/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.api;

import scala.Function0;
import scala.Function1;
import scala.ScalaReflectionException;
import scala.collection.LinearSeqOptimized;
import scala.collection.immutable.List;
import scala.collection.immutable.Set;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Annotations;
import scala.reflect.api.Names;
import scala.reflect.api.Position;
import scala.reflect.api.Types;
import scala.reflect.io.AbstractFile;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\r%d\u0001DA\b\u0003#\u0001\n1!\u0001\u0002 \r\u0005\u0004bBA\u0015\u0001\u0011\u0005\u00111\u0006\u0003\b\u0003g\u0001!\u0011AA\u001b\t\u001d\ty\n\u0001B\u0001\u0003C#q!a@\u0001\u0005\u0003\u0011\t\u0001B\u0004\u0003>\u0001\u0011\tAa\u0010\u0005\u000f\t%\u0004A!\u0001\u0003l\u00119!1\u0011\u0001\u0003\u0002\t\u0015\u0005\"CB0\u0001\t\u0007i\u0011AA'\r-\t9\u0005\u0001I\u0001\u0004\u0003\tI%a\u0014\t\u000f\u0005%\u0012\u0002\"\u0001\u0002,!9\u00111J\u0005\u0007\u0002\u00055CaBA)\u0013\t\u0005\u00111\u000b\u0005\b\u0003?Ja\u0011AA1\u0011\u001d\t9'\u0003D\u0001\u0003SBq!!!\n\r\u0003\t\u0019\tC\u0004\u0002\u0010&!\t!!%\t\u000f\u0005e\u0015\u0002\"\u0001\u0002\u001c\"9\u0011q_\u0005\u0005\u0002\u0005E\u0005bBA}\u0013\u0011\u0005\u00111 \u0005\b\u0005gIA\u0011AAI\u0011\u001d\u0011)$\u0003D\u0001\u0003#CqAa\u000e\n\t\u0003\u0011I\u0004C\u0004\u0003$%!\t\"!%\t\u000f\t\u0005\u0014\u0002\"\u0001\u0002\u0012\"9!1M\u0005\u0005\u0002\t\u0015\u0004b\u0002B=\u0013\u0011\u0005\u0011\u0011\u0013\u0005\b\u0005wJA\u0011AAI\u0011\u001d\u0011i(\u0003C\u0001\u0005\u007fBqA!0\n\r\u0003\u0011y\fC\u0004\u0003T&1\tA!6\t\u000f\t\r\u0018B\"\u0001\u0002N!9!1^\u0005\u0007\u0002\u00055\u0003b\u0002Bw\u0013\u0019\u0005!q\u001e\u0005\b\u0005gLa\u0011\u0001B{\u0011\u001d\u0011I0\u0003D\u0001\u0003kCqAa?\n\r\u0003\t)\fC\u0004\u0003~&1\t!a:\t\u000f\r\u0015\u0011B\"\u0001\u0002h\"91qA\u0005\u0007\u0002\u0005\u001d\bbBB\u0005\u0013\u0019\u0005\u0011\u0011\u0013\u0005\b\u0007\u0017Ia\u0011AAI\u0011\u001d\u0019i!\u0003D\u0001\u0003#Cqaa\u0004\n\r\u0003\t\t\nC\u0004\u0004\u0012%1\t!!%\t\u000f\rM\u0011B\"\u0001\u0002\u0012\"91QC\u0005\u0007\u0002\u0005E\u0005bBB\f\u0013\u0019\u0005\u0011Q\n\u0005\b\u00073Ia\u0011AAI\u0011\u001d\u0019Y\"\u0003D\u0001\u0003#Cqa!\b\n\r\u0003\t\t\nC\u0004\u0004 %1\t!!%\t\u000f\r\u0005\u0012B\"\u0001\u0002\u0012\"911E\u0005\u0007\u0002\u0005E\u0005bBB\u0013\u0013\u0019\u0005\u0011\u0011\u0013\u0005\b\u0007OIa\u0011AAI\u0011\u001d\u0019I#\u0003D\u0001\u0003#Cqaa\u000b\n\r\u0003\t\t\nC\u0004\u0004.%1\t!!%\t\u000f\r=\u0012B\"\u0001\u0002\u0012\"91\u0011G\u0005\u0007\u0002\u0005E\u0005bBB\u001a\u0013\u0019\u00051Q\u0007\u0005\b\u0007\u0003Ja\u0011AB\"\u0011\u001d\u0019y%\u0003D\u0001\u0007#Bqa!\u0017\n\r\u0003\u0019YFB\u0006\u0003\n\u0001\u0001\n1!\u0001\u0003\f\u0005u\bbBA\u0015\u0003\u0012\u0005\u00111F\u0003\u0007\u0003#\n%A!\u0004\t\u000f\u0005]\u0018\t\"\u0012\u0002\u0012\"9\u0011\u0011`!\u0005F\u0005m\bb\u0002B\n\u0003\u001a\u0005\u0011\u0011\u0013\u0005\b\u0005+\te\u0011AAI\u0011\u001d\u00119\"\u0011D\u0001\u0003#CqA!\u0007B\r\u0003\t\t\nC\u0004\u0003\u001c\u00053\t!!%\t\u000f\tu\u0011I\"\u0001\u0002\u0012\"9!qD!\u0007\u0002\u0005E\u0005b\u0002B\u0011\u0003\u001a\u0005\u0011\u0011\u0013\u0005\b\u0005G\tE\u0011KAI\u0011\u001d\u0011)#\u0011D\u0001\u0003\u001bBqAa\nB\r\u0003\ti\u0005C\u0004\u0003*\u00053\t!!\u0014\t\u000f\t-\u0012I\"\u0001\u0002\u0012\"9!QF!\u0007\u0002\u0005E\u0005b\u0002B\u0018\u0003\u001a\u0005\u0011\u0011\u0013\u0005\b\u0005c\te\u0011AAI\r-\tI\u000b\u0001I\u0001\u0004\u0003\tY+!(\t\u000f\u0005%b\u000b\"\u0001\u0002,\u00151\u0011\u0011\u000b,\u0003\u0003[Cq!a-W\r\u0003\t)\fC\u0004\u0002BZ3\t!a1\t\u000f\u0005%gK\"\u0001\u00026\"9\u0011q\u0012,\u0005F\u0005E\u0005bBAM-\u0012\u0015\u00131\u0014\u0005\b\u0003\u00174f\u0011AAI\u0011\u001d\tiM\u0016D\u0001\u0003#Cq!a4W\r\u0003\t\t\nC\u0004\u0002RZ3\t!!%\t\u000f\u0005\rhK\"\u0001\u0002\u0012\"9\u0011Q\u001d,\u0007\u0002\u0005\u001dha\u0003B$\u0001A\u0005\u0019\u0011\u0001B%\u0005wAq!!\u000be\t\u0003\tY\u0003C\u0004\u00034\u0011$)%!%\t\u000f\t]B\r\"\u0012\u0003:!9!1\n3\u0007\u0002\u0005E\u0005bBAsI\u001a\u0005\u0011q\u001d\u0005\b\u0005\u001b\"g\u0011\u0001B(\u0011\u001d\u0011I\u0006\u001aD\u0001\u0005\u001fBqAa\u0017e\r\u0003\t\t\nC\u0004\u0003^\u00114\t!!.\t\u000f\t}CM\"\u0001\u0002h\u001aY!1\u000f\u0001\u0011\u0002\u0007\u0005!Q\u000fB4\u0011\u001d\tIc\u001cC\u0001\u0003WAqAa\u001ep\r\u0003\ti\u0005C\u0004\u0003b=$)%!%\t\u000f\t\rt\u000e\"\u0012\u0003f\u0019Y!Q\u0012\u0001\u0011\u0002\u0007\u0005!q\u0012BA\u0011\u001d\tI\u0003\u001eC\u0001\u0003WAqA!\u001fu\t\u000b\n\t\nC\u0004\u0003~Q$)Ea \t\u000f\tEEO\"\u0001\u0002\u0012\"9!1\u0013;\u0007\u0002\u0005E\u0005b\u0002BKi\u001a\u0005\u0011\u0011\u0013\u0005\b\u0005/#h\u0011AAI\u0011\u001d\u0011I\n\u001eD\u0001\u0003#CqA!(u\r\u0003\t\t\nC\u0004\u0003 R4\t!!%\t\u000f\t\u0005FO\"\u0001\u0003$\"9!1\u0016;\u0007\u0002\u0005\u001d\bb\u0002BWi\u001a\u0005\u0011Q\n\u0005\b\u0005_#h\u0011AA[\u0011\u001d\u0011\t\f\u001eD\u0001\u0003kCqAa-u\r\u0003\u0011)\fC\u0004\u0002fR4\t!a:\t\u000f\tmFO\"\u0001\u0002N\t91+_7c_2\u001c(\u0002BA\n\u0003+\t1!\u00199j\u0015\u0011\t9\"!\u0007\u0002\u000fI,g\r\\3di*\u0011\u00111D\u0001\u0006g\u000e\fG.Y\u0002\u0001'\r\u0001\u0011\u0011\u0005\t\u0005\u0003G\t)#\u0004\u0002\u0002\u001a%!\u0011qEA\r\u0005\u0019\te.\u001f*fM\u00061A%\u001b8ji\u0012\"\"!!\f\u0011\t\u0005\r\u0012qF\u0005\u0005\u0003c\tIB\u0001\u0003V]&$(AB*z[\n|G.\u0005\u0003\u00028\u0005u\u0002\u0003BA\u0012\u0003sIA!a\u000f\u0002\u001a\t!a*\u001e7m%\u0019\ty$!\t\u0002D\u00191\u0011\u0011\t\u0001\u0001\u0003{\u0011A\u0002\u0010:fM&tW-\\3oiz\u00022!!\u0012\n\u001b\u0005\u0001!!C*z[\n|G.\u00119j'\rI\u0011\u0011E\u0001\u0006_^tWM]\u000b\u0003\u0003\u001f\u00022!!\u0012\u0003\u0005!q\u0015-\\3UsB,\u0017\u0003BA\u001c\u0003+\u0002B!!\u0012\u0002X%!\u0011\u0011LA.\u0005\u0011q\u0015-\\3\n\t\u0005u\u0013\u0011\u0003\u0002\u0006\u001d\u0006lWm]\u0001\u0005]\u0006lW-\u0006\u0002\u0002dA\u0019\u0011Q\r\u0007\u000e\u0003%\t\u0001BZ;mY:\u000bW.Z\u000b\u0003\u0003W\u0002B!!\u001c\u0002|9!\u0011qNA<!\u0011\t\t(!\u0007\u000e\u0005\u0005M$\u0002BA;\u0003;\ta\u0001\u0010:p_Rt\u0014\u0002BA=\u00033\ta\u0001\u0015:fI\u00164\u0017\u0002BA?\u0003\u007f\u0012aa\u0015;sS:<'\u0002BA=\u00033\t1\u0001]8t+\t\t)\t\u0005\u0003\u0002F\u0005\u001d\u0015\u0002BAE\u0003\u0017\u0013\u0001\u0002U8tSRLwN\\\u0005\u0005\u0003\u001b\u000b\tBA\u0005Q_NLG/[8og\u00061\u0011n\u001d+za\u0016,\"!a%\u0011\t\u0005\r\u0012QS\u0005\u0005\u0003/\u000bIBA\u0004C_>dW-\u00198\u0002\r\u0005\u001cH+\u001f9f+\t\ti\nE\u0002\u0002F\r\u0011!\u0002V=qKNKXNY8m#\u0011\t9$a)\u0013\r\u0005\u0015\u0016qUA(\r\u0019\t\t\u0005\u0001\u0001\u0002$B\u0019\u0011Q\t,\u0003\u001bQK\b/Z*z[\n|G.\u00119j'\u00151\u0016\u0011EA\"!\u0011\t)%a,\n\t\u0005E\u00161\f\u0002\t)f\u0004XMT1nK\u0006\tBo\u001c+za\u0016\u001cuN\\:ueV\u001cGo\u001c:\u0016\u0005\u0005]\u0006\u0003BA#\u0003sKA!a/\u0002>\n!A+\u001f9f\u0013\u0011\ty,!\u0005\u0003\u000bQK\b/Z:\u0002\u0011Q|G+\u001f9f\u0013:$B!a.\u0002F\"9\u0011q\u0019.A\u0002\u0005]\u0016\u0001B:ji\u0016\fa\u0001^8UsB,\u0017aD5t\u0007>tGO]1wCJL\u0017M\u001c;\u0002\u0017%\u001c8i\u001c<be&\fg\u000e^\u0001\fSN\fE.[1t)f\u0004X-\u0001\bjg\u0006\u00137\u000f\u001e:bGR$\u0016\u0010]3)\u000f\u0005\f).a7\u0002`B!\u00111EAl\u0013\u0011\tI.!\u0007\u0003\u0015\u0011,\u0007O]3dCR,G-\t\u0002\u0002^\u00061Ro]3!SN\f%m\u001d;sC\u000e$\b%\u001b8ti\u0016\fG-\t\u0002\u0002b\u00061!GL\u00192]A\nQ\"[:Fq&\u001cH/\u001a8uS\u0006d\u0017A\u0003;za\u0016\u0004\u0016M]1ngV\u0011\u0011\u0011\u001e\t\u0007\u0003W\f\t0a\u0014\u000f\t\u0005\r\u0012Q^\u0005\u0005\u0003_\fI\"A\u0004qC\u000e\\\u0017mZ3\n\t\u0005M\u0018Q\u001f\u0002\u0005\u0019&\u001cHO\u0003\u0003\u0002p\u0006e\u0011AB5t)\u0016\u0014X.\u0001\u0004bgR+'/\\\u000b\u0003\u0003{\u00042!!\u0012\u0005\u0005)!VM]7Ts6\u0014w\u000e\\\t\u0005\u0003o\u0011\u0019A\u0005\u0004\u0003\u0006\t\u001d\u0011q\n\u0004\u0007\u0003\u0003\u0002\u0001Aa\u0001\u0011\u0007\u0005\u0015\u0013IA\u0007UKJl7+_7c_2\f\u0005/[\n\u0006\u0003\u0006\u0005\u00121\t\t\u0005\u0003\u000b\u0012y!\u0003\u0003\u0003\u0012\u0005m#\u0001\u0003+fe6t\u0015-\\3\u0002\u000b%\u001ch+\u00197\u0002\u0011%\u001c8\u000b^1cY\u0016\fQ![:WCJ\f!\"[:BG\u000e,7o]8s\u0003!I7oR3ui\u0016\u0014\u0018\u0001C5t'\u0016$H/\u001a:\u0002\u0019%\u001cxJ^3sY>\fG-\u001a3\u0002\r%\u001cH*\u0019>z\u0003II7o\u0014<fe2|\u0017\rZ3e\u001b\u0016$\bn\u001c3\u0002\u0011\u0005\u001c7-Z:tK\u0012\faaZ3ui\u0016\u0014\u0018AB:fiR,'/A\bjgB\u000b'/Y7BG\u000e,7o]8s\u00039I7oQ1tK\u0006\u001b7-Z:t_J\f!#[:QCJ\fWnV5uQ\u0012+g-Y;mi\u0006i\u0011n\u001d\"z\u001d\u0006lW\rU1sC6\f\u0001\"[:NKRDw\u000eZ\u0001\u000eSN\u001cuN\\:ueV\u001cGo\u001c:\u0002\u0011\u0005\u001cX*\u001a;i_\u0012,\"Aa\u000f\u0011\u0007\u0005\u0015SA\u0001\u0007NKRDw\u000eZ*z[\n|G.\u0005\u0003\u00028\t\u0005#C\u0002B\"\u0005\u000b\niP\u0002\u0004\u0002B\u0001\u0001!\u0011\t\t\u0004\u0003\u000b\"'aD'fi\"|GmU=nE>d\u0017\t]5\u0014\u000b\u0011\f\tCa\u0002\u0002)%\u001c\bK]5nCJL8i\u001c8tiJ,8\r^8s\u0003\u001d\u0001\u0018M]1ngN,\"A!\u0015\u0011\r\u0005-\u0018\u0011_AuQ\u001dQ\u0017Q\u001bB+\u0003?\f#Aa\u0016\u00021U\u001cX\r\t1qCJ\fW\u000eT5tiN\u0004\u0007%\u001b8ti\u0016\fG-\u0001\u0006qCJ\fW\u000eT5tiN\f\u0011\"[:WCJ\f'oZ:\u0002\u0015I,G/\u001e:o)f\u0004X-\u0001\u0006fq\u000e,\u0007\u000f^5p]N\f\u0001\"[:N_\u0012,H.Z\u0001\tCNlu\u000eZ;mKV\u0011!q\r\t\u0004\u0003\u000b2!\u0001D'pIVdWmU=nE>d\u0017\u0003BA\u001c\u0005[\u0012bAa\u001c\u0003r\u0005uhABA!\u0001\u0001\u0011i\u0007E\u0002\u0002F=\u0014q\"T8ek2,7+_7c_2\f\u0005/[\n\u0006_\u0006\u0005\"qA\u0001\f[>$W\u000f\\3DY\u0006\u001c8/A\u0004jg\u000ec\u0017m]:\u0002\u001b%\u001cXj\u001c3vY\u0016\u001cE.Y:t\u0003\u001d\t7o\u00117bgN,\"A!!\u0011\u0007\u0005\u0015sAA\u0006DY\u0006\u001c8oU=nE>d\u0017\u0003BA\u001c\u0005\u000f\u0013bA!#\u0003\f\u0006ueABA!\u0001\u0001\u00119\tE\u0002\u0002FQ\u0014ab\u00117bgN\u001c\u00160\u001c2pY\u0006\u0003\u0018nE\u0003u\u0003C\t9+A\u0006jgB\u0013\u0018.\\5uSZ,\u0017!C5t\u001dVlWM]5d\u0003MI7\u000fR3sSZ,GMV1mk\u0016\u001cE.Y:t\u0003\u001dI7\u000f\u0016:bSR\fq\"[:BEN$(/Y2u\u00072\f7o\u001d\u0015\by\u0006U\u00171\\Ap\u0003-I7oQ1tK\u000ec\u0017m]:\u0002\u0011%\u001c8+Z1mK\u0012\fQc\u001b8po:$\u0015N]3diN+(m\u00197bgN,7/\u0006\u0002\u0003&B1\u0011Q\u000eBT\u0003\u001fJAA!+\u0002\u0000\t\u00191+\u001a;\u0002\u0017\t\f7/Z\"mCN\u001cXm]\u0001\u0007[>$W\u000f\\3\u0002\u0011M,GN\u001a+za\u0016\f!\u0002\u001e5jgB\u0013XMZ5y\u0003-\u0019X\u000f]3s!J,g-\u001b=\u0015\t\u0005]&q\u0017\u0005\t\u0005s\u000bI\u00011\u0001\u00028\u0006A1/\u001e9feR\u0004X-\u0001\nqe&l\u0017M]=D_:\u001cHO];di>\u0014\u0018AD1tg>\u001c\u0017.\u0019;fI\u001aKG.Z\u000b\u0003\u0005\u0003\u0004BAa1\u0003J6\u0011!Q\u0019\u0006\u0005\u0005\u000f\f)\"\u0001\u0002j_&!!1\u001aBc\u00051\t%m\u001d;sC\u000e$h)\u001b7fQ\u001di\u0012Q\u001bBh\u0003?\f#A!5\u0002;U\u001cX\r\t1q_Nt3o\\;sG\u0016tc-\u001b7fA\u0002Jgn\u001d;fC\u0012\f1\"\u00198o_R\fG/[8ogV\u0011!q\u001b\t\u0007\u0003W\f\tP!7\u0011\t\u0005\u0015#1\\\u0005\u0005\u0005;\u0014yN\u0001\u0006B]:|G/\u0019;j_:LAA!9\u0002\u0012\tY\u0011I\u001c8pi\u0006$\u0018n\u001c8t\u0003=\u0019w.\u001c9b]&|gnU=nE>d\u0007fB\u0010\u0002V\n\u001d\u0018q\\\u0011\u0003\u0005S\f1)^:fA\u0001\u001cw.\u001c9b]&|g\u000e\u0019\u0011j]N$X-\u00193-A\t,H\u000f\t2fo\u0006\u0014X\rI8gAA|7o]5cY\u0016\u00043\r[1oO\u0016\u001c\b%\u001b8!E\u0016D\u0017M^5pe\u0006I1m\\7qC:LwN\\\u0001\u0010if\u0004XmU5h]\u0006$XO]3J]R!\u0011q\u0017By\u0011\u001d\t9-\ta\u0001\u0003o\u000ba!\u001b8g_&sG\u0003BA\\\u0005oDq!a2#\u0001\u0004\t9,A\u0007usB,7+[4oCR,(/Z\u0001\u0005S:4w.\u0001\u000bbY2|e/\u001a:sS\u0012$WM\\*z[\n|Gn\u001d\u0015\bK\u0005U7\u0011AApC\t\u0019\u0019!A\fvg\u0016\u0004\u0003m\u001c<feJLG-Z:aA%t7\u000f^3bI\u0006IqN^3se&$Wm]\u0001\rC2$XM\u001d8bi&4Xm]\u0001\fSN\u001c\u0016P\u001c;iKRL7-\u0001\rjg&k\u0007\u000f\\3nK:$\u0018\r^5p]\u0006\u0013H/\u001b4bGR\fQ\"[:Qe&4\u0018\r^3UQ&\u001c\u0018!C5t!JLg/\u0019;f\u0003=I7\u000f\u0015:pi\u0016\u001cG/\u001a3UQ&\u001c\u0018aC5t!J|G/Z2uK\u0012\f\u0001\"[:Qk\nd\u0017nY\u0001\u000eaJLg/\u0019;f/&$\b.\u001b8\u0002\u0013%\u001c\b+Y2lC\u001e,\u0017AD5t!\u0006\u001c7.Y4f\u00072\f7o]\u0001\tSN\u001cF/\u0019;jG\u00069\u0011n\u001d$j]\u0006d\u0017AC5t\u0003\n\u001cHO]1di\u0006\u0011\u0012n]!cgR\u0014\u0018m\u0019;Pm\u0016\u0014(/\u001b3f\u0003\u001dI7/T1de>\f1\"[:QCJ\fW.\u001a;fe\u0006i\u0011n]*qK\u000eL\u0017\r\\5{K\u0012\fa![:KCZ\f\u0017AC5t\u00136\u0004H.[2ji\u0006Q\u0011n\u001d&bm\u0006,e.^7\u0002!%\u001c(*\u0019<b\u0003:tw\u000e^1uS>t\u0017AB8s\u000b2\u001cX\r\u0006\u0003\u0002P\r]\u0002\u0002CB\u001d{\u0011\u0005\raa\u000f\u0002\u0007\u0005dG\u000f\u0005\u0004\u0002$\ru\u0012qJ\u0005\u0005\u0007\u007f\tIB\u0001\u0005=Eft\u0017-\\3?\u0003\u00191\u0017\u000e\u001c;feR!\u0011qJB#\u0011\u001d\u00199E\u0010a\u0001\u0007\u0013\nAaY8oIBA\u00111EB&\u0003\u001f\n\u0019*\u0003\u0003\u0004N\u0005e!!\u0003$v]\u000e$\u0018n\u001c82\u0003\ri\u0017\r\u001d\u000b\u0005\u0003\u001f\u001a\u0019\u0006C\u0004\u0004V}\u0002\raa\u0016\u0002\u0003\u0019\u0004\u0002\"a\t\u0004L\u0005=\u0013qJ\u0001\tgV\u001c\u0007\u000e\u00165biR!\u0011qJB/\u0011\u001d\u00199\u0005\u0011a\u0001\u0007\u0013\n\u0001BT8Ts6\u0014w\u000e\u001c\t\u0005\u0007G\u001a)'\u0004\u0002\u0002\u0012%!1qMA\t\u0005!)f.\u001b<feN,\u0007")
public interface Symbols {
    public SymbolApi NoSymbol();

