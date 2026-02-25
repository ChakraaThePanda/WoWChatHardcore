/*
 * Decompiled with CFR 0.152.
 */
package scala.sys.process;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import scala.Function0;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Stream;
import scala.concurrent.SyncVar;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.java8.JFunction0$mcI$sp;
import scala.runtime.java8.JFunction0$mcV$sp;
import scala.sys.package$;
import scala.sys.process.BasicIO;
import scala.sys.process.BasicIO$;
import scala.sys.process.BasicIO$Streamed$;
import scala.sys.process.BasicIO$Uncloseable$;
import scala.sys.process.Process;
import scala.sys.process.Process$;
import scala.sys.process.ProcessBuilder;
import scala.sys.process.ProcessBuilder$;
import scala.sys.process.ProcessIO;
import scala.sys.process.ProcessImpl;
import scala.sys.process.ProcessLogger;

@ScalaSignature(bytes="\u0006\u0001\r\u0005gaC={!\u0003\r\tA_A\u0001\u0007{Cq!a\u0003\u0001\t\u0003\tyAB\u0004\u0002\u0018\u0001\u0001!0!\u0007\t\u0015\tU!A!A!\u0002\u0013\t\u0019\u0003C\u0004\u0002<\t!\tAa\u0006\t\u000f\u0005}#\u0001\"\u0002\u0003\u001e\u00199!\u0011\u0005\u0001\u0001u\n\r\u0002B\u0003B\u0013\r\t\u0015\r\u0011\"\u0011\u0002\n\"Q!q\u0005\u0004\u0003\u0002\u0003\u0006I!a#\t\u0015\t%bA!A%\u0002\u0013\u0011Y\u0003C\u0004\u0002<\u0019!\tA!\r\t\u000f\u0005}c\u0001\"\u0011\u0003:!9!q\u0002\u0004\u0005B\tEaa\u0002B\u001f\u0001\u0001Q(q\b\u0005\u000b\u0005sj!\u0011!Q\u0001\n\tm\u0004bBA\u001e\u001b\u0011\u0005!\u0011\u0011\u0004\b\u0005\u000f\u0003\u0001A\u001fBE\u0011)\u0011Y\t\u0005B\u0001B\u0003%!Q\u0012\u0005\b\u0003w\u0001B\u0011\u0001BJ\r\u001d\u0011I\n\u0001\u0001{\u00057C!Ba#\u0014\u0005\u0003\u0005\u000b\u0011\u0002BG\u0011)\u0011\tl\u0005B\u0001B\u0003%\u0011q\u000e\u0005\b\u0003w\u0019B\u0011\u0001BZ\r\u001d\u0011y\n\u0001\u0001{\u0005CC!Ba\u0018\u0018\u0005\u0003%\u000b\u0011\u0002BR\u0011-\u0011\th\u0006B\u0001B\u0003%\u00111\u0012\u0012\t\u000f\u0005mr\u0003\"\u0001\u0003,\"9!1C\f\u0005B\tEaa\u0002B\"\u0001\u0001Q(Q\t\u0005\u000b\u0005?b\"\u0011!S\u0001\n\t\u0005\u0004b\u0003B99\t\u0005\t\u0015!\u0003\u0002\f\nBq!a\u000f\u001d\t\u0003\u0011\u0019\bC\u0004\u0003\u0014q!\tE!\u0005\u0007\u0011\t%\u0003!!\u0001{\u0005\u0017B!B!\n\"\u0005\u000b\u0007I\u0011IAE\u0011)\u00119#\tB\u0001B\u0003%\u00111\u0012\u0005\u000b\u0005\u001b\n#\u0011!Q\u0001\n\t=\u0003bBA\u001eC\u0011\u0005!Q\u000b\u0005\b\u0003?\nC\u0011\tB.\r\u001d\u0011Y\f\u0001\u0001{\u0005{C!Ba0(\u0005\u0003\u0005\u000b\u0011\u0002Ba\u0011\u001d\tYd\nC\u0001\u0005\u000fDq!a\u0018(\t\u0003\u0012i\rC\u0004\u0003&\u001d\"\tE!5\t\u000f\t=q\u0005\"\u0011\u0003\u0012\u0019A\u0011q\u0004\u0001\u0002\u0002y\f\t\u0003C\u0004\u0002<5\"\t!!\u0010\t\u000f\u0005}R\u0006\"\u0005\u0002B!9\u00111I\u0017\u0005\u0012\u0005\u0005\u0003bBA#[\u0011\u0005\u0011q\t\u0005\b\u0003\u001bjC\u0011AA(\u0011\u001d\t\u0019&\fC\u0001\u0003+Bq!!\u0017.\t\u0003\tY\u0006C\u0004\u0002`5\"\t!!\u0019\t\u000f\u0005}S\u0006\"\u0001\u0002j!9\u0011qL\u0017\u0005\u0002\u0005U\u0004bBA0[\u0011\u0005\u0011\u0011\u0011\u0005\b\u0003\u000fkC\u0011AAE\u0011\u001d\t9)\fC\u0001\u0003CCq!!*.\t\u0003\tI\tC\u0004\u0002&6\"\t!a*\t\u000f\u0005-V\u0006\"\u0001\u0002.\"9\u00111V\u0017\u0005\u0002\u0005u\u0006bBAa[\u0011\u0005\u0011Q\u0016\u0005\b\u0003\u0003lC\u0011AAb\u0011\u001d\t9-\fC\u0001\u0003\u0013Dq!a2.\t\u0003\t\t\u000eC\u0004\u0002H6\"\t!!8\t\u000f\u0005\u0005X\u0006\"\u0001\u0002J\"9\u0011\u0011]\u0017\u0005\u0002\u0005\r\bbBAt[\u0011\u0005\u0011\u0011\u001e\u0005\t\u0003Wl\u0003\u0015\"\u0003\u0002n\"A\u00111V\u0017!\n\u0013\tY\u0010\u0003\u0005\u0003\b5\u0002K\u0011\u0002B\u0005\u0011\u001d\u0011y!\fC\u0001\u0005#AqAa\u0005.\t\u0003\u0011\tBB\u0004\u0003b\u0002\u0001!Pa9\t\u0015\teDJ!A!\u0002\u0013\u0011Y\bC\u0004\u0002<1#\tAa;\t\u000f\u0005}B\n\"\u0005\u0003r\u001a9!1\u001f\u0001\u0001u\nU\bB\u0003B\u007f!\n\u0005\t\u0015!\u0003\u0003\u000e\"9\u00111\b)\u0005\u0002\t}\bbBA !\u0012E1Q\u0001\u0005\b\u0003\u0007\u0002F\u0011CB\u0004\u0011\u001d\u0019I\u0001\u0015C\u0001\u0007\u0017Aqa!\u0003Q\t\u0003\u0019\t\u0002C\u0004\u0004\nA#\taa\u0006\t\u000f\r%\u0001\u000b\"\u0001\u0004\u001e\u0019A11\u0005\u0001\u0002\u0002i\u001c)\u0003C\u0004\u0002<e#\taa\n\t\u0011\r-\u0012\f)C\t\u0007[Aq!a\u0018Z\t\u000b\u0019\u0019\u0004\u0003\u0005\u00048e\u0003k\u0011CB\u001d\r!\u0019i\u0005AA\u0001u\u000e=\u0003BCB\u0019=\n\u0005\t\u0015!\u0003\u0002$!Q1\u0011\u00050\u0003\u0002\u0003\u0006I!a\t\t\u0015\rEcL!A!\u0002\u0013\tY\tC\u0004\u0002<y#\taa\u0015\t\u000f\t\u0015b\f\"\u0011\u0003R\u001a91Q\f\u0001\u0001u\u000e}\u0003BCB1I\n\u0005\t\u0015!\u0003\u0002$!Q11\r3\u0003\u0002\u0003\u0006I!a\t\t\u0015\r\u0015DM!A!\u0002\u0013\ty\u0007C\u0004\u0002<\u0011$\taa\u001a\t\u000f\r]B\r\"\u0011\u0004r\u0019911\u0010\u0001\u0001u\u000eu\u0004BCB1U\n\u0005\t\u0015!\u0003\u0002$!Q11\r6\u0003\u0002\u0003\u0006I!a\t\t\u000f\u0005m\"\u000e\"\u0001\u0004\u0000!91q\u00076\u0005B\r\u001deaBBI\u0001\u0001Q81\u0013\u0005\u000b\u0007Cz'\u0011!Q\u0001\n\u0005\r\u0002BCB2_\n\u0005\t\u0015!\u0003\u0002$!9\u00111H8\u0005\u0002\rU\u0005bBB\u001c_\u0012\u00053Q\u0014\u0004\b\u0007O\u0003\u0001A_BU\u0011)\u0019\t\u0007\u001eB\u0001B\u0003%\u00111\u0005\u0005\u000b\u0007G\"(\u0011!Q\u0001\n\u0005\r\u0002bBA\u001ei\u0012\u000511\u0016\u0005\b\u0007o!H\u0011IBZ\u0005I\u0001&o\\2fgN\u0014U/\u001b7eKJLU\u000e\u001d7\u000b\u0005md\u0018a\u00029s_\u000e,7o\u001d\u0006\u0003{z\f1a]=t\u0015\u0005y\u0018!B:dC2\f7c\u0001\u0001\u0002\u0004A!\u0011QAA\u0004\u001b\u0005q\u0018bAA\u0005}\n1\u0011I\\=SK\u001a\fa\u0001J5oSR$3\u0001\u0001\u000b\u0003\u0003#\u0001B!!\u0002\u0002\u0014%\u0019\u0011Q\u0003@\u0003\tUs\u0017\u000e\u001e\u0002\u000e\t\u0006,Wn\u001c8Ck&dG-\u001a:\u0014\u0007\t\tY\u0002E\u0002\u0002\u001e5j\u0011\u0001\u0001\u0002\u0010\u0003\n\u001cHO]1di\n+\u0018\u000e\u001c3feNIQ&a\u0001\u0002$\u0005-\u0012Q\u0007\t\u0005\u0003K\t9#D\u0001{\u0013\r\tIC\u001f\u0002\u000f!J|7-Z:t\u0005VLG\u000eZ3s!\u0011\ti\"!\f\n\t\u0005=\u0012\u0011\u0007\u0002\u0005'&t7NC\u0002\u00024i\fa\u0002\u0015:pG\u0016\u001c8OQ;jY\u0012,'\u000f\u0005\u0003\u0002\u001e\u0005]\u0012\u0002BA\u001d\u0003c\u0011aaU8ve\u000e,\u0017A\u0002\u001fj]&$h\b\u0006\u0002\u0002\u001c\u0005AAo\\*pkJ\u001cW-\u0006\u0002\u0002\u001c\u00051Ao\\*j].\f\u0011\u0002\n5bg\"$#-\u0019:\u0015\t\u0005\r\u0012\u0011\n\u0005\b\u0003\u0017\n\u0004\u0019AA\u0012\u0003\u0015yG\u000f[3s\u00035!\u0003.Y:iI\t\f'\u000f\n2beR!\u00111EA)\u0011\u001d\tYE\ra\u0001\u0003G\tQ\u0002\n5bg\"$\u0013-\u001c9%C6\u0004H\u0003BA\u0012\u0003/Bq!a\u00134\u0001\u0004\t\u0019#A\b%Q\u0006\u001c\b\u000e\n5bg\"$\u0003.Y:i)\u0011\t\u0019#!\u0018\t\u000f\u0005-C\u00071\u0001\u0002$\u0005\u0019!/\u001e8\u0015\u0005\u0005\r\u0004\u0003BA\u0013\u0003KJ1!a\u001a{\u0005\u001d\u0001&o\\2fgN$B!a\u0019\u0002l!9\u0011Q\u000e\u001cA\u0002\u0005=\u0014\u0001D2p]:,7\r^%oaV$\b\u0003BA\u0003\u0003cJ1!a\u001d\u007f\u0005\u001d\u0011un\u001c7fC:$B!a\u0019\u0002x!9\u0011\u0011P\u001cA\u0002\u0005m\u0014a\u00017pOB!\u0011QEA?\u0013\r\tyH\u001f\u0002\u000e!J|7-Z:t\u0019><w-\u001a:\u0015\r\u0005\r\u00141QAC\u0011\u001d\tI\b\u000fa\u0001\u0003wBq!!\u001c9\u0001\u0004\ty'\u0001\u0006%E\u0006tw\r\n2b]\u001e,\"!a#\u0011\t\u00055\u00151\u0014\b\u0005\u0003\u001f\u000b9\nE\u0002\u0002\u0012zl!!a%\u000b\t\u0005U\u0015QB\u0001\u0007yI|w\u000e\u001e \n\u0007\u0005ee0\u0001\u0004Qe\u0016$WMZ\u0005\u0005\u0003;\u000byJ\u0001\u0004TiJLgn\u001a\u0006\u0004\u00033sH\u0003BAF\u0003GCq!!\u001f;\u0001\u0004\tY(A\b%E\u0006tw\r\n2b]\u001e$C.Z:t)\u0011\tY)!+\t\u000f\u0005eD\b1\u0001\u0002|\u0005QA.\u001b8f'R\u0014X-Y7\u0016\u0005\u0005=\u0006CBAY\u0003o\u000bYI\u0004\u0003\u0002\u0006\u0005M\u0016bAA[}\u00069\u0001/Y2lC\u001e,\u0017\u0002BA]\u0003w\u0013aa\u0015;sK\u0006l'bAA[}R!\u0011qVA`\u0011\u001d\tIH\u0010a\u0001\u0003w\n\u0001\u0003\\5oKN#(/Z1n?\u0012\u0012\u0017M\\4\u0015\t\u0005=\u0016Q\u0019\u0005\b\u0003s\u0002\u0005\u0019AA>\u0003\u0015!#-\u00198h+\t\tY\r\u0005\u0003\u0002\u0006\u00055\u0017bAAh}\n\u0019\u0011J\u001c;\u0015\t\u0005-\u00171\u001b\u0005\b\u0003+\u0014\u0005\u0019AAl\u0003\tIw\u000e\u0005\u0003\u0002&\u0005e\u0017bAAnu\nI\u0001K]8dKN\u001c\u0018j\u0014\u000b\u0005\u0003\u0017\fy\u000eC\u0004\u0002z\r\u0003\r!a\u001f\u0002\u0015\u0011\u0012\u0017M\\4%Y\u0016\u001c8\u000f\u0006\u0003\u0002L\u0006\u0015\bbBA=\u000b\u0002\u0007\u00111P\u0001\u000bI\u0006,Wn\u001c8ju\u0016$GCAA\u0012\u0003\u0015\u0019H.\u001e:q)\u0019\tY)a<\u0002x\"9\u0011\u0011P$A\u0002\u0005E\bCBA\u0003\u0003g\fY(C\u0002\u0002vz\u0014aa\u00149uS>t\u0007bBA}\u000f\u0002\u0007\u0011qN\u0001\u0007o&$\b.\u00138\u0015\u0011\u0005=\u0016Q B\u0001\u0005\u000bAq!a@I\u0001\u0004\ty'A\u0005xSRD\u0017J\u001c9vi\"9!1\u0001%A\u0002\u0005=\u0014\u0001\u00058p]j+'o\\#yG\u0016\u0004H/[8o\u0011\u001d\tI\b\u0013a\u0001\u0003c\f1B];o\u0005V4g-\u001a:fIR1\u00111\u001aB\u0006\u0005\u001bAq!!\u001fJ\u0001\u0004\tY\bC\u0004\u0002n%\u0003\r!a\u001c\u0002\u0013\r\fg\u000eU5qKR{WCAA8\u00031A\u0017m]#ySR4\u0016\r\\;f\u0003))h\u000eZ3sYfLgn\u001a\u000b\u0005\u00053\u0011Y\u0002E\u0002\u0002\u001e\tAqA!\u0006\u0005\u0001\u0004\t\u0019\u0003\u0006\u0003\u0002d\t}\u0001bBAk\u000b\u0001\u0007\u0011q\u001b\u0002\u0006\tVlW._\n\u0004\r\u0005m\u0011\u0001\u0003;p'R\u0014\u0018N\\4\u0002\u0013Q|7\u000b\u001e:j]\u001e\u0004\u0013!C3ySR4\u0016\r\\;f!\u0019\t)A!\f\u0002L&\u0019!q\u0006@\u0003\u0011q\u0012\u0017P\\1nKz\"bAa\r\u00036\t]\u0002cAA\u000f\r!9!Q\u0005\u0006A\u0002\u0005-\u0005\u0002\u0003B\u0015\u0015\u0011\u0005\rAa\u000b\u0015\t\u0005\r$1\b\u0005\b\u0003+\\\u0001\u0019AAl\u0005!)&\u000bT%oaV$8cA\u0007\u0003BA\u0019\u0011Q\u0004\u000f\u0003\u001d%\u001bFO]3b[\n+\u0018\u000e\u001c3feN\u0019ADa\u0012\u0011\u0007\u0005u\u0011EA\u0007UQJ,\u0017\r\u001a\"vS2$WM]\n\u0004C\u0005m\u0011a\u0002:v]&k\u0007\u000f\u001c\t\t\u0003\u000b\u0011\t&a6\u0002\u0012%\u0019!1\u000b@\u0003\u0013\u0019+hn\u0019;j_:\fDC\u0002B$\u0005/\u0012I\u0006C\u0004\u0003&\u0015\u0002\r!a#\t\u000f\t5S\u00051\u0001\u0003PQ!\u00111\rB/\u0011\u001d\t)N\na\u0001\u0003/\faa\u001d;sK\u0006l\u0007CBA\u0003\u0005[\u0011\u0019\u0007\u0005\u0003\u0003f\t-d\u0002BA\u0013\u0005OJ1A!\u001b{\u0003=\u0001(o\\2fgNLe\u000e^3s]\u0006d\u0017\u0002\u0002B7\u0005_\u00121\"\u00138qkR\u001cFO]3b[*\u0019!\u0011\u000e>\u0002\u000b1\f'-\u001a7\u0015\r\t\u0005#Q\u000fB<\u0011!\u0011yf\bCA\u0002\t\u0005\u0004b\u0002B9?\u0001\u0007\u00111R\u0001\u0004kJd\u0007\u0003\u0002B3\u0005{JAAa \u0003p\t\u0019QK\u0015'\u0015\t\t\r%Q\u0011\t\u0004\u0003;i\u0001b\u0002B=\u001f\u0001\u0007!1\u0010\u0002\n\r&dW-\u00138qkR\u001c2\u0001\u0005B!\u0003\u00111\u0017\u000e\\3\u0011\t\t\u0015$qR\u0005\u0005\u0005#\u0013yG\u0001\u0003GS2,G\u0003\u0002BK\u0005/\u00032!!\b\u0011\u0011\u001d\u0011YI\u0005a\u0001\u0005\u001b\u0013!BR5mK>+H\u000f];u'\r\u0019\"Q\u0014\t\u0004\u0003;9\"AD(TiJ,\u0017-\u001c\"vS2$WM]\n\u0004/\t\u001d\u0003CBA\u0003\u0005[\u0011)\u000b\u0005\u0003\u0003f\t\u001d\u0016\u0002\u0002BU\u0005_\u0012AbT;uaV$8\u000b\u001e:fC6$bA!(\u0003.\n=\u0006\u0002\u0003B05\u0011\u0005\rAa)\t\u000f\tE$\u00041\u0001\u0002\f\u00061\u0011\r\u001d9f]\u0012$bA!.\u00038\ne\u0006cAA\u000f'!9!1\u0012\fA\u0002\t5\u0005b\u0002BY-\u0001\u0007\u0011q\u000e\u0002\u0007'&l\u0007\u000f\\3\u0014\u0007\u001d\nY\"A\u0001q!\u0011\u0011)Ga1\n\t\t\u0015'q\u000e\u0002\u0010\u0015B\u0013xnY3tg\n+\u0018\u000e\u001c3feR!!\u0011\u001aBf!\r\tib\n\u0005\b\u0005\u007fK\u0003\u0019\u0001Ba)\u0011\t\u0019Ga4\t\u000f\u0005U'\u00061\u0001\u0002XR\u0011!1\u001b\t\u0005\u0005+\u0014y.\u0004\u0002\u0003X*!!\u0011\u001cBn\u0003\u0011a\u0017M\\4\u000b\u0005\tu\u0017\u0001\u00026bm\u0006LA!!(\u0003X\n9QK\u0015'J[Bd7c\u0002'\u0002\u0004\t\u0015\u0018Q\u0007\t\u0005\u0003;\u00119/\u0003\u0003\u0003j\u0006E\"AC+S\u0019\n+\u0018\u000e\u001c3feR!!Q\u001eBx!\r\ti\u0002\u0014\u0005\b\u0005sr\u0005\u0019\u0001B>+\t\u0011\u0019I\u0001\u0005GS2,\u0017*\u001c9m'%\u0001\u00161\u0001B|\u0003W\t)\u0004\u0005\u0003\u0002\u001e\te\u0018\u0002\u0002B~\u0003c\u00111BR5mK\n+\u0018\u000e\u001c3fe\u0006!!-Y:f)\u0011\u0019\taa\u0001\u0011\u0007\u0005u\u0001\u000bC\u0004\u0003~J\u0003\rA!$\u0016\u0005\tUUC\u0001B[\u0003=!\u0003.Y:iI1,7o\u001d\u0013mKN\u001cH\u0003BA\u0012\u0007\u001bAqaa\u0004V\u0001\u0004\u0011i)A\u0001g)\u0011\t\u0019ca\u0005\t\u000f\rUa\u000b1\u0001\u0003|\u0005\tQ\u000f\u0006\u0003\u0002$\re\u0001\u0002CB\u000e/\u0012\u0005\rA!\u0019\u0002\u0003M$B!a\t\u0004 !91\u0011\u0005-A\u0002\u0005\r\u0012!\u00012\u0003\u0019\t\u000b7/[2Ck&dG-\u001a:\u0014\u0007e\u000bY\u0002\u0006\u0002\u0004*A\u0019\u0011QD-\u0002\u0019\rDWmY6O_R$\u0006.[:\u0015\t\u0005E1q\u0006\u0005\b\u0007cY\u0006\u0019AA\u0012\u0003\u0005\tG\u0003BA2\u0007kAq!!6]\u0001\u0004\t9.A\u0007de\u0016\fG/\u001a)s_\u000e,7o\u001d\u000b\u0005\u0007w\u0019Y\u0005\u0005\u0003\u0004>\r\rc\u0002BA\u0013\u0007\u007fI1a!\u0011{\u0003\u001d\u0001&o\\2fgNLAa!\u0012\u0004H\ta!)Y:jGB\u0013xnY3tg&\u00191\u0011\n>\u0003\u0017A\u0013xnY3tg&k\u0007\u000f\u001c\u0005\b\u0003+l\u0006\u0019AAl\u0005E\u0019V-];f]RL\u0017\r\u001c\"vS2$WM]\n\u0004=\u000e%\u0012AD8qKJ\fGo\u001c:TiJLgn\u001a\u000b\t\u0007+\u001a9f!\u0017\u0004\\A\u0019\u0011Q\u00040\t\u000f\rE\"\r1\u0001\u0002$!91\u0011\u00052A\u0002\u0005\r\u0002bBB)E\u0002\u0007\u00111\u0012\u0002\r!&\u0004X\r\u001a\"vS2$WM]\n\u0004I\u000eU\u0013!\u00024jeN$\u0018AB:fG>tG-A\u0004u_\u0016\u0013(o\u001c:\u0015\u0011\r%41NB7\u0007_\u00022!!\be\u0011\u001d\u0019\t\u0007\u001ba\u0001\u0003GAqaa\u0019i\u0001\u0004\t\u0019\u0003C\u0004\u0004f!\u0004\r!a\u001c\u0015\t\rM4\u0011\u0010\t\u0005\u0007{\u0019)(\u0003\u0003\u0004x\r\u001d#A\u0004)ja\u0016$\u0007K]8dKN\u001cXm\u001d\u0005\b\u0003+L\u0007\u0019AAl\u0005)\te\u000e\u001a\"vS2$WM]\n\u0004U\u000eUCCBBA\u0007\u0007\u001b)\tE\u0002\u0002\u001e)Dqa!\u0019n\u0001\u0004\t\u0019\u0003C\u0004\u0004d5\u0004\r!a\t\u0015\t\r%5q\u0012\t\u0005\u0007{\u0019Y)\u0003\u0003\u0004\u000e\u000e\u001d#AC!oIB\u0013xnY3tg\"9\u0011Q\u001b8A\u0002\u0005]'!C(s\u0005VLG\u000eZ3s'\ry7Q\u000b\u000b\u0007\u0007/\u001bIja'\u0011\u0007\u0005uq\u000eC\u0004\u0004bI\u0004\r!a\t\t\u000f\r\r$\u000f1\u0001\u0002$Q!1qTBS!\u0011\u0019id!)\n\t\r\r6q\t\u0002\n\u001fJ\u0004&o\\2fgNDq!!6t\u0001\u0004\t9NA\bTKF,XM\\2f\u0005VLG\u000eZ3s'\r!8Q\u000b\u000b\u0007\u0007[\u001byk!-\u0011\u0007\u0005uA\u000fC\u0004\u0004b]\u0004\r!a\t\t\u000f\r\rt\u000f1\u0001\u0002$Q!1QWB^!\u0011\u0019ida.\n\t\re6q\t\u0002\u0010!J|7-Z:t'\u0016\fX/\u001a8dK\"9\u0011Q\u001b=A\u0002\u0005]g\u0002BA\u0013\u0007\u007fK1!a\r{\u0001")
public interface ProcessBuilderImpl {
    public static void $init$(ProcessBuilderImpl $this) {
    }

