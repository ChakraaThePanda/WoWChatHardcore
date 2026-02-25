/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.api;

import java.io.PrintWriter;
import java.io.StringWriter;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Product;
import scala.Serializable;
import scala.Some;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Names;
import scala.reflect.api.Position;
import scala.reflect.api.Printers$BooleanFlag$;
import scala.reflect.api.Symbols;
import scala.reflect.api.Trees;
import scala.reflect.api.Universe;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\r\u0005c!C-[!\u0003\r\t!YB\u001d\u0011\u00151\u0007\u0001\"\u0001h\r\u001dY\u0007\u0001%A\u0002\u00121DQA\u001a\u0002\u0005\u0002\u001dDQ!\u001c\u0002\u0007\u00029Dqa\u001e\u0002A\u0002\u0013E\u0001\u0010C\u0004}\u0005\u0001\u0007I\u0011C?\t\u0011\u0005\u0005!\u00011A\u0005\u0012aD\u0011\"a\u0001\u0003\u0001\u0004%\t\"!\u0002\t\u0011\u0005%!\u00011A\u0005\u0012aD\u0011\"a\u0003\u0003\u0001\u0004%\t\"!\u0004\t\u0011\u0005E!\u00011A\u0005\u0012aD\u0011\"a\u0005\u0003\u0001\u0004%\t\"!\u0006\t\u0011\u0005e!\u00011A\u0005\u0012aD\u0011\"a\u0007\u0003\u0001\u0004%\t\"!\b\t\u0011\u0005\u0005\"\u00011A\u0005\u0012aD\u0011\"a\t\u0003\u0001\u0004%\t\"!\n\t\u000f\u0005%\"\u0001\"\u0001\u0002,!9\u0011q\u0006\u0002\u0005\u0002\u0005-\u0002bBA\u0019\u0005\u0011\u0005\u00111\u0006\u0005\b\u0003g\u0011A\u0011AA\u0016\u0011\u001d\t)D\u0001C\u0001\u0003WAq!a\u000e\u0003\t\u0003\tY\u0003C\u0004\u0002:\t!\t!a\u000b\t\u000f\u0005m\"\u0001\"\u0001\u0002,!9\u0011Q\b\u0002\u0005\u0002\u0005-\u0002bBA \u0005\u0011\u0005\u00111\u0006\u0005\b\u0003\u0003\u0012A\u0011AA\u0016\u0011\u001d\t\u0019E\u0001C\u0001\u0003W1a!!\u0012\u0001\u0001\u0006\u001d\u0003BCA+;\tU\r\u0011\"\u0001\u0002X!Q\u0011qL\u000f\u0003\u0012\u0003\u0006I!!\u0017\t\u000f\u0005\u0005T\u0004\"\u0001\u0002d!I\u00111N\u000f\u0002\u0002\u0013\u0005\u0011Q\u000e\u0005\n\u0003cj\u0012\u0013!C\u0001\u0003gB\u0011\"!#\u001e\u0003\u0003%\t%a#\t\u0013\u0005uU$!A\u0005\u0002\u0005}\u0005\"CAT;\u0005\u0005I\u0011AAU\u0011%\ti+HA\u0001\n\u0003\ny\u000bC\u0005\u0002>v\t\t\u0011\"\u0001\u0002@\"I\u00111Y\u000f\u0002\u0002\u0013\u0005\u0013Q\u0019\u0005\n\u0003\u000fl\u0012\u0011!C!\u0003\u0013D\u0011\"a3\u001e\u0003\u0003%\t%!4\b\u000f\u0005E\u0007\u0001#\u0001\u0002T\u001a9\u0011Q\t\u0001\t\u0002\u0005U\u0007bBA1Y\u0011\u0005\u0011q\u001b\u0005\b\u00033dC1AAn\u0011\u001d\ty\u000e\fC\u0002\u0003CDq!!:-\t\u0007\t9\u000fC\u0005\u0003\u00041\n\t\u0011\"!\u0003\u0006!I!\u0011\u0002\u0017\u0002\u0002\u0013\u0005%1\u0002\u0005\b\u0005'\u0001A\u0011\u0003B\u000b\u0011%\u0011\u0019\u0006AI\u0001\n#\u0011)\u0006C\u0005\u0003Z\u0001\t\n\u0011\"\u0005\u0003V!I!1\f\u0001\u0012\u0002\u0013E!Q\u000b\u0005\n\u0005;\u0002\u0011\u0013!C\t\u0005+B\u0011Ba\u0018\u0001#\u0003%\tB!\u0016\t\u0013\t\u0005\u0004!%A\u0005\u0012\tU\u0003b\u0002B2\u0001\u0011E#Q\r\u0005\b\u0005k\u0002A\u0011\u0001B<\u0011%\u0011I\tAI\u0001\n\u0003\u0011)\u0006C\u0005\u0003\f\u0002\t\n\u0011\"\u0001\u0003V!I!Q\u0012\u0001\u0012\u0002\u0013\u0005!Q\u000b\u0005\n\u0005\u001f\u0003\u0011\u0013!C\u0001\u0005+B\u0011B!%\u0001#\u0003%\tA!\u0016\t\u0013\tM\u0005!%A\u0005\u0002\tU\u0003b\u0002BK\u0001\u0019E!q\u0013\u0005\b\u0005;\u0003A\u0011\u0001BP\u0011%\u0011y\u000bAI\u0001\n\u0003\u0011)\u0006C\u0005\u00032\u0002\t\n\u0011\"\u0001\u0003V!I!1\u0017\u0001\u0012\u0002\u0013\u0005!Q\u000b\u0005\n\u0005k\u0003\u0011\u0013!C\u0001\u0005+B\u0011Ba.\u0001#\u0003%\tA!/\t\u000f\tu\u0006A\"\u0005\u0003@\"9!q\u0019\u0001\u0005\u0002\t%\u0007\"\u0003Bm\u0001E\u0005I\u0011\u0001B+\u0011%\u0011Y\u000eAI\u0001\n\u0003\u0011)\u0006C\u0005\u0003^\u0002\t\n\u0011\"\u0001\u0003V!I!q\u001c\u0001\u0012\u0002\u0013\u0005!Q\u000b\u0005\n\u0005C\u0004\u0011\u0013!C\u0001\u0005+B\u0011Ba9\u0001#\u0003%\tA!\u0016\t\u000f\t\u0015\bA\"\u0005\u0003h\"9!Q\u000f\u0001\u0007\u0002\t-\bb\u0002Bd\u0001\u0011\u0005!1 \u0005\b\u0005k\u0002a\u0011\u0001B\u0000\u0011\u001d\u0011)\b\u0001D\u0001\u0007\u001fAqAa2\u0001\t\u0003\u0019y\u0002C\u0004\u0003H\u0002!\taa\t\t\u000f\r\u001d\u0002A\"\u0001\u0004*\tA\u0001K]5oi\u0016\u00148O\u0003\u0002\\9\u0006\u0019\u0011\r]5\u000b\u0005us\u0016a\u0002:fM2,7\r\u001e\u0006\u0002?\u0006)1oY1mC\u000e\u00011C\u0001\u0001c!\t\u0019G-D\u0001_\u0013\t)gL\u0001\u0004B]f\u0014VMZ\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003!\u0004\"aY5\n\u0005)t&\u0001B+oSR\u00141\u0002\u0016:fKB\u0013\u0018N\u001c;feN\u0011!AY\u0001\u0006aJLg\u000e\u001e\u000b\u0003Q>DQ\u0001\u001d\u0003A\u0002E\fA!\u0019:hgB\u00191M\u001d;\n\u0005Mt&A\u0003\u001fsKB,\u0017\r^3e}A\u00111-^\u0005\u0003mz\u00131!\u00118z\u0003)\u0001(/\u001b8u)f\u0004Xm]\u000b\u0002sB\u00111M_\u0005\u0003wz\u0013qAQ8pY\u0016\fg.\u0001\bqe&tG\u000fV=qKN|F%Z9\u0015\u0005!t\bbB@\u0007\u0003\u0003\u0005\r!_\u0001\u0004q\u0012\n\u0014\u0001\u00039sS:$\u0018\nZ:\u0002\u0019A\u0014\u0018N\u001c;JIN|F%Z9\u0015\u0007!\f9\u0001C\u0004\u0000\u0011\u0005\u0005\t\u0019A=\u0002\u0017A\u0014\u0018N\u001c;Po:,'o]\u0001\u0010aJLg\u000e^(x]\u0016\u00148o\u0018\u0013fcR\u0019\u0001.a\u0004\t\u000f}T\u0011\u0011!a\u0001s\u0006Q\u0001O]5oi.Kg\u000eZ:\u0002\u001dA\u0014\u0018N\u001c;LS:$7o\u0018\u0013fcR\u0019\u0001.a\u0006\t\u000f}d\u0011\u0011!a\u0001s\u0006a\u0001O]5oi6K'O]8sg\u0006\u0001\u0002O]5oi6K'O]8sg~#S-\u001d\u000b\u0004Q\u0006}\u0001bB@\u000f\u0003\u0003\u0005\r!_\u0001\u000faJLg\u000e\u001e)pg&$\u0018n\u001c8t\u0003I\u0001(/\u001b8u!>\u001c\u0018\u000e^5p]N|F%Z9\u0015\u0007!\f9\u0003C\u0004\u0000!\u0005\u0005\t\u0019A=\u0002\u0013]LG\u000f\u001b+za\u0016\u001cXCAA\u0017\u001b\u0005\u0011\u0011\u0001D<ji\"|W\u000f\u001e+za\u0016\u001c\u0018aB<ji\"LEm]\u0001\u000bo&$\bn\\;u\u0013\u0012\u001c\u0018AC<ji\"|uO\\3sg\u0006iq/\u001b;i_V$xj\u001e8feN\f\u0011b^5uQ.Kg\u000eZ:\u0002\u0019]LG\u000f[8vi.Kg\u000eZ:\u0002\u0017]LG\u000f['jeJ|'o]\u0001\u000fo&$\bn\\;u\u001b&\u0014(o\u001c:t\u000359\u0018\u000e\u001e5Q_NLG/[8og\u0006\u0001r/\u001b;i_V$\bk\\:ji&|gn\u001d\u0002\f\u0005>|G.Z1o\r2\fwm\u0005\u0004\u001eE\u0006%\u0013q\n\t\u0004G\u0006-\u0013bAA'=\n9\u0001K]8ek\u000e$\bcA2\u0002R%\u0019\u00111\u000b0\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\u000bY\fG.^3\u0016\u0005\u0005e\u0003\u0003B2\u0002\\eL1!!\u0018_\u0005\u0019y\u0005\u000f^5p]\u00061a/\u00197vK\u0002\na\u0001P5oSRtD\u0003BA3\u0003S\u00022!a\u001a\u001e\u001b\u0005\u0001\u0001bBA+A\u0001\u0007\u0011\u0011L\u0001\u0005G>\u0004\u0018\u0010\u0006\u0003\u0002f\u0005=\u0004\"CA+CA\u0005\t\u0019AA-\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIE*\"!!\u001e+\t\u0005e\u0013qO\u0016\u0003\u0003s\u0002B!a\u001f\u0002\u00066\u0011\u0011Q\u0010\u0006\u0005\u0003\u007f\n\t)A\u0005v]\u000eDWmY6fI*\u0019\u00111\u00110\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0003\u0002\b\u0006u$!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\u0006i\u0001O]8ek\u000e$\bK]3gSb,\"!!$\u0011\t\u0005=\u0015\u0011T\u0007\u0003\u0003#SA!a%\u0002\u0016\u0006!A.\u00198h\u0015\t\t9*\u0001\u0003kCZ\f\u0017\u0002BAN\u0003#\u0013aa\u0015;sS:<\u0017\u0001\u00049s_\u0012,8\r^!sSRLXCAAQ!\r\u0019\u00171U\u0005\u0004\u0003Ks&aA%oi\u0006q\u0001O]8ek\u000e$X\t\\3nK:$Hc\u0001;\u0002,\"Aq0JA\u0001\u0002\u0004\t\t+A\bqe>$Wo\u0019;Ji\u0016\u0014\u0018\r^8s+\t\t\t\fE\u0003\u00024\u0006eF/\u0004\u0002\u00026*\u0019\u0011q\u00170\u0002\u0015\r|G\u000e\\3di&|g.\u0003\u0003\u0002<\u0006U&\u0001C%uKJ\fGo\u001c:\u0002\u0011\r\fg.R9vC2$2!_Aa\u0011\u001dyx%!AA\u0002Q\f\u0001\u0002[1tQ\u000e{G-\u001a\u000b\u0003\u0003C\u000b\u0001\u0002^8TiJLgn\u001a\u000b\u0003\u0003\u001b\u000ba!Z9vC2\u001cHcA=\u0002P\"9qPKA\u0001\u0002\u0004!\u0018a\u0003\"p_2,\u0017M\u001c$mC\u001e\u00042!a\u001a-'\u0011a#-a\u0014\u0015\u0005\u0005M\u0017\u0001\u00062p_2,\u0017M\u001c+p\u0005>|G.Z1o\r2\fw\r\u0006\u0003\u0002f\u0005u\u0007BBA+]\u0001\u0007\u00110A\npaRLwN\u001c+p\u0005>|G.Z1o\r2\fw\r\u0006\u0003\u0002f\u0005\r\bbBA+_\u0001\u0007\u0011\u0011L\u0001\u0015g\u0016$H/\u001b8h)>\u0014un\u001c7fC:4E.Y4\u0015\t\u0005\u0015\u0014\u0011\u001e\u0005\b\u0003W\u0004\u0004\u0019AAw\u0003\u001d\u0019X\r\u001e;j]\u001e\u0004B!a<\u0002\u0000B!\u0011\u0011_A~\u001b\t\t\u0019P\u0003\u0003\u0002v\u0006]\u0018\u0001C:fiRLgnZ:\u000b\u0007\u0005eH,\u0001\u0005j]R,'O\\1m\u0013\u0011\ti0a=\u0003\u001f5+H/\u00192mKN+G\u000f^5oONLAA!\u0001\u0002|\nq!i\\8mK\u0006t7+\u001a;uS:<\u0017!B1qa2LH\u0003BA3\u0005\u000fAq!!\u00162\u0001\u0004\tI&A\u0004v]\u0006\u0004\b\u000f\\=\u0015\t\t5!q\u0002\t\u0006G\u0006m\u0013\u0011\f\u0005\n\u0005#\u0011\u0014\u0011!a\u0001\u0003K\n1\u0001\u001f\u00131\u0003\u0019\u0011XM\u001c3feR\u0011\"q\u0003B\u0016\u0005_\u00119E!\u0013\u0003L\t5#q\nB)!\u0011\u0011IBa\n\u000f\t\tm!1\u0005\t\u0004\u0005;qVB\u0001B\u0010\u0015\r\u0011\t\u0003Y\u0001\u0007yI|w\u000e\u001e \n\u0007\t\u0015b,\u0001\u0004Qe\u0016$WMZ\u0005\u0005\u00037\u0013ICC\u0002\u0003&yCaA!\f4\u0001\u0004!\u0018\u0001B<iCRDqA!\r4\u0001\u0004\u0011\u0019$A\u0005nWB\u0013\u0018N\u001c;feB91M!\u000e\u0003:\t\u0015\u0013b\u0001B\u001c=\nIa)\u001e8di&|g.\r\t\u0005\u0005w\u0011\t%\u0004\u0002\u0003>)!!qHAK\u0003\tIw.\u0003\u0003\u0003D\tu\"a\u0003)sS:$xK]5uKJ\u00042!a\u001a\u0003\u0011!98\u0007%AA\u0002\u0005\u0015\u0004\"CA\u0001gA\u0005\t\u0019AA3\u0011%\tIa\rI\u0001\u0002\u0004\t)\u0007C\u0005\u0002\u0012M\u0002\n\u00111\u0001\u0002f!I\u0011\u0011D\u001a\u0011\u0002\u0003\u0007\u0011Q\r\u0005\n\u0003C\u0019\u0004\u0013!a\u0001\u0003K\n\u0001C]3oI\u0016\u0014H\u0005Z3gCVdG\u000fJ\u001a\u0016\u0005\t]#\u0006BA3\u0003o\n\u0001C]3oI\u0016\u0014H\u0005Z3gCVdG\u000f\n\u001b\u0002!I,g\u000eZ3sI\u0011,g-Y;mi\u0012*\u0014\u0001\u0005:f]\u0012,'\u000f\n3fM\u0006,H\u000e\u001e\u00137\u0003A\u0011XM\u001c3fe\u0012\"WMZ1vYR$s'\u0001\tsK:$WM\u001d\u0013eK\u001a\fW\u000f\u001c;%q\u0005aAO]3f)>\u001cFO]5oOR!!q\u0003B4\u0011\u001d\u0011IG\u000fa\u0001\u0005W\nA\u0001\u001e:fKB!\u0011q\rB7\u0013\u0011\u0011yG!\u001d\u0003\tQ\u0013X-Z\u0005\u0004\u0005gR&!\u0002+sK\u0016\u001c\u0018\u0001B:i_^$\u0002Ca\u0006\u0003z\tu$q\u0010BA\u0005\u0007\u0013)Ia\"\t\r\tm4\b1\u0001u\u0003\r\tg.\u001f\u0005\ton\u0002\n\u00111\u0001\u0002f!I\u0011\u0011A\u001e\u0011\u0002\u0003\u0007\u0011Q\r\u0005\n\u0003\u0013Y\u0004\u0013!a\u0001\u0003KB\u0011\"!\u0005<!\u0003\u0005\r!!\u001a\t\u0013\u0005e1\b%AA\u0002\u0005\u0015\u0004\"CA\u0011wA\u0005\t\u0019AA3\u00039\u0019\bn\\<%I\u00164\u0017-\u001e7uII\nab\u001d5po\u0012\"WMZ1vYR$3'\u0001\btQ><H\u0005Z3gCVdG\u000f\n\u001b\u0002\u001dMDwn\u001e\u0013eK\u001a\fW\u000f\u001c;%k\u0005q1\u000f[8xI\u0011,g-Y;mi\u00122\u0014AD:i_^$C-\u001a4bk2$HeN\u0001\u000f]\u0016<HK]3f!JLg\u000e^3s)\u0011\u0011)E!'\t\u000f\tm%\t1\u0001\u0003:\u0005\u0019q.\u001e;\u0002\u0011MDwn^\"pI\u0016$bBa\u0006\u0003\"\n\r&Q\u0015BT\u0005S\u0013Y\u000bC\u0004\u0003j\r\u0003\rAa\u001b\t\u0011]\u001c\u0005\u0013!a\u0001\u0003KB\u0011\"!\u0001D!\u0003\u0005\r!!\u001a\t\u0013\u0005%1\t%AA\u0002\u0005\u0015\u0004\"CA\u0011\u0007B\u0005\t\u0019AA3\u0011!\u0011ik\u0011I\u0001\u0002\u0004I\u0018\u0001\u00049sS:$(k\\8u!.<\u0017AE:i_^\u001cu\u000eZ3%I\u00164\u0017-\u001e7uII\n!c\u001d5po\u000e{G-\u001a\u0013eK\u001a\fW\u000f\u001c;%g\u0005\u00112\u000f[8x\u0007>$W\r\n3fM\u0006,H\u000e\u001e\u00135\u0003I\u0019\bn\\<D_\u0012,G\u0005Z3gCVdG\u000fJ\u001b\u0002%MDwn^\"pI\u0016$C-\u001a4bk2$HEN\u000b\u0003\u0005wS3!_A<\u00039qWm^\"pI\u0016\u0004&/\u001b8uKJ$\u0002B!\u0012\u0003B\n\r'Q\u0019\u0005\b\u00057K\u0005\u0019\u0001B\u001d\u0011\u001d\u0011I'\u0013a\u0001\u0005WBaA!,J\u0001\u0004I\u0018aB:i_^\u0014\u0016m\u001e\u000b\u0011\u0005/\u0011YM!4\u0003P\nE'1\u001bBk\u0005/DaAa\u001fK\u0001\u0004!\b\u0002C<K!\u0003\u0005\r!!\u001a\t\u0013\u0005\u0005!\n%AA\u0002\u0005\u0015\u0004\"CA\u0005\u0015B\u0005\t\u0019AA3\u0011%\t\tB\u0013I\u0001\u0002\u0004\t)\u0007C\u0005\u0002\u001a)\u0003\n\u00111\u0001\u0002f!I\u0011\u0011\u0005&\u0011\u0002\u0003\u0007\u0011QM\u0001\u0012g\"|wOU1xI\u0011,g-Y;mi\u0012\u0012\u0014!E:i_^\u0014\u0016m\u001e\u0013eK\u001a\fW\u000f\u001c;%g\u0005\t2\u000f[8x%\u0006<H\u0005Z3gCVdG\u000f\n\u001b\u0002#MDwn\u001e*bo\u0012\"WMZ1vYR$S'A\ttQ><(+Y<%I\u00164\u0017-\u001e7uIY\n\u0011c\u001d5poJ\u000bw\u000f\n3fM\u0006,H\u000e\u001e\u00138\u0003EqWm\u001e*boR\u0013X-\u001a)sS:$XM\u001d\u000b\u0005\u0005\u000b\u0012I\u000fC\u0004\u0003\u001cF\u0003\rA!\u000f\u0015\t\t]!Q\u001e\u0005\b\u0005_\u0014\u0006\u0019\u0001By\u0003\u0011q\u0017-\\3\u0011\t\u0005\u001d$1_\u0005\u0005\u0005k\u00149P\u0001\u0003OC6,\u0017b\u0001B}5\n)a*Y7fgR!!q\u0003B\u007f\u0011\u001d\u0011yo\u0015a\u0001\u0005c$BAa\u0006\u0004\u0002!911\u0001+A\u0002\r\u0015\u0011!\u00024mC\u001e\u001c\b\u0003BA4\u0007\u000fIAa!\u0003\u0004\f\t9a\t\\1h'\u0016$\u0018bAB\u00075\nAa\t\\1h'\u0016$8\u000f\u0006\u0003\u0003\u0018\rE\u0001bBB\n+\u0002\u00071QC\u0001\ta>\u001c\u0018\u000e^5p]B!\u0011qMB\f\u0013\u0011\u0019Iba\u0007\u0003\u0011A{7/\u001b;j_:L1a!\b[\u0005%\u0001vn]5uS>t7\u000f\u0006\u0003\u0003\u0018\r\u0005\u0002bBB\u0002-\u0002\u00071Q\u0001\u000b\u0005\u0005/\u0019)\u0003C\u0004\u0004\u0014]\u0003\ra!\u0006\u0002\u0011MDwn\u001e#fG2$BAa\u0006\u0004,!91Q\u0006-A\u0002\r=\u0012aA:z[B!\u0011qMB\u0019\u0013\u0011\u0019\u0019d!\u000e\u0003\rMKXNY8m\u0013\r\u00199D\u0017\u0002\b'fl'm\u001c7t!\u0011\u0019Yd!\u0010\u000e\u0003iK1aa\u0010[\u0005!)f.\u001b<feN,\u0007")
public interface Printers {
    public Printers$BooleanFlag$ BooleanFlag();