    public static void $init$(Symbols $this) {
    }

    public interface ClassSymbolApi
    extends TypeSymbolApi {
        public static /* synthetic */ boolean isClass$(ClassSymbolApi $this) {
            return $this.isClass();
        }

        @Override
        default public boolean isClass() {
            return true;
        }

        public static /* synthetic */ ClassSymbolApi asClass$(ClassSymbolApi $this) {
            return $this.asClass();
        }

        @Override
        default public ClassSymbolApi asClass() {
            return this;
        }

        public boolean isPrimitive();

        public boolean isNumeric();

        public boolean isDerivedValueClass();

        public boolean isTrait();

        public boolean isAbstractClass();

        public boolean isCaseClass();

        public boolean isSealed();

        public Set<SymbolApi> knownDirectSubclasses();

        public List<SymbolApi> baseClasses();

        public SymbolApi module();

        public Types.TypeApi selfType();

        public Types.TypeApi thisPrefix();

        public Types.TypeApi superPrefix(Types.TypeApi var1);

        @Override
        public List<SymbolApi> typeParams();

        public SymbolApi primaryConstructor();

        public /* synthetic */ Symbols scala$reflect$api$Symbols$ClassSymbolApi$$$outer();

        public static void $init$(ClassSymbolApi $this) {
        }
    }

