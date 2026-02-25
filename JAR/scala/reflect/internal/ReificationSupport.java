/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Option$;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.ScalaReflectionException;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.Tuple4;
import scala.Tuple6;
import scala.collection.Iterable;
import scala.collection.LinearSeqOptimized;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ListBuffer;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Internals;
import scala.reflect.api.Liftables;
import scala.reflect.api.Trees;
import scala.reflect.internal.AnnotationInfos;
import scala.reflect.internal.Constants;
import scala.reflect.internal.Names;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$FilterCall$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$FlagsRepr$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$FunctionClassRef$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$ImplicitParams$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$MaybeSelectApply$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$MaybeTypeTreeOriginal$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$MaybeTyped$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$MaybeUnchecked$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$ScalaDot$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticAnnotatedType$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticApplied$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticAppliedType$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticAssign$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticBlock$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticClassDef$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticCompoundType$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticDefDef$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticEmptyTypeTree$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticExistentialType$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticFilter$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticFor$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticForYield$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticFunction$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticFunctionType$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticImport$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticMatch$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticNew$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticObjectDef$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticPackageObjectDef$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticPartialFunction$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticPatDef$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticSelectTerm$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticSelectType$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticSingletonType$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticTermIdent$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticTraitDef$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticTry$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticTuple$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticTupleType$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticTypeApplied$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticTypeIdent$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticTypeProjection$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticValDef$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticValEq$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticValFrom$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntacticVarDef$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$SyntheticUnit$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$TupleClassRef$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$TupleCompanionRef$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$UnCheckIfRefutable$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$UnClosure$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$UnCtor$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$UnFilter$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$UnFlatMap$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$UnFor$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$UnForeach$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$UnMap$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$UnMkTemplate$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$UnPatSeq$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$UnPatSeqWithRes$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$UnSyntheticParam$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$UnVisitor$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$UnitClassRef$;
import scala.reflect.internal.ReificationSupport$ReificationSupportImpl$implodePatDefs$;
import scala.reflect.internal.Scopes;
import scala.reflect.internal.StdAttachments$ForAttachment$;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Trees;
import scala.reflect.internal.Types;
import scala.reflect.internal.util.FreshNameCreator;
import scala.reflect.internal.util.Position;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.LambdaDeserialize;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001=Ub\u0001DB%\u0007\u0017\u0002\n1!\u0001\u0004Z=5\u0002bBB2\u0001\u0011\u00051Q\r\u0004\u0007\u0007[\u0002\u0001aa\u001c\t\u000f\r\u0005%\u0001\"\u0001\u0004\u0004\"91q\u0011\u0002\u0005\u0002\r%\u0005bBB]\u0005\u0011\u000511\u0018\u0005\b\u0007\u000f\u0014A\u0011CBe\u0011\u001d\u0019IN\u0001C\u0001\u00077Dqa!=\u0003\t\u0003\u0019\u0019\u0010C\u0005\u0005\u001c\t\t\n\u0011\"\u0001\u0005\u001e!IA1\u0007\u0002\u0012\u0002\u0013\u0005AQ\u0007\u0005\b\ts\u0011A\u0011\u0001C\u001e\u0011%!IEAI\u0001\n\u0003!i\u0002C\u0005\u0005L\t\t\n\u0011\"\u0001\u00056!9AQ\n\u0002\u0005\u0002\u0011=\u0003b\u0002C8\u0005\u0011\u0005A\u0011\u000f\u0005\b\t\u000f\u0013A\u0011\u0001CE\u0011\u001d!iL\u0001C\u0001\t\u007fCq\u0001b6\u0003\t\u0003!I\u000eC\u0004\u0005h\n!\t\u0001\";\t\u000f\u0011](\u0001\"\u0001\u0005z\"9Q1\u0001\u0002\u0005\u0002\u0015\u0015\u0001bBC\t\u0005\u0011\u0005Q1\u0003\u0005\b\u000b/\u0011A\u0011AC\r\u0011\u001d)\tC\u0001C\u0001\u000bGAq!\"\f\u0003\t\u0003)y\u0003C\u0004\u0006D\t!\t!\"\u0012\t\u000f\u0015E#\u0001\"\u0001\u0006T!9Qq\r\u0002\u0005\u0002\u0015%\u0004bBC<\u0005\u0011\u0005Q\u0011\u0010\u0005\b\u000b\u0017\u0013A\u0011ACG\u0011\u001d)9J\u0001C\u0001\u000b3Cq!b*\u0003\t\u0003)I\u000bC\u0004\u0006:\n!\t!b/\t\u000f\u0015E'\u0001\"\u0001\u0006T\"9Q1\u001d\u0002\u0005\u0002\u0015\u0015\bbBCy\u0005\u0011\u0005Q1\u001f\u0005\b\u000bo\u0014A\u0011AC}\u0011\u001d1YA\u0001C\u0001\r\u001bAqA\"\u0007\u0003\t\u00031Y\u0002C\u0004\u0007\"\t!\tAb\t\t\u000f\u0019\u0005\"\u0001\"\u0001\u0007(!9aQ\u0006\u0002\u0005\u0002\u0019=\u0002\"\u0003D*\u0005E\u0005I\u0011\u0001D+\u0011%1IFAI\u0001\n\u00031)\u0006C\u0004\u0007.\t!\tAb\u0017\t\u000f\u0019\r$\u0001\"\u0001\u0007f!9a1\r\u0002\u0005\u0002\u0019%\u0004b\u0002D7\u0005\u0011\u0005aq\u000e\u0005\b\r{\u0012A\u0011\u0001D@\u0011\u001d1iH\u0001C\u0001\r\u000bCqAb#\u0003\t\u00031i\tC\u0004\u0007\f\n!\tA\"%\b\u000f\u0019U%\u0001#\u0001\u0007\u0018\u001a9a1\u0014\u0002\t\u0002\u0019u\u0005bBBAm\u0011\u0005aQ\u0015\u0005\b\rO3D\u0011\u0001DU\u0011\u001d1iK\u000eC\u0001\r_CqA\"/\u0003\t\u00031Y\fC\u0004\u0007:\n!\tA\"1\t\u000f\u0019\u001d'\u0001\"\u0001\u0007J\"9aq\u001b\u0002\u0005\u0002\u0019e\u0007\"\u0003Ds\u0005E\u0005I\u0011\u0001C\u001b\u0011\u001d19O\u0001C\u0001\rSDqAb=\u0003\t'1)pB\u0004\b\u0004\tA\ta\"\u0002\u0007\u000f\u001d\u001d!\u0001#\u0001\b\n!91\u0011\u0011\"\u0005\u0002\u001dE\u0001b\u0002DT\u0005\u0012\u0005q1\u0003\u0005\b\r[\u0013E\u0011AD\u000f\u000f\u001d9yC\u0001E\u0001\u000fc1qab\r\u0003\u0011\u00039)\u0004C\u0004\u0004\u0002\u001e#\ta\"\u0010\t\u000f\u0019\u001dv\t\"\u0001\b@!9aQV$\u0005\u0002\u001d\u0015saBD&\u0005!\u0005qQ\n\u0004\b\u000f\u001f\u0012\u0001\u0012AD)\u0011\u001d\u0019\t\t\u0014C\u0001\u000f3BqAb*M\t\u00039Y\u0006C\u0004\u0007.2#\tab\u0019\b\u000f\u001d-$\u0001#\u0001\bn\u00199qq\u000e\u0002\t\u0002\u001dE\u0004bBBA#\u0012\u0005q1\u000f\u0005\b\rO\u000bF\u0011AD;\u0011\u001d1i+\u0015C\u0001\u000fw:qab \u0003\u0011\u00039\tIB\u0004\b\u0004\nA\ta\"\"\t\u000f\r\u0005e\u000b\"\u0001\b\u000e\"9aq\u0015,\u0005\u0002\u001d=\u0005b\u0002DW-\u0012\u0005qQS\u0004\b\u000f;\u0013\u0001\u0012CDP\r\u001d9\tK\u0001E\t\u000fGCqa!!\\\t\u00039)\u000bC\u0004\u0007.n#\tab*\u0007\r\u001de&\u0001CD^\u0011)9iL\u0018B\u0001B\u0003%A\u0011\u000e\u0005\b\u0007\u0003sF\u0011AD`\u0011\u001d1iK\u0018C\u0001\u000f\u000bDqa\"7_\t\u00039YnB\u0004\b^\nA\tbb8\u0007\u000f\u001de&\u0001#\u0005\bb\"91\u0011\u00113\u0005\u0002\u001d\r\bbBDs\u0005\u0011Eqq]\u0004\b\u000fW\u0014\u0001\u0012ADw\r\u001d9yO\u0001E\u0001\u000fcDqa!!i\t\u00039I\u0010C\u0004\u0007(\"$\tab?\t\u000f\u00195\u0006\u000e\"\u0001\t \u001d9\u00012\u0006\u0002\t\u0002!5ba\u0002E\u0018\u0005!\u0005\u0001\u0012\u0007\u0005\b\u0007\u0003kG\u0011\u0001E\u001d\u0011\u001d19+\u001cC\u0001\u0011wAqA\",n\t\u0003AYeB\u0004\tX\tA\t\u0001#\u0017\u0007\u000f!m#\u0001#\u0001\t^!91\u0011\u0011:\u0005\u0002!\u0015\u0004b\u0002DTe\u0012\u0005\u0001r\r\u0005\b\r[\u0013H\u0011\u0001E>\u000f\u001dA\u0019I\u0001E\u0001\u0011\u000b3q\u0001c\"\u0003\u0011\u0003AI\tC\u0004\u0004\u0002^$\t\u0001#%\t\u000f\u0019\u001dv\u000f\"\u0001\t\u0014\"9aQV<\u0005\u0002!\u0015fA\u0002EY\u0005!A\u0019\f\u0003\u0006\t6n\u0014\t\u0011)A\u0005\u0011oCqa!!|\t\u0003Ai\fC\u0004\tDn$\t\u0001#2\t\u000f\u001956\u0010\"\u0001\tL\u001e9\u0001r\u001a\u0002\t\u0012!Ega\u0002Ej\u0005!E\u0001R\u001b\u0005\t\u0007\u0003\u000b\u0019\u0001\"\u0001\tX\u001e9\u0001\u0012\u001c\u0002\t\u0012!mga\u0002Eo\u0005!E\u0001r\u001c\u0005\t\u0007\u0003\u000bI\u0001\"\u0001\tb\u001e9\u00012\u001d\u0002\t\u0012!\u0015ha\u0002Et\u0005!E\u0001\u0012\u001e\u0005\t\u0007\u0003\u000by\u0001\"\u0001\tl\u001e9\u0001R\u001e\u0002\t\u0012!=ha\u0002Ey\u0005!E\u00012\u001f\u0005\t\u0007\u0003\u000b)\u0002\"\u0001\tv\u001e9\u0001r\u001f\u0002\t\u0002!eha\u0002E~\u0005!\u0005\u0001R \u0005\t\u0007\u0003\u000bY\u0002\"\u0001\n\u0006!AaqUA\u000e\t\u0003I9\u0001\u0003\u0005\u0007.\u0006mA\u0011AE\u0006\u000f\u001dI\tB\u0001E\u0001\u0013'1q!#\u0006\u0003\u0011\u0003I9\u0002\u0003\u0005\u0004\u0002\u0006\u0015B\u0011AE\r\u0011!19+!\n\u0005\u0002%m\u0001\u0002\u0003DW\u0003K!\t!c\b\b\u000f%\r\"\u0001#\u0001\n&\u00199\u0011r\u0005\u0002\t\u0002%%\u0002\u0002CBA\u0003_!\t!#\r\t\u0011\u0019\u001d\u0016q\u0006C\u0001\u0013gA\u0001B\",\u00020\u0011\u0005\u0011RH\u0004\b\u0013\u000b\u0012\u0001\u0012AE$\r\u001dIIE\u0001E\u0001\u0013\u0017B\u0001b!!\u0002:\u0011\u0005\u0011R\n\u0005\t\r[\u000bI\u0004\"\u0001\nP\u001d9\u00112\u000b\u0002\t\u0002%UcaBE,\u0005!\u0005\u0011\u0012\f\u0005\t\u0007\u0003\u000b\t\u0005\"\u0001\nb!AaqUA!\t\u0003I\u0019\u0007\u0003\u0005\u0007.\u0006\u0005C\u0011AE4\u000f\u001dIYG\u0001E\u0001\u0013[2q!c\u001c\u0003\u0011\u0003I\t\b\u0003\u0005\u0004\u0002\u0006-C\u0011AE=\u0011!19+a\u0013\u0005\u0002%m\u0004\u0002\u0003DW\u0003\u0017\"\t!c\"\b\u000f%=%\u0001#\u0001\n\u0012\u001a9\u00112\u0013\u0002\t\u0002%U\u0005\u0002CBA\u0003+\"\t!#(\t\u0011\u0019\u001d\u0016Q\u000bC\u0001\u0013?C\u0001B\",\u0002V\u0011\u0005\u0011\u0012V\u0004\b\u0013k\u0013\u0001\u0012AE\\\r\u001dIIL\u0001E\u0001\u0013wC\u0001b!!\u0002`\u0011\u0005\u00112\u0019\u0005\t\rO\u000by\u0006\"\u0001\nF\"AaQVA0\t\u0003IiN\u0002\u0004\nf\nA\u0011r\u001d\u0005\f\u0013_\f9G!A!\u0002\u0013!I\u0007\u0003\u0005\u0004\u0002\u0006\u001dD\u0011AEy\u0011!I90a\u001a\u0005\u0002%e\b\u0002\u0003DT\u0003O\"\t!#@\t\u0011\u00195\u0016q\rC\u0001\u0015\u000f9qAc\u0004\u0003\u0011\u0003Q\tBB\u0004\u000b\u0014\tA\tA#\u0006\t\u0011\r\u0005\u0015Q\u000fC\u0001\u0015/9qA#\u0007\u0003\u0011\u0003QYBB\u0004\u000b\u001e\tA\tAc\b\t\u0011\r\u0005\u00151\u0010C\u0001\u0015C9qAc\t\u0003\u0011\u0003Q)CB\u0004\u000b(\tA\tA#\u000b\t\u0011\r\u0005\u0015\u0011\u0011C\u0001\u0015cA\u0001Bb*\u0002\u0002\u0012\u0005!2\u0007\u0005\t\r[\u000b\t\t\"\u0001\u000b<!9!2\t\u0002\u0005\u0002)\u0015\u0003b\u0002F5\u0005\u0011\u0005!2N\u0004\b\u0015\u0003\u0013\u0001\u0012\u0001FB\r\u001dQ)I\u0001E\u0001\u0015\u000fC\u0001b!!\u0002\u0010\u0012\u0005!r\u0012\u0005\t\rO\u000by\t\"\u0001\u000b\u0012\"AaQVAH\t\u0003QIjB\u0004\u000b\u001e\nA\tAc(\u0007\u000f)\u0005&\u0001#\u0001\u000b$\"A1\u0011QAM\t\u0003QY\u000b\u0003\u0005\u0007(\u0006eE\u0011\u0001FW\u0011!1i+!'\u0005\u0002)Mva\u0002F\\\u0005!\u0005!\u0012\u0018\u0004\b\u0015w\u0013\u0001\u0012\u0001F_\u0011!\u0019\t)a)\u0005\u0002)\u0015\u0007\u0002\u0003DT\u0003G#\tAc2\t\u0011\u00195\u00161\u0015C\u0001\u0015\u0017<qA#5\u0003\u0011\u0003Q\u0019NB\u0004\u000bV\nA\tAc6\t\u0011\r\u0005\u0015Q\u0016C\u0001\u0015?D\u0001Bb*\u0002.\u0012\u0005!\u0012\u001d\u0005\t\r[\u000bi\u000b\"\u0001\u000bd\u001e9!\u0012\u001e\u0002\t\u0012)-ha\u0002Fw\u0005!E!r\u001e\u0005\t\u0007\u0003\u000b9\f\"\u0001\u000br\"AaQVA\\\t\u0003Q\u0019pB\u0004\u000b|\nA\tA#@\u0007\u000f)}(\u0001#\u0001\f\u0002!A1\u0011QA`\t\u0003YY\u0001\u0003\u0005\f\u000e\u0005}F\u0011IF\b\u0011!Y\u0019\"a0\u0005\u0002-U\u0001\u0002\u0003DT\u0003\u007f#\ta#\u0007\t\u0011\u0019\u001d\u0016q\u0018C\u0001\u0017;9qa#\t\u0003\u0011\u0003Y\u0019CB\u0004\f&\tA\tac\n\t\u0011\r\u0005\u0015Q\u001aC\u0001\u0017_A\u0001Bb*\u0002N\u0012\u00051\u0012\u0007\u0005\t\r[\u000bi\r\"\u0001\f<\u001d912\t\u0002\t\u0012-\u0015caBF$\u0005!E1\u0012\n\u0005\t\u0007\u0003\u000b9\u000e\"\u0001\fL!AaQVAl\t\u0003YieB\u0004\fV\tA\tbc\u0016\u0007\u000f-e#\u0001#\u0005\f\\!A1\u0011QAp\t\u0003Yi\u0006\u0003\u0005\u0007.\u0006}G\u0011AF0\u000f\u001dY)G\u0001E\t\u0017O2qa#\u001b\u0003\u0011#YY\u0007\u0003\u0005\u0004\u0002\u0006\u001dH\u0011AF7\u0011!1i+a:\u0005\u0002-=taBF@\u0005!E1\u0012\u0011\u0004\b\u0017\u0007\u0013\u0001\u0012CFC\u0011!\u0019\t)a<\u0005\u0002-\u001d\u0005\u0002\u0003DW\u0003_$\ta##\b\u000f-5%\u0001#\u0005\f\u0010\u001a91\u0012\u0013\u0002\t\u0012-M\u0005\u0002CBA\u0003o$\ta#&\t\u0011\u00195\u0016q\u001fC\u0001\u0017/;qac'\u0003\u0011#YiJB\u0004\f \nA\tb#)\t\u0011\r\u0005\u0015q C\u0001\u0017GC\u0001B\",\u0002\u0000\u0012\u00051RU\u0004\b\u0017W\u0013\u0001\u0012CFW\r\u001dYyK\u0001E\t\u0017cC\u0001b!!\u0003\b\u0011\u000512\u0017\u0005\t\r[\u00139\u0001\"\u0001\f6\u001a11\u0012\u0018\u0002\t\u0017wC1b!)\u0003\u000e\t\u0005\t\u0015!\u0003\u0007\\\"A1\u0011\u0011B\u0007\t\u0003Yi\f\u0003\u0005\u0007.\n5A\u0011AFb\u000f\u001dY9M\u0001E\t\u0017\u00134qac3\u0003\u0011#Yi\r\u0003\u0005\u0004\u0002\n]A\u0011AFh\u000f\u001dY\tN\u0001E\t\u0017'4qa#6\u0003\u0011#Y9\u000e\u0003\u0005\u0004\u0002\nuA\u0011AFm\u000f\u001dYYN\u0001E\t\u0017;4qac8\u0003\u0011#Y\t\u000f\u0003\u0005\u0004\u0002\n\rB\u0011AFr\u000f\u001dY)O\u0001E\t\u0017O4qa#;\u0003\u0011#YY\u000f\u0003\u0005\u0004\u0002\n%B\u0011AFw\u0011!1iK!\u000b\u0005\u0002-=\bbBFz\u0005\u0011E1R_\u0004\b\u0017w\u0014\u0001\u0012AF\u007f\r\u001dYyP\u0001E\u0001\u0019\u0003A\u0001b!!\u00034\u0011\u0005A\u0012\u0002\u0005\t\rO\u0013\u0019\u0004\"\u0001\r\f!AaQ\u0016B\u001a\t\u0003a\tbB\u0004\r\u0016\tA\t\u0001d\u0006\u0007\u000f1e!\u0001#\u0001\r\u001c!A1\u0011\u0011B\u001f\t\u0003ai\u0002\u0003\u0005\u0007(\nuB\u0011\u0001G\u0010\u0011!1iK!\u0010\u0005\u00021\u0015ra\u0002G\u0015\u0005!EA2\u0006\u0004\b\u0019[\u0011\u0001\u0012\u0003G\u0018\u0011!\u0019\tIa\u0012\u0005\u00021E\u0002\u0002\u0003DW\u0005\u000f\"\t\u0001d\r\b\u000f1e\"\u0001#\u0005\r<\u00199AR\b\u0002\t\u00121}\u0002\u0002CBA\u0005\u001f\"\t\u0001$\u0011\t\u0011\u00195&q\nC\u0001\u0019\u0007:q\u0001d\u0012\u0003\u0011#aIEB\u0004\rL\tA\t\u0002$\u0014\t\u0011\r\u0005%q\u000bC\u0001\u0019\u001fB\u0001B\",\u0003X\u0011\u0005A\u0012K\u0004\b\u0019+\u0012\u0001\u0012\u0003G,\r\u001daIF\u0001E\t\u00197B\u0001b!!\u0003`\u0011\u0005AR\f\u0005\t\r[\u0013y\u0006\"\u0001\r`!9AR\r\u0002\u0005\u00121\u001dta\u0002G7\u0005!\u0005Ar\u000e\u0004\b\u0019c\u0012\u0001\u0012\u0001G:\u0011!\u0019\tI!\u001b\u0005\u00021m\u0004\u0002\u0003DT\u0005S\"\t\u0001$ \t\u0011\u00195&\u0011\u000eC\u0001\u0019\u000f;q\u0001$$\u0003\u0011\u0003ayIB\u0004\r\u0012\nA\t\u0001d%\t\u0011\r\u0005%1\u000fC\u0001\u00197C\u0001Bb*\u0003t\u0011\u0005AR\u0014\u0005\t\r[\u0013\u0019\b\"\u0001\r&\u001e9AR\u0016\u0002\t\u00021=fa\u0002GY\u0005!\u0005A2\u0017\u0005\t\u0007\u0003\u0013i\b\"\u0001\r<\"Aaq\u0015B?\t\u0003ai\f\u0003\u0005\u0007.\nuD\u0011\u0001Gi\u000f\u001daIN\u0001E\u0001\u001974q\u0001$8\u0003\u0011\u0003ay\u000e\u0003\u0005\u0004\u0002\n\u001dE\u0011\u0001Gt\u0011!19Ka\"\u0005\u00021%\b\u0002\u0003DW\u0005\u000f#\t\u0001$=\b\u000f1m(\u0001#\u0001\r~\u001a9Ar \u0002\t\u00025\u0005\u0001\u0002CBA\u0005##\t!$\u0003\t\u0011\u0019\u001d&\u0011\u0013C\u0001\u001b\u0017A\u0001B\",\u0003\u0012\u0012\u0005QrB\u0004\b\u001b+\u0011\u0001\u0012AG\f\r\u001diIB\u0001E\u0001\u001b7A\u0001b!!\u0003\u001c\u0012\u0005Q2E\u0004\t\u001bK\u0011Y\n#\u0003\u000e(\u0019AQ2\u0006BN\u0011\u0013ii\u0003\u0003\u0005\u0004\u0002\n\u0005F\u0011AG\u0018\u0011!19K!)\u0005\u00025E\u0002\u0002\u0003DW\u0005C#\t!$\u0010\b\u00115\u0015#1\u0014E\u0005\u001b\u000f2\u0001\"$\u0013\u0003\u001c\"%Q2\n\u0005\t\u0007\u0003\u0013Y\u000b\"\u0001\u000eN!Aaq\u0015BV\t\u0003iy\u0005\u0003\u0005\u0007.\n-F\u0011AG+\u000f!iiFa'\t\n5}c\u0001CG1\u00057CI!d\u0019\t\u0011\r\u0005%Q\u0017C\u0001\u001bKB\u0001Bb*\u00036\u0012\u0005Qr\r\u0005\t\r[\u0013)\f\"\u0001\u000ez\u001dAQ\u0012\u0011BN\u0011\u0013i\u0019I\u0002\u0005\u000e\u0006\nm\u0005\u0012BGD\u0011!\u0019\tIa0\u0005\u00025%\u0005\u0002\u0003DT\u0005\u007f#\t!d#\t\u0011\u00195&q\u0018C\u0001\u001b#;\u0001\"$&\u0003\u001c\"%Qr\u0013\u0004\t\u001b3\u0013Y\n#\u0003\u000e\u001c\"A1\u0011\u0011Be\t\u0003ii\n\u0003\u0005\u0007(\n%G\u0011AGP\u0011!1iK!3\u0005\u00025\rv\u0001CGU\u00057CI!d+\u0007\u001155&1\u0014E\u0005\u001b_C\u0001b!!\u0003T\u0012\u0005Q\u0012\u0017\u0005\t\rO\u0013\u0019\u000e\"\u0001\u000e4\"AaQ\u0016Bj\t\u0003iIl\u0002\u0005\u000eB\nm\u0005\u0012BGb\r!i)Ma'\t\n5\u001d\u0007\u0002CBA\u0005;$\t!$3\t\u0011\u0019\u001d&Q\u001cC\u0001\u001b\u0017D\u0001B\",\u0003^\u0012\u0005Q2\\\u0004\t\u001b?\u0014Y\n#\u0003\u000eb\u001aAQ2\u001dBN\u0011\u0013i)\u000f\u0003\u0005\u0004\u0002\n\u001dH\u0011AGt\u0011!19Ka:\u0005\u00025%\b\u0002\u0003DW\u0005O$\t!d>\b\u00115}(1\u0014E\u0005\u001d\u00031\u0001Bd\u0001\u0003\u001c\"%aR\u0001\u0005\t\u0007\u0003\u0013\t\u0010\"\u0001\u000f\b!Aaq\u0015By\t\u0003qI\u0001\u0003\u0005\u0007.\nEH\u0011\u0001H\b\u0011!q\u0019Ba'\u0005\n9U\u0001\u0002\u0003H\u000f\u00057#IAd\b\t\u0011\u0019\u001d&1\u0014C\u0001\u001dGA\u0001B\",\u0003\u001c\u0012\u0005a2G\u0004\b\u001ds\u0011\u0001\u0012\u0001H\u001e\r\u001dqiD\u0001E\u0001\u001d\u007fA\u0001b!!\u0004\u0004\u0011\u0005ar\t\u0005\t\rO\u001b\u0019\u0001\"\u0001\u000fJ!AaQVB\u0002\t\u0003qyeB\u0004\u000fX\tA\tA$\u0017\u0007\u000f9m#\u0001#\u0001\u000f^!A1\u0011QB\u0007\t\u0003q)\u0007\u0003\u0005\u0007(\u000e5A\u0011\u0001H4\u0011!1ik!\u0004\u0005\u000295ta\u0002H;\u0005!\u0005ar\u000f\u0004\b\u001ds\u0012\u0001\u0012\u0001H>\u0011!\u0019\tia\u0006\u0005\u00029\r\u0005\u0002\u0003DT\u0007/!\tA$\"\t\u0011\u001956q\u0003C\u0001\u001d#;qA$'\u0003\u0011\u0003qYJB\u0004\u000f\u001e\nA\tAd(\t\u0011\r\u00055\u0011\u0005C\u0001\u001dOC\u0001Bb*\u0004\"\u0011\u0005a\u0012\u0016\u0005\t\r[\u001b\t\u0003\"\u0001\u000f6\u001e9a\u0012\u0018\u0002\t\u00029mfa\u0002H_\u0005!\u0005ar\u0018\u0005\t\u0007\u0003\u001bY\u0003\"\u0001\u000fH\"AaqUB\u0016\t\u0003qI\r\u0003\u0005\u0007.\u000e-B\u0011\u0001Hk\u000f\u001dqIN\u0001E\u0001\u001d74qA$8\u0003\u0011\u0003qy\u000e\u0003\u0005\u0004\u0002\u000eUB\u0011\u0001Ht\u0011!19k!\u000e\u0005\u00029%\b\u0002\u0003DW\u0007k!\tAd>\b\u000f9m(\u0001#\u0001\u000f~\u001a9ar \u0002\t\u0002=\u0005\u0001\u0002CBA\u0007\u007f!\ta$\u0003\t\u0011\u0019\u001d6q\bC\u0001\u001f\u0017A\u0001B\",\u0004@\u0011\u0005q\u0012\u0004\u0005\n\u001fS\u0001!\u0019!C\u0001\u001fW\u0011!CU3jM&\u001c\u0017\r^5p]N+\b\u000f]8si*!1QJB(\u0003!Ig\u000e^3s]\u0006d'\u0002BB)\u0007'\nqA]3gY\u0016\u001cGO\u0003\u0002\u0004V\u0005)1oY1mC\u000e\u00011c\u0001\u0001\u0004\\A!1QLB0\u001b\t\u0019\u0019&\u0003\u0003\u0004b\rM#AB!osJ+g-\u0001\u0004%S:LG\u000f\n\u000b\u0003\u0007O\u0002Ba!\u0018\u0004j%!11NB*\u0005\u0011)f.\u001b;\u0003-I+\u0017NZ5dCRLwN\\*vaB|'\u000f^%na2\u001cRAAB.\u0007c\u0002Baa\u001d\u0004v5\t\u0001!\u0003\u0003\u0004x\re$!\u0006*fS\u001aL7-\u0019;j_:\u001cV\u000f\u001d9peR\f\u0005/[\u0005\u0005\u0007w\u001aiHA\u0005J]R,'O\\1mg*!1qPB(\u0003\r\t\u0007/[\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005\r\u0015\u0005cAB:\u0005\u0005Q1/\u001a7fGR$\u0016\u0010]3\u0015\r\r-5QSBP!\u0011\u0019\u0019h!$\n\t\r=5\u0011\u0013\u0002\u000b)f\u0004XmU=nE>d\u0017\u0002BBJ\u0007\u0017\u0012qaU=nE>d7\u000fC\u0004\u0004\u0018\u0012\u0001\ra!'\u0002\u000b=<h.\u001a:\u0011\t\rM41T\u0005\u0005\u0007;\u001b\tJ\u0001\u0004Ts6\u0014w\u000e\u001c\u0005\b\u0007C#\u0001\u0019ABR\u0003\u0011q\u0017-\\3\u0011\t\r\u001561\u0017\b\u0005\u0007O\u001by\u000b\u0005\u0003\u0004*\u000eMSBABV\u0015\u0011\u0019ika\u0016\u0002\rq\u0012xn\u001c;?\u0013\u0011\u0019\tla\u0015\u0002\rA\u0013X\rZ3g\u0013\u0011\u0019)la.\u0003\rM#(/\u001b8h\u0015\u0011\u0019\tla\u0015\u0002\u0015M,G.Z2u)\u0016\u0014X\u000e\u0006\u0004\u0004>\u000e\r7Q\u0019\t\u0005\u0007g\u001ay,\u0003\u0003\u0004B\u000eE%A\u0003+fe6\u001c\u00160\u001c2pY\"91qS\u0003A\u0002\re\u0005bBBQ\u000b\u0001\u000711U\u0001\u0007g\u0016dWm\u0019;\u0015\r\re51ZBg\u0011\u001d\u00199J\u0002a\u0001\u00073Cqa!)\u0007\u0001\u0004\u0019y\r\u0005\u0003\u0004t\rE\u0017\u0002BBj\u0007+\u0014AAT1nK&!1q[B&\u0005\u0015q\u0015-\\3t\u0003Y\u0019X\r\\3di>3XM\u001d7pC\u0012,G-T3uQ>$G\u0003CBo\u0007G\u001c)oa:\u0011\t\rM4q\\\u0005\u0005\u0007C\u001c\tJ\u0001\u0007NKRDw\u000eZ*z[\n|G\u000eC\u0004\u0004\u0018\u001e\u0001\ra!'\t\u000f\r\u0005v\u00011\u0001\u0004$\"91\u0011^\u0004A\u0002\r-\u0018!B5oI\u0016D\b\u0003BB/\u0007[LAaa<\u0004T\t\u0019\u0011J\u001c;\u0002\u00179,wO\u0012:fKR+'/\u001c\u000b\u000b\u0007k\u001cYp!@\u0005\u000e\u0011]\u0001\u0003BB:\u0007oLAa!?\u0004\u0012\nqaI]3f)\u0016\u0014XnU=nE>d\u0007bBBQ\u0011\u0001\u000711\u0015\u0005\t\u0007\u007fDA\u00111\u0001\u0005\u0002\u0005)a/\u00197vKB11Q\fC\u0002\t\u000fIA\u0001\"\u0002\u0004T\tAAHY=oC6,g\b\u0005\u0003\u0004^\u0011%\u0011\u0002\u0002C\u0006\u0007'\u00121!\u00118z\u0011%!y\u0001\u0003I\u0001\u0002\u0004!\t\"A\u0003gY\u0006<7\u000f\u0005\u0003\u0004^\u0011M\u0011\u0002\u0002C\u000b\u0007'\u0012A\u0001T8oO\"IA\u0011\u0004\u0005\u0011\u0002\u0003\u000711U\u0001\u0007_JLw-\u001b8\u0002+9,wO\u0012:fKR+'/\u001c\u0013eK\u001a\fW\u000f\u001c;%gU\u0011Aq\u0004\u0016\u0005\t#!\tc\u000b\u0002\u0005$A!AQ\u0005C\u0018\u001b\t!9C\u0003\u0003\u0005*\u0011-\u0012!C;oG\",7m[3e\u0015\u0011!ica\u0015\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0003\u00052\u0011\u001d\"!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\u0006)b.Z<Ge\u0016,G+\u001a:nI\u0011,g-Y;mi\u0012\"TC\u0001C\u001cU\u0011\u0019\u0019\u000b\"\t\u0002\u00179,wO\u0012:fKRK\b/\u001a\u000b\t\t{!\u0019\u0005\"\u0012\u0005HA!11\u000fC \u0013\u0011!\te!%\u0003\u001d\u0019\u0013X-\u001a+za\u0016\u001c\u00160\u001c2pY\"91\u0011U\u0006A\u0002\r\r\u0006\"\u0003C\b\u0017A\u0005\t\u0019\u0001C\t\u0011%!Ib\u0003I\u0001\u0002\u0004\u0019\u0019+A\u000boK^4%/Z3UsB,G\u0005Z3gCVdG\u000f\n\u001a\u0002+9,wO\u0012:fKRK\b/\u001a\u0013eK\u001a\fW\u000f\u001c;%g\u0005ya.Z<OKN$X\rZ*z[\n|G\u000e\u0006\u0007\u0004\u001a\u0012EC1\u000bC+\tG\")\u0007C\u0004\u0004\u0018:\u0001\ra!'\t\u000f\r\u0005f\u00021\u0001\u0004P\"9Aq\u000b\bA\u0002\u0011e\u0013a\u00019pgB!11\u000fC.\u0013\u0011!i\u0006b\u0018\u0003\u0011A{7/\u001b;j_:LA\u0001\"\u0019\u0004L\tI\u0001k\\:ji&|gn\u001d\u0005\b\t\u001fq\u0001\u0019\u0001C\t\u0011\u001d!9G\u0004a\u0001\tS\nq![:DY\u0006\u001c8\u000f\u0005\u0003\u0004^\u0011-\u0014\u0002\u0002C7\u0007'\u0012qAQ8pY\u0016\fg.\u0001\u0007oK^\u001c6m\u001c9f/&$\b\u000e\u0006\u0003\u0005t\u0011u\u0004\u0003BB:\tkJA\u0001b\u001e\u0005z\t)1kY8qK&!A1PB&\u0005\u0019\u00196m\u001c9fg\"9AqP\bA\u0002\u0011\u0005\u0015!B3mK6\u001c\bCBB/\t\u0007\u001bI*\u0003\u0003\u0005\u0006\u000eM#A\u0003\u001fsKB,\u0017\r^3e}\u0005q1/\u001a;B]:|G/\u0019;j_:\u001cX\u0003\u0002CF\t##b\u0001\"$\u0005\u001e\u0012\u0005\u0006\u0003\u0002CH\t#c\u0001\u0001B\u0004\u0005\u0014B\u0011\r\u0001\"&\u0003\u0003M\u000bB\u0001b&\u0004\u001aB!1Q\fCM\u0013\u0011!Yja\u0015\u0003\u000f9{G\u000f[5oO\"9Aq\u0014\tA\u0002\u00115\u0015aA:z[\"9A1\u0015\tA\u0002\u0011\u0015\u0016AB1o]>$8\u000f\u0005\u0004\u0005(\u00125F1\u0017\b\u0005\u0007;\"I+\u0003\u0003\u0005,\u000eM\u0013a\u00029bG.\fw-Z\u0005\u0005\t_#\tL\u0001\u0003MSN$(\u0002\u0002CV\u0007'\u0002Baa\u001d\u00056&!Aq\u0017C]\u00059\teN\\8uCRLwN\\%oM>LA\u0001b/\u0004L\ty\u0011I\u001c8pi\u0006$\u0018n\u001c8J]\u001a|7/A\u0004tKRLeNZ8\u0016\t\u0011\u0005GQ\u0019\u000b\u0007\t\u0007$9\r\"3\u0011\t\u0011=EQ\u0019\u0003\b\t'\u000b\"\u0019\u0001CK\u0011\u001d!y*\u0005a\u0001\t\u0007Dq\u0001b3\u0012\u0001\u0004!i-A\u0002ua\u0016\u0004Baa\u001d\u0005P&!A\u0011\u001bCj\u0005\u0011!\u0016\u0010]3\n\t\u0011U71\n\u0002\u0006)f\u0004Xm]\u0001\u0007[.$\u0006.[:\u0015\t\u0011mGQ\u001d\t\u0005\u0007g\"i.\u0003\u0003\u0005`\u0012\u0005(\u0001\u0002+sK\u0016LA\u0001b9\u0004L\t)AK]3fg\"9Aq\u0014\nA\u0002\re\u0015\u0001C7l'\u0016dWm\u0019;\u0015\r\u0011-H\u0011\u001fC{!\u0011\u0019\u0019\b\"<\n\t\u0011=H\u0011\u001d\u0002\u0007'\u0016dWm\u0019;\t\u000f\u0011M8\u00031\u0001\u0005\\\u0006I\u0011/^1mS\u001aLWM\u001d\u0005\b\t?\u001b\u0002\u0019ABM\u0003\u001di7.\u00133f]R$B\u0001b?\u0006\u0002A!11\u000fC\u007f\u0013\u0011!y\u0010\"9\u0003\u000b%#WM\u001c;\t\u000f\u0011}E\u00031\u0001\u0004\u001a\u0006QQn\u001b+za\u0016$&/Z3\u0015\t\u0015\u001dQQ\u0002\t\u0005\u0007g*I!\u0003\u0003\u0006\f\u0011\u0005(\u0001\u0003+za\u0016$&/Z3\t\u000f\u0015=Q\u00031\u0001\u0005N\u0006\u0011A\u000f]\u0001\t)\"L7\u000fV=qKR!AQZC\u000b\u0011\u001d!yJ\u0006a\u0001\u00073\u000b!bU5oO2,G+\u001f9f)\u0019!i-b\u0007\u0006 !9QQD\fA\u0002\u00115\u0017a\u00019sK\"9AqT\fA\u0002\re\u0015!C*va\u0016\u0014H+\u001f9f)\u0019!i-\"\n\u0006*!9Qq\u0005\rA\u0002\u00115\u0017a\u0002;iSN$\b/\u001a\u0005\b\u000bWA\u0002\u0019\u0001Cg\u0003!\u0019X\u000f]3siB,\u0017\u0001D\"p]N$\u0018M\u001c;UsB,G\u0003BC\u0019\u000bo\u0001Baa\u001d\u00064%!QQ\u0007Cj\u00051\u0019uN\\:uC:$H+\u001f9f\u0011\u001d\u0019y0\u0007a\u0001\u000bs\u0001Baa\u001d\u0006<%!QQHC \u0005!\u0019uN\\:uC:$\u0018\u0002BC!\u0007\u0017\u0012\u0011bQ8ogR\fg\u000e^:\u0002\u000fQK\b/\u001a*fMRAAQZC$\u000b\u0013*Y\u0005C\u0004\u0006\u001ei\u0001\r\u0001\"4\t\u000f\u0011}%\u00041\u0001\u0004\u001a\"9QQ\n\u000eA\u0002\u0015=\u0013\u0001B1sON\u0004b\u0001b*\u0005.\u00125\u0017a\u0003*fM&tW\r\u001a+za\u0016$\u0002\"\"\u0016\u0006\\\u0015}S1\r\t\u0005\u0007g*9&\u0003\u0003\u0006Z\u0011M'a\u0003*fM&tW\r\u001a+za\u0016Dq!\"\u0018\u001c\u0001\u0004)y%A\u0004qCJ,g\u000e^:\t\u000f\u0015\u00054\u00041\u0001\u0005t\u0005)A-Z2mg\"9QQM\u000eA\u0002\re\u0015A\u0003;za\u0016\u001c\u00160\u001c2pY\u0006i1\t\\1tg&sgm\u001c+za\u0016$\u0002\"b\u001b\u0006r\u0015MTQ\u000f\t\u0005\u0007g*i'\u0003\u0003\u0006p\u0011M'!D\"mCN\u001c\u0018J\u001c4p)f\u0004X\rC\u0004\u0006^q\u0001\r!b\u0014\t\u000f\u0015\u0005D\u00041\u0001\u0005t!9QQ\r\u000fA\u0002\re\u0015AC'fi\"|G\rV=qKR1Q1PCA\u000b\u000f\u0003Baa\u001d\u0006~%!Qq\u0010Cj\u0005)iU\r\u001e5pIRK\b/\u001a\u0005\b\u000b\u0007k\u0002\u0019ACC\u0003\u0019\u0001\u0018M]1ngB1Aq\u0015CW\u00073Cq!\"#\u001e\u0001\u0004!i-\u0001\u0006sKN,H\u000e\u001e+za\u0016\f\u0011CT;mY\u0006\u0014\u00180T3uQ>$G+\u001f9f)\u0011)y)\"&\u0011\t\rMT\u0011S\u0005\u0005\u000b'#\u0019NA\tOk2d\u0017M]=NKRDw\u000e\u001a+za\u0016Dq!\"#\u001f\u0001\u0004!i-\u0001\u0005Q_2LH+\u001f9f)\u0019)Y*\")\u0006&B!11OCO\u0013\u0011)y\nb5\u0003\u0011A{G.\u001f+za\u0016Dq!b) \u0001\u0004)))\u0001\u0006usB,\u0007+\u0019:b[NDq!\"# \u0001\u0004!i-A\bFq&\u001cH/\u001a8uS\u0006dG+\u001f9f)\u0019)Y+\"-\u00066B!11OCW\u0013\u0011)y\u000bb5\u0003\u001f\u0015C\u0018n\u001d;f]RL\u0017\r\u001c+za\u0016Dq!b-!\u0001\u0004)))\u0001\u0006rk\u0006tG/\u001b4jK\u0012Dq!b.!\u0001\u0004!i-\u0001\u0006v]\u0012,'\u000f\\=j]\u001e\fQ\"\u00118o_R\fG/\u001a3UsB,GCBC_\u000b\u0007,y\r\u0005\u0003\u0004t\u0015}\u0016\u0002BCa\t'\u0014Q\"\u00118o_R\fG/\u001a3UsB,\u0007bBCcC\u0001\u0007QqY\u0001\fC:tw\u000e^1uS>t7\u000f\u0005\u0004\u0005(\u00125V\u0011\u001a\t\u0005\u0007g*Y-\u0003\u0003\u0006N\u0012e&AC!o]>$\u0018\r^5p]\"9QqW\u0011A\u0002\u00115\u0017A\u0003+za\u0016\u0014u.\u001e8egR1QQ[Cn\u000b?\u0004Baa\u001d\u0006X&!Q\u0011\u001cCj\u0005)!\u0016\u0010]3C_VtGm\u001d\u0005\b\u000b;\u0014\u0003\u0019\u0001Cg\u0003\taw\u000eC\u0004\u0006b\n\u0002\r\u0001\"4\u0002\u0005!L\u0017a\u0005\"pk:$W\rZ,jY\u0012\u001c\u0017M\u001d3UsB,G\u0003BCt\u000b[\u0004Baa\u001d\u0006j&!Q1\u001eCj\u0005M\u0011u.\u001e8eK\u0012<\u0016\u000e\u001c3dCJ$G+\u001f9f\u0011\u001d)yo\ta\u0001\u000b+\faAY8v]\u0012\u001c\u0018A\u0003;iSN\u0004&/\u001a4jqR!AQZC{\u0011\u001d!y\n\na\u0001\u00073\u000bqa]3u)f\u0004X-\u0006\u0003\u0006|\u0016}HCBC\u007f\r\u000b1I\u0001\u0005\u0003\u0005\u0010\u0016}Ha\u0002D\u0001K\t\u0007a1\u0001\u0002\u0002)F!Aq\u0013Cn\u0011\u001d19!\na\u0001\u000b{\fA\u0001\u001e:fK\"9A1Z\u0013A\u0002\u00115\u0017!C:fiNKXNY8m+\u00111yAb\u0005\u0015\r\u0019EaQ\u0003D\f!\u0011!yIb\u0005\u0005\u000f\u0019\u0005aE1\u0001\u0007\u0004!9aq\u0001\u0014A\u0002\u0019E\u0001b\u0002CPM\u0001\u00071\u0011T\u0001\bi>\u001cF/\u0019;t)\u00111iBb\b\u0011\r\u0011\u001dFQ\u0016Cn\u0011\u001d19a\na\u0001\t7\fA\"\\6B]:|G/\u0019;j_:$B\u0001b7\u0007&!9aq\u0001\u0015A\u0002\u0011mG\u0003\u0002D\u000f\rSAqAb\u000b*\u0001\u00041i\"A\u0003ue\u0016,7/A\u0004nWB\u000b'/Y7\u0015\u0011\u0019Eb1\bD!\r\u001f\u0002b\u0001b*\u0005.\u001aM\u0002C\u0002CT\t[3)\u0004\u0005\u0003\u0004t\u0019]\u0012\u0002\u0002D\u001d\tC\u0014aAV1m\t\u00164\u0007b\u0002D\u001fU\u0001\u0007aqH\u0001\u0006CJ<7o\u001d\t\u0007\tO#iK\"\b\t\u0013\u0019\r#\u0006%AA\u0002\u0019\u0015\u0013AC3yiJ\fg\t\\1hgB!11\u000fD$\u0013\u00111IEb\u0013\u0003\u000f\u0019c\u0017mZ*fi&!aQJB&\u0005!1E.Y4TKR\u001c\b\"\u0003D)UA\u0005\t\u0019\u0001D#\u00031)\u0007p\u00197vI\u00164E.Y4t\u0003Ei7\u000eU1sC6$C-\u001a4bk2$HEM\u000b\u0003\r/RCA\"\u0012\u0005\"\u0005\tRn\u001b)be\u0006lG\u0005Z3gCVdG\u000fJ\u001a\u0015\u0011\u0019UbQ\fD0\rCBqAb\u0002.\u0001\u0004!Y\u000eC\u0004\u0007D5\u0002\rA\"\u0012\t\u000f\u0019ES\u00061\u0001\u0007F\u0005yQn[%na2L7-\u001b;QCJ\fW\u000e\u0006\u0003\u00074\u0019\u001d\u0004bBC']\u0001\u0007aQ\u0004\u000b\u0005\rk1Y\u0007C\u0004\u0007\b=\u0002\r\u0001b7\u0002\u00135\\G\u000b]1sC6\u001cH\u0003\u0002D9\rs\u0002b\u0001b*\u0005.\u001aM\u0004\u0003BB:\rkJAAb\u001e\u0005b\n9A+\u001f9f\t\u00164\u0007b\u0002D>a\u0001\u0007aQD\u0001\biB\f'/Y7t\u00031i7NU3gS:,7\u000b^1u)\u0011!YN\"!\t\u000f\u0019\r\u0015\u00071\u0001\u0005\\\u0006!1\u000f^1u)\u00111iBb\"\t\u000f\u0019%%\u00071\u0001\u0007\u001e\u0005)1\u000f^1ug\u0006iQn\u001b)bG.\fw-Z*uCR$B\u0001b7\u0007\u0010\"9a1Q\u001aA\u0002\u0011mG\u0003\u0002D\u000f\r'CqA\"#5\u0001\u00041i\"\u0001\u0005TG\u0006d\u0017\rR8u!\r1IJN\u0007\u0002\u0005\tA1kY1mC\u0012{GoE\u00037\u000772y\n\u0005\u0003\u0007\u001a\u001a\u0005\u0016\u0002\u0002DR\u0007k\u0012\u0011cU2bY\u0006$u\u000e^#yiJ\f7\r^8s)\t19*A\u0003baBd\u0017\u0010\u0006\u0003\u0005\\\u001a-\u0006bBBQq\u0001\u00071qZ\u0001\bk:\f\u0007\u000f\u001d7z)\u00111\tLb.\u0011\r\ruc1WBh\u0013\u00111)la\u0015\u0003\r=\u0003H/[8o\u0011\u001d19!\u000fa\u0001\t7\f!\"\\6FCJd\u0017\u0010R3g)\u0011!YN\"0\t\u000f\u0019}&\b1\u0001\u0005\\\u0006!A-\u001a4o)\u00111iBb1\t\u000f\u0019\u00157\b1\u0001\u0007\u001e\u0005)A-\u001a4og\u0006IQn\u001b*fMR\u0013X-\u001a\u000b\u0007\r\u00174\tN\"6\u0011\t\rMdQZ\u0005\u0005\r\u001f$\tOA\u0004SK\u001a$&/Z3\t\u000f\u0019MG\b1\u0001\u0005\\\u0006!\u0011/^1m\u0011\u001d!y\n\u0010a\u0001\u00073\u000bQB\u001a:fg\"$VM]7OC6,G\u0003\u0002Dn\rC\u0004Baa\u001d\u0007^&!aq\\Bk\u0005!!VM]7OC6,\u0007\"\u0003Dr{A\u0005\t\u0019ABR\u0003\u0019\u0001(/\u001a4jq\u00069bM]3tQR+'/\u001c(b[\u0016$C-\u001a4bk2$H%M\u0001\u000eMJ,7\u000f\u001b+za\u0016t\u0015-\\3\u0015\t\u0019-h\u0011\u001f\t\u0005\u0007g2i/\u0003\u0003\u0007p\u000eU'\u0001\u0003+za\u0016t\u0015-\\3\t\u000f\u0019\rx\b1\u0001\u0004$\u0006)aM]3tQV\u0011aq\u001f\t\u0005\rs4y0\u0004\u0002\u0007|*!aQ`B&\u0003\u0011)H/\u001b7\n\t\u001d\u0005a1 \u0002\u0011\rJ,7\u000f\u001b(b[\u0016\u001c%/Z1u_J\fa\"S7qY&\u001c\u0017\u000e\u001e)be\u0006l7\u000fE\u0002\u0007\u001a\n\u0013a\"S7qY&\u001c\u0017\u000e\u001e)be\u0006l7oE\u0003C\u00077:Y\u0001\u0005\u0003\u0007\u001a\u001e5\u0011\u0002BD\b\u0007k\u0012q#S7qY&\u001c\u0017\u000e\u001e)be\u0006l7/\u0012=ue\u0006\u001cGo\u001c:\u0015\u0005\u001d\u0015AC\u0002D \u000f+9I\u0002C\u0004\b\u0018\u0011\u0003\rAb\u0010\u0002\u000fA\f'/Y7tg\"9q1\u0004#A\u0002\u0019u\u0011AC5na2\u0004\u0018M]1ngR!qqDD\u0016!\u0019\u0019if\"\t\b&%!q1EB*\u0005\u0011\u0019v.\\3\u0011\u0011\rusq\u0005D\u0019\rgIAa\"\u000b\u0004T\t1A+\u001e9mKJBqa\"\fF\u0001\u00041\t$\u0001\u0005wa\u0006\u0014\u0018-\\:t\u0003%1E.Y4t%\u0016\u0004(\u000fE\u0002\u0007\u001a\u001e\u0013\u0011B\u00127bON\u0014V\r\u001d:\u0014\u000b\u001d\u001bYfb\u000e\u0011\t\u0019eu\u0011H\u0005\u0005\u000fw\u0019)H\u0001\nGY\u0006<7OU3qe\u0016CHO]1di>\u0014HCAD\u0019)\u00111)e\"\u0011\t\u000f\u001d\r\u0013\n1\u0001\u0005\u0012\u0005!!-\u001b;t)\u001199e\"\u0013\u0011\r\rus\u0011\u0005C\t\u0011\u001d!yA\u0013a\u0001\t#\tAcU=oi\u0006\u001cG/[2UsB,\u0017\t\u001d9mS\u0016$\u0007c\u0001DM\u0019\n!2+\u001f8uC\u000e$\u0018n\u0019+za\u0016\f\u0005\u000f\u001d7jK\u0012\u001cR\u0001TB.\u000f'\u0002BA\"'\bV%!qqKB;\u0005u\u0019\u0016P\u001c;bGRL7\rV=qK\u0006\u0003\b\u000f\\5fI\u0016CHO]1di>\u0014HCAD')\u0019!Yn\"\u0018\b`!9aq\u0001(A\u0002\u0011m\u0007bBD1\u001d\u0002\u0007aQD\u0001\u0006i\u0006\u0014xm\u001d\u000b\u0005\u000fK:I\u0007\u0005\u0004\u0004^\u0019Mvq\r\t\t\u0007;:9\u0003b7\u0007\u001e!9aqA(A\u0002\u0011m\u0017\u0001F*z]R\f7\r^5d\u0003B\u0004H.[3e)f\u0004X\rE\u0002\u0007\u001aF\u0013AcU=oi\u0006\u001cG/[2BaBd\u0017.\u001a3UsB,7#B)\u0004\\\u001dMCCAD7)\u0019!Ynb\u001e\bz!9aqA*A\u0002\u0011m\u0007bBD1'\u0002\u0007aQ\u0004\u000b\u0005\u000fK:i\bC\u0004\u0007\bQ\u0003\r\u0001b7\u0002!MKh\u000e^1di&\u001c\u0017\t\u001d9mS\u0016$\u0007c\u0001DM-\n\u00012+\u001f8uC\u000e$\u0018nY!qa2LW\rZ\n\u0006-\u000emsq\u0011\t\u0005\r3;I)\u0003\u0003\b\f\u000eU$!G*z]R\f7\r^5d\u0003B\u0004H.[3e\u000bb$(/Y2u_J$\"a\"!\u0015\r\u0011mw\u0011SDJ\u0011\u001d19\u0001\u0017a\u0001\t7DqA\"\u0010Y\u0001\u00041y\u0004\u0006\u0003\b\u0018\u001em\u0005CBB/\u000fC9I\n\u0005\u0005\u0004^\u001d\u001dB1\u001cD \u0011\u001d19!\u0017a\u0001\t7\fa!\u00168Di>\u0014\bc\u0001DM7\n1QK\\\"u_J\u001c2aWB.)\t9y\n\u0006\u0003\b*\u001e]\u0006CBB/\rg;Y\u000b\u0005\u0006\u0004^\u001d5v\u0011\u0017D\u0019\r;IAab,\u0004T\t1A+\u001e9mKN\u0002Baa\u001d\b4&!qQ\u0017Cq\u0005%iu\u000eZ5gS\u0016\u00148\u000fC\u0004\u0007\bu\u0003\r\u0001b7\u0003\u0019UsWj\u001b+f[Bd\u0017\r^3\u0014\u0007y\u001bY&A\u0006jg\u000e\u000b7/Z\"mCN\u001cH\u0003BDa\u000f\u0007\u00042A\"'_\u0011\u001d9i\f\u0019a\u0001\tS\"Bab2\bPB11Q\fDZ\u000f\u0013\u0004\u0002c!\u0018\bL\u001auaQGDY\rc1iB\"\b\n\t\u001d571\u000b\u0002\u0007)V\u0004H.\u001a\u001c\t\u000f\u001dE\u0017\r1\u0001\bT\u0006)A/Z7qYB!11ODk\u0013\u001199\u000e\"9\u0003\u0011Q+W\u000e\u001d7bi\u0016\fa!Y:DCN,WCADa\u00031)f.T6UK6\u0004H.\u0019;f!\r1I\nZ\n\u0004I\u001e\u0005GCADp\u0003)i7nU3mMRK\b/\u001a\u000b\u0005\rk9I\u000fC\u0004\u0007\b\u0019\u0004\r\u0001b7\u0002#MKh\u000e^1di&\u001c7\t\\1tg\u0012+g\rE\u0002\u0007\u001a\"\u0014\u0011cU=oi\u0006\u001cG/[2DY\u0006\u001c8\u000fR3g'\u0015A71LDz!\u00111Ij\">\n\t\u001d]8Q\u000f\u0002\u001b'ftG/Y2uS\u000e\u001cE.Y:t\t\u00164W\t\u001f;sC\u000e$xN\u001d\u000b\u0003\u000f[$Bc\"@\t\u0004!\u001d\u0001\u0012\u0002E\u0006\u0011\u001fA\t\u0002#\u0006\t\u0018!m\u0001\u0003BB:\u000f\u007fLA\u0001#\u0001\u0005b\nA1\t\\1tg\u0012+g\rC\u0004\t\u0006)\u0004\ra\"-\u0002\t5|Gm\u001d\u0005\b\u0007CS\u0007\u0019\u0001Dv\u0011\u001d1YH\u001ba\u0001\r;Aq\u0001#\u0004k\u0001\u00049\t,\u0001\u0006d_:\u001cHO]'pINDqa\"\fk\u0001\u00041y\u0004C\u0004\t\u0014)\u0004\rA\"\b\u0002\u0013\u0015\f'\u000f\\=EK\u001a\u001c\bbBC/U\u0002\u0007aQ\u0004\u0005\b\u00113Q\u0007\u0019\u0001Cn\u0003!\u0019X\r\u001c4UsB,\u0007b\u0002E\u000fU\u0002\u0007aQD\u0001\u0005E>$\u0017\u0010\u0006\u0003\t\"!%\u0002CBB/\rgC\u0019\u0003\u0005\f\u0004^!\u0015r\u0011\u0017Dv\rc:\tL\"\r\u0007\u001e\u0019uaQ\u0007D\u000f\u0013\u0011A9ca\u0015\u0003\rQ+\b\u000f\\3:\u0011\u001d19a\u001ba\u0001\t7\f\u0011cU=oi\u0006\u001cG/[2Ue\u0006LG\u000fR3g!\r1I*\u001c\u0002\u0012'ftG/Y2uS\u000e$&/Y5u\t\u001647#B7\u0004\\!M\u0002\u0003\u0002DM\u0011kIA\u0001c\u000e\u0004v\tQ2+\u001f8uC\u000e$\u0018n\u0019+sC&$H)\u001a4FqR\u0014\u0018m\u0019;peR\u0011\u0001R\u0006\u000b\u0011\u000f{Di\u0004c\u0010\tB!\r\u0003R\tE$\u0011\u0013Bq\u0001#\u0002p\u0001\u00049\t\fC\u0004\u0004\">\u0004\rAb;\t\u000f\u0019mt\u000e1\u0001\u0007\u001e!9\u00012C8A\u0002\u0019u\u0001bBC/_\u0002\u0007aQ\u0004\u0005\b\u00113y\u0007\u0019\u0001Cn\u0011\u001dAib\u001ca\u0001\r;!B\u0001#\u0014\tVA11Q\fDZ\u0011\u001f\u0002\"c!\u0018\tR\u001dEf1\u001eD9\r;1iB\"\u000e\u0007\u001e%!\u00012KB*\u0005\u0019!V\u000f\u001d7fo!9aq\u00019A\u0002\u0011m\u0017AE*z]R\f7\r^5d\u001f\nTWm\u0019;EK\u001a\u00042A\"'s\u0005I\u0019\u0016P\u001c;bGRL7m\u00142kK\u000e$H)\u001a4\u0014\u000bI\u001cY\u0006c\u0018\u0011\t\u0019e\u0005\u0012M\u0005\u0005\u0011G\u001a)HA\u000eTs:$\u0018m\u0019;jG>\u0013'.Z2u\t\u00164W\t\u001f;sC\u000e$xN\u001d\u000b\u0003\u00113\"b\u0002#\u001b\tp!E\u00042\u000fE;\u0011oBI\b\u0005\u0003\u0004t!-\u0014\u0002\u0002E7\tC\u0014\u0011\"T8ek2,G)\u001a4\t\u000f!\u0015A\u000f1\u0001\b2\"91\u0011\u0015;A\u0002\u0019m\u0007b\u0002E\ni\u0002\u0007aQ\u0004\u0005\b\u000b;\"\b\u0019\u0001D\u000f\u0011\u001dAI\u0002\u001ea\u0001\t7Dq\u0001#\bu\u0001\u00041i\u0002\u0006\u0003\t~!\u0005\u0005CBB/\rgCy\b\u0005\t\u0004^\u001d-w\u0011\u0017Dn\r;1iB\"\u000e\u0007\u001e!9aqA;A\u0002\u0011m\u0017!G*z]R\f7\r^5d!\u0006\u001c7.Y4f\u001f\nTWm\u0019;EK\u001a\u00042A\"'x\u0005e\u0019\u0016P\u001c;bGRL7\rU1dW\u0006<Wm\u00142kK\u000e$H)\u001a4\u0014\u000b]\u001cY\u0006c#\u0011\t\u0019e\u0005RR\u0005\u0005\u0011\u001f\u001b)H\u0001\u0012Ts:$\u0018m\u0019;jGB\u000b7m[1hK>\u0013'.Z2u\t\u00164W\t\u001f;sC\u000e$xN\u001d\u000b\u0003\u0011\u000b#B\u0002#&\t\u001c\"u\u0005r\u0014EQ\u0011G\u0003Baa\u001d\t\u0018&!\u0001\u0012\u0014Cq\u0005)\u0001\u0016mY6bO\u0016$UM\u001a\u0005\b\u0007CK\b\u0019\u0001Dn\u0011\u001dA\u0019\"\u001fa\u0001\r;Aq!\"\u0018z\u0001\u00041i\u0002C\u0004\t\u001ae\u0004\r\u0001b7\t\u000f!u\u0011\u00101\u0001\u0007\u001eQ!\u0001r\u0015EX!\u0019\u0019iFb-\t*Bq1Q\fEV\r74iB\"\b\u00076\u0019u\u0011\u0002\u0002EW\u0007'\u0012a\u0001V;qY\u0016,\u0004b\u0002D\u0004u\u0002\u0007A1\u001c\u0002\u000f'\u000e\fG.Y'f[\n,'OU3g'\rY81L\u0001\bgfl'm\u001c7t!\u0019!9\u000b#/\u0004\u001a&!\u00012\u0018CY\u0005\r\u0019V-\u001d\u000b\u0005\u0011\u007fC\t\rE\u0002\u0007\u001anDq\u0001#.~\u0001\u0004A9,\u0001\u0004sKN,H\u000e\u001e\u000b\u0005\u0011\u000fDI\r\u0005\u0004\u0004^\u0019M6\u0011\u0014\u0005\b\u0007Cs\b\u0019ABh)\u0011A9\r#4\t\u000f\u0019\u001dq\u00101\u0001\u0005\\\u0006iA+\u001e9mK\u000ec\u0017m]:SK\u001a\u0004BA\"'\u0002\u0004\tiA+\u001e9mK\u000ec\u0017m]:SK\u001a\u001cB!a\u0001\t@R\u0011\u0001\u0012[\u0001\u0012)V\u0004H.Z\"p[B\fg.[8o%\u00164\u0007\u0003\u0002DM\u0003\u0013\u0011\u0011\u0003V;qY\u0016\u001cu.\u001c9b]&|gNU3g'\u0011\tI\u0001c0\u0015\u0005!m\u0017\u0001D+oSR\u001cE.Y:t%\u00164\u0007\u0003\u0002DM\u0003\u001f\u0011A\"\u00168ji\u000ec\u0017m]:SK\u001a\u001cB!a\u0004\t@R\u0011\u0001R]\u0001\u0011\rVt7\r^5p]\u000ec\u0017m]:SK\u001a\u0004BA\"'\u0002\u0016\t\u0001b)\u001e8di&|gn\u00117bgN\u0014VMZ\n\u0005\u0003+Ay\f\u0006\u0002\tp\u0006q1+\u001f8uC\u000e$\u0018n\u0019+va2,\u0007\u0003\u0002DM\u00037\u0011abU=oi\u0006\u001cG/[2UkBdWm\u0005\u0004\u0002\u001c\rm\u0003r \t\u0005\r3K\t!\u0003\u0003\n\u0004\rU$aF*z]R\f7\r^5d)V\u0004H.Z#yiJ\f7\r^8s)\tAI\u0010\u0006\u0003\u0005\\&%\u0001\u0002CC'\u0003?\u0001\rA\"\b\u0015\t%5\u0011r\u0002\t\u0007\u0007;2\u0019L\"\b\t\u0011\u0019\u001d\u0011\u0011\u0005a\u0001\t7\f!cU=oi\u0006\u001cG/[2UkBdW\rV=qKB!a\u0011TA\u0013\u0005I\u0019\u0016P\u001c;bGRL7\rV;qY\u0016$\u0016\u0010]3\u0014\r\u0005\u001521\fE\u0000)\tI\u0019\u0002\u0006\u0003\u0005\\&u\u0001\u0002CC'\u0003S\u0001\rA\"\b\u0015\t%5\u0011\u0012\u0005\u0005\t\r\u000f\tY\u00031\u0001\u0005\\\u0006)2+\u001f8uC\u000e$\u0018n\u0019$v]\u000e$\u0018n\u001c8UsB,\u0007\u0003\u0002DM\u0003_\u0011QcU=oi\u0006\u001cG/[2Gk:\u001cG/[8o)f\u0004Xm\u0005\u0004\u00020\rm\u00132\u0006\t\u0005\r3Ki#\u0003\u0003\n0\rU$AH*z]R\f7\r^5d\rVt7\r^5p]RK\b/Z#yiJ\f7\r^8s)\tI)\u0003\u0006\u0004\u0005\\&U\u0012\u0012\b\u0005\t\u0013o\t\u0019\u00041\u0001\u0007\u001e\u00059\u0011M]4ua\u0016\u001c\b\u0002CE\u001e\u0003g\u0001\r\u0001b7\u0002\rI,7\u000f\u001e9f)\u0011Iy$c\u0011\u0011\r\ruc1WE!!!\u0019ifb\n\u0007\u001e\u0011m\u0007\u0002\u0003D\u0004\u0003k\u0001\r\u0001b7\u0002\u001bMKh\u000e\u001e5fi&\u001cWK\\5u!\u00111I*!\u000f\u0003\u001bMKh\u000e\u001e5fi&\u001cWK\\5u'\u0011\tIda\u0017\u0015\u0005%\u001dC\u0003\u0002C5\u0013#B\u0001Bb\u0002\u0002>\u0001\u0007A1\\\u0001\u000f'ftG/Y2uS\u000e\u0014En\\2l!\u00111I*!\u0011\u0003\u001dMKh\u000e^1di&\u001c'\t\\8dWN1\u0011\u0011IB.\u00137\u0002BA\"'\n^%!\u0011rLB;\u0005]\u0019\u0016P\u001c;bGRL7M\u00117pG.,\u0005\u0010\u001e:bGR|'\u000f\u0006\u0002\nVQ!A1\\E3\u0011!1I)!\u0012A\u0002\u0019uA\u0003BE\u0007\u0013SB\u0001Bb\u0002\u0002H\u0001\u0007A1\\\u0001\u0012'ftG/Y2uS\u000e4UO\\2uS>t\u0007\u0003\u0002DM\u0003\u0017\u0012\u0011cU=oi\u0006\u001cG/[2Gk:\u001cG/[8o'\u0019\tYea\u0017\ntA!a\u0011TE;\u0013\u0011I9h!\u001e\u00035MKh\u000e^1di&\u001cg)\u001e8di&|g.\u0012=ue\u0006\u001cGo\u001c:\u0015\u0005%5DCBE?\u0013\u0007K)\t\u0005\u0003\u0004t%}\u0014\u0002BEA\tC\u0014\u0001BR;oGRLwN\u001c\u0005\t\u000b\u0007\u000by\u00051\u0001\u0007\u001e!A\u0001RDA(\u0001\u0004!Y\u000e\u0006\u0003\n\n&5\u0005CBB/\rgKY\t\u0005\u0005\u0004^\u001d\u001db1\u0007Cn\u0011!19!!\u0015A\u0002%u\u0014\u0001D*z]R\f7\r^5d\u001d\u0016<\b\u0003\u0002DM\u0003+\u0012AbU=oi\u0006\u001cG/[2OK^\u001cb!!\u0016\u0004\\%]\u0005\u0003\u0002DM\u00133KA!c'\u0004v\t)2+\u001f8uC\u000e$\u0018n\u0019(fo\u0016CHO]1di>\u0014HCAEI))!Y.#)\n$&\u0015\u0016r\u0015\u0005\t\u0011'\tI\u00061\u0001\u0007\u001e!AQQLA-\u0001\u00041i\u0002\u0003\u0005\t\u001a\u0005e\u0003\u0019\u0001Cn\u0011!Ai\"!\u0017A\u0002\u0019uA\u0003BEV\u0013g\u0003ba!\u0018\u00074&5\u0006\u0003DB/\u0013_3iB\"\b\u00076\u0019u\u0011\u0002BEY\u0007'\u0012a\u0001V;qY\u0016$\u0004\u0002\u0003D\u0004\u00037\u0002\r\u0001b7\u0002\u001fMKh\u000e^1di&\u001cG)\u001a4EK\u001a\u0004BA\"'\u0002`\ty1+\u001f8uC\u000e$\u0018n\u0019#fM\u0012+gm\u0005\u0004\u0002`\rm\u0013R\u0018\t\u0005\r3Ky,\u0003\u0003\nB\u000eU$\u0001G*z]R\f7\r^5d\t\u00164G)\u001a4FqR\u0014\u0018m\u0019;peR\u0011\u0011r\u0017\u000b\u000f\u0013\u000fLi-c4\nR&M\u0017R[Em!\u0011\u0019\u0019(#3\n\t%-G\u0011\u001d\u0002\u0007\t\u00164G)\u001a4\t\u0011!\u0015\u00111\ra\u0001\u000fcC\u0001b!)\u0002d\u0001\u0007a1\u001c\u0005\t\rw\n\u0019\u00071\u0001\u0007\u001e!AqQFA2\u0001\u00041y\u0004\u0003\u0005\nX\u0006\r\u0004\u0019\u0001Cn\u0003\r!\b\u000f\u001e\u0005\t\u00137\f\u0019\u00071\u0001\u0005\\\u0006\u0019!\u000f[:\u0015\t%}\u00172\u001d\t\u0007\u0007;2\u0019,#9\u0011!\rus1ZDY\r74\tH\"\r\u0005\\\u0012m\u0007\u0002\u0003D\u0004\u0003K\u0002\r\u0001b7\u0003'MKh\u000e^1di&\u001cg+\u00197EK\u001a\u0014\u0015m]3\u0014\r\u0005\u001d41LEu!\u00111I*c;\n\t%58Q\u000f\u0002\u0019'ftG/Y2uS\u000e4\u0016\r\u001c#fM\u0016CHO]1di>\u0014\u0018!C5t\u001bV$\u0018M\u00197f)\u0011I\u00190#>\u0011\t\u0019e\u0015q\r\u0005\t\u0013_\fY\u00071\u0001\u0005j\u0005IQn\u001c3jM&,'o\u001d\u000b\u0005\u000fcKY\u0010\u0003\u0005\t\u0006\u00055\u0004\u0019ADY))1)$c@\u000b\u0002)\r!R\u0001\u0005\t\u0011\u000b\ty\u00071\u0001\b2\"A1\u0011UA8\u0001\u00041Y\u000e\u0003\u0005\nX\u0006=\u0004\u0019\u0001Cn\u0011!IY.a\u001cA\u0002\u0011mG\u0003\u0002F\u0005\u0015\u001b\u0001ba!\u0018\u00074*-\u0001\u0003DB/\u0013_;\tLb7\u0005\\\u0012m\u0007\u0002\u0003D\u0004\u0003c\u0002\r\u0001b7\u0002\u001fMKh\u000e^1di&\u001cg+\u00197EK\u001a\u0004BA\"'\u0002v\ty1+\u001f8uC\u000e$\u0018n\u0019,bY\u0012+gm\u0005\u0003\u0002v%MHC\u0001F\t\u0003=\u0019\u0016P\u001c;bGRL7MV1s\t\u00164\u0007\u0003\u0002DM\u0003w\u0012qbU=oi\u0006\u001cG/[2WCJ$UMZ\n\u0005\u0003wJ\u0019\u0010\u0006\u0002\u000b\u001c\u0005y1+\u001f8uC\u000e$\u0018nY!tg&<g\u000e\u0005\u0003\u0007\u001a\u0006\u0005%aD*z]R\f7\r^5d\u0003N\u001c\u0018n\u001a8\u0014\r\u0005\u000551\fF\u0016!\u00111IJ#\f\n\t)=2Q\u000f\u0002\u0019'ftG/Y2uS\u000e\f5o]5h]\u0016CHO]1di>\u0014HC\u0001F\u0013)\u0019!YN#\u000e\u000b:!A!rGAC\u0001\u0004!Y.A\u0002mQND\u0001\"c7\u0002\u0006\u0002\u0007A1\u001c\u000b\u0005\u0015{Q\t\u0005\u0005\u0004\u0004^\u0019M&r\b\t\t\u0007;:9\u0003b7\u0005\\\"AaqAAD\u0001\u0004!Y.A\u000bV]2Lg\r\u001e'jgR,E.Z7f]R<\u0018n]3\u0016\t)\u001d#r\u000b\u000b\u0005\u0015\u0013RYF\u0005\u0004\u000bL\rm#r\n\u0004\b\u0015\u001b\nI\t\u0001F%\u00051a$/\u001a4j]\u0016lWM\u001c;?!\u00191IJ#\u0015\u000bV%!!2KB;\u0005U)f\u000e\\5gi2K7\u000f^#mK6,g\u000e^<jg\u0016\u0004B\u0001b$\u000bX\u0011Aa\u0011AAE\u0005\u0004QI&\u0005\u0003\u0005\u0018\u0012\u001d\u0001\u0002\u0003F/\u0003\u0013\u0003\rAc\u0018\u0002\u0015UtG.\u001b4uC\ndW\r\u0005\u0004\u0004t)\u0005$RK\u0005\u0005\u0015GR)G\u0001\u0006V]2Lg\r^1cY\u0016LAAc\u001a\u0004~\tIA*\u001b4uC\ndWm]\u0001\u001d+:d\u0017N\u001a;MSN$xJ\u001a'jgR\u001cX\t\\3nK:$x/[:f+\u0011QiGc\u001f\u0015\t)=$R\u0010\n\u0007\u0015c\u001aYFc\u001d\u0007\u000f)5\u00131\u0012\u0001\u000bpA1a\u0011\u0014F;\u0015sJAAc\u001e\u0004v\taRK\u001c7jMRd\u0015n\u001d;PM2K7\u000f^:FY\u0016lWM\u001c;xSN,\u0007\u0003\u0002CH\u0015w\"\u0001B\"\u0001\u0002\f\n\u0007!\u0012\f\u0005\t\u0015;\nY\t1\u0001\u000b\u0000A111\u000fF1\u0015s\n\u0001cU=oi\u0006\u001cG/[2WC24%o\\7\u0011\t\u0019e\u0015q\u0012\u0002\u0011'ftG/Y2uS\u000e4\u0016\r\u001c$s_6\u001cb!a$\u0004\\)%\u0005\u0003\u0002DM\u0015\u0017KAA#$\u0004v\tI2+\u001f8uC\u000e$\u0018n\u0019,bY\u001a\u0013x.\\#yiJ\f7\r^8s)\tQ\u0019\t\u0006\u0004\u0005\\*M%r\u0013\u0005\t\u0015+\u000b\u0019\n1\u0001\u0005\\\u0006\u0019\u0001/\u0019;\t\u0011%m\u00171\u0013a\u0001\t7$BA#\u0010\u000b\u001c\"AaqAAK\u0001\u0004!Y.\u0001\bTs:$\u0018m\u0019;jGZ\u000bG.R9\u0011\t\u0019e\u0015\u0011\u0014\u0002\u000f'ftG/Y2uS\u000e4\u0016\r\\#r'\u0019\tIja\u0017\u000b&B!a\u0011\u0014FT\u0013\u0011QIk!\u001e\u0003/MKh\u000e^1di&\u001cg+\u00197Fc\u0016CHO]1di>\u0014HC\u0001FP)\u0019!YNc,\u000b2\"A!RSAO\u0001\u0004!Y\u000e\u0003\u0005\n\\\u0006u\u0005\u0019\u0001Cn)\u0011QiD#.\t\u0011\u0019\u001d\u0011q\u0014a\u0001\t7\fqbU=oi\u0006\u001cG/[2GS2$XM\u001d\t\u0005\r3\u000b\u0019KA\bTs:$\u0018m\u0019;jG\u001aKG\u000e^3s'\u0019\t\u0019ka\u0017\u000b@B!a\u0011\u0014Fa\u0013\u0011Q\u0019m!\u001e\u00031MKh\u000e^1di&\u001cg)\u001b7uKJ,\u0005\u0010\u001e:bGR|'\u000f\u0006\u0002\u000b:R!A1\u001cFe\u0011!19!a*A\u0002\u0011mG\u0003\u0002Fg\u0015\u001f\u0004ba!\u0018\u00074\u0012m\u0007\u0002\u0003D\u0004\u0003S\u0003\r\u0001b7\u0002-MKh\u000e^1di&\u001cW)\u001c9usRK\b/\u001a+sK\u0016\u0004BA\"'\u0002.\n12+\u001f8uC\u000e$\u0018nY#naRLH+\u001f9f)J,Wm\u0005\u0004\u0002.\u000em#\u0012\u001c\t\u0005\r3SY.\u0003\u0003\u000b^\u000eU$aH*z]R\f7\r^5d\u000b6\u0004H/\u001f+za\u0016$&/Z3FqR\u0014\u0018m\u0019;peR\u0011!2\u001b\u000b\u0003\u000b\u000f!B\u0001\"\u001b\u000bf\"A!r]AZ\u0001\u0004)9!\u0001\u0002ui\u0006AQK\u001c)biN+\u0017\u000f\u0005\u0003\u0007\u001a\u0006]&\u0001C+o!\u0006$8+Z9\u0014\t\u0005]61\f\u000b\u0003\u0015W$BA#>\u000bzB11Q\fDZ\u0015o\u0004b\u0001b*\u0005.*}\u0002\u0002\u0003D\u0016\u0003w\u0003\rA\"\b\u0002\u001d%l\u0007\u000f\\8eKB\u000bG\u000fR3ggB!a\u0011TA`\u00059IW\u000e\u001d7pI\u0016\u0004\u0016\r\u001e#fMN\u001cB!a0\f\u0004A!11OF\u0003\u0013\u0011Y9a#\u0003\u0003\u0017Q\u0013\u0018M\\:g_JlWM]\u0005\u0005\tG\u001ci\b\u0006\u0002\u000b~\u0006IAO]1og\u001a|'/\u001c\u000b\u0005\t7\\\t\u0002\u0003\u0005\u0007\b\u0005\r\u0007\u0019\u0001Cn\u00039!(/\u00198tM>\u0014Xn\u0015;biN$BA\"\b\f\u0018!Aa1FAc\u0001\u00041i\u0002\u0006\u0003\u0005\\.m\u0001\u0002\u0003D\u0004\u0003\u000f\u0004\r\u0001b7\u0015\t\u0019u1r\u0004\u0005\t\rW\tI\r1\u0001\u0007\u001e\u0005y1+\u001f8uC\u000e$\u0018n\u0019)bi\u0012+g\r\u0005\u0003\u0007\u001a\u00065'aD*z]R\f7\r^5d!\u0006$H)\u001a4\u0014\r\u0005571LF\u0015!\u00111Ijc\u000b\n\t-52Q\u000f\u0002\u0019'ftG/Y2uS\u000e\u0004\u0016\r\u001e#fM\u0016CHO]1di>\u0014HCAF\u0012))1\u0019dc\r\f6-]2\u0012\b\u0005\t\u0011\u000b\t\t\u000e1\u0001\b2\"A!RSAi\u0001\u0004!Y\u000e\u0003\u0005\nX\u0006E\u0007\u0019\u0001Cn\u0011!IY.!5A\u0002\u0011mG\u0003BF\u001f\u0017\u0003\u0002ba!\u0018\u00074.}\u0002\u0003DB/\u0013_;\t\fb7\u0005\\\u0012m\u0007\u0002\u0003D\u0004\u0003'\u0004\r\u0001b7\u0002\u001fUs\u0007+\u0019;TKF<\u0016\u000e\u001e5SKN\u0004BA\"'\u0002X\nyQK\u001c)biN+\u0017oV5uQJ+7o\u0005\u0003\u0002X\u000emCCAF#)\u0011Yyec\u0015\u0011\r\ruc1WF)!!\u0019ifb\n\u000bx\u001au\u0001\u0002\u0003D\u0004\u00037\u0004\r\u0001b7\u0002!Us7+\u001f8uQ\u0016$\u0018n\u0019)be\u0006l\u0007\u0003\u0002DM\u0003?\u0014\u0001#\u00168Ts:$\b.\u001a;jGB\u000b'/Y7\u0014\t\u0005}71\f\u000b\u0003\u0017/\"Ba#\u0019\fdA11Q\fDZ\r7D\u0001Bb\u0002\u0002d\u0002\u0007A1\\\u0001\n+:4\u0016n]5u_J\u0004BA\"'\u0002h\nIQK\u001c,jg&$xN]\n\u0005\u0003O\u001cY\u0006\u0006\u0002\fhQ!1\u0012OF?!\u0019\u0019iFb-\ftAA1QLD\u0014\r7\\)\b\u0005\u0004\u0005(\u001256r\u000f\t\u0005\u0007gZI(\u0003\u0003\f|\u0011\u0005(aB\"bg\u0016$UM\u001a\u0005\t\r\u000f\tY\u000f1\u0001\u0005\\\u0006IQK\\\"m_N,(/\u001a\t\u0005\r3\u000byOA\u0005V]\u000ecwn];sKN!\u0011q^B.)\tY\t\t\u0006\u0003\u000b>--\u0005\u0002\u0003D\u0004\u0003g\u0004\r\u0001b7\u0002\u0015\u0019KG\u000e^3s\u0007\u0006dG\u000e\u0005\u0003\u0007\u001a\u0006](A\u0003$jYR,'oQ1mYN!\u0011q_B.)\tYy\t\u0006\u0003\u000b>-e\u0005\u0002\u0003D\u0004\u0003w\u0004\r\u0001b7\u0002\u0011Usg)\u001b7uKJ\u0004BA\"'\u0002\u0000\nAQK\u001c$jYR,'o\u0005\u0003\u0002\u0000\u000emCCAFO)\u0011Y9k#+\u0011\r\rus\u0011ED4\u0011!19Aa\u0001A\u0002\u0011m\u0017AE+o\u0007\",7m[%g%\u00164W\u000f^1cY\u0016\u0004BA\"'\u0003\b\t\u0011RK\\\"iK\u000e\\\u0017J\u001a*fMV$\u0018M\u00197f'\u0011\u00119aa\u0017\u0015\u0005-5F\u0003\u0002F\u001f\u0017oC\u0001Bb\u0002\u0003\f\u0001\u0007A1\u001c\u0002\u0011+:4uN]\"p[\nLg.\u0019;j_:\u001cBA!\u0004\u0004\\Q!1rXFa!\u00111IJ!\u0004\t\u0011\r\u0005&\u0011\u0003a\u0001\r7$BA#\u0010\fF\"Aaq\u0001B\n\u0001\u0004!Y.A\u0003V]6\u000b\u0007\u000f\u0005\u0003\u0007\u001a\n]!!B+o\u001b\u0006\u00048\u0003\u0002B\f\u0017\u007f#\"a#3\u0002\u0013Usgi\u001c:fC\u000eD\u0007\u0003\u0002DM\u0005;\u0011\u0011\"\u00168G_J,\u0017m\u00195\u0014\t\tu1r\u0018\u000b\u0003\u0017'\f\u0011\"\u00168GY\u0006$X*\u00199\u0011\t\u0019e%1\u0005\u0002\n+:4E.\u0019;NCB\u001cBAa\t\f@R\u00111R\\\u0001\u0006+:4uN\u001d\t\u0005\r3\u0013ICA\u0003V]\u001a{'o\u0005\u0003\u0003*\rmCCAFt)\u0011Iyd#=\t\u0011\u0019\u001d!Q\u0006a\u0001\t7\fQ\"\\6F]VlWM]1u_J\u001cH\u0003\u0002D\u000f\u0017oD\u0001b#?\u00030\u0001\u0007aQD\u0001\u0006K:,Xn]\u0001\r'ftG/Y2uS\u000e4uN\u001d\t\u0005\r3\u0013\u0019D\u0001\u0007Ts:$\u0018m\u0019;jG\u001a{'o\u0005\u0004\u00034\rmC2\u0001\t\u0005\r3c)!\u0003\u0003\r\b\rU$!F*z]R\f7\r^5d\r>\u0014X\t\u001f;sC\u000e$xN\u001d\u000b\u0003\u0017{$b\u0001b7\r\u000e1=\u0001\u0002CF}\u0005o\u0001\rA\"\b\t\u0011!u!q\u0007a\u0001\t7$B!c\u0010\r\u0014!Aaq\u0001B\u001d\u0001\u0004!Y.A\tTs:$\u0018m\u0019;jG\u001a{'/W5fY\u0012\u0004BA\"'\u0003>\t\t2+\u001f8uC\u000e$\u0018n\u0019$pefKW\r\u001c3\u0014\r\tu21\fG\u0002)\ta9\u0002\u0006\u0004\u0005\\2\u0005B2\u0005\u0005\t\u0017s\u0014\t\u00051\u0001\u0007\u001e!A\u0001R\u0004B!\u0001\u0004!Y\u000e\u0006\u0003\n@1\u001d\u0002\u0002\u0003D\u0004\u0005\u0007\u0002\r\u0001b7\u0002+5\u000b\u0017PY3UsB,GK]3f\u001fJLw-\u001b8bYB!a\u0011\u0014B$\u0005Ui\u0015-\u001f2f)f\u0004X\r\u0016:fK>\u0013\u0018nZ5oC2\u001cBAa\u0012\u0004\\Q\u0011A2\u0006\u000b\u0005\u0019ka9\u0004\u0005\u0004\u0004^\u001d\u0005B1\u001c\u0005\t\r\u000f\u0011Y\u00051\u0001\u0005\\\u0006\u0001R*Y=cKN+G.Z2u\u0003B\u0004H.\u001f\t\u0005\r3\u0013yE\u0001\tNCf\u0014WmU3mK\u000e$\u0018\t\u001d9msN!!qJB.)\taY\u0004\u0006\u0003\r61\u0015\u0003\u0002\u0003D\u0004\u0005'\u0002\r\u0001b7\u0002\u001d5\u000b\u0017PY3V]\u000eDWmY6fIB!a\u0011\u0014B,\u00059i\u0015-\u001f2f+:\u001c\u0007.Z2lK\u0012\u001cBAa\u0016\u0004\\Q\u0011A\u0012\n\u000b\u0005\u0019ka\u0019\u0006\u0003\u0005\u0007\b\tm\u0003\u0019\u0001Cn\u0003)i\u0015-\u001f2f)f\u0004X\r\u001a\t\u0005\r3\u0013yF\u0001\u0006NCf\u0014W\rV=qK\u0012\u001cBAa\u0018\u0004\\Q\u0011Ar\u000b\u000b\u0005\u0019Cb\u0019\u0007\u0005\u0004\u0004^\u001d\u0005\"r\b\u0005\t\r\u000f\u0011\u0019\u00071\u0001\u0005\\\u00069Qn[\"bg\u0016\u001cH\u0003BF;\u0019SB\u0001\u0002d\u001b\u0003f\u0001\u0007aQD\u0001\u0006G\u0006\u001cXm]\u0001\u0019'ftG/Y2uS\u000e\u0004\u0016M\u001d;jC24UO\\2uS>t\u0007\u0003\u0002DM\u0005S\u0012\u0001dU=oi\u0006\u001cG/[2QCJ$\u0018.\u00197Gk:\u001cG/[8o'\u0019\u0011Iga\u0017\rvA!a\u0011\u0014G<\u0013\u0011aIh!\u001e\u0003CMKh\u000e^1di&\u001c\u0007+\u0019:uS\u0006dg)\u001e8di&|g.\u0012=ue\u0006\u001cGo\u001c:\u0015\u00051=D\u0003\u0002G@\u0019\u000b\u0003Baa\u001d\r\u0002&!A2\u0011Cq\u0005\u0015i\u0015\r^2i\u0011!aYG!\u001cA\u0002\u0019uA\u0003\u0002GE\u0019\u0017\u0003ba!\u0018\u00074.U\u0004\u0002\u0003D\u0004\u0005_\u0002\r\u0001b7\u0002\u001dMKh\u000e^1di&\u001cW*\u0019;dQB!a\u0011\u0014B:\u00059\u0019\u0016P\u001c;bGRL7-T1uG\"\u001cbAa\u001d\u0004\\1U\u0005\u0003\u0002DM\u0019/KA\u0001$'\u0004v\t92+\u001f8uC\u000e$\u0018nY'bi\u000eDW\t\u001f;sC\u000e$xN\u001d\u000b\u0003\u0019\u001f#b\u0001d \r 2\r\u0006\u0002\u0003GQ\u0005o\u0002\r\u0001b7\u0002\u0013M\u001c'/\u001e;j]\u0016,\u0007\u0002\u0003G6\u0005o\u0002\rA\"\b\u0015\t1\u001dF2\u0016\t\u0007\u0007;2\u0019\f$+\u0011\u0011\rusq\u0005Cn\u0017kB\u0001Bb\u0002\u0003z\u0001\u0007ArP\u0001\r'ftG/Y2uS\u000e$&/\u001f\t\u0005\r3\u0013iH\u0001\u0007Ts:$\u0018m\u0019;jGR\u0013\u0018p\u0005\u0004\u0003~\rmCR\u0017\t\u0005\r3c9,\u0003\u0003\r:\u000eU$!F*z]R\f7\r^5d)JLX\t\u001f;sC\u000e$xN\u001d\u000b\u0003\u0019_#\u0002\u0002d0\rF2%GR\u001a\t\u0005\u0007gb\t-\u0003\u0003\rD\u0012\u0005(a\u0001+ss\"AAr\u0019BA\u0001\u0004!Y.A\u0003cY>\u001c7\u000e\u0003\u0005\rL\n\u0005\u0005\u0019\u0001D\u000f\u0003\u001d\u0019\u0017\r^2iKND\u0001\u0002d4\u0003\u0002\u0002\u0007A1\\\u0001\nM&t\u0017\r\\5{KJ$B\u0001d5\rXB11Q\fDZ\u0019+\u0004\"b!\u0018\b.\u0012m7R\u000fCn\u0011!19Aa!A\u00021}\u0016AE*z]R\f7\r^5d)\u0016\u0014X.\u00133f]R\u0004BA\"'\u0003\b\n\u00112+\u001f8uC\u000e$\u0018n\u0019+fe6LE-\u001a8u'\u0019\u00119ia\u0017\rbB!a\u0011\u0014Gr\u0013\u0011a)o!\u001e\u00037MKh\u000e^1di&\u001cG+\u001a:n\u0013\u0012,g\u000e^#yiJ\f7\r^8s)\taY\u000e\u0006\u0004\u0005|2-HR\u001e\u0005\t\u0007C\u0013Y\t1\u0001\u0007\\\"QAr\u001eBF!\u0003\u0005\r\u0001\"\u001b\u0002\u0019%\u001c()Y2lcV|G/\u001a3\u0015\t1MHr\u001f\t\u0007\u0007;2\u0019\f$>\u0011\u0011\rusq\u0005Dn\tSB\u0001\u0002$?\u0003\u000e\u0002\u0007A1`\u0001\u0003S\u0012\f!cU=oi\u0006\u001cG/[2UsB,\u0017\nZ3oiB!a\u0011\u0014BI\u0005I\u0019\u0016P\u001c;bGRL7\rV=qK&#WM\u001c;\u0014\r\tE51LG\u0002!\u00111I*$\u0002\n\t5\u001d1Q\u000f\u0002\u001c'ftG/Y2uS\u000e$\u0016\u0010]3JI\u0016tG/\u0012=ue\u0006\u001cGo\u001c:\u0015\u00051uH\u0003\u0002C~\u001b\u001bA\u0001b!)\u0003\u0016\u0002\u0007a1\u001e\u000b\u0005\u001b#i\u0019\u0002\u0005\u0004\u0004^\u0019Mf1\u001e\u0005\t\r\u000f\u00119\n1\u0001\u0005\\\u0006y1+\u001f8uC\u000e$\u0018nY%na>\u0014H\u000f\u0005\u0003\u0007\u001a\nm%aD*z]R\f7\r^5d\u00136\u0004xN\u001d;\u0014\r\tm51LG\u000f!\u00111I*d\b\n\t5\u00052Q\u000f\u0002\u0019'ftG/Y2uS\u000eLU\u000e]8si\u0016CHO]1di>\u0014HCAG\f\u0003A9\u0016\u000e\u001c3dCJ$7+\u001a7fGR|'\u000f\u0005\u0003\u000e*\t\u0005VB\u0001BN\u0005A9\u0016\u000e\u001c3dCJ$7+\u001a7fGR|'o\u0005\u0003\u0003\"\u000emCCAG\u0014)\u0011i\u0019$$\u000f\u0011\t\rMTRG\u0005\u0005\u001bo!\tO\u0001\bJ[B|'\u000f^*fY\u0016\u001cGo\u001c:\t\u00115m\"Q\u0015a\u0001\u0007W\faa\u001c4gg\u0016$H\u0003BG \u001b\u0003\u0002ba!\u0018\u00074\u000e-\b\u0002CG\"\u0005O\u0003\r!d\r\u0002\u0007M,G.\u0001\u0007OC6,7+\u001a7fGR|'\u000f\u0005\u0003\u000e*\t-&\u0001\u0004(b[\u0016\u001cV\r\\3di>\u00148\u0003\u0002BV\u00077\"\"!d\u0012\u0015\r5MR\u0012KG*\u0011!\u0019\tKa,A\u0002\u0019m\u0007\u0002CG\u001e\u0005_\u0003\raa;\u0015\t5]S2\f\t\u0007\u0007;2\u0019,$\u0017\u0011\u0011\rusq\u0005Dn\u0007WD\u0001\"d\u0011\u00032\u0002\u0007Q2G\u0001\u000f%\u0016t\u0017-\\3TK2,7\r^8s!\u0011iIC!.\u0003\u001dI+g.Y7f'\u0016dWm\u0019;peN!!QWB.)\tiy\u0006\u0006\u0006\u000e45%TRNG9\u001bkB\u0001\"d\u001b\u0003:\u0002\u0007a1\\\u0001\u0006]\u0006lW-\r\u0005\t\u001b_\u0012I\f1\u0001\u0004l\u00069qN\u001a4tKR\f\u0004\u0002CG:\u0005s\u0003\rAb7\u0002\u000b9\fW.\u001a\u001a\t\u00115]$\u0011\u0018a\u0001\u0007W\fqa\u001c4gg\u0016$(\u0007\u0006\u0003\u000e|5}\u0004CBB/\rgki\b\u0005\u0007\u0004^%=f1\\Bv\r7\u001cY\u000f\u0003\u0005\u000eD\tm\u0006\u0019AG\u001a\u0003A)f.[7q_J$8+\u001a7fGR|'\u000f\u0005\u0003\u000e*\t}&\u0001E+oS6\u0004xN\u001d;TK2,7\r^8s'\u0011\u0011yla\u0017\u0015\u00055\rECBG\u001a\u001b\u001bky\t\u0003\u0005\u0004\"\n\r\u0007\u0019\u0001Dn\u0011!iYDa1A\u0002\r-H\u0003BG,\u001b'C\u0001\"d\u0011\u0003F\u0002\u0007Q2G\u0001\u0015/&dGmY1sIN+G.Z2u_J\u0014V\r\u001d:\u0011\t5%\"\u0011\u001a\u0002\u0015/&dGmY1sIN+G.Z2u_J\u0014V\r\u001d:\u0014\t\t%71\f\u000b\u0003\u001b/#B\u0001b7\u000e\"\"AAq\u000bBg\u0001\u0004!I\u0006\u0006\u0003\u000e&6\u001d\u0006CBB/\rg#I\u0006\u0003\u0005\u0007\b\t=\u0007\u0019\u0001Cn\u0003Aq\u0015-\\3TK2,7\r^8s%\u0016\u0004(\u000f\u0005\u0003\u000e*\tM'\u0001\u0005(b[\u0016\u001cV\r\\3di>\u0014(+\u001a9s'\u0011\u0011\u0019na\u0017\u0015\u00055-FC\u0002Cn\u001bkk9\f\u0003\u0005\u0004\"\n]\u0007\u0019\u0001Dn\u0011!!9Fa6A\u0002\u0011eC\u0003BG^\u001b\u007f\u0003ba!\u0018\u000746u\u0006\u0003CB/\u000fO1Y\u000e\"\u0017\t\u0011\u0019\u001d!\u0011\u001ca\u0001\t7\fQ!\u0011:s_^\u0004B!$\u000b\u0003^\n)\u0011I\u001d:poN!!Q\\B.)\ti\u0019\r\u0006\u0004\u000eN6MWr\u001b\t\u0005\u0007gjy-\u0003\u0003\u000eR\u0012\u0005(!B!qa2L\b\u0002CGk\u0005C\u0004\r\u0001b7\u0002\t1,g\r\u001e\u0005\t\u001b3\u0014\t\u000f1\u0001\u0005\\\u0006)!/[4iiR!!RHGo\u0011!19Aa9A\u000255\u0017A\u0005*f]\u0006lWmU3mK\u000e$xN\u001d*faJ\u0004B!$\u000b\u0003h\n\u0011\"+\u001a8b[\u0016\u001cV\r\\3di>\u0014(+\u001a9s'\u0011\u00119oa\u0017\u0015\u00055\u0005HC\u0003Cn\u001bWli/$=\u000et\"AQ2\u000eBv\u0001\u00041Y\u000e\u0003\u0005\u000ep\n-\b\u0019\u0001C-\u0003\u0011\u0001xn]\u0019\t\u00115M$1\u001ea\u0001\r7D\u0001\"$>\u0003l\u0002\u0007A\u0011L\u0001\u0005a>\u001c(\u0007\u0006\u0003\u000ez6u\bCBB/\rgkY\u0010\u0005\u0007\u0004^%=f1\u001cC-\r7$I\u0006\u0003\u0005\u0007\b\t5\b\u0019\u0001Cn\u0003Q)f.[7q_J$8+\u001a7fGR|'OU3qeB!Q\u0012\u0006By\u0005Q)f.[7q_J$8+\u001a7fGR|'OU3qeN!!\u0011_B.)\tq\t\u0001\u0006\u0004\u0005\\:-aR\u0002\u0005\t\u0007C\u0013)\u00101\u0001\u0007\\\"AAq\u000bB{\u0001\u0004!I\u0006\u0006\u0003\u000e<:E\u0001\u0002\u0003D\u0004\u0005o\u0004\r\u0001b7\u0002\u0015\u0011,'/\u001b<fIB{7\u000f\u0006\u0004\u0005Z9]a2\u0004\u0005\t\u001d3\u0011I\u00101\u0001\u0005\\\u0006\tA\u000f\u0003\u0005\u000e<\te\b\u0019ABv\u00035!WM]5wK\u0012|eMZ:fiR!11\u001eH\u0011\u0011!!9Fa?A\u0002\u0011eCC\u0002H\u0013\u001dWqy\u0003\u0005\u0003\u0004t9\u001d\u0012\u0002\u0002H\u0015\tC\u0014a!S7q_J$\b\u0002\u0003H\u0017\u0005{\u0004\r\u0001b7\u0002\t\u0015D\bO\u001d\u0005\t\u001dc\u0011i\u00101\u0001\u0007\u001e\u0005I1/\u001a7fGR|'o\u001d\u000b\u0005\u0017Os)\u0004\u0003\u0005\u000f8\t}\b\u0019\u0001H\u0013\u0003\rIW\u000e]\u0001\u0014'ftG/Y2uS\u000e\u001cV\r\\3diRK\b/\u001a\t\u0005\r3\u001b\u0019AA\nTs:$\u0018m\u0019;jGN+G.Z2u)f\u0004Xm\u0005\u0004\u0004\u0004\rmc\u0012\t\t\u0005\r3s\u0019%\u0003\u0003\u000fF\rU$\u0001H*z]R\f7\r^5d'\u0016dWm\u0019;UsB,W\t\u001f;sC\u000e$xN\u001d\u000b\u0003\u001dw!b\u0001b;\u000fL95\u0003\u0002\u0003Dj\u0007\u000f\u0001\r\u0001b7\t\u0011\r\u00056q\u0001a\u0001\rW$BA$\u0015\u000fVA11Q\fDZ\u001d'\u0002\u0002b!\u0018\b(\u0011mg1\u001e\u0005\t\r\u000f\u0019I\u00011\u0001\u0005\\\u0006\u00192+\u001f8uC\u000e$\u0018nY*fY\u0016\u001cG\u000fV3s[B!a\u0011TB\u0007\u0005M\u0019\u0016P\u001c;bGRL7mU3mK\u000e$H+\u001a:n'\u0019\u0019iaa\u0017\u000f`A!a\u0011\u0014H1\u0013\u0011q\u0019g!\u001e\u00039MKh\u000e^1di&\u001c7+\u001a7fGR$VM]7FqR\u0014\u0018m\u0019;peR\u0011a\u0012\f\u000b\u0007\tWtIGd\u001b\t\u0011\u0019M7\u0011\u0003a\u0001\t7D\u0001b!)\u0004\u0012\u0001\u0007a1\u001c\u000b\u0005\u001d_r\u0019\b\u0005\u0004\u0004^\u0019Mf\u0012\u000f\t\t\u0007;:9\u0003b7\u0007\\\"AaqAB\n\u0001\u0004!Y.A\u000bTs:$\u0018m\u0019;jG\u000e{W\u000e]8v]\u0012$\u0016\u0010]3\u0011\t\u0019e5q\u0003\u0002\u0016'ftG/Y2uS\u000e\u001cu.\u001c9pk:$G+\u001f9f'\u0019\u00199ba\u0017\u000f~A!a\u0011\u0014H@\u0013\u0011q\ti!\u001e\u0003=MKh\u000e^1di&\u001c7i\\7q_VtG\rV=qK\u0016CHO]1di>\u0014HC\u0001H<)\u0019q9I$$\u000f\u0010B!11\u000fHE\u0013\u0011qY\t\"9\u0003!\r{W\u000e]8v]\u0012$\u0016\u0010]3Ue\u0016,\u0007\u0002CC/\u00077\u0001\rA\"\b\t\u0011\u0019\u001571\u0004a\u0001\r;!BAd%\u000f\u0018B11Q\fDZ\u001d+\u0003\u0002b!\u0018\b(\u0019uaQ\u0004\u0005\t\r\u000f\u0019i\u00021\u0001\u0005\\\u000612+\u001f8uC\u000e$\u0018nY*j]\u001edW\r^8o)f\u0004X\r\u0005\u0003\u0007\u001a\u000e\u0005\"AF*z]R\f7\r^5d'&tw\r\\3u_:$\u0016\u0010]3\u0014\r\r\u000521\fHQ!\u00111IJd)\n\t9\u00156Q\u000f\u0002 'ftG/Y2ji\u000e\u001c\u0016N\\4mKR|g\u000eV=qK\u0016CHO]1di>\u0014HC\u0001HN)\u0011qYK$-\u0011\t\rMdRV\u0005\u0005\u001d_#\tOA\tTS:<G.\u001a;p]RK\b/\u001a+sK\u0016D\u0001Bd-\u0004&\u0001\u0007A1\\\u0001\u0004e\u00164G\u0003\u0002Fg\u001doC\u0001Bb\u0002\u0004(\u0001\u0007A1\\\u0001\u0018'ftG/Y2uS\u000e$\u0016\u0010]3Qe>TWm\u0019;j_:\u0004BA\"'\u0004,\t92+\u001f8uC\u000e$\u0018n\u0019+za\u0016\u0004&o\u001c6fGRLwN\\\n\u0007\u0007W\u0019YF$1\u0011\t\u0019ee2Y\u0005\u0005\u001d\u000b\u001c)H\u0001\u0011Ts:$\u0018m\u0019;jGRK\b/\u001a)s_*,7\r^5p]\u0016CHO]1di>\u0014HC\u0001H^)\u0019qYM$5\u000fTB!11\u000fHg\u0013\u0011qy\r\"9\u0003%M+G.Z2u\rJ|W\u000eV=qKR\u0013X-\u001a\u0005\t\r'\u001cy\u00031\u0001\u0005\\\"A1\u0011UB\u0018\u0001\u00041Y\u000f\u0006\u0003\u000fR9]\u0007\u0002\u0003D\u0004\u0007c\u0001\r\u0001b7\u0002-MKh\u000e^1di&\u001c\u0017I\u001c8pi\u0006$X\r\u001a+za\u0016\u0004BA\"'\u00046\t12+\u001f8uC\u000e$\u0018nY!o]>$\u0018\r^3e)f\u0004Xm\u0005\u0004\u00046\rmc\u0012\u001d\t\u0005\r3s\u0019/\u0003\u0003\u000ff\u000eU$aH*z]R\f7\r^5d\u0003:tw\u000e^1uK\u0012$\u0016\u0010]3FqR\u0014\u0018m\u0019;peR\u0011a2\u001c\u000b\u0007\u001dWt\tPd=\u0011\t\rMdR^\u0005\u0005\u001d_$\tOA\u0005B]:|G/\u0019;fI\"A\u0011r[B\u001d\u0001\u0004!Y\u000e\u0003\u0005\u000fv\u000ee\u0002\u0019\u0001Cn\u0003\u0015\tgN\\8u)\u0011QiD$?\t\u0011\u0019\u001d11\ba\u0001\t7\f\u0001dU=oi\u0006\u001cG/[2Fq&\u001cH/\u001a8uS\u0006dG+\u001f9f!\u00111Ija\u0010\u00031MKh\u000e^1di&\u001cW\t_5ti\u0016tG/[1m)f\u0004Xm\u0005\u0004\u0004@\rms2\u0001\t\u0005\r3{)!\u0003\u0003\u0010\b\rU$!I*z]R\f7\r^5d\u000bbL7\u000f^3oi&\fG\u000eV=qK\u0016CHO]1di>\u0014HC\u0001H\u007f)\u0019yiad\u0005\u0010\u0016A!11OH\b\u0013\u0011y\t\u0002\"9\u0003'\u0015C\u0018n\u001d;f]RL\u0017\r\u001c+za\u0016$&/Z3\t\u0011%]71\ta\u0001\t7D\u0001bd\u0006\u0004D\u0001\u0007aQD\u0001\u0006o\",'/\u001a\u000b\u0005\u001f7y9\u0003\u0005\u0004\u0004^\u0019MvR\u0004\t\t\u0007;:9\u0003b7\u0010 A1Aq\u0015CW\u001fC\u0001Baa\u001d\u0010$%!qR\u0005Cq\u0005%iU-\u001c2fe\u0012+g\r\u0003\u0005\u0007\b\r\u0015\u0003\u0019\u0001Cn\u0003\u0015\u0011W/\u001b7e+\t\u0019)\t\u0005\u0003\u00100=ERBAB&\u0013\u0011y\u0019da\u0013\u0003\u0017MKXNY8m)\u0006\u0014G.\u001a")
public interface ReificationSupport {
    public void scala$reflect$internal$ReificationSupport$_setter_$build_$eq(ReificationSupportImpl var1);