    public static /* synthetic */ String render$(Printers $this, Object what, Function1 mkPrinter, BooleanFlag printTypes, BooleanFlag printIds, BooleanFlag printOwners, BooleanFlag printKinds, BooleanFlag printMirrors, BooleanFlag printPositions) {
        return $this.render(what, mkPrinter, printTypes, printIds, printOwners, printKinds, printMirrors, printPositions);
    }

    default public String render(Object what, Function1<PrintWriter, TreePrinter> mkPrinter, BooleanFlag printTypes, BooleanFlag printIds, BooleanFlag printOwners, BooleanFlag printKinds, BooleanFlag printMirrors, BooleanFlag printPositions) {
        StringWriter buffer = new StringWriter();
        PrintWriter writer = new PrintWriter(buffer);
        TreePrinter printer = mkPrinter.apply(writer);
        Option<Object> option = printTypes.value();
        if (option == null) {
            throw null;
        }
        Option<Object> map_this = option;
        if (map_this.isEmpty()) {
        } else {
            Object object = map_this.get();
            new Some<TreePrinter>(Printers.$anonfun$render$1(printer, BoxesRunTime.unboxToBoolean(object)));
        }
        Option<Object> option2 = printIds.value();
        if (option2 == null) {
            throw null;
        }
        Option<Object> map_this2 = option2;
        if (map_this2.isEmpty()) {
        } else {
            Object object = map_this2.get();
            new Some<TreePrinter>(Printers.$anonfun$render$2(printer, BoxesRunTime.unboxToBoolean(object)));
        }
        Option<Object> option3 = printOwners.value();
        if (option3 == null) {
            throw null;
        }
        Option<Object> map_this3 = option3;
        if (map_this3.isEmpty()) {
        } else {
            Object object = map_this3.get();
            new Some<TreePrinter>(Printers.$anonfun$render$3(printer, BoxesRunTime.unboxToBoolean(object)));
        }
        Option<Object> option4 = printKinds.value();
        if (option4 == null) {
            throw null;
        }
        Option<Object> map_this4 = option4;
        if (map_this4.isEmpty()) {
        } else {
            Object object = map_this4.get();
            new Some<TreePrinter>(Printers.$anonfun$render$4(printer, BoxesRunTime.unboxToBoolean(object)));
        }
        Option<Object> option5 = printMirrors.value();
        if (option5 == null) {
            throw null;
        }
        Option<Object> map_this5 = option5;
        if (map_this5.isEmpty()) {
        } else {
            Object object = map_this5.get();
            new Some<TreePrinter>(Printers.$anonfun$render$5(printer, BoxesRunTime.unboxToBoolean(object)));
        }
        Option<Object> option6 = printPositions.value();
        if (option6 == null) {
            throw null;
        }
        Option<Object> map_this6 = option6;
        if (map_this6.isEmpty()) {
        } else {
            Object object = map_this6.get();
            new Some<TreePrinter>(Printers.$anonfun$render$6(printer, BoxesRunTime.unboxToBoolean(object)));
        }
        printer.print(Predef$.MODULE$.genericWrapArray(new Object[]{what}));
        writer.flush();
        return buffer.toString();
    }

