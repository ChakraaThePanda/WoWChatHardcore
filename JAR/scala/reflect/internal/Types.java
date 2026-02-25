/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import java.util.Objects;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Option$;
import scala.PartialFunction;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Predef$any2stringadd$;
import scala.Product;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.Tuple5;
import scala.collection.AbstractIterable;
import scala.collection.AbstractTraversable;
import scala.collection.GenMap;
import scala.collection.GenSeq;
import scala.collection.GenSet;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.Iterable$;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.LinearSeqLike;
import scala.collection.LinearSeqOptimized;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Set;
import scala.collection.immutable.Set$;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.BitSet;
import scala.collection.mutable.HashSet;
import scala.collection.mutable.LinkedHashSet;
import scala.collection.mutable.LinkedHashSet$;
import scala.collection.mutable.ListBuffer;
import scala.collection.mutable.ListBuffer$;
import scala.collection.mutable.Map;
import scala.collection.mutable.Map$;
import scala.collection.mutable.WeakHashMap;
import scala.ref.WeakReference;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Mirrors;
import scala.reflect.api.Printers;
import scala.reflect.api.Symbols;
import scala.reflect.api.Types;
import scala.reflect.internal.AnnotationCheckers;
import scala.reflect.internal.AnnotationInfos;
import scala.reflect.internal.BaseTypeSeqs;
import scala.reflect.internal.Constants;
import scala.reflect.internal.Definitions;
import scala.reflect.internal.Definitions$DefinitionsClass$NothingClass$;
import scala.reflect.internal.Depth;
import scala.reflect.internal.Depth$;
import scala.reflect.internal.HasFlags;
import scala.reflect.internal.Kinds;
import scala.reflect.internal.Mirrors;
import scala.reflect.internal.Names;
import scala.reflect.internal.Reporting;
import scala.reflect.internal.Scopes;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Trees;
import scala.reflect.internal.TypeDebugging;
import scala.reflect.internal.Types$AnnotatedType$;
import scala.reflect.internal.Types$AntiPolyType$;
import scala.reflect.internal.Types$ArrayTypeRef$;
import scala.reflect.internal.Types$BoundedWildcardType$;
import scala.reflect.internal.Types$ClassInfoType$;
import scala.reflect.internal.Types$ClassInfoType$enterRefs$;
import scala.reflect.internal.Types$CompoundType$;
import scala.reflect.internal.Types$ConstantType$;
import scala.reflect.internal.Types$ErasedValueType$;
import scala.reflect.internal.Types$ErrorType$;
import scala.reflect.internal.Types$ExistentialType$;
import scala.reflect.internal.Types$GenPolyType$;
import scala.reflect.internal.Types$HasTypeMember$;
import scala.reflect.internal.Types$ImportType$;
import scala.reflect.internal.Types$MethodType$;
import scala.reflect.internal.Types$NamedType$;
import scala.reflect.internal.Types$NoPrefix$;
import scala.reflect.internal.Types$NoType$;
import scala.reflect.internal.Types$NullaryMethodType$;
import scala.reflect.internal.Types$OverloadedType$;
import scala.reflect.internal.Types$PolyType$;
import scala.reflect.internal.Types$RecoverableCyclicReference$;
import scala.reflect.internal.Types$RefinedType$;
import scala.reflect.internal.Types$RepeatedType$;
import scala.reflect.internal.Types$SingleType$;
import scala.reflect.internal.Types$StaticallyAnnotatedType$;
import scala.reflect.internal.Types$SuperType$;
import scala.reflect.internal.Types$ThisType$;
import scala.reflect.internal.Types$TypeBounds$;
import scala.reflect.internal.Types$TypeRef$;
import scala.reflect.internal.Types$TypeVar$;
import scala.reflect.internal.Types$UnmappableTree$;
import scala.reflect.internal.Types$WildcardType$;
import scala.reflect.internal.Types$substTypeMapCache$;
import scala.reflect.internal.Types$unwrapToClass$;
import scala.reflect.internal.Types$unwrapToStableClass$;
import scala.reflect.internal.Types$unwrapWrapperTypes$;
import scala.reflect.internal.TypesStats;
import scala.reflect.internal.Variance;
import scala.reflect.internal.Variance$;
import scala.reflect.internal.settings.MutableSettings;
import scala.reflect.internal.settings.MutableSettings$;
import scala.reflect.internal.tpe.CommonOwners;
import scala.reflect.internal.tpe.FindMembers;
import scala.reflect.internal.tpe.GlbLubs;
import scala.reflect.internal.tpe.TypeComparers;
import scala.reflect.internal.tpe.TypeConstraints;
import scala.reflect.internal.tpe.TypeMaps;
import scala.reflect.internal.tpe.TypeToStrings;
import scala.reflect.internal.util.Collections;
import scala.reflect.internal.util.Position;
import scala.reflect.internal.util.ReusableInstance;
import scala.reflect.internal.util.Statistics;
import scala.reflect.internal.util.StatisticsStatics;
import scala.reflect.internal.util.ThreeValues$;
import scala.reflect.internal.util.WeakHashSet;
import scala.reflect.internal.util.WeakHashSet$;
import scala.runtime.BooleanRef;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.IntRef;
import scala.runtime.LambdaDeserialize;
import scala.runtime.Nothing$;
import scala.runtime.Null$;
import scala.runtime.ObjectRef;
import scala.runtime.ScalaRunTime$;
import scala.runtime.java8.JFunction0$mcZ$sp;
import scala.sys.package$;
import scala.util.control.ControlThrowable;
import scala.util.control.NoStackTrace;
import scala.util.hashing.MurmurHash3$;

@ScalaSignature(bytes="\u0006\u0001\u00056d\u0001DFH\u0017#\u0003\n1!\u0001\f \u0006.\u0004bBFx\u0001\u0011\u00051\u0012\u001f\u0005\n\u0017s\u0004\u0001\u0019!C\u0005\u0017wD\u0011\u0002d\u0001\u0001\u0001\u0004%I\u0001$\u0002\t\u00131-\u0001A1A\u0005\u000e15\u0001\"\u0003G\u0016\u0001\t\u0007IQBF~\u0011%ai\u0003\u0001b\u0001\n\u001bYYpB\u0004\r0\u0001AI\u0001$\r\u0007\u000f1M\u0002\u0001#\u0003\r6!9Ar\u0007\u0005\u0005\u00021e\u0002\u0002\u0003G\u001e\u0011\u0001\u0006K\u0001$\u0010\t\u000f1\r\u0003\u0002\"\u0001\rF!I\u0001s\u0006\u0001A\u0002\u0013%QR\u0004\u0005\n!c\u0001\u0001\u0019!C\u0005!gAq\u0001e\u000e\u0001\t\u0003ii\u0002C\u0004\u0011:\u0001!\t\u0001e\u000f\t\u0013A\u0005\u0003A1A\u0005\nA\r\u0003b\u0002I/\u0001\u0011\u0005\u00013\t\u0004\n!?\u0002\u0001\u0013aA\u0001!CBqac<\u0013\t\u0003Y\t\u0010C\u0004\rtJ1\t\u0001$'\t\u000f1\u0005'\u0003\"\u0011\f|\"9A2\u0019\n\u0005B-m\bb\u0002H\u0005%\u0011\u0005C\u0012\u0014\u0005\b\u0019'\u0014B\u0011IF~\u0011\u001da)N\u0005C!\u0017wDqAd\u0007\u0013\t\u0003ji\u0002C\u0004\u000f\u001eI!\t\u0005$-\t\u000f9}!\u0003\"\u0011\u000eV!9a\u0012\u0005\n\u0005B1U\u0005b\u0002Gu%\u0011\u0005C2\u001e\u0005\b\u0019_\u0014B\u0011\tGv\u0011\u001dq\u0019C\u0005C!\u001b+Bq!d\u0016\u0013\t\u0003bi\u0001C\u0004\rnJ!\t\u0005d;\t\u000f1E(\u0003\"\u0011\rl\"9AR\u001f\n\u0005B1e\u0005b\u0002G}%\u0011\u0005C\u0012\u0014\u0005\b\u0019{\u0014B\u0011\tG\u0000\u0011\u001diYJ\u0005C!\u00193Cq!$'\u0013\t\u0003bI\nC\u0004\u000e.I!\t\u0005$&\t\u000f9\u0015!\u0003\"\u0011\r\u001a\"9Qr\u0006\n\u0005B1\u001d\u0005bBG\u0019%\u0011\u0005\u0003S\r\u0005\b\u001bs\u0011B\u0011IG\u001e\u0011\u001di9E\u0005C!\u001b\u0013Bq!d\u0015\u0013\t\u0003j)FB\u0005\u0011j\u0001\u0001\n1!\u0001\u0011l!91r\u001e\u0019\u0005\u0002-E\bb\u0002I8a\u0011E\u0001\u0013\u000f\u0005\b!o\u0002d\u0011\u0003I=\u0011\u001da)\u0010\rC!\u00193Cq\u0001d?1\t\u0003bI\nC\u0004\rxB\"\t\u0005$'\t\u000f9=\u0001\u0007\"\u0011\r\u001a\"9ar\u0002\u0019\u0005BAu\u0004b\u0002H\u000ea\u0011\u0005SR\u0004\u0005\b\u001d;\u0001D\u0011\tGY\u0011\u001dqy\u0002\rC!\u001b+BqA$\t1\t\u0003b)\nC\u0004\u000f\fA\"\t\u0005$&\t\u000f9\u001d\u0002\u0007\"\u0011\u0011\u0002\"9a\u0012\u0007\u0019\u0005BA\u001d\u0005b\u0002H\u001fa\u0011\u0005C\u0012\u0014\u0005\b\u001d\u007f\u0001D\u0011\tGM\u0011\u001dq\t\u0005\rC!\u00193Cqad/1\t\u0003\u0002j\tC\u0004\u0010BB\"\t\u0005%%\t\u000f=M\u0007\u0007\"\u0011\u000e.\"9A\u0012\u001c\u0019\u0005B-m\bb\u0002Goa\u0011\u0005\u0003S\u0013\u0005\b\u001fK\u0004D\u0011\tIM\u0011\u001d\u0001J\u0003\rC!!;Cq\u0001e\u00061\t\u0003bIjB\u0004\u0011\"\u0002A\t\te)\u0007\u000fA\u0015\u0006\u0001#!\u0011(\"9Ar\u0007'\u0005\u0002Ae\u0006bBHk\u0019\u0012\u0005\u00033\u0018\u0005\b!{cE\u0011\tI`\u0011%iY\u000eTA\u0001\n\u0003jY\rC\u0005\u000e^2\u000b\t\u0011\"\u0001\u000e\u001e!IQr\u001c'\u0002\u0002\u0013\u0005\u0001S\u0019\u0005\n\u001bWd\u0015\u0011!C!\u001b[D\u0011\"d>M\u0003\u0003%\t\u0001%3\u0007\u00131\u001d\u0004!!\u0001\rj1}\u0003b\u0002G\u001c+\u0012\u0005A\u0012\u000f\u0005\b\u0019g*F\u0011\u0001G;\u0011\u001da))\u0016C\u0001\u0019\u000fCq\u0001d%V\t\u0003a)\nC\u0004\r\u0018V#\t\u0001$'\t\u000f1mU\u000b\"\u0001\r\u001e\"9A2U+\u0005\u00021\u0015\u0006b\u0002GV+\u0012\u000512 \u0005\b\u0019[+F\u0011\u0001GM\u0011\u001day+\u0016C\u0001\u0019c3q\u0001$\u0019\u0001\u0003\u0003a\u0019\u0007C\u0004\r8\u0001$\t\u0001d0\t\u000f1\u0005\u0007\r\"\u0001\f|\"9A2\u00191\u0005\u0002-m\bb\u0002GcA\u0012\u000512 \u0005\b\u0019\u000f\u0004GQAF~\u0011\u001daI\r\u0019C\u0003\u0017wDq\u0001d3a\t\u0003YY\u0010C\u0004\rN\u0002$\tac?\t\u000f1=\u0007\r\"\u0001\f|\"9A\u0012\u001b1\u0005\u0002-m\bb\u0002GjA\u0012\u000512 \u0005\b\u0019+\u0004G\u0011AF~\u0011\u001da9\u000e\u0019C\u0001\u0017wDq\u0001$7a\t\u0003YY\u0010C\u0004\r\\\u0002$\tac?\t\u000f1u\u0007\r\"\u0001\r`\"9AR\u001d1\u0005\u00021\u001d\bb\u0002GuA\u0012\u0005A2\u001e\u0005\b\u0019[\u0004G\u0011\u0001Gv\u0011\u001day\u000f\u0019C\u0001\u0019WDq\u0001$=a\t\u0003aY\u000fC\u0004\rt\u0002$\t\u0001$'\t\u000f1U\b\r\"\u0001\r\u001a\"9Ar\u001f1\u0005\u00021e\u0005b\u0002G}A\u0012\u0005A\u0012\u0014\u0005\b\u0019w\u0004G\u0011\u0001GM\u0011\u001dai\u0010\u0019C\u0001\u0019\u007fDq!d'a\t\u0003aI\nC\u0004\u000e\u001a\u0002$\t\u0001$'\t\u000f55\u0002\r\"\u0001\r\u0016\"9a2\u00011\u0005\u00021e\u0005b\u0002H\u0003A\u0012\u0005A\u0012\u0014\u0005\b\u001d\u000f\u0001G\u0011\u0001GK\u0011\u001dqI\u0001\u0019C\u0001\u00193CqAd\u0003a\t\u0003a)\nC\u0004\u000f\u000e\u0001$\t\u0002$&\t\u000f9=\u0001\r\"\u0001\r\u001a\"9ar\u00021\u0005\u00029E\u0001b\u0002H\fA\u0012\u0005A\u0012\u0014\u0005\b\u001d3\u0001GQ\u0001GM\u0011\u001dqY\u0002\u0019C\u0001\u001b;AqA$\ba\t\u0003a\t\fC\u0004\u000f \u0001$\t!$\u0016\t\u000f9\u0005\u0002\r\"\u0001\r\u0016\"9a2\u00051\u0005\u00025U\u0003bBG,A\u0012\u0005AR\u0002\u0005\b\u001dO\u0001G\u0011\u0001H\u0015\u0011\u001dq\t\u0004\u0019C\u0001\u001dgAqA$\ra\t\u0003aI\nC\u0004\u000f>\u0001$\t\u0001$'\t\u000f9}\u0002\r\"\u0001\r\u001a\"9a\u0012\t1\u0005\u00021e\u0005b\u0002H\"A\u0012\u0005A\u0012\u0014\u0005\b\u001d\u000b\u0002G\u0011\u0001GK\u0011\u001dq9\u0005\u0019C\u0001\u00193Cq!d\fa\t\u0003a9\tC\u0004\u000fJ\u0001$\tAd\u0013\t\u000f9=\u0003\r\"\u0001\u000eV!9a\u0012\u000b1\u0005\u00029M\u0003b\u0002H,A\u0012\u0005Ar\u0011\u0005\b\u001d3\u0002G\u0011\u0001GD\u0011\u001dqY\u0006\u0019C\u0001\u001d;BqA$\u001ba\t\u0003a9\tC\u0004\u000fl\u0001$\t\u0001d\"\t\u000f95\u0004\r\"\u0001\u000fp!9a2\u000f1\u0005\u00029U\u0004b\u0002H=A\u0012\u0005a2\u0010\u0005\b\u001d\u007f\u0002G\u0011\u0001Gv\u0011\u001dq\t\t\u0019C\u0001\u001d\u0007CqA$#a\t\u0003qY\tC\u0004\u000f\u0010\u0002$\tA$%\t\u000f9m\u0005\r\"\u0001\u000f\u001e\"9Q\u0012\u00071\u0005\u00029\r\u0006b\u0002HTA\u0012\u0005a\u0012\u0016\u0005\b\u001dc\u0003G\u0011\u0001HZ\u0011\u001dq9\f\u0019C\u0001\u001dsCqA$0a\t\u0003qy\fC\u0004\u000fD\u0002$\tA$2\t\u000f9-\u0007\r\"\u0001\u000fN\"9a2\u001b1\u0005\u00029U\u0007b\u0002HjA\u0012\u0005a2\u001c\u0005\b\u001dC\u0004G\u0011\u0001Hr\u0011\u001dq\t\u0010\u0019C\u0001\u001dg4aA$?a\u00019m\bbCH\u0002\u0003S\u0012\t\u0011)A\u0005\u001f\u000bA\u0001\u0002d\u000e\u0002j\u0011\u0005qr\u0001\u0005\t\u001f\u0017\tI\u0007\"\u0001\u0010\u000e!AqrEA5\t\u0003yI\u0003C\u0004\u0010<\u0001$)a$\u0010\t\u000f=E\u0003\r\"\u0001\u0010T!9q2\u00021\u0005\u0002=u\u0003bBH2A\u0012\u0005qR\r\u0005\b\u001fO\u0001G\u0011AH=\u0011\u001dyy\b\u0019C\u0001\u001f\u0003Cqa$\"a\t\u0003y9\tC\u0004\u0010\f\u0002$\ta$$\t\u000f=E\u0005\r\"\u0001\u0010\u0014\"9qr\u00131\u0005\u0002=e\u0005bBHOA\u0012\u0005qr\u0014\u0005\b\u001fG\u0003G\u0011AHS\u0011\u001dyI\u000b\u0019C\u0001\u001fWCqad,a\t\u0003y\t\fC\u0004\u000e:\u0001$\t!d\u000f\t\u000f5\u001d\u0003\r\"\u0001\u000eJ!9Q2\u000b1\u0005\u00025U\u0003bBH[A\u0012\u0005qr\u0017\u0005\b\u001fw\u0003G\u0011AH_\u0011\u001dy\t\r\u0019C\u0001\u001f\u0007Dqad2a\t#iY\rC\u0004\u0010J\u0002$\t\"d3\t\u000f=-\u0007\r\"\u0001\u0010N\"9q2\u001b1\u0005\u000255\u0006bBHkA\u0012\u0015sr\u001b\u0005\b\u001bW\u0003G\u0011AGW\u0011\u001dyI\u000e\u0019C\u0001\u001b[Cqad7a\t\u0003ii\u000bC\u0004\u0010^\u0002$\t!$,\t\u000f=}\u0007\r\"\u0002\f|\"9q\u0012\u001d1\u0005\u0006-m\bbBHrA\u0012\u000512 \u0005\b\u001fK\u0004G\u0011AHt\u0011\u001dyY\u000f\u0019C\u0005\u001f[Dqad=a\t\u0003y)\u0010C\u0004\u0010|\u0002$\ta$@\t\u000fA%\u0001\r\"\u0001\u000eV!9\u00013\u00021\u0005\u0002A5\u0001b\u0002I\fA\u0012\u0005A\u0012\u0014\u0005\b!3\u0001G\u0011\u0001I\u000e\u0011\u001d\u0001\n\u0003\u0019C\u0001!GAq\u0001%\u000ba\t\u0003\u0001Z\u0003C\u0004\u000eJ\u0002$\t!$,\u0007\u000f5=\u0001!!\u0001\u000e\u0012!AArGAe\t\u0003iI\u0002\u0003\u0006\u000e\u001c\u0005%'\u0019!C#\u001b;A\u0011\"$\n\u0002J\u0002\u0006i!d\b\t\u00115\u001d\u0012\u0011\u001aC\t\u001b;1q!$\u0003\u0001\u0003\u0003iY\u0001\u0003\u0005\r8\u0005MG\u0011AG\u0015\u0011!iY#a5\u0007\u00021e\u0005\u0002CG\u0017\u0003'$\t\u0005$&\t\u00115=\u00121\u001bC!\u0019\u000fC\u0001\"$\r\u0002T\u0012\u0005S2\u0007\u0005\t\u001bs\t\u0019\u000e\"\u0011\u000e<!AQrIAj\t\u0003jI\u0005\u0003\u0005\u000eT\u0005MG\u0011IG+\u0011!i9&a5\u0005B5eca\u0002Ig\u0001\u0005\u0005\u0001s\u001a\u0005\t\u0019o\t9\u000f\"\u0001\u0011X\"AQ2FAt\t\u0003aI\n\u0003\u0005\rB\u0006\u001dH\u0011IF~\u0011!a\u0019-a:\u0005B-m\b\u0002CGV\u0003O$\t%$,\t\u00115]\u0013q\u001dC!\u001b3:q\u0001%8\u0001\u0011\u0003\u0003zNB\u0004\u0011b\u0002A\t\te9\t\u00111]\u0012q\u001fC\u0001!KD\u0001\u0002d5\u0002x\u0012\u000532 \u0005\t\u001b_\t9\u0010\"\u0011\r\b\"Aq2`A|\t\u0003\u0002:\u000f\u0003\u0005\u000e2\u0005]H\u0011\tIy\u0011!iY+a>\u0005B55\u0006\u0002\u0003G~\u0003o$\t\u0005$'\t\u00115%\u0017q\u001fC!\u001b\u0017D!\"d7\u0002x\u0006\u0005I\u0011IGf\u0011)ii.a>\u0002\u0002\u0013\u0005QR\u0004\u0005\u000b\u001b?\f90!A\u0005\u0002AU\bBCGv\u0003o\f\t\u0011\"\u0011\u000en\"QQr_A|\u0003\u0003%\t\u0001%?\t\u00155m\u0011q_A\u0001\n\u0003\u0002jpB\u0004\u0011\u0000\u0002A\t)%\u0001\u0007\u000fE\r\u0001\u0001#!\u0012\u0006!AAr\u0007B\f\t\u0003\t:\u0001\u0003\u0005\rR\n]A\u0011IF~\u0011!iYKa\u0006\u0005B55\u0006\u0002CGe\u0005/!\t%d3\t\u00155m'qCA\u0001\n\u0003jY\r\u0003\u0006\u000e^\n]\u0011\u0011!C\u0001\u001b;A!\"d8\u0003\u0018\u0005\u0005I\u0011AI\u0005\u0011)iYOa\u0006\u0002\u0002\u0013\u0005SR\u001e\u0005\u000b\u001bo\u00149\"!A\u0005\u0002E5\u0001BCG\u000e\u0005/\t\t\u0011\"\u0011\u0011~\u001a1\u0011\u0013\u0003\u0001A#'A1\u0002$@\u0003.\tU\r\u0011\"\u0011\r\u0000\"Y\u00113\u0004B\u0017\u0005#\u0005\u000b\u0011BG\u0001\u0011!a9D!\f\u0005\u0002Eu\u0001\u0002CGM\u0005[!\t\u0005$'\t\u00115m%Q\u0006C!\u00193C\u0001\u0002$5\u0003.\u0011\u000532 \u0005\t\u001bW\u0013i\u0003\"\u0011\u000e.\"AQ\u0012\u001aB\u0017\t\u0003jY\r\u0003\u0006\u0012$\t5\u0012\u0011!C\u0001#KA!\"%\u000b\u0003.E\u0005I\u0011AI\u0016\u0011)iYN!\f\u0002\u0002\u0013\u0005S2\u001a\u0005\u000b\u001b;\u0014i#!A\u0005\u00025u\u0001BCGp\u0005[\t\t\u0011\"\u0001\u0012B!QQ2\u001eB\u0017\u0003\u0003%\t%$<\t\u00155](QFA\u0001\n\u0003\t*\u0005\u0003\u0006\u000e\u001c\t5\u0012\u0011!C!!{D!\"$@\u0003.\u0005\u0005I\u0011II%\u000f\u001d\tj\u0005\u0001E\u0001#\u001f2q!%\u0005\u0001\u0011\u0003\t\n\u0006\u0003\u0005\r8\tMC\u0011AI-\u0011)a\u0019Ea\u0015\u0002\u0002\u0013\u0005\u00153\f\u0005\u000b#?\u0012\u0019&!A\u0005\u0002F\u0005taBI5\u0001!\u0005\u00153\u000e\u0004\b#[\u0002\u0001\u0012QI8\u0011!a9D!\u0018\u0005\u0002EE\u0004\u0002\u0003Ga\u0005;\"\tec?\t\u00115-&Q\fC!\u001b[C\u0001\"$3\u0003^\u0011\u0005S2\u001a\u0005\u000b\u001b7\u0014i&!A\u0005B5-\u0007BCGo\u0005;\n\t\u0011\"\u0001\u000e\u001e!QQr\u001cB/\u0003\u0003%\t!e\u001d\t\u00155-(QLA\u0001\n\u0003ji\u000f\u0003\u0006\u000ex\nu\u0013\u0011!C\u0001#oB!\"d\u0007\u0003^\u0005\u0005I\u0011\tI\u007f\u000f\u001d\tZ\b\u0001EA#{2q!e \u0001\u0011\u0003\u000b\n\t\u0003\u0005\r8\tUD\u0011AIB\u0011!a\tM!\u001e\u0005B-m\b\u0002CHj\u0005k\"\t%d3\t\u00115-&Q\u000fC!\u001b[C\u0001\"$3\u0003v\u0011\u0005S2\u001a\u0005\u000b\u001b7\u0014)(!A\u0005B5-\u0007BCGo\u0005k\n\t\u0011\"\u0001\u000e\u001e!QQr\u001cB;\u0003\u0003%\t!%\"\t\u00155-(QOA\u0001\n\u0003ji\u000f\u0003\u0006\u000ex\nU\u0014\u0011!C\u0001#\u0013C!\"d\u0007\u0003v\u0005\u0005I\u0011\tI\u007f\r\u001d\tj\tAAA#\u001fC1\u0002d9\u0003\u000e\nU\r\u0011\"\u0001\rl\"Y\u0011s\u0013BG\u0005#\u0005\u000b\u0011\u0002G\u0010\u0011!a9D!$\u0005\u0002Ee\u0005\u0002\u0003Ga\u0005\u001b#\tec?\t\u001115(Q\u0012C!\u0019WD\u0001\u0002d=\u0003\u000e\u0012\u0005C\u0012\u0014\u0005\t\u0019\u0007\u0014i\t\"\u0011\f|\"Aq2\u001bBG\t\u0003ji\u000b\u0003\u0005\u000e,\n5E\u0011IGW\u0011!aYP!$\u0005B1e\u0005\u0002CGe\u0005\u001b#\t%d3\t\u00155m'QRA\u0001\n\u0003jY\r\u0003\u0006\u000e^\n5\u0015\u0011!C\u0001\u001b;A!\"d8\u0003\u000e\u0006\u0005I\u0011AIP\u0011)iYO!$\u0002\u0002\u0013\u0005SR\u001e\u0005\u000b\u001bo\u0014i)!A\u0005\u0002E\r\u0006BCG\u007f\u0005\u001b\u000b\t\u0011\"\u0011\u0012(\u001e9\u00113\u0016\u0001\t\u0002E5faBIG\u0001!\u0005\u0011s\u0016\u0005\t\u0019o\u0011\u0019\f\"\u0001\u00128\"AA2\tBZ\t\u0003\tJ\f\u0003\u0006\u0012`\tM\u0016\u0011!CA#{3a!e1\u0001\u0005E\u0015\u0007\"\u0004Gr\u0005w\u0013\t\u0011)A\u0005\u0019?\u0011y\t\u0003\u0005\r8\tmF\u0011AId\r\u001d\tj\rAAA#\u001fD1B$,\u0003B\nU\r\u0011\"\u0001\r\u001a\"Y\u0011s\u001bBa\u0005#\u0005\u000b\u0011\u0002G0\u0011-a\u0019O!1\u0003\u0016\u0004%\t\u0001d;\t\u0017E]%\u0011\u0019B\tB\u0003%Ar\u0004\u0005\t\u0019o\u0011\t\r\"\u0001\u0012Z\"Q\u0011\u0013\u001dBa\u0001\u0004%I!e9\t\u0015E](\u0011\u0019a\u0001\n\u0013\tJ\u0010C\u0005\u0012~\n\u0005\u0007\u0015)\u0003\u0012f\"AA\u0012\u0019Ba\t\u0003ZY\u0010\u0003\u0005\u0010d\n\u0005G\u0011IF~\u00111\tzP!1A\u0002\u0013\u00051R\u0013GM\u00111\u0011\nA!1A\u0002\u0013\u00051R\u0013J\u0002\u0011%\u0011:A!1!B\u0013ay\u0006\u0003\u0007\u0013\u0012\t\u0005\u0007\u0019!C\u0001\u0017+ki\u0002\u0003\u0007\u0013\u0014\t\u0005\u0007\u0019!C\u0001\u0017+\u0013*\u0002C\u0005\u0013\u001a\t\u0005\u0007\u0015)\u0003\u000e !AA2\u001fBa\t\u0003bI\n\u0003\u0005\rN\n\u0005G\u0011IF~\u0011!aYP!1\u0005B1e\u0005\u0002\u0003Gu\u0005\u0003$\t\u0005d;\t\u00119\u0015!\u0011\u0019C!\u00193C\u0001bd5\u0003B\u0012\u0005SR\u0016\u0005\t\u001b\u0013\u0014\t\r\"\u0011\u000eL\"QQ2\u001cBa\u0003\u0003%\t%d3\t\u00155u'\u0011YA\u0001\n\u0003ii\u0002\u0003\u0006\u000e`\n\u0005\u0017\u0011!C\u0001%;A!\"d;\u0003B\u0006\u0005I\u0011IGw\u0011)i9P!1\u0002\u0002\u0013\u0005!\u0013\u0005\u0005\u000b\u001b{\u0014\t-!A\u0005BI\u0015\u0002\"\u0004J\u0015\u0005\u0003\u0014\t\u0011!A\u0005\u0002\u0001Y\tpB\u0004\u0013,\u0001A\tA%\f\u0007\u000fE5\u0007\u0001#\u0001\u00130!AArGB\u0001\t\u0003\u0011:\u0004\u0003\u0005\rD\r\u0005A\u0011\u0001J\u001d\u0011)\tzf!\u0001\u0002\u0002\u0013\u0005%s\b\u0004\u0007%\u0017\u0002!A%\u0014\t\u001b956\u0011\u0002B\u0001B\u0003%Ar\fBb\u00115a\u0019o!\u0003\u0003\u0002\u0003\u0006I\u0001d\b\u0003H\"AArGB\u0005\t\u0003\u0011z\u0005C\u0004\u0013X\u0001!\tB%\u0017\u0007\u000fIu\u0003!!!\u0013`!Y!sMB\n\u0005+\u0007I\u0011\u0001GM\u0011-\u0011Jga\u0005\u0003\u0012\u0003\u0006I\u0001d\u0018\t\u0017I-41\u0003BK\u0002\u0013\u0005A\u0012\u0014\u0005\f%[\u001a\u0019B!E!\u0002\u0013ay\u0006\u0003\u0005\r8\rMA\u0011\u0001J8\u0011)\t\noa\u0005A\u0002\u0013%\u00113\u001d\u0005\u000b#o\u001c\u0019\u00021A\u0005\nI]\u0004\"CI\u007f\u0007'\u0001\u000b\u0015BIs\u0011!a\tma\u0005\u0005B-m\b\u0002\u0003Gw\u0007'!\t\u0005d;\t\u00111M81\u0003C!\u00193C\u0001B$\u0002\u0004\u0014\u0011\u0005C\u0012\u0014\u0005\t\u001f'\u001c\u0019\u0002\"\u0011\u000eL\"AA2`B\n\t\u0003bI\n\u0003\u0005\u000eJ\u000eMA\u0011IGf\u0011)iYna\u0005\u0002\u0002\u0013\u0005S2\u001a\u0005\u000b\u001b;\u001c\u0019\"!A\u0005\u00025u\u0001BCGp\u0007'\t\t\u0011\"\u0001\u0013|!QQ2^B\n\u0003\u0003%\t%$<\t\u00155]81CA\u0001\n\u0003\u0011z\b\u0003\u0006\u000e~\u000eM\u0011\u0011!C!%\u0007;qAe\"\u0001\u0011\u0003\u0011JIB\u0004\u0013^\u0001A\tAe#\t\u00111]2\u0011\tC\u0001%'C\u0001\u0002d\u0011\u0004B\u0011\u0005!S\u0013\u0005\u000b#?\u001a\t%!A\u0005\u0002J}eA\u0002JT\u0001\t\u0011J\u000bC\u0007\u0013\u001a\u000e%#\u0011!Q\u0001\n1}3Q\u0003\u0005\u000e%;\u001bIE!A!\u0002\u0013ayf!\u0007\t\u00111]2\u0011\nC\u0001%W3q!d\u0001\u0001\u0003\u0003k)\u0001C\u0006\u000e\f\u000eE#Q3A\u0005\u00021e\u0005bCGG\u0007#\u0012\t\u0012)A\u0005\u0019?B1\"d$\u0004R\tU\r\u0011\"\u0001\r\u001a\"YQ\u0012SB)\u0005#\u0005\u000b\u0011\u0002G0\u0011!a9d!\u0015\u0005\u00025M\u0005\u0002CG\u0016\u0007#\"\t\u0001$'\t\u00111\u00057\u0011\u000bC!\u0017wD\u0001\u0002$@\u0004R\u0011\u0005Cr \u0005\t\u001b3\u001b\t\u0006\"\u0011\r\u001a\"AQ2TB)\t\u0003bI\n\u0003\u0005\u000e\u001e\u000eEC\u0011AGP\u0011!i)k!\u0015\u0005\u0002-m\b\u0002CGT\u0007#\"\tac?\t\u00115%6\u0011\u000bC\u0001\u0017wD\u0001\"d+\u0004R\u0011\u0005SR\u0016\u0005\u000b\u001bk\u001b\t\u0006\"\u0001\f\u00126]\u0006BCGb\u0007#\"\ta#%\u000eF\"AQ\u0012ZB)\t\u0003jY\r\u0003\u0006\u000e\\\u000eE\u0013\u0011!C!\u001b\u0017D!\"$8\u0004R\u0005\u0005I\u0011AG\u000f\u0011)iyn!\u0015\u0002\u0002\u0013\u0005Q\u0012\u001d\u0005\u000b\u001bW\u001c\t&!A\u0005B55\bBCG|\u0007#\n\t\u0011\"\u0001\u000ez\"QQR`B)\u0003\u0003%\t%d@\b\u000fIM\u0006\u0001#\u0001\u00136\u001a9Q2\u0001\u0001\t\u0002I]\u0006\u0002\u0003G\u001c\u0007\u000b#\tAe0\t\u0011I\u00057Q\u0011C\u0001\u0019\u007fD\u0001Be1\u0004\u0006\u0012\u0005!S\u0019\u0005\t%\u0013\u001c)\t\"\u0001\u0013L\"AA2IBC\t\u0003\u0011z\r\u0003\u0005\u0013V\u000e\u0015E\u0011\u0001Jl\u0011!\u0011Zn!\"\u0005\u0002Iu\u0007BCI0\u0007\u000b\u000b\t\u0011\"!\u0013b\u001a1!S\u001d\u0001\u0003%ODQ\"d#\u0004\u0018\n\u0005\t\u0015!\u0003\r`\rM\u0003\"DGH\u0007/\u0013\t\u0011)A\u0005\u0019?\u001a9\u0006\u0003\u0005\r8\r]E\u0011\u0001Ju\u000f\u001d\u0011\n\u0010\u0001E\u0001%g4qA%>\u0001\u0011\u0003\u0011:\u0010\u0003\u0005\r8\r\u0005F\u0011\u0001J}\u0011!\tzf!)\u0005\u0002Imha\u0002J{\u0001\u0005\u00051\u0013\u0002\u0005\t\u0019o\u00199\u000b\"\u0001\u0014\u0012!q1SCBT\u0001\u0004\u0005\r\u0011\"\u0001\f\u00166m\u0002BDJ\f\u0007O\u0003\r\u00111A\u0005\u0002-U5\u0013\u0004\u0005\r';\u00199\u000b1A\u0001B\u0003&QR\b\u0005\r'?\u00199\u000b1A\u0005\u0002-UUR\u0004\u0005\r'C\u00199\u000b1A\u0005\u0002-U53\u0005\u0005\n'O\u00199\u000b)Q\u0005\u001b?Aab%\u000b\u0004(\u0002\u0007\t\u0019!C\u0001\u0017+k)\u0006\u0003\b\u0014,\r\u001d\u0006\u0019!a\u0001\n\u0003Y)j%\f\t\u0019ME2q\u0015a\u0001\u0002\u0003\u0006K\u0001d\u0013\t\u0019MM2q\u0015a\u0001\n\u0003Y)*$\b\t\u0019MU2q\u0015a\u0001\n\u0003Y)je\u000e\t\u0013Mm2q\u0015Q!\n5}\u0001\u0002CG\u001d\u0007O#\t%d\u000f\t\u00115\u001d3q\u0015C!\u001b\u0013B\u0001\"d\u0015\u0004(\u0012\u0005SR\u000b\u0005\t'{\u00199\u000b\"\u0001\u0014@!AQ\u0012GBT\t\u0003\u001a:\u0006\u0003\u0005\r|\u000e\u001dF\u0011\tGM\u0011!aYma*\u0005B-m\b\u0002CJ.\u0007O#\tbc?\t\u0011Mu3q\u0015C\t\u0019\u000fC\u0001be\u0018\u0004(\u0012EQR\u0016\u0005\t\u001bW\u001b9\u000b\"\u0011\u000eL\"i1\u0013MBT\u0005\u0003\u0005\t\u0011\"\u0001\u0001\u0017cDqae\u0019\u0001\t#\u0019*\u0007C\u0004\u0014j\u0001!\tbe\u001b\t\u000fM=\u0004\u0001\"\u0005\u0014r\u001911S\u000f\u0001A'oB1\"$\f\u0004b\nU\r\u0011\"\u0011\r\u0016\"Y1sPBq\u0005#\u0005\u000b\u0011\u0002G/\u0011-iyc!9\u0003\u0016\u0004%\t\u0005d\"\t\u0017M\u00055\u0011\u001dB\tB\u0003%A\u0012\u0012\u0005\t\u0019o\u0019\t\u000f\"\u0001\u0014\u0004\"AA2YBq\t\u0003ZY\u0010\u0003\u0005\u000f$\r\u0005H\u0011IG+\u0011!qIa!9\u0005B1e\u0005\u0002\u0003H\u001f\u0007C$)\u0005$'\t\u0019M-5\u0011\u001da\u0001\u0002\u0004%I\u0001$'\t\u0019M55\u0011\u001da\u0001\u0002\u0004%Iae$\t\u0019MM5\u0011\u001da\u0001\u0002\u0003\u0006K\u0001d\u0018\t\u0011MU5\u0011\u001dC\u0005\u00193C\u0001Bd\u0010\u0004b\u0012\u0015C\u0012\u0014\u0005\t\u001b\u0013\u001c\t\u000f\"\u0011\u000eL\"Q\u00113EBq\u0003\u0003%\tae&\t\u0015E%2\u0011]I\u0001\n\u0003\u0019j\n\u0003\u0006\u0014\"\u000e\u0005\u0018\u0013!C\u0001'GC!\"d7\u0004b\u0006\u0005I\u0011IGf\u0011)iin!9\u0002\u0002\u0013\u0005QR\u0004\u0005\u000b\u001b?\u001c\t/!A\u0005\u0002M\u001d\u0006BCGv\u0007C\f\t\u0011\"\u0011\u000en\"QQr_Bq\u0003\u0003%\tae+\t\u00155m1\u0011]A\u0001\n\u0003\u0002j\u0010\u0003\u0006\u000e~\u000e\u0005\u0018\u0011!C!'_;qae-\u0001\u0011\u0003\u0019*LB\u0004\u0014v\u0001A\tae.\t\u00111]Bq\u0003C\u0001'\u007fC\u0001\u0002d\u0011\u0005\u0018\u0011\u00051\u0013\u0019\u0005\u000b\u0019\u0007\"9\"!A\u0005\u0002N%\u0007BCI0\t/\t\t\u0011\"!\u0014P\u001a11s\u001b\u0001\u0003'3DQ\"$\f\u0005\"\t\u0005\t\u0015!\u0003\r^\r\r\b\"DG\u0018\tC\u0011\t\u0011)A\u0005\u0019\u0013\u001b9\u000fC\u0006\u000e8\u0011\u0005\"\u0011!Q\u0001\n1}\u0001\u0002\u0003G\u001c\tC!\tae7\t\u001115H\u0011\u0005C!\u0019WDqa%:\u0001\t\u0003\u0019:O\u0002\u0004\u0014n\u0002\u00015s\u001e\u0005\f\u001b[!yC!f\u0001\n\u0003b)\nC\u0006\u0014\u0000\u0011=\"\u0011#Q\u0001\n1u\u0003bCG\u0018\t_\u0011)\u001a!C!\u0019\u000fC1b%!\u00050\tE\t\u0015!\u0003\r\n\"YAR\u001eC\u0018\u0005+\u0007I\u0011\tGv\u0011-\u0019:\u0010b\f\u0003\u0012\u0003\u0006I\u0001d\b\t\u00111]Bq\u0006C\u0001'sD!\u0002&\u0001\u00050\t\u0007IQ\u0002K\u0002\u0011%!J\u0001b\f!\u0002\u001b!*\u0001\u0003\u0006\u0015\f\u0011=\"\u0019!C\u0007)\u001bA\u0011\u0002f\u0005\u00050\u0001\u0006i\u0001f\u0004\t\u0015QUAq\u0006b\u0001\n\u001b!\u001a\u0001C\u0005\u0015\u0018\u0011=\u0002\u0015!\u0004\u0015\u0006!QA\u0013\u0004C\u0018\u0005\u0004%i\u0001&\u0004\t\u0013QmAq\u0006Q\u0001\u000eQ=\u0001B\u0003K\u000f\t_\u0011\r\u0011\"\u0004\u0015 !IAS\u0005C\u0018A\u00035A\u0013E\u0003\b)O!y\u0003\u0002K\u0015\u0011)!z\u0003b\f\u0005\u0002-eE\u0013\u0007\u0005\r)o!y\u00031AA\u0002\u0013%A\u0013\b\u0005\r)\u000b\"y\u00031AA\u0002\u0013%As\t\u0005\r)\u0017\"y\u00031A\u0001B\u0003&A3\b\u0005\u000b)\u001b\"y\u00031A\u0005\n5u\u0001B\u0003K(\t_\u0001\r\u0011\"\u0003\u0015R!IAS\u000bC\u0018A\u0003&Qr\u0004\u0005\t)/\"y\u0003\"\u0003\u0015Z!AA\u0013\rC\u0018\t\u0013!\u001a\u0007\u0003\u0005\u0015l\u0011=B\u0011\u0002K7\u0011!!*\bb\f\u0005\nQ]t\u0001\u0003K>\t_AI\u0001& \u0007\u0011Q}Dq\u0006E\u0005)\u0003C\u0001\u0002d\u000e\u0005n\u0011\u0005A\u0013\u0012\u0005\r)k!i\u00071AA\u0002\u0013%A2\u001e\u0005\r)\u0017#i\u00071AA\u0002\u0013%AS\u0012\u0005\r)##i\u00071A\u0001B\u0003&Ar\u0004\u0005\t\u0019\u0007\"i\u0007\"\u0001\u0015\u0014\"AAs\u0013C7\t\u0003!J\n\u0003\u0005\u0015$\u0012=B\u0011BFy\u0011!!*\u000bb\f\u0005\nQ\u001d\u0006\u0002CGe\t_!\t%d3\t\u0011Q%Fq\u0006C\u0001\u001b\u0017D\u0001be\u0017\u00050\u0011E32 \u0005\t'?\"y\u0003\"\u0015\u000e.\"AQ2\u0016C\u0018\t\u0003jY\r\u0003\u0006\u0012$\u0011=\u0012\u0011!C\u0001)WC!\"%\u000b\u00050E\u0005I\u0011AJO\u0011)\u0019\n\u000bb\f\u0012\u0002\u0013\u000513\u0015\u0005\u000b)g#y#%A\u0005\u0002QU\u0006BCGn\t_\t\t\u0011\"\u0011\u000eL\"QQR\u001cC\u0018\u0003\u0003%\t!$\b\t\u00155}GqFA\u0001\n\u0003!J\f\u0003\u0006\u000el\u0012=\u0012\u0011!C!\u001b[D!\"d>\u00050\u0005\u0005I\u0011\u0001K_\u0011)iY\u0002b\f\u0002\u0002\u0013\u0005\u0003S \u0005\u000b\u001b{$y#!A\u0005BQ\u0005wa\u0002Kc\u0001!\u0005As\u0019\u0004\b'[\u0004\u0001\u0012\u0001Ke\u0011!a9\u0004\")\u0005\u0002QE\u0007B\u0003G\"\tC\u000b\t\u0011\"!\u0015T\"Q\u0011s\fCQ\u0003\u0003%\t\tf7\u0007\rQ}\u0007\u0001\u0001Kq\u00115iy\u0003\"+\u0003\u0002\u0003\u0006I\u0001$#\u00056!iQr\u0007CU\u0005\u0003\u0005\u000b\u0011\u0002G\u0010\tsA\u0001\u0002d\u000e\u0005*\u0012\u0005A3\u001d\u0004\b)W\u0004\u0011\u0011\u0011Kw\u0011-\u0001z\u0004\"-\u0003\u0016\u0004%\t\u0001&>\t\u0017U\u0005A\u0011\u0017B\tB\u0003%As\u001f\u0005\t\u0019o!\t\f\"\u0001\u0016\u0004!AA2\u001fCY\t\u0003bI\n\u0003\u0005\rB\u0012EF\u0011IF~\u0011!a9\u0010\"-\u0005B1e\u0005\u0002CGV\tc#\t%$,\t\u00115%G\u0011\u0017C!\u001b\u0017D!\"d7\u00052\u0006\u0005I\u0011IGf\u0011)ii\u000e\"-\u0002\u0002\u0013\u0005QR\u0004\u0005\u000b\u001b?$\t,!A\u0005\u0002U%\u0001BCGv\tc\u000b\t\u0011\"\u0011\u000en\"QQr\u001fCY\u0003\u0003%\t!&\u0004\t\u00155uH\u0011WA\u0001\n\u0003*\nbB\u0004\u0016\u0016\u0001A\t!f\u0006\u0007\u000fQ-\b\u0001#\u0001\u0016\u001a!AAr\u0007Ci\t\u0003)\n\u0003\u0003\u0005\rD\u0011EG\u0011AK\u0012\u0011)\tz\u0006\"5\u0002\u0002\u0013\u0005U\u0013\u0007\u0004\u0007+O\u0001!!&\u000b\t\u001bA}B\u0011\u001cB\u0001B\u0003%As\u001fCZ\u0011!a9\u0004\"7\u0005\u0002U-bABK\u001c\u0001\u0001)J\u0004C\u0007\u0016X\u0012}'\u0011!Q\u0001\n1}Sq\u0011\u0005\u000e+3$yN!A!\u0002\u0013ay\"b#\t\u001bUmGq\u001cB\u0001B\u0003%ARLCH\u0011!a9\u0004b8\u0005\u0002Uu\u0007\u0002\u0003Gb\t?$\tec?\t\u00119\rBq\u001cC!+OD\u0001B$\u0003\u0005`\u0012\u0005C\u0012\u0014\u0004\u0007+_\u0004\u0001!&=\t\u001bU]Gq\u001eB\u0001B\u0003%ArLCD\u00115)J\u000eb<\u0003\u0002\u0003\u0006I\u0001d\b\u0006\f\"AAr\u0007Cx\t\u00031:\u0001\u0003\u0007\u0017\u0010\u0011=\b\u0019!A!B\u0013ay\u0006\u0003\u0005\r|\u0012=H\u0011\tGM\u0011!a)\u000fb<\u0005B1\u001d\b\u0002CKZ\t_$\tF&\u0005\t\u0011=mGq\u001eC!\u001b[C\u0001b$7\u0005p\u0012\u0005SR\u0016\u0005\t\u001bW#y\u000f\"\u0011\u000eL\"Aq2\u001bCx\t\u0003jY\rC\u0007\u0016T\u0012=(\u0011!A\u0001\n\u0003\u00021\u0012\u001f\u0004\u0007-+\u0001\u0001Af\u0006\t\u001bU]W\u0011\u0002B\u0001B\u0003%ArLCD\u00115)J.\"\u0003\u0003\u0002\u0003\u0006I\u0001d\b\u0006\f\"AArGC\u0005\t\u00031J\u0002\u0003\u0005\u00164\u0016%A\u0011\u000bL\u0011\r\u00191*\u0003\u0001\u0001\u0017(!iQs[C\n\u0005\u0003\u0005\u000b\u0011\u0002G0\u000b\u000fCQ\"&7\u0006\u0014\t\u0005\t\u0015!\u0003\r \u0015-\u0005\u0002\u0003G\u001c\u000b'!\tA&\u000b\t\u0011MUU1\u0003C)\u00193C\u0001\"f-\u0006\u0014\u0011Ec\u0013\u0007\u0004\u0007+k\u0004\u0001!f>\t\u001bU]Wq\u0004B\u0001B\u0003%ArLCD\u00115)J.b\b\u0003\u0002\u0003\u0006I\u0001d\b\u0006\f\"AArGC\u0010\t\u0003)J\u0010\u0003\u0005\rD\u0016}A\u0011IF~\u0011!q\u0019#b\b\u0005B5U\u0003\u0002\u0003H\u0014\u000b?!\t%f@\t\u00111mXq\u0004C!\u00193C\u0001B$\u0003\u0006 \u0011\u0005cS\u0001\u0005\t'++y\u0002\"\u0015\r\u001a\u001aIaS\u0007\u0001\u0011\u0002\u0007\u0005as\u0007\u0005\t\u0017_,\u0019\u0004\"\u0001\fr\"aa\u0013HC\u001a\u0001\u0004\u0005\r\u0011\"\u0003\r\u001a\"aa3HC\u001a\u0001\u0004\u0005\r\u0011\"\u0003\u0017>!Qa\u0013IC\u001a\u0001\u0004%IAf\u0011\t\u0015Y=S1\u0007a\u0001\n\u00131\n\u0006\u0003\u0007\u0017V\u0015M\u0002\u0019!a\u0001\n\u0013aI\n\u0003\u0007\u0017X\u0015M\u0002\u0019!a\u0001\n\u00131J\u0006\u0003\u0005\u0016\u0000\u0015MBQ\u000bGM\u0011!1j&b\r\u0005\n-E\b\"DKj\u000bg\u0011\t\u0011!A\u0005B\u0001Y\t\u0010C\b\u0017`\u0015M\u0002\u0013aA\u0001\u0002\u0013%1\u0012\u001fD\u0010\u0011=1\n'b\r\u0011\u0002\u0007\u0005\t\u0011\"\u0003\r\u001a\u0016\u0005g!\u0003L2\u0001A\u0005\u0019\u0011\u0001L3\u0011!Yy/\"\u0014\u0005\u0002-E\b\u0002\u0003H!\u000b\u001b\"\t\u0005$'\t\u00111mXQ\nC!\u00193C\u0001B$\u0002\u0006N\u0011\u0005C\u0012\u0014\u0005\t\u0019S,i\u0005\"\u0011\rl\"AAR^C'\t\u0003bY\u000fC\u0005\u0016&\u00165C\u0011\u000b\u0001\r\u0016\"AQ2KC'\t\u0003j)\u0006\u0003\u0005\u000e0\u00155C\u0011\tGD\u0011!\u0019**\"\u0014\u0005R1e\u0005\u0002\u0003H$\u000b\u001b\"\t\u0005$'\t\u0011UeUQ\nC!-SB\u0001\"$3\u0006N\u0011\u0005S2\u001a\u0005\u0010-_*i\u0005%A\u0002\u0002\u0003%I\u0001$'\u0002*!ya\u0013OC'!\u0003\r\t\u0011!C\u0005\u0019W,y\u000eC\b\u0017t\u00155\u0003\u0013aA\u0001\u0002\u0013%A\u0012TCg\u0011\u001d1*\b\u0001C\u0005-o2\u0011B& \u0001!\u0003\r\tAf \t\u0011-=X\u0011\u000fC\u0001\u0017cD\u0001\"d\u0015\u0006r\u0011\u0005SR\u000b\u0005\t\u001b_)\t\b\"\u0011\r\b\"AAR`C9\t\u0003by\u0010\u0003\u0005\u000e\u001a\u0016ED\u0011\tGM\u0011!iY*\"\u001d\u0005B1e\u0005\"CKT\u000bc\"\t\u0006AG\u001e\u0011%)*+\"\u001d\u0005R\u0001a)\n\u0003\u0005\u000eJ\u0016ED\u0011IGf\r\u001d)j\u0004AAA+\u007fA1B$,\u0006\u0006\nU\r\u0011\"\u0001\r\u001a\"Y\u0011s[CC\u0005#\u0005\u000b\u0011\u0002G0\u0011-a\u0019/\"\"\u0003\u0016\u0004%\t\u0001d;\t\u0017E]UQ\u0011B\tB\u0003%Ar\u0004\u0005\f+\u000f*)I!f\u0001\n\u0003a)\nC\u0006\u0016J\u0015\u0015%\u0011#Q\u0001\n1u\u0003\u0002\u0003G\u001c\u000b\u000b#\t!f\u0013\t\u0015E\u0005XQ\u0011a\u0001\n\u0013\t\u001a\u000f\u0003\u0006\u0012x\u0016\u0015\u0005\u0019!C\u0005+'B\u0011\"%@\u0006\u0006\u0002\u0006K!%:\t\u00111\u0005WQ\u0011C!\u0017wD\u0001\u0002d7\u0006\u0006\u0012\u000532 \u0005\u000f+/*)\t1AA\u0002\u0013\u00051R\u0013GK\u00119)J&\"\"A\u0002\u0003\u0007I\u0011AFK+7BA\"f\u0018\u0006\u0006\u0002\u0007\t\u0011)Q\u0005\u0019;BA\"&\u0019\u0006\u0006\u0002\u0007I\u0011AFK\u001b;AA\"f\u0019\u0006\u0006\u0002\u0007I\u0011AFK+KB\u0011\"&\u001b\u0006\u0006\u0002\u0006K!d\b\t\u001dMUQQ\u0011a\u0001\u0002\u0004%\ta#&\u000e<!q1sCCC\u0001\u0004\u0005\r\u0011\"\u0001\f\u0016V-\u0004\u0002DJ\u000f\u000b\u000b\u0003\r\u0011!Q!\n5u\u0002\u0002DJ\u0010\u000b\u000b\u0003\r\u0011\"\u0001\f\u00166u\u0001\u0002DJ\u0011\u000b\u000b\u0003\r\u0011\"\u0001\f\u0016V=\u0004\"CJ\u0014\u000b\u000b\u0003\u000b\u0015BG\u0010\u00111\u0019Z)\"\"A\u0002\u0003\u0007I\u0011\u0002GM\u00111\u0019j)\"\"A\u0002\u0003\u0007I\u0011BK:\u00111\u0019\u001a*\"\"A\u0002\u0003\u0005\u000b\u0015\u0002G0\u0011!i9#\"\"\u0005F5u\u0001\u0002CG\u007f\u000b\u000b#)%&\u001f\t\u0011U}TQ\u0011C\t\u00193C\u0001\"&!\u0006\u0006\u0012\u0015Q3\u0011\u0005\t+\u000f+)\t\"\u0003\r\u0016\"AQ\u0012GCC\t\u000b*J\t\u0003\u0005\u0016\u000e\u0016\u0015E\u0011BKH\u0011!)\u001a*\"\"\u0005\nUU\u0005\u0002CJK\u000b\u000b#\t\u0002$'\t\u00119uRQ\u0011C#\u00193C\u0001bd9\u0006\u0006\u0012\u000532 \u0005\t\u001d\u007f))\t\"\u0012\r\u001a\"AQ\u0013TCC\t\u0003)Z\n\u0003\u0005\u0016\"\u0016\u0015E\u0011AG+\u0011!)\u001a+\"\"\u0005\u0002-m\b\u0002CG$\u000b\u000b#\t%$\u0013\t\u00119\u0015QQ\u0011C!\u00193C\u0001\u0002$;\u0006\u0006\u0012\u0005C2\u001e\u0005\t\u0019_,)\t\"\u0011\rl\"Aa2BCC\t\u0003b)\n\u0003\u0005\rz\u0016\u0015E\u0011\tGM\u0011!ai/\"\"\u0005B1-\b\u0002\u0003Gy\u000b\u000b#\t\u0005d;\t\u001155RQ\u0011C!\u0019+C\u0011\"&*\u0006\u0006\u0012E\u0001\u0001$&\t\u00115MSQ\u0011C!\u001b+B\u0001\"d\f\u0006\u0006\u0012\u0005Cr\u0011\u0005\n+O+)\t\"\u0005\u0001\u001bwA\u0001\"$\u000f\u0006\u0006\u0012\u0005S2\b\u0005\t+S+)\t\"\u0003\f|\"AQ3VCC\t\u0013ii\u000b\u0003\u0005\u0016.\u0016\u0015E\u0011BGf\u0011!yi.\"\"\u0005B5-\u0007\u0002CKX\u000b\u000b#I\u0001d\"\t\u0011UEVQ\u0011C\u0005\u001b[C\u0001\"f-\u0006\u0006\u0012EQS\u0017\u0005\t+w+)\t\"\u0003\u000eL\"AQSXCC\t\u0013ii\u000b\u0003\u0005\u0016@\u0016\u0015E\u0011BGW\u0011!)\n-\"\"\u0005\n55\u0006\u0002CGV\u000b\u000b#\t%$,\t\u0011=MWQ\u0011C!\u001b\u0017D\u0001\"e\t\u0006\u0006\u0012%Q3\u0019\u0005\t\u001b\u0013,)\t\"\u0011\u000eL\"QQ2\\CC\u0003\u0003%\t%d3\t\u00155uWQQA\u0001\n\u0003ii\u0002\u0003\u0006\u000e`\u0016\u0015\u0015\u0011!C\u0001+\u0017D!\"d;\u0006\u0006\u0006\u0005I\u0011IGw\u0011)i90\"\"\u0002\u0002\u0013\u0005Qs\u001a\u0005\u000e+',)I!A\u0001\u0002\u0013\u0005\u0001a#=\t\u001bUUWQ\u0011B\u0001\u0002\u0003%)\u0001\u0001Gt\u000f\u001d1\n\t\u0001E\u0001-\u00073q!&\u0010\u0001\u0011\u00031*\t\u0003\u0005\r8\u0019\u0015B\u0011\u0001LG\u0011!a\u0019E\"\n\u0005\u0002Y=\u0005BCI0\rK\t\t\u0011\"!\u0017\u0018\u001a1as\u0014\u0001\u0007-CCQB$,\u0007.\t\u0005\t\u0015!\u0003\r`\u0015\u001d\u0005\"\u0004Gr\r[\u0011\t\u0011)A\u0005\u0019?)Y\tC\u0007\u0016H\u00195\"\u0011!Q\u0001\n1uSq\u0012\u0005\t\u0019o1i\u0003\"\u0001\u0017&\u001a1as\u0016\u0001\u0007-cCQB$,\u00078\t\u0005\t\u0015!\u0003\r`\u0015\u001d\u0005\"\u0004Gr\ro\u0011\t\u0011)A\u0005\u0019?)Y\tC\u0007\u0016H\u0019]\"\u0011!Q\u0001\n1uSq\u0012\u0005\t\u0019o19\u0004\"\u0001\u00176\u001a1as\u0018\u0001\u0007-\u0003DQB$,\u0007B\t\u0005\t\u0015!\u0003\r`\u0015\u001d\u0005\"\u0004Gr\r\u0003\u0012\t\u0011)A\u0005\u0019?)Y\tC\u0007\u0016H\u0019\u0005#\u0011!Q\u0001\n1uSq\u0012\u0005\t\u0019o1\t\u0005\"\u0001\u0017D\u001a1aS\u001a\u0001\u0007-\u001fDQB$,\u0007L\t\u0005\t\u0015!\u0003\r`\u0015\u001d\u0005\"\u0004Gr\r\u0017\u0012\t\u0011)A\u0005\u0019?)Y\t\u0003\u0005\r8\u0019-C\u0011\u0001Li\r\u00191J\u000e\u0001\u0004\u0017\\\"iaR\u0016D*\u0005\u0003\u0005\u000b\u0011\u0002G0\u000b\u000fCQ\u0002d9\u0007T\t\u0005\t\u0015!\u0003\r \u0015-\u0005\u0002\u0003G\u001c\r'\"\tA&8\u0007\rY\u0015\bA\u0002Lt\u00115qiKb\u0017\u0003\u0002\u0003\u0006I\u0001d\u0018\u0006\b\"iA2\u001dD.\u0005\u0003\u0005\u000b\u0011\u0002G\u0010\u000b\u0017C\u0001\u0002d\u000e\u0007\\\u0011\u0005a\u0013\u001e\u0005\b-c\u0004A\u0011\u0003Lz\u0011\u001d1J\u0010\u0001C\t-wDqAf@\u0001\t#9\nA\u0002\u0004\u0018\u0006\u0001\u0001us\u0001\u0005\f\u001d?1IG!f\u0001\n\u0003j)\u0006C\u0006\u0018\u0010\u0019%$\u0011#Q\u0001\n1-\u0003b\u0003H\b\rS\u0012)\u001a!C!\u00193C1b&\u0005\u0007j\tE\t\u0015!\u0003\r`!AAr\u0007D5\t\u00039\u001a\u0002\u0003\u0006\u0012b\u001a%\u0004\u0019!C\u0005#GD!\"e>\u0007j\u0001\u0007I\u0011BL\u000e\u0011%\tjP\"\u001b!B\u0013\t*\u000f\u0003\u0005\rB\u001a%D\u0011IF~\u0011!9zB\"\u001b\u0005\n-m\b\u0002CL\u0011\rS\"Iac?\t\u0011]\rb\u0011\u000eC\u0001\u0017wD\u0001b&\n\u0007j\u0011\u000512 \u0005\t\u001d71I\u0007\"\u0011\u000e\u001e!AaR\u0004D5\t\u0003b\t\f\u0003\u0005\u000f\"\u0019%D\u0011\tGK\u0011!i9F\"\u001b\u0005B15\u0001\u0002\u0003H\b\rS\"\te&\u000b\t\u0015]5b\u0011\u000ea\u0001\n\u0013\t\u001a\u000f\u0003\u0006\u00180\u0019%\u0004\u0019!C\u0005/cA\u0011b&\u000e\u0007j\u0001\u0006K!%:\t\u00111=g\u0011\u000eC!\u0017wD\u0001bf\u000e\u0007j\u0011\u0005q\u0013\b\u0005\t\u001bW3I\u0007\"\u0011\u000eL\"Aq2\u0018D5\t\u0003:Z\u0004\u0003\u0005\u0010B\u001a%D\u0011IL \u0011!iIM\"\u001b\u0005B5-\u0007BCI\u0012\rS\n\t\u0011\"\u0001\u0018D!Q\u0011\u0013\u0006D5#\u0003%\ta&\u0013\t\u0015M\u0005f\u0011NI\u0001\n\u00039j\u0005\u0003\u0006\u000e\\\u001a%\u0014\u0011!C!\u001b\u0017D!\"$8\u0007j\u0005\u0005I\u0011AG\u000f\u0011)iyN\"\u001b\u0002\u0002\u0013\u0005q\u0013\u000b\u0005\u000b\u001bW4I'!A\u0005B55\bBCG|\rS\n\t\u0011\"\u0001\u0018V!QQ2\u0004D5\u0003\u0003%\t\u0005%@\t\u00155uh\u0011NA\u0001\n\u0003:JfB\u0004\u0018^\u0001A\taf\u0018\u0007\u000f]\u0015\u0001\u0001#\u0001\u0018b!AAr\u0007D\\\t\u00039J\u0007\u0003\u0006\rD\u0019]\u0016\u0011!CA/WB!\"e\u0018\u00078\u0006\u0005I\u0011QL9\r\u00199J\b\u0001\u0001\u0018|!iqS\u0010D`\u0005\u0003\u0005\u000b\u0011\u0002G&\rWB1bf \u0007@\n\u0005\t\u0015!\u0003\r`!AAr\u0007D`\t\u00039\n\t\u0003\u0005\u0018&\u0019}F\u0011IF~\r\u00199J\t\u0001!\u0018\f\"Yar\u0002De\u0005+\u0007I\u0011\tGM\u0011-9\nB\"3\u0003\u0012\u0003\u0006I\u0001d\u0018\t\u00111]b\u0011\u001aC\u0001/'C\u0001\u0002$1\u0007J\u0012\u000532 \u0005\t\u001d\u000b1I\r\"\u0011\r\u001a\"AA2 De\t\u0003bI\n\u0003\u0005\rj\u001a%G\u0011\tGv\u0011!aiO\"3\u0005B1-\b\u0002CG\u0017\r\u0013$\t\u0005$&\t\u00115=b\u0011\u001aC!\u0019\u000fC\u0001\"$\u000f\u0007J\u0012\u0005S2\b\u0005\t\u001b\u000f2I\r\"\u0011\u000eJ!AQ2\u000bDe\t\u0003j)\u0006\u0003\u0005\u000e2\u0019%G\u0011ILM\u0011!i9F\"3\u0005B15\u0001\u0002CGV\r\u0013$\t%$,\t\u00115%g\u0011\u001aC!\u001b\u0017D!\"e\t\u0007J\u0006\u0005I\u0011ALP\u0011)\tJC\"3\u0012\u0002\u0013\u0005qS\n\u0005\u000b\u001b74I-!A\u0005B5-\u0007BCGo\r\u0013\f\t\u0011\"\u0001\u000e\u001e!QQr\u001cDe\u0003\u0003%\taf)\t\u00155-h\u0011ZA\u0001\n\u0003ji\u000f\u0003\u0006\u000ex\u001a%\u0017\u0011!C\u0001/OC!\"d\u0007\u0007J\u0006\u0005I\u0011\tI\u007f\u0011)iiP\"3\u0002\u0002\u0013\u0005s3V\u0004\b/_\u0003\u0001\u0012ALY\r\u001d9J\t\u0001E\u0001/gC\u0001\u0002d\u000e\b\u0002\u0011\u0005q3\u0018\u0005\u000b\u0019\u0007:\t!!A\u0005\u0002^u\u0006BCI0\u000f\u0003\t\t\u0011\"!\u0018B\u001a1qS\u0019\u0001A/\u000fD1Bd\t\b\n\tU\r\u0011\"\u0011\u000eV!YqsZD\u0005\u0005#\u0005\u000b\u0011\u0002G&\u0011-qya\"\u0003\u0003\u0016\u0004%\t\u0005$'\t\u0017]Eq\u0011\u0002B\tB\u0003%Ar\f\u0005\t\u0019o9I\u0001\"\u0001\u0018R\"Aa2DD\u0005\t\u0003ji\u0002\u0003\u0005\u000f\u001e\u001d%A\u0011\tGY\u0011!qyb\"\u0003\u0005B5U\u0003\u0002\u0003H\u0011\u000f\u0013!\t\u0005$&\t\u001155r\u0011\u0002C!\u0019+C\u0001\"d\f\b\n\u0011\u0005Cr\u0011\u0005\t\u0019S<I\u0001\"\u0011\rl\"AAR^D\u0005\t\u0003bY\u000f\u0003\u0005\u000eX\u001d%A\u0011\tG\u0007\u0011!q)a\"\u0003\u0005B1e\u0005\u0002CG\u001d\u000f\u0013!\t%d\u000f\t\u00115\u001ds\u0011\u0002C!\u001b\u0013B\u0001\"d\u0015\b\n\u0011\u0005SR\u000b\u0005\t\u001bc9I\u0001\"\u0011\u0018\\\"AA2`D\u0005\t\u0003bI\n\u0003\u0005\rP\u001e%A\u0011IF~\u0011!iYj\"\u0003\u0005B1e\u0005\u0002CGM\u000f\u0013!\t\u0005$'\t\u00111\rw\u0011\u0002C!\u0017wD\u0001\"d+\b\n\u0011\u0005S2\u001a\u0005\t\u001fw;I\u0001\"\u0011\u0018`\"Aq\u0012YD\u0005\t\u0003:\u001a\u000f\u0003\u0005\u000eJ\u001e%A\u0011IGf\u0011)\t\u001ac\"\u0003\u0002\u0002\u0013\u0005qs\u001d\u0005\u000b#S9I!%A\u0005\u0002]%\u0003BCJQ\u000f\u0013\t\n\u0011\"\u0001\u0018N!QQ2\\D\u0005\u0003\u0003%\t%d3\t\u00155uw\u0011BA\u0001\n\u0003ii\u0002\u0003\u0006\u000e`\u001e%\u0011\u0011!C\u0001/[D!\"d;\b\n\u0005\u0005I\u0011IGw\u0011)i9p\"\u0003\u0002\u0002\u0013\u0005q\u0013\u001f\u0005\u000b\u001b79I!!A\u0005BAu\bBCG\u007f\u000f\u0013\t\t\u0011\"\u0011\u0018v\u001e9q\u0013 \u0001\t\u0002]mhaBLc\u0001!\u0005qS \u0005\t\u0019o9I\u0006\"\u0001\u0019\u0006!QA2ID-\u0003\u0003%\t\tg\u0002\t\u0015E}s\u0011LA\u0001\n\u0003Cj\u0001C\u0004\u0019\u0012\u0001!\t\u0001g\u0005\u0007\ram\u0001\u0001\u0011M\u000f\u0011-A:bb\u0019\u0003\u0016\u0004%\t!$\u0016\t\u0017a\u001dr1\rB\tB\u0003%A2\n\u0005\f\u0019g<\u0019G!f\u0001\n\u0003bI\nC\u0006\u0019*\u001d\r$\u0011#Q\u0001\n1}\u0003\u0002\u0003G\u001c\u000fG\"\t\u0001g\u000b\t\u0011A]t1\rC)1gA\u0001\u0002$1\bd\u0011\u000532 \u0005\t\u001b7;\u0019\u0007\"\u0011\r\u001a\"AQ\u0012TD2\t\u0003bI\n\u0003\u0005\u000e.\u001d\rD\u0011\tGK\u0011!i9fb\u0019\u0005B15\u0001\u0002\u0003H\u0003\u000fG\"\t\u0005$'\t\u00119-q1\rC!\u0019+C\u0001Bd\b\bd\u0011\u0005\u0003\u0014\b\u0005\t\u001dC9\u0019\u0007\"\u0011\r\u0016\"AarED2\t\u0003Bz\u0004\u0003\u0005\u000e2\u001d\rD\u0011\tM#\u0011!iIdb\u0019\u0005B5m\u0002\u0002\u0003Gb\u000fG\"\tec?\t\u0011a%s1\rC\u0005\u0019WD\u0001\u0002g\u0013\bd\u0011%12 \u0005\t\u001dc9\u0019\u0007\"\u0011\u0019N!A\u0001TKD2\t\u0013A:\u0006\u0003\u0005\u0010^\u001e\rD\u0011IGW\u0011!A\ngb\u0019\u0005\n5-\u0007\u0002\u0003M2\u000fG\"\tac?\t\u00115-v1\rC!\u001b[C\u0001bd/\bd\u0011\u0005\u0003T\r\u0005\t\u001f\u0003<\u0019\u0007\"\u0011\u0019j!AQ\u0012ZD2\t\u0003jY\r\u0003\u0005\u0019n\u001d\rD\u0011\u0001M8\u0011!Ajgb\u0019\u0005\u0002aU\u0004BCI\u0012\u000fG\n\t\u0011\"\u0001\u0019~!Q\u0011\u0013FD2#\u0003%\ta&\u0013\t\u0015M\u0005v1MI\u0001\n\u00039j\u0005\u0003\u0006\u000e\\\u001e\r\u0014\u0011!C!\u001b\u0017D!\"$8\bd\u0005\u0005I\u0011AG\u000f\u0011)iynb\u0019\u0002\u0002\u0013\u0005\u00014\u0011\u0005\u000b\u001bW<\u0019'!A\u0005B55\bBCG|\u000fG\n\t\u0011\"\u0001\u0019\b\"QQ2DD2\u0003\u0003%\t\u0005%@\t\u00155ux1MA\u0001\n\u0003BZiB\u0004\u0019\u0010\u0002A\t\u0001'%\u0007\u000fam\u0001\u0001#\u0001\u0019\u0014\"AArGD^\t\u0003AZ\n\u0003\u0006\rD\u001dm\u0016\u0011!CA1;C!\"e\u0018\b<\u0006\u0005I\u0011\u0011MR\r\u0019A:\u000b\u0001!\u0019*\"YaRVDb\u0005+\u0007I\u0011\u0001GM\u0011-\t:nb1\u0003\u0012\u0003\u0006I\u0001d\u0018\t\u0017a-v1\u0019BK\u0002\u0013\u0005QR\u000b\u0005\f1[;\u0019M!E!\u0002\u0013aY\u0005\u0003\u0005\r8\u001d\rG\u0011\u0001MX\u0011!q)ab1\u0005B1e\u0005\u0002CGV\u000f\u0007$\t%$,\t\u00115%w1\u0019C!\u001b\u0017D!\"e\t\bD\u0006\u0005I\u0011\u0001M\\\u0011)\tJcb1\u0012\u0002\u0013\u0005qS\n\u0005\u000b'C;\u0019-%A\u0005\u0002]%\u0003BCGn\u000f\u0007\f\t\u0011\"\u0011\u000eL\"QQR\\Db\u0003\u0003%\t!$\b\t\u00155}w1YA\u0001\n\u0003Aj\f\u0003\u0006\u000el\u001e\r\u0017\u0011!C!\u001b[D!\"d>\bD\u0006\u0005I\u0011\u0001Ma\u0011)iYbb1\u0002\u0002\u0013\u0005\u0003S \u0005\u000b\u001b{<\u0019-!A\u0005Ba\u0015w!\u0003Me\u0001\u0005\u0005\t\u0012\u0001Mf\r%A:\u000bAA\u0001\u0012\u0003Aj\r\u0003\u0005\r8\u001d-H\u0011\u0001Mn\u0011)y)nb;\u0002\u0002\u0013\u0015\u00033\u0018\u0005\u000b\u0019\u0007:Y/!A\u0005\u0002bu\u0007BCI0\u000fW\f\t\u0011\"!\u0019d\"9\u00014\u001e\u0001\u0005\u0002a5hA\u0002Mz\u0001\u0001C*\u0010C\u0006\u0019x\u001e](Q3A\u0005\u0002ae\bb\u0003M~\u000fo\u0014\t\u0012)A\u0005!SC\u0001\u0002d\u000e\bx\u0012\u0005\u0001T \u0005\t\u001bW;9\u0010\"\u0011\u000eL\"Q\u00113ED|\u0003\u0003%\t!g\u0001\t\u0015E%rq_I\u0001\n\u0003I:\u0001\u0003\u0006\u000e\\\u001e]\u0018\u0011!C!\u001b\u0017D!\"$8\bx\u0006\u0005I\u0011AG\u000f\u0011)iynb>\u0002\u0002\u0013\u0005\u00114\u0002\u0005\u000b\u001bW<90!A\u0005B55\bBCG|\u000fo\f\t\u0011\"\u0001\u001a\u0010!QQ2DD|\u0003\u0003%\t\u0005%@\t\u00155uxq_A\u0001\n\u0003J\u001abB\u0005\u001a\u0018\u0001\t\t\u0011#\u0001\u001a\u001a\u0019I\u00014\u001f\u0001\u0002\u0002#\u0005\u00114\u0004\u0005\t\u0019oA)\u0002\"\u0001\u001a$!QqR\u001bE\u000b\u0003\u0003%)\u0005e/\t\u00151\r\u0003RCA\u0001\n\u0003K*\u0003\u0003\u0006\u0012`!U\u0011\u0011!CA3S1a!g\f\u0001\u0001fE\u0002b\u0003HW\u0011?\u0011)\u001a!C\u0001\u00193C1\"e6\t \tE\t\u0015!\u0003\r`!Y\u00114\u0007E\u0010\u0005+\u0007I\u0011\u0001GK\u0011-I*\u0004c\b\u0003\u0012\u0003\u0006I\u0001$\u0018\t\u00111]\u0002r\u0004C\u00013oA\u0001\"d+\t \u0011\u0005S2\u001a\u0005\t\u001doCy\u0002\"\u0011\u001a@!AQ\u0012\u001aE\u0010\t\u0003jY\r\u0003\u0006\u0012$!}\u0011\u0011!C\u00013\u0007B!\"%\u000b\t E\u0005I\u0011AL'\u0011)\u0019\n\u000bc\b\u0012\u0002\u0013\u00051S\u0014\u0005\u000b\u001b7Dy\"!A\u0005B5-\u0007BCGo\u0011?\t\t\u0011\"\u0001\u000e\u001e!QQr\u001cE\u0010\u0003\u0003%\t!'\u0013\t\u00155-\brDA\u0001\n\u0003ji\u000f\u0003\u0006\u000ex\"}\u0011\u0011!C\u00013\u001bB!\"d\u0007\t \u0005\u0005I\u0011\tI\u007f\u0011)ii\u0010c\b\u0002\u0002\u0013\u0005\u0013\u0014K\u0004\n3+\u0002\u0011\u0011!E\u00013/2\u0011\"g\f\u0001\u0003\u0003E\t!'\u0017\t\u00111]\u0002r\tC\u00013;B!b$6\tH\u0005\u0005IQ\tI^\u0011)a\u0019\u0005c\u0012\u0002\u0002\u0013\u0005\u0015t\f\u0005\u000b#?B9%!A\u0005\u0002f\u0015taBM7\u0001!\u0005\u0011t\u000e\u0004\b3c\u0002\u0001\u0012AM:\u0011!a9\u0004c\u0015\u0005\u0002eU\u0004\u0002\u0003G\"\u0011'\"\t!g\u001e\t\u0011E}\u00032\u000bC\u00013\u0007;q!g#\u0001\u0011\u0003IjIB\u0004\u001a\u0010\u0002A\t!'%\t\u00111]\u0002R\fC\u00013'C\u0001\"e\u0018\t^\u0011\u0005\u0011TS\u0004\b33\u0003\u0001\u0012AMN\r\u001dIj\n\u0001E\u00013?C\u0001\u0002d\u000e\tf\u0011\u0005\u0011\u0014\u0015\u0005\t3GC)\u0007\"\u0002\u001a&\"A\u0011T\u0018E3\t\u0013Iz\f\u0003\u0005\u001aJ\"\u0015D\u0011AMf\u0011!a\u0019\u0005#\u001a\u0005\u0002i\u001d\u0005\u0002\u0003G\"\u0011K\"\tAg#\t\u00111\r\u0003R\rC\u00015#C\u0001Bg'\tf\u0011%!T\u0014\u0005\t57C)\u0007\"\u0003\u001b*\"Q\u0011s\fE3\u0003\u0003%\tIg,\u0007\ri]\u0006\u0001\u0001N]\u00115QZ\fc\u001f\u0003\u0002\u0003\u0006I\u0001d\u0018\t0\"Y!T\u0018E>\u0005\u0003\u0005\u000b\u0011BMa\u0011-qy\u0002c\u001f\u0003\u0006\u0004%\t%$\u0016\t\u0017]=\u00012\u0010B\u0001B\u0003%A2\n\u0005\t\u0019oAY\b\"\u0001\u001b@\"AA2\u0019E>\t\u0003ZYP\u0002\u0004\u001bJ\u0002\u0001!4\u001a\u0005\u000e5wCII!A!\u0002\u0013ay\u0006c,\t\u0017iu\u0006\u0012\u0012B\u0001B\u0003%\u0011\u0014\u0019\u0005\f\u001d?AII!b\u0001\n\u0003j)\u0006C\u0006\u0018\u0010!%%\u0011!Q\u0001\n1-\u0003b\u0003H\u0006\u0011\u0013\u0013)\u0019!C!\u0019+C1B'4\t\n\n\u0005\t\u0015!\u0003\r^!AAr\u0007EE\t\u0003Qz\r\u0003\u0005\u000e,\"%E\u0011IGW\r%QZ\u000e\u0001I\u0001\u0004\u0003Qj\u000e\u0003\u0005\fp\"mE\u0011AFy\u0011!IJ\rc'\u0005B-m\b\u0002CHr\u00117#\tec?\t\u0011im\u00022\u0014C!5?D\u0001B'\f\t\u001c\u0012\u0005#T\u001d\u0005\u000b5sAY*%A\u0005\u0002i=\u0001b\u0004Nw\u00117\u0003\n1!A\u0001\n\u0013Qz\u000fc;\t\u001fiU\b2\u0014I\u0001\u0004\u0003\u0005I\u0011\u0002N|\u0011O4q!'(\u0001\u0003\u0003Kz\rC\u0006\u000f<!5&Q3A\u0005\u00021e\u0005bCMi\u0011[\u0013\t\u0012)A\u0005\u0019?B1\"g5\t.\nE\r\u0011\"\u0001\u001aV\"Y\u0011t\u001bEW\u0005\u0003\u0007I\u0011AMm\u0011-Ij\u000e#,\u0003\u0012\u0003\u0006K!'1\t\u00111]\u0002R\u0016C\u00013?D\u0001\"d\u0007\t.\u0012\u0005\u0003S \u0005\t\u001b{Di\u000b\"\u0011\u001af\"A\u0011\u0014\u001aEW\t\u0003YY\u0010\u0003\u0005\u000f !5F\u0011IG+\u0011!qY\u0001#,\u0005B1U\u0005\u0002\u0003Gb\u0011[#\tec?\t\u0011e%\bR\u0016C\u0001\u0017wD\u0001\"g;\t.\u0012\u0005A\u0012\u0014\u0005\t3[Di\u000b\"\u0001\f|\"Aq2\u001dEW\t\u0003ZY\u0010\u0003\u0006\u001ap\"5&\u0019!C\u0001\u001b;A\u0011\"'=\t.\u0002\u0006I!d\b\t\u0011eM\bR\u0016C\u00013kD\u0001\"g?\t.\u0012\u0005\u0011T \u0005\t5\u0007Ai\u000b\"\u0001\u001b\u0006!Q!T\u0002EW#\u0003%\tAg\u0004\t\u0011iM\u0001R\u0016C\u00015+A!Bg\u0007\t.F\u0005I\u0011\u0001N\b\u0011)Qj\u0002#,A\u0002\u0013%A\u0012\u0014\u0005\u000b5?Ai\u000b1A\u0005\ni\u0005\u0002\"\u0003N\u0013\u0011[\u0003\u000b\u0015\u0002G0\u0011!Q:\u0003#,\u0005\u0016i%\u0002\u0002\u0003N\u0017\u0011[#\tAg\f\t\u0015ie\u0002RVI\u0001\n\u0003Qz\u0001\u0003\u0005\u001b<!5F\u0011\u0001N\u001f\u0011!Q*\u0005#,\u0005\u0002i\u001d\u0003\u0002\u0003N'\u0011[#IAg\u0014\t\u0011iM\u0003R\u0016C\u00015+B\u0001B$\u0010\t.\u0012\u0005C\u0012\u0014\u0005\t\u001d\u007fAi\u000b\"\u0011\r\u001a\"AAR\u001eEW\t\u0003bY\u000f\u0003\u0005\u001bZ!5F\u0011\u0002N.\u0011!Qz\u0006#,\u0005\u000255\u0006\u0002\u0003N1\u0011[#\t!$,\t\u0011i\r\u0004R\u0016C\u00055KB\u0001\"d+\t.\u0012\u0005SR\u0016\u0005\t5OBi\u000b\"\u0001\u000e.\"AQ\u0012\u001aEW\t\u0003jY\r\u0003\u0005\u001bj!5F\u0011\u0001N6\u0011)iY\u000e#,\u0002\u0002\u0013\u0005S2\u001a\u0005\u000b\u001b;Di+!A\u0005\u00025u\u0001BCGp\u0011[\u000b\t\u0011\"\u0001\u001bn!QQ2\u001eEW\u0003\u0003%\t%$<\t\u00155]\bRVA\u0001\n\u0003Q\n\bC\u0007\u001bv!5&\u0011!A\u0001\n\u0003\u000112 \u0005\u000e5oBiK!A\u0001\u0002\u0013\u0005\u0001A'\u001f\t\u001bi}\u0004R\u0016B\u0001\u0002\u0003%\t\u0001\u0001NA\r\u0019Qz\u0010\u0001!\u001c\u0002!Y\u00013BE\r\u0005+\u0007I\u0011\tI\u0007\u0011-YJ!#\u0007\u0003\u0012\u0003\u0006I\u0001e\u0004\t\u00171M\u0018\u0012\u0004BK\u0002\u0013\u0005C\u0012\u0014\u0005\f1SIIB!E!\u0002\u0013ay\u0006\u0003\u0005\r8%eA\u0011AN\u0006\u0011!\u0001:(#\u0007\u0005RmM\u0001\u0002\u0003Ga\u00133!\tec?\t\u00115-\u0016\u0012\u0004C!\u001b[C\u0001\u0002%\u0007\n\u001a\u0011\u00053t\u0003\u0005\t!CII\u0002\"\u0011\u001c\u001c!A\u0001\u0013FE\r\t\u0003Zz\u0002\u0003\u0005\u0011\u0018%eA\u0011\tGM\u0011!ai0#\u0007\u0005B1}\b\u0002CGN\u00133!\t\u0005$'\t\u00115e\u0015\u0012\u0004C!\u00193C\u0001Bd\n\n\u001a\u0011\u000534\u0005\u0005\t\u001bsII\u0002\"\u0011\u000e<!AQ\u0012ZE\r\t\u0003jY\r\u0003\u0006\u0012$%e\u0011\u0011!C\u00017SA!\"%\u000b\n\u001aE\u0005I\u0011AN\u0018\u0011)\u0019\n+#\u0007\u0012\u0002\u0013\u0005qS\n\u0005\u000b\u001b7LI\"!A\u0005B5-\u0007BCGo\u00133\t\t\u0011\"\u0001\u000e\u001e!QQr\\E\r\u0003\u0003%\tag\r\t\u00155-\u0018\u0012DA\u0001\n\u0003ji\u000f\u0003\u0006\u000ex&e\u0011\u0011!C\u00017oA!\"d\u0007\n\u001a\u0005\u0005I\u0011\tI\u007f\u0011)ii0#\u0007\u0002\u0002\u0013\u000534H\u0004\b7\u007f\u0001\u0001\u0012AN!\r\u001dQz\u0010\u0001E\u00017\u0007B\u0001\u0002d\u000e\nV\u0011\u000514\n\u0005\u000b\u0019\u0007J)&!A\u0005\u0002n5\u0003BCI0\u0013+\n\t\u0011\"!\u001cT!914\f\u0001\u0005\u0002musaBN2\u0001!\u00051T\r\u0004\b7O\u0002\u0001\u0012AN5\u0011!a9$#\u0019\u0005\u0002m-\u0004\u0002CI0\u0013C\"\ta'\u001c\u0007\rmE\u0004\u0001QN:\u0011-aI(c\u001a\u0003\u0016\u0004%\ta'\u001e\t\u0017m]\u0014r\rB\tB\u0003%A2\u0010\u0005\f'\u000fI9G!f\u0001\n\u0003aI\nC\u0006\u001cz%\u001d$\u0011#Q\u0001\n1}\u0003\u0002\u0003G\u001c\u0013O\"\tag\u001f\t\u00115-\u0016r\rC!\u001b[C!\"e\t\nh\u0005\u0005I\u0011ANB\u0011)\tJ#c\u001a\u0012\u0002\u0013\u00051\u0014\u0012\u0005\u000b'CK9'%A\u0005\u0002]5\u0003BCGn\u0013O\n\t\u0011\"\u0011\u000eL\"QQR\\E4\u0003\u0003%\t!$\b\t\u00155}\u0017rMA\u0001\n\u0003Yj\t\u0003\u0006\u000el&\u001d\u0014\u0011!C!\u001b[D!\"d>\nh\u0005\u0005I\u0011ANI\u0011)iY\"c\u001a\u0002\u0002\u0013\u0005\u0003S \u0005\u000b\u001b{L9'!A\u0005BmUu!CNM\u0001\u0005\u0005\t\u0012ANN\r%Y\n\bAA\u0001\u0012\u0003Yj\n\u0003\u0005\r8%-E\u0011ANQ\u0011)y).c#\u0002\u0002\u0013\u0015\u00033\u0018\u0005\u000b\u0019\u0007JY)!A\u0005\u0002n\r\u0006BCI0\u0013\u0017\u000b\t\u0011\"!\u001c*\u001a11\u0014\u0017\u0001A7gC1be\u0002\n\u0016\nU\r\u0011\"\u0001\r\u001a\"Y1\u0014PEK\u0005#\u0005\u000b\u0011\u0002G0\u0011!a9$#&\u0005\u0002mU\u0006\u0002CGV\u0013+#\t%$,\t\u0015E\r\u0012RSA\u0001\n\u0003YZ\f\u0003\u0006\u0012*%U\u0015\u0013!C\u0001/\u001bB!\"d7\n\u0016\u0006\u0005I\u0011IGf\u0011)ii.#&\u0002\u0002\u0013\u0005QR\u0004\u0005\u000b\u001b?L)*!A\u0005\u0002m}\u0006BCGv\u0013+\u000b\t\u0011\"\u0011\u000en\"QQr_EK\u0003\u0003%\tag1\t\u00155m\u0011RSA\u0001\n\u0003\u0002j\u0010\u0003\u0006\u000e~&U\u0015\u0011!C!7\u000f<\u0011bg3\u0001\u0003\u0003E\ta'4\u0007\u0013mE\u0006!!A\t\u0002m=\u0007\u0002\u0003G\u001c\u0013g#\tag5\t\u0015=U\u00172WA\u0001\n\u000b\u0002Z\f\u0003\u0006\rD%M\u0016\u0011!CA7+D!\"e\u0018\n4\u0006\u0005I\u0011QNm\r\u001dYj\u000eAAA7?D1b'9\n>\nU\r\u0011\"\u0001\rl\"Y14]E_\u0005#\u0005\u000b\u0011\u0002G\u0010\u0011-Y*/#0\u0003\u0016\u0004%\t\u0001$'\t\u0017m\u001d\u0018R\u0018B\tB\u0003%Ar\f\u0005\t\u0019oIi\f\"\u0001\u001cj\"AQ2VE_\t\u0003ji\u000b\u0003\u0006\u000e\\&u\u0016\u0011!C!\u001b\u0017D!\"$8\n>\u0006\u0005I\u0011AG\u000f\u0011)iy.#0\u0002\u0002\u0013\u00051\u0014\u001f\u0005\u000b\u001bWLi,!A\u0005B55\bBCG|\u0013{\u000b\t\u0011\"\u0001\u001cv\"QQR`E_\u0003\u0003%\te'?\b\u000fmu\b\u0001#\u0001\u001c\u0000\u001a91T\u001c\u0001\t\u0002q\u0005\u0001\u0002\u0003G\u001c\u00133$\t\u0001h\u0001\t\u00111\r\u0013\u0012\u001cC\u00019\u000bA!\"e\u0018\nZ\u0006\u0005I\u0011\u0011O\u0006\r\u0019a\u001a\u0002\u0001\u0002\u001d\u0016!i1\u0014]Eq\u0005\u0003\u0005\u000b\u0011\u0002G\u0010\u0013\u007fCQb':\nb\n\u0005\t\u0015!\u0003\r`%\r\u0007\u0002\u0003G\u001c\u0013C$\t\u0001h\u0006\u0007\u000fq}\u0001!!\u0001\u001d\"!AArGEu\t\u0003a\u001a\u0003\u0003\u0005\rZ&%H\u0011IF~\u0011!ai.#;\u0007Bq\u001d\u0002\u0002CGV\u0013S$\t%d3\t\u00115%\u0017\u0012\u001eC!\u001b\u0017D\u0001\u0002h\u000b\nj\u0012\u000512 \u0005\t9[II\u000f\"\u0001\u000eV\u0019IAt\u0006\u0001\u0011\u0002G\u0005A\u0014\u0007\u0004\n9g\u0001\u0001\u0013aI\u00019k1q\u0001h\u000e\u0001\u0003\u0003aJ\u0004C\u0006\u000f$%u(Q1A\u0005B5U\u0003bCLh\u0013{\u0014\t\u0011)A\u0005\u0019\u0017B\u0001\u0002d\u000e\n~\u0012\u0005A4\b\u0005\t\u001bWKi\u0010\"\u0011\u000eL\"9A\u0014\t\u0001\u0005\nq\r\u0003b\u0002O%\u0001\u0011%A4\n\u0005\b9#\u0002A\u0011\u0001O*\u0011\u001daJ\u0006\u0001C\u000197Bq\u0001(\u0017\u0001\t\u0003a\n\bC\u0004\u001dx\u0001!\t\u0001(\u001f\t\u000fq\r\u0005\u0001\"\u0001\u001d\u0006\"9AT\u0012\u0001\u0005\u0002q=\u0005b\u0002OM\u0001\u0011\u0005A4\u0014\u0005\b9C\u0003A\u0011\u0001OR\u0011\u001daj\u000b\u0001C\u00019_Cq\u0001(,\u0001\t\u0003a:\fC\u0004\u001d<\u0002!\t\u0001(0\t\u000fq\u0005\u0007\u0001\"\u0001\u001dD\"9At\u0019\u0001\u0005\u0002q%\u0007b\u0002Od\u0001\u0011\u0005A\u0014\u001b\u0005\b9\u000f\u0004A\u0011\u0001Oo\u0011\u001da:\r\u0001C\u00019K<q\u0001h;\u0001\u0011\u0003ajOB\u0004\u001dp\u0002A\t\u0001(=\t\u00111]\"R\u0006C\u00019gD\u0001\u0002d\u0011\u000b.\u0011\u0005AT\u001f\u0005\t#?Ri\u0003\"\u0001\u001d~\"9Q\u0014\u0001\u0001\u0005\u0002u\r\u0001bBO\u0005\u0001\u0011\u0005Q4\u0002\u0005\b;7\u0001A\u0011AO\u000f\u0011\u001di*\u0003\u0001C\u0001;OAq!(\f\u0001\t\u0003iz\u0003C\u0005\u001e8\u0001\u0011\r\u0011\"\u0003\u000e\u001e!YQ\u0014\b\u0001A\u0002\u0003\u0007I\u0011BO\u001e\u0011-i\u001a\u0005\u0001a\u0001\u0002\u0004%I!(\u0012\t\u0013u%\u0003\u00011A\u0005\n5u\u0001\"CO&\u0001\u0001\u0007I\u0011BO'\u0011\u001di\n\u0006\u0001C\u0003\u001b;Aq!h\u0015\u0001\t#i*F\u0002\u0004\u001eb\u0001\u0001Q4\r\u0005\f;KRiE!A!\u0002\u0013Yi\u0010C\u0006\u001eh)5#\u0011!Q\u0001\n-u\bbCO5\u0015\u001b\u0012\t\u0011)A\u0005\u0017{D1\"h\u001b\u000bN\t\u0005\t\u0015!\u0003\f~\"AAr\u0007F'\t\u0003ij\u0007\u0003\u0005\rD)5C\u0011AO=\r\u0019ij\b\u0001\u0001\u001e\u0000!YQt\rF.\u0005\u0003\u0005\u000b\u0011BF\u007f\u0011!a9Dc\u0017\u0005\u0002u\u0005\u0005\u0002\u0003G\"\u00157\"\t%h\"\b\u000fu-\u0005\u0001#\u0001\u001e\u000e\u001a9Qt\u0012\u0001\t\u0002uE\u0005\u0002\u0003G\u001c\u0015K\"\t!h%\b\u000fuU\u0005\u0001#\u0001\u001e\u0018\u001a9Q\u0014\u0014\u0001\t\u0002um\u0005\u0002\u0003G\u001c\u0015W\"\t!((\b\u000fu}\u0005\u0001#\u0001\u001e\"\u001a9Q4\u0015\u0001\t\u0002u\u0015\u0006\u0002\u0003G\u001c\u0015c\"\t!h*\t\u000fu%\u0006\u0001\"\u0001\u001e,\"9Q4\u0017\u0001\u0005\u0002uU\u0006bBO^\u0001\u0011\u0005QT\u0018\u0005\b;\u000f\u0004A\u0011AOe\u0011\u001di\u001a\u000e\u0001C\u0001;+Dq!h8\u0001\t\u0003i\n\u000fC\u0004\u001ef\u0002!\t!h:\t\u000fu-\b\u0001\"\u0001\u001en\"9Q\u0014\u001f\u0001\u0005\nuM\bbBO\u007f\u0001\u0011\u0005Qt \u0005\b=\u0007\u0001A\u0011\u0001P\u0003\u0011\u001dq\u001a\u0001\u0001C\u0001=\u0017AqAh\u0004\u0001\t\u0003q\n\u0002C\u0004\u001f\u0016\u0001!\tAh\u0006\t\u000fym\u0001\u0001\"\u0001\u001f\u001e!9aT\u0006\u0001\u0005\u0002y=\u0002b\u0002P\u001a\u0001\u0011\u0005aT\u0007\u0004\u0007={\u0001\u0001Ah\u0010\t\u00111]\"r\u0013C\u0001=+B\u0011B(\u0017\u0001\u0005\u0004%\tAh\u0017\u0007\ryu\u0003\u0001\u0001P0\u0011!a9D#(\u0005\u0002y\u0005\u0004b\u0002P3\u0001\u0011\u0005at\r\u0005\b=[\u0002A\u0011\u0002P8\u0011\u001dqJ\b\u0001C\u0005=wBqAh \u0001\t\u0013q\n\tC\u0004\u000eH\u0001!IAh\"\t\u000fy-\u0005\u0001\"\u0001\u001f\u000e\"9at\u0013\u0001\u0005\u0002ye\u0005b\u0002PO\u0001\u0011\u0005at\u0014\u0005\n=S\u0003\u0001\u0019!C\u0005\u001b;A\u0011Bh+\u0001\u0001\u0004%IA(,\t\u000fyE\u0006\u0001\"\u0001\u000e\u001e!9a4\u0017\u0001\u0005\u0002yU\u0006\"\u0003P]\u0001\t\u0007I\u0011\u0002P^\u0011\u001dq\u001a\r\u0001C\u0001=wCqA(2\u0001\t\u0003q:\rC\u0004\u001fL\u0002!\tA(4\t\u000fyE\u0007\u0001\"\u0001\u001fT\"9at\u001b\u0001\u0005\u0002ye\u0007b\u0002Po\u0001\u0011\u0005at\u001c\u0005\b=G\u0004A\u0011\u0001Ps\u0011\u001dqJ\u000f\u0001C\u0001=WDqAh<\u0001\t\u0013q\n\u0010C\u0004\u001fv\u0002!)Ah>\t\u000f}\u0015\u0001\u0001\"\u0003 \b!9q4\u0002\u0001\u0005\n}5\u0001bBP\t\u0001\u0011%q4\u0003\u0005\b?/\u0001A\u0011BP\r\u0011\u001dyj\u0002\u0001C\u0001??Aqah\t\u0001\t\u0003y*\u0003C\u0004 0\u0001!\ta(\r\t\u0013}=\u0002\u0001\"\u0005\f\u0012~e\u0002bBP'\u0001\u0011\u0015qt\n\u0005\n?3\u0002A\u0011CFI?7Bqa(\u001c\u0001\t\u0003yz\u0007C\u0004 z\u0001!\tah\u001f\t\u000f}}\u0004\u0001\"\u0001 \u0002\"9qt\u0011\u0001\u0005\u0006}%\u0005bBPO\u0001\u0011\u0015qt\u0014\u0005\n?S\u0003\u0011\u0013!C\u00035\u001fAqah+\u0001\t\u0003yj\u000bC\u0004 @\u0002!\ta(1\t\u000f}}\u0006\u0001\"\u0001 J\"9q4\u001b\u0001\u0005\u0002}U\u0007bBPm\u0001\u0011\u0005q4\u001c\u0004\u0007??\u0004\u0001a(9\t\u0017q\u0015$\u0012 BA\u0002\u0013\u0005q4\u001d\u0005\f?KTIP!a\u0001\n\u0003y:\u000fC\u0006 l*e(\u0011!Q!\nq\u001d\u0004bCM\\\u0015s\u0014)\u0019!C\u0001\u001b[C1b(<\u000bz\n\u0005\t\u0015!\u0003\u000e0\"AAr\u0007F}\t\u0003yz\u000f\u0003\u0005\r8)eH\u0011AP|\u0011!yZP#?\u0005F}uhA\u0002Q\u0002\u0001\u0001\u0003+\u0001C\u0006\rd.-!Q3A\u0005\u00021-\bbCIL\u0017\u0017\u0011\t\u0012)A\u0005\u0019?A\u0001\u0002d\u000e\f\f\u0011\u0005\u0001u\u0001\u0005\u000b#GYY!!A\u0005\u0002\u00016\u0001BCI\u0015\u0017\u0017\t\n\u0011\"\u0001\u00156\"QQ2\\F\u0006\u0003\u0003%\t%d3\t\u00155u72BA\u0001\n\u0003ii\u0002\u0003\u0006\u000e`.-\u0011\u0011!C\u0001A#A!\"d;\f\f\u0005\u0005I\u0011IGw\u0011)i9pc\u0003\u0002\u0002\u0013\u0005\u0001U\u0003\u0005\u000b\u001b7YY!!A\u0005BAu\bBCG\u007f\u0017\u0017\t\t\u0011\"\u0011!\u001a\u001dI\u0001U\u0004\u0001\u0002\u0002#\u0005\u0001u\u0004\u0004\nA\u0007\u0001\u0011\u0011!E\u0001ACA\u0001\u0002d\u000e\f(\u0011\u0005\u0001U\u0005\u0005\u000b\u001f+\\9#!A\u0005FAm\u0006B\u0003G\"\u0017O\t\t\u0011\"!!(!Q\u0011sLF\u0014\u0003\u0003%\t\ti\u000b\u0007\r\u0001>\u0002\u0001\u0001Q\u0019\u0011-a\u001al#\r\u0003\u0002\u0003\u0006I\u0001$\u0018\t\u00111]2\u0012\u0007C\u0001Ag1a\u0001)\u000f\u0001\u0001\u0001n\u0002bCM\\\u0017o\u0011\t\u0011)A\u0005\u001b_C\u0001\u0002d\u000e\f8\u0011\u0005\u0001U\b\u0005\t\u0019oY9\u0004\"\u0001!D!I\u0001\u0015\n\u0001A\u0002\u0013%QR\u0016\u0005\nA\u0017\u0002\u0001\u0019!C\u0005A\u001bBq\u0001)\u0015\u0001\t#ii\u000bC\u0004!T\u0001!\t\u0002)\u0016\t\u000f\u0001f\u0003\u0001\"\u0005!\\!9\u00015\u000f\u0001\u0005\u0002\u0001V\u0004b\u0002Q:\u0001\u0011\u0005\u0001u\u0010\u0005\bA\u0013\u0003A\u0011\u0001QF\u0011\u001d\u0001;\n\u0001C\u0001A3Cq\u0001)(\u0001\t\u0003\u0001{\nC\u0004!$\u0002!)\u0001)*\t\u000f\u0001&\u0006\u0001\"\u0001!,\"9\u0001u\u0016\u0001\u0005\u0002\u0001F\u0006b\u0002Q[\u0001\u0011\u0005\u0001u\u0017\u0005\bAw\u0003A\u0011\u0001Q_\u0011\u001d\u0001;\r\u0001C\u0001A\u0013D\u0011\u0002i4\u0001\u0005\u0004%\t\u0001)5\t\u0017\u0001V\u0007A1A\u0005\u0002-e\u0005u\u001b\u0005\fAK\u0004!\u0019!C\u0001\u00173\u0003;\u000fC\u0006!j\u0002\u0011\r\u0011\"\u0001\f\u001a\u0002\u001e\bb\u0002Qv\u0001\u0011\u0005\u0001U\u001e\u0005\nAc\u0004A\u0011AFMAgDq\u0001i>\u0001\t\u0013\u0001K\u0010C\u0005!\u0000\u0002\u0011\r\u0011b\u0001\"\u0002!I\u00115\u0002\u0001C\u0002\u0013\r\u0011U\u0002\u0005\nC#\u0001!\u0019!C\u0002C'A\u0011\"i\u0006\u0001\u0005\u0004%\u0019!)\u0007\t\u0013\u0005v\u0001A1A\u0005\u0004\u0005~\u0001\"CQ\u0012\u0001\t\u0007I1AQ\u0013\u0011%\tK\u0003\u0001b\u0001\n\u0007\t[\u0003C\u0005\"0\u0001\u0011\r\u0011b\u0001\"2!I\u0011U\u0007\u0001C\u0002\u0013\r\u0011u\u0007\u0005\nCw\u0001!\u0019!C\u0002C{A\u0011\")\u0011\u0001\u0005\u0004%\u0019!i\u0011\t\u0013\u0005\u001e\u0003A1A\u0005\u0004\u0005&\u0003\"CQ'\u0001\t\u0007I1AQ(\u0011%\t\u001b\u0006\u0001b\u0001\n\u0007\t+\u0006C\u0005\"Z\u0001\u0011\r\u0011b\u0001\"\\!I\u0011u\f\u0001C\u0002\u0013\r\u0011\u0015\r\u0005\nCK\u0002!\u0019!C\u0002CO\u0012Q\u0001V=qKNTAac%\f\u0016\u0006A\u0011N\u001c;fe:\fGN\u0003\u0003\f\u0018.e\u0015a\u0002:fM2,7\r\u001e\u0006\u0003\u00177\u000bQa]2bY\u0006\u001c\u0001aE\u000b\u0001\u0017C[Ikc-\f@.\u001572ZFi\u0017/\\inc9\u0011\t-\r6RU\u0007\u0003\u00173KAac*\f\u001a\n1\u0011I\\=SK\u001a\u0004Bac+\f26\u00111R\u0016\u0006\u0005\u0017_[)*A\u0002ba&LAac$\f.B!1RWF^\u001b\tY9L\u0003\u0003\f:.E\u0015a\u0001;qK&!1RXF\\\u00055!\u0016\u0010]3D_6\u0004\u0018M]3sgB!1RWFa\u0013\u0011Y\u0019mc.\u0003\u001bQK\b/\u001a+p'R\u0014\u0018N\\4t!\u0011Y)lc2\n\t-%7r\u0017\u0002\r\u0007>lWn\u001c8Po:,'o\u001d\t\u0005\u0017k[i-\u0003\u0003\fP.]&aB$mE2+(m\u001d\t\u0005\u0017k[\u0019.\u0003\u0003\fV.]&\u0001\u0003+za\u0016l\u0015\r]:\u0011\t-U6\u0012\\\u0005\u0005\u00177\\9LA\bUsB,7i\u001c8tiJ\f\u0017N\u001c;t!\u0011Y)lc8\n\t-\u00058r\u0017\u0002\f\r&tG-T3nE\u0016\u00148\u000f\u0005\u0003\ff.-XBAFt\u0015\u0011YIo#%\u0002\tU$\u0018\u000e\\\u0005\u0005\u0017[\\9OA\u0006D_2dWm\u0019;j_:\u001c\u0018A\u0002\u0013j]&$H\u0005\u0006\u0002\ftB!12UF{\u0013\u0011Y9p#'\u0003\tUs\u0017\u000e^\u0001\u000eKb\u0004H.Y5o'^LGo\u00195\u0016\u0005-u\b\u0003BFR\u0017\u007fLA\u0001$\u0001\f\u001a\n9!i\\8mK\u0006t\u0017!E3ya2\f\u0017N\\*xSR\u001c\u0007n\u0018\u0013fcR!12\u001fG\u0004\u0011%aIaAA\u0001\u0002\u0004Yi0A\u0002yIE\na\"Z7qif\u001c\u00160\u001c2pYN+G/\u0006\u0002\r\u0010A1A\u0012\u0003G\u000e\u0019?i!\u0001d\u0005\u000b\t1UArC\u0001\nS6lW\u000f^1cY\u0016TA\u0001$\u0007\f\u001a\u0006Q1m\u001c7mK\u000e$\u0018n\u001c8\n\t1uA2\u0003\u0002\u0004'\u0016$\b\u0003\u0002G\u0011\u0019Gi\u0011\u0001A\u0005\u0005\u0019Ka9C\u0001\u0004Ts6\u0014w\u000e\\\u0005\u0005\u0019SY\tJA\u0004Ts6\u0014w\u000e\\:\u0002EA\u0014x\u000e]1hCR,\u0007+\u0019:b[\u0016$XM\u001d\"pk:$7\u000fV8UsB,g+\u0019:t\u00039\u0019\b.\u0019:qKJ\u001c6n\u001c7f[N\f\u0011c];cgR$\u0016\u0010]3NCB\u001c\u0015m\u00195f!\ra\t\u0003\u0003\u0002\u0012gV\u00147\u000f\u001e+za\u0016l\u0015\r]\"bG\",7c\u0001\u0005\f\"\u00061A(\u001b8jiz\"\"\u0001$\r\u0002\r\r\f7\r[3e!\u0011a\t\u0003d\u0010\n\t1\u000532\u001b\u0002\r'V\u00147\u000f\u001e+za\u0016l\u0015\r]\u0001\u0006CB\u0004H.\u001f\u000b\u0007\u0019{a9\u0005$\u0017\t\u000f1%3\u00021\u0001\rL\u0005!aM]8n!\u0019ai\u0005d\u0015\r 9!12\u0015G(\u0013\u0011a\tf#'\u0002\u000fA\f7m[1hK&!AR\u000bG,\u0005\u0011a\u0015n\u001d;\u000b\t1E3\u0012\u0014\u0005\b\u00197Z\u0001\u0019\u0001G/\u0003\t!x\u000e\u0005\u0004\rN1MCr\f\t\u0004\u0019C\u0001'\u0001\u0002+za\u0016\u001cR\u0001\u0019G3\u0019k\u00032\u0001$\tV\u0005-!\u0016\u0010]3Ba&LU\u000e\u001d7\u0014\u0007UcY\u0007\u0005\u0003\r\"15\u0014\u0002\u0002G8\u0017c\u0013q\u0001V=qK\u0006\u0003\u0018\u000e\u0006\u0002\rf\u0005YA-Z2mCJ\fG/[8o)\u0011ay\u0002d\u001e\t\u000f1et\u000b1\u0001\r|\u0005!a.Y7f!\u0011a\t\u0003$ \n\t1}D\u0012\u0011\u0002\u0005\u001d\u0006lW-\u0003\u0003\r\u0004.E%!\u0002(b[\u0016\u001c\u0018\u0001\u00043fG2\f'/\u0019;j_:\u001cXC\u0001GE!\u0011a\t\u0003d#\n\t15Er\u0012\u0002\u0006'\u000e|\u0007/Z\u0005\u0005\u0019#[\tJ\u0001\u0004TG>\u0004Xm]\u0001\u000eif\u0004X-\u0011:hk6,g\u000e^:\u0016\u00051u\u0013aB3sCN,(/Z\u000b\u0003\u0019?\n\u0011c];cgRLG/\u001e;f'fl'm\u001c7t)\u0019ay\u0006d(\r\"\"9A\u0012J.A\u00021-\u0003b\u0002G.7\u0002\u0007A2J\u0001\u0010gV\u00147\u000f^5ukR,G+\u001f9fgR1Ar\fGT\u0019SCq\u0001$\u0013]\u0001\u0004aY\u0005C\u0004\r\\q\u0003\r\u0001$\u0018\u0002\u0019%\u001c8\u000b\u001d7jG\u0016\f'\r\\3\u0002\u0013\r|W\u000e]1oS>t\u0017A\u00039be\u0006lG*[:ugV\u0011A2\u0017\t\u0007\u0019\u001bb\u0019\u0006d\u0013\u0011\r1\u0005Br\u0017G0\u0013\u0011aI\fd/\u0003\u0017\u0005sgn\u001c;bi\u0006\u0014G.Z\u0005\u0005\u0019{[\tJA\bB]:|G/\u0019;j_:LeNZ8t)\tay&A\u0005jgR\u0013\u0018N^5bY\u0006q\u0011n\u001d%jO\",'oS5oI\u0016$\u0017!\u0004;bW\u0016\u001cH+\u001f9f\u0003J<7/\u0001\u0005jgN#\u0018M\u00197f\u0003)I7OV8mCRLG.Z\u0001\u0017SN\u001cFO];diV\u0014\u0018\r\u001c*fM&tW-\\3oi\u00061\u0012n]%n[\u0016$\u0017.\u0019;fYf$U\r]3oI\u0016tG/A\u000bjg\u0012+\u0007/\u001a8eK:$X*\u001a;i_\u0012$\u0016\u0010]3\u0002\u0015%\u001cx+\u001b7eG\u0006\u0014H-A\u0004jg\u0016\u0013(o\u001c:\u0002\u0017%\u001cXI\u001d:p]\u0016|Wo]\u0001\fSN4\u0015N\\1m)f\u0004X-\u0001\u0006jg\u000e{W\u000e\u001d7fi\u0016\f\u0011#[:TQ><\u0018i]%oM&DH+\u001f9f\u0003!\u0019w.\u001c9mKR,G\u0003BFz\u0019CDq\u0001d9q\u0001\u0004ay\"A\u0002ts6\fqCZ8sG\u0016$\u0015N]3diN+\b/\u001a:dY\u0006\u001c8/Z:\u0016\u0005-M\u0018A\u0003;fe6\u001c\u00160\u001c2pYV\u0011ArD\u0001\u000bif\u0004XmU=nE>d\u0017\u0001\u0005;fe6\u001c\u00160\u001c2pY\u0012K'/Z2u\u0003A!\u0018\u0010]3Ts6\u0014w\u000e\u001c#je\u0016\u001cG/\u0001\u0006v]\u0012,'\u000f\\=j]\u001e\fQa^5eK:\fq\u0001Z3d_:\u001cH/\u0001\u0006usB,wJ\u001a+iSN\faA\\1se><\u0018A\u00022pk:$7/\u0006\u0002\u000e\u0002A!A\u0012EB)\u0005)!\u0016\u0010]3C_VtGm]\n\u000b\u0007#j9!d \u000e\u00145\u0015\u0005\u0003\u0002G\u0011\u0003'\u0014qaU;c)f\u0004Xm\u0005\u0003\u0002T65\u0001\u0003\u0002G\u0011\u0003\u0013\u0014!\"\u00168jcV,G+\u001f9f'\u0019\tI\rd\u0018\u000e\u0014A!12UG\u000b\u0013\u0011i9b#'\u0003\u000fA\u0013x\u000eZ;diR\u0011QRB\u0001\tQ\u0006\u001c\bnQ8eKV\u0011Qr\u0004\t\u0005\u0017Gk\t#\u0003\u0003\u000e$-e%aA%oi\u0006I\u0001.Y:i\u0007>$W\rI\u0001\u0010G>l\u0007/\u001e;f\u0011\u0006\u001c\bnQ8eKR\u0011QrA\u0001\ngV\u0004XM\u001d;za\u0016\fq\u0001]1sK:$8/A\u0003eK\u000ed7/\u0001\u0005cCN,G+\u001f9f)\u0011ay&$\u000e\t\u00115]\u0012Q\u001ca\u0001\u0019?\tQa\u00197buj\f1BY1tKRK\b/Z*fcV\u0011QR\b\t\u0005\u0019Ciy$\u0003\u0003\u000eB5\r#a\u0003\"bg\u0016$\u0016\u0010]3TKFLA!$\u0012\f\u0012\na!)Y:f)f\u0004XmU3rg\u0006\u0001\"-Y:f)f\u0004XmU3r\t\u0016\u0004H\u000f[\u000b\u0003\u001b\u0017\u0002B!$\u0014\u000eP5\u00111\u0012S\u0005\u0005\u001b#Z\tJA\u0003EKB$\b.A\u0006cCN,7\t\\1tg\u0016\u001cXC\u0001G&\u0003%\u0011w.\u001e8e'fl7/\u0006\u0002\u000e\\A1QRLG6\u0019?qA!d\u0018\u000ehA!Q\u0012MFM\u001b\ti\u0019G\u0003\u0003\u000ef-u\u0015A\u0002\u001fs_>$h(\u0003\u0003\u000ej-e\u0015A\u0002)sK\u0012,g-\u0003\u0003\r\u001e55$\u0002BG5\u00173C\u0003\"!:\u000er5]T2\u0010\t\u0005\u0017Gk\u0019(\u0003\u0003\u000ev-e%A\u00033faJ,7-\u0019;fI\u0006\u0012Q\u0012P\u0001.\u001d>\u0004Cn\u001c8hKJ\u0004So]3eA%t\u0007\u0005\u001e5fA\r|W\u000e]5mKJ\u0004\u0013.\u001c9mK6,g\u000e^1uS>t\u0017EAG?\u0003\u0019\u0011d&\r\u001a/gA!A\u0012EGA\u0013\u0011i\u0019i#-\u0003\u001bQK\b/\u001a\"pk:$7/\u00119j!\u0011Y\u0019+d\"\n\t5%5\u0012\u0014\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0003Y>\f1\u0001\\8!\u0003\tA\u0017.A\u0002iS\u0002\"b!$\u0001\u000e\u00166]\u0005\u0002CGF\u00077\u0002\r\u0001d\u0018\t\u00115=51\fa\u0001\u0019?\n!\"\u001e9qKJ\u0014u.\u001e8e\u0003)awn^3s\u0005>,h\u000eZ\u0001\rG>tG/Y5ogRK\b/\u001a\u000b\u0005\u0017{l\t\u000b\u0003\u0005\u000e$\u000e\u001d\u0004\u0019\u0001G0\u0003\u0011!\b.\u0019;\u0002\u001f\u0015l\u0007\u000f^=M_^,'OQ8v]\u0012\fq\"Z7qif,\u0006\u000f]3s\u0005>,h\u000eZ\u0001\u000eSN,U\u000e\u001d;z\u0005>,h\u000eZ:\u0002\u0019M\fg-\u001a+p'R\u0014\u0018N\\4\u0016\u00055=\u0006\u0003BG/\u001bcKA!d-\u000en\t11\u000b\u001e:j]\u001e\fQb]2bY\u0006tu\u000e^1uS>tG\u0003BGX\u001bsC\u0001\"d/\u0004r\u0001\u0007QRX\u0001\u000bif\u0004Xm\u0015;sS:<\u0007\u0003CFR\u001b\u007fcy&d,\n\t5\u00057\u0012\u0014\u0002\n\rVt7\r^5p]F\nAb\u001d;be:{G/\u0019;j_:$B!d,\u000eH\"AQ2XB:\u0001\u0004ii,\u0001\u0003lS:$WCAGg!\u0011iy-$7\u000e\u00055E'\u0002BGj\u001b+\fA\u0001\\1oO*\u0011Qr[\u0001\u0005U\u00064\u0018-\u0003\u0003\u000e46E\u0017!\u00049s_\u0012,8\r\u001e)sK\u001aL\u00070\u0001\u0007qe>$Wo\u0019;Be&$\u00180\u0001\bqe>$Wo\u0019;FY\u0016lWM\u001c;\u0015\t5\rX\u0012\u001e\t\u0005\u0017Gk)/\u0003\u0003\u000eh.e%aA!os\"QA\u0012BB>\u0003\u0003\u0005\r!d\b\u0002\u001fA\u0014x\u000eZ;di&#XM]1u_J,\"!d<\u0011\r5EX2_Gr\u001b\ta9\"\u0003\u0003\u000ev2]!\u0001C%uKJ\fGo\u001c:\u0002\u0011\r\fg.R9vC2$Ba#@\u000e|\"QA\u0012BB@\u0003\u0003\u0005\r!d9\u0002\r\u0015\fX/\u00197t)\u0011YiP$\u0001\t\u00151%1\u0011QA\u0001\u0002\u0004i\u0019/A\u0006gSJ\u001cH\u000fU1sK:$\u0018A\u00029sK\u001aL\u00070A\u0006qe\u00164\u0017\u000e_\"iC&t\u0017a\u0004;za\u0016\u001cuN\\:ueV\u001cGo\u001c:\u0002\u0011QL\b/Z!sON\f\u0011\u0002Z;n[f\f%oZ:\u0002\u0015I,7/\u001e7u)f\u0004X\r\u0006\u0003\r`9M\u0001\u0002\u0003H\u000b\u0003\u001b\u0001\r\u0001$\u0018\u0002\u000f\u0005\u001cG/^1mg\u0006a!/Z:vYR\f\u0005\u000f\u001d:pq\u0006ya-\u001b8bYJ+7/\u001e7u)f\u0004X-A\tqCJ\fWnU3di&|gnQ8v]R\fq\u0001]1sC6\u001c8/\u0001\u0004qCJ\fWn]\u0001\u000ba\u0006\u0014\u0018-\u001c+za\u0016\u001c\u0018A\u0003;za\u0016\u0004\u0016M]1ng\"B\u0011QDG9\u001bojY(A\u000bj]N$\u0018M\u001c;jCR,G+\u001f9f!\u0006\u0014\u0018-\\:\u0015\r1}c2\u0006H\u0018\u0011!qi#a\bA\u00021-\u0013a\u00024pe6\fGn\u001d\u0005\t\u001d+\ty\u00021\u0001\r^\u0005!2o[8mK6L'0Z#ySN$XM\u001c;jC2$b\u0001d\u0018\u000f69e\u0002\u0002\u0003H\u001c\u0003C\u0001\r\u0001d\b\u0002\u000b=<h.\u001a:\t\u00119m\u0012\u0011\u0005a\u0001\u0017C\u000baa\u001c:jO&t\u0017!\u00038pe6\fG.\u001b>f\u0003%)G/Y#ya\u0006tG-A\u0004eK\u0006d\u0017.Y:\u0002\u0019\u0011,\u0017\r\\5bg^KG-\u001a8\u0002#\u0011,\u0017\r\\5bg^KG-\u001a8DQ\u0006Lg.\u0001\u0006cKR\f'+\u001a3vG\u0016\fA\u0001Z3dYR!Ar\u0004H'\u0011!aI(a\rA\u00021m\u0014a\u00048p]B\u0013\u0018N^1uK\u0012+7\r\\:\u0002\u001d9|g\u000e\u0015:jm\u0006$X\rR3dYR!Ar\u0004H+\u0011!aI(a\u000eA\u00021m\u0014aB7f[\n,'o]\u0001\u0012]>t\u0007K]5wCR,W*Z7cKJ\u001c\u0018A\u00078p]B\u0013\u0018N^1uK6+WNY3sg\u0006#W.\u001b;uS:<G\u0003\u0002GE\u001d?B\u0001B$\u0019\u0002>\u0001\u0007a2M\u0001\u0006C\u0012l\u0017\u000e\u001e\t\u0005\u0017Gs)'\u0003\u0003\u000fh-e%\u0001\u0002'p]\u001e\fq\"[7qY&\u001c\u0017\u000e^'f[\n,'o]\u0001\u0010I\u00164WM\u001d:fI6+WNY3sg\u00061Q.Z7cKJ$B\u0001d\b\u000fr!AA\u0012PA\"\u0001\u0004aY(\u0001\to_:\u0004&/\u001b<bi\u0016lU-\u001c2feR!Ar\u0004H<\u0011!aI(!\u0012A\u00021m\u0014a\u00055bg:{g\u000e\u0015:jm\u0006$X-T3nE\u0016\u0014H\u0003BF\u007f\u001d{B\u0001\u0002$\u001f\u0002H\u0001\u0007A2P\u0001\u000ea\u0006\u001c7.Y4f\u001f\nTWm\u0019;\u000239|g\u000e\u0015:jm\u0006$X-T3nE\u0016\u0014\u0018\tZ7jiRLgn\u001a\u000b\u0007\u0019?q)Id\"\t\u00111e\u00141\na\u0001\u0019wB\u0001B$\u0019\u0002L\u0001\u0007a2M\u0001\u000f]>tGj\\2bY6+WNY3s)\u0011ayB$$\t\u00111e\u0014Q\na\u0001\u0019w\n1#\\3nE\u0016\u00148OQ1tK\u0012|eN\u00127bON$b\u0001$#\u000f\u0014:]\u0005\u0002\u0003HK\u0003\u001f\u0002\rAd\u0019\u0002\u001b\u0015D8\r\\;eK\u00124E.Y4t\u0011!qI*a\u0014A\u00029\r\u0014!\u0004:fcVL'/\u001a3GY\u0006<7/A\tnK6\u0014WM\u001d\"bg\u0016$wJ\u001c(b[\u0016$b\u0001d\b\u000f :\u0005\u0006\u0002\u0003G=\u0003#\u0002\r\u0001d\u001f\t\u00119U\u0015\u0011\u000ba\u0001\u001dG\"B\u0001d\u0018\u000f&\"AQrGA*\u0001\u0004ay\"\u0001\u0006bgN+WM\u001c$s_6$b\u0001d\u0018\u000f,:=\u0006\u0002\u0003HW\u0003+\u0002\r\u0001d\u0018\u0002\u0007A\u0014X\r\u0003\u0005\u000e8\u0005U\u0003\u0019\u0001G\u0010\u0003)iW-\u001c2fe&sgm\u001c\u000b\u0005\u0019?r)\f\u0003\u0005\rd\u0006]\u0003\u0019\u0001G\u0010\u0003)iW-\u001c2feRK\b/\u001a\u000b\u0005\u0019?rY\f\u0003\u0005\rd\u0006e\u0003\u0019\u0001G\u0010\u0003E\u0019w.\u001c9vi\u0016lU-\u001c2feRK\b/\u001a\u000b\u0005\u0019?r\t\r\u0003\u0005\rd\u0006m\u0003\u0019\u0001G\u0010\u0003\u0015\u0019XOY:u)\u0019ayFd2\u000fJ\"AA\u0012JA/\u0001\u0004aY\u0005\u0003\u0005\r\\\u0005u\u0003\u0019\u0001G/\u0003!\u0019XOY:u'flGC\u0002G0\u001d\u001ft\t\u000e\u0003\u0005\rJ\u0005}\u0003\u0019\u0001G&\u0011!aY&a\u0018A\u00021-\u0013!C:vEN$H\u000b[5t)\u0019ayFd6\u000fZ\"AA\u0012JA1\u0001\u0004ay\u0002\u0003\u0005\r\\\u0005\u0005\u0004\u0019\u0001G0)\u0019ayF$8\u000f`\"AA\u0012JA2\u0001\u0004ay\u0002\u0003\u0005\r\\\u0005\r\u0004\u0019\u0001G\u0010\u0003=\u0019XOY:u)\"L7/\u00118e'flGC\u0003G0\u001dKt9O$;\u000fn\"AA\u0012JA3\u0001\u0004ay\u0002\u0003\u0005\r\\\u0005\u0015\u0004\u0019\u0001G0\u0011!qY/!\u001aA\u00021-\u0013\u0001C:z[N4%o\\7\t\u00119=\u0018Q\ra\u0001\u0019\u0017\naa]=ngR{\u0017AC<ji\"4\u0015\u000e\u001c;feR!aR_H\u001d!\u0011q90!\u001b\u000e\u0003\u0001\u0014\u0001CR5mi\u0016\u0014X*\u00199G_J,\u0017m\u00195\u0014\t\u0005%dR \t\u0005\u0019Cqy0\u0003\u0003\u0010\u0002-M'a\u0005$jYR,'\u000fV=qK\u000e{G\u000e\\3di>\u0014\u0018!\u00019\u0011\u0011-\rVr\u0018G0\u0017{$BA$>\u0010\n!Aq2AA7\u0001\u0004y)!A\u0004g_J,\u0017m\u00195\u0016\t==q2\u0004\u000b\u0005\u0017g|\t\u0002\u0003\u0005\u0010\u0014\u0005=\u0004\u0019AH\u000b\u0003\u00051\u0007\u0003CFR\u001b\u007fcyfd\u0006\u0011\t=eq2\u0004\u0007\u0001\t!yi\"a\u001cC\u0002=}!!A+\u0012\t=\u0005R2\u001d\t\u0005\u0017G{\u0019#\u0003\u0003\u0010&-e%a\u0002(pi\"LgnZ\u0001\u0004[\u0006\u0004X\u0003BH\u0016\u001fc!Ba$\f\u00106A1AR\nG*\u001f_\u0001Ba$\u0007\u00102\u0011Aq2GA9\u0005\u0004yyBA\u0001U\u0011!y\u0019\"!\u001dA\u0002=]\u0002\u0003CFR\u001b\u007fcyfd\f\t\u0011=\r\u0011q\ra\u0001\u001f\u000b\taa\u001c:FYN,G\u0003\u0002G0\u001f\u007fA\u0011b$\u0011\u0002t\u0011\u0005\rad\u0011\u0002\u0007\u0005dG\u000f\u0005\u0004\f$>\u0015CrL\u0005\u0005\u001f\u000fZIJ\u0001\u0005=Eft\u0017-\\3?Q\u0011\t\u0019hd\u0013\u0011\t-\rvRJ\u0005\u0005\u001f\u001fZIJ\u0001\u0004j]2Lg.Z\u0001\u0005M&tG\r\u0006\u0003\u0010V=m\u0003CBFR\u001f/by&\u0003\u0003\u0010Z-e%AB(qi&|g\u000e\u0003\u0005\u0010\u0004\u0005U\u0004\u0019AH\u0003)\u0011Y\u0019pd\u0018\t\u0011=M\u0011q\u000fa\u0001\u001fC\u0002\u0002bc)\u000e@2}32_\u0001\bG>dG.Z2u+\u0011y9g$\u001c\u0015\t=%tr\u000e\t\u0007\u0019\u001bb\u0019fd\u001b\u0011\t=eqR\u000e\u0003\t\u001fg\tIH1\u0001\u0010 !Aq\u0012OA=\u0001\u0004y\u0019(\u0001\u0002qMBA12UH;\u0019?zY'\u0003\u0003\u0010x-e%a\u0004)beRL\u0017\r\u001c$v]\u000e$\u0018n\u001c8\u0015\t1}s2\u0010\u0005\t\u001f'\tY\b1\u0001\u0010~AA12UG`\u0019?by&\u0001\u0004fq&\u001cHo\u001d\u000b\u0005\u0017{|\u0019\t\u0003\u0005\u0010\u0004\u0005u\u0004\u0019AH\u0003\u0003!\u0019wN\u001c;bS:\u001cH\u0003BF\u007f\u001f\u0013C\u0001\u0002d9\u0002\u0000\u0001\u0007ArD\u0001\u0011I1,7o\u001d\u0013d_2|g\u000e\n7fgN$Ba#@\u0010\u0010\"AQ2UAA\u0001\u0004ay&\u0001\bnCR\u001c\u0007.Z:QCR$XM\u001d8\u0015\t-uxR\u0013\u0005\t\u001bG\u000b\u0019\t1\u0001\r`\u0005)2\u000f^1u?\u0012bWm]:%G>dwN\u001c\u0013mKN\u001cH\u0003BF\u007f\u001f7C\u0001\"d)\u0002\u0006\u0002\u0007ArL\u0001\u0016o\u0016\f7n\u0018\u0013mKN\u001cHeY8m_:$C.Z:t)\u0011Yip$)\t\u00115\r\u0016q\u0011a\u0001\u0019?\nA\u0002J3rI\r|Gn\u001c8%KF$Ba#@\u0010(\"AQ2UAE\u0001\u0004ay&A\u0004nCR\u001c\u0007.Z:\u0015\t-uxR\u0016\u0005\t\u001bG\u000bY\t1\u0001\r`\u0005qAn\\8tK2LX*\u0019;dQ\u0016\u001cH\u0003BF\u007f\u001fgC\u0001\"d)\u0002\u000e\u0002\u0007ArL\u0001\u000eE\u0006\u001cX\rV=qK&sG-\u001a=\u0015\t5}q\u0012\u0018\u0005\t\u0019G\f)\n1\u0001\r \u0005I1\r\\8oK&sgm\u001c\u000b\u0005\u0019?zy\f\u0003\u0005\u000f8\u0005]\u0005\u0019\u0001G\u0010\u0003\u001d\tGoT<oKJ$B\u0001d\u0018\u0010F\"AarGAM\u0001\u0004ay\"\u0001\u0007pE*,7\r\u001e)sK\u001aL\u00070A\u0007qC\u000e\\\u0017mZ3Qe\u00164\u0017\u000e_\u0001\u000biJLW\u000e\u0015:fM&DH\u0003BGg\u001f\u001fD\u0001b$5\u0002 \u0002\u0007QrV\u0001\u0004gR\u0014\u0018\u0001\u00049sK\u001aL\u0007p\u0015;sS:<\u0017\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u00055=\u0016\u0001\u0004;p\u0019>twm\u0015;sS:<\u0017A\u00053je\u0016\u001cGo\u00142kK\u000e$8\u000b\u001e:j]\u001e\f\u0011C\\1nK\u0006sG-\u0011:hgN#(/\u001b8h\u0003\u0015I7/\u00118z\u0003%I7OT8uQ&tw-\u0001\u0005jg\u001e\u0013x.\u001e8e\u0003\u0011aw.\u00193\u0015\t-Mx\u0012\u001e\u0005\t\u0019G\f\u0019\f1\u0001\r \u0005Aa-\u001b8e\t\u0016\u001cG\u000e\u0006\u0004\r ==x\u0012\u001f\u0005\t\u0019s\n)\f1\u0001\r|!AaRSA[\u0001\u0004iy\"A\u0006gS:$W*Z7cKJ\u001cHC\u0002GE\u001fo|I\u0010\u0003\u0005\u000f\u0016\u0006]\u0006\u0019\u0001H2\u0011!qI*a.A\u00029\r\u0014A\u00034j]\u0012lU-\u001c2feRQArDH\u0000!\u0003\u0001\u001a\u0001%\u0002\t\u00111e\u0014\u0011\u0018a\u0001\u0019wB\u0001B$&\u0002:\u0002\u0007a2\r\u0005\t\u001d3\u000bI\f1\u0001\u000fd!A\u0001sAA]\u0001\u0004Yi0\u0001\u0006ti\u0006\u0014G.Z(oYf\fQd]6pY\u0016l7/\u0012=dKB$X*\u001a;i_\u0012$\u0016\u0010]3QCJ\fWn]\u0001\fC:tw\u000e^1uS>t7/\u0006\u0002\u0011\u0010A1AR\nG*!#\u0001B\u0001$\t\u0011\u0014%!\u0001S\u0003G^\u00059\teN\\8uCRLwN\\%oM>\f!c^5uQ>,H/\u00118o_R\fG/[8og\u0006\tb-\u001b7uKJ\feN\\8uCRLwN\\:\u0015\t1}\u0003S\u0004\u0005\t\u001f\u0007\t\t\r1\u0001\u0011 AA12UG`!#Yi0\u0001\btKR\feN\\8uCRLwN\\:\u0015\t1}\u0003S\u0005\u0005\t!O\t\u0019\r1\u0001\u0011\u0010\u00051\u0011M\u001c8piN\fqb^5uQ\u0006sgn\u001c;bi&|gn\u001d\u000b\u0005\u0019?\u0002j\u0003\u0003\u0005\u0011(\u0005\u0015\u0007\u0019\u0001I\b\u0003My6o[8mK6L'0\u0019;j_:dUM^3m\u0003]y6o[8mK6L'0\u0019;j_:dUM^3m?\u0012*\u0017\u000f\u0006\u0003\ftBU\u0002\"\u0003G\u0005\u001b\u0005\u0005\t\u0019AG\u0010\u0003I\u00198n\u001c7f[&T\u0018\r^5p]2+g/\u001a7\u0002-M\\w\u000e\\3nSj\fG/[8o\u0019\u00164X\r\\0%KF$Bac=\u0011>!9\u0001sH\bA\u00025}\u0011!\u0002<bYV,\u0017\u0001F0j]R,'o]3di&|gnV5u]\u0016\u001c8/\u0006\u0002\u0011FAA\u0001s\tI'\u0019;\u0002\n&\u0004\u0002\u0011J)!\u00013\nG\f\u0003\u001diW\u000f^1cY\u0016LA\u0001e\u0014\u0011J\tYq+Z1l\u0011\u0006\u001c\b.T1q!\u0019\u0001\u001a\u0006%\u0017\r`5\u0011\u0001S\u000b\u0006\u0005!/ZI*A\u0002sK\u001aLA\u0001e\u0017\u0011V\tiq+Z1l%\u00164WM]3oG\u0016\f1#\u001b8uKJ\u001cXm\u0019;j_:<\u0016\u000e\u001e8fgN\u0014qbU5na2,G+\u001f9f!J|\u00070_\n\u0004%1}\u0003fB\u0011\u000er5]T2\u0010\u000b\u0005\u0019?\u0002:\u0007C\u0004\u000e81\u0002\r\u0001d\b\u0003'I+wO]1qa&tw\rV=qKB\u0013x\u000e_=\u0014\u000bAby\u0006%\u001c\u0011\u00071\u0005\"#A\u0006nCf\u0014WMU3xe\u0006\u0004H\u0003\u0002G0!gBq\u0001%\u001e3\u0001\u0004ay&A\u0003oK^$\b/\u0001\u0004sK^\u0014\u0018\r\u001d\u000b\u0005\u0019?\u0002Z\bC\u0004\u0011vM\u0002\r\u0001d\u0018\u0015\t1}\u0003s\u0010\u0005\b\u001d+A\u0004\u0019\u0001G/)\u0019ay\u0006e!\u0011\u0006\"9aR\u0006 A\u00021-\u0003b\u0002H\u000b}\u0001\u0007AR\f\u000b\u0007\u0019?\u0002J\te#\t\u000f9]r\b1\u0001\r !9a2H A\u0002-\u0005F\u0003\u0002G0!\u001fCqAd\u000eD\u0001\u0004ay\u0002\u0006\u0003\r`AM\u0005b\u0002H\u001c\t\u0002\u0007Ar\u0004\u000b\u0005\u0017g\u0004:\nC\u0004\rd\u001e\u0003\r\u0001d\b\u0015\t-M\b3\u0014\u0005\b\u0019GD\u0005\u0019\u0001G\u0010)\u0011ay\u0006e(\t\u000fA\u001d\u0012\n1\u0001\u0011\u0010\u0005qQK\\7baB\f'\r\\3Ue\u0016,\u0007c\u0001G\u0011\u0019\nqQK\\7baB\f'\r\\3Ue\u0016,7#\u0003'\u0011*BMV2CGC!\u0011a\t\u0003e+\n\tA5\u0006s\u0016\u0002\u0005)J,W-\u0003\u0003\u00112.E%!\u0002+sK\u0016\u001c\b\u0003\u0002G\u0011!kKA\u0001e.\u00110\nAA+\u001a:n)J,W\r\u0006\u0002\u0011$R\u0011QRZ\u0001\biB,w\fJ3r)\u0011Y\u0019\u0010%1\t\u000fA\rw\n1\u0001\r`\u0005\tA\u000f\u0006\u0003\u000edB\u001d\u0007\"\u0003G\u0005%\u0006\u0005\t\u0019AG\u0010)\u0011Yi\u0010e3\t\u00131%A+!AA\u00025\r(!D*j]\u001edW\r^8o)f\u0004Xm\u0005\u0005\u0002h6\u001d\u0001S\u000eIi!\u0011a\t\u0003e5\n\tAU7\u0012\u0017\u0002\u0011'&tw\r\\3u_:$\u0016\u0010]3Ba&$\"\u0001%7\u0011\t1\u0005\u0012q\u001d\u0015\t\u0003gl\t(d\u001e\u000e|\u0005IQI\u001d:peRK\b/\u001a\t\u0005\u0019C\t9PA\u0005FeJ|'\u000fV=qKNA\u0011q\u001fG0\u001b'i)\t\u0006\u0002\u0011`RQAr\u0004Iu!W\u0004j\u000fe<\t\u00111e\u0014q a\u0001\u0019wB\u0001B$&\u0002\u0000\u0002\u0007a2\r\u0005\t\u001d3\u000by\u00101\u0001\u000fd!A\u0001sAA\u0000\u0001\u0004Yi\u0010\u0006\u0003\r`AM\b\u0002CG\u001c\u0005\u0003\u0001\r\u0001d\b\u0015\t5\r\bs\u001f\u0005\u000b\u0019\u0013\u0011i!!AA\u00025}A\u0003BF\u007f!wD!\u0002$\u0003\u0003\u0012\u0005\u0005\t\u0019AGr)\tiy\"\u0001\u0007XS2$7-\u0019:e)f\u0004X\r\u0005\u0003\r\"\t]!\u0001D,jY\u0012\u001c\u0017M\u001d3UsB,7\u0003\u0003B\f\u0019?j\u0019\"$\"\u0015\u0005E\u0005A\u0003BGr#\u0017A!\u0002$\u0003\u0003&\u0005\u0005\t\u0019AG\u0010)\u0011Yi0e\u0004\t\u00151%!\u0011FA\u0001\u0002\u0004i\u0019OA\nC_VtG-\u001a3XS2$7-\u0019:e)f\u0004Xm\u0005\u0006\u0003.1}\u0013SCG\n\u001b\u000b\u0003B\u0001$\t\u0012\u0018%!\u0011\u0013DFY\u0005Y\u0011u.\u001e8eK\u0012<\u0016\u000e\u001c3dCJ$G+\u001f9f\u0003BL\u0017a\u00022pk:$7\u000f\t\u000b\u0005#?\t\n\u0003\u0005\u0003\r\"\t5\u0002\u0002\u0003G\u007f\u0005g\u0001\r!$\u0001\u0002\t\r|\u0007/\u001f\u000b\u0005#?\t:\u0003\u0003\u0006\r~\n}\u0002\u0013!a\u0001\u001b\u0003\tabY8qs\u0012\"WMZ1vYR$\u0013'\u0006\u0002\u0012.)\"Q\u0012AI\u0018W\t\t\n\u0004\u0005\u0003\u00124EuRBAI\u001b\u0015\u0011\t:$%\u000f\u0002\u0013Ut7\r[3dW\u0016$'\u0002BI\u001e\u00173\u000b!\"\u00198o_R\fG/[8o\u0013\u0011\tz$%\u000e\u0003#Ut7\r[3dW\u0016$g+\u0019:jC:\u001cW\r\u0006\u0003\u000edF\r\u0003B\u0003G\u0005\u0005\u000f\n\t\u00111\u0001\u000e Q!1R`I$\u0011)aIAa\u0013\u0002\u0002\u0003\u0007Q2\u001d\u000b\u0005\u0017{\fZ\u0005\u0003\u0006\r\n\t=\u0013\u0011!a\u0001\u001bG\f1CQ8v]\u0012,GmV5mI\u000e\f'\u000f\u001a+za\u0016\u0004B\u0001$\t\u0003TM1!1KI*\u001b\u000b\u0003B\u0001$\t\u0012V%!\u0011sKFY\u0005q\u0011u.\u001e8eK\u0012<\u0016\u000e\u001c3dCJ$G+\u001f9f\u000bb$(/Y2u_J$\"!e\u0014\u0015\tE}\u0011S\f\u0005\t\u0019{\u00149\u00061\u0001\u000e\u0002\u00059QO\\1qa2LH\u0003BI2#K\u0002bac)\u0010X5\u0005\u0001BCI4\u00053\n\t\u00111\u0001\u0012 \u0005\u0019\u0001\u0010\n\u0019\u0002\r9{G+\u001f9f!\u0011a\tC!\u0018\u0003\r9{G+\u001f9f'!\u0011i\u0006d\u0018\u000e\u00145\u0015ECAI6)\u0011i\u0019/%\u001e\t\u00151%!1NA\u0001\u0002\u0004iy\u0002\u0006\u0003\f~Fe\u0004B\u0003G\u0005\u0005_\n\t\u00111\u0001\u000ed\u0006Aaj\u001c)sK\u001aL\u0007\u0010\u0005\u0003\r\"\tU$\u0001\u0003(p!J,g-\u001b=\u0014\u0011\tUDrLG\n\u001b\u000b#\"!% \u0015\t5\r\u0018s\u0011\u0005\u000b\u0019\u0013\u0011))!AA\u00025}A\u0003BF\u007f#\u0017C!\u0002$\u0003\u0003\n\u0006\u0005\t\u0019AGr\u0005!!\u0006.[:UsB,7C\u0003BG!3\f\n*d\u0005\u000e\u0006B!A\u0012EIJ\u0013\u0011\t*j#-\u0003\u0017QC\u0017n\u001d+za\u0016\f\u0005/[\u0001\u0005gfl\u0007\u0005\u0006\u0003\u0012\u001cFu\u0005\u0003\u0002G\u0011\u0005\u001bC\u0001\u0002d9\u0003\u0014\u0002\u0007Ar\u0004\u000b\u0005\u001bG\f\n\u000b\u0003\u0006\r\n\t%\u0016\u0011!a\u0001\u001b?!Ba#@\u0012&\"QA\u0012\u0002BW\u0003\u0003\u0005\r!d9\u0015\t-u\u0018\u0013\u0016\u0005\u000b\u0019\u0013\u0011y+!AA\u00025\r\u0018\u0001\u0003+iSN$\u0016\u0010]3\u0011\t1\u0005\"1W\n\u0007\u0005g\u000b\n,$\"\u0011\t1\u0005\u00123W\u0005\u0005#k[\tLA\tUQ&\u001cH+\u001f9f\u000bb$(/Y2u_J$\"!%,\u0015\t1}\u00133\u0018\u0005\t\u0019G\u00149\f1\u0001\r Q!\u0011sXIa!\u0019Y\u0019kd\u0016\r !Q\u0011s\rB]\u0003\u0003\u0005\r!e'\u0003\u001dUs\u0017.];f)\"L7\u000fV=qKN!!1XIN)\u0011\tJ-e3\u0011\t1\u0005\"1\u0018\u0005\t\u0019G\u0014y\f1\u0001\r \tQ1+\u001b8hY\u0016$\u0016\u0010]3\u0014\u0015\t\u0005\u0007\u0013\\Ii\u001b'i)\t\u0005\u0003\r\"EM\u0017\u0002BIk\u0017c\u0013QbU5oO2,G+\u001f9f\u0003BL\u0017\u0001\u00029sK\u0002\"b!e7\u0012^F}\u0007\u0003\u0002G\u0011\u0005\u0003D\u0001B$,\u0003L\u0002\u0007Ar\f\u0005\t\u0019G\u0014Y\r1\u0001\r \u00059AO]5wS\u0006dWCAIs!\u0011\t:/%=\u000f\tE%\u0018S\u001e\b\u0005\u001b\u001b\nZ/\u0003\u0003\fj.E\u0015\u0002BIx\u0017O\f1\u0002\u00165sK\u00164\u0016\r\\;fg&!\u00113_I{\u0005)!\u0006N]3f-\u0006dW/\u001a\u0006\u0005#_\\9/A\u0006ue&4\u0018.\u00197`I\u0015\fH\u0003BFz#wD!\u0002$\u0003\u0003P\u0006\u0005\t\u0019AIs\u0003!!(/\u001b<jC2\u0004\u0013aD;oI\u0016\u0014H._5oO\u000e\u000b7\r[3\u0002'UtG-\u001a:ms&twmQ1dQ\u0016|F%Z9\u0015\t-M(S\u0001\u0005\u000b\u0019\u0013\u0011I.!AA\u00021}\u0013\u0001E;oI\u0016\u0014H._5oO\u000e\u000b7\r[3!Q\u0011\u0011YNe\u0003\u0011\t-\r&SB\u0005\u0005%\u001fYIJ\u0001\u0005w_2\fG/\u001b7f\u0003A)h\u000eZ3sYfLgn\u001a)fe&|G-\u0001\u000bv]\u0012,'\u000f\\=j]\u001e\u0004VM]5pI~#S-\u001d\u000b\u0005\u0017g\u0014:\u0002\u0003\u0006\r\n\t}\u0017\u0011!a\u0001\u001b?\t\u0011#\u001e8eKJd\u00170\u001b8h!\u0016\u0014\u0018n\u001c3!Q\u0011\u0011\tOe\u0003\u0015\t5\r(s\u0004\u0005\u000b\u0019\u0013\u0011)0!AA\u00025}A\u0003BF\u007f%GA!\u0002$\u0003\u0003z\u0006\u0005\t\u0019AGr)\u0011YiPe\n\t\u00151%!1`A\u0001\u0002\u0004i\u0019/\u0001\u001dtG\u0006d\u0017\r\n:fM2,7\r\u001e\u0013j]R,'O\\1mIQK\b/Z:%I%tg/\u00197jI\u0006$XmU5oO2,G+\u001f9f\u0007\u0006\u001c\u0007.Z:\u0002\u0015MKgn\u001a7f)f\u0004X\r\u0005\u0003\r\"\r\u00051CBB\u0001%ci)\t\u0005\u0003\r\"IM\u0012\u0002\u0002J\u001b\u0017c\u00131cU5oO2,G+\u001f9f\u000bb$(/Y2u_J$\"A%\f\u0015\r1}#3\bJ\u001f\u0011!qik!\u0002A\u00021}\u0003\u0002\u0003Gr\u0007\u000b\u0001\r\u0001d\b\u0015\tI\u0005#\u0013\n\t\u0007\u0017G{9Fe\u0011\u0011\u0011-\r&S\tG0\u0019?IAAe\u0012\f\u001a\n1A+\u001e9mKJB!\"e\u001a\u0004\b\u0005\u0005\t\u0019AIn\u0005A)f.[9vKNKgn\u001a7f)f\u0004Xm\u0005\u0003\u0004\nEmGC\u0002J)%'\u0012*\u0006\u0005\u0003\r\"\r%\u0001\u0002\u0003HW\u0007\u001f\u0001\r\u0001d\u0018\t\u00111\r8q\u0002a\u0001\u0019?\tA\u0004Z3gS:,WK\u001c3fe2L\u0018N\\4PMNKgn\u001a7f)f\u0004X\r\u0006\u0003\ftJm\u0003\u0002CF]\u0007#\u0001\r!e7\u0003\u0013M+\b/\u001a:UsB,7CCB\n!3\u0014\n'd\u0005\u000e\u0006B!A\u0012\u0005J2\u0013\u0011\u0011*g#-\u0003\u0019M+\b/\u001a:UsB,\u0017\t]5\u0002\u000fQD\u0017n\u001d;qK\u0006AA\u000f[5tiB,\u0007%\u0001\u0005tkB,'\u000f\u001e9f\u0003%\u0019X\u000f]3siB,\u0007\u0005\u0006\u0004\u0013rIM$S\u000f\t\u0005\u0019C\u0019\u0019\u0002\u0003\u0005\u0013h\ru\u0001\u0019\u0001G0\u0011!\u0011Zg!\bA\u00021}C\u0003BFz%sB!\u0002$\u0003\u0004\"\u0005\u0005\t\u0019AIs)\u0011i\u0019O% \t\u00151%1qGA\u0001\u0002\u0004iy\u0002\u0006\u0003\f~J\u0005\u0005B\u0003G\u0005\u0007w\t\t\u00111\u0001\u000edR!1R JC\u0011)aIa!\u0010\u0002\u0002\u0003\u0007Q2]\u0001\n'V\u0004XM\u001d+za\u0016\u0004B\u0001$\t\u0004BM11\u0011\tJG\u001b\u000b\u0003B\u0001$\t\u0013\u0010&!!\u0013SFY\u0005I\u0019V\u000f]3s)f\u0004X-\u0012=ue\u0006\u001cGo\u001c:\u0015\u0005I%EC\u0002G0%/\u0013Z\n\u0003\u0005\u0013\u001a\u000e\u0015\u0003\u0019\u0001G0\u0003\u0019!\b.[:ua\"A!STB#\u0001\u0004ay&A\u0004tkB,'\u000f\u001e9\u0015\tI\u0005&S\u0015\t\u0007\u0017G{9Fe)\u0011\u0011-\r&S\tG0\u0019?B!\"e\u001a\u0004H\u0005\u0005\t\u0019\u0001J9\u0005=)f.[9vKN+\b/\u001a:UsB,7\u0003BB%%c\"bA%,\u00130JE\u0006\u0003\u0002G\u0011\u0007\u0013B\u0001B%'\u0004P\u0001\u0007Ar\f\u0005\t%;\u001by\u00051\u0001\r`\u0005QA+\u001f9f\u0005>,h\u000eZ:\u0011\t1\u00052QQ\n\u0007\u0007\u000b\u0013J,$\"\u0011\t1\u0005\"3X\u0005\u0005%{[\tLA\nUsB,'i\\;oIN,\u0005\u0010\u001e:bGR|'\u000f\u0006\u0002\u00136\u0006)Q-\u001c9us\u0006)Q\u000f\u001d9feR!Q\u0012\u0001Jd\u0011!iyia#A\u00021}\u0013!\u00027po\u0016\u0014H\u0003BG\u0001%\u001bD\u0001\"d#\u0004\u000e\u0002\u0007Ar\f\u000b\u0007\u001b\u0003\u0011\nNe5\t\u00115-5q\u0012a\u0001\u0019?B\u0001\"d$\u0004\u0010\u0002\u0007ArL\u0001\rSN,U\u000e\u001d;z+B\u0004XM\u001d\u000b\u0005\u0017{\u0014J\u000e\u0003\u0005\u000e\u0010\u000eE\u0005\u0019\u0001G0\u00031I7/R7qifdun^3s)\u0011YiPe8\t\u00115-51\u0013a\u0001\u0019?\"BA%)\u0013d\"Q\u0011sMBK\u0003\u0003\u0005\r!$\u0001\u0003!Us\u0017.];f)f\u0004XMQ8v]\u0012\u001c8\u0003BBL\u001b\u0003!bAe;\u0013nJ=\b\u0003\u0002G\u0011\u0007/C\u0001\"d#\u0004\u001e\u0002\u0007Ar\f\u0005\t\u001b\u001f\u001bi\n1\u0001\r`\u0005a1i\\7q_VtG\rV=qKB!A\u0012EBQ\u00051\u0019u.\u001c9pk:$G+\u001f9f'\u0011\u0019\tk#)\u0015\u0005IMH\u0003\u0002J\u007f'\u000b\u0001bac)\u0010XI}\bCCFR'\u0003ai\u0006$#\r %!13AFM\u0005\u0019!V\u000f\u001d7fg!A1sABS\u0001\u0004ay&\u0001\u0002uaN11q\u0015G0'\u0017\u0001B\u0001$\t\u0014\u000e%!1sBFY\u0005=\u0019u.\u001c9pk:$G+\u001f9f\u0003BLGCAJ\n!\u0011a\tca*\u0002!\t\f7/\u001a+za\u0016\u001cV-]\"bG\",\u0017\u0001\u00062bg\u0016$\u0016\u0010]3TKF\u001c\u0015m\u00195f?\u0012*\u0017\u000f\u0006\u0003\ftNm\u0001B\u0003G\u0005\u0007[\u000b\t\u00111\u0001\u000e>\u0005\t\"-Y:f)f\u0004XmU3r\u0007\u0006\u001c\u0007.\u001a\u0011\u0002#\t\f7/\u001a+za\u0016\u001cV-\u001d)fe&|G-A\u000bcCN,G+\u001f9f'\u0016\f\b+\u001a:j_\u0012|F%Z9\u0015\t-M8S\u0005\u0005\u000b\u0019\u0013\u0019\u0019,!AA\u00025}\u0011A\u00052bg\u0016$\u0016\u0010]3TKF\u0004VM]5pI\u0002\n\u0001CY1tK\u000ec\u0017m]:fg\u000e\u000b7\r[3\u0002)\t\f7/Z\"mCN\u001cXm]\"bG\",w\fJ3r)\u0011Y\u0019pe\f\t\u00151%1\u0011XA\u0001\u0002\u0004aY%A\tcCN,7\t\\1tg\u0016\u001c8)Y2iK\u0002\n\u0011CY1tK\u000ec\u0017m]:fgB+'/[8e\u0003U\u0011\u0017m]3DY\u0006\u001c8/Z:QKJLw\u000eZ0%KF$Bac=\u0014:!QA\u0012BB`\u0003\u0003\u0005\r!d\b\u0002%\t\f7/Z\"mCN\u001cXm\u001d)fe&|G\rI\u0001\u0005[\u0016lw.\u0006\u0003\u0014BM\u001dC\u0003BJ\"'#\"Ba%\u0012\u0014LA!q\u0012DJ$\t!\u0019Je!3C\u0002=}!!A!\t\u0011M53\u0011\u001aa\u0001'\u001f\n1a\u001c93!!Y\u0019+d0\r`M\u0015\u0003\"CJ*\u0007\u0013$\t\u0019AJ+\u0003\ry\u0007/\r\t\u0007\u0017G{)e%\u0012\u0015\t1}3\u0013\f\u0005\t\u0019G\u001cY\r1\u0001\r \u0005\u00012\u000f[8vY\u00124uN]2f'\u000e|\u0007/Z\u0001\nS:LG\u000fR3dYN\f1b]2pa\u0016\u001cFO]5oO\u0006Y4oY1mC\u0012\u0012XM\u001a7fGR$\u0013N\u001c;fe:\fG\u000e\n+za\u0016\u001cH\u0005J5om\u0006d\u0017\u000eZ1uK\u0012\u001cu.\u001c9pk:$G+\u001f9f\u0007\u0006\u001c\u0007.Z:\u0002%\r|W\u000e];uK\n\u000b7/Z\"mCN\u001cXm\u001d\u000b\u0005\u0019\u0017\u001a:\u0007\u0003\u0005\f:\u000em\u0007\u0019\u0001G0\u0003}!WMZ5oK\n\u000b7/\u001a+za\u0016\u001cV-](g\u0007>l\u0007o\\;oIRK\b/\u001a\u000b\u0005\u0017g\u001cj\u0007\u0003\u0005\f:\u000eu\u0007\u0019AJ\n\u0003}!WMZ5oK\n\u000b7/Z\"mCN\u001cXm](g\u0007>l\u0007o\\;oIRK\b/\u001a\u000b\u0005\u0017g\u001c\u001a\b\u0003\u0005\f:\u000e}\u0007\u0019AJ\n\u0005-\u0011VMZ5oK\u0012$\u0016\u0010]3\u0014\u0015\r\u000583CJ=\u001b'i)\t\u0005\u0003\r\"Mm\u0014\u0002BJ?\u0017c\u0013aBU3gS:,G\rV=qK\u0006\u0003\u0018.\u0001\u0005qCJ,g\u000e^:!\u0003\u0019!Wm\u00197tAQ11SQJD'\u0013\u0003B\u0001$\t\u0004b\"AQRFBv\u0001\u0004ai\u0006\u0003\u0005\u000e0\r-\b\u0019\u0001GE\u0003)qwN]7bY&TX\rZ\u0001\u000f]>\u0014X.\u00197ju\u0016$w\fJ3r)\u0011Y\u0019p%%\t\u00151%1q_A\u0001\u0002\u0004ay&A\u0006o_Jl\u0017\r\\5{K\u0012\u0004\u0013!\u00048pe6\fG.\u001b>f\u00136\u0004H\u000e\u0006\u0004\u0014\u0006Ne53\u0014\u0005\u000b\u001b[!\t\u0001%AA\u00021u\u0003BCG\u0018\t\u0003\u0001\n\u00111\u0001\r\nV\u00111s\u0014\u0016\u0005\u0019;\nz#\u0001\bd_BLH\u0005Z3gCVdG\u000f\n\u001a\u0016\u0005M\u0015&\u0006\u0002GE#_!B!d9\u0014*\"QA\u0012\u0002C\u0006\u0003\u0003\u0005\r!d\b\u0015\t-u8S\u0016\u0005\u000b\u0019\u0013!y!!AA\u00025\rH\u0003BF\u007f'cC!\u0002$\u0003\u0005\u0014\u0005\u0005\t\u0019AGr\u0003-\u0011VMZ5oK\u0012$\u0016\u0010]3\u0011\t1\u0005BqC\n\u0007\t/\u0019J,$\"\u0011\t1\u000523X\u0005\u0005'{[\tL\u0001\u000bSK\u001aLg.\u001a3UsB,W\t\u001f;sC\u000e$xN\u001d\u000b\u0003'k#\u0002b%\"\u0014DN\u00157s\u0019\u0005\t\u001b[!Y\u00021\u0001\r^!AQr\u0006C\u000e\u0001\u0004aI\t\u0003\u0005\u000e8\u0011m\u0001\u0019\u0001G\u0010)\u0019\u0019*ie3\u0014N\"AQR\u0006C\u000f\u0001\u0004ai\u0006\u0003\u0005\u000e0\u0011u\u0001\u0019\u0001GE)\u0011\u0019\nn%6\u0011\r-\rvrKJj!!Y\u0019K%\u0012\r^1%\u0005BCI4\t?\t\t\u00111\u0001\u0014\u0006\na!+\u001a4j]\u0016$G+\u001f9faM!A\u0011EJC)!\u0019jne8\u0014bN\r\b\u0003\u0002G\u0011\tCA\u0001\"$\f\u0005*\u0001\u0007AR\f\u0005\t\u001b_!I\u00031\u0001\r\n\"AQr\u0007C\u0015\u0001\u0004ay\"A\twC2LG-\u0019;f\u00072\f7o]%oM>$Bac=\u0014j\"A1s\u0001C\u0017\u0001\u0004\u0019Z\u000f\u0005\u0003\r\"\u0011=\"!D\"mCN\u001c\u0018J\u001c4p)f\u0004Xm\u0005\u0006\u00050MM1\u0013_G\n\u001b\u000b\u0003B\u0001$\t\u0014t&!1S_FY\u0005A\u0019E.Y:t\u0013:4w\u000eV=qK\u0006\u0003\u0018.A\u0006usB,7+_7c_2\u0004C\u0003CJv'w\u001cjpe@\t\u001155BQ\ba\u0001\u0019;B\u0001\"d\f\u0005>\u0001\u0007A\u0012\u0012\u0005\t\u0019[$i\u00041\u0001\r \u0005aaj\u001c8FqB\fgn]5wKV\u0011ASA\b\u0003)\u000fi\u0012\u0001A\u0001\u000e\u001d>tW\t\u001f9b]NLg/\u001a\u0011\u0002\u0013\u0015C\b/\u00198tSZ,WC\u0001K\b\u001f\t!\n\"H\u0001\u0002\u0003))\u0005\u0010]1og&4X\rI\u0001\u000e+:Le.\u001b;jC2L'0\u001a3\u0002\u001dUs\u0017J\\5uS\u0006d\u0017N_3eA\u0005a\u0011J\\5uS\u0006d\u0017N_5oO\u0006i\u0011J\\5uS\u0006d\u0017N_5oO\u0002\n1\"\u00138ji&\fG.\u001b>fIV\u0011A\u0013E\b\u0003)Gi\u0012AA\u0001\r\u0013:LG/[1mSj,G\r\t\u0002\u0007%\u00164W*\u00199\u0011\u00115uC3\u0006G\u0010\u0019\u001fIA\u0001&\f\u000en\t\u0019Q*\u00199\u0002\u001b\u0015D\b/\u00198tSZ,'+\u001a4t)\u0011iY\u0006f\r\t\u0011QUBQ\u000ba\u0001\u0019?\ta\u0001\u001e9be\u0006l\u0017\u0001\u0002:fMN,\"\u0001f\u000f\u0011\r-\rFS\bK!\u0013\u0011!zd#'\u0003\u000b\u0005\u0013(/Y=\u0011\tQ\rC1K\u0007\u0003\t_\t\u0001B]3gg~#S-\u001d\u000b\u0005\u0017g$J\u0005\u0003\u0006\r\n\u0011e\u0013\u0011!a\u0001)w\tQA]3gg\u0002\nQa\u001d;bi\u0016\f\u0011b\u001d;bi\u0016|F%Z9\u0015\t-MH3\u000b\u0005\u000b\u0019\u0013!y&!AA\u00025}\u0011AB:uCR,\u0007%A\u0004hKR\u0014VMZ:\u0015\r5mC3\fK0\u0011!!j\u0006b\u0019A\u00025}\u0011!B<iS\u000eD\u0007\u0002\u0003G%\tG\u0002\r\u0001d\b\u0002\r\u0005$GMU3g)!Y\u0019\u0010&\u001a\u0015hQ%\u0004\u0002\u0003K/\tK\u0002\r!d\b\t\u00111%CQ\ra\u0001\u0019?A\u0001\u0002d\u0017\u0005f\u0001\u0007ArD\u0001\bC\u0012$'+\u001a4t)!Y\u0019\u0010f\u001c\u0015rQM\u0004\u0002\u0003K/\tO\u0002\r!d\b\t\u00111%Cq\ra\u0001\u0019?A\u0001\u0002d\u0017\u0005h\u0001\u0007Q2L\u0001\nG2\f7o]%oM>$Bae;\u0015z!AAS\u0007C5\u0001\u0004ay\"A\u0005f]R,'OU3ggB!A3\tC7\u0005%)g\u000e^3s%\u001647o\u0005\u0003\u0005nQ\r\u0005\u0003\u0002G\u0011)\u000bKA\u0001f\"\fT\n9A+\u001f9f\u001b\u0006\u0004HC\u0001K?\u0003)!\b/\u0019:b[~#S-\u001d\u000b\u0005\u0017g$z\t\u0003\u0006\r\n\u0011M\u0014\u0011!a\u0001\u0019?\tq\u0001\u001e9be\u0006l\u0007\u0005\u0006\u0003\r`QU\u0005\u0002CJ\u0004\to\u0002\r\u0001d\u0018\u0002\u000b\u0015tG/\u001a:\u0015\r-MH3\u0014KP\u0011!!j\n\"\u001fA\u00021}\u0011a\u0002;qCJ\fW\u000e\r\u0005\t)C#I\b1\u0001\r`\u00051\u0001/\u0019:f]R\f1bY8naV$XMU3gg\u0006I\u0001O]8qC\u001e\fG/\u001a\u000b\u0003\u0017{\f\u0011CZ8s[\u0006$H/\u001a3U_N#(/\u001b8h)!\u0019Z\u000f&,\u00150RE\u0006BCG\u0017\t\u0013\u0003\n\u00111\u0001\r^!QQr\u0006CE!\u0003\u0005\r\u0001$#\t\u001515H\u0011\u0012I\u0001\u0002\u0004ay\"\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u001a\u0016\u0005Q]&\u0006\u0002G\u0010#_!B!d9\u0015<\"QA\u0012\u0002CK\u0003\u0003\u0005\r!d\b\u0015\t-uHs\u0018\u0005\u000b\u0019\u0013!I*!AA\u00025\rH\u0003BF\u007f)\u0007D!\u0002$\u0003\u0005\u001e\u0006\u0005\t\u0019AGr\u00035\u0019E.Y:t\u0013:4w\u000eV=qKB!A\u0012\u0005CQ'\u0019!\t\u000bf3\u000e\u0006B!A\u0012\u0005Kg\u0013\u0011!zm#-\u0003-\rc\u0017m]:J]\u001a|G+\u001f9f\u000bb$(/Y2u_J$\"\u0001f2\u0015\u0011M-HS\u001bKl)3D\u0001\"$\f\u0005&\u0002\u0007AR\f\u0005\t\u001b_!)\u000b1\u0001\r\n\"AAR\u001eCS\u0001\u0004ay\u0002\u0006\u0003\u0013~Ru\u0007BCI4\tO\u000b\t\u00111\u0001\u0014l\n!\u0002+Y2lC\u001e,7\t\\1tg&sgm\u001c+za\u0016\u001cB\u0001\"+\u0014lR1AS\u001dKt)S\u0004B\u0001$\t\u0005*\"AQr\u0006CX\u0001\u0004aI\t\u0003\u0005\u000e8\u0011=\u0006\u0019\u0001G\u0010\u00051\u0019uN\\:uC:$H+\u001f9f')!\t\f%7\u0015p6MQR\u0011\t\u0005\u0019C!\n0\u0003\u0003\u0015t.E&aD\"p]N$\u0018M\u001c;UsB,\u0017\t]5\u0016\u0005Q]\b\u0003\u0002G\u0011)sLA\u0001f?\u0015~\nA1i\u001c8ti\u0006tG/\u0003\u0003\u0015\u0000.E%!C\"p]N$\u0018M\u001c;t\u0003\u00191\u0018\r\\;fAQ!QSAK\u0004!\u0011a\t\u0003\"-\t\u0011A}Bq\u0017a\u0001)o$B!d9\u0016\f!QA\u0012\u0002Cd\u0003\u0003\u0005\r!d\b\u0015\t-uXs\u0002\u0005\u000b\u0019\u0013!Y-!AA\u00025\rH\u0003BF\u007f+'A!\u0002$\u0003\u0005N\u0006\u0005\t\u0019AGr\u00031\u0019uN\\:uC:$H+\u001f9f!\u0011a\t\u0003\"5\u0014\r\u0011EW3DGC!\u0011a\t#&\b\n\tU}1\u0012\u0017\u0002\u0016\u0007>t7\u000f^1oiRK\b/Z#yiJ\f7\r^8s)\t):\u0002\u0006\u0003\u0016&U=\u0002\u0003\u0002G\u0011\t3\u0014!#\u00168jcV,7i\u001c8ti\u0006tG\u000fV=qKN!A\u0011\\K\u0003)\u0011)*#&\f\t\u0011A}BQ\u001ca\u0001)oD\u0001\u0002e\u0010\u0005V\u0002\u0007As\u001f\u000b\u0005+g)*\u0004\u0005\u0004\f$>]Cs\u001f\u0005\u000b#O\"9.!AA\u0002U\u0015!aC!sON$\u0016\u0010]3SK\u001a\u001cB\u0001b8\u0016<A!A\u0012ECC\u0005\u001d!\u0016\u0010]3SK\u001a\u001c\"\"\"\"\u000e\u000eU\u0005S2CGC!\u0011a\t#f\u0011\n\tU\u00153\u0012\u0017\u0002\u000b)f\u0004XMU3g\u0003BL\u0017\u0001B1sON\fQ!\u0019:hg\u0002\"\u0002\"f\u000f\u0016NU=S\u0013\u000b\u0005\t\u001d[+\u0019\n1\u0001\r`!AA2]CJ\u0001\u0004ay\u0002\u0003\u0005\u0016H\u0015M\u0005\u0019\u0001G/)\u0011Y\u00190&\u0016\t\u00151%QqSA\u0001\u0002\u0004\t*/\u0001\u0007qCJ,g\u000e^:DC\u000eDW-\u0001\tqCJ,g\u000e^:DC\u000eDWm\u0018\u0013fcR!12_K/\u0011)aI!\")\u0002\u0002\u0003\u0007ARL\u0001\u000ea\u0006\u0014XM\u001c;t\u0007\u0006\u001c\u0007.\u001a\u0011\u0002\u001bA\f'/\u001a8ugB+'/[8e\u0003E\u0001\u0018M]3oiN\u0004VM]5pI~#S-\u001d\u000b\u0005\u0017g,:\u0007\u0003\u0006\r\n\u0015\u001d\u0016\u0011!a\u0001\u001b?\ta\u0002]1sK:$8\u000fU3sS>$\u0007\u0005\u0006\u0003\ftV5\u0004B\u0003G\u0005\u000b[\u000b\t\u00111\u0001\u000e>Q!12_K9\u0011)aI!b-\u0002\u0002\u0003\u0007Qr\u0004\u000b\u0005\u0017g,*\b\u0003\u0006\r\n\u0015e\u0016\u0011!a\u0001\u0019?BC!b/\u0013\fQ!1R`K>\u0011!)j(b0A\u00025\r\u0018!B8uQ\u0016\u0014\u0018\u0001\u0004:fY\u0006$\u0018N^3J]\u001a|\u0017A\u0003:fY\u0006$\u0018N^5{KR!ArLKC\u0011!\u0019:!b1A\u00021}\u0013!D1sON|%\u000fR;n[&,7\u000f\u0006\u0003\r`U-\u0005\u0002CG\u001c\u000b\u000f\u0004\r\u0001d\b\u00023\t\f7/\u001a+za\u0016|eMT8o\u00072\f7o\u001d+za\u0016\u0014VM\u001a\u000b\u0005\u0019?*\n\n\u0003\u0005\u000e8\u0015%\u0007\u0019\u0001G\u0010\u0003}\u0011\u0017m]3UsB,wJ\u001a(p]\u000ec\u0017m]:UsB,'+\u001a4M_\u001e<W\r\u001a\u000b\u0005\u0019?*:\n\u0003\u0005\u000e8\u0015-\u0007\u0019\u0001G\u0010\u0003-\u0019w.\u001a<pYZ,7+_7\u0015\t1}QS\u0014\u0005\t+?+)\u000e1\u0001\r`\u0005!\u0001O]32\u0003UIg.\u001b;jC2L'0\u001a3UsB,\u0007+\u0019:b[N\f1\u0003^=qKB\u000b'/Y7t\u001b\u0006$8\r[!sON\f1\u0002]1sK:$8/S7qY\u0006y!-Y:f)f\u0004XmU3r\u00136\u0004H.\u0001\boK\u0016$7\u000f\u0015:f'R\u0014\u0018N\\4\u0002\u0013A\u0014Xm\u0015;sS:<\u0017AC1sON\u001cFO]5oO\u0006y!/\u001a4j]\u0016lWM\u001c;EK\u000ed7/\u0001\tsK\u001aLg.Z7f]R\u001cFO]5oO\u0006aa-\u001b8jg\"\u0004&/\u001a4jqR!QRZK\\\u0011!)JLb\u0001A\u00025=\u0016\u0001\u0002:fgR\fAB\\8Be\u001e\u001c8\u000b\u001e:j]\u001e\fq\u0002^;qY\u0016$\u0016\u0010]3TiJLgnZ\u0001\u0010S:4\u0017\u000e\u001f+za\u0016\u001cFO]5oO\u0006q1-^:u_6$vn\u0015;sS:<WCAKc!\u0011Y\u0019+f2\n\tU%7\u0012\u0014\u0002\u0005\u001dVdG\u000e\u0006\u0003\u000edV5\u0007B\u0003G\u0005\r3\t\t\u00111\u0001\u000e Q!1R`Ki\u0011)aIA\"\b\u0002\u0002\u0003\u0007Q2]\u00016g\u000e\fG.\u0019\u0013sK\u001adWm\u0019;%S:$XM\u001d8bY\u0012\"\u0016\u0010]3tI\u0011JgN^1mS\u0012\fG/\u001a+za\u0016\u0014VMZ\"bG\",7/\u0001\u0018tG\u0006d\u0017\r\n:fM2,7\r\u001e\u0013j]R,'O\\1mIQK\b/Z:%I\u0011,g-\u001b8f\u001d>\u0014X.\u00197ju\u0016$\u0017\u0001\u00029sKB\nAa]=na\u0005)\u0011M]4taQAQs\\Kq+G,*\u000f\u0005\u0003\r\"\u0011}\u0007\u0002CKl\tO\u0004\r\u0001d\u0018\t\u0011UeGq\u001da\u0001\u0019?A\u0001\"f7\u0005h\u0002\u0007ARL\u000b\u0003+StA\u0001$\u0005\u0016l&!QS\u001eG\n\u0003\rq\u0015\u000e\u001c\u0002\u000e\u001b>$W\u000f\\3UsB,'+\u001a4\u0014\t\u0011=X3\u001f\t\u0005\u0019C)yBA\u0007O_\u0006\u0013xm\u001d+za\u0016\u0014VMZ\n\u0005\u000b?)Z\u0004\u0006\u0004\u0016tVmXS \u0005\t+/,)\u00031\u0001\r`!AQ\u0013\\C\u0013\u0001\u0004ay\u0002\u0006\u0004\r`Y\u0005a3\u0001\u0005\t\u001d[)Y\u00031\u0001\rL!AaRCC\u0016\u0001\u0004ai&\u0006\u0002\u0016tR1a\u0013\u0002L\u0006-\u001b\u0001B\u0001$\t\u0005p\"AQs\u001bC{\u0001\u0004ay\u0006\u0003\u0005\u0016Z\u0012U\b\u0019\u0001G\u0010\u00035q\u0017M\u001d:po\u0016$7)Y2iKR!QR\u001aL\n\u0011!)J\f\"@A\u00025=&A\u0004)bG.\fw-\u001a+za\u0016\u0014VMZ\n\u0005\u000b\u00131J\u0001\u0006\u0004\u0017\u001cYuas\u0004\t\u0005\u0019C)I\u0001\u0003\u0005\u0016X\u0016=\u0001\u0019\u0001G0\u0011!)J.b\u0004A\u00021}A\u0003BGg-GA\u0001\"&/\u0006\u0012\u0001\u0007Qr\u0016\u0002\u0012%\u00164\u0017N\\3nK:$H+\u001f9f%\u001647\u0003BC\n+g$bAf\u000b\u0017.Y=\u0002\u0003\u0002G\u0011\u000b'A\u0001\"f6\u0006\u001a\u0001\u0007Ar\f\u0005\t+3,I\u00021\u0001\r Q!QR\u001aL\u001a\u0011!)J,\"\bA\u00025=&a\u0004(p]\u000ec\u0017m]:UsB,'+\u001a4\u0014\t\u0015MR3H\u0001\u0012e\u0016d\u0017\r^5wK&sgm\\\"bG\",\u0017!\u0006:fY\u0006$\u0018N^3J]\u001a|7)Y2iK~#S-\u001d\u000b\u0005\u0017g4z\u0004\u0003\u0006\r\n\u0015e\u0012\u0011!a\u0001\u0019?\nqD]3mCRLg/Z%oM>\u001c\u0015m\u00195f-\u0006d\u0017\u000e\u001a$peB+'/[8e+\t1*\u0005\u0005\u0003\r\"Y\u001d\u0013\u0002\u0002L%-\u0017\u0012a\u0001U3sS>$\u0017\u0002\u0002L'\u0017#\u00131bU=nE>dG+\u00192mK\u0006\u0019#/\u001a7bi&4X-\u00138g_\u000e\u000b7\r[3WC2LGMR8s!\u0016\u0014\u0018n\u001c3`I\u0015\fH\u0003BFz-'B!\u0002$\u0003\u0006>\u0005\u0005\t\u0019\u0001L#\u0003\u0001\u0012X\r\\1uSZ,\u0017J\u001c4p\u0007\u0006\u001c\u0007.\u001a,bY&$gi\u001c:Ts6LeNZ8\u0002II,G.\u0019;jm\u0016LeNZ8DC\u000eDWMV1mS\u00124uN]*z[&sgm\\0%KF$Bac=\u0017\\!QA\u0012BC!\u0003\u0003\u0005\r\u0001d\u0018\u0002)Y\fG.\u001b3bi\u0016\u0014V\r\\1uSZ,\u0017J\u001c4p\u0003u\u0019X\u000f]3sI%tg/\u00197jI\u0006$X\rV=qKJ+gmQ1dQ\u0016\u001c\u0018AE:va\u0016\u0014HE]3mCRLg/Z%oM>\u0014A\"\u00117jCN$\u0016\u0010]3SK\u001a\u001cb!\"\u0014\u0016<Y\u001d\u0004\u0003\u0002G\u0011\u000bg!B\u0001d\b\u0017l!AaSNC3\u0001\u0004ay&\u0001\u0004oK^\u0004&/Z\u0001\u000egV\u0004XM\u001d\u0013eK\u0006d\u0017.Y:\u0002!M,\b/\u001a:%i\u0016\u0014XnU=nE>d\u0017aE:va\u0016\u0014HE\\8s[\u0006d\u0017N_3J[Bd\u0017AD3nE\u0016$G-\u001a3Ts6\u0014w\u000e\u001c\u000b\u0007\u0019?1JHf\u001f\t\u0011M\u001dQq\u000ea\u0001\u0019?B\u0001\u0002$\u001f\u0006p\u0001\u0007A2\u0010\u0002\u0010\u0003\n\u001cHO]1diRK\b/\u001a*fMN1Q\u0011OK\u001e-O\nq\u0001V=qKJ+g\r\u0005\u0003\r\"\u0019\u00152C\u0002D\u0013-\u000fk)\t\u0005\u0003\r\"Y%\u0015\u0002\u0002LF\u0017c\u0013\u0001\u0003V=qKJ+g-\u0012=ue\u0006\u001cGo\u001c:\u0015\u0005Y\rE\u0003\u0003G0-#3\u001aJ&&\t\u001195f\u0011\u0006a\u0001\u0019?B\u0001\u0002d9\u0007*\u0001\u0007Ar\u0004\u0005\t+\u000f2I\u00031\u0001\r^Q!a\u0013\u0014LO!\u0019Y\u0019kd\u0016\u0017\u001cBQ12UJ\u0001\u0019?by\u0002$\u0018\t\u0015E\u001dd1FA\u0001\u0002\u0004)ZD\u0001\tBY&\f7/\u0011:hgRK\b/\u001a*fMN1aQFKp-G\u0003B\u0001$\t\u0006NQAas\u0015LU-W3j\u000b\u0005\u0003\r\"\u00195\u0002\u0002\u0003HW\rk\u0001\r\u0001d\u0018\t\u00111\rhQ\u0007a\u0001\u0019?A\u0001\"f\u0012\u00076\u0001\u0007AR\f\u0002\u0014\u0003\n\u001cHO]1di\u0006\u0013xm\u001d+za\u0016\u0014VMZ\n\u0007\ro)zNf-\u0011\t1\u0005R\u0011\u000f\u000b\t-o3JLf/\u0017>B!A\u0012\u0005D\u001c\u0011!qiKb\u0010A\u00021}\u0003\u0002\u0003Gr\r\u007f\u0001\r\u0001d\b\t\u0011U\u001dcq\ba\u0001\u0019;\u0012\u0001c\u00117bgN\f%oZ:UsB,'+\u001a4\u0014\t\u0019\u0005Ss\u001c\u000b\t-\u000b4:M&3\u0017LB!A\u0012\u0005D!\u0011!qiK\"\u0013A\u00021}\u0003\u0002\u0003Gr\r\u0013\u0002\r\u0001d\b\t\u0011U\u001dc\u0011\na\u0001\u0019;\u0012!#\u00117jCNtu.\u0011:hgRK\b/\u001a*fMN1a1JKz-G#bAf5\u0017VZ]\u0007\u0003\u0002G\u0011\r\u0017B\u0001B$,\u0007R\u0001\u0007Ar\f\u0005\t\u0019G4\t\u00061\u0001\r \t)\u0012IY:ue\u0006\u001cGOT8Be\u001e\u001cH+\u001f9f%\u001647C\u0002D*+g4\u001a\f\u0006\u0004\u0017`Z\u0005h3\u001d\t\u0005\u0019C1\u0019\u0006\u0003\u0005\u000f.\u001ae\u0003\u0019\u0001G0\u0011!a\u0019O\"\u0017A\u00021}!AE\"mCN\u001chj\\!sON$\u0016\u0010]3SK\u001a\u001cBAb\u0017\u0016tR1a3\u001eLw-_\u0004B\u0001$\t\u0007\\!AaR\u0016D1\u0001\u0004ay\u0006\u0003\u0005\rd\u001a\u0005\u0004\u0019\u0001G\u0010\u0003A!WMZ5oK:{'/\\1mSj,G\r\u0006\u0003\ftZU\b\u0002\u0003L|\rG\u0002\r!f\u000f\u0002\u0005Q\u0014\u0018A\u00063fM&tW\rU1sK:$8o\u00144UsB,'+\u001a4\u0015\t-MhS \u0005\t\u0017s3)\u00071\u0001\u0016<\u0005QB-\u001a4j]\u0016\u0014\u0015m]3UsB,7+Z9PMRK\b/\u001a*fMR!12_L\u0002\u0011!YILb\u001aA\u0002Um\"AC'fi\"|G\rV=qKNQa\u0011\u000eG0/\u0013i\u0019\"$\"\u0011\t1\u0005r3B\u0005\u0005/\u001bY\tLA\u0007NKRDw\u000e\u001a+za\u0016\f\u0005/[\u0001\ba\u0006\u0014\u0018-\\:!\u0003-\u0011Xm];miRK\b/\u001a\u0011\u0015\r]UqsCL\r!\u0011a\tC\"\u001b\t\u00119}a1\u000fa\u0001\u0019\u0017B\u0001Bd\u0004\u0007t\u0001\u0007Ar\f\u000b\u0005\u0017g<j\u0002\u0003\u0006\r\n\u0019]\u0014\u0011!a\u0001#K\fq\"[:Ue&4\u0018.\u00197SKN,H\u000e^\u0001\u0011CJ,GK]5wS\u0006d\u0007+\u0019:b[N\f!\"[:J[Bd\u0017nY5u\u0003\u0019I7OS1wC\"Ba1RG9\u001bojY\b\u0006\u0003\r`]-\u0002\u0002\u0003H\u000b\r\u001b\u0003\r\u0001$\u0018\u0002\u0013%\u001cH-\u001a9nKRD\u0017!D5tI\u0016\u0004X.\u001a;i?\u0012*\u0017\u000f\u0006\u0003\ft^M\u0002B\u0003G\u0005\r#\u000b\t\u00111\u0001\u0012f\u0006Q\u0011n\u001d3fa6,G\u000f\u001b\u0011\u0002\u0017\u0005\u0004\bO]8yS6\fG/Z\u000b\u0003/+!B\u0001d\u0018\u0018>!Aar\u0007DN\u0001\u0004ay\u0002\u0006\u0003\r`]\u0005\u0003\u0002\u0003H\u001c\r;\u0003\r\u0001d\b\u0015\r]UqSIL$\u0011)qyB\")\u0011\u0002\u0003\u0007A2\n\u0005\u000b\u001d\u001f1\t\u000b%AA\u00021}SCAL&U\u0011aY%e\f\u0016\u0005]=#\u0006\u0002G0#_!B!d9\u0018T!QA\u0012\u0002DV\u0003\u0003\u0005\r!d\b\u0015\t-uxs\u000b\u0005\u000b\u0019\u00131y+!AA\u00025\rH\u0003BF\u007f/7B!\u0002$\u0003\u00074\u0006\u0005\t\u0019AGr\u0003)iU\r\u001e5pIRK\b/\u001a\t\u0005\u0019C19l\u0005\u0004\u00078^\rTR\u0011\t\u0005\u0019C9*'\u0003\u0003\u0018h-E&aE'fi\"|G\rV=qK\u0016CHO]1di>\u0014HCAL0)\u00199*b&\u001c\u0018p!Aar\u0004D^\u0001\u0004aY\u0005\u0003\u0005\u000f\u0010\u0019m\u0006\u0019\u0001G0)\u00119\u001ahf\u001e\u0011\r-\rvrKL;!!Y\u0019K%\u0012\rL1}\u0003BCI4\r{\u000b\t\u00111\u0001\u0018\u0016\tq!*\u0019<b\u001b\u0016$\bn\u001c3UsB,7\u0003\u0002D`/+\t!\u0001]:\u0002\u0005I$HCBLB/\u000b;:\t\u0005\u0003\r\"\u0019}\u0006\u0002CL?\r\u000b\u0004\r\u0001d\u0013\t\u0011]}dQ\u0019a\u0001\u0019?\u0012\u0011CT;mY\u0006\u0014\u00180T3uQ>$G+\u001f9f')1I\rd\u0018\u0018\u000e6MQR\u0011\t\u0005\u0019C9z)\u0003\u0003\u0018\u0012.E&\u0001\u0006(vY2\f'/_'fi\"|G\rV=qK\u0006\u0003\u0018\u000e\u0006\u0003\u0018\u0016^]\u0005\u0003\u0002G\u0011\r\u0013D\u0001Bd\u0004\u0007P\u0002\u0007Ar\f\u000b\u0005\u0019?:Z\n\u0003\u0005\u000e8\u0019\u0015\b\u0019\u0001G\u0010Q!19/$\u001d\u000ex5mD\u0003BLK/CC!Bd\u0004\u0007nB\u0005\t\u0019\u0001G0)\u0011i\u0019o&*\t\u00151%aQ_A\u0001\u0002\u0004iy\u0002\u0006\u0003\f~^%\u0006B\u0003G\u0005\rs\f\t\u00111\u0001\u000edR!1R`LW\u0011)aIA\"@\u0002\u0002\u0003\u0007Q2]\u0001\u0012\u001dVdG.\u0019:z\u001b\u0016$\bn\u001c3UsB,\u0007\u0003\u0002G\u0011\u000f\u0003\u0019ba\"\u0001\u001866\u0015\u0005\u0003\u0002G\u0011/oKAa&/\f2\nQb*\u001e7mCJLX*\u001a;i_\u0012$\u0016\u0010]3FqR\u0014\u0018m\u0019;peR\u0011q\u0013\u0017\u000b\u0005/+;z\f\u0003\u0005\u000f\u0010\u001d\u0015\u0001\u0019\u0001G0)\u0011y)ff1\t\u0015E\u001dtqAA\u0001\u0002\u00049*J\u0001\u0005Q_2LH+\u001f9f')9I\u0001d\u0018\u0018J6MQR\u0011\t\u0005\u0019C9Z-\u0003\u0003\u0018N.E&a\u0003)pYf$\u0016\u0010]3Ba&\f1\u0002^=qKB\u000b'/Y7tAQ1q3[Lk//\u0004B\u0001$\t\b\n!Aa2ED\n\u0001\u0004aY\u0005\u0003\u0005\u000f\u0010\u001dM\u0001\u0019\u0001G0Q!9)#$\u001d\u000ex5mD\u0003\u0002G0/;D\u0001\"d\u000e\b0\u0001\u0007Ar\u0004\u000b\u0005/'<\n\u000f\u0003\u0005\u000f8\u001du\u0002\u0019\u0001G\u0010)\u0011ayf&:\t\u00119]rq\ba\u0001\u0019?!baf5\u0018j^-\bB\u0003H\u0012\u000f\u0007\u0002\n\u00111\u0001\rL!QarBD\"!\u0003\u0005\r\u0001d\u0018\u0015\t5\rxs\u001e\u0005\u000b\u0019\u00139i%!AA\u00025}A\u0003BF\u007f/gD!\u0002$\u0003\bR\u0005\u0005\t\u0019AGr)\u0011Yipf>\t\u00151%qQKA\u0001\u0002\u0004i\u0019/\u0001\u0005Q_2LH+\u001f9f!\u0011a\tc\"\u0017\u0014\r\u001dess`GC!\u0011a\t\u0003'\u0001\n\ta\r1\u0012\u0017\u0002\u0012!>d\u0017\u0010V=qK\u0016CHO]1di>\u0014HCAL~)\u00199\u001a\u000e'\u0003\u0019\f!Aa2ED/\u0001\u0004aY\u0005\u0003\u0005\u000f\u0010\u001du\u0003\u0019\u0001G0)\u00119\u001a\bg\u0004\t\u0015E\u001dtqLA\u0001\u0002\u00049\u001a.\u0001\noK^,\u00050[:uK:$\u0018.\u00197UsB,GC\u0002G01+AJ\u0002\u0003\u0005\u0019\u0018\u001d\u0005\u0004\u0019\u0001G&\u0003)\tX/\u00198uS\u001aLW\r\u001a\u0005\t\u0019g<\t\u00071\u0001\r`\tyQ\t_5ti\u0016tG/[1m)f\u0004Xm\u0005\u0007\bd1}\u0003t\u0004M\u0011\u001b'i)\tE\u0002\r\"A\u0002B\u0001$\t\u0019$%!\u0001TEFY\u0005I)\u00050[:uK:$\u0018.\u00197UsB,\u0017\t]5\u0002\u0017E,\u0018M\u001c;jM&,G\rI\u0001\fk:$WM\u001d7zS:<\u0007\u0005\u0006\u0004\u0019.a=\u0002\u0014\u0007\t\u0005\u0019C9\u0019\u0007\u0003\u0005\u0019\u0018\u001d5\u0004\u0019\u0001G&\u0011!a\u0019p\"\u001cA\u00021}C\u0003\u0002G01kA\u0001\u0002%\u001e\bp\u0001\u0007Ar\f\u0015\t\u000fsj\t(d\u001e\u000e|U\u0011\u00014\b\t\u0007\u0019#Aj\u0004d\b\n\t1UC2\u0003\u000b\u0007\u0019?B\n\u0005g\u0011\t\u001195r1\u0011a\u0001\u0019\u0017B\u0001B$\u0006\b\u0004\u0002\u0007AR\f\u000b\u0005\u0019?B:\u0005\u0003\u0005\u000e8\u001d\u0015\u0005\u0019\u0001G\u0010\u0003=\tX/\u00198uS\u001aLWM](x]\u0016\u0014\u0018!F5t'R\u0014\u0018-[4ii\u0006\u0003\b\u000f\\5dCRLwN\u001c\u000b\u0007\u0019?Bz\u0005g\u0015\t\u0011aEsq\u0012a\u0001\u0019?\taa\\<oKJ\u0004\u0004\u0002\u0003H\u001e\u000f\u001f\u0003\ra#)\u0002%]LG\u000eZ2be\u0012\f%oZ:TiJLgn\u001a\u000b\u000713BZ\u0006g\u0018\u0011\r15C2KGX\u0011!Ajf\"%A\u00025m\u0013\u0001B9tKRD\u0001\"f\u0012\b\u0012\u0002\u0007ARL\u0001\u0013KbL7\u000f^3oi&\fGn\u00117bkN,7/\u0001\u000fjgJ+\u0007O]3tK:$\u0018M\u00197f/&$\bnV5mI\u000e\f'\u000fZ:\u0015\t1}\u0003t\r\u0005\t\u001do9Y\n1\u0001\r Q!Ar\fM6\u0011!q9d\"(A\u00021}\u0011\u0001D<ji\"$\u0016\u0010]3WCJ\u001cH\u0003BF\u007f1cB\u0001\u0002g\u001d\b\"\u0002\u0007qRA\u0001\u0003_B$ba#@\u0019xae\u0004\u0002\u0003M:\u000fG\u0003\ra$\u0002\t\u0011amt1\u0015a\u0001\u001b\u0017\nQ\u0001Z3qi\"$b\u0001'\f\u0019\u0000a\u0005\u0005B\u0003M\f\u000fK\u0003\n\u00111\u0001\rL!QA2_DS!\u0003\u0005\r\u0001d\u0018\u0015\t5\r\bT\u0011\u0005\u000b\u0019\u00139y+!AA\u00025}A\u0003BF\u007f1\u0013C!\u0002$\u0003\b4\u0006\u0005\t\u0019AGr)\u0011Yi\u0010'$\t\u00151%qqWA\u0001\u0002\u0004i\u0019/A\bFq&\u001cH/\u001a8uS\u0006dG+\u001f9f!\u0011a\tcb/\u0014\r\u001dm\u0006TSGC!\u0011a\t\u0003g&\n\tae5\u0012\u0017\u0002\u0019\u000bbL7\u000f^3oi&\fG\u000eV=qK\u0016CHO]1di>\u0014HC\u0001MI)\u0019Aj\u0003g(\u0019\"\"A\u0001tCD`\u0001\u0004aY\u0005\u0003\u0005\rt\u001e}\u0006\u0019\u0001G0)\u00119\u001a\b'*\t\u0015E\u001dt\u0011YA\u0001\u0002\u0004AjC\u0001\bPm\u0016\u0014Hn\\1eK\u0012$\u0016\u0010]3\u0014\u0011\u001d\rGrLG\n\u001b\u000b\u000bA\"\u00197uKJt\u0017\r^5wKN\fQ\"\u00197uKJt\u0017\r^5wKN\u0004CC\u0002MY1gC*\f\u0005\u0003\r\"\u001d\r\u0007\u0002\u0003HW\u000f\u001b\u0004\r\u0001d\u0018\t\u0011a-vQ\u001aa\u0001\u0019\u0017\"b\u0001'-\u0019:bm\u0006B\u0003HW\u000f+\u0004\n\u00111\u0001\r`!Q\u00014VDk!\u0003\u0005\r\u0001d\u0013\u0015\t5\r\bt\u0018\u0005\u000b\u0019\u00139y.!AA\u00025}A\u0003BF\u007f1\u0007D!\u0002$\u0003\bd\u0006\u0005\t\u0019AGr)\u0011Yi\u0010g2\t\u00151%qq]A\u0001\u0002\u0004i\u0019/\u0001\bPm\u0016\u0014Hn\\1eK\u0012$\u0016\u0010]3\u0011\t1\u0005r1^\n\u0007\u000fWDz-$\"\u0011\u0015aE\u0007t\u001bG0\u0019\u0017B\n,\u0004\u0002\u0019T*!\u0001T[FM\u0003\u001d\u0011XO\u001c;j[\u0016LA\u0001'7\u0019T\n\t\u0012IY:ue\u0006\u001cGOR;oGRLwN\u001c\u001a\u0015\u0005a-GC\u0002MY1?D\n\u000f\u0003\u0005\u000f.\u001eE\b\u0019\u0001G0\u0011!AZk\"=A\u00021-C\u0003\u0002Ms1S\u0004bac)\u0010Xa\u001d\b\u0003CFR%\u000bby\u0006d\u0013\t\u0015E\u001dt1_A\u0001\u0002\u0004A\n,\u0001\bpm\u0016\u0014Hn\\1eK\u0012$\u0016\u0010]3\u0015\r1}\u0003t\u001eMy\u0011!qik\">A\u00021}\u0003\u0002\u0003MV\u000fk\u0004\r\u0001d\u0013\u0003\u0015%k\u0007o\u001c:u)f\u0004Xm\u0005\u0005\bx2}S2CGC\u0003\u0011)\u0007\u0010\u001d:\u0016\u0005A%\u0016!B3yaJ\u0004C\u0003\u0002M\u00003\u0003\u0001B\u0001$\t\bx\"A\u0001t_D\u007f\u0001\u0004\u0001J\u000b\u0006\u0003\u0019\u0000f\u0015\u0001B\u0003M|\u0011\u0003\u0001\n\u00111\u0001\u0011*V\u0011\u0011\u0014\u0002\u0016\u0005!S\u000bz\u0003\u0006\u0003\u000edf5\u0001B\u0003G\u0005\u0011\u0013\t\t\u00111\u0001\u000e Q!1R`M\t\u0011)aI\u0001#\u0004\u0002\u0002\u0003\u0007Q2\u001d\u000b\u0005\u0017{L*\u0002\u0003\u0006\r\n!E\u0011\u0011!a\u0001\u001bG\f!\"S7q_J$H+\u001f9f!\u0011a\t\u0003#\u0006\u0014\r!U\u0011TDGC!!A\n.g\b\u0011*b}\u0018\u0002BM\u00111'\u0014\u0011#\u00112tiJ\f7\r\u001e$v]\u000e$\u0018n\u001c82)\tIJ\u0002\u0006\u0003\u0019\u0000f\u001d\u0002\u0002\u0003M|\u00117\u0001\r\u0001%+\u0015\te-\u0012T\u0006\t\u0007\u0017G{9\u0006%+\t\u0015E\u001d\u0004RDA\u0001\u0002\u0004AzP\u0001\u0007B]RL\u0007k\u001c7z)f\u0004Xm\u0005\u0005\t 1}S2CGC\u0003\u0015!\u0018M]4t\u0003\u0019!\u0018M]4tAQ1\u0011\u0014HM\u001e3{\u0001B\u0001$\t\t !AaR\u0016E\u0015\u0001\u0004ay\u0006\u0003\u0005\u001a4!%\u0002\u0019\u0001G/)\u0011ay&'\u0011\t\u00111\r\bR\u0006a\u0001\u0019?!b!'\u000f\u001aFe\u001d\u0003B\u0003HW\u0011c\u0001\n\u00111\u0001\r`!Q\u00114\u0007E\u0019!\u0003\u0005\r\u0001$\u0018\u0015\t5\r\u00184\n\u0005\u000b\u0019\u0013AY$!AA\u00025}A\u0003BF\u007f3\u001fB!\u0002$\u0003\t@\u0005\u0005\t\u0019AGr)\u0011Yi0g\u0015\t\u00151%\u00012IA\u0001\u0002\u0004i\u0019/\u0001\u0007B]RL\u0007k\u001c7z)f\u0004X\r\u0005\u0003\r\"!\u001d3C\u0002E$37j)\t\u0005\u0006\u0019Rb]Gr\fG/3s!\"!g\u0016\u0015\ree\u0012\u0014MM2\u0011!qi\u000b#\u0014A\u00021}\u0003\u0002CM\u001a\u0011\u001b\u0002\r\u0001$\u0018\u0015\te\u001d\u00144\u000e\t\u0007\u0017G{9&'\u001b\u0011\u0011-\r&S\tG0\u0019;B!\"e\u001a\tP\u0005\u0005\t\u0019AM\u001d\u00035A\u0015m\u001d+za\u0016lU-\u001c2feB!A\u0012\u0005E*\u00055A\u0015m\u001d+za\u0016lU-\u001c2feN!\u00012KFQ)\tIz\u0007\u0006\u0004\r`ee\u0014\u0014\u0011\u0005\t\u0019sB9\u00061\u0001\u001a|A!A\u0012EM?\u0013\u0011Iz\b$!\u0003\u0011QK\b/\u001a(b[\u0016D\u0001be\u0002\tX\u0001\u0007Ar\f\u000b\u00053\u000bKJ\t\u0005\u0004\f$>]\u0013t\u0011\t\t\u0017G\u0013*%g\u001f\r`!A1s\u0001E-\u0001\u0004ay&\u0001\u0007BeJ\f\u0017\u0010V=qKJ+g\r\u0005\u0003\r\"!u#\u0001D!se\u0006LH+\u001f9f%\u001647\u0003\u0002E/\u0017C#\"!'$\u0015\t=U\u0013t\u0013\u0005\t'\u000fA\t\u00071\u0001\r`\u00059A+\u001f9f-\u0006\u0014\b\u0003\u0002G\u0011\u0011K\u0012q\u0001V=qKZ\u000b'o\u0005\u0004\tf-\u0005VR\u0011\u000b\u000337\u000bQ\u0001\u001e:bG\u0016,B!g*\u001a.R1\u0011\u0014VMY3k#B!g+\u001a0B!q\u0012DMW\t!y\u0019\u0004#\u001bC\u0002=}\u0001\u0002\u0003I \u0011S\u0002\r!g+\t\u0011eM\u0006\u0012\u000ea\u0001\u001b_\u000ba!Y2uS>t\u0007\"CM\\\u0011S\"\t\u0019AM]\u0003\ri7o\u001a\t\u0007\u0017G{)%d,)\t!%t2J\u0001\u0011I\u0016\u0014\u0018N^3D_:\u001cHO]1j]R$B!'1\u001aHB!A\u0012EMb\u0013\u0011I*m#7\u0003\u001dQK\b/Z\"p]N$(/Y5oi\"AAS\u0007E6\u0001\u0004ay\"A\u0006v]R|Wo\u00195bE2,G\u0003BMg5\u000b\u0003B\u0001$\t\t.NA\u0001R\u0016G0\u001b'i))A\u0004pe&<\u0017N\u001c\u0011\u0002\r\r|gn\u001d;s+\tI\n-\u0001\u0006d_:\u001cHO]0%KF$Bac=\u001a\\\"QA\u0012\u0002E[\u0003\u0003\u0005\r!'1\u0002\u000f\r|gn\u001d;sAQ1\u0011TZMq3GD\u0001Bd\u000f\t:\u0002\u0007Ar\f\u0005\t3'DI\f1\u0001\u001aBR!1R`Mt\u0011!)j\b#0A\u00025\r\u0018!C5ogR4\u0016\r\\5e\u0003\u0011Ign\u001d;\u0002!%t7\u000f^,ji\"LgNQ8v]\u0012\u001c\u0018!\u00027fm\u0016d\u0017A\u00027fm\u0016d\u0007%A\u0005baBd\u00170\u0011:hgR!\u0011TZM|\u0011!IJ\u0010c5A\u00021u\u0013a\u00028fo\u0006\u0013xm]\u0001\bg\u0016$\u0018J\\:u)\u0011IzP'\u0001\u000e\u0005!5\u0006\u0002CJ\u0004\u0011+\u0004\r\u0001d\u0018\u0002\u0015\u0005$G\rT8C_VtG\r\u0006\u0004\ftj\u001d!\u0014\u0002\u0005\t'\u000fA9\u000e1\u0001\r`!Q!4\u0002El!\u0003\u0005\ra#@\u0002\u001d%\u001ch*^7fe&\u001c'i\\;oI\u0006!\u0012\r\u001a3M_\n{WO\u001c3%I\u00164\u0017-\u001e7uII*\"A'\u0005+\t-u\u0018sF\u0001\u000bC\u0012$\u0007*\u001b\"pk:$GCBFz5/QJ\u0002\u0003\u0005\u0014\b!m\u0007\u0019\u0001G0\u0011)QZ\u0001c7\u0011\u0002\u0003\u00071R`\u0001\u0015C\u0012$\u0007*\u001b\"pk:$G\u0005Z3gCVdG\u000f\n\u001a\u0002\u0015}\u001bXo\u001d9f]\u0012,G-\u0001\b`gV\u001c\b/\u001a8eK\u0012|F%Z9\u0015\t-M(4\u0005\u0005\u000b\u0019\u0013A\t/!AA\u00021}\u0013aC0tkN\u0004XM\u001c3fI\u0002\n\u0011c\u001d5be\u0016\u001c8i\u001c8tiJ\f\u0017N\u001c;t)\u0011YiPg\u000b\t\u0011Uu\u0004R\u001da\u0001\u0019?\nQB]3hSN$XM\u001d\"pk:$G\u0003CF\u007f5cQ\u001aDg\u000e\t\u0011M\u001d\u0001r\u001da\u0001\u0019?B\u0001B'\u000e\th\u0002\u00071R`\u0001\rSNdun^3s\u0005>,h\u000e\u001a\u0005\u000b5\u0017A9\u000f%AA\u0002-u\u0018a\u0006:fO&\u001cH/\u001a:C_VtG\r\n3fM\u0006,H\u000e\u001e\u00134\u0003Q\u0011XmZ5ti\u0016\u0014H+\u001f9f\u000bF,\u0018\r\\5usR11R N 5\u0003B\u0001be\u0002\tl\u0002\u0007Ar\f\u0005\t5\u0007BY\u000f1\u0001\f~\u0006QA/\u001f9f-\u0006\u0014H\nS*\u0002+I,w-[:uKJ$\u0016\u0010]3TK2,7\r^5p]R11R N%5\u0017B\u0001\u0002d9\tn\u0002\u0007Ar\u0004\u0005\t'\u000fAi\u000f1\u0001\r`\u0005\u0011\u0012n]*l_2,W.\u00112pm\u0016dUM^3m)\u0011YiP'\u0015\t\u0011M\u001d\u0001r\u001ea\u0001\u0019?\n1\"[:SK2\fG/\u00192mKR!1R N,\u0011!\u0019:\u0001#=A\u00021}\u0013\u0001\u0004;qCJ\fWn](g'flG\u0003BGX5;B\u0001\u0002d9\tz\u0002\u0007ArD\u0001\u000b_JLw-\u001b8OC6,\u0017AD8sS\u001eLg\u000eT8dCRLwN\\\u0001\fY\u00164X\r\\*ue&tw-\u0006\u0002\u000ed\u0006aqN]5hS:\u001cFO]5oO\u0006i1\r\\8oK&sG/\u001a:oC2,\"!'4\u0015\t5\r(t\u000e\u0005\u000b\u0019\u0013Ii!!AA\u00025}A\u0003BF\u007f5gB!\u0002$\u0003\n\u0012\u0005\u0005\t\u0019AGr\u0003\u001d\u001a8-\u00197bII,g\r\\3di\u0012Jg\u000e^3s]\u0006dG\u0005V=qKN$Ce];ta\u0016tG-\u001a3\u0002WM\u001c\u0017\r\\1%e\u00164G.Z2uI%tG/\u001a:oC2$C+\u001f9fg\u0012\"3/^:qK:$W\rZ0%KF$Bac=\u001b|!A!TPE\u000b\u0001\u0004Yi0A\u0001c\u0003-\u001a8-\u00197bII,g\r\\3di\u0012Jg\u000e^3s]\u0006dG\u0005V=qKN$C\u0005\\5oWN+8\u000f]3oI\u0016$G\u0003BFz5\u0007C\u0001Bd\u000f\n\u0018\u0001\u0007\u0011T\u001a\u0005\t)kAi\u00071\u0001\r Q!\u0011T\u001aNE\u0011!!*\u0004c\u001cA\u00021}ACBMg5\u001bSz\t\u0003\u0005\u000f<!E\u0004\u0019\u0001G0\u0011!I\u001a\u000e#\u001dA\u0002e\u0005GCCMg5'S*Jg&\u001b\u001a\"Aa2\bE:\u0001\u0004ay\u0006\u0003\u0005\u001aT\"M\u0004\u0019AMa\u0011!):\u0005c\u001dA\u00021u\u0003\u0002\u0003H\u0010\u0011g\u0002\r\u0001d\u0013\u0002\u001b\r\u0014X-\u0019;f)f\u0004XMV1s)1IjMg(\u001b\"j\r&T\u0015NT\u0011!qY\u0004#\u001eA\u00021}\u0003\u0002CMj\u0011k\u0002\r!'1\t\u0011U\u001d\u0003R\u000fa\u0001\u0019;B\u0001Bd\b\tv\u0001\u0007A2\n\u0005\t3\u0013D)\b1\u0001\f~R1\u0011T\u001aNV5[C\u0001\u0002&\u000e\tx\u0001\u0007Ar\u0004\u0005\t3\u0013D9\b1\u0001\f~R!!\u0014\u0017N[!\u0019Y\u0019kd\u0016\u001b4BA12\u0015J#\u0019?J\n\r\u0003\u0006\u0012h!e\u0014\u0011!a\u00013\u001b\u0014\u0011\u0002S&UsB,g+\u0019:\u0014\t!m\u0014TZ\u0001\b?>\u0014\u0018nZ5o\u0003\u001dy6m\u001c8tiJ$\u0002B'1\u001bDj\u0015't\u0019\t\u0005\u0019CAY\b\u0003\u0005\u001b<\"\u0015\u0005\u0019\u0001G0\u0011!Qj\f#\"A\u0002e\u0005\u0007\u0002\u0003H\u0010\u0011\u000b\u0003\r\u0001d\u0013\u0003\u001d\u0005\u0003\b\u000f\\5fIRK\b/\u001a,beN!\u0001\u0012RMg\u0003%!\u0018\u0010]3Be\u001e\u001c\b\u0005\u0006\u0006\u001bRjM'T\u001bNl53\u0004B\u0001$\t\t\n\"A!4\u0018EL\u0001\u0004ay\u0006\u0003\u0005\u001b>\"]\u0005\u0019AMa\u0011!qy\u0002c&A\u00021-\u0003\u0002\u0003H\u0006\u0011/\u0003\r\u0001$\u0018\u0003%UsGo\\;dQ\u0006\u0014G.\u001a+za\u00164\u0016M]\n\u0005\u00117Kj\r\u0006\u0004\f~j\u0005(4\u001d\u0005\t'\u000fA\u0019\u000b1\u0001\r`!A!4\tER\u0001\u0004Yi\u0010\u0006\u0005\f~j\u001d(\u0014\u001eNv\u0011!\u0019:\u0001#*A\u00021}\u0003\u0002\u0003N\u001b\u0011K\u0003\ra#@\t\u0015i-\u0001R\u0015I\u0001\u0002\u0004Yi0\u0001\u000etkB,'\u000f\n:fO&\u001cH/\u001a:UsB,W)];bY&$\u0018\u0010\u0006\u0004\f~jE(4\u001f\u0005\t'\u000fAI\u000b1\u0001\r`!A!4\tEU\u0001\u0004Yi0A\ntkB,'\u000f\n:fO&\u001cH/\u001a:C_VtG\r\u0006\u0005\f~je(4 N\u007f\u0011!\u0019:\u0001c+A\u00021}\u0003\u0002\u0003N\u001b\u0011W\u0003\ra#@\t\u0015i-\u00012\u0016I\u0001\u0002\u0004YiPA\u0007B]:|G/\u0019;fIRK\b/Z\n\r\u00133ay\u0006g\b\u001c\u00045MQR\u0011\t\u0005\u0019CY*!\u0003\u0003\u001c\b-E&\u0001E!o]>$\u0018\r^3e)f\u0004X-\u00119j\u00031\tgN\\8uCRLwN\\:!)\u0019Yjag\u0004\u001c\u0012A!A\u0012EE\r\u0011!\u0001Z!c\tA\u0002A=\u0001\u0002\u0003Gz\u0013G\u0001\r\u0001d\u0018\u0015\tm51T\u0003\u0005\t'\u000fI)\u00031\u0001\r`Q!ArLN\r\u0011!y\u0019!c\u000bA\u0002A}A\u0003\u0002G07;A\u0001\u0002e\n\n.\u0001\u0007\u0001s\u0002\u000b\u0005\u0019?Z\n\u0003\u0003\u0005\u0011(%=\u0002\u0019\u0001I\b)\u0019ayf'\n\u001c(!AaRFE\u001d\u0001\u0004aY\u0005\u0003\u0005\u000f\u0016%e\u0002\u0019\u0001G/)\u0019Yjag\u000b\u001c.!Q\u00013BE !\u0003\u0005\r\u0001e\u0004\t\u00151M\u0018r\bI\u0001\u0002\u0004ay&\u0006\u0002\u001c2)\"\u0001sBI\u0018)\u0011i\u0019o'\u000e\t\u00151%\u0011\u0012JA\u0001\u0002\u0004iy\u0002\u0006\u0003\f~ne\u0002B\u0003G\u0005\u0013\u001b\n\t\u00111\u0001\u000edR!1R`N\u001f\u0011)aI!#\u0015\u0002\u0002\u0003\u0007Q2]\u0001\u000e\u0003:tw\u000e^1uK\u0012$\u0016\u0010]3\u0011\t1\u0005\u0012RK\n\u0007\u0013+Z*%$\"\u0011\t1\u00052tI\u0005\u00057\u0013Z\tL\u0001\fB]:|G/\u0019;fIRK\b/Z#yiJ\f7\r^8s)\tY\n\u0005\u0006\u0004\u001c\u000em=3\u0014\u000b\u0005\t!\u0017II\u00061\u0001\u0011\u0010!AA2_E-\u0001\u0004ay\u0006\u0006\u0003\u001cVme\u0003CBFR\u001f/Z:\u0006\u0005\u0005\f$J\u0015\u0003s\u0002G0\u0011)\t:'c\u0017\u0002\u0002\u0003\u00071TB\u0001\u000eC:tw\u000e^1uK\u0012$\u0016\u0010]3\u0015\r1}3tLN1\u0011!\u0001:##\u0018A\u0002A=\u0001\u0002\u0003Gz\u0013;\u0002\r\u0001d\u0018\u0002/M#\u0018\r^5dC2d\u00170\u00118o_R\fG/\u001a3UsB,\u0007\u0003\u0002G\u0011\u0013C\u0012qc\u0015;bi&\u001c\u0017\r\u001c7z\u0003:tw\u000e^1uK\u0012$\u0016\u0010]3\u0014\t%\u00054\u0012\u0015\u000b\u00037K\"Ba'\u0016\u001cp!A1sAE3\u0001\u0004ayFA\u0005OC6,G\rV=qKNA\u0011r\rG0\u001b'i))\u0006\u0002\r|\u0005)a.Y7fA\u0005\u0019A\u000f\u001d\u0011\u0015\rmu4tPNA!\u0011a\t#c\u001a\t\u00111e\u0014\u0012\u000fa\u0001\u0019wB\u0001be\u0002\nr\u0001\u0007Ar\f\u000b\u00077{Z*ig\"\t\u00151e\u0014R\u000fI\u0001\u0002\u0004aY\b\u0003\u0006\u0014\b%U\u0004\u0013!a\u0001\u0019?*\"ag#+\t1m\u0014s\u0006\u000b\u0005\u001bG\\z\t\u0003\u0006\r\n%}\u0014\u0011!a\u0001\u001b?!Ba#@\u001c\u0014\"QA\u0012BEB\u0003\u0003\u0005\r!d9\u0015\t-u8t\u0013\u0005\u000b\u0019\u0013I9)!AA\u00025\r\u0018!\u0003(b[\u0016$G+\u001f9f!\u0011a\t#c#\u0014\r%-5tTGC!)A\n\u000eg6\r|1}3T\u0010\u000b\u000377#ba' \u001c&n\u001d\u0006\u0002\u0003G=\u0013#\u0003\r\u0001d\u001f\t\u0011M\u001d\u0011\u0012\u0013a\u0001\u0019?\"Bag+\u001c0B112UH,7[\u0003\u0002bc)\u0013F1mDr\f\u0005\u000b#OJ\u0019*!AA\u0002mu$\u0001\u0004*fa\u0016\fG/\u001a3UsB,7\u0003CEK\u0019?j\u0019\"$\"\u0015\tm]6\u0014\u0018\t\u0005\u0019CI)\n\u0003\u0005\u0014\b%m\u0005\u0019\u0001G0)\u0011Y:l'0\t\u0015M\u001d\u0011r\u0014I\u0001\u0002\u0004ay\u0006\u0006\u0003\u000edn\u0005\u0007B\u0003G\u0005\u0013O\u000b\t\u00111\u0001\u000e Q!1R`Nc\u0011)aI!c+\u0002\u0002\u0003\u0007Q2\u001d\u000b\u0005\u0017{\\J\r\u0003\u0006\r\n%=\u0016\u0011!a\u0001\u001bG\fABU3qK\u0006$X\r\u001a+za\u0016\u0004B\u0001$\t\n4N1\u00112WNi\u001b\u000b\u0003\u0002\u0002'5\u001a 1}3t\u0017\u000b\u00037\u001b$Bag.\u001cX\"A1sAE]\u0001\u0004ay\u0006\u0006\u0003\u0010Vmm\u0007BCI4\u0013w\u000b\t\u00111\u0001\u001c8\nyQI]1tK\u00124\u0016\r\\;f)f\u0004Xm\u0005\u0005\n>65Q2CGC\u0003)1\u0018\r\\;f\u00072\f'P_\u0001\fm\u0006dW/Z\"mCjT\b%\u0001\tfe\u0006\u001cX\rZ+oI\u0016\u0014H._5oO\u0006\tRM]1tK\u0012,f\u000eZ3sYfLgn\u001a\u0011\u0015\rm-8T^Nx!\u0011a\t##0\t\u0011m\u0005\u0018r\u0019a\u0001\u0019?A\u0001b':\nH\u0002\u0007Ar\f\u000b\u0005\u001bG\\\u001a\u0010\u0003\u0006\r\n%=\u0017\u0011!a\u0001\u001b?!Ba#@\u001cx\"QA\u0012BEj\u0003\u0003\u0005\r!d9\u0015\t-u84 \u0005\u000b\u0019\u0013I).!AA\u00025\r\u0018aD#sCN,GMV1mk\u0016$\u0016\u0010]3\u0011\t1\u0005\u0012\u0012\\\n\u0007\u00133\\\t+$\"\u0015\u0005m}HC\u0002G09\u000faJ\u0001\u0003\u0005\u001cb&u\u0007\u0019\u0001G\u0010\u0011!Y*/#8A\u00021}C\u0003\u0002O\u00079#\u0001bac)\u0010Xq=\u0001\u0003CFR%\u000bby\u0002d\u0018\t\u0015E\u001d\u0014r\\A\u0001\u0002\u0004YZOA\u000bV]&\fX/Z#sCN,GMV1mk\u0016$\u0016\u0010]3\u0014\t%\u000584\u001e\u000b\u000793aZ\u0002(\b\u0011\t1\u0005\u0012\u0012\u001d\u0005\t7CL9\u000f1\u0001\r !A1T]Et\u0001\u0004ayF\u0001\u0005MCjLH+\u001f9f'\u0011II\u000fd\u0018\u0015\u0005q\u0015\u0002\u0003\u0002G\u0011\u0013S$Bac=\u001d*!AA2]Ex\u0001\u0004ay\"A\njg*\u000bg/\u0019,be\u0006\u0014xm]'fi\"|G-\u0001\u000bkCZ\fG\u000b\u001b:po:,\u0005pY3qi&|gn\u001d\u0002\u0016\r2\fw-Q4o_N$\u0018nY\"p[BdW\r^3s'\u0011II\u0010(\n\u0003-\u0019c\u0017mZ!tg&<g.\u001b8h\u0007>l\u0007\u000f\\3uKJ\u001cB!c?\u001d&\taA*\u0019>z!>d\u0017\u0010V=qKN!\u0011R O\u0013)\u0011aj\u0004h\u0010\u0011\t1\u0005\u0012R \u0005\t\u001dGQ\u0019\u00011\u0001\rL\u00051!/\u001a2j]\u0012$b\u0001d\b\u001dFq\u001d\u0003\u0002\u0003HW\u0015\u000f\u0001\r\u0001d\u0018\t\u00111\r(r\u0001a\u0001\u0019?\t1B]3n_Z,7+\u001e9feR1Ar\fO'9\u001fB\u0001be\u0002\u000b\n\u0001\u0007Ar\f\u0005\t\u0019GTI\u00011\u0001\r \u0005Q1/\u001b8hY\u0016$\u0016\u0010]3\u0015\r1}CT\u000bO,\u0011!qiKc\u0003A\u00021}\u0003\u0002\u0003Gr\u0015\u0017\u0001\r\u0001d\b\u0002\u0017I,g-\u001b8fIRK\b/\u001a\u000b\u000b\u0019?bj\u0006h\u0018\u001dbq\r\u0004\u0002CG\u0017\u0015\u001b\u0001\r\u0001$\u0018\t\u00119]\"R\u0002a\u0001\u0019?A\u0001\"d\f\u000b\u000e\u0001\u0007A\u0012\u0012\u0005\t9KRi\u00011\u0001\u001dh\u0005\u0019\u0001o\\:\u0011\t1\u0005B\u0014N\u0005\u00059WbjG\u0001\u0005Q_NLG/[8o\u0013\u0011azg#%\u0003\u0013A{7/\u001b;j_:\u001cHC\u0002G09gb*\b\u0003\u0005\u000e.)=\u0001\u0019\u0001G/\u0011!q9Dc\u0004A\u00021}\u0011aD2paf\u0014VMZ5oK\u0012$\u0016\u0010]3\u0015\u00111}C4\u0010O@9\u0003C\u0001\u0002( \u000b\u0012\u0001\u00071SQ\u0001\t_JLw-\u001b8bY\"AQR\u0006F\t\u0001\u0004ai\u0006\u0003\u0005\u000e0)E\u0001\u0019\u0001GE\u0003\u001d!\u0018\u0010]3SK\u001a$\u0002\u0002d\u0018\u001d\br%E4\u0012\u0005\t\u001d[S\u0019\u00021\u0001\r`!AA2\u001dF\n\u0001\u0004ay\u0002\u0003\u0005\u0016H)M\u0001\u0019\u0001G/\u0003-\u0019w\u000e]=UsB,'+\u001a4\u0015\u00151}C\u0014\u0013OJ9+c:\n\u0003\u0005\u0014\b)U\u0001\u0019\u0001G0\u0011!qiK#\u0006A\u00021}\u0003\u0002\u0003Gr\u0015+\u0001\r\u0001d\b\t\u0011U\u001d#R\u0003a\u0001\u0019;\naBS1wC6+G\u000f[8e)f\u0004X\r\u0006\u0004\u0018\u0004ruEt\u0014\u0005\t\u001d?Q9\u00021\u0001\rL!Aar\u0002F\f\u0001\u0004ay&\u0001\bd_BLX*\u001a;i_\u0012$\u0016\u0010]3\u0015\u00111}CT\u0015OT9SC\u0001be\u0002\u000b\u001a\u0001\u0007Ar\f\u0005\t\u001d?QI\u00021\u0001\rL!AA4\u0016F\r\u0001\u0004ay&\u0001\u0004sKN$\b/Z\u0001\u0011S:$XM]:fGRLwN\u001c+za\u0016$b\u0001d\u0018\u001d2rU\u0006\u0002\u0003OZ\u00157\u0001\r\u0001$\u0018\u0002\u0007Q\u00048\u000f\u0003\u0005\u000f8)m\u0001\u0019\u0001G\u0010)\u0011ay\u0006(/\t\u0011qM&R\u0004a\u0001\u0019;\nq$\u001b8uKJ\u001cXm\u0019;j_:$\u0016\u0010]3G_Jd\u0015M_=CCN,G+\u001f9f)\u0011ay\u0006h0\t\u0011qM&r\u0004a\u0001\u0019;\n\u0011%[:J]R,'o]3di&|g\u000eV=qK\u001a{'\u000fT1{s\n\u000b7/\u001a+za\u0016$Ba#@\u001dF\"A1s\u0001F\u0011\u0001\u0004\u0019*)A\u0006baBd\u0017.\u001a3UsB,GC\u0002G09\u0017dz\r\u0003\u0005\u001dN*\r\u0002\u0019\u0001G0\u0003\u0015!\u0018pY8o\u0011!):Ec\tA\u00021uCC\u0002G09'd*\u000e\u0003\u0005\u001dN*\u0015\u0002\u0019\u0001G0\u0011!):E#\nA\u0002q]\u0007CBFR93dy&\u0003\u0003\u001d\\.e%A\u0003\u001fsKB,\u0017\r^3e}Q1Ar\fOp9GD\u0001\u0002(9\u000b(\u0001\u0007ArD\u0001\tif\u001cwN\\*z[\"AQs\tF\u0014\u0001\u0004ai\u0006\u0006\u0004\r`q\u001dH\u0014\u001e\u0005\t9CTI\u00031\u0001\r !AQs\tF\u0015\u0001\u0004a:.A\u0006HK:\u0004v\u000e\\=UsB,\u0007\u0003\u0002G\u0011\u0015[\u00111bR3o!>d\u0017\u0010V=qKN!!RFFQ)\taj\u000f\u0006\u0004\r`q]H4 \u0005\t9sT\t\u00041\u0001\rL\u00059A\u000f]1sC6\u001c\b\u0002CF]\u0015c\u0001\r\u0001d\u0018\u0015\t]MDt \u0005\t\u0017sS\u0019\u00041\u0001\r`\u0005Yq-\u001a8Q_2LH+\u001f9f)\u0019ay&(\u0002\u001e\b!Aar\u0004F\u001b\u0001\u0004aY\u0005\u0003\u0005\f:*U\u0002\u0019\u0001G0\u0003!\u0001x\u000e\\=UsB,GC\u0002G0;\u001biz\u0001\u0003\u0005\u000f )]\u0002\u0019\u0001G&\u0011!YILc\u000eA\u00021}\u0003\u0006\u0003F\u001c\u001bcj\u001a\"h\u0006\"\u0005uU\u0011\u0001H;tK\u0002:WM\u001c)pYf$\u0016\u0010]3)]9r\u0013\u0006I5ogR,\u0017\rZ\u0011\u0003;3\taA\r\u00182a9\u0002\u0014a\u0003;za\u00164UO\\!o_:$b\u0001d\u0018\u001e u\u0005\u0002\u0002\u0003OZ\u0015s\u0001\r\u0001d\u0013\t\u0011u\r\"\u0012\ba\u0001\u0019?\nAAY8es\u00069A/\u001f9f\rVtGC\u0002G0;SiZ\u0003\u0003\u0005\u001d4*m\u0002\u0019\u0001G&\u0011!i\u001aCc\u000fA\u00021}\u0013AF3ySN$XM\u001c;jC2\f%m\u001d;sC\u000e$\u0018n\u001c8\u0015\r1}S\u0014GO\u001a\u0011!aJP#\u0010A\u00021-\u0003\u0002CO\u001b\u0015{\u0001\r\u0001d\u0018\u0002\tQ\u0004X\rM\u0001\u0017S:LG/[1m+:L\u0017/^3t\u0007\u0006\u0004\u0018mY5us\u00069QO\\5rk\u0016\u001cXCAO\u001f!\u0019Y)/h\u0010\r`%!Q\u0014IFt\u0005-9V-Y6ICND7+\u001a;\u0002\u0017Ut\u0017.];fg~#S-\u001d\u000b\u0005\u0017gl:\u0005\u0003\u0006\r\n)\r\u0013\u0011!a\u0001;{\t1\"\u001e8jcV,'+\u001e8JI\u0006yQO\\5rk\u0016\u0014VO\\%e?\u0012*\u0017\u000f\u0006\u0003\ftv=\u0003B\u0003G\u0005\u0015\u000f\n\t\u00111\u0001\u000e \u0005\u0011\u0002n\\<NC:LXK\\5rk\u0016$\u0016\u0010]3t\u0003\u0019)h.[9vKV!QtKO.)\u0011iJ&h\u0018\u0011\t=eQ4\f\u0003\t\u001fgQYE1\u0001\u001e^E!q\u0012\u0005G0\u0011!\u0019:Ac\u0013A\u0002ue#!\u0004+za\u0016,fn\u001e:baB,'o\u0005\u0004\u000bN-\u0005vRP\u0001\u0005a>d\u00170A\u0006fq&\u001cH/\u001a8uS\u0006d\u0017!C1o]>$\u0018\r^3e\u0003\u001dqW\u000f\u001c7bef$\"\"h\u001c\u001eruMTTOO<!\u0011a\tC#\u0014\t\u0011u\u0015$r\u000ba\u0001\u0017{D\u0001\"h\u001a\u000bX\u0001\u00071R \u0005\t;SR9\u00061\u0001\f~\"AQ4\u000eF,\u0001\u0004Yi\u0010\u0006\u0003\r`um\u0004\u0002CJ\u0004\u00153\u0002\r\u0001d\u0018\u0003\u001d\rc\u0017m]:V]^\u0014\u0018\r\u001d9feN!!2LO8)\u0011i\u001a)(\"\u0011\t1\u0005\"2\f\u0005\t;ORy\u00061\u0001\f~R!ArLOE\u0011!\u0019:A#\u0019A\u00021}\u0013!D;ooJ\f\u0007\u000fV8DY\u0006\u001c8\u000f\u0005\u0003\r\")\u0015$!D;ooJ\f\u0007\u000fV8DY\u0006\u001c8o\u0005\u0003\u000bfu\rECAOG\u0003M)hn\u001e:baR{7\u000b^1cY\u0016\u001cE.Y:t!\u0011a\tCc\u001b\u0003'UtwO]1q)>\u001cF/\u00192mK\u000ec\u0017m]:\u0014\t)-T4\u0011\u000b\u0003;/\u000b!#\u001e8xe\u0006\u0004xK]1qa\u0016\u0014H+\u001f9fgB!A\u0012\u0005F9\u0005I)hn\u001e:ba^\u0013\u0018\r\u001d9feRK\b/Z:\u0014\t)ETt\u000e\u000b\u0003;C\u000ba\"\u001a7f[\u0016tG/\u0012=ue\u0006\u001cG\u000f\u0006\u0004\r`u5V\u0014\u0017\u0005\t;_S)\b1\u0001\r \u0005I1m\u001c8uC&tWM\u001d\u0005\t'\u000fQ)\b1\u0001\r`\u0005!R\r\\3nK:$X\t\u001f;sC\u000e$x\n\u001d;j_:$ba$\u0016\u001e8ve\u0006\u0002COX\u0015o\u0002\r\u0001d\b\t\u0011M\u001d!r\u000fa\u0001\u0019?\n1\"\u001a7f[\u0016tG\u000fV3tiR1QtXOb;\u000b$Ba#@\u001eB\"Aq2\u0003F=\u0001\u0004y)\u0001\u0003\u0005\u001e0*e\u0004\u0019\u0001G\u0010\u0011!\u0019:A#\u001fA\u00021}\u0013\u0001E3mK6,g\u000e\u001e+sC:\u001chm\u001c:n)\u0019iZ-h4\u001eRR!ArLOg\u0011!y\u0019Bc\u001fA\u0002=u\u0004\u0002COX\u0015w\u0002\r\u0001d\b\t\u0011M\u001d!2\u0010a\u0001\u0019?\n1\u0004\u001e:b]N\u0004\u0018M]3oiNC\u0017\r\u001c7poR\u0013\u0018M\\:g_JlGCBOl;7lj\u000e\u0006\u0003\r`ue\u0007\u0002CH\n\u0015{\u0002\ra$ \t\u0011u=&R\u0010a\u0001\u0019?A\u0001be\u0002\u000b~\u0001\u0007ArL\u0001\u0012e\u0016\u0004\u0018mY6Fq&\u001cH/\u001a8uS\u0006dG\u0003\u0002G0;GD\u0001be\u0002\u000b\u0000\u0001\u0007ArL\u0001\u0014G>tG/Y5og\u0016C\u0018n\u001d;f]RL\u0017\r\u001c\u000b\u0005\u0017{lJ\u000f\u0003\u0005\f:*\u0005\u0005\u0019\u0001G0\u0003I)\u00070[:uK:$\u0018.\u00197t\u0013:$\u0016\u0010]3\u0015\t1-St\u001e\u0005\t\u0017sS\u0019\t1\u0001\r`\u0005I\u0011n\u001d#v[6LxJ\u001a\u000b\u0005;klZ\u0010\u0006\u0003\f~v]\b\u0002CO}\u0015\u000b\u0003\r\u0001d\u0018\u0002\tQ\f'o\u001a\u0005\t\u0017sS)\t1\u0001\r`\u0005\u0011\u0012n\u001d#v[6L\u0018\t\u001d9mS\u0016$G+\u001f9f)\u0011YiP(\u0001\t\u0011M\u001d!r\u0011a\u0001\u0019?\n\u0001\u0004^=qKB\u000b'/Y7t)>,\u00050[:uK:$\u0018.\u00197t)\u0019aYEh\u0002\u001f\n!AQr\u0007FE\u0001\u0004ay\u0002\u0003\u0005\u001dz*%\u0005\u0019\u0001G&)\u0011aYE(\u0004\t\u00115]\"2\u0012a\u0001\u0019?\t!#[:SC^LemV5uQ>,H/\u0011:hgR!1R P\n\u0011!a\u0019O#$A\u00021}\u0011!C5t%\u0006<H+\u001f9f)\u0011YiP(\u0007\t\u0011M\u001d!r\u0012a\u0001\u0019?\nQ![:SC^$ba#@\u001f y\u0005\u0002\u0002\u0003Gr\u0015#\u0003\r\u0001d\b\t\u0011U\u001d#\u0012\u0013a\u0001\u0019;B\u0003B#%\u000ery\u0015b\u0014F\u0011\u0003=O\tQ\"^:fA%\u001c(+Y<UsB,\u0017E\u0001P\u0016\u0003\u0019\u0011d&\r\u0019/c\u0005y1/\u001b8hY\u0016$xN\u001c\"pk:$7\u000f\u0006\u0003\u000e\u0002yE\u0002\u0002CGH\u0015'\u0003\r\u0001d\u0018\u0002!9,7\u000f^3e\u001b\u0016l'-\u001a:UsB,G\u0003\u0003G0=oqJDh\u000f\t\u00111\r(R\u0013a\u0001\u0019?A\u0001B$,\u000b\u0016\u0002\u0007Ar\f\u0005\t\u001doQ)\n1\u0001\r \t\u0019R*[:tS:<\u0017\t\\5bg\u000e{g\u000e\u001e:pYN1!r\u0013P!=\u000f\u0002B\u0001$\u0014\u001fD%!aT\tG,\u0005%!\u0006N]8xC\ndW\r\u0005\u0003\u001fJyESB\u0001P&\u0015\u0011qjEh\u0014\u0002\u000f\r|g\u000e\u001e:pY*!1\u0012^FM\u0013\u0011q\u001aFh\u0013\u0003!\r{g\u000e\u001e:pYRC'o\\<bE2,GC\u0001P,!\u0011a\tCc&\u0002+5L7o]5oO\u0006c\u0017.Y:Fq\u000e,\u0007\u000f^5p]V\u0011at\u000b\u0002\u0013\u001b&\u001c8/\u001b8h)f\u0004XmQ8oiJ|Gn\u0005\u0004\u000b\u001ez\u0005ct\t\u000b\u0003=G\u0002B\u0001$\t\u000b\u001e\u0006AA.\u001e2EKB$\b\u000e\u0006\u0003\u000eLy%\u0004\u0002\u0003P6\u0015C\u0003\r\u0001$\u0018\u0002\u0005Q\u001c\u0018A\u00047vE\u0012+\u0007\u000f\u001e5BI*,8\u000f\u001e\u000b\u0007\u001b\u0017r\nH(\u001e\t\u0011yM$2\u0015a\u0001\u001b\u0017\n!\u0001\u001e3\t\u0011y]$2\u0015a\u0001\u001b\u0017\n!A\u00193\u0002\u001b%tgm\u001c+za\u0016$U\r\u001d;i)\u0011iYE( \t\u00111\r(R\u0015a\u0001\u0019?\tAb]=n)f\u0004X\rR3qi\"$B!d\u0013\u001f\u0004\"AaT\u0011FT\u0001\u0004aY%\u0001\u0003ts6\u001cH\u0003BG&=\u0013C\u0001\u0002h-\u000b*\u0002\u0007ARL\u0001\fSN\u0004v\u000e];mCR,G\r\u0006\u0004\f~z=e4\u0013\u0005\t=#SY\u000b1\u0001\r`\u0005\u0019A\u000f]\u0019\t\u0011yU%2\u0016a\u0001\u0019?\n1\u0001\u001e93\u00035qwN]7bY&TX\r\u00157vgR!Ar\fPN\u0011!\u0019:A#,A\u00021}\u0013aC5t'\u0006lW\rV=qKN$ba#@\u001f\"z\u0015\u0006\u0002\u0003PR\u0015_\u0003\r\u0001$\u0018\u0002\tQ\u00048/\r\u0005\t=OSy\u000b1\u0001\r^\u0005!A\u000f]:3\u0003My&-Y:fif\u0004XMU3dkJ\u001c\u0018n\u001c8t\u0003]y&-Y:fif\u0004XMU3dkJ\u001c\u0018n\u001c8t?\u0012*\u0017\u000f\u0006\u0003\ftz=\u0006B\u0003G\u0005\u0015g\u000b\t\u00111\u0001\u000e \u0005\u0011\"-Y:fif\u0004XMU3dkJ\u001c\u0018n\u001c8t\u0003Y\u0011\u0017m]3usB,'+Z2veNLwN\\:`I\u0015\fH\u0003BFz=oC\u0001\u0002e\u0010\u000b8\u0002\u0007QrD\u0001\u0012?B,g\u000eZ5oO\n\u000b7/\u001a+za\u0016\u001cXC\u0001P_!\u0019\u0001:Eh0\r`%!a\u0014\u0019I%\u0005\u001dA\u0015m\u001d5TKR\f\u0001\u0003]3oI&twMQ1tKRK\b/Z:\u0002=%\u001cX\t\\5hS\ndWMR8s!J,g-\u001b=V]&4\u0017nY1uS>tG\u0003BF\u007f=\u0013D\u0001be\u0002\u000b>\u0002\u0007ArL\u0001\u0012SN,%O]8s\u001fJ<\u0016\u000e\u001c3dCJ$G\u0003BF\u007f=\u001fD\u0001be\u0002\u000b@\u0002\u0007ArL\u0001\rSN\u001c\u0016N\\4mKRK\b/\u001a\u000b\u0005\u0017{t*\u000e\u0003\u0005\u0014\b)\u0005\u0007\u0019\u0001G0\u00039I7oQ8ogR\fg\u000e\u001e+za\u0016$Ba#@\u001f\\\"A1s\u0001Fb\u0001\u0004ay&A\tjg\u0016C\u0018n\u001d;f]RL\u0017\r\u001c+za\u0016$Ba#@\u001fb\"A1s\u0001Fc\u0001\u0004ay&\u0001\u000bjg&k\u0007\u000f\\5dSRlU\r\u001e5pIRK\b/\u001a\u000b\u0005\u0017{t:\u000f\u0003\u0005\u0014\b)\u001d\u0007\u0019\u0001G0\u0003II7/V:fC\ndW-Q:UsB,\u0017I]4\u0015\t-uhT\u001e\u0005\t'\u000fQI\r1\u0001\r`\u0005Y\u0011n\u001d%L)f\u0004XMU3g)\u0011YiPh=\t\u0011M\u001d!2\u001aa\u0001\u0019?\n1#[:Vg\u0016\f'\r\\3BgRK\b/Z!sON$Ba#@\u001fz\"AA4\u0017Fg\u0001\u0004ai\u0006\u000b\u0003\u000bNzu\b\u0003\u0002P\u0000?\u0003i!!%\u000f\n\t}\r\u0011\u0013\b\u0002\bi\u0006LGN]3d\u0003mI7/\u00138uKJt\u0017\r\u001c+za\u0016,6/\u001a3BgRK\b/Z!sOR!1R`P\u0005\u0011!\u0019:Ac4A\u00021}\u0013!E5t\u00032<\u0018-_:WC2,X\rV=qKR!1R`P\b\u0011!\u0019:A#5A\u00021}\u0013\u0001F5t\u00032<\u0018-_:O_:4\u0016\r\\;f)f\u0004X\r\u0006\u0003\f~~U\u0001\u0002CJ\u0004\u0015'\u0004\r\u0001d\u0018\u0002'%\u001ch+\u00197vK\u0016c7/\u001a(p]Z\u000bG.^3\u0015\t-ux4\u0004\u0005\t'\u000fQ)\u000e1\u0001\r`\u0005A\u0012n\u001d(p]J+g-\u001b8f[\u0016tGo\u00117bgN$\u0016\u0010]3\u0015\t-ux\u0014\u0005\u0005\t\u0017sS9\u000e1\u0001\r`\u0005I\u0011n]*vE\u0006\u0013xm\u001d\u000b\u000b\u0017{|:c(\u000b ,}5\u0002\u0002\u0003PR\u00153\u0004\r\u0001$\u0018\t\u0011y\u001d&\u0012\u001ca\u0001\u0019;B\u0001\u0002(?\u000bZ\u0002\u0007A2\n\u0005\t1wRI\u000e1\u0001\u000eL\u0005q1\u000f]3dS\u0006d\u0017N_3t'flG\u0003CF\u007f?gy*dh\u000e\t\u0011M\u001d!2\u001ca\u0001\u0019?B\u0001\u0002d9\u000b\\\u0002\u0007Ar\u0004\u0005\t1wRY\u000e1\u0001\u000eLQa1R`P\u001e?\u007fy\u001aeh\u0012 L!AqT\bFo\u0001\u0004ay&A\u0003qe\u0016du\u000e\u0003\u0005 B)u\u0007\u0019\u0001G\u0010\u0003\u0015\u0019\u00180\u001c'p\u0011!y*E#8A\u00021}\u0013!\u00029sK\"K\u0007\u0002CP%\u0015;\u0004\r\u0001d\b\u0002\u000bMLX\u000eS5\t\u0011am$R\u001ca\u0001\u001b\u0017\n1\"\\1uG\",7\u000fV=qKRA1R`P)?'z*\u0006\u0003\u0005\u001f\u0012*}\u0007\u0019\u0001G0\u0011!q*Jc8A\u00021}\u0003\u0002CP,\u0015?\u0004\ra#@\u0002#\u0005dw/Y=t\u001b\u0006$8\r[*j[BdW-\u0001\bnCR\u001c\u0007.\u001b8h!\u0006\u0014\u0018-\\:\u0015\u0015-uxTLP1?KzJ\u0007\u0003\u0005 `)\u0005\b\u0019\u0001G&\u0003\u0015\u0019\u00180\\:2\u0011!y\u001aG#9A\u00021-\u0013!B:z[N\u0014\u0004\u0002CP4\u0015C\u0004\ra#@\u0002\u0017MLXn]\u0019jg*\u000bg/\u0019\u0005\t?WR\t\u000f1\u0001\f~\u0006Y1/_7te%\u001c(*\u0019<b\u00039I7oV5uQ&t'i\\;oIN$\"b#@ r}MtTOP<\u0011!qiKc9A\u00021}\u0003\u0002\u0003H\u001c\u0015G\u0004\r\u0001d\b\t\u0011qe(2\u001da\u0001\u0019\u0017B\u0001\"g\r\u000bd\u0002\u0007ARL\u0001\u0013K2LW.\u00118p]flw.^:DY\u0006\u001c8\u000f\u0006\u0003\r`}u\u0004\u0002\u0003Ib\u0015K\u0004\r\u0001d\u0018\u0002\u001dQL\b/\u001a,beNLe\u000eV=qKR!q4QPC!\u0019ai\u0005d\u0015\u001aN\"A1s\u0001Ft\u0001\u0004ay&\u0001\ntkN\u0004XM\u001c3j]\u001e$\u0016\u0010]3WCJ\u001cX\u0003BPF?##Ba($ \u0018R!qtRPJ!\u0011yIb(%\u0005\u0011=M\"\u0012\u001eb\u0001\u001f?A\u0011\u0002g\u001d\u000bj\u0012\u0005\ra(&\u0011\r-\rvRIPH\u0011!yJJ#;A\u0002}\r\u0015a\u0001;wg\"\"!\u0012^H&\u0003q\u0019HO]5q\u000bbL7\u000f^3oi&\fGn]!oIRK\b/\u001a,beN$ba() $~\u0015\u0006\u0003CFR%\u000bbi\u0006d\u0013\t\u0011y-$2\u001ea\u0001\u0019;B!bh*\u000blB\u0005\t\u0019AF\u007f\u0003I)\u0007\u0010]1oI2\u000b'0\u001f\"bg\u0016$\u0016\u0010]3\u0002MM$(/\u001b9Fq&\u001cH/\u001a8uS\u0006d7/\u00118e)f\u0004XMV1sg\u0012\"WMZ1vYR$#'\u0001\nnKJ<W\r\u0015:fM&D\u0018I\u001c3Be\u001e\u001cH\u0003\u0003G0?_{\u001al(0\t\u0011}E&r\u001ea\u0001\u0019;\nA\u0001\u001e9ta!AqT\u0017Fx\u0001\u0004y:,\u0001\u0005wCJL\u0017M\\2f!\u0011iie(/\n\t}m6\u0012\u0013\u0002\t-\u0006\u0014\u0018.\u00198dK\"A\u00014\u0010Fx\u0001\u0004iY%A\u0005bI\u0012lU-\u001c2feRA12_Pb?\u000b|:\r\u0003\u0005\u0013\u001a*E\b\u0019\u0001G0\u0011!\u0019:A#=A\u00021}\u0003\u0002\u0003Gr\u0015c\u0004\r\u0001d\b\u0015\u0015-Mx4ZPg?\u001f|\n\u000e\u0003\u0005\u0013\u001a*M\b\u0019\u0001G0\u0011!\u0019:Ac=A\u00021}\u0003\u0002\u0003Gr\u0015g\u0004\r\u0001d\b\t\u0011am$2\u001fa\u0001\u001b\u0017\nQ#[:KCZ\fg+\u0019:be\u001e\u001c\u0018I\\2fgR|'\u000f\u0006\u0003\f~~]\u0007\u0002CG\u001c\u0015k\u0004\r\u0001d\b\u00023%t\u0007.\u001a:jiNT\u0015M^1WCJ\f%oZ:NKRDw\u000e\u001a\u000b\u0005\u0017{|j\u000e\u0003\u0005\u000e8)]\b\u0019\u0001G\u0010\u0005%!\u0016\u0010]3FeJ|'o\u0005\u0003\u000bzz\u0005SC\u0001O4\u0003\u001d\u0001xn]0%KF$Bac= j\"QA\u0012\u0002F\u007f\u0003\u0003\u0005\r\u0001h\u001a\u0002\tA|7\u000fI\u0001\u0005[N<\u0007\u0005\u0006\u0004 r~MxT\u001f\t\u0005\u0019CQI\u0010\u0003\u0005\u001df-\u0015\u0001\u0019\u0001O4\u0011!I:l#\u0002A\u00025=F\u0003BPy?sD\u0001\"g.\f\b\u0001\u0007QrV\u0001\u0011M&dG.\u00138Ti\u0006\u001c7\u000e\u0016:bG\u0016$\"ah@\u0011\t5=\u0007\u0015A\u0005\u0005=\u000bj\tN\u0001\u000eSK\u000e|g/\u001a:bE2,7)_2mS\u000e\u0014VMZ3sK:\u001cWm\u0005\u0005\f\f}EX2CGC)\u0011\u0001K\u0001i\u0003\u0011\t1\u000522\u0002\u0005\t\u0019G\\\t\u00021\u0001\r Q!\u0001\u0015\u0002Q\b\u0011)a\u0019oc\u0005\u0011\u0002\u0003\u0007Ar\u0004\u000b\u0005\u001bG\u0004\u001b\u0002\u0003\u0006\r\n-m\u0011\u0011!a\u0001\u001b?!Ba#@!\u0018!QA\u0012BF\u0010\u0003\u0003\u0005\r!d9\u0015\t-u\b5\u0004\u0005\u000b\u0019\u0013Y\u0019#!AA\u00025\r\u0018A\u0007*fG>4XM]1cY\u0016\u001c\u0015p\u00197jGJ+g-\u001a:f]\u000e,\u0007\u0003\u0002G\u0011\u0017O\u0019bac\n!$5\u0015\u0005\u0003\u0003Mi3?ay\u0002)\u0003\u0015\u0005\u0001~A\u0003\u0002Q\u0005ASA\u0001\u0002d9\f.\u0001\u0007Ar\u0004\u000b\u0005#\u007f\u0003k\u0003\u0003\u0006\u0012h-=\u0012\u0011!a\u0001A\u0013\u0011ABT8D_6lwN\u001c+za\u0016\u001cba#\r\u001fBy\u001dC\u0003\u0002Q\u001bAo\u0001B\u0001$\t\f2!AA4WF\u001b\u0001\u0004aiFA\u0007NC24wN]7fIRK\b/Z\n\u0005\u0017oy\n\u0010\u0006\u0003!@\u0001\u0006\u0003\u0003\u0002G\u0011\u0017oA\u0001\"g.\f<\u0001\u0007Qr\u0016\u000b\u0007A\u007f\u0001+\u0005i\u0012\t\u0011956R\ba\u0001\u0019?B\u0001be\u0002\f>\u0001\u0007QrV\u0001\b?&tG-\u001a8u\u0003-y\u0016N\u001c3f]R|F%Z9\u0015\t-M\bu\n\u0005\u000b\u0019\u0013Y\t%!AA\u00025=\u0016AB5oI\u0016tG/\u0001\u0006j]\u0012,g\u000e^0%KF$Bac=!X!A\u0001sHF#\u0001\u0004iy+A\u0004fqBd\u0017-\u001b8\u0016\t\u0001v\u00035\u000e\u000b\u000b\u0017{\u0004{\u0006)\u0019!n\u0001>\u0004\u0002\u0003M:\u0017\u000f\u0002\r!d,\t\u0011=\r1r\ta\u0001AG\u0002\"bc)!f1}\u0003\u0015NF\u007f\u0013\u0011\u0001;g#'\u0003\u0013\u0019+hn\u0019;j_:\u0014\u0004\u0003BH\rAW\"\u0001bd\r\fH\t\u0007qr\u0004\u0005\t=#[9\u00051\u0001\r`!A\u0001\u0015OF$\u0001\u0004\u0001K'\u0001\u0003be\u001e\u0014\u0014\u0001D3ya2\f\u0017N\u001c+za\u0016\u001cHCBFzAo\u0002[\b\u0003\u0005!z-%\u0003\u0019\u0001G0\u0003\u00151w.\u001e8e\u0011!\u0001kh#\u0013A\u00021}\u0013\u0001\u0003:fcVL'/\u001a3\u0015\u0011-M\b\u0015\u0011QCA\u000fC\u0001\u0002g\u001d\fL\u0001\u0007\u00015\u0011\t\u000b\u0017G\u0003+\u0007d\u0018\r`5\r\b\u0002\u0003Q=\u0017\u0017\u0002\r\u0001d\u0018\t\u0011\u0001v42\na\u0001\u0019?\n!c^5uQRK\b/Z:FqBd\u0017-\u001b8fIV!\u0001U\u0012QI)\u0011\u0001{\ti%\u0011\t=e\u0001\u0015\u0013\u0003\t'\u0013ZiE1\u0001\u0010 !I\u00014OF'\t\u0003\u0007\u0001U\u0013\t\u0007\u0017G{)\u0005i$\u0002!%\u001c(i\\;oI\u0016$w)\u001a8fe&\u001cG\u0003BF\u007fA7C\u0001be\u0002\fP\u0001\u0007ArL\u0001\u0010C\u0012$7+\u001a:jC2L'0\u00192mKR!AR\fQQ\u0011!9jh#\u0015A\u0002q]\u0017aD;oG\",7m[3e\u0005>,h\u000eZ:\u0015\t1}\u0003u\u0015\u0005\t'\u000fY\u0019\u00061\u0001\r`\u0005\tbn\u001c8Ue&4\u0018.\u00197NK6\u0014WM]:\u0015\t1%\u0005U\u0016\u0005\t\u001boY)\u00061\u0001\r \u0005\t\u0012.\u001c9peR\f'\r\\3NK6\u0014WM]:\u0015\t1%\u00055\u0017\u0005\t\u001d[[9\u00061\u0001\r`\u0005AqN\u00196U_\u0006s\u0017\u0010\u0006\u0003\r`\u0001f\u0006\u0002CJ\u0004\u00173\u0002\r\u0001d\u0018\u0002/%tg/\u00197jI\u0006$X\r\u0016:fKR\u0003XmQ1dQ\u0016\u001cHCBFzA\u007f\u0003\u001b\r\u0003\u0005!B.m\u0003\u0019\u0001IU\u0003\u0011!(/Z3\t\u0011\u0001\u001672\fa\u0001\u0019\u0017\n1\"\u001e9eCR,GmU=ng\u0006\u0001\u0012N\u001c<bY&$\u0017\r^3DC\u000eDWm\u001d\u000b\u0007\u0017g\u0004[\r)4\t\u0011A\r7R\fa\u0001\u0019?B\u0001\u0002)2\f^\u0001\u0007A2J\u0001\u000bg\"|'\u000f\u001e5b]\u0012\u001cXC\u0001Qj!\u0019a\t\u0002d\u0007\u000eN\u00069AO]3f)B,WC\u0001Qm!!Y\u0019+d0\u0011*2}\u0003\u0006CF1\u001bc\u0002k\u000e)9\"\u0005\u0001~\u0017!C+tK\u0002zf\u0006\u001e9fC\t\u0001\u001b/A\u00043]E\u0012d&\r\u001a\u0002'QL\b/Z\"p]R\f\u0017N\\:UsB,g+\u0019:\u0016\u0005=\u0015\u0011a\u0007;za\u0016L5oU;c)f\u0004Xm\u00144TKJL\u0017\r\\5{C\ndW-A\u0005usB,G)\u001a9uQR!Q2\nQx\u0011!\u0019:ac\u001aA\u00021}\u0013\u0001C7bq\u0012+\u0007\u000f\u001e5\u0015\t5-\u0003U\u001f\u0005\t9g[I\u00071\u0001\r^\u0005y\u0011M]3Ue&4\u0018.\u00197UsB,7\u000f\u0006\u0003\f~\u0002n\b\u0002\u0003OZ\u0017W\u0002\r\u0001$\u0018)\t--dT`\u0001\u0011\u0003:tw\u000e^1uK\u0012$\u0016\u0010]3UC\u001e,\"!i\u0001\u0011\r\u0005\u0016\u0011uAN\u0007\u001b\tY)*\u0003\u0003\"\n-U%\u0001C\"mCN\u001cH+Y4\u0002-\t{WO\u001c3fI^KG\u000eZ2be\u0012$\u0016\u0010]3UC\u001e,\"!i\u0004\u0011\r\u0005\u0016\u0011uAI\u0010\u0003A\u0019E.Y:t\u0013:4w\u000eV=qKR\u000bw-\u0006\u0002\"\u0016A1\u0011UAQ\u0004'W\fqbQ8na>,h\u000e\u001a+za\u0016$\u0016mZ\u000b\u0003C7\u0001b!)\u0002\"\bMM\u0011aD\"p]N$\u0018M\u001c;UsB,G+Y4\u0016\u0005\u0005\u0006\u0002CBQ\u0003C\u000f)*!\u0001\nFq&\u001cH/\u001a8uS\u0006dG+\u001f9f)\u0006<WCAQ\u0014!\u0019\t+!i\u0002\u0019.\u0005iQ*\u001a;i_\u0012$\u0016\u0010]3UC\u001e,\"!)\f\u0011\r\u0005\u0016\u0011uAL\u000b\u0003QqU\u000f\u001c7beflU\r\u001e5pIRK\b/\u001a+bOV\u0011\u00115\u0007\t\u0007C\u000b\t;a&&\u0002\u0017A{G.\u001f+za\u0016$\u0016mZ\u000b\u0003Cs\u0001b!)\u0002\"\b]M\u0017A\u0004*fM&tW\r\u001a+za\u0016$\u0016mZ\u000b\u0003C\u007f\u0001b!)\u0002\"\bM\u0015\u0015\u0001E*j]\u001edW\r^8o)f\u0004X\rV1h+\t\t+\u0005\u0005\u0004\"\u0006\u0005\u001e\u0001\u0013\\\u0001\u000e'&tw\r\\3UsB,G+Y4\u0016\u0005\u0005.\u0003CBQ\u0003C\u000f\tZ.\u0001\u0007TkB,'\u000fV=qKR\u000bw-\u0006\u0002\"RA1\u0011UAQ\u0004%c\n1\u0002\u00165jgRK\b/\u001a+bOV\u0011\u0011u\u000b\t\u0007C\u000b\t;!e'\u0002\u001bQK\b/\u001a\"pk:$7\u000fV1h+\t\tk\u0006\u0005\u0004\"\u0006\u0005\u001eQ\u0012A\u0001\u000b)f\u0004XMU3g)\u0006<WCAQ2!\u0019\t+!i\u0002\u0016<\u0005AA+\u001f9f)\u0006<w-\u0006\u0002\"jA1\u0011UAQ\u0004\u0019?\u0002B!$\u0014\u0017L\u0001")
public interface Types
extends scala.reflect.api.Types,
TypeComparers,
TypeToStrings,
CommonOwners,
GlbLubs,
TypeMaps,
TypeConstraints,
FindMembers,
Collections {
    public Types$substTypeMapCache$ scala$reflect$internal$Types$$substTypeMapCache();

    public Types$UnmappableTree$ UnmappableTree();

    public Types$ErrorType$ ErrorType();

    @Override
    public Types$WildcardType$ WildcardType();

    @Override
    public Types$BoundedWildcardType$ BoundedWildcardType();

    @Override
    public Types$NoType$ NoType();

    @Override
    public Types$NoPrefix$ NoPrefix();

    @Override
    public Types$ThisType$ ThisType();

    @Override
    public Types$SingleType$ SingleType();

    @Override
    public Types$SuperType$ SuperType();

    @Override
    public Types$TypeBounds$ TypeBounds();

    public Types$CompoundType$ CompoundType();

    @Override
    public Types$RefinedType$ RefinedType();

    @Override
    public Types$ClassInfoType$ ClassInfoType();

    @Override
    public Types$ConstantType$ ConstantType();

    @Override
    public Types$TypeRef$ TypeRef();

    @Override
    public Types$MethodType$ MethodType();

    @Override
    public Types$NullaryMethodType$ NullaryMethodType();

    @Override
    public Types$PolyType$ PolyType();

    @Override
    public Types$ExistentialType$ ExistentialType();

    public Types$OverloadedType$ OverloadedType();

    public Types$ImportType$ ImportType();

    public Types$AntiPolyType$ AntiPolyType();

    public Types$HasTypeMember$ HasTypeMember();

    public Types$ArrayTypeRef$ ArrayTypeRef();

    public Types$TypeVar$ TypeVar();

    @Override
    public Types$AnnotatedType$ AnnotatedType();

    public Types$StaticallyAnnotatedType$ StaticallyAnnotatedType();

    public Types$NamedType$ NamedType();

    public Types$RepeatedType$ RepeatedType();

    public Types$ErasedValueType$ ErasedValueType();

    public Types$GenPolyType$ GenPolyType();

    public Types$unwrapToClass$ unwrapToClass();

    public Types$unwrapToStableClass$ unwrapToStableClass();

    public Types$unwrapWrapperTypes$ unwrapWrapperTypes();

    public Types$RecoverableCyclicReference$ RecoverableCyclicReference();

    public void scala$reflect$internal$Types$_setter_$scala$reflect$internal$Types$$emptySymbolSet_$eq(Set<Symbols.Symbol> var1);

    public void scala$reflect$internal$Types$_setter_$scala$reflect$internal$Types$$propagateParameterBoundsToTypeVars_$eq(boolean var1);

    public void scala$reflect$internal$Types$_setter_$scala$reflect$internal$Types$$sharperSkolems_$eq(boolean var1);

    public void scala$reflect$internal$Types$_setter_$scala$reflect$internal$Types$$_intersectionWitness_$eq(WeakHashMap<List<Type>, WeakReference<Type>> var1);

    public void scala$reflect$internal$Types$_setter_$scala$reflect$internal$Types$$initialUniquesCapacity_$eq(int var1);

    public void scala$reflect$internal$Types$_setter_$missingAliasException_$eq(MissingAliasControl var1);

    public void scala$reflect$internal$Types$_setter_$scala$reflect$internal$Types$$_pendingBaseTypes_$eq(HashSet<Type> var1);

    public void scala$reflect$internal$Types$_setter_$shorthands_$eq(Set<String> var1);

    public void scala$reflect$internal$Types$_setter_$treeTpe_$eq(Function1<Trees.Tree, Type> var1);

    public void scala$reflect$internal$Types$_setter_$typeContainsTypeVar_$eq(Function1<Type, Object> var1);

    public void scala$reflect$internal$Types$_setter_$typeIsSubTypeOfSerializable_$eq(Function1<Type, Object> var1);

    public void scala$reflect$internal$Types$_setter_$AnnotatedTypeTag_$eq(ClassTag<AnnotatedType> var1);

    public void scala$reflect$internal$Types$_setter_$BoundedWildcardTypeTag_$eq(ClassTag<BoundedWildcardType> var1);

    public void scala$reflect$internal$Types$_setter_$ClassInfoTypeTag_$eq(ClassTag<ClassInfoType> var1);

    public void scala$reflect$internal$Types$_setter_$CompoundTypeTag_$eq(ClassTag<CompoundType> var1);

    public void scala$reflect$internal$Types$_setter_$ConstantTypeTag_$eq(ClassTag<ConstantType> var1);

    public void scala$reflect$internal$Types$_setter_$ExistentialTypeTag_$eq(ClassTag<ExistentialType> var1);

    public void scala$reflect$internal$Types$_setter_$MethodTypeTag_$eq(ClassTag<MethodType> var1);

    public void scala$reflect$internal$Types$_setter_$NullaryMethodTypeTag_$eq(ClassTag<NullaryMethodType> var1);

    public void scala$reflect$internal$Types$_setter_$PolyTypeTag_$eq(ClassTag<PolyType> var1);

    public void scala$reflect$internal$Types$_setter_$RefinedTypeTag_$eq(ClassTag<RefinedType> var1);

    public void scala$reflect$internal$Types$_setter_$SingletonTypeTag_$eq(ClassTag<SingletonType> var1);

    public void scala$reflect$internal$Types$_setter_$SingleTypeTag_$eq(ClassTag<SingleType> var1);

    public void scala$reflect$internal$Types$_setter_$SuperTypeTag_$eq(ClassTag<SuperType> var1);

    public void scala$reflect$internal$Types$_setter_$ThisTypeTag_$eq(ClassTag<ThisType> var1);

    public void scala$reflect$internal$Types$_setter_$TypeBoundsTag_$eq(ClassTag<TypeBounds> var1);

    public void scala$reflect$internal$Types$_setter_$TypeRefTag_$eq(ClassTag<TypeRef> var1);

    public void scala$reflect$internal$Types$_setter_$TypeTagg_$eq(ClassTag<Type> var1);

    public boolean scala$reflect$internal$Types$$explainSwitch();

    public void scala$reflect$internal$Types$$explainSwitch_$eq(boolean var1);

    public Set<Symbols.Symbol> scala$reflect$internal$Types$$emptySymbolSet();

    public boolean scala$reflect$internal$Types$$propagateParameterBoundsToTypeVars();

    public boolean scala$reflect$internal$Types$$sharperSkolems();

    public int scala$reflect$internal$Types$$_skolemizationLevel();

    public void scala$reflect$internal$Types$$_skolemizationLevel_$eq(int var1);

    public static /* synthetic */ int skolemizationLevel$(Types $this) {
        return $this.skolemizationLevel();
    }

    default public int skolemizationLevel() {
        return this.scala$reflect$internal$Types$$_skolemizationLevel();
    }

    public static /* synthetic */ void skolemizationLevel_$eq$(Types $this, int value) {
        $this.skolemizationLevel_$eq(value);
    }

    default public void skolemizationLevel_$eq(int value) {
        this.scala$reflect$internal$Types$$_skolemizationLevel_$eq(value);
    }

    public WeakHashMap<List<Type>, WeakReference<Type>> scala$reflect$internal$Types$$_intersectionWitness();

    public static /* synthetic */ WeakHashMap intersectionWitness$(Types $this) {
        return $this.intersectionWitness();
    }

    default public WeakHashMap<List<Type>, WeakReference<Type>> intersectionWitness() {
        return this.scala$reflect$internal$Types$$_intersectionWitness();
    }

    public static /* synthetic */ void defineUnderlyingOfSingleType$(Types $this, SingleType tpe) {
        $this.defineUnderlyingOfSingleType(tpe);
    }

    /*
     * WARNING - void declaration
     */
    default public void defineUnderlyingOfSingleType(SingleType tpe) {
        int period = tpe.underlyingPeriod();
        if (period != ((SymbolTable)this).currentPeriod()) {
            tpe.underlyingPeriod_$eq(((SymbolTable)this).currentPeriod());
            if (!((SymbolTable)this).isValid(period)) {
                void assert_assertion;
                Symbols.Symbol symbol = tpe.sym();
                Symbols.NoSymbol noSymbol = ((Symbols)((Object)this)).NoSymbol();
                tpe.underlyingCache_$eq(!(symbol != null ? !symbol.equals(noSymbol) : noSymbol != null) ? this.ThisType().apply(((Mirrors.RootsBase)((Mirrors)((Object)this)).rootMirror()).RootClass()) : tpe.pre().memberType(tpe.sym()).resultType());
                boolean bl = tpe.underlyingCache() != tpe;
                SymbolTable assert_this = (SymbolTable)this;
                if (assert_assertion == false) {
                    throw assert_this.throwAssertionError(tpe);
                }
            }
        }
    }

    public static /* synthetic */ List computeBaseClasses$(Types $this, Type tpe) {
        return $this.computeBaseClasses(tpe);
    }

    default public List<Symbols.Symbol> computeBaseClasses(Type tpe) {
        List list;
        List<Type> parents = tpe.parents();
        if (parents.isEmpty() || parents.head() instanceof PackageTypeRef) {
            list = Nil$.MODULE$;
        } else {
            Type superclazz = parents.head();
            List mixins = (List)parents.tail();
            List<Symbols.Symbol> sbcs = superclazz.baseClasses();
            ObjectRef<List<Symbols.Symbol>> bcs = ObjectRef.create(sbcs);
            while (!mixins.isEmpty()) {
                bcs.elem = this.addMixinBaseClasses$1(((Type)mixins.head()).baseClasses(), bcs, superclazz, sbcs);
                mixins = (List)mixins.tail();
            }
            list = (List)bcs.elem;
        }
        Nil$ baseTail = list;
        Symbols.Symbol symbol = tpe.typeSymbol();
        return baseTail.$colon$colon(symbol);
    }

    public static /* synthetic */ void defineBaseTypeSeqOfCompoundType$(Types $this, CompoundType tpe) {
        $this.defineBaseTypeSeqOfCompoundType(tpe);
    }

    /*
     * WARNING - void declaration
     */
    default public void defineBaseTypeSeqOfCompoundType(CompoundType tpe) {
        int period = tpe.baseTypeSeqPeriod();
        if (period != ((SymbolTable)this).currentPeriod()) {
            tpe.baseTypeSeqPeriod_$eq(((SymbolTable)this).currentPeriod());
            if (!((SymbolTable)this).isValidForBaseClasses(period)) {
                if (tpe.parents().exists(this.typeContainsTypeVar())) {
                    GenMap tvarFor = Map$.MODULE$.empty();
                    TypeMaps.TypeMap varToParam = new TypeMaps.TypeMap((SymbolTable)this, (Map)tvarFor){
                        private final /* synthetic */ SymbolTable $outer;
                        private final Map tvarFor$1;

                        public Type apply(Type tp) {
                            Type type;
                            if (tp instanceof TypeVar) {
                                $colon$colon<Nothing$> $colon$colon;
                                List<Type> mapConserve_this;
                                TypeVar typeVar = (TypeVar)tp;
                                Type type2 = typeVar.origin().typeSymbol().typeConstructor();
                                List<Type> list = typeVar.typeArgs();
                                if (list == null) {
                                    throw null;
                                }
                                List<Type> list2 = mapConserve_this = list;
                                List<Type> list3 = mapConserve_this;
                                Object var7_6 = null;
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
                                    A mapConserve_loop$1_head0 = mapConserve_loop$1_pending.head();
                                    R mapConserve_loop$1_head1 = this.apply(mapConserve_loop$1_head0);
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
                                Type toOrigin = this.$outer.appliedType(type2, (List<Type>)$colon$colon);
                                this.tvarFor$1.update(toOrigin, typeVar);
                                type = toOrigin;
                            } else {
                                type = this.mapOver(tp);
                            }
                            return type;
                        }
                        {
                            if ($outer == null) {
                                throw null;
                            }
                            this.$outer = $outer;
                            this.tvarFor$1 = tvarFor$1;
                            super($outer);
                        }
                    };
                    Type tpWithoutTypeVars = this.copyRefinedType((RefinedType)tpe, tpe.parents().map(varToParam, List$.MODULE$.canBuildFrom()), varToParam.mapOver(tpe.decls()));
                    TypeMaps.TypeMap paramToVar = new TypeMaps.TypeMap((SymbolTable)this, (Map)tvarFor){
                        private final scala.collection.immutable.Map<Type, TypeVar> paramToVarMap;

                        public scala.collection.immutable.Map<Type, TypeVar> paramToVarMap() {
                            return this.paramToVarMap;
                        }

                        public Type apply(Type tp) {
                            Type type;
                            if (tp instanceof TypeRef) {
                                TypeRef typeRef = (TypeRef)tp;
                                type = (Type)this.paramToVarMap().getOrElse(typeRef, (Function0<Type> & java.io.Serializable & Serializable)() -> this.mapOver(tp));
                            } else {
                                type = this.mapOver(tp);
                            }
                            return type;
                        }
                        {
                            this.paramToVarMap = tvarFor$1.toMap(Predef$.MODULE$.$conforms());
                        }

                        private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                            return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$apply$1(scala.reflect.internal.Types$$anon$3 scala.reflect.internal.Types$Type )}, serializedLambda);
                        }
                    };
                    tpe.baseTypeSeqCache_$eq(tpWithoutTypeVars.baseTypeSeq().lateMap(paramToVar));
                } else {
                    Tuple2<Object, Object> tuple2;
                    if (StatisticsStatics.areSomeColdStatsEnabled()) {
                        void incCounter_c;
                        Statistics statistics = ((SymbolTable)this).statistics();
                        Statistics.SubCounter subCounter = ((TypesStats)((Object)((SymbolTable)this).statistics())).compoundBaseTypeSeqCount();
                        if (statistics == null) {
                            throw null;
                        }
                        if (statistics.areColdStatsLocallyEnabled() && incCounter_c != null) {
                            incCounter_c.value_$eq(incCounter_c.value() + 1);
                        }
                    }
                    if (StatisticsStatics.areSomeColdStatsEnabled()) {
                        void pushTimer_timers;
                        Statistics statistics = ((SymbolTable)this).statistics();
                        Statistics.TimerStack timerStack = ((TypesStats)((Object)((SymbolTable)this).statistics())).typeOpsStack();
                        if (statistics == null) {
                            throw null;
                        }
                        tuple2 = statistics.areColdStatsLocallyEnabled() && pushTimer_timers != null ? pushTimer_timers.push(Types.$anonfun$defineBaseTypeSeqOfCompoundType$1(this)) : null;
                    } else {
                        tuple2 = null;
                    }
                    Tuple2<Object, Object> start = tuple2;
                    try {
                        tpe.baseTypeSeqCache_$eq(((BaseTypeSeqs)((Object)this)).undetBaseTypeSeq());
                        tpe.baseTypeSeqCache_$eq(tpe.typeSymbol().isRefinementClass() ? (BaseTypeSeqs.BaseTypeSeq)tpe.memo((Function0<BaseTypeSeqs.BaseTypeSeq> & java.io.Serializable & Serializable)() -> ((BaseTypeSeqs)((Object)this)).compoundBaseTypeSeq(tpe), (Function1<Type, BaseTypeSeqs.BaseTypeSeq> & java.io.Serializable & Serializable)x$20 -> x$20.baseTypeSeq().updateHead(tpe.typeSymbol().tpe_$times())) : ((BaseTypeSeqs)((Object)this)).compoundBaseTypeSeq(tpe));
                    }
                    catch (Throwable throwable) {
                        if (StatisticsStatics.areSomeColdStatsEnabled()) {
                            void popTimer_timers;
                            Statistics statistics = ((SymbolTable)this).statistics();
                            Statistics.TimerStack timerStack = ((TypesStats)((Object)((SymbolTable)this).statistics())).typeOpsStack();
                            if (statistics == null) {
                                throw null;
                            }
                            if (statistics.areColdStatsLocallyEnabled() && popTimer_timers != null) {
                                popTimer_timers.pop(start);
                            }
                        }
                        throw throwable;
                    }
                    if (StatisticsStatics.areSomeColdStatsEnabled()) {
                        void popTimer_timers;
                        Statistics statistics = ((SymbolTable)this).statistics();
                        Statistics.TimerStack timerStack = ((TypesStats)((Object)((SymbolTable)this).statistics())).typeOpsStack();
                        if (statistics == null) {
                            throw null;
                        }
                        if (statistics.areColdStatsLocallyEnabled() && popTimer_timers != null) {
                            popTimer_timers.pop(start);
                        }
                    }
                }
            }
        }
        if (tpe.baseTypeSeqCache() == ((BaseTypeSeqs)((Object)this)).undetBaseTypeSeq()) {
            throw new TypeError((SymbolTable)this, new StringBuilder(37).append("illegal cyclic inheritance involving ").append(tpe.typeSymbol()).toString());
        }
    }

    public static /* synthetic */ void defineBaseClassesOfCompoundType$(Types $this, CompoundType tpe) {
        $this.defineBaseClassesOfCompoundType(tpe);
    }

    /*
     * WARNING - void declaration
     */
    default public void defineBaseClassesOfCompoundType(CompoundType tpe) {
        int period = tpe.baseClassesPeriod();
        if (period != ((SymbolTable)this).currentPeriod()) {
            tpe.baseClassesPeriod_$eq(((SymbolTable)this).currentPeriod());
            if (!((SymbolTable)this).isValidForBaseClasses(period)) {
                Tuple2<Object, Object> tuple2;
                if (StatisticsStatics.areSomeColdStatsEnabled()) {
                    void pushTimer_timers;
                    Statistics statistics = ((SymbolTable)this).statistics();
                    Statistics.TimerStack timerStack = ((TypesStats)((Object)((SymbolTable)this).statistics())).typeOpsStack();
                    if (statistics == null) {
                        throw null;
                    }
                    tuple2 = statistics.areColdStatsLocallyEnabled() && pushTimer_timers != null ? pushTimer_timers.push(Types.$anonfun$defineBaseClassesOfCompoundType$1(this)) : null;
                } else {
                    tuple2 = null;
                }
                Tuple2<Object, Object> start = tuple2;
                try {
                    tpe.baseClassesCache_$eq(null);
                    tpe.baseClassesCache_$eq((List)tpe.memo((Function0<List> & java.io.Serializable & Serializable)() -> this.computeBaseClasses(tpe), (Function1<Type, List> & java.io.Serializable & Serializable)x$21 -> {
                        Symbols.Symbol symbol = tpe.typeSymbol();
                        return ((List)x$21.baseClasses().tail()).$colon$colon(symbol);
                    }));
                }
                catch (Throwable throwable) {
                    if (StatisticsStatics.areSomeColdStatsEnabled()) {
                        void popTimer_timers;
                        Statistics statistics = ((SymbolTable)this).statistics();
                        Statistics.TimerStack timerStack = ((TypesStats)((Object)((SymbolTable)this).statistics())).typeOpsStack();
                        if (statistics == null) {
                            throw null;
                        }
                        if (statistics.areColdStatsLocallyEnabled() && popTimer_timers != null) {
                            popTimer_timers.pop(start);
                        }
                    }
                    throw throwable;
                }
                if (StatisticsStatics.areSomeColdStatsEnabled()) {
                    void popTimer_timers;
                    Statistics statistics = ((SymbolTable)this).statistics();
                    Statistics.TimerStack timerStack = ((TypesStats)((Object)((SymbolTable)this).statistics())).typeOpsStack();
                    if (statistics == null) {
                        throw null;
                    }
                    if (statistics.areColdStatsLocallyEnabled() && popTimer_timers != null) {
                        popTimer_timers.pop(start);
                    }
                }
            }
        }
        if (tpe.baseClassesCache() == null) {
            throw new TypeError((SymbolTable)this, new StringBuilder(35).append("illegal cyclic reference involving ").append(tpe.typeSymbol()).toString());
        }
    }

    public static /* synthetic */ void validateClassInfo$(Types $this, ClassInfoType tp) {
        $this.validateClassInfo(tp);
    }

    default public void validateClassInfo(ClassInfoType tp) {
    }

    public static /* synthetic */ Symbols.Symbol scala$reflect$internal$Types$$embeddedSymbol$(Types $this, Type tp, Names.Name name) {
        return $this.scala$reflect$internal$Types$$embeddedSymbol(tp, name);
    }

    default public Symbols.Symbol scala$reflect$internal$Types$$embeddedSymbol(Type tp, Names.Name name) {
        if (tp.typeSymbol().isRefinementClass()) {
            return tp.normalize().decls().lookup(name);
        }
        ((SymbolTable)this).debuglog((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(34).append("no embedded symbol ").append(name).append(" found in ").append(((Printers)((Object)this)).showRaw(tp, ((Printers)((Object)this)).showRaw$default$2(), ((Printers)((Object)this)).showRaw$default$3(), ((Printers)((Object)this)).showRaw$default$4(), ((Printers)((Object)this)).showRaw$default$5(), ((Printers)((Object)this)).showRaw$default$6(), ((Printers)((Object)this)).showRaw$default$7())).append(" --> ").append(tp.normalize().decls().lookup(name)).toString());
        return ((Symbols)((Object)this)).NoSymbol();
    }

    public static /* synthetic */ void defineNormalized$(Types $this, TypeRef tr) {
        $this.defineNormalized(tr);
    }

    default public void defineNormalized(TypeRef tr) {
        tr.scala$reflect$internal$Types$$defineNormalized();
    }

    public static /* synthetic */ void defineParentsOfTypeRef$(Types $this, TypeRef tpe) {
        $this.defineParentsOfTypeRef(tpe);
    }

    default public void defineParentsOfTypeRef(TypeRef tpe) {
        int period = tpe.parentsPeriod();
        if (period != ((SymbolTable)this).currentPeriod()) {
            tpe.parentsPeriod_$eq(((SymbolTable)this).currentPeriod());
            if (!((SymbolTable)this).isValidForBaseClasses(period)) {
                tpe.parentsCache_$eq(tpe.parentsImpl());
                return;
            }
            if (tpe.parentsCache() == null) {
                tpe.parentsCache_$eq(new $colon$colon<Nothing$>((Nothing$)((Object)((Definitions)((Object)this)).definitions().AnyTpe()), Nil$.MODULE$));
                return;
            }
        }
    }

    public static /* synthetic */ void defineBaseTypeSeqOfTypeRef$(Types $this, TypeRef tpe) {
        $this.defineBaseTypeSeqOfTypeRef(tpe);
    }

    /*
     * WARNING - void declaration
     */
    default public void defineBaseTypeSeqOfTypeRef(TypeRef tpe) {
        block24: {
            block23: {
                BaseTypeSeqs.BaseTypeSeq baseTypeSeq;
                BaseTypeSeqs.BaseTypeSeq baseTypeSeq2;
                block22: {
                    int period = tpe.baseTypeSeqPeriod();
                    if (period != ((SymbolTable)this).currentPeriod()) {
                        tpe.baseTypeSeqPeriod_$eq(((SymbolTable)this).currentPeriod());
                        if (!((SymbolTable)this).isValidForBaseClasses(period)) {
                            Tuple2<Object, Object> tuple2;
                            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                                void incCounter_c;
                                Statistics statistics = ((SymbolTable)this).statistics();
                                Statistics.SubCounter subCounter = ((TypesStats)((Object)((SymbolTable)this).statistics())).typerefBaseTypeSeqCount();
                                if (statistics == null) {
                                    throw null;
                                }
                                if (statistics.areColdStatsLocallyEnabled() && incCounter_c != null) {
                                    incCounter_c.value_$eq(incCounter_c.value() + 1);
                                }
                            }
                            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                                void pushTimer_timers;
                                Statistics statistics = ((SymbolTable)this).statistics();
                                Statistics.TimerStack timerStack = ((TypesStats)((Object)((SymbolTable)this).statistics())).typeOpsStack();
                                if (statistics == null) {
                                    throw null;
                                }
                                tuple2 = statistics.areColdStatsLocallyEnabled() && pushTimer_timers != null ? pushTimer_timers.push(Types.$anonfun$defineBaseTypeSeqOfTypeRef$1(this)) : null;
                            } else {
                                tuple2 = null;
                            }
                            Tuple2<Object, Object> start = tuple2;
                            try {
                                tpe.baseTypeSeqCache_$eq(((BaseTypeSeqs)((Object)this)).undetBaseTypeSeq());
                                tpe.baseTypeSeqCache_$eq(tpe.baseTypeSeqImpl());
                            }
                            catch (Throwable throwable) {
                                if (StatisticsStatics.areSomeColdStatsEnabled()) {
                                    void popTimer_timers;
                                    Statistics statistics = ((SymbolTable)this).statistics();
                                    Statistics.TimerStack timerStack = ((TypesStats)((Object)((SymbolTable)this).statistics())).typeOpsStack();
                                    if (statistics == null) {
                                        throw null;
                                    }
                                    if (statistics.areColdStatsLocallyEnabled() && popTimer_timers != null) {
                                        popTimer_timers.pop(start);
                                    }
                                }
                                throw throwable;
                            }
                            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                                void popTimer_timers;
                                Statistics statistics = ((SymbolTable)this).statistics();
                                Statistics.TimerStack timerStack = ((TypesStats)((Object)((SymbolTable)this).statistics())).typeOpsStack();
                                if (statistics == null) {
                                    throw null;
                                }
                                if (statistics.areColdStatsLocallyEnabled() && popTimer_timers != null) {
                                    popTimer_timers.pop(start);
                                }
                            }
                        }
                    }
                    baseTypeSeq2 = tpe.baseTypeSeqCache();
                    baseTypeSeq = ((BaseTypeSeqs)((Object)this)).undetBaseTypeSeq();
                    if (baseTypeSeq2 != null) break block22;
                    if (baseTypeSeq != null) {
                        return;
                    }
                    break block23;
                }
                if (!baseTypeSeq2.equals(baseTypeSeq)) break block24;
            }
            throw new TypeError((SymbolTable)this, new StringBuilder(37).append("illegal cyclic inheritance involving ").append(tpe.sym()).toString());
        }
    }

    public static /* synthetic */ Type newExistentialType$(Types $this, List quantified, Type underlying) {
        return $this.newExistentialType(quantified, underlying);
    }

    default public Type newExistentialType(List<Symbols.Symbol> quantified, Type underlying) {
        Type type;
        if (quantified.isEmpty()) {
            return underlying;
        }
        if (underlying instanceof ExistentialType) {
            ExistentialType existentialType = (ExistentialType)underlying;
            List<Symbols.Symbol> qs = existentialType.quantified();
            Type restpe = existentialType.underlying();
            type = this.newExistentialType(qs.$colon$colon$colon(quantified), restpe);
        } else {
            type = new ExistentialType((SymbolTable)this, quantified, underlying);
        }
        return type;
    }

    public static /* synthetic */ Type overloadedType$(Types $this, Type pre, List alternatives) {
        return $this.overloadedType(pre, alternatives);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    default public Type overloadedType(Type pre, List<Symbols.Symbol> alternatives) {
        void var3_6;
        if (((Object)Nil$.MODULE$).equals(alternatives)) {
            Types$NoType$ types$NoType$ = this.NoType();
            return var3_6;
        }
        if (alternatives instanceof $colon$colon) {
            $colon$colon $colon$colon = ($colon$colon)alternatives;
            Symbols.Symbol alt = (Symbols.Symbol)$colon$colon.head();
            List list = $colon$colon.tl$access$1();
            if (((Object)Nil$.MODULE$).equals(list)) {
                Type type = pre.memberType(alt);
                return var3_6;
            }
        }
        OverloadedType overloadedType = new OverloadedType((SymbolTable)this, pre, alternatives);
        return var3_6;
    }

    public static /* synthetic */ Type annotatedType$(Types $this, List annots, Type underlying) {
        return $this.annotatedType(annots, underlying);
    }

    default public Type annotatedType(List<AnnotationInfos.AnnotationInfo> annots, Type underlying) {
        if (annots.isEmpty()) {
            return underlying;
        }
        return new AnnotatedType((SymbolTable)this, annots, underlying);
    }

    private Symbols.Symbol rebind(Type pre, Symbols.Symbol sym2) {
        block6: {
            block5: {
                if (!sym2.isOverridableMember()) break block5;
                Symbols.Symbol symbol = sym2.owner();
                Symbols.Symbol symbol2 = pre.typeSymbol();
                if (symbol != null ? !symbol.equals(symbol2) : symbol2 != null) break block6;
            }
            return sym2;
        }
        Symbols.SymbolApi symbolApi = pre.nonPrivateMember(sym2.name()).suchThat((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)sym -> BoxesRunTime.boxToBoolean(Types.$anonfun$rebind$1(this, sym)));
        if (symbolApi == null) {
            throw null;
        }
        Symbols.SymbolApi orElse_this = symbolApi;
        if (orElse_this != ((Symbols.Symbol)orElse_this).scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
            return orElse_this;
        }
        return sym2;
    }

    private Type removeSuper(Type tp, Symbols.Symbol sym) {
        Type type;
        if (tp instanceof SuperType) {
            Type thistp = ((SuperType)tp).thistpe();
            type = sym.isEffectivelyFinal() || sym.isDeferred() ? thistp : tp;
        } else {
            type = tp;
        }
        return type;
    }

    public static /* synthetic */ Type singleType$(Types $this, Type pre, Symbols.Symbol sym) {
        return $this.singleType(pre, sym);
    }

    default public Type singleType(Type pre, Symbols.Symbol sym) {
        if (((SymbolTable)this).phase().erasedTypes()) {
            return sym.tpe().resultType();
        }
        if (sym.isRootPackage()) {
            return this.ThisType().apply(sym.moduleClass());
        }
        Symbols.Symbol sym1 = this.rebind(pre, sym);
        Type pre1 = this.removeSuper(pre, sym1);
        if (pre1 != pre) {
            sym1 = this.rebind(pre1, sym1);
        }
        return this.SingleType().apply(pre1, sym1);
    }

    public static /* synthetic */ Type refinedType$(Types $this, List parents, Symbols.Symbol owner, Scopes.Scope decls, Position pos) {
        return $this.refinedType(parents, owner, decls, pos);
    }

    default public Type refinedType(List<Type> parents, Symbols.Symbol owner, Scopes.Scope decls, Position pos) {
        if (((SymbolTable)this).phase().erasedTypes()) {
            if (parents.isEmpty()) {
                return ((Definitions)((Object)this)).definitions().ObjectTpe();
            }
            return parents.head();
        }
        Symbols.RefinementClassSymbol clazz = owner.newRefinementClass(pos);
        RefinedType result2 = this.RefinedType().apply(parents, decls, clazz);
        clazz.setInfo(result2);
        return result2;
    }

    public static /* synthetic */ Type refinedType$(Types $this, List parents, Symbols.Symbol owner) {
        return $this.refinedType(parents, owner);
    }

    default public Type refinedType(List<Type> parents, Symbols.Symbol owner) {
        return this.refinedType(parents, owner, ((Scopes)((Object)this)).newScope(), owner.pos());
    }

    public static /* synthetic */ Type copyRefinedType$(Types $this, RefinedType original, List parents, Scopes.Scope decls) {
        return $this.copyRefinedType(original, parents, decls);
    }

    default public Type copyRefinedType(RefinedType original, List<Type> parents, Scopes.Scope decls) {
        if (parents == original.parents() && decls == original.decls()) {
            return original;
        }
        Symbols.Symbol owner = original.typeSymbol().owner();
        Type result2 = this.isIntersectionTypeForLazyBaseType(original) ? this.intersectionTypeForLazyBaseType(parents) : this.refinedType(parents, owner);
        List syms1 = decls.toList();
        if (syms1 == null) {
            throw null;
        }
        List foreach_these = syms1;
        while (!foreach_these.isEmpty()) {
            Symbols.Symbol symbol = foreach_these.head();
            Types.$anonfun$copyRefinedType$1(result2, symbol);
            foreach_these = (List)foreach_these.tail();
        }
        List syms2 = result2.decls().toList();
        Type resultThis = result2.typeSymbol().thisType();
        if (syms2 == null) {
            throw null;
        }
        List foreach_these2 = syms2;
        while (!foreach_these2.isEmpty()) {
            Symbols.Symbol symbol = foreach_these2.head();
            symbol.modifyInfo((Function1<Type, Type> & java.io.Serializable & Serializable)x$52 -> x$52.substThisAndSym(original$1.typeSymbol(), resultThis$1, syms1$1, syms2$1));
            foreach_these2 = (List)foreach_these2.tail();
        }
        return result2;
    }

    public static /* synthetic */ Type typeRef$(Types $this, Type pre, Symbols.Symbol sym, List args2) {
        return $this.typeRef(pre, sym, args2);
    }

    /*
     * Unable to fully structure code
     */
    default public Type typeRef(Type pre, Symbols.Symbol sym, List<Type> args) {
        v0 = sym1 = sym.isAbstractType() != false ? this.rebind(pre, sym) : sym;
        if (sym1.isAliasType() && this.sameLength(sym1.info().typeParams(), args) && !sym1.lockOK()) {
            throw new RecoverableCyclicReference((SymbolTable)this, sym1);
        }
        if (!(pre instanceof SuperType)) ** GOTO lbl-1000
        var6_5 = (SuperType)pre;
        if (sym1.isEffectivelyFinal() || sym1.isDeferred()) {
            var4_6 = var6_5.thistpe();
        } else lbl-1000:
        // 2 sources

        {
            var4_6 = pre;
        }
        if (pre == var4_6) {
            return this.TypeRef().apply(pre, sym1, args);
        }
        if (sym1.isAbstractType() && !sym1.isClass()) {
            return this.typeRef(var4_6, this.rebind(var4_6, sym1), args);
        }
        return this.typeRef(var4_6, sym1, args);
    }

    public static /* synthetic */ Type copyTypeRef$(Types $this, Type tp, Type pre, Symbols.Symbol sym, List args2) {
        return $this.copyTypeRef(tp, pre, sym, args2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    default public Type copyTypeRef(Type tp, Type pre, Symbols.Symbol sym, List<Type> args2) {
        if (!(tp instanceof TypeRef)) return this.typeRef(pre, sym, args2);
        TypeRef typeRef = (TypeRef)tp;
        Type pre0 = typeRef.pre();
        Symbols.Symbol sym0 = typeRef.sym();
        Type type = pre;
        if (type == null) {
            if (pre0 != null) {
                return this.typeRef(pre, sym, args2);
            }
        } else if (!type.equals(pre0)) return this.typeRef(pre, sym, args2);
        Names.Name name = sym0.name();
        Names.Name name2 = sym.name();
        if (name == null) {
            if (name2 != null) {
                return this.typeRef(pre, sym, args2);
            }
        } else if (!name.equals(name2)) return this.typeRef(pre, sym, args2);
        if (!sym.isAliasType() || !this.sameLength(sym.info().typeParams(), args2) || sym.lockOK()) return args2 == Nil$.MODULE$ && pre == this.NoPrefix() ? sym.tpeHK() : this.TypeRef().apply(pre, sym, args2);
        throw new RecoverableCyclicReference((SymbolTable)this, sym);
    }

    public static /* synthetic */ JavaMethodType JavaMethodType$(Types $this, List params, Type resultType) {
        return $this.JavaMethodType(params, resultType);
    }

    default public JavaMethodType JavaMethodType(List<Symbols.Symbol> params, Type resultType) {
        return new JavaMethodType((SymbolTable)this, params, resultType);
    }

    public static /* synthetic */ Type copyMethodType$(Types $this, Type tp, List params, Type restpe) {
        return $this.copyMethodType(tp, params, restpe);
    }

    default public Type copyMethodType(Type tp, List<Symbols.Symbol> params, Type restpe) {
        MethodType methodType = tp instanceof JavaMethodType ? this.JavaMethodType(params, restpe) : new MethodType((SymbolTable)this, params, restpe);
        return methodType;
    }

    public static /* synthetic */ Type intersectionType$(Types $this, List tps, Symbols.Symbol owner) {
        return $this.intersectionType(tps, owner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    default public Type intersectionType(List<Type> tps, Symbols.Symbol owner) {
        if (!(tps instanceof $colon$colon)) return this.refinedType(tps, owner);
        $colon$colon $colon$colon = ($colon$colon)tps;
        Type tp = (Type)$colon$colon.head();
        List list = $colon$colon.tl$access$1();
        if (!((Object)Nil$.MODULE$).equals(list)) return this.refinedType(tps, owner);
        return tp;
    }

    public static /* synthetic */ Type intersectionType$(Types $this, List tps) {
        return $this.intersectionType(tps);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    default public Type intersectionType(List<Type> tps) {
        if (!(tps instanceof $colon$colon)) return this.refinedType(tps, this.commonOwner(tps));
        $colon$colon $colon$colon = ($colon$colon)tps;
        Type tp = (Type)$colon$colon.head();
        List list = $colon$colon.tl$access$1();
        if (!((Object)Nil$.MODULE$).equals(list)) return this.refinedType(tps, this.commonOwner(tps));
        return tp;
    }

    public static /* synthetic */ Type intersectionTypeForLazyBaseType$(Types $this, List tps) {
        return $this.intersectionTypeForLazyBaseType(tps);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    default public Type intersectionTypeForLazyBaseType(List<Type> tps) {
        void var2_7;
        if (tps instanceof $colon$colon) {
            $colon$colon $colon$colon = ($colon$colon)tps;
            Type tp = (Type)$colon$colon.head();
            List list = $colon$colon.tl$access$1();
            if (((Object)Nil$.MODULE$).equals(list)) {
                Type type = tp;
                return var2_7;
            }
        }
        RefinedType refinedType = this.RefinedType().apply(tps, ((Scopes)((Object)this)).newScope(), tps.head().typeSymbolDirect());
        return var2_7;
    }

    public static /* synthetic */ boolean isIntersectionTypeForLazyBaseType$(Types $this, RefinedType tp) {
        return $this.isIntersectionTypeForLazyBaseType(tp);
    }

    default public boolean isIntersectionTypeForLazyBaseType(RefinedType tp) {
        boolean bl;
        List<Type> list = tp.parents();
        if (list instanceof $colon$colon) {
            Type head = (Type)(($colon$colon)list).head();
            bl = tp.typeSymbolDirect() == head.typeSymbolDirect();
        } else {
            bl = false;
        }
        return bl;
    }

    public static /* synthetic */ Type appliedType$(Types $this, Type tycon, List args2) {
        return $this.appliedType(tycon, (List<Type>)args2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    default public Type appliedType(Type tycon, List<Type> args2) {
        if (args2.isEmpty()) {
            return tycon;
        }
        boolean bl = false;
        TypeRef typeRef = null;
        if (tycon instanceof TypeRef) {
            boolean bl2;
            bl = true;
            typeRef = (TypeRef)tycon;
            Type pre = typeRef.pre();
            Symbols.Symbol sym = typeRef.sym();
            if (((Definitions)((Object)this)).definitions().NothingClass().equals(sym)) {
                bl2 = true;
            } else {
                Symbols.ClassSymbol classSymbol = ((Definitions)((Object)this)).definitions().AnyClass();
                bl2 = !(classSymbol != null ? !classSymbol.equals(sym) : sym != null);
            }
            if (bl2) {
                return this.copyTypeRef(tycon, pre, sym, Nil$.MODULE$);
            }
        }
        if (bl) {
            Type pre = typeRef.pre();
            Symbols.Symbol sym = typeRef.sym();
            List<Type> list = typeRef.args();
            if (((Object)Nil$.MODULE$).equals(list)) {
                return this.copyTypeRef(tycon, pre, sym, args2);
            }
        }
        if (bl) {
            Type pre = typeRef.pre();
            Symbols.Symbol sym = typeRef.sym();
            List<Type> bogons = typeRef.args();
            ((SymbolTable)this).devWarning((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(31).append("Dropping ").append(bogons).append(" from ").append(tycon).append(" in appliedType.").toString());
            return this.copyTypeRef(tycon, pre, sym, args2);
        }
        if (tycon instanceof PolyType) {
            PolyType polyType = (PolyType)tycon;
            List<Symbols.Symbol> tparams = polyType.typeParams();
            return polyType.resultType().instantiateTypeParams(tparams, args2);
        }
        if (tycon instanceof ExistentialType) {
            ExistentialType existentialType = (ExistentialType)tycon;
            List<Symbols.Symbol> tparams = existentialType.quantified();
            Type restpe = existentialType.underlying();
            return this.newExistentialType(tparams, this.appliedType(restpe, args2));
        }
        if (tycon instanceof SingletonType) {
            SingletonType singletonType = (SingletonType)tycon;
            return this.appliedType(singletonType.widen(), args2);
        }
        if (tycon instanceof RefinedType) {
            RefinedType refinedType = (RefinedType)tycon;
            List<Type> parents = refinedType.parents();
            Scopes.Scope decls = refinedType.decls();
            return new RefinedType((SymbolTable)this, parents.map((Function1<Type, Type> & java.io.Serializable & Serializable)x$53 -> this.appliedType((Type)x$53, args2), List$.MODULE$.canBuildFrom()), decls);
        }
        if (tycon instanceof TypeBounds) {
            TypeBounds typeBounds = (TypeBounds)tycon;
            Type lo = typeBounds.lo();
            Type hi = typeBounds.hi();
            return this.TypeBounds().apply(this.appliedType(lo, args2), this.appliedType(hi, args2));
        }
        if (tycon instanceof TypeVar) {
            return ((TypeVar)tycon).applyArgs(args2);
        }
        if (tycon instanceof AnnotatedType) {
            AnnotatedType annotatedType = (AnnotatedType)tycon;
            List<AnnotationInfos.AnnotationInfo> annots = annotatedType.annotations();
            Type underlying = annotatedType.underlying();
            return new AnnotatedType((SymbolTable)this, annots, this.appliedType(underlying, args2));
        }
        boolean bl3 = this.ErrorType().equals(tycon) ? true : this.WildcardType().equals(tycon);
        if (!bl3) throw ((Reporting)((Object)this)).abort(((TypeDebugging)((Object)this)).debugString(tycon));
        return tycon;
    }

    public static /* synthetic */ Type appliedType$(Types $this, Type tycon, Seq args2) {
        return $this.appliedType(tycon, (Seq<Type>)args2);
    }

    default public Type appliedType(Type tycon, Seq<Type> args2) {
        return this.appliedType(tycon, args2.toList());
    }

    public static /* synthetic */ Type appliedType$(Types $this, Symbols.Symbol tyconSym, List args2) {
        return $this.appliedType(tyconSym, (List<Type>)args2);
    }

    default public Type appliedType(Symbols.Symbol tyconSym, List<Type> args2) {
        return this.appliedType(tyconSym.typeConstructor(), args2);
    }

    public static /* synthetic */ Type appliedType$(Types $this, Symbols.Symbol tyconSym, Seq args2) {
        return $this.appliedType(tyconSym, (Seq<Type>)args2);
    }

    default public Type appliedType(Symbols.Symbol tyconSym, Seq<Type> args2) {
        return this.appliedType(tyconSym.typeConstructor(), args2.toList());
    }

    public static /* synthetic */ Type genPolyType$(Types $this, List params, Type tpe) {
        return $this.genPolyType(params, tpe);
    }

    default public Type genPolyType(List<Symbols.Symbol> params, Type tpe) {
        return this.GenPolyType().apply(params, tpe);
    }

    public static /* synthetic */ Type polyType$(Types $this, List params, Type tpe) {
        return $this.polyType(params, tpe);
    }

    default public Type polyType(List<Symbols.Symbol> params, Type tpe) {
        return this.GenPolyType().apply(params, tpe);
    }

    public static /* synthetic */ Type typeFunAnon$(Types $this, List tps, Type body) {
        return $this.typeFunAnon(tps, body);
    }

    default public Type typeFunAnon(List<Symbols.Symbol> tps, Type body) {
        return this.typeFun(tps, body);
    }

    public static /* synthetic */ Type typeFun$(Types $this, List tps, Type body) {
        return $this.typeFun(tps, body);
    }

    default public Type typeFun(List<Symbols.Symbol> tps, Type body) {
        return new PolyType((SymbolTable)this, tps, body);
    }

    public static /* synthetic */ Type existentialAbstraction$(Types $this, List tparams, Type tpe0) {
        return $this.existentialAbstraction(tparams, tpe0);
    }

    default public Type existentialAbstraction(List<Symbols.Symbol> tparams, Type tpe0) {
        if (tparams.isEmpty()) {
            return tpe0;
        }
        Type tpe = this.normalizeAliases().apply(tpe0);
        Type tpe1 = new TypeMaps.ExistentialExtrapolation((SymbolTable)this, tparams).extrapolate(tpe);
        List tparams0 = tparams;
        ObjectRef<List> tparams1 = ObjectRef.create((List)tparams.filter((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)sym -> BoxesRunTime.boxToBoolean(tpe1.contains(sym))));
        while (true) {
            List list = (List)tparams1.elem;
            if (!(list == null ? tparams0 != null : !((Object)list).equals(tparams0))) break;
            tparams0 = (List)tparams1.elem;
            tparams1.elem = (List)tparams.filter((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)p -> BoxesRunTime.boxToBoolean(Types.$anonfun$existentialAbstraction$2(tparams1, p)));
        }
        return this.newExistentialType((List)tparams1.elem, tpe1);
    }

    public int scala$reflect$internal$Types$$initialUniquesCapacity();

    public WeakHashSet<Type> scala$reflect$internal$Types$$uniques();

    public void scala$reflect$internal$Types$$uniques_$eq(WeakHashSet<Type> var1);

    public int scala$reflect$internal$Types$$uniqueRunId();

    public void scala$reflect$internal$Types$$uniqueRunId_$eq(int var1);

    public static /* synthetic */ int howManyUniqueTypes$(Types $this) {
        return $this.howManyUniqueTypes();
    }

    default public int howManyUniqueTypes() {
        if (this.scala$reflect$internal$Types$$uniques() == null) {
            return 0;
        }
        return this.scala$reflect$internal$Types$$uniques().size();
    }

    public static /* synthetic */ Type unique$(Types $this, Type tp) {
        return $this.unique(tp);
    }

    default public <T extends Type> T unique(T tp) {
        if (this.scala$reflect$internal$Types$$uniqueRunId() != ((SymbolTable)this).currentRunId()) {
            this.scala$reflect$internal$Types$$uniques_$eq(WeakHashSet$.MODULE$.apply(this.scala$reflect$internal$Types$$initialUniquesCapacity(), WeakHashSet$.MODULE$.apply$default$2()));
            this.scala$reflect$internal$Types$$uniqueRunId_$eq(((SymbolTable)this).currentRunId());
        }
        return (T)this.scala$reflect$internal$Types$$uniques().findEntryOrUpdate(tp);
    }

    public static /* synthetic */ Type elementExtract$(Types $this, Symbols.Symbol container, Type tp) {
        return $this.elementExtract(container, tp);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    default public Type elementExtract(Symbols.Symbol container, Type tp) {
        void var3_14;
        void assert_assertion;
        boolean bl = !container.isAliasType();
        SymbolTable assert_this = (SymbolTable)this;
        if (assert_assertion == false) {
            throw assert_this.throwAssertionError(container);
        }
        Type type = this.unwrapWrapperTypes().apply(tp.baseType(container)).dealiasWiden();
        if (type instanceof TypeRef) {
            TypeRef typeRef = (TypeRef)type;
            Symbols.Symbol symbol = typeRef.sym();
            List<Type> list = typeRef.args();
            if (container.equals(symbol) && list instanceof $colon$colon) {
                $colon$colon $colon$colon = ($colon$colon)list;
                Type arg = (Type)$colon$colon.head();
                List list2 = $colon$colon.tl$access$1();
                if (((Object)Nil$.MODULE$).equals(list2)) {
                    Type type2 = arg;
                    return var3_14;
                }
            }
        }
        Types$NoType$ types$NoType$ = this.NoType();
        return var3_14;
    }

    public static /* synthetic */ Option elementExtractOption$(Types $this, Symbols.Symbol container, Type tp) {
        return $this.elementExtractOption(container, tp);
    }

    default public Option<Type> elementExtractOption(Symbols.Symbol container, Type tp) {
        Type type = this.elementExtract(container, tp);
        Option option = this.NoType().equals(type) ? None$.MODULE$ : new Some<Type>(type);
        return option;
    }

    public static /* synthetic */ boolean elementTest$(Types $this, Symbols.Symbol container, Type tp, Function1 f) {
        return $this.elementTest(container, tp, f);
    }

    default public boolean elementTest(Symbols.Symbol container, Type tp, Function1<Type, Object> f) {
        Type type = this.elementExtract(container, tp);
        boolean bl = this.NoType().equals(type) ? false : BoxesRunTime.unboxToBoolean(f.apply(type));
        return bl;
    }

    public static /* synthetic */ Type elementTransform$(Types $this, Symbols.Symbol container, Type tp, Function1 f) {
        return $this.elementTransform(container, tp, f);
    }

    default public Type elementTransform(Symbols.Symbol container, Type tp, Function1<Type, Type> f) {
        Type type = this.elementExtract(container, tp);
        Type type2 = this.NoType().equals(type) ? this.NoType() : f.apply(type);
        return type2;
    }

    public static /* synthetic */ Type transparentShallowTransform$(Types $this, Symbols.Symbol container, Type tp, Function1 f) {
        return $this.transparentShallowTransform(container, tp, f);
    }

    default public Type transparentShallowTransform(Symbols.Symbol container, Type tp, Function1<Type, Type> f) {
        Type type;
        if (tp instanceof AnnotatedType) {
            AnnotatedType annotatedType = (AnnotatedType)tp;
            Type loop$2_underlying = annotatedType.underlying();
            Type loop$2_x$1 = this.loop$2(loop$2_underlying, container, f);
            List<AnnotationInfos.AnnotationInfo> loop$2_x$2 = annotatedType.copy$default$1();
            type = annotatedType.copy(loop$2_x$2, loop$2_x$1);
        } else if (tp instanceof ExistentialType) {
            ExistentialType existentialType = (ExistentialType)tp;
            Type loop$2_underlying = existentialType.underlying();
            Type loop$2_x$3 = this.loop$2(loop$2_underlying, container, f);
            List<Symbols.Symbol> loop$2_x$4 = existentialType.copy$default$1();
            type = existentialType.copy(loop$2_x$4, loop$2_x$3);
        } else if (tp instanceof PolyType) {
            PolyType polyType = (PolyType)tp;
            Type loop$2_resultType = polyType.resultType();
            Type loop$2_x$5 = this.loop$2(loop$2_resultType, container, f);
            List<Symbols.Symbol> loop$2_x$6 = polyType.copy$default$1();
            type = polyType.copy(loop$2_x$6, loop$2_x$5);
        } else if (tp instanceof NullaryMethodType) {
            NullaryMethodType nullaryMethodType = (NullaryMethodType)tp;
            Type loop$2_resultType = nullaryMethodType.resultType();
            type = nullaryMethodType.copy(this.loop$2(loop$2_resultType, container, f));
        } else {
            Type type2 = this.elementTransform(container, tp, (Function1<Type, Type> & java.io.Serializable & Serializable)el -> this.appliedType(container, Predef$.MODULE$.wrapRefArray((Object[])new Type[]{(Type)f.apply((Type)el)})));
            if (type2 == null) {
                throw null;
            }
            Type loop$2_orElse_this = type2;
            type = loop$2_orElse_this != loop$2_orElse_this.scala$reflect$internal$Types$Type$$$outer().NoType() ? loop$2_orElse_this : Types.$anonfun$transparentShallowTransform$2(f, tp);
        }
        return type;
    }

    public static /* synthetic */ Type repackExistential$(Types $this, Type tp) {
        return $this.repackExistential(tp);
    }

    default public Type repackExistential(Type tp) {
        Type type = tp;
        Types$NoType$ types$NoType$ = this.NoType();
        if (!(type != null ? !type.equals(types$NoType$) : types$NoType$ != null)) {
            return tp;
        }
        return this.existentialAbstraction(this.existentialsInType(tp), tp);
    }

    public static /* synthetic */ boolean containsExistential$(Types $this, Type tpe) {
        return $this.containsExistential(tpe);
    }

    default public boolean containsExistential(Type tpe) {
        return tpe.exists((Function1<Type, Object> & java.io.Serializable & Serializable)x$55 -> BoxesRunTime.boxToBoolean(Types.$anonfun$containsExistential$1(x$55)));
    }

    public static /* synthetic */ List existentialsInType$(Types $this, Type tpe) {
        return $this.existentialsInType(tpe);
    }

    default public List<Symbols.Symbol> existentialsInType(Type tpe) {
        return tpe.withFilter((Function1<Type, Object> & java.io.Serializable & Serializable)x$56 -> BoxesRunTime.boxToBoolean(Types.$anonfun$existentialsInType$1(x$56))).map((Function1<Type, Symbols.Symbol> & java.io.Serializable & Serializable)x$57 -> x$57.typeSymbol());
    }

    private boolean isDummyOf(Type tpe, Type targ) {
        Symbols.Symbol sym = targ.typeSymbol();
        if (sym.isTypeParameter()) {
            Symbols.Symbol symbol = sym.owner();
            Symbols.Symbol symbol2 = tpe.typeSymbol();
            if (!(symbol != null ? !symbol.equals(symbol2) : symbol2 != null)) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isDummyAppliedType$(Types $this, Type tp) {
        return $this.isDummyAppliedType(tp);
    }

    default public boolean isDummyAppliedType(Type tp) {
        boolean bl;
        Type type = tp.dealias();
        if (type instanceof TypeRef) {
            boolean bl2;
            block5: {
                TypeRef typeRef = (TypeRef)type;
                List<Type> args2 = typeRef.args();
                if (args2 == null) {
                    throw null;
                }
                LinearSeqOptimized exists_these = args2;
                while (!exists_these.isEmpty()) {
                    Type type2 = (Type)exists_these.head();
                    if (this.isDummyOf(typeRef, type2)) {
                        bl2 = true;
                        break block5;
                    }
                    exists_these = (LinearSeqOptimized)exists_these.tail();
                }
                bl2 = false;
            }
            bl = bl2;
        } else {
            bl = false;
        }
        return bl;
    }

    public static /* synthetic */ List typeParamsToExistentials$(Types $this, Symbols.Symbol clazz, List tparams) {
        return $this.typeParamsToExistentials(clazz, tparams);
    }

    /*
     * WARNING - void declaration
     */
    default public List<Symbols.Symbol> typeParamsToExistentials(Symbols.Symbol clazz, List<Symbols.Symbol> tparams) {
        void var3_3;
        List eparams = tparams.map((Function1<Symbols.Symbol, Symbols.TypeSymbol> & java.io.Serializable & Serializable)tparam -> (Symbols.TypeSymbol)clazz.newExistential(tparam.name().toTypeName(), clazz.pos(), clazz.newExistential$default$3()).setInfo(tparam.info().bounds()), List$.MODULE$.canBuildFrom());
        if (eparams == null) {
            throw null;
        }
        List foreach_these = eparams;
        while (!foreach_these.isEmpty()) {
            Symbols.TypeSymbol typeSymbol = (Symbols.TypeSymbol)foreach_these.head();
            Types.$anonfun$typeParamsToExistentials$2(tparams, eparams, typeSymbol);
            foreach_these = (List)foreach_these.tail();
        }
        return var3_3;
    }

    public static /* synthetic */ List typeParamsToExistentials$(Types $this, Symbols.Symbol clazz) {
        return $this.typeParamsToExistentials(clazz);
    }

    default public List<Symbols.Symbol> typeParamsToExistentials(Symbols.Symbol clazz) {
        return this.typeParamsToExistentials(clazz, clazz.typeParams());
    }

    public static /* synthetic */ boolean isRawIfWithoutArgs$(Types $this, Symbols.Symbol sym) {
        return $this.isRawIfWithoutArgs(sym);
    }

    default public boolean isRawIfWithoutArgs(Symbols.Symbol sym) {
        return sym.isClass() && !sym.typeParams().isEmpty() && sym.isJavaDefined();
    }

    public static /* synthetic */ boolean isRawType$(Types $this, Type tp) {
        return $this.isRawType(tp);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    default public boolean isRawType(Type tp) {
        if (((SymbolTable)this).phase().erasedTypes()) return false;
        if (!(tp instanceof TypeRef)) return false;
        TypeRef typeRef = (TypeRef)tp;
        Symbols.Symbol sym = typeRef.sym();
        List<Type> list = typeRef.args();
        if (!((Object)Nil$.MODULE$).equals(list)) return false;
        boolean bl = this.isRawIfWithoutArgs(sym);
        if (!bl) return false;
        return true;
    }

    public static /* synthetic */ boolean isRaw$(Types $this, Symbols.Symbol sym, List args2) {
        return $this.isRaw(sym, args2);
    }

    default public boolean isRaw(Symbols.Symbol sym, List<Type> args2) {
        return !((SymbolTable)this).phase().erasedTypes() && args2.isEmpty() && this.isRawIfWithoutArgs(sym);
    }

    public static /* synthetic */ TypeBounds singletonBounds$(Types $this, Type hi) {
        return $this.singletonBounds(hi);
    }

    default public TypeBounds singletonBounds(Type hi) {
        Type type = ((Definitions)((Object)this)).definitions().SingletonClass().tpe();
        return this.TypeBounds().upper(this.intersectionType(Nil$.MODULE$.$colon$colon(type).$colon$colon(hi)));
    }

    public static /* synthetic */ Type nestedMemberType$(Types $this, Symbols.Symbol sym, Type pre, Symbols.Symbol owner) {
        return $this.nestedMemberType(sym, pre, owner);
    }

    /*
     * Unable to fully structure code
     */
    default public Type nestedMemberType(Symbols.Symbol sym, Type pre, Symbols.Symbol owner) {
        result = Types.loop$3(sym.tpeHK(), owner, pre);
        v0 = (SymbolTable)this;
        if (sym.isTerm()) ** GOTO lbl-1000
        v1 = result.typeSymbol();
        if (v1 != null && v1.equals(sym)) lbl-1000:
        // 2 sources

        {
            v2 = true;
        } else {
            v2 = false;
        }
        var6_5 = v2;
        assert_this = v0;
        if (assert_assertion == false) {
            throw assert_this.throwAssertionError(Types.$anonfun$nestedMemberType$1(result, sym));
        }
        return result;
    }

    public MissingAliasControl missingAliasException();

    public static /* synthetic */ int lubDepth$(Types $this, List ts) {
        return $this.lubDepth(ts);
    }

    default public int lubDepth(List<Type> ts) {
        int td = this.maxDepth(ts);
        int bd = this.baseTypeSeqDepth(ts);
        return this.lubDepthAdjust(td, Depth$.MODULE$.max$extension(td, bd));
    }

    /*
     * WARNING - void declaration
     */
    private int lubDepthAdjust(int td, int bd) {
        void apply_depth;
        void apply_depth2;
        void apply_depth3;
        void reflectSettingToBoolean_s;
        MutableSettings.SettingValue settingValue = ((SymbolTable)this).settings().XfullLubs();
        if (MutableSettings$.MODULE$ == null) {
            throw null;
        }
        if (BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value())) {
            return bd;
        }
        Depth$ depth$ = Depth$.MODULE$;
        int n = 3;
        if (depth$ == null) {
            throw null;
        }
        Depth$ apply_this = depth$;
        if (new Depth(bd).$less$eq(new Depth(apply_depth3 < -3 ? apply_this.AnyDepth() : apply_depth3))) {
            return bd;
        }
        Depth$ depth$2 = Depth$.MODULE$;
        int n2 = 5;
        if (depth$2 == null) {
            throw null;
        }
        Depth$ apply_this2 = depth$2;
        if (new Depth(bd).$less$eq(new Depth(apply_depth2 < -3 ? apply_this2.AnyDepth() : apply_depth2))) {
            return Depth$.MODULE$.max$extension(td, Depth$.MODULE$.decr$extension1(bd));
        }
        Depth$ depth$3 = Depth$.MODULE$;
        int n3 = 7;
        if (depth$3 == null) {
            throw null;
        }
        Depth$ apply_this3 = depth$3;
        if (new Depth(bd).$less$eq(new Depth(apply_depth < -3 ? apply_this3.AnyDepth() : apply_depth))) {
            return Depth$.MODULE$.max$extension(td, Depth$.MODULE$.decr$extension0(bd, 2));
        }
        return Depth$.MODULE$.max$extension(Depth$.MODULE$.decr$extension1(td), Depth$.MODULE$.decr$extension0(bd, 3));
    }

    private int infoTypeDepth(Symbols.Symbol sym) {
        return this.typeDepth(sym.info());
    }

    private int symTypeDepth(List<Symbols.Symbol> syms) {
        return Depth$.MODULE$.maximumBy(syms, sym -> this.infoTypeDepth((Symbols.Symbol)sym));
    }

    private int baseTypeSeqDepth(List<Type> tps) {
        return Depth$.MODULE$.maximumBy(tps, t -> t.baseTypeSeqDepth());
    }

    public static /* synthetic */ boolean isPopulated$(Types $this, Type tp1, Type tp2) {
        return $this.isPopulated(tp1, tp2);
    }

    default public boolean isPopulated(Type tp1, Type tp2) {
        return this.check$1(tp1, tp2) && this.check$1(tp2, tp1);
    }

    public static /* synthetic */ Type normalizePlus$(Types $this, Type tp) {
        return $this.normalizePlus(tp);
    }

    default public Type normalizePlus(Type tp) {
        ThisType thisType;
        SingleType singleType;
        if (this.isRawType(tp)) {
            return this.rawToExistential().apply(tp);
        }
        Type type = tp.normalize();
        Type type2 = type instanceof SingleType && (singleType = (SingleType)type).sym().isModule() ? singleType.underlying().normalize() : (type instanceof ThisType && (thisType = (ThisType)type).sym().isModuleClass() ? this.normalizePlus(thisType.underlying()) : tp.normalize());
        return type2;
    }

    public static /* synthetic */ boolean isSameTypes$(Types $this, List tps1, List tps2) {
        return $this.isSameTypes(tps1, tps2);
    }

    default public boolean isSameTypes(List<Type> tps1, List<Type> tps2) {
        boolean bl;
        block3: {
            if (tps1 == null) {
                throw null;
            }
            List<Type> list = tps2;
            LinearSeqLike corresponds_this = tps1;
            while (true) {
                GenSeq corresponds_that;
                if (corresponds_this.isEmpty()) {
                    bl = corresponds_that.isEmpty();
                    break block3;
                }
                if (!corresponds_that.nonEmpty()) break;
                Type type = (Type)corresponds_that.head();
                if (!((Type)corresponds_this.head()).$eq$colon$eq(type)) break;
                corresponds_that = (GenSeq)corresponds_that.tail();
                corresponds_this = (LinearSeqLike)corresponds_this.tail();
            }
            bl = false;
        }
        return bl;
    }

    public int scala$reflect$internal$Types$$_basetypeRecursions();

    public void scala$reflect$internal$Types$$_basetypeRecursions_$eq(int var1);

    public static /* synthetic */ int basetypeRecursions$(Types $this) {
        return $this.basetypeRecursions();
    }

    default public int basetypeRecursions() {
        return this.scala$reflect$internal$Types$$_basetypeRecursions();
    }

    public static /* synthetic */ void basetypeRecursions_$eq$(Types $this, int value) {
        $this.basetypeRecursions_$eq(value);
    }

    default public void basetypeRecursions_$eq(int value) {
        this.scala$reflect$internal$Types$$_basetypeRecursions_$eq(value);
    }

    public HashSet<Type> scala$reflect$internal$Types$$_pendingBaseTypes();

    public static /* synthetic */ HashSet pendingBaseTypes$(Types $this) {
        return $this.pendingBaseTypes();
    }

    default public HashSet<Type> pendingBaseTypes() {
        return this.scala$reflect$internal$Types$$_pendingBaseTypes();
    }

    public static /* synthetic */ boolean isEligibleForPrefixUnification$(Types $this, Type tp) {
        return $this.isEligibleForPrefixUnification(tp);
    }

    default public boolean isEligibleForPrefixUnification(Type tp) {
        boolean bl;
        if (tp instanceof SingleType) {
            SingleType singleType = (SingleType)tp;
            Type pre = singleType.pre();
            bl = !singleType.sym().hasFlag(16384) && this.isEligibleForPrefixUnification(pre);
        } else if (tp instanceof TypeVar) {
            TypeVar typeVar = (TypeVar)tp;
            TypeConstraints.TypeConstraint constr = typeVar.constr();
            bl = !typeVar.instValid() || this.isEligibleForPrefixUnification(constr.inst());
        } else {
            bl = tp instanceof RefinedType;
        }
        return bl;
    }

    public static /* synthetic */ boolean isErrorOrWildcard$(Types $this, Type tp) {
        return $this.isErrorOrWildcard(tp);
    }

    default public boolean isErrorOrWildcard(Type tp) {
        return tp == this.ErrorType() || tp == this.WildcardType();
    }

    public static /* synthetic */ boolean isSingleType$(Types $this, Type tp) {
        return $this.isSingleType(tp);
    }

    default public boolean isSingleType(Type tp) {
        boolean bl = tp instanceof ThisType ? true : (tp instanceof SuperType ? true : tp instanceof SingleType);
        boolean bl2 = bl;
        return bl2;
    }

    public static /* synthetic */ boolean isConstantType$(Types $this, Type tp) {
        return $this.isConstantType(tp);
    }

    default public boolean isConstantType(Type tp) {
        boolean bl = tp instanceof ConstantType;
        return bl;
    }

    public static /* synthetic */ boolean isExistentialType$(Types $this, Type tp) {
        return $this.isExistentialType(tp);
    }

    default public boolean isExistentialType(Type tp) {
        boolean bl = tp instanceof ExistentialType ? true : (tp != null && tp.dealias() != tp ? this.isExistentialType(tp.dealias()) : false);
        return bl;
    }

    public static /* synthetic */ boolean isImplicitMethodType$(Types $this, Type tp) {
        return $this.isImplicitMethodType(tp);
    }

    default public boolean isImplicitMethodType(Type tp) {
        boolean bl = tp instanceof MethodType ? ((MethodType)tp).isImplicit() : false;
        return bl;
    }

    public static /* synthetic */ boolean isUseableAsTypeArg$(Types $this, Type tp) {
        return $this.isUseableAsTypeArg(tp);
    }

    default public boolean isUseableAsTypeArg(Type tp) {
        return this.isInternalTypeUsedAsTypeArg(tp) || this.isHKTypeRef(tp) || this.isValueElseNonValue(tp);
    }

    private boolean isHKTypeRef(Type tp) {
        List<Type> list;
        boolean bl = tp instanceof TypeRef && ((Object)Nil$.MODULE$).equals(list = ((TypeRef)tp).args()) ? tp.isHigherKinded() : false;
        return bl;
    }

    public static /* synthetic */ boolean isUseableAsTypeArgs$(Types $this, List tps) {
        return $this.isUseableAsTypeArgs(tps);
    }

    default public boolean isUseableAsTypeArgs(List<Type> tps) {
        boolean bl;
        block2: {
            block3: {
                while (true) {
                    if (((Object)Nil$.MODULE$).equals(tps)) {
                        bl = true;
                        break block2;
                    }
                    if (!(tps instanceof $colon$colon)) break block3;
                    $colon$colon $colon$colon = ($colon$colon)tps;
                    Type x = (Type)$colon$colon.head();
                    List xs = $colon$colon.tl$access$1();
                    if (!this_.isUseableAsTypeArg(x)) break;
                    tps = xs;
                    Types this_ = (SymbolTable)this_;
                }
                bl = false;
                break block2;
            }
            throw new MatchError(tps);
        }
        return bl;
    }

    private boolean isInternalTypeUsedAsTypeArg(Type tp) {
        boolean bl = this.WildcardType().equals(tp) ? true : (tp instanceof BoundedWildcardType ? true : (this.ErrorType().equals(tp) ? true : tp instanceof TypeVar));
        return bl;
    }

    private boolean isAlwaysValueType(Type tp) {
        boolean bl = tp instanceof RefinedType ? true : (tp instanceof ExistentialType ? true : tp instanceof ConstantType);
        return bl;
    }

    private boolean isAlwaysNonValueType(Type tp) {
        boolean bl = tp instanceof OverloadedType ? true : (tp instanceof NullaryMethodType ? true : (tp instanceof MethodType ? true : tp instanceof PolyType && ((PolyType)tp).resultType() instanceof MethodType));
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean isValueElseNonValue(Type tp) {
        TypeRef typeRef;
        boolean bl;
        while (true) {
            Type underlying;
            bl = false;
            typeRef = null;
            if (this_.isAlwaysValueType(tp)) {
                return true;
            }
            if (this_.isAlwaysNonValueType(tp)) {
                return false;
            }
            if (!(tp instanceof AnnotatedType)) break;
            tp = underlying = ((AnnotatedType)tp).underlying();
            Types this_ = (SymbolTable)this_;
        }
        if (tp instanceof SingleType) {
            return ((SingleType)tp).sym().isValue();
        }
        if (tp instanceof TypeRef) {
            bl = true;
            typeRef = (TypeRef)tp;
            if (tp.isHigherKinded()) {
                return false;
            }
        }
        if (tp instanceof ThisType) {
            if (((ThisType)tp).sym().isPackageClass()) return false;
            return true;
        }
        if (bl) {
            if (typeRef.sym().isPackageClass()) return false;
            return true;
        }
        if (!(tp instanceof PolyType)) throw package$.MODULE$.error(new StringBuilder(47).append("isValueElseNonValue called with third-way type ").append(tp).toString());
        return true;
    }

    public static /* synthetic */ boolean isNonRefinementClassType$(Types $this, Type tpe) {
        return $this.isNonRefinementClassType(tpe);
    }

    default public boolean isNonRefinementClassType(Type tpe) {
        Symbols.Symbol sym;
        boolean bl = tpe instanceof SingleType ? ((SingleType)tpe).sym().isModuleClass() : (tpe instanceof TypeRef ? (sym = ((TypeRef)tpe).sym()).isClass() && !sym.isRefinementClass() : this.ErrorType().equals(tpe));
        return bl;
    }

    public static /* synthetic */ boolean isSubArgs$(Types $this, List tps1, List tps2, List tparams, int depth) {
        return $this.isSubArgs(tps1, tps2, tparams, depth);
    }

    default public boolean isSubArgs(List<Type> tps1, List<Type> tps2, List<Symbols.Symbol> tparams, int depth) {
        Function3<Type, Type, Symbols.Symbol, Object> & java.io.Serializable & Serializable intersect = (Function3<Type, Type, Symbols.Symbol, Object> & java.io.Serializable & Serializable)(t1, t2, tparam) -> BoxesRunTime.boxToBoolean(this.isSubArg$1(t1, t2, tparam, depth));
        List<Symbols.Symbol> list = tparams;
        List<Type> list2 = tps2;
        List corresponds3_xs1 = tps1;
        while (true) {
            List corresponds3_xs3;
            List corresponds3_xs2;
            if (corresponds3_xs1.isEmpty()) {
                return corresponds3_xs2.isEmpty() && corresponds3_xs3.isEmpty();
            }
            if (corresponds3_xs2.isEmpty() || corresponds3_xs3.isEmpty()) break;
            Symbols.Symbol symbol = (Symbols.Symbol)corresponds3_xs3.head();
            Type type = (Type)corresponds3_xs2.head();
            Type type2 = corresponds3_xs1.head();
            if (!this.isSubArg$1(type2, type, symbol, depth)) break;
            corresponds3_xs3 = (List)corresponds3_xs3.tail();
            corresponds3_xs2 = (List)corresponds3_xs2.tail();
            corresponds3_xs1 = (List)corresponds3_xs1.tail();
        }
        return false;
    }

    public static /* synthetic */ boolean specializesSym$(Types $this, Type tp, Symbols.Symbol sym, int depth) {
        return $this.specializesSym(tp, sym, depth);
    }

    default public boolean specializesSym(Type tp, Symbols.Symbol sym, int depth) {
        boolean isHasMember;
        Type type = sym.info();
        Types$WildcardType$ types$WildcardType$ = this.WildcardType();
        boolean bl = !(type != null ? !type.equals(types$WildcardType$) : types$WildcardType$ != null) ? true : (isHasMember = false);
        return tp.typeSymbol().isBottomSubClass(sym.owner()) || (isHasMember ? tp.hasNonPrivateMember(sym.name()) : this.specializedBy$1(tp.nonPrivateMember(sym.name()), sym, tp, depth));
    }

    public static /* synthetic */ boolean specializesSym$(Types $this, Type preLo, Symbols.Symbol symLo, Type preHi, Symbols.Symbol symHi, int depth) {
        return $this.specializesSym(preLo, symLo, preHi, symHi, depth);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    default public boolean specializesSym(Type preLo, Symbols.Symbol symLo, Type preHi, Symbols.Symbol symHi, int depth) {
        void require_requirement;
        if (!symHi.isAliasType() && !symHi.isTerm()) {
            if (!symHi.isAbstractType()) return false;
        }
        Type symHiInfo = symHi.info();
        if (symHi.isTerm()) {
            Type type = symHiInfo;
            Types$WildcardType$ types$WildcardType$ = this.WildcardType();
            if (!(type != null ? !type.equals(types$WildcardType$) : types$WildcardType$ != null)) {
                if (!symHi.isStable()) return true;
                if (!symLo.isStable()) return false;
                return true;
            }
        }
        boolean bl = symLo != ((Symbols)((Object)this)).NoSymbol() && symHi != ((Symbols)((Object)this)).NoSymbol();
        SymbolTable require_this = (SymbolTable)this;
        if (require_requirement == false) {
            throw require_this.throwRequirementError(Types.$anonfun$specializesSym$2(preLo, symLo, preHi, symHi, depth));
        }
        Type tpHi = symHiInfo.asSeenFrom(preHi, symHi.owner()).substThis(preHi.typeSymbol(), preLo);
        Type tpLo = preLo.memberType(symLo);
        ((SymbolTable)this).debuglog((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(24).append("specializesSymHi: ").append(preHi).append(" . ").append(symHi).append(" : ").append(tpHi).toString());
        ((SymbolTable)this).debuglog((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(24).append("specializesSymLo: ").append(preLo).append(" . ").append(symLo).append(" : ").append(tpLo).toString());
        if (symHi.isTerm()) {
            if (!this.isSubType(tpLo, tpHi, depth)) return false;
            if (symHi.isStable()) {
                if (!symLo.isStable()) return false;
            }
            if (!symLo.hasVolatileType()) return true;
            if (symHi.hasVolatileType()) return true;
            if (!tpHi.isWildcard()) return false;
            return true;
        }
        if (symHi.isAbstractType()) {
            if (!tpHi.bounds().containsType(tpLo)) return false;
            if (!((Kinds)((Object)this)).kindsConform(Nil$.MODULE$.$colon$colon(symHi), Nil$.MODULE$.$colon$colon(tpLo), preLo, symLo.owner())) return false;
            return true;
        }
        boolean bl2 = tpLo.$eq$colon$eq(tpHi);
        if (!bl2) return false;
        return true;
    }

    public static /* synthetic */ boolean matchesType$(Types $this, Type tp1, Type tp2, boolean alwaysMatchSimple) {
        return $this.matchesType(tp1, tp2, alwaysMatchSimple);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    default public boolean matchesType(Type tp1, Type tp2, boolean alwaysMatchSimple) {
        while (true) {
            Type res2;
            Types this_;
            if (tp1 instanceof MethodType) {
                MethodType methodType = (MethodType)tp1;
                List<Symbols.Symbol> params1 = methodType.params();
                Type res1 = methodType.resultType();
                if (tp2 instanceof MethodType) {
                    MethodType methodType2 = (MethodType)tp2;
                    List<Symbols.Symbol> params2 = methodType2.params();
                    Type res22 = methodType2.resultType();
                    if (methodType.isImplicit() != methodType2.isImplicit()) return false;
                    if (!this_.matchingParams(params1, params2, methodType.isJava(), methodType2.isJava())) return false;
                    if (!this_.matchesQuantified$1(params1, params2, res1, res22, alwaysMatchSimple)) return false;
                    return true;
                }
                if (tp2 instanceof NullaryMethodType) {
                    Type res23 = ((NullaryMethodType)tp2).resultType();
                    if (params1.isEmpty()) {
                        tp2 = res23;
                        tp1 = res1;
                        this_ = (SymbolTable)this_;
                        continue;
                    }
                    tp2 = res23;
                    this_ = (SymbolTable)this_;
                    continue;
                }
                if (tp2 instanceof ExistentialType) {
                    Type res24 = ((ExistentialType)tp2).underlying();
                    if (!alwaysMatchSimple) return false;
                    alwaysMatchSimple = true;
                    tp2 = res24;
                    this_ = (SymbolTable)this_;
                    continue;
                }
                if (!(tp2 instanceof TypeRef)) return false;
                TypeRef typeRef = (TypeRef)tp2;
                Symbols.Symbol sym = typeRef.sym();
                List<Type> list = typeRef.args();
                if (!((Object)Nil$.MODULE$).equals(list)) return false;
                if (!params1.isEmpty()) return false;
                if (!sym.isModuleClass()) return false;
                tp1 = res1;
                this_ = (SymbolTable)this_;
                continue;
            }
            if (tp1 instanceof NullaryMethodType) {
                Type res1 = ((NullaryMethodType)tp1).resultType();
                if (tp2 instanceof MethodType) {
                    MethodType methodType = (MethodType)tp2;
                    List<Symbols.Symbol> list = methodType.params();
                    Type res25 = methodType.resultType();
                    if (((Object)Nil$.MODULE$).equals(list)) {
                        tp2 = res25;
                        tp1 = res1;
                        this_ = (SymbolTable)this_;
                        continue;
                    }
                }
                if (tp2 instanceof NullaryMethodType) {
                    Type res26;
                    tp2 = res26 = ((NullaryMethodType)tp2).resultType();
                    tp1 = res1;
                    this_ = (SymbolTable)this_;
                    continue;
                }
                if (tp2 instanceof ExistentialType) {
                    Type res27 = ((ExistentialType)tp2).underlying();
                    if (!alwaysMatchSimple) return false;
                    alwaysMatchSimple = true;
                    tp2 = res27;
                    this_ = (SymbolTable)this_;
                    continue;
                }
                if (tp2 instanceof TypeRef) {
                    TypeRef typeRef = (TypeRef)tp2;
                    Symbols.Symbol sym = typeRef.sym();
                    List<Type> list = typeRef.args();
                    if (((Object)Nil$.MODULE$).equals(list) && sym.isModuleClass()) {
                        tp1 = res1;
                        this_ = (SymbolTable)this_;
                        continue;
                    }
                }
                tp1 = res1;
                this_ = (SymbolTable)this_;
                continue;
            }
            if (tp1 instanceof PolyType) {
                Type res28;
                List<Symbols.Symbol> tparams2;
                PolyType polyType = (PolyType)tp1;
                List<Symbols.Symbol> tparams1 = polyType.typeParams();
                Type res1 = polyType.resultType();
                if (tp2 instanceof PolyType) {
                    boolean bl;
                    block26: {
                        PolyType polyType2 = (PolyType)tp2;
                        tparams2 = polyType2.typeParams();
                        res28 = polyType2.resultType();
                        if (tparams1 == null) {
                            throw null;
                        }
                        List<Symbols.Symbol> list = tparams2;
                        List<Symbols.Symbol> list2 = tparams1;
                        while (true) {
                            GenSeq corresponds_that;
                            void var49_38;
                            if (var49_38.isEmpty()) {
                                bl = corresponds_that.isEmpty();
                                break block26;
                            }
                            if (!corresponds_that.nonEmpty()) break;
                            Symbols.Symbol symbol = (Symbols.Symbol)corresponds_that.head();
                            if (!Types.$anonfun$matchesType$1((Symbols.Symbol)var49_38.head(), symbol)) break;
                            corresponds_that = (GenSeq)corresponds_that.tail();
                            LinearSeqLike linearSeqLike = (LinearSeqLike)var49_38.tail();
                        }
                        bl = false;
                    }
                    if (bl) {
                        tp2 = res28;
                        tp1 = res1;
                        this_ = (SymbolTable)this_;
                        continue;
                    }
                } else {
                    if (!(tp2 instanceof ExistentialType)) return false;
                    Type res29 = ((ExistentialType)tp2).underlying();
                    if (!alwaysMatchSimple) return false;
                    alwaysMatchSimple = true;
                    tp2 = res29;
                    this_ = (SymbolTable)this_;
                    continue;
                }
                boolean bl = this_.matchesQuantified$1(tparams1, tparams2, res1, res28, alwaysMatchSimple);
                return bl;
            }
            if (tp1 instanceof ExistentialType) {
                boolean bl;
                ExistentialType existentialType = (ExistentialType)tp1;
                List<Symbols.Symbol> tparams1 = existentialType.quantified();
                Type res1 = existentialType.underlying();
                if (tp2 instanceof ExistentialType) {
                    ExistentialType existentialType2 = (ExistentialType)tp2;
                    List<Symbols.Symbol> tparams2 = existentialType2.quantified();
                    Type res210 = existentialType2.underlying();
                    bl = this_.matchesQuantified$1(tparams1, tparams2, res1, res210, alwaysMatchSimple);
                    return bl;
                } else {
                    if (alwaysMatchSimple) {
                        alwaysMatchSimple = true;
                        tp1 = res1;
                        this_ = (SymbolTable)this_;
                        continue;
                    }
                    bl = this_.lastTry$1(tp2, alwaysMatchSimple, tp1);
                }
                return bl;
            }
            if (!(tp1 instanceof TypeRef)) return this_.lastTry$1(tp2, alwaysMatchSimple, tp1);
            TypeRef typeRef = (TypeRef)tp1;
            Symbols.Symbol sym = typeRef.sym();
            List<Type> list = typeRef.args();
            if (!((Object)Nil$.MODULE$).equals(list)) return this_.lastTry$1(tp2, alwaysMatchSimple, tp1);
            if (!sym.isModuleClass()) return this_.lastTry$1(tp2, alwaysMatchSimple, tp1);
            if (tp2 instanceof MethodType) {
                MethodType methodType = (MethodType)tp2;
                List<Symbols.Symbol> list3 = methodType.params();
                Type res211 = methodType.resultType();
                if (((Object)Nil$.MODULE$).equals(list3)) {
                    tp2 = res211;
                    this_ = (SymbolTable)this_;
                    continue;
                }
            }
            if (!(tp2 instanceof NullaryMethodType)) return this_.lastTry$1(tp2, alwaysMatchSimple, tp1);
            tp2 = res2 = ((NullaryMethodType)tp2).resultType();
            this_ = (SymbolTable)this_;
        }
    }

    public static /* synthetic */ boolean matchingParams$(Types $this, List syms1, List syms2, boolean syms1isJava, boolean syms2isJava) {
        return $this.matchingParams(syms1, syms2, syms1isJava, syms2isJava);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    default public boolean matchingParams(List<Symbols.Symbol> syms1, List<Symbols.Symbol> syms2, boolean syms1isJava, boolean syms2isJava) {
        List<Symbols.Symbol> rest2;
        List<Symbols.Symbol> rest1;
        block10: {
            Type tp2;
            Type tp1;
            block11: {
                if (((Object)Nil$.MODULE$).equals(syms1)) {
                    return syms2.isEmpty();
                }
                if (!(syms1 instanceof $colon$colon)) throw new MatchError(syms1);
                $colon$colon $colon$colon = ($colon$colon)syms1;
                Symbols.Symbol sym1 = (Symbols.Symbol)$colon$colon.head();
                rest1 = $colon$colon.tl$access$1();
                if (((Object)Nil$.MODULE$).equals(syms2)) {
                    return false;
                }
                if (!(syms2 instanceof $colon$colon)) throw new MatchError(syms2);
                $colon$colon $colon$colon2 = ($colon$colon)syms2;
                Symbols.Symbol sym2 = (Symbols.Symbol)$colon$colon2.head();
                rest2 = $colon$colon2.tl$access$1();
                tp1 = sym1.tpe();
                if (tp1.$eq$colon$eq(tp2 = sym2.tpe())) break block10;
                if (!syms1isJava) break block11;
                Symbols.Symbol symbol = tp2.typeSymbol();
                Symbols.ClassSymbol classSymbol = ((Definitions)((Object)this)).definitions().ObjectClass();
                if (symbol != null ? !symbol.equals(classSymbol) : classSymbol != null) break block11;
                Symbols.Symbol symbol2 = tp1.typeSymbol();
                Symbols.ClassSymbol classSymbol2 = ((Definitions)((Object)this)).definitions().AnyClass();
                if (!(symbol2 == null ? classSymbol2 != null : !symbol2.equals(classSymbol2))) break block10;
            }
            if (!syms2isJava) return false;
            Symbols.Symbol symbol = tp1.typeSymbol();
            Symbols.ClassSymbol classSymbol = ((Definitions)((Object)this)).definitions().ObjectClass();
            if (symbol == null) {
                if (classSymbol != null) {
                    return false;
                }
            } else if (!symbol.equals(classSymbol)) return false;
            Symbols.Symbol symbol3 = tp2.typeSymbol();
            Symbols.ClassSymbol classSymbol3 = ((Definitions)((Object)this)).definitions().AnyClass();
            if (symbol3 == null) {
                if (classSymbol3 != null) {
                    return false;
                }
            } else if (!symbol3.equals(classSymbol3)) return false;
        }
        if (!this.matchingParams(rest1, rest2, syms1isJava, syms2isJava)) return false;
        return true;
    }

    public static /* synthetic */ boolean isWithinBounds$(Types $this, Type pre, Symbols.Symbol owner, List tparams, List targs) {
        return $this.isWithinBounds(pre, owner, tparams, targs);
    }

    default public boolean isWithinBounds(Type pre, Symbols.Symbol owner, List<Symbols.Symbol> tparams, List<Type> targs) {
        boolean bl;
        block15: {
            boolean bl2;
            block13: {
                if (targs == null) {
                    throw null;
                }
                LinearSeqOptimized exists_these = targs;
                while (!exists_these.isEmpty()) {
                    if (Types.$anonfun$isWithinBounds$1((Type)exists_these.head())) {
                        bl2 = true;
                        break block13;
                    }
                    exists_these = (LinearSeqOptimized)exists_these.tail();
                }
                bl2 = false;
            }
            if (bl2) {
                boolean bl3;
                block14: {
                    List list;
                    if (tparams == Nil$.MODULE$) {
                        list = Nil$.MODULE$;
                    } else {
                        $colon$colon<Nothing$> mapList_head;
                        Symbols.Symbol symbol = tparams.head();
                        $colon$colon<Nothing$> mapList_tail = mapList_head = new $colon$colon<Nothing$>((Nothing$)((Object)Types.instantiatedBound$1(symbol, pre, owner, tparams, targs)), Nil$.MODULE$);
                        for (List mapList_rest = (List)tparams.tail(); mapList_rest != Nil$.MODULE$; mapList_rest = (List)mapList_rest.tail()) {
                            symbol = (Symbols.Symbol)mapList_rest.head();
                            $colon$colon<Nothing$> mapList_next = new $colon$colon<Nothing$>((Nothing$)((Object)Types.instantiatedBound$1(symbol, pre, owner, tparams, targs)), Nil$.MODULE$);
                            mapList_tail.tl_$eq(mapList_next);
                            mapList_tail = mapList_next;
                        }
                        list = mapList_head;
                    }
                    Nil$ nil$ = list;
                    List<TypeBounds> bounds = ((AnnotationCheckers)((Object)this)).adaptBoundsToAnnotations(nil$, tparams, targs);
                    if (bounds == null) {
                        throw null;
                    }
                    List<Type> list2 = targs;
                    LinearSeqLike corresponds_this = bounds;
                    while (true) {
                        GenSeq corresponds_that;
                        if (corresponds_this.isEmpty()) {
                            bl3 = corresponds_that.isEmpty();
                            break block14;
                        }
                        if (!corresponds_that.nonEmpty()) break;
                        Type type = (Type)corresponds_that.head();
                        if (!((TypeBounds)corresponds_this.head()).containsType(type)) break;
                        corresponds_that = (GenSeq)corresponds_that.tail();
                        corresponds_this = (LinearSeqLike)corresponds_this.tail();
                    }
                    bl3 = false;
                }
                return bl3;
            }
            if (tparams == null) {
                throw null;
            }
            List<Type> list = targs;
            LinearSeqLike corresponds_this = tparams;
            while (true) {
                GenSeq corresponds_that;
                if (corresponds_this.isEmpty()) {
                    bl = corresponds_that.isEmpty();
                    break block15;
                }
                if (!corresponds_that.nonEmpty()) break;
                Type type = (Type)corresponds_that.head();
                Symbols.Symbol symbol = (Symbols.Symbol)corresponds_this.head();
                if (!Types.$anonfun$isWithinBounds$4(pre, owner, tparams, targs, symbol, type)) break;
                corresponds_that = (GenSeq)corresponds_that.tail();
                corresponds_this = (LinearSeqLike)corresponds_this.tail();
            }
            bl = false;
        }
        return bl;
    }

    public static /* synthetic */ Type elimAnonymousClass$(Types $this, Type t) {
        return $this.elimAnonymousClass(t);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    default public Type elimAnonymousClass(Type t) {
        if (!(t instanceof TypeRef)) return t;
        TypeRef typeRef = (TypeRef)t;
        Type pre = typeRef.pre();
        Symbols.Symbol clazz = typeRef.sym();
        List<Type> list = typeRef.args();
        if (!((Object)Nil$.MODULE$).equals(list)) return t;
        if (!clazz.isAnonymousClass()) return t;
        return clazz.classBound().asSeenFrom(pre, clazz.owner());
    }

    public static /* synthetic */ List typeVarsInType$(Types $this, Type tp) {
        return $this.typeVarsInType(tp);
    }

    default public List<TypeVar> typeVarsInType(Type tp) {
        ObjectRef<Nil$> tvs = ObjectRef.create(Nil$.MODULE$);
        tp.foreach((Function1<Type, BoxedUnit>)(Function1<Type, Object> & java.io.Serializable & Serializable)x0$1 -> {
            Types.$anonfun$typeVarsInType$1(tvs, x0$1);
            return BoxedUnit.UNIT;
        });
        return ((List)tvs.elem).reverse();
    }

    /*
     * WARNING - void declaration
     */
    default public <T> T suspendingTypeVars(List<TypeVar> tvs, Function0<T> op) {
        T t;
        BitSet bitSetByPredicate_bs = new BitSet();
        List bitSetByPredicate_ys = tvs;
        int bitSetByPredicate_i = 0;
        while (!bitSetByPredicate_ys.isEmpty()) {
            if (bitSetByPredicate_ys.head().scala$reflect$internal$Types$$suspended()) {
                bitSetByPredicate_bs.add(bitSetByPredicate_i);
            }
            bitSetByPredicate_ys = (List)bitSetByPredicate_ys.tail();
            ++bitSetByPredicate_i;
        }
        if (tvs == null) {
            throw null;
        }
        List foreach_these = tvs;
        while (!foreach_these.isEmpty()) {
            ((TypeVar)foreach_these.head()).scala$reflect$internal$Types$$suspended_$eq(true);
            foreach_these = (List)foreach_these.tail();
        }
        try {
            t = op.apply();
        }
        finally {
            int index = 0;
            List sss = tvs;
            while (true) {
                void var8_3;
                List list = sss;
                Nil$ nil$ = Nil$.MODULE$;
                if (!(list == null ? nil$ != null : !((Object)list).equals(nil$))) break;
                ((TypeVar)sss.head()).scala$reflect$internal$Types$$suspended_$eq(var8_3.apply(BoxesRunTime.boxToInteger(index)));
                ++index;
                sss = (List)sss.tail();
            }
        }
        return t;
    }

    public static /* synthetic */ Tuple2 stripExistentialsAndTypeVars$(Types $this, List ts, boolean expandLazyBaseType) {
        return $this.stripExistentialsAndTypeVars(ts, expandLazyBaseType);
    }

    default public Tuple2<List<Type>, List<Symbols.Symbol>> stripExistentialsAndTypeVars(List<Type> ts, boolean expandLazyBaseType) {
        boolean bl;
        block5: {
            if (ts == null) {
                throw null;
            }
            LinearSeqOptimized exists_these = ts;
            while (!exists_these.isEmpty()) {
                if (Types.$anonfun$stripExistentialsAndTypeVars$1((Type)exists_these.head())) {
                    bl = true;
                    break block5;
                }
                exists_these = (LinearSeqOptimized)exists_these.tail();
            }
            bl = false;
        }
        if (!bl) {
            return new Tuple2<List<Type>, List<Symbols.Symbol>>(ts, Nil$.MODULE$);
        }
        ListBuffer tparams = (ListBuffer)ListBuffer$.MODULE$.apply(Nil$.MODULE$);
        ListBuffer stripped = (ListBuffer)ListBuffer$.MODULE$.apply(Nil$.MODULE$);
        List foreach_these = ts;
        while (!foreach_these.isEmpty()) {
            Type type = foreach_these.head();
            this.stripType$1(type, expandLazyBaseType, ts, stripped, tparams);
            foreach_these = (List)foreach_these.tail();
        }
        return new Tuple2<List<Type>, List<Symbols.Symbol>>(stripped.toList(), tparams.toList());
    }

    public static /* synthetic */ boolean stripExistentialsAndTypeVars$default$2$(Types $this) {
        return $this.stripExistentialsAndTypeVars$default$2();
    }

    default public boolean stripExistentialsAndTypeVars$default$2() {
        return false;
    }

    public static /* synthetic */ Type mergePrefixAndArgs$(Types $this, List tps0, int variance, int depth) {
        return $this.mergePrefixAndArgs(tps0, variance, depth);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    default public Type mergePrefixAndArgs(List<Type> tps0, int variance, int depth) {
        Type type;
        Type type2;
        Type type3;
        Type type4;
        void var8_6;
        void var7_5;
        Tuple2<List<Type>, List<Symbols.Symbol>> tuple2 = this.stripExistentialsAndTypeVars(tps0, true);
        if (tuple2 == null) {
            throw new MatchError((Object)null);
        }
        List<Type> tps = tuple2._1();
        List<Symbols.Symbol> tparams = tuple2._2();
        void tps2 = var7_5;
        void tparams2 = var8_6;
        boolean bl = false;
        $colon$colon $colon$colon = null;
        if (tps2 instanceof $colon$colon) {
            bl = true;
            $colon$colon = ($colon$colon)tps2;
            Type tp = (Type)$colon$colon.head();
            List list = $colon$colon.tl$access$1();
            if (((Object)Nil$.MODULE$).equals(list)) {
                type4 = tp;
                return this.existentialAbstraction((List<Symbols.Symbol>)tparams2, type4);
            }
        }
        if (bl && (type3 = (Type)$colon$colon.head()) instanceof TypeRef) {
            Type type5;
            block20: {
                Symbols.Symbol sym = ((TypeRef)type3).sym();
                List<Type> pres = tps2.map((Function1<Type, Type> & java.io.Serializable & Serializable)x$75 -> x$75.prefix(), List$.MODULE$.canBuildFrom());
                Type pre = Variance$.MODULE$.isPositive$extension(variance) ? this.lub(pres, depth) : this.glb(pres, depth);
                List<List<?>> argss = tps2.map((Function1<Type, List> & java.io.Serializable & Serializable)x$76 -> x$76.normalize().typeArgs(), List$.MODULE$.canBuildFrom());
                ListBuffer capturedParams = new ListBuffer();
                try {
                    Types$NoType$ types$NoType$;
                    Symbols.Symbol symbol = sym;
                    Symbols.ClassSymbol classSymbol = ((Definitions)((Object)this)).definitions().ArrayClass();
                    if (!(symbol != null ? !symbol.equals(classSymbol) : classSymbol != null) && ((SymbolTable)this).phase().erasedTypes()) {
                        boolean bl2;
                        block21: {
                            void var32_27;
                            boolean bl3;
                            block19: {
                                void var30_22;
                                if (argss == null) {
                                    throw null;
                                }
                                List<List<?>> list = argss;
                                while (!var30_22.isEmpty()) {
                                    if (((List)var30_22.head()).isEmpty()) {
                                        bl3 = true;
                                        break block19;
                                    }
                                    LinearSeqOptimized linearSeqOptimized = (LinearSeqOptimized)var30_22.tail();
                                }
                                bl3 = false;
                            }
                            if (bl3) {
                                type5 = this.NoType();
                                break block20;
                            }
                            Type argH = (Type)((IterableLike)argss.head()).head();
                            if (((LinearSeqOptimized)argss.tail()).forall((Function1<List, Object> & java.io.Serializable & Serializable)x$78 -> BoxesRunTime.boxToBoolean(Types.$anonfun$mergePrefixAndArgs$4(argH, x$78)))) {
                                type5 = this.typeRef(pre, sym, new $colon$colon<Nothing$>((Nothing$)((Object)argH), Nil$.MODULE$));
                                break block20;
                            }
                            List<List<?>> list = argss;
                            while (!var32_27.isEmpty()) {
                                List list2 = (List)var32_27.head();
                                if (Types.$anonfun$mergePrefixAndArgs$5(this, list2)) {
                                    bl2 = true;
                                    break block21;
                                }
                                LinearSeqOptimized linearSeqOptimized = (LinearSeqOptimized)var32_27.tail();
                            }
                            bl2 = false;
                        }
                        type5 = bl2 ? ((Definitions)((Object)this)).definitions().ObjectTpe() : this.typeRef(pre, sym, new $colon$colon<Nothing$>((Nothing$)((Object)this.lub(argss.map((Function1<List, Type> & java.io.Serializable & Serializable)x$79 -> (Type)x$79.head(), List$.MODULE$.canBuildFrom()))), Nil$.MODULE$));
                        break block20;
                    }
                    Option option = this.transposeSafe(argss);
                    if (None$.MODULE$.equals(option)) {
                        ((SymbolTable)this).debuglog(() -> Types.$anonfun$mergePrefixAndArgs$7((List)tps2, argss));
                        types$NoType$ = this.NoType();
                    } else {
                        if (!(option instanceof Some)) throw new MatchError(option);
                        List argsst = (List)((Some)option).value();
                        IntRef capturedParamIds = IntRef.create(0);
                        List map2_xs1 = sym.typeParams();
                        ListBuffer map2_lb = new ListBuffer();
                        List map2_ys1 = map2_xs1;
                        List map2_ys2 = argsst;
                        while (!map2_ys1.isEmpty() && !map2_ys2.isEmpty()) {
                            List list = (List)map2_ys2.head();
                            Symbols.Symbol symbol2 = map2_ys1.head();
                            map2_lb.$plus$eq(Types.$anonfun$mergePrefixAndArgs$8(this, depth, variance, capturedParamIds, capturedParams, symbol2, list));
                            map2_ys1 = (List)map2_ys1.tail();
                            map2_ys2 = (List)map2_ys2.tail();
                        }
                        List<Type> list = map2_lb.toList();
                        types$NoType$ = list.contains(this.NoType()) ? this.NoType() : this.existentialAbstraction(capturedParams.toList(), this.typeRef(pre, sym, list));
                    }
                    type5 = types$NoType$;
                }
                catch (MalformedType malformedType) {
                    type5 = this.NoType();
                }
            }
            type4 = type5;
            return this.existentialAbstraction((List<Symbols.Symbol>)tparams2, type4);
        }
        if (!bl || !((type2 = (Type)$colon$colon.head()) instanceof SingleType)) throw ((Reporting)((Object)this)).abort(new StringBuilder(41).append("mergePrefixAndArgs(").append(tps2).append(", ").append(new Variance(variance)).append(", ").append(new Depth(depth)).append("): unsupported tps").toString());
        Symbols.Symbol sym = ((SingleType)type2).sym();
        List<Type> pres = tps2.map((Function1<Type, Type> & java.io.Serializable & Serializable)x$80 -> x$80.prefix(), List$.MODULE$.canBuildFrom());
        Type pre = Variance$.MODULE$.isPositive$extension(variance) ? this.lub(pres, depth) : this.glb(pres, depth);
        try {
            type = this.singleType(pre, sym);
        }
        catch (MalformedType malformedType) {
            type = this.NoType();
        }
        type4 = type;
        return this.existentialAbstraction((List<Symbols.Symbol>)tparams2, type4);
    }

    public static /* synthetic */ void addMember$(Types $this, Type thistp, Type tp, Symbols.Symbol sym) {
        $this.addMember(thistp, tp, sym);
    }

    default public void addMember(Type thistp, Type tp, Symbols.Symbol sym) {
        this.addMember(thistp, tp, sym, Depth$.MODULE$.AnyDepth());
    }

    public static /* synthetic */ void addMember$(Types $this, Type thistp, Type tp, Symbols.Symbol sym, int depth) {
        $this.addMember(thistp, tp, sym, depth);
    }

    default public void addMember(Type thistp, Type tp, Symbols.Symbol sym, int depth) {
        Symbols.Symbol symbol = sym;
        Symbols.NoSymbol noSymbol = ((Symbols)((Object)this)).NoSymbol();
        ((SymbolTable)this).assert(symbol == null ? noSymbol != null : !symbol.equals(noSymbol));
        if (!this.specializesSym(thistp, sym, depth)) {
            if (sym.isTerm()) {
                List list = tp.nonPrivateDecl(sym.name()).alternatives();
                if (list == null) {
                    throw null;
                }
                List foreach_these = list;
                while (!foreach_these.isEmpty()) {
                    Symbols.Symbol symbol2 = foreach_these.head();
                    Types.$anonfun$addMember$1(this, thistp, sym, depth, tp, symbol2);
                    foreach_these = (List)foreach_these.tail();
                }
            }
            tp.decls().enter(sym);
        }
    }

    public static /* synthetic */ boolean isJavaVarargsAncestor$(Types $this, Symbols.Symbol clazz) {
        return $this.isJavaVarargsAncestor(clazz);
    }

    default public boolean isJavaVarargsAncestor(Symbols.Symbol clazz) {
        if (clazz.isClass() && clazz.isJavaDefined()) {
            boolean bl;
            block5: {
                List<Symbols.Symbol> list = clazz.info().nonPrivateDecls();
                if (list == null) {
                    throw null;
                }
                LinearSeqOptimized exists_these = list;
                while (!exists_these.isEmpty()) {
                    Symbols.Symbol symbol = (Symbols.Symbol)exists_these.head();
                    if (Types.$anonfun$isJavaVarargsAncestor$1(this, symbol)) {
                        bl = true;
                        break block5;
                    }
                    exists_these = (LinearSeqOptimized)exists_these.tail();
                }
                bl = false;
            }
            if (bl) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean inheritsJavaVarArgsMethod$(Types $this, Symbols.Symbol clazz) {
        return $this.inheritsJavaVarArgsMethod(clazz);
    }

    default public boolean inheritsJavaVarArgsMethod(Symbols.Symbol clazz) {
        boolean bl;
        block3: {
            List<Symbols.Symbol> list = clazz.thisType().baseClasses();
            if (list == null) {
                throw null;
            }
            LinearSeqOptimized exists_these = list;
            while (!exists_these.isEmpty()) {
                Symbols.Symbol symbol = (Symbols.Symbol)exists_these.head();
                if (this.isJavaVarargsAncestor(symbol)) {
                    bl = true;
                    break block3;
                }
                exists_these = (LinearSeqOptimized)exists_these.tail();
            }
            bl = false;
        }
        return bl;
    }

    public String scala$reflect$internal$Types$$_indent();

    public void scala$reflect$internal$Types$$_indent_$eq(String var1);

    public static /* synthetic */ String indent$(Types $this) {
        return $this.indent();
    }

    default public String indent() {
        return this.scala$reflect$internal$Types$$_indent();
    }

    public static /* synthetic */ void indent_$eq$(Types $this, String value) {
        $this.indent_$eq(value);
    }

    default public void indent_$eq(String value) {
        this.scala$reflect$internal$Types$$_indent_$eq(value);
    }

    public static /* synthetic */ boolean explain$(Types $this, String op, Function2 p, Type tp1, Object arg2) {
        return $this.explain(op, p, tp1, arg2);
    }

    default public <T> boolean explain(String op, Function2<Type, T, Object> p, Type tp1, T arg2) {
        ((Reporting)((Object)this)).inform(new StringBuilder(3).append(this.indent()).append(tp1).append(" ").append(op).append(" ").append(arg2).append("?").toString());
        this.indent_$eq(new StringBuilder(2).append(this.indent()).append("  ").toString());
        boolean result2 = BoxesRunTime.unboxToBoolean(p.apply(tp1, arg2));
        String string = this.indent();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        this.indent_$eq(new StringOps(string).stripSuffix("  "));
        ((Reporting)((Object)this)).inform(new StringBuilder(0).append(this.indent()).append(result2).toString());
        return result2;
    }

    public static /* synthetic */ void explainTypes$(Types $this, Type found, Type required) {
        $this.explainTypes(found, required);
    }

    /*
     * WARNING - void declaration
     */
    default public void explainTypes(Type found, Type required) {
        void reflectSettingToBoolean_s;
        MutableSettings.SettingValue settingValue = ((SymbolTable)this).settings().explaintypes();
        if (MutableSettings$.MODULE$ == null) {
            throw null;
        }
        if (BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value())) {
            this.withTypesExplained((JFunction0$mcZ$sp & Serializable)() -> found.$less$colon$less(required));
        }
    }

    public static /* synthetic */ void explainTypes$(Types $this, Function2 op, Type found, Type required) {
        $this.explainTypes(op, found, required);
    }

    /*
     * WARNING - void declaration
     */
    default public void explainTypes(Function2<Type, Type, Object> op, Type found, Type required) {
        void reflectSettingToBoolean_s;
        MutableSettings.SettingValue settingValue = ((SymbolTable)this).settings().explaintypes();
        if (MutableSettings$.MODULE$ == null) {
            throw null;
        }
        if (BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value())) {
            this.withTypesExplained((Function0<Object> & java.io.Serializable & Serializable)() -> op.apply(found, required));
        }
    }

    public static /* synthetic */ Object withTypesExplained$(Types $this, Function0 op) {
        return $this.withTypesExplained(op);
    }

    default public <A> A withTypesExplained(Function0<A> op) {
        A a;
        boolean s = this.scala$reflect$internal$Types$$explainSwitch();
        try {
            this.scala$reflect$internal$Types$$explainSwitch_$eq(true);
            a = op.apply();
        }
        finally {
            this.scala$reflect$internal$Types$$explainSwitch_$eq(s);
        }
        return a;
    }

    public static /* synthetic */ boolean isBoundedGeneric$(Types $this, Type tp) {
        return $this.isBoundedGeneric(tp);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    default public boolean isBoundedGeneric(Type tp) {
        boolean bl = false;
        TypeRef typeRef = null;
        if (tp instanceof TypeRef) {
            bl = true;
            typeRef = (TypeRef)tp;
            if (typeRef.sym().isAbstractType()) {
                return tp.$less$colon$less(((Definitions)((Object)this)).definitions().AnyRefTpe());
            }
        }
        if (!bl) return false;
        Symbols.Symbol sym = typeRef.sym();
        if (((Definitions)((Object)this)).definitions().isPrimitiveValueClass(sym)) return false;
        return true;
    }

    public static /* synthetic */ List addSerializable$(Types $this, Seq ps) {
        return $this.addSerializable(ps);
    }

    default public List<Type> addSerializable(Seq<Type> ps) {
        if (ps.exists(this.typeIsSubTypeOfSerializable())) {
            return ps.toList();
        }
        return ((TraversableOnce)ps.$colon$plus(((Definitions)((Object)this)).definitions().SerializableTpe(), Seq$.MODULE$.canBuildFrom())).toList();
    }

    public static /* synthetic */ Type uncheckedBounds$(Types $this, Type tp) {
        return $this.uncheckedBounds(tp);
    }

    default public Type uncheckedBounds(Type tp) {
        block3: {
            block2: {
                if (tp.typeArgs().isEmpty()) break block2;
                Symbols.Symbol symbol = ((Definitions)((Object)this)).definitions().UncheckedBoundsClass();
                Symbols.NoSymbol noSymbol = ((Symbols)((Object)this)).NoSymbol();
                if (symbol != null ? !symbol.equals(noSymbol) : noSymbol != null) break block3;
            }
            return tp;
        }
        return (Type)tp.withAnnotation(((AnnotationInfos)((Object)this)).AnnotationInfo().marker(((Definitions)((Object)this)).definitions().UncheckedBoundsClass().tpe()));
    }

    public static /* synthetic */ Scopes.Scope nonTrivialMembers$(Types $this, Symbols.Symbol clazz) {
        return $this.nonTrivialMembers(clazz);
    }

    default public Scopes.Scope nonTrivialMembers(Symbols.Symbol clazz) {
        return clazz.info().members().filterNot((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)sym -> BoxesRunTime.boxToBoolean(Types.$anonfun$nonTrivialMembers$1(this, sym)));
    }

    public static /* synthetic */ Scopes.Scope importableMembers$(Types $this, Type pre) {
        return $this.importableMembers(pre);
    }

    default public Scopes.Scope importableMembers(Type pre) {
        return pre.members().filter((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)sym -> BoxesRunTime.boxToBoolean(Types.$anonfun$importableMembers$1(this, sym)));
    }

    public static /* synthetic */ Type objToAny$(Types $this, Type tp) {
        return $this.objToAny(tp);
    }

    default public Type objToAny(Type tp) {
        if (!((SymbolTable)this).phase().erasedTypes()) {
            Symbols.Symbol symbol = tp.typeSymbol();
            Symbols.ClassSymbol classSymbol = ((Definitions)((Object)this)).definitions().ObjectClass();
            if (!(symbol != null ? !symbol.equals(classSymbol) : classSymbol != null)) {
                return ((Definitions)((Object)this)).definitions().AnyTpe();
            }
        }
        return tp;
    }

    public static /* synthetic */ void invalidateTreeTpeCaches$(Types $this, Trees.Tree tree, List updatedSyms) {
        $this.invalidateTreeTpeCaches(tree, updatedSyms);
    }

    default public void invalidateTreeTpeCaches(Trees.Tree tree, List<Symbols.Symbol> updatedSyms) {
        if (updatedSyms.nonEmpty()) {
            List list = tree.withFilter((Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)t -> BoxesRunTime.boxToBoolean(Types.$anonfun$invalidateTreeTpeCaches$1(t)));
            if (list == null) {
                throw null;
            }
            List foreach_these = list;
            while (!foreach_these.isEmpty()) {
                Trees.Tree tree2 = foreach_these.head();
                Types.$anonfun$invalidateTreeTpeCaches$2(this, updatedSyms, tree2);
                foreach_these = (List)foreach_these.tail();
            }
        }
    }

    public static /* synthetic */ void invalidateCaches$(Types $this, Type t, List updatedSyms) {
        $this.invalidateCaches(t, updatedSyms);
    }

    default public void invalidateCaches(Type t, List<Symbols.Symbol> updatedSyms) {
        TypeRef typeRef;
        if (t instanceof TypeRef && updatedSyms.contains((typeRef = (TypeRef)t).sym())) {
            typeRef.scala$reflect$internal$Types$$invalidateTypeRefCaches();
            return;
        }
        if (t instanceof CompoundType) {
            boolean bl;
            CompoundType compoundType;
            block9: {
                compoundType = (CompoundType)t;
                List<Symbols.Symbol> list = compoundType.baseClasses();
                if (list == null) {
                    throw null;
                }
                LinearSeqOptimized exists_these = list;
                while (!exists_these.isEmpty()) {
                    Object a = exists_these.head();
                    if (updatedSyms.contains(a)) {
                        bl = true;
                        break block9;
                    }
                    exists_these = (LinearSeqOptimized)exists_these.tail();
                }
                bl = false;
            }
            if (bl) {
                compoundType.scala$reflect$internal$Types$$invalidatedCompoundTypeCaches();
                return;
            }
        }
        if (t instanceof SingleType) {
            Type underlying;
            SingleType singleType = (SingleType)t;
            if (updatedSyms.contains(singleType.sym())) {
                singleType.scala$reflect$internal$Types$$invalidateSingleTypeCaches();
            }
            if ((underlying = singleType.underlying()) != singleType) {
                this.invalidateCaches(underlying, updatedSyms);
                return;
            }
        }
    }

    public Set<String> shorthands();

    public Function1<Trees.Tree, Type> treeTpe();

    public Function1<Type, Object> typeContainsTypeVar();

    public Function1<Type, Object> typeIsSubTypeOfSerializable();

    public static /* synthetic */ int typeDepth$(Types $this, Type tp) {
        return $this.typeDepth(tp);
    }

    /*
     * WARNING - void declaration
     */
    default public int typeDepth(Type tp) {
        int n;
        if (tp instanceof TypeRef) {
            TypeRef typeRef = (TypeRef)tp;
            Type pre = typeRef.pre();
            List<Type> args2 = typeRef.args();
            n = Depth$.MODULE$.max$extension(this.typeDepth(pre), Depth$.MODULE$.incr$extension1(this.maxDepth(args2)));
        } else if (tp instanceof RefinedType) {
            RefinedType refinedType = (RefinedType)tp;
            List<Type> parents = refinedType.parents();
            Scopes.Scope decls = refinedType.decls();
            n = Depth$.MODULE$.max$extension(this.maxDepth(parents), Depth$.MODULE$.incr$extension1(this.symTypeDepth(decls.toList())));
        } else if (tp instanceof TypeBounds) {
            TypeBounds typeBounds = (TypeBounds)tp;
            Type lo = typeBounds.lo();
            Type hi = typeBounds.hi();
            n = Depth$.MODULE$.max$extension(this.typeDepth(lo), this.typeDepth(hi));
        } else if (tp instanceof MethodType) {
            Type result2 = ((MethodType)tp).resultType();
            n = this.typeDepth(result2);
        } else if (tp instanceof NullaryMethodType) {
            Type result3 = ((NullaryMethodType)tp).resultType();
            n = this.typeDepth(result3);
        } else if (tp instanceof PolyType) {
            PolyType polyType = (PolyType)tp;
            List<Symbols.Symbol> tparams = polyType.typeParams();
            Type result4 = polyType.resultType();
            n = Depth$.MODULE$.max$extension(this.typeDepth(result4), Depth$.MODULE$.incr$extension1(this.symTypeDepth(tparams)));
        } else if (tp instanceof ExistentialType) {
            ExistentialType existentialType = (ExistentialType)tp;
            List<Symbols.Symbol> tparams = existentialType.quantified();
            Type result5 = existentialType.underlying();
            n = Depth$.MODULE$.max$extension(this.typeDepth(result5), Depth$.MODULE$.incr$extension1(this.symTypeDepth(tparams)));
        } else {
            void apply_depth;
            Depth$ depth$ = Depth$.MODULE$;
            boolean bl = true;
            if (depth$ == null) {
                throw null;
            }
            Depth$ apply_this = depth$;
            n = apply_depth < -3 ? apply_this.AnyDepth() : apply_depth;
        }
        return n;
    }

    public static /* synthetic */ int maxDepth$(Types $this, List tps) {
        return $this.maxDepth(tps);
    }

    default public int maxDepth(List<Type> tps) {
        return Depth$.MODULE$.maximumBy(tps, tp -> this.typeDepth((Type)tp));
    }

    public static /* synthetic */ boolean scala$reflect$internal$Types$$areTrivialTypes$(Types $this, List tps) {
        return $this.scala$reflect$internal$Types$$areTrivialTypes(tps);
    }

    default public boolean scala$reflect$internal$Types$$areTrivialTypes(List<Type> tps) {
        boolean bl;
        block2: {
            while (tps instanceof $colon$colon) {
                $colon$colon $colon$colon = ($colon$colon)tps;
                Type tp = (Type)$colon$colon.head();
                List rest = $colon$colon.tl$access$1();
                if (tp.isTrivial()) {
                    tps = rest;
                    Types this_ = (SymbolTable)this_;
                    continue;
                }
                bl = false;
                break block2;
            }
            bl = true;
        }
        return bl;
    }

    public ClassTag<AnnotatedType> AnnotatedTypeTag();

    public ClassTag<BoundedWildcardType> BoundedWildcardTypeTag();

    public ClassTag<ClassInfoType> ClassInfoTypeTag();

    public ClassTag<CompoundType> CompoundTypeTag();

    public ClassTag<ConstantType> ConstantTypeTag();

    public ClassTag<ExistentialType> ExistentialTypeTag();

    public ClassTag<MethodType> MethodTypeTag();

    public ClassTag<NullaryMethodType> NullaryMethodTypeTag();

    public ClassTag<PolyType> PolyTypeTag();

    public ClassTag<RefinedType> RefinedTypeTag();

    public ClassTag<SingletonType> SingletonTypeTag();

    public ClassTag<SingleType> SingleTypeTag();

    public ClassTag<SuperType> SuperTypeTag();

    public ClassTag<ThisType> ThisTypeTag();

    public ClassTag<TypeBounds> TypeBoundsTag();

    public ClassTag<TypeRef> TypeRefTag();

    public ClassTag<Type> TypeTagg();

    private static boolean isNew$1(Symbols.Symbol clazz, Type superclazz$1, ObjectRef bcs$1, List sbcs$1) {
        if (superclazz$1.baseTypeIndex(clazz) < 0) {
            List p;
            for (p = (List)bcs$1.elem; p != sbcs$1; p = (List)p.tail()) {
                Object a = p.head();
                if (!(a == null ? clazz != null : !a.equals(clazz))) break;
            }
            if (p == sbcs$1) {
                return true;
            }
        }
        return false;
    }

    private List addMixinBaseClasses$1(List mbcs, ObjectRef bcs$1, Type superclazz$1, List sbcs$1) {
        while (!mbcs.isEmpty()) {
            if (Types.isNew$1((Symbols.Symbol)mbcs.head(), superclazz$1, bcs$1, sbcs$1)) {
                Symbols.Symbol symbol = (Symbols.Symbol)mbcs.head();
                return this_.addMixinBaseClasses$1((List)mbcs.tail(), bcs$1, superclazz$1, sbcs$1).$colon$colon(symbol);
            }
            mbcs = (List)mbcs.tail();
            Types this_ = (SymbolTable)this_;
        }
        return (List)bcs$1.elem;
    }

    public static /* synthetic */ Statistics.StackableTimer $anonfun$defineBaseTypeSeqOfCompoundType$1(Types $this) {
        return ((TypesStats)((Object)((SymbolTable)$this).statistics())).baseTypeSeqNanos();
    }

    public static /* synthetic */ Statistics.StackableTimer $anonfun$defineBaseClassesOfCompoundType$1(Types $this) {
        return ((TypesStats)((Object)((SymbolTable)$this).statistics())).baseClassesNanos();
    }

    public static /* synthetic */ Statistics.StackableTimer $anonfun$defineBaseTypeSeqOfTypeRef$1(Types $this) {
        return ((TypesStats)((Object)((SymbolTable)$this).statistics())).baseTypeSeqNanos();
    }

    public static /* synthetic */ boolean $anonfun$rebind$1(Types $this, Symbols.Symbol sym) {
        boolean isModuleWithAccessor;
        boolean bl = isModuleWithAccessor = ((SymbolTable)$this).phase().assignsFields() && sym.isModuleNotMethod();
        return sym.isType() || !isModuleWithAccessor && sym.isStable() && !sym.hasVolatileType();
    }

    public static /* synthetic */ Symbols.Symbol $anonfun$copyRefinedType$1(Type result$1, Symbols.Symbol sym) {
        return result$1.decls().enter(sym.cloneSymbol(result$1.typeSymbol()).resetFlag(2L));
    }

    public static /* synthetic */ String $anonfun$appliedType$1(Types $this, Type tycon$1, List args$3) {
        String tapp_s = new StringBuilder(2).append(tycon$1).append("[").append(args$3.mkString(", ")).append("]").toString();
        String arg_s = ((TraversableOnce)((List)args$3.filterNot((Function1<Type, Object> & java.io.Serializable & Serializable)tp -> BoxesRunTime.boxToBoolean($this.isUseableAsTypeArg(tp)))).map((Function1<Type, String> & java.io.Serializable & Serializable)t -> new StringBuilder(0).append(Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(t), "/")).append(t.getClass()).toString(), List$.MODULE$.canBuildFrom())).mkString(", ");
        return new StringBuilder(32).append(tapp_s).append(" includes illegal type argument ").append(arg_s).toString();
    }

    public static /* synthetic */ boolean $anonfun$existentialAbstraction$3(Symbols.Symbol p$1, Symbols.Symbol p1) {
        Symbols.Symbol symbol = p1;
        return !(symbol == null ? p$1 != null : !symbol.equals(p$1)) || p1.info().contains(p$1);
    }

    public static /* synthetic */ boolean $anonfun$existentialAbstraction$2(ObjectRef tparams1$1, Symbols.Symbol p) {
        boolean bl;
        block3: {
            List list = (List)tparams1$1.elem;
            if (list == null) {
                throw null;
            }
            LinearSeqOptimized exists_these = list;
            while (!exists_these.isEmpty()) {
                Symbols.Symbol symbol = (Symbols.Symbol)exists_these.head();
                if (Types.$anonfun$existentialAbstraction$3(p, symbol)) {
                    bl = true;
                    break block3;
                }
                exists_these = (LinearSeqOptimized)exists_these.tail();
            }
            bl = false;
        }
        return bl;
    }

    public static /* synthetic */ Type $anonfun$transparentShallowTransform$2(Function1 f$2, Type x1$1) {
        return (Type)f$2.apply(x1$1);
    }

    private Type loop$2(Type tp, Symbols.Symbol container$2, Function1 f$2) {
        Type type;
        if (tp instanceof AnnotatedType) {
            AnnotatedType annotatedType = (AnnotatedType)tp;
            Type underlying = annotatedType.underlying();
            Type x$1 = this.loop$2(underlying, container$2, f$2);
            List<AnnotationInfos.AnnotationInfo> x$2 = annotatedType.copy$default$1();
            type = annotatedType.copy(x$2, x$1);
        } else if (tp instanceof ExistentialType) {
            ExistentialType existentialType = (ExistentialType)tp;
            Type underlying = existentialType.underlying();
            Type x$3 = this.loop$2(underlying, container$2, f$2);
            List<Symbols.Symbol> x$4 = existentialType.copy$default$1();
            type = existentialType.copy(x$4, x$3);
        } else if (tp instanceof PolyType) {
            PolyType polyType = (PolyType)tp;
            Type resultType = polyType.resultType();
            Type x$5 = this.loop$2(resultType, container$2, f$2);
            List<Symbols.Symbol> x$6 = polyType.copy$default$1();
            type = polyType.copy(x$6, x$5);
        } else if (tp instanceof NullaryMethodType) {
            NullaryMethodType nullaryMethodType = (NullaryMethodType)tp;
            Type resultType = nullaryMethodType.resultType();
            type = nullaryMethodType.copy(this.loop$2(resultType, container$2, f$2));
        } else {
            Type type2 = this.elementTransform(container$2, tp, (Function1<Type, Type> & java.io.Serializable & Serializable)el -> this.appliedType(container, Predef$.MODULE$.wrapRefArray((Object[])new Type[]{(Type)f.apply((Type)el)})));
            if (type2 == null) {
                throw null;
            }
            Type orElse_this = type2;
            type = orElse_this != orElse_this.scala$reflect$internal$Types$Type$$$outer().NoType() ? orElse_this : Types.$anonfun$transparentShallowTransform$2(f$2, tp);
        }
        return type;
    }

    public static /* synthetic */ boolean $anonfun$containsExistential$1(Type x$55) {
        return x$55.typeSymbol().isExistentiallyBound();
    }

    public static /* synthetic */ boolean $anonfun$existentialsInType$1(Type x$56) {
        return x$56.typeSymbol().isExistentiallyBound();
    }

    public static /* synthetic */ Symbols.TypeSymbol $anonfun$typeParamsToExistentials$2(List tparams$3, List eparams$1, Symbols.TypeSymbol x$58) {
        return (Symbols.TypeSymbol)x$58.substInfo(tparams$3, eparams$1);
    }

    private static Type loop$3(Type tp, Symbols.Symbol owner$2, Type pre$1) {
        if (tp.isTrivial()) {
            return tp;
        }
        if (tp.prefix().typeSymbol().isNonBottomSubClass(owner$2)) {
            Type type = tp instanceof ConstantType ? tp : tp.widen();
            Type memType = type.asSeenFrom(pre$1, tp.typeSymbol().owner());
            if (tp == type) {
                return memType;
            }
            return memType.narrow();
        }
        return Types.loop$3(tp.prefix(), owner$2, pre$1).memberType(tp.typeSymbol());
    }

    public static /* synthetic */ String $anonfun$nestedMemberType$1(Type result$2, Symbols.Symbol sym$3) {
        return new StringBuilder(27).append("(").append(result$2).append(").typeSymbol = ").append(result$2.typeSymbol()).append("; expected ").append(sym$3).toString();
    }

    public static /* synthetic */ Tuple2 $anonfun$isPopulated$1(Symbols.Symbol sym1$1, Symbols.Symbol sym2$1) {
        return new Tuple2<Symbols.Symbol, Symbols.Symbol>(sym1$1, sym2$1);
    }

    public static /* synthetic */ boolean $anonfun$isPopulated$2(Type arg1, Type arg2, Symbols.Symbol tparam) {
        if (Variance$.MODULE$.isInvariant$extension(tparam.variance())) {
            return arg1.$eq$colon$eq(arg2);
        }
        return !(arg1 instanceof TypeVar) || (Variance$.MODULE$.isContravariant$extension(tparam.variance()) ? arg1.$less$colon$less(arg2) : arg2.$less$colon$less(arg1));
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean isConsistent$1(Type tp1, Type tp2) {
        Type et;
        Type et2;
        Type type = tp2.dealias();
        Type type2 = tp1.dealias();
        Tuple2<Type, Type> tuple2 = new Tuple2<Type, Type>(type2, type);
        Type type3 = type2;
        Type type4 = type;
        if (type3 instanceof TypeRef) {
            TypeRef typeRef = (TypeRef)type3;
            Type pre1 = typeRef.pre();
            Symbols.Symbol sym1 = typeRef.sym();
            List args1 = typeRef.args();
            if (type4 instanceof TypeRef) {
                void assert_assertion;
                TypeRef typeRef2 = (TypeRef)type4;
                Type pre2 = typeRef2.pre();
                Symbols.Symbol sym2 = typeRef2.sym();
                List args2 = typeRef2.args();
                Symbols.Symbol symbol = sym1;
                boolean bl = !(symbol != null ? !symbol.equals(sym2) : sym2 != null);
                SymbolTable assert_this = (SymbolTable)this;
                if (assert_assertion == false) {
                    throw assert_this.throwAssertionError(Types.$anonfun$isPopulated$1(sym1, sym2));
                }
                if (!pre1.$eq$colon$eq(pre2)) return false;
                List forall3_xs3 = sym1.typeParams();
                List forall3_ys1 = args1;
                List forall3_ys2 = args2;
                List forall3_ys3 = forall3_xs3;
                while (!forall3_ys1.isEmpty()) {
                    if (forall3_ys2.isEmpty()) return true;
                    if (forall3_ys3.isEmpty()) return true;
                    Symbols.Symbol symbol2 = forall3_ys3.head();
                    Type type5 = forall3_ys2.head();
                    if (!Types.$anonfun$isPopulated$2(forall3_ys1.head(), type5, symbol2)) {
                        return false;
                    }
                    forall3_ys1 = (List)forall3_ys1.tail();
                    forall3_ys2 = (List)forall3_ys2.tail();
                    forall3_ys3 = (List)forall3_ys3.tail();
                }
                return true;
            }
        }
        if ((et2 = type2) instanceof ExistentialType) {
            return ((ExistentialType)et2).withTypeVars((Function1<Type, Object> & java.io.Serializable & Serializable)x$61 -> BoxesRunTime.boxToBoolean(this.isConsistent$1(x$61, tp2)));
        }
        if (tuple2 != null && (et = type) instanceof ExistentialType) {
            return ((ExistentialType)et).withTypeVars((Function1<Type, Object> & java.io.Serializable & Serializable)x$62 -> BoxesRunTime.boxToBoolean(this.isConsistent$1(tp1, x$62)));
        }
        if (tuple2 == null) throw new MatchError((Object)null);
        throw new MatchError(new Tuple2<Type, Type>(tp1, tp2));
    }

    public static /* synthetic */ boolean $anonfun$isPopulated$5(Types $this, Type tp2$2, Type tp1$2, Symbols.Symbol bc) {
        return tp2$2.baseTypeIndex(bc) < 0 || $this.isConsistent$1(tp1$2.baseType(bc), tp2$2.baseType(bc));
    }

    private boolean check$1(Type tp1, Type tp2) {
        boolean bl;
        block4: {
            if (tp1.typeSymbol().isClass() && tp1.typeSymbol().hasFlag(32)) {
                return tp1.$less$colon$less(tp2) || ((Definitions)((Object)this)).definitions().isNumericValueClass(tp1.typeSymbol()) && ((Definitions)((Object)this)).definitions().isNumericValueClass(tp2.typeSymbol());
            }
            List<Symbols.Symbol> list = tp1.baseClasses();
            if (list == null) {
                throw null;
            }
            LinearSeqOptimized forall_these = list;
            while (!forall_these.isEmpty()) {
                Symbols.Symbol symbol = (Symbols.Symbol)forall_these.head();
                if (!Types.$anonfun$isPopulated$5(this, tp2, tp1, symbol)) {
                    bl = false;
                    break block4;
                }
                forall_these = (LinearSeqOptimized)forall_these.tail();
            }
            bl = true;
        }
        return bl;
    }

    private boolean isSubArg$1(Type t1, Type t2, Symbols.Symbol tparam, int depth$1) {
        return !(!tparam.isCovariant() && !this.isSubType(t2, t1, depth$1) || !tparam.isContravariant() && !this.isSubType(t1, t2, depth$1));
    }

    private boolean directlySpecializedBy$1(Symbols.Symbol member, Symbols.Symbol sym$4, Type tp$6, int depth$2) {
        Symbols.Symbol symbol = member;
        return !(symbol == null ? sym$4 != null : !symbol.equals(sym$4)) || this.specializesSym(tp$6.narrow(), member, sym$4.owner().thisType(), sym$4, depth$2);
    }

    private boolean specializedBy$1(Symbols.Symbol member, Symbols.Symbol sym$4, Type tp$6, int depth$2) {
        if (member == ((Symbols)((Object)this)).NoSymbol()) {
            return false;
        }
        if (member.isOverloaded()) {
            boolean bl;
            block5: {
                List<Symbols.Symbol> list = member.alternatives();
                if (list == null) {
                    throw null;
                }
                LinearSeqOptimized exists_these = list;
                while (!exists_these.isEmpty()) {
                    Symbols.Symbol symbol = (Symbols.Symbol)exists_these.head();
                    if (this.directlySpecializedBy$1(symbol, sym$4, tp$6, depth$2)) {
                        bl = true;
                        break block5;
                    }
                    exists_these = (LinearSeqOptimized)exists_these.tail();
                }
                bl = false;
            }
            return bl;
        }
        return this.directlySpecializedBy$1(member, sym$4, tp$6, depth$2);
    }

    public static /* synthetic */ Tuple5 $anonfun$specializesSym$2(Type preLo$1, Symbols.Symbol symLo$1, Type preHi$1, Symbols.Symbol symHi$1, int depth$3) {
        return new Tuple5<Type, Symbols.Symbol, Type, Symbols.Symbol, Depth>(preLo$1, symLo$1, preHi$1, symHi$1, new Depth(depth$3));
    }

    private boolean matchesQuantified$1(List tparams1, List tparams2, Type res1, Type res2, boolean alwaysMatchSimple$1) {
        return this.sameLength(tparams1, tparams2) && this.matchesType(res1, res2.substSym(tparams2, tparams1), alwaysMatchSimple$1);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean lastTry$1(Type tp2$3, boolean alwaysMatchSimple$1, Type tp1$3) {
        if (tp2$3 instanceof ExistentialType) {
            Type res2 = ((ExistentialType)tp2$3).underlying();
            if (alwaysMatchSimple$1) {
                return this.matchesType(tp1$3, res2, true);
            }
        }
        if (tp2$3 instanceof MethodType) {
            return false;
        }
        if (tp2$3 instanceof PolyType) {
            return false;
        }
        if (alwaysMatchSimple$1) return true;
        if (!tp1$3.$eq$colon$eq(tp2$3)) return false;
        return true;
    }

    public static /* synthetic */ boolean $anonfun$matchesType$1(Symbols.Symbol x$67, Symbols.Symbol x$68) {
        return x$67 == x$68;
    }

    private static TypeBounds instantiatedBound$1(Symbols.Symbol tparam, Type pre$2, Symbols.Symbol owner$3, List tparams$4, List targs$1) {
        return tparam.info().asSeenFrom(pre$2, owner$3).instantiateTypeParams(tparams$4, targs$1).bounds();
    }

    public static /* synthetic */ boolean $anonfun$isWithinBounds$1(Type x$69) {
        return !x$69.annotations().isEmpty();
    }

    public static /* synthetic */ boolean $anonfun$isWithinBounds$4(Type pre$2, Symbols.Symbol owner$3, List tparams$4, List targs$1, Symbols.Symbol tparam, Type targ) {
        return Types.instantiatedBound$1(tparam, pre$2, owner$3, tparams$4, targs$1).containsType(targ);
    }

    public static /* synthetic */ void $anonfun$typeVarsInType$1(ObjectRef tvs$1, Type x0$1) {
        if (x0$1 instanceof TypeVar) {
            TypeVar typeVar = (TypeVar)x0$1;
            tvs$1.elem = ((List)tvs$1.elem).$colon$colon(typeVar);
            return;
        }
    }

    public static /* synthetic */ boolean $anonfun$stripExistentialsAndTypeVars$1(Type x0$1) {
        boolean bl = x0$1 instanceof RefinedType ? true : (x0$1 instanceof TypeVar ? true : x0$1 instanceof ExistentialType);
        boolean bl2 = bl;
        return bl2;
    }

    private void stripType$1(Type tp, boolean expandLazyBaseType$1, List ts$1, ListBuffer stripped$1, ListBuffer tparams$5) {
        block7: {
            block8: {
                TypeVar typeVar;
                while (true) {
                    Types this_;
                    RefinedType refinedType;
                    if (tp instanceof RefinedType && this_.isIntersectionTypeForLazyBaseType(refinedType = (RefinedType)tp)) {
                        if (expandLazyBaseType$1) {
                            List list = refinedType.parents();
                            if (list == null) {
                                throw null;
                            }
                            List foreach_these = list;
                            while (!foreach_these.isEmpty()) {
                                Type type = foreach_these.head();
                                this_.stripType$1(type, expandLazyBaseType$1, ts$1, stripped$1, tparams$5);
                                foreach_these = (List)foreach_these.tail();
                            }
                            break block7;
                        }
                        ((SymbolTable)this_).devWarning((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(70).append("Unexpected RefinedType in stripExistentialsAndTypeVars ").append(ts$1).append(", not expanding").toString());
                        stripped$1.$plus$eq(tp);
                        return;
                    }
                    if (tp instanceof ExistentialType) {
                        ExistentialType existentialType = (ExistentialType)tp;
                        List<Symbols.Symbol> qs = existentialType.quantified();
                        Type underlying = existentialType.underlying();
                        tparams$5.$plus$plus$eq((TraversableOnce)qs);
                        tp = underlying;
                        this_ = (SymbolTable)this_;
                        continue;
                    }
                    if (!(tp instanceof TypeVar)) break block8;
                    typeVar = (TypeVar)tp;
                    TypeConstraints.TypeConstraint constr = typeVar.constr();
                    if (!typeVar.instValid()) break;
                    tp = constr.inst();
                    this_ = (SymbolTable)this_;
                }
                if (typeVar.untouchable()) {
                    stripped$1.$plus$eq(typeVar);
                    return;
                }
                throw ((Reporting)((Object)this_)).abort(new StringBuilder(32).append("trying to do lub/glb of typevar ").append(typeVar).toString());
            }
            stripped$1.$plus$eq(tp);
        }
    }

    public static /* synthetic */ boolean $anonfun$mergePrefixAndArgs$4(Type argH$1, List x$78) {
        return ((Type)x$78.head()).$eq$colon$eq(argH$1);
    }

    public static /* synthetic */ boolean $anonfun$mergePrefixAndArgs$5(Types $this, List args2) {
        return ((Definitions)((Object)$this)).definitions().isPrimitiveValueClass(((Type)args2.head()).typeSymbol());
    }

    public static /* synthetic */ String $anonfun$mergePrefixAndArgs$7(List tps$1, List argss$1) {
        return new StringBuilder(41).append("transposed irregular matrix!? tps=").append(tps$1).append(" argss=").append(argss$1).toString();
    }

    public static /* synthetic */ Type $anonfun$mergePrefixAndArgs$8(Types $this, int depth$4, int variance$1, IntRef capturedParamIds$1, ListBuffer capturedParams$1, Symbols.Symbol tparam, List as0) {
        Type g;
        List as = (List)as0.distinct();
        if (as.size() == 1) {
            return (Type)as.head();
        }
        if (Depth$.MODULE$.isZero$extension(depth$4)) {
            ((SymbolTable)$this).log((Function0<Object>)(Function0<String> & java.io.Serializable & Serializable)() -> {
                String string = "Giving up merging args: can't unify %s under %s";
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                return new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{as.mkString(", "), tparam.fullLocationString()}));
            });
            return $this.NoType();
        }
        if (tparam.variance() == variance$1) {
            return $this.lub(as, Depth$.MODULE$.decr$extension1(depth$4));
        }
        if (tparam.variance() == Variance$.MODULE$.flip$extension(variance$1)) {
            return $this.glb(as, Depth$.MODULE$.decr$extension1(depth$4));
        }
        Type l = $this.lub(as, Depth$.MODULE$.decr$extension1(depth$4));
        if (l.$less$colon$less(g = $this.glb(as, Depth$.MODULE$.decr$extension1(depth$4)))) {
            return l;
        }
        ++capturedParamIds$1.elem;
        int capturedParamId = capturedParamIds$1.elem;
        Symbols.TypeSymbol qvar = (Symbols.TypeSymbol)$this.commonOwner(as).freshExistential("", capturedParamId).setInfo($this.TypeBounds().apply(g, l));
        capturedParams$1.$plus$eq(qvar);
        return qvar.tpe();
    }

    public static /* synthetic */ void $anonfun$addMember$1(Types $this, Type thistp$1, Symbols.Symbol sym$5, int depth$5, Type tp$7, Symbols.Symbol alt) {
        if ($this.specializesSym(thistp$1, sym$5, thistp$1, alt, depth$5)) {
            tp$7.decls().unlink(alt);
        }
    }

    public static /* synthetic */ boolean $anonfun$isJavaVarargsAncestor$1(Types $this, Symbols.Symbol m) {
        return ((Definitions)((Object)$this)).definitions().isJavaVarArgsMethod(m);
    }

    public static /* synthetic */ boolean $anonfun$nonTrivialMembers$1(Types $this, Symbols.Symbol sym) {
        return ((Definitions)((Object)$this)).definitions().isUniversalMember(sym);
    }

    public static /* synthetic */ boolean $anonfun$importableMembers$1(Types $this, Symbols.Symbol sym) {
        return ((Definitions)((Object)$this)).definitions().isImportable(sym);
    }

    public static /* synthetic */ boolean $anonfun$invalidateTreeTpeCaches$1(Trees.Tree t) {
        return t.tpe() != null;
    }

    public static /* synthetic */ void $anonfun$invalidateTreeTpeCaches$2(Types $this, List updatedSyms$1, Trees.Tree t) {
        t.tpe().foreach((Function1<Type, BoxedUnit>)(Function1<Type, Object> & java.io.Serializable & Serializable)tp -> {
            $this.invalidateCaches(tp, updatedSyms$1);
            return BoxedUnit.UNIT;
        });
    }

    public static /* synthetic */ boolean $anonfun$typeContainsTypeVar$1(Type x$81) {
        return x$81 instanceof TypeVar;
    }

    public static /* synthetic */ boolean $anonfun$typeContainsTypeVar$2(TypeMaps.FindTypeCollector collector$1, Type tp) {
        return ((Option)collector$1.collect(tp)).isDefined();
    }

    public static void $init$(Types $this) {
        $this.scala$reflect$internal$Types$$explainSwitch_$eq(false);
        $this.scala$reflect$internal$Types$_setter_$scala$reflect$internal$Types$$emptySymbolSet_$eq((Set<Symbols.Symbol>)Set$.MODULE$.empty());
        $this.scala$reflect$internal$Types$_setter_$scala$reflect$internal$Types$$propagateParameterBoundsToTypeVars_$eq(package$.MODULE$.props().contains("scalac.debug.prop-constraints"));
        $this.scala$reflect$internal$Types$_setter_$scala$reflect$internal$Types$$sharperSkolems_$eq(package$.MODULE$.props().contains("scalac.experimental.sharper-skolems"));
        $this.scala$reflect$internal$Types$$_skolemizationLevel_$eq(0);
        $this.scala$reflect$internal$Types$_setter_$scala$reflect$internal$Types$$_intersectionWitness_$eq(((SymbolTable)$this).perRunCaches().newWeakMap());
        $this.scala$reflect$internal$Types$_setter_$scala$reflect$internal$Types$$initialUniquesCapacity_$eq(4096);
        $this.scala$reflect$internal$Types$$uniqueRunId_$eq(0);
        $this.scala$reflect$internal$Types$_setter_$missingAliasException_$eq(new MissingAliasControl((SymbolTable)$this));
        $this.scala$reflect$internal$Types$$_basetypeRecursions_$eq(0);
        $this.scala$reflect$internal$Types$_setter_$scala$reflect$internal$Types$$_pendingBaseTypes_$eq(new HashSet<Type>());
        $this.scala$reflect$internal$Types$$_indent_$eq("");
        $this.scala$reflect$internal$Types$_setter_$shorthands_$eq((Set)Predef$.MODULE$.Set().apply(Predef$.MODULE$.wrapRefArray((Object[])new String[]{"scala.collection.immutable.List", "scala.collection.immutable.Nil", "scala.collection.Seq", "scala.collection.Traversable", "scala.collection.Iterable", "scala.collection.mutable.StringBuilder", "scala.collection.IndexedSeq", "scala.collection.Iterator"})));
        $this.scala$reflect$internal$Types$_setter_$treeTpe_$eq((Function1<Trees.Tree, Type> & java.io.Serializable & Serializable)t -> t.tpe());
        $this.scala$reflect$internal$Types$_setter_$typeContainsTypeVar_$eq(arg_0 -> Types.$anonfun$typeContainsTypeVar$2$adapted(new TypeMaps.FindTypeCollector((SymbolTable)$this, (Function1<Type, Object> & java.io.Serializable & Serializable)x$81 -> BoxesRunTime.boxToBoolean(Types.$anonfun$typeContainsTypeVar$1(x$81))), arg_0));
        $this.scala$reflect$internal$Types$_setter_$typeIsSubTypeOfSerializable_$eq((Function1<Type, Object> & java.io.Serializable & Serializable)tp -> BoxesRunTime.boxToBoolean(tp.$less$colon$less(((Definitions)((Object)$this)).definitions().SerializableTpe())));
        $this.scala$reflect$internal$Types$_setter_$AnnotatedTypeTag_$eq(ClassTag$.MODULE$.apply(AnnotatedType.class));
        $this.scala$reflect$internal$Types$_setter_$BoundedWildcardTypeTag_$eq(ClassTag$.MODULE$.apply(BoundedWildcardType.class));
        $this.scala$reflect$internal$Types$_setter_$ClassInfoTypeTag_$eq(ClassTag$.MODULE$.apply(ClassInfoType.class));
        $this.scala$reflect$internal$Types$_setter_$CompoundTypeTag_$eq(ClassTag$.MODULE$.apply(CompoundType.class));
        $this.scala$reflect$internal$Types$_setter_$ConstantTypeTag_$eq(ClassTag$.MODULE$.apply(ConstantType.class));
        $this.scala$reflect$internal$Types$_setter_$ExistentialTypeTag_$eq(ClassTag$.MODULE$.apply(ExistentialType.class));
        $this.scala$reflect$internal$Types$_setter_$MethodTypeTag_$eq(ClassTag$.MODULE$.apply(MethodType.class));
        $this.scala$reflect$internal$Types$_setter_$NullaryMethodTypeTag_$eq(ClassTag$.MODULE$.apply(NullaryMethodType.class));
        $this.scala$reflect$internal$Types$_setter_$PolyTypeTag_$eq(ClassTag$.MODULE$.apply(PolyType.class));
        $this.scala$reflect$internal$Types$_setter_$RefinedTypeTag_$eq(ClassTag$.MODULE$.apply(RefinedType.class));
        $this.scala$reflect$internal$Types$_setter_$SingletonTypeTag_$eq(ClassTag$.MODULE$.apply(SingletonType.class));
        $this.scala$reflect$internal$Types$_setter_$SingleTypeTag_$eq(ClassTag$.MODULE$.apply(SingleType.class));
        $this.scala$reflect$internal$Types$_setter_$SuperTypeTag_$eq(ClassTag$.MODULE$.apply(SuperType.class));
        $this.scala$reflect$internal$Types$_setter_$ThisTypeTag_$eq(ClassTag$.MODULE$.apply(ThisType.class));
        $this.scala$reflect$internal$Types$_setter_$TypeBoundsTag_$eq(ClassTag$.MODULE$.apply(TypeBounds.class));
        $this.scala$reflect$internal$Types$_setter_$TypeRefTag_$eq(ClassTag$.MODULE$.apply(TypeRef.class));
        $this.scala$reflect$internal$Types$_setter_$TypeTagg_$eq(ClassTag$.MODULE$.apply(Type.class));
    }

    public static /* synthetic */ Object $anonfun$isDummyAppliedType$1$adapted(Types $this, TypeRef x2$1, Type targ) {
        return BoxesRunTime.boxToBoolean($this.isDummyOf(x2$1, targ));
    }

    public static /* synthetic */ Object $anonfun$isSameTypes$1$adapted(Type x$63, Type x$64) {
        return BoxesRunTime.boxToBoolean(x$63.$eq$colon$eq(x$64));
    }

    public static /* synthetic */ Object $anonfun$matchesType$1$adapted(Symbols.Symbol x$67, Symbols.Symbol x$68) {
        return BoxesRunTime.boxToBoolean(Types.$anonfun$matchesType$1(x$67, x$68));
    }

    public static /* synthetic */ Object $anonfun$isWithinBounds$1$adapted(Type x$69) {
        return BoxesRunTime.boxToBoolean(Types.$anonfun$isWithinBounds$1(x$69));
    }

    public static /* synthetic */ Object $anonfun$isWithinBounds$3$adapted(TypeBounds x$70, Type x$71) {
        return BoxesRunTime.boxToBoolean(x$70.containsType(x$71));
    }

    public static /* synthetic */ Object $anonfun$isWithinBounds$4$adapted(Type pre$2, Symbols.Symbol owner$3, List tparams$4, List targs$1, Symbols.Symbol tparam, Type targ) {
        return BoxesRunTime.boxToBoolean(Types.$anonfun$isWithinBounds$4(pre$2, owner$3, tparams$4, targs$1, tparam, targ));
    }

    public static /* synthetic */ Object $anonfun$suspendingTypeVars$1$adapted(TypeVar x$72) {
        return BoxesRunTime.boxToBoolean(x$72.scala$reflect$internal$Types$$suspended());
    }

    public static /* synthetic */ Object $anonfun$suspendingTypeVars$2$adapted(TypeVar x$73) {
        x$73.scala$reflect$internal$Types$$suspended_$eq(true);
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$stripExistentialsAndTypeVars$1$adapted(Type x0$1) {
        return BoxesRunTime.boxToBoolean(Types.$anonfun$stripExistentialsAndTypeVars$1(x0$1));
    }

    public static /* synthetic */ Object $anonfun$stripExistentialsAndTypeVars$4$adapted(Types $this, boolean expandLazyBaseType$1, List ts$1, ListBuffer stripped$1, ListBuffer tparams$5, Type tp) {
        $this.stripType$1(tp, expandLazyBaseType$1, ts$1, stripped$1, tparams$5);
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$mergePrefixAndArgs$3$adapted(List x$77) {
        return BoxesRunTime.boxToBoolean(x$77.isEmpty());
    }

    public static /* synthetic */ Object $anonfun$mergePrefixAndArgs$5$adapted(Types $this, List args2) {
        return BoxesRunTime.boxToBoolean(Types.$anonfun$mergePrefixAndArgs$5($this, args2));
    }

    public static /* synthetic */ Object $anonfun$addMember$1$adapted(Types $this, Type thistp$1, Symbols.Symbol sym$5, int depth$5, Type tp$7, Symbols.Symbol alt) {
        Types.$anonfun$addMember$1($this, thistp$1, sym$5, depth$5, tp$7, alt);
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$isJavaVarargsAncestor$1$adapted(Types $this, Symbols.Symbol m) {
        return BoxesRunTime.boxToBoolean(Types.$anonfun$isJavaVarargsAncestor$1($this, m));
    }

    public static /* synthetic */ Object $anonfun$inheritsJavaVarArgsMethod$1$adapted(Types $this, Symbols.Symbol clazz) {
        return BoxesRunTime.boxToBoolean($this.isJavaVarargsAncestor(clazz));
    }

    public static /* synthetic */ Object $anonfun$invalidateTreeTpeCaches$2$adapted(Types $this, List updatedSyms$1, Trees.Tree t) {
        Types.$anonfun$invalidateTreeTpeCaches$2($this, updatedSyms$1, t);
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$invalidateCaches$1$adapted(List updatedSyms$2, Object elem) {
        return BoxesRunTime.boxToBoolean(updatedSyms$2.contains(elem));
    }

    public static /* synthetic */ Object $anonfun$existentialAbstraction$3$adapted(Symbols.Symbol p$1, Symbols.Symbol p1) {
        return BoxesRunTime.boxToBoolean(Types.$anonfun$existentialAbstraction$3(p$1, p1));
    }

    public static /* synthetic */ Object $anonfun$isPopulated$2$adapted(Type arg1, Type arg2, Symbols.Symbol tparam) {
        return BoxesRunTime.boxToBoolean(Types.$anonfun$isPopulated$2(arg1, arg2, tparam));
    }

    public static /* synthetic */ Object $anonfun$isPopulated$5$adapted(Types $this, Type tp2$2, Type tp1$2, Symbols.Symbol bc) {
        return BoxesRunTime.boxToBoolean(Types.$anonfun$isPopulated$5($this, tp2$2, tp1$2, bc));
    }

    public static /* synthetic */ Object $anonfun$specializesSym$1$adapted(Types $this, Symbols.Symbol sym$4, Type tp$6, int depth$2, Symbols.Symbol member) {
        return BoxesRunTime.boxToBoolean($this.directlySpecializedBy$1(member, sym$4, tp$6, depth$2));
    }

    public static /* synthetic */ Object $anonfun$stripExistentialsAndTypeVars$2$adapted(Types $this, boolean expandLazyBaseType$1, List ts$1, ListBuffer stripped$1, ListBuffer tparams$5, Type tp) {
        $this.stripType$1(tp, expandLazyBaseType$1, ts$1, stripped$1, tparams$5);
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$typeContainsTypeVar$2$adapted(TypeMaps.FindTypeCollector collector$1, Type tp) {
        return BoxesRunTime.boxToBoolean(Types.$anonfun$typeContainsTypeVar$2(collector$1, tp));
    }

    private final class AbstractArgsTypeRef
    extends ArgsTypeRef
    implements AbstractTypeRef {
        private Type scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache;
        private int scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod;
        private Type scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo;

        @Override
        public List<Symbols.Symbol> baseClasses() {
            return ((AbstractTypeRef)this).baseClasses();
        }

        @Override
        public Scopes.Scope decls() {
            return ((AbstractTypeRef)this).decls();
        }

        @Override
        public TypeBounds bounds() {
            return ((AbstractTypeRef)this).bounds();
        }

        @Override
        public Type upperBound() {
            return ((AbstractTypeRef)this).upperBound();
        }

        @Override
        public Type lowerBound() {
            return ((AbstractTypeRef)this).lowerBound();
        }

        @Override
        public BaseTypeSeqs.BaseTypeSeq baseTypeSeqImpl() {
            return ((AbstractTypeRef)this).baseTypeSeqImpl();
        }

        @Override
        public List<Type> parentsImpl() {
            return ((AbstractTypeRef)this).parentsImpl();
        }

        @Override
        public String kind() {
            return ((AbstractTypeRef)this).kind();
        }

        @Override
        public /* synthetic */ void scala$reflect$internal$Types$NonClassTypeRef$$super$invalidateTypeRefCaches() {
            super.scala$reflect$internal$Types$$invalidateTypeRefCaches();
        }

        @Override
        public /* synthetic */ Type scala$reflect$internal$Types$NonClassTypeRef$$super$relativeInfo() {
            return super.relativeInfo();
        }

        @Override
        public final Type relativeInfo() {
            return ((NonClassTypeRef)this).relativeInfo();
        }

        @Override
        public void scala$reflect$internal$Types$$invalidateTypeRefCaches() {
            ((NonClassTypeRef)this).scala$reflect$internal$Types$$invalidateTypeRefCaches();
        }

        @Override
        public Type scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache() {
            return this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache;
        }

        @Override
        public void scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache_$eq(Type x$1) {
            this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache = x$1;
        }

        @Override
        public int scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod() {
            return this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod;
        }

        @Override
        public void scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod_$eq(int x$1) {
            this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod = x$1;
        }

        @Override
        public Type scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo() {
            return this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo;
        }

        @Override
        public void scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo_$eq(Type x$1) {
            this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo = x$1;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$AbstractArgsTypeRef$$$outer() {
            return (SymbolTable)this.$outer;
        }

        @Override
        public /* synthetic */ Types scala$reflect$internal$Types$AbstractTypeRef$$$outer() {
            return this.scala$reflect$internal$Types$AbstractArgsTypeRef$$$outer();
        }

        @Override
        public /* synthetic */ Types scala$reflect$internal$Types$NonClassTypeRef$$$outer() {
            return this.scala$reflect$internal$Types$AbstractArgsTypeRef$$$outer();
        }

        public AbstractArgsTypeRef(SymbolTable $outer, Type pre, Symbols.Symbol sym, List<Type> args2) {
            super($outer, pre, sym, args2);
            NonClassTypeRef.$init$(this);
            AbstractTypeRef.$init$(this);
        }
    }

    private final class AbstractNoArgsTypeRef
    extends NoArgsTypeRef
    implements AbstractTypeRef {
        private Type scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache;
        private int scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod;
        private Type scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo;

        @Override
        public List<Symbols.Symbol> baseClasses() {
            return ((AbstractTypeRef)this).baseClasses();
        }

        @Override
        public Scopes.Scope decls() {
            return ((AbstractTypeRef)this).decls();
        }

        @Override
        public TypeBounds bounds() {
            return ((AbstractTypeRef)this).bounds();
        }

        @Override
        public Type upperBound() {
            return ((AbstractTypeRef)this).upperBound();
        }

        @Override
        public Type lowerBound() {
            return ((AbstractTypeRef)this).lowerBound();
        }

        @Override
        public BaseTypeSeqs.BaseTypeSeq baseTypeSeqImpl() {
            return ((AbstractTypeRef)this).baseTypeSeqImpl();
        }

        @Override
        public List<Type> parentsImpl() {
            return ((AbstractTypeRef)this).parentsImpl();
        }

        @Override
        public String kind() {
            return ((AbstractTypeRef)this).kind();
        }

        @Override
        public /* synthetic */ void scala$reflect$internal$Types$NonClassTypeRef$$super$invalidateTypeRefCaches() {
            super.scala$reflect$internal$Types$$invalidateTypeRefCaches();
        }

        @Override
        public /* synthetic */ Type scala$reflect$internal$Types$NonClassTypeRef$$super$relativeInfo() {
            return super.relativeInfo();
        }

        @Override
        public final Type relativeInfo() {
            return ((NonClassTypeRef)this).relativeInfo();
        }

        @Override
        public void scala$reflect$internal$Types$$invalidateTypeRefCaches() {
            ((NonClassTypeRef)this).scala$reflect$internal$Types$$invalidateTypeRefCaches();
        }

        @Override
        public Type scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache() {
            return this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache;
        }

        @Override
        public void scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache_$eq(Type x$1) {
            this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache = x$1;
        }

        @Override
        public int scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod() {
            return this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod;
        }

        @Override
        public void scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod_$eq(int x$1) {
            this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod = x$1;
        }

        @Override
        public Type scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo() {
            return this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo;
        }

        @Override
        public void scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo_$eq(Type x$1) {
            this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo = x$1;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$AbstractNoArgsTypeRef$$$outer() {
            return (SymbolTable)this.$outer;
        }

        @Override
        public /* synthetic */ Types scala$reflect$internal$Types$AbstractTypeRef$$$outer() {
            return this.scala$reflect$internal$Types$AbstractNoArgsTypeRef$$$outer();
        }

        @Override
        public /* synthetic */ Types scala$reflect$internal$Types$NonClassTypeRef$$$outer() {
            return this.scala$reflect$internal$Types$AbstractNoArgsTypeRef$$$outer();
        }

        public AbstractNoArgsTypeRef(SymbolTable $outer, Type pre, Symbols.Symbol sym) {
            super($outer, pre, sym);
            NonClassTypeRef.$init$(this);
            AbstractTypeRef.$init$(this);
        }
    }

    public interface AbstractTypeRef
    extends NonClassTypeRef {
        default public List<Symbols.Symbol> baseClasses() {
            return this.relativeInfo().baseClasses();
        }

        default public Scopes.Scope decls() {
            return this.relativeInfo().decls();
        }

        default public TypeBounds bounds() {
            return this.relativeInfo().bounds();
        }

        default public Type upperBound() {
            return this.relativeInfo().upperBound();
        }

        default public Type lowerBound() {
            return this.relativeInfo().lowerBound();
        }

        default public BaseTypeSeqs.BaseTypeSeq baseTypeSeqImpl() {
            return this.bounds().hi().baseTypeSeq().prepend((Type)((Object)this));
        }

        default public List<Type> parentsImpl() {
            return this.relativeInfo().parents();
        }

        default public String kind() {
            return "AbstractTypeRef";
        }

        public /* synthetic */ Types scala$reflect$internal$Types$AbstractTypeRef$$$outer();

        public static /* synthetic */ Symbols.Symbol $anonfun$$init$$3(AbstractTypeRef $this) {
            return ((TypeRef)((Object)$this)).sym();
        }

        /*
         * WARNING - void declaration
         */
        public static void $init$(AbstractTypeRef $this) {
            void require_requirement;
            SymbolTable symbolTable = (SymbolTable)$this.scala$reflect$internal$Types$AbstractTypeRef$$$outer();
            boolean bl = ((TypeRef)((Object)$this)).sym().isAbstractType();
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable require_this = symbolTable;
            if (require_requirement == false) {
                throw require_this.throwRequirementError(AbstractTypeRef.$anonfun$$init$$3($this));
            }
        }
    }

    private final class AliasArgsTypeRef
    extends ArgsTypeRef
    implements AliasTypeRef {
        private Type scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache;
        private int scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod;
        private Type scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo;

        @Override
        public /* synthetic */ Type scala$reflect$internal$Types$AliasTypeRef$$super$dealias() {
            return super.dealias();
        }

        @Override
        public /* synthetic */ Symbols.Symbol scala$reflect$internal$Types$AliasTypeRef$$super$termSymbol() {
            return super.termSymbol();
        }

        @Override
        public /* synthetic */ Type scala$reflect$internal$Types$AliasTypeRef$$super$normalizeImpl() {
            return super.normalizeImpl();
        }

        @Override
        public Type dealias() {
            return ((AliasTypeRef)this).dealias();
        }

        @Override
        public Type narrow() {
            return ((AliasTypeRef)this).narrow();
        }

        @Override
        public Type prefix() {
            return ((AliasTypeRef)this).prefix();
        }

        @Override
        public Symbols.Symbol termSymbol() {
            return ((AliasTypeRef)this).termSymbol();
        }

        @Override
        public Symbols.Symbol typeSymbol() {
            return ((AliasTypeRef)this).typeSymbol();
        }

        @Override
        public List<Type> parentsImpl() {
            return ((AliasTypeRef)this).parentsImpl();
        }

        @Override
        public List<Symbols.Symbol> baseClasses() {
            return ((AliasTypeRef)this).baseClasses();
        }

        @Override
        public Scopes.Scope decls() {
            return ((AliasTypeRef)this).decls();
        }

        @Override
        public Type normalizeImpl() {
            return ((AliasTypeRef)this).normalizeImpl();
        }

        @Override
        public Type betaReduce() {
            return ((AliasTypeRef)this).betaReduce();
        }

        @Override
        public Symbols.Symbol coevolveSym(Type newPre) {
            return ((AliasTypeRef)this).coevolveSym(newPre);
        }

        @Override
        public String kind() {
            return ((AliasTypeRef)this).kind();
        }

        @Override
        public /* synthetic */ void scala$reflect$internal$Types$NonClassTypeRef$$super$invalidateTypeRefCaches() {
            super.scala$reflect$internal$Types$$invalidateTypeRefCaches();
        }

        @Override
        public /* synthetic */ Type scala$reflect$internal$Types$NonClassTypeRef$$super$relativeInfo() {
            return super.relativeInfo();
        }

        @Override
        public final Type relativeInfo() {
            return ((NonClassTypeRef)this).relativeInfo();
        }

        @Override
        public void scala$reflect$internal$Types$$invalidateTypeRefCaches() {
            ((NonClassTypeRef)this).scala$reflect$internal$Types$$invalidateTypeRefCaches();
        }

        @Override
        public Type scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache() {
            return this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache;
        }

        @Override
        public void scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache_$eq(Type x$1) {
            this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache = x$1;
        }

        @Override
        public int scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod() {
            return this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod;
        }

        @Override
        public void scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod_$eq(int x$1) {
            this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod = x$1;
        }

        @Override
        public Type scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo() {
            return this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo;
        }

        @Override
        public void scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo_$eq(Type x$1) {
            this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo = x$1;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$AliasArgsTypeRef$$$outer() {
            return (SymbolTable)this.$outer;
        }

        @Override
        public /* synthetic */ Types scala$reflect$internal$Types$AliasTypeRef$$$outer() {
            return this.scala$reflect$internal$Types$AliasArgsTypeRef$$$outer();
        }

        @Override
        public /* synthetic */ Types scala$reflect$internal$Types$NonClassTypeRef$$$outer() {
            return this.scala$reflect$internal$Types$AliasArgsTypeRef$$$outer();
        }

        public AliasArgsTypeRef(SymbolTable $outer, Type pre, Symbols.Symbol sym, List<Type> args2) {
            super($outer, pre, sym, args2);
            NonClassTypeRef.$init$(this);
            AliasTypeRef.$init$(this);
        }
    }

    private final class AliasNoArgsTypeRef
    extends NoArgsTypeRef
    implements AliasTypeRef {
        private Type scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache;
        private int scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod;
        private Type scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo;

        @Override
        public /* synthetic */ Type scala$reflect$internal$Types$AliasTypeRef$$super$dealias() {
            return super.dealias();
        }

        @Override
        public /* synthetic */ Symbols.Symbol scala$reflect$internal$Types$AliasTypeRef$$super$termSymbol() {
            return super.termSymbol();
        }

        @Override
        public /* synthetic */ Type scala$reflect$internal$Types$AliasTypeRef$$super$normalizeImpl() {
            return super.normalizeImpl();
        }

        @Override
        public Type dealias() {
            return ((AliasTypeRef)this).dealias();
        }

        @Override
        public Type narrow() {
            return ((AliasTypeRef)this).narrow();
        }

        @Override
        public Type prefix() {
            return ((AliasTypeRef)this).prefix();
        }

        @Override
        public Symbols.Symbol termSymbol() {
            return ((AliasTypeRef)this).termSymbol();
        }

        @Override
        public Symbols.Symbol typeSymbol() {
            return ((AliasTypeRef)this).typeSymbol();
        }

        @Override
        public List<Type> parentsImpl() {
            return ((AliasTypeRef)this).parentsImpl();
        }

        @Override
        public List<Symbols.Symbol> baseClasses() {
            return ((AliasTypeRef)this).baseClasses();
        }

        @Override
        public Scopes.Scope decls() {
            return ((AliasTypeRef)this).decls();
        }

        @Override
        public Type normalizeImpl() {
            return ((AliasTypeRef)this).normalizeImpl();
        }

        @Override
        public Type betaReduce() {
            return ((AliasTypeRef)this).betaReduce();
        }

        @Override
        public Symbols.Symbol coevolveSym(Type newPre) {
            return ((AliasTypeRef)this).coevolveSym(newPre);
        }

        @Override
        public String kind() {
            return ((AliasTypeRef)this).kind();
        }

        @Override
        public /* synthetic */ void scala$reflect$internal$Types$NonClassTypeRef$$super$invalidateTypeRefCaches() {
            super.scala$reflect$internal$Types$$invalidateTypeRefCaches();
        }

        @Override
        public /* synthetic */ Type scala$reflect$internal$Types$NonClassTypeRef$$super$relativeInfo() {
            return super.relativeInfo();
        }

        @Override
        public final Type relativeInfo() {
            return ((NonClassTypeRef)this).relativeInfo();
        }

        @Override
        public void scala$reflect$internal$Types$$invalidateTypeRefCaches() {
            ((NonClassTypeRef)this).scala$reflect$internal$Types$$invalidateTypeRefCaches();
        }

        @Override
        public Type scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache() {
            return this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache;
        }

        @Override
        public void scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache_$eq(Type x$1) {
            this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache = x$1;
        }

        @Override
        public int scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod() {
            return this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod;
        }

        @Override
        public void scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod_$eq(int x$1) {
            this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod = x$1;
        }

        @Override
        public Type scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo() {
            return this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo;
        }

        @Override
        public void scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo_$eq(Type x$1) {
            this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo = x$1;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$AliasNoArgsTypeRef$$$outer() {
            return (SymbolTable)this.$outer;
        }

        @Override
        public /* synthetic */ Types scala$reflect$internal$Types$AliasTypeRef$$$outer() {
            return this.scala$reflect$internal$Types$AliasNoArgsTypeRef$$$outer();
        }

        @Override
        public /* synthetic */ Types scala$reflect$internal$Types$NonClassTypeRef$$$outer() {
            return this.scala$reflect$internal$Types$AliasNoArgsTypeRef$$$outer();
        }

        public AliasNoArgsTypeRef(SymbolTable $outer, Type pre, Symbols.Symbol sym) {
            super($outer, pre, sym);
            NonClassTypeRef.$init$(this);
            AliasTypeRef.$init$(this);
        }
    }

    public interface AliasTypeRef
    extends NonClassTypeRef {
        public /* synthetic */ Type scala$reflect$internal$Types$AliasTypeRef$$super$dealias();

        public /* synthetic */ Symbols.Symbol scala$reflect$internal$Types$AliasTypeRef$$super$termSymbol();

        public /* synthetic */ Type scala$reflect$internal$Types$AliasTypeRef$$super$normalizeImpl();

        default public Type dealias() {
            if (((TypeRef)((Object)this)).typeParamsMatchArgs()) {
                return this.betaReduce().dealias();
            }
            return this.scala$reflect$internal$Types$AliasTypeRef$$super$dealias();
        }

        default public Type narrow() {
            return ((TypeRef)((Object)this)).normalize().narrow();
        }

        default public Type prefix() {
            if (this != ((TypeRef)((Object)this)).normalize()) {
                return ((TypeRef)((Object)this)).normalize().prefix();
            }
            return ((TypeRef)((Object)this)).pre();
        }

        default public Symbols.Symbol termSymbol() {
            if (this != ((TypeRef)((Object)this)).normalize()) {
                return ((TypeRef)((Object)this)).normalize().termSymbol();
            }
            return this.scala$reflect$internal$Types$AliasTypeRef$$super$termSymbol();
        }

        default public Symbols.Symbol typeSymbol() {
            if (this != ((TypeRef)((Object)this)).normalize()) {
                return ((TypeRef)((Object)this)).normalize().typeSymbol();
            }
            return ((TypeRef)((Object)this)).sym();
        }

        default public List<Type> parentsImpl() {
            return ((TypeRef)((Object)this)).normalize().parents().map((Function1<Type, Type> & java.io.Serializable & Serializable)tp -> ((TypeRef)((Object)this)).relativize((Type)tp), List$.MODULE$.canBuildFrom());
        }

        default public List<Symbols.Symbol> baseClasses() {
            return ((TypeRef)((Object)this)).normalize().baseClasses();
        }

        default public Scopes.Scope decls() {
            return ((TypeRef)((Object)this)).normalize().decls();
        }

        default public Type normalizeImpl() {
            Symbols.Symbol overriddenSym;
            if (((TypeRef)((Object)this)).typeParamsMatchArgs()) {
                return this.betaReduce().normalize();
            }
            if (((Type)((Object)this)).isHigherKinded()) {
                return this.scala$reflect$internal$Types$AliasTypeRef$$super$normalizeImpl();
            }
            Symbols.Symbol symbol = overriddenSym = ((TypeRef)((Object)this)).sym().nextOverriddenSymbol();
            Symbols.NoSymbol noSymbol = ((Symbols)((Object)this.scala$reflect$internal$Types$AliasTypeRef$$$outer())).NoSymbol();
            if (symbol == null ? noSymbol != null : !symbol.equals(noSymbol)) {
                return ((TypeRef)((Object)this)).pre().memberType(overriddenSym).normalize();
            }
            return this.scala$reflect$internal$Types$AliasTypeRef$$$outer().ErrorType();
        }

        default public Type betaReduce() {
            return ((TypeRef)((Object)this)).relativize(((TypeRef)((Object)this)).sym().info().resultType());
        }

        default public Symbols.Symbol coevolveSym(Type newPre) {
            if (((TypeRef)((Object)this)).pre() != newPre) {
                Symbols.Symbol symbol = this.scala$reflect$internal$Types$AliasTypeRef$$$outer().scala$reflect$internal$Types$$embeddedSymbol(((TypeRef)((Object)this)).pre(), ((TypeRef)((Object)this)).sym().name());
                Symbols.Symbol symbol2 = ((TypeRef)((Object)this)).sym();
                if (!(symbol != null ? !symbol.equals(symbol2) : symbol2 != null)) {
                    Symbols.Symbol newSym = this.scala$reflect$internal$Types$AliasTypeRef$$$outer().scala$reflect$internal$Types$$embeddedSymbol(newPre, ((TypeRef)((Object)this)).sym().name());
                    ((SymbolTable)this.scala$reflect$internal$Types$AliasTypeRef$$$outer()).debuglog((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(27).append("co-evolve: ").append(((TypeRef)((Object)this)).pre()).append(" -> ").append(newPre).append(", ").append(((TypeRef)((Object)this)).sym()).append(" : ").append(((TypeRef)((Object)this)).sym().info()).append(" -> ").append(newSym).append(" : ").append(newSym.info()).toString());
                    if (newSym == null) {
                        throw null;
                    }
                    if (newSym != newSym.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                        return newSym;
                    }
                    return AliasTypeRef.$anonfun$coevolveSym$2(this);
                }
            }
            return ((TypeRef)((Object)this)).sym();
        }

        default public String kind() {
            return "AliasTypeRef";
        }

        public /* synthetic */ Types scala$reflect$internal$Types$AliasTypeRef$$$outer();

        public static /* synthetic */ Symbols.Symbol $anonfun$$init$$2(AliasTypeRef $this) {
            return ((TypeRef)((Object)$this)).sym();
        }

        public static /* synthetic */ Symbols.Symbol $anonfun$coevolveSym$2(AliasTypeRef $this) {
            return ((TypeRef)((Object)$this)).sym();
        }

        /*
         * WARNING - void declaration
         */
        public static void $init$(AliasTypeRef $this) {
            void require_requirement;
            SymbolTable symbolTable = (SymbolTable)$this.scala$reflect$internal$Types$AliasTypeRef$$$outer();
            boolean bl = ((TypeRef)((Object)$this)).sym().isAliasType();
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable require_this = symbolTable;
            if (require_requirement == false) {
                throw require_this.throwRequirementError(AliasTypeRef.$anonfun$$init$$2($this));
            }
        }
    }

    public class AnnotatedType
    extends Type
    implements RewrappingTypeProxy,
    Types.AnnotatedTypeApi,
    Product,
    Serializable {
        private final List<AnnotationInfos.AnnotationInfo> annotations;
        private final Type underlying;

        @Override
        public Type maybeRewrap(Type newtp) {
            return ((RewrappingTypeProxy)this).maybeRewrap(newtp);
        }

        @Override
        public Type widen() {
            return ((RewrappingTypeProxy)this).widen();
        }

        @Override
        public Type narrow() {
            return ((RewrappingTypeProxy)this).narrow();
        }

        @Override
        public Type deconst() {
            return ((RewrappingTypeProxy)this).deconst();
        }

        @Override
        public Type resultType() {
            return ((RewrappingTypeProxy)this).resultType();
        }

        @Override
        public Type resultType(List<Type> actuals) {
            return ((RewrappingTypeProxy)this).resultType(actuals);
        }

        @Override
        public int paramSectionCount() {
            return ((RewrappingTypeProxy)this).paramSectionCount();
        }

        @Override
        public List<List<Symbols.Symbol>> paramss() {
            return ((RewrappingTypeProxy)this).paramss();
        }

        @Override
        public List<Symbols.Symbol> params() {
            return ((RewrappingTypeProxy)this).params();
        }

        @Override
        public List<Type> paramTypes() {
            return ((RewrappingTypeProxy)this).paramTypes();
        }

        @Override
        public List<Type> typeArgs() {
            return ((RewrappingTypeProxy)this).typeArgs();
        }

        @Override
        public Type skolemizeExistential(Symbols.Symbol owner, Object origin) {
            return ((RewrappingTypeProxy)this).skolemizeExistential(owner, origin);
        }

        @Override
        public Type normalize() {
            return ((RewrappingTypeProxy)this).normalize();
        }

        @Override
        public Type etaExpand() {
            return ((RewrappingTypeProxy)this).etaExpand();
        }

        @Override
        public Type dealias() {
            return ((RewrappingTypeProxy)this).dealias();
        }

        @Override
        public Type cloneInfo(Symbols.Symbol owner) {
            return ((RewrappingTypeProxy)this).cloneInfo(owner);
        }

        @Override
        public Type atOwner(Symbols.Symbol owner) {
            return ((RewrappingTypeProxy)this).atOwner(owner);
        }

        @Override
        public String prefixString() {
            return ((RewrappingTypeProxy)this).prefixString();
        }

        @Override
        public boolean isComplete() {
            return ((RewrappingTypeProxy)this).isComplete();
        }

        @Override
        public void complete(Symbols.Symbol sym) {
            ((RewrappingTypeProxy)this).complete(sym);
        }

        @Override
        public void load(Symbols.Symbol sym) {
            ((RewrappingTypeProxy)this).load(sym);
        }

        @Override
        public boolean isHigherKinded() {
            return ((SimpleTypeProxy)this).isHigherKinded();
        }

        @Override
        public Type typeConstructor() {
            return ((SimpleTypeProxy)this).typeConstructor();
        }

        @Override
        public boolean isError() {
            return ((SimpleTypeProxy)this).isError();
        }

        @Override
        public boolean isErroneous() {
            return ((SimpleTypeProxy)this).isErroneous();
        }

        @Override
        public Symbols.Symbol termSymbol() {
            return ((SimpleTypeProxy)this).termSymbol();
        }

        @Override
        public Symbols.Symbol termSymbolDirect() {
            return ((SimpleTypeProxy)this).termSymbolDirect();
        }

        @Override
        public List<Symbols.Symbol> typeParams() {
            return ((SimpleTypeProxy)this).typeParams();
        }

        @Override
        public Set<Symbols.Symbol> boundSyms() {
            return ((SimpleTypeProxy)this).boundSyms();
        }

        @Override
        public Symbols.Symbol typeSymbol() {
            return ((SimpleTypeProxy)this).typeSymbol();
        }

        @Override
        public Symbols.Symbol typeSymbolDirect() {
            return ((SimpleTypeProxy)this).typeSymbolDirect();
        }

        @Override
        public Type typeOfThis() {
            return ((SimpleTypeProxy)this).typeOfThis();
        }

        @Override
        public List<Type> parents() {
            return ((SimpleTypeProxy)this).parents();
        }

        @Override
        public Type prefix() {
            return ((SimpleTypeProxy)this).prefix();
        }

        @Override
        public Scopes.Scope decls() {
            return ((SimpleTypeProxy)this).decls();
        }

        @Override
        public Type baseType(Symbols.Symbol clazz) {
            return ((SimpleTypeProxy)this).baseType(clazz);
        }

        @Override
        public int baseTypeSeqDepth() {
            return ((SimpleTypeProxy)this).baseTypeSeqDepth();
        }

        @Override
        public List<Symbols.Symbol> baseClasses() {
            return ((SimpleTypeProxy)this).baseClasses();
        }

        @Override
        public List<AnnotationInfos.AnnotationInfo> annotations() {
            return this.annotations;
        }

        @Override
        public Type underlying() {
            return this.underlying;
        }

        @Override
        public AnnotatedType rewrap(Type tp) {
            List<AnnotationInfos.AnnotationInfo> x$2 = this.copy$default$1();
            return this.copy(x$2, tp);
        }

        @Override
        public boolean isTrivial() {
            if (this.underlying().isTrivial()) {
                boolean bl;
                block5: {
                    List<AnnotationInfos.AnnotationInfo> list = this.annotations();
                    if (list == null) {
                        throw null;
                    }
                    LinearSeqOptimized forall_these = list;
                    while (!forall_these.isEmpty()) {
                        if (!((AnnotationInfos.AnnotationInfo)forall_these.head()).isTrivial()) {
                            bl = false;
                            break block5;
                        }
                        forall_these = (LinearSeqOptimized)forall_these.tail();
                    }
                    bl = true;
                }
                if (bl) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public String safeToString() {
            return this.annotations().mkString(Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(this.underlying()), " @"), " @", "");
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public Type filterAnnotations(Function1<AnnotationInfos.AnnotationInfo, Object> p) {
            void var4_4;
            void var3_3;
            Tuple2<Traversable<AnnotationInfos.AnnotationInfo>, Traversable<AnnotationInfos.AnnotationInfo>> tuple2 = this.annotations().partition(p);
            if (tuple2 == null) {
                throw new MatchError((Object)null);
            }
            List yes = (List)tuple2._1();
            List no = (List)tuple2._2();
            void yes2 = var3_3;
            void no2 = var4_4;
            if (yes2.isEmpty()) {
                return this.underlying();
            }
            if (no2.isEmpty()) {
                return this;
            }
            return this.copy((List<AnnotationInfos.AnnotationInfo>)yes2, this.copy$default$2());
        }

        @Override
        public Type setAnnotations(List<AnnotationInfos.AnnotationInfo> annots) {
            if (annots.isEmpty()) {
                return this.underlying();
            }
            return this.copy(annots, this.copy$default$2());
        }

        @Override
        public Type withAnnotations(List<AnnotationInfos.AnnotationInfo> annots) {
            if (annots.isEmpty()) {
                return this;
            }
            return this.copy(this.annotations().$colon$colon$colon(annots), this.copy$default$2());
        }

        @Override
        public Type withoutAnnotations() {
            return this.underlying().withoutAnnotations();
        }

        @Override
        public TypeBounds bounds() {
            TypeBounds typeBounds = this.underlying().bounds();
            TypeBounds typeBounds2 = typeBounds != null && typeBounds.lo() == this && typeBounds.hi() == this ? this.scala$reflect$internal$Types$AnnotatedType$$$outer().TypeBounds().apply(this, this) : typeBounds;
            return typeBounds2;
        }

        @Override
        public Type lowerBound() {
            return this.bounds().lo();
        }

        @Override
        public Type upperBound() {
            return this.bounds().hi();
        }

        @Override
        public Type instantiateTypeParams(List<Symbols.Symbol> formals, List<Type> actuals) {
            List<AnnotationInfos.AnnotationInfo> annotations1 = this.annotations().map((Function1<AnnotationInfos.AnnotationInfo, AnnotationInfos.AnnotationInfo> & java.io.Serializable & Serializable)info -> this.scala$reflect$internal$Types$AnnotatedType$$$outer().AnnotationInfo().apply(info.atp().instantiateTypeParams(formals, actuals), info.args(), info.assocs()).setPos(info.pos()), List$.MODULE$.canBuildFrom());
            Type underlying1 = this.underlying().instantiateTypeParams(formals, actuals);
            if (annotations1 == this.annotations() && underlying1 == this.underlying()) {
                return this;
            }
            return new AnnotatedType(this.scala$reflect$internal$Types$AnnotatedType$$$outer(), annotations1, underlying1);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public BaseTypeSeqs.BaseTypeSeq baseTypeSeq() {
            void var1_1;
            BaseTypeSeqs.BaseTypeSeq oftp = this.underlying().baseTypeSeq();
            if (oftp.length() == 1 && oftp.apply(0) == this.underlying()) {
                return this.scala$reflect$internal$Types$AnnotatedType$$$outer().baseTypeSingletonSeq(this);
            }
            return var1_1;
        }

        @Override
        public String kind() {
            return "AnnotatedType";
        }

        public AnnotatedType copy(List<AnnotationInfos.AnnotationInfo> annotations, Type underlying) {
            return new AnnotatedType(this.scala$reflect$internal$Types$AnnotatedType$$$outer(), annotations, underlying);
        }

        public List<AnnotationInfos.AnnotationInfo> copy$default$1() {
            return this.annotations();
        }

        public Type copy$default$2() {
            return this.underlying();
        }

        @Override
        public String productPrefix() {
            return "AnnotatedType";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.annotations();
                }
                case 1: {
                    return this.underlying();
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
            return x$1 instanceof AnnotatedType;
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
            if (!(x$1 instanceof AnnotatedType)) return false;
            if (((AnnotatedType)x$1).scala$reflect$internal$Types$AnnotatedType$$$outer() != this.scala$reflect$internal$Types$AnnotatedType$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            AnnotatedType annotatedType = (AnnotatedType)x$1;
            List<AnnotationInfos.AnnotationInfo> list = this.annotations();
            List<AnnotationInfos.AnnotationInfo> list2 = annotatedType.annotations();
            if (list == null) {
                if (list2 != null) {
                    return false;
                }
            } else if (!((Object)list).equals(list2)) return false;
            Type type = this.underlying();
            Type type2 = annotatedType.underlying();
            if (type == null) {
                if (type2 != null) {
                    return false;
                }
            } else if (!type.equals(type2)) return false;
            if (!annotatedType.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$AnnotatedType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        @Override
        public /* synthetic */ Types scala$reflect$internal$Types$RewrappingTypeProxy$$$outer() {
            return this.scala$reflect$internal$Types$AnnotatedType$$$outer();
        }

        @Override
        public /* synthetic */ Types scala$reflect$internal$Types$SimpleTypeProxy$$$outer() {
            return this.scala$reflect$internal$Types$AnnotatedType$$$outer();
        }

        public static final /* synthetic */ String $anonfun$new$8(AnnotatedType $this) {
            return String.valueOf($this.underlying());
        }

        /*
         * WARNING - void declaration
         */
        public AnnotatedType(SymbolTable $outer, List<AnnotationInfos.AnnotationInfo> annotations, Type underlying) {
            void assert_assertion;
            boolean bl;
            this.annotations = annotations;
            this.underlying = underlying;
            super($outer);
            SimpleTypeProxy.$init$(this);
            RewrappingTypeProxy.$init$(this);
            Product.$init$(this);
            boolean bl2 = bl = !annotations.isEmpty();
            if ($outer == null) {
                throw null;
            }
            if (assert_assertion == false) {
                throw $outer.throwAssertionError(AnnotatedType.$anonfun$new$8(this));
            }
        }

        public static final /* synthetic */ Object $anonfun$isTrivial$1$adapted(AnnotationInfos.AnnotationInfo x$49) {
            return BoxesRunTime.boxToBoolean(x$49.isTrivial());
        }
    }

    public class AntiPolyType
    extends Type
    implements Product,
    Serializable {
        private final Type pre;
        private final List<Type> targs;

        public Type pre() {
            return this.pre;
        }

        public List<Type> targs() {
            return this.targs;
        }

        @Override
        public String safeToString() {
            return new StringBuilder(0).append(this.pre().toString()).append(this.targs().mkString("(with type arguments ", ", ", ")")).toString();
        }

        @Override
        public Type memberType(Symbols.Symbol sym) {
            return this.scala$reflect$internal$Types$AntiPolyType$$$outer().appliedType(this.pre().memberType(sym), this.targs());
        }

        @Override
        public String kind() {
            return "AntiPolyType";
        }

        public AntiPolyType copy(Type pre, List<Type> targs) {
            return new AntiPolyType(this.scala$reflect$internal$Types$AntiPolyType$$$outer(), pre, targs);
        }

        public Type copy$default$1() {
            return this.pre();
        }

        public List<Type> copy$default$2() {
            return this.targs();
        }

        @Override
        public String productPrefix() {
            return "AntiPolyType";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.pre();
                }
                case 1: {
                    return this.targs();
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
            return x$1 instanceof AntiPolyType;
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
            if (!(x$1 instanceof AntiPolyType)) return false;
            if (((AntiPolyType)x$1).scala$reflect$internal$Types$AntiPolyType$$$outer() != this.scala$reflect$internal$Types$AntiPolyType$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            AntiPolyType antiPolyType = (AntiPolyType)x$1;
            Type type = this.pre();
            Type type2 = antiPolyType.pre();
            if (type == null) {
                if (type2 != null) {
                    return false;
                }
            } else if (!type.equals(type2)) return false;
            List<Type> list = this.targs();
            List<Type> list2 = antiPolyType.targs();
            if (list == null) {
                if (list2 != null) {
                    return false;
                }
            } else if (!((Object)list).equals(list2)) return false;
            if (!antiPolyType.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$AntiPolyType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public AntiPolyType(SymbolTable $outer, Type pre, List<Type> targs) {
            this.pre = pre;
            this.targs = targs;
            super($outer);
            Product.$init$(this);
        }
    }

    public class AppliedTypeVar
    extends TypeVar {
        private final List<Symbols.Symbol> params;
        private final List<Type> typeArgs;

        @Override
        public List<Symbols.Symbol> params() {
            return this.params;
        }

        @Override
        public List<Type> typeArgs() {
            return this.typeArgs;
        }

        @Override
        public String safeToString() {
            return new StringBuilder(0).append(super.safeToString()).append(((TraversableOnce)this.typeArgs().map((Function1<Type, String> & java.io.Serializable & Serializable)x$42 -> x$42.safeToString(), List$.MODULE$.canBuildFrom())).mkString("[", ", ", "]")).toString();
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$AppliedTypeVar$$$outer() {
            return (SymbolTable)this.$outer;
        }

        /*
         * WARNING - void declaration
         */
        public AppliedTypeVar(SymbolTable $outer, Type _origin, TypeConstraints.TypeConstraint _constr, List<Symbols.Symbol> params, List<Type> typeArgs) {
            void require_requirement;
            boolean bl;
            this.params = params;
            this.typeArgs = typeArgs;
            super($outer, _origin, _constr);
            boolean bl2 = bl = params.nonEmpty() && $outer.sameLength(params, typeArgs);
            if ($outer == null) {
                throw null;
            }
            if (require_requirement == false) {
                throw $outer.throwRequirementError(this);
            }
        }
    }

    public class ArgsTypeRef
    extends TypeRef {
        @Override
        public boolean isHigherKinded() {
            return false;
        }

        public Nil$ typeParams() {
            return Nil$.MODULE$;
        }

        @Override
        public Type typeConstructor() {
            return this.scala$reflect$internal$Types$ArgsTypeRef$$$outer().TypeRef().apply(this.pre(), this.sym(), Nil$.MODULE$);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$ArgsTypeRef$$$outer() {
            return (SymbolTable)this.$outer;
        }

        /*
         * WARNING - void declaration
         */
        public ArgsTypeRef(SymbolTable $outer, Type pre0, Symbols.Symbol sym0, List<Type> args0) {
            super($outer, pre0, sym0, args0);
            void require_requirement;
            boolean bl;
            boolean bl2 = bl = super.args() != Nil$.MODULE$;
            if ($outer == null) {
                throw null;
            }
            if (require_requirement == false) {
                throw $outer.throwRequirementError(this);
            }
        }
    }

    public class BoundedWildcardType
    extends Type
    implements Types.BoundedWildcardTypeApi,
    Product,
    Serializable {
        private final TypeBounds bounds;

        @Override
        public TypeBounds bounds() {
            return this.bounds;
        }

        @Override
        public Type upperBound() {
            return this.bounds().hi();
        }

        @Override
        public Type lowerBound() {
            return this.bounds().lo();
        }

        @Override
        public boolean isWildcard() {
            return true;
        }

        @Override
        public String safeToString() {
            return new StringBuilder(1).append("?").append(this.bounds()).toString();
        }

        @Override
        public String kind() {
            return "BoundedWildcardType";
        }

        public BoundedWildcardType copy(TypeBounds bounds) {
            return new BoundedWildcardType(this.scala$reflect$internal$Types$BoundedWildcardType$$$outer(), bounds);
        }

        public TypeBounds copy$default$1() {
            return this.bounds();
        }

        @Override
        public String productPrefix() {
            return "BoundedWildcardType";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.bounds();
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
            return x$1 instanceof BoundedWildcardType;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof BoundedWildcardType && ((BoundedWildcardType)x$1).scala$reflect$internal$Types$BoundedWildcardType$$$outer() == this.scala$reflect$internal$Types$BoundedWildcardType$$$outer();
                    if (!bl) break block3;
                    BoundedWildcardType boundedWildcardType = (BoundedWildcardType)x$1;
                    TypeBounds typeBounds = this.bounds();
                    TypeBounds typeBounds2 = boundedWildcardType.bounds();
                    if (!(!(typeBounds != null ? !((Object)typeBounds).equals(typeBounds2) : typeBounds2 != null) && boundedWildcardType.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$BoundedWildcardType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public BoundedWildcardType(SymbolTable $outer, TypeBounds bounds) {
            this.bounds = bounds;
            super($outer);
            Product.$init$(this);
        }
    }

    private final class ClassArgsTypeRef
    extends ArgsTypeRef {
        public ClassArgsTypeRef(SymbolTable $outer, Type pre, Symbols.Symbol sym, List<Type> args2) {
            super($outer, pre, sym, args2);
        }
    }

    public class ClassInfoType
    extends CompoundType
    implements Types.ClassInfoTypeApi,
    Product,
    Serializable {
        private volatile Types$ClassInfoType$enterRefs$ enterRefs$module;
        private final List<Type> parents;
        private final Scopes.Scope decls;
        private final Symbols.Symbol typeSymbol;
        private scala.collection.immutable.Map<Symbols.Symbol, Set<Symbols.Symbol>>[] refs;
        private int state;

        private Types$ClassInfoType$enterRefs$ enterRefs() {
            if (this.enterRefs$module == null) {
                this.enterRefs$lzycompute$1();
            }
            return this.enterRefs$module;
        }

        @Override
        public List<Type> parents() {
            return this.parents;
        }

        @Override
        public Scopes.Scope decls() {
            return this.decls;
        }

        @Override
        public Symbols.Symbol typeSymbol() {
            return this.typeSymbol;
        }

        private final int NonExpansive() {
            return 0;
        }

        private final int Expansive() {
            return 1;
        }

        private final int UnInitialized() {
            return 0;
        }

        private final int Initializing() {
            return 1;
        }

        private final int Initialized() {
            return 2;
        }

        public Set<Symbols.Symbol> expansiveRefs(Symbols.Symbol tparam) {
            if (this.state() == 0) {
                this.computeRefs();
                while (this.state() != 2) {
                    this.propagate();
                }
            }
            return this.getRefs(1, tparam);
        }

        private scala.collection.immutable.Map<Symbols.Symbol, Set<Symbols.Symbol>>[] refs() {
            return this.refs;
        }

        private void refs_$eq(scala.collection.immutable.Map<Symbols.Symbol, Set<Symbols.Symbol>>[] x$1) {
            this.refs = x$1;
        }

        private int state() {
            return this.state;
        }

        private void state_$eq(int x$1) {
            this.state = x$1;
        }

        private Set<Symbols.Symbol> getRefs(int which, Symbols.Symbol from) {
            Option option = this.refs()[which].get(from);
            Set set = option instanceof Some ? (Set)((Some)option).value() : (Set)Predef$.MODULE$.Set().apply(Nil$.MODULE$);
            return set;
        }

        /*
         * WARNING - void declaration
         */
        public void scala$reflect$internal$Types$ClassInfoType$$addRef(int which, Symbols.Symbol from, Symbols.Symbol to) {
            void $minus$greater$extension_y;
            void $minus$greater$extension_$this;
            Object Repr = this.getRefs(which, from).$plus(to);
            Symbols.Symbol symbol = Predef$.MODULE$.ArrowAssoc(from);
            if (Predef$ArrowAssoc$.MODULE$ == null) {
                throw null;
            }
            this.refs()[which] = this.refs()[which].$plus(new Tuple2<void, void>($minus$greater$extension_$this, $minus$greater$extension_y));
        }

        /*
         * WARNING - void declaration
         */
        private void addRefs(int which, Symbols.Symbol from, Set<Symbols.Symbol> to) {
            void $minus$greater$extension_y;
            void $minus$greater$extension_$this;
            Object This2 = this.getRefs(which, from).$plus$plus(to);
            Symbols.Symbol symbol = Predef$.MODULE$.ArrowAssoc(from);
            if (Predef$ArrowAssoc$.MODULE$ == null) {
                throw null;
            }
            this.refs()[which] = this.refs()[which].$plus(new Tuple2<void, void>($minus$greater$extension_$this, $minus$greater$extension_y));
        }

        private ClassInfoType classInfo(Symbols.Symbol tparam) {
            Type type;
            while (true) {
                if ((type = tparam.owner().info().resultType()) instanceof ClassInfoType) break;
                tparam = this.scala$reflect$internal$Types$ClassInfoType$$$outer().definitions().ObjectClass();
            }
            ClassInfoType classInfoType = (ClassInfoType)type;
            return classInfoType;
        }

        private void computeRefs() {
            this.refs_$eq((scala.collection.immutable.Map[])((Object[])new scala.collection.immutable.Map[]{(scala.collection.immutable.Map)Predef$.MODULE$.Map().apply(Nil$.MODULE$), (scala.collection.immutable.Map)Predef$.MODULE$.Map().apply(Nil$.MODULE$)}));
            List list = this.typeSymbol().typeParams();
            if (list == null) {
                throw null;
            }
            List foreach_these = list;
            while (!foreach_these.isEmpty()) {
                Symbols.Symbol symbol = foreach_these.head();
                ClassInfoType.$anonfun$computeRefs$1(this, symbol);
                foreach_these = (List)foreach_these.tail();
            }
            this.state_$eq(1);
        }

        /*
         * Unable to fully structure code
         */
        private boolean propagate() {
            if (this.state() == 0) {
                this.computeRefs();
            }
            lastRefs = (scala.collection.immutable.Map[])((Object[])new scala.collection.immutable.Map[]{this.refs()[0], this.refs()[1]});
            this.state_$eq(2);
            change = BooleanRef.create(false);
            this.refs()[0].iterator().withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$propagate$1$adapted(scala.Tuple2 ), (Lscala/Tuple2;)Ljava/lang/Object;)()).foreach((Function1<Tuple2, Object> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$propagate$2$adapted(scala.reflect.internal.Types$ClassInfoType scala.runtime.BooleanRef scala.Tuple2 ), (Lscala/Tuple2;)Ljava/lang/Object;)((ClassInfoType)this, (BooleanRef)change));
            this.refs()[1].iterator().withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$propagate$4$adapted(scala.Tuple2 ), (Lscala/Tuple2;)Ljava/lang/Object;)()).foreach((Function1<Tuple2, Object> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$propagate$5$adapted(scala.reflect.internal.Types$ClassInfoType scala.runtime.BooleanRef scala.Tuple2 ), (Lscala/Tuple2;)Ljava/lang/Object;)((ClassInfoType)this, (BooleanRef)change));
            if (change.elem) ** GOTO lbl-1000
            v0 = this.refs()[0];
            var3_3 = lastRefs[0];
            if (v0 != null ? v0.equals(var3_3) == false : var3_3 != null) ** GOTO lbl-1000
            v1 = this.refs()[1];
            var4_4 = lastRefs[1];
            if (v1 == null ? var4_4 != null : v1.equals(var4_4) == false) lbl-1000:
            // 3 sources

            {
                v2 = true;
            } else {
                v2 = change.elem = false;
            }
            if (change.elem) {
                this.state_$eq(1);
            }
            return change.elem;
        }

        @Override
        public String kind() {
            return "ClassInfoType";
        }

        public String formattedToString() {
            return new StringBuilder(0).append(this.parents().mkString("\n        with ")).append(this.scopeString()).toString();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public boolean shouldForceScope() {
            void reflectSettingToBoolean_s;
            MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Types$ClassInfoType$$$outer().settings().debug();
            if (MutableSettings$.MODULE$ == null) {
                throw null;
            }
            return BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value()) || this.decls().size() > 1;
        }

        @Override
        public String scopeString() {
            return this.initDecls().mkString(" {\n  ", "\n  ", "\n}");
        }

        @Override
        public String safeToString() {
            if (this.shouldForceScope()) {
                return this.formattedToString();
            }
            return super.safeToString();
        }

        public ClassInfoType copy(List<Type> parents, Scopes.Scope decls, Symbols.Symbol typeSymbol) {
            return new ClassInfoType(this.scala$reflect$internal$Types$ClassInfoType$$$outer(), parents, decls, typeSymbol);
        }

        public List<Type> copy$default$1() {
            return this.parents();
        }

        public Scopes.Scope copy$default$2() {
            return this.decls();
        }

        public Symbols.Symbol copy$default$3() {
            return this.typeSymbol();
        }

        @Override
        public String productPrefix() {
            return "ClassInfoType";
        }

        @Override
        public int productArity() {
            return 3;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.parents();
                }
                case 1: {
                    return this.decls();
                }
                case 2: {
                    return this.typeSymbol();
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
            return x$1 instanceof ClassInfoType;
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
            if (!(x$1 instanceof ClassInfoType)) return false;
            if (((ClassInfoType)x$1).scala$reflect$internal$Types$ClassInfoType$$$outer() != this.scala$reflect$internal$Types$ClassInfoType$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            ClassInfoType classInfoType = (ClassInfoType)x$1;
            List<Type> list = this.parents();
            List<Type> list2 = classInfoType.parents();
            if (list == null) {
                if (list2 != null) {
                    return false;
                }
            } else if (!((Object)list).equals(list2)) return false;
            Scopes.Scope scope = this.decls();
            Scopes.Scope scope2 = classInfoType.decls();
            if (scope == null) {
                if (scope2 != null) {
                    return false;
                }
            } else if (!scope.equals(scope2)) return false;
            Symbols.Symbol symbol = this.typeSymbol();
            Symbols.Symbol symbol2 = classInfoType.typeSymbol();
            if (symbol == null) {
                if (symbol2 != null) {
                    return false;
                }
            } else if (!symbol.equals(symbol2)) return false;
            if (!classInfoType.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$ClassInfoType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        private final void enterRefs$lzycompute$1() {
            synchronized (this) {
                if (this.enterRefs$module == null) {
                    this.enterRefs$module = new Types$ClassInfoType$enterRefs$(this);
                }
                return;
            }
        }

        public static final /* synthetic */ void $anonfun$computeRefs$2(ClassInfoType $this, Symbols.Symbol tparam$1, Type p) {
            $this.enterRefs().enter(tparam$1, p);
        }

        public static final /* synthetic */ void $anonfun$computeRefs$1(ClassInfoType $this, Symbols.Symbol tparam) {
            List list = $this.parents();
            if (list == null) {
                throw null;
            }
            List foreach_these = list;
            while (!foreach_these.isEmpty()) {
                Type type = foreach_these.head();
                ClassInfoType.$anonfun$computeRefs$2($this, tparam, type);
                foreach_these = (List)foreach_these.tail();
            }
        }

        public static final /* synthetic */ void $anonfun$propagate$3(ClassInfoType $this, BooleanRef change$1, Symbols.Symbol from$1, Symbols.Symbol target) {
            ClassInfoType thatInfo = $this.classInfo(target);
            if (thatInfo.state() != 2) {
                change$1.elem |= thatInfo.propagate();
            }
            $this.addRefs(0, from$1, thatInfo.getRefs(0, target));
            $this.addRefs(1, from$1, thatInfo.getRefs(1, target));
        }

        public static final /* synthetic */ void $anonfun$propagate$2(ClassInfoType $this, BooleanRef change$1, Tuple2 x$25) {
            if (x$25 != null) {
                Symbols.Symbol from = (Symbols.Symbol)x$25._1();
                ((Set)x$25._2()).foreach((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)(A target) -> {
                    ClassInfoType.$anonfun$propagate$3($this, change$1, from, target);
                    return BoxedUnit.UNIT;
                });
                return;
            }
            throw new MatchError((Object)null);
        }

        public static final /* synthetic */ void $anonfun$propagate$6(ClassInfoType $this, BooleanRef change$1, Symbols.Symbol from$2, Symbols.Symbol target) {
            ClassInfoType thatInfo = $this.classInfo(target);
            if (thatInfo.state() != 2) {
                change$1.elem |= thatInfo.propagate();
            }
            $this.addRefs(1, from$2, thatInfo.getRefs(0, target));
        }

        public static final /* synthetic */ void $anonfun$propagate$5(ClassInfoType $this, BooleanRef change$1, Tuple2 x$26) {
            if (x$26 != null) {
                Symbols.Symbol from = (Symbols.Symbol)x$26._1();
                ((Set)x$26._2()).foreach((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)(A target) -> {
                    ClassInfoType.$anonfun$propagate$6($this, change$1, from, target);
                    return BoxedUnit.UNIT;
                });
                return;
            }
            throw new MatchError((Object)null);
        }

        public ClassInfoType(SymbolTable $outer, List<Type> parents, Scopes.Scope decls, Symbols.Symbol typeSymbol) {
            this.parents = parents;
            this.decls = decls;
            this.typeSymbol = typeSymbol;
            super($outer);
            Product.$init$(this);
            $outer.validateClassInfo(this);
            this.state = 0;
        }

        public static final /* synthetic */ Object $anonfun$computeRefs$1$adapted(ClassInfoType $this, Symbols.Symbol tparam) {
            ClassInfoType.$anonfun$computeRefs$1($this, tparam);
            return BoxedUnit.UNIT;
        }

        public static final /* synthetic */ Object $anonfun$propagate$1$adapted(Tuple2 check$ifrefutable$1) {
            return BoxesRunTime.boxToBoolean(bl = check$ifrefutable$1 != null);
        }

        public static final /* synthetic */ Object $anonfun$propagate$2$adapted(ClassInfoType $this, BooleanRef change$1, Tuple2 x$25) {
            ClassInfoType.$anonfun$propagate$2($this, change$1, x$25);
            return BoxedUnit.UNIT;
        }

        public static final /* synthetic */ Object $anonfun$propagate$4$adapted(Tuple2 check$ifrefutable$2) {
            return BoxesRunTime.boxToBoolean(bl = check$ifrefutable$2 != null);
        }

        public static final /* synthetic */ Object $anonfun$propagate$5$adapted(ClassInfoType $this, BooleanRef change$1, Tuple2 x$26) {
            ClassInfoType.$anonfun$propagate$5($this, change$1, x$26);
            return BoxedUnit.UNIT;
        }

        public static final /* synthetic */ Object $anonfun$computeRefs$2$adapted(ClassInfoType $this, Symbols.Symbol tparam$1, Type p) {
            ClassInfoType.$anonfun$computeRefs$2($this, tparam$1, p);
            return BoxedUnit.UNIT;
        }
    }

    private final class ClassNoArgsTypeRef
    extends NoArgsTypeRef {
        public ClassNoArgsTypeRef(SymbolTable $outer, Type pre, Symbols.Symbol sym) {
            super($outer, pre, sym);
        }
    }

    public class ClassUnwrapper
    extends TypeUnwrapper {
        @Override
        public Type apply(Type tp) {
            return super.apply(tp.normalize());
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$ClassUnwrapper$$$outer() {
            return this.$outer;
        }

        public ClassUnwrapper(SymbolTable $outer, boolean existential) {
            super($outer, true, existential, true, false);
        }
    }

    public abstract class CompoundType
    extends Type
    implements Types.CompoundTypeApi {
        private BaseTypeSeqs.BaseTypeSeq baseTypeSeqCache;
        private int baseTypeSeqPeriod = 0;
        private List<Symbols.Symbol> baseClassesCache;
        private int baseClassesPeriod = 0;

        public BaseTypeSeqs.BaseTypeSeq baseTypeSeqCache() {
            return this.baseTypeSeqCache;
        }

        public void baseTypeSeqCache_$eq(BaseTypeSeqs.BaseTypeSeq x$1) {
            this.baseTypeSeqCache = x$1;
        }

        public int baseTypeSeqPeriod() {
            return this.baseTypeSeqPeriod;
        }

        public void baseTypeSeqPeriod_$eq(int x$1) {
            this.baseTypeSeqPeriod = x$1;
        }

        public List<Symbols.Symbol> baseClassesCache() {
            return this.baseClassesCache;
        }

        public void baseClassesCache_$eq(List<Symbols.Symbol> x$1) {
            this.baseClassesCache = x$1;
        }

        public int baseClassesPeriod() {
            return this.baseClassesPeriod;
        }

        public void baseClassesPeriod_$eq(int x$1) {
            this.baseClassesPeriod = x$1;
        }

        public void scala$reflect$internal$Types$$invalidatedCompoundTypeCaches() {
            this.baseTypeSeqCache_$eq(null);
            this.baseTypeSeqPeriod_$eq(0);
            this.baseClassesCache_$eq(null);
            this.baseClassesPeriod_$eq(0);
        }

        @Override
        public BaseTypeSeqs.BaseTypeSeq baseTypeSeq() {
            BaseTypeSeqs.BaseTypeSeq cached = this.baseTypeSeqCache();
            if (this.baseTypeSeqPeriod() == this.scala$reflect$internal$Types$CompoundType$$$outer().currentPeriod() && cached != null && !cached.equals(this.scala$reflect$internal$Types$CompoundType$$$outer().undetBaseTypeSeq())) {
                return cached;
            }
            this.scala$reflect$internal$Types$CompoundType$$$outer().defineBaseTypeSeqOfCompoundType(this);
            if (this.baseTypeSeqCache() == this.scala$reflect$internal$Types$CompoundType$$$outer().undetBaseTypeSeq()) {
                throw new RecoverableCyclicReference(this.scala$reflect$internal$Types$CompoundType$$$outer(), this.typeSymbol());
            }
            return this.baseTypeSeqCache();
        }

        @Override
        public int baseTypeSeqDepth() {
            return this.baseTypeSeq().maxDepth();
        }

        @Override
        public List<Symbols.Symbol> baseClasses() {
            List<Symbols.Symbol> cached = this.baseClassesCache();
            if (this.baseClassesPeriod() == this.scala$reflect$internal$Types$CompoundType$$$outer().currentPeriod() && cached != null) {
                return cached;
            }
            this.scala$reflect$internal$Types$CompoundType$$$outer().defineBaseClassesOfCompoundType(this);
            if (this.baseClassesCache() == null) {
                throw new RecoverableCyclicReference(this.scala$reflect$internal$Types$CompoundType$$$outer(), this.typeSymbol());
            }
            return this.baseClassesCache();
        }

        public <A> A memo(Function0<A> op1, Function1<Type, A> op2) {
            A a;
            Option option = this.scala$reflect$internal$Types$CompoundType$$$outer().intersectionWitness().get(this.parents());
            if (option instanceof Some) {
                A a2;
                Option option2 = ((WeakReference)((Some)option).value()).get();
                if (option2 instanceof Some) {
                    Type w = (Type)((Some)option2).value();
                    a2 = w == this ? op1.apply() : op2.apply(w);
                } else if (None$.MODULE$.equals(option2)) {
                    this.scala$reflect$internal$Types$CompoundType$$$outer().intersectionWitness().update(this.parents(), new WeakReference<CompoundType>(this));
                    a2 = op1.apply();
                } else {
                    throw new MatchError(option2);
                }
                a = a2;
            } else if (None$.MODULE$.equals(option)) {
                this.scala$reflect$internal$Types$CompoundType$$$outer().intersectionWitness().update(this.parents(), new WeakReference<CompoundType>(this));
                a = op1.apply();
            } else {
                throw new MatchError(option);
            }
            return a;
        }

        @Override
        public Type baseType(Symbols.Symbol sym) {
            int index = this.baseTypeIndex(sym);
            if (index >= 0) {
                return this.baseTypeSeq().apply(index);
            }
            return this.scala$reflect$internal$Types$CompoundType$$$outer().NoType();
        }

        @Override
        public Type narrow() {
            return this.typeSymbol().thisType();
        }

        @Override
        public boolean isStructuralRefinement() {
            return this.typeSymbol().isAnonOrRefinementClass() && this.decls().exists(this.scala$reflect$internal$Types$CompoundType$$$outer().symbolIsPossibleInRefinement());
        }

        /*
         * WARNING - void declaration
         */
        public boolean shouldForceScope() {
            void reflectSettingToBoolean_s;
            MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Types$CompoundType$$$outer().settings().debug();
            if (MutableSettings$.MODULE$ == null) {
                throw null;
            }
            return BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value()) || this.parents().isEmpty() || !this.decls().isEmpty();
        }

        public Scopes.Scope initDecls() {
            return this.scala$reflect$internal$Types$CompoundType$$$outer().definitions().fullyInitializeScope(this.decls());
        }

        public String scopeString() {
            if (this.shouldForceScope()) {
                return this.initDecls().mkString("{", "; ", "}");
            }
            return "";
        }

        @Override
        public String safeToString() {
            return new StringBuilder(0).append(this.scala$reflect$internal$Types$CompoundType$$$outer().definitions().parentsString(this.parents())).append(this.scopeString()).toString();
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$CompoundType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        private final Object updateCache$1(Function0 op1$1) {
            this.scala$reflect$internal$Types$CompoundType$$$outer().intersectionWitness().update(this.parents(), new WeakReference<CompoundType>(this));
            return op1$1.apply();
        }

        public CompoundType(SymbolTable $outer) {
            super($outer);
        }
    }

    public abstract class ConstantType
    extends SingletonType
    implements Types.ConstantTypeApi,
    Serializable {
        private final Constants.Constant value;

        @Override
        public Constants.Constant value() {
            return this.value;
        }

        @Override
        public Type underlying() {
            return this.value().tpe();
        }

        @Override
        public boolean isTrivial() {
            return true;
        }

        @Override
        public Type deconst() {
            return this.underlying().deconst();
        }

        @Override
        public String safeToString() {
            return new StringBuilder(2).append(this.underlying().toString()).append("(").append(this.value().escapedStringValue()).append(")").toString();
        }

        @Override
        public String kind() {
            return "ConstantType";
        }

        @Override
        public String productPrefix() {
            return "ConstantType";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.value();
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
            return x$1 instanceof ConstantType;
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof ConstantType && ((ConstantType)x$1).scala$reflect$internal$Types$ConstantType$$$outer() == this.scala$reflect$internal$Types$ConstantType$$$outer();
                    if (!bl) break block3;
                    ConstantType constantType = (ConstantType)x$1;
                    Constants.Constant constant = this.value();
                    Constants.Constant constant2 = constantType.value();
                    if (!(!(constant != null ? !((Object)constant).equals(constant2) : constant2 != null) && constantType.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$ConstantType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public ConstantType(SymbolTable $outer, Constants.Constant value) {
            this.value = value;
            super($outer);
            Symbols.Symbol symbol = this.underlying().typeSymbol();
            Symbols.ClassSymbol classSymbol = $outer.definitions().UnitClass();
            $outer.assert(symbol == null ? classSymbol != null : !symbol.equals(classSymbol));
        }
    }

    public abstract class ErasedValueType
    extends UniqueType
    implements Serializable {
        private final Symbols.Symbol valueClazz;
        private final Type erasedUnderlying;

        public Symbols.Symbol valueClazz() {
            return this.valueClazz;
        }

        public Type erasedUnderlying() {
            return this.erasedUnderlying;
        }

        @Override
        public String safeToString() {
            return new StringBuilder(19).append("ErasedValueType(").append(this.valueClazz()).append(", ").append(this.erasedUnderlying()).append(")").toString();
        }

        @Override
        public String productPrefix() {
            return "ErasedValueType";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.valueClazz();
                }
                case 1: {
                    return this.erasedUnderlying();
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
            return x$1 instanceof ErasedValueType;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public boolean equals(Object x$1) {
            if (this == x$1) return true;
            if (!(x$1 instanceof ErasedValueType)) return false;
            if (((ErasedValueType)x$1).scala$reflect$internal$Types$ErasedValueType$$$outer() != this.scala$reflect$internal$Types$ErasedValueType$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            ErasedValueType erasedValueType = (ErasedValueType)x$1;
            Symbols.Symbol symbol = this.valueClazz();
            Symbols.Symbol symbol2 = erasedValueType.valueClazz();
            if (symbol == null) {
                if (symbol2 != null) {
                    return false;
                }
            } else if (!symbol.equals(symbol2)) return false;
            Type type = this.erasedUnderlying();
            Type type2 = erasedValueType.erasedUnderlying();
            if (type == null) {
                if (type2 != null) {
                    return false;
                }
            } else if (!type.equals(type2)) return false;
            if (!erasedValueType.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$ErasedValueType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public ErasedValueType(SymbolTable $outer, Symbols.Symbol valueClazz, Type erasedUnderlying) {
            this.valueClazz = valueClazz;
            this.erasedUnderlying = erasedUnderlying;
            super($outer);
        }
    }

    public class ExistentialType
    extends Type
    implements RewrappingTypeProxy,
    Types.ExistentialTypeApi,
    Product,
    Serializable {
        private final List<Symbols.Symbol> quantified;
        private final Type underlying;

        @Override
        public Type maybeRewrap(Type newtp) {
            return ((RewrappingTypeProxy)this).maybeRewrap(newtp);
        }

        @Override
        public Type widen() {
            return ((RewrappingTypeProxy)this).widen();
        }

        @Override
        public Type narrow() {
            return ((RewrappingTypeProxy)this).narrow();
        }

        @Override
        public Type deconst() {
            return ((RewrappingTypeProxy)this).deconst();
        }

        @Override
        public Type resultType() {
            return ((RewrappingTypeProxy)this).resultType();
        }

        @Override
        public Type resultType(List<Type> actuals) {
            return ((RewrappingTypeProxy)this).resultType(actuals);
        }

        @Override
        public int paramSectionCount() {
            return ((RewrappingTypeProxy)this).paramSectionCount();
        }

        @Override
        public List<List<Symbols.Symbol>> paramss() {
            return ((RewrappingTypeProxy)this).paramss();
        }

        @Override
        public Type normalize() {
            return ((RewrappingTypeProxy)this).normalize();
        }

        @Override
        public Type etaExpand() {
            return ((RewrappingTypeProxy)this).etaExpand();
        }

        @Override
        public Type dealias() {
            return ((RewrappingTypeProxy)this).dealias();
        }

        @Override
        public String prefixString() {
            return ((RewrappingTypeProxy)this).prefixString();
        }

        @Override
        public boolean isComplete() {
            return ((RewrappingTypeProxy)this).isComplete();
        }

        @Override
        public void complete(Symbols.Symbol sym) {
            ((RewrappingTypeProxy)this).complete(sym);
        }

        @Override
        public void load(Symbols.Symbol sym) {
            ((RewrappingTypeProxy)this).load(sym);
        }

        @Override
        public Type withAnnotations(List<AnnotationInfos.AnnotationInfo> annots) {
            return ((RewrappingTypeProxy)this).withAnnotations(annots);
        }

        @Override
        public Type withoutAnnotations() {
            return ((RewrappingTypeProxy)this).withoutAnnotations();
        }

        @Override
        public Type typeConstructor() {
            return ((SimpleTypeProxy)this).typeConstructor();
        }

        @Override
        public boolean isError() {
            return ((SimpleTypeProxy)this).isError();
        }

        @Override
        public boolean isErroneous() {
            return ((SimpleTypeProxy)this).isErroneous();
        }

        @Override
        public Symbols.Symbol termSymbol() {
            return ((SimpleTypeProxy)this).termSymbol();
        }

        @Override
        public Symbols.Symbol termSymbolDirect() {
            return ((SimpleTypeProxy)this).termSymbolDirect();
        }

        @Override
        public List<Symbols.Symbol> typeParams() {
            return ((SimpleTypeProxy)this).typeParams();
        }

        @Override
        public Symbols.Symbol typeSymbol() {
            return ((SimpleTypeProxy)this).typeSymbol();
        }

        @Override
        public Symbols.Symbol typeSymbolDirect() {
            return ((SimpleTypeProxy)this).typeSymbolDirect();
        }

        @Override
        public Type typeOfThis() {
            return ((SimpleTypeProxy)this).typeOfThis();
        }

        @Override
        public TypeBounds bounds() {
            return ((SimpleTypeProxy)this).bounds();
        }

        @Override
        public Scopes.Scope decls() {
            return ((SimpleTypeProxy)this).decls();
        }

        @Override
        public int baseTypeSeqDepth() {
            return ((SimpleTypeProxy)this).baseTypeSeqDepth();
        }

        @Override
        public List<Symbols.Symbol> baseClasses() {
            return ((SimpleTypeProxy)this).baseClasses();
        }

        public List<Symbols.Symbol> quantified() {
            return this.quantified;
        }

        @Override
        public Type underlying() {
            return this.underlying;
        }

        @Override
        public Type rewrap(Type newtp) {
            return this.scala$reflect$internal$Types$ExistentialType$$$outer().existentialAbstraction(this.quantified(), newtp);
        }

        @Override
        public boolean isTrivial() {
            return false;
        }

        @Override
        public Type lowerBound() {
            return this.maybeRewrap(this.underlying().lowerBound());
        }

        @Override
        public Type upperBound() {
            return this.maybeRewrap(this.underlying().upperBound());
        }

        @Override
        public List<Type> parents() {
            return this.underlying().parents().map((Function1<Type, Type> & java.io.Serializable & Serializable)newtp -> this.maybeRewrap((Type)newtp), List$.MODULE$.canBuildFrom());
        }

        @Override
        public Set<Symbols.Symbol> boundSyms() {
            return this.quantified().toSet();
        }

        @Override
        public Type prefix() {
            return this.maybeRewrap(this.underlying().prefix());
        }

        @Override
        public List<Type> typeArgs() {
            return this.underlying().typeArgs().map((Function1<Type, Type> & java.io.Serializable & Serializable)newtp -> this.maybeRewrap((Type)newtp), List$.MODULE$.canBuildFrom());
        }

        @Override
        public List<Symbols.Symbol> params() {
            $colon$colon<Nothing$> $colon$colon;
            List<Symbols.Symbol> mapConserve_this;
            List<Symbols.Symbol> list = this.underlying().params();
            if (list == null) {
                throw null;
            }
            List<Symbols.Symbol> list2 = mapConserve_this = list;
            List<Symbols.Symbol> list3 = mapConserve_this;
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
                Symbols.Symbol symbol = (Symbols.Symbol)mapConserve_loop$1_head0;
                Symbols.Symbol mapConserve_loop$1_head1 = ExistentialType.$anonfun$params$1(this, symbol);
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
            return $colon$colon;
        }

        @Override
        public List<Type> paramTypes() {
            return this.underlying().paramTypes().map((Function1<Type, Type> & java.io.Serializable & Serializable)newtp -> this.maybeRewrap((Type)newtp), List$.MODULE$.canBuildFrom());
        }

        @Override
        public Type instantiateTypeParams(List<Symbols.Symbol> formals, List<Type> actuals) {
            List<Symbols.Symbol> quantified1 = new TypeMaps.SubstTypeMap(this.scala$reflect$internal$Types$ExistentialType$$$outer(), formals, actuals).mapOver(this.quantified());
            Type underlying1 = this.underlying().instantiateTypeParams(formals, actuals);
            if (quantified1 == this.quantified() && underlying1 == this.underlying()) {
                return this;
            }
            return this.scala$reflect$internal$Types$ExistentialType$$$outer().existentialAbstraction(quantified1, underlying1.substSym(this.quantified(), quantified1));
        }

        @Override
        public Type baseType(Symbols.Symbol clazz) {
            return this.maybeRewrap(this.underlying().baseType(clazz));
        }

        @Override
        public BaseTypeSeqs.BaseTypeSeq baseTypeSeq() {
            return this.underlying().baseTypeSeq().map((Function1<Type, Type> & java.io.Serializable & Serializable)(Type newtp) -> this.maybeRewrap((Type)newtp));
        }

        @Override
        public boolean isHigherKinded() {
            return false;
        }

        private Symbols.Symbol quantifierOwner() {
            Option<Symbols.Symbol> option = this.quantified().collectFirst(new Serializable(null){
                public static final long serialVersionUID = 0L;

                public final <A1 extends Symbols.Symbol, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                    Symbols.Symbol symbol = x1.owner().exists() ? x1.owner() : function1.apply(x1);
                    return (B1)symbol;
                }

                public final boolean isDefinedAt(Symbols.Symbol x1) {
                    boolean bl = x1.owner().exists();
                    return bl;
                }
            });
            if (option == null) {
                throw null;
            }
            Option<Symbols.Symbol> getOrElse_this = option;
            Symbols.Symbol symbol = getOrElse_this.isEmpty() ? ExistentialType.$anonfun$quantifierOwner$2(this) : getOrElse_this.get();
            return symbol;
        }

        /*
         * WARNING - void declaration
         */
        private boolean isStraightApplication() {
            boolean bl;
            block3: {
                void corresponds_that;
                List<Symbols.Symbol> list = this.quantified();
                List<Type> list2 = this.underlying().typeArgs();
                if (list == null) {
                    throw null;
                }
                GenSeq corresponds_that2 = corresponds_that;
                LinearSeqLike corresponds_this = list;
                while (true) {
                    if (corresponds_this.isEmpty()) {
                        bl = corresponds_that2.isEmpty();
                        break block3;
                    }
                    if (!corresponds_that2.nonEmpty()) break;
                    Type type = (Type)corresponds_that2.head();
                    if (!ExistentialType.$anonfun$isStraightApplication$1((Symbols.Symbol)corresponds_this.head(), type)) break;
                    corresponds_that2 = (GenSeq)corresponds_that2.tail();
                    corresponds_this = (LinearSeqLike)corresponds_this.tail();
                }
                bl = false;
            }
            return bl;
        }

        @Override
        public Type skolemizeExistential(Symbols.Symbol owner0, Object origin) {
            if (owner0 == null) {
                throw null;
            }
            Symbols.Symbol symbol = owner0 != owner0.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol() ? owner0 : this.quantifierOwner();
            if ((this.underlying().typeSymbol().isJavaDefined() || this.scala$reflect$internal$Types$ExistentialType$$$outer().scala$reflect$internal$Types$$sharperSkolems()) && this.isStraightApplication()) {
                return this.scala$reflect$internal$Types$ExistentialType$$$outer().deriveType2(this.quantified(), this.tpars$1(), (Function2<Symbols.Symbol, Symbols.Symbol, Symbols.Symbol> & java.io.Serializable & Serializable)(quant, tparam) -> this.newSharpenedSkolem$1((Symbols.Symbol)quant, (Symbols.Symbol)tparam, symbol, origin), this.underlying());
            }
            return this.scala$reflect$internal$Types$ExistentialType$$$outer().deriveType(this.quantified(), (Function1<Symbols.Symbol, Symbols.Symbol>)(Function1<Symbols.Symbol, Symbols.TypeSkolem> & java.io.Serializable & Serializable)quant -> ExistentialType.newSkolem$1(quant, symbol, origin), this.underlying());
        }

        private List<String> wildcardArgsString(Set<Symbols.Symbol> qset, List<Type> args2) {
            return args2.map((Function1<Type, String> & java.io.Serializable & Serializable)x0$1 -> {
                Symbols.Symbol sym;
                String string = x0$1 instanceof TypeRef && qset.contains(sym = ((TypeRef)x0$1).sym()) ? new StringBuilder(1).append("_").append(sym.infoString(sym.info())).toString() : x0$1.toString();
                return string;
            }, List$.MODULE$.canBuildFrom());
        }

        /*
         * WARNING - void declaration
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public String nameAndArgsString() {
            boolean bl = false;
            TypeRef typeRef = null;
            Type type = this.underlying();
            if (type instanceof TypeRef) {
                void reflectSettingToBoolean_s;
                bl = true;
                typeRef = (TypeRef)type;
                Symbols.Symbol sym = typeRef.sym();
                List<Type> args2 = typeRef.args();
                MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Types$ExistentialType$$$outer().settings().debug();
                if (MutableSettings$.MODULE$ == null) {
                    throw null;
                }
                if (!BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value()) && this.isRepresentableWithWildcards()) {
                    return Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(sym.name()), this.wildcardArgsString((Set<Symbols.Symbol>)this.quantified().toSet(), args2).mkString("[", ",", "]"));
                }
            }
            if (!bl) return Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(this.underlying().typeSymbol().name()), this.existentialClauses());
            Symbols.Symbol sym = typeRef.sym();
            List<Type> args3 = typeRef.args();
            return new StringBuilder(0).append(Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(sym.name()), args3.mkString("[", ",", "]"))).append(this.existentialClauses()).toString();
        }

        /*
         * WARNING - void declaration
         */
        private String existentialClauses() {
            void var1_1;
            void reflectSettingToBoolean_s;
            String str = ((TraversableOnce)this.quantified().map((Function1<Symbols.Symbol, String> & java.io.Serializable & Serializable)x$37 -> x$37.existentialToString(), List$.MODULE$.canBuildFrom())).mkString(" forSome { ", "; ", " }");
            MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Types$ExistentialType$$$outer().settings().explaintypes();
            if (MutableSettings$.MODULE$ == null) {
                throw null;
            }
            if (BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value())) {
                return new StringBuilder(2).append("(").append(str).append(")").toString();
            }
            return var1_1;
        }

        /*
         * WARNING - void declaration
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean isRepresentableWithWildcards() {
            void var9_9;
            void var8_8;
            GenSet qset = this.quantified().toSet();
            Type type = this.underlying();
            if (type instanceof RefinementTypeRef) {
                return false;
            }
            if (!(type instanceof TypeRef)) return false;
            TypeRef typeRef = (TypeRef)type;
            Type pre = typeRef.pre();
            Symbols.Symbol sym = typeRef.sym();
            Tuple2<Traversable<Type>, Traversable<Type>> tuple2 = typeRef.args().partition(arg_0 -> ExistentialType.$anonfun$isRepresentableWithWildcards$3$adapted((Set)qset, arg_0));
            if (tuple2 == null) throw new MatchError((Object)null);
            List wildcardArgs = (List)tuple2._1();
            List otherArgs = (List)tuple2._2();
            void wildcardArgs2 = var8_8;
            void otherArgs2 = var9_9;
            if (wildcardArgs2.toSet().size() != wildcardArgs2.size()) return false;
            if (otherArgs2 == null) {
                throw null;
            }
            LinearSeqOptimized exists_these = otherArgs2;
            while (!exists_these.isEmpty()) {
                Type type2 = (Type)exists_these.head();
                if (ExistentialType.isQuantified$1(type2, (Set)qset)) {
                    return false;
                }
                exists_these = (LinearSeqOptimized)exists_these.tail();
            }
            boolean bl = false;
            if (bl) return false;
            LinearSeqOptimized exists_these2 = wildcardArgs2;
            while (!exists_these2.isEmpty()) {
                Type type3 = (Type)exists_these2.head();
                if (ExistentialType.isQuantified$1(type3.typeSymbol().info().bounds(), (Set)qset)) {
                    return false;
                }
                exists_these2 = (LinearSeqOptimized)exists_these2.tail();
            }
            boolean bl2 = false;
            if (bl2) return false;
            if (qset.contains(sym)) return false;
            if (ExistentialType.isQuantified$1(pre, (Set)qset)) return false;
            return true;
        }

        /*
         * WARNING - void declaration
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public String safeToString() {
            Type type = this.underlying();
            if (type instanceof TypeRef) {
                void reflectSettingToBoolean_s;
                TypeRef typeRef = (TypeRef)type;
                Type pre = typeRef.pre();
                Symbols.Symbol sym = typeRef.sym();
                List<Type> args2 = typeRef.args();
                MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Types$ExistentialType$$$outer().settings().debug();
                if (MutableSettings$.MODULE$ == null) {
                    throw null;
                }
                if (!BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value()) && this.isRepresentableWithWildcards()) {
                    return new StringBuilder(0).append(this.scala$reflect$internal$Types$ExistentialType$$$outer().TypeRef().apply(pre, sym, Nil$.MODULE$)).append(this.wildcardArgsString((Set<Symbols.Symbol>)this.quantified().toSet(), args2).mkString("[", ", ", "]")).toString();
                }
            }
            boolean bl = type instanceof MethodType ? true : (type instanceof NullaryMethodType ? true : type instanceof PolyType);
            if (!bl) return new StringBuilder(0).append(this.underlying()).append(this.existentialClauses()).toString();
            return new StringBuilder(2).append("(").append(this.underlying()).append(")").append(this.existentialClauses()).toString();
        }

        @Override
        public Type cloneInfo(Symbols.Symbol owner) {
            return (Type)this.scala$reflect$internal$Types$ExistentialType$$$outer().createFromClonedSymbolsAtOwner(this.quantified(), owner, this.underlying(), (Function2<List, Type, Type> & java.io.Serializable & Serializable)(quantified, underlying) -> this.scala$reflect$internal$Types$ExistentialType$$$outer().newExistentialType((List<Symbols.Symbol>)quantified, (Type)underlying));
        }

        @Override
        public Type atOwner(Symbols.Symbol owner) {
            if (!this.scala$reflect$internal$Types$ExistentialType$$$outer().allSymbolsHaveOwner(this.quantified(), owner)) {
                return this.cloneInfo(owner);
            }
            return this;
        }

        @Override
        public String kind() {
            return "ExistentialType";
        }

        public boolean withTypeVars(Function1<Type, Object> op) {
            return this.withTypeVars(op, Depth$.MODULE$.AnyDepth());
        }

        public boolean withTypeVars(Function1<Type, Object> op, int depth) {
            List<Symbols.Symbol> quantifiedFresh = this.scala$reflect$internal$Types$ExistentialType$$$outer().cloneSymbols(this.quantified());
            List<Type> tvars = quantifiedFresh.map((Function1<Symbols.Symbol, TypeVar> & java.io.Serializable & Serializable)tparam -> this.scala$reflect$internal$Types$ExistentialType$$$outer().TypeVar().apply((Symbols.Symbol)tparam), List$.MODULE$.canBuildFrom());
            Type underlying1 = this.underlying().instantiateTypeParams(this.quantified(), tvars);
            return BoxesRunTime.unboxToBoolean(op.apply(underlying1)) && this.scala$reflect$internal$Types$ExistentialType$$$outer().solve(tvars, quantifiedFresh, x$39 -> Variance$.MODULE$.Invariant(), false, depth) && this.scala$reflect$internal$Types$ExistentialType$$$outer().isWithinBounds(this.scala$reflect$internal$Types$ExistentialType$$$outer().NoPrefix(), this.scala$reflect$internal$Types$ExistentialType$$$outer().NoSymbol(), quantifiedFresh, tvars.map((Function1<TypeVar, Type> & java.io.Serializable & Serializable)x$40 -> x$40.inst(), List$.MODULE$.canBuildFrom()));
        }

        public ExistentialType copy(List<Symbols.Symbol> quantified, Type underlying) {
            return new ExistentialType(this.scala$reflect$internal$Types$ExistentialType$$$outer(), quantified, underlying);
        }

        public List<Symbols.Symbol> copy$default$1() {
            return this.quantified();
        }

        public Type copy$default$2() {
            return this.underlying();
        }

        @Override
        public String productPrefix() {
            return "ExistentialType";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.quantified();
                }
                case 1: {
                    return this.underlying();
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
            return x$1 instanceof ExistentialType;
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
            if (!(x$1 instanceof ExistentialType)) return false;
            if (((ExistentialType)x$1).scala$reflect$internal$Types$ExistentialType$$$outer() != this.scala$reflect$internal$Types$ExistentialType$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            ExistentialType existentialType = (ExistentialType)x$1;
            List<Symbols.Symbol> list = this.quantified();
            List<Symbols.Symbol> list2 = existentialType.quantified();
            if (list == null) {
                if (list2 != null) {
                    return false;
                }
            } else if (!((Object)list).equals(list2)) return false;
            Type type = this.underlying();
            Type type2 = existentialType.underlying();
            if (type == null) {
                if (type2 != null) {
                    return false;
                }
            } else if (!type.equals(type2)) return false;
            if (!existentialType.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$ExistentialType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        @Override
        public /* synthetic */ Types scala$reflect$internal$Types$RewrappingTypeProxy$$$outer() {
            return this.scala$reflect$internal$Types$ExistentialType$$$outer();
        }

        @Override
        public /* synthetic */ Types scala$reflect$internal$Types$SimpleTypeProxy$$$outer() {
            return this.scala$reflect$internal$Types$ExistentialType$$$outer();
        }

        public static final /* synthetic */ Symbols.Symbol $anonfun$params$1(ExistentialType $this, Symbols.Symbol param2) {
            Type tpe1 = $this.rewrap(param2.tpeHK());
            if (tpe1 == param2.tpeHK()) {
                return param2;
            }
            return param2.cloneSymbol().setInfo(tpe1);
        }

        public static final /* synthetic */ Symbols.NoSymbol $anonfun$quantifierOwner$2(ExistentialType $this) {
            return $this.scala$reflect$internal$Types$ExistentialType$$$outer().NoSymbol();
        }

        public static final /* synthetic */ boolean $anonfun$isStraightApplication$1(Symbols.Symbol q, Type a) {
            return q.tpe().$eq$colon$eq(a);
        }

        private final List tpars$1() {
            return this.underlying().typeSymbolDirect().initialize().typeParams();
        }

        private static final Symbols.TypeSkolem newSkolem$1(Symbols.Symbol quant, Symbols.Symbol owner$1, Object origin$1) {
            return owner$1.newExistentialSkolem(quant, origin$1);
        }

        private static final boolean emptyBounds$1(Symbols.Symbol sym) {
            return sym.info().bounds().isEmptyBounds();
        }

        public static final /* synthetic */ boolean $anonfun$skolemizeExistential$2(ExistentialType $this, Symbols.Symbol et) {
            return !$this.quantified().contains(et);
        }

        /*
         * Unable to fully structure code
         * Could not resolve type clashes
         */
        private final Symbols.Symbol newSharpenedSkolem$1(Symbols.Symbol quant, Symbols.Symbol tparam, Symbols.Symbol owner$1, Object origin$1) {
            block5: {
                if (!ExistentialType.emptyBounds$1(quant) || ExistentialType.emptyBounds$1(tparam)) ** GOTO lbl-1000
                v0 = this.scala$reflect$internal$Types$ExistentialType$$$outer().existentialsInType(tparam.info());
                if (v0 == null) {
                    throw null;
                }
                forall_these /* !! */  = v0;
                while (!forall_these /* !! */ .isEmpty()) {
                    var8_6 = (Symbols.Symbol)forall_these /* !! */ .head();
                    if (!ExistentialType.$anonfun$skolemizeExistential$2(this, var8_6)) {
                        var7_7 = false;
                        break block5;
                    }
                    forall_these /* !! */  = (LinearSeqOptimized)forall_these /* !! */ .tail();
                }
                var7_7 = true;
            }
            if (var7_7) {
                v1 = true;
            } else lbl-1000:
            // 2 sources

            {
                v1 = false;
            }
            skolemInfo = v1 == false ? quant.info() : tparam.info().substSym(this.tpars$1(), this.quantified());
            return owner$1.newExistentialSkolem(quant.name().toTypeName(), skolemInfo, quant.flags(), quant.pos(), origin$1);
        }

        private static final boolean isQuantified$1(Type tpe, Set qset$2) {
            block9: {
                block8: {
                    boolean bl;
                    block7: {
                        if (tpe.exists((Function1<Type, Object> & java.io.Serializable & Serializable)(Type t) -> BoxesRunTime.boxToBoolean(qset$2.contains(t.typeSymbol())))) break block8;
                        if (!tpe.typeSymbol().isRefinementClass()) break block9;
                        List<Type> list = tpe.parents();
                        if (list == null) {
                            throw null;
                        }
                        LinearSeqOptimized exists_these = list;
                        while (!exists_these.isEmpty()) {
                            Type type = (Type)exists_these.head();
                            if (ExistentialType.isQuantified$1(type, qset$2)) {
                                bl = true;
                                break block7;
                            }
                            exists_these = (LinearSeqOptimized)exists_these.tail();
                        }
                        bl = false;
                    }
                    if (!bl) break block9;
                }
                return true;
            }
            return false;
        }

        public ExistentialType(SymbolTable $outer, List<Symbols.Symbol> quantified, Type underlying) {
            this.quantified = quantified;
            this.underlying = underlying;
            super($outer);
            SimpleTypeProxy.$init$(this);
            RewrappingTypeProxy.$init$(this);
            Product.$init$(this);
        }

        public static final /* synthetic */ Object $anonfun$isStraightApplication$1$adapted(Symbols.Symbol q, Type a) {
            return BoxesRunTime.boxToBoolean(ExistentialType.$anonfun$isStraightApplication$1(q, a));
        }

        public static final /* synthetic */ Object $anonfun$isRepresentableWithWildcards$3$adapted(Set qset$2, Type arg) {
            return BoxesRunTime.boxToBoolean(qset$2.contains(arg.typeSymbol()));
        }

        public static final /* synthetic */ Object $anonfun$isRepresentableWithWildcards$4$adapted(Set qset$2, Type arg) {
            return BoxesRunTime.boxToBoolean(ExistentialType.isQuantified$1(arg, qset$2));
        }

        public static final /* synthetic */ Object $anonfun$isRepresentableWithWildcards$5$adapted(Set qset$2, Type arg) {
            return BoxesRunTime.boxToBoolean(ExistentialType.isQuantified$1(arg.typeSymbol().info().bounds(), qset$2));
        }

        public static final /* synthetic */ Object $anonfun$skolemizeExistential$2$adapted(ExistentialType $this, Symbols.Symbol et) {
            return BoxesRunTime.boxToBoolean(ExistentialType.$anonfun$skolemizeExistential$2($this, et));
        }

        public static final /* synthetic */ Object $anonfun$isRepresentableWithWildcards$2$adapted(Set qset$2, Type tpe) {
            return BoxesRunTime.boxToBoolean(ExistentialType.isQuantified$1(tpe, qset$2));
        }
    }

    public interface FlagAgnosticCompleter {
    }

    public interface FlagAssigningCompleter {
    }

    public class HKTypeVar
    extends TypeVar {
        private final List<Symbols.Symbol> params;

        @Override
        public List<Symbols.Symbol> params() {
            return this.params;
        }

        @Override
        public boolean isHigherKinded() {
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$HKTypeVar$$$outer() {
            return (SymbolTable)this.$outer;
        }

        /*
         * WARNING - void declaration
         */
        public HKTypeVar(SymbolTable $outer, Type _origin, TypeConstraints.TypeConstraint _constr, List<Symbols.Symbol> params) {
            void require_requirement;
            this.params = params;
            super($outer, _origin, _constr);
            boolean bl = params.nonEmpty();
            if ($outer == null) {
                throw null;
            }
            if (require_requirement == false) {
                throw $outer.throwRequirementError(this);
            }
        }
    }

    public class ImportType
    extends Type
    implements Product,
    Serializable {
        private final Trees.Tree expr;

        public Trees.Tree expr() {
            return this.expr;
        }

        @Override
        public String safeToString() {
            return new StringBuilder(12).append("ImportType(").append(this.expr()).append(")").toString();
        }

        public ImportType copy(Trees.Tree expr) {
            return new ImportType(this.scala$reflect$internal$Types$ImportType$$$outer(), expr);
        }

        public Trees.Tree copy$default$1() {
            return this.expr();
        }

        @Override
        public String productPrefix() {
            return "ImportType";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.expr();
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
            return x$1 instanceof ImportType;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof ImportType && ((ImportType)x$1).scala$reflect$internal$Types$ImportType$$$outer() == this.scala$reflect$internal$Types$ImportType$$$outer();
                    if (!bl) break block3;
                    ImportType importType = (ImportType)x$1;
                    Trees.Tree tree = this.expr();
                    Trees.Tree tree2 = importType.expr();
                    if (!(!(tree != null ? !((Object)tree).equals(tree2) : tree2 != null) && importType.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$ImportType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public ImportType(SymbolTable $outer, Trees.Tree expr) {
            this.expr = expr;
            super($outer);
            Product.$init$(this);
        }
    }

    public class JavaMethodType
    extends MethodType {
        @Override
        public boolean isJava() {
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$JavaMethodType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public JavaMethodType(SymbolTable $outer, List<Symbols.Symbol> ps, Type rt) {
            super($outer, ps, rt);
        }
    }

    public abstract class LazyPolyType
    extends LazyType {
        private final List<Symbols.Symbol> typeParams;

        @Override
        public List<Symbols.Symbol> typeParams() {
            return this.typeParams;
        }

        @Override
        public String safeToString() {
            return new StringBuilder(0).append(this.typeParams().isEmpty() ? "" : this.scala$reflect$internal$Types$LazyPolyType$$$outer().typeParamsString(this)).append(super.safeToString()).toString();
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$LazyPolyType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public LazyPolyType(SymbolTable $outer, List<Symbols.Symbol> typeParams) {
            this.typeParams = typeParams;
            super($outer);
        }
    }

    public abstract class LazyType
    extends Type {
        @Override
        public boolean isComplete() {
            return false;
        }

        @Override
        public abstract void complete(Symbols.Symbol var1);

        @Override
        public String safeToString() {
            return "<?>";
        }

        @Override
        public String kind() {
            return "LazyType";
        }

        public boolean isJavaVarargsMethod() {
            return false;
        }

        public List<Symbols.Symbol> javaThrownExceptions() {
            return Nil$.MODULE$;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$LazyType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public LazyType(SymbolTable $outer) {
            super($outer);
        }
    }

    public class MalformedType
    extends TypeError {
        public /* synthetic */ SymbolTable scala$reflect$internal$Types$MalformedType$$$outer() {
            return this.$outer;
        }

        public MalformedType(SymbolTable $outer, String msg) {
            super($outer, msg);
        }

        public MalformedType(SymbolTable $outer, Type pre, String tp) {
            this($outer, new StringBuilder(17).append("malformed type: ").append(pre).append("#").append(tp).toString());
        }
    }

    public class MethodType
    extends Type
    implements Types.MethodTypeApi,
    Product,
    Serializable {
        private final List<Symbols.Symbol> params;
        private final Type resultType;
        private byte trivial;
        private byte isdepmeth;

        @Override
        public List<Symbols.Symbol> params() {
            return this.params;
        }

        @Override
        public Type resultType() {
            return this.resultType;
        }

        private byte trivial() {
            return this.trivial;
        }

        private void trivial_$eq(byte x$1) {
            this.trivial = x$1;
        }

        @Override
        public boolean isTrivial() {
            if (this.trivial() == 0) {
                this.trivial_$eq(ThreeValues$.MODULE$.fromBoolean(this.isTrivialResult() && this.areTrivialParams()));
            }
            return ThreeValues$.MODULE$.toBoolean(this.trivial());
        }

        private boolean isTrivialResult() {
            return this.resultType().isTrivial() && this.resultType() == this.resultType().withoutAnnotations();
        }

        private boolean areTrivialParams() {
            Type[] paramsTpes;
            if (this.params().isEmpty()) {
                return true;
            }
            int len = this.params().length();
            return this.forallIsTrivial$1(len, paramsTpes = new Type[len]) && this.forallParamsNoTypeContains$1(this.params(), len, paramsTpes);
        }

        public boolean isImplicit() {
            return this.params() != Nil$.MODULE$ && ((HasFlags)this.params().head()).isImplicit();
        }

        public boolean isJava() {
            return false;
        }

        @Override
        public int paramSectionCount() {
            return this.resultType().paramSectionCount() + 1;
        }

        @Override
        public List<List<Symbols.Symbol>> paramss() {
            List<Symbols.Symbol> list = this.params();
            return this.resultType().paramss().$colon$colon(list);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public List<Type> paramTypes() {
            void var2_2;
            $colon$colon<Nothing$> mapList_head;
            void mapList_as;
            List<Symbols.Symbol> list = this.params();
            if (this.scala$reflect$internal$Types$MethodType$$$outer() == null) {
                throw null;
            }
            if (mapList_as == Nil$.MODULE$) {
                return Nil$.MODULE$;
            }
            $colon$colon<Nothing$> mapList_tail = mapList_head = new $colon$colon<Nothing$>((Nothing$)((Object)((Symbols.Symbol)mapList_as.head()).tpe()), Nil$.MODULE$);
            for (List mapList_rest = (List)mapList_as.tail(); mapList_rest != Nil$.MODULE$; mapList_rest = (List)mapList_rest.tail()) {
                $colon$colon<Nothing$> mapList_next = new $colon$colon<Nothing$>((Nothing$)((Object)((Symbols.Symbol)mapList_rest.head()).tpe()), Nil$.MODULE$);
                mapList_tail.tl_$eq(mapList_next);
                mapList_tail = mapList_next;
            }
            return var2_2;
        }

        @Override
        public Set<Symbols.Symbol> boundSyms() {
            return (Set)this.resultType().boundSyms().$plus$plus(this.params());
        }

        @Override
        public Type resultType(List<Type> actuals) {
            if (this.isTrivial() || this.scala$reflect$internal$Types$MethodType$$$outer().phase().erasedTypes()) {
                return this.resultType();
            }
            if (this.scala$reflect$internal$Types$MethodType$$$outer().sameLength(actuals, this.params())) {
                TypeMaps.InstantiateDependentMap idm = new TypeMaps.InstantiateDependentMap(this.scala$reflect$internal$Types$MethodType$$$outer(), this.params(), actuals);
                Type res = idm.apply(this.resultType());
                return this.scala$reflect$internal$Types$MethodType$$$outer().existentialAbstraction(idm.existentialsNeeded(), res);
            }
            return this.scala$reflect$internal$Types$MethodType$$$outer().existentialAbstraction(this.params(), this.resultType());
        }

        private byte isdepmeth() {
            return this.isdepmeth;
        }

        private void isdepmeth_$eq(byte x$1) {
            this.isdepmeth = x$1;
        }

        @Override
        public boolean isDependentMethodType() {
            if (this.isdepmeth() == 0) {
                this.isdepmeth_$eq(ThreeValues$.MODULE$.fromBoolean(BoxesRunTime.unboxToBoolean(this.scala$reflect$internal$Types$MethodType$$$outer().IsDependentCollector().collect(this.resultType().dealias()))));
            }
            return ThreeValues$.MODULE$.toBoolean(this.isdepmeth());
        }

        public MethodType approximate() {
            return new MethodType(this.scala$reflect$internal$Types$MethodType$$$outer(), this.params(), this.resultApprox());
        }

        @Override
        public String safeToString() {
            return new StringBuilder(0).append(this.scala$reflect$internal$Types$MethodType$$$outer().paramString(this)).append(this.resultType()).toString();
        }

        @Override
        public Type cloneInfo(Symbols.Symbol owner) {
            List<Symbols.Symbol> vparams = this.scala$reflect$internal$Types$MethodType$$$outer().cloneSymbolsAtOwner(this.params(), owner);
            return this.scala$reflect$internal$Types$MethodType$$$outer().copyMethodType(this, vparams, this.resultType().substSym(this.params(), vparams).cloneInfo(owner));
        }

        @Override
        public Type atOwner(Symbols.Symbol owner) {
            if (!this.scala$reflect$internal$Types$MethodType$$$outer().allSymbolsHaveOwner(this.params(), owner) || this.resultType().atOwner(owner) != this.resultType()) {
                return this.cloneInfo(owner);
            }
            return this;
        }

        @Override
        public String kind() {
            return "MethodType";
        }

        public MethodType copy(List<Symbols.Symbol> params, Type resultType) {
            return new MethodType(this.scala$reflect$internal$Types$MethodType$$$outer(), params, resultType);
        }

        public List<Symbols.Symbol> copy$default$1() {
            return this.params();
        }

        public Type copy$default$2() {
            return this.resultType();
        }

        @Override
        public String productPrefix() {
            return "MethodType";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.params();
                }
                case 1: {
                    return this.resultType();
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
            return x$1 instanceof MethodType;
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
            if (!(x$1 instanceof MethodType)) return false;
            if (((MethodType)x$1).scala$reflect$internal$Types$MethodType$$$outer() != this.scala$reflect$internal$Types$MethodType$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            MethodType methodType = (MethodType)x$1;
            List<Symbols.Symbol> list = this.params();
            List<Symbols.Symbol> list2 = methodType.params();
            if (list == null) {
                if (list2 != null) {
                    return false;
                }
            } else if (!((Object)list).equals(list2)) return false;
            Type type = this.resultType();
            Type type2 = methodType.resultType();
            if (type == null) {
                if (type2 != null) {
                    return false;
                }
            } else if (!type.equals(type2)) return false;
            if (!methodType.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$MethodType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        /*
         * WARNING - void declaration
         */
        private final boolean forallIsTrivial$1(int len$1, Type[] paramsTpes$1) {
            void var3_3;
            boolean res = true;
            List pps = this.params();
            for (int ix = 0; res && ix < len$1; ++ix) {
                paramsTpes$1[ix] = pps.head().tpe();
                res = paramsTpes$1[ix].isTrivial();
                pps = (List)pps.tail();
            }
            return (boolean)var3_3;
        }

        private static final boolean typeContains$1(TypeMaps.ContainsCollector pcc, Type tp) {
            pcc.result_$eq(BoxesRunTime.boxToBoolean(false));
            return BoxesRunTime.unboxToBoolean(pcc.collect(tp));
        }

        /*
         * WARNING - void declaration
         */
        private static final boolean anyTypeContains$1(TypeMaps.ContainsCollector pcc, int len$1, Type[] paramsTpes$1) {
            void var3_3;
            boolean existsContains = false;
            for (int tpeIx = 0; tpeIx < len$1 && !existsContains; ++tpeIx) {
                existsContains = MethodType.typeContains$1(pcc, paramsTpes$1[tpeIx]);
            }
            return (boolean)var3_3;
        }

        private final boolean forallParamsNoTypeContains$1(List params, int len$1, Type[] paramsTpes$1) {
            boolean bl;
            block2: {
                block3: {
                    while (true) {
                        if (((Object)Nil$.MODULE$).equals(params)) {
                            bl = true;
                            break block2;
                        }
                        if (!(params instanceof $colon$colon)) break block3;
                        $colon$colon $colon$colon = ($colon$colon)params;
                        Symbols.Symbol pp = (Symbols.Symbol)$colon$colon.head();
                        List pps = $colon$colon.tl$access$1();
                        TypeMaps.ContainsCollector pcc = new TypeMaps.ContainsCollector(this.scala$reflect$internal$Types$MethodType$$$outer(), pp);
                        if (MethodType.typeContains$1(pcc, this.resultType()) || MethodType.anyTypeContains$1(pcc, len$1, paramsTpes$1)) break;
                        params = pps;
                    }
                    bl = false;
                    break block2;
                }
                throw new MatchError(params);
            }
            return bl;
        }

        public MethodType(SymbolTable $outer, List<Symbols.Symbol> params, Type resultType) {
            this.params = params;
            this.resultType = resultType;
            super($outer);
            Product.$init$(this);
            this.trivial = 0;
            this.isdepmeth = 0;
        }
    }

    public static class MissingAliasControl
    extends Throwable
    implements ControlThrowable {
        public final /* synthetic */ SymbolTable $outer;

        @Override
        public /* synthetic */ Throwable scala$util$control$NoStackTrace$$super$fillInStackTrace() {
            return super.fillInStackTrace();
        }

        @Override
        public Throwable fillInStackTrace() {
            return NoStackTrace.fillInStackTrace$(this);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$MissingAliasControl$$$outer() {
            return this.$outer;
        }

        public MissingAliasControl(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            NoStackTrace.$init$(this);
        }
    }

    public static class MissingTypeControl
    extends Throwable
    implements ControlThrowable {
        public final /* synthetic */ SymbolTable $outer;

        @Override
        public /* synthetic */ Throwable scala$util$control$NoStackTrace$$super$fillInStackTrace() {
            return super.fillInStackTrace();
        }

        @Override
        public Throwable fillInStackTrace() {
            return NoStackTrace.fillInStackTrace$(this);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$MissingTypeControl$$$outer() {
            return this.$outer;
        }

        public MissingTypeControl(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            NoStackTrace.$init$(this);
        }
    }

    public class ModuleTypeRef
    extends NoArgsTypeRef {
        private Type narrowedCache;

        @Override
        public Type narrow() {
            if (this.narrowedCache == null) {
                this.narrowedCache = this.scala$reflect$internal$Types$ModuleTypeRef$$$outer().singleType(this.pre(), this.sym().sourceModule());
            }
            return this.narrowedCache;
        }

        @Override
        public void scala$reflect$internal$Types$$invalidateTypeRefCaches() {
            super.scala$reflect$internal$Types$$invalidateTypeRefCaches();
            this.narrowedCache = null;
        }

        @Override
        public void forceDirectSuperclasses() {
            super.sym().rawInfo().decls().foreach((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)(Symbols.Symbol decl) -> {
                ModuleTypeRef.$anonfun$forceDirectSuperclasses$1(decl);
                return BoxedUnit.UNIT;
            });
        }

        @Override
        public String finishPrefix(String rest) {
            return new StringBuilder(0).append(this.objectPrefix()).append(rest).toString();
        }

        @Override
        public String directObjectString() {
            return super.safeToString();
        }

        @Override
        public String toLongString() {
            return this.toString();
        }

        @Override
        public String safeToString() {
            return new StringBuilder(4).append(this.prefixString()).append("type").toString();
        }

        @Override
        public String prefixString() {
            if (this.sym().isOmittablePrefix()) {
                return "";
            }
            return new StringBuilder(1).append(this.prefix().prefixString()).append(this.sym().nameString()).append(".").toString();
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$ModuleTypeRef$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public static final /* synthetic */ void $anonfun$forceDirectSuperclasses$1(Symbols.Symbol decl) {
            if (decl.isModule() || !decl.isTerm()) {
                decl.rawInfo().forceDirectSuperclasses();
            }
        }

        /*
         * WARNING - void declaration
         */
        public ModuleTypeRef(SymbolTable $outer, Type pre0, Symbols.Symbol sym0) {
            super($outer, pre0, sym0);
            void require_requirement;
            boolean bl = this.sym().isModuleClass();
            if ($outer == null) {
                throw null;
            }
            if (require_requirement == false) {
                throw $outer.throwRequirementError(this.sym());
            }
        }
    }

    public class NamedType
    extends Type
    implements Product,
    Serializable {
        private final Names.Name name;
        private final Type tp;

        public Names.Name name() {
            return this.name;
        }

        public Type tp() {
            return this.tp;
        }

        @Override
        public String safeToString() {
            return new StringBuilder(2).append(this.name().toString()).append(": ").append(this.tp()).toString();
        }

        public NamedType copy(Names.Name name, Type tp) {
            return new NamedType(this.scala$reflect$internal$Types$NamedType$$$outer(), name, tp);
        }

        public Names.Name copy$default$1() {
            return this.name();
        }

        public Type copy$default$2() {
            return this.tp();
        }

        @Override
        public String productPrefix() {
            return "NamedType";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.name();
                }
                case 1: {
                    return this.tp();
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
            return x$1 instanceof NamedType;
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
            if (!(x$1 instanceof NamedType)) return false;
            if (((NamedType)x$1).scala$reflect$internal$Types$NamedType$$$outer() != this.scala$reflect$internal$Types$NamedType$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            NamedType namedType = (NamedType)x$1;
            Names.Name name = this.name();
            Names.Name name2 = namedType.name();
            if (name == null) {
                if (name2 != null) {
                    return false;
                }
            } else if (!name.equals(name2)) return false;
            Type type = this.tp();
            Type type2 = namedType.tp();
            if (type == null) {
                if (type2 != null) {
                    return false;
                }
            } else if (!type.equals(type2)) return false;
            if (!namedType.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$NamedType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public NamedType(SymbolTable $outer, Names.Name name, Type tp) {
            this.name = name;
            this.tp = tp;
            super($outer);
            Product.$init$(this);
        }
    }

    public class NoArgsTypeRef
    extends TypeRef {
        @Override
        public boolean isHigherKinded() {
            return this.typeParams() != Nil$.MODULE$;
        }

        @Override
        public List<Symbols.Symbol> typeParams() {
            if (this.scala$reflect$internal$Types$NoArgsTypeRef$$$outer().definitions().isDefinitionsInitialized()) {
                return this.sym().typeParams();
            }
            return this.sym().unsafeTypeParams();
        }

        @Override
        public Type instantiateTypeParams(List<Symbols.Symbol> formals, List<Type> actuals) {
            if (this.isHigherKinded()) {
                boolean bl;
                block5: {
                    List<Symbols.Symbol> list = this.typeParams();
                    if (list == null) {
                        throw null;
                    }
                    LinearSeqOptimized forall_these = list;
                    while (!forall_these.isEmpty()) {
                        Object a = forall_these.head();
                        if (!formals.contains(a)) {
                            bl = false;
                            break block5;
                        }
                        forall_these = (LinearSeqOptimized)forall_these.tail();
                    }
                    bl = true;
                }
                if (bl) {
                    return this.scala$reflect$internal$Types$NoArgsTypeRef$$$outer().copyTypeRef(this, this.pre(), this.sym(), actuals);
                }
                return this.scala$reflect$internal$Types$NoArgsTypeRef$$$outer().copyTypeRef(this, this.pre(), this.sym(), this.dummyArgs()).instantiateTypeParams(formals, actuals);
            }
            return super.instantiateTypeParams(formals, actuals);
        }

        @Override
        public Type narrow() {
            if (this.sym().isModuleClass()) {
                return this.scala$reflect$internal$Types$NoArgsTypeRef$$$outer().singleType(this.pre(), this.sym().sourceModule());
            }
            return super.narrow();
        }

        @Override
        public NoArgsTypeRef typeConstructor() {
            return this;
        }

        @Override
        public Type normalizeImpl() {
            if (this.isHigherKinded()) {
                return this.etaExpand();
            }
            return super.normalizeImpl();
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$NoArgsTypeRef$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public NoArgsTypeRef(SymbolTable $outer, Type pre0, Symbols.Symbol sym0) {
            super($outer, pre0, sym0, Nil$.MODULE$);
        }

        public static final /* synthetic */ Object $anonfun$instantiateTypeParams$1$adapted(List formals$1, Object elem) {
            return BoxesRunTime.boxToBoolean(formals$1.contains(elem));
        }
    }

    public static class NoCommonType
    extends Throwable
    implements ControlThrowable {
        public final /* synthetic */ SymbolTable $outer;

        @Override
        public /* synthetic */ Throwable scala$util$control$NoStackTrace$$super$fillInStackTrace() {
            return super.fillInStackTrace();
        }

        @Override
        public Throwable fillInStackTrace() {
            return NoStackTrace.fillInStackTrace$(this);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$NoCommonType$$$outer() {
            return this.$outer;
        }

        public NoCommonType(SymbolTable $outer, List<Type> tps) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            super(new StringBuilder(31).append("lub/glb of incompatible types: ").append(tps.mkString("", " and ", "")).toString());
            NoStackTrace.$init$(this);
        }
    }

    public interface NonClassTypeRef {
        public /* synthetic */ void scala$reflect$internal$Types$NonClassTypeRef$$super$invalidateTypeRefCaches();

        public /* synthetic */ Type scala$reflect$internal$Types$NonClassTypeRef$$super$relativeInfo();

        public Type scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache();

        public void scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache_$eq(Type var1);

        public int scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod();

        public void scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod_$eq(int var1);

        public Type scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo();

        public void scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo_$eq(Type var1);

        default public void scala$reflect$internal$Types$$invalidateTypeRefCaches() {
            this.scala$reflect$internal$Types$NonClassTypeRef$$super$invalidateTypeRefCaches();
            this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache_$eq(this.scala$reflect$internal$Types$NonClassTypeRef$$$outer().NoType());
            this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod_$eq(0);
            this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo_$eq(null);
        }

        default public Type relativeInfo() {
            Type symInfo = ((TypeRef)((Object)this)).sym().info();
            if (this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache() == null || this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo() != symInfo || this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod() != ((SymbolTable)this.scala$reflect$internal$Types$NonClassTypeRef$$$outer()).currentPeriod()) {
                this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache_$eq(this.scala$reflect$internal$Types$NonClassTypeRef$$super$relativeInfo());
                if (this instanceof AbstractTypeRef) {
                    this.validateRelativeInfo();
                }
                this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForSymInfo_$eq(symInfo);
                this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod_$eq(((SymbolTable)this.scala$reflect$internal$Types$NonClassTypeRef$$$outer()).currentPeriod());
            }
            return this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache();
        }

        private void validateRelativeInfo() {
            Type type = this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache();
            if (type instanceof SubType && ((SubType)type).supertype() == this) {
                this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCache_$eq(null);
                throw new RecoverableCyclicReference((SymbolTable)this.scala$reflect$internal$Types$NonClassTypeRef$$$outer(), ((TypeRef)((Object)this)).sym());
            }
        }

        public /* synthetic */ Types scala$reflect$internal$Types$NonClassTypeRef$$$outer();

        public static /* synthetic */ Symbols.Symbol $anonfun$$init$$1(NonClassTypeRef $this) {
            return ((TypeRef)((Object)$this)).sym();
        }

        /*
         * WARNING - void declaration
         */
        public static void $init$(NonClassTypeRef $this) {
            void require_requirement;
            SymbolTable symbolTable = (SymbolTable)$this.scala$reflect$internal$Types$NonClassTypeRef$$$outer();
            boolean bl = ((TypeRef)((Object)$this)).sym().isNonClassType();
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable require_this = symbolTable;
            if (require_requirement == false) {
                throw require_this.throwRequirementError(NonClassTypeRef.$anonfun$$init$$1($this));
            }
            $this.scala$reflect$internal$Types$NonClassTypeRef$$relativeInfoCacheValidForPeriod_$eq(0);
        }
    }

    public class NullaryMethodType
    extends Type
    implements Types.NullaryMethodTypeApi,
    Product,
    Serializable {
        private final Type resultType;

        @Override
        public Type resultType() {
            return this.resultType;
        }

        @Override
        public boolean isTrivial() {
            return this.resultType().isTrivial() && this.resultType() == this.resultType().withoutAnnotations();
        }

        @Override
        public Type prefix() {
            return this.resultType().prefix();
        }

        @Override
        public Type narrow() {
            return this.resultType().narrow();
        }

        @Override
        public Symbols.Symbol termSymbol() {
            return this.resultType().termSymbol();
        }

        @Override
        public Symbols.Symbol typeSymbol() {
            return this.resultType().typeSymbol();
        }

        @Override
        public List<Type> parents() {
            return this.resultType().parents();
        }

        @Override
        public Scopes.Scope decls() {
            return this.resultType().decls();
        }

        @Override
        public BaseTypeSeqs.BaseTypeSeq baseTypeSeq() {
            return this.resultType().baseTypeSeq();
        }

        @Override
        public int baseTypeSeqDepth() {
            return this.resultType().baseTypeSeqDepth();
        }

        @Override
        public List<Symbols.Symbol> baseClasses() {
            return this.resultType().baseClasses();
        }

        @Override
        public Type baseType(Symbols.Symbol clazz) {
            return this.resultType().baseType(clazz);
        }

        @Override
        public Set<Symbols.Symbol> boundSyms() {
            return this.resultType().boundSyms();
        }

        @Override
        public String safeToString() {
            return new StringBuilder(3).append("=> ").append(this.resultType()).toString();
        }

        @Override
        public String kind() {
            return "NullaryMethodType";
        }

        public NullaryMethodType copy(Type resultType) {
            return new NullaryMethodType(this.scala$reflect$internal$Types$NullaryMethodType$$$outer(), resultType);
        }

        public Type copy$default$1() {
            return this.resultType();
        }

        @Override
        public String productPrefix() {
            return "NullaryMethodType";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.resultType();
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
            return x$1 instanceof NullaryMethodType;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof NullaryMethodType && ((NullaryMethodType)x$1).scala$reflect$internal$Types$NullaryMethodType$$$outer() == this.scala$reflect$internal$Types$NullaryMethodType$$$outer();
                    if (!bl) break block3;
                    NullaryMethodType nullaryMethodType = (NullaryMethodType)x$1;
                    Type type = this.resultType();
                    Type type2 = nullaryMethodType.resultType();
                    if (!(!(type != null ? !type.equals(type2) : type2 != null) && nullaryMethodType.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$NullaryMethodType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public NullaryMethodType(SymbolTable $outer, Type resultType) {
            this.resultType = resultType;
            super($outer);
            Product.$init$(this);
        }
    }

    public class OverloadedType
    extends Type
    implements Product,
    Serializable {
        private final Type pre;
        private final List<Symbols.Symbol> alternatives;

        public Type pre() {
            return this.pre;
        }

        public List<Symbols.Symbol> alternatives() {
            return this.alternatives;
        }

        @Override
        public Type prefix() {
            return this.pre();
        }

        @Override
        public String safeToString() {
            return ((TraversableOnce)this.alternatives().map((Function1<Symbols.Symbol, Type> & java.io.Serializable & Serializable)sym -> this.pre().memberType((Symbols.Symbol)sym), List$.MODULE$.canBuildFrom())).mkString("", " <and> ", "");
        }

        @Override
        public String kind() {
            return "OverloadedType";
        }

        public OverloadedType copy(Type pre, List<Symbols.Symbol> alternatives) {
            return new OverloadedType(this.scala$reflect$internal$Types$OverloadedType$$$outer(), pre, alternatives);
        }

        public Type copy$default$1() {
            return this.pre();
        }

        public List<Symbols.Symbol> copy$default$2() {
            return this.alternatives();
        }

        @Override
        public String productPrefix() {
            return "OverloadedType";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.pre();
                }
                case 1: {
                    return this.alternatives();
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
            return x$1 instanceof OverloadedType;
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
            if (!(x$1 instanceof OverloadedType)) return false;
            if (((OverloadedType)x$1).scala$reflect$internal$Types$OverloadedType$$$outer() != this.scala$reflect$internal$Types$OverloadedType$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            OverloadedType overloadedType = (OverloadedType)x$1;
            Type type = this.pre();
            Type type2 = overloadedType.pre();
            if (type == null) {
                if (type2 != null) {
                    return false;
                }
            } else if (!type.equals(type2)) return false;
            List<Symbols.Symbol> list = this.alternatives();
            List<Symbols.Symbol> list2 = overloadedType.alternatives();
            if (list == null) {
                if (list2 != null) {
                    return false;
                }
            } else if (!((Object)list).equals(list2)) return false;
            if (!overloadedType.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$OverloadedType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public OverloadedType(SymbolTable $outer, Type pre, List<Symbols.Symbol> alternatives) {
            this.pre = pre;
            this.alternatives = alternatives;
            super($outer);
            Product.$init$(this);
        }
    }

    public class PackageClassInfoType
    extends ClassInfoType {
        public /* synthetic */ SymbolTable scala$reflect$internal$Types$PackageClassInfoType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public PackageClassInfoType(SymbolTable $outer, Scopes.Scope decls, Symbols.Symbol clazz) {
            super($outer, Nil$.MODULE$, decls, clazz);
        }
    }

    public class PackageTypeRef
    extends ModuleTypeRef {
        @Override
        public String finishPrefix(String rest) {
            return new StringBuilder(0).append(this.packagePrefix()).append(rest).toString();
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$PackageTypeRef$$$outer() {
            return (SymbolTable)this.$outer;
        }

        /*
         * WARNING - void declaration
         */
        public PackageTypeRef(SymbolTable $outer, Type pre0, Symbols.Symbol sym0) {
            super($outer, pre0, sym0);
            void require_requirement;
            boolean bl = this.sym().isPackageClass();
            if ($outer == null) {
                throw null;
            }
            if (require_requirement == false) {
                throw $outer.throwRequirementError(this.sym());
            }
        }
    }

    public class PolyType
    extends Type
    implements Types.PolyTypeApi,
    Product,
    Serializable {
        private final List<Symbols.Symbol> typeParams;
        private final Type resultType;

        @Override
        public List<Symbols.Symbol> typeParams() {
            return this.typeParams;
        }

        @Override
        public Type resultType() {
            return this.resultType;
        }

        @Override
        public int paramSectionCount() {
            return this.resultType().paramSectionCount();
        }

        @Override
        public List<List<Symbols.Symbol>> paramss() {
            return this.resultType().paramss();
        }

        @Override
        public List<Symbols.Symbol> params() {
            return this.resultType().params();
        }

        @Override
        public List<Type> paramTypes() {
            return this.resultType().paramTypes();
        }

        @Override
        public List<Type> parents() {
            return this.resultType().parents();
        }

        @Override
        public Scopes.Scope decls() {
            return this.resultType().decls();
        }

        @Override
        public Symbols.Symbol termSymbol() {
            return this.resultType().termSymbol();
        }

        @Override
        public Symbols.Symbol typeSymbol() {
            return this.resultType().typeSymbol();
        }

        @Override
        public Set<Symbols.Symbol> boundSyms() {
            return (Set)Set$.MODULE$.apply(this.typeParams().$plus$plus(this.resultType().boundSyms(), List$.MODULE$.canBuildFrom()));
        }

        @Override
        public Type prefix() {
            return this.resultType().prefix();
        }

        @Override
        public BaseTypeSeqs.BaseTypeSeq baseTypeSeq() {
            return this.resultType().baseTypeSeq();
        }

        @Override
        public int baseTypeSeqDepth() {
            return this.resultType().baseTypeSeqDepth();
        }

        @Override
        public List<Symbols.Symbol> baseClasses() {
            return this.resultType().baseClasses();
        }

        @Override
        public Type baseType(Symbols.Symbol clazz) {
            return this.resultType().baseType(clazz);
        }

        @Override
        public Type narrow() {
            return this.resultType().narrow();
        }

        @Override
        public boolean isDependentMethodType() {
            return this.resultType().isDependentMethodType();
        }

        @Override
        public Type lowerBound() {
            return this.scala$reflect$internal$Types$PolyType$$$outer().typeFun(this.typeParams(), this.resultType().lowerBound());
        }

        @Override
        public Type upperBound() {
            return this.scala$reflect$internal$Types$PolyType$$$outer().typeFun(this.typeParams(), this.resultType().upperBound());
        }

        @Override
        public boolean isHigherKinded() {
            return !this.typeParams().isEmpty();
        }

        @Override
        public String safeToString() {
            return new StringBuilder(0).append(this.scala$reflect$internal$Types$PolyType$$$outer().typeParamsString(this)).append(this.resultType()).toString();
        }

        @Override
        public PolyType cloneInfo(Symbols.Symbol owner) {
            List<Symbols.Symbol> tparams = this.scala$reflect$internal$Types$PolyType$$$outer().cloneSymbolsAtOwner(this.typeParams(), owner);
            return new PolyType(this.scala$reflect$internal$Types$PolyType$$$outer(), tparams, this.resultType().substSym(this.typeParams(), tparams).cloneInfo(owner));
        }

        @Override
        public Type atOwner(Symbols.Symbol owner) {
            if (!this.scala$reflect$internal$Types$PolyType$$$outer().allSymbolsHaveOwner(this.typeParams(), owner) || this.resultType().atOwner(owner) != this.resultType()) {
                return this.cloneInfo(owner);
            }
            return this;
        }

        @Override
        public String kind() {
            return "PolyType";
        }

        public PolyType copy(List<Symbols.Symbol> typeParams, Type resultType) {
            return new PolyType(this.scala$reflect$internal$Types$PolyType$$$outer(), typeParams, resultType);
        }

        public List<Symbols.Symbol> copy$default$1() {
            return this.typeParams();
        }

        public Type copy$default$2() {
            return this.resultType();
        }

        @Override
        public String productPrefix() {
            return "PolyType";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.typeParams();
                }
                case 1: {
                    return this.resultType();
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
            return x$1 instanceof PolyType;
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
            if (!(x$1 instanceof PolyType)) return false;
            if (((PolyType)x$1).scala$reflect$internal$Types$PolyType$$$outer() != this.scala$reflect$internal$Types$PolyType$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            PolyType polyType = (PolyType)x$1;
            List<Symbols.Symbol> list = this.typeParams();
            List<Symbols.Symbol> list2 = polyType.typeParams();
            if (list == null) {
                if (list2 != null) {
                    return false;
                }
            } else if (!((Object)list).equals(list2)) return false;
            Type type = this.resultType();
            Type type2 = polyType.resultType();
            if (type == null) {
                if (type2 != null) {
                    return false;
                }
            } else if (!type.equals(type2)) return false;
            if (!polyType.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$PolyType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        /*
         * WARNING - void declaration
         */
        public PolyType(SymbolTable $outer, List<Symbols.Symbol> typeParams, Type resultType) {
            void assert_assertion;
            this.typeParams = typeParams;
            this.resultType = resultType;
            super($outer);
            Product.$init$(this);
            boolean bl = typeParams.nonEmpty();
            if ($outer == null) {
                throw null;
            }
            if (assert_assertion == false) {
                throw $outer.throwAssertionError(this);
            }
        }
    }

    public class RecoverableCyclicReference
    extends TypeError
    implements Product,
    Serializable {
        private final Symbols.Symbol sym;

        public Symbols.Symbol sym() {
            return this.sym;
        }

        public RecoverableCyclicReference copy(Symbols.Symbol sym) {
            return new RecoverableCyclicReference(this.scala$reflect$internal$Types$RecoverableCyclicReference$$$outer(), sym);
        }

        public Symbols.Symbol copy$default$1() {
            return this.sym();
        }

        @Override
        public String productPrefix() {
            return "RecoverableCyclicReference";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.sym();
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
            return x$1 instanceof RecoverableCyclicReference;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof RecoverableCyclicReference && ((RecoverableCyclicReference)x$1).scala$reflect$internal$Types$RecoverableCyclicReference$$$outer() == this.scala$reflect$internal$Types$RecoverableCyclicReference$$$outer();
                    if (!bl) break block3;
                    RecoverableCyclicReference recoverableCyclicReference = (RecoverableCyclicReference)x$1;
                    Symbols.Symbol symbol = this.sym();
                    Symbols.Symbol symbol2 = recoverableCyclicReference.sym();
                    if (!(!(symbol != null ? !symbol.equals(symbol2) : symbol2 != null) && recoverableCyclicReference.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$RecoverableCyclicReference$$$outer() {
            return this.$outer;
        }

        /*
         * WARNING - void declaration
         */
        public RecoverableCyclicReference(SymbolTable $outer, Symbols.Symbol sym) {
            void reflectSettingToBoolean_s;
            this.sym = sym;
            super($outer, new StringBuilder(35).append("illegal cyclic reference involving ").append(sym).toString());
            Product.$init$(this);
            MutableSettings.SettingValue settingValue = $outer.settings().debug();
            if (MutableSettings$.MODULE$ == null) {
                throw null;
            }
            if (BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value())) {
                this.printStackTrace();
            }
        }
    }

    public class RefinedType
    extends CompoundType
    implements Types.RefinedTypeApi,
    Product,
    Serializable {
        private final List<Type> parents;
        private final Scopes.Scope decls;
        private Type normalized;

        @Override
        public List<Type> parents() {
            return this.parents;
        }

        @Override
        public Scopes.Scope decls() {
            return this.decls;
        }

        @Override
        public boolean isHigherKinded() {
            if (this.parents().nonEmpty()) {
                boolean bl;
                block5: {
                    List<Type> list = this.parents();
                    if (list == null) {
                        throw null;
                    }
                    LinearSeqOptimized forall_these = list;
                    while (!forall_these.isEmpty()) {
                        if (!((Type)forall_these.head()).isHigherKinded()) {
                            bl = false;
                            break block5;
                        }
                        forall_these = (LinearSeqOptimized)forall_these.tail();
                    }
                    bl = true;
                }
                if (bl && !this.scala$reflect$internal$Types$RefinedType$$$outer().phase().erasedTypes()) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public List<Symbols.Symbol> typeParams() {
            if (this.isHigherKinded()) {
                return this.firstParent().typeParams();
            }
            return super.typeParams();
        }

        @Override
        public Type typeConstructor() {
            return this.scala$reflect$internal$Types$RefinedType$$$outer().copyRefinedType(this, this.parents().map((Function1<Type, Type> & java.io.Serializable & Serializable)x$24 -> x$24.typeConstructor(), List$.MODULE$.canBuildFrom()), this.decls());
        }

        @Override
        public final Type normalize() {
            if (this.scala$reflect$internal$Types$RefinedType$$$outer().phase().erasedTypes()) {
                return this.normalizeImpl();
            }
            if (this.normalized() == null) {
                this.normalized_$eq(this.normalizeImpl());
            }
            return this.normalized();
        }

        private Type normalized() {
            return this.normalized;
        }

        private void normalized_$eq(Type x$1) {
            this.normalized = x$1;
        }

        private Type normalizeImpl() {
            GenTraversable flattened = LinkedHashSet$.MODULE$.empty();
            List list = this.parents();
            if (list == null) {
                throw null;
            }
            List foreach_these = list;
            while (!foreach_these.isEmpty()) {
                Type type = foreach_these.head();
                RefinedType.loop$1(type, (LinkedHashSet)flattened);
                foreach_these = (List)foreach_these.tail();
            }
            if (this.decls().isEmpty() && ((LinkedHashSet)flattened).size() == 1) {
                return (Type)((AbstractIterable)flattened).head();
            }
            if (!((AbstractIterable)flattened).sameElements(this.parents())) {
                return this.scala$reflect$internal$Types$RefinedType$$$outer().refinedType(((AbstractTraversable)flattened).toList(), this.typeSymbol() == this.scala$reflect$internal$Types$RefinedType$$$outer().NoSymbol() ? this.scala$reflect$internal$Types$RefinedType$$$outer().NoSymbol() : this.typeSymbol().owner(), this.decls(), this.scala$reflect$internal$Types$RefinedType$$$outer().NoPosition());
            }
            if (this.isHigherKinded()) {
                return this.etaExpand();
            }
            return super.normalize();
        }

        @Override
        public final Type etaExpand() {
            if (!this.isHigherKinded()) {
                return this;
            }
            return this.scala$reflect$internal$Types$RefinedType$$$outer().typeFun(this.typeParams(), this.scala$reflect$internal$Types$RefinedType$$$outer().RefinedType().apply(this.parents().map((Function1<Type, Type> & java.io.Serializable & Serializable)x0$1 -> {
                if (!(x0$1 instanceof TypeRef)) return x0$1;
                TypeRef typeRef = (TypeRef)x0$1;
                Type pre = typeRef.pre();
                Symbols.Symbol sym = typeRef.sym();
                List<Type> list = typeRef.args();
                Some<List<Type>> some = List$.MODULE$.unapplySeq(list);
                if (some.isEmpty()) return x0$1;
                if (some.get() == null) return x0$1;
                if (((LinearSeqOptimized)some.get()).lengthCompare(0) != 0) return x0$1;
                return this.scala$reflect$internal$Types$RefinedType$$$outer().TypeRef().apply(pre, sym, this.dummyArgs());
            }, List$.MODULE$.canBuildFrom()), this.decls(), this.typeSymbol()));
        }

        @Override
        public String kind() {
            return "RefinedType";
        }

        public RefinedType copy(List<Type> parents, Scopes.Scope decls) {
            return new RefinedType(this.scala$reflect$internal$Types$RefinedType$$$outer(), parents, decls);
        }

        public List<Type> copy$default$1() {
            return this.parents();
        }

        public Scopes.Scope copy$default$2() {
            return this.decls();
        }

        @Override
        public String productPrefix() {
            return "RefinedType";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.parents();
                }
                case 1: {
                    return this.decls();
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
            return x$1 instanceof RefinedType;
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
            if (!(x$1 instanceof RefinedType)) return false;
            if (((RefinedType)x$1).scala$reflect$internal$Types$RefinedType$$$outer() != this.scala$reflect$internal$Types$RefinedType$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            RefinedType refinedType = (RefinedType)x$1;
            List<Type> list = this.parents();
            List<Type> list2 = refinedType.parents();
            if (list == null) {
                if (list2 != null) {
                    return false;
                }
            } else if (!((Object)list).equals(list2)) return false;
            Scopes.Scope scope = this.decls();
            Scopes.Scope scope2 = refinedType.decls();
            if (scope == null) {
                if (scope2 != null) {
                    return false;
                }
            } else if (!scope.equals(scope2)) return false;
            if (!refinedType.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$RefinedType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        private static final Type dealiasRefinement$1(Type tp) {
            if (tp.dealias() instanceof RefinedType) {
                return tp.dealias();
            }
            return tp;
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        private static final void loop$1(Type tp, LinkedHashSet flattened$1) {
            Type type = RefinedType.dealiasRefinement$1(tp);
            if (type instanceof RefinedType) {
                RefinedType refinedType = (RefinedType)type;
                List parents = refinedType.parents();
                if (refinedType.decls().isEmpty()) {
                    if (parents == null) {
                        throw null;
                    }
                    List foreach_these = parents;
                    while (!foreach_these.isEmpty()) {
                        Type type2 = foreach_these.head();
                        RefinedType.loop$1(type2, flattened$1);
                        foreach_these = (List)foreach_these.tail();
                    }
                    return;
                }
            }
            flattened$1.add(type);
        }

        public RefinedType(SymbolTable $outer, List<Type> parents, Scopes.Scope decls) {
            this.parents = parents;
            this.decls = decls;
            super($outer);
            Product.$init$(this);
        }

        public static final /* synthetic */ Object $anonfun$isHigherKinded$1$adapted(Type x$23) {
            return BoxesRunTime.boxToBoolean(x$23.isHigherKinded());
        }

        public static final /* synthetic */ Object $anonfun$normalizeImpl$2$adapted(LinkedHashSet flattened$1, Type tp) {
            RefinedType.loop$1(tp, flattened$1);
            return BoxedUnit.UNIT;
        }

        public static final /* synthetic */ Object $anonfun$normalizeImpl$1$adapted(LinkedHashSet flattened$1, Type tp) {
            RefinedType.loop$1(tp, flattened$1);
            return BoxedUnit.UNIT;
        }
    }

    public final class RefinedType0
    extends RefinedType {
        private final Symbols.Symbol clazz;

        @Override
        public Symbols.Symbol typeSymbol() {
            return this.clazz;
        }

        public RefinedType0(SymbolTable $outer, List<Type> parents, Scopes.Scope decls, Symbols.Symbol clazz) {
            this.clazz = clazz;
            super($outer, parents, decls);
        }
    }

    public class RefinementTypeRef
    extends NoArgsTypeRef {
        @Override
        public Type normalizeImpl() {
            return this.pre().memberInfo(this.sym()).normalize();
        }

        @Override
        public String finishPrefix(String rest) {
            return String.valueOf(this.sym().info());
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$RefinementTypeRef$$$outer() {
            return (SymbolTable)this.$outer;
        }

        /*
         * WARNING - void declaration
         */
        public RefinementTypeRef(SymbolTable $outer, Type pre0, Symbols.Symbol sym0) {
            super($outer, pre0, sym0);
            void require_requirement;
            boolean bl = this.sym().isRefinementClass();
            if ($outer == null) {
                throw null;
            }
            if (require_requirement == false) {
                throw $outer.throwRequirementError(this.sym());
            }
        }
    }

    public class RepeatedType
    extends Type
    implements Product,
    Serializable {
        private final Type tp;

        public Type tp() {
            return this.tp;
        }

        @Override
        public String safeToString() {
            return Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(this.tp()), ": _*");
        }

        public RepeatedType copy(Type tp) {
            return new RepeatedType(this.scala$reflect$internal$Types$RepeatedType$$$outer(), tp);
        }

        public Type copy$default$1() {
            return this.tp();
        }

        @Override
        public String productPrefix() {
            return "RepeatedType";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.tp();
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
            return x$1 instanceof RepeatedType;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof RepeatedType && ((RepeatedType)x$1).scala$reflect$internal$Types$RepeatedType$$$outer() == this.scala$reflect$internal$Types$RepeatedType$$$outer();
                    if (!bl) break block3;
                    RepeatedType repeatedType = (RepeatedType)x$1;
                    Type type = this.tp();
                    Type type2 = repeatedType.tp();
                    if (!(!(type != null ? !type.equals(type2) : type2 != null) && repeatedType.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$RepeatedType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public RepeatedType(SymbolTable $outer, Type tp) {
            this.tp = tp;
            super($outer);
            Product.$init$(this);
        }
    }

    public interface RewrappingTypeProxy
    extends SimpleTypeProxy {
        default public Type maybeRewrap(Type newtp) {
            if (newtp == ((Type)((Object)this)).underlying()) {
                return (Type)((Object)this);
            }
            if (!(newtp.isWildcard() || newtp.isHigherKinded() || newtp instanceof RefinementTypeRef) && newtp.$eq$colon$eq(((Type)((Object)this)).underlying())) {
                return (Type)((Object)this);
            }
            return this.rewrap(newtp);
        }

        public Type rewrap(Type var1);

        @Override
        default public Type widen() {
            return this.maybeRewrap(((Type)((Object)this)).underlying().widen());
        }

        default public Type narrow() {
            return ((Type)((Object)this)).underlying().narrow();
        }

        default public Type deconst() {
            return this.maybeRewrap(((Type)((Object)this)).underlying().deconst());
        }

        default public Type resultType() {
            return this.maybeRewrap(((Type)((Object)this)).underlying().resultType());
        }

        default public Type resultType(List<Type> actuals) {
            return this.maybeRewrap(((Type)((Object)this)).underlying().resultType(actuals));
        }

        @Override
        default public int paramSectionCount() {
            return 0;
        }

        @Override
        default public List<List<Symbols.Symbol>> paramss() {
            return Nil$.MODULE$;
        }

        @Override
        default public List<Symbols.Symbol> params() {
            return Nil$.MODULE$;
        }

        @Override
        default public List<Type> paramTypes() {
            return Nil$.MODULE$;
        }

        default public List<Type> typeArgs() {
            return ((Type)((Object)this)).underlying().typeArgs();
        }

        public static /* synthetic */ Type instantiateTypeParams$(RewrappingTypeProxy $this, List formals, List actuals) {
            return $this.instantiateTypeParams(formals, actuals);
        }

        default public Type instantiateTypeParams(List<Symbols.Symbol> formals, List<Type> actuals) {
            return ((Type)((Object)this)).underlying().instantiateTypeParams(formals, actuals);
        }

        default public Type skolemizeExistential(Symbols.Symbol owner, Object origin) {
            return ((Type)((Object)this)).underlying().skolemizeExistential(owner, origin);
        }

        default public Type normalize() {
            return this.maybeRewrap(((Type)((Object)this)).underlying().normalize());
        }

        default public Type etaExpand() {
            return this.maybeRewrap(((Type)((Object)this)).underlying().etaExpand());
        }

        default public Type dealias() {
            return this.maybeRewrap(((Type)((Object)this)).underlying().dealias());
        }

        default public Type cloneInfo(Symbols.Symbol owner) {
            return this.maybeRewrap(((Type)((Object)this)).underlying().cloneInfo(owner));
        }

        default public Type atOwner(Symbols.Symbol owner) {
            return this.maybeRewrap(((Type)((Object)this)).underlying().atOwner(owner));
        }

        default public String prefixString() {
            return ((Type)((Object)this)).underlying().prefixString();
        }

        default public boolean isComplete() {
            return ((Type)((Object)this)).underlying().isComplete();
        }

        default public void complete(Symbols.Symbol sym) {
            ((Type)((Object)this)).underlying().complete(sym);
        }

        default public void load(Symbols.Symbol sym) {
            ((Type)((Object)this)).underlying().load(sym);
        }

        default public Type withAnnotations(List<AnnotationInfos.AnnotationInfo> annots) {
            return this.maybeRewrap((Type)((Type)((Object)this)).underlying().withAnnotations((List)annots));
        }

        default public Type withoutAnnotations() {
            return this.maybeRewrap(((Type)((Object)this)).underlying().withoutAnnotations());
        }

        public /* synthetic */ Types scala$reflect$internal$Types$RewrappingTypeProxy$$$outer();

        public static void $init$(RewrappingTypeProxy $this) {
        }
    }

    public interface SimpleTypeProxy {
        public Type underlying();

        public static /* synthetic */ boolean isTrivial$(SimpleTypeProxy $this) {
            return $this.isTrivial();
        }

        default public boolean isTrivial() {
            return ((Type)((Object)this)).underlying().isTrivial();
        }

        default public boolean isHigherKinded() {
            return ((Type)((Object)this)).underlying().isHigherKinded();
        }

        default public Type typeConstructor() {
            return ((Type)((Object)this)).underlying().typeConstructor();
        }

        default public boolean isError() {
            return ((Type)((Object)this)).underlying().isError();
        }

        default public boolean isErroneous() {
            return ((Type)((Object)this)).underlying().isErroneous();
        }

        default public int paramSectionCount() {
            return ((Type)((Object)this)).underlying().paramSectionCount();
        }

        default public List<List<Symbols.Symbol>> paramss() {
            return ((Type)((Object)this)).underlying().paramss();
        }

        default public List<Symbols.Symbol> params() {
            return ((Type)((Object)this)).underlying().params();
        }

        default public List<Type> paramTypes() {
            return ((Type)((Object)this)).underlying().paramTypes();
        }

        default public Symbols.Symbol termSymbol() {
            return ((Type)((Object)this)).underlying().termSymbol();
        }

        default public Symbols.Symbol termSymbolDirect() {
            return ((Type)((Object)this)).underlying().termSymbolDirect();
        }

        default public List<Symbols.Symbol> typeParams() {
            return ((Type)((Object)this)).underlying().typeParams();
        }

        default public Set<Symbols.Symbol> boundSyms() {
            return ((Type)((Object)this)).underlying().boundSyms();
        }

        default public Symbols.Symbol typeSymbol() {
            return ((Type)((Object)this)).underlying().typeSymbol();
        }

        default public Symbols.Symbol typeSymbolDirect() {
            return ((Type)((Object)this)).underlying().typeSymbolDirect();
        }

        default public Type widen() {
            return ((Type)((Object)this)).underlying().widen();
        }

        default public Type typeOfThis() {
            return ((Type)((Object)this)).underlying().typeOfThis();
        }

        default public TypeBounds bounds() {
            return ((Type)((Object)this)).underlying().bounds();
        }

        default public Type lowerBound() {
            return ((Type)((Object)this)).underlying().lowerBound();
        }

        default public Type upperBound() {
            return ((Type)((Object)this)).underlying().upperBound();
        }

        default public List<Type> parents() {
            return ((Type)((Object)this)).underlying().parents();
        }

        default public Type prefix() {
            return ((Type)((Object)this)).underlying().prefix();
        }

        default public Scopes.Scope decls() {
            return ((Type)((Object)this)).underlying().decls();
        }

        default public Type baseType(Symbols.Symbol clazz) {
            return ((Type)((Object)this)).underlying().baseType(clazz);
        }

        default public BaseTypeSeqs.BaseTypeSeq baseTypeSeq() {
            return ((Type)((Object)this)).underlying().baseTypeSeq();
        }

        default public int baseTypeSeqDepth() {
            return ((Type)((Object)this)).underlying().baseTypeSeqDepth();
        }

        default public List<Symbols.Symbol> baseClasses() {
            return ((Type)((Object)this)).underlying().baseClasses();
        }

        public /* synthetic */ Types scala$reflect$internal$Types$SimpleTypeProxy$$$outer();

        public static void $init$(SimpleTypeProxy $this) {
        }
    }

    public abstract class SingleType
    extends SingletonType
    implements Types.SingleTypeApi,
    Serializable {
        private final Type pre;
        private final Symbols.Symbol sym;
        private byte trivial;
        private volatile Type underlyingCache;
        private volatile int underlyingPeriod;

        @Override
        public Type pre() {
            return this.pre;
        }

        @Override
        public Symbols.Symbol sym() {
            return this.sym;
        }

        private byte trivial() {
            return this.trivial;
        }

        private void trivial_$eq(byte x$1) {
            this.trivial = x$1;
        }

        @Override
        public boolean isTrivial() {
            if (this.trivial() == 0) {
                this.trivial_$eq(ThreeValues$.MODULE$.fromBoolean(this.pre().isTrivial()));
            }
            return ThreeValues$.MODULE$.toBoolean(this.trivial());
        }

        @Override
        public boolean isGround() {
            return this.sym().isPackageClass() || this.pre().isGround();
        }

        public Type underlyingCache() {
            return this.underlyingCache;
        }

        public void underlyingCache_$eq(Type x$1) {
            this.underlyingCache = x$1;
        }

        public int underlyingPeriod() {
            return this.underlyingPeriod;
        }

        public void underlyingPeriod_$eq(int x$1) {
            this.underlyingPeriod = x$1;
        }

        public void scala$reflect$internal$Types$$invalidateSingleTypeCaches() {
            this.underlyingCache_$eq(this.scala$reflect$internal$Types$SingleType$$$outer().NoType());
            this.underlyingPeriod_$eq(0);
        }

        @Override
        public Type underlying() {
            Type cache = this.underlyingCache();
            if (this.underlyingPeriod() == this.scala$reflect$internal$Types$SingleType$$$outer().currentPeriod() && cache != null) {
                return cache;
            }
            this.scala$reflect$internal$Types$SingleType$$$outer().defineUnderlyingOfSingleType(this);
            return this.underlyingCache();
        }

        @Override
        public boolean isImmediatelyDependent() {
            return this.sym() != this.scala$reflect$internal$Types$SingleType$$$outer().NoSymbol() && this.sym().owner().isMethod() && this.sym().isValueParameter();
        }

        @Override
        public Type narrow() {
            return this;
        }

        @Override
        public Symbols.Symbol termSymbol() {
            return this.sym();
        }

        @Override
        public Type prefix() {
            return this.pre();
        }

        @Override
        public String prefixString() {
            if (this.sym().skipPackageObject().isOmittablePrefix()) {
                return "";
            }
            if (this.sym().isPackageObjectOrClass()) {
                return this.pre().prefixString();
            }
            return new StringBuilder(1).append(this.pre().prefixString()).append(this.sym().nameString()).append(".").toString();
        }

        @Override
        public String kind() {
            return "SingleType";
        }

        @Override
        public String productPrefix() {
            return "SingleType";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.pre();
                }
                case 1: {
                    return this.sym();
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
            return x$1 instanceof SingleType;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public boolean equals(Object x$1) {
            if (this == x$1) return true;
            if (!(x$1 instanceof SingleType)) return false;
            if (((SingleType)x$1).scala$reflect$internal$Types$SingleType$$$outer() != this.scala$reflect$internal$Types$SingleType$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            SingleType singleType = (SingleType)x$1;
            Type type = this.pre();
            Type type2 = singleType.pre();
            if (type == null) {
                if (type2 != null) {
                    return false;
                }
            } else if (!type.equals(type2)) return false;
            Symbols.Symbol symbol = this.sym();
            Symbols.Symbol symbol2 = singleType.sym();
            if (symbol == null) {
                if (symbol2 != null) {
                    return false;
                }
            } else if (!symbol.equals(symbol2)) return false;
            if (!singleType.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$SingleType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public SingleType(SymbolTable $outer, Type pre, Symbols.Symbol sym) {
            this.pre = pre;
            this.sym = sym;
            super($outer);
            this.trivial = 0;
            this.underlyingCache = $outer.NoType();
            this.underlyingPeriod = 0;
        }
    }

    public abstract class SingletonType
    extends SubType
    implements SimpleTypeProxy,
    Types.SingletonTypeApi {
        @Override
        public Type typeConstructor() {
            return ((SimpleTypeProxy)this).typeConstructor();
        }

        @Override
        public boolean isError() {
            return ((SimpleTypeProxy)this).isError();
        }

        @Override
        public boolean isErroneous() {
            return ((SimpleTypeProxy)this).isErroneous();
        }

        @Override
        public int paramSectionCount() {
            return ((SimpleTypeProxy)this).paramSectionCount();
        }

        @Override
        public List<List<Symbols.Symbol>> paramss() {
            return ((SimpleTypeProxy)this).paramss();
        }

        @Override
        public List<Symbols.Symbol> params() {
            return ((SimpleTypeProxy)this).params();
        }

        @Override
        public List<Type> paramTypes() {
            return ((SimpleTypeProxy)this).paramTypes();
        }

        @Override
        public Symbols.Symbol termSymbol() {
            return ((SimpleTypeProxy)this).termSymbol();
        }

        @Override
        public Symbols.Symbol termSymbolDirect() {
            return ((SimpleTypeProxy)this).termSymbolDirect();
        }

        @Override
        public List<Symbols.Symbol> typeParams() {
            return ((SimpleTypeProxy)this).typeParams();
        }

        @Override
        public Symbols.Symbol typeSymbol() {
            return ((SimpleTypeProxy)this).typeSymbol();
        }

        @Override
        public Symbols.Symbol typeSymbolDirect() {
            return ((SimpleTypeProxy)this).typeSymbolDirect();
        }

        @Override
        public Type widen() {
            return ((SimpleTypeProxy)this).widen();
        }

        @Override
        public Type typeOfThis() {
            return ((SimpleTypeProxy)this).typeOfThis();
        }

        @Override
        public TypeBounds bounds() {
            return ((SimpleTypeProxy)this).bounds();
        }

        @Override
        public Type lowerBound() {
            return ((SimpleTypeProxy)this).lowerBound();
        }

        @Override
        public Type upperBound() {
            return ((SimpleTypeProxy)this).upperBound();
        }

        @Override
        public List<Type> parents() {
            return ((SimpleTypeProxy)this).parents();
        }

        @Override
        public Type prefix() {
            return ((SimpleTypeProxy)this).prefix();
        }

        @Override
        public Scopes.Scope decls() {
            return ((SimpleTypeProxy)this).decls();
        }

        @Override
        public Type baseType(Symbols.Symbol clazz) {
            return ((SimpleTypeProxy)this).baseType(clazz);
        }

        @Override
        public BaseTypeSeqs.BaseTypeSeq baseTypeSeq() {
            return ((SimpleTypeProxy)this).baseTypeSeq();
        }

        @Override
        public int baseTypeSeqDepth() {
            return ((SimpleTypeProxy)this).baseTypeSeqDepth();
        }

        @Override
        public List<Symbols.Symbol> baseClasses() {
            return ((SimpleTypeProxy)this).baseClasses();
        }

        @Override
        public Type supertype() {
            return this.underlying();
        }

        @Override
        public boolean isTrivial() {
            return false;
        }

        @Override
        public boolean isHigherKinded() {
            return false;
        }

        @Override
        public String safeToString() {
            Symbols.Symbol pre = this.underlying().typeSymbol().skipPackageObject();
            if (pre.isOmittablePrefix()) {
                return new StringBuilder(5).append(pre.fullName()).append(".type").toString();
            }
            return new StringBuilder(4).append(this.prefixString()).append("type").toString();
        }

        @Override
        public Set<Symbols.Symbol> boundSyms() {
            return this.scala$reflect$internal$Types$SingletonType$$$outer().scala$reflect$internal$Types$$emptySymbolSet();
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$SingletonType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        @Override
        public /* synthetic */ Types scala$reflect$internal$Types$SimpleTypeProxy$$$outer() {
            return this.scala$reflect$internal$Types$SingletonType$$$outer();
        }

        public SingletonType(SymbolTable $outer) {
            super($outer);
            SimpleTypeProxy.$init$(this);
        }
    }

    public abstract class SubType
    extends UniqueType {
        public abstract Type supertype();

        @Override
        public List<Type> parents() {
            return this.supertype().parents();
        }

        @Override
        public Scopes.Scope decls() {
            return this.supertype().decls();
        }

        @Override
        public Type baseType(Symbols.Symbol clazz) {
            return this.supertype().baseType(clazz);
        }

        @Override
        public BaseTypeSeqs.BaseTypeSeq baseTypeSeq() {
            return this.supertype().baseTypeSeq();
        }

        @Override
        public int baseTypeSeqDepth() {
            return this.supertype().baseTypeSeqDepth();
        }

        @Override
        public List<Symbols.Symbol> baseClasses() {
            return this.supertype().baseClasses();
        }

        @Override
        public Set<Symbols.Symbol> boundSyms() {
            return this.scala$reflect$internal$Types$SubType$$$outer().scala$reflect$internal$Types$$emptySymbolSet();
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$SubType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public SubType(SymbolTable $outer) {
            super($outer);
        }
    }

    public abstract class SuperType
    extends SingletonType
    implements Types.SuperTypeApi,
    Serializable {
        private final Type thistpe;
        private final Type supertpe;
        private byte trivial;

        @Override
        public Type thistpe() {
            return this.thistpe;
        }

        @Override
        public Type supertpe() {
            return this.supertpe;
        }

        private byte trivial() {
            return this.trivial;
        }

        private void trivial_$eq(byte x$1) {
            this.trivial = x$1;
        }

        @Override
        public boolean isTrivial() {
            if (this.trivial() == 0) {
                this.trivial_$eq(ThreeValues$.MODULE$.fromBoolean(this.thistpe().isTrivial() && this.supertpe().isTrivial()));
            }
            return ThreeValues$.MODULE$.toBoolean(this.trivial());
        }

        @Override
        public Symbols.Symbol typeSymbol() {
            return this.thistpe().typeSymbol();
        }

        @Override
        public Type underlying() {
            return this.supertpe();
        }

        @Override
        public Type prefix() {
            return this.supertpe().prefix();
        }

        @Override
        public String prefixString() {
            return this.thistpe().prefixString().replaceAll("\\bthis\\.$", "super.");
        }

        @Override
        public Type narrow() {
            return this.thistpe().narrow();
        }

        @Override
        public String kind() {
            return "SuperType";
        }

        @Override
        public String productPrefix() {
            return "SuperType";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.thistpe();
                }
                case 1: {
                    return this.supertpe();
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
            return x$1 instanceof SuperType;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public boolean equals(Object x$1) {
            if (this == x$1) return true;
            if (!(x$1 instanceof SuperType)) return false;
            if (((SuperType)x$1).scala$reflect$internal$Types$SuperType$$$outer() != this.scala$reflect$internal$Types$SuperType$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            SuperType superType = (SuperType)x$1;
            Type type = this.thistpe();
            Type type2 = superType.thistpe();
            if (type == null) {
                if (type2 != null) {
                    return false;
                }
            } else if (!type.equals(type2)) return false;
            Type type3 = this.supertpe();
            Type type4 = superType.supertpe();
            if (type3 == null) {
                if (type4 != null) {
                    return false;
                }
            } else if (!type3.equals(type4)) return false;
            if (!superType.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$SuperType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public SuperType(SymbolTable $outer, Type thistpe, Type supertpe) {
            this.thistpe = thistpe;
            this.supertpe = supertpe;
            super($outer);
            this.trivial = 0;
        }
    }

    public abstract class ThisType
    extends SingletonType
    implements Types.ThisTypeApi,
    Serializable {
        private final Symbols.Symbol sym;

        @Override
        public Symbols.Symbol sym() {
            return this.sym;
        }

        @Override
        public boolean isTrivial() {
            return this.sym().isPackageClass();
        }

        @Override
        public Symbols.Symbol typeSymbol() {
            return this.sym();
        }

        @Override
        public Type underlying() {
            return this.sym().typeOfThis();
        }

        @Override
        public boolean isHigherKinded() {
            return this.sym().isRefinementClass() && this.underlying().isHigherKinded();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public String prefixString() {
            void reflectSettingToBoolean_s;
            MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Types$ThisType$$$outer().settings().debug();
            if (MutableSettings$.MODULE$ == null) {
                throw null;
            }
            if (BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value())) {
                return new StringBuilder(6).append(this.sym().nameString()).append(".this.").toString();
            }
            if (this.sym().isAnonOrRefinementClass()) {
                return "this.";
            }
            if (this.sym().isOmittablePrefix()) {
                return "";
            }
            if (this.sym().isModuleClass()) {
                return new StringBuilder(1).append(this.sym().fullNameString()).append(".").toString();
            }
            return new StringBuilder(6).append(this.sym().nameString()).append(".this.").toString();
        }

        @Override
        public String safeToString() {
            if (this.sym().isEffectiveRoot()) {
                return String.valueOf(this.sym().name());
            }
            return super.safeToString();
        }

        @Override
        public Type narrow() {
            return this;
        }

        @Override
        public String kind() {
            return "ThisType";
        }

        @Override
        public String productPrefix() {
            return "ThisType";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.sym();
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
            return x$1 instanceof ThisType;
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof ThisType && ((ThisType)x$1).scala$reflect$internal$Types$ThisType$$$outer() == this.scala$reflect$internal$Types$ThisType$$$outer();
                    if (!bl) break block3;
                    ThisType thisType = (ThisType)x$1;
                    Symbols.Symbol symbol = this.sym();
                    Symbols.Symbol symbol2 = thisType.sym();
                    if (!(!(symbol != null ? !symbol.equals(symbol2) : symbol2 != null) && thisType.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$ThisType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public ThisType(SymbolTable $outer, Symbols.Symbol sym) {
            this.sym = sym;
            super($outer);
            if (!sym.isClass() && !sym.isFreeType()) {
                sym.failIfStub();
                throw $outer.abort(new StringBuilder(39).append("ThisType(").append(sym).append(") for sym which is not a class").toString());
            }
        }
    }

    public abstract class Type
    extends TypeApiImpl
    implements AnnotationInfos.Annotatable<Type> {
        @Override
        public List<AnnotationInfos.AnnotationInfo> staticAnnotations() {
            return AnnotationInfos.Annotatable.staticAnnotations$(this);
        }

        @Override
        public Object addThrowsAnnotation(Symbols.Symbol throwableSym) {
            return AnnotationInfos.Annotatable.addThrowsAnnotation$(this, throwableSym);
        }

        @Override
        public boolean hasAnnotation(Symbols.Symbol cls) {
            return AnnotationInfos.Annotatable.hasAnnotation$(this, cls);
        }

        @Override
        public Option<AnnotationInfos.AnnotationInfo> getAnnotation(Symbols.Symbol cls) {
            return AnnotationInfos.Annotatable.getAnnotation$(this, cls);
        }

        @Override
        public Object removeAnnotation(Symbols.Symbol cls) {
            return AnnotationInfos.Annotatable.removeAnnotation$(this, cls);
        }

        @Override
        public final Object withAnnotation(AnnotationInfos.AnnotationInfo annot) {
            return AnnotationInfos.Annotatable.withAnnotation$(this, annot);
        }

        public boolean isTrivial() {
            return false;
        }

        public boolean isHigherKinded() {
            return false;
        }

        @Override
        public boolean takesTypeArgs() {
            return this.isHigherKinded();
        }

        public final boolean isStable() {
            return this.scala$reflect$internal$Types$Type$$$outer().definitions().isStable(this);
        }

        public final boolean isVolatile() {
            return this.scala$reflect$internal$Types$Type$$$outer().definitions().isVolatile(this);
        }

        public boolean isStructuralRefinement() {
            return false;
        }

        public boolean isImmediatelyDependent() {
            return false;
        }

        public boolean isDependentMethodType() {
            return false;
        }

        public boolean isWildcard() {
            return false;
        }

        public boolean isError() {
            return this.typeSymbol().isError() || this.termSymbol().isError();
        }

        public boolean isErroneous() {
            return BoxesRunTime.unboxToBoolean(this.scala$reflect$internal$Types$Type$$$outer().ErroneousCollector().collect(this));
        }

        public boolean isFinalType() {
            return this.typeSymbol().hasOnlyBottomSubclasses() && this.prefix().isStable();
        }

        public boolean isComplete() {
            return true;
        }

        public boolean isShowAsInfixType() {
            return false;
        }

        public void complete(Symbols.Symbol sym) {
        }

        public void forceDirectSuperclasses() {
        }

        @Override
        public Symbols.Symbol termSymbol() {
            return this.scala$reflect$internal$Types$Type$$$outer().NoSymbol();
        }

        @Override
        public Symbols.Symbol typeSymbol() {
            return this.scala$reflect$internal$Types$Type$$$outer().NoSymbol();
        }

        public Symbols.Symbol termSymbolDirect() {
            return this.termSymbol();
        }

        public Symbols.Symbol typeSymbolDirect() {
            return this.typeSymbol();
        }

        public Type underlying() {
            return this;
        }

        @Override
        public Type widen() {
            return this;
        }

        public Type deconst() {
            return this;
        }

        public Type typeOfThis() {
            return this.typeSymbol().typeOfThis();
        }

        public Type narrow() {
            if (this.scala$reflect$internal$Types$Type$$$outer().phase().erasedTypes()) {
                return this;
            }
            Symbols.Symbol cowner = this.scala$reflect$internal$Types$Type$$$outer().commonOwner(this);
            return this.scala$reflect$internal$Types$Type$$$outer().refinedType(Nil$.MODULE$.$colon$colon(this), cowner, this.scala$reflect$internal$Types$Type$$$outer().EmptyScope(), cowner.pos()).narrow();
        }

        public TypeBounds bounds() {
            return this.scala$reflect$internal$Types$Type$$$outer().TypeBounds().apply(this.lowerBound(), this.upperBound());
        }

        public Type lowerBound() {
            return this;
        }

        public Type upperBound() {
            return this;
        }

        public List<Type> parents() {
            return Nil$.MODULE$;
        }

        public Type firstParent() {
            if (!this.parents().isEmpty()) {
                return this.parents().head();
            }
            return this.scala$reflect$internal$Types$Type$$$outer().definitions().ObjectTpe();
        }

        public Type prefix() {
            return this.scala$reflect$internal$Types$Type$$$outer().NoType();
        }

        public List<Type> prefixChain() {
            List list;
            if (this instanceof TypeRef) {
                Type pre = ((TypeRef)this).pre();
                list = pre.prefixChain().$colon$colon(pre);
            } else if (this instanceof SingleType) {
                Type pre = ((SingleType)this).pre();
                list = pre.prefixChain().$colon$colon(pre);
            } else {
                list = Nil$.MODULE$;
            }
            return list;
        }

        @Override
        public Type typeConstructor() {
            return this;
        }

        public List<Type> typeArgs() {
            return Nil$.MODULE$;
        }

        public List<Type> dummyArgs() {
            return this.typeParams().map((Function1<Symbols.Symbol, Type> & java.io.Serializable & Serializable)x$4 -> x$4.typeConstructor(), List$.MODULE$.canBuildFrom());
        }

        @Override
        public Type resultType() {
            return this;
        }

        public Type resultType(List<Type> actuals) {
            return this;
        }

        public Type resultApprox() {
            return this.scala$reflect$internal$Types$Type$$$outer().ApproximateDependentMap().apply(this.resultType());
        }

        @Override
        public final Type finalResultType() {
            return this.scala$reflect$internal$Types$Type$$$outer().definitions().finalResultType(this);
        }

        public int paramSectionCount() {
            return 0;
        }

        public List<List<Symbols.Symbol>> paramss() {
            return Nil$.MODULE$;
        }

        public List<Symbols.Symbol> params() {
            return Nil$.MODULE$;
        }

        public List<Type> paramTypes() {
            return Nil$.MODULE$;
        }

        public List<Symbols.Symbol> typeParams() {
            return Nil$.MODULE$;
        }

        public Set<Symbols.Symbol> boundSyms() {
            return this.scala$reflect$internal$Types$Type$$$outer().scala$reflect$internal$Types$$emptySymbolSet();
        }

        public Type instantiateTypeParams(List<Symbols.Symbol> formals, List<Type> actuals) {
            if (this.scala$reflect$internal$Types$Type$$$outer().sameLength(formals, actuals)) {
                return this.subst(formals, actuals);
            }
            return this.scala$reflect$internal$Types$Type$$$outer().ErrorType();
        }

        public Type skolemizeExistential(Symbols.Symbol owner, Object origin) {
            return this;
        }

        public Type skolemizeExistential() {
            return this.skolemizeExistential(this.scala$reflect$internal$Types$Type$$$outer().NoSymbol(), null);
        }

        @Override
        public Type normalize() {
            return this;
        }

        @Override
        public Type etaExpand() {
            return this;
        }

        @Override
        public Type dealias() {
            return this;
        }

        public Type dealiasWiden() {
            Type widened = this.widen();
            if (this != widened) {
                return widened.dealiasWiden();
            }
            Type dealiased = this.dealias();
            if (this != dealiased) {
                return dealiased.dealiasWiden();
            }
            return this;
        }

        public List<Type> dealiasWidenChain() {
            Type betaReduced;
            Type widened = this.widen();
            return (this != widened ? widened.dealiasWidenChain() : (this != (betaReduced = this.betaReduce()) ? betaReduced.dealiasWidenChain() : Nil$.MODULE$)).$colon$colon(this);
        }

        public Type betaReduce() {
            return this;
        }

        @Override
        public Scopes.Scope decls() {
            return this.scala$reflect$internal$Types$Type$$$outer().EmptyScope();
        }

        public Symbols.Symbol decl(Names.Name name) {
            return this.findDecl(name, 0);
        }

        public List<Symbols.Symbol> nonPrivateDecls() {
            return ((Scopes.Scope)this.decls().filterNot((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$6 -> BoxesRunTime.boxToBoolean(x$6.isPrivate()))).toList();
        }

        public Symbols.Symbol nonPrivateDecl(Names.Name name) {
            return this.findDecl(name, 4);
        }

        @Override
        public Scopes.Scope members() {
            return this.membersBasedOnFlags(0L, 0L);
        }

        public Scopes.Scope nonPrivateMembers() {
            return this.membersBasedOnFlags(0x40004000004L, 0L);
        }

        public Scopes.Scope nonPrivateMembersAdmitting(long admit) {
            return this.membersBasedOnFlags(0x40004000004L & (admit ^ 0xFFFFFFFFFFFFFFFFL), 0L);
        }

        public Scopes.Scope implicitMembers() {
            Symbols.Symbol symbol = this.typeSymbolDirect();
            Scopes.Scope scope = symbol instanceof Symbols.ModuleClassSymbol ? ((Symbols.ModuleClassSymbol)symbol).implicitMembers() : this.membersBasedOnFlags(0x40004000000L, 512L);
            return scope;
        }

        public Scopes.Scope deferredMembers() {
            return this.membersBasedOnFlags(0x40004000000L, 16L);
        }

        public Symbols.Symbol member(Names.Name name) {
            return this.memberBasedOnName(name, 0x40004000000L);
        }

        public Symbols.Symbol nonPrivateMember(Names.Name name) {
            return this.memberBasedOnName(name, 0x40004000004L);
        }

        public boolean hasNonPrivateMember(Names.Name name) {
            return BoxesRunTime.unboxToBoolean(new FindMembers.HasMember(this.scala$reflect$internal$Types$Type$$$outer(), this, name, 0x40004000004L, 0L).apply());
        }

        public Symbols.Symbol packageObject() {
            return this.member(this.scala$reflect$internal$Types$Type$$$outer().nme().PACKAGE());
        }

        public Symbols.Symbol nonPrivateMemberAdmitting(Names.Name name, long admit) {
            return this.memberBasedOnName(name, 0x40004000004L & (admit ^ 0xFFFFFFFFFFFFFFFFL));
        }

        public Symbols.Symbol nonLocalMember(Names.Name name) {
            return this.memberBasedOnName(name, 0x40004080000L);
        }

        public Scopes.Scope membersBasedOnFlags(long excludedFlags, long requiredFlags) {
            return this.findMembers(excludedFlags, requiredFlags);
        }

        public Symbols.Symbol memberBasedOnName(Names.Name name, long excludedFlags) {
            return this.findMember(name, excludedFlags, 0L, false);
        }

        public Type baseType(Symbols.Symbol clazz) {
            return this.scala$reflect$internal$Types$Type$$$outer().NoType();
        }

        /*
         * Unable to fully structure code
         */
        public Type asSeenFrom(Type pre, Symbols.Symbol clazz) {
            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                v0 = this.scala$reflect$internal$Types$Type$$$outer().statistics();
                var9_3 = ((TypesStats)this.scala$reflect$internal$Types$Type$$$outer().statistics()).typeOpsStack();
                if (v0 == null) {
                    throw null;
                }
                v1 = v0.areColdStatsLocallyEnabled() && pushTimer_timers != null ? pushTimer_timers.push(Type.$anonfun$asSeenFrom$1(this)) : null;
            } else {
                v1 = null;
            }
            start = v1;
            try {
                block15: {
                    if (this.isTrivial()) ** GOTO lbl-1000
                    if (!this.scala$reflect$internal$Types$Type$$$outer().phase().erasedTypes()) break block15;
                    v2 = pre.typeSymbol();
                    var4_5 = this.scala$reflect$internal$Types$Type$$$outer().definitions().ArrayClass();
                    if (v2 != null ? v2.equals(var4_5) == false : var4_5 != null) ** GOTO lbl-1000
                }
                if (this.scala$reflect$internal$Types$Type$$$outer().skipPrefixOf(pre, clazz)) lbl-1000:
                // 3 sources

                {
                    v3 = true;
                } else {
                    v3 = false;
                }
                if (v3) {
                    v4 = this;
                } else {
                    m = new TypeMaps.AsSeenFromMap(this.scala$reflect$internal$Types$Type$$$outer(), pre.normalize(), clazz);
                    tp = m.apply(this);
                    tp1 = this.scala$reflect$internal$Types$Type$$$outer().existentialAbstraction(m.capturedParams(), tp);
                    v4 = m.capturedSkolems().isEmpty() ? tp1 : this.scala$reflect$internal$Types$Type$$$outer().deriveType(m.capturedSkolems(), (Function1<Symbols.Symbol, Symbols.Symbol> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$asSeenFrom$2(scala.reflect.internal.Symbols$Symbol ), (Lscala/reflect/internal/Symbols$Symbol;)Lscala/reflect/internal/Symbols$Symbol;)(), tp1);
                }
            }
            catch (Throwable var8_9) {
                if (StatisticsStatics.areSomeColdStatsEnabled()) {
                    v5 = this.scala$reflect$internal$Types$Type$$$outer().statistics();
                    var10_10 = ((TypesStats)this.scala$reflect$internal$Types$Type$$$outer().statistics()).typeOpsStack();
                    if (v5 == null) {
                        throw null;
                    }
                    if (v5.areColdStatsLocallyEnabled() && popTimer_timers != null) {
                        popTimer_timers.pop(start);
                    }
                }
                throw var8_9;
            }
            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                v6 = this.scala$reflect$internal$Types$Type$$$outer().statistics();
                var11_11 = ((TypesStats)this.scala$reflect$internal$Types$Type$$$outer().statistics()).typeOpsStack();
                if (v6 == null) {
                    throw null;
                }
                if (v6.areColdStatsLocallyEnabled() && popTimer_timers != null) {
                    popTimer_timers.pop(start);
                    return v4;
                }
            }
            return v4;
        }

        public Type memberInfo(Symbols.Symbol sym) {
            return sym.info().asSeenFrom(this, sym.owner());
        }

        public Type memberType(Symbols.Symbol sym) {
            Type type = sym instanceof Symbols.MethodSymbol ? ((Symbols.MethodSymbol)sym).typeAsMemberOf(this) : this.computeMemberType(sym);
            return type;
        }

        public Type computeMemberType(Symbols.Symbol sym) {
            Type type;
            Type type2 = sym.tpeHK();
            if (type2 instanceof OverloadedType) {
                List<Symbols.Symbol> alts = ((OverloadedType)type2).alternatives();
                type = new OverloadedType(this.scala$reflect$internal$Types$Type$$$outer(), this, alts);
            } else {
                type = sym == this.scala$reflect$internal$Types$Type$$$outer().NoSymbol() ? this.scala$reflect$internal$Types$Type$$$outer().NoType() : type2.asSeenFrom(this, sym.owner());
            }
            return type;
        }

        public Type subst(List<Symbols.Symbol> from, List<Type> to) {
            if (from.isEmpty()) {
                return this;
            }
            return this.scala$reflect$internal$Types$Type$$$outer().scala$reflect$internal$Types$$substTypeMapCache().apply(from, to).apply(this);
        }

        public Type substSym(List<Symbols.Symbol> from, List<Symbols.Symbol> to) {
            if (from == to || from.isEmpty()) {
                return this;
            }
            return new TypeMaps.SubstSymMap(this.scala$reflect$internal$Types$Type$$$outer(), from, to).apply(this);
        }

        public Type substThis(Symbols.Symbol from, Type to) {
            return new TypeMaps.SubstThisMap(this.scala$reflect$internal$Types$Type$$$outer(), from, to).apply(this);
        }

        public Type substThis(Symbols.Symbol from, Symbols.Symbol to) {
            return this.substThis(from, to.thisType());
        }

        public Type substThisAndSym(Symbols.Symbol from, Type to, List<Symbols.Symbol> symsFrom, List<Symbols.Symbol> symsTo) {
            if (symsFrom == symsTo) {
                return this.substThis(from, to);
            }
            return this.substThis(from, to).substSym(symsFrom, symsTo);
        }

        public FilterMapForeach withFilter(Function1<Type, Object> p) {
            return new FilterMapForeach(p);
        }

        public final Type orElse(Function0<Type> alt) {
            if (this != this.scala$reflect$internal$Types$Type$$$outer().NoType()) {
                return this;
            }
            return alt.apply();
        }

        public Option<Type> find(Function1<Type, Object> p) {
            return (Option)new TypeMaps.FindTypeCollector(this.scala$reflect$internal$Types$Type$$$outer(), p).collect(this);
        }

        public void foreach(Function1<Type, BoxedUnit> f) {
            new TypeMaps.ForEachTypeTraverser(this.scala$reflect$internal$Types$Type$$$outer(), f).traverse(this);
        }

        public <T> List<T> collect(PartialFunction<Type, T> pf) {
            return new TypeMaps.CollectTypeCollector<T>(this.scala$reflect$internal$Types$Type$$$outer(), pf).collect(this);
        }

        public Type map(Function1<Type, Type> f) {
            return new TypeMaps.TypeMap(this, f){
                private final Function1 f$1;

                public Type apply(Type x) {
                    return (Type)this.f$1.apply(this.mapOver(x));
                }
                {
                    this.f$1 = f$1;
                    super($outer.scala$reflect$internal$Types$Type$$$outer());
                }
            }.apply(this);
        }

        public boolean exists(Function1<Type, Object> p) {
            return !this.find(p).isEmpty();
        }

        public boolean contains(Symbols.Symbol sym) {
            return BoxesRunTime.unboxToBoolean(new TypeMaps.ContainsCollector(this.scala$reflect$internal$Types$Type$$$outer(), sym).collect(this));
        }

        public boolean $less$colon$less(Type that) {
            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                return this.stat_$less$colon$less(that);
            }
            return this == that || (this.scala$reflect$internal$Types$Type$$$outer().scala$reflect$internal$Types$$explainSwitch() ? this.scala$reflect$internal$Types$Type$$$outer().explain("<:", (Function2<Type, Type, Object> & java.io.Serializable & Serializable)(x$8, x$9) -> BoxesRunTime.boxToBoolean(Type.$anonfun$$less$colon$less$1(this, x$8, x$9)), this, that) : this.scala$reflect$internal$Types$Type$$$outer().isSubType(this, that, this.scala$reflect$internal$Types$Type$$$outer().isSubType$default$3()));
        }

        public boolean matchesPattern(Type that) {
            block10: {
                block9: {
                    boolean bl;
                    Type elem2;
                    if (this.$less$colon$less(that)) break block9;
                    Option<Type> option = this.scala$reflect$internal$Types$Type$$$outer().ArrayTypeRef().unapply(that);
                    if (!option.isEmpty() && (elem2 = option.get()).typeConstructor().isHigherKinded()) {
                        Option<Type> option2 = this.scala$reflect$internal$Types$Type$$$outer().ArrayTypeRef().unapply(this);
                        boolean bl2 = !option2.isEmpty() ? option2.get().matchesPattern(elem2) : false;
                        bl = bl2;
                    } else if (that instanceof TypeRef) {
                        boolean bl3;
                        List<Type> args2 = ((TypeRef)that).args();
                        Type that1 = this.scala$reflect$internal$Types$Type$$$outer().existentialAbstraction(args2.map((Function1<Type, Symbols.Symbol> & java.io.Serializable & Serializable)x$10 -> x$10.typeSymbol(), List$.MODULE$.canBuildFrom()), that);
                        if (that != that1 && this.$less$colon$less(that1)) {
                            this.scala$reflect$internal$Types$Type$$$outer().debuglog((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(62).append(this).append(".matchesPattern(").append(that).append(") depended on discarding args and testing <:< ").append(that1).toString());
                            bl3 = true;
                        } else {
                            bl3 = false;
                        }
                        bl = bl3;
                    } else {
                        bl = false;
                    }
                    if (!bl) break block10;
                }
                return true;
            }
            return false;
        }

        /*
         * WARNING - void declaration
         */
        public boolean stat_$less$colon$less(Type that) {
            void var3_5;
            boolean result2;
            Tuple2<Object, Object> start;
            Tuple2<Object, Object> tuple2;
            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                void incCounter_c;
                Statistics statistics = this.scala$reflect$internal$Types$Type$$$outer().statistics();
                Statistics.Counter counter = ((TypesStats)((Object)this.scala$reflect$internal$Types$Type$$$outer().statistics())).subtypeCount();
                if (statistics == null) {
                    throw null;
                }
                if (statistics.areColdStatsLocallyEnabled() && incCounter_c != null) {
                    incCounter_c.value_$eq(incCounter_c.value() + 1);
                }
            }
            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                void pushTimer_timers;
                Statistics statistics = this.scala$reflect$internal$Types$Type$$$outer().statistics();
                Statistics.TimerStack timerStack = ((TypesStats)((Object)this.scala$reflect$internal$Types$Type$$$outer().statistics())).typeOpsStack();
                if (statistics == null) {
                    throw null;
                }
                tuple2 = statistics.areColdStatsLocallyEnabled() && pushTimer_timers != null ? pushTimer_timers.push(Type.$anonfun$stat_$less$colon$less$1(this)) : null;
            } else {
                tuple2 = start = null;
            }
            boolean bl = this == that || (this.scala$reflect$internal$Types$Type$$$outer().scala$reflect$internal$Types$$explainSwitch() ? this.scala$reflect$internal$Types$Type$$$outer().explain("<:", (Function2<Type, Type, Object> & java.io.Serializable & Serializable)(x$11, x$12) -> BoxesRunTime.boxToBoolean(Type.$anonfun$stat_$less$colon$less$2(this, x$11, x$12)), this, that) : this.scala$reflect$internal$Types$Type$$$outer().isSubType(this, that, this.scala$reflect$internal$Types$Type$$$outer().isSubType$default$3())) ? true : (result2 = false);
            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                void popTimer_timers;
                Statistics statistics = this.scala$reflect$internal$Types$Type$$$outer().statistics();
                Statistics.TimerStack timerStack = ((TypesStats)((Object)this.scala$reflect$internal$Types$Type$$$outer().statistics())).typeOpsStack();
                if (statistics == null) {
                    throw null;
                }
                if (statistics.areColdStatsLocallyEnabled() && popTimer_timers != null) {
                    popTimer_timers.pop(start);
                }
            }
            return (boolean)var3_5;
        }

        /*
         * WARNING - void declaration
         */
        public boolean weak_$less$colon$less(Type that) {
            void var3_5;
            boolean result2;
            Tuple2<Object, Object> start;
            Tuple2<Object, Object> tuple2;
            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                void incCounter_c;
                Statistics statistics = this.scala$reflect$internal$Types$Type$$$outer().statistics();
                Statistics.Counter counter = ((TypesStats)((Object)this.scala$reflect$internal$Types$Type$$$outer().statistics())).subtypeCount();
                if (statistics == null) {
                    throw null;
                }
                if (statistics.areColdStatsLocallyEnabled() && incCounter_c != null) {
                    incCounter_c.value_$eq(incCounter_c.value() + 1);
                }
            }
            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                void pushTimer_timers;
                Statistics statistics = this.scala$reflect$internal$Types$Type$$$outer().statistics();
                Statistics.TimerStack timerStack = ((TypesStats)((Object)this.scala$reflect$internal$Types$Type$$$outer().statistics())).typeOpsStack();
                if (statistics == null) {
                    throw null;
                }
                tuple2 = statistics.areColdStatsLocallyEnabled() && pushTimer_timers != null ? pushTimer_timers.push(Type.$anonfun$weak_$less$colon$less$1(this)) : null;
            } else {
                tuple2 = start = null;
            }
            boolean bl = this == that || (this.scala$reflect$internal$Types$Type$$$outer().scala$reflect$internal$Types$$explainSwitch() ? this.scala$reflect$internal$Types$Type$$$outer().explain("weak_<:", (Function2<Type, Type, Object> & java.io.Serializable & Serializable)(tp1, tp2) -> BoxesRunTime.boxToBoolean(Type.$anonfun$weak_$less$colon$less$2(this, tp1, tp2)), this, that) : this.scala$reflect$internal$Types$Type$$$outer().isWeakSubType(this, that)) ? true : (result2 = false);
            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                void popTimer_timers;
                Statistics statistics = this.scala$reflect$internal$Types$Type$$$outer().statistics();
                Statistics.TimerStack timerStack = ((TypesStats)((Object)this.scala$reflect$internal$Types$Type$$$outer().statistics())).typeOpsStack();
                if (statistics == null) {
                    throw null;
                }
                if (statistics.areColdStatsLocallyEnabled() && popTimer_timers != null) {
                    popTimer_timers.pop(start);
                }
            }
            return (boolean)var3_5;
        }

        public boolean $eq$colon$eq(Type that) {
            return this == that || (this.scala$reflect$internal$Types$Type$$$outer().scala$reflect$internal$Types$$explainSwitch() ? this.scala$reflect$internal$Types$Type$$$outer().explain("=", (Function2<Type, Type, Object> & java.io.Serializable & Serializable)(tp1, tp2) -> BoxesRunTime.boxToBoolean(Type.$anonfun$$eq$colon$eq$1(this, tp1, tp2)), this, that) : this.scala$reflect$internal$Types$Type$$$outer().isSameType(this, that));
        }

        public boolean matches(Type that) {
            return this.scala$reflect$internal$Types$Type$$$outer().matchesType(this, that, !this.scala$reflect$internal$Types$Type$$$outer().phase().erasedTypes());
        }

        public boolean looselyMatches(Type that) {
            return this.scala$reflect$internal$Types$Type$$$outer().matchesType(this, that, true);
        }

        public BaseTypeSeqs.BaseTypeSeq baseTypeSeq() {
            return this.scala$reflect$internal$Types$Type$$$outer().baseTypeSingletonSeq(this);
        }

        /*
         * WARNING - void declaration
         */
        public int baseTypeSeqDepth() {
            void apply_depth;
            Depth$ depth$ = Depth$.MODULE$;
            int n = 1;
            if (depth$ == null) {
                throw null;
            }
            Depth$ apply_this = depth$;
            if (apply_depth < -3) {
                return apply_this.AnyDepth();
            }
            return n;
        }

        public List<Symbols.Symbol> baseClasses() {
            return Nil$.MODULE$;
        }

        public int baseTypeIndex(Symbols.Symbol sym) {
            return this.baseTypeSeq().baseTypeIndex(sym);
        }

        public Type cloneInfo(Symbols.Symbol owner) {
            return this;
        }

        public Type atOwner(Symbols.Symbol owner) {
            return this;
        }

        public String objectPrefix() {
            return "object ";
        }

        public String packagePrefix() {
            return "package ";
        }

        public String trimPrefix(String str) {
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            String string = new StringOps(str).stripPrefix(this.objectPrefix());
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return new StringOps(string).stripPrefix(this.packagePrefix());
        }

        public String prefixString() {
            String pre = this.trimPrefix(this.toString());
            if (this.isShowAsInfixType()) {
                return new StringBuilder(3).append("(").append(pre).append(")#").toString();
            }
            return new StringBuilder(1).append(pre).append("#").toString();
        }

        public final String toString() {
            if (!this.scala$reflect$internal$Types$Type$$$outer().isCompilerUniverse()) {
                this.scala$reflect$internal$Types$Type$$$outer().definitions().fullyInitializeType(this);
            }
            return this.scala$reflect$internal$Types$Type$$$outer().typeToString(this);
        }

        public String safeToString() {
            return super.toString();
        }

        /*
         * WARNING - void declaration
         */
        public String toLongString() {
            void var2_1;
            String str;
            String string = str = this.toString();
            String string2 = "type";
            if (string != null && string.equals(string2)) {
                return this.widen().toString();
            }
            if (str.endsWith(".type") && !this.typeSymbol().isModuleClass()) {
                String string3;
                if (this.widen() instanceof RefinedType) {
                    string3 = String.valueOf(this.widen());
                } else {
                    String string4 = this.widen().toString().trim();
                    String string5 = "";
                    string3 = string4 != null && string4.equals(string5) ? str : new StringBuilder(24).append(str).append(" (with underlying type ").append(this.widen()).append(")").toString();
                }
                return string3;
            }
            return var2_1;
        }

        public String directObjectString() {
            return this.safeToString();
        }

        public String nameAndArgsString() {
            return this.typeSymbol().name().toString();
        }

        public final boolean isAny() {
            return this.typeSymbolDirect() == this.scala$reflect$internal$Types$Type$$$outer().definitions().AnyClass();
        }

        public final boolean isNothing() {
            return this.typeSymbolDirect() == this.scala$reflect$internal$Types$Type$$$outer().definitions().NothingClass();
        }

        public boolean isGround() {
            boolean bl = this instanceof ThisType ? true : (this.scala$reflect$internal$Types$Type$$$outer().NoPrefix().equals(this) ? true : (this.scala$reflect$internal$Types$Type$$$outer().WildcardType().equals(this) ? true : (this.scala$reflect$internal$Types$Type$$$outer().NoType().equals(this) ? true : (this.scala$reflect$internal$Types$Type$$$outer().ErrorType().equals(this) ? true : this instanceof ConstantType))));
            boolean bl2 = bl ? true : this.scala$reflect$internal$Types$Type$$$outer().typeVarToOriginMap().apply(this) == this;
            return bl2;
        }

        public void load(Symbols.Symbol sym) {
        }

        private Symbols.Symbol findDecl(Names.Name name, int excludedFlags) {
            List alts = Nil$.MODULE$;
            Symbols.Symbol sym = this.scala$reflect$internal$Types$Type$$$outer().NoSymbol();
            Scopes.ScopeEntry e = this.decls().lookupEntry(name);
            while (e != null) {
                if (!e.sym().hasFlag((long)excludedFlags)) {
                    Symbols.NoSymbol noSymbol = sym;
                    Symbols.NoSymbol noSymbol2 = this.scala$reflect$internal$Types$Type$$$outer().NoSymbol();
                    if (!(noSymbol != null ? !noSymbol.equals(noSymbol2) : noSymbol2 != null)) {
                        sym = e.sym();
                    } else {
                        if (alts.isEmpty()) {
                            alts = Nil$.MODULE$.$colon$colon(sym);
                        }
                        Symbols.Symbol symbol = e.sym();
                        alts = alts.$colon$colon(symbol);
                    }
                }
                e = this.decls().lookupNextEntry(e);
            }
            if (alts.isEmpty()) {
                return sym;
            }
            return this.baseClasses().head().newOverloaded(this, alts);
        }

        /*
         * WARNING - void declaration
         */
        public Scopes.Scope findMembers(long excludedFlags, long requiredFlags) {
            void suspendingTypeVars_op;
            void suspendingTypeVars_tvs;
            if (this.isGround()) {
                return this.findMembersInternal$1(excludedFlags, requiredFlags);
            }
            SymbolTable symbolTable = this.scala$reflect$internal$Types$Type$$$outer();
            Function0<Scopes.Scope> & java.io.Serializable & Serializable intersect = (Function0<Scopes.Scope> & java.io.Serializable & Serializable)() -> this.findMembersInternal$1(excludedFlags, requiredFlags);
            List<TypeVar> list = this.scala$reflect$internal$Types$Type$$$outer().typeVarsInType(this);
            if (symbolTable == null) {
                throw null;
            }
            return (Scopes.Scope)((Types)symbolTable).suspendingTypeVars((List)suspendingTypeVars_tvs, (Function0)suspendingTypeVars_op);
        }

        /*
         * WARNING - void declaration
         */
        public Symbols.Symbol findMember(Names.Name name, long excludedFlags, long requiredFlags, boolean stableOnly) {
            void suspendingTypeVars_op;
            void suspendingTypeVars_tvs;
            if (this.isGround()) {
                return this.findMemberInternal$1(name, excludedFlags, requiredFlags, stableOnly);
            }
            SymbolTable symbolTable = this.scala$reflect$internal$Types$Type$$$outer();
            Function0<Symbols.Symbol> & java.io.Serializable & Serializable intersect = (Function0<Symbols.Symbol> & java.io.Serializable & Serializable)() -> this.findMemberInternal$1(name, excludedFlags, requiredFlags, stableOnly);
            List<TypeVar> list = this.scala$reflect$internal$Types$Type$$$outer().typeVarsInType(this);
            if (symbolTable == null) {
                throw null;
            }
            return (Symbols.Symbol)((Types)symbolTable).suspendingTypeVars((List)suspendingTypeVars_tvs, (Function0)suspendingTypeVars_op);
        }

        public List<Symbols.Symbol> skolemsExceptMethodTypeParams() {
            ObjectRef<Nil$> boundSyms = ObjectRef.create(Nil$.MODULE$);
            ObjectRef<Nil$> skolems = ObjectRef.create(Nil$.MODULE$);
            this.foreach((Function1<Type, BoxedUnit>)(Function1<Type, Object> & java.io.Serializable & Serializable)t -> {
                Type.$anonfun$skolemsExceptMethodTypeParams$1(boundSyms, skolems, t);
                return BoxedUnit.UNIT;
            });
            return (List)skolems.elem;
        }

        @Override
        public List<AnnotationInfos.AnnotationInfo> annotations() {
            return Nil$.MODULE$;
        }

        @Override
        public Type withoutAnnotations() {
            return this;
        }

        @Override
        public Type filterAnnotations(Function1<AnnotationInfos.AnnotationInfo, Object> p) {
            return this;
        }

        @Override
        public Type setAnnotations(List<AnnotationInfos.AnnotationInfo> annots) {
            return this.scala$reflect$internal$Types$Type$$$outer().annotatedType(annots, this);
        }

        @Override
        public Type withAnnotations(List<AnnotationInfos.AnnotationInfo> annots) {
            return this.scala$reflect$internal$Types$Type$$$outer().annotatedType(annots, this);
        }

        public String kind() {
            return new StringBuilder(22).append("unknown type of class ").append(this.getClass()).toString();
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$Type$$$outer() {
            return (SymbolTable)this.$outer;
        }

        @Override
        public /* synthetic */ AnnotationInfos scala$reflect$internal$AnnotationInfos$Annotatable$$$outer() {
            return this.scala$reflect$internal$Types$Type$$$outer();
        }

        public static final /* synthetic */ Statistics.StackableTimer $anonfun$asSeenFrom$1(Type $this) {
            return ((TypesStats)((Object)$this.scala$reflect$internal$Types$Type$$$outer().statistics())).asSeenFromNanos();
        }

        public static final /* synthetic */ Symbols.Symbol $anonfun$asSeenFrom$2(Symbols.Symbol x$7) {
            return x$7.cloneSymbol().setFlag(65536L);
        }

        public static final /* synthetic */ boolean $anonfun$$less$colon$less$1(Type $this, Type x$8, Type x$9) {
            return $this.scala$reflect$internal$Types$Type$$$outer().isSubType(x$8, x$9, $this.scala$reflect$internal$Types$Type$$$outer().isSubType$default$3());
        }

        public static final /* synthetic */ Statistics.StackableTimer $anonfun$stat_$less$colon$less$1(Type $this) {
            return ((TypesStats)((Object)$this.scala$reflect$internal$Types$Type$$$outer().statistics())).subtypeNanos();
        }

        public static final /* synthetic */ boolean $anonfun$stat_$less$colon$less$2(Type $this, Type x$11, Type x$12) {
            return $this.scala$reflect$internal$Types$Type$$$outer().isSubType(x$11, x$12, $this.scala$reflect$internal$Types$Type$$$outer().isSubType$default$3());
        }

        public static final /* synthetic */ Statistics.StackableTimer $anonfun$weak_$less$colon$less$1(Type $this) {
            return ((TypesStats)((Object)$this.scala$reflect$internal$Types$Type$$$outer().statistics())).subtypeNanos();
        }

        public static final /* synthetic */ boolean $anonfun$weak_$less$colon$less$2(Type $this, Type tp1, Type tp2) {
            return $this.scala$reflect$internal$Types$Type$$$outer().isWeakSubType(tp1, tp2);
        }

        public static final /* synthetic */ boolean $anonfun$$eq$colon$eq$1(Type $this, Type tp1, Type tp2) {
            return $this.scala$reflect$internal$Types$Type$$$outer().isSameType(tp1, tp2);
        }

        private final Scopes.Scope findMembersInternal$1(long excludedFlags$1, long requiredFlags$1) {
            return (Scopes.Scope)new FindMembers.FindMembers(this.scala$reflect$internal$Types$Type$$$outer(), this, excludedFlags$1, requiredFlags$1).apply();
        }

        public static final /* synthetic */ Symbols.Symbol $anonfun$findMember$1(Type $this, Names.Name name$1, long excludedFlags$2, long requiredFlags$2, boolean stableOnly$1, FindMembers.FindMember findMember) {
            findMember.init($this, name$1, excludedFlags$2, requiredFlags$2, stableOnly$1);
            return (Symbols.Symbol)findMember.apply();
        }

        private final Symbols.Symbol findMemberInternal$1(Names.Name name$1, long excludedFlags$2, long requiredFlags$2, boolean stableOnly$1) {
            Symbols.Symbol symbol;
            ReusableInstance<FindMembers.FindMember> reusableInstance = this.scala$reflect$internal$Types$Type$$$outer().findMemberInstance();
            if (reusableInstance == null) {
                throw null;
            }
            ReusableInstance<FindMembers.FindMember> using_this = reusableInstance;
            if (!using_this.scala$reflect$internal$util$ReusableInstance$$enabled || using_this.scala$reflect$internal$util$ReusableInstance$$taken()) {
                FindMembers.FindMember findMember = (FindMembers.FindMember)using_this.scala$reflect$internal$util$ReusableInstance$$make.apply();
                return Type.$anonfun$findMember$1(this, name$1, excludedFlags$2, requiredFlags$2, stableOnly$1, findMember);
            }
            try {
                using_this.scala$reflect$internal$util$ReusableInstance$$taken_$eq(true);
                FindMembers.FindMember findMember = using_this.scala$reflect$internal$util$ReusableInstance$$cached();
                symbol = Type.$anonfun$findMember$1(this, name$1, excludedFlags$2, requiredFlags$2, stableOnly$1, findMember);
            }
            finally {
                using_this.scala$reflect$internal$util$ReusableInstance$$taken_$eq(false);
            }
            return symbol;
        }

        public static final /* synthetic */ void $anonfun$skolemsExceptMethodTypeParams$1(ObjectRef boundSyms$1, ObjectRef skolems$1, Type t) {
            Symbols.Symbol sym;
            if (t instanceof ExistentialType) {
                List<Symbols.Symbol> quantified = ((ExistentialType)t).quantified();
                List list = (List)boundSyms$1.elem;
                boundSyms$1.elem = quantified.$colon$colon$colon(list);
                return;
            }
            if (t instanceof TypeRef && ((sym = ((TypeRef)t).sym()).isExistentialSkolem() || sym.isGADTSkolem()) && !((List)boundSyms$1.elem).contains(sym) && !((List)skolems$1.elem).contains(sym)) {
                skolems$1.elem = ((List)skolems$1.elem).$colon$colon(sym);
                return;
            }
        }

        public Type(SymbolTable $outer) {
            super($outer);
            AnnotationInfos.Annotatable.$init$(this);
        }

        public class FilterMapForeach
        extends TypeMaps.FilterTypeCollector {
            public <U> void foreach(Function1<Type, U> f) {
                Object object = this.collect(this.scala$reflect$internal$Types$Type$FilterMapForeach$$$outer());
                if (object == null) {
                    throw null;
                }
                Object foreach_these = object;
                while (!((List)foreach_these).isEmpty()) {
                    f.apply((Type)((List)foreach_these).head());
                    foreach_these = (List)((AbstractTraversable)foreach_these).tail();
                }
            }

            public <T> List<T> map(Function1<Type, T> f) {
                return ((List)this.collect(this.scala$reflect$internal$Types$Type$FilterMapForeach$$$outer())).map(f, List$.MODULE$.canBuildFrom());
            }

            public /* synthetic */ Type scala$reflect$internal$Types$Type$FilterMapForeach$$$outer() {
                return Type.this;
            }

            public FilterMapForeach(Function1<Type, Object> p) {
                if (Type.this == null) {
                    throw null;
                }
                super(Type.this.scala$reflect$internal$Types$Type$$$outer(), p);
            }
        }
    }

    public abstract class TypeApiImpl
    extends Types.TypeApi {
        public Symbols.Symbol declaration(Names.Name name) {
            return ((Type)this).decl(name);
        }

        @Override
        public Scopes.Scope declarations() {
            return ((Type)this).decls();
        }

        public List<Type> typeArguments() {
            return ((Type)this).typeArgs();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public Type erasure() {
            Type type;
            if ((Type)this instanceof ConstantType) {
                type = ((Type)this).widen().erasure();
            } else {
                void var3_2;
                Type type2;
                Types.TypeApi result2 = this.scala$reflect$internal$Types$TypeApiImpl$$$outer().transformedType((Type)this);
                Type type3 = result2.normalize();
                if (type3 instanceof PolyType) {
                    PolyType polyType = (PolyType)type3;
                    List<Symbols.Symbol> undets = polyType.typeParams();
                    Type underlying = polyType.resultType();
                    type2 = this.scala$reflect$internal$Types$TypeApiImpl$$$outer().existentialAbstraction(undets, underlying);
                } else {
                    type2 = result2;
                }
                result2 = type2;
                result2 = result2.map((Function1<Type, Type> & java.io.Serializable & Serializable)tpe -> {
                    Type type;
                    if (tpe instanceof PackageTypeRef) {
                        PackageTypeRef packageTypeRef = (PackageTypeRef)tpe;
                        type = this.scala$reflect$internal$Types$TypeApiImpl$$$outer().ThisType().apply(packageTypeRef.sym());
                    } else {
                        type = tpe;
                    }
                    return type;
                });
                type = var3_2;
            }
            return type;
        }

        public Type substituteSymbols(List<Symbols.Symbol> from, List<Symbols.Symbol> to) {
            return ((Type)this).substSym(from, to);
        }

        public Type substituteTypes(List<Symbols.Symbol> from, List<Type> to) {
            return ((Type)this).subst(from, to);
        }

        public boolean isSpliceable() {
            return this instanceof TypeRef && ((Type)this).typeSymbol().isAbstractType() && !((Type)this).typeSymbol().isExistential();
        }

        @Override
        public Type companion() {
            Symbols.Symbol sym = ((Type)this).typeSymbolDirect();
            if (sym.isModule() && !sym.hasPackageFlag()) {
                return sym.companionSymbol().tpe();
            }
            if (sym.isModuleClass() && !sym.isPackageClass()) {
                return sym.sourceModule().companionSymbol().tpe();
            }
            if (sym.isClass() && !sym.isModuleClass() && !sym.isPackageClass()) {
                return sym.companionSymbol().info();
            }
            return this.scala$reflect$internal$Types$TypeApiImpl$$$outer().NoType();
        }

        public List<List<Symbols.Symbol>> paramLists() {
            return ((Type)this).paramss();
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$TypeApiImpl$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public TypeApiImpl(SymbolTable $outer) {
            super($outer);
        }
    }

    public abstract class TypeBounds
    extends SubType
    implements Types.TypeBoundsApi,
    Serializable {
        private final Type lo;
        private final Type hi;

        @Override
        public Type lo() {
            return this.lo;
        }

        @Override
        public Type hi() {
            return this.hi;
        }

        @Override
        public Type supertype() {
            return this.hi();
        }

        @Override
        public boolean isTrivial() {
            return this.lo().isTrivial() && this.hi().isTrivial();
        }

        @Override
        public TypeBounds bounds() {
            return this;
        }

        @Override
        public Type upperBound() {
            return this.hi();
        }

        @Override
        public Type lowerBound() {
            return this.lo();
        }

        public boolean containsType(Type that) {
            boolean bl = that instanceof TypeBounds ? that.$less$colon$less(this) : this.lo().$less$colon$less(that) && that.$less$colon$less(this.hi());
            return bl;
        }

        public boolean emptyLowerBound() {
            return this.scala$reflect$internal$Types$TypeBounds$$$outer().TypeBounds().isEmptyLower(this.lo());
        }

        public boolean emptyUpperBound() {
            return this.scala$reflect$internal$Types$TypeBounds$$$outer().TypeBounds().isEmptyUpper(this.hi());
        }

        public boolean isEmptyBounds() {
            return this.emptyLowerBound() && this.emptyUpperBound();
        }

        @Override
        public String safeToString() {
            return this.scalaNotation((Function1<Type, String> & java.io.Serializable & Serializable)x$17 -> x$17.toString());
        }

        public String scalaNotation(Function1<Type, String> typeString) {
            return new StringBuilder(0).append(this.emptyLowerBound() ? "" : new StringBuilder(4).append(" >: ").append((Object)typeString.apply(this.lo())).toString()).append((Object)(this.emptyUpperBound() ? "" : new StringBuilder(4).append(" <: ").append((Object)typeString.apply(this.hi())).toString())).toString();
        }

        public String starNotation(Function1<Type, String> typeString) {
            if (this.emptyLowerBound() && this.emptyUpperBound()) {
                return "";
            }
            if (this.emptyLowerBound()) {
                return new StringBuilder(2).append("(").append((Object)typeString.apply(this.hi())).append(")").toString();
            }
            String string = "(%s, %s)";
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{typeString.apply(this.lo()), typeString.apply(this.hi())}));
        }

        @Override
        public String kind() {
            return "TypeBoundsType";
        }

        @Override
        public String productPrefix() {
            return "TypeBounds";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.lo();
                }
                case 1: {
                    return this.hi();
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
            return x$1 instanceof TypeBounds;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public boolean equals(Object x$1) {
            if (this == x$1) return true;
            if (!(x$1 instanceof TypeBounds)) return false;
            if (((TypeBounds)x$1).scala$reflect$internal$Types$TypeBounds$$$outer() != this.scala$reflect$internal$Types$TypeBounds$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            TypeBounds typeBounds = (TypeBounds)x$1;
            Type type = this.lo();
            Type type2 = typeBounds.lo();
            if (type == null) {
                if (type2 != null) {
                    return false;
                }
            } else if (!type.equals(type2)) return false;
            Type type3 = this.hi();
            Type type4 = typeBounds.hi();
            if (type3 == null) {
                if (type4 != null) {
                    return false;
                }
            } else if (!type3.equals(type4)) return false;
            if (!typeBounds.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$TypeBounds$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public TypeBounds(SymbolTable $outer, Type lo, Type hi) {
            this.lo = lo;
            this.hi = hi;
            super($outer);
        }
    }

    public class TypeError
    extends Throwable {
        private Position pos;
        private final String msg;
        public final /* synthetic */ SymbolTable $outer;

        public Position pos() {
            return this.pos;
        }

        public void pos_$eq(Position x$1) {
            this.pos = x$1;
        }

        public String msg() {
            return this.msg;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final Throwable fillInStackTrace() {
            void reflectSettingToBoolean_s;
            MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Types$TypeError$$$outer().settings().debug();
            if (MutableSettings$.MODULE$ == null) {
                throw null;
            }
            if (BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value())) {
                return super.fillInStackTrace();
            }
            return this;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$TypeError$$$outer() {
            return this.$outer;
        }

        public TypeError(SymbolTable $outer, Position pos, String msg) {
            this.pos = pos;
            this.msg = msg;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            super(msg);
        }

        public TypeError(SymbolTable $outer, String msg) {
            this($outer, $outer.NoPosition(), msg);
        }
    }

    public abstract class TypeRef
    extends UniqueType
    implements Types.TypeRefApi,
    Serializable {
        private final Type pre;
        private final Symbols.Symbol sym;
        private final List<Type> args;
        private byte trivial;
        private List<Type> parentsCache;
        private int parentsPeriod;
        private BaseTypeSeqs.BaseTypeSeq baseTypeSeqCache;
        private int baseTypeSeqPeriod;
        private volatile Type normalized;

        @Override
        public Type pre() {
            return this.pre;
        }

        @Override
        public Symbols.Symbol sym() {
            return this.sym;
        }

        public List<Type> args() {
            return this.args;
        }

        private byte trivial() {
            return this.trivial;
        }

        private void trivial_$eq(byte x$1) {
            this.trivial = x$1;
        }

        @Override
        public boolean isTrivial() {
            if (this.trivial() == 0) {
                this.trivial_$eq(ThreeValues$.MODULE$.fromBoolean(!this.sym().isTypeParameter() && this.pre().isTrivial() && this.scala$reflect$internal$Types$TypeRef$$$outer().scala$reflect$internal$Types$$areTrivialTypes(this.args())));
            }
            return ThreeValues$.MODULE$.toBoolean(this.trivial());
        }

        @Override
        public boolean isShowAsInfixType() {
            if (this.scala$reflect$internal$Types$TypeRef$$$outer().hasLength(this.args(), 2)) {
                Option<AnnotationInfos.AnnotationInfo> option = this.sym().getAnnotation(this.scala$reflect$internal$Types$TypeRef$$$outer().definitions().ShowAsInfixAnnotationClass());
                if (option == null) {
                    throw null;
                }
                Option<AnnotationInfos.AnnotationInfo> map_this = option;
                Option option2 = map_this.isEmpty() ? None$.MODULE$ : new Some<Boolean>(BoxesRunTime.boxToBoolean(TypeRef.$anonfun$isShowAsInfixType$1(map_this.get())));
                if (option2 == null) {
                    throw null;
                }
                Object object = ((Option)option2).isEmpty() ? BoxesRunTime.boxToBoolean(TypeRef.$anonfun$isShowAsInfixType$3(this)) : ((Option)option2).get();
                if (BoxesRunTime.unboxToBoolean(object)) {
                    return true;
                }
            }
            return false;
        }

        public void scala$reflect$internal$Types$$invalidateTypeRefCaches() {
            this.parentsCache_$eq(null);
            this.parentsPeriod_$eq(0);
            this.baseTypeSeqCache_$eq(null);
            this.baseTypeSeqPeriod_$eq(0);
            this.normalized_$eq(null);
        }

        public List<Type> parentsCache() {
            return this.parentsCache;
        }

        public void parentsCache_$eq(List<Type> x$1) {
            this.parentsCache = x$1;
        }

        public int parentsPeriod() {
            return this.parentsPeriod;
        }

        public void parentsPeriod_$eq(int x$1) {
            this.parentsPeriod = x$1;
        }

        public BaseTypeSeqs.BaseTypeSeq baseTypeSeqCache() {
            return this.baseTypeSeqCache;
        }

        public void baseTypeSeqCache_$eq(BaseTypeSeqs.BaseTypeSeq x$1) {
            this.baseTypeSeqCache = x$1;
        }

        public int baseTypeSeqPeriod() {
            return this.baseTypeSeqPeriod;
        }

        public void baseTypeSeqPeriod_$eq(int x$1) {
            this.baseTypeSeqPeriod = x$1;
        }

        private Type normalized() {
            return this.normalized;
        }

        private void normalized_$eq(Type x$1) {
            this.normalized = x$1;
        }

        @Override
        public final int computeHashCode() {
            int h = -889275714;
            h = MurmurHash3$.MODULE$.mix(h, this.pre().hashCode());
            h = MurmurHash3$.MODULE$.mix(h, this.sym().hashCode());
            int length = 2;
            List elems = this.args();
            while (elems != Nil$.MODULE$) {
                h = MurmurHash3$.MODULE$.mix(h, elems.head().hashCode());
                elems = (List)elems.tail();
                ++length;
            }
            return MurmurHash3$.MODULE$.finalizeHash(h, length);
        }

        @Override
        public final boolean equals(Object other) {
            boolean bl;
            if (this == other) {
                return true;
            }
            if (other instanceof TypeRef && ((TypeRef)other).scala$reflect$internal$Types$TypeRef$$$outer() == this.scala$reflect$internal$Types$TypeRef$$$outer()) {
                TypeRef typeRef = (TypeRef)other;
                bl = Objects.equals(this.pre(), typeRef.pre()) && this.sym() == typeRef.sym() && this.scala$reflect$internal$Types$TypeRef$$$outer().sameElementsEquals(this.args(), typeRef.args());
            } else {
                bl = false;
            }
            return bl;
        }

        public Type relativeInfo() {
            return this.scala$reflect$internal$Types$TypeRef$$$outer().appliedType(this.sym().info().asSeenFrom(this.pre(), this.sym().owner()), this.argsOrDummies());
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public final Type relativize(Type tp) {
            if (tp.isTrivial()) {
                return tp;
            }
            if (this.args().isEmpty()) {
                if (this.scala$reflect$internal$Types$TypeRef$$$outer().phase().erasedTypes()) return tp.asSeenFrom(this.pre(), this.sym().owner());
                if (!this.isHigherKinded()) return tp.asSeenFrom(this.pre(), this.sym().owner());
                if (this.scala$reflect$internal$Types$TypeRef$$$outer().isRawIfWithoutArgs(this.sym())) {
                    return tp.asSeenFrom(this.pre(), this.sym().owner());
                }
            }
            List<Symbols.Symbol> formals = this.sym().typeParams();
            if (!(tp instanceof PolyType)) return this.seenFromOwnerInstantiated$1(tp, formals);
            PolyType polyType = (PolyType)tp;
            List<Symbols.Symbol> list = polyType.typeParams();
            Type result2 = polyType.resultType();
            List<Symbols.Symbol> list2 = formals;
            if (list2 != null) {
                if (!((Object)list2).equals(list)) return this.seenFromOwnerInstantiated$1(tp, formals);
                return new PolyType(this.scala$reflect$internal$Types$TypeRef$$$outer(), formals, this.seenFromOwnerInstantiated$1(result2, formals));
            }
            if (list == null) return new PolyType(this.scala$reflect$internal$Types$TypeRef$$$outer(), formals, this.seenFromOwnerInstantiated$1(result2, formals));
            return this.seenFromOwnerInstantiated$1(tp, formals);
        }

        private List<Type> argsOrDummies() {
            if (this.args().isEmpty()) {
                return this.dummyArgs();
            }
            return this.args();
        }

        @Override
        public final Type baseType(Symbols.Symbol clazz) {
            if (clazz == this.sym()) {
                return this;
            }
            if (this.sym().isClass()) {
                return this.relativize(this.sym().info().baseType(clazz));
            }
            return this.baseTypeOfNonClassTypeRef(clazz);
        }

        private Type baseTypeOfNonClassTypeRef(Symbols.Symbol clazz) {
            Type type;
            try {
                this.scala$reflect$internal$Types$TypeRef$$$outer().basetypeRecursions_$eq(this.scala$reflect$internal$Types$TypeRef$$$outer().basetypeRecursions() + 1);
                type = this.scala$reflect$internal$Types$TypeRef$$$outer().basetypeRecursions() >= 50 ? this.baseTypeOfNonClassTypeRefLogged(clazz) : this.relativeInfo().baseType(clazz);
            }
            finally {
                this.scala$reflect$internal$Types$TypeRef$$$outer().basetypeRecursions_$eq(this.scala$reflect$internal$Types$TypeRef$$$outer().basetypeRecursions() - 1);
            }
            return type;
        }

        private Type baseTypeOfNonClassTypeRefLogged(Symbols.Symbol clazz) {
            if (this.scala$reflect$internal$Types$TypeRef$$$outer().pendingBaseTypes().add(this)) {
                Type type;
                try {
                    type = this.relativeInfo().baseType(clazz);
                }
                finally {
                    this.scala$reflect$internal$Types$TypeRef$$$outer().pendingBaseTypes().remove(this);
                }
                return type;
            }
            if (clazz == this.scala$reflect$internal$Types$TypeRef$$$outer().definitions().AnyClass()) {
                return this.scala$reflect$internal$Types$TypeRef$$$outer().definitions().AnyTpe();
            }
            return this.scala$reflect$internal$Types$TypeRef$$$outer().NoType();
        }

        public Type normalizeImpl() {
            if (this.isHigherKinded()) {
                return this.etaExpand();
            }
            return super.normalize();
        }

        @Override
        public final Type normalize() {
            if (this.pre() == this.scala$reflect$internal$Types$TypeRef$$$outer().WildcardType()) {
                return this.scala$reflect$internal$Types$TypeRef$$$outer().WildcardType();
            }
            if (this.scala$reflect$internal$Types$TypeRef$$$outer().phase().erasedTypes()) {
                return this.normalizeImpl();
            }
            if (this.normalized() == null) {
                this.scala$reflect$internal$Types$TypeRef$$$outer().defineNormalized(this);
            }
            return this.normalized();
        }

        public final void scala$reflect$internal$Types$$defineNormalized() {
            if (this.normalized() == null) {
                this.normalized_$eq(this.normalizeImpl());
            }
        }

        @Override
        public boolean isGround() {
            block9: {
                block8: {
                    boolean bl;
                    block7: {
                        if (this.sym().isPackageClass()) break block8;
                        if (!this.pre().isGround()) break block9;
                        List<Type> list = this.args();
                        if (list == null) {
                            throw null;
                        }
                        LinearSeqOptimized forall_these = list;
                        while (!forall_these.isEmpty()) {
                            if (!((Type)forall_these.head()).isGround()) {
                                bl = false;
                                break block7;
                            }
                            forall_these = (LinearSeqOptimized)forall_these.tail();
                        }
                        bl = true;
                    }
                    if (!bl) break block9;
                }
                return true;
            }
            return false;
        }

        @Override
        public final Type etaExpand() {
            List<Symbols.Symbol> tpars = this.initializedTypeParams();
            if (tpars.isEmpty()) {
                return this;
            }
            return this.scala$reflect$internal$Types$TypeRef$$$outer().typeFunAnon(tpars, this.scala$reflect$internal$Types$TypeRef$$$outer().copyTypeRef(this, this.pre(), this.sym(), tpars.map((Function1<Symbols.Symbol, Type> & java.io.Serializable & Serializable)x$29 -> x$29.tpeHK(), List$.MODULE$.canBuildFrom())));
        }

        public Symbols.Symbol coevolveSym(Type pre1) {
            return this.sym();
        }

        public List<Symbols.Symbol> initializedTypeParams() {
            return this.sym().info().typeParams();
        }

        public boolean typeParamsMatchArgs() {
            return this.scala$reflect$internal$Types$TypeRef$$$outer().sameLength(this.initializedTypeParams(), this.args());
        }

        @Override
        public int baseTypeSeqDepth() {
            return this.baseTypeSeq().maxDepth();
        }

        @Override
        public Type prefix() {
            return this.pre();
        }

        @Override
        public Symbols.Symbol termSymbol() {
            return super.termSymbol();
        }

        @Override
        public Symbols.Symbol termSymbolDirect() {
            return super.termSymbol();
        }

        @Override
        public List<Type> typeArgs() {
            return this.args();
        }

        @Override
        public Type typeOfThis() {
            return this.relativize(this.sym().typeOfThis());
        }

        @Override
        public Symbols.Symbol typeSymbol() {
            return this.sym();
        }

        @Override
        public Symbols.Symbol typeSymbolDirect() {
            return this.sym();
        }

        @Override
        public List<Type> parents() {
            List<Type> cache = this.parentsCache();
            if (this.parentsPeriod() == this.scala$reflect$internal$Types$TypeRef$$$outer().currentPeriod() && cache != null) {
                return cache;
            }
            this.scala$reflect$internal$Types$TypeRef$$$outer().defineParentsOfTypeRef(this);
            return this.parentsCache();
        }

        public List<Type> parentsImpl() {
            return this.sym().info().parents().map((Function1<Type, Type> & java.io.Serializable & Serializable)tp -> this.relativize((Type)tp), List$.MODULE$.canBuildFrom());
        }

        @Override
        public List<Symbols.Symbol> baseClasses() {
            return this.sym().info().baseClasses();
        }

        @Override
        public Scopes.Scope decls() {
            return this.sym().info().decls();
        }

        public BaseTypeSeqs.BaseTypeSeq baseTypeSeqImpl() {
            if (this.sym().info().baseTypeSeq().exists((Function1<Type, Object> & java.io.Serializable & Serializable)(Type x$30) -> BoxesRunTime.boxToBoolean(TypeRef.$anonfun$baseTypeSeqImpl$1(x$30)))) {
                return this.relativize(this.sym().info()).baseTypeSeq();
            }
            return this.sym().info().baseTypeSeq().map((Function1<Type, Type> & java.io.Serializable & Serializable)(Type tp) -> this.relativize((Type)tp));
        }

        @Override
        public BaseTypeSeqs.BaseTypeSeq baseTypeSeq() {
            BaseTypeSeqs.BaseTypeSeq cache = this.baseTypeSeqCache();
            if (this.baseTypeSeqPeriod() == this.scala$reflect$internal$Types$TypeRef$$$outer().currentPeriod() && cache != null && !cache.equals(this.scala$reflect$internal$Types$TypeRef$$$outer().undetBaseTypeSeq())) {
                return cache;
            }
            this.scala$reflect$internal$Types$TypeRef$$$outer().defineBaseTypeSeqOfTypeRef(this);
            BaseTypeSeqs.BaseTypeSeq baseTypeSeq = this.baseTypeSeqCache();
            BaseTypeSeqs.BaseTypeSeq baseTypeSeq2 = this.scala$reflect$internal$Types$TypeRef$$$outer().undetBaseTypeSeq();
            if (!(baseTypeSeq != null ? !baseTypeSeq.equals(baseTypeSeq2) : baseTypeSeq2 != null)) {
                throw new RecoverableCyclicReference(this.scala$reflect$internal$Types$TypeRef$$$outer(), this.sym());
            }
            return this.baseTypeSeqCache();
        }

        /*
         * WARNING - void declaration
         */
        private boolean needsPreString() {
            void reflectSettingToBoolean_s;
            MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Types$TypeRef$$$outer().settings().debug();
            if (MutableSettings$.MODULE$ == null) {
                throw null;
            }
            return BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value()) || !this.scala$reflect$internal$Types$TypeRef$$$outer().shorthands().apply(this.sym().fullName()) || this.sym().ownersIterator().exists((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)(A s) -> BoxesRunTime.boxToBoolean(TypeRef.$anonfun$needsPreString$1(s)));
        }

        private String preString() {
            if (this.needsPreString()) {
                return this.pre().prefixString();
            }
            return "";
        }

        private String argsString() {
            if (this.args().isEmpty()) {
                return "";
            }
            return this.args().mkString("[", ",", "]");
        }

        @Override
        public String nameAndArgsString() {
            return new StringBuilder(0).append(this.typeSymbol().name().toString()).append(this.argsString()).toString();
        }

        private Scopes.Scope refinementDecls() {
            return this.scala$reflect$internal$Types$TypeRef$$$outer().definitions().fullyInitializeScope(this.decls()).filter((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)sym -> BoxesRunTime.boxToBoolean(TypeRef.$anonfun$refinementDecls$1(sym)));
        }

        private String refinementString() {
            if (this.sym().isStructuralRefinement()) {
                return ((TraversableOnce)this.refinementDecls().map((Function1<Symbols.Symbol, String> & java.io.Serializable & Serializable)x$31 -> x$31.defString(), Iterable$.MODULE$.canBuildFrom())).mkString("{", "; ", "}");
            }
            return "";
        }

        public String finishPrefix(String rest) {
            if (this.sym().isInitialized() && this.sym().isAnonymousClass() && !this.scala$reflect$internal$Types$TypeRef$$$outer().phase().erasedTypes()) {
                return new StringBuilder(0).append(this.scala$reflect$internal$Types$TypeRef$$$outer().definitions().parentsString(this.sym().info().parents())).append(this.refinementString()).toString();
            }
            return rest;
        }

        private String noArgsString() {
            return this.finishPrefix(new StringBuilder(0).append(this.preString()).append(this.sym().nameString()).toString());
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private String tupleTypeString() {
            List<Type> list = this.args();
            if (((Object)Nil$.MODULE$).equals(list)) {
                return this.noArgsString();
            }
            if (!(list instanceof $colon$colon)) return this.args().mkString("(", ", ", ")");
            $colon$colon $colon$colon = ($colon$colon)list;
            Type arg = (Type)$colon$colon.head();
            List list2 = $colon$colon.tl$access$1();
            if (!((Object)Nil$.MODULE$).equals(list2)) return this.args().mkString("(", ", ", ")");
            return new StringBuilder(3).append("(").append(arg).append(",)").toString();
        }

        /*
         * WARNING - void declaration
         */
        private String infixTypeString() {
            void var6_6;
            void var3_3;
            block3: {
                List<Type> list;
                block2: {
                    list = this.args();
                    if (!(list instanceof $colon$colon)) break block2;
                    $colon$colon $colon$colon = ($colon$colon)list;
                    Type l = (Type)$colon$colon.head();
                    List list2 = $colon$colon.tl$access$1();
                    if (!(list2 instanceof $colon$colon)) break block2;
                    $colon$colon $colon$colon2 = ($colon$colon)list2;
                    Type r = (Type)$colon$colon2.head();
                    List list3 = $colon$colon2.tl$access$1();
                    if (((Object)Nil$.MODULE$).equals(list3)) break block3;
                }
                throw new MatchError(list);
            }
            void l = var3_3;
            void r = var6_6;
            boolean isRightAssoc = this.typeSymbol().decodedName().endsWith(":");
            String lstr = isRightAssoc && l.isShowAsInfixType() ? new StringBuilder(2).append("(").append(l).append(")").toString() : l.toString();
            String rstr = !isRightAssoc && r.isShowAsInfixType() ? new StringBuilder(2).append("(").append(r).append(")").toString() : r.toString();
            return new StringBuilder(2).append(lstr).append(" ").append(this.sym().decodedName()).append(" ").append(rstr).toString();
        }

        /*
         * Unable to fully structure code
         * Could not resolve type clashes
         */
        private String customToString() {
            block11: {
                block16: {
                    block9: {
                        block18: {
                            block17: {
                                block13: {
                                    block15: {
                                        block14: {
                                            block12: {
                                                block10: {
                                                    var4_1 = this.sym();
                                                    v0 = this.scala$reflect$internal$Types$TypeRef$$$outer().definitions().RepeatedParamClass();
                                                    if (!(v0 != null ? v0.equals(var4_1) == false : var4_1 != null)) {
                                                        var3_2 = true;
                                                    } else {
                                                        v1 = this.scala$reflect$internal$Types$TypeRef$$$outer().definitions().JavaRepeatedParamClass();
                                                        var3_2 = !(v1 != null ? v1.equals(var4_1) == false : var4_1 != null);
                                                    }
                                                    if (!var3_2) break block10;
                                                    var1_3 = Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(this.args().head()), "*");
                                                    break block11;
                                                }
                                                v2 = this.scala$reflect$internal$Types$TypeRef$$$outer().definitions().ByNameParamClass();
                                                if (v2 != null ? v2.equals(var4_1) == false : var4_1 != null) break block12;
                                                var1_3 = new StringBuilder(3).append("=> ").append(this.args().head()).toString();
                                                break block11;
                                            }
                                            if (!this.scala$reflect$internal$Types$TypeRef$$$outer().definitions().isFunctionTypeDirect(this)) break block13;
                                            var5_4 = this.scala$reflect$internal$Types$TypeRef$$$outer().definitions().unspecializedTypeArgs(this);
                                            if (!Nil$.MODULE$.equals(var5_4)) break block14;
                                            var2_5 = this.noArgsString();
                                            break block15;
                                        }
                                        if (!(var5_4 instanceof $colon$colon)) ** GOTO lbl-1000
                                        var6_6 = ($colon$colon)var5_4;
                                        in = (Type)var6_6.head();
                                        var8_8 = var6_6.tl$access$1();
                                        if (!(var8_8 instanceof $colon$colon)) ** GOTO lbl-1000
                                        var9_9 = ($colon$colon)var8_8;
                                        out = (Type)var9_9.head();
                                        var11_11 = var9_9.tl$access$1();
                                        if (Nil$.MODULE$.equals(var11_11) && !this.scala$reflect$internal$Types$TypeRef$$$outer().definitions().isTupleTypeDirect(in)) {
                                            in_s = this.scala$reflect$internal$Types$TypeRef$$$outer().definitions().isFunctionTypeDirect(in) != false || this.scala$reflect$internal$Types$TypeRef$$$outer().definitions().isByNameParamType(in) != false ? new StringBuilder(2).append("(").append(in).append(")").toString() : String.valueOf(in);
                                            out_s = this.scala$reflect$internal$Types$TypeRef$$$outer().definitions().isFunctionTypeDirect(out) != false ? new StringBuilder(2).append("(").append(out).append(")").toString() : String.valueOf(out);
                                            var2_5 = new StringBuilder(4).append(in_s).append(" => ").append(out_s).toString();
                                        } else lbl-1000:
                                        // 3 sources

                                        {
                                            var2_5 = new StringBuilder(4).append(((TraversableOnce)var5_4.init()).mkString("(", ", ", ")")).append(" => ").append(var5_4.last()).toString();
                                        }
                                    }
                                    v3 = var2_5;
                                    break block16;
                                }
                                if (!this.isShowAsInfixType()) break block17;
                                v3 = this.infixTypeString();
                                break block16;
                            }
                            if (!this.scala$reflect$internal$Types$TypeRef$$$outer().definitions().isTupleTypeDirect(this)) break block18;
                            v3 = this.tupleTypeString();
                            break block16;
                        }
                        if (!this.sym().isAliasType()) ** GOTO lbl-1000
                        v4 = this.prefixChain();
                        if (v4 == null) {
                            throw null;
                        }
                        exists_these /* !! */  = v4;
                        while (!exists_these /* !! */ .isEmpty()) {
                            if (TypeRef.$anonfun$customToString$1((Type)exists_these /* !! */ .head())) {
                                var15_15 = true;
                                break block9;
                            }
                            exists_these /* !! */  = (LinearSeqOptimized)exists_these /* !! */ .tail();
                        }
                        var15_15 = false;
                    }
                    if (var15_15 && this != this.dealias()) {
                        v3 = String.valueOf(this.dealias());
                    } else lbl-1000:
                    // 2 sources

                    {
                        v3 = "";
                    }
                }
                var1_3 = v3;
            }
            return var1_3;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public String safeToString() {
            void reflectSettingToBoolean_s;
            String custom;
            MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Types$TypeRef$$$outer().settings().debug();
            if (MutableSettings$.MODULE$ == null) {
                throw null;
            }
            String string = custom = BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value()) ? "" : this.customToString();
            String string2 = "";
            if (string == null || !string.equals(string2)) {
                return custom;
            }
            return this.finishPrefix(new StringBuilder(0).append(this.preString()).append(this.sym().nameString()).append(this.argsString()).toString());
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public String prefixString() {
            void reflectSettingToBoolean_s;
            MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Types$TypeRef$$$outer().settings().debug();
            if (MutableSettings$.MODULE$ == null) {
                throw null;
            }
            return String.valueOf(BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value()) ? super.prefixString() : (this.sym().isOmittablePrefix() ? "" : (this.sym().isPackageClass() || this.sym().isPackageObjectOrClass() ? new StringBuilder(1).append(this.sym().skipPackageObject().fullName()).append(".").toString() : (this.isStable() && this.scala$reflect$internal$Types$TypeRef$$$outer().nme().isSingletonName(this.sym().name()) ? Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(this.scala$reflect$internal$Types$TypeRef$$$outer().tpnme().dropSingletonName(this.sym().name())), ".") : super.prefixString()))));
        }

        private Null$ copy() {
            return null;
        }

        @Override
        public String kind() {
            return "TypeRef";
        }

        @Override
        public String productPrefix() {
            return "TypeRef";
        }

        @Override
        public int productArity() {
            return 3;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.pre();
                }
                case 1: {
                    return this.sym();
                }
                case 2: {
                    return this.args();
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
            return x$1 instanceof TypeRef;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$TypeRef$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public static final /* synthetic */ boolean $anonfun$isShowAsInfixType$2() {
            return true;
        }

        public static final /* synthetic */ boolean $anonfun$isShowAsInfixType$1(AnnotationInfos.AnnotationInfo x$27) {
            Option<Object> option = x$27.booleanArg(0);
            if (option == null) {
                throw null;
            }
            Option<Object> getOrElse_this = option;
            Object object = getOrElse_this.isEmpty() ? BoxesRunTime.boxToBoolean(TypeRef.$anonfun$isShowAsInfixType$2()) : getOrElse_this.get();
            return BoxesRunTime.unboxToBoolean(object);
        }

        public static final /* synthetic */ boolean $anonfun$isShowAsInfixType$3(TypeRef $this) {
            String string = $this.sym().decodedName();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return !Character.isUnicodeIdentifierStart(BoxesRunTime.unboxToChar(new StringOps(string).head()));
        }

        private final Type seenFromOwnerInstantiated$1(Type tp, List formals$2) {
            return tp.asSeenFrom(this.pre(), this.sym().owner()).instantiateTypeParams(formals$2, this.argsOrDummies());
        }

        public static final /* synthetic */ boolean $anonfun$baseTypeSeqImpl$1(Type x$30) {
            return x$30.typeSymbolDirect().isAbstractType();
        }

        public static final /* synthetic */ boolean $anonfun$needsPreString$1(Symbols.Symbol s) {
            return !s.isClass();
        }

        public static final /* synthetic */ boolean $anonfun$refinementDecls$1(Symbols.Symbol sym) {
            return sym.isPossibleInRefinement() && sym.isPublic();
        }

        public static final /* synthetic */ boolean $anonfun$customToString$1(Type x$33) {
            return x$33.termSymbol().isSynthetic();
        }

        public TypeRef(SymbolTable $outer, Type pre, Symbols.Symbol sym, List<Type> args2) {
            this.pre = pre;
            this.sym = sym;
            this.args = args2;
            super($outer);
            this.trivial = 0;
            this.parentsPeriod = 0;
            this.baseTypeSeqPeriod = 0;
        }

        public static final /* synthetic */ Object $anonfun$isShowAsInfixType$1$adapted(AnnotationInfos.AnnotationInfo x$27) {
            return BoxesRunTime.boxToBoolean(TypeRef.$anonfun$isShowAsInfixType$1(x$27));
        }

        public static final /* synthetic */ Object $anonfun$isGround$1$adapted(Type x$28) {
            return BoxesRunTime.boxToBoolean(x$28.isGround());
        }

        public static final /* synthetic */ Object $anonfun$customToString$1$adapted(Type x$33) {
            return BoxesRunTime.boxToBoolean(TypeRef.$anonfun$customToString$1(x$33));
        }
    }

    public class TypeUnwrapper
    implements Function1<Type, Type> {
        private final boolean poly;
        private final boolean existential;
        private final boolean annotated;
        private final boolean nullary;
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
        public <A> Function1<A, Type> compose(Function1<A, Type> g) {
            return Function1.compose$(this, g);
        }

        @Override
        public <A> Function1<Type, A> andThen(Function1<Type, A> g) {
            return Function1.andThen$(this, g);
        }

        @Override
        public String toString() {
            return Function1.toString$(this);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public Type apply(Type tp) {
            if (tp instanceof AnnotatedType) {
                Type underlying = ((AnnotatedType)tp).underlying();
                if (this.annotated) {
                    return this.apply(underlying);
                }
            }
            if (tp instanceof ExistentialType) {
                Type underlying = ((ExistentialType)tp).underlying();
                if (this.existential) {
                    return this.apply(underlying);
                }
            }
            if (tp instanceof PolyType) {
                Type underlying = ((PolyType)tp).resultType();
                if (this.poly) {
                    return this.apply(underlying);
                }
            }
            if (!(tp instanceof NullaryMethodType)) return tp;
            Type underlying = ((NullaryMethodType)tp).resultType();
            if (!this.nullary) return tp;
            return this.apply(underlying);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$TypeUnwrapper$$$outer() {
            return this.$outer;
        }

        public TypeUnwrapper(SymbolTable $outer, boolean poly, boolean existential, boolean annotated, boolean nullary) {
            this.poly = poly;
            this.existential = existential;
            this.annotated = annotated;
            this.nullary = nullary;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public abstract class TypeVar
    extends Type
    implements Product,
    Serializable {
        private final Type origin;
        private TypeConstraints.TypeConstraint constr;
        private final int level;
        private Type _suspended;

        public Type origin() {
            return this.origin;
        }

        public TypeConstraints.TypeConstraint constr() {
            return this.constr;
        }

        public void constr_$eq(TypeConstraints.TypeConstraint x$1) {
            this.constr = x$1;
        }

        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override
        public boolean equals(Object other) {
            return this == other;
        }

        public boolean untouchable() {
            return false;
        }

        @Override
        public List<Symbols.Symbol> params() {
            return Nil$.MODULE$;
        }

        @Override
        public List<Type> typeArgs() {
            return Nil$.MODULE$;
        }

        @Override
        public boolean isHigherKinded() {
            return false;
        }

        public boolean instValid() {
            return this.constr().instValid();
        }

        public Type inst() {
            return this.constr().inst();
        }

        public boolean instWithinBounds() {
            return this.constr().instWithinBounds();
        }

        @Override
        public boolean isGround() {
            return this.instValid() && this.inst().isGround();
        }

        public int level() {
            return this.level;
        }

        /*
         * WARNING - void declaration
         */
        public TypeVar applyArgs(List<Type> newArgs) {
            if (newArgs.isEmpty() && this.typeArgs().isEmpty()) {
                return this;
            }
            if (newArgs.size() == this.params().size()) {
                void var2_2;
                TypeVar tv = this.scala$reflect$internal$Types$TypeVar$$$outer().TypeVar().apply(this.origin(), this.constr(), newArgs, this.params());
                tv.scala$reflect$internal$Types$$linkSuspended(this);
                if (this.scala$reflect$internal$Types$TypeVar$$$outer().TypeVar() == null) {
                    throw null;
                }
                return var2_2;
            }
            return this.scala$reflect$internal$Types$TypeVar$$$outer().TypeVar().apply(this.typeSymbol()).setInst(this.scala$reflect$internal$Types$TypeVar$$$outer().ErrorType());
        }

        public TypeVar setInst(Type tp) {
            if (tp != this) {
                this.scala$reflect$internal$Types$TypeVar$$$outer().undoLog().record(this);
                if (this.scala$reflect$internal$Types$TypeVar$$$outer().TypeVar() == null) {
                    throw null;
                }
                this.constr().inst_$eq(tp);
                return this;
            }
            this.scala$reflect$internal$Types$TypeVar$$$outer().log((Function0<Object>)(Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(49).append("TypeVar cycle: called setInst passing ").append(this).append(" to itself.").toString());
            return this;
        }

        /*
         * WARNING - void declaration
         */
        public void addLoBound(Type tp, boolean isNumericBound) {
            void assert_assertion;
            boolean bl;
            SymbolTable symbolTable = this.scala$reflect$internal$Types$TypeVar$$$outer();
            Type type = tp;
            boolean bl2 = bl = type == null || !type.equals(this);
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable assert_this = symbolTable;
            if (assert_assertion == false) {
                throw assert_this.throwAssertionError(tp);
            }
            if (!this.sharesConstraints(tp)) {
                this.scala$reflect$internal$Types$TypeVar$$$outer().undoLog().record(this);
                this.constr().addLoBound(tp, isNumericBound);
            }
        }

        public boolean addLoBound$default$2() {
            return false;
        }

        public void addHiBound(Type tp, boolean isNumericBound) {
            if (!this.sharesConstraints(tp)) {
                this.scala$reflect$internal$Types$TypeVar$$$outer().undoLog().record(this);
                this.constr().addHiBound(tp, isNumericBound);
            }
        }

        public boolean addHiBound$default$2() {
            return false;
        }

        private Type _suspended() {
            return this._suspended;
        }

        private void _suspended_$eq(Type x$1) {
            this._suspended = x$1;
        }

        public boolean scala$reflect$internal$Types$$suspended() {
            boolean bl;
            Type type = this._suspended();
            UniqueConstantType uniqueConstantType = this.scala$reflect$internal$Types$TypeVar$$$outer().definitions().ConstantFalse();
            if (!(uniqueConstantType != null ? !((Object)uniqueConstantType).equals(type) : type != null)) {
                bl = false;
            } else {
                UniqueConstantType uniqueConstantType2 = this.scala$reflect$internal$Types$TypeVar$$$outer().definitions().ConstantTrue();
                if (!(uniqueConstantType2 != null ? !((Object)uniqueConstantType2).equals(type) : type != null)) {
                    bl = true;
                } else if (type instanceof TypeVar) {
                    bl = ((TypeVar)type).scala$reflect$internal$Types$$suspended();
                } else {
                    throw new MatchError(type);
                }
            }
            return bl;
        }

        public final boolean sharesConstraints(Type other) {
            boolean bl;
            if (other instanceof TypeVar) {
                TypeVar typeVar = (TypeVar)other;
                TypeConstraints.TypeConstraint typeConstraint = this.constr();
                TypeConstraints.TypeConstraint typeConstraint2 = typeVar.constr();
                bl = !(typeConstraint != null ? !typeConstraint.equals(typeConstraint2) : typeConstraint2 != null);
            } else {
                bl = false;
            }
            return bl;
        }

        public void scala$reflect$internal$Types$$suspended_$eq(boolean b) {
            this._suspended_$eq(b ? this.scala$reflect$internal$Types$TypeVar$$$outer().definitions().ConstantTrue() : this.scala$reflect$internal$Types$TypeVar$$$outer().definitions().ConstantFalse());
        }

        public void scala$reflect$internal$Types$$linkSuspended(TypeVar origin) {
            this._suspended_$eq(origin);
        }

        public boolean registerBound(Type tp, boolean isLowerBound, boolean isNumericBound) {
            block11: {
                block12: {
                    boolean bl;
                    block10: {
                        if (isLowerBound) {
                            Type type = tp;
                            this.scala$reflect$internal$Types$TypeVar$$$outer().assert(type == null || !type.equals(this));
                        }
                        if (this.scala$reflect$internal$Types$$suspended()) {
                            return TypeVar.checkSubtype$1(tp, this.origin(), isLowerBound, isNumericBound);
                        }
                        if (this.instValid()) {
                            return TypeVar.checkSubtype$1(tp, this.inst(), isLowerBound, isNumericBound);
                        }
                        if (!this.isRelatable(tp)) break block11;
                        if (this.unifySimple$1(tp, isLowerBound, isNumericBound) || this.unifyFull$1(tp, isLowerBound, isNumericBound)) break block12;
                        if (!isLowerBound) break block11;
                        List<Type> list = tp.parents();
                        if (list == null) {
                            throw null;
                        }
                        LinearSeqOptimized exists_these = list;
                        while (!exists_these.isEmpty()) {
                            Type type = (Type)exists_these.head();
                            if (this.unifyFull$1(type, isLowerBound, isNumericBound)) {
                                bl = true;
                                break block10;
                            }
                            exists_these = (LinearSeqOptimized)exists_these.tail();
                        }
                        bl = false;
                    }
                    if (!bl && !tp.baseTypeSeq().toIterator().drop(1).exists((Function1<Type, Object> & java.io.Serializable & Serializable)(A bt) -> BoxesRunTime.boxToBoolean(TypeVar.$anonfun$registerBound$5(this, tp, isLowerBound, isNumericBound, bt)))) break block11;
                }
                return true;
            }
            return false;
        }

        public boolean registerBound$default$3() {
            return false;
        }

        public boolean registerTypeEquality(Type tp, boolean typeVarLHS) {
            if (this.scala$reflect$internal$Types$$suspended()) {
                return tp.$eq$colon$eq(this.origin());
            }
            if (this.instValid()) {
                return this.checkIsSameType$1(tp, typeVarLHS);
            }
            if (this.isRelatable(tp)) {
                boolean bl;
                Type newInst = this.scala$reflect$internal$Types$TypeVar$$$outer().wildcardToTypeVarMap().apply(tp);
                if (this.constr().isWithinBounds(newInst)) {
                    this.setInst(newInst);
                    bl = true;
                } else {
                    bl = false;
                }
                if (bl) {
                    return true;
                }
            }
            return false;
        }

        public boolean registerTypeSelection(Symbols.Symbol sym, Type tp) {
            return this.registerBound(this.scala$reflect$internal$Types$TypeVar$$$outer().HasTypeMember().apply(sym.name().toTypeName(), tp), false, this.registerBound$default$3());
        }

        private boolean isSkolemAboveLevel(Type tp) {
            Symbols.Symbol symbol = tp.typeSymbol();
            boolean bl = symbol instanceof Symbols.TypeSkolem ? ((Symbols.TypeSkolem)symbol).level() > this.level() : false;
            return bl;
        }

        public boolean isRelatable(Type tp2) {
            return !tp2.exists((Function1<Type, Object> & java.io.Serializable & Serializable)(Type tp) -> BoxesRunTime.boxToBoolean(this.isSkolemAboveLevel(tp)));
        }

        @Override
        public Type normalize() {
            if (this.instValid()) {
                return this.inst();
            }
            if (this.isHigherKinded()) {
                return this.etaExpand();
            }
            return super.normalize();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public Type etaExpand() {
            void logResult_result;
            void logResult_msg;
            if (!this.isHigherKinded()) {
                return this;
            }
            SymbolTable symbolTable = this.scala$reflect$internal$Types$TypeVar$$$outer();
            Type type = this.scala$reflect$internal$Types$TypeVar$$$outer().typeFun(this.params(), this.applyArgs(this.params().map((Function1<Symbols.Symbol, Type> & java.io.Serializable & Serializable)x$47 -> x$47.typeConstructor(), List$.MODULE$.canBuildFrom())));
            Function0<String> & java.io.Serializable & Serializable intersect = (Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(15).append("Normalizing HK ").append(this).toString();
            if (symbolTable == null) {
                throw null;
            }
            symbolTable.log((Function0<Object>)((Function0<String> & java.io.Serializable & Serializable)() -> SymbolTable.$anonfun$logResult$1((Function0)logResult_msg, logResult_result)));
            return type;
        }

        @Override
        public Symbols.Symbol typeSymbol() {
            return this.origin().typeSymbol();
        }

        private String tparamsOfSym(Symbols.Symbol sym) {
            List<Symbols.Symbol> tparams;
            Type type = sym.info();
            String string = type instanceof PolyType && (tparams = ((PolyType)type).typeParams()).nonEmpty() ? ((TraversableOnce)tparams.map((Function1<Symbols.Symbol, String> & java.io.Serializable & Serializable)x$48 -> x$48.defString(), List$.MODULE$.canBuildFrom())).mkString("[", ",", "]") : "";
            return string;
        }

        public String originName() {
            return this.origin().typeSymbolDirect().decodedName();
        }

        /*
         * Enabled aggressive block sorting
         */
        public String originLocation() {
            Option option;
            Symbols.Symbol sym = this.origin().typeSymbolDirect();
            Symbols.Symbol encl = sym.owner().logicallyEnclosingMember();
            Some<Symbols.Symbol> some = new Some<Symbols.Symbol>(encl.enclClass());
            Option option2 = encl.isMethod() ? new Some<Symbols.Symbol>(encl) : None$.MODULE$;
            if (sym.owner().isTerm()) {
                Symbols.Symbol symbol = sym.owner();
                if (symbol == null || !symbol.equals(encl)) {
                    option = new Some<Symbols.Symbol>(sym.owner());
                    return ((TraversableOnce)((List)GenericTraversableTemplate.flatten$(new $colon$colon<Nothing$>((Nothing$)((Object)some), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)option2), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)option), Nil$.MODULE$))), (Function1<Option, Iterable> & java.io.Serializable & Serializable)xo -> Option$.MODULE$.option2Iterable(xo))).map((Function1<Symbols.Symbol, String> & java.io.Serializable & Serializable)s -> new StringBuilder(0).append(s.decodedName()).append(this.tparamsOfSym((Symbols.Symbol)s)).toString(), List$.MODULE$.canBuildFrom())).mkString("#");
                }
            }
            option = None$.MODULE$;
            return ((TraversableOnce)((List)GenericTraversableTemplate.flatten$(new $colon$colon<Nothing$>((Nothing$)((Object)some), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)option2), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)option), Nil$.MODULE$))), (Function1<Option, Iterable> & java.io.Serializable & Serializable)xo -> Option$.MODULE$.option2Iterable(xo))).map((Function1<Symbols.Symbol, String> & java.io.Serializable & Serializable)s -> new StringBuilder(0).append(s.decodedName()).append(this.tparamsOfSym((Symbols.Symbol)s)).toString(), List$.MODULE$.canBuildFrom())).mkString("#");
        }

        /*
         * WARNING - void declaration
         */
        private Object levelString() {
            void reflectSettingToBoolean_s;
            MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Types$TypeVar$$$outer().settings().explaintypes();
            if (MutableSettings$.MODULE$ == null) {
                throw null;
            }
            if (BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value())) {
                return BoxesRunTime.boxToInteger(this.level());
            }
            return "";
        }

        @Override
        public String safeToString() {
            if (this.constr() == null || this.inst() == null) {
                return new StringBuilder(11).append("TVar<").append(this.originName()).append("=null>").toString();
            }
            if (this.inst() != this.scala$reflect$internal$Types$TypeVar$$$outer().NoType()) {
                return new StringBuilder(2).append("=?").append(this.inst()).toString();
            }
            return new StringBuilder(0).append(this.untouchable() ? "!?" : "?").append(this.levelString()).append(this.originName()).toString();
        }

        public String originString() {
            return new StringBuilder(4).append(this.originName()).append(" in ").append(this.originLocation()).toString();
        }

        @Override
        public String kind() {
            return "TypeVar";
        }

        /*
         * WARNING - void declaration
         */
        public TypeVar cloneInternal() {
            void assert_assertion;
            boolean bl;
            SymbolTable symbolTable = this.scala$reflect$internal$Types$TypeVar$$$outer();
            boolean bl2 = bl = !this.scala$reflect$internal$Types$$suspended();
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable assert_this = symbolTable;
            if (assert_assertion == false) {
                throw assert_this.throwAssertionError(this);
            }
            TypeVar typeVar = this.scala$reflect$internal$Types$TypeVar$$$outer().TypeVar().apply(this.origin(), this.constr().cloneInternal(), this.typeArgs(), this.params());
            if (this.scala$reflect$internal$Types$TypeVar$$$outer().TypeVar() == null) {
                throw null;
            }
            return typeVar;
        }

        @Override
        public String productPrefix() {
            return "TypeVar";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.origin();
                }
                case 1: {
                    return this.constr();
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
            return x$1 instanceof TypeVar;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$TypeVar$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public static final /* synthetic */ String $anonfun$applyArgs$1(TypeVar $this, List newArgs$1) {
            return new StringBuilder(20).append("In ").append($this.originLocation()).append(", apply args ").append(newArgs$1.mkString(", ")).append(" to ").append($this.originName()).toString();
        }

        public static final /* synthetic */ String $anonfun$setInst$1(TypeVar $this, Type tp$3) {
            return new StringBuilder(6).append("In ").append($this.originLocation()).append(", ").append($this.originName()).append("=").append(tp$3).toString();
        }

        private final void addBound$1(Type tp, boolean isLowerBound$1, boolean isNumericBound$1) {
            if (isLowerBound$1) {
                this.addLoBound(tp, isNumericBound$1);
                return;
            }
            this.addHiBound(tp, isNumericBound$1);
        }

        private static final boolean checkSubtype$1(Type tp1, Type tp2, boolean isLowerBound$1, boolean isNumericBound$1) {
            Type rhs;
            Type lhs = isLowerBound$1 ? tp1 : tp2;
            Type type = rhs = isLowerBound$1 ? tp2 : tp1;
            if (isNumericBound$1) {
                return lhs.weak_$less$colon$less(rhs);
            }
            return lhs.$less$colon$less(rhs);
        }

        private final boolean unifySimple$1(Type tp$5, boolean isLowerBound$1, boolean isNumericBound$1) {
            block5: {
                Symbols.Symbol sym;
                block4: {
                    Symbols.Symbol symbol = sym = tp$5.typeSymbol();
                    Definitions$DefinitionsClass$NothingClass$ definitions$DefinitionsClass$NothingClass$ = this.scala$reflect$internal$Types$TypeVar$$$outer().definitions().NothingClass();
                    if (!(symbol == null ? definitions$DefinitionsClass$NothingClass$ != null : !symbol.equals(definitions$DefinitionsClass$NothingClass$))) break block4;
                    Symbols.Symbol symbol2 = sym;
                    Symbols.ClassSymbol classSymbol = this.scala$reflect$internal$Types$TypeVar$$$outer().definitions().AnyClass();
                    if (symbol2 != null ? !symbol2.equals(classSymbol) : classSymbol != null) break block5;
                }
                this.addBound$1(sym.tpe(), isLowerBound$1, isNumericBound$1);
                return true;
            }
            if (this.params().isEmpty()) {
                this.addBound$1(tp$5, isLowerBound$1, isNumericBound$1);
                return true;
            }
            return false;
        }

        /*
         * WARNING - void declaration
         */
        private final boolean unifySpecific$1(Type tp, boolean isLowerBound$1, boolean isNumericBound$1) {
            void reflectSettingToBoolean_s;
            List<Type> tpTypeArgs = tp.typeArgs();
            int arityDelta = this.scala$reflect$internal$Types$TypeVar$$$outer().compareLengths(this.typeArgs(), tpTypeArgs);
            if (arityDelta == 0) {
                List<Type> rhs;
                List<Type> lhs = isLowerBound$1 ? tpTypeArgs : this.typeArgs();
                List<Type> list = rhs = isLowerBound$1 ? this.typeArgs() : tpTypeArgs;
                if (this.scala$reflect$internal$Types$TypeVar$$$outer().isSubArgs(lhs, rhs, this.params(), Depth$.MODULE$.AnyDepth())) {
                    this.addBound$1(tp.typeConstructor(), isLowerBound$1, isNumericBound$1);
                    return true;
                }
                return false;
            }
            MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Types$TypeVar$$$outer().settings().YpartialUnification();
            if (MutableSettings$.MODULE$ == null) {
                throw null;
            }
            if (BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value()) && arityDelta < 0 && this.typeArgs().nonEmpty()) {
                void var16_17;
                void var15_16;
                void var11_12;
                void var10_11;
                int numCaptured = tpTypeArgs.length() - this.typeArgs().length();
                Tuple2<List<Type>, List<Type>> tuple2 = tpTypeArgs.splitAt(numCaptured);
                if (tuple2 == null) {
                    throw new MatchError((Object)null);
                }
                List<Type> captured = tuple2._1();
                List<Type> abstractedArgs = tuple2._2();
                void captured2 = var10_11;
                void abstractedArgs2 = var11_12;
                Tuple2<void, List<Type>> tuple22 = isLowerBound$1 ? new Tuple2<void, List<Type>>(abstractedArgs2, this.typeArgs()) : new Tuple2<List<Type>, void>(this.typeArgs(), abstractedArgs2);
                List lhs = (List)tuple22._1();
                List<Type> rhs = tuple22._2();
                void lhs2 = var15_16;
                void rhs2 = var16_17;
                if (this.scala$reflect$internal$Types$TypeVar$$$outer().isSubArgs((List<Type>)lhs2, (List<Type>)rhs2, this.params(), Depth$.MODULE$.AnyDepth())) {
                    Symbols.Symbol tpSym = tp.typeSymbolDirect();
                    List<Symbols.Symbol> abstractedTypeParams = ((List)tpSym.typeParams().drop(numCaptured)).map((Function1<Symbols.Symbol, Symbols.Symbol> & java.io.Serializable & Serializable)x$45 -> x$45.cloneSymbol(tpSym), List$.MODULE$.canBuildFrom());
                    this.addBound$1(new PolyType(this.scala$reflect$internal$Types$TypeVar$$$outer(), abstractedTypeParams, this.scala$reflect$internal$Types$TypeVar$$$outer().appliedType(tp.typeConstructor(), captured2.$plus$plus((GenTraversableOnce)abstractedTypeParams.map((Function1<Symbols.Symbol, Type> & java.io.Serializable & Serializable)x$46 -> x$46.tpeHK(), List$.MODULE$.canBuildFrom()), List$.MODULE$.canBuildFrom()))), isLowerBound$1, isNumericBound$1);
                    return true;
                }
                return false;
            }
            return false;
        }

        private final boolean unifyFull$1(Type tpe, boolean isLowerBound$1, boolean isNumericBound$1) {
            boolean bl;
            block3: {
                List<Type> list = tpe.dealiasWidenChain();
                if (list == null) {
                    throw null;
                }
                LinearSeqOptimized exists_these = list;
                while (!exists_these.isEmpty()) {
                    Type type = (Type)exists_these.head();
                    if (this.unifySpecific$1(type, isLowerBound$1, isNumericBound$1)) {
                        bl = true;
                        break block3;
                    }
                    exists_these = (LinearSeqOptimized)exists_these.tail();
                }
                bl = false;
            }
            return bl;
        }

        public static final /* synthetic */ boolean $anonfun$registerBound$5(TypeVar $this, Type tp$5, boolean isLowerBound$1, boolean isNumericBound$1, Type bt) {
            return !tp$5.parents().contains(bt) && $this.unifyFull$1(bt, isLowerBound$1, isNumericBound$1);
        }

        private final boolean checkIsSameType$1(Type tp, boolean typeVarLHS$1) {
            if (typeVarLHS$1) {
                return this.inst().$eq$colon$eq(tp);
            }
            return tp.$eq$colon$eq(this.inst());
        }

        public static final /* synthetic */ String $anonfun$cloneInternal$2(TypeVar $this) {
            return $this.originLocation();
        }

        public TypeVar(SymbolTable $outer, Type origin, TypeConstraints.TypeConstraint constr) {
            this.origin = origin;
            this.constr = constr;
            super($outer);
            Product.$init$(this);
            this.level = $outer.skolemizationLevel();
            this._suspended = $outer.definitions().ConstantFalse();
        }

        public static final /* synthetic */ Object $anonfun$registerBound$4$adapted(TypeVar $this, boolean isLowerBound$1, boolean isNumericBound$1, Type tpe) {
            return BoxesRunTime.boxToBoolean($this.unifyFull$1(tpe, isLowerBound$1, isNumericBound$1));
        }

        public static final /* synthetic */ Object $anonfun$registerBound$3$adapted(TypeVar $this, boolean isLowerBound$1, boolean isNumericBound$1, Type tp) {
            return BoxesRunTime.boxToBoolean($this.unifySpecific$1(tp, isLowerBound$1, isNumericBound$1));
        }
    }

    public final class UniqueConstantType
    extends ConstantType {
        public UniqueConstantType(SymbolTable $outer, Constants.Constant value) {
            super($outer, value);
        }
    }

    public final class UniqueErasedValueType
    extends ErasedValueType {
        public UniqueErasedValueType(SymbolTable $outer, Symbols.Symbol valueClazz, Type erasedUnderlying) {
            super($outer, valueClazz, erasedUnderlying);
        }
    }

    public final class UniqueSingleType
    extends SingleType {
        public UniqueSingleType(SymbolTable $outer, Type pre, Symbols.Symbol sym) {
            super($outer, pre, sym);
        }
    }

    public final class UniqueSuperType
    extends SuperType {
        public UniqueSuperType(SymbolTable $outer, Type thistp, Type supertp) {
            super($outer, thistp, supertp);
        }
    }

    public final class UniqueThisType
    extends ThisType {
        public UniqueThisType(SymbolTable $outer, Symbols.Symbol sym) {
            super($outer, sym);
        }
    }

    public abstract class UniqueType
    extends Type
    implements Product {
        private final int hashCode;

        @Override
        public Iterator<Object> productIterator() {
            return Product.productIterator$(this);
        }

        @Override
        public String productPrefix() {
            return Product.productPrefix$(this);
        }

        public final int hashCode() {
            return this.hashCode;
        }

        public int computeHashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Types$UniqueType$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public UniqueType(SymbolTable $outer) {
            super($outer);
            Product.$init$(this);
            this.hashCode = this.computeHashCode();
        }
    }

    public final class UniqueTypeBounds
    extends TypeBounds {
        public UniqueTypeBounds(SymbolTable $outer, Type lo, Type hi) {
            super($outer, lo, hi);
        }
    }

    public interface UntouchableTypeVar {
        public /* synthetic */ boolean scala$reflect$internal$Types$UntouchableTypeVar$$super$registerTypeEquality(Type var1, boolean var2);

        public /* synthetic */ boolean scala$reflect$internal$Types$UntouchableTypeVar$$super$registerBound(Type var1, boolean var2, boolean var3);

        public static /* synthetic */ boolean untouchable$(UntouchableTypeVar $this) {
            return $this.untouchable();
        }

        default public boolean untouchable() {
            return true;
        }

        public static /* synthetic */ boolean isGround$(UntouchableTypeVar $this) {
            return $this.isGround();
        }

        default public boolean isGround() {
            return true;
        }

        public static /* synthetic */ boolean registerTypeEquality$(UntouchableTypeVar $this, Type tp, boolean typeVarLHS) {
            return $this.registerTypeEquality(tp, typeVarLHS);
        }

        default public boolean registerTypeEquality(Type tp, boolean typeVarLHS) {
            TypeVar typeVar;
            boolean bl = tp instanceof TypeVar && !(typeVar = (TypeVar)tp).untouchable() ? typeVar.registerTypeEquality((Type)((Object)this), !typeVarLHS) : this.scala$reflect$internal$Types$UntouchableTypeVar$$super$registerTypeEquality(tp, typeVarLHS);
            return bl;
        }

        public static /* synthetic */ boolean registerBound$(UntouchableTypeVar $this, Type tp, boolean isLowerBound, boolean isNumericBound) {
            return $this.registerBound(tp, isLowerBound, isNumericBound);
        }

        default public boolean registerBound(Type tp, boolean isLowerBound, boolean isNumericBound) {
            TypeVar typeVar;
            boolean bl = tp instanceof TypeVar && !(typeVar = (TypeVar)tp).untouchable() ? typeVar.registerBound((Type)((Object)this), !isLowerBound, isNumericBound) : this.scala$reflect$internal$Types$UntouchableTypeVar$$super$registerBound(tp, isLowerBound, isNumericBound);
            return bl;
        }

        public static /* synthetic */ boolean registerBound$default$3$(UntouchableTypeVar $this) {
            return $this.registerBound$default$3();
        }

        default public boolean registerBound$default$3() {
            return false;
        }

        public /* synthetic */ Types scala$reflect$internal$Types$UntouchableTypeVar$$$outer();

        public static void $init$(UntouchableTypeVar $this) {
        }
    }
}

