/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.tpe;

import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Types;
import scala.reflect.internal.tpe.TypeMaps;
import scala.runtime.BoxedUnit;

@ScalaSignature(bytes="\u0006\u0001q3\u0011BD\b\u0011\u0002\u0007\u0005\u0011c\u0006-\t\u000bq\u0001A\u0011\u0001\u0010\t\r\t\u0002A\u0011C\t$\u0011\u0019\u0011\u0003\u0001\"\u0005\u0012c!)1\b\u0001C\ty\u0019!a\b\u0001\u0005@\u0011\u0015)U\u0001\"\u0001G\u0011%9U\u00011AA\u0002\u0013\u0005\u0001\nC\u0005J\u000b\u0001\u0007\t\u0019!C\u0001\u0015\"IQ*\u0002a\u0001\u0002\u0003\u0006K\u0001\n\u0005\u0006\u001d\u0016!\tA\b\u0005\u0006\u001f\u0016!I\u0001\u0015\u0005\u0006'\u0016!\t\u0001\u0016\u0005\t/\u0002A)\u0019!C\u0005y\ta1i\\7n_:|uO\\3sg*\u0011\u0001#E\u0001\u0004iB,'B\u0001\n\u0014\u0003!Ig\u000e^3s]\u0006d'B\u0001\u000b\u0016\u0003\u001d\u0011XM\u001a7fGRT\u0011AF\u0001\u0006g\u000e\fG.Y\n\u0003\u0001a\u0001\"!\u0007\u000e\u000e\u0003UI!aG\u000b\u0003\r\u0005s\u0017PU3g\u0003\u0019!\u0013N\\5uI\r\u0001A#A\u0010\u0011\u0005e\u0001\u0013BA\u0011\u0016\u0005\u0011)f.\u001b;\u0002\u0017\r|W.\\8o\u001f^tWM\u001d\u000b\u0003I)\u0002\"!\n\u0014\u000e\u0003\u0001I!a\n\u0015\u0003\rMKXNY8m\u0013\tI\u0013CA\u0004Ts6\u0014w\u000e\\:\t\u000b-\u0012\u0001\u0019\u0001\u0017\u0002\u0003Q\u0004\"!J\u0017\n\u00059z#\u0001\u0002+za\u0016L!\u0001M\t\u0003\u000bQK\b/Z:\u0015\u0005\u0011\u0012\u0004\"B\u001a\u0004\u0001\u0004!\u0014a\u0001;qgB\u0019Q\u0007\u000f\u0017\u000f\u0005e1\u0014BA\u001c\u0016\u0003\u001d\u0001\u0018mY6bO\u0016L!!\u000f\u001e\u0003\t1K7\u000f\u001e\u0006\u0003oU\tabY8n[>twj\u001e8fe6\u000b\u0007/F\u0001>!\t)SA\u0001\bD_6lwN\\(x]\u0016\u0014X*\u00199\u0014\u0005\u0015\u0001\u0005cA\u0013BI%\u0011!i\u0011\u0002\u0018)f\u0004X\r\u0016:bm\u0016\u00148/\u001a:XSRD'+Z:vYRL!\u0001R\b\u0003\u0011QK\b/Z'baN\fa\u0001P5oSRtD#A\u001f\u0002\rI,7/\u001e7u+\u0005!\u0013A\u0003:fgVdGo\u0018\u0013fcR\u0011qd\u0013\u0005\b\u0019\"\t\t\u00111\u0001%\u0003\rAH%M\u0001\be\u0016\u001cX\u000f\u001c;!\u0003\u0015\u0019G.Z1s\u0003!\u0011XmZ5ti\u0016\u0014HCA\u0010R\u0011\u0015\u00116\u00021\u0001%\u0003\r\u0019\u00180\\\u0001\tiJ\fg/\u001a:tKR\u0011q$\u0016\u0005\u0006-2\u0001\r\u0001L\u0001\u0003iB\f\u0011cY8n[>twj\u001e8fe6\u000b\u0007o\u00142k!\tI&,D\u0001\u0012\u0013\tY\u0016CA\u0006Ts6\u0014w\u000e\u001c+bE2,\u0007")
public interface CommonOwners {
    public static /* synthetic */ Symbols.Symbol commonOwner$(CommonOwners $this, Types.Type t) {
        return $this.commonOwner(t);
    }

    default public Symbols.Symbol commonOwner(Types.Type t) {
        return this.commonOwner(Nil$.MODULE$.$colon$colon(t));
    }

    public static /* synthetic */ Symbols.Symbol commonOwner$(CommonOwners $this, List tps) {
        return $this.commonOwner(tps);
    }