    public static /* synthetic */ BooleanFlag render$default$3$(Printers $this) {
        return $this.render$default$3();
    }

    default public BooleanFlag render$default$3() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ BooleanFlag render$default$4$(Printers $this) {
        return $this.render$default$4();
    }

    default public BooleanFlag render$default$4() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ BooleanFlag render$default$5$(Printers $this) {
        return $this.render$default$5();
    }

    default public BooleanFlag render$default$5() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ BooleanFlag render$default$6$(Printers $this) {
        return $this.render$default$6();
    }

    default public BooleanFlag render$default$6() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ BooleanFlag render$default$7$(Printers $this) {
        return $this.render$default$7();
    }

    default public BooleanFlag render$default$7() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ BooleanFlag render$default$8$(Printers $this) {
        return $this.render$default$8();
    }

    default public BooleanFlag render$default$8() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ String treeToString$(Printers $this, Trees.TreeApi tree) {
        return $this.treeToString(tree);
    }

    default public String treeToString(Trees.TreeApi tree) {
        return this.show(tree, this.show$default$2(), this.show$default$3(), this.show$default$4(), this.show$default$5(), this.show$default$6(), this.show$default$7());
    }

    public static /* synthetic */ String show$(Printers $this, Object any, BooleanFlag printTypes, BooleanFlag printIds, BooleanFlag printOwners, BooleanFlag printKinds, BooleanFlag printMirrors, BooleanFlag printPositions) {
        return $this.show(any, printTypes, printIds, printOwners, printKinds, printMirrors, printPositions);
    }

