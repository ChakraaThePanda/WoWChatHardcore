/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.runtime;

import java.lang.invoke.LambdaMetafactory;
import scala.Function0;
import scala.Function2;
import scala.MatchError;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.AbstractTraversable;
import scala.collection.Iterator;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.HashSet;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.Flags$;
import scala.reflect.internal.Names;
import scala.reflect.internal.Scopes;
import scala.reflect.internal.Scopes$EmptyScope$;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Types;
import scala.reflect.runtime.JavaMirrors;
import scala.reflect.runtime.SymbolTable;
import scala.reflect.runtime.SynchronizedOps;
import scala.runtime.Nothing$;
import scala.runtime.java8.JFunction0$mcV$sp;

@ScalaSignature(bytes="\u0006\u0001\u0005ufAC\u000e\u001d!\u0003\r\tA\b\u0012\u00028\")q\u0005\u0001C\u0001S\u0019!Q\u0006\u0001\u0001/\u0011!a$A!A!\u0002\u0013i\u0004\u0002\u0003\"\u0003\u0005\u0003\u0005\u000b\u0011B\"\t\u000b\u0019\u0013A\u0011A$\t\u000b-\u0013A\u0011\t'\t\u000bI\u0013A\u0011I*\t\u000bU\u0003A\u0011\u0003,\t\u000b-\u0004A\u0011\u00037\t\u000bQ\u0004A\u0011C;\u0007\te\u0004\u0001A\u001f\u0005\u0006\r.!\tA \u0005\u0007\u0017.!\t%!\u0001\u0007\r\u0005\u0015\u0001\u0001AA\u0004\u0011%\tiB\u0004B\u0001B\u0003%q\n\u0003\u0004G\u001d\u0011\u0005\u0011q\u0004\u0005\b\u0003KqA\u0011IA\u0014\u0011\u001d\tiD\u0004C!\u0003\u007fAq!!\u0013\u000f\t\u0003\nY\u0005C\u0005\u0002f9\u0011\r\u0011\"\u0003\u0002h!A\u0011q\u0010\b!\u0002\u0013\tI\u0007C\u0004\u0002\u0002:!\t%a!\t\u001d\u00055e\u0002%A\u0002\u0002\u0003%I!a$\u0002\u0014\"9\u0011Q\u0013\u0001\u0005B\u0005]\u0005bBAR\u0001\u0011\u0005\u0013Q\u0015\u0005\b\u0003S\u0003A\u0011IAV\u00055\u0019\u00160\u001c2pY2{\u0017\rZ3sg*\u0011QDH\u0001\beVtG/[7f\u0015\ty\u0002%A\u0004sK\u001adWm\u0019;\u000b\u0003\u0005\nQa]2bY\u0006\u001c\"\u0001A\u0012\u0011\u0005\u0011*S\"\u0001\u0011\n\u0005\u0019\u0002#AB!osJ+g-\u0001\u0004%S:LG\u000fJ\u0002\u0001)\u0005Q\u0003C\u0001\u0013,\u0013\ta\u0003E\u0001\u0003V]&$(!\u0005+pa\u000ec\u0017m]:D_6\u0004H.\u001a;feN\u0019!aL\u001c\u0011\u0005A\nT\"\u0001\u0001\n\u0005I\u001a$!C*z[2{\u0017\rZ3s\u0013\t!TGA\u0006Ts6\u0014w\u000e\u001c+bE2,'B\u0001\u001c\u001f\u0003!Ig\u000e^3s]\u0006d\u0007C\u0001\u00199\u0013\tI$H\u0001\fGY\u0006<\u0017i]:jO:LgnZ\"p[BdW\r^3s\u0013\tYTGA\u0003UsB,7/A\u0003dY\u0006T(\u0010\u0005\u00021}%\u0011q\b\u0011\u0002\f\u00072\f7o]*z[\n|G.\u0003\u0002Bk\t91+_7c_2\u001c\u0018AB7pIVdW\r\u0005\u00021\t&\u0011Q\t\u0011\u0002\r\u001b>$W\u000f\\3Ts6\u0014w\u000e\\\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0007!K%\n\u0005\u00021\u0005!)A(\u0002a\u0001{!)!)\u0002a\u0001\u0007\u0006A1m\\7qY\u0016$X\r\u0006\u0002+\u001b\")aJ\u0002a\u0001\u001f\u0006\u00191/_7\u0011\u0005A\u0002\u0016BA)A\u0005\u0019\u0019\u00160\u001c2pY\u0006!An\\1e)\tQC\u000bC\u0003O\u000f\u0001\u0007q*\u0001\u000ej]&$\u0018I\u001c3F]R,'o\u00117bgN\fe\u000eZ'pIVdW\r\u0006\u0003X5r\u001b\u0007\u0003\u0002\u0013Y{\rK!!\u0017\u0011\u0003\rQ+\b\u000f\\33\u0011\u0015Y\u0006\u00021\u0001P\u0003\u0015ywO\\3s\u0011\u0015i\u0006\u00021\u0001_\u0003\u0011q\u0017-\\3\u0011\u0005Az\u0016B\u00011b\u0005!!\u0016\u0010]3OC6,\u0017B\u000126\u0005\u0015q\u0015-\\3t\u0011\u0015!\u0007\u00021\u0001f\u0003%\u0019w.\u001c9mKR,'\u000fE\u0003%Mv\u001a\u0005.\u0003\u0002hA\tIa)\u001e8di&|gN\r\t\u0003a%L!A\u001b\u001e\u0003\u00111\u000b'0\u001f+za\u0016\f1b]3u\u00032d\u0017J\u001c4pgR!!&\u001c8p\u0011\u0015a\u0014\u00021\u0001P\u0011\u0015\u0011\u0015\u00021\u0001P\u0011\u0015\u0001\u0018\u00021\u0001r\u0003\u0011IgNZ8\u0011\u0005A\u0012\u0018BA:;\u0005\u0011!\u0016\u0010]3\u0002%%t\u0017\u000e^\"mCN\u001c\u0018I\u001c3N_\u0012,H.\u001a\u000b\u0005UY<\b\u0010C\u0003=\u0015\u0001\u0007q\nC\u0003C\u0015\u0001\u0007q\nC\u0003e\u0015\u0001\u0007\u0001NA\bMCjL\b+Y2lC\u001e,G+\u001f9f'\rY\u0001n\u001f\t\u0003aqL!! \u001e\u0003+\u0019c\u0017mZ!h]>\u001cH/[2D_6\u0004H.\u001a;feR\tq\u0010\u0005\u00021\u0017Q\u0019!&a\u0001\t\u000b9k\u0001\u0019A(\u0003\u0019A\u000b7m[1hKN\u001bw\u000e]3\u0014\u000b9\tI!a\u0005\u0011\u0007A\nY!\u0003\u0003\u0002\u000e\u0005=!!B*d_B,\u0017bAA\tk\t11kY8qKN\u00042\u0001MA\u000b\u0013\u0011\t9\"!\u0007\u0003#MKhn\u00195s_:L'0\u001a3TG>\u0004X-C\u0002\u0002\u001cq\u0011qbU=oG\"\u0014xN\\5{K\u0012|\u0005o]\u0001\ta.<7\t\\1tgR!\u0011\u0011EA\u0012!\t\u0001d\u0002\u0003\u0004\u0002\u001eA\u0001\raT\u0001\u0006K:$XM]\u000b\u0005\u0003S\ty\u0003\u0006\u0003\u0002,\u0005m\u0002\u0003BA\u0017\u0003_a\u0001\u0001B\u0004\u00022E\u0011\r!a\r\u0003\u0003Q\u000b2!!\u000eP!\r!\u0013qG\u0005\u0004\u0003s\u0001#a\u0002(pi\"Lgn\u001a\u0005\u0007\u001dF\u0001\r!a\u000b\u0002\u0015\u0015tG/\u001a:JM:+w/\u0006\u0003\u0002B\u0005\u0015C\u0003BA\"\u0003\u000f\u0002B!!\f\u0002F\u00119\u0011\u0011\u0007\nC\u0002\u0005M\u0002B\u0002(\u0013\u0001\u0004\t\u0019%\u0001\u000bts:\u001cGj\\2l'ft7\r\u001b:p]&TX\rZ\u000b\u0005\u0003\u001b\n\t\u0006\u0006\u0003\u0002P\u0005m\u0003\u0003BA\u0017\u0003#\"q!!\r\u0014\u0005\u0004\t\u0019&\u0005\u0003\u00026\u0005U\u0003c\u0001\u0013\u0002X%\u0019\u0011\u0011\f\u0011\u0003\u0007\u0005s\u0017\u0010\u0003\u0005\u0002^M!\t\u0019AA0\u0003\u0011\u0011w\u000eZ=\u0011\u000b\u0011\n\t'a\u0014\n\u0007\u0005\r\u0004E\u0001\u0005=Eft\u0017-\\3?\u0003%qWmZ1uSZ,7/\u0006\u0002\u0002jA1\u00111NA;\u0003sj!!!\u001c\u000b\t\u0005=\u0014\u0011O\u0001\b[V$\u0018M\u00197f\u0015\r\t\u0019\bI\u0001\u000bG>dG.Z2uS>t\u0017\u0002BA<\u0003[\u0012q\u0001S1tQN+G\u000fE\u00021\u0003wJ1!! b\u0005\u0011q\u0015-\\3\u0002\u00159,w-\u0019;jm\u0016\u001c\b%A\u0006m_>\\W\u000f]#oiJLH\u0003BAC\u0003\u0017\u00032\u0001MAD\u0013\u0011\tI)a\u0004\u0003\u0015M\u001bw\u000e]3F]R\u0014\u0018\u0010\u0003\u0004^-\u0001\u0007\u0011\u0011P\u0001\u0012gV\u0004XM\u001d\u0013m_>\\W\u000f]#oiJLH\u0003BAC\u0003#Ca!X\fA\u0002\u0005e\u0014\u0002BAA\u0003+\t\u0011C^1mS\u0012\fG/Z\"mCN\u001c\u0018J\u001c4p)\rQ\u0013\u0011\u0014\u0005\b\u00037C\u0002\u0019AAO\u0003\t!\b\u000fE\u00021\u0003?K1!!);\u00055\u0019E.Y:t\u0013:4w\u000eV=qK\u0006ya.Z<QC\u000e\\\u0017mZ3TG>\u0004X\r\u0006\u0003\u0002\"\u0005\u001d\u0006BBA\u000f3\u0001\u0007q*\u0001\btG>\u0004X\r\u0016:b]N4wN]7\u0015\t\u00055\u0016Q\u0017\u000b\u0005\u0003\u0013\ty\u000b\u0003\u0005\u00022j!\t\u0019AAZ\u0003\ty\u0007\u000fE\u0003%\u0003C\nI\u0001C\u0003\\5\u0001\u0007q\n\u0005\u0003\u0002:\u0006mV\"\u0001\u000f\n\u0005Qb\u0002")
public interface SymbolLoaders {
    public static /* synthetic */ Tuple2 initAndEnterClassAndModule$(SymbolLoaders $this, Symbols.Symbol owner, Names.TypeName name, Function2 completer) {
        return $this.initAndEnterClassAndModule(owner, name, completer);
    }

