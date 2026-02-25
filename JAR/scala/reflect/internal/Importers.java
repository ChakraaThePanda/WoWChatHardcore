/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Array$;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Predef$any2stringadd$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Set;
import scala.collection.immutable.Set$;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.MutableList;
import scala.collection.mutable.MutableList$;
import scala.collection.mutable.WeakHashMap;
import scala.ref.WeakReference;
import scala.ref.WeakReference$;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Internals;
import scala.reflect.api.Symbols;
import scala.reflect.api.Trees;
import scala.reflect.api.Types;
import scala.reflect.api.Universe;
import scala.reflect.internal.AnnotationInfos;
import scala.reflect.internal.Constants;
import scala.reflect.internal.Importers$StandardImporter$reverse$;
import scala.reflect.internal.Mirrors;
import scala.reflect.internal.Names;
import scala.reflect.internal.Scopes;
import scala.reflect.internal.StdAttachments;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Trees;
import scala.reflect.internal.Types;
import scala.reflect.internal.Types$NoType$;
import scala.reflect.internal.tpe.TypeConstraints;
import scala.reflect.internal.util.Collections;
import scala.reflect.internal.util.NoPosition$;
import scala.reflect.internal.util.Position;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.LambdaDeserialize;
import scala.runtime.java8.JFunction0$mcV$sp;