    public interface MethodSymbolApi
    extends TermSymbolApi {
        public static /* synthetic */ boolean isMethod$(MethodSymbolApi $this) {
            return $this.isMethod();
        }

        @Override
        default public boolean isMethod() {
            return true;
        }

        public static /* synthetic */ MethodSymbolApi asMethod$(MethodSymbolApi $this) {
            return $this.asMethod();
        }

        @Override
        default public MethodSymbolApi asMethod() {
            return this;
        }

        public boolean isPrimaryConstructor();

        public List<SymbolApi> typeParams();

        public List<List<SymbolApi>> paramss();

        public List<List<SymbolApi>> paramLists();

        public boolean isVarargs();

        public Types.TypeApi returnType();

        public List<SymbolApi> exceptions();

        public /* synthetic */ Symbols scala$reflect$api$Symbols$MethodSymbolApi$$$outer();

        public static void $init$(MethodSymbolApi $this) {
        }
    }

    public interface ModuleSymbolApi
    extends TermSymbolApi {
        public SymbolApi moduleClass();

        public static /* synthetic */ boolean isModule$(ModuleSymbolApi $this) {
            return $this.isModule();
        }

        @Override
        default public boolean isModule() {
            return true;
        }

        public static /* synthetic */ ModuleSymbolApi asModule$(ModuleSymbolApi $this) {
            return $this.asModule();
        }

        @Override
        default public ModuleSymbolApi asModule() {
            return this;
        }

        public /* synthetic */ Symbols scala$reflect$api$Symbols$ModuleSymbolApi$$$outer();

        public static void $init$(ModuleSymbolApi $this) {
        }
    }