    default public String show(Object any, BooleanFlag printTypes, BooleanFlag printIds, BooleanFlag printOwners, BooleanFlag printKinds, BooleanFlag printMirrors, BooleanFlag printPositions) {
        return this.render(any, (Function1<PrintWriter, TreePrinter> & java.io.Serializable & Serializable)x$1 -> this.newTreePrinter((PrintWriter)x$1), printTypes, printIds, printOwners, printKinds, printMirrors, printPositions);
    }

    public TreePrinter newTreePrinter(PrintWriter var1);

    public static /* synthetic */ String showCode$(Printers $this, Trees.TreeApi tree, BooleanFlag printTypes, BooleanFlag printIds, BooleanFlag printOwners, BooleanFlag printPositions, boolean printRootPkg) {
        return $this.showCode(tree, printTypes, printIds, printOwners, printPositions, printRootPkg);
    }

    default public String showCode(Trees.TreeApi tree, BooleanFlag printTypes, BooleanFlag printIds, BooleanFlag printOwners, BooleanFlag printPositions, boolean printRootPkg) {
        return this.render(tree, (Function1<PrintWriter, TreePrinter> & java.io.Serializable & Serializable)x$2 -> this.newCodePrinter((PrintWriter)x$2, tree, printRootPkg), printTypes, printIds, printOwners, this.BooleanFlag().optionToBooleanFlag(None$.MODULE$), this.BooleanFlag().optionToBooleanFlag(None$.MODULE$), printPositions);
    }

