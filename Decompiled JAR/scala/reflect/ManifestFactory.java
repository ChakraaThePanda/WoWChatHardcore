/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect;

import scala.None$;
import scala.Option;
import scala.Some;
import scala.collection.Seq;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.ArrayBuilder;
import scala.collection.mutable.WrappedArray;
import scala.reflect.AnyValManifest;
import scala.reflect.ClassManifestDeprecatedApis;
import scala.reflect.ClassTag;
import scala.reflect.Manifest;
import scala.reflect.ManifestFactory$;
import scala.reflect.ScalaSignature;
import scala.reflect.package$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.Null$;

@ScalaSignature(bytes="\u0006\u0001!\u0005r\u0001CA=\u0003wB\t!!\"\u0007\u0011\u0005%\u00151\u0010E\u0001\u0003\u0017Cq!!&\u0002\t\u0003\t9\nC\u0004\u0002\u001a\u0006!\t!a'\u0007\r\u0005%\u0017\u0001BAf\u0011\u001d\t)\n\u0002C\u0001\u0003+Dq!a7\u0005\t\u0003\ti\u000eC\u0004\u0002t\u0012!\t%!>\t\u000f\t\u001dA\u0001\"\u0011\u0003\n!9!Q\u0004\u0003\u0005B\t}\u0001b\u0002B\u0014\t\u0011\u0005#\u0011\u0006\u0005\b\u0005k!A\u0011\u0002B\u001c\u0011%\u0011)%\u0001b\u0001\n\u0003\u00119\u0005\u0003\u0005\u0003J\u0005\u0001\u000b\u0011BAg\r\u0019\u0011Y%\u0001\u0003\u0003N!9\u0011Q\u0013\b\u0005\u0002\t]\u0003bBAn\u001d\u0011\u0005!1\f\u0005\b\u0003gtA\u0011\tB2\u0011\u001d\u00119A\u0004C!\u0005SBqA!\b\u000f\t\u0003\u0012y\u0007C\u0004\u0003(9!\tEa\u001d\t\u000f\tUb\u0002\"\u0003\u00038!I!1P\u0001C\u0002\u0013\u0005!Q\u0010\u0005\t\u0005\u007f\n\u0001\u0015!\u0003\u0003P\u00191!\u0011Q\u0001\u0005\u0005\u0007Cq!!&\u0019\t\u0003\u0011i\tC\u0004\u0002\\b!\tA!%\t\u000f\u0005M\b\u0004\"\u0011\u0003\u001c\"9!q\u0001\r\u0005B\t\u0005\u0006b\u0002B\u000f1\u0011\u0005#q\u0015\u0005\b\u0005OAB\u0011\tBV\u0011\u001d\u0011)\u0004\u0007C\u0005\u0005oA\u0011Ba-\u0002\u0005\u0004%\tA!.\t\u0011\t]\u0016\u0001)A\u0005\u0005\u000b3aA!/\u0002\t\tm\u0006bBAKE\u0011\u0005!q\u0018\u0005\b\u00037\u0014C\u0011\u0001Bb\u0011\u001d\t\u0019P\tC!\u0005\u001bDqAa\u0002#\t\u0003\u0012\u0019\u000eC\u0004\u0003\u001e\t\"\tE!7\t\u000f\t\u001d\"\u0005\"\u0011\u0003^\"9!Q\u0007\u0012\u0005\n\t]\u0002\"\u0003Bs\u0003\t\u0007I\u0011\u0001Bt\u0011!\u0011I/\u0001Q\u0001\n\tufA\u0002Bv\u0003\u0011\u0011i\u000fC\u0004\u0002\u00162\"\tAa>\t\u000f\u0005mG\u0006\"\u0001\u0003|\"9\u00111\u001f\u0017\u0005B\r\r\u0001b\u0002B\u0004Y\u0011\u00053\u0011\u0002\u0005\b\u0005;aC\u0011IB\b\u0011\u001d\u00119\u0003\fC!\u0007'AqA!\u000e-\t\u0013\u00119\u0004C\u0005\u0004\u001c\u0005\u0011\r\u0011\"\u0001\u0004\u001e!A1qD\u0001!\u0002\u0013\u0011yO\u0002\u0004\u0004\"\u0005!11\u0005\u0005\b\u0003+3D\u0011AB\u0017\u0011\u001d\tYN\u000eC\u0001\u0007cAq!a=7\t\u0003\u001aI\u0004C\u0004\u0003\bY\"\tea\u0010\t\u000f\tua\u0007\"\u0011\u0004F!9!q\u0005\u001c\u0005B\r%\u0003b\u0002B\u001bm\u0011%!q\u0007\u0005\n\u0007#\n!\u0019!C\u0001\u0007'B\u0001b!\u0016\u0002A\u0003%1Q\u0005\u0004\u0007\u0007/\nAa!\u0017\t\u000f\u0005U\u0005\t\"\u0001\u0004d!9\u00111\u001c!\u0005\u0002\r\u001d\u0004bBAz\u0001\u0012\u00053q\u000e\u0005\b\u0005\u000f\u0001E\u0011IB;\u0011\u001d\u0011i\u0002\u0011C!\u0007wBqAa\nA\t\u0003\u001ay\bC\u0004\u00036\u0001#IAa\u000e\t\u0013\r\u001d\u0015A1A\u0005\u0002\r%\u0005\u0002CBF\u0003\u0001\u0006Iaa\u0017\u0007\r\r5\u0015\u0001BBH\u0011\u001d\t)J\u0013C\u0001\u00073Cq!a7K\t\u0003\u0019i\nC\u0004\u0002t*#\te!*\t\u000f\t\u001d!\n\"\u0011\u0004,\"9!Q\u0004&\u0005B\rE\u0006b\u0002B\u0014\u0015\u0012\u00053Q\u0017\u0005\b\u0005kQE\u0011\u0002B\u001c\u0011%\u0019i,\u0001b\u0001\n\u0003\u0019y\f\u0003\u0005\u0004B\u0006\u0001\u000b\u0011BBI\r\u0019\u0019\u0019-\u0001\u0003\u0004F\"9\u0011Q\u0013+\u0005\u0002\r=\u0007bBAn)\u0012\u000511\u001b\u0005\b\u0003g$F\u0011IBo\u0011\u001d\u00119\u0001\u0016C!\u0007GDqA!\bU\t\u0003\u001aI\u000fC\u0004\u0004nR#\tfa<\t\u000f\t\u001dB\u000b\"\u0011\u0005\u001e!9!Q\u0007+\u0005\n\t]\u0002\"\u0003C\u0013\u0003\t\u0007I\u0011\u0001C\u0014\u0011!!I#\u0001Q\u0001\n\r\u001d\u0007\"\u0003C\u0016\u0003\t\u0007I\u0011\u0002C\u0017\u0011!!9$\u0001Q\u0001\n\u0011=\u0002\"\u0003C\u001d\u0003\t\u0007I\u0011\u0002C\u001e\u0011!!Y%\u0001Q\u0001\n\u0011u\u0002\"\u0003C'\u0003\t\u0007I\u0011\u0002C(\u0011!!I&\u0001Q\u0001\n\u0011EcA\u0002C.\u0003\u0011!i\u0006C\u0004\u0002\u0016\u0016$\t!b\u0007\t\u000f\u0005MX\r\"\u0011\u0006 !9QQE3\u0005B\u0015\u001d\u0002b\u0002B\u001bK\u0012%!q\u0007\u0005\n\u000b\u0003\n!\u0019!C\u0001\u000b\u0007B\u0001\"b\u0012\u0002A\u0003%QQ\t\u0004\u0007\u000b\u0013\nA!b\u0013\t\u000f\u0005UE\u000e\"\u0001\u0006P!9\u00111\u001f7\u0005B\u0015M\u0003bBC\u0013Y\u0012\u0005S\u0011\f\u0005\b\u0005kaG\u0011\u0002B\u001c\u0011%)I'\u0001b\u0001\n\u0003)Y\u0007\u0003\u0005\u0006p\u0005\u0001\u000b\u0011BC7\u0011%)\t(\u0001b\u0001\n\u0003)\u0019\b\u0003\u0005\u0006x\u0005\u0001\u000b\u0011BC;\r\u0019)I(\u0001\u0003\u0006|!9\u0011QS;\u0005\u0002\u0015\u0015\u0005bBAzk\u0012\u0005S\u0011\u0012\u0005\b\u000bK)H\u0011ICH\u0011\u001d\u0011)$\u001eC\u0005\u0005oA\u0011\"b(\u0002\u0005\u0004%\t!\")\t\u0011\u0015\u0015\u0016\u0001)A\u0005\u000bG3a!b*\u0002\t\u0015%\u0006bBAKy\u0012\u0005Q1\u0017\u0005\b\u0003gdH\u0011IC\\\u0011\u001d))\u0003 C!\u000b{CqA!\u000e}\t\u0013\u00119\u0004C\u0005\u0006N\u0006\u0011\r\u0011\"\u0001\u0006P\"AQ1[\u0001!\u0002\u0013)\tN\u0002\u0004\u0006V\u0006!Qq\u001b\u0005\t\u0003+\u000b9\u0001\"\u0001\u0006\\\"A\u00111_A\u0004\t\u0003*y\u000e\u0003\u0005\u0006&\u0005\u001dA\u0011ICs\u0011!\u0011)$a\u0002\u0005\n\t]\u0002\"CC{\u0003\t\u0007I\u0011AC|\u0011!)Y0\u0001Q\u0001\n\u0015ehABC\u007f\u0003\u0011)y\u0010C\u0006\u0003B\u0005U!\u0011!Q\u0001\n\u00055\u0005\u0002CAK\u0003+!\tAb\u0003\t\u0017\u0005m\u0017Q\u0003EC\u0002\u0013\u0005a\u0011\u0003\u0005\f\t\u001f\f)\u0002#b\u0001\n\u00032Y\u0002C\u0004\u0007 \u0005!\tA\"\t\t\u000f\u00195\u0012\u0001\"\u0001\u00070!9aQF\u0001\u0005\u0002\u0019\u001d\u0003b\u0002D\u0017\u0003\u0011\u0005a\u0011\u0010\u0004\b\tC\n\u0011\u0011\u0002C2\u00115!y.a\n\u0003\u0002\u0003\u0006I\u0001\"9\u0002<!YAqZA\u0014\u0005\u000b\u0007I\u0011\tCv\u0011-!\t0a\n\u0003\u0002\u0003\u0006I\u0001\"<\t\u0011\u0005U\u0015q\u0005C\u0001\tgD\u0001\"b\u0001\u0002(\u0011\u0005SQ\u0001\u0005\u000b\u000b\u0017\t9C1A\u0005B\u00155\u0001\"CC\b\u0003O\u0001\u000b\u0011\u0002B\u0001\r\u0019!I'\u0001\u0003\u0005l!YA\u0011PA\u001c\u0005\u0003\u0005\u000b\u0011\u0002C>\u0011-\tY.a\u000e\u0003\u0006\u0004%\t\u0001b\"\t\u0017\u0011U\u0015q\u0007B\u0001B\u0003%A\u0011\u0012\u0005\f\t/\u000b9D!b\u0001\n\u0003\"I\nC\u0006\u0005(\u0006]\"\u0011!Q\u0001\n\u0011m\u0005\u0002CAK\u0003o!\t\u0001\"+\t\u0011\u0011=\u0017q\u0007C!\t#DqA\"+\u0002\t\u00031YK\u0002\u0004\u0007F\u0006!aq\u0019\u0005\f\ts\nIE!A!\u0002\u00131\t\u000eC\u0006\u0007\\\u0006%#\u0011!Q\u0001\n\u00115\bb\u0003Do\u0003\u0013\u0012\t\u0011)A\u0005\r?D1B\"\u001a\u0002J\t\u0005\t\u0015!\u0003\u0007j\"A\u0011QSA%\t\u00031I\u0010\u0003\u0005\u0002\\\u0006%C\u0011AD\u0010\u0011)!9*!\u0013C\u0002\u0013\u0005s\u0011\u0006\u0005\n\tO\u000bI\u0005)A\u0005\u000fWA\u0001\u0002b4\u0002J\u0011\u0005C\u0011\u001b\u0005\b\u000f_\tA\u0011AD\u0019\r\u00199\u0019'\u0001\u0003\bf!YqqNA0\u0005\u0003\u0005\u000b\u0011BD9\u0011-1i.a\u0018\u0003\u0002\u0003\u0006Iab\u001f\t\u0011\u0005U\u0015q\fC\u0001\u000f\u000bC\u0001\"a7\u0002`\u0011\u0005qQ\u0014\u0005\t\t\u001f\fy\u0006\"\u0011\u0005R\"9q1V\u0001\u0005\u0002\u001d5fABDh\u0003\u00119\t\u000eC\u0006\b\\\u00065$\u0011!Q\u0001\n\u001du\u0007\u0002CAK\u0003[\"\ta\";\t\u0011\u0005m\u0017Q\u000eC\u0001\u000fsD\u0001\u0002b4\u0002n\u0011\u0005\u00032\u0001\u0005\b\u0011\u000f\tA\u0011\u0001E\u0005\u0003=i\u0015M\\5gKN$h)Y2u_JL(\u0002BA?\u0003\u007f\nqA]3gY\u0016\u001cGO\u0003\u0002\u0002\u0002\u0006)1oY1mC\u000e\u0001\u0001cAAD\u00035\u0011\u00111\u0010\u0002\u0010\u001b\u0006t\u0017NZ3ti\u001a\u000b7\r^8ssN\u0019\u0011!!$\u0011\t\u0005=\u0015\u0011S\u0007\u0003\u0003\u007fJA!a%\u0002\u0000\t1\u0011I\\=SK\u001a\fa\u0001P5oSRtDCAAC\u000391\u0018\r\\;f\u001b\u0006t\u0017NZ3tiN,\"!!(\u0011\r\u0005}\u0015QUAV\u001d\u0011\ty)!)\n\t\u0005\r\u0016qP\u0001\ba\u0006\u001c7.Y4f\u0013\u0011\t9+!+\u0003\t1K7\u000f\u001e\u0006\u0005\u0003G\u000by\b\r\u0003\u0002.\u0006]\u0006CBAD\u0003_\u000b\u0019,\u0003\u0003\u00022\u0006m$AD!osZ\u000bG.T1oS\u001a,7\u000f\u001e\t\u0005\u0003k\u000b9\f\u0004\u0001\u0005\u0017\u0005e6!!A\u0001\u0002\u000b\u0005\u00111\u0018\u0002\u0004?\u0012\u001a\u0014\u0003BA_\u0003\u0007\u0004B!a$\u0002@&!\u0011\u0011YA@\u0005\u001dqu\u000e\u001e5j]\u001e\u0004B!a$\u0002F&!\u0011qYA@\u0005\r\te.\u001f\u0002\r\u0005f$X-T1oS\u001a,7\u000f^\n\u0004\t\u00055\u0007CBAD\u0003_\u000by\r\u0005\u0003\u0002\u0010\u0006E\u0017\u0002BAj\u0003\u007f\u0012AAQ=uKR\u0011\u0011q\u001b\t\u0004\u00033$Q\"A\u0001\u0002\u0019I,h\u000e^5nK\u000ec\u0017m]:\u0016\u0005\u0005}\u0007CBAq\u0003W\fy/\u0004\u0002\u0002d*!\u0011Q]At\u0003\u0011a\u0017M\\4\u000b\u0005\u0005%\u0018\u0001\u00026bm\u0006LA!!<\u0002d\n)1\t\\1tgB!\u0011\u0011]Ay\u0013\u0011\t\u0019.a9\u0002\u00119,w/\u0011:sCf$B!a>\u0002~B1\u0011qRA}\u0003\u001fLA!a?\u0002\u0000\t)\u0011I\u001d:bs\"9\u0011q`\u0004A\u0002\t\u0005\u0011a\u00017f]B!\u0011q\u0012B\u0002\u0013\u0011\u0011)!a \u0003\u0007%sG/A\boK^<&/\u00199qK\u0012\f%O]1z)\u0011\u0011YAa\u0007\u0011\r\t5!qCAh\u001b\t\u0011yA\u0003\u0003\u0003\u0012\tM\u0011aB7vi\u0006\u0014G.\u001a\u0006\u0005\u0005+\ty(\u0001\u0006d_2dWm\u0019;j_:LAA!\u0007\u0003\u0010\taqK]1qa\u0016$\u0017I\u001d:bs\"9\u0011q \u0005A\u0002\t\u0005\u0011a\u00048fo\u0006\u0013(/Y=Ck&dG-\u001a:\u0015\u0005\t\u0005\u0002C\u0002B\u0007\u0005G\ty-\u0003\u0003\u0003&\t=!\u0001D!se\u0006L()^5mI\u0016\u0014\u0018aB;oCB\u0004H.\u001f\u000b\u0005\u0005W\u0011\t\u0004\u0005\u0004\u0002\u0010\n5\u0012qZ\u0005\u0005\u0005_\tyH\u0001\u0004PaRLwN\u001c\u0005\b\u0005gQ\u0001\u0019AAb\u0003\u0005A\u0018a\u0003:fC\u0012\u0014Vm]8mm\u0016$\"!a1)\u000f\u0011\u0011YD!\u0011\u0003DA!\u0011q\u0012B\u001f\u0013\u0011\u0011y$a \u0003!M+'/[1m-\u0016\u00148/[8o+&#\u0015!\u0002<bYV,g$A\u0001\u0002\t\tKH/Z\u000b\u0003\u0003\u001b\fQAQ=uK\u0002\u0012Qb\u00155peRl\u0015M\\5gKN$8c\u0001\b\u0003PA1\u0011qQAX\u0005#\u0002B!a$\u0003T%!!QKA@\u0005\u0015\u0019\u0006n\u001c:u)\t\u0011I\u0006E\u0002\u0002Z:)\"A!\u0018\u0011\r\u0005\u0005\u00181\u001eB0!\u0011\t\tO!\u0019\n\t\tU\u00131\u001d\u000b\u0005\u0005K\u00129\u0007\u0005\u0004\u0002\u0010\u0006e(\u0011\u000b\u0005\b\u0003\u007f\f\u0002\u0019\u0001B\u0001)\u0011\u0011YG!\u001c\u0011\r\t5!q\u0003B)\u0011\u001d\tyP\u0005a\u0001\u0005\u0003!\"A!\u001d\u0011\r\t5!1\u0005B))\u0011\u0011)Ha\u001e\u0011\r\u0005=%Q\u0006B)\u0011\u001d\u0011\u0019\u0004\u0006a\u0001\u0003\u0007DsA\u0004B\u001e\u0005\u0003\u0012\u0019%A\u0003TQ>\u0014H/\u0006\u0002\u0003P\u000511\u000b[8si\u0002\u0012Ab\u00115be6\u000bg.\u001b4fgR\u001c2\u0001\u0007BC!\u0019\t9)a,\u0003\bB!\u0011q\u0012BE\u0013\u0011\u0011Y)a \u0003\t\rC\u0017M\u001d\u000b\u0003\u0005\u001f\u00032!!7\u0019+\t\u0011\u0019\n\u0005\u0004\u0002b\u0006-(Q\u0013\t\u0005\u0003C\u00149*\u0003\u0003\u0003\u001a\u0006\r(!C\"iCJ\f7\r^3s)\u0011\u0011iJa(\u0011\r\u0005=\u0015\u0011 BD\u0011\u001d\typ\u0007a\u0001\u0005\u0003!BAa)\u0003&B1!Q\u0002B\f\u0005\u000fCq!a@\u001d\u0001\u0004\u0011\t\u0001\u0006\u0002\u0003*B1!Q\u0002B\u0012\u0005\u000f#BA!,\u00030B1\u0011q\u0012B\u0017\u0005\u000fCqAa\r\u001f\u0001\u0004\t\u0019\rK\u0004\u0019\u0005w\u0011\tEa\u0011\u0002\t\rC\u0017M]\u000b\u0003\u0005\u000b\u000bQa\u00115be\u0002\u00121\"\u00138u\u001b\u0006t\u0017NZ3tiN\u0019!E!0\u0011\r\u0005\u001d\u0015q\u0016B\u0001)\t\u0011\t\rE\u0002\u0002Z\n*\"A!2\u0011\r\u0005\u0005\u00181\u001eBd!\u0011\t\tO!3\n\t\t-\u00171\u001d\u0002\b\u0013:$XmZ3s)\u0011\u0011yM!5\u0011\r\u0005=\u0015\u0011 B\u0001\u0011\u001d\ty0\na\u0001\u0005\u0003!BA!6\u0003XB1!Q\u0002B\f\u0005\u0003Aq!a@'\u0001\u0004\u0011\t\u0001\u0006\u0002\u0003\\B1!Q\u0002B\u0012\u0005\u0003!BAa8\u0003bB1\u0011q\u0012B\u0017\u0005\u0003AqAa\r)\u0001\u0004\t\u0019\rK\u0004#\u0005w\u0011\tEa\u0011\u0002\u0007%sG/\u0006\u0002\u0003>\u0006!\u0011J\u001c;!\u00051auN\\4NC:Lg-Z:u'\ra#q\u001e\t\u0007\u0003\u000f\u000byK!=\u0011\t\u0005=%1_\u0005\u0005\u0005k\fyH\u0001\u0003M_:<GC\u0001B}!\r\tI\u000eL\u000b\u0003\u0005{\u0004b!!9\u0002l\n}\b\u0003BAq\u0007\u0003IAA!>\u0002dR!1QAB\u0004!\u0019\ty)!?\u0003r\"9\u0011q`\u0018A\u0002\t\u0005A\u0003BB\u0006\u0007\u001b\u0001bA!\u0004\u0003\u0018\tE\bbBA\u0000a\u0001\u0007!\u0011\u0001\u000b\u0003\u0007#\u0001bA!\u0004\u0003$\tEH\u0003BB\u000b\u0007/\u0001b!a$\u0003.\tE\bb\u0002B\u001ae\u0001\u0007\u00111\u0019\u0015\bY\tm\"\u0011\tB\"\u0003\u0011auN\\4\u0016\u0005\t=\u0018!\u0002'p]\u001e\u0004#!\u0004$m_\u0006$X*\u00198jM\u0016\u001cHoE\u00027\u0007K\u0001b!a\"\u00020\u000e\u001d\u0002\u0003BAH\u0007SIAaa\u000b\u0002\u0000\t)a\t\\8biR\u00111q\u0006\t\u0004\u000334TCAB\u001a!\u0019\t\t/a;\u00046A!\u0011\u0011]B\u001c\u0013\u0011\u0019Y#a9\u0015\t\rm2Q\b\t\u0007\u0003\u001f\u000bIpa\n\t\u000f\u0005}\u0018\b1\u0001\u0003\u0002Q!1\u0011IB\"!\u0019\u0011iAa\u0006\u0004(!9\u0011q \u001eA\u0002\t\u0005ACAB$!\u0019\u0011iAa\t\u0004(Q!11JB'!\u0019\tyI!\f\u0004(!9!1\u0007\u001fA\u0002\u0005\r\u0007f\u0002\u001c\u0003<\t\u0005#1I\u0001\u0006\r2|\u0017\r^\u000b\u0003\u0007K\taA\u00127pCR\u0004#A\u0004#pk\ndW-T1oS\u001a,7\u000f^\n\u0004\u0001\u000em\u0003CBAD\u0003_\u001bi\u0006\u0005\u0003\u0002\u0010\u000e}\u0013\u0002BB1\u0003\u007f\u0012a\u0001R8vE2,GCAB3!\r\tI\u000eQ\u000b\u0003\u0007S\u0002b!!9\u0002l\u000e-\u0004\u0003BAq\u0007[JAa!\u0019\u0002dR!1\u0011OB:!\u0019\ty)!?\u0004^!9\u0011q`\"A\u0002\t\u0005A\u0003BB<\u0007s\u0002bA!\u0004\u0003\u0018\ru\u0003bBA\u0000\t\u0002\u0007!\u0011\u0001\u000b\u0003\u0007{\u0002bA!\u0004\u0003$\ruC\u0003BBA\u0007\u0007\u0003b!a$\u0003.\ru\u0003b\u0002B\u001a\r\u0002\u0007\u00111\u0019\u0015\b\u0001\nm\"\u0011\tB\"\u0003\u0019!u.\u001e2mKV\u001111L\u0001\b\t>,(\r\\3!\u0005=\u0011un\u001c7fC:l\u0015M\\5gKN$8c\u0001&\u0004\u0012B1\u0011qQAX\u0007'\u0003B!a$\u0004\u0016&!1qSA@\u0005\u001d\u0011un\u001c7fC:$\"aa'\u0011\u0007\u0005e'*\u0006\u0002\u0004 B1\u0011\u0011]Av\u0007C\u0003B!!9\u0004$&!1qSAr)\u0011\u00199k!+\u0011\r\u0005=\u0015\u0011`BJ\u0011\u001d\ty0\u0014a\u0001\u0005\u0003!Ba!,\u00040B1!Q\u0002B\f\u0007'Cq!a@O\u0001\u0004\u0011\t\u0001\u0006\u0002\u00044B1!Q\u0002B\u0012\u0007'#Baa.\u0004:B1\u0011q\u0012B\u0017\u0007'CqAa\rQ\u0001\u0004\t\u0019\rK\u0004K\u0005w\u0011\tEa\u0011\u0002\u000f\t{w\u000e\\3b]V\u00111\u0011S\u0001\t\u0005>|G.Z1oA\taQK\\5u\u001b\u0006t\u0017NZ3tiN\u0019Aka2\u0011\r\u0005\u001d\u0015qVBe!\u0011\tyia3\n\t\r5\u0017q\u0010\u0002\u0005+:LG\u000f\u0006\u0002\u0004RB\u0019\u0011\u0011\u001c+\u0016\u0005\rU\u0007CBAq\u0003W\u001c9\u000e\u0005\u0003\u0002b\u000ee\u0017\u0002BBn\u0003G\u0014AAV8jIR!1q\\Bq!\u0019\ty)!?\u0004J\"9\u0011q`,A\u0002\t\u0005A\u0003BBs\u0007O\u0004bA!\u0004\u0003\u0018\r%\u0007bBA\u00001\u0002\u0007!\u0011\u0001\u000b\u0003\u0007W\u0004bA!\u0004\u0003$\r%\u0017AC1se\u0006L8\t\\1tgV!1\u0011\u001fC\u0006)\u0011\u0019\u0019\u0010b\u0004\u0011\r\rUH1\u0001C\u0004\u001d\u0011\u00199pa@\u0011\t\re\u0018qP\u0007\u0003\u0007wTAa!@\u0002\u0004\u00061AH]8pizJA\u0001\"\u0001\u0002\u0000\u00051\u0001K]3eK\u001aLA!!<\u0005\u0006)!A\u0011AA@!\u0019\ty)!?\u0005\nA!\u0011Q\u0017C\u0006\t\u001d!iA\u0017b\u0001\u0003w\u0013\u0011\u0001\u0016\u0005\b\t#Q\u0006\u0019\u0001C\n\u0003\t!\b\u000f\r\u0003\u0005\u0016\u0011e\u0001CBB{\t\u0007!9\u0002\u0005\u0003\u00026\u0012eA\u0001\u0004C\u000e\t\u001f\t\t\u0011!A\u0003\u0002\u0005m&aA0%iQ!Aq\u0004C\u0011!\u0019\tyI!\f\u0004J\"9!1G.A\u0002\u0005\r\u0007f\u0002+\u0003<\t\u0005#1I\u0001\u0005+:LG/\u0006\u0002\u0004H\u0006)QK\\5uA\u0005QqJ\u00196fGR$\u0016\fU#\u0016\u0005\u0011=\u0002CBAq\u0003W$\t\u0004\u0005\u0003\u0002b\u0012M\u0012\u0002\u0002C\u001b\u0003G\u0014aa\u00142kK\u000e$\u0018aC(cU\u0016\u001cG\u000fV-Q\u000b\u0002\n1BT8uQ&tw\rV-Q\u000bV\u0011AQ\b\t\u0007\u0003C\fY\u000fb\u0010\u0011\t\u0011\u0005CqI\u0007\u0003\t\u0007RA\u0001\"\u0012\u0002\u0000\u00059!/\u001e8uS6,\u0017\u0002\u0002C%\t\u0007\u0012\u0001BT8uQ&tw\rJ\u0001\r\u001d>$\b.\u001b8h)f\u0003V\tI\u0001\t\u001dVdG\u000eV-Q\u000bV\u0011A\u0011\u000b\t\u0007\u0003C\fY\u000fb\u0015\u0011\t\u0011\u0005CQK\u0005\u0005\t/\"\u0019EA\u0003Ok2dG%A\u0005Ok2dG+\u0017)FA\tY\u0011I\\=NC:Lg-Z:u'\r)Gq\f\t\u0007\u00033\f9#a1\u0003\u001fAC\u0017M\u001c;p[6\u000bg.\u001b4fgR,B\u0001\"\u001a\u0005^N!\u0011q\u0005C4!\u0019\tI.a\u000e\u0005\\\n\t2\t\\1tgRK\b/Z'b]&4Wm\u001d;\u0016\t\u00115DqO\n\u0007\u0003o\ti\tb\u001c\u0011\r\u0005\u001dE\u0011\u000fC;\u0013\u0011!\u0019(a\u001f\u0003\u00115\u000bg.\u001b4fgR\u0004B!!.\u0005x\u0011AAQBA\u001c\u0005\u0004\tY,\u0001\u0004qe\u00164\u0017\u000e\u001f\t\u0007\u0003\u001f\u0013i\u0003\" 1\t\u0011}D1\u0011\t\u0007\u0003\u000f#\t\b\"!\u0011\t\u0005UF1\u0011\u0003\r\t\u000b\u000bI$!A\u0001\u0002\u000b\u0005\u00111\u0018\u0002\u0005?\u0012\nt'\u0006\u0002\u0005\nB\"A1\u0012CI!\u0019!i\tb\u0001\u0005\u0010:!\u0011qRB\u0000!\u0011\t)\f\"%\u0005\u0019\u0011M\u0015QHA\u0001\u0002\u0003\u0015\t!a/\u0003\t}#\u0013\u0007O\u0001\u000eeVtG/[7f\u00072\f7o\u001d\u0011\u0002\u001bQL\b/Z!sOVlWM\u001c;t+\t!Y\n\u0005\u0004\u0002 \u0006\u0015FQ\u0014\u0019\u0005\t?#\u0019\u000b\u0005\u0004\u0002\b\u0012ED\u0011\u0015\t\u0005\u0003k#\u0019\u000b\u0002\u0007\u0005&\u0006\u0005\u0013\u0011!A\u0001\u0006\u0003\tYL\u0001\u0003`IEJ\u0014A\u0004;za\u0016\f%oZ;nK:$8\u000f\t\u000b\t\tW#i\u000b\"/\u0005DB1\u0011\u0011\\A\u001c\tkB\u0001\u0002\"\u001f\u0002D\u0001\u0007Aq\u0016\t\u0007\u0003\u001f\u0013i\u0003\"-1\t\u0011MFq\u0017\t\u0007\u0003\u000f#\t\b\".\u0011\t\u0005UFq\u0017\u0003\r\t\u000b#i+!A\u0001\u0002\u000b\u0005\u00111\u0018\u0005\t\u00037\f\u0019\u00051\u0001\u0005<B\"AQ\u0018Ca!\u0019!i\tb\u0001\u0005@B!\u0011Q\u0017Ca\t1!\u0019\n\"/\u0002\u0002\u0003\u0005)\u0011AA^\u0011!!9*a\u0011A\u0002\u0011\u0015\u0007CBAP\u0003K#9\r\r\u0003\u0005J\u00125\u0007CBAD\tc\"Y\r\u0005\u0003\u00026\u00125G\u0001\u0004CS\t\u0007\f\t\u0011!A\u0003\u0002\u0005m\u0016\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0005\u0011M\u0007\u0003BAq\t+LA\u0001b6\u0002d\n11\u000b\u001e:j]\u001eD\u0003\"a\u000e\u0003<\t\u0005#1\t\t\u0005\u0003k#i\u000e\u0002\u0005\u0005\u000e\u0005\u001d\"\u0019AA^\u00035y&/\u001e8uS6,7\t\\1tgB\"A1\u001dCt!\u0019!i\tb\u0001\u0005fB!\u0011Q\u0017Ct\t1!I/!\u000b\u0002\u0002\u0003\u0005)\u0011AA^\u0005\u0011yF%\r\u001c\u0016\u0005\u00115\b\u0003BB{\t_LA\u0001b6\u0005\u0006\u0005IAo\\*ue&tw\r\t\u000b\u0007\tk$90\"\u0001\u0011\r\u0005e\u0017q\u0005Cn\u0011!!y.a\fA\u0002\u0011e\b\u0007\u0002C~\t\u007f\u0004b\u0001\"$\u0005\u0004\u0011u\b\u0003BA[\t\u007f$A\u0002\";\u0005x\u0006\u0005\t\u0011!B\u0001\u0003wC\u0001\u0002b4\u00020\u0001\u0007AQ^\u0001\u0007KF,\u0018\r\\:\u0015\t\rMUq\u0001\u0005\t\u000b\u0013\t\t\u00041\u0001\u0002D\u0006!A\u000f[1u\u0003!A\u0017m\u001d5D_\u0012,WC\u0001B\u0001\u0003%A\u0017m\u001d5D_\u0012,\u0007\u0005\u000b\u0003\u00026\u0015M\u0001\u0003BAH\u000b+IA!b\u0006\u0002\u0000\tIAO]1og&,g\u000e\u001e\u0015\t\u0003O\u0011YD!\u0011\u0003DQ\u0011QQ\u0004\t\u0004\u00033,G\u0003BC\u0011\u000bG\u0001b!a$\u0002z\u0006\r\u0007bBA\u0000O\u0002\u0007!\u0011A\u0001\u0011I1,7o\u001d\u0013d_2|g\u000e\n7fgN$Baa%\u0006*!9Q\u0011\u00025A\u0002\u0015-\u0002\u0007BC\u0017\u000bw\u0001b!b\f\u00064\u0015eb\u0002BAD\u000bcIA!a)\u0002|%!QQGC\u001c\u00055\u0019E.Y:t\u001b\u0006t\u0017NZ3ti*!\u00111UA>!\u0011\t),b\u000f\u0005\u0019\u0015uR\u0011FA\u0001\u0002\u0003\u0015\t!a/\u0003\u0007}#S\u0007K\u0004f\u0005w\u0011\tEa\u0011\u0002\u0007\u0005s\u00170\u0006\u0002\u0006FA1\u0011q\u0011C9\u0003\u0007\fA!\u00118zA\tqqJ\u00196fGRl\u0015M\\5gKN$8c\u00017\u0006NA1\u0011\u0011\\A\u0014\tc!\"!\"\u0015\u0011\u0007\u0005eG\u000e\u0006\u0003\u0006V\u0015]\u0003CBAH\u0003s$\t\u0004C\u0004\u0002\u0000:\u0004\rA!\u0001\u0015\t\rMU1\f\u0005\b\u000b\u0013y\u0007\u0019AC/a\u0011)y&b\u0019\u0011\r\u0015=R1GC1!\u0011\t),b\u0019\u0005\u0019\u0015\u0015T1LA\u0001\u0002\u0003\u0015\t!a/\u0003\u0007}#c\u0007K\u0004m\u0005w\u0011\tEa\u0011\u0002\r=\u0013'.Z2u+\t)i\u0007\u0005\u0004\u0002\b\u0012ED\u0011G\u0001\b\u001f\nTWm\u0019;!\u0003\u0019\te.\u001f*fMV\u0011QQ\u000f\t\u0007\u0003\u000f#\t(!$\u0002\u000f\u0005s\u0017PU3gA\t)\u0012I\\=WC2\u0004\u0006.\u00198u_6l\u0015M\\5gKN$8cA;\u0006~A1\u0011\u0011\\A\u0014\u000b\u007f\u0002B!a$\u0006\u0002&!Q1QA@\u0005\u0019\te.\u001f,bYR\u0011Qq\u0011\t\u0004\u00033,H\u0003BCF\u000b\u001b\u0003b!a$\u0002z\u0016}\u0004bBA\u0000o\u0002\u0007!\u0011\u0001\u000b\u0005\u0007'+\t\nC\u0004\u0006\na\u0004\r!b%1\t\u0015UU\u0011\u0014\t\u0007\u000b_)\u0019$b&\u0011\t\u0005UV\u0011\u0014\u0003\r\u000b7+\t*!A\u0001\u0002\u000b\u0005\u00111\u0018\u0002\u0004?\u0012:\u0004fB;\u0003<\t\u0005#1I\u0001\u0007\u0003:Lh+\u00197\u0016\u0005\u0015\r\u0006CBAD\tc*y(A\u0004B]f4\u0016\r\u001c\u0011\u0003\u00199+H\u000e\\'b]&4Wm\u001d;\u0014\u0007q,Y\u000b\u0005\u0004\u0002Z\u0006\u001dRQ\u0016\t\u0005\u0003\u001f+y+\u0003\u0003\u00062\u0006}$\u0001\u0002(vY2$\"!\".\u0011\u0007\u0005eG\u0010\u0006\u0003\u0006:\u0016m\u0006CBAH\u0003s,i\u000bC\u0004\u0002\u0000z\u0004\rA!\u0001\u0015\t\rMUq\u0018\u0005\b\u000b\u0013y\b\u0019ACaa\u0011)\u0019-b2\u0011\r\u0015=R1GCc!\u0011\t),b2\u0005\u0019\u0015%WqXA\u0001\u0002\u0003\u0015\t!a/\u0003\u0007}#\u0003\bK\u0004}\u0005w\u0011\tEa\u0011\u0002\t9+H\u000e\\\u000b\u0003\u000b#\u0004b!a\"\u0005r\u00155\u0016!\u0002(vY2\u0004#a\u0004(pi\"LgnZ'b]&4Wm\u001d;\u0014\t\u0005\u001dQ\u0011\u001c\t\u0007\u00033\f9#!0\u0015\u0005\u0015u\u0007\u0003BAm\u0003\u000f!B!\"9\u0006dB1\u0011qRA}\u0003{C\u0001\"a@\u0002\f\u0001\u0007!\u0011\u0001\u000b\u0005\u0007'+9\u000f\u0003\u0005\u0006\n\u00055\u0001\u0019ACua\u0011)Y/b<\u0011\r\u0015=R1GCw!\u0011\t),b<\u0005\u0019\u0015EXq]A\u0001\u0002\u0003\u0015\t!a/\u0003\u0007}#\u0013\b\u000b\u0005\u0002\b\tm\"\u0011\tB\"\u0003\u001dqu\u000e\u001e5j]\u001e,\"!\"?\u0011\r\u0005\u001dE\u0011OA_\u0003!qu\u000e\u001e5j]\u001e\u0004#!F*j]\u001edW\r^8o)f\u0004X-T1oS\u001a,7\u000f^\u000b\u0005\r\u000319a\u0005\u0004\u0002\u0016\u00055e1\u0001\t\u0007\u0003\u000f#\tH\"\u0002\u0011\t\u0005Ufq\u0001\u0003\t\t\u001b\t)B1\u0001\u0007\nE!\u0011QXAG)\u00111iAb\u0004\u0011\r\u0005e\u0017Q\u0003D\u0003\u0011!\u0011\t%!\u0007A\u0002\u00055UC\u0001D\na\u00111)B\"\u0007\u0011\r\u0005\u0005\u00181\u001eD\f!\u0011\t)L\"\u0007\u0005\u0019\u00115\u00111DA\u0001\u0002\u0003\u0015\tA\"\u0003\u0016\u0005\u0011M\u0007\u0006CA\u000b\u0005w\u0011\tEa\u0011\u0002\u0015MLgn\u001a7f)f\u0004X-\u0006\u0003\u0007$\u0019%B\u0003\u0002D\u0013\rW\u0001b!a\"\u0005r\u0019\u001d\u0002\u0003BA[\rS!\u0001\u0002\"\u0004\u0002 \t\u0007a\u0011\u0002\u0005\t\u0005\u0003\ny\u00021\u0001\u0002\u000e\u0006I1\r\\1tgRK\b/Z\u000b\u0005\rc19\u0004\u0006\u0003\u00074\u0019e\u0002CBAD\tc2)\u0004\u0005\u0003\u00026\u001a]B\u0001\u0003C\u0007\u0003C\u0011\r!a/\t\u0011\u0019m\u0012\u0011\u0005a\u0001\r{\tQa\u00197buj\u0004DAb\u0010\u0007DA1AQ\u0012C\u0002\r\u0003\u0002B!!.\u0007D\u0011aaQ\tD\u001d\u0003\u0003\u0005\tQ!\u0001\u0002<\n!q\fJ\u00191+\u00111IEb\u0014\u0015\u0011\u0019-c\u0011\u000bD+\rG\u0002b!a\"\u0005r\u00195\u0003\u0003BA[\r\u001f\"\u0001\u0002\"\u0004\u0002$\t\u0007\u00111\u0018\u0005\t\rw\t\u0019\u00031\u0001\u0007TA1AQ\u0012C\u0002\r\u001bB\u0001Bb\u0016\u0002$\u0001\u0007a\u0011L\u0001\u0005CJ<\u0017\u0007\r\u0003\u0007\\\u0019}\u0003CBAD\tc2i\u0006\u0005\u0003\u00026\u001a}C\u0001\u0004D1\r+\n\t\u0011!A\u0003\u0002\u0005m&\u0001B0%cEB\u0001B\"\u001a\u0002$\u0001\u0007aqM\u0001\u0005CJ<7\u000f\u0005\u0004\u0002\u0010\u001a%dQN\u0005\u0005\rW\nyH\u0001\u0006=e\u0016\u0004X-\u0019;fIz\u0002DAb\u001c\u0007tA1\u0011q\u0011C9\rc\u0002B!!.\u0007t\u0011aaQ\u000fD<\u0003\u0003\u0005\tQ!\u0001\u0002<\n!q\fJ\u00193\u0011!1)'a\tA\u0002\u0019\u001dT\u0003\u0002D>\r\u0003#\u0002B\" \u0007\u0004\u001a=e1\u0014\t\u0007\u0003\u000f#\tHb \u0011\t\u0005Uf\u0011\u0011\u0003\t\t\u001b\t)C1\u0001\u0002<\"AA\u0011PA\u0013\u0001\u00041)\t\r\u0003\u0007\b\u001a-\u0005CBAD\tc2I\t\u0005\u0003\u00026\u001a-E\u0001\u0004DG\r\u0007\u000b\t\u0011!A\u0003\u0002\u0005m&\u0001B0%cMB\u0001Bb\u000f\u0002&\u0001\u0007a\u0011\u0013\u0019\u0005\r'39\n\u0005\u0004\u0005\u000e\u0012\raQ\u0013\t\u0005\u0003k39\n\u0002\u0007\u0007\u001a\u001a=\u0015\u0011!A\u0001\u0006\u0003\tYL\u0001\u0003`IE\"\u0004\u0002\u0003D3\u0003K\u0001\rA\"(\u0011\r\u0005=e\u0011\u000eDPa\u00111\tK\"*\u0011\r\u0005\u001dE\u0011\u000fDR!\u0011\t)L\"*\u0005\u0019\u0019\u001df1TA\u0001\u0002\u0003\u0015\t!a/\u0003\t}#\u0013'N\u0001\nCJ\u0014\u0018-\u001f+za\u0016,BA\",\u00076R!aq\u0016D\\!\u0019\t9\t\"\u001d\u00072B1\u0011qRA}\rg\u0003B!!.\u00076\u0012AAQBA$\u0005\u0004\tY\f\u0003\u0005\u0007:\u0006\u001d\u0003\u0019\u0001D^\u0003\r\t'o\u001a\u0019\u0005\r{3\t\r\u0005\u0004\u0002\b\u0012Edq\u0018\t\u0005\u0003k3\t\r\u0002\u0007\u0007D\u001a]\u0016\u0011!A\u0001\u0006\u0003\tYL\u0001\u0003`II\u0002$\u0001F!cgR\u0014\u0018m\u0019;UsB,W*\u00198jM\u0016\u001cH/\u0006\u0003\u0007J\u001a=7CBA%\u0003\u001b3Y\r\u0005\u0004\u0002\b\u0012EdQ\u001a\t\u0005\u0003k3y\r\u0002\u0005\u0005\u000e\u0005%#\u0019AA^a\u00111\u0019Nb6\u0011\r\u0005\u001dE\u0011\u000fDk!\u0011\t)Lb6\u0005\u0019\u0019e\u00171JA\u0001\u0002\u0003\u0015\t!a/\u0003\t}##'M\u0001\u0005]\u0006lW-\u0001\u0006vaB,'OQ8v]\u0012\u0004DA\"9\u0007fB1AQ\u0012C\u0002\rG\u0004B!!.\u0007f\u0012aaq]A(\u0003\u0003\u0005\tQ!\u0001\u0002<\n!q\f\n\u001a3!\u0019\tyJb;\u0007p&!aQ^AU\u0005\r\u0019V-\u001d\u0019\u0005\rc4)\u0010\u0005\u0004\u0002\b\u0012Ed1\u001f\t\u0005\u0003k3)\u0010\u0002\u0007\u0007x\u0006E\u0013\u0011!A\u0001\u0006\u0003\tYL\u0001\u0003`II\u001aDC\u0003D~\r{<9a\"\u0003\b\u0014A1\u0011\u0011\\A%\r\u001bD\u0001\u0002\"\u001f\u0002T\u0001\u0007aq \u0019\u0005\u000f\u00039)\u0001\u0005\u0004\u0002\b\u0012Et1\u0001\t\u0005\u0003k;)\u0001\u0002\u0007\u0007Z\u001au\u0018\u0011!A\u0001\u0006\u0003\tY\f\u0003\u0005\u0007\\\u0006M\u0003\u0019\u0001Cw\u0011!1i.a\u0015A\u0002\u001d-\u0001\u0007BD\u0007\u000f#\u0001b\u0001\"$\u0005\u0004\u001d=\u0001\u0003BA[\u000f#!ABb:\b\n\u0005\u0005\t\u0011!B\u0001\u0003wC\u0001B\"\u001a\u0002T\u0001\u0007qQ\u0003\t\u0007\u0003?3Yob\u00061\t\u001deqQ\u0004\t\u0007\u0003\u000f#\thb\u0007\u0011\t\u0005UvQ\u0004\u0003\r\ro<\u0019\"!A\u0001\u0002\u000b\u0005\u00111X\u000b\u0003\u000fC\u0001Dab\t\b(A1\u0011\u0011]Av\u000fK\u0001B!!.\b(\u0011aaq]A+\u0003\u0003\u0005\tQ!\u0001\u0002<V\u0011q1\u0006\t\u0007\u0003?\u000b)Kb<)\u0011\u0005%#1\bB!\u0005\u0007\nA\"\u00192tiJ\f7\r\u001e+za\u0016,Bab\r\b:QQqQGD\u001e\u000f\u000f:Ie\"\u0016\u0011\r\u0005\u001dE\u0011OD\u001c!\u0011\t)l\"\u000f\u0005\u0011\u00115\u0011Q\fb\u0001\u0003wC\u0001\u0002\"\u001f\u0002^\u0001\u0007qQ\b\u0019\u0005\u000f\u007f9\u0019\u0005\u0005\u0004\u0002\b\u0012Et\u0011\t\t\u0005\u0003k;\u0019\u0005\u0002\u0007\bF\u001dm\u0012\u0011!A\u0001\u0006\u0003\tYL\u0001\u0003`II\"\u0004\u0002\u0003Dn\u0003;\u0002\r\u0001\"<\t\u0011\u0019u\u0017Q\fa\u0001\u000f\u0017\u0002Da\"\u0014\bRA1AQ\u0012C\u0002\u000f\u001f\u0002B!!.\bR\u0011aq1KD%\u0003\u0003\u0005\tQ!\u0001\u0002<\n!q\f\n\u001a6\u0011!1)'!\u0018A\u0002\u001d]\u0003CBAH\rS:I\u0006\r\u0003\b\\\u001d}\u0003CBAD\tc:i\u0006\u0005\u0003\u00026\u001e}C\u0001DD1\u000f+\n\t\u0011!A\u0003\u0002\u0005m&\u0001B0%eY\u0012\u0001cV5mI\u000e\f'\u000fZ'b]&4Wm\u001d;\u0016\t\u001d\u001dtQN\n\u0007\u0003?\nii\"\u001b\u0011\r\u0005\u001dE\u0011OD6!\u0011\t)l\"\u001c\u0005\u0011\u00115\u0011q\fb\u0001\u0003w\u000b!\u0002\\8xKJ\u0014u.\u001e8ea\u00119\u0019hb\u001e\u0011\r\u0005\u001dE\u0011OD;!\u0011\t)lb\u001e\u0005\u0019\u001de\u0014\u0011MA\u0001\u0002\u0003\u0015\t!a/\u0003\t}##g\u000e\u0019\u0005\u000f{:\t\t\u0005\u0004\u0002\b\u0012Etq\u0010\t\u0005\u0003k;\t\t\u0002\u0007\b\u0004\u0006\r\u0014\u0011!A\u0001\u0006\u0003\tYL\u0001\u0003`IIBDCBDD\u000f\u0013;\u0019\n\u0005\u0004\u0002Z\u0006}s1\u000e\u0005\t\u000f_\n)\u00071\u0001\b\fB\"qQRDI!\u0019\t9\t\"\u001d\b\u0010B!\u0011QWDI\t19Ih\"#\u0002\u0002\u0003\u0005)\u0011AA^\u0011!1i.!\u001aA\u0002\u001dU\u0005\u0007BDL\u000f7\u0003b!a\"\u0005r\u001de\u0005\u0003BA[\u000f7#Abb!\b\u0014\u0006\u0005\t\u0011!B\u0001\u0003w+\"ab(1\t\u001d\u0005vQ\u0015\t\u0007\u0003C\fYob)\u0011\t\u0005UvQ\u0015\u0003\r\u000fO\u000b9'!A\u0001\u0002\u000b\u0005\u00111\u0018\u0002\u0004?\u0012\n\u0004\u0006CA0\u0005w\u0011\tEa\u0011\u0002\u0019]LG\u000eZ2be\u0012$\u0016\u0010]3\u0016\t\u001d=vQ\u0017\u000b\u0007\u000fc;9lb1\u0011\r\u0005\u001dE\u0011ODZ!\u0011\t)l\".\u0005\u0011\u00115\u00111\u000eb\u0001\u0003wC\u0001bb\u001c\u0002l\u0001\u0007q\u0011\u0018\u0019\u0005\u000fw;y\f\u0005\u0004\u0002\b\u0012EtQ\u0018\t\u0005\u0003k;y\f\u0002\u0007\bB\u001e]\u0016\u0011!A\u0001\u0006\u0003\tYL\u0001\u0003`IIJ\u0004\u0002\u0003Do\u0003W\u0002\ra\"21\t\u001d\u001dw1\u001a\t\u0007\u0003\u000f#\th\"3\u0011\t\u0005Uv1\u001a\u0003\r\u000f\u001b<\u0019-!A\u0001\u0002\u000b\u0005\u00111\u0018\u0002\u0005?\u0012\u001a\u0004G\u0001\rJ]R,'o]3di&|g\u000eV=qK6\u000bg.\u001b4fgR,Bab5\bZN1\u0011QNAG\u000f+\u0004b!a\"\u0005r\u001d]\u0007\u0003BA[\u000f3$\u0001\u0002\"\u0004\u0002n\t\u0007\u00111X\u0001\ba\u0006\u0014XM\u001c;t!\u0019\tyJb;\b`B\"q\u0011]Ds!\u0019\t9\t\"\u001d\bdB!\u0011QWDs\t199/a\u001c\u0002\u0002\u0003\u0005)\u0011AA^\u0005\u0011yFeM\u0019\u0015\t\u001d-xQ\u001e\t\u0007\u00033\figb6\t\u0011\u001dm\u0017\u0011\u000fa\u0001\u000f_\u0004b!a(\u0007l\u001eE\b\u0007BDz\u000fo\u0004b!a\"\u0005r\u001dU\b\u0003BA[\u000fo$Abb:\bn\u0006\u0005\t\u0011!B\u0001\u0003w+\"ab?1\t\u001du\b\u0012\u0001\t\u0007\u0003C\fYob@\u0011\t\u0005U\u0006\u0012\u0001\u0003\r\u000fO\u000b\u0019(!A\u0001\u0002\u000b\u0005\u00111\u0018\u000b\u0003\t[D\u0003\"!\u001c\u0003<\t\u0005#1I\u0001\u0011S:$XM]:fGRLwN\u001c+za\u0016,B\u0001c\u0003\t\u0012Q!\u0001R\u0002E\n!\u0019\t9\t\"\u001d\t\u0010A!\u0011Q\u0017E\t\t!!i!a\u001eC\u0002\u0005m\u0006\u0002CDn\u0003o\u0002\r\u0001#\u0006\u0011\r\u0005=e\u0011\u000eE\fa\u0011AI\u0002#\b\u0011\r\u0005\u001dE\u0011\u000fE\u000e!\u0011\t)\f#\b\u0005\u0019!}\u00012CA\u0001\u0002\u0003\u0015\t!a/\u0003\t}#3G\r")
public final class ManifestFactory {
    public static <T> Manifest<T> intersectionType(Seq<Manifest<?>> seq) {
        return ManifestFactory$.MODULE$.intersectionType(seq);
    }