@ScalaSignature(bytes="\u0006\u0001\r\u0015a\u0001\u0003\u001a4!\u0003\r\tA\u000f2\t\u000b}\u0002A\u0011\u0001!\t\u000b\u0011\u0003A\u0011I#\u0007\u000bq\u0003\u0011\u0011A/\t\u000by\u001bA\u0011A0\t\u000fI\u001b!\u0019!D\u0001C\"Aam\u0001EC\u0002\u0013Eq\r\u0003\u0006\u00026\rA)\u0019!C\t\u0003o1AA[\u0002\tW\"1a\f\u0003C\u0001\u0003\u0017Aq!a\u0004\t\t\u0003\t\t\u0002C\u0004\u0002\u001e!!\t!a\b\t\u0013\u0005\u001d3\u00011A\u0005\u0002\u0005%\u0003\"CA)\u0007\u0001\u0007I\u0011AA*\u0011!\tIf\u0001Q!\n\u0005-\u0003\"CA.\u0007\u0001\u0007I\u0011AA%\u0011%\tif\u0001a\u0001\n\u0003\ty\u0006\u0003\u0005\u0002d\r\u0001\u000b\u0015BA&\u0011)\t)g\u0001EC\u0002\u0013\u0005\u0011q\r\u0005\b\u0003k\u001aA\u0011AA<\u0011\u0019\t\u0019i\u0001C\u0001\u0001\u001e9\u0011QQ\u0002\t\u0002\u0005\u001deaBAE\u0007!\u0005\u00111\u0012\u0005\u0007=Z!\t!a$\t\u0011I3\"\u0019!C\u0001\u0003#Cq!a%\u0017A\u0003%!\nC\u0004\u0002\u0016\u000e!\t\"a&\t\u000f\u0005E6\u0001\"\u0005\u00024\"9\u0011qW\u0002\u0005\u0002\u0005e\u0006bBA`\u0007\u0011\u0005\u0011\u0011\u0019\u0005\b\u0003\u000b\u001cA\u0011AAd\u0011\u001d\tYm\u0001C\u0001\u0003\u001bDq!a8\u0004\t\u0003\t\t\u000fC\u0004\u0002f\u000e!\t!a:\t\u000f\u0005-8\u0001\"\u0001\u0002n\"9!qB\u0002\u0005\u0002\tE\u0001b\u0002B\u0012\u0007\u0011\u0005!Q\u0005\u0005\b\u0005g\u0019A\u0011\u0001B\u001b\u0011\u001d\u0011)e\u0001C\u0001\u0005\u000fBqA!\u0017\u0004\t\u0003\u0011Y\u0006C\u0004\u0003n\r!\tAa\u001c\t\u000f\tu4\u0001\"\u0001\u0003\u0000!9!QR\u0002\u0005\u0002\t=\u0005b\u0002BO\u0007\u0011\u0005!q\u0014\u0005\b\u0005W\u001bA\u0011\u0001BW\u0011\u001d\u0011Il\u0001C\u0001\u0005wCqAa2\u0004\t\u0003\u0011I\rC\u0004\u0003V\u000e!\tAa6\t\u000f\t\r8\u0001\"\u0001\u0003f\"9!\u0011_\u0002\u0005\u0002\tM(!C%na>\u0014H/\u001a:t\u0015\t!T'\u0001\u0005j]R,'O\\1m\u0015\t1t'A\u0004sK\u001adWm\u0019;\u000b\u0003a\nQa]2bY\u0006\u001c\u0001a\u0005\u0002\u0001wA\u0011A(P\u0007\u0002o%\u0011ah\u000e\u0002\u0007\u0003:L(+\u001a4\u0002\r\u0011Jg.\u001b;%)\u0005\t\u0005C\u0001\u001fC\u0013\t\u0019uG\u0001\u0003V]&$\u0018AC7l\u00136\u0004xN\u001d;feR\u0011aI\u0016\n\u0003\u000f&3A\u0001\u0013\u0001\u0001\r\naAH]3gS:,W.\u001a8u}A\u0011!jS\u0007\u0002\u0001%\u0011A*\u0014\u0002\t\u00136\u0004xN\u001d;fe&\u0011aj\u0014\u0002\n\u0013:$XM\u001d8bYNT!\u0001U\u001b\u0002\u0007\u0005\u0004\u0018\u000eC\u0004S\u000f\n\u0007i\u0011I*\u0002\t\u0019\u0014x.\\\u000b\u0002):\u0011QK\u0016\u0007\u0001\u0011\u00159&\u00011\u0001Y\u0003\u00151'o\\71!\tI&,D\u0001P\u0013\tYvJ\u0001\u0005V]&4XM]:f\u0005A\u0019F/\u00198eCJ$\u0017*\u001c9peR,'oE\u0002\u0004w%\u000ba\u0001P5oSRtD#\u00011\u0011\u0005)\u001bQ#\u00012\u0011\u0005\r$W\"A\u001a\n\u0005\u0015\u001c$aC*z[\n|G\u000eV1cY\u0016\faa]=n\u001b\u0006\u0004X#\u00015\u0011\r%D\u0011qEA\u001a\u001b\u0005\u0019!!B\"bG\",W\u0003\u00027w\u0003\u000f\u0019\"\u0001C7\u0011\t9\u001cX\u000f`\u0007\u0002_*\u0011\u0001/]\u0001\b[V$\u0018M\u00197f\u0015\t\u0011x'\u0001\u0006d_2dWm\u0019;j_:L!\u0001^8\u0003\u0017]+\u0017m\u001b%bg\"l\u0015\r\u001d\t\u0003+Z$Qa\u001e\u0005C\u0002a\u0014\u0011aS\t\u0003sn\u0002\"\u0001\u0010>\n\u0005m<$a\u0002(pi\"Lgn\u001a\t\u0006{\u0006\u0005\u0011QA\u0007\u0002}*\u0011qpN\u0001\u0004e\u00164\u0017bAA\u0002}\niq+Z1l%\u00164WM]3oG\u0016\u00042!VA\u0004\t\u0019\tI\u0001\u0003b\u0001q\n\ta\u000b\u0006\u0002\u0002\u000eA)\u0011\u000eC;\u0002\u0006\u00059q/Z1l\u000f\u0016$H\u0003BA\n\u00033\u0001R\u0001PA\u000b\u0003\u000bI1!a\u00068\u0005\u0019y\u0005\u000f^5p]\"1\u00111\u0004\u0006A\u0002U\f1a[3z\u0003)9X-Y6Va\u0012\fG/\u001a\u000b\u0006\u0003\u0006\u0005\u00121\u0005\u0005\u0007\u00037Y\u0001\u0019A;\t\u000f\u0005\u00152\u00021\u0001\u0002\u0006\u0005)a/\u00197vKB!\u0011\u0011FA\u0016\u001d\tIW!\u0003\u0003\u0002.\u0005=\"AB*z[\n|G.C\u0002\u00022M\u0012qaU=nE>d7\u000fE\u0002K\u0003W\ta\u0001\u001e9f\u001b\u0006\u0004XCAA\u001d!\u0019I\u0007\"a\u000f\u0002FA!\u0011\u0011FA\u001f\u0013\u0011\ty$!\u0011\u0003\tQK\b/Z\u0005\u0004\u0003\u0007\u001a$!\u0002+za\u0016\u001c\bc\u0001&\u0002>\u0005Y\u0001/\u001a8eS:<7+_7t+\t\tY\u0005E\u0002=\u0003\u001bJ1!a\u00148\u0005\rIe\u000e^\u0001\u0010a\u0016tG-\u001b8h'fl7o\u0018\u0013fcR\u0019\u0011)!\u0016\t\u0013\u0005]S\"!AA\u0002\u0005-\u0013a\u0001=%c\u0005a\u0001/\u001a8eS:<7+_7tA\u0005Y\u0001/\u001a8eS:<G\u000b]3t\u0003=\u0001XM\u001c3j]\u001e$\u0006/Z:`I\u0015\fHcA!\u0002b!I\u0011q\u000b\t\u0002\u0002\u0003\u0007\u00111J\u0001\ra\u0016tG-\u001b8h)B,7\u000fI\u0001\u0007M&DX\u000f]:\u0016\u0005\u0005%\u0004#\u00028\u0002l\u0005=\u0014bAA7_\nYQ*\u001e;bE2,G*[:u!\u0011a\u0014\u0011O!\n\u0007\u0005MtGA\u0005Gk:\u001cG/[8oa\u0005A\u0011\r\u001a3GSb,\b\u000fF\u0002B\u0003sB\u0001\"a\u001f\u0014\t\u0003\u0007\u0011QP\u0001\u0006M&DX\u000f\u001d\t\u0005y\u0005}\u0014)C\u0002\u0002\u0002^\u0012\u0001\u0002\u00102z]\u0006lWMP\u0001\tiJLh)\u001b=va\u00069!/\u001a<feN,\u0007CA5\u0017\u0005\u001d\u0011XM^3sg\u0016\u001c2AFAG!\r\tIc\u0001\u000b\u0003\u0003\u000f+\u0012AS\u0001\u0006MJ|W\u000eI\u0001\u0019e\u0016\u001c'/Z1uK\u0012\u001c\u00160\u001c2pY\u000e{W\u000e\u001d7fi\u0016\u0014HCBAM\u0003S\u000biK\u0005\u0004\u0002\u001c\u0006u\u00151\u0015\u0004\u0006\u0011j\u0001\u0011\u0011\u0014\t\u0004\u0015\u0006}\u0015\u0002BAQ\u0003\u0003\u0012A\u0002T1{sB{G.\u001f+za\u0016\u00042ASAS\u0013\u0011\t9+!\u0011\u0003+\u0019c\u0017mZ!h]>\u001cH/[2D_6\u0004H.\u001a;fe\"9\u00111\u0016\u000eA\u0002\u0005M\u0012AA7z\u0011\u001d\tyK\u0007a\u0001\u0003O\tQ\u0001\u001e5fSJ\faB]3de\u0016\fG/Z*z[\n|G\u000e\u0006\u0003\u00024\u0005U\u0006bBAX7\u0001\u0007\u0011qE\u0001\rS6\u0004xN\u001d;Ts6\u0014w\u000e\u001c\u000b\u0005\u0003g\tY\fC\u0004\u0002>r\u0001\r!a\n\u0002\rQDW-\u001b:1\u00031\u0011Xm\u0019:fCR,G+\u001f9f)\u0011\t)%a1\t\u000f\u0005=V\u00041\u0001\u0002<\u0005Q\u0011.\u001c9peR$\u0016\u0010]3\u0015\t\u0005\u0015\u0013\u0011\u001a\u0005\b\u0003_s\u0002\u0019AA\u001e\u0003Y\u0011Xm\u0019:fCR,G\r\u0016:fK\u000e{W\u000e\u001d7fi\u0016\u0014H#B!\u0002P\u0006m\u0007bBAX?\u0001\u0007\u0011\u0011\u001b\t\u0005\u0003S\t\u0019.\u0003\u0003\u0002V\u0006]'\u0001\u0002+sK\u0016L1!!74\u0005\u0015!&/Z3t\u0011\u001d\tYk\ba\u0001\u0003;\u00042ASAj\u00031\u0011Xm\u0019:fCR,GK]3f)\u0011\ti.a9\t\u000f\u0005=\u0006\u00051\u0001\u0002R\u0006Q\u0011.\u001c9peR$&/Z3\u0015\t\u0005u\u0017\u0011\u001e\u0005\b\u0003_\u000b\u0003\u0019AAi\u0003EIW\u000e]8si\u0006#H/Y2i[\u0016tGo\u001d\u000b\u0005\u0003_\u0014Y\u0001\u0005\u0004\u0002r\u0006}(Q\u0001\b\u0005\u0003g\fY\u0010E\u0002\u0002v^j!!a>\u000b\u0007\u0005e\u0018(\u0001\u0004=e>|GOP\u0005\u0004\u0003{<\u0014A\u0002)sK\u0012,g-\u0003\u0003\u0003\u0002\t\r!aA*fi*\u0019\u0011Q`\u001c\u0011\u0007q\u00129!C\u0002\u0003\n]\u00121!\u00118z\u0011\u001d\u0011iA\ta\u0001\u0003_\f1\"\u0019;uC\u000eDW.\u001a8ug\u0006!\u0012.\u001c9peR\feN\\8uCRLwN\\%oM>$BAa\u0005\u0003\u001eA\u0019!J!\u0006\n\t\t]!\u0011\u0004\u0002\u000f\u0003:tw\u000e^1uS>t\u0017J\u001c4p\u0013\r\u0011Yb\r\u0002\u0010\u0003:tw\u000e^1uS>t\u0017J\u001c4pg\"9!qD\u0012A\u0002\t\u0005\u0012aA1o]B!\u0011\u0011\u0006B\u000b\u00039IW\u000e]8si\u0006sgn\u001c;Be\u001e$BAa\n\u0003.A\u0019!J!\u000b\n\t\t-\"\u0011\u0004\u0002\u0012\u00072\f7o\u001d4jY\u0016\feN\\8u\u0003J<\u0007b\u0002B\u0018I\u0001\u0007!\u0011G\u0001\u0004CJ<\u0007\u0003BA\u0015\u0005S\ta\"[7q_J$\bk\\:ji&|g\u000e\u0006\u0003\u00038\t\u0005\u0003c\u0001&\u0003:%!!1\bB\u001f\u0005!\u0001vn]5uS>t\u0017b\u0001B g\tI\u0001k\\:ji&|gn\u001d\u0005\b\u0003_+\u0003\u0019\u0001B\"!\u0011\tIC!\u000f\u0002\u0017%l\u0007o\u001c:u'\u000e|\u0007/\u001a\u000b\u0005\u0005\u0013\u0012\u0019\u0006E\u0002K\u0005\u0017JAA!\u0014\u0003P\t)1kY8qK&\u0019!\u0011K\u001a\u0003\rM\u001bw\u000e]3t\u0011\u001d\u0011)F\na\u0001\u0005/\nQ\u0001Z3dYN\u0004B!!\u000b\u0003L\u0005Q\u0011.\u001c9peRt\u0015-\\3\u0015\t\tu#q\r\t\u0004\u0015\n}\u0013\u0002\u0002B1\u0005G\u0012AAT1nK&\u0019!QM\u001a\u0003\u000b9\u000bW.Z:\t\u000f\t%t\u00051\u0001\u0003l\u0005!a.Y7f!\u0011\tICa\u0018\u0002\u001f%l\u0007o\u001c:u\u001b>$\u0017NZ5feN$BA!\u001d\u0003xA\u0019!Ja\u001d\n\t\tU\u0014q\u001b\u0002\n\u001b>$\u0017NZ5feNDqA!\u001f)\u0001\u0004\u0011Y(\u0001\u0003n_\u0012\u001c\b\u0003BA\u0015\u0005g\nA#[7q_J$\u0018*\u001c9peR\u001cV\r\\3di>\u0014H\u0003\u0002BA\u0005\u000f\u00032A\u0013BB\u0013\u0011\u0011))a6\u0003\u001d%k\u0007o\u001c:u'\u0016dWm\u0019;pe\"9!\u0011R\u0015A\u0002\t-\u0015aA:fYB!\u0011\u0011\u0006BB\u00031IW\u000e]8siZ\u000bG\u000eR3g)\u0011\u0011\tJa&\u0011\u0007)\u0013\u0019*\u0003\u0003\u0003\u0016\u0006]'A\u0002,bY\u0012+g\rC\u0004\u0003\u001a*\u0002\rAa'\u0002\tQ\u0014X-\u001a\t\u0005\u0003S\u0011\u0019*A\u0007j[B|'\u000f\u001e+za\u0016$UM\u001a\u000b\u0005\u0005C\u00139\u000bE\u0002K\u0005GKAA!*\u0002X\n9A+\u001f9f\t\u00164\u0007b\u0002BMW\u0001\u0007!\u0011\u0016\t\u0005\u0003S\u0011\u0019+A\bj[B|'\u000f^'f[\n,'\u000fR3g)\u0011\u0011yK!.\u0011\u0007)\u0013\t,\u0003\u0003\u00034\u0006]'!C'f[\n,'\u000fR3g\u0011\u001d\u0011I\n\fa\u0001\u0005o\u0003B!!\u000b\u00032\u0006q\u0011.\u001c9peR$V-\u001c9mCR,G\u0003\u0002B_\u0005\u0007\u00042A\u0013B`\u0013\u0011\u0011\t-a6\u0003\u0011Q+W\u000e\u001d7bi\u0016DqA!'.\u0001\u0004\u0011)\r\u0005\u0003\u0002*\t}\u0016!D5na>\u0014HOU3g)J,W\r\u0006\u0003\u0003L\nE\u0007c\u0001&\u0003N&!!qZAl\u0005\u001d\u0011VM\u001a+sK\u0016DqA!'/\u0001\u0004\u0011\u0019\u000e\u0005\u0003\u0002*\t5\u0017aC5na>\u0014H/\u00133f]R$BA!7\u0003`B\u0019!Ja7\n\t\tu\u0017q\u001b\u0002\u0006\u0013\u0012,g\u000e\u001e\u0005\b\u00053{\u0003\u0019\u0001Bq!\u0011\tICa7\u0002\u001b%l\u0007o\u001c:u\u0007\u0006\u001cX\rR3g)\u0011\u00119O!<\u0011\u0007)\u0013I/\u0003\u0003\u0003l\u0006]'aB\"bg\u0016$UM\u001a\u0005\b\u00053\u0003\u0004\u0019\u0001Bx!\u0011\tIC!;\u0002\u001d%l\u0007o\u001c:u\u0007>t7\u000f^1oiR!!Q\u001fB\u0000!\rQ%q_\u0005\u0005\u0005s\u0014YP\u0001\u0005D_:\u001cH/\u00198u\u0013\r\u0011ip\r\u0002\n\u0007>t7\u000f^1oiNDqa!\u00012\u0001\u0004\u0019\u0019!\u0001\u0005d_:\u001cH/\u00198u!\u0011\tICa>")
public interface Importers {
    public static /* synthetic */ Internals.Importer mkImporter$(Importers $this, Universe from0) {
        return $this.mkImporter(from0);
    }

