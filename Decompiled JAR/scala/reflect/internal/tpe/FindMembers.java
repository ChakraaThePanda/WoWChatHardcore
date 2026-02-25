/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.tpe;

import scala.Function0;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.LinearSeqOptimized;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.Names;
import scala.reflect.internal.Scopes;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Types;
import scala.reflect.internal.TypesStats;
import scala.reflect.internal.util.ReusableInstance;
import scala.reflect.internal.util.Statistics;
import scala.reflect.internal.util.StatisticsStatics;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\t\u0005d!\u0003$H!\u0003\r\t\u0001\u0015B-\u0011\u0015)\u0006\u0001\"\u0001W\r\u0019Q\u0006!!\u0001J7\")QL\u0001C\u0001=\"I\u0001J\u0001a\u0001\u0002\u0004%\t\u0002\u001c\u0005\ne\n\u0001\r\u00111A\u0005\u0012MD\u0011B\u001e\u0002A\u0002\u0003\u0005\u000b\u0015B7\t\u0013]\u0014\u0001\u0019!a\u0001\n#A\b\"\u0003@\u0003\u0001\u0004\u0005\r\u0011\"\u0005\u0000\u0011)\t\u0019A\u0001a\u0001\u0002\u0003\u0006K!\u001f\u0005\n\u0003\u000b\u0011\u0001\u0019!C\t\u0003\u000fA\u0011\"a\u0004\u0003\u0001\u0004%\t\"!\u0005\t\u0011\u0005U!\u0001)Q\u0005\u0003\u0013A\u0011\"a\u0006\u0003\u0001\u0004%\t\"a\u0002\t\u0013\u0005e!\u00011A\u0005\u0012\u0005m\u0001\u0002CA\u0010\u0005\u0001\u0006K!!\u0003\t\u0017\u0005\u0005\"\u00011AA\u0002\u0013E\u00111\u0005\u0005\f\u0003\u000f\u0012\u0001\u0019!a\u0001\n#\tI\u0005C\u0006\u0002N\t\u0001\r\u0011!Q!\n\u0005\u0015\u0002bBA(\u0005\u0011E\u0011\u0011\u000b\u0005\b\u00037\u0012\u0001\u0015)\u0003n\u0011\u0019\tiF\u0001C\tY\"9\u0011q\f\u0002\u0005\u0002\u0005\u0005\u0004bBA2\u0005\u0019E\u0011Q\r\u0005\b\u0003O\u0012A\u0011BA3\u0011\u001d\tIG\u0001C\u0005\u0003WBq!a \u0003\r#\t\t\tC\u0004\u0002\b\n1\t\"!#\t\u000f\u00055%\u0001\"\u0003\u0002\u0010\"9\u0011Q\u0015\u0002\u0005\u0012\u0005\u001d\u0006bBAY\u0005\u0001\u0006K!\u001c\u0005\t\u0003g\u0013\u0001\u0015)\u0003\u0002>!9\u0011Q\u0017\u0002\u0005\u0012\u0005]\u0006bBA^\u0005\u0011E\u0011Q\u0018\u0005\b\u0003\u0003\u0014A\u0011BAb\r\u00191\u0005AA&\u0002J\"A\u0001j\tB\u0001B\u0003%Q\u000e\u0003\u0006\u0002\u0006\r\u0012\t\u0011)A\u0005\u0003\u0013A!\"a\u0006$\u0005\u0003\u0005\u000b\u0011BA\u0005\u0011\u0019i6\u0005\"\u0001\u0002X\"A\u0011\u0011]\u0012!B\u0013\ti\rC\u0004\u0002d\u000e\"I!!:\t\u000f\u0005}4\u0005\"\u0005\u0002h\"9\u00111M\u0012\u0005\u0012\u0005\u0015\bbBADG\u0011E\u00111\u001e\u0005\u000b\u0003_\u0004!\u0019!C\u0001\u0017\u0006Eha\u0002B\u0001\u0001\tY%1\u0001\u0005\u0007;:\"\tAa\u0002\t\u0011\t%a\u0006)Q\u0005\u0003[B1Ba\u0003/\u0001\u0004\u0005\t\u0015)\u0003\u0002>!Y!Q\u0002\u0018A\u0002\u0003\u0005\u000b\u0015BA\u0013\u0011-\u0011yA\fa\u0001\u0002\u0003\u0006KA!\u0005\t\u000f\u0005=c\u0006\"\u0001\u0003\u0018!9!1\u0005\u0018\u0005\n\t\u0015\u0002bBA@]\u0011E!\u0011\u0006\u0005\b\u0003\u000fsC\u0011\u0003B\u0017\u0011\u001d\u0011\tD\fQ!\n5DqAa\r/A\u0013%A\u000eC\u0004\u0002<:\"\tF!\u000e\t\u000f\u0005\rd\u0006\"\u0005\u0003:\u00199!1\b\u0001\u0003\u001b\nu\u0002\u0002\u0003%=\u0005\u0003\u0005\u000b\u0011B7\t\u0011]d$\u0011!Q\u0001\neD!\"!\u0002=\u0005\u0003\u0005\u000b\u0011BA\u0005\u0011)\t9\u0002\u0010B\u0001B\u0003%\u0011\u0011\u0002\u0005\u0007;r\"\tA!\u0011\t\u0011\t5C\b)Q\u0005\u0003[Bq!a\u0019=\t#\u0012y\u0005C\u0004\u0002\u0000q\"\tB!\u0015\t\u000f\u0005\u001dE\b\"\u0005\u0003V\tYa)\u001b8e\u001b\u0016l'-\u001a:t\u0015\tA\u0015*A\u0002ua\u0016T!AS&\u0002\u0011%tG/\u001a:oC2T!\u0001T'\u0002\u000fI,g\r\\3di*\ta*A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0005\u0001\t\u0006C\u0001*T\u001b\u0005i\u0015B\u0001+N\u0005\u0019\te.\u001f*fM\u00061A%\u001b8ji\u0012\"\u0012a\u0016\t\u0003%bK!!W'\u0003\tUs\u0017\u000e\u001e\u0002\u000f\r&tG-T3nE\u0016\u0014()Y:f+\ta6m\u0005\u0002\u0003#\u00061A(\u001b8jiz\"\u0012a\u0018\t\u0004A\n\tW\"\u0001\u0001\u0011\u0005\t\u001cG\u0002\u0001\u0003\u0006I\n\u0011\r!\u001a\u0002\u0002)F\u0011a-\u001b\t\u0003%\u001eL!\u0001['\u0003\u000f9{G\u000f[5oOB\u0011!K[\u0005\u0003W6\u00131!\u00118z+\u0005i\u0007C\u00011o\u0013\ty\u0007O\u0001\u0003UsB,\u0017BA9J\u0005\u0015!\u0016\u0010]3t\u0003\u001d!\b/Z0%KF$\"a\u0016;\t\u000fU,\u0011\u0011!a\u0001[\u0006\u0019\u0001\u0010J\u0019\u0002\tQ\u0004X\rI\u0001\u0005]\u0006lW-F\u0001z!\t\u0001'0\u0003\u0002|y\n!a*Y7f\u0013\ti\u0018JA\u0003OC6,7/\u0001\u0005oC6,w\fJ3r)\r9\u0016\u0011\u0001\u0005\bk\"\t\t\u00111\u0001z\u0003\u0015q\u0017-\\3!\u00035)\u0007p\u00197vI\u0016$g\t\\1hgV\u0011\u0011\u0011\u0002\t\u0004%\u0006-\u0011bAA\u0007\u001b\n!Aj\u001c8h\u0003E)\u0007p\u00197vI\u0016$g\t\\1hg~#S-\u001d\u000b\u0004/\u0006M\u0001\u0002C;\f\u0003\u0003\u0005\r!!\u0003\u0002\u001d\u0015D8\r\\;eK\u00124E.Y4tA\u0005i!/Z9vSJ,GM\u00127bON\f\u0011C]3rk&\u0014X\r\u001a$mC\u001e\u001cx\fJ3r)\r9\u0016Q\u0004\u0005\tk:\t\t\u00111\u0001\u0002\n\u0005q!/Z9vSJ,GM\u00127bON\u0004\u0013aD5oSR\u0014\u0015m]3DY\u0006\u001c8/Z:\u0016\u0005\u0005\u0015\u0002CBA\u0014\u0003o\tiD\u0004\u0003\u0002*\u0005Mb\u0002BA\u0016\u0003ci!!!\f\u000b\u0007\u0005=r*\u0001\u0004=e>|GOP\u0005\u0002\u001d&\u0019\u0011QG'\u0002\u000fA\f7m[1hK&!\u0011\u0011HA\u001e\u0005\u0011a\u0015n\u001d;\u000b\u0007\u0005UR\nE\u0002a\u0003\u007fIA!!\u0011\u0002D\t11+_7c_2L1!!\u0012J\u0005\u001d\u0019\u00160\u001c2pYN\f1#\u001b8ji\n\u000b7/Z\"mCN\u001cXm]0%KF$2aVA&\u0011!)\u0018#!AA\u0002\u0005\u0015\u0012\u0001E5oSR\u0014\u0015m]3DY\u0006\u001c8/Z:!\u0003\u0011Ig.\u001b;\u0015\u0013]\u000b\u0019&!\u0016\u0002X\u0005e\u0003\"\u0002%\u0014\u0001\u0004i\u0007\"B<\u0014\u0001\u0004I\bbBA\u0003'\u0001\u0007\u0011\u0011\u0002\u0005\b\u0003/\u0019\u0002\u0019AA\u0005\u0003\u0015y6/\u001a7g\u0003\u0011\u0019X\r\u001c4\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\u0003\u0005\faA]3tk2$X#A1\u00025M,\u0017M]2i\u0007>t7M]3uKRCWM\u001c#fM\u0016\u0014(/\u001a3\u0002\u001f]\fGn\u001b\"bg\u0016\u001cE.Y:tKN$\u0002\"!\u001c\u0002t\u0005]\u00141\u0010\t\u0004%\u0006=\u0014bAA9\u001b\n9!i\\8mK\u0006t\u0007bBA;3\u0001\u0007\u0011QH\u0001\u000eg\u0016dWm\u0019;pe\u000ec\u0017m]:\t\u000f\u0005e\u0014\u00041\u0001\u0002\n\u0005A!/Z9vSJ,G\rC\u0004\u0002~e\u0001\r!!\u0003\u0002\u0011\u0015D8\r\\;eK\u0012\fAb\u001d5peR\u001c\u0015N]2vSR$B!!\u001c\u0002\u0004\"9\u0011Q\u0011\u000eA\u0002\u0005u\u0012aA:z[\u0006q\u0011\r\u001a3NK6\u0014WM]%g\u001d\u0016<HcA,\u0002\f\"9\u0011QQ\u000eA\u0002\u0005u\u0012!E5t!>$XM\u001c;jC2lU-\u001c2feRq\u0011QNAI\u0003'\u000b9*!'\u0002\u001e\u0006\u0005\u0006bBAC9\u0001\u0007\u0011Q\b\u0005\b\u0003+c\u0002\u0019AA\u0005\u0003\u00151G.Y4t\u0011\u001d\t)\b\ba\u0001\u0003{Aq!a'\u001d\u0001\u0004\ti$A\u0003po:,'\u000fC\u0004\u0002 r\u0001\r!!\u001c\u00027M,WM\u001c$jeN$hj\u001c8SK\u001aLg.Z7f]R\u001cE.Y:t\u0011\u001d\t\u0019\u000b\ba\u0001\u0003K\t\u0011C]3gS:,W.\u001a8u\u00072\f7o]3t\u0003-I7OT3x\u001b\u0016l'-\u001a:\u0015\r\u00055\u0014\u0011VAW\u0011\u001d\tY+\ba\u0001\u0003{\ta!\\3nE\u0016\u0014\bbBAX;\u0001\u0007\u0011QH\u0001\u0006_RDWM]\u0001\u0013?6,WNY3s)f\u0004X\rS5DC\u000eDW-A\u000b`[\u0016l'-\u001a:UsB,\u0007*[\"bG\",7+_7\u0002\u00195,WNY3s)f\u0004X\rS5\u0015\u00075\fI\fC\u0004\u0002\u0006\u0002\u0002\r!!\u0010\u0002\u001b5,WNY3s)f\u0004X\rT8x)\ri\u0017q\u0018\u0005\b\u0003\u000b\u000b\u0003\u0019AA\u001f\u0003Mq\u0017M\u001d:po\u001a{'OR5oI6+WNY3s)\ri\u0017Q\u0019\u0005\u0007\u0003\u000f\u0014\u0003\u0019A7\u0002\u0005Q\u00048cA\u0012\u0002LB!\u0001MAAg!\r\u0001\u0017qZ\u0005\u0005\u0003#\f\u0019NA\u0003TG>\u0004X-C\u0002\u0002V&\u0013aaU2pa\u0016\u001cH\u0003CAm\u00037\fi.a8\u0011\u0005\u0001\u001c\u0003\"\u0002%(\u0001\u0004i\u0007bBA\u0003O\u0001\u0007\u0011\u0011\u0002\u0005\b\u0003/9\u0003\u0019AA\u0005\u00035yV.Z7cKJ\u001c8kY8qK\u0006aQ.Z7cKJ\u001c8kY8qKV\u0011\u0011Q\u001a\u000b\u0005\u0003[\nI\u000fC\u0004\u0002\u0006*\u0002\r!!\u0010\u0015\u0007]\u000bi\u000fC\u0004\u0002\u00062\u0002\r!!\u0010\u0002%\u0019Lg\u000eZ'f[\n,'/\u00138ti\u0006t7-Z\u000b\u0003\u0003g\u0004b!!>\u0002|\u0006}XBAA|\u0015\r\tI0S\u0001\u0005kRLG.\u0003\u0003\u0002~\u0006](\u0001\u0005*fkN\f'\r\\3J]N$\u0018M\\2f!\t\u0001gF\u0001\u0006GS:$W*Z7cKJ\u001c2A\fB\u0003!\u0011\u0001'!!\u0010\u0015\u0005\u0005}\u0018AC:uC\ndWm\u00148ms\u00069Q.Z7cKJ\u0004\u0014aB7f[\n,'o]\u0001\u0006Y\u0006\u001cH/\u0014\t\u0007\u0003O\u0011\u0019\"!\u0010\n\t\tU\u00111\b\u0002\rI\r|Gn\u001c8%G>dwN\u001c\u000b\f/\ne!1\u0004B\u000f\u0005?\u0011\t\u0003C\u0003Ii\u0001\u0007Q\u000eC\u0003xi\u0001\u0007\u0011\u0010C\u0004\u0002\u0006Q\u0002\r!!\u0003\t\u000f\u0005]A\u00071\u0001\u0002\n!9!\u0011\u0002\u001bA\u0002\u00055\u0014!E2mK\u0006\u0014\u0018I\u001c3BI\u0012\u0014Vm];miR\u0019qKa\n\t\u000f\u0005\u0015U\u00071\u0001\u0002>Q!\u0011Q\u000eB\u0016\u0011\u001d\t)I\u000ea\u0001\u0003{!2a\u0016B\u0018\u0011\u001d\t)i\u000ea\u0001\u0003{\t1bX7f[\n,'\u000f\r+qK\u0006QQ.Z7cKJ\u0004D\u000b]3\u0015\u00075\u00149\u0004C\u0004\u0002\u0006j\u0002\r!!\u0010\u0016\u0005\u0005u\"!\u0003%bg6+WNY3s'\ra$q\b\t\u0005A\n\ti\u0007\u0006\u0006\u0003D\t\u0015#q\tB%\u0005\u0017\u0002\"\u0001\u0019\u001f\t\u000b!\u000b\u0005\u0019A7\t\u000b]\f\u0005\u0019A=\t\u000f\u0005\u0015\u0011\t1\u0001\u0002\n!9\u0011qC!A\u0002\u0005%\u0011aB0sKN,H\u000e^\u000b\u0003\u0003[\"B!!\u001c\u0003T!9\u0011Q\u0011#A\u0002\u0005uBcA,\u0003X!9\u0011QQ#A\u0002\u0005u\u0002\u0003\u0002B.\u0005;j\u0011!S\u0005\u0004\u0005?J%aC*z[\n|G\u000eV1cY\u0016\u0004")
public interface FindMembers {
    public void scala$reflect$internal$tpe$FindMembers$_setter_$findMemberInstance_$eq(ReusableInstance<FindMember> var1);