    public static <T> Manifest<T> wildcardType(Manifest<?> manifest, Manifest<?> manifest2) {
        return ManifestFactory$.MODULE$.wildcardType(manifest, manifest2);
    }

    public static <T> Manifest<T> abstractType(Manifest<?> manifest, String string, Class<?> clazz, Seq<Manifest<?>> seq) {
        return ManifestFactory$.MODULE$.abstractType(manifest, string, clazz, seq);
    }

    public static <T> Manifest<Object> arrayType(Manifest<?> manifest) {
        return ManifestFactory$.MODULE$.arrayType(manifest);
    }

    public static <T> Manifest<T> classType(Manifest<?> manifest, Class<?> clazz, Seq<Manifest<?>> seq) {
        return ManifestFactory$.MODULE$.classType(manifest, clazz, seq);
    }

    public static <T> Manifest<T> classType(Class<T> clazz, Manifest<?> manifest, Seq<Manifest<?>> seq) {
        return ManifestFactory$.MODULE$.classType(clazz, manifest, seq);
    }

    public static <T> Manifest<T> classType(Class<?> clazz) {
        return ManifestFactory$.MODULE$.classType(clazz);
    }

    public static <T> Manifest<T> singleType(Object object) {
        return ManifestFactory$.MODULE$.singleType(object);
    }