    public TreePrinter newCodePrinter(PrintWriter var1, Trees.TreeApi var2, boolean var3);

    public static /* synthetic */ String showRaw$(Printers $this, Object any, BooleanFlag printTypes, BooleanFlag printIds, BooleanFlag printOwners, BooleanFlag printKinds, BooleanFlag printMirrors, BooleanFlag printPositions) {
        return $this.showRaw(any, printTypes, printIds, printOwners, printKinds, printMirrors, printPositions);
    }

    default public String showRaw(Object any, BooleanFlag printTypes, BooleanFlag printIds, BooleanFlag printOwners, BooleanFlag printKinds, BooleanFlag printMirrors, BooleanFlag printPositions) {
        return this.render(any, (Function1<PrintWriter, TreePrinter> & java.io.Serializable & Serializable)out -> this.newRawTreePrinter((PrintWriter)out), printTypes, printIds, printOwners, printKinds, printMirrors, printPositions);
    }

    public TreePrinter newRawTreePrinter(PrintWriter var1);

    public String show(Names.NameApi var1);

    public static /* synthetic */ String showRaw$(Printers $this, Names.NameApi name) {
        return $this.showRaw(name);
    }

    default public String showRaw(Names.NameApi name) {
        return name.toString();
    }

    public String show(Object var1);