    /*
     * WARNING - void declaration
     */
    default public Tuple2<Symbols.ClassSymbol, Symbols.ModuleSymbol> initAndEnterClassAndModule(Symbols.Symbol owner, Names.TypeName name, Function2<Symbols.ClassSymbol, Symbols.ModuleSymbol, Types.LazyType> completer) {
        void assert_assertion;
        boolean bl = !name.toString().endsWith("[]");
        scala.reflect.internal.SymbolTable assert_this = (scala.reflect.internal.SymbolTable)((Object)this);
        if (assert_assertion == false) {
            throw assert_this.throwAssertionError(name);
        }
        Symbols.ClassSymbol clazz = owner.newClass(name, owner.newClass$default$2(), owner.newClass$default$3());
        Symbols.ModuleSymbol module = owner.newModule(name.toTermName(), owner.newModule$default$2(), owner.newModule$default$3());
        Scopes.Scope scope = owner.info().decls();
        Scopes$EmptyScope$ scopes$EmptyScope$ = ((Scopes)((Object)this)).EmptyScope();
        if (scope == null ? scopes$EmptyScope$ != null : !scope.equals(scopes$EmptyScope$)) {
            owner.info().decls().enter(clazz);
            owner.info().decls().enter(module);
        }
        this.initClassAndModule(clazz, module, completer.apply(clazz, module));
        return new Tuple2<Symbols.ClassSymbol, Symbols.ModuleSymbol>(clazz, module);
    }