    public static Manifest<Nothing$> Nothing() {
        return ManifestFactory$.MODULE$.Nothing();
    }

    public static Manifest<Null$> Null() {
        return ManifestFactory$.MODULE$.Null();
    }

    public static Manifest<Object> AnyVal() {
        return ManifestFactory$.MODULE$.AnyVal();
    }

    public static Manifest<Object> AnyRef() {
        return ManifestFactory$.MODULE$.AnyRef();
    }

    public static Manifest<Object> Object() {
        return ManifestFactory$.MODULE$.Object();
    }

    public static Manifest<Object> Any() {
        return ManifestFactory$.MODULE$.Any();
    }

    public static AnyValManifest<BoxedUnit> Unit() {
        return ManifestFactory$.MODULE$.Unit();
    }

    public static AnyValManifest<Object> Boolean() {
        return ManifestFactory$.MODULE$.Boolean();
    }

    public static AnyValManifest<Object> Double() {
        return ManifestFactory$.MODULE$.Double();
    }

    public static AnyValManifest<Object> Float() {
        return ManifestFactory$.MODULE$.Float();
    }

    public static AnyValManifest<Object> Long() {
        return ManifestFactory$.MODULE$.Long();
    }

    public static AnyValManifest<Object> Int() {
        return ManifestFactory$.MODULE$.Int();
    }