    public static abstract class AbstractBuilder
    implements ProcessBuilder {
        public final /* synthetic */ ProcessBuilder$ $outer;

        @Override
        public Stream<String> lines() {
            return ProcessBuilder.lines$(this);
        }

        @Override
        public Stream<String> lines(ProcessLogger log) {
            return ProcessBuilder.lines$(this, log);
        }

        @Override
        public Stream<String> lines_$bang() {
            return ProcessBuilder.lines_$bang$(this);
        }

        @Override
        public Stream<String> lines_$bang(ProcessLogger log) {
            return ProcessBuilder.lines_$bang$(this, log);
        }

        @Override
        public ProcessBuilder $hash$less(File f) {
            return ProcessBuilder.Sink.$hash$less$((ProcessBuilder.Sink)this, f);
        }

        @Override
        public ProcessBuilder $hash$less(URL f) {
            return ProcessBuilder.Sink.$hash$less$((ProcessBuilder.Sink)this, f);
        }

        @Override
        public ProcessBuilder $hash$less(Function0<InputStream> in) {
            return ProcessBuilder.Sink.$hash$less$((ProcessBuilder.Sink)this, in);
        }

        @Override
        public ProcessBuilder $hash$less(ProcessBuilder b) {
            return ProcessBuilder.Sink.$hash$less$((ProcessBuilder.Sink)this, b);
        }

        @Override
        public ProcessBuilder $hash$greater(File f) {
            return ProcessBuilder.Source.$hash$greater$((ProcessBuilder.Source)this, f);
        }

        @Override
        public ProcessBuilder $hash$greater$greater(File f) {
            return ProcessBuilder.Source.$hash$greater$greater$(this, f);
        }

        @Override
        public ProcessBuilder $hash$greater(Function0<OutputStream> out) {
            return ProcessBuilder.Source.$hash$greater$((ProcessBuilder.Source)this, out);
        }

        @Override
        public ProcessBuilder $hash$greater(ProcessBuilder b) {
            return ProcessBuilder.Source.$hash$greater$((ProcessBuilder.Source)this, b);
        }

        @Override
        public ProcessBuilder cat() {
            return ProcessBuilder.Source.cat$(this);
        }

        @Override
        public AbstractBuilder toSource() {
            return this;
        }

        @Override
        public AbstractBuilder toSink() {
            return this;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public ProcessBuilder $hash$bar(ProcessBuilder other) {
            void require_requirement;
            boolean bl = other.canPipeTo();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (require_requirement == false) {
                throw new IllegalArgumentException(new StringBuilder(20).append("requirement failed: ").append((Object)AbstractBuilder.$anonfun$$hash$bar$1()).toString());
            }
            return new PipedBuilder(this.scala$sys$process$ProcessBuilderImpl$AbstractBuilder$$$outer(), (ProcessBuilder)this, other, false);
        }

        @Override
        public ProcessBuilder $hash$bar$bar(ProcessBuilder other) {
            return new OrBuilder(this.scala$sys$process$ProcessBuilderImpl$AbstractBuilder$$$outer(), this, other);
        }

        @Override
        public ProcessBuilder $hash$amp$amp(ProcessBuilder other) {
            return new AndBuilder(this.scala$sys$process$ProcessBuilderImpl$AbstractBuilder$$$outer(), this, other);
        }

        @Override
        public ProcessBuilder $hash$hash$hash(ProcessBuilder other) {
            return new SequenceBuilder(this.scala$sys$process$ProcessBuilderImpl$AbstractBuilder$$$outer(), this, other);
        }

        @Override
        public Process run() {
            return this.run(false);
        }

        @Override
        public Process run(boolean connectInput) {
            return this.run(BasicIO$.MODULE$.standard(connectInput));
        }

        @Override
        public Process run(ProcessLogger log) {
            return this.run(log, false);
        }

        @Override
        public Process run(ProcessLogger log, boolean connectInput) {
            return this.run(BasicIO$.MODULE$.apply(connectInput, log));
        }

        @Override
        public String $bang$bang() {
            return this.slurp(None$.MODULE$, false);
        }

        @Override
        public String $bang$bang(ProcessLogger log) {
            return this.slurp(new Some<ProcessLogger>(log), false);
        }

        @Override
        public String $bang$bang$less() {
            return this.slurp(None$.MODULE$, true);
        }

        @Override
        public String $bang$bang$less(ProcessLogger log) {
            return this.slurp(new Some<ProcessLogger>(log), true);
        }

        @Override
        public Stream<String> lineStream() {
            return this.lineStream(false, true, None$.MODULE$);
        }

        @Override
        public Stream<String> lineStream(ProcessLogger log) {
            return this.lineStream(false, true, new Some<ProcessLogger>(log));
        }

        @Override
        public Stream<String> lineStream_$bang() {
            return this.lineStream(false, false, None$.MODULE$);
        }

        @Override
        public Stream<String> lineStream_$bang(ProcessLogger log) {
            return this.lineStream(false, false, new Some<ProcessLogger>(log));
        }

        @Override
        public int $bang() {
            return this.run(false).exitValue();
        }

        public int $bang(ProcessIO io) {
            return this.run(io).exitValue();
        }

        @Override
        public int $bang(ProcessLogger log) {
            return this.runBuffered(log, false);
        }

        @Override
        public int $bang$less() {
            return this.run(true).exitValue();
        }

        @Override
        public int $bang$less(ProcessLogger log) {
            return this.runBuffered(log, true);
        }

        public ProcessBuilder daemonized() {
            return new DaemonBuilder(this.scala$sys$process$ProcessBuilderImpl$AbstractBuilder$$$outer(), this);
        }

        private String slurp(Option<ProcessLogger> log, boolean withIn) {
            StringBuffer buffer = new StringBuffer();
            int code = this.$bang(BasicIO$.MODULE$.apply(withIn, buffer, log));
            if (code == 0) {
                return buffer.toString();
            }
            throw package$.MODULE$.error(new StringBuilder(20).append("Nonzero exit value: ").append(code).toString());
        }

        /*
         * WARNING - void declaration
         */
        private Stream<String> lineStream(boolean withInput, boolean nonZeroException, Option<ProcessLogger> log) {
            void apply_f;
            BasicIO.Streamed streamed = BasicIO$Streamed$.MODULE$.apply(nonZeroException);
            Process process = this.run(BasicIO$.MODULE$.apply(withInput, streamed.process(), log));
            JFunction0$mcV$sp & Serializable intersect = (JFunction0$mcV$sp & Serializable)() -> streamed.done().apply$mcVI$sp(process.exitValue());
            if (Process$.MODULE$.Spawn() == null) {
                throw null;
            }
            boolean apply_apply_daemon = false;
            Thread apply_apply_thread = new Thread(null, (Function0)apply_f){
                private final Function0 f$1;

                public void run() {
                    this.f$1.apply$mcV$sp();
                }
                {
                    this.f$1 = f$1;
                }
            };
            apply_apply_thread.setDaemon(apply_apply_daemon);
            apply_apply_thread.start();
            return streamed.stream().apply();
        }

        private int runBuffered(ProcessLogger log, boolean connectInput) {
            return BoxesRunTime.unboxToInt(log.buffer((JFunction0$mcI$sp & Serializable)() -> this.run(log, connectInput).exitValue()));
        }

        @Override
        public boolean canPipeTo() {
            return false;
        }

        @Override
        public boolean hasExitValue() {
            return true;
        }

        public /* synthetic */ ProcessBuilder$ scala$sys$process$ProcessBuilderImpl$AbstractBuilder$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ String $anonfun$$hash$bar$1() {
            return "Piping to multiple processes is not supported.";
        }

        public AbstractBuilder(ProcessBuilder$ $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            ProcessBuilder.Source.$init$(this);
            ProcessBuilder.Sink.$init$(this);
            ProcessBuilder.$init$(this);
        }
    }

    public class AndBuilder
    extends SequentialBuilder {
        private final ProcessBuilder first;
        private final ProcessBuilder second;

        @Override
        public ProcessImpl.AndProcess createProcess(ProcessIO io) {
            return new ProcessImpl.AndProcess(Process$.MODULE$, this.first, this.second, io);
        }

        public /* synthetic */ ProcessBuilder$ scala$sys$process$ProcessBuilderImpl$AndBuilder$$$outer() {
            return this.$outer;
        }

        public AndBuilder(ProcessBuilder$ $outer, ProcessBuilder first, ProcessBuilder second) {
            this.first = first;
            this.second = second;
            super($outer, first, second, "#&&");
        }
    }

    public abstract class BasicBuilder
    extends AbstractBuilder {
        /*
         * WARNING - void declaration
         */
        public void checkNotThis(ProcessBuilder a) {
            void require_requirement;
            boolean bl;
            ProcessBuilder processBuilder = a;
            boolean bl2 = bl = processBuilder == null || !processBuilder.equals(this);
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (require_requirement == false) {
                throw new IllegalArgumentException(new StringBuilder(20).append("requirement failed: ").append((Object)BasicBuilder.$anonfun$checkNotThis$1(a)).toString());
            }
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final Process run(ProcessIO io) {
            void var2_2;
            ProcessImpl.BasicProcess p = this.createProcess(io);
            p.start();
            return var2_2;
        }

        public abstract ProcessImpl.BasicProcess createProcess(ProcessIO var1);

        public /* synthetic */ ProcessBuilder$ scala$sys$process$ProcessBuilderImpl$BasicBuilder$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ String $anonfun$checkNotThis$1(ProcessBuilder a$1) {
            return new StringBuilder(42).append("Compound process '").append(a$1).append("' cannot contain itself.").toString();
        }

        public BasicBuilder(ProcessBuilder$ $outer) {
            super($outer);
        }
    }

    public class DaemonBuilder
    extends AbstractBuilder {
        private final ProcessBuilder underlying;

        @Override
        public final Process run(ProcessIO io) {
            return this.underlying.run(io.daemonized());
        }

        public /* synthetic */ ProcessBuilder$ scala$sys$process$ProcessBuilderImpl$DaemonBuilder$$$outer() {
            return this.$outer;
        }

        public DaemonBuilder(ProcessBuilder$ $outer, ProcessBuilder underlying) {
            this.underlying = underlying;
            super($outer);
        }
    }

    public class Dummy
    extends AbstractBuilder {
        private final String toString;
        private final Function0<Object> exitValue;

        public String toString() {
            return this.toString;
        }

        @Override
        public Process run(ProcessIO io) {
            return new ProcessImpl.DummyProcess(Process$.MODULE$, this.exitValue);
        }

        @Override
        public boolean canPipeTo() {
            return true;
        }

        public /* synthetic */ ProcessBuilder$ scala$sys$process$ProcessBuilderImpl$Dummy$$$outer() {
            return this.$outer;
        }

        public Dummy(ProcessBuilder$ $outer, String toString2, Function0<Object> exitValue) {
            this.toString = toString2;
            this.exitValue = exitValue;
            super($outer);
        }
    }

    public class FileImpl
    implements ProcessBuilder.FileBuilder {
        private final File base;
        public final /* synthetic */ ProcessBuilder$ $outer;

        @Override
        public ProcessBuilder $hash$greater(File f) {
            return ProcessBuilder.Source.$hash$greater$((ProcessBuilder.Source)this, f);
        }

        @Override
        public ProcessBuilder $hash$greater$greater(File f) {
            return ProcessBuilder.Source.$hash$greater$greater$(this, f);
        }

        @Override
        public ProcessBuilder $hash$greater(Function0<OutputStream> out) {
            return ProcessBuilder.Source.$hash$greater$((ProcessBuilder.Source)this, out);
        }

        @Override
        public ProcessBuilder $hash$greater(ProcessBuilder b) {
            return ProcessBuilder.Source.$hash$greater$((ProcessBuilder.Source)this, b);
        }

        @Override
        public ProcessBuilder cat() {
            return ProcessBuilder.Source.cat$(this);
        }

        @Override
        public ProcessBuilder $hash$less(File f) {
            return ProcessBuilder.Sink.$hash$less$((ProcessBuilder.Sink)this, f);
        }

        @Override
        public ProcessBuilder $hash$less(URL f) {
            return ProcessBuilder.Sink.$hash$less$((ProcessBuilder.Sink)this, f);
        }

        @Override
        public ProcessBuilder $hash$less(Function0<InputStream> in) {
            return ProcessBuilder.Sink.$hash$less$((ProcessBuilder.Sink)this, in);
        }

        @Override
        public ProcessBuilder $hash$less(ProcessBuilder b) {
            return ProcessBuilder.Sink.$hash$less$((ProcessBuilder.Sink)this, b);
        }

        @Override
        public FileInput toSource() {
            return new FileInput(this.scala$sys$process$ProcessBuilderImpl$FileImpl$$$outer(), this.base);
        }

        @Override
        public FileOutput toSink() {
            return new FileOutput(this.scala$sys$process$ProcessBuilderImpl$FileImpl$$$outer(), this.base, false);
        }

        @Override
        public ProcessBuilder $hash$less$less(File f) {
            return this.$hash$less$less(new FileInput(this.scala$sys$process$ProcessBuilderImpl$FileImpl$$$outer(), f));
        }

        @Override
        public ProcessBuilder $hash$less$less(URL u) {
            return this.$hash$less$less(new URLInput(this.scala$sys$process$ProcessBuilderImpl$FileImpl$$$outer(), u));
        }

        @Override
        public ProcessBuilder $hash$less$less(Function0<InputStream> s) {
            return this.$hash$less$less(new IStreamBuilder(this.scala$sys$process$ProcessBuilderImpl$FileImpl$$$outer(), s, "<input stream>"));
        }

        @Override
        public ProcessBuilder $hash$less$less(ProcessBuilder b) {
            return new PipedBuilder(this.scala$sys$process$ProcessBuilderImpl$FileImpl$$$outer(), b, (ProcessBuilder)new FileOutput(this.scala$sys$process$ProcessBuilderImpl$FileImpl$$$outer(), this.base, true), false);
        }

        public /* synthetic */ ProcessBuilder$ scala$sys$process$ProcessBuilderImpl$FileImpl$$$outer() {
            return this.$outer;
        }

        public FileImpl(ProcessBuilder$ $outer, File base) {
            this.base = base;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            ProcessBuilder.Sink.$init$(this);
            ProcessBuilder.Source.$init$(this);
        }
    }

    public class FileInput
    extends IStreamBuilder {
        public /* synthetic */ ProcessBuilder$ scala$sys$process$ProcessBuilderImpl$FileInput$$$outer() {
            return this.$outer;
        }

        public FileInput(ProcessBuilder$ $outer, File file) {
            super($outer, (Function0<InputStream>)((Object)new Serializable(null, file){
                public static final long serialVersionUID = 0L;
                private final File file$1;

                public final FileInputStream apply() {
                    return new FileInputStream(this.file$1);
                }
                {
                    this.file$1 = file$1;
                }
            }), file.getAbsolutePath());
        }
    }

    public class FileOutput
    extends OStreamBuilder {
        public /* synthetic */ ProcessBuilder$ scala$sys$process$ProcessBuilderImpl$FileOutput$$$outer() {
            return this.$outer;
        }

        public FileOutput(ProcessBuilder$ $outer, File file, boolean append) {
            super($outer, (Function0<OutputStream>)((Object)new Serializable(null, file, append){
                public static final long serialVersionUID = 0L;
                private final File file$2;
                private final boolean append$1;

                public final FileOutputStream apply() {
                    return new FileOutputStream(this.file$2, this.append$1);
                }
                {
                    this.file$2 = file$2;
                    this.append$1 = append$1;
                }
            }), file.getAbsolutePath());
        }
    }

    public class IStreamBuilder
    extends ThreadBuilder {
        @Override
        public boolean hasExitValue() {
            return false;
        }

        public /* synthetic */ ProcessBuilder$ scala$sys$process$ProcessBuilderImpl$IStreamBuilder$$$outer() {
            return this.$outer;
        }

        public IStreamBuilder(ProcessBuilder$ $outer, Function0<InputStream> stream, String label) {
            super($outer, label, (Function1<ProcessIO, BoxedUnit>)((Object)new Serializable(null, stream){
                public static final long serialVersionUID = 0L;
                private final Function0 stream$2;

                public final void apply(ProcessIO x$2) {
                    x$2.processOutput().apply(BasicIO$Uncloseable$.MODULE$.protect((InputStream)this.stream$2.apply()));
                }
                {
                    this.stream$2 = stream$2;
                }
            }));
        }
    }

    public class OStreamBuilder
    extends ThreadBuilder {
        @Override
        public boolean hasExitValue() {
            return false;
        }

        public /* synthetic */ ProcessBuilder$ scala$sys$process$ProcessBuilderImpl$OStreamBuilder$$$outer() {
            return this.$outer;
        }

        public OStreamBuilder(ProcessBuilder$ $outer, Function0<OutputStream> stream, String label) {
            super($outer, label, (Function1<ProcessIO, BoxedUnit>)((Object)new Serializable(null, stream){
                public static final long serialVersionUID = 0L;
                private final Function0 stream$1;

                public final void apply(ProcessIO x$1) {
                    x$1.writeInput().apply(BasicIO$Uncloseable$.MODULE$.protect((OutputStream)this.stream$1.apply()));
                }
                {
                    this.stream$1 = stream$1;
                }
            }));
        }
    }

    public class OrBuilder
    extends SequentialBuilder {
        private final ProcessBuilder first;
        private final ProcessBuilder second;

        @Override
        public ProcessImpl.OrProcess createProcess(ProcessIO io) {
            return new ProcessImpl.OrProcess(Process$.MODULE$, this.first, this.second, io);
        }

        public /* synthetic */ ProcessBuilder$ scala$sys$process$ProcessBuilderImpl$OrBuilder$$$outer() {
            return this.$outer;
        }

        public OrBuilder(ProcessBuilder$ $outer, ProcessBuilder first, ProcessBuilder second) {
            this.first = first;
            this.second = second;
            super($outer, first, second, "#||");
        }
    }

    public class PipedBuilder
    extends SequentialBuilder {
        private final ProcessBuilder first;
        private final ProcessBuilder second;
        private final boolean toError;

        @Override
        public ProcessImpl.PipedProcesses createProcess(ProcessIO io) {
            return new ProcessImpl.PipedProcesses(Process$.MODULE$, this.first, this.second, io, this.toError);
        }

        public /* synthetic */ ProcessBuilder$ scala$sys$process$ProcessBuilderImpl$PipedBuilder$$$outer() {
            return this.$outer;
        }

        public PipedBuilder(ProcessBuilder$ $outer, ProcessBuilder first, ProcessBuilder second, boolean toError) {
            this.first = first;
            this.second = second;
            this.toError = toError;
            super($outer, first, second, toError ? "#|!" : "#|");
        }
    }

    public class SequenceBuilder
    extends SequentialBuilder {
        private final ProcessBuilder first;
        private final ProcessBuilder second;

        @Override
        public ProcessImpl.ProcessSequence createProcess(ProcessIO io) {
            return new ProcessImpl.ProcessSequence(Process$.MODULE$, this.first, this.second, io);
        }

        public /* synthetic */ ProcessBuilder$ scala$sys$process$ProcessBuilderImpl$SequenceBuilder$$$outer() {
            return this.$outer;
        }

        public SequenceBuilder(ProcessBuilder$ $outer, ProcessBuilder first, ProcessBuilder second) {
            this.first = first;
            this.second = second;
            super($outer, first, second, "###");
        }
    }

    public abstract class SequentialBuilder
    extends BasicBuilder {
        private final ProcessBuilder a;
        private final ProcessBuilder b;
        private final String operatorString;

        public String toString() {
            return new StringBuilder(8).append(" ( ").append(this.a).append(" ").append(this.operatorString).append(" ").append(this.b).append(" ) ").toString();
        }

        public /* synthetic */ ProcessBuilder$ scala$sys$process$ProcessBuilderImpl$SequentialBuilder$$$outer() {
            return this.$outer;
        }

        public SequentialBuilder(ProcessBuilder$ $outer, ProcessBuilder a, ProcessBuilder b, String operatorString) {
            this.a = a;
            this.b = b;
            this.operatorString = operatorString;
            super($outer);
            this.checkNotThis(a);
            this.checkNotThis(b);
        }
    }

    public class Simple
    extends AbstractBuilder {
        private final java.lang.ProcessBuilder p;

        /*
         * WARNING - void declaration
         */
        @Override
        public Process run(ProcessIO io) {
            void var9_8;
            void var6_5;
            List list;
            void apply_daemon;
            void apply_f;
            void apply_daemon2;
            void apply_f2;
            java.lang.Process process = this.p.start();
            boolean bl = true;
            JFunction0$mcV$sp & Serializable intersect = (JFunction0$mcV$sp & Serializable)() -> io.writeInput().apply(process.getOutputStream());
            if (Process$.MODULE$.Spawn() == null) {
                throw null;
            }
            Thread apply_thread = new /* invalid duplicate definition of identical inner class */;
            apply_thread.setDaemon((boolean)apply_daemon2);
            apply_thread.start();
            boolean bl2 = io.daemonizeThreads();
            JFunction0$mcV$sp & Serializable intersect2 = (JFunction0$mcV$sp & Serializable)() -> io.processOutput().apply(process.getInputStream());
            if (Process$.MODULE$.Spawn() == null) {
                throw null;
            }
            Thread apply_thread2 = new /* invalid duplicate definition of identical inner class */;
            apply_thread2.setDaemon((boolean)apply_daemon);
            apply_thread2.start();
            if (this.p.redirectErrorStream()) {
                list = Nil$.MODULE$;
            } else {
                void var12_11;
                void apply_daemon3;
                void apply_f3;
                boolean bl3 = io.daemonizeThreads();
                JFunction0$mcV$sp & Serializable intersect3 = (JFunction0$mcV$sp & Serializable)() -> io.processError().apply(process.getErrorStream());
                if (Process$.MODULE$.Spawn() == null) {
                    throw null;
                }
                Thread apply_thread3 = new /* invalid duplicate definition of identical inner class */;
                apply_thread3.setDaemon((boolean)apply_daemon3);
                apply_thread3.start();
                list = new $colon$colon<Nothing$>((Nothing$)var12_11, Nil$.MODULE$);
            }
            List errorThread = list;
            return new ProcessImpl.SimpleProcess(Process$.MODULE$, process, (Thread)var6_5, errorThread.$colon$colon(var9_8));
        }

        public String toString() {
            return this.p.command().toString();
        }

        @Override
        public boolean canPipeTo() {
            return true;
        }

        public /* synthetic */ ProcessBuilder$ scala$sys$process$ProcessBuilderImpl$Simple$$$outer() {
            return this.$outer;
        }

        public Simple(ProcessBuilder$ $outer, java.lang.ProcessBuilder p) {
            this.p = p;
            super($outer);
        }
    }

    public abstract class ThreadBuilder
    extends AbstractBuilder {
        private final String toString;
        private final Function1<ProcessIO, BoxedUnit> runImpl;

        public String toString() {
            return this.toString;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public Process run(ProcessIO io) {
            void var5_5;
            void apply_daemon;
            void apply_f;
            SyncVar<Object> success = new SyncVar<Object>();
            boolean bl = io.daemonizeThreads();
            JFunction0$mcV$sp & Serializable intersect = (JFunction0$mcV$sp & Serializable)() -> this.go$1(io, success);
            if (Process$.MODULE$.Spawn() == null) {
                throw null;
            }
            Thread apply_thread = new /* invalid duplicate definition of identical inner class */;
            apply_thread.setDaemon((boolean)apply_daemon);
            apply_thread.start();
            return new ProcessImpl.ThreadProcess(Process$.MODULE$, (Thread)var5_5, success);
        }

        public /* synthetic */ ProcessBuilder$ scala$sys$process$ProcessBuilderImpl$ThreadBuilder$$$outer() {
            return this.$outer;
        }

        private final void go$1(ProcessIO io$1, SyncVar success$1) {
            boolean ok = false;
            try {
                this.runImpl.apply(io$1);
                ok = true;
            }
            finally {
                success$1.put(BoxesRunTime.boxToBoolean(ok));
            }
        }

        public ThreadBuilder(ProcessBuilder$ $outer, String toString2, Function1<ProcessIO, BoxedUnit> runImpl) {
            this.toString = toString2;
            this.runImpl = runImpl;
            super($outer);
        }
    }

    public class URLImpl
    implements ProcessBuilder.URLBuilder {
        private final URL url;
        public final /* synthetic */ ProcessBuilder$ $outer;

        @Override
        public ProcessBuilder $hash$greater(File f) {
            return ProcessBuilder.Source.$hash$greater$((ProcessBuilder.Source)this, f);
        }

        @Override
        public ProcessBuilder $hash$greater$greater(File f) {
            return ProcessBuilder.Source.$hash$greater$greater$(this, f);
        }

        @Override
        public ProcessBuilder $hash$greater(Function0<OutputStream> out) {
            return ProcessBuilder.Source.$hash$greater$((ProcessBuilder.Source)this, out);
        }

        @Override
        public ProcessBuilder $hash$greater(ProcessBuilder b) {
            return ProcessBuilder.Source.$hash$greater$((ProcessBuilder.Source)this, b);
        }

        @Override
        public ProcessBuilder cat() {
            return ProcessBuilder.Source.cat$(this);
        }

        @Override
        public URLInput toSource() {
            return new URLInput(this.scala$sys$process$ProcessBuilderImpl$URLImpl$$$outer(), this.url);
        }

        public /* synthetic */ ProcessBuilder$ scala$sys$process$ProcessBuilderImpl$URLImpl$$$outer() {
            return this.$outer;
        }

        public URLImpl(ProcessBuilder$ $outer, URL url) {
            this.url = url;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            ProcessBuilder.Source.$init$(this);
        }
    }

    public class URLInput
    extends IStreamBuilder {
        public /* synthetic */ ProcessBuilder$ scala$sys$process$ProcessBuilderImpl$URLInput$$$outer() {
            return this.$outer;
        }

        public URLInput(ProcessBuilder$ $outer, URL url) {
            super($outer, (Function0<InputStream>)((Object)new Serializable(null, url){
                public static final long serialVersionUID = 0L;
                private final URL url$1;

                public final InputStream apply() {
                    return this.url$1.openStream();
                }
                {
                    this.url$1 = url$1;
                }
            }), url.toString());
        }
    }
}

