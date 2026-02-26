/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.SoftReference;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import scala.Array$;
import scala.DelayedInit;
import scala.Dynamic;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Option$;
import scala.PartialFunction;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Predef$any2stringadd$;
import scala.Product;
import scala.SerialVersionUID;
import scala.Serializable;
import scala.Some;
import scala.Some$;
import scala.Specializable;
import scala.StringContext;
import scala.StringContext$;
import scala.Symbol;
import scala.Symbol$;
import scala.Tuple2;
import scala.UninitializedFieldError;
import scala.annotation.Annotation;
import scala.annotation.ClassfileAnnotation;
import scala.annotation.StaticAnnotation;
import scala.annotation.TypeConstraint;
import scala.annotation.bridge;
import scala.annotation.elidable;
import scala.annotation.implicitNotFound;
import scala.annotation.meta.beanGetter;
import scala.annotation.meta.beanSetter;
import scala.annotation.meta.companionClass;
import scala.annotation.meta.companionMethod;
import scala.annotation.meta.companionObject;
import scala.annotation.meta.field;
import scala.annotation.meta.getter;
import scala.annotation.meta.languageFeature;
import scala.annotation.meta.param;
import scala.annotation.meta.setter;
import scala.annotation.migration;
import scala.annotation.strictfp;
import scala.annotation.switch;
import scala.annotation.tailrec;
import scala.annotation.unchecked.uncheckedStable;
import scala.annotation.unchecked.uncheckedVariance;
import scala.annotation.unspecialized;
import scala.annotation.varargs;
import scala.beans.BeanProperty;
import scala.beans.BooleanBeanProperty;
import scala.collection.GenSeq;
import scala.collection.IndexedSeq;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.LinearSeqLike;
import scala.collection.LinearSeqOptimized;
import scala.collection.MapLike;
import scala.collection.Seq;
import scala.collection.SetLike;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.IndexedSeq$;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Map$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Range;
import scala.collection.immutable.Seq$;
import scala.collection.immutable.Set;
import scala.collection.immutable.Set$;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.HashSet;
import scala.collection.mutable.HashSet$;
import scala.concurrent.Future;
import scala.concurrent.Promise;
import scala.deprecated;
import scala.deprecatedInheritance;
import scala.deprecatedName;
import scala.deprecatedOverriding;
import scala.inline;
import scala.math.ScalaNumber;
import scala.native;
import scala.noinline;
import scala.reflect.ClassManifestFactory$;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.Manifest;
import scala.reflect.ManifestFactory$;
import scala.reflect.NoManifest$;
import scala.reflect.OptManifest;
import scala.reflect.ScalaLongSignature;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Mirrors;
import scala.reflect.api.StandardDefinitions;
import scala.reflect.api.Symbols;
import scala.reflect.api.TypeTags;
import scala.reflect.internal.AnnotationInfos;
import scala.reflect.internal.Constants;
import scala.reflect.internal.Definitions$DefinitionsClass$MacroContextType$;
import scala.reflect.internal.Definitions$DefinitionsClass$NothingClass$;
import scala.reflect.internal.Definitions$DefinitionsClass$NullClass$;
import scala.reflect.internal.Definitions$DefinitionsClass$RunDefinitions$ExprClassOf$;
import scala.reflect.internal.Definitions$DefinitionsClass$RunDefinitions$SubtreeType$;
import scala.reflect.internal.Definitions$DefinitionsClass$RunDefinitions$TreeType$;
import scala.reflect.internal.Definitions$DefinitionsClass$VarArityClass$;
import scala.reflect.internal.Definitions$definitions$;
import scala.reflect.internal.FatalError;
import scala.reflect.internal.Mirrors;
import scala.reflect.internal.Names;
import scala.reflect.internal.Phase;
import scala.reflect.internal.Positions;
import scala.reflect.internal.Reporting;
import scala.reflect.internal.Scopes;
import scala.reflect.internal.StdNames;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Trees;
import scala.reflect.internal.Types;
import scala.reflect.internal.Types$NoType$;
import scala.reflect.internal.settings.MutableSettings$;
import scala.reflect.internal.util.Collections;
import scala.reflect.internal.util.Position;
import scala.reflect.internal.util.package$;
import scala.reflect.macros.internal.macroImpl;
import scala.remote;
import scala.runtime.AbstractPartialFunction;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.EmptyMethodCache;
import scala.runtime.MethodCache;
import scala.runtime.NonLocalReturnControl;
import scala.runtime.Nothing$;
import scala.runtime.Null$;
import scala.runtime.ObjectRef;
import scala.runtime.RichInt$;
import scala.runtime.ScalaRunTime$;
import scala.runtime.StringAdd;
import scala.runtime.VolatileObjectRef;
import scala.specialized;
import scala.throws;
import scala.transient;
import scala.unchecked;
import scala.util.Failure;
import scala.util.Properties$;
import scala.util.Success;
import scala.util.Try;
import scala.util.control.NonFatal$;
import scala.volatile;

@ScalaSignature(bytes="\u0006\u0001E5g\u0001DC!\u000b\u0007\u0002\n1!\u0001\u0006RE\u001d\u0007bBC4\u0001\u0011\u0005Q\u0011N\u0004\b\u000bc\u0002\u0001\u0012AC:\r\u001d)9\b\u0001E\u0001\u000bsBqa\"\u0003\u0004\t\u0003\t**\u0002\u0004\u0010>\u0001!qr\b\u0005\b#/\u0003A\u0011BIM\u0011%\t\u001a\u000bAI\u0001\n\u0013\t*\u000bC\u0004\u0012*\u0002!I!e+\t\u000fE]\u0006\u0001\"\u0003\u0012:\"I\u0011S\u0019\u0001\u0012\u0002\u0013%\u0011S\u0015\u0004\f\u000b\u0013\u0003\u0001\u0013aA\u0001\u000b\u0017+Y\bC\u0004\u0006h-!\t!\"\u001b\t\u0013\u001555B1A\u0005\n\u0015=\u0005\"CCY\u0017\t\u0007I\u0011BCZ\u0011\u001d)il\u0003C\u0005\u000b\u007fCq!\"6\f\t\u0013)9\u000eC\u0004\u0007(-!IA\"\u000b\t\u000f\u0019\u00153\u0002\"\u0003\u0007H!Qa1L\u0006\t\u0006\u0004%\tA\"\u0018\t\u0015\u0019\u00054\u0002#b\u0001\n\u00031\u0019\u0007\u0003\u0006\u0007h-A)\u0019!C\u0001\rSB!Bb\u001d\f\u0011\u000b\u0007I\u0011\u0001D;\u0011)1Ih\u0003EC\u0002\u0013\u0005aQ\u000f\u0005\u000b\rwZ\u0001R1A\u0005\u0002\u0019U\u0004B\u0003D?\u0017!\u0015\r\u0011\"\u0001\u0007\u0000!Qa1Q\u0006\t\u0006\u0004%\tA\"\"\t\u0015\u0019\u001d5\u0002#b\u0001\n\u00031)\t\u0003\u0006\u0007\n.A)\u0019!C\u0001\r\u0017CqAb%\f\t\u00031)\nC\u0004\u0007 .!\tA\")\t\u000f\u0019\u001d6\u0002\"\u0001\u0007*\"QaQV\u0006\t\u0006\u0004%\tAb,\t\u0015\u0019E6\u0002#b\u0001\n\u00031y\u000b\u0003\u0006\u00074.A)\u0019!C\u0001\r_C!B\".\f\u0011\u000b\u0007I\u0011\u0001DX\u0011)19l\u0003EC\u0002\u0013\u0005aq\u0016\u0005\u000b\rs[\u0001R1A\u0005\u0002\u0019=\u0006B\u0003D^\u0017!\u0015\r\u0011\"\u0001\u00070\"QaQX\u0006\t\u0006\u0004%\tAb,\t\u0015\u0019}6\u0002#b\u0001\n\u00031y\u000bC\u0004\u0007B.!\tAb1\t\u000f\u0019-7\u0002\"\u0001\u0007D\"9aQZ\u0006\u0005\u0002\u0019\r\u0007B\u0003Dh\u0017!\u0015\r\u0011\"\u0001\u0007R\"QaQ\\\u0006\t\u0006\u0004%\tA\"5\t\u0015\u0019}7\u0002#b\u0001\n\u00031\t\u000e\u0003\u0006\u0007b.A)\u0019!C\u0001\r#D!Bb9\f\u0011\u000b\u0007I\u0011\u0001Di\u0011)1)o\u0003EC\u0002\u0013\u0005a\u0011\u001b\u0005\u000b\rO\\\u0001R1A\u0005\u0002\u0019E\u0007B\u0003Du\u0017!\u0015\r\u0011\"\u0001\u0007R\"Qa1^\u0006\t\u0006\u0004%\tA\"5\t\u0015\u001958\u0002#b\u0001\n\u00031y\u000f\u0003\u0006\u0007v.A)\u0019!C\u0001\r_D!Bb>\f\u0011\u000b\u0007I\u0011\u0001D}\u0011)1ip\u0003EC\u0002\u0013\u0005aq \u0005\u000b\u000f?Y\u0001R1A\u0005\u0002\u0019}hABD\u0003\u0017\t99\u0001\u0003\u0006\u0007\u000ei\u0012\t\u0011)A\u0005\r\u001fAqa\"\u0003;\t\u00039Y\u0001\u0003\u0005\b\u0010i\u0002\u000b\u0011BD\t\u0011!99B\u000fQ\u0001\n\u0015=\bbBD\ru\u0011\u0015q1\u0004\u0005\b\u000fCYA\u0011\u0001D}\u0011\u001d9\u0019c\u0003C\u0001\u000fKAAbb\u000b\f\u0005\u0003\u0005\t\u0011\"\u0001\u0001\u000f[AAbb\f\f\u0005\u0003\u0005\t\u0011\"\u0001\u0001\u000fc1q!\" \u0001\u0003\u0003)y\bC\u0004\b\n\u0011#\tab\u0010\t\u0013\u001d\u0005C\t1A\u0005\n\u001d\r\u0003\"CD#\t\u0002\u0007I\u0011BD$\u0011!9i\u0005\u0012Q!\n\u0019m\u0002bBD(\t\u0012\u0005q1\t\u0005\u000b\u000f#\"\u0005R1A\u0005\u0002\u001dM\u0003BCD+\t\"\u0015\r\u0011\"\u0001\u00070\"Qqq\u000b#\t\u0006\u0004%\tab\u0015\t\u0015\u001deC\t#b\u0001\n\u00031y\u000b\u0003\u0006\b\\\u0011C)\u0019!C\u0001\u000f'B!b\"\u0018E\u0011\u000b\u0007I\u0011\u0001DX\u0011\u001d9y\u0006\u0012C\u0001\u000fCBqa\"\u001eE\t\u000399\bC\u0004\b\u0006\u0012#\tab\"\t\u000f\u001d-E\t\"\u0001\b\u000e\"9q1\u0013#\u0005\u0002\u001dU\u0005bBDS\t\u0012\u0005qq\u0015\u0005\b\u000fW#E\u0011ADW\u0011\u001d9\t\f\u0012C\u0001\u000fgCqab.E\t\u00039I\fC\u0004\b>\u0012#\tab0\t\u000f\u001d\rG\t\"\u0001\bF\"9q\u0011\u001a#\u0005\u0002\u001d-\u0007bBDe\t\u0012\u0005q\u0011\u001b\u0005\b\u000f/$E\u0011BDm\u0011)9y\u000e\u0012EC\u0002\u0013\u0005aq\u0016\u0005\u000b\u000fC$\u0005R1A\u0005\u0002\u001d\r\bBCDv\t\"\u0015\r\u0011\"\u0001\u00070\"QqQ\u001e#\t\u0006\u0004%\tA\"5\t\u0015\u001d=H\t#b\u0001\n\u00031\t\u000e\u0003\u0006\br\u0012C)\u0019!C\u0001\r#D!bb=E\u0011\u000b\u0007I\u0011\u0001Di\u0011)9)\u0010\u0012EC\u0002\u0013\u0005a\u0011\u001b\u0005\u000b\u000fo$\u0005R1A\u0005\u0002\u0019E\u0007BCD}\t\"\u0015\r\u0011\"\u0001\u0007R\"Qq1 #\t\u0006\u0004%\tA\"5\t\u0015\u001duH\t#b\u0001\n\u00031\t\u000e\u0003\u0006\b\u0000\u0012C)\u0019!C\u0001\r#D!\u0002#\u0001E\u0011\u000b\u0007I\u0011\u0001E\u0002\u0011)AY\u0001\u0012EC\u0002\u0013\u0005\u00012\u0001\u0005\u000b\u0011\u001b!\u0005R1A\u0005\u0002!\r\u0001B\u0003E\b\t\"\u0015\r\u0011\"\u0001\u00070\"9\u0001\u0012\u0003#\u0005\u0002\u0019\r\u0007B\u0003E\n\t\"\u0015\r\u0011\"\u0001\u00070\"Q\u0001R\u0003#\t\u0006\u0004%\tAb,\u0007\u000f!]A)!\t\t\u001a!QQQ\u001a:\u0003\u0002\u0003\u0006I!b4\t\u0015!m!O!A!\u0002\u0013)y\u000fC\u0004\b\nI$\t\u0001#\b\t\u000f!\u001d\"\u000f\"\u0012\bD!9\u0001\u0012\u0006:\u0005F!-ra\u0002E+\t\"\u0015\u0001r\b\u0004\b\u0011s!\u0005R\u0001E\u001e\u0011\u001d9I!\u001fC\u0001\u0011{Aq\u0001#\u0011z\t\u0003B\u0019eB\u0004\tX\u0011C)\u0001c\u0014\u0007\u000f!%C\t#\u0002\tL!9q\u0011B?\u0005\u0002!5\u0003b\u0002E!{\u0012\u0005\u0003\u0012\u000b\u0005\u000b\u00113\"\u0005R1A\u0005\u0002\u0019=\u0006B\u0003E.\t\"\u0015\r\u0011\"\u0001\u00070\"Q\u0001R\f#\t\u0006\u0004%\tAb,\t\u0015!}C\t#b\u0001\n\u00031y\u000b\u0003\u0006\tb\u0011C)\u0019!C\u0001\r_C!\u0002c\u0019E\u0011\u000b\u0007I\u0011\u0001DX\u0011)A)\u0007\u0012EC\u0002\u0013\u0005aq\u0016\u0005\u000b\u0011O\"\u0005R1A\u0005\u0002\u0019=\u0006B\u0003E5\t\"\u0015\r\u0011\"\u0001\u00070\"Q\u00012\u000e#\t\u0006\u0004%\tA\"\"\t\u0015!5D\t#b\u0001\n\u00031y\u000b\u0003\u0006\tp\u0011C)\u0019!C\u0001\r_C!\u0002#\u001dE\u0011\u000b\u0007I\u0011\u0001DX\u0011)A\u0019\b\u0012EC\u0002\u0013\u0005aq\u0016\u0005\u000b\u0011k\"\u0005R1A\u0005\u0002\u0019\u0015\u0005B\u0003E<\t\"\u0015\r\u0011\"\u0001\u00070\"9\u0001\u0012\u0010#\u0005\u0002\u0019\r\u0007B\u0003E>\t\"\u0015\r\u0011\"\u0001\u00070\"Q\u0001R\u0010#\t\u0006\u0004%\tab\u0015\t\u000f!}D\t\"\u0001\u0007D\"Q\u0001\u0012\u0011#\t\u0006\u0004%\t\u0001c!\t\u0015!\u001dE\t#b\u0001\n\u0003AI\t\u0003\u0006\t\u0010\u0012C)\u0019!C\u0001\u000f'Bq\u0001#%E\t\u0003A\u0019\nC\u0004\t\u0018\u0012#\tAb1\t\u000f!eE\t\"\u0001\u0007D\"9\u00012\u0014#\u0005\u0002!u\u0005B\u0003ER\t\"\u0015\r\u0011\"\u0001\bT!Q\u0001R\u0015#\t\u0006\u0004%\tab\u0015\t\u0015!\u001dF\t#b\u0001\n\u00039\u0019\u0006C\u0004\t*\u0012#\tAb1\t\u0015!-F\t#b\u0001\n\u00031y\u000b\u0003\u0006\t.\u0012C)\u0019!C\u0001\r_C!\u0002c,E\u0011\u000b\u0007I\u0011\u0001DX\u0011\u001dA\t\f\u0012C\u0001\r\u0007D!\u0002c-E\u0011\u000b\u0007I\u0011\u0001DX\u0011)A)\f\u0012EC\u0002\u0013\u0005aq\u0016\u0005\u000b\u0011o#\u0005R1A\u0005\u0002\u0019=\u0006B\u0003E]\t\"\u0015\r\u0011\"\u0001\u00070\"Q\u00012\u0018#\t\u0006\u0004%\tAb,\t\u0015!uF\t#b\u0001\n\u00031y\u000b\u0003\u0006\t@\u0012C)\u0019!C\u0001\r_C!\u0002#1E\u0011\u000b\u0007I\u0011\u0001DX\u0011)A\u0019\r\u0012EC\u0002\u0013\u0005aq\u0016\u0005\u000b\u0011\u000b$\u0005R1A\u0005\u0002\u0019=\u0006B\u0003Ed\t\"\u0015\r\u0011\"\u0001\u00070\"Q\u0001\u0012\u001a#\t\u0006\u0004%\tAb,\t\u0015!-G\t#b\u0001\n\u00031y\u000b\u0003\u0006\tN\u0012C)\u0019!C\u0001\r_C!\u0002c4E\u0011\u000b\u0007I\u0011\u0001DX\u0011\u001dA\t\u000e\u0012C\u0001\u0011'Dq\u0001c6E\t\u0003AI\u000eC\u0004\t^\u0012#\t\u0001c8\t\u000f!\rH\t\"\u0001\tf\"9\u0001\u0012\u001e#\u0005\u0002!-\bb\u0002Ey\t\u0012\u0005\u00012\u001f\u0005\b\u0011o$E\u0011\u0001E}\u0011\u001dAi\u0010\u0012C\u0001\u0011\u007fDq!#\u0002E\t\u0003I9\u0001C\u0004\n\u0014\u0011#\t!#\u0006\t\u000f%eA\t\"\u0001\n\u001c!9\u0011r\u0004#\u0005\u0002%\u0005\u0002bBE\u0015\t\u0012\u0005\u00112\u0006\u0005\b\u0013_!E\u0011AE\u0019\u0011\u001dII\u0004\u0012C\u0001\u0013wAq!c\u0010E\t\u0003I\t\u0005C\u0004\nF\u0011#\t!c\u0012\t\u000f%-C\t\"\u0001\nN!9\u0011\u0012\u000b#\u0005\u0002%M\u0003bBE,\t\u0012\u0005\u0011\u0012\f\u0005\b\u0013;\"E\u0011AE0\u0011\u001dI\u0019\u0007\u0012C\u0001\u0013KBq!#\u001cE\t\u0003Iy\u0007\u0003\u0006\nx\u0011C)\u0019!C\u0001\r_C!\"#\u001fE\u0011\u000b\u0007I\u0011\u0001DX\u0011)IY\b\u0012EC\u0002\u0013\u0005aq\u0016\u0005\u000b\u0013{\"\u0005R1A\u0005\u0002\u0019=\u0006bBE@\t\u0012\u0005a1\u0019\u0005\u000b\u0013\u0003#\u0005R1A\u0005\u0002\u0019=\u0006BCEB\t\"\u0015\r\u0011\"\u0001\u00070\"Q\u0011R\u0011#\t\u0006\u0004%\tAb,\t\u0015%\u001dE\t#b\u0001\n\u00031y\u000b\u0003\u0006\n\n\u0012C)\u0019!C\u0001\r_C!\"c#E\u0011\u000b\u0007I\u0011AD*\u0011\u001dIi\t\u0012C\u0001\r\u0007D!\"c$E\u0011\u000b\u0007I\u0011AD*\u0011)I\t\n\u0012EC\u0002\u0013\u0005q1\u000b\u0005\u000b\u0013'#\u0005R1A\u0005\u0002\u001dM\u0003BCEK\t\"\u0015\r\u0011\"\u0001\bT!Q\u0011r\u0013#\t\u0006\u0004%\tAb1\t\u000f%eE\t\"\u0001\u0007\u0006\"9\u00112\u0014#\u0005\u0002%u\u0005BCEQ\t\"\u0015\r\u0011\"\u0001\u00070\"Q\u00112\u0015#\t\u0006\u0004%\tAb1\t\u0015%\u0015F\t#b\u0001\n\u00031\u0019\r\u0003\u0006\n(\u0012C)\u0019!C\u0001\r\u0007D!\"#+E\u0011\u000b\u0007I\u0011\u0001Db\u0011)IY\u000b\u0012EC\u0002\u0013\u0005aq\u0016\u0005\u000b\u0013[#\u0005R1A\u0005\u0002\u0019=\u0006BCEX\t\"\u0015\r\u0011\"\u0001\u00070\"Q\u0011\u0012\u0017#\t\u0006\u0004%\tAb,\t\u000f%MF\t\"\u0001\u0007D\"9\u0011R\u0017#\u0005\u0002\u0019\r\u0007BCE\\\t\"\u0015\r\u0011\"\u0001\u0007\u0006\"9\u0011\u0012\u0018#\u0005\u0002\u0019\r\u0007BCE^\t\"\u0015\r\u0011\"\u0001\n>\"9\u0011R\u0019#\u0005\u0002\u0019\u0015\u0005bBEd\t\u0012\u0005aQ\u0011\u0005\b\u0013\u0013$E\u0011\u0001DC\u0011)IY\r\u0012EC\u0002\u0013\u0005aQ\u0011\u0005\b\u0013\u001b$E\u0011\u0001DC\u0011\u001dIy\r\u0012C\u0001\u0013{C!\"#5E\u0011\u000b\u0007I\u0011\u0001DC\u0011)I\u0019\u000e\u0012EC\u0002\u0013\u0005aQ\u0011\u0005\u000b\u0013+$\u0005R1A\u0005\u0002\u001dM\u0003BCEl\t\"\u0015\r\u0011\"\u0001\u0007\u0006\"Q\u0011\u0012\u001c#\t\u0006\u0004%\tA\"\"\t\u000f%mG\t\"\u0001\u0007\u0006\"9\u0011R\u001c#\u0005\u0002\u0019\u0015\u0005BCEp\t\"\u0015\r\u0011\"\u0001\u0007\u0006\"9\u0011\u0012\u001d#\u0005\u0002\u0019\r\u0007BCEr\t\"\u0015\r\u0011\"\u0001\bT!Q\u0011R\u001d#\t\u0006\u0004%\tAb,\t\u0015%\u001dH\t#b\u0001\n\u00039\u0019\u0006\u0003\u0006\nj\u0012C)\u0019!C\u0001\r_C!\"c;E\u0011\u000b\u0007I\u0011AD*\u0011)Ii\u000f\u0012EC\u0002\u0013\u0005aQ\u0011\u0005\u000b\u0013_$\u0005R1A\u0005\u0002\u0019\u0015\u0005bBEy\t\u0012\u0005aQ\u0011\u0005\b\u0013g$E\u0011\u0001DC\u0011\u001dI)\u0010\u0012C\u0001\r\u000bC!\"c>E\u0011\u000b\u0007I\u0011AD*\u0011)II\u0010\u0012EC\u0002\u0013\u0005aq\u0016\u0005\u000b\u0013w$\u0005R1A\u0005\u0002\u0019\u0015\u0005BCE\u007f\t\"\u0015\r\u0011\"\u0001\u0007\u0006\"Q\u0011r #\t\u0006\u0004%\tA\"\"\t\u0015)\u0005A\t#b\u0001\n\u00031)\t\u0003\u0006\u000b\u0004\u0011C)\u0019!C\u0001\r\u000bC!B#\u0002E\u0011\u000b\u0007I\u0011\u0001DC\u0011)Q9\u0001\u0012EC\u0002\u0013\u0005aQ\u0011\u0005\b\u0015\u0013!E\u0011\u0002DC\u0011)QY\u0001\u0012EC\u0002\u0013\u0005aQ\u0011\u0005\u000b\u0015\u001b!\u0005R1A\u0005\u0002\u0019\u0015\u0005b\u0002F\b\t\u0012\u0005aQ\u0011\u0005\b\u0015#!E\u0011\u0001DC\u0011\u001dQ\u0019\u0002\u0012C\u0001\r\u000bCqA#\u0006E\t\u00031)\tC\u0004\u000b\u0018\u0011#\tA\"\"\t\u000f)eA\t\"\u0001\u0007\u0006\"Q!2\u0004#\t\u0006\u0004%\tAb,\t\u0015)uA\t#b\u0001\n\u00031y\u000b\u0003\u0006\u000b \u0011C)\u0019!C\u0001\u000f'B!B#\tE\u0011\u000b\u0007I\u0011\u0001DC\u0011)Q\u0019\u0003\u0012EC\u0002\u0013\u0005aQ\u0011\u0005\u000b\u0015K!\u0005R1A\u0005\u0002)\u001d\u0002B\u0003F,\t\"\u0015\r\u0011\"\u0001\u000bZ!Q!r\u000f#\t\u0006\u0004%\tAb,\t\u0015)eD\t#b\u0001\n\u00031y\u000b\u0003\u0006\u000b|\u0011C)\u0019!C\u0001\r\u000bC!B# E\u0011\u000b\u0007I\u0011\u0001DC\u0011)Qy\b\u0012EC\u0002\u0013\u0005aq\u0016\u0005\u000b\u0015\u0003#\u0005R1A\u0005\u0002\u001dM\u0003B\u0003FB\t\"\u0015\r\u0011\"\u0001\u00070\"Q!R\u0011#\t\u0006\u0004%\tab\u0015\t\u0015)\u001dE\t#b\u0001\n\u00039\u0019\u0006C\u0004\u000b\n\u0012#\tAc#\t\u000f)%F\t\"\u0001\u000b,\"9!\u0012\u0018#\u0005\u0002)m\u0006b\u0002F`\t\u0012\u0005!\u0012\u0019\u0004\u0007\u0015\u000b$\u0005Ac2\t\u0017\u00155'1\u000bB\u0001B\u0003%!r\u001a\u0005\f\u0015'\u0014\u0019F!A!\u0002\u0013)Y\u000bC\u0006\u000bV\nM#\u0011!Q\u0001\n\u0015-\u0006b\u0003Fl\u0005'\u0012\t\u0011)A\u0005\u00153D\u0001b\"\u0003\u0003T\u0011\u0005!r\u001c\u0005\u000b\u0015W\u0014\u0019F1A\u0005\n)5\b\"\u0003Fx\u0005'\u0002\u000b\u0011BCV\u0011!Q\tPa\u0015\u0005\n)M\bB\u0003F}\u0005'\u0012\r\u0011\"\u0001\u000b|\"I12\u0001B*A\u0003%!R \u0005\u000b\u0017\u000b\u0011\u0019F1A\u0005\n-\u001d\u0001\"CF\u0006\u0005'\u0002\u000b\u0011BF\u0005\u0011!9IBa\u0015\u0005\u0002-5\u0001\u0002CF\t\u0005'\"\tac\u0005\t\u0011-]!1\u000bC\u0001\u00173A!b#\n\u0003TE\u0005I\u0011AF\u0014\u000f\u001dYi\u0004\u0012E\u0001\u0017\u007f1qA#2E\u0011\u0003Y\t\u0005\u0003\u0005\b\n\t]D\u0011AF\"\u0011)Y)Ea\u001e\u0012\u0002\u0013\u00051r\t\u0005\u000b\u0017\u0017\u00129(%A\u0005\u0002-5\u0003\"CF)\t\n\u0007I\u0011\u0001Fw\u0011!Y\u0019\u0006\u0012Q\u0001\n\u0015-\u0006\"CF+\t\n\u0007I\u0011\u0001Fw\u0011!Y9\u0006\u0012Q\u0001\n\u0015-\u0006\"CF-\t\n\u0007I\u0011\u0001Fw\u0011!YY\u0006\u0012Q\u0001\n\u0015-\u0006\"CF/\t\n\u0007I\u0011\u0001Fw\u0011!Yy\u0006\u0012Q\u0001\n\u0015-\u0006\"CF1\t\n\u0007I\u0011\u0001Fw\u0011!Y\u0019\u0007\u0012Q\u0001\n\u0015-\u0006\"CF3\t\n\u0007I\u0011\u0001Fw\u0011!Y9\u0007\u0012Q\u0001\n\u0015-\u0006BCF5\t\"\u0015\r\u0011\"\u0001\fl!Q1R\u000e#\t\u0006\u0004%\tac\u001b\t\u0015-=D\t#b\u0001\n\u0003YY\u0007\u0003\u0006\fr\u0011C)\u0019!C\u0001\u0017WBqac\u001dE\t\u0003Y)\bC\u0004\f|\u0011#\ta# \t\u000f-\u0015E\t\"\u0001\f\b\"91R\u0012#\u0005\u0002-=\u0005bBFK\t\u0012\u00051r\u0013\u0005\b\u00177#E\u0011AFO\u0011\u001dY\t\u000b\u0012C\u0001\u0017GC!bc*E\u0011\u000b\u0007I\u0011\u0001DX\u0011)YI\u000b\u0012EC\u0002\u0013\u0005aq\u0016\u0005\u000b\u0017W#\u0005R1A\u0005\u0002\u0019=\u0006BCFW\t\"\u0015\r\u0011\"\u0001\u00070\"Q1r\u0016#\t\u0006\u0004%\tAb,\t\u0015-EF\t#b\u0001\n\u00031y\u000bC\u0004\f4\u0012#\ta#.\t\u000f-eF\t\"\u0001\f<\u001e91r\u0018#\t\u0002-\u0005gaBFb\t\"\u00051R\u0019\u0005\t\u000f\u0013\u0011y\f\"\u0001\fH\"A1\u0012\u001aB`\t\u0003YY\rC\u0004\fR\u0012#\tac5\t\u000f-]G\t\"\u0001\fZ\"91R\u001c#\u0005\n-}\u0007bBFr\t\u0012\u00051R\u001d\u0005\b\u0017S$E\u0011AFv\u0011\u001dYy\u000f\u0012C\u0001\u0017cDqa#>E\t\u0003Y9\u0010C\u0004\f|\u0012#\ta#@\t\u000f1\u0005A\t\"\u0001\r\u0004!9Ar\u0001#\u0005\u00021%\u0001b\u0002G\u0007\t\u0012\u0005Ar\u0002\u0005\b\u0019'!E\u0011\u0001G\u000b\u0011\u001daI\u0002\u0012C\u0001\u00197Aq\u0001d\bE\t\u0003a\t\u0003C\u0004\r,\u0011#\t\u0001$\f\t\u000f1EB\t\"\u0001\r4!QAr\u0007#\t\u0006\u0004%\tAb,\t\u000f1eB\t\"\u0001\u0007D\"9A2\b#\u0005\u0002\u0019\r\u0007b\u0002G\u001f\t\u0012\u0005a1\u0019\u0005\b\u0019\u007f!E\u0011\u0001Db\u0011\u001da\t\u0005\u0012C\u0001\r\u0007Dq\u0001d\u0011E\t\u0003a)\u0005C\u0004\rP\u0011#\t\u0001$\u0015\t\u000f1\u0015D\t\"\u0001\rh!9AR\u000e#\u0005\u00021=\u0004b\u0002G:\t\u0012\u0005AR\u000f\u0005\b\u0019s\"E\u0011\u0001G>\u0011\u001day\b\u0012C\u0001\u0019\u0003C\u0001\u0002$\"EA\u0003&Q1\u0016\u0005\t\u0019\u000f#\u0005\u0015!\u0003\r\n\"9AR\u0013#\u0005\u00021]\u0005b\u0002GN\t\u0012\u0005AR\u0014\u0005\t\u0019C#\u0005\u0015!\u0003\u0007<!9A2\u0015#\u0005\u00021\u0015\u0006b\u0002GU\t\u0012\u0005A2\u0016\u0005\b\u0019c#E\u0011\u0001GZ\u0011\u001da9\f\u0012C\u0001\u0019sCq\u0001$0E\t\u0003ay\fC\u0004\rD\u0012#\t\u0001$2\t\u000f1%G\t\"\u0001\rL\"9Ar\u001a#\u0005\u00021E\u0007b\u0002Gk\t\u0012\u0005Ar\u001b\u0005\b\u00197$E\u0011\u0001Go\u0011\u001da\t\u000f\u0012C\u0001\u0019GDq\u0001d:E\t\u0003aI\u000fC\u0004\rn\u0012#\t\u0001d<\t\u000f1MH\t\"\u0003\rv\"9Q\u0012\u0002#\u0005\n5-\u0001bBG\u000f\t\u0012\u0005Qr\u0004\u0005\b\u001bG!E\u0011AG\u0013\u0011\u001diI\u0003\u0012C\u0001\u001bWAq!d\fE\t\u0003i\t\u0004\u0003\u0006\u000e:\u0011C)\u0019!C\u0001\u0013{C!\"d\u000fE\u0011\u000b\u0007I\u0011AE_\u0011)ii\u0004\u0012EC\u0002\u0013\u0005\u0011R\u0018\u0005\u000b\u001b\u007f!\u0005R1A\u0005\u0002%u\u0006BCG!\t\"\u0015\r\u0011\"\u0001\n>\"QQ2\t#\t\u0006\u0004%\t!#0\t\u00155\u0015C\t#b\u0001\n\u0003Ii\f\u0003\u0006\u000eH\u0011C)\u0019!C\u0001\u0013{C!\"$\u0013E\u0011\u000b\u0007I\u0011AE_\u0011)iY\u0005\u0012EC\u0002\u0013\u0005\u0001\u0012\u0012\u0005\u000b\u001b\u001b\"\u0005R1A\u0005\u0002\u0019-\u0005bBG(\t\u0012\u0005Q\u0012\u000b\u0005\b\u001b+\"E\u0011AG,\u0011\u001dii\u0006\u0012C\u0001\u001b?Bq!$\u001aE\t\u0003i9\u0007C\u0004\u000el\u0011#\t!$\u001c\t\u000f5ED\t\"\u0001\u000et!9Qr\u000f#\u0005\u00025e\u0004bBG?\t\u0012\u0005Qr\u0010\u0005\u000b\u001b\u0007#\u0005R1A\u0005\u0002%u\u0006BCGC\t\"\u0015\r\u0011\"\u0001\n>\"QQr\u0011#\t\u0006\u0004%\t!#0\t\u00155%E\t#b\u0001\n\u0003Ii\f\u0003\u0006\u000e\f\u0012C)\u0019!C\u0001\u0013{C!\"$$E\u0011\u000b\u0007I\u0011AE_\u0011)iy\t\u0012EC\u0002\u0013\u0005\u0011R\u0018\u0005\u000b\u001b##\u0005R1A\u0005\u0002%u\u0006BCGJ\t\"\u0015\r\u0011\"\u0001\n>\"9QR\u0013#\u0005\u0002\u0019\r\u0007bBGL\t\u0012\u0005a1\u0019\u0005\b\u001b3#E\u0011\u0001Db\u0011\u001diY\n\u0012C\u0001\r\u0007Dq!$(E\t\u00031\u0019\rC\u0004\u000e \u0012#\tAb1\t\u000f5\u0005F\t\"\u0001\u0007D\"9Q2\u0015#\u0005\u0002\u0019\r\u0007BCGS\t\"\u0015\r\u0011\"\u0001\u00070\"QQr\u0015#\t\u0006\u0004%\tAb,\t\u00155%F\t#b\u0001\n\u00039\u0019\u0006\u0003\u0006\u000e,\u0012C)\u0019!C\u0001\u000f'B!\"$,E\u0011\u000b\u0007I\u0011\u0001DC\u0011)iy\u000b\u0012EC\u0002\u0013\u0005aq\u0016\u0005\u000b\u001bc#\u0005R1A\u0005\u0002\u0019=\u0006BCGZ\t\"\u0015\r\u0011\"\u0001\u00070\"QQR\u0017#\t\u0006\u0004%\tAb,\t\u00155]F\t#b\u0001\n\u00031y\u000b\u0003\u0006\u000e:\u0012C)\u0019!C\u0001\r_C!\"d/E\u0011\u000b\u0007I\u0011\u0001DX\u0011)ii\f\u0012EC\u0002\u0013\u0005aq\u0016\u0005\u000b\u001b\u007f#\u0005R1A\u0005\u0002\u0019=\u0006BCGa\t\"\u0015\r\u0011\"\u0001\u00070\"QQ2\u0019#\t\u0006\u0004%\tab\u0015\t\u000f5\u0015G\t\"\u0001\u0007D\"9Qr\u0019#\u0005\u0002\u0019\r\u0007BCGe\t\"\u0015\r\u0011\"\u0001\u00070\"QQ2\u001a#\t\u0006\u0004%\tAb,\t\u001555G\t#b\u0001\n\u00031y\u000b\u0003\u0006\u000eP\u0012C)\u0019!C\u0001\r_C!\"$5E\u0011\u000b\u0007I\u0011\u0001DX\u0011)i\u0019\u000e\u0012EC\u0002\u0013\u0005aq\u0016\u0005\u000b\u001b+$\u0005R1A\u0005\u0002\u0019=\u0006BCGl\t\"\u0015\r\u0011\"\u0001\u00070\"QQ\u0012\u001c#\t\u0006\u0004%\tAb,\t\u00155mG\t#b\u0001\n\u00031)\t\u0003\u0006\u000e^\u0012C)\u0019!C\u0001\r_C!\"d8E\u0011\u000b\u0007I\u0011\u0001DX\u0011)i\t\u000f\u0012EC\u0002\u0013\u0005aq\u0016\u0005\u000b\u001bG$\u0005R1A\u0005\u0002\u0019=\u0006BCGs\t\"\u0015\r\u0011\"\u0001\u00070\"QQr\u001d#\t\u0006\u0004%\tA\"\"\t\u00155%H\t#b\u0001\n\u00031y\u000b\u0003\u0006\u000el\u0012C)\u0019!C\u0001\r_C!\"$<E\u0011\u000b\u0007I\u0011\u0001DX\u0011)iy\u000f\u0012EC\u0002\u0013\u0005aq\u0016\u0005\u000b\u001bc$\u0005R1A\u0005\u0002\u0019\u0015\u0005BCGz\t\"\u0015\r\u0011\"\u0001\u00070\"QQR\u001f#\t\u0006\u0004%\tAb,\t\u00155]H\t#b\u0001\n\u00031y\u000b\u0003\u0006\u000ez\u0012C)\u0019!C\u0001\r_C!\"d?E\u0011\u000b\u0007I\u0011\u0001DX\u0011)ii\u0010\u0012EC\u0002\u0013\u0005aq\u0016\u0005\u000b\u001b\u007f$\u0005R1A\u0005\u0002\u0019=\u0006B\u0003H\u0001\t\"\u0015\r\u0011\"\u0001\u00070\"Qa2\u0001#\t\u0006\u0004%\tAb,\t\u00159\u0015A\t#b\u0001\n\u0003q9\u0001\u0003\u0006\u000f\u0014\u0011C)\u0019!C\u0001\r_C!B$\u0006E\u0011\u000b\u0007I\u0011\u0001DX\u0011)q9\u0002\u0012EC\u0002\u0013\u0005aq\u0016\u0005\u000b\u001d3!\u0005R1A\u0005\u0002\u0019=\u0006B\u0003H\u000e\t\"\u0015\r\u0011\"\u0001\u0007\u0006\"QaR\u0004#\t\u0006\u0004%\tAb,\t\u00159}A\t#b\u0001\n\u00031y\u000b\u0003\u0006\u000f\"\u0011C)\u0019!C\u0001\r_C!Bd\tE\u0011\u000b\u0007I\u0011\u0001DX\u0011)q)\u0003\u0012EC\u0002\u0013\u0005aq\u0016\u0005\u000b\u001dO!\u0005R1A\u0005\u0002\u0019=\u0006B\u0003H\u0015\t\"\u0015\r\u0011\"\u0001\u00070\"Qa2\u0006#\t\u0006\u0004%\tAb,\t\u001595B\t#b\u0001\n\u00031y\u000b\u0003\u0006\u000f0\u0011C)\u0019!C\u0001\r_C!B$\rE\u0011\u000b\u0007I\u0011\u0001DX\u0011)q\u0019\u0004\u0012EC\u0002\u0013\u0005aq\u0016\u0005\u000b\u001dk!\u0005R1A\u0005\u0002\u0019=\u0006B\u0003H\u001c\t\"\u0015\r\u0011\"\u0001\u00070\"Qa\u0012\b#\t\u0006\u0004%\tAd\u000f\t\u00159}B\t#b\u0001\n\u00039\u0019\u0006C\u0004\u000fB\u0011#\tAd\u0011\t\u00159\u001dC\t#b\u0001\n\u00031Y\tC\u0004\u000fJ\u0011#\tAd\u0013\t\u00159mC\t#b\u0001\n\u00031y\u000bC\u0004\u000f^\u0011#IAd\u0018\t\u00139=D)%A\u0005\n9E\u0004\"\u0003H;\tF\u0005I\u0011\u0002H9\u0011\u001dq9\b\u0012C\u0001\u001dsB\u0011Bd E#\u0003%\tA$!\t\u000f9\u0015E\t\"\u0001\u000f\b\"9aR\u0012#\u0005\u00029=\u0005b\u0002HG\t\u0012\u0005a\u0012\u0014\u0005\b\u001dG#E\u0011\u0001HS\u0011\u001dqY\u000b\u0012C\u0001\u001d[CqAd-E\t\u0003q)\fC\u0004\u000f<\u0012#\tA$0\t\u000f9%G\t\"\u0001\u000fL\"9a\u0012\u001b#\u0005\u00029M\u0007b\u0002Hm\t\u0012\u0005a2\u001c\u0005\b\u001dC$E\u0011\u0001Hr\u0011)qI\u000f\u0012EC\u0002\u0013%a2\u001e\u0005\b\u001dk$E\u0011\u0001H|\u0011\u001dqi\u0010\u0012C\u0001\u001d\u007fDqa$\u0002E\t\u0003y9\u0001C\u0004\u0010\u000e\u0011#Iad\u0004\t\u000f=eA\t\"\u0003\u0010\u001c!9q\u0012\u0007#\u0005\u0002=M\u0002bBH*\t\u0012\u0005qR\u000b\u0005\b\u001fG\"E\u0011AH3\u0011\u001dy\t\b\u0012C\u0001\u001fgBqad E\t\u0003y\t\tC\u0004\u0010\u000e\u0012#\tad$\t\u000f=mE\t\"\u0001\u0010\u001e\"9q\u0012\u0016#\u0005\u0002=-\u0006BCH\\\t\"\u0015\r\u0011\"\u0001\t\n\"Qq\u0012\u0018#\t\u0006\u0004%\tad/\t\u0015=\u001dG\t#b\u0001\n\u0003yI\r\u0003\u0006\u0010N\u0012C)\u0019!C\u0001\r_D!bd4E\u0011\u000b\u0007I\u0011AHi\u0011)\u0001z\u0005\u0012EC\u0002\u0013\u0005\u0001\u0012\u0012\u0005\u000b!#\"\u0005R1A\u0005\n!%\u0005b\u0002I*\t\u0012\u0005\u0001S\u000b\u0005\b!3\"E\u0011\u0001I.\u0011\u001d\u0001z\u0006\u0012C\u0001!CBq\u0001%\u001aE\t\u0003\u0001:\u0007C\u0004\u0011l\u0011#\t\u0001%\u001c\t\u0015AED\t#b\u0001\n\u00031)\tC\u0004\u0011t\u0011#\t\u0001%\u001e\t\u000f)]G\t\"\u0001\u0006j\u00191\u0001\u0013\u0010#\u0001!wB1\u0002% \u0005f\t\u0005\t\u0015!\u0003\u000fR!Aq\u0011\u0002C3\t\u0003\u0001z\bC\u0006\u0011\u0006\u0012\u0015\u0004R1A\u0005\u0002\u0019E\u0007b\u0003ID\tKB)\u0019!C\u0001\r#D1\u0002%#\u0005f!\u0015\r\u0011\"\u0001\u0007R\"Y\u00013\u0012C3\u0011\u000b\u0007I\u0011\u0001Di\u0011-\u0001j\t\"\u001a\t\u0006\u0004%\tA\"5\t\u0017A=EQ\rEC\u0002\u0013\u0005a\u0011\u001b\u0005\f!##)\u0007#b\u0001\n\u00031\t\u000eC\u0006\u0011\u0014\u0012\u0015\u0004R1A\u0005\u0002\u0019E\u0007b\u0003IK\tKB)\u0019!C\u0001\r#D1\u0002e&\u0005f!\u0015\r\u0011\"\u0001\u0007R\"Y\u0001\u0013\u0014C3\u0011\u000b\u0007I\u0011\u0001Di\u0011!\u0001Z\n\"\u001a\u0005\u0002AueA\u0002IQ\t\n\u0001\u001a\u000b\u0003\u0005\b\n\u0011\rE\u0011\u0001IS\u0011-\u0001J\u000bb!\t\u0006\u0004%\tAb1\t\u0017A-F1\u0011EC\u0002\u0013\u0005aQ\u0011\u0005\t![#\u0019\t\"\u0001\u00110\"Y\u00013\u0017CB\u0011\u000b\u0007I\u0011\u0001Db\u0011-\u0001*\fb!\t\u0006\u0004%\tAb1\t\u0017A]F1\u0011EC\u0002\u0013\u0005a1\u0019\u0005\f!s#\u0019\t#b\u0001\n\u00031\u0019\rC\u0006\u0011<\u0012\r\u0005R1A\u0005\u0002\u0019=\u0006\u0002\u0003I_\t\u0007#\t\u0001e0\t\u0017A\rG1\u0011EC\u0002\u0013\u0005aQ\u0011\u0005\f!\u000b$\u0019\t#b\u0001\n\u00031)\t\u0003\u0005\u0011H\u0012\rE\u0011\u0002Ie\u0011!\u0001j\rb!\u0005\nA=\u0007b\u0003Im\t\u0007C)\u0019!C\u0001!7D1\u0002e8\u0005\u0004\"\u0015\r\u0011\"\u0001\u0011\\\"Y\u0001\u0013\u001dCB\u0011\u000b\u0007I\u0011\u0001EE\u0011-\u0001\u001a\u000fb!\t\u0006\u0004%\t\u0001##\t\u0017\u0019\u0005G1\u0011EC\u0002\u0013\u0005a1\u0019\u0005\f\r\u0017$\u0019\t#b\u0001\n\u00031\u0019\rC\u0006\u0007N\u0012\r\u0005R1A\u0005\u0002\u0019\r\u0007b\u0003Is\t\u0007C)\u0019!C\u0001\r\u0007D1\u0002e:\u0005\u0004\"\u0015\r\u0011\"\u0001\u0007\u0006\"Y\u0001\u0013\u001eCB\u0011\u000b\u0007I\u0011\u0001DC\u0011-Ii\tb!\t\u0006\u0004%\tAb1\t\u0011A-H1\u0011C\u0001![D\u0001\u0002%=\u0005\u0004\u0012\u0005\u00013\u001f\u0005\f!o$\u0019\t#b\u0001\n\u0003\u0001J\u0010C\u0006\u0011~\u0012\r\u0005R1A\u0005\u0002!%\u0005b\u0003I\u0000\t\u0007C)\u0019!C\u0001\r\u000bC1\"%\u0001\u0005\u0004\"\u0015\r\u0011\"\u0001\u0007D\"Y\u00113\u0001CB\u0011\u000b\u0007I\u0011\u0001Db\u0011-\t*\u0001b!\t\u0006\u0004%\tAb1\t\u0017E\u001dA1\u0011EC\u0002\u0013\u0005a1\u0019\u0005\f#\u0013!\u0019\t#b\u0001\n\u00031\u0019\rC\u0006\u0012\f\u0011\r\u0005R1A\u0005\u0002\u0019\r\u0007bCI\u0007\t\u0007C)\u0019!C\u0001\r\u0007D1\"e\u0004\u0005\u0004\"\u0015\r\u0011\"\u0001\u0007D\"Y\u0011\u0013\u0003CB\u0011\u000b\u0007I\u0011\u0001Db\u0011-\t\u001a\u0002b!\t\u0006\u0004%\t\u0001##\t\u0017EUA1\u0011EC\u0002\u0013\u0005a1\u0019\u0005\f#/!\u0019\t#b\u0001\n\u00031\u0019\rC\u0006\t\u0018\u0012\r\u0005R1A\u0005\u0002\u0019\r\u0007bCI\r\t\u0007C)\u0019!C\u0001\r\u0007D1\"e\u0007\u0005\u0004\"\u0015\r\u0011\"\u0001\u0007D\"Y\u0011S\u0004CB\u0011\u000b\u0007I\u0011\u0001Db\u0011-\tz\u0002b!\t\u0006\u0004%\tAb1\t\u0017E\u0005B1\u0011EC\u0002\u0013\u0005a1\u0019\u0005\f#G!\u0019\t#b\u0001\n\u00031\u0019\rC\u0006\u0012&\u0011\r\u0005R1A\u0005\u0002\u0019\r\u0007bCI\u0014\t\u0007C)\u0019!C\u0001\r_C1\"%\u000b\u0005\u0004\"\u0015\r\u0011\"\u0001\u0007\u0006\"Y\u00113\u0006CB\u0011\u000b\u0007I\u0011\u0001DC\u0011-\tj\u0003b!\t\u0006\u0004%\tA\"\"\t\u0017E=B1\u0011EC\u0002\u0013\u0005aQ\u0011\u0005\f\u0015'!\u0019\t#b\u0001\n\u00031)\tC\u0006\u00122\u0011\r\u0005R1A\u0005\u0002\u0019\r\u0007bCI\u001a\t\u0007C)\u0019!C\u0001\r\u000bC1\"%\u000e\u0005\u0004\"\u0015\r\u0011\"\u0001\u0007\u0006\"Y\u0011s\u0007CB\u0011\u000b\u0007I\u0011AD*\u0011-\tJ\u0004b!\t\u0006\u0004%\tA\"\"\t\u0017EmB1\u0011EC\u0002\u0013\u0005aQ\u0011\u0005\f#{!\u0019\t#b\u0001\n\u00031)\tC\u0006\u0012@\u0011\r\u0005R1A\u0005\u0002\u0019\u0015\u0005bCI!\t\u0007C)\u0019!C\u0001\r\u000bC1\"e\u0011\u0005\u0004\"\u0015\r\u0011\"\u0001\u0007\u0006\"Y\u0011S\tCB\u0011\u000b\u0007I\u0011\u0001DC\u0011-\t:\u0005b!\t\u0006\u0004%\tA\"\"\t\u0017%mG1\u0011EC\u0002\u0013\u0005aQ\u0011\u0005\f\u0013;$\u0019\t#b\u0001\n\u00031)\tC\u0006\u0012J\u0011\r\u0005R1A\u0005\u0002\u0019\u0015u\u0001CI&\t\u0007C\t!%\u0014\u0007\u0011EEC1\u0011E\u0001#'B\u0001b\"\u0003\u0006\u0016\u0011\u0005\u0011S\u000b\u0005\t\u0017\u0013,)\u0002\"\u0001\u0012X\u001dA\u00113\fCB\u0011\u0003\tjF\u0002\u0005\u0012`\u0011\r\u0005\u0012AI1\u0011!9I!\"\b\u0005\u0002E\r\u0004\u0002CFe\u000b;!\t!%\u001a\b\u0011E%D1\u0011E\u0001#W2\u0001\"%\u001c\u0005\u0004\"\u0005\u0011s\u000e\u0005\t\u000f\u0013))\u0003\"\u0001\u0012r!A1\u0012ZC\u0013\t\u0003\t\u001a\bC\u0006\u0012x\u0011\r\u0005R1A\u0005\u0002Ee\u0004bCI>\t\u0007C)\u0019!C\u0001\u0011\u0013C1\"% \u0005\u0004\"\u0015\r\u0011\"\u0003\u0007\u0006\"Q\u0011s\u0010CB\u0005\u0004%I!%!\t\u0013E\rE1\u0011Q\u0001\n\u0015=\u0007\u0002CIC\t\u0007#\t!e\"\t\u0017E-E1\u0011EC\u0002\u0013\u0005aQ\u0011\u0005\f#\u001b#\u0019\t#b\u0001\n\u00031)\tC\u0006\u0012\u0010\u0012\r\u0005R1A\u0005\u0002\u0019\u0015\u0005bCII\t\u0007C)\u0019!C\u0001\r\u000bC1\"e%\u0005\u0004\"\u0015\r\u0011\"\u0001\u0007\u0006\nYA)\u001a4j]&$\u0018n\u001c8t\u0015\u0011))%b\u0012\u0002\u0011%tG/\u001a:oC2TA!\"\u0013\u0006L\u00059!/\u001a4mK\u000e$(BAC'\u0003\u0015\u00198-\u00197b\u0007\u0001\u0019R\u0001AC*\u000b7\u0002B!\"\u0016\u0006X5\u0011Q1J\u0005\u0005\u000b3*YE\u0001\u0004B]f\u0014VM\u001a\t\u0005\u000b;*\u0019'\u0004\u0002\u0006`)!Q\u0011MC$\u0003\r\t\u0007/[\u0005\u0005\u000bK*yFA\nTi\u0006tG-\u0019:e\t\u00164\u0017N\\5uS>t7/\u0001\u0004%S:LG\u000f\n\u000b\u0003\u000bW\u0002B!\"\u0016\u0006n%!QqNC&\u0005\u0011)f.\u001b;\u0002\u0017\u0011,g-\u001b8ji&|gn\u001d\t\u0004\u000bk\u001aQ\"\u0001\u0001\u0003\u0017\u0011,g-\u001b8ji&|gn]\n\u0004\u0007\u0015m\u0004cAC;\t\n\u0001B)\u001a4j]&$\u0018n\u001c8t\u00072\f7o]\n\b\t\u0016MS\u0011QCD!\u0011))(b!\n\t\u0015\u0015U1\r\u0002\u000f\t\u00164\u0017N\\5uS>t7/\u00119j!\r))h\u0003\u0002\u0016-\u0006dW/Z\"mCN\u001cH)\u001a4j]&$\u0018n\u001c8t'\rYQ1K\u0001\r]\u0006lW\rV8XK&<\u0007\u000e^\u000b\u0003\u000b#\u0003\u0002\"b%\u0006\u001e\u0016\u0005V1V\u0007\u0003\u000b+SA!b&\u0006\u001a\u0006I\u0011.\\7vi\u0006\u0014G.\u001a\u0006\u0005\u000b7+Y%\u0001\u0006d_2dWm\u0019;j_:LA!b(\u0006\u0016\n\u0019Q*\u00199\u0011\t\u0015UT1U\u0005\u0005\u000bK+9K\u0001\u0003OC6,\u0017\u0002BCU\u000b\u0007\u0012QAT1nKN\u0004B!\"\u0016\u0006.&!QqVC&\u0005\rIe\u000e^\u0001\n]\u0006lW\rV8UC\u001e,\"!\".\u0011\u0011\u0015MUQTCQ\u000bo\u0003B!\"\u0016\u0006:&!Q1XC&\u0005\u0011\u0019\u0005.\u0019:\u0002!Y\fG.^3DY\u0006\u001c8oU=nE>dG\u0003BCa\u000b\u0017\u0004B!\"\u001e\u0006D&!QQYCd\u0005-\u0019E.Y:t'fl'm\u001c7\n\t\u0015%W1\t\u0002\b'fl'm\u001c7t\u0011\u001d)im\u0004a\u0001\u000b\u001f\fAA\\1nKB!QQOCi\u0013\u0011)\u0019.b*\u0003\u0011QK\b/\u001a(b[\u0016\f!b]=nE>d7/T1q+\u0011)I.\"?\u0015\r\u0015mg1\u0002D\u000f!!)i.b;\u0006p\u0016Uh\u0002BCp\u000bO\u0004B!\"9\u0006L5\u0011Q1\u001d\u0006\u0005\u000bK,y%\u0001\u0004=e>|GOP\u0005\u0005\u000bS,Y%\u0001\u0004Qe\u0016$WMZ\u0005\u0005\u000b?+iO\u0003\u0003\u0006j\u0016-\u0003\u0003BC;\u000bcLA!b=\u0006H\n11+_7c_2\u0004B!b>\u0006z2\u0001AaBC~!\t\u0007QQ \u0002\u0002)F!Qq D\u0003!\u0011))F\"\u0001\n\t\u0019\rQ1\n\u0002\b\u001d>$\b.\u001b8h!\u0011))Fb\u0002\n\t\u0019%Q1\n\u0002\u0004\u0003:L\bb\u0002D\u0007!\u0001\u0007aqB\u0001\u0005gfl7\u000f\u0005\u0004\u0007\u0012\u0019]Qq\u001e\b\u0005\u000b+2\u0019\"\u0003\u0003\u0007\u0016\u0015-\u0013a\u00029bG.\fw-Z\u0005\u0005\r31YB\u0001\u0003MSN$(\u0002\u0002D\u000b\u000b\u0017BqAb\b\u0011\u0001\u00041\t#A\u0001g!!))Fb\t\u0006\"\u0016U\u0018\u0002\u0002D\u0013\u000b\u0017\u0012\u0011BR;oGRLwN\\\u0019\u0002\u001dMLXNY8mg6\u000b\u0007OR5miV!a1\u0006D\u0019)!1iCb\r\u00076\u0019\u0005\u0003\u0003CCo\u000bW,yOb\f\u0011\t\u0015]h\u0011\u0007\u0003\b\u000bw\f\"\u0019AC\u007f\u0011\u001d1i!\u0005a\u0001\r\u001fAqAb\u000e\u0012\u0001\u00041I$A\u0001q!!))Fb\t\u0006\"\u001am\u0002\u0003BC+\r{IAAb\u0010\u0006L\t9!i\\8mK\u0006t\u0007b\u0002D\u0010#\u0001\u0007a1\t\t\t\u000b+2\u0019#\")\u00070\u0005I!m\u001c=fI:\u000bW.\u001a\u000b\u0005\r\u00132I\u0006\u0005\u0003\u0007L\u0019USB\u0001D'\u0015\u00111yE\"\u0015\u0002\t1\fgn\u001a\u0006\u0003\r'\nAA[1wC&!aq\u000bD'\u0005\u0019\u0019FO]5oO\"9QQ\u001a\nA\u0002\u0015\u0005\u0016\u0001C1cEJ4H+Y4\u0016\u0005\u0019}\u0003\u0003CCJ\u000b;+y/b.\u0002\u001b9,X.\u001a:jG^+\u0017n\u001a5u+\t1)\u0007\u0005\u0005\u0006^\u0016-Xq^CV\u0003-\u0011w\u000e_3e\u001b>$W\u000f\\3\u0016\u0005\u0019-\u0004\u0003CCo\u000bW,yO\"\u001c\u0011\t\u0015UdqN\u0005\u0005\rc*9M\u0001\u0007N_\u0012,H.Z*z[\n|G.\u0001\u0006c_b,Gm\u00117bgN,\"Ab\u001e\u0011\u0011\u0015uW1^Cx\u000b\u0003\f\u0001B]3g\u00072\f7o]\u0001\u0011m>d\u0017\r^5mKJ+gm\u00117bgN\f1\u0002\\1{s\"{G\u000eZ3sgV\u0011a\u0011\u0011\t\t\u000b;,Y/b<\u0006p\u0006aA*\u0019>z%\u001647\t\\1tgV\u0011Qq^\u0001\u000e\u0019\u0006T\u00180\u00168ji\u000ec\u0017m]:\u0002\u001b\u0005dGNU3g\u00072\f7o]3t+\t1i\t\u0005\u0004\u0006^\u001a=Uq^\u0005\u0005\r#+iOA\u0002TKR\f\u0011#[:Ok6,'/[2Tk\n\u001cE.Y:t)\u00191YDb&\u0007\u001c\"9a\u0011T\u000fA\u0002\u0015=\u0018aA:vE\"9aQT\u000fA\u0002\u0015=\u0018aA:va\u0006\u0019\u0012n\u001d(v[\u0016\u0014\u0018n\u0019,bYV,7\t\\1tgR!a1\bDR\u0011\u001d1)K\ba\u0001\u000b_\f1a]=n\u0003)I7oR3u\u00072\f7o\u001d\u000b\u0005\rw1Y\u000bC\u0004\u0007&~\u0001\r!b<\u0002\u0013Us\u0017\u000e^\"mCN\u001cXCACa\u0003%\u0011\u0015\u0010^3DY\u0006\u001c8/\u0001\u0006TQ>\u0014Ho\u00117bgN\f\u0011b\u00115be\u000ec\u0017m]:\u0002\u0011%sGo\u00117bgN\f\u0011\u0002T8oO\u000ec\u0017m]:\u0002\u0015\u0019cw.\u0019;DY\u0006\u001c8/A\u0006E_V\u0014G.Z\"mCN\u001c\u0018\u0001\u0004\"p_2,\u0017M\\\"mCN\u001c\u0018a\u0003\"p_2,\u0017M\\0b]\u0012,\"A\"2\u0011\t\u0015UdqY\u0005\u0005\r\u0013,9M\u0001\u0006UKJl7+_7c_2\f!BQ8pY\u0016\fgnX8s\u0003-\u0011un\u001c7fC:|fn\u001c;\u0002\u000fUs\u0017\u000e\u001e+qKV\u0011a1\u001b\t\u0005\u000bk2).\u0003\u0003\u0007X\u001ae'\u0001\u0002+za\u0016LAAb7\u0006D\t)A+\u001f9fg\u00069!)\u001f;f)B,\u0017\u0001C*i_J$H\u000b]3\u0002\u000f\rC\u0017M\u001d+qK\u00061\u0011J\u001c;Ua\u0016\fq\u0001T8oOR\u0003X-\u0001\u0005GY>\fG\u000f\u00169f\u0003%!u.\u001e2mKR\u0003X-\u0001\u0006C_>dW-\u00198Ua\u0016\f\u0001dU2bY\u0006tU/\\3sS\u000e4\u0016\r\\;f\u00072\f7o]3t+\t1\t\u0010\u0005\u0004\u0006\u0014\u001aMX\u0011Y\u0005\u0005\r3))*A\fTG\u0006d\u0017MV1mk\u0016\u001cE.Y:tKNtu.\u00168ji\u0006\t2kY1mCZ\u000bG.^3DY\u0006\u001c8/Z:\u0016\u0005\u0019m\bC\u0002D\t\r/)\t-\u0001\u000bTG\u0006d\u0017MV1mk\u0016\u001cE.Y:tKN\u001cV\r^\u000b\u0003\u000f\u0003\u00012ab\u0001;\u001b\u0005Y!!C*z[\n|GnU3u'\rQT1K\u0001\u0007y%t\u0017\u000e\u001e \u0015\t\u001d\u0005qQ\u0002\u0005\b\r\u001ba\u0004\u0019\u0001D\b\u0003\rIGm\u001d\t\u0007\u000b+:\u0019\"b<\n\t\u001dUQ1\n\u0002\u0006\u0003J\u0014\u0018-_\u0001\fG>lWn\u001c8Po:,'/\u0001\u0005d_:$\u0018-\u001b8t)\u00111Yd\"\b\t\u000f\u0019\u0015v\b1\u0001\u0006p\u0006Y2kY1mC:+X.\u001a:jGZ\u000bG.^3DY\u0006\u001c8/Z:TKR\f!dU2bY\u0006\u0004&/[7ji&4XMV1mk\u0016\u001cE.Y:tKN\fa#\u001e8eKJd\u00170\u001b8h\u001f\u001a4\u0016\r\\;f\u00072\f7o\u001d\u000b\u0005\r'<9\u0003C\u0004\b*\u0005\u0003\r!b<\u0002\u000b\rd\u0017M\u001f>\u0002oM\u001c\u0017\r\\1%e\u00164G.Z2uI%tG/\u001a:oC2$C)\u001a4j]&$\u0018n\u001c8tI\u0011\u001a\u0017\r^1tiJ|\u0007\u000f[5d\r\u0006LG.\u001e:f)\t)y0\u0001\u0018tG\u0006d\u0017\r\n:fM2,7\r\u001e\u0013j]R,'O\\1mI\u0011+g-\u001b8ji&|gn\u001d\u0013%G2\f7o]3t\u001b\u0006\u0004X\u0003BD\u001a\u000fs!Ba\"\u000e\b<AAQQ\\Cv\u000b_<9\u0004\u0005\u0003\u0006x\u001eeBaBC~\u0007\n\u0007QQ \u0005\b\r?\u0019\u0005\u0019AD\u001f!!))Fb\t\u0006\"\u001e]BCAC>\u00035I7/\u00138ji&\fG.\u001b>fIV\u0011a1H\u0001\u0012SNLe.\u001b;jC2L'0\u001a3`I\u0015\fH\u0003BC6\u000f\u0013B\u0011bb\u0013H\u0003\u0003\u0005\rAb\u000f\u0002\u0007a$\u0013'\u0001\bjg&s\u0017\u000e^5bY&TX\r\u001a\u0011\u00021%\u001cH)\u001a4j]&$\u0018n\u001c8t\u0013:LG/[1mSj,G-A\bKCZ\fG*\u00198h!\u0006\u001c7.Y4f+\t1i'\u0001\u000bKCZ\fG*\u00198h!\u0006\u001c7.Y4f\u00072\f7o]\u0001\r'\u000e\fG.\u0019)bG.\fw-Z\u0001\u0012'\u000e\fG.\u0019)bG.\fw-Z\"mCN\u001c\u0018A\u0004*v]RLW.\u001a)bG.\fw-Z\u0001\u0014%VtG/[7f!\u0006\u001c7.Y4f\u00072\f7o]\u0001\u0015U\u00064\u0018\rV=qKR{g+\u00197vK\u000ec\u0017m]:\u0015\t\u0015=x1\r\u0005\b\u000fK\u0002\u0006\u0019AD4\u0003\u0015QG/\u001f9fa\u00119Ig\"\u001d\u0011\r\u0015uw1ND8\u0013\u00119i'\"<\u0003\u000b\rc\u0017m]:\u0011\t\u0015]x\u0011\u000f\u0003\r\u000fg:\u0019'!A\u0001\u0002\u000b\u0005QQ \u0002\u0004?\u0012\n\u0014\u0001\u0006<bYV,7\t\\1tgR{'*\u0019<b)f\u0004X\r\u0006\u0003\bz\u001d\r\u0005\u0007BD>\u000f\u007f\u0002b!\"8\bl\u001du\u0004\u0003BC|\u000f\u007f\"1b\"!R\u0003\u0003\u0005\tQ!\u0001\u0006~\n\u0019q\f\n\u001a\t\u000f\u0019\u0015\u0016\u000b1\u0001\u0006p\u0006)b-\u001e7ms&s\u0017\u000e^5bY&TXmU=nE>dG\u0003BCx\u000f\u0013CqA\"*S\u0001\u0004)y/A\ngk2d\u00170\u00138ji&\fG.\u001b>f)f\u0004X\r\u0006\u0003\u0007T\u001e=\u0005bBDI'\u0002\u0007a1[\u0001\u0003iB\fACZ;mYfLe.\u001b;jC2L'0Z*d_B,G\u0003BDL\u000fC\u0003B!\"\u001e\b\u001a&!q1TDO\u0005\u0015\u00196m\u001c9f\u0013\u00119y*b\u0011\u0003\rM\u001bw\u000e]3t\u0011\u001d9\u0019\u000b\u0016a\u0001\u000f/\u000bQa]2pa\u0016\f\u0011#[:V]&4XM]:bY6+WNY3s)\u00111Yd\"+\t\u000f\u0019\u0015V\u000b1\u0001\u0006p\u0006q\u0011n]+oS6\u0004xN\u001d;bE2,G\u0003\u0002D\u001e\u000f_CqA\"*W\u0001\u0004)y/A\u000ejgVs\u0017.\u001c9peR\f'\r\\3V]2,7o\u001d*f]\u0006lW\r\u001a\u000b\u0005\rw9)\fC\u0004\u0007&^\u0003\r!b<\u0002\u0019%\u001c\u0018*\u001c9peR\f'\r\\3\u0015\t\u0019mr1\u0018\u0005\b\rKC\u0006\u0019ACx\u0003AI7\u000f\u0016:jm&\fG\u000eV8q)f\u0004X\r\u0006\u0003\u0007<\u001d\u0005\u0007bBDI3\u0002\u0007a1[\u0001\u000bSN,f.\u001b;UsB,G\u0003\u0002D\u001e\u000f\u000fDqa\"%[\u0001\u00041\u0019.\u0001\u0011iCNlU\u000f\u001c;ja2,gj\u001c8J[Bd\u0017nY5u!\u0006\u0014\u0018-\u001c'jgR\u001cH\u0003\u0002D\u001e\u000f\u001bDqab4\\\u0001\u0004)y/\u0001\u0004nK6\u0014WM\u001d\u000b\u0005\rw9\u0019\u000eC\u0004\bVr\u0003\rAb5\u0002\t%tgm\\\u0001\u0010M&DX\u000f]!t\u0003:LHK]1jiR!a1[Dn\u0011\u001d9i.\u0018a\u0001\r'\f1\u0001\u001e9f\u0003!\te._\"mCN\u001c\u0018aC!osJ+gm\u00117bgN,\"a\":\u0011\t\u0015Utq]\u0005\u0005\u000fS,9MA\bBY&\f7\u000fV=qKNKXNY8m\u0003-y%M[3di\u000ec\u0017m]:\u0002\u0013\u0005s\u0017PU3g)B,\u0017AB!osR\u0003X-A\u0005B]f4\u0016\r\u001c+qK\u0006a!i\u001c=fIVs\u0017\u000e\u001e+qK\u0006Qaj\u001c;iS:<G\u000b]3\u0002\u000f9+H\u000e\u001c+qK\u0006IqJ\u00196fGR$\u0006/Z\u0001\u0010'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.\u001a+qK\u0006I1\u000b\u001e:j]\u001e$\u0006/Z\u0001\r)\"\u0014xn^1cY\u0016$\u0006/Z\u0001\r\u0007>t7\u000f^1oiR\u0013X/Z\u000b\u0003\u0011\u000b\u0001B!\"\u001e\t\b%!\u0001\u0012\u0002Dm\u0005I)f.[9vK\u000e{gn\u001d;b]R$\u0016\u0010]3\u0002\u001b\r{gn\u001d;b]R4\u0015\r\\:f\u00031\u0019uN\\:uC:$h*\u001e7m\u0003-\te.\u001f,bY\u000ec\u0017m]:\u0002\u001f\u0005s\u0017PV1m?\u001e,Go\u00117bgN\f1CU;oi&lWMT8uQ&twm\u00117bgN\f\u0001CU;oi&lWMT;mY\u000ec\u0017m]:\u0003#\t{G\u000f^8n\u00072\f7o]*z[\n|GnE\u0002s\u000b\u0003\fa\u0001]1sK:$HC\u0002E\u0010\u0011GA)\u0003E\u0002\t\"Il\u0011\u0001\u0012\u0005\b\u000b\u001b,\b\u0019ACh\u0011\u001dAY\"\u001ea\u0001\u000b_\fQ\"[:C_R$x.\\\"mCN\u001c\u0018\u0001D5t)\"\u0014X-\u00193tC\u001a,G\u0003\u0002D\u001e\u0011[Aq\u0001c\fx\u0001\u0004A\t$A\u0004qkJ\u0004xn]3\u0011\t\u0015U\u00042G\u0005\u0005\u0011k)9MA\u0005Ts6\u0014w\u000e\\(qg&\u001a!/_?\u0003\u00199{G\u000f[5oO\u000ec\u0017m]:\u0014\u0007eDy\u0002\u0006\u0002\t@A\u0019\u0001\u0012E=\u0002\u0015%\u001c8+\u001e2DY\u0006\u001c8\u000f\u0006\u0003\u0007<!\u0015\u0003b\u0002E$w\u0002\u0007Qq^\u0001\u0005i\"\fGOA\u0005Ok2d7\t\\1tgN\u0019Q\u0010c\b\u0015\u0005!=\u0003c\u0001E\u0011{R!a1\bE*\u0011\u001dA9e a\u0001\u000b_\fABT8uQ&twm\u00117bgN\f\u0011BT;mY\u000ec\u0017m]:\u0002/\rc\u0017m]:DCN$X\t_2faRLwN\\\"mCN\u001c\u0018AH%oI\u0016Dx*\u001e;PM\n{WO\u001c3t\u000bb\u001cW\r\u001d;j_:\u001cE.Y:t\u0003yIeN^8dCRLwN\u001c+be\u001e,G/\u0012=dKB$\u0018n\u001c8DY\u0006\u001c8/A\bNCR\u001c\u0007.\u0012:s_J\u001cE.Y:t\u0003iquN\u001c'pG\u0006d'+\u001a;ve:\u001cuN\u001c;s_2\u001cE.Y:t\u0003eqU\u000f\u001c7Q_&tG/\u001a:Fq\u000e,\u0007\u000f^5p]\u000ec\u0017m]:\u0002\u001dQC'o\\<bE2,7\t\\1tg\u00069RK\\5oSRL\u0017\r\\5{K\u0012,%O]8s\u00072\f7o]\u0001\u0019\u00132dWmZ1m\u0003J<W\t_2faRLwN\\\"mCN\u001c\u0018!H+oS:LG/[1mSj,GMR5fY\u0012\u001cuN\\:ueV\u001cGo\u001c:\u0002)A\u000b'\u000f^5bY\u001a+hn\u0019;j_:\u001cE.Y:t\u0003q\t%m\u001d;sC\u000e$\b+\u0019:uS\u0006dg)\u001e8di&|gn\u00117bgN\f1bU=nE>d7\t\\1tg\u0006Y1\u000b\u001e:j]\u001e\u001cE.Y:t\u00031\u0019FO]5oO6{G-\u001e7f\u0003)\u0019E.Y:t\u00072\f7o]\u0001\u0010\u00072\f7o]0hKRlU\r\u001e5pI\u0006aA)\u001f8b[&\u001c7\t\\1tg\u0006Q1+_:QC\u000e\\\u0017mZ3\u0002\u0013MK8oX3se>\u0014\u0018AE+ocV\fG.\u001b4jK\u0012lu\u000eZ;mKN,\"\u0001#\"\u0011\r\u0015Me1\u001fD7\u0003E)f.];bY&4\u0017.\u001a3Po:,'o]\u000b\u0003\u0011\u0017\u0003b!b%\t\u000e\u0016=\u0018\u0002\u0002DI\u000b+\u000bA\u0002\u0015:fI\u00164Wj\u001c3vY\u0016\f\u0001\u0003\u0015:fI\u00164wl\u001e:ba\u0006\u0013(/Y=\u0015\t\u0019\u0015\u0007R\u0013\u0005\t\u000f#\u000by\u00031\u0001\u0007T\u0006I\u0002K]3eK\u001a|F%]7be.$\u0013/\\1sW\u0012\nX.\u0019:l\u00039\u0001&/\u001a3fM~cwnY1mYf\f1#[:Qe\u0016$WMZ'f[\n,'OT1nK\u0012$bAb\u000f\t \"\u0005\u0006\u0002\u0003DS\u0003k\u0001\r!b<\t\u0011\u00155\u0017Q\u0007a\u0001\u000bC\u000b1c\u00159fG&\fG.\u001b>bE2,Wj\u001c3vY\u0016\f!cU2bY\u0006\u0014VO\u001c+j[\u0016lu\u000eZ;mK\u0006a1+_7c_2lu\u000eZ;mK\u0006a1+_7c_2|\u0016\r\u001d9ms\u0006q1\u000b\u001e:j]\u001e\fE\rZ\"mCN\u001c\u0018\u0001E*dC2\fg*^7cKJ\u001cE.Y:t\u0003A!U\r\\1zK\u0012Le.\u001b;DY\u0006\u001c8/A\teK2\f\u00170\u001a3J]&$X*\u001a;i_\u0012\f1\u0003V=qK\u000e{gn\u001d;sC&tGo\u00117bgN\fabU5oO2,Go\u001c8DY\u0006\u001c8/A\tTKJL\u0017\r\\5{C\ndWm\u00117bgN\fQCS1wCN+'/[1mSj\f'\r\\3DY\u0006\u001c8/A\bD_6\u0004\u0018M]1cY\u0016\u001cE.Y:t\u0003IQ\u0015M^1DY>tW-\u00192mK\u000ec\u0017m]:\u0002\u001f)\u000bg/\u0019(v[\n,'o\u00117bgN\fQBS1wC\u0016sW/\\\"mCN\u001c\u0018\u0001\u0006*f[>$X-\u00138uKJ4\u0017mY3DY\u0006\u001c8/\u0001\u000bSK6|G/Z#yG\u0016\u0004H/[8o\u00072\f7o]\u0001\f\u0015\u00064\u0018-\u0016;jY6\u000b\u0007/A\bKCZ\fW\u000b^5m\u0011\u0006\u001c\b.T1q\u0003A\u0011\u0015PT1nKB\u000b'/Y7DY\u0006\u001c8/\u0001\fKCZ\f'+\u001a9fCR,G\rU1sC6\u001cE.Y:t\u0003I\u0011V\r]3bi\u0016$\u0007+\u0019:b[\u000ec\u0017m]:\u0002#%\u001c()\u001f(b[\u0016\u0004\u0016M]1n)f\u0004X\r\u0006\u0003\u0007<!U\u0007\u0002CDI\u0003K\u0002\rAb5\u00021%\u001c8kY1mCJ+\u0007/Z1uK\u0012\u0004\u0016M]1n)f\u0004X\r\u0006\u0003\u0007<!m\u0007\u0002CDI\u0003O\u0002\rAb5\u0002/%\u001c(*\u0019<b%\u0016\u0004X-\u0019;fIB\u000b'/Y7UsB,G\u0003\u0002D\u001e\u0011CD\u0001b\"%\u0002j\u0001\u0007a1[\u0001\u0014SN\u0014V\r]3bi\u0016$\u0007+\u0019:b[RK\b/\u001a\u000b\u0005\rwA9\u000f\u0003\u0005\b\u0012\u0006-\u0004\u0019\u0001Dj\u0003)I7OU3qK\u0006$X\r\u001a\u000b\u0005\rwAi\u000f\u0003\u0005\tp\u00065\u0004\u0019ACx\u0003\u0015\u0001\u0018M]1n\u0003!I7OQ=OC6,G\u0003\u0002D\u001e\u0011kD\u0001\u0002c<\u0002p\u0001\u0007Qq^\u0001\rSN\u001c\u0015m\u001d;Ts6\u0014w\u000e\u001c\u000b\u0005\rwAY\u0010\u0003\u0005\u0007&\u0006E\u0004\u0019ACx\u0003MI7OS1wCZ\u000b'/\u0011:hg6+G\u000f[8e)\u00111Y$#\u0001\t\u0011%\r\u00111\u000fa\u0001\u000b_\f\u0011!\\\u0001\u000eSNT\u0015M^1WCJ\f%oZ:\u0015\t\u0019m\u0012\u0012\u0002\u0005\t\u0013\u0017\t)\b1\u0001\n\u000e\u00051\u0001/\u0019:b[N\u0004bA\"\u0005\n\u0010\u0015=\u0018\u0002BE\t\r7\u00111aU3r\u00039I7oU2bY\u00064\u0016M]!sON$BAb\u000f\n\u0018!A\u00112BA<\u0001\u0004Ii!A\u0007jgZ\u000b'/\u0011:hg2K7\u000f\u001e\u000b\u0005\rwIi\u0002\u0003\u0005\n\f\u0005e\u0004\u0019AE\u0007\u00035I7OV1s\u0003J<G+\u001f9fgR!a1HE\u0012\u0011!I)#a\u001fA\u0002%\u001d\u0012a\u00024pe6\fGn\u001d\t\u0007\r#IyAb5\u0002\u001d\u0019L'o\u001d;QCJ\fW\u000eV=qKR!a1[E\u0017\u0011!9i.! A\u0002\u0019M\u0017!E5t\u00136\u0004H.[2jiB\u000b'/Y7tgR!a1HE\u001a\u0011!I)$a A\u0002%]\u0012a\u00029be\u0006l7o\u001d\t\u0007\r#19Bb\u0004\u0002!!\f7OU3qK\u0006$X\r\u001a)be\u0006lG\u0003\u0002D\u001e\u0013{A\u0001b\"%\u0002\u0002\u0002\u0007a1[\u0001\u000bIJ|\u0007OQ=OC6,G\u0003\u0002Dj\u0013\u0007B\u0001b\"%\u0002\u0004\u0002\u0007a1[\u0001\rIJ|\u0007OU3qK\u0006$X\r\u001a\u000b\u0005\r'LI\u0005\u0003\u0005\b\u0012\u0006\u0015\u0005\u0019\u0001Dj\u0003A\u0011X\r]3bi\u0016$Gk\\*j]\u001edW\r\u0006\u0003\u0007T&=\u0003\u0002CDI\u0003\u000f\u0003\rAb5\u0002\u001bI,\u0007/Z1uK\u0012$vnU3r)\u00111\u0019.#\u0016\t\u0011\u001dE\u0015\u0011\u0012a\u0001\r'\fQb]3r)>\u0014V\r]3bi\u0016$G\u0003\u0002Dj\u00137B\u0001b\"%\u0002\f\u0002\u0007a1[\u0001\u0011SN\u0014VMZ3sK:\u001cW-\u0011:sCf$BAb\u000f\nb!Aq\u0011SAG\u0001\u00041\u0019.A\bjg\u0006\u0013(/Y=PMNKXNY8m)\u00191Y$c\u001a\nj!Aq\u0011SAH\u0001\u00041\u0019\u000e\u0003\u0005\nl\u0005=\u0005\u0019ACx\u0003\u0011)G.Z7\u0002\u0017\u0015dW-\\3oiRK\b/\u001a\u000b\u0007\r'L\t(#\u001e\t\u0011%M\u0014\u0011\u0013a\u0001\u000b_\f\u0011bY8oi\u0006Lg.\u001a:\t\u0011\u001dE\u0015\u0011\u0013a\u0001\r'\f\u0011bQ8og\u000ec\u0017m]:\u0002\u001b%#XM]1u_J\u001cE.Y:t\u00035IE/\u001a:bE2,7\t\\1tg\u0006IA*[:u\u00072\f7o]\u0001\n\u0019&\u001cHoX2p]N\f\u0001bU3r\u00072\f7o]\u0001\u0017\u0015\u00064\u0018m\u0015;sS:<')^5mI\u0016\u00148\t\\1tg\u0006)\"*\u0019<b'R\u0014\u0018N\\4Ck\u001a4WM]\"mCN\u001c\u0018!\u0006&bm\u0006\u001c\u0005.\u0019:TKF,XM\\2f\u00072\f7o]\u0001\u0011)J\fg/\u001a:tC\ndWm\u00117bgN\f!\u0002T5ti6{G-\u001e7f\u0003)a\u0015n\u001d;`CB\u0004H._\u0001\n\u001d&dWj\u001c3vY\u0016\f\u0011bU3r\u001b>$W\u000f\\3\u0002\u0015%\u001bV-]'pIVdW-A\u0006BeJ\f\u00170T8ek2,\u0017aG!se\u0006LXj\u001c3vY\u0016|vN^3sY>\fG-\u001a3BaBd\u00170\u0001\rBeJ\f\u00170T8ek2,wlZ3oKJL7-\u00119qYf\f\u0011#\u0011:sCflu\u000eZ;mK~\u000b\u0007\u000f\u001d7z)\u0011)y/c(\t\u0011\u001dE\u0015q\u0017a\u0001\r'\f!\"\u0011:sCf\u001cE.Y:t\u0003-\t%O]1z?\u0006\u0004\b\u000f\\=\u0002\u0019\u0005\u0013(/Y=`kB$\u0017\r^3\u0002\u0019\u0005\u0013(/Y=`Y\u0016tw\r\u001e5\u0002\u0017\u0005\u0013(/Y=`G2|g.Z\u0001\u0013'>4GOU3gKJ,gnY3DY\u0006\u001c8/A\u0006NKRDw\u000eZ\"mCN\u001c\u0018!F#naRLX*\u001a;i_\u0012\u001c\u0015m\u00195f\u00072\f7o]\u0001\u0011\u001b\u0016$\bn\u001c3DC\u000eDWm\u00117bgN\f\u0001#\\3uQ>$7)Y2iK~3\u0017N\u001c3\u0002\u001f5,G\u000f[8e\u0007\u0006\u001c\u0007.Z0bI\u0012\f!c\u0015;sk\u000e$XO]1m\u0007\u0006dGnU5uK\u0006a2\u000b\u001e:vGR,(/\u00197DC2d7+\u001b;f?\n|w\u000e^:ue\u0006\u0004\u0018\u0001G*ueV\u001cG/\u001e:bY\u000e\u000bG\u000e\\*ji\u0016|F-^7nsV\u0011\u0011r\u0018\t\u0005\u000bkJ\t-\u0003\u0003\nD\u0016\u001d'\u0001D'fi\"|GmU=nE>d\u0017aF*ueV\u001cG/\u001e:bY\u000e\u000bG\u000e\\*ji\u0016|f-\u001b8e\u0003Y\u0019FO];diV\u0014\u0018\r\\\"bY2\u001c\u0016\u000e^3`C\u0012$\u0017\u0001J*ueV\u001cG/\u001e:bY\u000e\u000bG\u000e\\*ji\u0016|v-\u001a;QCJ\fW.\u001a;feRK\b/Z:\u0002\u001bMKXNY8m\u0019&$XM]1m\u0003]\u0019\u00160\u001c2pY2KG/\u001a:bY~\u0013wn\u001c;tiJ\f\u0007/A\nTs6\u0014w\u000e\u001c'ji\u0016\u0014\u0018\r\\0ek6l\u00170\u0001\tTG\u0006d\u0017\rW7m)>\u00048kY8qK\u0006y1kY1mCbkG\u000eU1dW\u0006<W-\u0001\bSK\u001adWm\u0019;QC\u000e\\\u0017mZ3\u0002#I+g\r\\3di\u0006\u0003\u0018\u000eU1dW\u0006<W-A\u000bSK\u001adWm\u0019;Sk:$\u0018.\\3QC\u000e\\\u0017mZ3\u0002-I+g\r\\3diJ+h\u000e^5nKVs\u0017N^3sg\u0016\f1DU3gY\u0016\u001cGOU;oi&lWmQ;se\u0016tG/T5se>\u0014\u0018!D+oSZ,'o]3DY\u0006\u001c8/\u0001\tV]&4XM]:f\u0013:$XM\u001d8bY\u0006)\u0002+\u0019:uS\u0006dW*\u00198jM\u0016\u001cH/T8ek2,\u0017!\u0005$vY2l\u0015M\\5gKN$8\t\\1tg\u0006\u0011b)\u001e7m\u001b\u0006t\u0017NZ3ti6{G-\u001e7f\u0003Ay\u0005\u000f^'b]&4Wm\u001d;DY\u0006\u001c8/\u0001\u0006O_6\u000bg.\u001b4fgR\f!\u0002\u0016:fKN\u001cE.Y:t\u0003))\u0005\u0010\u001d:t\u00072\f7o]\u0001\n\u000bb\u0004(o\u00117bgN\f!\"\u0012=qeN\u0003H.[2f\u0003%)\u0005\u0010\u001d:WC2,X-\u0001\bDY\u0006\u001c8\u000fV1h\u001b>$W\u000f\\3\u0002\u001b\rc\u0017m]:UC\u001e\u001cE.Y:t\u00035!\u0016\u0010]3UC\u001e\u001c8\t\\1tg\u0006\u0001\u0012\t]5V]&4XM]:f\u00072\f7o]\u0001\u0014\u0003BL\u0017+^1tSF,x\u000e^3t\u00072\f7o]\u0001\u0012\u0015\u00064\u0018-\u00168jm\u0016\u00148/Z\"mCN\u001c\u0018aC'jeJ|'o\u00117bgN\f\u0001\u0003V=qK\u000e\u0013X-\u0019;pe\u000ec\u0017m]:\u0002!Q\u0013X-Z\"sK\u0006$xN]\"mCN\u001c\u0018aC\"p]R,\u0007\u0010^03cA\nAC\u00117bG.\u0014w\u000e_\"p]R,\u0007\u0010^\"mCN\u001c\u0018\u0001F,iSR,'m\u001c=D_:$X\r\u001f;DY\u0006\u001c8/\u0001\nNC\u000e\u0014xnQ8oi\u0016DH\u000f\u0015:fM&D\u0018AF'bGJ|7i\u001c8uKb$\bK]3gSb$\u0016\u0010]3\u0002)5\u000b7M]8D_:$X\r\u001f;V]&4XM]:f\u0003Ui\u0015m\u0019:p\u0007>tG/\u001a=u\u000bb\u0004(o\u00117bgN\fA$T1de>\u001cuN\u001c;fqR<V-Y6UsB,G+Y4DY\u0006\u001c8/\u0001\u000bNC\u000e\u0014xnQ8oi\u0016DH\u000f\u0016:fKRK\b/Z\u0001\u0014\u001b\u0006\u001c'o\\%na2\feN\\8uCRLwN\\\u0001\u0013'R\u0014\u0018N\\4D_:$X\r\u001f;DY\u0006\u001c8/A\nTiJLgnZ\"p]R,\u0007\u0010^'pIVdW-A\bRk\u0006\u001c\u0018.];pi\u0016\u001cE.Y:t\u0003M\tV/Y:jcV|G/Z\"mCN\u001cx,\u00199j\u0003e\tV/Y:jcV|G/Z\"mCN\u001cx,\u00199j?\u0006\u0004\b\u000f\\=\u0016\u0005)%\"\u0003\u0002F\u0016\u000b_4aA#\f\u0001\u0001)%\"\u0001\u0004\u001fsK\u001aLg.Z7f]RtD\u0001\u0003F\u0019\u0015W\u0011\tAc\r\u0003%QK\b/Z(g\u00072|g.\u001a3Ts6\u0014w\u000e\\\t\u0005\u0015kQyD\u0005\u0004\u000b8\u0019\u0015'\u0012\b\u0004\u0007\u0015[\u0001\u0001A#\u000e\u0011\t\u0015U$2H\u0005\u0005\u0015{)9M\u0001\u0005O_NKXNY8m%\u0011Q\t%b<\u0007\r)5\u0002\u0001\u0001F \t!Q\tD#\u0011\u0003\u0002)\u0015\u0013\u0003\u0002F$\u000b_\u0014bA#\u0013\u0007F*ebA\u0002F\u0017\u0001\u0001Q9\u0005\u0002\u0005\u000bN)\u0005#\u0011\u0001F(\u0005!q\u0015-\\3UsB,\u0007\u0003BC;\u0015#JAAc\u0015\u0006(\nAA+\u001a:n\u001d\u0006lW\r\u0002\u0005\u000bN)-\"\u0011\u0001F(\u0003m\tV/Y:jcV|G/Z\"mCN\u001cx,\u00199j?Vt\u0017\r\u001d9msV\u0011!2\f\n\u0005\u0015;*yO\u0002\u0004\u000b.\u0001\u0001!2\f\u0003\t\u0015cQiF!\u0001\u000bbE!!2\rF4%\u0019Q)G\"2\u000b:\u00191!R\u0006\u0001\u0001\u0015G\u0012BA#\u001b\u0006p\u001a1!R\u0006\u0001\u0001\u0015O\"\u0001B#\r\u000bj\t\u0005!RN\t\u0005\u0015_*yO\u0005\u0004\u000br\u0019\u0015'\u0012\b\u0004\u0007\u0015[\u0001\u0001Ac\u001c\u0005\u0011)5#\u0012\u000eB\u0001\u0015\u001f\"\u0001B#\u0014\u000b^\t\u0005!rJ\u0001\u0019'\u000e\fG.Y*jO:\fG/\u001e:f\u0003:tw\u000e^1uS>t\u0017\u0001H*dC2\fGj\u001c8h'&<g.\u0019;ve\u0016\feN\\8uCRLwN\\\u0001\u0012\u001b\u0016$\bn\u001c3IC:$G.Z\"mCN\u001c\u0018A\u0004,be\"\u000bg\u000e\u001a7f\u00072\f7o]\u0001\f\u001fB$\u0018n\u001c8DY\u0006\u001c8/\u0001\u0007PaRLwN\\'pIVdW-A\u0005T_6,7\t\\1tg\u0006Qaj\u001c8f\u001b>$W\u000f\\3\u0002\u0015M{W.Z'pIVdW-A\nd_6\u0004\u0018\u000e\\3s)f\u0004XM\u0012:p[R\u000bw\r\u0006\u0003\u0007T*5\u0005\u0002\u0003FH\u0005\u0017\u0002\rA#%\u0002\u0005Q$\b\u0007\u0002FJ\u0015K\u0003bA#&\u000b\u001c*\r\u0006\u0003BC/\u0015/KAA#'\u0006`\tAQK\\5wKJ\u001cX-\u0003\u0003\u000b\u001e*}%aC,fC.$\u0016\u0010]3UC\u001eLAA#)\u0006`\tAA+\u001f9f)\u0006<7\u000f\u0005\u0003\u0006x*\u0015F\u0001\u0004FT\u0015\u001b\u000b\t\u0011!A\u0003\u0002\u0015u(\u0001B0%ea\nQcY8na&dWM]*z[\n|GN\u0012:p[R\u000bw\r\u0006\u0003\u0006p*5\u0006\u0002\u0003FH\u0005\u001b\u0002\rAc,1\t)E&R\u0017\t\u0007\u0015+SYJc-\u0011\t\u0015](R\u0017\u0003\r\u0015oSi+!A\u0001\u0002\u000b\u0005QQ \u0002\u0005?\u0012\u0012\u0014(\u0001\tjg*\u000bg/Y'bS:lU\r\u001e5pIR!a1\bF_\u0011!1)Ka\u0014A\u0002\u0015=\u0018!\u00055bg*\u000bg/Y'bS:lU\r\u001e5pIR!a1\bFb\u0011!1)K!\u0015A\u0002\u0015=(!\u0004,be\u0006\u0013\u0018\u000e^=DY\u0006\u001c8o\u0005\u0003\u0003T)%\u0007\u0003\u0002E\u0011\u0015\u0017LAA#4\u0006\u0004\n\u0001b+\u0019:Be&$\u0018p\u00117bgN\f\u0005/\u001b\t\u0005\u000b;T\t.\u0003\u0003\u0007X\u00155\u0018\u0001C7bq\u0006\u0013\u0018\u000e^=\u0002\u0013\r|WO\u001c;Ge>l\u0017\u0001B5oSR\u0004b!\"\u0016\u000b\\\u0016\u0005\u0017\u0002\u0002Fo\u000b\u0017\u0012aa\u00149uS>tGC\u0003Fq\u0015GT)Oc:\u000bjB!\u0001\u0012\u0005B*\u0011!)iM!\u0018A\u0002)=\u0007\u0002\u0003Fj\u0005;\u0002\r!b+\t\u0015)U'Q\fI\u0001\u0002\u0004)Y\u000b\u0003\u0006\u000bX\nu\u0003\u0013!a\u0001\u00153\faa\u001c4gg\u0016$XCACV\u0003\u001dygMZ:fi\u0002\n1\"[:EK\u001aLg.\u001a3BiR!a1\bF{\u0011!Q9Pa\u0019A\u0002\u0015-\u0016!A5\u0002\u0007M,\u0017/\u0006\u0002\u000b~B1a\u0011\u0003F\u0000\u000b\u0003LAa#\u0001\u0007\u001c\tQ\u0011J\u001c3fq\u0016$7+Z9\u0002\tM,\u0017\u000fI\u0001\u0007gfl7+\u001a;\u0016\u0005-%\u0001c\u0001E\u0011u\u000591/_7TKR\u0004C\u0003\u0002D\u001e\u0017\u001fA\u0001B\"*\u0003n\u0001\u0007Qq^\u0001\u0006CB\u0004H.\u001f\u000b\u0005\u000b_\\)\u0002\u0003\u0005\u000bx\n=\u0004\u0019ACV\u00031\u0019\b/Z2jM&\u001cG+\u001f9f)\u00191\u0019nc\u0007\f\"!A1R\u0004B9\u0001\u0004Yy\"\u0001\u0003be\u001e\u001c\bC\u0002D\t\r/1\u0019\u000e\u0003\u0006\f$\tE\u0004\u0013!a\u0001\u0017?\taa\u001c;iKJ\u001c\u0018AF:qK\u000eLg-[2UsB,G\u0005Z3gCVdG\u000f\n\u001a\u0016\u0005-%\"\u0006BF\u0010\u0017WY#a#\f\u0011\t-=2\u0012H\u0007\u0003\u0017cQAac\r\f6\u0005IQO\\2iK\u000e\\W\r\u001a\u0006\u0005\u0017o)Y%\u0001\u0006b]:|G/\u0019;j_:LAac\u000f\f2\t\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0002\u001bY\u000b'/\u0011:jif\u001cE.Y:t!\u0011A\tCa\u001e\u0014\t\t]T1\u000b\u000b\u0003\u0017\u007f\t1\u0004\n7fgNLg.\u001b;%OJ,\u0017\r^3sI\u0011,g-Y;mi\u0012\u001aTCAF%U\u0011)Ykc\u000b\u00027\u0011bWm]:j]&$He\u001a:fCR,'\u000f\n3fM\u0006,H\u000e\u001e\u00135+\tYyE\u000b\u0003\u000bZ.-\u0012!D'bqR+\b\u000f\\3Be&$\u00180\u0001\bNCb$V\u000f\u001d7f\u0003JLG/\u001f\u0011\u0002\u001f5\u000b\u0007\u0010\u0015:pIV\u001cG/\u0011:jif\f\u0001#T1y!J|G-^2u\u0003JLG/\u001f\u0011\u0002!5\u000b\u0007PR;oGRLwN\\!sSRL\u0018!E'bq\u001a+hn\u0019;j_:\f%/\u001b;zA\u0005AR*\u0019=UkBdW-\u0011:jif\u001c\u0006/Z2jC2L'0\u001a3\u000235\u000b\u0007\u0010V;qY\u0016\f%/\u001b;z'B,7-[1mSj,G\rI\u0001\u001b\u001b\u0006D\bK]8ek\u000e$\u0018I]5usN\u0003XmY5bY&TX\rZ\u0001\u001c\u001b\u0006D\bK]8ek\u000e$\u0018I]5usN\u0003XmY5bY&TX\r\u001a\u0011\u000275\u000b\u0007PR;oGRLwN\\!sSRL8\u000b]3dS\u0006d\u0017N_3e\u0003qi\u0015\r\u001f$v]\u000e$\u0018n\u001c8Be&$\u0018p\u00159fG&\fG.\u001b>fI\u0002\nA\u0002\u0015:pIV\u001cGo\u00117bgN,\"A#9\u0002\u0015Q+\b\u000f\\3DY\u0006\u001c8/A\u0007Gk:\u001cG/[8o\u00072\f7o]\u0001\u0016\u0003\n\u001cHO]1di\u001a+hn\u0019;j_:\u001cE.Y:t\u0003%!X\u000f\u001d7f)f\u0004X\r\u0006\u0003\u0007T.]\u0004\u0002CF=\u0005?\u0003\rac\b\u0002\u000b\u0015dW-\\:\u0002\u0019\u0019,hn\u0019;j_:$\u0016\u0010]3\u0015\r\u0019M7rPFA\u0011!I)C!)A\u0002-}\u0001\u0002CFB\u0005C\u0003\rAb5\u0002\rI,7\u000f\u001e9f\u0003Q\t'm\u001d;sC\u000e$h)\u001e8di&|g\u000eV=qKR1a1[FE\u0017\u0017C\u0001\"#\n\u0003$\u0002\u00071r\u0004\u0005\t\u0017\u0007\u0013\u0019\u000b1\u0001\u0007T\u0006\u0019rO]1q\u0003J\u0014\u0018-_'fi\"|GMT1nKR!!rJFI\u0011!Y\u0019J!*A\u0002\u0019M\u0017AB3mK6$\b/A\u0007jgR+\b\u000f\\3Ts6\u0014w\u000e\u001c\u000b\u0005\rwYI\n\u0003\u0005\u0007&\n\u001d\u0006\u0019ACx\u0003AI7OR;oGRLwN\\*z[\n|G\u000e\u0006\u0003\u0007<-}\u0005\u0002\u0003DS\u0005S\u0003\r!b<\u0002!%\u001c\bK]8ek\u000e$hjU=nE>dG\u0003\u0002D\u001e\u0017KC\u0001B\"*\u0003,\u0002\u0007Qq^\u0001\t)JL8\t\\1tg\u0006aa)Y5mkJ,7\t\\1tg\u0006a1+^2dKN\u001c8\t\\1tg\u0006Ya)\u001e;ve\u0016\u001cE.Y:t\u00031\u0001&o\\7jg\u0016\u001cE.Y:t\u00035quN\u001c$bi\u0006d7\t\\1tg\u0006\u0019RO\\:qK\u000eL\u0017\r\\5{K\u0012\u001c\u00160\u001c2pYR!Qq^F\\\u0011!1)K!/A\u0002\u0015=\u0018!F;ogB,7-[1mSj,G\rV=qK\u0006\u0013xm\u001d\u000b\u0005\u0017?Yi\f\u0003\u0005\b\u0012\nm\u0006\u0019\u0001Dj\u0003Ai\u0015m\u0019:p\u0007>tG/\u001a=u)f\u0004X\r\u0005\u0003\t\"\t}&\u0001E'bGJ|7i\u001c8uKb$H+\u001f9f'\u0011\u0011y,b\u0015\u0015\u0005-\u0005\u0017aB;oCB\u0004H.\u001f\u000b\u0005\u0017\u001b\\y\r\u0005\u0004\u0006V)mg1\u001b\u0005\t\u000f#\u0013\u0019\r1\u0001\u0007T\u0006\u0011\u0012n]'bGJ|7i\u001c8uKb$H+\u001f9f)\u00111Yd#6\t\u0011\u001dE%Q\u0019a\u0001\r'\fQ#[:XQ&$XMY8y\u0007>tG/\u001a=u)f\u0004X\r\u0006\u0003\u0007<-m\u0007\u0002CDI\u0005\u000f\u0004\rAb5\u0002)5\f7M]8Ck:$G.\u001a)be\u0006l\u0017J\u001c4p)\u00111\u0019n#9\t\u0011\u001dE%\u0011\u001aa\u0001\r'\f\u0001\u0004\\8pWNd\u0015n[3NC\u000e\u0014xNQ;oI2,G+\u001f9f)\u00111Ydc:\t\u0011\u001dE%1\u001aa\u0001\r'\f\u0011#[:NC\u000e\u0014xNQ;oI2,G+\u001f9f)\u00111Yd#<\t\u0011\u001dE%Q\u001aa\u0001\r'\f\u0011$[:CY\u0006\u001c7NY8y\u001b\u0006\u001c'o\u001c\"v]\u0012dW\rV=qKR!a1HFz\u0011!9\tJa4A\u0002\u0019M\u0017AC5t\u0019&\u001cH\u000fV=qKR!a1HF}\u0011!9\tJ!5A\u0002\u0019M\u0017AD5t\u0013R,'/\u00192mKRK\b/\u001a\u000b\u0005\rwYy\u0010\u0003\u0005\b\u0012\nM\u0007\u0019\u0001Dj\u0003QI7OR;oGRLwN\u001c+za\u0016$\u0015N]3diR!a1\bG\u0003\u0011!9\tJ!6A\u0002\u0019M\u0017!E5t)V\u0004H.\u001a+za\u0016$\u0015N]3diR!a1\bG\u0006\u0011!9\tJa6A\u0002\u0019M\u0017AD5t\rVt7\r^5p]RK\b/\u001a\u000b\u0005\rwa\t\u0002\u0003\u0005\b\u0012\ne\u0007\u0019\u0001Dj\u0003U1WO\\2uS>t\u0017I]5us\u001a\u0013x.\u001c+za\u0016$B!b+\r\u0018!Aq\u0011\u0013Bn\u0001\u00041\u0019.A\u000bgk:\u001cG/[8o\u001fJ\u001c\u0016-\\!sORK\b/Z:\u0015\t-}AR\u0004\u0005\t\u000f#\u0013i\u000e1\u0001\u0007T\u0006q2/Y7NCR\u001c\u0007.Z:Gk:\u001cG/[8o\u0005\u0006\u001cX\rZ(o\u0003JLG/\u001f\u000b\u0007\rwa\u0019\u0003d\n\t\u00111\u0015\"q\u001ca\u0001\u000b_\f1a]1n\u0011!I)Ca8A\u00021%\u0002C\u0002D\t\r/1)!A\u0006jgR+\b\u000f\\3UsB,G\u0003\u0002D\u001e\u0019_A\u0001b\"%\u0003b\u0002\u0007a1[\u0001\u0010iV\u0004H.Z\"p[B|g.\u001a8ugR!1r\u0004G\u001b\u0011!9\tJa9A\u0002\u0019M\u0017\u0001\u0005)s_\u0012,8\r\u001e*p_R\u001cE.Y:t\u0003Q\u0001&o\u001c3vGR|\u0006O]8ek\u000e$\u0018I]5us\u00061\u0002K]8ek\u000e$x\f\u001d:pIV\u001cG/\u00127f[\u0016tG/\u0001\tQe>$Wo\u0019;`SR,'/\u0019;pe\u0006)\u0002K]8ek\u000e$x\f\u001d:pIV\u001cG\u000f\u0015:fM&D\u0018\u0001\u0005)s_\u0012,8\r^0dC:,\u0015/^1m\u0003-\u0001(o\u001c3vGR\u0004&o\u001c6\u0015\r\u0019\u0015Gr\tG&\u0011!aIE!=A\u0002\u0015=\u0018!\u0001>\t\u001115#\u0011\u001fa\u0001\u000bW\u000b\u0011A[\u0001\u000fO\u0016$\bK]8ek\u000e$\u0018I]4t)\u0011Yy\u0002d\u0015\t\u0011\u001du'1\u001fa\u0001\r'D\u0003Ba=\rX1uC\u0012\r\t\u0005\u000b+bI&\u0003\u0003\r\\\u0015-#A\u00033faJ,7-\u0019;fI\u0006\u0012ArL\u0001\u000f]>\u0004Cn\u001c8hKJ\u0004So]3eC\ta\u0019'\u0001\u00043]E\nd\u0006M\u0001\u000ek:\f\u0007\u000f\u001d7z+:<(/\u00199\u0015\t\u0019MG\u0012\u000e\u0005\t\u000f;\u0014)\u00101\u0001\u0007T\"B!Q\u001fG,\u0019;b\t'A\tee>\u0004h*\u001e7mCJLX*\u001a;i_\u0012$BAb5\rr!Aq\u0011\u0013B|\u0001\u00041\u0019.A\bgS:\fGNU3tk2$H+\u001f9f)\u00111\u0019\u000ed\u001e\t\u0011\u001dE%\u0011 a\u0001\r'\f\u0001\"[:Ti\u0006\u0014G.\u001a\u000b\u0005\rwai\b\u0003\u0005\b\u0012\nm\b\u0019\u0001Dj\u0003)I7OV8mCRLG.\u001a\u000b\u0005\rwa\u0019\t\u0003\u0005\b\u0012\nu\b\u0019\u0001Dj\u0003I1x\u000e\\1uS2,'+Z2veNLwN\\:\u0002!A,g\u000eZ5oOZ{G.\u0019;jY\u0016\u001c\bC\u0002GF\u0019#+y/\u0004\u0002\r\u000e*!ArRCM\u0003\u001diW\u000f^1cY\u0016LA\u0001d%\r\u000e\n9\u0001*Y:i'\u0016$\u0018!\u00054v]\u000e$\u0018n\u001c8O\u0005\u0006\u001cX\rV=qKR!a1\u001bGM\u0011!9\tja\u0001A\u0002\u0019M\u0017!F5t!\u0006\u0014H/[1m\rVt7\r^5p]RK\b/\u001a\u000b\u0005\rway\n\u0003\u0005\b\u0012\u000e\u0015\u0001\u0019\u0001Dj\u0003\u0015!wnU1n\u0003\u0015\u0019\u0018-\\(g)\u0011)y\u000fd*\t\u0011\u001dE5\u0011\u0002a\u0001\r'\f\u0011\"\u0019:sCf$\u0016\u0010]3\u0015\t\u0019MGR\u0016\u0005\t\u0019_\u001bY\u00011\u0001\u0007T\u0006\u0019\u0011M]4\u0002\u0015\tLh*Y7f)f\u0004X\r\u0006\u0003\u0007T2U\u0006\u0002\u0003GX\u0007\u001b\u0001\rAb5\u0002\u001d%$XM]1u_J|e\rV=qKR!a1\u001bG^\u0011!9\tja\u0004A\u0002\u0019M\u0017\u0001\u00056bm\u0006\u0014V\r]3bi\u0016$G+\u001f9f)\u00111\u0019\u000e$1\t\u00111=6\u0011\u0003a\u0001\r'\f!b\u001c9uS>tG+\u001f9f)\u00111\u0019\u000ed2\t\u0011\u001dE51\u0003a\u0001\r'\f\u0011c]2bY\u0006\u0014V\r]3bi\u0016$G+\u001f9f)\u00111\u0019\u000e$4\t\u00111=6Q\u0003a\u0001\r'\fqa]3r)f\u0004X\r\u0006\u0003\u0007T2M\u0007\u0002\u0003GX\u0007/\u0001\rAb5\u0002%\u0015dW-\\3oiRK\b/\u001a$s_6<U\r\u001e\u000b\u0005\r'dI\u000e\u0003\u0005\b\u0012\u000ee\u0001\u0019\u0001Dj\u0003M)G.Z7f]R$\u0016\u0010]3Ge>l\u0007*Z1e)\u00111\u0019\u000ed8\t\u0011\u001dE51\u0004a\u0001\r'\fA#\u001a7f[\u0016tG\u000fV=qK\u001a\u0013x.\\!qa2LH\u0003\u0002Dj\u0019KD\u0001b\"%\u0004\u001e\u0001\u0007a1[\u0001\u0014K2,W.\u001a8u)f\u0004XM\u0012:p[\u0012\u0013x\u000e\u001d\u000b\u0005\r'dY\u000f\u0003\u0005\b\u0012\u000e}\u0001\u0019\u0001Dj\u0003=\u0011Xm];mi>3\u0017j]#naRLH\u0003\u0002Dj\u0019cD\u0001b\"%\u0004\"\u0001\u0007a1[\u0001\u0014if\u0004X-\u0011:h\u001f\u001a\u0014\u0015m]3UsB,wJ\u001d\u000b\u0007\u0019ol\u0019!$\u0002\u0015\t\u0019MG\u0012 \u0005\n\u0019w\u001c\u0019\u0003\"a\u0001\u0019{\f!a\u001c:\u0011\r\u0015UCr Dj\u0013\u0011i\t!b\u0013\u0003\u0011q\u0012\u0017P\\1nKzB\u0001b\"%\u0004$\u0001\u0007a1\u001b\u0005\t\u001b\u000f\u0019\u0019\u00031\u0001\u0006p\u0006I!-Y:f\u00072\f7o]\u0001\u0017e\u0016\u001cX\u000f\u001c;PM6\u000bGo\u00195j]\u001elU\r\u001e5pIR1QRBG\r\u001b7!BAb5\u000e\u0010!AQ\u0012CB\u0013\u0001\u0004i\u0019\"\u0001\u0006qCJ\fW\u000eV=qKN\u0004b!\"\u0016\u000e\u0016\u0019M\u0017\u0002BG\f\u000b\u0017\u0012!\u0002\u0010:fa\u0016\fG/\u001a3?\u0011!9\tj!\nA\u0002\u0019M\u0007\u0002CCg\u0007K\u0001\rAc\u0014\u0002\u0013\rc\u0017m]:UsB,G\u0003\u0002Dj\u001bCA\u0001\u0002d,\u0004(\u0001\u0007a1[\u0001\u0017]\u00164XM\u001d%bgRK\b/\u001a)be\u0006lW\r^3sgR!a1HG\u0014\u0011!1)k!\u000bA\u0002\u0015=\u0018\u0001C#ok6$\u0016\u0010]3\u0015\t\u0019MWR\u0006\u0005\t\rK\u001bY\u00031\u0001\u0006p\u0006!2\r\\1tg\u0016C\u0018n\u001d;f]RL\u0017\r\u001c+za\u0016$bAb5\u000e45]\u0002\u0002CG\u001b\u0007[\u0001\rAb5\u0002\rA\u0014XMZ5y\u0011!9Ic!\fA\u0002\u0015=\u0018AC!os~#S-\u001d\u0013fc\u0006a\u0011I\\=`I\t\fgn\u001a\u0013fc\u0006Q\u0011I\\=`KF,\u0018\r\\:\u0002\u0019\u0005s\u0017p\u00185bg\"\u001cu\u000eZ3\u0002\u0019\u0005s\u0017p\u0018;p'R\u0014\u0018N\\4\u0002\u001d\u0005s\u0017p\u0018\u0013iCNDG\u0005[1tQ\u0006a\u0011I\\=`O\u0016$8\t\\1tg\u0006\u0001\u0012I\\=`SNLen\u001d;b]\u000e,wJZ\u0001\u0011\u0003:Lx,Y:J]N$\u0018M\\2f\u001f\u001a\f\u0001\u0004\u001d:j[&$\u0018N^3HKR\u001cE.Y:t\u001b\u0016$\bn\u001c3t\u0003=9W\r^\"mCN\u001cX*\u001a;i_\u0012\u001c\u0018AE4fi\u000ec\u0017m]:SKR,(O\u001c+za\u0016$BAb5\u000eT!Aq\u0011SB#\u0001\u00041\u0019.\u0001\fsK6|g/\u001a*fIVtG-\u00198u\u001f\nTWm\u0019;t)\u0011Yy\"$\u0017\t\u00115m3q\ta\u0001\u0017?\t1\u0001\u001e9t\u0003EqwN]7bY&TX\r\u001a)be\u0016tGo\u001d\u000b\u0005\u0017?i\t\u0007\u0003\u0005\u000ed\r%\u0003\u0019AF\u0010\u0003\u001d\u0001\u0018M]3oiN\fQ\"\u00197m!\u0006\u0014\u0018-\\3uKJ\u001cH\u0003\u0002D\b\u001bSB\u0001b\"8\u0004L\u0001\u0007a1[\u0001\u0014if\u0004Xm\u0015;sS:<gj\u001c)bG.\fw-\u001a\u000b\u0005\r\u0013jy\u0007\u0003\u0005\b\u0012\u000e5\u0003\u0019\u0001Dj\u0003I\u0011'/[3g!\u0006\u0014XM\u001c;t'R\u0014\u0018N\\4\u0015\t)=WR\u000f\u0005\t\u001bG\u001ay\u00051\u0001\f \u0005i\u0001/\u0019:f]R\u001c8\u000b\u001e:j]\u001e$BAc4\u000e|!AQ2MB)\u0001\u0004Yy\"A\twC2,X\rU1sC6\u001c8\u000b\u001e:j]\u001e$BAc4\u000e\u0002\"Aq\u0011SB*\u0001\u00041\u0019.A\tPE*,7\r^0%Q\u0006\u001c\b\u000e\n5bg\"\fQb\u00142kK\u000e$x\fJ3rI\u0015\f\u0018aD(cU\u0016\u001cGo\u0018\u0013cC:<G%Z9\u0002\u0013=\u0013'.Z2u?\u0016\f\u0018!C(cU\u0016\u001cGo\u00188f\u0003My%M[3di~K7/\u00138ti\u0006t7-Z(g\u0003My%M[3di~\u000b7/\u00138ti\u0006t7-Z(g\u0003My%M[3di~\u001b\u0018P\\2ie>t\u0017N_3e\u00031\u0019FO]5oO~#\u0003\u000f\\;t\u0003=y%M[3di~;W\r^\"mCN\u001c\u0018\u0001D(cU\u0016\u001cGoX2m_:,\u0017aD(cU\u0016\u001cGo\u00184j]\u0006d\u0017N_3\u0002\u001b=\u0013'.Z2u?:|G/\u001b4z\u0003Ay%M[3di~sw\u000e^5gs\u0006cG.A\u0007PE*,7\r^0fcV\fGn]\u0001\u0010\u001f\nTWm\u0019;`Q\u0006\u001c\bnQ8eK\u0006yqJ\u00196fGR|Fo\\*ue&tw-\u0001\bPE*,7\r\u001e*fM\u000ec\u0017m]:\u0002-Y{G.\u0019;jY\u0016|%M[3diJ+gm\u00117bgN\fACU;oi&lWm\u0015;bi&\u001c7/T8ek2,\u0017A\u0005\"pq\u0016\u001c(+\u001e8US6,Wj\u001c3vY\u0016\f\u0011CQ8yKN\u0014VO\u001c+j[\u0016\u001cE.Y:t\u0003A\u0011u\u000e_3e\u001dVl'-\u001a:DY\u0006\u001c8/A\nC_b,Gm\u00115be\u0006\u001cG/\u001a:DY\u0006\u001c8/A\tC_b,GMQ8pY\u0016\fgn\u00117bgN\faBQ8yK\u0012\u0014\u0015\u0010^3DY\u0006\u001c8/A\bC_b,Gm\u00155peR\u001cE.Y:t\u00035\u0011u\u000e_3e\u0013:$8\t\\1tg\u0006q!i\u001c=fI2{gnZ\"mCN\u001c\u0018a\u0004\"pq\u0016$g\t\\8bi\u000ec\u0017m]:\u0002!\t{\u00070\u001a3E_V\u0014G.Z\"mCN\u001c\u0018A\u0004\"pq\u0016$WK\\5u\u00072\f7o]\u0001\u0010\u0005>DX\rZ+oSRlu\u000eZ;mK\u0006q!i\u001c=fIVs\u0017\u000e^0V\u001d&#\u0016A\u0004\"pq\u0016$WK\\5u?RK\u0006+R\u0001\u0010\u0003:tw\u000e^1uS>t7\t\\1tg\u0006A2\t\\1tg\u001aLG.Z!o]>$\u0018\r^5p]\u000ec\u0017m]:\u0002+M#\u0018\r^5d\u0003:tw\u000e^1uS>t7\t\\1tg\u00069\u0012I\u001c8pi\u0006$\u0018n\u001c8SKR,g\u000e^5p]\u0006#HO]\u0001\u001e\u0003:tw\u000e^1uS>t'+\u001a;f]RLwN\u001c)pY&\u001c\u00170\u0011;ue\u0006A\u0012I\u001c8pi\u0006$\u0018n\u001c8SKB,\u0017\r^1cY\u0016\fE\u000f\u001e:\u0002\u0017\t\u0013\u0018\u000eZ4f\u00072\f7o]\u0001\u0014\u000b2LG-\u00192mK6+G\u000f[8e\u00072\f7o]\u0001\u0016\u00136\u0004H.[2ji:{GOR8v]\u0012\u001cE.Y:t\u0003YIU\u000e\u001d7jG&$\u0018)\u001c2jOV|Wo]\"mCN\u001c\u0018\u0001G'jOJ\fG/[8o\u0003:tw\u000e^1uS>t7\t\\1tg\u0006\t2kY1mCN#(/[2u\rB\u000bE\u000f\u001e:\u0002\u0017M;\u0018\u000e^2i\u00072\f7o]\u0001\r)\u0006LGN]3d\u00072\f7o]\u0001\r-\u0006\u0014\u0018M]4t\u00072\f7o]\u0001\f\u001d><\u0018M\u001d8DY\u0006\u001c8/\u0001\u000bv]\u000eDWmY6fIN#\u0018M\u00197f\u00072\f7o]\u0001\u0017k:\u001c\u0007.Z2lK\u00124\u0016M]5b]\u000e,7\t\\1tg\u0006\u0001\")Z1o!J|\u0007/\u001a:us\u0006#HO]\u0001\u0018\u0005>|G.Z1o\u0005\u0016\fg\u000e\u0015:pa\u0016\u0014H/_!uiJ\f1cQ8na&dW\rV5nK>sG._!uiJ\fa\u0002R3qe\u0016\u001c\u0017\r^3e\u0003R$(/\u0001\nEKB\u0014XmY1uK\u0012t\u0015-\\3BiR\u0014\u0018!\u0007#faJ,7-\u0019;fI&s\u0007.\u001a:ji\u0006t7-Z!uiJ\f\u0001\u0004R3qe\u0016\u001c\u0017\r^3e\u001fZ,'O]5eS:<\u0017\t\u001e;s\u0003)q\u0015\r^5wK\u0006#HO]\u0001\u000b%\u0016lw\u000e^3BiR\u0014\u0018\u0001E*dC2\f\u0017J\u001c7j]\u0016\u001cE.Y:t\u0003I\u00196-\u00197b\u001d>Le\u000e\\5oK\u000ec\u0017m]:\u0002)M+'/[1m-\u0016\u00148/[8o+&#\u0015\t\u001e;s\u0003i\u0019VM]5bYZ+'o]5p]VKE)\u00118o_R\fG/[8o+\tqI\u0001\u0005\u0003\u0006v9-\u0011\u0002\u0002H\u0007\u001d\u001f\u0011a\"\u00118o_R\fG/[8o\u0013:4w.\u0003\u0003\u000f\u0012\u0015\r#aD!o]>$\u0018\r^5p]&sgm\\:\u0002!M\u0003XmY5bY&TX\rZ\"mCN\u001c\u0018a\u0003+ie><8o\u00117bgN\fQ\u0002\u0016:b]NLWM\u001c;BiR\u0014\u0018AD+oG\",7m[3e\u00072\f7o]\u0001\u0015+:\u001c\u0007.Z2lK\u0012\u0014u.\u001e8eg\u000ec\u0017m]:\u0002%Us7\u000f]3dS\u0006d\u0017N_3e\u00072\f7o]\u0001\r->d\u0017\r^5mK\u0006#HO]\u0001\u0013\u0015\u00064\u0018\rR3qe\u0016\u001c\u0017\r^3e\u0003R$(/\u0001\rGk:\u001cG/[8oC2Le\u000e^3sM\u0006\u001cWm\u00117bgN\fQCQ3b]\u001e+G\u000f^3s)\u0006\u0014x-\u001a;DY\u0006\u001c8/A\u000bCK\u0006t7+\u001a;uKJ$\u0016M]4fi\u000ec\u0017m]:\u0002!\u0019KW\r\u001c3UCJ<W\r^\"mCN\u001c\u0018!E$fiR,'\u000fV1sO\u0016$8\t\\1tg\u0006\u0001\u0002+\u0019:b[R\u000b'oZ3u\u00072\f7o]\u0001\u0012'\u0016$H/\u001a:UCJ<W\r^\"mCN\u001c\u0018!E(cU\u0016\u001cG\u000fV1sO\u0016$8\t\\1tg\u0006\u00012\t\\1tgR\u000b'oZ3u\u00072\f7o]\u0001\u0012\u001b\u0016$\bn\u001c3UCJ<W\r^\"mCN\u001c\u0018\u0001\u0006'b]\u001e,\u0018mZ3GK\u0006$XO]3B]:|G/\u0001\tK+:LG/\u00118o_R\fG/[8ogV\u0011aR\b\t\u0007\u000b'3\u00190b<\u0002+1\fgnZ;bO\u00164U-\u0019;ve\u0016lu\u000eZ;mK\u0006\u0001\u0012n]'fi\u0006\feN\\8uCRLwN\u001c\u000b\u0005\rwq)\u0005\u0003\u0005\u0007&\u0012\r\u0001\u0019ACx\u0003=iW\r^1B]:|G/\u0019;j_:\u001c\u0018a\u00063fM\u0006,H\u000e^!o]>$\u0018\r^5p]R\u000b'oZ3u)\u0011)yO$\u0014\t\u00119=Cq\u0001a\u0001\u001d#\n\u0011\u0001\u001e\t\u0005\u000bkr\u0019&\u0003\u0003\u000fV9]#\u0001\u0002+sK\u0016LAA$\u0017\u0006D\t)AK]3fg\u0006)\u0012I\u001c8pi\u0006$\u0018n\u001c8EK\u001a\fW\u000f\u001c;BiR\u0014\u0018A\u00054bi\u0006dW*[:tS:<7+_7c_2$\"\"b@\u000fb9\u0015dr\rH6\u0011!q\u0019\u0007b\u0003A\u0002\u0015=\u0018!B8x]\u0016\u0014\b\u0002CCg\t\u0017\u0001\r!\")\t\u00159%D1\u0002I\u0001\u0002\u0004Qy-\u0001\u0003xQ\u0006$\bB\u0003H7\t\u0017\u0001\n\u00111\u0001\u000bP\u0006A\u0011\r\u001a3f]\u0012,X.\u0001\u000fgCR\fG.T5tg&twmU=nE>dG\u0005Z3gCVdG\u000fJ\u001a\u0016\u00059M$\u0006\u0002Fh\u0017W\tADZ1uC2l\u0015n]:j]\u001e\u001c\u00160\u001c2pY\u0012\"WMZ1vYR$C'\u0001\nhKRd\u0015M\\4vC\u001e,g)Z1ukJ,GCBCx\u001dwri\b\u0003\u0005\u0006N\u0012E\u0001\u0019\u0001Fh\u0011)q\u0019\u0007\"\u0005\u0011\u0002\u0003\u0007Qq^\u0001\u001dO\u0016$H*\u00198hk\u0006<WMR3biV\u0014X\r\n3fM\u0006,H\u000e\u001e\u00133+\tq\u0019I\u000b\u0003\u0006p.-\u0012A\u0003;fe6lU-\u001c2feR1Qq\u001eHE\u001d\u0017C\u0001Bd\u0019\u0005\u0016\u0001\u0007Qq\u001e\u0005\t\u000b\u001b$)\u00021\u0001\u000bP\u0006ya-\u001b8e\u001d\u0006lW\rZ'f[\n,'\u000f\u0006\u0004\u0006p:EeR\u0013\u0005\t\u001d'#9\u00021\u0001\u0006\"\u0006Aa-\u001e7m\u001d\u0006lW\r\u0003\u0005\u000f\u0018\u0012]\u0001\u0019ACx\u0003\u0011\u0011xn\u001c;\u0015\r\u0015=h2\u0014HQ\u0011!qi\n\"\u0007A\u00029}\u0015\u0001B:fON\u0004bA\"\u0005\u0007\u0018\u0015\u0005\u0006\u0002\u0003HL\t3\u0001\r!b<\u0002\u0013\u001d,G/T3nE\u0016\u0014HCBCx\u001dOsI\u000b\u0003\u0005\u000fd\u0011m\u0001\u0019ACx\u0011!)i\rb\u0007A\u0002\u0015\u0005\u0016AD4fi6+WNY3s-\u0006dW/\u001a\u000b\u0007\r\u000btyK$-\t\u00119\rDQ\u0004a\u0001\u000b_D\u0001\"\"4\u0005\u001e\u0001\u0007Q\u0011U\u0001\u0010O\u0016$X*Z7cKJlu\u000eZ;mKR1aQ\u000eH\\\u001dsC\u0001Bd\u0019\u0005 \u0001\u0007Qq\u001e\u0005\t\u000b\u001b$y\u00021\u0001\u0006\"\u0006iq-\u001a;UsB,W*Z7cKJ$bAd0\u000fF:\u001d\u0007\u0003BC;\u001d\u0003LAAd1\u0006H\nQA+\u001f9f'fl'm\u001c7\t\u00119\rD\u0011\u0005a\u0001\u000b_D\u0001\"\"4\u0005\"\u0001\u0007Q\u0011U\u0001\u000fO\u0016$X*Z7cKJ\u001cE.Y:t)\u0019)\tM$4\u000fP\"Aa2\rC\u0012\u0001\u0004)y\u000f\u0003\u0005\u0006N\u0012\r\u0002\u0019ACQ\u0003=9W\r^'f[\n,'/T3uQ>$GC\u0002Dc\u001d+t9\u000e\u0003\u0005\u000fd\u0011\u0015\u0002\u0019ACx\u0011!)i\r\"\nA\u0002\u0015\u0005\u0016!D4fi\u0012+7\r\\'fi\"|G\r\u0006\u0004\u0007F:ugr\u001c\u0005\t\u001dG\"9\u00031\u0001\u0006p\"AQQ\u001aC\u0014\u0001\u0004)\t+\u0001\u0007hKR$Um\u00197WC2,X\r\u0006\u0004\u0007F:\u0015hr\u001d\u0005\t\u001dG\"I\u00031\u0001\u0006p\"AQQ\u001aC\u0015\u0001\u0004)\t+\u0001\u0007fe\u0006\u001cXO]3QQ\u0006\u001cX-\u0006\u0002\u000fnB!ar\u001eHy\u001b\t)\u0019%\u0003\u0003\u000ft\u0016\r#!\u0002)iCN,\u0017AE4fi6+WNY3s\u0013\u001a$UMZ5oK\u0012$b!b<\u000fz:m\b\u0002\u0003H2\t[\u0001\r!b<\t\u0011\u00155GQ\u0006a\u0001\u000bC\u000bqaZ3u\t\u0016\u001cG\u000e\u0006\u0004\u0006p>\u0005q2\u0001\u0005\t\u001dG\"y\u00031\u0001\u0006p\"AQQ\u001aC\u0018\u0001\u0004)\t+\u0001\thKR$Um\u00197JM\u0012+g-\u001b8fIR1Qq^H\u0005\u001f\u0017A\u0001Bd\u0019\u00052\u0001\u0007Qq\u001e\u0005\t\u000b\u001b$\t\u00041\u0001\u0006\"\u0006Aa.Z<BY&\f7\u000f\u0006\u0005\bf>Eq2CH\u000b\u0011!q\u0019\u0007b\rA\u0002\u0015=\b\u0002CCg\tg\u0001\r!b4\t\u0011=]A1\u0007a\u0001\r'\fQ!\u00197jCN\f\u0001c\u001d9fG&\fG\u000eU8ms\u000ec\u0017m]:\u0015\r=uqREH\u0014)\u0011)\tmd\b\t\u0011=\u0005BQ\u0007a\u0001\u001fG\t\u0001\u0002]1sK:$hI\u001c\t\t\u000b+2\u0019#b<\u0007T\"AQQ\u001aC\u001b\u0001\u0004)y\r\u0003\u0005\u0010*\u0011U\u0002\u0019AH\u0016\u0003\u00151G.Y4t!\u0011))f$\f\n\t==R1\n\u0002\u0005\u0019>tw-A\u0007oK^\u0004v\u000e\\=NKRDw\u000e\u001a\u000b\u000b\u001fkyIe$\u0014\u0010P=EC\u0003BE`\u001foA\u0001b$\u000f\u00058\u0001\u0007q2H\u0001\tGJ,\u0017\r^3G]B\u0019QQO\u0003\u0003#A{G._'fi\"|Gm\u0011:fCR|'\u000f\u0005\u0005\u0006V\u0019\rbqBH!!!))fd\u0011\u0010H\u0019M\u0017\u0002BH#\u000b\u0017\u0012a\u0001V;qY\u0016\u0014\u0004CBC+\u00157\\y\u0002\u0003\u0005\u0010L\u0011]\u0002\u0019ACV\u00039!\u0018\u0010]3QCJ\fWnQ8v]RD\u0001Bd\u0019\u00058\u0001\u0007Qq\u001e\u0005\t\u000b\u001b$9\u00041\u0001\u000bP!Aq\u0012\u0006C\u001c\u0001\u0004yY#\u0001\nf]R,'OT3x!>d\u00170T3uQ>$GCCH,\u001f7zifd\u0018\u0010bQ!\u0011rXH-\u0011!yI\u0004\"\u000fA\u0002=m\u0002\u0002CH&\ts\u0001\r!b+\t\u00119\rD\u0011\ba\u0001\u000b_D\u0001\"\"4\u0005:\u0001\u0007!r\n\u0005\t\u001fS!I\u00041\u0001\u0010,\u0005\u0011b.Z<Uc9+H\u000e\\1ss6+G\u000f[8e)!y9gd\u001b\u0010n==D\u0003BE`\u001fSB\u0001b$\u000f\u0005<\u0001\u0007q2\u0005\u0005\t\u001dG\"Y\u00041\u0001\u0006p\"AQQ\u001aC\u001e\u0001\u0004Qy\u0005\u0003\u0005\u0010*\u0011m\u0002\u0019AH\u0016\u0003])g\u000e^3s\u001d\u0016<H+\r(vY2\f'/_'fi\"|G\r\u0006\u0005\u0010v=et2PH?)\u0011Iyld\u001e\t\u0011=eBQ\ba\u0001\u001fGA\u0001Bd\u0019\u0005>\u0001\u0007Qq\u001e\u0005\t\u000b\u001b$i\u00041\u0001\u000bP!Aq\u0012\u0006C\u001f\u0001\u0004yY#A\toK^$\u0016GT5mCJLX*\u001a;i_\u0012$\u0002bd!\u0010\b>%u2\u0012\u000b\u0005\u0013\u007f{)\t\u0003\u0005\u0010:\u0011}\u0002\u0019AH\u0012\u0011!q\u0019\u0007b\u0010A\u0002\u0015=\b\u0002CCg\t\u007f\u0001\rAc\u0014\t\u0011=%Bq\ba\u0001\u001fW\ta#\u001a8uKJtUm\u001e+2\u001d&d\u0017M]=NKRDw\u000e\u001a\u000b\t\u001f#{)jd&\u0010\u001aR!\u0011rXHJ\u0011!yI\u0004\"\u0011A\u0002=\r\u0002\u0002\u0003H2\t\u0003\u0002\r!b<\t\u0011\u00155G\u0011\ta\u0001\u0015\u001fB\u0001b$\u000b\u0005B\u0001\u0007q2F\u0001\f]\u0016<H+M'fi\"|G\r\u0006\u0005\u0010 >\rvRUHT)\u0011Iyl$)\t\u0011=eB1\ta\u0001\u001fGA\u0001Bd\u0019\u0005D\u0001\u0007Qq\u001e\u0005\t\u000b\u001b$\u0019\u00051\u0001\u000bP!Aq\u0012\u0006C\"\u0001\u0004yY#\u0001\tf]R,'OT3x)FjU\r\u001e5pIRAqRVHY\u001fg{)\f\u0006\u0003\n@>=\u0006\u0002CH\u001d\t\u000b\u0002\rad\t\t\u00119\rDQ\ta\u0001\u000b_D\u0001\"\"4\u0005F\u0001\u0007!r\n\u0005\t\u001fS!)\u00051\u0001\u0010,\u0005q\u0011n\u001d)iC:$x.\\\"mCN\u001c\u0018\u0001F:z]RDW\r^5d\u0007>\u0014Xm\u00117bgN,7/\u0006\u0002\u0010>B1Q1\u0013Dz\u001f\u007f\u0013Ba$1\u000f@\u001a1!R\u0006\u0001\u0001\u001f\u007f#\u0001B#\r\u0010B\n\u0005qRY\t\u0005\u000b\u0003ty,\u0001\u000bts:$\b.\u001a;jG\u000e{'/Z'fi\"|Gm]\u000b\u0003\u001f\u0017\u0004b!b%\u0007t&}\u0016a\u00055jU\u0006\u001c7.\u001a3D_J,7\t\\1tg\u0016\u001c\u0018aG:z[\n|Gn\u001d(piB\u0013Xm]3oi&s')\u001f;fG>$W-\u0006\u0002\u0010TB1Q1\u0013Dz\u001f+\u0014Bad6\u0006p\u001a1!R\u0006\u0001\u0001\u001f+$\u0001B#\r\u0010X\n\u0005q2\\\t\u0005\u001f;|\tO\u0005\u0004\u0010`\u0016\u0005gQ\u0019\u0004\u0007\u0015[\u0001\u0001a$8\u0013\t=\rXq\u001e\u0004\u0007\u0015[\u0001\u0001a$9\u0005\u0011)Er2\u001dB\u0001\u001fO\fBa$;\u0010pB!QQKHv\u0013\u0011yi/b\u0013\u0003\t9+H\u000e\u001c\n\u0005\u001fc,yO\u0002\u0004\u000b.\u0001\u0001qr\u001e\u0003\t\u0015\u001bz\tP!\u0001\u0010vF!qr_CQ%\u0019yI0b4\u000bP\u00191!R\u0006\u0001\u0001\u001fo$\u0001B#\u0014\u0010d\n\u0005qR`\t\u0005\u001f\u007f\u0004\u001aA\u0005\u0004\u0011\u0002\u0015='r\n\u0004\u0007\u0015[\u0001\u0001ad@\u0013\tA\u0015Q\u0011\u0015\u0004\u0007\u0015[\u0001\u0001\u0001e\u0001\t\u0011A%\u0001S\u0001D\u0001!\u0017\tAA\\3yiV\u0011Q\u0011\u0015\u0003\t!\u001f\u0001*A!\u0001\u0010v\naA\u000b[5t\u001d\u0006lW\rV=qK\u0012A!RJHl\u0005\u0003\u0001\u001a\"\u0005\u0003\u0011\u0016Ae!C\u0002I\f\u000b\u001fTyE\u0002\u0004\u000b.\u0001\u0001\u0001S\u0003\n\u0005!7)\tK\u0002\u0004\u000b.\u0001\u0001\u0001\u0013\u0004\u0005\t!?\u0001ZB\"\u0001\u0011\"\u00059a.Z<OC6,G\u0003\u0002I\u0002!GA\u0001\u0002%\n\u0011\u001e\u0001\u0007!rZ\u0001\u0004gR\u0014\b\u0002\u0003I\u0015!71\t\u0001e\u000b\u0002\u000fM,(MT1nKR1\u00013\u0001I\u0017!cA\u0001\u0002e\f\u0011(\u0001\u0007Q1V\u0001\u0005MJ|W\u000e\u0003\u0005\u00114A\u001d\u0002\u0019ACV\u0003\t!x\u000e\u0003\u0005\u00118Ama\u0011\u0001I\u001d\u00035\u0019w.\u001c9b]&|gNT1nKV\u0011\u00013\b\n\u0005!{)\tK\u0002\u0004\u000b.\u0001\u0001\u00013\b\u0005\t!\u0013\u0001jD\"\u0001\u0011\f\u0011A\u0001s\u0002I\u001f\u0005\u0003\u0001\u001a%\u0005\u0003\u0011F\u0015\u0005&C\u0002I$\u0015\u001f*yM\u0002\u0004\u000b.\u0001\u0001\u0001S\t\u0005\t!\u0013\u0001ZB\"\u0001\u0011LU\u0011\u00013\u0001\u0003\t!\u001f\u0001ZB!\u0001\u0010~\u0006I\u0012n\u001d)pgNL'\r\\3Ts:$\b.\u001a;jGB\u000b'/\u001a8u\u0003Q\u0011w\u000e_3e-\u0006dW/Z\"mCN\u001cXm]*fi\u0006)\u0012n\u001d)sS6LG/\u001b<f-\u0006dW/Z\"mCN\u001cH\u0003\u0002D\u001e!/B\u0001B\"*\u0005V\u0001\u0007Qq^\u0001\u0015SN\u0004&/[7ji&4XMV1mk\u0016$\u0016\u0010]3\u0015\t\u0019m\u0002S\f\u0005\t\u000f##9\u00061\u0001\u0007T\u0006\t\u0012n\u001d\"pq\u0016$g+\u00197vK\u000ec\u0017m]:\u0015\t\u0019m\u00023\r\u0005\t\rK#I\u00061\u0001\u0006p\u0006\tRO\u001c2pq\u0016$g+\u00197vK\u000ec\u0017m]:\u0015\t\u0015=\b\u0013\u000e\u0005\t\rK#Y\u00061\u0001\u0006p\u0006\u0011\u0012n\u001d(v[\u0016\u0014\u0018n\u0019,bYV,G+\u001f9f)\u00111Y\u0004e\u001c\t\u0011\u001dEEQ\fa\u0001\r'\f!d\u00155po\u0006\u001b\u0018J\u001c4jq\u0006sgn\u001c;bi&|gn\u00117bgN\f\u0011b]5h]\u0006$XO]3\u0015\t)=\u0007s\u000f\u0005\t\u000f##\t\u00071\u0001\u0007T\n1RK\\5wKJ\u001cX\rR3qK:$WM\u001c;UsB,7o\u0005\u0003\u0005f\u0015M\u0013\u0001C;oSZ,'o]3\u0015\tA\u0005\u00053\u0011\t\u0005\u0011C!)\u0007\u0003\u0005\u0011~\u0011%\u0004\u0019\u0001H)\u0003!q\u0017-\\3UsB,\u0017\u0001C7pIN$\u0016\u0010]3\u0002\u0013\u0019d\u0017mZ:UsB,\u0017AC:z[\n|G\u000eV=qK\u0006AAO]3f)f\u0004X-A\u0006dCN,G)\u001a4UsB,\u0017\u0001\u00047jMR\f'\r\\3UsB,\u0017AD;oY&4G/\u00192mKRK\b/Z\u0001\u0011SR,'/\u00192mKR\u0013X-\u001a+za\u0016\fA\u0002\\5tiR\u0013X-\u001a+za\u0016\f\u0001\u0003\\5ti2K7\u000f\u001e+sK\u0016$\u0016\u0010]3\u0002%Ut\u0017N^3sg\u0016lU-\u001c2feRK\b/\u001a\u000b\u0005\r'\u0004z\n\u0003\u0005\u0006N\u0012\u0005\u0005\u0019ACh\u00059\u0011VO\u001c#fM&t\u0017\u000e^5p]N\u001cB\u0001b!\u0006TQ\u0011\u0001s\u0015\t\u0005\u0011C!\u0019)A\bTiJLgnZ!eI~#\u0003\u000f\\;t\u0003I\u0019FO]5oO~3\u0018\r\\;f\u001f\u001a|\u0016J\u001c;\u0002!%\u001c8\u000b\u001e:j]\u001e\fE\rZ5uS>tG\u0003\u0002D\u001e!cC\u0001B\"*\u0005\f\u0002\u0007Qq^\u0001\u0010'R\u0014\u0018N\\4D_:$X\r\u001f;`M\u0006y1\u000b\u001e:j]\u001e\u001cuN\u001c;fqR|6/A\tTiJLgnZ\"p]R,\u0007\u0010^0sC^\f1c\u0015;sS:<7i\u001c8uKb$x,\u00199qYf\fq\"\u0011:s_^\f5o]8d\u00072\f7o]\u0001\rSN\f%O]8x\u0003N\u001cxn\u0019\u000b\u0005\rw\u0001\n\r\u0003\u0005\u0007&\u0012]\u0005\u0019ACx\u0003Q\u0011u\u000e_3t?&\u001ch*^7cKJ|%OQ8pY\u0006q!i\u001c=fg~K7OT;nE\u0016\u0014\u0018a\u0005<bYV,7\t\\1tg\u000e{W\u000e]1oS>tG\u0003\u0002D7!\u0017D\u0001\"\"4\u0005\u001e\u0002\u0007!rJ\u0001\u0015m\u0006dW/Z\"p[B\fg.[8o\u001b\u0016l'-\u001a:\u0015\r\u0019\u0015\u0007\u0013\u001bIk\u0011!\u0001\u001a\u000eb(A\u0002\u0015\u0005\u0016!C2mCN\u001ch*Y7f\u0011!\u0001:\u000eb(A\u0002)=\u0013AC7fi\"|GMT1nK\u0006I!m\u001c=NKRDw\u000eZ\u000b\u0003!;\u0004\u0002\"\"8\u0006l\u0016=hQY\u0001\fk:\u0014w\u000e_'fi\"|G-A\u0004jgVs'm\u001c=\u0002\u000b%\u001c(i\u001c=\u0002\u0019=\u0003H/[8o?\u0006\u0004\b\u000f\\=\u0002!=\u0003H/[8o?&\u001cH)\u001a4j]\u0016$\u0017AC(qi&|gnX4fi\u0006Y\u0011n\u001d'jgR\f\u0005\u000f\u001d7z)\u00111Y\u0004e<\t\u0011\u0019\u0015Fq\u0017a\u0001\u000b_\fq\"[:Qe\u0016$WMZ\"mCN\u001cxJ\u001a\u000b\u0005\rw\u0001*\u0010\u0003\u0005\u0007&\u0012e\u0006\u0019ACx\u0003A!\u0016mZ'bi\u0016\u0014\u0018.\u00197ju\u0016\u00148/\u0006\u0002\u0011|BAQ1SCO\u000b_,y/\u0001\u0006UC\u001e\u001c\u00160\u001c2pYN\fq\u0002\u0015:fI\u00164wlY8oM>\u0014Xn]\u0001\u000f!J,G-\u001a4`G2\f7o](g\u0003Q\u0001&/\u001a3fM~#w.\u001e2mKJ\"u.\u001e2mK\u0006\u0011\u0002K]3eK\u001a|f\r\\8biJ2En\\1u\u0003A\u0001&/\u001a3fM~\u0013\u0017\u0010^33\u0005f$X-\u0001\nQe\u0016$WMZ0tQ>\u0014HOM*i_J$\u0018!\u0006)sK\u0012,gmX2iCJ\u00144\t[1sC\u000e$XM]\u0001\u0013!J,G-\u001a4`S:$('\u00138uK\u001e,'/\u0001\tQe\u0016$WMZ0m_:<'\u0007T8oO\u00061\u0002K]3eK\u001a|&m\\8mK\u0006t'GQ8pY\u0016\fg.\u0001\u000fQe\u0016$UMZ0qe&l\u0017\u000e^5wKN\u0014\u0004K]5nSRLg/Z:\u0002#A\u0013X\rZ3g?&l\u0007\u000f\\5dSRd\u00170A\nQe\u0016$WMZ0xe\u0006\u0004(+\u001a4BeJ\f\u00170\u0001\tbeJ\f\u00170\u00119qYflU\r\u001e5pI\u0006\t\u0012M\u001d:bsV\u0003H-\u0019;f\u001b\u0016$\bn\u001c3\u0002#\u0005\u0014(/Y=MK:<G\u000f['fi\"|G-\u0001\tbeJ\f\u0017p\u00117p]\u0016lU\r\u001e5pI\u00061RM\\:ve\u0016\f5mY3tg&\u0014G.Z'fi\"|G-\u0001\tbeJ\f\u0017p\u00117bgNlU\r\u001e5pI\u0006)BO]1wKJ\u001c\u0018M\u00197f\tJ|\u0007/T3uQ>$\u0017\u0001F$s_V\u0004xJZ*qK\u000eL\u0017\r\\5{C\ndW-\u0001\tXK\u0006\\G+\u001f9f)\u0006<7\t\\1tg\u0006\tr+Z1l)f\u0004X\rV1h\u001b>$W\u000f\\3\u0002\u0019QK\b/\u001a+bO\u000ec\u0017m]:\u0002\u001bQK\b/\u001a+bO6{G-\u001e7f\u0003Mi\u0017\r^3sS\u0006d\u0017N_3DY\u0006\u001c8\u000fV1h\u0003Yi\u0017\r^3sS\u0006d\u0017N_3XK\u0006\\G+\u001f9f)\u0006<\u0017AE7bi\u0016\u0014\u0018.\u00197ju\u0016$\u0016\u0010]3UC\u001e\f!#\u001a=qKJLW.\u001a8uC2lu\u000eZ;mK\u0006iQ*Y2s_N4U-\u0019;ve\u0016\fq\u0002R=oC6L7m\u001d$fCR,(/Z\u0001\u0012!>\u001cHOZ5y\u001fB\u001ch)Z1ukJ,\u0017A\u0006*fM2,7\r^5wK\u000e\u000bG\u000e\\:GK\u0006$XO]3\u00025%k\u0007\u000f\\5dSR\u001cuN\u001c<feNLwN\\:GK\u0006$XO]3\u0002%!Kw\r[3s\u0017&tGm\u001d$fCR,(/Z\u0001\u0014\u000bbL7\u000f^3oi&\fGn\u001d$fCR,(/Z\u0001\u0011\u0003BLWK\\5wKJ\u001cXMU3jMf\fQ\u0002\u0016:fKN$&/Z3UsB,\u0017\u0001\u0003+sK\u0016$\u0016\u0010]3\u0011\tE=SQC\u0007\u0003\t\u0007\u0013\u0001\u0002\u0016:fKRK\b/Z\n\u0005\u000b+)\u0019\u0006\u0006\u0002\u0012NQ!a1HI-\u0011!9i.\"\u0007A\u0002\u0019M\u0017aC*vER\u0014X-\u001a+za\u0016\u0004B!e\u0014\u0006\u001e\tY1+\u001e2ue\u0016,G+\u001f9f'\u0011)i\"b\u0015\u0015\u0005EuC\u0003\u0002D\u001e#OB\u0001b\"8\u0006\"\u0001\u0007a1[\u0001\f\u000bb\u0004(o\u00117bgN|e\r\u0005\u0003\u0012P\u0015\u0015\"aC#yaJ\u001cE.Y:t\u001f\u001a\u001cB!\"\n\u0006TQ\u0011\u00113\u000e\u000b\u0005\u0017\u001b\f*\b\u0003\u0005\b\u0012\u0016%\u0002\u0019\u0001Dj\u0003Q\u0001\u0016M\u001d;jC2l\u0015M\\5gKN$8\t\\1tgV\u0011arX\u0001\u0010\u001b\u0006t\u0017NZ3tiNKXNY8mg\u0006I\u0002k\u001c7z[>\u0014\b\u000f[5d'&<g.\u0019;ve\u0016\u001cE.Y:t\u0003a\u0001v\u000e\\=n_J\u0004\b.[2TS\u001et\u0017\r^;sK:\u000bW.Z\u000b\u0003\u000b\u001f\f\u0011\u0004U8ms6|'\u000f\u001d5jGNKwM\\1ukJ,g*Y7fA\u00051\u0012n\u001d)pYflwN\u001d9iS\u000e\u001c\u0016n\u001a8biV\u0014X\r\u0006\u0003\u0007<E%\u0005\u0002\u0003DS\u000bk\u0001\r!b<\u00023M\u001b\u0017\r\\1`\u0015\u00064\u0018\rO0D_6\u0004\u0018\r\u001e)bG.\fw-Z\u0001\f\rV$XO]3`k:LG/A\tGkR,(/Z0p]\u000e{W\u000e\u001d7fi\u0016\fABR;ukJ,wL^1mk\u0016\f\u0001\u0003\u0015:p[&\u001cXmX2p[BdW\r^3\u0015\u0005\u0015M\u0014!D3oi\u0016\u0014h*Z<DY\u0006\u001c8\u000f\u0006\u0006\u0006BFm\u0015STIP#CCqAd\u0019\u0007\u0001\u0004)y\u000fC\u0004\u0006N\u001a\u0001\r!b4\t\u000f5\rd\u00011\u0001\f !Iq\u0012\u0006\u0004\u0011\u0002\u0003\u0007q2F\u0001\u0018K:$XM\u001d(fo\u000ec\u0017m]:%I\u00164\u0017-\u001e7uIQ*\"!e*+\t=-22F\u0001\n]\u0016<X*\u001a;i_\u0012$B\"c0\u0012.F=\u0016\u0013WIZ#kCqAd\u0019\t\u0001\u0004)y\u000fC\u0004\u0006N\"\u0001\rAc\u0014\t\u000f%\u0015\u0002\u00021\u0001\f !912\u0011\u0005A\u0002\u0019M\u0007bBH\u0015\u0011\u0001\u0007q2F\u0001\u000fK:$XM\u001d(fo6+G\u000f[8e)1Iy,e/\u0012>F}\u0016\u0013YIb\u0011\u001dq\u0019'\u0003a\u0001\u000b_Dq!\"4\n\u0001\u0004Qy\u0005C\u0004\n&%\u0001\rac\b\t\u000f-\r\u0015\u00021\u0001\u0007T\"Iq\u0012F\u0005\u0011\u0002\u0003\u0007q2F\u0001\u0019K:$XM\u001d(fo6+G\u000f[8eI\u0011,g-Y;mi\u0012*\u0004\u0003\u0002Hx#\u0013LA!e3\u0006D\tY1+_7c_2$\u0016M\u00197f\u0001")
public interface Definitions
extends StandardDefinitions {
    @Override
    public Definitions$definitions$ definitions();

    public static /* synthetic */ Symbols.ClassSymbol scala$reflect$internal$Definitions$$enterNewClass$(Definitions $this, Symbols.Symbol owner, Names.TypeName name, List parents, long flags) {
        return $this.scala$reflect$internal$Definitions$$enterNewClass(owner, name, parents, flags);
    }

    default public Symbols.ClassSymbol scala$reflect$internal$Definitions$$enterNewClass(Symbols.Symbol owner, Names.TypeName name, List<Types.Type> parents, long flags) {
        Symbols.ClassSymbol clazz = owner.newClassSymbol(name, ((Positions)((Object)this)).NoPosition(), flags);
        return (Symbols.ClassSymbol)clazz.setInfoAndEnter(new Types.ClassInfoType((SymbolTable)this, parents, ((Scopes)((Object)this)).newScope(), clazz)).markAllCompleted();
    }

    public static /* synthetic */ long scala$reflect$internal$Definitions$$enterNewClass$default$4$(Definitions $this) {
        return $this.scala$reflect$internal$Definitions$$enterNewClass$default$4();
    }

    default public long scala$reflect$internal$Definitions$$enterNewClass$default$4() {
        return 0L;
    }

    private Symbols.MethodSymbol newMethod(Symbols.Symbol owner, Names.TermName name, List<Types.Type> formals, Types.Type restpe, long flags) {
        Symbols.MethodSymbol msym = owner.newMethod((Names.TermName)name.encode(), ((Positions)((Object)this)).NoPosition(), flags);
        List<Symbols.Symbol> params = msym.newSyntheticValueParams(formals);
        Types.MethodType info = owner.isJavaDefined() ? ((Types)((Object)this)).JavaMethodType(params, restpe) : new Types.MethodType((SymbolTable)this, params, restpe);
        return (Symbols.MethodSymbol)msym.setInfo(info).markAllCompleted();
    }

    public static /* synthetic */ Symbols.MethodSymbol scala$reflect$internal$Definitions$$enterNewMethod$(Definitions $this, Symbols.Symbol owner, Names.TermName name, List formals, Types.Type restpe, long flags) {
        return $this.scala$reflect$internal$Definitions$$enterNewMethod(owner, name, formals, restpe, flags);
    }

    default public Symbols.MethodSymbol scala$reflect$internal$Definitions$$enterNewMethod(Symbols.Symbol owner, Names.TermName name, List<Types.Type> formals, Types.Type restpe, long flags) {
        return owner.info().decls().enter(this.newMethod(owner, name, formals, restpe, flags));
    }

    public static /* synthetic */ long scala$reflect$internal$Definitions$$enterNewMethod$default$5$(Definitions $this) {
        return $this.scala$reflect$internal$Definitions$$enterNewMethod$default$5();
    }

    default public long scala$reflect$internal$Definitions$$enterNewMethod$default$5() {
        return 0L;
    }

    public static void $init$(Definitions $this) {
    }

    /*
     * Exception performing whole class analysis.
     */
    public abstract class DefinitionsClass
    implements StandardDefinitions.DefinitionsApi,
    ValueClassDefinitions {
        private Symbols.ModuleSymbol JavaLangPackage;
        private Symbols.ClassSymbol JavaLangPackageClass;
        private Symbols.ModuleSymbol ScalaPackage;
        private Symbols.ClassSymbol ScalaPackageClass;
        private Symbols.ModuleSymbol RuntimePackage;
        private Symbols.ClassSymbol RuntimePackageClass;
        private Symbols.ClassSymbol AnyClass;
        private Symbols.AliasTypeSymbol AnyRefClass;
        private Symbols.ClassSymbol ObjectClass;
        private Types.Type AnyRefTpe;
        private Types.Type AnyTpe;
        private Types.Type AnyValTpe;
        private Types.Type BoxedUnitTpe;
        private Types.Type NothingTpe;
        private Types.Type NullTpe;
        private Types.Type ObjectTpe;
        private Types.Type SerializableTpe;
        private Types.Type StringTpe;
        private Types.Type ThrowableTpe;
        private Types.UniqueConstantType ConstantTrue;
        private Types.UniqueConstantType ConstantFalse;
        private Types.UniqueConstantType ConstantNull;
        private Symbols.ClassSymbol AnyValClass;
        private Symbols.ClassSymbol RuntimeNothingClass;
        private Symbols.ClassSymbol RuntimeNullClass;
        private volatile Definitions$DefinitionsClass$NothingClass$ NothingClass$module;
        private volatile Definitions$DefinitionsClass$NullClass$ NullClass$module;
        private Symbols.ClassSymbol ClassCastExceptionClass;
        private Symbols.ClassSymbol IndexOutOfBoundsExceptionClass;
        private Symbols.ClassSymbol InvocationTargetExceptionClass;
        private Symbols.ClassSymbol MatchErrorClass;
        private Symbols.ClassSymbol NonLocalReturnControlClass;
        private Symbols.ClassSymbol NullPointerExceptionClass;
        private Symbols.ClassSymbol ThrowableClass;
        private Symbols.ClassSymbol UninitializedErrorClass;
        private Symbols.ClassSymbol IllegalArgExceptionClass;
        private Symbols.Symbol UninitializedFieldConstructor;
        private Symbols.ClassSymbol PartialFunctionClass;
        private Symbols.ClassSymbol AbstractPartialFunctionClass;
        private Symbols.ClassSymbol SymbolClass;
        private Symbols.ClassSymbol StringClass;
        private Symbols.Symbol StringModule;
        private Symbols.ClassSymbol ClassClass;
        private Symbols.ClassSymbol DynamicClass;
        private Symbols.ModuleSymbol SysPackage;
        private List<Symbols.ModuleSymbol> UnqualifiedModules;
        private Set<Symbols.Symbol> UnqualifiedOwners;
        private Symbols.ModuleSymbol PredefModule;
        private Symbols.ModuleSymbol SpecializableModule;
        private Symbols.ModuleSymbol ScalaRunTimeModule;
        private Symbols.ModuleSymbol SymbolModule;
        private Symbols.ClassSymbol StringAddClass;
        private Symbols.ClassSymbol ScalaNumberClass;
        private Symbols.ClassSymbol DelayedInitClass;
        private Symbols.ClassSymbol TypeConstraintClass;
        private Symbols.ClassSymbol SingletonClass;
        private Symbols.ClassSymbol SerializableClass;
        private Symbols.ClassSymbol JavaSerializableClass;
        private Symbols.ClassSymbol ComparableClass;
        private Symbols.ClassSymbol JavaCloneableClass;
        private Symbols.ClassSymbol JavaNumberClass;
        private Symbols.ClassSymbol JavaEnumClass;
        private Symbols.ClassSymbol RemoteInterfaceClass;
        private Symbols.ClassSymbol RemoteExceptionClass;
        private Symbols.ClassSymbol JavaUtilMap;
        private Symbols.ClassSymbol JavaUtilHashMap;
        private Symbols.ClassSymbol ByNameParamClass;
        private Symbols.ClassSymbol JavaRepeatedParamClass;
        private Symbols.ClassSymbol RepeatedParamClass;
        private Symbols.ClassSymbol ConsClass;
        private Symbols.ClassSymbol IteratorClass;
        private Symbols.ClassSymbol IterableClass;
        private Symbols.ClassSymbol ListClass;
        private Symbols.ClassSymbol SeqClass;
        private Symbols.ClassSymbol JavaStringBuilderClass;
        private Symbols.ClassSymbol JavaStringBufferClass;
        private Symbols.ClassSymbol JavaCharSequenceClass;
        private Symbols.ClassSymbol TraversableClass;
        private Symbols.ModuleSymbol ListModule;
        private Symbols.ModuleSymbol NilModule;
        private Symbols.ModuleSymbol SeqModule;
        private Symbols.ModuleSymbol ISeqModule;
        private Symbols.ModuleSymbol ArrayModule;
        private Symbols.TermSymbol ArrayModule_overloadedApply;
        private Symbols.ClassSymbol ArrayClass;
        private Symbols.TermSymbol Array_apply;
        private Symbols.TermSymbol Array_update;
        private Symbols.TermSymbol Array_length;
        private Symbols.TermSymbol Array_clone;
        private Symbols.ClassSymbol SoftReferenceClass;
        private Symbols.ClassSymbol MethodClass;
        private Symbols.ClassSymbol EmptyMethodCacheClass;
        private Symbols.ClassSymbol MethodCacheClass;
        private Symbols.Symbol StructuralCallSite;
        private Symbols.MethodSymbol StructuralCallSite_dummy;
        private Symbols.Symbol SymbolLiteral;
        private Symbols.Symbol ScalaXmlTopScope;
        private Symbols.Symbol ScalaXmlPackage;
        private Symbols.ModuleSymbol ReflectPackage;
        private Symbols.Symbol ReflectApiPackage;
        private Symbols.Symbol ReflectRuntimePackage;
        private Symbols.Symbol UniverseClass;
        private Symbols.ModuleSymbol PartialManifestModule;
        private Symbols.ClassSymbol FullManifestClass;
        private Symbols.ModuleSymbol FullManifestModule;
        private Symbols.ClassSymbol OptManifestClass;
        private Symbols.ModuleSymbol NoManifest;
        private Symbols.Symbol TreesClass;
        private Symbols.Symbol ExprsClass;
        private Symbols.ModuleSymbol ClassTagModule;
        private Symbols.ClassSymbol ClassTagClass;
        private Symbols.Symbol TypeTagsClass;
        private Symbols.Symbol ApiUniverseClass;
        private Symbols.Symbol ApiQuasiquotesClass;
        private Symbols.Symbol JavaUniverseClass;
        private Symbols.Symbol MirrorClass;
        private Symbols.Symbol TypeCreatorClass;
        private Symbols.Symbol TreeCreatorClass;
        private Symbols.Symbol BlackboxContextClass;
        private Symbols.Symbol WhiteboxContextClass;
        private Symbols.ClassSymbol MacroImplAnnotation;
        private Symbols.ClassSymbol StringContextClass;
        private Symbols.ModuleSymbol StringContextModule;
        private Symbols.Symbol QuasiquoteClass;
        private Symbols.Symbol QuasiquoteClass_api;
        private Symbols.Symbol QuasiquoteClass_api_apply;
        private Symbols.Symbol QuasiquoteClass_api_unapply;
        private Symbols.ClassSymbol ScalaSignatureAnnotation;
        private Symbols.ClassSymbol ScalaLongSignatureAnnotation;
        private Symbols.Symbol MethodHandleClass;
        private Symbols.Symbol VarHandleClass;
        private Symbols.ClassSymbol OptionClass;
        private Symbols.ModuleSymbol OptionModule;
        private Symbols.ClassSymbol SomeClass;
        private Symbols.ModuleSymbol NoneModule;
        private Symbols.ModuleSymbol SomeModule;
        private volatile Definitions$DefinitionsClass$VarArityClass$ VarArityClass$module;
        private VarArityClass ProductClass;
        private VarArityClass TupleClass;
        private VarArityClass FunctionClass;
        private VarArityClass AbstractFunctionClass;
        private Symbols.ClassSymbol TryClass;
        private Symbols.ClassSymbol FailureClass;
        private Symbols.ClassSymbol SuccessClass;
        private Symbols.ClassSymbol FutureClass;
        private Symbols.ClassSymbol PromiseClass;
        private Symbols.ClassSymbol NonFatalClass;
        private volatile Definitions$DefinitionsClass$MacroContextType$ MacroContextType$module;
        private Symbols.ClassSymbol ProductRootClass;
        private Symbols.MethodSymbol Any_$eq$eq;
        private Symbols.MethodSymbol Any_$bang$eq;
        private Symbols.MethodSymbol Any_equals;
        private Symbols.MethodSymbol Any_hashCode;
        private Symbols.MethodSymbol Any_toString;
        private Symbols.MethodSymbol Any_$hash$hash;
        private Symbols.MethodSymbol Any_getClass;
        private Symbols.MethodSymbol Any_isInstanceOf;
        private Symbols.MethodSymbol Any_asInstanceOf;
        private Set<Symbols.Symbol> primitiveGetClassMethods;
        private Set<Symbols.Symbol> getClassMethods;
        private Symbols.MethodSymbol Object_$hash$hash;
        private Symbols.MethodSymbol Object_$eq$eq;
        private Symbols.MethodSymbol Object_$bang$eq;
        private Symbols.MethodSymbol Object_eq;
        private Symbols.MethodSymbol Object_ne;
        private Symbols.MethodSymbol Object_isInstanceOf;
        private Symbols.MethodSymbol Object_asInstanceOf;
        private Symbols.MethodSymbol Object_synchronized;
        private Symbols.MethodSymbol String_$plus;
        private Symbols.ClassSymbol ObjectRefClass;
        private Symbols.ClassSymbol VolatileObjectRefClass;
        private Symbols.ModuleSymbol RuntimeStaticsModule;
        private Symbols.ModuleSymbol BoxesRunTimeModule;
        private Symbols.Symbol BoxesRunTimeClass;
        private Symbols.ClassSymbol BoxedNumberClass;
        private Symbols.ClassSymbol BoxedCharacterClass;
        private Symbols.ClassSymbol BoxedBooleanClass;
        private Symbols.ClassSymbol BoxedByteClass;
        private Symbols.ClassSymbol BoxedShortClass;
        private Symbols.ClassSymbol BoxedIntClass;
        private Symbols.ClassSymbol BoxedLongClass;
        private Symbols.ClassSymbol BoxedFloatClass;
        private Symbols.ClassSymbol BoxedDoubleClass;
        private Symbols.ClassSymbol BoxedUnitClass;
        private Symbols.ModuleSymbol BoxedUnitModule;
        private Symbols.ClassSymbol AnnotationClass;
        private Symbols.ClassSymbol ClassfileAnnotationClass;
        private Symbols.ClassSymbol StaticAnnotationClass;
        private Symbols.ClassSymbol AnnotationRetentionAttr;
        private Symbols.ClassSymbol AnnotationRetentionPolicyAttr;
        private Symbols.ClassSymbol AnnotationRepeatableAttr;
        private Symbols.ClassSymbol BridgeClass;
        private Symbols.ClassSymbol ElidableMethodClass;
        private Symbols.ClassSymbol ImplicitNotFoundClass;
        private Symbols.Symbol ImplicitAmbiguousClass;
        private Symbols.ClassSymbol MigrationAnnotationClass;
        private Symbols.ClassSymbol ScalaStrictFPAttr;
        private Symbols.ClassSymbol SwitchClass;
        private Symbols.ClassSymbol TailrecClass;
        private Symbols.ClassSymbol VarargsClass;
        private Symbols.Symbol NowarnClass;
        private Symbols.ClassSymbol uncheckedStableClass;
        private Symbols.ClassSymbol uncheckedVarianceClass;
        private Symbols.ClassSymbol BeanPropertyAttr;
        private Symbols.ClassSymbol BooleanBeanPropertyAttr;
        private Symbols.Symbol CompileTimeOnlyAttr;
        private Symbols.ClassSymbol DeprecatedAttr;
        private Symbols.ClassSymbol DeprecatedNameAttr;
        private Symbols.ClassSymbol DeprecatedInheritanceAttr;
        private Symbols.ClassSymbol DeprecatedOverridingAttr;
        private Symbols.ClassSymbol NativeAttr;
        private Symbols.ClassSymbol RemoteAttr;
        private Symbols.ClassSymbol ScalaInlineClass;
        private Symbols.ClassSymbol ScalaNoInlineClass;
        private Symbols.ClassSymbol SerialVersionUIDAttr;
        private AnnotationInfos.AnnotationInfo SerialVersionUIDAnnotation;
        private Symbols.ClassSymbol SpecializedClass;
        private Symbols.ClassSymbol ThrowsClass;
        private Symbols.ClassSymbol TransientAttr;
        private Symbols.ClassSymbol UncheckedClass;
        private Symbols.Symbol UncheckedBoundsClass;
        private Symbols.ClassSymbol UnspecializedClass;
        private Symbols.ClassSymbol VolatileAttr;
        private Symbols.ClassSymbol JavaDeprecatedAttr;
        private Symbols.ClassSymbol FunctionalInterfaceClass;
        private Symbols.ClassSymbol BeanGetterTargetClass;
        private Symbols.ClassSymbol BeanSetterTargetClass;
        private Symbols.ClassSymbol FieldTargetClass;
        private Symbols.ClassSymbol GetterTargetClass;
        private Symbols.ClassSymbol ParamTargetClass;
        private Symbols.ClassSymbol SetterTargetClass;
        private Symbols.ClassSymbol ObjectTargetClass;
        private Symbols.ClassSymbol ClassTargetClass;
        private Symbols.ClassSymbol MethodTargetClass;
        private Symbols.ClassSymbol LanguageFeatureAnnot;
        private List<Symbols.Symbol> JUnitAnnotations;
        private Symbols.ModuleSymbol languageFeatureModule;
        private Set<Symbols.Symbol> metaAnnotations;
        private Symbols.ClassSymbol AnnotationDefaultAttr;
        private Phase erasurePhase;
        private Set<Symbols.Symbol> isPhantomClass;
        private List<Symbols.TypeSymbol> syntheticCoreClasses;
        private List<Symbols.MethodSymbol> syntheticCoreMethods;
        private List<Symbols.ClassSymbol> hijackedCoreClasses;
        private List<Symbols.Symbol> symbolsNotPresentInBytecode;
        private Set<Symbols.Symbol> isPossibleSyntheticParent;
        private Set<Symbols.Symbol> boxedValueClassesSet;
        private Symbols.Symbol ShowAsInfixAnnotationClass;
        private boolean isInitialized;
        private final int MaxTupleArity;
        private final int MaxProductArity;
        private final int MaxFunctionArity;
        private final int MaxTupleAritySpecialized;
        private final int MaxProductAritySpecialized;
        private final int MaxFunctionAritySpecialized;
        private int volatileRecursions;
        private final HashSet<Symbols.Symbol> pendingVolatiles;
        private final boolean doSam;
        private final scala.collection.immutable.Map<Names.Name, Object> scala$reflect$internal$Definitions$ValueClassDefinitions$$nameToWeight;
        private final scala.collection.immutable.Map<Names.Name, Object> scala$reflect$internal$Definitions$ValueClassDefinitions$$nameToTag;
        private scala.collection.immutable.Map<Symbols.Symbol, Object> abbrvTag;
        private scala.collection.immutable.Map<Symbols.Symbol, Object> numericWeight;
        private scala.collection.immutable.Map<Symbols.Symbol, Symbols.ModuleSymbol> boxedModule;
        private scala.collection.immutable.Map<Symbols.Symbol, Symbols.ClassSymbol> boxedClass;
        private scala.collection.immutable.Map<Symbols.Symbol, Symbols.ClassSymbol> refClass;
        private scala.collection.immutable.Map<Symbols.Symbol, Symbols.ClassSymbol> volatileRefClass;
        private scala.collection.immutable.Map<Symbols.Symbol, Symbols.Symbol> lazyHolders;
        private Symbols.Symbol LazyRefClass;
        private Symbols.Symbol LazyUnitClass;
        private Set<Symbols.Symbol> allRefClasses;
        private Symbols.ClassSymbol UnitClass;
        private Symbols.ClassSymbol ByteClass;
        private Symbols.ClassSymbol ShortClass;
        private Symbols.ClassSymbol CharClass;
        private Symbols.ClassSymbol IntClass;
        private Symbols.ClassSymbol LongClass;
        private Symbols.ClassSymbol FloatClass;
        private Symbols.ClassSymbol DoubleClass;
        private Symbols.ClassSymbol BooleanClass;
        private Types.Type UnitTpe;
        private Types.Type ByteTpe;
        private Types.Type ShortTpe;
        private Types.Type CharTpe;
        private Types.Type IntTpe;
        private Types.Type LongTpe;
        private Types.Type FloatTpe;
        private Types.Type DoubleTpe;
        private Types.Type BooleanTpe;
        private List<Symbols.ClassSymbol> ScalaNumericValueClasses;
        private List<Symbols.ClassSymbol> ScalaValueClassesNoUnit;
        private List<Symbols.ClassSymbol> ScalaValueClasses;
        private ValueClassDefinitions.SymbolSet ScalaValueClassesSet;
        private ValueClassDefinitions.SymbolSet ScalaNumericValueClassesSet;
        private volatile long bitmap$0;
        private volatile long bitmap$1;
        private volatile long bitmap$2;
        private volatile long bitmap$3;
        private volatile long bitmap$4;
        public final /* synthetic */ SymbolTable $outer;

        @Override
        public boolean isNumericSubClass(Symbols.Symbol sub, Symbols.Symbol sup) {
            return ((ValueClassDefinitions)this).isNumericSubClass(sub, sup);
        }

        @Override
        public boolean isNumericValueClass(Symbols.Symbol sym) {
            return ((ValueClassDefinitions)this).isNumericValueClass(sym);
        }

        @Override
        public boolean isGetClass(Symbols.Symbol sym) {
            return ((ValueClassDefinitions)this).isGetClass(sym);
        }

        @Override
        public Symbols.TermSymbol Boolean_and() {
            return ((ValueClassDefinitions)this).Boolean_and();
        }

        @Override
        public Symbols.TermSymbol Boolean_or() {
            return ((ValueClassDefinitions)this).Boolean_or();
        }

        @Override
        public Symbols.TermSymbol Boolean_not() {
            return ((ValueClassDefinitions)this).Boolean_not();
        }

        @Override
        public List<Symbols.ClassSymbol> ScalaPrimitiveValueClasses() {
            return ((ValueClassDefinitions)this).ScalaPrimitiveValueClasses();
        }

        @Override
        public Types.Type underlyingOfValueClass(Symbols.Symbol clazz) {
            return ((ValueClassDefinitions)this).underlyingOfValueClass(clazz);
        }

        @Override
        public Nothing$ scala$reflect$internal$Definitions$$catastrophicFailure() {
            return ((ValueClassDefinitions)this).scala$reflect$internal$Definitions$$catastrophicFailure();
        }

        @Override
        public <T> scala.collection.immutable.Map<Symbols.Symbol, T> scala$reflect$internal$Definitions$$classesMap(Function1<Names.Name, T> f) {
            return ((ValueClassDefinitions)this).scala$reflect$internal$Definitions$$classesMap(f);
        }

        @Override
        public final Definitions$DefinitionsClass$NothingClass$ NothingClass() {
            if (this.NothingClass$module == null) {
                this.NothingClass$lzycompute$1();
            }
            return this.NothingClass$module;
        }

        @Override
        public final Definitions$DefinitionsClass$NullClass$ NullClass() {
            if (this.NullClass$module == null) {
                this.NullClass$lzycompute$1();
            }
            return this.NullClass$module;
        }

        public Definitions$DefinitionsClass$VarArityClass$ VarArityClass() {
            if (this.VarArityClass$module == null) {
                this.VarArityClass$lzycompute$1();
            }
            return this.VarArityClass$module;
        }

        public Definitions$DefinitionsClass$MacroContextType$ MacroContextType() {
            if (this.MacroContextType$module == null) {
                this.MacroContextType$lzycompute$1();
            }
            return this.MacroContextType$module;
        }

        @Override
        public scala.collection.immutable.Map<Names.Name, Object> scala$reflect$internal$Definitions$ValueClassDefinitions$$nameToWeight() {
            return this.scala$reflect$internal$Definitions$ValueClassDefinitions$$nameToWeight;
        }

        @Override
        public scala.collection.immutable.Map<Names.Name, Object> scala$reflect$internal$Definitions$ValueClassDefinitions$$nameToTag() {
            return this.scala$reflect$internal$Definitions$ValueClassDefinitions$$nameToTag;
        }

        private scala.collection.immutable.Map<Symbols.Symbol, Object> abbrvTag$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x10000000000000L) == 0L) {
                    this.abbrvTag = ((ValueClassDefinitions)this).abbrvTag();
                    this.bitmap$3 |= 0x10000000000000L;
                }
            }
            return this.abbrvTag;
        }

        @Override
        public scala.collection.immutable.Map<Symbols.Symbol, Object> abbrvTag() {
            if ((this.bitmap$3 & 0x10000000000000L) == 0L) {
                return this.abbrvTag$lzycompute();
            }
            return this.abbrvTag;
        }

        private scala.collection.immutable.Map<Symbols.Symbol, Object> numericWeight$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x20000000000000L) == 0L) {
                    this.numericWeight = ((ValueClassDefinitions)this).numericWeight();
                    this.bitmap$3 |= 0x20000000000000L;
                }
            }
            return this.numericWeight;
        }

        @Override
        public scala.collection.immutable.Map<Symbols.Symbol, Object> numericWeight() {
            if ((this.bitmap$3 & 0x20000000000000L) == 0L) {
                return this.numericWeight$lzycompute();
            }
            return this.numericWeight;
        }

        private scala.collection.immutable.Map<Symbols.Symbol, Symbols.ModuleSymbol> boxedModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x40000000000000L) == 0L) {
                    this.boxedModule = ((ValueClassDefinitions)this).boxedModule();
                    this.bitmap$3 |= 0x40000000000000L;
                }
            }
            return this.boxedModule;
        }

        @Override
        public scala.collection.immutable.Map<Symbols.Symbol, Symbols.ModuleSymbol> boxedModule() {
            if ((this.bitmap$3 & 0x40000000000000L) == 0L) {
                return this.boxedModule$lzycompute();
            }
            return this.boxedModule;
        }

        private scala.collection.immutable.Map<Symbols.Symbol, Symbols.ClassSymbol> boxedClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x80000000000000L) == 0L) {
                    this.boxedClass = ((ValueClassDefinitions)this).boxedClass();
                    this.bitmap$3 |= 0x80000000000000L;
                }
            }
            return this.boxedClass;
        }

        @Override
        public scala.collection.immutable.Map<Symbols.Symbol, Symbols.ClassSymbol> boxedClass() {
            if ((this.bitmap$3 & 0x80000000000000L) == 0L) {
                return this.boxedClass$lzycompute();
            }
            return this.boxedClass;
        }

        private scala.collection.immutable.Map<Symbols.Symbol, Symbols.ClassSymbol> refClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x100000000000000L) == 0L) {
                    this.refClass = ((ValueClassDefinitions)this).refClass();
                    this.bitmap$3 |= 0x100000000000000L;
                }
            }
            return this.refClass;
        }

        @Override
        public scala.collection.immutable.Map<Symbols.Symbol, Symbols.ClassSymbol> refClass() {
            if ((this.bitmap$3 & 0x100000000000000L) == 0L) {
                return this.refClass$lzycompute();
            }
            return this.refClass;
        }

        private scala.collection.immutable.Map<Symbols.Symbol, Symbols.ClassSymbol> volatileRefClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x200000000000000L) == 0L) {
                    this.volatileRefClass = ((ValueClassDefinitions)this).volatileRefClass();
                    this.bitmap$3 |= 0x200000000000000L;
                }
            }
            return this.volatileRefClass;
        }

        @Override
        public scala.collection.immutable.Map<Symbols.Symbol, Symbols.ClassSymbol> volatileRefClass() {
            if ((this.bitmap$3 & 0x200000000000000L) == 0L) {
                return this.volatileRefClass$lzycompute();
            }
            return this.volatileRefClass;
        }

        private scala.collection.immutable.Map<Symbols.Symbol, Symbols.Symbol> lazyHolders$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x400000000000000L) == 0L) {
                    this.lazyHolders = ((ValueClassDefinitions)this).lazyHolders();
                    this.bitmap$3 |= 0x400000000000000L;
                }
            }
            return this.lazyHolders;
        }

        @Override
        public scala.collection.immutable.Map<Symbols.Symbol, Symbols.Symbol> lazyHolders() {
            if ((this.bitmap$3 & 0x400000000000000L) == 0L) {
                return this.lazyHolders$lzycompute();
            }
            return this.lazyHolders;
        }

        private Symbols.Symbol LazyRefClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x800000000000000L) == 0L) {
                    this.LazyRefClass = ((ValueClassDefinitions)this).LazyRefClass();
                    this.bitmap$3 |= 0x800000000000000L;
                }
            }
            return this.LazyRefClass;
        }

        @Override
        public Symbols.Symbol LazyRefClass() {
            if ((this.bitmap$3 & 0x800000000000000L) == 0L) {
                return this.LazyRefClass$lzycompute();
            }
            return this.LazyRefClass;
        }

        private Symbols.Symbol LazyUnitClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x1000000000000000L) == 0L) {
                    this.LazyUnitClass = ((ValueClassDefinitions)this).LazyUnitClass();
                    this.bitmap$3 |= 0x1000000000000000L;
                }
            }
            return this.LazyUnitClass;
        }

        @Override
        public Symbols.Symbol LazyUnitClass() {
            if ((this.bitmap$3 & 0x1000000000000000L) == 0L) {
                return this.LazyUnitClass$lzycompute();
            }
            return this.LazyUnitClass;
        }

        private Set<Symbols.Symbol> allRefClasses$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x2000000000000000L) == 0L) {
                    this.allRefClasses = ((ValueClassDefinitions)this).allRefClasses();
                    this.bitmap$3 |= 0x2000000000000000L;
                }
            }
            return this.allRefClasses;
        }

        @Override
        public Set<Symbols.Symbol> allRefClasses() {
            if ((this.bitmap$3 & 0x2000000000000000L) == 0L) {
                return this.allRefClasses$lzycompute();
            }
            return this.allRefClasses;
        }

        private Symbols.ClassSymbol UnitClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x4000000000000000L) == 0L) {
                    this.UnitClass = ((ValueClassDefinitions)this).UnitClass();
                    this.bitmap$3 |= 0x4000000000000000L;
                }
            }
            return this.UnitClass;
        }

        @Override
        public Symbols.ClassSymbol UnitClass() {
            if ((this.bitmap$3 & 0x4000000000000000L) == 0L) {
                return this.UnitClass$lzycompute();
            }
            return this.UnitClass;
        }

        private Symbols.ClassSymbol ByteClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & Long.MIN_VALUE) == 0L) {
                    this.ByteClass = ((ValueClassDefinitions)this).ByteClass();
                    this.bitmap$3 |= Long.MIN_VALUE;
                }
            }
            return this.ByteClass;
        }

        @Override
        public Symbols.ClassSymbol ByteClass() {
            if ((this.bitmap$3 & Long.MIN_VALUE) == 0L) {
                return this.ByteClass$lzycompute();
            }
            return this.ByteClass;
        }

        private Symbols.ClassSymbol ShortClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 1L) == 0L) {
                    this.ShortClass = ((ValueClassDefinitions)this).ShortClass();
                    this.bitmap$4 |= 1L;
                }
            }
            return this.ShortClass;
        }

        @Override
        public Symbols.ClassSymbol ShortClass() {
            if ((this.bitmap$4 & 1L) == 0L) {
                return this.ShortClass$lzycompute();
            }
            return this.ShortClass;
        }

        private Symbols.ClassSymbol CharClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 2L) == 0L) {
                    this.CharClass = ((ValueClassDefinitions)this).CharClass();
                    this.bitmap$4 |= 2L;
                }
            }
            return this.CharClass;
        }

        @Override
        public Symbols.ClassSymbol CharClass() {
            if ((this.bitmap$4 & 2L) == 0L) {
                return this.CharClass$lzycompute();
            }
            return this.CharClass;
        }

        private Symbols.ClassSymbol IntClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 4L) == 0L) {
                    this.IntClass = ((ValueClassDefinitions)this).IntClass();
                    this.bitmap$4 |= 4L;
                }
            }
            return this.IntClass;
        }

        @Override
        public Symbols.ClassSymbol IntClass() {
            if ((this.bitmap$4 & 4L) == 0L) {
                return this.IntClass$lzycompute();
            }
            return this.IntClass;
        }

        private Symbols.ClassSymbol LongClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 8L) == 0L) {
                    this.LongClass = ((ValueClassDefinitions)this).LongClass();
                    this.bitmap$4 |= 8L;
                }
            }
            return this.LongClass;
        }

        @Override
        public Symbols.ClassSymbol LongClass() {
            if ((this.bitmap$4 & 8L) == 0L) {
                return this.LongClass$lzycompute();
            }
            return this.LongClass;
        }

        private Symbols.ClassSymbol FloatClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 0x10L) == 0L) {
                    this.FloatClass = ((ValueClassDefinitions)this).FloatClass();
                    this.bitmap$4 |= 0x10L;
                }
            }
            return this.FloatClass;
        }

        @Override
        public Symbols.ClassSymbol FloatClass() {
            if ((this.bitmap$4 & 0x10L) == 0L) {
                return this.FloatClass$lzycompute();
            }
            return this.FloatClass;
        }

        private Symbols.ClassSymbol DoubleClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 0x20L) == 0L) {
                    this.DoubleClass = ((ValueClassDefinitions)this).DoubleClass();
                    this.bitmap$4 |= 0x20L;
                }
            }
            return this.DoubleClass;
        }

        @Override
        public Symbols.ClassSymbol DoubleClass() {
            if ((this.bitmap$4 & 0x20L) == 0L) {
                return this.DoubleClass$lzycompute();
            }
            return this.DoubleClass;
        }

        private Symbols.ClassSymbol BooleanClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 0x40L) == 0L) {
                    this.BooleanClass = ((ValueClassDefinitions)this).BooleanClass();
                    this.bitmap$4 |= 0x40L;
                }
            }
            return this.BooleanClass;
        }

        @Override
        public Symbols.ClassSymbol BooleanClass() {
            if ((this.bitmap$4 & 0x40L) == 0L) {
                return this.BooleanClass$lzycompute();
            }
            return this.BooleanClass;
        }

        private Types.Type UnitTpe$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 0x80L) == 0L) {
                    this.UnitTpe = ((ValueClassDefinitions)this).UnitTpe();
                    this.bitmap$4 |= 0x80L;
                }
            }
            return this.UnitTpe;
        }

        @Override
        public Types.Type UnitTpe() {
            if ((this.bitmap$4 & 0x80L) == 0L) {
                return this.UnitTpe$lzycompute();
            }
            return this.UnitTpe;
        }

        private Types.Type ByteTpe$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 0x100L) == 0L) {
                    this.ByteTpe = ((ValueClassDefinitions)this).ByteTpe();
                    this.bitmap$4 |= 0x100L;
                }
            }
            return this.ByteTpe;
        }

        @Override
        public Types.Type ByteTpe() {
            if ((this.bitmap$4 & 0x100L) == 0L) {
                return this.ByteTpe$lzycompute();
            }
            return this.ByteTpe;
        }

        private Types.Type ShortTpe$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 0x200L) == 0L) {
                    this.ShortTpe = ((ValueClassDefinitions)this).ShortTpe();
                    this.bitmap$4 |= 0x200L;
                }
            }
            return this.ShortTpe;
        }

        @Override
        public Types.Type ShortTpe() {
            if ((this.bitmap$4 & 0x200L) == 0L) {
                return this.ShortTpe$lzycompute();
            }
            return this.ShortTpe;
        }

        private Types.Type CharTpe$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 0x400L) == 0L) {
                    this.CharTpe = ((ValueClassDefinitions)this).CharTpe();
                    this.bitmap$4 |= 0x400L;
                }
            }
            return this.CharTpe;
        }

        @Override
        public Types.Type CharTpe() {
            if ((this.bitmap$4 & 0x400L) == 0L) {
                return this.CharTpe$lzycompute();
            }
            return this.CharTpe;
        }

        private Types.Type IntTpe$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 0x800L) == 0L) {
                    this.IntTpe = ((ValueClassDefinitions)this).IntTpe();
                    this.bitmap$4 |= 0x800L;
                }
            }
            return this.IntTpe;
        }

        @Override
        public Types.Type IntTpe() {
            if ((this.bitmap$4 & 0x800L) == 0L) {
                return this.IntTpe$lzycompute();
            }
            return this.IntTpe;
        }

        private Types.Type LongTpe$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 0x1000L) == 0L) {
                    this.LongTpe = ((ValueClassDefinitions)this).LongTpe();
                    this.bitmap$4 |= 0x1000L;
                }
            }
            return this.LongTpe;
        }

        @Override
        public Types.Type LongTpe() {
            if ((this.bitmap$4 & 0x1000L) == 0L) {
                return this.LongTpe$lzycompute();
            }
            return this.LongTpe;
        }

        private Types.Type FloatTpe$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 0x2000L) == 0L) {
                    this.FloatTpe = ((ValueClassDefinitions)this).FloatTpe();
                    this.bitmap$4 |= 0x2000L;
                }
            }
            return this.FloatTpe;
        }

        @Override
        public Types.Type FloatTpe() {
            if ((this.bitmap$4 & 0x2000L) == 0L) {
                return this.FloatTpe$lzycompute();
            }
            return this.FloatTpe;
        }

        private Types.Type DoubleTpe$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 0x4000L) == 0L) {
                    this.DoubleTpe = ((ValueClassDefinitions)this).DoubleTpe();
                    this.bitmap$4 |= 0x4000L;
                }
            }
            return this.DoubleTpe;
        }

        @Override
        public Types.Type DoubleTpe() {
            if ((this.bitmap$4 & 0x4000L) == 0L) {
                return this.DoubleTpe$lzycompute();
            }
            return this.DoubleTpe;
        }

        private Types.Type BooleanTpe$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 0x8000L) == 0L) {
                    this.BooleanTpe = ((ValueClassDefinitions)this).BooleanTpe();
                    this.bitmap$4 |= 0x8000L;
                }
            }
            return this.BooleanTpe;
        }

        @Override
        public Types.Type BooleanTpe() {
            if ((this.bitmap$4 & 0x8000L) == 0L) {
                return this.BooleanTpe$lzycompute();
            }
            return this.BooleanTpe;
        }

        private List<Symbols.ClassSymbol> ScalaNumericValueClasses$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 0x10000L) == 0L) {
                    this.ScalaNumericValueClasses = ((ValueClassDefinitions)this).ScalaNumericValueClasses();
                    this.bitmap$4 |= 0x10000L;
                }
            }
            return this.ScalaNumericValueClasses;
        }

        @Override
        public List<Symbols.ClassSymbol> ScalaNumericValueClasses() {
            if ((this.bitmap$4 & 0x10000L) == 0L) {
                return this.ScalaNumericValueClasses$lzycompute();
            }
            return this.ScalaNumericValueClasses;
        }

        private List<Symbols.ClassSymbol> ScalaValueClassesNoUnit$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 0x20000L) == 0L) {
                    this.ScalaValueClassesNoUnit = ((ValueClassDefinitions)this).ScalaValueClassesNoUnit();
                    this.bitmap$4 |= 0x20000L;
                }
            }
            return this.ScalaValueClassesNoUnit;
        }

        @Override
        public List<Symbols.ClassSymbol> ScalaValueClassesNoUnit() {
            if ((this.bitmap$4 & 0x20000L) == 0L) {
                return this.ScalaValueClassesNoUnit$lzycompute();
            }
            return this.ScalaValueClassesNoUnit;
        }

        private List<Symbols.ClassSymbol> ScalaValueClasses$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 0x40000L) == 0L) {
                    this.ScalaValueClasses = ((ValueClassDefinitions)this).ScalaValueClasses();
                    this.bitmap$4 |= 0x40000L;
                }
            }
            return this.ScalaValueClasses;
        }

        @Override
        public List<Symbols.ClassSymbol> ScalaValueClasses() {
            if ((this.bitmap$4 & 0x40000L) == 0L) {
                return this.ScalaValueClasses$lzycompute();
            }
            return this.ScalaValueClasses;
        }

        private ValueClassDefinitions.SymbolSet ScalaValueClassesSet$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 0x80000L) == 0L) {
                    this.ScalaValueClassesSet = ((ValueClassDefinitions)this).ScalaValueClassesSet();
                    this.bitmap$4 |= 0x80000L;
                }
            }
            return this.ScalaValueClassesSet;
        }

        @Override
        public ValueClassDefinitions.SymbolSet ScalaValueClassesSet() {
            if ((this.bitmap$4 & 0x80000L) == 0L) {
                return this.ScalaValueClassesSet$lzycompute();
            }
            return this.ScalaValueClassesSet;
        }

        private ValueClassDefinitions.SymbolSet ScalaNumericValueClassesSet$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$4 & 0x100000L) == 0L) {
                    this.ScalaNumericValueClassesSet = ((ValueClassDefinitions)this).ScalaNumericValueClassesSet();
                    this.bitmap$4 |= 0x100000L;
                }
            }
            return this.ScalaNumericValueClassesSet;
        }

        @Override
        public ValueClassDefinitions.SymbolSet ScalaNumericValueClassesSet() {
            if ((this.bitmap$4 & 0x100000L) == 0L) {
                return this.ScalaNumericValueClassesSet$lzycompute();
            }
            return this.ScalaNumericValueClassesSet;
        }

        @Override
        public final void scala$reflect$internal$Definitions$ValueClassDefinitions$_setter_$scala$reflect$internal$Definitions$ValueClassDefinitions$$nameToWeight_$eq(scala.collection.immutable.Map<Names.Name, Object> x$1) {
            this.scala$reflect$internal$Definitions$ValueClassDefinitions$$nameToWeight = x$1;
        }

        @Override
        public final void scala$reflect$internal$Definitions$ValueClassDefinitions$_setter_$scala$reflect$internal$Definitions$ValueClassDefinitions$$nameToTag_$eq(scala.collection.immutable.Map<Names.Name, Object> x$1) {
            this.scala$reflect$internal$Definitions$ValueClassDefinitions$$nameToTag = x$1;
        }

        private boolean isInitialized() {
            return this.isInitialized;
        }

        private void isInitialized_$eq(boolean x$1) {
            this.isInitialized = x$1;
        }

        public boolean isDefinitionsInitialized() {
            return this.isInitialized();
        }

        private Symbols.ModuleSymbol JavaLangPackage$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 1L) == 0L) {
                    this.JavaLangPackage = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getPackage("java.lang");
                    this.bitmap$0 |= 1L;
                }
            }
            return this.JavaLangPackage;
        }

        @Override
        public Symbols.ModuleSymbol JavaLangPackage() {
            if ((this.bitmap$0 & 1L) == 0L) {
                return this.JavaLangPackage$lzycompute();
            }
            return this.JavaLangPackage;
        }

        private Symbols.ClassSymbol JavaLangPackageClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 2L) == 0L) {
                    this.JavaLangPackageClass = (Symbols.ClassSymbol)this.JavaLangPackage().moduleClass().asClass();
                    this.bitmap$0 |= 2L;
                }
            }
            return this.JavaLangPackageClass;
        }

        @Override
        public Symbols.ClassSymbol JavaLangPackageClass() {
            if ((this.bitmap$0 & 2L) == 0L) {
                return this.JavaLangPackageClass$lzycompute();
            }
            return this.JavaLangPackageClass;
        }

        private Symbols.ModuleSymbol ScalaPackage$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 4L) == 0L) {
                    this.ScalaPackage = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getPackage("scala");
                    this.bitmap$0 |= 4L;
                }
            }
            return this.ScalaPackage;
        }

        @Override
        public Symbols.ModuleSymbol ScalaPackage() {
            if ((this.bitmap$0 & 4L) == 0L) {
                return this.ScalaPackage$lzycompute();
            }
            return this.ScalaPackage;
        }

        private Symbols.ClassSymbol ScalaPackageClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 8L) == 0L) {
                    this.ScalaPackageClass = (Symbols.ClassSymbol)this.ScalaPackage().moduleClass().asClass();
                    this.bitmap$0 |= 8L;
                }
            }
            return this.ScalaPackageClass;
        }

        @Override
        public Symbols.ClassSymbol ScalaPackageClass() {
            if ((this.bitmap$0 & 8L) == 0L) {
                return this.ScalaPackageClass$lzycompute();
            }
            return this.ScalaPackageClass;
        }

        private Symbols.ModuleSymbol RuntimePackage$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x10L) == 0L) {
                    this.RuntimePackage = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getPackage("scala.runtime");
                    this.bitmap$0 |= 0x10L;
                }
            }
            return this.RuntimePackage;
        }

        public Symbols.ModuleSymbol RuntimePackage() {
            if ((this.bitmap$0 & 0x10L) == 0L) {
                return this.RuntimePackage$lzycompute();
            }
            return this.RuntimePackage;
        }

        private Symbols.ClassSymbol RuntimePackageClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x20L) == 0L) {
                    this.RuntimePackageClass = (Symbols.ClassSymbol)this.RuntimePackage().moduleClass().asClass();
                    this.bitmap$0 |= 0x20L;
                }
            }
            return this.RuntimePackageClass;
        }

        public Symbols.ClassSymbol RuntimePackageClass() {
            if ((this.bitmap$0 & 0x20L) == 0L) {
                return this.RuntimePackageClass$lzycompute();
            }
            return this.RuntimePackageClass;
        }

        public Symbols.Symbol javaTypeToValueClass(Class<?> jtype) {
            Symbols.Symbol symbol;
            Class<Void> clazz = Void.TYPE;
            if (!(clazz != null ? !clazz.equals(jtype) : jtype != null)) {
                symbol = this.UnitClass();
            } else {
                Class<Byte> clazz2 = Byte.TYPE;
                if (!(clazz2 != null ? !clazz2.equals(jtype) : jtype != null)) {
                    symbol = this.ByteClass();
                } else {
                    Class<Character> clazz3 = Character.TYPE;
                    if (!(clazz3 != null ? !clazz3.equals(jtype) : jtype != null)) {
                        symbol = this.CharClass();
                    } else {
                        Class<Short> clazz4 = Short.TYPE;
                        if (!(clazz4 != null ? !clazz4.equals(jtype) : jtype != null)) {
                            symbol = this.ShortClass();
                        } else {
                            Class<Integer> clazz5 = Integer.TYPE;
                            if (!(clazz5 != null ? !clazz5.equals(jtype) : jtype != null)) {
                                symbol = this.IntClass();
                            } else {
                                Class<Long> clazz6 = Long.TYPE;
                                if (!(clazz6 != null ? !clazz6.equals(jtype) : jtype != null)) {
                                    symbol = this.LongClass();
                                } else {
                                    Class<Float> clazz7 = Float.TYPE;
                                    if (!(clazz7 != null ? !clazz7.equals(jtype) : jtype != null)) {
                                        symbol = this.FloatClass();
                                    } else {
                                        Class<Double> clazz8 = Double.TYPE;
                                        if (!(clazz8 != null ? !clazz8.equals(jtype) : jtype != null)) {
                                            symbol = this.DoubleClass();
                                        } else {
                                            Class<Boolean> clazz9 = Boolean.TYPE;
                                            symbol = !(clazz9 != null ? !clazz9.equals(jtype) : jtype != null) ? this.BooleanClass() : this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return symbol;
        }

        public Class<?> valueClassToJavaType(Symbols.Symbol sym) {
            Class<Object> clazz;
            Symbols.ClassSymbol classSymbol = this.UnitClass();
            if (!(classSymbol != null ? !classSymbol.equals(sym) : sym != null)) {
                clazz = Void.TYPE;
            } else {
                Symbols.ClassSymbol classSymbol2 = this.ByteClass();
                if (!(classSymbol2 != null ? !classSymbol2.equals(sym) : sym != null)) {
                    clazz = Byte.TYPE;
                } else {
                    Symbols.ClassSymbol classSymbol3 = this.CharClass();
                    if (!(classSymbol3 != null ? !classSymbol3.equals(sym) : sym != null)) {
                        clazz = Character.TYPE;
                    } else {
                        Symbols.ClassSymbol classSymbol4 = this.ShortClass();
                        if (!(classSymbol4 != null ? !classSymbol4.equals(sym) : sym != null)) {
                            clazz = Short.TYPE;
                        } else {
                            Symbols.ClassSymbol classSymbol5 = this.IntClass();
                            if (!(classSymbol5 != null ? !classSymbol5.equals(sym) : sym != null)) {
                                clazz = Integer.TYPE;
                            } else {
                                Symbols.ClassSymbol classSymbol6 = this.LongClass();
                                if (!(classSymbol6 != null ? !classSymbol6.equals(sym) : sym != null)) {
                                    clazz = Long.TYPE;
                                } else {
                                    Symbols.ClassSymbol classSymbol7 = this.FloatClass();
                                    if (!(classSymbol7 != null ? !classSymbol7.equals(sym) : sym != null)) {
                                        clazz = Float.TYPE;
                                    } else {
                                        Symbols.ClassSymbol classSymbol8 = this.DoubleClass();
                                        if (!(classSymbol8 != null ? !classSymbol8.equals(sym) : sym != null)) {
                                            clazz = Double.TYPE;
                                        } else {
                                            Symbols.ClassSymbol classSymbol9 = this.BooleanClass();
                                            clazz = !(classSymbol9 != null ? !classSymbol9.equals(sym) : sym != null) ? Boolean.TYPE : null;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return clazz;
        }

        public Symbols.Symbol fullyInitializeSymbol(Symbols.Symbol sym) {
            sym.initialize();
            if (sym.owner().initialize().isJavaDefined()) {
                sym.cookJavaRawInfo();
            }
            this.fullyInitializeType(sym.info());
            this.fullyInitializeType(sym.tpe_$times());
            return sym;
        }

        /*
         * WARNING - void declaration
         */
        public Types.Type fullyInitializeType(Types.Type tp) {
            void mforeach_xss;
            List list = tp.typeParams();
            if (list == null) {
                throw null;
            }
            List foreach_these = list;
            while (!foreach_these.isEmpty()) {
                Symbols.Symbol symbol = foreach_these.head();
                this.fullyInitializeSymbol(symbol);
                foreach_these = (List)foreach_these.tail();
            }
            Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable intersect = (Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)sym -> {
                this.fullyInitializeSymbol(sym);
                return BoxedUnit.UNIT;
            };
            List<List<Symbols.Symbol>> list2 = tp.paramss();
            if (this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer() == null) {
                throw null;
            }
            if (mforeach_xss == null) {
                throw null;
            }
            List mforeach_foreach_these = mforeach_xss;
            while (!mforeach_foreach_these.isEmpty()) {
                List list3 = (List)mforeach_foreach_these.head();
                if (list3 == null) {
                    throw null;
                }
                List $anonfun$mforeach$1$adapted_$anonfun$mforeach$1_foreach_these = list3;
                while (!$anonfun$mforeach$1$adapted_$anonfun$mforeach$1_foreach_these.isEmpty()) {
                    void mforeach_f;
                    mforeach_f.apply($anonfun$mforeach$1$adapted_$anonfun$mforeach$1_foreach_these.head());
                    $anonfun$mforeach$1$adapted_$anonfun$mforeach$1_foreach_these = (List)$anonfun$mforeach$1$adapted_$anonfun$mforeach$1_foreach_these.tail();
                }
                mforeach_foreach_these = (List)mforeach_foreach_these.tail();
            }
            return tp;
        }

        public Scopes.Scope fullyInitializeScope(Scopes.Scope scope) {
            List list = scope.sorted();
            if (list == null) {
                throw null;
            }
            List foreach_these = list;
            while (!foreach_these.isEmpty()) {
                Symbols.Symbol symbol = foreach_these.head();
                this.fullyInitializeSymbol(symbol);
                foreach_these = (List)foreach_these.tail();
            }
            return scope;
        }

        public boolean isUniversalMember(Symbols.Symbol sym) {
            return this.ObjectClass().isSubClass(sym.owner());
        }

        public boolean isUnimportable(Symbols.Symbol sym) {
            return sym == this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol() || sym.isConstructor() || sym.isPrivateLocal();
        }

        public boolean isUnimportableUnlessRenamed(Symbols.Symbol sym) {
            return this.isUnimportable(sym) || this.isUniversalMember(sym);
        }

        public boolean isImportable(Symbols.Symbol sym) {
            return !this.isUnimportable(sym);
        }

        public boolean isTrivialTopType(Types.Type tp) {
            return tp.$eq$colon$eq(this.AnyTpe()) || tp.$eq$colon$eq(this.AnyValTpe()) || tp.$eq$colon$eq(this.AnyRefTpe());
        }

        public boolean isUnitType(Types.Type tp) {
            Symbols.Symbol symbol = tp.typeSymbol();
            Symbols.ClassSymbol classSymbol = this.UnitClass();
            return !(symbol != null ? !symbol.equals(classSymbol) : classSymbol != null) && tp.annotations().isEmpty();
        }

        public boolean hasMultipleNonImplicitParamLists(Symbols.Symbol member) {
            return this.hasMultipleNonImplicitParamLists(member.info());
        }

        public boolean hasMultipleNonImplicitParamLists(Types.Type info) {
            boolean bl;
            if (info instanceof Types.PolyType) {
                Types.Type restpe = ((Types.PolyType)info).resultType();
                bl = this.hasMultipleNonImplicitParamLists(restpe);
            } else {
                List<Symbols.Symbol> list;
                Types.Type type;
                bl = info instanceof Types.MethodType && (type = ((Types.MethodType)info).resultType()) instanceof Types.MethodType && (list = ((Types.MethodType)type).params()) instanceof $colon$colon && !((Symbols.Symbol)(($colon$colon)list).head()).isImplicit();
            }
            return bl;
        }

        /*
         * WARNING - void declaration
         */
        private Types.Type fixupAsAnyTrait(Types.Type tpe) {
            Types.Type type;
            if (tpe instanceof Types.ClassInfoType) {
                Types.Type type2;
                Types.ClassInfoType classInfoType = (Types.ClassInfoType)tpe;
                List<Types.Type> parents = classInfoType.parents();
                Scopes.Scope decls = classInfoType.decls();
                Symbols.Symbol clazz = classInfoType.typeSymbol();
                Symbols.Symbol symbol = parents.head().typeSymbol();
                Symbols.ClassSymbol classSymbol = this.AnyClass();
                if (!(symbol != null ? !symbol.equals(classSymbol) : classSymbol != null)) {
                    type2 = tpe;
                } else {
                    void assert_assertion;
                    boolean bl;
                    SymbolTable symbolTable = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer();
                    Symbols.Symbol symbol2 = parents.head().typeSymbol();
                    Symbols.ClassSymbol classSymbol2 = this.ObjectClass();
                    boolean bl2 = !(symbol2 != null ? !symbol2.equals(classSymbol2) : classSymbol2 != null) ? true : (bl = false);
                    if (symbolTable == null) {
                        throw null;
                    }
                    SymbolTable assert_this = symbolTable;
                    if (assert_assertion == false) {
                        throw assert_this.throwAssertionError(parents);
                    }
                    Types.Type type3 = this.AnyTpe();
                    Types.ClassInfoType classInfoType2 = new Types.ClassInfoType(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer(), ((List)parents.tail()).$colon$colon(type3), decls, clazz);
                    type2 = classInfoType2;
                }
                type = type2;
            } else if (tpe instanceof Types.PolyType) {
                Types.PolyType polyType = (Types.PolyType)tpe;
                List<Symbols.Symbol> tparams = polyType.typeParams();
                Types.Type restpe = polyType.resultType();
                type = new Types.PolyType(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer(), tparams, this.fixupAsAnyTrait(restpe));
            } else {
                throw new MatchError(tpe);
            }
            return type;
        }

        private Symbols.ClassSymbol AnyClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x40L) == 0L) {
                    this.AnyClass = (Symbols.ClassSymbol)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewClass(this.ScalaPackageClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().Any(), Nil$.MODULE$, 8L).markAllCompleted();
                    this.bitmap$0 |= 0x40L;
                }
            }
            return this.AnyClass;
        }

        @Override
        public Symbols.ClassSymbol AnyClass() {
            if ((this.bitmap$0 & 0x40L) == 0L) {
                return this.AnyClass$lzycompute();
            }
            return this.AnyClass;
        }

        private Symbols.AliasTypeSymbol AnyRefClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x80L) == 0L) {
                    this.AnyRefClass = (Symbols.AliasTypeSymbol)this.newAlias(this.ScalaPackageClass(), (Names.TypeName)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().AnyRef(), this.ObjectTpe()).markAllCompleted();
                    this.bitmap$0 |= 0x80L;
                }
            }
            return this.AnyRefClass;
        }

        @Override
        public Symbols.AliasTypeSymbol AnyRefClass() {
            if ((this.bitmap$0 & 0x80L) == 0L) {
                return this.AnyRefClass$lzycompute();
            }
            return this.AnyRefClass;
        }

        private Symbols.ClassSymbol ObjectClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x100L) == 0L) {
                    this.ObjectClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getRequiredClass("java.lang.Object");
                    this.bitmap$0 |= 0x100L;
                }
            }
            return this.ObjectClass;
        }

        @Override
        public Symbols.ClassSymbol ObjectClass() {
            if ((this.bitmap$0 & 0x100L) == 0L) {
                return this.ObjectClass$lzycompute();
            }
            return this.ObjectClass;
        }

        private Types.Type AnyRefTpe$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x200L) == 0L) {
                    this.AnyRefTpe = this.AnyRefClass().tpe();
                    this.bitmap$0 |= 0x200L;
                }
            }
            return this.AnyRefTpe;
        }

        @Override
        public Types.Type AnyRefTpe() {
            if ((this.bitmap$0 & 0x200L) == 0L) {
                return this.AnyRefTpe$lzycompute();
            }
            return this.AnyRefTpe;
        }

        private Types.Type AnyTpe$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x400L) == 0L) {
                    this.AnyTpe = this.AnyClass().tpe();
                    this.bitmap$0 |= 0x400L;
                }
            }
            return this.AnyTpe;
        }

        @Override
        public Types.Type AnyTpe() {
            if ((this.bitmap$0 & 0x400L) == 0L) {
                return this.AnyTpe$lzycompute();
            }
            return this.AnyTpe;
        }

        private Types.Type AnyValTpe$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x800L) == 0L) {
                    this.AnyValTpe = this.AnyValClass().tpe();
                    this.bitmap$0 |= 0x800L;
                }
            }
            return this.AnyValTpe;
        }

        @Override
        public Types.Type AnyValTpe() {
            if ((this.bitmap$0 & 0x800L) == 0L) {
                return this.AnyValTpe$lzycompute();
            }
            return this.AnyValTpe;
        }

        private Types.Type BoxedUnitTpe$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x1000L) == 0L) {
                    this.BoxedUnitTpe = this.BoxedUnitClass().tpe();
                    this.bitmap$0 |= 0x1000L;
                }
            }
            return this.BoxedUnitTpe;
        }

        public Types.Type BoxedUnitTpe() {
            if ((this.bitmap$0 & 0x1000L) == 0L) {
                return this.BoxedUnitTpe$lzycompute();
            }
            return this.BoxedUnitTpe;
        }

        private Types.Type NothingTpe$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x2000L) == 0L) {
                    this.NothingTpe = this.NothingClass().tpe();
                    this.bitmap$0 |= 0x2000L;
                }
            }
            return this.NothingTpe;
        }

        @Override
        public Types.Type NothingTpe() {
            if ((this.bitmap$0 & 0x2000L) == 0L) {
                return this.NothingTpe$lzycompute();
            }
            return this.NothingTpe;
        }

        private Types.Type NullTpe$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x4000L) == 0L) {
                    this.NullTpe = this.NullClass().tpe();
                    this.bitmap$0 |= 0x4000L;
                }
            }
            return this.NullTpe;
        }

        @Override
        public Types.Type NullTpe() {
            if ((this.bitmap$0 & 0x4000L) == 0L) {
                return this.NullTpe$lzycompute();
            }
            return this.NullTpe;
        }

        private Types.Type ObjectTpe$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x8000L) == 0L) {
                    this.ObjectTpe = this.ObjectClass().tpe();
                    this.bitmap$0 |= 0x8000L;
                }
            }
            return this.ObjectTpe;
        }

        @Override
        public Types.Type ObjectTpe() {
            if ((this.bitmap$0 & 0x8000L) == 0L) {
                return this.ObjectTpe$lzycompute();
            }
            return this.ObjectTpe;
        }

        private Types.Type SerializableTpe$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x10000L) == 0L) {
                    this.SerializableTpe = this.SerializableClass().tpe();
                    this.bitmap$0 |= 0x10000L;
                }
            }
            return this.SerializableTpe;
        }

        public Types.Type SerializableTpe() {
            if ((this.bitmap$0 & 0x10000L) == 0L) {
                return this.SerializableTpe$lzycompute();
            }
            return this.SerializableTpe;
        }

        private Types.Type StringTpe$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x20000L) == 0L) {
                    this.StringTpe = this.StringClass().tpe();
                    this.bitmap$0 |= 0x20000L;
                }
            }
            return this.StringTpe;
        }

        public Types.Type StringTpe() {
            if ((this.bitmap$0 & 0x20000L) == 0L) {
                return this.StringTpe$lzycompute();
            }
            return this.StringTpe;
        }

        private Types.Type ThrowableTpe$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x40000L) == 0L) {
                    this.ThrowableTpe = this.ThrowableClass().tpe();
                    this.bitmap$0 |= 0x40000L;
                }
            }
            return this.ThrowableTpe;
        }

        public Types.Type ThrowableTpe() {
            if ((this.bitmap$0 & 0x40000L) == 0L) {
                return this.ThrowableTpe$lzycompute();
            }
            return this.ThrowableTpe;
        }

        private Types.UniqueConstantType ConstantTrue$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x80000L) == 0L) {
                    this.ConstantTrue = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().ConstantType().apply(new Constants.Constant(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer(), BoxesRunTime.boxToBoolean(true)));
                    this.bitmap$0 |= 0x80000L;
                }
            }
            return this.ConstantTrue;
        }

        public Types.UniqueConstantType ConstantTrue() {
            if ((this.bitmap$0 & 0x80000L) == 0L) {
                return this.ConstantTrue$lzycompute();
            }
            return this.ConstantTrue;
        }

        private Types.UniqueConstantType ConstantFalse$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x100000L) == 0L) {
                    this.ConstantFalse = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().ConstantType().apply(new Constants.Constant(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer(), BoxesRunTime.boxToBoolean(false)));
                    this.bitmap$0 |= 0x100000L;
                }
            }
            return this.ConstantFalse;
        }

        public Types.UniqueConstantType ConstantFalse() {
            if ((this.bitmap$0 & 0x100000L) == 0L) {
                return this.ConstantFalse$lzycompute();
            }
            return this.ConstantFalse;
        }

        private Types.UniqueConstantType ConstantNull$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x200000L) == 0L) {
                    this.ConstantNull = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().ConstantType().apply(new Constants.Constant(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer(), null));
                    this.bitmap$0 |= 0x200000L;
                }
            }
            return this.ConstantNull;
        }

        public Types.UniqueConstantType ConstantNull() {
            if ((this.bitmap$0 & 0x200000L) == 0L) {
                return this.ConstantNull$lzycompute();
            }
            return this.ConstantNull;
        }

        private Symbols.ClassSymbol AnyValClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x400000L) == 0L) {
                    Symbols.Symbol symbol = this.ScalaPackageClass().info().member(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().AnyVal());
                    if (symbol == null) {
                        throw null;
                    }
                    Symbols.Symbol orElse_this = symbol;
                    this.AnyValClass = (Symbols.ClassSymbol)(orElse_this != orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol() ? orElse_this : DefinitionsClass.$anonfun$AnyValClass$1(this));
                    this.bitmap$0 |= 0x400000L;
                }
            }
            return this.AnyValClass;
        }

        @Override
        public Symbols.ClassSymbol AnyValClass() {
            if ((this.bitmap$0 & 0x400000L) == 0L) {
                return this.AnyValClass$lzycompute();
            }
            return this.AnyValClass;
        }

        public Symbols.TermSymbol AnyVal_getClass() {
            return this.getMemberMethod(this.AnyValClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().getClass_());
        }

        private Symbols.ClassSymbol RuntimeNothingClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x800000L) == 0L) {
                    this.RuntimeNothingClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Nothing$.class));
                    this.bitmap$0 |= 0x800000L;
                }
            }
            return this.RuntimeNothingClass;
        }

        public Symbols.ClassSymbol RuntimeNothingClass() {
            if ((this.bitmap$0 & 0x800000L) == 0L) {
                return this.RuntimeNothingClass$lzycompute();
            }
            return this.RuntimeNothingClass;
        }

        private Symbols.ClassSymbol RuntimeNullClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x1000000L) == 0L) {
                    this.RuntimeNullClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Null$.class));
                    this.bitmap$0 |= 0x1000000L;
                }
            }
            return this.RuntimeNullClass;
        }

        public Symbols.ClassSymbol RuntimeNullClass() {
            if ((this.bitmap$0 & 0x1000000L) == 0L) {
                return this.RuntimeNullClass$lzycompute();
            }
            return this.RuntimeNullClass;
        }

        private Symbols.ClassSymbol ClassCastExceptionClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x2000000L) == 0L) {
                    this.ClassCastExceptionClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(ClassCastException.class));
                    this.bitmap$0 |= 0x2000000L;
                }
            }
            return this.ClassCastExceptionClass;
        }

        public Symbols.ClassSymbol ClassCastExceptionClass() {
            if ((this.bitmap$0 & 0x2000000L) == 0L) {
                return this.ClassCastExceptionClass$lzycompute();
            }
            return this.ClassCastExceptionClass;
        }

        private Symbols.ClassSymbol IndexOutOfBoundsExceptionClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x4000000L) == 0L) {
                    this.IndexOutOfBoundsExceptionClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassByName("java.lang.IndexOutOfBoundsException");
                    this.bitmap$0 |= 0x4000000L;
                }
            }
            return this.IndexOutOfBoundsExceptionClass;
        }

        public Symbols.ClassSymbol IndexOutOfBoundsExceptionClass() {
            if ((this.bitmap$0 & 0x4000000L) == 0L) {
                return this.IndexOutOfBoundsExceptionClass$lzycompute();
            }
            return this.IndexOutOfBoundsExceptionClass;
        }

        private Symbols.ClassSymbol InvocationTargetExceptionClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x8000000L) == 0L) {
                    this.InvocationTargetExceptionClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassByName("java.lang.reflect.InvocationTargetException");
                    this.bitmap$0 |= 0x8000000L;
                }
            }
            return this.InvocationTargetExceptionClass;
        }

        public Symbols.ClassSymbol InvocationTargetExceptionClass() {
            if ((this.bitmap$0 & 0x8000000L) == 0L) {
                return this.InvocationTargetExceptionClass$lzycompute();
            }
            return this.InvocationTargetExceptionClass;
        }

        private Symbols.ClassSymbol MatchErrorClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x10000000L) == 0L) {
                    this.MatchErrorClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(MatchError.class));
                    this.bitmap$0 |= 0x10000000L;
                }
            }
            return this.MatchErrorClass;
        }

        public Symbols.ClassSymbol MatchErrorClass() {
            if ((this.bitmap$0 & 0x10000000L) == 0L) {
                return this.MatchErrorClass$lzycompute();
            }
            return this.MatchErrorClass;
        }

        private Symbols.ClassSymbol NonLocalReturnControlClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x20000000L) == 0L) {
                    this.NonLocalReturnControlClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(NonLocalReturnControl.class));
                    this.bitmap$0 |= 0x20000000L;
                }
            }
            return this.NonLocalReturnControlClass;
        }

        public Symbols.ClassSymbol NonLocalReturnControlClass() {
            if ((this.bitmap$0 & 0x20000000L) == 0L) {
                return this.NonLocalReturnControlClass$lzycompute();
            }
            return this.NonLocalReturnControlClass;
        }

        private Symbols.ClassSymbol NullPointerExceptionClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x40000000L) == 0L) {
                    this.NullPointerExceptionClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassByName("java.lang.NullPointerException");
                    this.bitmap$0 |= 0x40000000L;
                }
            }
            return this.NullPointerExceptionClass;
        }

        public Symbols.ClassSymbol NullPointerExceptionClass() {
            if ((this.bitmap$0 & 0x40000000L) == 0L) {
                return this.NullPointerExceptionClass$lzycompute();
            }
            return this.NullPointerExceptionClass;
        }

        private Symbols.ClassSymbol ThrowableClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x80000000L) == 0L) {
                    this.ThrowableClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassByName("java.lang.Throwable");
                    this.bitmap$0 |= 0x80000000L;
                }
            }
            return this.ThrowableClass;
        }

        public Symbols.ClassSymbol ThrowableClass() {
            if ((this.bitmap$0 & 0x80000000L) == 0L) {
                return this.ThrowableClass$lzycompute();
            }
            return this.ThrowableClass;
        }

        private Symbols.ClassSymbol UninitializedErrorClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x100000000L) == 0L) {
                    this.UninitializedErrorClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(UninitializedFieldError.class));
                    this.bitmap$0 |= 0x100000000L;
                }
            }
            return this.UninitializedErrorClass;
        }

        public Symbols.ClassSymbol UninitializedErrorClass() {
            if ((this.bitmap$0 & 0x100000000L) == 0L) {
                return this.UninitializedErrorClass$lzycompute();
            }
            return this.UninitializedErrorClass;
        }

        private Symbols.ClassSymbol IllegalArgExceptionClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x200000000L) == 0L) {
                    this.IllegalArgExceptionClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(IllegalArgumentException.class));
                    this.bitmap$0 |= 0x200000000L;
                }
            }
            return this.IllegalArgExceptionClass;
        }

        public Symbols.ClassSymbol IllegalArgExceptionClass() {
            if ((this.bitmap$0 & 0x200000000L) == 0L) {
                return this.IllegalArgExceptionClass$lzycompute();
            }
            return this.IllegalArgExceptionClass;
        }

        private Symbols.Symbol UninitializedFieldConstructor$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x400000000L) == 0L) {
                    this.UninitializedFieldConstructor = this.UninitializedErrorClass().primaryConstructor();
                    this.bitmap$0 |= 0x400000000L;
                }
            }
            return this.UninitializedFieldConstructor;
        }

        public Symbols.Symbol UninitializedFieldConstructor() {
            if ((this.bitmap$0 & 0x400000000L) == 0L) {
                return this.UninitializedFieldConstructor$lzycompute();
            }
            return this.UninitializedFieldConstructor;
        }

        private Symbols.ClassSymbol PartialFunctionClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x800000000L) == 0L) {
                    this.PartialFunctionClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(PartialFunction.class));
                    this.bitmap$0 |= 0x800000000L;
                }
            }
            return this.PartialFunctionClass;
        }

        public Symbols.ClassSymbol PartialFunctionClass() {
            if ((this.bitmap$0 & 0x800000000L) == 0L) {
                return this.PartialFunctionClass$lzycompute();
            }
            return this.PartialFunctionClass;
        }

        private Symbols.ClassSymbol AbstractPartialFunctionClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x1000000000L) == 0L) {
                    this.AbstractPartialFunctionClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(AbstractPartialFunction.class));
                    this.bitmap$0 |= 0x1000000000L;
                }
            }
            return this.AbstractPartialFunctionClass;
        }

        public Symbols.ClassSymbol AbstractPartialFunctionClass() {
            if ((this.bitmap$0 & 0x1000000000L) == 0L) {
                return this.AbstractPartialFunctionClass$lzycompute();
            }
            return this.AbstractPartialFunctionClass;
        }

        private Symbols.ClassSymbol SymbolClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x2000000000L) == 0L) {
                    this.SymbolClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Symbol.class));
                    this.bitmap$0 |= 0x2000000000L;
                }
            }
            return this.SymbolClass;
        }

        public Symbols.ClassSymbol SymbolClass() {
            if ((this.bitmap$0 & 0x2000000000L) == 0L) {
                return this.SymbolClass$lzycompute();
            }
            return this.SymbolClass;
        }

        private Symbols.ClassSymbol StringClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x4000000000L) == 0L) {
                    this.StringClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(String.class));
                    this.bitmap$0 |= 0x4000000000L;
                }
            }
            return this.StringClass;
        }

        @Override
        public Symbols.ClassSymbol StringClass() {
            if ((this.bitmap$0 & 0x4000000000L) == 0L) {
                return this.StringClass$lzycompute();
            }
            return this.StringClass;
        }

        private Symbols.Symbol StringModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x8000000000L) == 0L) {
                    this.StringModule = this.StringClass().linkedClassOfClass();
                    this.bitmap$0 |= 0x8000000000L;
                }
            }
            return this.StringModule;
        }

        public Symbols.Symbol StringModule() {
            if ((this.bitmap$0 & 0x8000000000L) == 0L) {
                return this.StringModule$lzycompute();
            }
            return this.StringModule;
        }

        private Symbols.ClassSymbol ClassClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x10000000000L) == 0L) {
                    this.ClassClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Class.class));
                    this.bitmap$0 |= 0x10000000000L;
                }
            }
            return this.ClassClass;
        }

        @Override
        public Symbols.ClassSymbol ClassClass() {
            if ((this.bitmap$0 & 0x10000000000L) == 0L) {
                return this.ClassClass$lzycompute();
            }
            return this.ClassClass;
        }

        public Symbols.TermSymbol Class_getMethod() {
            return this.getMemberMethod(this.ClassClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().getMethod_());
        }

        private Symbols.ClassSymbol DynamicClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x20000000000L) == 0L) {
                    this.DynamicClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Dynamic.class));
                    this.bitmap$0 |= 0x20000000000L;
                }
            }
            return this.DynamicClass;
        }

        public Symbols.ClassSymbol DynamicClass() {
            if ((this.bitmap$0 & 0x20000000000L) == 0L) {
                return this.DynamicClass$lzycompute();
            }
            return this.DynamicClass;
        }

        private Symbols.ModuleSymbol SysPackage$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x40000000000L) == 0L) {
                    this.SysPackage = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getPackageObject("scala.sys");
                    this.bitmap$0 |= 0x40000000000L;
                }
            }
            return this.SysPackage;
        }

        public Symbols.ModuleSymbol SysPackage() {
            if ((this.bitmap$0 & 0x40000000000L) == 0L) {
                return this.SysPackage$lzycompute();
            }
            return this.SysPackage;
        }

        public Symbols.TermSymbol Sys_error() {
            return this.getMemberMethod(this.SysPackage(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().error());
        }

        private List<Symbols.ModuleSymbol> UnqualifiedModules$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x80000000000L) == 0L) {
                    this.UnqualifiedModules = new $colon$colon<Nothing$>((Nothing$)((Object)this.PredefModule()), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)this.ScalaPackage()), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)this.JavaLangPackage()), Nil$.MODULE$)));
                    this.bitmap$0 |= 0x80000000000L;
                }
            }
            return this.UnqualifiedModules;
        }

        public List<Symbols.ModuleSymbol> UnqualifiedModules() {
            if ((this.bitmap$0 & 0x80000000000L) == 0L) {
                return this.UnqualifiedModules$lzycompute();
            }
            return this.UnqualifiedModules;
        }

        private Set<Symbols.Symbol> UnqualifiedOwners$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x100000000000L) == 0L) {
                    this.UnqualifiedOwners = (Set)this.UnqualifiedModules().toSet().$plus$plus(this.UnqualifiedModules().map((Function1<Symbols.ModuleSymbol, Symbols.Symbol> & java.io.Serializable & Serializable)x$5 -> x$5.moduleClass(), List$.MODULE$.canBuildFrom()));
                    this.bitmap$0 |= 0x100000000000L;
                }
            }
            return this.UnqualifiedOwners;
        }

        public Set<Symbols.Symbol> UnqualifiedOwners() {
            if ((this.bitmap$0 & 0x100000000000L) == 0L) {
                return this.UnqualifiedOwners$lzycompute();
            }
            return this.UnqualifiedOwners;
        }

        private Symbols.ModuleSymbol PredefModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x200000000000L) == 0L) {
                    this.PredefModule = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredModule(ClassTag$.MODULE$.apply(Predef$.class));
                    this.bitmap$0 |= 0x200000000000L;
                }
            }
            return this.PredefModule;
        }

        @Override
        public Symbols.ModuleSymbol PredefModule() {
            if ((this.bitmap$0 & 0x200000000000L) == 0L) {
                return this.PredefModule$lzycompute();
            }
            return this.PredefModule;
        }

        public Symbols.TermSymbol Predef_wrapArray(Types.Type tp) {
            return this.getMemberMethod(this.PredefModule(), this.wrapArrayMethodName(tp));
        }

        public Symbols.TermSymbol Predef_$qmark$qmark$qmark() {
            return this.getMemberMethod(this.PredefModule(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().$qmark$qmark$qmark());
        }

        public Symbols.TermSymbol Predef_locally() {
            return this.getMemberMethod(this.PredefModule(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().locally());
        }

        public boolean isPredefMemberNamed(Symbols.Symbol sym, Names.Name name) {
            Names.Name name2 = sym.name();
            if (!(name2 != null ? !name2.equals(name) : name != null)) {
                Symbols.Symbol symbol = sym.owner();
                Symbols.Symbol symbol2 = this.PredefModule().moduleClass();
                if (!(symbol != null ? !symbol.equals(symbol2) : symbol2 != null)) {
                    return true;
                }
            }
            return false;
        }

        private Symbols.ModuleSymbol SpecializableModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x400000000000L) == 0L) {
                    this.SpecializableModule = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredModule(ClassTag$.MODULE$.apply(Specializable.class));
                    this.bitmap$0 |= 0x400000000000L;
                }
            }
            return this.SpecializableModule;
        }

        public Symbols.ModuleSymbol SpecializableModule() {
            if ((this.bitmap$0 & 0x400000000000L) == 0L) {
                return this.SpecializableModule$lzycompute();
            }
            return this.SpecializableModule;
        }

        private Symbols.ModuleSymbol ScalaRunTimeModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x800000000000L) == 0L) {
                    this.ScalaRunTimeModule = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredModule(ClassTag$.MODULE$.apply(ScalaRunTime$.class));
                    this.bitmap$0 |= 0x800000000000L;
                }
            }
            return this.ScalaRunTimeModule;
        }

        public Symbols.ModuleSymbol ScalaRunTimeModule() {
            if ((this.bitmap$0 & 0x800000000000L) == 0L) {
                return this.ScalaRunTimeModule$lzycompute();
            }
            return this.ScalaRunTimeModule;
        }

        private Symbols.ModuleSymbol SymbolModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x1000000000000L) == 0L) {
                    this.SymbolModule = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredModule(ClassTag$.MODULE$.apply(Symbol$.class));
                    this.bitmap$0 |= 0x1000000000000L;
                }
            }
            return this.SymbolModule;
        }

        public Symbols.ModuleSymbol SymbolModule() {
            if ((this.bitmap$0 & 0x1000000000000L) == 0L) {
                return this.SymbolModule$lzycompute();
            }
            return this.SymbolModule;
        }

        public Symbols.TermSymbol Symbol_apply() {
            return this.getMemberMethod(this.SymbolModule(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().apply());
        }

        private Symbols.ClassSymbol StringAddClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x2000000000000L) == 0L) {
                    this.StringAddClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(StringAdd.class));
                    this.bitmap$0 |= 0x2000000000000L;
                }
            }
            return this.StringAddClass;
        }

        public Symbols.ClassSymbol StringAddClass() {
            if ((this.bitmap$0 & 0x2000000000000L) == 0L) {
                return this.StringAddClass$lzycompute();
            }
            return this.StringAddClass;
        }

        private Symbols.ClassSymbol ScalaNumberClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x4000000000000L) == 0L) {
                    this.ScalaNumberClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(ScalaNumber.class));
                    this.bitmap$0 |= 0x4000000000000L;
                }
            }
            return this.ScalaNumberClass;
        }

        public Symbols.ClassSymbol ScalaNumberClass() {
            if ((this.bitmap$0 & 0x4000000000000L) == 0L) {
                return this.ScalaNumberClass$lzycompute();
            }
            return this.ScalaNumberClass;
        }

        private Symbols.ClassSymbol DelayedInitClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x8000000000000L) == 0L) {
                    this.DelayedInitClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(DelayedInit.class));
                    this.bitmap$0 |= 0x8000000000000L;
                }
            }
            return this.DelayedInitClass;
        }

        public Symbols.ClassSymbol DelayedInitClass() {
            if ((this.bitmap$0 & 0x8000000000000L) == 0L) {
                return this.DelayedInitClass$lzycompute();
            }
            return this.DelayedInitClass;
        }

        public Symbols.TermSymbol delayedInitMethod() {
            return this.getMemberMethod(this.DelayedInitClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().delayedInit());
        }

        private Symbols.ClassSymbol TypeConstraintClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x10000000000000L) == 0L) {
                    this.TypeConstraintClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(TypeConstraint.class));
                    this.bitmap$0 |= 0x10000000000000L;
                }
            }
            return this.TypeConstraintClass;
        }

        public Symbols.ClassSymbol TypeConstraintClass() {
            if ((this.bitmap$0 & 0x10000000000000L) == 0L) {
                return this.TypeConstraintClass$lzycompute();
            }
            return this.TypeConstraintClass;
        }

        private Symbols.ClassSymbol SingletonClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x20000000000000L) == 0L) {
                    Types.Type type = this.AnyTpe();
                    this.SingletonClass = (Symbols.ClassSymbol)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewClass(this.ScalaPackageClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().Singleton(), Nil$.MODULE$.$colon$colon(type), 0x2000028L).markAllCompleted();
                    this.bitmap$0 |= 0x20000000000000L;
                }
            }
            return this.SingletonClass;
        }

        public Symbols.ClassSymbol SingletonClass() {
            if ((this.bitmap$0 & 0x20000000000000L) == 0L) {
                return this.SingletonClass$lzycompute();
            }
            return this.SingletonClass;
        }

        private Symbols.ClassSymbol SerializableClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x40000000000000L) == 0L) {
                    this.SerializableClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Serializable.class));
                    this.bitmap$0 |= 0x40000000000000L;
                }
            }
            return this.SerializableClass;
        }

        public Symbols.ClassSymbol SerializableClass() {
            if ((this.bitmap$0 & 0x40000000000000L) == 0L) {
                return this.SerializableClass$lzycompute();
            }
            return this.SerializableClass;
        }

        private Symbols.ClassSymbol JavaSerializableClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x80000000000000L) == 0L) {
                    this.JavaSerializableClass = (Symbols.ClassSymbol)((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(java.io.Serializable.class)).modifyInfo((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)tpe -> this.fixupAsAnyTrait((Types.Type)tpe));
                    this.bitmap$0 |= 0x80000000000000L;
                }
            }
            return this.JavaSerializableClass;
        }

        public Symbols.ClassSymbol JavaSerializableClass() {
            if ((this.bitmap$0 & 0x80000000000000L) == 0L) {
                return this.JavaSerializableClass$lzycompute();
            }
            return this.JavaSerializableClass;
        }

        private Symbols.ClassSymbol ComparableClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x100000000000000L) == 0L) {
                    this.ComparableClass = (Symbols.ClassSymbol)((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Comparable.class)).modifyInfo((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)tpe -> this.fixupAsAnyTrait((Types.Type)tpe));
                    this.bitmap$0 |= 0x100000000000000L;
                }
            }
            return this.ComparableClass;
        }

        public Symbols.ClassSymbol ComparableClass() {
            if ((this.bitmap$0 & 0x100000000000000L) == 0L) {
                return this.ComparableClass$lzycompute();
            }
            return this.ComparableClass;
        }

        private Symbols.ClassSymbol JavaCloneableClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x200000000000000L) == 0L) {
                    this.JavaCloneableClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Cloneable.class));
                    this.bitmap$0 |= 0x200000000000000L;
                }
            }
            return this.JavaCloneableClass;
        }

        public Symbols.ClassSymbol JavaCloneableClass() {
            if ((this.bitmap$0 & 0x200000000000000L) == 0L) {
                return this.JavaCloneableClass$lzycompute();
            }
            return this.JavaCloneableClass;
        }

        private Symbols.ClassSymbol JavaNumberClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x400000000000000L) == 0L) {
                    this.JavaNumberClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Number.class));
                    this.bitmap$0 |= 0x400000000000000L;
                }
            }
            return this.JavaNumberClass;
        }

        public Symbols.ClassSymbol JavaNumberClass() {
            if ((this.bitmap$0 & 0x400000000000000L) == 0L) {
                return this.JavaNumberClass$lzycompute();
            }
            return this.JavaNumberClass;
        }

        private Symbols.ClassSymbol JavaEnumClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x800000000000000L) == 0L) {
                    this.JavaEnumClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Enum.class));
                    this.bitmap$0 |= 0x800000000000000L;
                }
            }
            return this.JavaEnumClass;
        }

        public Symbols.ClassSymbol JavaEnumClass() {
            if ((this.bitmap$0 & 0x800000000000000L) == 0L) {
                return this.JavaEnumClass$lzycompute();
            }
            return this.JavaEnumClass;
        }

        private Symbols.ClassSymbol RemoteInterfaceClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x1000000000000000L) == 0L) {
                    this.RemoteInterfaceClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Remote.class));
                    this.bitmap$0 |= 0x1000000000000000L;
                }
            }
            return this.RemoteInterfaceClass;
        }

        public Symbols.ClassSymbol RemoteInterfaceClass() {
            if ((this.bitmap$0 & 0x1000000000000000L) == 0L) {
                return this.RemoteInterfaceClass$lzycompute();
            }
            return this.RemoteInterfaceClass;
        }

        private Symbols.ClassSymbol RemoteExceptionClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x2000000000000000L) == 0L) {
                    this.RemoteExceptionClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(RemoteException.class));
                    this.bitmap$0 |= 0x2000000000000000L;
                }
            }
            return this.RemoteExceptionClass;
        }

        public Symbols.ClassSymbol RemoteExceptionClass() {
            if ((this.bitmap$0 & 0x2000000000000000L) == 0L) {
                return this.RemoteExceptionClass$lzycompute();
            }
            return this.RemoteExceptionClass;
        }

        private Symbols.ClassSymbol JavaUtilMap$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & 0x4000000000000000L) == 0L) {
                    this.JavaUtilMap = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Map.class));
                    this.bitmap$0 |= 0x4000000000000000L;
                }
            }
            return this.JavaUtilMap;
        }

        public Symbols.ClassSymbol JavaUtilMap() {
            if ((this.bitmap$0 & 0x4000000000000000L) == 0L) {
                return this.JavaUtilMap$lzycompute();
            }
            return this.JavaUtilMap;
        }

        private Symbols.ClassSymbol JavaUtilHashMap$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$0 & Long.MIN_VALUE) == 0L) {
                    this.JavaUtilHashMap = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(HashMap.class));
                    this.bitmap$0 |= Long.MIN_VALUE;
                }
            }
            return this.JavaUtilHashMap;
        }

        public Symbols.ClassSymbol JavaUtilHashMap() {
            if ((this.bitmap$0 & Long.MIN_VALUE) == 0L) {
                return this.JavaUtilHashMap$lzycompute();
            }
            return this.JavaUtilHashMap;
        }

        private Symbols.ClassSymbol ByNameParamClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 1L) == 0L) {
                    Symbols.TypeSymbol specialPolyClass_tparam;
                    long specialPolyClass_flags = 65536L;
                    Names.TypeName specialPolyClass_name = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().BYNAME_PARAM_CLASS_NAME();
                    Symbols.ClassSymbol specialPolyClass_clazz = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewClass(this.ScalaPackageClass(), specialPolyClass_name, Nil$.MODULE$, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewClass$default$4());
                    Symbols.TypeSymbol typeSymbol = specialPolyClass_tparam = specialPolyClass_clazz.newSyntheticTypeParam("T0", specialPolyClass_flags);
                    $colon$colon<Nothing$> specialPolyClass_parents = new $colon$colon<Nothing$>((Nothing$)((Object)this.AnyRefTpe()), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)this.AnyTpe()), Nil$.MODULE$));
                    this.ByNameParamClass = (Symbols.ClassSymbol)specialPolyClass_clazz.setInfo(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().GenPolyType().apply(new $colon$colon<Nothing$>((Nothing$)((Object)specialPolyClass_tparam), Nil$.MODULE$), new Types.ClassInfoType(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer(), specialPolyClass_parents, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().newScope(), specialPolyClass_clazz))).markAllCompleted();
                    this.bitmap$1 |= 1L;
                }
            }
            return this.ByNameParamClass;
        }

        @Override
        public Symbols.ClassSymbol ByNameParamClass() {
            if ((this.bitmap$1 & 1L) == 0L) {
                return this.ByNameParamClass$lzycompute();
            }
            return this.ByNameParamClass;
        }

        private Symbols.ClassSymbol JavaRepeatedParamClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 2L) == 0L) {
                    Symbols.TypeSymbol specialPolyClass_tparam;
                    long specialPolyClass_flags = 65536L;
                    Names.TypeName specialPolyClass_name = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().JAVA_REPEATED_PARAM_CLASS_NAME();
                    Symbols.ClassSymbol specialPolyClass_clazz = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewClass(this.ScalaPackageClass(), specialPolyClass_name, Nil$.MODULE$, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewClass$default$4());
                    Symbols.TypeSymbol typeSymbol = specialPolyClass_tparam = specialPolyClass_clazz.newSyntheticTypeParam("T0", specialPolyClass_flags);
                    $colon$colon<Nothing$> specialPolyClass_parents = new $colon$colon<Nothing$>((Nothing$)((Object)this.AnyRefTpe()), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)this.arrayType(typeSymbol.tpe())), Nil$.MODULE$));
                    this.JavaRepeatedParamClass = (Symbols.ClassSymbol)specialPolyClass_clazz.setInfo(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().GenPolyType().apply(new $colon$colon<Nothing$>((Nothing$)((Object)specialPolyClass_tparam), Nil$.MODULE$), new Types.ClassInfoType(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer(), specialPolyClass_parents, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().newScope(), specialPolyClass_clazz))).markAllCompleted();
                    this.bitmap$1 |= 2L;
                }
            }
            return this.JavaRepeatedParamClass;
        }

        @Override
        public Symbols.ClassSymbol JavaRepeatedParamClass() {
            if ((this.bitmap$1 & 2L) == 0L) {
                return this.JavaRepeatedParamClass$lzycompute();
            }
            return this.JavaRepeatedParamClass;
        }

        private Symbols.ClassSymbol RepeatedParamClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 4L) == 0L) {
                    Symbols.TypeSymbol specialPolyClass_tparam;
                    long specialPolyClass_flags = 65536L;
                    Names.TypeName specialPolyClass_name = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().REPEATED_PARAM_CLASS_NAME();
                    Symbols.ClassSymbol specialPolyClass_clazz = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewClass(this.ScalaPackageClass(), specialPolyClass_name, Nil$.MODULE$, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewClass$default$4());
                    Symbols.TypeSymbol typeSymbol = specialPolyClass_tparam = specialPolyClass_clazz.newSyntheticTypeParam("T0", specialPolyClass_flags);
                    $colon$colon<Nothing$> specialPolyClass_parents = new $colon$colon<Nothing$>((Nothing$)((Object)this.AnyRefTpe()), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)this.seqType(typeSymbol.tpe())), Nil$.MODULE$));
                    this.RepeatedParamClass = (Symbols.ClassSymbol)specialPolyClass_clazz.setInfo(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().GenPolyType().apply(new $colon$colon<Nothing$>((Nothing$)((Object)specialPolyClass_tparam), Nil$.MODULE$), new Types.ClassInfoType(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer(), specialPolyClass_parents, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().newScope(), specialPolyClass_clazz))).markAllCompleted();
                    this.bitmap$1 |= 4L;
                }
            }
            return this.RepeatedParamClass;
        }

        @Override
        public Symbols.ClassSymbol RepeatedParamClass() {
            if ((this.bitmap$1 & 4L) == 0L) {
                return this.RepeatedParamClass$lzycompute();
            }
            return this.RepeatedParamClass;
        }

        public boolean isByNameParamType(Types.Type tp) {
            Symbols.Symbol symbol = tp.typeSymbol();
            Symbols.ClassSymbol classSymbol = this.ByNameParamClass();
            return !(symbol != null ? !symbol.equals(classSymbol) : classSymbol != null);
        }

        public boolean isScalaRepeatedParamType(Types.Type tp) {
            Symbols.Symbol symbol = tp.typeSymbol();
            Symbols.ClassSymbol classSymbol = this.RepeatedParamClass();
            return !(symbol != null ? !symbol.equals(classSymbol) : classSymbol != null);
        }

        public boolean isJavaRepeatedParamType(Types.Type tp) {
            Symbols.Symbol symbol = tp.typeSymbol();
            Symbols.ClassSymbol classSymbol = this.JavaRepeatedParamClass();
            return !(symbol != null ? !symbol.equals(classSymbol) : classSymbol != null);
        }

        public boolean isRepeatedParamType(Types.Type tp) {
            return this.isScalaRepeatedParamType(tp) || this.isJavaRepeatedParamType(tp);
        }

        public boolean isRepeated(Symbols.Symbol param2) {
            return this.isRepeatedParamType(param2.tpe_$times());
        }

        public boolean isByName(Symbols.Symbol param2) {
            return this.isByNameParamType(param2.tpe_$times());
        }

        public boolean isCastSymbol(Symbols.Symbol sym) {
            block3: {
                block2: {
                    Symbols.Symbol symbol = sym;
                    Symbols.MethodSymbol methodSymbol = this.Any_asInstanceOf();
                    if (!(symbol == null ? methodSymbol != null : !symbol.equals(methodSymbol))) break block2;
                    Symbols.Symbol symbol2 = sym;
                    Symbols.MethodSymbol methodSymbol2 = this.Object_asInstanceOf();
                    if (symbol2 != null ? !symbol2.equals(methodSymbol2) : methodSymbol2 != null) break block3;
                }
                return true;
            }
            return false;
        }

        public boolean isJavaVarArgsMethod(Symbols.Symbol m) {
            Types.Type type;
            boolean bl;
            return m.isMethod() && (bl = (type = m.rawInfo()) instanceof Types.LazyType ? ((Types.LazyType)type).isJavaVarargsMethod() : this.isJavaVarArgs(m.info().params()));
        }

        public boolean isJavaVarArgs(Seq<Symbols.Symbol> params) {
            return !params.isEmpty() && this.isJavaRepeatedParamType(((Symbols.Symbol)params.last()).tpe());
        }

        public boolean isScalaVarArgs(Seq<Symbols.Symbol> params) {
            return !params.isEmpty() && this.isScalaRepeatedParamType(((Symbols.Symbol)params.last()).tpe());
        }

        public boolean isVarArgsList(Seq<Symbols.Symbol> params) {
            return !params.isEmpty() && this.isRepeatedParamType(((Symbols.Symbol)params.last()).tpe());
        }

        public boolean isVarArgTypes(Seq<Types.Type> formals) {
            return !formals.isEmpty() && this.isRepeatedParamType((Types.Type)formals.last());
        }

        public Types.Type firstParamType(Types.Type tpe) {
            List<Types.Type> list = tpe.paramTypes();
            Types.Type type = list instanceof $colon$colon ? (Types.Type)(($colon$colon)list).head() : this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoType();
            return type;
        }

        public boolean isImplicitParamss(List<List<Symbols.Symbol>> paramss) {
            List list;
            boolean bl = paramss instanceof $colon$colon && (list = (List)(($colon$colon)paramss).head()) instanceof $colon$colon ? ((Symbols.Symbol)(($colon$colon)list).head()).isImplicit() : false;
            return bl;
        }

        public boolean hasRepeatedParam(Types.Type tp) {
            boolean bl;
            if (tp instanceof Types.MethodType) {
                Types.MethodType methodType = (Types.MethodType)tp;
                List<Symbols.Symbol> formals = methodType.params();
                Types.Type restpe = methodType.resultType();
                bl = this.isScalaVarArgs(formals) || this.hasRepeatedParam(restpe);
            } else if (tp instanceof Types.PolyType) {
                Types.Type restpe = ((Types.PolyType)tp).resultType();
                bl = this.hasRepeatedParam(restpe);
            } else {
                bl = false;
            }
            return bl;
        }

        public Types.Type dropByName(Types.Type tp) {
            Types.Type type = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().elementExtract(this.ByNameParamClass(), tp);
            if (type == null) {
                throw null;
            }
            Types.Type orElse_this = type;
            if (orElse_this != orElse_this.scala$reflect$internal$Types$Type$$$outer().NoType()) {
                return orElse_this;
            }
            return tp;
        }

        public Types.Type dropRepeated(Types.Type tp) {
            if (this.isJavaRepeatedParamType(tp)) {
                Types.Type type = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().elementExtract(this.JavaRepeatedParamClass(), tp);
                if (type == null) {
                    throw null;
                }
                Types.Type orElse_this = type;
                if (orElse_this != orElse_this.scala$reflect$internal$Types$Type$$$outer().NoType()) {
                    return orElse_this;
                }
                return tp;
            }
            if (this.isScalaRepeatedParamType(tp)) {
                Types.Type type = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().elementExtract(this.RepeatedParamClass(), tp);
                if (type == null) {
                    throw null;
                }
                Types.Type orElse_this = type;
                if (orElse_this != orElse_this.scala$reflect$internal$Types$Type$$$outer().NoType()) {
                    return orElse_this;
                }
                return tp;
            }
            return tp;
        }

        public Types.Type repeatedToSingle(Types.Type tp) {
            Types.Type type;
            Types.Type type2 = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().elementExtract(this.RepeatedParamClass(), tp);
            if (type2 == null) {
                throw null;
            }
            Types.Type orElse_this = type2;
            Types.Type type3 = type = orElse_this != orElse_this.scala$reflect$internal$Types$Type$$$outer().NoType() ? orElse_this : DefinitionsClass.$anonfun$repeatedToSingle$1(this, tp);
            if (type == null) {
                throw null;
            }
            if (type != type.scala$reflect$internal$Types$Type$$$outer().NoType()) {
                return type;
            }
            return tp;
        }

        public Types.Type repeatedToSeq(Types.Type tp) {
            Types.Type type = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().elementTransform(this.RepeatedParamClass(), tp, (Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)arg -> this.seqType((Types.Type)arg));
            if (type == null) {
                throw null;
            }
            Types.Type orElse_this = type;
            if (orElse_this != orElse_this.scala$reflect$internal$Types$Type$$$outer().NoType()) {
                return orElse_this;
            }
            return tp;
        }

        public Types.Type seqToRepeated(Types.Type tp) {
            Types.Type type = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().elementTransform(this.SeqClass(), tp, (Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)arg -> this.scalaRepeatedType((Types.Type)arg));
            if (type == null) {
                throw null;
            }
            Types.Type orElse_this = type;
            if (orElse_this != orElse_this.scala$reflect$internal$Types$Type$$$outer().NoType()) {
                return orElse_this;
            }
            return tp;
        }

        public boolean isReferenceArray(Types.Type tp) {
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().elementTest(this.ArrayClass(), tp, (Function1<Types.Type, Object> & java.io.Serializable & Serializable)x$8 -> BoxesRunTime.boxToBoolean(x$8.$less$colon$less(this.AnyRefTpe())));
        }

        public boolean isArrayOfSymbol(Types.Type tp, Symbols.Symbol elem) {
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().elementTest(this.ArrayClass(), tp, (Function1<Types.Type, Object> & java.io.Serializable & Serializable)x$9 -> BoxesRunTime.boxToBoolean(DefinitionsClass.$anonfun$isArrayOfSymbol$1(elem, x$9)));
        }

        public Types.Type elementType(Symbols.Symbol container, Types.Type tp) {
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().elementExtract(container, tp);
        }

        private Symbols.ClassSymbol ConsClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 8L) == 0L) {
                    this.ConsClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply($colon$colon.class));
                    this.bitmap$1 |= 8L;
                }
            }
            return this.ConsClass;
        }

        public Symbols.ClassSymbol ConsClass() {
            if ((this.bitmap$1 & 8L) == 0L) {
                return this.ConsClass$lzycompute();
            }
            return this.ConsClass;
        }

        private Symbols.ClassSymbol IteratorClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x10L) == 0L) {
                    this.IteratorClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Iterator.class));
                    this.bitmap$1 |= 0x10L;
                }
            }
            return this.IteratorClass;
        }

        public Symbols.ClassSymbol IteratorClass() {
            if ((this.bitmap$1 & 0x10L) == 0L) {
                return this.IteratorClass$lzycompute();
            }
            return this.IteratorClass;
        }

        private Symbols.ClassSymbol IterableClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x20L) == 0L) {
                    this.IterableClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Iterable.class));
                    this.bitmap$1 |= 0x20L;
                }
            }
            return this.IterableClass;
        }

        public Symbols.ClassSymbol IterableClass() {
            if ((this.bitmap$1 & 0x20L) == 0L) {
                return this.IterableClass$lzycompute();
            }
            return this.IterableClass;
        }

        private Symbols.ClassSymbol ListClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x40L) == 0L) {
                    this.ListClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(List.class));
                    this.bitmap$1 |= 0x40L;
                }
            }
            return this.ListClass;
        }

        @Override
        public Symbols.ClassSymbol ListClass() {
            if ((this.bitmap$1 & 0x40L) == 0L) {
                return this.ListClass$lzycompute();
            }
            return this.ListClass;
        }

        public Symbols.TermSymbol List_cons() {
            return this.getMemberMethod(this.ListClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().CONS());
        }

        private Symbols.ClassSymbol SeqClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x80L) == 0L) {
                    this.SeqClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Seq.class));
                    this.bitmap$1 |= 0x80L;
                }
            }
            return this.SeqClass;
        }

        public Symbols.ClassSymbol SeqClass() {
            if ((this.bitmap$1 & 0x80L) == 0L) {
                return this.SeqClass$lzycompute();
            }
            return this.SeqClass;
        }

        private Symbols.ClassSymbol JavaStringBuilderClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x100L) == 0L) {
                    this.JavaStringBuilderClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(StringBuilder.class));
                    this.bitmap$1 |= 0x100L;
                }
            }
            return this.JavaStringBuilderClass;
        }

        public Symbols.ClassSymbol JavaStringBuilderClass() {
            if ((this.bitmap$1 & 0x100L) == 0L) {
                return this.JavaStringBuilderClass$lzycompute();
            }
            return this.JavaStringBuilderClass;
        }

        private Symbols.ClassSymbol JavaStringBufferClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x200L) == 0L) {
                    this.JavaStringBufferClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(StringBuffer.class));
                    this.bitmap$1 |= 0x200L;
                }
            }
            return this.JavaStringBufferClass;
        }

        public Symbols.ClassSymbol JavaStringBufferClass() {
            if ((this.bitmap$1 & 0x200L) == 0L) {
                return this.JavaStringBufferClass$lzycompute();
            }
            return this.JavaStringBufferClass;
        }

        private Symbols.ClassSymbol JavaCharSequenceClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x400L) == 0L) {
                    this.JavaCharSequenceClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(CharSequence.class));
                    this.bitmap$1 |= 0x400L;
                }
            }
            return this.JavaCharSequenceClass;
        }

        public Symbols.ClassSymbol JavaCharSequenceClass() {
            if ((this.bitmap$1 & 0x400L) == 0L) {
                return this.JavaCharSequenceClass$lzycompute();
            }
            return this.JavaCharSequenceClass;
        }

        private Symbols.ClassSymbol TraversableClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x800L) == 0L) {
                    this.TraversableClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Traversable.class));
                    this.bitmap$1 |= 0x800L;
                }
            }
            return this.TraversableClass;
        }

        public Symbols.ClassSymbol TraversableClass() {
            if ((this.bitmap$1 & 0x800L) == 0L) {
                return this.TraversableClass$lzycompute();
            }
            return this.TraversableClass;
        }

        private Symbols.ModuleSymbol ListModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x1000L) == 0L) {
                    this.ListModule = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredModule(ClassTag$.MODULE$.apply(List$.class));
                    this.bitmap$1 |= 0x1000L;
                }
            }
            return this.ListModule;
        }

        @Override
        public Symbols.ModuleSymbol ListModule() {
            if ((this.bitmap$1 & 0x1000L) == 0L) {
                return this.ListModule$lzycompute();
            }
            return this.ListModule;
        }

        @Override
        public Symbols.TermSymbol List_apply() {
            return this.getMemberMethod(this.ListModule(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().apply());
        }

        private Symbols.ModuleSymbol NilModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x2000L) == 0L) {
                    this.NilModule = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredModule(ClassTag$.MODULE$.apply(Nil$.class));
                    this.bitmap$1 |= 0x2000L;
                }
            }
            return this.NilModule;
        }

        @Override
        public Symbols.ModuleSymbol NilModule() {
            if ((this.bitmap$1 & 0x2000L) == 0L) {
                return this.NilModule$lzycompute();
            }
            return this.NilModule;
        }

        private Symbols.ModuleSymbol SeqModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x4000L) == 0L) {
                    this.SeqModule = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredModule(ClassTag$.MODULE$.apply(scala.collection.Seq$.class));
                    this.bitmap$1 |= 0x4000L;
                }
            }
            return this.SeqModule;
        }

        public Symbols.ModuleSymbol SeqModule() {
            if ((this.bitmap$1 & 0x4000L) == 0L) {
                return this.SeqModule$lzycompute();
            }
            return this.SeqModule;
        }

        private Symbols.ModuleSymbol ISeqModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x8000L) == 0L) {
                    this.ISeqModule = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredModule(ClassTag$.MODULE$.apply(Seq$.class));
                    this.bitmap$1 |= 0x8000L;
                }
            }
            return this.ISeqModule;
        }

        public Symbols.ModuleSymbol ISeqModule() {
            if ((this.bitmap$1 & 0x8000L) == 0L) {
                return this.ISeqModule$lzycompute();
            }
            return this.ISeqModule;
        }

        private Symbols.ModuleSymbol ArrayModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x10000L) == 0L) {
                    this.ArrayModule = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredModule(ClassTag$.MODULE$.apply(Array$.class));
                    this.bitmap$1 |= 0x10000L;
                }
            }
            return this.ArrayModule;
        }

        @Override
        public Symbols.ModuleSymbol ArrayModule() {
            if ((this.bitmap$1 & 0x10000L) == 0L) {
                return this.ArrayModule$lzycompute();
            }
            return this.ArrayModule;
        }

        private Symbols.TermSymbol ArrayModule_overloadedApply$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x20000L) == 0L) {
                    this.ArrayModule_overloadedApply = this.getMemberMethod(this.ArrayModule(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().apply());
                    this.bitmap$1 |= 0x20000L;
                }
            }
            return this.ArrayModule_overloadedApply;
        }

        @Override
        public Symbols.TermSymbol ArrayModule_overloadedApply() {
            if ((this.bitmap$1 & 0x20000L) == 0L) {
                return this.ArrayModule_overloadedApply$lzycompute();
            }
            return this.ArrayModule_overloadedApply;
        }

        public Symbols.Symbol ArrayModule_genericApply() {
            return this.ArrayModule_overloadedApply().suchThat((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$10 -> BoxesRunTime.boxToBoolean(DefinitionsClass.$anonfun$ArrayModule_genericApply$1(this, x$10)));
        }

        public Symbols.Symbol ArrayModule_apply(Types.Type tp) {
            return this.ArrayModule_overloadedApply().suchThat((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$11 -> BoxesRunTime.boxToBoolean(DefinitionsClass.$anonfun$ArrayModule_apply$1(this, tp, x$11)));
        }

        private Symbols.ClassSymbol ArrayClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x40000L) == 0L) {
                    this.ArrayClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getRequiredClass("scala.Array");
                    this.bitmap$1 |= 0x40000L;
                }
            }
            return this.ArrayClass;
        }

        @Override
        public Symbols.ClassSymbol ArrayClass() {
            if ((this.bitmap$1 & 0x40000L) == 0L) {
                return this.ArrayClass$lzycompute();
            }
            return this.ArrayClass;
        }

        private Symbols.TermSymbol Array_apply$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x80000L) == 0L) {
                    this.Array_apply = this.getMemberMethod(this.ArrayClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().apply());
                    this.bitmap$1 |= 0x80000L;
                }
            }
            return this.Array_apply;
        }

        @Override
        public Symbols.TermSymbol Array_apply() {
            if ((this.bitmap$1 & 0x80000L) == 0L) {
                return this.Array_apply$lzycompute();
            }
            return this.Array_apply;
        }

        private Symbols.TermSymbol Array_update$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x100000L) == 0L) {
                    this.Array_update = this.getMemberMethod(this.ArrayClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().update());
                    this.bitmap$1 |= 0x100000L;
                }
            }
            return this.Array_update;
        }

        @Override
        public Symbols.TermSymbol Array_update() {
            if ((this.bitmap$1 & 0x100000L) == 0L) {
                return this.Array_update$lzycompute();
            }
            return this.Array_update;
        }

        private Symbols.TermSymbol Array_length$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x200000L) == 0L) {
                    this.Array_length = this.getMemberMethod(this.ArrayClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().length());
                    this.bitmap$1 |= 0x200000L;
                }
            }
            return this.Array_length;
        }

        @Override
        public Symbols.TermSymbol Array_length() {
            if ((this.bitmap$1 & 0x200000L) == 0L) {
                return this.Array_length$lzycompute();
            }
            return this.Array_length;
        }

        private Symbols.TermSymbol Array_clone$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x400000L) == 0L) {
                    this.Array_clone = this.getMemberMethod(this.ArrayClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().clone_());
                    this.bitmap$1 |= 0x400000L;
                }
            }
            return this.Array_clone;
        }

        @Override
        public Symbols.TermSymbol Array_clone() {
            if ((this.bitmap$1 & 0x400000L) == 0L) {
                return this.Array_clone$lzycompute();
            }
            return this.Array_clone;
        }

        private Symbols.ClassSymbol SoftReferenceClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x800000L) == 0L) {
                    this.SoftReferenceClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(SoftReference.class));
                    this.bitmap$1 |= 0x800000L;
                }
            }
            return this.SoftReferenceClass;
        }

        public Symbols.ClassSymbol SoftReferenceClass() {
            if ((this.bitmap$1 & 0x800000L) == 0L) {
                return this.SoftReferenceClass$lzycompute();
            }
            return this.SoftReferenceClass;
        }

        private Symbols.ClassSymbol MethodClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x1000000L) == 0L) {
                    this.MethodClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassByName("java.lang.reflect.Method");
                    this.bitmap$1 |= 0x1000000L;
                }
            }
            return this.MethodClass;
        }

        public Symbols.ClassSymbol MethodClass() {
            if ((this.bitmap$1 & 0x1000000L) == 0L) {
                return this.MethodClass$lzycompute();
            }
            return this.MethodClass;
        }

        private Symbols.ClassSymbol EmptyMethodCacheClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x2000000L) == 0L) {
                    this.EmptyMethodCacheClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(EmptyMethodCache.class));
                    this.bitmap$1 |= 0x2000000L;
                }
            }
            return this.EmptyMethodCacheClass;
        }

        public Symbols.ClassSymbol EmptyMethodCacheClass() {
            if ((this.bitmap$1 & 0x2000000L) == 0L) {
                return this.EmptyMethodCacheClass$lzycompute();
            }
            return this.EmptyMethodCacheClass;
        }

        private Symbols.ClassSymbol MethodCacheClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x4000000L) == 0L) {
                    this.MethodCacheClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(MethodCache.class));
                    this.bitmap$1 |= 0x4000000L;
                }
            }
            return this.MethodCacheClass;
        }

        public Symbols.ClassSymbol MethodCacheClass() {
            if ((this.bitmap$1 & 0x4000000L) == 0L) {
                return this.MethodCacheClass$lzycompute();
            }
            return this.MethodCacheClass;
        }

        public Symbols.TermSymbol methodCache_find() {
            return this.getMemberMethod(this.MethodCacheClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().find_());
        }

        public Symbols.TermSymbol methodCache_add() {
            return this.getMemberMethod(this.MethodCacheClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().add_());
        }

        private Symbols.Symbol StructuralCallSite$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x8000000L) == 0L) {
                    this.StructuralCallSite = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("scala.runtime.StructuralCallSite");
                    this.bitmap$1 |= 0x8000000L;
                }
            }
            return this.StructuralCallSite;
        }

        public Symbols.Symbol StructuralCallSite() {
            if ((this.bitmap$1 & 0x8000000L) == 0L) {
                return this.StructuralCallSite$lzycompute();
            }
            return this.StructuralCallSite;
        }

        public Symbols.TermSymbol StructuralCallSite_bootstrap() {
            return this.getMemberMethod(this.StructuralCallSite().linkedClassOfClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().sn().Bootstrap());
        }

        private Symbols.MethodSymbol StructuralCallSite_dummy$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x10000000L) == 0L) {
                    this.StructuralCallSite_dummy = (Symbols.MethodSymbol)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol().newMethodSymbol(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().apply(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol().newMethodSymbol$default$2(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol().newMethodSymbol$default$3()).setInfo(new Types.NullaryMethodType(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer(), this.StructuralCallSite().tpe()));
                    this.bitmap$1 |= 0x10000000L;
                }
            }
            return this.StructuralCallSite_dummy;
        }

        public Symbols.MethodSymbol StructuralCallSite_dummy() {
            if ((this.bitmap$1 & 0x10000000L) == 0L) {
                return this.StructuralCallSite_dummy$lzycompute();
            }
            return this.StructuralCallSite_dummy;
        }

        public Symbols.Symbol StructuralCallSite_find() {
            return this.getMemberIfDefined(this.StructuralCallSite(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().find_());
        }

        public Symbols.Symbol StructuralCallSite_add() {
            return this.getMemberIfDefined(this.StructuralCallSite(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().add_());
        }

        public Symbols.Symbol StructuralCallSite_getParameterTypes() {
            return this.getMemberIfDefined(this.StructuralCallSite(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().parameterTypes());
        }

        private Symbols.Symbol SymbolLiteral$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x20000000L) == 0L) {
                    this.SymbolLiteral = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("scala.runtime.SymbolLiteral");
                    this.bitmap$1 |= 0x20000000L;
                }
            }
            return this.SymbolLiteral;
        }

        public Symbols.Symbol SymbolLiteral() {
            if ((this.bitmap$1 & 0x20000000L) == 0L) {
                return this.SymbolLiteral$lzycompute();
            }
            return this.SymbolLiteral;
        }

        public Symbols.Symbol SymbolLiteral_bootstrap() {
            return this.getMemberIfDefined(this.SymbolLiteral().linkedClassOfClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().sn().Bootstrap());
        }

        public Symbols.MethodSymbol SymbolLiteral_dummy() {
            return (Symbols.MethodSymbol)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol().newMethodSymbol(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().apply(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol().newMethodSymbol$default$2(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol().newMethodSymbol$default$3()).setInfo(new Types.NullaryMethodType(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer(), this.SymbolModule().companionClass().tpe()));
        }

        private Symbols.Symbol ScalaXmlTopScope$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x40000000L) == 0L) {
                    this.ScalaXmlTopScope = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getModuleIfDefined("scala.xml.TopScope");
                    this.bitmap$1 |= 0x40000000L;
                }
            }
            return this.ScalaXmlTopScope;
        }

        public Symbols.Symbol ScalaXmlTopScope() {
            if ((this.bitmap$1 & 0x40000000L) == 0L) {
                return this.ScalaXmlTopScope$lzycompute();
            }
            return this.ScalaXmlTopScope;
        }

        private Symbols.Symbol ScalaXmlPackage$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x80000000L) == 0L) {
                    this.ScalaXmlPackage = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getPackageIfDefined("scala.xml");
                    this.bitmap$1 |= 0x80000000L;
                }
            }
            return this.ScalaXmlPackage;
        }

        public Symbols.Symbol ScalaXmlPackage() {
            if ((this.bitmap$1 & 0x80000000L) == 0L) {
                return this.ScalaXmlPackage$lzycompute();
            }
            return this.ScalaXmlPackage;
        }

        private Symbols.ModuleSymbol ReflectPackage$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x100000000L) == 0L) {
                    this.ReflectPackage = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredModule(ClassTag$.MODULE$.apply(scala.reflect.package$.class));
                    this.bitmap$1 |= 0x100000000L;
                }
            }
            return this.ReflectPackage;
        }

        public Symbols.ModuleSymbol ReflectPackage() {
            if ((this.bitmap$1 & 0x100000000L) == 0L) {
                return this.ReflectPackage$lzycompute();
            }
            return this.ReflectPackage;
        }

        private Symbols.Symbol ReflectApiPackage$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x200000000L) == 0L) {
                    this.ReflectApiPackage = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getPackageObjectIfDefined("scala.reflect.api");
                    this.bitmap$1 |= 0x200000000L;
                }
            }
            return this.ReflectApiPackage;
        }

        public Symbols.Symbol ReflectApiPackage() {
            if ((this.bitmap$1 & 0x200000000L) == 0L) {
                return this.ReflectApiPackage$lzycompute();
            }
            return this.ReflectApiPackage;
        }

        private Symbols.Symbol ReflectRuntimePackage$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x400000000L) == 0L) {
                    this.ReflectRuntimePackage = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getPackageObjectIfDefined("scala.reflect.runtime");
                    this.bitmap$1 |= 0x400000000L;
                }
            }
            return this.ReflectRuntimePackage;
        }

        public Symbols.Symbol ReflectRuntimePackage() {
            if ((this.bitmap$1 & 0x400000000L) == 0L) {
                return this.ReflectRuntimePackage$lzycompute();
            }
            return this.ReflectRuntimePackage;
        }

        public Symbols.Symbol ReflectRuntimeUniverse() {
            Symbols.Symbol symbol = this.ReflectRuntimePackage();
            if (symbol == null) {
                throw null;
            }
            Symbols.Symbol map_this = symbol;
            if (map_this == map_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                return map_this;
            }
            Symbols.Symbol symbol2 = map_this;
            return this.getDeclValue(symbol2, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().universe());
        }

        public Symbols.Symbol ReflectRuntimeCurrentMirror() {
            Symbols.Symbol symbol = this.ReflectRuntimePackage();
            if (symbol == null) {
                throw null;
            }
            Symbols.Symbol map_this = symbol;
            if (map_this == map_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                return map_this;
            }
            Symbols.Symbol symbol2 = map_this;
            return this.getDeclMethod(symbol2, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().currentMirror());
        }

        private Symbols.Symbol UniverseClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x800000000L) == 0L) {
                    this.UniverseClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("scala.reflect.api.Universe");
                    this.bitmap$1 |= 0x800000000L;
                }
            }
            return this.UniverseClass;
        }

        public Symbols.Symbol UniverseClass() {
            if ((this.bitmap$1 & 0x800000000L) == 0L) {
                return this.UniverseClass$lzycompute();
            }
            return this.UniverseClass;
        }

        public Symbols.TermSymbol UniverseInternal() {
            return this.getMemberValue(this.UniverseClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().internal());
        }

        private Symbols.ModuleSymbol PartialManifestModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x1000000000L) == 0L) {
                    this.PartialManifestModule = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredModule(ClassTag$.MODULE$.apply(ClassManifestFactory$.class));
                    this.bitmap$1 |= 0x1000000000L;
                }
            }
            return this.PartialManifestModule;
        }

        public Symbols.ModuleSymbol PartialManifestModule() {
            if ((this.bitmap$1 & 0x1000000000L) == 0L) {
                return this.PartialManifestModule$lzycompute();
            }
            return this.PartialManifestModule;
        }

        private Symbols.ClassSymbol FullManifestClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x2000000000L) == 0L) {
                    this.FullManifestClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Manifest.class));
                    this.bitmap$1 |= 0x2000000000L;
                }
            }
            return this.FullManifestClass;
        }

        public Symbols.ClassSymbol FullManifestClass() {
            if ((this.bitmap$1 & 0x2000000000L) == 0L) {
                return this.FullManifestClass$lzycompute();
            }
            return this.FullManifestClass;
        }

        private Symbols.ModuleSymbol FullManifestModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x4000000000L) == 0L) {
                    this.FullManifestModule = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredModule(ClassTag$.MODULE$.apply(ManifestFactory$.class));
                    this.bitmap$1 |= 0x4000000000L;
                }
            }
            return this.FullManifestModule;
        }

        public Symbols.ModuleSymbol FullManifestModule() {
            if ((this.bitmap$1 & 0x4000000000L) == 0L) {
                return this.FullManifestModule$lzycompute();
            }
            return this.FullManifestModule;
        }

        private Symbols.ClassSymbol OptManifestClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x8000000000L) == 0L) {
                    this.OptManifestClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(OptManifest.class));
                    this.bitmap$1 |= 0x8000000000L;
                }
            }
            return this.OptManifestClass;
        }

        public Symbols.ClassSymbol OptManifestClass() {
            if ((this.bitmap$1 & 0x8000000000L) == 0L) {
                return this.OptManifestClass$lzycompute();
            }
            return this.OptManifestClass;
        }

        private Symbols.ModuleSymbol NoManifest$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x10000000000L) == 0L) {
                    this.NoManifest = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredModule(ClassTag$.MODULE$.apply(NoManifest$.class));
                    this.bitmap$1 |= 0x10000000000L;
                }
            }
            return this.NoManifest;
        }

        public Symbols.ModuleSymbol NoManifest() {
            if ((this.bitmap$1 & 0x10000000000L) == 0L) {
                return this.NoManifest$lzycompute();
            }
            return this.NoManifest;
        }

        private Symbols.Symbol TreesClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x20000000000L) == 0L) {
                    this.TreesClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("scala.reflect.api.Trees");
                    this.bitmap$1 |= 0x20000000000L;
                }
            }
            return this.TreesClass;
        }

        public Symbols.Symbol TreesClass() {
            if ((this.bitmap$1 & 0x20000000000L) == 0L) {
                return this.TreesClass$lzycompute();
            }
            return this.TreesClass;
        }

        private Symbols.Symbol ExprsClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x40000000000L) == 0L) {
                    this.ExprsClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("scala.reflect.api.Exprs");
                    this.bitmap$1 |= 0x40000000000L;
                }
            }
            return this.ExprsClass;
        }

        public Symbols.Symbol ExprsClass() {
            if ((this.bitmap$1 & 0x40000000000L) == 0L) {
                return this.ExprsClass$lzycompute();
            }
            return this.ExprsClass;
        }

        public Symbols.Symbol ExprClass() {
            Symbols.Symbol symbol = this.ExprsClass();
            if (symbol == null) {
                throw null;
            }
            Symbols.Symbol map_this = symbol;
            if (map_this == map_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                return map_this;
            }
            Symbols.Symbol symbol2 = map_this;
            return this.getMemberClass(symbol2, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().Expr());
        }

        public Symbols.Symbol ExprSplice() {
            Symbols.Symbol symbol = this.ExprClass();
            if (symbol == null) {
                throw null;
            }
            Symbols.Symbol map_this = symbol;
            if (map_this == map_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                return map_this;
            }
            Symbols.Symbol symbol2 = map_this;
            return this.getMemberMethod(symbol2, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().splice());
        }

        public Symbols.Symbol ExprValue() {
            Symbols.Symbol symbol = this.ExprClass();
            if (symbol == null) {
                throw null;
            }
            Symbols.Symbol map_this = symbol;
            if (map_this == map_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                return map_this;
            }
            Symbols.Symbol symbol2 = map_this;
            return this.getMemberMethod(symbol2, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().value());
        }

        private Symbols.ModuleSymbol ClassTagModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x80000000000L) == 0L) {
                    this.ClassTagModule = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredModule(ClassTag$.MODULE$.apply(ClassTag.class));
                    this.bitmap$1 |= 0x80000000000L;
                }
            }
            return this.ClassTagModule;
        }

        public Symbols.ModuleSymbol ClassTagModule() {
            if ((this.bitmap$1 & 0x80000000000L) == 0L) {
                return this.ClassTagModule$lzycompute();
            }
            return this.ClassTagModule;
        }

        private Symbols.ClassSymbol ClassTagClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x100000000000L) == 0L) {
                    this.ClassTagClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(ClassTag.class));
                    this.bitmap$1 |= 0x100000000000L;
                }
            }
            return this.ClassTagClass;
        }

        public Symbols.ClassSymbol ClassTagClass() {
            if ((this.bitmap$1 & 0x100000000000L) == 0L) {
                return this.ClassTagClass$lzycompute();
            }
            return this.ClassTagClass;
        }

        private Symbols.Symbol TypeTagsClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x200000000000L) == 0L) {
                    this.TypeTagsClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("scala.reflect.api.TypeTags");
                    this.bitmap$1 |= 0x200000000000L;
                }
            }
            return this.TypeTagsClass;
        }

        public Symbols.Symbol TypeTagsClass() {
            if ((this.bitmap$1 & 0x200000000000L) == 0L) {
                return this.TypeTagsClass$lzycompute();
            }
            return this.TypeTagsClass;
        }

        private Symbols.Symbol ApiUniverseClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x400000000000L) == 0L) {
                    this.ApiUniverseClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("scala.reflect.api.Universe");
                    this.bitmap$1 |= 0x400000000000L;
                }
            }
            return this.ApiUniverseClass;
        }

        public Symbols.Symbol ApiUniverseClass() {
            if ((this.bitmap$1 & 0x400000000000L) == 0L) {
                return this.ApiUniverseClass$lzycompute();
            }
            return this.ApiUniverseClass;
        }

        private Symbols.Symbol ApiQuasiquotesClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x800000000000L) == 0L) {
                    this.ApiQuasiquotesClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("scala.reflect.api.Quasiquotes");
                    this.bitmap$1 |= 0x800000000000L;
                }
            }
            return this.ApiQuasiquotesClass;
        }

        public Symbols.Symbol ApiQuasiquotesClass() {
            if ((this.bitmap$1 & 0x800000000000L) == 0L) {
                return this.ApiQuasiquotesClass$lzycompute();
            }
            return this.ApiQuasiquotesClass;
        }

        private Symbols.Symbol JavaUniverseClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x1000000000000L) == 0L) {
                    this.JavaUniverseClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("scala.reflect.api.JavaUniverse");
                    this.bitmap$1 |= 0x1000000000000L;
                }
            }
            return this.JavaUniverseClass;
        }

        public Symbols.Symbol JavaUniverseClass() {
            if ((this.bitmap$1 & 0x1000000000000L) == 0L) {
                return this.JavaUniverseClass$lzycompute();
            }
            return this.JavaUniverseClass;
        }

        private Symbols.Symbol MirrorClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x2000000000000L) == 0L) {
                    this.MirrorClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("scala.reflect.api.Mirror");
                    this.bitmap$1 |= 0x2000000000000L;
                }
            }
            return this.MirrorClass;
        }

        public Symbols.Symbol MirrorClass() {
            if ((this.bitmap$1 & 0x2000000000000L) == 0L) {
                return this.MirrorClass$lzycompute();
            }
            return this.MirrorClass;
        }

        private Symbols.Symbol TypeCreatorClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x4000000000000L) == 0L) {
                    this.TypeCreatorClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("scala.reflect.api.TypeCreator");
                    this.bitmap$1 |= 0x4000000000000L;
                }
            }
            return this.TypeCreatorClass;
        }

        public Symbols.Symbol TypeCreatorClass() {
            if ((this.bitmap$1 & 0x4000000000000L) == 0L) {
                return this.TypeCreatorClass$lzycompute();
            }
            return this.TypeCreatorClass;
        }

        private Symbols.Symbol TreeCreatorClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x8000000000000L) == 0L) {
                    this.TreeCreatorClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("scala.reflect.api.TreeCreator");
                    this.bitmap$1 |= 0x8000000000000L;
                }
            }
            return this.TreeCreatorClass;
        }

        public Symbols.Symbol TreeCreatorClass() {
            if ((this.bitmap$1 & 0x8000000000000L) == 0L) {
                return this.TreeCreatorClass$lzycompute();
            }
            return this.TreeCreatorClass;
        }

        private Symbols.Symbol Context_210() {
            if (this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().settings().isScala211()) {
                return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol();
            }
            return ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("scala.reflect.macros.Context");
        }

        private Symbols.Symbol BlackboxContextClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x10000000000000L) == 0L) {
                    Symbols.Symbol symbol = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("scala.reflect.macros.blackbox.Context");
                    if (symbol == null) {
                        throw null;
                    }
                    Symbols.Symbol orElse_this = symbol;
                    this.BlackboxContextClass = orElse_this != orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol() ? orElse_this : this.Context_210();
                    this.bitmap$1 |= 0x10000000000000L;
                }
            }
            return this.BlackboxContextClass;
        }

        public Symbols.Symbol BlackboxContextClass() {
            if ((this.bitmap$1 & 0x10000000000000L) == 0L) {
                return this.BlackboxContextClass$lzycompute();
            }
            return this.BlackboxContextClass;
        }

        private Symbols.Symbol WhiteboxContextClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x20000000000000L) == 0L) {
                    Symbols.Symbol symbol = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("scala.reflect.macros.whitebox.Context");
                    if (symbol == null) {
                        throw null;
                    }
                    Symbols.Symbol orElse_this = symbol;
                    this.WhiteboxContextClass = orElse_this != orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol() ? orElse_this : this.Context_210();
                    this.bitmap$1 |= 0x20000000000000L;
                }
            }
            return this.WhiteboxContextClass;
        }

        public Symbols.Symbol WhiteboxContextClass() {
            if ((this.bitmap$1 & 0x20000000000000L) == 0L) {
                return this.WhiteboxContextClass$lzycompute();
            }
            return this.WhiteboxContextClass;
        }

        public Symbols.Symbol MacroContextPrefix() {
            Symbols.Symbol symbol = this.BlackboxContextClass();
            if (symbol == null) {
                throw null;
            }
            Symbols.Symbol map_this = symbol;
            if (map_this == map_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                return map_this;
            }
            Symbols.Symbol symbol2 = map_this;
            return this.getMemberMethod(symbol2, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().prefix());
        }

        public Symbols.Symbol MacroContextPrefixType() {
            Symbols.Symbol symbol = this.BlackboxContextClass();
            if (symbol == null) {
                throw null;
            }
            Symbols.Symbol map_this = symbol;
            if (map_this == map_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                return map_this;
            }
            Symbols.Symbol symbol2 = map_this;
            return this.getTypeMember(symbol2, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().PrefixType());
        }

        public Symbols.Symbol MacroContextUniverse() {
            Symbols.Symbol symbol = this.BlackboxContextClass();
            if (symbol == null) {
                throw null;
            }
            Symbols.Symbol map_this = symbol;
            if (map_this == map_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                return map_this;
            }
            Symbols.Symbol symbol2 = map_this;
            return this.getMemberMethod(symbol2, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().universe());
        }

        public Symbols.Symbol MacroContextExprClass() {
            Symbols.Symbol symbol = this.BlackboxContextClass();
            if (symbol == null) {
                throw null;
            }
            Symbols.Symbol map_this = symbol;
            if (map_this == map_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                return map_this;
            }
            Symbols.Symbol symbol2 = map_this;
            return this.getTypeMember(symbol2, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().Expr());
        }

        public Symbols.Symbol MacroContextWeakTypeTagClass() {
            Symbols.Symbol symbol = this.BlackboxContextClass();
            if (symbol == null) {
                throw null;
            }
            Symbols.Symbol map_this = symbol;
            if (map_this == map_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                return map_this;
            }
            Symbols.Symbol symbol2 = map_this;
            return this.getTypeMember(symbol2, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().WeakTypeTag());
        }

        public Symbols.Symbol MacroContextTreeType() {
            Symbols.Symbol symbol = this.BlackboxContextClass();
            if (symbol == null) {
                throw null;
            }
            Symbols.Symbol map_this = symbol;
            if (map_this == map_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                return map_this;
            }
            Symbols.Symbol symbol2 = map_this;
            return this.getTypeMember(symbol2, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().Tree());
        }

        private Symbols.ClassSymbol MacroImplAnnotation$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x40000000000000L) == 0L) {
                    this.MacroImplAnnotation = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(macroImpl.class));
                    this.bitmap$1 |= 0x40000000000000L;
                }
            }
            return this.MacroImplAnnotation;
        }

        public Symbols.ClassSymbol MacroImplAnnotation() {
            if ((this.bitmap$1 & 0x40000000000000L) == 0L) {
                return this.MacroImplAnnotation$lzycompute();
            }
            return this.MacroImplAnnotation;
        }

        private Symbols.ClassSymbol StringContextClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x80000000000000L) == 0L) {
                    this.StringContextClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(StringContext.class));
                    this.bitmap$1 |= 0x80000000000000L;
                }
            }
            return this.StringContextClass;
        }

        public Symbols.ClassSymbol StringContextClass() {
            if ((this.bitmap$1 & 0x80000000000000L) == 0L) {
                return this.StringContextClass$lzycompute();
            }
            return this.StringContextClass;
        }

        private Symbols.ModuleSymbol StringContextModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x100000000000000L) == 0L) {
                    this.StringContextModule = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredModule(ClassTag$.MODULE$.apply(StringContext$.class));
                    this.bitmap$1 |= 0x100000000000000L;
                }
            }
            return this.StringContextModule;
        }

        public Symbols.ModuleSymbol StringContextModule() {
            if ((this.bitmap$1 & 0x100000000000000L) == 0L) {
                return this.StringContextModule$lzycompute();
            }
            return this.StringContextModule;
        }

        private Symbols.Symbol QuasiquoteClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x200000000000000L) == 0L) {
                    Symbols.Symbol symbol = this.ApiUniverseClass();
                    Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol();
                    this.QuasiquoteClass = (symbol == null ? noSymbol != null : !symbol.equals(noSymbol)) ? this.ApiQuasiquotesClass().info().decl(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().Quasiquote()) : this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol();
                    this.bitmap$1 |= 0x200000000000000L;
                }
            }
            return this.QuasiquoteClass;
        }

        public Symbols.Symbol QuasiquoteClass() {
            if ((this.bitmap$1 & 0x200000000000000L) == 0L) {
                return this.QuasiquoteClass$lzycompute();
            }
            return this.QuasiquoteClass;
        }

        private Symbols.Symbol QuasiquoteClass_api$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x400000000000000L) == 0L) {
                    Symbols.Symbol symbol = this.QuasiquoteClass();
                    Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol();
                    this.QuasiquoteClass_api = (symbol == null ? noSymbol != null : !symbol.equals(noSymbol)) ? this.QuasiquoteClass().info().decl(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().api()) : this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol();
                    this.bitmap$1 |= 0x400000000000000L;
                }
            }
            return this.QuasiquoteClass_api;
        }

        public Symbols.Symbol QuasiquoteClass_api() {
            if ((this.bitmap$1 & 0x400000000000000L) == 0L) {
                return this.QuasiquoteClass_api$lzycompute();
            }
            return this.QuasiquoteClass_api;
        }

        private Symbols.Symbol QuasiquoteClass_api_apply$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x800000000000000L) == 0L) {
                    Symbols.Symbol symbol = this.QuasiquoteClass_api();
                    Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol();
                    this.QuasiquoteClass_api_apply = (symbol == null ? noSymbol != null : !symbol.equals(noSymbol)) ? this.getDeclMethod(this.QuasiquoteClass_api(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().apply()) : this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol();
                    this.bitmap$1 |= 0x800000000000000L;
                }
            }
            return this.QuasiquoteClass_api_apply;
        }

        public Symbols.Symbol QuasiquoteClass_api_apply() {
            if ((this.bitmap$1 & 0x800000000000000L) == 0L) {
                return this.QuasiquoteClass_api_apply$lzycompute();
            }
            return this.QuasiquoteClass_api_apply;
        }

        private Symbols.Symbol QuasiquoteClass_api_unapply$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x1000000000000000L) == 0L) {
                    Symbols.Symbol symbol = this.QuasiquoteClass_api();
                    Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol();
                    this.QuasiquoteClass_api_unapply = (symbol == null ? noSymbol != null : !symbol.equals(noSymbol)) ? this.getDeclMethod(this.QuasiquoteClass_api(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().unapply()) : this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol();
                    this.bitmap$1 |= 0x1000000000000000L;
                }
            }
            return this.QuasiquoteClass_api_unapply;
        }

        public Symbols.Symbol QuasiquoteClass_api_unapply() {
            if ((this.bitmap$1 & 0x1000000000000000L) == 0L) {
                return this.QuasiquoteClass_api_unapply$lzycompute();
            }
            return this.QuasiquoteClass_api_unapply;
        }

        private Symbols.ClassSymbol ScalaSignatureAnnotation$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x2000000000000000L) == 0L) {
                    this.ScalaSignatureAnnotation = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(ScalaSignature.class));
                    this.bitmap$1 |= 0x2000000000000000L;
                }
            }
            return this.ScalaSignatureAnnotation;
        }

        public Symbols.ClassSymbol ScalaSignatureAnnotation() {
            if ((this.bitmap$1 & 0x2000000000000000L) == 0L) {
                return this.ScalaSignatureAnnotation$lzycompute();
            }
            return this.ScalaSignatureAnnotation;
        }

        private Symbols.ClassSymbol ScalaLongSignatureAnnotation$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & 0x4000000000000000L) == 0L) {
                    this.ScalaLongSignatureAnnotation = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(ScalaLongSignature.class));
                    this.bitmap$1 |= 0x4000000000000000L;
                }
            }
            return this.ScalaLongSignatureAnnotation;
        }

        public Symbols.ClassSymbol ScalaLongSignatureAnnotation() {
            if ((this.bitmap$1 & 0x4000000000000000L) == 0L) {
                return this.ScalaLongSignatureAnnotation$lzycompute();
            }
            return this.ScalaLongSignatureAnnotation;
        }

        private Symbols.Symbol MethodHandleClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$1 & Long.MIN_VALUE) == 0L) {
                    this.MethodHandleClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("java.lang.invoke.MethodHandle");
                    this.bitmap$1 |= Long.MIN_VALUE;
                }
            }
            return this.MethodHandleClass;
        }

        public Symbols.Symbol MethodHandleClass() {
            if ((this.bitmap$1 & Long.MIN_VALUE) == 0L) {
                return this.MethodHandleClass$lzycompute();
            }
            return this.MethodHandleClass;
        }

        private Symbols.Symbol VarHandleClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 1L) == 0L) {
                    this.VarHandleClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("java.lang.invoke.VarHandle");
                    this.bitmap$2 |= 1L;
                }
            }
            return this.VarHandleClass;
        }

        public Symbols.Symbol VarHandleClass() {
            if ((this.bitmap$2 & 1L) == 0L) {
                return this.VarHandleClass$lzycompute();
            }
            return this.VarHandleClass;
        }

        private Symbols.ClassSymbol OptionClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 2L) == 0L) {
                    this.OptionClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Option.class));
                    this.bitmap$2 |= 2L;
                }
            }
            return this.OptionClass;
        }

        @Override
        public Symbols.ClassSymbol OptionClass() {
            if ((this.bitmap$2 & 2L) == 0L) {
                return this.OptionClass$lzycompute();
            }
            return this.OptionClass;
        }

        private Symbols.ModuleSymbol OptionModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 4L) == 0L) {
                    this.OptionModule = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredModule(ClassTag$.MODULE$.apply(Option$.class));
                    this.bitmap$2 |= 4L;
                }
            }
            return this.OptionModule;
        }

        public Symbols.ModuleSymbol OptionModule() {
            if ((this.bitmap$2 & 4L) == 0L) {
                return this.OptionModule$lzycompute();
            }
            return this.OptionModule;
        }

        private Symbols.ClassSymbol SomeClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 8L) == 0L) {
                    this.SomeClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Some.class));
                    this.bitmap$2 |= 8L;
                }
            }
            return this.SomeClass;
        }

        public Symbols.ClassSymbol SomeClass() {
            if ((this.bitmap$2 & 8L) == 0L) {
                return this.SomeClass$lzycompute();
            }
            return this.SomeClass;
        }

        private Symbols.ModuleSymbol NoneModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x10L) == 0L) {
                    this.NoneModule = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredModule(ClassTag$.MODULE$.apply(None$.class));
                    this.bitmap$2 |= 0x10L;
                }
            }
            return this.NoneModule;
        }

        @Override
        public Symbols.ModuleSymbol NoneModule() {
            if ((this.bitmap$2 & 0x10L) == 0L) {
                return this.NoneModule$lzycompute();
            }
            return this.NoneModule;
        }

        private Symbols.ModuleSymbol SomeModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x20L) == 0L) {
                    this.SomeModule = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredModule(ClassTag$.MODULE$.apply(Some$.class));
                    this.bitmap$2 |= 0x20L;
                }
            }
            return this.SomeModule;
        }

        @Override
        public Symbols.ModuleSymbol SomeModule() {
            if ((this.bitmap$2 & 0x20L) == 0L) {
                return this.SomeModule$lzycompute();
            }
            return this.SomeModule;
        }

        public Types.Type compilerTypeFromTag(TypeTags.WeakTypeTag<?> tt) {
            return (Types.Type)tt.in(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).tpe();
        }

        public Symbols.Symbol compilerSymbolFromTag(TypeTags.WeakTypeTag<?> tt) {
            return ((Types.Type)tt.in(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).tpe()).typeSymbol();
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean isJavaMainMethod(Symbols.Symbol sym) {
            Types.Type type;
            Names.Name name = sym.name();
            Names.TermName termName = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().main();
            if (name == null) {
                if (termName != null) {
                    return false;
                }
            } else if (!name.equals(termName)) return false;
            if (!((type = sym.info()) instanceof Types.MethodType)) return false;
            Types.MethodType methodType = (Types.MethodType)type;
            List<Symbols.Symbol> list = methodType.params();
            Types.Type restpe = methodType.resultType();
            if (!(list instanceof $colon$colon)) return false;
            $colon$colon $colon$colon = ($colon$colon)list;
            Symbols.Symbol p = (Symbols.Symbol)$colon$colon.head();
            List list2 = $colon$colon.tl$access$1();
            if (!((Object)Nil$.MODULE$).equals(list2)) return false;
            if (!this.isArrayOfSymbol(p.tpe(), this.StringClass())) return false;
            Symbols.Symbol symbol = restpe.typeSymbol();
            Symbols.ClassSymbol classSymbol = this.UnitClass();
            if (symbol != null) {
                if (!symbol.equals(classSymbol)) return false;
                return true;
            }
            if (classSymbol == null) return true;
            return false;
        }

        public boolean hasJavaMainMethod(Symbols.Symbol sym) {
            boolean bl;
            block3: {
                List<Symbols.Symbol> list = sym.tpe().member(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().main()).alternatives();
                if (list == null) {
                    throw null;
                }
                LinearSeqOptimized exists_these = list;
                while (!exists_these.isEmpty()) {
                    Symbols.Symbol symbol = (Symbols.Symbol)exists_these.head();
                    if (this.isJavaMainMethod(symbol)) {
                        bl = true;
                        break block3;
                    }
                    exists_these = (LinearSeqOptimized)exists_these.tail();
                }
                bl = false;
            }
            return bl;
        }

        public int MaxTupleArity() {
            return this.MaxTupleArity;
        }

        public int MaxProductArity() {
            return this.MaxProductArity;
        }

        public int MaxFunctionArity() {
            return this.MaxFunctionArity;
        }

        public int MaxTupleAritySpecialized() {
            return this.MaxTupleAritySpecialized;
        }

        public int MaxProductAritySpecialized() {
            return this.MaxProductAritySpecialized;
        }

        public int MaxFunctionAritySpecialized() {
            return this.MaxFunctionAritySpecialized;
        }

        private VarArityClass ProductClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x40L) == 0L) {
                    this.ProductClass = new VarArityClass(this, "Product", this.MaxProductArity(), 1, new Some<Symbols.ClassSymbol>(this.UnitClass()));
                    this.bitmap$2 |= 0x40L;
                }
            }
            return this.ProductClass;
        }

        @Override
        public VarArityClass ProductClass() {
            if ((this.bitmap$2 & 0x40L) == 0L) {
                return this.ProductClass$lzycompute();
            }
            return this.ProductClass;
        }

        private VarArityClass TupleClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x80L) == 0L) {
                    this.TupleClass = new VarArityClass(this, "Tuple", this.MaxTupleArity(), 1, this.VarArityClass().$lessinit$greater$default$4());
                    this.bitmap$2 |= 0x80L;
                }
            }
            return this.TupleClass;
        }

        @Override
        public VarArityClass TupleClass() {
            if ((this.bitmap$2 & 0x80L) == 0L) {
                return this.TupleClass$lzycompute();
            }
            return this.TupleClass;
        }

        private VarArityClass FunctionClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x100L) == 0L) {
                    this.FunctionClass = new VarArityClass(this, "Function", this.MaxFunctionArity(), this.VarArityClass().$lessinit$greater$default$3(), this.VarArityClass().$lessinit$greater$default$4());
                    this.bitmap$2 |= 0x100L;
                }
            }
            return this.FunctionClass;
        }

        @Override
        public VarArityClass FunctionClass() {
            if ((this.bitmap$2 & 0x100L) == 0L) {
                return this.FunctionClass$lzycompute();
            }
            return this.FunctionClass;
        }

        private VarArityClass AbstractFunctionClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x200L) == 0L) {
                    this.AbstractFunctionClass = new VarArityClass(this, "runtime.AbstractFunction", this.MaxFunctionArity(), this.VarArityClass().$lessinit$greater$default$3(), this.VarArityClass().$lessinit$greater$default$4());
                    this.bitmap$2 |= 0x200L;
                }
            }
            return this.AbstractFunctionClass;
        }

        public VarArityClass AbstractFunctionClass() {
            if ((this.bitmap$2 & 0x200L) == 0L) {
                return this.AbstractFunctionClass$lzycompute();
            }
            return this.AbstractFunctionClass;
        }

        public Types.Type tupleType(List<Types.Type> elems) {
            return this.TupleClass().specificType(elems, this.TupleClass().specificType$default$2());
        }

        public Types.Type functionType(List<Types.Type> formals, Types.Type restpe) {
            return this.FunctionClass().specificType(formals, Nil$.MODULE$.$colon$colon(restpe));
        }

        public Types.Type abstractFunctionType(List<Types.Type> formals, Types.Type restpe) {
            return this.AbstractFunctionClass().specificType(formals, Nil$.MODULE$.$colon$colon(restpe));
        }

        public Names.TermName wrapArrayMethodName(Types.Type elemtp) {
            Names.TermName termName;
            Symbols.Symbol symbol = elemtp.typeSymbol();
            Symbols.ClassSymbol classSymbol = this.ByteClass();
            if (!(classSymbol != null ? !classSymbol.equals(symbol) : symbol != null)) {
                termName = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().wrapByteArray();
            } else {
                Symbols.ClassSymbol classSymbol2 = this.ShortClass();
                if (!(classSymbol2 != null ? !classSymbol2.equals(symbol) : symbol != null)) {
                    termName = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().wrapShortArray();
                } else {
                    Symbols.ClassSymbol classSymbol3 = this.CharClass();
                    if (!(classSymbol3 != null ? !classSymbol3.equals(symbol) : symbol != null)) {
                        termName = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().wrapCharArray();
                    } else {
                        Symbols.ClassSymbol classSymbol4 = this.IntClass();
                        if (!(classSymbol4 != null ? !classSymbol4.equals(symbol) : symbol != null)) {
                            termName = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().wrapIntArray();
                        } else {
                            Symbols.ClassSymbol classSymbol5 = this.LongClass();
                            if (!(classSymbol5 != null ? !classSymbol5.equals(symbol) : symbol != null)) {
                                termName = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().wrapLongArray();
                            } else {
                                Symbols.ClassSymbol classSymbol6 = this.FloatClass();
                                if (!(classSymbol6 != null ? !classSymbol6.equals(symbol) : symbol != null)) {
                                    termName = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().wrapFloatArray();
                                } else {
                                    Symbols.ClassSymbol classSymbol7 = this.DoubleClass();
                                    if (!(classSymbol7 != null ? !classSymbol7.equals(symbol) : symbol != null)) {
                                        termName = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().wrapDoubleArray();
                                    } else {
                                        Symbols.ClassSymbol classSymbol8 = this.BooleanClass();
                                        if (!(classSymbol8 != null ? !classSymbol8.equals(symbol) : symbol != null)) {
                                            termName = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().wrapBooleanArray();
                                        } else {
                                            Symbols.ClassSymbol classSymbol9 = this.UnitClass();
                                            termName = !(classSymbol9 != null ? !classSymbol9.equals(symbol) : symbol != null) ? this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().wrapUnitArray() : (elemtp.$less$colon$less(this.AnyRefTpe()) && !this.isPhantomClass().apply(elemtp.typeSymbol()) ? this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().wrapRefArray() : this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().genericWrapArray());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return termName;
        }

        public boolean isTupleSymbol(Symbols.Symbol sym) {
            return this.TupleClass().contains(this.unspecializedSymbol(sym));
        }

        public boolean isFunctionSymbol(Symbols.Symbol sym) {
            return this.FunctionClass().contains(this.unspecializedSymbol(sym));
        }

        public boolean isProductNSymbol(Symbols.Symbol sym) {
            return this.ProductClass().contains(this.unspecializedSymbol(sym));
        }

        private Symbols.ClassSymbol TryClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x400L) == 0L) {
                    this.TryClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Try.class));
                    this.bitmap$2 |= 0x400L;
                }
            }
            return this.TryClass;
        }

        public Symbols.ClassSymbol TryClass() {
            if ((this.bitmap$2 & 0x400L) == 0L) {
                return this.TryClass$lzycompute();
            }
            return this.TryClass;
        }

        private Symbols.ClassSymbol FailureClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x800L) == 0L) {
                    this.FailureClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Failure.class));
                    this.bitmap$2 |= 0x800L;
                }
            }
            return this.FailureClass;
        }

        public Symbols.ClassSymbol FailureClass() {
            if ((this.bitmap$2 & 0x800L) == 0L) {
                return this.FailureClass$lzycompute();
            }
            return this.FailureClass;
        }

        private Symbols.ClassSymbol SuccessClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x1000L) == 0L) {
                    this.SuccessClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Success.class));
                    this.bitmap$2 |= 0x1000L;
                }
            }
            return this.SuccessClass;
        }

        public Symbols.ClassSymbol SuccessClass() {
            if ((this.bitmap$2 & 0x1000L) == 0L) {
                return this.SuccessClass$lzycompute();
            }
            return this.SuccessClass;
        }

        private Symbols.ClassSymbol FutureClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x2000L) == 0L) {
                    this.FutureClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Future.class));
                    this.bitmap$2 |= 0x2000L;
                }
            }
            return this.FutureClass;
        }

        public Symbols.ClassSymbol FutureClass() {
            if ((this.bitmap$2 & 0x2000L) == 0L) {
                return this.FutureClass$lzycompute();
            }
            return this.FutureClass;
        }

        private Symbols.ClassSymbol PromiseClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x4000L) == 0L) {
                    this.PromiseClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Promise.class));
                    this.bitmap$2 |= 0x4000L;
                }
            }
            return this.PromiseClass;
        }

        public Symbols.ClassSymbol PromiseClass() {
            if ((this.bitmap$2 & 0x4000L) == 0L) {
                return this.PromiseClass$lzycompute();
            }
            return this.PromiseClass;
        }

        private Symbols.ClassSymbol NonFatalClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x8000L) == 0L) {
                    this.NonFatalClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(NonFatal$.class));
                    this.bitmap$2 |= 0x8000L;
                }
            }
            return this.NonFatalClass;
        }

        public Symbols.ClassSymbol NonFatalClass() {
            if ((this.bitmap$2 & 0x8000L) == 0L) {
                return this.NonFatalClass$lzycompute();
            }
            return this.NonFatalClass;
        }

        public Symbols.Symbol unspecializedSymbol(Symbols.Symbol sym) {
            if (sym.hasFlag(0x10000000000L)) {
                Names.Name genericName = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().unspecializedName(sym.name());
                return sym.owner().info().decl(genericName.toTypeName());
            }
            return sym;
        }

        public List<Types.Type> unspecializedTypeArgs(Types.Type tp) {
            return tp.baseType(this.unspecializedSymbol(tp.typeSymbolDirect())).typeArgs();
        }

        public boolean isMacroContextType(Types.Type tp) {
            return this.MacroContextType().unapply(tp).isDefined();
        }

        public boolean isWhiteboxContextType(Types.Type tp) {
            return this.isMacroContextType(tp) && tp.$less$colon$less(this.WhiteboxContextClass().tpe());
        }

        private Types.Type macroBundleParamInfo(Types.Type tp) {
            Symbols.Symbol c;
            Symbols.Symbol sym;
            List list;
            Some<List> some;
            List<List<Symbols.Symbol>> list2 = tp.erasure().typeSymbol().primaryConstructor().paramss();
            Some<List<List<Symbols.Symbol>>> some2 = List$.MODULE$.unapplySeq(list2);
            Types.Type type = !some2.isEmpty() && some2.get() != null && ((LinearSeqOptimized)some2.get()).lengthCompare(1) == 0 && !(some = List$.MODULE$.unapplySeq(list = (List)((LinearSeqOptimized)some2.get()).apply(0))).isEmpty() && some.get() != null && ((LinearSeqOptimized)some.get()).lengthCompare(1) == 0 ? ((sym = (c = (Symbols.Symbol)((LinearSeqOptimized)some.get()).apply(0)).info().typeSymbol()).isNonBottomSubClass(this.BlackboxContextClass()) || sym.isNonBottomSubClass(this.WhiteboxContextClass()) ? c.info() : this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoType()) : this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoType();
            return type;
        }

        public boolean looksLikeMacroBundleType(Types.Type tp) {
            Types.Type type = this.macroBundleParamInfo(tp);
            Types$NoType$ types$NoType$ = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoType();
            return type == null ? types$NoType$ != null : !type.equals(types$NoType$);
        }

        public boolean isMacroBundleType(Types.Type tp) {
            boolean nonAbstract;
            boolean isMonomorphic = tp.typeSymbol().typeParams().isEmpty();
            boolean isContextCompatible = this.isMacroContextType(this.macroBundleParamInfo(tp));
            boolean hasSingleConstructor = !tp.declaration(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().CONSTRUCTOR()).isOverloaded();
            boolean bl = nonAbstract = !tp.erasure().typeSymbol().isAbstractClass();
            return isMonomorphic && isContextCompatible && hasSingleConstructor && nonAbstract;
        }

        public boolean isBlackboxMacroBundleType(Types.Type tp) {
            boolean isBundle = this.isMacroBundleType(tp);
            Option<Types.Type> option = this.MacroContextType().unapply(this.macroBundleParamInfo(tp));
            if (option == null) {
                throw null;
            }
            Option<Types.Type> getOrElse_this = option;
            Types.Type type = getOrElse_this.isEmpty() ? DefinitionsClass.$anonfun$isBlackboxMacroBundleType$1(this) : getOrElse_this.get();
            boolean isBlackbox = ((Types.Type)type).$eq$colon$eq(this.BlackboxContextClass().tpe());
            return isBundle && isBlackbox;
        }

        public boolean isListType(Types.Type tp) {
            return tp.typeSymbol().isNonBottomSubClass(this.ListClass());
        }

        public boolean isIterableType(Types.Type tp) {
            return tp.typeSymbol().isNonBottomSubClass(this.IterableClass());
        }

        public boolean isFunctionTypeDirect(Types.Type tp) {
            return !tp.isHigherKinded() && this.isFunctionSymbol(tp.typeSymbolDirect());
        }

        public boolean isTupleTypeDirect(Types.Type tp) {
            return !tp.isHigherKinded() && this.isTupleSymbol(tp.typeSymbolDirect());
        }

        public boolean isFunctionType(Types.Type tp) {
            return this.isFunctionTypeDirect(tp.dealiasWiden());
        }

        public int functionArityFromType(Types.Type tp) {
            Types.Type dealiased = tp.dealiasWiden();
            if (this.isFunctionTypeDirect(dealiased)) {
                return dealiased.typeArgs().length() - 1;
            }
            Symbols.Symbol symbol = this.samOf(tp);
            int n = symbol.exists() ? symbol.info().params().length() : -1;
            return n;
        }

        public List<Types.Type> functionOrSamArgTypes(Types.Type tp) {
            Types.Type dealiased = tp.dealiasWiden();
            if (this.isFunctionTypeDirect(dealiased)) {
                return (List)dealiased.typeArgs().init();
            }
            Symbols.Symbol symbol = this.samOf(tp);
            List list = symbol.exists() ? tp.memberInfo(symbol).paramTypes() : Nil$.MODULE$;
            return list;
        }

        public boolean samMatchesFunctionBasedOnArity(Symbols.Symbol sam, List<Object> formals) {
            return sam.exists() && this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().sameLength(sam.info().params(), formals);
        }

        public boolean isTupleType(Types.Type tp) {
            return this.isTupleTypeDirect(tp.dealiasWiden());
        }

        public List<Types.Type> tupleComponents(Types.Type tp) {
            return tp.dealiasWiden().typeArgs();
        }

        private Symbols.ClassSymbol ProductRootClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x10000L) == 0L) {
                    this.ProductRootClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Product.class));
                    this.bitmap$2 |= 0x10000L;
                }
            }
            return this.ProductRootClass;
        }

        public Symbols.ClassSymbol ProductRootClass() {
            if ((this.bitmap$2 & 0x10000L) == 0L) {
                return this.ProductRootClass$lzycompute();
            }
            return this.ProductRootClass;
        }

        public Symbols.TermSymbol Product_productArity() {
            return this.getMemberMethod(this.ProductRootClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().productArity());
        }

        public Symbols.TermSymbol Product_productElement() {
            return this.getMemberMethod(this.ProductRootClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().productElement());
        }

        public Symbols.TermSymbol Product_iterator() {
            return this.getMemberMethod(this.ProductRootClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().productIterator());
        }

        public Symbols.TermSymbol Product_productPrefix() {
            return this.getMemberMethod(this.ProductRootClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().productPrefix());
        }

        public Symbols.TermSymbol Product_canEqual() {
            return this.getMemberMethod(this.ProductRootClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().canEqual_());
        }

        public Symbols.TermSymbol productProj(Symbols.Symbol z, int j) {
            return this.getMemberValue(z, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().productAccessorName(j));
        }

        public List<Types.Type> getProductArgs(Types.Type tpe) {
            List list;
            Option option;
            block5: {
                List<Symbols.Symbol> list2 = tpe.baseClasses();
                if (list2 == null) {
                    throw null;
                }
                LinearSeqOptimized find_these = list2;
                while (!find_these.isEmpty()) {
                    Symbols.Symbol symbol = (Symbols.Symbol)find_these.head();
                    if (this.isProductNSymbol(symbol)) {
                        option = new Some(find_these.head());
                        break block5;
                    }
                    find_these = (LinearSeqOptimized)find_these.tail();
                }
                option = None$.MODULE$;
            }
            if (option instanceof Some) {
                Symbols.Symbol x = (Symbols.Symbol)((Some)option).value();
                list = tpe.baseType(x).typeArgs();
            } else {
                list = Nil$.MODULE$;
            }
            return list;
        }

        public Types.Type unapplyUnwrap(Types.Type tpe) {
            List<Types.Type> list;
            Types.Type type = tpe.finalResultType().dealiasWiden();
            Types.Type type2 = type instanceof Types.RefinedType && (list = ((Types.RefinedType)type).parents()) instanceof $colon$colon ? ((Types.Type)(($colon$colon)list).head()).dealiasWiden() : type;
            return type2;
        }

        public Types.Type dropNullaryMethod(Types.Type tp) {
            Types.Type type = tp instanceof Types.NullaryMethodType ? ((Types.NullaryMethodType)tp).resultType() : tp;
            return type;
        }

        public Types.Type finalResultType(Types.Type tp) {
            Types.Type type;
            if (tp instanceof Types.PolyType) {
                Types.Type restpe = ((Types.PolyType)tp).resultType();
                type = this.finalResultType(restpe);
            } else if (tp instanceof Types.MethodType) {
                Types.Type restpe = ((Types.MethodType)tp).resultType();
                type = this.finalResultType(restpe);
            } else if (tp instanceof Types.NullaryMethodType) {
                Types.Type restpe = ((Types.NullaryMethodType)tp).resultType();
                type = this.finalResultType(restpe);
            } else {
                type = tp;
            }
            return type;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean isStable(Types.Type tp) {
            boolean bl = false;
            Types.TypeRef typeRef = null;
            if (tp instanceof Types.SingletonType) {
                return true;
            }
            if (this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoPrefix().equals(tp)) {
                return true;
            }
            if (tp instanceof Types.TypeRef) {
                bl = true;
                typeRef = (Types.TypeRef)tp;
                Symbols.Symbol symbol = typeRef.sym();
                if (this.NothingClass().equals(symbol)) {
                    return true;
                }
                Symbols.ClassSymbol classSymbol = this.SingletonClass();
                if (classSymbol == null) {
                    if (symbol == null) return true;
                } else if (classSymbol.equals(symbol)) {
                    return true;
                }
                boolean bl2 = false;
                if (bl2) {
                    return true;
                }
            }
            if (bl && typeRef.sym().isAbstractType()) {
                return tp.upperBound().typeSymbol().isSubClass(this.SingletonClass());
            }
            if (bl) {
                Types.Type pre = typeRef.pre();
                if (typeRef.sym().isModuleClass()) {
                    return this.isStable(pre);
                }
            }
            if (bl) {
                Types.Type normalize = tp.normalize();
                if (normalize == tp) return false;
                if (!this.isStable(normalize)) return false;
                return true;
            }
            if (tp instanceof Types.TypeVar) {
                Types.Type origin = ((Types.TypeVar)tp).origin();
                return this.isStable(origin);
            }
            if (tp instanceof Types.AnnotatedType) {
                Types.Type atp = ((Types.AnnotatedType)tp).underlying();
                return this.isStable(atp);
            }
            if (!(tp instanceof Types.SimpleTypeProxy)) return false;
            return this.isStable(tp.underlying());
        }

        public boolean isVolatile(Types.Type tp) {
            boolean bl;
            if (tp instanceof Types.ThisType) {
                bl = false;
            } else if (tp instanceof Types.SingleType) {
                Symbols.Symbol sym = ((Types.SingleType)tp).sym();
                bl = this.isVolatile(tp.underlying()) && (sym.hasVolatileType() || !sym.isStable());
            } else if (tp instanceof Types.NullaryMethodType) {
                Types.Type restpe = ((Types.NullaryMethodType)tp).resultType();
                bl = this.isVolatile(restpe);
            } else if (tp instanceof Types.PolyType) {
                Types.Type restpe = ((Types.PolyType)tp).resultType();
                bl = this.isVolatile(restpe);
            } else if (tp instanceof Types.TypeRef) {
                Types.TypeRef typeRef = (Types.TypeRef)tp;
                bl = this.isVolatileTypeRef$1(typeRef, tp);
            } else if (tp instanceof Types.RefinedType) {
                bl = this.isVolatileRefinedType$1(tp);
            } else if (tp instanceof Types.TypeVar) {
                Types.Type origin = ((Types.TypeVar)tp).origin();
                bl = this.isVolatile(origin);
            } else {
                bl = tp instanceof Types.SimpleTypeProxy ? this.isVolatile(tp.underlying()) : false;
            }
            return bl;
        }

        public Types.Type functionNBaseType(Types.Type tp) {
            Types.Type type;
            Option option;
            block5: {
                List<Symbols.Symbol> list = tp.baseClasses();
                if (list == null) {
                    throw null;
                }
                LinearSeqOptimized find_these = list;
                while (!find_these.isEmpty()) {
                    Symbols.Symbol symbol = (Symbols.Symbol)find_these.head();
                    if (this.isFunctionSymbol(symbol)) {
                        option = new Some(find_these.head());
                        break block5;
                    }
                    find_these = (LinearSeqOptimized)find_these.tail();
                }
                option = None$.MODULE$;
            }
            if (option instanceof Some) {
                Symbols.Symbol sym = (Symbols.Symbol)((Some)option).value();
                type = tp.baseType(this.unspecializedSymbol(sym));
            } else {
                type = tp;
            }
            return type;
        }

        public boolean isPartialFunctionType(Types.Type tp) {
            Symbols.Symbol sym = tp.typeSymbol();
            return sym == this.PartialFunctionClass() || sym == this.AbstractPartialFunctionClass();
        }

        public Symbols.Symbol samOf(Types.Type tp) {
            Symbols.Symbol ctor;
            if (!this.doSam) {
                return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol();
            }
            if (!this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().isNonRefinementClassType(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().unwrapToClass().apply(tp))) {
                return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol();
            }
            Symbols.Symbol tpSym = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().erasure().javaErasure().apply(tp).typeSymbol();
            if (tpSym.exists() && tpSym.isClass() && !tpSym.hasFlag(1056) && (!(ctor = tpSym.primaryConstructor()).exists() || !ctor.isOverloaded() && ctor.isPublic() && ctor.info().params().isEmpty() && ctor.info().paramSectionCount() <= 1) && !tpSym.hasSelfType()) {
                List deferredMembers = (List)tp.membersBasedOnFlags(0x40004000004L, 64L).toList().filter((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)mem -> BoxesRunTime.boxToBoolean(DefinitionsClass.$anonfun$samOf$1(this, mem)));
                if (deferredMembers.lengthCompare(1) == 0 && ((Symbols.Symbol)deferredMembers.head()).typeParams().isEmpty() && ((Symbols.Symbol)deferredMembers.head()).info().paramSectionCount() == 1) {
                    return (Symbols.Symbol)deferredMembers.head();
                }
                return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol();
            }
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol();
        }

        public Types.Type arrayType(Types.Type arg) {
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().appliedType((Symbols.Symbol)this.ArrayClass(), Nil$.MODULE$.$colon$colon(arg));
        }

        public Types.Type byNameType(Types.Type arg) {
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().appliedType((Symbols.Symbol)this.ByNameParamClass(), Nil$.MODULE$.$colon$colon(arg));
        }

        public Types.Type iteratorOfType(Types.Type tp) {
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().appliedType((Symbols.Symbol)this.IteratorClass(), Nil$.MODULE$.$colon$colon(tp));
        }

        public Types.Type javaRepeatedType(Types.Type arg) {
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().appliedType((Symbols.Symbol)this.JavaRepeatedParamClass(), Nil$.MODULE$.$colon$colon(arg));
        }

        public Types.Type optionType(Types.Type tp) {
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().appliedType((Symbols.Symbol)this.OptionClass(), Nil$.MODULE$.$colon$colon(tp));
        }

        public Types.Type scalaRepeatedType(Types.Type arg) {
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().appliedType((Symbols.Symbol)this.RepeatedParamClass(), Nil$.MODULE$.$colon$colon(arg));
        }

        public Types.Type seqType(Types.Type arg) {
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().appliedType((Symbols.Symbol)this.SeqClass(), Nil$.MODULE$.$colon$colon(arg));
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public Types.Type elementTypeFromGet(Types.Type tp) {
            Symbols.ClassSymbol typeArgOfBaseTypeOr_baseClass = this.OptionClass();
            List<Types.Type> list = tp.baseType(typeArgOfBaseTypeOr_baseClass).typeArgs();
            if (!(list instanceof $colon$colon)) return this.resultOfMatchingMethod(tp, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().get(), Nil$.MODULE$);
            $colon$colon $colon$colon = ($colon$colon)list;
            Types.Type typeArgOfBaseTypeOr_x = (Types.Type)$colon$colon.head();
            List list2 = $colon$colon.tl$access$1();
            if (!((Object)Nil$.MODULE$).equals(list2)) return this.resultOfMatchingMethod(tp, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().get(), Nil$.MODULE$);
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().repackExistential(typeArgOfBaseTypeOr_x);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public Types.Type elementTypeFromHead(Types.Type tp) {
            Symbols.ClassSymbol typeArgOfBaseTypeOr_baseClass = this.SeqClass();
            List<Types.Type> list = tp.baseType(typeArgOfBaseTypeOr_baseClass).typeArgs();
            if (!(list instanceof $colon$colon)) return this.resultOfMatchingMethod(tp, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().head(), Nil$.MODULE$);
            $colon$colon $colon$colon = ($colon$colon)list;
            Types.Type typeArgOfBaseTypeOr_x = (Types.Type)$colon$colon.head();
            List list2 = $colon$colon.tl$access$1();
            if (!((Object)Nil$.MODULE$).equals(list2)) return this.resultOfMatchingMethod(tp, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().head(), Nil$.MODULE$);
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().repackExistential(typeArgOfBaseTypeOr_x);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public Types.Type elementTypeFromApply(Types.Type tp) {
            Symbols.ClassSymbol typeArgOfBaseTypeOr_baseClass = this.SeqClass();
            List<Types.Type> list = tp.baseType(typeArgOfBaseTypeOr_baseClass).typeArgs();
            if (!(list instanceof $colon$colon)) return this.resultOfMatchingMethod(tp, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().apply(), Predef$.MODULE$.wrapRefArray((Object[])new Types.Type[]{this.IntTpe()}));
            $colon$colon $colon$colon = ($colon$colon)list;
            Types.Type typeArgOfBaseTypeOr_x = (Types.Type)$colon$colon.head();
            List list2 = $colon$colon.tl$access$1();
            if (!((Object)Nil$.MODULE$).equals(list2)) return this.resultOfMatchingMethod(tp, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().apply(), Predef$.MODULE$.wrapRefArray((Object[])new Types.Type[]{this.IntTpe()}));
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().repackExistential(typeArgOfBaseTypeOr_x);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public Types.Type elementTypeFromDrop(Types.Type tp) {
            Symbols.ClassSymbol typeArgOfBaseTypeOr_baseClass = this.SeqClass();
            List<Types.Type> list = tp.baseType(typeArgOfBaseTypeOr_baseClass).typeArgs();
            if (!(list instanceof $colon$colon)) return this.resultOfMatchingMethod(tp, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().drop(), Predef$.MODULE$.wrapRefArray((Object[])new Types.Type[]{this.IntTpe()}));
            $colon$colon $colon$colon = ($colon$colon)list;
            Types.Type typeArgOfBaseTypeOr_x = (Types.Type)$colon$colon.head();
            List list2 = $colon$colon.tl$access$1();
            if (!((Object)Nil$.MODULE$).equals(list2)) return this.resultOfMatchingMethod(tp, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().drop(), Predef$.MODULE$.wrapRefArray((Object[])new Types.Type[]{this.IntTpe()}));
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().repackExistential(typeArgOfBaseTypeOr_x);
        }

        public Types.Type resultOfIsEmpty(Types.Type tp) {
            return this.resultOfMatchingMethod(tp, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().isEmpty(), Nil$.MODULE$);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private Types.Type typeArgOfBaseTypeOr(Types.Type tp, Symbols.Symbol baseClass, Function0<Types.Type> or) {
            List<Types.Type> list = tp.baseType(baseClass).typeArgs();
            if (!(list instanceof $colon$colon)) return or.apply();
            $colon$colon $colon$colon = ($colon$colon)list;
            Types.Type x = (Types.Type)$colon$colon.head();
            List list2 = $colon$colon.tl$access$1();
            if (!((Object)Nil$.MODULE$).equals(list2)) return or.apply();
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().repackExistential(x);
        }

        private Types.Type resultOfMatchingMethod(Types.Type tp, Names.TermName name, Seq<Types.Type> paramTypes) {
            Symbols.SymbolApi symbolApi = tp.member(name).filter((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)member -> BoxesRunTime.boxToBoolean(this.matchesParams$1(member, paramTypes)));
            Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol();
            Types.Type type = !(noSymbol != null ? !noSymbol.equals(symbolApi) : symbolApi != null) ? this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoType() : tp.memberType((Symbols.Symbol)symbolApi).finalResultType();
            return type;
        }

        public Types.Type ClassType(Types.Type arg) {
            if (this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().phase().erasedTypes()) {
                return this.ClassClass().tpe();
            }
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().appliedType((Symbols.Symbol)this.ClassClass(), Nil$.MODULE$.$colon$colon(arg));
        }

        public boolean neverHasTypeParameters(Symbols.Symbol sym) {
            boolean bl = sym instanceof Symbols.RefinementClassSymbol ? true : (sym instanceof Symbols.ModuleClassSymbol ? true : sym.isPrimitiveValueClass() || sym.isAnonymousClass() || sym.initialize().isMonomorphicType());
            return bl;
        }

        /*
         * WARNING - void declaration
         */
        public Types.Type EnumType(Symbols.Symbol sym) {
            Symbols.Symbol symbol;
            void enteringPhaseNotLaterThan_target;
            SymbolTable symbolTable = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer();
            Phase phase = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().picklerPhase();
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable enteringPhaseNotLaterThan_this = symbolTable;
            if (enteringPhaseNotLaterThan_this.isAtPhaseAfter((Phase)enteringPhaseNotLaterThan_target)) {
                if (enteringPhaseNotLaterThan_target == enteringPhaseNotLaterThan_this.phase()) {
                    symbol = DefinitionsClass.$anonfun$EnumType$1(sym);
                } else {
                    Phase enteringPhaseNotLaterThan_enteringPhase_saved = enteringPhaseNotLaterThan_this.pushPhase((Phase)enteringPhaseNotLaterThan_target);
                    try {
                        symbol = DefinitionsClass.$anonfun$EnumType$1(sym);
                    }
                    finally {
                        enteringPhaseNotLaterThan_this.popPhase(enteringPhaseNotLaterThan_enteringPhase_saved);
                    }
                }
            } else {
                symbol = DefinitionsClass.$anonfun$EnumType$1(sym);
            }
            return symbol.tpe();
        }

        public Types.Type classExistentialType(Types.Type prefix, Symbols.Symbol clazz) {
            List<Symbols.Symbol> eparams = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().typeParamsToExistentials(clazz, clazz.unsafeTypeParams());
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().newExistentialType(eparams, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().typeRef(prefix, clazz, eparams.map((Function1<Symbols.Symbol, Types.Type> & java.io.Serializable & Serializable)x$27 -> x$27.tpeHK(), List$.MODULE$.canBuildFrom())));
        }

        private Symbols.MethodSymbol Any_$eq$eq$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x20000L) == 0L) {
                    Types.Type type = this.AnyTpe();
                    this.Any_$eq$eq = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewMethod(this.AnyClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().EQ(), Nil$.MODULE$.$colon$colon(type), this.BooleanTpe(), 32L);
                    this.bitmap$2 |= 0x20000L;
                }
            }
            return this.Any_$eq$eq;
        }

        public Symbols.MethodSymbol Any_$eq$eq() {
            if ((this.bitmap$2 & 0x20000L) == 0L) {
                return this.Any_$eq$eq$lzycompute();
            }
            return this.Any_$eq$eq;
        }

        private Symbols.MethodSymbol Any_$bang$eq$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x40000L) == 0L) {
                    Types.Type type = this.AnyTpe();
                    this.Any_$bang$eq = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewMethod(this.AnyClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().NE(), Nil$.MODULE$.$colon$colon(type), this.BooleanTpe(), 32L);
                    this.bitmap$2 |= 0x40000L;
                }
            }
            return this.Any_$bang$eq;
        }

        public Symbols.MethodSymbol Any_$bang$eq() {
            if ((this.bitmap$2 & 0x40000L) == 0L) {
                return this.Any_$bang$eq$lzycompute();
            }
            return this.Any_$bang$eq;
        }

        private Symbols.MethodSymbol Any_equals$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x80000L) == 0L) {
                    Types.Type type = this.AnyTpe();
                    this.Any_equals = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewMethod(this.AnyClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().equals_(), Nil$.MODULE$.$colon$colon(type), this.BooleanTpe(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewMethod$default$5());
                    this.bitmap$2 |= 0x80000L;
                }
            }
            return this.Any_equals;
        }

        public Symbols.MethodSymbol Any_equals() {
            if ((this.bitmap$2 & 0x80000L) == 0L) {
                return this.Any_equals$lzycompute();
            }
            return this.Any_equals;
        }

        private Symbols.MethodSymbol Any_hashCode$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x100000L) == 0L) {
                    this.Any_hashCode = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewMethod(this.AnyClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().hashCode_(), Nil$.MODULE$, this.IntTpe(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewMethod$default$5());
                    this.bitmap$2 |= 0x100000L;
                }
            }
            return this.Any_hashCode;
        }

        public Symbols.MethodSymbol Any_hashCode() {
            if ((this.bitmap$2 & 0x100000L) == 0L) {
                return this.Any_hashCode$lzycompute();
            }
            return this.Any_hashCode;
        }

        private Symbols.MethodSymbol Any_toString$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x200000L) == 0L) {
                    this.Any_toString = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewMethod(this.AnyClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().toString_(), Nil$.MODULE$, this.StringTpe(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewMethod$default$5());
                    this.bitmap$2 |= 0x200000L;
                }
            }
            return this.Any_toString;
        }

        public Symbols.MethodSymbol Any_toString() {
            if ((this.bitmap$2 & 0x200000L) == 0L) {
                return this.Any_toString$lzycompute();
            }
            return this.Any_toString;
        }

        private Symbols.MethodSymbol Any_$hash$hash$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x400000L) == 0L) {
                    this.Any_$hash$hash = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewMethod(this.AnyClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().HASHHASH(), Nil$.MODULE$, this.IntTpe(), 32L);
                    this.bitmap$2 |= 0x400000L;
                }
            }
            return this.Any_$hash$hash;
        }

        public Symbols.MethodSymbol Any_$hash$hash() {
            if ((this.bitmap$2 & 0x400000L) == 0L) {
                return this.Any_$hash$hash$lzycompute();
            }
            return this.Any_$hash$hash;
        }

        private Symbols.MethodSymbol Any_getClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x800000L) == 0L) {
                    this.Any_getClass = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewMethod(this.AnyClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().getClass_(), Nil$.MODULE$, this.getMemberMethod(this.ObjectClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().getClass_()).tpe().resultType(), 16L);
                    this.bitmap$2 |= 0x800000L;
                }
            }
            return this.Any_getClass;
        }

        public Symbols.MethodSymbol Any_getClass() {
            if ((this.bitmap$2 & 0x800000L) == 0L) {
                return this.Any_getClass$lzycompute();
            }
            return this.Any_getClass;
        }

        private Symbols.MethodSymbol Any_isInstanceOf$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x1000000L) == 0L) {
                    this.Any_isInstanceOf = this.enterNewT1NullaryMethod(this.AnyClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().isInstanceOf_(), 32L, (Function1<Symbols.Symbol, Types.Type> & java.io.Serializable & Serializable)x$31 -> this.BooleanTpe());
                    this.bitmap$2 |= 0x1000000L;
                }
            }
            return this.Any_isInstanceOf;
        }

        public Symbols.MethodSymbol Any_isInstanceOf() {
            if ((this.bitmap$2 & 0x1000000L) == 0L) {
                return this.Any_isInstanceOf$lzycompute();
            }
            return this.Any_isInstanceOf;
        }

        private Symbols.MethodSymbol Any_asInstanceOf$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x2000000L) == 0L) {
                    this.Any_asInstanceOf = this.enterNewT1NullaryMethod(this.AnyClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().asInstanceOf_(), 32L, (Function1<Symbols.Symbol, Types.Type> & java.io.Serializable & Serializable)x$32 -> x$32.typeConstructor());
                    this.bitmap$2 |= 0x2000000L;
                }
            }
            return this.Any_asInstanceOf;
        }

        public Symbols.MethodSymbol Any_asInstanceOf() {
            if ((this.bitmap$2 & 0x2000000L) == 0L) {
                return this.Any_asInstanceOf$lzycompute();
            }
            return this.Any_asInstanceOf;
        }

        private Set<Symbols.Symbol> primitiveGetClassMethods$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x4000000L) == 0L) {
                    this.primitiveGetClassMethods = (Set)((SetLike)Predef$.MODULE$.Set().apply(Predef$.MODULE$.wrapRefArray((Object[])new Symbols.Symbol[]{this.Any_getClass(), this.AnyVal_getClass()}))).$plus$plus(this.ScalaValueClasses().map((Function1<Symbols.ClassSymbol, Symbols.Symbol> & java.io.Serializable & Serializable)x$33 -> x$33.tpe().member(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().getClass_()), List$.MODULE$.canBuildFrom()));
                    this.bitmap$2 |= 0x4000000L;
                }
            }
            return this.primitiveGetClassMethods;
        }

        public Set<Symbols.Symbol> primitiveGetClassMethods() {
            if ((this.bitmap$2 & 0x4000000L) == 0L) {
                return this.primitiveGetClassMethods$lzycompute();
            }
            return this.primitiveGetClassMethods;
        }

        private Set<Symbols.Symbol> getClassMethods$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x8000000L) == 0L) {
                    this.getClassMethods = (Set)this.primitiveGetClassMethods().$plus(this.Object_getClass());
                    this.bitmap$2 |= 0x8000000L;
                }
            }
            return this.getClassMethods;
        }

        public Set<Symbols.Symbol> getClassMethods() {
            if ((this.bitmap$2 & 0x8000000L) == 0L) {
                return this.getClassMethods$lzycompute();
            }
            return this.getClassMethods;
        }

        public Types.Type getClassReturnType(Types.Type tp) {
            Symbols.Symbol sym = tp.typeSymbol();
            if (this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().phase().erasedTypes()) {
                return this.ClassClass().tpe();
            }
            if (this.isPrimitiveValueClass(sym)) {
                return this.ClassType(tp.widen());
            }
            List<Symbols.Symbol> eparams = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().typeParamsToExistentials(this.ClassClass(), this.ClassClass().typeParams());
            Types.Type upperBound = this.isPhantomClass().apply(sym) ? this.AnyTpe() : (sym.isLocalClass() ? this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().erasure().intersectionDominator(tp.parents()) : tp.widen());
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().existentialAbstraction(eparams, this.ClassType(eparams.head().setInfo(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().TypeBounds().upper(upperBound)).tpe()));
        }

        public List<Types.Type> removeRedundantObjects(List<Types.Type> tps) {
            List list;
            if (((Object)Nil$.MODULE$).equals(tps)) {
                list = Nil$.MODULE$;
            } else if (tps instanceof $colon$colon) {
                $colon$colon $colon$colon = ($colon$colon)tps;
                Types.Type x = (Types.Type)$colon$colon.head();
                List<Types.Type> xs = $colon$colon.tl$access$1();
                Symbols.Symbol symbol = x.typeSymbol();
                Symbols.ClassSymbol classSymbol = this.ObjectClass();
                list = !(symbol != null ? !symbol.equals(classSymbol) : classSymbol != null) ? ((List)xs.filterNot((Function1<Types.Type, Object> & java.io.Serializable & Serializable)x$34 -> BoxesRunTime.boxToBoolean(DefinitionsClass.$anonfun$removeRedundantObjects$1(this, x$34)))).$colon$colon(x) : this.removeRedundantObjects(xs).$colon$colon(x);
            } else {
                throw new MatchError(tps);
            }
            return list;
        }

        public List<Types.Type> normalizedParents(List<Types.Type> parents) {
            boolean bl;
            block4: {
                if (parents == null) {
                    throw null;
                }
                LinearSeqOptimized exists_these = parents;
                while (!exists_these.isEmpty()) {
                    Types.Type type = (Types.Type)exists_these.head();
                    if (DefinitionsClass.$anonfun$normalizedParents$1(this, type)) {
                        bl = true;
                        break block4;
                    }
                    exists_these = (LinearSeqOptimized)exists_these.tail();
                }
                bl = false;
            }
            if (bl) {
                return (List)parents.filterNot((Function1<Types.Type, Object> & java.io.Serializable & Serializable)x$37 -> BoxesRunTime.boxToBoolean(DefinitionsClass.$anonfun$normalizedParents$2(this, x$37)));
            }
            return this.removeRedundantObjects(parents);
        }

        public List<Symbols.Symbol> allParameters(Types.Type tpe) {
            List list;
            if (tpe instanceof Types.MethodType) {
                Types.MethodType methodType = (Types.MethodType)tpe;
                List<Symbols.Symbol> params = methodType.params();
                Types.Type res = methodType.resultType();
                list = this.allParameters(res).$colon$colon$colon(params);
            } else {
                list = Nil$.MODULE$;
            }
            return list;
        }

        public String typeStringNoPackage(Types.Type tp) {
            String string = String.valueOf(tp);
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return new StringOps(string).stripPrefix(new StringBuilder(1).append(tp.typeSymbol().enclosingPackage().fullName()).append(".").toString());
        }

        public String briefParentsString(List<Types.Type> parents) {
            return ((TraversableOnce)this.normalizedParents(parents).map((Function1<Types.Type, String> & java.io.Serializable & Serializable)tp -> this.typeStringNoPackage((Types.Type)tp), List$.MODULE$.canBuildFrom())).mkString(" with ");
        }

        public String parentsString(List<Types.Type> parents) {
            return this.normalizedParents(parents).mkString(" with ");
        }

        public String valueParamsString(Types.Type tp) {
            String string = tp instanceof Types.MethodType ? ((TraversableOnce)((Types.MethodType)tp).params().map((Function1<Symbols.Symbol, String> & java.io.Serializable & Serializable)x$39 -> x$39.defString(), List$.MODULE$.canBuildFrom())).mkString("(", ",", ")") : "";
            return string;
        }

        private Symbols.MethodSymbol Object_$hash$hash$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x10000000L) == 0L) {
                    this.Object_$hash$hash = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewMethod(this.ObjectClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().HASHHASH(), Nil$.MODULE$, this.IntTpe(), 32L);
                    this.bitmap$2 |= 0x10000000L;
                }
            }
            return this.Object_$hash$hash;
        }

        public Symbols.MethodSymbol Object_$hash$hash() {
            if ((this.bitmap$2 & 0x10000000L) == 0L) {
                return this.Object_$hash$hash$lzycompute();
            }
            return this.Object_$hash$hash;
        }

        private Symbols.MethodSymbol Object_$eq$eq$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x20000000L) == 0L) {
                    Types.Type type = this.AnyTpe();
                    this.Object_$eq$eq = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewMethod(this.ObjectClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().EQ(), Nil$.MODULE$.$colon$colon(type), this.BooleanTpe(), 32L);
                    this.bitmap$2 |= 0x20000000L;
                }
            }
            return this.Object_$eq$eq;
        }

        public Symbols.MethodSymbol Object_$eq$eq() {
            if ((this.bitmap$2 & 0x20000000L) == 0L) {
                return this.Object_$eq$eq$lzycompute();
            }
            return this.Object_$eq$eq;
        }

        private Symbols.MethodSymbol Object_$bang$eq$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x40000000L) == 0L) {
                    Types.Type type = this.AnyTpe();
                    this.Object_$bang$eq = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewMethod(this.ObjectClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().NE(), Nil$.MODULE$.$colon$colon(type), this.BooleanTpe(), 32L);
                    this.bitmap$2 |= 0x40000000L;
                }
            }
            return this.Object_$bang$eq;
        }

        public Symbols.MethodSymbol Object_$bang$eq() {
            if ((this.bitmap$2 & 0x40000000L) == 0L) {
                return this.Object_$bang$eq$lzycompute();
            }
            return this.Object_$bang$eq;
        }

        private Symbols.MethodSymbol Object_eq$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x80000000L) == 0L) {
                    Types.Type type = this.AnyRefTpe();
                    this.Object_eq = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewMethod(this.ObjectClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().eq(), Nil$.MODULE$.$colon$colon(type), this.BooleanTpe(), 32L);
                    this.bitmap$2 |= 0x80000000L;
                }
            }
            return this.Object_eq;
        }

        public Symbols.MethodSymbol Object_eq() {
            if ((this.bitmap$2 & 0x80000000L) == 0L) {
                return this.Object_eq$lzycompute();
            }
            return this.Object_eq;
        }

        private Symbols.MethodSymbol Object_ne$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x100000000L) == 0L) {
                    Types.Type type = this.AnyRefTpe();
                    this.Object_ne = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewMethod(this.ObjectClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().ne(), Nil$.MODULE$.$colon$colon(type), this.BooleanTpe(), 32L);
                    this.bitmap$2 |= 0x100000000L;
                }
            }
            return this.Object_ne;
        }

        public Symbols.MethodSymbol Object_ne() {
            if ((this.bitmap$2 & 0x100000000L) == 0L) {
                return this.Object_ne$lzycompute();
            }
            return this.Object_ne;
        }

        private Symbols.MethodSymbol Object_isInstanceOf$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x200000000L) == 0L) {
                    this.Object_isInstanceOf = this.newT1NilaryMethod(this.ObjectClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().isInstanceOf_Ob(), 0x400000200020L, (Function1<Symbols.Symbol, Types.Type> & java.io.Serializable & Serializable)x$44 -> this.BooleanTpe());
                    this.bitmap$2 |= 0x200000000L;
                }
            }
            return this.Object_isInstanceOf;
        }

        public Symbols.MethodSymbol Object_isInstanceOf() {
            if ((this.bitmap$2 & 0x200000000L) == 0L) {
                return this.Object_isInstanceOf$lzycompute();
            }
            return this.Object_isInstanceOf;
        }

        private Symbols.MethodSymbol Object_asInstanceOf$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x400000000L) == 0L) {
                    this.Object_asInstanceOf = this.newT1NilaryMethod(this.ObjectClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().asInstanceOf_Ob(), 0x400000200020L, (Function1<Symbols.Symbol, Types.Type> & java.io.Serializable & Serializable)x$45 -> x$45.typeConstructor());
                    this.bitmap$2 |= 0x400000000L;
                }
            }
            return this.Object_asInstanceOf;
        }

        public Symbols.MethodSymbol Object_asInstanceOf() {
            if ((this.bitmap$2 & 0x400000000L) == 0L) {
                return this.Object_asInstanceOf$lzycompute();
            }
            return this.Object_asInstanceOf;
        }

        private Symbols.MethodSymbol Object_synchronized$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x800000000L) == 0L) {
                    this.Object_synchronized = this.enterNewT1Method(this.ObjectClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().synchronized_(), 32L, (Function1<Symbols.Symbol, Types.Type> & java.io.Serializable & Serializable)x$46 -> x$46.typeConstructor());
                    this.bitmap$2 |= 0x800000000L;
                }
            }
            return this.Object_synchronized;
        }

        public Symbols.MethodSymbol Object_synchronized() {
            if ((this.bitmap$2 & 0x800000000L) == 0L) {
                return this.Object_synchronized$lzycompute();
            }
            return this.Object_synchronized;
        }

        private Symbols.MethodSymbol String_$plus$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x1000000000L) == 0L) {
                    Types.Type type = this.AnyTpe();
                    this.String_$plus = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewMethod(this.StringClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().raw().PLUS(), Nil$.MODULE$.$colon$colon(type), this.StringTpe(), 32L);
                    this.bitmap$2 |= 0x1000000000L;
                }
            }
            return this.String_$plus;
        }

        public Symbols.MethodSymbol String_$plus() {
            if ((this.bitmap$2 & 0x1000000000L) == 0L) {
                return this.String_$plus$lzycompute();
            }
            return this.String_$plus;
        }

        public Symbols.TermSymbol Object_getClass() {
            return this.getMemberMethod(this.ObjectClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().getClass_());
        }

        public Symbols.TermSymbol Object_clone() {
            return this.getMemberMethod(this.ObjectClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().clone_());
        }

        public Symbols.TermSymbol Object_finalize() {
            return this.getMemberMethod(this.ObjectClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().finalize_());
        }

        public Symbols.TermSymbol Object_notify() {
            return this.getMemberMethod(this.ObjectClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().notify_());
        }

        public Symbols.TermSymbol Object_notifyAll() {
            return this.getMemberMethod(this.ObjectClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().notifyAll_());
        }

        public Symbols.TermSymbol Object_equals() {
            return this.getMemberMethod(this.ObjectClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().equals_());
        }

        public Symbols.TermSymbol Object_hashCode() {
            return this.getMemberMethod(this.ObjectClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().hashCode_());
        }

        public Symbols.TermSymbol Object_toString() {
            return this.getMemberMethod(this.ObjectClass(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().toString_());
        }

        private Symbols.ClassSymbol ObjectRefClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x2000000000L) == 0L) {
                    this.ObjectRefClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(ObjectRef.class));
                    this.bitmap$2 |= 0x2000000000L;
                }
            }
            return this.ObjectRefClass;
        }

        public Symbols.ClassSymbol ObjectRefClass() {
            if ((this.bitmap$2 & 0x2000000000L) == 0L) {
                return this.ObjectRefClass$lzycompute();
            }
            return this.ObjectRefClass;
        }

        private Symbols.ClassSymbol VolatileObjectRefClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x4000000000L) == 0L) {
                    this.VolatileObjectRefClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(VolatileObjectRef.class));
                    this.bitmap$2 |= 0x4000000000L;
                }
            }
            return this.VolatileObjectRefClass;
        }

        public Symbols.ClassSymbol VolatileObjectRefClass() {
            if ((this.bitmap$2 & 0x4000000000L) == 0L) {
                return this.VolatileObjectRefClass$lzycompute();
            }
            return this.VolatileObjectRefClass;
        }

        private Symbols.ModuleSymbol RuntimeStaticsModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x8000000000L) == 0L) {
                    this.RuntimeStaticsModule = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getRequiredModule("scala.runtime.Statics");
                    this.bitmap$2 |= 0x8000000000L;
                }
            }
            return this.RuntimeStaticsModule;
        }

        public Symbols.ModuleSymbol RuntimeStaticsModule() {
            if ((this.bitmap$2 & 0x8000000000L) == 0L) {
                return this.RuntimeStaticsModule$lzycompute();
            }
            return this.RuntimeStaticsModule;
        }

        private Symbols.ModuleSymbol BoxesRunTimeModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x10000000000L) == 0L) {
                    this.BoxesRunTimeModule = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getRequiredModule("scala.runtime.BoxesRunTime");
                    this.bitmap$2 |= 0x10000000000L;
                }
            }
            return this.BoxesRunTimeModule;
        }

        public Symbols.ModuleSymbol BoxesRunTimeModule() {
            if ((this.bitmap$2 & 0x10000000000L) == 0L) {
                return this.BoxesRunTimeModule$lzycompute();
            }
            return this.BoxesRunTimeModule;
        }

        private Symbols.Symbol BoxesRunTimeClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x20000000000L) == 0L) {
                    this.BoxesRunTimeClass = this.BoxesRunTimeModule().moduleClass();
                    this.bitmap$2 |= 0x20000000000L;
                }
            }
            return this.BoxesRunTimeClass;
        }

        public Symbols.Symbol BoxesRunTimeClass() {
            if ((this.bitmap$2 & 0x20000000000L) == 0L) {
                return this.BoxesRunTimeClass$lzycompute();
            }
            return this.BoxesRunTimeClass;
        }

        private Symbols.ClassSymbol BoxedNumberClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x40000000000L) == 0L) {
                    this.BoxedNumberClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassByName(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().sn().BoxedNumber());
                    this.bitmap$2 |= 0x40000000000L;
                }
            }
            return this.BoxedNumberClass;
        }

        public Symbols.ClassSymbol BoxedNumberClass() {
            if ((this.bitmap$2 & 0x40000000000L) == 0L) {
                return this.BoxedNumberClass$lzycompute();
            }
            return this.BoxedNumberClass;
        }

        private Symbols.ClassSymbol BoxedCharacterClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x80000000000L) == 0L) {
                    this.BoxedCharacterClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassByName(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().sn().BoxedCharacter());
                    this.bitmap$2 |= 0x80000000000L;
                }
            }
            return this.BoxedCharacterClass;
        }

        public Symbols.ClassSymbol BoxedCharacterClass() {
            if ((this.bitmap$2 & 0x80000000000L) == 0L) {
                return this.BoxedCharacterClass$lzycompute();
            }
            return this.BoxedCharacterClass;
        }

        private Symbols.ClassSymbol BoxedBooleanClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x100000000000L) == 0L) {
                    this.BoxedBooleanClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassByName(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().sn().BoxedBoolean());
                    this.bitmap$2 |= 0x100000000000L;
                }
            }
            return this.BoxedBooleanClass;
        }

        public Symbols.ClassSymbol BoxedBooleanClass() {
            if ((this.bitmap$2 & 0x100000000000L) == 0L) {
                return this.BoxedBooleanClass$lzycompute();
            }
            return this.BoxedBooleanClass;
        }

        private Symbols.ClassSymbol BoxedByteClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x200000000000L) == 0L) {
                    this.BoxedByteClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Byte.class));
                    this.bitmap$2 |= 0x200000000000L;
                }
            }
            return this.BoxedByteClass;
        }

        public Symbols.ClassSymbol BoxedByteClass() {
            if ((this.bitmap$2 & 0x200000000000L) == 0L) {
                return this.BoxedByteClass$lzycompute();
            }
            return this.BoxedByteClass;
        }

        private Symbols.ClassSymbol BoxedShortClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x400000000000L) == 0L) {
                    this.BoxedShortClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Short.class));
                    this.bitmap$2 |= 0x400000000000L;
                }
            }
            return this.BoxedShortClass;
        }

        public Symbols.ClassSymbol BoxedShortClass() {
            if ((this.bitmap$2 & 0x400000000000L) == 0L) {
                return this.BoxedShortClass$lzycompute();
            }
            return this.BoxedShortClass;
        }

        private Symbols.ClassSymbol BoxedIntClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x800000000000L) == 0L) {
                    this.BoxedIntClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Integer.class));
                    this.bitmap$2 |= 0x800000000000L;
                }
            }
            return this.BoxedIntClass;
        }

        public Symbols.ClassSymbol BoxedIntClass() {
            if ((this.bitmap$2 & 0x800000000000L) == 0L) {
                return this.BoxedIntClass$lzycompute();
            }
            return this.BoxedIntClass;
        }

        private Symbols.ClassSymbol BoxedLongClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x1000000000000L) == 0L) {
                    this.BoxedLongClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Long.class));
                    this.bitmap$2 |= 0x1000000000000L;
                }
            }
            return this.BoxedLongClass;
        }

        public Symbols.ClassSymbol BoxedLongClass() {
            if ((this.bitmap$2 & 0x1000000000000L) == 0L) {
                return this.BoxedLongClass$lzycompute();
            }
            return this.BoxedLongClass;
        }

        private Symbols.ClassSymbol BoxedFloatClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x2000000000000L) == 0L) {
                    this.BoxedFloatClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Float.class));
                    this.bitmap$2 |= 0x2000000000000L;
                }
            }
            return this.BoxedFloatClass;
        }

        public Symbols.ClassSymbol BoxedFloatClass() {
            if ((this.bitmap$2 & 0x2000000000000L) == 0L) {
                return this.BoxedFloatClass$lzycompute();
            }
            return this.BoxedFloatClass;
        }

        private Symbols.ClassSymbol BoxedDoubleClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x4000000000000L) == 0L) {
                    this.BoxedDoubleClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Double.class));
                    this.bitmap$2 |= 0x4000000000000L;
                }
            }
            return this.BoxedDoubleClass;
        }

        public Symbols.ClassSymbol BoxedDoubleClass() {
            if ((this.bitmap$2 & 0x4000000000000L) == 0L) {
                return this.BoxedDoubleClass$lzycompute();
            }
            return this.BoxedDoubleClass;
        }

        private Symbols.ClassSymbol BoxedUnitClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x8000000000000L) == 0L) {
                    this.BoxedUnitClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(BoxedUnit.class));
                    this.bitmap$2 |= 0x8000000000000L;
                }
            }
            return this.BoxedUnitClass;
        }

        public Symbols.ClassSymbol BoxedUnitClass() {
            if ((this.bitmap$2 & 0x8000000000000L) == 0L) {
                return this.BoxedUnitClass$lzycompute();
            }
            return this.BoxedUnitClass;
        }

        private Symbols.ModuleSymbol BoxedUnitModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x10000000000000L) == 0L) {
                    this.BoxedUnitModule = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getRequiredModule("scala.runtime.BoxedUnit");
                    this.bitmap$2 |= 0x10000000000000L;
                }
            }
            return this.BoxedUnitModule;
        }

        public Symbols.ModuleSymbol BoxedUnitModule() {
            if ((this.bitmap$2 & 0x10000000000000L) == 0L) {
                return this.BoxedUnitModule$lzycompute();
            }
            return this.BoxedUnitModule;
        }

        public Symbols.TermSymbol BoxedUnit_UNIT() {
            return this.getMemberValue(this.BoxedUnitModule(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().UNIT());
        }

        public Symbols.TermSymbol BoxedUnit_TYPE() {
            return this.getMemberValue(this.BoxedUnitModule(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().TYPE_());
        }

        private Symbols.ClassSymbol AnnotationClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x20000000000000L) == 0L) {
                    this.AnnotationClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Annotation.class));
                    this.bitmap$2 |= 0x20000000000000L;
                }
            }
            return this.AnnotationClass;
        }

        public Symbols.ClassSymbol AnnotationClass() {
            if ((this.bitmap$2 & 0x20000000000000L) == 0L) {
                return this.AnnotationClass$lzycompute();
            }
            return this.AnnotationClass;
        }

        private Symbols.ClassSymbol ClassfileAnnotationClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x40000000000000L) == 0L) {
                    this.ClassfileAnnotationClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(ClassfileAnnotation.class));
                    this.bitmap$2 |= 0x40000000000000L;
                }
            }
            return this.ClassfileAnnotationClass;
        }

        public Symbols.ClassSymbol ClassfileAnnotationClass() {
            if ((this.bitmap$2 & 0x40000000000000L) == 0L) {
                return this.ClassfileAnnotationClass$lzycompute();
            }
            return this.ClassfileAnnotationClass;
        }

        private Symbols.ClassSymbol StaticAnnotationClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x80000000000000L) == 0L) {
                    this.StaticAnnotationClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(StaticAnnotation.class));
                    this.bitmap$2 |= 0x80000000000000L;
                }
            }
            return this.StaticAnnotationClass;
        }

        public Symbols.ClassSymbol StaticAnnotationClass() {
            if ((this.bitmap$2 & 0x80000000000000L) == 0L) {
                return this.StaticAnnotationClass$lzycompute();
            }
            return this.StaticAnnotationClass;
        }

        private Symbols.ClassSymbol AnnotationRetentionAttr$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x100000000000000L) == 0L) {
                    this.AnnotationRetentionAttr = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Retention.class));
                    this.bitmap$2 |= 0x100000000000000L;
                }
            }
            return this.AnnotationRetentionAttr;
        }

        public Symbols.ClassSymbol AnnotationRetentionAttr() {
            if ((this.bitmap$2 & 0x100000000000000L) == 0L) {
                return this.AnnotationRetentionAttr$lzycompute();
            }
            return this.AnnotationRetentionAttr;
        }

        private Symbols.ClassSymbol AnnotationRetentionPolicyAttr$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x200000000000000L) == 0L) {
                    this.AnnotationRetentionPolicyAttr = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(RetentionPolicy.class));
                    this.bitmap$2 |= 0x200000000000000L;
                }
            }
            return this.AnnotationRetentionPolicyAttr;
        }

        public Symbols.ClassSymbol AnnotationRetentionPolicyAttr() {
            if ((this.bitmap$2 & 0x200000000000000L) == 0L) {
                return this.AnnotationRetentionPolicyAttr$lzycompute();
            }
            return this.AnnotationRetentionPolicyAttr;
        }

        private Symbols.ClassSymbol AnnotationRepeatableAttr$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x400000000000000L) == 0L) {
                    this.AnnotationRepeatableAttr = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Repeatable.class));
                    this.bitmap$2 |= 0x400000000000000L;
                }
            }
            return this.AnnotationRepeatableAttr;
        }

        public Symbols.ClassSymbol AnnotationRepeatableAttr() {
            if ((this.bitmap$2 & 0x400000000000000L) == 0L) {
                return this.AnnotationRepeatableAttr$lzycompute();
            }
            return this.AnnotationRepeatableAttr;
        }

        private Symbols.ClassSymbol BridgeClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x800000000000000L) == 0L) {
                    this.BridgeClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(bridge.class));
                    this.bitmap$2 |= 0x800000000000000L;
                }
            }
            return this.BridgeClass;
        }

        public Symbols.ClassSymbol BridgeClass() {
            if ((this.bitmap$2 & 0x800000000000000L) == 0L) {
                return this.BridgeClass$lzycompute();
            }
            return this.BridgeClass;
        }

        private Symbols.ClassSymbol ElidableMethodClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x1000000000000000L) == 0L) {
                    this.ElidableMethodClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(elidable.class));
                    this.bitmap$2 |= 0x1000000000000000L;
                }
            }
            return this.ElidableMethodClass;
        }

        public Symbols.ClassSymbol ElidableMethodClass() {
            if ((this.bitmap$2 & 0x1000000000000000L) == 0L) {
                return this.ElidableMethodClass$lzycompute();
            }
            return this.ElidableMethodClass;
        }

        private Symbols.ClassSymbol ImplicitNotFoundClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x2000000000000000L) == 0L) {
                    this.ImplicitNotFoundClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(implicitNotFound.class));
                    this.bitmap$2 |= 0x2000000000000000L;
                }
            }
            return this.ImplicitNotFoundClass;
        }

        public Symbols.ClassSymbol ImplicitNotFoundClass() {
            if ((this.bitmap$2 & 0x2000000000000000L) == 0L) {
                return this.ImplicitNotFoundClass$lzycompute();
            }
            return this.ImplicitNotFoundClass;
        }

        private Symbols.Symbol ImplicitAmbiguousClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & 0x4000000000000000L) == 0L) {
                    this.ImplicitAmbiguousClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("scala.annotation.implicitAmbiguous");
                    this.bitmap$2 |= 0x4000000000000000L;
                }
            }
            return this.ImplicitAmbiguousClass;
        }

        public Symbols.Symbol ImplicitAmbiguousClass() {
            if ((this.bitmap$2 & 0x4000000000000000L) == 0L) {
                return this.ImplicitAmbiguousClass$lzycompute();
            }
            return this.ImplicitAmbiguousClass;
        }

        private Symbols.ClassSymbol MigrationAnnotationClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$2 & Long.MIN_VALUE) == 0L) {
                    this.MigrationAnnotationClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(migration.class));
                    this.bitmap$2 |= Long.MIN_VALUE;
                }
            }
            return this.MigrationAnnotationClass;
        }

        public Symbols.ClassSymbol MigrationAnnotationClass() {
            if ((this.bitmap$2 & Long.MIN_VALUE) == 0L) {
                return this.MigrationAnnotationClass$lzycompute();
            }
            return this.MigrationAnnotationClass;
        }

        private Symbols.ClassSymbol ScalaStrictFPAttr$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 1L) == 0L) {
                    this.ScalaStrictFPAttr = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(strictfp.class));
                    this.bitmap$3 |= 1L;
                }
            }
            return this.ScalaStrictFPAttr;
        }

        public Symbols.ClassSymbol ScalaStrictFPAttr() {
            if ((this.bitmap$3 & 1L) == 0L) {
                return this.ScalaStrictFPAttr$lzycompute();
            }
            return this.ScalaStrictFPAttr;
        }

        private Symbols.ClassSymbol SwitchClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 2L) == 0L) {
                    this.SwitchClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(switch.class));
                    this.bitmap$3 |= 2L;
                }
            }
            return this.SwitchClass;
        }

        public Symbols.ClassSymbol SwitchClass() {
            if ((this.bitmap$3 & 2L) == 0L) {
                return this.SwitchClass$lzycompute();
            }
            return this.SwitchClass;
        }

        private Symbols.ClassSymbol TailrecClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 4L) == 0L) {
                    this.TailrecClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(tailrec.class));
                    this.bitmap$3 |= 4L;
                }
            }
            return this.TailrecClass;
        }

        public Symbols.ClassSymbol TailrecClass() {
            if ((this.bitmap$3 & 4L) == 0L) {
                return this.TailrecClass$lzycompute();
            }
            return this.TailrecClass;
        }

        private Symbols.ClassSymbol VarargsClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 8L) == 0L) {
                    this.VarargsClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(varargs.class));
                    this.bitmap$3 |= 8L;
                }
            }
            return this.VarargsClass;
        }

        public Symbols.ClassSymbol VarargsClass() {
            if ((this.bitmap$3 & 8L) == 0L) {
                return this.VarargsClass$lzycompute();
            }
            return this.VarargsClass;
        }

        private Symbols.Symbol NowarnClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x10L) == 0L) {
                    this.NowarnClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("scala.annotation.nowarn");
                    this.bitmap$3 |= 0x10L;
                }
            }
            return this.NowarnClass;
        }

        public Symbols.Symbol NowarnClass() {
            if ((this.bitmap$3 & 0x10L) == 0L) {
                return this.NowarnClass$lzycompute();
            }
            return this.NowarnClass;
        }

        private Symbols.ClassSymbol uncheckedStableClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x20L) == 0L) {
                    this.uncheckedStableClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(uncheckedStable.class));
                    this.bitmap$3 |= 0x20L;
                }
            }
            return this.uncheckedStableClass;
        }

        public Symbols.ClassSymbol uncheckedStableClass() {
            if ((this.bitmap$3 & 0x20L) == 0L) {
                return this.uncheckedStableClass$lzycompute();
            }
            return this.uncheckedStableClass;
        }

        private Symbols.ClassSymbol uncheckedVarianceClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x40L) == 0L) {
                    this.uncheckedVarianceClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(uncheckedVariance.class));
                    this.bitmap$3 |= 0x40L;
                }
            }
            return this.uncheckedVarianceClass;
        }

        public Symbols.ClassSymbol uncheckedVarianceClass() {
            if ((this.bitmap$3 & 0x40L) == 0L) {
                return this.uncheckedVarianceClass$lzycompute();
            }
            return this.uncheckedVarianceClass;
        }

        private Symbols.ClassSymbol BeanPropertyAttr$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x80L) == 0L) {
                    this.BeanPropertyAttr = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(BeanProperty.class));
                    this.bitmap$3 |= 0x80L;
                }
            }
            return this.BeanPropertyAttr;
        }

        public Symbols.ClassSymbol BeanPropertyAttr() {
            if ((this.bitmap$3 & 0x80L) == 0L) {
                return this.BeanPropertyAttr$lzycompute();
            }
            return this.BeanPropertyAttr;
        }

        private Symbols.ClassSymbol BooleanBeanPropertyAttr$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x100L) == 0L) {
                    this.BooleanBeanPropertyAttr = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(BooleanBeanProperty.class));
                    this.bitmap$3 |= 0x100L;
                }
            }
            return this.BooleanBeanPropertyAttr;
        }

        public Symbols.ClassSymbol BooleanBeanPropertyAttr() {
            if ((this.bitmap$3 & 0x100L) == 0L) {
                return this.BooleanBeanPropertyAttr$lzycompute();
            }
            return this.BooleanBeanPropertyAttr;
        }

        private Symbols.Symbol CompileTimeOnlyAttr$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x200L) == 0L) {
                    this.CompileTimeOnlyAttr = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("scala.annotation.compileTimeOnly");
                    this.bitmap$3 |= 0x200L;
                }
            }
            return this.CompileTimeOnlyAttr;
        }

        public Symbols.Symbol CompileTimeOnlyAttr() {
            if ((this.bitmap$3 & 0x200L) == 0L) {
                return this.CompileTimeOnlyAttr$lzycompute();
            }
            return this.CompileTimeOnlyAttr;
        }

        private Symbols.ClassSymbol DeprecatedAttr$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x400L) == 0L) {
                    this.DeprecatedAttr = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(deprecated.class));
                    this.bitmap$3 |= 0x400L;
                }
            }
            return this.DeprecatedAttr;
        }

        public Symbols.ClassSymbol DeprecatedAttr() {
            if ((this.bitmap$3 & 0x400L) == 0L) {
                return this.DeprecatedAttr$lzycompute();
            }
            return this.DeprecatedAttr;
        }

        private Symbols.ClassSymbol DeprecatedNameAttr$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x800L) == 0L) {
                    this.DeprecatedNameAttr = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(deprecatedName.class));
                    this.bitmap$3 |= 0x800L;
                }
            }
            return this.DeprecatedNameAttr;
        }

        public Symbols.ClassSymbol DeprecatedNameAttr() {
            if ((this.bitmap$3 & 0x800L) == 0L) {
                return this.DeprecatedNameAttr$lzycompute();
            }
            return this.DeprecatedNameAttr;
        }

        private Symbols.ClassSymbol DeprecatedInheritanceAttr$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x1000L) == 0L) {
                    this.DeprecatedInheritanceAttr = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(deprecatedInheritance.class));
                    this.bitmap$3 |= 0x1000L;
                }
            }
            return this.DeprecatedInheritanceAttr;
        }

        public Symbols.ClassSymbol DeprecatedInheritanceAttr() {
            if ((this.bitmap$3 & 0x1000L) == 0L) {
                return this.DeprecatedInheritanceAttr$lzycompute();
            }
            return this.DeprecatedInheritanceAttr;
        }

        private Symbols.ClassSymbol DeprecatedOverridingAttr$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x2000L) == 0L) {
                    this.DeprecatedOverridingAttr = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(deprecatedOverriding.class));
                    this.bitmap$3 |= 0x2000L;
                }
            }
            return this.DeprecatedOverridingAttr;
        }

        public Symbols.ClassSymbol DeprecatedOverridingAttr() {
            if ((this.bitmap$3 & 0x2000L) == 0L) {
                return this.DeprecatedOverridingAttr$lzycompute();
            }
            return this.DeprecatedOverridingAttr;
        }

        private Symbols.ClassSymbol NativeAttr$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x4000L) == 0L) {
                    this.NativeAttr = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(native.class));
                    this.bitmap$3 |= 0x4000L;
                }
            }
            return this.NativeAttr;
        }

        public Symbols.ClassSymbol NativeAttr() {
            if ((this.bitmap$3 & 0x4000L) == 0L) {
                return this.NativeAttr$lzycompute();
            }
            return this.NativeAttr;
        }

        private Symbols.ClassSymbol RemoteAttr$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x8000L) == 0L) {
                    this.RemoteAttr = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(remote.class));
                    this.bitmap$3 |= 0x8000L;
                }
            }
            return this.RemoteAttr;
        }

        public Symbols.ClassSymbol RemoteAttr() {
            if ((this.bitmap$3 & 0x8000L) == 0L) {
                return this.RemoteAttr$lzycompute();
            }
            return this.RemoteAttr;
        }

        private Symbols.ClassSymbol ScalaInlineClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x10000L) == 0L) {
                    this.ScalaInlineClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(inline.class));
                    this.bitmap$3 |= 0x10000L;
                }
            }
            return this.ScalaInlineClass;
        }

        public Symbols.ClassSymbol ScalaInlineClass() {
            if ((this.bitmap$3 & 0x10000L) == 0L) {
                return this.ScalaInlineClass$lzycompute();
            }
            return this.ScalaInlineClass;
        }

        private Symbols.ClassSymbol ScalaNoInlineClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x20000L) == 0L) {
                    this.ScalaNoInlineClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(noinline.class));
                    this.bitmap$3 |= 0x20000L;
                }
            }
            return this.ScalaNoInlineClass;
        }

        public Symbols.ClassSymbol ScalaNoInlineClass() {
            if ((this.bitmap$3 & 0x20000L) == 0L) {
                return this.ScalaNoInlineClass$lzycompute();
            }
            return this.ScalaNoInlineClass;
        }

        private Symbols.ClassSymbol SerialVersionUIDAttr$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x40000L) == 0L) {
                    this.SerialVersionUIDAttr = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(SerialVersionUID.class));
                    this.bitmap$3 |= 0x40000L;
                }
            }
            return this.SerialVersionUIDAttr;
        }

        public Symbols.ClassSymbol SerialVersionUIDAttr() {
            if ((this.bitmap$3 & 0x40000L) == 0L) {
                return this.SerialVersionUIDAttr$lzycompute();
            }
            return this.SerialVersionUIDAttr;
        }

        /*
         * WARNING - void declaration
         */
        private AnnotationInfos.AnnotationInfo SerialVersionUIDAnnotation$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x80000L) == 0L) {
                    void $minus$greater$extension_y;
                    void $minus$greater$extension_$this;
                    AnnotationInfos.LiteralAnnotArg literalAnnotArg = new AnnotationInfos.LiteralAnnotArg(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer(), new Constants.Constant(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer(), BoxesRunTime.boxToInteger(0)));
                    Names.TermName termName = Predef$.MODULE$.ArrowAssoc(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().value());
                    if (Predef$ArrowAssoc$.MODULE$ == null) {
                        throw null;
                    }
                    this.SerialVersionUIDAnnotation = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().AnnotationInfo().apply(this.SerialVersionUIDAttr().tpe(), Nil$.MODULE$, new $colon$colon<Nothing$>((Nothing$)((Object)new Tuple2<void, void>($minus$greater$extension_$this, $minus$greater$extension_y)), Nil$.MODULE$));
                    this.bitmap$3 |= 0x80000L;
                }
            }
            return this.SerialVersionUIDAnnotation;
        }

        public AnnotationInfos.AnnotationInfo SerialVersionUIDAnnotation() {
            if ((this.bitmap$3 & 0x80000L) == 0L) {
                return this.SerialVersionUIDAnnotation$lzycompute();
            }
            return this.SerialVersionUIDAnnotation;
        }

        private Symbols.ClassSymbol SpecializedClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x100000L) == 0L) {
                    this.SpecializedClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(specialized.class));
                    this.bitmap$3 |= 0x100000L;
                }
            }
            return this.SpecializedClass;
        }

        public Symbols.ClassSymbol SpecializedClass() {
            if ((this.bitmap$3 & 0x100000L) == 0L) {
                return this.SpecializedClass$lzycompute();
            }
            return this.SpecializedClass;
        }

        private Symbols.ClassSymbol ThrowsClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x200000L) == 0L) {
                    this.ThrowsClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(throws.class));
                    this.bitmap$3 |= 0x200000L;
                }
            }
            return this.ThrowsClass;
        }

        public Symbols.ClassSymbol ThrowsClass() {
            if ((this.bitmap$3 & 0x200000L) == 0L) {
                return this.ThrowsClass$lzycompute();
            }
            return this.ThrowsClass;
        }

        private Symbols.ClassSymbol TransientAttr$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x400000L) == 0L) {
                    this.TransientAttr = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(transient.class));
                    this.bitmap$3 |= 0x400000L;
                }
            }
            return this.TransientAttr;
        }

        public Symbols.ClassSymbol TransientAttr() {
            if ((this.bitmap$3 & 0x400000L) == 0L) {
                return this.TransientAttr$lzycompute();
            }
            return this.TransientAttr;
        }

        private Symbols.ClassSymbol UncheckedClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x800000L) == 0L) {
                    this.UncheckedClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(unchecked.class));
                    this.bitmap$3 |= 0x800000L;
                }
            }
            return this.UncheckedClass;
        }

        public Symbols.ClassSymbol UncheckedClass() {
            if ((this.bitmap$3 & 0x800000L) == 0L) {
                return this.UncheckedClass$lzycompute();
            }
            return this.UncheckedClass;
        }

        private Symbols.Symbol UncheckedBoundsClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x1000000L) == 0L) {
                    this.UncheckedBoundsClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("scala.reflect.internal.annotations.uncheckedBounds");
                    this.bitmap$3 |= 0x1000000L;
                }
            }
            return this.UncheckedBoundsClass;
        }

        public Symbols.Symbol UncheckedBoundsClass() {
            if ((this.bitmap$3 & 0x1000000L) == 0L) {
                return this.UncheckedBoundsClass$lzycompute();
            }
            return this.UncheckedBoundsClass;
        }

        private Symbols.ClassSymbol UnspecializedClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x2000000L) == 0L) {
                    this.UnspecializedClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(unspecialized.class));
                    this.bitmap$3 |= 0x2000000L;
                }
            }
            return this.UnspecializedClass;
        }

        public Symbols.ClassSymbol UnspecializedClass() {
            if ((this.bitmap$3 & 0x2000000L) == 0L) {
                return this.UnspecializedClass$lzycompute();
            }
            return this.UnspecializedClass;
        }

        private Symbols.ClassSymbol VolatileAttr$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x4000000L) == 0L) {
                    this.VolatileAttr = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(volatile.class));
                    this.bitmap$3 |= 0x4000000L;
                }
            }
            return this.VolatileAttr;
        }

        public Symbols.ClassSymbol VolatileAttr() {
            if ((this.bitmap$3 & 0x4000000L) == 0L) {
                return this.VolatileAttr$lzycompute();
            }
            return this.VolatileAttr;
        }

        private Symbols.ClassSymbol JavaDeprecatedAttr$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x8000000L) == 0L) {
                    this.JavaDeprecatedAttr = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(Deprecated.class));
                    this.bitmap$3 |= 0x8000000L;
                }
            }
            return this.JavaDeprecatedAttr;
        }

        public Symbols.ClassSymbol JavaDeprecatedAttr() {
            if ((this.bitmap$3 & 0x8000000L) == 0L) {
                return this.JavaDeprecatedAttr$lzycompute();
            }
            return this.JavaDeprecatedAttr;
        }

        private Symbols.ClassSymbol FunctionalInterfaceClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x10000000L) == 0L) {
                    this.FunctionalInterfaceClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(FunctionalInterface.class));
                    this.bitmap$3 |= 0x10000000L;
                }
            }
            return this.FunctionalInterfaceClass;
        }

        public Symbols.ClassSymbol FunctionalInterfaceClass() {
            if ((this.bitmap$3 & 0x10000000L) == 0L) {
                return this.FunctionalInterfaceClass$lzycompute();
            }
            return this.FunctionalInterfaceClass;
        }

        private Symbols.ClassSymbol BeanGetterTargetClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x20000000L) == 0L) {
                    this.BeanGetterTargetClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(beanGetter.class));
                    this.bitmap$3 |= 0x20000000L;
                }
            }
            return this.BeanGetterTargetClass;
        }

        public Symbols.ClassSymbol BeanGetterTargetClass() {
            if ((this.bitmap$3 & 0x20000000L) == 0L) {
                return this.BeanGetterTargetClass$lzycompute();
            }
            return this.BeanGetterTargetClass;
        }

        private Symbols.ClassSymbol BeanSetterTargetClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x40000000L) == 0L) {
                    this.BeanSetterTargetClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(beanSetter.class));
                    this.bitmap$3 |= 0x40000000L;
                }
            }
            return this.BeanSetterTargetClass;
        }

        public Symbols.ClassSymbol BeanSetterTargetClass() {
            if ((this.bitmap$3 & 0x40000000L) == 0L) {
                return this.BeanSetterTargetClass$lzycompute();
            }
            return this.BeanSetterTargetClass;
        }

        private Symbols.ClassSymbol FieldTargetClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x80000000L) == 0L) {
                    this.FieldTargetClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(field.class));
                    this.bitmap$3 |= 0x80000000L;
                }
            }
            return this.FieldTargetClass;
        }

        public Symbols.ClassSymbol FieldTargetClass() {
            if ((this.bitmap$3 & 0x80000000L) == 0L) {
                return this.FieldTargetClass$lzycompute();
            }
            return this.FieldTargetClass;
        }

        private Symbols.ClassSymbol GetterTargetClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x100000000L) == 0L) {
                    this.GetterTargetClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(getter.class));
                    this.bitmap$3 |= 0x100000000L;
                }
            }
            return this.GetterTargetClass;
        }

        public Symbols.ClassSymbol GetterTargetClass() {
            if ((this.bitmap$3 & 0x100000000L) == 0L) {
                return this.GetterTargetClass$lzycompute();
            }
            return this.GetterTargetClass;
        }

        private Symbols.ClassSymbol ParamTargetClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x200000000L) == 0L) {
                    this.ParamTargetClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(param.class));
                    this.bitmap$3 |= 0x200000000L;
                }
            }
            return this.ParamTargetClass;
        }

        public Symbols.ClassSymbol ParamTargetClass() {
            if ((this.bitmap$3 & 0x200000000L) == 0L) {
                return this.ParamTargetClass$lzycompute();
            }
            return this.ParamTargetClass;
        }

        private Symbols.ClassSymbol SetterTargetClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x400000000L) == 0L) {
                    this.SetterTargetClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(setter.class));
                    this.bitmap$3 |= 0x400000000L;
                }
            }
            return this.SetterTargetClass;
        }

        public Symbols.ClassSymbol SetterTargetClass() {
            if ((this.bitmap$3 & 0x400000000L) == 0L) {
                return this.SetterTargetClass$lzycompute();
            }
            return this.SetterTargetClass;
        }

        private Symbols.ClassSymbol ObjectTargetClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x800000000L) == 0L) {
                    this.ObjectTargetClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(companionObject.class));
                    this.bitmap$3 |= 0x800000000L;
                }
            }
            return this.ObjectTargetClass;
        }

        public Symbols.ClassSymbol ObjectTargetClass() {
            if ((this.bitmap$3 & 0x800000000L) == 0L) {
                return this.ObjectTargetClass$lzycompute();
            }
            return this.ObjectTargetClass;
        }

        private Symbols.ClassSymbol ClassTargetClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x1000000000L) == 0L) {
                    this.ClassTargetClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(companionClass.class));
                    this.bitmap$3 |= 0x1000000000L;
                }
            }
            return this.ClassTargetClass;
        }

        public Symbols.ClassSymbol ClassTargetClass() {
            if ((this.bitmap$3 & 0x1000000000L) == 0L) {
                return this.ClassTargetClass$lzycompute();
            }
            return this.ClassTargetClass;
        }

        private Symbols.ClassSymbol MethodTargetClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x2000000000L) == 0L) {
                    this.MethodTargetClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(companionMethod.class));
                    this.bitmap$3 |= 0x2000000000L;
                }
            }
            return this.MethodTargetClass;
        }

        public Symbols.ClassSymbol MethodTargetClass() {
            if ((this.bitmap$3 & 0x2000000000L) == 0L) {
                return this.MethodTargetClass$lzycompute();
            }
            return this.MethodTargetClass;
        }

        private Symbols.ClassSymbol LanguageFeatureAnnot$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x4000000000L) == 0L) {
                    this.LanguageFeatureAnnot = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).requiredClass(ClassTag$.MODULE$.apply(languageFeature.class));
                    this.bitmap$3 |= 0x4000000000L;
                }
            }
            return this.LanguageFeatureAnnot;
        }

        public Symbols.ClassSymbol LanguageFeatureAnnot() {
            if ((this.bitmap$3 & 0x4000000000L) == 0L) {
                return this.LanguageFeatureAnnot$lzycompute();
            }
            return this.LanguageFeatureAnnot;
        }

        private List<Symbols.Symbol> JUnitAnnotations$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x8000000000L) == 0L) {
                    this.JUnitAnnotations = new $colon$colon<Nothing$>((Nothing$)((Object)"Test"), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)"Ignore"), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)"Before"), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)"After"), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)"BeforeClass"), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)"AfterClass"), Nil$.MODULE$)))))).map((Function1<String, Symbols.Symbol> & java.io.Serializable & Serializable)n -> ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined(new StringBuilder(10).append("org.junit.").append((String)n).toString()), List$.MODULE$.canBuildFrom());
                    this.bitmap$3 |= 0x8000000000L;
                }
            }
            return this.JUnitAnnotations;
        }

        public List<Symbols.Symbol> JUnitAnnotations() {
            if ((this.bitmap$3 & 0x8000000000L) == 0L) {
                return this.JUnitAnnotations$lzycompute();
            }
            return this.JUnitAnnotations;
        }

        private Symbols.ModuleSymbol languageFeatureModule$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x10000000000L) == 0L) {
                    this.languageFeatureModule = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getRequiredModule("scala.languageFeature");
                    this.bitmap$3 |= 0x10000000000L;
                }
            }
            return this.languageFeatureModule;
        }

        public Symbols.ModuleSymbol languageFeatureModule() {
            if ((this.bitmap$3 & 0x10000000000L) == 0L) {
                return this.languageFeatureModule$lzycompute();
            }
            return this.languageFeatureModule;
        }

        public boolean isMetaAnnotation(Symbols.Symbol sym) {
            return this.metaAnnotations().apply(sym) || sym.isAliasType() && this.isMetaAnnotation(sym.info().typeSymbol());
        }

        private Set<Symbols.Symbol> metaAnnotations$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x20000000000L) == 0L) {
                    this.metaAnnotations = ((Scopes.Scope)((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getPackage("scala.annotation.meta").info().members().filter((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$48 -> BoxesRunTime.boxToBoolean(x$48.isSubClass(this.StaticAnnotationClass())))).toSet();
                    this.bitmap$3 |= 0x20000000000L;
                }
            }
            return this.metaAnnotations;
        }

        public Set<Symbols.Symbol> metaAnnotations() {
            if ((this.bitmap$3 & 0x20000000000L) == 0L) {
                return this.metaAnnotations$lzycompute();
            }
            return this.metaAnnotations;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public Symbols.Symbol defaultAnnotationTarget(Trees.Tree t) {
            boolean bl = false;
            Trees.SymTree symTree = null;
            if (t instanceof Trees.ClassDef) {
                return this.ClassTargetClass();
            }
            if (t instanceof Trees.ModuleDef) {
                return this.ObjectTargetClass();
            }
            if (t instanceof Trees.ValDef) {
                bl = true;
                symTree = (Trees.ValDef)t;
                if (symTree.symbol().isParamAccessor()) {
                    return this.ParamTargetClass();
                }
            }
            if (bl && symTree.symbol().isValueParameter()) {
                return this.ParamTargetClass();
            }
            if (bl) {
                return this.FieldTargetClass();
            }
            if (!(t instanceof Trees.DefDef)) return this.GetterTargetClass();
            return this.MethodTargetClass();
        }

        private Symbols.ClassSymbol AnnotationDefaultAttr$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x40000000000L) == 0L) {
                    Symbols.ClassSymbol classSymbol;
                    Symbols.ClassSymbol sym = this.RuntimePackageClass().newClassSymbol(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().AnnotationDefaultATTR(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoPosition(), 0L);
                    sym.setInfo(new Types.ClassInfoType(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer(), new $colon$colon<Nothing$>((Nothing$)((Object)this.StaticAnnotationClass().tpe()), Nil$.MODULE$), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().newScope(), sym));
                    this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().markAllCompleted(Predef$.MODULE$.wrapRefArray((Object[])new Symbols.Symbol[]{sym}));
                    List list = (List)this.RuntimePackageClass().info().decls().toList().filter((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$49 -> BoxesRunTime.boxToBoolean(DefinitionsClass.$anonfun$AnnotationDefaultAttr$1(sym, x$49)));
                    if (list instanceof $colon$colon) {
                        classSymbol = (Symbols.ClassSymbol)((Symbols.Symbol)(($colon$colon)list).head());
                    } else {
                        this.RuntimePackageClass().info().decls().enter(sym);
                        sym.info().decls().enter(sym.newClassConstructor(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoPosition()));
                        classSymbol = sym;
                    }
                    this.AnnotationDefaultAttr = classSymbol;
                    this.bitmap$3 |= 0x40000000000L;
                }
            }
            return this.AnnotationDefaultAttr;
        }

        public Symbols.ClassSymbol AnnotationDefaultAttr() {
            if ((this.bitmap$3 & 0x40000000000L) == 0L) {
                return this.AnnotationDefaultAttr$lzycompute();
            }
            return this.AnnotationDefaultAttr;
        }

        private Nothing$ fatalMissingSymbol(Symbols.Symbol owner, Names.Name name, String what, String addendum) {
            throw new FatalError(new StringBuilder(1).append(Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(owner), " does not have a ")).append(what).append(" ").append(name).append(addendum).toString());
        }

        private String fatalMissingSymbol$default$3() {
            return "member";
        }

        private String fatalMissingSymbol$default$4() {
            return "";
        }

        public Symbols.Symbol getLanguageFeature(String name, Symbols.Symbol owner) {
            return this.getMember(owner, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().newTypeName(name));
        }

        public Symbols.Symbol getLanguageFeature$default$2() {
            return this.languageFeatureModule();
        }

        public Symbols.Symbol termMember(Symbols.Symbol owner, String name) {
            return owner.info().member(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().newTermName(name));
        }

        public Symbols.Symbol findNamedMember(Names.Name fullName, Symbols.Symbol root) {
            List<Names.Name> segs;
            block3: {
                block2: {
                    segs = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().segments(fullName.toString(), fullName.isTermName());
                    if (segs.isEmpty()) break block2;
                    Names.Name name = segs.head();
                    Names.Name name2 = root.simpleName();
                    if (!(name == null ? name2 != null : !name.equals(name2))) break block3;
                }
                return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol();
            }
            return this.findNamedMember((List)segs.tail(), root);
        }

        public Symbols.Symbol findNamedMember(List<Names.Name> segs, Symbols.Symbol root) {
            if (segs.isEmpty()) {
                return root;
            }
            return this.findNamedMember((List)segs.tail(), root.info().member(segs.head()));
        }

        public Symbols.Symbol getMember(Symbols.Symbol owner, Names.Name name) {
            Symbols.Symbol symbol = this.getMemberIfDefined(owner, name);
            if (symbol == null) {
                throw null;
            }
            Symbols.Symbol orElse_this = symbol;
            if (orElse_this != orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                return orElse_this;
            }
            return DefinitionsClass.$anonfun$getMember$1(this, name, owner);
        }

        public Symbols.TermSymbol getMemberValue(Symbols.Symbol owner, Names.Name name) {
            Symbols.Symbol symbol = this.getMember(owner, name.toTermName());
            if (!(symbol instanceof Symbols.TermSymbol)) {
                throw this.fatalMissingSymbol(owner, name, "member value", this.fatalMissingSymbol$default$4());
            }
            Symbols.TermSymbol termSymbol = (Symbols.TermSymbol)symbol;
            return termSymbol;
        }

        public Symbols.ModuleSymbol getMemberModule(Symbols.Symbol owner, Names.Name name) {
            Symbols.Symbol symbol = this.getMember(owner, name.toTermName());
            if (!(symbol instanceof Symbols.ModuleSymbol)) {
                Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol();
                if (!(noSymbol != null ? !noSymbol.equals(symbol) : symbol != null)) {
                    throw this.fatalMissingSymbol(owner, name, "member object", this.fatalMissingSymbol$default$4());
                }
                throw this.fatalMissingSymbol(owner, name, "member object", new StringBuilder(36).append(". A symbol ").append(symbol).append(" of kind ").append(symbol.accurateKindString()).append(" already exists.").toString());
            }
            Symbols.ModuleSymbol moduleSymbol = (Symbols.ModuleSymbol)symbol;
            return moduleSymbol;
        }

        public Symbols.TypeSymbol getTypeMember(Symbols.Symbol owner, Names.Name name) {
            Symbols.Symbol symbol = this.getMember(owner, name.toTypeName());
            if (!(symbol instanceof Symbols.TypeSymbol)) {
                throw this.fatalMissingSymbol(owner, name, "type member", this.fatalMissingSymbol$default$4());
            }
            Symbols.TypeSymbol typeSymbol = (Symbols.TypeSymbol)symbol;
            return typeSymbol;
        }

        public Symbols.ClassSymbol getMemberClass(Symbols.Symbol owner, Names.Name name) {
            Symbols.Symbol symbol = this.getMember(owner, name.toTypeName());
            if (!(symbol instanceof Symbols.ClassSymbol)) {
                throw this.fatalMissingSymbol(owner, name, "member class", this.fatalMissingSymbol$default$4());
            }
            Symbols.ClassSymbol classSymbol = (Symbols.ClassSymbol)symbol;
            return classSymbol;
        }

        public Symbols.TermSymbol getMemberMethod(Symbols.Symbol owner, Names.Name name) {
            Symbols.Symbol symbol = this.getMember(owner, name.toTermName());
            if (!(symbol instanceof Symbols.TermSymbol)) {
                throw this.fatalMissingSymbol(owner, name, "method", this.fatalMissingSymbol$default$4());
            }
            Symbols.TermSymbol termSymbol = (Symbols.TermSymbol)symbol;
            return termSymbol;
        }

        public Symbols.TermSymbol getDeclMethod(Symbols.Symbol owner, Names.Name name) {
            Symbols.Symbol symbol = this.getDecl(owner, name.toTermName());
            if (!(symbol instanceof Symbols.TermSymbol)) {
                throw this.fatalMissingSymbol(owner, name, "method", this.fatalMissingSymbol$default$4());
            }
            Symbols.TermSymbol termSymbol = (Symbols.TermSymbol)symbol;
            return termSymbol;
        }

        public Symbols.TermSymbol getDeclValue(Symbols.Symbol owner, Names.Name name) {
            Symbols.Symbol symbol = this.getDecl(owner, name.toTermName());
            if (!(symbol instanceof Symbols.TermSymbol)) {
                throw this.fatalMissingSymbol(owner, name, "declared value", this.fatalMissingSymbol$default$4());
            }
            Symbols.TermSymbol termSymbol = (Symbols.TermSymbol)symbol;
            return termSymbol;
        }

        private Phase erasurePhase$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x80000000000L) == 0L) {
                    this.erasurePhase = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().findPhaseWithName("erasure");
                    this.bitmap$3 |= 0x80000000000L;
                }
            }
            return this.erasurePhase;
        }

        private Phase erasurePhase() {
            if ((this.bitmap$3 & 0x80000000000L) == 0L) {
                return this.erasurePhase$lzycompute();
            }
            return this.erasurePhase;
        }

        /*
         * WARNING - void declaration
         */
        public Symbols.Symbol getMemberIfDefined(Symbols.Symbol owner, Names.Name name) {
            void enteringPhaseNotLaterThan_target;
            SymbolTable symbolTable = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer();
            Phase phase = this.erasurePhase();
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable enteringPhaseNotLaterThan_this = symbolTable;
            if (enteringPhaseNotLaterThan_this.isAtPhaseAfter((Phase)enteringPhaseNotLaterThan_target)) {
                Symbols.Symbol symbol;
                if (enteringPhaseNotLaterThan_target == enteringPhaseNotLaterThan_this.phase()) {
                    return DefinitionsClass.$anonfun$getMemberIfDefined$1(owner, name);
                }
                Phase enteringPhaseNotLaterThan_enteringPhase_saved = enteringPhaseNotLaterThan_this.pushPhase((Phase)enteringPhaseNotLaterThan_target);
                try {
                    symbol = DefinitionsClass.$anonfun$getMemberIfDefined$1(owner, name);
                }
                finally {
                    enteringPhaseNotLaterThan_this.popPhase(enteringPhaseNotLaterThan_enteringPhase_saved);
                }
                return symbol;
            }
            return DefinitionsClass.$anonfun$getMemberIfDefined$1(owner, name);
        }

        /*
         * WARNING - void declaration
         */
        public Symbols.Symbol getDecl(Symbols.Symbol owner, Names.Name name) {
            void var3_3;
            Symbols.Symbol symbol = this.getDeclIfDefined(owner, name);
            if (symbol == null) {
                throw null;
            }
            Symbols.Symbol orElse_this = symbol;
            if (orElse_this == orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                throw this.fatalMissingSymbol(owner, name, "decl", this.fatalMissingSymbol$default$4());
            }
            return var3_3;
        }

        public Symbols.Symbol getDeclIfDefined(Symbols.Symbol owner, Names.Name name) {
            return owner.info().nonPrivateDecl(name);
        }

        private Symbols.AliasTypeSymbol newAlias(Symbols.Symbol owner, Names.TypeName name, Types.Type alias) {
            return (Symbols.AliasTypeSymbol)owner.newAliasType(name, owner.newAliasType$default$2(), owner.newAliasType$default$3()).setInfoAndEnter(alias);
        }

        private Symbols.ClassSymbol specialPolyClass(Names.TypeName name, long flags, Function1<Symbols.Symbol, Types.Type> parentFn) {
            Symbols.ClassSymbol clazz = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewClass(this.ScalaPackageClass(), name, Nil$.MODULE$, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewClass$default$4());
            Symbols.TypeSymbol tparam = clazz.newSyntheticTypeParam("T0", flags);
            $colon$colon<Nothing$> parents = new $colon$colon<Nothing$>((Nothing$)((Object)this.AnyRefTpe()), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)parentFn.apply(tparam)), Nil$.MODULE$));
            return (Symbols.ClassSymbol)clazz.setInfo(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().GenPolyType().apply(new $colon$colon<Nothing$>((Nothing$)((Object)tparam), Nil$.MODULE$), new Types.ClassInfoType(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer(), parents, this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().newScope(), clazz))).markAllCompleted();
        }

        /*
         * WARNING - void declaration
         * Enabled aggressive block sorting
         */
        public Symbols.MethodSymbol newPolyMethod(int typeParamCount, Symbols.Symbol owner, Names.TermName name, long flags, Function1<List<Symbols.Symbol>, Tuple2<Option<List<Types.Type>>, Types.Type>> createFn) {
            void var7_14;
            Symbols.MethodSymbol msym = owner.newMethod((Names.TermName)name.encode(), this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoPosition(), flags);
            List<Symbols.Symbol> tparams = msym.newSyntheticTypeParams(typeParamCount);
            Tuple2<Option<List<Types.Type>>, Types.Type> tuple2 = createFn.apply(tparams);
            if (tuple2 != null) {
                Option<List<Types.Type>> option = tuple2._1();
                Types.Type restpe = tuple2._2();
                if (option instanceof Some) {
                    List formals = (List)((Some)option).value();
                    Types.MethodType methodType = new Types.MethodType(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer(), msym.newSyntheticValueParams(formals), restpe);
                    return (Symbols.MethodSymbol)msym.setInfo(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().genPolyType(tparams, (Types.Type)var7_14)).markAllCompleted();
                }
            }
            if (tuple2 == null) throw new MatchError((Object)null);
            Types.Type restpe = tuple2._2();
            Types.NullaryMethodType nullaryMethodType = new Types.NullaryMethodType(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer(), restpe);
            return (Symbols.MethodSymbol)msym.setInfo(this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().genPolyType(tparams, (Types.Type)var7_14)).markAllCompleted();
        }

        public Symbols.MethodSymbol enterNewPolyMethod(int typeParamCount, Symbols.Symbol owner, Names.TermName name, long flags, Function1<List<Symbols.Symbol>, Tuple2<Option<List<Types.Type>>, Types.Type>> createFn) {
            Symbols.MethodSymbol m = this.newPolyMethod(typeParamCount, owner, name, flags, createFn);
            owner.info().decls().enter(m);
            return m;
        }

        public Symbols.MethodSymbol newT1NullaryMethod(Symbols.Symbol owner, Names.TermName name, long flags, Function1<Symbols.Symbol, Types.Type> createFn) {
            return this.newPolyMethod(1, owner, name, flags, (Function1<List<Symbols.Symbol>, Tuple2<Option<List<Types.Type>>, Types.Type>>)(Function1<List, Tuple2> & java.io.Serializable & Serializable)tparams -> new Tuple2(None$.MODULE$, createFn.apply((Symbols.Symbol)tparams.head())));
        }

        public Symbols.MethodSymbol enterNewT1NullaryMethod(Symbols.Symbol owner, Names.TermName name, long flags, Function1<Symbols.Symbol, Types.Type> createFn) {
            return this.enterNewPolyMethod(1, owner, name, flags, (Function1<List<Symbols.Symbol>, Tuple2<Option<List<Types.Type>>, Types.Type>>)(Function1<List, Tuple2> & java.io.Serializable & Serializable)tparams -> new Tuple2(None$.MODULE$, createFn.apply((Symbols.Symbol)tparams.head())));
        }

        public Symbols.MethodSymbol newT1NilaryMethod(Symbols.Symbol owner, Names.TermName name, long flags, Function1<Symbols.Symbol, Types.Type> createFn) {
            return this.newPolyMethod(1, owner, name, flags, (Function1<List<Symbols.Symbol>, Tuple2<Option<List<Types.Type>>, Types.Type>>)(Function1<List, Tuple2> & java.io.Serializable & Serializable)tparams -> new Tuple2(package$.MODULE$.SomeOfNil(), createFn.apply((Symbols.Symbol)tparams.head())));
        }

        public Symbols.MethodSymbol enterNewT1NilaryMethod(Symbols.Symbol owner, Names.TermName name, long flags, Function1<Symbols.Symbol, Types.Type> createFn) {
            return this.enterNewPolyMethod(1, owner, name, flags, (Function1<List<Symbols.Symbol>, Tuple2<Option<List<Types.Type>>, Types.Type>>)(Function1<List, Tuple2> & java.io.Serializable & Serializable)tparams -> new Tuple2(package$.MODULE$.SomeOfNil(), createFn.apply((Symbols.Symbol)tparams.head())));
        }

        public Symbols.MethodSymbol newT1Method(Symbols.Symbol owner, Names.TermName name, long flags, Function1<Symbols.Symbol, Types.Type> createFn) {
            return this.newPolyMethod(1, owner, name, flags, (Function1<List<Symbols.Symbol>, Tuple2<Option<List<Types.Type>>, Types.Type>>)(Function1<List, Tuple2> & java.io.Serializable & Serializable)tparams -> {
                Types.Type t = (Types.Type)createFn.apply((Symbols.Symbol)tparams.head());
                return new Tuple2<Some<$colon$colon<Nothing$>>, Types.Type>(new Some<$colon$colon<Nothing$>>(new $colon$colon<Nothing$>((Nothing$)((Object)t), Nil$.MODULE$)), t);
            });
        }

        public Symbols.MethodSymbol enterNewT1Method(Symbols.Symbol owner, Names.TermName name, long flags, Function1<Symbols.Symbol, Types.Type> createFn) {
            return this.enterNewPolyMethod(1, owner, name, flags, (Function1<List<Symbols.Symbol>, Tuple2<Option<List<Types.Type>>, Types.Type>>)(Function1<List, Tuple2> & java.io.Serializable & Serializable)tparams -> {
                Types.Type t = (Types.Type)createFn.apply((Symbols.Symbol)tparams.head());
                return new Tuple2<Some<$colon$colon<Nothing$>>, Types.Type>(new Some<$colon$colon<Nothing$>>(new $colon$colon<Nothing$>((Nothing$)((Object)t), Nil$.MODULE$)), t);
            });
        }

        private Set<Symbols.Symbol> isPhantomClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x100000000000L) == 0L) {
                    this.isPhantomClass = (Set)Predef$.MODULE$.Set().apply(Predef$.MODULE$.wrapRefArray((Object[])new Symbols.Symbol[]{this.AnyClass(), this.AnyValClass(), this.NullClass(), this.NothingClass()}));
                    this.bitmap$3 |= 0x100000000000L;
                }
            }
            return this.isPhantomClass;
        }

        public Set<Symbols.Symbol> isPhantomClass() {
            if ((this.bitmap$3 & 0x100000000000L) == 0L) {
                return this.isPhantomClass$lzycompute();
            }
            return this.isPhantomClass;
        }

        private List<Symbols.TypeSymbol> syntheticCoreClasses$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x200000000000L) == 0L) {
                    this.syntheticCoreClasses = List$.MODULE$.apply(Predef$.MODULE$.wrapRefArray((Object[])new Symbols.TypeSymbol[]{this.AnnotationDefaultAttr(), this.RepeatedParamClass(), this.JavaRepeatedParamClass(), this.ByNameParamClass(), this.AnyClass(), this.AnyRefClass(), this.AnyValClass(), this.NullClass(), this.NothingClass(), this.SingletonClass()}));
                    this.bitmap$3 |= 0x200000000000L;
                }
            }
            return this.syntheticCoreClasses;
        }

        public List<Symbols.TypeSymbol> syntheticCoreClasses() {
            if ((this.bitmap$3 & 0x200000000000L) == 0L) {
                return this.syntheticCoreClasses$lzycompute();
            }
            return this.syntheticCoreClasses;
        }

        private List<Symbols.MethodSymbol> syntheticCoreMethods$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x400000000000L) == 0L) {
                    this.syntheticCoreMethods = List$.MODULE$.apply(Predef$.MODULE$.wrapRefArray((Object[])new Symbols.MethodSymbol[]{this.Any_$eq$eq(), this.Any_$bang$eq(), this.Any_equals(), this.Any_hashCode(), this.Any_toString(), this.Any_getClass(), this.Any_isInstanceOf(), this.Any_asInstanceOf(), this.Any_$hash$hash(), this.Object_eq(), this.Object_ne(), this.Object_$eq$eq(), this.Object_$bang$eq(), this.Object_$hash$hash(), this.Object_synchronized(), this.Object_isInstanceOf(), this.Object_asInstanceOf(), this.String_$plus()}));
                    this.bitmap$3 |= 0x400000000000L;
                }
            }
            return this.syntheticCoreMethods;
        }

        public List<Symbols.MethodSymbol> syntheticCoreMethods() {
            if ((this.bitmap$3 & 0x400000000000L) == 0L) {
                return this.syntheticCoreMethods$lzycompute();
            }
            return this.syntheticCoreMethods;
        }

        private List<Symbols.ClassSymbol> hijackedCoreClasses$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x800000000000L) == 0L) {
                    this.hijackedCoreClasses = new $colon$colon<Nothing$>((Nothing$)((Object)this.ComparableClass()), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)this.JavaSerializableClass()), Nil$.MODULE$));
                    this.bitmap$3 |= 0x800000000000L;
                }
            }
            return this.hijackedCoreClasses;
        }

        public List<Symbols.ClassSymbol> hijackedCoreClasses() {
            if ((this.bitmap$3 & 0x800000000000L) == 0L) {
                return this.hijackedCoreClasses$lzycompute();
            }
            return this.hijackedCoreClasses;
        }

        private List<Symbols.Symbol> symbolsNotPresentInBytecode$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x1000000000000L) == 0L) {
                    this.symbolsNotPresentInBytecode = this.syntheticCoreClasses().$plus$plus(this.syntheticCoreMethods(), List$.MODULE$.canBuildFrom()).$plus$plus(this.hijackedCoreClasses(), List$.MODULE$.canBuildFrom());
                    this.bitmap$3 |= 0x1000000000000L;
                }
            }
            return this.symbolsNotPresentInBytecode;
        }

        public List<Symbols.Symbol> symbolsNotPresentInBytecode() {
            if ((this.bitmap$3 & 0x1000000000000L) == 0L) {
                return this.symbolsNotPresentInBytecode$lzycompute();
            }
            return this.symbolsNotPresentInBytecode;
        }

        private Set<Symbols.Symbol> isPossibleSyntheticParent$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x2000000000000L) == 0L) {
                    this.isPossibleSyntheticParent = (Set)this.ProductClass().seq().toSet().$plus(this.ProductRootClass()).$plus((Symbols.ClassSymbol)this.SerializableClass());
                    this.bitmap$3 |= 0x2000000000000L;
                }
            }
            return this.isPossibleSyntheticParent;
        }

        public Set<Symbols.Symbol> isPossibleSyntheticParent() {
            if ((this.bitmap$3 & 0x2000000000000L) == 0L) {
                return this.isPossibleSyntheticParent$lzycompute();
            }
            return this.isPossibleSyntheticParent;
        }

        private Set<Symbols.Symbol> boxedValueClassesSet$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x4000000000000L) == 0L) {
                    this.boxedValueClassesSet = (Set)this.boxedClass().values().toSet().$plus(this.BoxedUnitClass());
                    this.bitmap$3 |= 0x4000000000000L;
                }
            }
            return this.boxedValueClassesSet;
        }

        private Set<Symbols.Symbol> boxedValueClassesSet() {
            if ((this.bitmap$3 & 0x4000000000000L) == 0L) {
                return this.boxedValueClassesSet$lzycompute();
            }
            return this.boxedValueClassesSet;
        }

        public boolean isPrimitiveValueClass(Symbols.Symbol sym) {
            return this.ScalaValueClassesSet().contains(sym);
        }

        public boolean isPrimitiveValueType(Types.Type tp) {
            return this.isPrimitiveValueClass(tp.typeSymbol());
        }

        public boolean isBoxedValueClass(Symbols.Symbol sym) {
            return this.boxedValueClassesSet().apply(sym);
        }

        public Symbols.Symbol unboxedValueClass(Symbols.Symbol sym) {
            if (this.isPrimitiveValueClass(sym)) {
                return sym;
            }
            Symbols.Symbol symbol = sym;
            Symbols.ClassSymbol classSymbol = this.BoxedUnitClass();
            if (!(symbol != null ? !symbol.equals(classSymbol) : classSymbol != null)) {
                return this.UnitClass();
            }
            return (Symbols.Symbol)((MapLike)this.boxedClass().map((Function1<Tuple2, Tuple2> & java.io.Serializable & Serializable)kvp -> new Tuple2((Symbols.Symbol)kvp._2(), kvp._1()), Map$.MODULE$.canBuildFrom())).getOrElse(sym, (Function0<Symbols.NoSymbol> & java.io.Serializable & Serializable)() -> this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol());
        }

        public boolean isNumericValueType(Types.Type tp) {
            boolean bl;
            if (tp instanceof Types.TypeRef) {
                Symbols.Symbol sym = ((Types.TypeRef)tp).sym();
                bl = this.isNumericValueClass(sym);
            } else {
                bl = false;
            }
            return bl;
        }

        private Symbols.Symbol ShowAsInfixAnnotationClass$lzycompute() {
            synchronized (this) {
                if ((this.bitmap$3 & 0x8000000000000L) == 0L) {
                    this.ShowAsInfixAnnotationClass = ((Mirrors.RootsBase)this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getClassIfDefined("scala.annotation.showAsInfix");
                    this.bitmap$3 |= 0x8000000000000L;
                }
            }
            return this.ShowAsInfixAnnotationClass;
        }

        public Symbols.Symbol ShowAsInfixAnnotationClass() {
            if ((this.bitmap$3 & 0x8000000000000L) == 0L) {
                return this.ShowAsInfixAnnotationClass$lzycompute();
            }
            return this.ShowAsInfixAnnotationClass;
        }

        public String signature(Types.Type tp) {
            Types.Type etp = this.erasure$1(tp);
            Symbols.Symbol symbol = etp.typeSymbol();
            Symbols.ClassSymbol classSymbol = this.ArrayClass();
            if (!(symbol != null ? !symbol.equals(classSymbol) : classSymbol != null)) {
                return this.signature1$1(etp);
            }
            return this.flatNameString$1(etp.typeSymbol(), '.');
        }

        public void init() {
            if (this.isInitialized()) {
                return;
            }
            this.ObjectClass().initialize();
            this.ScalaPackageClass().initialize();
            this.symbolsNotPresentInBytecode();
            this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol();
            this.isInitialized_$eq(true);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Definitions$DefinitionsClass$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ Definitions scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer() {
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer();
        }

        @Override
        public /* synthetic */ StandardDefinitions scala$reflect$api$StandardDefinitions$DefinitionsApi$$$outer() {
            return this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer();
        }

        private final void NothingClass$lzycompute$1() {
            synchronized (this) {
                if (this.NothingClass$module == null) {
                    this.NothingClass$module = new Definitions$DefinitionsClass$NothingClass$(this);
                }
                return;
            }
        }

        private final void NullClass$lzycompute$1() {
            synchronized (this) {
                if (this.NullClass$module == null) {
                    this.NullClass$module = new Definitions$DefinitionsClass$NullClass$(this);
                }
                return;
            }
        }

        private final void VarArityClass$lzycompute$1() {
            synchronized (this) {
                if (this.VarArityClass$module == null) {
                    this.VarArityClass$module = new Definitions$DefinitionsClass$VarArityClass$(this);
                }
                return;
            }
        }

        private final void MacroContextType$lzycompute$1() {
            synchronized (this) {
                if (this.MacroContextType$module == null) {
                    this.MacroContextType$module = new Definitions$DefinitionsClass$MacroContextType$(this);
                }
                return;
            }
        }

        public static final /* synthetic */ Symbols.ClassSymbol $anonfun$AnyValClass$1(DefinitionsClass $this) {
            Types.Type type = $this.AnyTpe();
            Symbols.ClassSymbol anyval = $this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().scala$reflect$internal$Definitions$$enterNewClass($this.ScalaPackageClass(), $this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().AnyVal(), Nil$.MODULE$.$colon$colon(type), 8L);
            Symbols.MethodSymbol av_constr = anyval.newClassConstructor($this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoPosition());
            anyval.info().decls().enter(av_constr);
            return (Symbols.ClassSymbol)anyval.markAllCompleted();
        }

        public static final /* synthetic */ Types.Type $anonfun$repeatedToSingle$1(DefinitionsClass $this, Types.Type tp$3) {
            return $this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().elementExtract($this.JavaRepeatedParamClass(), tp$3);
        }

        public static final /* synthetic */ boolean $anonfun$isArrayOfSymbol$1(Symbols.Symbol elem$1, Types.Type x$9) {
            Symbols.Symbol symbol = x$9.typeSymbol();
            return !(symbol != null ? !symbol.equals(elem$1) : elem$1 != null);
        }

        public static final /* synthetic */ boolean $anonfun$ArrayModule_genericApply$1(DefinitionsClass $this, Symbols.Symbol x$10) {
            Symbols.Symbol symbol = ((Symbols.Symbol)((LinearSeqOptimized)((Object)x$10.paramss().flatten((Function1)Predef$.MODULE$.$conforms()))).last()).tpe().typeSymbol();
            Symbols.ClassSymbol classSymbol = $this.ClassTagClass();
            return !(symbol != null ? !symbol.equals(classSymbol) : classSymbol != null);
        }

        public static final /* synthetic */ boolean $anonfun$ArrayModule_apply$1(DefinitionsClass $this, Types.Type tp$6, Symbols.Symbol x$11) {
            return x$11.tpe().resultType().$eq$colon$eq($this.arrayType(tp$6));
        }

        public static final /* synthetic */ Types$NoType$ $anonfun$isBlackboxMacroBundleType$1(DefinitionsClass $this) {
            return $this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoType();
        }

        private static final Symbols.Symbol sym$1(Types.Type tp$7) {
            return tp$7.typeSymbol();
        }

        private final boolean volatileUpperBound$1(Types.Type tp$7) {
            return this.isVolatile(tp$7.upperBound());
        }

        private final boolean safeIsVolatile$1(Types.Type tp$7) {
            block9: {
                block8: {
                    boolean bl;
                    if (this.volatileRecursions < 50) {
                        return this.volatileUpperBound$1(tp$7);
                    }
                    if (this.pendingVolatiles.apply(DefinitionsClass.sym$1(tp$7))) break block8;
                    this.pendingVolatiles.$plus$eq((Object)DefinitionsClass.sym$1(tp$7));
                    try {
                        bl = this.volatileUpperBound$1(tp$7);
                    }
                    finally {
                        this.pendingVolatiles.$minus$eq((Object)DefinitionsClass.sym$1(tp$7));
                    }
                    if (!bl) break block9;
                }
                return true;
            }
            return false;
        }

        private final boolean isVolatileAbstractType$1(Types.Type tp$7) {
            boolean bl;
            ++this.volatileRecursions;
            try {
                bl = this.safeIsVolatile$1(tp$7);
            }
            finally {
                --this.volatileRecursions;
            }
            return bl;
        }

        private static final boolean isVisibleDeferred$1(Symbols.Symbol m, Types.Type tp$7) {
            return m.isDeferred() && tp$7.nonPrivateMember(m.name()).alternatives().contains(m);
        }

        private static final boolean contributesAbstractMembers$1(Types.Type p, Types.Type tp$7) {
            return p.deferredMembers().exists((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)m -> BoxesRunTime.boxToBoolean(DefinitionsClass.isVisibleDeferred$1(m, tp$7)));
        }

        public static final /* synthetic */ boolean $anonfun$isVolatile$2(Types.Type p) {
            return !p.typeSymbol().isAbstractType();
        }

        private static final List dropConcreteParents$1(List parents$2) {
            return parents$2.dropWhile((Function1<Types.Type, Object> & java.io.Serializable & Serializable)p -> BoxesRunTime.boxToBoolean(DefinitionsClass.$anonfun$isVolatile$2(p)));
        }

        /*
         * WARNING - void declaration
         */
        private final boolean isVolatileRefinedType$1(Types.Type tp$7) {
            block12: {
                block11: {
                    boolean bl;
                    boolean bl2;
                    void decls;
                    void parents;
                    block10: {
                        void var5_4;
                        void var4_3;
                        if (!(tp$7 instanceof Types.RefinedType)) {
                            throw new MatchError(tp$7);
                        }
                        Types.RefinedType refinedType = (Types.RefinedType)tp$7;
                        List<Types.Type> parents2 = refinedType.parents();
                        Scopes.Scope decls2 = refinedType.decls();
                        parents = var4_3;
                        decls = var5_4;
                        if (parents == null) {
                            throw null;
                        }
                        LinearSeqOptimized exists_these = parents;
                        while (!exists_these.isEmpty()) {
                            Types.Type type = (Types.Type)exists_these.head();
                            if (this.isVolatile(type)) {
                                bl2 = true;
                                break block10;
                            }
                            exists_these = (LinearSeqOptimized)exists_these.tail();
                        }
                        bl2 = false;
                    }
                    if (bl2) break block11;
                    List list = DefinitionsClass.dropConcreteParents$1((List)parents);
                    if (((Object)Nil$.MODULE$).equals(list)) {
                        bl = false;
                    } else {
                        boolean bl3 = bl = list != parents || ((LinearSeqOptimized)list.tail()).exists((Function1<Types.Type, Object> & java.io.Serializable & Serializable)p -> BoxesRunTime.boxToBoolean(DefinitionsClass.contributesAbstractMembers$1(p, tp$7))) || decls.exists((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)m -> BoxesRunTime.boxToBoolean(DefinitionsClass.isVisibleDeferred$1(m, tp$7)));
                    }
                    if (!bl) break block12;
                }
                return true;
            }
            return false;
        }

        private final boolean isVolatileTypeRef$1(Types.TypeRef tr, Types.Type tp$7) {
            Types.Type dealised = tr.dealias();
            if (dealised != tr) {
                return this.isVolatile(dealised);
            }
            if (tr.sym().isAbstractType()) {
                return this.isVolatileAbstractType$1(tp$7);
            }
            return false;
        }

        public static final /* synthetic */ boolean $anonfun$samOf$1(DefinitionsClass $this, Symbols.Symbol mem) {
            return mem.isDeferred() && !$this.isUniversalMember(mem);
        }

        public static final /* synthetic */ boolean $anonfun$resultOfMatchingMethod$1(Symbols.Symbol x$24, Types.Type x$25) {
            return x$24.tpe().$eq$colon$eq(x$25);
        }

        /*
         * WARNING - void declaration
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private final boolean matchesParams$1(Symbols.Symbol member, Seq paramTypes$1) {
            GenSeq corresponds_that;
            List<List<Symbols.Symbol>> list = member.paramss();
            if (((Object)Nil$.MODULE$).equals(list)) {
                return paramTypes$1.isEmpty();
            }
            if (!(list instanceof $colon$colon)) throw new MatchError(list);
            $colon$colon $colon$colon = ($colon$colon)list;
            List ps = (List)$colon$colon.head();
            List<List<Symbols.Symbol>> rest = $colon$colon.tl$access$1();
            if (!rest.isEmpty()) {
                if (!this.isImplicitParamss(rest)) return false;
            }
            if (ps == null) {
                throw null;
            }
            Seq seq = paramTypes$1;
            List list2 = ps;
            while (true) {
                void var8_10;
                if (var8_10.isEmpty()) break;
                if (!corresponds_that.nonEmpty()) return false;
                Types.Type type = (Types.Type)corresponds_that.head();
                if (!DefinitionsClass.$anonfun$resultOfMatchingMethod$1((Symbols.Symbol)var8_10.head(), type)) return false;
                corresponds_that = (GenSeq)corresponds_that.tail();
                LinearSeqLike linearSeqLike = (LinearSeqLike)var8_10.tail();
            }
            boolean bl = corresponds_that.isEmpty();
            if (!bl) return false;
            return true;
        }

        public static final /* synthetic */ Symbols.Symbol $anonfun$EnumType$1(Symbols.Symbol sym$2) {
            return sym$2.owner().linkedClassOfClass();
        }

        public static final /* synthetic */ boolean $anonfun$removeRedundantObjects$1(DefinitionsClass $this, Types.Type x$34) {
            Symbols.Symbol symbol = x$34.typeSymbol();
            Symbols.ClassSymbol classSymbol = $this.ObjectClass();
            return !(symbol != null ? !symbol.equals(classSymbol) : classSymbol != null);
        }

        public static final /* synthetic */ boolean $anonfun$normalizedParents$1(DefinitionsClass $this, Types.Type t) {
            return t.typeSymbol() != $this.ObjectClass() && t.typeSymbol().isClass();
        }

        public static final /* synthetic */ boolean $anonfun$normalizedParents$2(DefinitionsClass $this, Types.Type x$37) {
            return x$37.typeSymbol() == $this.ObjectClass();
        }

        public static final /* synthetic */ boolean $anonfun$AnnotationDefaultAttr$1(Symbols.ClassSymbol sym$3, Symbols.Symbol x$49) {
            Names.Name name = x$49.name();
            Names.Name name2 = sym$3.name();
            return !(name != null ? !name.equals(name2) : name2 != null);
        }

        public static final /* synthetic */ Symbols.Symbol $anonfun$getMember$1(DefinitionsClass $this, Names.Name name$1, Symbols.Symbol owner$1) {
            if ($this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().phase().flatClasses() && name$1.isTypeName() && !owner$1.isPackageObjectOrClass()) {
                Symbols.Symbol pkg = owner$1.owner();
                Names.TypeName flatname = (Names.TypeName)$this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().flattenedName(owner$1, name$1);
                return $this.getMember(pkg, flatname);
            }
            throw $this.fatalMissingSymbol(owner$1, name$1, $this.fatalMissingSymbol$default$3(), $this.fatalMissingSymbol$default$4());
        }

        public static final /* synthetic */ Symbols.Symbol $anonfun$getMemberIfDefined$1(Symbols.Symbol owner$2, Names.Name name$2) {
            return owner$2.info().nonPrivateMember(name$2);
        }

        private final Types.Type erasure$1(Types.Type tp) {
            while (true) {
                if (tp instanceof Types.SubType) {
                    tp = ((Types.SubType)tp).supertype();
                    continue;
                }
                if (!(tp instanceof Types.RefinedType)) break;
                tp = ((Types.RefinedType)tp).parents().head();
            }
            return tp;
        }

        private final String flatNameString$1(Symbols.Symbol sym, char separator) {
            Symbols.Symbol symbol = sym;
            Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol();
            if (!(symbol != null ? !symbol.equals(noSymbol) : noSymbol != null)) {
                return "";
            }
            if (sym.isTopLevel()) {
                return sym.javaClassName();
            }
            return new StringBuilder(1).append(this.flatNameString$1(sym.owner(), separator)).append("$").append(sym.simpleName()).toString();
        }

        private final String signature1$1(Types.Type etp) {
            Symbols.Symbol symbol = etp.typeSymbol();
            Symbols.ClassSymbol classSymbol = this.ArrayClass();
            if (!(symbol != null ? !symbol.equals(classSymbol) : classSymbol != null)) {
                return new StringBuilder(1).append("[").append(this.signature1$1(this.erasure$1(etp.dealiasWiden().typeArgs().head()))).toString();
            }
            if (this.isPrimitiveValueClass(etp.typeSymbol())) {
                return this.abbrvTag().apply(etp.typeSymbol()).toString();
            }
            return new StringBuilder(2).append("L").append(this.flatNameString$1(etp.typeSymbol(), '/')).append(";").toString();
        }

        /*
         * Unable to fully structure code
         */
        public DefinitionsClass(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            super();
            StandardDefinitions.DefinitionsApi.$init$(this);
            ValueClassDefinitions.$init$(this);
            this.isInitialized = false;
            this.MaxTupleArity = 22;
            this.MaxProductArity = 22;
            this.MaxFunctionArity = 22;
            this.MaxTupleAritySpecialized = 2;
            this.MaxProductAritySpecialized = 2;
            this.MaxFunctionAritySpecialized = 2;
            this.volatileRecursions = 0;
            this.pendingVolatiles = (HashSet)HashSet$.MODULE$.apply(Nil$.MODULE$);
            if ($outer.settings().isScala212()) ** GOTO lbl-1000
            if ($outer.settings().isScala211()) {
                var2_2 = $outer.settings().Xexperimental();
                if (MutableSettings$.MODULE$ == null) {
                    throw null;
                }
                ** if (!BoxesRunTime.unboxToBoolean((Object)reflectSettingToBoolean_s.value())) goto lbl-1000
            }
            ** GOTO lbl-1000
lbl-1000:
            // 2 sources

            {
                v0 = true;
                ** GOTO lbl26
            }
lbl-1000:
            // 2 sources

            {
                v0 = false;
            }
lbl26:
            // 2 sources

            this.doSam = v0;
        }

        public static final /* synthetic */ Object $anonfun$hasJavaMainMethod$1$adapted(DefinitionsClass $this, Symbols.Symbol sym) {
            return BoxesRunTime.boxToBoolean($this.isJavaMainMethod(sym));
        }

        public static final /* synthetic */ Object $anonfun$getProductArgs$1$adapted(DefinitionsClass $this, Symbols.Symbol sym) {
            return BoxesRunTime.boxToBoolean($this.isProductNSymbol(sym));
        }

        public static final /* synthetic */ Object $anonfun$functionNBaseType$1$adapted(DefinitionsClass $this, Symbols.Symbol sym) {
            return BoxesRunTime.boxToBoolean($this.isFunctionSymbol(sym));
        }

        public static final /* synthetic */ Object $anonfun$normalizedParents$1$adapted(DefinitionsClass $this, Types.Type t) {
            return BoxesRunTime.boxToBoolean(DefinitionsClass.$anonfun$normalizedParents$1($this, t));
        }

        public static final /* synthetic */ Object $anonfun$isVolatile$3$adapted(DefinitionsClass $this, Types.Type tp) {
            return BoxesRunTime.boxToBoolean($this.isVolatile(tp));
        }

        public static final /* synthetic */ Object $anonfun$resultOfMatchingMethod$1$adapted(Symbols.Symbol x$24, Types.Type x$25) {
            return BoxesRunTime.boxToBoolean(DefinitionsClass.$anonfun$resultOfMatchingMethod$1(x$24, x$25));
        }

        public abstract class BottomClassSymbol
        extends Symbols.ClassSymbol {
            @Override
            public final boolean isBottomClass() {
                return true;
            }

            @Override
            public final boolean isThreadsafe(Symbols.SymbolOps purpose) {
                return true;
            }

            public /* synthetic */ DefinitionsClass scala$reflect$internal$Definitions$DefinitionsClass$BottomClassSymbol$$$outer() {
                return DefinitionsClass.this;
            }

            public BottomClassSymbol(Names.TypeName name, Symbols.Symbol parent) {
                if (DefinitionsClass.this == null) {
                    throw null;
                }
                super(DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer(), (Symbols.Symbol)DefinitionsClass.this.ScalaPackageClass(), (Position)DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoPosition(), name);
                this.initFlags(40L);
                this.setInfoAndEnter(new Types.ClassInfoType(DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer(), new $colon$colon<Nothing$>((Nothing$)((Object)parent.tpe()), Nil$.MODULE$), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().newScope(), this));
                this.markAllCompleted();
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
            }
        }

        public final class RunDefinitions {
            private Symbols.TermSymbol StringAdd_$plus;
            private Symbols.Symbol String_valueOf_Int;
            private Symbols.TermSymbol StringContext_f;
            private Symbols.TermSymbol StringContext_s;
            private Symbols.TermSymbol StringContext_raw;
            private Symbols.TermSymbol StringContext_apply;
            private Symbols.ClassSymbol ArrowAssocClass;
            private Symbols.Symbol Boxes_isNumberOrBool;
            private Symbols.Symbol Boxes_isNumber;
            private scala.collection.immutable.Map<Symbols.Symbol, Symbols.TermSymbol> boxMethod;
            private scala.collection.immutable.Map<Symbols.Symbol, Symbols.TermSymbol> unboxMethod;
            private Set<Symbols.Symbol> isUnbox;
            private Set<Symbols.Symbol> isBox;
            private Symbols.TermSymbol Boolean_and;
            private Symbols.TermSymbol Boolean_or;
            private Symbols.TermSymbol Boolean_not;
            private Symbols.TermSymbol Option_apply;
            private Symbols.Symbol Option_isDefined;
            private Symbols.Symbol Option_get;
            private Symbols.TermSymbol List_apply;
            private scala.collection.immutable.Map<Symbols.Symbol, Symbols.Symbol> TagMaterializers;
            private Set<Symbols.Symbol> TagSymbols;
            private Symbols.Symbol Predef_conforms;
            private Symbols.TermSymbol Predef_classOf;
            private Symbols.TermSymbol Predef_double2Double;
            private Symbols.TermSymbol Predef_float2Float;
            private Symbols.TermSymbol Predef_byte2Byte;
            private Symbols.TermSymbol Predef_short2Short;
            private Symbols.TermSymbol Predef_char2Character;
            private Symbols.TermSymbol Predef_int2Integer;
            private Symbols.TermSymbol Predef_long2Long;
            private Symbols.TermSymbol Predef_boolean2Boolean;
            private Set<Symbols.Symbol> PreDef_primitives2Primitives;
            private Symbols.TermSymbol Predef_implicitly;
            private Symbols.TermSymbol Predef_wrapRefArray;
            private Symbols.TermSymbol Predef_$qmark$qmark$qmark;
            private Symbols.TermSymbol arrayApplyMethod;
            private Symbols.TermSymbol arrayUpdateMethod;
            private Symbols.TermSymbol arrayLengthMethod;
            private Symbols.TermSymbol arrayCloneMethod;
            private Symbols.TermSymbol ensureAccessibleMethod;
            private Symbols.TermSymbol arrayClassMethod;
            private Symbols.TermSymbol traversableDropMethod;
            private Symbols.ClassSymbol GroupOfSpecializable;
            private Symbols.Symbol WeakTypeTagClass;
            private Symbols.Symbol WeakTypeTagModule;
            private Symbols.Symbol TypeTagClass;
            private Symbols.Symbol TypeTagModule;
            private Symbols.Symbol MacroContextUniverse;
            private Symbols.TermSymbol materializeClassTag;
            private Symbols.Symbol materializeWeakTypeTag;
            private Symbols.Symbol materializeTypeTag;
            private Symbols.ModuleSymbol experimentalModule;
            private Symbols.Symbol MacrosFeature;
            private Symbols.Symbol DynamicsFeature;
            private Symbols.Symbol PostfixOpsFeature;
            private Symbols.Symbol ReflectiveCallsFeature;
            private Symbols.Symbol ImplicitConversionsFeature;
            private Symbols.Symbol HigherKindsFeature;
            private Symbols.Symbol ExistentialsFeature;
            private Symbols.Symbol ApiUniverseReify;
            private Symbols.Symbol ReflectRuntimeUniverse;
            private Symbols.Symbol ReflectRuntimeCurrentMirror;
            private Symbols.Symbol TreesTreeType;
            private volatile Definitions$DefinitionsClass$RunDefinitions$TreeType$ TreeType$module;
            private volatile Definitions$DefinitionsClass$RunDefinitions$SubtreeType$ SubtreeType$module;
            private volatile Definitions$DefinitionsClass$RunDefinitions$ExprClassOf$ ExprClassOf$module;
            private Symbols.TypeSymbol PartialManifestClass;
            private Set<Symbols.Symbol> ManifestSymbols;
            private Symbols.Symbol PolymorphicSignatureClass;
            private Symbols.Symbol Scala_Java8_CompatPackage;
            private Symbols.Symbol Future_unit;
            private Symbols.Symbol Future_onComplete;
            private Symbols.Symbol Future_value;
            private Symbols.Symbol Promise_complete;
            private final Names.TypeName PolymorphicSignatureName;
            private volatile long bitmap$0;
            private volatile long bitmap$1;

            public Definitions$DefinitionsClass$RunDefinitions$TreeType$ TreeType() {
                if (this.TreeType$module == null) {
                    this.TreeType$lzycompute$1();
                }
                return this.TreeType$module;
            }

            public Definitions$DefinitionsClass$RunDefinitions$SubtreeType$ SubtreeType() {
                if (this.SubtreeType$module == null) {
                    this.SubtreeType$lzycompute$1();
                }
                return this.SubtreeType$module;
            }

            public Definitions$DefinitionsClass$RunDefinitions$ExprClassOf$ ExprClassOf() {
                if (this.ExprClassOf$module == null) {
                    this.ExprClassOf$lzycompute$1();
                }
                return this.ExprClassOf$module;
            }

            private Symbols.TermSymbol StringAdd_$plus$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 1L) == 0L) {
                        this.StringAdd_$plus = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.StringAddClass(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().PLUS());
                        this.bitmap$0 |= 1L;
                    }
                }
                return this.StringAdd_$plus;
            }

            public Symbols.TermSymbol StringAdd_$plus() {
                if ((this.bitmap$0 & 1L) == 0L) {
                    return this.StringAdd_$plus$lzycompute();
                }
                return this.StringAdd_$plus;
            }

            private Symbols.Symbol String_valueOf_Int$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 2L) == 0L) {
                        this.String_valueOf_Int = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.StringClass().companionModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().valueOf()).suchThat((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x -> BoxesRunTime.boxToBoolean(RunDefinitions.$anonfun$String_valueOf_Int$1(this, x)));
                        this.bitmap$0 |= 2L;
                    }
                }
                return this.String_valueOf_Int;
            }

            public Symbols.Symbol String_valueOf_Int() {
                if ((this.bitmap$0 & 2L) == 0L) {
                    return this.String_valueOf_Int$lzycompute();
                }
                return this.String_valueOf_Int;
            }

            public boolean isStringAddition(Symbols.Symbol sym) {
                block3: {
                    block2: {
                        Symbols.Symbol symbol = sym;
                        Symbols.MethodSymbol methodSymbol = DefinitionsClass.this.String_$plus();
                        if (!(symbol == null ? methodSymbol != null : !symbol.equals(methodSymbol))) break block2;
                        Symbols.Symbol symbol2 = sym;
                        Symbols.TermSymbol termSymbol = this.StringAdd_$plus();
                        if (symbol2 != null ? !symbol2.equals(termSymbol) : termSymbol != null) break block3;
                    }
                    return true;
                }
                return false;
            }

            private Symbols.TermSymbol StringContext_f$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 4L) == 0L) {
                        this.StringContext_f = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.StringContextClass(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().f());
                        this.bitmap$0 |= 4L;
                    }
                }
                return this.StringContext_f;
            }

            public Symbols.TermSymbol StringContext_f() {
                if ((this.bitmap$0 & 4L) == 0L) {
                    return this.StringContext_f$lzycompute();
                }
                return this.StringContext_f;
            }

            private Symbols.TermSymbol StringContext_s$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 8L) == 0L) {
                        this.StringContext_s = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.StringContextClass(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().s());
                        this.bitmap$0 |= 8L;
                    }
                }
                return this.StringContext_s;
            }

            public Symbols.TermSymbol StringContext_s() {
                if ((this.bitmap$0 & 8L) == 0L) {
                    return this.StringContext_s$lzycompute();
                }
                return this.StringContext_s;
            }

            private Symbols.TermSymbol StringContext_raw$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x10L) == 0L) {
                        this.StringContext_raw = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.StringContextClass(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().raw_());
                        this.bitmap$0 |= 0x10L;
                    }
                }
                return this.StringContext_raw;
            }

            public Symbols.TermSymbol StringContext_raw() {
                if ((this.bitmap$0 & 0x10L) == 0L) {
                    return this.StringContext_raw$lzycompute();
                }
                return this.StringContext_raw;
            }

            private Symbols.TermSymbol StringContext_apply$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x20L) == 0L) {
                        this.StringContext_apply = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.StringContextModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().apply());
                        this.bitmap$0 |= 0x20L;
                    }
                }
                return this.StringContext_apply;
            }

            public Symbols.TermSymbol StringContext_apply() {
                if ((this.bitmap$0 & 0x20L) == 0L) {
                    return this.StringContext_apply$lzycompute();
                }
                return this.StringContext_apply;
            }

            private Symbols.ClassSymbol ArrowAssocClass$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x40L) == 0L) {
                        this.ArrowAssocClass = DefinitionsClass.this.getMemberClass(DefinitionsClass.this.PredefModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().TypeName().apply("ArrowAssoc"));
                        this.bitmap$0 |= 0x40L;
                    }
                }
                return this.ArrowAssocClass;
            }

            public Symbols.ClassSymbol ArrowAssocClass() {
                if ((this.bitmap$0 & 0x40L) == 0L) {
                    return this.ArrowAssocClass$lzycompute();
                }
                return this.ArrowAssocClass;
            }

            public boolean isArrowAssoc(Symbols.Symbol sym) {
                Symbols.Symbol symbol = sym.owner();
                Symbols.ClassSymbol classSymbol = this.ArrowAssocClass();
                return !(symbol != null ? !symbol.equals(classSymbol) : classSymbol != null);
            }

            private Symbols.Symbol Boxes_isNumberOrBool$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x80L) == 0L) {
                        this.Boxes_isNumberOrBool = DefinitionsClass.this.getDecl(DefinitionsClass.this.BoxesRunTimeClass(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().isBoxedNumberOrBoolean());
                        this.bitmap$0 |= 0x80L;
                    }
                }
                return this.Boxes_isNumberOrBool;
            }

            public Symbols.Symbol Boxes_isNumberOrBool() {
                if ((this.bitmap$0 & 0x80L) == 0L) {
                    return this.Boxes_isNumberOrBool$lzycompute();
                }
                return this.Boxes_isNumberOrBool;
            }

            private Symbols.Symbol Boxes_isNumber$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x100L) == 0L) {
                        this.Boxes_isNumber = DefinitionsClass.this.getDecl(DefinitionsClass.this.BoxesRunTimeClass(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().isBoxedNumber());
                        this.bitmap$0 |= 0x100L;
                    }
                }
                return this.Boxes_isNumber;
            }

            public Symbols.Symbol Boxes_isNumber() {
                if ((this.bitmap$0 & 0x100L) == 0L) {
                    return this.Boxes_isNumber$lzycompute();
                }
                return this.Boxes_isNumber;
            }

            private Symbols.ModuleSymbol valueClassCompanion(Names.TermName name) {
                Symbols.Symbol symbol = DefinitionsClass.this.getMember(DefinitionsClass.this.ScalaPackageClass(), name);
                if (!(symbol instanceof Symbols.ModuleSymbol)) {
                    throw DefinitionsClass.this.scala$reflect$internal$Definitions$$catastrophicFailure();
                }
                Symbols.ModuleSymbol moduleSymbol = (Symbols.ModuleSymbol)symbol;
                return moduleSymbol;
            }

            private Symbols.TermSymbol valueCompanionMember(Names.Name className, Names.TermName methodName) {
                return DefinitionsClass.this.getMemberMethod(this.valueClassCompanion(className.toTermName()).moduleClass(), methodName);
            }

            private scala.collection.immutable.Map<Symbols.Symbol, Symbols.TermSymbol> boxMethod$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x200L) == 0L) {
                        this.boxMethod = DefinitionsClass.this.scala$reflect$internal$Definitions$$classesMap((Function1<Names.Name, Symbols.TermSymbol> & java.io.Serializable & Serializable)x -> this.valueCompanionMember((Names.Name)x, $this.DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().box()));
                        this.bitmap$0 |= 0x200L;
                    }
                }
                return this.boxMethod;
            }

            public scala.collection.immutable.Map<Symbols.Symbol, Symbols.TermSymbol> boxMethod() {
                if ((this.bitmap$0 & 0x200L) == 0L) {
                    return this.boxMethod$lzycompute();
                }
                return this.boxMethod;
            }

            private scala.collection.immutable.Map<Symbols.Symbol, Symbols.TermSymbol> unboxMethod$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x400L) == 0L) {
                        this.unboxMethod = DefinitionsClass.this.scala$reflect$internal$Definitions$$classesMap((Function1<Names.Name, Symbols.TermSymbol> & java.io.Serializable & Serializable)x -> this.valueCompanionMember((Names.Name)x, $this.DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().unbox()));
                        this.bitmap$0 |= 0x400L;
                    }
                }
                return this.unboxMethod;
            }

            public scala.collection.immutable.Map<Symbols.Symbol, Symbols.TermSymbol> unboxMethod() {
                if ((this.bitmap$0 & 0x400L) == 0L) {
                    return this.unboxMethod$lzycompute();
                }
                return this.unboxMethod;
            }

            private Set<Symbols.Symbol> isUnbox$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x800L) == 0L) {
                        this.isUnbox = this.unboxMethod().values().toSet();
                        this.bitmap$0 |= 0x800L;
                    }
                }
                return this.isUnbox;
            }

            public Set<Symbols.Symbol> isUnbox() {
                if ((this.bitmap$0 & 0x800L) == 0L) {
                    return this.isUnbox$lzycompute();
                }
                return this.isUnbox;
            }

            private Set<Symbols.Symbol> isBox$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x1000L) == 0L) {
                        this.isBox = this.boxMethod().values().toSet();
                        this.bitmap$0 |= 0x1000L;
                    }
                }
                return this.isBox;
            }

            public Set<Symbols.Symbol> isBox() {
                if ((this.bitmap$0 & 0x1000L) == 0L) {
                    return this.isBox$lzycompute();
                }
                return this.isBox;
            }

            private Symbols.TermSymbol Boolean_and$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x2000L) == 0L) {
                        this.Boolean_and = DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().definitions().Boolean_and();
                        this.bitmap$0 |= 0x2000L;
                    }
                }
                return this.Boolean_and;
            }

            public Symbols.TermSymbol Boolean_and() {
                if ((this.bitmap$0 & 0x2000L) == 0L) {
                    return this.Boolean_and$lzycompute();
                }
                return this.Boolean_and;
            }

            private Symbols.TermSymbol Boolean_or$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x4000L) == 0L) {
                        this.Boolean_or = DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().definitions().Boolean_or();
                        this.bitmap$0 |= 0x4000L;
                    }
                }
                return this.Boolean_or;
            }

            public Symbols.TermSymbol Boolean_or() {
                if ((this.bitmap$0 & 0x4000L) == 0L) {
                    return this.Boolean_or$lzycompute();
                }
                return this.Boolean_or;
            }

            private Symbols.TermSymbol Boolean_not$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x8000L) == 0L) {
                        this.Boolean_not = DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().definitions().Boolean_not();
                        this.bitmap$0 |= 0x8000L;
                    }
                }
                return this.Boolean_not;
            }

            public Symbols.TermSymbol Boolean_not() {
                if ((this.bitmap$0 & 0x8000L) == 0L) {
                    return this.Boolean_not$lzycompute();
                }
                return this.Boolean_not;
            }

            private Symbols.TermSymbol Option_apply$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x10000L) == 0L) {
                        this.Option_apply = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.OptionModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().apply());
                        this.bitmap$0 |= 0x10000L;
                    }
                }
                return this.Option_apply;
            }

            public Symbols.TermSymbol Option_apply() {
                if ((this.bitmap$0 & 0x10000L) == 0L) {
                    return this.Option_apply$lzycompute();
                }
                return this.Option_apply;
            }

            private Symbols.Symbol Option_isDefined$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x20000L) == 0L) {
                        this.Option_isDefined = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.OptionClass(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().TermName().apply("isDefined"));
                        this.bitmap$0 |= 0x20000L;
                    }
                }
                return this.Option_isDefined;
            }

            public Symbols.Symbol Option_isDefined() {
                if ((this.bitmap$0 & 0x20000L) == 0L) {
                    return this.Option_isDefined$lzycompute();
                }
                return this.Option_isDefined;
            }

            private Symbols.Symbol Option_get$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x40000L) == 0L) {
                        this.Option_get = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.OptionClass(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().TermName().apply("get"));
                        this.bitmap$0 |= 0x40000L;
                    }
                }
                return this.Option_get;
            }

            public Symbols.Symbol Option_get() {
                if ((this.bitmap$0 & 0x40000L) == 0L) {
                    return this.Option_get$lzycompute();
                }
                return this.Option_get;
            }

            private Symbols.TermSymbol List_apply$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x80000L) == 0L) {
                        this.List_apply = DefinitionsClass.this.List_apply();
                        this.bitmap$0 |= 0x80000L;
                    }
                }
                return this.List_apply;
            }

            public Symbols.TermSymbol List_apply() {
                if ((this.bitmap$0 & 0x80000L) == 0L) {
                    return this.List_apply$lzycompute();
                }
                return this.List_apply;
            }

            public boolean isListApply(Symbols.Symbol sym) {
                return sym.isInitialized() && DefinitionsClass.this.ListModule().hasCompleteInfo() && sym.equals(this.List_apply());
            }

            public boolean isPredefClassOf(Symbols.Symbol sym) {
                if (DefinitionsClass.this.PredefModule().hasCompleteInfo()) {
                    Symbols.Symbol symbol = sym;
                    Symbols.TermSymbol termSymbol = this.Predef_classOf();
                    return !(symbol != null ? !symbol.equals(termSymbol) : termSymbol != null);
                }
                return DefinitionsClass.this.isPredefMemberNamed(sym, DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().classOf());
            }

            /*
             * WARNING - void declaration
             */
            private scala.collection.immutable.Map<Symbols.Symbol, Symbols.Symbol> TagMaterializers$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x100000L) == 0L) {
                        void $minus$greater$extension_y;
                        void $minus$greater$extension_$this;
                        void $minus$greater$extension_y2;
                        void $minus$greater$extension_$this2;
                        void $minus$greater$extension_y3;
                        void $minus$greater$extension_$this3;
                        Tuple2[] tuple2Array = new Tuple2[3];
                        Symbols.TermSymbol termSymbol = this.materializeClassTag();
                        Symbols.ClassSymbol classSymbol = Predef$.MODULE$.ArrowAssoc(DefinitionsClass.this.ClassTagClass());
                        if (Predef$ArrowAssoc$.MODULE$ == null) {
                            throw null;
                        }
                        tuple2Array[0] = new Tuple2<void, void>($minus$greater$extension_$this3, $minus$greater$extension_y3);
                        Symbols.Symbol symbol = this.materializeWeakTypeTag();
                        Symbols.Symbol symbol2 = Predef$.MODULE$.ArrowAssoc(this.WeakTypeTagClass());
                        if (Predef$ArrowAssoc$.MODULE$ == null) {
                            throw null;
                        }
                        tuple2Array[1] = new Tuple2<void, void>($minus$greater$extension_$this2, $minus$greater$extension_y2);
                        Symbols.Symbol symbol3 = this.materializeTypeTag();
                        Symbols.Symbol symbol4 = Predef$.MODULE$.ArrowAssoc(this.TypeTagClass());
                        if (Predef$ArrowAssoc$.MODULE$ == null) {
                            throw null;
                        }
                        tuple2Array[2] = new Tuple2<void, void>($minus$greater$extension_$this, $minus$greater$extension_y);
                        this.TagMaterializers = (scala.collection.immutable.Map)Predef$.MODULE$.Map().apply(Predef$.MODULE$.wrapRefArray((Object[])tuple2Array));
                        this.bitmap$0 |= 0x100000L;
                    }
                }
                return this.TagMaterializers;
            }

            public scala.collection.immutable.Map<Symbols.Symbol, Symbols.Symbol> TagMaterializers() {
                if ((this.bitmap$0 & 0x100000L) == 0L) {
                    return this.TagMaterializers$lzycompute();
                }
                return this.TagMaterializers;
            }

            private Set<Symbols.Symbol> TagSymbols$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x200000L) == 0L) {
                        this.TagSymbols = this.TagMaterializers().keySet();
                        this.bitmap$0 |= 0x200000L;
                    }
                }
                return this.TagSymbols;
            }

            public Set<Symbols.Symbol> TagSymbols() {
                if ((this.bitmap$0 & 0x200000L) == 0L) {
                    return this.TagSymbols$lzycompute();
                }
                return this.TagSymbols;
            }

            private Symbols.Symbol Predef_conforms$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x400000L) == 0L) {
                        Symbols.Symbol symbol = DefinitionsClass.this.getMemberIfDefined(DefinitionsClass.this.PredefModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().conforms());
                        if (symbol == null) {
                            throw null;
                        }
                        Symbols.Symbol orElse_this = symbol;
                        this.Predef_conforms = orElse_this != orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol() ? orElse_this : DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.PredefModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().TermName().apply("conforms"));
                        this.bitmap$0 |= 0x400000L;
                    }
                }
                return this.Predef_conforms;
            }

            public Symbols.Symbol Predef_conforms() {
                if ((this.bitmap$0 & 0x400000L) == 0L) {
                    return this.Predef_conforms$lzycompute();
                }
                return this.Predef_conforms;
            }

            private Symbols.TermSymbol Predef_classOf$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x800000L) == 0L) {
                        this.Predef_classOf = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.PredefModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().classOf());
                        this.bitmap$0 |= 0x800000L;
                    }
                }
                return this.Predef_classOf;
            }

            public Symbols.TermSymbol Predef_classOf() {
                if ((this.bitmap$0 & 0x800000L) == 0L) {
                    return this.Predef_classOf$lzycompute();
                }
                return this.Predef_classOf;
            }

            private Symbols.TermSymbol Predef_double2Double$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x1000000L) == 0L) {
                        this.Predef_double2Double = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.PredefModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().double2Double());
                        this.bitmap$0 |= 0x1000000L;
                    }
                }
                return this.Predef_double2Double;
            }

            public Symbols.TermSymbol Predef_double2Double() {
                if ((this.bitmap$0 & 0x1000000L) == 0L) {
                    return this.Predef_double2Double$lzycompute();
                }
                return this.Predef_double2Double;
            }

            private Symbols.TermSymbol Predef_float2Float$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x2000000L) == 0L) {
                        this.Predef_float2Float = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.PredefModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().float2Float());
                        this.bitmap$0 |= 0x2000000L;
                    }
                }
                return this.Predef_float2Float;
            }

            public Symbols.TermSymbol Predef_float2Float() {
                if ((this.bitmap$0 & 0x2000000L) == 0L) {
                    return this.Predef_float2Float$lzycompute();
                }
                return this.Predef_float2Float;
            }

            private Symbols.TermSymbol Predef_byte2Byte$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x4000000L) == 0L) {
                        this.Predef_byte2Byte = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.PredefModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().byte2Byte());
                        this.bitmap$0 |= 0x4000000L;
                    }
                }
                return this.Predef_byte2Byte;
            }

            public Symbols.TermSymbol Predef_byte2Byte() {
                if ((this.bitmap$0 & 0x4000000L) == 0L) {
                    return this.Predef_byte2Byte$lzycompute();
                }
                return this.Predef_byte2Byte;
            }

            private Symbols.TermSymbol Predef_short2Short$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x8000000L) == 0L) {
                        this.Predef_short2Short = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.PredefModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().short2Short());
                        this.bitmap$0 |= 0x8000000L;
                    }
                }
                return this.Predef_short2Short;
            }

            public Symbols.TermSymbol Predef_short2Short() {
                if ((this.bitmap$0 & 0x8000000L) == 0L) {
                    return this.Predef_short2Short$lzycompute();
                }
                return this.Predef_short2Short;
            }

            private Symbols.TermSymbol Predef_char2Character$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x10000000L) == 0L) {
                        this.Predef_char2Character = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.PredefModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().char2Character());
                        this.bitmap$0 |= 0x10000000L;
                    }
                }
                return this.Predef_char2Character;
            }

            public Symbols.TermSymbol Predef_char2Character() {
                if ((this.bitmap$0 & 0x10000000L) == 0L) {
                    return this.Predef_char2Character$lzycompute();
                }
                return this.Predef_char2Character;
            }

            private Symbols.TermSymbol Predef_int2Integer$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x20000000L) == 0L) {
                        this.Predef_int2Integer = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.PredefModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().int2Integer());
                        this.bitmap$0 |= 0x20000000L;
                    }
                }
                return this.Predef_int2Integer;
            }

            public Symbols.TermSymbol Predef_int2Integer() {
                if ((this.bitmap$0 & 0x20000000L) == 0L) {
                    return this.Predef_int2Integer$lzycompute();
                }
                return this.Predef_int2Integer;
            }

            private Symbols.TermSymbol Predef_long2Long$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x40000000L) == 0L) {
                        this.Predef_long2Long = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.PredefModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().long2Long());
                        this.bitmap$0 |= 0x40000000L;
                    }
                }
                return this.Predef_long2Long;
            }

            public Symbols.TermSymbol Predef_long2Long() {
                if ((this.bitmap$0 & 0x40000000L) == 0L) {
                    return this.Predef_long2Long$lzycompute();
                }
                return this.Predef_long2Long;
            }

            private Symbols.TermSymbol Predef_boolean2Boolean$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x80000000L) == 0L) {
                        this.Predef_boolean2Boolean = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.PredefModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().boolean2Boolean());
                        this.bitmap$0 |= 0x80000000L;
                    }
                }
                return this.Predef_boolean2Boolean;
            }

            public Symbols.TermSymbol Predef_boolean2Boolean() {
                if ((this.bitmap$0 & 0x80000000L) == 0L) {
                    return this.Predef_boolean2Boolean$lzycompute();
                }
                return this.Predef_boolean2Boolean;
            }

            private Set<Symbols.Symbol> PreDef_primitives2Primitives$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x100000000L) == 0L) {
                        this.PreDef_primitives2Primitives = (Set)Predef$.MODULE$.Set().apply(Predef$.MODULE$.wrapRefArray((Object[])new Symbols.Symbol[]{this.Predef_double2Double(), this.Predef_float2Float(), this.Predef_byte2Byte(), this.Predef_short2Short(), this.Predef_char2Character(), this.Predef_int2Integer(), this.Predef_long2Long(), this.Predef_boolean2Boolean()}));
                        this.bitmap$0 |= 0x100000000L;
                    }
                }
                return this.PreDef_primitives2Primitives;
            }

            public Set<Symbols.Symbol> PreDef_primitives2Primitives() {
                if ((this.bitmap$0 & 0x100000000L) == 0L) {
                    return this.PreDef_primitives2Primitives$lzycompute();
                }
                return this.PreDef_primitives2Primitives;
            }

            private Symbols.TermSymbol Predef_implicitly$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x200000000L) == 0L) {
                        this.Predef_implicitly = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.PredefModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().implicitly());
                        this.bitmap$0 |= 0x200000000L;
                    }
                }
                return this.Predef_implicitly;
            }

            public Symbols.TermSymbol Predef_implicitly() {
                if ((this.bitmap$0 & 0x200000000L) == 0L) {
                    return this.Predef_implicitly$lzycompute();
                }
                return this.Predef_implicitly;
            }

            private Symbols.TermSymbol Predef_wrapRefArray$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x400000000L) == 0L) {
                        this.Predef_wrapRefArray = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.PredefModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().wrapRefArray());
                        this.bitmap$0 |= 0x400000000L;
                    }
                }
                return this.Predef_wrapRefArray;
            }

            public Symbols.TermSymbol Predef_wrapRefArray() {
                if ((this.bitmap$0 & 0x400000000L) == 0L) {
                    return this.Predef_wrapRefArray$lzycompute();
                }
                return this.Predef_wrapRefArray;
            }

            private Symbols.TermSymbol Predef_$qmark$qmark$qmark$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x800000000L) == 0L) {
                        this.Predef_$qmark$qmark$qmark = DefinitionsClass.this.Predef_$qmark$qmark$qmark();
                        this.bitmap$0 |= 0x800000000L;
                    }
                }
                return this.Predef_$qmark$qmark$qmark;
            }

            public Symbols.TermSymbol Predef_$qmark$qmark$qmark() {
                if ((this.bitmap$0 & 0x800000000L) == 0L) {
                    return this.Predef_$qmark$qmark$qmark$lzycompute();
                }
                return this.Predef_$qmark$qmark$qmark;
            }

            private Symbols.TermSymbol arrayApplyMethod$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x1000000000L) == 0L) {
                        this.arrayApplyMethod = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.ScalaRunTimeModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().array_apply());
                        this.bitmap$0 |= 0x1000000000L;
                    }
                }
                return this.arrayApplyMethod;
            }

            public Symbols.TermSymbol arrayApplyMethod() {
                if ((this.bitmap$0 & 0x1000000000L) == 0L) {
                    return this.arrayApplyMethod$lzycompute();
                }
                return this.arrayApplyMethod;
            }

            private Symbols.TermSymbol arrayUpdateMethod$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x2000000000L) == 0L) {
                        this.arrayUpdateMethod = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.ScalaRunTimeModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().array_update());
                        this.bitmap$0 |= 0x2000000000L;
                    }
                }
                return this.arrayUpdateMethod;
            }

            public Symbols.TermSymbol arrayUpdateMethod() {
                if ((this.bitmap$0 & 0x2000000000L) == 0L) {
                    return this.arrayUpdateMethod$lzycompute();
                }
                return this.arrayUpdateMethod;
            }

            private Symbols.TermSymbol arrayLengthMethod$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x4000000000L) == 0L) {
                        this.arrayLengthMethod = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.ScalaRunTimeModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().array_length());
                        this.bitmap$0 |= 0x4000000000L;
                    }
                }
                return this.arrayLengthMethod;
            }

            public Symbols.TermSymbol arrayLengthMethod() {
                if ((this.bitmap$0 & 0x4000000000L) == 0L) {
                    return this.arrayLengthMethod$lzycompute();
                }
                return this.arrayLengthMethod;
            }

            private Symbols.TermSymbol arrayCloneMethod$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x8000000000L) == 0L) {
                        this.arrayCloneMethod = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.ScalaRunTimeModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().array_clone());
                        this.bitmap$0 |= 0x8000000000L;
                    }
                }
                return this.arrayCloneMethod;
            }

            public Symbols.TermSymbol arrayCloneMethod() {
                if ((this.bitmap$0 & 0x8000000000L) == 0L) {
                    return this.arrayCloneMethod$lzycompute();
                }
                return this.arrayCloneMethod;
            }

            private Symbols.TermSymbol ensureAccessibleMethod$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x10000000000L) == 0L) {
                        this.ensureAccessibleMethod = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.ScalaRunTimeModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().ensureAccessible());
                        this.bitmap$0 |= 0x10000000000L;
                    }
                }
                return this.ensureAccessibleMethod;
            }

            public Symbols.TermSymbol ensureAccessibleMethod() {
                if ((this.bitmap$0 & 0x10000000000L) == 0L) {
                    return this.ensureAccessibleMethod$lzycompute();
                }
                return this.ensureAccessibleMethod;
            }

            private Symbols.TermSymbol arrayClassMethod$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x20000000000L) == 0L) {
                        this.arrayClassMethod = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.ScalaRunTimeModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().arrayClass());
                        this.bitmap$0 |= 0x20000000000L;
                    }
                }
                return this.arrayClassMethod;
            }

            public Symbols.TermSymbol arrayClassMethod() {
                if ((this.bitmap$0 & 0x20000000000L) == 0L) {
                    return this.arrayClassMethod$lzycompute();
                }
                return this.arrayClassMethod;
            }

            private Symbols.TermSymbol traversableDropMethod$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x40000000000L) == 0L) {
                        this.traversableDropMethod = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.ScalaRunTimeModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().drop());
                        this.bitmap$0 |= 0x40000000000L;
                    }
                }
                return this.traversableDropMethod;
            }

            public Symbols.TermSymbol traversableDropMethod() {
                if ((this.bitmap$0 & 0x40000000000L) == 0L) {
                    return this.traversableDropMethod$lzycompute();
                }
                return this.traversableDropMethod;
            }

            private Symbols.ClassSymbol GroupOfSpecializable$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x80000000000L) == 0L) {
                        this.GroupOfSpecializable = DefinitionsClass.this.getMemberClass(DefinitionsClass.this.SpecializableModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().Group());
                        this.bitmap$0 |= 0x80000000000L;
                    }
                }
                return this.GroupOfSpecializable;
            }

            public Symbols.ClassSymbol GroupOfSpecializable() {
                if ((this.bitmap$0 & 0x80000000000L) == 0L) {
                    return this.GroupOfSpecializable$lzycompute();
                }
                return this.GroupOfSpecializable;
            }

            private Symbols.Symbol WeakTypeTagClass$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x100000000000L) == 0L) {
                        Symbols.Symbol symbol;
                        Symbols.Symbol symbol2 = DefinitionsClass.this.TypeTagsClass();
                        if (symbol2 == null) {
                            throw null;
                        }
                        Symbols.Symbol map_this = symbol2;
                        if (map_this == map_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                            symbol = map_this;
                        } else {
                            Symbols.Symbol symbol3 = map_this;
                            symbol = DefinitionsClass.this.getMemberClass(symbol3, DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().WeakTypeTag());
                        }
                        this.WeakTypeTagClass = symbol;
                        this.bitmap$0 |= 0x100000000000L;
                    }
                }
                return this.WeakTypeTagClass;
            }

            public Symbols.Symbol WeakTypeTagClass() {
                if ((this.bitmap$0 & 0x100000000000L) == 0L) {
                    return this.WeakTypeTagClass$lzycompute();
                }
                return this.WeakTypeTagClass;
            }

            private Symbols.Symbol WeakTypeTagModule$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x200000000000L) == 0L) {
                        Symbols.Symbol symbol;
                        Symbols.Symbol symbol2 = DefinitionsClass.this.TypeTagsClass();
                        if (symbol2 == null) {
                            throw null;
                        }
                        Symbols.Symbol map_this = symbol2;
                        if (map_this == map_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                            symbol = map_this;
                        } else {
                            Symbols.Symbol symbol3 = map_this;
                            symbol = DefinitionsClass.this.getMemberModule(symbol3, DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().WeakTypeTag());
                        }
                        this.WeakTypeTagModule = symbol;
                        this.bitmap$0 |= 0x200000000000L;
                    }
                }
                return this.WeakTypeTagModule;
            }

            public Symbols.Symbol WeakTypeTagModule() {
                if ((this.bitmap$0 & 0x200000000000L) == 0L) {
                    return this.WeakTypeTagModule$lzycompute();
                }
                return this.WeakTypeTagModule;
            }

            private Symbols.Symbol TypeTagClass$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x400000000000L) == 0L) {
                        Symbols.Symbol symbol;
                        Symbols.Symbol symbol2 = DefinitionsClass.this.TypeTagsClass();
                        if (symbol2 == null) {
                            throw null;
                        }
                        Symbols.Symbol map_this = symbol2;
                        if (map_this == map_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                            symbol = map_this;
                        } else {
                            Symbols.Symbol symbol3 = map_this;
                            symbol = DefinitionsClass.this.getMemberClass(symbol3, DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().TypeTag());
                        }
                        this.TypeTagClass = symbol;
                        this.bitmap$0 |= 0x400000000000L;
                    }
                }
                return this.TypeTagClass;
            }

            public Symbols.Symbol TypeTagClass() {
                if ((this.bitmap$0 & 0x400000000000L) == 0L) {
                    return this.TypeTagClass$lzycompute();
                }
                return this.TypeTagClass;
            }

            private Symbols.Symbol TypeTagModule$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x800000000000L) == 0L) {
                        Symbols.Symbol symbol;
                        Symbols.Symbol symbol2 = DefinitionsClass.this.TypeTagsClass();
                        if (symbol2 == null) {
                            throw null;
                        }
                        Symbols.Symbol map_this = symbol2;
                        if (map_this == map_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                            symbol = map_this;
                        } else {
                            Symbols.Symbol symbol3 = map_this;
                            symbol = DefinitionsClass.this.getMemberModule(symbol3, DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().TypeTag());
                        }
                        this.TypeTagModule = symbol;
                        this.bitmap$0 |= 0x800000000000L;
                    }
                }
                return this.TypeTagModule;
            }

            public Symbols.Symbol TypeTagModule() {
                if ((this.bitmap$0 & 0x800000000000L) == 0L) {
                    return this.TypeTagModule$lzycompute();
                }
                return this.TypeTagModule;
            }

            private Symbols.Symbol MacroContextUniverse$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x1000000000000L) == 0L) {
                        this.MacroContextUniverse = DefinitionsClass.this.MacroContextUniverse();
                        this.bitmap$0 |= 0x1000000000000L;
                    }
                }
                return this.MacroContextUniverse;
            }

            public Symbols.Symbol MacroContextUniverse() {
                if ((this.bitmap$0 & 0x1000000000000L) == 0L) {
                    return this.MacroContextUniverse$lzycompute();
                }
                return this.MacroContextUniverse;
            }

            private Symbols.TermSymbol materializeClassTag$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x2000000000000L) == 0L) {
                        this.materializeClassTag = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.ReflectPackage(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().materializeClassTag());
                        this.bitmap$0 |= 0x2000000000000L;
                    }
                }
                return this.materializeClassTag;
            }

            public Symbols.TermSymbol materializeClassTag() {
                if ((this.bitmap$0 & 0x2000000000000L) == 0L) {
                    return this.materializeClassTag$lzycompute();
                }
                return this.materializeClassTag;
            }

            private Symbols.Symbol materializeWeakTypeTag$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x4000000000000L) == 0L) {
                        Symbols.Symbol symbol;
                        Symbols.Symbol symbol2 = DefinitionsClass.this.ReflectApiPackage();
                        if (symbol2 == null) {
                            throw null;
                        }
                        Symbols.Symbol map_this = symbol2;
                        if (map_this == map_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                            symbol = map_this;
                        } else {
                            Symbols.Symbol symbol3 = map_this;
                            symbol = DefinitionsClass.this.getMemberMethod(symbol3, DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().materializeWeakTypeTag());
                        }
                        this.materializeWeakTypeTag = symbol;
                        this.bitmap$0 |= 0x4000000000000L;
                    }
                }
                return this.materializeWeakTypeTag;
            }

            public Symbols.Symbol materializeWeakTypeTag() {
                if ((this.bitmap$0 & 0x4000000000000L) == 0L) {
                    return this.materializeWeakTypeTag$lzycompute();
                }
                return this.materializeWeakTypeTag;
            }

            private Symbols.Symbol materializeTypeTag$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x8000000000000L) == 0L) {
                        Symbols.Symbol symbol;
                        Symbols.Symbol symbol2 = DefinitionsClass.this.ReflectApiPackage();
                        if (symbol2 == null) {
                            throw null;
                        }
                        Symbols.Symbol map_this = symbol2;
                        if (map_this == map_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                            symbol = map_this;
                        } else {
                            Symbols.Symbol symbol3 = map_this;
                            symbol = DefinitionsClass.this.getMemberMethod(symbol3, DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().materializeTypeTag());
                        }
                        this.materializeTypeTag = symbol;
                        this.bitmap$0 |= 0x8000000000000L;
                    }
                }
                return this.materializeTypeTag;
            }

            public Symbols.Symbol materializeTypeTag() {
                if ((this.bitmap$0 & 0x8000000000000L) == 0L) {
                    return this.materializeTypeTag$lzycompute();
                }
                return this.materializeTypeTag;
            }

            private Symbols.ModuleSymbol experimentalModule$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x10000000000000L) == 0L) {
                        this.experimentalModule = DefinitionsClass.this.getMemberModule(DefinitionsClass.this.languageFeatureModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().experimental());
                        this.bitmap$0 |= 0x10000000000000L;
                    }
                }
                return this.experimentalModule;
            }

            public Symbols.ModuleSymbol experimentalModule() {
                if ((this.bitmap$0 & 0x10000000000000L) == 0L) {
                    return this.experimentalModule$lzycompute();
                }
                return this.experimentalModule;
            }

            private Symbols.Symbol MacrosFeature$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x20000000000000L) == 0L) {
                        this.MacrosFeature = DefinitionsClass.this.getLanguageFeature("macros", this.experimentalModule());
                        this.bitmap$0 |= 0x20000000000000L;
                    }
                }
                return this.MacrosFeature;
            }

            public Symbols.Symbol MacrosFeature() {
                if ((this.bitmap$0 & 0x20000000000000L) == 0L) {
                    return this.MacrosFeature$lzycompute();
                }
                return this.MacrosFeature;
            }

            private Symbols.Symbol DynamicsFeature$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x40000000000000L) == 0L) {
                        this.DynamicsFeature = DefinitionsClass.this.getLanguageFeature("dynamics", DefinitionsClass.this.getLanguageFeature$default$2());
                        this.bitmap$0 |= 0x40000000000000L;
                    }
                }
                return this.DynamicsFeature;
            }

            public Symbols.Symbol DynamicsFeature() {
                if ((this.bitmap$0 & 0x40000000000000L) == 0L) {
                    return this.DynamicsFeature$lzycompute();
                }
                return this.DynamicsFeature;
            }

            private Symbols.Symbol PostfixOpsFeature$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x80000000000000L) == 0L) {
                        this.PostfixOpsFeature = DefinitionsClass.this.getLanguageFeature("postfixOps", DefinitionsClass.this.getLanguageFeature$default$2());
                        this.bitmap$0 |= 0x80000000000000L;
                    }
                }
                return this.PostfixOpsFeature;
            }

            public Symbols.Symbol PostfixOpsFeature() {
                if ((this.bitmap$0 & 0x80000000000000L) == 0L) {
                    return this.PostfixOpsFeature$lzycompute();
                }
                return this.PostfixOpsFeature;
            }

            private Symbols.Symbol ReflectiveCallsFeature$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x100000000000000L) == 0L) {
                        this.ReflectiveCallsFeature = DefinitionsClass.this.getLanguageFeature("reflectiveCalls", DefinitionsClass.this.getLanguageFeature$default$2());
                        this.bitmap$0 |= 0x100000000000000L;
                    }
                }
                return this.ReflectiveCallsFeature;
            }

            public Symbols.Symbol ReflectiveCallsFeature() {
                if ((this.bitmap$0 & 0x100000000000000L) == 0L) {
                    return this.ReflectiveCallsFeature$lzycompute();
                }
                return this.ReflectiveCallsFeature;
            }

            private Symbols.Symbol ImplicitConversionsFeature$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x200000000000000L) == 0L) {
                        this.ImplicitConversionsFeature = DefinitionsClass.this.getLanguageFeature("implicitConversions", DefinitionsClass.this.getLanguageFeature$default$2());
                        this.bitmap$0 |= 0x200000000000000L;
                    }
                }
                return this.ImplicitConversionsFeature;
            }

            public Symbols.Symbol ImplicitConversionsFeature() {
                if ((this.bitmap$0 & 0x200000000000000L) == 0L) {
                    return this.ImplicitConversionsFeature$lzycompute();
                }
                return this.ImplicitConversionsFeature;
            }

            private Symbols.Symbol HigherKindsFeature$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x400000000000000L) == 0L) {
                        this.HigherKindsFeature = DefinitionsClass.this.getLanguageFeature("higherKinds", DefinitionsClass.this.getLanguageFeature$default$2());
                        this.bitmap$0 |= 0x400000000000000L;
                    }
                }
                return this.HigherKindsFeature;
            }

            public Symbols.Symbol HigherKindsFeature() {
                if ((this.bitmap$0 & 0x400000000000000L) == 0L) {
                    return this.HigherKindsFeature$lzycompute();
                }
                return this.HigherKindsFeature;
            }

            private Symbols.Symbol ExistentialsFeature$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x800000000000000L) == 0L) {
                        this.ExistentialsFeature = DefinitionsClass.this.getLanguageFeature("existentials", DefinitionsClass.this.getLanguageFeature$default$2());
                        this.bitmap$0 |= 0x800000000000000L;
                    }
                }
                return this.ExistentialsFeature;
            }

            public Symbols.Symbol ExistentialsFeature() {
                if ((this.bitmap$0 & 0x800000000000000L) == 0L) {
                    return this.ExistentialsFeature$lzycompute();
                }
                return this.ExistentialsFeature;
            }

            private Symbols.Symbol ApiUniverseReify$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x1000000000000000L) == 0L) {
                        Symbols.Symbol symbol;
                        Symbols.Symbol symbol2 = DefinitionsClass.this.ApiUniverseClass();
                        if (symbol2 == null) {
                            throw null;
                        }
                        Symbols.Symbol map_this = symbol2;
                        if (map_this == map_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                            symbol = map_this;
                        } else {
                            Symbols.Symbol symbol3 = map_this;
                            symbol = DefinitionsClass.this.getDeclIfDefined(symbol3, DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().nme().reify());
                        }
                        this.ApiUniverseReify = symbol;
                        this.bitmap$0 |= 0x1000000000000000L;
                    }
                }
                return this.ApiUniverseReify;
            }

            public Symbols.Symbol ApiUniverseReify() {
                if ((this.bitmap$0 & 0x1000000000000000L) == 0L) {
                    return this.ApiUniverseReify$lzycompute();
                }
                return this.ApiUniverseReify;
            }

            private Symbols.Symbol ReflectRuntimeUniverse$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x2000000000000000L) == 0L) {
                        this.ReflectRuntimeUniverse = DefinitionsClass.this.ReflectRuntimeUniverse();
                        this.bitmap$0 |= 0x2000000000000000L;
                    }
                }
                return this.ReflectRuntimeUniverse;
            }

            public Symbols.Symbol ReflectRuntimeUniverse() {
                if ((this.bitmap$0 & 0x2000000000000000L) == 0L) {
                    return this.ReflectRuntimeUniverse$lzycompute();
                }
                return this.ReflectRuntimeUniverse;
            }

            private Symbols.Symbol ReflectRuntimeCurrentMirror$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x4000000000000000L) == 0L) {
                        this.ReflectRuntimeCurrentMirror = DefinitionsClass.this.ReflectRuntimeCurrentMirror();
                        this.bitmap$0 |= 0x4000000000000000L;
                    }
                }
                return this.ReflectRuntimeCurrentMirror;
            }

            public Symbols.Symbol ReflectRuntimeCurrentMirror() {
                if ((this.bitmap$0 & 0x4000000000000000L) == 0L) {
                    return this.ReflectRuntimeCurrentMirror$lzycompute();
                }
                return this.ReflectRuntimeCurrentMirror;
            }

            private Symbols.Symbol TreesTreeType$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & Long.MIN_VALUE) == 0L) {
                        Symbols.Symbol symbol;
                        Symbols.Symbol symbol2 = DefinitionsClass.this.TreesClass();
                        if (symbol2 == null) {
                            throw null;
                        }
                        Symbols.Symbol map_this = symbol2;
                        if (map_this == map_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                            symbol = map_this;
                        } else {
                            Symbols.Symbol symbol3 = map_this;
                            symbol = DefinitionsClass.this.getTypeMember(symbol3, DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().Tree());
                        }
                        this.TreesTreeType = symbol;
                        this.bitmap$0 |= Long.MIN_VALUE;
                    }
                }
                return this.TreesTreeType;
            }

            public Symbols.Symbol TreesTreeType() {
                if ((this.bitmap$0 & Long.MIN_VALUE) == 0L) {
                    return this.TreesTreeType$lzycompute();
                }
                return this.TreesTreeType;
            }

            private Symbols.TypeSymbol PartialManifestClass$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$1 & 1L) == 0L) {
                        this.PartialManifestClass = DefinitionsClass.this.getTypeMember(DefinitionsClass.this.ReflectPackage(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().ClassManifest());
                        this.bitmap$1 |= 1L;
                    }
                }
                return this.PartialManifestClass;
            }

            public Symbols.TypeSymbol PartialManifestClass() {
                if ((this.bitmap$1 & 1L) == 0L) {
                    return this.PartialManifestClass$lzycompute();
                }
                return this.PartialManifestClass;
            }

            private Set<Symbols.Symbol> ManifestSymbols$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$1 & 2L) == 0L) {
                        this.ManifestSymbols = (Set)Predef$.MODULE$.Set().apply(Predef$.MODULE$.wrapRefArray((Object[])new Symbols.Symbol[]{this.PartialManifestClass(), DefinitionsClass.this.FullManifestClass(), DefinitionsClass.this.OptManifestClass()}));
                        this.bitmap$1 |= 2L;
                    }
                }
                return this.ManifestSymbols;
            }

            public Set<Symbols.Symbol> ManifestSymbols() {
                if ((this.bitmap$1 & 2L) == 0L) {
                    return this.ManifestSymbols$lzycompute();
                }
                return this.ManifestSymbols;
            }

            private Symbols.Symbol PolymorphicSignatureClass$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$1 & 4L) == 0L) {
                        this.PolymorphicSignatureClass = DefinitionsClass.this.MethodHandleClass().companionModule().info().decl(DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().TypeName().apply("PolymorphicSignature"));
                        this.bitmap$1 |= 4L;
                    }
                }
                return this.PolymorphicSignatureClass;
            }

            private Symbols.Symbol PolymorphicSignatureClass() {
                if ((this.bitmap$1 & 4L) == 0L) {
                    return this.PolymorphicSignatureClass$lzycompute();
                }
                return this.PolymorphicSignatureClass;
            }

            private Names.TypeName PolymorphicSignatureName() {
                return this.PolymorphicSignatureName;
            }

            /*
             * WARNING - void declaration
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public boolean isPolymorphicSignature(Symbols.Symbol sym) {
                Symbols.Symbol owner;
                if (sym == null) return false;
                if (!sym.isJavaDefined()) return false;
                Symbols.Symbol symbol = owner = sym.safeOwner();
                Symbols.Symbol symbol2 = DefinitionsClass.this.MethodHandleClass();
                if (symbol == null ? symbol2 != null : !symbol.equals(symbol2)) {
                    Symbols.Symbol symbol3 = owner;
                    Symbols.Symbol symbol4 = DefinitionsClass.this.VarHandleClass();
                    if (symbol3 == null) {
                        if (symbol4 != null) {
                            return false;
                        }
                    } else if (!symbol3.equals(symbol4)) return false;
                }
                if (this.PolymorphicSignatureClass() == DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol()) {
                    void var5_6;
                    List<AnnotationInfos.AnnotationInfo> list = sym.annotations();
                    if (list == null) {
                        throw null;
                    }
                    List<AnnotationInfos.AnnotationInfo> list2 = list;
                    while (!var5_6.isEmpty()) {
                        AnnotationInfos.AnnotationInfo annotationInfo = (AnnotationInfos.AnnotationInfo)var5_6.head();
                        if (RunDefinitions.$anonfun$isPolymorphicSignature$1(this, annotationInfo)) {
                            return true;
                        }
                        LinearSeqOptimized linearSeqOptimized = (LinearSeqOptimized)var5_6.tail();
                    }
                    return false;
                }
                boolean bl = sym.hasAnnotation(this.PolymorphicSignatureClass());
                if (!bl) return false;
                return true;
            }

            private Symbols.Symbol Scala_Java8_CompatPackage$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$1 & 8L) == 0L) {
                        this.Scala_Java8_CompatPackage = ((Mirrors.RootsBase)DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getPackageIfDefined("scala.runtime.java8");
                        this.bitmap$1 |= 8L;
                    }
                }
                return this.Scala_Java8_CompatPackage;
            }

            public Symbols.Symbol Scala_Java8_CompatPackage() {
                if ((this.bitmap$1 & 8L) == 0L) {
                    return this.Scala_Java8_CompatPackage$lzycompute();
                }
                return this.Scala_Java8_CompatPackage;
            }

            private Symbols.Symbol Future_unit$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$1 & 0x10L) == 0L) {
                        this.Future_unit = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.FutureClass().companionModule(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().TermName().apply("unit"));
                        this.bitmap$1 |= 0x10L;
                    }
                }
                return this.Future_unit;
            }

            public Symbols.Symbol Future_unit() {
                if ((this.bitmap$1 & 0x10L) == 0L) {
                    return this.Future_unit$lzycompute();
                }
                return this.Future_unit;
            }

            private Symbols.Symbol Future_onComplete$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$1 & 0x20L) == 0L) {
                        this.Future_onComplete = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.FutureClass(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().TermName().apply("onComplete"));
                        this.bitmap$1 |= 0x20L;
                    }
                }
                return this.Future_onComplete;
            }

            public Symbols.Symbol Future_onComplete() {
                if ((this.bitmap$1 & 0x20L) == 0L) {
                    return this.Future_onComplete$lzycompute();
                }
                return this.Future_onComplete;
            }

            private Symbols.Symbol Future_value$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$1 & 0x40L) == 0L) {
                        this.Future_value = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.FutureClass(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().TermName().apply("value"));
                        this.bitmap$1 |= 0x40L;
                    }
                }
                return this.Future_value;
            }

            public Symbols.Symbol Future_value() {
                if ((this.bitmap$1 & 0x40L) == 0L) {
                    return this.Future_value$lzycompute();
                }
                return this.Future_value;
            }

            private Symbols.Symbol Promise_complete$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$1 & 0x80L) == 0L) {
                        this.Promise_complete = DefinitionsClass.this.getMemberMethod(DefinitionsClass.this.PromiseClass(), DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().TermName().apply("complete"));
                        this.bitmap$1 |= 0x80L;
                    }
                }
                return this.Promise_complete;
            }

            public Symbols.Symbol Promise_complete() {
                if ((this.bitmap$1 & 0x80L) == 0L) {
                    return this.Promise_complete$lzycompute();
                }
                return this.Promise_complete;
            }

            public /* synthetic */ DefinitionsClass scala$reflect$internal$Definitions$DefinitionsClass$RunDefinitions$$$outer() {
                return DefinitionsClass.this;
            }

            private final void TreeType$lzycompute$1() {
                synchronized (this) {
                    if (this.TreeType$module == null) {
                        this.TreeType$module = new Definitions$DefinitionsClass$RunDefinitions$TreeType$(this);
                    }
                    return;
                }
            }

            private final void SubtreeType$lzycompute$1() {
                synchronized (this) {
                    if (this.SubtreeType$module == null) {
                        this.SubtreeType$module = new Definitions$DefinitionsClass$RunDefinitions$SubtreeType$(this);
                    }
                    return;
                }
            }

            private final void ExprClassOf$lzycompute$1() {
                synchronized (this) {
                    if (this.ExprClassOf$module == null) {
                        this.ExprClassOf$module = new Definitions$DefinitionsClass$RunDefinitions$ExprClassOf$(this);
                    }
                    return;
                }
            }

            public static final /* synthetic */ boolean $anonfun$String_valueOf_Int$1(RunDefinitions $this, Symbols.Symbol x) {
                if (((LinearSeqOptimized)x.paramss().head()).length() == 1) {
                    Symbols.Symbol symbol = x.firstParam().info().typeSymbol();
                    Symbols.ClassSymbol classSymbol = $this.DefinitionsClass.this.IntClass();
                    if (!(symbol != null ? !symbol.equals(classSymbol) : classSymbol != null)) {
                        return true;
                    }
                }
                return false;
            }

            public static final /* synthetic */ boolean $anonfun$isPolymorphicSignature$1(RunDefinitions $this, AnnotationInfos.AnnotationInfo x$51) {
                Names.Name name = x$51.atp().typeSymbolDirect().name();
                Names.TypeName typeName = $this.PolymorphicSignatureName();
                return !(name != null ? !name.equals(typeName) : typeName != null);
            }

            public RunDefinitions() {
                if (DefinitionsClass.this == null) {
                    throw null;
                }
                this.PolymorphicSignatureName = DefinitionsClass.this.scala$reflect$internal$Definitions$DefinitionsClass$$$outer().TypeName().apply("java.lang.invoke.MethodHandle$PolymorphicSignature");
            }

            public static final /* synthetic */ Object $anonfun$isPolymorphicSignature$1$adapted(RunDefinitions $this, AnnotationInfos.AnnotationInfo x$51) {
                return BoxesRunTime.boxToBoolean(RunDefinitions.$anonfun$isPolymorphicSignature$1($this, x$51));
            }
        }

        public class UniverseDependentTypes {
            private Types.Type nameType;
            private Types.Type modsType;
            private Types.Type flagsType;
            private Types.Type symbolType;
            private Types.Type treeType;
            private Types.Type caseDefType;
            private Types.Type liftableType;
            private Types.Type unliftableType;
            private Types.Type iterableTreeType;
            private Types.Type listTreeType;
            private Types.Type listListTreeType;
            private final Trees.Tree universe;
            private volatile int bitmap$0;
            public final /* synthetic */ DefinitionsClass $outer;

            private Types.Type nameType$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 1) == 0) {
                        this.nameType = this.universeMemberType(this.scala$reflect$internal$Definitions$DefinitionsClass$UniverseDependentTypes$$$outer().scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().Name());
                        this.bitmap$0 |= 1;
                    }
                }
                return this.nameType;
            }

            public Types.Type nameType() {
                if ((this.bitmap$0 & 1) == 0) {
                    return this.nameType$lzycompute();
                }
                return this.nameType;
            }

            private Types.Type modsType$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 2) == 0) {
                        this.modsType = this.universeMemberType(this.scala$reflect$internal$Definitions$DefinitionsClass$UniverseDependentTypes$$$outer().scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().Modifiers());
                        this.bitmap$0 |= 2;
                    }
                }
                return this.modsType;
            }

            public Types.Type modsType() {
                if ((this.bitmap$0 & 2) == 0) {
                    return this.modsType$lzycompute();
                }
                return this.modsType;
            }

            private Types.Type flagsType$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 4) == 0) {
                        this.flagsType = this.universeMemberType(this.scala$reflect$internal$Definitions$DefinitionsClass$UniverseDependentTypes$$$outer().scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().FlagSet());
                        this.bitmap$0 |= 4;
                    }
                }
                return this.flagsType;
            }

            public Types.Type flagsType() {
                if ((this.bitmap$0 & 4) == 0) {
                    return this.flagsType$lzycompute();
                }
                return this.flagsType;
            }

            private Types.Type symbolType$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 8) == 0) {
                        this.symbolType = this.universeMemberType((Names.TypeName)this.scala$reflect$internal$Definitions$DefinitionsClass$UniverseDependentTypes$$$outer().scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().Symbol());
                        this.bitmap$0 |= 8;
                    }
                }
                return this.symbolType;
            }

            public Types.Type symbolType() {
                if ((this.bitmap$0 & 8) == 0) {
                    return this.symbolType$lzycompute();
                }
                return this.symbolType;
            }

            private Types.Type treeType$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x10) == 0) {
                        this.treeType = this.universeMemberType(this.scala$reflect$internal$Definitions$DefinitionsClass$UniverseDependentTypes$$$outer().scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().Tree());
                        this.bitmap$0 |= 0x10;
                    }
                }
                return this.treeType;
            }

            public Types.Type treeType() {
                if ((this.bitmap$0 & 0x10) == 0) {
                    return this.treeType$lzycompute();
                }
                return this.treeType;
            }

            private Types.Type caseDefType$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x20) == 0) {
                        this.caseDefType = this.universeMemberType(this.scala$reflect$internal$Definitions$DefinitionsClass$UniverseDependentTypes$$$outer().scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().CaseDef());
                        this.bitmap$0 |= 0x20;
                    }
                }
                return this.caseDefType;
            }

            public Types.Type caseDefType() {
                if ((this.bitmap$0 & 0x20) == 0) {
                    return this.caseDefType$lzycompute();
                }
                return this.caseDefType;
            }

            private Types.Type liftableType$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x40) == 0) {
                        this.liftableType = this.universeMemberType(this.scala$reflect$internal$Definitions$DefinitionsClass$UniverseDependentTypes$$$outer().scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().Liftable());
                        this.bitmap$0 |= 0x40;
                    }
                }
                return this.liftableType;
            }

            public Types.Type liftableType() {
                if ((this.bitmap$0 & 0x40) == 0) {
                    return this.liftableType$lzycompute();
                }
                return this.liftableType;
            }

            private Types.Type unliftableType$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x80) == 0) {
                        this.unliftableType = this.universeMemberType(this.scala$reflect$internal$Definitions$DefinitionsClass$UniverseDependentTypes$$$outer().scala$reflect$internal$Definitions$DefinitionsClass$$$outer().tpnme().Unliftable());
                        this.bitmap$0 |= 0x80;
                    }
                }
                return this.unliftableType;
            }

            public Types.Type unliftableType() {
                if ((this.bitmap$0 & 0x80) == 0) {
                    return this.unliftableType$lzycompute();
                }
                return this.unliftableType;
            }

            private Types.Type iterableTreeType$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x100) == 0) {
                        this.iterableTreeType = this.scala$reflect$internal$Definitions$DefinitionsClass$UniverseDependentTypes$$$outer().scala$reflect$internal$Definitions$DefinitionsClass$$$outer().appliedType((Symbols.Symbol)this.scala$reflect$internal$Definitions$DefinitionsClass$UniverseDependentTypes$$$outer().IterableClass(), Predef$.MODULE$.wrapRefArray((Object[])new Types.Type[]{this.treeType()}));
                        this.bitmap$0 |= 0x100;
                    }
                }
                return this.iterableTreeType;
            }

            public Types.Type iterableTreeType() {
                if ((this.bitmap$0 & 0x100) == 0) {
                    return this.iterableTreeType$lzycompute();
                }
                return this.iterableTreeType;
            }

            private Types.Type listTreeType$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x200) == 0) {
                        this.listTreeType = this.scala$reflect$internal$Definitions$DefinitionsClass$UniverseDependentTypes$$$outer().scala$reflect$internal$Definitions$DefinitionsClass$$$outer().appliedType((Symbols.Symbol)this.scala$reflect$internal$Definitions$DefinitionsClass$UniverseDependentTypes$$$outer().ListClass(), Predef$.MODULE$.wrapRefArray((Object[])new Types.Type[]{this.treeType()}));
                        this.bitmap$0 |= 0x200;
                    }
                }
                return this.listTreeType;
            }

            public Types.Type listTreeType() {
                if ((this.bitmap$0 & 0x200) == 0) {
                    return this.listTreeType$lzycompute();
                }
                return this.listTreeType;
            }

            private Types.Type listListTreeType$lzycompute() {
                synchronized (this) {
                    if ((this.bitmap$0 & 0x400) == 0) {
                        this.listListTreeType = this.scala$reflect$internal$Definitions$DefinitionsClass$UniverseDependentTypes$$$outer().scala$reflect$internal$Definitions$DefinitionsClass$$$outer().appliedType((Symbols.Symbol)this.scala$reflect$internal$Definitions$DefinitionsClass$UniverseDependentTypes$$$outer().ListClass(), Predef$.MODULE$.wrapRefArray((Object[])new Types.Type[]{this.listTreeType()}));
                        this.bitmap$0 |= 0x400;
                    }
                }
                return this.listListTreeType;
            }

            public Types.Type listListTreeType() {
                if ((this.bitmap$0 & 0x400) == 0) {
                    return this.listListTreeType$lzycompute();
                }
                return this.listListTreeType;
            }

            public Types.Type universeMemberType(Names.TypeName name) {
                return this.universe.tpe().memberType(this.scala$reflect$internal$Definitions$DefinitionsClass$UniverseDependentTypes$$$outer().getTypeMember(this.universe.symbol(), name));
            }

            public /* synthetic */ DefinitionsClass scala$reflect$internal$Definitions$DefinitionsClass$UniverseDependentTypes$$$outer() {
                return this.$outer;
            }

            public UniverseDependentTypes(DefinitionsClass $outer, Trees.Tree universe) {
                this.universe = universe;
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }
        }

        public class VarArityClass
        extends StandardDefinitions.DefinitionsApi.VarArityClassApi {
            private final String name;
            private final int offset;
            private final IndexedSeq<Symbols.ClassSymbol> seq;
            private final ValueClassDefinitions.SymbolSet symSet;

            private int offset() {
                return this.offset;
            }

            private boolean isDefinedAt(int i) {
                return i < this.seq().length() + this.offset() && i >= this.offset();
            }

            public IndexedSeq<Symbols.ClassSymbol> seq() {
                return this.seq;
            }

            private ValueClassDefinitions.SymbolSet symSet() {
                return this.symSet;
            }

            public boolean contains(Symbols.Symbol sym) {
                return this.symSet().contains(sym);
            }

            @Override
            public Symbols.Symbol apply(int i) {
                if (this.isDefinedAt(i)) {
                    return (Symbols.Symbol)this.seq().apply(i - this.offset());
                }
                return this.scala$reflect$internal$Definitions$DefinitionsClass$VarArityClass$$$outer().scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoSymbol();
            }

            public Types.Type specificType(List<Types.Type> args2, List<Types.Type> others) {
                int arity = args2.length();
                if (!this.isDefinedAt(arity)) {
                    return this.scala$reflect$internal$Definitions$DefinitionsClass$VarArityClass$$$outer().scala$reflect$internal$Definitions$DefinitionsClass$$$outer().NoType();
                }
                return this.scala$reflect$internal$Definitions$DefinitionsClass$VarArityClass$$$outer().scala$reflect$internal$Definitions$DefinitionsClass$$$outer().appliedType(this.apply(arity), others.$colon$colon$colon(args2));
            }

            public List<Types.Type> specificType$default$2() {
                return Nil$.MODULE$;
            }

            public /* synthetic */ DefinitionsClass scala$reflect$internal$Definitions$DefinitionsClass$VarArityClass$$$outer() {
                return (DefinitionsClass)this.$outer;
            }

            public static final /* synthetic */ Symbols.ClassSymbol $anonfun$seq$1(VarArityClass $this, int i) {
                return ((Mirrors.RootsBase)$this.scala$reflect$internal$Definitions$DefinitionsClass$VarArityClass$$$outer().scala$reflect$internal$Definitions$DefinitionsClass$$$outer().rootMirror()).getRequiredClass(new StringBuilder(6).append("scala.").append($this.name).append(i).toString());
            }

            /*
             * WARNING - void declaration
             */
            public VarArityClass(DefinitionsClass $outer, String name, int maxArity, int countFrom, Option<Symbols.ClassSymbol> init) {
                void map_bf;
                void map_f;
                this.name = name;
                this.offset = countFrom - Option$.MODULE$.option2Iterable(init).size();
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                Range.Inclusive inclusive = RichInt$.MODULE$.to$extension0(countFrom, maxArity);
                CanBuildFrom canBuildFrom = IndexedSeq$.MODULE$.canBuildFrom();
                Function1<Object, Symbols.ClassSymbol> & java.io.Serializable & Serializable intersect = (Function1<Object, Symbols.ClassSymbol> & java.io.Serializable & Serializable)i -> VarArityClass.$anonfun$seq$1(this, BoxesRunTime.unboxToInt(i));
                if (inclusive == null) {
                    throw null;
                }
                this.seq = ((TraversableOnce)((TraversableLike)TraversableLike.map$(inclusive, (Function1)map_f, (CanBuildFrom)map_bf)).$plus$plus$colon(Option$.MODULE$.option2Iterable(init), IndexedSeq$.MODULE$.canBuildFrom())).toVector();
                this.symSet = new ValueClassDefinitions.SymbolSet($outer, this.seq().toList());
            }
        }
    }

    public interface ValueClassDefinitions {
        public void scala$reflect$internal$Definitions$ValueClassDefinitions$_setter_$scala$reflect$internal$Definitions$ValueClassDefinitions$$nameToWeight_$eq(scala.collection.immutable.Map<Names.Name, Object> var1);

        public void scala$reflect$internal$Definitions$ValueClassDefinitions$_setter_$scala$reflect$internal$Definitions$ValueClassDefinitions$$nameToTag_$eq(scala.collection.immutable.Map<Names.Name, Object> var1);

        public scala.collection.immutable.Map<Names.Name, Object> scala$reflect$internal$Definitions$ValueClassDefinitions$$nameToWeight();

        public scala.collection.immutable.Map<Names.Name, Object> scala$reflect$internal$Definitions$ValueClassDefinitions$$nameToTag();

        default public Nothing$ scala$reflect$internal$Definitions$$catastrophicFailure() {
            return ((Reporting)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).abort(new StringBuilder(69).append("Could not find value classes! This is a catastrophic failure.  scala ").append(Properties$.MODULE$.versionString()).toString());
        }

        private Symbols.ClassSymbol valueClassSymbol(Names.TypeName name) {
            Symbols.Symbol symbol = ((DefinitionsClass)this).getMember(((DefinitionsClass)this).ScalaPackageClass(), name);
            if (!(symbol instanceof Symbols.ClassSymbol)) {
                throw this.scala$reflect$internal$Definitions$$catastrophicFailure();
            }
            Symbols.ClassSymbol classSymbol = (Symbols.ClassSymbol)symbol;
            return classSymbol;
        }

        /*
         * WARNING - void declaration
         */
        default public <T> scala.collection.immutable.Map<Symbols.Symbol, T> scala$reflect$internal$Definitions$$classesMap(Function1<Names.Name, T> f) {
            void symbolsMap_mapFrom_f;
            List<Symbols.ClassSymbol> symbolsMap_syms = this.ScalaValueClassesNoUnit();
            Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable intersect = (Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x -> f.apply(x.name());
            if ((Collections)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer()) == null) {
                throw null;
            }
            return (scala.collection.immutable.Map)Predef$.MODULE$.Map().apply(symbolsMap_syms.map(arg_0 -> Collections.$anonfun$mapFrom$1((Function1)symbolsMap_mapFrom_f, arg_0), List$.MODULE$.canBuildFrom()));
        }

        /*
         * WARNING - void declaration
         */
        private <T> scala.collection.immutable.Map<Symbols.Symbol, T> symbolsMap(List<Symbols.Symbol> syms, Function1<Names.Name, T> f) {
            void mapFrom_f;
            Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable intersect = (Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x -> f.apply(x.name());
            if ((Collections)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer()) == null) {
                throw null;
            }
            return (scala.collection.immutable.Map)Predef$.MODULE$.Map().apply(syms.map(arg_0 -> Collections.$anonfun$mapFrom$1((Function1)mapFrom_f, arg_0), List$.MODULE$.canBuildFrom()));
        }

        /*
         * WARNING - void declaration
         */
        private <T> scala.collection.immutable.Map<Symbols.Symbol, T> symbolsMapFilt(List<Symbols.Symbol> syms, Function1<Names.Name, Object> p, Function1<Names.Name, T> f) {
            void symbolsMap_mapFrom_f;
            List symbolsMap_syms = (List)syms.filter((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x -> BoxesRunTime.boxToBoolean(BoxesRunTime.unboxToBoolean(p.apply(x.name()))));
            Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable intersect = (Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x -> f.apply(x.name());
            if ((Collections)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer()) == null) {
                throw null;
            }
            return (scala.collection.immutable.Map)Predef$.MODULE$.Map().apply(symbolsMap_syms.map(arg_0 -> Collections.$anonfun$mapFrom$1((Function1)symbolsMap_mapFrom_f, arg_0), List$.MODULE$.canBuildFrom()));
        }

        private String boxedName(Names.Name name) {
            return (String)((StdNames)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).sn().Boxed().apply(name.toTypeName());
        }

        default public scala.collection.immutable.Map<Symbols.Symbol, Object> abbrvTag() {
            return this.symbolsMap(this.ScalaValueClasses(), this.scala$reflect$internal$Definitions$ValueClassDefinitions$$nameToTag()).withDefaultValue(BoxesRunTime.boxToCharacter('L'));
        }

        default public scala.collection.immutable.Map<Symbols.Symbol, Object> numericWeight() {
            return this.symbolsMapFilt(this.ScalaValueClasses(), this.scala$reflect$internal$Definitions$ValueClassDefinitions$$nameToWeight().keySet(), this.scala$reflect$internal$Definitions$ValueClassDefinitions$$nameToWeight());
        }

        default public scala.collection.immutable.Map<Symbols.Symbol, Symbols.ModuleSymbol> boxedModule() {
            return this.scala$reflect$internal$Definitions$$classesMap((Function1<Names.Name, Symbols.ModuleSymbol> & java.io.Serializable & Serializable)x -> ((Mirrors.RootsBase)((Mirrors)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).rootMirror()).getModuleByName(this.boxedName((Names.Name)x)));
        }

        default public scala.collection.immutable.Map<Symbols.Symbol, Symbols.ClassSymbol> boxedClass() {
            return this.scala$reflect$internal$Definitions$$classesMap((Function1<Names.Name, Symbols.ClassSymbol> & java.io.Serializable & Serializable)x -> ((Mirrors.RootsBase)((Mirrors)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).rootMirror()).getClassByName(this.boxedName((Names.Name)x)));
        }

        default public scala.collection.immutable.Map<Symbols.Symbol, Symbols.ClassSymbol> refClass() {
            return this.scala$reflect$internal$Definitions$$classesMap((Function1<Names.Name, Symbols.ClassSymbol> & java.io.Serializable & Serializable)x -> ((Mirrors.RootsBase)((Mirrors)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).rootMirror()).getRequiredClass(new StringBuilder(17).append("scala.runtime.").append((CharSequence)x).append("Ref").toString()));
        }

        default public scala.collection.immutable.Map<Symbols.Symbol, Symbols.ClassSymbol> volatileRefClass() {
            return this.scala$reflect$internal$Definitions$$classesMap((Function1<Names.Name, Symbols.ClassSymbol> & java.io.Serializable & Serializable)x -> ((Mirrors.RootsBase)((Mirrors)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).rootMirror()).getRequiredClass(new StringBuilder(25).append("scala.runtime.Volatile").append((CharSequence)x).append("Ref").toString()));
        }

        /*
         * WARNING - void declaration
         */
        default public scala.collection.immutable.Map<Symbols.Symbol, Symbols.Symbol> lazyHolders() {
            void symbolsMap_mapFrom_f;
            Function1<Names.Name, Symbols.Symbol> & java.io.Serializable & Serializable symbolsMap_f = (Function1<Names.Name, Symbols.Symbol> & java.io.Serializable & Serializable)x -> ((Mirrors.RootsBase)((Mirrors)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).rootMirror()).getClassIfDefined(new StringBuilder(18).append("scala.runtime.Lazy").append((CharSequence)x).toString());
            List<Symbols.ClassSymbol> symbolsMap_syms = this.ScalaValueClasses();
            Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable intersect = (Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x -> f.apply(x.name());
            if ((Collections)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer()) == null) {
                throw null;
            }
            return (scala.collection.immutable.Map)Predef$.MODULE$.Map().apply(symbolsMap_syms.map(arg_0 -> Collections.$anonfun$mapFrom$1((Function1)symbolsMap_mapFrom_f, arg_0), List$.MODULE$.canBuildFrom()));
        }

        default public Symbols.Symbol LazyRefClass() {
            return ((Mirrors.RootsBase)((Mirrors)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).rootMirror()).getClassIfDefined("scala.runtime.LazyRef");
        }

        default public Symbols.Symbol LazyUnitClass() {
            return ((Mirrors.RootsBase)((Mirrors)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).rootMirror()).getClassIfDefined("scala.runtime.LazyUnit");
        }

        default public Set<Symbols.Symbol> allRefClasses() {
            return this.refClass().values().toSet().$plus$plus(this.volatileRefClass().values().toSet()).$plus$plus(Predef$.MODULE$.Set().apply(Predef$.MODULE$.wrapRefArray((Object[])new Symbols.ClassSymbol[]{((DefinitionsClass)this).VolatileObjectRefClass(), ((DefinitionsClass)this).ObjectRefClass()})), Set$.MODULE$.canBuildFrom());
        }

        default public boolean isNumericSubClass(Symbols.Symbol sub, Symbols.Symbol sup) {
            return this.numericWeight().contains(sub) && this.numericWeight().contains(sup) && BoxesRunTime.unboxToInt(this.numericWeight().apply(sup)) % BoxesRunTime.unboxToInt(this.numericWeight().apply(sub)) == 0;
        }

        default public boolean isNumericValueClass(Symbols.Symbol sym) {
            return this.ScalaNumericValueClassesSet().contains(sym);
        }

        default public boolean isGetClass(Symbols.Symbol sym) {
            Names.Name name = sym.name();
            Names.TermName termName = ((StdNames)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).nme().getClass_();
            return !(name != null ? !name.equals(termName) : termName != null) && ((DefinitionsClass)this).getClassMethods().apply(sym);
        }

        default public Symbols.ClassSymbol UnitClass() {
            return this.valueClassSymbol((Names.TypeName)((StdNames)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Unit());
        }

        default public Symbols.ClassSymbol ByteClass() {
            return this.valueClassSymbol((Names.TypeName)((StdNames)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Byte());
        }

        default public Symbols.ClassSymbol ShortClass() {
            return this.valueClassSymbol((Names.TypeName)((StdNames)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Short());
        }

        default public Symbols.ClassSymbol CharClass() {
            return this.valueClassSymbol((Names.TypeName)((StdNames)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Char());
        }

        default public Symbols.ClassSymbol IntClass() {
            return this.valueClassSymbol((Names.TypeName)((StdNames)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Int());
        }

        default public Symbols.ClassSymbol LongClass() {
            return this.valueClassSymbol((Names.TypeName)((StdNames)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Long());
        }

        default public Symbols.ClassSymbol FloatClass() {
            return this.valueClassSymbol((Names.TypeName)((StdNames)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Float());
        }

        default public Symbols.ClassSymbol DoubleClass() {
            return this.valueClassSymbol((Names.TypeName)((StdNames)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Double());
        }

        default public Symbols.ClassSymbol BooleanClass() {
            return this.valueClassSymbol((Names.TypeName)((StdNames)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Boolean());
        }

        default public Symbols.TermSymbol Boolean_and() {
            return ((DefinitionsClass)this).getMemberMethod(this.BooleanClass(), ((StdNames)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).nme().ZAND());
        }

        default public Symbols.TermSymbol Boolean_or() {
            return ((DefinitionsClass)this).getMemberMethod(this.BooleanClass(), ((StdNames)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).nme().ZOR());
        }

        default public Symbols.TermSymbol Boolean_not() {
            return ((DefinitionsClass)this).getMemberMethod(this.BooleanClass(), ((StdNames)((Object)this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).nme().UNARY_$bang());
        }

        default public Types.Type UnitTpe() {
            return this.UnitClass().tpe();
        }

        default public Types.Type ByteTpe() {
            return this.ByteClass().tpe();
        }

        default public Types.Type ShortTpe() {
            return this.ShortClass().tpe();
        }

        default public Types.Type CharTpe() {
            return this.CharClass().tpe();
        }

        default public Types.Type IntTpe() {
            return this.IntClass().tpe();
        }

        default public Types.Type LongTpe() {
            return this.LongClass().tpe();
        }

        default public Types.Type FloatTpe() {
            return this.FloatClass().tpe();
        }

        default public Types.Type DoubleTpe() {
            return this.DoubleClass().tpe();
        }

        default public Types.Type BooleanTpe() {
            return this.BooleanClass().tpe();
        }

        default public List<Symbols.ClassSymbol> ScalaNumericValueClasses() {
            return (List)this.ScalaValueClasses().filterNot((Function1)Predef$.MODULE$.Set().apply(Predef$.MODULE$.wrapRefArray((Object[])new Symbols.Symbol[]{this.UnitClass(), this.BooleanClass()})));
        }

        default public List<Symbols.ClassSymbol> ScalaValueClassesNoUnit() {
            return (List)this.ScalaValueClasses().filterNot((Function1<Symbols.ClassSymbol, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(ValueClassDefinitions.$anonfun$ScalaValueClassesNoUnit$1(this, x$1)));
        }

        default public List<Symbols.ClassSymbol> ScalaValueClasses() {
            return List$.MODULE$.apply(Predef$.MODULE$.wrapRefArray((Object[])new Symbols.ClassSymbol[]{this.UnitClass(), this.BooleanClass(), this.ByteClass(), this.ShortClass(), this.CharClass(), this.IntClass(), this.LongClass(), this.FloatClass(), this.DoubleClass()}));
        }

        default public SymbolSet ScalaValueClassesSet() {
            return new SymbolSet((DefinitionsClass)this, this.ScalaValueClasses());
        }

        default public SymbolSet ScalaNumericValueClassesSet() {
            return new SymbolSet((DefinitionsClass)this, this.ScalaNumericValueClasses());
        }

        default public List<Symbols.ClassSymbol> ScalaPrimitiveValueClasses() {
            return this.ScalaValueClasses();
        }

        default public Types.Type underlyingOfValueClass(Symbols.Symbol clazz) {
            return clazz.derivedValueClassUnbox().tpe().resultType();
        }

        public /* synthetic */ Definitions scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer();

        public static /* synthetic */ boolean $anonfun$symbolsMapFilt$1(Function1 p$1, Symbols.Symbol x) {
            return BoxesRunTime.unboxToBoolean(p$1.apply(x.name()));
        }

        public static /* synthetic */ boolean $anonfun$ScalaValueClassesNoUnit$1(ValueClassDefinitions $this, Symbols.ClassSymbol x$1) {
            return x$1 == $this.UnitClass();
        }

        /*
         * WARNING - void declaration
         */
        public static void $init$(ValueClassDefinitions $this) {
            void $minus$greater$extension_y;
            void $minus$greater$extension_$this;
            void $minus$greater$extension_y2;
            void $minus$greater$extension_$this2;
            void $minus$greater$extension_y3;
            void $minus$greater$extension_$this3;
            void $minus$greater$extension_y4;
            void $minus$greater$extension_$this4;
            void $minus$greater$extension_y5;
            void $minus$greater$extension_$this5;
            void $minus$greater$extension_y6;
            void $minus$greater$extension_$this6;
            void $minus$greater$extension_y7;
            void $minus$greater$extension_$this7;
            void $minus$greater$extension_y8;
            void $minus$greater$extension_$this8;
            void $minus$greater$extension_y9;
            void $minus$greater$extension_$this9;
            void $minus$greater$extension_y10;
            void $minus$greater$extension_$this10;
            void $minus$greater$extension_y11;
            void $minus$greater$extension_$this11;
            void $minus$greater$extension_y12;
            void $minus$greater$extension_$this12;
            void $minus$greater$extension_y13;
            void $minus$greater$extension_$this13;
            void $minus$greater$extension_y14;
            void $minus$greater$extension_$this14;
            void $minus$greater$extension_y15;
            void $minus$greater$extension_$this15;
            void $minus$greater$extension_y16;
            void $minus$greater$extension_$this16;
            Tuple2[] tuple2Array = new Tuple2[7];
            Integer n = BoxesRunTime.boxToInteger(2);
            Names.Name name = Predef$.MODULE$.ArrowAssoc(((StdNames)((Object)$this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Byte());
            if (Predef$ArrowAssoc$.MODULE$ == null) {
                throw null;
            }
            tuple2Array[0] = new Tuple2<void, void>($minus$greater$extension_$this16, $minus$greater$extension_y16);
            Integer n2 = BoxesRunTime.boxToInteger(3);
            Names.Name name2 = Predef$.MODULE$.ArrowAssoc(((StdNames)((Object)$this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Char());
            if (Predef$ArrowAssoc$.MODULE$ == null) {
                throw null;
            }
            tuple2Array[1] = new Tuple2<void, void>($minus$greater$extension_$this15, $minus$greater$extension_y15);
            Integer n3 = BoxesRunTime.boxToInteger(4);
            Names.Name name3 = Predef$.MODULE$.ArrowAssoc(((StdNames)((Object)$this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Short());
            if (Predef$ArrowAssoc$.MODULE$ == null) {
                throw null;
            }
            tuple2Array[2] = new Tuple2<void, void>($minus$greater$extension_$this14, $minus$greater$extension_y14);
            Integer n4 = BoxesRunTime.boxToInteger(12);
            Names.Name name4 = Predef$.MODULE$.ArrowAssoc(((StdNames)((Object)$this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Int());
            if (Predef$ArrowAssoc$.MODULE$ == null) {
                throw null;
            }
            tuple2Array[3] = new Tuple2<void, void>($minus$greater$extension_$this13, $minus$greater$extension_y13);
            Integer n5 = BoxesRunTime.boxToInteger(24);
            Names.Name name5 = Predef$.MODULE$.ArrowAssoc(((StdNames)((Object)$this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Long());
            if (Predef$ArrowAssoc$.MODULE$ == null) {
                throw null;
            }
            tuple2Array[4] = new Tuple2<void, void>($minus$greater$extension_$this12, $minus$greater$extension_y12);
            Integer n6 = BoxesRunTime.boxToInteger(48);
            Names.Name name6 = Predef$.MODULE$.ArrowAssoc(((StdNames)((Object)$this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Float());
            if (Predef$ArrowAssoc$.MODULE$ == null) {
                throw null;
            }
            tuple2Array[5] = new Tuple2<void, void>($minus$greater$extension_$this11, $minus$greater$extension_y11);
            Integer n7 = BoxesRunTime.boxToInteger(96);
            Names.Name name7 = Predef$.MODULE$.ArrowAssoc(((StdNames)((Object)$this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Double());
            if (Predef$ArrowAssoc$.MODULE$ == null) {
                throw null;
            }
            tuple2Array[6] = new Tuple2<void, void>($minus$greater$extension_$this10, $minus$greater$extension_y10);
            $this.scala$reflect$internal$Definitions$ValueClassDefinitions$_setter_$scala$reflect$internal$Definitions$ValueClassDefinitions$$nameToWeight_$eq((scala.collection.immutable.Map)Predef$.MODULE$.Map().apply(Predef$.MODULE$.wrapRefArray((Object[])tuple2Array)));
            Tuple2[] tuple2Array2 = new Tuple2[9];
            Character c = BoxesRunTime.boxToCharacter('B');
            Names.Name name8 = Predef$.MODULE$.ArrowAssoc(((StdNames)((Object)$this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Byte());
            if (Predef$ArrowAssoc$.MODULE$ == null) {
                throw null;
            }
            tuple2Array2[0] = new Tuple2<void, void>($minus$greater$extension_$this9, $minus$greater$extension_y9);
            Character c2 = BoxesRunTime.boxToCharacter('C');
            Names.Name name9 = Predef$.MODULE$.ArrowAssoc(((StdNames)((Object)$this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Char());
            if (Predef$ArrowAssoc$.MODULE$ == null) {
                throw null;
            }
            tuple2Array2[1] = new Tuple2<void, void>($minus$greater$extension_$this8, $minus$greater$extension_y8);
            Character c3 = BoxesRunTime.boxToCharacter('S');
            Names.Name name10 = Predef$.MODULE$.ArrowAssoc(((StdNames)((Object)$this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Short());
            if (Predef$ArrowAssoc$.MODULE$ == null) {
                throw null;
            }
            tuple2Array2[2] = new Tuple2<void, void>($minus$greater$extension_$this7, $minus$greater$extension_y7);
            Character c4 = BoxesRunTime.boxToCharacter('I');
            Names.Name name11 = Predef$.MODULE$.ArrowAssoc(((StdNames)((Object)$this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Int());
            if (Predef$ArrowAssoc$.MODULE$ == null) {
                throw null;
            }
            tuple2Array2[3] = new Tuple2<void, void>($minus$greater$extension_$this6, $minus$greater$extension_y6);
            Character c5 = BoxesRunTime.boxToCharacter('J');
            Names.Name name12 = Predef$.MODULE$.ArrowAssoc(((StdNames)((Object)$this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Long());
            if (Predef$ArrowAssoc$.MODULE$ == null) {
                throw null;
            }
            tuple2Array2[4] = new Tuple2<void, void>($minus$greater$extension_$this5, $minus$greater$extension_y5);
            Character c6 = BoxesRunTime.boxToCharacter('F');
            Names.Name name13 = Predef$.MODULE$.ArrowAssoc(((StdNames)((Object)$this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Float());
            if (Predef$ArrowAssoc$.MODULE$ == null) {
                throw null;
            }
            tuple2Array2[5] = new Tuple2<void, void>($minus$greater$extension_$this4, $minus$greater$extension_y4);
            Character c7 = BoxesRunTime.boxToCharacter('D');
            Names.Name name14 = Predef$.MODULE$.ArrowAssoc(((StdNames)((Object)$this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Double());
            if (Predef$ArrowAssoc$.MODULE$ == null) {
                throw null;
            }
            tuple2Array2[6] = new Tuple2<void, void>($minus$greater$extension_$this3, $minus$greater$extension_y3);
            Character c8 = BoxesRunTime.boxToCharacter('Z');
            Names.Name name15 = Predef$.MODULE$.ArrowAssoc(((StdNames)((Object)$this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Boolean());
            if (Predef$ArrowAssoc$.MODULE$ == null) {
                throw null;
            }
            tuple2Array2[7] = new Tuple2<void, void>($minus$greater$extension_$this2, $minus$greater$extension_y2);
            Character c9 = BoxesRunTime.boxToCharacter('V');
            Names.Name name16 = Predef$.MODULE$.ArrowAssoc(((StdNames)((Object)$this.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).tpnme().Unit());
            if (Predef$ArrowAssoc$.MODULE$ == null) {
                throw null;
            }
            tuple2Array2[8] = new Tuple2<void, void>($minus$greater$extension_$this, $minus$greater$extension_y);
            $this.scala$reflect$internal$Definitions$ValueClassDefinitions$_setter_$scala$reflect$internal$Definitions$ValueClassDefinitions$$nameToTag_$eq((scala.collection.immutable.Map)Predef$.MODULE$.Map().apply(Predef$.MODULE$.wrapRefArray((Object[])tuple2Array2)));
        }

        public final class SymbolSet {
            private final Symbols.Symbol[] ids;
            private final Symbols.Symbol commonOwner;

            public final boolean contains(Symbols.Symbol sym) {
                if (this.commonOwner != null && this.commonOwner != sym.rawowner()) {
                    return false;
                }
                Symbols.Symbol[] array = this.ids;
                for (int i = 0; i < array.length; ++i) {
                    if (array[i] != sym) continue;
                    return true;
                }
                return false;
            }

            public static final /* synthetic */ boolean $anonfun$commonOwner$1(Symbols.Symbol hhOwner$1, Symbols.Symbol x$2) {
                Symbols.Symbol symbol = x$2.rawowner();
                return !(symbol != null ? !symbol.equals(hhOwner$1) : hhOwner$1 != null);
            }

            public SymbolSet(DefinitionsClass $outer, List<Symbols.Symbol> syms) {
                Symbols.Symbol symbol;
                this.ids = (Symbols.Symbol[])syms.toArray(((Symbols)((Object)$outer.scala$reflect$internal$Definitions$ValueClassDefinitions$$$outer())).SymbolTag());
                if (syms.isEmpty()) {
                    symbol = null;
                } else {
                    Symbols.Symbol hhOwner = syms.head().rawowner();
                    symbol = ((LinearSeqOptimized)syms.tail()).forall((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(SymbolSet.$anonfun$commonOwner$1(hhOwner, x$2))) ? hhOwner : null;
                }
                this.commonOwner = symbol;
            }
        }
    }
}

