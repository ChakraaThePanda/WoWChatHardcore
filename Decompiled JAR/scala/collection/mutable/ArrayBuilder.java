/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.util.Arrays;
import scala.Array$;
import scala.Function1;
import scala.Serializable;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.Growable;
import scala.collection.mutable.ArrayBuilder$;
import scala.collection.mutable.Builder;
import scala.collection.mutable.ReusableBuilder;
import scala.collection.mutable.WrappedArray;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;

@ScalaSignature(bytes="\u0006\u0001\u00115h\u0001CAQ\u0003G\u000b\t!!-\t\u000f\u0005\u001d\b\u0001\"\u0001\u0002j\u001eA\u0011Q^AR\u0011\u0003\tyO\u0002\u0005\u0002\"\u0006\r\u0006\u0012AAy\u0011\u001d\t9o\u0001C\u0001\u0003gDq!!>\u0004\t\u0003\t9P\u0002\u0004\u0003\u0014\r\u0011!Q\u0003\u0005\u000b\u0005C1!1!Q\u0001\f\t\r\u0002bBAt\r\u0011\u0005!Q\u0005\u0005\f\u0005_1\u0001\u0019!a\u0001\n\u0013\u0011\t\u0004C\u0006\u00036\u0019\u0001\r\u00111A\u0005\n\t]\u0002b\u0003B\"\r\u0001\u0007\t\u0011)Q\u0005\u0005gA\u0011B!\u0012\u0007\u0001\u0004%IAa\u0012\t\u0013\t=c\u00011A\u0005\n\tE\u0003\u0002\u0003B+\r\u0001\u0006KA!\u0013\t\u0013\t]c\u00011A\u0005\n\t\u001d\u0003\"\u0003B-\r\u0001\u0007I\u0011\u0002B.\u0011!\u0011yF\u0002Q!\n\t%\u0003b\u0002B1\r\u0011%!1\r\u0005\b\u0005O2A\u0011\u0002B5\u0011\u001d\u0011iG\u0002C!\u0005_BqAa\u001d\u0007\t\u0013\u0011)\bC\u0004\u0003z\u0019!\tAa\u001f\t\u000f\t\re\u0001\"\u0011\u0003\u0006\"9!1\u0013\u0004\u0005\u0002\tU\u0005b\u0002BL\r\u0011\u0005!\u0011\u0014\u0005\b\u000573A\u0011\tBO\u0011\u001d\u0011IK\u0002C!\u0005W3aA!0\u0004\u0005\t}\u0006bBAt9\u0011\u0005!\u0011\u001a\u0005\f\u0005_a\u0002\u0019!a\u0001\n\u0013\u0011i\rC\u0006\u00036q\u0001\r\u00111A\u0005\n\tE\u0007b\u0003B\"9\u0001\u0007\t\u0011)Q\u0005\u0005\u001fD\u0011B!\u0012\u001d\u0001\u0004%IAa\u0012\t\u0013\t=C\u00041A\u0005\n\tU\u0007\u0002\u0003B+9\u0001\u0006KA!\u0013\t\u0013\t]C\u00041A\u0005\n\t\u001d\u0003\"\u0003B-9\u0001\u0007I\u0011\u0002Bm\u0011!\u0011y\u0006\bQ!\n\t%\u0003b\u0002B19\u0011%!Q\u001c\u0005\b\u0005ObB\u0011\u0002Bq\u0011\u001d\u0011i\u0007\bC!\u0005KDqAa\u001d\u001d\t\u0013\u0011I\u000fC\u0004\u0003zq!\tA!<\t\u000f\t\rE\u0004\"\u0011\u0003t\"9!1\u0013\u000f\u0005\u0002\tU\u0005b\u0002BL9\u0011\u0005!\u0011 \u0005\b\u00057cB\u0011\tB~\u0011\u001d\u0011I\u000b\bC!\u0005W3aAa@\u0004\u0005\r\u0005\u0001bBAtc\u0011\u000511\u0002\u0005\f\u0005_\t\u0004\u0019!a\u0001\n\u0013\u0019y\u0001C\u0006\u00036E\u0002\r\u00111A\u0005\n\rM\u0001b\u0003B\"c\u0001\u0007\t\u0011)Q\u0005\u0007#A\u0011B!\u00122\u0001\u0004%IAa\u0012\t\u0013\t=\u0013\u00071A\u0005\n\r]\u0001\u0002\u0003B+c\u0001\u0006KA!\u0013\t\u0013\t]\u0013\u00071A\u0005\n\t\u001d\u0003\"\u0003B-c\u0001\u0007I\u0011BB\u000e\u0011!\u0011y&\rQ!\n\t%\u0003b\u0002B1c\u0011%1q\u0004\u0005\b\u0005O\nD\u0011BB\u0012\u0011\u001d\u0011i'\rC!\u0007OAqAa\u001d2\t\u0013\u0019Y\u0003C\u0004\u0003zE\"\taa\f\t\u000f\t\r\u0015\u0007\"\u0011\u00046!9!1S\u0019\u0005\u0002\tU\u0005b\u0002BLc\u0011\u000511\b\u0005\b\u00057\u000bD\u0011IB\u001f\u0011\u001d\u0011I+\rC!\u0005W3aa!\u0011\u0004\u0005\r\r\u0003bBAt\r\u0012\u00051Q\n\u0005\f\u0005_1\u0005\u0019!a\u0001\n\u0013\u0019\t\u0006C\u0006\u00036\u0019\u0003\r\u00111A\u0005\n\rU\u0003b\u0003B\"\r\u0002\u0007\t\u0011)Q\u0005\u0007'B\u0011B!\u0012G\u0001\u0004%IAa\u0012\t\u0013\t=c\t1A\u0005\n\re\u0003\u0002\u0003B+\r\u0002\u0006KA!\u0013\t\u0013\t]c\t1A\u0005\n\t\u001d\u0003\"\u0003B-\r\u0002\u0007I\u0011BB/\u0011!\u0011yF\u0012Q!\n\t%\u0003b\u0002B1\r\u0012%1\u0011\r\u0005\b\u0005O2E\u0011BB3\u0011\u001d\u0011iG\u0012C!\u0007SBqAa\u001dG\t\u0013\u0019i\u0007C\u0004\u0003z\u0019#\ta!\u001d\t\u000f\t\re\t\"\u0011\u0004x!9!1\u0013$\u0005\u0002\tU\u0005b\u0002BL\r\u0012\u00051Q\u0010\u0005\b\u000573E\u0011IB@\u0011\u001d\u0011IK\u0012C!\u0005W3aaa!\u0004\u0005\r\u0015\u0005bBAt7\u0012\u00051\u0011\u0012\u0005\f\u0005_Y\u0006\u0019!a\u0001\n\u0013\u0019i\tC\u0006\u00036m\u0003\r\u00111A\u0005\n\rE\u0005b\u0003B\"7\u0002\u0007\t\u0011)Q\u0005\u0007\u001fC\u0011B!\u0012\\\u0001\u0004%IAa\u0012\t\u0013\t=3\f1A\u0005\n\rU\u0005\u0002\u0003B+7\u0002\u0006KA!\u0013\t\u0013\t]3\f1A\u0005\n\t\u001d\u0003\"\u0003B-7\u0002\u0007I\u0011BBM\u0011!\u0011yf\u0017Q!\n\t%\u0003b\u0002B17\u0012%1Q\u0014\u0005\b\u0005OZF\u0011BBQ\u0011\u001d\u0011ig\u0017C!\u0007KCqAa\u001d\\\t\u0013\u0019I\u000bC\u0004\u0003zm#\ta!,\t\u000f\t\r5\f\"\u0011\u00044\"9!1S.\u0005\u0002\tU\u0005b\u0002BL7\u0012\u00051\u0011\u0018\u0005\b\u00057[F\u0011IB^\u0011\u001d\u0011Ik\u0017C!\u0005W3aaa0\u0004\u0005\r\u0005\u0007bBAta\u0012\u000511\u001a\u0005\f\u0005_\u0001\b\u0019!a\u0001\n\u0013\u0019y\rC\u0006\u00036A\u0004\r\u00111A\u0005\n\rM\u0007b\u0003B\"a\u0002\u0007\t\u0011)Q\u0005\u0007#D\u0011B!\u0012q\u0001\u0004%IAa\u0012\t\u0013\t=\u0003\u000f1A\u0005\n\r]\u0007\u0002\u0003B+a\u0002\u0006KA!\u0013\t\u0013\t]\u0003\u000f1A\u0005\n\t\u001d\u0003\"\u0003B-a\u0002\u0007I\u0011BBn\u0011!\u0011y\u0006\u001dQ!\n\t%\u0003b\u0002B1a\u0012%1q\u001c\u0005\b\u0005O\u0002H\u0011BBr\u0011\u001d\u0011i\u0007\u001dC!\u0007ODqAa\u001dq\t\u0013\u0019Y\u000fC\u0004\u0003zA$\taa<\t\u000f\t\r\u0005\u000f\"\u0011\u0004v\"9!1\u00139\u0005\u0002\tU\u0005b\u0002BLa\u0012\u000511 \u0005\b\u00057\u0003H\u0011IB\u007f\u0011\u001d\u0011I\u000b\u001dC!\u0005W3a\u0001\"\u0001\u0004\u0005\u0011\r\u0001\u0002CAt\u0003\u0017!\t\u0001\"\u0004\t\u0019\t=\u00121\u0002a\u0001\u0002\u0004%I\u0001\"\u0005\t\u0019\tU\u00121\u0002a\u0001\u0002\u0004%I\u0001\"\u0006\t\u0019\t\r\u00131\u0002a\u0001\u0002\u0003\u0006K\u0001b\u0005\t\u0015\t\u0015\u00131\u0002a\u0001\n\u0013\u00119\u0005\u0003\u0006\u0003P\u0005-\u0001\u0019!C\u0005\t3A\u0011B!\u0016\u0002\f\u0001\u0006KA!\u0013\t\u0015\t]\u00131\u0002a\u0001\n\u0013\u00119\u0005\u0003\u0006\u0003Z\u0005-\u0001\u0019!C\u0005\t;A\u0011Ba\u0018\u0002\f\u0001\u0006KA!\u0013\t\u0011\t\u0005\u00141\u0002C\u0005\tCA\u0001Ba\u001a\u0002\f\u0011%AQ\u0005\u0005\t\u0005[\nY\u0001\"\u0011\u0005*!A!1OA\u0006\t\u0013!i\u0003\u0003\u0005\u0003z\u0005-A\u0011\u0001C\u0019\u0011!\u0011\u0019)a\u0003\u0005B\u0011]\u0002\u0002\u0003BJ\u0003\u0017!\tA!&\t\u0011\t]\u00151\u0002C\u0001\t{A\u0001Ba'\u0002\f\u0011\u0005Cq\b\u0005\t\u0005S\u000bY\u0001\"\u0011\u0003,\u001a1A1I\u0002\u0003\t\u000bB\u0001\"a:\u00026\u0011\u0005Aq\n\u0005\r\u0005_\t)\u00041AA\u0002\u0013%A1\u000b\u0005\r\u0005k\t)\u00041AA\u0002\u0013%Aq\u000b\u0005\r\u0005\u0007\n)\u00041A\u0001B\u0003&AQ\u000b\u0005\u000b\u0005\u000b\n)\u00041A\u0005\n\t\u001d\u0003B\u0003B(\u0003k\u0001\r\u0011\"\u0003\u0005\\!I!QKA\u001bA\u0003&!\u0011\n\u0005\u000b\u0005/\n)\u00041A\u0005\n\t\u001d\u0003B\u0003B-\u0003k\u0001\r\u0011\"\u0003\u0005`!I!qLA\u001bA\u0003&!\u0011\n\u0005\t\u0005C\n)\u0004\"\u0003\u0005d!A!qMA\u001b\t\u0013!9\u0007\u0003\u0005\u0003n\u0005UB\u0011\tC6\u0011!\u0011\u0019(!\u000e\u0005\n\u0011=\u0004\u0002\u0003B=\u0003k!\t\u0001b\u001d\t\u0011\t\r\u0015Q\u0007C!\tsB\u0001Ba%\u00026\u0011\u0005!Q\u0013\u0005\t\u0005/\u000b)\u0004\"\u0001\u0005\u0000!A!1TA\u001b\t\u0003\"\t\t\u0003\u0005\u0003*\u0006UB\u0011\tBV\r\u0019!)i\u0001\u0001\u0005\b\"A\u0011q]A0\t\u0003!Y\t\u0003\u0007\u00030\u0005}\u0003\u0019!a\u0001\n\u0013!y\t\u0003\u0007\u00036\u0005}\u0003\u0019!a\u0001\n\u0013!\u0019\n\u0003\u0007\u0003D\u0005}\u0003\u0019!A!B\u0013!\t\n\u0003\u0006\u0003F\u0005}\u0003\u0019!C\u0005\u0005\u000fB!Ba\u0014\u0002`\u0001\u0007I\u0011\u0002CL\u0011%\u0011)&a\u0018!B\u0013\u0011I\u0005\u0003\u0006\u0003X\u0005}\u0003\u0019!C\u0005\u0005\u000fB!B!\u0017\u0002`\u0001\u0007I\u0011\u0002CN\u0011%\u0011y&a\u0018!B\u0013\u0011I\u0005\u0003\u0005\u0003b\u0005}C\u0011\u0002CP\u0011!\u00119'a\u0018\u0005\n\u0011\r\u0006\u0002\u0003B7\u0003?\"\t\u0005b*\t\u0011\tM\u0014q\fC\u0005\tWC\u0001B!\u001f\u0002`\u0011\u0005Aq\u0016\u0005\t\u0005\u0007\u000by\u0006\"\u0011\u00056\"A!1SA0\t\u0003\u0011)\n\u0003\u0005\u0003\u0018\u0006}C\u0011\u0001C^\u0011!\u0011Y*a\u0018\u0005B\u0011u\u0006\u0002\u0003BU\u0003?\"\tEa+\u0007\r\u0011\u00057A\u0001Cb\u0011!\t9/!#\u0005\u0002\u0011\u001d\u0007B\u0003B,\u0003\u0013\u0003\r\u0011\"\u0003\u0003H!Q!\u0011LAE\u0001\u0004%I\u0001b3\t\u0013\t}\u0013\u0011\u0012Q!\n\t%\u0003\u0002\u0003B=\u0003\u0013#\t\u0001b4\t\u0011\t\r\u0015\u0011\u0012C!\t+D\u0001Ba%\u0002\n\u0012\u0005!Q\u0013\u0005\t\u0005/\u000bI\t\"\u0001\u0005\\\"A!1TAE\t\u0003\"y\u000e\u0003\u0005\u0003*\u0006%E\u0011\tBV\u0011%!\u0019oAA\u0001\n\u0013!)O\u0001\u0007BeJ\f\u0017PQ;jY\u0012,'O\u0003\u0003\u0002&\u0006\u001d\u0016aB7vi\u0006\u0014G.\u001a\u0006\u0005\u0003S\u000bY+\u0001\u0006d_2dWm\u0019;j_:T!!!,\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U!\u00111WAe'\u001d\u0001\u0011QWA_\u0003C\u0004B!a.\u0002:6\u0011\u00111V\u0005\u0005\u0003w\u000bYK\u0001\u0004B]f\u0014VM\u001a\t\t\u0003\u007f\u000b\t-!2\u0002\\6\u0011\u00111U\u0005\u0005\u0003\u0007\f\u0019KA\bSKV\u001c\u0018M\u00197f\u0005VLG\u000eZ3s!\u0011\t9-!3\r\u0001\u00119\u00111\u001a\u0001C\u0002\u00055'!\u0001+\u0012\t\u0005=\u0017Q\u001b\t\u0005\u0003o\u000b\t.\u0003\u0003\u0002T\u0006-&a\u0002(pi\"Lgn\u001a\t\u0005\u0003o\u000b9.\u0003\u0003\u0002Z\u0006-&aA!osB1\u0011qWAo\u0003\u000bLA!a8\u0002,\n)\u0011I\u001d:bsB!\u0011qWAr\u0013\u0011\t)/a+\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\rqJg.\u001b;?)\t\tY\u000fE\u0003\u0002@\u0002\t)-\u0001\u0007BeJ\f\u0017PQ;jY\u0012,'\u000fE\u0002\u0002@\u000e\u0019RaAA[\u0003C$\"!a<\u0002\t5\f7.Z\u000b\u0005\u0003s\u0014\t\u0001\u0006\u0002\u0002|R!\u0011Q B\u0002!\u0015\ty\fAA\u0000!\u0011\t9M!\u0001\u0005\u000f\u0005-WA1\u0001\u0002N\"I!QA\u0003\u0002\u0002\u0003\u000f!qA\u0001\u000bKZLG-\u001a8dK\u0012\n\u0004C\u0002B\u0005\u0005\u001f\ty0\u0004\u0002\u0003\f)!!QBAV\u0003\u001d\u0011XM\u001a7fGRLAA!\u0005\u0003\f\tA1\t\\1tgR\u000bwMA\u0003pMJ+g-\u0006\u0003\u0003\u0018\tu1c\u0001\u0004\u0003\u001aA)\u0011q\u0018\u0001\u0003\u001cA!\u0011q\u0019B\u000f\t\u001d\tYM\u0002b\u0001\u0005?\tB!a4\u00026\u0006QQM^5eK:\u001cW\r\n\u001a\u0011\r\t%!q\u0002B\u000e)\t\u00119\u0003\u0006\u0003\u0003*\t5\u0002#\u0002B\u0016\r\tmQ\"A\u0002\t\u000f\t\u0005\u0002\u0002q\u0001\u0003$\u0005)Q\r\\3ngV\u0011!1\u0007\t\u0007\u0003o\u000biNa\u0007\u0002\u0013\u0015dW-\\:`I\u0015\fH\u0003\u0002B\u001d\u0005\u007f\u0001B!a.\u0003<%!!QHAV\u0005\u0011)f.\u001b;\t\u0013\t\u0005#\"!AA\u0002\tM\u0012a\u0001=%c\u00051Q\r\\3ng\u0002\n\u0001bY1qC\u000eLG/_\u000b\u0003\u0005\u0013\u0002B!a.\u0003L%!!QJAV\u0005\rIe\u000e^\u0001\rG\u0006\u0004\u0018mY5us~#S-\u001d\u000b\u0005\u0005s\u0011\u0019\u0006C\u0005\u0003B5\t\t\u00111\u0001\u0003J\u0005I1-\u00199bG&$\u0018\u0010I\u0001\u0005g&TX-\u0001\u0005tSj,w\fJ3r)\u0011\u0011ID!\u0018\t\u0013\t\u0005\u0003#!AA\u0002\t%\u0013!B:ju\u0016\u0004\u0013aB7l\u0003J\u0014\u0018-\u001f\u000b\u0005\u0005g\u0011)\u0007C\u0004\u0003XI\u0001\rA!\u0013\u0002\rI,7/\u001b>f)\u0011\u0011IDa\u001b\t\u000f\t]3\u00031\u0001\u0003J\u0005A1/\u001b>f\u0011&tG\u000f\u0006\u0003\u0003:\tE\u0004b\u0002B,)\u0001\u0007!\u0011J\u0001\u000bK:\u001cXO]3TSj,G\u0003\u0002B\u001d\u0005oBqAa\u0016\u0016\u0001\u0004\u0011I%\u0001\u0005%a2,8\u000fJ3r)\u0011\u0011iHa \u000e\u0003\u0019AqA!!\u0017\u0001\u0004\u0011Y\"\u0001\u0003fY\u0016l\u0017!\u0004\u0013qYV\u001cH\u0005\u001d7vg\u0012*\u0017\u000f\u0006\u0003\u0003~\t\u001d\u0005b\u0002BE/\u0001\u0007!1R\u0001\u0003qN\u0004bA!$\u0003\u0010\nmQBAAT\u0013\u0011\u0011\t*a*\u0003\u001fQ\u0013\u0018M^3sg\u0006\u0014G.Z(oG\u0016\fQa\u00197fCJ$\"A!\u000f\u0002\rI,7/\u001e7u)\t\u0011\u0019$\u0001\u0004fcV\fGn\u001d\u000b\u0005\u0005?\u0013)\u000b\u0005\u0003\u00028\n\u0005\u0016\u0002\u0002BR\u0003W\u0013qAQ8pY\u0016\fg\u000eC\u0004\u0003(j\u0001\r!!6\u0002\u000b=$\b.\u001a:\u0002\u0011Q|7\u000b\u001e:j]\u001e$\"A!,\u0011\t\t=&\u0011X\u0007\u0003\u0005cSAAa-\u00036\u0006!A.\u00198h\u0015\t\u00119,\u0001\u0003kCZ\f\u0017\u0002\u0002B^\u0005c\u0013aa\u0015;sS:<'AB8g\u0005f$XmE\u0002\u001d\u0005\u0003\u0004R!a0\u0001\u0005\u0007\u0004B!a.\u0003F&!!qYAV\u0005\u0011\u0011\u0015\u0010^3\u0015\u0005\t-\u0007c\u0001B\u00169U\u0011!q\u001a\t\u0007\u0003o\u000biNa1\u0015\t\te\"1\u001b\u0005\n\u0005\u0003z\u0012\u0011!a\u0001\u0005\u001f$BA!\u000f\u0003X\"I!\u0011\t\u0012\u0002\u0002\u0003\u0007!\u0011\n\u000b\u0005\u0005s\u0011Y\u000eC\u0005\u0003B\u0015\n\t\u00111\u0001\u0003JQ!!q\u001aBp\u0011\u001d\u00119f\na\u0001\u0005\u0013\"BA!\u000f\u0003d\"9!q\u000b\u0015A\u0002\t%C\u0003\u0002B\u001d\u0005ODqAa\u0016*\u0001\u0004\u0011I\u0005\u0006\u0003\u0003:\t-\bb\u0002B,U\u0001\u0007!\u0011\n\u000b\u0005\u0005_\u0014\t0D\u0001\u001d\u0011\u001d\u0011\ti\u000ba\u0001\u0005\u0007$BAa<\u0003v\"9!\u0011\u0012\u0017A\u0002\t]\bC\u0002BG\u0005\u001f\u0013\u0019\r\u0006\u0002\u0003PR!!q\u0014B\u007f\u0011\u001d\u00119k\fa\u0001\u0003+\u0014qa\u001c4TQ>\u0014HoE\u00022\u0007\u0007\u0001R!a0\u0001\u0007\u000b\u0001B!a.\u0004\b%!1\u0011BAV\u0005\u0015\u0019\u0006n\u001c:u)\t\u0019i\u0001E\u0002\u0003,E*\"a!\u0005\u0011\r\u0005]\u0016Q\\B\u0003)\u0011\u0011Id!\u0006\t\u0013\t\u0005C'!AA\u0002\rEA\u0003\u0002B\u001d\u00073A\u0011B!\u00118\u0003\u0003\u0005\rA!\u0013\u0015\t\te2Q\u0004\u0005\n\u0005\u0003R\u0014\u0011!a\u0001\u0005\u0013\"Ba!\u0005\u0004\"!9!q\u000b\u001fA\u0002\t%C\u0003\u0002B\u001d\u0007KAqAa\u0016>\u0001\u0004\u0011I\u0005\u0006\u0003\u0003:\r%\u0002b\u0002B,}\u0001\u0007!\u0011\n\u000b\u0005\u0005s\u0019i\u0003C\u0004\u0003X}\u0002\rA!\u0013\u0015\t\rE21G\u0007\u0002c!9!\u0011\u0011!A\u0002\r\u0015A\u0003BB\u0019\u0007oAqA!#B\u0001\u0004\u0019I\u0004\u0005\u0004\u0003\u000e\n=5Q\u0001\u000b\u0003\u0007#!BAa(\u0004@!9!q\u0015#A\u0002\u0005U'AB8g\u0007\"\f'oE\u0002G\u0007\u000b\u0002R!a0\u0001\u0007\u000f\u0002B!a.\u0004J%!11JAV\u0005\u0011\u0019\u0005.\u0019:\u0015\u0005\r=\u0003c\u0001B\u0016\rV\u001111\u000b\t\u0007\u0003o\u000bina\u0012\u0015\t\te2q\u000b\u0005\n\u0005\u0003J\u0015\u0011!a\u0001\u0007'\"BA!\u000f\u0004\\!I!\u0011\t'\u0002\u0002\u0003\u0007!\u0011\n\u000b\u0005\u0005s\u0019y\u0006C\u0005\u0003B=\u000b\t\u00111\u0001\u0003JQ!11KB2\u0011\u001d\u00119&\u0015a\u0001\u0005\u0013\"BA!\u000f\u0004h!9!q\u000b*A\u0002\t%C\u0003\u0002B\u001d\u0007WBqAa\u0016T\u0001\u0004\u0011I\u0005\u0006\u0003\u0003:\r=\u0004b\u0002B,)\u0002\u0007!\u0011\n\u000b\u0005\u0007g\u001a)(D\u0001G\u0011\u001d\u0011\t)\u0016a\u0001\u0007\u000f\"Baa\u001d\u0004z!9!\u0011\u0012,A\u0002\rm\u0004C\u0002BG\u0005\u001f\u001b9\u0005\u0006\u0002\u0004TQ!!qTBA\u0011\u001d\u00119+\u0017a\u0001\u0003+\u0014Qa\u001c4J]R\u001c2aWBD!\u0015\ty\f\u0001B%)\t\u0019Y\tE\u0002\u0003,m+\"aa$\u0011\r\u0005]\u0016Q\u001cB%)\u0011\u0011Ida%\t\u0013\t\u0005c,!AA\u0002\r=E\u0003\u0002B\u001d\u0007/C\u0011B!\u0011b\u0003\u0003\u0005\rA!\u0013\u0015\t\te21\u0014\u0005\n\u0005\u0003\"\u0017\u0011!a\u0001\u0005\u0013\"Baa$\u0004 \"9!q\u000b4A\u0002\t%C\u0003\u0002B\u001d\u0007GCqAa\u0016h\u0001\u0004\u0011I\u0005\u0006\u0003\u0003:\r\u001d\u0006b\u0002B,Q\u0002\u0007!\u0011\n\u000b\u0005\u0005s\u0019Y\u000bC\u0004\u0003X%\u0004\rA!\u0013\u0015\t\r=6\u0011W\u0007\u00027\"9!\u0011\u00116A\u0002\t%C\u0003BBX\u0007kCqA!#l\u0001\u0004\u00199\f\u0005\u0004\u0003\u000e\n=%\u0011\n\u000b\u0003\u0007\u001f#BAa(\u0004>\"9!q\u00158A\u0002\u0005U'AB8g\u0019>twmE\u0002q\u0007\u0007\u0004R!a0\u0001\u0007\u000b\u0004B!a.\u0004H&!1\u0011ZAV\u0005\u0011auN\\4\u0015\u0005\r5\u0007c\u0001B\u0016aV\u00111\u0011\u001b\t\u0007\u0003o\u000bin!2\u0015\t\te2Q\u001b\u0005\n\u0005\u0003\u001a\u0018\u0011!a\u0001\u0007#$BA!\u000f\u0004Z\"I!\u0011\t<\u0002\u0002\u0003\u0007!\u0011\n\u000b\u0005\u0005s\u0019i\u000eC\u0005\u0003Be\f\t\u00111\u0001\u0003JQ!1\u0011[Bq\u0011\u001d\u00119f\u001fa\u0001\u0005\u0013\"BA!\u000f\u0004f\"9!q\u000b?A\u0002\t%C\u0003\u0002B\u001d\u0007SDqAa\u0016~\u0001\u0004\u0011I\u0005\u0006\u0003\u0003:\r5\bb\u0002B,}\u0002\u0007!\u0011\n\u000b\u0005\u0007c\u001c\u00190D\u0001q\u0011\u001d\u0011\ti a\u0001\u0007\u000b$Ba!=\u0004x\"A!\u0011RA\u0001\u0001\u0004\u0019I\u0010\u0005\u0004\u0003\u000e\n=5Q\u0019\u000b\u0003\u0007#$BAa(\u0004\u0000\"A!qUA\u0004\u0001\u0004\t)NA\u0004pM\u001acw.\u0019;\u0014\t\u0005-AQ\u0001\t\u0006\u0003\u007f\u0003Aq\u0001\t\u0005\u0003o#I!\u0003\u0003\u0005\f\u0005-&!\u0002$m_\u0006$HC\u0001C\b!\u0011\u0011Y#a\u0003\u0016\u0005\u0011M\u0001CBA\\\u0003;$9\u0001\u0006\u0003\u0003:\u0011]\u0001B\u0003B!\u0003#\t\t\u00111\u0001\u0005\u0014Q!!\u0011\bC\u000e\u0011)\u0011\t%a\u0006\u0002\u0002\u0003\u0007!\u0011\n\u000b\u0005\u0005s!y\u0002\u0003\u0006\u0003B\u0005u\u0011\u0011!a\u0001\u0005\u0013\"B\u0001b\u0005\u0005$!A!qKA\u0011\u0001\u0004\u0011I\u0005\u0006\u0003\u0003:\u0011\u001d\u0002\u0002\u0003B,\u0003G\u0001\rA!\u0013\u0015\t\teB1\u0006\u0005\t\u0005/\n)\u00031\u0001\u0003JQ!!\u0011\bC\u0018\u0011!\u00119&a\nA\u0002\t%C\u0003\u0002C\u001a\tki!!a\u0003\t\u0011\t\u0005\u0015\u0011\u0006a\u0001\t\u000f!B\u0001b\r\u0005:!A!\u0011RA\u0016\u0001\u0004!Y\u0004\u0005\u0004\u0003\u000e\n=Eq\u0001\u000b\u0003\t'!BAa(\u0005B!A!qUA\u0019\u0001\u0004\t)N\u0001\u0005pM\u0012{WO\u00197f'\u0011\t)\u0004b\u0012\u0011\u000b\u0005}\u0006\u0001\"\u0013\u0011\t\u0005]F1J\u0005\u0005\t\u001b\nYK\u0001\u0004E_V\u0014G.\u001a\u000b\u0003\t#\u0002BAa\u000b\u00026U\u0011AQ\u000b\t\u0007\u0003o\u000bi\u000e\"\u0013\u0015\t\teB\u0011\f\u0005\u000b\u0005\u0003\nY$!AA\u0002\u0011UC\u0003\u0002B\u001d\t;B!B!\u0011\u0002B\u0005\u0005\t\u0019\u0001B%)\u0011\u0011I\u0004\"\u0019\t\u0015\t\u0005\u0013qIA\u0001\u0002\u0004\u0011I\u0005\u0006\u0003\u0005V\u0011\u0015\u0004\u0002\u0003B,\u0003\u0017\u0002\rA!\u0013\u0015\t\teB\u0011\u000e\u0005\t\u0005/\ni\u00051\u0001\u0003JQ!!\u0011\bC7\u0011!\u00119&a\u0014A\u0002\t%C\u0003\u0002B\u001d\tcB\u0001Ba\u0016\u0002R\u0001\u0007!\u0011\n\u000b\u0005\tk\"9(\u0004\u0002\u00026!A!\u0011QA*\u0001\u0004!I\u0005\u0006\u0003\u0005v\u0011m\u0004\u0002\u0003BE\u0003+\u0002\r\u0001\" \u0011\r\t5%q\u0012C%)\t!)\u0006\u0006\u0003\u0003 \u0012\r\u0005\u0002\u0003BT\u00037\u0002\r!!6\u0003\u0013=4'i\\8mK\u0006t7\u0003BA0\t\u0013\u0003R!a0\u0001\u0005?#\"\u0001\"$\u0011\t\t-\u0012qL\u000b\u0003\t#\u0003b!a.\u0002^\n}E\u0003\u0002B\u001d\t+C!B!\u0011\u0002f\u0005\u0005\t\u0019\u0001CI)\u0011\u0011I\u0004\"'\t\u0015\t\u0005\u00131NA\u0001\u0002\u0004\u0011I\u0005\u0006\u0003\u0003:\u0011u\u0005B\u0003B!\u0003c\n\t\u00111\u0001\u0003JQ!A\u0011\u0013CQ\u0011!\u00119&!\u001eA\u0002\t%C\u0003\u0002B\u001d\tKC\u0001Ba\u0016\u0002x\u0001\u0007!\u0011\n\u000b\u0005\u0005s!I\u000b\u0003\u0005\u0003X\u0005e\u0004\u0019\u0001B%)\u0011\u0011I\u0004\",\t\u0011\t]\u00131\u0010a\u0001\u0005\u0013\"B\u0001\"-\u000546\u0011\u0011q\f\u0005\t\u0005\u0003\u000bi\b1\u0001\u0003 R!A\u0011\u0017C\\\u0011!\u0011I)a A\u0002\u0011e\u0006C\u0002BG\u0005\u001f\u0013y\n\u0006\u0002\u0005\u0012R!!q\u0014C`\u0011!\u00119+!\"A\u0002\u0005U'AB8g+:LGo\u0005\u0003\u0002\n\u0012\u0015\u0007#BA`\u0001\teBC\u0001Ce!\u0011\u0011Y#!#\u0015\t\teBQ\u001a\u0005\u000b\u0005\u0003\ny)!AA\u0002\t%C\u0003\u0002Ci\t'l!!!#\t\u0011\t\u0005\u00151\u0013a\u0001\u0005s!B\u0001\"5\u0005X\"A!\u0011RAK\u0001\u0004!I\u000e\u0005\u0004\u0003\u000e\n=%\u0011\b\u000b\u0003\t;\u0004b!a.\u0002^\neB\u0003\u0002BP\tCD\u0001Ba*\u0002\u001c\u0002\u0007\u0011Q[\u0001\fe\u0016\fGMU3t_24X\r\u0006\u0002\u0005hB!!q\u0016Cu\u0013\u0011!YO!-\u0003\r=\u0013'.Z2u\u0001")
public abstract class ArrayBuilder<T>
implements ReusableBuilder<T, Object>,
Serializable {
    public static <T> ArrayBuilder<T> make(ClassTag<T> classTag) {
        return ArrayBuilder$.MODULE$.make(classTag);
    }

    @Override
    public void sizeHint(int size) {
        Builder.sizeHint$((Builder)this, size);
    }

    @Override
    public void sizeHint(TraversableLike<?, ?> coll) {
        Builder.sizeHint$((Builder)this, coll);
    }

    @Override
    public void sizeHint(TraversableLike<?, ?> coll, int delta) {
        Builder.sizeHint$(this, coll, delta);
    }

    @Override
    public void sizeHintBounded(int size, TraversableLike<?, ?> boundingColl) {
        Builder.sizeHintBounded$(this, size, boundingColl);
    }

    @Override
    public <NewTo> Builder<T, NewTo> mapResult(Function1<Object, NewTo> f) {
        return Builder.mapResult$(this, f);
    }

    @Override
    public Growable<T> $plus$eq(T elem1, T elem2, Seq<T> elems) {
        return Growable.$plus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Growable<T> $plus$plus$eq(TraversableOnce<T> xs) {
        return Growable.$plus$plus$eq$(this, xs);
    }

    public ArrayBuilder() {
        Growable.$init$(this);
        Builder.$init$(this);
    }

    public static class ofBoolean
    extends ArrayBuilder<Object> {
        private boolean[] elems;
        private int capacity = 0;
        private int size = 0;

        private boolean[] elems() {
            return this.elems;
        }

        private void elems_$eq(boolean[] x$1) {
            this.elems = x$1;
        }

        private int capacity() {
            return this.capacity;
        }

        private void capacity_$eq(int x$1) {
            this.capacity = x$1;
        }

        private int size() {
            return this.size;
        }

        private void size_$eq(int x$1) {
            this.size = x$1;
        }

        /*
         * WARNING - void declaration
         */
        private boolean[] mkArray(int size) {
            void var2_2;
            boolean[] newelems = new boolean[size];
            if (this.size() > 0) {
                Array$.MODULE$.copy(this.elems(), 0, newelems, 0, this.size());
            }
            return var2_2;
        }

        private void resize(int size) {
            this.elems_$eq(this.mkArray(size));
            this.capacity_$eq(size);
        }

        @Override
        public void sizeHint(int size) {
            if (this.capacity() < size) {
                this.resize(size);
            }
        }

        private void ensureSize(int size) {
            if (this.capacity() < size || this.capacity() == 0) {
                int newsize;
                int n = newsize = this.capacity() == 0 ? 16 : this.capacity() * 2;
                while (newsize < size) {
                    newsize *= 2;
                }
                this.resize(newsize);
            }
        }

        public ofBoolean $plus$eq(boolean elem) {
            this.ensureSize(this.size() + 1);
            this.elems()[this.size()] = elem;
            this.size_$eq(this.size() + 1);
            return this;
        }

        public ofBoolean $plus$plus$eq(TraversableOnce<Object> xs) {
            ofBoolean ofBoolean2;
            if (xs instanceof WrappedArray.ofBoolean) {
                WrappedArray.ofBoolean ofBoolean3 = (WrappedArray.ofBoolean)xs;
                this.ensureSize(this.size() + ofBoolean3.length());
                Array$.MODULE$.copy(ofBoolean3.array(), 0, this.elems(), this.size(), ofBoolean3.length());
                this.size_$eq(this.size() + ofBoolean3.length());
                ofBoolean2 = this;
            } else {
                ofBoolean2 = (ofBoolean)Growable.$plus$plus$eq$(this, xs);
            }
            return ofBoolean2;
        }

        @Override
        public void clear() {
            this.size_$eq(0);
        }

        @Override
        public boolean[] result() {
            if (this.capacity() != 0 && this.capacity() == this.size()) {
                this.capacity_$eq(0);
                return this.elems();
            }
            return this.mkArray(this.size());
        }

        public boolean equals(Object other) {
            boolean bl;
            if (other instanceof ofBoolean) {
                ofBoolean ofBoolean2 = (ofBoolean)other;
                bl = this.size() == ofBoolean2.size() && this.elems() == ofBoolean2.elems();
            } else {
                bl = false;
            }
            return bl;
        }

        public String toString() {
            return "ArrayBuilder.ofBoolean";
        }
    }

    public static final class ofByte
    extends ArrayBuilder<Object> {
        private byte[] elems;
        private int capacity = 0;
        private int size = 0;

        private byte[] elems() {
            return this.elems;
        }

        private void elems_$eq(byte[] x$1) {
            this.elems = x$1;
        }

        private int capacity() {
            return this.capacity;
        }

        private void capacity_$eq(int x$1) {
            this.capacity = x$1;
        }

        private int size() {
            return this.size;
        }

        private void size_$eq(int x$1) {
            this.size = x$1;
        }

        /*
         * WARNING - void declaration
         */
        private byte[] mkArray(int size) {
            void var2_2;
            byte[] newelems = new byte[size];
            if (this.size() > 0) {
                Array$.MODULE$.copy(this.elems(), 0, newelems, 0, this.size());
            }
            return var2_2;
        }

        private void resize(int size) {
            this.elems_$eq(this.mkArray(size));
            this.capacity_$eq(size);
        }

        @Override
        public void sizeHint(int size) {
            if (this.capacity() < size) {
                this.resize(size);
            }
        }

        private void ensureSize(int size) {
            if (this.capacity() < size || this.capacity() == 0) {
                int newsize;
                int n = newsize = this.capacity() == 0 ? 16 : this.capacity() * 2;
                while (newsize < size) {
                    newsize *= 2;
                }
                this.resize(newsize);
            }
        }

        public ofByte $plus$eq(byte elem) {
            this.ensureSize(this.size() + 1);
            this.elems()[this.size()] = elem;
            this.size_$eq(this.size() + 1);
            return this;
        }

        public ofByte $plus$plus$eq(TraversableOnce<Object> xs) {
            ofByte ofByte2;
            if (xs instanceof WrappedArray.ofByte) {
                WrappedArray.ofByte ofByte3 = (WrappedArray.ofByte)xs;
                this.ensureSize(this.size() + ofByte3.length());
                Array$.MODULE$.copy(ofByte3.array(), 0, this.elems(), this.size(), ofByte3.length());
                this.size_$eq(this.size() + ofByte3.length());
                ofByte2 = this;
            } else {
                ofByte2 = (ofByte)Growable.$plus$plus$eq$(this, xs);
            }
            return ofByte2;
        }

        @Override
        public void clear() {
            this.size_$eq(0);
        }

        @Override
        public byte[] result() {
            if (this.capacity() != 0 && this.capacity() == this.size()) {
                this.capacity_$eq(0);
                return this.elems();
            }
            return this.mkArray(this.size());
        }

        public boolean equals(Object other) {
            boolean bl;
            if (other instanceof ofByte) {
                ofByte ofByte2 = (ofByte)other;
                bl = this.size() == ofByte2.size() && this.elems() == ofByte2.elems();
            } else {
                bl = false;
            }
            return bl;
        }

        public String toString() {
            return "ArrayBuilder.ofByte";
        }
    }

    public static final class ofChar
    extends ArrayBuilder<Object> {
        private char[] elems;
        private int capacity = 0;
        private int size = 0;

        private char[] elems() {
            return this.elems;
        }

        private void elems_$eq(char[] x$1) {
            this.elems = x$1;
        }

        private int capacity() {
            return this.capacity;
        }

        private void capacity_$eq(int x$1) {
            this.capacity = x$1;
        }

        private int size() {
            return this.size;
        }

        private void size_$eq(int x$1) {
            this.size = x$1;
        }

        /*
         * WARNING - void declaration
         */
        private char[] mkArray(int size) {
            void var2_2;
            char[] newelems = new char[size];
            if (this.size() > 0) {
                Array$.MODULE$.copy(this.elems(), 0, newelems, 0, this.size());
            }
            return var2_2;
        }

        private void resize(int size) {
            this.elems_$eq(this.mkArray(size));
            this.capacity_$eq(size);
        }

        @Override
        public void sizeHint(int size) {
            if (this.capacity() < size) {
                this.resize(size);
            }
        }

        private void ensureSize(int size) {
            if (this.capacity() < size || this.capacity() == 0) {
                int newsize;
                int n = newsize = this.capacity() == 0 ? 16 : this.capacity() * 2;
                while (newsize < size) {
                    newsize *= 2;
                }
                this.resize(newsize);
            }
        }

        public ofChar $plus$eq(char elem) {
            this.ensureSize(this.size() + 1);
            this.elems()[this.size()] = elem;
            this.size_$eq(this.size() + 1);
            return this;
        }

        public ofChar $plus$plus$eq(TraversableOnce<Object> xs) {
            ofChar ofChar2;
            if (xs instanceof WrappedArray.ofChar) {
                WrappedArray.ofChar ofChar3 = (WrappedArray.ofChar)xs;
                this.ensureSize(this.size() + ofChar3.length());
                Array$.MODULE$.copy(ofChar3.array(), 0, this.elems(), this.size(), ofChar3.length());
                this.size_$eq(this.size() + ofChar3.length());
                ofChar2 = this;
            } else {
                ofChar2 = (ofChar)Growable.$plus$plus$eq$(this, xs);
            }
            return ofChar2;
        }

        @Override
        public void clear() {
            this.size_$eq(0);
        }

        @Override
        public char[] result() {
            if (this.capacity() != 0 && this.capacity() == this.size()) {
                this.capacity_$eq(0);
                return this.elems();
            }
            return this.mkArray(this.size());
        }

        public boolean equals(Object other) {
            boolean bl;
            if (other instanceof ofChar) {
                ofChar ofChar2 = (ofChar)other;
                bl = this.size() == ofChar2.size() && this.elems() == ofChar2.elems();
            } else {
                bl = false;
            }
            return bl;
        }

        public String toString() {
            return "ArrayBuilder.ofChar";
        }
    }

    public static final class ofDouble
    extends ArrayBuilder<Object> {
        private double[] elems;
        private int capacity = 0;
        private int size = 0;

        private double[] elems() {
            return this.elems;
        }

        private void elems_$eq(double[] x$1) {
            this.elems = x$1;
        }

        private int capacity() {
            return this.capacity;
        }

        private void capacity_$eq(int x$1) {
            this.capacity = x$1;
        }

        private int size() {
            return this.size;
        }

        private void size_$eq(int x$1) {
            this.size = x$1;
        }

        /*
         * WARNING - void declaration
         */
        private double[] mkArray(int size) {
            void var2_2;
            double[] newelems = new double[size];
            if (this.size() > 0) {
                Array$.MODULE$.copy(this.elems(), 0, newelems, 0, this.size());
            }
            return var2_2;
        }

        private void resize(int size) {
            this.elems_$eq(this.mkArray(size));
            this.capacity_$eq(size);
        }

        @Override
        public void sizeHint(int size) {
            if (this.capacity() < size) {
                this.resize(size);
            }
        }

        private void ensureSize(int size) {
            if (this.capacity() < size || this.capacity() == 0) {
                int newsize;
                int n = newsize = this.capacity() == 0 ? 16 : this.capacity() * 2;
                while (newsize < size) {
                    newsize *= 2;
                }
                this.resize(newsize);
            }
        }

        public ofDouble $plus$eq(double elem) {
            this.ensureSize(this.size() + 1);
            this.elems()[this.size()] = elem;
            this.size_$eq(this.size() + 1);
            return this;
        }

        public ofDouble $plus$plus$eq(TraversableOnce<Object> xs) {
            ofDouble ofDouble2;
            if (xs instanceof WrappedArray.ofDouble) {
                WrappedArray.ofDouble ofDouble3 = (WrappedArray.ofDouble)xs;
                this.ensureSize(this.size() + ofDouble3.length());
                Array$.MODULE$.copy(ofDouble3.array(), 0, this.elems(), this.size(), ofDouble3.length());
                this.size_$eq(this.size() + ofDouble3.length());
                ofDouble2 = this;
            } else {
                ofDouble2 = (ofDouble)Growable.$plus$plus$eq$(this, xs);
            }
            return ofDouble2;
        }

        @Override
        public void clear() {
            this.size_$eq(0);
        }

        @Override
        public double[] result() {
            if (this.capacity() != 0 && this.capacity() == this.size()) {
                this.capacity_$eq(0);
                return this.elems();
            }
            return this.mkArray(this.size());
        }

        public boolean equals(Object other) {
            boolean bl;
            if (other instanceof ofDouble) {
                ofDouble ofDouble2 = (ofDouble)other;
                bl = this.size() == ofDouble2.size() && this.elems() == ofDouble2.elems();
            } else {
                bl = false;
            }
            return bl;
        }

        public String toString() {
            return "ArrayBuilder.ofDouble";
        }
    }

    public static final class ofFloat
    extends ArrayBuilder<Object> {
        private float[] elems;
        private int capacity = 0;
        private int size = 0;

        private float[] elems() {
            return this.elems;
        }

        private void elems_$eq(float[] x$1) {
            this.elems = x$1;
        }

        private int capacity() {
            return this.capacity;
        }

        private void capacity_$eq(int x$1) {
            this.capacity = x$1;
        }

        private int size() {
            return this.size;
        }

        private void size_$eq(int x$1) {
            this.size = x$1;
        }

        /*
         * WARNING - void declaration
         */
        private float[] mkArray(int size) {
            void var2_2;
            float[] newelems = new float[size];
            if (this.size() > 0) {
                Array$.MODULE$.copy(this.elems(), 0, newelems, 0, this.size());
            }
            return var2_2;
        }

        private void resize(int size) {
            this.elems_$eq(this.mkArray(size));
            this.capacity_$eq(size);
        }

        @Override
        public void sizeHint(int size) {
            if (this.capacity() < size) {
                this.resize(size);
            }
        }

        private void ensureSize(int size) {
            if (this.capacity() < size || this.capacity() == 0) {
                int newsize;
                int n = newsize = this.capacity() == 0 ? 16 : this.capacity() * 2;
                while (newsize < size) {
                    newsize *= 2;
                }
                this.resize(newsize);
            }
        }

        public ofFloat $plus$eq(float elem) {
            this.ensureSize(this.size() + 1);
            this.elems()[this.size()] = elem;
            this.size_$eq(this.size() + 1);
            return this;
        }

        public ofFloat $plus$plus$eq(TraversableOnce<Object> xs) {
            ofFloat ofFloat2;
            if (xs instanceof WrappedArray.ofFloat) {
                WrappedArray.ofFloat ofFloat3 = (WrappedArray.ofFloat)xs;
                this.ensureSize(this.size() + ofFloat3.length());
                Array$.MODULE$.copy(ofFloat3.array(), 0, this.elems(), this.size(), ofFloat3.length());
                this.size_$eq(this.size() + ofFloat3.length());
                ofFloat2 = this;
            } else {
                ofFloat2 = (ofFloat)Growable.$plus$plus$eq$(this, xs);
            }
            return ofFloat2;
        }

        @Override
        public void clear() {
            this.size_$eq(0);
        }

        @Override
        public float[] result() {
            if (this.capacity() != 0 && this.capacity() == this.size()) {
                this.capacity_$eq(0);
                return this.elems();
            }
            return this.mkArray(this.size());
        }

        public boolean equals(Object other) {
            boolean bl;
            if (other instanceof ofFloat) {
                ofFloat ofFloat2 = (ofFloat)other;
                bl = this.size() == ofFloat2.size() && this.elems() == ofFloat2.elems();
            } else {
                bl = false;
            }
            return bl;
        }

        public String toString() {
            return "ArrayBuilder.ofFloat";
        }
    }

    public static final class ofInt
    extends ArrayBuilder<Object> {
        private int[] elems;
        private int capacity = 0;
        private int size = 0;

        private int[] elems() {
            return this.elems;
        }

        private void elems_$eq(int[] x$1) {
            this.elems = x$1;
        }

        private int capacity() {
            return this.capacity;
        }

        private void capacity_$eq(int x$1) {
            this.capacity = x$1;
        }

        private int size() {
            return this.size;
        }

        private void size_$eq(int x$1) {
            this.size = x$1;
        }

        /*
         * WARNING - void declaration
         */
        private int[] mkArray(int size) {
            void var2_2;
            int[] newelems = new int[size];
            if (this.size() > 0) {
                Array$.MODULE$.copy(this.elems(), 0, newelems, 0, this.size());
            }
            return var2_2;
        }

        private void resize(int size) {
            this.elems_$eq(this.mkArray(size));
            this.capacity_$eq(size);
        }

        @Override
        public void sizeHint(int size) {
            if (this.capacity() < size) {
                this.resize(size);
            }
        }

        private void ensureSize(int size) {
            if (this.capacity() < size || this.capacity() == 0) {
                int newsize;
                int n = newsize = this.capacity() == 0 ? 16 : this.capacity() * 2;
                while (newsize < size) {
                    newsize *= 2;
                }
                this.resize(newsize);
            }
        }

        public ofInt $plus$eq(int elem) {
            this.ensureSize(this.size() + 1);
            this.elems()[this.size()] = elem;
            this.size_$eq(this.size() + 1);
            return this;
        }

        public ofInt $plus$plus$eq(TraversableOnce<Object> xs) {
            ofInt ofInt2;
            if (xs instanceof WrappedArray.ofInt) {
                WrappedArray.ofInt ofInt3 = (WrappedArray.ofInt)xs;
                this.ensureSize(this.size() + ofInt3.length());
                Array$.MODULE$.copy(ofInt3.array(), 0, this.elems(), this.size(), ofInt3.length());
                this.size_$eq(this.size() + ofInt3.length());
                ofInt2 = this;
            } else {
                ofInt2 = (ofInt)Growable.$plus$plus$eq$(this, xs);
            }
            return ofInt2;
        }

        @Override
        public void clear() {
            this.size_$eq(0);
        }

        @Override
        public int[] result() {
            if (this.capacity() != 0 && this.capacity() == this.size()) {
                this.capacity_$eq(0);
                return this.elems();
            }
            return this.mkArray(this.size());
        }

        public boolean equals(Object other) {
            boolean bl;
            if (other instanceof ofInt) {
                ofInt ofInt2 = (ofInt)other;
                bl = this.size() == ofInt2.size() && this.elems() == ofInt2.elems();
            } else {
                bl = false;
            }
            return bl;
        }

        public String toString() {
            return "ArrayBuilder.ofInt";
        }
    }

    public static final class ofLong
    extends ArrayBuilder<Object> {
        private long[] elems;
        private int capacity = 0;
        private int size = 0;

        private long[] elems() {
            return this.elems;
        }

        private void elems_$eq(long[] x$1) {
            this.elems = x$1;
        }

        private int capacity() {
            return this.capacity;
        }

        private void capacity_$eq(int x$1) {
            this.capacity = x$1;
        }

        private int size() {
            return this.size;
        }

        private void size_$eq(int x$1) {
            this.size = x$1;
        }

        /*
         * WARNING - void declaration
         */
        private long[] mkArray(int size) {
            void var2_2;
            long[] newelems = new long[size];
            if (this.size() > 0) {
                Array$.MODULE$.copy(this.elems(), 0, newelems, 0, this.size());
            }
            return var2_2;
        }

        private void resize(int size) {
            this.elems_$eq(this.mkArray(size));
            this.capacity_$eq(size);
        }

        @Override
        public void sizeHint(int size) {
            if (this.capacity() < size) {
                this.resize(size);
            }
        }

        private void ensureSize(int size) {
            if (this.capacity() < size || this.capacity() == 0) {
                int newsize;
                int n = newsize = this.capacity() == 0 ? 16 : this.capacity() * 2;
                while (newsize < size) {
                    newsize *= 2;
                }
                this.resize(newsize);
            }
        }

        public ofLong $plus$eq(long elem) {
            this.ensureSize(this.size() + 1);
            this.elems()[this.size()] = elem;
            this.size_$eq(this.size() + 1);
            return this;
        }

        public ofLong $plus$plus$eq(TraversableOnce<Object> xs) {
            ofLong ofLong2;
            if (xs instanceof WrappedArray.ofLong) {
                WrappedArray.ofLong ofLong3 = (WrappedArray.ofLong)xs;
                this.ensureSize(this.size() + ofLong3.length());
                Array$.MODULE$.copy(ofLong3.array(), 0, this.elems(), this.size(), ofLong3.length());
                this.size_$eq(this.size() + ofLong3.length());
                ofLong2 = this;
            } else {
                ofLong2 = (ofLong)Growable.$plus$plus$eq$(this, xs);
            }
            return ofLong2;
        }

        @Override
        public void clear() {
            this.size_$eq(0);
        }

        @Override
        public long[] result() {
            if (this.capacity() != 0 && this.capacity() == this.size()) {
                this.capacity_$eq(0);
                return this.elems();
            }
            return this.mkArray(this.size());
        }

        public boolean equals(Object other) {
            boolean bl;
            if (other instanceof ofLong) {
                ofLong ofLong2 = (ofLong)other;
                bl = this.size() == ofLong2.size() && this.elems() == ofLong2.elems();
            } else {
                bl = false;
            }
            return bl;
        }

        public String toString() {
            return "ArrayBuilder.ofLong";
        }
    }

    public static final class ofRef<T>
    extends ArrayBuilder<T> {
        private final ClassTag<T> evidence$2;
        private T[] elems;
        private int capacity;
        private int size;

        private T[] elems() {
            return this.elems;
        }

        private void elems_$eq(T[] x$1) {
            this.elems = x$1;
        }

        private int capacity() {
            return this.capacity;
        }

        private void capacity_$eq(int x$1) {
            this.capacity = x$1;
        }

        private int size() {
            return this.size;
        }

        private void size_$eq(int x$1) {
            this.size = x$1;
        }

        private T[] mkArray(int size) {
            if (this.capacity() == size && this.capacity() > 0) {
                return this.elems();
            }
            if (this.elems() == null) {
                return (Object[])this.evidence$2.newArray(size);
            }
            return Arrays.copyOf(this.elems(), size);
        }

        private void resize(int size) {
            this.elems_$eq(this.mkArray(size));
            this.capacity_$eq(size);
        }

        @Override
        public void sizeHint(int size) {
            if (this.capacity() < size) {
                this.resize(size);
            }
        }

        private void ensureSize(int size) {
            if (this.capacity() < size || this.capacity() == 0) {
                int newsize;
                int n = newsize = this.capacity() == 0 ? 16 : this.capacity() * 2;
                while (newsize < size) {
                    newsize *= 2;
                }
                this.resize(newsize);
            }
        }

        @Override
        public ofRef<T> $plus$eq(T elem) {
            this.ensureSize(this.size() + 1);
            this.elems()[this.size()] = elem;
            this.size_$eq(this.size() + 1);
            return this;
        }

        @Override
        public ofRef<T> $plus$plus$eq(TraversableOnce<T> xs) {
            ofRef ofRef2;
            if (xs instanceof WrappedArray.ofRef) {
                WrappedArray.ofRef ofRef3 = (WrappedArray.ofRef)xs;
                this.ensureSize(this.size() + ofRef3.length());
                Array$.MODULE$.copy(ofRef3.array(), 0, this.elems(), this.size(), ofRef3.length());
                this.size_$eq(this.size() + ofRef3.length());
                ofRef2 = this;
            } else {
                ofRef2 = (ofRef)Growable.$plus$plus$eq$(this, xs);
            }
            return ofRef2;
        }

        @Override
        public void clear() {
            this.size_$eq(0);
        }

        @Override
        public T[] result() {
            if (this.capacity() != 0 && this.capacity() == this.size()) {
                this.capacity_$eq(0);
                return this.elems();
            }
            return this.mkArray(this.size());
        }

        public boolean equals(Object other) {
            boolean bl;
            if (other instanceof ofRef) {
                ofRef ofRef2 = (ofRef)other;
                bl = this.size() == ofRef2.size() && this.elems() == ofRef2.elems();
            } else {
                bl = false;
            }
            return bl;
        }

        public String toString() {
            return "ArrayBuilder.ofRef";
        }

        public ofRef(ClassTag<T> evidence$2) {
            this.evidence$2 = evidence$2;
            this.capacity = 0;
            this.size = 0;
        }
    }

    public static final class ofShort
    extends ArrayBuilder<Object> {
        private short[] elems;
        private int capacity = 0;
        private int size = 0;

        private short[] elems() {
            return this.elems;
        }

        private void elems_$eq(short[] x$1) {
            this.elems = x$1;
        }

        private int capacity() {
            return this.capacity;
        }

        private void capacity_$eq(int x$1) {
            this.capacity = x$1;
        }

        private int size() {
            return this.size;
        }

        private void size_$eq(int x$1) {
            this.size = x$1;
        }

        /*
         * WARNING - void declaration
         */
        private short[] mkArray(int size) {
            void var2_2;
            short[] newelems = new short[size];
            if (this.size() > 0) {
                Array$.MODULE$.copy(this.elems(), 0, newelems, 0, this.size());
            }
            return var2_2;
        }

        private void resize(int size) {
            this.elems_$eq(this.mkArray(size));
            this.capacity_$eq(size);
        }

        @Override
        public void sizeHint(int size) {
            if (this.capacity() < size) {
                this.resize(size);
            }
        }

        private void ensureSize(int size) {
            if (this.capacity() < size || this.capacity() == 0) {
                int newsize;
                int n = newsize = this.capacity() == 0 ? 16 : this.capacity() * 2;
                while (newsize < size) {
                    newsize *= 2;
                }
                this.resize(newsize);
            }
        }

        public ofShort $plus$eq(short elem) {
            this.ensureSize(this.size() + 1);
            this.elems()[this.size()] = elem;
            this.size_$eq(this.size() + 1);
            return this;
        }

        public ofShort $plus$plus$eq(TraversableOnce<Object> xs) {
            ofShort ofShort2;
            if (xs instanceof WrappedArray.ofShort) {
                WrappedArray.ofShort ofShort3 = (WrappedArray.ofShort)xs;
                this.ensureSize(this.size() + ofShort3.length());
                Array$.MODULE$.copy(ofShort3.array(), 0, this.elems(), this.size(), ofShort3.length());
                this.size_$eq(this.size() + ofShort3.length());
                ofShort2 = this;
            } else {
                ofShort2 = (ofShort)Growable.$plus$plus$eq$(this, xs);
            }
            return ofShort2;
        }

        @Override
        public void clear() {
            this.size_$eq(0);
        }

        @Override
        public short[] result() {
            if (this.capacity() != 0 && this.capacity() == this.size()) {
                this.capacity_$eq(0);
                return this.elems();
            }
            return this.mkArray(this.size());
        }

        public boolean equals(Object other) {
            boolean bl;
            if (other instanceof ofShort) {
                ofShort ofShort2 = (ofShort)other;
                bl = this.size() == ofShort2.size() && this.elems() == ofShort2.elems();
            } else {
                bl = false;
            }
            return bl;
        }

        public String toString() {
            return "ArrayBuilder.ofShort";
        }
    }

    public static final class ofUnit
    extends ArrayBuilder<BoxedUnit> {
        private int size = 0;

        private int size() {
            return this.size;
        }

        private void size_$eq(int x$1) {
            this.size = x$1;
        }

        public ofUnit $plus$eq(BoxedUnit elem) {
            this.size_$eq(this.size() + 1);
            return this;
        }

        public ofUnit $plus$plus$eq(TraversableOnce<BoxedUnit> xs) {
            this.size_$eq(this.size() + xs.size());
            return this;
        }

        @Override
        public void clear() {
            this.size_$eq(0);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public BoxedUnit[] result() {
            void var1_1;
            BoxedUnit[] ans = new BoxedUnit[this.size()];
            for (int i = 0; i < this.size(); ++i) {
                ans[i] = BoxedUnit.UNIT;
            }
            return var1_1;
        }

        public boolean equals(Object other) {
            boolean bl;
            if (other instanceof ofUnit) {
                ofUnit ofUnit2 = (ofUnit)other;
                bl = this.size() == ofUnit2.size();
            } else {
                bl = false;
            }
            return bl;
        }

        public String toString() {
            return "ArrayBuilder.ofUnit";
        }
    }
}