    public String show(Position var1);

    public static /* synthetic */ BooleanFlag show$default$2$(Printers $this) {
        return $this.show$default$2();
    }

    default public BooleanFlag show$default$2() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ BooleanFlag show$default$3$(Printers $this) {
        return $this.show$default$3();
    }

    default public BooleanFlag show$default$3() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ BooleanFlag show$default$4$(Printers $this) {
        return $this.show$default$4();
    }

    default public BooleanFlag show$default$4() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ BooleanFlag show$default$5$(Printers $this) {
        return $this.show$default$5();
    }

    default public BooleanFlag show$default$5() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ BooleanFlag show$default$6$(Printers $this) {
        return $this.show$default$6();
    }

    default public BooleanFlag show$default$6() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ BooleanFlag show$default$7$(Printers $this) {
        return $this.show$default$7();
    }

    default public BooleanFlag show$default$7() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ BooleanFlag showCode$default$2$(Printers $this) {
        return $this.showCode$default$2();
    }

    default public BooleanFlag showCode$default$2() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ BooleanFlag showCode$default$3$(Printers $this) {
        return $this.showCode$default$3();
    }

    default public BooleanFlag showCode$default$3() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ BooleanFlag showCode$default$4$(Printers $this) {
        return $this.showCode$default$4();
    }

