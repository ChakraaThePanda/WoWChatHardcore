/*
 * Decompiled with CFR 0.152.
 */
package scala.sys.process;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.LinkedBlockingQueue;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.Tuple3;
import scala.Tuple4;
import scala.collection.Seq;
import scala.collection.immutable.List;
import scala.concurrent.SyncVar;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.java8.JFunction0$mcI$sp;
import scala.runtime.java8.JFunction0$mcV$sp;
import scala.sys.package$;
import scala.sys.process.BasicIO$;
import scala.sys.process.Process;
import scala.sys.process.Process$;
import scala.sys.process.ProcessBuilder;
import scala.sys.process.ProcessIO;
import scala.sys.process.ProcessImpl$Future$;
import scala.sys.process.ProcessImpl$Spawn$;
import scala.sys.process.processInternal$;

@ScalaSignature(bytes="\u0006\u0001\r\rdA\u00038p!\u0003\r\ta\\;\u0004^!)!\u0010\u0001C\u0001y\u001eA\u0011\u0011\u0001\u0001\t\u0002=\f\u0019A\u0002\u0005\u0002\b\u0001A\ta\\A\u0005\u0011\u001d\tYa\u0001C\u0001\u0003\u001bAq!a\u0004\u0004\t\u0003\t\t\u0002C\u0004\u0002\u0010\r!\t!!\f\b\u0011\u0005m\u0002\u0001#\u0001p\u0003{1\u0001\"a\u0010\u0001\u0011\u0003y\u0017\u0011\t\u0005\b\u0003\u0017AA\u0011AA\"\u0011\u001d\ty\u0001\u0003C\u0001\u0003\u000b2q!a\u001c\u0001\u0001=\f\t\b\u0003\u0006\u0002b.\u0011\t\u0011)A\u0005\u0003GD!\"!;\f\u0005\u0003\u0005\u000b\u0011BAr\u0011)\tYo\u0003B\u0001B\u0003%\u0011Q\u001e\u0005\b\u0003\u0017YA\u0011\u0001B\u0003\r\u001d\u0011y\u0001\u0001\u0001p\u0005#A!\"!9\u0011\u0005\u0003\u0005\u000b\u0011BAr\u0011)\tI\u000f\u0005B\u0001B\u0003%\u00111\u001d\u0005\u000b\u0003W\u0004\"\u0011!Q\u0001\n\u00055\bbBA\u0006!\u0011\u0005!1\u0003\u0004\b\u0005;\u0001\u0001a\u001cB\u0010\u0011)\t\t/\u0006B\u0001B\u0003%\u00111\u001d\u0005\u000b\u0003S,\"\u0011!Q\u0001\n\u0005\r\bBCAv+\t\u0005\t\u0015!\u0003\u0002n\"9\u00111B\u000b\u0005\u0002\t\u0005baBA;\u0001\u0001y\u0017q\u000f\u0005\u000b\u0003CT\"\u0011!Q\u0001\n\u0005\r\bBCAu5\t\u0005\t\u0015!\u0003\u0002d\"Q\u00111\u001e\u000e\u0003\u0002\u0003\u0006I!!<\t\u0015\u0005M(D!A!\u0002\u0013\t)\u0010C\u0004\u0002\fi!\t!a?\t\u0011\u0005\u0015'\u0004)C)\u0003\u000f4\u0001\"!!\u0001\u0003\u0003y\u00171\u0011\u0005\b\u0003\u0017\tC\u0011AAG\u0011\u0019\ty)\tD\u0001y\u001aA\u00111\u0010\u0001\u0002\u0002=\fi\bC\u0004\u0002\f\u0011\"\t!!%\t\u000f\u0005ME\u0005\"\u0001\u0002\u0016\"1\u0011q\u0013\u0013\u0005\u0002qDq!!'%\t\u0003\tY\n\u0003\u0004\u0002\u0010\u0012\"\t\u0001 \u0005\r\u0003G#\u0003\u0013!EDB\u0013%\u0011Q\u0015\u0005\u000b\u0003o#\u0003R1A\u0005\u0012\u0005e\u0006BCA^I!\u0015\r\u0011\"\u0005\u0002:\"Q\u0011Q\u0018\u0013\t\u0006\u0004%\t\"a0\t\u0015\u0005\u0005G\u0005#b\u0001\n#\t\u0019\r\u0003\u0005\u0002F\u0012\u0002k\u0011CAd\u0011!\tI\r\nQ\u0005\u0012\u0005-ga\u0002B\u0016\u0001\u0001y'Q\u0006\u0005\u000b\u0003C\f$\u0011!Q\u0001\n\u0005\r\bBCAuc\t\u0005\t\u0015!\u0003\u0002d\"Q!qF\u0019\u0003\u0002\u0003\u0006I!!<\t\u0015\tE\u0012G!A!\u0002\u0013\t)\u0004C\u0004\u0002\fE\"\tAa\r\t\u0011\u0005\u0015\u0017\u0007)C)\u0003\u000fD\u0001\"!22A\u0013E!q\b\u0004\t\u0005\u001b\u0002\u0011\u0011A8\u0003P!Q!\u0011K\u001d\u0003\u0002\u0003\u0006I!!\u000e\t\u0015\tM\u0013H!A!\u0002\u0013\u0011)\u0006C\u0004\u0002\fe\"\tA!\u001c\t\r\tM\u0014H\"\u0001}\u0011!\u0011)(\u000fC\u0001_\n]\u0004b\u0002BKs\u0011%!q\u0013\u0004\b\u0005\u000f\u0002\u0001a\u001cB%\u0011)\u0011\u0019\u000b\u0011B\u0001J\u0003%!Q\u0015\u0005\b\u0003\u0017\u0001E\u0011\u0001BT\u0011%\u0011Y\u000b\u0011b!\n#\u0011i\u000b\u0003\u0005\u0003:\u0002\u0003\u000b\u0011\u0002BX\u0011%\u0011\u0019\u0005\u0011b!\n#\u0011Y\f\u0003\u0005\u0003P\u0002\u0003\u000b\u0011\u0002B_\u0011\u0019\u0011\u0019\b\u0011C!y\"9!\u0011\u001b!\u0005\u0002\tM\u0007b\u0002Bm\u0001\u0012\u0005!1\u001c\u0005\u0007\u0007\u000f\u0001E\u0011\u0001?\u0007\u000f\t\r\b\u0001A8\u0003f\"Q!1U&\u0003\u0002\u0013\u0006IA!*\t\u000f\u0005-1\n\"\u0001\u0003h\"I!1V&CB\u0013E!1\u001e\u0005\t\u0005s[\u0005\u0015!\u0003\u0003n\"I!q\\&CB\u0013E!1\u001f\u0005\t\u0005s\\\u0005\u0015!\u0003\u0003v\"1!1O&\u0005BqDqA!7L\t\u0003\u0011Y\u0010C\u0004\u0003R.#\ta!\u0001\t\r\r\u001d1\n\"\u0001}\r\u001d\u0019Y\u0001\u0001\u0001p\u0007\u001bA!\"!8W\u0005\u0003%\u000b\u0011BB\b\u0011\u001d\tYA\u0016C\u0001\u0007#AAba\u0006W!\u0003\u0005\u0019\u0011)A\u0005\u00073A\u0001b!\bWA\u0003%\u00111\u0003\u0005\t\u0007?1\u0006\u0015!\u0003\u0004\u001c!9\u00111\u0013,\u0005B\u0005U\u0005bBAM-\u0012\u0005\u00131\u0014\u0005\u0007\u0003/3F\u0011\t?\u0007\u000f\r\u0005\u0002\u0001A8\u0004$!Q1QE0\u0003\u0002\u0003\u0006Iaa\n\t\u0015\r5rL!A!\u0002\u0013\t\u0019\u0002\u0003\u0006\u00040}\u0013\t\u0011)A\u0005\u0007cAq!a\u0003`\t\u0003\u0019y\u0004C\u0004\u0002\u0014~#\t%!&\t\u000f\u0005eu\f\"\u0011\u0002\u001c\"1\u0011qS0\u0005Bq4qa!\u0013\u0001\u0005=\u001cY\u0005\u0003\u0006\u0004\u001e\u001d\u0014\t\u0011)A\u0005\u0003'A!b!\u0014h\u0005\u0003\u0005\u000b\u0011BB(\u0011\u001d\tYa\u001aC\u0001\u0007+Bq!a%h\t\u0003\n)\nC\u0004\u0002\u001a\u001e$\t%a'\t\r\u0005]u\r\"\u0011}\u0005-\u0001&o\\2fgNLU\u000e\u001d7\u000b\u0005A\f\u0018a\u00029s_\u000e,7o\u001d\u0006\u0003eN\f1a]=t\u0015\u0005!\u0018!B:dC2\f7C\u0001\u0001w!\t9\b0D\u0001t\u0013\tI8O\u0001\u0004B]f\u0014VMZ\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0004\u0001Q\tQ\u0010\u0005\u0002x}&\u0011qp\u001d\u0002\u0005+:LG/A\u0003Ta\u0006<h\u000eE\u0002\u0002\u0006\ri\u0011\u0001\u0001\u0002\u0006'B\fwO\\\n\u0003\u0007Y\fa\u0001P5oSRtDCAA\u0002\u0003\u0015\t\u0007\u000f\u001d7z)\u0011\t\u0019\"a\t\u0011\t\u0005U\u0011qD\u0007\u0003\u0003/QA!!\u0007\u0002\u001c\u0005!A.\u00198h\u0015\t\ti\"\u0001\u0003kCZ\f\u0017\u0002BA\u0011\u0003/\u0011a\u0001\u00165sK\u0006$\u0007\u0002CA\u0013\u000b\u0011\u0005\r!a\n\u0002\u0003\u0019\u0004Ba^A\u0015{&\u0019\u00111F:\u0003\u0011q\u0012\u0017P\\1nKz\"b!a\u0005\u00020\u0005E\u0002\u0002CA\u0013\r\u0011\u0005\r!a\n\t\u000f\u0005Mb\u00011\u0001\u00026\u00051A-Y3n_:\u00042a^A\u001c\u0013\r\tId\u001d\u0002\b\u0005>|G.Z1o\u0003\u00191U\u000f^;sKB\u0019\u0011Q\u0001\u0005\u0003\r\u0019+H/\u001e:f'\tAa\u000f\u0006\u0002\u0002>U!\u0011qIA-)\u0011\tI%a\u001b\u0011\u000f]\fY%a\u0005\u0002P%\u0019\u0011QJ:\u0003\rQ+\b\u000f\\33!\u00159\u0018\u0011KA+\u0013\r\t\u0019f\u001d\u0002\n\rVt7\r^5p]B\u0002B!a\u0016\u0002Z1\u0001AaBA.\u0015\t\u0007\u0011Q\f\u0002\u0002)F!\u0011qLA3!\r9\u0018\u0011M\u0005\u0004\u0003G\u001a(a\u0002(pi\"Lgn\u001a\t\u0004o\u0006\u001d\u0014bAA5g\n\u0019\u0011I\\=\t\u0011\u0005\u0015\"\u0002\"a\u0001\u0003[\u0002Ra^A\u0015\u0003+\u0012!\"\u00118e!J|7-Z:t'\rY\u00111\u000f\t\u0004\u0003\u000bQ\"!E*fcV,g\u000e^5bYB\u0013xnY3tgN\u0019!$!\u001f\u0011\u0007\u0005\u0015AEA\bD_6\u0004x.\u001e8e!J|7-Z:t'\r!\u0013q\u0010\t\u0004\u0003\u000b\t#\u0001\u0004\"bg&\u001c\u0007K]8dKN\u001c8\u0003B\u0011w\u0003\u000b\u0003B!a\"\u0002\n6\tq.C\u0002\u0002\f>\u0014q\u0001\u0015:pG\u0016\u001c8\u000f\u0006\u0002\u0002\u0000\u0005)1\u000f^1siR\u0011\u0011\u0011P\u0001\bSN\fE.\u001b<f)\t\t)$A\u0004eKN$(o\\=\u0002\u0013\u0015D\u0018\u000e\u001e,bYV,GCAAO!\r9\u0018qT\u0005\u0004\u0003C\u001b(aA%oi\u0006\u0019\u0001\u0010\n\u001b\u0016\u0005\u0005\u001d\u0006cC<\u0002*\u0006M\u00111CAW\u0003kK1!a+t\u0005\u0019!V\u000f\u001d7fiA)q/!\u0015\u00020B)q/!-\u0002\u001e&\u0019\u00111W:\u0003\r=\u0003H/[8o!\u00119\u0018\u0011K?\u0002\u001bA\u0014xnY3tgRC'/Z1e+\t\t\u0019\"\u0001\u0007gkR,(/\u001a+ie\u0016\fG-A\u0006gkR,(/\u001a,bYV,WCAAW\u0003%!Wm\u001d;s_f,'/\u0006\u0002\u00026\u0006y!/\u001e8B]\u0012,\u00050\u001b;WC2,X\r\u0006\u0002\u00020\u0006\u0001\"/\u001e8J]R,'O];qi&\u0014G.Z\u000b\u0005\u0003\u001b\f)\u000e\u0006\u0003\u0002P\u0006mG\u0003BAi\u0003/\u0004Ra^AY\u0003'\u0004B!a\u0016\u0002V\u00129\u00111\f\u0019C\u0002\u0005u\u0003\u0002CAma\u0011\u0005\r!a\n\u0002\u0017\u0011,7\u000f\u001e:ps&k\u0007\u000f\u001c\u0005\t\u0003;\u0004D\u00111\u0001\u0002`\u00061\u0011m\u0019;j_:\u0004Ra^A\u0015\u0003'\f\u0011!\u0019\t\u0005\u0003\u000f\u000b)/C\u0002\u0002h>\u0014a\u0002\u0015:pG\u0016\u001c8OQ;jY\u0012,'/A\u0001c\u0003\tIw\u000e\u0005\u0003\u0002\b\u0006=\u0018bAAy_\nI\u0001K]8dKN\u001c\u0018jT\u0001\u0016KZ\fG.^1uKN+7m\u001c8e!J|7-Z:t!\u001d9\u0018q_AO\u0003kI1!!?t\u0005%1UO\\2uS>t\u0017\u0007\u0006\u0006\u0002t\u0005u\u0018q B\u0001\u0005\u0007Aq!!9 \u0001\u0004\t\u0019\u000fC\u0004\u0002j~\u0001\r!a9\t\u000f\u0005-x\u00041\u0001\u0002n\"9\u00111_\u0010A\u0002\u0005UH\u0003\u0003B\u0004\u0005\u0013\u0011YA!\u0004\u0011\u0007\u0005\u00151\u0002C\u0004\u0002b>\u0001\r!a9\t\u000f\u0005%x\u00021\u0001\u0002d\"9\u00111^\bA\u0002\u00055(!C(s!J|7-Z:t'\r\u0001\u00121\u000f\u000b\t\u0005+\u00119B!\u0007\u0003\u001cA\u0019\u0011Q\u0001\t\t\u000f\u0005\u0005H\u00031\u0001\u0002d\"9\u0011\u0011\u001e\u000bA\u0002\u0005\r\bbBAv)\u0001\u0007\u0011Q\u001e\u0002\u0010!J|7-Z:t'\u0016\fX/\u001a8dKN\u0019Q#a\u001d\u0015\u0011\t\r\"Q\u0005B\u0014\u0005S\u00012!!\u0002\u0016\u0011\u001d\t\t/\u0007a\u0001\u0003GDq!!;\u001a\u0001\u0004\t\u0019\u000fC\u0004\u0002lf\u0001\r!!<\u0003\u001dAK\u0007/\u001a3Qe>\u001cWm]:fgN\u0019\u0011'!\u001f\u0002\u0013\u0011,g-Y;mi&{\u0015a\u0002;p\u000bJ\u0014xN\u001d\u000b\u000b\u0005k\u00119D!\u000f\u0003<\tu\u0002cAA\u0003c!9\u0011\u0011\u001d\u001cA\u0002\u0005\r\bbBAum\u0001\u0007\u00111\u001d\u0005\b\u0005_1\u0004\u0019AAw\u0011\u001d\u0011\tD\u000ea\u0001\u0003k!b!a,\u0003B\r%\u0001b\u0002B\"q\u0001\u0007!QI\u0001\u0007g>,(oY3\u0011\u0007\u0005\u0015\u0001I\u0001\u0006QSB,7k\\;sG\u0016\u001c2\u0001\u0011B&!\r\t)!\u000f\u0002\u000b!&\u0004X\r\u00165sK\u0006$7cA\u001d\u0002\u0014\u00051\u0011n]*j].\fq\u0001\\1cK24e\u000eE\u0003x\u0003#\u00129\u0006\u0005\u0003\u0003Z\t\u001dd\u0002\u0002B.\u0005G\u00022A!\u0018t\u001b\t\u0011yFC\u0002\u0003bm\fa\u0001\u0010:p_Rt\u0014b\u0001B3g\u00061\u0001K]3eK\u001aLAA!\u001b\u0003l\t11\u000b\u001e:j]\u001eT1A!\u001at)\u0019\u0011YEa\u001c\u0003r!9!\u0011\u000b\u001fA\u0002\u0005U\u0002b\u0002B*y\u0001\u0007!QK\u0001\u0004eVt\u0017a\u0002:v]2|w\u000e\u001d\u000b\u0006{\ne$1\u0012\u0005\b\u0005wr\u0004\u0019\u0001B?\u0003\r\u0019(o\u0019\t\u0005\u0005\u007f\u0012)I\u0004\u0003\u0002\b\n\u0005\u0015b\u0001BB_\u0006y\u0001O]8dKN\u001c\u0018J\u001c;fe:\fG.\u0003\u0003\u0003\b\n%%aC%oaV$8\u000b\u001e:fC6T1Aa!p\u0011\u001d\u0011iI\u0010a\u0001\u0005\u001f\u000b1\u0001Z:u!\u0011\u0011yH!%\n\t\tM%\u0011\u0012\u0002\r\u001fV$\b/\u001e;TiJ,\u0017-\\\u0001\nS>D\u0015M\u001c3mKJ$2! BM\u0011\u001d\u0011Yj\u0010a\u0001\u0005;\u000b\u0011!\u001a\t\u0005\u0005\u007f\u0012y*\u0003\u0003\u0003\"\n%%aC%P\u000bb\u001cW\r\u001d;j_:\fQ\u0001\\1cK2\u0004Ra^A\u0015\u0005/\"BA!\u0012\u0003*\"A!1\u0015\"\u0005\u0002\u0004\u0011)+\u0001\u0003qSB,WC\u0001BX!\u0011\u0011\tL!.\u000e\u0005\tM&\u0002BAv\u00037IAAa.\u00034\n\t\u0002+\u001b9fI>+H\u000f];u'R\u0014X-Y7\u0002\u000bAL\u0007/\u001a\u0011\u0016\u0005\tu\u0006C\u0002B`\u0005\u0013\u0014i-\u0004\u0002\u0003B*!!1\u0019Bc\u0003)\u0019wN\\2veJ,g\u000e\u001e\u0006\u0005\u0005\u000f\fY\"\u0001\u0003vi&d\u0017\u0002\u0002Bf\u0005\u0003\u00141\u0003T5oW\u0016$'\t\\8dW&tw-U;fk\u0016\u0004Ra^AY\u0005{\nqa]8ve\u000e,\u0007%A\u0005d_:tWm\u0019;J]R\u0019QP!6\t\u000f\t]\u0007\n1\u0001\u0003~\u0005\u0011\u0011N\\\u0001\u000bG>tg.Z2u\u001fV$HcA?\u0003^\"9!q\\%A\u0002\t\u0005\u0018\u0001B:j].\u00042!!\u0002L\u0005!\u0001\u0016\u000e]3TS:\\7cA&\u0003LQ!!\u0011\u001dBu\u0011!\u0011\u0019+\u0014CA\u0002\t\u0015VC\u0001Bw!\u0011\u0011\tLa<\n\t\tE(1\u0017\u0002\u0011!&\u0004X\rZ%oaV$8\u000b\u001e:fC6,\"A!>\u0011\r\t}&\u0011\u001aB|!\u00159\u0018\u0011\u0017BH\u0003\u0015\u0019\u0018N\\6!)\ri(Q \u0005\b\u0005\u007f\u001c\u0006\u0019\u0001BH\u0003\ryW\u000f\u001e\u000b\u0004{\u000e\r\u0001bBB\u0003)\u0002\u0007!qV\u0001\ba&\u0004XmT;u\u0003\u001d\u0011X\r\\3bg\u0016DqAa89\u0001\u0004\u0011\tO\u0001\u0007Ek6l\u0017\u0010\u0015:pG\u0016\u001c8o\u0005\u0003Wm\u0006\u0015\u0005#B<\u0002*\u0005uE\u0003BB\n\u0007+\u00012!!\u0002W\u0011!\ti\u000e\u0017CA\u0002\r=\u0011\u0001\u0002=%cI\u0002ra^A&\u0003'\u0019Y\u0002E\u0003x\u0003#\ni*\u0001\u0004uQJ,\u0017\rZ\u0001\u0006m\u0006dW/\u001a\u0002\u000e'&l\u0007\u000f\\3Qe>\u001cWm]:\u0014\t}3\u0018QQ\u0001\u0002aB!!qPB\u0015\u0013\u0011\u0019YC!#\u0003\u0011)\u0003&o\\2fgN\f1\"\u001b8qkR$\u0006N]3bI\u0006iq.\u001e;qkR$\u0006N]3bIN\u0004baa\r\u0004:\u0005MabA<\u00046%\u00191qG:\u0002\u000fA\f7m[1hK&!11HB\u001f\u0005\u0011a\u0015n\u001d;\u000b\u0007\r]2\u000f\u0006\u0005\u0004B\r\r3QIB$!\r\t)a\u0018\u0005\b\u0007K\u0019\u0007\u0019AB\u0014\u0011\u001d\u0019ic\u0019a\u0001\u0003'Aqaa\fd\u0001\u0004\u0019\tDA\u0007UQJ,\u0017\r\u001a)s_\u000e,7o]\n\u0005OZ\f))A\u0004tk\u000e\u001cWm]:\u0011\r\t}4\u0011KA\u001b\u0013\u0011\u0019\u0019F!#\u0003\u000fMKhn\u0019,beR11qKB-\u00077\u00022!!\u0002h\u0011\u001d\u0019iB\u001ba\u0001\u0003'Aqa!\u0014k\u0001\u0004\u0019yE\u0004\u0003\u0002\b\u000e}\u0013bAB1_\u00069\u0001K]8dKN\u001c\b")
public interface ProcessImpl {
    public ProcessImpl$Spawn$ Spawn();