    public static AnyValManifest<Object> Char() {
        return ManifestFactory$.MODULE$.Char();
    }

    public static AnyValManifest<Object> Short() {
        return ManifestFactory$.MODULE$.Short();
    }

    public static AnyValManifest<Object> Byte() {
        return ManifestFactory$.MODULE$.Byte();
    }

    public static List<AnyValManifest<?>> valueManifests() {
        return ManifestFactory$.MODULE$.valueManifests();
    }

    public static class AbstractTypeManifest<T>
    implements Manifest<T> {
        public static final long serialVersionUID = 1L;
        private final Manifest<?> prefix;
        private final String name;
        private final Class<?> upperBound;
        private final List<Manifest<?>> typeArguments;

        @Override
        public Manifest<Object> arrayManifest() {
            return Manifest.arrayManifest$(this);
        }

        @Override
        public boolean canEqual(Object that) {
            return Manifest.canEqual$(this, that);
        }

        @Override
        public boolean equals(Object that) {
            return Manifest.equals$(this, that);
        }

        @Override
        public int hashCode() {
            return Manifest.hashCode$(this);
        }

        @Override
        public ClassTag<Object> wrap() {
            return ClassTag.wrap$(this);
        }

        @Override
        public Object newArray(int len) {
            return ClassTag.newArray$(this, len);
        }

        @Override
        public Option<T> unapply(Object x) {
            return ClassTag.unapply$(this, x);
        }

        @Override
        public Class<?> erasure() {
            return ClassManifestDeprecatedApis.erasure$(this);
        }

        @Override
        public boolean $less$colon$less(ClassTag<?> that) {
            return ClassManifestDeprecatedApis.$less$colon$less$(this, that);
        }

        @Override
        public boolean $greater$colon$greater(ClassTag<?> that) {
            return ClassManifestDeprecatedApis.$greater$colon$greater$(this, that);
        }

        @Override
        public <T> Class<Object> arrayClass(Class<?> tp) {
            return ClassManifestDeprecatedApis.arrayClass$(this, tp);
        }

        @Override
        public Object[] newArray2(int len) {
            return ClassManifestDeprecatedApis.newArray2$(this, len);
        }

        @Override
        public Object[][] newArray3(int len) {
            return ClassManifestDeprecatedApis.newArray3$(this, len);
        }

        @Override
        public Object[][][] newArray4(int len) {
            return ClassManifestDeprecatedApis.newArray4$(this, len);
        }

        @Override
        public Object[][][][] newArray5(int len) {
            return ClassManifestDeprecatedApis.newArray5$(this, len);
        }

        @Override
        public WrappedArray<T> newWrappedArray(int len) {
            return ClassManifestDeprecatedApis.newWrappedArray$(this, len);
        }

        @Override
        public ArrayBuilder<T> newArrayBuilder() {
            return ClassManifestDeprecatedApis.newArrayBuilder$(this);
        }

        @Override
        public String argString() {
            return ClassManifestDeprecatedApis.argString$(this);
        }

        @Override
        public Class<?> runtimeClass() {
            return this.upperBound;
        }

        @Override
        public List<Manifest<?>> typeArguments() {
            return this.typeArguments;
        }

        @Override
        public String toString() {
            return new StringBuilder(1).append(this.prefix.toString()).append("#").append(this.name).append(this.argString()).toString();
        }

        public AbstractTypeManifest(Manifest<?> prefix, String name, Class<?> upperBound, Seq<Manifest<?>> args2) {
            this.prefix = prefix;
            this.name = name;
            this.upperBound = upperBound;
            ClassManifestDeprecatedApis.$init$(this);
            ClassTag.$init$(this);
            Manifest.$init$(this);
            this.typeArguments = args2.toList();
        }
    }