    public ReificationSupportImpl build();

    public static void $init$(ReificationSupport $this) {
        $this.scala$reflect$internal$ReificationSupport$_setter_$build_$eq(new ReificationSupportImpl((SymbolTable)$this));
    }

    public static class ReificationSupportImpl
    implements Internals.ReificationSupportApi {
        private volatile ReificationSupport$ReificationSupportImpl$ScalaDot$ ScalaDot$module;
        private volatile ReificationSupport$ReificationSupportImpl$ImplicitParams$ ImplicitParams$module;
        private volatile ReificationSupport$ReificationSupportImpl$FlagsRepr$ FlagsRepr$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticTypeApplied$ SyntacticTypeApplied$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticAppliedType$ SyntacticAppliedType$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticApplied$ SyntacticApplied$module;
        private volatile ReificationSupport$ReificationSupportImpl$UnCtor$ UnCtor$module;
        private volatile ReificationSupport$ReificationSupportImpl$UnMkTemplate$ UnMkTemplate$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticClassDef$ SyntacticClassDef$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticTraitDef$ SyntacticTraitDef$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticObjectDef$ SyntacticObjectDef$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticPackageObjectDef$ SyntacticPackageObjectDef$module;
        private volatile ReificationSupport$ReificationSupportImpl$TupleClassRef$ TupleClassRef$module;
        private volatile ReificationSupport$ReificationSupportImpl$TupleCompanionRef$ TupleCompanionRef$module;
        private volatile ReificationSupport$ReificationSupportImpl$UnitClassRef$ UnitClassRef$module;
        private volatile ReificationSupport$ReificationSupportImpl$FunctionClassRef$ FunctionClassRef$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticTuple$ SyntacticTuple$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticTupleType$ SyntacticTupleType$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticFunctionType$ SyntacticFunctionType$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntheticUnit$ SyntheticUnit$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticBlock$ SyntacticBlock$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticFunction$ SyntacticFunction$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticNew$ SyntacticNew$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticDefDef$ SyntacticDefDef$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticValDef$ SyntacticValDef$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticVarDef$ SyntacticVarDef$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticAssign$ SyntacticAssign$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticValFrom$ SyntacticValFrom$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticValEq$ SyntacticValEq$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticFilter$ SyntacticFilter$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticEmptyTypeTree$ SyntacticEmptyTypeTree$module;
        private volatile ReificationSupport$ReificationSupportImpl$UnPatSeq$ UnPatSeq$module;
        private volatile ReificationSupport$ReificationSupportImpl$implodePatDefs$ implodePatDefs$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticPatDef$ SyntacticPatDef$module;
        private volatile ReificationSupport$ReificationSupportImpl$UnPatSeqWithRes$ UnPatSeqWithRes$module;
        private volatile ReificationSupport$ReificationSupportImpl$UnSyntheticParam$ UnSyntheticParam$module;
        private volatile ReificationSupport$ReificationSupportImpl$UnVisitor$ UnVisitor$module;
        private volatile ReificationSupport$ReificationSupportImpl$UnClosure$ UnClosure$module;
        private volatile ReificationSupport$ReificationSupportImpl$FilterCall$ FilterCall$module;
        private volatile ReificationSupport$ReificationSupportImpl$UnFilter$ UnFilter$module;
        private volatile ReificationSupport$ReificationSupportImpl$UnCheckIfRefutable$ UnCheckIfRefutable$module;
        private volatile ReificationSupport$ReificationSupportImpl$UnMap$ UnMap$module;
        private volatile ReificationSupport$ReificationSupportImpl$UnForeach$ UnForeach$module;
        private volatile ReificationSupport$ReificationSupportImpl$UnFlatMap$ UnFlatMap$module;
        private volatile ReificationSupport$ReificationSupportImpl$UnFor$ UnFor$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticFor$ SyntacticFor$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticForYield$ SyntacticForYield$module;
        private volatile ReificationSupport$ReificationSupportImpl$MaybeTypeTreeOriginal$ MaybeTypeTreeOriginal$module;
        private volatile ReificationSupport$ReificationSupportImpl$MaybeSelectApply$ MaybeSelectApply$module;
        private volatile ReificationSupport$ReificationSupportImpl$MaybeUnchecked$ MaybeUnchecked$module;
        private volatile ReificationSupport$ReificationSupportImpl$MaybeTyped$ MaybeTyped$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticPartialFunction$ SyntacticPartialFunction$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticMatch$ SyntacticMatch$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticTry$ SyntacticTry$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticTermIdent$ SyntacticTermIdent$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticTypeIdent$ SyntacticTypeIdent$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticImport$ SyntacticImport$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticSelectType$ SyntacticSelectType$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticSelectTerm$ SyntacticSelectTerm$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticCompoundType$ SyntacticCompoundType$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticSingletonType$ SyntacticSingletonType$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticTypeProjection$ SyntacticTypeProjection$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticAnnotatedType$ SyntacticAnnotatedType$module;
        private volatile ReificationSupport$ReificationSupportImpl$SyntacticExistentialType$ SyntacticExistentialType$module;
        public final /* synthetic */ SymbolTable $outer;

        @Override
        public ReificationSupport$ReificationSupportImpl$ScalaDot$ ScalaDot() {
            if (this.ScalaDot$module == null) {
                this.ScalaDot$lzycompute$1();
            }
            return this.ScalaDot$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$ImplicitParams$ ImplicitParams() {
            if (this.ImplicitParams$module == null) {
                this.ImplicitParams$lzycompute$1();
            }
            return this.ImplicitParams$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$FlagsRepr$ FlagsRepr() {
            if (this.FlagsRepr$module == null) {
                this.FlagsRepr$lzycompute$1();
            }
            return this.FlagsRepr$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticTypeApplied$ SyntacticTypeApplied() {
            if (this.SyntacticTypeApplied$module == null) {
                this.SyntacticTypeApplied$lzycompute$1();
            }
            return this.SyntacticTypeApplied$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticAppliedType$ SyntacticAppliedType() {
            if (this.SyntacticAppliedType$module == null) {
                this.SyntacticAppliedType$lzycompute$1();
            }
            return this.SyntacticAppliedType$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticApplied$ SyntacticApplied() {
            if (this.SyntacticApplied$module == null) {
                this.SyntacticApplied$lzycompute$1();
            }
            return this.SyntacticApplied$module;
        }

        public ReificationSupport$ReificationSupportImpl$UnCtor$ UnCtor() {
            if (this.UnCtor$module == null) {
                this.UnCtor$lzycompute$1();
            }
            return this.UnCtor$module;
        }

        public ReificationSupport$ReificationSupportImpl$UnMkTemplate$ UnMkTemplate() {
            if (this.UnMkTemplate$module == null) {
                this.UnMkTemplate$lzycompute$1();
            }
            return this.UnMkTemplate$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticClassDef$ SyntacticClassDef() {
            if (this.SyntacticClassDef$module == null) {
                this.SyntacticClassDef$lzycompute$1();
            }
            return this.SyntacticClassDef$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticTraitDef$ SyntacticTraitDef() {
            if (this.SyntacticTraitDef$module == null) {
                this.SyntacticTraitDef$lzycompute$1();
            }
            return this.SyntacticTraitDef$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticObjectDef$ SyntacticObjectDef() {
            if (this.SyntacticObjectDef$module == null) {
                this.SyntacticObjectDef$lzycompute$1();
            }
            return this.SyntacticObjectDef$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticPackageObjectDef$ SyntacticPackageObjectDef() {
            if (this.SyntacticPackageObjectDef$module == null) {
                this.SyntacticPackageObjectDef$lzycompute$1();
            }
            return this.SyntacticPackageObjectDef$module;
        }

        public ReificationSupport$ReificationSupportImpl$TupleClassRef$ TupleClassRef() {
            if (this.TupleClassRef$module == null) {
                this.TupleClassRef$lzycompute$1();
            }
            return this.TupleClassRef$module;
        }

        public ReificationSupport$ReificationSupportImpl$TupleCompanionRef$ TupleCompanionRef() {
            if (this.TupleCompanionRef$module == null) {
                this.TupleCompanionRef$lzycompute$1();
            }
            return this.TupleCompanionRef$module;
        }

        public ReificationSupport$ReificationSupportImpl$UnitClassRef$ UnitClassRef() {
            if (this.UnitClassRef$module == null) {
                this.UnitClassRef$lzycompute$1();
            }
            return this.UnitClassRef$module;
        }

        public ReificationSupport$ReificationSupportImpl$FunctionClassRef$ FunctionClassRef() {
            if (this.FunctionClassRef$module == null) {
                this.FunctionClassRef$lzycompute$1();
            }
            return this.FunctionClassRef$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticTuple$ SyntacticTuple() {
            if (this.SyntacticTuple$module == null) {
                this.SyntacticTuple$lzycompute$1();
            }
            return this.SyntacticTuple$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticTupleType$ SyntacticTupleType() {
            if (this.SyntacticTupleType$module == null) {
                this.SyntacticTupleType$lzycompute$1();
            }
            return this.SyntacticTupleType$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticFunctionType$ SyntacticFunctionType() {
            if (this.SyntacticFunctionType$module == null) {
                this.SyntacticFunctionType$lzycompute$1();
            }
            return this.SyntacticFunctionType$module;
        }

        public ReificationSupport$ReificationSupportImpl$SyntheticUnit$ SyntheticUnit() {
            if (this.SyntheticUnit$module == null) {
                this.SyntheticUnit$lzycompute$1();
            }
            return this.SyntheticUnit$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticBlock$ SyntacticBlock() {
            if (this.SyntacticBlock$module == null) {
                this.SyntacticBlock$lzycompute$1();
            }
            return this.SyntacticBlock$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticFunction$ SyntacticFunction() {
            if (this.SyntacticFunction$module == null) {
                this.SyntacticFunction$lzycompute$1();
            }
            return this.SyntacticFunction$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticNew$ SyntacticNew() {
            if (this.SyntacticNew$module == null) {
                this.SyntacticNew$lzycompute$1();
            }
            return this.SyntacticNew$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticDefDef$ SyntacticDefDef() {
            if (this.SyntacticDefDef$module == null) {
                this.SyntacticDefDef$lzycompute$1();
            }
            return this.SyntacticDefDef$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticValDef$ SyntacticValDef() {
            if (this.SyntacticValDef$module == null) {
                this.SyntacticValDef$lzycompute$1();
            }
            return this.SyntacticValDef$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticVarDef$ SyntacticVarDef() {
            if (this.SyntacticVarDef$module == null) {
                this.SyntacticVarDef$lzycompute$1();
            }
            return this.SyntacticVarDef$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticAssign$ SyntacticAssign() {
            if (this.SyntacticAssign$module == null) {
                this.SyntacticAssign$lzycompute$1();
            }
            return this.SyntacticAssign$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticValFrom$ SyntacticValFrom() {
            if (this.SyntacticValFrom$module == null) {
                this.SyntacticValFrom$lzycompute$1();
            }
            return this.SyntacticValFrom$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticValEq$ SyntacticValEq() {
            if (this.SyntacticValEq$module == null) {
                this.SyntacticValEq$lzycompute$1();
            }
            return this.SyntacticValEq$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticFilter$ SyntacticFilter() {
            if (this.SyntacticFilter$module == null) {
                this.SyntacticFilter$lzycompute$1();
            }
            return this.SyntacticFilter$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticEmptyTypeTree$ SyntacticEmptyTypeTree() {
            if (this.SyntacticEmptyTypeTree$module == null) {
                this.SyntacticEmptyTypeTree$lzycompute$1();
            }
            return this.SyntacticEmptyTypeTree$module;
        }

        public ReificationSupport$ReificationSupportImpl$UnPatSeq$ UnPatSeq() {
            if (this.UnPatSeq$module == null) {
                this.UnPatSeq$lzycompute$1();
            }
            return this.UnPatSeq$module;
        }

        public ReificationSupport$ReificationSupportImpl$implodePatDefs$ implodePatDefs() {
            if (this.implodePatDefs$module == null) {
                this.implodePatDefs$lzycompute$1();
            }
            return this.implodePatDefs$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticPatDef$ SyntacticPatDef() {
            if (this.SyntacticPatDef$module == null) {
                this.SyntacticPatDef$lzycompute$1();
            }
            return this.SyntacticPatDef$module;
        }

        public ReificationSupport$ReificationSupportImpl$UnPatSeqWithRes$ UnPatSeqWithRes() {
            if (this.UnPatSeqWithRes$module == null) {
                this.UnPatSeqWithRes$lzycompute$1();
            }
            return this.UnPatSeqWithRes$module;
        }

        public ReificationSupport$ReificationSupportImpl$UnSyntheticParam$ UnSyntheticParam() {
            if (this.UnSyntheticParam$module == null) {
                this.UnSyntheticParam$lzycompute$1();
            }
            return this.UnSyntheticParam$module;
        }

        public ReificationSupport$ReificationSupportImpl$UnVisitor$ UnVisitor() {
            if (this.UnVisitor$module == null) {
                this.UnVisitor$lzycompute$1();
            }
            return this.UnVisitor$module;
        }

        public ReificationSupport$ReificationSupportImpl$UnClosure$ UnClosure() {
            if (this.UnClosure$module == null) {
                this.UnClosure$lzycompute$1();
            }
            return this.UnClosure$module;
        }

        public ReificationSupport$ReificationSupportImpl$FilterCall$ FilterCall() {
            if (this.FilterCall$module == null) {
                this.FilterCall$lzycompute$1();
            }
            return this.FilterCall$module;
        }

        public ReificationSupport$ReificationSupportImpl$UnFilter$ UnFilter() {
            if (this.UnFilter$module == null) {
                this.UnFilter$lzycompute$1();
            }
            return this.UnFilter$module;
        }

        public ReificationSupport$ReificationSupportImpl$UnCheckIfRefutable$ UnCheckIfRefutable() {
            if (this.UnCheckIfRefutable$module == null) {
                this.UnCheckIfRefutable$lzycompute$1();
            }
            return this.UnCheckIfRefutable$module;
        }

        public ReificationSupport$ReificationSupportImpl$UnMap$ UnMap() {
            if (this.UnMap$module == null) {
                this.UnMap$lzycompute$1();
            }
            return this.UnMap$module;
        }

        public ReificationSupport$ReificationSupportImpl$UnForeach$ UnForeach() {
            if (this.UnForeach$module == null) {
                this.UnForeach$lzycompute$1();
            }
            return this.UnForeach$module;
        }

        public ReificationSupport$ReificationSupportImpl$UnFlatMap$ UnFlatMap() {
            if (this.UnFlatMap$module == null) {
                this.UnFlatMap$lzycompute$1();
            }
            return this.UnFlatMap$module;
        }

        public ReificationSupport$ReificationSupportImpl$UnFor$ UnFor() {
            if (this.UnFor$module == null) {
                this.UnFor$lzycompute$1();
            }
            return this.UnFor$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticFor$ SyntacticFor() {
            if (this.SyntacticFor$module == null) {
                this.SyntacticFor$lzycompute$1();
            }
            return this.SyntacticFor$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticForYield$ SyntacticForYield() {
            if (this.SyntacticForYield$module == null) {
                this.SyntacticForYield$lzycompute$1();
            }
            return this.SyntacticForYield$module;
        }

        public ReificationSupport$ReificationSupportImpl$MaybeTypeTreeOriginal$ MaybeTypeTreeOriginal() {
            if (this.MaybeTypeTreeOriginal$module == null) {
                this.MaybeTypeTreeOriginal$lzycompute$1();
            }
            return this.MaybeTypeTreeOriginal$module;
        }

        public ReificationSupport$ReificationSupportImpl$MaybeSelectApply$ MaybeSelectApply() {
            if (this.MaybeSelectApply$module == null) {
                this.MaybeSelectApply$lzycompute$1();
            }
            return this.MaybeSelectApply$module;
        }

        public ReificationSupport$ReificationSupportImpl$MaybeUnchecked$ MaybeUnchecked() {
            if (this.MaybeUnchecked$module == null) {
                this.MaybeUnchecked$lzycompute$1();
            }
            return this.MaybeUnchecked$module;
        }

        public ReificationSupport$ReificationSupportImpl$MaybeTyped$ MaybeTyped() {
            if (this.MaybeTyped$module == null) {
                this.MaybeTyped$lzycompute$1();
            }
            return this.MaybeTyped$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticPartialFunction$ SyntacticPartialFunction() {
            if (this.SyntacticPartialFunction$module == null) {
                this.SyntacticPartialFunction$lzycompute$1();
            }
            return this.SyntacticPartialFunction$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticMatch$ SyntacticMatch() {
            if (this.SyntacticMatch$module == null) {
                this.SyntacticMatch$lzycompute$1();
            }
            return this.SyntacticMatch$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticTry$ SyntacticTry() {
            if (this.SyntacticTry$module == null) {
                this.SyntacticTry$lzycompute$1();
            }
            return this.SyntacticTry$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticTermIdent$ SyntacticTermIdent() {
            if (this.SyntacticTermIdent$module == null) {
                this.SyntacticTermIdent$lzycompute$1();
            }
            return this.SyntacticTermIdent$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticTypeIdent$ SyntacticTypeIdent() {
            if (this.SyntacticTypeIdent$module == null) {
                this.SyntacticTypeIdent$lzycompute$1();
            }
            return this.SyntacticTypeIdent$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticImport$ SyntacticImport() {
            if (this.SyntacticImport$module == null) {
                this.SyntacticImport$lzycompute$1();
            }
            return this.SyntacticImport$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticSelectType$ SyntacticSelectType() {
            if (this.SyntacticSelectType$module == null) {
                this.SyntacticSelectType$lzycompute$1();
            }
            return this.SyntacticSelectType$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticSelectTerm$ SyntacticSelectTerm() {
            if (this.SyntacticSelectTerm$module == null) {
                this.SyntacticSelectTerm$lzycompute$1();
            }
            return this.SyntacticSelectTerm$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticCompoundType$ SyntacticCompoundType() {
            if (this.SyntacticCompoundType$module == null) {
                this.SyntacticCompoundType$lzycompute$1();
            }
            return this.SyntacticCompoundType$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticSingletonType$ SyntacticSingletonType() {
            if (this.SyntacticSingletonType$module == null) {
                this.SyntacticSingletonType$lzycompute$1();
            }
            return this.SyntacticSingletonType$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticTypeProjection$ SyntacticTypeProjection() {
            if (this.SyntacticTypeProjection$module == null) {
                this.SyntacticTypeProjection$lzycompute$1();
            }
            return this.SyntacticTypeProjection$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticAnnotatedType$ SyntacticAnnotatedType() {
            if (this.SyntacticAnnotatedType$module == null) {
                this.SyntacticAnnotatedType$lzycompute$1();
            }
            return this.SyntacticAnnotatedType$module;
        }

        @Override
        public ReificationSupport$ReificationSupportImpl$SyntacticExistentialType$ SyntacticExistentialType() {
            if (this.SyntacticExistentialType$module == null) {
                this.SyntacticExistentialType$lzycompute$1();
            }
            return this.SyntacticExistentialType$module;
        }

        public Symbols.TypeSymbol selectType(Symbols.Symbol owner, String name) {
            return (Symbols.TypeSymbol)this.select(owner, this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().newTypeName(name)).asType();
        }

        /*
         * WARNING - void declaration
         */
        public Symbols.TermSymbol selectTerm(Symbols.Symbol owner, String name) {
            void var3_3;
            Symbols.TermSymbol result2 = (Symbols.TermSymbol)this.select(owner, this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().newTermName(name)).asTerm();
            if (result2.isOverloaded()) {
                return (Symbols.TermSymbol)((Symbols.SymbolContextApiImpl)result2.suchThat((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(ReificationSupportImpl.$anonfun$selectTerm$1(x$1)))).asTerm();
            }
            return var3_3;
        }

        /*
         * WARNING - void declaration
         */
        public Symbols.Symbol select(Symbols.Symbol owner, Names.Name name) {
            void var4_4;
            Symbols.Symbol result2 = owner.info().decl(name);
            if (result2 != this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().NoSymbol()) {
                return result2;
            }
            Symbols.Symbol symbol = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().mirrorThatLoaded(owner).missingHook(owner, name);
            if (symbol == null) {
                throw null;
            }
            Symbols.Symbol orElse_this = symbol;
            if (orElse_this == orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                throw ReificationSupportImpl.$anonfun$select$1(name, owner);
            }
            return var4_4;
        }

        public Symbols.MethodSymbol selectOverloadedMethod(Symbols.Symbol owner, String name, int index) {
            Symbols.Symbol result2 = owner.info().decl(this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().newTermName(name)).alternatives().apply(index);
            if (result2 != this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().NoSymbol()) {
                return (Symbols.MethodSymbol)result2.asMethod();
            }
            String string = "overloaded method %s #%d in %s not found";
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            throw new ScalaReflectionException(new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{name, BoxesRunTime.boxToInteger(index), owner.fullName()})));
        }

        public Symbols.FreeTermSymbol newFreeTerm(String name, Function0<Object> value, long flags, String origin) {
            return (Symbols.FreeTermSymbol)this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().newFreeTermSymbol(this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().newTermName(name), value, flags, origin).markFlagsCompleted(-1L);
        }

        public long newFreeTerm$default$3() {
            return 0L;
        }

        @Override
        public String newFreeTerm$default$4() {
            return null;
        }

        public Symbols.FreeTypeSymbol newFreeType(String name, long flags, String origin) {
            return (Symbols.FreeTypeSymbol)this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().newFreeTypeSymbol(this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().newTypeName(name), flags, origin).markFlagsCompleted(-1L);
        }

        public long newFreeType$default$2() {
            return 0L;
        }

        @Override
        public String newFreeType$default$3() {
            return null;
        }

        public Symbols.Symbol newNestedSymbol(Symbols.Symbol owner, Names.Name name, Position pos, long flags, boolean isClass) {
            return owner.newNestedSymbol(name, pos, flags, isClass).markFlagsCompleted(-1L);
        }

        public Scopes.Scope newScopeWith(Seq<Symbols.Symbol> elems) {
            return this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().newScopeWith(elems);
        }

        public <S extends Symbols.Symbol> S setAnnotations(S sym, List<AnnotationInfos.AnnotationInfo> annots) {
            return (S)sym.setAnnotations((List)annots);
        }

        public <S extends Symbols.Symbol> S setInfo(S sym, Types.Type tpe) {
            return (S)sym.setInfo(tpe).markAllCompleted();
        }

        public Trees.Tree mkThis(Symbols.Symbol sym) {
            return this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().This(sym);
        }

        public Trees.Select mkSelect(Trees.Tree qualifier, Symbols.Symbol sym) {
            return this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().Select(qualifier, sym);
        }

        public Trees.Ident mkIdent(Symbols.Symbol sym) {
            return this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().Ident(sym);
        }

        public Trees.TypeTree mkTypeTree(Types.Type tp) {
            return this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().TypeTree(tp);
        }

        public Types.Type ThisType(Symbols.Symbol sym) {
            return this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().ThisType().apply(sym);
        }

        public Types.Type SingleType(Types.Type pre, Symbols.Symbol sym) {
            return this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().SingleType().apply(pre, sym);
        }

        public Types.Type SuperType(Types.Type thistpe, Types.Type supertpe) {
            return this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().SuperType().apply(thistpe, supertpe);
        }

        public Types.ConstantType ConstantType(Constants.Constant value) {
            return this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().ConstantType().apply(value);
        }

        public Types.Type TypeRef(Types.Type pre, Symbols.Symbol sym, List<Types.Type> args2) {
            return this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().TypeRef().apply(pre, sym, args2);
        }

        public Types.RefinedType RefinedType(List<Types.Type> parents, Scopes.Scope decls, Symbols.Symbol typeSymbol) {
            return this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().RefinedType().apply(parents, decls, typeSymbol);
        }

        public Types.ClassInfoType ClassInfoType(List<Types.Type> parents, Scopes.Scope decls, Symbols.Symbol typeSymbol) {
            return new Types.ClassInfoType(this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer(), parents, decls, typeSymbol);
        }

        public Types.MethodType MethodType(List<Symbols.Symbol> params, Types.Type resultType) {
            return new Types.MethodType(this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer(), params, resultType);
        }

        public Types.NullaryMethodType NullaryMethodType(Types.Type resultType) {
            return new Types.NullaryMethodType(this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer(), resultType);
        }

        public Types.PolyType PolyType(List<Symbols.Symbol> typeParams, Types.Type resultType) {
            return new Types.PolyType(this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer(), typeParams, resultType);
        }

        public Types.ExistentialType ExistentialType(List<Symbols.Symbol> quantified, Types.Type underlying) {
            return new Types.ExistentialType(this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer(), quantified, underlying);
        }

        public Types.AnnotatedType AnnotatedType(List<AnnotationInfos.AnnotationInfo> annotations, Types.Type underlying) {
            return new Types.AnnotatedType(this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer(), annotations, underlying);
        }

        public Types.TypeBounds TypeBounds(Types.Type lo, Types.Type hi) {
            return this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().TypeBounds().apply(lo, hi);
        }

        public Types.BoundedWildcardType BoundedWildcardType(Types.TypeBounds bounds) {
            return new Types.BoundedWildcardType(this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer(), bounds);
        }

        public Types.Type thisPrefix(Symbols.Symbol sym) {
            return sym.thisPrefix();
        }

        public <T extends Trees.Tree> T setType(T tree, Types.Type tpe) {
            tree.setType(tpe);
            return tree;
        }

        public <T extends Trees.Tree> T setSymbol(T tree, Symbols.Symbol sym) {
            tree.setSymbol(sym);
            return tree;
        }

        public List<Trees.Tree> toStats(Trees.Tree tree) {
            List list;
            if (((Object)this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().EmptyTree()).equals(tree)) {
                list = Nil$.MODULE$;
            } else {
                Option<List<Trees.Tree>> option = this.SyntacticBlock().unapply(tree);
                if (!option.isEmpty()) {
                    list = option.get();
                } else if (tree.isDef()) {
                    list = Nil$.MODULE$.$colon$colon(tree);
                } else if (tree instanceof Trees.Import) {
                    Trees.Import import_ = (Trees.Import)tree;
                    list = Nil$.MODULE$.$colon$colon(import_);
                } else {
                    throw new IllegalArgumentException(new StringBuilder(14).append("can't flatten ").append(tree).toString());
                }
            }
            return list;
        }

        public Trees.Tree mkAnnotation(Trees.Tree tree) {
            block3: {
                block2: {
                    Option<Tuple4<List<Trees.Tree>, List<Trees.Tree>, Trees.ValDef, List<Trees.Tree>>> option = this.SyntacticNew().unapply(tree);
                    if (option.isEmpty()) break block2;
                    List<Trees.Tree> list = option.get()._1();
                    List<Trees.Tree> list2 = option.get()._2();
                    List<Trees.Tree> list3 = option.get()._4();
                    if (!((Object)Nil$.MODULE$).equals(list) || !(list2 instanceof $colon$colon)) break block2;
                    $colon$colon $colon$colon = ($colon$colon)list2;
                    Trees.Tree tree2 = (Trees.Tree)$colon$colon.head();
                    List list4 = $colon$colon.tl$access$1();
                    Some<Tuple2<Trees.Tree, List<List<Trees.Tree>>>> some = this.SyntacticApplied().unapply(tree2);
                    if (some.isEmpty()) break block2;
                    Trees.Tree tree3 = some.get()._1();
                    if (!this.SyntacticAppliedType().unapply(tree3).isEmpty() && ((Object)Nil$.MODULE$).equals(list4) && ((Object)Nil$.MODULE$).equals(list3)) break block3;
                }
                throw new IllegalArgumentException(new StringBuilder(122).append("Tree ").append(this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().showRaw(tree, this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().showRaw$default$2(), this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().showRaw$default$3(), this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().showRaw$default$4(), this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().showRaw$default$5(), this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().showRaw$default$6(), this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().showRaw$default$7())).append(" isn't a correct representation of annotation.").append("Consider reformatting it into a q\"new $name[..$targs](...$argss)\" shape").toString());
            }
            return tree;
        }

        public List<Trees.Tree> mkAnnotation(List<Trees.Tree> trees) {
            return trees.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)tree -> this.mkAnnotation((Trees.Tree)tree), List$.MODULE$.canBuildFrom());
        }

        public List<List<Trees.ValDef>> mkParam(List<List<Trees.Tree>> argss, long extraFlags, long excludeFlags) {
            return argss.map((Function1<List, List> & java.io.Serializable & Serializable)args2 -> args2.map((Function1<Trees.Tree, Trees.ValDef> & java.io.Serializable & Serializable)x$4 -> this.mkParam((Trees.Tree)x$4, extraFlags, excludeFlags), List$.MODULE$.canBuildFrom()), List$.MODULE$.canBuildFrom());
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public Trees.ValDef mkParam(Trees.Tree tree, long extraFlags, long excludeFlags) {
            if (tree instanceof Trees.Typed) {
                Names.Name name;
                Trees.Typed typed = (Trees.Typed)tree;
                Trees.Tree tree2 = typed.expr();
                Trees.Tree tpt = typed.tpt();
                if (tree2 instanceof Trees.Ident && (name = ((Trees.Ident)tree2).name()) instanceof Names.TermName) {
                    Names.TermName termName = (Names.TermName)name;
                    return this.mkParam(new Trees.ValDef(this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer(), (Trees.Modifiers)this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().NoMods(), termName, tpt, this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().EmptyTree()), extraFlags, excludeFlags);
                }
            }
            if (!(tree instanceof Trees.ValDef)) throw new IllegalArgumentException(new StringBuilder(108).append(tree).append(" is not valid representation of a parameter, ").append("consider reformatting it into q\"val $name: $T = $default\" shape").toString());
            Trees.ValDef valDef = (Trees.ValDef)tree;
            Trees.Modifiers newmods = valDef.mods().$amp(excludeFlags ^ 0xFFFFFFFFFFFFFFFFL);
            if (valDef.rhs().nonEmpty()) {
                newmods = newmods.$bar(0x2000000);
            }
            Trees.Modifiers x$2 = newmods.$bar(extraFlags);
            Names.Name x$3 = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyValDef$default$3(valDef);
            Trees.Tree x$4 = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyValDef$default$4(valDef);
            Trees.Tree x$5 = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyValDef$default$5(valDef);
            return this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyValDef(valDef, x$2, x$3, x$4, x$5);
        }

        public long mkParam$default$2() {
            return this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().NoFlags();
        }

        public long mkParam$default$3() {
            return 16L;
        }

        public List<Trees.ValDef> mkImplicitParam(List<Trees.Tree> args2) {
            return args2.map((Function1<Trees.Tree, Trees.ValDef> & java.io.Serializable & Serializable)tree -> this.mkImplicitParam((Trees.Tree)tree), List$.MODULE$.canBuildFrom());
        }

        public Trees.ValDef mkImplicitParam(Trees.Tree tree) {
            return this.mkParam(tree, 8704L, this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().NoFlags());
        }

        public List<Trees.TypeDef> mkTparams(List<Trees.Tree> tparams) {
            return tparams.map((Function1<Trees.Tree, Trees.TypeDef> & java.io.Serializable & Serializable)x0$1 -> {
                if (!(x0$1 instanceof Trees.TypeDef)) {
                    throw new IllegalArgumentException(new StringBuilder(31).append("can't splice ").append(x0$1).append(" as type parameter").toString());
                }
                Trees.TypeDef typeDef = (Trees.TypeDef)x0$1;
                Trees.Modifiers x$2 = typeDef.mods().$bar(8192).$amp(-17L);
                Names.Name x$3 = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyTypeDef$default$3(typeDef);
                List<Trees.TypeDef> x$4 = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyTypeDef$default$4(typeDef);
                Trees.Tree x$5 = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyTypeDef$default$5(typeDef);
                Trees.TypeDef typeDef2 = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyTypeDef(typeDef, x$2, x$3, x$4, x$5);
                return typeDef2;
            }, List$.MODULE$.canBuildFrom());
        }

        /*
         * WARNING - void declaration
         */
        public Trees.Tree mkRefineStat(Trees.Tree stat) {
            if (stat instanceof Trees.DefDef) {
                void require_requirement;
                Trees.DefDef defDef = (Trees.DefDef)stat;
                SymbolTable symbolTable = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer();
                boolean bl = defDef.rhs().isEmpty();
                if (symbolTable == null) {
                    throw null;
                }
                SymbolTable require_this = symbolTable;
                if (require_requirement == false) {
                    throw require_this.throwRequirementError(ReificationSupportImpl.$anonfun$mkRefineStat$1());
                }
            } else if (stat instanceof Trees.ValDef) {
                void require_requirement;
                Trees.ValDef valDef = (Trees.ValDef)stat;
                SymbolTable symbolTable = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer();
                boolean bl = valDef.rhs().isEmpty();
                if (symbolTable == null) {
                    throw null;
                }
                SymbolTable require_this = symbolTable;
                if (require_requirement == false) {
                    throw require_this.throwRequirementError(ReificationSupportImpl.$anonfun$mkRefineStat$2());
                }
            } else if (!(stat instanceof Trees.TypeDef)) {
                throw new IllegalArgumentException(new StringBuilder(23).append("not legal refine stat: ").append(stat).toString());
            }
            return stat;
        }

        public List<Trees.Tree> mkRefineStat(List<Trees.Tree> stats) {
            return stats.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)stat -> this.mkRefineStat((Trees.Tree)stat), List$.MODULE$.canBuildFrom());
        }

        public Trees.Tree mkPackageStat(Trees.Tree stat) {
            if (!(stat instanceof Trees.ClassDef || stat instanceof Trees.ModuleDef || stat instanceof Trees.PackageDef)) {
                throw new IllegalArgumentException(new StringBuilder(24).append("not legal package stat: ").append(stat).toString());
            }
            return stat;
        }

        public List<Trees.Tree> mkPackageStat(List<Trees.Tree> stats) {
            return stats.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)stat -> this.mkPackageStat((Trees.Tree)stat), List$.MODULE$.canBuildFrom());
        }

        public Trees.Tree mkEarlyDef(Trees.Tree defn) {
            Trees.MemberDef memberDef;
            Trees.ValDef valDef;
            Trees.Modifiers mods;
            if (defn instanceof Trees.ValDef && !(mods = (valDef = (Trees.ValDef)defn).mods()).isDeferred()) {
                Trees.Modifiers x$2 = mods.$bar(0x2000000000L);
                Names.Name x$3 = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyValDef$default$3(valDef);
                Trees.Tree x$4 = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyValDef$default$4(valDef);
                Trees.Tree x$5 = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyValDef$default$5(valDef);
                memberDef = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyValDef(valDef, x$2, x$3, x$4, x$5);
            } else if (defn instanceof Trees.TypeDef) {
                Trees.TypeDef typeDef = (Trees.TypeDef)defn;
                Trees.Modifiers x$7 = typeDef.mods().$bar(0x2000000000L);
                Names.Name x$8 = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyTypeDef$default$3(typeDef);
                List<Trees.TypeDef> x$9 = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyTypeDef$default$4(typeDef);
                Trees.Tree x$10 = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyTypeDef$default$5(typeDef);
                memberDef = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyTypeDef(typeDef, x$7, x$8, x$9, x$10);
            } else {
                throw new IllegalArgumentException(new StringBuilder(21).append("not legal early def: ").append(defn).toString());
            }
            return memberDef;
        }

        public List<Trees.Tree> mkEarlyDef(List<Trees.Tree> defns) {
            return defns.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)defn -> this.mkEarlyDef((Trees.Tree)defn), List$.MODULE$.canBuildFrom());
        }

        public Trees.RefTree mkRefTree(Trees.Tree qual, Symbols.Symbol sym) {
            return (Trees.RefTree)((Object)((Trees.Tree)((Object)this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().RefTree().apply(qual, sym.name()))).setSymbol(sym));
        }

        @Override
        public Names.TermName freshTermName(String prefix) {
            return this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().freshTermName(prefix, this.fresh());
        }

        @Override
        public Names.TypeName freshTypeName(String prefix) {
            return this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().freshTypeName(prefix, this.fresh());
        }

        public FreshNameCreator fresh() {
            return this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().currentFreshNameCreator();
        }

        public String freshTermName$default$1() {
            return this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().nme().FRESH_TERM_NAME_PREFIX();
        }

        /*
         * WARNING - void declaration
         */
        public Trees.ValDef mkSelfType(Trees.Tree tree) {
            Trees.ValDef valDef;
            if (tree instanceof Trees.ValDef) {
                void require_requirement;
                valDef = (Trees.ValDef)tree;
                SymbolTable symbolTable = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer();
                boolean bl = valDef.rhs().isEmpty();
                if (symbolTable == null) {
                    throw null;
                }
                SymbolTable require_this = symbolTable;
                if (require_requirement == false) {
                    throw require_this.throwRequirementError(ReificationSupportImpl.$anonfun$mkSelfType$1());
                }
            } else {
                throw new IllegalArgumentException(new StringBuilder(94).append(tree).append(" is not a valid representation of self type, ").append("consider reformatting into q\"val $self: $T\" shape").toString());
            }
            Trees.Modifiers x$2 = valDef.mods().$bar(4).$amp(-17L);
            Names.Name x$3 = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyValDef$default$3(valDef);
            Trees.Tree x$4 = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyValDef$default$4(valDef);
            Trees.Tree x$5 = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyValDef$default$5(valDef);
            Trees.ValDef valDef2 = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyValDef(valDef, x$2, x$3, x$4, x$5);
            return valDef2;
        }

        @Override
        public <T> Internals.ReificationSupportApi.UnliftListElementwise<T> UnliftListElementwise(Liftables.Unliftable<T> unliftable) {
            return new Internals.ReificationSupportApi.UnliftListElementwise<T>(null, unliftable){
                private final Liftables.Unliftable unliftable$1;

                public Option<List<T>> unapply(List<Trees.Tree> lst) {
                    List<A> unlifted = lst.flatMap((Function1<Trees.Tree, Iterable> & java.io.Serializable & Serializable)x$23 -> Option$.MODULE$.option2Iterable($this.unliftable$1.unapply((Trees.TreeApi)x$23)), List$.MODULE$.canBuildFrom());
                    if (unlifted.length() == lst.length()) {
                        return new Some<List<T>>(unlifted);
                    }
                    return None$.MODULE$;
                }
                {
                    this.unliftable$1 = unliftable$1;
                }

                private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                    return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$unapply$9(scala.reflect.internal.ReificationSupport$ReificationSupportImpl$$anon$1 scala.reflect.internal.Trees$Tree )}, serializedLambda);
                }
            };
        }

        @Override
        public <T> Internals.ReificationSupportApi.UnliftListOfListsElementwise<T> UnliftListOfListsElementwise(Liftables.Unliftable<T> unliftable) {
            return new Internals.ReificationSupportApi.UnliftListOfListsElementwise<T>(null, unliftable){
                private final Liftables.Unliftable unliftable$2;

                public Option<List<List<T>>> unapply(List<List<Trees.Tree>> lst) {
                    List<A> unlifted = lst.map((Function1<List, List> & java.io.Serializable & Serializable)l -> l.flatMap((Function1<Trees.Tree, Iterable> & java.io.Serializable & Serializable)x$24 -> Option$.MODULE$.option2Iterable($this.unliftable$2.unapply((Trees.TreeApi)x$24)), List$.MODULE$.canBuildFrom()), List$.MODULE$.canBuildFrom());
                    if (((LinearSeqOptimized)((Object)unlifted.flatten(Predef$.MODULE$.$conforms()))).length() == ((LinearSeqOptimized)((Object)lst.flatten(Predef$.MODULE$.$conforms()))).length()) {
                        return new Some<List<List<T>>>(unlifted);
                    }
                    return None$.MODULE$;
                }
                {
                    this.unliftable$2 = unliftable$2;
                }

                private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                    return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$unapply$10(scala.reflect.internal.ReificationSupport$ReificationSupportImpl$$anon$2 scala.collection.immutable.List ), $anonfun$unapply$11(scala.reflect.internal.ReificationSupport$ReificationSupportImpl$$anon$2 scala.reflect.internal.Trees$Tree )}, serializedLambda);
                }
            };
        }

        /*
         * WARNING - void declaration
         */
        public List<Trees.Tree> mkEnumerators(List<Trees.Tree> enums) {
            void require_requirement;
            SymbolTable symbolTable = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer();
            boolean bl = enums.nonEmpty();
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable require_this = symbolTable;
            if (require_requirement == false) {
                throw require_this.throwRequirementError(ReificationSupportImpl.$anonfun$mkEnumerators$1());
            }
            Trees.Tree tree = enums.head();
            if (this.SyntacticValFrom().unapply(tree).isEmpty()) {
                throw new IllegalArgumentException(new StringBuilder(44).append(tree).append(" is not a valid first enumerator of for loop").toString());
            }
            List list = (List)enums.tail();
            if (list == null) {
                throw null;
            }
            List foreach_these = list;
            while (!foreach_these.isEmpty()) {
                Trees.Tree tree2 = (Trees.Tree)foreach_these.head();
                ReificationSupportImpl.$anonfun$mkEnumerators$2(this, tree2);
                foreach_these = (List)foreach_these.tail();
            }
            return enums;
        }

        public List<Trees.CaseDef> mkCases(List<Trees.Tree> cases) {
            return cases.map((Function1<Trees.Tree, Trees.CaseDef> & java.io.Serializable & Serializable)x0$1 -> {
                if (!(x0$1 instanceof Trees.CaseDef)) {
                    throw new IllegalArgumentException(new StringBuilder(50).append(x0$1).append(" is not valid representation of pattern match case").toString());
                }
                Trees.CaseDef caseDef = (Trees.CaseDef)x0$1;
                return caseDef;
            }, List$.MODULE$.canBuildFrom());
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ Internals scala$reflect$api$Internals$ReificationSupportApi$$$outer() {
            return this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer();
        }

        private final void ScalaDot$lzycompute$1() {
            synchronized (this) {
                if (this.ScalaDot$module == null) {
                    this.ScalaDot$module = new ReificationSupport$ReificationSupportImpl$ScalaDot$(this);
                }
                return;
            }
        }

        private final void ImplicitParams$lzycompute$1() {
            synchronized (this) {
                if (this.ImplicitParams$module == null) {
                    this.ImplicitParams$module = new ReificationSupport$ReificationSupportImpl$ImplicitParams$(this);
                }
                return;
            }
        }

        private final void FlagsRepr$lzycompute$1() {
            synchronized (this) {
                if (this.FlagsRepr$module == null) {
                    this.FlagsRepr$module = new ReificationSupport$ReificationSupportImpl$FlagsRepr$(this);
                }
                return;
            }
        }

        private final void SyntacticTypeApplied$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticTypeApplied$module == null) {
                    this.SyntacticTypeApplied$module = new ReificationSupport$ReificationSupportImpl$SyntacticTypeApplied$(this);
                }
                return;
            }
        }

        private final void SyntacticAppliedType$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticAppliedType$module == null) {
                    this.SyntacticAppliedType$module = new ReificationSupport$ReificationSupportImpl$SyntacticAppliedType$(this);
                }
                return;
            }
        }

        private final void SyntacticApplied$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticApplied$module == null) {
                    this.SyntacticApplied$module = new ReificationSupport$ReificationSupportImpl$SyntacticApplied$(this);
                }
                return;
            }
        }

        private final void UnCtor$lzycompute$1() {
            synchronized (this) {
                if (this.UnCtor$module == null) {
                    this.UnCtor$module = new ReificationSupport$ReificationSupportImpl$UnCtor$(this);
                }
                return;
            }
        }

        private final void UnMkTemplate$lzycompute$1() {
            synchronized (this) {
                if (this.UnMkTemplate$module == null) {
                    this.UnMkTemplate$module = new ReificationSupport$ReificationSupportImpl$UnMkTemplate$(this);
                }
                return;
            }
        }

        private final void SyntacticClassDef$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticClassDef$module == null) {
                    this.SyntacticClassDef$module = new ReificationSupport$ReificationSupportImpl$SyntacticClassDef$(this);
                }
                return;
            }
        }

        private final void SyntacticTraitDef$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticTraitDef$module == null) {
                    this.SyntacticTraitDef$module = new ReificationSupport$ReificationSupportImpl$SyntacticTraitDef$(this);
                }
                return;
            }
        }

        private final void SyntacticObjectDef$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticObjectDef$module == null) {
                    this.SyntacticObjectDef$module = new ReificationSupport$ReificationSupportImpl$SyntacticObjectDef$(this);
                }
                return;
            }
        }

        private final void SyntacticPackageObjectDef$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticPackageObjectDef$module == null) {
                    this.SyntacticPackageObjectDef$module = new ReificationSupport$ReificationSupportImpl$SyntacticPackageObjectDef$(this);
                }
                return;
            }
        }

        private final void TupleClassRef$lzycompute$1() {
            synchronized (this) {
                if (this.TupleClassRef$module == null) {
                    this.TupleClassRef$module = new ReificationSupport$ReificationSupportImpl$TupleClassRef$(this);
                }
                return;
            }
        }

        private final void TupleCompanionRef$lzycompute$1() {
            synchronized (this) {
                if (this.TupleCompanionRef$module == null) {
                    this.TupleCompanionRef$module = new ReificationSupport$ReificationSupportImpl$TupleCompanionRef$(this);
                }
                return;
            }
        }

        private final void UnitClassRef$lzycompute$1() {
            synchronized (this) {
                if (this.UnitClassRef$module == null) {
                    this.UnitClassRef$module = new ReificationSupport$ReificationSupportImpl$UnitClassRef$(this);
                }
                return;
            }
        }

        private final void FunctionClassRef$lzycompute$1() {
            synchronized (this) {
                if (this.FunctionClassRef$module == null) {
                    this.FunctionClassRef$module = new ReificationSupport$ReificationSupportImpl$FunctionClassRef$(this);
                }
                return;
            }
        }

        private final void SyntacticTuple$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticTuple$module == null) {
                    this.SyntacticTuple$module = new ReificationSupport$ReificationSupportImpl$SyntacticTuple$(this);
                }
                return;
            }
        }

        private final void SyntacticTupleType$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticTupleType$module == null) {
                    this.SyntacticTupleType$module = new ReificationSupport$ReificationSupportImpl$SyntacticTupleType$(this);
                }
                return;
            }
        }

        private final void SyntacticFunctionType$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticFunctionType$module == null) {
                    this.SyntacticFunctionType$module = new ReificationSupport$ReificationSupportImpl$SyntacticFunctionType$(this);
                }
                return;
            }
        }

        private final void SyntheticUnit$lzycompute$1() {
            synchronized (this) {
                if (this.SyntheticUnit$module == null) {
                    this.SyntheticUnit$module = new ReificationSupport$ReificationSupportImpl$SyntheticUnit$(this);
                }
                return;
            }
        }

        private final void SyntacticBlock$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticBlock$module == null) {
                    this.SyntacticBlock$module = new ReificationSupport$ReificationSupportImpl$SyntacticBlock$(this);
                }
                return;
            }
        }

        private final void SyntacticFunction$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticFunction$module == null) {
                    this.SyntacticFunction$module = new ReificationSupport$ReificationSupportImpl$SyntacticFunction$(this);
                }
                return;
            }
        }

        private final void SyntacticNew$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticNew$module == null) {
                    this.SyntacticNew$module = new ReificationSupport$ReificationSupportImpl$SyntacticNew$(this);
                }
                return;
            }
        }

        private final void SyntacticDefDef$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticDefDef$module == null) {
                    this.SyntacticDefDef$module = new ReificationSupport$ReificationSupportImpl$SyntacticDefDef$(this);
                }
                return;
            }
        }

        private final void SyntacticValDef$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticValDef$module == null) {
                    this.SyntacticValDef$module = new ReificationSupport$ReificationSupportImpl$SyntacticValDef$(this);
                }
                return;
            }
        }

        private final void SyntacticVarDef$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticVarDef$module == null) {
                    this.SyntacticVarDef$module = new ReificationSupport$ReificationSupportImpl$SyntacticVarDef$(this);
                }
                return;
            }
        }

        private final void SyntacticAssign$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticAssign$module == null) {
                    this.SyntacticAssign$module = new ReificationSupport$ReificationSupportImpl$SyntacticAssign$(this);
                }
                return;
            }
        }

        private final void SyntacticValFrom$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticValFrom$module == null) {
                    this.SyntacticValFrom$module = new ReificationSupport$ReificationSupportImpl$SyntacticValFrom$(this);
                }
                return;
            }
        }

        private final void SyntacticValEq$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticValEq$module == null) {
                    this.SyntacticValEq$module = new ReificationSupport$ReificationSupportImpl$SyntacticValEq$(this);
                }
                return;
            }
        }

        private final void SyntacticFilter$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticFilter$module == null) {
                    this.SyntacticFilter$module = new ReificationSupport$ReificationSupportImpl$SyntacticFilter$(this);
                }
                return;
            }
        }

        private final void SyntacticEmptyTypeTree$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticEmptyTypeTree$module == null) {
                    this.SyntacticEmptyTypeTree$module = new ReificationSupport$ReificationSupportImpl$SyntacticEmptyTypeTree$(this);
                }
                return;
            }
        }

        private final void UnPatSeq$lzycompute$1() {
            synchronized (this) {
                if (this.UnPatSeq$module == null) {
                    this.UnPatSeq$module = new ReificationSupport$ReificationSupportImpl$UnPatSeq$(this);
                }
                return;
            }
        }

        private final void implodePatDefs$lzycompute$1() {
            synchronized (this) {
                if (this.implodePatDefs$module == null) {
                    this.implodePatDefs$module = new ReificationSupport$ReificationSupportImpl$implodePatDefs$(this);
                }
                return;
            }
        }

        private final void SyntacticPatDef$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticPatDef$module == null) {
                    this.SyntacticPatDef$module = new ReificationSupport$ReificationSupportImpl$SyntacticPatDef$(this);
                }
                return;
            }
        }

        private final void UnPatSeqWithRes$lzycompute$1() {
            synchronized (this) {
                if (this.UnPatSeqWithRes$module == null) {
                    this.UnPatSeqWithRes$module = new ReificationSupport$ReificationSupportImpl$UnPatSeqWithRes$(this);
                }
                return;
            }
        }

        private final void UnSyntheticParam$lzycompute$1() {
            synchronized (this) {
                if (this.UnSyntheticParam$module == null) {
                    this.UnSyntheticParam$module = new ReificationSupport$ReificationSupportImpl$UnSyntheticParam$(this);
                }
                return;
            }
        }

        private final void UnVisitor$lzycompute$1() {
            synchronized (this) {
                if (this.UnVisitor$module == null) {
                    this.UnVisitor$module = new ReificationSupport$ReificationSupportImpl$UnVisitor$(this);
                }
                return;
            }
        }

        private final void UnClosure$lzycompute$1() {
            synchronized (this) {
                if (this.UnClosure$module == null) {
                    this.UnClosure$module = new ReificationSupport$ReificationSupportImpl$UnClosure$(this);
                }
                return;
            }
        }

        private final void FilterCall$lzycompute$1() {
            synchronized (this) {
                if (this.FilterCall$module == null) {
                    this.FilterCall$module = new ReificationSupport$ReificationSupportImpl$FilterCall$(this);
                }
                return;
            }
        }

        private final void UnFilter$lzycompute$1() {
            synchronized (this) {
                if (this.UnFilter$module == null) {
                    this.UnFilter$module = new ReificationSupport$ReificationSupportImpl$UnFilter$(this);
                }
                return;
            }
        }

        private final void UnCheckIfRefutable$lzycompute$1() {
            synchronized (this) {
                if (this.UnCheckIfRefutable$module == null) {
                    this.UnCheckIfRefutable$module = new ReificationSupport$ReificationSupportImpl$UnCheckIfRefutable$(this);
                }
                return;
            }
        }

        private final void UnMap$lzycompute$1() {
            synchronized (this) {
                if (this.UnMap$module == null) {
                    this.UnMap$module = new ReificationSupport$ReificationSupportImpl$UnMap$(this);
                }
                return;
            }
        }

        private final void UnForeach$lzycompute$1() {
            synchronized (this) {
                if (this.UnForeach$module == null) {
                    this.UnForeach$module = new ReificationSupport$ReificationSupportImpl$UnForeach$(this);
                }
                return;
            }
        }

        private final void UnFlatMap$lzycompute$1() {
            synchronized (this) {
                if (this.UnFlatMap$module == null) {
                    this.UnFlatMap$module = new ReificationSupport$ReificationSupportImpl$UnFlatMap$(this);
                }
                return;
            }
        }

        private final void UnFor$lzycompute$1() {
            synchronized (this) {
                if (this.UnFor$module == null) {
                    this.UnFor$module = new ReificationSupport$ReificationSupportImpl$UnFor$(this);
                }
                return;
            }
        }

        private final void SyntacticFor$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticFor$module == null) {
                    this.SyntacticFor$module = new ReificationSupport$ReificationSupportImpl$SyntacticFor$(this);
                }
                return;
            }
        }

        private final void SyntacticForYield$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticForYield$module == null) {
                    this.SyntacticForYield$module = new ReificationSupport$ReificationSupportImpl$SyntacticForYield$(this);
                }
                return;
            }
        }

        private final void MaybeTypeTreeOriginal$lzycompute$1() {
            synchronized (this) {
                if (this.MaybeTypeTreeOriginal$module == null) {
                    this.MaybeTypeTreeOriginal$module = new ReificationSupport$ReificationSupportImpl$MaybeTypeTreeOriginal$(this);
                }
                return;
            }
        }

        private final void MaybeSelectApply$lzycompute$1() {
            synchronized (this) {
                if (this.MaybeSelectApply$module == null) {
                    this.MaybeSelectApply$module = new ReificationSupport$ReificationSupportImpl$MaybeSelectApply$(this);
                }
                return;
            }
        }

        private final void MaybeUnchecked$lzycompute$1() {
            synchronized (this) {
                if (this.MaybeUnchecked$module == null) {
                    this.MaybeUnchecked$module = new ReificationSupport$ReificationSupportImpl$MaybeUnchecked$(this);
                }
                return;
            }
        }

        private final void MaybeTyped$lzycompute$1() {
            synchronized (this) {
                if (this.MaybeTyped$module == null) {
                    this.MaybeTyped$module = new ReificationSupport$ReificationSupportImpl$MaybeTyped$(this);
                }
                return;
            }
        }

        private final void SyntacticPartialFunction$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticPartialFunction$module == null) {
                    this.SyntacticPartialFunction$module = new ReificationSupport$ReificationSupportImpl$SyntacticPartialFunction$(this);
                }
                return;
            }
        }

        private final void SyntacticMatch$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticMatch$module == null) {
                    this.SyntacticMatch$module = new ReificationSupport$ReificationSupportImpl$SyntacticMatch$(this);
                }
                return;
            }
        }

        private final void SyntacticTry$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticTry$module == null) {
                    this.SyntacticTry$module = new ReificationSupport$ReificationSupportImpl$SyntacticTry$(this);
                }
                return;
            }
        }

        private final void SyntacticTermIdent$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticTermIdent$module == null) {
                    this.SyntacticTermIdent$module = new ReificationSupport$ReificationSupportImpl$SyntacticTermIdent$(this);
                }
                return;
            }
        }

        private final void SyntacticTypeIdent$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticTypeIdent$module == null) {
                    this.SyntacticTypeIdent$module = new ReificationSupport$ReificationSupportImpl$SyntacticTypeIdent$(this);
                }
                return;
            }
        }

        private final void SyntacticImport$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticImport$module == null) {
                    this.SyntacticImport$module = new ReificationSupport$ReificationSupportImpl$SyntacticImport$(this);
                }
                return;
            }
        }

        private final void SyntacticSelectType$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticSelectType$module == null) {
                    this.SyntacticSelectType$module = new ReificationSupport$ReificationSupportImpl$SyntacticSelectType$(this);
                }
                return;
            }
        }

        private final void SyntacticSelectTerm$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticSelectTerm$module == null) {
                    this.SyntacticSelectTerm$module = new ReificationSupport$ReificationSupportImpl$SyntacticSelectTerm$(this);
                }
                return;
            }
        }

        private final void SyntacticCompoundType$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticCompoundType$module == null) {
                    this.SyntacticCompoundType$module = new ReificationSupport$ReificationSupportImpl$SyntacticCompoundType$(this);
                }
                return;
            }
        }

        private final void SyntacticSingletonType$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticSingletonType$module == null) {
                    this.SyntacticSingletonType$module = new ReificationSupport$ReificationSupportImpl$SyntacticSingletonType$(this);
                }
                return;
            }
        }

        private final void SyntacticTypeProjection$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticTypeProjection$module == null) {
                    this.SyntacticTypeProjection$module = new ReificationSupport$ReificationSupportImpl$SyntacticTypeProjection$(this);
                }
                return;
            }
        }

        private final void SyntacticAnnotatedType$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticAnnotatedType$module == null) {
                    this.SyntacticAnnotatedType$module = new ReificationSupport$ReificationSupportImpl$SyntacticAnnotatedType$(this);
                }
                return;
            }
        }

        private final void SyntacticExistentialType$lzycompute$1() {
            synchronized (this) {
                if (this.SyntacticExistentialType$module == null) {
                    this.SyntacticExistentialType$module = new ReificationSupport$ReificationSupportImpl$SyntacticExistentialType$(this);
                }
                return;
            }
        }

        public static final /* synthetic */ boolean $anonfun$selectTerm$1(Symbols.Symbol x$1) {
            return !x$1.isMethod();
        }

        public static final /* synthetic */ Nothing$ $anonfun$select$1(Names.Name name$1, Symbols.Symbol owner$1) {
            String string = "%s %s in %s not found";
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            throw new ScalaReflectionException(new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{name$1.isTermName() ? "term" : "type", name$1, owner$1.fullName()})));
        }

        public static final /* synthetic */ String $anonfun$mkRefineStat$1() {
            return "can't use DefDef with non-empty body as refine stat";
        }

        public static final /* synthetic */ String $anonfun$mkRefineStat$2() {
            return "can't use ValDef with non-empty rhs as refine stat";
        }

        public static final /* synthetic */ String $anonfun$mkSelfType$1() {
            return "self types must have empty right hand side";
        }

        public static final /* synthetic */ String $anonfun$mkEnumerators$1() {
            return "enumerators can't be empty";
        }

        public static final /* synthetic */ void $anonfun$mkEnumerators$2(ReificationSupportImpl $this, Trees.Tree x0$1) {
            boolean bl = !$this.SyntacticValEq().unapply(x0$1).isEmpty() ? true : (!$this.SyntacticValFrom().unapply(x0$1).isEmpty() ? true : !$this.SyntacticFilter().unapply(x0$1).isEmpty());
            if (bl) {
                return;
            }
            throw new IllegalArgumentException(new StringBuilder(55).append(x0$1).append(" is not a valid representation of a for loop enumerator").toString());
        }

        public ReificationSupportImpl(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Internals.ReificationSupportApi.$init$(this);
        }

        public static final /* synthetic */ Object $anonfun$mkEnumerators$2$adapted(ReificationSupportImpl $this, Trees.Tree x0$1) {
            ReificationSupportImpl.$anonfun$mkEnumerators$2($this, x0$1);
            return BoxedUnit.UNIT;
        }

        public class ScalaMemberRef {
            private final Seq<Symbols.Symbol> symbols;
            public final /* synthetic */ ReificationSupportImpl $outer;

            public Option<Symbols.Symbol> result(Names.Name name) {
                return ((TraversableLike)this.symbols.collect(new Serializable(null, name){
                    public static final long serialVersionUID = 0L;
                    private final Names.Name name$2;

                    public final <A1 extends Symbols.Symbol, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                        Names.Name name = x1.name();
                        Names.Name name2 = this.name$2;
                        Object object = !(name != null ? !name.equals(name2) : name2 != null) ? x1 : function1.apply(x1);
                        return (B1)object;
                    }

                    public final boolean isDefinedAt(Symbols.Symbol x1) {
                        Names.Name name = x1.name();
                        Names.Name name2 = this.name$2;
                        boolean bl = !(name != null ? !name.equals(name2) : name2 != null);
                        return bl;
                    }
                    {
                        this.name$2 = name$2;
                    }
                }, Seq$.MODULE$.canBuildFrom())).headOption();
            }

            /*
             * WARNING - void declaration
             * Enabled aggressive block sorting
             */
            public Option<Symbols.Symbol> unapply(Trees.Tree tree) {
                void var2_11;
                boolean bl = false;
                Trees.Select select = null;
                if (tree instanceof Trees.Ident) {
                    Trees.Ident ident = (Trees.Ident)tree;
                    Names.Name name = ident.name();
                    if (this.symbols.contains(ident.symbol())) {
                        Names.Name name2 = name;
                        Names.Name name3 = ident.symbol().name();
                        if (!(name2 != null ? !name2.equals(name3) : name3 != null)) {
                            Some<Symbols.Symbol> some = new Some<Symbols.Symbol>(ident.symbol());
                            return var2_11;
                        }
                    }
                }
                if (tree instanceof Trees.Select) {
                    bl = true;
                    select = (Trees.Select)tree;
                    Trees.Tree scalapkg = select.qualifier();
                    Names.Name name = select.name();
                    if (scalapkg instanceof Trees.Ident) {
                        Trees.Ident ident = (Trees.Ident)scalapkg;
                        Names.Name name4 = ident.name();
                        Names.TermName termName = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$ScalaMemberRef$$$outer().scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().nme().scala_();
                        if (!(termName != null ? !termName.equals(name4) : name4 != null)) {
                            Symbols.Symbol symbol = ident.symbol();
                            Symbols.ModuleSymbol moduleSymbol = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$ScalaMemberRef$$$outer().scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().definitions().ScalaPackage();
                            if (!(symbol != null ? !symbol.equals(moduleSymbol) : moduleSymbol != null)) {
                                Option<Symbols.Symbol> option = this.result(name);
                                return var2_11;
                            }
                        }
                    }
                }
                if (bl) {
                    Trees.Tree tree2 = select.qualifier();
                    Names.Name name = select.name();
                    if (tree2 instanceof Trees.Select) {
                        Trees.Select select2 = (Trees.Select)tree2;
                        Trees.Tree tree3 = select2.qualifier();
                        Names.Name name5 = select2.name();
                        if (tree3 instanceof Trees.Ident) {
                            Names.Name name6 = ((Trees.Ident)tree3).name();
                            Names.TermName termName = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$ScalaMemberRef$$$outer().scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().nme().ROOTPKG();
                            if (!(termName != null ? !termName.equals(name6) : name6 != null)) {
                                Names.TermName termName2 = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$ScalaMemberRef$$$outer().scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().nme().scala_();
                                if (!(termName2 != null ? !termName2.equals(name5) : name5 != null)) {
                                    Option<Symbols.Symbol> option = this.result(name);
                                    return var2_11;
                                }
                            }
                        }
                    }
                }
                None$ none$ = None$.MODULE$;
                return var2_11;
            }

            public /* synthetic */ ReificationSupportImpl scala$reflect$internal$ReificationSupport$ReificationSupportImpl$ScalaMemberRef$$$outer() {
                return this.$outer;
            }

            public ScalaMemberRef(ReificationSupportImpl $outer, Seq<Symbols.Symbol> symbols) {
                this.symbols = symbols;
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }
        }

        public class SyntacticValDefBase
        implements Internals.ReificationSupportApi.SyntacticValDefExtractor {
            private final boolean isMutable;
            public final /* synthetic */ ReificationSupportImpl $outer;

            public Trees.Modifiers modifiers(Trees.Modifiers mods) {
                if (this.isMutable) {
                    return mods.$bar(4096);
                }
                return mods;
            }

            public Trees.ValDef apply(Trees.Modifiers mods, Names.TermName name, Trees.Tree tpt, Trees.Tree rhs) {
                return new Trees.ValDef(this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$SyntacticValDefBase$$$outer().scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer(), this.modifiers(mods), name, tpt, rhs);
            }

            /*
             * WARNING - void declaration
             * Enabled aggressive block sorting
             */
            public Option<Tuple4<Trees.Modifiers, Names.TermName, Trees.Tree, Trees.Tree>> unapply(Trees.Tree tree) {
                void var2_9;
                if (tree instanceof Trees.ValDef) {
                    Trees.ValDef valDef = (Trees.ValDef)tree;
                    Trees.Modifiers mods = valDef.mods();
                    Names.TermName name = valDef.name();
                    Trees.Tree tpt = valDef.tpt();
                    Trees.Tree rhs = valDef.rhs();
                    if (mods.hasFlag(4096L) == this.isMutable) {
                        Some<Tuple4<Trees.Modifiers, Names.TermName, Trees.Tree, Trees.Tree>> some = new Some<Tuple4<Trees.Modifiers, Names.TermName, Trees.Tree, Trees.Tree>>(new Tuple4<Trees.Modifiers, Names.TermName, Trees.Tree, Trees.Tree>(mods, name, tpt, rhs));
                        return var2_9;
                    }
                }
                None$ none$ = None$.MODULE$;
                return var2_9;
            }

            public /* synthetic */ ReificationSupportImpl scala$reflect$internal$ReificationSupport$ReificationSupportImpl$SyntacticValDefBase$$$outer() {
                return this.$outer;
            }

            public SyntacticValDefBase(ReificationSupportImpl $outer, boolean isMutable) {
                this.isMutable = isMutable;
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }
        }

        public class UnForCombination {
            private final Names.TermName name;
            public final /* synthetic */ ReificationSupportImpl $outer;

            /*
             * WARNING - void declaration
             * Enabled aggressive block sorting
             */
            public Option<Tuple2<Trees.Tree, Trees.Tree>> unapply(Trees.Tree tree) {
                Some<Tuple2<Trees.Tree, List<List<Trees.Tree>>>> some;
                void var2_19;
                Some<Tuple2<Trees.Tree, List<List<Trees.Tree>>>> some2 = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnForCombination$$$outer().SyntacticApplied().unapply(tree);
                if (!some2.isEmpty()) {
                    Trees.Tree sel;
                    Trees.Tree tree2 = some2.get()._1();
                    List<List<Trees.Tree>> list = some2.get()._2();
                    Option<Tuple2<Trees.Tree, List<Trees.Tree>>> option = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnForCombination$$$outer().SyntacticTypeApplied().unapply(tree2);
                    if (!option.isEmpty() && (sel = option.get()._1()) instanceof Trees.Select) {
                        Trees.Select select = (Trees.Select)sel;
                        Trees.Tree lhs = select.qualifier();
                        Names.Name meth = select.name();
                        if (list instanceof $colon$colon) {
                            $colon$colon $colon$colon = ($colon$colon)list;
                            List list2 = (List)$colon$colon.head();
                            List list3 = $colon$colon.tl$access$1();
                            if (list2 instanceof $colon$colon) {
                                $colon$colon $colon$colon2 = ($colon$colon)list2;
                                Trees.Tree f = (Trees.Tree)$colon$colon2.head();
                                List list4 = $colon$colon2.tl$access$1();
                                if (((Object)Nil$.MODULE$).equals(list4) && ((Object)Nil$.MODULE$).equals(list3)) {
                                    Names.TermName termName = this.name;
                                    if (!(termName != null ? !termName.equals(meth) : meth != null) && select.hasAttachment(ClassTag$.MODULE$.apply(StdAttachments$ForAttachment$.class))) {
                                        Some<Tuple2<Trees.Tree, Trees.Tree>> some3 = new Some<Tuple2<Trees.Tree, Trees.Tree>>(new Tuple2<Trees.Tree, Trees.Tree>(lhs, f));
                                        return var2_19;
                                    }
                                }
                            }
                        }
                    }
                }
                if (!(some = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnForCombination$$$outer().SyntacticApplied().unapply(tree)).isEmpty()) {
                    Trees.Tree sel;
                    Trees.Tree tree3 = some.get()._1();
                    List<List<Trees.Tree>> list = some.get()._2();
                    Option<Tuple2<Trees.Tree, List<Trees.Tree>>> option = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnForCombination$$$outer().SyntacticTypeApplied().unapply(tree3);
                    if (!option.isEmpty() && (sel = option.get()._1()) instanceof Trees.Select) {
                        Trees.Select select = (Trees.Select)sel;
                        Trees.Tree lhs = select.qualifier();
                        Names.Name meth = select.name();
                        if (list instanceof $colon$colon) {
                            $colon$colon $colon$colon = ($colon$colon)list;
                            List list5 = (List)$colon$colon.head();
                            List list6 = $colon$colon.tl$access$1();
                            if (list5 instanceof $colon$colon) {
                                List list7;
                                $colon$colon $colon$colon3 = ($colon$colon)list5;
                                Trees.Tree f = (Trees.Tree)$colon$colon3.head();
                                List list8 = $colon$colon3.tl$access$1();
                                if (((Object)Nil$.MODULE$).equals(list8) && list6 instanceof $colon$colon && ((Object)Nil$.MODULE$).equals(list7 = (($colon$colon)list6).tl$access$1())) {
                                    Names.TermName termName = this.name;
                                    if (!(termName != null ? !termName.equals(meth) : meth != null) && select.hasAttachment(ClassTag$.MODULE$.apply(StdAttachments$ForAttachment$.class))) {
                                        Some<Tuple2<Trees.Tree, Trees.Tree>> some4 = new Some<Tuple2<Trees.Tree, Trees.Tree>>(new Tuple2<Trees.Tree, Trees.Tree>(lhs, f));
                                        return var2_19;
                                    }
                                }
                            }
                        }
                    }
                }
                None$ none$ = None$.MODULE$;
                return var2_19;
            }

            public /* synthetic */ ReificationSupportImpl scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnForCombination$$$outer() {
                return this.$outer;
            }

            public UnForCombination(ReificationSupportImpl $outer, Names.TermName name) {
                this.name = name;
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }
        }

        public class UnMkTemplate {
            private final boolean isCaseClass;
            public final /* synthetic */ ReificationSupportImpl $outer;

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public Option<Tuple6<List<Trees.Tree>, Trees.ValDef, Trees.Modifiers, List<List<Trees.ValDef>>, List<Trees.Tree>, List<Trees.Tree>>> unapply(Trees.Template templ) {
                block19: {
                    block18: {
                        block17: {
                            if (templ == null) {
                                throw new MatchError((Object)null);
                            }
                            parents = templ.parents();
                            selfType = templ.self();
                            parents = var3_2;
                            selfType = var4_3;
                            tbody = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnMkTemplate$$$outer().scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().treeInfo().untypecheckedTemplBody(templ);
                            if (tbody == null) {
                                throw null;
                            }
                            forall_these /* !! */  = tbody;
                            while (!forall_these /* !! */ .isEmpty()) {
                                var46_8 = (Trees.Tree)forall_these /* !! */ .head();
                                if (!UnMkTemplate.$anonfun$unapply$2(this, var46_8)) {
                                    var41_9 = false;
                                    break block17;
                                }
                                forall_these /* !! */  = (LinearSeqOptimized)forall_these /* !! */ .tail();
                            }
                            var41_9 = true;
                        }
                        if (var41_9) {
                            return UnMkTemplate.result$1(((Trees.Modifiers)this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnMkTemplate$$$outer().scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().NoMods()).$bar(this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnMkTemplate$$$outer().scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().Flag().TRAIT()), Nil$.MODULE$, Nil$.MODULE$, tbody, (List)parents, (Trees.ValDef)selfType);
                        }
                        if (this.indexOfCtor$1(tbody) == -1) {
                            return None$.MODULE$;
                        }
                        span_b = new ListBuffer<A>();
                        span_these = tbody;
                        while (!span_these.isEmpty() && UnMkTemplate.$anonfun$unapply$3(this, var47_12 = span_these.head())) {
                            span_b.$plus$eq(span_these.head());
                            span_these = (List)span_these.tail();
                        }
                        rawEdefs = span_b.toList();
                        rest = var43_11;
                        rawEdefs = var8_13;
                        rest = var9_14;
                        var12_17 = rawEdefs.partition((Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$unapply$4$adapted(scala.reflect.internal.ReificationSupport$ReificationSupportImpl$UnMkTemplate scala.reflect.internal.Trees$Tree ), (Lscala/reflect/internal/Trees$Tree;)Ljava/lang/Object;)((UnMkTemplate)this));
                        if (var12_17 == null) {
                            throw new MatchError((Object)null);
                        }
                        gvdefs = (List)var12_17._1();
                        etdefs = (List)var12_17._2();
                        gvdefs = var13_18;
                        etdefs = var14_19;
                        var17_22 = rest.splitAt(this.indexOfCtor$1((List)rest));
                        if (var17_22 == null) break block18;
                        fieldDefs = var17_22._1();
                        var19_24 = var17_22._2();
                        if (!(var19_24 instanceof $colon$colon)) break block18;
                        var20_25 = ($colon$colon)var19_24;
                        var21_26 = (Trees.Tree)var20_25.head();
                        body = var20_25.tl$access$1();
                        var23_28 = this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnMkTemplate$$$outer().UnCtor().unapply(var21_26);
                        if (!var23_28.isEmpty()) break block19;
                    }
                    throw new MatchError(var17_22);
                }
                ctorMods = var23_28.get()._1();
                ctorVparamss = var23_28.get()._2();
                lvdefs = var23_28.get()._3();
                fieldDefs = var18_23;
                ctorMods = var24_29;
                ctorVparamss = var25_30;
                lvdefs = var26_31;
                body = var22_27;
                evdefs = gvdefs.zip(lvdefs, List$.MODULE$.canBuildFrom()).map((Function1<Tuple2, Trees.ValDef> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$unapply$5(scala.reflect.internal.ReificationSupport$ReificationSupportImpl$UnMkTemplate scala.Tuple2 ), (Lscala/Tuple2;)Lscala/reflect/internal/Trees$ValDef;)((UnMkTemplate)this), List$.MODULE$.canBuildFrom());
                edefs = etdefs.$colon$colon$colon(evdefs);
                if (ctorMods.isTrait()) {
                    return UnMkTemplate.result$1((Trees.Modifiers)ctorMods, Nil$.MODULE$, edefs, (List)body, (List)parents, (Trees.ValDef)selfType);
                }
                if (!(ctorVparamss instanceof $colon$colon)) ** GOTO lbl-1000
                var34_39 = ($colon$colon)ctorVparamss;
                var35_40 = (List)var34_39.head();
                tail = var34_39.tl$access$1();
                if (Nil$.MODULE$.equals(var35_40) && tail instanceof $colon$colon && (var38_43 = (List)(var37_42 = ($colon$colon)tail).head()) instanceof $colon$colon && ((Trees.ValDef)(($colon$colon)var38_43).head()).mods().isImplicit() && !this.isCaseClass) {
                    var2_44 = var37_42;
                } else lbl-1000:
                // 2 sources

                {
                    var2_44 = ctorVparamss;
                }
                modsMap = ((TraversableOnce)fieldDefs.map((Function1<Trees.Tree, Tuple2> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$unapply$6(scala.reflect.internal.Trees$Tree ), (Lscala/reflect/internal/Trees$Tree;)Lscala/Tuple2;)(), List$.MODULE$.canBuildFrom())).toMap(Predef$.MODULE$.$conforms());
                if (!UnMkTemplate.ctorArgsCorrespondToFields$1(var2_44, modsMap)) {
                    return None$.MODULE$;
                }
                var44_46 = (Function1<Trees.ValDef, Trees.ValDef> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$unapply$8(scala.reflect.internal.ReificationSupport$ReificationSupportImpl$UnMkTemplate scala.collection.immutable.Map scala.reflect.internal.Trees$ValDef ), (Lscala/reflect/internal/Trees$ValDef;)Lscala/reflect/internal/Trees$ValDef;)((UnMkTemplate)this, modsMap);
                if (this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnMkTemplate$$$outer().scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer() == null) {
                    throw null;
                }
                var45_47 = var2_44.map((Function1<List, List> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$mmap$1(scala.Function1 scala.collection.immutable.List ), (Lscala/collection/immutable/List;)Lscala/collection/immutable/List;)((Function1)mmap_f), List$.MODULE$.canBuildFrom());
                return UnMkTemplate.result$1((Trees.Modifiers)ctorMods, var45_47, edefs, (List)body, (List)parents, (Trees.ValDef)selfType);
            }

            public UnMkTemplate asCase() {
                return new UnMkTemplate(this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnMkTemplate$$$outer(), true);
            }

            public /* synthetic */ ReificationSupportImpl scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnMkTemplate$$$outer() {
                return this.$outer;
            }

            private static final Some result$1(Trees.Modifiers ctorMods, List vparamss, List edefs, List body, List parents$1, Trees.ValDef selfType$1) {
                return new Some<Tuple6<List, Trees.ValDef, Trees.Modifiers, List, List, List>>(new Tuple6<List, Trees.ValDef, Trees.Modifiers, List, List, List>(parents$1, selfType$1, ctorMods, vparamss, edefs, body));
            }

            private final int indexOfCtor$1(List trees) {
                return trees.indexWhere((Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)x0$1 -> BoxesRunTime.boxToBoolean(bl = !this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnMkTemplate$$$outer().UnCtor().unapply(x0$1).isEmpty()));
            }

            public static final /* synthetic */ boolean $anonfun$unapply$2(UnMkTemplate $this, Trees.Tree tree) {
                return $this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnMkTemplate$$$outer().scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().treeInfo().isInterfaceMember(tree);
            }

            public static final /* synthetic */ boolean $anonfun$unapply$3(UnMkTemplate $this, Trees.Tree tree) {
                return $this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnMkTemplate$$$outer().scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().treeInfo().isEarlyDef(tree);
            }

            public static final /* synthetic */ boolean $anonfun$unapply$4(UnMkTemplate $this, Trees.Tree tree) {
                return $this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnMkTemplate$$$outer().scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().treeInfo().isEarlyValDef(tree);
            }

            public static final /* synthetic */ Trees.ValDef $anonfun$unapply$5(UnMkTemplate $this, Tuple2 x0$1) {
                Trees.TypeTree typeTree;
                Trees.ValDef valDef;
                Trees.Tree tree;
                block5: {
                    block4: {
                        Trees.Tree tpt;
                        if (x0$1 == null) break block4;
                        Trees.Tree gvdef = (Trees.Tree)x0$1._1();
                        tree = (Trees.Tree)x0$1._2();
                        if (!(gvdef instanceof Trees.ValDef) || !((tpt = (valDef = (Trees.ValDef)gvdef).tpt()) instanceof Trees.TypeTree)) break block4;
                        typeTree = (Trees.TypeTree)tpt;
                        if (tree instanceof Trees.ValDef) break block5;
                    }
                    if (x0$1 != null) {
                        Trees.Tree tr1 = (Trees.Tree)x0$1._1();
                        Trees.Tree tr2 = (Trees.Tree)x0$1._2();
                        throw new MatchError(new Tuple2<Trees.Tree, Trees.Tree>(tr1, tr2));
                    }
                    throw new MatchError((Object)null);
                }
                Trees.Tree rhs = ((Trees.ValDef)tree).rhs();
                Trees.Tree x$2 = typeTree.original();
                Trees.Modifiers x$4 = $this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnMkTemplate$$$outer().scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyValDef$default$2(valDef);
                Names.Name x$5 = $this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnMkTemplate$$$outer().scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyValDef$default$3(valDef);
                Trees.ValDef valDef2 = $this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnMkTemplate$$$outer().scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().copyValDef(valDef, x$4, x$5, x$2, rhs);
                return valDef2;
            }

            /*
             * WARNING - void declaration
             */
            public static final /* synthetic */ Tuple2 $anonfun$unapply$6(Trees.Tree x0$2) {
                void $minus$greater$extension_$this;
                Trees.Modifiers mods;
                if (x0$2 instanceof Trees.ValDef) {
                    Trees.ValDef valDef = (Trees.ValDef)x0$2;
                    mods = valDef.mods();
                    Names.TermName name = valDef.name();
                    Names.TermName termName = Predef$.MODULE$.ArrowAssoc(name);
                    if (Predef$ArrowAssoc$.MODULE$ == null) {
                        throw null;
                    }
                } else {
                    throw new MatchError(x0$2);
                }
                Tuple2<void, Trees.Modifiers> tuple2 = new Tuple2<void, Trees.Modifiers>($minus$greater$extension_$this, mods);
                return tuple2;
            }

            private static final boolean ctorArgsCorrespondToFields$1(List vparamssRestoredImplicits$1, Map modsMap$1) {
                return ((LinearSeqOptimized)((Object)vparamssRestoredImplicits$1.flatten((Function1)Predef$.MODULE$.$conforms()))).forall((Function1<Trees.ValDef, Object> & java.io.Serializable & Serializable)vd -> BoxesRunTime.boxToBoolean(modsMap$1.contains(vd.name())));
            }

            public static final /* synthetic */ Trees.ValDef $anonfun$unapply$8(UnMkTemplate $this, Map modsMap$1, Trees.ValDef vd) {
                Trees.Modifiers originalMods = ((Trees.Modifiers)modsMap$1.apply(vd.name())).$bar(vd.mods().flags() & 0x2000000L);
                return $this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnMkTemplate$$$outer().scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer().atPos(vd.pos(), new Trees.ValDef($this.scala$reflect$internal$ReificationSupport$ReificationSupportImpl$UnMkTemplate$$$outer().scala$reflect$internal$ReificationSupport$ReificationSupportImpl$$$outer(), originalMods, vd.name(), vd.tpt(), vd.rhs()));
            }

            public UnMkTemplate(ReificationSupportImpl $outer, boolean isCaseClass) {
                this.isCaseClass = isCaseClass;
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }

            public static final /* synthetic */ Object $anonfun$unapply$2$adapted(UnMkTemplate $this, Trees.Tree tree) {
                return BoxesRunTime.boxToBoolean(UnMkTemplate.$anonfun$unapply$2($this, tree));
            }

            public static final /* synthetic */ Object $anonfun$unapply$3$adapted(UnMkTemplate $this, Trees.Tree tree) {
                return BoxesRunTime.boxToBoolean(UnMkTemplate.$anonfun$unapply$3($this, tree));
            }

            public static final /* synthetic */ Object $anonfun$unapply$4$adapted(UnMkTemplate $this, Trees.Tree tree) {
                return BoxesRunTime.boxToBoolean(UnMkTemplate.$anonfun$unapply$4($this, tree));
            }
        }
    }
}