    default public BooleanFlag showCode$default$4() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ BooleanFlag showCode$default$5$(Printers $this) {
        return $this.showCode$default$5();
    }

    default public BooleanFlag showCode$default$5() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ boolean showCode$default$6$(Printers $this) {
        return $this.showCode$default$6();
    }

    default public boolean showCode$default$6() {
        return false;
    }

    public static /* synthetic */ String showRaw$(Printers $this, Object flags) {
        return $this.showRaw(flags);
    }

    default public String showRaw(Object flags) {
        return flags.toString();
    }

    public static /* synthetic */ String showRaw$(Printers $this, Position position) {
        return $this.showRaw(position);
    }

    default public String showRaw(Position position) {
        return position.toString();
    }

    public static /* synthetic */ BooleanFlag showRaw$default$2$(Printers $this) {
        return $this.showRaw$default$2();
    }

    default public BooleanFlag showRaw$default$2() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ BooleanFlag showRaw$default$3$(Printers $this) {
        return $this.showRaw$default$3();
    }

    default public BooleanFlag showRaw$default$3() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ BooleanFlag showRaw$default$4$(Printers $this) {
        return $this.showRaw$default$4();
    }

    default public BooleanFlag showRaw$default$4() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ BooleanFlag showRaw$default$5$(Printers $this) {
        return $this.showRaw$default$5();
    }

    default public BooleanFlag showRaw$default$5() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ BooleanFlag showRaw$default$6$(Printers $this) {
        return $this.showRaw$default$6();
    }

    default public BooleanFlag showRaw$default$6() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public static /* synthetic */ BooleanFlag showRaw$default$7$(Printers $this) {
        return $this.showRaw$default$7();
    }

    default public BooleanFlag showRaw$default$7() {
        return this.BooleanFlag().optionToBooleanFlag(None$.MODULE$);
    }

    public String showDecl(Symbols.SymbolApi var1);

    public static /* synthetic */ TreePrinter $anonfun$render$1(TreePrinter printer$1, boolean printTypes) {
        if (printTypes) {
            return printer$1.withTypes();
        }
        return printer$1.withoutTypes();
    }

    public static /* synthetic */ TreePrinter $anonfun$render$2(TreePrinter printer$1, boolean printIds) {
        if (printIds) {
            return printer$1.withIds();
        }
        return printer$1.withoutIds();
    }

    public static /* synthetic */ TreePrinter $anonfun$render$3(TreePrinter printer$1, boolean printOwners) {
        if (printOwners) {
            return printer$1.withOwners();
        }
        return printer$1.withoutOwners();
    }

    public static /* synthetic */ TreePrinter $anonfun$render$4(TreePrinter printer$1, boolean printKinds) {
        if (printKinds) {
            return printer$1.withKinds();
        }
        return printer$1.withoutKinds();
    }

    public static /* synthetic */ TreePrinter $anonfun$render$5(TreePrinter printer$1, boolean printMirrors) {
        if (printMirrors) {
            return printer$1.withMirrors();
        }
        return printer$1.withoutMirrors();
    }

    public static /* synthetic */ TreePrinter $anonfun$render$6(TreePrinter printer$1, boolean printPositions) {
        if (printPositions) {
            return printer$1.withPositions();
        }
        return printer$1.withoutPositions();
    }

    public static void $init$(Printers $this) {
    }

    public static /* synthetic */ TreePrinter $anonfun$render$1$adapted(TreePrinter printer$1, Object printTypes) {
        return Printers.$anonfun$render$1(printer$1, BoxesRunTime.unboxToBoolean(printTypes));
    }

    public static /* synthetic */ TreePrinter $anonfun$render$2$adapted(TreePrinter printer$1, Object printIds) {
        return Printers.$anonfun$render$2(printer$1, BoxesRunTime.unboxToBoolean(printIds));
    }

    public static /* synthetic */ TreePrinter $anonfun$render$3$adapted(TreePrinter printer$1, Object printOwners) {
        return Printers.$anonfun$render$3(printer$1, BoxesRunTime.unboxToBoolean(printOwners));
    }

    public static /* synthetic */ TreePrinter $anonfun$render$4$adapted(TreePrinter printer$1, Object printKinds) {
        return Printers.$anonfun$render$4(printer$1, BoxesRunTime.unboxToBoolean(printKinds));
    }

    public static /* synthetic */ TreePrinter $anonfun$render$5$adapted(TreePrinter printer$1, Object printMirrors) {
        return Printers.$anonfun$render$5(printer$1, BoxesRunTime.unboxToBoolean(printMirrors));
    }