    default public Symbols.Symbol commonOwner(List<Types.Type> tps) {
        if (tps.isEmpty()) {
            return ((Symbols)((Object)this)).NoSymbol();
        }
        this.commonOwnerMap().clear();
        List foreach_these = tps;
        while (!foreach_these.isEmpty()) {
            Types.Type type = foreach_these.head();
            CommonOwners.$anonfun$commonOwner$1(this, type);
            foreach_these = (List)foreach_these.tail();
        }
        if (this.commonOwnerMap().result() != null) {
            return this.commonOwnerMap().result();
        }
        return ((Symbols)((Object)this)).NoSymbol();
    }

    public static /* synthetic */ CommonOwnerMap commonOwnerMap$(CommonOwners $this) {
        return $this.commonOwnerMap();
    }

    default public CommonOwnerMap commonOwnerMap() {
        return this.scala$reflect$internal$tpe$CommonOwners$$commonOwnerMapObj();
    }

    public static /* synthetic */ CommonOwnerMap scala$reflect$internal$tpe$CommonOwners$$commonOwnerMapObj$(CommonOwners $this) {
        return $this.scala$reflect$internal$tpe$CommonOwners$$commonOwnerMapObj();
    }

    default public CommonOwnerMap scala$reflect$internal$tpe$CommonOwners$$commonOwnerMapObj() {
        return new CommonOwnerMap((SymbolTable)this);
    }

    public static /* synthetic */ void $anonfun$commonOwner$1(CommonOwners $this, Types.Type x$2) {
        $this.commonOwnerMap().traverse(x$2);
    }

    public static void $init$(CommonOwners $this) {
    }

    public static /* synthetic */ Object $anonfun$commonOwner$1$adapted(CommonOwners $this, Types.Type x$2) {
        CommonOwners.$anonfun$commonOwner$1($this, x$2);
        return BoxedUnit.UNIT;
    }

    public static class CommonOwnerMap
    extends TypeMaps.TypeTraverserWithResult<Symbols.Symbol> {
        private Symbols.Symbol result;
        public final /* synthetic */ SymbolTable $outer;

        @Override
        public Symbols.Symbol result() {
            return this.result;
        }

        public void result_$eq(Symbols.Symbol x$1) {
            this.result = x$1;
        }

        @Override
        public void clear() {
            this.result_$eq(null);
        }

        private void register(Symbols.Symbol sym) {
            if (this.result() == null || sym == this.scala$reflect$internal$tpe$CommonOwners$CommonOwnerMap$$$outer().NoSymbol()) {
                this.result_$eq(sym);
                return;
            }
            while (this.result() != this.scala$reflect$internal$tpe$CommonOwners$CommonOwnerMap$$$outer().NoSymbol() && this.result() != sym && !sym.isNestedIn(this.result())) {
                this.result_$eq(this.result().owner());
            }
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        @Override
        public void traverse(Types.Type tp) {
            Types.Type type = tp.normalize();
            if (type instanceof Types.ThisType) {
                Symbols.Symbol sym = ((Types.ThisType)type).sym();
                this.register(sym);
                return;
            }
            if (type instanceof Types.TypeRef) {
                Types.TypeRef typeRef = (Types.TypeRef)type;
                Types.Type type2 = typeRef.pre();
                Symbols.Symbol sym = typeRef.sym();
                List args2 = typeRef.args();
                if (this.scala$reflect$internal$tpe$CommonOwners$CommonOwnerMap$$$outer().NoPrefix().equals(type2)) {
                    this.register(sym.owner());
                    if (args2 == null) {
                        throw null;
                    }
                    List foreach_these = args2;
                    while (!foreach_these.isEmpty()) {
                        Types.Type type3 = foreach_these.head();
                        this.traverse(type3);
                        foreach_these = (List)foreach_these.tail();
                    }
                    return;
                }
            }
            if (type instanceof Types.SingleType) {
                Types.SingleType singleType = (Types.SingleType)type;
                Types.Type type4 = singleType.pre();
                Symbols.Symbol sym = singleType.sym();
                if (this.scala$reflect$internal$tpe$CommonOwners$CommonOwnerMap$$$outer().NoPrefix().equals(type4)) {
                    this.register(sym.owner());
                    return;
                }
            }
            this.mapOver(tp);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$CommonOwners$CommonOwnerMap$$$outer() {
            return this.$outer;
        }

        public CommonOwnerMap(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            super($outer);
        }

        public static final /* synthetic */ Object $anonfun$traverse$1$adapted(CommonOwnerMap $this, Types.Type tp) {
            $this.traverse(tp);
            return BoxedUnit.UNIT;
        }
    }
}