    public static class AnyManifest
    extends PhantomManifest<Object> {
        public static final long serialVersionUID = 1L;

        public Object[] newArray(int len) {
            return new Object[len];
        }

        @Override
        public boolean $less$colon$less(ClassTag<?> that) {
            return that == this;
        }

        private Object readResolve() {
            return package$.MODULE$.Manifest().Any();
        }

        public AnyManifest() {
            super(ManifestFactory$.MODULE$.scala$reflect$ManifestFactory$$ObjectTYPE(), "Any");
        }
    }

    public static class AnyValPhantomManifest
    extends PhantomManifest<Object> {
        public static final long serialVersionUID = 1L;

        public Object[] newArray(int len) {
            return new Object[len];
        }

        @Override
        public boolean $less$colon$less(ClassTag<?> that) {
            return that == this || that == ManifestFactory$.MODULE$.Any();
        }

        private Object readResolve() {
            return package$.MODULE$.Manifest().AnyVal();
        }

        public AnyValPhantomManifest() {
            super(ManifestFactory$.MODULE$.scala$reflect$ManifestFactory$$ObjectTYPE(), "AnyVal");
        }
    }

    public static class BooleanManifest
    extends AnyValManifest<Object> {
        public static final long serialVersionUID = 1L;

        @Override
        public Class<Boolean> runtimeClass() {
            return Boolean.TYPE;
        }

        public boolean[] newArray(int len) {
            return new boolean[len];
        }

        @Override
        public WrappedArray<Object> newWrappedArray(int len) {
            return new WrappedArray.ofBoolean(new boolean[len]);
        }

        @Override
        public ArrayBuilder<Object> newArrayBuilder() {
            return new ArrayBuilder.ofBoolean();
        }

        @Override
        public Option<Object> unapply(Object x) {
            Option option;
            if (x instanceof Boolean) {
                boolean bl = BoxesRunTime.unboxToBoolean(x);
                option = new Some<Boolean>(BoxesRunTime.boxToBoolean(bl));
            } else {
                option = None$.MODULE$;
            }
            return option;
        }

        private Object readResolve() {
            return package$.MODULE$.Manifest().Boolean();
        }

        public BooleanManifest() {
            super("Boolean");
        }
    }