    public static /* synthetic */ void setAllInfos$(SymbolLoaders $this, Symbols.Symbol clazz, Symbols.Symbol module, Types.Type info) {
        $this.setAllInfos(clazz, module, info);
    }

    default public void setAllInfos(Symbols.Symbol clazz, Symbols.Symbol module, Types.Type info) {
        List foreach_these = new $colon$colon<Nothing$>((Nothing$)((Object)clazz), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)module), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)module.moduleClass()), Nil$.MODULE$)));
        while (!((List)foreach_these).isEmpty()) {
            Symbols.Symbol symbol = (Symbols.Symbol)((List)foreach_these).head();
            symbol.setInfo(info);
            foreach_these = (List)((AbstractTraversable)foreach_these).tail();
        }
    }

    public static /* synthetic */ void initClassAndModule$(SymbolLoaders $this, Symbols.Symbol clazz, Symbols.Symbol module, Types.LazyType completer) {
        $this.initClassAndModule(clazz, module, completer);
    }

    default public void initClassAndModule(Symbols.Symbol clazz, Symbols.Symbol module, Types.LazyType completer) {
        this.setAllInfos(clazz, module, completer);
    }

    public static /* synthetic */ void validateClassInfo$(SymbolLoaders $this, Types.ClassInfoType tp) {
        $this.validateClassInfo(tp);
    }

    default public void validateClassInfo(Types.ClassInfoType tp) {
        ((scala.reflect.internal.SymbolTable)((Object)this)).assert(!tp.typeSymbol().isPackageClass() || tp.decls() instanceof PackageScope);
    }

    public static /* synthetic */ PackageScope newPackageScope$(SymbolLoaders $this, Symbols.Symbol pkgClass) {
        return $this.newPackageScope(pkgClass);
    }

    default public PackageScope newPackageScope(Symbols.Symbol pkgClass) {
        return new PackageScope((SymbolTable)this, pkgClass);
    }

    public static /* synthetic */ Scopes.Scope scopeTransform$(SymbolLoaders $this, Symbols.Symbol owner, Function0 op) {
        return $this.scopeTransform(owner, op);
    }

    default public Scopes.Scope scopeTransform(Symbols.Symbol owner, Function0<Scopes.Scope> op) {
        if (owner.isPackageClass()) {
            return owner.info().decls();
        }
        return op.apply();
    }

    public static void $init$(SymbolLoaders $this) {
    }

    public static class LazyPackageType
    extends Types.LazyType
    implements Types.FlagAgnosticCompleter {
        public final /* synthetic */ SymbolTable $outer;

        @Override
        public void complete(Symbols.Symbol sym) {
            ((scala.reflect.internal.SymbolTable)((Object)this.scala$reflect$runtime$SymbolLoaders$LazyPackageType$$$outer())).assert(sym.isPackageClass());
            ((scala.reflect.internal.SymbolTable)((Object)this.scala$reflect$runtime$SymbolLoaders$LazyPackageType$$$outer())).slowButSafeEnteringPhaseNotLaterThan(((scala.reflect.internal.SymbolTable)((Object)this.scala$reflect$runtime$SymbolLoaders$LazyPackageType$$$outer())).picklerPhase(), (JFunction0$mcV$sp & Serializable)() -> {
                sym.setInfo(new Types.ClassInfoType((scala.reflect.internal.SymbolTable)((Object)this.scala$reflect$runtime$SymbolLoaders$LazyPackageType$$$outer()), Nil$.MODULE$, new PackageScope(this.scala$reflect$runtime$SymbolLoaders$LazyPackageType$$$outer(), sym), sym));
                ((scala.reflect.internal.SymbolTable)((Object)this.scala$reflect$runtime$SymbolLoaders$LazyPackageType$$$outer())).openPackageModule(sym);
                this.scala$reflect$runtime$SymbolLoaders$LazyPackageType$$$outer().markAllCompleted(Predef$.MODULE$.wrapRefArray((Object[])new Symbols.Symbol[]{sym}));
            });
        }

        public /* synthetic */ SymbolTable scala$reflect$runtime$SymbolLoaders$LazyPackageType$$$outer() {
            return this.$outer;
        }

        public LazyPackageType(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            super((scala.reflect.internal.SymbolTable)((Object)$outer));
        }
    }

    public class PackageScope
    extends Scopes.Scope
    implements SynchronizedOps.SynchronizedScope {
        private final Symbols.Symbol pkgClass;
        private final HashSet<Names.Name> negatives;
        private Object scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$syncLock;
        private volatile boolean bitmap$0;
        public final /* synthetic */ SymbolTable $outer;

        @Override
        public /* synthetic */ boolean scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$isEmpty() {
            return super.isEmpty();
        }

        @Override
        public /* synthetic */ int scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$size() {
            return super.size();
        }

        @Override
        public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$enter(Symbols.Symbol sym) {
            return super.enter(sym);
        }

        @Override
        public /* synthetic */ void scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$rehash(Symbols.Symbol sym, Names.Name newname) {
            super.rehash(sym, newname);
        }

        @Override
        public /* synthetic */ void scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$unlink(Scopes.ScopeEntry e) {
            super.unlink(e);
        }

        @Override
        public /* synthetic */ void scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$unlink(Symbols.Symbol sym) {
            super.unlink(sym);
        }

        @Override
        public /* synthetic */ Iterator scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$lookupAll(Names.Name name) {
            return super.lookupAll(name);
        }

        @Override
        public /* synthetic */ Scopes.ScopeEntry scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$lookupEntry(Names.Name name) {
            return super.lookupEntry(name);
        }

        @Override
        public /* synthetic */ Scopes.ScopeEntry scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$lookupNextEntry(Scopes.ScopeEntry entry) {
            return super.lookupNextEntry(entry);
        }

        @Override
        public /* synthetic */ List scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$toList() {
            return super.toList();
        }

        @Override
        public boolean isEmpty() {
            return SynchronizedOps.SynchronizedScope.isEmpty$(this);
        }

        @Override
        public int size() {
            return SynchronizedOps.SynchronizedScope.size$(this);
        }

        @Override
        public void rehash(Symbols.Symbol sym, Names.Name newname) {
            SynchronizedOps.SynchronizedScope.rehash$(this, sym, newname);
        }

        @Override
        public void unlink(Scopes.ScopeEntry e) {
            SynchronizedOps.SynchronizedScope.unlink$((SynchronizedOps.SynchronizedScope)this, e);
        }

        @Override
        public void unlink(Symbols.Symbol sym) {
            SynchronizedOps.SynchronizedScope.unlink$((SynchronizedOps.SynchronizedScope)this, sym);
        }

        @Override
        public Iterator<Symbols.Symbol> lookupAll(Names.Name name) {
            return SynchronizedOps.SynchronizedScope.lookupAll$(this, name);
        }

        @Override
        public Scopes.ScopeEntry lookupNextEntry(Scopes.ScopeEntry entry) {
            return SynchronizedOps.SynchronizedScope.lookupNextEntry$(this, entry);
        }

        @Override
        public List<Symbols.Symbol> toList() {
            return SynchronizedOps.SynchronizedScope.toList$(this);
        }

        private Object scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$syncLock$lzycompute() {
            synchronized (this) {
                if (!this.bitmap$0) {
                    this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$syncLock = SynchronizedOps.SynchronizedScope.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$syncLock$(this);
                    this.bitmap$0 = true;
                }
            }
            return this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$syncLock;
        }

        @Override
        public Object scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$syncLock() {
            if (!this.bitmap$0) {
                return this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$syncLock$lzycompute();
            }
            return this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$syncLock;
        }

        private /* synthetic */ Scopes.ScopeEntry super$lookupEntry(Names.Name name) {
            return SynchronizedOps.SynchronizedScope.lookupEntry$(this, name);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public <T extends Symbols.Symbol> T enter(T sym) {
            void assert_assertion;
            boolean bl;
            if (this.scala$reflect$runtime$SymbolLoaders$PackageScope$$$outer().isCompilerUniverse()) {
                return (T)SynchronizedOps.SynchronizedScope.enter$(this, sym);
            }
            Scopes.ScopeEntry existing = SynchronizedOps.SynchronizedScope.lookupEntry$(this, sym.name());
            scala.reflect.internal.SymbolTable symbolTable = (scala.reflect.internal.SymbolTable)((Object)this.scala$reflect$runtime$SymbolLoaders$PackageScope$$$outer());
            boolean bl2 = bl = existing == null || PackageScope.eitherIsMethod$1(existing.sym(), sym);
            if (symbolTable == null) {
                throw null;
            }
            scala.reflect.internal.SymbolTable assert_this = symbolTable;
            if (assert_assertion == false) {
                throw assert_this.throwAssertionError(PackageScope.$anonfun$enter$1(this, sym, existing));
            }
            return (T)SynchronizedOps.SynchronizedScope.enter$(this, sym);
        }

        @Override
        public <T extends Symbols.Symbol> T enterIfNew(T sym) {
            Scopes.ScopeEntry existing = SynchronizedOps.SynchronizedScope.lookupEntry$(this, sym.name());
            if (existing == null) {
                return this.enter(sym);
            }
            return (T)existing.sym();
        }

        @Override
        public <T> T syncLockSynchronized(Function0<T> body) {
            T t;
            SymbolTable symbolTable = this.scala$reflect$runtime$SymbolLoaders$PackageScope$$$outer();
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable gilSynchronized_this = symbolTable;
            if (gilSynchronized_this.isCompilerUniverse()) {
                return body.apply();
            }
            try {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                t = body.apply();
            }
            finally {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return t;
        }

        private HashSet<Names.Name> negatives() {
            return this.negatives;
        }

        @Override
        public Scopes.ScopeEntry lookupEntry(Names.Name name) {
            return (Scopes.ScopeEntry)this.syncLockSynchronized((Function0<Scopes.ScopeEntry> & java.io.Serializable & Serializable)() -> {
                Scopes.ScopeEntry scopeEntry;
                Scopes.ScopeEntry e = this.super$lookupEntry(name);
                if (e != null) {
                    return e;
                }
                if (this.negatives().contains(name)) {
                    return null;
                }
                String path = $this.pkgClass.isEmptyPackageClass() ? name.toString() : new StringBuilder(1).append($this.pkgClass.fullName()).append(".").append(name).toString();
                JavaMirrors.JavaMirror currentMirror = this.scala$reflect$runtime$SymbolLoaders$PackageScope$$$outer().mirrorThatLoaded($this.pkgClass);
                Option<Class<?>> option = currentMirror.tryJavaClass(path);
                if (option instanceof Some) {
                    void var15_14;
                    Tuple2<Symbols.Symbol, Symbols.Symbol> tuple2;
                    Tuple2<Symbols.Symbol, Symbols.Symbol> tuple22;
                    Class cls = (Class)((Some)option).value();
                    JavaMirrors.JavaMirror loadingMirror = currentMirror.mirrorDefining(cls);
                    if (loadingMirror == currentMirror) {
                        tuple22 = this.scala$reflect$runtime$SymbolLoaders$PackageScope$$$outer().initAndEnterClassAndModule($this.pkgClass, name.toTypeName(), (Function2<Symbols.ClassSymbol, Symbols.ModuleSymbol, Types.LazyType>)(Function2<Symbols.ClassSymbol, Symbols.ModuleSymbol, TopClassCompleter> & java.io.Serializable & Serializable)(x$2, x$3) -> new TopClassCompleter(this.scala$reflect$runtime$SymbolLoaders$PackageScope$$$outer(), (Symbols.ClassSymbol)x$2, (Symbols.ModuleSymbol)x$3));
                    } else {
                        Symbols.ModuleSymbol origOwner = loadingMirror.packageNameToScala($this.pkgClass.fullName());
                        Symbols.Symbol clazz = origOwner.info().decl(name.toTypeName());
                        Symbols.Symbol module = origOwner.info().decl(name.toTermName());
                        Symbols.Symbol symbol = clazz;
                        Symbols.NoSymbol noSymbol = this.scala$reflect$runtime$SymbolLoaders$PackageScope$$$outer().NoSymbol();
                        ((scala.reflect.internal.SymbolTable)((Object)this.scala$reflect$runtime$SymbolLoaders$PackageScope$$$outer())).assert(symbol == null ? noSymbol != null : !symbol.equals(noSymbol));
                        Symbols.Symbol symbol2 = module;
                        Symbols.NoSymbol noSymbol2 = this.scala$reflect$runtime$SymbolLoaders$PackageScope$$$outer().NoSymbol();
                        ((scala.reflect.internal.SymbolTable)((Object)this.scala$reflect$runtime$SymbolLoaders$PackageScope$$$outer())).assert(symbol2 == null ? noSymbol2 != null : !symbol2.equals(noSymbol2));
                        this.enterIfNew(clazz);
                        this.enterIfNew(module);
                        tuple22 = tuple2 = new Tuple2<Symbols.Symbol, Symbols.Symbol>(clazz, module);
                    }
                    if (tuple2 == null) {
                        throw new MatchError((Object)null);
                    }
                    Symbols.Symbol module = tuple2._2();
                    this.scala$reflect$runtime$SymbolLoaders$PackageScope$$$outer().debugInfo(() -> PackageScope.$anonfun$lookupEntry$3(this, (Symbols.Symbol)var15_14));
                    scopeEntry = this.lookupEntry(name);
                } else {
                    this.scala$reflect$runtime$SymbolLoaders$PackageScope$$$outer().debugInfo((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(16).append("*** not found : ").append(path).toString());
                    this.negatives().$plus$eq((Object)name);
                    scopeEntry = null;
                }
                return scopeEntry;
            });
        }

        public /* synthetic */ SymbolTable scala$reflect$runtime$SymbolLoaders$PackageScope$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ SynchronizedOps scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$$outer() {
            return this.scala$reflect$runtime$SymbolLoaders$PackageScope$$$outer();
        }

        private static final boolean eitherIsMethod$1(Symbols.Symbol sym1, Symbols.Symbol sym2) {
            return sym1.isMethod() || sym2.isMethod();
        }

        public static final /* synthetic */ String $anonfun$enter$1(PackageScope $this, Symbols.Symbol sym$3, Scopes.ScopeEntry existing$1) {
            return new StringBuilder(32).append("pkgClass = ").append($this.pkgClass).append(", sym = ").append(sym$3).append(", existing = ").append(existing$1).toString();
        }

        public static final /* synthetic */ String $anonfun$lookupEntry$3(PackageScope $this, Symbols.Symbol module$1) {
            return new StringBuilder(13).append("created ").append(module$1).append("/").append(module$1.moduleClass()).append(" in ").append($this.pkgClass).toString();
        }

        public PackageScope(SymbolTable $outer, Symbols.Symbol pkgClass) {
            this.pkgClass = pkgClass;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            super((scala.reflect.internal.SymbolTable)((Object)$outer));
            SynchronizedOps.SynchronizedScope.$init$(this);
            ((scala.reflect.internal.SymbolTable)((Object)$outer)).assert(pkgClass.isType());
            this.negatives = new HashSet();
        }
    }

    public class TopClassCompleter
    extends SymbolTable.SymLoader
    implements Types.FlagAssigningCompleter {
        private final Symbols.ClassSymbol clazz;
        private final Symbols.ModuleSymbol module;
        public final /* synthetic */ SymbolTable $outer;

        /*
         * Unable to fully structure code
         */
        @Override
        public void complete(Symbols.Symbol sym) {
            this.scala$reflect$runtime$SymbolLoaders$TopClassCompleter$$$outer().debugInfo((Function0<String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()Ljava/lang/Object;, $anonfun$complete$1(scala.reflect.runtime.SymbolLoaders$TopClassCompleter scala.reflect.internal.Symbols$Symbol ), ()Ljava/lang/String;)((TopClassCompleter)this, (Symbols.Symbol)sym));
            v0 = (scala.reflect.internal.SymbolTable)this.scala$reflect$runtime$SymbolLoaders$TopClassCompleter$$$outer();
            v1 = sym;
            var2_2 = this.clazz;
            if (!(v1 == null ? var2_2 != null : v1.equals(var2_2) == false)) ** GOTO lbl-1000
            v2 = sym;
            var3_3 = this.module;
            if (!(v2 == null ? var3_3 != null : v2.equals(var3_3) == false)) ** GOTO lbl-1000
            v3 = sym;
            var4_4 = this.module.moduleClass();
            if (!(v3 != null ? v3.equals(var4_4) == false : var4_4 != null)) lbl-1000:
            // 3 sources

            {
                v4 = true;
            } else {
                v4 = false;
            }
            v0.assert(v4);
            ((scala.reflect.internal.SymbolTable)this.scala$reflect$runtime$SymbolLoaders$TopClassCompleter$$$outer()).slowButSafeEnteringPhaseNotLaterThan(((scala.reflect.internal.SymbolTable)this.scala$reflect$runtime$SymbolLoaders$TopClassCompleter$$$outer()).picklerPhase(), (JFunction0$mcV$sp & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()V, $anonfun$complete$2(scala.reflect.runtime.SymbolLoaders$TopClassCompleter scala.reflect.internal.Symbols$Symbol ), ()V)((TopClassCompleter)this, (Symbols.Symbol)sym));
        }

        @Override
        public void load(Symbols.Symbol sym) {
            this.complete(sym);
        }

        public /* synthetic */ SymbolTable scala$reflect$runtime$SymbolLoaders$TopClassCompleter$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ String $anonfun$complete$1(TopClassCompleter $this, Symbols.Symbol sym$1) {
            return new StringBuilder(12).append("completing ").append(sym$1).append("/").append($this.clazz.fullName()).toString();
        }

        public static final /* synthetic */ void $anonfun$complete$2(TopClassCompleter $this, Symbols.Symbol sym$1) {
            JavaMirrors.JavaMirror loadingMirror = $this.scala$reflect$runtime$SymbolLoaders$TopClassCompleter$$$outer().mirrorThatLoaded(sym$1);
            Class<?> javaClass = loadingMirror.javaClass($this.clazz.javaClassName());
            loadingMirror.unpickleClass($this.clazz, $this.module, javaClass);
        }

        public TopClassCompleter(SymbolTable $outer, Symbols.ClassSymbol clazz, Symbols.ModuleSymbol module) {
            this.clazz = clazz;
            this.module = module;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            super((scala.reflect.internal.SymbolTable)((Object)$outer));
            $outer.markFlagsCompleted(Predef$.MODULE$.wrapRefArray((Object[])new Symbols.Symbol[]{clazz, module}), Flags$.MODULE$.TopLevelPickledFlags() ^ 0xFFFFFFFFFFFFFFFFL);
        }
    }
}

