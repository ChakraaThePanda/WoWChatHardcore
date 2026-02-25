/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.macros;

import scala.Option;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.immutable.List;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Annotations;
import scala.reflect.api.Internals;
import scala.reflect.api.Names;
import scala.reflect.api.Position;
import scala.reflect.api.Scopes;
import scala.reflect.api.Symbols;
import scala.reflect.api.Trees;
import scala.reflect.api.Types;
import scala.reflect.internal.util.SourceFile;
import scala.reflect.macros.Attachments;

@ScalaSignature(bytes="\u0006\u0001\u001d\u001da\u0001CA\u0013\u0003O\t\t!!\u000e\t\u000f\u0005\u0005\u0003\u0001\"\u0001\u0002D\u00119\u0011\u0011\n\u0001\u0003B\u0005-c!CA-\u0001A\u0005\u0019\u0011AA.\u0011\u001d\tig\u0001C\u0001\u0003_Bq!a\u001e\u0004\r\u0003\tI\bC\u0004\u0002\u001c\u000e1\t!!(\t\u000f\u0005\u00156A\"\u0001\u0002(\"I\u0011\u0011Y\u0002C\u0002\u001b\u0005\u00111\u0019\u0005\b\u0005c\u001ba\u0011\u0001BZ\u0011\u001d\u0011\u0019n\u0001D\u0001\u0005+DqA!@\u0004\r\u0003\u0011y\u0010C\u0004\u0004\u0014\r1\ta!\u0006\t\u000f\r}1A\"\u0001\u0004\"!91\u0011F\u0002\u0007\u0002\r-\u0002bBB#\u0007\u0019\u00051q\t\u0005\b\u0007#\u001aa\u0011AB*\u0011\u001d\u0019Yf\u0001D\u0001\u0007;Bqa!\u001d\u0004\r\u0003\u0019\u0019\bC\u0004\u00032\u000e1\taa\u001f\t\u000f\tM7A\"\u0001\u0004\u0006\"9!Q`\u0002\u0007\u0002\rm\u0005bBBX\u0007\u0019\u00051\u0011\u0017\u0005\b\u0007w\u001ba\u0011AB_\u0011\u001d\u0019)m\u0001D\u0001\u0007\u000fDqaa4\u0004\r\u0003\u0019\t\u000eC\u0004\u0004Z\u000e1\taa7\t\u000f\r-8A\"\u0001\u0004n\"911_\u0002\u0007\u0002\rU\bbBB}\u0007\u0019\u000511 \u0005\b\u0007\u007f\u001ca\u0011\u0001C\u0001\t\u001d!Ya\u0001B!\t\u001b1\u0011\u0002b\u0005\u0004!\u0003\r\t\u0001\"\u0006\t\u000f\u00055\u0004\u0005\"\u0001\u0002p\u00119AQ\u0004\u0011\u0003\u0002\u0011}\u0001b\u0002C%A\u0019\rA1\n\u0004\u0007\tO\u0001\u0003\u0001\"\u000b\t\u0015\u0005\u0005EE!b\u0001\n\u0003!i\u0003\u0003\u0006\u00056\u0011\u0012\t\u0011)A\u0005\t_Aq!!\u0011%\t\u0003!9\u0004C\u0004\u0002x\u0011\"\t\u0001\"\u0010\t\u000f\u0005mE\u0005\"\u0001\u0005B\u00119Aq\u000b\u0011\u0003B\u0011ecA\u0002C0A\u0001!\t\u0007\u0003\u0006\u0002..\u0012)\u0019!C!\tcBA\u0002b\u001d,\u0005\u0003\u0005\u000b\u0011\u0002C6\tkBq!!\u0011,\t\u0003!9\bC\u0004\u0002&.\"\t\u0001\" \t\u000f\tE6\u0006\"\u0001\u0005\b\"9!1[\u0016\u0005\u0002\u0011=\u0005b\u0002B\u007fW\u0011\u0005A1\u0015\u0005\b\u0007_[C\u0011\u0001CY\u0011\u001d\u0019Yl\u000bC\u0001\tkCqa!2,\t\u0003!I\fC\u0004\u0004P.\"\t\u0001\"0\u0005\u000f\u0011\u0015\u0007E!\u0001\u0005H\"9A1\u001e\u0011\u0007\u0004\u00115hA\u0002CgA\u0001!y\r\u0003\u0006\u0004ff\u0012)\u0019!C\u0001\t'D!\u0002b7:\u0005\u0003\u0005\u000b\u0011\u0002Ck\u0011\u001d\t\t%\u000fC\u0001\t;Dqa!7:\t\u0003!\u0019\u000fB\u0004\u0005z\u0002\u0012\t\u0005b?\u0007\r\u0015\u0005\u0001\u0005AC\u0002\u0011)\u0011\tn\u0010BC\u0002\u0013\u0005S1\u0003\u0005\r\u000b+y$\u0011!Q\u0001\n\u00155Qq\u0003\u0005\b\u0003\u0003zD\u0011AC\r\u0011\u001d\u0011\tl\u0010C\u0001\u000b?AqAa5@\t\u0003)9\u0003C\u0004\u0003~~\"\t!\"\u000f\t\u000f\rMq\b\"\u0001\u0006H!91qD \u0005\u0002\u0015-\u0003bBB\u0015\u007f\u0011\u0005Qq\n\u0005\b\u0007\u000bzD\u0011AC*\u0011\u001d\u0019\tf\u0010C\u0001\u000b/Bqaa\u0017@\t\u0003)Y\u0006C\u0004\u0004r}\"\t!b\u0018\u0007\u0013\u0005\u001d\u0007\u0001%A\u0012\u0002\u0005%\u0007bBAf\u001b\u001a\u0005\u0011Q\u001a\u0005\b\u0003\u0017le\u0011AAo\u0011\u001d\t)/\u0014D\u0001\u0003ODq!!:N\r\u0003\t)\u0010C\u0004\u0002z63\t!a?\t\u000f\u0005}XJ\"\u0001\u0003\u0002!9\u0011q`'\u0007\u0002\t\u001d\u0001b\u0002B\u0006\u001b\u001a\u0005!Q\u0002\u0005\b\u0005\u0017ie\u0011\u0001B\t\u0011\u001d\u0011\t#\u0014D\u0001\u0005GAqA!\fN\r\u0003\u0011y\u0003C\u0004\u0003453\tA!\u000e\t\u000f\tuRJ\"\u0001\u0003@!9!QH'\u0007\u0002\t\u0005\u0004b\u0002B\u001f\u001b\u001a\u0005!1\u000e\u0005\b\u0005{ie\u0011\u0001B9\u0011\u001d\u0011i$\u0014D\u0001\u0005sBqA!\u0010N\r\u0003\u0011\t\tC\u0004\u0003>53\tAa#\t\u000f\tMUJ\"\u0001\u0003\u0016\"9!1T'\u0007\u0002\tu\u0005b\u0002BP\u001b\u001a\u0005!\u0011\u0015\u0005\b\u0005Oke\u0011\u0001BU\u0011%)9\u0007\u0001b\u0001\u000e\u0003\t\u0019\rB\u0004\u0006z\u0001\u0011\t!b\u001f\u0007\u0013\u0015}\u0004\u0001%A\u0002\u0002\u0015\u0005\u0005bBA7O\u0012\u0005\u0011q\u000e\u0004\u0007\u000b\u0013;\u0017!b#\t\u0015\tE\u0017N!A!\u0002\u0013\t\t\nC\u0004\u0002B%$\t!\"$\t\u000f\tE\u0016\u000e\"\u0001\u0006\u0016\"9!1[5\u0005\u0002\u0015\r\u0006b\u0002B\u007fS\u0012\u0005Q1\u0018\u0005\b\u000b\u001fLG\u0011ACi\u0011\u001d\u0019I#\u001bC\u0001\u000b7Dqa!\u0012j\t\u0003))\u000fC\u0004\u0004R%$\t!b<\t\u0013\u0015ex-!A\u0005\u0004\u0015mhABC\u0000O\u00061\t\u0001\u0003\u0006\u0002.R\u0014\t\u0011)A\u0005\u0003_Cq!!\u0011u\t\u00031\u0019\u0001C\u0004\u00032R$\tA\"\u0003\t\u000f\tMG\u000f\"\u0001\u0007\u0014!9!Q ;\u0005\u0002\u0019\u001d\u0002b\u0002D\u001ci\u0012\u0005a\u0011\b\u0005\b\u0007_#H\u0011\u0001D#\u0011\u001d1Y\u0005\u001eC\u0001\r\u001bBqaa/u\t\u00031I\u0006C\u0004\u0004FR$\tAb\u0018\t\u000f\u0019%D\u000f\"\u0001\u0007l!91q\u001a;\u0005\u0002\u0019U\u0004\"\u0003D>O\u0006\u0005I1\u0001D?\r\u00191\tiZ\u0001\u0007\u0004\"Y1Q]A\u0003\u0005\u0003\u0005\u000b\u0011BBo\u0011!\t\t%!\u0002\u0005\u0002\u0019\u0015\u0005\u0002CBm\u0003\u000b!\tAb#\t\u0013\u0019Uu-!A\u0005\u0004\u0019]\u0005bBBvO\u0012\u0005a1\u0014\u0005\b\u0007g<G\u0011\u0001DS\u0011\u001d\u0019Ip\u001aC\u0001\r_#qA\"/\u0001\u0005\u00031YLB\u0005\u0007@\u0002\u0001\n1%\u0001\u0007B\"Aa1YA\f\r\u00031)\r\u0003\u0005\u0007x\u0006]a\u0011\u0001D}\t\u001d1I\r\u0001B\u0001\r\u00174\u0011Bb4\u0001!\u0003\r\nA\"5\t\u0011\u0019M\u0017q\u0004D\u0001\r+D\u0001B\"<\u0002 \u0019\u0005!Q\u0014\u0002\t+:Lg/\u001a:tK*!\u0011\u0011FA\u0016\u0003\u0019i\u0017m\u0019:pg*!\u0011QFA\u0018\u0003\u001d\u0011XM\u001a7fGRT!!!\r\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M\u0019\u0001!a\u000e\u0011\t\u0005e\u0012qH\u0007\u0003\u0003wQA!!\u0010\u0002,\u0005\u0019\u0011\r]5\n\t\u0005\u0015\u00121H\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005\u0005\u0015\u0003cAA$\u00015\u0011\u0011q\u0005\u0002\t\u0013:$XM\u001d8bYF!\u0011QJA+!\u0011\ty%!\u0015\u000e\u0005\u0005=\u0012\u0002BA*\u0003_\u0011qAT8uQ&tw\rE\u0002\u0002X\ri\u0011\u0001\u0001\u0002\u0011\u001b\u0006\u001c'o\\%oi\u0016\u0014h.\u00197Ba&\u001cRaAA/\u0003G\u0002B!a\u0014\u0002`%!\u0011\u0011MA\u0018\u0005\u0019\te.\u001f*fMB!\u0011qKA3\u0013\u0011\t9'!\u001b\u0003\u0017%sG/\u001a:oC2\f\u0005/[\u0005\u0005\u0003W\nYDA\u0005J]R,'O\\1mg\u00061A%\u001b8ji\u0012\"\"!!\u001d\u0011\t\u0005=\u00131O\u0005\u0005\u0003k\nyC\u0001\u0003V]&$\u0018!B3oi\u0016\u0014HCBA>\u0003\u007f\niI\u0004\u0003\u0002~\u0005}D\u0002\u0001\u0005\b\u0003\u0003+\u0001\u0019AAB\u0003\u0015\u00198m\u001c9f!\u0011\t9&!\"\n\t\u0005\u001d\u0015\u0011\u0012\u0002\u0006'\u000e|\u0007/Z\u0005\u0005\u0003\u0017\u000bYD\u0001\u0004TG>\u0004Xm\u001d\u0005\b\u0003\u001f+\u0001\u0019AAI\u0003\r\u0019\u00180\u001c\t\u0005\u0003/\n\u0019*\u0003\u0003\u0002\u0016\u0006]%AB*z[\n|G.\u0003\u0003\u0002\u001a\u0006m\"aB*z[\n|Gn]\u0001\u0007k:d\u0017N\\6\u0015\r\u0005}\u0015\u0011UAR\u001d\u0011\ti(!)\t\u000f\u0005\u0005e\u00011\u0001\u0002\u0004\"9\u0011q\u0012\u0004A\u0002\u0005E\u0015aC2iC:<WmT<oKJ$\u0002\"!+\u0002,\u0006e\u0016Q\u0018\b\u0005\u0003{\nY\u000bC\u0004\u0002.\u001e\u0001\r!a,\u0002\tQ\u0014X-\u001a\t\u0005\u0003/\n\t,\u0003\u0003\u00024\u0006U&\u0001\u0002+sK\u0016LA!a.\u0002<\t)AK]3fg\"9\u00111X\u0004A\u0002\u0005E\u0015\u0001\u00029sKZDq!a0\b\u0001\u0004\t\t*\u0001\u0003oKb$\u0018aA4f]V\u0011\u0011Q\u0019\t\u0004\u0003/j%a\u0002+sK\u0016<UM\\\n\u0004\u001b\u0006u\u0013!F7l\u0003R$(/\u001b2vi\u0016$\u0017+^1mS\u001aLWM\u001d\u000b\u0005\u0003_\u000by\rC\u0004\u0002R:\u0003\r!a5\u0002\u0007Q\u0004X\r\u0005\u0003\u0002X\u0005U\u0017\u0002BAl\u00033\u0014A\u0001V=qK&!\u00111\\A\u001e\u0005\u0015!\u0016\u0010]3t)\u0019\ty+a8\u0002b\"9\u0011\u0011[(A\u0002\u0005M\u0007bBAr\u001f\u0002\u0007\u0011\u0011S\u0001\bi\u0016\u0014XnU=n\u0003=i7.\u0011;ue&\u0014W\u000f^3e%\u00164GCBAu\u0003_\f\u0019\u0010\u0005\u0003\u0002X\u0005-\u0018\u0002BAw\u0003k\u0013qAU3g)J,W\rC\u0004\u0002rB\u0003\r!a5\u0002\u0007A\u0014X\rC\u0004\u0002\u0010B\u0003\r!!%\u0015\t\u0005%\u0018q\u001f\u0005\b\u0003\u001f\u000b\u0006\u0019AAI\u0003%\u0019H/\u00192jY&TX\r\u0006\u0003\u00020\u0006u\bbBAW%\u0002\u0007\u0011qV\u0001\u0016[.\fE\u000f\u001e:jEV$X\rZ*uC\ndWMU3g)\u0019\tyKa\u0001\u0003\u0006!9\u0011\u0011_*A\u0002\u0005M\u0007bBAH'\u0002\u0007\u0011\u0011\u0013\u000b\u0005\u0003_\u0013I\u0001C\u0004\u0002\u0010R\u0003\r!!%\u0002#5\\WK\\1uiJL'-\u001e;fIJ+g\r\u0006\u0003\u0002j\n=\u0001bBAH+\u0002\u0007\u0011\u0011\u0013\u000b\u0005\u0003S\u0014\u0019\u0002C\u0004\u0003\u0016Y\u0003\rAa\u0006\u0002\u0011\u0019,H\u000e\u001c(b[\u0016\u0004B!a\u0016\u0003\u001a%!!1\u0004B\u000f\u0005\u0011q\u0015-\\3\n\t\t}\u00111\b\u0002\u0006\u001d\u0006lWm]\u0001\u0011[.\fE\u000f\u001e:jEV$X\r\u001a+iSN$BA!\n\u0003,A!\u0011q\u000bB\u0014\u0013\u0011\u0011I#!.\u0003\tQC\u0017n\u001d\u0005\b\u0003\u001f;\u0006\u0019AAI\u0003Ei7.\u0011;ue&\u0014W\u000f^3e\u0013\u0012,g\u000e\u001e\u000b\u0005\u0003S\u0014\t\u0004C\u0004\u0002\u0010b\u0003\r!!%\u0002%5\\\u0017\t\u001e;sS\n,H/\u001a3TK2,7\r\u001e\u000b\u0007\u0003S\u00149Da\u000f\t\u000f\te\u0012\f1\u0001\u00020\u0006!\u0011/^1m\u0011\u001d\ty)\u0017a\u0001\u0003#\u000bA\"\\6NKRDw\u000eZ\"bY2$\"\"a,\u0003B\t\u0015#\u0011\nB.\u0011\u001d\u0011\u0019E\u0017a\u0001\u0003#\u000b\u0001B]3dK&4XM\u001d\u0005\b\u0005\u000fR\u0006\u0019\u0001B\f\u0003)iW\r\u001e5pI:\u000bW.\u001a\u0005\b\u0005\u0017R\u0006\u0019\u0001B'\u0003\u0015!\u0018M]4t!\u0019\u0011yE!\u0016\u0002T:!\u0011q\nB)\u0013\u0011\u0011\u0019&a\f\u0002\u000fA\f7m[1hK&!!q\u000bB-\u0005\u0011a\u0015n\u001d;\u000b\t\tM\u0013q\u0006\u0005\b\u0005;R\u0006\u0019\u0001B0\u0003\u0011\t'oZ:\u0011\r\t=#QKAX)!\tyKa\u0019\u0003h\t%\u0004b\u0002B37\u0002\u0007\u0011\u0011S\u0001\u0007[\u0016$\bn\u001c3\t\u000f\t-3\f1\u0001\u0003N!9!QL.A\u0002\t}CCBAX\u0005[\u0012y\u0007C\u0004\u0003fq\u0003\r!!%\t\u000f\tuC\f1\u0001\u0003`Q1\u0011q\u0016B:\u0005oBqA!\u001e^\u0001\u0004\ty+\u0001\u0004uCJ<W\r\u001e\u0005\b\u0005;j\u0006\u0019\u0001B0)!\tyKa\u001f\u0003~\t}\u0004b\u0002B\"=\u0002\u0007\u0011\u0011\u0013\u0005\b\u0005\u000fr\u0006\u0019\u0001B\f\u0011\u001d\u0011iF\u0018a\u0001\u0005?\"\"\"a,\u0003\u0004\n\u0015%q\u0011BE\u0011\u001d\u0011\u0019e\u0018a\u0001\u0003_CqA!\u001a`\u0001\u0004\t\t\nC\u0004\u0003L}\u0003\rA!\u0014\t\u000f\tus\f1\u0001\u0003`QA\u0011q\u0016BG\u0005\u001f\u0013\t\nC\u0004\u0003v\u0001\u0004\r!a,\t\u000f\t-\u0003\r1\u0001\u0003N!9!Q\f1A\u0002\t}\u0013!D7l\u001dVdG.\u0019:z\u0007\u0006dG\u000e\u0006\u0004\u00020\n]%\u0011\u0014\u0005\b\u0005K\n\u0007\u0019AAI\u0011\u001d\u0011Y%\u0019a\u0001\u0005\u001b\nA#\\6Sk:$\u0018.\\3V]&4XM]:f%\u00164WCAAX\u0003\u0019i7NW3s_R!\u0011q\u0016BR\u0011\u001d\u0011)k\u0019a\u0001\u0003'\f!\u0001\u001e9\u0002\r5\\7)Y:u)\u0019\tyKa+\u0003.\"9\u0011Q\u00163A\u0002\u0005=\u0006b\u0002BXI\u0002\u0007\u00111[\u0001\u0003aR\f1\"\u0019;uC\u000eDW.\u001a8ugR!!Q\u0017Bh%\u0011\u00119La/\u0007\r\te6\u0001\u0001B[\u00051a$/\u001a4j]\u0016lWM\u001c;?!\u0011\t9E!0\n\t\t}\u0016q\u0005\u0002\f\u0003R$\u0018m\u00195nK:$8/B\u0004\u0003D\n]\u0006E!2\u0003\u0007A{7\u000f\u0005\u0003\u0002X\t\u001d\u0017\u0002\u0002Be\u0005\u0017\u0014\u0001\u0002U8tSRLwN\\\u0005\u0005\u0005\u001b\fYDA\u0005Q_NLG/[8og\"9!\u0011[\u0005A\u0002\u0005E\u0015AB:z[\n|G.\u0001\tva\u0012\fG/Z!ui\u0006\u001c\u0007.\\3oiV!!q\u001bBw)\u0019\u0011IN!8\u0003zR!!1\u001cBp\u001d\u0011\tiH!8\t\u000f\tE'\u00021\u0001\u0002\u0012\"I!\u0011\u001d\u0006\u0002\u0002\u0003\u000f!1]\u0001\u000bKZLG-\u001a8dK\u0012\n\u0004C\u0002Bs\u0005O\u0014Y/\u0004\u0002\u0002,%!!\u0011^A\u0016\u0005!\u0019E.Y:t)\u0006<\u0007\u0003BA?\u0005[$qAa<\u000b\u0005\u0004\u0011\tPA\u0001U#\u0011\tiEa=\u0011\t\u0005=#Q_\u0005\u0005\u0005o\fyCA\u0002B]fDqAa?\u000b\u0001\u0004\u0011Y/\u0001\u0006biR\f7\r[7f]R\f\u0001C]3n_Z,\u0017\t\u001e;bG\"lWM\u001c;\u0016\t\r\u00051\u0011\u0003\u000b\u0005\u0007\u0007\u00199\u0001\u0006\u0003\u0004\u0006\r%a\u0002BA?\u0007\u000fAqA!5\f\u0001\u0004\t\t\nC\u0005\u0004\f-\t\t\u0011q\u0001\u0004\u000e\u0005QQM^5eK:\u001cW\r\n\u001a\u0011\r\t\u0015(q]B\b!\u0011\tih!\u0005\u0005\u000f\t=8B1\u0001\u0003r\u0006A1/\u001a;Po:,'\u000f\u0006\u0004\u0004\u0018\re11\u0004\b\u0005\u0003{\u001aI\u0002C\u0004\u0003R2\u0001\r!!%\t\u000f\ruA\u00021\u0001\u0002\u0012\u0006Aa.Z<po:,'/A\u0004tKRLeNZ8\u0015\r\r\r2QEB\u0014\u001d\u0011\tih!\n\t\u000f\tEW\u00021\u0001\u0002\u0012\"9\u0011\u0011[\u0007A\u0002\u0005M\u0017AD:fi\u0006sgn\u001c;bi&|gn\u001d\u000b\u0007\u0007[\u0019yc!\r\u000f\t\u0005u4q\u0006\u0005\b\u0005#t\u0001\u0019AAI\u0011\u001d\u0019\u0019D\u0004a\u0001\u0007k\ta!\u00198o_R\u001c\bCBA(\u0007o\u0019Y$\u0003\u0003\u0004:\u0005=\"A\u0003\u001fsKB,\u0017\r^3e}A!\u0011qKB\u001f\u0013\u0011\u0019yd!\u0011\u0003\u0015\u0005sgn\u001c;bi&|g.\u0003\u0003\u0004D\u0005m\"aC!o]>$\u0018\r^5p]N\fqa]3u\u001d\u0006lW\r\u0006\u0004\u0004J\r-3Q\n\b\u0005\u0003{\u001aY\u0005C\u0004\u0003R>\u0001\r!!%\t\u000f\r=s\u00021\u0001\u0003\u0018\u0005!a.Y7f\u0003A\u0019X\r\u001e)sSZ\fG/Z,ji\"Lg\u000e\u0006\u0004\u0004V\r]3\u0011\f\b\u0005\u0003{\u001a9\u0006C\u0004\u0003RB\u0001\r!!%\t\u000f\u0005=\u0005\u00031\u0001\u0002\u0012\u000691/\u001a;GY\u0006<GCBB0\u0007C\u001a\u0019G\u0004\u0003\u0002~\r\u0005\u0004b\u0002Bi#\u0001\u0007\u0011\u0011\u0013\u0005\b\u0007K\n\u0002\u0019AB4\u0003\u00151G.Y4t!\u0011\t9f!\u001b\n\t\r-4Q\u000e\u0002\b\r2\fwmU3u\u0013\u0011\u0019y'a\u000f\u0003\u0011\u0019c\u0017mZ*fiN\f\u0011B]3tKR4E.Y4\u0015\r\rU4qOB=\u001d\u0011\tiha\u001e\t\u000f\tE'\u00031\u0001\u0002\u0012\"91Q\r\nA\u0002\r\u001dD\u0003BB?\u0007\u0007\u0013Baa \u0003<\u001a1!\u0011X\u0002\u0001\u0007{*qAa1\u0004\u0000\u0001\u0012)\rC\u0004\u0002.N\u0001\r!a,\u0016\t\r\u001d5q\u0013\u000b\u0007\u0007\u0013\u001bii!'\u0015\t\r-5q\u0012\b\u0005\u0003{\u001ai\tC\u0004\u0002.R\u0001\r!a,\t\u0013\rEE#!AA\u0004\rM\u0015AC3wS\u0012,gnY3%gA1!Q\u001dBt\u0007+\u0003B!! \u0004\u0018\u00129!q\u001e\u000bC\u0002\tE\bb\u0002B~)\u0001\u00071QS\u000b\u0005\u0007;\u001bi\u000b\u0006\u0003\u0004 \u000e\rF\u0003BBQ\u0007KsA!! \u0004$\"9\u0011QV\u000bA\u0002\u0005=\u0006\"CBT+\u0005\u0005\t9ABU\u0003))g/\u001b3f]\u000e,G\u0005\u000e\t\u0007\u0005K\u00149oa+\u0011\t\u0005u4Q\u0016\u0003\b\u0005_,\"\u0019\u0001By\u0003\u0019\u0019X\r\u001e)pgR111WB[\u0007osA!! \u00046\"9\u0011Q\u0016\fA\u0002\u0005=\u0006bBB]-\u0001\u0007!QY\u0001\u0007]\u0016<\bo\\:\u0002\u000fM,G\u000fV=qKR11qXBa\u0007\u0007tA!! \u0004B\"9\u0011QV\fA\u0002\u0005=\u0006b\u0002BS/\u0001\u0007\u00111[\u0001\u000bI\u00164\u0017N\\3UsB,GCBBe\u0007\u0017\u001ciM\u0004\u0003\u0002~\r-\u0007bBAW1\u0001\u0007\u0011q\u0016\u0005\b\u0005KC\u0002\u0019AAj\u0003%\u0019X\r^*z[\n|G\u000e\u0006\u0004\u0004T\u000eU7q\u001b\b\u0005\u0003{\u001a)\u000eC\u0004\u0002.f\u0001\r!a,\t\u000f\u0005=\u0015\u00041\u0001\u0002\u0012\u0006Y1/\u001a;Pe&<\u0017N\\1m)\u0019\u0019ina9\u0004hB!\u0011qKBp\u0013\u0011\u0019\t/!.\u0003\u0011QK\b/\u001a+sK\u0016Dqa!:\u001b\u0001\u0004\u0019i.\u0001\u0002ui\"91\u0011\u001e\u000eA\u0002\u0005=\u0016\u0001C8sS\u001eLg.\u00197\u0002\u001f\r\f\u0007\u000f^;sKZ\u000b'/[1cY\u0016$B!!\u001d\u0004p\"91\u0011_\u000eA\u0002\u0005E\u0015\u0001\u0002<cY\u0016\f\u0011D]3gKJ,gnY3DCB$XO]3e-\u0006\u0014\u0018.\u00192mKR!\u0011qVB|\u0011\u001d\u0019\t\u0010\ba\u0001\u0003#\u000bAcY1qiV\u0014X\r\u001a,be&\f'\r\\3UsB,G\u0003BAj\u0007{Dqa!=\u001e\u0001\u0004\t\t*A\u0006tk\n\u0004\u0018\r\u001e;fe:\u001cH\u0003\u0002C\u0002\t\u0013\u0001b!a\u0014\u0005\u0006\t}\u0013\u0002\u0002C\u0004\u0003_\u0011aa\u00149uS>t\u0007bBAW=\u0001\u0007\u0011q\u0016\u0002\u000b\t\u0016\u001cwN]1u_J\u001c\u0018\u0003BA'\t\u001f\u00012\u0001\"\u0005!\u001b\u0005\u0019!!E'bGJ|G)Z2pe\u0006$xN]!qSN)\u0001%!\u0018\u0005\u0018A!A\u0011\u0003C\r\u0013\u0011!Y\"!\u001a\u0003\u0019\u0011+7m\u001c:bi>\u0014\u0018\t]5\u0003\u001dM\u001bw\u000e]3EK\u000e|'/\u0019;peV!A\u0011\u0005C$#\u0011\ti\u0005b\t\u0011\u000b\u0011\u0015B\u0005\"\u0012\u000e\u0003\u0001\u0012a#T1de>\u001c6m\u001c9f\t\u0016\u001cwN]1u_J\f\u0005/[\u000b\u0005\tW!\tdE\u0002%\u0003;*\"\u0001b\f\u0011\t\u0005uD\u0011\u0007\u0003\b\u0005_$#\u0019\u0001C\u001a#\u0011\ti%a!\u0002\rM\u001cw\u000e]3!)\u0011!I\u0004b\u000f\u0011\u000b\u0011\u0015B\u0005b\f\t\u000f\u0005\u0005u\u00051\u0001\u00050Q!Aq\u0006C \u0011\u001d\ty\t\u000ba\u0001\u0003##B\u0001b\f\u0005D!9\u0011qR\u0015A\u0002\u0005E\u0005\u0003BA?\t\u000f\"qAa<#\u0005\u0004!\u0019$\u0001\btG>\u0004X\rR3d_J\fGo\u001c:\u0016\t\u00115C1\u000b\u000b\u0005\t\u001f\")\u0006E\u0003\u0005&\t\"\t\u0006\u0005\u0003\u0002~\u0011MCa\u0002BxG\t\u0007A1\u0007\u0005\b\u0003[\u001b\u0003\u0019\u0001C)\u00055!&/Z3EK\u000e|'/\u0019;peV!A1\fCb#\u0011\ti\u0005\"\u0018\u0011\u000b\u0011\u00152\u0006\"1\u0003+5\u000b7M]8Ue\u0016,G)Z2pe\u0006$xN]!qSV!A1\rC7'\rYCQ\r\t\u0007\tK!9\u0007b\u001b\n\t\u0011%D\u0011\u0004\u0002\u0011)J,W\rR3d_J\fGo\u001c:Ba&\u0004B!! \u0005n\u00119!q^\u0016C\u0002\u0011=\u0014\u0003BA'\u0003_+\"\u0001b\u001b\u0002\u000bQ\u0014X-\u001a\u0011\n\t\u00055Fq\r\u000b\u0005\ts\"Y\bE\u0003\u0005&-\"Y\u0007C\u0004\u0002.:\u0002\r\u0001b\u001b\u0015\r\u0011}D1\u0011CC\u001d\r!\t\tL\u0007\u0002W!9\u00111X\u0018A\u0002\u0005E\u0005bBA`_\u0001\u0007\u0011\u0011S\u000b\u0003\t\u0013\u0013B\u0001b#\u0003<\u001a1!\u0011X\u0016\u0001\t\u0013+qAa1\u0005\f\u0002\u0012)-\u0006\u0003\u0005\u0012\u0012uE\u0003\u0002CJ\tC#B\u0001b \u0005\u0016\"IAqS\u0019\u0002\u0002\u0003\u000fA\u0011T\u0001\u000bKZLG-\u001a8dK\u0012*\u0004C\u0002Bs\u0005O$Y\n\u0005\u0003\u0002~\u0011uEa\u0002CPc\t\u0007!\u0011\u001f\u0002\u0002\u0003\"9!1`\u0019A\u0002\u0011mU\u0003\u0002CS\t_#B\u0001b\u001b\u0005(\"IA\u0011\u0016\u001a\u0002\u0002\u0003\u000fA1V\u0001\u000bKZLG-\u001a8dK\u00122\u0004C\u0002Bs\u0005O$i\u000b\u0005\u0003\u0002~\u0011=Fa\u0002CPe\t\u0007!\u0011\u001f\u000b\u0005\tW\"\u0019\fC\u0004\u0004:N\u0002\rA!2\u0015\t\u0011-Dq\u0017\u0005\b\u0005K#\u0004\u0019AAj)\u0011!Y\u0007b/\t\u000f\t\u0015V\u00071\u0001\u0002TR!A1\u000eC`\u0011\u001d\tyI\u000ea\u0001\u0003#\u0003B!! \u0005D\u00129!q\u001e\u0016C\u0002\u0011=$!\u0005+za\u0016$&/Z3EK\u000e|'/\u0019;peV!A\u0011\u001aCu#\u0011\ti\u0005b3\u0011\u000b\u0011\u0015\u0012\bb:\u000335\u000b7M]8UsB,GK]3f\t\u0016\u001cwN]1u_J\f\u0005/[\u000b\u0005\t#$9nE\u0002:\u0003;*\"\u0001\"6\u0011\t\u0005uDq\u001b\u0003\b\u0005_L$\u0019\u0001Cm#\u0011\tie!8\u0002\u0007Q$\b\u0005\u0006\u0003\u0005`\u0012\u0005\b#\u0002C\u0013s\u0011U\u0007bBBsy\u0001\u0007AQ\u001b\u000b\u0005\u0007;$)\u000fC\u0004\u0002.v\u0002\r!a,\u0011\t\u0005uD\u0011\u001e\u0003\b\u0005_<$\u0019\u0001Cm\u0003E!\u0018\u0010]3Ue\u0016,G)Z2pe\u0006$xN]\u000b\u0005\t_$)\u0010\u0006\u0003\u0005r\u0012]\b#\u0002C\u0013o\u0011M\b\u0003BA?\tk$qAa<9\u0005\u0004!I\u000eC\u0004\u0004fb\u0002\r\u0001b=\u0003\u001fMKXNY8m\t\u0016\u001cwN]1u_J,B\u0001\"@\u0006fE!\u0011Q\nC\u0000!\u0015!)cPC2\u0005]i\u0015m\u0019:p'fl'm\u001c7EK\u000e|'/\u0019;pe\u0006\u0003\u0018.\u0006\u0003\u0006\u0006\u0015=1cA \u0006\bA1AQEC\u0005\u000b\u001bIA!b\u0003\u0005\u001a\t\u00112+_7c_2$UmY8sCR|'/\u00119j!\u0011\ti(b\u0004\u0005\u000f\t=xH1\u0001\u0006\u0012E!\u0011QJAI+\t)i!A\u0004ts6\u0014w\u000e\u001c\u0011\n\t\tEW\u0011\u0002\u000b\u0005\u000b7)i\u0002E\u0003\u0005&}*i\u0001C\u0004\u0003R\n\u0003\r!\"\u0004\u0016\u0005\u0015\u0005\"\u0003BC\u0012\u0005w3aA!/@\u0001\u0015\u0005Ra\u0002Bb\u000bG\u0001#QY\u000b\u0005\u000bS))\u0004\u0006\u0003\u0006,\u0015]B\u0003BC\u0007\u000b[A\u0011\"b\fE\u0003\u0003\u0005\u001d!\"\r\u0002\u0015\u00154\u0018\u000eZ3oG\u0016$s\u0007\u0005\u0004\u0003f\n\u001dX1\u0007\t\u0005\u0003{*)\u0004B\u0004\u0005 \u0012\u0013\rA!=\t\u000f\tmH\t1\u0001\u00064U!Q1HC#)\u0011)i!\"\u0010\t\u0013\u0015}R)!AA\u0004\u0015\u0005\u0013AC3wS\u0012,gnY3%qA1!Q\u001dBt\u000b\u0007\u0002B!! \u0006F\u00119AqT#C\u0002\tEH\u0003BC\u0007\u000b\u0013Bqa!\bG\u0001\u0004\t\t\n\u0006\u0003\u0006\u000e\u00155\u0003bBAi\u000f\u0002\u0007\u00111\u001b\u000b\u0005\u000b\u001b)\t\u0006C\u0004\u00044!\u0003\ra!\u000e\u0015\t\u00155QQ\u000b\u0005\b\u0007\u001fJ\u0005\u0019\u0001B\f)\u0011)i!\"\u0017\t\u000f\u0005=%\n1\u0001\u0002\u0012R!QQBC/\u0011\u001d\u0019)g\u0013a\u0001\u0007O\"B!\"\u0004\u0006b!91Q\r'A\u0002\r\u001d\u0004\u0003BA?\u000bK\"qAa<?\u0005\u0004)\t\"A\u0005ue\u0016,')^5mI\":Q-b\u001b\u0006r\u0015U\u0004\u0003BA(\u000b[JA!b\u001c\u00020\tQA-\u001a9sK\u000e\fG/\u001a3\"\u0005\u0015M\u0014AG;tK\u0002\u0002\u0017N\u001c;fe:\fGNL4f]\u0002\u0004\u0013N\\:uK\u0006$\u0017EAC<\u0003\u0019\u0011d&M\u0019/a\t11i\\7qCR\fB!!\u0014\u0006~A\u0019\u0011qK4\u0003\u001d5\u000b7M]8D_6\u0004\u0018\r^!qSN)q-!\u0018\u0006\u0004B!\u0011qKCC\u0013\u0011)9)!\u001b\u0003\u0013\r{W\u000e]1u\u0003BL'!F'bGJ|7i\\7qCRL'\r\\3Ts6\u0014w\u000e\\\n\u0004S\u0006uC\u0003BCH\u000b'\u00032!\"%j\u001b\u00059\u0007b\u0002BiW\u0002\u0007\u0011\u0011S\u000b\u0003\u000b/\u0013B!\"'\u0003<\u001a1!\u0011X5\u0001\u000b/+qAa1\u0006\u001a\u0002\u0012)\rK\u0004m\u000bW*y*\"\u001e\"\u0005\u0015\u0005\u0016!V;tK\u0002\u0002\u0017N\u001c;fe:\fGNL1ui\u0006\u001c\u0007.\\3oiN\u0004\u0007%\u001b8ti\u0016\fG\rI8sA%l\u0007o\u001c:uA\u0001Lg\u000e^3s]\u0006dg\u0006Z3d_J\fGo\u001c:t]}\u0003\u0007EZ8sA%tg-\u001b=!gftG/\u0019=\u0016\t\u0015\u0015V\u0011\u0017\u000b\u0005\u000bO+\u0019\f\u0006\u0003\u0002\u0012\u0016%\u0006\"CCV[\u0006\u0005\t9ACW\u0003))g/\u001b3f]\u000e,G%\u000f\t\u0007\u0005K\u00149/b,\u0011\t\u0005uT\u0011\u0017\u0003\b\u0005_l'\u0019\u0001By\u0011\u001d\u0011Y0\u001ca\u0001\u000b_Cs!\\C6\u000bo+)(\t\u0002\u0006:\u0006QVo]3!A&tG/\u001a:oC2tS\u000f\u001d3bi\u0016\fE\u000f^1dQ6,g\u000e\u001e1!S:\u001cH/Z1eA=\u0014\b%[7q_J$\b\u0005Y5oi\u0016\u0014h.\u00197/I\u0016\u001cwN]1u_J\u001chf\u00181!M>\u0014\b%\u001b8gSb\u00043/\u001f8uCb,B!\"0\u0006HR!\u0011\u0011SC`\u0011%)\tM\\A\u0001\u0002\b)\u0019-A\u0006fm&$WM\\2fIE\u0002\u0004C\u0002Bs\u0005O,)\r\u0005\u0003\u0002~\u0015\u001dGa\u0002Bx]\n\u0007!\u0011\u001f\u0015\b]\u0016-T1ZC;C\t)i-\u0001.vg\u0016\u0004\u0003-\u001b8uKJt\u0017\r\u001c\u0018sK6|g/Z!ui\u0006\u001c\u0007.\\3oi\u0002\u0004\u0013N\\:uK\u0006$\u0007e\u001c:!S6\u0004xN\u001d;!A&tG/\u001a:oC2tC-Z2pe\u0006$xN]:/?\u0002\u0004cm\u001c:!S:4\u0017\u000e\u001f\u0011ts:$\u0018\r_\u0001\u0011g\u0016$H+\u001f9f'&<g.\u0019;ve\u0016$B!!%\u0006T\"9\u0011\u0011[8A\u0002\u0005M\u0007fB8\u0006l\u0015]WQO\u0011\u0003\u000b3\f\u0011+^:fA\u0001Lg\u000e^3s]\u0006dgf]3u\u0013:4w\u000e\u0019\u0011j]N$X-\u00193!_J\u0004\u0013.\u001c9peR\u0004\u0003-\u001b8uKJt\u0017\r\u001c\u0018eK\u000e|'/\u0019;peNts\f\u0019\u0011g_J\u0004\u0013N\u001c4jq\u0002\u001a\u0018P\u001c;bqR!\u0011\u0011SCo\u0011\u001d\u0019\u0019\u0004\u001da\u0001\u0007kAs\u0001]C6\u000bC,)(\t\u0002\u0006d\u0006AVo]3!A&tG/\u001a:oC2t3/\u001a;B]:|G/\u0019;j_:\u001c\b\rI5ogR,\u0017\r\u001a\u0011pe\u0002JW\u000e]8si\u0002\u0002\u0017N\u001c;fe:\fGN\f3fG>\u0014\u0018\r^8sg:z\u0006\r\t4pe\u0002JgNZ5yAMLh\u000e^1y)\u0011\t\t*b:\t\u000f\r=\u0013\u000f1\u0001\u0003\u0018!:\u0011/b\u001b\u0006l\u0016U\u0014EACw\u0003E+8/\u001a\u0011aS:$XM\u001d8bY:\u001aX\r\u001e(b[\u0016\u0004\u0007%\u001b8ti\u0016\fG\rI8sA%l\u0007o\u001c:uA\u0001Lg\u000e^3s]\u0006dg\u0006Z3d_J\fGo\u001c:t]}\u0003\u0007EZ8sA%tg-\u001b=!gftG/\u0019=\u0015\t\u0005EU\u0011\u001f\u0005\b\u0003\u001f\u0013\b\u0019AAIQ\u001d\u0011X1NC{\u000bk\n#!b>\u00025V\u001cX\r\t1j]R,'O\\1m]M,G\u000f\u0015:jm\u0006$XmV5uQ&t\u0007\rI5ogR,\u0017\r\u001a\u0011pe\u0002JW\u000e]8si\u0002\u0002\u0017N\u001c;fe:\fGN\f3fG>\u0014\u0018\r^8sg:z\u0006\r\t4pe\u0002JgNZ5yAMLh\u000e^1y\u0003Ui\u0015m\u0019:p\u0007>l\u0007/\u0019;jE2,7+_7c_2$B!b$\u0006~\"9!\u0011[:A\u0002\u0005E%aE'bGJ|7i\\7qCRL'\r\\3Ue\u0016,7c\u0001;\u0002^Q!aQ\u0001D\u0004!\r)\t\n\u001e\u0005\b\u0003[3\b\u0019AAX+\t1YA\u0005\u0003\u0007\u000e\tmfA\u0002B]i\u00021Y!B\u0004\u0003D\u001a5\u0001E!2)\u000f],Y'b(\u0006vU!aQ\u0003D\u0011)\u001119Bb\t\u0015\t\u0005=f\u0011\u0004\u0005\n\r7A\u0018\u0011!a\u0002\r;\t1\"\u001a<jI\u0016t7-\u001a\u00132cA1!Q\u001dBt\r?\u0001B!! \u0007\"\u00119!q\u001e=C\u0002\tE\bb\u0002B~q\u0002\u0007aq\u0004\u0015\bq\u0016-TqWC;+\u00111ICb\r\u0015\t\u0005=f1\u0006\u0005\n\r[I\u0018\u0011!a\u0002\r_\t1\"\u001a<jI\u0016t7-\u001a\u00132eA1!Q\u001dBt\rc\u0001B!! \u00074\u00119!q^=C\u0002\tE\bfB=\u0006l\u0015-WQO\u0001\ba>\u001cx\fJ3r)\u0011\t\tHb\u000f\t\u000f\u0019u\"\u00101\u0001\u0003F\u0006\u0019\u0001o\\:)\u000fi,YG\"\u0011\u0006v\u0005\u0012a1I\u0001QkN,\u0007\u0005Y5oi\u0016\u0014h.\u00197/g\u0016$\bk\\:aA%t7\u000f^3bI\u0002z'\u000fI5na>\u0014H\u000f\t1j]R,'O\\1m]\u0011,7m\u001c:bi>\u00148OL0aA\u0019|'\u000fI5oM&D\be]=oi\u0006DH\u0003BAX\r\u000fBqa!/|\u0001\u0004\u0011)\rK\u0004|\u000bW2\t%\"\u001e\u0002\u000fQ\u0004Xm\u0018\u0013fcR!\u0011\u0011\u000fD(\u0011\u001d1\t\u0006 a\u0001\u0003'\f\u0011\u0001\u001e\u0015\by\u0016-dQKC;C\t19&A)vg\u0016\u0004\u0003-\u001b8uKJt\u0017\r\u001c\u0018tKR$\u0016\u0010]3aA%t7\u000f^3bI\u0002z'\u000fI5na>\u0014H\u000f\t1j]R,'O\\1m]\u0011,7m\u001c:bi>\u00148OL0aA\u0019|'\u000fI5oM&D\be]=oi\u0006DH\u0003BAX\r7BqA!*~\u0001\u0004\t\u0019\u000eK\u0004~\u000bW2)&\"\u001e\u0015\t\u0005=f\u0011\r\u0005\b\u0005Ks\b\u0019AAjQ\u001dqX1\u000eD3\u000bk\n#Ab\u001a\u0002)V\u001cX\r\t1j]R,'O\\1m]\u0011,g-\u001b8f)f\u0004X\r\u0019\u0011j]N$X-\u00193!_J\u0004\u0013.\u001c9peR\u0004\u0003-\u001b8uKJt\u0017\r\u001c\u0018eK\u000e|'/\u0019;peNts\f\u0019\u0011g_J\u0004\u0013N\u001c4jq\u0002\u001a\u0018P\u001c;bq\u0006Q1/_7c_2|F%Z9\u0015\t\u0005EdQ\u000e\u0005\b\u0003\u001f{\b\u0019AAIQ\u001dyX1\u000eD9\u000bk\n#Ab\u001d\u0002'V\u001cX\r\t1j]R,'O\\1m]M,GoU=nE>d\u0007\rI5ogR,\u0017\r\u001a\u0011pe\u0002JW\u000e]8si\u0002\u0002\u0017N\u001c;fe:\fGN\f3fG>\u0014\u0018\r^8sg:z\u0006\r\t4pe\u0002JgNZ5yAMLh\u000e^1y)\u0011\tyKb\u001e\t\u0011\u0005=\u0015\u0011\u0001a\u0001\u0003#C\u0003\"!\u0001\u0006l\u0019ETQO\u0001\u0014\u001b\u0006\u001c'o\\\"p[B\fG/\u001b2mKR\u0013X-\u001a\u000b\u0005\r\u000b1y\b\u0003\u0005\u0002.\u0006\r\u0001\u0019AAX\u0005I\u0019u.\u001c9bi&\u0014G.\u001a+za\u0016$&/Z3\u0014\t\u0005\u0015\u0011Q\f\u000b\u0005\r\u000f3I\t\u0005\u0003\u0006\u0012\u0006\u0015\u0001\u0002CBs\u0003\u0013\u0001\ra!8\u0015\t\rugQ\u0012\u0005\t\u0003[\u000bY\u00011\u0001\u00020\"B\u00111BC6\r#+)(\t\u0002\u0007\u0014\u0006)Vo]3!A&tG/\u001a:oC2t3/\u001a;Pe&<\u0017N\\1mA\u0002Jgn\u001d;fC\u0012\u0004sN\u001d\u0011j[B|'\u000f\u001e\u0011aS:$XM\u001d8bY:\"WmY8sCR|'o\u001d\u0018`A\u00022wN\u001d\u0011j]\u001aL\u0007\u0010I:z]R\f\u00070\u0001\nD_6\u0004\u0018\r^5cY\u0016$\u0016\u0010]3Ue\u0016,G\u0003\u0002DD\r3C\u0001b!:\u0002\u000e\u0001\u00071Q\u001c\u000b\u0005\u0003c2i\n\u0003\u0005\u0004r\u0006=\u0001\u0019AAIQ!\ty!b\u001b\u0007\"\u0016U\u0014E\u0001DR\u0003\u0019*8/\u001a\u0011aS:$XM\u001d8bY:\u001a\u0017\r\u001d;ve\u00164\u0016M]5bE2,\u0007\rI5ogR,\u0017\r\u001a\u000b\u0005\u0003_39\u000b\u0003\u0005\u0004r\u0006E\u0001\u0019AAIQ!\t\t\"b\u001b\u0007,\u0016U\u0014E\u0001DW\u0003A*8/\u001a\u0011aS:$XM\u001d8bY:\u0012XMZ3sK:\u001cWmQ1qiV\u0014X\r\u001a,be&\f'\r\\3aA%t7\u000f^3bIR!\u00111\u001bDY\u0011!\u0019\t0a\u0005A\u0002\u0005E\u0005\u0006CA\n\u000bW2),\"\u001e\"\u0005\u0019]\u0016aK;tK\u0002\u0002\u0017N\u001c;fe:\fGNL2baR,(/\u001a3WCJL\u0017M\u00197f)f\u0004X\r\u0019\u0011j]N$X-\u00193\u0003\u0007I+h.\u0005\u0003\u0002N\u0019u\u0006\u0003BA,\u0003/\u0011QBU;o\u0007>tG/\u001a=u\u0003BL7\u0003BA\f\u0003;\n1bY;se\u0016tG/\u00168jiV\u0011aq\u0019\t\u0005\u0003/\niBA\bD_6\u0004\u0018\u000e\\1uS>tWK\\5u#\u0011\tiE\"4\u0011\t\u0005]\u0013q\u0004\u0002\u001a\u0007>l\u0007/\u001b7bi&|g.\u00168ji\u000e{g\u000e^3yi\u0006\u0003\u0018n\u0005\u0003\u0002 \u0005u\u0013AB:pkJ\u001cW-\u0006\u0002\u0007XB!a\u0011\u001cDr\u001b\t1YN\u0003\u0003\u0007^\u001a}\u0017\u0001B;uS2TAA\"9\u0002,\u0005A\u0011N\u001c;fe:\fG.\u0003\u0003\u0007f\u001am'AC*pkJ\u001cWMR5mK\"B\u0011\u0011EC6\rS,)(\t\u0002\u0007l\u0006A6ML3oG2|7/\u001b8h)J,W-L:us2,\u0007%\u0011)Jg\u0002\n'/\u001a\u0011o_^\u0004C-\u001a9sK\u000e\fG/\u001a3<A\r|gn];mi\u0002\"\b.\u001a\u0011tG\u0006d\u0017\rZ8dA\u0019|'\u000fI7pe\u0016\u0004\u0013N\u001c4pe6\fG/[8o\u0003\u0011\u0011w\u000eZ=)\u0011\u0005\rR1\u000eDu\u000bkB\u0003\"a\b\u0006l\u0019%XQ\u000f\u0015\t\u0003;)YG\";\u0006v!B\u0011\u0011DC6\rS,)(A\u0003v]&$8/\u0006\u0002\u0007|B1!q\nD\u007f\r\u000fLAAb@\u0003Z\tA\u0011\n^3sCR|'\u000f\u000b\u0005\u0002\u001c\u0015-d\u0011^C;Q!\t9\"b\u001b\u0007j\u0016U\u0004\u0006CA\u000b\u000bW2I/\"\u001e")
public abstract class Universe
extends scala.reflect.api.Universe {
    public abstract TreeGen treeBuild();

    public interface CompilationUnitContextApi {
        public SourceFile source();

        public Trees.TreeApi body();
    }

    public interface MacroCompatApi
    extends Internals.CompatApi {
        public static /* synthetic */ MacroCompatibleSymbol MacroCompatibleSymbol$(MacroCompatApi $this, Symbols.SymbolApi symbol) {
            return $this.MacroCompatibleSymbol(symbol);
        }

        default public MacroCompatibleSymbol MacroCompatibleSymbol(Symbols.SymbolApi symbol) {
            return new MacroCompatibleSymbol(this, symbol);
        }

        public static /* synthetic */ MacroCompatibleTree MacroCompatibleTree$(MacroCompatApi $this, Trees.TreeApi tree) {
            return $this.MacroCompatibleTree(tree);
        }

        default public MacroCompatibleTree MacroCompatibleTree(Trees.TreeApi tree) {
            return new MacroCompatibleTree(this, tree);
        }

        public static /* synthetic */ CompatibleTypeTree CompatibleTypeTree$(MacroCompatApi $this, Trees.TypeTreeApi tt) {
            return $this.CompatibleTypeTree(tt);
        }

        default public CompatibleTypeTree CompatibleTypeTree(Trees.TypeTreeApi tt) {
            return new CompatibleTypeTree(this, tt);
        }

        public static /* synthetic */ void captureVariable$(MacroCompatApi $this, Symbols.SymbolApi vble) {
            $this.captureVariable(vble);
        }

        default public void captureVariable(Symbols.SymbolApi vble) {
            ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).captureVariable(vble);
        }

        public static /* synthetic */ Trees.TreeApi referenceCapturedVariable$(MacroCompatApi $this, Symbols.SymbolApi vble) {
            return $this.referenceCapturedVariable(vble);
        }

        default public Trees.TreeApi referenceCapturedVariable(Symbols.SymbolApi vble) {
            return ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).referenceCapturedVariable(vble);
        }

        public static /* synthetic */ Types.TypeApi capturedVariableType$(MacroCompatApi $this, Symbols.SymbolApi vble) {
            return $this.capturedVariableType(vble);
        }

        default public Types.TypeApi capturedVariableType(Symbols.SymbolApi vble) {
            return ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).capturedVariableType(vble);
        }

        public /* synthetic */ Universe scala$reflect$macros$Universe$MacroCompatApi$$$outer();

        public static void $init$(MacroCompatApi $this) {
        }

        public class CompatibleTypeTree {
            private final Trees.TypeTreeApi tt;
            public final /* synthetic */ MacroCompatApi $outer;

            public Trees.TypeTreeApi setOriginal(Trees.TreeApi tree) {
                return ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$CompatibleTypeTree$$$outer().scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).setOriginal(this.tt, tree);
            }

            public /* synthetic */ MacroCompatApi scala$reflect$macros$Universe$MacroCompatApi$CompatibleTypeTree$$$outer() {
                return this.$outer;
            }

            public CompatibleTypeTree(MacroCompatApi $outer, Trees.TypeTreeApi tt) {
                this.tt = tt;
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }
        }

        public class MacroCompatibleSymbol {
            private final Symbols.SymbolApi symbol;
            public final /* synthetic */ MacroCompatApi $outer;

            public Attachments attachments() {
                return ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$MacroCompatibleSymbol$$$outer().scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).attachments(this.symbol);
            }

            public <T> Symbols.SymbolApi updateAttachment(T attachment, ClassTag<T> evidence$9) {
                return ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$MacroCompatibleSymbol$$$outer().scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).updateAttachment(this.symbol, attachment, evidence$9);
            }

            public <T> Symbols.SymbolApi removeAttachment(ClassTag<T> evidence$10) {
                return ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$MacroCompatibleSymbol$$$outer().scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).removeAttachment(this.symbol, evidence$10);
            }

            public Symbols.SymbolApi setTypeSignature(Types.TypeApi tpe) {
                return ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$MacroCompatibleSymbol$$$outer().scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).setInfo(this.symbol, tpe);
            }

            public Symbols.SymbolApi setAnnotations(Seq<Annotations.AnnotationApi> annots) {
                return ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$MacroCompatibleSymbol$$$outer().scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).setAnnotations(this.symbol, annots);
            }

            public Symbols.SymbolApi setName(Names.NameApi name) {
                return ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$MacroCompatibleSymbol$$$outer().scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).setName(this.symbol, name);
            }

            public Symbols.SymbolApi setPrivateWithin(Symbols.SymbolApi sym) {
                return ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$MacroCompatibleSymbol$$$outer().scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).setPrivateWithin(this.symbol, sym);
            }

            public /* synthetic */ MacroCompatApi scala$reflect$macros$Universe$MacroCompatApi$MacroCompatibleSymbol$$$outer() {
                return this.$outer;
            }

            public MacroCompatibleSymbol(MacroCompatApi $outer, Symbols.SymbolApi symbol) {
                this.symbol = symbol;
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }
        }

        public class MacroCompatibleTree {
            private final Trees.TreeApi tree;
            public final /* synthetic */ MacroCompatApi $outer;

            public Attachments attachments() {
                return ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$MacroCompatibleTree$$$outer().scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).attachments(this.tree);
            }

            public <T> Trees.TreeApi updateAttachment(T attachment, ClassTag<T> evidence$11) {
                return ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$MacroCompatibleTree$$$outer().scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).updateAttachment(this.tree, attachment, evidence$11);
            }

            public <T> Trees.TreeApi removeAttachment(ClassTag<T> evidence$12) {
                return ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$MacroCompatibleTree$$$outer().scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).removeAttachment(this.tree, evidence$12);
            }

            public void pos_$eq(Position pos) {
                ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$MacroCompatibleTree$$$outer().scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).setPos(this.tree, pos);
            }

            public Trees.TreeApi setPos(Position newpos) {
                return ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$MacroCompatibleTree$$$outer().scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).setPos(this.tree, newpos);
            }

            public void tpe_$eq(Types.TypeApi t) {
                ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$MacroCompatibleTree$$$outer().scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).setType(this.tree, t);
            }

            public Trees.TreeApi setType(Types.TypeApi tp) {
                return ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$MacroCompatibleTree$$$outer().scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).setType(this.tree, tp);
            }

            public Trees.TreeApi defineType(Types.TypeApi tp) {
                return ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$MacroCompatibleTree$$$outer().scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).defineType(this.tree, tp);
            }

            public void symbol_$eq(Symbols.SymbolApi sym) {
                ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$MacroCompatibleTree$$$outer().scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).setSymbol(this.tree, sym);
            }

            public Trees.TreeApi setSymbol(Symbols.SymbolApi sym) {
                return ((MacroInternalApi)this.scala$reflect$macros$Universe$MacroCompatApi$MacroCompatibleTree$$$outer().scala$reflect$macros$Universe$MacroCompatApi$$$outer().internal()).setSymbol(this.tree, sym);
            }

            public /* synthetic */ MacroCompatApi scala$reflect$macros$Universe$MacroCompatApi$MacroCompatibleTree$$$outer() {
                return this.$outer;
            }

            public MacroCompatibleTree(MacroCompatApi $outer, Trees.TreeApi tree) {
                this.tree = tree;
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }
        }
    }

    public interface MacroInternalApi
    extends Internals.InternalApi {
        public Scopes.ScopeApi enter(Scopes.ScopeApi var1, Symbols.SymbolApi var2);

        public Scopes.ScopeApi unlink(Scopes.ScopeApi var1, Symbols.SymbolApi var2);

        public Trees.TreeApi changeOwner(Trees.TreeApi var1, Symbols.SymbolApi var2, Symbols.SymbolApi var3);

        public TreeGen gen();

        public Attachments attachments(Symbols.SymbolApi var1);

        public <T> Symbols.SymbolApi updateAttachment(Symbols.SymbolApi var1, T var2, ClassTag<T> var3);

        public <T> Symbols.SymbolApi removeAttachment(Symbols.SymbolApi var1, ClassTag<T> var2);

        public Symbols.SymbolApi setOwner(Symbols.SymbolApi var1, Symbols.SymbolApi var2);

        public Symbols.SymbolApi setInfo(Symbols.SymbolApi var1, Types.TypeApi var2);

        public Symbols.SymbolApi setAnnotations(Symbols.SymbolApi var1, Seq<Annotations.AnnotationApi> var2);

        public Symbols.SymbolApi setName(Symbols.SymbolApi var1, Names.NameApi var2);

        public Symbols.SymbolApi setPrivateWithin(Symbols.SymbolApi var1, Symbols.SymbolApi var2);

        public Symbols.SymbolApi setFlag(Symbols.SymbolApi var1, Object var2);

        public Symbols.SymbolApi resetFlag(Symbols.SymbolApi var1, Object var2);

        public Attachments attachments(Trees.TreeApi var1);

        public <T> Trees.TreeApi updateAttachment(Trees.TreeApi var1, T var2, ClassTag<T> var3);

        public <T> Trees.TreeApi removeAttachment(Trees.TreeApi var1, ClassTag<T> var2);

        public Trees.TreeApi setPos(Trees.TreeApi var1, Position var2);

        public Trees.TreeApi setType(Trees.TreeApi var1, Types.TypeApi var2);

        public Trees.TreeApi defineType(Trees.TreeApi var1, Types.TypeApi var2);

        public Trees.TreeApi setSymbol(Trees.TreeApi var1, Symbols.SymbolApi var2);

        public Trees.TypeTreeApi setOriginal(Trees.TypeTreeApi var1, Trees.TreeApi var2);

        public void captureVariable(Symbols.SymbolApi var1);

        public Trees.TreeApi referenceCapturedVariable(Symbols.SymbolApi var1);

        public Types.TypeApi capturedVariableType(Symbols.SymbolApi var1);

        public Option<List<Trees.TreeApi>> subpatterns(Trees.TreeApi var1);

        public /* synthetic */ Universe scala$reflect$macros$Universe$MacroInternalApi$$$outer();

        public static void $init$(MacroInternalApi $this) {
        }

        public interface MacroDecoratorApi
        extends Internals.InternalApi.DecoratorApi {
            public <T extends Scopes.ScopeApi> MacroScopeDecoratorApi scopeDecorator(T var1);

            public <T extends Trees.TypeTreeApi> MacroTypeTreeDecoratorApi typeTreeDecorator(T var1);

            public /* synthetic */ MacroInternalApi scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer();

            public static void $init$(MacroDecoratorApi $this) {
            }

            public class MacroScopeDecoratorApi<T extends Scopes.ScopeApi> {
                private final T scope;
                public final /* synthetic */ MacroDecoratorApi $outer;

                public T scope() {
                    return this.scope;
                }

                public T enter(Symbols.SymbolApi sym) {
                    return (T)this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroScopeDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().enter((Scopes.ScopeApi)this.scope(), sym);
                }

                public T unlink(Symbols.SymbolApi sym) {
                    return (T)this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroScopeDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().unlink((Scopes.ScopeApi)this.scope(), sym);
                }

                public /* synthetic */ MacroDecoratorApi scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroScopeDecoratorApi$$$outer() {
                    return this.$outer;
                }

                public MacroScopeDecoratorApi(T scope) {
                    this.scope = scope;
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                }
            }

            public class MacroSymbolDecoratorApi<T extends Symbols.SymbolApi>
            extends Internals.InternalApi.DecoratorApi.SymbolDecoratorApi<T> {
                @Override
                public T symbol() {
                    return super.symbol();
                }

                public Attachments attachments() {
                    return this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroSymbolDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().attachments((Symbols.SymbolApi)this.symbol());
                }

                public <A> T updateAttachment(A attachment, ClassTag<A> evidence$7) {
                    return (T)this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroSymbolDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().updateAttachment((Symbols.SymbolApi)this.symbol(), attachment, evidence$7);
                }

                public <A> T removeAttachment(ClassTag<A> evidence$8) {
                    return (T)this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroSymbolDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().removeAttachment((Symbols.SymbolApi)this.symbol(), evidence$8);
                }

                public T setOwner(Symbols.SymbolApi newowner) {
                    return (T)this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroSymbolDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().setOwner((Symbols.SymbolApi)this.symbol(), newowner);
                }

                public T setInfo(Types.TypeApi tpe) {
                    return (T)this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroSymbolDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().setInfo((Symbols.SymbolApi)this.symbol(), tpe);
                }

                public T setAnnotations(Seq<Annotations.AnnotationApi> annots) {
                    return (T)this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroSymbolDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().setAnnotations((Symbols.SymbolApi)this.symbol(), annots);
                }

                public T setName(Names.NameApi name) {
                    return (T)this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroSymbolDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().setName((Symbols.SymbolApi)this.symbol(), name);
                }

                public T setPrivateWithin(Symbols.SymbolApi sym) {
                    return (T)this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroSymbolDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().setPrivateWithin((Symbols.SymbolApi)this.symbol(), sym);
                }

                public T setFlag(Object flags) {
                    return (T)this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroSymbolDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().setFlag((Symbols.SymbolApi)this.symbol(), flags);
                }

                public T resetFlag(Object flags) {
                    return (T)this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroSymbolDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().resetFlag((Symbols.SymbolApi)this.symbol(), flags);
                }

                public /* synthetic */ MacroDecoratorApi scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroSymbolDecoratorApi$$$outer() {
                    return (MacroDecoratorApi)this.$outer;
                }

                public MacroSymbolDecoratorApi(T symbol) {
                    super((Internals.InternalApi.DecoratorApi)$outer, symbol);
                }
            }

            public class MacroTreeDecoratorApi<T extends Trees.TreeApi>
            extends Internals.InternalApi.DecoratorApi.TreeDecoratorApi<T> {
                @Override
                public T tree() {
                    return super.tree();
                }

                public T changeOwner(Symbols.SymbolApi prev, Symbols.SymbolApi next) {
                    return (T)this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroTreeDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().changeOwner((Trees.TreeApi)this.tree(), prev, next);
                }

                public Attachments attachments() {
                    return this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroTreeDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().attachments((Trees.TreeApi)this.tree());
                }

                public <A> T updateAttachment(A attachment, ClassTag<A> evidence$5) {
                    return (T)this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroTreeDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().updateAttachment((Trees.TreeApi)this.tree(), attachment, evidence$5);
                }

                public <A> T removeAttachment(ClassTag<A> evidence$6) {
                    return (T)this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroTreeDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().removeAttachment((Trees.TreeApi)this.tree(), evidence$6);
                }

                public T setPos(Position newpos) {
                    return (T)this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroTreeDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().setPos((Trees.TreeApi)this.tree(), newpos);
                }

                public T setType(Types.TypeApi tp) {
                    return (T)this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroTreeDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().setType((Trees.TreeApi)this.tree(), tp);
                }

                public T defineType(Types.TypeApi tp) {
                    return (T)this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroTreeDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().defineType((Trees.TreeApi)this.tree(), tp);
                }

                public T setSymbol(Symbols.SymbolApi sym) {
                    return (T)this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroTreeDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().setSymbol((Trees.TreeApi)this.tree(), sym);
                }

                public /* synthetic */ MacroDecoratorApi scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroTreeDecoratorApi$$$outer() {
                    return (MacroDecoratorApi)this.$outer;
                }

                public MacroTreeDecoratorApi(T tree) {
                    super((Internals.InternalApi.DecoratorApi)$outer, tree);
                }
            }

            public class MacroTypeTreeDecoratorApi<T extends Trees.TypeTreeApi> {
                private final T tt;
                public final /* synthetic */ MacroDecoratorApi $outer;

                public T tt() {
                    return this.tt;
                }

                public Trees.TypeTreeApi setOriginal(Trees.TreeApi tree) {
                    return this.scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroTypeTreeDecoratorApi$$$outer().scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$$$outer().setOriginal((Trees.TypeTreeApi)this.tt(), tree);
                }

                public /* synthetic */ MacroDecoratorApi scala$reflect$macros$Universe$MacroInternalApi$MacroDecoratorApi$MacroTypeTreeDecoratorApi$$$outer() {
                    return this.$outer;
                }

                public MacroTypeTreeDecoratorApi(T tt) {
                    this.tt = tt;
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                }
            }
        }
    }

    public interface RunContextApi {
        public CompilationUnitContextApi currentUnit();

        public Iterator<CompilationUnitContextApi> units();
    }

    public interface TreeGen {
        public Trees.TreeApi mkAttributedQualifier(Types.TypeApi var1);

        public Trees.TreeApi mkAttributedQualifier(Types.TypeApi var1, Symbols.SymbolApi var2);

        public Trees.RefTreeApi mkAttributedRef(Types.TypeApi var1, Symbols.SymbolApi var2);

        public Trees.RefTreeApi mkAttributedRef(Symbols.SymbolApi var1);

        public Trees.TreeApi stabilize(Trees.TreeApi var1);

        public Trees.TreeApi mkAttributedStableRef(Types.TypeApi var1, Symbols.SymbolApi var2);

        public Trees.TreeApi mkAttributedStableRef(Symbols.SymbolApi var1);

        public Trees.RefTreeApi mkUnattributedRef(Symbols.SymbolApi var1);

        public Trees.RefTreeApi mkUnattributedRef(Names.NameApi var1);

        public Trees.ThisApi mkAttributedThis(Symbols.SymbolApi var1);

        public Trees.RefTreeApi mkAttributedIdent(Symbols.SymbolApi var1);

        public Trees.RefTreeApi mkAttributedSelect(Trees.TreeApi var1, Symbols.SymbolApi var2);

        public Trees.TreeApi mkMethodCall(Symbols.SymbolApi var1, Names.NameApi var2, List<Types.TypeApi> var3, List<Trees.TreeApi> var4);

        public Trees.TreeApi mkMethodCall(Symbols.SymbolApi var1, List<Types.TypeApi> var2, List<Trees.TreeApi> var3);

        public Trees.TreeApi mkMethodCall(Symbols.SymbolApi var1, List<Trees.TreeApi> var2);

        public Trees.TreeApi mkMethodCall(Trees.TreeApi var1, List<Trees.TreeApi> var2);

        public Trees.TreeApi mkMethodCall(Symbols.SymbolApi var1, Names.NameApi var2, List<Trees.TreeApi> var3);

        public Trees.TreeApi mkMethodCall(Trees.TreeApi var1, Symbols.SymbolApi var2, List<Types.TypeApi> var3, List<Trees.TreeApi> var4);

        public Trees.TreeApi mkMethodCall(Trees.TreeApi var1, List<Types.TypeApi> var2, List<Trees.TreeApi> var3);

        public Trees.TreeApi mkNullaryCall(Symbols.SymbolApi var1, List<Types.TypeApi> var2);

        public Trees.TreeApi mkRuntimeUniverseRef();

        public Trees.TreeApi mkZero(Types.TypeApi var1);

        public Trees.TreeApi mkCast(Trees.TreeApi var1, Types.TypeApi var2);
    }
}