    public static class ByteManifest
    extends AnyValManifest<Object> {
        public static final long serialVersionUID = 1L;

        @Override
        public Class<Byte> runtimeClass() {
            return Byte.TYPE;
        }

        public byte[] newArray(int len) {
            return new byte[len];
        }

        @Override
        public WrappedArray<Object> newWrappedArray(int len) {
            return new WrappedArray.ofByte(new byte[len]);
        }

        @Override
        public ArrayBuilder<Object> newArrayBuilder() {
            return new ArrayBuilder.ofByte();
        }

        @Override
        public Option<Object> unapply(Object x) {
            Option option;
            if (x instanceof Byte) {
                byte by = BoxesRunTime.unboxToByte(x);
                option = new Some<Byte>(BoxesRunTime.boxToByte(by));
            } else {
                option = None$.MODULE$;
            }
            return option;
        }

        private Object readResolve() {
            return package$.MODULE$.Manifest().Byte();
        }

        public ByteManifest() {
            super("Byte");
        }
    }

    public static class CharManifest
    extends AnyValManifest<Object> {
        public static final long serialVersionUID = 1L;

        @Override
        public Class<Character> runtimeClass() {
            return Character.TYPE;
        }

        public char[] newArray(int len) {
            return new char[len];
        }

        @Override
        public WrappedArray<Object> newWrappedArray(int len) {
            return new WrappedArray.ofChar(new char[len]);
        }

        @Override
        public ArrayBuilder<Object> newArrayBuilder() {
            return new ArrayBuilder.ofChar();
        }

        @Override
        public Option<Object> unapply(Object x) {
            Option option;
            if (x instanceof Character) {
                char c = BoxesRunTime.unboxToChar(x);
                option = new Some<Character>(BoxesRunTime.boxToCharacter(c));
            } else {
                option = None$.MODULE$;
            }
            return option;
        }

        private Object readResolve() {
            return package$.MODULE$.Manifest().Char();
        }

        public CharManifest() {
            super("Char");
        }
    }

