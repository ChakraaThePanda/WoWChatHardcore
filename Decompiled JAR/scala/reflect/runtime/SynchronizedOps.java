/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.runtime;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function0;
import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.collection.IndexedSeqOptimized;
import scala.collection.Iterator;
import scala.collection.immutable.List;
import scala.collection.mutable.ArrayOps;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.BaseTypeSeqs;
import scala.reflect.internal.Depth;
import scala.reflect.internal.Names;
import scala.reflect.internal.Scopes;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Types;
import scala.reflect.runtime.Gil;
import scala.reflect.runtime.SymbolTable;
import scala.reflect.runtime.SynchronizedSymbols;
import scala.reflect.runtime.SynchronizedTypes;
import scala.runtime.BoxesRunTime;
import scala.runtime.LambdaDeserialize;
import scala.runtime.java8.JFunction0$mcI$sp;
import scala.runtime.java8.JFunction0$mcV$sp;
import scala.runtime.java8.JFunction0$mcZ$sp;

@ScalaSignature(bytes="\u0006\u0001\t\rfA\u0003\u001a4!\u0003\r\t!N\u001d\u0003 \")q\t\u0001C\u0001\u0013\")a\n\u0001C)\u001f\")1\u000b\u0001C))\")a\u000e\u0001C)_\u001a9q\u000f\u0001I\u0001\u0004\u0003A\b\"B$\u0006\t\u0003I\u0005\"B=\u0006\t\u0003R\bbBA\u0001\u000b\u0011\u0005\u00131\u0001\u0005\b\u0003\u000f)A\u0011IA\u0005\u0011\u001d\t9\"\u0002C!\u00033Aq!a\u0007\u0006\t\u0003\ni\u0002C\u0004\u0002(\u0015!\t%!\u000b\t\u000f\u0005UR\u0001\"\u0011\u00028!Q\u0011qH\u0003\t\u0006\u0004%\t%!\u0011\t\u000f\u0005%S\u0001\"\u0011\u0002L!q\u00111M\u0003\u0011\u0002\u0007\u0005\t\u0011\"\u0003\u0002f\u0005%\u0004BDA6\u000bA\u0005\u0019\u0011!A\u0005\n\u00055\u0014\u0011\u000f\u0005\u000f\u0003g*\u0001\u0013aA\u0001\u0002\u0013%\u0011QOA=\u00119\tY(\u0002I\u0001\u0004\u0003\u0005I\u0011BA\r\u0003{Ba\"a \u0006!\u0003\r\t\u0011!C\u0005\u0003\u0003\u000b9\t\u0003\b\u0002\n\u0016\u0001\n1!A\u0001\n\u0013\tY)a$\t\u001d\u0005EU\u0001%A\u0002\u0002\u0003%I!a%\u0002\u0018\"q\u0011\u0011T\u0003\u0011\u0002\u0007\u0005\t\u0011\"\u0003\u0002B\u0005m\u0005BDAP\u000bA\u0005\u0019\u0011!A\u0005\n\u0005-\u0013\u0011\u0015\u0005\b\u0003S\u0003A\u0011IAV\r%\ti\f\u0001I\u0001\u0004\u0003\ty\fC\u0003H5\u0011\u0005\u0011\n\u0003\u0006\u0002BjA)\u0019!C\u0005\u0003\u0007Dq!!6\u001b\t\u0003\t9\u000e\u0003\u0004\u0002|j!\te\u0014\u0005\b\u0003{TB\u0011IA\u0000\u0011\u001d\u0011\tA\u0007C!\u0005\u0007AqA!\u0005\u001b\t\u0003\u0012\u0019\u0002C\u0004\u0003&i!\tEa\n\t\u000f\t\u0015\"\u0004\"\u0011\u00034!9!q\u0007\u000e\u0005B\te\u0002b\u0002B#5\u0011\u0005#q\t\u0005\b\u0005\u0017RB\u0011\tB'\u0011\u001d\t9B\u0007C!\u0005'BQBa\u0016\u001b!\u0003\r\t\u0011!C\u0005\u001f\ne\u0003B\u0004B.5A\u0005\u0019\u0011!A\u0005\n\u0005}(Q\f\u0005\u000f\u0005?R\u0002\u0013aA\u0001\u0002\u0013%!\u0011\rB6\u00119\u0011iG\u0007I\u0001\u0004\u0003\u0005I\u0011\u0002B8\u0005kBaBa\u001e\u001b!\u0003\r\t\u0011!C\u0005\u0005s\u0012i\b\u0003\b\u0003xi\u0001\n1!A\u0001\n\u0013\u0011yHa!\t\u001d\t\u0015%\u0004%A\u0002\u0002\u0003%IAa\"\u0003\f\"q!Q\u0012\u000e\u0011\u0002\u0007\u0005\t\u0011\"\u0003\u0003\u0010\nM\u0005B\u0004BK5A\u0005\u0019\u0011!A\u0005\n\t]%1\u0014\u0005\u000f\u0003wR\u0002\u0013aA\u0001\u0002\u0013%!1\u000bBO\u0005=\u0019\u0016P\\2ie>t\u0017N_3e\u001fB\u001c(B\u0001\u001b6\u0003\u001d\u0011XO\u001c;j[\u0016T!AN\u001c\u0002\u000fI,g\r\\3di*\t\u0001(A\u0003tG\u0006d\u0017m\u0005\u0003\u0001u\u0001#\u0005CA\u001e?\u001b\u0005a$BA\u001f6\u0003!Ig\u000e^3s]\u0006d\u0017BA =\u0005-\u0019\u00160\u001c2pYR\u000b'\r\\3\u0011\u0005\u0005\u0013U\"A\u001a\n\u0005\r\u001b$aE*z]\u000eD'o\u001c8ju\u0016$7+_7c_2\u001c\bCA!F\u0013\t15GA\tTs:\u001c\u0007N]8oSj,G\rV=qKN\fa\u0001J5oSR$3\u0001\u0001\u000b\u0002\u0015B\u00111\nT\u0007\u0002o%\u0011Qj\u000e\u0002\u0005+:LG/\u0001\tts:\u001c\u0007N]8oSj,g*Y7fgV\t\u0001\u000b\u0005\u0002L#&\u0011!k\u000e\u0002\b\u0005>|G.Z1o\u00039qWm\u001e\"bg\u0016$\u0016\u0010]3TKF$2!V.j!\t1v+D\u0001\u0001\u0013\tA\u0016LA\u0006CCN,G+\u001f9f'\u0016\f\u0018B\u0001.=\u00051\u0011\u0015m]3UsB,7+Z9t\u0011\u0015a6\u00011\u0001^\u0003\u001d\u0001\u0018M]3oiN\u00042AX1e\u001d\tYu,\u0003\u0002ao\u00059\u0001/Y2lC\u001e,\u0017B\u00012d\u0005\u0011a\u0015n\u001d;\u000b\u0005\u0001<\u0004C\u0001,f\u0013\t1wM\u0001\u0003UsB,\u0017B\u00015=\u0005\u0015!\u0016\u0010]3t\u0011\u0015Q7\u00011\u0001l\u0003\u0015)G.Z7t!\rYE\u000eZ\u0005\u0003[^\u0012Q!\u0011:sCf\fAC\\3x\u001b\u0006\u0004\b/\u001a3CCN,G+\u001f9f'\u0016\fH#\u00029\u0002$\u0006\u001d&cA9tm\u001a!!\u000f\u0002\u0001q\u00051a$/\u001a4j]\u0016lWM\u001c;?!\t1F/\u0003\u0002v3\n\tR*\u00199qK\u0012\u0014\u0015m]3UsB,7+Z9\u0011\u0005Y+!aF*z]\u000eD'o\u001c8ju\u0016$')Y:f)f\u0004XmU3r'\t)Q+A\u0003baBd\u0017\u0010\u0006\u0002ew\")Ap\u0002a\u0001{\u0006\t\u0011\u000e\u0005\u0002L}&\u0011qp\u000e\u0002\u0004\u0013:$\u0018a\u0002:bo\u0016cW-\u001c\u000b\u0004I\u0006\u0015\u0001\"\u0002?\t\u0001\u0004i\u0018A\u0003;za\u0016\u001c\u00160\u001c2pYR!\u00111BA\u000b!\r1\u0016QB\u0005\u0005\u0003\u001f\t\tB\u0001\u0004Ts6\u0014w\u000e\\\u0005\u0004\u0003'a$aB*z[\n|Gn\u001d\u0005\u0006y&\u0001\r!`\u0001\u0007i>d\u0015n\u001d;\u0016\u0003u\u000bAaY8qsR)Q+a\b\u0002$!1\u0011\u0011E\u0006A\u0002\u0011\fA\u0001[3bI\"1\u0011QE\u0006A\u0002u\faa\u001c4gg\u0016$\u0018aA7baR\u0019Q+a\u000b\t\u000f\u00055B\u00021\u0001\u00020\u0005\ta\rE\u0003L\u0003c!G-C\u0002\u00024]\u0012\u0011BR;oGRLwN\\\u0019\u0002\r\u0015D\u0018n\u001d;t)\r\u0001\u0016\u0011\b\u0005\b\u0003wi\u0001\u0019AA\u001f\u0003\u0005\u0001\b#B&\u00022\u0011\u0004\u0016\u0001C7bq\u0012+\u0007\u000f\u001e5\u0016\u0005\u0005\r\u0003cA\u001e\u0002F%\u0019\u0011q\t\u001f\u0003\u000b\u0011+\u0007\u000f\u001e5\u0002\u0011Q|7\u000b\u001e:j]\u001e$\"!!\u0014\u0011\t\u0005=\u0013Q\f\b\u0005\u0003#\nI\u0006E\u0002\u0002T]j!!!\u0016\u000b\u0007\u0005]\u0003*\u0001\u0004=e>|GOP\u0005\u0004\u00037:\u0014A\u0002)sK\u0012,g-\u0003\u0003\u0002`\u0005\u0005$AB*ue&twMC\u0002\u0002\\]\n1b];qKJ$\u0013\r\u001d9msR\u0019A-a\u001a\t\u000bq\u0004\u0002\u0019A?\n\u0005e<\u0016!D:va\u0016\u0014HE]1x\u000b2,W\u000eF\u0002e\u0003_BQ\u0001`\tA\u0002uL1!!\u0001X\u0003A\u0019X\u000f]3sIQL\b/Z*z[\n|G\u000e\u0006\u0003\u0002\f\u0005]\u0004\"\u0002?\u0013\u0001\u0004i\u0018bAA\u0004/\u0006a1/\u001e9fe\u0012\"x\u000eT5ti&\u0019\u0011qC,\u0002\u0015M,\b/\u001a:%G>\u0004\u0018\u0010F\u0003V\u0003\u0007\u000b)\t\u0003\u0004\u0002\"Q\u0001\r\u0001\u001a\u0005\u0007\u0003K!\u0002\u0019A?\n\u0007\u0005mq+A\u0005tkB,'\u000fJ7baR\u0019Q+!$\t\u000f\u00055R\u00031\u0001\u00020%\u0019\u0011qE,\u0002\u0019M,\b/\u001a:%KbL7\u000f^:\u0015\u0007A\u000b)\nC\u0004\u0002<Y\u0001\r!!\u0010\n\u0007\u0005Ur+A\u000btkB,'\u000fJ7bq\u0012+\u0007\u000f\u001e5PM\u0016cW-\\:\n\u0007\u0005uu+A\bnCb$U\r\u001d;i\u001f\u001a,E.Z7t\u00039\u0019X\u000f]3sIQ|7\u000b\u001e:j]\u001eL1!!\u0013X\u0011\u0019\t)\u000b\u0002a\u0001+\u0006!qN]5h\u0011\u001d\ti\u0003\u0002a\u0001\u0003_\t\u0001B\\3x'\u000e|\u0007/Z\u000b\u0003\u0003[\u0013b!a,\u00022\u0006mf!\u0002:\u001a\u0001\u00055\u0006c\u0001,\u00024&!\u0011QWA\\\u0005\u0015\u00196m\u001c9f\u0013\r\tI\f\u0010\u0002\u0007'\u000e|\u0007/Z:\u0011\u0005YS\"!E*z]\u000eD'o\u001c8ju\u0016$7kY8qKN\u0019!$!-\u0002\u0011MLhn\u0019'pG.,\"!!2\u0011\t\u0005\u001d\u0017\u0011[\u0007\u0003\u0003\u0013TA!a3\u0002N\u0006!A.\u00198h\u0015\t\ty-\u0001\u0003kCZ\f\u0017\u0002BAj\u0003\u0013\u0014aa\u00142kK\u000e$\u0018\u0001F:z]\u000edunY6Ts:\u001c\u0007N]8oSj,G-\u0006\u0003\u0002Z\u0006}G\u0003BAn\u0003c\u0004B!!8\u0002`2\u0001AaBAq;\t\u0007\u00111\u001d\u0002\u0002)F!\u0011Q]Av!\rY\u0015q]\u0005\u0004\u0003S<$a\u0002(pi\"Lgn\u001a\t\u0004\u0017\u00065\u0018bAAxo\t\u0019\u0011I\\=\t\u0011\u0005MX\u0004\"a\u0001\u0003k\fAAY8esB)1*a>\u0002\\&\u0019\u0011\u0011`\u001c\u0003\u0011q\u0012\u0017P\\1nKz\nq![:F[B$\u00180\u0001\u0003tSj,W#A?\u0002\u000b\u0015tG/\u001a:\u0016\t\t\u0015!\u0011\u0002\u000b\u0005\u0005\u000f\u0011i\u0001\u0005\u0003\u0002^\n%AaBAqA\t\u0007!1B\t\u0005\u0003K\fY\u0001C\u0004\u0003\u0010\u0001\u0002\rAa\u0002\u0002\u0007MLX.\u0001\u0004sK\"\f7\u000f\u001b\u000b\u0006\u0015\nU!q\u0003\u0005\b\u0005\u001f\t\u0003\u0019AA\u0006\u0011\u001d\u0011I\"\ta\u0001\u00057\tqA\\3x]\u0006lW\rE\u0002W\u0005;IAAa\b\u0003\"\t!a*Y7f\u0013\r\u0011\u0019\u0003\u0010\u0002\u0006\u001d\u0006lWm]\u0001\u0007k:d\u0017N\\6\u0015\u0007)\u0013I\u0003C\u0004\u0003,\t\u0002\rA!\f\u0002\u0003\u0015\u00042A\u0016B\u0018\u0013\u0011\u0011\t$a.\u0003\u0015M\u001bw\u000e]3F]R\u0014\u0018\u0010F\u0002K\u0005kAqAa\u0004$\u0001\u0004\tY!A\u0005m_>\\W\u000f]!mYR!!1\bB!!\u0015q&QHA\u0006\u0013\r\u0011yd\u0019\u0002\t\u0013R,'/\u0019;pe\"9!1\t\u0013A\u0002\tm\u0011\u0001\u00028b[\u0016\f1\u0002\\8pWV\u0004XI\u001c;ssR!!Q\u0006B%\u0011\u001d\u0011\u0019%\na\u0001\u00057\tq\u0002\\8pWV\u0004h*\u001a=u\u000b:$(/\u001f\u000b\u0005\u0005[\u0011y\u0005C\u0004\u0003R\u0019\u0002\rA!\f\u0002\u000b\u0015tGO]=\u0016\u0005\tU\u0003\u0003\u00020b\u0003\u0017\tQb];qKJ$\u0013n]#naRL\u0018\u0002BA~\u0003g\u000b!b];qKJ$3/\u001b>f\u0013\u0011\ti0a-\u0002\u0017M,\b/\u001a:%K:$XM]\u000b\u0005\u0005G\u00129\u0007\u0006\u0003\u0003f\t%\u0004\u0003BAo\u0005O\"q!!9+\u0005\u0004\u0011Y\u0001C\u0004\u0003\u0010)\u0002\rA!\u001a\n\t\t\u0005\u00111W\u0001\rgV\u0004XM\u001d\u0013sK\"\f7\u000f\u001b\u000b\u0006\u0015\nE$1\u000f\u0005\b\u0005\u001fY\u0003\u0019AA\u0006\u0011\u001d\u0011Ib\u000ba\u0001\u00057IAA!\u0005\u00024\u0006a1/\u001e9fe\u0012*h\u000e\\5oWR\u0019!Ja\u001f\t\u000f\t-B\u00061\u0001\u0003.%!!QEAZ)\rQ%\u0011\u0011\u0005\b\u0005\u001fi\u0003\u0019AA\u0006\u0013\u0011\u0011)#a-\u0002\u001fM,\b/\u001a:%Y>|7.\u001e9BY2$BAa\u000f\u0003\n\"9!1\t\u0018A\u0002\tm\u0011\u0002\u0002B\u001c\u0003g\u000b\u0011c];qKJ$Cn\\8lkB,e\u000e\u001e:z)\u0011\u0011iC!%\t\u000f\t\rs\u00061\u0001\u0003\u001c%!!QIAZ\u0003U\u0019X\u000f]3sI1|wn[;q\u001d\u0016DH/\u00128uef$BA!\f\u0003\u001a\"9!\u0011\u000b\u0019A\u0002\t5\u0012\u0002\u0002B&\u0003gKA!a\u0006\u00024B\u0019\u0011I!)\n\u0005}\u001a\u0004")
public interface SynchronizedOps
extends SynchronizedSymbols,
SynchronizedTypes {
    public static /* synthetic */ boolean synchronizeNames$(SynchronizedOps $this) {
        return $this.synchronizeNames();
    }

    default public boolean synchronizeNames() {
        return true;
    }

    public static /* synthetic */ BaseTypeSeqs.BaseTypeSeq newBaseTypeSeq$(SynchronizedOps $this, List parents, Types.Type[] elems) {
        return $this.newBaseTypeSeq(parents, elems);
    }

    default public BaseTypeSeqs.BaseTypeSeq newBaseTypeSeq(List<Types.Type> parents, Types.Type[] elems) {
        if (IndexedSeqOptimized.exists$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])elems)), (Function1<Types.Type, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(SynchronizedOps.$anonfun$newBaseTypeSeq$1(x$1)))) {
            return new SynchronizedBaseTypeSeq((SymbolTable)this, parents, elems){
                private int maxDepth;
                private volatile boolean bitmap$0;
                private final /* synthetic */ SymbolTable $outer;

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$apply(int i) {
                    return super.apply(i);
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$rawElem(int i) {
                    return super.rawElem(i);
                }

                public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$typeSymbol(int i) {
                    return super.typeSymbol(i);
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$toList() {
                    return super.toList();
                }

                public /* synthetic */ BaseTypeSeqs.BaseTypeSeq scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$copy(Types.Type head, int offset) {
                    return super.copy(head, offset);
                }

                public /* synthetic */ BaseTypeSeqs.BaseTypeSeq scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$map(Function1 f) {
                    int map_len = this.length();
                    Types.Type[] map_arr = new Types.Type[map_len];
                    for (int map_i = 0; map_i < map_len; ++map_i) {
                        map_arr[map_i] = (Types.Type)f.apply(this.scala$reflect$internal$BaseTypeSeqs$$elems()[map_i]);
                    }
                    return this.scala$reflect$internal$BaseTypeSeqs$BaseTypeSeq$$$outer().newBaseTypeSeq(this.scala$reflect$internal$BaseTypeSeqs$$parents(), map_arr);
                }

                public /* synthetic */ boolean scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$exists(Function1 p) {
                    return IndexedSeqOptimized.exists$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$reflect$internal$BaseTypeSeqs$$elems())), p);
                }

                public /* synthetic */ int scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$maxDepthOfElems() {
                    return super.maxDepthOfElems();
                }

                public /* synthetic */ String scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$toString() {
                    return super.toString();
                }

                public Types.Type apply(int i) {
                    return SynchronizedBaseTypeSeq.apply$(this, i);
                }

                public Types.Type rawElem(int i) {
                    return SynchronizedBaseTypeSeq.rawElem$(this, i);
                }

                public Symbols.Symbol typeSymbol(int i) {
                    return SynchronizedBaseTypeSeq.typeSymbol$(this, i);
                }

                public List<Types.Type> toList() {
                    return SynchronizedBaseTypeSeq.toList$(this);
                }

                public BaseTypeSeqs.BaseTypeSeq copy(Types.Type head, int offset) {
                    return SynchronizedBaseTypeSeq.copy$(this, head, offset);
                }

                public BaseTypeSeqs.BaseTypeSeq map(Function1<Types.Type, Types.Type> f) {
                    return SynchronizedBaseTypeSeq.map$(this, f);
                }

                public boolean exists(Function1<Types.Type, Object> p) {
                    return SynchronizedBaseTypeSeq.exists$(this, p);
                }

                public String toString() {
                    return SynchronizedBaseTypeSeq.toString$(this);
                }

                private int maxDepth$lzycompute() {
                    synchronized (this) {
                        if (!this.bitmap$0) {
                            this.maxDepth = SynchronizedBaseTypeSeq.maxDepth$(this);
                            this.bitmap$0 = true;
                        }
                    }
                    return this.maxDepth;
                }

                public int maxDepth() {
                    if (!this.bitmap$0) {
                        return this.maxDepth$lzycompute();
                    }
                    return this.maxDepth;
                }

                public /* synthetic */ SynchronizedOps scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$$outer() {
                    return this.$outer;
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    super((scala.reflect.internal.SymbolTable)((Object)$outer), parents$1, elems$1);
                    SynchronizedBaseTypeSeq.$init$(this);
                }
            };
        }
        return new BaseTypeSeqs.BaseTypeSeq((scala.reflect.internal.SymbolTable)((Object)this), parents, elems);
    }

    public static /* synthetic */ BaseTypeSeqs.MappedBaseTypeSeq newMappedBaseTypeSeq$(SynchronizedOps $this, BaseTypeSeqs.BaseTypeSeq orig, Function1 f) {
        return $this.newMappedBaseTypeSeq(orig, f);
    }

    default public BaseTypeSeqs.MappedBaseTypeSeq newMappedBaseTypeSeq(BaseTypeSeqs.BaseTypeSeq orig, Function1<Types.Type, Types.Type> f) {
        return new SynchronizedBaseTypeSeq((SymbolTable)this, orig, f){
            private int maxDepth;
            private volatile boolean bitmap$0;
            private final /* synthetic */ SymbolTable $outer;

            public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$apply(int i) {
                return super.apply(i);
            }

            public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$rawElem(int i) {
                return super.rawElem(i);
            }

            public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$typeSymbol(int i) {
                return super.typeSymbol(i);
            }

            public /* synthetic */ List scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$toList() {
                return super.toList();
            }

            public /* synthetic */ BaseTypeSeqs.BaseTypeSeq scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$copy(Types.Type head, int offset) {
                return super.copy(head, offset);
            }

            public /* synthetic */ BaseTypeSeqs.BaseTypeSeq scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$map(Function1 f) {
                return this.lateMap(f);
            }

            public /* synthetic */ boolean scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$exists(Function1 p) {
                return IndexedSeqOptimized.exists$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$reflect$internal$BaseTypeSeqs$$elems())), arg_0 -> BaseTypeSeqs.MappedBaseTypeSeq.$anonfun$exists$1$adapted(this, p, arg_0));
            }

            public /* synthetic */ int scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$maxDepthOfElems() {
                return super.maxDepthOfElems();
            }

            public /* synthetic */ String scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$toString() {
                return super.toString();
            }

            public Types.Type apply(int i) {
                return SynchronizedBaseTypeSeq.apply$(this, i);
            }

            public Types.Type rawElem(int i) {
                return SynchronizedBaseTypeSeq.rawElem$(this, i);
            }

            public Symbols.Symbol typeSymbol(int i) {
                return SynchronizedBaseTypeSeq.typeSymbol$(this, i);
            }

            public List<Types.Type> toList() {
                return SynchronizedBaseTypeSeq.toList$(this);
            }

            public BaseTypeSeqs.BaseTypeSeq copy(Types.Type head, int offset) {
                return SynchronizedBaseTypeSeq.copy$(this, head, offset);
            }

            public BaseTypeSeqs.BaseTypeSeq map(Function1<Types.Type, Types.Type> f) {
                return SynchronizedBaseTypeSeq.map$(this, f);
            }

            public boolean exists(Function1<Types.Type, Object> p) {
                return SynchronizedBaseTypeSeq.exists$(this, p);
            }

            public String toString() {
                return SynchronizedBaseTypeSeq.toString$(this);
            }

            private int maxDepth$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.maxDepth = SynchronizedBaseTypeSeq.maxDepth$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.maxDepth;
            }

            public int maxDepth() {
                if (!this.bitmap$0) {
                    return this.maxDepth$lzycompute();
                }
                return this.maxDepth;
            }

            public /* synthetic */ SynchronizedOps scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                super((scala.reflect.internal.SymbolTable)((Object)$outer), orig$1, f$1);
                SynchronizedBaseTypeSeq.$init$(this);
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$exists$1$adapted(scala.reflect.internal.BaseTypeSeqs$MappedBaseTypeSeq scala.Function1 scala.reflect.internal.Types$Type )}, serializedLambda);
            }
        };
    }

    public static /* synthetic */ SynchronizedScope newScope$(SynchronizedOps $this) {
        return $this.newScope();
    }

    default public SynchronizedScope newScope() {
        return new SynchronizedScope((SymbolTable)this){
            private Object scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$syncLock;
            private volatile boolean bitmap$0;
            private final /* synthetic */ SymbolTable $outer;

            public /* synthetic */ boolean scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$isEmpty() {
                return super.isEmpty();
            }

            public /* synthetic */ int scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$size() {
                return super.size();
            }

            public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$enter(Symbols.Symbol sym) {
                return super.enter(sym);
            }

            public /* synthetic */ void scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$rehash(Symbols.Symbol sym, Names.Name newname) {
                super.rehash(sym, newname);
            }

            public /* synthetic */ void scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$unlink(Scopes.ScopeEntry e) {
                super.unlink(e);
            }

            public /* synthetic */ void scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$unlink(Symbols.Symbol sym) {
                super.unlink(sym);
            }

            public /* synthetic */ Iterator scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$lookupAll(Names.Name name) {
                return super.lookupAll(name);
            }

            public /* synthetic */ Scopes.ScopeEntry scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$lookupEntry(Names.Name name) {
                return super.lookupEntry(name);
            }

            public /* synthetic */ Scopes.ScopeEntry scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$lookupNextEntry(Scopes.ScopeEntry entry) {
                return super.lookupNextEntry(entry);
            }

            public /* synthetic */ List scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$toList() {
                return super.toList();
            }

            public <T> T syncLockSynchronized(Function0<T> body) {
                return (T)SynchronizedScope.syncLockSynchronized$(this, body);
            }

            public boolean isEmpty() {
                return SynchronizedScope.isEmpty$(this);
            }

            public int size() {
                return SynchronizedScope.size$(this);
            }

            public <T extends Symbols.Symbol> T enter(T sym) {
                return (T)SynchronizedScope.enter$(this, sym);
            }

            public void rehash(Symbols.Symbol sym, Names.Name newname) {
                SynchronizedScope.rehash$(this, sym, newname);
            }

            public void unlink(Scopes.ScopeEntry e) {
                SynchronizedScope.unlink$((SynchronizedScope)this, e);
            }

            public void unlink(Symbols.Symbol sym) {
                SynchronizedScope.unlink$((SynchronizedScope)this, sym);
            }

            public Iterator<Symbols.Symbol> lookupAll(Names.Name name) {
                return SynchronizedScope.lookupAll$(this, name);
            }

            public Scopes.ScopeEntry lookupEntry(Names.Name name) {
                return SynchronizedScope.lookupEntry$(this, name);
            }

            public Scopes.ScopeEntry lookupNextEntry(Scopes.ScopeEntry entry) {
                return SynchronizedScope.lookupNextEntry$(this, entry);
            }

            public List<Symbols.Symbol> toList() {
                return SynchronizedScope.toList$(this);
            }

            private Object scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$syncLock$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$syncLock = SynchronizedScope.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$syncLock$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$syncLock;
            }

            public Object scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$syncLock() {
                if (!this.bitmap$0) {
                    return this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$syncLock$lzycompute();
                }
                return this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$syncLock;
            }

            public /* synthetic */ SynchronizedOps scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                super((scala.reflect.internal.SymbolTable)((Object)$outer));
                SynchronizedScope.$init$(this);
            }
        };
    }

    public static /* synthetic */ boolean $anonfun$newBaseTypeSeq$1(Types.Type x$1) {
        return x$1 instanceof Types.RefinedType;
    }

    public static void $init$(SynchronizedOps $this) {
    }

    public interface SynchronizedBaseTypeSeq {
        public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$apply(int var1);

        public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$rawElem(int var1);

        public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$typeSymbol(int var1);

        public /* synthetic */ List scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$toList();

        public /* synthetic */ BaseTypeSeqs.BaseTypeSeq scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$copy(Types.Type var1, int var2);

        public /* synthetic */ BaseTypeSeqs.BaseTypeSeq scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$map(Function1 var1);

        public /* synthetic */ boolean scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$exists(Function1 var1);

        public /* synthetic */ int scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$maxDepthOfElems();

        public /* synthetic */ String scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$toString();

        public static /* synthetic */ Types.Type apply$(SynchronizedBaseTypeSeq $this, int i) {
            return $this.apply(i);
        }

        default public Types.Type apply(int i) {
            Types.Type type;
            Gil gil = (Gil)((Object)this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$$outer());
            if (gil == null) {
                throw null;
            }
            Gil gilSynchronized_this = gil;
            if (((SymbolTable)gilSynchronized_this).isCompilerUniverse()) {
                return this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$apply(i);
            }
            try {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                type = this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$apply(i);
            }
            finally {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return type;
        }

        public static /* synthetic */ Types.Type rawElem$(SynchronizedBaseTypeSeq $this, int i) {
            return $this.rawElem(i);
        }

        default public Types.Type rawElem(int i) {
            Types.Type type;
            Gil gil = (Gil)((Object)this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$$outer());
            if (gil == null) {
                throw null;
            }
            Gil gilSynchronized_this = gil;
            if (((SymbolTable)gilSynchronized_this).isCompilerUniverse()) {
                return this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$rawElem(i);
            }
            try {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                type = this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$rawElem(i);
            }
            finally {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return type;
        }

        public static /* synthetic */ Symbols.Symbol typeSymbol$(SynchronizedBaseTypeSeq $this, int i) {
            return $this.typeSymbol(i);
        }

        default public Symbols.Symbol typeSymbol(int i) {
            Symbols.Symbol symbol;
            Gil gil = (Gil)((Object)this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$$outer());
            if (gil == null) {
                throw null;
            }
            Gil gilSynchronized_this = gil;
            if (((SymbolTable)gilSynchronized_this).isCompilerUniverse()) {
                return this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$typeSymbol(i);
            }
            try {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                symbol = this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$typeSymbol(i);
            }
            finally {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return symbol;
        }

        public static /* synthetic */ List toList$(SynchronizedBaseTypeSeq $this) {
            return $this.toList();
        }

        default public List<Types.Type> toList() {
            List list;
            Gil gil = (Gil)((Object)this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$$outer());
            if (gil == null) {
                throw null;
            }
            Gil gilSynchronized_this = gil;
            if (((SymbolTable)gilSynchronized_this).isCompilerUniverse()) {
                return this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$toList();
            }
            try {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                list = this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$toList();
            }
            finally {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return list;
        }

        public static /* synthetic */ BaseTypeSeqs.BaseTypeSeq copy$(SynchronizedBaseTypeSeq $this, Types.Type head, int offset) {
            return $this.copy(head, offset);
        }

        default public BaseTypeSeqs.BaseTypeSeq copy(Types.Type head, int offset) {
            BaseTypeSeqs.BaseTypeSeq baseTypeSeq;
            Gil gil = (Gil)((Object)this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$$outer());
            if (gil == null) {
                throw null;
            }
            Gil gilSynchronized_this = gil;
            if (((SymbolTable)gilSynchronized_this).isCompilerUniverse()) {
                return this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$copy(head, offset);
            }
            try {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                baseTypeSeq = this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$copy(head, offset);
            }
            finally {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return baseTypeSeq;
        }

        public static /* synthetic */ BaseTypeSeqs.BaseTypeSeq map$(SynchronizedBaseTypeSeq $this, Function1 f) {
            return $this.map(f);
        }

        default public BaseTypeSeqs.BaseTypeSeq map(Function1<Types.Type, Types.Type> f) {
            BaseTypeSeqs.BaseTypeSeq baseTypeSeq;
            Gil gil = (Gil)((Object)this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$$outer());
            if (gil == null) {
                throw null;
            }
            Gil gilSynchronized_this = gil;
            if (((SymbolTable)gilSynchronized_this).isCompilerUniverse()) {
                return this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$map(f);
            }
            try {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                baseTypeSeq = this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$map(f);
            }
            finally {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return baseTypeSeq;
        }

        public static /* synthetic */ boolean exists$(SynchronizedBaseTypeSeq $this, Function1 p) {
            return $this.exists(p);
        }

        default public boolean exists(Function1<Types.Type, Object> p) {
            boolean bl;
            Gil gil = (Gil)((Object)this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$$outer());
            if (gil == null) {
                throw null;
            }
            Gil gilSynchronized_this = gil;
            if (((SymbolTable)gilSynchronized_this).isCompilerUniverse()) {
                return this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$exists(p);
            }
            try {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                bl = this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$exists(p);
            }
            finally {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return bl;
        }

        public static /* synthetic */ int maxDepth$(SynchronizedBaseTypeSeq $this) {
            return $this.maxDepth();
        }

        default public int maxDepth() {
            Depth depth;
            Gil gil = (Gil)((Object)this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$$outer());
            if (gil == null) {
                throw null;
            }
            Gil gilSynchronized_this = gil;
            if (((SymbolTable)gilSynchronized_this).isCompilerUniverse()) {
                depth = new Depth(this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$maxDepthOfElems());
            } else {
                try {
                    gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                    depth = new Depth(this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$maxDepthOfElems());
                }
                finally {
                    gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
                }
            }
            return depth.depth();
        }

        public static /* synthetic */ String toString$(SynchronizedBaseTypeSeq $this) {
            return $this.toString();
        }

        default public String toString() {
            String string;
            Gil gil = (Gil)((Object)this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$$outer());
            if (gil == null) {
                throw null;
            }
            Gil gilSynchronized_this = gil;
            if (((SymbolTable)gilSynchronized_this).isCompilerUniverse()) {
                return this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$toString();
            }
            try {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                string = this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$toString();
            }
            finally {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return string;
        }

        public /* synthetic */ SynchronizedOps scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$$outer();

        public static void $init$(SynchronizedBaseTypeSeq $this) {
        }

        public static /* synthetic */ Object $anonfun$maxDepth$1$adapted(SynchronizedBaseTypeSeq $this) {
            return new Depth($this.scala$reflect$runtime$SynchronizedOps$SynchronizedBaseTypeSeq$$super$maxDepthOfElems());
        }
    }

    public interface SynchronizedScope {
        public /* synthetic */ boolean scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$isEmpty();

        public /* synthetic */ int scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$size();

        public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$enter(Symbols.Symbol var1);

        public /* synthetic */ void scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$rehash(Symbols.Symbol var1, Names.Name var2);

        public /* synthetic */ void scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$unlink(Scopes.ScopeEntry var1);

        public /* synthetic */ void scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$unlink(Symbols.Symbol var1);

        public /* synthetic */ Iterator scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$lookupAll(Names.Name var1);

        public /* synthetic */ Scopes.ScopeEntry scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$lookupEntry(Names.Name var1);

        public /* synthetic */ Scopes.ScopeEntry scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$lookupNextEntry(Scopes.ScopeEntry var1);

        public /* synthetic */ List scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$toList();

        public static /* synthetic */ Object scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$syncLock$(SynchronizedScope $this) {
            return $this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$syncLock();
        }

        default public Object scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$syncLock() {
            return new Object();
        }

        public static /* synthetic */ Object syncLockSynchronized$(SynchronizedScope $this, Function0 body) {
            return $this.syncLockSynchronized(body);
        }

        default public <T> T syncLockSynchronized(Function0<T> body) {
            if (((SymbolTable)this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$$outer()).isCompilerUniverse()) {
                return body.apply();
            }
            Object object = this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$syncLock();
            synchronized (object) {
                T t = body.apply();
                return t;
            }
        }

        public static /* synthetic */ boolean isEmpty$(SynchronizedScope $this) {
            return $this.isEmpty();
        }

        default public boolean isEmpty() {
            return BoxesRunTime.unboxToBoolean(this.syncLockSynchronized((JFunction0$mcZ$sp & Serializable)() -> this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$isEmpty()));
        }

        public static /* synthetic */ int size$(SynchronizedScope $this) {
            return $this.size();
        }

        default public int size() {
            return BoxesRunTime.unboxToInt(this.syncLockSynchronized((JFunction0$mcI$sp & Serializable)() -> this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$size()));
        }

        public static /* synthetic */ Symbols.Symbol enter$(SynchronizedScope $this, Symbols.Symbol sym) {
            return $this.enter(sym);
        }

        default public <T extends Symbols.Symbol> T enter(T sym) {
            return (T)((Symbols.Symbol)this.syncLockSynchronized((Function0<Symbols.Symbol> & java.io.Serializable & Serializable)() -> this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$enter(sym)));
        }

        public static /* synthetic */ void rehash$(SynchronizedScope $this, Symbols.Symbol sym, Names.Name newname) {
            $this.rehash(sym, newname);
        }

        default public void rehash(Symbols.Symbol sym, Names.Name newname) {
            this.syncLockSynchronized((JFunction0$mcV$sp & Serializable)() -> this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$rehash(sym, newname));
        }

        public static /* synthetic */ void unlink$(SynchronizedScope $this, Scopes.ScopeEntry e) {
            $this.unlink(e);
        }

        default public void unlink(Scopes.ScopeEntry e) {
            this.syncLockSynchronized((JFunction0$mcV$sp & Serializable)() -> this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$unlink(e));
        }

        public static /* synthetic */ void unlink$(SynchronizedScope $this, Symbols.Symbol sym) {
            $this.unlink(sym);
        }

        default public void unlink(Symbols.Symbol sym) {
            this.syncLockSynchronized((JFunction0$mcV$sp & Serializable)() -> this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$unlink(sym));
        }

        public static /* synthetic */ Iterator lookupAll$(SynchronizedScope $this, Names.Name name) {
            return $this.lookupAll(name);
        }

        default public Iterator<Symbols.Symbol> lookupAll(Names.Name name) {
            return (Iterator)this.syncLockSynchronized((Function0<Iterator> & java.io.Serializable & Serializable)() -> this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$lookupAll(name));
        }

        public static /* synthetic */ Scopes.ScopeEntry lookupEntry$(SynchronizedScope $this, Names.Name name) {
            return $this.lookupEntry(name);
        }

        default public Scopes.ScopeEntry lookupEntry(Names.Name name) {
            return (Scopes.ScopeEntry)this.syncLockSynchronized((Function0<Scopes.ScopeEntry> & java.io.Serializable & Serializable)() -> this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$lookupEntry(name));
        }

        public static /* synthetic */ Scopes.ScopeEntry lookupNextEntry$(SynchronizedScope $this, Scopes.ScopeEntry entry) {
            return $this.lookupNextEntry(entry);
        }

        default public Scopes.ScopeEntry lookupNextEntry(Scopes.ScopeEntry entry) {
            return (Scopes.ScopeEntry)this.syncLockSynchronized((Function0<Scopes.ScopeEntry> & java.io.Serializable & Serializable)() -> this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$lookupNextEntry(entry));
        }

        public static /* synthetic */ List toList$(SynchronizedScope $this) {
            return $this.toList();
        }

        default public List<Symbols.Symbol> toList() {
            return (List)this.syncLockSynchronized((Function0<List> & java.io.Serializable & Serializable)() -> this.scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$super$toList());
        }

        public /* synthetic */ SynchronizedOps scala$reflect$runtime$SynchronizedOps$SynchronizedScope$$$outer();

        public static void $init$(SynchronizedScope $this) {
        }
    }
}