    public interface SymbolApi {
        public SymbolApi owner();

        public Names.NameApi name();

        public String fullName();

        public Position pos();

        public static /* synthetic */ boolean isType$(SymbolApi $this) {
            return $this.isType();
        }

        default public boolean isType() {
            return false;
        }

        public static /* synthetic */ TypeSymbolApi asType$(SymbolApi $this) {
            return $this.asType();
        }

        default public TypeSymbolApi asType() {
            throw new ScalaReflectionException(new StringBuilder(14).append(this).append(" is not a type").toString());
        }

        public static /* synthetic */ boolean isTerm$(SymbolApi $this) {
            return $this.isTerm();
        }

        default public boolean isTerm() {
            return false;
        }

        public static /* synthetic */ TermSymbolApi asTerm$(SymbolApi $this) {
            return $this.asTerm();
        }

        default public TermSymbolApi asTerm() {
            throw new ScalaReflectionException(new StringBuilder(14).append(this).append(" is not a term").toString());
        }

        public static /* synthetic */ boolean isMethod$(SymbolApi $this) {
            return $this.isMethod();
        }

        default public boolean isMethod() {
            return false;
        }

        public boolean isConstructor();

        public static /* synthetic */ MethodSymbolApi asMethod$(SymbolApi $this) {
            return $this.asMethod();
        }

