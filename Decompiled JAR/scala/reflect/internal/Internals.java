/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Function0;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.Seq;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Map;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.Manifest;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Internals;
import scala.reflect.api.Scopes;
import scala.reflect.api.Symbols;
import scala.reflect.api.Trees;
import scala.reflect.api.TypeTags;
import scala.reflect.api.Types;
import scala.reflect.internal.AnnotationInfos;
import scala.reflect.internal.CapturedVariables;
import scala.reflect.internal.Constants;
import scala.reflect.internal.Definitions;
import scala.reflect.internal.FlagSets;
import scala.reflect.internal.Importers;
import scala.reflect.internal.Names;
import scala.reflect.internal.Positions;
import scala.reflect.internal.ReificationSupport;
import scala.reflect.internal.Scopes;
import scala.reflect.internal.StdAttachments;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Trees;
import scala.reflect.internal.Trees$DefDef$;
import scala.reflect.internal.Types;
import scala.reflect.internal.util.Position;
import scala.reflect.macros.Attachments;
import scala.reflect.macros.Universe;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u0019}d!C8q!\u0003\r\ta\u001eD<\u0011\u001d\t\u0019\u0001\u0001C\u0001\u0003\u000b)a!!\u0004\u0001\u0001\u0005=\u0001\"C9\u0001\u0011\u000b\u0007I\u0011AA\u0010\u000b\u0019\t\u0019\u0003\u0001\u0001\u0002&!Q\u00111\u0006\u0001\t\u0006\u0004%\t!!\f\u0007\u0013\u0005E\u0002\u0001%A\u0002\u0002\u0005M\u0002bBA\u0002\r\u0011\u0005\u0011Q\u0001\u0005\u000b\u0003k1\u0001R1A\u0005\u0002\u0005]\u0002bBA \r\u0011\u0005\u0011\u0011\t\u0005\b\u0003C2A\u0011AA2\u0011\u001d\t\u0019I\u0002C\u0001\u0003\u000bCq!!%\u0007\t\u0003\t\u0019\nC\u0004\u0002\u001c\u001a!\t!!(\t\u000f\u0005\u0005g\u0001\"\u0001\u0002D\"9\u0011q\u001a\u0004\u0005\u0002\u0005E\u0007bBAo\r\u0011\u0005\u0011q\u001c\u0005\b\u0003g4A\u0011AA{\u0011\u001d\u0011)A\u0002C\u0001\u0005\u000fAqA!\n\u0007\t\u0003\u00119\u0003C\u0004\u0003V\u0019!\tAa\u0016\t\u000f\t-d\u0001\"\u0001\u0003n!9!q\u000f\u0004\u0005\u0002\te\u0004b\u0002BB\r\u0011\u0005!Q\u0011\u0005\b\u0005\u001b3A\u0011\u0001BH\u0011\u001d\u00119J\u0002C\u0001\u00053CqAa*\u0007\t\u0003\u0011I\u000bC\u0004\u00030\u001a!\tA!-\t\u000f\tUf\u0001\"\u0001\u00038\"9!1\u0018\u0004\u0005\u0002\tu\u0006b\u0002Bi\r\u0011\u0005!1\u001b\u0005\b\u0005?4A\u0011\u0001Bq\u0011\u001d\u0011yN\u0002C\u0001\u0005_DqAa=\u0007\t\u0003\u0011)\u0010C\u0004\u0003t\u001a!\taa\u0005\t\u000f\tMh\u0001\"\u0001\u0004\u001c!9!1\u001f\u0004\u0005\u0002\r\r\u0002b\u0002Bz\r\u0011\u00051\u0011\u0006\u0005\b\u0007o1A\u0011AB\u001d\u0011\u001d\u00199D\u0002C\u0001\u0007\u000bBqa!\u0013\u0007\t\u0003\u0019Y\u0005C\u0004\u0004\\\u0019!\ta!\u0018\t\u0015\r-d\u0001#b\u0001\n\u0003\u0019i\u0007C\u0004\u0004|\u0019!\ta! \t\u000f\r%e\u0001\"\u0001\u0004\f\"91q\u0012\u0004\u0005\u0002\rE\u0005bBBK\r\u0011\u00051q\u0013\u0005\b\u000773A\u0011ABO\u0011%\u00199MBI\u0001\n\u0003\u0019I\rC\u0005\u0004`\u001a\t\n\u0011\"\u0001\u0004b\"91Q\u001d\u0004\u0005\u0002\r\u001d\b\"\u0003C\u0005\rE\u0005I\u0011ABe\u0011%!YABI\u0001\n\u0003\u0019\t\u000fC\u0004\u0005\u000e\u0019!\t\u0001b\u0004\t\u0013\u0011}a!%A\u0005\u0002\r%\u0007\"\u0003C\u0011\rE\u0005I\u0011ABq\u0011\u001d!\u0019C\u0002C\u0001\tKA\u0011\u0002b\u000f\u0007#\u0003%\ta!3\t\u0013\u0011ub!%A\u0005\u0002\r\u0005\bb\u0002C \r\u0011\u0005A\u0011\t\u0005\n\t\u00172\u0011\u0013!C\u0001\u0007\u0013D\u0011\u0002\"\u0014\u0007#\u0003%\ta!9\t\u000f\u0011=c\u0001\"\u0001\u0005R!IAq\u000f\u0004\u0012\u0002\u0013\u00051\u0011\u001d\u0005\n\ts2\u0011\u0013!C\u0001\twBq\u0001b \u0007\t\u0003!\t\tC\u0005\u0005\n\u001a\t\n\u0011\"\u0001\u0004b\"IA1\u0012\u0004\u0012\u0002\u0013\u0005A1\u0010\u0005\b\t\u001b3A\u0011\u0001CH\u0011\u001d!\u0019J\u0002C\u0001\t+Cq\u0001\"'\u0007\t\u0003!Y\nC\u0004\u0005 \u001a!\t\u0001\")\t\u000f\u0011\u001df\u0001\"\u0001\u0005*\"9Aq\u0015\u0004\u0005\u0002\u0011=\u0006b\u0002CT\r\u0011\u0005AQ\u0017\u0005\b\u0007w3A\u0011\u0001C^\u0011\u001d\u0011)A\u0002C\u0001\t\u007fCqA!\n\u0007\t\u0003!I\rC\u0004\u0003V\u0019!\t\u0001b8\t\u000f\u0011Mh\u0001\"\u0001\u0005v\"9Aq \u0004\u0005\u0002\u0015\u0005\u0001bBC\u0006\r\u0011\u0005QQ\u0002\u0005\b\u000bG1A\u0011AC\u0013\u0011\u001d)iC\u0002C\u0001\u000b_Aq!b\u000e\u0007\t\u0003)I\u0004C\u0004\u0006B\u0019!\t!b\u0011\t\u000f\u0015-c\u0001\"\u0001\u0006N!9Q\u0011\u000b\u0004\u0005\u0002\u0015M\u0003bBC.\r\u0011\u0005QQ\f\u0005\b\u000bO2A\u0011AC5\u0011\u001d)iH\u0002C\u0001\u000b\u007fBq!\"#\u0007\t\u0003)Y\tC\u0004\u0006\n\u001a!\t!b'\t\u000f\u0015%e\u0001\"\u0001\u0006$\"9Q\u0011\u0012\u0004\u0005\u0002\u0015-\u0006bBCE\r\u0011\u0005Q1\u0017\u0005\b\u000b{3A\u0011AC`\u0011\u001d)iL\u0002C\u0001\u000b\u000bDq!b3\u0007\t\u0003)i\rC\u0004\u0006^\u001a!\t!b8\t\u000f\u00155h\u0001\"\u0001\u0006p\"9Q\u0011 \u0004\u0005\u0002\u0015m\bb\u0002D\u0005\r\u0011\u0005a1\u0002\u0005\b\r71A\u0011\u0001D\u000f\u0011\u001d19C\u0002C\u0001\rSAqA\"\u000f\u0007\t\u00031Y\u0004C\u0004\u0007L\u0019!\tA\"\u0014\t\u000f\u0019ec\u0001\"\u0001\u0007\\\u00151aq\r\u0004\u0001\rSB!B\"\u001d\u0007\u0011\u000b\u0007I\u0011\u0001D:\u0011)\u0019\u0019\b\u0001EC\u0002\u0013\u00051Q\u000e\u0002\n\u0013:$XM\u001d8bYNT!!\u001d:\u0002\u0011%tG/\u001a:oC2T!a\u001d;\u0002\u000fI,g\r\\3di*\tQ/A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0007\u0001AH\u0010\u0005\u0002zu6\tA/\u0003\u0002|i\n1\u0011I\\=SK\u001a\u00042!`A\u0001\u001b\u0005q(BA@s\u0003\r\t\u0007/[\u0005\u0003_z\fa\u0001J5oSR$CCAA\u0004!\rI\u0018\u0011B\u0005\u0004\u0003\u0017!(\u0001B+oSR\u0014\u0001\"\u00138uKJt\u0017\r\u001c\t\u0005\u0003#\t\u0019\"D\u0001\u0001\u0013\u0011\t)\"a\u0006\u0003!5\u000b7M]8J]R,'O\\1m\u0003BL\u0017\u0002BA\r\u00037\u0011\u0001\"\u00168jm\u0016\u00148/\u001a\u0006\u0004\u0003;\u0011\u0018AB7bGJ|7/\u0006\u0002\u0002\"A\u0019\u0011\u0011\u0003\u0002\u0003\r\r{W\u000e]1u!\u0011\t\t\"a\n\n\t\u0005%\u0012q\u0003\u0002\u000f\u001b\u0006\u001c'o\\\"p[B\fG/\u00119j\u0003\u0019\u0019w.\u001c9biV\u0011\u0011q\u0006\t\u0004\u0003#!!aE*z[\n|G\u000eV1cY\u0016Le\u000e^3s]\u0006d7\u0003\u0002\u0004y\u0003\u001f\t!C]3jM&\u001c\u0017\r^5p]N+\b\u000f]8siV\u0011\u0011\u0011\b\t\u0005\u0003#\tY$\u0003\u0003\u0002>\u0005\u0005!!\u0006*fS\u001aL7-\u0019;j_:\u001cV\u000f\u001d9peR\f\u0005/[\u0001\u000fGJ,\u0017\r^3J[B|'\u000f^3s)\u0011\t\u0019%!\u0017\u0013\t\u0005\u0015\u0013\u0011\n\u0004\u0007\u0003\u000f2\u0001!a\u0011\u0003\u0019q\u0012XMZ5oK6,g\u000e\u001e \u0011\t\u0005E\u00111J\u0005\u0005\u0003\u001b\n\tA\u0001\u0005J[B|'\u000f^3s\u0011)\t\t&!\u0012C\u0002\u001b\u0005\u00131K\u0001\u0005MJ|W.\u0006\u0002\u0002V9!\u0011qKA-\u0019\u0001Aq!a\u0017\n\u0001\u0004\ti&A\u0003ge>l\u0007\u0007E\u0002~\u0003?J1!!\u0007\u007f\u00031qWm^*d_B,w+\u001b;i)\u0011\t)'a\u001c\u0011\t\u0005E\u0011qM\u0005\u0005\u0003S\nYGA\u0003TG>\u0004X-C\u0002\u0002nA\u0014aaU2pa\u0016\u001c\bbBA9\u0015\u0001\u0007\u00111O\u0001\u0006K2,Wn\u001d\t\u0006s\u0006U\u0014\u0011P\u0005\u0004\u0003o\"(A\u0003\u001fsKB,\u0017\r^3e}A!\u0011\u0011CA>\u0013\u0011\ti(a \u0003\rMKXNY8m\u0013\r\t\t\t\u001d\u0002\b'fl'm\u001c7t\u0003\u0015)g\u000e^3s)\u0019\t9)!#\u0002\u000e:!\u0011qKAE\u0011\u001d\tYi\u0003a\u0001\u0003K\nQa]2pa\u0016Dq!a$\f\u0001\u0004\tI(A\u0002ts6\fa!\u001e8mS:\\GCBAK\u0003/\u000bIJ\u0004\u0003\u0002X\u0005]\u0005bBAF\u0019\u0001\u0007\u0011Q\r\u0005\b\u0003\u001fc\u0001\u0019AA=\u0003%1'/Z3UKJl7\u000f\u0006\u0003\u0002 \u0006M\u0006CBAQ\u0003O\u000biKD\u0002z\u0003GK1!!*u\u0003\u001d\u0001\u0018mY6bO\u0016LA!!+\u0002,\n!A*[:u\u0015\r\t)\u000b\u001e\t\u0005\u0003#\ty+\u0003\u0003\u00022\u0006}$A\u0004$sK\u0016$VM]7Ts6\u0014w\u000e\u001c\u0005\b\u0003kk\u0001\u0019AA\\\u0003\u0011!(/Z3\u0011\t\u0005E\u0011\u0011X\u0005\u0005\u0003w\u000biL\u0001\u0003Ue\u0016,\u0017bAA`a\n)AK]3fg\u0006IaM]3f)f\u0004Xm\u001d\u000b\u0005\u0003\u000b\fi\r\u0005\u0004\u0002\"\u0006\u001d\u0016q\u0019\t\u0005\u0003#\tI-\u0003\u0003\u0002L\u0006}$A\u0004$sK\u0016$\u0016\u0010]3Ts6\u0014w\u000e\u001c\u0005\b\u0003ks\u0001\u0019AA\\\u0003E\u0019XOY:uSR,H/Z*z[\n|Gn\u001d\u000b\t\u0003o\u000b\u0019.!6\u0002Z\"9\u0011QW\bA\u0002\u0005]\u0006bBA)\u001f\u0001\u0007\u0011q\u001b\t\u0007\u0003C\u000b9+!\u001f\t\u000f\u0005mw\u00021\u0001\u0002X\u0006\u0011Ao\\\u0001\u0010gV\u00147\u000f^5ukR,G+\u001f9fgRA\u0011qWAq\u0003G\f)\u000fC\u0004\u00026B\u0001\r!a.\t\u000f\u0005E\u0003\u00031\u0001\u0002X\"9\u00111\u001c\tA\u0002\u0005\u001d\bCBAQ\u0003O\u000bI\u000f\u0005\u0003\u0002\u0012\u0005-\u0018\u0002BAw\u0003_\u0014A\u0001V=qK&\u0019\u0011\u0011\u001f9\u0003\u000bQK\b/Z:\u0002\u001dM,(m\u001d;jiV$X\r\u00165jgRA\u0011qWA|\u0003s\fi\u0010C\u0004\u00026F\u0001\r!a.\t\u000f\u0005m\u0018\u00031\u0001\u0002z\u0005)1\r\\1{u\"A\u00111\\\t\u0005\u0002\u0004\ty\u0010E\u0003z\u0005\u0003\t9,C\u0002\u0003\u0004Q\u0014\u0001\u0002\u00102z]\u0006lWMP\u0001\fCR$\u0018m\u00195nK:$8\u000f\u0006\u0003\u0003\n\t\r\"\u0003\u0002B\u0006\u0005\u001b1a!a\u0012\u0007\u0001\t%\u0001\u0003\u0002B\b\u0005#i!!a\u0007\n\t\tM\u00111\u0004\u0002\f\u0003R$\u0018m\u00195nK:$8/B\u0004\u0003\u0018\t-\u0001E!\u0007\u0003\u0007A{7\u000f\u0005\u0003\u0002\u0012\tm\u0011\u0002\u0002B\u000f\u0005?\u0011\u0001\u0002U8tSRLwN\\\u0005\u0004\u0005C\u0001(!\u0003)pg&$\u0018n\u001c8t\u0011\u001d\t)L\u0005a\u0001\u0003o\u000b\u0001#\u001e9eCR,\u0017\t\u001e;bG\"lWM\u001c;\u0016\t\t%\"q\b\u000b\u0007\u0005W\u0011yC!\u0015\u0015\t\t5\"\u0011\u0007\b\u0005\u0003/\u0012y\u0003C\u0004\u00026N\u0001\r!a.\t\u0013\tM2#!AA\u0004\tU\u0012AC3wS\u0012,gnY3%cA1!q\u0007B\u001d\u0005{i\u0011A]\u0005\u0004\u0005w\u0011(\u0001C\"mCN\u001cH+Y4\u0011\t\u0005]#q\b\u0003\b\u0005\u0003\u001a\"\u0019\u0001B\"\u0005\u0005!\u0016\u0003\u0002B#\u0005\u0017\u00022!\u001fB$\u0013\r\u0011I\u0005\u001e\u0002\b\u001d>$\b.\u001b8h!\rI(QJ\u0005\u0004\u0005\u001f\"(aA!os\"9!1K\nA\u0002\tu\u0012AC1ui\u0006\u001c\u0007.\\3oi\u0006\u0001\"/Z7pm\u0016\fE\u000f^1dQ6,g\u000e^\u000b\u0005\u00053\u0012I\u0007\u0006\u0003\u0003\\\t}C\u0003\u0002B/\u0005CrA!a\u0016\u0003`!9\u0011Q\u0017\u000bA\u0002\u0005]\u0006\"\u0003B2)\u0005\u0005\t9\u0001B3\u0003))g/\u001b3f]\u000e,GE\r\t\u0007\u0005o\u0011IDa\u001a\u0011\t\u0005]#\u0011\u000e\u0003\b\u0005\u0003\"\"\u0019\u0001B\"\u0003\u0019\u0019X\r\u001e)pgR1!q\u000eB9\u0005grA!a\u0016\u0003r!9\u0011QW\u000bA\u0002\u0005]\u0006b\u0002B;+\u0001\u0007!\u0011D\u0001\u0007]\u0016<\bo\\:\u0002\u000fM,G\u000fV=qKR1!1\u0010B?\u0005\u007frA!a\u0016\u0003~!9\u0011Q\u0017\fA\u0002\u0005]\u0006b\u0002BA-\u0001\u0007\u0011\u0011^\u0001\u0003iB\f!\u0002Z3gS:,G+\u001f9f)\u0019\u00119I!#\u0003\f:!\u0011q\u000bBE\u0011\u001d\t)l\u0006a\u0001\u0003oCqA!!\u0018\u0001\u0004\tI/A\u0005tKR\u001c\u00160\u001c2pYR1!\u0011\u0013BJ\u0005+sA!a\u0016\u0003\u0014\"9\u0011Q\u0017\rA\u0002\u0005]\u0006bBAH1\u0001\u0007\u0011\u0011P\u0001\fg\u0016$xJ]5hS:\fG\u000e\u0006\u0004\u0003\u001c\n\u0005&Q\u0015\t\u0005\u0003#\u0011i*\u0003\u0003\u0003 \u0006u&\u0001\u0003+za\u0016$&/Z3\t\u000f\t\r\u0016\u00041\u0001\u0003\u001c\u0006\u0011A\u000f\u001e\u0005\b\u0003kK\u0002\u0019AA\\\u0003=\u0019\u0017\r\u001d;ve\u00164\u0016M]5bE2,G\u0003BA\u0004\u0005WCqA!,\u001b\u0001\u0004\tI(\u0001\u0003wE2,\u0017!\u0007:fM\u0016\u0014XM\\2f\u0007\u0006\u0004H/\u001e:fIZ\u000b'/[1cY\u0016$B!a.\u00034\"9!QV\u000eA\u0002\u0005e\u0014\u0001F2baR,(/\u001a3WCJL\u0017M\u00197f)f\u0004X\r\u0006\u0003\u0002j\ne\u0006b\u0002BW9\u0001\u0007\u0011\u0011P\u0001\tG2\f7o\u001d#fMR1!q\u0018Bc\u0005\u000f\u0004B!!\u0005\u0003B&!!1YA_\u0005!\u0019E.Y:t\t\u00164\u0007bBAH;\u0001\u0007\u0011\u0011\u0010\u0005\b\u0005\u0013l\u0002\u0019\u0001Bf\u0003\u0011IW\u000e\u001d7\u0011\t\u0005E!QZ\u0005\u0005\u0005\u001f\fiL\u0001\u0005UK6\u0004H.\u0019;f\u0003%iw\u000eZ;mK\u0012+g\r\u0006\u0004\u0003V\nm'Q\u001c\t\u0005\u0003#\u00119.\u0003\u0003\u0003Z\u0006u&!C'pIVdW\rR3g\u0011\u001d\tyI\ba\u0001\u0003sBqA!3\u001f\u0001\u0004\u0011Y-\u0001\u0004wC2$UM\u001a\u000b\u0007\u0005G\u0014IOa;\u0011\t\u0005E!Q]\u0005\u0005\u0005O\fiL\u0001\u0004WC2$UM\u001a\u0005\b\u0003\u001f{\u0002\u0019AA=\u0011\u001d\u0011io\ba\u0001\u0003o\u000b1A\u001d5t)\u0011\u0011\u0019O!=\t\u000f\u0005=\u0005\u00051\u0001\u0002z\u00051A-\u001a4EK\u001a$\"Ba>\u0003~\n}8\u0011BB\t!\u0011\t\tB!?\n\t\tm\u0018Q\u0018\u0002\u0007\t\u00164G)\u001a4\t\u000f\u0005=\u0015\u00051\u0001\u0002z!91\u0011A\u0011A\u0002\r\r\u0011\u0001B7pIN\u0004B!!\u0005\u0004\u0006%!1qAA_\u0005%iu\u000eZ5gS\u0016\u00148\u000fC\u0004\u0004\f\u0005\u0002\ra!\u0004\u0002\u0011Y\u0004\u0018M]1ngN\u0004b!!)\u0002(\u000e=\u0001CBAQ\u0003O\u0013\u0019\u000fC\u0004\u0003n\u0006\u0002\r!a.\u0015\u0011\t]8QCB\f\u00073Aq!a$#\u0001\u0004\tI\bC\u0004\u0004\f\t\u0002\ra!\u0004\t\u000f\t5(\u00051\u0001\u00028RA!q_B\u000f\u0007?\u0019\t\u0003C\u0004\u0002\u0010\u000e\u0002\r!!\u001f\t\u000f\r\u00051\u00051\u0001\u0004\u0004!9!Q^\u0012A\u0002\u0005]FC\u0002B|\u0007K\u00199\u0003C\u0004\u0002\u0010\u0012\u0002\r!!\u001f\t\u000f\t5H\u00051\u0001\u00028R1!q_B\u0016\u0007[Aq!a$&\u0001\u0004\tI\bC\u0004\u0003n\u0016\u0002\raa\f\u0011\u000fe\u001c\td!\u000e\u00028&\u001911\u0007;\u0003\u0013\u0019+hn\u0019;j_:\f\u0004CBAQ\u0003O\u000b9.A\u0004usB,G)\u001a4\u0015\r\rm2\u0011IB\"!\u0011\t\tb!\u0010\n\t\r}\u0012Q\u0018\u0002\b)f\u0004X\rR3g\u0011\u001d\tyI\na\u0001\u0003sBqA!<'\u0001\u0004\t9\f\u0006\u0003\u0004<\r\u001d\u0003bBAHO\u0001\u0007\u0011\u0011P\u0001\tY\u0006\u0014W\r\u001c#fMRA1QJB*\u0007+\u001aI\u0006\u0005\u0003\u0002\u0012\r=\u0013\u0002BB)\u0003{\u0013\u0001\u0002T1cK2$UM\u001a\u0005\b\u0003\u001fC\u0003\u0019AA=\u0011\u001d\u00199\u0006\u000ba\u0001\u0003/\fa\u0001]1sC6\u001c\bb\u0002BwQ\u0001\u0007\u0011qW\u0001\fG\"\fgnZ3Po:,'\u000f\u0006\u0005\u0004`\r\u000541MB4\u001d\u0011\t9f!\u0019\t\u000f\u0005U\u0016\u00061\u0001\u00028\"91QM\u0015A\u0002\u0005e\u0014\u0001\u00029sKZDqa!\u001b*\u0001\u0004\tI(\u0001\u0003oKb$\u0018aA4f]V\u00111q\u000e\n\u0006\u0007cB8Q\u000f\u0004\u0007\u0003\u000fr\u0007aa\u001c\u0002\u0013Q\u0014X-\u001a\"vS2$\u0007\u0003BA\t\u0007oJAa!\u001f\u0002\u0018\t9AK]3f\u000f\u0016t\u0017AC5t\rJ,W\rV3s[R!1qPBC!\rI8\u0011Q\u0005\u0004\u0007\u0007#(a\u0002\"p_2,\u0017M\u001c\u0005\b\u0007\u000f[\u0003\u0019AA=\u0003\u0019\u0019\u00180\u001c2pY\u0006Q\u0011m\u001d$sK\u0016$VM]7\u0015\t\u000556Q\u0012\u0005\b\u0007\u000fc\u0003\u0019AA=\u0003)I7O\u0012:fKRK\b/\u001a\u000b\u0005\u0007\u007f\u001a\u0019\nC\u0004\u0004\b6\u0002\r!!\u001f\u0002\u0015\u0005\u001chI]3f)f\u0004X\r\u0006\u0003\u0002H\u000ee\u0005bBBD]\u0001\u0007\u0011\u0011P\u0001\u000e]\u0016<H+\u001a:n'fl'm\u001c7\u0015\u0015\r}5QUBT\u0007k\u001bI\f\u0005\u0003\u0002\u0012\r\u0005\u0016\u0002BBR\u0003\u007f\u0012!\u0002V3s[NKXNY8m\u0011\u001d\u00199i\fa\u0001\u0003sBqa!+0\u0001\u0004\u0019Y+\u0001\u0003oC6,\u0007\u0003BA\t\u0007[KAaa,\u00042\nAA+\u001a:n\u001d\u0006lW-C\u0002\u00044B\u0014QAT1nKND\u0011ba.0!\u0003\u0005\rA!\u0007\u0002\u0007A|7\u000fC\u0005\u0004<>\u0002\n\u00111\u0001\u0004>\u0006)a\r\\1hgB!\u0011\u0011CB`\u0013\u0011\u0019\tma1\u0003\u000f\u0019c\u0017mZ*fi&\u00191Q\u00199\u0003\u0011\u0019c\u0017mZ*fiN\fqC\\3x)\u0016\u0014XnU=nE>dG\u0005Z3gCVdG\u000fJ\u001a\u0016\u0005\r-'\u0006\u0002B\r\u0007\u001b\\#aa4\u0011\t\rE71\\\u0007\u0003\u0007'TAa!6\u0004X\u0006IQO\\2iK\u000e\\W\r\u001a\u0006\u0004\u00073$\u0018AC1o]>$\u0018\r^5p]&!1Q\\Bj\u0005E)hn\u00195fG.,GMV1sS\u0006t7-Z\u0001\u0018]\u0016<H+\u001a:n'fl'm\u001c7%I\u00164\u0017-\u001e7uIQ*\"aa9+\t\ru6QZ\u0001\u0018]\u0016<Xj\u001c3vY\u0016\fe\u000eZ\"mCN\u001c8+_7c_2$\"b!;\u0004|\u000euHQ\u0001C\u0004!\u001dI81^Bx\u0007kL1a!<u\u0005\u0019!V\u000f\u001d7feA!\u0011\u0011CBy\u0013\u0011\u0019\u00190a \u0003\u00195{G-\u001e7f'fl'm\u001c7\u0011\t\u0005E1q_\u0005\u0005\u0007s\fyHA\u0006DY\u0006\u001c8oU=nE>d\u0007bBBDe\u0001\u0007\u0011\u0011\u0010\u0005\b\u0007S\u0013\u0004\u0019AB\u0000!\u0011\t\t\u0002\"\u0001\n\t\u0011\r1\u0011\u0017\u0002\u0005\u001d\u0006lW\rC\u0005\u00048J\u0002\n\u00111\u0001\u0003\u001a!I11\u0018\u001a\u0011\u0002\u0003\u00071QX\u0001\"]\u0016<Xj\u001c3vY\u0016\fe\u000eZ\"mCN\u001c8+_7c_2$C-\u001a4bk2$HeM\u0001\"]\u0016<Xj\u001c3vY\u0016\fe\u000eZ\"mCN\u001c8+_7c_2$C-\u001a4bk2$H\u0005N\u0001\u0010]\u0016<X*\u001a;i_\u0012\u001c\u00160\u001c2pYRQA\u0011\u0003C\f\t3!Y\u0002\"\b\u0011\t\u0005EA1C\u0005\u0005\t+\tyH\u0001\u0007NKRDw\u000eZ*z[\n|G\u000eC\u0004\u0004\bV\u0002\r!!\u001f\t\u000f\r%V\u00071\u0001\u0004,\"I1qW\u001b\u0011\u0002\u0003\u0007!\u0011\u0004\u0005\n\u0007w+\u0004\u0013!a\u0001\u0007{\u000b\u0011D\\3x\u001b\u0016$\bn\u001c3Ts6\u0014w\u000e\u001c\u0013eK\u001a\fW\u000f\u001c;%g\u0005Ib.Z<NKRDw\u000eZ*z[\n|G\u000e\n3fM\u0006,H\u000e\u001e\u00135\u00035qWm\u001e+za\u0016\u001c\u00160\u001c2pYRQAq\u0005C\u0017\t_!9\u0004\"\u000f\u0011\t\u0005EA\u0011F\u0005\u0005\tW\tyH\u0001\u0006UsB,7+_7c_2Dqaa\"9\u0001\u0004\tI\bC\u0004\u0004*b\u0002\r\u0001\"\r\u0011\t\u0005EA1G\u0005\u0005\tk\u0019\tL\u0001\u0005UsB,g*Y7f\u0011%\u00199\f\u000fI\u0001\u0002\u0004\u0011I\u0002C\u0005\u0004<b\u0002\n\u00111\u0001\u0004>\u00069b.Z<UsB,7+_7c_2$C-\u001a4bk2$HeM\u0001\u0018]\u0016<H+\u001f9f'fl'm\u001c7%I\u00164\u0017-\u001e7uIQ\naB\\3x\u00072\f7o]*z[\n|G\u000e\u0006\u0006\u0004v\u0012\rCQ\tC$\t\u0013Bqaa\"<\u0001\u0004\tI\bC\u0004\u0004*n\u0002\r\u0001\"\r\t\u0013\r]6\b%AA\u0002\te\u0001\"CB^wA\u0005\t\u0019AB_\u0003aqWm^\"mCN\u001c8+_7c_2$C-\u001a4bk2$HeM\u0001\u0019]\u0016<8\t\\1tgNKXNY8mI\u0011,g-Y;mi\u0012\"\u0014a\u00038fo\u001a\u0013X-\u001a+fe6$\"\"!,\u0005T\u0011-D\u0011\u000fC:\u0011\u001d\u0019IK\u0010a\u0001\t+\u0002B\u0001b\u0016\u0005f9!A\u0011\fC1!\r!Y\u0006^\u0007\u0003\t;R1\u0001b\u0018w\u0003\u0019a$o\\8u}%\u0019A1\r;\u0002\rA\u0013X\rZ3g\u0013\u0011!9\u0007\"\u001b\u0003\rM#(/\u001b8h\u0015\r!\u0019\u0007\u001e\u0005\t\t[rD\u00111\u0001\u0005p\u0005)a/\u00197vKB)\u0011P!\u0001\u0003L!I11\u0018 \u0011\u0002\u0003\u00071Q\u0018\u0005\n\tkr\u0004\u0013!a\u0001\t+\naa\u001c:jO&t\u0017!\u00068fo\u001a\u0013X-\u001a+fe6$C-\u001a4bk2$HeM\u0001\u0016]\u0016<hI]3f)\u0016\u0014X\u000e\n3fM\u0006,H\u000e\u001e\u00135+\t!iH\u000b\u0003\u0005V\r5\u0017a\u00038fo\u001a\u0013X-\u001a+za\u0016$\u0002\"a2\u0005\u0004\u0012\u0015Eq\u0011\u0005\b\u0007S\u000b\u0005\u0019\u0001C+\u0011%\u0019Y,\u0011I\u0001\u0002\u0004\u0019i\fC\u0005\u0005v\u0005\u0003\n\u00111\u0001\u0005V\u0005)b.Z<Ge\u0016,G+\u001f9fI\u0011,g-Y;mi\u0012\u0012\u0014!\u00068fo\u001a\u0013X-\u001a+za\u0016$C-\u001a4bk2$HeM\u0001\fSN,%O]8oK>,8\u000f\u0006\u0003\u0004\u0000\u0011E\u0005bBBD\t\u0002\u0007\u0011\u0011P\u0001\tSN\u001c6n\u001c7f[R!1q\u0010CL\u0011\u001d\u00199)\u0012a\u0001\u0003s\n1\u0002Z3TW>dW-\\5{KR!\u0011\u0011\u0010CO\u0011\u001d\u00199I\u0012a\u0001\u0003s\n!\"\u001b8ji&\fG.\u001b>f)\u0011!\u0019\u000b\"*\u000f\t\u0005]CQ\u0015\u0005\b\u0007\u000f;\u0005\u0019AA=\u0003=1W\u000f\u001c7z\u0013:LG/[1mSj,G\u0003\u0002CV\t[sA!a\u0016\u0005.\"91q\u0011%A\u0002\u0005eD\u0003\u0002CY\tgsA!a\u0016\u00054\"9!\u0011Q%A\u0002\u0005%H\u0003\u0002C\\\tssA!a\u0016\u0005:\"9\u00111\u0012&A\u0002\u0005\u0015D\u0003BB_\t{Cqaa\"L\u0001\u0004\tI\b\u0006\u0003\u0005B\u0012\u001d'\u0003\u0002Cb\u0005\u001b1a!a\u0012\u0007\u0001\u0011\u0005Wa\u0002B\f\t\u0007\u0004#\u0011\u0004\u0005\b\u0007\u000fc\u0005\u0019AA=+\u0011!Y\rb7\u0015\r\u00115G\u0011\u001bCo)\u0011!y\rb5\u000f\t\u0005]C\u0011\u001b\u0005\b\u0007\u000fk\u0005\u0019AA=\u0011%!).TA\u0001\u0002\b!9.\u0001\u0006fm&$WM\\2fIM\u0002bAa\u000e\u0003:\u0011e\u0007\u0003BA,\t7$qA!\u0011N\u0005\u0004\u0011\u0019\u0005C\u0004\u0003T5\u0003\r\u0001\"7\u0016\t\u0011\u0005H\u0011\u001f\u000b\u0005\tG$9\u000f\u0006\u0003\u0005f\u0012%h\u0002BA,\tODqaa\"O\u0001\u0004\tI\bC\u0005\u0005l:\u000b\t\u0011q\u0001\u0005n\u0006QQM^5eK:\u001cW\r\n\u001b\u0011\r\t]\"\u0011\bCx!\u0011\t9\u0006\"=\u0005\u000f\t\u0005cJ1\u0001\u0003D\u0005A1/\u001a;Po:,'\u000f\u0006\u0004\u0005x\u0012eH1 \b\u0005\u0003/\"I\u0010C\u0004\u0004\b>\u0003\r!!\u001f\t\u000f\u0011ux\n1\u0001\u0002z\u0005Aa.Z<po:,'/A\u0004tKRLeNZ8\u0015\r\u0015\rQQAC\u0004\u001d\u0011\t9&\"\u0002\t\u000f\r\u001d\u0005\u000b1\u0001\u0002z!9Q\u0011\u0002)A\u0002\u0005%\u0018a\u0001;qK\u0006q1/\u001a;B]:|G/\u0019;j_:\u001cHCBC\b\u000b#)\u0019B\u0004\u0003\u0002X\u0015E\u0001bBBD#\u0002\u0007\u0011\u0011\u0010\u0005\b\u000b+\t\u0006\u0019AC\f\u0003\u0019\tgN\\8ugB)\u00110!\u001e\u0006\u001aA!\u0011\u0011CC\u000e\u0013\u0011)i\"b\b\u0003\u0015\u0005sgn\u001c;bi&|g.C\u0002\u0006\"A\u0014q\"\u00118o_R\fG/[8o\u0013:4wn]\u0001\bg\u0016$h*Y7f)\u0019)9#\"\u000b\u0006,9!\u0011qKC\u0015\u0011\u001d\u00199I\u0015a\u0001\u0003sBqa!+S\u0001\u0004\u0019y0\u0001\ttKR\u0004&/\u001b<bi\u0016<\u0016\u000e\u001e5j]R1Q\u0011GC\u001a\u000bkqA!a\u0016\u00064!91qQ*A\u0002\u0005e\u0004bBAH'\u0002\u0007\u0011\u0011P\u0001\bg\u0016$h\t\\1h)\u0019)Y$\"\u0010\u0006@9!\u0011qKC\u001f\u0011\u001d\u00199\t\u0016a\u0001\u0003sBqaa/U\u0001\u0004\u0019i,A\u0005sKN,GO\u00127bOR1QQIC$\u000b\u0013rA!a\u0016\u0006H!91qQ+A\u0002\u0005e\u0004bBB^+\u0002\u00071QX\u0001\ti\"L7\u000fV=qKR!\u0011\u0011^C(\u0011\u001d\tyI\u0016a\u0001\u0003s\n!b]5oO2,G+\u001f9f)\u0019\tI/\"\u0016\u0006Z!9QqK,A\u0002\u0005%\u0018a\u00019sK\"9\u0011qR,A\u0002\u0005e\u0014!C:va\u0016\u0014H+\u001f9f)\u0019\tI/b\u0018\u0006d!9Q\u0011\r-A\u0002\u0005%\u0018a\u0002;iSN$\b/\u001a\u0005\b\u000bKB\u0006\u0019AAu\u0003!\u0019X\u000f]3siB,\u0017\u0001D2p]N$\u0018M\u001c;UsB,G\u0003BC6\u000bc\u0002B!!\u0005\u0006n%!QqNAx\u00051\u0019uN\\:uC:$H+\u001f9f\u0011\u001d!i'\u0017a\u0001\u000bg\u0002B!!\u0005\u0006v%!QqOC=\u0005!\u0019uN\\:uC:$\u0018bAC>a\nI1i\u001c8ti\u0006tGo]\u0001\bif\u0004XMU3g)!\tI/\"!\u0006\u0004\u0016\u0015\u0005bBC,5\u0002\u0007\u0011\u0011\u001e\u0005\b\u0003\u001fS\u0006\u0019AA=\u0011\u001d)9I\u0017a\u0001\u0003O\fA!\u0019:hg\u0006Y!/\u001a4j]\u0016$G+\u001f9f)\u0019)i)b%\u0006\u0018B!\u0011\u0011CCH\u0013\u0011)\t*a<\u0003\u0017I+g-\u001b8fIRK\b/\u001a\u0005\b\u000b+[\u0006\u0019AAt\u0003\u001d\u0001\u0018M]3oiNDq!\"'\\\u0001\u0004\t)'A\u0003eK\u000ed7\u000f\u0006\u0005\u0006\u000e\u0016uUqTCQ\u0011\u001d))\n\u0018a\u0001\u0003ODq!\"']\u0001\u0004\t)\u0007C\u0004\u0002|r\u0003\r!!\u001f\u0015\r\u0005%XQUCT\u0011\u001d))*\u0018a\u0001\u0003ODq!\"+^\u0001\u0004\tI(A\u0003po:,'\u000f\u0006\u0005\u0002j\u00165VqVCY\u0011\u001d))J\u0018a\u0001\u0003ODq!\"+_\u0001\u0004\tI\bC\u0004\u0006\u001az\u0003\r!!\u001a\u0015\u0015\u0005%XQWC\\\u000bs+Y\fC\u0004\u0006\u0016~\u0003\r!a:\t\u000f\u0015%v\f1\u0001\u0002z!9Q\u0011T0A\u0002\u0005\u0015\u0004bBB\\?\u0002\u0007!\u0011D\u0001\u0011S:$XM]:fGRLwN\u001c+za\u0016$B!!;\u0006B\"9Q1\u00191A\u0002\u0005\u001d\u0018a\u0001;qgR1\u0011\u0011^Cd\u000b\u0013Dq!b1b\u0001\u0004\t9\u000fC\u0004\u0006*\u0006\u0004\r!!\u001f\u0002\u001b\rd\u0017m]:J]\u001a|G+\u001f9f)!)y-\"6\u0006X\u0016e\u0007\u0003BA\t\u000b#LA!b5\u0002p\ni1\t\\1tg&sgm\u001c+za\u0016Dq!\"&c\u0001\u0004\t9\u000fC\u0004\u0006\u001a\n\u0004\r!!\u001a\t\u000f\u0015m'\r1\u0001\u0002z\u0005QA/\u001f9f'fl'm\u001c7\u0002\u00155,G\u000f[8e)f\u0004X\r\u0006\u0004\u0006b\u0016\u001dX\u0011\u001e\t\u0005\u0003#)\u0019/\u0003\u0003\u0006f\u0006=(AC'fi\"|G\rV=qK\"91qK2A\u0002\u0005]\u0007bBCvG\u0002\u0007\u0011\u0011^\u0001\u000be\u0016\u001cX\u000f\u001c;UsB,\u0017!\u00058vY2\f'/_'fi\"|G\rV=qKR!Q\u0011_C|!\u0011\t\t\"b=\n\t\u0015U\u0018q\u001e\u0002\u0012\u001dVdG.\u0019:z\u001b\u0016$\bn\u001c3UsB,\u0007bBCvI\u0002\u0007\u0011\u0011^\u0001\ta>d\u0017\u0010V=qKR1QQ D\u0002\r\u000f\u0001B!!\u0005\u0006\u0000&!a\u0011AAx\u0005!\u0001v\u000e\\=UsB,\u0007b\u0002D\u0003K\u0002\u0007\u0011q[\u0001\u000bif\u0004X\rU1sC6\u001c\bbBCvK\u0002\u0007\u0011\u0011^\u0001\u0010KbL7\u000f^3oi&\fG\u000eV=qKR1aQ\u0002D\n\r/\u0001B!!\u0005\u0007\u0010%!a\u0011CAx\u0005=)\u00050[:uK:$\u0018.\u00197UsB,\u0007b\u0002D\u000bM\u0002\u0007\u0011q[\u0001\u000bcV\fg\u000e^5gS\u0016$\u0007b\u0002D\rM\u0002\u0007\u0011\u0011^\u0001\u000bk:$WM\u001d7zS:<\u0017AF3ySN$XM\u001c;jC2\f%m\u001d;sC\u000e$\u0018n\u001c8\u0015\r\u0005%hq\u0004D\u0012\u0011\u001d1\tc\u001aa\u0001\u0003/\fq\u0001\u001e9be\u0006l7\u000fC\u0004\u0007&\u001d\u0004\r!!;\u0002\tQ\u0004X\rM\u0001\u000eC:tw\u000e^1uK\u0012$\u0016\u0010]3\u0015\r\u0019-b\u0011\u0007D\u001c!\u0011\t\tB\"\f\n\t\u0019=\u0012q\u001e\u0002\u000e\u0003:tw\u000e^1uK\u0012$\u0016\u0010]3\t\u000f\u0019M\u0002\u000e1\u0001\u00076\u0005Y\u0011M\u001c8pi\u0006$\u0018n\u001c8t!\u0019\t\t+a*\u0006\u001a!9a\u0011\u00045A\u0002\u0005%\u0018A\u0003;za\u0016\u0014u.\u001e8egR1aQ\bD\"\r\u000f\u0002B!!\u0005\u0007@%!a\u0011IAx\u0005)!\u0016\u0010]3C_VtGm\u001d\u0005\b\r\u000bJ\u0007\u0019AAu\u0003\taw\u000eC\u0004\u0007J%\u0004\r!!;\u0002\u0005!L\u0017a\u00052pk:$W\rZ,jY\u0012\u001c\u0017M\u001d3UsB,G\u0003\u0002D(\r+\u0002B!!\u0005\u0007R%!a1KAx\u0005M\u0011u.\u001e8eK\u0012<\u0016\u000e\u001c3dCJ$G+\u001f9f\u0011\u001d19F\u001ba\u0001\r{\taAY8v]\u0012\u001c\u0018aC:vEB\fG\u000f^3s]N$BA\"\u0018\u0007fA)\u0011Pb\u0018\u0007d%\u0019a\u0011\r;\u0003\r=\u0003H/[8o!\u0019\t\t+a*\u00028\"9\u0011QW6A\u0002\u0005]&A\u0003#fG>\u0014\u0018\r^8sgB!a1\u000eD7\u001b\u00051\u0011\u0002\u0002D8\u0003'\u0011\u0011#T1de>$UmY8sCR|'/\u00119j\u0003)!WmY8sCR|'o]\u000b\u0003\rk\u00022Ab\u001bm!\u00111IHb\u001f\u000e\u0003AL1A\" q\u0005-\u0019\u00160\u001c2pYR\u000b'\r\\3")
public interface Internals
extends scala.reflect.api.Internals {
    public static /* synthetic */ Universe.MacroInternalApi internal$(Internals $this) {
        return $this.internal();
    }

    @Override
    default public Universe.MacroInternalApi internal() {
        return new SymbolTableInternal((SymbolTable)this){
            private Internals.ReificationSupportApi reificationSupport;
            private Universe.TreeGen gen;
            private Universe.MacroInternalApi.MacroDecoratorApi decorators;
            private volatile byte bitmap$0;
            private final /* synthetic */ SymbolTable $outer;

            public Internals.Importer createImporter(scala.reflect.api.Universe from0) {
                return SymbolTableInternal.createImporter$(this, from0);
            }

            public Scopes.Scope newScopeWith(Seq<Symbols.Symbol> elems) {
                return SymbolTableInternal.newScopeWith$(this, elems);
            }

            public Scopes.Scope enter(Scopes.Scope scope, Symbols.Symbol sym) {
                return SymbolTableInternal.enter$(this, scope, sym);
            }

            public Scopes.Scope unlink(Scopes.Scope scope, Symbols.Symbol sym) {
                return SymbolTableInternal.unlink$(this, scope, sym);
            }

            public List<Symbols.FreeTermSymbol> freeTerms(Trees.Tree tree) {
                return SymbolTableInternal.freeTerms$(this, tree);
            }

            public List<Symbols.FreeTypeSymbol> freeTypes(Trees.Tree tree) {
                return SymbolTableInternal.freeTypes$(this, tree);
            }

            public Trees.Tree substituteSymbols(Trees.Tree tree, List<Symbols.Symbol> from, List<Symbols.Symbol> to) {
                return SymbolTableInternal.substituteSymbols$(this, tree, from, to);
            }

            public Trees.Tree substituteTypes(Trees.Tree tree, List<Symbols.Symbol> from, List<Types.Type> to) {
                return SymbolTableInternal.substituteTypes$(this, tree, from, to);
            }

            public Trees.Tree substituteThis(Trees.Tree tree, Symbols.Symbol clazz, Function0<Trees.Tree> to) {
                return SymbolTableInternal.substituteThis$(this, tree, clazz, to);
            }

            public Attachments attachments(Trees.Tree tree) {
                return SymbolTableInternal.attachments$((SymbolTableInternal)this, tree);
            }

            public <T> Trees.Tree updateAttachment(Trees.Tree tree, T attachment, ClassTag<T> evidence$1) {
                return SymbolTableInternal.updateAttachment$((SymbolTableInternal)this, tree, attachment, evidence$1);
            }

            public <T> Trees.Tree removeAttachment(Trees.Tree tree, ClassTag<T> evidence$2) {
                return SymbolTableInternal.removeAttachment$((SymbolTableInternal)this, tree, evidence$2);
            }

            public Trees.Tree setPos(Trees.Tree tree, Position newpos) {
                return SymbolTableInternal.setPos$(this, tree, newpos);
            }

            public Trees.Tree setType(Trees.Tree tree, Types.Type tp) {
                return SymbolTableInternal.setType$(this, tree, tp);
            }

            public Trees.Tree defineType(Trees.Tree tree, Types.Type tp) {
                return SymbolTableInternal.defineType$(this, tree, tp);
            }

            public Trees.Tree setSymbol(Trees.Tree tree, Symbols.Symbol sym) {
                return SymbolTableInternal.setSymbol$(this, tree, sym);
            }

            public Trees.TypeTree setOriginal(Trees.TypeTree tt, Trees.Tree tree) {
                return SymbolTableInternal.setOriginal$(this, tt, tree);
            }

            public void captureVariable(Symbols.Symbol vble) {
                SymbolTableInternal.captureVariable$(this, vble);
            }

            public Trees.Tree referenceCapturedVariable(Symbols.Symbol vble) {
                return SymbolTableInternal.referenceCapturedVariable$(this, vble);
            }

            public Types.Type capturedVariableType(Symbols.Symbol vble) {
                return SymbolTableInternal.capturedVariableType$(this, vble);
            }

            public Trees.ClassDef classDef(Symbols.Symbol sym, Trees.Template impl) {
                return SymbolTableInternal.classDef$(this, sym, impl);
            }

            public Trees.ModuleDef moduleDef(Symbols.Symbol sym, Trees.Template impl) {
                return SymbolTableInternal.moduleDef$(this, sym, impl);
            }

            public Trees.ValDef valDef(Symbols.Symbol sym, Trees.Tree rhs) {
                return SymbolTableInternal.valDef$(this, sym, rhs);
            }

            public Trees.ValDef valDef(Symbols.Symbol sym) {
                return SymbolTableInternal.valDef$(this, sym);
            }

            public Trees.DefDef defDef(Symbols.Symbol sym, Trees.Modifiers mods, List<List<Trees.ValDef>> vparamss, Trees.Tree rhs) {
                return SymbolTableInternal.defDef$(this, sym, mods, vparamss, rhs);
            }

            public Trees.DefDef defDef(Symbols.Symbol sym, List<List<Trees.ValDef>> vparamss, Trees.Tree rhs) {
                return SymbolTableInternal.defDef$((SymbolTableInternal)this, sym, vparamss, rhs);
            }

            public Trees.DefDef defDef(Symbols.Symbol sym, Trees.Modifiers mods, Trees.Tree rhs) {
                return SymbolTableInternal.defDef$((SymbolTableInternal)this, sym, mods, rhs);
            }

            public Trees.DefDef defDef(Symbols.Symbol sym, Trees.Tree rhs) {
                return SymbolTableInternal.defDef$((SymbolTableInternal)this, sym, rhs);
            }

            public Trees.DefDef defDef(Symbols.Symbol sym, Function1<List<List<Symbols.Symbol>>, Trees.Tree> rhs) {
                return SymbolTableInternal.defDef$((SymbolTableInternal)this, sym, rhs);
            }

            public Trees.TypeDef typeDef(Symbols.Symbol sym, Trees.Tree rhs) {
                return SymbolTableInternal.typeDef$(this, sym, rhs);
            }

            public Trees.TypeDef typeDef(Symbols.Symbol sym) {
                return SymbolTableInternal.typeDef$(this, sym);
            }

            public Trees.LabelDef labelDef(Symbols.Symbol sym, List<Symbols.Symbol> params, Trees.Tree rhs) {
                return SymbolTableInternal.labelDef$(this, sym, params, rhs);
            }

            public Trees.Tree changeOwner(Trees.Tree tree, Symbols.Symbol prev, Symbols.Symbol next) {
                return SymbolTableInternal.changeOwner$(this, tree, prev, next);
            }

            public boolean isFreeTerm(Symbols.Symbol symbol) {
                return SymbolTableInternal.isFreeTerm$(this, symbol);
            }

            public Symbols.FreeTermSymbol asFreeTerm(Symbols.Symbol symbol) {
                return SymbolTableInternal.asFreeTerm$(this, symbol);
            }

            public boolean isFreeType(Symbols.Symbol symbol) {
                return SymbolTableInternal.isFreeType$(this, symbol);
            }

            public Symbols.FreeTypeSymbol asFreeType(Symbols.Symbol symbol) {
                return SymbolTableInternal.asFreeType$(this, symbol);
            }

            public Symbols.TermSymbol newTermSymbol(Symbols.Symbol symbol, Names.TermName name, Position pos, long flags) {
                return SymbolTableInternal.newTermSymbol$(this, symbol, name, pos, flags);
            }

            public Position newTermSymbol$default$3() {
                return SymbolTableInternal.newTermSymbol$default$3$(this);
            }

            public long newTermSymbol$default$4() {
                return SymbolTableInternal.newTermSymbol$default$4$(this);
            }

            public Tuple2<Symbols.ModuleSymbol, Symbols.ClassSymbol> newModuleAndClassSymbol(Symbols.Symbol symbol, Names.Name name, Position pos, long flags) {
                return SymbolTableInternal.newModuleAndClassSymbol$(this, symbol, name, pos, flags);
            }

            public Position newModuleAndClassSymbol$default$3() {
                return SymbolTableInternal.newModuleAndClassSymbol$default$3$(this);
            }

            public long newModuleAndClassSymbol$default$4() {
                return SymbolTableInternal.newModuleAndClassSymbol$default$4$(this);
            }

            public Symbols.MethodSymbol newMethodSymbol(Symbols.Symbol symbol, Names.TermName name, Position pos, long flags) {
                return SymbolTableInternal.newMethodSymbol$(this, symbol, name, pos, flags);
            }

            public Position newMethodSymbol$default$3() {
                return SymbolTableInternal.newMethodSymbol$default$3$(this);
            }

            public long newMethodSymbol$default$4() {
                return SymbolTableInternal.newMethodSymbol$default$4$(this);
            }

            public Symbols.TypeSymbol newTypeSymbol(Symbols.Symbol symbol, Names.TypeName name, Position pos, long flags) {
                return SymbolTableInternal.newTypeSymbol$(this, symbol, name, pos, flags);
            }

            public Position newTypeSymbol$default$3() {
                return SymbolTableInternal.newTypeSymbol$default$3$(this);
            }

            public long newTypeSymbol$default$4() {
                return SymbolTableInternal.newTypeSymbol$default$4$(this);
            }

            public Symbols.ClassSymbol newClassSymbol(Symbols.Symbol symbol, Names.TypeName name, Position pos, long flags) {
                return SymbolTableInternal.newClassSymbol$(this, symbol, name, pos, flags);
            }

            public Position newClassSymbol$default$3() {
                return SymbolTableInternal.newClassSymbol$default$3$(this);
            }

            public long newClassSymbol$default$4() {
                return SymbolTableInternal.newClassSymbol$default$4$(this);
            }

            public Symbols.FreeTermSymbol newFreeTerm(String name, Function0<Object> value, long flags, String origin) {
                return SymbolTableInternal.newFreeTerm$(this, name, value, flags, origin);
            }

            public long newFreeTerm$default$3() {
                return SymbolTableInternal.newFreeTerm$default$3$(this);
            }

            public String newFreeTerm$default$4() {
                return SymbolTableInternal.newFreeTerm$default$4$(this);
            }

            public Symbols.FreeTypeSymbol newFreeType(String name, long flags, String origin) {
                return SymbolTableInternal.newFreeType$(this, name, flags, origin);
            }

            public long newFreeType$default$2() {
                return SymbolTableInternal.newFreeType$default$2$(this);
            }

            public String newFreeType$default$3() {
                return SymbolTableInternal.newFreeType$default$3$(this);
            }

            public boolean isErroneous(Symbols.Symbol symbol) {
                return SymbolTableInternal.isErroneous$(this, symbol);
            }

            public boolean isSkolem(Symbols.Symbol symbol) {
                return SymbolTableInternal.isSkolem$(this, symbol);
            }

            public Symbols.Symbol deSkolemize(Symbols.Symbol symbol) {
                return SymbolTableInternal.deSkolemize$(this, symbol);
            }

            public Symbols.Symbol initialize(Symbols.Symbol symbol) {
                return SymbolTableInternal.initialize$(this, symbol);
            }

            public Symbols.Symbol fullyInitialize(Symbols.Symbol symbol) {
                return SymbolTableInternal.fullyInitialize$((SymbolTableInternal)this, symbol);
            }

            public Types.Type fullyInitialize(Types.Type tp) {
                return SymbolTableInternal.fullyInitialize$((SymbolTableInternal)this, tp);
            }

            public Scopes.Scope fullyInitialize(Scopes.Scope scope) {
                return SymbolTableInternal.fullyInitialize$((SymbolTableInternal)this, scope);
            }

            public long flags(Symbols.Symbol symbol) {
                return SymbolTableInternal.flags$(this, symbol);
            }

            public Attachments attachments(Symbols.Symbol symbol) {
                return SymbolTableInternal.attachments$((SymbolTableInternal)this, symbol);
            }

            public <T> Symbols.Symbol updateAttachment(Symbols.Symbol symbol, T attachment, ClassTag<T> evidence$3) {
                return SymbolTableInternal.updateAttachment$((SymbolTableInternal)this, symbol, attachment, evidence$3);
            }

            public <T> Symbols.Symbol removeAttachment(Symbols.Symbol symbol, ClassTag<T> evidence$4) {
                return SymbolTableInternal.removeAttachment$((SymbolTableInternal)this, symbol, evidence$4);
            }

            public Symbols.Symbol setOwner(Symbols.Symbol symbol, Symbols.Symbol newowner) {
                return SymbolTableInternal.setOwner$(this, symbol, newowner);
            }

            public Symbols.Symbol setInfo(Symbols.Symbol symbol, Types.Type tpe) {
                return SymbolTableInternal.setInfo$(this, symbol, tpe);
            }

            public Symbols.Symbol setAnnotations(Symbols.Symbol symbol, Seq<AnnotationInfos.AnnotationInfo> annots) {
                return SymbolTableInternal.setAnnotations$(this, symbol, annots);
            }

            public Symbols.Symbol setName(Symbols.Symbol symbol, Names.Name name) {
                return SymbolTableInternal.setName$(this, symbol, name);
            }

            public Symbols.Symbol setPrivateWithin(Symbols.Symbol symbol, Symbols.Symbol sym) {
                return SymbolTableInternal.setPrivateWithin$(this, symbol, sym);
            }

            public Symbols.Symbol setFlag(Symbols.Symbol symbol, long flags) {
                return SymbolTableInternal.setFlag$(this, symbol, flags);
            }

            public Symbols.Symbol resetFlag(Symbols.Symbol symbol, long flags) {
                return SymbolTableInternal.resetFlag$(this, symbol, flags);
            }

            public Types.Type thisType(Symbols.Symbol sym) {
                return SymbolTableInternal.thisType$(this, sym);
            }

            public Types.Type singleType(Types.Type pre, Symbols.Symbol sym) {
                return SymbolTableInternal.singleType$(this, pre, sym);
            }

            public Types.Type superType(Types.Type thistpe, Types.Type supertpe) {
                return SymbolTableInternal.superType$(this, thistpe, supertpe);
            }

            public Types.ConstantType constantType(Constants.Constant value) {
                return SymbolTableInternal.constantType$(this, value);
            }

            public Types.Type typeRef(Types.Type pre, Symbols.Symbol sym, List<Types.Type> args2) {
                return SymbolTableInternal.typeRef$(this, pre, sym, args2);
            }

            public Types.RefinedType refinedType(List<Types.Type> parents, Scopes.Scope decls) {
                return SymbolTableInternal.refinedType$((SymbolTableInternal)this, parents, decls);
            }

            public Types.RefinedType refinedType(List<Types.Type> parents, Scopes.Scope decls, Symbols.Symbol clazz) {
                return SymbolTableInternal.refinedType$((SymbolTableInternal)this, parents, decls, clazz);
            }

            public Types.Type refinedType(List<Types.Type> parents, Symbols.Symbol owner) {
                return SymbolTableInternal.refinedType$((SymbolTableInternal)this, parents, owner);
            }

            public Types.Type refinedType(List<Types.Type> parents, Symbols.Symbol owner, Scopes.Scope decls) {
                return SymbolTableInternal.refinedType$((SymbolTableInternal)this, parents, owner, decls);
            }

            public Types.Type refinedType(List<Types.Type> parents, Symbols.Symbol owner, Scopes.Scope decls, Position pos) {
                return SymbolTableInternal.refinedType$(this, parents, owner, decls, pos);
            }

            public Types.Type intersectionType(List<Types.Type> tps) {
                return SymbolTableInternal.intersectionType$(this, tps);
            }

            public Types.Type intersectionType(List<Types.Type> tps, Symbols.Symbol owner) {
                return SymbolTableInternal.intersectionType$(this, tps, owner);
            }

            public Types.ClassInfoType classInfoType(List<Types.Type> parents, Scopes.Scope decls, Symbols.Symbol typeSymbol) {
                return SymbolTableInternal.classInfoType$(this, parents, decls, typeSymbol);
            }

            public Types.MethodType methodType(List<Symbols.Symbol> params, Types.Type resultType) {
                return SymbolTableInternal.methodType$(this, params, resultType);
            }

            public Types.NullaryMethodType nullaryMethodType(Types.Type resultType) {
                return SymbolTableInternal.nullaryMethodType$(this, resultType);
            }

            public Types.PolyType polyType(List<Symbols.Symbol> typeParams, Types.Type resultType) {
                return SymbolTableInternal.polyType$(this, typeParams, resultType);
            }

            public Types.ExistentialType existentialType(List<Symbols.Symbol> quantified, Types.Type underlying) {
                return SymbolTableInternal.existentialType$(this, quantified, underlying);
            }

            public Types.Type existentialAbstraction(List<Symbols.Symbol> tparams, Types.Type tpe0) {
                return SymbolTableInternal.existentialAbstraction$(this, tparams, tpe0);
            }

            public Types.AnnotatedType annotatedType(List<AnnotationInfos.AnnotationInfo> annotations, Types.Type underlying) {
                return SymbolTableInternal.annotatedType$(this, annotations, underlying);
            }

            public Types.TypeBounds typeBounds(Types.Type lo, Types.Type hi) {
                return SymbolTableInternal.typeBounds$(this, lo, hi);
            }

            public Types.BoundedWildcardType boundedWildcardType(Types.TypeBounds bounds) {
                return SymbolTableInternal.boundedWildcardType$(this, bounds);
            }

            public Option<List<Trees.Tree>> subpatterns(Trees.Tree tree) {
                return SymbolTableInternal.subpatterns$(this, tree);
            }

            public <T> Manifest<T> typeTagToManifest(Object mirror, TypeTags.TypeTag<T> tag, ClassTag<T> evidence$1) {
                return Internals.InternalApi.typeTagToManifest$(this, mirror, tag, evidence$1);
            }

            public <T> TypeTags.TypeTag<T> manifestToTypeTag(Object mirror, Manifest<T> manifest) {
                return Internals.InternalApi.manifestToTypeTag$(this, mirror, manifest);
            }

            public Trees.DefDefApi markForAsyncTransform(Symbols.SymbolApi owner, Trees.DefDefApi method, Symbols.SymbolApi awaitSymbol, Map<String, Object> config) {
                return Internals.InternalApi.markForAsyncTransform$(this, owner, method, awaitSymbol, config);
            }

            private Internals.ReificationSupportApi reificationSupport$lzycompute() {
                synchronized (this) {
                    if ((byte)(this.bitmap$0 & 1) == 0) {
                        this.reificationSupport = SymbolTableInternal.reificationSupport$(this);
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
                        this.gen = SymbolTableInternal.gen$(this);
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
                        this.decorators = SymbolTableInternal.decorators$(this);
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
                SymbolTableInternal.$init$(this);
            }
        };
    }

    public static /* synthetic */ Universe.MacroCompatApi compat$(Internals $this) {
        return $this.compat();
    }

    @Override
    default public Universe.MacroCompatApi compat() {
        return new Universe.MacroCompatApi((SymbolTable)this){
            private final Internals.CompatToken token;
            private final /* synthetic */ SymbolTable $outer;

            public Universe.MacroCompatApi.MacroCompatibleSymbol MacroCompatibleSymbol(Symbols.SymbolApi symbol) {
                return Universe.MacroCompatApi.MacroCompatibleSymbol$(this, symbol);
            }

            public Universe.MacroCompatApi.MacroCompatibleTree MacroCompatibleTree(Trees.TreeApi tree) {
                return Universe.MacroCompatApi.MacroCompatibleTree$(this, tree);
            }

            public Universe.MacroCompatApi.CompatibleTypeTree CompatibleTypeTree(Trees.TypeTreeApi tt) {
                return Universe.MacroCompatApi.CompatibleTypeTree$(this, tt);
            }

            public void captureVariable(Symbols.SymbolApi vble) {
                Universe.MacroCompatApi.captureVariable$(this, vble);
            }

            public Trees.TreeApi referenceCapturedVariable(Symbols.SymbolApi vble) {
                return Universe.MacroCompatApi.referenceCapturedVariable$(this, vble);
            }

            public Types.TypeApi capturedVariableType(Symbols.SymbolApi vble) {
                return Universe.MacroCompatApi.capturedVariableType$(this, vble);
            }

            public <T> Manifest<T> typeTagToManifest(Object mirror, TypeTags.TypeTag<T> tag, ClassTag<T> evidence$2) {
                return Internals.CompatApi.typeTagToManifest$(this, mirror, tag, evidence$2);
            }

            public <T> TypeTags.TypeTag<T> manifestToTypeTag(Object mirror, Manifest<T> manifest) {
                return Internals.CompatApi.manifestToTypeTag$(this, mirror, manifest);
            }

            public Scopes.ScopeApi newScopeWith(Seq<Symbols.SymbolApi> elems) {
                return Internals.CompatApi.newScopeWith$(this, elems);
            }

            public Internals.CompatApi.CompatibleBuildApi CompatibleBuildApi(Internals.ReificationSupportApi api2) {
                return Internals.CompatApi.CompatibleBuildApi$(this, api2);
            }

            public Internals.CompatApi.CompatibleTree CompatibleTree(Trees.TreeApi tree) {
                return Internals.CompatApi.CompatibleTree$(this, tree);
            }

            public Internals.CompatApi.CompatibleSymbol CompatibleSymbol(Symbols.SymbolApi symbol) {
                return Internals.CompatApi.CompatibleSymbol$(this, symbol);
            }

            public Types.TypeApi singleType(Types.TypeApi pre, Symbols.SymbolApi sym) {
                return Internals.CompatApi.singleType$(this, pre, sym);
            }

            public Types.TypeApi refinedType(List<Types.TypeApi> parents, Symbols.SymbolApi owner, Scopes.ScopeApi decls, scala.reflect.api.Position pos) {
                return Internals.CompatApi.refinedType$(this, parents, owner, decls, pos);
            }

            public Types.TypeApi refinedType(List<Types.TypeApi> parents, Symbols.SymbolApi owner) {
                return Internals.CompatApi.refinedType$(this, parents, owner);
            }

            public Types.TypeApi typeRef(Types.TypeApi pre, Symbols.SymbolApi sym, List<Types.TypeApi> args2) {
                return Internals.CompatApi.typeRef$(this, pre, sym, args2);
            }

            public Types.TypeApi intersectionType(List<Types.TypeApi> tps) {
                return Internals.CompatApi.intersectionType$(this, tps);
            }

            public Types.TypeApi intersectionType(List<Types.TypeApi> tps, Symbols.SymbolApi owner) {
                return Internals.CompatApi.intersectionType$(this, tps, owner);
            }

            public Types.TypeApi polyType(List<Symbols.SymbolApi> tparams, Types.TypeApi tpe) {
                return Internals.CompatApi.polyType$(this, tparams, tpe);
            }

            public Types.TypeApi existentialAbstraction(List<Symbols.SymbolApi> tparams, Types.TypeApi tpe0) {
                return Internals.CompatApi.existentialAbstraction$(this, tparams, tpe0);
            }

            public Internals.CompatToken token() {
                return this.token;
            }

            public void scala$reflect$api$Internals$CompatApi$_setter_$token_$eq(Internals.CompatToken x$1) {
                this.token = x$1;
            }

            public /* synthetic */ Universe scala$reflect$macros$Universe$MacroCompatApi$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ scala.reflect.api.Internals scala$reflect$api$Internals$CompatApi$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                Internals.CompatApi.$init$(this);
                Universe.MacroCompatApi.$init$(this);
            }
        };
    }

    public static /* synthetic */ Universe.TreeGen treeBuild$(Internals $this) {
        return $this.treeBuild();
    }

    default public Universe.TreeGen treeBuild() {
        return new Universe.TreeGen((SymbolTable)this){
            private final /* synthetic */ SymbolTable $outer;

            public Trees.Tree mkAttributedQualifier(Types.Type tpe) {
                return this.$outer.gen().mkAttributedQualifier(tpe);
            }

            public Trees.Tree mkAttributedQualifier(Types.Type tpe, Symbols.Symbol termSym) {
                return this.$outer.gen().mkAttributedQualifier(tpe, termSym);
            }

            public Trees.RefTree mkAttributedRef(Types.Type pre, Symbols.Symbol sym) {
                return this.$outer.gen().mkAttributedRef(pre, sym);
            }

            public Trees.RefTree mkAttributedRef(Symbols.Symbol sym) {
                return this.$outer.gen().mkAttributedRef(sym);
            }

            public Trees.Tree stabilize(Trees.Tree tree) {
                return this.$outer.gen().stabilize(tree);
            }

            public Trees.Tree mkAttributedStableRef(Types.Type pre, Symbols.Symbol sym) {
                return this.$outer.gen().mkAttributedStableRef(pre, sym);
            }

            public Trees.Tree mkAttributedStableRef(Symbols.Symbol sym) {
                return this.$outer.gen().mkAttributedStableRef(sym);
            }

            public Trees.RefTree mkUnattributedRef(Symbols.Symbol sym) {
                return this.$outer.gen().mkUnattributedRef(sym);
            }

            public Trees.RefTree mkUnattributedRef(Names.Name fullName) {
                return this.$outer.gen().mkUnattributedRef(fullName);
            }

            public Trees.This mkAttributedThis(Symbols.Symbol sym) {
                return this.$outer.gen().mkAttributedThis(sym);
            }

            public Trees.RefTree mkAttributedIdent(Symbols.Symbol sym) {
                return this.$outer.gen().mkAttributedIdent(sym);
            }

            public Trees.RefTree mkAttributedSelect(Trees.Tree qual, Symbols.Symbol sym) {
                return this.$outer.gen().mkAttributedSelect(qual, sym);
            }

            public Trees.Tree mkMethodCall(Symbols.Symbol receiver, Names.Name methodName, List<Types.Type> targs, List<Trees.Tree> args2) {
                return this.$outer.gen().mkMethodCall(receiver, methodName, targs, args2);
            }

            public Trees.Tree mkMethodCall(Symbols.Symbol method, List<Types.Type> targs, List<Trees.Tree> args2) {
                return this.$outer.gen().mkMethodCall(method, targs, args2);
            }

            public Trees.Tree mkMethodCall(Symbols.Symbol method, List<Trees.Tree> args2) {
                return this.$outer.gen().mkMethodCall(method, args2);
            }

            public Trees.Tree mkMethodCall(Trees.Tree target, List<Trees.Tree> args2) {
                return this.$outer.gen().mkMethodCall(target, args2);
            }

            public Trees.Tree mkMethodCall(Symbols.Symbol receiver, Names.Name methodName, List<Trees.Tree> args2) {
                return this.$outer.gen().mkMethodCall(receiver, methodName, args2);
            }

            public Trees.Tree mkMethodCall(Trees.Tree receiver, Symbols.Symbol method, List<Types.Type> targs, List<Trees.Tree> args2) {
                return this.$outer.gen().mkMethodCall(receiver, method, targs, args2);
            }

            public Trees.Tree mkMethodCall(Trees.Tree target, List<Types.Type> targs, List<Trees.Tree> args2) {
                return this.$outer.gen().mkMethodCall(target, targs, args2);
            }

            public Trees.Tree mkNullaryCall(Symbols.Symbol method, List<Types.Type> targs) {
                return this.$outer.gen().mkNullaryCall(method, targs);
            }

            public Trees.Tree mkRuntimeUniverseRef() {
                return this.$outer.gen().mkRuntimeUniverseRef();
            }

            public Trees.Tree mkZero(Types.Type tp) {
                return this.$outer.gen().mkZero(tp);
            }

            public Trees.Tree mkCast(Trees.Tree tree, Types.Type pt) {
                return this.$outer.gen().mkCast(tree, pt);
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }
        };
    }

    public static void $init$(Internals $this) {
    }

    public interface SymbolTableInternal
    extends Universe.MacroInternalApi {
        public static /* synthetic */ Internals.ReificationSupportApi reificationSupport$(SymbolTableInternal $this) {
            return $this.reificationSupport();
        }

        @Override
        default public Internals.ReificationSupportApi reificationSupport() {
            return ((ReificationSupport)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).build();
        }

        public static /* synthetic */ Internals.Importer createImporter$(SymbolTableInternal $this, scala.reflect.api.Universe from0) {
            return $this.createImporter(from0);
        }

        @Override
        default public Internals.Importer createImporter(scala.reflect.api.Universe from0) {
            return ((Importers)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).mkImporter(from0);
        }

        public static /* synthetic */ Scopes.Scope newScopeWith$(SymbolTableInternal $this, Seq elems) {
            return $this.newScopeWith(elems);
        }

        default public Scopes.Scope newScopeWith(Seq<Symbols.Symbol> elems) {
            return ((Scopes)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).newScopeWith(elems);
        }

        public static /* synthetic */ Scopes.Scope enter$(SymbolTableInternal $this, Scopes.Scope scope, Symbols.Symbol sym) {
            return $this.enter(scope, sym);
        }

        default public Scopes.Scope enter(Scopes.Scope scope, Symbols.Symbol sym) {
            scope.enter(sym);
            return scope;
        }

        public static /* synthetic */ Scopes.Scope unlink$(SymbolTableInternal $this, Scopes.Scope scope, Symbols.Symbol sym) {
            return $this.unlink(scope, sym);
        }

        default public Scopes.Scope unlink(Scopes.Scope scope, Symbols.Symbol sym) {
            scope.unlink(sym);
            return scope;
        }

        public static /* synthetic */ List freeTerms$(SymbolTableInternal $this, Trees.Tree tree) {
            return $this.freeTerms(tree);
        }

        default public List<Symbols.FreeTermSymbol> freeTerms(Trees.Tree tree) {
            return tree.freeTerms();
        }

        public static /* synthetic */ List freeTypes$(SymbolTableInternal $this, Trees.Tree tree) {
            return $this.freeTypes(tree);
        }

        default public List<Symbols.FreeTypeSymbol> freeTypes(Trees.Tree tree) {
            return tree.freeTypes();
        }

        public static /* synthetic */ Trees.Tree substituteSymbols$(SymbolTableInternal $this, Trees.Tree tree, List from, List to) {
            return $this.substituteSymbols(tree, from, to);
        }

        default public Trees.Tree substituteSymbols(Trees.Tree tree, List<Symbols.Symbol> from, List<Symbols.Symbol> to) {
            return tree.substituteSymbols(from, to);
        }

        public static /* synthetic */ Trees.Tree substituteTypes$(SymbolTableInternal $this, Trees.Tree tree, List from, List to) {
            return $this.substituteTypes(tree, from, to);
        }

        default public Trees.Tree substituteTypes(Trees.Tree tree, List<Symbols.Symbol> from, List<Types.Type> to) {
            return tree.substituteTypes(from, to);
        }

        public static /* synthetic */ Trees.Tree substituteThis$(SymbolTableInternal $this, Trees.Tree tree, Symbols.Symbol clazz, Function0 to) {
            return $this.substituteThis(tree, clazz, to);
        }

        default public Trees.Tree substituteThis(Trees.Tree tree, Symbols.Symbol clazz, Function0<Trees.Tree> to) {
            return tree.substituteThis(clazz, to);
        }

        public static /* synthetic */ Attachments attachments$(SymbolTableInternal $this, Trees.Tree tree) {
            return $this.attachments(tree);
        }

        default public Attachments attachments(Trees.Tree tree) {
            return tree.attachments();
        }

        public static /* synthetic */ Trees.Tree updateAttachment$(SymbolTableInternal $this, Trees.Tree tree, Object attachment, ClassTag evidence$1) {
            return $this.updateAttachment(tree, attachment, evidence$1);
        }

        default public <T> Trees.Tree updateAttachment(Trees.Tree tree, T attachment, ClassTag<T> evidence$1) {
            return (Trees.Tree)tree.updateAttachment(attachment, evidence$1);
        }

        public static /* synthetic */ Trees.Tree removeAttachment$(SymbolTableInternal $this, Trees.Tree tree, ClassTag evidence$2) {
            return $this.removeAttachment(tree, evidence$2);
        }

        default public <T> Trees.Tree removeAttachment(Trees.Tree tree, ClassTag<T> evidence$2) {
            return (Trees.Tree)tree.removeAttachment(evidence$2);
        }

        public static /* synthetic */ Trees.Tree setPos$(SymbolTableInternal $this, Trees.Tree tree, Position newpos) {
            return $this.setPos(tree, newpos);
        }

        default public Trees.Tree setPos(Trees.Tree tree, Position newpos) {
            return (Trees.Tree)tree.setPos(newpos);
        }

        public static /* synthetic */ Trees.Tree setType$(SymbolTableInternal $this, Trees.Tree tree, Types.Type tp) {
            return $this.setType(tree, tp);
        }

        default public Trees.Tree setType(Trees.Tree tree, Types.Type tp) {
            return tree.setType(tp);
        }

        public static /* synthetic */ Trees.Tree defineType$(SymbolTableInternal $this, Trees.Tree tree, Types.Type tp) {
            return $this.defineType(tree, tp);
        }

        default public Trees.Tree defineType(Trees.Tree tree, Types.Type tp) {
            return tree.defineType(tp);
        }

        public static /* synthetic */ Trees.Tree setSymbol$(SymbolTableInternal $this, Trees.Tree tree, Symbols.Symbol sym) {
            return $this.setSymbol(tree, sym);
        }

        default public Trees.Tree setSymbol(Trees.Tree tree, Symbols.Symbol sym) {
            return tree.setSymbol(sym);
        }

        public static /* synthetic */ Trees.TypeTree setOriginal$(SymbolTableInternal $this, Trees.TypeTree tt, Trees.Tree tree) {
            return $this.setOriginal(tt, tree);
        }

        default public Trees.TypeTree setOriginal(Trees.TypeTree tt, Trees.Tree tree) {
            return tt.setOriginal(tree);
        }

        public static /* synthetic */ void captureVariable$(SymbolTableInternal $this, Symbols.Symbol vble) {
            $this.captureVariable(vble);
        }

        default public void captureVariable(Symbols.Symbol vble) {
            ((CapturedVariables)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).captureVariable(vble);
        }

        public static /* synthetic */ Trees.Tree referenceCapturedVariable$(SymbolTableInternal $this, Symbols.Symbol vble) {
            return $this.referenceCapturedVariable(vble);
        }

        default public Trees.Tree referenceCapturedVariable(Symbols.Symbol vble) {
            return ((CapturedVariables)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).referenceCapturedVariable(vble);
        }

        public static /* synthetic */ Types.Type capturedVariableType$(SymbolTableInternal $this, Symbols.Symbol vble) {
            return $this.capturedVariableType(vble);
        }

        default public Types.Type capturedVariableType(Symbols.Symbol vble) {
            return ((CapturedVariables)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).capturedVariableType(vble);
        }

        public static /* synthetic */ Trees.ClassDef classDef$(SymbolTableInternal $this, Symbols.Symbol sym, Trees.Template impl) {
            return $this.classDef(sym, impl);
        }

        default public Trees.ClassDef classDef(Symbols.Symbol sym, Trees.Template impl) {
            return ((Trees)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).ClassDef().apply(sym, impl);
        }

        public static /* synthetic */ Trees.ModuleDef moduleDef$(SymbolTableInternal $this, Symbols.Symbol sym, Trees.Template impl) {
            return $this.moduleDef(sym, impl);
        }

        default public Trees.ModuleDef moduleDef(Symbols.Symbol sym, Trees.Template impl) {
            return ((Trees)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).ModuleDef().apply(sym, impl);
        }

        public static /* synthetic */ Trees.ValDef valDef$(SymbolTableInternal $this, Symbols.Symbol sym, Trees.Tree rhs) {
            return $this.valDef(sym, rhs);
        }

        default public Trees.ValDef valDef(Symbols.Symbol sym, Trees.Tree rhs) {
            return ((Trees)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).ValDef().apply(sym, rhs);
        }

        public static /* synthetic */ Trees.ValDef valDef$(SymbolTableInternal $this, Symbols.Symbol sym) {
            return $this.valDef(sym);
        }

        default public Trees.ValDef valDef(Symbols.Symbol sym) {
            return ((Trees)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).ValDef().apply(sym);
        }

        public static /* synthetic */ Trees.DefDef defDef$(SymbolTableInternal $this, Symbols.Symbol sym, Trees.Modifiers mods, List vparamss, Trees.Tree rhs) {
            return $this.defDef(sym, mods, vparamss, rhs);
        }

        default public Trees.DefDef defDef(Symbols.Symbol sym, Trees.Modifiers mods, List<List<Trees.ValDef>> vparamss, Trees.Tree rhs) {
            return ((Trees)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).DefDef().apply(sym, mods, vparamss, rhs);
        }

        public static /* synthetic */ Trees.DefDef defDef$(SymbolTableInternal $this, Symbols.Symbol sym, List vparamss, Trees.Tree rhs) {
            return $this.defDef(sym, vparamss, rhs);
        }

        default public Trees.DefDef defDef(Symbols.Symbol sym, List<List<Trees.ValDef>> vparamss, Trees.Tree rhs) {
            return ((Trees)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).DefDef().apply(sym, vparamss, rhs);
        }

        public static /* synthetic */ Trees.DefDef defDef$(SymbolTableInternal $this, Symbols.Symbol sym, Trees.Modifiers mods, Trees.Tree rhs) {
            return $this.defDef(sym, mods, rhs);
        }

        default public Trees.DefDef defDef(Symbols.Symbol sym, Trees.Modifiers mods, Trees.Tree rhs) {
            return ((Trees)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).DefDef().apply(sym, mods, rhs);
        }

        public static /* synthetic */ Trees.DefDef defDef$(SymbolTableInternal $this, Symbols.Symbol sym, Trees.Tree rhs) {
            return $this.defDef(sym, rhs);
        }

        default public Trees.DefDef defDef(Symbols.Symbol sym, Trees.Tree rhs) {
            return ((Trees)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).DefDef().apply(sym, rhs);
        }

        public static /* synthetic */ Trees.DefDef defDef$(SymbolTableInternal $this, Symbols.Symbol sym, Function1 rhs) {
            return $this.defDef(sym, rhs);
        }

        default public Trees.DefDef defDef(Symbols.Symbol sym, Function1<List<List<Symbols.Symbol>>, Trees.Tree> rhs) {
            Trees$DefDef$ trees$DefDef$ = ((Trees)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).DefDef();
            if (trees$DefDef$ == null) {
                throw null;
            }
            Trees$DefDef$ apply_this = trees$DefDef$;
            Trees.Tree apply_x$2 = rhs.apply(sym.info().paramss());
            Trees.Modifiers apply_x$3 = apply_this.scala$reflect$internal$Trees$DefDef$$$outer().newDefDef$default$3(sym, apply_x$2);
            Names.TermName apply_x$4 = apply_this.scala$reflect$internal$Trees$DefDef$$$outer().newDefDef$default$4(sym, apply_x$2);
            List<Trees.TypeDef> apply_x$5 = apply_this.scala$reflect$internal$Trees$DefDef$$$outer().newDefDef$default$5(sym, apply_x$2);
            List<List<Trees.ValDef>> apply_x$6 = apply_this.scala$reflect$internal$Trees$DefDef$$$outer().newDefDef$default$6(sym, apply_x$2);
            Trees.Tree apply_x$7 = apply_this.scala$reflect$internal$Trees$DefDef$$$outer().newDefDef$default$7(sym, apply_x$2);
            return apply_this.scala$reflect$internal$Trees$DefDef$$$outer().newDefDef(sym, apply_x$2, apply_x$3, apply_x$4, apply_x$5, apply_x$6, apply_x$7);
        }

        public static /* synthetic */ Trees.TypeDef typeDef$(SymbolTableInternal $this, Symbols.Symbol sym, Trees.Tree rhs) {
            return $this.typeDef(sym, rhs);
        }

        default public Trees.TypeDef typeDef(Symbols.Symbol sym, Trees.Tree rhs) {
            return ((Trees)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).TypeDef().apply(sym, rhs);
        }

        public static /* synthetic */ Trees.TypeDef typeDef$(SymbolTableInternal $this, Symbols.Symbol sym) {
            return $this.typeDef(sym);
        }

        default public Trees.TypeDef typeDef(Symbols.Symbol sym) {
            return ((Trees)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).TypeDef().apply(sym);
        }

        public static /* synthetic */ Trees.LabelDef labelDef$(SymbolTableInternal $this, Symbols.Symbol sym, List params, Trees.Tree rhs) {
            return $this.labelDef(sym, params, rhs);
        }

        default public Trees.LabelDef labelDef(Symbols.Symbol sym, List<Symbols.Symbol> params, Trees.Tree rhs) {
            return ((Trees)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).LabelDef().apply(sym, params, rhs);
        }

        public static /* synthetic */ Trees.Tree changeOwner$(SymbolTableInternal $this, Trees.Tree tree, Symbols.Symbol prev, Symbols.Symbol next) {
            return $this.changeOwner(tree, prev, next);
        }

        default public Trees.Tree changeOwner(Trees.Tree tree, Symbols.Symbol prev, Symbols.Symbol next) {
            new Trees.ChangeOwnerTraverser((SymbolTable)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer(), prev, next).traverse(tree);
            return tree;
        }

        public static /* synthetic */ Universe.TreeGen gen$(SymbolTableInternal $this) {
            return $this.gen();
        }

        @Override
        default public Universe.TreeGen gen() {
            return this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer().treeBuild();
        }

        public static /* synthetic */ boolean isFreeTerm$(SymbolTableInternal $this, Symbols.Symbol symbol) {
            return $this.isFreeTerm(symbol);
        }

        default public boolean isFreeTerm(Symbols.Symbol symbol) {
            return symbol.isFreeTerm();
        }

        public static /* synthetic */ Symbols.FreeTermSymbol asFreeTerm$(SymbolTableInternal $this, Symbols.Symbol symbol) {
            return $this.asFreeTerm(symbol);
        }

        default public Symbols.FreeTermSymbol asFreeTerm(Symbols.Symbol symbol) {
            return symbol.asFreeTerm();
        }

        public static /* synthetic */ boolean isFreeType$(SymbolTableInternal $this, Symbols.Symbol symbol) {
            return $this.isFreeType(symbol);
        }

        default public boolean isFreeType(Symbols.Symbol symbol) {
            return symbol.isFreeType();
        }

        public static /* synthetic */ Symbols.FreeTypeSymbol asFreeType$(SymbolTableInternal $this, Symbols.Symbol symbol) {
            return $this.asFreeType(symbol);
        }

        default public Symbols.FreeTypeSymbol asFreeType(Symbols.Symbol symbol) {
            return symbol.asFreeType();
        }

        public static /* synthetic */ Symbols.TermSymbol newTermSymbol$(SymbolTableInternal $this, Symbols.Symbol symbol, Names.TermName name, Position pos, long flags) {
            return $this.newTermSymbol(symbol, name, pos, flags);
        }

        default public Symbols.TermSymbol newTermSymbol(Symbols.Symbol symbol, Names.TermName name, Position pos, long flags) {
            return symbol.newTermSymbol(name, pos, flags);
        }

        public static /* synthetic */ Position newTermSymbol$default$3$(SymbolTableInternal $this) {
            return $this.newTermSymbol$default$3();
        }

        @Override
        default public Position newTermSymbol$default$3() {
            return ((Positions)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).NoPosition();
        }

        public static /* synthetic */ long newTermSymbol$default$4$(SymbolTableInternal $this) {
            return $this.newTermSymbol$default$4();
        }

        default public long newTermSymbol$default$4() {
            return ((FlagSets)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).NoFlags();
        }

        public static /* synthetic */ Tuple2 newModuleAndClassSymbol$(SymbolTableInternal $this, Symbols.Symbol symbol, Names.Name name, Position pos, long flags) {
            return $this.newModuleAndClassSymbol(symbol, name, pos, flags);
        }

        default public Tuple2<Symbols.ModuleSymbol, Symbols.ClassSymbol> newModuleAndClassSymbol(Symbols.Symbol symbol, Names.Name name, Position pos, long flags) {
            return symbol.newModuleAndClassSymbol(name, pos, flags);
        }

        public static /* synthetic */ Position newModuleAndClassSymbol$default$3$(SymbolTableInternal $this) {
            return $this.newModuleAndClassSymbol$default$3();
        }

        @Override
        default public Position newModuleAndClassSymbol$default$3() {
            return ((Positions)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).NoPosition();
        }

        public static /* synthetic */ long newModuleAndClassSymbol$default$4$(SymbolTableInternal $this) {
            return $this.newModuleAndClassSymbol$default$4();
        }

        default public long newModuleAndClassSymbol$default$4() {
            return ((FlagSets)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).NoFlags();
        }

        public static /* synthetic */ Symbols.MethodSymbol newMethodSymbol$(SymbolTableInternal $this, Symbols.Symbol symbol, Names.TermName name, Position pos, long flags) {
            return $this.newMethodSymbol(symbol, name, pos, flags);
        }

        default public Symbols.MethodSymbol newMethodSymbol(Symbols.Symbol symbol, Names.TermName name, Position pos, long flags) {
            return symbol.newMethodSymbol(name, pos, flags);
        }

        public static /* synthetic */ Position newMethodSymbol$default$3$(SymbolTableInternal $this) {
            return $this.newMethodSymbol$default$3();
        }

        @Override
        default public Position newMethodSymbol$default$3() {
            return ((Positions)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).NoPosition();
        }

        public static /* synthetic */ long newMethodSymbol$default$4$(SymbolTableInternal $this) {
            return $this.newMethodSymbol$default$4();
        }

        default public long newMethodSymbol$default$4() {
            return ((FlagSets)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).NoFlags();
        }

        public static /* synthetic */ Symbols.TypeSymbol newTypeSymbol$(SymbolTableInternal $this, Symbols.Symbol symbol, Names.TypeName name, Position pos, long flags) {
            return $this.newTypeSymbol(symbol, name, pos, flags);
        }

        default public Symbols.TypeSymbol newTypeSymbol(Symbols.Symbol symbol, Names.TypeName name, Position pos, long flags) {
            return symbol.newTypeSymbol(name, pos, flags);
        }

        public static /* synthetic */ Position newTypeSymbol$default$3$(SymbolTableInternal $this) {
            return $this.newTypeSymbol$default$3();
        }

        @Override
        default public Position newTypeSymbol$default$3() {
            return ((Positions)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).NoPosition();
        }

        public static /* synthetic */ long newTypeSymbol$default$4$(SymbolTableInternal $this) {
            return $this.newTypeSymbol$default$4();
        }

        default public long newTypeSymbol$default$4() {
            return ((FlagSets)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).NoFlags();
        }

        public static /* synthetic */ Symbols.ClassSymbol newClassSymbol$(SymbolTableInternal $this, Symbols.Symbol symbol, Names.TypeName name, Position pos, long flags) {
            return $this.newClassSymbol(symbol, name, pos, flags);
        }

        default public Symbols.ClassSymbol newClassSymbol(Symbols.Symbol symbol, Names.TypeName name, Position pos, long flags) {
            return symbol.newClassSymbol(name, pos, flags);
        }

        public static /* synthetic */ Position newClassSymbol$default$3$(SymbolTableInternal $this) {
            return $this.newClassSymbol$default$3();
        }

        @Override
        default public Position newClassSymbol$default$3() {
            return ((Positions)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).NoPosition();
        }

        public static /* synthetic */ long newClassSymbol$default$4$(SymbolTableInternal $this) {
            return $this.newClassSymbol$default$4();
        }

        default public long newClassSymbol$default$4() {
            return ((FlagSets)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).NoFlags();
        }

        public static /* synthetic */ Symbols.FreeTermSymbol newFreeTerm$(SymbolTableInternal $this, String name, Function0 value, long flags, String origin) {
            return $this.newFreeTerm(name, (Function0<Object>)value, flags, origin);
        }

        default public Symbols.FreeTermSymbol newFreeTerm(String name, Function0<Object> value, long flags, String origin) {
            return (Symbols.FreeTermSymbol)this.reificationSupport().newFreeTerm(name, value, BoxesRunTime.boxToLong(flags), origin);
        }

        public static /* synthetic */ long newFreeTerm$default$3$(SymbolTableInternal $this) {
            return $this.newFreeTerm$default$3();
        }

        default public long newFreeTerm$default$3() {
            return ((FlagSets)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).NoFlags();
        }

        public static /* synthetic */ String newFreeTerm$default$4$(SymbolTableInternal $this) {
            return $this.newFreeTerm$default$4();
        }

        @Override
        default public String newFreeTerm$default$4() {
            return null;
        }

        public static /* synthetic */ Symbols.FreeTypeSymbol newFreeType$(SymbolTableInternal $this, String name, long flags, String origin) {
            return $this.newFreeType(name, flags, origin);
        }

        default public Symbols.FreeTypeSymbol newFreeType(String name, long flags, String origin) {
            return (Symbols.FreeTypeSymbol)this.reificationSupport().newFreeType(name, BoxesRunTime.boxToLong(flags), origin);
        }

        public static /* synthetic */ long newFreeType$default$2$(SymbolTableInternal $this) {
            return $this.newFreeType$default$2();
        }

        default public long newFreeType$default$2() {
            return ((FlagSets)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).NoFlags();
        }

        public static /* synthetic */ String newFreeType$default$3$(SymbolTableInternal $this) {
            return $this.newFreeType$default$3();
        }

        @Override
        default public String newFreeType$default$3() {
            return null;
        }

        public static /* synthetic */ boolean isErroneous$(SymbolTableInternal $this, Symbols.Symbol symbol) {
            return $this.isErroneous(symbol);
        }

        default public boolean isErroneous(Symbols.Symbol symbol) {
            return symbol.isErroneous();
        }

        public static /* synthetic */ boolean isSkolem$(SymbolTableInternal $this, Symbols.Symbol symbol) {
            return $this.isSkolem(symbol);
        }

        default public boolean isSkolem(Symbols.Symbol symbol) {
            return symbol.isSkolem();
        }

        public static /* synthetic */ Symbols.Symbol deSkolemize$(SymbolTableInternal $this, Symbols.Symbol symbol) {
            return $this.deSkolemize(symbol);
        }

        default public Symbols.Symbol deSkolemize(Symbols.Symbol symbol) {
            return symbol.deSkolemize();
        }

        public static /* synthetic */ Symbols.Symbol initialize$(SymbolTableInternal $this, Symbols.Symbol symbol) {
            return $this.initialize(symbol);
        }

        default public Symbols.Symbol initialize(Symbols.Symbol symbol) {
            return symbol.initialize();
        }

        public static /* synthetic */ Symbols.Symbol fullyInitialize$(SymbolTableInternal $this, Symbols.Symbol symbol) {
            return $this.fullyInitialize(symbol);
        }

        default public Symbols.Symbol fullyInitialize(Symbols.Symbol symbol) {
            return ((Definitions)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).definitions().fullyInitializeSymbol(symbol);
        }

        public static /* synthetic */ Types.Type fullyInitialize$(SymbolTableInternal $this, Types.Type tp) {
            return $this.fullyInitialize(tp);
        }

        default public Types.Type fullyInitialize(Types.Type tp) {
            return ((Definitions)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).definitions().fullyInitializeType(tp);
        }

        public static /* synthetic */ Scopes.Scope fullyInitialize$(SymbolTableInternal $this, Scopes.Scope scope) {
            return $this.fullyInitialize(scope);
        }

        default public Scopes.Scope fullyInitialize(Scopes.Scope scope) {
            return ((Definitions)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).definitions().fullyInitializeScope(scope);
        }

        public static /* synthetic */ long flags$(SymbolTableInternal $this, Symbols.Symbol symbol) {
            return $this.flags(symbol);
        }

        default public long flags(Symbols.Symbol symbol) {
            return symbol.flags();
        }

        public static /* synthetic */ Attachments attachments$(SymbolTableInternal $this, Symbols.Symbol symbol) {
            return $this.attachments(symbol);
        }

        default public Attachments attachments(Symbols.Symbol symbol) {
            return symbol.attachments();
        }

        public static /* synthetic */ Symbols.Symbol updateAttachment$(SymbolTableInternal $this, Symbols.Symbol symbol, Object attachment, ClassTag evidence$3) {
            return $this.updateAttachment(symbol, attachment, evidence$3);
        }

        default public <T> Symbols.Symbol updateAttachment(Symbols.Symbol symbol, T attachment, ClassTag<T> evidence$3) {
            return (Symbols.Symbol)symbol.updateAttachment(attachment, evidence$3);
        }

        public static /* synthetic */ Symbols.Symbol removeAttachment$(SymbolTableInternal $this, Symbols.Symbol symbol, ClassTag evidence$4) {
            return $this.removeAttachment(symbol, evidence$4);
        }

        default public <T> Symbols.Symbol removeAttachment(Symbols.Symbol symbol, ClassTag<T> evidence$4) {
            return (Symbols.Symbol)symbol.removeAttachment(evidence$4);
        }

        public static /* synthetic */ Symbols.Symbol setOwner$(SymbolTableInternal $this, Symbols.Symbol symbol, Symbols.Symbol newowner) {
            return $this.setOwner(symbol, newowner);
        }

        default public Symbols.Symbol setOwner(Symbols.Symbol symbol, Symbols.Symbol newowner) {
            symbol.owner_$eq(newowner);
            return symbol;
        }

        public static /* synthetic */ Symbols.Symbol setInfo$(SymbolTableInternal $this, Symbols.Symbol symbol, Types.Type tpe) {
            return $this.setInfo(symbol, tpe);
        }

        default public Symbols.Symbol setInfo(Symbols.Symbol symbol, Types.Type tpe) {
            return symbol.setInfo(tpe);
        }

        public static /* synthetic */ Symbols.Symbol setAnnotations$(SymbolTableInternal $this, Symbols.Symbol symbol, Seq annots) {
            return $this.setAnnotations(symbol, annots);
        }

        default public Symbols.Symbol setAnnotations(Symbols.Symbol symbol, Seq<AnnotationInfos.AnnotationInfo> annots) {
            return symbol.setAnnotations(annots);
        }

        public static /* synthetic */ Symbols.Symbol setName$(SymbolTableInternal $this, Symbols.Symbol symbol, Names.Name name) {
            return $this.setName(symbol, name);
        }

        default public Symbols.Symbol setName(Symbols.Symbol symbol, Names.Name name) {
            return symbol.setName(name);
        }

        public static /* synthetic */ Symbols.Symbol setPrivateWithin$(SymbolTableInternal $this, Symbols.Symbol symbol, Symbols.Symbol sym) {
            return $this.setPrivateWithin(symbol, sym);
        }

        default public Symbols.Symbol setPrivateWithin(Symbols.Symbol symbol, Symbols.Symbol sym) {
            return symbol.setPrivateWithin(sym);
        }

        public static /* synthetic */ Symbols.Symbol setFlag$(SymbolTableInternal $this, Symbols.Symbol symbol, long flags) {
            return $this.setFlag(symbol, flags);
        }

        default public Symbols.Symbol setFlag(Symbols.Symbol symbol, long flags) {
            return symbol.setFlag(flags);
        }

        public static /* synthetic */ Symbols.Symbol resetFlag$(SymbolTableInternal $this, Symbols.Symbol symbol, long flags) {
            return $this.resetFlag(symbol, flags);
        }

        default public Symbols.Symbol resetFlag(Symbols.Symbol symbol, long flags) {
            return symbol.resetFlag(flags);
        }

        public static /* synthetic */ Types.Type thisType$(SymbolTableInternal $this, Symbols.Symbol sym) {
            return $this.thisType(sym);
        }

        default public Types.Type thisType(Symbols.Symbol sym) {
            return ((Types)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).ThisType().apply(sym);
        }

        public static /* synthetic */ Types.Type singleType$(SymbolTableInternal $this, Types.Type pre, Symbols.Symbol sym) {
            return $this.singleType(pre, sym);
        }

        default public Types.Type singleType(Types.Type pre, Symbols.Symbol sym) {
            return ((Types)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).SingleType().apply(pre, sym);
        }

        public static /* synthetic */ Types.Type superType$(SymbolTableInternal $this, Types.Type thistpe, Types.Type supertpe) {
            return $this.superType(thistpe, supertpe);
        }

        default public Types.Type superType(Types.Type thistpe, Types.Type supertpe) {
            return ((Types)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).SuperType().apply(thistpe, supertpe);
        }

        public static /* synthetic */ Types.ConstantType constantType$(SymbolTableInternal $this, Constants.Constant value) {
            return $this.constantType(value);
        }

        default public Types.ConstantType constantType(Constants.Constant value) {
            return ((Types)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).ConstantType().apply(value);
        }

        public static /* synthetic */ Types.Type typeRef$(SymbolTableInternal $this, Types.Type pre, Symbols.Symbol sym, List args2) {
            return $this.typeRef(pre, sym, args2);
        }

        default public Types.Type typeRef(Types.Type pre, Symbols.Symbol sym, List<Types.Type> args2) {
            return ((Types)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).TypeRef().apply(pre, sym, args2);
        }

        public static /* synthetic */ Types.RefinedType refinedType$(SymbolTableInternal $this, List parents, Scopes.Scope decls) {
            return $this.refinedType((List<Types.Type>)parents, decls);
        }

        default public Types.RefinedType refinedType(List<Types.Type> parents, Scopes.Scope decls) {
            return new Types.RefinedType((SymbolTable)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer(), parents, decls);
        }

        public static /* synthetic */ Types.RefinedType refinedType$(SymbolTableInternal $this, List parents, Scopes.Scope decls, Symbols.Symbol clazz) {
            return $this.refinedType((List<Types.Type>)parents, decls, clazz);
        }

        default public Types.RefinedType refinedType(List<Types.Type> parents, Scopes.Scope decls, Symbols.Symbol clazz) {
            return ((Types)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).RefinedType().apply(parents, decls, clazz);
        }

        public static /* synthetic */ Types.Type refinedType$(SymbolTableInternal $this, List parents, Symbols.Symbol owner) {
            return $this.refinedType((List<Types.Type>)parents, owner);
        }

        default public Types.Type refinedType(List<Types.Type> parents, Symbols.Symbol owner) {
            return ((Types)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).refinedType(parents, owner);
        }

        public static /* synthetic */ Types.Type refinedType$(SymbolTableInternal $this, List parents, Symbols.Symbol owner, Scopes.Scope decls) {
            return $this.refinedType((List<Types.Type>)parents, owner, decls);
        }

        default public Types.Type refinedType(List<Types.Type> parents, Symbols.Symbol owner, Scopes.Scope decls) {
            return ((Types)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).RefinedType().apply(parents, decls, owner);
        }

        public static /* synthetic */ Types.Type refinedType$(SymbolTableInternal $this, List parents, Symbols.Symbol owner, Scopes.Scope decls, Position pos) {
            return $this.refinedType(parents, owner, decls, pos);
        }

        default public Types.Type refinedType(List<Types.Type> parents, Symbols.Symbol owner, Scopes.Scope decls, Position pos) {
            return ((Types)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).refinedType(parents, owner, decls, pos);
        }

        public static /* synthetic */ Types.Type intersectionType$(SymbolTableInternal $this, List tps) {
            return $this.intersectionType(tps);
        }

        default public Types.Type intersectionType(List<Types.Type> tps) {
            return ((Types)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).intersectionType(tps);
        }

        public static /* synthetic */ Types.Type intersectionType$(SymbolTableInternal $this, List tps, Symbols.Symbol owner) {
            return $this.intersectionType(tps, owner);
        }

        default public Types.Type intersectionType(List<Types.Type> tps, Symbols.Symbol owner) {
            return ((Types)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).intersectionType(tps, owner);
        }

        public static /* synthetic */ Types.ClassInfoType classInfoType$(SymbolTableInternal $this, List parents, Scopes.Scope decls, Symbols.Symbol typeSymbol) {
            return $this.classInfoType(parents, decls, typeSymbol);
        }

        default public Types.ClassInfoType classInfoType(List<Types.Type> parents, Scopes.Scope decls, Symbols.Symbol typeSymbol) {
            return new Types.ClassInfoType((SymbolTable)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer(), parents, decls, typeSymbol);
        }

        public static /* synthetic */ Types.MethodType methodType$(SymbolTableInternal $this, List params, Types.Type resultType) {
            return $this.methodType(params, resultType);
        }

        default public Types.MethodType methodType(List<Symbols.Symbol> params, Types.Type resultType) {
            return new Types.MethodType((SymbolTable)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer(), params, resultType);
        }

        public static /* synthetic */ Types.NullaryMethodType nullaryMethodType$(SymbolTableInternal $this, Types.Type resultType) {
            return $this.nullaryMethodType(resultType);
        }

        default public Types.NullaryMethodType nullaryMethodType(Types.Type resultType) {
            return new Types.NullaryMethodType((SymbolTable)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer(), resultType);
        }

        public static /* synthetic */ Types.PolyType polyType$(SymbolTableInternal $this, List typeParams, Types.Type resultType) {
            return $this.polyType(typeParams, resultType);
        }

        default public Types.PolyType polyType(List<Symbols.Symbol> typeParams, Types.Type resultType) {
            return new Types.PolyType((SymbolTable)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer(), typeParams, resultType);
        }

        public static /* synthetic */ Types.ExistentialType existentialType$(SymbolTableInternal $this, List quantified, Types.Type underlying) {
            return $this.existentialType(quantified, underlying);
        }

        default public Types.ExistentialType existentialType(List<Symbols.Symbol> quantified, Types.Type underlying) {
            return new Types.ExistentialType((SymbolTable)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer(), quantified, underlying);
        }

        public static /* synthetic */ Types.Type existentialAbstraction$(SymbolTableInternal $this, List tparams, Types.Type tpe0) {
            return $this.existentialAbstraction(tparams, tpe0);
        }

        default public Types.Type existentialAbstraction(List<Symbols.Symbol> tparams, Types.Type tpe0) {
            return ((Types)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).existentialAbstraction(tparams, tpe0);
        }

        public static /* synthetic */ Types.AnnotatedType annotatedType$(SymbolTableInternal $this, List annotations, Types.Type underlying) {
            return $this.annotatedType(annotations, underlying);
        }

        default public Types.AnnotatedType annotatedType(List<AnnotationInfos.AnnotationInfo> annotations, Types.Type underlying) {
            return new Types.AnnotatedType((SymbolTable)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer(), annotations, underlying);
        }

        public static /* synthetic */ Types.TypeBounds typeBounds$(SymbolTableInternal $this, Types.Type lo, Types.Type hi) {
            return $this.typeBounds(lo, hi);
        }

        default public Types.TypeBounds typeBounds(Types.Type lo, Types.Type hi) {
            return ((Types)((Object)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).TypeBounds().apply(lo, hi);
        }

        public static /* synthetic */ Types.BoundedWildcardType boundedWildcardType$(SymbolTableInternal $this, Types.TypeBounds bounds) {
            return $this.boundedWildcardType(bounds);
        }

        default public Types.BoundedWildcardType boundedWildcardType(Types.TypeBounds bounds) {
            return new Types.BoundedWildcardType((SymbolTable)this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer(), bounds);
        }

        public static /* synthetic */ Option subpatterns$(SymbolTableInternal $this, Trees.Tree tree) {
            return $this.subpatterns(tree);
        }

        default public Option<List<Trees.Tree>> subpatterns(Trees.Tree tree) {
            Option option;
            Option option2 = tree.attachments().get(ClassTag$.MODULE$.apply(StdAttachments.SubpatternsAttachment.class));
            if (option2 == null) {
                throw null;
            }
            Option map_this = option2;
            if (map_this.isEmpty()) {
                option = None$.MODULE$;
            } else {
                StdAttachments.SubpatternsAttachment subpatternsAttachment = (StdAttachments.SubpatternsAttachment)map_this.get();
                option = new Some<List>(SymbolTableInternal.$anonfun$subpatterns$1(this, subpatternsAttachment));
            }
            return option;
        }

        public static /* synthetic */ Universe.MacroInternalApi.MacroDecoratorApi decorators$(SymbolTableInternal $this) {
            return $this.decorators();
        }

        @Override
        default public Universe.MacroInternalApi.MacroDecoratorApi decorators() {
            return new Universe.MacroInternalApi.MacroDecoratorApi(this){
                private final /* synthetic */ SymbolTableInternal $outer;

                public <T extends Types.TypeApi> Internals.InternalApi.DecoratorApi.TypeDecoratorApi<T> TypeDecoratorApi(T tp) {
                    return Internals.InternalApi.DecoratorApi.TypeDecoratorApi$(this, tp);
                }

                public <T extends Scopes.Scope> Universe.MacroInternalApi.MacroDecoratorApi.MacroScopeDecoratorApi<T> scopeDecorator(T scope) {
                    return new Universe.MacroInternalApi.MacroDecoratorApi.MacroScopeDecoratorApi((Universe.MacroInternalApi.MacroDecoratorApi)this, scope);
                }

                public <T extends Trees.Tree> Universe.MacroInternalApi.MacroDecoratorApi.MacroTreeDecoratorApi<T> treeDecorator(T tree) {
                    return new Universe.MacroInternalApi.MacroDecoratorApi.MacroTreeDecoratorApi((Universe.MacroInternalApi.MacroDecoratorApi)this, tree);
                }

                public <T extends Trees.TypeTree> Universe.MacroInternalApi.MacroDecoratorApi.MacroTypeTreeDecoratorApi<T> typeTreeDecorator(T tt) {
                    return new Universe.MacroInternalApi.MacroDecoratorApi.MacroTypeTreeDecoratorApi((Universe.MacroInternalApi.MacroDecoratorApi)this, tt);
                }

                public <T extends Symbols.Symbol> Universe.MacroInternalApi.MacroDecoratorApi.MacroSymbolDecoratorApi<T> symbolDecorator(T symbol) {
                    return new Universe.MacroInternalApi.MacroDecoratorApi.MacroSymbolDecoratorApi((Universe.MacroInternalApi.MacroDecoratorApi)this, symbol);
                }

                public <T extends Types.Type> Internals.InternalApi.DecoratorApi.TypeDecoratorApi<T> typeDecorator(T tp) {
                    return new Internals.InternalApi.DecoratorApi.TypeDecoratorApi((Internals.InternalApi.DecoratorApi)this, tp);
                }

                public /* synthetic */ Universe.MacroInternalApi scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer() {
                    return this.$outer;
                }

                public /* synthetic */ Internals.InternalApi scala$reflect$api$Internals$InternalApi$DecoratorApi$$$outer() {
                    return this.$outer;
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    Internals.InternalApi.DecoratorApi.$init$(this);
                    Universe.MacroInternalApi.MacroDecoratorApi.$init$(this);
                }
            };
        }

        public /* synthetic */ Internals scala$reflect$internal$Internals$SymbolTableInternal$$$outer();

        public static /* synthetic */ List $anonfun$subpatterns$1(SymbolTableInternal $this, StdAttachments.SubpatternsAttachment x$1) {
            return x$1.patterns().map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)tree -> ((Trees)((Object)$this.scala$reflect$internal$Internals$SymbolTableInternal$$$outer())).duplicateAndKeepPositions((Trees.Tree)tree), List$.MODULE$.canBuildFrom());
        }

        public static void $init$(SymbolTableInternal $this) {
        }
    }
}

