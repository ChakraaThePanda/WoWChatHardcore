/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.runtime;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import scala.Console$;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Seq;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Map;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.HashSet;
import scala.collection.mutable.WeakHashMap;
import scala.ref.WeakReference;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.Manifest;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Internals;
import scala.reflect.api.Mirror;
import scala.reflect.api.Symbols;
import scala.reflect.api.Trees;
import scala.reflect.api.TypeCreator;
import scala.reflect.api.TypeTags;
import scala.reflect.api.Types;
import scala.reflect.internal.AnnotationInfos;
import scala.reflect.internal.BaseTypeSeqs;
import scala.reflect.internal.BaseTypeSeqsStats;
import scala.reflect.internal.Constants;
import scala.reflect.internal.Depth;
import scala.reflect.internal.Internals;
import scala.reflect.internal.Names;
import scala.reflect.internal.Reporter;
import scala.reflect.internal.Reporting;
import scala.reflect.internal.ScopeStats;
import scala.reflect.internal.Scopes;
import scala.reflect.internal.SomePhase$;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.SymbolTableStats;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.SymbolsStats;
import scala.reflect.internal.Trees;
import scala.reflect.internal.TreesStats;
import scala.reflect.internal.Types;
import scala.reflect.internal.TypesStats;
import scala.reflect.internal.tpe.CommonOwners;
import scala.reflect.internal.tpe.TypeComparers;
import scala.reflect.internal.tpe.TypeConstraints;
import scala.reflect.internal.util.FreshNameCreator;
import scala.reflect.internal.util.Position;
import scala.reflect.internal.util.Statistics;
import scala.reflect.macros.Attachments;
import scala.reflect.macros.Universe;
import scala.reflect.package$;
import scala.reflect.runtime.Gil;
import scala.reflect.runtime.JavaMirrors;
import scala.reflect.runtime.JavaUniverse$treeInfo$;
import scala.reflect.runtime.JavaUniverseForce;
import scala.reflect.runtime.ReflectSetup;
import scala.reflect.runtime.Settings;
import scala.reflect.runtime.SymbolLoaders;
import scala.reflect.runtime.SymbolTable;
import scala.reflect.runtime.SynchronizedOps;
import scala.reflect.runtime.SynchronizedSymbols;
import scala.reflect.runtime.SynchronizedTypes;
import scala.reflect.runtime.ThreadLocalStorage;
import scala.reflect.runtime.TwoWayCaches;
import scala.runtime.LambdaDeserialize;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0015e\u0001B\u000f\u001f\u0001\u0015BQ!\u000e\u0001\u0005\u0002YBQ\u0001\u000f\u0001\u0005\u0002eBQ!\u0010\u0001\u0005\u0002eB\u0001B\u0010\u0001\t\u0006\u0004%\ta\u0010\u0005\b\u0007\u0002\u0011\r\u0011\"\u0012E\u0011\u0019A\u0005\u0001)A\u0007\u000b\"91\u000b\u0001b\u0001\n\u0013!\u0006BB-\u0001A\u0003%Q\u000bC\u0003[\u0001\u0011\u00051\fC\u0003h\u0001\u0011\u0005\u0003\u000eC\u0003m\u0001\u0011\u0005QN\u0002\u0003v\u0001\u00011\b\"B\u001b\r\t\u0003Q\b\"\u0002?\r\t\u0003i\bbBA\u0018\u0001\u0011E\u0011\u0011G\u0003\u0007\u0003g\u0001\u0001!!\u000e\t\u0013\u0005}\u0002A1A\u0005\u0004\u0005\u0005\u0003\u0002CA'\u0001\u0001\u0006I!a\u0011\t\u000f\u0005=\u0003\u0001\"\u0001\u0002R!9\u00111\u000b\u0001\u0005\u0002\u0005E\u0003bBA+\u0001\u0011\u0005\u0011q\u000b\u0005\nS\u0001A)\u0019!C!\u0003?:q!a\u001b\u0001\u0011\u0003\tiGB\u0004\u0002p\u0001A\t!!\u001d\t\u0013\u0005e\u0004D1A\u0005\u0002\u0005m\u0004BCA?1\u0011\u0005\t\u0011)A\u0005!\"1Q\u0007\u0007C\u0001\u0003\u007fBq!!!\u0001\t\u0003\t\u0019I\u0001\u0007KCZ\fWK\\5wKJ\u001cXM\u0003\u0002 A\u00059!/\u001e8uS6,'BA\u0011#\u0003\u001d\u0011XM\u001a7fGRT\u0011aI\u0001\u0006g\u000e\fG.Y\u0002\u0001'\u0015\u0001a\u0005\f\u00194!\t9#&D\u0001)\u0015\tI\u0003%\u0001\u0005j]R,'O\\1m\u0013\tY\u0003FA\u0006Ts6\u0014w\u000e\u001c+bE2,\u0007CA\u0017/\u001b\u0005q\u0012BA\u0018\u001f\u0005EQ\u0015M^1V]&4XM]:f\r>\u00148-\u001a\t\u0003[EJ!A\r\u0010\u0003\u0019I+g\r\\3diN+G/\u001e9\u0011\u00055\"\u0014BA\u0016\u001f\u0003\u0019a\u0014N\\5u}Q\tq\u0007\u0005\u0002.\u0001\u0005a\u0001/[2lY\u0016\u0014\b\u000b[1tKV\t!H\u0004\u0002(w%\u0011A\bK\u0001\n'>lW\r\u00155bg\u0016\fA\"\u001a:bgV\u0014X\r\u00155bg\u0016\f\u0001b]3ui&twm]\u000b\u0002\u0001B\u0011Q&Q\u0005\u0003\u0005z\u0011\u0001bU3ui&twm]\u0001\u000bgR\fG/[:uS\u000e\u001cX#A#\u0013\u0007\u0019KuJ\u0002\u0003H\r\u0001)%\u0001\u0004\u001fsK\u001aLg.Z7f]Rt\u0014aC:uCRL7\u000f^5dg\u0002\u0002\"AS'\u000e\u0003-S!\u0001\u0014\u0015\u0002\tU$\u0018\u000e\\\u0005\u0003\u001d.\u0013!b\u0015;bi&\u001cH/[2t!\t\u0001\u0016+D\u0001\u0001\u0013\t\u0011&F\u0001\u0007SK\u001adWm\u0019;Ti\u0006$8/A\u0005jg2{wmZ5oOV\tQ\u000b\u0005\u0002W/6\t!%\u0003\u0002YE\t9!i\\8mK\u0006t\u0017AC5t\u0019><w-\u001b8hA\u0005\u0019An\\4\u0015\u0005q{\u0006C\u0001,^\u0013\tq&E\u0001\u0003V]&$\bB\u00021\n\t\u0003\u0007\u0011-A\u0002ng\u001e\u00042A\u00162e\u0013\t\u0019'E\u0001\u0005=Eft\u0017-\\3?!\t1V-\u0003\u0002gE\t1\u0011I\\=SK\u001a\f\u0001B]3q_J$XM]\u000b\u0002SB\u0011qE[\u0005\u0003W\"\u0012\u0001BU3q_J$XM]\u0001\u000bGV\u0014(/\u001a8u%VtW#\u00018\u0013\u0007=$\u0007O\u0002\u0003H\u0017\u0001q\u0007C\u0001)r\u0013\t\u00118O\u0001\u0007Sk:\u0014V\r]8si&tw-\u0003\u0002uQ\tI!+\u001a9peRLgn\u001a\u0002\u0010!\u0016\u0014(+\u001e8SKB|'\u000f^5oON\u0011Ab\u001e\t\u0003!bL!!_:\u0003'A+'OU;o%\u0016\u0004xN\u001d;j]\u001e\u0014\u0015m]3\u0015\u0003m\u0004\"\u0001\u0015\u0007\u0002%\u0011,\u0007O]3dCRLwN\\,be:Lgn\u001a\u000b\u000b9z\fY!a\t\u0002(\u0005-\u0002BB@\u000f\u0001\u0004\t\t!A\u0002q_N\u00042\u0001UA\u0002\u0013\u0011\t)!a\u0002\u0003\u0011A{7/\u001b;j_:L1!!\u0003)\u0005%\u0001vn]5uS>t7\u000f\u0003\u0004a\u001d\u0001\u0007\u0011Q\u0002\t\u0005\u0003\u001f\tiB\u0004\u0003\u0002\u0012\u0005e\u0001cAA\nE5\u0011\u0011Q\u0003\u0006\u0004\u0003/!\u0013A\u0002\u001fs_>$h(C\u0002\u0002\u001c\t\na\u0001\u0015:fI\u00164\u0017\u0002BA\u0010\u0003C\u0011aa\u0015;sS:<'bAA\u000eE!9\u0011Q\u0005\bA\u0002\u00055\u0011!B:j]\u000e,\u0007bBA\u0015\u001d\u0001\u0007\u0011QB\u0001\u0005g&$X\rC\u0004\u0002.9\u0001\r!!\u0004\u0002\r=\u0014\u0018nZ5o\u0003=\u0001VM\u001d*v]J+\u0007o\u001c:uS:<W#A>\u0003\u0015Q\u0013X-Z\"pa&,'\u000fE\u0002Q\u0003oIA!!\u000f\u0002<\t)\u0012J\u001c;fe:\fG\u000e\u0016:fK\u000e{\u0007/[3s\u001fB\u001c\u0018bAA\u001fQ\t)AK]3fg\u0006iAK]3f\u0007>\u0004\u0018.\u001a:UC\u001e,\"!a\u0011\u0011\r\u0005\u0015\u0013qIA&\u001b\u0005\u0001\u0013bAA%A\tA1\t\\1tgR\u000bw\r\u0005\u0002Q!\u0005qAK]3f\u0007>\u0004\u0018.\u001a:UC\u001e\u0004\u0013a\u00058foN#(/[2u)J,WmQ8qS\u0016\u0014XCAA&\u0003EqWm\u001e'buf$&/Z3D_BLWM]\u0001\u0018GV\u0014(/\u001a8u\rJ,7\u000f\u001b(b[\u0016\u001c%/Z1u_J,\"!!\u0017\u0011\u0007)\u000bY&C\u0002\u0002^-\u0013\u0001C\u0012:fg\"t\u0015-\\3De\u0016\fGo\u001c:\u0016\u0005\u0005\u0005\u0004c\u0001)\u0002d%!\u0011QMA4\u0005!Ie\u000e^3s]\u0006d\u0017bAA5Q\tI\u0011J\u001c;fe:\fGn]\u0001\tiJ,W-\u00138g_B\u0011\u0001\u000b\u0007\u0002\tiJ,W-\u00138g_N\u0019\u0001$a\u001d\u0011\u0007\u001d\n)(C\u0002\u0002x!\u0012\u0001\u0002\u0016:fK&sgm\\\u0001\u0007O2|'-\u00197\u0016\u0003A\u000bqa\u001a7pE\u0006d\u0007\u0005\u0006\u0002\u0002n\u0005!\u0011N\\5u)\u0005a\u0006")
public class JavaUniverse
extends scala.reflect.internal.SymbolTable
implements JavaUniverseForce,
ReflectSetup,
SymbolTable {
    private Settings settings;
    private Universe.MacroInternalApi internal;
    private volatile JavaUniverse$treeInfo$ treeInfo$module;
    private final Statistics statistics;
    private final boolean isLogging;
    private final ClassTag<Trees.InternalTreeCopierOps> TreeCopierTag;
    private ReentrantLock scala$reflect$runtime$Gil$$gil;
    private Object scala$reflect$runtime$SynchronizedTypes$$uniqueLock;
    private final WeakHashMap<Types.Type, java.lang.ref.WeakReference<Types.Type>> scala$reflect$runtime$SynchronizedTypes$$uniques;
    private ThreadLocalStorage.ThreadLocalStorage<Object> scala$reflect$runtime$SynchronizedTypes$$_skolemizationLevel;
    private ThreadLocalStorage.ThreadLocalStorage<TypeConstraints.UndoLog> scala$reflect$runtime$SynchronizedTypes$$_undoLog;
    private ThreadLocalStorage.ThreadLocalStorage<WeakHashMap<List<Types.Type>, WeakReference<Types.Type>>> scala$reflect$runtime$SynchronizedTypes$$_intersectionWitness;
    private ThreadLocalStorage.ThreadLocalStorage<Object> scala$reflect$runtime$SynchronizedTypes$$_subsametypeRecursions;
    private ThreadLocalStorage.ThreadLocalStorage<HashSet<TypeComparers.SubTypePair>> scala$reflect$runtime$SynchronizedTypes$$_pendingSubTypes;
    private ThreadLocalStorage.ThreadLocalStorage<Object> scala$reflect$runtime$SynchronizedTypes$$_basetypeRecursions;
    private ThreadLocalStorage.ThreadLocalStorage<HashSet<Types.Type>> scala$reflect$runtime$SynchronizedTypes$$_pendingBaseTypes;
    private ThreadLocalStorage.ThreadLocalStorage<HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type>> scala$reflect$runtime$SynchronizedTypes$$_lubResults;
    private ThreadLocalStorage.ThreadLocalStorage<HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type>> scala$reflect$runtime$SynchronizedTypes$$_glbResults;
    private ThreadLocalStorage.ThreadLocalStorage<String> scala$reflect$runtime$SynchronizedTypes$$_indent;
    private ThreadLocalStorage.ThreadLocalStorage<Object> scala$reflect$runtime$SynchronizedTypes$$_toStringRecursions;
    private ThreadLocalStorage.ThreadLocalStorage<HashSet<Types.Type>> scala$reflect$runtime$SynchronizedTypes$$_toStringSubjects;
    private AtomicInteger scala$reflect$runtime$SynchronizedSymbols$$atomicIds;
    private AtomicInteger scala$reflect$runtime$SynchronizedSymbols$$atomicExistentialIds;
    private ThreadLocalStorage.ThreadLocalStorage<Map<Symbols.Symbol, Object>> scala$reflect$runtime$SynchronizedSymbols$$_recursionTable;
    private WeakHashMap<ClassLoader, WeakReference<JavaMirrors.JavaMirror>> scala$reflect$runtime$JavaMirrors$$mirrors;
    private final ClassTag<JavaMirrors.JavaMirror> MirrorTag;
    private JavaMirrors.JavaMirror rootMirror;
    private final ClassTag<Class<?>> RuntimeClassTag;
    private final int currentRunId;
    private volatile int bitmap$0;

    @Override
    public void info(Function0<String> msg) {
        SymbolTable.info$(this, msg);
    }

    @Override
    public void debugInfo(Function0<String> msg) {
        SymbolTable.debugInfo$(this, msg);
    }

    @Override
    public boolean isCompilerUniverse() {
        return SymbolTable.isCompilerUniverse$(this);
    }

    @Override
    public final <T> ThreadLocalStorage.ThreadLocalStorage<T> mkThreadLocalStorage(Function0<T> x) {
        return ThreadLocalStorage.mkThreadLocalStorage$(this, x);
    }

    @Override
    public final <T> T gilSynchronized(Function0<T> body) {
        return (T)Gil.gilSynchronized$(this, body);
    }

    @Override
    public boolean synchronizeNames() {
        return SynchronizedOps.synchronizeNames$(this);
    }

    @Override
    public BaseTypeSeqs.BaseTypeSeq newBaseTypeSeq(List<Types.Type> parents, Types.Type[] elems) {
        return SynchronizedOps.newBaseTypeSeq$(this, parents, elems);
    }

    @Override
    public BaseTypeSeqs.MappedBaseTypeSeq newMappedBaseTypeSeq(BaseTypeSeqs.BaseTypeSeq orig, Function1<Types.Type, Types.Type> f) {
        return SynchronizedOps.newMappedBaseTypeSeq$(this, orig, f);
    }

    @Override
    public SynchronizedOps.SynchronizedScope newScope() {
        return SynchronizedOps.newScope$(this);
    }

    @Override
    public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedTypes$$super$unique(Types.Type tp) {
        return Types.unique$(this, tp);
    }

    @Override
    public /* synthetic */ void scala$reflect$runtime$SynchronizedTypes$$super$defineUnderlyingOfSingleType(Types.SingleType tpe) {
        Types.defineUnderlyingOfSingleType$(this, tpe);
    }

    @Override
    public /* synthetic */ void scala$reflect$runtime$SynchronizedTypes$$super$defineBaseTypeSeqOfCompoundType(Types.CompoundType tpe) {
        Types.defineBaseTypeSeqOfCompoundType$(this, tpe);
    }

    @Override
    public /* synthetic */ void scala$reflect$runtime$SynchronizedTypes$$super$defineBaseClassesOfCompoundType(Types.CompoundType tpe) {
        Types.defineBaseClassesOfCompoundType$(this, tpe);
    }

    @Override
    public /* synthetic */ void scala$reflect$runtime$SynchronizedTypes$$super$defineParentsOfTypeRef(Types.TypeRef tpe) {
        Types.defineParentsOfTypeRef$(this, tpe);
    }

    @Override
    public /* synthetic */ void scala$reflect$runtime$SynchronizedTypes$$super$defineBaseTypeSeqOfTypeRef(Types.TypeRef tpe) {
        Types.defineBaseTypeSeqOfTypeRef$(this, tpe);
    }

    @Override
    public /* synthetic */ void scala$reflect$runtime$SynchronizedTypes$$super$defineNormalized(Types.TypeRef tr) {
        Types.defineNormalized$(this, tr);
    }

    @Override
    public CommonOwners.CommonOwnerMap commonOwnerMap() {
        return SynchronizedTypes.commonOwnerMap$(this);
    }

    @Override
    public <T extends Types.Type> T unique(T tp) {
        return (T)SynchronizedTypes.unique$(this, tp);
    }

    @Override
    public int skolemizationLevel() {
        return SynchronizedTypes.skolemizationLevel$(this);
    }

    @Override
    public void skolemizationLevel_$eq(int value) {
        SynchronizedTypes.skolemizationLevel_$eq$(this, value);
    }

    @Override
    public TypeConstraints.UndoLog undoLog() {
        return SynchronizedTypes.undoLog$(this);
    }

    @Override
    public WeakHashMap<List<Types.Type>, WeakReference<Types.Type>> intersectionWitness() {
        return SynchronizedTypes.intersectionWitness$(this);
    }

    @Override
    public int subsametypeRecursions() {
        return SynchronizedTypes.subsametypeRecursions$(this);
    }

    @Override
    public void subsametypeRecursions_$eq(int value) {
        SynchronizedTypes.subsametypeRecursions_$eq$(this, value);
    }

    @Override
    public HashSet<TypeComparers.SubTypePair> pendingSubTypes() {
        return SynchronizedTypes.pendingSubTypes$(this);
    }

    @Override
    public int basetypeRecursions() {
        return SynchronizedTypes.basetypeRecursions$(this);
    }

    @Override
    public void basetypeRecursions_$eq(int value) {
        SynchronizedTypes.basetypeRecursions_$eq$(this, value);
    }

    @Override
    public HashSet<Types.Type> pendingBaseTypes() {
        return SynchronizedTypes.pendingBaseTypes$(this);
    }

    @Override
    public HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type> lubResults() {
        return SynchronizedTypes.lubResults$(this);
    }

    @Override
    public HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type> glbResults() {
        return SynchronizedTypes.glbResults$(this);
    }

    @Override
    public String indent() {
        return SynchronizedTypes.indent$(this);
    }

    @Override
    public void indent_$eq(String value) {
        SynchronizedTypes.indent_$eq$(this, value);
    }

    @Override
    public int toStringRecursions() {
        return SynchronizedTypes.toStringRecursions$(this);
    }

    @Override
    public void toStringRecursions_$eq(int value) {
        SynchronizedTypes.toStringRecursions_$eq$(this, value);
    }

    @Override
    public HashSet<Types.Type> toStringSubjects() {
        return SynchronizedTypes.toStringSubjects$(this);
    }

    @Override
    public void defineUnderlyingOfSingleType(Types.SingleType tpe) {
        SynchronizedTypes.defineUnderlyingOfSingleType$(this, tpe);
    }

    @Override
    public void defineBaseTypeSeqOfCompoundType(Types.CompoundType tpe) {
        SynchronizedTypes.defineBaseTypeSeqOfCompoundType$(this, tpe);
    }

    @Override
    public void defineBaseClassesOfCompoundType(Types.CompoundType tpe) {
        SynchronizedTypes.defineBaseClassesOfCompoundType$(this, tpe);
    }

    @Override
    public void defineParentsOfTypeRef(Types.TypeRef tpe) {
        SynchronizedTypes.defineParentsOfTypeRef$(this, tpe);
    }

    @Override
    public void defineBaseTypeSeqOfTypeRef(Types.TypeRef tpe) {
        SynchronizedTypes.defineBaseTypeSeqOfTypeRef$(this, tpe);
    }

    @Override
    public void defineNormalized(Types.TypeRef tr) {
        SynchronizedTypes.defineNormalized$(this, tr);
    }

    @Override
    public /* synthetic */ Symbols.ModuleSymbol scala$reflect$runtime$SynchronizedSymbols$$super$connectModuleToClass(Symbols.ModuleSymbol m, Symbols.ClassSymbol moduleClass) {
        return Symbols.connectModuleToClass$(this, m, moduleClass);
    }

    @Override
    public int nextId() {
        return SynchronizedSymbols.nextId$(this);
    }

    @Override
    public int nextExistentialId() {
        return SynchronizedSymbols.nextExistentialId$(this);
    }

    @Override
    public Map<Symbols.Symbol, Object> recursionTable() {
        return SynchronizedSymbols.recursionTable$(this);
    }

    @Override
    public void recursionTable_$eq(Map<Symbols.Symbol, Object> value) {
        SynchronizedSymbols.recursionTable_$eq$(this, value);
    }

    @Override
    public Symbols.ModuleSymbol connectModuleToClass(Symbols.ModuleSymbol m, Symbols.ClassSymbol moduleClass) {
        return SynchronizedSymbols.connectModuleToClass$(this, m, moduleClass);
    }

    @Override
    public Symbols.FreeTermSymbol newFreeTermSymbol(Names.TermName name, Function0<Object> value, long flags, String origin) {
        return SynchronizedSymbols.newFreeTermSymbol$(this, name, value, flags, origin);
    }

    @Override
    public long newFreeTermSymbol$default$3() {
        return SynchronizedSymbols.newFreeTermSymbol$default$3$(this);
    }

    @Override
    public String newFreeTermSymbol$default$4() {
        return SynchronizedSymbols.newFreeTermSymbol$default$4$(this);
    }

    @Override
    public Symbols.FreeTypeSymbol newFreeTypeSymbol(Names.TypeName name, long flags, String origin) {
        return SynchronizedSymbols.newFreeTypeSymbol$(this, name, flags, origin);
    }

    @Override
    public long newFreeTypeSymbol$default$2() {
        return SynchronizedSymbols.newFreeTypeSymbol$default$2$(this);
    }

    @Override
    public String newFreeTypeSymbol$default$3() {
        return SynchronizedSymbols.newFreeTypeSymbol$default$3$(this);
    }

    @Override
    public Symbols.NoSymbol makeNoSymbol() {
        return SynchronizedSymbols.makeNoSymbol$(this);
    }

    @Override
    public Tuple2<Symbols.ClassSymbol, Symbols.ModuleSymbol> initAndEnterClassAndModule(Symbols.Symbol owner, Names.TypeName name, Function2<Symbols.ClassSymbol, Symbols.ModuleSymbol, Types.LazyType> completer) {
        return SymbolLoaders.initAndEnterClassAndModule$(this, owner, name, completer);
    }

    @Override
    public void setAllInfos(Symbols.Symbol clazz, Symbols.Symbol module, Types.Type info) {
        SymbolLoaders.setAllInfos$(this, clazz, module, info);
    }

    @Override
    public void initClassAndModule(Symbols.Symbol clazz, Symbols.Symbol module, Types.LazyType completer) {
        SymbolLoaders.initClassAndModule$(this, clazz, module, completer);
    }

    @Override
    public void validateClassInfo(Types.ClassInfoType tp) {
        SymbolLoaders.validateClassInfo$(this, tp);
    }

    @Override
    public SymbolLoaders.PackageScope newPackageScope(Symbols.Symbol pkgClass) {
        return SymbolLoaders.newPackageScope$(this, pkgClass);
    }

    @Override
    public Scopes.Scope scopeTransform(Symbols.Symbol owner, Function0<Scopes.Scope> op) {
        return SymbolLoaders.scopeTransform$(this, owner, op);
    }

    @Override
    public /* synthetic */ Symbols.Symbol scala$reflect$runtime$JavaMirrors$$super$missingHook(Symbols.Symbol owner, Names.Name name) {
        return super.missingHook(owner, name);
    }

    @Override
    public ClassLoader rootClassLoader() {
        return JavaMirrors.rootClassLoader$(this);
    }

    @Override
    public JavaMirrors.JavaMirror runtimeMirror(ClassLoader cl) {
        return JavaMirrors.runtimeMirror$(this, cl);
    }

    @Override
    public JavaMirrors.JavaMirror mirrorThatLoaded(Symbols.Symbol sym) {
        return JavaMirrors.mirrorThatLoaded$(this, sym);
    }

    @Override
    public Symbols.Symbol missingHook(Symbols.Symbol owner, Names.Name name) {
        return JavaMirrors.missingHook$(this, owner, name);
    }

    @Override
    public void force() {
        JavaUniverseForce.force$(this);
    }

    @Override
    public JavaUniverse$treeInfo$ treeInfo() {
        if (this.treeInfo$module == null) {
            this.treeInfo$lzycompute$1();
        }
        return this.treeInfo$module;
    }

    private ReentrantLock scala$reflect$runtime$Gil$$gil$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 4) == 0) {
                this.scala$reflect$runtime$Gil$$gil = Gil.scala$reflect$runtime$Gil$$gil$(this);
                this.bitmap$0 |= 4;
            }
        }
        return this.scala$reflect$runtime$Gil$$gil;
    }

    @Override
    public ReentrantLock scala$reflect$runtime$Gil$$gil() {
        if ((this.bitmap$0 & 4) == 0) {
            return this.scala$reflect$runtime$Gil$$gil$lzycompute();
        }
        return this.scala$reflect$runtime$Gil$$gil;
    }

    private Object scala$reflect$runtime$SynchronizedTypes$$uniqueLock$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 8) == 0) {
                this.scala$reflect$runtime$SynchronizedTypes$$uniqueLock = SynchronizedTypes.scala$reflect$runtime$SynchronizedTypes$$uniqueLock$(this);
                this.bitmap$0 |= 8;
            }
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$uniqueLock;
    }

    @Override
    public Object scala$reflect$runtime$SynchronizedTypes$$uniqueLock() {
        if ((this.bitmap$0 & 8) == 0) {
            return this.scala$reflect$runtime$SynchronizedTypes$$uniqueLock$lzycompute();
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$uniqueLock;
    }

    @Override
    public WeakHashMap<Types.Type, java.lang.ref.WeakReference<Types.Type>> scala$reflect$runtime$SynchronizedTypes$$uniques() {
        return this.scala$reflect$runtime$SynchronizedTypes$$uniques;
    }

    private ThreadLocalStorage.ThreadLocalStorage<Object> scala$reflect$runtime$SynchronizedTypes$$_skolemizationLevel$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x10) == 0) {
                this.scala$reflect$runtime$SynchronizedTypes$$_skolemizationLevel = SynchronizedTypes.scala$reflect$runtime$SynchronizedTypes$$_skolemizationLevel$(this);
                this.bitmap$0 |= 0x10;
            }
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_skolemizationLevel;
    }

    @Override
    public ThreadLocalStorage.ThreadLocalStorage<Object> scala$reflect$runtime$SynchronizedTypes$$_skolemizationLevel() {
        if ((this.bitmap$0 & 0x10) == 0) {
            return this.scala$reflect$runtime$SynchronizedTypes$$_skolemizationLevel$lzycompute();
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_skolemizationLevel;
    }

    private ThreadLocalStorage.ThreadLocalStorage<TypeConstraints.UndoLog> scala$reflect$runtime$SynchronizedTypes$$_undoLog$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x20) == 0) {
                this.scala$reflect$runtime$SynchronizedTypes$$_undoLog = SynchronizedTypes.scala$reflect$runtime$SynchronizedTypes$$_undoLog$(this);
                this.bitmap$0 |= 0x20;
            }
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_undoLog;
    }

    @Override
    public ThreadLocalStorage.ThreadLocalStorage<TypeConstraints.UndoLog> scala$reflect$runtime$SynchronizedTypes$$_undoLog() {
        if ((this.bitmap$0 & 0x20) == 0) {
            return this.scala$reflect$runtime$SynchronizedTypes$$_undoLog$lzycompute();
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_undoLog;
    }

    private ThreadLocalStorage.ThreadLocalStorage<WeakHashMap<List<Types.Type>, WeakReference<Types.Type>>> scala$reflect$runtime$SynchronizedTypes$$_intersectionWitness$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x40) == 0) {
                this.scala$reflect$runtime$SynchronizedTypes$$_intersectionWitness = SynchronizedTypes.scala$reflect$runtime$SynchronizedTypes$$_intersectionWitness$(this);
                this.bitmap$0 |= 0x40;
            }
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_intersectionWitness;
    }

    @Override
    public ThreadLocalStorage.ThreadLocalStorage<WeakHashMap<List<Types.Type>, WeakReference<Types.Type>>> scala$reflect$runtime$SynchronizedTypes$$_intersectionWitness() {
        if ((this.bitmap$0 & 0x40) == 0) {
            return this.scala$reflect$runtime$SynchronizedTypes$$_intersectionWitness$lzycompute();
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_intersectionWitness;
    }

    private ThreadLocalStorage.ThreadLocalStorage<Object> scala$reflect$runtime$SynchronizedTypes$$_subsametypeRecursions$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x80) == 0) {
                this.scala$reflect$runtime$SynchronizedTypes$$_subsametypeRecursions = SynchronizedTypes.scala$reflect$runtime$SynchronizedTypes$$_subsametypeRecursions$(this);
                this.bitmap$0 |= 0x80;
            }
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_subsametypeRecursions;
    }

    @Override
    public ThreadLocalStorage.ThreadLocalStorage<Object> scala$reflect$runtime$SynchronizedTypes$$_subsametypeRecursions() {
        if ((this.bitmap$0 & 0x80) == 0) {
            return this.scala$reflect$runtime$SynchronizedTypes$$_subsametypeRecursions$lzycompute();
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_subsametypeRecursions;
    }

    private ThreadLocalStorage.ThreadLocalStorage<HashSet<TypeComparers.SubTypePair>> scala$reflect$runtime$SynchronizedTypes$$_pendingSubTypes$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x100) == 0) {
                this.scala$reflect$runtime$SynchronizedTypes$$_pendingSubTypes = SynchronizedTypes.scala$reflect$runtime$SynchronizedTypes$$_pendingSubTypes$(this);
                this.bitmap$0 |= 0x100;
            }
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_pendingSubTypes;
    }

    @Override
    public ThreadLocalStorage.ThreadLocalStorage<HashSet<TypeComparers.SubTypePair>> scala$reflect$runtime$SynchronizedTypes$$_pendingSubTypes() {
        if ((this.bitmap$0 & 0x100) == 0) {
            return this.scala$reflect$runtime$SynchronizedTypes$$_pendingSubTypes$lzycompute();
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_pendingSubTypes;
    }

    private ThreadLocalStorage.ThreadLocalStorage<Object> scala$reflect$runtime$SynchronizedTypes$$_basetypeRecursions$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x200) == 0) {
                this.scala$reflect$runtime$SynchronizedTypes$$_basetypeRecursions = SynchronizedTypes.scala$reflect$runtime$SynchronizedTypes$$_basetypeRecursions$(this);
                this.bitmap$0 |= 0x200;
            }
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_basetypeRecursions;
    }

    @Override
    public ThreadLocalStorage.ThreadLocalStorage<Object> scala$reflect$runtime$SynchronizedTypes$$_basetypeRecursions() {
        if ((this.bitmap$0 & 0x200) == 0) {
            return this.scala$reflect$runtime$SynchronizedTypes$$_basetypeRecursions$lzycompute();
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_basetypeRecursions;
    }

    private ThreadLocalStorage.ThreadLocalStorage<HashSet<Types.Type>> scala$reflect$runtime$SynchronizedTypes$$_pendingBaseTypes$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x400) == 0) {
                this.scala$reflect$runtime$SynchronizedTypes$$_pendingBaseTypes = SynchronizedTypes.scala$reflect$runtime$SynchronizedTypes$$_pendingBaseTypes$(this);
                this.bitmap$0 |= 0x400;
            }
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_pendingBaseTypes;
    }

    @Override
    public ThreadLocalStorage.ThreadLocalStorage<HashSet<Types.Type>> scala$reflect$runtime$SynchronizedTypes$$_pendingBaseTypes() {
        if ((this.bitmap$0 & 0x400) == 0) {
            return this.scala$reflect$runtime$SynchronizedTypes$$_pendingBaseTypes$lzycompute();
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_pendingBaseTypes;
    }

    private ThreadLocalStorage.ThreadLocalStorage<HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type>> scala$reflect$runtime$SynchronizedTypes$$_lubResults$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x800) == 0) {
                this.scala$reflect$runtime$SynchronizedTypes$$_lubResults = SynchronizedTypes.scala$reflect$runtime$SynchronizedTypes$$_lubResults$(this);
                this.bitmap$0 |= 0x800;
            }
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_lubResults;
    }

    @Override
    public ThreadLocalStorage.ThreadLocalStorage<HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type>> scala$reflect$runtime$SynchronizedTypes$$_lubResults() {
        if ((this.bitmap$0 & 0x800) == 0) {
            return this.scala$reflect$runtime$SynchronizedTypes$$_lubResults$lzycompute();
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_lubResults;
    }

    private ThreadLocalStorage.ThreadLocalStorage<HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type>> scala$reflect$runtime$SynchronizedTypes$$_glbResults$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x1000) == 0) {
                this.scala$reflect$runtime$SynchronizedTypes$$_glbResults = SynchronizedTypes.scala$reflect$runtime$SynchronizedTypes$$_glbResults$(this);
                this.bitmap$0 |= 0x1000;
            }
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_glbResults;
    }

    @Override
    public ThreadLocalStorage.ThreadLocalStorage<HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type>> scala$reflect$runtime$SynchronizedTypes$$_glbResults() {
        if ((this.bitmap$0 & 0x1000) == 0) {
            return this.scala$reflect$runtime$SynchronizedTypes$$_glbResults$lzycompute();
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_glbResults;
    }

    private ThreadLocalStorage.ThreadLocalStorage<String> scala$reflect$runtime$SynchronizedTypes$$_indent$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x2000) == 0) {
                this.scala$reflect$runtime$SynchronizedTypes$$_indent = SynchronizedTypes.scala$reflect$runtime$SynchronizedTypes$$_indent$(this);
                this.bitmap$0 |= 0x2000;
            }
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_indent;
    }

    @Override
    public ThreadLocalStorage.ThreadLocalStorage<String> scala$reflect$runtime$SynchronizedTypes$$_indent() {
        if ((this.bitmap$0 & 0x2000) == 0) {
            return this.scala$reflect$runtime$SynchronizedTypes$$_indent$lzycompute();
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_indent;
    }

    private ThreadLocalStorage.ThreadLocalStorage<Object> scala$reflect$runtime$SynchronizedTypes$$_toStringRecursions$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x4000) == 0) {
                this.scala$reflect$runtime$SynchronizedTypes$$_toStringRecursions = SynchronizedTypes.scala$reflect$runtime$SynchronizedTypes$$_toStringRecursions$(this);
                this.bitmap$0 |= 0x4000;
            }
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_toStringRecursions;
    }

    @Override
    public ThreadLocalStorage.ThreadLocalStorage<Object> scala$reflect$runtime$SynchronizedTypes$$_toStringRecursions() {
        if ((this.bitmap$0 & 0x4000) == 0) {
            return this.scala$reflect$runtime$SynchronizedTypes$$_toStringRecursions$lzycompute();
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_toStringRecursions;
    }

    private ThreadLocalStorage.ThreadLocalStorage<HashSet<Types.Type>> scala$reflect$runtime$SynchronizedTypes$$_toStringSubjects$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x8000) == 0) {
                this.scala$reflect$runtime$SynchronizedTypes$$_toStringSubjects = SynchronizedTypes.scala$reflect$runtime$SynchronizedTypes$$_toStringSubjects$(this);
                this.bitmap$0 |= 0x8000;
            }
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_toStringSubjects;
    }

    @Override
    public ThreadLocalStorage.ThreadLocalStorage<HashSet<Types.Type>> scala$reflect$runtime$SynchronizedTypes$$_toStringSubjects() {
        if ((this.bitmap$0 & 0x8000) == 0) {
            return this.scala$reflect$runtime$SynchronizedTypes$$_toStringSubjects$lzycompute();
        }
        return this.scala$reflect$runtime$SynchronizedTypes$$_toStringSubjects;
    }

    @Override
    public final void scala$reflect$runtime$SynchronizedTypes$_setter_$scala$reflect$runtime$SynchronizedTypes$$uniques_$eq(WeakHashMap<Types.Type, java.lang.ref.WeakReference<Types.Type>> x$1) {
        this.scala$reflect$runtime$SynchronizedTypes$$uniques = x$1;
    }

    private AtomicInteger scala$reflect$runtime$SynchronizedSymbols$$atomicIds$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x10000) == 0) {
                this.scala$reflect$runtime$SynchronizedSymbols$$atomicIds = SynchronizedSymbols.scala$reflect$runtime$SynchronizedSymbols$$atomicIds$(this);
                this.bitmap$0 |= 0x10000;
            }
        }
        return this.scala$reflect$runtime$SynchronizedSymbols$$atomicIds;
    }

    @Override
    public AtomicInteger scala$reflect$runtime$SynchronizedSymbols$$atomicIds() {
        if ((this.bitmap$0 & 0x10000) == 0) {
            return this.scala$reflect$runtime$SynchronizedSymbols$$atomicIds$lzycompute();
        }
        return this.scala$reflect$runtime$SynchronizedSymbols$$atomicIds;
    }

    private AtomicInteger scala$reflect$runtime$SynchronizedSymbols$$atomicExistentialIds$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x20000) == 0) {
                this.scala$reflect$runtime$SynchronizedSymbols$$atomicExistentialIds = SynchronizedSymbols.scala$reflect$runtime$SynchronizedSymbols$$atomicExistentialIds$(this);
                this.bitmap$0 |= 0x20000;
            }
        }
        return this.scala$reflect$runtime$SynchronizedSymbols$$atomicExistentialIds;
    }

    @Override
    public AtomicInteger scala$reflect$runtime$SynchronizedSymbols$$atomicExistentialIds() {
        if ((this.bitmap$0 & 0x20000) == 0) {
            return this.scala$reflect$runtime$SynchronizedSymbols$$atomicExistentialIds$lzycompute();
        }
        return this.scala$reflect$runtime$SynchronizedSymbols$$atomicExistentialIds;
    }

    private ThreadLocalStorage.ThreadLocalStorage<Map<Symbols.Symbol, Object>> scala$reflect$runtime$SynchronizedSymbols$$_recursionTable$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x40000) == 0) {
                this.scala$reflect$runtime$SynchronizedSymbols$$_recursionTable = SynchronizedSymbols.scala$reflect$runtime$SynchronizedSymbols$$_recursionTable$(this);
                this.bitmap$0 |= 0x40000;
            }
        }
        return this.scala$reflect$runtime$SynchronizedSymbols$$_recursionTable;
    }

    @Override
    public ThreadLocalStorage.ThreadLocalStorage<Map<Symbols.Symbol, Object>> scala$reflect$runtime$SynchronizedSymbols$$_recursionTable() {
        if ((this.bitmap$0 & 0x40000) == 0) {
            return this.scala$reflect$runtime$SynchronizedSymbols$$_recursionTable$lzycompute();
        }
        return this.scala$reflect$runtime$SynchronizedSymbols$$_recursionTable;
    }

    private WeakHashMap<ClassLoader, WeakReference<JavaMirrors.JavaMirror>> scala$reflect$runtime$JavaMirrors$$mirrors$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x80000) == 0) {
                this.scala$reflect$runtime$JavaMirrors$$mirrors = JavaMirrors.scala$reflect$runtime$JavaMirrors$$mirrors$(this);
                this.bitmap$0 |= 0x80000;
            }
        }
        return this.scala$reflect$runtime$JavaMirrors$$mirrors;
    }

    @Override
    public WeakHashMap<ClassLoader, WeakReference<JavaMirrors.JavaMirror>> scala$reflect$runtime$JavaMirrors$$mirrors() {
        if ((this.bitmap$0 & 0x80000) == 0) {
            return this.scala$reflect$runtime$JavaMirrors$$mirrors$lzycompute();
        }
        return this.scala$reflect$runtime$JavaMirrors$$mirrors;
    }

    @Override
    public ClassTag<JavaMirrors.JavaMirror> MirrorTag() {
        return this.MirrorTag;
    }

    private JavaMirrors.JavaMirror rootMirror$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 0x100000) == 0) {
                this.rootMirror = JavaMirrors.rootMirror$(this);
                this.bitmap$0 |= 0x100000;
            }
        }
        return this.rootMirror;
    }

    @Override
    public JavaMirrors.JavaMirror rootMirror() {
        if ((this.bitmap$0 & 0x100000) == 0) {
            return this.rootMirror$lzycompute();
        }
        return this.rootMirror;
    }

    @Override
    public void scala$reflect$runtime$JavaMirrors$_setter_$MirrorTag_$eq(ClassTag<JavaMirrors.JavaMirror> x$1) {
        this.MirrorTag = x$1;
    }

    @Override
    public ClassTag<Class<?>> RuntimeClassTag() {
        return this.RuntimeClassTag;
    }

    @Override
    public void scala$reflect$api$JavaUniverse$_setter_$RuntimeClassTag_$eq(ClassTag<Class<?>> x$1) {
        this.RuntimeClassTag = x$1;
    }

    @Override
    public int currentRunId() {
        return this.currentRunId;
    }

    @Override
    public void scala$reflect$runtime$ReflectSetup$_setter_$currentRunId_$eq(int x$1) {
        this.currentRunId = x$1;
    }

    @Override
    public SomePhase$ picklerPhase() {
        return SomePhase$.MODULE$;
    }

    @Override
    public SomePhase$ erasurePhase() {
        return SomePhase$.MODULE$;
    }

    private Settings settings$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 1) == 0) {
                this.settings = new Settings();
                this.bitmap$0 |= 1;
            }
        }
        return this.settings;
    }

    @Override
    public Settings settings() {
        if ((this.bitmap$0 & 1) == 0) {
            return this.settings$lzycompute();
        }
        return this.settings;
    }

    @Override
    public final Statistics statistics() {
        return this.statistics;
    }

    private boolean isLogging() {
        return this.isLogging;
    }

    @Override
    public void log(Function0<Object> msg) {
        if (this.isLogging()) {
            Console$.MODULE$.err().println(new StringBuilder(10).append("[reflect] ").append(msg.apply()).toString());
        }
    }

    @Override
    public Reporter reporter() {
        return new Reporter(this){
            private final /* synthetic */ JavaUniverse $outer;

            public void info0(Position pos, String msg, Reporter.Severity severity, boolean force) {
                this.$outer.log((Function0<Object>)(Function0<String> & java.io.Serializable & Serializable)() -> msg);
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$info0$1(java.lang.String )}, serializedLambda);
            }
        };
    }

    @Override
    public Reporting.RunReporting currentRun() {
        return new Reporting.RunReporting(this){
            private final PerRunReporting reporting;
            private final /* synthetic */ JavaUniverse $outer;

            public PerRunReporting reporting() {
                return this.reporting;
            }

            public void scala$reflect$internal$Reporting$RunReporting$_setter_$reporting_$eq(PerRunReporting x$1) {
                this.reporting = x$1;
            }

            public /* synthetic */ Reporting scala$reflect$internal$Reporting$RunReporting$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                Reporting.RunReporting.$init$(this);
            }
        };
    }

    @Override
    public PerRunReporting PerRunReporting() {
        return new PerRunReporting(this);
    }

    public ClassTag<Trees.InternalTreeCopierOps> TreeCopierTag() {
        return this.TreeCopierTag;
    }

    @Override
    public Trees.InternalTreeCopierOps newStrictTreeCopier() {
        return new Trees.StrictTreeCopier(this);
    }

    @Override
    public Trees.InternalTreeCopierOps newLazyTreeCopier() {
        return new Trees.LazyTreeCopier(this);
    }

    @Override
    public FreshNameCreator currentFreshNameCreator() {
        return this.globalFreshNameCreator();
    }

    private Universe.MacroInternalApi internal$lzycompute() {
        synchronized (this) {
            if ((this.bitmap$0 & 2) == 0) {
                this.internal = new Internals.SymbolTableInternal(this){
                    private Internals.ReificationSupportApi reificationSupport;
                    private Universe.TreeGen gen;
                    private Universe.MacroInternalApi.MacroDecoratorApi decorators;
                    private volatile byte bitmap$0;
                    private final /* synthetic */ JavaUniverse $outer;

                    public Internals.Importer createImporter(scala.reflect.api.Universe from0) {
                        return Internals.SymbolTableInternal.createImporter$(this, from0);
                    }

                    public Scopes.Scope newScopeWith(Seq<Symbols.Symbol> elems) {
                        return Internals.SymbolTableInternal.newScopeWith$(this, elems);
                    }

                    public Scopes.Scope enter(Scopes.Scope scope, Symbols.Symbol sym) {
                        return Internals.SymbolTableInternal.enter$(this, scope, sym);
                    }

                    public Scopes.Scope unlink(Scopes.Scope scope, Symbols.Symbol sym) {
                        return Internals.SymbolTableInternal.unlink$(this, scope, sym);
                    }

                    public List<Symbols.FreeTermSymbol> freeTerms(Trees.Tree tree) {
                        return Internals.SymbolTableInternal.freeTerms$(this, tree);
                    }

                    public List<Symbols.FreeTypeSymbol> freeTypes(Trees.Tree tree) {
                        return Internals.SymbolTableInternal.freeTypes$(this, tree);
                    }

                    public Trees.Tree substituteSymbols(Trees.Tree tree, List<Symbols.Symbol> from, List<Symbols.Symbol> to) {
                        return Internals.SymbolTableInternal.substituteSymbols$(this, tree, from, to);
                    }

                    public Trees.Tree substituteTypes(Trees.Tree tree, List<Symbols.Symbol> from, List<Types.Type> to) {
                        return Internals.SymbolTableInternal.substituteTypes$(this, tree, from, to);
                    }

                    public Trees.Tree substituteThis(Trees.Tree tree, Symbols.Symbol clazz, Function0<Trees.Tree> to) {
                        return Internals.SymbolTableInternal.substituteThis$(this, tree, clazz, to);
                    }

                    public Attachments attachments(Trees.Tree tree) {
                        return Internals.SymbolTableInternal.attachments$((Internals.SymbolTableInternal)this, tree);
                    }

                    public <T> Trees.Tree updateAttachment(Trees.Tree tree, T attachment, ClassTag<T> evidence$1) {
                        return Internals.SymbolTableInternal.updateAttachment$((Internals.SymbolTableInternal)this, tree, attachment, evidence$1);
                    }

                    public <T> Trees.Tree removeAttachment(Trees.Tree tree, ClassTag<T> evidence$2) {
                        return Internals.SymbolTableInternal.removeAttachment$((Internals.SymbolTableInternal)this, tree, evidence$2);
                    }

                    public Trees.Tree setPos(Trees.Tree tree, Position newpos) {
                        return Internals.SymbolTableInternal.setPos$(this, tree, newpos);
                    }

                    public Trees.Tree setType(Trees.Tree tree, Types.Type tp) {
                        return Internals.SymbolTableInternal.setType$(this, tree, tp);
                    }

                    public Trees.Tree defineType(Trees.Tree tree, Types.Type tp) {
                        return Internals.SymbolTableInternal.defineType$(this, tree, tp);
                    }

                    public Trees.Tree setSymbol(Trees.Tree tree, Symbols.Symbol sym) {
                        return Internals.SymbolTableInternal.setSymbol$(this, tree, sym);
                    }

                    public Trees.TypeTree setOriginal(Trees.TypeTree tt, Trees.Tree tree) {
                        return Internals.SymbolTableInternal.setOriginal$(this, tt, tree);
                    }

                    public void captureVariable(Symbols.Symbol vble) {
                        Internals.SymbolTableInternal.captureVariable$(this, vble);
                    }

                    public Trees.Tree referenceCapturedVariable(Symbols.Symbol vble) {
                        return Internals.SymbolTableInternal.referenceCapturedVariable$(this, vble);
                    }

                    public Types.Type capturedVariableType(Symbols.Symbol vble) {
                        return Internals.SymbolTableInternal.capturedVariableType$(this, vble);
                    }

                    public Trees.ClassDef classDef(Symbols.Symbol sym, Trees.Template impl) {
                        return Internals.SymbolTableInternal.classDef$(this, sym, impl);
                    }

                    public Trees.ModuleDef moduleDef(Symbols.Symbol sym, Trees.Template impl) {
                        return Internals.SymbolTableInternal.moduleDef$(this, sym, impl);
                    }

                    public Trees.ValDef valDef(Symbols.Symbol sym, Trees.Tree rhs) {
                        return Internals.SymbolTableInternal.valDef$(this, sym, rhs);
                    }

                    public Trees.ValDef valDef(Symbols.Symbol sym) {
                        return Internals.SymbolTableInternal.valDef$(this, sym);
                    }

                    public Trees.DefDef defDef(Symbols.Symbol sym, Trees.Modifiers mods, List<List<Trees.ValDef>> vparamss, Trees.Tree rhs) {
                        return Internals.SymbolTableInternal.defDef$(this, sym, mods, vparamss, rhs);
                    }

                    public Trees.DefDef defDef(Symbols.Symbol sym, List<List<Trees.ValDef>> vparamss, Trees.Tree rhs) {
                        return Internals.SymbolTableInternal.defDef$((Internals.SymbolTableInternal)this, sym, vparamss, rhs);
                    }

                    public Trees.DefDef defDef(Symbols.Symbol sym, Trees.Modifiers mods, Trees.Tree rhs) {
                        return Internals.SymbolTableInternal.defDef$((Internals.SymbolTableInternal)this, sym, mods, rhs);
                    }

                    public Trees.DefDef defDef(Symbols.Symbol sym, Trees.Tree rhs) {
                        return Internals.SymbolTableInternal.defDef$((Internals.SymbolTableInternal)this, sym, rhs);
                    }

                    public Trees.DefDef defDef(Symbols.Symbol sym, Function1<List<List<Symbols.Symbol>>, Trees.Tree> rhs) {
                        return Internals.SymbolTableInternal.defDef$((Internals.SymbolTableInternal)this, sym, rhs);
                    }

                    public Trees.TypeDef typeDef(Symbols.Symbol sym, Trees.Tree rhs) {
                        return Internals.SymbolTableInternal.typeDef$(this, sym, rhs);
                    }

                    public Trees.TypeDef typeDef(Symbols.Symbol sym) {
                        return Internals.SymbolTableInternal.typeDef$(this, sym);
                    }

                    public Trees.LabelDef labelDef(Symbols.Symbol sym, List<Symbols.Symbol> params, Trees.Tree rhs) {
                        return Internals.SymbolTableInternal.labelDef$(this, sym, params, rhs);
                    }

                    public Trees.Tree changeOwner(Trees.Tree tree, Symbols.Symbol prev, Symbols.Symbol next) {
                        return Internals.SymbolTableInternal.changeOwner$(this, tree, prev, next);
                    }

                    public boolean isFreeTerm(Symbols.Symbol symbol) {
                        return Internals.SymbolTableInternal.isFreeTerm$(this, symbol);
                    }

                    public Symbols.FreeTermSymbol asFreeTerm(Symbols.Symbol symbol) {
                        return Internals.SymbolTableInternal.asFreeTerm$(this, symbol);
                    }

                    public boolean isFreeType(Symbols.Symbol symbol) {
                        return Internals.SymbolTableInternal.isFreeType$(this, symbol);
                    }

                    public Symbols.FreeTypeSymbol asFreeType(Symbols.Symbol symbol) {
                        return Internals.SymbolTableInternal.asFreeType$(this, symbol);
                    }

                    public Symbols.TermSymbol newTermSymbol(Symbols.Symbol symbol, Names.TermName name, Position pos, long flags) {
                        return Internals.SymbolTableInternal.newTermSymbol$(this, symbol, name, pos, flags);
                    }

                    public Position newTermSymbol$default$3() {
                        return Internals.SymbolTableInternal.newTermSymbol$default$3$(this);
                    }

                    public long newTermSymbol$default$4() {
                        return Internals.SymbolTableInternal.newTermSymbol$default$4$(this);
                    }

                    public Tuple2<Symbols.ModuleSymbol, Symbols.ClassSymbol> newModuleAndClassSymbol(Symbols.Symbol symbol, Names.Name name, Position pos, long flags) {
                        return Internals.SymbolTableInternal.newModuleAndClassSymbol$(this, symbol, name, pos, flags);
                    }

                    public Position newModuleAndClassSymbol$default$3() {
                        return Internals.SymbolTableInternal.newModuleAndClassSymbol$default$3$(this);
                    }

                    public long newModuleAndClassSymbol$default$4() {
                        return Internals.SymbolTableInternal.newModuleAndClassSymbol$default$4$(this);
                    }

                    public Symbols.MethodSymbol newMethodSymbol(Symbols.Symbol symbol, Names.TermName name, Position pos, long flags) {
                        return Internals.SymbolTableInternal.newMethodSymbol$(this, symbol, name, pos, flags);
                    }

                    public Position newMethodSymbol$default$3() {
                        return Internals.SymbolTableInternal.newMethodSymbol$default$3$(this);
                    }

                    public long newMethodSymbol$default$4() {
                        return Internals.SymbolTableInternal.newMethodSymbol$default$4$(this);
                    }

                    public Symbols.TypeSymbol newTypeSymbol(Symbols.Symbol symbol, Names.TypeName name, Position pos, long flags) {
                        return Internals.SymbolTableInternal.newTypeSymbol$(this, symbol, name, pos, flags);
                    }

                    public Position newTypeSymbol$default$3() {
                        return Internals.SymbolTableInternal.newTypeSymbol$default$3$(this);
                    }

                    public long newTypeSymbol$default$4() {
                        return Internals.SymbolTableInternal.newTypeSymbol$default$4$(this);
                    }

                    public Symbols.ClassSymbol newClassSymbol(Symbols.Symbol symbol, Names.TypeName name, Position pos, long flags) {
                        return Internals.SymbolTableInternal.newClassSymbol$(this, symbol, name, pos, flags);
                    }

                    public Position newClassSymbol$default$3() {
                        return Internals.SymbolTableInternal.newClassSymbol$default$3$(this);
                    }

                    public long newClassSymbol$default$4() {
                        return Internals.SymbolTableInternal.newClassSymbol$default$4$(this);
                    }

                    public Symbols.FreeTermSymbol newFreeTerm(String name, Function0<Object> value, long flags, String origin) {
                        return Internals.SymbolTableInternal.newFreeTerm$(this, name, value, flags, origin);
                    }

                    public long newFreeTerm$default$3() {
                        return Internals.SymbolTableInternal.newFreeTerm$default$3$(this);
                    }

                    public String newFreeTerm$default$4() {
                        return Internals.SymbolTableInternal.newFreeTerm$default$4$(this);
                    }

                    public Symbols.FreeTypeSymbol newFreeType(String name, long flags, String origin) {
                        return Internals.SymbolTableInternal.newFreeType$(this, name, flags, origin);
                    }

                    public long newFreeType$default$2() {
                        return Internals.SymbolTableInternal.newFreeType$default$2$(this);
                    }

                    public String newFreeType$default$3() {
                        return Internals.SymbolTableInternal.newFreeType$default$3$(this);
                    }

                    public boolean isErroneous(Symbols.Symbol symbol) {
                        return Internals.SymbolTableInternal.isErroneous$(this, symbol);
                    }

                    public boolean isSkolem(Symbols.Symbol symbol) {
                        return Internals.SymbolTableInternal.isSkolem$(this, symbol);
                    }

                    public Symbols.Symbol deSkolemize(Symbols.Symbol symbol) {
                        return Internals.SymbolTableInternal.deSkolemize$(this, symbol);
                    }

                    public Symbols.Symbol initialize(Symbols.Symbol symbol) {
                        return Internals.SymbolTableInternal.initialize$(this, symbol);
                    }

                    public Symbols.Symbol fullyInitialize(Symbols.Symbol symbol) {
                        return Internals.SymbolTableInternal.fullyInitialize$((Internals.SymbolTableInternal)this, symbol);
                    }

                    public Types.Type fullyInitialize(Types.Type tp) {
                        return Internals.SymbolTableInternal.fullyInitialize$((Internals.SymbolTableInternal)this, tp);
                    }

                    public Scopes.Scope fullyInitialize(Scopes.Scope scope) {
                        return Internals.SymbolTableInternal.fullyInitialize$((Internals.SymbolTableInternal)this, scope);
                    }

                    public long flags(Symbols.Symbol symbol) {
                        return Internals.SymbolTableInternal.flags$(this, symbol);
                    }

                    public Attachments attachments(Symbols.Symbol symbol) {
                        return Internals.SymbolTableInternal.attachments$((Internals.SymbolTableInternal)this, symbol);
                    }

                    public <T> Symbols.Symbol updateAttachment(Symbols.Symbol symbol, T attachment, ClassTag<T> evidence$3) {
                        return Internals.SymbolTableInternal.updateAttachment$((Internals.SymbolTableInternal)this, symbol, attachment, evidence$3);
                    }

                    public <T> Symbols.Symbol removeAttachment(Symbols.Symbol symbol, ClassTag<T> evidence$4) {
                        return Internals.SymbolTableInternal.removeAttachment$((Internals.SymbolTableInternal)this, symbol, evidence$4);
                    }

                    public Symbols.Symbol setOwner(Symbols.Symbol symbol, Symbols.Symbol newowner) {
                        return Internals.SymbolTableInternal.setOwner$(this, symbol, newowner);
                    }

                    public Symbols.Symbol setInfo(Symbols.Symbol symbol, Types.Type tpe) {
                        return Internals.SymbolTableInternal.setInfo$(this, symbol, tpe);
                    }

                    public Symbols.Symbol setAnnotations(Symbols.Symbol symbol, Seq<AnnotationInfos.AnnotationInfo> annots) {
                        return Internals.SymbolTableInternal.setAnnotations$(this, symbol, annots);
                    }

                    public Symbols.Symbol setName(Symbols.Symbol symbol, Names.Name name) {
                        return Internals.SymbolTableInternal.setName$(this, symbol, name);
                    }

                    public Symbols.Symbol setPrivateWithin(Symbols.Symbol symbol, Symbols.Symbol sym) {
                        return Internals.SymbolTableInternal.setPrivateWithin$(this, symbol, sym);
                    }

                    public Symbols.Symbol setFlag(Symbols.Symbol symbol, long flags) {
                        return Internals.SymbolTableInternal.setFlag$(this, symbol, flags);
                    }

                    public Symbols.Symbol resetFlag(Symbols.Symbol symbol, long flags) {
                        return Internals.SymbolTableInternal.resetFlag$(this, symbol, flags);
                    }

                    public Types.Type thisType(Symbols.Symbol sym) {
                        return Internals.SymbolTableInternal.thisType$(this, sym);
                    }

                    public Types.Type singleType(Types.Type pre, Symbols.Symbol sym) {
                        return Internals.SymbolTableInternal.singleType$(this, pre, sym);
                    }

                    public Types.Type superType(Types.Type thistpe, Types.Type supertpe) {
                        return Internals.SymbolTableInternal.superType$(this, thistpe, supertpe);
                    }

                    public Types.ConstantType constantType(Constants.Constant value) {
                        return Internals.SymbolTableInternal.constantType$(this, value);
                    }

                    public Types.Type typeRef(Types.Type pre, Symbols.Symbol sym, List<Types.Type> args2) {
                        return Internals.SymbolTableInternal.typeRef$(this, pre, sym, args2);
                    }

                    public Types.RefinedType refinedType(List<Types.Type> parents, Scopes.Scope decls) {
                        return Internals.SymbolTableInternal.refinedType$((Internals.SymbolTableInternal)this, parents, decls);
                    }

                    public Types.RefinedType refinedType(List<Types.Type> parents, Scopes.Scope decls, Symbols.Symbol clazz) {
                        return Internals.SymbolTableInternal.refinedType$((Internals.SymbolTableInternal)this, parents, decls, clazz);
                    }

                    public Types.Type refinedType(List<Types.Type> parents, Symbols.Symbol owner) {
                        return Internals.SymbolTableInternal.refinedType$((Internals.SymbolTableInternal)this, parents, owner);
                    }

                    public Types.Type refinedType(List<Types.Type> parents, Symbols.Symbol owner, Scopes.Scope decls) {
                        return Internals.SymbolTableInternal.refinedType$((Internals.SymbolTableInternal)this, parents, owner, decls);
                    }

                    public Types.Type refinedType(List<Types.Type> parents, Symbols.Symbol owner, Scopes.Scope decls, Position pos) {
                        return Internals.SymbolTableInternal.refinedType$(this, parents, owner, decls, pos);
                    }

                    public Types.Type intersectionType(List<Types.Type> tps) {
                        return Internals.SymbolTableInternal.intersectionType$(this, tps);
                    }

                    public Types.Type intersectionType(List<Types.Type> tps, Symbols.Symbol owner) {
                        return Internals.SymbolTableInternal.intersectionType$(this, tps, owner);
                    }

                    public Types.ClassInfoType classInfoType(List<Types.Type> parents, Scopes.Scope decls, Symbols.Symbol typeSymbol) {
                        return Internals.SymbolTableInternal.classInfoType$(this, parents, decls, typeSymbol);
                    }

                    public Types.MethodType methodType(List<Symbols.Symbol> params, Types.Type resultType) {
                        return Internals.SymbolTableInternal.methodType$(this, params, resultType);
                    }

                    public Types.NullaryMethodType nullaryMethodType(Types.Type resultType) {
                        return Internals.SymbolTableInternal.nullaryMethodType$(this, resultType);
                    }

                    public Types.PolyType polyType(List<Symbols.Symbol> typeParams, Types.Type resultType) {
                        return Internals.SymbolTableInternal.polyType$(this, typeParams, resultType);
                    }

                    public Types.ExistentialType existentialType(List<Symbols.Symbol> quantified, Types.Type underlying) {
                        return Internals.SymbolTableInternal.existentialType$(this, quantified, underlying);
                    }

                    public Types.Type existentialAbstraction(List<Symbols.Symbol> tparams, Types.Type tpe0) {
                        return Internals.SymbolTableInternal.existentialAbstraction$(this, tparams, tpe0);
                    }

                    public Types.AnnotatedType annotatedType(List<AnnotationInfos.AnnotationInfo> annotations, Types.Type underlying) {
                        return Internals.SymbolTableInternal.annotatedType$(this, annotations, underlying);
                    }

                    public Types.TypeBounds typeBounds(Types.Type lo, Types.Type hi) {
                        return Internals.SymbolTableInternal.typeBounds$(this, lo, hi);
                    }

                    public Types.BoundedWildcardType boundedWildcardType(Types.TypeBounds bounds) {
                        return Internals.SymbolTableInternal.boundedWildcardType$(this, bounds);
                    }

                    public Option<List<Trees.Tree>> subpatterns(Trees.Tree tree) {
                        return Internals.SymbolTableInternal.subpatterns$(this, tree);
                    }

                    public Trees.DefDefApi markForAsyncTransform(Symbols.SymbolApi owner, Trees.DefDefApi method, Symbols.SymbolApi awaitSymbol, Map<String, Object> config) {
                        return Internals.InternalApi.markForAsyncTransform$(this, owner, method, awaitSymbol, config);
                    }

                    private Internals.ReificationSupportApi reificationSupport$lzycompute() {
                        synchronized (this) {
                            if ((byte)(this.bitmap$0 & 1) == 0) {
                                this.reificationSupport = Internals.SymbolTableInternal.reificationSupport$(this);
                                this.bitmap$0 = (byte)(this.bitmap$0 | 1);
                            }
                        }
                        return this.reificationSupport;
                    }

                    public Internals.ReificationSupportApi reificationSupport() {
                        if ((byte)(this.bitmap$0 & 1) == 0) {
                            return this.reificationSupport$lzycompute();
                        }
                        return this.reificationSupport;
                    }

                    private Universe.TreeGen gen$lzycompute() {
                        synchronized (this) {
                            if ((byte)(this.bitmap$0 & 2) == 0) {
                                this.gen = Internals.SymbolTableInternal.gen$(this);
                                this.bitmap$0 = (byte)(this.bitmap$0 | 2);
                            }
                        }
                        return this.gen;
                    }

                    public Universe.TreeGen gen() {
                        if ((byte)(this.bitmap$0 & 2) == 0) {
                            return this.gen$lzycompute();
                        }
                        return this.gen;
                    }

                    private Universe.MacroInternalApi.MacroDecoratorApi decorators$lzycompute() {
                        synchronized (this) {
                            if ((byte)(this.bitmap$0 & 4) == 0) {
                                this.decorators = Internals.SymbolTableInternal.decorators$(this);
                                this.bitmap$0 = (byte)(this.bitmap$0 | 4);
                            }
                        }
                        return this.decorators;
                    }

                    public Universe.MacroInternalApi.MacroDecoratorApi decorators() {
                        if ((byte)(this.bitmap$0 & 4) == 0) {
                            return this.decorators$lzycompute();
                        }
                        return this.decorators;
                    }

                    public <T> Manifest<T> typeTagToManifest(Object mirror0, TypeTags.TypeTag<T> tag, ClassTag<T> evidence$1) {
                        JavaMirrors.JavaMirror mirror = (JavaMirrors.JavaMirror)mirror0;
                        Class<?> runtimeClass = mirror.runtimeClass((Types.Type)tag.in(mirror).tpe());
                        return package$.MODULE$.Manifest().classType(runtimeClass);
                    }

                    public <T> TypeTags.TypeTag<T> manifestToTypeTag(Object mirror0, Manifest<T> manifest) {
                        return this.$outer.TypeTag().apply((JavaMirrors.JavaMirror)mirror0, new TypeCreator(null, manifest){
                            private final Manifest manifest$1;

                            public <U extends scala.reflect.api.Universe> Types.TypeApi apply(Mirror<U> mirror) {
                                Types.TypeApi typeApi;
                                U u = mirror.universe();
                                if (u instanceof JavaUniverse) {
                                    Types.TypeApi typeApi2;
                                    JavaUniverse javaUniverse = (JavaUniverse)u;
                                    JavaMirrors.JavaMirror jm = (JavaMirrors.JavaMirror)mirror;
                                    Symbols.ClassSymbol sym = jm.classSymbol(this.manifest$1.runtimeClass());
                                    if (this.manifest$1.typeArguments().isEmpty()) {
                                        typeApi2 = sym.toType();
                                    } else {
                                        List<?> tags = this.manifest$1.typeArguments().map((Function1<Manifest, TypeTags.TypeTag> & java.io.Serializable & Serializable)targ -> javaUniverse.internal().manifestToTypeTag(jm, targ), List$.MODULE$.canBuildFrom());
                                        typeApi2 = javaUniverse.appliedType((Types.Type)sym.toTypeConstructor(), tags.map((Function1<TypeTags.TypeTag, Types.Type> & java.io.Serializable & Serializable)x$1 -> (Types.Type)x$1.in(jm).tpe(), List$.MODULE$.canBuildFrom()));
                                    }
                                    typeApi = typeApi2;
                                } else {
                                    typeApi = u.internal().manifestToTypeTag(mirror, this.manifest$1).in(mirror).tpe();
                                }
                                return typeApi;
                            }
                            {
                                this.manifest$1 = manifest$1;
                            }

                            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$apply$1(scala.reflect.runtime.JavaUniverse scala.reflect.runtime.JavaMirrors$JavaMirror scala.reflect.Manifest ), $anonfun$apply$2(scala.reflect.runtime.JavaMirrors$JavaMirror scala.reflect.api.TypeTags$TypeTag )}, serializedLambda);
                            }
                        });
                    }

                    public /* synthetic */ Internals scala$reflect$internal$Internals$SymbolTableInternal$$$outer() {
                        return this.$outer;
                    }

                    public /* synthetic */ Universe scala$reflect$macros$Universe$MacroInternalApi$$$outer() {
                        return this.$outer;
                    }

                    public /* synthetic */ scala.reflect.api.Internals scala$reflect$api$Internals$InternalApi$$$outer() {
                        return this.$outer;
                    }
                    {
                        if ($outer == null) {
                            throw null;
                        }
                        this.$outer = $outer;
                        Internals.InternalApi.$init$(this);
                        Universe.MacroInternalApi.$init$(this);
                        Internals.SymbolTableInternal.$init$(this);
                    }
                };
                this.bitmap$0 |= 2;
            }
        }
        return this.internal;
    }

    @Override
    public Universe.MacroInternalApi internal() {
        if ((this.bitmap$0 & 2) == 0) {
            return this.internal$lzycompute();
        }
        return this.internal;
    }

    public void init() {
        this.definitions().init();
        this.force();
    }

    private final void treeInfo$lzycompute$1() {
        synchronized (this) {
            if (this.treeInfo$module == null) {
                this.treeInfo$module = new JavaUniverse$treeInfo$(this);
            }
            return;
        }
    }

    public JavaUniverse() {
        JavaUniverseForce.$init$(this);
        ReflectSetup.$init$(this);
        scala.reflect.api.JavaUniverse.$init$(this);
        TwoWayCaches.$init$(this);
        JavaMirrors.$init$(this);
        SymbolLoaders.$init$(this);
        SynchronizedSymbols.$init$(this);
        SynchronizedTypes.$init$(this);
        SynchronizedOps.$init$(this);
        Gil.$init$(this);
        ThreadLocalStorage.$init$(this);
        SymbolTable.$init$(this);
        this.statistics = new SymbolTable.ReflectStats(this){
            private final Statistics.View scopeCountView;
            private final Statistics.Timer scopePopulationTime;
            private final Statistics.View symbolsCount;
            private final Statistics.Counter typeSymbolCount;
            private final Statistics.Counter classSymbolCount;
            private final Statistics.View treeNodeCount;
            private final Statistics.Counter retainedCount;
            private final Statistics.QuantMap<Class<?>, Statistics.Counter> retainedByType;
            private final Statistics.Timer classReadNanos;
            private final Statistics.View uniqueTypesView;
            private final Statistics.Counter rawTypeCount;
            private final Statistics.Counter subtypeCount;
            private final Statistics.Counter sametypeCount;
            private final Statistics.Counter lubCount;
            private final Statistics.Counter nestedLubCount;
            private final Statistics.Counter findMemberCount;
            private final Statistics.Counter findMembersCount;
            private final Statistics.SubCounter noMemberCount;
            private final Statistics.SubCounter multMemberCount;
            private final Statistics.Timer typerNanos;
            private final Statistics.StackableTimer lubNanos;
            private final Statistics.StackableTimer subtypeNanos;
            private final Statistics.StackableTimer findMemberNanos;
            private final Statistics.StackableTimer findMembersNanos;
            private final Statistics.StackableTimer asSeenFromNanos;
            private final Statistics.StackableTimer baseTypeSeqNanos;
            private final Statistics.StackableTimer baseClassesNanos;
            private final Statistics.SubCounter compoundBaseTypeSeqCount;
            private final Statistics.SubCounter typerefBaseTypeSeqCount;
            private final Statistics.SubCounter singletonBaseTypeSeqCount;
            private final Statistics.TimerStack typeOpsStack;
            private final Statistics.Counter baseTypeSeqCount;
            private final Statistics.Counter baseTypeSeqLenTotal;

            public Statistics.View scopeCountView() {
                return this.scopeCountView;
            }

            public Statistics.Timer scopePopulationTime() {
                return this.scopePopulationTime;
            }

            public void scala$reflect$internal$ScopeStats$_setter_$scopeCountView_$eq(Statistics.View x$1) {
                this.scopeCountView = x$1;
            }

            public void scala$reflect$internal$ScopeStats$_setter_$scopePopulationTime_$eq(Statistics.Timer x$1) {
                this.scopePopulationTime = x$1;
            }

            public Statistics.View symbolsCount() {
                return this.symbolsCount;
            }

            public Statistics.Counter typeSymbolCount() {
                return this.typeSymbolCount;
            }

            public Statistics.Counter classSymbolCount() {
                return this.classSymbolCount;
            }

            public void scala$reflect$internal$SymbolsStats$_setter_$symbolsCount_$eq(Statistics.View x$1) {
                this.symbolsCount = x$1;
            }

            public void scala$reflect$internal$SymbolsStats$_setter_$typeSymbolCount_$eq(Statistics.Counter x$1) {
                this.typeSymbolCount = x$1;
            }

            public void scala$reflect$internal$SymbolsStats$_setter_$classSymbolCount_$eq(Statistics.Counter x$1) {
                this.classSymbolCount = x$1;
            }

            public Statistics.View treeNodeCount() {
                return this.treeNodeCount;
            }

            public Statistics.Counter retainedCount() {
                return this.retainedCount;
            }

            public Statistics.QuantMap<Class<?>, Statistics.Counter> retainedByType() {
                return this.retainedByType;
            }

            public void scala$reflect$internal$TreesStats$_setter_$treeNodeCount_$eq(Statistics.View x$1) {
                this.treeNodeCount = x$1;
            }

            public void scala$reflect$internal$TreesStats$_setter_$retainedCount_$eq(Statistics.Counter x$1) {
                this.retainedCount = x$1;
            }

            public void scala$reflect$internal$TreesStats$_setter_$retainedByType_$eq(Statistics.QuantMap<Class<?>, Statistics.Counter> x$1) {
                this.retainedByType = x$1;
            }

            public Statistics.Timer classReadNanos() {
                return this.classReadNanos;
            }

            public void scala$reflect$internal$SymbolTableStats$_setter_$classReadNanos_$eq(Statistics.Timer x$1) {
                this.classReadNanos = x$1;
            }

            public Statistics.View uniqueTypesView() {
                return this.uniqueTypesView;
            }

            public Statistics.Counter rawTypeCount() {
                return this.rawTypeCount;
            }

            public Statistics.Counter subtypeCount() {
                return this.subtypeCount;
            }

            public Statistics.Counter sametypeCount() {
                return this.sametypeCount;
            }

            public Statistics.Counter lubCount() {
                return this.lubCount;
            }

            public Statistics.Counter nestedLubCount() {
                return this.nestedLubCount;
            }

            public Statistics.Counter findMemberCount() {
                return this.findMemberCount;
            }

            public Statistics.Counter findMembersCount() {
                return this.findMembersCount;
            }

            public Statistics.SubCounter noMemberCount() {
                return this.noMemberCount;
            }

            public Statistics.SubCounter multMemberCount() {
                return this.multMemberCount;
            }

            public Statistics.Timer typerNanos() {
                return this.typerNanos;
            }

            public Statistics.StackableTimer lubNanos() {
                return this.lubNanos;
            }

            public Statistics.StackableTimer subtypeNanos() {
                return this.subtypeNanos;
            }

            public Statistics.StackableTimer findMemberNanos() {
                return this.findMemberNanos;
            }

            public Statistics.StackableTimer findMembersNanos() {
                return this.findMembersNanos;
            }

            public Statistics.StackableTimer asSeenFromNanos() {
                return this.asSeenFromNanos;
            }

            public Statistics.StackableTimer baseTypeSeqNanos() {
                return this.baseTypeSeqNanos;
            }

            public Statistics.StackableTimer baseClassesNanos() {
                return this.baseClassesNanos;
            }

            public Statistics.SubCounter compoundBaseTypeSeqCount() {
                return this.compoundBaseTypeSeqCount;
            }

            public Statistics.SubCounter typerefBaseTypeSeqCount() {
                return this.typerefBaseTypeSeqCount;
            }

            public Statistics.SubCounter singletonBaseTypeSeqCount() {
                return this.singletonBaseTypeSeqCount;
            }

            public Statistics.TimerStack typeOpsStack() {
                return this.typeOpsStack;
            }

            public void scala$reflect$internal$TypesStats$_setter_$uniqueTypesView_$eq(Statistics.View x$1) {
                this.uniqueTypesView = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$rawTypeCount_$eq(Statistics.Counter x$1) {
                this.rawTypeCount = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$subtypeCount_$eq(Statistics.Counter x$1) {
                this.subtypeCount = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$sametypeCount_$eq(Statistics.Counter x$1) {
                this.sametypeCount = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$lubCount_$eq(Statistics.Counter x$1) {
                this.lubCount = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$nestedLubCount_$eq(Statistics.Counter x$1) {
                this.nestedLubCount = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$findMemberCount_$eq(Statistics.Counter x$1) {
                this.findMemberCount = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$findMembersCount_$eq(Statistics.Counter x$1) {
                this.findMembersCount = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$noMemberCount_$eq(Statistics.SubCounter x$1) {
                this.noMemberCount = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$multMemberCount_$eq(Statistics.SubCounter x$1) {
                this.multMemberCount = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$typerNanos_$eq(Statistics.Timer x$1) {
                this.typerNanos = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$lubNanos_$eq(Statistics.StackableTimer x$1) {
                this.lubNanos = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$subtypeNanos_$eq(Statistics.StackableTimer x$1) {
                this.subtypeNanos = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$findMemberNanos_$eq(Statistics.StackableTimer x$1) {
                this.findMemberNanos = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$findMembersNanos_$eq(Statistics.StackableTimer x$1) {
                this.findMembersNanos = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$asSeenFromNanos_$eq(Statistics.StackableTimer x$1) {
                this.asSeenFromNanos = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$baseTypeSeqNanos_$eq(Statistics.StackableTimer x$1) {
                this.baseTypeSeqNanos = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$baseClassesNanos_$eq(Statistics.StackableTimer x$1) {
                this.baseClassesNanos = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$compoundBaseTypeSeqCount_$eq(Statistics.SubCounter x$1) {
                this.compoundBaseTypeSeqCount = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$typerefBaseTypeSeqCount_$eq(Statistics.SubCounter x$1) {
                this.typerefBaseTypeSeqCount = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$singletonBaseTypeSeqCount_$eq(Statistics.SubCounter x$1) {
                this.singletonBaseTypeSeqCount = x$1;
            }

            public void scala$reflect$internal$TypesStats$_setter_$typeOpsStack_$eq(Statistics.TimerStack x$1) {
                this.typeOpsStack = x$1;
            }

            public Statistics.Counter baseTypeSeqCount() {
                return this.baseTypeSeqCount;
            }

            public Statistics.Counter baseTypeSeqLenTotal() {
                return this.baseTypeSeqLenTotal;
            }

            public void scala$reflect$internal$BaseTypeSeqsStats$_setter_$baseTypeSeqCount_$eq(Statistics.Counter x$1) {
                this.baseTypeSeqCount = x$1;
            }

            public void scala$reflect$internal$BaseTypeSeqsStats$_setter_$baseTypeSeqLenTotal_$eq(Statistics.Counter x$1) {
                this.baseTypeSeqLenTotal = x$1;
            }
            {
                BaseTypeSeqsStats.$init$(this);
                TypesStats.$init$(this);
                SymbolTableStats.$init$(this);
                TreesStats.$init$(this);
                SymbolsStats.$init$(this);
                ScopeStats.$init$(this);
            }
        };
        this.isLogging = scala.sys.package$.MODULE$.props().contains("scala.debug.reflect");
        this.TreeCopierTag = ClassTag$.MODULE$.apply(Trees.InternalTreeCopierOps.class);
        this.init();
    }

    public class PerRunReporting
    extends Reporting.PerRunReportingBase {
        @Override
        public void deprecationWarning(Position pos, String msg, String since, String site, String origin) {
            this.scala$reflect$runtime$JavaUniverse$PerRunReporting$$$outer().reporter().warning(pos, msg);
        }

        public /* synthetic */ JavaUniverse scala$reflect$runtime$JavaUniverse$PerRunReporting$$$outer() {
            return (JavaUniverse)this.$outer;
        }

        public PerRunReporting(JavaUniverse $outer) {
        }
    }
}