    public ProcessImpl$Future$ Future();

    public static void $init$(ProcessImpl $this) {
    }

    public class AndProcess
    extends SequentialProcess {
        public /* synthetic */ Process$ scala$sys$process$ProcessImpl$AndProcess$$$outer() {
            return this.$outer;
        }

        public AndProcess(Process$ $outer, ProcessBuilder a, ProcessBuilder b, ProcessIO io) {
            super($outer, a, b, io, (Function1<Object, Object>)((Object)new Serializable(null){
                public static final long serialVersionUID = 0L;

                public final boolean apply(int x$1) {
                    return this.apply$mcZI$sp(x$1);
                }

                public boolean apply$mcZI$sp(int x$1) {
                    return x$1 == 0;
                }
            }));
        }
    }

    public static abstract class BasicProcess
    implements Process {
        public final /* synthetic */ Process$ $outer;

        public abstract void start();

        public /* synthetic */ Process$ scala$sys$process$ProcessImpl$BasicProcess$$$outer() {
            return this.$outer;
        }

        public BasicProcess(Process$ $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public abstract class CompoundProcess
    extends BasicProcess {
        private Tuple4<Thread, Thread, Function0<Option<Object>>, Function0<BoxedUnit>> x$4;
        private Thread processThread;
        private Thread futureThread;
        private Function0<Option<Object>> futureValue;
        private Function0<BoxedUnit> destroyer;
        private volatile byte bitmap$0;

        @Override
        public boolean isAlive() {
            return this.processThread().isAlive();
        }

        @Override
        public void destroy() {
            this.destroyer().apply$mcV$sp();
        }

        @Override
        public int exitValue() {
            Option<Object> option = this.futureValue().apply();
            if (option == null) {
                throw null;
            }
            Option<Object> getOrElse_this = option;
            if (getOrElse_this.isEmpty()) {
                throw package$.MODULE$.error("No exit code: process destroyed.");
            }
            return BoxesRunTime.unboxToInt(getOrElse_this.get());
        }

        @Override
        public void start() {
            this.futureThread();
        }

        /*
         * WARNING - void declaration
         */
        private Tuple4<Thread, Thread, Function0<Option<Object>>, Function0<BoxedUnit>> x$4$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 1) == 0) {
                    void var11_4;
                    void apply_f;
                    SyncVar code = new SyncVar();
                    JFunction0$mcV$sp & Serializable intersect = (JFunction0$mcV$sp & Serializable)() -> {
                        Option value = None$.MODULE$;
                        try {
                            value = this.runAndExitValue();
                        }
                        finally {
                            code.put(value);
                        }
                    };
                    if (this.scala$sys$process$ProcessImpl$CompoundProcess$$$outer().Spawn() == null) {
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
                    JFunction0$mcV$sp & Serializable intersect2 = () -> CompoundProcess.$anonfun$x$4$3((Thread)var11_4);
                    Tuple2 tuple2 = this.scala$sys$process$ProcessImpl$CompoundProcess$$$outer().Future().apply((Function0<Option> & java.io.Serializable & Serializable)() -> (Option)code.get());
                    Tuple3 tuple3 = new Tuple3(var11_4, tuple2, intersect2);
                    void processThread = var11_4;
                    Tuple2 tuple22 = tuple2;
                    JFunction0$mcV$sp & Serializable destroyer = intersect2;
                    if (tuple22 == null) {
                        throw new MatchError(tuple3);
                    }
                    Thread futureThread = tuple22._1();
                    Function0 futureValue = tuple22._2();
                    Tuple4 tuple4 = new Tuple4(processThread, futureThread, futureValue, destroyer);
                    this.x$4 = tuple4;
                    this.bitmap$0 = (byte)(this.bitmap$0 | 1);
                }
            }
            return this.x$4;
        }