    public static class ClassTypeManifest<T>
    implements Manifest<T> {
        public static final long serialVersionUID = 1L;
        private final Option<Manifest<?>> prefix;
        private final Class<?> runtimeClass;
        private final List<Manifest<?>> typeArguments;

        @Override
        public Manifest<Object> arrayManifest() {
            return Manifest.arrayManifest$(this);
        }

        @Override
        public boolean canEqual(Object that) {
            return Manifest.canEqual$(this, that);
        }

        @Override
        public boolean equals(Object that) {
            return Manifest.equals$(this, that);
        }

        @Override
        public int hashCode() {
            return Manifest.hashCode$(this);
        }

        @Override
        public ClassTag<Object> wrap() {
            return ClassTag.wrap$(this);
        }

        @Override
        public Object newArray(int len) {
            return ClassTag.newArray$(this, len);
        }

        @Override
        public Option<T> unapply(Object x) {
            return ClassTag.unapply$(this, x);
        }

        @Override
        public Class<?> erasure() {
            return ClassManifestDeprecatedApis.erasure$(this);
        }

        @Override
        public boolean $less$colon$less(ClassTag<?> that) {
            return ClassManifestDeprecatedApis.$less$colon$less$(this, that);
        }

        @Override
        public boolean $greater$colon$greater(ClassTag<?> that) {
            return ClassManifestDeprecatedApis.$greater$colon$greater$(this, that);
        }

        @Override
        public <T> Class<Object> arrayClass(Class<?> tp) {
            return ClassManifestDeprecatedApis.arrayClass$(this, tp);
        }

        @Override
        public Object[] newArray2(int len) {
            return ClassManifestDeprecatedApis.newArray2$(this, len);
        }

        @Override
        public Object[][] newArray3(int len) {
            return ClassManifestDeprecatedApis.newArray3$(this, len);
        }

        @Override
        public Object[][][] newArray4(int len) {
            return ClassManifestDeprecatedApis.newArray4$(this, len);
        }

        @Override
        public Object[][][][] newArray5(int len) {
            return ClassManifestDeprecatedApis.newArray5$(this, len);
        }

        @Override
        public WrappedArray<T> newWrappedArray(int len) {
            return ClassManifestDeprecatedApis.newWrappedArray$(this, len);
        }

        @Override
        public ArrayBuilder<T> newArrayBuilder() {
            return ClassManifestDeprecatedApis.newArrayBuilder$(this);
        }

        @Override
        public String argString() {
            return ClassManifestDeprecatedApis.argString$(this);
        }

        @Override
        public Class<?> runtimeClass() {
            return this.runtimeClass;
        }

        @Override
        public List<Manifest<?>> typeArguments() {
            return this.typeArguments;
        }

        @Override
        public String toString() {
            return new StringBuilder(0).append(this.prefix.isEmpty() ? "" : new StringBuilder(1).append(((ClassTag)this.prefix.get()).toString()).append("#").toString()).append((Object)(this.runtimeClass().isArray() ? "Array" : this.runtimeClass().getName())).append(this.argString()).toString();
        }

        public ClassTypeManifest(Option<Manifest<?>> prefix, Class<?> runtimeClass, List<Manifest<?>> typeArguments) {
            this.prefix = prefix;
            this.runtimeClass = runtimeClass;
            this.typeArguments = typeArguments;
            ClassManifestDeprecatedApis.$init$(this);
            ClassTag.$init$(this);
            Manifest.$init$(this);
        }
    }

    public static class DoubleManifest
    extends AnyValManifest<Object> {
        public static final long serialVersionUID = 1L;

        @Override
        public Class<Double> runtimeClass() {
            return Double.TYPE;
        }

        public double[] newArray(int len) {
            return new double[len];
        }

        @Override
        public WrappedArray<Object> newWrappedArray(int len) {
            return new WrappedArray.ofDouble(new double[len]);
        }

        @Override
        public ArrayBuilder<Object> newArrayBuilder() {
            return new ArrayBuilder.ofDouble();
        }

        @Override
        public Option<Object> unapply(Object x) {
            Option option;
            if (x instanceof Double) {
                double d = BoxesRunTime.unboxToDouble(x);
                option = new Some<Double>(BoxesRunTime.boxToDouble(d));
            } else {
                option = None$.MODULE$;
            }
            return option;
        }

        private Object readResolve() {
            return package$.MODULE$.Manifest().Double();
        }

        public DoubleManifest() {
            super("Double");
        }
    }

    public static class FloatManifest
    extends AnyValManifest<Object> {
        public static final long serialVersionUID = 1L;

        @Override
        public Class<Float> runtimeClass() {
            return Float.TYPE;
        }

        public float[] newArray(int len) {
            return new float[len];
        }

        @Override
        public WrappedArray<Object> newWrappedArray(int len) {
            return new WrappedArray.ofFloat(new float[len]);
        }

        @Override
        public ArrayBuilder<Object> newArrayBuilder() {
            return new ArrayBuilder.ofFloat();
        }

        @Override
        public Option<Object> unapply(Object x) {
            Option option;
            if (x instanceof Float) {
                float f = BoxesRunTime.unboxToFloat(x);
                option = new Some<Float>(BoxesRunTime.boxToFloat(f));
            } else {
                option = None$.MODULE$;
            }
            return option;
        }

        private Object readResolve() {
            return package$.MODULE$.Manifest().Float();
        }

        public FloatManifest() {
            super("Float");
        }
    }

    public static class IntManifest
    extends AnyValManifest<Object> {
        public static final long serialVersionUID = 1L;

        @Override
        public Class<Integer> runtimeClass() {
            return Integer.TYPE;
        }

        public int[] newArray(int len) {
            return new int[len];
        }

        @Override
        public WrappedArray<Object> newWrappedArray(int len) {
            return new WrappedArray.ofInt(new int[len]);
        }

        @Override
        public ArrayBuilder<Object> newArrayBuilder() {
            return new ArrayBuilder.ofInt();
        }

        @Override
        public Option<Object> unapply(Object x) {
            Option option;
            if (x instanceof Integer) {
                int n = BoxesRunTime.unboxToInt(x);
                option = new Some<Integer>(BoxesRunTime.boxToInteger(n));
            } else {
                option = None$.MODULE$;
            }
            return option;
        }

        private Object readResolve() {
            return package$.MODULE$.Manifest().Int();
        }

        public IntManifest() {
            super("Int");
        }
    }

    public static class IntersectionTypeManifest<T>
    implements Manifest<T> {
        public static final long serialVersionUID = 1L;
        private final Seq<Manifest<?>> parents;

        @Override
        public List<Manifest<?>> typeArguments() {
            return Manifest.typeArguments$(this);
        }

        @Override
        public Manifest<Object> arrayManifest() {
            return Manifest.arrayManifest$(this);
        }

        @Override
        public boolean canEqual(Object that) {
            return Manifest.canEqual$(this, that);
        }

        @Override
        public boolean equals(Object that) {
            return Manifest.equals$(this, that);
        }

        @Override
        public int hashCode() {
            return Manifest.hashCode$(this);
        }

        @Override
        public ClassTag<Object> wrap() {
            return ClassTag.wrap$(this);
        }

        @Override
        public Object newArray(int len) {
            return ClassTag.newArray$(this, len);
        }

        @Override
        public Option<T> unapply(Object x) {
            return ClassTag.unapply$(this, x);
        }

        @Override
        public Class<?> erasure() {
            return ClassManifestDeprecatedApis.erasure$(this);
        }

        @Override
        public boolean $less$colon$less(ClassTag<?> that) {
            return ClassManifestDeprecatedApis.$less$colon$less$(this, that);
        }

        @Override
        public boolean $greater$colon$greater(ClassTag<?> that) {
            return ClassManifestDeprecatedApis.$greater$colon$greater$(this, that);
        }

        @Override
        public <T> Class<Object> arrayClass(Class<?> tp) {
            return ClassManifestDeprecatedApis.arrayClass$(this, tp);
        }

        @Override
        public Object[] newArray2(int len) {
            return ClassManifestDeprecatedApis.newArray2$(this, len);
        }

        @Override
        public Object[][] newArray3(int len) {
            return ClassManifestDeprecatedApis.newArray3$(this, len);
        }

        @Override
        public Object[][][] newArray4(int len) {
            return ClassManifestDeprecatedApis.newArray4$(this, len);
        }

        @Override
        public Object[][][][] newArray5(int len) {
            return ClassManifestDeprecatedApis.newArray5$(this, len);
        }

        @Override
        public WrappedArray<T> newWrappedArray(int len) {
            return ClassManifestDeprecatedApis.newWrappedArray$(this, len);
        }

        @Override
        public ArrayBuilder<T> newArrayBuilder() {
            return ClassManifestDeprecatedApis.newArrayBuilder$(this);
        }

        @Override
        public String argString() {
            return ClassManifestDeprecatedApis.argString$(this);
        }

        @Override
        public Class<?> runtimeClass() {
            return ((ClassTag)this.parents.head()).runtimeClass();
        }

        @Override
        public String toString() {
            return this.parents.mkString(" with ");
        }

        public IntersectionTypeManifest(Seq<Manifest<?>> parents) {
            this.parents = parents;
            ClassManifestDeprecatedApis.$init$(this);
            ClassTag.$init$(this);
            Manifest.$init$(this);
        }
    }

    public static class LongManifest
    extends AnyValManifest<Object> {
        public static final long serialVersionUID = 1L;

        @Override
        public Class<Long> runtimeClass() {
            return Long.TYPE;
        }

        public long[] newArray(int len) {
            return new long[len];
        }

        @Override
        public WrappedArray<Object> newWrappedArray(int len) {
            return new WrappedArray.ofLong(new long[len]);
        }

        @Override
        public ArrayBuilder<Object> newArrayBuilder() {
            return new ArrayBuilder.ofLong();
        }

        @Override
        public Option<Object> unapply(Object x) {
            Option option;
            if (x instanceof Long) {
                long l = BoxesRunTime.unboxToLong(x);
                option = new Some<Long>(BoxesRunTime.boxToLong(l));
            } else {
                option = None$.MODULE$;
            }
            return option;
        }

        private Object readResolve() {
            return package$.MODULE$.Manifest().Long();
        }

        public LongManifest() {
            super("Long");
        }
    }

    public static class NothingManifest
    extends PhantomManifest<Nothing$> {
        public static final long serialVersionUID = 1L;

        public Object[] newArray(int len) {
            return new Object[len];
        }

        @Override
        public boolean $less$colon$less(ClassTag<?> that) {
            return that != null;
        }

        private Object readResolve() {
            return package$.MODULE$.Manifest().Nothing();
        }

        public NothingManifest() {
            super(ManifestFactory$.MODULE$.scala$reflect$ManifestFactory$$NothingTYPE(), "Nothing");
        }
    }

