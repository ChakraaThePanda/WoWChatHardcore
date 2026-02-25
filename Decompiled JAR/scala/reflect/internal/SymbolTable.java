/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Member;
import java.util.concurrent.TimeUnit;
import scala.Array$;
import scala.Console$;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.MatchError;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.StringContext;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.Iterator;
import scala.collection.LinearSeqOptimized;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Set;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.AnyRefMap;
import scala.collection.mutable.ArrayBuilder;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.ArrayStack;
import scala.collection.mutable.BitSet;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.HashSet;
import scala.collection.mutable.LinkedHashMap;
import scala.collection.mutable.WeakHashMap;
import scala.math.Ordering;
import scala.ref.WeakReference;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.reflect.api.FlagSets;
import scala.reflect.api.Internals;
import scala.reflect.api.Trees;
import scala.reflect.api.TypeTags;
import scala.reflect.internal.AnnotationCheckers;
import scala.reflect.internal.AnnotationInfos;
import scala.reflect.internal.AnnotationInfos$Annotation$;
import scala.reflect.internal.AnnotationInfos$AnnotationInfo$;
import scala.reflect.internal.AnnotationInfos$ArrayAnnotArg$;
import scala.reflect.internal.AnnotationInfos$LiteralAnnotArg$;
import scala.reflect.internal.AnnotationInfos$NestedAnnotArg$;
import scala.reflect.internal.AnnotationInfos$ScalaSigBytes$;
import scala.reflect.internal.AnnotationInfos$ThrownException$;
import scala.reflect.internal.AnnotationInfos$UnmappableAnnotArg$;
import scala.reflect.internal.AnnotationInfos$UnmappableAnnotation$;
import scala.reflect.internal.BaseTypeSeqs;
import scala.reflect.internal.BaseTypeSeqsStats;
import scala.reflect.internal.CapturedVariables;
import scala.reflect.internal.Constants;
import scala.reflect.internal.Constants$Constant$;
import scala.reflect.internal.Definitions;
import scala.reflect.internal.Definitions$definitions$;
import scala.reflect.internal.Depth;
import scala.reflect.internal.ExistentialsAndSkolems;
import scala.reflect.internal.FlagSets;
import scala.reflect.internal.FlagSets$Flag$;
import scala.reflect.internal.FreshNames;
import scala.reflect.internal.FreshNames$FreshNameExtractor$;
import scala.reflect.internal.Importers;
import scala.reflect.internal.InfoTransformers;
import scala.reflect.internal.Internals;
import scala.reflect.internal.Kinds;
import scala.reflect.internal.Kinds$Kind$;
import scala.reflect.internal.Kinds$KindErrors$;
import scala.reflect.internal.Kinds$ProperTypeKind$;
import scala.reflect.internal.Kinds$TypeConKind$;
import scala.reflect.internal.Kinds$inferKind$;
import scala.reflect.internal.Mirrors;
import scala.reflect.internal.Names;
import scala.reflect.internal.Names$TermName$;
import scala.reflect.internal.Names$TypeName$;
import scala.reflect.internal.NoPhase$;
import scala.reflect.internal.Phase;
import scala.reflect.internal.Positions;
import scala.reflect.internal.Printers;
import scala.reflect.internal.Printers$ConsoleWriter$;
import scala.reflect.internal.PrivateWithin;
import scala.reflect.internal.ReificationSupport;
import scala.reflect.internal.Reporting;
import scala.reflect.internal.ScopeStats;
import scala.reflect.internal.Scopes;
import scala.reflect.internal.Scopes$EmptyScope$;
import scala.reflect.internal.Scopes$LookupAmbiguous$;
import scala.reflect.internal.Scopes$LookupInaccessible$;
import scala.reflect.internal.Scopes$LookupNotFound$;
import scala.reflect.internal.Scopes$LookupSucceeded$;
import scala.reflect.internal.Scopes$Scope$;
import scala.reflect.internal.StdAttachments;
import scala.reflect.internal.StdAttachments$BackquotedIdentifierAttachment$;
import scala.reflect.internal.StdAttachments$ChangeOwnerAttachment$;
import scala.reflect.internal.StdAttachments$CompoundTypeTreeOriginalAttachment$;
import scala.reflect.internal.StdAttachments$DelambdafyTarget$;
import scala.reflect.internal.StdAttachments$ForAttachment$;
import scala.reflect.internal.StdAttachments$InlineCallsiteAttachment$;
import scala.reflect.internal.StdAttachments$JustMethodReference$;
import scala.reflect.internal.StdAttachments$KnownDirectSubclassesCalled$;
import scala.reflect.internal.StdAttachments$NoInlineCallsiteAttachment$;
import scala.reflect.internal.StdAttachments$NoWarnAttachment$;
import scala.reflect.internal.StdAttachments$OuterArgCanBeElided$;
import scala.reflect.internal.StdAttachments$PatVarDefAttachment$;
import scala.reflect.internal.StdAttachments$SAMFunction$;
import scala.reflect.internal.StdAttachments$SubpatternsAttachment$;
import scala.reflect.internal.StdAttachments$SyntheticUnitAttachment$;
import scala.reflect.internal.StdAttachments$TypeParamVarargsAttachment$;
import scala.reflect.internal.StdAttachments$UseInvokeSpecial$;
import scala.reflect.internal.StdCreators;
import scala.reflect.internal.StdCreators$FixedMirrorTreeCreator$;
import scala.reflect.internal.StdCreators$FixedMirrorTypeCreator$;
import scala.reflect.internal.StdNames;
import scala.reflect.internal.StdNames$binarynme$;
import scala.reflect.internal.StdNames$compactify$;
import scala.reflect.internal.StdNames$fulltpnme$;
import scala.reflect.internal.StdNames$nme$;
import scala.reflect.internal.StdNames$tpnme$;
import scala.reflect.internal.SymbolTable$SimpleNameOrdering$;
import scala.reflect.internal.SymbolTable$perRunCaches$;
import scala.reflect.internal.SymbolTable$traceSymbols$;
import scala.reflect.internal.SymbolTableStats;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Symbols$CyclicReference$;
import scala.reflect.internal.Symbols$SymbolKind$;
import scala.reflect.internal.Symbols$SymbolOps$;
import scala.reflect.internal.Symbols$TypeHistory$;
import scala.reflect.internal.SymbolsStats;
import scala.reflect.internal.TreeGen;
import scala.reflect.internal.TreeInfo;
import scala.reflect.internal.Trees;
import scala.reflect.internal.Trees$Alternative$;
import scala.reflect.internal.Trees$Annotated$;
import scala.reflect.internal.Trees$AppliedTypeTree$;
import scala.reflect.internal.Trees$Apply$;
import scala.reflect.internal.Trees$ApplyDynamic$;
import scala.reflect.internal.Trees$ArrayValue$;
import scala.reflect.internal.Trees$Assign$;
import scala.reflect.internal.Trees$AssignOrNamedArg$;
import scala.reflect.internal.Trees$Bind$;
import scala.reflect.internal.Trees$Block$;
import scala.reflect.internal.Trees$CaseDef$;
import scala.reflect.internal.Trees$ClassDef$;
import scala.reflect.internal.Trees$CompoundTypeTree$;
import scala.reflect.internal.Trees$DefDef$;
import scala.reflect.internal.Trees$EmptyTree$;
import scala.reflect.internal.Trees$ExistentialTypeTree$;
import scala.reflect.internal.Trees$Function$;
import scala.reflect.internal.Trees$Ident$;
import scala.reflect.internal.Trees$If$;
import scala.reflect.internal.Trees$Import$;
import scala.reflect.internal.Trees$ImportSelector$;
import scala.reflect.internal.Trees$LabelDef$;
import scala.reflect.internal.Trees$Literal$;
import scala.reflect.internal.Trees$Match$;
import scala.reflect.internal.Trees$MethodValue$;
import scala.reflect.internal.Trees$Modifiers$;
import scala.reflect.internal.Trees$ModuleDef$;
import scala.reflect.internal.Trees$New$;
import scala.reflect.internal.Trees$PackageDef$;
import scala.reflect.internal.Trees$RefTree$;
import scala.reflect.internal.Trees$ReferenceToBoxed$;
import scala.reflect.internal.Trees$Return$;
import scala.reflect.internal.Trees$Select$;
import scala.reflect.internal.Trees$SelectFromTypeTree$;
import scala.reflect.internal.Trees$SingletonTypeTree$;
import scala.reflect.internal.Trees$Star$;
import scala.reflect.internal.Trees$Super$;
import scala.reflect.internal.Trees$Template$;
import scala.reflect.internal.Trees$This$;
import scala.reflect.internal.Trees$Throw$;
import scala.reflect.internal.Trees$Try$;
import scala.reflect.internal.Trees$TypeApply$;
import scala.reflect.internal.Trees$TypeBoundsTree$;
import scala.reflect.internal.Trees$TypeDef$;
import scala.reflect.internal.Trees$TypeTree$;
import scala.reflect.internal.Trees$Typed$;
import scala.reflect.internal.Trees$UnApply$;
import scala.reflect.internal.Trees$ValDef$;
import scala.reflect.internal.Trees$ValOrDefDef$;
import scala.reflect.internal.Trees$duplicateAndResetPos$;
import scala.reflect.internal.Trees$noSelfType$;
import scala.reflect.internal.Trees$pendingSuperCall$;
import scala.reflect.internal.TreesStats;
import scala.reflect.internal.TypeDebugging;
import scala.reflect.internal.TypeDebugging$noPrint$;
import scala.reflect.internal.TypeDebugging$typeDebug$;
import scala.reflect.internal.Types;
import scala.reflect.internal.Types$AnnotatedType$;
import scala.reflect.internal.Types$AntiPolyType$;
import scala.reflect.internal.Types$ArrayTypeRef$;
import scala.reflect.internal.Types$BoundedWildcardType$;
import scala.reflect.internal.Types$ClassInfoType$;
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
import scala.reflect.internal.Variances;
import scala.reflect.internal.pickling.Translations;
import scala.reflect.internal.settings.MutableSettings;
import scala.reflect.internal.settings.MutableSettings$;
import scala.reflect.internal.tpe.CommonOwners;
import scala.reflect.internal.tpe.FindMembers;
import scala.reflect.internal.tpe.GlbLubs;
import scala.reflect.internal.tpe.TypeComparers;
import scala.reflect.internal.tpe.TypeComparers$SubTypePair$;
import scala.reflect.internal.tpe.TypeConstraints;
import scala.reflect.internal.tpe.TypeConstraints$TypeConstraint$;
import scala.reflect.internal.tpe.TypeMaps;
import scala.reflect.internal.tpe.TypeMaps$ApproximateDependentMap$;
import scala.reflect.internal.tpe.TypeMaps$ErroneousCollector$;
import scala.reflect.internal.tpe.TypeMaps$IsDependentCollector$;
import scala.reflect.internal.tpe.TypeMaps$abstractTypesToBounds$;
import scala.reflect.internal.tpe.TypeMaps$adaptToNewRunMap$;
import scala.reflect.internal.tpe.TypeMaps$dropIllegalStarTypes$;
import scala.reflect.internal.tpe.TypeMaps$dropSingletonType$;
import scala.reflect.internal.tpe.TypeMaps$normalizeAliases$;
import scala.reflect.internal.tpe.TypeMaps$typeVarToOriginMap$;
import scala.reflect.internal.tpe.TypeMaps$wildcardExtrapolation$;
import scala.reflect.internal.tpe.TypeMaps$wildcardToTypeVarMap$;
import scala.reflect.internal.tpe.TypeToStrings;
import scala.reflect.internal.transform.Erasure;
import scala.reflect.internal.transform.PostErasure;
import scala.reflect.internal.transform.Transforms;
import scala.reflect.internal.transform.UnCurry;
import scala.reflect.internal.util.Collections;
import scala.reflect.internal.util.FreshNameCreator;
import scala.reflect.internal.util.NoPosition$;
import scala.reflect.internal.util.Position;
import scala.reflect.internal.util.ReusableInstance;
import scala.reflect.internal.util.SourceFile;
import scala.reflect.internal.util.Statistics;
import scala.reflect.internal.util.WeakHashSet;
import scala.reflect.internal.util.package;
import scala.reflect.internal.util.package$;
import scala.reflect.io.AbstractFile;
import scala.reflect.macros.Universe;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@ScalaSignature(bytes="\u0006\u0001\u001d\u0005g\u0001CA\u0004\u0003\u0013\t\t!a\u0006\t\u000f\u0005e\b\u0001\"\u0001\u0002|\"I\u0011q \u0001C\u0002\u0013\u0005!\u0011\u0001\u0005\t\u0005\u0013\u0001\u0001\u0015!\u0003\u0003\u0004\u0019Y!\u0011\u0004\u0001\u0011\u0002G\u0005!1\u0004B%\u0011%\u0011)\u0006\u0001b\u0001\u000e\u0003\u00119\u0006C\u0004\u0003^\u00011\tAa\u0018\t\u000f\tE\u0004\u0001\"\u0005\u0003t!9!Q\u0015\u0001\u0005\u0002\t\u001d\u0006b\u0002BV\u0001\u0011\u0005!Q\u0016\u0005\b\u0005g\u0003A\u0011\u0001B[\u0011\u001d\u0011i\f\u0001C\u0001\u0005kCqAa0\u0001\t\u000b\u0011)\fC\u0004\u0003B\u00021\tAa1\t\u000f\t-\u0007A\"\u0001\u0003D\"9!Q\u001a\u0001\u0007\u0002\t=\u0007b\u0002Bn\u0001\u0011\u0005!Q\u0017\u0005\b\u0005[\u0004A\u0011\u0001B[\u0011\u001d\u0011)\u0010\u0001C\u0001\u0005oDqaa\u0001\u0001\t\u0003\u0019)\u0001C\u0004\u0004\n\u0001!)aa\u0003\t\u000f\r}\u0001\u0001\"\u0001\u0004\"!91Q\u0005\u0001\u0005\u0002\r\u001d\u0002bBB\u0013\u0001\u0011\u000511\b\u0005\b\u0007\u0013\u0002AQAB&\u0011\u001d\u0019\u0019\u0006\u0001C\u0001\u0007+B\u0011b!\u0017\u0001\t\u0003\t\tba\u0017\t\u0013\ru\u0004\u0001\"\u0001\u0002\u0012\r}\u0004\"CBG\u0001\u0011\u0015\u0011\u0011CBH\u0011%\u0019y\n\u0001C\u0003\u0003#\u0019\t\u000bC\u0005\u00042\u0002!)!!\u0005\u00044\"I11\u0019\u0001\u0005\u0006\u0005E1Q\u0019\u0005\n\u0007;\u0004AQAA\t\u0007?Dqaa=\u0001\t\u000b\u0019)\u0010C\u0004\u0004t\u0002!)\u0001b\u0001\t\u000f\u0011\u001d\u0001\u0001\"\u0002\u0005\n!9Aq\u0001\u0001\u0005\u0006\u0011M\u0001\"\u0003C\f\u0001\u0011\u0005\u0011\u0011\u0002C\r\u0011%!i\u0002\u0001C\u0001\u0003\u0013!y\u0002C\u0004\u0005$\u0001!)\u0001\"\n\t\u000f\u0011\u0005\u0003\u0001b\u0001\u0005D\u001d9A\u0011\f\u0001\t\n\u0011mca\u0002C/\u0001!%Aq\f\u0005\b\u0003sTC\u0011\u0001C5\u0011\u001d!YG\u000bC\u0001\t[B\u0011\u0002b\u001e\u0001\u0005\u0004%)A!.\t\u0011\u0011e\u0004\u0001)A\u0007\u0005o;q\u0001b\u001f\u0001\u0011\u0003!iHB\u0004\u0005\u0000\u0001A\t\u0001\"!\t\u0013\tM\u0001G1A\u0005\u0002\tU\u0001b\u0003CEa\u0011\u0005\t\u0011)A\u0005\u0005/Aq!!?1\t\u0003!Y\tC\u0005\u0005\u000e\u0002\u0011\rQ\"\u0001\u0005\u0010\"9AQ\u0014\u0001\u0005\u0002\u0011}\u0005b\u0002CY\u0001\u0011\u0005A1\u0017\u0005\b\t\u007f\u0003a\u0011\u0001Ca\u000b\u0019!i\r\u0001\u0001\u0004D!IAq\u001a\u0001C\u0002\u0013\u0015A\u0011\u001b\u0005\t\t/\u0004\u0001\u0015!\u0004\u0005T\u00161A\u0011\u001c\u0001\u0001\u0007\u0007B\u0011\u0002b7\u0001\u0005\u0004%)\u0001\"5\t\u0011\u0011u\u0007\u0001)A\u0007\t'D\u0011\u0002b8\u0001\u0005\u0004%I\u0001\"9\t\u0011\u0011M\b\u0001)A\u0005\tGD\u0001\u0002\">\u0001A\u0003&!Q\u0019\u0005\t\to\u0004\u0001\u0015)\u0003\u0004D!9A\u0011 \u0001\u0005\u0006\u0011m\bbBC\u0002\u0001\u0011\u0015!1\u0019\u0005\b\u000b\u000b\u0001A\u0011AC\u0004\u0011\u001d)I\u0001\u0001C\u0003\u000b\u0017Aq!b\u0004\u0001\t\u000b)\t\u0002C\u0004\u0006\u0016\u0001!)!b\u0006\t\u0013\u0015m\u0001\u00011A\u0005\u0002\tU\u0006\"CC\u000f\u0001\u0001\u0007I\u0011AC\u0010\u0011!))\u0003\u0001Q!\n\t]\u0006bBC\u0014\u0001\u0019\u0005Q\u0011\u0006\u0005\b\u000b[\u0001AQAC\u0018\u0011\u001d)9\u0004\u0001C\u0003\u000bsAq!\"\u0010\u0001\t\u000b)y\u0004C\u0004\u0006B\u0001!)!b\u0011\t\u000f\u0015M\u0002\u0001\"\u0002\u0006H!9Q\u0011\u000b\u0001\u0005\u0006\u0015M\u0003bBC,\u0001\u0011\u0015Q\u0011\f\u0005\b\u000b[\u0002AQAC8\u0011\u001d))\b\u0001C\u0003\u000boBq!\"#\u0001\t\u0003)Y\tC\u0004\u0006\u001c\u0002!)!\"(\t\u000f\u0015=\u0006\u0001\"\u0002\u00062\"9Qq\u0018\u0001\u0005\u0006\u0015\u0005\u0007bBCk\u0001\u0011\u0005Qq\u001b\u0005\b\u000bO\u0004AQACu\u0011\u001d)i\u000f\u0001C\u0003\u000b_Dq!b=\u0001\t\u0003))\u0010C\u0004\u0006\u0000\u0002!\tA\"\u0001\u0007\u000f\u00195\u0001!!\u0001\u0007\u0010!9\u0011\u0011 0\u0005\u0002\u0019]\u0001b\u0002D\u000e=\u0012\u0005!Q\u0017\u0005\b\u000bg\u0004A\u0011\u0001D\u000f\u000f\u001d1\u0019\u0003\u0001E\u0001\rK1qAb\n\u0001\u0011\u00031I\u0003C\u0004\u0002z\u000e$\tAb\u000b\t\u0013\u001952\r1A\u0005\n\u0019=\u0002\"\u0003D*G\u0002\u0007I\u0011\u0002D+\u0011!1If\u0019Q!\n\u0019E\u0002\"\u0003D.G\u0002\u0007I\u0011\u0002D/\u0011%1\th\u0019a\u0001\n\u00131\u0019\b\u0003\u0005\u0007p\r\u0004\u000b\u0015\u0002D0\u0011\u001d19h\u0019C\u0001\rsBqAb\"d\t\u000b1I\tC\u0004\u0007\u0016\u000e$\tAb&\t\u000f\u0019\u00056\r\"\u0001\u0005 \"9a1U2\u0005\u0002\u0019\u0015\u0006b\u0002D^G\u0012\u0005aQ\u0018\u0005\b\r\u001f\u001cG\u0011\u0001Di\u0011\u001d1yn\u0019C\u0001\rCDqA\"=d\t\u00031\u0019\u0010C\u0004\b\u0006\r$\tab\u0002\t\u0013\u001d\u00052-%A\u0005\u0002\u001d\r\u0002\"CD\u001e\u0001\u0001\u0007I\u0011AD\u001f\u0011%9)\u0005\u0001a\u0001\n\u000399\u0005\u0003\u0005\bL\u0001\u0001\u000b\u0015BD \u0011%9i\u0005\u0001b\u0001\n\u001b9y\u0005\u0003\u0005\bV\u0001\u0001\u000bQBD)\u0011%99\u0006\u0001b\u0001\n\u000b9I\u0006\u0003\u0005\bb\u0001\u0001\u000bQBD.\u0011\u001d9\u0019\u0007\u0001C\u0001\u0005kCqa\"\u001a\u0001\t\u000b99\u0007C\u0005\b\u0004\u0002\u0011\r\u0011b\u0001\b\u0006\"Aqq\u0014\u0001!\u0002\u001399\tC\u0005\b\"\u0002!\t\"!\u0005\b$\"Iq\u0011\u0018\u0001\u0005\u0012\u0005Eq1\u0018\u0002\f'fl'm\u001c7UC\ndWM\u0003\u0003\u0002\f\u00055\u0011\u0001C5oi\u0016\u0014h.\u00197\u000b\t\u0005=\u0011\u0011C\u0001\be\u00164G.Z2u\u0015\t\t\u0019\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0007\u0002\tI\"!\n\u00022\u0005e\u0012qHA#\u0003\u0017\n\t&a\u0016\u0002^\u0005\r\u0014\u0011NA8\u0003k\nY(!!\u0002\u000e\u0006M\u0015\u0011TAP\u0003K\u000bY+!-\u00028\u0006u\u00161YAe\u0003\u001f\f).a7\u0002h\u00065\u00181\u001f\t\u0005\u00037\t\t#\u0004\u0002\u0002\u001e)!\u0011qDA\u0007\u0003\u0019i\u0017m\u0019:pg&!\u00111EA\u000f\u0005!)f.\u001b<feN,\u0007\u0003BA\u0014\u0003[i!!!\u000b\u000b\t\u0005-\u0012\u0011B\u0001\u0005kRLG.\u0003\u0003\u00020\u0005%\"aC\"pY2,7\r^5p]N\u0004B!a\r\u000265\u0011\u0011\u0011B\u0005\u0005\u0003o\tIAA\u0003OC6,7\u000f\u0005\u0003\u00024\u0005m\u0012\u0002BA\u001f\u0003\u0013\u0011qaU=nE>d7\u000f\u0005\u0003\u00024\u0005\u0005\u0013\u0002BA\"\u0003\u0013\u0011Q\u0001V=qKN\u0004B!a\r\u0002H%!\u0011\u0011JA\u0005\u0005%1\u0016M]5b]\u000e,7\u000f\u0005\u0003\u00024\u00055\u0013\u0002BA(\u0003\u0013\u0011QaS5oIN\u0004B!a\r\u0002T%!\u0011QKA\u0005\u0005Y)\u00050[:uK:$\u0018.\u00197t\u0003:$7k[8mK6\u001c\b\u0003BA\u001a\u00033JA!a\u0017\u0002\n\tAa\t\\1h'\u0016$8\u000f\u0005\u0003\u00024\u0005}\u0013\u0002BA1\u0003\u0013\u0011aaU2pa\u0016\u001c\b\u0003BA\u001a\u0003KJA!a\u001a\u0002\n\t9Q*\u001b:s_J\u001c\b\u0003BA\u001a\u0003WJA!!\u001c\u0002\n\tYA)\u001a4j]&$\u0018n\u001c8t!\u0011\t\u0019$!\u001d\n\t\u0005M\u0014\u0011\u0002\u0002\n\u0007>t7\u000f^1oiN\u0004B!a\r\u0002x%!\u0011\u0011PA\u0005\u00051\u0011\u0015m]3UsB,7+Z9t!\u0011\t\u0019$! \n\t\u0005}\u0014\u0011\u0002\u0002\u0011\u0013:4w\u000e\u0016:b]N4wN]7feN\u0004B!a!\u0002\n6\u0011\u0011Q\u0011\u0006\u0005\u0003\u000f\u000bI!A\u0005ue\u0006t7OZ8s[&!\u00111RAC\u0005)!&/\u00198tM>\u0014Xn\u001d\t\u0005\u0003g\ty)\u0003\u0003\u0002\u0012\u0006%!\u0001C*uI:\u000bW.Z:\u0011\t\u0005M\u0012QS\u0005\u0005\u0003/\u000bIAA\bB]:|G/\u0019;j_:LeNZ8t!\u0011\t\u0019$a'\n\t\u0005u\u0015\u0011\u0002\u0002\u0013\u0003:tw\u000e^1uS>t7\t[3dW\u0016\u00148\u000f\u0005\u0003\u00024\u0005\u0005\u0016\u0002BAR\u0003\u0013\u0011Q\u0001\u0016:fKN\u0004B!a\r\u0002(&!\u0011\u0011VA\u0005\u0005!\u0001&/\u001b8uKJ\u001c\b\u0003BA\u001a\u0003[KA!a,\u0002\n\tI\u0001k\\:ji&|gn\u001d\t\u0005\u0003g\t\u0019,\u0003\u0003\u00026\u0006%!!\u0004+za\u0016$UMY;hO&tw\r\u0005\u0003\u00024\u0005e\u0016\u0002BA^\u0003\u0013\u0011\u0011\"S7q_J$XM]:\u0011\t\u0005M\u0012qX\u0005\u0005\u0003\u0003\fIAA\tDCB$XO]3e-\u0006\u0014\u0018.\u00192mKN\u0004B!a\r\u0002F&!\u0011qYA\u0005\u00059\u0019F\u000fZ!ui\u0006\u001c\u0007.\\3oiN\u0004B!a\r\u0002L&!\u0011QZA\u0005\u0005-\u0019F\u000fZ\"sK\u0006$xN]:\u0011\t\u0005M\u0012\u0011[\u0005\u0005\u0003'\fIA\u0001\nSK&4\u0017nY1uS>t7+\u001e9q_J$\b\u0003BA\u001a\u0003/LA!!7\u0002\n\ti\u0001K]5wCR,w+\u001b;iS:\u0004B!!8\u0002d6\u0011\u0011q\u001c\u0006\u0005\u0003C\fI!\u0001\u0005qS\u000e\\G.\u001b8h\u0013\u0011\t)/a8\u0003\u0019Q\u0013\u0018M\\:mCRLwN\\:\u0011\t\u0005M\u0012\u0011^\u0005\u0005\u0003W\fIA\u0001\u0006Ge\u0016\u001c\bNT1nKN\u0004B!a\r\u0002p&!\u0011\u0011_A\u0005\u0005%Ie\u000e^3s]\u0006d7\u000f\u0005\u0003\u00024\u0005U\u0018\u0002BA|\u0003\u0013\u0011\u0011BU3q_J$\u0018N\\4\u0002\rqJg.\u001b;?)\t\ti\u0010E\u0002\u00024\u0001\t1aZ3o+\t\u0011\u0019A\u0005\u0003\u0003\u0006\t-aA\u0002B\u0004\u0007\u0001\u0011\u0019A\u0001\u0007=e\u00164\u0017N\\3nK:$h(\u0001\u0003hK:\u0004\u0003\u0003BA\u001a\u0005\u001bIAAa\u0004\u0002\n\t9AK]3f\u000f\u0016t\u0007B\u0003B\n\u0005\u000b\u0011\r\u0011\"\u0001\u0003\u0016\u00051q\r\\8cC2,\"Aa\u0006\u000e\u0003\u0001\u0011ABU3gY\u0016\u001cGo\u0015;biN\u001cr\u0002\u0002B\u000f\u0005K\u0011YC!\r\u00038\tu\"1\t\t\u0005\u0005?\u0011\t#\u0004\u0002\u0002\u0012%!!1EA\t\u0005\u0019\te.\u001f*fMB!\u00111\u0007B\u0014\u0013\u0011\u0011I#!\u0003\u0003#\t\u000b7/\u001a+za\u0016\u001cV-]:Ti\u0006$8\u000f\u0005\u0003\u00024\t5\u0012\u0002\u0002B\u0018\u0003\u0013\u0011!\u0002V=qKN\u001cF/\u0019;t!\u0011\t\u0019Da\r\n\t\tU\u0012\u0011\u0002\u0002\u0011'fl'm\u001c7UC\ndWm\u0015;biN\u0004B!a\r\u0003:%!!1HA\u0005\u0005)!&/Z3t'R\fGo\u001d\t\u0005\u0003g\u0011y$\u0003\u0003\u0003B\u0005%!\u0001D*z[\n|Gn]*uCR\u001c\b\u0003BA\u001a\u0005\u000bJAAa\u0012\u0002\n\tQ1kY8qKN#\u0018\r^:\u0013\r\t-#Q\nB(\r\u0019\u00119\u0001\u0001\u0001\u0003JA\u0019!q\u0003\u0003\u0011\t\u0005\u001d\"\u0011K\u0005\u0005\u0005'\nIC\u0001\u0006Ti\u0006$\u0018n\u001d;jGN\f!b\u001d;bi&\u001cH/[2t+\t\u0011IF\u0005\u0004\u0003\\\t=#Q\n\u0004\u0007\u0005\u000f\u0001\u0001A!\u0017\u0002\u00071|w\r\u0006\u0003\u0003b\t\u001d\u0004\u0003\u0002B\u0010\u0005GJAA!\u001a\u0002\u0012\t!QK\\5u\u0011!\u0011IG\u0002CA\u0002\t-\u0014aA7tOB1!q\u0004B7\u0005;IAAa\u001c\u0002\u0012\tAAHY=oC6,g(\u0001\bfY\u0006\u00048/\u001a3NKN\u001c\u0018mZ3\u0015\r\tU$Q\u0011BN!\u0011\u00119H!!\u000e\u0005\te$\u0002\u0002B>\u0005{\nA\u0001\\1oO*\u0011!qP\u0001\u0005U\u00064\u0018-\u0003\u0003\u0003\u0004\ne$AB*ue&tw\rC\u0004\u0003j\u001d\u0001\rAa\"\u0011\t\t%%q\u0013\b\u0005\u0005\u0017\u0013\u0019\n\u0005\u0003\u0003\u000e\u0006EQB\u0001BH\u0015\u0011\u0011\t*!\u0006\u0002\rq\u0012xn\u001c;?\u0013\u0011\u0011)*!\u0005\u0002\rA\u0013X\rZ3g\u0013\u0011\u0011\u0019I!'\u000b\t\tU\u0015\u0011\u0003\u0005\b\u0005;;\u0001\u0019\u0001BP\u0003\u0015\u0019H/\u0019:u!\u0011\u0011yB!)\n\t\t\r\u0016\u0011\u0003\u0002\u0005\u0019>tw-\u0001\bj]\u001a|'/\u001c)s_\u001e\u0014Xm]:\u0015\t\t\u0005$\u0011\u0016\u0005\b\u0005SB\u0001\u0019\u0001BD\u0003)IgNZ8s[RKW.\u001a\u000b\u0007\u0005C\u0012yK!-\t\u000f\t%\u0014\u00021\u0001\u0003\b\"9!QT\u0005A\u0002\t}\u0015\u0001F:i_VdG\rT8h\u0003R$\u0006.[:QQ\u0006\u001cX-\u0006\u0002\u00038B!!q\u0004B]\u0013\u0011\u0011Y,!\u0005\u0003\u000f\t{w\u000e\\3b]\u0006Y\u0011n\u001d)bgR$\u0016\u0010]3s\u0003-I7\u000fR3wK2|\u0007/\u001a:\u0002\u0019AL7m\u001b7feBC\u0017m]3\u0016\u0005\t\u0015\u0007\u0003BA\u001a\u0005\u000fLAA!3\u0002\n\t)\u0001\u000b[1tK\u0006aQM]1tkJ,\u0007\u000b[1tK\u0006A1/\u001a;uS:<7/\u0006\u0002\u0003RB!!1\u001bBl\u001b\t\u0011)N\u0003\u0003\u0003N\u0006%\u0011\u0002\u0002Bm\u0005+\u0014q\"T;uC\ndWmU3ui&twm]\u0001\u000fM>\u0014\u0018J\u001c;fe\u0006\u001cG/\u001b<fQ\u001d\u0001\"q\u001cBs\u0005S\u0004BAa\b\u0003b&!!1]A\t\u0005)!W\r\u001d:fG\u0006$X\rZ\u0011\u0003\u0005O\fQ)\u00138uKJ\f7\r^5wK\u0002J7\u000fI5na2,W.\u001a8uK\u0012\u0004s/\u001b;iA\u0005\u00043-^:u_6\u0004s\t\\8cC2\\\u0004\u0005\u001e5jg\u00022G.Y4!SN\u0004\u0013n\u001a8pe\u0016$\u0017E\u0001Bv\u0003\u0019\u0011d&M\u0019/a\u0005Yam\u001c:TG\u0006d\u0017\rZ8dQ\u001d\t\"q\u001cBy\u0005S\f#Aa=\u0002\u0005N\u001b\u0017\r\\1e_\u000e\u0004\u0013n\u001d\u0011j[BdW-\\3oi\u0016$\u0007e^5uQ\u0002\n\u0007eY;ti>l\u0007e\u00127pE\u0006d7\b\t;iSN\u0004c\r\\1hA%\u001c\b%[4o_J,G-A\u0005eK\n,xm^1s]R!!\u0011\rB}\u0011!\u0011IG\u0005CA\u0002\tm\bC\u0002B\u0010\u0005[\u00129\tK\u0004\u0013\u0005?\u0014yP!;\"\u0005\r\u0005\u0011!P;tK\u0002\"WM^,be:Lgn\u001a\u0011jM\u0002\"\b.[:!SN\u0004#/Z1mYf\u0004\u0013\rI<be:LgnZ\u001e!_RDWM]<jg\u0016\u0004So]3!Y><\u0017\u0001\u00033fEV<Gn\\4\u0015\t\t\u00054q\u0001\u0005\t\u0005S\u001aB\u00111\u0001\u0003|\u0006aA-\u001a<XCJt\u0017N\\4JMR!1QBB\t)\u0011\u0011\tga\u0004\t\u0011\t%D\u0003\"a\u0001\u0005wD\u0001ba\u0005\u0015\t\u0003\u00071QC\u0001\u0005G>tG\r\u0005\u0004\u0003 \t5$q\u0017\u0015\u0004)\re\u0001\u0003\u0002B\u0010\u00077IAa!\b\u0002\u0012\t1\u0011N\u001c7j]\u0016\f!\u0002Z3w/\u0006\u0014h.\u001b8h)\u0011\u0011\tga\t\t\u0011\t%T\u0003\"a\u0001\u0005w\f\u0011\u0003\u001e5s_^\f'\r\\3BgN#(/\u001b8h)\u0011\u00119i!\u000b\t\u000f\r-b\u00031\u0001\u0004.\u0005\tA\u000f\u0005\u0003\u00040\rUb\u0002\u0002B\u0010\u0007cIAaa\r\u0002\u0012\u00059\u0001/Y2lC\u001e,\u0017\u0002BB\u001c\u0007s\u0011\u0011\u0002\u00165s_^\f'\r\\3\u000b\t\rM\u0012\u0011\u0003\u000b\u0007\u0005\u000f\u001bida\u0010\t\u000f\r-r\u00031\u0001\u0004.!91\u0011I\fA\u0002\r\r\u0013!C7bq\u001a\u0013\u0018-\\3t!\u0011\u0011yb!\u0012\n\t\r\u001d\u0013\u0011\u0003\u0002\u0004\u0013:$\u0018a\u00053fm^\u000b'O\\5oO\u0012+X\u000e]*uC\u000e\\GC\u0002B1\u0007\u001b\u001ay\u0005\u0003\u0005\u0003ja!\t\u0019\u0001B~\u0011\u001d\u0019\t\u0005\u0007a\u0001\u0007\u0007B3\u0001GB\r\u0003)!WMY;h'R\f7m\u001b\u000b\u0005\u0005C\u001a9\u0006C\u0004\u0004,e\u0001\ra!\f\u0002\u0017A\u0014\u0018N\u001c;DC2dWM]\u000b\u0005\u0007;\u001a)\u0007\u0006\u0003\u0004`\rmD\u0003BB1\u0007o\u0002Baa\u0019\u0004f1\u0001AaBB45\t\u00071\u0011\u000e\u0002\u0002)F!11NB9!\u0011\u0011yb!\u001c\n\t\r=\u0014\u0011\u0003\u0002\b\u001d>$\b.\u001b8h!\u0011\u0011yba\u001d\n\t\rU\u0014\u0011\u0003\u0002\u0004\u0003:L\bbBB=5\u0001\u00071\u0011M\u0001\u0007e\u0016\u001cX\u000f\u001c;\t\u000f\t%$\u00041\u0001\u0003\b\u0006Y\u0001O]5oiJ+7/\u001e7u+\u0011\u0019\tia\"\u0015\t\r\r51\u0012\u000b\u0005\u0007\u000b\u001bI\t\u0005\u0003\u0004d\r\u001dEaBB47\t\u00071\u0011\u000e\u0005\b\u0007sZ\u0002\u0019ABC\u0011\u001d\u0011Ig\u0007a\u0001\u0005\u000f\u000b\u0011\u0002\\8h%\u0016\u001cX\u000f\u001c;\u0016\t\rE5q\u0013\u000b\u0005\u0007'\u001bY\n\u0006\u0003\u0004\u0016\u000ee\u0005\u0003BB2\u0007/#qaa\u001a\u001d\u0005\u0004\u0019I\u0007C\u0004\u0004zq\u0001\ra!&\t\u0011\t%D\u0004\"a\u0001\u0005wD3\u0001HB\r\u00039!WMY;hY><'+Z:vYR,Baa)\u0004*R!1QUBW)\u0011\u00199ka+\u0011\t\r\r4\u0011\u0016\u0003\b\u0007Oj\"\u0019AB5\u0011\u001d\u0019I(\ba\u0001\u0007OC\u0001B!\u001b\u001e\t\u0003\u0007!1 \u0015\u0004;\re\u0011\u0001\u00053fm^\u000b'O\\5oOJ+7/\u001e7u+\u0011\u0019)la/\u0015\t\r]6q\u0018\u000b\u0005\u0007s\u001bi\f\u0005\u0003\u0004d\rmFaBB4=\t\u00071\u0011\u000e\u0005\b\u0007sr\u0002\u0019AB]\u0011!\u0011IG\bCA\u0002\tm\bf\u0001\u0010\u0004\u001a\u0005YAn\\4SKN,H\u000e^%g+\u0011\u00199m!4\u0015\r\r%7\u0011[Bj)\u0011\u0019Yma4\u0011\t\r\r4Q\u001a\u0003\b\u0007Oz\"\u0019AB5\u0011\u001d\u0019Ih\ba\u0001\u0007\u0017D\u0001B!\u001b \t\u0003\u0007!1 \u0005\b\u0007'y\u0002\u0019ABk!!\u0011yba6\u0004L\n]\u0016\u0002BBm\u0003#\u0011\u0011BR;oGRLwN\\\u0019)\u0007}\u0019I\"\u0001\teK\n,x\r\\8h%\u0016\u001cX\u000f\u001c;JMV!1\u0011]Bt)\u0019\u0019\u0019oa;\u0004nR!1Q]Bu!\u0011\u0019\u0019ga:\u0005\u000f\r\u001d\u0004E1\u0001\u0004j!91\u0011\u0010\u0011A\u0002\r\u0015\b\u0002\u0003B5A\u0011\u0005\rAa?\t\u000f\rM\u0001\u00051\u0001\u0004pBA!qDBl\u0007K\u00149\fK\u0002!\u00073\ta!Y:tKJ$HC\u0002B1\u0007o\u001cY\u0010C\u0004\u0004z\u0006\u0002\rAa.\u0002\u0013\u0005\u001c8/\u001a:uS>t\u0007\u0002CB\u007fC\u0011\u0005\raa@\u0002\u000f5,7o]1hKB1!q\u0004B7\u0007cB3!IB\r)\u0011\u0011\t\u0007\"\u0002\t\u000f\re(\u00051\u0001\u00038\u00069!/Z9vSJ,GC\u0002B1\t\u0017!y\u0001C\u0004\u0005\u000e\r\u0002\rAa.\u0002\u0017I,\u0017/^5sK6,g\u000e\u001e\u0005\t\u0007{\u001cC\u00111\u0001\u0004\u0000\"\u001a1e!\u0007\u0015\t\t\u0005DQ\u0003\u0005\b\t\u001b!\u0003\u0019\u0001B\\\u0003M!\bN]8x\u0003N\u001cXM\u001d;j_:,%O]8s)\u0011\u0019Y\u0007b\u0007\t\u000f\t%T\u00051\u0001\u0004r\u0005)B\u000f\u001b:poJ+\u0017/^5sK6,g\u000e^#se>\u0014H\u0003BB6\tCAqA!\u001b'\u0001\u0004\u0019\t(\u0001\u0006gS:$7+_7c_2$B\u0001b\n\u00056Q!A\u0011\u0006C\u0018!\u0011\u00119\u0002b\u000b\n\t\u00115\u00121\b\u0002\u0007'fl'm\u001c7\t\u000f\u0011Er\u00051\u0001\u00054\u0005\t\u0001\u000f\u0005\u0005\u0003 \r]G\u0011\u0006B\\\u0011\u001d!9d\na\u0001\ts\t!\u0001_:\u0011\r\r=B1\bC\u0015\u0013\u0011!id!\u000f\u0003\u001fQ\u0013\u0018M^3sg\u0006\u0014G.Z(oG\u0016D3aJB\r\u0003]awn\u001e)sS>\u0014\u0018\u000e^=OC6,wJ\u001d3fe&tw-\u0006\u0003\u0005F\u0011=SC\u0001C$!\u0019\u0019y\u0003\"\u0013\u0005N%!A1JB\u001d\u0005!y%\u000fZ3sS:<\u0007\u0003BB2\t\u001f\"qaa\u001a)\u0005\u0004!\t&\u0005\u0003\u0004l\u0011M\u0003\u0003BA\u0019\t+JA\u0001b\u0016\u00026\t!a*Y7f\u0003I\u0019\u0016.\u001c9mK:\u000bW.Z(sI\u0016\u0014\u0018N\\4\u0011\u0007\t]!F\u0001\nTS6\u0004H.\u001a(b[\u0016|%\u000fZ3sS:<7#\u0002\u0016\u0005b\u0011\u001d\u0004\u0003\u0002B<\tGJA\u0001\"\u001a\u0003z\t1qJ\u00196fGR\u0004baa\f\u0005J\u0011MCC\u0001C.\u0003\u001d\u0019w.\u001c9be\u0016$baa\u0011\u0005p\u0011M\u0004b\u0002C9Y\u0001\u0007A1K\u0001\u0003]FBq\u0001\"\u001e-\u0001\u0004!\u0019&\u0001\u0002oe\u0005\u0019BO]1dKNKXNY8m\u0003\u000e$\u0018N^5us\u0006!BO]1dKNKXNY8m\u0003\u000e$\u0018N^5us\u0002\nA\u0002\u001e:bG\u0016\u001c\u00160\u001c2pYN\u00042Aa\u00061\u00051!(/Y2f'fl'm\u001c7t'\u0015\u0001$Q\u0004CB!\u0011\t9\u0003\"\"\n\t\u0011\u001d\u0015\u0011\u0006\u0002\u0014)J\f7-Z*z[\n|G.Q2uSZLG/_\u0001\bO2|'-\u00197!)\t!i(\u0001\u0005ue\u0016,\u0017J\u001c4p+\t!\tJ\u0005\u0003\u0005\u0014\u0012UeA\u0002B\u0004\u0001\u0001!\t\n\u0005\u0003\u00024\u0011]\u0015\u0002\u0002CM\u0003\u0013\u0011\u0001\u0002\u0016:fK&sgm\u001c\u0005\u000b\u0005'!\u0019J1A\u0007B\tU\u0011aE1tg\u0016\u0014HoQ8se\u0016\u001cG\u000f\u00165sK\u0006$GC\u0001B1Q\u0015)D1\u0015CX!\u0011!)\u000bb+\u000e\u0005\u0011\u001d&\u0002\u0002CU\u0003#\t!\"\u00198o_R\fG/[8o\u0013\u0011!i\u000bb*\u0003\u0011\u0015d\u0017\u000eZ1cY\u0016l\"a\u0001C\u0002\u00175L7o]5oO\"{wn\u001b\u000b\u0007\tS!)\f\"/\t\u000f\u0011]f\u00071\u0001\u0005*\u0005)qn\u001e8fe\"9A1\u0018\u001cA\u0002\u0011u\u0016\u0001\u00028b[\u0016\u0004BAa\u0006\u0005V\u0005\u0001R.\u001b:s_J$\u0006.\u0019;M_\u0006$W\r\u001a\u000b\u0005\t\u0007$I\r\u0005\u0003\u0003\u0018\u0011\u0015\u0017\u0002\u0002Cd\u0003K\u0012a!T5se>\u0014\bb\u0002Cfo\u0001\u0007A\u0011F\u0001\u0004gfl'A\u0002)fe&|G-\u0001\u0005O_B+'/[8e+\t!\u0019n\u0004\u0002\u0005Vv\t\u0001!A\u0005O_B+'/[8eA\t)!+\u001e8JI\u00069aj\u001c*v]&#\u0017\u0001\u0003(p%Vt\u0017\n\u001a\u0011\u0002\u000fAD7\u000b^1dWV\u0011A1\u001d\t\u0007\tK$yO!2\u000e\u0005\u0011\u001d(\u0002\u0002Cu\tW\fq!\\;uC\ndWM\u0003\u0003\u0005n\u0006E\u0011AC2pY2,7\r^5p]&!A\u0011\u001fCt\u0005)\t%O]1z'R\f7m[\u0001\ta\"\u001cF/Y2lA\u0005\u0011\u0001\u000f[\u0001\u0004a\u0016\u0014\u0018\u0001D1u!\"\f7/Z*uC\u000e\\WC\u0001C\u007f!\u0019\u0019y\u0003b@\u0003F&!Q\u0011AB\u001d\u0005\u0011a\u0015n\u001d;\u0002\u000bAD\u0017m]3\u0002'\u0005$\b\u000b[1tKN#\u0018mY6NKN\u001c\u0018mZ3\u0016\u0005\tU\u0014!\u00039iCN,w\fJ3r)\u0011\u0011\t'\"\u0004\t\u000f\u0011ER\t1\u0001\u0003F\u0006I\u0001/^:i!\"\f7/\u001a\u000b\u0005\u0005\u000b,\u0019\u0002C\u0004\u0005v\u001a\u0003\rA!2\u0002\u0011A|\u0007\u000f\u00155bg\u0016$BA!\u0019\u0006\u001a!9AQ_$A\u0002\t\u0015\u0017AD6fKB\u0004\u0006.Y:f'R\f7m[\u0001\u0013W\u0016,\u0007\u000f\u00155bg\u0016\u001cF/Y2l?\u0012*\u0017\u000f\u0006\u0003\u0003b\u0015\u0005\u0002\"CC\u0012\u0013\u0006\u0005\t\u0019\u0001B\\\u0003\rAH%M\u0001\u0010W\u0016,\u0007\u000f\u00155bg\u0016\u001cF/Y2lA\u0005a1-\u001e:sK:$(+\u001e8JIV\u0011Q1\u0006\t\u0004\u0005/Y\u0014!\u0002:v]&#G\u0003BC\u0016\u000bcAq!b\rM\u0001\u0004))$\u0001\u0004qKJLw\u000e\u001a\t\u0004\u0005/A\u0014a\u00029iCN,\u0017\n\u001a\u000b\u0005\u0007\u0007*Y\u0004C\u0004\u000645\u0003\r!\"\u000e\u0002\u001b\r,(O]3oiB+'/[8e+\t))$A\u0004qQ\u0006\u001cXm\u00144\u0015\t\t\u0015WQ\t\u0005\b\u000bgy\u0005\u0019AC\u001b)\u0019))$\"\u0013\u0006N!9Q1\n)A\u0002\u0015-\u0012a\u0001:jI\"9Qq\n)A\u0002\r\r\u0013a\u00019jI\u0006q\u0011n]!u!\"\f7/Z!gi\u0016\u0014H\u0003\u0002B\\\u000b+Bq\u0001\"\rR\u0001\u0004\u0011)-A\u0007f]R,'/\u001b8h!\"\f7/Z\u000b\u0005\u000b7*\t\u0007\u0006\u0003\u0006^\u0015%D\u0003BC0\u000bG\u0002Baa\u0019\u0006b\u001191q\r*C\u0002\r%\u0004\u0002CC3%\u0012\u0005\r!b\u001a\u0002\u0005=\u0004\bC\u0002B\u0010\u0005[*y\u0006C\u0004\u0005vJ\u0003\rA!2)\u0007I\u001bI\"A\tgS:$\u0007\u000b[1tK^KG\u000f\u001b(b[\u0016$BA!2\u0006r!9Q1O*A\u0002\t\u001d\u0015!\u00039iCN,g*Y7f\u0003U)g\u000e^3sS:<\u0007\u000b[1tK^KG\u000f\u001b(b[\u0016,B!\"\u001f\u0006\u0000Q!Q1PCD)\u0011)i(\"!\u0011\t\r\rTq\u0010\u0003\b\u0007O\"&\u0019AB5\u0011!)\u0019\t\u0016CA\u0002\u0015\u0015\u0015\u0001\u00022pIf\u0004bAa\b\u0003n\u0015u\u0004bBC:)\u0002\u0007!qQ\u0001\u0019g2|wOQ;u'\u00064W-\u00128uKJLgn\u001a)iCN,W\u0003BCG\u000b'#B!b$\u0006\u001aR!Q\u0011SCK!\u0011\u0019\u0019'b%\u0005\u000f\r\u001dTK1\u0001\u0004j!AQQM+\u0005\u0002\u0004)9\n\u0005\u0004\u0003 \t5T\u0011\u0013\u0005\b\tk,\u0006\u0019\u0001Bc\u00031)\u00070\u001b;j]\u001e\u0004\u0006.Y:f+\u0011)y*\"*\u0015\t\u0015\u0005V1\u0016\u000b\u0005\u000bG+9\u000b\u0005\u0003\u0004d\u0015\u0015FaBB4-\n\u00071\u0011\u000e\u0005\t\u000bK2F\u00111\u0001\u0006*B1!q\u0004B7\u000bGCq\u0001\">W\u0001\u0004\u0011)\rK\u0002W\u00073\t\u0011#\u001a8uKJLgn\u001a)sKZ\u0004\u0006.Y:f+\u0011)\u0019,b.\u0015\t\u0015UV\u0011\u0018\t\u0005\u0007G*9\fB\u0004\u0004h]\u0013\ra!\u001b\t\u0011\u0015\u0015t\u000b\"a\u0001\u000bw\u0003bAa\b\u0003n\u0015U\u0006fA,\u0004\u001a\u0005IRM\u001c;fe&tw\r\u00155bg\u0016tu\u000e\u001e'bi\u0016\u0014H\u000b[1o+\u0011)\u0019-\"3\u0015\t\u0015\u0015Wq\u001a\u000b\u0005\u000b\u000f,Y\r\u0005\u0003\u0004d\u0015%GaBB41\n\u00071\u0011\u000e\u0005\t\u000bKBF\u00111\u0001\u0006NB1!q\u0004B7\u000b\u000fDq!\"5Y\u0001\u0004\u0011)-\u0001\u0004uCJ<W\r\u001e\u0015\u00041\u000ee\u0011\u0001J:m_^\u0014U\u000f^*bM\u0016,e\u000e^3sS:<\u0007\u000b[1tK:{G\u000fT1uKJ$\u0006.\u00198\u0016\t\u0015eWq\u001c\u000b\u0005\u000b7,)\u000f\u0006\u0003\u0006^\u0016\u0005\b\u0003BB2\u000b?$qaa\u001aZ\u0005\u0004\u0019I\u0007\u0003\u0005\u0006fe#\t\u0019ACr!\u0019\u0011yB!\u001c\u0006^\"9Q\u0011[-A\u0002\t\u0015\u0017aB5t-\u0006d\u0017\u000e\u001a\u000b\u0005\u0005o+Y\u000fC\u0004\u00064i\u0003\r!\"\u000e\u0002+%\u001ch+\u00197jI\u001a{'OQ1tK\u000ec\u0017m]:fgR!!qWCy\u0011\u001d)\u0019d\u0017a\u0001\u000bk\t\u0011c\u001c9f]B\u000b7m[1hK6{G-\u001e7f)\u0019\u0011\t'b>\u0006|\"9Q\u0011 /A\u0002\u0011%\u0012!C2p]R\f\u0017N\\3s\u0011\u001d)i\u0010\u0018a\u0001\tS\tA\u0001Z3ti\u0006y\u0011M\u001d:bsR{'+\u001a9fCR,G\r\u0006\u0003\u0007\u0004\u0019%\u0001\u0003\u0002B\f\r\u000bIAAb\u0002\u0002B\t!A+\u001f9f\u0011\u001d1Y!\u0018a\u0001\r\u0007\t!\u0001\u001e9\u0003\u0013MKX\u000eT8bI\u0016\u00148c\u00010\u0007\u0012A!!q\u0003D\n\u0013\u00111)\"!\u0011\u0003\u00111\u000b'0\u001f+za\u0016$\"A\"\u0007\u0011\u0007\t]a,\u0001\u0006ge>l7k\\;sG\u0016$BA!\u0019\u0007 !9a\u0011E1A\u0002\u0011%\u0012\u0001\u00039lO\u000ec\u0017m]:\u0002\u0019A,'OU;o\u0007\u0006\u001c\u0007.Z:\u0011\u0007\t]1M\u0001\u0007qKJ\u0014VO\\\"bG\",7oE\u0002d\u0005;!\"A\"\n\u0002\r\r\f7\r[3t+\t1\t\u0004\u0005\u0004\u00074\u0019eb1H\u0007\u0003\rkQAAb\u000e\u0005l\u0006I\u0011.\\7vi\u0006\u0014G.Z\u0005\u0005\u000b\u00031)\u0004\u0005\u0004\u0007>\u0019\rcqI\u0007\u0003\r\u007fQAA\"\u0011\u0003z\u0005\u0019!/\u001a4\n\t\u0019\u0015cq\b\u0002\u000e/\u0016\f7NU3gKJ,gnY3\u0011\t\u0019%cqJ\u0007\u0003\r\u0017RAA\"\u0014\u0005l\u00069q-\u001a8fe&\u001c\u0017\u0002\u0002D)\r\u0017\u0012\u0011b\u00117fCJ\f'\r\\3\u0002\u0015\r\f7\r[3t?\u0012*\u0017\u000f\u0006\u0003\u0003b\u0019]\u0003\"CC\u0012M\u0006\u0005\t\u0019\u0001D\u0019\u0003\u001d\u0019\u0017m\u00195fg\u0002\n!B[1wC\u000e\u000b7\r[3t+\t1y\u0006\u0005\u0004\u00074\u0019eb\u0011\r\u0019\u0005\rG2Y\u0007\u0005\u0004\u0002(\u0019\u0015d\u0011N\u0005\u0005\rO\nICA\u0007KCZ\f7\t\\3be\u0006\u0014G.\u001a\t\u0005\u0007G2Y\u0007B\u0006\u0007n)\f\t\u0011!A\u0003\u0002\r%$aA0%c\u0005Y!.\u0019<b\u0007\u0006\u001c\u0007.Z:!\u00039Q\u0017M^1DC\u000eDWm]0%KF$BA!\u0019\u0007v!IQ1E5\u0002\u0002\u0003\u0007aqL\u0001\fe\u0016\u001cwN\u001d3DC\u000eDW-\u0006\u0003\u0007|\u0019}D\u0003\u0002D?\r\u0007\u0003Baa\u0019\u0007\u0000\u001191qM6C\u0002\u0019\u0005\u0015\u0003BB6\r\u000fBqA\"\"l\u0001\u00041i(A\u0003dC\u000eDW-A\tsK\u000e|'\u000fZ\"mCN\u001cHn\\1eKJ$BAb#\u0007\u0012B!!q\u000fDG\u0013\u00111yI!\u001f\u0003\u0017\rc\u0017m]:M_\u0006$WM\u001d\u0005\b\r'c\u0007\u0019\u0001DF\u0003\u0019aw.\u00193fe\u0006iQO\u001c:fG>\u0014HmQ1dQ\u0016,BA\"'\u0007 R!!\u0011\rDN\u0011\u001d1))\u001ca\u0001\r;\u0003Baa\u0019\u0007 \u001291qM7C\u0002\u0019\u0005\u0015\u0001C2mK\u0006\u0014\u0018\t\u001c7\u0002\u00159,woV3bW6\u000b\u0007/\u0006\u0004\u0007(\u001aEfq\u0017\u000b\u0003\rS\u0003\u0002\u0002\":\u0007,\u001a=fQW\u0005\u0005\r[#9OA\u0006XK\u0006\\\u0007*Y:i\u001b\u0006\u0004\b\u0003BB2\rc#qAb-p\u0005\u0004\u0019IGA\u0001L!\u0011\u0019\u0019Gb.\u0005\u000f\u0019evN1\u0001\u0004j\t\ta+\u0001\u0004oK^l\u0015\r]\u000b\u0007\r\u007f3IM\"4\u0015\u0005\u0019\u0005\u0007\u0003\u0003Cs\r\u000749Mb3\n\t\u0019\u0015Gq\u001d\u0002\b\u0011\u0006\u001c\b.T1q!\u0011\u0019\u0019G\"3\u0005\u000f\u0019M\u0006O1\u0001\u0004jA!11\rDg\t\u001d1I\f\u001db\u0001\u0007S\naA\\3x'\u0016$X\u0003\u0002Dj\r;$\"A\"6\u0011\r\u0011\u0015hq\u001bDn\u0013\u00111I\u000eb:\u0003\u000f!\u000b7\u000f[*fiB!11\rDo\t\u001d1\u0019,\u001db\u0001\u0007S\n!B\\3x/\u0016\f7nU3u+\u00111\u0019O\"<\u0015\u0005\u0019\u0015\bCBA\u0014\rO4Y/\u0003\u0003\u0007j\u0006%\"aC,fC.D\u0015m\u001d5TKR\u0004Baa\u0019\u0007n\u00129a1\u0017:C\u0002\u0019=\u0018\u0003BB6\u0005;\tAB\\3x\u0003:L(+\u001a4NCB,bA\">\u0007\u0000\u001e\rAC\u0001D|!!!)O\"?\u0007~\u001e\u0005\u0011\u0002\u0002D~\tO\u0014\u0011\"\u00118z%\u00164W*\u00199\u0011\t\r\rdq \u0003\b\rg\u001b(\u0019\u0001Dx!\u0011\u0019\u0019gb\u0001\u0005\u000f\u0019e6O1\u0001\u0004j\u0005Qa.Z<HK:,'/[2\u0016\t\u001d%q1\u0003\u000b\u0007\u000f\u00179)bb\u0007\u0011\r\t}qQBD\t\u0013\u00119y!!\u0005\u0003\u0013\u0019+hn\u0019;j_:\u0004\u0004\u0003BB2\u000f'!qaa\u001au\u0005\u0004\u0019I\u0007\u0003\u0005\b\u0018Q$\t\u0019AD\r\u0003\u00051\u0007C\u0002B\u0010\u0005[:\t\u0002C\u0005\b\u001eQ\u0004\n\u00111\u0001\b \u000591\r\\3b]V\u0004\b\u0003\u0003B\u0010\u0007/<\tB!\u0019\u0002)9,woR3oKJL7\r\n3fM\u0006,H\u000e\u001e\u00133+\u00119)c\"\u000f\u0016\u0005\u001d\u001d\"\u0006BD\u0015\u000fW\u0001\u0002Ba\b\u0004X\u000eE$\u0011M\u0016\u0003\u000f[\u0001Bab\f\b65\u0011q\u0011\u0007\u0006\u0005\u000fg!9+A\u0005v]\u000eDWmY6fI&!qqGD\u0019\u0005E)hn\u00195fG.,GMV1sS\u0006t7-\u001a\u0003\b\u0007O*(\u0019AB5\u0003AIgNZ8Ue\u0006t7OZ8s[\u0016\u00148/\u0006\u0002\b@A!!qCD!\u0013\u00119\u0019%! \u0003\u001f%sgm\u001c+sC:\u001chm\u001c:nKJ\fA#\u001b8g_R\u0013\u0018M\\:g_JlWM]:`I\u0015\fH\u0003\u0002B1\u000f\u0013B\u0011\"b\tx\u0003\u0003\u0005\rab\u0010\u0002#%tgm\u001c+sC:\u001chm\u001c:nKJ\u001c\b%A\u0005NCb\u0004\u0006.Y:fgV\u0011q\u0011K\b\u0003\u000f'j\"!\u0001\u0001\u0002\u00155\u000b\u0007\u0010\u00155bg\u0016\u001c\b%A\u0006qQ\u0006\u001cXmV5uQ&#WCAD.!\u0019\u0011yb\"\u0018\u0003F&!qqLA\t\u0005\u0015\t%O]1z\u00031\u0001\b.Y:f/&$\b.\u00133!\u0003II7oQ8na&dWM]+oSZ,'o]3\u0002\u000f\u0005$\b\u000b[1tKV!q\u0011ND8)\u00119Yg\"\u001e\u0015\t\u001d5t\u0011\u000f\t\u0005\u0007G:y\u0007B\u0004\u0004hy\u0014\ra!\u001b\t\u0011\u0015\u0015d\u0010\"a\u0001\u000fg\u0002bAa\b\u0003n\u001d5\u0004b\u0002C{}\u0002\u0007!Q\u0019\u0015\u0004}\u000ee\u0001f\u0002@\u0003`\u001emtqP\u0011\u0003\u000f{\n\u0011#^:fA\u0015tG/\u001a:j]\u001e\u0004\u0006.Y:fC\t9\t)\u0001\u00043]E\u0002d\u0006M\u0001\u001c'R\u0014\u0018N\\4D_:$X\r\u001f;TiJL\u0007/T1sO&tw\n]:\u0016\u0005\u001d\u001d\u0005\u0003\u0003B\u0010\u0007/<Iib$\u0011\t\t}q1R\u0005\u0005\u000f\u001b\u000b\tBA\u0007TiJLgnZ\"p]R,\u0007\u0010\u001e\t\u0005\u000f#;IJ\u0004\u0003\b\u0014\u001e]e\u0002BA\u001a\u000f+KA!a\u000b\u0002\n%!11GA\u0015\u0013\u00119Yj\"(\u00037M#(/\u001b8h\u0007>tG/\u001a=u'R\u0014\u0018\u000e]'be\u001eLgn\u00149t\u0015\u0011\u0019\u0019$!\u000b\u00029M#(/\u001b8h\u0007>tG/\u001a=u'R\u0014\u0018\u000e]'be\u001eLgn\u00149tA\u0005\u00113-\u001e:sK:$(+\u001e8Qe>4\u0017\u000e\\3s\u0005\u00164wN]3D_6\u0004H.\u001a;j_:$bA!\u0019\b&\u001e%\u0006\u0002CDT\u0003\u0007\u0001\r\u0001\"\u000b\u0002\tI|w\u000e\u001e\u0005\t\u000fW\u000b\u0019\u00011\u0001\b.\u0006q\u0011m]:pG&\fG/\u001a3GS2,\u0007\u0003BDX\u000fkk!a\"-\u000b\t\u001dM\u0016QB\u0001\u0003S>LAab.\b2\na\u0011IY:ue\u0006\u001cGOR5mK\u0006\t3-\u001e:sK:$(+\u001e8Qe>4\u0017\u000e\\3s\u0003\u001a$XM]\"p[BdW\r^5p]R1!\u0011MD_\u000f\u007fC\u0001bb*\u0002\u0006\u0001\u0007A\u0011\u0006\u0005\t\u000fW\u000b)\u00011\u0001\b.\u0002")
public abstract class SymbolTable
extends Universe
implements Names,
Symbols,
Types,
Variances,
Kinds,
ExistentialsAndSkolems,
FlagSets,
Scopes,
Mirrors,
Definitions,
Constants,
BaseTypeSeqs,
InfoTransformers,
Transforms,
StdNames,
AnnotationInfos,
AnnotationCheckers,
Trees,
Printers,
Positions,
TypeDebugging,
Importers,
CapturedVariables,
StdAttachments,
StdCreators,
ReificationSupport,
PrivateWithin,
Translations,
FreshNames,
Internals,
Reporting {
    private volatile SymbolTable$SimpleNameOrdering$ SimpleNameOrdering$module;
    private volatile SymbolTable$traceSymbols$ traceSymbols$module;
    private volatile SymbolTable$perRunCaches$ perRunCaches$module;
    private final TreeGen gen;
    private final boolean traceSymbolActivity;
    private final ArrayStack<Phase> phStack;
    private Phase ph;
    private int per;
    private boolean keepPhaseStack;
    private InfoTransformers.InfoTransformer infoTransformers;
    private final Phase[] phaseWithId;
    private final Function1<StringContext, package.StringContextStripMarginOps> StringContextStripMarginOps;
    private Universe.MacroInternalApi internal;
    private Universe.MacroCompatApi compat;
    private Universe.TreeGen treeBuild;
    private final FreshNameCreator globalFreshNameCreator;
    private volatile FreshNames$FreshNameExtractor$ FreshNameExtractor$module;
    private final ReificationSupport.ReificationSupportImpl build;
    private volatile StdCreators$FixedMirrorTreeCreator$ FixedMirrorTreeCreator$module;
    private volatile StdCreators$FixedMirrorTypeCreator$ FixedMirrorTypeCreator$module;
    private volatile StdAttachments$CompoundTypeTreeOriginalAttachment$ CompoundTypeTreeOriginalAttachment$module;
    private volatile StdAttachments$SAMFunction$ SAMFunction$module;
    private volatile StdAttachments$DelambdafyTarget$ DelambdafyTarget$module;
    private volatile StdAttachments$JustMethodReference$ JustMethodReference$module;
    private volatile StdAttachments$BackquotedIdentifierAttachment$ BackquotedIdentifierAttachment$module;
    private volatile StdAttachments$NoWarnAttachment$ NoWarnAttachment$module;
    private volatile StdAttachments$PatVarDefAttachment$ PatVarDefAttachment$module;
    private volatile StdAttachments$ForAttachment$ ForAttachment$module;
    private volatile StdAttachments$SyntheticUnitAttachment$ SyntheticUnitAttachment$module;
    private volatile StdAttachments$SubpatternsAttachment$ SubpatternsAttachment$module;
    private volatile StdAttachments$NoInlineCallsiteAttachment$ NoInlineCallsiteAttachment$module;
    private volatile StdAttachments$InlineCallsiteAttachment$ InlineCallsiteAttachment$module;
    private volatile StdAttachments$OuterArgCanBeElided$ OuterArgCanBeElided$module;
    private volatile StdAttachments$UseInvokeSpecial$ UseInvokeSpecial$module;
    private volatile StdAttachments$TypeParamVarargsAttachment$ TypeParamVarargsAttachment$module;
    private volatile StdAttachments$KnownDirectSubclassesCalled$ KnownDirectSubclassesCalled$module;
    private volatile StdAttachments$ChangeOwnerAttachment$ ChangeOwnerAttachment$module;
    private volatile TypeDebugging$noPrint$ noPrint$module;
    private volatile TypeDebugging$typeDebug$ typeDebug$module;
    private final NoPosition$ NoPosition;
    private final ClassTag<Position> PositionTag;
    private final Ordering<Trees.Tree> scala$reflect$internal$Positions$$posStartOrdering;
    private final ReusableInstance<Positions.SetChildrenPosAccumulator> scala$reflect$internal$Positions$$setChildrenPosAccumulator;
    private Positions.PosAssigner posAssigner;
    private volatile Printers$ConsoleWriter$ ConsoleWriter$module;
    private int nodeCount;
    private volatile Trees$RefTree$ RefTree$module;
    private volatile Trees$PackageDef$ PackageDef$module;
    private volatile Trees$ClassDef$ ClassDef$module;
    private volatile Trees$ModuleDef$ ModuleDef$module;
    private volatile Trees$ValOrDefDef$ ValOrDefDef$module;
    private volatile Trees$ValDef$ ValDef$module;
    private volatile Trees$DefDef$ DefDef$module;
    private volatile Trees$TypeDef$ TypeDef$module;
    private volatile Trees$LabelDef$ LabelDef$module;
    private volatile Trees$ImportSelector$ ImportSelector$module;
    private volatile Trees$Import$ Import$module;
    private volatile Trees$Template$ Template$module;
    private volatile Trees$Block$ Block$module;
    private volatile Trees$CaseDef$ CaseDef$module;
    private volatile Trees$Alternative$ Alternative$module;
    private volatile Trees$Star$ Star$module;
    private volatile Trees$Bind$ Bind$module;
    private volatile Trees$UnApply$ UnApply$module;
    private volatile Trees$ArrayValue$ ArrayValue$module;
    private volatile Trees$Function$ Function$module;
    private volatile Trees$Assign$ Assign$module;
    private volatile Trees$AssignOrNamedArg$ AssignOrNamedArg$module;
    private volatile Trees$If$ If$module;
    private volatile Trees$Match$ Match$module;
    private volatile Trees$Return$ Return$module;
    private volatile Trees$Try$ Try$module;
    private volatile Trees$Throw$ Throw$module;
    private volatile Trees$New$ New$module;
    private volatile Trees$Typed$ Typed$module;
    private volatile Trees$MethodValue$ MethodValue$module;
    private volatile Trees$TypeApply$ TypeApply$module;
    private volatile Trees$Apply$ Apply$module;
    private volatile Trees$ApplyDynamic$ ApplyDynamic$module;
    private volatile Trees$Super$ Super$module;
    private volatile Trees$This$ This$module;
    private volatile Trees$Select$ Select$module;
    private volatile Trees$Ident$ Ident$module;
    private volatile Trees$ReferenceToBoxed$ ReferenceToBoxed$module;
    private volatile Trees$Literal$ Literal$module;
    private volatile Trees$Annotated$ Annotated$module;
    private volatile Trees$SingletonTypeTree$ SingletonTypeTree$module;
    private volatile Trees$SelectFromTypeTree$ SelectFromTypeTree$module;
    private volatile Trees$CompoundTypeTree$ CompoundTypeTree$module;
    private volatile Trees$AppliedTypeTree$ AppliedTypeTree$module;
    private volatile Trees$TypeBoundsTree$ TypeBoundsTree$module;
    private volatile Trees$ExistentialTypeTree$ ExistentialTypeTree$module;
    private volatile Trees$TypeTree$ TypeTree$module;
    private volatile Trees$Modifiers$ Modifiers$module;
    private final ClassTag<Trees.Modifiers> ModifiersTag;
    private volatile Trees$EmptyTree$ EmptyTree$module;
    private volatile Trees$noSelfType$ noSelfType$module;
    private volatile Trees$pendingSuperCall$ pendingSuperCall$module;
    private Trees$noSelfType$ emptyValDef;
    private Trees.TreeTypeSubstituter EmptyTreeTypeSubstituter;
    private Trees.Duplicator scala$reflect$internal$Trees$$duplicator;
    private volatile Trees$duplicateAndResetPos$ duplicateAndResetPos$module;
    private final ReusableInstance<Trees.OnlyChildAccumulator> scala$reflect$internal$Trees$$onlyChildAccumulator;
    private final ClassTag<Trees.Alternative> AlternativeTag;
    private final ClassTag<Trees.Annotated> AnnotatedTag;
    private final ClassTag<Trees.AppliedTypeTree> AppliedTypeTreeTag;
    private final ClassTag<Trees.Apply> ApplyTag;
    private final ClassTag<Trees.AssignOrNamedArg> AssignOrNamedArgTag;
    private final ClassTag<Trees.Assign> AssignTag;
    private final ClassTag<Trees.Bind> BindTag;
    private final ClassTag<Trees.Block> BlockTag;
    private final ClassTag<Trees.CaseDef> CaseDefTag;
    private final ClassTag<Trees.ClassDef> ClassDefTag;
    private final ClassTag<Trees.CompoundTypeTree> CompoundTypeTreeTag;
    private final ClassTag<Trees.DefDef> DefDefTag;
    private final ClassTag<Trees.DefTree> DefTreeTag;
    private final ClassTag<Trees.ExistentialTypeTree> ExistentialTypeTreeTag;
    private final ClassTag<Trees.Function> FunctionTag;
    private final ClassTag<Trees.GenericApply> GenericApplyTag;
    private final ClassTag<Trees.Ident> IdentTag;
    private final ClassTag<Trees.If> IfTag;
    private final ClassTag<Trees.ImplDef> ImplDefTag;
    private final ClassTag<Trees.ImportSelector> ImportSelectorTag;
    private final ClassTag<Trees.Import> ImportTag;
    private final ClassTag<Trees.LabelDef> LabelDefTag;
    private final ClassTag<Trees.Literal> LiteralTag;
    private final ClassTag<Trees.Match> MatchTag;
    private final ClassTag<Trees.MemberDef> MemberDefTag;
    private final ClassTag<Trees.ModuleDef> ModuleDefTag;
    private final ClassTag<Trees.NameTree> NameTreeTag;
    private final ClassTag<Trees.New> NewTag;
    private final ClassTag<Trees.PackageDef> PackageDefTag;
    private final ClassTag<Trees.ReferenceToBoxed> ReferenceToBoxedTag;
    private final ClassTag<Trees.RefTree> RefTreeTag;
    private final ClassTag<Trees.Return> ReturnTag;
    private final ClassTag<Trees.SelectFromTypeTree> SelectFromTypeTreeTag;
    private final ClassTag<Trees.Select> SelectTag;
    private final ClassTag<Trees.SingletonTypeTree> SingletonTypeTreeTag;
    private final ClassTag<Trees.Star> StarTag;
    private final ClassTag<Trees.Super> SuperTag;
    private final ClassTag<Trees.SymTree> SymTreeTag;
    private final ClassTag<Trees.Template> TemplateTag;
    private final ClassTag<Trees.TermTree> TermTreeTag;
    private final ClassTag<Trees.This> ThisTag;
    private final ClassTag<Trees.Throw> ThrowTag;
    private final ClassTag<Trees.Tree> TreeTag;
    private final ClassTag<Trees.Try> TryTag;
    private final ClassTag<Trees.TypTree> TypTreeTag;
    private final ClassTag<Trees.TypeApply> TypeApplyTag;
    private final ClassTag<Trees.TypeBoundsTree> TypeBoundsTreeTag;
    private final ClassTag<Trees.TypeDef> TypeDefTag;
    private final ClassTag<Trees.TypeTree> TypeTreeTag;
    private final ClassTag<Trees.Typed> TypedTag;
    private final ClassTag<Trees.UnApply> UnApplyTag;
    private final ClassTag<Trees.ValDef> ValDefTag;
    private final ClassTag<Trees.ValOrDefDef> ValOrDefDefTag;
    private List<AnnotationCheckers.AnnotationChecker> scala$reflect$internal$AnnotationCheckers$$annotationCheckers;
    private final ClassTag<AnnotationInfos.ClassfileAnnotArg> JavaArgumentTag;
    private volatile AnnotationInfos$UnmappableAnnotArg$ UnmappableAnnotArg$module;
    private volatile AnnotationInfos$LiteralAnnotArg$ LiteralAnnotArg$module;
    private volatile AnnotationInfos$ArrayAnnotArg$ ArrayAnnotArg$module;
    private volatile AnnotationInfos$NestedAnnotArg$ NestedAnnotArg$module;
    private final AnnotationInfos$LiteralAnnotArg$ LiteralArgument;
    private final ClassTag<AnnotationInfos.LiteralAnnotArg> LiteralArgumentTag;
    private final AnnotationInfos$ArrayAnnotArg$ ArrayArgument;
    private final ClassTag<AnnotationInfos.ArrayAnnotArg> ArrayArgumentTag;
    private final AnnotationInfos$NestedAnnotArg$ NestedArgument;
    private final ClassTag<AnnotationInfos.NestedAnnotArg> NestedArgumentTag;
    private volatile AnnotationInfos$ScalaSigBytes$ ScalaSigBytes$module;
    private volatile AnnotationInfos$AnnotationInfo$ AnnotationInfo$module;
    private volatile AnnotationInfos$Annotation$ Annotation$module;
    private final ClassTag<AnnotationInfos.AnnotationInfo> AnnotationTag;
    private volatile AnnotationInfos$UnmappableAnnotation$ UnmappableAnnotation$module;
    private volatile AnnotationInfos$ThrownException$ ThrownException$module;
    private volatile StdNames$compactify$ compactify$module;
    private StdNames$tpnme$ typeNames;
    private volatile StdNames$tpnme$ tpnme$module;
    private volatile StdNames$fulltpnme$ fulltpnme$module;
    private volatile StdNames$binarynme$ binarynme$module;
    private final StdNames.JavaKeywords javanme;
    private StdNames$nme$ termNames;
    private volatile StdNames$nme$ nme$module;
    private StdNames.SymbolNames sn;
    private final Transforms.Lazy<UnCurry> scala$reflect$internal$transform$Transforms$$uncurryLazy;
    private final Transforms.Lazy<Erasure> scala$reflect$internal$transform$Transforms$$erasureLazy;
    private final Transforms.Lazy<PostErasure> scala$reflect$internal$transform$Transforms$$postErasureLazy;
    private BaseTypeSeqs.BaseTypeSeq undetBaseTypeSeq;
    private final Throwable CyclicInheritance;
    private volatile Constants$Constant$ Constant$module;
    private final ClassTag<Constants.Constant> ConstantTag;
    private volatile Definitions$definitions$ definitions$module;
    private int scopeCount;
    private volatile Scopes$LookupSucceeded$ LookupSucceeded$module;
    private volatile Scopes$LookupAmbiguous$ LookupAmbiguous$module;
    private volatile Scopes$LookupInaccessible$ LookupInaccessible$module;
    private volatile Scopes$LookupNotFound$ LookupNotFound$module;
    private volatile Scopes$Scope$ Scope$module;
    private final ClassTag<Scopes.Scope> ScopeTag;
    private final ClassTag<Scopes.Scope> MemberScopeTag;
    private volatile Scopes$EmptyScope$ EmptyScope$module;
    private final ClassTag<Object> FlagSetTag;
    private final long NoFlags;
    private volatile FlagSets$Flag$ Flag$module;
    private volatile Kinds$KindErrors$ KindErrors$module;
    private final Kinds.KindErrors NoKindErrors;
    private volatile Kinds$Kind$ Kind$module;
    private volatile Kinds$ProperTypeKind$ ProperTypeKind$module;
    private volatile Kinds$TypeConKind$ TypeConKind$module;
    private volatile Kinds$inferKind$ inferKind$module;
    private final ReusableInstance<Variances.varianceInType> scala$reflect$internal$Variances$$varianceInTypeCache;
    private boolean scala$reflect$internal$Types$$explainSwitch;
    private final Set<Symbols.Symbol> scala$reflect$internal$Types$$emptySymbolSet;
    private final boolean scala$reflect$internal$Types$$propagateParameterBoundsToTypeVars;
    private final boolean scala$reflect$internal$Types$$sharperSkolems;
    private volatile Types$substTypeMapCache$ substTypeMapCache$module;
    private int scala$reflect$internal$Types$$_skolemizationLevel;
    private final WeakHashMap<List<Types.Type>, WeakReference<Types.Type>> scala$reflect$internal$Types$$_intersectionWitness;
    private volatile Types$UnmappableTree$ UnmappableTree$module;
    private volatile Types$ErrorType$ ErrorType$module;
    private volatile Types$WildcardType$ WildcardType$module;
    private volatile Types$BoundedWildcardType$ BoundedWildcardType$module;
    private volatile Types$NoType$ NoType$module;
    private volatile Types$NoPrefix$ NoPrefix$module;
    private volatile Types$ThisType$ ThisType$module;
    private volatile Types$SingleType$ SingleType$module;
    private volatile Types$SuperType$ SuperType$module;
    private volatile Types$TypeBounds$ TypeBounds$module;
    private volatile Types$CompoundType$ CompoundType$module;
    private volatile Types$RefinedType$ RefinedType$module;
    private volatile Types$ClassInfoType$ ClassInfoType$module;
    private volatile Types$ConstantType$ ConstantType$module;
    private volatile Types$TypeRef$ TypeRef$module;
    private volatile Types$MethodType$ MethodType$module;
    private volatile Types$NullaryMethodType$ NullaryMethodType$module;
    private volatile Types$PolyType$ PolyType$module;
    private volatile Types$ExistentialType$ ExistentialType$module;
    private volatile Types$OverloadedType$ OverloadedType$module;
    private volatile Types$ImportType$ ImportType$module;
    private volatile Types$AntiPolyType$ AntiPolyType$module;
    private volatile Types$HasTypeMember$ HasTypeMember$module;
    private volatile Types$ArrayTypeRef$ ArrayTypeRef$module;
    private volatile Types$TypeVar$ TypeVar$module;
    private volatile Types$AnnotatedType$ AnnotatedType$module;
    private volatile Types$StaticallyAnnotatedType$ StaticallyAnnotatedType$module;
    private volatile Types$NamedType$ NamedType$module;
    private volatile Types$RepeatedType$ RepeatedType$module;
    private volatile Types$ErasedValueType$ ErasedValueType$module;
    private volatile Types$GenPolyType$ GenPolyType$module;
    private final int scala$reflect$internal$Types$$initialUniquesCapacity;
    private WeakHashSet<Types.Type> scala$reflect$internal$Types$$uniques;
    private int scala$reflect$internal$Types$$uniqueRunId;
    private volatile Types$unwrapToClass$ unwrapToClass$module;
    private volatile Types$unwrapToStableClass$ unwrapToStableClass$module;
    private volatile Types$unwrapWrapperTypes$ unwrapWrapperTypes$module;
    private final Types.MissingAliasControl missingAliasException;
    private int scala$reflect$internal$Types$$_basetypeRecursions;
    private final HashSet<Types.Type> scala$reflect$internal$Types$$_pendingBaseTypes;
    private volatile Types$RecoverableCyclicReference$ RecoverableCyclicReference$module;
    private String scala$reflect$internal$Types$$_indent;
    private final Set<String> shorthands;
    private final Function1<Trees.Tree, Types.Type> treeTpe;
    private final Function1<Types.Type, Object> typeContainsTypeVar;
    private final Function1<Types.Type, Object> typeIsSubTypeOfSerializable;
    private final ClassTag<Types.AnnotatedType> AnnotatedTypeTag;
    private final ClassTag<Types.BoundedWildcardType> BoundedWildcardTypeTag;
    private final ClassTag<Types.ClassInfoType> ClassInfoTypeTag;
    private final ClassTag<Types.CompoundType> CompoundTypeTag;
    private final ClassTag<Types.ConstantType> ConstantTypeTag;
    private final ClassTag<Types.ExistentialType> ExistentialTypeTag;
    private final ClassTag<Types.MethodType> MethodTypeTag;
    private final ClassTag<Types.NullaryMethodType> NullaryMethodTypeTag;
    private final ClassTag<Types.PolyType> PolyTypeTag;
    private final ClassTag<Types.RefinedType> RefinedTypeTag;
    private final ClassTag<Types.SingletonType> SingletonTypeTag;
    private final ClassTag<Types.SingleType> SingleTypeTag;
    private final ClassTag<Types.SuperType> SuperTypeTag;
    private final ClassTag<Types.ThisType> ThisTypeTag;
    private final ClassTag<Types.TypeBounds> TypeBoundsTag;
    private final ClassTag<Types.TypeRef> TypeRefTag;
    private final ClassTag<Types.Type> TypeTagg;
    private final ReusableInstance<FindMembers.FindMember> findMemberInstance;
    private TypeConstraints.UndoLog scala$reflect$internal$tpe$TypeConstraints$$_undoLog;
    private Types.Type scala$reflect$internal$tpe$TypeConstraints$$numericLoBound;
    private Types.Type scala$reflect$internal$tpe$TypeConstraints$$numericHiBound;
    private volatile TypeConstraints$TypeConstraint$ TypeConstraint$module;
    private volatile TypeMaps$normalizeAliases$ normalizeAliases$module;
    private volatile TypeMaps$dropSingletonType$ dropSingletonType$module;
    private volatile TypeMaps$abstractTypesToBounds$ abstractTypesToBounds$module;
    private volatile TypeMaps$dropIllegalStarTypes$ dropIllegalStarTypes$module;
    private volatile TypeMaps$wildcardExtrapolation$ wildcardExtrapolation$module;
    private volatile TypeMaps$IsDependentCollector$ IsDependentCollector$module;
    private volatile TypeMaps$ApproximateDependentMap$ ApproximateDependentMap$module;
    private volatile TypeMaps$wildcardToTypeVarMap$ wildcardToTypeVarMap$module;
    private volatile TypeMaps$typeVarToOriginMap$ typeVarToOriginMap$module;
    private volatile TypeMaps$ErroneousCollector$ ErroneousCollector$module;
    private volatile TypeMaps$adaptToNewRunMap$ adaptToNewRunMap$module;
    private final boolean scala$reflect$internal$tpe$GlbLubs$$printLubs;
    private final MutableSettings.SettingValue scala$reflect$internal$tpe$GlbLubs$$strictInference;
    private final HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type> scala$reflect$internal$tpe$GlbLubs$$_lubResults;
    private final HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type> scala$reflect$internal$tpe$GlbLubs$$_glbResults;
    private final Throwable GlbFailure;
    private int scala$reflect$internal$tpe$GlbLubs$$globalGlbDepth;
    private final int scala$reflect$internal$tpe$GlbLubs$$globalGlbLimit;
    private CommonOwners.CommonOwnerMap scala$reflect$internal$tpe$CommonOwners$$commonOwnerMapObj;
    private int scala$reflect$internal$tpe$TypeToStrings$$_toStringRecursions;
    private final HashSet<Types.Type> scala$reflect$internal$tpe$TypeToStrings$$_toStringSubjects;
    private final HashSet<TypeComparers.SubTypePair> scala$reflect$internal$tpe$TypeComparers$$_pendingSubTypes;
    private volatile TypeComparers$SubTypePair$ SubTypePair$module;
    private int scala$reflect$internal$tpe$TypeComparers$$_subsametypeRecursions;
    private int ids;
    private Map<Symbols.Symbol, Object> scala$reflect$internal$Symbols$$_recursionTable;
    private int scala$reflect$internal$Symbols$$_lockedCount;
    private int scala$reflect$internal$Symbols$$existentialIds;
    private final AnyRefMap<Symbols.Symbol, Symbols.Symbol> scala$reflect$internal$Symbols$$originalOwnerMap;
    private volatile Symbols$SymbolKind$ SymbolKind$module;
    private final ClassTag<Symbols.Symbol> SymbolTag;
    private final ClassTag<Symbols.TermSymbol> TermSymbolTag;
    private final ClassTag<Symbols.ModuleSymbol> ModuleSymbolTag;
    private final ClassTag<Symbols.MethodSymbol> MethodSymbolTag;
    private final ClassTag<Symbols.TypeSymbol> TypeSymbolTag;
    private final ClassTag<Symbols.ClassSymbol> ClassSymbolTag;
    private final ClassTag<Symbols.FreeTermSymbol> FreeTermSymbolTag;
    private final ClassTag<Symbols.FreeTypeSymbol> FreeTypeSymbolTag;
    private Symbols.NoSymbol NoSymbol;
    private volatile Symbols$CyclicReference$ CyclicReference$module;
    private volatile Symbols$TypeHistory$ TypeHistory$module;
    private final Function1<Symbols.Symbol, Object> symbolIsPossibleInRefinement;
    private volatile Symbols$SymbolOps$ SymbolOps$module;
    private final Symbols.SymbolOps AllOps;
    private final Object scala$reflect$internal$Names$$nameLock;
    private char[] scala$reflect$internal$Names$$_chrs;
    private int scala$reflect$internal$Names$$nc;
    private final Names.TermName[] scala$reflect$internal$Names$$termHashtable;
    private final Names.TypeName[] scala$reflect$internal$Names$$typeHashtable;
    private final ClassTag<Names.Name> NameTag;
    private final ClassTag<Names.TermName> TermNameTag;
    private volatile Names$TermName$ TermName$module;
    private final ClassTag<Names.TypeName> TypeNameTag;
    private volatile Names$TypeName$ TypeName$module;
    private volatile int bitmap$0;

    @Override
    public String supplementTyperState(String errorMessage) {
        return Reporting.supplementTyperState$(this, errorMessage);
    }

    @Override
    public String supplementErrorMessage(String errorMessage) {
        return Reporting.supplementErrorMessage$(this, errorMessage);
    }

    @Override
    public void inform(String msg) {
        Reporting.inform$(this, msg);
    }

    @Override
    public void warning(String msg) {
        Reporting.warning$(this, msg);
    }

    @Override
    public void globalError(String msg) {
        Reporting.globalError$(this, msg);
    }

    @Override
    public Nothing$ abort(String msg) {
        return Reporting.abort$(this, msg);
    }

    @Override
    public void inform(Position pos, String msg) {
        Reporting.inform$(this, pos, msg);
    }

    @Override
    public void warning(Position pos, String msg) {
        Reporting.warning$(this, pos, msg);
    }

    @Override
    public void globalError(Position pos, String msg) {
        Reporting.globalError$(this, pos, msg);
    }

    @Override
    public Names.TermName freshTermName(String prefix, FreshNameCreator creator) {
        return FreshNames.freshTermName$(this, prefix, creator);
    }

    @Override
    public String freshTermName$default$1() {
        return FreshNames.freshTermName$default$1$(this);
    }

    @Override
    public Names.TypeName freshTypeName(String prefix, FreshNameCreator creator) {
        return FreshNames.freshTypeName$(this, prefix, creator);
    }

    @Override
    public boolean isTreeSymbolPickled(int code) {
        return Translations.isTreeSymbolPickled$((Translations)this, code);
    }

    @Override
    public boolean isTreeSymbolPickled(Trees.Tree tree) {
        return Translations.isTreeSymbolPickled$((Translations)this, tree);
    }

    @Override
    public int picklerTag(Object ref) {
        return Translations.picklerTag$((Translations)this, ref);
    }

    @Override
    public int picklerTag(Symbols.Symbol sym) {
        return Translations.picklerTag$((Translations)this, sym);
    }

    @Override
    public int picklerTag(Types.Type tpe) {
        return Translations.picklerTag$((Translations)this, tpe);
    }

    @Override
    public int picklerSubTag(Trees.Tree tree) {
        return Translations.picklerSubTag$(this, tree);
    }

    @Override
    public void propagatePackageBoundary(Class<?> c, Seq<Symbols.Symbol> syms) {
        PrivateWithin.propagatePackageBoundary$((PrivateWithin)this, c, syms);
    }

    @Override
    public void propagatePackageBoundary(Member m, Seq<Symbols.Symbol> syms) {
        PrivateWithin.propagatePackageBoundary$((PrivateWithin)this, m, syms);
    }

    @Override
    public void propagatePackageBoundary(int jflags, Seq<Symbols.Symbol> syms) {
        PrivateWithin.propagatePackageBoundary$((PrivateWithin)this, jflags, syms);
    }

    @Override
    public Symbols.Symbol setPackageAccessBoundary(Symbols.Symbol sym) {
        return PrivateWithin.setPackageAccessBoundary$(this, sym);
    }

    @Override
    public void captureVariable(Symbols.Symbol vble) {
        CapturedVariables.captureVariable$(this, vble);
    }

    @Override
    public Trees.Tree referenceCapturedVariable(Symbols.Symbol vble) {
        return CapturedVariables.referenceCapturedVariable$(this, vble);
    }

    @Override
    public Types.Type capturedVariableType(Symbols.Symbol vble) {
        return CapturedVariables.capturedVariableType$(this, vble);
    }

    @Override
    public Types.Type capturedVariableType(Symbols.Symbol vble, Types.Type tpe, boolean erasedTypes) {
        return CapturedVariables.capturedVariableType$(this, vble, tpe, erasedTypes);
    }

    @Override
    public Types.Type capturedVariableType$default$2() {
        return CapturedVariables.capturedVariableType$default$2$(this);
    }

    @Override
    public boolean capturedVariableType$default$3() {
        return CapturedVariables.capturedVariableType$default$3$(this);
    }

    @Override
    public Internals.Importer mkImporter(scala.reflect.api.Universe from0) {
        return Importers.mkImporter$(this, from0);
    }

    @Override
    public String paramString(Types.Type tp) {
        return TypeDebugging.paramString$(this, tp);
    }

    @Override
    public String typeParamsString(Types.Type tp) {
        return TypeDebugging.typeParamsString$(this, tp);
    }

    @Override
    public String debugString(Types.Type tp) {
        return TypeDebugging.debugString$(this, tp);
    }

    @Override
    public boolean useOffsetPositions() {
        return Positions.useOffsetPositions$(this);
    }

    @Override
    public Position wrappingPos(Position position, List<Trees.Tree> trees) {
        return Positions.wrappingPos$(this, position, trees);
    }

    @Override
    public Position wrappingPos(Position position, List<Trees.Tree> trees, boolean focus) {
        return Positions.wrappingPos$(this, position, trees, focus);
    }

    @Override
    public Position wrappingPos(List<Trees.Tree> trees) {
        return Positions.wrappingPos$(this, trees);
    }

    @Override
    public void ensureNonOverlapping(Trees.Tree tree, List<Trees.Tree> others) {
        Positions.ensureNonOverlapping$(this, tree, others);
    }

    @Override
    public void ensureNonOverlapping(Trees.Tree tree, List<Trees.Tree> others, boolean focus) {
        Positions.ensureNonOverlapping$(this, tree, others, focus);
    }

    @Override
    public Position rangePos(SourceFile source2, int start, int point, int end) {
        return Positions.rangePos$(this, source2, start, point, end);
    }

    @Override
    public void validatePositions(Trees.Tree tree) {
        Positions.validatePositions$(this, tree);
    }

    @Override
    public <T extends Trees.Tree> T atPos(Position pos, T tree) {
        return (T)Positions.atPos$(this, pos, tree);
    }

    @Override
    public String quotedName(Names.Name name, boolean decode) {
        return Printers.quotedName$(this, name, decode);
    }

    @Override
    public String quotedName(Names.Name name) {
        return Printers.quotedName$((Printers)this, name);
    }

    @Override
    public String quotedName(String name) {
        return Printers.quotedName$((Printers)this, name);
    }

    @Override
    public String decodedSymName(Trees.Tree tree, Names.Name name) {
        return Printers.decodedSymName$(this, tree, name);
    }

    @Override
    public String symName(Trees.Tree tree, Names.Name name) {
        return Printers.symName$(this, tree, name);
    }

    @Override
    public String backquotedPath(Trees.Tree t) {
        return Printers.backquotedPath$(this, t);
    }

    @Override
    public void xprintTree(Printers.TreePrinter treePrinter, Trees.Tree tree) {
        Printers.xprintTree$(this, treePrinter, tree);
    }

    @Override
    public Printers.TreePrinter newCodePrinter(PrintWriter writer, Trees.Tree tree, boolean printRootPkg) {
        return Printers.newCodePrinter$(this, writer, tree, printRootPkg);
    }

    @Override
    public Printers.TreePrinter newTreePrinter(PrintWriter writer) {
        return Printers.newTreePrinter$((Printers)this, writer);
    }

    @Override
    public Printers.TreePrinter newTreePrinter(OutputStream stream) {
        return Printers.newTreePrinter$((Printers)this, stream);
    }

    @Override
    public Printers.TreePrinter newTreePrinter() {
        return Printers.newTreePrinter$(this);
    }

    @Override
    public Printers.RawTreePrinter newRawTreePrinter(PrintWriter writer) {
        return Printers.newRawTreePrinter$(this, writer);
    }

    @Override
    public String show(Names.Name name) {
        return Printers.show$((Printers)this, name);
    }

    @Override
    public String show(long flags) {
        return Printers.show$((Printers)this, flags);
    }

    @Override
    public String show(Position position) {
        return Printers.show$((Printers)this, position);
    }

    @Override
    public String showDecl(Symbols.Symbol sym) {
        return Printers.showDecl$(this, sym);
    }

    @Override
    public String treeLine(Trees.Tree t) {
        return Trees.treeLine$(this, t);
    }

    @Override
    public String treeStatus(Trees.Tree t, Trees.Tree enclosingTree) {
        return Trees.treeStatus$(this, t, enclosingTree);
    }

    @Override
    public Trees.Tree treeStatus$default$2() {
        return Trees.treeStatus$default$2$(this);
    }

    @Override
    public String treeSymStatus(Trees.Tree t) {
        return Trees.treeSymStatus$(this, t);
    }

    @Override
    public Trees.Apply ApplyConstructor(Trees.Tree tpt, List<Trees.Tree> args2) {
        return Trees.ApplyConstructor$(this, tpt, args2);
    }

    @Override
    public Trees.Apply NewFromConstructor(Symbols.Symbol constructor, Seq<Trees.Tree> args2) {
        return Trees.NewFromConstructor$(this, constructor, args2);
    }

    @Override
    public Trees.TypeTree TypeTree(Types.Type tp) {
        return Trees.TypeTree$(this, tp);
    }

    @Override
    public Trees.TypeBoundsTree TypeBoundsTree(Types.TypeBounds bounds) {
        return Trees.TypeBoundsTree$((Trees)this, bounds);
    }

    @Override
    public Trees.TypeBoundsTree TypeBoundsTree(Symbols.Symbol sym) {
        return Trees.TypeBoundsTree$((Trees)this, sym);
    }

    @Override
    public boolean isReferenceToScalaMember(Trees.Tree t, Names.Name Id2) {
        return Trees.isReferenceToScalaMember$(this, t, Id2);
    }

    @Override
    public boolean isReferenceToPredef(Trees.Tree t) {
        return Trees.isReferenceToPredef$(this, t);
    }

    @Override
    public Trees.Template Template(Symbols.Symbol sym, List<Trees.Tree> body) {
        return Trees.Template$(this, sym, body);
    }

    @Override
    public Trees.ValDef newValDef(Symbols.Symbol sym, Trees.Tree rhs, Trees.Modifiers mods, Names.TermName name, Trees.Tree tpt) {
        return Trees.newValDef$(this, sym, rhs, mods, name, tpt);
    }

    @Override
    public Trees.Modifiers newValDef$default$3(Symbols.Symbol sym, Trees.Tree rhs) {
        return Trees.newValDef$default$3$(this, sym, rhs);
    }

    @Override
    public Names.TermName newValDef$default$4(Symbols.Symbol sym, Trees.Tree rhs) {
        return Trees.newValDef$default$4$(this, sym, rhs);
    }

    @Override
    public Trees.Tree newValDef$default$5(Symbols.Symbol sym, Trees.Tree rhs) {
        return Trees.newValDef$default$5$(this, sym, rhs);
    }

    @Override
    public Trees.DefDef newDefDef(Symbols.Symbol sym, Trees.Tree rhs, Trees.Modifiers mods, Names.TermName name, List<Trees.TypeDef> tparams, List<List<Trees.ValDef>> vparamss, Trees.Tree tpt) {
        return Trees.newDefDef$(this, sym, rhs, mods, name, tparams, vparamss, tpt);
    }

    @Override
    public Trees.Modifiers newDefDef$default$3(Symbols.Symbol sym, Trees.Tree rhs) {
        return Trees.newDefDef$default$3$(this, sym, rhs);
    }

    @Override
    public Names.TermName newDefDef$default$4(Symbols.Symbol sym, Trees.Tree rhs) {
        return Trees.newDefDef$default$4$(this, sym, rhs);
    }

    @Override
    public List<Trees.TypeDef> newDefDef$default$5(Symbols.Symbol sym, Trees.Tree rhs) {
        return Trees.newDefDef$default$5$(this, sym, rhs);
    }

    @Override
    public List<List<Trees.ValDef>> newDefDef$default$6(Symbols.Symbol sym, Trees.Tree rhs) {
        return Trees.newDefDef$default$6$(this, sym, rhs);
    }

    @Override
    public Trees.Tree newDefDef$default$7(Symbols.Symbol sym, Trees.Tree rhs) {
        return Trees.newDefDef$default$7$(this, sym, rhs);
    }

    @Override
    public Trees.TypeDef newTypeDef(Symbols.Symbol sym, Trees.Tree rhs, Trees.Modifiers mods, Names.TypeName name, List<Trees.TypeDef> tparams) {
        return Trees.newTypeDef$(this, sym, rhs, mods, name, tparams);
    }

    @Override
    public Trees.Modifiers newTypeDef$default$3(Symbols.Symbol sym, Trees.Tree rhs) {
        return Trees.newTypeDef$default$3$(this, sym, rhs);
    }

    @Override
    public Names.TypeName newTypeDef$default$4(Symbols.Symbol sym, Trees.Tree rhs) {
        return Trees.newTypeDef$default$4$(this, sym, rhs);
    }

    @Override
    public List<Trees.TypeDef> newTypeDef$default$5(Symbols.Symbol sym, Trees.Tree rhs) {
        return Trees.newTypeDef$default$5$(this, sym, rhs);
    }

    @Override
    public Trees.CaseDef CaseDef(Trees.Tree pat, Trees.Tree body) {
        return Trees.CaseDef$(this, pat, body);
    }

    @Override
    public Trees.Bind Bind(Symbols.Symbol sym, Trees.Tree body) {
        return Trees.Bind$(this, sym, body);
    }

    @Override
    public Trees.Try Try(Trees.Tree body, Seq<Tuple2<Trees.Tree, Trees.Tree>> cases) {
        return Trees.Try$(this, body, cases);
    }

    @Override
    public Trees.Throw Throw(Types.Type tpe, Seq<Trees.Tree> args2) {
        return Trees.Throw$(this, tpe, args2);
    }

    @Override
    public Trees.Tree Apply(Symbols.Symbol sym, Seq<Trees.Tree> args2) {
        return Trees.Apply$(this, sym, args2);
    }

    @Override
    public Trees.Tree New(Trees.Tree tpt, List<List<Trees.Tree>> argss) {
        return Trees.New$((Trees)this, tpt, argss);
    }

    @Override
    public Trees.Tree New(Types.Type tpe, Seq<Trees.Tree> args2) {
        return Trees.New$((Trees)this, tpe, args2);
    }

    @Override
    public Trees.Tree New(Types.Type tpe, List<List<Trees.Tree>> argss) {
        return Trees.New$((Trees)this, tpe, argss);
    }

    @Override
    public Trees.Tree New(Symbols.Symbol sym, Seq<Trees.Tree> args2) {
        return Trees.New$((Trees)this, sym, args2);
    }

    @Override
    public Trees.Tree Super(Symbols.Symbol sym, Names.TypeName mix) {
        return Trees.Super$(this, sym, mix);
    }

    @Override
    public Trees.Tree SuperSelect(Symbols.Symbol clazz, Symbols.Symbol sym) {
        return Trees.SuperSelect$(this, clazz, sym);
    }

    @Override
    public Trees.Tree This(Symbols.Symbol sym) {
        return Trees.This$(this, sym);
    }

    @Override
    public Trees.Select Select(Trees.Tree qualifier, String name) {
        return Trees.Select$((Trees)this, qualifier, name);
    }

    @Override
    public Trees.Select Select(Trees.Tree qualifier, Symbols.Symbol sym) {
        return Trees.Select$((Trees)this, qualifier, sym);
    }

    @Override
    public Trees.Ident Ident(String name) {
        return Trees.Ident$((Trees)this, name);
    }

    @Override
    public Trees.Ident Ident(Symbols.Symbol sym) {
        return Trees.Ident$((Trees)this, sym);
    }

    @Override
    public Trees.Block Block(Seq<Trees.Tree> stats) {
        return Trees.Block$(this, stats);
    }

    @Override
    public Symbols.Symbol typeTreeSymbol(Trees.TypeTree tree) {
        return Trees.typeTreeSymbol$(this, tree);
    }

    @Override
    public void itraverse(Trees.Traverser traverser, Trees.Tree tree) {
        Trees.itraverse$(this, traverser, tree);
    }

    @Override
    public Trees.Tree itransform(Trees.Transformer transformer, Trees.Tree tree) {
        return Trees.itransform$(this, transformer, tree);
    }

    @Override
    public Trees.Tree duplicateAndKeepPositions(Trees.Tree tree) {
        return Trees.duplicateAndKeepPositions$(this, tree);
    }

    @Override
    public Trees.Tree wrappingIntoTerm(Trees.Tree tree0, Function1<Trees.Tree, Trees.Tree> op) {
        return Trees.wrappingIntoTerm$(this, tree0, op);
    }

    @Override
    public Trees.DefDef copyDefDef(Trees.Tree tree, Trees.Modifiers mods, Names.Name name, List<Trees.TypeDef> tparams, List<List<Trees.ValDef>> vparamss, Trees.Tree tpt, Trees.Tree rhs) {
        return Trees.copyDefDef$(this, tree, mods, name, tparams, vparamss, tpt, rhs);
    }

    @Override
    public Trees.Modifiers copyDefDef$default$2(Trees.Tree tree) {
        return Trees.copyDefDef$default$2$(this, tree);
    }

    @Override
    public Names.Name copyDefDef$default$3(Trees.Tree tree) {
        return Trees.copyDefDef$default$3$(this, tree);
    }

    @Override
    public List<Trees.TypeDef> copyDefDef$default$4(Trees.Tree tree) {
        return Trees.copyDefDef$default$4$(this, tree);
    }

    @Override
    public List<List<Trees.ValDef>> copyDefDef$default$5(Trees.Tree tree) {
        return Trees.copyDefDef$default$5$(this, tree);
    }

    @Override
    public Trees.Tree copyDefDef$default$6(Trees.Tree tree) {
        return Trees.copyDefDef$default$6$(this, tree);
    }

    @Override
    public Trees.Tree copyDefDef$default$7(Trees.Tree tree) {
        return Trees.copyDefDef$default$7$(this, tree);
    }

    @Override
    public Trees.ValDef copyValDef(Trees.Tree tree, Trees.Modifiers mods, Names.Name name, Trees.Tree tpt, Trees.Tree rhs) {
        return Trees.copyValDef$(this, tree, mods, name, tpt, rhs);
    }

    @Override
    public Trees.Modifiers copyValDef$default$2(Trees.Tree tree) {
        return Trees.copyValDef$default$2$(this, tree);
    }

    @Override
    public Names.Name copyValDef$default$3(Trees.Tree tree) {
        return Trees.copyValDef$default$3$(this, tree);
    }

    @Override
    public Trees.Tree copyValDef$default$4(Trees.Tree tree) {
        return Trees.copyValDef$default$4$(this, tree);
    }

    @Override
    public Trees.Tree copyValDef$default$5(Trees.Tree tree) {
        return Trees.copyValDef$default$5$(this, tree);
    }

    @Override
    public Trees.TypeDef copyTypeDef(Trees.Tree tree, Trees.Modifiers mods, Names.Name name, List<Trees.TypeDef> tparams, Trees.Tree rhs) {
        return Trees.copyTypeDef$(this, tree, mods, name, tparams, rhs);
    }

    @Override
    public Trees.Modifiers copyTypeDef$default$2(Trees.Tree tree) {
        return Trees.copyTypeDef$default$2$(this, tree);
    }

    @Override
    public Names.Name copyTypeDef$default$3(Trees.Tree tree) {
        return Trees.copyTypeDef$default$3$(this, tree);
    }

    @Override
    public List<Trees.TypeDef> copyTypeDef$default$4(Trees.Tree tree) {
        return Trees.copyTypeDef$default$4$(this, tree);
    }

    @Override
    public Trees.Tree copyTypeDef$default$5(Trees.Tree tree) {
        return Trees.copyTypeDef$default$5$(this, tree);
    }

    @Override
    public Trees.ClassDef copyClassDef(Trees.Tree tree, Trees.Modifiers mods, Names.Name name, List<Trees.TypeDef> tparams, Trees.Template impl) {
        return Trees.copyClassDef$(this, tree, mods, name, tparams, impl);
    }

    @Override
    public Trees.Modifiers copyClassDef$default$2(Trees.Tree tree) {
        return Trees.copyClassDef$default$2$(this, tree);
    }

    @Override
    public Names.Name copyClassDef$default$3(Trees.Tree tree) {
        return Trees.copyClassDef$default$3$(this, tree);
    }

    @Override
    public List<Trees.TypeDef> copyClassDef$default$4(Trees.Tree tree) {
        return Trees.copyClassDef$default$4$(this, tree);
    }

    @Override
    public Trees.Template copyClassDef$default$5(Trees.Tree tree) {
        return Trees.copyClassDef$default$5$(this, tree);
    }

    @Override
    public Trees.ModuleDef copyModuleDef(Trees.Tree tree, Trees.Modifiers mods, Names.Name name, Trees.Template impl) {
        return Trees.copyModuleDef$(this, tree, mods, name, impl);
    }

    @Override
    public Trees.Modifiers copyModuleDef$default$2(Trees.Tree tree) {
        return Trees.copyModuleDef$default$2$(this, tree);
    }

    @Override
    public Names.Name copyModuleDef$default$3(Trees.Tree tree) {
        return Trees.copyModuleDef$default$3$(this, tree);
    }

    @Override
    public Trees.Template copyModuleDef$default$4(Trees.Tree tree) {
        return Trees.copyModuleDef$default$4$(this, tree);
    }

    @Override
    public Trees.DefDef deriveDefDef(Trees.Tree ddef, Function1<Trees.Tree, Trees.Tree> applyToRhs) {
        return Trees.deriveDefDef$(this, ddef, applyToRhs);
    }

    @Override
    public Trees.ValDef deriveValDef(Trees.Tree vdef, Function1<Trees.Tree, Trees.Tree> applyToRhs) {
        return Trees.deriveValDef$(this, vdef, applyToRhs);
    }

    @Override
    public Trees.Template deriveTemplate(Trees.Tree templ, Function1<List<Trees.Tree>, List<Trees.Tree>> applyToBody) {
        return Trees.deriveTemplate$(this, templ, applyToBody);
    }

    @Override
    public Trees.ClassDef deriveClassDef(Trees.Tree cdef, Function1<Trees.Template, Trees.Template> applyToImpl) {
        return Trees.deriveClassDef$(this, cdef, applyToImpl);
    }

    @Override
    public Trees.ModuleDef deriveModuleDef(Trees.Tree mdef, Function1<Trees.Template, Trees.Template> applyToImpl) {
        return Trees.deriveModuleDef$(this, mdef, applyToImpl);
    }

    @Override
    public Trees.CaseDef deriveCaseDef(Trees.Tree cdef, Function1<Trees.Tree, Trees.Tree> applyToBody) {
        return Trees.deriveCaseDef$(this, cdef, applyToBody);
    }

    @Override
    public Trees.LabelDef deriveLabelDef(Trees.Tree ldef, Function1<Trees.Tree, Trees.Tree> applyToRhs) {
        return Trees.deriveLabelDef$(this, ldef, applyToRhs);
    }

    @Override
    public Trees.Function deriveFunction(Trees.Tree func, Function1<Trees.Tree, Trees.Tree> applyToRhs) {
        return Trees.deriveFunction$(this, func, applyToRhs);
    }

    @Override
    public void addAnnotationChecker(AnnotationCheckers.AnnotationChecker checker) {
        AnnotationCheckers.addAnnotationChecker$(this, checker);
    }

    @Override
    public void removeAllAnnotationCheckers() {
        AnnotationCheckers.removeAllAnnotationCheckers$(this);
    }

    @Override
    public boolean annotationsConform(Types.Type tp1, Types.Type tp2) {
        return AnnotationCheckers.annotationsConform$(this, tp1, tp2);
    }

    @Override
    public Types.Type annotationsLub(Types.Type tpe, List<Types.Type> ts) {
        return AnnotationCheckers.annotationsLub$(this, tpe, ts);
    }

    @Override
    public Types.Type annotationsGlb(Types.Type tpe, List<Types.Type> ts) {
        return AnnotationCheckers.annotationsGlb$(this, tpe, ts);
    }

    @Override
    public List<Types.TypeBounds> adaptBoundsToAnnotations(List<Types.TypeBounds> bounds, List<Symbols.Symbol> tparams, List<Types.Type> targs) {
        return AnnotationCheckers.adaptBoundsToAnnotations$(this, bounds, tparams, targs);
    }

    @Override
    public Types.Type addAnnotations(Trees.Tree tree, Types.Type tpe) {
        return AnnotationCheckers.addAnnotations$(this, tree, tpe);
    }

    @Override
    public boolean canAdaptAnnotations(Trees.Tree tree, int mode, Types.Type pt) {
        return AnnotationCheckers.canAdaptAnnotations$(this, tree, mode, pt);
    }

    @Override
    public Trees.Tree adaptAnnotations(Trees.Tree tree, int mode, Types.Type pt) {
        return AnnotationCheckers.adaptAnnotations$(this, tree, mode, pt);
    }

    @Override
    public Types.Type adaptTypeOfReturn(Trees.Tree tree, Types.Type pt, Function0<Types.Type> function0) {
        return AnnotationCheckers.adaptTypeOfReturn$(this, tree, pt, function0);
    }

    @Override
    public String completeAnnotationToString(AnnotationInfos.AnnotationInfo annInfo) {
        return AnnotationInfos.completeAnnotationToString$(this, annInfo);
    }

    @Override
    public Trees.Tree annotationToTree(AnnotationInfos.AnnotationInfo ann) {
        return AnnotationInfos.annotationToTree$(this, ann);
    }

    @Override
    public AnnotationInfos.AnnotationInfo treeToAnnotation(Trees.Tree tree) {
        return AnnotationInfos.treeToAnnotation$(this, tree);
    }

    @Override
    public Names.TermName encode(String str) {
        return StdNames.encode$(this, str);
    }

    @Override
    public String compactifyName(String orig) {
        return StdNames.compactifyName$(this, orig);
    }

    @Override
    public UnCurry uncurry() {
        return Transforms.uncurry$(this);
    }

    @Override
    public Erasure erasure() {
        return Transforms.erasure$(this);
    }

    @Override
    public PostErasure postErasure() {
        return Transforms.postErasure$(this);
    }

    @Override
    public Types.Type transformedType(Symbols.Symbol sym) {
        return Transforms.transformedType$((Transforms)this, sym);
    }

    @Override
    public Types.Type transformedType(Types.Type tpe) {
        return Transforms.transformedType$((Transforms)this, tpe);
    }

    @Override
    public BaseTypeSeqs.BaseTypeSeq newBaseTypeSeq(List<Types.Type> parents, Types.Type[] elems) {
        return BaseTypeSeqs.newBaseTypeSeq$(this, parents, elems);
    }

    @Override
    public BaseTypeSeqs.MappedBaseTypeSeq newMappedBaseTypeSeq(BaseTypeSeqs.BaseTypeSeq orig, Function1<Types.Type, Types.Type> f) {
        return BaseTypeSeqs.newMappedBaseTypeSeq$(this, orig, f);
    }

    @Override
    public BaseTypeSeqs.BaseTypeSeq baseTypeSingletonSeq(Types.Type tp) {
        return BaseTypeSeqs.baseTypeSingletonSeq$(this, tp);
    }

    @Override
    public BaseTypeSeqs.BaseTypeSeq compoundBaseTypeSeq(Types.Type tp) {
        return BaseTypeSeqs.compoundBaseTypeSeq$(this, tp);
    }

    @Override
    public Scopes.Scope newScope() {
        return Scopes.newScope$(this);
    }

    @Override
    public Scopes.Scope newFindMemberScope() {
        return Scopes.newFindMemberScope$(this);
    }

    @Override
    public final Scopes.Scope newNestedScope(Scopes.Scope outer) {
        return Scopes.newNestedScope$(this, outer);
    }

    @Override
    public Scopes.Scope newScopeWith(Seq<Symbols.Symbol> elems) {
        return Scopes.newScopeWith$(this, elems);
    }

    @Override
    public Scopes.Scope newPackageScope(Symbols.Symbol pkgClass) {
        return Scopes.newPackageScope$(this, pkgClass);
    }

    @Override
    public Scopes.Scope scopeTransform(Symbols.Symbol owner, Function0<Scopes.Scope> op) {
        return Scopes.scopeTransform$(this, owner, op);
    }

    @Override
    public FlagSets.FlagOps addFlagOps(long left) {
        return FlagSets.addFlagOps$(this, left);
    }

    @Override
    public List<Symbols.Symbol> deriveFreshSkolems(List<Symbols.Symbol> tparams) {
        return ExistentialsAndSkolems.deriveFreshSkolems$(this, tparams);
    }

    @Override
    public boolean isRawParameter(Symbols.Symbol sym) {
        return ExistentialsAndSkolems.isRawParameter$(this, sym);
    }

    @Override
    public final <T> T existentialTransform(List<Symbols.Symbol> rawSyms, Types.Type tp, Symbols.Symbol rawOwner, Function2<List<Symbols.Symbol>, Types.Type, T> creator) {
        return (T)ExistentialsAndSkolems.existentialTransform$(this, rawSyms, tp, rawOwner, creator);
    }

    @Override
    public final <T> Symbols.Symbol existentialTransform$default$3() {
        return ExistentialsAndSkolems.existentialTransform$default$3$(this);
    }

    @Override
    public final Types.Type packSymbols(List<Symbols.Symbol> hidden, Types.Type tp, Symbols.Symbol rawOwner) {
        return ExistentialsAndSkolems.packSymbols$(this, hidden, tp, rawOwner);
    }

    @Override
    public final Symbols.Symbol packSymbols$default$3() {
        return ExistentialsAndSkolems.packSymbols$default$3$(this);
    }

    @Override
    public boolean kindsConform(List<Symbols.Symbol> tparams, List<Types.Type> targs, Types.Type pre, Symbols.Symbol owner) {
        return Kinds.kindsConform$(this, tparams, targs, pre, owner);
    }

    @Override
    public List<Tuple3<Types.Type, Symbols.Symbol, Kinds.KindErrors>> checkKindBounds0(List<Symbols.Symbol> tparams, List<Types.Type> targs, Types.Type pre, Symbols.Symbol owner, boolean explainErrors) {
        return Kinds.checkKindBounds0$(this, tparams, targs, pre, owner, explainErrors);
    }

    @Override
    public final int varianceInTypes(List<Types.Type> tps, Symbols.Symbol tparam) {
        return Variances.varianceInTypes$(this, tps, tparam);
    }

    @Override
    public final int varianceInType(Types.Type tp, Symbols.Symbol tparam) {
        return Variances.varianceInType$(this, tp, tparam);
    }

    @Override
    public int skolemizationLevel() {
        return Types.skolemizationLevel$(this);
    }

    @Override
    public void skolemizationLevel_$eq(int value) {
        Types.skolemizationLevel_$eq$(this, value);
    }

    @Override
    public WeakHashMap<List<Types.Type>, WeakReference<Types.Type>> intersectionWitness() {
        return Types.intersectionWitness$(this);
    }

    @Override
    public void defineUnderlyingOfSingleType(Types.SingleType tpe) {
        Types.defineUnderlyingOfSingleType$(this, tpe);
    }

    @Override
    public List<Symbols.Symbol> computeBaseClasses(Types.Type tpe) {
        return Types.computeBaseClasses$(this, tpe);
    }

    @Override
    public void defineBaseTypeSeqOfCompoundType(Types.CompoundType tpe) {
        Types.defineBaseTypeSeqOfCompoundType$(this, tpe);
    }

    @Override
    public void defineBaseClassesOfCompoundType(Types.CompoundType tpe) {
        Types.defineBaseClassesOfCompoundType$(this, tpe);
    }

    @Override
    public void validateClassInfo(Types.ClassInfoType tp) {
        Types.validateClassInfo$(this, tp);
    }

    @Override
    public void defineNormalized(Types.TypeRef tr) {
        Types.defineNormalized$(this, tr);
    }

    @Override
    public void defineParentsOfTypeRef(Types.TypeRef tpe) {
        Types.defineParentsOfTypeRef$(this, tpe);
    }

    @Override
    public void defineBaseTypeSeqOfTypeRef(Types.TypeRef tpe) {
        Types.defineBaseTypeSeqOfTypeRef$(this, tpe);
    }

    @Override
    public Types.Type newExistentialType(List<Symbols.Symbol> quantified, Types.Type underlying) {
        return Types.newExistentialType$(this, quantified, underlying);
    }

    @Override
    public Types.Type overloadedType(Types.Type pre, List<Symbols.Symbol> alternatives) {
        return Types.overloadedType$(this, pre, alternatives);
    }

    @Override
    public Types.Type annotatedType(List<AnnotationInfos.AnnotationInfo> annots, Types.Type underlying) {
        return Types.annotatedType$(this, annots, underlying);
    }

    @Override
    public Types.Type singleType(Types.Type pre, Symbols.Symbol sym) {
        return Types.singleType$(this, pre, sym);
    }

    @Override
    public Types.Type refinedType(List<Types.Type> parents, Symbols.Symbol owner, Scopes.Scope decls, Position pos) {
        return Types.refinedType$(this, parents, owner, decls, pos);
    }

    @Override
    public Types.Type refinedType(List<Types.Type> parents, Symbols.Symbol owner) {
        return Types.refinedType$(this, parents, owner);
    }

    @Override
    public Types.Type copyRefinedType(Types.RefinedType original, List<Types.Type> parents, Scopes.Scope decls) {
        return Types.copyRefinedType$(this, original, parents, decls);
    }

    @Override
    public Types.Type typeRef(Types.Type pre, Symbols.Symbol sym, List<Types.Type> args2) {
        return Types.typeRef$(this, pre, sym, args2);
    }

    @Override
    public Types.Type copyTypeRef(Types.Type tp, Types.Type pre, Symbols.Symbol sym, List<Types.Type> args2) {
        return Types.copyTypeRef$(this, tp, pre, sym, args2);
    }

    @Override
    public Types.JavaMethodType JavaMethodType(List<Symbols.Symbol> params, Types.Type resultType) {
        return Types.JavaMethodType$(this, params, resultType);
    }

    @Override
    public Types.Type copyMethodType(Types.Type tp, List<Symbols.Symbol> params, Types.Type restpe) {
        return Types.copyMethodType$(this, tp, params, restpe);
    }

    @Override
    public Types.Type intersectionType(List<Types.Type> tps, Symbols.Symbol owner) {
        return Types.intersectionType$(this, tps, owner);
    }

    @Override
    public Types.Type intersectionType(List<Types.Type> tps) {
        return Types.intersectionType$(this, tps);
    }

    @Override
    public Types.Type intersectionTypeForLazyBaseType(List<Types.Type> tps) {
        return Types.intersectionTypeForLazyBaseType$(this, tps);
    }

    @Override
    public boolean isIntersectionTypeForLazyBaseType(Types.RefinedType tp) {
        return Types.isIntersectionTypeForLazyBaseType$(this, tp);
    }

    @Override
    public Types.Type appliedType(Types.Type tycon, List<Types.Type> args2) {
        return Types.appliedType$((Types)this, tycon, args2);
    }

    @Override
    public Types.Type appliedType(Types.Type tycon, Seq<Types.Type> args2) {
        return Types.appliedType$((Types)this, tycon, args2);
    }

    @Override
    public Types.Type appliedType(Symbols.Symbol tyconSym, List<Types.Type> args2) {
        return Types.appliedType$((Types)this, tyconSym, args2);
    }

    @Override
    public Types.Type appliedType(Symbols.Symbol tyconSym, Seq<Types.Type> args2) {
        return Types.appliedType$((Types)this, tyconSym, args2);
    }

    @Override
    public Types.Type genPolyType(List<Symbols.Symbol> params, Types.Type tpe) {
        return Types.genPolyType$(this, params, tpe);
    }

    @Override
    public Types.Type polyType(List<Symbols.Symbol> params, Types.Type tpe) {
        return Types.polyType$(this, params, tpe);
    }

    @Override
    public Types.Type typeFunAnon(List<Symbols.Symbol> tps, Types.Type body) {
        return Types.typeFunAnon$(this, tps, body);
    }

    @Override
    public Types.Type typeFun(List<Symbols.Symbol> tps, Types.Type body) {
        return Types.typeFun$(this, tps, body);
    }

    @Override
    public Types.Type existentialAbstraction(List<Symbols.Symbol> tparams, Types.Type tpe0) {
        return Types.existentialAbstraction$(this, tparams, tpe0);
    }

    @Override
    public final int howManyUniqueTypes() {
        return Types.howManyUniqueTypes$(this);
    }

    @Override
    public <T extends Types.Type> T unique(T tp) {
        return (T)Types.unique$(this, tp);
    }

    @Override
    public Types.Type elementExtract(Symbols.Symbol container, Types.Type tp) {
        return Types.elementExtract$(this, container, tp);
    }

    @Override
    public Option<Types.Type> elementExtractOption(Symbols.Symbol container, Types.Type tp) {
        return Types.elementExtractOption$(this, container, tp);
    }

    @Override
    public boolean elementTest(Symbols.Symbol container, Types.Type tp, Function1<Types.Type, Object> f) {
        return Types.elementTest$(this, container, tp, f);
    }

    @Override
    public Types.Type elementTransform(Symbols.Symbol container, Types.Type tp, Function1<Types.Type, Types.Type> f) {
        return Types.elementTransform$(this, container, tp, f);
    }

    @Override
    public Types.Type transparentShallowTransform(Symbols.Symbol container, Types.Type tp, Function1<Types.Type, Types.Type> f) {
        return Types.transparentShallowTransform$(this, container, tp, f);
    }

    @Override
    public Types.Type repackExistential(Types.Type tp) {
        return Types.repackExistential$(this, tp);
    }

    @Override
    public boolean containsExistential(Types.Type tpe) {
        return Types.containsExistential$(this, tpe);
    }

    @Override
    public List<Symbols.Symbol> existentialsInType(Types.Type tpe) {
        return Types.existentialsInType$(this, tpe);
    }

    @Override
    public boolean isDummyAppliedType(Types.Type tp) {
        return Types.isDummyAppliedType$(this, tp);
    }

    @Override
    public List<Symbols.Symbol> typeParamsToExistentials(Symbols.Symbol clazz, List<Symbols.Symbol> tparams) {
        return Types.typeParamsToExistentials$(this, clazz, tparams);
    }

    @Override
    public List<Symbols.Symbol> typeParamsToExistentials(Symbols.Symbol clazz) {
        return Types.typeParamsToExistentials$(this, clazz);
    }

    @Override
    public boolean isRawIfWithoutArgs(Symbols.Symbol sym) {
        return Types.isRawIfWithoutArgs$(this, sym);
    }

    @Override
    public boolean isRawType(Types.Type tp) {
        return Types.isRawType$(this, tp);
    }

    @Override
    public boolean isRaw(Symbols.Symbol sym, List<Types.Type> args2) {
        return Types.isRaw$(this, sym, args2);
    }

    @Override
    public Types.TypeBounds singletonBounds(Types.Type hi) {
        return Types.singletonBounds$(this, hi);
    }

    @Override
    public Types.Type nestedMemberType(Symbols.Symbol sym, Types.Type pre, Symbols.Symbol owner) {
        return Types.nestedMemberType$(this, sym, pre, owner);
    }

    @Override
    public int lubDepth(List<Types.Type> ts) {
        return Types.lubDepth$(this, ts);
    }

    @Override
    public boolean isPopulated(Types.Type tp1, Types.Type tp2) {
        return Types.isPopulated$(this, tp1, tp2);
    }

    @Override
    public Types.Type normalizePlus(Types.Type tp) {
        return Types.normalizePlus$(this, tp);
    }

    @Override
    public boolean isSameTypes(List<Types.Type> tps1, List<Types.Type> tps2) {
        return Types.isSameTypes$(this, tps1, tps2);
    }

    @Override
    public int basetypeRecursions() {
        return Types.basetypeRecursions$(this);
    }

    @Override
    public void basetypeRecursions_$eq(int value) {
        Types.basetypeRecursions_$eq$(this, value);
    }

    @Override
    public HashSet<Types.Type> pendingBaseTypes() {
        return Types.pendingBaseTypes$(this);
    }

    @Override
    public boolean isEligibleForPrefixUnification(Types.Type tp) {
        return Types.isEligibleForPrefixUnification$(this, tp);
    }

    @Override
    public boolean isErrorOrWildcard(Types.Type tp) {
        return Types.isErrorOrWildcard$(this, tp);
    }

    @Override
    public boolean isSingleType(Types.Type tp) {
        return Types.isSingleType$(this, tp);
    }

    @Override
    public boolean isConstantType(Types.Type tp) {
        return Types.isConstantType$(this, tp);
    }

    @Override
    public boolean isExistentialType(Types.Type tp) {
        return Types.isExistentialType$(this, tp);
    }

    @Override
    public boolean isImplicitMethodType(Types.Type tp) {
        return Types.isImplicitMethodType$(this, tp);
    }

    @Override
    public boolean isUseableAsTypeArg(Types.Type tp) {
        return Types.isUseableAsTypeArg$(this, tp);
    }

    @Override
    public final boolean isUseableAsTypeArgs(List<Types.Type> tps) {
        return Types.isUseableAsTypeArgs$(this, tps);
    }

    @Override
    public boolean isNonRefinementClassType(Types.Type tpe) {
        return Types.isNonRefinementClassType$(this, tpe);
    }

    @Override
    public boolean isSubArgs(List<Types.Type> tps1, List<Types.Type> tps2, List<Symbols.Symbol> tparams, int depth) {
        return Types.isSubArgs$(this, tps1, tps2, tparams, depth);
    }

    @Override
    public boolean specializesSym(Types.Type tp, Symbols.Symbol sym, int depth) {
        return Types.specializesSym$(this, tp, sym, depth);
    }

    @Override
    public boolean specializesSym(Types.Type preLo, Symbols.Symbol symLo, Types.Type preHi, Symbols.Symbol symHi, int depth) {
        return Types.specializesSym$(this, preLo, symLo, preHi, symHi, depth);
    }

    @Override
    public final boolean matchesType(Types.Type tp1, Types.Type tp2, boolean alwaysMatchSimple) {
        return Types.matchesType$(this, tp1, tp2, alwaysMatchSimple);
    }

    @Override
    public boolean matchingParams(List<Symbols.Symbol> syms1, List<Symbols.Symbol> syms2, boolean syms1isJava, boolean syms2isJava) {
        return Types.matchingParams$(this, syms1, syms2, syms1isJava, syms2isJava);
    }

    @Override
    public boolean isWithinBounds(Types.Type pre, Symbols.Symbol owner, List<Symbols.Symbol> tparams, List<Types.Type> targs) {
        return Types.isWithinBounds$(this, pre, owner, tparams, targs);
    }

    @Override
    public Types.Type elimAnonymousClass(Types.Type t) {
        return Types.elimAnonymousClass$(this, t);
    }

    @Override
    public List<Types.TypeVar> typeVarsInType(Types.Type tp) {
        return Types.typeVarsInType$(this, tp);
    }

    @Override
    public final <T> T suspendingTypeVars(List<Types.TypeVar> tvs, Function0<T> op) {
        return (T)Types.suspendingTypeVars$(this, tvs, op);
    }

    @Override
    public final Tuple2<List<Types.Type>, List<Symbols.Symbol>> stripExistentialsAndTypeVars(List<Types.Type> ts, boolean expandLazyBaseType) {
        return Types.stripExistentialsAndTypeVars$(this, ts, expandLazyBaseType);
    }

    @Override
    public final boolean stripExistentialsAndTypeVars$default$2() {
        return Types.stripExistentialsAndTypeVars$default$2$(this);
    }

    @Override
    public Types.Type mergePrefixAndArgs(List<Types.Type> tps0, int variance, int depth) {
        return Types.mergePrefixAndArgs$(this, tps0, variance, depth);
    }

    @Override
    public void addMember(Types.Type thistp, Types.Type tp, Symbols.Symbol sym) {
        Types.addMember$(this, thistp, tp, sym);
    }

    @Override
    public void addMember(Types.Type thistp, Types.Type tp, Symbols.Symbol sym, int depth) {
        Types.addMember$(this, thistp, tp, sym, depth);
    }

    @Override
    public boolean isJavaVarargsAncestor(Symbols.Symbol clazz) {
        return Types.isJavaVarargsAncestor$(this, clazz);
    }

    @Override
    public boolean inheritsJavaVarArgsMethod(Symbols.Symbol clazz) {
        return Types.inheritsJavaVarArgsMethod$(this, clazz);
    }

    @Override
    public String indent() {
        return Types.indent$(this);
    }

    @Override
    public void indent_$eq(String value) {
        Types.indent_$eq$(this, value);
    }

    @Override
    public <T> boolean explain(String op, Function2<Types.Type, T, Object> p, Types.Type tp1, T arg2) {
        return Types.explain$(this, op, p, tp1, arg2);
    }

    @Override
    public void explainTypes(Types.Type found, Types.Type required) {
        Types.explainTypes$(this, found, required);
    }

    @Override
    public void explainTypes(Function2<Types.Type, Types.Type, Object> op, Types.Type found, Types.Type required) {
        Types.explainTypes$(this, op, found, required);
    }

    @Override
    public <A> A withTypesExplained(Function0<A> op) {
        return (A)Types.withTypesExplained$(this, op);
    }

    @Override
    public boolean isBoundedGeneric(Types.Type tp) {
        return Types.isBoundedGeneric$(this, tp);
    }

    @Override
    public List<Types.Type> addSerializable(Seq<Types.Type> ps) {
        return Types.addSerializable$(this, ps);
    }

    @Override
    public final Types.Type uncheckedBounds(Types.Type tp) {
        return Types.uncheckedBounds$(this, tp);
    }

    @Override
    public Scopes.Scope nonTrivialMembers(Symbols.Symbol clazz) {
        return Types.nonTrivialMembers$(this, clazz);
    }

    @Override
    public Scopes.Scope importableMembers(Types.Type pre) {
        return Types.importableMembers$(this, pre);
    }

    @Override
    public Types.Type objToAny(Types.Type tp) {
        return Types.objToAny$(this, tp);
    }

    @Override
    public void invalidateTreeTpeCaches(Trees.Tree tree, List<Symbols.Symbol> updatedSyms) {
        Types.invalidateTreeTpeCaches$(this, tree, updatedSyms);
    }

    @Override
    public void invalidateCaches(Types.Type t, List<Symbols.Symbol> updatedSyms) {
        Types.invalidateCaches$(this, t, updatedSyms);
    }

    @Override
    public int typeDepth(Types.Type tp) {
        return Types.typeDepth$(this, tp);
    }

    @Override
    public int maxDepth(List<Types.Type> tps) {
        return Types.maxDepth$(this, tps);
    }

    @Override
    public TypeConstraints.UndoLog undoLog() {
        return TypeConstraints.undoLog$(this);
    }

    @Override
    public boolean solve(List<Types.TypeVar> tvars, List<Symbols.Symbol> tparams, Variance.Extractor<Symbols.Symbol> getVariance, boolean upper, int depth) {
        return TypeConstraints.solve$(this, tvars, tparams, getVariance, upper, depth);
    }

    @Override
    public TypeMaps.TypeMap rawToExistential() {
        return TypeMaps.rawToExistential$(this);
    }

    @Override
    public boolean isPossiblePrefix(Symbols.Symbol clazz) {
        return TypeMaps.isPossiblePrefix$(this, clazz);
    }

    @Override
    public boolean skipPrefixOf(Types.Type pre, Symbols.Symbol clazz) {
        return TypeMaps.skipPrefixOf$(this, pre, clazz);
    }

    @Override
    public final TypeMaps.AsSeenFromMap newAsSeenFromMap(Types.Type pre, Symbols.Symbol clazz) {
        return TypeMaps.newAsSeenFromMap$(this, pre, clazz);
    }

    @Override
    public List<Tuple2<Symbols.Symbol, Symbols.Symbol>> findRecursiveBounds(List<Types.Type> ts) {
        return GlbLubs.findRecursiveBounds$(this, ts);
    }

    @Override
    public List<Types.Type> lubList(List<Types.Type> ts, int depth) {
        return GlbLubs.lubList$(this, ts, depth);
    }

    @Override
    public List<Types.Type> spanningTypes(List<Types.Type> ts) {
        return GlbLubs.spanningTypes$(this, ts);
    }

    @Override
    public boolean sameWeakLubAsLub(List<Types.Type> tps) {
        return GlbLubs.sameWeakLubAsLub$(this, tps);
    }

    @Override
    public Types.Type weakLub(List<Types.Type> tps) {
        return GlbLubs.weakLub$(this, tps);
    }

    @Override
    public Types.Type numericLub(List<Types.Type> ts) {
        return GlbLubs.numericLub$(this, ts);
    }

    @Override
    public HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type> lubResults() {
        return GlbLubs.lubResults$(this);
    }

    @Override
    public HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type> glbResults() {
        return GlbLubs.glbResults$(this);
    }

    @Override
    public Types.Type lub(List<Types.Type> ts) {
        return GlbLubs.lub$(this, ts);
    }

    @Override
    public Types.Type lub(List<Types.Type> ts, int depth) {
        return GlbLubs.lub$(this, ts, depth);
    }

    @Override
    public Types.Type glb(List<Types.Type> ts) {
        return GlbLubs.glb$(this, ts);
    }

    @Override
    public Types.Type glb(List<Types.Type> ts, int depth) {
        return GlbLubs.glb$(this, ts, depth);
    }

    @Override
    public Types.Type glbNorm(List<Types.Type> ts, int depth) {
        return GlbLubs.glbNorm$(this, ts, depth);
    }

    @Override
    public Symbols.Symbol commonOwner(Types.Type t) {
        return CommonOwners.commonOwner$((CommonOwners)this, t);
    }

    @Override
    public Symbols.Symbol commonOwner(List<Types.Type> tps) {
        return CommonOwners.commonOwner$((CommonOwners)this, tps);
    }

    @Override
    public CommonOwners.CommonOwnerMap commonOwnerMap() {
        return CommonOwners.commonOwnerMap$(this);
    }

    @Override
    public int toStringRecursions() {
        return TypeToStrings.toStringRecursions$(this);
    }

    @Override
    public void toStringRecursions_$eq(int value) {
        TypeToStrings.toStringRecursions_$eq$(this, value);
    }

    @Override
    public HashSet<Types.Type> toStringSubjects() {
        return TypeToStrings.toStringSubjects$(this);
    }

    @Override
    public String typeToString(Types.Type tpe) {
        return TypeToStrings.typeToString$(this, tpe);
    }

    @Override
    public HashSet<TypeComparers.SubTypePair> pendingSubTypes() {
        return TypeComparers.pendingSubTypes$(this);
    }

    @Override
    public int subsametypeRecursions() {
        return TypeComparers.subsametypeRecursions$(this);
    }

    @Override
    public void subsametypeRecursions_$eq(int value) {
        TypeComparers.subsametypeRecursions_$eq$(this, value);
    }

    @Override
    public boolean isDifferentType(Types.Type tp1, Types.Type tp2) {
        return TypeComparers.isDifferentType$(this, tp1, tp2);
    }

    @Override
    public boolean isDifferentTypeConstructor(Types.Type tp1, Types.Type tp2) {
        return TypeComparers.isDifferentTypeConstructor$(this, tp1, tp2);
    }

    @Override
    public boolean isSameType(Types.Type tp1, Types.Type tp2) {
        return TypeComparers.isSameType$(this, tp1, tp2);
    }

    @Override
    public boolean isSameType2(Types.Type tp1, Types.Type tp2) {
        return TypeComparers.isSameType2$(this, tp1, tp2);
    }

    @Override
    public boolean isSubType(Types.Type tp1, Types.Type tp2, int depth) {
        return TypeComparers.isSubType$(this, tp1, tp2, depth);
    }

    @Override
    public int isSubType$default$3() {
        return TypeComparers.isSubType$default$3$(this);
    }

    @Override
    public boolean isHKSubType(Types.Type tp1, Types.Type tp2, int depth) {
        return TypeComparers.isHKSubType$(this, tp1, tp2, depth);
    }

    @Override
    public boolean isWeakSubType(Types.Type tp1, Types.Type tp2) {
        return TypeComparers.isWeakSubType$(this, tp1, tp2);
    }

    @Override
    public boolean isNumericSubType(Types.Type tp1, Types.Type tp2) {
        return TypeComparers.isNumericSubType$(this, tp1, tp2);
    }

    @Override
    public int getCurrentSymbolIdCount() {
        return Symbols.getCurrentSymbolIdCount$(this);
    }

    @Override
    public int nextId() {
        return Symbols.nextId$(this);
    }

    @Override
    public Map<Symbols.Symbol, Object> recursionTable() {
        return Symbols.recursionTable$(this);
    }

    @Override
    public void recursionTable_$eq(Map<Symbols.Symbol, Object> value) {
        Symbols.recursionTable_$eq$(this, value);
    }

    @Override
    public int lockedCount() {
        return Symbols.lockedCount$(this);
    }

    @Override
    public void lockedCount_$eq(int i) {
        Symbols.lockedCount_$eq$(this, i);
    }

    @Override
    public int nextExistentialId() {
        return Symbols.nextExistentialId$(this);
    }

    @Override
    public Names.TypeName freshExistentialName(String suffix) {
        return Symbols.freshExistentialName$(this, suffix);
    }

    @Override
    public Names.TypeName freshExistentialName(String suffix, int id) {
        return Symbols.freshExistentialName$(this, suffix, id);
    }

    @Override
    public Symbols.ModuleSymbol connectModuleToClass(Symbols.ModuleSymbol m, Symbols.ClassSymbol moduleClass) {
        return Symbols.connectModuleToClass$(this, m, moduleClass);
    }

    @Override
    public Symbols.FreeTermSymbol newFreeTermSymbol(Names.TermName name, Function0<Object> value, long flags, String origin) {
        return Symbols.newFreeTermSymbol$(this, name, value, flags, origin);
    }

    @Override
    public long newFreeTermSymbol$default$3() {
        return Symbols.newFreeTermSymbol$default$3$(this);
    }

    @Override
    public Symbols.FreeTypeSymbol newFreeTypeSymbol(Names.TypeName name, long flags, String origin) {
        return Symbols.newFreeTypeSymbol$(this, name, flags, origin);
    }

    @Override
    public long newFreeTypeSymbol$default$2() {
        return Symbols.newFreeTypeSymbol$default$2$(this);
    }

    @Override
    public void saveOriginalOwner(Symbols.Symbol sym) {
        Symbols.saveOriginalOwner$(this, sym);
    }

    @Override
    public void defineOriginalOwner(Symbols.Symbol sym, Symbols.Symbol owner) {
        Symbols.defineOriginalOwner$(this, sym, owner);
    }

    @Override
    public <T> Symbols.TypeSymbol symbolOf(TypeTags.WeakTypeTag<T> evidence$1) {
        return Symbols.symbolOf$(this, evidence$1);
    }

    @Override
    public Symbols.Symbol newStubSymbol(Symbols.Symbol owner, Names.Name name, String missingMessage) {
        return Symbols.newStubSymbol$(this, owner, name, missingMessage);
    }

    @Override
    public Symbols.NoSymbol makeNoSymbol() {
        return Symbols.makeNoSymbol$(this);
    }

    @Override
    public List<Symbols.Symbol> deriveSymbols(List<Symbols.Symbol> syms, Function1<Symbols.Symbol, Symbols.Symbol> symFn) {
        return Symbols.deriveSymbols$(this, syms, symFn);
    }

    @Override
    public <A> List<Symbols.Symbol> deriveSymbols2(List<Symbols.Symbol> syms, List<A> as, Function2<Symbols.Symbol, A, Symbols.Symbol> symFn) {
        return Symbols.deriveSymbols2$(this, syms, as, symFn);
    }

    @Override
    public Types.Type deriveType(List<Symbols.Symbol> syms, Function1<Symbols.Symbol, Symbols.Symbol> symFn, Types.Type tpe) {
        return Symbols.deriveType$(this, syms, symFn, tpe);
    }

    @Override
    public <A> Types.Type deriveType2(List<Symbols.Symbol> syms, List<A> as, Function2<Symbols.Symbol, A, Symbols.Symbol> symFn, Types.Type tpe) {
        return Symbols.deriveType2$(this, syms, as, symFn, tpe);
    }

    @Override
    public Types.Type deriveTypeWithWildcards(List<Symbols.Symbol> syms, Types.Type tpe) {
        return Symbols.deriveTypeWithWildcards$(this, syms, tpe);
    }

    @Override
    public List<Symbols.Symbol> cloneSymbols(List<Symbols.Symbol> syms) {
        return Symbols.cloneSymbols$(this, syms);
    }

    @Override
    public List<Symbols.Symbol> cloneSymbolsAtOwner(List<Symbols.Symbol> syms, Symbols.Symbol owner) {
        return Symbols.cloneSymbolsAtOwner$(this, syms, owner);
    }

    @Override
    public List<Symbols.Symbol> cloneSymbolsAndModify(List<Symbols.Symbol> syms, Function1<Types.Type, Types.Type> infoFn) {
        return Symbols.cloneSymbolsAndModify$(this, syms, infoFn);
    }

    @Override
    public List<Symbols.Symbol> cloneSymbolsAtOwnerAndModify(List<Symbols.Symbol> syms, Symbols.Symbol owner, Function1<Types.Type, Types.Type> infoFn) {
        return Symbols.cloneSymbolsAtOwnerAndModify$(this, syms, owner, infoFn);
    }

    @Override
    public <T> T createFromClonedSymbols(List<Symbols.Symbol> syms, Types.Type tpe, Function2<List<Symbols.Symbol>, Types.Type, T> creator) {
        return (T)Symbols.createFromClonedSymbols$(this, syms, tpe, creator);
    }

    @Override
    public <T> T createFromClonedSymbolsAtOwner(List<Symbols.Symbol> syms, Symbols.Symbol owner, Types.Type tpe, Function2<List<Symbols.Symbol>, Types.Type, T> creator) {
        return (T)Symbols.createFromClonedSymbolsAtOwner$(this, syms, owner, tpe, creator);
    }

    @Override
    public <T> List<List<T>> mapParamss(Symbols.Symbol sym, Function1<Symbols.Symbol, T> f) {
        return Symbols.mapParamss$(this, sym, f);
    }

    @Override
    public void foreachParamss(Symbols.Symbol sym, Function1<Symbols.Symbol, BoxedUnit> f) {
        Symbols.foreachParamss$(this, sym, f);
    }

    @Override
    public List<Symbols.Symbol> existingSymbols(List<Symbols.Symbol> syms) {
        return Symbols.existingSymbols$(this, syms);
    }

    @Override
    public final Symbols.Symbol closestEnclMethod(Symbols.Symbol from) {
        return Symbols.closestEnclMethod$(this, from);
    }

    @Override
    public final boolean allSymbolsHaveOwner(List<Symbols.Symbol> syms, Symbols.Symbol owner) {
        return Symbols.allSymbolsHaveOwner$(this, syms, owner);
    }

    @Override
    public Symbols.SymbolOps FlagOps(long mask) {
        return Symbols.FlagOps$(this, mask);
    }

    @Override
    public void markFlagsCompleted(Seq<Symbols.Symbol> syms, long mask) {
        Symbols.markFlagsCompleted$(this, syms, mask);
    }

    @Override
    public void markAllCompleted(Seq<Symbols.Symbol> syms) {
        Symbols.markAllCompleted$(this, syms);
    }

    @Override
    public boolean synchronizeNames() {
        return Names.synchronizeNames$(this);
    }

    @Override
    public char[] chrs() {
        return Names.chrs$(this);
    }

    @Override
    public void chrs_$eq(char[] cs) {
        Names.chrs_$eq$(this, cs);
    }

    @Override
    public final Iterator<Names.TermName> allNames() {
        return Names.allNames$(this);
    }

    @Override
    public final Names.TermName newTermName(char[] cs, int offset, int len) {
        return Names.newTermName$((Names)this, cs, offset, len);
    }

    @Override
    public final Names.TermName newTermName(char[] cs) {
        return Names.newTermName$((Names)this, cs);
    }

    @Override
    public final Names.TypeName newTypeName(char[] cs) {
        return Names.newTypeName$((Names)this, cs);
    }

    @Override
    public final Names.TermName newTermName(char[] cs, int offset, int len0, String cachedString) {
        return Names.newTermName$(this, cs, offset, len0, cachedString);
    }

    @Override
    public final Names.TypeName newTypeName(char[] cs, int offset, int len, String cachedString) {
        return Names.newTypeName$(this, cs, offset, len, cachedString);
    }

    @Override
    public Names.TermName newTermName(String s) {
        return Names.newTermName$((Names)this, s);
    }

    @Override
    public Names.TypeName newTypeName(String s) {
        return Names.newTypeName$((Names)this, s);
    }

    @Override
    public final Names.TermName newTermName(byte[] bs, int offset, int len) {
        return Names.newTermName$((Names)this, bs, offset, len);
    }

    @Override
    public final Names.TermName newTermNameCached(String s) {
        return Names.newTermNameCached$(this, s);
    }

    @Override
    public final Names.TypeName newTypeNameCached(String s) {
        return Names.newTypeNameCached$(this, s);
    }

    @Override
    public final Names.TypeName newTypeName(char[] cs, int offset, int len) {
        return Names.newTypeName$((Names)this, cs, offset, len);
    }

    @Override
    public final Names.TypeName newTypeName(byte[] bs, int offset, int len) {
        return Names.newTypeName$((Names)this, bs, offset, len);
    }

    @Override
    public final Names.TypeName lookupTypeName(char[] cs) {
        return Names.lookupTypeName$(this, cs);
    }

    @Override
    public Names.NameOps<Names.Name> AnyNameOps(Names.Name name) {
        return Names.AnyNameOps$(this, name);
    }

    @Override
    public Names.NameOps<Names.TermName> TermNameOps(Names.TermName name) {
        return Names.TermNameOps$(this, name);
    }

    @Override
    public Names.NameOps<Names.TypeName> TypeNameOps(Names.TypeName name) {
        return Names.TypeNameOps$(this, name);
    }

    @Override
    public final <A, B, C> boolean corresponds3(List<A> xs1, List<B> xs2, List<C> xs3, Function3<A, B, C, Object> f) {
        return Collections.corresponds3$(this, xs1, xs2, xs3, f);
    }

    @Override
    public final <A> boolean mexists(List<List<A>> xss, Function1<A, Object> p) {
        return Collections.mexists$(this, xss, p);
    }

    @Override
    public final <A> boolean mforall(List<List<A>> xss, Function1<A, Object> p) {
        return Collections.mforall$(this, xss, p);
    }

    @Override
    public final <A, B> List<List<B>> mmap(List<List<A>> xss, Function1<A, B> f) {
        return Collections.mmap$(this, xss, f);
    }

    @Override
    public final <A> Option<A> mfind(List<List<A>> xss, Function1<A, Object> p) {
        return Collections.mfind$(this, xss, p);
    }

    @Override
    public final <A> void mforeach(List<List<A>> xss, Function1<A, BoxedUnit> f) {
        Collections.mforeach$((Collections)this, xss, f);
    }

    @Override
    public final <A> void mforeach(Traversable<Traversable<A>> xss, Function1<A, BoxedUnit> f) {
        Collections.mforeach$((Collections)this, xss, f);
    }

    @Override
    public final <A, B> List<B> mapList(List<A> as, Function1<A, B> f) {
        return Collections.mapList$(this, as, f);
    }

    @Override
    public final boolean sameElementsEquals(List<Object> thiss, List<Object> that) {
        return Collections.sameElementsEquals$(this, thiss, that);
    }

    @Override
    public final <A, B> Option<B> collectFirst(List<A> as, PartialFunction<A, B> pf) {
        return Collections.collectFirst$(this, as, pf);
    }

    @Override
    public final <A, B, C> List<C> map2(List<A> xs1, List<B> xs2, Function2<A, B, C> f) {
        return Collections.map2$(this, xs1, xs2, f);
    }

    @Override
    public final <A, B> List<A> map2Conserve(List<A> xs, List<B> ys, Function2<A, B, A> f) {
        return Collections.map2Conserve$(this, xs, ys, f);
    }

    @Override
    public final <A, B, C, D> List<D> map3(List<A> xs1, List<B> xs2, List<C> xs3, Function3<A, B, C, D> f) {
        return Collections.map3$(this, xs1, xs2, xs3, f);
    }

    @Override
    public final <A, B, C> List<C> flatMap2(List<A> xs1, List<B> xs2, Function2<A, B, List<C>> f) {
        return Collections.flatMap2$(this, xs1, xs2, f);
    }

    @Override
    public final <A1, A2, B> B foldLeft2(List<A1> xs1, List<A2> xs2, B z0, Function3<B, A1, A2, B> f) {
        return (B)Collections.foldLeft2$(this, xs1, xs2, z0, f);
    }

    @Override
    public final <A, B> List<B> flatCollect(List<A> elems, PartialFunction<A, Traversable<B>> pf) {
        return Collections.flatCollect$(this, elems, pf);
    }

    @Override
    public final <A, B> List<A> distinctBy(List<A> xs, Function1<A, B> f) {
        return Collections.distinctBy$(this, xs, f);
    }

    @Override
    public final boolean flattensToEmpty(Seq<Seq<?>> xss) {
        return Collections.flattensToEmpty$(this, xss);
    }

    @Override
    public final <A> void foreachWithIndex(List<A> xs, Function2<A, Object, BoxedUnit> f) {
        Collections.foreachWithIndex$(this, xs, f);
    }

    @Override
    public final <A> A findOrElse(TraversableOnce<A> xs, Function1<A, Object> p, Function0<A> orElse) {
        return (A)Collections.findOrElse$(this, xs, p, orElse);
    }

    @Override
    public final <A, A1, B> Map<A1, B> mapFrom(List<A> xs, Function1<A, B> f) {
        return Collections.mapFrom$(this, xs, f);
    }

    @Override
    public final <A, A1, B> LinkedHashMap<A1, B> linkedMapFrom(List<A> xs, Function1<A, B> f) {
        return Collections.linkedMapFrom$(this, xs, f);
    }

    @Override
    public final <A, B> List<B> mapWithIndex(List<A> xs, Function2<A, Object, B> f) {
        return Collections.mapWithIndex$(this, xs, f);
    }

    @Override
    public final <A, B, C> Map<A, B> collectMap2(List<A> xs1, List<B> xs2, Function2<A, B, Object> p) {
        return Collections.collectMap2$(this, xs1, xs2, p);
    }

    @Override
    public final <A, B> void foreach2(List<A> xs1, List<B> xs2, Function2<A, B, BoxedUnit> f) {
        Collections.foreach2$(this, xs1, xs2, f);
    }

    @Override
    public final <A, B, C> void foreach3(List<A> xs1, List<B> xs2, List<C> xs3, Function3<A, B, C, BoxedUnit> f) {
        Collections.foreach3$(this, xs1, xs2, xs3, f);
    }

    @Override
    public final <A, B> boolean exists2(List<A> xs1, List<B> xs2, Function2<A, B, Object> f) {
        return Collections.exists2$(this, xs1, xs2, f);
    }

    @Override
    public final <A, B, C> boolean exists3(List<A> xs1, List<B> xs2, List<C> xs3, Function3<A, B, C, Object> f) {
        return Collections.exists3$(this, xs1, xs2, xs3, f);
    }

    @Override
    public final <A, B, C> boolean forall3(List<A> xs1, List<B> xs2, List<C> xs3, Function3<A, B, C, Object> f) {
        return Collections.forall3$(this, xs1, xs2, xs3, f);
    }

    @Override
    public final <A, B, C> Iterator<C> mapFilter2(Iterator<A> itA, Iterator<B> itB, Function2<A, B, Option<C>> f) {
        return Collections.mapFilter2$(this, itA, itB, f);
    }

    @Override
    public final <A> Option<List<A>> sequenceOpt(List<Option<A>> as) {
        return Collections.sequenceOpt$(this, as);
    }

    @Override
    public final <A, B> Option<List<B>> traverseOpt(List<A> as, Function1<A, Option<B>> f) {
        return Collections.traverseOpt$(this, as, f);
    }

    @Override
    public final <A> BitSet bitSetByPredicate(List<A> xs, Function1<A, Object> pred) {
        return Collections.bitSetByPredicate$(this, xs, pred);
    }

    @Override
    public final <A> Option<List<A>> sequence(List<Option<A>> as) {
        return Collections.sequence$(this, as);
    }

    @Override
    public final <A> Option<List<List<A>>> transposeSafe(List<List<A>> ass) {
        return Collections.transposeSafe$(this, ass);
    }

    @Override
    public final boolean sameLength(List<?> xs1, List<?> xs2) {
        return Collections.sameLength$(this, xs1, xs2);
    }

    @Override
    public final int compareLengths(List<?> xs1, List<?> xs2) {
        return Collections.compareLengths$(this, xs1, xs2);
    }

    @Override
    public final boolean hasLength(List<?> xs, int len) {
        return Collections.hasLength$(this, xs, len);
    }

    @Override
    public final int sumSize(List<List<?>> xss, int acc) {
        return Collections.sumSize$(this, xss, acc);
    }

    private SymbolTable$SimpleNameOrdering$ SimpleNameOrdering() {
        if (this.SimpleNameOrdering$module == null) {
            this.SimpleNameOrdering$lzycompute$1();
        }
        return this.SimpleNameOrdering$module;
    }

    public SymbolTable$traceSymbols$ traceSymbols() {
        if (this.traceSymbols$module == null) {
            this.traceSymbols$lzycompute$1();
        }
        return this.traceSymbols$module;
    }

    public SymbolTable$perRunCaches$ perRunCaches() {
        if (this.perRunCaches$module == null) {
            this.perRunCaches$lzycompute$1();
        }
        return this.perRunCaches$module;
    }

    private Universe.MacroInternalApi internal$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 1) == 0) {
                this.internal = Internals.internal$(this);
                this.bitmap$0 |= 1;
            }
        }
        return this.internal;
    }

    @Override
    public Universe.MacroInternalApi internal() {
        if ((this.bitmap$0 & 1) == 0) {
            return this.internal$lzycompute();
        }
        return this.internal;
    }

    private Universe.MacroCompatApi compat$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 2) == 0) {
                this.compat = Internals.compat$(this);
                this.bitmap$0 |= 2;
            }
        }
        return this.compat;
    }

    @Override
    public Universe.MacroCompatApi compat() {
        if ((this.bitmap$0 & 2) == 0) {
            return this.compat$lzycompute();
        }
        return this.compat;
    }

    private Universe.TreeGen treeBuild$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 4) == 0) {
                this.treeBuild = Internals.treeBuild$(this);
                this.bitmap$0 |= 4;
            }
        }
        return this.treeBuild;
    }

    @Override
    public Universe.TreeGen treeBuild() {
        if ((this.bitmap$0 & 4) == 0) {
            return this.treeBuild$lzycompute();
        }
        return this.treeBuild;
    }

    @Override
    public FreshNameCreator globalFreshNameCreator() {
        return this.globalFreshNameCreator;
    }

    @Override
    public FreshNames$FreshNameExtractor$ FreshNameExtractor() {
        if (this.FreshNameExtractor$module == null) {
            this.FreshNameExtractor$lzycompute$1();
        }
        return this.FreshNameExtractor$module;
    }

    @Override
    public void scala$reflect$internal$FreshNames$_setter_$globalFreshNameCreator_$eq(FreshNameCreator x$1) {
        this.globalFreshNameCreator = x$1;
    }

    @Override
    public ReificationSupport.ReificationSupportImpl build() {
        return this.build;
    }

    @Override
    public void scala$reflect$internal$ReificationSupport$_setter_$build_$eq(ReificationSupport.ReificationSupportImpl x$1) {
        this.build = x$1;
    }

    @Override
    public StdCreators$FixedMirrorTreeCreator$ FixedMirrorTreeCreator() {
        if (this.FixedMirrorTreeCreator$module == null) {
            this.FixedMirrorTreeCreator$lzycompute$1();
        }
        return this.FixedMirrorTreeCreator$module;
    }

    @Override
    public StdCreators$FixedMirrorTypeCreator$ FixedMirrorTypeCreator() {
        if (this.FixedMirrorTypeCreator$module == null) {
            this.FixedMirrorTypeCreator$lzycompute$1();
        }
        return this.FixedMirrorTypeCreator$module;
    }

    @Override
    public StdAttachments$CompoundTypeTreeOriginalAttachment$ CompoundTypeTreeOriginalAttachment() {
        if (this.CompoundTypeTreeOriginalAttachment$module == null) {
            this.CompoundTypeTreeOriginalAttachment$lzycompute$1();
        }
        return this.CompoundTypeTreeOriginalAttachment$module;
    }

    @Override
    public StdAttachments$SAMFunction$ SAMFunction() {
        if (this.SAMFunction$module == null) {
            this.SAMFunction$lzycompute$1();
        }
        return this.SAMFunction$module;
    }

    @Override
    public StdAttachments$DelambdafyTarget$ DelambdafyTarget() {
        if (this.DelambdafyTarget$module == null) {
            this.DelambdafyTarget$lzycompute$1();
        }
        return this.DelambdafyTarget$module;
    }

    @Override
    public StdAttachments$JustMethodReference$ JustMethodReference() {
        if (this.JustMethodReference$module == null) {
            this.JustMethodReference$lzycompute$1();
        }
        return this.JustMethodReference$module;
    }

    @Override
    public StdAttachments$BackquotedIdentifierAttachment$ BackquotedIdentifierAttachment() {
        if (this.BackquotedIdentifierAttachment$module == null) {
            this.BackquotedIdentifierAttachment$lzycompute$1();
        }
        return this.BackquotedIdentifierAttachment$module;
    }

    @Override
    public StdAttachments$NoWarnAttachment$ NoWarnAttachment() {
        if (this.NoWarnAttachment$module == null) {
            this.NoWarnAttachment$lzycompute$1();
        }
        return this.NoWarnAttachment$module;
    }

    @Override
    public StdAttachments$PatVarDefAttachment$ PatVarDefAttachment() {
        if (this.PatVarDefAttachment$module == null) {
            this.PatVarDefAttachment$lzycompute$1();
        }
        return this.PatVarDefAttachment$module;
    }

    @Override
    public StdAttachments$ForAttachment$ ForAttachment() {
        if (this.ForAttachment$module == null) {
            this.ForAttachment$lzycompute$1();
        }
        return this.ForAttachment$module;
    }

    @Override
    public StdAttachments$SyntheticUnitAttachment$ SyntheticUnitAttachment() {
        if (this.SyntheticUnitAttachment$module == null) {
            this.SyntheticUnitAttachment$lzycompute$1();
        }
        return this.SyntheticUnitAttachment$module;
    }

    @Override
    public StdAttachments$SubpatternsAttachment$ SubpatternsAttachment() {
        if (this.SubpatternsAttachment$module == null) {
            this.SubpatternsAttachment$lzycompute$1();
        }
        return this.SubpatternsAttachment$module;
    }

    @Override
    public StdAttachments$NoInlineCallsiteAttachment$ NoInlineCallsiteAttachment() {
        if (this.NoInlineCallsiteAttachment$module == null) {
            this.NoInlineCallsiteAttachment$lzycompute$1();
        }
        return this.NoInlineCallsiteAttachment$module;
    }

    @Override
    public StdAttachments$InlineCallsiteAttachment$ InlineCallsiteAttachment() {
        if (this.InlineCallsiteAttachment$module == null) {
            this.InlineCallsiteAttachment$lzycompute$1();
        }
        return this.InlineCallsiteAttachment$module;
    }

    @Override
    public StdAttachments$OuterArgCanBeElided$ OuterArgCanBeElided() {
        if (this.OuterArgCanBeElided$module == null) {
            this.OuterArgCanBeElided$lzycompute$1();
        }
        return this.OuterArgCanBeElided$module;
    }

    @Override
    public StdAttachments$UseInvokeSpecial$ UseInvokeSpecial() {
        if (this.UseInvokeSpecial$module == null) {
            this.UseInvokeSpecial$lzycompute$1();
        }
        return this.UseInvokeSpecial$module;
    }

    @Override
    public StdAttachments$TypeParamVarargsAttachment$ TypeParamVarargsAttachment() {
        if (this.TypeParamVarargsAttachment$module == null) {
            this.TypeParamVarargsAttachment$lzycompute$1();
        }
        return this.TypeParamVarargsAttachment$module;
    }

    @Override
    public StdAttachments$KnownDirectSubclassesCalled$ KnownDirectSubclassesCalled() {
        if (this.KnownDirectSubclassesCalled$module == null) {
            this.KnownDirectSubclassesCalled$lzycompute$1();
        }
        return this.KnownDirectSubclassesCalled$module;
    }

    @Override
    public StdAttachments$ChangeOwnerAttachment$ ChangeOwnerAttachment() {
        if (this.ChangeOwnerAttachment$module == null) {
            this.ChangeOwnerAttachment$lzycompute$1();
        }
        return this.ChangeOwnerAttachment$module;
    }

    @Override
    public TypeDebugging$noPrint$ noPrint() {
        if (this.noPrint$module == null) {
            this.noPrint$lzycompute$1();
        }
        return this.noPrint$module;
    }

    @Override
    public TypeDebugging$typeDebug$ typeDebug() {
        if (this.typeDebug$module == null) {
            this.typeDebug$lzycompute$1();
        }
        return this.typeDebug$module;
    }

    @Override
    public NoPosition$ NoPosition() {
        return this.NoPosition;
    }

    @Override
    public ClassTag<Position> PositionTag() {
        return this.PositionTag;
    }

    @Override
    public Ordering<Trees.Tree> scala$reflect$internal$Positions$$posStartOrdering() {
        return this.scala$reflect$internal$Positions$$posStartOrdering;
    }

    @Override
    public ReusableInstance<Positions.SetChildrenPosAccumulator> scala$reflect$internal$Positions$$setChildrenPosAccumulator() {
        return this.scala$reflect$internal$Positions$$setChildrenPosAccumulator;
    }

    private Positions.PosAssigner posAssigner$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 8) == 0) {
                this.posAssigner = Positions.posAssigner$(this);
                this.bitmap$0 |= 8;
            }
        }
        return this.posAssigner;
    }

    @Override
    public Positions.PosAssigner posAssigner() {
        if ((this.bitmap$0 & 8) == 0) {
            return this.posAssigner$lzycompute();
        }
        return this.posAssigner;
    }

    @Override
    public void scala$reflect$internal$Positions$_setter_$NoPosition_$eq(NoPosition$ x$1) {
        this.NoPosition = x$1;
    }

    @Override
    public void scala$reflect$internal$Positions$_setter_$PositionTag_$eq(ClassTag<Position> x$1) {
        this.PositionTag = x$1;
    }

    @Override
    public final void scala$reflect$internal$Positions$_setter_$scala$reflect$internal$Positions$$posStartOrdering_$eq(Ordering<Trees.Tree> x$1) {
        this.scala$reflect$internal$Positions$$posStartOrdering = x$1;
    }

    @Override
    public final void scala$reflect$internal$Positions$_setter_$scala$reflect$internal$Positions$$setChildrenPosAccumulator_$eq(ReusableInstance<Positions.SetChildrenPosAccumulator> x$1) {
        this.scala$reflect$internal$Positions$$setChildrenPosAccumulator = x$1;
    }

    @Override
    public Printers$ConsoleWriter$ ConsoleWriter() {
        if (this.ConsoleWriter$module == null) {
            this.ConsoleWriter$lzycompute$1();
        }
        return this.ConsoleWriter$module;
    }

    @Override
    public int nodeCount() {
        return this.nodeCount;
    }

    @Override
    public void nodeCount_$eq(int x$1) {
        this.nodeCount = x$1;
    }

    @Override
    public Trees$RefTree$ RefTree() {
        if (this.RefTree$module == null) {
            this.RefTree$lzycompute$1();
        }
        return this.RefTree$module;
    }

    @Override
    public Trees$PackageDef$ PackageDef() {
        if (this.PackageDef$module == null) {
            this.PackageDef$lzycompute$1();
        }
        return this.PackageDef$module;
    }

    @Override
    public Trees$ClassDef$ ClassDef() {
        if (this.ClassDef$module == null) {
            this.ClassDef$lzycompute$1();
        }
        return this.ClassDef$module;
    }

    @Override
    public Trees$ModuleDef$ ModuleDef() {
        if (this.ModuleDef$module == null) {
            this.ModuleDef$lzycompute$1();
        }
        return this.ModuleDef$module;
    }

    @Override
    public Trees$ValOrDefDef$ ValOrDefDef() {
        if (this.ValOrDefDef$module == null) {
            this.ValOrDefDef$lzycompute$1();
        }
        return this.ValOrDefDef$module;
    }

    @Override
    public Trees$ValDef$ ValDef() {
        if (this.ValDef$module == null) {
            this.ValDef$lzycompute$1();
        }
        return this.ValDef$module;
    }

    @Override
    public Trees$DefDef$ DefDef() {
        if (this.DefDef$module == null) {
            this.DefDef$lzycompute$1();
        }
        return this.DefDef$module;
    }

    @Override
    public Trees$TypeDef$ TypeDef() {
        if (this.TypeDef$module == null) {
            this.TypeDef$lzycompute$1();
        }
        return this.TypeDef$module;
    }

    @Override
    public Trees$LabelDef$ LabelDef() {
        if (this.LabelDef$module == null) {
            this.LabelDef$lzycompute$1();
        }
        return this.LabelDef$module;
    }

    @Override
    public Trees$ImportSelector$ ImportSelector() {
        if (this.ImportSelector$module == null) {
            this.ImportSelector$lzycompute$1();
        }
        return this.ImportSelector$module;
    }

    @Override
    public Trees$Import$ Import() {
        if (this.Import$module == null) {
            this.Import$lzycompute$1();
        }
        return this.Import$module;
    }

    @Override
    public Trees$Template$ Template() {
        if (this.Template$module == null) {
            this.Template$lzycompute$1();
        }
        return this.Template$module;
    }

    @Override
    public Trees$Block$ Block() {
        if (this.Block$module == null) {
            this.Block$lzycompute$1();
        }
        return this.Block$module;
    }

    @Override
    public Trees$CaseDef$ CaseDef() {
        if (this.CaseDef$module == null) {
            this.CaseDef$lzycompute$1();
        }
        return this.CaseDef$module;
    }

    @Override
    public Trees$Alternative$ Alternative() {
        if (this.Alternative$module == null) {
            this.Alternative$lzycompute$1();
        }
        return this.Alternative$module;
    }

    @Override
    public Trees$Star$ Star() {
        if (this.Star$module == null) {
            this.Star$lzycompute$1();
        }
        return this.Star$module;
    }

    @Override
    public Trees$Bind$ Bind() {
        if (this.Bind$module == null) {
            this.Bind$lzycompute$1();
        }
        return this.Bind$module;
    }

    @Override
    public Trees$UnApply$ UnApply() {
        if (this.UnApply$module == null) {
            this.UnApply$lzycompute$1();
        }
        return this.UnApply$module;
    }

    @Override
    public Trees$ArrayValue$ ArrayValue() {
        if (this.ArrayValue$module == null) {
            this.ArrayValue$lzycompute$1();
        }
        return this.ArrayValue$module;
    }

    @Override
    public Trees$Function$ Function() {
        if (this.Function$module == null) {
            this.Function$lzycompute$1();
        }
        return this.Function$module;
    }

    @Override
    public Trees$Assign$ Assign() {
        if (this.Assign$module == null) {
            this.Assign$lzycompute$1();
        }
        return this.Assign$module;
    }

    @Override
    public Trees$AssignOrNamedArg$ AssignOrNamedArg() {
        if (this.AssignOrNamedArg$module == null) {
            this.AssignOrNamedArg$lzycompute$1();
        }
        return this.AssignOrNamedArg$module;
    }

    @Override
    public Trees$If$ If() {
        if (this.If$module == null) {
            this.If$lzycompute$1();
        }
        return this.If$module;
    }

    @Override
    public Trees$Match$ Match() {
        if (this.Match$module == null) {
            this.Match$lzycompute$1();
        }
        return this.Match$module;
    }

    @Override
    public Trees$Return$ Return() {
        if (this.Return$module == null) {
            this.Return$lzycompute$1();
        }
        return this.Return$module;
    }

    @Override
    public Trees$Try$ Try() {
        if (this.Try$module == null) {
            this.Try$lzycompute$1();
        }
        return this.Try$module;
    }

    @Override
    public Trees$Throw$ Throw() {
        if (this.Throw$module == null) {
            this.Throw$lzycompute$1();
        }
        return this.Throw$module;
    }

    @Override
    public Trees$New$ New() {
        if (this.New$module == null) {
            this.New$lzycompute$1();
        }
        return this.New$module;
    }

    @Override
    public Trees$Typed$ Typed() {
        if (this.Typed$module == null) {
            this.Typed$lzycompute$1();
        }
        return this.Typed$module;
    }

    @Override
    public Trees$MethodValue$ MethodValue() {
        if (this.MethodValue$module == null) {
            this.MethodValue$lzycompute$1();
        }
        return this.MethodValue$module;
    }

    @Override
    public Trees$TypeApply$ TypeApply() {
        if (this.TypeApply$module == null) {
            this.TypeApply$lzycompute$1();
        }
        return this.TypeApply$module;
    }

    @Override
    public Trees$Apply$ Apply() {
        if (this.Apply$module == null) {
            this.Apply$lzycompute$1();
        }
        return this.Apply$module;
    }

    @Override
    public Trees$ApplyDynamic$ ApplyDynamic() {
        if (this.ApplyDynamic$module == null) {
            this.ApplyDynamic$lzycompute$1();
        }
        return this.ApplyDynamic$module;
    }

    @Override
    public Trees$Super$ Super() {
        if (this.Super$module == null) {
            this.Super$lzycompute$1();
        }
        return this.Super$module;
    }

    @Override
    public Trees$This$ This() {
        if (this.This$module == null) {
            this.This$lzycompute$1();
        }
        return this.This$module;
    }

    @Override
    public Trees$Select$ Select() {
        if (this.Select$module == null) {
            this.Select$lzycompute$1();
        }
        return this.Select$module;
    }

    @Override
    public Trees$Ident$ Ident() {
        if (this.Ident$module == null) {
            this.Ident$lzycompute$1();
        }
        return this.Ident$module;
    }

    @Override
    public Trees$ReferenceToBoxed$ ReferenceToBoxed() {
        if (this.ReferenceToBoxed$module == null) {
            this.ReferenceToBoxed$lzycompute$1();
        }
        return this.ReferenceToBoxed$module;
    }

    @Override
    public Trees$Literal$ Literal() {
        if (this.Literal$module == null) {
            this.Literal$lzycompute$1();
        }
        return this.Literal$module;
    }

    @Override
    public Trees$Annotated$ Annotated() {
        if (this.Annotated$module == null) {
            this.Annotated$lzycompute$1();
        }
        return this.Annotated$module;
    }

    @Override
    public Trees$SingletonTypeTree$ SingletonTypeTree() {
        if (this.SingletonTypeTree$module == null) {
            this.SingletonTypeTree$lzycompute$1();
        }
        return this.SingletonTypeTree$module;
    }

    @Override
    public Trees$SelectFromTypeTree$ SelectFromTypeTree() {
        if (this.SelectFromTypeTree$module == null) {
            this.SelectFromTypeTree$lzycompute$1();
        }
        return this.SelectFromTypeTree$module;
    }

    @Override
    public Trees$CompoundTypeTree$ CompoundTypeTree() {
        if (this.CompoundTypeTree$module == null) {
            this.CompoundTypeTree$lzycompute$1();
        }
        return this.CompoundTypeTree$module;
    }

    @Override
    public Trees$AppliedTypeTree$ AppliedTypeTree() {
        if (this.AppliedTypeTree$module == null) {
            this.AppliedTypeTree$lzycompute$1();
        }
        return this.AppliedTypeTree$module;
    }

    @Override
    public Trees$TypeBoundsTree$ TypeBoundsTree() {
        if (this.TypeBoundsTree$module == null) {
            this.TypeBoundsTree$lzycompute$1();
        }
        return this.TypeBoundsTree$module;
    }

    @Override
    public Trees$ExistentialTypeTree$ ExistentialTypeTree() {
        if (this.ExistentialTypeTree$module == null) {
            this.ExistentialTypeTree$lzycompute$1();
        }
        return this.ExistentialTypeTree$module;
    }

    @Override
    public Trees$TypeTree$ TypeTree() {
        if (this.TypeTree$module == null) {
            this.TypeTree$lzycompute$1();
        }
        return this.TypeTree$module;
    }

    @Override
    public Trees$Modifiers$ Modifiers() {
        if (this.Modifiers$module == null) {
            this.Modifiers$lzycompute$1();
        }
        return this.Modifiers$module;
    }

    @Override
    public ClassTag<Trees.Modifiers> ModifiersTag() {
        return this.ModifiersTag;
    }

    @Override
    public Trees$EmptyTree$ EmptyTree() {
        if (this.EmptyTree$module == null) {
            this.EmptyTree$lzycompute$1();
        }
        return this.EmptyTree$module;
    }

    @Override
    public Trees$noSelfType$ noSelfType() {
        if (this.noSelfType$module == null) {
            this.noSelfType$lzycompute$1();
        }
        return this.noSelfType$module;
    }

    @Override
    public Trees$pendingSuperCall$ pendingSuperCall() {
        if (this.pendingSuperCall$module == null) {
            this.pendingSuperCall$lzycompute$1();
        }
        return this.pendingSuperCall$module;
    }

    private Trees$noSelfType$ emptyValDef$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x10) == 0) {
                this.emptyValDef = Trees.emptyValDef$(this);
                this.bitmap$0 |= 0x10;
            }
        }
        return this.emptyValDef;
    }

    @Override
    public Trees$noSelfType$ emptyValDef() {
        if ((this.bitmap$0 & 0x10) == 0) {
            return this.emptyValDef$lzycompute();
        }
        return this.emptyValDef;
    }

    private Trees.TreeTypeSubstituter EmptyTreeTypeSubstituter$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x20) == 0) {
                this.EmptyTreeTypeSubstituter = Trees.EmptyTreeTypeSubstituter$(this);
                this.bitmap$0 |= 0x20;
            }
        }
        return this.EmptyTreeTypeSubstituter;
    }

    @Override
    public Trees.TreeTypeSubstituter EmptyTreeTypeSubstituter() {
        if ((this.bitmap$0 & 0x20) == 0) {
            return this.EmptyTreeTypeSubstituter$lzycompute();
        }
        return this.EmptyTreeTypeSubstituter;
    }

    private Trees.Duplicator scala$reflect$internal$Trees$$duplicator$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x40) == 0) {
                this.scala$reflect$internal$Trees$$duplicator = Trees.scala$reflect$internal$Trees$$duplicator$(this);
                this.bitmap$0 |= 0x40;
            }
        }
        return this.scala$reflect$internal$Trees$$duplicator;
    }

    @Override
    public Trees.Duplicator scala$reflect$internal$Trees$$duplicator() {
        if ((this.bitmap$0 & 0x40) == 0) {
            return this.scala$reflect$internal$Trees$$duplicator$lzycompute();
        }
        return this.scala$reflect$internal$Trees$$duplicator;
    }

    @Override
    public Trees$duplicateAndResetPos$ duplicateAndResetPos() {
        if (this.duplicateAndResetPos$module == null) {
            this.duplicateAndResetPos$lzycompute$1();
        }
        return this.duplicateAndResetPos$module;
    }

    @Override
    public ReusableInstance<Trees.OnlyChildAccumulator> scala$reflect$internal$Trees$$onlyChildAccumulator() {
        return this.scala$reflect$internal$Trees$$onlyChildAccumulator;
    }

    @Override
    public ClassTag<Trees.Alternative> AlternativeTag() {
        return this.AlternativeTag;
    }

    @Override
    public ClassTag<Trees.Annotated> AnnotatedTag() {
        return this.AnnotatedTag;
    }

    @Override
    public ClassTag<Trees.AppliedTypeTree> AppliedTypeTreeTag() {
        return this.AppliedTypeTreeTag;
    }

    @Override
    public ClassTag<Trees.Apply> ApplyTag() {
        return this.ApplyTag;
    }

    @Override
    public ClassTag<Trees.AssignOrNamedArg> AssignOrNamedArgTag() {
        return this.AssignOrNamedArgTag;
    }

    @Override
    public ClassTag<Trees.Assign> AssignTag() {
        return this.AssignTag;
    }

    @Override
    public ClassTag<Trees.Bind> BindTag() {
        return this.BindTag;
    }

    @Override
    public ClassTag<Trees.Block> BlockTag() {
        return this.BlockTag;
    }

    @Override
    public ClassTag<Trees.CaseDef> CaseDefTag() {
        return this.CaseDefTag;
    }

    @Override
    public ClassTag<Trees.ClassDef> ClassDefTag() {
        return this.ClassDefTag;
    }

    @Override
    public ClassTag<Trees.CompoundTypeTree> CompoundTypeTreeTag() {
        return this.CompoundTypeTreeTag;
    }

    @Override
    public ClassTag<Trees.DefDef> DefDefTag() {
        return this.DefDefTag;
    }

    @Override
    public ClassTag<Trees.DefTree> DefTreeTag() {
        return this.DefTreeTag;
    }

    @Override
    public ClassTag<Trees.ExistentialTypeTree> ExistentialTypeTreeTag() {
        return this.ExistentialTypeTreeTag;
    }

    @Override
    public ClassTag<Trees.Function> FunctionTag() {
        return this.FunctionTag;
    }

    @Override
    public ClassTag<Trees.GenericApply> GenericApplyTag() {
        return this.GenericApplyTag;
    }

    @Override
    public ClassTag<Trees.Ident> IdentTag() {
        return this.IdentTag;
    }

    @Override
    public ClassTag<Trees.If> IfTag() {
        return this.IfTag;
    }

    @Override
    public ClassTag<Trees.ImplDef> ImplDefTag() {
        return this.ImplDefTag;
    }

    @Override
    public ClassTag<Trees.ImportSelector> ImportSelectorTag() {
        return this.ImportSelectorTag;
    }

    @Override
    public ClassTag<Trees.Import> ImportTag() {
        return this.ImportTag;
    }

    @Override
    public ClassTag<Trees.LabelDef> LabelDefTag() {
        return this.LabelDefTag;
    }

    @Override
    public ClassTag<Trees.Literal> LiteralTag() {
        return this.LiteralTag;
    }

    @Override
    public ClassTag<Trees.Match> MatchTag() {
        return this.MatchTag;
    }

    @Override
    public ClassTag<Trees.MemberDef> MemberDefTag() {
        return this.MemberDefTag;
    }

    @Override
    public ClassTag<Trees.ModuleDef> ModuleDefTag() {
        return this.ModuleDefTag;
    }

    @Override
    public ClassTag<Trees.NameTree> NameTreeTag() {
        return this.NameTreeTag;
    }

    @Override
    public ClassTag<Trees.New> NewTag() {
        return this.NewTag;
    }

    @Override
    public ClassTag<Trees.PackageDef> PackageDefTag() {
        return this.PackageDefTag;
    }

    @Override
    public ClassTag<Trees.ReferenceToBoxed> ReferenceToBoxedTag() {
        return this.ReferenceToBoxedTag;
    }

    @Override
    public ClassTag<Trees.RefTree> RefTreeTag() {
        return this.RefTreeTag;
    }

    @Override
    public ClassTag<Trees.Return> ReturnTag() {
        return this.ReturnTag;
    }

    @Override
    public ClassTag<Trees.SelectFromTypeTree> SelectFromTypeTreeTag() {
        return this.SelectFromTypeTreeTag;
    }

    @Override
    public ClassTag<Trees.Select> SelectTag() {
        return this.SelectTag;
    }

    @Override
    public ClassTag<Trees.SingletonTypeTree> SingletonTypeTreeTag() {
        return this.SingletonTypeTreeTag;
    }

    @Override
    public ClassTag<Trees.Star> StarTag() {
        return this.StarTag;
    }

    @Override
    public ClassTag<Trees.Super> SuperTag() {
        return this.SuperTag;
    }

    @Override
    public ClassTag<Trees.SymTree> SymTreeTag() {
        return this.SymTreeTag;
    }

    @Override
    public ClassTag<Trees.Template> TemplateTag() {
        return this.TemplateTag;
    }

    @Override
    public ClassTag<Trees.TermTree> TermTreeTag() {
        return this.TermTreeTag;
    }

    @Override
    public ClassTag<Trees.This> ThisTag() {
        return this.ThisTag;
    }

    @Override
    public ClassTag<Trees.Throw> ThrowTag() {
        return this.ThrowTag;
    }

    @Override
    public ClassTag<Trees.Tree> TreeTag() {
        return this.TreeTag;
    }

    @Override
    public ClassTag<Trees.Try> TryTag() {
        return this.TryTag;
    }

    @Override
    public ClassTag<Trees.TypTree> TypTreeTag() {
        return this.TypTreeTag;
    }

    @Override
    public ClassTag<Trees.TypeApply> TypeApplyTag() {
        return this.TypeApplyTag;
    }

    @Override
    public ClassTag<Trees.TypeBoundsTree> TypeBoundsTreeTag() {
        return this.TypeBoundsTreeTag;
    }

    @Override
    public ClassTag<Trees.TypeDef> TypeDefTag() {
        return this.TypeDefTag;
    }

    @Override
    public ClassTag<Trees.TypeTree> TypeTreeTag() {
        return this.TypeTreeTag;
    }

    @Override
    public ClassTag<Trees.Typed> TypedTag() {
        return this.TypedTag;
    }

    @Override
    public ClassTag<Trees.UnApply> UnApplyTag() {
        return this.UnApplyTag;
    }

    @Override
    public ClassTag<Trees.ValDef> ValDefTag() {
        return this.ValDefTag;
    }

    @Override
    public ClassTag<Trees.ValOrDefDef> ValOrDefDefTag() {
        return this.ValOrDefDefTag;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$ModifiersTag_$eq(ClassTag<Trees.Modifiers> x$1) {
        this.ModifiersTag = x$1;
    }

    @Override
    public final void scala$reflect$internal$Trees$_setter_$scala$reflect$internal$Trees$$onlyChildAccumulator_$eq(ReusableInstance<Trees.OnlyChildAccumulator> x$1) {
        this.scala$reflect$internal$Trees$$onlyChildAccumulator = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$AlternativeTag_$eq(ClassTag<Trees.Alternative> x$1) {
        this.AlternativeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$AnnotatedTag_$eq(ClassTag<Trees.Annotated> x$1) {
        this.AnnotatedTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$AppliedTypeTreeTag_$eq(ClassTag<Trees.AppliedTypeTree> x$1) {
        this.AppliedTypeTreeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$ApplyTag_$eq(ClassTag<Trees.Apply> x$1) {
        this.ApplyTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$AssignOrNamedArgTag_$eq(ClassTag<Trees.AssignOrNamedArg> x$1) {
        this.AssignOrNamedArgTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$AssignTag_$eq(ClassTag<Trees.Assign> x$1) {
        this.AssignTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$BindTag_$eq(ClassTag<Trees.Bind> x$1) {
        this.BindTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$BlockTag_$eq(ClassTag<Trees.Block> x$1) {
        this.BlockTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$CaseDefTag_$eq(ClassTag<Trees.CaseDef> x$1) {
        this.CaseDefTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$ClassDefTag_$eq(ClassTag<Trees.ClassDef> x$1) {
        this.ClassDefTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$CompoundTypeTreeTag_$eq(ClassTag<Trees.CompoundTypeTree> x$1) {
        this.CompoundTypeTreeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$DefDefTag_$eq(ClassTag<Trees.DefDef> x$1) {
        this.DefDefTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$DefTreeTag_$eq(ClassTag<Trees.DefTree> x$1) {
        this.DefTreeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$ExistentialTypeTreeTag_$eq(ClassTag<Trees.ExistentialTypeTree> x$1) {
        this.ExistentialTypeTreeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$FunctionTag_$eq(ClassTag<Trees.Function> x$1) {
        this.FunctionTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$GenericApplyTag_$eq(ClassTag<Trees.GenericApply> x$1) {
        this.GenericApplyTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$IdentTag_$eq(ClassTag<Trees.Ident> x$1) {
        this.IdentTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$IfTag_$eq(ClassTag<Trees.If> x$1) {
        this.IfTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$ImplDefTag_$eq(ClassTag<Trees.ImplDef> x$1) {
        this.ImplDefTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$ImportSelectorTag_$eq(ClassTag<Trees.ImportSelector> x$1) {
        this.ImportSelectorTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$ImportTag_$eq(ClassTag<Trees.Import> x$1) {
        this.ImportTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$LabelDefTag_$eq(ClassTag<Trees.LabelDef> x$1) {
        this.LabelDefTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$LiteralTag_$eq(ClassTag<Trees.Literal> x$1) {
        this.LiteralTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$MatchTag_$eq(ClassTag<Trees.Match> x$1) {
        this.MatchTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$MemberDefTag_$eq(ClassTag<Trees.MemberDef> x$1) {
        this.MemberDefTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$ModuleDefTag_$eq(ClassTag<Trees.ModuleDef> x$1) {
        this.ModuleDefTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$NameTreeTag_$eq(ClassTag<Trees.NameTree> x$1) {
        this.NameTreeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$NewTag_$eq(ClassTag<Trees.New> x$1) {
        this.NewTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$PackageDefTag_$eq(ClassTag<Trees.PackageDef> x$1) {
        this.PackageDefTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$ReferenceToBoxedTag_$eq(ClassTag<Trees.ReferenceToBoxed> x$1) {
        this.ReferenceToBoxedTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$RefTreeTag_$eq(ClassTag<Trees.RefTree> x$1) {
        this.RefTreeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$ReturnTag_$eq(ClassTag<Trees.Return> x$1) {
        this.ReturnTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$SelectFromTypeTreeTag_$eq(ClassTag<Trees.SelectFromTypeTree> x$1) {
        this.SelectFromTypeTreeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$SelectTag_$eq(ClassTag<Trees.Select> x$1) {
        this.SelectTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$SingletonTypeTreeTag_$eq(ClassTag<Trees.SingletonTypeTree> x$1) {
        this.SingletonTypeTreeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$StarTag_$eq(ClassTag<Trees.Star> x$1) {
        this.StarTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$SuperTag_$eq(ClassTag<Trees.Super> x$1) {
        this.SuperTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$SymTreeTag_$eq(ClassTag<Trees.SymTree> x$1) {
        this.SymTreeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$TemplateTag_$eq(ClassTag<Trees.Template> x$1) {
        this.TemplateTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$TermTreeTag_$eq(ClassTag<Trees.TermTree> x$1) {
        this.TermTreeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$ThisTag_$eq(ClassTag<Trees.This> x$1) {
        this.ThisTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$ThrowTag_$eq(ClassTag<Trees.Throw> x$1) {
        this.ThrowTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$TreeTag_$eq(ClassTag<Trees.Tree> x$1) {
        this.TreeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$TryTag_$eq(ClassTag<Trees.Try> x$1) {
        this.TryTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$TypTreeTag_$eq(ClassTag<Trees.TypTree> x$1) {
        this.TypTreeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$TypeApplyTag_$eq(ClassTag<Trees.TypeApply> x$1) {
        this.TypeApplyTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$TypeBoundsTreeTag_$eq(ClassTag<Trees.TypeBoundsTree> x$1) {
        this.TypeBoundsTreeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$TypeDefTag_$eq(ClassTag<Trees.TypeDef> x$1) {
        this.TypeDefTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$TypeTreeTag_$eq(ClassTag<Trees.TypeTree> x$1) {
        this.TypeTreeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$TypedTag_$eq(ClassTag<Trees.Typed> x$1) {
        this.TypedTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$UnApplyTag_$eq(ClassTag<Trees.UnApply> x$1) {
        this.UnApplyTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$ValDefTag_$eq(ClassTag<Trees.ValDef> x$1) {
        this.ValDefTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Trees$_setter_$ValOrDefDefTag_$eq(ClassTag<Trees.ValOrDefDef> x$1) {
        this.ValOrDefDefTag = x$1;
    }

    @Override
    public List<AnnotationCheckers.AnnotationChecker> scala$reflect$internal$AnnotationCheckers$$annotationCheckers() {
        return this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers;
    }

    @Override
    public void scala$reflect$internal$AnnotationCheckers$$annotationCheckers_$eq(List<AnnotationCheckers.AnnotationChecker> x$1) {
        this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers = x$1;
    }

    @Override
    public ClassTag<AnnotationInfos.ClassfileAnnotArg> JavaArgumentTag() {
        return this.JavaArgumentTag;
    }

    @Override
    public AnnotationInfos$UnmappableAnnotArg$ UnmappableAnnotArg() {
        if (this.UnmappableAnnotArg$module == null) {
            this.UnmappableAnnotArg$lzycompute$1();
        }
        return this.UnmappableAnnotArg$module;
    }

    @Override
    public AnnotationInfos$LiteralAnnotArg$ LiteralAnnotArg() {
        if (this.LiteralAnnotArg$module == null) {
            this.LiteralAnnotArg$lzycompute$1();
        }
        return this.LiteralAnnotArg$module;
    }

    @Override
    public AnnotationInfos$ArrayAnnotArg$ ArrayAnnotArg() {
        if (this.ArrayAnnotArg$module == null) {
            this.ArrayAnnotArg$lzycompute$1();
        }
        return this.ArrayAnnotArg$module;
    }

    @Override
    public AnnotationInfos$NestedAnnotArg$ NestedAnnotArg() {
        if (this.NestedAnnotArg$module == null) {
            this.NestedAnnotArg$lzycompute$1();
        }
        return this.NestedAnnotArg$module;
    }

    @Override
    public AnnotationInfos$LiteralAnnotArg$ LiteralArgument() {
        return this.LiteralArgument;
    }

    @Override
    public ClassTag<AnnotationInfos.LiteralAnnotArg> LiteralArgumentTag() {
        return this.LiteralArgumentTag;
    }

    @Override
    public AnnotationInfos$ArrayAnnotArg$ ArrayArgument() {
        return this.ArrayArgument;
    }

    @Override
    public ClassTag<AnnotationInfos.ArrayAnnotArg> ArrayArgumentTag() {
        return this.ArrayArgumentTag;
    }

    @Override
    public AnnotationInfos$NestedAnnotArg$ NestedArgument() {
        return this.NestedArgument;
    }

    @Override
    public ClassTag<AnnotationInfos.NestedAnnotArg> NestedArgumentTag() {
        return this.NestedArgumentTag;
    }

    @Override
    public AnnotationInfos$ScalaSigBytes$ ScalaSigBytes() {
        if (this.ScalaSigBytes$module == null) {
            this.ScalaSigBytes$lzycompute$1();
        }
        return this.ScalaSigBytes$module;
    }

    @Override
    public AnnotationInfos$AnnotationInfo$ AnnotationInfo() {
        if (this.AnnotationInfo$module == null) {
            this.AnnotationInfo$lzycompute$1();
        }
        return this.AnnotationInfo$module;
    }

    @Override
    public AnnotationInfos$Annotation$ Annotation() {
        if (this.Annotation$module == null) {
            this.Annotation$lzycompute$1();
        }
        return this.Annotation$module;
    }

    @Override
    public ClassTag<AnnotationInfos.AnnotationInfo> AnnotationTag() {
        return this.AnnotationTag;
    }

    @Override
    public AnnotationInfos$UnmappableAnnotation$ UnmappableAnnotation() {
        if (this.UnmappableAnnotation$module == null) {
            this.UnmappableAnnotation$lzycompute$1();
        }
        return this.UnmappableAnnotation$module;
    }

    @Override
    public AnnotationInfos$ThrownException$ ThrownException() {
        if (this.ThrownException$module == null) {
            this.ThrownException$lzycompute$1();
        }
        return this.ThrownException$module;
    }

    @Override
    public void scala$reflect$internal$AnnotationInfos$_setter_$JavaArgumentTag_$eq(ClassTag<AnnotationInfos.ClassfileAnnotArg> x$1) {
        this.JavaArgumentTag = x$1;
    }

    @Override
    public void scala$reflect$internal$AnnotationInfos$_setter_$LiteralArgument_$eq(AnnotationInfos$LiteralAnnotArg$ x$1) {
        this.LiteralArgument = x$1;
    }

    @Override
    public void scala$reflect$internal$AnnotationInfos$_setter_$LiteralArgumentTag_$eq(ClassTag<AnnotationInfos.LiteralAnnotArg> x$1) {
        this.LiteralArgumentTag = x$1;
    }

    @Override
    public void scala$reflect$internal$AnnotationInfos$_setter_$ArrayArgument_$eq(AnnotationInfos$ArrayAnnotArg$ x$1) {
        this.ArrayArgument = x$1;
    }

    @Override
    public void scala$reflect$internal$AnnotationInfos$_setter_$ArrayArgumentTag_$eq(ClassTag<AnnotationInfos.ArrayAnnotArg> x$1) {
        this.ArrayArgumentTag = x$1;
    }

    @Override
    public void scala$reflect$internal$AnnotationInfos$_setter_$NestedArgument_$eq(AnnotationInfos$NestedAnnotArg$ x$1) {
        this.NestedArgument = x$1;
    }

    @Override
    public void scala$reflect$internal$AnnotationInfos$_setter_$NestedArgumentTag_$eq(ClassTag<AnnotationInfos.NestedAnnotArg> x$1) {
        this.NestedArgumentTag = x$1;
    }

    @Override
    public void scala$reflect$internal$AnnotationInfos$_setter_$AnnotationTag_$eq(ClassTag<AnnotationInfos.AnnotationInfo> x$1) {
        this.AnnotationTag = x$1;
    }

    @Override
    public StdNames$compactify$ scala$reflect$internal$StdNames$$compactify() {
        if (this.compactify$module == null) {
            this.scala$reflect$internal$StdNames$$compactify$lzycompute$1();
        }
        return this.compactify$module;
    }

    private StdNames$tpnme$ typeNames$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x80) == 0) {
                this.typeNames = StdNames.typeNames$(this);
                this.bitmap$0 |= 0x80;
            }
        }
        return this.typeNames;
    }

    @Override
    public StdNames$tpnme$ typeNames() {
        if ((this.bitmap$0 & 0x80) == 0) {
            return this.typeNames$lzycompute();
        }
        return this.typeNames;
    }

    @Override
    public StdNames$tpnme$ tpnme() {
        if (this.tpnme$module == null) {
            this.tpnme$lzycompute$1();
        }
        return this.tpnme$module;
    }

    @Override
    public StdNames$fulltpnme$ fulltpnme() {
        if (this.fulltpnme$module == null) {
            this.fulltpnme$lzycompute$1();
        }
        return this.fulltpnme$module;
    }

    @Override
    public StdNames$binarynme$ binarynme() {
        if (this.binarynme$module == null) {
            this.binarynme$lzycompute$1();
        }
        return this.binarynme$module;
    }

    @Override
    public StdNames.JavaKeywords javanme() {
        return this.javanme;
    }

    private StdNames$nme$ termNames$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x100) == 0) {
                this.termNames = StdNames.termNames$(this);
                this.bitmap$0 |= 0x100;
            }
        }
        return this.termNames;
    }

    @Override
    public StdNames$nme$ termNames() {
        if ((this.bitmap$0 & 0x100) == 0) {
            return this.termNames$lzycompute();
        }
        return this.termNames;
    }

    @Override
    public StdNames$nme$ nme() {
        if (this.nme$module == null) {
            this.nme$lzycompute$1();
        }
        return this.nme$module;
    }

    private StdNames.SymbolNames sn$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x200) == 0) {
                this.sn = StdNames.sn$(this);
                this.bitmap$0 |= 0x200;
            }
        }
        return this.sn;
    }

    @Override
    public StdNames.SymbolNames sn() {
        if ((this.bitmap$0 & 0x200) == 0) {
            return this.sn$lzycompute();
        }
        return this.sn;
    }

    @Override
    public void scala$reflect$internal$StdNames$_setter_$javanme_$eq(StdNames.JavaKeywords x$1) {
        this.javanme = x$1;
    }

    @Override
    public Transforms.Lazy<UnCurry> scala$reflect$internal$transform$Transforms$$uncurryLazy() {
        return this.scala$reflect$internal$transform$Transforms$$uncurryLazy;
    }

    @Override
    public Transforms.Lazy<Erasure> scala$reflect$internal$transform$Transforms$$erasureLazy() {
        return this.scala$reflect$internal$transform$Transforms$$erasureLazy;
    }

    @Override
    public Transforms.Lazy<PostErasure> scala$reflect$internal$transform$Transforms$$postErasureLazy() {
        return this.scala$reflect$internal$transform$Transforms$$postErasureLazy;
    }

    @Override
    public final void scala$reflect$internal$transform$Transforms$_setter_$scala$reflect$internal$transform$Transforms$$uncurryLazy_$eq(Transforms.Lazy<UnCurry> x$1) {
        this.scala$reflect$internal$transform$Transforms$$uncurryLazy = x$1;
    }

    @Override
    public final void scala$reflect$internal$transform$Transforms$_setter_$scala$reflect$internal$transform$Transforms$$erasureLazy_$eq(Transforms.Lazy<Erasure> x$1) {
        this.scala$reflect$internal$transform$Transforms$$erasureLazy = x$1;
    }

    @Override
    public final void scala$reflect$internal$transform$Transforms$_setter_$scala$reflect$internal$transform$Transforms$$postErasureLazy_$eq(Transforms.Lazy<PostErasure> x$1) {
        this.scala$reflect$internal$transform$Transforms$$postErasureLazy = x$1;
    }

    private BaseTypeSeqs.BaseTypeSeq undetBaseTypeSeq$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x400) == 0) {
                this.undetBaseTypeSeq = BaseTypeSeqs.undetBaseTypeSeq$(this);
                this.bitmap$0 |= 0x400;
            }
        }
        return this.undetBaseTypeSeq;
    }

    @Override
    public BaseTypeSeqs.BaseTypeSeq undetBaseTypeSeq() {
        if ((this.bitmap$0 & 0x400) == 0) {
            return this.undetBaseTypeSeq$lzycompute();
        }
        return this.undetBaseTypeSeq;
    }

    @Override
    public Throwable CyclicInheritance() {
        return this.CyclicInheritance;
    }

    @Override
    public void scala$reflect$internal$BaseTypeSeqs$_setter_$CyclicInheritance_$eq(Throwable x$1) {
        this.CyclicInheritance = x$1;
    }

    @Override
    public Constants$Constant$ Constant() {
        if (this.Constant$module == null) {
            this.Constant$lzycompute$1();
        }
        return this.Constant$module;
    }

    @Override
    public ClassTag<Constants.Constant> ConstantTag() {
        return this.ConstantTag;
    }

    @Override
    public void scala$reflect$internal$Constants$_setter_$ConstantTag_$eq(ClassTag<Constants.Constant> x$1) {
        this.ConstantTag = x$1;
    }

    @Override
    public Definitions$definitions$ definitions() {
        if (this.definitions$module == null) {
            this.definitions$lzycompute$1();
        }
        return this.definitions$module;
    }

    @Override
    public int scopeCount() {
        return this.scopeCount;
    }

    @Override
    public void scopeCount_$eq(int x$1) {
        this.scopeCount = x$1;
    }

    @Override
    public Scopes$LookupSucceeded$ LookupSucceeded() {
        if (this.LookupSucceeded$module == null) {
            this.LookupSucceeded$lzycompute$1();
        }
        return this.LookupSucceeded$module;
    }

    @Override
    public Scopes$LookupAmbiguous$ LookupAmbiguous() {
        if (this.LookupAmbiguous$module == null) {
            this.LookupAmbiguous$lzycompute$1();
        }
        return this.LookupAmbiguous$module;
    }

    @Override
    public Scopes$LookupInaccessible$ LookupInaccessible() {
        if (this.LookupInaccessible$module == null) {
            this.LookupInaccessible$lzycompute$1();
        }
        return this.LookupInaccessible$module;
    }

    @Override
    public Scopes$LookupNotFound$ LookupNotFound() {
        if (this.LookupNotFound$module == null) {
            this.LookupNotFound$lzycompute$1();
        }
        return this.LookupNotFound$module;
    }

    @Override
    public Scopes$Scope$ Scope() {
        if (this.Scope$module == null) {
            this.Scope$lzycompute$1();
        }
        return this.Scope$module;
    }

    @Override
    public ClassTag<Scopes.Scope> ScopeTag() {
        return this.ScopeTag;
    }

    @Override
    public ClassTag<Scopes.Scope> MemberScopeTag() {
        return this.MemberScopeTag;
    }

    @Override
    public Scopes$EmptyScope$ EmptyScope() {
        if (this.EmptyScope$module == null) {
            this.EmptyScope$lzycompute$1();
        }
        return this.EmptyScope$module;
    }

    @Override
    public void scala$reflect$internal$Scopes$_setter_$ScopeTag_$eq(ClassTag<Scopes.Scope> x$1) {
        this.ScopeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Scopes$_setter_$MemberScopeTag_$eq(ClassTag<Scopes.Scope> x$1) {
        this.MemberScopeTag = x$1;
    }

    @Override
    public ClassTag<Object> FlagSetTag() {
        return this.FlagSetTag;
    }

    @Override
    public long NoFlags() {
        return this.NoFlags;
    }

    @Override
    public FlagSets$Flag$ Flag() {
        if (this.Flag$module == null) {
            this.Flag$lzycompute$1();
        }
        return this.Flag$module;
    }

    @Override
    public void scala$reflect$internal$FlagSets$_setter_$FlagSetTag_$eq(ClassTag<Object> x$1) {
        this.FlagSetTag = x$1;
    }

    @Override
    public void scala$reflect$internal$FlagSets$_setter_$NoFlags_$eq(long x$1) {
        this.NoFlags = x$1;
    }

    @Override
    public Kinds$KindErrors$ KindErrors() {
        if (this.KindErrors$module == null) {
            this.KindErrors$lzycompute$1();
        }
        return this.KindErrors$module;
    }

    @Override
    public Kinds.KindErrors NoKindErrors() {
        return this.NoKindErrors;
    }

    @Override
    public Kinds$Kind$ Kind() {
        if (this.Kind$module == null) {
            this.Kind$lzycompute$1();
        }
        return this.Kind$module;
    }

    @Override
    public Kinds$ProperTypeKind$ ProperTypeKind() {
        if (this.ProperTypeKind$module == null) {
            this.ProperTypeKind$lzycompute$1();
        }
        return this.ProperTypeKind$module;
    }

    @Override
    public Kinds$TypeConKind$ TypeConKind() {
        if (this.TypeConKind$module == null) {
            this.TypeConKind$lzycompute$1();
        }
        return this.TypeConKind$module;
    }

    @Override
    public Kinds$inferKind$ inferKind() {
        if (this.inferKind$module == null) {
            this.inferKind$lzycompute$1();
        }
        return this.inferKind$module;
    }

    @Override
    public void scala$reflect$internal$Kinds$_setter_$NoKindErrors_$eq(Kinds.KindErrors x$1) {
        this.NoKindErrors = x$1;
    }

    @Override
    public ReusableInstance<Variances.varianceInType> scala$reflect$internal$Variances$$varianceInTypeCache() {
        return this.scala$reflect$internal$Variances$$varianceInTypeCache;
    }

    @Override
    public final void scala$reflect$internal$Variances$_setter_$scala$reflect$internal$Variances$$varianceInTypeCache_$eq(ReusableInstance<Variances.varianceInType> x$1) {
        this.scala$reflect$internal$Variances$$varianceInTypeCache = x$1;
    }

    @Override
    public boolean scala$reflect$internal$Types$$explainSwitch() {
        return this.scala$reflect$internal$Types$$explainSwitch;
    }

    @Override
    public void scala$reflect$internal$Types$$explainSwitch_$eq(boolean x$1) {
        this.scala$reflect$internal$Types$$explainSwitch = x$1;
    }

    @Override
    public final Set<Symbols.Symbol> scala$reflect$internal$Types$$emptySymbolSet() {
        return this.scala$reflect$internal$Types$$emptySymbolSet;
    }

    @Override
    public final boolean scala$reflect$internal$Types$$propagateParameterBoundsToTypeVars() {
        return this.scala$reflect$internal$Types$$propagateParameterBoundsToTypeVars;
    }

    @Override
    public final boolean scala$reflect$internal$Types$$sharperSkolems() {
        return this.scala$reflect$internal$Types$$sharperSkolems;
    }

    @Override
    public Types$substTypeMapCache$ scala$reflect$internal$Types$$substTypeMapCache() {
        if (this.substTypeMapCache$module == null) {
            this.scala$reflect$internal$Types$$substTypeMapCache$lzycompute$1();
        }
        return this.substTypeMapCache$module;
    }

    @Override
    public int scala$reflect$internal$Types$$_skolemizationLevel() {
        return this.scala$reflect$internal$Types$$_skolemizationLevel;
    }

    @Override
    public void scala$reflect$internal$Types$$_skolemizationLevel_$eq(int x$1) {
        this.scala$reflect$internal$Types$$_skolemizationLevel = x$1;
    }

    @Override
    public WeakHashMap<List<Types.Type>, WeakReference<Types.Type>> scala$reflect$internal$Types$$_intersectionWitness() {
        return this.scala$reflect$internal$Types$$_intersectionWitness;
    }

    @Override
    public Types$UnmappableTree$ UnmappableTree() {
        if (this.UnmappableTree$module == null) {
            this.UnmappableTree$lzycompute$1();
        }
        return this.UnmappableTree$module;
    }

    @Override
    public Types$ErrorType$ ErrorType() {
        if (this.ErrorType$module == null) {
            this.ErrorType$lzycompute$1();
        }
        return this.ErrorType$module;
    }

    @Override
    public Types$WildcardType$ WildcardType() {
        if (this.WildcardType$module == null) {
            this.WildcardType$lzycompute$1();
        }
        return this.WildcardType$module;
    }

    @Override
    public Types$BoundedWildcardType$ BoundedWildcardType() {
        if (this.BoundedWildcardType$module == null) {
            this.BoundedWildcardType$lzycompute$1();
        }
        return this.BoundedWildcardType$module;
    }

    @Override
    public Types$NoType$ NoType() {
        if (this.NoType$module == null) {
            this.NoType$lzycompute$1();
        }
        return this.NoType$module;
    }

    @Override
    public Types$NoPrefix$ NoPrefix() {
        if (this.NoPrefix$module == null) {
            this.NoPrefix$lzycompute$1();
        }
        return this.NoPrefix$module;
    }

    @Override
    public Types$ThisType$ ThisType() {
        if (this.ThisType$module == null) {
            this.ThisType$lzycompute$1();
        }
        return this.ThisType$module;
    }

    @Override
    public Types$SingleType$ SingleType() {
        if (this.SingleType$module == null) {
            this.SingleType$lzycompute$1();
        }
        return this.SingleType$module;
    }

    @Override
    public Types$SuperType$ SuperType() {
        if (this.SuperType$module == null) {
            this.SuperType$lzycompute$1();
        }
        return this.SuperType$module;
    }

    @Override
    public Types$TypeBounds$ TypeBounds() {
        if (this.TypeBounds$module == null) {
            this.TypeBounds$lzycompute$1();
        }
        return this.TypeBounds$module;
    }

    @Override
    public Types$CompoundType$ CompoundType() {
        if (this.CompoundType$module == null) {
            this.CompoundType$lzycompute$1();
        }
        return this.CompoundType$module;
    }

    @Override
    public Types$RefinedType$ RefinedType() {
        if (this.RefinedType$module == null) {
            this.RefinedType$lzycompute$1();
        }
        return this.RefinedType$module;
    }

    @Override
    public Types$ClassInfoType$ ClassInfoType() {
        if (this.ClassInfoType$module == null) {
            this.ClassInfoType$lzycompute$1();
        }
        return this.ClassInfoType$module;
    }

    @Override
    public Types$ConstantType$ ConstantType() {
        if (this.ConstantType$module == null) {
            this.ConstantType$lzycompute$1();
        }
        return this.ConstantType$module;
    }

    @Override
    public Types$TypeRef$ TypeRef() {
        if (this.TypeRef$module == null) {
            this.TypeRef$lzycompute$1();
        }
        return this.TypeRef$module;
    }

    @Override
    public Types$MethodType$ MethodType() {
        if (this.MethodType$module == null) {
            this.MethodType$lzycompute$1();
        }
        return this.MethodType$module;
    }

    @Override
    public Types$NullaryMethodType$ NullaryMethodType() {
        if (this.NullaryMethodType$module == null) {
            this.NullaryMethodType$lzycompute$1();
        }
        return this.NullaryMethodType$module;
    }

    @Override
    public Types$PolyType$ PolyType() {
        if (this.PolyType$module == null) {
            this.PolyType$lzycompute$1();
        }
        return this.PolyType$module;
    }

    @Override
    public Types$ExistentialType$ ExistentialType() {
        if (this.ExistentialType$module == null) {
            this.ExistentialType$lzycompute$1();
        }
        return this.ExistentialType$module;
    }

    @Override
    public Types$OverloadedType$ OverloadedType() {
        if (this.OverloadedType$module == null) {
            this.OverloadedType$lzycompute$1();
        }
        return this.OverloadedType$module;
    }

    @Override
    public Types$ImportType$ ImportType() {
        if (this.ImportType$module == null) {
            this.ImportType$lzycompute$1();
        }
        return this.ImportType$module;
    }

    @Override
    public Types$AntiPolyType$ AntiPolyType() {
        if (this.AntiPolyType$module == null) {
            this.AntiPolyType$lzycompute$1();
        }
        return this.AntiPolyType$module;
    }

    @Override
    public Types$HasTypeMember$ HasTypeMember() {
        if (this.HasTypeMember$module == null) {
            this.HasTypeMember$lzycompute$1();
        }
        return this.HasTypeMember$module;
    }

    @Override
    public Types$ArrayTypeRef$ ArrayTypeRef() {
        if (this.ArrayTypeRef$module == null) {
            this.ArrayTypeRef$lzycompute$1();
        }
        return this.ArrayTypeRef$module;
    }

    @Override
    public Types$TypeVar$ TypeVar() {
        if (this.TypeVar$module == null) {
            this.TypeVar$lzycompute$1();
        }
        return this.TypeVar$module;
    }

    @Override
    public Types$AnnotatedType$ AnnotatedType() {
        if (this.AnnotatedType$module == null) {
            this.AnnotatedType$lzycompute$1();
        }
        return this.AnnotatedType$module;
    }

    @Override
    public Types$StaticallyAnnotatedType$ StaticallyAnnotatedType() {
        if (this.StaticallyAnnotatedType$module == null) {
            this.StaticallyAnnotatedType$lzycompute$1();
        }
        return this.StaticallyAnnotatedType$module;
    }

    @Override
    public Types$NamedType$ NamedType() {
        if (this.NamedType$module == null) {
            this.NamedType$lzycompute$1();
        }
        return this.NamedType$module;
    }

    @Override
    public Types$RepeatedType$ RepeatedType() {
        if (this.RepeatedType$module == null) {
            this.RepeatedType$lzycompute$1();
        }
        return this.RepeatedType$module;
    }

    @Override
    public Types$ErasedValueType$ ErasedValueType() {
        if (this.ErasedValueType$module == null) {
            this.ErasedValueType$lzycompute$1();
        }
        return this.ErasedValueType$module;
    }

    @Override
    public Types$GenPolyType$ GenPolyType() {
        if (this.GenPolyType$module == null) {
            this.GenPolyType$lzycompute$1();
        }
        return this.GenPolyType$module;
    }

    @Override
    public int scala$reflect$internal$Types$$initialUniquesCapacity() {
        return this.scala$reflect$internal$Types$$initialUniquesCapacity;
    }

    @Override
    public WeakHashSet<Types.Type> scala$reflect$internal$Types$$uniques() {
        return this.scala$reflect$internal$Types$$uniques;
    }

    @Override
    public void scala$reflect$internal$Types$$uniques_$eq(WeakHashSet<Types.Type> x$1) {
        this.scala$reflect$internal$Types$$uniques = x$1;
    }

    @Override
    public int scala$reflect$internal$Types$$uniqueRunId() {
        return this.scala$reflect$internal$Types$$uniqueRunId;
    }

    @Override
    public void scala$reflect$internal$Types$$uniqueRunId_$eq(int x$1) {
        this.scala$reflect$internal$Types$$uniqueRunId = x$1;
    }

    @Override
    public Types$unwrapToClass$ unwrapToClass() {
        if (this.unwrapToClass$module == null) {
            this.unwrapToClass$lzycompute$1();
        }
        return this.unwrapToClass$module;
    }

    @Override
    public Types$unwrapToStableClass$ unwrapToStableClass() {
        if (this.unwrapToStableClass$module == null) {
            this.unwrapToStableClass$lzycompute$1();
        }
        return this.unwrapToStableClass$module;
    }

    @Override
    public Types$unwrapWrapperTypes$ unwrapWrapperTypes() {
        if (this.unwrapWrapperTypes$module == null) {
            this.unwrapWrapperTypes$lzycompute$1();
        }
        return this.unwrapWrapperTypes$module;
    }

    @Override
    public Types.MissingAliasControl missingAliasException() {
        return this.missingAliasException;
    }

    @Override
    public int scala$reflect$internal$Types$$_basetypeRecursions() {
        return this.scala$reflect$internal$Types$$_basetypeRecursions;
    }

    @Override
    public void scala$reflect$internal$Types$$_basetypeRecursions_$eq(int x$1) {
        this.scala$reflect$internal$Types$$_basetypeRecursions = x$1;
    }

    @Override
    public HashSet<Types.Type> scala$reflect$internal$Types$$_pendingBaseTypes() {
        return this.scala$reflect$internal$Types$$_pendingBaseTypes;
    }

    @Override
    public Types$RecoverableCyclicReference$ RecoverableCyclicReference() {
        if (this.RecoverableCyclicReference$module == null) {
            this.RecoverableCyclicReference$lzycompute$1();
        }
        return this.RecoverableCyclicReference$module;
    }

    @Override
    public String scala$reflect$internal$Types$$_indent() {
        return this.scala$reflect$internal$Types$$_indent;
    }

    @Override
    public void scala$reflect$internal$Types$$_indent_$eq(String x$1) {
        this.scala$reflect$internal$Types$$_indent = x$1;
    }

    @Override
    public Set<String> shorthands() {
        return this.shorthands;
    }

    @Override
    public Function1<Trees.Tree, Types.Type> treeTpe() {
        return this.treeTpe;
    }

    @Override
    public Function1<Types.Type, Object> typeContainsTypeVar() {
        return this.typeContainsTypeVar;
    }

    @Override
    public Function1<Types.Type, Object> typeIsSubTypeOfSerializable() {
        return this.typeIsSubTypeOfSerializable;
    }

    @Override
    public ClassTag<Types.AnnotatedType> AnnotatedTypeTag() {
        return this.AnnotatedTypeTag;
    }

    @Override
    public ClassTag<Types.BoundedWildcardType> BoundedWildcardTypeTag() {
        return this.BoundedWildcardTypeTag;
    }

    @Override
    public ClassTag<Types.ClassInfoType> ClassInfoTypeTag() {
        return this.ClassInfoTypeTag;
    }

    @Override
    public ClassTag<Types.CompoundType> CompoundTypeTag() {
        return this.CompoundTypeTag;
    }

    @Override
    public ClassTag<Types.ConstantType> ConstantTypeTag() {
        return this.ConstantTypeTag;
    }

    @Override
    public ClassTag<Types.ExistentialType> ExistentialTypeTag() {
        return this.ExistentialTypeTag;
    }

    @Override
    public ClassTag<Types.MethodType> MethodTypeTag() {
        return this.MethodTypeTag;
    }

    @Override
    public ClassTag<Types.NullaryMethodType> NullaryMethodTypeTag() {
        return this.NullaryMethodTypeTag;
    }

    @Override
    public ClassTag<Types.PolyType> PolyTypeTag() {
        return this.PolyTypeTag;
    }

    @Override
    public ClassTag<Types.RefinedType> RefinedTypeTag() {
        return this.RefinedTypeTag;
    }

    @Override
    public ClassTag<Types.SingletonType> SingletonTypeTag() {
        return this.SingletonTypeTag;
    }

    @Override
    public ClassTag<Types.SingleType> SingleTypeTag() {
        return this.SingleTypeTag;
    }

    @Override
    public ClassTag<Types.SuperType> SuperTypeTag() {
        return this.SuperTypeTag;
    }

    @Override
    public ClassTag<Types.ThisType> ThisTypeTag() {
        return this.ThisTypeTag;
    }

    @Override
    public ClassTag<Types.TypeBounds> TypeBoundsTag() {
        return this.TypeBoundsTag;
    }

    @Override
    public ClassTag<Types.TypeRef> TypeRefTag() {
        return this.TypeRefTag;
    }

    @Override
    public ClassTag<Types.Type> TypeTagg() {
        return this.TypeTagg;
    }

    @Override
    public final void scala$reflect$internal$Types$_setter_$scala$reflect$internal$Types$$emptySymbolSet_$eq(Set<Symbols.Symbol> x$1) {
        this.scala$reflect$internal$Types$$emptySymbolSet = x$1;
    }

    @Override
    public final void scala$reflect$internal$Types$_setter_$scala$reflect$internal$Types$$propagateParameterBoundsToTypeVars_$eq(boolean x$1) {
        this.scala$reflect$internal$Types$$propagateParameterBoundsToTypeVars = x$1;
    }

    @Override
    public final void scala$reflect$internal$Types$_setter_$scala$reflect$internal$Types$$sharperSkolems_$eq(boolean x$1) {
        this.scala$reflect$internal$Types$$sharperSkolems = x$1;
    }

    @Override
    public final void scala$reflect$internal$Types$_setter_$scala$reflect$internal$Types$$_intersectionWitness_$eq(WeakHashMap<List<Types.Type>, WeakReference<Types.Type>> x$1) {
        this.scala$reflect$internal$Types$$_intersectionWitness = x$1;
    }

    @Override
    public final void scala$reflect$internal$Types$_setter_$scala$reflect$internal$Types$$initialUniquesCapacity_$eq(int x$1) {
        this.scala$reflect$internal$Types$$initialUniquesCapacity = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$missingAliasException_$eq(Types.MissingAliasControl x$1) {
        this.missingAliasException = x$1;
    }

    @Override
    public final void scala$reflect$internal$Types$_setter_$scala$reflect$internal$Types$$_pendingBaseTypes_$eq(HashSet<Types.Type> x$1) {
        this.scala$reflect$internal$Types$$_pendingBaseTypes = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$shorthands_$eq(Set<String> x$1) {
        this.shorthands = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$treeTpe_$eq(Function1<Trees.Tree, Types.Type> x$1) {
        this.treeTpe = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$typeContainsTypeVar_$eq(Function1<Types.Type, Object> x$1) {
        this.typeContainsTypeVar = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$typeIsSubTypeOfSerializable_$eq(Function1<Types.Type, Object> x$1) {
        this.typeIsSubTypeOfSerializable = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$AnnotatedTypeTag_$eq(ClassTag<Types.AnnotatedType> x$1) {
        this.AnnotatedTypeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$BoundedWildcardTypeTag_$eq(ClassTag<Types.BoundedWildcardType> x$1) {
        this.BoundedWildcardTypeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$ClassInfoTypeTag_$eq(ClassTag<Types.ClassInfoType> x$1) {
        this.ClassInfoTypeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$CompoundTypeTag_$eq(ClassTag<Types.CompoundType> x$1) {
        this.CompoundTypeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$ConstantTypeTag_$eq(ClassTag<Types.ConstantType> x$1) {
        this.ConstantTypeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$ExistentialTypeTag_$eq(ClassTag<Types.ExistentialType> x$1) {
        this.ExistentialTypeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$MethodTypeTag_$eq(ClassTag<Types.MethodType> x$1) {
        this.MethodTypeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$NullaryMethodTypeTag_$eq(ClassTag<Types.NullaryMethodType> x$1) {
        this.NullaryMethodTypeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$PolyTypeTag_$eq(ClassTag<Types.PolyType> x$1) {
        this.PolyTypeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$RefinedTypeTag_$eq(ClassTag<Types.RefinedType> x$1) {
        this.RefinedTypeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$SingletonTypeTag_$eq(ClassTag<Types.SingletonType> x$1) {
        this.SingletonTypeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$SingleTypeTag_$eq(ClassTag<Types.SingleType> x$1) {
        this.SingleTypeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$SuperTypeTag_$eq(ClassTag<Types.SuperType> x$1) {
        this.SuperTypeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$ThisTypeTag_$eq(ClassTag<Types.ThisType> x$1) {
        this.ThisTypeTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$TypeBoundsTag_$eq(ClassTag<Types.TypeBounds> x$1) {
        this.TypeBoundsTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$TypeRefTag_$eq(ClassTag<Types.TypeRef> x$1) {
        this.TypeRefTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Types$_setter_$TypeTagg_$eq(ClassTag<Types.Type> x$1) {
        this.TypeTagg = x$1;
    }

    @Override
    public ReusableInstance<FindMembers.FindMember> findMemberInstance() {
        return this.findMemberInstance;
    }

    @Override
    public void scala$reflect$internal$tpe$FindMembers$_setter_$findMemberInstance_$eq(ReusableInstance<FindMembers.FindMember> x$1) {
        this.findMemberInstance = x$1;
    }

    private TypeConstraints.UndoLog scala$reflect$internal$tpe$TypeConstraints$$_undoLog$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x800) == 0) {
                this.scala$reflect$internal$tpe$TypeConstraints$$_undoLog = TypeConstraints.scala$reflect$internal$tpe$TypeConstraints$$_undoLog$(this);
                this.bitmap$0 |= 0x800;
            }
        }
        return this.scala$reflect$internal$tpe$TypeConstraints$$_undoLog;
    }

    @Override
    public TypeConstraints.UndoLog scala$reflect$internal$tpe$TypeConstraints$$_undoLog() {
        if ((this.bitmap$0 & 0x800) == 0) {
            return this.scala$reflect$internal$tpe$TypeConstraints$$_undoLog$lzycompute();
        }
        return this.scala$reflect$internal$tpe$TypeConstraints$$_undoLog;
    }

    private Types.Type scala$reflect$internal$tpe$TypeConstraints$$numericLoBound$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x1000) == 0) {
                this.scala$reflect$internal$tpe$TypeConstraints$$numericLoBound = TypeConstraints.scala$reflect$internal$tpe$TypeConstraints$$numericLoBound$(this);
                this.bitmap$0 |= 0x1000;
            }
        }
        return this.scala$reflect$internal$tpe$TypeConstraints$$numericLoBound;
    }

    @Override
    public Types.Type scala$reflect$internal$tpe$TypeConstraints$$numericLoBound() {
        if ((this.bitmap$0 & 0x1000) == 0) {
            return this.scala$reflect$internal$tpe$TypeConstraints$$numericLoBound$lzycompute();
        }
        return this.scala$reflect$internal$tpe$TypeConstraints$$numericLoBound;
    }

    private Types.Type scala$reflect$internal$tpe$TypeConstraints$$numericHiBound$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x2000) == 0) {
                this.scala$reflect$internal$tpe$TypeConstraints$$numericHiBound = TypeConstraints.scala$reflect$internal$tpe$TypeConstraints$$numericHiBound$(this);
                this.bitmap$0 |= 0x2000;
            }
        }
        return this.scala$reflect$internal$tpe$TypeConstraints$$numericHiBound;
    }

    @Override
    public Types.Type scala$reflect$internal$tpe$TypeConstraints$$numericHiBound() {
        if ((this.bitmap$0 & 0x2000) == 0) {
            return this.scala$reflect$internal$tpe$TypeConstraints$$numericHiBound$lzycompute();
        }
        return this.scala$reflect$internal$tpe$TypeConstraints$$numericHiBound;
    }

    @Override
    public TypeConstraints$TypeConstraint$ TypeConstraint() {
        if (this.TypeConstraint$module == null) {
            this.TypeConstraint$lzycompute$1();
        }
        return this.TypeConstraint$module;
    }

    @Override
    public TypeMaps$normalizeAliases$ normalizeAliases() {
        if (this.normalizeAliases$module == null) {
            this.normalizeAliases$lzycompute$1();
        }
        return this.normalizeAliases$module;
    }

    @Override
    public TypeMaps$dropSingletonType$ dropSingletonType() {
        if (this.dropSingletonType$module == null) {
            this.dropSingletonType$lzycompute$1();
        }
        return this.dropSingletonType$module;
    }

    @Override
    public TypeMaps$abstractTypesToBounds$ abstractTypesToBounds() {
        if (this.abstractTypesToBounds$module == null) {
            this.abstractTypesToBounds$lzycompute$1();
        }
        return this.abstractTypesToBounds$module;
    }

    @Override
    public TypeMaps$dropIllegalStarTypes$ dropIllegalStarTypes() {
        if (this.dropIllegalStarTypes$module == null) {
            this.dropIllegalStarTypes$lzycompute$1();
        }
        return this.dropIllegalStarTypes$module;
    }

    @Override
    public TypeMaps$wildcardExtrapolation$ wildcardExtrapolation() {
        if (this.wildcardExtrapolation$module == null) {
            this.wildcardExtrapolation$lzycompute$1();
        }
        return this.wildcardExtrapolation$module;
    }

    @Override
    public TypeMaps$IsDependentCollector$ IsDependentCollector() {
        if (this.IsDependentCollector$module == null) {
            this.IsDependentCollector$lzycompute$1();
        }
        return this.IsDependentCollector$module;
    }

    @Override
    public TypeMaps$ApproximateDependentMap$ ApproximateDependentMap() {
        if (this.ApproximateDependentMap$module == null) {
            this.ApproximateDependentMap$lzycompute$1();
        }
        return this.ApproximateDependentMap$module;
    }

    @Override
    public TypeMaps$wildcardToTypeVarMap$ wildcardToTypeVarMap() {
        if (this.wildcardToTypeVarMap$module == null) {
            this.wildcardToTypeVarMap$lzycompute$1();
        }
        return this.wildcardToTypeVarMap$module;
    }

    @Override
    public TypeMaps$typeVarToOriginMap$ typeVarToOriginMap() {
        if (this.typeVarToOriginMap$module == null) {
            this.typeVarToOriginMap$lzycompute$1();
        }
        return this.typeVarToOriginMap$module;
    }

    @Override
    public TypeMaps$ErroneousCollector$ ErroneousCollector() {
        if (this.ErroneousCollector$module == null) {
            this.ErroneousCollector$lzycompute$1();
        }
        return this.ErroneousCollector$module;
    }

    @Override
    public TypeMaps$adaptToNewRunMap$ adaptToNewRunMap() {
        if (this.adaptToNewRunMap$module == null) {
            this.adaptToNewRunMap$lzycompute$1();
        }
        return this.adaptToNewRunMap$module;
    }

    @Override
    public final boolean scala$reflect$internal$tpe$GlbLubs$$printLubs() {
        return this.scala$reflect$internal$tpe$GlbLubs$$printLubs;
    }

    @Override
    public final MutableSettings.SettingValue scala$reflect$internal$tpe$GlbLubs$$strictInference() {
        return this.scala$reflect$internal$tpe$GlbLubs$$strictInference;
    }

    @Override
    public HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type> scala$reflect$internal$tpe$GlbLubs$$_lubResults() {
        return this.scala$reflect$internal$tpe$GlbLubs$$_lubResults;
    }

    @Override
    public HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type> scala$reflect$internal$tpe$GlbLubs$$_glbResults() {
        return this.scala$reflect$internal$tpe$GlbLubs$$_glbResults;
    }

    @Override
    public Throwable GlbFailure() {
        return this.GlbFailure;
    }

    @Override
    public int scala$reflect$internal$tpe$GlbLubs$$globalGlbDepth() {
        return this.scala$reflect$internal$tpe$GlbLubs$$globalGlbDepth;
    }

    @Override
    public void scala$reflect$internal$tpe$GlbLubs$$globalGlbDepth_$eq(int x$1) {
        this.scala$reflect$internal$tpe$GlbLubs$$globalGlbDepth = x$1;
    }

    @Override
    public final int scala$reflect$internal$tpe$GlbLubs$$globalGlbLimit() {
        return this.scala$reflect$internal$tpe$GlbLubs$$globalGlbLimit;
    }

    @Override
    public final void scala$reflect$internal$tpe$GlbLubs$_setter_$scala$reflect$internal$tpe$GlbLubs$$printLubs_$eq(boolean x$1) {
        this.scala$reflect$internal$tpe$GlbLubs$$printLubs = x$1;
    }

    @Override
    public final void scala$reflect$internal$tpe$GlbLubs$_setter_$scala$reflect$internal$tpe$GlbLubs$$strictInference_$eq(MutableSettings.SettingValue x$1) {
        this.scala$reflect$internal$tpe$GlbLubs$$strictInference = x$1;
    }

    @Override
    public final void scala$reflect$internal$tpe$GlbLubs$_setter_$scala$reflect$internal$tpe$GlbLubs$$_lubResults_$eq(HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type> x$1) {
        this.scala$reflect$internal$tpe$GlbLubs$$_lubResults = x$1;
    }

    @Override
    public final void scala$reflect$internal$tpe$GlbLubs$_setter_$scala$reflect$internal$tpe$GlbLubs$$_glbResults_$eq(HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type> x$1) {
        this.scala$reflect$internal$tpe$GlbLubs$$_glbResults = x$1;
    }

    @Override
    public void scala$reflect$internal$tpe$GlbLubs$_setter_$GlbFailure_$eq(Throwable x$1) {
        this.GlbFailure = x$1;
    }

    @Override
    public final void scala$reflect$internal$tpe$GlbLubs$_setter_$scala$reflect$internal$tpe$GlbLubs$$globalGlbLimit_$eq(int x$1) {
        this.scala$reflect$internal$tpe$GlbLubs$$globalGlbLimit = x$1;
    }

    private CommonOwners.CommonOwnerMap scala$reflect$internal$tpe$CommonOwners$$commonOwnerMapObj$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x4000) == 0) {
                this.scala$reflect$internal$tpe$CommonOwners$$commonOwnerMapObj = CommonOwners.scala$reflect$internal$tpe$CommonOwners$$commonOwnerMapObj$(this);
                this.bitmap$0 |= 0x4000;
            }
        }
        return this.scala$reflect$internal$tpe$CommonOwners$$commonOwnerMapObj;
    }

    @Override
    public CommonOwners.CommonOwnerMap scala$reflect$internal$tpe$CommonOwners$$commonOwnerMapObj() {
        if ((this.bitmap$0 & 0x4000) == 0) {
            return this.scala$reflect$internal$tpe$CommonOwners$$commonOwnerMapObj$lzycompute();
        }
        return this.scala$reflect$internal$tpe$CommonOwners$$commonOwnerMapObj;
    }

    @Override
    public int scala$reflect$internal$tpe$TypeToStrings$$_toStringRecursions() {
        return this.scala$reflect$internal$tpe$TypeToStrings$$_toStringRecursions;
    }

    @Override
    public void scala$reflect$internal$tpe$TypeToStrings$$_toStringRecursions_$eq(int x$1) {
        this.scala$reflect$internal$tpe$TypeToStrings$$_toStringRecursions = x$1;
    }

    @Override
    public HashSet<Types.Type> scala$reflect$internal$tpe$TypeToStrings$$_toStringSubjects() {
        return this.scala$reflect$internal$tpe$TypeToStrings$$_toStringSubjects;
    }

    @Override
    public final void scala$reflect$internal$tpe$TypeToStrings$_setter_$scala$reflect$internal$tpe$TypeToStrings$$_toStringSubjects_$eq(HashSet<Types.Type> x$1) {
        this.scala$reflect$internal$tpe$TypeToStrings$$_toStringSubjects = x$1;
    }

    @Override
    public HashSet<TypeComparers.SubTypePair> scala$reflect$internal$tpe$TypeComparers$$_pendingSubTypes() {
        return this.scala$reflect$internal$tpe$TypeComparers$$_pendingSubTypes;
    }

    @Override
    public TypeComparers$SubTypePair$ SubTypePair() {
        if (this.SubTypePair$module == null) {
            this.SubTypePair$lzycompute$1();
        }
        return this.SubTypePair$module;
    }

    @Override
    public int scala$reflect$internal$tpe$TypeComparers$$_subsametypeRecursions() {
        return this.scala$reflect$internal$tpe$TypeComparers$$_subsametypeRecursions;
    }

    @Override
    public void scala$reflect$internal$tpe$TypeComparers$$_subsametypeRecursions_$eq(int x$1) {
        this.scala$reflect$internal$tpe$TypeComparers$$_subsametypeRecursions = x$1;
    }

    @Override
    public final void scala$reflect$internal$tpe$TypeComparers$_setter_$scala$reflect$internal$tpe$TypeComparers$$_pendingSubTypes_$eq(HashSet<TypeComparers.SubTypePair> x$1) {
        this.scala$reflect$internal$tpe$TypeComparers$$_pendingSubTypes = x$1;
    }

    @Override
    public int ids() {
        return this.ids;
    }

    @Override
    public void ids_$eq(int x$1) {
        this.ids = x$1;
    }

    @Override
    public Map<Symbols.Symbol, Object> scala$reflect$internal$Symbols$$_recursionTable() {
        return this.scala$reflect$internal$Symbols$$_recursionTable;
    }

    @Override
    public void scala$reflect$internal$Symbols$$_recursionTable_$eq(Map<Symbols.Symbol, Object> x$1) {
        this.scala$reflect$internal$Symbols$$_recursionTable = x$1;
    }

    @Override
    public int scala$reflect$internal$Symbols$$_lockedCount() {
        return this.scala$reflect$internal$Symbols$$_lockedCount;
    }

    @Override
    public void scala$reflect$internal$Symbols$$_lockedCount_$eq(int x$1) {
        this.scala$reflect$internal$Symbols$$_lockedCount = x$1;
    }

    @Override
    public int scala$reflect$internal$Symbols$$existentialIds() {
        return this.scala$reflect$internal$Symbols$$existentialIds;
    }

    @Override
    public void scala$reflect$internal$Symbols$$existentialIds_$eq(int x$1) {
        this.scala$reflect$internal$Symbols$$existentialIds = x$1;
    }

    @Override
    public AnyRefMap<Symbols.Symbol, Symbols.Symbol> scala$reflect$internal$Symbols$$originalOwnerMap() {
        return this.scala$reflect$internal$Symbols$$originalOwnerMap;
    }

    @Override
    public Symbols$SymbolKind$ SymbolKind() {
        if (this.SymbolKind$module == null) {
            this.SymbolKind$lzycompute$1();
        }
        return this.SymbolKind$module;
    }

    @Override
    public ClassTag<Symbols.Symbol> SymbolTag() {
        return this.SymbolTag;
    }

    @Override
    public ClassTag<Symbols.TermSymbol> TermSymbolTag() {
        return this.TermSymbolTag;
    }

    @Override
    public ClassTag<Symbols.ModuleSymbol> ModuleSymbolTag() {
        return this.ModuleSymbolTag;
    }

    @Override
    public ClassTag<Symbols.MethodSymbol> MethodSymbolTag() {
        return this.MethodSymbolTag;
    }

    @Override
    public ClassTag<Symbols.TypeSymbol> TypeSymbolTag() {
        return this.TypeSymbolTag;
    }

    @Override
    public ClassTag<Symbols.ClassSymbol> ClassSymbolTag() {
        return this.ClassSymbolTag;
    }

    @Override
    public ClassTag<Symbols.FreeTermSymbol> FreeTermSymbolTag() {
        return this.FreeTermSymbolTag;
    }

    @Override
    public ClassTag<Symbols.FreeTypeSymbol> FreeTypeSymbolTag() {
        return this.FreeTypeSymbolTag;
    }

    private Symbols.NoSymbol NoSymbol$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x8000) == 0) {
                this.NoSymbol = Symbols.NoSymbol$(this);
                this.bitmap$0 |= 0x8000;
            }
        }
        return this.NoSymbol;
    }

    @Override
    public Symbols.NoSymbol NoSymbol() {
        if ((this.bitmap$0 & 0x8000) == 0) {
            return this.NoSymbol$lzycompute();
        }
        return this.NoSymbol;
    }

    @Override
    public Symbols$CyclicReference$ CyclicReference() {
        if (this.CyclicReference$module == null) {
            this.CyclicReference$lzycompute$1();
        }
        return this.CyclicReference$module;
    }

    @Override
    public Symbols$TypeHistory$ scala$reflect$internal$Symbols$$TypeHistory() {
        if (this.TypeHistory$module == null) {
            this.scala$reflect$internal$Symbols$$TypeHistory$lzycompute$1();
        }
        return this.TypeHistory$module;
    }

    @Override
    public final Function1<Symbols.Symbol, Object> symbolIsPossibleInRefinement() {
        return this.symbolIsPossibleInRefinement;
    }

    @Override
    public Symbols$SymbolOps$ SymbolOps() {
        if (this.SymbolOps$module == null) {
            this.SymbolOps$lzycompute$1();
        }
        return this.SymbolOps$module;
    }

    @Override
    public Symbols.SymbolOps AllOps() {
        return this.AllOps;
    }

    @Override
    public final void scala$reflect$internal$Symbols$_setter_$scala$reflect$internal$Symbols$$originalOwnerMap_$eq(AnyRefMap<Symbols.Symbol, Symbols.Symbol> x$1) {
        this.scala$reflect$internal$Symbols$$originalOwnerMap = x$1;
    }

    @Override
    public void scala$reflect$internal$Symbols$_setter_$SymbolTag_$eq(ClassTag<Symbols.Symbol> x$1) {
        this.SymbolTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Symbols$_setter_$TermSymbolTag_$eq(ClassTag<Symbols.TermSymbol> x$1) {
        this.TermSymbolTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Symbols$_setter_$ModuleSymbolTag_$eq(ClassTag<Symbols.ModuleSymbol> x$1) {
        this.ModuleSymbolTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Symbols$_setter_$MethodSymbolTag_$eq(ClassTag<Symbols.MethodSymbol> x$1) {
        this.MethodSymbolTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Symbols$_setter_$TypeSymbolTag_$eq(ClassTag<Symbols.TypeSymbol> x$1) {
        this.TypeSymbolTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Symbols$_setter_$ClassSymbolTag_$eq(ClassTag<Symbols.ClassSymbol> x$1) {
        this.ClassSymbolTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Symbols$_setter_$FreeTermSymbolTag_$eq(ClassTag<Symbols.FreeTermSymbol> x$1) {
        this.FreeTermSymbolTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Symbols$_setter_$FreeTypeSymbolTag_$eq(ClassTag<Symbols.FreeTypeSymbol> x$1) {
        this.FreeTypeSymbolTag = x$1;
    }

    @Override
    public final void scala$reflect$internal$Symbols$_setter_$symbolIsPossibleInRefinement_$eq(Function1<Symbols.Symbol, Object> x$1) {
        this.symbolIsPossibleInRefinement = x$1;
    }

    @Override
    public void scala$reflect$internal$Symbols$_setter_$AllOps_$eq(Symbols.SymbolOps x$1) {
        this.AllOps = x$1;
    }

    @Override
    public Object scala$reflect$internal$Names$$nameLock() {
        return this.scala$reflect$internal$Names$$nameLock;
    }

    @Override
    public char[] scala$reflect$internal$Names$$_chrs() {
        return this.scala$reflect$internal$Names$$_chrs;
    }

    @Override
    public void scala$reflect$internal$Names$$_chrs_$eq(char[] x$1) {
        this.scala$reflect$internal$Names$$_chrs = x$1;
    }

    @Override
    public int scala$reflect$internal$Names$$nc() {
        return this.scala$reflect$internal$Names$$nc;
    }

    @Override
    public void scala$reflect$internal$Names$$nc_$eq(int x$1) {
        this.scala$reflect$internal$Names$$nc = x$1;
    }

    @Override
    public Names.TermName[] scala$reflect$internal$Names$$termHashtable() {
        return this.scala$reflect$internal$Names$$termHashtable;
    }

    @Override
    public Names.TypeName[] scala$reflect$internal$Names$$typeHashtable() {
        return this.scala$reflect$internal$Names$$typeHashtable;
    }

    @Override
    public ClassTag<Names.Name> NameTag() {
        return this.NameTag;
    }

    @Override
    public ClassTag<Names.TermName> TermNameTag() {
        return this.TermNameTag;
    }

    @Override
    public Names$TermName$ TermName() {
        if (this.TermName$module == null) {
            this.TermName$lzycompute$1();
        }
        return this.TermName$module;
    }

    @Override
    public ClassTag<Names.TypeName> TypeNameTag() {
        return this.TypeNameTag;
    }

    @Override
    public Names$TypeName$ TypeName() {
        if (this.TypeName$module == null) {
            this.TypeName$lzycompute$1();
        }
        return this.TypeName$module;
    }

    @Override
    public final void scala$reflect$internal$Names$_setter_$scala$reflect$internal$Names$$nameLock_$eq(Object x$1) {
        this.scala$reflect$internal$Names$$nameLock = x$1;
    }

    @Override
    public final void scala$reflect$internal$Names$_setter_$scala$reflect$internal$Names$$termHashtable_$eq(Names.TermName[] x$1) {
        this.scala$reflect$internal$Names$$termHashtable = x$1;
    }

    @Override
    public final void scala$reflect$internal$Names$_setter_$scala$reflect$internal$Names$$typeHashtable_$eq(Names.TypeName[] x$1) {
        this.scala$reflect$internal$Names$$typeHashtable = x$1;
    }

    @Override
    public void scala$reflect$internal$Names$_setter_$NameTag_$eq(ClassTag<Names.Name> x$1) {
        this.NameTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Names$_setter_$TermNameTag_$eq(ClassTag<Names.TermName> x$1) {
        this.TermNameTag = x$1;
    }

    @Override
    public void scala$reflect$internal$Names$_setter_$TypeNameTag_$eq(ClassTag<Names.TypeName> x$1) {
        this.TypeNameTag = x$1;
    }

    public TreeGen gen() {
        return this.gen;
    }

    public abstract Statistics statistics();

    public abstract void log(Function0<Object> var1);

    public String elapsedMessage(String msg, long start) {
        return new StringBuilder(6).append(msg).append(" in ").append(TimeUnit.NANOSECONDS.toMillis(System.nanoTime()) - start).append("ms").toString();
    }

    /*
     * WARNING - void declaration
     */
    public void informProgress(String msg) {
        void reflectSettingToBoolean_s;
        MutableSettings.SettingValue settingValue = this.settings().verbose();
        if (MutableSettings$.MODULE$ == null) {
            throw null;
        }
        if (BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value())) {
            this.inform(new StringBuilder(2).append("[").append(msg).append("]").toString());
        }
    }

    /*
     * WARNING - void declaration
     */
    public void informTime(String msg, long start) {
        void reflectSettingToBoolean_s;
        MutableSettings.SettingValue settingValue = this.settings().verbose();
        if (MutableSettings$.MODULE$ == null) {
            throw null;
        }
        if (BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value())) {
            this.informProgress(this.elapsedMessage(msg, start));
        }
    }

    public boolean shouldLogAtThisPhase() {
        return false;
    }

    public boolean isPastTyper() {
        return false;
    }

    public final boolean isDeveloper() {
        return BoxesRunTime.unboxToBoolean(this.settings().debug().value()) || BoxesRunTime.unboxToBoolean(this.settings().developer().value());
    }

    public abstract Phase picklerPhase();

    public abstract Phase erasurePhase();

    public abstract MutableSettings settings();

    public boolean forInteractive() {
        return false;
    }

    public boolean forScaladoc() {
        return false;
    }

    public void debugwarn(Function0<String> msg) {
        this.devWarning(msg);
    }

    /*
     * WARNING - void declaration
     */
    public void debuglog(Function0<String> msg) {
        void reflectSettingToBoolean_s;
        MutableSettings.SettingValue settingValue = this.settings().debug();
        if (MutableSettings$.MODULE$ == null) {
            throw null;
        }
        if (BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value())) {
            this.log(msg);
        }
    }

    public final void devWarningIf(Function0<Object> cond, Function0<String> msg) {
        if (this.isDeveloper() && cond.apply$mcZ$sp()) {
            this.devWarning(msg);
        }
    }

    public void devWarning(Function0<String> msg) {
        if (this.isDeveloper()) {
            Console$.MODULE$.err().println(msg.apply());
        }
    }

    public String throwableAsString(Throwable t) {
        return String.valueOf(t);
    }

    public String throwableAsString(Throwable t, int maxFrames) {
        return new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])t.getStackTrace())).take(maxFrames))).mkString("\n  at ");
    }

    public final void devWarningDumpStack(Function0<String> msg, int maxFrames) {
        this.devWarning((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(1).append((String)msg.apply()).append("\n").append(this.throwableAsString(new Throwable(), maxFrames)).toString());
    }

    public void debugStack(Throwable t) {
        this.devWarning((Function0<String> & java.io.Serializable & Serializable)() -> this.throwableAsString(t));
    }

    public <T> T printCaller(String msg, T result2) {
        String string = "%s: %s\nCalled from: %s";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Console$.MODULE$.err().println(new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{msg, result2, new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new Throwable().getStackTrace())).drop(2))).take(50))).mkString("\n")})));
        return result2;
    }

    public <T> T printResult(String msg, T result2) {
        Console$.MODULE$.err().println(new StringBuilder(2).append(msg).append(": ").append(result2).toString());
        return result2;
    }

    public final <T> T logResult(Function0<String> msg, T result2) {
        this.log((Function0<Object>)(Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(2).append((String)msg.apply()).append(": ").append(result2).toString());
        return result2;
    }

    public final <T> T debuglogResult(Function0<String> msg, T result2) {
        this.debuglog((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(2).append((String)msg.apply()).append(": ").append(result2).toString());
        return result2;
    }

    public final <T> T devWarningResult(Function0<String> msg, T result2) {
        this.devWarning((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(2).append((String)msg.apply()).append(": ").append(result2).toString());
        return result2;
    }

    public final <T> T logResultIf(Function0<String> msg, Function1<T, Object> cond, T result2) {
        if (BoxesRunTime.unboxToBoolean(cond.apply(result2))) {
            this.log((Function0<Object>)(Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(2).append((String)msg.apply()).append(": ").append(result2).toString());
        }
        return result2;
    }

    public final <T> T debuglogResultIf(Function0<String> msg, Function1<T, Object> cond, T result2) {
        if (BoxesRunTime.unboxToBoolean(cond.apply(result2))) {
            this.debuglog((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(2).append((String)msg.apply()).append(": ").append(result2).toString());
        }
        return result2;
    }

    public final void assert(boolean assertion, Function0<Object> message) {
        if (!assertion) {
            throw this.throwAssertionError(message.apply());
        }
    }

    public final void assert(boolean assertion) {
        if (!assertion) {
            throw this.throwAssertionError(SymbolTable.$anonfun$assert$1());
        }
    }

    public final void require(boolean requirement, Function0<Object> message) {
        if (!requirement) {
            throw this.throwRequirementError(message.apply());
        }
    }

    public final void require(boolean requirement) {
        if (!requirement) {
            throw this.throwRequirementError(SymbolTable.$anonfun$require$1());
        }
    }

    public Nothing$ throwAssertionError(Object msg) {
        throw new AssertionError((Object)new StringBuilder(18).append("assertion failed: ").append(this.supplementErrorMessage(String.valueOf(msg))).toString());
    }

    public Nothing$ throwRequirementError(Object msg) {
        throw new IllegalArgumentException(new StringBuilder(20).append("requirement failed: ").append(this.supplementErrorMessage(String.valueOf(msg))).toString());
    }

    public final Symbols.Symbol findSymbol(TraversableOnce<Symbols.Symbol> xs, Function1<Symbols.Symbol, Object> p) {
        Option<Symbols.Symbol> option = xs.find(p);
        if (option == null) {
            throw null;
        }
        Option<Symbols.Symbol> getOrElse_this = option;
        Symbols.Symbol symbol = getOrElse_this.isEmpty() ? this.NoSymbol() : getOrElse_this.get();
        return symbol;
    }

    public <T extends Names.Name> Ordering<T> lowPriorityNameOrdering() {
        return this.SimpleNameOrdering();
    }

    public final boolean traceSymbolActivity() {
        return this.traceSymbolActivity;
    }

    public abstract TreeInfo treeInfo();

    public void assertCorrectThread() {
    }

    public Symbols.Symbol missingHook(Symbols.Symbol owner, Names.Name name) {
        return this.NoSymbol();
    }

    public abstract Mirrors.RootsBase mirrorThatLoaded(Symbols.Symbol var1);

    public final int NoPeriod() {
        return 0;
    }

    public final int NoRunId() {
        return 0;
    }

    private ArrayStack<Phase> phStack() {
        return this.phStack;
    }

    public final List<Phase> atPhaseStack() {
        return this.phStack().toList();
    }

    public final Phase phase() {
        return this.ph;
    }

    public String atPhaseStackMessage() {
        List<Phase> list = this.atPhaseStack();
        String string = ((Object)Nil$.MODULE$).equals(list) ? "" : ((TraversableOnce)list.reverseMap((Function1<Phase, String> & java.io.Serializable & Serializable)x$1 -> new StringBuilder(2).append("->").append(x$1).toString(), List$.MODULE$.canBuildFrom())).mkString("(", " ", ")");
        return string;
    }

    public final void phase_$eq(Phase p) {
        this.ph = p;
        this.per = this.period(this.currentRunId(), p.id());
    }

    /*
     * WARNING - void declaration
     */
    public final Phase pushPhase(Phase ph) {
        void var2_2;
        Phase current = this.phase();
        this.phase_$eq(ph);
        if (this.keepPhaseStack()) {
            this.phStack().push(ph);
        }
        return var2_2;
    }

    public final void popPhase(Phase ph) {
        if (this.keepPhaseStack()) {
            this.phStack().pop();
        }
        this.phase_$eq(ph);
    }

    public boolean keepPhaseStack() {
        return this.keepPhaseStack;
    }

    public void keepPhaseStack_$eq(boolean x$1) {
        this.keepPhaseStack = x$1;
    }

    public abstract int currentRunId();

    public final int runId(int period) {
        return period >> 8;
    }

    public final int phaseId(int period) {
        return period & 0xFF;
    }

    public final int currentPeriod() {
        return this.per;
    }

    public final Phase phaseOf(int period) {
        return this.phaseWithId()[this.phaseId(period)];
    }

    public final int period(int rid, int pid) {
        return (rid << 8) + pid;
    }

    public final boolean isAtPhaseAfter(Phase p) {
        Phase phase = p;
        NoPhase$ noPhase$ = NoPhase$.MODULE$;
        return (phase == null ? noPhase$ != null : !((Object)phase).equals(noPhase$)) && this.phase().id() > p.id();
    }

    public final <T> T enteringPhase(Phase ph, Function0<T> op) {
        T t;
        if (ph == this.phase()) {
            return op.apply();
        }
        Phase saved = this.pushPhase(ph);
        try {
            t = op.apply();
        }
        finally {
            this.popPhase(saved);
        }
        return t;
    }

    /*
     * WARNING - void declaration
     */
    public final Phase findPhaseWithName(String phaseName) {
        void var2_2;
        Phase ph = this.phase();
        while (true) {
            Phase phase = ph;
            NoPhase$ noPhase$ = NoPhase$.MODULE$;
            if (!(phase == null ? noPhase$ != null : !((Object)phase).equals(noPhase$))) break;
            String string = ph.name();
            if (!(string == null ? phaseName != null : !string.equals(phaseName))) break;
            ph = ph.prev();
        }
        if (ph == NoPhase$.MODULE$) {
            return this.phase();
        }
        return var2_2;
    }

    public final <T> T enteringPhaseWithName(String phaseName, Function0<T> body) {
        T t;
        Phase phase = this.findPhaseWithName(phaseName);
        if (phase == this.phase()) {
            return body.apply();
        }
        Phase enteringPhase_saved = this.pushPhase(phase);
        try {
            t = body.apply();
        }
        finally {
            this.popPhase(enteringPhase_saved);
        }
        return t;
    }

    public <T> T slowButSafeEnteringPhase(Phase ph, Function0<T> op) {
        if (this.isCompilerUniverse()) {
            T t;
            if (ph == this.phase()) {
                return op.apply();
            }
            Phase enteringPhase_saved = this.pushPhase(ph);
            try {
                t = op.apply();
            }
            finally {
                this.popPhase(enteringPhase_saved);
            }
            return t;
        }
        return op.apply();
    }

    public final <T> T exitingPhase(Phase ph, Function0<T> op) {
        T t;
        Phase enteringPhase_ph = ph.next();
        if (enteringPhase_ph == this.phase()) {
            return op.apply();
        }
        Phase enteringPhase_saved = this.pushPhase(enteringPhase_ph);
        try {
            t = op.apply();
        }
        finally {
            this.popPhase(enteringPhase_saved);
        }
        return t;
    }

    public final <T> T enteringPrevPhase(Function0<T> op) {
        T t;
        Phase enteringPhase_ph = this.phase().prev();
        if (enteringPhase_ph == this.phase()) {
            return op.apply();
        }
        Phase enteringPhase_saved = this.pushPhase(enteringPhase_ph);
        try {
            t = op.apply();
        }
        finally {
            this.popPhase(enteringPhase_saved);
        }
        return t;
    }

    public final <T> T enteringPhaseNotLaterThan(Phase target, Function0<T> op) {
        if (this.isAtPhaseAfter(target)) {
            T t;
            if (target == this.phase()) {
                return op.apply();
            }
            Phase enteringPhase_saved = this.pushPhase(target);
            try {
                t = op.apply();
            }
            finally {
                this.popPhase(enteringPhase_saved);
            }
            return t;
        }
        return op.apply();
    }

    public <T> T slowButSafeEnteringPhaseNotLaterThan(Phase target, Function0<T> op) {
        if (this.isCompilerUniverse()) {
            if (this.isAtPhaseAfter(target)) {
                T t;
                if (target == this.phase()) {
                    return op.apply();
                }
                Phase enteringPhaseNotLaterThan_enteringPhase_saved = this.pushPhase(target);
                try {
                    t = op.apply();
                }
                finally {
                    this.popPhase(enteringPhaseNotLaterThan_enteringPhase_saved);
                }
                return t;
            }
            return op.apply();
        }
        return op.apply();
    }

    public final boolean isValid(int period) {
        if (period != 0 && this.runId(period) == this.currentRunId()) {
            int pid = this.phaseId(period);
            boolean bl = this.phase().id() > pid ? this.infoTransformers().nextFrom(pid).pid() >= this.phase().id() : this.infoTransformers().nextFrom(this.phase().id()).pid() >= pid;
            if (bl) {
                return true;
            }
        }
        return false;
    }

    public final boolean isValidForBaseClasses(int period) {
        if (period != 0 && this.runId(period) == this.currentRunId()) {
            int pid = this.phaseId(period);
            if (this.phase().id() > pid ? this.noChangeInBaseClasses$1(this.infoTransformers().nextFrom(pid), this.phase().id()) : this.noChangeInBaseClasses$1(this.infoTransformers().nextFrom(this.phase().id()), pid)) {
                return true;
            }
        }
        return false;
    }

    public void openPackageModule(Symbols.Symbol container, Symbols.Symbol dest) {
        container.info().decls().iterator().foreach((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)member -> {
            SymbolTable.$anonfun$openPackageModule$1(dest, member);
            return BoxedUnit.UNIT;
        });
        container.info().decls().iterator().foreach((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)member -> {
            if (!member.isPrivate() && !member.isConstructor()) {
                return dest.info().decls().enter(member);
            }
            return BoxedUnit.UNIT;
        });
        container.parentSymbolsIterator().foreach((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)p -> {
            SymbolTable.$anonfun$openPackageModule$4(this, dest, p);
            return BoxedUnit.UNIT;
        });
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public Types.Type arrayToRepeated(Types.Type tp) {
        block6: {
            block5: {
                if (!(tp instanceof Types.MethodType)) break block5;
                var4_2 = (Types.MethodType)tp;
                params = var4_2.params();
                rtpe = var4_2.resultType();
                formals = tp.paramTypes();
                v0 = formals.last().typeSymbol();
                var8_6 = this.definitions().ArrayClass();
                if (!(!(v0 != null ? v0.equals(var8_6) == false : var8_6 != null))) {
                    throw this.throwAssertionError(SymbolTable.$anonfun$arrayToRepeated$1(formals));
                }
                method = params.last().owner();
                var10_8 = formals.last().typeArgs().head();
                if (!(var10_8 instanceof Types.RefinedType) || (var12_10 = List$.MODULE$.unapplySeq(var11_9 = ((Types.RefinedType)var10_8).parents())).isEmpty() || var12_10.get() == null || ((LinearSeqOptimized)var12_10.get()).lengthCompare(2) != 0) ** GOTO lbl-1000
                t1 = (Types.Type)((LinearSeqOptimized)var12_10.get()).apply(0);
                t2 = (Types.Type)((LinearSeqOptimized)var12_10.get()).apply(1);
                if (!t1.typeSymbol().isAbstractType()) ** GOTO lbl-1000
                v1 = t2.typeSymbol();
                var15_13 = this.definitions().ObjectClass();
                if (!(v1 != null ? v1.equals(var15_13) == false : var15_13 != null)) {
                    var3_14 = t1;
                } else lbl-1000:
                // 3 sources

                {
                    var3_14 = var10_8;
                }
                newParams = method.newSyntheticValueParams(((SeqLike)formals.init()).$colon$plus(this.definitions().javaRepeatedType(var3_14), List$.MODULE$.canBuildFrom()));
                var2_16 /* !! */  = new Types.MethodType(this, newParams, rtpe);
                break block6;
            }
            if (tp instanceof Types.PolyType) {
                var17_17 = (Types.PolyType)tp;
                tparams = var17_17.typeParams();
                rtpe = var17_17.resultType();
                var2_16 /* !! */  = new Types.PolyType(this, tparams, this.arrayToRepeated(rtpe));
            } else {
                throw new MatchError(tp);
            }
        }
        return var2_16 /* !! */ ;
    }

    public void openPackageModule(Symbols.Symbol pkgClass) {
        Symbols.Symbol pkgModule = pkgClass.packageObject();
        if (pkgModule.isModule() && !SymbolTable.fromSource$1(pkgModule)) {
            this.openPackageModule(pkgModule, pkgClass);
        }
    }

    public InfoTransformers.InfoTransformer infoTransformers() {
        return this.infoTransformers;
    }

    public void infoTransformers_$eq(InfoTransformers.InfoTransformer x$1) {
        this.infoTransformers = x$1;
    }

    private final int MaxPhases() {
        return 256;
    }

    public final Phase[] phaseWithId() {
        return this.phaseWithId;
    }

    public boolean isCompilerUniverse() {
        return false;
    }

    public final <T> T atPhase(Phase ph, Function0<T> op) {
        T t;
        if (ph == this.phase()) {
            return op.apply();
        }
        Phase enteringPhase_saved = this.pushPhase(ph);
        try {
            t = op.apply();
        }
        finally {
            this.popPhase(enteringPhase_saved);
        }
        return t;
    }

    public Function1<StringContext, package.StringContextStripMarginOps> StringContextStripMarginOps() {
        return this.StringContextStripMarginOps;
    }

    public void currentRunProfilerBeforeCompletion(Symbols.Symbol root, AbstractFile associatedFile) {
    }

    public void currentRunProfilerAfterCompletion(Symbols.Symbol root, AbstractFile associatedFile) {
    }

    private final void SimpleNameOrdering$lzycompute$1() {
        synchronized (this) {
            if (this.SimpleNameOrdering$module == null) {
                this.SimpleNameOrdering$module = new SymbolTable$SimpleNameOrdering$(this);
            }
            return;
        }
    }

    private final void traceSymbols$lzycompute$1() {
        synchronized (this) {
            if (this.traceSymbols$module == null) {
                this.traceSymbols$module = new SymbolTable$traceSymbols$(this);
            }
            return;
        }
    }

    private final void perRunCaches$lzycompute$1() {
        synchronized (this) {
            if (this.perRunCaches$module == null) {
                this.perRunCaches$module = new SymbolTable$perRunCaches$(this);
            }
            return;
        }
    }

    private final void FreshNameExtractor$lzycompute$1() {
        synchronized (this) {
            if (this.FreshNameExtractor$module == null) {
                this.FreshNameExtractor$module = new FreshNames$FreshNameExtractor$(this);
            }
            return;
        }
    }

    private final void FixedMirrorTreeCreator$lzycompute$1() {
        synchronized (this) {
            if (this.FixedMirrorTreeCreator$module == null) {
                this.FixedMirrorTreeCreator$module = new StdCreators$FixedMirrorTreeCreator$(this);
            }
            return;
        }
    }

    private final void FixedMirrorTypeCreator$lzycompute$1() {
        synchronized (this) {
            if (this.FixedMirrorTypeCreator$module == null) {
                this.FixedMirrorTypeCreator$module = new StdCreators$FixedMirrorTypeCreator$(this);
            }
            return;
        }
    }

    private final void CompoundTypeTreeOriginalAttachment$lzycompute$1() {
        synchronized (this) {
            if (this.CompoundTypeTreeOriginalAttachment$module == null) {
                this.CompoundTypeTreeOriginalAttachment$module = new StdAttachments$CompoundTypeTreeOriginalAttachment$(this);
            }
            return;
        }
    }

    private final void SAMFunction$lzycompute$1() {
        synchronized (this) {
            if (this.SAMFunction$module == null) {
                this.SAMFunction$module = new StdAttachments$SAMFunction$(this);
            }
            return;
        }
    }

    private final void DelambdafyTarget$lzycompute$1() {
        synchronized (this) {
            if (this.DelambdafyTarget$module == null) {
                this.DelambdafyTarget$module = new StdAttachments$DelambdafyTarget$(this);
            }
            return;
        }
    }

    private final void JustMethodReference$lzycompute$1() {
        synchronized (this) {
            if (this.JustMethodReference$module == null) {
                this.JustMethodReference$module = new StdAttachments$JustMethodReference$(this);
            }
            return;
        }
    }

    private final void BackquotedIdentifierAttachment$lzycompute$1() {
        synchronized (this) {
            if (this.BackquotedIdentifierAttachment$module == null) {
                this.BackquotedIdentifierAttachment$module = new StdAttachments$BackquotedIdentifierAttachment$(this);
            }
            return;
        }
    }

    private final void NoWarnAttachment$lzycompute$1() {
        synchronized (this) {
            if (this.NoWarnAttachment$module == null) {
                this.NoWarnAttachment$module = new StdAttachments$NoWarnAttachment$(this);
            }
            return;
        }
    }

    private final void PatVarDefAttachment$lzycompute$1() {
        synchronized (this) {
            if (this.PatVarDefAttachment$module == null) {
                this.PatVarDefAttachment$module = new StdAttachments$PatVarDefAttachment$(this);
            }
            return;
        }
    }

    private final void ForAttachment$lzycompute$1() {
        synchronized (this) {
            if (this.ForAttachment$module == null) {
                this.ForAttachment$module = new StdAttachments$ForAttachment$(this);
            }
            return;
        }
    }

    private final void SyntheticUnitAttachment$lzycompute$1() {
        synchronized (this) {
            if (this.SyntheticUnitAttachment$module == null) {
                this.SyntheticUnitAttachment$module = new StdAttachments$SyntheticUnitAttachment$(this);
            }
            return;
        }
    }

    private final void SubpatternsAttachment$lzycompute$1() {
        synchronized (this) {
            if (this.SubpatternsAttachment$module == null) {
                this.SubpatternsAttachment$module = new StdAttachments$SubpatternsAttachment$(this);
            }
            return;
        }
    }

    private final void NoInlineCallsiteAttachment$lzycompute$1() {
        synchronized (this) {
            if (this.NoInlineCallsiteAttachment$module == null) {
                this.NoInlineCallsiteAttachment$module = new StdAttachments$NoInlineCallsiteAttachment$(this);
            }
            return;
        }
    }

    private final void InlineCallsiteAttachment$lzycompute$1() {
        synchronized (this) {
            if (this.InlineCallsiteAttachment$module == null) {
                this.InlineCallsiteAttachment$module = new StdAttachments$InlineCallsiteAttachment$(this);
            }
            return;
        }
    }

    private final void OuterArgCanBeElided$lzycompute$1() {
        synchronized (this) {
            if (this.OuterArgCanBeElided$module == null) {
                this.OuterArgCanBeElided$module = new StdAttachments$OuterArgCanBeElided$(this);
            }
            return;
        }
    }

    private final void UseInvokeSpecial$lzycompute$1() {
        synchronized (this) {
            if (this.UseInvokeSpecial$module == null) {
                this.UseInvokeSpecial$module = new StdAttachments$UseInvokeSpecial$(this);
            }
            return;
        }
    }

    private final void TypeParamVarargsAttachment$lzycompute$1() {
        synchronized (this) {
            if (this.TypeParamVarargsAttachment$module == null) {
                this.TypeParamVarargsAttachment$module = new StdAttachments$TypeParamVarargsAttachment$(this);
            }
            return;
        }
    }

    private final void KnownDirectSubclassesCalled$lzycompute$1() {
        synchronized (this) {
            if (this.KnownDirectSubclassesCalled$module == null) {
                this.KnownDirectSubclassesCalled$module = new StdAttachments$KnownDirectSubclassesCalled$(this);
            }
            return;
        }
    }

    private final void ChangeOwnerAttachment$lzycompute$1() {
        synchronized (this) {
            if (this.ChangeOwnerAttachment$module == null) {
                this.ChangeOwnerAttachment$module = new StdAttachments$ChangeOwnerAttachment$(this);
            }
            return;
        }
    }

    private final void noPrint$lzycompute$1() {
        synchronized (this) {
            if (this.noPrint$module == null) {
                this.noPrint$module = new TypeDebugging$noPrint$(this);
            }
            return;
        }
    }

    private final void typeDebug$lzycompute$1() {
        synchronized (this) {
            if (this.typeDebug$module == null) {
                this.typeDebug$module = new TypeDebugging$typeDebug$(this);
            }
            return;
        }
    }

    private final void ConsoleWriter$lzycompute$1() {
        synchronized (this) {
            if (this.ConsoleWriter$module == null) {
                this.ConsoleWriter$module = new Printers$ConsoleWriter$(this);
            }
            return;
        }
    }

    private final void RefTree$lzycompute$1() {
        synchronized (this) {
            if (this.RefTree$module == null) {
                this.RefTree$module = new Trees$RefTree$(this);
            }
            return;
        }
    }

    private final void PackageDef$lzycompute$1() {
        synchronized (this) {
            if (this.PackageDef$module == null) {
                this.PackageDef$module = new Trees$PackageDef$(this);
            }
            return;
        }
    }

    private final void ClassDef$lzycompute$1() {
        synchronized (this) {
            if (this.ClassDef$module == null) {
                this.ClassDef$module = new Trees$ClassDef$(this);
            }
            return;
        }
    }

    private final void ModuleDef$lzycompute$1() {
        synchronized (this) {
            if (this.ModuleDef$module == null) {
                this.ModuleDef$module = new Trees$ModuleDef$(this);
            }
            return;
        }
    }

    private final void ValOrDefDef$lzycompute$1() {
        synchronized (this) {
            if (this.ValOrDefDef$module == null) {
                this.ValOrDefDef$module = new Trees$ValOrDefDef$(this);
            }
            return;
        }
    }

    private final void ValDef$lzycompute$1() {
        synchronized (this) {
            if (this.ValDef$module == null) {
                this.ValDef$module = new Trees$ValDef$(this);
            }
            return;
        }
    }

    private final void DefDef$lzycompute$1() {
        synchronized (this) {
            if (this.DefDef$module == null) {
                this.DefDef$module = new Trees$DefDef$(this);
            }
            return;
        }
    }

    private final void TypeDef$lzycompute$1() {
        synchronized (this) {
            if (this.TypeDef$module == null) {
                this.TypeDef$module = new Trees$TypeDef$(this);
            }
            return;
        }
    }

    private final void LabelDef$lzycompute$1() {
        synchronized (this) {
            if (this.LabelDef$module == null) {
                this.LabelDef$module = new Trees$LabelDef$(this);
            }
            return;
        }
    }

    private final void ImportSelector$lzycompute$1() {
        synchronized (this) {
            if (this.ImportSelector$module == null) {
                this.ImportSelector$module = new Trees$ImportSelector$(this);
            }
            return;
        }
    }

    private final void Import$lzycompute$1() {
        synchronized (this) {
            if (this.Import$module == null) {
                this.Import$module = new Trees$Import$(this);
            }
            return;
        }
    }

    private final void Template$lzycompute$1() {
        synchronized (this) {
            if (this.Template$module == null) {
                this.Template$module = new Trees$Template$(this);
            }
            return;
        }
    }

    private final void Block$lzycompute$1() {
        synchronized (this) {
            if (this.Block$module == null) {
                this.Block$module = new Trees$Block$(this);
            }
            return;
        }
    }

    private final void CaseDef$lzycompute$1() {
        synchronized (this) {
            if (this.CaseDef$module == null) {
                this.CaseDef$module = new Trees$CaseDef$(this);
            }
            return;
        }
    }

    private final void Alternative$lzycompute$1() {
        synchronized (this) {
            if (this.Alternative$module == null) {
                this.Alternative$module = new Trees$Alternative$(this);
            }
            return;
        }
    }

    private final void Star$lzycompute$1() {
        synchronized (this) {
            if (this.Star$module == null) {
                this.Star$module = new Trees$Star$(this);
            }
            return;
        }
    }

    private final void Bind$lzycompute$1() {
        synchronized (this) {
            if (this.Bind$module == null) {
                this.Bind$module = new Trees$Bind$(this);
            }
            return;
        }
    }

    private final void UnApply$lzycompute$1() {
        synchronized (this) {
            if (this.UnApply$module == null) {
                this.UnApply$module = new Trees$UnApply$(this);
            }
            return;
        }
    }

    private final void ArrayValue$lzycompute$1() {
        synchronized (this) {
            if (this.ArrayValue$module == null) {
                this.ArrayValue$module = new Trees$ArrayValue$(this);
            }
            return;
        }
    }

    private final void Function$lzycompute$1() {
        synchronized (this) {
            if (this.Function$module == null) {
                this.Function$module = new Trees$Function$(this);
            }
            return;
        }
    }

    private final void Assign$lzycompute$1() {
        synchronized (this) {
            if (this.Assign$module == null) {
                this.Assign$module = new Trees$Assign$(this);
            }
            return;
        }
    }

    private final void AssignOrNamedArg$lzycompute$1() {
        synchronized (this) {
            if (this.AssignOrNamedArg$module == null) {
                this.AssignOrNamedArg$module = new Trees$AssignOrNamedArg$(this);
            }
            return;
        }
    }

    private final void If$lzycompute$1() {
        synchronized (this) {
            if (this.If$module == null) {
                this.If$module = new Trees$If$(this);
            }
            return;
        }
    }

    private final void Match$lzycompute$1() {
        synchronized (this) {
            if (this.Match$module == null) {
                this.Match$module = new Trees$Match$(this);
            }
            return;
        }
    }

    private final void Return$lzycompute$1() {
        synchronized (this) {
            if (this.Return$module == null) {
                this.Return$module = new Trees$Return$(this);
            }
            return;
        }
    }

    private final void Try$lzycompute$1() {
        synchronized (this) {
            if (this.Try$module == null) {
                this.Try$module = new Trees$Try$(this);
            }
            return;
        }
    }

    private final void Throw$lzycompute$1() {
        synchronized (this) {
            if (this.Throw$module == null) {
                this.Throw$module = new Trees$Throw$(this);
            }
            return;
        }
    }

    private final void New$lzycompute$1() {
        synchronized (this) {
            if (this.New$module == null) {
                this.New$module = new Trees$New$(this);
            }
            return;
        }
    }

    private final void Typed$lzycompute$1() {
        synchronized (this) {
            if (this.Typed$module == null) {
                this.Typed$module = new Trees$Typed$(this);
            }
            return;
        }
    }

    private final void MethodValue$lzycompute$1() {
        synchronized (this) {
            if (this.MethodValue$module == null) {
                this.MethodValue$module = new Trees$MethodValue$(this);
            }
            return;
        }
    }

    private final void TypeApply$lzycompute$1() {
        synchronized (this) {
            if (this.TypeApply$module == null) {
                this.TypeApply$module = new Trees$TypeApply$(this);
            }
            return;
        }
    }

    private final void Apply$lzycompute$1() {
        synchronized (this) {
            if (this.Apply$module == null) {
                this.Apply$module = new Trees$Apply$(this);
            }
            return;
        }
    }

    private final void ApplyDynamic$lzycompute$1() {
        synchronized (this) {
            if (this.ApplyDynamic$module == null) {
                this.ApplyDynamic$module = new Trees$ApplyDynamic$(this);
            }
            return;
        }
    }

    private final void Super$lzycompute$1() {
        synchronized (this) {
            if (this.Super$module == null) {
                this.Super$module = new Trees$Super$(this);
            }
            return;
        }
    }

    private final void This$lzycompute$1() {
        synchronized (this) {
            if (this.This$module == null) {
                this.This$module = new Trees$This$(this);
            }
            return;
        }
    }

    private final void Select$lzycompute$1() {
        synchronized (this) {
            if (this.Select$module == null) {
                this.Select$module = new Trees$Select$(this);
            }
            return;
        }
    }

    private final void Ident$lzycompute$1() {
        synchronized (this) {
            if (this.Ident$module == null) {
                this.Ident$module = new Trees$Ident$(this);
            }
            return;
        }
    }

    private final void ReferenceToBoxed$lzycompute$1() {
        synchronized (this) {
            if (this.ReferenceToBoxed$module == null) {
                this.ReferenceToBoxed$module = new Trees$ReferenceToBoxed$(this);
            }
            return;
        }
    }

    private final void Literal$lzycompute$1() {
        synchronized (this) {
            if (this.Literal$module == null) {
                this.Literal$module = new Trees$Literal$(this);
            }
            return;
        }
    }

    private final void Annotated$lzycompute$1() {
        synchronized (this) {
            if (this.Annotated$module == null) {
                this.Annotated$module = new Trees$Annotated$(this);
            }
            return;
        }
    }

    private final void SingletonTypeTree$lzycompute$1() {
        synchronized (this) {
            if (this.SingletonTypeTree$module == null) {
                this.SingletonTypeTree$module = new Trees$SingletonTypeTree$(this);
            }
            return;
        }
    }

    private final void SelectFromTypeTree$lzycompute$1() {
        synchronized (this) {
            if (this.SelectFromTypeTree$module == null) {
                this.SelectFromTypeTree$module = new Trees$SelectFromTypeTree$(this);
            }
            return;
        }
    }

    private final void CompoundTypeTree$lzycompute$1() {
        synchronized (this) {
            if (this.CompoundTypeTree$module == null) {
                this.CompoundTypeTree$module = new Trees$CompoundTypeTree$(this);
            }
            return;
        }
    }

    private final void AppliedTypeTree$lzycompute$1() {
        synchronized (this) {
            if (this.AppliedTypeTree$module == null) {
                this.AppliedTypeTree$module = new Trees$AppliedTypeTree$(this);
            }
            return;
        }
    }

    private final void TypeBoundsTree$lzycompute$1() {
        synchronized (this) {
            if (this.TypeBoundsTree$module == null) {
                this.TypeBoundsTree$module = new Trees$TypeBoundsTree$(this);
            }
            return;
        }
    }

    private final void ExistentialTypeTree$lzycompute$1() {
        synchronized (this) {
            if (this.ExistentialTypeTree$module == null) {
                this.ExistentialTypeTree$module = new Trees$ExistentialTypeTree$(this);
            }
            return;
        }
    }

    private final void TypeTree$lzycompute$1() {
        synchronized (this) {
            if (this.TypeTree$module == null) {
                this.TypeTree$module = new Trees$TypeTree$(this);
            }
            return;
        }
    }

    private final void Modifiers$lzycompute$1() {
        synchronized (this) {
            if (this.Modifiers$module == null) {
                this.Modifiers$module = new Trees$Modifiers$(this);
            }
            return;
        }
    }

    private final void EmptyTree$lzycompute$1() {
        synchronized (this) {
            if (this.EmptyTree$module == null) {
                this.EmptyTree$module = new Trees$EmptyTree$(this);
            }
            return;
        }
    }

    private final void noSelfType$lzycompute$1() {
        synchronized (this) {
            if (this.noSelfType$module == null) {
                this.noSelfType$module = new Trees$noSelfType$(this);
            }
            return;
        }
    }

    private final void pendingSuperCall$lzycompute$1() {
        synchronized (this) {
            if (this.pendingSuperCall$module == null) {
                this.pendingSuperCall$module = new Trees$pendingSuperCall$(this);
            }
            return;
        }
    }

    private final void duplicateAndResetPos$lzycompute$1() {
        synchronized (this) {
            if (this.duplicateAndResetPos$module == null) {
                this.duplicateAndResetPos$module = new Trees$duplicateAndResetPos$(this);
            }
            return;
        }
    }

    private final void UnmappableAnnotArg$lzycompute$1() {
        synchronized (this) {
            if (this.UnmappableAnnotArg$module == null) {
                this.UnmappableAnnotArg$module = new AnnotationInfos$UnmappableAnnotArg$(this);
            }
            return;
        }
    }

    private final void LiteralAnnotArg$lzycompute$1() {
        synchronized (this) {
            if (this.LiteralAnnotArg$module == null) {
                this.LiteralAnnotArg$module = new AnnotationInfos$LiteralAnnotArg$(this);
            }
            return;
        }
    }

    private final void ArrayAnnotArg$lzycompute$1() {
        synchronized (this) {
            if (this.ArrayAnnotArg$module == null) {
                this.ArrayAnnotArg$module = new AnnotationInfos$ArrayAnnotArg$(this);
            }
            return;
        }
    }

    private final void NestedAnnotArg$lzycompute$1() {
        synchronized (this) {
            if (this.NestedAnnotArg$module == null) {
                this.NestedAnnotArg$module = new AnnotationInfos$NestedAnnotArg$(this);
            }
            return;
        }
    }

    private final void ScalaSigBytes$lzycompute$1() {
        synchronized (this) {
            if (this.ScalaSigBytes$module == null) {
                this.ScalaSigBytes$module = new AnnotationInfos$ScalaSigBytes$(this);
            }
            return;
        }
    }

    private final void AnnotationInfo$lzycompute$1() {
        synchronized (this) {
            if (this.AnnotationInfo$module == null) {
                this.AnnotationInfo$module = new AnnotationInfos$AnnotationInfo$(this);
            }
            return;
        }
    }

    private final void Annotation$lzycompute$1() {
        synchronized (this) {
            if (this.Annotation$module == null) {
                this.Annotation$module = new AnnotationInfos$Annotation$(this);
            }
            return;
        }
    }

    private final void UnmappableAnnotation$lzycompute$1() {
        synchronized (this) {
            if (this.UnmappableAnnotation$module == null) {
                this.UnmappableAnnotation$module = new AnnotationInfos$UnmappableAnnotation$(this);
            }
            return;
        }
    }

    private final void ThrownException$lzycompute$1() {
        synchronized (this) {
            if (this.ThrownException$module == null) {
                this.ThrownException$module = new AnnotationInfos$ThrownException$(this);
            }
            return;
        }
    }

    private final void scala$reflect$internal$StdNames$$compactify$lzycompute$1() {
        synchronized (this) {
            if (this.compactify$module == null) {
                this.compactify$module = new StdNames$compactify$(this);
            }
            return;
        }
    }

    private final void tpnme$lzycompute$1() {
        synchronized (this) {
            if (this.tpnme$module == null) {
                this.tpnme$module = new StdNames$tpnme$(this);
            }
            return;
        }
    }

    private final void fulltpnme$lzycompute$1() {
        synchronized (this) {
            if (this.fulltpnme$module == null) {
                this.fulltpnme$module = new StdNames$fulltpnme$(this);
            }
            return;
        }
    }

    private final void binarynme$lzycompute$1() {
        synchronized (this) {
            if (this.binarynme$module == null) {
                this.binarynme$module = new StdNames$binarynme$(this);
            }
            return;
        }
    }

    private final void nme$lzycompute$1() {
        synchronized (this) {
            if (this.nme$module == null) {
                this.nme$module = new StdNames$nme$(this);
            }
            return;
        }
    }

    private final void Constant$lzycompute$1() {
        synchronized (this) {
            if (this.Constant$module == null) {
                this.Constant$module = new Constants$Constant$(this);
            }
            return;
        }
    }

    private final void definitions$lzycompute$1() {
        synchronized (this) {
            if (this.definitions$module == null) {
                this.definitions$module = new Definitions$definitions$(this);
            }
            return;
        }
    }

    private final void LookupSucceeded$lzycompute$1() {
        synchronized (this) {
            if (this.LookupSucceeded$module == null) {
                this.LookupSucceeded$module = new Scopes$LookupSucceeded$(this);
            }
            return;
        }
    }

    private final void LookupAmbiguous$lzycompute$1() {
        synchronized (this) {
            if (this.LookupAmbiguous$module == null) {
                this.LookupAmbiguous$module = new Scopes$LookupAmbiguous$(this);
            }
            return;
        }
    }

    private final void LookupInaccessible$lzycompute$1() {
        synchronized (this) {
            if (this.LookupInaccessible$module == null) {
                this.LookupInaccessible$module = new Scopes$LookupInaccessible$(this);
            }
            return;
        }
    }

    private final void LookupNotFound$lzycompute$1() {
        synchronized (this) {
            if (this.LookupNotFound$module == null) {
                this.LookupNotFound$module = new Scopes$LookupNotFound$(this);
            }
            return;
        }
    }

    private final void Scope$lzycompute$1() {
        synchronized (this) {
            if (this.Scope$module == null) {
                this.Scope$module = new Scopes$Scope$(this);
            }
            return;
        }
    }

    private final void EmptyScope$lzycompute$1() {
        synchronized (this) {
            if (this.EmptyScope$module == null) {
                this.EmptyScope$module = new Scopes$EmptyScope$(this);
            }
            return;
        }
    }

    private final void Flag$lzycompute$1() {
        synchronized (this) {
            if (this.Flag$module == null) {
                this.Flag$module = new FlagSets$Flag$(this);
            }
            return;
        }
    }

    private final void KindErrors$lzycompute$1() {
        synchronized (this) {
            if (this.KindErrors$module == null) {
                this.KindErrors$module = new Kinds$KindErrors$(this);
            }
            return;
        }
    }

    private final void Kind$lzycompute$1() {
        synchronized (this) {
            if (this.Kind$module == null) {
                this.Kind$module = new Kinds$Kind$(this);
            }
            return;
        }
    }

    private final void ProperTypeKind$lzycompute$1() {
        synchronized (this) {
            if (this.ProperTypeKind$module == null) {
                this.ProperTypeKind$module = new Kinds$ProperTypeKind$(this);
            }
            return;
        }
    }

    private final void TypeConKind$lzycompute$1() {
        synchronized (this) {
            if (this.TypeConKind$module == null) {
                this.TypeConKind$module = new Kinds$TypeConKind$(this);
            }
            return;
        }
    }

    private final void inferKind$lzycompute$1() {
        synchronized (this) {
            if (this.inferKind$module == null) {
                this.inferKind$module = new Kinds$inferKind$(this);
            }
            return;
        }
    }

    private final void scala$reflect$internal$Types$$substTypeMapCache$lzycompute$1() {
        synchronized (this) {
            if (this.substTypeMapCache$module == null) {
                this.substTypeMapCache$module = new Types$substTypeMapCache$(this);
            }
            return;
        }
    }

    private final void UnmappableTree$lzycompute$1() {
        synchronized (this) {
            if (this.UnmappableTree$module == null) {
                this.UnmappableTree$module = new Types$UnmappableTree$(this);
            }
            return;
        }
    }

    private final void ErrorType$lzycompute$1() {
        synchronized (this) {
            if (this.ErrorType$module == null) {
                this.ErrorType$module = new Types$ErrorType$(this);
            }
            return;
        }
    }

    private final void WildcardType$lzycompute$1() {
        synchronized (this) {
            if (this.WildcardType$module == null) {
                this.WildcardType$module = new Types$WildcardType$(this);
            }
            return;
        }
    }

    private final void BoundedWildcardType$lzycompute$1() {
        synchronized (this) {
            if (this.BoundedWildcardType$module == null) {
                this.BoundedWildcardType$module = new Types$BoundedWildcardType$(this);
            }
            return;
        }
    }

    private final void NoType$lzycompute$1() {
        synchronized (this) {
            if (this.NoType$module == null) {
                this.NoType$module = new Types$NoType$(this);
            }
            return;
        }
    }

    private final void NoPrefix$lzycompute$1() {
        synchronized (this) {
            if (this.NoPrefix$module == null) {
                this.NoPrefix$module = new Types$NoPrefix$(this);
            }
            return;
        }
    }

    private final void ThisType$lzycompute$1() {
        synchronized (this) {
            if (this.ThisType$module == null) {
                this.ThisType$module = new Types$ThisType$(this);
            }
            return;
        }
    }

    private final void SingleType$lzycompute$1() {
        synchronized (this) {
            if (this.SingleType$module == null) {
                this.SingleType$module = new Types$SingleType$(this);
            }
            return;
        }
    }

    private final void SuperType$lzycompute$1() {
        synchronized (this) {
            if (this.SuperType$module == null) {
                this.SuperType$module = new Types$SuperType$(this);
            }
            return;
        }
    }

    private final void TypeBounds$lzycompute$1() {
        synchronized (this) {
            if (this.TypeBounds$module == null) {
                this.TypeBounds$module = new Types$TypeBounds$(this);
            }
            return;
        }
    }

    private final void CompoundType$lzycompute$1() {
        synchronized (this) {
            if (this.CompoundType$module == null) {
                this.CompoundType$module = new Types$CompoundType$(this);
            }
            return;
        }
    }

    private final void RefinedType$lzycompute$1() {
        synchronized (this) {
            if (this.RefinedType$module == null) {
                this.RefinedType$module = new Types$RefinedType$(this);
            }
            return;
        }
    }

    private final void ClassInfoType$lzycompute$1() {
        synchronized (this) {
            if (this.ClassInfoType$module == null) {
                this.ClassInfoType$module = new Types$ClassInfoType$(this);
            }
            return;
        }
    }

    private final void ConstantType$lzycompute$1() {
        synchronized (this) {
            if (this.ConstantType$module == null) {
                this.ConstantType$module = new Types$ConstantType$(this);
            }
            return;
        }
    }

    private final void TypeRef$lzycompute$1() {
        synchronized (this) {
            if (this.TypeRef$module == null) {
                this.TypeRef$module = new Types$TypeRef$(this);
            }
            return;
        }
    }

    private final void MethodType$lzycompute$1() {
        synchronized (this) {
            if (this.MethodType$module == null) {
                this.MethodType$module = new Types$MethodType$(this);
            }
            return;
        }
    }

    private final void NullaryMethodType$lzycompute$1() {
        synchronized (this) {
            if (this.NullaryMethodType$module == null) {
                this.NullaryMethodType$module = new Types$NullaryMethodType$(this);
            }
            return;
        }
    }

    private final void PolyType$lzycompute$1() {
        synchronized (this) {
            if (this.PolyType$module == null) {
                this.PolyType$module = new Types$PolyType$(this);
            }
            return;
        }
    }

    private final void ExistentialType$lzycompute$1() {
        synchronized (this) {
            if (this.ExistentialType$module == null) {
                this.ExistentialType$module = new Types$ExistentialType$(this);
            }
            return;
        }
    }

    private final void OverloadedType$lzycompute$1() {
        synchronized (this) {
            if (this.OverloadedType$module == null) {
                this.OverloadedType$module = new Types$OverloadedType$(this);
            }
            return;
        }
    }

    private final void ImportType$lzycompute$1() {
        synchronized (this) {
            if (this.ImportType$module == null) {
                this.ImportType$module = new Types$ImportType$(this);
            }
            return;
        }
    }

    private final void AntiPolyType$lzycompute$1() {
        synchronized (this) {
            if (this.AntiPolyType$module == null) {
                this.AntiPolyType$module = new Types$AntiPolyType$(this);
            }
            return;
        }
    }

    private final void HasTypeMember$lzycompute$1() {
        synchronized (this) {
            if (this.HasTypeMember$module == null) {
                this.HasTypeMember$module = new Types$HasTypeMember$(this);
            }
            return;
        }
    }

    private final void ArrayTypeRef$lzycompute$1() {
        synchronized (this) {
            if (this.ArrayTypeRef$module == null) {
                this.ArrayTypeRef$module = new Types$ArrayTypeRef$(this);
            }
            return;
        }
    }

    private final void TypeVar$lzycompute$1() {
        synchronized (this) {
            if (this.TypeVar$module == null) {
                this.TypeVar$module = new Types$TypeVar$(this);
            }
            return;
        }
    }

    private final void AnnotatedType$lzycompute$1() {
        synchronized (this) {
            if (this.AnnotatedType$module == null) {
                this.AnnotatedType$module = new Types$AnnotatedType$(this);
            }
            return;
        }
    }

    private final void StaticallyAnnotatedType$lzycompute$1() {
        synchronized (this) {
            if (this.StaticallyAnnotatedType$module == null) {
                this.StaticallyAnnotatedType$module = new Types$StaticallyAnnotatedType$(this);
            }
            return;
        }
    }

    private final void NamedType$lzycompute$1() {
        synchronized (this) {
            if (this.NamedType$module == null) {
                this.NamedType$module = new Types$NamedType$(this);
            }
            return;
        }
    }

    private final void RepeatedType$lzycompute$1() {
        synchronized (this) {
            if (this.RepeatedType$module == null) {
                this.RepeatedType$module = new Types$RepeatedType$(this);
            }
            return;
        }
    }

    private final void ErasedValueType$lzycompute$1() {
        synchronized (this) {
            if (this.ErasedValueType$module == null) {
                this.ErasedValueType$module = new Types$ErasedValueType$(this);
            }
            return;
        }
    }

    private final void GenPolyType$lzycompute$1() {
        synchronized (this) {
            if (this.GenPolyType$module == null) {
                this.GenPolyType$module = new Types$GenPolyType$(this);
            }
            return;
        }
    }

    private final void unwrapToClass$lzycompute$1() {
        synchronized (this) {
            if (this.unwrapToClass$module == null) {
                this.unwrapToClass$module = new Types$unwrapToClass$(this);
            }
            return;
        }
    }

    private final void unwrapToStableClass$lzycompute$1() {
        synchronized (this) {
            if (this.unwrapToStableClass$module == null) {
                this.unwrapToStableClass$module = new Types$unwrapToStableClass$(this);
            }
            return;
        }
    }

    private final void unwrapWrapperTypes$lzycompute$1() {
        synchronized (this) {
            if (this.unwrapWrapperTypes$module == null) {
                this.unwrapWrapperTypes$module = new Types$unwrapWrapperTypes$(this);
            }
            return;
        }
    }

    private final void RecoverableCyclicReference$lzycompute$1() {
        synchronized (this) {
            if (this.RecoverableCyclicReference$module == null) {
                this.RecoverableCyclicReference$module = new Types$RecoverableCyclicReference$(this);
            }
            return;
        }
    }

    private final void TypeConstraint$lzycompute$1() {
        synchronized (this) {
            if (this.TypeConstraint$module == null) {
                this.TypeConstraint$module = new TypeConstraints$TypeConstraint$(this);
            }
            return;
        }
    }

    private final void normalizeAliases$lzycompute$1() {
        synchronized (this) {
            if (this.normalizeAliases$module == null) {
                this.normalizeAliases$module = new TypeMaps$normalizeAliases$(this);
            }
            return;
        }
    }

    private final void dropSingletonType$lzycompute$1() {
        synchronized (this) {
            if (this.dropSingletonType$module == null) {
                this.dropSingletonType$module = new TypeMaps$dropSingletonType$(this);
            }
            return;
        }
    }

    private final void abstractTypesToBounds$lzycompute$1() {
        synchronized (this) {
            if (this.abstractTypesToBounds$module == null) {
                this.abstractTypesToBounds$module = new TypeMaps$abstractTypesToBounds$(this);
            }
            return;
        }
    }

    private final void dropIllegalStarTypes$lzycompute$1() {
        synchronized (this) {
            if (this.dropIllegalStarTypes$module == null) {
                this.dropIllegalStarTypes$module = new TypeMaps$dropIllegalStarTypes$(this);
            }
            return;
        }
    }

    private final void wildcardExtrapolation$lzycompute$1() {
        synchronized (this) {
            if (this.wildcardExtrapolation$module == null) {
                this.wildcardExtrapolation$module = new TypeMaps$wildcardExtrapolation$(this);
            }
            return;
        }
    }

    private final void IsDependentCollector$lzycompute$1() {
        synchronized (this) {
            if (this.IsDependentCollector$module == null) {
                this.IsDependentCollector$module = new TypeMaps$IsDependentCollector$(this);
            }
            return;
        }
    }

    private final void ApproximateDependentMap$lzycompute$1() {
        synchronized (this) {
            if (this.ApproximateDependentMap$module == null) {
                this.ApproximateDependentMap$module = new TypeMaps$ApproximateDependentMap$(this);
            }
            return;
        }
    }

    private final void wildcardToTypeVarMap$lzycompute$1() {
        synchronized (this) {
            if (this.wildcardToTypeVarMap$module == null) {
                this.wildcardToTypeVarMap$module = new TypeMaps$wildcardToTypeVarMap$(this);
            }
            return;
        }
    }

    private final void typeVarToOriginMap$lzycompute$1() {
        synchronized (this) {
            if (this.typeVarToOriginMap$module == null) {
                this.typeVarToOriginMap$module = new TypeMaps$typeVarToOriginMap$(this);
            }
            return;
        }
    }

    private final void ErroneousCollector$lzycompute$1() {
        synchronized (this) {
            if (this.ErroneousCollector$module == null) {
                this.ErroneousCollector$module = new TypeMaps$ErroneousCollector$(this);
            }
            return;
        }
    }

    private final void adaptToNewRunMap$lzycompute$1() {
        synchronized (this) {
            if (this.adaptToNewRunMap$module == null) {
                this.adaptToNewRunMap$module = new TypeMaps$adaptToNewRunMap$(this);
            }
            return;
        }
    }

    private final void SubTypePair$lzycompute$1() {
        synchronized (this) {
            if (this.SubTypePair$module == null) {
                this.SubTypePair$module = new TypeComparers$SubTypePair$(this);
            }
            return;
        }
    }

    private final void SymbolKind$lzycompute$1() {
        synchronized (this) {
            if (this.SymbolKind$module == null) {
                this.SymbolKind$module = new Symbols$SymbolKind$(this);
            }
            return;
        }
    }

    private final void CyclicReference$lzycompute$1() {
        synchronized (this) {
            if (this.CyclicReference$module == null) {
                this.CyclicReference$module = new Symbols$CyclicReference$(this);
            }
            return;
        }
    }

    private final void scala$reflect$internal$Symbols$$TypeHistory$lzycompute$1() {
        synchronized (this) {
            if (this.TypeHistory$module == null) {
                this.TypeHistory$module = new Symbols$TypeHistory$(this);
            }
            return;
        }
    }

    private final void SymbolOps$lzycompute$1() {
        synchronized (this) {
            if (this.SymbolOps$module == null) {
                this.SymbolOps$module = new Symbols$SymbolOps$(this);
            }
            return;
        }
    }

    private final void TermName$lzycompute$1() {
        synchronized (this) {
            if (this.TermName$module == null) {
                this.TermName$module = new Names$TermName$(this);
            }
            return;
        }
    }

    private final void TypeName$lzycompute$1() {
        synchronized (this) {
            if (this.TypeName$module == null) {
                this.TypeName$module = new Names$TypeName$(this);
            }
            return;
        }
    }

    public static final /* synthetic */ String $anonfun$assert$1() {
        return "";
    }

    public static final /* synthetic */ String $anonfun$require$1() {
        return "";
    }

    private final boolean noChangeInBaseClasses$1(InfoTransformers.InfoTransformer it, int limit) {
        block2: {
            while (it.pid() < limit) {
                if (!it.changesBaseClasses()) {
                    it = it.next();
                    continue;
                }
                break block2;
            }
            return true;
        }
        return false;
    }

    public static final /* synthetic */ void $anonfun$openPackageModule$2(Symbols.Symbol dest$1, Symbols.Symbol existing) {
        dest$1.info().decls().unlink(existing);
    }

    public static final /* synthetic */ void $anonfun$openPackageModule$1(Symbols.Symbol dest$1, Symbols.Symbol member) {
        if (!member.isPrivate() && !member.isConstructor()) {
            List list = dest$1.info().decl(member.name()).alternatives();
            if (list == null) {
                throw null;
            }
            List foreach_these = list;
            while (!foreach_these.isEmpty()) {
                Symbols.Symbol symbol = foreach_these.head();
                SymbolTable.$anonfun$openPackageModule$2(dest$1, symbol);
                foreach_these = (List)foreach_these.tail();
            }
        }
    }

    public static final /* synthetic */ void $anonfun$openPackageModule$4(SymbolTable $this, Symbols.Symbol dest$1, Symbols.Symbol p) {
        Symbols.Symbol symbol = p;
        Symbols.ClassSymbol classSymbol = $this.definitions().ObjectClass();
        if (symbol == null ? classSymbol != null : !symbol.equals(classSymbol)) {
            $this.openPackageModule(p, dest$1);
        }
    }

    public static final /* synthetic */ List $anonfun$arrayToRepeated$1(List formals$1) {
        return formals$1;
    }

    private static final boolean fromSource$1(Symbols.Symbol pkgModule$1) {
        Types.Type type = pkgModule$1.rawInfo();
        boolean bl = type instanceof SymLoader ? ((SymLoader)type).fromSource() : false;
        return bl;
    }

    public static final /* synthetic */ NoPhase$ $anonfun$phaseWithId$1() {
        return NoPhase$.MODULE$;
    }

    /*
     * WARNING - void declaration
     */
    public SymbolTable() {
        int fill_n;
        void fill_evidence$9;
        Collections.$init$(this);
        Names.$init$(this);
        Symbols.$init$(this);
        TypeComparers.$init$(this);
        TypeToStrings.$init$(this);
        CommonOwners.$init$(this);
        GlbLubs.$init$(this);
        TypeMaps.$init$(this);
        TypeConstraints.$init$(this);
        FindMembers.$init$(this);
        Types.$init$(this);
        Variances.$init$(this);
        Kinds.$init$(this);
        ExistentialsAndSkolems.$init$(this);
        FlagSets.$init$(this);
        Scopes.$init$(this);
        Mirrors.$init$(this);
        Definitions.$init$(this);
        Constants.$init$(this);
        BaseTypeSeqs.$init$(this);
        InfoTransformers.$init$(this);
        Transforms.$init$(this);
        StdNames.$init$(this);
        AnnotationInfos.$init$(this);
        AnnotationCheckers.$init$(this);
        Trees.$init$(this);
        Printers.$init$(this);
        Positions.$init$(this);
        TypeDebugging.$init$(this);
        Importers.$init$(this);
        CapturedVariables.$init$(this);
        StdAttachments.$init$(this);
        StdCreators.$init$(this);
        ReificationSupport.$init$(this);
        PrivateWithin.$init$(this);
        Translations.$init$(this);
        FreshNames.$init$(this);
        Internals.$init$(this);
        Reporting.$init$(this);
        this.gen = new TreeGen(this){
            private final SymbolTable global;

            public SymbolTable global() {
                return this.global;
            }
            {
                this.global = $outer;
            }
        };
        this.traceSymbolActivity = scala.sys.package$.MODULE$.props().contains("scalac.debug.syms");
        this.phStack = new ArrayStack();
        this.ph = NoPhase$.MODULE$;
        this.per = 0;
        this.keepPhaseStack = false;
        this.infoTransformers = new InfoTransformers.InfoTransformer(this){
            private final int pid;
            private final boolean changesBaseClasses;

            public int pid() {
                return this.pid;
            }

            public boolean changesBaseClasses() {
                return this.changesBaseClasses;
            }

            public Types.Type transform(Symbols.Symbol sym, Types.Type tpe) {
                return tpe;
            }
            {
                this.pid = NoPhase$.MODULE$.id();
                this.changesBaseClasses = true;
            }
        };
        Array$ array$ = Array$.MODULE$;
        ClassTag classTag = ClassTag$.MODULE$.apply(Phase.class);
        int n = 256;
        if (array$ == null) {
            throw null;
        }
        ArrayBuilder fill_b = array$.newBuilder(fill_evidence$9);
        fill_b.sizeHint(fill_n);
        for (int fill_i = 0; fill_i < fill_n; ++fill_i) {
            fill_b.$plus$eq(SymbolTable.$anonfun$phaseWithId$1());
        }
        this.phaseWithId = (Phase[])fill_b.result();
        this.StringContextStripMarginOps = (Function1<StringContext, package.StringContextStripMarginOps> & java.io.Serializable & Serializable)stringContext -> package$.MODULE$.StringContextStripMarginOps((StringContext)stringContext);
    }

    public static final /* synthetic */ Object $anonfun$openPackageModule$2$adapted(Symbols.Symbol dest$1, Symbols.Symbol existing) {
        SymbolTable.$anonfun$openPackageModule$2(dest$1, existing);
        return BoxedUnit.UNIT;
    }

    public interface ReflectStats
    extends BaseTypeSeqsStats,
    TypesStats,
    SymbolTableStats,
    TreesStats,
    SymbolsStats,
    ScopeStats {
    }

    public abstract class SymLoader
    extends Types.LazyType {
        public boolean fromSource() {
            return false;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$SymbolTable$SymLoader$$$outer() {
            return (SymbolTable)this.$outer;
        }

        public SymLoader(SymbolTable $outer) {
            super($outer);
        }
    }
}