        default public MethodSymbolApi asMethod() {
            String msg = this.isOverloadedMethod() ? SymbolApi.overloadedMsg$1() : SymbolApi.vanillaMsg$1();
            throw new ScalaReflectionException(new StringBuilder(1).append(this).append(" ").append(msg).toString());
        }

        public static /* synthetic */ boolean isOverloadedMethod$(SymbolApi $this) {
            return $this.isOverloadedMethod();
        }

        default public boolean isOverloadedMethod() {
            return false;
        }

        public static /* synthetic */ boolean isModule$(SymbolApi $this) {
            return $this.isModule();
        }

        default public boolean isModule() {
            return false;
        }

        public static /* synthetic */ ModuleSymbolApi asModule$(SymbolApi $this) {
            return $this.asModule();
        }

        default public ModuleSymbolApi asModule() {
            throw new ScalaReflectionException(new StringBuilder(16).append(this).append(" is not a module").toString());
        }

        public static /* synthetic */ boolean isClass$(SymbolApi $this) {
            return $this.isClass();
        }

        default public boolean isClass() {
            return false;
        }

        public static /* synthetic */ boolean isModuleClass$(SymbolApi $this) {
            return $this.isModuleClass();
        }

        default public boolean isModuleClass() {
            return false;
        }

        public static /* synthetic */ ClassSymbolApi asClass$(SymbolApi $this) {
            return $this.asClass();
        }