        private /* synthetic */ Tuple4 x$4() {
            if ((byte)(this.bitmap$0 & 1) == 0) {
                return this.x$4$lzycompute();
            }
            return this.x$4;
        }

        private Thread processThread$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 2) == 0) {
                    this.processThread = (Thread)this.x$4()._1();
                    this.bitmap$0 = (byte)(this.bitmap$0 | 2);
                }
            }
            return this.processThread;
        }

        public Thread processThread() {
            if ((byte)(this.bitmap$0 & 2) == 0) {
                return this.processThread$lzycompute();
            }
            return this.processThread;
        }

        private Thread futureThread$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 4) == 0) {
                    this.futureThread = (Thread)this.x$4()._2();
                    this.bitmap$0 = (byte)(this.bitmap$0 | 4);
                }
            }
            return this.futureThread;
        }

        public Thread futureThread() {
            if ((byte)(this.bitmap$0 & 4) == 0) {
                return this.futureThread$lzycompute();
            }
            return this.futureThread;
        }

        private Function0<Option<Object>> futureValue$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 8) == 0) {
                    this.futureValue = (Function0)this.x$4()._3();
                    this.bitmap$0 = (byte)(this.bitmap$0 | 8);
                }
            }
            return this.futureValue;
        }

        public Function0<Option<Object>> futureValue() {
            if ((byte)(this.bitmap$0 & 8) == 0) {
                return this.futureValue$lzycompute();
            }
            return this.futureValue;
        }

        private Function0<BoxedUnit> destroyer$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 0x10) == 0) {
                    this.destroyer = (Function0)this.x$4()._4();
                    this.bitmap$0 = (byte)(this.bitmap$0 | 0x10);
                }
            }
            return this.destroyer;
        }

        public Function0<BoxedUnit> destroyer() {
            if ((byte)(this.bitmap$0 & 0x10) == 0) {
                return this.destroyer$lzycompute();
            }
            return this.destroyer;
        }

        public abstract Option<Object> runAndExitValue();

        /*
         * WARNING - void declaration
         */
        public <T> Option<T> runInterruptible(Function0<T> action, Function0<BoxedUnit> destroyImpl) {
            try {
                return new Some<T>(action.apply());
            }
            catch (Throwable x$5) {
                void onInterrupt_handler;
                Function0<None$> & java.io.Serializable & Serializable intersect = (Function0<None$> & java.io.Serializable & Serializable)() -> {
                    destroyImpl.apply$mcV$sp();
                    return None$.MODULE$;
                };
                if (processInternal$.MODULE$ == null) {
                    throw null;
                }
                Serializable serializable = new Serializable((Function0)onInterrupt_handler){
                    public static final long serialVersionUID = 0L;
                    private final Function0 handler$3;

                    public final <A1 extends Throwable, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                        Object object = x1 instanceof InterruptedException ? this.handler$3.apply() : function1.apply(x1);
                        return (B1)object;
                    }

                    public final boolean isDefinedAt(Throwable x1) {
                        boolean bl = x1 instanceof InterruptedException;
                        return bl;
                    }
                    {
                        this.handler$3 = handler$3;
                    }
                };
                if (serializable.isDefinedAt(x$5)) {
                    return (Option)serializable.apply(x$5);
                }
                throw x$5;
            }
        }

        public /* synthetic */ Process$ scala$sys$process$ProcessImpl$CompoundProcess$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ void $anonfun$x$4$3(Thread thread$1) {
            thread$1.interrupt();
        }

        public CompoundProcess(Process$ $outer) {
            super($outer);
        }
    }

    public static class DummyProcess
    implements Process {
        private final /* synthetic */ Tuple2 x$12;
        private final Thread thread;
        private final Function0<Object> value;
        public final /* synthetic */ Process$ $outer;

        @Override
        public boolean isAlive() {
            return this.thread.isAlive();
        }

        @Override
        public int exitValue() {
            return this.value.apply$mcI$sp();
        }

        @Override
        public void destroy() {
        }

        public /* synthetic */ Process$ scala$sys$process$ProcessImpl$DummyProcess$$$outer() {
            return this.$outer;
        }

        public DummyProcess(Process$ $outer, Function0<Object> action) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Tuple2<Thread, Function0<Object>> tuple2 = $outer.Future().apply(action);
            if (tuple2 == null) {
                throw new MatchError((Object)null);
            }
            Thread thread2 = tuple2._1();
            Function0<Object> value = tuple2._2();
            Tuple2<Thread, Function0<Object>> tuple22 = new Tuple2<Thread, Function0<Object>>(thread2, value);
            this.x$12 = tuple22;
            this.thread = (Thread)this.x$12._1();
            this.value = (Function0)this.x$12._2();
        }
    }

    public class OrProcess
    extends SequentialProcess {
        public /* synthetic */ Process$ scala$sys$process$ProcessImpl$OrProcess$$$outer() {
            return this.$outer;
        }

        public OrProcess(Process$ $outer, ProcessBuilder a, ProcessBuilder b, ProcessIO io) {
            super($outer, a, b, io, (Function1<Object, Object>)((Object)new Serializable(null){
                public static final long serialVersionUID = 0L;

                public final boolean apply(int x$2) {
                    return this.apply$mcZI$sp(x$2);
                }

                public boolean apply$mcZI$sp(int x$2) {
                    return x$2 != 0;
                }
            }));
        }
    }

    public class PipeSink
    extends PipeThread {
        private final PipedInputStream pipe = new PipedInputStream();
        private final LinkedBlockingQueue<Option<OutputStream>> sink = new LinkedBlockingQueue();

        public PipedInputStream pipe() {
            return this.pipe;
        }

        public LinkedBlockingQueue<Option<OutputStream>> sink() {
            return this.sink;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public void run() {
            block10: {
                try {
                    try {
                        Option<OutputStream> option = this.sink().take();
                        if (option instanceof Some) {
                            OutputStream out = (OutputStream)((Some)option).value();
                            this.runloop(this.pipe(), out);
                        } else if (!None$.MODULE$.equals(option)) {
                            throw new MatchError(option);
                        }
                    }
                    catch (Throwable x$11) {
                        void onInterrupt_handler;
                        JFunction0$mcV$sp & Serializable intersect = (JFunction0$mcV$sp & Serializable)() -> {};
                        if (processInternal$.MODULE$ == null) {
                            throw null;
                        }
                        Serializable serializable = new /* invalid duplicate definition of identical inner class */;
                        if (serializable.isDefinedAt(x$11)) {
                            serializable.apply(x$11);
                            break block10;
                        }
                        throw x$11;
                    }
                }
                finally {
                    BasicIO$.MODULE$.close(this.pipe());
                }
            }
        }

        public void connectOut(OutputStream out) {
            this.sink().add(new Some<OutputStream>(out));
        }

        public void connectIn(PipedOutputStream pipeOut) {
            this.pipe().connect(pipeOut);
        }

        public void release() {
            this.interrupt();
            this.sink().add(None$.MODULE$);
            this.join();
        }

        public /* synthetic */ Process$ scala$sys$process$ProcessImpl$PipeSink$$$outer() {
            return this.$outer;
        }

        public PipeSink(Process$ $outer, Function0<String> label) {
            super($outer, true, label);
        }
    }

    public class PipeSource
    extends PipeThread {
        private final PipedOutputStream pipe = new PipedOutputStream();
        private final LinkedBlockingQueue<Option<InputStream>> source = new LinkedBlockingQueue();

        public PipedOutputStream pipe() {
            return this.pipe;
        }

        public LinkedBlockingQueue<Option<InputStream>> source() {
            return this.source;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public void run() {
            block10: {
                try {
                    try {
                        Option<InputStream> option = this.source().take();
                        if (option instanceof Some) {
                            InputStream in = (InputStream)((Some)option).value();
                            this.runloop(in, this.pipe());
                        } else if (!None$.MODULE$.equals(option)) {
                            throw new MatchError(option);
                        }
                    }
                    catch (Throwable x$10) {
                        void onInterrupt_handler;
                        JFunction0$mcV$sp & Serializable intersect = (JFunction0$mcV$sp & Serializable)() -> {};
                        if (processInternal$.MODULE$ == null) {
                            throw null;
                        }
                        Serializable serializable = new /* invalid duplicate definition of identical inner class */;
                        if (serializable.isDefinedAt(x$10)) {
                            serializable.apply(x$10);
                            break block10;
                        }
                        throw x$10;
                    }
                }
                finally {
                    BasicIO$.MODULE$.close(this.pipe());
                }
            }
        }

        public void connectIn(InputStream in) {
            this.source().add(new Some<InputStream>(in));
        }

        public void connectOut(PipeSink sink2) {
            sink2.connectIn(this.pipe());
        }

        public void release() {
            this.interrupt();
            this.source().add(None$.MODULE$);
            this.join();
        }

        public /* synthetic */ Process$ scala$sys$process$ProcessImpl$PipeSource$$$outer() {
            return this.$outer;
        }

        public PipeSource(Process$ $outer, Function0<String> label) {
            super($outer, false, label);
        }
    }

    public abstract class PipeThread
    extends Thread {
        private final boolean isSink;
        private final Function0<String> labelFn;
        public final /* synthetic */ Process$ $outer;

        @Override
        public abstract void run();

        /*
         * WARNING - void declaration
         */
        public void runloop(InputStream src, OutputStream dst) {
            block6: {
                try {
                    try {
                        BasicIO$.MODULE$.transferFully(src, dst);
                    }
                    catch (Throwable x$9) {
                        void ioFailure_handler;
                        Function1<IOException, Object> & java.io.Serializable & Serializable intersect = (Function1<IOException, Object> & java.io.Serializable & Serializable)e -> {
                            this.ioHandler(e);
                            return BoxedUnit.UNIT;
                        };
                        if (processInternal$.MODULE$ == null) {
                            throw null;
                        }
                        Serializable serializable = new Serializable((Function1)ioFailure_handler){
                            public static final long serialVersionUID = 0L;
                            private final Function1 handler$4;

                            public final <A1 extends Throwable, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                                Object object;
                                if (x1 instanceof IOException) {
                                    IOException iOException = (IOException)x1;
                                    object = this.handler$4.apply(iOException);
                                } else {
                                    object = function1.apply(x1);
                                }
                                return object;
                            }

                            public final boolean isDefinedAt(Throwable x1) {
                                boolean bl = x1 instanceof IOException;
                                return bl;
                            }
                            {
                                this.handler$4 = handler$4;
                            }
                        };
                        if (serializable.isDefinedAt(x$9)) {
                            serializable.apply(x$9);
                            break block6;
                        }
                        throw x$9;
                    }
                }
                catch (Throwable throwable) {
                    BasicIO$.MODULE$.close(this.isSink ? dst : src);
                    throw throwable;
                }
            }
            BasicIO$.MODULE$.close(this.isSink ? dst : src);
        }

        private void ioHandler(IOException e) {
            Predef$.MODULE$.println(new StringBuilder(24).append("I/O error ").append(e.getMessage()).append(" for process: ").append((Object)this.labelFn.apply()).toString());
            e.printStackTrace();
        }

        public /* synthetic */ Process$ scala$sys$process$ProcessImpl$PipeThread$$$outer() {
            return this.$outer;
        }

        public PipeThread(Process$ $outer, boolean isSink, Function0<String> labelFn) {
            this.isSink = isSink;
            this.labelFn = labelFn;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public class PipedProcesses
    extends CompoundProcess {
        private final ProcessBuilder a;
        private final ProcessBuilder b;
        private final ProcessIO defaultIO;
        private final boolean toError;

        @Override
        public Option<Object> runAndExitValue() {
            return this.runAndExitValue(new PipeSource(this.scala$sys$process$ProcessImpl$PipedProcesses$$$outer(), (Function0<String> & java.io.Serializable & Serializable)() -> $this.a.toString()), new PipeSink(this.scala$sys$process$ProcessImpl$PipedProcesses$$$outer(), (Function0<String> & java.io.Serializable & Serializable)() -> $this.b.toString()));
        }

        /*
         * WARNING - void declaration
         */
        public Option<Object> runAndExitValue(PipeSource source2, PipeSink sink2) {
            Process process;
            Process process2;
            void withInput_write;
            ProcessIO processIO;
            source2.connectOut(sink2);
            source2.start();
            sink2.start();
            if (this.toError) {
                void withError_process;
                ProcessIO processIO2 = this.defaultIO;
                Function1<InputStream, Object> & java.io.Serializable & Serializable intersect = (Function1<InputStream, Object> & java.io.Serializable & Serializable)in -> {
                    source2.connectIn(in);
                    return BoxedUnit.UNIT;
                };
                if (processIO2 == null) {
                    throw null;
                }
                ProcessIO withError_this = processIO2;
                processIO = new ProcessIO(withError_this.writeInput(), withError_this.processOutput(), (Function1<InputStream, BoxedUnit>)withError_process, withError_this.daemonizeThreads());
            } else {
                void withOutput_process;
                ProcessIO processIO3 = this.defaultIO;
                Function1<InputStream, Object> & java.io.Serializable & Serializable intersect = (Function1<InputStream, Object> & java.io.Serializable & Serializable)in -> {
                    source2.connectIn(in);
                    return BoxedUnit.UNIT;
                };
                if (processIO3 == null) {
                    throw null;
                }
                ProcessIO withOutput_this = processIO3;
                processIO = new ProcessIO(withOutput_this.writeInput(), (Function1<InputStream, BoxedUnit>)withOutput_process, withOutput_this.processError(), withOutput_this.daemonizeThreads());
            }
            ProcessIO firstIO = processIO;
            ProcessIO processIO4 = this.defaultIO;
            Function1<OutputStream, Object> & java.io.Serializable & Serializable intersect = (Function1<OutputStream, Object> & java.io.Serializable & Serializable)out -> {
                sink2.connectOut(out);
                return BoxedUnit.UNIT;
            };
            if (processIO4 == null) {
                throw null;
            }
            ProcessIO withInput_this = processIO4;
            ProcessIO processIO5 = new ProcessIO((Function1<OutputStream, BoxedUnit>)withInput_write, withInput_this.processOutput(), withInput_this.processError(), withInput_this.daemonizeThreads());
            try {
                process2 = this.b.run(processIO5);
            }
            catch (Throwable x$7) {
                void onError_handler;
                Function1<Throwable, Nothing$> & java.io.Serializable & Serializable intersect2 = (Function1<Throwable, Nothing$> & java.io.Serializable & Serializable)err -> {
                    PipedProcesses.releaseResources$1(source2, sink2, Predef$.MODULE$.wrapRefArray((Object[])new Process[0]));
                    throw err;
                };
                if (processInternal$.MODULE$ == null) {
                    throw null;
                }
                Serializable serializable = new Serializable((Function1)onError_handler){
                    public static final long serialVersionUID = 0L;
                    private final Function1 handler$1;

                    public final <A1 extends Throwable, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                        return (B1)this.handler$1.apply(x1);
                    }

                    public final boolean isDefinedAt(Throwable x1) {
                        return true;
                    }
                    {
                        this.handler$1 = handler$1;
                    }
                };
                if (serializable.isDefinedAt(x$7)) {
                    process2 = (Process)serializable.apply(x$7);
                }
                throw x$7;
            }
            Process second = process2;
            try {
                process = this.a.run(firstIO);
            }
            catch (Throwable x$8) {
                void onError_handler;
                Function1<Throwable, Nothing$> & java.io.Serializable & Serializable intersect3 = (Function1<Throwable, Nothing$> & java.io.Serializable & Serializable)err -> {
                    PipedProcesses.releaseResources$1(source2, sink2, Predef$.MODULE$.wrapRefArray((Object[])new Process[]{second}));
                    throw err;
                };
                if (processInternal$.MODULE$ == null) {
                    throw null;
                }
                Serializable serializable = new /* invalid duplicate definition of identical inner class */;
                if (serializable.isDefinedAt(x$8)) {
                    process = (Process)serializable.apply(x$8);
                }
                throw x$8;
            }
            Process first = process;
            return this.runInterruptible((JFunction0$mcI$sp & Serializable)() -> {
                source2.join();
                int exit1 = first.exitValue();
                int exit2 = second.exitValue();
                if ($this.b.hasExitValue()) {
                    return exit2;
                }
                return exit1;
            }, (JFunction0$mcV$sp & Serializable)() -> PipedProcesses.releaseResources$1(source2, sink2, Predef$.MODULE$.wrapRefArray((Object[])new Process[]{first, second})));
        }

        public /* synthetic */ Process$ scala$sys$process$ProcessImpl$PipedProcesses$$$outer() {
            return this.$outer;
        }

        private static final void releaseResources$1(PipeSource so, PipeSink sk, Seq p) {
            so.release();
            sk.release();
            p.foreach((Function1<Process, Object> & java.io.Serializable & Serializable)x$6 -> {
                x$6.destroy();
                return BoxedUnit.UNIT;
            });
        }

        public PipedProcesses(Process$ $outer, ProcessBuilder a, ProcessBuilder b, ProcessIO defaultIO, boolean toError) {
            this.a = a;
            this.b = b;
            this.defaultIO = defaultIO;
            this.toError = toError;
            super($outer);
        }
    }

    public class ProcessSequence
    extends SequentialProcess {
        public /* synthetic */ Process$ scala$sys$process$ProcessImpl$ProcessSequence$$$outer() {
            return this.$outer;
        }

        public ProcessSequence(Process$ $outer, ProcessBuilder a, ProcessBuilder b, ProcessIO io) {
            super($outer, a, b, io, (Function1<Object, Object>)((Object)new Serializable(null){
                public static final long serialVersionUID = 0L;

                public final boolean apply(int x$3) {
                    return this.apply$mcZI$sp(x$3);
                }

                public boolean apply$mcZI$sp(int x$3) {
                    return true;
                }
            }));
        }
    }

    public class SequentialProcess
    extends CompoundProcess {
        private final ProcessBuilder a;
        private final ProcessBuilder b;
        private final ProcessIO io;
        private final Function1<Object, Object> evaluateSecondProcess;

        @Override
        public Option<Object> runAndExitValue() {
            Process first = this.a.run(this.io);
            Option option = this.runInterruptible((JFunction0$mcI$sp & Serializable)() -> first.exitValue(), (JFunction0$mcV$sp & Serializable)() -> first.destroy());
            if (option == null) {
                throw null;
            }
            Option flatMap_this = option;
            if (flatMap_this.isEmpty()) {
                return None$.MODULE$;
            }
            Object t = flatMap_this.get();
            return SequentialProcess.$anonfun$runAndExitValue$3(this, BoxesRunTime.unboxToInt(t));
        }

        public /* synthetic */ Process$ scala$sys$process$ProcessImpl$SequentialProcess$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ Option $anonfun$runAndExitValue$3(SequentialProcess $this, int codeA) {
            if ($this.evaluateSecondProcess.apply$mcZI$sp(codeA)) {
                Process second = $this.b.run($this.io);
                return $this.runInterruptible((JFunction0$mcI$sp & Serializable)() -> second.exitValue(), (JFunction0$mcV$sp & Serializable)() -> second.destroy());
            }
            return new Some<Integer>(BoxesRunTime.boxToInteger(codeA));
        }

        public SequentialProcess(Process$ $outer, ProcessBuilder a, ProcessBuilder b, ProcessIO io, Function1<Object, Object> evaluateSecondProcess) {
            this.a = a;
            this.b = b;
            this.io = io;
            this.evaluateSecondProcess = evaluateSecondProcess;
            super($outer);
        }
    }

    public class SimpleProcess
    implements Process {
        private final java.lang.Process p;
        private final Thread inputThread;
        private final List<Thread> outputThreads;
        public final /* synthetic */ Process$ $outer;

        @Override
        public boolean isAlive() {
            return this.p.isAlive();
        }

        @Override
        public int exitValue() {
            try {
                this.p.waitFor();
            }
            finally {
                this.inputThread.interrupt();
            }
            List list = this.outputThreads;
            if (list == null) {
                throw null;
            }
            List foreach_these = list;
            while (!foreach_these.isEmpty()) {
                SimpleProcess.$anonfun$exitValue$2$adapted(foreach_these.head());
                foreach_these = (List)foreach_these.tail();
            }
            return this.p.exitValue();
        }

        @Override
        public void destroy() {
            try {
                List list = this.outputThreads;
                if (list == null) {
                    throw null;
                }
                List foreach_these = list;
                while (!foreach_these.isEmpty()) {
                    SimpleProcess.$anonfun$destroy$1$adapted(foreach_these.head());
                    foreach_these = (List)foreach_these.tail();
                }
                this.p.destroy();
            }
            finally {
                this.inputThread.interrupt();
            }
        }

        public /* synthetic */ Process$ scala$sys$process$ProcessImpl$SimpleProcess$$$outer() {
            return this.$outer;
        }

        public SimpleProcess(Process$ $outer, java.lang.Process p, Thread inputThread, List<Thread> outputThreads) {
            this.p = p;
            this.inputThread = inputThread;
            this.outputThreads = outputThreads;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }

        public static final /* synthetic */ Object $anonfun$exitValue$2$adapted(Thread x$13) {
            x$13.join();
            return BoxedUnit.UNIT;
        }

        public static final /* synthetic */ Object $anonfun$destroy$1$adapted(Thread x$14) {
            x$14.interrupt();
            return BoxedUnit.UNIT;
        }
    }

    public final class ThreadProcess
    implements Process {
        private final Thread thread;
        private final SyncVar<Object> success;

        @Override
        public boolean isAlive() {
            return this.thread.isAlive();
        }

        @Override
        public int exitValue() {
            if (BoxesRunTime.unboxToBoolean(this.success.get())) {
                return 0;
            }
            return 1;
        }

        @Override
        public void destroy() {
            this.thread.interrupt();
        }

        public ThreadProcess(Process$ $outer, Thread thread2, SyncVar<Object> success) {
            this.thread = thread2;
            this.success = success;
        }
    }
}

