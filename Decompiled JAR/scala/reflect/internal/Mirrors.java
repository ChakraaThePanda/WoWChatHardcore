/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Function0;
import scala.Function1;
import scala.Predef$;
import scala.ScalaReflectionException;
import scala.Serializable;
import scala.collection.immutable.List;
import scala.collection.immutable.StringOps;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Mirror;
import scala.reflect.api.TypeTags;
import scala.reflect.api.Universe;
import scala.reflect.internal.MissingRequirementError;
import scala.reflect.internal.MissingRequirementError$;
import scala.reflect.internal.Names;
import scala.reflect.internal.Scopes;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Types;
import scala.reflect.internal.settings.MutableSettings;
import scala.reflect.internal.settings.MutableSettings$;
import scala.reflect.internal.util.Position;
import scala.reflect.package$;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\rud!C,Y!\u0003\r\taXB;\u0011\u0015I\u0007\u0001\"\u0001k\t\u0015q\u0007A!\u0011p\r%\u0019)\u0001\u0001I\u0001$\u0003\u00199\u0001C\u0004\u0004\n\r1\taa\u0003\u0007\u000bU\u0004\u0011\u0011\u0001<\t\u0011e,!\u0011!Q\u0001\niDaa`\u0003\u0005\u0002\u0005\u0005\u0001\u0002CA\u0003\u000b\u0001\u0006K!a\u0002\t\u000f\u00055Q\u0001\"\u0001\u0002\u0010!A\u0011\u0011C\u0003\u0007\u0012q\u000b\u0019\u0002C\u0005\u0002 \u0015\u0011\rQ\"\u0001\u0002\"!I\u0011\u0011F\u0003C\u0002\u001b\u0005\u00111\u0006\u0005\n\u0003g)!\u0019!D\u0001\u0003CA\u0011\"!\u000e\u0006\u0005\u00045\t!a\u000b\t\u000f\u0005]R\u0001\"\u0001\u0002:!9\u0011qN\u0003\u0005\u0002\u0005E\u0004bBAA\u000b\u0011%\u00111\u0011\u0005\b\u0003\u0003+A\u0011BAZ\u0011\u001d\tI,\u0002C\u0005\u0003wCq!!1\u0006\t#\t\u0019\rC\u0004\u0002N\u0016!\t\"a4\t\u0011\u0005UW\u0001\"\u0001]\u0003/Dq!!8\u0006\t\u0013\ty\u000eC\u0004\u0002j\u0016!\t!a;\t\u000f\u0005%X\u0001\"\u0001\u0002\u0000\"9!1A\u0003\u0005\u0002\t\u0015\u0001b\u0002B\u0002\u000b\u0011\u0005!1\u0002\u0005\b\u0005\u001f)A\u0011\u0001B\t\u0011\u001d\u0011)#\u0002C\u0001\u0005OAqA!\n\u0006\t\u0003\u0011Y\u0003C\u0004\u0003&\u0015!\tA!\r\t\u000f\t]R\u0001\"\u0011\u0003:!9!QH\u0003\u0005\n\t}\u0002b\u0002B%\u000b\u0011\u0005!1\n\u0005\b\u0005\u0013*A\u0011\u0001B)\u0011\u001d\u0011)&\u0002C\u0001\u0005/BqAa\u0017\u0006\t\u0003\u0011i\u0006C\u0004\u0003l\u0015!\tA!\u001c\t\u000f\t-T\u0001\"\u0001\u0003r!9!qO\u0003\u0005B\te\u0004b\u0002B?\u000b\u0011%!q\u0010\u0005\b\u0005\u0013+A\u0011\u0001BF\u0011\u001d\u0011I)\u0002C\u0001\u00057CqAa(\u0006\t\u0003\u0011\t\u000bC\u0004\u0003 \u0016!\tAa+\t\u000f\t=V\u0001\"\u0001\u00032\"9!qX\u0003\u0005\u0002\t\u0005\u0007b\u0002B`\u000b\u0011\u0005!q\u0019\u0005\b\u0005\u0017,A\u0011\u0001Bg\u0011\u001d\u0011Y-\u0002C\u0001\u0005'DqAa6\u0006\t\u0003\u0012I\u000eC\u0004\u0003^\u0016!\tAa8\t\u000f\t5X\u0001\"\u0002\u0003p\"111A\u0003\u0005\u0002)4qaa\u0004\u0001\u0003\u0003\u0019\t\u0002\u0003\u0005zo\t\u0005\t\u0015!\u0003{\u0011\u0019yx\u0007\"\u0001\u0004\u0014\u0019I1\u0011D\u001c\u0011\u0002\u0007\u000521\u0004\u0005\u0006Sj\"\tA\u001b\u0004\n\u0007\u000b9\u0004\u0013aA\u0011\u0007\u0007BQ!\u001b\u001f\u0005\u0002)Dqaa\u0012=\t\u000b\ny\u0001C\u0004\u0002Hr\"\te!\u0013\t\u000f\r-C\b\"\u0011\u0004N!91\u0011\u0002\u001f\u0005\u0002\r-aABB5o\u0001\u0019Y\u0007\u0003\u0004\u0000\u0005\u0012\u00051Q\u000e\u0005\b\u0007_\u0012E\u0011IA\b\u0011)\tIc\u000eEC\u0002\u0013\u00051Q\r\u0004\u0007\u0007/:\u0004a!\u0017\t\r}4E\u0011AB/\u0011\u001d\u0019\tG\u0012C!\u0003\u001fAqaa\u000fG\t\u0003\ny\u0001C\u0004\u0004d\u0019#\t%a\u0004\t\u000f\r}b\t\"\u0011\u0004f!Q\u0011qD\u001c\t\u0006\u0004%\ta!\u001d\u0007\r\r}q\u0007AB\u0011\u0011\u0019yX\n\"\u0001\u0004(!911F'\u0005B\u0005=\u0001BCA\u001bo!\u0015\r\u0011\"\u0001\u0004B\u001911QF\u001c\u0001\u0007_Aaa`)\u0005\u0002\r]\u0002bBB\u001e#\u0012\u0005\u0013q\u0002\u0005\b\u0007{\tF\u0011IA\b\u0011\u001d\u0019y$\u0015C!\u0007\u0003B!\"a\r8\u0011\u000b\u0007I\u0011AB:\u0005\u001di\u0015N\u001d:peNT!!\u0017.\u0002\u0011%tG/\u001a:oC2T!a\u0017/\u0002\u000fI,g\r\\3di*\tQ,A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0007\u0001\u0001G\r\u0005\u0002bE6\tA,\u0003\u0002d9\n1\u0011I\\=SK\u001a\u0004\"!\u001a5\u000e\u0003\u0019T!a\u001a.\u0002\u0007\u0005\u0004\u0018.\u0003\u0002XM\u00061A%\u001b8ji\u0012\"\u0012a\u001b\t\u0003C2L!!\u001c/\u0003\tUs\u0017\u000e\u001e\u0002\u0007\u001b&\u0014(o\u001c:\u0012\u0005A\u001c\bCA1r\u0013\t\u0011HL\u0001\u0003Ok2d\u0007C\u0001;\u0006\u001b\u0005\u0001!!\u0003*p_R\u001c()Y:f'\t)q\u000fE\u0002fqRL!A\u001c4\u0002\u0013I|w\u000e^(x]\u0016\u0014\bC\u0001;|\u0013\taXP\u0001\u0004Ts6\u0014w\u000e\\\u0005\u0003}b\u0013qaU=nE>d7/\u0001\u0004=S:LGO\u0010\u000b\u0004g\u0006\r\u0001\"B=\b\u0001\u0004Q\u0018aC5oSRL\u0017\r\\5{K\u0012\u00042!YA\u0005\u0013\r\tY\u0001\u0018\u0002\b\u0005>|G.Z1o\u0003MI7/T5se>\u0014\u0018J\\5uS\u0006d\u0017N_3e+\t\t9!\u0001\u0006s_>$Hj\\1eKJ,\"!!\u0006\u0011\u0007Q\f9\"\u0003\u0003\u0002\u001a\u0005m!\u0001\u0003'buf$\u0016\u0010]3\n\u0007\u0005u\u0001LA\u0003UsB,7/A\u0005S_>$8\t\\1tgV\u0011\u00111\u0005\t\u0004i\u0006\u0015\u0012bAA\u0014{\nY1\t\\1tgNKXNY8m\u0003-\u0011vn\u001c;QC\u000e\\\u0017mZ3\u0016\u0005\u00055\u0002c\u0001;\u00020%\u0019\u0011\u0011G?\u0003\u00195{G-\u001e7f'fl'm\u001c7\u0002#\u0015k\u0007\u000f^=QC\u000e\\\u0017mZ3DY\u0006\u001c8/\u0001\u0007F[B$\u0018\u0010U1dW\u0006<W-\u0001\u0005ts6\u0014w\u000e\\(g+\u0011\tY$!\u0018\u0015\t\u0005u\u00121\n\t\u0005\u0003\u007f\t9E\u0004\u0003\u0002B\u0005\rS\"A\u0003\n\u0007\u0005\u0015\u00030\u0001\u0005v]&4XM]:f\u0013\r\tI% \u0002\u000b)f\u0004XmU=nE>d\u0007\"CA'\u001f\u0005\u0005\t9AA(\u0003))g/\u001b3f]\u000e,G%\r\t\u0007\u0003\u007f\t\t&!\u0017\n\t\u0005M\u0013Q\u000b\u0002\f/\u0016\f7\u000eV=qKR\u000bw-C\u0002\u0002X\u0019\u0014\u0001\u0002V=qKR\u000bwm\u001d\t\u0005\u00037\ni\u0006\u0004\u0001\u0005\u000f\u0005}sB1\u0001\u0002b\t\tA+\u0005\u0003\u0002d\u0005%\u0004cA1\u0002f%\u0019\u0011q\r/\u0003\u000f9{G\u000f[5oOB\u0019\u0011-a\u001b\n\u0007\u00055DLA\u0002B]f\f!CZ5oI6+WNY3s\rJ|WNU8piR\u0019!0a\u001d\t\u000f\u0005U\u0004\u00031\u0001\u0002x\u0005Aa-\u001e7m\u001d\u0006lW\rE\u0002u\u0003sJA!a\u001f\u0002~\t!a*Y7f\u0013\r\ty\b\u0017\u0002\u0006\u001d\u0006lWm]\u0001\u0011O\u0016$Xj\u001c3vY\u0016|%o\u00117bgN$rA_AC\u0003?\u000bI\u000bC\u0004\u0002\bF\u0001\r!!#\u0002\tA\fG\u000f\u001b\t\u0005\u0003\u0017\u000bIJ\u0004\u0003\u0002\u000e\u0006U\u0005cAAH96\u0011\u0011\u0011\u0013\u0006\u0004\u0003's\u0016A\u0002\u001fs_>$h(C\u0002\u0002\u0018r\u000ba\u0001\u0015:fI\u00164\u0017\u0002BAN\u0003;\u0013aa\u0015;sS:<'bAAL9\"9\u0011\u0011U\tA\u0002\u0005\r\u0016a\u00017f]B\u0019\u0011-!*\n\u0007\u0005\u001dFLA\u0002J]RDq!a+\u0012\u0001\u0004\ti+\u0001\u0004u_:\u000bW.\u001a\t\bC\u0006=\u0016\u0011RA<\u0013\r\t\t\f\u0018\u0002\n\rVt7\r^5p]F\"RA_A[\u0003oCq!a\"\u0013\u0001\u0004\tI\tC\u0004\u0002,J\u0001\r!!,\u0002'M$\u0018\r^5d\u001b>$W\u000f\\3Pe\u000ec\u0017m]:\u0015\u000bi\fi,a0\t\u000f\u0005\u001d5\u00031\u0001\u0002\n\"9\u00111V\nA\u0002\u00055\u0016!E7jeJ|'/T5tg&tw\rS8pWR)!0!2\u0002J\"1\u0011q\u0019\u000bA\u0002i\fQa\\<oKJDq!a3\u0015\u0001\u0004\t9(\u0001\u0003oC6,\u0017aE;oSZ,'o]3NSN\u001c\u0018N\\4I_>\\G#\u0002>\u0002R\u0006M\u0007BBAd+\u0001\u0007!\u0010C\u0004\u0002LV\u0001\r!a\u001e\u0002\u00175L7o]5oO\"{wn\u001b\u000b\u0006u\u0006e\u00171\u001c\u0005\u0007\u0003\u000f4\u0002\u0019\u0001>\t\u000f\u0005-g\u00031\u0001\u0002x\u0005\tRM\\:ve\u0016\u001cE.Y:t'fl'm\u001c7\u0015\r\u0005\r\u0012\u0011]As\u0011\u001d\t\u0019o\u0006a\u0001\u0003\u0013\u000b\u0001BZ;mY:\fW.\u001a\u0005\u0007\u0003O<\u0002\u0019\u0001>\u0002\u0007MLX.\u0001\bhKR\u001cE.Y:t\u0005ft\u0015-\\3\u0015\t\u0005\r\u0012Q\u001e\u0005\b\u0003GD\u0002\u0019AA<Q\u001dA\u0012\u0011_A|\u0003w\u00042!YAz\u0013\r\t)\u0010\u0018\u0002\u000bI\u0016\u0004(/Z2bi\u0016$\u0017EAA}\u0003\r*6/\u001a\u0011pm\u0016\u0014Hn\\1eAQD\u0017\r\u001e\u0011bG\u000e,\u0007\u000f^:!C\u0002\u001aFO]5oO:\n#!!@\u0002\u000fIr\u0013G\r\u00182gQ!\u00111\u0005B\u0001\u0011\u001d\t\u0019/\u0007a\u0001\u0003\u0013\u000b\u0001cZ3u%\u0016\fX/\u001b:fI\u000ec\u0017m]:\u0015\r\u0005\r\"q\u0001B\u0005\u0011\u001d\t\u0019O\u0007a\u0001\u0003\u0013Cq!a+\u001b\u0001\u0004\ti\u000b\u0006\u0003\u0002$\t5\u0001bBAr7\u0001\u0007\u0011\u0011R\u0001\u000ee\u0016\fX/\u001b:fI\u000ec\u0017m]:\u0016\t\tM!1\u0005\u000b\u0005\u0003G\u0011)\u0002C\u0005\u0003\u0018q\t\t\u0011q\u0001\u0003\u001a\u0005QQM^5eK:\u001cW\r\n\u001a\u0011\r\tm!Q\u0004B\u0011\u001b\u0005Q\u0016b\u0001B\u00105\nA1\t\\1tgR\u000bw\r\u0005\u0003\u0002\\\t\rBaBA09\t\u0007\u0011\u0011M\u0001\u0012O\u0016$8\t\\1tg&3G)\u001a4j]\u0016$Gc\u0001>\u0003*!9\u00111]\u000fA\u0002\u0005%Ec\u0001>\u0003.!9\u00111\u001d\u0010A\u0002\u0005]\u0004f\u0002\u0010\u0002r\u0006]\u00181 \u000b\u0006u\nM\"Q\u0007\u0005\b\u0003G|\u0002\u0019AAE\u0011\u001d\tYk\ba\u0001\u0003[\u000b1b\u001d;bi&\u001c7\t\\1tgR!\u00111\u0005B\u001e\u0011\u001d\t\u0019\u000f\ta\u0001\u0003\u0013\u000b!#\u001a8tkJ,Wj\u001c3vY\u0016\u001c\u00160\u001c2pYRA\u0011Q\u0006B!\u0005\u0007\u0012)\u0005C\u0004\u0002d\u0006\u0002\r!!#\t\r\u0005\u001d\u0018\u00051\u0001{\u0011\u001d\u00119%\ta\u0001\u0003\u000f\tQ\"\u00197m_^\u0004\u0016mY6bO\u0016\u001c\u0018aD4fi6{G-\u001e7f\u0005ft\u0015-\\3\u0015\t\u00055\"Q\n\u0005\b\u0003G\u0014\u0003\u0019AA<Q\u001d\u0011\u0013\u0011_A|\u0003w$B!!\f\u0003T!9\u00111]\u0012A\u0002\u0005%\u0015!E4fiJ+\u0017/^5sK\u0012lu\u000eZ;mKR!\u0011Q\u0006B-\u0011\u001d\t\u0019\u000f\na\u0001\u0003\u0013\u000baB]3rk&\u0014X\rZ'pIVdW-\u0006\u0003\u0003`\t%D\u0003BA\u0017\u0005CB\u0011Ba\u0019&\u0003\u0003\u0005\u001dA!\u001a\u0002\u0015\u00154\u0018\u000eZ3oG\u0016$3\u0007\u0005\u0004\u0003\u001c\tu!q\r\t\u0005\u00037\u0012I\u0007B\u0004\u0002`\u0015\u0012\r!!\u0019\u0002%\u001d,G/T8ek2,\u0017J\u001a#fM&tW\r\u001a\u000b\u0004u\n=\u0004bBArM\u0001\u0007\u0011\u0011\u0012\u000b\u0004u\nM\u0004bBArO\u0001\u0007\u0011q\u000f\u0015\bO\u0005E\u0018q_A~\u00031\u0019H/\u0019;jG6{G-\u001e7f)\u0011\tiCa\u001f\t\u000f\u0005\r\b\u00061\u0001\u0002\n\u0006\u0019RM\\:ve\u0016\u0004\u0016mY6bO\u0016\u001c\u00160\u001c2pYRA\u0011Q\u0006BA\u0005\u0007\u0013)\tC\u0004\u0002d&\u0002\r!!#\t\r\u0005\u001d\u0018\u00061\u0001{\u0011\u001d\u00119)\u000ba\u0001\u0003\u000f\tA\"\u00197m_^lu\u000eZ;mKN\f!bZ3u!\u0006\u001c7.Y4f)\u0011\tiC!$\t\u000f\u0005\r(\u00061\u0001\u0003\u0010B\u0019AO!%\n\t\tM\u0015Q\u0010\u0002\t)\u0016\u0014XNT1nK\":!&!=\u0003\u0018\u0006m\u0018E\u0001BM\u0003\r*8/\u001a\u0011pm\u0016\u0014Hn\\1eAQD\u0017\r\u001e\u0011bG\u000e,\u0007\u000f^:!C\u0002\u001aFO]5oO:\"B!!\f\u0003\u001e\"9\u00111]\u0016A\u0002\u0005%\u0015aE4fiB\u000b7m[1hK&3G)\u001a4j]\u0016$Gc\u0001>\u0003$\"9\u00111\u001d\u0017A\u0002\t=\u0005f\u0002\u0017\u0002r\n]%qU\u0011\u0003\u0005S\u000bqA\r\u00182e9\n\u0014\u0007F\u0002{\u0005[Cq!a9.\u0001\u0004\tI)\u0001\nhKR\u0014V-];je\u0016$\u0007+Y2lC\u001e,G\u0003BA\u0017\u0005gCq!a9/\u0001\u0004\tI\tK\u0004/\u0003c\u00149La/\"\u0005\te\u0016AD;tK\u0002:W\r\u001e)bG.\fw-Z\u0011\u0003\u0005{\u000baA\r\u00182c9\u0002\u0014\u0001E4fiB\u000b7m[1hK>\u0013'.Z2u)\u0011\tiCa1\t\u000f\u0005\rx\u00061\u0001\u0003\u0010\":q&!=\u0003\u0018\n\u001dF\u0003BA\u0017\u0005\u0013Dq!a91\u0001\u0004\tI)A\rhKR\u0004\u0016mY6bO\u0016|%M[3di&3G)\u001a4j]\u0016$Gc\u0001>\u0003P\"9\u00111]\u0019A\u0002\t=\u0005fB\u0019\u0002r\n]%q\u0015\u000b\u0004u\nU\u0007bBAre\u0001\u0007\u0011\u0011R\u0001\u000egR\fG/[2QC\u000e\\\u0017mZ3\u0015\t\u00055\"1\u001c\u0005\b\u0003G\u001c\u0004\u0019AAE\u0003-)'/Y:ve\u0016t\u0015-\\3\u0016\t\t\u0005(1\u001e\u000b\u0005\u0003\u0013\u0013\u0019\u000fC\u0005\u0003fR\n\t\u0011q\u0001\u0003h\u0006QQM^5eK:\u001cW\r\n\u001b\u0011\r\tm!Q\u0004Bu!\u0011\tYFa;\u0005\u000f\u0005}CG1\u0001\u0002b\u0005YqO]1q\u001b&\u001c8/\u001b8h)\rQ(\u0011\u001f\u0005\t\u0005g,D\u00111\u0001\u0003v\u0006!!m\u001c3z!\u0011\t'q\u001f>\n\u0007\teHL\u0001\u0005=Eft\u0017-\\3?Q\r)$Q \t\u0004C\n}\u0018bAB\u00019\n1\u0011N\u001c7j]\u0016\fA!\u001b8ji\nQ!k\\8u'fl'm\u001c7\u0014\u0005\rQ\u0018AB7jeJ|'/\u0006\u0002\u0004\u000eA\u0011AO\u0001\u0002\u0006%>|Go]\n\u0003oM$Ba!\u0006\u0004\u0018A\u0011Ao\u000e\u0005\u0006sf\u0002\rA\u001f\u0002\u0010/\u0016dGn\u00138po:\u001c\u00160\u001c2pYN\u0011!H_\u0015\u0005u5\u000bFH\u0001\u0007F[B$\u0018\u0010U1dW\u0006<WmE\u0003N\u0003[\u0019\u0019\u0003E\u0002\u0004&ij\u0011a\u000e\u000b\u0003\u0007S\u00012a!\nN\u00039I7/R7qif\u0004\u0016mY6bO\u0016\u0014\u0011#R7qif\u0004\u0016mY6bO\u0016\u001cE.Y:t'\u0015\t6\u0011GB\u0012!\r!81G\u0005\u0004\u0007ki(A\u0005)bG.\fw-Z\"mCN\u001c8+_7c_2$\"a!\u000f\u0011\u0007\r\u0015\u0012+A\bjg\u00163g-Z2uSZ,'k\\8u\u0003MI7/R7qif\u0004\u0016mY6bO\u0016\u001cE.Y:t\u00031\u0019x.\u001e:dK6{G-\u001e7f+\t\u0019Ic\u0005\u0004=u\u000e\r2Q\t\t\u0003i\u000e\tA\"[:S_>$8+_7c_2,\u0012A_\u0001\u000bif\u0004Xm\u00144UQ&\u001cXCAB(!\r!8\u0011K\u0005\u0005\u0007'\nYB\u0001\u0003UsB,\u0017f\u0001\u001fG\u0005\nI!k\\8u\u00072\f7o]\n\u0006\r\u000eE21\f\t\u0004\u0007KaDCAB0!\r\u0019)CR\u0001\u0007SN\u0014vn\u001c;\u0002\u001b%\u001ch*Z:uK\u0012\u001cE.Y:t+\t\u00199\u0007E\u0002\u0004&\t\u00131BU8piB\u000b7m[1hKN)!)!\f\u0004\\Q\u00111qM\u0001\u000eSN\u0014vn\u001c;QC\u000e\\\u0017mZ3\u0016\u0005\r}SCAB\u001d!\u0011\u00199h!\u001f\u000e\u0003aK1aa\u001fY\u0005-\u0019\u00160\u001c2pYR\u000b'\r\\3")
public interface Mirrors
extends scala.reflect.api.Mirrors {
    public static void $init$(Mirrors $this) {
    }

    public interface RootSymbol {
        public RootsBase mirror();
    }

    public abstract class Roots
    extends RootsBase {
        private RootPackage RootPackage;
        private RootClass RootClass;
        private EmptyPackage EmptyPackage;
        private EmptyPackageClass EmptyPackageClass;
        public final Symbols.Symbol scala$reflect$internal$Mirrors$Roots$$rootOwner;
        private volatile byte bitmap$0;

        private RootPackage RootPackage$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 1) == 0) {
                    this.RootPackage = new RootPackage();
                    this.bitmap$0 = (byte)(this.bitmap$0 | 1);
                }
            }
            return this.RootPackage;
        }

        @Override
        public RootPackage RootPackage() {
            if ((byte)(this.bitmap$0 & 1) == 0) {
                return this.RootPackage$lzycompute();
            }
            return this.RootPackage;
        }

        private RootClass RootClass$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 2) == 0) {
                    this.RootClass = new RootClass();
                    this.bitmap$0 = (byte)(this.bitmap$0 | 2);
                }
            }
            return this.RootClass;
        }

        @Override
        public RootClass RootClass() {
            if ((byte)(this.bitmap$0 & 2) == 0) {
                return this.RootClass$lzycompute();
            }
            return this.RootClass;
        }

        private EmptyPackage EmptyPackage$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 4) == 0) {
                    this.EmptyPackage = new EmptyPackage();
                    this.bitmap$0 = (byte)(this.bitmap$0 | 4);
                }
            }
            return this.EmptyPackage;
        }

        @Override
        public EmptyPackage EmptyPackage() {
            if ((byte)(this.bitmap$0 & 4) == 0) {
                return this.EmptyPackage$lzycompute();
            }
            return this.EmptyPackage;
        }

        private EmptyPackageClass EmptyPackageClass$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 8) == 0) {
                    this.EmptyPackageClass = new EmptyPackageClass();
                    this.bitmap$0 = (byte)(this.bitmap$0 | 8);
                }
            }
            return this.EmptyPackageClass;
        }

        @Override
        public EmptyPackageClass EmptyPackageClass() {
            if ((byte)(this.bitmap$0 & 8) == 0) {
                return this.EmptyPackageClass$lzycompute();
            }
            return this.EmptyPackageClass;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Mirrors$Roots$$$outer() {
            return this.$outer;
        }

        public Roots(SymbolTable $outer, Symbols.Symbol rootOwner) {
            this.scala$reflect$internal$Mirrors$Roots$$rootOwner = rootOwner;
            super($outer, rootOwner);
        }

        public class EmptyPackage
        extends Symbols.ModuleSymbol
        implements WellKnownSymbol {
            @Override
            public boolean isEmptyPackage() {
                return true;
            }

            public /* synthetic */ Roots scala$reflect$internal$Mirrors$Roots$EmptyPackage$$$outer() {
                return Roots.this;
            }

            @Override
            public /* synthetic */ Roots scala$reflect$internal$Mirrors$Roots$WellKnownSymbol$$$outer() {
                return this.scala$reflect$internal$Mirrors$Roots$EmptyPackage$$$outer();
            }

            public EmptyPackage() {
                if (Roots.this == null) {
                    throw null;
                }
                super(Roots.this.scala$reflect$internal$Mirrors$Roots$$$outer(), (Symbols.Symbol)Roots.this.RootClass(), (Position)Roots.this.scala$reflect$internal$Mirrors$Roots$$$outer().NoPosition(), (Names.TermName)Roots.this.scala$reflect$internal$Mirrors$Roots$$$outer().nme().EMPTY_PACKAGE_NAME());
                WellKnownSymbol.$init$(this);
            }
        }

        public class EmptyPackageClass
        extends Symbols.PackageClassSymbol
        implements WellKnownSymbol {
            @Override
            public boolean isEffectiveRoot() {
                return true;
            }

            @Override
            public boolean isEmptyPackageClass() {
                return true;
            }

            @Override
            public EmptyPackage sourceModule() {
                return this.scala$reflect$internal$Mirrors$Roots$EmptyPackageClass$$$outer().EmptyPackage();
            }

            public /* synthetic */ Roots scala$reflect$internal$Mirrors$Roots$EmptyPackageClass$$$outer() {
                return Roots.this;
            }

            @Override
            public /* synthetic */ Roots scala$reflect$internal$Mirrors$Roots$WellKnownSymbol$$$outer() {
                return this.scala$reflect$internal$Mirrors$Roots$EmptyPackageClass$$$outer();
            }

            public EmptyPackageClass() {
                if (Roots.this == null) {
                    throw null;
                }
                super(Roots.this.scala$reflect$internal$Mirrors$Roots$$$outer(), (Symbols.Symbol)Roots.this.RootClass(), (Position)Roots.this.scala$reflect$internal$Mirrors$Roots$$$outer().NoPosition(), (Names.TypeName)Roots.this.scala$reflect$internal$Mirrors$Roots$$$outer().tpnme().EMPTY_PACKAGE_NAME());
                WellKnownSymbol.$init$(this);
            }
        }

        public class RootClass
        extends Symbols.PackageClassSymbol
        implements RootSymbol {
            @Override
            public final boolean isRootSymbol() {
                return ((RootSymbol)this).isRootSymbol();
            }

            @Override
            public Symbols.Symbol owner() {
                return ((RootSymbol)this).owner();
            }

            @Override
            public Types.Type typeOfThis() {
                return ((RootSymbol)this).typeOfThis();
            }

            @Override
            public RootsBase mirror() {
                return ((RootSymbol)this).mirror();
            }

            @Override
            public boolean isRoot() {
                return true;
            }

            @Override
            public boolean isEffectiveRoot() {
                return true;
            }

            @Override
            public boolean isNestedClass() {
                return false;
            }

            @Override
            public RootPackage sourceModule() {
                return this.scala$reflect$internal$Mirrors$Roots$RootClass$$$outer().RootPackage();
            }

            public /* synthetic */ Roots scala$reflect$internal$Mirrors$Roots$RootClass$$$outer() {
                return Roots.this;
            }

            @Override
            public /* synthetic */ Roots scala$reflect$internal$Mirrors$Roots$RootSymbol$$$outer() {
                return this.scala$reflect$internal$Mirrors$Roots$RootClass$$$outer();
            }

            @Override
            public /* synthetic */ Roots scala$reflect$internal$Mirrors$Roots$WellKnownSymbol$$$outer() {
                return this.scala$reflect$internal$Mirrors$Roots$RootClass$$$outer();
            }

            public RootClass() {
                if (Roots.this == null) {
                    throw null;
                }
                super(Roots.this.scala$reflect$internal$Mirrors$Roots$$$outer(), Roots.this.scala$reflect$internal$Mirrors$Roots$$rootOwner, (Position)Roots.this.scala$reflect$internal$Mirrors$Roots$$$outer().NoPosition(), (Names.TypeName)Roots.this.scala$reflect$internal$Mirrors$Roots$$$outer().tpnme().ROOT());
                WellKnownSymbol.$init$(this);
                RootSymbol.$init$(this);
                this.setInfo(Roots.this.rootLoader());
            }
        }

        public class RootPackage
        extends Symbols.ModuleSymbol
        implements RootSymbol {
            @Override
            public final boolean isRootSymbol() {
                return ((RootSymbol)this).isRootSymbol();
            }

            @Override
            public Symbols.Symbol owner() {
                return ((RootSymbol)this).owner();
            }

            @Override
            public Types.Type typeOfThis() {
                return ((RootSymbol)this).typeOfThis();
            }

            @Override
            public RootsBase mirror() {
                return ((RootSymbol)this).mirror();
            }

            @Override
            public boolean isRootPackage() {
                return true;
            }

            public /* synthetic */ Roots scala$reflect$internal$Mirrors$Roots$RootPackage$$$outer() {
                return Roots.this;
            }

            @Override
            public /* synthetic */ Roots scala$reflect$internal$Mirrors$Roots$RootSymbol$$$outer() {
                return this.scala$reflect$internal$Mirrors$Roots$RootPackage$$$outer();
            }

            @Override
            public /* synthetic */ Roots scala$reflect$internal$Mirrors$Roots$WellKnownSymbol$$$outer() {
                return this.scala$reflect$internal$Mirrors$Roots$RootPackage$$$outer();
            }

            public RootPackage() {
                if (Roots.this == null) {
                    throw null;
                }
                super(Roots.this.scala$reflect$internal$Mirrors$Roots$$$outer(), Roots.this.scala$reflect$internal$Mirrors$Roots$$rootOwner, (Position)Roots.this.scala$reflect$internal$Mirrors$Roots$$$outer().NoPosition(), Roots.this.scala$reflect$internal$Mirrors$Roots$$$outer().nme().ROOTPKG());
                WellKnownSymbol.$init$(this);
                RootSymbol.$init$(this);
                this.setInfo(new Types.NullaryMethodType(Roots.this.scala$reflect$internal$Mirrors$Roots$$$outer(), Roots.this.RootClass().tpe()));
            }
        }

        public interface RootSymbol
        extends WellKnownSymbol,
        scala.reflect.internal.Mirrors$RootSymbol {
            default public boolean isRootSymbol() {
                return true;
            }

            default public Symbols.Symbol owner() {
                return this.scala$reflect$internal$Mirrors$Roots$RootSymbol$$$outer().scala$reflect$internal$Mirrors$Roots$$rootOwner;
            }

            default public Types.Type typeOfThis() {
                return ((Symbols.Symbol)((Object)this)).thisSym().tpe();
            }

            @Override
            default public RootsBase mirror() {
                return this.scala$reflect$internal$Mirrors$Roots$RootSymbol$$$outer();
            }

            public /* synthetic */ Roots scala$reflect$internal$Mirrors$Roots$RootSymbol$$$outer();

            public static void $init$(RootSymbol $this) {
            }
        }

        public interface WellKnownSymbol {
            public /* synthetic */ Roots scala$reflect$internal$Mirrors$Roots$WellKnownSymbol$$$outer();

            public static void $init$(WellKnownSymbol $this) {
                ((Symbols.Symbol)((Object)$this)).initFlags(9453856L);
            }
        }
    }

    public abstract class RootsBase
    extends Mirror<SymbolTable> {
        private final Symbols.Symbol rootOwner;
        private boolean initialized;
        public final /* synthetic */ SymbolTable $outer;

        public boolean isMirrorInitialized() {
            return this.initialized;
        }

        public abstract Types.LazyType rootLoader();

        @Override
        public abstract Symbols.ClassSymbol RootClass();

        @Override
        public abstract Symbols.ModuleSymbol RootPackage();

        @Override
        public abstract Symbols.ClassSymbol EmptyPackageClass();

        @Override
        public abstract Symbols.ModuleSymbol EmptyPackage();

        @Override
        public <T> Symbols.TypeSymbol symbolOf(TypeTags.WeakTypeTag<T> evidence$1) {
            return (Symbols.TypeSymbol)((Types.Type)((Universe)this.universe()).weakTypeTag(evidence$1).in(this).tpe()).typeSymbolDirect().asType();
        }

        public Symbols.Symbol findMemberFromRoot(Names.Name fullName) {
            List<Names.Name> segs = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().nme().segments(fullName.toString(), fullName.isTermName());
            if (segs.isEmpty()) {
                return this.scala$reflect$internal$Mirrors$RootsBase$$$outer().NoSymbol();
            }
            return this.scala$reflect$internal$Mirrors$RootsBase$$$outer().definitions().findNamedMember((List)segs.tail(), this.RootClass().info().member(segs.head()));
        }

        /*
         * WARNING - void declaration
         */
        private Symbols.Symbol getModuleOrClass(String path, int len, Function1<String, Names.Name> toName) {
            void var11_11;
            void reflectSettingToBoolean_s;
            Symbols.Symbol result2;
            int point = path.lastIndexOf(46, len - 1);
            Symbols.ClassSymbol owner = point > 0 ? this.getModuleOrClass(path, point, (Function1<String, Names.Name>)(Function1<String, Names.TermName> & java.io.Serializable & Serializable)x$1 -> this.scala$reflect$internal$Mirrors$RootsBase$$$outer().newTermName((String)x$1)) : this.RootClass();
            Names.Name name = toName.apply(path.substring(point + 1, len));
            Symbols.Symbol sym = owner.info().member(name);
            Symbols.Symbol symbol = result2 = name.isTermName() ? sym.suchThat((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(x$2.hasFlag(256))) : sym;
            Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().NoSymbol();
            if (symbol == null ? noSymbol != null : !symbol.equals(noSymbol)) {
                return result2;
            }
            MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().settings().debug();
            if (MutableSettings$.MODULE$ == null) {
                throw null;
            }
            if (BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value())) {
                this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Types.Type> & java.io.Serializable & Serializable)() -> sym.info());
                this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Scopes.Scope> & java.io.Serializable & Serializable)() -> sym.info().members());
            }
            Symbols.Symbol symbol2 = this.missingHook(owner, name);
            if (symbol2 == null) {
                throw null;
            }
            Symbols.Symbol orElse_this = symbol2;
            if (orElse_this == orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                throw MissingRequirementError$.MODULE$.notFound(new StringBuilder(4).append(name.isTermName() ? "object " : "class ").append(path).append(" in ").append(this).toString());
            }
            return var11_11;
        }

        /*
         * WARNING - void declaration
         */
        private Symbols.Symbol getModuleOrClass(String path, Function1<String, Names.Name> toName) {
            void var11_11;
            void getModuleOrClass_reflectSettingToBoolean_s;
            Symbols.Symbol getModuleOrClass_result;
            int getModuleOrClass_len = path.length();
            int getModuleOrClass_point = path.lastIndexOf(46, getModuleOrClass_len - 1);
            Symbols.ClassSymbol getModuleOrClass_owner = getModuleOrClass_point > 0 ? this.getModuleOrClass(path, getModuleOrClass_point, (Function1<String, Names.Name>)(Function1<String, Names.TermName> & java.io.Serializable & Serializable)x$1 -> this.scala$reflect$internal$Mirrors$RootsBase$$$outer().newTermName((String)x$1)) : this.RootClass();
            Names.Name getModuleOrClass_name = toName.apply(path.substring(getModuleOrClass_point + 1, getModuleOrClass_len));
            Symbols.Symbol getModuleOrClass_sym = getModuleOrClass_owner.info().member(getModuleOrClass_name);
            Symbols.Symbol symbol = getModuleOrClass_result = getModuleOrClass_name.isTermName() ? getModuleOrClass_sym.suchThat((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(x$2.hasFlag(256))) : getModuleOrClass_sym;
            Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().NoSymbol();
            if (symbol == null ? noSymbol != null : !symbol.equals(noSymbol)) {
                return getModuleOrClass_result;
            }
            MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().settings().debug();
            if (MutableSettings$.MODULE$ == null) {
                throw null;
            }
            if (BoxesRunTime.unboxToBoolean(getModuleOrClass_reflectSettingToBoolean_s.value())) {
                this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Types.Type> & java.io.Serializable & Serializable)() -> sym.info());
                this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Scopes.Scope> & java.io.Serializable & Serializable)() -> sym.info().members());
            }
            Symbols.Symbol symbol2 = this.missingHook(getModuleOrClass_owner, getModuleOrClass_name);
            if (symbol2 == null) {
                throw null;
            }
            Symbols.Symbol getModuleOrClass_orElse_this = symbol2;
            if (getModuleOrClass_orElse_this == getModuleOrClass_orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                throw MissingRequirementError$.MODULE$.notFound(new StringBuilder(4).append(getModuleOrClass_name.isTermName() ? "object " : "class ").append(path).append(" in ").append(this).toString());
            }
            return var11_11;
        }

        /*
         * WARNING - void declaration
         */
        private Symbols.Symbol staticModuleOrClass(String path, Function1<String, Names.Name> toName) {
            void var11_11;
            void getModuleOrClass_getModuleOrClass_reflectSettingToBoolean_s;
            Symbols.Symbol getModuleOrClass_getModuleOrClass_result;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (!new StringOps(path).contains(BoxesRunTime.boxToCharacter('.'))) {
                return this.EmptyPackageClass().info().decl(toName.apply(path));
            }
            int getModuleOrClass_getModuleOrClass_len = path.length();
            int getModuleOrClass_getModuleOrClass_point = path.lastIndexOf(46, getModuleOrClass_getModuleOrClass_len - 1);
            Symbols.ClassSymbol getModuleOrClass_getModuleOrClass_owner = getModuleOrClass_getModuleOrClass_point > 0 ? this.getModuleOrClass(path, getModuleOrClass_getModuleOrClass_point, (Function1<String, Names.Name>)(Function1<String, Names.TermName> & java.io.Serializable & Serializable)x$1 -> this.scala$reflect$internal$Mirrors$RootsBase$$$outer().newTermName((String)x$1)) : this.RootClass();
            Names.Name getModuleOrClass_getModuleOrClass_name = toName.apply(path.substring(getModuleOrClass_getModuleOrClass_point + 1, getModuleOrClass_getModuleOrClass_len));
            Symbols.Symbol getModuleOrClass_getModuleOrClass_sym = getModuleOrClass_getModuleOrClass_owner.info().member(getModuleOrClass_getModuleOrClass_name);
            Symbols.Symbol symbol = getModuleOrClass_getModuleOrClass_result = getModuleOrClass_getModuleOrClass_name.isTermName() ? getModuleOrClass_getModuleOrClass_sym.suchThat((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(x$2.hasFlag(256))) : getModuleOrClass_getModuleOrClass_sym;
            Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().NoSymbol();
            if (symbol == null ? noSymbol != null : !symbol.equals(noSymbol)) {
                return getModuleOrClass_getModuleOrClass_result;
            }
            MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().settings().debug();
            if (MutableSettings$.MODULE$ == null) {
                throw null;
            }
            if (BoxesRunTime.unboxToBoolean(getModuleOrClass_getModuleOrClass_reflectSettingToBoolean_s.value())) {
                this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Types.Type> & java.io.Serializable & Serializable)() -> sym.info());
                this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Scopes.Scope> & java.io.Serializable & Serializable)() -> sym.info().members());
            }
            Symbols.Symbol symbol2 = this.missingHook(getModuleOrClass_getModuleOrClass_owner, getModuleOrClass_getModuleOrClass_name);
            if (symbol2 == null) {
                throw null;
            }
            Symbols.Symbol getModuleOrClass_getModuleOrClass_orElse_this = symbol2;
            if (getModuleOrClass_getModuleOrClass_orElse_this == getModuleOrClass_getModuleOrClass_orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                throw MissingRequirementError$.MODULE$.notFound(new StringBuilder(4).append(getModuleOrClass_getModuleOrClass_name.isTermName() ? "object " : "class ").append(path).append(" in ").append(this).toString());
            }
            return var11_11;
        }

        public Symbols.Symbol mirrorMissingHook(Symbols.Symbol owner, Names.Name name) {
            return this.scala$reflect$internal$Mirrors$RootsBase$$$outer().NoSymbol();
        }

        public Symbols.Symbol universeMissingHook(Symbols.Symbol owner, Names.Name name) {
            return this.scala$reflect$internal$Mirrors$RootsBase$$$outer().missingHook(owner, name);
        }

        /*
         * WARNING - void declaration
         */
        public Symbols.Symbol missingHook(Symbols.Symbol owner, Names.Name name) {
            void logResult_msg;
            SymbolTable symbolTable = this.scala$reflect$internal$Mirrors$RootsBase$$$outer();
            Symbols.Symbol symbol = this.mirrorMissingHook(owner, name);
            if (symbol == null) {
                throw null;
            }
            Symbols.Symbol orElse_this = symbol;
            Symbols.Symbol symbol2 = orElse_this != orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol() ? orElse_this : this.universeMissingHook(owner, name);
            Function0<String> & java.io.Serializable & Serializable intersect = (Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(15).append("missingHook(").append(owner).append(", ").append(name).append(")").toString();
            if (symbolTable == null) {
                throw null;
            }
            symbolTable.log((Function0<Object>)((Function0<String> & java.io.Serializable & Serializable)() -> SymbolTable.$anonfun$logResult$1((Function0)logResult_msg, symbol2)));
            return symbol2;
        }

        private Symbols.ClassSymbol ensureClassSymbol(String fullname, Symbols.Symbol sym) {
            if (!(sym instanceof Symbols.ClassSymbol)) {
                throw MissingRequirementError$.MODULE$.notFound(new StringBuilder(6).append("class ").append(fullname).toString());
            }
            Symbols.ClassSymbol classSymbol = (Symbols.ClassSymbol)sym;
            return classSymbol;
        }

        /*
         * WARNING - void declaration
         */
        public Symbols.ClassSymbol getClassByName(Names.Name fullname) {
            Symbols.Symbol symbol;
            Symbols.Symbol getModuleOrClass_result;
            String string = fullname.toString();
            int getModuleOrClass_len = fullname.length();
            String getModuleOrClass_path = fullname.toString();
            int getModuleOrClass_point = getModuleOrClass_path.lastIndexOf(46, getModuleOrClass_len - 1);
            Symbols.ClassSymbol getModuleOrClass_owner = getModuleOrClass_point > 0 ? this.getModuleOrClass(getModuleOrClass_path, getModuleOrClass_point, (Function1<String, Names.Name>)(Function1<String, Names.TermName> & java.io.Serializable & Serializable)x$1 -> this.scala$reflect$internal$Mirrors$RootsBase$$$outer().newTermName((String)x$1)) : this.RootClass();
            String string2 = getModuleOrClass_path.substring(getModuleOrClass_point + 1, getModuleOrClass_len);
            Names.TypeName getModuleOrClass_name = RootsBase.$anonfun$getClassByName$1(this, string2);
            Symbols.Symbol getModuleOrClass_sym = getModuleOrClass_owner.info().member(getModuleOrClass_name);
            Symbols.Symbol symbol2 = getModuleOrClass_result = ((Names.Name)getModuleOrClass_name).isTermName() ? getModuleOrClass_sym.suchThat((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(x$2.hasFlag(256))) : getModuleOrClass_sym;
            Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().NoSymbol();
            if (symbol2 == null ? noSymbol != null : !symbol2.equals(noSymbol)) {
                symbol = getModuleOrClass_result;
            } else {
                void var11_12;
                void getModuleOrClass_reflectSettingToBoolean_s;
                MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().settings().debug();
                if (MutableSettings$.MODULE$ == null) {
                    throw null;
                }
                if (BoxesRunTime.unboxToBoolean(getModuleOrClass_reflectSettingToBoolean_s.value())) {
                    this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Types.Type> & java.io.Serializable & Serializable)() -> sym.info());
                    this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Scopes.Scope> & java.io.Serializable & Serializable)() -> sym.info().members());
                }
                Symbols.Symbol symbol3 = this.missingHook(getModuleOrClass_owner, getModuleOrClass_name);
                if (symbol3 == null) {
                    throw null;
                }
                Symbols.Symbol getModuleOrClass_orElse_this = symbol3;
                if (getModuleOrClass_orElse_this == getModuleOrClass_orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                    throw MissingRequirementError$.MODULE$.notFound(new StringBuilder(4).append(getModuleOrClass_name.isTermName() ? "object " : "class ").append(getModuleOrClass_path).append(" in ").append(this).toString());
                }
                symbol = var11_12;
            }
            return this.ensureClassSymbol(string, symbol);
        }

        public Symbols.ClassSymbol getClassByName(String fullname) {
            return this.getRequiredClass(fullname);
        }

        /*
         * WARNING - void declaration
         */
        public Symbols.ClassSymbol getRequiredClass(String fullname, Function1<String, Names.Name> toName) {
            Symbols.Symbol symbol;
            Symbols.Symbol getModuleOrClass_result;
            int getModuleOrClass_len = fullname.length();
            int getModuleOrClass_point = fullname.lastIndexOf(46, getModuleOrClass_len - 1);
            Symbols.ClassSymbol getModuleOrClass_owner = getModuleOrClass_point > 0 ? this.getModuleOrClass(fullname, getModuleOrClass_point, (Function1<String, Names.Name>)(Function1<String, Names.TermName> & java.io.Serializable & Serializable)x$1 -> this.scala$reflect$internal$Mirrors$RootsBase$$$outer().newTermName((String)x$1)) : this.RootClass();
            Names.Name getModuleOrClass_name = toName.apply(fullname.substring(getModuleOrClass_point + 1, getModuleOrClass_len));
            Symbols.Symbol getModuleOrClass_sym = getModuleOrClass_owner.info().member(getModuleOrClass_name);
            Symbols.Symbol symbol2 = getModuleOrClass_result = getModuleOrClass_name.isTermName() ? getModuleOrClass_sym.suchThat((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(x$2.hasFlag(256))) : getModuleOrClass_sym;
            Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().NoSymbol();
            if (symbol2 == null ? noSymbol != null : !symbol2.equals(noSymbol)) {
                symbol = getModuleOrClass_result;
            } else {
                void var11_11;
                void getModuleOrClass_reflectSettingToBoolean_s;
                MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().settings().debug();
                if (MutableSettings$.MODULE$ == null) {
                    throw null;
                }
                if (BoxesRunTime.unboxToBoolean(getModuleOrClass_reflectSettingToBoolean_s.value())) {
                    this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Types.Type> & java.io.Serializable & Serializable)() -> sym.info());
                    this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Scopes.Scope> & java.io.Serializable & Serializable)() -> sym.info().members());
                }
                Symbols.Symbol symbol3 = this.missingHook(getModuleOrClass_owner, getModuleOrClass_name);
                if (symbol3 == null) {
                    throw null;
                }
                Symbols.Symbol getModuleOrClass_orElse_this = symbol3;
                if (getModuleOrClass_orElse_this == getModuleOrClass_orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                    throw MissingRequirementError$.MODULE$.notFound(new StringBuilder(4).append(getModuleOrClass_name.isTermName() ? "object " : "class ").append(fullname).append(" in ").append(this).toString());
                }
                symbol = var11_11;
            }
            return this.ensureClassSymbol(fullname, symbol);
        }

        /*
         * WARNING - void declaration
         */
        public Symbols.ClassSymbol getRequiredClass(String fullname) {
            Symbols.Symbol symbol;
            Symbols.Symbol getModuleOrClass_result;
            int getModuleOrClass_len = fullname.length();
            int getModuleOrClass_point = fullname.lastIndexOf(46, getModuleOrClass_len - 1);
            Symbols.ClassSymbol getModuleOrClass_owner = getModuleOrClass_point > 0 ? this.getModuleOrClass(fullname, getModuleOrClass_point, (Function1<String, Names.Name>)(Function1<String, Names.TermName> & java.io.Serializable & Serializable)x$1 -> this.scala$reflect$internal$Mirrors$RootsBase$$$outer().newTermName((String)x$1)) : this.RootClass();
            String string = fullname.substring(getModuleOrClass_point + 1, getModuleOrClass_len);
            Names.TypeName getModuleOrClass_name = RootsBase.$anonfun$getRequiredClass$1(this, string);
            Symbols.Symbol getModuleOrClass_sym = getModuleOrClass_owner.info().member(getModuleOrClass_name);
            Symbols.Symbol symbol2 = getModuleOrClass_result = ((Names.Name)getModuleOrClass_name).isTermName() ? getModuleOrClass_sym.suchThat((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(x$2.hasFlag(256))) : getModuleOrClass_sym;
            Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().NoSymbol();
            if (symbol2 == null ? noSymbol != null : !symbol2.equals(noSymbol)) {
                symbol = getModuleOrClass_result;
            } else {
                void var10_11;
                void getModuleOrClass_reflectSettingToBoolean_s;
                MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().settings().debug();
                if (MutableSettings$.MODULE$ == null) {
                    throw null;
                }
                if (BoxesRunTime.unboxToBoolean(getModuleOrClass_reflectSettingToBoolean_s.value())) {
                    this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Types.Type> & java.io.Serializable & Serializable)() -> sym.info());
                    this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Scopes.Scope> & java.io.Serializable & Serializable)() -> sym.info().members());
                }
                Symbols.Symbol symbol3 = this.missingHook(getModuleOrClass_owner, getModuleOrClass_name);
                if (symbol3 == null) {
                    throw null;
                }
                Symbols.Symbol getModuleOrClass_orElse_this = symbol3;
                if (getModuleOrClass_orElse_this == getModuleOrClass_orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                    throw MissingRequirementError$.MODULE$.notFound(new StringBuilder(4).append(getModuleOrClass_name.isTermName() ? "object " : "class ").append(fullname).append(" in ").append(this).toString());
                }
                symbol = var10_11;
            }
            return this.ensureClassSymbol(fullname, symbol);
        }

        public <T> Symbols.ClassSymbol requiredClass(ClassTag<T> evidence$2) {
            return this.getRequiredClass(this.erasureName(evidence$2), (Function1<String, Names.Name>)(Function1<String, Names.TypeName> & java.io.Serializable & Serializable)x$5 -> this.scala$reflect$internal$Mirrors$RootsBase$$$outer().newTypeName((String)x$5));
        }

        public Symbols.Symbol getClassIfDefined(String fullname) {
            return this.getClassIfDefined(fullname, (Function1<String, Names.Name>)(Function1<String, Names.TypeName> & java.io.Serializable & Serializable)x$6 -> this.scala$reflect$internal$Mirrors$RootsBase$$$outer().newTypeName((String)x$6));
        }

        public Symbols.Symbol getClassIfDefined(Names.Name fullname) {
            try {
                return this.getClassByName(fullname.toTypeName());
            }
            catch (MissingRequirementError missingRequirementError) {
                return this.scala$reflect$internal$Mirrors$RootsBase$$$outer().NoSymbol();
            }
        }

        public Symbols.Symbol getClassIfDefined(String fullname, Function1<String, Names.Name> toName) {
            try {
                return this.getRequiredClass(fullname, toName);
            }
            catch (MissingRequirementError missingRequirementError) {
                return this.scala$reflect$internal$Mirrors$RootsBase$$$outer().NoSymbol();
            }
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public Symbols.ClassSymbol staticClass(String fullname) {
            try {
                Symbols.Symbol symbol;
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                if (!new StringOps(fullname).contains(BoxesRunTime.boxToCharacter('.'))) {
                    String string = fullname;
                    symbol = this.EmptyPackageClass().info().decl(RootsBase.$anonfun$staticClass$1(this, string));
                } else {
                    Symbols.Symbol staticModuleOrClass_getModuleOrClass_getModuleOrClass_result;
                    int staticModuleOrClass_getModuleOrClass_getModuleOrClass_len = fullname.length();
                    int staticModuleOrClass_getModuleOrClass_getModuleOrClass_point = fullname.lastIndexOf(46, staticModuleOrClass_getModuleOrClass_getModuleOrClass_len - 1);
                    Symbols.ClassSymbol staticModuleOrClass_getModuleOrClass_getModuleOrClass_owner = staticModuleOrClass_getModuleOrClass_getModuleOrClass_point > 0 ? this.getModuleOrClass(fullname, staticModuleOrClass_getModuleOrClass_getModuleOrClass_point, (Function1<String, Names.Name>)(Function1<String, Names.TermName> & java.io.Serializable & Serializable)x$1 -> this.scala$reflect$internal$Mirrors$RootsBase$$$outer().newTermName((String)x$1)) : this.RootClass();
                    String string = fullname.substring(staticModuleOrClass_getModuleOrClass_getModuleOrClass_point + 1, staticModuleOrClass_getModuleOrClass_getModuleOrClass_len);
                    Names.TypeName staticModuleOrClass_getModuleOrClass_getModuleOrClass_name = RootsBase.$anonfun$staticClass$1(this, string);
                    Symbols.Symbol staticModuleOrClass_getModuleOrClass_getModuleOrClass_sym = staticModuleOrClass_getModuleOrClass_getModuleOrClass_owner.info().member(staticModuleOrClass_getModuleOrClass_getModuleOrClass_name);
                    Symbols.Symbol symbol2 = staticModuleOrClass_getModuleOrClass_getModuleOrClass_result = ((Names.Name)staticModuleOrClass_getModuleOrClass_getModuleOrClass_name).isTermName() ? staticModuleOrClass_getModuleOrClass_getModuleOrClass_sym.suchThat((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(x$2.hasFlag(256))) : staticModuleOrClass_getModuleOrClass_getModuleOrClass_sym;
                    Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().NoSymbol();
                    if (symbol2 == null ? noSymbol != null : !symbol2.equals(noSymbol)) {
                        symbol = staticModuleOrClass_getModuleOrClass_getModuleOrClass_result;
                    } else {
                        void var11_12;
                        void staticModuleOrClass_getModuleOrClass_getModuleOrClass_reflectSettingToBoolean_s;
                        MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().settings().debug();
                        if (MutableSettings$.MODULE$ == null) {
                            throw null;
                        }
                        if (BoxesRunTime.unboxToBoolean(staticModuleOrClass_getModuleOrClass_getModuleOrClass_reflectSettingToBoolean_s.value())) {
                            this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Types.Type> & java.io.Serializable & Serializable)() -> sym.info());
                            this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Scopes.Scope> & java.io.Serializable & Serializable)() -> sym.info().members());
                        }
                        Symbols.Symbol symbol3 = this.missingHook(staticModuleOrClass_getModuleOrClass_getModuleOrClass_owner, staticModuleOrClass_getModuleOrClass_getModuleOrClass_name);
                        if (symbol3 == null) {
                            throw null;
                        }
                        Symbols.Symbol staticModuleOrClass_getModuleOrClass_getModuleOrClass_orElse_this = symbol3;
                        if (staticModuleOrClass_getModuleOrClass_getModuleOrClass_orElse_this == staticModuleOrClass_getModuleOrClass_getModuleOrClass_orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                            throw MissingRequirementError$.MODULE$.notFound(new StringBuilder(4).append(staticModuleOrClass_getModuleOrClass_getModuleOrClass_name.isTermName() ? "object " : "class ").append(fullname).append(" in ").append(this).toString());
                        }
                        symbol = var11_12;
                    }
                }
                return this.ensureClassSymbol(fullname, symbol);
            }
            catch (MissingRequirementError mre) {
                throw new ScalaReflectionException(mre.msg());
            }
        }

        private Symbols.ModuleSymbol ensureModuleSymbol(String fullname, Symbols.Symbol sym, boolean allowPackages) {
            Symbols.ModuleSymbol moduleSymbol;
            block3: {
                block2: {
                    if (!(sym instanceof Symbols.ModuleSymbol)) break block2;
                    moduleSymbol = (Symbols.ModuleSymbol)sym;
                    if (allowPackages || !moduleSymbol.hasPackageFlag()) break block3;
                }
                throw MissingRequirementError$.MODULE$.notFound(new StringBuilder(7).append("object ").append(fullname).toString());
            }
            return moduleSymbol;
        }

        public Symbols.ModuleSymbol getModuleByName(Names.Name fullname) {
            return this.getModuleByName(fullname.toString());
        }

        /*
         * WARNING - void declaration
         */
        public Symbols.ModuleSymbol getModuleByName(String fullname) {
            Symbols.Symbol symbol;
            Symbols.Symbol getModuleOrClass_result;
            int getModuleOrClass_len = fullname.length();
            int getModuleOrClass_point = fullname.lastIndexOf(46, getModuleOrClass_len - 1);
            Symbols.ClassSymbol getModuleOrClass_owner = getModuleOrClass_point > 0 ? this.getModuleOrClass(fullname, getModuleOrClass_point, (Function1<String, Names.Name>)(Function1<String, Names.TermName> & java.io.Serializable & Serializable)x$1 -> this.scala$reflect$internal$Mirrors$RootsBase$$$outer().newTermName((String)x$1)) : this.RootClass();
            String string = fullname.substring(getModuleOrClass_point + 1, getModuleOrClass_len);
            Names.TermName getModuleOrClass_name = RootsBase.$anonfun$getModuleByName$1(this, string);
            Symbols.Symbol getModuleOrClass_sym = getModuleOrClass_owner.info().member(getModuleOrClass_name);
            Symbols.Symbol symbol2 = getModuleOrClass_result = ((Names.Name)getModuleOrClass_name).isTermName() ? getModuleOrClass_sym.suchThat((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(x$2.hasFlag(256))) : getModuleOrClass_sym;
            Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().NoSymbol();
            if (symbol2 == null ? noSymbol != null : !symbol2.equals(noSymbol)) {
                symbol = getModuleOrClass_result;
            } else {
                void var10_11;
                void getModuleOrClass_reflectSettingToBoolean_s;
                MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().settings().debug();
                if (MutableSettings$.MODULE$ == null) {
                    throw null;
                }
                if (BoxesRunTime.unboxToBoolean(getModuleOrClass_reflectSettingToBoolean_s.value())) {
                    this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Types.Type> & java.io.Serializable & Serializable)() -> sym.info());
                    this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Scopes.Scope> & java.io.Serializable & Serializable)() -> sym.info().members());
                }
                Symbols.Symbol symbol3 = this.missingHook(getModuleOrClass_owner, getModuleOrClass_name);
                if (symbol3 == null) {
                    throw null;
                }
                Symbols.Symbol getModuleOrClass_orElse_this = symbol3;
                if (getModuleOrClass_orElse_this == getModuleOrClass_orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                    throw MissingRequirementError$.MODULE$.notFound(new StringBuilder(4).append(getModuleOrClass_name.isTermName() ? "object " : "class ").append(fullname).append(" in ").append(this).toString());
                }
                symbol = var10_11;
            }
            return this.ensureModuleSymbol(fullname, symbol, true);
        }

        public Symbols.ModuleSymbol getRequiredModule(String fullname) {
            return this.getModuleByName(fullname);
        }

        public <T> Symbols.ModuleSymbol requiredModule(ClassTag<T> evidence$3) {
            String string = this.erasureName(evidence$3);
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return this.getRequiredModule(new StringOps(string).stripSuffix("$"));
        }

        public Symbols.Symbol getModuleIfDefined(String fullname) {
            try {
                return this.getModuleByName(fullname);
            }
            catch (MissingRequirementError missingRequirementError) {
                return this.scala$reflect$internal$Mirrors$RootsBase$$$outer().NoSymbol();
            }
        }

        public Symbols.Symbol getModuleIfDefined(Names.Name fullname) {
            return this.getModuleIfDefined(fullname.toString());
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public Symbols.ModuleSymbol staticModule(String fullname) {
            try {
                Symbols.Symbol symbol;
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                if (!new StringOps(fullname).contains(BoxesRunTime.boxToCharacter('.'))) {
                    String string = fullname;
                    symbol = this.EmptyPackageClass().info().decl(RootsBase.$anonfun$staticModule$1(this, string));
                } else {
                    Symbols.Symbol staticModuleOrClass_getModuleOrClass_getModuleOrClass_result;
                    int staticModuleOrClass_getModuleOrClass_getModuleOrClass_len = fullname.length();
                    int staticModuleOrClass_getModuleOrClass_getModuleOrClass_point = fullname.lastIndexOf(46, staticModuleOrClass_getModuleOrClass_getModuleOrClass_len - 1);
                    Symbols.ClassSymbol staticModuleOrClass_getModuleOrClass_getModuleOrClass_owner = staticModuleOrClass_getModuleOrClass_getModuleOrClass_point > 0 ? this.getModuleOrClass(fullname, staticModuleOrClass_getModuleOrClass_getModuleOrClass_point, (Function1<String, Names.Name>)(Function1<String, Names.TermName> & java.io.Serializable & Serializable)x$1 -> this.scala$reflect$internal$Mirrors$RootsBase$$$outer().newTermName((String)x$1)) : this.RootClass();
                    String string = fullname.substring(staticModuleOrClass_getModuleOrClass_getModuleOrClass_point + 1, staticModuleOrClass_getModuleOrClass_getModuleOrClass_len);
                    Names.TermName staticModuleOrClass_getModuleOrClass_getModuleOrClass_name = RootsBase.$anonfun$staticModule$1(this, string);
                    Symbols.Symbol staticModuleOrClass_getModuleOrClass_getModuleOrClass_sym = staticModuleOrClass_getModuleOrClass_getModuleOrClass_owner.info().member(staticModuleOrClass_getModuleOrClass_getModuleOrClass_name);
                    Symbols.Symbol symbol2 = staticModuleOrClass_getModuleOrClass_getModuleOrClass_result = ((Names.Name)staticModuleOrClass_getModuleOrClass_getModuleOrClass_name).isTermName() ? staticModuleOrClass_getModuleOrClass_getModuleOrClass_sym.suchThat((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(x$2.hasFlag(256))) : staticModuleOrClass_getModuleOrClass_getModuleOrClass_sym;
                    Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().NoSymbol();
                    if (symbol2 == null ? noSymbol != null : !symbol2.equals(noSymbol)) {
                        symbol = staticModuleOrClass_getModuleOrClass_getModuleOrClass_result;
                    } else {
                        void var11_12;
                        void staticModuleOrClass_getModuleOrClass_getModuleOrClass_reflectSettingToBoolean_s;
                        MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().settings().debug();
                        if (MutableSettings$.MODULE$ == null) {
                            throw null;
                        }
                        if (BoxesRunTime.unboxToBoolean(staticModuleOrClass_getModuleOrClass_getModuleOrClass_reflectSettingToBoolean_s.value())) {
                            this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Types.Type> & java.io.Serializable & Serializable)() -> sym.info());
                            this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Scopes.Scope> & java.io.Serializable & Serializable)() -> sym.info().members());
                        }
                        Symbols.Symbol symbol3 = this.missingHook(staticModuleOrClass_getModuleOrClass_getModuleOrClass_owner, staticModuleOrClass_getModuleOrClass_getModuleOrClass_name);
                        if (symbol3 == null) {
                            throw null;
                        }
                        Symbols.Symbol staticModuleOrClass_getModuleOrClass_getModuleOrClass_orElse_this = symbol3;
                        if (staticModuleOrClass_getModuleOrClass_getModuleOrClass_orElse_this == staticModuleOrClass_getModuleOrClass_getModuleOrClass_orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                            throw MissingRequirementError$.MODULE$.notFound(new StringBuilder(4).append(staticModuleOrClass_getModuleOrClass_getModuleOrClass_name.isTermName() ? "object " : "class ").append(fullname).append(" in ").append(this).toString());
                        }
                        symbol = var11_12;
                    }
                }
                return this.ensureModuleSymbol(fullname, symbol, false);
            }
            catch (MissingRequirementError mre) {
                throw new ScalaReflectionException(mre.msg());
            }
        }

        private Symbols.ModuleSymbol ensurePackageSymbol(String fullname, Symbols.Symbol sym, boolean allowModules) {
            Symbols.ModuleSymbol moduleSymbol;
            block3: {
                block2: {
                    if (!(sym instanceof Symbols.ModuleSymbol)) break block2;
                    moduleSymbol = (Symbols.ModuleSymbol)sym;
                    if (allowModules || moduleSymbol.hasPackageFlag()) break block3;
                }
                throw MissingRequirementError$.MODULE$.notFound(new StringBuilder(8).append("package ").append(fullname).toString());
            }
            return moduleSymbol;
        }

        public Symbols.ModuleSymbol getPackage(Names.TermName fullname) {
            return this.getPackage(fullname.toString());
        }

        /*
         * WARNING - void declaration
         */
        public Symbols.ModuleSymbol getPackage(String fullname) {
            Symbols.Symbol symbol;
            Symbols.Symbol getModuleOrClass_getModuleOrClass_result;
            int getModuleOrClass_getModuleOrClass_len = fullname.length();
            int getModuleOrClass_getModuleOrClass_point = fullname.lastIndexOf(46, getModuleOrClass_getModuleOrClass_len - 1);
            Symbols.ClassSymbol getModuleOrClass_getModuleOrClass_owner = getModuleOrClass_getModuleOrClass_point > 0 ? this.getModuleOrClass(fullname, getModuleOrClass_getModuleOrClass_point, (Function1<String, Names.Name>)(Function1<String, Names.TermName> & java.io.Serializable & Serializable)x$1 -> this.scala$reflect$internal$Mirrors$RootsBase$$$outer().newTermName((String)x$1)) : this.RootClass();
            String string = fullname.substring(getModuleOrClass_getModuleOrClass_point + 1, getModuleOrClass_getModuleOrClass_len);
            Names.TermName getModuleOrClass_getModuleOrClass_name = RootsBase.$anonfun$getPackage$1(this, string);
            Symbols.Symbol getModuleOrClass_getModuleOrClass_sym = getModuleOrClass_getModuleOrClass_owner.info().member(getModuleOrClass_getModuleOrClass_name);
            Symbols.Symbol symbol2 = getModuleOrClass_getModuleOrClass_result = ((Names.Name)getModuleOrClass_getModuleOrClass_name).isTermName() ? getModuleOrClass_getModuleOrClass_sym.suchThat((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(x$2.hasFlag(256))) : getModuleOrClass_getModuleOrClass_sym;
            Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().NoSymbol();
            if (symbol2 == null ? noSymbol != null : !symbol2.equals(noSymbol)) {
                symbol = getModuleOrClass_getModuleOrClass_result;
            } else {
                void var10_11;
                void getModuleOrClass_getModuleOrClass_reflectSettingToBoolean_s;
                MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().settings().debug();
                if (MutableSettings$.MODULE$ == null) {
                    throw null;
                }
                if (BoxesRunTime.unboxToBoolean(getModuleOrClass_getModuleOrClass_reflectSettingToBoolean_s.value())) {
                    this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Types.Type> & java.io.Serializable & Serializable)() -> sym.info());
                    this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Scopes.Scope> & java.io.Serializable & Serializable)() -> sym.info().members());
                }
                Symbols.Symbol symbol3 = this.missingHook(getModuleOrClass_getModuleOrClass_owner, getModuleOrClass_getModuleOrClass_name);
                if (symbol3 == null) {
                    throw null;
                }
                Symbols.Symbol getModuleOrClass_getModuleOrClass_orElse_this = symbol3;
                if (getModuleOrClass_getModuleOrClass_orElse_this == getModuleOrClass_getModuleOrClass_orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                    throw MissingRequirementError$.MODULE$.notFound(new StringBuilder(4).append(getModuleOrClass_getModuleOrClass_name.isTermName() ? "object " : "class ").append(fullname).append(" in ").append(this).toString());
                }
                symbol = var10_11;
            }
            return this.ensurePackageSymbol(fullname, symbol, true);
        }

        public Symbols.Symbol getPackageIfDefined(Names.TermName fullname) {
            return this.getPackageIfDefined(fullname.toString());
        }

        public Symbols.Symbol getPackageIfDefined(String fullname) {
            try {
                return this.getPackage(fullname);
            }
            catch (MissingRequirementError missingRequirementError) {
                return this.scala$reflect$internal$Mirrors$RootsBase$$$outer().NoSymbol();
            }
        }

        public Symbols.ModuleSymbol getRequiredPackage(String fullname) {
            return this.getPackage(fullname);
        }

        public Symbols.ModuleSymbol getPackageObject(Names.TermName fullname) {
            return this.getPackageObject(fullname.toString());
        }

        public Symbols.ModuleSymbol getPackageObject(String fullname) {
            Symbols.Symbol symbol = this.getPackage(fullname).packageObject();
            if (!(symbol instanceof Symbols.ModuleSymbol)) {
                throw MissingRequirementError$.MODULE$.notFound(new StringBuilder(15).append("package object ").append(fullname).toString());
            }
            Symbols.ModuleSymbol moduleSymbol = (Symbols.ModuleSymbol)symbol;
            return moduleSymbol;
        }

        public Symbols.Symbol getPackageObjectIfDefined(Names.TermName fullname) {
            return this.getPackageObjectIfDefined(fullname.toString());
        }

        public Symbols.Symbol getPackageObjectIfDefined(String fullname) {
            try {
                return this.getPackageObject(fullname);
            }
            catch (MissingRequirementError missingRequirementError) {
                return this.scala$reflect$internal$Mirrors$RootsBase$$$outer().NoSymbol();
            }
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public Symbols.ModuleSymbol staticPackage(String fullname) {
            try {
                Symbols.Symbol symbol;
                Symbols.Symbol getModuleOrClass_result;
                String string = fullname.toString();
                int getModuleOrClass_len = fullname.length();
                int getModuleOrClass_point = fullname.lastIndexOf(46, getModuleOrClass_len - 1);
                Symbols.ClassSymbol getModuleOrClass_owner = getModuleOrClass_point > 0 ? this.getModuleOrClass(fullname, getModuleOrClass_point, (Function1<String, Names.Name>)(Function1<String, Names.TermName> & java.io.Serializable & Serializable)x$1 -> this.scala$reflect$internal$Mirrors$RootsBase$$$outer().newTermName((String)x$1)) : this.RootClass();
                String string2 = fullname.substring(getModuleOrClass_point + 1, getModuleOrClass_len);
                Names.TermName getModuleOrClass_name = RootsBase.$anonfun$staticPackage$1(this, string2);
                Symbols.Symbol getModuleOrClass_sym = getModuleOrClass_owner.info().member(getModuleOrClass_name);
                Symbols.Symbol symbol2 = getModuleOrClass_result = ((Names.Name)getModuleOrClass_name).isTermName() ? getModuleOrClass_sym.suchThat((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(x$2.hasFlag(256))) : getModuleOrClass_sym;
                Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().NoSymbol();
                if (symbol2 == null ? noSymbol != null : !symbol2.equals(noSymbol)) {
                    symbol = getModuleOrClass_result;
                } else {
                    void var11_11;
                    void getModuleOrClass_reflectSettingToBoolean_s;
                    MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().settings().debug();
                    if (MutableSettings$.MODULE$ == null) {
                        throw null;
                    }
                    if (BoxesRunTime.unboxToBoolean(getModuleOrClass_reflectSettingToBoolean_s.value())) {
                        this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Types.Type> & java.io.Serializable & Serializable)() -> sym.info());
                        this.scala$reflect$internal$Mirrors$RootsBase$$$outer().log((Function0<Object>)(Function0<Scopes.Scope> & java.io.Serializable & Serializable)() -> sym.info().members());
                    }
                    Symbols.Symbol symbol3 = this.missingHook(getModuleOrClass_owner, getModuleOrClass_name);
                    if (symbol3 == null) {
                        throw null;
                    }
                    Symbols.Symbol getModuleOrClass_orElse_this = symbol3;
                    if (getModuleOrClass_orElse_this == getModuleOrClass_orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                        throw MissingRequirementError$.MODULE$.notFound(new StringBuilder(4).append(getModuleOrClass_name.isTermName() ? "object " : "class ").append(fullname).append(" in ").append(this).toString());
                    }
                    symbol = var11_11;
                }
                return this.ensurePackageSymbol(string, symbol, false);
            }
            catch (MissingRequirementError mre) {
                throw new ScalaReflectionException(mre.msg());
            }
        }

        public <T> String erasureName(ClassTag<T> evidence$4) {
            return RootsBase.erasureString$1(package$.MODULE$.classTag(evidence$4).runtimeClass());
        }

        public final Symbols.Symbol wrapMissing(Function0<Symbols.Symbol> body) {
            try {
                return body.apply();
            }
            catch (MissingRequirementError missingRequirementError) {
                return this.scala$reflect$internal$Mirrors$RootsBase$$$outer().NoSymbol();
            }
        }

        public void init() {
            if (this.initialized) {
                return;
            }
            this.EmptyPackageClass().setInfo(this.rootLoader());
            this.EmptyPackage().setInfo(this.EmptyPackageClass().tpe());
            this.scala$reflect$internal$Mirrors$RootsBase$$$outer().connectModuleToClass(this.EmptyPackage(), this.EmptyPackageClass());
            this.scala$reflect$internal$Mirrors$RootsBase$$$outer().connectModuleToClass(this.RootPackage(), this.RootClass());
            this.RootClass().info().decls().enter(this.EmptyPackage());
            this.RootClass().info().decls().enter(this.RootPackage());
            Symbols.Symbol symbol = this.rootOwner;
            Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().NoSymbol();
            if (symbol == null ? noSymbol != null : !symbol.equals(noSymbol)) {
                List list = this.scala$reflect$internal$Mirrors$RootsBase$$$outer().definitions().syntheticCoreClasses();
                if (list == null) {
                    throw null;
                }
                List foreach_these = list;
                while (!foreach_these.isEmpty()) {
                    Symbols.TypeSymbol typeSymbol = foreach_these.head();
                    RootsBase.$anonfun$init$1(this, typeSymbol);
                    foreach_these = (List)foreach_these.tail();
                }
            }
            this.initialized = true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Mirrors$RootsBase$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ Names.TypeName $anonfun$getClassByName$1(RootsBase $this, String x$3) {
            return $this.scala$reflect$internal$Mirrors$RootsBase$$$outer().newTypeName(x$3);
        }

        public static final /* synthetic */ Names.TypeName $anonfun$getRequiredClass$1(RootsBase $this, String x$4) {
            return $this.scala$reflect$internal$Mirrors$RootsBase$$$outer().newTypeName(x$4);
        }

        public static final /* synthetic */ Names.TypeName $anonfun$staticClass$1(RootsBase $this, String x$7) {
            return $this.scala$reflect$internal$Mirrors$RootsBase$$$outer().newTypeName(x$7);
        }

        public static final /* synthetic */ Names.TermName $anonfun$getModuleByName$1(RootsBase $this, String x$8) {
            return $this.scala$reflect$internal$Mirrors$RootsBase$$$outer().newTermName(x$8);
        }

        public static final /* synthetic */ Names.TermName $anonfun$staticModule$1(RootsBase $this, String x$9) {
            return $this.scala$reflect$internal$Mirrors$RootsBase$$$outer().newTermName(x$9);
        }

        public static final /* synthetic */ Names.TermName $anonfun$getPackage$1(RootsBase $this, String x$10) {
            return $this.scala$reflect$internal$Mirrors$RootsBase$$$outer().newTermName(x$10);
        }

        public static final /* synthetic */ Names.TermName $anonfun$staticPackage$1(RootsBase $this, String x$11) {
            return $this.scala$reflect$internal$Mirrors$RootsBase$$$outer().newTermName(x$11);
        }

        private static final String erasureString$1(Class clazz) {
            if (clazz.isArray()) {
                return new StringBuilder(7).append("Array[").append(RootsBase.erasureString$1(clazz.getComponentType())).append("]").toString();
            }
            return clazz.getName();
        }

        public static final /* synthetic */ String $anonfun$init$2(Symbols.TypeSymbol theirSym$1, Symbols.Symbol theirOwner$1) {
            return new StringBuilder(26).append("theirSym = ").append(theirSym$1).append(", theirOwner = ").append(theirOwner$1).toString();
        }

        /*
         * WARNING - void declaration
         */
        public static final /* synthetic */ Symbols.TypeSymbol $anonfun$init$1(RootsBase $this, Symbols.TypeSymbol theirSym) {
            void assert_assertion;
            Symbols.Symbol theirOwner = theirSym.owner();
            SymbolTable symbolTable = $this.scala$reflect$internal$Mirrors$RootsBase$$$outer();
            boolean bl = theirOwner.isPackageClass();
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable assert_this = symbolTable;
            if (assert_assertion == false) {
                throw assert_this.throwAssertionError(RootsBase.$anonfun$init$2(theirSym, theirOwner));
            }
            return $this.staticPackage(theirOwner.fullName()).moduleClass().info().decls().enterIfNew(theirSym);
        }

        public RootsBase(SymbolTable $outer, Symbols.Symbol rootOwner) {
            this.rootOwner = rootOwner;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            this.initialized = false;
        }
    }
}