    default public Internals.Importer mkImporter(Universe from0) {
        Internals.Importer importer;
        if (this == from0) {
            importer = new Internals.Importer((SymbolTable)this, from0){
                private final Universe from;
                private final Internals.Importer reverse;

                public Universe from() {
                    return this.from;
                }

                public Internals.Importer reverse() {
                    return this.reverse;
                }

                public Symbols.Symbol importSymbol(Symbols.SymbolApi their) {
                    return (Symbols.Symbol)their;
                }

                public Types.Type importType(Types.TypeApi their) {
                    return (Types.Type)their;
                }

                public Trees.Tree importTree(Trees.TreeApi their) {
                    return (Trees.Tree)their;
                }

                public Position importPosition(scala.reflect.api.Position their) {
                    return (Position)their;
                }
                {
                    this.from = from0$1;
                    this.reverse = this;
                }
            };
        } else {
            boolean assert_assertion = from0 instanceof SymbolTable;
            SymbolTable assert_this = (SymbolTable)this;
            if (!assert_assertion) {
                throw assert_this.throwAssertionError(Importers.$anonfun$mkImporter$1());
            }
            importer = new StandardImporter((SymbolTable)this, from0){
                private final SymbolTable from;

                public SymbolTable from() {
                    return this.from;
                }
                {
                    this.from = (SymbolTable)from0$1;
                }
            };
        }
        return importer;
    }

    public static /* synthetic */ String $anonfun$mkImporter$1() {
        return "`from` should be an instance of scala.reflect.internal.SymbolTable";
    }

    public static void $init$(Importers $this) {
    }