    public static /* synthetic */ TreePrinter $anonfun$render$6$adapted(TreePrinter printer$1, Object printPositions) {
        return Printers.$anonfun$render$6(printer$1, BoxesRunTime.unboxToBoolean(printPositions));
    }

    public class BooleanFlag
    implements Product,
    Serializable {
        private final Option<Object> value;
        public final /* synthetic */ Universe $outer;

        public Option<Object> value() {
            return this.value;
        }

        public BooleanFlag copy(Option<Object> value) {
            return new BooleanFlag(this.scala$reflect$api$Printers$BooleanFlag$$$outer(), value);
        }

        public Option<Object> copy$default$1() {
            return this.value();
        }

        @Override
        public String productPrefix() {
            return "BooleanFlag";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.value();
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
            return x$1 instanceof BooleanFlag;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        public String toString() {
            return ScalaRunTime$.MODULE$._toString(this);
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof BooleanFlag && ((BooleanFlag)x$1).scala$reflect$api$Printers$BooleanFlag$$$outer() == this.scala$reflect$api$Printers$BooleanFlag$$$outer();
                    if (!bl) break block3;
                    BooleanFlag booleanFlag = (BooleanFlag)x$1;
                    Option<Object> option = this.value();
                    Option<Object> option2 = booleanFlag.value();
                    if (!(!(option != null ? !option.equals(option2) : option2 != null) && booleanFlag.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ Universe scala$reflect$api$Printers$BooleanFlag$$$outer() {
            return this.$outer;
        }

        public BooleanFlag(Universe $outer, Option<Object> value) {
            this.value = value;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Product.$init$(this);
        }
    }

    public interface TreePrinter {
        public void print(Seq<Object> var1);

        public boolean printTypes();

        public void printTypes_$eq(boolean var1);

        public boolean printIds();

        public void printIds_$eq(boolean var1);

        public boolean printOwners();

        public void printOwners_$eq(boolean var1);

        public boolean printKinds();

        public void printKinds_$eq(boolean var1);

        public boolean printMirrors();

        public void printMirrors_$eq(boolean var1);

        public boolean printPositions();

        public void printPositions_$eq(boolean var1);

        public static /* synthetic */ TreePrinter withTypes$(TreePrinter $this) {
            return $this.withTypes();
        }

        default public TreePrinter withTypes() {
            this.printTypes_$eq(true);
            return this;
        }

        public static /* synthetic */ TreePrinter withoutTypes$(TreePrinter $this) {
            return $this.withoutTypes();
        }

        default public TreePrinter withoutTypes() {
            this.printTypes_$eq(false);
            return this;
        }

        public static /* synthetic */ TreePrinter withIds$(TreePrinter $this) {
            return $this.withIds();
        }

        default public TreePrinter withIds() {
            this.printIds_$eq(true);
            return this;
        }

        public static /* synthetic */ TreePrinter withoutIds$(TreePrinter $this) {
            return $this.withoutIds();
        }

        default public TreePrinter withoutIds() {
            this.printIds_$eq(false);
            return this;
        }

        public static /* synthetic */ TreePrinter withOwners$(TreePrinter $this) {
            return $this.withOwners();
        }

        default public TreePrinter withOwners() {
            this.printOwners_$eq(true);
            return this;
        }

        public static /* synthetic */ TreePrinter withoutOwners$(TreePrinter $this) {
            return $this.withoutOwners();
        }

        default public TreePrinter withoutOwners() {
            this.printOwners_$eq(false);
            return this;
        }

        public static /* synthetic */ TreePrinter withKinds$(TreePrinter $this) {
            return $this.withKinds();
        }

        default public TreePrinter withKinds() {
            this.printKinds_$eq(true);
            return this;
        }

        public static /* synthetic */ TreePrinter withoutKinds$(TreePrinter $this) {
            return $this.withoutKinds();
        }

        default public TreePrinter withoutKinds() {
            this.printKinds_$eq(false);
            return this;
        }

        public static /* synthetic */ TreePrinter withMirrors$(TreePrinter $this) {
            return $this.withMirrors();
        }

        default public TreePrinter withMirrors() {
            this.printMirrors_$eq(true);
            return this;
        }

        public static /* synthetic */ TreePrinter withoutMirrors$(TreePrinter $this) {
            return $this.withoutMirrors();
        }

        default public TreePrinter withoutMirrors() {
            this.printMirrors_$eq(false);
            return this;
        }

        public static /* synthetic */ TreePrinter withPositions$(TreePrinter $this) {
            return $this.withPositions();
        }

        default public TreePrinter withPositions() {
            this.printPositions_$eq(true);
            return this;
        }

        public static /* synthetic */ TreePrinter withoutPositions$(TreePrinter $this) {
            return $this.withoutPositions();
        }

        default public TreePrinter withoutPositions() {
            this.printPositions_$eq(false);
            return this;
        }

        public /* synthetic */ Printers scala$reflect$api$Printers$TreePrinter$$$outer();

        public static void $init$(TreePrinter $this) {
            $this.printTypes_$eq(false);
            $this.printIds_$eq(false);
            $this.printOwners_$eq(false);
            $this.printKinds_$eq(false);
            $this.printMirrors_$eq(false);
            $this.printPositions_$eq(false);
        }
    }
}