    public ReusableInstance<FindMember> findMemberInstance();

    public static void $init$(FindMembers $this) {
        $this.scala$reflect$internal$tpe$FindMembers$_setter_$findMemberInstance_$eq(new ReusableInstance<FindMember>((Function0<FindMember> & java.io.Serializable & Serializable)() -> new FindMember((SymbolTable)$this), ((SymbolTable)$this).isCompilerUniverse()));
    }

    public final class FindMember
    extends FindMemberBase<Symbols.Symbol> {
        private boolean stableOnly = false;
        private Symbols.Symbol member0;
        private List<Symbols.Symbol> members;
        private $colon$colon<Symbols.Symbol> lastM;
        private Types.Type _member0Tpe = null;

        public void init(Types.Type tpe, Names.Name name, long excludedFlags, long requiredFlags, boolean stableOnly) {
            super.init(tpe, name, excludedFlags, requiredFlags);
            this.stableOnly = stableOnly;
            this.member0 = this.scala$reflect$internal$tpe$FindMembers$FindMember$$$outer().NoSymbol();
            this._member0Tpe = null;
            this.members = null;
            this.lastM = null;
        }

        private void clearAndAddResult(Symbols.Symbol sym) {
            this.member0 = sym;
            this.members = null;
            this.lastM = null;
        }

        @Override
        public boolean shortCircuit(Symbols.Symbol sym) {
            if (this.name().isTypeName() || this.stableOnly && sym.isStable() && !sym.hasVolatileType()) {
                this.clearAndAddResult(sym);
                return true;
            }
            return false;
        }

        @Override
        public void addMemberIfNew(Symbols.Symbol sym) {
            if (this.member0 == this.scala$reflect$internal$tpe$FindMembers$FindMember$$$outer().NoSymbol()) {
                this.member0 = sym;
                return;
            }
            if (this.members == null) {
                if (this.isNewMember(this.member0, sym)) {
                    this.lastM = new $colon$colon<Symbols.Symbol>(sym, null);
                    Symbols.Symbol symbol = this.member0;
                    this.members = this.lastM.$colon$colon(symbol);
                    return;
                }
            } else {
                boolean isNew = true;
                for (List ms = this.members; ms != null && isNew; ms = (List)ms.tail()) {
                    Symbols.Symbol member = ms.head();
                    if (this.isNewMember(member, sym)) continue;
                    isNew = false;
                }
                if (isNew) {
                    $colon$colon<Symbols.Symbol> lastM1 = new $colon$colon<Symbols.Symbol>(sym, null);
                    this.lastM.tl_$eq(lastM1);
                    this.lastM = lastM1;
                }
            }
        }

        private Types.Type member0Tpe() {
            this.scala$reflect$internal$tpe$FindMembers$FindMember$$$outer().assert(this.member0 != null);
            if (this._member0Tpe == null) {
                this._member0Tpe = this.self().memberType(this.member0);
            }
            return this._member0Tpe;
        }

        @Override
        public Types.Type memberTypeLow(Symbols.Symbol sym) {
            if (sym == this.member0) {
                return this.member0Tpe();
            }
            return super.memberTypeLow(sym);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public Symbols.Symbol result() {
            if (this.members == null) {
                Symbols.Symbol symbol = this.member0;
                Symbols.NoSymbol noSymbol = this.scala$reflect$internal$tpe$FindMembers$FindMember$$$outer().NoSymbol();
                if (!(symbol != null ? !symbol.equals(noSymbol) : noSymbol != null)) {
                    if (StatisticsStatics.areSomeColdStatsEnabled()) {
                        void incCounter_c;
                        Statistics statistics = this.scala$reflect$internal$tpe$FindMembers$FindMember$$$outer().statistics();
                        Statistics.SubCounter subCounter = ((TypesStats)((Object)this.scala$reflect$internal$tpe$FindMembers$FindMember$$$outer().statistics())).noMemberCount();
                        if (statistics == null) {
                            throw null;
                        }
                        if (statistics.areColdStatsLocallyEnabled() && incCounter_c != null) {
                            incCounter_c.value_$eq(incCounter_c.value() + 1);
                        }
                    }
                    return this.scala$reflect$internal$tpe$FindMembers$FindMember$$$outer().NoSymbol();
                }
                return this.member0;
            }
            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                void incCounter_c;
                Statistics statistics = this.scala$reflect$internal$tpe$FindMembers$FindMember$$$outer().statistics();
                Statistics.SubCounter subCounter = ((TypesStats)((Object)this.scala$reflect$internal$tpe$FindMembers$FindMember$$$outer().statistics())).multMemberCount();
                if (statistics == null) {
                    throw null;
                }
                if (statistics.areColdStatsLocallyEnabled() && incCounter_c != null) {
                    incCounter_c.value_$eq(incCounter_c.value() + 1);
                }
            }
            this.lastM.tl_$eq(Nil$.MODULE$);
            return this.initBaseClasses().head().newOverloaded(this.tpe(), this.members);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$FindMembers$FindMember$$$outer() {
            return this.$outer;
        }

        public FindMember(SymbolTable $outer) {
            super($outer);
        }
    }

    public static abstract class FindMemberBase<T> {
        private Types.Type tpe;
        private Names.Name name;
        private long excludedFlags;
        private long requiredFlags;
        private List<Symbols.Symbol> initBaseClasses;
        private Types.Type _self;
        private Types.Type _memberTypeHiCache;
        private Symbols.Symbol _memberTypeHiCacheSym;
        public final /* synthetic */ SymbolTable $outer;

        public Types.Type tpe() {
            return this.tpe;
        }

        public void tpe_$eq(Types.Type x$1) {
            this.tpe = x$1;
        }

        public Names.Name name() {
            return this.name;
        }

        public void name_$eq(Names.Name x$1) {
            this.name = x$1;
        }

        public long excludedFlags() {
            return this.excludedFlags;
        }

        public void excludedFlags_$eq(long x$1) {
            this.excludedFlags = x$1;
        }

        public long requiredFlags() {
            return this.requiredFlags;
        }

        public void requiredFlags_$eq(long x$1) {
            this.requiredFlags = x$1;
        }

        public List<Symbols.Symbol> initBaseClasses() {
            return this.initBaseClasses;
        }

        public void initBaseClasses_$eq(List<Symbols.Symbol> x$1) {
            this.initBaseClasses = x$1;
        }

        public void init(Types.Type tpe, Names.Name name, long excludedFlags, long requiredFlags) {
            this.tpe_$eq(tpe);
            this.name_$eq(name);
            this.excludedFlags_$eq(excludedFlags);
            this.requiredFlags_$eq(requiredFlags);
            this.initBaseClasses_$eq(tpe.baseClasses());
            this._self = null;
            this._memberTypeHiCache = null;
            this._memberTypeHiCacheSym = null;
        }

        public Types.Type self() {
            if (this._self == null) {
                this._self = this.narrowForFindMember(this.tpe());
            }
            return this._self;
        }

        /*
         * WARNING - void declaration
         */
        public T apply() {
            T t;
            Tuple2<Object, Object> tuple2;
            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                void incCounter_c;
                Statistics statistics = this.scala$reflect$internal$tpe$FindMembers$FindMemberBase$$$outer().statistics();
                Statistics.Counter counter = ((TypesStats)((Object)this.scala$reflect$internal$tpe$FindMembers$FindMemberBase$$$outer().statistics())).findMemberCount();
                if (statistics == null) {
                    throw null;
                }
                if (statistics.areColdStatsLocallyEnabled() && incCounter_c != null) {
                    incCounter_c.value_$eq(incCounter_c.value() + 1);
                }
            }
            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                void pushTimer_timers;
                Statistics statistics = this.scala$reflect$internal$tpe$FindMembers$FindMemberBase$$$outer().statistics();
                Statistics.TimerStack timerStack = ((TypesStats)((Object)this.scala$reflect$internal$tpe$FindMembers$FindMemberBase$$$outer().statistics())).typeOpsStack();
                if (statistics == null) {
                    throw null;
                }
                tuple2 = statistics.areColdStatsLocallyEnabled() && pushTimer_timers != null ? pushTimer_timers.push(FindMemberBase.$anonfun$apply$1(this)) : null;
            } else {
                tuple2 = null;
            }
            Tuple2<Object, Object> start = tuple2;
            try {
                t = this.searchConcreteThenDeferred();
            }
            catch (Throwable throwable) {
                if (StatisticsStatics.areSomeColdStatsEnabled()) {
                    void popTimer_timers;
                    Statistics statistics = this.scala$reflect$internal$tpe$FindMembers$FindMemberBase$$$outer().statistics();
                    Statistics.TimerStack timerStack = ((TypesStats)((Object)this.scala$reflect$internal$tpe$FindMembers$FindMemberBase$$$outer().statistics())).typeOpsStack();
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
                Statistics statistics = this.scala$reflect$internal$tpe$FindMembers$FindMemberBase$$$outer().statistics();
                Statistics.TimerStack timerStack = ((TypesStats)((Object)this.scala$reflect$internal$tpe$FindMembers$FindMemberBase$$$outer().statistics())).typeOpsStack();
                if (statistics == null) {
                    throw null;
                }
                if (statistics.areColdStatsLocallyEnabled() && popTimer_timers != null) {
                    popTimer_timers.pop(start);
                    return t;
                }
            }
            return t;
        }

        public abstract T result();

        private T searchConcreteThenDeferred() {
            Symbols.Symbol symbol;
            Types.Type type = this.tpe();
            if (type instanceof Types.ThisType) {
                symbol = ((Types.ThisType)type).sym();
            } else {
                List<Symbols.Symbol> list = this.initBaseClasses();
                Symbols.Symbol symbol2 = ((Object)Nil$.MODULE$).equals(list) ? this.scala$reflect$internal$tpe$FindMembers$FindMemberBase$$$outer().NoSymbol() : list.head();
                symbol = symbol2;
            }
            if (this.walkBaseClasses(symbol, this.requiredFlags(), this.excludedFlags() | 0x10L)) {
                this.walkBaseClasses(symbol, this.requiredFlags() | 0x10L, this.excludedFlags() & ((long)16 ^ 0xFFFFFFFFFFFFFFFFL));
            }
            return this.result();
        }

        private boolean walkBaseClasses(Symbols.Symbol selectorClass, long required, long excluded) {
            boolean fastFlags;
            List bcs = this.initBaseClasses();
            boolean deferredSeen = false;
            List refinementClasses = Nil$.MODULE$;
            boolean seenFirstNonRefinementClass = false;
            Names.Name name = this.name();
            Names.TermName termName = this.scala$reflect$internal$tpe$FindMembers$FindMemberBase$$$outer().nme().ANYname();
            boolean findAll2 = !(name != null ? !name.equals(termName) : termName != null);
            long phaseFlagMask = this.scala$reflect$internal$tpe$FindMembers$FindMemberBase$$$outer().phase().flagMask();
            boolean bl = fastFlags = (phaseFlagMask & (0x7FFFFFFFFFFFFL ^ 0xFFFFFFFFFFFFFFFFL)) == 0L;
            while (!bcs.isEmpty()) {
                Scopes.ScopeEntry entry;
                Symbols.Symbol currentBaseClass = bcs.head();
                Scopes.Scope decls = currentBaseClass.info().decls();
                Scopes.ScopeEntry scopeEntry = entry = findAll2 ? decls.elems() : decls.lookupEntry(this.name());
                while (entry != null) {
                    Symbols.Symbol sym = entry.sym();
                    long flags = fastFlags ? sym.rawflags() & phaseFlagMask : sym.flags(phaseFlagMask);
                    if ((flags & required) == required) {
                        long excl = flags & excluded;
                        if (!(excl != 0L) && this.isPotentialMember(sym, flags, selectorClass, currentBaseClass, seenFirstNonRefinementClass, refinementClasses)) {
                            if (this.shortCircuit(sym)) {
                                return false;
                            }
                            this.addMemberIfNew(sym);
                        } else if (excl == 16L) {
                            deferredSeen = true;
                        }
                    }
                    entry = findAll2 ? entry.next() : decls.lookupNextEntry(entry);
                }
                if (currentBaseClass.isRefinementClass()) {
                    refinementClasses = refinementClasses.$colon$colon(currentBaseClass);
                } else if (currentBaseClass.isClass()) {
                    seenFirstNonRefinementClass = true;
                }
                bcs = (List)bcs.tail();
            }
            return deferredSeen;
        }

        public abstract boolean shortCircuit(Symbols.Symbol var1);

        public abstract void addMemberIfNew(Symbols.Symbol var1);

        private boolean isPotentialMember(Symbols.Symbol sym, long flags, Symbols.Symbol selectorClass, Symbols.Symbol owner, boolean seenFirstNonRefinementClass, List<Symbols.Symbol> refinementClasses) {
            boolean isPrivateLocal;
            boolean isPrivate = (flags & 4L) == 4L;
            boolean bl = isPrivateLocal = (flags & 0x80004L) == 524292L;
            return !(sym.isClassConstructor() && owner != this.initBaseClasses().head() || isPrivate && owner != selectorClass && !FindMemberBase.admitPrivate$1(isPrivateLocal, seenFirstNonRefinementClass, refinementClasses, owner));
        }

        public boolean isNewMember(Symbols.Symbol member, Symbols.Symbol other) {
            return other != member && (member.owner() == other.owner() || (member.flags() & 4L) != 0L || (other.flags() & 4L) != 0L || !this.memberTypeLow(member).matches(this.memberTypeHi(other)));
        }

        public Types.Type memberTypeHi(Symbols.Symbol sym) {
            if (this._memberTypeHiCacheSym != sym) {
                this._memberTypeHiCache = this.self().memberType(sym);
                this._memberTypeHiCacheSym = sym;
            }
            return this._memberTypeHiCache;
        }

        public Types.Type memberTypeLow(Symbols.Symbol sym) {
            return this.self().memberType(sym);
        }

        private Types.Type narrowForFindMember(Types.Type tp) {
            Types.Type w = tp.widen();
            if (tp != w && this.scala$reflect$internal$tpe$FindMembers$FindMemberBase$$$outer().containsExistential(w)) {
                return w.narrow();
            }
            return tp.narrow();
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$FindMembers$FindMemberBase$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ Statistics.StackableTimer $anonfun$apply$1(FindMemberBase $this) {
            return ((TypesStats)((Object)$this.scala$reflect$internal$tpe$FindMembers$FindMemberBase$$$outer().statistics())).findMemberNanos();
        }

        public static final /* synthetic */ boolean $anonfun$isPotentialMember$2(Symbols.Symbol owner$1, Types.Type x$2) {
            return x$2.typeSymbol() == owner$1;
        }

        public static final /* synthetic */ boolean $anonfun$isPotentialMember$1(Symbols.Symbol owner$1, Symbols.Symbol x$1) {
            boolean bl;
            block3: {
                List<Types.Type> list = x$1.info().parents();
                if (list == null) {
                    throw null;
                }
                LinearSeqOptimized exists_these = list;
                while (!exists_these.isEmpty()) {
                    Types.Type type = (Types.Type)exists_these.head();
                    if (FindMemberBase.$anonfun$isPotentialMember$2(owner$1, type)) {
                        bl = true;
                        break block3;
                    }
                    exists_these = (LinearSeqOptimized)exists_these.tail();
                }
                bl = false;
            }
            return bl;
        }

        private static final boolean admitPrivate$1(boolean isPrivateLocal$1, boolean seenFirstNonRefinementClass$1, List refinementClasses$1, Symbols.Symbol owner$1) {
            block8: {
                block9: {
                    boolean bl;
                    block7: {
                        if (isPrivateLocal$1) break block8;
                        if (!seenFirstNonRefinementClass$1) break block9;
                        if (refinementClasses$1 == null) {
                            throw null;
                        }
                        LinearSeqOptimized exists_these = refinementClasses$1;
                        while (!exists_these.isEmpty()) {
                            Symbols.Symbol symbol = (Symbols.Symbol)exists_these.head();
                            if (FindMemberBase.$anonfun$isPotentialMember$1(owner$1, symbol)) {
                                bl = true;
                                break block7;
                            }
                            exists_these = (LinearSeqOptimized)exists_these.tail();
                        }
                        bl = false;
                    }
                    if (!bl) break block8;
                }
                return true;
            }
            return false;
        }

        public FindMemberBase(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            this.excludedFlags = 0L;
            this.requiredFlags = 0L;
            this._self = null;
            this._memberTypeHiCache = null;
            this._memberTypeHiCacheSym = null;
        }

        public static final /* synthetic */ Object $anonfun$isPotentialMember$2$adapted(Symbols.Symbol owner$1, Types.Type x$2) {
            return BoxesRunTime.boxToBoolean(FindMemberBase.$anonfun$isPotentialMember$2(owner$1, x$2));
        }

        public static final /* synthetic */ Object $anonfun$isPotentialMember$1$adapted(Symbols.Symbol owner$1, Symbols.Symbol x$1) {
            return BoxesRunTime.boxToBoolean(FindMemberBase.$anonfun$isPotentialMember$1(owner$1, x$1));
        }
    }

    public final class FindMembers
    extends FindMemberBase<Scopes.Scope> {
        private Scopes.Scope _membersScope;

        private Scopes.Scope membersScope() {
            if (this._membersScope == null) {
                this._membersScope = this.scala$reflect$internal$tpe$FindMembers$FindMembers$$$outer().newFindMemberScope();
            }
            return this._membersScope;
        }

        @Override
        public boolean shortCircuit(Symbols.Symbol sym) {
            return false;
        }

        @Override
        public Scopes.Scope result() {
            return this.membersScope();
        }

        @Override
        public void addMemberIfNew(Symbols.Symbol sym) {
            Scopes.Scope members = this.membersScope();
            Scopes.ScopeEntry others = members.lookupEntry(sym.name());
            boolean isNew = true;
            while (others != null && isNew) {
                Symbols.Symbol member = others.sym();
                if (!this.isNewMember(member, sym)) {
                    isNew = false;
                }
                others = members.lookupNextEntry(others);
            }
            if (isNew) {
                members.enter(sym);
            }
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$FindMembers$FindMembers$$$outer() {
            return this.$outer;
        }

        public FindMembers(SymbolTable $outer, Types.Type tpe, long excludedFlags, long requiredFlags) {
            super($outer);
            this.init(tpe, $outer.nme().ANYname(), excludedFlags, requiredFlags);
            this._membersScope = null;
        }
    }

    public final class HasMember
    extends FindMemberBase<Object> {
        private boolean _result;

        @Override
        public boolean result() {
            return this._result;
        }

        @Override
        public boolean shortCircuit(Symbols.Symbol sym) {
            this._result = true;
            return true;
        }

        @Override
        public void addMemberIfNew(Symbols.Symbol sym) {
        }

        public HasMember(SymbolTable $outer, Types.Type tpe, Names.Name name, long excludedFlags, long requiredFlags) {
            super($outer);
            this.init(tpe, name, excludedFlags, requiredFlags);
            this._result = false;
        }
    }
}