        default public ClassSymbolApi asClass() {
            throw new ScalaReflectionException(new StringBuilder(15).append(this).append(" is not a class").toString());
        }

        public AbstractFile associatedFile();

        public List<Annotations.AnnotationApi> annotations();

        public SymbolApi companionSymbol();

        public SymbolApi companion();

        public Types.TypeApi typeSignatureIn(Types.TypeApi var1);

        public Types.TypeApi infoIn(Types.TypeApi var1);

        public Types.TypeApi typeSignature();

        public Types.TypeApi info();

        public List<SymbolApi> allOverriddenSymbols();

        public List<SymbolApi> overrides();

        public List<SymbolApi> alternatives();

        public boolean isSynthetic();

        public boolean isImplementationArtifact();

        public boolean isPrivateThis();

        public boolean isPrivate();

        public boolean isProtectedThis();

        public boolean isProtected();

        public boolean isPublic();

        public SymbolApi privateWithin();

        public boolean isPackage();

        public boolean isPackageClass();

        public boolean isStatic();

        public boolean isFinal();

        public boolean isAbstract();

        public boolean isAbstractOverride();

        public boolean isMacro();

        public boolean isParameter();

        public boolean isSpecialized();

        public boolean isJava();

        public boolean isImplicit();

        public boolean isJavaEnum();