    public static class NullManifest
    extends PhantomManifest<Null$> {
        public static final long serialVersionUID = 1L;

        public Object[] newArray(int len) {
            return new Object[len];
        }

        @Override
        public boolean $less$colon$less(ClassTag<?> that) {
            return that != null && that != ManifestFactory$.MODULE$.Nothing() && !that.$less$colon$less(ManifestFactory$.MODULE$.AnyVal());
        }

        private Object readResolve() {
            return package$.MODULE$.Manifest().Null();
        }

        public NullManifest() {
            super(ManifestFactory$.MODULE$.scala$reflect$ManifestFactory$$NullTYPE(), "Null");
        }
    }

    public static class ObjectManifest
    extends PhantomManifest<Object> {
        public static final long serialVersionUID = 1L;

        public Object[] newArray(int len) {
            return new Object[len];
        }

        @Override
        public boolean $less$colon$less(ClassTag<?> that) {
            return that == this || that == ManifestFactory$.MODULE$.Any();
        }

        private Object readResolve() {
            return package$.MODULE$.Manifest().Object();
        }

        public ObjectManifest() {
            super(ManifestFactory$.MODULE$.scala$reflect$ManifestFactory$$ObjectTYPE(), "Object");
        }
    }

    public static abstract class PhantomManifest<T>
    extends ClassTypeManifest<T> {
        public static final long serialVersionUID = 1L;
        private final String toString;
        private final transient int hashCode;

        @Override
        public String toString() {
            return this.toString;
        }

        @Override
        public boolean equals(Object that) {
            return this == that;
        }

        @Override
        public int hashCode() {
            return this.hashCode;
        }

        public PhantomManifest(Class<?> _runtimeClass, String toString2) {
            this.toString = toString2;
            super(None$.MODULE$, _runtimeClass, Nil$.MODULE$);
            this.hashCode = System.identityHashCode(this);
        }
    }

    public static class ShortManifest
    extends AnyValManifest<Object> {
        public static final long serialVersionUID = 1L;

        @Override
        public Class<Short> runtimeClass() {
            return Short.TYPE;
        }

        public short[] newArray(int len) {
            return new short[len];
        }

        @Override
        public WrappedArray<Object> newWrappedArray(int len) {
            return new WrappedArray.ofShort(new short[len]);
        }

        @Override
        public ArrayBuilder<Object> newArrayBuilder() {
            return new ArrayBuilder.ofShort();
        }

        @Override
        public Option<Object> unapply(Object x) {
            Option option;
            if (x instanceof Short) {
                short s = BoxesRunTime.unboxToShort(x);
                option = new Some<Short>(BoxesRunTime.boxToShort(s));
            } else {
                option = None$.MODULE$;
            }
            return option;
        }

        private Object readResolve() {
            return package$.MODULE$.Manifest().Short();
        }

        public ShortManifest() {
            super("Short");
        }
    }

    public static class SingletonTypeManifest<T>
    implements Manifest<T> {
        public static final long serialVersionUID = 1L;
        private Class<?> runtimeClass;
        private String toString;
        private final Object value;
        private volatile byte bitmap$0;

        @Override
        public List<Manifest<?>> typeArguments() {
            return Manifest.typeArguments$(this);
        }

        @Override
        public Manifest<T[]> arrayManifest() {
            return Manifest.arrayManifest$(this);
        }

        @Override
        public boolean canEqual(Object that) {
            return Manifest.canEqual$(this, that);
        }

        @Override
        public boolean equals(Object that) {
            return Manifest.equals$(this, that);
        }

        @Override
        public int hashCode() {
            return Manifest.hashCode$(this);
        }

        @Override
        public ClassTag<T[]> wrap() {
            return ClassTag.wrap$(this);
        }

        @Override
        public Object newArray(int len) {
            return ClassTag.newArray$(this, len);
        }

        @Override
        public Option<T> unapply(Object x) {
            return ClassTag.unapply$(this, x);
        }

        @Override
        public Class<?> erasure() {
            return ClassManifestDeprecatedApis.erasure$(this);
        }

        @Override
        public boolean $less$colon$less(ClassTag<?> that) {
            return ClassManifestDeprecatedApis.$less$colon$less$(this, that);
        }

        @Override
        public boolean $greater$colon$greater(ClassTag<?> that) {
            return ClassManifestDeprecatedApis.$greater$colon$greater$(this, that);
        }

        @Override
        public <T> Class<Object> arrayClass(Class<?> tp) {
            return ClassManifestDeprecatedApis.arrayClass$(this, tp);
        }

        @Override
        public Object[] newArray2(int len) {
            return ClassManifestDeprecatedApis.newArray2$(this, len);
        }

        @Override
        public Object[][] newArray3(int len) {
            return ClassManifestDeprecatedApis.newArray3$(this, len);
        }

        @Override
        public Object[][][] newArray4(int len) {
            return ClassManifestDeprecatedApis.newArray4$(this, len);
        }

        @Override
        public Object[][][][] newArray5(int len) {
            return ClassManifestDeprecatedApis.newArray5$(this, len);
        }

        @Override
        public WrappedArray<T> newWrappedArray(int len) {
            return ClassManifestDeprecatedApis.newWrappedArray$(this, len);
        }

        @Override
        public ArrayBuilder<T> newArrayBuilder() {
            return ClassManifestDeprecatedApis.newArrayBuilder$(this);
        }

        @Override
        public String argString() {
            return ClassManifestDeprecatedApis.argString$(this);
        }

        private Class<?> runtimeClass$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 1) == 0) {
                    this.runtimeClass = this.value.getClass();
                    this.bitmap$0 = (byte)(this.bitmap$0 | 1);
                }
            }
            return this.runtimeClass;
        }

        @Override
        public Class<?> runtimeClass() {
            if ((byte)(this.bitmap$0 & 1) == 0) {
                return this.runtimeClass$lzycompute();
            }
            return this.runtimeClass;
        }

        private String toString$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 2) == 0) {
                    this.toString = new StringBuilder(5).append(this.value.toString()).append(".type").toString();
                    this.bitmap$0 = (byte)(this.bitmap$0 | 2);
                }
            }
            return this.toString;
        }

        @Override
        public String toString() {
            if ((byte)(this.bitmap$0 & 2) == 0) {
                return this.toString$lzycompute();
            }
            return this.toString;
        }

        public SingletonTypeManifest(Object value) {
            this.value = value;
            ClassManifestDeprecatedApis.$init$(this);
            ClassTag.$init$(this);
            Manifest.$init$(this);
        }
    }

    public static class UnitManifest
    extends AnyValManifest<BoxedUnit> {
        public static final long serialVersionUID = 1L;

        @Override
        public Class<Void> runtimeClass() {
            return Void.TYPE;
        }

        public BoxedUnit[] newArray(int len) {
            return new BoxedUnit[len];
        }

        @Override
        public WrappedArray<BoxedUnit> newWrappedArray(int len) {
            return new WrappedArray.ofUnit(new BoxedUnit[len]);
        }

        @Override
        public ArrayBuilder<BoxedUnit> newArrayBuilder() {
            return new ArrayBuilder.ofUnit();
        }

        @Override
        public <T> Class<Object> arrayClass(Class<?> tp) {
            if (tp == this.runtimeClass()) {
                return BoxedUnit[].class;
            }
            return ClassManifestDeprecatedApis.arrayClass$(this, tp);
        }

        @Override
        public Option<BoxedUnit> unapply(Object x) {
            Option option;
            if (x instanceof BoxedUnit) {
                BoxedUnit boxedUnit = BoxedUnit.UNIT;
                option = new Some<BoxedUnit>(boxedUnit);
            } else {
                option = None$.MODULE$;
            }
            return option;
        }

        private Object readResolve() {
            return package$.MODULE$.Manifest().Unit();
        }

        public UnitManifest() {
            super("Unit");
        }
    }

    public static class WildcardManifest<T>
    implements Manifest<T> {
        public static final long serialVersionUID = 1L;
        private final Manifest<?> lowerBound;
        private final Manifest<?> upperBound;

        @Override
        public List<Manifest<?>> typeArguments() {
            return Manifest.typeArguments$(this);
        }

        @Override
        public Manifest<Object> arrayManifest() {
            return Manifest.arrayManifest$(this);
        }

        @Override
        public boolean canEqual(Object that) {
            return Manifest.canEqual$(this, that);
        }

        @Override
        public boolean equals(Object that) {
            return Manifest.equals$(this, that);
        }

        @Override
        public int hashCode() {
            return Manifest.hashCode$(this);
        }

        @Override
        public ClassTag<Object> wrap() {
            return ClassTag.wrap$(this);
        }

        @Override
        public Object newArray(int len) {
            return ClassTag.newArray$(this, len);
        }

        @Override
        public Option<T> unapply(Object x) {
            return ClassTag.unapply$(this, x);
        }

        @Override
        public Class<?> erasure() {
            return ClassManifestDeprecatedApis.erasure$(this);
        }

        @Override
        public boolean $less$colon$less(ClassTag<?> that) {
            return ClassManifestDeprecatedApis.$less$colon$less$(this, that);
        }

        @Override
        public boolean $greater$colon$greater(ClassTag<?> that) {
            return ClassManifestDeprecatedApis.$greater$colon$greater$(this, that);
        }

        @Override
        public <T> Class<Object> arrayClass(Class<?> tp) {
            return ClassManifestDeprecatedApis.arrayClass$(this, tp);
        }

        @Override
        public Object[] newArray2(int len) {
            return ClassManifestDeprecatedApis.newArray2$(this, len);
        }

        @Override
        public Object[][] newArray3(int len) {
            return ClassManifestDeprecatedApis.newArray3$(this, len);
        }

        @Override
        public Object[][][] newArray4(int len) {
            return ClassManifestDeprecatedApis.newArray4$(this, len);
        }

        @Override
        public Object[][][][] newArray5(int len) {
            return ClassManifestDeprecatedApis.newArray5$(this, len);
        }

        @Override
        public WrappedArray<T> newWrappedArray(int len) {
            return ClassManifestDeprecatedApis.newWrappedArray$(this, len);
        }

        @Override
        public ArrayBuilder<T> newArrayBuilder() {
            return ClassManifestDeprecatedApis.newArrayBuilder$(this);
        }

        @Override
        public String argString() {
            return ClassManifestDeprecatedApis.argString$(this);
        }

        @Override
        public Class<?> runtimeClass() {
            return this.upperBound.runtimeClass();
        }

        @Override
        public String toString() {
            return new StringBuilder(1).append("_").append((Object)(this.lowerBound == ManifestFactory$.MODULE$.Nothing() ? "" : new StringBuilder(4).append(" >: ").append(this.lowerBound).toString())).append((Object)(this.upperBound == ManifestFactory$.MODULE$.Nothing() ? "" : new StringBuilder(4).append(" <: ").append(this.upperBound).toString())).toString();
        }

        public WildcardManifest(Manifest<?> lowerBound, Manifest<?> upperBound) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            ClassManifestDeprecatedApis.$init$(this);
            ClassTag.$init$(this);
            Manifest.$init$(this);
        }
    }
}