    public static abstract class StandardImporter
    implements Internals.Importer {
        private Cache<Symbols.Symbol, Symbols.Symbol> symMap;
        private Cache<Types.Type, Types.Type> tpeMap;
        private MutableList<Function0<BoxedUnit>> fixups;
        private volatile Importers$StandardImporter$reverse$ reverse$module;
        private int pendingSyms;
        private int pendingTpes;
        private volatile byte bitmap$0;
        public final /* synthetic */ SymbolTable $outer;

        @Override
        public Importers$StandardImporter$reverse$ reverse() {
            if (this.reverse$module == null) {
                this.reverse$lzycompute$1();
            }
            return this.reverse$module;
        }

        @Override
        public abstract SymbolTable from();

        private Cache<Symbols.Symbol, Symbols.Symbol> symMap$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 1) == 0) {
                    this.symMap = new Cache();
                    this.bitmap$0 = (byte)(this.bitmap$0 | 1);
                }
            }
            return this.symMap;
        }

        public Cache<Symbols.Symbol, Symbols.Symbol> symMap() {
            if ((byte)(this.bitmap$0 & 1) == 0) {
                return this.symMap$lzycompute();
            }
            return this.symMap;
        }

        private Cache<Types.Type, Types.Type> tpeMap$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 2) == 0) {
                    this.tpeMap = new Cache();
                    this.bitmap$0 = (byte)(this.bitmap$0 | 2);
                }
            }
            return this.tpeMap;
        }

        public Cache<Types.Type, Types.Type> tpeMap() {
            if ((byte)(this.bitmap$0 & 2) == 0) {
                return this.tpeMap$lzycompute();
            }
            return this.tpeMap;
        }

        public int pendingSyms() {
            return this.pendingSyms;
        }

        public void pendingSyms_$eq(int x$1) {
            this.pendingSyms = x$1;
        }

        public int pendingTpes() {
            return this.pendingTpes;
        }

        public void pendingTpes_$eq(int x$1) {
            this.pendingTpes = x$1;
        }

        private MutableList<Function0<BoxedUnit>> fixups$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 4) == 0) {
                    this.fixups = (MutableList)MutableList$.MODULE$.apply(Nil$.MODULE$);
                    this.bitmap$0 = (byte)(this.bitmap$0 | 4);
                }
            }
            return this.fixups;
        }

        public MutableList<Function0<BoxedUnit>> fixups() {
            if ((byte)(this.bitmap$0 & 4) == 0) {
                return this.fixups$lzycompute();
            }
            return this.fixups;
        }

        public void addFixup(Function0<BoxedUnit> fixup) {
            this.fixups().$plus$eq((Object)fixup);
        }

        public void tryFixup() {
            if (this.pendingSyms() == 0 && this.pendingTpes() == 0) {
                List fixups = this.fixups().toList();
                this.fixups().clear();
                if (fixups == null) {
                    throw null;
                }
                List foreach_these = fixups;
                while (!foreach_these.isEmpty()) {
                    foreach_these.head().apply$mcV$sp();
                    foreach_these = (List)foreach_these.tail();
                }
            }
        }

        public Types.LazyPolyType recreatedSymbolCompleter(Symbols.Symbol my, Symbols.Symbol their) {
            Types.FlagAgnosticCompleter flagAgnosticCompleter;
            try {
                my.setFlag(0x8000000000L);
                List mytypeParams = their.typeParams().map((Function1<Symbols.Symbol, Symbols.Symbol> & java.io.Serializable & Serializable)their0 -> this.importSymbol((Symbols.Symbol)their0), List$.MODULE$.canBuildFrom());
                flagAgnosticCompleter = new Types.FlagAgnosticCompleter(this, mytypeParams, their){
                    private final /* synthetic */ StandardImporter $outer;
                    private final Symbols.Symbol their$1;
                    private final List mytypeParams$1;

                    public void complete(Symbols.Symbol my) {
                        Types.Type type = this.their$1.info();
                        Types.Type type2 = type instanceof Types.PolyType ? ((Types.PolyType)type).resultType() : type;
                        my.setInfo(this.$outer.scala$reflect$internal$Importers$StandardImporter$$$outer().GenPolyType().apply(this.mytypeParams$1, this.$outer.importType(type2)));
                        my.setAnnotations(this.their$1.annotations().map((Function1<AnnotationInfos.AnnotationInfo, AnnotationInfos.AnnotationInfo> & java.io.Serializable & Serializable)ann -> $this.$outer.importAnnotationInfo((AnnotationInfos.AnnotationInfo)ann), List$.MODULE$.canBuildFrom()));
                        this.$outer.scala$reflect$internal$Importers$StandardImporter$$$outer().markAllCompleted(Predef$.MODULE$.wrapRefArray((Object[])new Symbols.Symbol[]{my}));
                    }
                    {
                        if ($outer == null) {
                            throw null;
                        }
                        this.$outer = $outer;
                        this.their$1 = their$1;
                        this.mytypeParams$1 = mytypeParams$1;
                        super($outer.scala$reflect$internal$Importers$StandardImporter$$$outer(), mytypeParams$1);
                    }

                    private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                        return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$complete$1(scala.reflect.internal.Importers$StandardImporter$$anon$3 scala.reflect.internal.AnnotationInfos$AnnotationInfo )}, serializedLambda);
                    }
                };
            }
            finally {
                my.resetFlag(0x8000000000L);
            }
            return flagAgnosticCompleter;
        }

        /*
         * WARNING - void declaration
         */
        public Symbols.Symbol recreateSymbol(Symbols.Symbol their) {
            Symbols.Symbol symbol;
            Symbols.Symbol myowner = this.importSymbol(their.owner());
            Position mypos = this.importPosition(their.pos());
            Names.Name myname = this.importName(their.name());
            long myflags = their.flags();
            if (their instanceof Symbols.MethodSymbol) {
                void var21_7;
                Symbols.MethodSymbol methodSymbol = (Symbols.MethodSymbol)their;
                Symbols.MethodSymbol linkReferenced$1_my = myowner.newMethod(myname.toTermName(), mypos, myflags);
                this.symMap().weakUpdate(methodSymbol, linkReferenced$1_my);
                Symbols.Symbol symbol2 = methodSymbol.referenced();
                linkReferenced$1_my.referenced_$eq(this.importSymbol(symbol2));
                symbol = var21_7;
            } else if (their instanceof Symbols.ModuleSymbol) {
                void var22_11;
                Symbols.ModuleSymbol moduleSymbol = (Symbols.ModuleSymbol)their;
                Symbols.ModuleSymbol linkReferenced$1_my = myowner.newModuleSymbol(myname.toTermName(), mypos, myflags);
                this.symMap().weakUpdate(moduleSymbol, linkReferenced$1_my);
                Symbols.Symbol symbol3 = moduleSymbol.referenced();
                linkReferenced$1_my.referenced_$eq(this.importSymbol(symbol3));
                var22_11.associatedFile_$eq(moduleSymbol.associatedFile());
                symbol = var22_11;
            } else if (their instanceof Symbols.FreeTermSymbol) {
                Symbols.FreeTermSymbol freeTermSymbol = (Symbols.FreeTermSymbol)their;
                symbol = this.scala$reflect$internal$Importers$StandardImporter$$$outer().newFreeTermSymbol(myname.toTermName(), (Function0<Object> & java.io.Serializable & Serializable)() -> freeTermSymbol.value(), freeTermSymbol.flags(), freeTermSymbol.origin()).setInfo(this.importType(freeTermSymbol.info()));
            } else if (their instanceof Symbols.FreeTypeSymbol) {
                Symbols.FreeTypeSymbol freeTypeSymbol = (Symbols.FreeTypeSymbol)their;
                symbol = this.scala$reflect$internal$Importers$StandardImporter$$$outer().newFreeTypeSymbol(myname.toTypeName(), freeTypeSymbol.flags(), freeTypeSymbol.origin());
            } else if (their instanceof Symbols.TermSymbol) {
                void var23_16;
                Symbols.TermSymbol termSymbol = (Symbols.TermSymbol)their;
                Symbols.TermSymbol linkReferenced$1_my = myowner.newValue(myname.toTermName(), mypos, myflags);
                this.symMap().weakUpdate(termSymbol, linkReferenced$1_my);
                Symbols.Symbol symbol4 = termSymbol.referenced();
                linkReferenced$1_my.referenced_$eq(this.importSymbol(symbol4));
                symbol = var23_16;
            } else if (their instanceof Symbols.TypeSkolem) {
                StdAttachments.Attachable attachable;
                Object object = ((Symbols.TypeSkolem)their).unpackLocation();
                if (object == null) {
                    attachable = null;
                } else if (object instanceof Trees.Tree && ((Trees.Tree)object).scala$reflect$internal$Trees$Tree$$$outer() == this.from()) {
                    Trees.Tree tree = (Trees.Tree)object;
                    attachable = this.importTree(tree);
                } else if (object instanceof Symbols.Symbol && ((Symbols.Symbol)object).scala$reflect$internal$Symbols$Symbol$$$outer() == this.from()) {
                    Symbols.Symbol symbol5 = (Symbols.Symbol)object;
                    attachable = this.importSymbol(symbol5);
                } else {
                    throw new MatchError(object);
                }
                symbol = myowner.newTypeSkolemSymbol(myname.toTypeName(), attachable, mypos, myflags);
            } else if (their instanceof Symbols.ModuleClassSymbol) {
                Symbols.ModuleClassSymbol moduleClassSymbol = (Symbols.ModuleClassSymbol)their;
                Symbols.ModuleClassSymbol my = myowner.newModuleClass(myname.toTypeName(), mypos, myflags);
                this.symMap().weakUpdate(moduleClassSymbol, my);
                my.sourceModule_$eq(this.importSymbol(moduleClassSymbol.sourceModule()));
                symbol = my;
            } else if (their instanceof Symbols.ClassSymbol) {
                Symbols.ClassSymbol classSymbol = (Symbols.ClassSymbol)their;
                Symbols.ClassSymbol my = myowner.newClassSymbol(myname.toTypeName(), mypos, myflags);
                this.symMap().weakUpdate(classSymbol, my);
                Symbols.Symbol symbol6 = classSymbol.thisSym();
                if (symbol6 == null || !symbol6.equals(classSymbol)) {
                    my.typeOfThis_$eq(this.importType(classSymbol.typeOfThis()));
                    my.thisSym().setName(this.importName(classSymbol.thisSym().name()));
                }
                my.associatedFile_$eq(classSymbol.associatedFile());
                symbol = my;
            } else if (their instanceof Symbols.TypeSymbol) {
                symbol = myowner.newTypeSymbol(myname.toTypeName(), mypos, myflags);
            } else {
                throw new MatchError(their);
            }
            this.symMap().weakUpdate(their, symbol);
            this.scala$reflect$internal$Importers$StandardImporter$$$outer().markFlagsCompleted(Predef$.MODULE$.wrapRefArray((Object[])new Symbols.Symbol[]{symbol}), -1L);
            return symbol.setInfo(this.recreatedSymbolCompleter(symbol, their));
        }

        public Symbols.Symbol importSymbol(Symbols.Symbol their0) {
            Symbols.Symbol symbol;
            Option<Symbols.Symbol> option = this.symMap().weakGet(their0);
            if (option instanceof Some) {
                symbol = (Symbols.Symbol)((Some)option).value();
            } else if (None$.MODULE$.equals(option)) {
                Symbols.Symbol symbol2;
                this.pendingSyms_$eq(this.pendingSyms() + 1);
                try {
                    Symbols.Symbol result2 = this.recreateOrRelink$1(their0);
                    this.symMap().weakUpdate(their0, result2);
                    symbol2 = result2;
                }
                finally {
                    this.pendingSyms_$eq(this.pendingSyms() - 1);
                    this.tryFixup();
                }
                symbol = symbol2;
            } else {
                throw new MatchError(option);
            }
            return symbol;
        }

        public Types.Type recreateType(Types.Type their2) {
            Constants.Constant constant;
            Types.Type type;
            if (their2 instanceof Types.TypeRef) {
                Types.TypeRef typeRef = (Types.TypeRef)their2;
                Types.Type pre = typeRef.pre();
                Symbols.Symbol sym = typeRef.sym();
                List<Types.Type> args2 = typeRef.args();
                type = this.scala$reflect$internal$Importers$StandardImporter$$$outer().TypeRef().apply(this.importType(pre), this.importSymbol(sym), args2.map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)their -> this.importType((Types.Type)their), List$.MODULE$.canBuildFrom()));
            } else if (their2 instanceof Types.ThisType) {
                Symbols.Symbol clazz = ((Types.ThisType)their2).sym();
                type = this.scala$reflect$internal$Importers$StandardImporter$$$outer().ThisType().apply(this.importSymbol(clazz));
            } else if (their2 instanceof Types.SingleType) {
                Types.SingleType singleType = (Types.SingleType)their2;
                Types.Type pre = singleType.pre();
                Symbols.Symbol sym = singleType.sym();
                type = this.scala$reflect$internal$Importers$StandardImporter$$$outer().SingleType().apply(this.importType(pre), this.importSymbol(sym));
            } else if (their2 instanceof Types.MethodType) {
                Types.MethodType methodType = (Types.MethodType)their2;
                List<Symbols.Symbol> params = methodType.params();
                Types.Type result2 = methodType.resultType();
                type = new Types.MethodType(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), params.map((Function1<Symbols.Symbol, Symbols.Symbol> & java.io.Serializable & Serializable)their0 -> this.importSymbol((Symbols.Symbol)their0), List$.MODULE$.canBuildFrom()), this.importType(result2));
            } else if (their2 instanceof Types.PolyType) {
                Types.PolyType polyType = (Types.PolyType)their2;
                List<Symbols.Symbol> tparams = polyType.typeParams();
                Types.Type result3 = polyType.resultType();
                type = new Types.PolyType(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), tparams.map((Function1<Symbols.Symbol, Symbols.Symbol> & java.io.Serializable & Serializable)their0 -> this.importSymbol((Symbols.Symbol)their0), List$.MODULE$.canBuildFrom()), this.importType(result3));
            } else if (their2 instanceof Types.NullaryMethodType) {
                Types.Type result4 = ((Types.NullaryMethodType)their2).resultType();
                type = new Types.NullaryMethodType(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importType(result4));
            } else if (their2 instanceof Types.ConstantType && (constant = ((Types.ConstantType)their2).value()) != null) {
                type = this.scala$reflect$internal$Importers$StandardImporter$$$outer().ConstantType().apply(this.importConstant(constant));
            } else if (their2 instanceof Types.SuperType) {
                Types.SuperType superType = (Types.SuperType)their2;
                Types.Type thistpe = superType.thistpe();
                Types.Type supertpe = superType.supertpe();
                type = this.scala$reflect$internal$Importers$StandardImporter$$$outer().SuperType().apply(this.importType(thistpe), this.importType(supertpe));
            } else if (their2 instanceof Types.TypeBounds) {
                Types.TypeBounds typeBounds = (Types.TypeBounds)their2;
                Types.Type lo = typeBounds.lo();
                Types.Type hi = typeBounds.hi();
                type = this.scala$reflect$internal$Importers$StandardImporter$$$outer().TypeBounds().apply(this.importType(lo), this.importType(hi));
            } else if (their2 instanceof Types.BoundedWildcardType) {
                Types.TypeBounds bounds = ((Types.BoundedWildcardType)their2).bounds();
                type = new Types.BoundedWildcardType(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), (Types.TypeBounds)this.importType(bounds));
            } else if (their2 instanceof Types.ClassInfoType) {
                Types.ClassInfoType classInfoType = (Types.ClassInfoType)their2;
                List<Types.Type> parents = classInfoType.parents();
                Scopes.Scope decls = classInfoType.decls();
                Symbols.Symbol clazz = classInfoType.typeSymbol();
                Symbols.Symbol myclazz = this.importSymbol(clazz);
                Scopes.Scope myscope = myclazz.isPackageClass() ? this.scala$reflect$internal$Importers$StandardImporter$$$outer().newPackageScope(myclazz) : this.scala$reflect$internal$Importers$StandardImporter$$$outer().newScope();
                Types.ClassInfoType myclazzTpe = new Types.ClassInfoType(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), parents.map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)their -> this.importType((Types.Type)their), List$.MODULE$.canBuildFrom()), myscope, myclazz);
                myclazz.setInfo(this.scala$reflect$internal$Importers$StandardImporter$$$outer().GenPolyType().apply(myclazz.typeParams(), myclazzTpe));
                decls.foreach((Function1<Symbols.Symbol, Symbols.Symbol> & java.io.Serializable & Serializable)their0 -> this.importSymbol((Symbols.Symbol)their0));
                type = myclazzTpe;
            } else if (their2 instanceof Types.RefinedType) {
                Types.RefinedType refinedType = (Types.RefinedType)their2;
                List<Types.Type> parents = refinedType.parents();
                Scopes.Scope decls = refinedType.decls();
                type = this.scala$reflect$internal$Importers$StandardImporter$$$outer().RefinedType().apply(parents.map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)their -> this.importType((Types.Type)their), List$.MODULE$.canBuildFrom()), this.importScope(decls), this.importSymbol(their2.typeSymbol()));
            } else if (their2 instanceof Types.ExistentialType) {
                Types.ExistentialType existentialType = (Types.ExistentialType)their2;
                List<Symbols.Symbol> tparams = existentialType.quantified();
                Types.Type result5 = existentialType.underlying();
                type = this.scala$reflect$internal$Importers$StandardImporter$$$outer().newExistentialType(tparams.map((Function1<Symbols.Symbol, Symbols.Symbol> & java.io.Serializable & Serializable)their0 -> this.importSymbol((Symbols.Symbol)their0), List$.MODULE$.canBuildFrom()), this.importType(result5));
            } else if (their2 instanceof Types.OverloadedType) {
                Types.OverloadedType overloadedType = (Types.OverloadedType)their2;
                Types.Type pre = overloadedType.pre();
                List<Symbols.Symbol> alts = overloadedType.alternatives();
                type = new Types.OverloadedType(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importType(pre), alts.map((Function1<Symbols.Symbol, Symbols.Symbol> & java.io.Serializable & Serializable)their0 -> this.importSymbol((Symbols.Symbol)their0), List$.MODULE$.canBuildFrom()));
            } else if (their2 instanceof Types.ImportType) {
                Trees.Tree qual = ((Types.ImportType)their2).expr();
                type = new Types.ImportType(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(qual));
            } else if (their2 instanceof Types.AntiPolyType) {
                Types.AntiPolyType antiPolyType = (Types.AntiPolyType)their2;
                Types.Type pre = antiPolyType.pre();
                List<Types.Type> targs = antiPolyType.targs();
                type = new Types.AntiPolyType(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importType(pre), targs.map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)their -> this.importType((Types.Type)their), List$.MODULE$.canBuildFrom()));
            } else if (their2 instanceof Types.TypeVar) {
                Types.TypeVar typeVar = (Types.TypeVar)their2;
                TypeConstraints.TypeConstraint myconstr = new TypeConstraints.TypeConstraint(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), typeVar.constr().loBounds().map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)their -> this.importType((Types.Type)their), List$.MODULE$.canBuildFrom()), typeVar.constr().hiBounds().map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)their -> this.importType((Types.Type)their), List$.MODULE$.canBuildFrom()));
                myconstr.inst_$eq(this.importType(typeVar.constr().inst()));
                type = this.scala$reflect$internal$Importers$StandardImporter$$$outer().TypeVar().apply(this.importType(typeVar.origin()), myconstr, typeVar.typeArgs().map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)their -> this.importType((Types.Type)their), List$.MODULE$.canBuildFrom()), typeVar.params().map((Function1<Symbols.Symbol, Symbols.Symbol> & java.io.Serializable & Serializable)their0 -> this.importSymbol((Symbols.Symbol)their0), List$.MODULE$.canBuildFrom()));
            } else if (their2 instanceof Types.AnnotatedType) {
                Types.AnnotatedType annotatedType = (Types.AnnotatedType)their2;
                List<AnnotationInfos.AnnotationInfo> annots = annotatedType.annotations();
                Types.Type result6 = annotatedType.underlying();
                type = new Types.AnnotatedType(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), annots.map((Function1<AnnotationInfos.AnnotationInfo, AnnotationInfos.AnnotationInfo> & java.io.Serializable & Serializable)ann -> this.importAnnotationInfo((AnnotationInfos.AnnotationInfo)ann), List$.MODULE$.canBuildFrom()), this.importType(result6));
            } else if (this.from().ErrorType().equals(their2)) {
                type = this.scala$reflect$internal$Importers$StandardImporter$$$outer().ErrorType();
            } else if (this.from().WildcardType().equals(their2)) {
                type = this.scala$reflect$internal$Importers$StandardImporter$$$outer().WildcardType();
            } else if (this.from().NoType().equals(their2)) {
                type = this.scala$reflect$internal$Importers$StandardImporter$$$outer().NoType();
            } else if (this.from().NoPrefix().equals(their2)) {
                type = this.scala$reflect$internal$Importers$StandardImporter$$$outer().NoPrefix();
            } else if (their2 == null) {
                type = null;
            } else {
                throw new MatchError(their2);
            }
            return type;
        }

        public Types.Type importType(Types.Type their) {
            Types.Type type;
            Option<Types.Type> option = this.tpeMap().weakGet(their);
            if (option instanceof Some) {
                type = (Types.Type)((Some)option).value();
            } else if (None$.MODULE$.equals(option)) {
                Types.Type type2;
                this.pendingTpes_$eq(this.pendingTpes() + 1);
                try {
                    Types.Type result2 = this.recreateType(their);
                    this.tpeMap().weakUpdate(their, result2);
                    type2 = result2;
                }
                finally {
                    this.pendingTpes_$eq(this.pendingTpes() - 1);
                    this.tryFixup();
                }
                type = type2;
            } else {
                throw new MatchError(option);
            }
            return type;
        }

        public void recreatedTreeCompleter(Trees.Tree their, Trees.Tree my) {
            if (their.canHaveAttrs()) {
                if (my.hasSymbolField()) {
                    my.symbol_$eq(this.importSymbol(their.symbol()));
                }
                my.pos_$eq(this.importPosition(their.pos()));
                Trees.Tree their2 = their;
                Trees.Tree my2 = my;
                if (their2 instanceof Trees.TypeTree) {
                    Trees.TypeTree typeTree = (Trees.TypeTree)their2;
                    if (my2 instanceof Trees.TypeTree) {
                        Trees.TypeTree typeTree2 = (Trees.TypeTree)my2;
                        if (typeTree.wasEmpty()) {
                            typeTree2.defineType(this.importType(typeTree.tpe()));
                            return;
                        }
                        typeTree2.setType(this.importType(typeTree.tpe()));
                        return;
                    }
                }
                my.setType(this.importType(their.tpe()));
                return;
            }
        }

        /*
         * WARNING - void declaration
         */
        public Trees.Tree recreateTree(Trees.Tree their2) {
            Constants.Constant constant;
            Trees.Tree tree2;
            if (their2 instanceof Trees.ClassDef) {
                Trees.ClassDef classDef = (Trees.ClassDef)their2;
                Trees.Modifiers mods = classDef.mods();
                Names.TypeName name = classDef.name();
                List<Trees.TypeDef> tparams = classDef.tparams();
                Trees.Template impl = classDef.impl();
                tree2 = new Trees.ClassDef(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importModifiers(mods), this.importName(name).toTypeName(), tparams.map((Function1<Trees.TypeDef, Trees.TypeDef> & java.io.Serializable & Serializable)tree -> this.importTypeDef((Trees.TypeDef)tree), List$.MODULE$.canBuildFrom()), this.importTemplate(impl));
            } else if (their2 instanceof Trees.PackageDef) {
                Trees.PackageDef packageDef = (Trees.PackageDef)their2;
                Trees.RefTree pid = packageDef.pid();
                List<Trees.Tree> stats = packageDef.stats();
                tree2 = new Trees.PackageDef(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importRefTree(pid), stats.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)their -> this.importTree((Trees.Tree)their), List$.MODULE$.canBuildFrom()));
            } else if (their2 instanceof Trees.ModuleDef) {
                Trees.ModuleDef moduleDef = (Trees.ModuleDef)their2;
                Trees.Modifiers mods = moduleDef.mods();
                Names.TermName name = moduleDef.name();
                Trees.Template impl = moduleDef.impl();
                tree2 = new Trees.ModuleDef(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importModifiers(mods), this.importName(name).toTermName(), this.importTemplate(impl));
            } else if (((Object)this.from().noSelfType()).equals(their2)) {
                tree2 = this.scala$reflect$internal$Importers$StandardImporter$$$outer().noSelfType();
            } else if (((Object)this.from().pendingSuperCall()).equals(their2)) {
                tree2 = this.scala$reflect$internal$Importers$StandardImporter$$$outer().pendingSuperCall();
            } else if (their2 instanceof Trees.ValDef) {
                Trees.ValDef valDef = (Trees.ValDef)their2;
                Trees.Modifiers mods = valDef.mods();
                Names.TermName name = valDef.name();
                Trees.Tree tpt = valDef.tpt();
                Trees.Tree rhs = valDef.rhs();
                tree2 = new Trees.ValDef(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importModifiers(mods), this.importName(name).toTermName(), this.importTree(tpt), this.importTree(rhs));
            } else if (their2 instanceof Trees.DefDef) {
                void mmap_f;
                Trees.DefDef defDef = (Trees.DefDef)their2;
                Trees.Modifiers mods = defDef.mods();
                Names.TermName name = defDef.name();
                List<Trees.TypeDef> tparams = defDef.tparams();
                List<List<Trees.ValDef>> vparamss = defDef.vparamss();
                Trees.Tree tpt = defDef.tpt();
                Trees.Tree rhs = defDef.rhs();
                Function1<Trees.ValDef, Trees.ValDef> & java.io.Serializable & Serializable intersect = (Function1<Trees.ValDef, Trees.ValDef> & java.io.Serializable & Serializable)tree -> this.importValDef((Trees.ValDef)tree);
                if (this.scala$reflect$internal$Importers$StandardImporter$$$outer() == null) {
                    throw null;
                }
                tree2 = new Trees.DefDef(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importModifiers(mods), this.importName(name).toTermName(), tparams.map((Function1<Trees.TypeDef, Trees.TypeDef> & java.io.Serializable & Serializable)tree -> this.importTypeDef((Trees.TypeDef)tree), List$.MODULE$.canBuildFrom()), vparamss.map(arg_0 -> Collections.$anonfun$mmap$1((Function1)mmap_f, arg_0), List$.MODULE$.canBuildFrom()), this.importTree(tpt), this.importTree(rhs));
            } else if (their2 instanceof Trees.TypeDef) {
                Trees.TypeDef typeDef = (Trees.TypeDef)their2;
                Trees.Modifiers mods = typeDef.mods();
                Names.TypeName name = typeDef.name();
                List<Trees.TypeDef> tparams = typeDef.tparams();
                Trees.Tree rhs = typeDef.rhs();
                tree2 = new Trees.TypeDef(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importModifiers(mods), this.importName(name).toTypeName(), tparams.map((Function1<Trees.TypeDef, Trees.TypeDef> & java.io.Serializable & Serializable)tree -> this.importTypeDef((Trees.TypeDef)tree), List$.MODULE$.canBuildFrom()), this.importTree(rhs));
            } else if (their2 instanceof Trees.LabelDef) {
                Trees.LabelDef labelDef = (Trees.LabelDef)their2;
                Names.TermName name = labelDef.name();
                List<Trees.Ident> params = labelDef.params();
                Trees.Tree rhs = labelDef.rhs();
                tree2 = new Trees.LabelDef(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importName(name).toTermName(), params.map((Function1<Trees.Ident, Trees.Ident> & java.io.Serializable & Serializable)tree -> this.importIdent((Trees.Ident)tree), List$.MODULE$.canBuildFrom()), this.importTree(rhs));
            } else if (their2 instanceof Trees.Import) {
                Trees.Import import_ = (Trees.Import)their2;
                Trees.Tree expr = import_.expr();
                List<Trees.ImportSelector> selectors = import_.selectors();
                tree2 = new Trees.Import(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(expr), selectors.map((Function1<Trees.ImportSelector, Trees.ImportSelector> & java.io.Serializable & Serializable)sel -> this.importImportSelector((Trees.ImportSelector)sel), List$.MODULE$.canBuildFrom()));
            } else if (their2 instanceof Trees.Template) {
                Trees.Template template = (Trees.Template)their2;
                List<Trees.Tree> parents = template.parents();
                Trees.ValDef self = template.self();
                List<Trees.Tree> body = template.body();
                tree2 = new Trees.Template(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), parents.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)their -> this.importTree((Trees.Tree)their), List$.MODULE$.canBuildFrom()), this.importValDef(self), body.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)their -> this.importTree((Trees.Tree)their), List$.MODULE$.canBuildFrom()));
            } else if (their2 instanceof Trees.Block) {
                Trees.Block block = (Trees.Block)their2;
                List<Trees.Tree> stats = block.stats();
                Trees.Tree expr = block.expr();
                tree2 = new Trees.Block(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), stats.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)their -> this.importTree((Trees.Tree)their), List$.MODULE$.canBuildFrom()), this.importTree(expr));
            } else if (their2 instanceof Trees.CaseDef) {
                Trees.CaseDef caseDef = (Trees.CaseDef)their2;
                Trees.Tree pat = caseDef.pat();
                Trees.Tree guard = caseDef.guard();
                Trees.Tree body = caseDef.body();
                tree2 = new Trees.CaseDef(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(pat), this.importTree(guard), this.importTree(body));
            } else if (their2 instanceof Trees.Alternative) {
                List<Trees.Tree> trees = ((Trees.Alternative)their2).trees();
                tree2 = new Trees.Alternative(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), trees.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)their -> this.importTree((Trees.Tree)their), List$.MODULE$.canBuildFrom()));
            } else if (their2 instanceof Trees.Star) {
                Trees.Tree elem = ((Trees.Star)their2).elem();
                tree2 = new Trees.Star(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(elem));
            } else if (their2 instanceof Trees.Bind) {
                Trees.Bind bind = (Trees.Bind)their2;
                Names.Name name = bind.name();
                Trees.Tree body = bind.body();
                tree2 = new Trees.Bind(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importName(name), this.importTree(body));
            } else if (their2 instanceof Trees.UnApply) {
                Trees.UnApply unApply = (Trees.UnApply)their2;
                Trees.Tree fun = unApply.fun();
                List<Trees.Tree> args2 = unApply.args();
                tree2 = new Trees.UnApply(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(fun), args2.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)their -> this.importTree((Trees.Tree)their), List$.MODULE$.canBuildFrom()));
            } else if (their2 instanceof Trees.ArrayValue) {
                Trees.ArrayValue arrayValue = (Trees.ArrayValue)their2;
                Trees.Tree elemtpt = arrayValue.elemtpt();
                List<Trees.Tree> elems = arrayValue.elems();
                tree2 = new Trees.ArrayValue(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(elemtpt), elems.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)their -> this.importTree((Trees.Tree)their), List$.MODULE$.canBuildFrom()));
            } else if (their2 instanceof Trees.Function) {
                Trees.Function function = (Trees.Function)their2;
                List<Trees.ValDef> vparams = function.vparams();
                Trees.Tree body = function.body();
                tree2 = new Trees.Function(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), vparams.map((Function1<Trees.ValDef, Trees.ValDef> & java.io.Serializable & Serializable)tree -> this.importValDef((Trees.ValDef)tree), List$.MODULE$.canBuildFrom()), this.importTree(body));
            } else if (their2 instanceof Trees.Assign) {
                Trees.Assign assign = (Trees.Assign)their2;
                Trees.Tree lhs = assign.lhs();
                Trees.Tree rhs = assign.rhs();
                tree2 = new Trees.Assign(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(lhs), this.importTree(rhs));
            } else if (their2 instanceof Trees.AssignOrNamedArg) {
                Trees.AssignOrNamedArg assignOrNamedArg = (Trees.AssignOrNamedArg)their2;
                Trees.Tree lhs = assignOrNamedArg.lhs();
                Trees.Tree rhs = assignOrNamedArg.rhs();
                tree2 = new Trees.AssignOrNamedArg(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(lhs), this.importTree(rhs));
            } else if (their2 instanceof Trees.If) {
                Trees.If if_ = (Trees.If)their2;
                Trees.Tree cond = if_.cond();
                Trees.Tree thenp = if_.thenp();
                Trees.Tree elsep = if_.elsep();
                tree2 = new Trees.If(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(cond), this.importTree(thenp), this.importTree(elsep));
            } else if (their2 instanceof Trees.Match) {
                Trees.Match match = (Trees.Match)their2;
                Trees.Tree selector = match.selector();
                List<Trees.CaseDef> cases = match.cases();
                tree2 = new Trees.Match(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(selector), cases.map((Function1<Trees.CaseDef, Trees.CaseDef> & java.io.Serializable & Serializable)tree -> this.importCaseDef((Trees.CaseDef)tree), List$.MODULE$.canBuildFrom()));
            } else if (their2 instanceof Trees.Return) {
                Trees.Tree expr = ((Trees.Return)their2).expr();
                tree2 = new Trees.Return(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(expr));
            } else if (their2 instanceof Trees.Try) {
                Trees.Try try_ = (Trees.Try)their2;
                Trees.Tree block = try_.block();
                List<Trees.CaseDef> catches = try_.catches();
                Trees.Tree finalizer = try_.finalizer();
                tree2 = new Trees.Try(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(block), catches.map((Function1<Trees.CaseDef, Trees.CaseDef> & java.io.Serializable & Serializable)tree -> this.importCaseDef((Trees.CaseDef)tree), List$.MODULE$.canBuildFrom()), this.importTree(finalizer));
            } else if (their2 instanceof Trees.Throw) {
                Trees.Tree expr = ((Trees.Throw)their2).expr();
                tree2 = new Trees.Throw(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(expr));
            } else if (their2 instanceof Trees.New) {
                Trees.Tree tpt = ((Trees.New)their2).tpt();
                tree2 = new Trees.New(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(tpt));
            } else if (their2 instanceof Trees.Typed) {
                Trees.Typed typed = (Trees.Typed)their2;
                Trees.Tree expr = typed.expr();
                Trees.Tree tpt = typed.tpt();
                tree2 = new Trees.Typed(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(expr), this.importTree(tpt));
            } else if (their2 instanceof Trees.TypeApply) {
                Trees.TypeApply typeApply = (Trees.TypeApply)their2;
                Trees.Tree fun = typeApply.fun();
                List<Trees.Tree> args3 = typeApply.args();
                tree2 = new Trees.TypeApply(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(fun), args3.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)their -> this.importTree((Trees.Tree)their), List$.MODULE$.canBuildFrom()));
            } else if (their2 instanceof Trees.Apply) {
                Trees.Apply apply2 = (Trees.Apply)their2;
                Trees.Tree fun = apply2.fun();
                List<Trees.Tree> args4 = apply2.args();
                Trees.Apply apply3 = their2 instanceof Trees.ApplyToImplicitArgs ? new Trees.ApplyToImplicitArgs(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(fun), args4.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)their -> this.importTree((Trees.Tree)their), List$.MODULE$.canBuildFrom())) : (their2 instanceof Trees.ApplyImplicitView ? new Trees.ApplyImplicitView(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(fun), args4.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)their -> this.importTree((Trees.Tree)their), List$.MODULE$.canBuildFrom())) : new Trees.Apply(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(fun), args4.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)their -> this.importTree((Trees.Tree)their), List$.MODULE$.canBuildFrom())));
                tree2 = apply3;
            } else if (their2 instanceof Trees.ApplyDynamic) {
                Trees.ApplyDynamic applyDynamic = (Trees.ApplyDynamic)their2;
                Trees.Tree qual = applyDynamic.qual();
                List<Trees.Tree> args5 = applyDynamic.args();
                tree2 = new Trees.ApplyDynamic(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(qual), args5.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)their -> this.importTree((Trees.Tree)their), List$.MODULE$.canBuildFrom()));
            } else if (their2 instanceof Trees.Super) {
                Trees.Super super_ = (Trees.Super)their2;
                Trees.Tree qual = super_.qual();
                Names.TypeName mix = super_.mix();
                tree2 = new Trees.Super(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(qual), this.importName(mix).toTypeName());
            } else if (their2 instanceof Trees.This) {
                Names.TypeName qual = ((Trees.This)their2).qual();
                tree2 = new Trees.This(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importName(qual).toTypeName());
            } else if (their2 instanceof Trees.Select) {
                Trees.Select select = (Trees.Select)their2;
                Trees.Tree qual = select.qualifier();
                Names.Name name = select.name();
                tree2 = new Trees.Select(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(qual), this.importName(name));
            } else if (their2 instanceof Trees.Ident) {
                Names.Name name = ((Trees.Ident)their2).name();
                tree2 = new Trees.Ident(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importName(name));
            } else if (their2 instanceof Trees.ReferenceToBoxed) {
                Trees.Ident ident = ((Trees.ReferenceToBoxed)their2).ident();
                Trees.Tree tree3 = this.importTree(ident);
                if (!(tree3 instanceof Trees.Ident)) {
                    throw new MatchError(tree3);
                }
                Trees.Ident ident2 = (Trees.Ident)tree3;
                tree2 = new Trees.ReferenceToBoxed(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), ident2);
            } else if (their2 instanceof Trees.Literal && (constant = ((Trees.Literal)their2).value()) != null) {
                tree2 = new Trees.Literal(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importConstant(constant));
            } else if (their2 instanceof Trees.TypeTree) {
                Trees.TypeTree typeTree = (Trees.TypeTree)their2;
                Trees.TypeTree mytt = new Trees.TypeTree(this.scala$reflect$internal$Importers$StandardImporter$$$outer());
                if (typeTree.original() != null) {
                    mytt.setOriginal(this.importTree(typeTree.original()));
                }
                tree2 = mytt;
            } else if (their2 instanceof Trees.Annotated) {
                Trees.Annotated annotated = (Trees.Annotated)their2;
                Trees.Tree annot = annotated.annot();
                Trees.Tree arg = annotated.arg();
                tree2 = new Trees.Annotated(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(annot), this.importTree(arg));
            } else if (their2 instanceof Trees.SingletonTypeTree) {
                Trees.Tree ref = ((Trees.SingletonTypeTree)their2).ref();
                tree2 = new Trees.SingletonTypeTree(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(ref));
            } else if (their2 instanceof Trees.SelectFromTypeTree) {
                Trees.SelectFromTypeTree selectFromTypeTree = (Trees.SelectFromTypeTree)their2;
                Trees.Tree qual = selectFromTypeTree.qualifier();
                Names.TypeName name = selectFromTypeTree.name();
                tree2 = new Trees.SelectFromTypeTree(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(qual), this.importName(name).toTypeName());
            } else if (their2 instanceof Trees.CompoundTypeTree) {
                Trees.Template templ = ((Trees.CompoundTypeTree)their2).templ();
                tree2 = new Trees.CompoundTypeTree(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTemplate(templ));
            } else if (their2 instanceof Trees.AppliedTypeTree) {
                Trees.AppliedTypeTree appliedTypeTree = (Trees.AppliedTypeTree)their2;
                Trees.Tree tpt = appliedTypeTree.tpt();
                List<Trees.Tree> args6 = appliedTypeTree.args();
                tree2 = new Trees.AppliedTypeTree(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(tpt), args6.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)their -> this.importTree((Trees.Tree)their), List$.MODULE$.canBuildFrom()));
            } else if (their2 instanceof Trees.TypeBoundsTree) {
                Trees.TypeBoundsTree typeBoundsTree = (Trees.TypeBoundsTree)their2;
                Trees.Tree lo = typeBoundsTree.lo();
                Trees.Tree hi = typeBoundsTree.hi();
                tree2 = new Trees.TypeBoundsTree(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(lo), this.importTree(hi));
            } else if (their2 instanceof Trees.ExistentialTypeTree) {
                Trees.ExistentialTypeTree existentialTypeTree = (Trees.ExistentialTypeTree)their2;
                Trees.Tree tpt = existentialTypeTree.tpt();
                List<Trees.MemberDef> whereClauses = existentialTypeTree.whereClauses();
                tree2 = new Trees.ExistentialTypeTree(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importTree(tpt), whereClauses.map((Function1<Trees.MemberDef, Trees.MemberDef> & java.io.Serializable & Serializable)tree -> this.importMemberDef((Trees.MemberDef)tree), List$.MODULE$.canBuildFrom()));
            } else if (((Object)this.from().EmptyTree()).equals(their2)) {
                tree2 = this.scala$reflect$internal$Importers$StandardImporter$$$outer().EmptyTree();
            } else if (their2 == null) {
                tree2 = null;
            } else {
                throw new MatchError(their2);
            }
            return tree2;
        }

        /*
         * WARNING - void declaration
         */
        public Trees.Tree importTree(Trees.Tree their) {
            void var2_2;
            Trees.Tree my = this.recreateTree(their);
            if (my != null) {
                this.addFixup((JFunction0$mcV$sp & Serializable)() -> this.recreatedTreeCompleter(their, my));
                this.tryFixup();
                Position position = their.pos();
                NoPosition$ noPosition$ = this.scala$reflect$internal$Importers$StandardImporter$$$outer().NoPosition();
                if (position == null ? noPosition$ != null : !position.equals(noPosition$)) {
                    my.setPos(this.importPosition(their.pos()));
                }
            }
            this.importAttachments(their.attachments().all()).foreach((Function1<Object, Trees.Tree> & java.io.Serializable & Serializable)x$7 -> (Trees.Tree)my.updateAttachment(x$7, ClassTag$.MODULE$.Any()));
            return var2_2;
        }

        public Set<Object> importAttachments(Set<Object> attachments) {
            return attachments.collect(new Serializable(this){
                public static final long serialVersionUID = 0L;
                private final /* synthetic */ StandardImporter $outer;

                public final <A1, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                    Object object = x1 instanceof StdAttachments.ImportableAttachment ? ((StdAttachments.ImportableAttachment)x1).importAttachment(this.$outer) : function1.apply(x1);
                    return object;
                }

                public final boolean isDefinedAt(Object x1) {
                    boolean bl = x1 instanceof StdAttachments.ImportableAttachment;
                    return bl;
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                }
            }, Set$.MODULE$.canBuildFrom());
        }

        public AnnotationInfos.AnnotationInfo importAnnotationInfo(AnnotationInfos.AnnotationInfo ann) {
            Types.Type atp1 = this.importType(ann.atp());
            List<Trees.Tree> args1 = ann.args().map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)their -> this.importTree((Trees.Tree)their), List$.MODULE$.canBuildFrom());
            List<Tuple2<Names.Name, AnnotationInfos.ClassfileAnnotArg>> assocs1 = ann.assocs().map((Function1<Tuple2, Tuple2> & java.io.Serializable & Serializable)x0$1 -> {
                if (x0$1 == null) {
                    throw new MatchError((Object)null);
                }
                Names.Name name = (Names.Name)x0$1._1();
                AnnotationInfos.ClassfileAnnotArg arg = (AnnotationInfos.ClassfileAnnotArg)x0$1._2();
                Tuple2<Names.Name, AnnotationInfos.ClassfileAnnotArg> tuple2 = new Tuple2<Names.Name, AnnotationInfos.ClassfileAnnotArg>(this.importName(name), this.importAnnotArg(arg));
                return tuple2;
            }, List$.MODULE$.canBuildFrom());
            Trees.Tree original1 = this.importTree(ann.original());
            return this.scala$reflect$internal$Importers$StandardImporter$$$outer().AnnotationInfo().apply(atp1, args1, assocs1).setOriginal(original1);
        }

        public AnnotationInfos.ClassfileAnnotArg importAnnotArg(AnnotationInfos.ClassfileAnnotArg arg2) {
            AnnotationInfos.ClassfileAnnotArg classfileAnnotArg;
            Constants.Constant constant;
            if (arg2 instanceof AnnotationInfos.LiteralAnnotArg && (constant = ((AnnotationInfos.LiteralAnnotArg)arg2).const()) != null) {
                classfileAnnotArg = new AnnotationInfos.LiteralAnnotArg(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importConstant(constant));
            } else if (arg2 instanceof AnnotationInfos.ArrayAnnotArg) {
                AnnotationInfos.ClassfileAnnotArg[] args2 = ((AnnotationInfos.ArrayAnnotArg)arg2).args();
                classfileAnnotArg = new AnnotationInfos.ArrayAnnotArg(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), (AnnotationInfos.ClassfileAnnotArg[])TraversableLike.map$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])args2)), (Function1<AnnotationInfos.ClassfileAnnotArg, AnnotationInfos.ClassfileAnnotArg> & java.io.Serializable & Serializable)arg -> this.importAnnotArg((AnnotationInfos.ClassfileAnnotArg)arg), Array$.MODULE$.canBuildFrom(this.scala$reflect$internal$Importers$StandardImporter$$$outer().JavaArgumentTag())));
            } else if (arg2 instanceof AnnotationInfos.ScalaSigBytes) {
                byte[] bytes = ((AnnotationInfos.ScalaSigBytes)arg2).bytes();
                classfileAnnotArg = new AnnotationInfos.ScalaSigBytes(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), bytes);
            } else if (arg2 instanceof AnnotationInfos.NestedAnnotArg) {
                AnnotationInfos.AnnotationInfo annInfo = ((AnnotationInfos.NestedAnnotArg)arg2).annInfo();
                classfileAnnotArg = new AnnotationInfos.NestedAnnotArg(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importAnnotationInfo(annInfo));
            } else if (this.from().UnmappableAnnotArg().equals(arg2)) {
                classfileAnnotArg = this.scala$reflect$internal$Importers$StandardImporter$$$outer().UnmappableAnnotArg();
            } else {
                throw new MatchError(arg2);
            }
            return classfileAnnotArg;
        }

        public Position importPosition(Position their) {
            return their;
        }

        public Scopes.Scope importScope(Scopes.Scope decls) {
            return this.scala$reflect$internal$Importers$StandardImporter$$$outer().newScopeWith(decls.toList().map((Function1<Symbols.Symbol, Symbols.Symbol> & java.io.Serializable & Serializable)their0 -> this.importSymbol((Symbols.Symbol)their0), List$.MODULE$.canBuildFrom()));
        }

        public Names.Name importName(Names.Name name) {
            if (name.isTypeName()) {
                return this.scala$reflect$internal$Importers$StandardImporter$$$outer().newTypeName(name.toString());
            }
            return this.scala$reflect$internal$Importers$StandardImporter$$$outer().newTermName(name.toString());
        }

        public Trees.Modifiers importModifiers(Trees.Modifiers mods) {
            return new Trees.Modifiers(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), mods.flags(), this.importName(mods.privateWithin()), mods.annotations().map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)their -> this.importTree((Trees.Tree)their), List$.MODULE$.canBuildFrom()));
        }

        public Trees.ImportSelector importImportSelector(Trees.ImportSelector sel) {
            return new Trees.ImportSelector(this.scala$reflect$internal$Importers$StandardImporter$$$outer(), this.importName(sel.name()), sel.namePos(), sel.rename() != null ? this.importName(sel.rename()) : null, sel.renamePos());
        }

        public Trees.ValDef importValDef(Trees.ValDef tree) {
            return (Trees.ValDef)this.importTree(tree);
        }

        public Trees.TypeDef importTypeDef(Trees.TypeDef tree) {
            return (Trees.TypeDef)this.importTree(tree);
        }

        public Trees.MemberDef importMemberDef(Trees.MemberDef tree) {
            return (Trees.MemberDef)this.importTree(tree);
        }

        public Trees.Template importTemplate(Trees.Template tree) {
            return (Trees.Template)this.importTree(tree);
        }

        public Trees.RefTree importRefTree(Trees.RefTree tree) {
            return (Trees.RefTree)((Object)this.importTree((Trees.Tree)((Object)tree)));
        }

        public Trees.Ident importIdent(Trees.Ident tree) {
            return (Trees.Ident)this.importTree(tree);
        }

        public Trees.CaseDef importCaseDef(Trees.CaseDef tree) {
            return (Trees.CaseDef)this.importTree(tree);
        }

        public Constants.Constant importConstant(Constants.Constant constant) {
            Object object;
            SymbolTable symbolTable = this.scala$reflect$internal$Importers$StandardImporter$$$outer();
            switch (constant.tag()) {
                case 12: {
                    object = this.importType((Types.Type)constant.value());
                    break;
                }
                case 13: {
                    object = this.importSymbol((Symbols.Symbol)constant.value());
                    break;
                }
                default: {
                    object = constant.value();
                }
            }
            return new Constants.Constant(symbolTable, object);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Importers$StandardImporter$$$outer() {
            return this.$outer;
        }

        private final void reverse$lzycompute$1() {
            synchronized (this) {
                if (this.reverse$module == null) {
                    this.reverse$module = new Importers$StandardImporter$reverse$(this);
                }
                return;
            }
        }

        public static final /* synthetic */ void $anonfun$tryFixup$1(Function0 x$1) {
            x$1.apply$mcV$sp();
        }

        private final Symbols.Symbol linkReferenced$1(Symbols.TermSymbol my, Symbols.TermSymbol their, Function1 op) {
            this.symMap().weakUpdate(their, my);
            my.referenced_$eq((Symbols.Symbol)op.apply(their.referenced()));
            return my;
        }

        private final Symbols.Symbol cachedRecreateSymbol$1(Symbols.Symbol their) {
            Option<Symbols.Symbol> option = this.symMap().weakGet(their);
            Symbols.Symbol symbol = option instanceof Some ? (Symbols.Symbol)((Some)option).value() : this.recreateSymbol(their);
            return symbol;
        }

        public static final /* synthetic */ boolean $anonfun$importSymbol$2(Symbols.Symbol localCopy$1, Symbols.Symbol x$4) {
            return x$4.tpe().matches(localCopy$1.tpe());
        }

        public static final /* synthetic */ boolean $anonfun$importSymbol$3(Symbols.Symbol x$5) {
            return !x$5.isMethod();
        }

        public static final /* synthetic */ String $anonfun$importSymbol$4(Symbols.Symbol result$1, Symbols.Symbol their$2) {
            return new StringBuilder(92).append("import failure: cannot determine unique overloaded method alternative from\n ").append(((TraversableOnce)result$1.alternatives().map((Function1<Symbols.Symbol, String> & java.io.Serializable & Serializable)x$6 -> x$6.defString(), List$.MODULE$.canBuildFrom())).mkString("\n")).append("\n that matches ").append(their$2).append(":").append(their$2.tpe()).toString();
        }

        /*
         * WARNING - void declaration
         */
        private final Symbols.Symbol disambiguate$1(Symbols.Symbol my, Symbols.Symbol their$2) {
            void var3_4;
            void assert_assertion;
            boolean bl;
            Symbols.SymbolApi symbolApi;
            if (their$2.isMethod()) {
                Symbols.Symbol localCopy = this.cachedRecreateSymbol$1(their$2);
                symbolApi = my.filter((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$4 -> BoxesRunTime.boxToBoolean(StandardImporter.$anonfun$importSymbol$2(localCopy, x$4)));
            } else {
                symbolApi = my.filter((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$5 -> BoxesRunTime.boxToBoolean(StandardImporter.$anonfun$importSymbol$3(x$5)));
            }
            Symbols.SymbolApi result2 = symbolApi;
            SymbolTable symbolTable = this.scala$reflect$internal$Importers$StandardImporter$$$outer();
            boolean bl2 = bl = !((Symbols.Symbol)result2).isOverloaded();
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable assert_this = symbolTable;
            if (assert_assertion == false) {
                throw assert_this.throwAssertionError(StandardImporter.$anonfun$importSymbol$4((Symbols.Symbol)result2, their$2));
            }
            return var3_4;
        }

        public static final /* synthetic */ String $anonfun$importSymbol$7(Names.Name myname$1, Types.Type myscope$1, Symbols.Symbol myexisting$1) {
            return new StringBuilder(1).append(Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(myname$1), " ")).append(myscope$1.decl(myname$1)).append(" ").append(myexisting$1).toString();
        }

        /*
         * WARNING - void declaration
         */
        public static final /* synthetic */ Symbols.Symbol $anonfun$importSymbol$6(StandardImporter $this, Symbols.Symbol their$2, Types.Type myscope$1, Names.Name myname$1, Symbols.Symbol myexisting$1) {
            Symbols.Symbol my = $this.cachedRecreateSymbol$1(their$2);
            Types.Type type = myscope$1;
            Types$NoType$ types$NoType$ = $this.scala$reflect$internal$Importers$StandardImporter$$$outer().NoType();
            if (type == null ? types$NoType$ != null : !type.equals(types$NoType$)) {
                void assert_assertion;
                boolean bl;
                SymbolTable symbolTable = $this.scala$reflect$internal$Importers$StandardImporter$$$outer();
                Symbols.Symbol symbol = myscope$1.decls().lookup(myname$1);
                Symbols.NoSymbol noSymbol = $this.scala$reflect$internal$Importers$StandardImporter$$$outer().NoSymbol();
                boolean bl2 = !(symbol != null ? !symbol.equals(noSymbol) : noSymbol != null) ? true : (bl = false);
                if (symbolTable == null) {
                    throw null;
                }
                SymbolTable assert_this = symbolTable;
                if (assert_assertion == false) {
                    throw assert_this.throwAssertionError(StandardImporter.$anonfun$importSymbol$7(myname$1, myscope$1, myexisting$1));
                }
                myscope$1.decls().enter(my);
            }
            return my;
        }

        private final Symbols.Symbol recreateOrRelink$1(Symbols.Symbol their0$1) {
            Symbols.Symbol myexisting;
            Symbols.Symbol symbol;
            Types$NoType$ myscope;
            if (their0$1 == null) {
                return null;
            }
            if (their0$1.equals(this.from().NoSymbol())) {
                return this.scala$reflect$internal$Importers$StandardImporter$$$outer().NoSymbol();
            }
            if (their0$1.isRoot()) {
                return ((Mirrors.RootsBase)this.scala$reflect$internal$Importers$StandardImporter$$$outer().rootMirror()).RootClass();
            }
            boolean isModuleClass = their0$1.isModuleClass();
            boolean isTparam = their0$1.isTypeParameter() && their0$1.paramPos() >= 0;
            boolean isOverloaded = their0$1.isOverloaded();
            Types$NoType$ theirscope = their0$1.owner().isClass() && !their0$1.owner().isRefinementClass() ? their0$1.owner().info() : this.from().NoType();
            if (!(isModuleClass ? theirscope.decl(their0$1.name()).moduleClass() : theirscope.decl(their0$1.name())).exists()) {
                theirscope = this.from().NoType();
            }
            Names.Name myname = this.importName(their0$1.name());
            Symbols.Symbol myowner = this.importSymbol(their0$1.owner());
            Types$NoType$ types$NoType$ = theirscope;
            Types$NoType$ types$NoType$2 = this.from().NoType();
            Types.Type type = (types$NoType$ == null ? types$NoType$2 != null : !types$NoType$.equals(types$NoType$2)) && !myowner.hasFlag(0x8000000000L) ? myowner.info() : (myscope = this.scala$reflect$internal$Importers$StandardImporter$$$outer().NoType());
            if (isModuleClass) {
                symbol = this.importSymbol(their0$1.sourceModule()).moduleClass();
            } else if (isTparam) {
                symbol = myowner.hasFlag(0x8000000000L) ? this.scala$reflect$internal$Importers$StandardImporter$$$outer().NoSymbol() : myowner.typeParams().apply(their0$1.paramPos());
            } else if (isOverloaded) {
                symbol = myowner.newOverloaded(myowner.thisType(), their0$1.alternatives().map((Function1<Symbols.Symbol, Symbols.Symbol> & java.io.Serializable & Serializable)their0 -> this.importSymbol((Symbols.Symbol)their0), List$.MODULE$.canBuildFrom()));
            } else {
                Types$NoType$ types$NoType$3 = myscope;
                Types$NoType$ types$NoType$4 = this.scala$reflect$internal$Importers$StandardImporter$$$outer().NoType();
                Symbols.Symbol myexisting2 = (types$NoType$3 == null ? types$NoType$4 != null : !types$NoType$3.equals(types$NoType$4)) ? myscope.decl(myname) : this.scala$reflect$internal$Importers$StandardImporter$$$outer().NoSymbol();
                symbol = myexisting = myexisting2.isOverloaded() ? this.disambiguate$1(myexisting2, their0$1) : myexisting2;
            }
            if (myexisting == null) {
                throw null;
            }
            if (myexisting != myexisting.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                return myexisting;
            }
            return StandardImporter.$anonfun$importSymbol$6(this, their0$1, myscope, myname, myexisting);
        }

        public StandardImporter(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            this.pendingSyms = 0;
            this.pendingTpes = 0;
        }

        public static final /* synthetic */ Object $anonfun$tryFixup$1$adapted(Function0 x$1) {
            x$1.apply$mcV$sp();
            return BoxedUnit.UNIT;
        }

        public class Cache<K, V>
        extends WeakHashMap<K, WeakReference<V>> {
            public Option<V> weakGet(K key) {
                Option option = this.get(key);
                if (option == null) {
                    throw null;
                }
                Option flatMap_this = option;
                Option option2 = flatMap_this.isEmpty() ? None$.MODULE$ : WeakReference$.MODULE$.unapply((WeakReference)flatMap_this.get());
                return option2;
            }

            public void weakUpdate(K key, V value) {
                this.update(key, WeakReference$.MODULE$.apply(value));
            }

            public /* synthetic */ StandardImporter scala$reflect$internal$Importers$StandardImporter$Cache$$$outer() {
                return StandardImporter.this;
            }

            public Cache() {
                if (StandardImporter.this == null) {
                    throw null;
                }
            }
        }
    }
}