        public boolean isJavaAnnotation();

        public SymbolApi orElse(Function0<SymbolApi> var1);

        public SymbolApi filter(Function1<SymbolApi, Object> var1);

        public SymbolApi map(Function1<SymbolApi, SymbolApi> var1);

        public SymbolApi suchThat(Function1<SymbolApi, Object> var1);

        public /* synthetic */ Symbols scala$reflect$api$Symbols$SymbolApi$$$outer();

        private static String overloadedMsg$1() {
            return "encapsulates multiple overloaded alternatives and cannot be treated as a method. Consider invoking `<offending symbol>.asTerm.alternatives` and manually picking the required method";
        }

        private static String vanillaMsg$1() {
            return "is not a method";
        }

        public static void $init$(SymbolApi $this) {
        }
    }

    public interface TermSymbolApi
    extends SymbolApi {
        public static /* synthetic */ boolean isTerm$(TermSymbolApi $this) {
            return $this.isTerm();
        }

        @Override
        default public boolean isTerm() {
            return true;
        }

        public static /* synthetic */ TermSymbolApi asTerm$(TermSymbolApi $this) {
            return $this.asTerm();
        }

        @Override
        default public TermSymbolApi asTerm() {
            return this;
        }

        public boolean isVal();

        public boolean isStable();

        public boolean isVar();

        public boolean isAccessor();

        public boolean isGetter();

        public boolean isSetter();

        public boolean isOverloaded();

        public boolean isLazy();

        public static /* synthetic */ boolean isOverloadedMethod$(TermSymbolApi $this) {
            return $this.isOverloadedMethod();
        }

        @Override
        default public boolean isOverloadedMethod() {
            boolean bl;
            block3: {
                List<SymbolApi> list = this.alternatives();
                if (list == null) {
                    throw null;
                }
                LinearSeqOptimized exists_these = list;
                while (!exists_these.isEmpty()) {
                    if (((SymbolApi)exists_these.head()).isMethod()) {
                        bl = true;
                        break block3;
                    }
                    exists_these = (LinearSeqOptimized)exists_these.tail();
                }
                bl = false;
            }
            return bl;
        }

        public SymbolApi accessed();

        public SymbolApi getter();

        public SymbolApi setter();

        public boolean isParamAccessor();

        public boolean isCaseAccessor();

        public boolean isParamWithDefault();

        public boolean isByNameParam();

        public /* synthetic */ Symbols scala$reflect$api$Symbols$TermSymbolApi$$$outer();

        public static void $init$(TermSymbolApi $this) {
        }

        public static /* synthetic */ Object $anonfun$isOverloadedMethod$1$adapted(SymbolApi x$1) {
            return BoxesRunTime.boxToBoolean(x$1.isMethod());
        }
    }

    public interface TypeSymbolApi
    extends SymbolApi {
        public Types.TypeApi toTypeConstructor();

        public Types.TypeApi toTypeIn(Types.TypeApi var1);

        public Types.TypeApi toType();

        public static /* synthetic */ boolean isType$(TypeSymbolApi $this) {
            return $this.isType();
        }

        @Override
        default public boolean isType() {
            return true;
        }

        public static /* synthetic */ TypeSymbolApi asType$(TypeSymbolApi $this) {
            return $this.asType();
        }

        @Override
        default public TypeSymbolApi asType() {
            return this;
        }

        public boolean isContravariant();

        public boolean isCovariant();

        public boolean isAliasType();

        public boolean isAbstractType();

        public boolean isExistential();

        public List<SymbolApi> typeParams();

        public /* synthetic */ Symbols scala$reflect$api$Symbols$TypeSymbolApi$$$outer();

        public static void $init$(TypeSymbolApi $this) {
        }
    }
}

