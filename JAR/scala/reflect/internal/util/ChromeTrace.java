/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import java.io.Closeable;
import java.lang.management.ManagementFactory;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;
import scala.Predef$;
import scala.Predef$StringFormat$;
import scala.Product;
import scala.Serializable;
import scala.collection.Iterator;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayStack;
import scala.collection.mutable.ArrayStack$;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.util.ChromeTrace$ArrayContext$;
import scala.reflect.internal.util.ChromeTrace$ObjectContext$;
import scala.reflect.internal.util.ChromeTrace$TopContext$;
import scala.reflect.internal.util.ChromeTrace$ValueContext$;
import scala.reflect.internal.util.FileUtils;
import scala.reflect.internal.util.FileUtils$;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import scala.runtime.Statics;

@ScalaSignature(bytes="\u0006\u0001\rewA\u0002>|\u0011\u0003\tIAB\u0004\u0002\u000emD\t!a\u0004\t\u000f\u0005e\u0011\u0001\"\u0001\u0002\u001c\u001d9\u0011QD\u0001\t\n\u0005}aaBA\u0012\u0003!%\u0011Q\u0005\u0005\b\u00033!A\u0011AA\u0014\u0011%\tI\u0003\u0002b\u0001\n\u000b\tY\u0003\u0003\u0005\u00024\u0011\u0001\u000bQBA\u0017\u0011%\t)\u0004\u0002b\u0001\n\u000b\t9\u0004\u0003\u0005\u0002@\u0011\u0001\u000bQBA\u001d\u0011%\t\t\u0005\u0002b\u0001\n\u000b\t\u0019\u0005\u0003\u0005\u0002L\u0011\u0001\u000bQBA#\u0011%\ti\u0005\u0002b\u0001\n\u000b\ty\u0005\u0003\u0005\u0002X\u0011\u0001\u000bQBA)\u0011%\tI\u0006\u0002b\u0001\n\u000b\tY\u0006\u0003\u0005\u0002d\u0011\u0001\u000bQBA/\u0011%\t)\u0007\u0002b\u0001\n\u000b\t9\u0007\u0003\u0005\u0002p\u0011\u0001\u000bQBA5\u0011%\t\t\b\u0002b\u0001\n\u000b\t\u0019\b\u0003\u0005\u0002|\u0011\u0001\u000bQBA;\u0011%\ti\b\u0002b\u0001\n\u000b\ty\b\u0003\u0005\u0002\b\u0012\u0001\u000bQBAA\r\u0019\tia\u001f\u0002\u0002\n\"Q\u0011q\u0015\f\u0003\u0002\u0003\u0006I!!+\t\u000f\u0005ea\u0003\"\u0001\u0002:\"I\u0011q\u0018\fC\u0002\u0013%\u0011\u0011\u0019\u0005\t\u0003#4\u0002\u0015!\u0003\u0002D\"I\u00111\u001b\fC\u0002\u0013%\u0011Q\u001b\u0005\t\u0005\u007f3\u0002\u0015!\u0003\u0002X\"I!\u0011\u0019\fC\u0002\u0013%!1\u0019\u0005\t\u0005?4\u0002\u0015!\u0003\u0003F\"I!\u0011\u001d\fC\u0002\u0013%!1\t\u0005\t\u0005G4\u0002\u0015!\u0003\u0003F!9!Q\u001d\f\u0005B\t\u001d\bb\u0002Bu-\u0011\u0005!1\u001e\u0005\n\u0007\u000f1\u0012\u0013!C\u0001\u0007\u0013A\u0011b!\u0004\u0017#\u0003%\ta!\u0003\t\u000f\r=a\u0003\"\u0003\u0004\u0012!91Q\u0003\f\u0005\u0002\r]\u0001bBB\u0014-\u0011\u00051\u0011\u0006\u0005\n\u0007o1\u0012\u0013!C\u0001\u0007\u0013A\u0011b!\u000f\u0017#\u0003%\ta!\u0003\t\u000f\rmb\u0003\"\u0001\u0004>!I1q\t\f\u0012\u0002\u0013\u00051\u0011\u0002\u0005\n\u0007\u00132\u0012\u0013!C\u0001\u0007\u0013Aqaa\u0013\u0017\t\u0013\u0019i\u0005C\u0005\u0004\\Y\t\n\u0011\"\u0003\u0004\n!91\u0011\u0001\f\u0005\n\ru\u0003bBB0-\u0011%1\u0011\r\u0005\b\u0007O2B\u0011BB5\r\u001d\tYOFA\u0011\u0003[Dq!!\u00073\t\u0003\tyO\u0002\u0004\u0002tZ\u0001\u0015Q\u001f\u0005\u000b\u0005\u0007!$\u00113A\u0005\u0002\t\u0015\u0001B\u0003B\u0007i\t\u0005\r\u0011\"\u0001\u0003\u0010!Q!1\u0004\u001b\u0003\u0012\u0003\u0006KAa\u0002\t\u000f\u0005eA\u0007\"\u0001\u0003\u001e!I!1\u0005\u001b\u0002\u0002\u0013\u0005!Q\u0005\u0005\n\u0005S!\u0014\u0013!C\u0001\u0005WA\u0011B!\u00115\u0003\u0003%\tEa\u0011\t\u0013\t-C'!A\u0005\u0002\t5\u0003\"\u0003B+i\u0005\u0005I\u0011\u0001B,\u0011%\u0011\t\u0007NA\u0001\n\u0003\u0012\u0019\u0007C\u0005\u0003nQ\n\t\u0011\"\u0001\u0003p!I!1\u000f\u001b\u0002\u0002\u0013\u0005#Q\u000f\u0005\n\u0005o\"\u0014\u0011!C!\u0005sB\u0011Ba\u001f5\u0003\u0003%\tE! \b\u0013\r-d#!A\t\u0002\r5d!CAz-\u0005\u0005\t\u0012AB8\u0011\u001d\tI\u0002\u0012C\u0001\u0007{B\u0011Ba\u001eE\u0003\u0003%)E!\u001f\t\u0013\r}D)!A\u0005\u0002\u000e\u0005\u0005\"CBC\t\u0006\u0005I\u0011QBD\r\u0019\u0011\tI\u0006!\u0003\u0004\"Q!1A%\u0003\u0012\u0004%\tA!\u0002\t\u0015\t5\u0011J!a\u0001\n\u0003\u0011)\t\u0003\u0006\u0003\u001c%\u0013\t\u0012)Q\u0005\u0005\u000fAq!!\u0007J\t\u0003\u0011I\tC\u0005\u0003$%\u000b\t\u0011\"\u0001\u0003\u0010\"I!\u0011F%\u0012\u0002\u0013\u0005!1\u0006\u0005\n\u0005\u0003J\u0015\u0011!C!\u0005\u0007B\u0011Ba\u0013J\u0003\u0003%\tA!\u0014\t\u0013\tU\u0013*!A\u0005\u0002\tM\u0005\"\u0003B1\u0013\u0006\u0005I\u0011\tB2\u0011%\u0011i'SA\u0001\n\u0003\u00119\nC\u0005\u0003t%\u000b\t\u0011\"\u0011\u0003v!I!qO%\u0002\u0002\u0013\u0005#\u0011\u0010\u0005\n\u0005wJ\u0015\u0011!C!\u00057;\u0011ba%\u0017\u0003\u0003E\ta!&\u0007\u0013\t\u0005e#!A\t\u0002\r]\u0005bBA\r3\u0012\u000511\u0014\u0005\n\u0005oJ\u0016\u0011!C#\u0005sB\u0011ba Z\u0003\u0003%\ti!(\t\u0013\r\u0015\u0015,!A\u0005\u0002\u000e\u0005vaBBS-!\u0005%Q\u0017\u0004\b\u0005_3\u0002\u0012\u0011BY\u0011\u001d\tIb\u0018C\u0001\u0005gC\u0011B!\u0011`\u0003\u0003%\tEa\u0011\t\u0013\t-s,!A\u0005\u0002\t5\u0003\"\u0003B+?\u0006\u0005I\u0011\u0001B\\\u0011%\u0011\tgXA\u0001\n\u0003\u0012\u0019\u0007C\u0005\u0003n}\u000b\t\u0011\"\u0001\u0003<\"I!1O0\u0002\u0002\u0013\u0005#Q\u000f\u0005\n\u0005oz\u0016\u0011!C!\u0005s:qaa*\u0017\u0011\u0003\u0013)KB\u0004\u0003 ZA\tI!)\t\u000f\u0005e\u0011\u000e\"\u0001\u0003$\"I!\u0011I5\u0002\u0002\u0013\u0005#1\t\u0005\n\u0005\u0017J\u0017\u0011!C\u0001\u0005\u001bB\u0011B!\u0016j\u0003\u0003%\tAa*\t\u0013\t\u0005\u0014.!A\u0005B\t\r\u0004\"\u0003B7S\u0006\u0005I\u0011\u0001BV\u0011%\u0011\u0019([A\u0001\n\u0003\u0012)\bC\u0005\u0003x%\f\t\u0011\"\u0011\u0003z!91\u0011\u0016\f\u0005\n\r-\u0006bBBZ-\u0011%1Q\u0017\u0005\b\u0007\u00074B\u0011BBc\u0011\u001d\u0019YM\u0006C\u0005\u0005ODqa!4\u0017\t\u0013\u00119\u000fC\u0004\u0004PZ!IAa:\t\u000f\rEg\u0003\"\u0003\u0003h\"911\u001b\f\u0005\n\rU\u0017aC\"ie>lW\r\u0016:bG\u0016T!\u0001`?\u0002\tU$\u0018\u000e\u001c\u0006\u0003}~\f\u0001\"\u001b8uKJt\u0017\r\u001c\u0006\u0005\u0003\u0003\t\u0019!A\u0004sK\u001adWm\u0019;\u000b\u0005\u0005\u0015\u0011!B:dC2\f7\u0001\u0001\t\u0004\u0003\u0017\tQ\"A>\u0003\u0017\rC'o\\7f)J\f7-Z\n\u0004\u0003\u0005E\u0001\u0003BA\n\u0003+i!!a\u0001\n\t\u0005]\u00111\u0001\u0002\u0007\u0003:L(+\u001a4\u0002\rqJg.\u001b;?)\t\tI!A\u0005Fm\u0016tG\u000fV=qKB\u0019\u0011\u0011\u0005\u0003\u000e\u0003\u0005\u0011\u0011\"\u0012<f]R$\u0016\u0010]3\u0014\u0007\u0011\t\t\u0002\u0006\u0002\u0002 \u0005)1\u000b^1siV\u0011\u0011QF\b\u0003\u0003_\t#!!\r\u0002\u0003\t\u000baa\u0015;beR\u0004\u0013aB%ogR\fg\u000e^\u000b\u0003\u0003sy!!a\u000f\"\u0005\u0005u\u0012!A%\u0002\u0011%s7\u000f^1oi\u0002\n1!\u00128e+\t\t)e\u0004\u0002\u0002H\u0005\u0012\u0011\u0011J\u0001\u0002\u000b\u0006!QI\u001c3!\u0003!\u0019u.\u001c9mKR,WCAA)\u001f\t\t\u0019&\t\u0002\u0002V\u0005\t\u0001,A\u0005D_6\u0004H.\u001a;fA\u000591i\\;oi\u0016\u0014XCAA/\u001f\t\ty&\t\u0002\u0002b\u0005\t1)\u0001\u0005D_VtG/\u001a:!\u0003)\t5/\u001f8d'R\f'\u000f^\u000b\u0003\u0003Sz!!a\u001b\"\u0005\u00055\u0014!\u00012\u0002\u0017\u0005\u001b\u0018P\\2Ti\u0006\u0014H\u000fI\u0001\r\u0003NLhnY%ogR\fg\u000e^\u000b\u0003\u0003kz!!a\u001e\"\u0005\u0005e\u0014!\u00018\u0002\u001b\u0005\u001b\u0018P\\2J]N$\u0018M\u001c;!\u0003!\t5/\u001f8d\u000b:$WCAAA\u001f\t\t\u0019)\t\u0002\u0002\u0006\u0006\tQ-A\u0005Bgft7-\u00128eAM)a#a#\u0002\u001cB!\u0011QRAL\u001b\t\tyI\u0003\u0003\u0002\u0012\u0006M\u0015\u0001\u00027b]\u001eT!!!&\u0002\t)\fg/Y\u0005\u0005\u00033\u000byI\u0001\u0004PE*,7\r\u001e\t\u0005\u0003;\u000b\u0019+\u0004\u0002\u0002 *!\u0011\u0011UAJ\u0003\tIw.\u0003\u0003\u0002&\u0006}%!C\"m_N,\u0017M\u00197f\u0003\u00051\u0007\u0003BAV\u0003kk!!!,\u000b\t\u0005=\u0016\u0011W\u0001\u0005M&dWM\u0003\u0003\u00024\u0006M\u0015a\u00018j_&!\u0011qWAW\u0005\u0011\u0001\u0016\r\u001e5\u0015\t\u0005m\u0016Q\u0018\t\u0004\u0003\u00171\u0002bBAT1\u0001\u0007\u0011\u0011V\u0001\fiJ\f7-Z,sSR,'/\u0006\u0002\u0002DB!\u0011QYAf\u001d\u0011\tY!a2\n\u0007\u0005%70A\u0005GS2,W\u000b^5mg&!\u0011QZAh\u0005)a\u0015N\\3Xe&$XM\u001d\u0006\u0004\u0003\u0013\\\u0018\u0001\u0004;sC\u000e,wK]5uKJ\u0004\u0013aB2p]R,\u0007\u0010^\u000b\u0003\u0003/\u0004b!!7\u0002d\u0006\u001dXBAAn\u0015\u0011\ti.a8\u0002\u000f5,H/\u00192mK*!\u0011\u0011]A\u0002\u0003)\u0019w\u000e\u001c7fGRLwN\\\u0005\u0005\u0003K\fYN\u0001\u0006BeJ\f\u0017p\u0015;bG.\u00042!!;3\u001b\u00051\"a\u0003&t_:\u001cuN\u001c;fqR\u001c2AMA\t)\t\t9/K\u00033i%KwL\u0001\u0007BeJ\f\u0017pQ8oi\u0016DHoE\u00045\u0003O\f90!@\u0011\t\u0005M\u0011\u0011`\u0005\u0005\u0003w\f\u0019AA\u0004Qe>$Wo\u0019;\u0011\t\u0005M\u0011q`\u0005\u0005\u0005\u0003\t\u0019A\u0001\u0007TKJL\u0017\r\\5{C\ndW-A\u0003gSJ\u001cH/\u0006\u0002\u0003\bA!\u00111\u0003B\u0005\u0013\u0011\u0011Y!a\u0001\u0003\u000f\t{w\u000e\\3b]\u0006Ia-\u001b:ti~#S-\u001d\u000b\u0005\u0005#\u00119\u0002\u0005\u0003\u0002\u0014\tM\u0011\u0002\u0002B\u000b\u0003\u0007\u0011A!\u00168ji\"I!\u0011\u0004\u001c\u0002\u0002\u0003\u0007!qA\u0001\u0004q\u0012\n\u0014A\u00024jeN$\b\u0005\u0006\u0003\u0003 \t\u0005\u0002cAAui!9!1\u0001\u001dA\u0002\t\u001d\u0011\u0001B2paf$BAa\b\u0003(!I!1A\u001d\u0011\u0002\u0003\u0007!qA\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00132+\t\u0011iC\u000b\u0003\u0003\b\t=2F\u0001B\u0019!\u0011\u0011\u0019D!\u0010\u000e\u0005\tU\"\u0002\u0002B\u001c\u0005s\t\u0011\"\u001e8dQ\u0016\u001c7.\u001a3\u000b\t\tm\u00121A\u0001\u000bC:tw\u000e^1uS>t\u0017\u0002\u0002B \u0005k\u0011\u0011#\u001e8dQ\u0016\u001c7.\u001a3WCJL\u0017M\\2f\u00035\u0001(o\u001c3vGR\u0004&/\u001a4jqV\u0011!Q\t\t\u0005\u0003\u001b\u00139%\u0003\u0003\u0003J\u0005=%AB*ue&tw-\u0001\u0007qe>$Wo\u0019;Be&$\u00180\u0006\u0002\u0003PA!\u00111\u0003B)\u0013\u0011\u0011\u0019&a\u0001\u0003\u0007%sG/\u0001\bqe>$Wo\u0019;FY\u0016lWM\u001c;\u0015\t\te#q\f\t\u0005\u0003'\u0011Y&\u0003\u0003\u0003^\u0005\r!aA!os\"I!\u0011D\u001f\u0002\u0002\u0003\u0007!qJ\u0001\u0010aJ|G-^2u\u0013R,'/\u0019;peV\u0011!Q\r\t\u0007\u0005O\u0012IG!\u0017\u000e\u0005\u0005}\u0017\u0002\u0002B6\u0003?\u0014\u0001\"\u0013;fe\u0006$xN]\u0001\tG\u0006tW)];bYR!!q\u0001B9\u0011%\u0011IbPA\u0001\u0002\u0004\u0011I&\u0001\u0005iCND7i\u001c3f)\t\u0011y%\u0001\u0005u_N#(/\u001b8h)\t\u0011)%\u0001\u0004fcV\fGn\u001d\u000b\u0005\u0005\u000f\u0011y\bC\u0005\u0003\u001a\t\u000b\t\u00111\u0001\u0003Z\tiqJ\u00196fGR\u001cuN\u001c;fqR\u001cr!SAt\u0003o\fi\u0010\u0006\u0003\u0003\u0012\t\u001d\u0005\"\u0003B\r\u0017\u0006\u0005\t\u0019\u0001B\u0004)\u0011\u0011YI!$\u0011\u0007\u0005%\u0018\nC\u0004\u0003\u00045\u0003\rAa\u0002\u0015\t\t-%\u0011\u0013\u0005\n\u0005\u0007q\u0005\u0013!a\u0001\u0005\u000f!BA!\u0017\u0003\u0016\"I!\u0011\u0004*\u0002\u0002\u0003\u0007!q\n\u000b\u0005\u0005\u000f\u0011I\nC\u0005\u0003\u001aQ\u000b\t\u00111\u0001\u0003ZQ!!q\u0001BO\u0011%\u0011IbVA\u0001\u0002\u0004\u0011IF\u0001\u0006U_B\u001cuN\u001c;fqR\u001cr![At\u0003o\fi\u0010\u0006\u0002\u0003&B\u0019\u0011\u0011^5\u0015\t\te#\u0011\u0016\u0005\n\u00053i\u0017\u0011!a\u0001\u0005\u001f\"BAa\u0002\u0003.\"I!\u0011D8\u0002\u0002\u0003\u0007!\u0011\f\u0002\r-\u0006dW/Z\"p]R,\u0007\u0010^\n\b?\u0006\u001d\u0018q_A\u007f)\t\u0011)\fE\u0002\u0002j~#BA!\u0017\u0003:\"I!\u0011D2\u0002\u0002\u0003\u0007!q\n\u000b\u0005\u0005\u000f\u0011i\fC\u0005\u0003\u001a\u0015\f\t\u00111\u0001\u0003Z\u0005A1m\u001c8uKb$\b%\u0001\u0005uS\u0012\u001c\u0015m\u00195f+\t\u0011)\r\u0005\u0004\u0002\u000e\n\u001d'1Z\u0005\u0005\u0005\u0013\fyIA\u0006UQJ,\u0017\r\u001a'pG\u0006d\u0007\u0003\u0002Bg\u00057tAAa4\u0003XB!!\u0011[A\u0002\u001b\t\u0011\u0019N\u0003\u0003\u0003V\u0006\u001d\u0011A\u0002\u001fs_>$h(\u0003\u0003\u0003Z\u0006\r\u0011A\u0002)sK\u0012,g-\u0003\u0003\u0003J\tu'\u0002\u0002Bm\u0003\u0007\t\u0011\u0002^5e\u0007\u0006\u001c\u0007.\u001a\u0011\u0002\u0007ALG-\u0001\u0003qS\u0012\u0004\u0013!B2m_N,GC\u0001B\t\u0003I!(/Y2f\tV\u0014\u0018\r^5p]\u00163XM\u001c;\u0015\u0019\tE!Q\u001eBy\u0005w\u0014ypa\u0001\t\u000f\t=(\u00051\u0001\u0003L\u0006!a.Y7f\u0011\u001d\u0011\u0019P\ta\u0001\u0005k\f!b\u001d;beRt\u0015M\\8t!\u0011\t\u0019Ba>\n\t\te\u00181\u0001\u0002\u0005\u0019>tw\rC\u0004\u0003~\n\u0002\rA!>\u0002\u001b\u0011,(/\u0019;j_:t\u0015M\\8t\u0011%\u0019\tA\tI\u0001\u0002\u0004\u0011Y-A\u0002uS\u0012D\u0011b!\u0002#!\u0003\u0005\rAa3\u0002\u0013ALGmU;gM&D\u0018\u0001\b;sC\u000e,G)\u001e:bi&|g.\u0012<f]R$C-\u001a4bk2$H\u0005N\u000b\u0003\u0007\u0017QCAa3\u00030\u0005aBO]1dK\u0012+(/\u0019;j_:,e/\u001a8uI\u0011,g-Y;mi\u0012*\u0014\u0001C<sSR,\u0007+\u001b3\u0015\t\tE11\u0003\u0005\b\u0007\u000b)\u0003\u0019\u0001Bf\u0003E!(/Y2f\u0007>,h\u000e^3s\u000bZ,g\u000e\u001e\u000b\u000b\u0005#\u0019Iba\u0007\u0004 \r\r\u0002b\u0002BxM\u0001\u0007!1\u001a\u0005\b\u0007;1\u0003\u0019\u0001Bf\u0003-\u0019w.\u001e8uKJt\u0015-\\3\t\u000f\r\u0005b\u00051\u0001\u0003v\u0006)1m\\;oi\"91Q\u0005\u0014A\u0002\t\u001d\u0011a\u00039s_\u000e,7o],jI\u0016\fq\u0003\u001e:bG\u0016$UO]1uS>tWI^3oiN#\u0018M\u001d;\u0015\u0015\tE11FB\u0018\u0007c\u0019)\u0004C\u0004\u0004.\u001d\u0002\rAa3\u0002\u0007\r\fG\u000fC\u0004\u0003p\u001e\u0002\rAa3\t\u0013\rMr\u0005%AA\u0002\t-\u0017AB2pY>,(\u000fC\u0005\u0004\u0006\u001d\u0002\n\u00111\u0001\u0003L\u0006\tCO]1dK\u0012+(/\u0019;j_:,e/\u001a8u'R\f'\u000f\u001e\u0013eK\u001a\fW\u000f\u001c;%g\u0005\tCO]1dK\u0012+(/\u0019;j_:,e/\u001a8u'R\f'\u000f\u001e\u0013eK\u001a\fW\u000f\u001c;%i\u0005)BO]1dK\u0012+(/\u0019;j_:,e/\u001a8u\u000b:$GC\u0003B\t\u0007\u007f\u0019\tea\u0011\u0004F!91Q\u0006\u0016A\u0002\t-\u0007b\u0002BxU\u0001\u0007!1\u001a\u0005\n\u0007gQ\u0003\u0013!a\u0001\u0005\u0017D\u0011b!\u0002+!\u0003\u0005\rAa3\u0002?Q\u0014\u0018mY3EkJ\fG/[8o\u000bZ,g\u000e^#oI\u0012\"WMZ1vYR$3'A\u0010ue\u0006\u001cW\rR;sCRLwN\\#wK:$XI\u001c3%I\u00164\u0017-\u001e7uIQ\n!\u0004\u001e:bG\u0016$UO]1uS>tWI^3oiN#\u0018M\u001d;F]\u0012$BB!\u0005\u0004P\rM3QKB,\u00073Bqa!\u0015.\u0001\u0004\u0011Y-A\u0005fm\u0016tG\u000fV=qK\"91QF\u0017A\u0002\t-\u0007b\u0002Bx[\u0001\u0007!1\u001a\u0005\b\u0007gi\u0003\u0019\u0001Bf\u0011%\u0019)!\fI\u0001\u0002\u0004\u0011Y-\u0001\u0013ue\u0006\u001cW\rR;sCRLwN\\#wK:$8\u000b^1si\u0016sG\r\n3fM\u0006,H\u000e\u001e\u00136)\t\u0011Y-A\u0007oC:|7\u000fV8NS\u000e\u0014xn\u001d\u000b\u0005\u0005k\u001c\u0019\u0007C\u0004\u0004fA\u0002\rA!>\u0002\u0003Q\f\u0011\"\\5de>$\u0016.\\3\u0015\u0005\tU\u0018\u0001D!se\u0006L8i\u001c8uKb$\bcAAu\tN)Ai!\u001d\u0002~BA11OB=\u0005\u000f\u0011y\"\u0004\u0002\u0004v)!1qOA\u0002\u0003\u001d\u0011XO\u001c;j[\u0016LAaa\u001f\u0004v\t\t\u0012IY:ue\u0006\u001cGOR;oGRLwN\\\u0019\u0015\u0005\r5\u0014!B1qa2LH\u0003\u0002B\u0010\u0007\u0007CqAa\u0001H\u0001\u0004\u00119!A\u0004v]\u0006\u0004\b\u000f\\=\u0015\t\r%5q\u0012\t\u0007\u0003'\u0019YIa\u0002\n\t\r5\u00151\u0001\u0002\u0007\u001fB$\u0018n\u001c8\t\u0013\rE\u0005*!AA\u0002\t}\u0011a\u0001=%a\u0005iqJ\u00196fGR\u001cuN\u001c;fqR\u00042!!;Z'\u0015I6\u0011TA\u007f!!\u0019\u0019h!\u001f\u0003\b\t-ECABK)\u0011\u0011Yia(\t\u000f\t\rA\f1\u0001\u0003\bQ!1\u0011RBR\u0011%\u0019\t*XA\u0001\u0002\u0004\u0011Y)\u0001\u0007WC2,XmQ8oi\u0016DH/\u0001\u0006U_B\u001cuN\u001c;fqR\f1a\u001d;s)\u0019\u0011\tb!,\u00040\"9!q\u001e:A\u0002\t-\u0007bBBYe\u0002\u0007!1Z\u0001\u0006m\u0006dW/Z\u0001\u0005gR\u0014(\u0007\u0006\u0006\u0003\u0012\r]6\u0011XB^\u0007\u007fCqAa<t\u0001\u0004\u0011Y\rC\u0004\u00042N\u0004\rAa3\t\u000f\ru6\u000f1\u0001\u0003L\u0006ya/\u00197vK\u000e{g\u000e^5ok\u0016$\u0017\u0007C\u0004\u0004BN\u0004\rAa3\u0002\u001fY\fG.^3D_:$\u0018N\\;fIJ\n1\u0001\u001c8h)\u0019\u0011\tba2\u0004J\"9!q\u001e;A\u0002\t-\u0007bBBYi\u0002\u0007!Q_\u0001\t_\nT7\u000b^1si\u00061qN\u00196F]\u0012\f\u0001\"\u0019:s'R\f'\u000f^\u0001\u0007CJ\u0014XI\u001c3\u0002\u0007\u0019dG\r\u0006\u0003\u0003\u0012\r]\u0007b\u0002Bxs\u0002\u0007!1\u001a")
public final class ChromeTrace
implements Closeable {
    private volatile ChromeTrace$ArrayContext$ ArrayContext$module;
    private volatile ChromeTrace$ObjectContext$ ObjectContext$module;
    private volatile ChromeTrace$ValueContext$ ValueContext$module;
    private volatile ChromeTrace$TopContext$ TopContext$module;
    private final FileUtils.LineWriter traceWriter;
    private final ArrayStack<JsonContext> context;
    private final ThreadLocal<String> tidCache;
    private final String pid;

    public ChromeTrace$ArrayContext$ ArrayContext() {
        if (this.ArrayContext$module == null) {
            this.ArrayContext$lzycompute$1();
        }
        return this.ArrayContext$module;
    }

    public ChromeTrace$ObjectContext$ ObjectContext() {
        if (this.ObjectContext$module == null) {
            this.ObjectContext$lzycompute$1();
        }
        return this.ObjectContext$module;
    }

    public ChromeTrace$ValueContext$ ValueContext() {
        if (this.ValueContext$module == null) {
            this.ValueContext$lzycompute$1();
        }
        return this.ValueContext$module;
    }

    public ChromeTrace$TopContext$ TopContext() {
        if (this.TopContext$module == null) {
            this.TopContext$lzycompute$1();
        }
        return this.TopContext$module;
    }

    private FileUtils.LineWriter traceWriter() {
        return this.traceWriter;
    }

    private ArrayStack<JsonContext> context() {
        return this.context;
    }

    private ThreadLocal<String> tidCache() {
        return this.tidCache;
    }

    private String pid() {
        return this.pid;
    }

    @Override
    public void close() {
        this.arrEnd();
        this.objEnd();
        this.context().pop();
        this.tidCache().remove();
        this.traceWriter().close();
    }

    public void traceDurationEvent(String name, long startNanos, long durationNanos, String tid, String pidSuffix) {
        long durationMicros = this.nanosToMicros(durationNanos);
        long startMicros = this.nanosToMicros(startNanos);
        this.objStart();
        this.str("cat", "scalac");
        this.str("name", name);
        this.str("ph", "X");
        this.str("tid", tid);
        this.writePid(pidSuffix);
        this.lng("ts", startMicros);
        this.lng("dur", durationMicros);
        this.objEnd();
        this.traceWriter().newLine();
    }

    public String traceDurationEvent$default$4() {
        return this.tid();
    }

    public String traceDurationEvent$default$5() {
        return "";
    }

    private void writePid(String pidSuffix) {
        String string = pidSuffix;
        String string2 = "";
        if (string != null && string.equals(string2)) {
            this.str("pid", this.pid());
            return;
        }
        this.str2("pid", this.pid(), "-", pidSuffix);
    }

    public void traceCounterEvent(String name, String counterName, long count, boolean processWide) {
        this.objStart();
        this.str("cat", "scalac");
        this.str("name", name);
        this.str("ph", "C");
        this.str("tid", this.tid());
        this.writePid(processWide ? "" : this.tid());
        this.lng("ts", this.microTime());
        this.fld("args");
        this.objStart();
        this.lng(counterName, count);
        this.objEnd();
        this.objEnd();
        this.traceWriter().newLine();
    }

    public void traceDurationEventStart(String cat, String name, String colour, String pidSuffix) {
        this.traceDurationEventStartEnd("B", cat, name, colour, pidSuffix);
    }

    public String traceDurationEventStart$default$3() {
        return "";
    }

    public String traceDurationEventStart$default$4() {
        return this.tid();
    }

    public void traceDurationEventEnd(String cat, String name, String colour, String pidSuffix) {
        this.traceDurationEventStartEnd("E", cat, name, colour, pidSuffix);
    }

    public String traceDurationEventEnd$default$3() {
        return "";
    }

    public String traceDurationEventEnd$default$4() {
        return this.tid();
    }

    private void traceDurationEventStartEnd(String eventType, String cat, String name, String colour, String pidSuffix) {
        this.objStart();
        this.str("cat", cat);
        this.str("name", name);
        this.str("ph", eventType);
        this.writePid(pidSuffix);
        this.str("tid", this.tid());
        this.lng("ts", this.microTime());
        String string = colour;
        String string2 = "";
        if (string == null || !string.equals(string2)) {
            this.str("cname", colour);
        }
        this.objEnd();
        this.traceWriter().newLine();
    }

    private String traceDurationEventStartEnd$default$5() {
        return "";
    }

    private String tid() {
        return this.tidCache().get();
    }

    private long nanosToMicros(long t) {
        return TimeUnit.NANOSECONDS.toMicros(t);
    }

    private long microTime() {
        return this.nanosToMicros(System.nanoTime());
    }

    private void str(String name, String value) {
        this.fld(name);
        this.traceWriter().write("\"");
        this.traceWriter().write(value);
        this.traceWriter().write("\"");
    }

    private void str2(String name, String value, String valueContinued1, String valueContinued2) {
        this.fld(name);
        this.traceWriter().write("\"");
        this.traceWriter().write(value);
        this.traceWriter().write(valueContinued1);
        this.traceWriter().write(valueContinued2);
        this.traceWriter().write("\"");
    }

    private void lng(String name, long value) {
        this.fld(name);
        this.traceWriter().write(String.valueOf(value));
        this.traceWriter().write("");
    }

    private void objStart() {
        JsonContext jsonContext = this.context().top();
        if (jsonContext instanceof ArrayContext) {
            ArrayContext arrayContext = (ArrayContext)jsonContext;
            if (arrayContext.first()) {
                arrayContext.first_$eq(false);
            } else {
                this.traceWriter().write(",");
            }
        }
        this.context().push(new ObjectContext(this, true));
        this.traceWriter().write("{");
    }

    private void objEnd() {
        this.traceWriter().write("}");
        this.context().pop();
    }

    private void arrStart() {
        this.traceWriter().write("[");
        this.context().push(new ArrayContext(this, true));
    }

    private void arrEnd() {
        this.traceWriter().write("]");
        this.context().pop();
    }

    private void fld(String name) {
        JsonContext topContext = this.context().top();
        if (topContext instanceof ObjectContext) {
            ObjectContext objectContext = (ObjectContext)topContext;
            if (objectContext.first()) {
                objectContext.first_$eq(false);
            } else {
                this.traceWriter().write(",");
            }
        } else {
            throw new IllegalStateException(new StringBuilder(15).append("Wrong context: ").append(topContext).toString());
        }
        this.traceWriter().write("\"");
        this.traceWriter().write(name);
        this.traceWriter().write("\"");
        this.traceWriter().write(":");
    }

    private final void ArrayContext$lzycompute$1() {
        synchronized (this) {
            if (this.ArrayContext$module == null) {
                this.ArrayContext$module = new ChromeTrace$ArrayContext$(this);
            }
            return;
        }
    }

    private final void ObjectContext$lzycompute$1() {
        synchronized (this) {
            if (this.ObjectContext$module == null) {
                this.ObjectContext$module = new ChromeTrace$ObjectContext$(this);
            }
            return;
        }
    }

    private final void ValueContext$lzycompute$1() {
        synchronized (this) {
            if (this.ValueContext$module == null) {
                this.ValueContext$module = new ChromeTrace$ValueContext$(this);
            }
            return;
        }
    }

    private final void TopContext$lzycompute$1() {
        synchronized (this) {
            if (this.TopContext$module == null) {
                this.TopContext$module = new ChromeTrace$TopContext$(this);
            }
            return;
        }
    }

    public ChromeTrace(Path f) {
        this.traceWriter = FileUtils$.MODULE$.newAsyncBufferedWriter(f, FileUtils$.MODULE$.newAsyncBufferedWriter$default$2(), FileUtils$.MODULE$.newAsyncBufferedWriter$default$3(), FileUtils$.MODULE$.newAsyncBufferedWriter$default$4());
        this.context = ArrayStack$.MODULE$.apply(Predef$.MODULE$.wrapRefArray((Object[])new JsonContext[]{this.TopContext()}), ClassTag$.MODULE$.apply(JsonContext.class));
        this.tidCache = new ThreadLocal<String>(null){

            /*
             * WARNING - void declaration
             */
            public String initialValue() {
                void formatted$extension_$this;
                void formatted$extension_fmtstr;
                String string = "%05d";
                Long l = Predef$.MODULE$.StringFormat(BoxesRunTime.boxToLong(Thread.currentThread().getId()));
                if (Predef$StringFormat$.MODULE$ == null) {
                    throw null;
                }
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                return new StringOps((String)formatted$extension_fmtstr).format(Predef$.MODULE$.genericWrapArray(new Object[]{formatted$extension_$this}));
            }
        };
        this.objStart();
        this.fld("traceEvents");
        this.context().push(this.ValueContext());
        this.arrStart();
        this.traceWriter().newLine();
        this.pid = ManagementFactory.getRuntimeMXBean().getName().replaceAll("@.*", "");
    }

    public class ArrayContext
    extends JsonContext
    implements Product,
    Serializable {
        private boolean first;

        public boolean first() {
            return this.first;
        }

        public void first_$eq(boolean x$1) {
            this.first = x$1;
        }

        public ArrayContext copy(boolean first) {
            return new ArrayContext(this.scala$reflect$internal$util$ChromeTrace$ArrayContext$$$outer(), first);
        }

        public boolean copy$default$1() {
            return this.first();
        }

        @Override
        public String productPrefix() {
            return "ArrayContext";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return BoxesRunTime.boxToBoolean(this.first());
                }
            }
            throw new IndexOutOfBoundsException(Integer.toString(x$1));
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof ArrayContext;
        }

        public int hashCode() {
            return Statics.finalizeHash(Statics.mix(-889275714, this.first() ? 1231 : 1237), 1);
        }

        public String toString() {
            return ScalaRunTime$.MODULE$._toString(this);
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof ArrayContext && ((ArrayContext)x$1).scala$reflect$internal$util$ChromeTrace$ArrayContext$$$outer() == this.scala$reflect$internal$util$ChromeTrace$ArrayContext$$$outer();
                    if (!bl) break block3;
                    ArrayContext arrayContext = (ArrayContext)x$1;
                    if (!(this.first() == arrayContext.first() && arrayContext.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ ChromeTrace scala$reflect$internal$util$ChromeTrace$ArrayContext$$$outer() {
            return this.$outer;
        }

        public ArrayContext(ChromeTrace $outer, boolean first) {
            this.first = first;
            Product.$init$(this);
        }
    }

    public abstract class JsonContext {
        public /* synthetic */ ChromeTrace scala$reflect$internal$util$ChromeTrace$JsonContext$$$outer() {
            return ChromeTrace.this;
        }

        public JsonContext() {
            if (ChromeTrace.this == null) {
                throw null;
            }
        }
    }

    public class ObjectContext
    extends JsonContext
    implements Product,
    Serializable {
        private boolean first;

        public boolean first() {
            return this.first;
        }

        public void first_$eq(boolean x$1) {
            this.first = x$1;
        }

        public ObjectContext copy(boolean first) {
            return new ObjectContext(this.scala$reflect$internal$util$ChromeTrace$ObjectContext$$$outer(), first);
        }

        public boolean copy$default$1() {
            return this.first();
        }

        @Override
        public String productPrefix() {
            return "ObjectContext";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return BoxesRunTime.boxToBoolean(this.first());
                }
            }
            throw new IndexOutOfBoundsException(Integer.toString(x$1));
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof ObjectContext;
        }

        public int hashCode() {
            return Statics.finalizeHash(Statics.mix(-889275714, this.first() ? 1231 : 1237), 1);
        }

        public String toString() {
            return ScalaRunTime$.MODULE$._toString(this);
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof ObjectContext && ((ObjectContext)x$1).scala$reflect$internal$util$ChromeTrace$ObjectContext$$$outer() == this.scala$reflect$internal$util$ChromeTrace$ObjectContext$$$outer();
                    if (!bl) break block3;
                    ObjectContext objectContext = (ObjectContext)x$1;
                    if (!(this.first() == objectContext.first() && objectContext.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ ChromeTrace scala$reflect$internal$util$ChromeTrace$ObjectContext$$$outer() {
            return this.$outer;
        }

        public ObjectContext(ChromeTrace $outer, boolean first) {
            this.first = first;
            Product.$init$(this);
        }
    }
}

