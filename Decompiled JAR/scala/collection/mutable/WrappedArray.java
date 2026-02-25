/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.util.Arrays;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.CustomParallelizable;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenSeqLike;
import scala.collection.IndexedSeqLike;
import scala.collection.IndexedSeqOptimized;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.SeqLike;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.List;
import scala.collection.mutable.AbstractSeq;
import scala.collection.mutable.ArrayLike;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.IndexedSeq;
import scala.collection.mutable.IndexedSeqView;
import scala.collection.mutable.WrappedArray$;
import scala.collection.mutable.WrappedArrayBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParArray;
import scala.collection.parallel.mutable.ParArray$;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.ScalaRunTime$;
import scala.util.hashing.MurmurHash3$;

@ScalaSignature(bytes="\u0006\u0001\u0019ua\u0001CA\t\u0003'\t\t!!\t\t\u000f\u0005%\u0004\u0001\"\u0001\u0002l!A\u0011Q\u000e\u0001!\n#\ny\u0007\u0003\u0005\u0002r\u0001\u0001K\u0011KA:\u0011\u001d\tI\b\u0001D\u0001\u0003wBq!!#\u0001\t\u0003\tY\tC\u0004\u00024\u00021\t!!.\t\u000f\u0005u\u0006A\"\u0001\u0002@\"9\u0011Q\u0019\u0001\u0007\u0002\u0005\u001d\u0007bBAk\u0001\u0019\u0005\u0011q\u001b\u0005\b\u0003?\u0004A\u0011IAq\u0011\u001d\t\u0019\u000f\u0001C\u0005\u0003KDq!!>\u0001\t\u0003\n9\u0010C\u0004\u0003\f\u0001!\tE!\u0004\t\u000f\t}\u0001\u0001\"\u0011\u0002l!A!\u0011\u0005\u0001!\n#\u0012\u0019c\u0002\u0005\u0003,\u0005M\u0001\u0012\u0001B\u0017\r!\t\t\"a\u0005\t\u0002\t=\u0002bBA5#\u0011\u0005!q\u0007\u0005\n\u0005s\t\"\u0019!C\u0005\u0005wA\u0001Ba\u001d\u0012A\u0003%!Q\b\u0005\b\u0005k\nB\u0011\u0001B<\u0011\u001d\u0011\t)\u0005C\u0001\u0005\u0007CqA!%\u0012\t\u0007\u0011\u0019\n\u0003\u0005\u0003:F\u0001\u000b\u0011\u0002B^\u0011!\u0011)-\u0005Q\u0001\n\t\u001d\u0007\u0002CB\u0003#\u0001\u0006Iaa\u0002\t\u0011\r}\u0012\u0003)A\u0005\u0007\u0003B\u0001b!\u001f\u0012A\u0003%11\u0010\u0005\t\u0007g\u000b\u0002\u0015!\u0003\u00046\"A1Q^\t!\u0002\u0013\u0019y\u000f\u0003\u0005\u0005\"E\u0001\u000b\u0011\u0002C\u0012\u0011!!Y&\u0005Q\u0001\n\u0011u\u0003\u0002\u0003CK#\u0001\u0006I\u0001b&\t\u0011\u0011%\u0017\u0003)A\u0005\t\u0017D\u0001\u0002b6\u0012A\u0013%A\u0011\u001c\u0005\b\u0005C\tB\u0011\u0001Cv\r\u0019\u0011\t%\u0005\u0002\u0003D!Q\u0011Q[\u0013\u0003\u0006\u0004%\tA!\u0016\t\u0015\teSE!A!\u0002\u0013\u00119\u0006C\u0004\u0002j\u0015\"\tAa\u0017\t\u000f\u0005eT\u0005\"\u0001\u0003b!9\u00111W\u0013\u0005\u0002\u0005U\u0006bBA_K\u0011\u0005!Q\r\u0005\b\u0003\u000b,C\u0011\u0001B5\u0011\u001d\u0011y'\nC!\u0005c2a\u0001\"?\u0012\u0005\u0011m\bBCAk]\t\u0015\r\u0011\"\u0001\u0005~\"Q!\u0011\f\u0018\u0003\u0002\u0003\u0006I\u0001b@\t\u000f\u0005%d\u0006\"\u0001\u0006\u0002!9\u0011\u0011\u0010\u0018\u0005\u0002\u0015\u001d\u0001bBAZ]\u0011\u0005\u0011Q\u0017\u0005\b\u0003{sC\u0011AC\u0006\u0011\u001d\t)M\fC\u0001\u000b\u001fAqAa\u001c/\t\u0003\u0012\t\bC\u0004\u0006\u00169\"\t%b\u0006\u0007\r\u0015u\u0011CAC\u0010\u0011)\t)\u000e\u000fBC\u0002\u0013\u0005Q\u0011\u0005\u0005\u000b\u00053B$\u0011!Q\u0001\n\u0015\r\u0002bBA5q\u0011\u0005QQ\u0005\u0005\b\u0003sBD\u0011AC\u0016\u0011\u001d\t\u0019\f\u000fC\u0001\u0003kCq!!09\t\u0003)y\u0003C\u0004\u0002Fb\"\t!b\r\t\u000f\t=\u0004\b\"\u0011\u0003r!9QQ\u0003\u001d\u0005B\u0015ebABC\u001f#\t)y\u0004\u0003\u0006\u0002V\n\u0013)\u0019!C\u0001\u000b\u0003B!B!\u0017C\u0005\u0003\u0005\u000b\u0011BC\"\u0011\u001d\tIG\u0011C\u0001\u000b\u000bBq!!\u001fC\t\u0003)Y\u0005C\u0004\u00024\n#\t!!.\t\u000f\u0005u&\t\"\u0001\u0006P!9\u0011Q\u0019\"\u0005\u0002\u0015M\u0003b\u0002B8\u0005\u0012\u0005#\u0011\u000f\u0005\b\u000b+\u0011E\u0011IC-\r\u0019)i&\u0005\u0002\u0006`!Q\u0011Q\u001b'\u0003\u0006\u0004%\t!\"\u0019\t\u0015\teCJ!A!\u0002\u0013)\u0019\u0007C\u0004\u0002j1#\t!\"\u001a\t\u000f\u0005eD\n\"\u0001\u0006l!9\u00111\u0017'\u0005\u0002\u0005U\u0006bBA_\u0019\u0012\u0005Qq\u000e\u0005\b\u0003\u000bdE\u0011AC:\u0011\u001d\u0011y\u0007\u0014C!\u0005cBq!\"\u0006M\t\u0003*IH\u0002\u0004\u0006~E\u0011Qq\u0010\u0005\u000b\u0003+4&Q1A\u0005\u0002\u0015\u0005\u0005B\u0003B--\n\u0005\t\u0015!\u0003\u0006\u0004\"9\u0011\u0011\u000e,\u0005\u0002\u0015\u0015\u0005bBA=-\u0012\u0005Q1\u0012\u0005\b\u0003g3F\u0011AA[\u0011\u001d\tiL\u0016C\u0001\u000b\u001fCq!!2W\t\u0003)\u0019\nC\u0004\u0003pY#\tE!\u001d\t\u000f\u0015Ua\u000b\"\u0011\u0006\u001a\u001a1QQT\t\u0003\u000b?C!\"!6a\u0005\u000b\u0007I\u0011ACQ\u0011)\u0011I\u0006\u0019B\u0001B\u0003%Q1\u0015\u0005\b\u0003S\u0002G\u0011ACS\u0011\u001d\tI\b\u0019C\u0001\u000bWCq!a-a\t\u0003\t)\fC\u0004\u0002>\u0002$\t!b,\t\u000f\u0005\u0015\u0007\r\"\u0001\u00064\"9!q\u000e1\u0005B\tE\u0004bBC\u000bA\u0012\u0005S\u0011\u0018\u0004\u0007\u000b{\u000b\"!b0\t\u0015\u0005U'N!b\u0001\n\u0003)\t\r\u0003\u0006\u0003Z)\u0014\t\u0011)A\u0005\u000b\u0007Dq!!\u001bk\t\u0003))\rC\u0004\u0002z)$\t!b3\t\u000f\u0005M&\u000e\"\u0001\u00026\"9\u0011Q\u00186\u0005\u0002\u0015=\u0007bBAcU\u0012\u0005Q1\u001b\u0005\b\u0005_RG\u0011\tB9\u0011\u001d))B\u001bC!\u000b34a!\"8\u0012\u0005\u0015}\u0007BCAki\n\u0015\r\u0011\"\u0001\u0006b\"Q!\u0011\f;\u0003\u0002\u0003\u0006I!b9\t\u000f\u0005%D\u000f\"\u0001\u0006f\"9\u0011\u0011\u0010;\u0005\u0002\u0015-\bbBAZi\u0012\u0005\u0011Q\u0017\u0005\b\u0003{#H\u0011ACx\u0011\u001d\t)\r\u001eC\u0001\u000bgDqAa\u001cu\t\u0003\u0012\t\bC\u0004\u0006\u0016Q$\t%\"?\u0007\r\u0015u\u0018CAC\u0000\u0011)\t)N BC\u0002\u0013\u0005a\u0011\u0001\u0005\u000b\u00053r(\u0011!Q\u0001\n\u0019\r\u0001bBA5}\u0012\u0005aQ\u0001\u0005\b\u0003srH\u0011\u0001D\u0006\u0011\u001d\t\u0019L C\u0001\u0003kCq!!0\u007f\t\u00031y\u0001C\u0004\u0002Fz$\tAb\u0005\t\u000f\t=d\u0010\"\u0011\u0003r!9QQ\u0003@\u0005B\u0019e!\u0001D,sCB\u0004X\rZ!se\u0006L(\u0002BA\u000b\u0003/\tq!\\;uC\ndWM\u0003\u0003\u0002\u001a\u0005m\u0011AC2pY2,7\r^5p]*\u0011\u0011QD\u0001\u0006g\u000e\fG.Y\u0002\u0001+\u0011\t\u0019#!\r\u0014\u0013\u0001\t)#!\u0012\u0002L\u0005M\u0003CBA\u0014\u0003S\ti#\u0004\u0002\u0002\u0014%!\u00111FA\n\u0005-\t%m\u001d;sC\u000e$8+Z9\u0011\t\u0005=\u0012\u0011\u0007\u0007\u0001\t\u001d\t\u0019\u0004\u0001b\u0001\u0003k\u0011\u0011\u0001V\t\u0005\u0003o\ty\u0004\u0005\u0003\u0002:\u0005mRBAA\u000e\u0013\u0011\ti$a\u0007\u0003\u000f9{G\u000f[5oOB!\u0011\u0011HA!\u0013\u0011\t\u0019%a\u0007\u0003\u0007\u0005s\u0017\u0010\u0005\u0004\u0002(\u0005\u001d\u0013QF\u0005\u0005\u0003\u0013\n\u0019B\u0001\u0006J]\u0012,\u00070\u001a3TKF\u0004\u0002\"a\n\u0002N\u00055\u0012\u0011K\u0005\u0005\u0003\u001f\n\u0019BA\u0005BeJ\f\u0017\u0010T5lKB)\u0011q\u0005\u0001\u0002.AA\u0011QKA,\u0003[\tY&\u0004\u0002\u0002\u0018%!\u0011\u0011LA\f\u0005Q\u0019Uo\u001d;p[B\u000b'/\u00197mK2L'0\u00192mKB1\u0011QLA3\u0003[i!!a\u0018\u000b\t\u0005U\u0011\u0011\r\u0006\u0005\u0003G\n9\"\u0001\u0005qCJ\fG\u000e\\3m\u0013\u0011\t9'a\u0018\u0003\u0011A\u000b'/\u0011:sCf\fa\u0001P5oSRtDCAA)\u00039!\b.[:D_2dWm\u0019;j_:,\"!!\u0015\u0002\u0019Q|7i\u001c7mK\u000e$\u0018n\u001c8\u0015\t\u0005E\u0013Q\u000f\u0005\b\u0003o\u001a\u0001\u0019AA)\u0003\u0011\u0011X\r\u001d:\u0002\u000f\u0015dW-\u001c+bOV\u0011\u0011Q\u0010\t\u0007\u0003\u007f\n))!\f\u000e\u0005\u0005\u0005%\u0002BAB\u00037\tqA]3gY\u0016\u001cG/\u0003\u0003\u0002\b\u0006\u0005%\u0001C\"mCN\u001cH+Y4\u0002\u0019\u0015dW-\\'b]&4Wm\u001d;\u0016\u0005\u00055\u0005CBAH\u0003;\u000biC\u0004\u0003\u0002\u0012\u0006e\u0005\u0003BAJ\u00037i!!!&\u000b\t\u0005]\u0015qD\u0001\u0007yI|w\u000e\u001e \n\t\u0005m\u00151D\u0001\u0007!J,G-\u001a4\n\t\u0005}\u0015\u0011\u0015\u0002\u000e\u00072\f7o]'b]&4Wm\u001d;\u000b\t\u0005m\u00151\u0004\u0015\b\u000b\u0005\u0015\u00161VAX!\u0011\tI$a*\n\t\u0005%\u00161\u0004\u0002\u000bI\u0016\u0004(/Z2bi\u0016$\u0017EAAW\u0003M)8/\u001a\u0011fY\u0016lG+Y4!S:\u001cH/Z1eC\t\t\t,\u0001\u00043]E\u0002d\u0006M\u0001\u0007Y\u0016tw\r\u001e5\u0016\u0005\u0005]\u0006\u0003BA\u001d\u0003sKA!a/\u0002\u001c\t\u0019\u0011J\u001c;\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\t\u00055\u0012\u0011\u0019\u0005\b\u0003\u0007<\u0001\u0019AA\\\u0003\u0015Ig\u000eZ3y\u0003\u0019)\b\u000fZ1uKR1\u0011\u0011ZAh\u0003#\u0004B!!\u000f\u0002L&!\u0011QZA\u000e\u0005\u0011)f.\u001b;\t\u000f\u0005\r\u0007\u00021\u0001\u00028\"9\u00111\u001b\u0005A\u0002\u00055\u0012\u0001B3mK6\fQ!\u0019:sCf,\"!!7\u0011\r\u0005e\u00121\\A\u0017\u0013\u0011\ti.a\u0007\u0003\u000b\u0005\u0013(/Y=\u0002\u0007A\f'/\u0006\u0002\u0002\\\u0005aQ\r\\3nK:$8\t\\1tgV\u0011\u0011q\u001d\u0019\u0005\u0003S\f\t\u0010\u0005\u0004\u0002\u0010\u0006-\u0018q^\u0005\u0005\u0003[\f\tKA\u0003DY\u0006\u001c8\u000f\u0005\u0003\u00020\u0005EHaCAz\u0017\u0005\u0005\t\u0011!B\u0001\u0003k\u00111a\u0018\u00132\u0003\u001d!x.\u0011:sCf,B!!?\u0002\u0000R!\u00111 B\u0003!\u0019\tI$a7\u0002~B!\u0011qFA\u0000\t\u001d\u0011\t\u0001\u0004b\u0001\u0005\u0007\u0011\u0011!V\t\u0005\u0003[\ty\u0004C\u0005\u0003\b1\t\t\u0011q\u0001\u0003\n\u0005QQM^5eK:\u001cW\rJ\u0019\u0011\r\u0005}\u0014QQA\u007f\u00031\u0019HO]5oOB\u0013XMZ5y+\t\u0011y\u0001\u0005\u0003\u0003\u0012\tmQB\u0001B\n\u0015\u0011\u0011)Ba\u0006\u0002\t1\fgn\u001a\u0006\u0003\u00053\tAA[1wC&!!Q\u0004B\n\u0005\u0019\u0019FO]5oO\u0006)1\r\\8oK\u0006Qa.Z<Ck&dG-\u001a:\u0016\u0005\t\u0015\u0002\u0003CA\u0014\u0005O\ti#!\u0015\n\t\t%\u00121\u0003\u0002\b\u0005VLG\u000eZ3s\u000319&/\u00199qK\u0012\f%O]1z!\r\t9#E\n\u0004#\tE\u0002\u0003BA\u001d\u0005gIAA!\u000e\u0002\u001c\t1\u0011I\\=SK\u001a$\"A!\f\u0002#\u0015k\u0007\u000f^=Xe\u0006\u0004\b/\u001a3BeJ\f\u00170\u0006\u0002\u0003>A)!qH\u0013\u000325\t\u0011CA\u0003pMJ+g-\u0006\u0003\u0003F\t-3#B\u0013\u0003H\t=\u0003#BA\u0014\u0001\t%\u0003\u0003BA\u0018\u0005\u0017\"q!a\r&\u0005\u0004\u0011i%\u0005\u0003\u00028\tE\u0002\u0003BA\u001d\u0005#JAAa\u0015\u0002\u001c\ta1+\u001a:jC2L'0\u00192mKV\u0011!q\u000b\t\u0007\u0003s\tYN!\u0013\u0002\r\u0005\u0014(/Y=!)\u0011\u0011iFa\u0018\u0011\u000b\t}RE!\u0013\t\u000f\u0005U\u0007\u00061\u0001\u0003XU\u0011!1\r\t\u0007\u0003\u007f\n)I!\u0013\u0015\t\t%#q\r\u0005\b\u0003\u0007\\\u0003\u0019AA\\)\u0019\tIMa\u001b\u0003n!9\u00111\u0019\u0017A\u0002\u0005]\u0006bBAjY\u0001\u0007!\u0011J\u0001\tQ\u0006\u001c\bnQ8eKR\u0011\u0011qW\u0001\u0013\u000b6\u0004H/_,sCB\u0004X\rZ!se\u0006L\b%A\u0003f[B$\u00180\u0006\u0003\u0003z\t}TC\u0001B>!\u0015\t9\u0003\u0001B?!\u0011\tyCa \u0005\u000f\u0005MRC1\u0001\u0003N\u0005!Q.Y6f+\u0011\u0011)Ia#\u0015\t\t\u001d%Q\u0012\t\u0006\u0003O\u0001!\u0011\u0012\t\u0005\u0003_\u0011Y\tB\u0004\u00024Y\u0011\r!!\u000e\t\u000f\t=e\u00031\u0001\u00032\u0005\t\u00010\u0001\u0007dC:\u0014U/\u001b7e\rJ|W.\u0006\u0003\u0003\u0016\n=F\u0003\u0002BL\u0005g\u0003\"B!'\u0003 \n\r&Q\u0016BY\u001b\t\u0011YJ\u0003\u0003\u0003\u001e\u0006]\u0011aB4f]\u0016\u0014\u0018nY\u0005\u0005\u0005C\u0013YJ\u0001\u0007DC:\u0014U/\u001b7e\rJ|W\u000e\r\u0003\u0003&\n%\u0006#BA\u0014\u0001\t\u001d\u0006\u0003BA\u0018\u0005S#1Ba+\u0018\u0003\u0003\u0005\tQ!\u0001\u00026\t\u0019q\f\n\u001a\u0011\t\u0005=\"q\u0016\u0003\b\u0003g9\"\u0019AA\u001b!\u0015\t9\u0003\u0001BW\u0011\u001d\u0011)l\u0006a\u0002\u0005o\u000b\u0011!\u001c\t\u0007\u0003\u007f\n)I!,\u0002\u0017=\u0013'.Z2u\u00072\f7o\u001d\t\u0007\u0005#\u0011iLa0\n\t\u00055(1\u0003\t\u0005\u0005#\u0011\t-\u0003\u0003\u0003D\nM!AB(cU\u0016\u001cG/A\bdE\u001a\u0014un\u001c7fC:\f%O]1z%\u0019\u0011IM!\r\u0003N\u001a1!1Z\r\u0001\u0005\u000f\u0014A\u0002\u0010:fM&tW-\\3oiz\u0002\"B!'\u0003 \n='1\u001eBya\u0011\u0011\tN!6\u0011\u000b\u0005\u001d\u0002Aa5\u0011\t\u0005=\"Q\u001b\u0003\r\u0005/\u0014I.!A\u0001\u0002\u000b\u0005\u0011Q\u0007\u0002\u0004?\u0012\"dA\u0002Bn3\t\u0011iNA\u0003%C:|gn\u0005\u0004\u0003Z\nE\"Q\u001a\u0005\t\u0003S\u0012I\u000e\"\u0001\u0003bR\u0011!1\u001d\t\u0005\u0003_\u0011I\u000e\u0003\u0005\u0002>\neG\u0011\u0001Bt)\u0011\u0011IOa=\u0011\u0011\u0005\u001d\"q\u0005Bv\u0005c\u0004B!!\u000f\u0003n&!!q^A\u000e\u0005\u001d\u0011un\u001c7fC:\u0004R!a\n\u0001\u0005WD\u0001B!>\u0003f\u0002\u0007!q_\u0001\u0005MJ|W\u000e\r\u0003\u0003z\nu\b#BA\u0014\u0001\tm\b\u0003BA\u0018\u0005{$ABa@\u0003t\u0006\u0005\t\u0011!B\u0001\u0003k\u00111a\u0018\u00136\u0011!\tiL!7\u0005\u0002\r\rAC\u0001Bu\u00031\u0019'M\u001a\"zi\u0016\f%O]1z%\u0019\u0019IA!\r\u0004\f\u00191!1\u001a\u000e\u0001\u0007\u000f\u0001\"B!'\u0003 \u000e51qEB\u0017a\u0011\u0019yaa\u0005\u0011\u000b\u0005\u001d\u0002a!\u0005\u0011\t\u0005=21\u0003\u0003\r\u0007+\u00199\"!A\u0001\u0002\u000b\u0005\u0011Q\u0007\u0002\u0004?\u00122dA\u0002Bn5\t\u0019Ib\u0005\u0004\u0004\u0018\tE21\u0002\u0005\t\u0003S\u001a9\u0002\"\u0001\u0004\u001eQ\u00111q\u0004\t\u0005\u0003_\u00199\u0002\u0003\u0005\u0002>\u000e]A\u0011AB\u0012)\u0011\u0019)ca\f\u0011\u0011\u0005\u001d\"qEB\u0014\u0007[\u0001B!!\u000f\u0004*%!11FA\u000e\u0005\u0011\u0011\u0015\u0010^3\u0011\u000b\u0005\u001d\u0002aa\n\t\u0011\tU8\u0011\u0005a\u0001\u0007c\u0001Daa\r\u00048A)\u0011q\u0005\u0001\u00046A!\u0011qFB\u001c\t1\u0019Ida\f\u0002\u0002\u0003\u0005)\u0011AA\u001b\u0005\ryFe\u000e\u0005\t\u0003{\u001b9\u0002\"\u0001\u0004>Q\u00111QE\u0001\rG\n47\t[1s\u0003J\u0014\u0018-\u001f\n\u0007\u0007\u0007\u0012\td!\u0012\u0007\r\t-7\u0004AB!!)\u0011IJa(\u0004H\r\u00054q\r\u0019\u0005\u0007\u0013\u001ai\u0005E\u0003\u0002(\u0001\u0019Y\u0005\u0005\u0003\u00020\r5C\u0001DB(\u0007#\n\t\u0011!A\u0003\u0002\u0005U\"aA0%q\u00191!1\\\u000e\u0003\u0007'\u001aba!\u0015\u00032\r\u0015\u0003\u0002CA5\u0007#\"\taa\u0016\u0015\u0005\re\u0003\u0003BA\u0018\u0007#B\u0001\"!0\u0004R\u0011\u00051Q\f\u000b\u0005\u0007?\u001aI\u0007\u0005\u0005\u0002(\t\u001d2\u0011MB4!\u0011\tIda\u0019\n\t\r\u0015\u00141\u0004\u0002\u0005\u0007\"\f'\u000fE\u0003\u0002(\u0001\u0019\t\u0007\u0003\u0005\u0003v\u000em\u0003\u0019AB6a\u0011\u0019ig!\u001d\u0011\u000b\u0005\u001d\u0002aa\u001c\u0011\t\u0005=2\u0011\u000f\u0003\r\u0007g\u001aI'!A\u0001\u0002\u000b\u0005\u0011Q\u0007\u0002\u0004?\u0012J\u0004\u0002CA_\u0007#\"\taa\u001e\u0015\u0005\r}\u0013AD2cM\u0012{WO\u00197f\u0003J\u0014\u0018-\u001f\n\u0007\u0007{\u0012\tda \u0007\r\t-G\u0004AB>!)\u0011IJa(\u0004\u0002\u000em5\u0011\u0015\u0019\u0005\u0007\u0007\u001b9\tE\u0003\u0002(\u0001\u0019)\t\u0005\u0003\u00020\r\u001dE\u0001DBE\u0007\u0017\u000b\t\u0011!A\u0003\u0002\u0005U\"\u0001B0%cA2aAa7\u001d\u0005\r55CBBF\u0005c\u0019y\b\u0003\u0005\u0002j\r-E\u0011ABI)\t\u0019\u0019\n\u0005\u0003\u00020\r-\u0005\u0002CA_\u0007\u0017#\taa&\u0015\t\re51\u0015\t\t\u0003O\u00119ca'\u0004\"B!\u0011\u0011HBO\u0013\u0011\u0019y*a\u0007\u0003\r\u0011{WO\u00197f!\u0015\t9\u0003ABN\u0011!\u0011)p!&A\u0002\r\u0015\u0006\u0007BBT\u0007W\u0003R!a\n\u0001\u0007S\u0003B!a\f\u0004,\u0012a1QVBR\u0003\u0003\u0005\tQ!\u0001\u00026\t!q\fJ\u00192\u0011!\tila#\u0005\u0002\rEFCABM\u00035\u0019'M\u001a$m_\u0006$\u0018I\u001d:bsJ11q\u0017B\u0019\u0007s3aAa3\u001e\u0001\rU\u0006C\u0003BM\u0005?\u001bYl!6\u0004\\B\"1QXBa!\u0015\t9\u0003AB`!\u0011\tyc!1\u0005\u0019\r\r7QYA\u0001\u0002\u0003\u0015\t!!\u000e\u0003\t}#\u0013G\r\u0004\u0007\u00057l\"aa2\u0014\r\r\u0015'\u0011GB]\u0011!\tIg!2\u0005\u0002\r-GCABg!\u0011\tyc!2\t\u0011\u0005u6Q\u0019C\u0001\u0007#$Baa5\u0004^BA\u0011q\u0005B\u0014\u0007+\u001cY\u000e\u0005\u0003\u0002:\r]\u0017\u0002BBm\u00037\u0011QA\u00127pCR\u0004R!a\n\u0001\u0007+D\u0001B!>\u0004P\u0002\u00071q\u001c\u0019\u0005\u0007C\u001c)\u000fE\u0003\u0002(\u0001\u0019\u0019\u000f\u0005\u0003\u00020\r\u0015H\u0001DBt\u0007;\f\t\u0011!A\u0003\u0002\u0005U\"\u0001B0%cMB\u0001\"!0\u0004F\u0012\u000511\u001e\u000b\u0003\u0007'\f1b\u00192g\u0013:$\u0018I\u001d:bsJ11\u0011\u001fB\u0019\u0007g4aAa3\u001f\u0001\r=\bC\u0003BM\u0005?\u001b)0a.\u0005\u0010A\"1q_B~!\u0015\t9\u0003AB}!\u0011\tyca?\u0005\u0019\ru8q`A\u0001\u0002\u0003\u0015\t!!\u000e\u0003\t}#\u0013\u0007\u000e\u0004\u0007\u00057t\"\u0001\"\u0001\u0014\r\r}(\u0011GBz\u0011!\tIga@\u0005\u0002\u0011\u0015AC\u0001C\u0004!\u0011\tyca@\t\u0011\u0005u6q C\u0001\t\u0017!B\u0001\"\u0004\u0005\u0012AA\u0011q\u0005B\u0014\u0003o#y\u0001E\u0003\u0002(\u0001\t9\f\u0003\u0005\u0003v\u0012%\u0001\u0019\u0001C\na\u0011!)\u0002\"\u0007\u0011\u000b\u0005\u001d\u0002\u0001b\u0006\u0011\t\u0005=B\u0011\u0004\u0003\r\t7!\t\"!A\u0001\u0002\u000b\u0005\u0011Q\u0007\u0002\u0005?\u0012\nT\u0007\u0003\u0005\u0002>\u000e}H\u0011\u0001C\u0010)\t!i!\u0001\u0007dE\u001aduN\\4BeJ\f\u0017P\u0005\u0004\u0005&\tEBq\u0005\u0004\u0007\u0005\u0017|\u0002\u0001b\t\u0011\u0015\te%q\u0014C\u0015\t\u0007\"I\u0005\r\u0003\u0005,\u0011=\u0002#BA\u0014\u0001\u00115\u0002\u0003BA\u0018\t_!A\u0002\"\r\u00054\u0005\u0005\t\u0011!B\u0001\u0003k\u0011Aa\u0018\u00132m\u00191!1\\\u0010\u0003\tk\u0019b\u0001b\r\u00032\u0011\u001d\u0002\u0002CA5\tg!\t\u0001\"\u000f\u0015\u0005\u0011m\u0002\u0003BA\u0018\tgA\u0001\"!0\u00054\u0011\u0005Aq\b\u000b\u0005\t\u0003\"Y\u0005\u0005\u0005\u0002(\t\u001dB1\tC%!\u0011\tI\u0004\"\u0012\n\t\u0011\u001d\u00131\u0004\u0002\u0005\u0019>tw\rE\u0003\u0002(\u0001!\u0019\u0005\u0003\u0005\u0003v\u0012u\u0002\u0019\u0001C'a\u0011!y\u0005b\u0015\u0011\u000b\u0005\u001d\u0002\u0001\"\u0015\u0011\t\u0005=B1\u000b\u0003\r\t+\"Y%!A\u0001\u0002\u000b\u0005\u0011Q\u0007\u0002\u0005?\u0012\nt\u0007\u0003\u0005\u0002>\u0012MB\u0011\u0001C-)\t!\t%A\u0007dE\u001a\u001c\u0006n\u001c:u\u0003J\u0014\u0018-\u001f\n\u0007\t?\u0012\t\u0004\"\u0019\u0007\r\t-\u0007\u0005\u0001C/!)\u0011IJa(\u0005d\u0011uD1\u0011\u0019\u0005\tK\"I\u0007E\u0003\u0002(\u0001!9\u0007\u0005\u0003\u00020\u0011%D\u0001\u0004C6\t[\n\t\u0011!A\u0003\u0002\u0005U\"\u0001B0%ca2aAa7!\u0005\u0011=4C\u0002C7\u0005c!\t\u0007\u0003\u0005\u0002j\u00115D\u0011\u0001C:)\t!)\b\u0005\u0003\u00020\u00115\u0004\u0002CA_\t[\"\t\u0001\"\u001f\u0015\t\u0011mDQ\u0011\t\t\u0003O\u00119\u0003\" \u0005\u0004B!\u0011\u0011\bC@\u0013\u0011!\t)a\u0007\u0003\u000bMCwN\u001d;\u0011\u000b\u0005\u001d\u0002\u0001\" \t\u0011\tUHq\u000fa\u0001\t\u000f\u0003D\u0001\"#\u0005\u000eB)\u0011q\u0005\u0001\u0005\fB!\u0011q\u0006CG\t1!y\t\"\"\u0002\u0002\u0003\u0005)\u0011AA\u001b\u0005\u0011yF%M\u001d\t\u0011\u0005uFQ\u000eC\u0001\t'#\"\u0001b\u001f\u0002\u0019\r\u0014g-\u00168ji\u0006\u0013(/Y=\u0013\r\u0011e%\u0011\u0007CN\r\u0019\u0011Y-\t\u0001\u0005\u0018BQ!\u0011\u0014BP\t;\u000bI\rb.1\t\u0011}E1\u0015\t\u0006\u0003O\u0001A\u0011\u0015\t\u0005\u0003_!\u0019\u000b\u0002\u0007\u0005&\u0012\u001d\u0016\u0011!A\u0001\u0006\u0003\t)D\u0001\u0003`II\u0002dA\u0002BnC\t!Ik\u0005\u0004\u0005(\nEB1\u0014\u0005\t\u0003S\"9\u000b\"\u0001\u0005.R\u0011Aq\u0016\t\u0005\u0003_!9\u000b\u0003\u0005\u0002>\u0012\u001dF\u0011\u0001CZ)\u0011!)\f\"/\u0011\u0011\u0005\u001d\"qEAe\to\u0003R!a\n\u0001\u0003\u0013D\u0001B!>\u00052\u0002\u0007A1\u0018\u0019\u0005\t{#\t\rE\u0003\u0002(\u0001!y\f\u0005\u0003\u00020\u0011\u0005G\u0001\u0004Cb\ts\u000b\t\u0011!A\u0003\u0002\u0005U\"\u0001B0%eEB\u0001\"!0\u0005(\u0012\u0005Aq\u0019\u000b\u0003\tk\u000bab\u00192g\u001f\nTWm\u0019;BeJ\f\u0017\u0010\u0005\u0006\u0003\u001a\n}EQ\u001aB`\tS\u0004D\u0001b4\u0005TB)\u0011q\u0005\u0001\u0005RB!\u0011q\u0006Cj\t-!)nIA\u0001\u0002\u0003\u0015\t!!\u000e\u0003\t}##GM\u0001\u0007e\u001647I\u0011$\u0016\t\u0011mG\u0011\u001d\u000b\u0005\t;$)\u000f\u0005\u0006\u0003\u001a\n}EQ\u001aCp\tG\u0004B!a\f\u0005b\u00129\u00111G\u0012C\u0002\t5\u0003#BA\u0014\u0001\u0011}\u0007b\u0002B[G\u0001\u000fAq\u001d\t\u0007\u0003\u007f\n)\tb8\u0011\u000b\u0005\u001d\u0002Aa0\u0016\t\u00115H1_\u000b\u0003\t_\u0004\u0002\"a\n\u0003(\u0011EHq\u001f\t\u0005\u0003_!\u0019\u0010B\u0004\u0005v\u0012\u0012\r!!\u000e\u0003\u0003\u0005\u0003b!a\n\u0002H\u0011E(AB8g\u0005f$XmE\u0003/\u0007[\u0011y%\u0006\u0002\u0005\u0000B1\u0011\u0011HAn\u0007O!B!b\u0001\u0006\u0006A\u0019!q\b\u0018\t\u000f\u0005U\u0017\u00071\u0001\u0005\u0000V\u0011Q\u0011\u0002\t\u0007\u0003\u007f\n)ia\n\u0015\t\r\u001dRQ\u0002\u0005\b\u0003\u0007$\u0004\u0019AA\\)\u0019\tI-\"\u0005\u0006\u0014!9\u00111Y\u001bA\u0002\u0005]\u0006bBAjk\u0001\u00071qE\u0001\u0007KF,\u0018\r\\:\u0015\t\t-X\u0011\u0004\u0005\b\u000b79\u0004\u0019AA \u0003\u0011!\b.\u0019;\u0003\u000f=47\u000b[8siN)\u0001\bb!\u0003PU\u0011Q1\u0005\t\u0007\u0003s\tY\u000e\" \u0015\t\u0015\u001dR\u0011\u0006\t\u0004\u0005\u007fA\u0004bBAkw\u0001\u0007Q1E\u000b\u0003\u000b[\u0001b!a \u0002\u0006\u0012uD\u0003\u0002C?\u000bcAq!a1?\u0001\u0004\t9\f\u0006\u0004\u0002J\u0016URq\u0007\u0005\b\u0003\u0007|\u0004\u0019AA\\\u0011\u001d\t\u0019n\u0010a\u0001\t{\"BAa;\u0006<!9Q1D!A\u0002\u0005}\"AB8g\u0007\"\f'oE\u0003C\u0007O\u0012y%\u0006\u0002\u0006DA1\u0011\u0011HAn\u0007C\"B!b\u0012\u0006JA\u0019!q\b\"\t\u000f\u0005UW\t1\u0001\u0006DU\u0011QQ\n\t\u0007\u0003\u007f\n)i!\u0019\u0015\t\r\u0005T\u0011\u000b\u0005\b\u0003\u0007D\u0005\u0019AA\\)\u0019\tI-\"\u0016\u0006X!9\u00111Y%A\u0002\u0005]\u0006bBAj\u0013\u0002\u00071\u0011\r\u000b\u0005\u0005W,Y\u0006C\u0004\u0006\u001c-\u0003\r!a\u0010\u0003\u000b=4\u0017J\u001c;\u0014\u000b1#yAa\u0014\u0016\u0005\u0015\r\u0004CBA\u001d\u00037\f9\f\u0006\u0003\u0006h\u0015%\u0004c\u0001B \u0019\"9\u0011Q[(A\u0002\u0015\rTCAC7!\u0019\ty(!\"\u00028R!\u0011qWC9\u0011\u001d\t\u0019M\u0015a\u0001\u0003o#b!!3\u0006v\u0015]\u0004bBAb'\u0002\u0007\u0011q\u0017\u0005\b\u0003'\u001c\u0006\u0019AA\\)\u0011\u0011Y/b\u001f\t\u000f\u0015mQ\u000b1\u0001\u0002@\t1qN\u001a'p]\u001e\u001cRA\u0016C%\u0005\u001f*\"!b!\u0011\r\u0005e\u00121\u001cC\")\u0011)9)\"#\u0011\u0007\t}b\u000bC\u0004\u0002Vf\u0003\r!b!\u0016\u0005\u00155\u0005CBA@\u0003\u000b#\u0019\u0005\u0006\u0003\u0005D\u0015E\u0005bBAb9\u0002\u0007\u0011q\u0017\u000b\u0007\u0003\u0013,)*b&\t\u000f\u0005\rW\f1\u0001\u00028\"9\u00111[/A\u0002\u0011\rC\u0003\u0002Bv\u000b7Cq!b\u0007`\u0001\u0004\tyDA\u0004pM\u001acw.\u0019;\u0014\u000b\u0001\u001cYNa\u0014\u0016\u0005\u0015\r\u0006CBA\u001d\u00037\u001c)\u000e\u0006\u0003\u0006(\u0016%\u0006c\u0001B A\"9\u0011Q[2A\u0002\u0015\rVCACW!\u0019\ty(!\"\u0004VR!1Q[CY\u0011\u001d\t\u0019M\u001aa\u0001\u0003o#b!!3\u00066\u0016]\u0006bBAbO\u0002\u0007\u0011q\u0017\u0005\b\u0003'<\u0007\u0019ABk)\u0011\u0011Y/b/\t\u000f\u0015m\u0011\u000e1\u0001\u0002@\tAqN\u001a#pk\ndWmE\u0003k\u0007C\u0013y%\u0006\u0002\u0006DB1\u0011\u0011HAn\u00077#B!b2\u0006JB\u0019!q\b6\t\u000f\u0005UW\u000e1\u0001\u0006DV\u0011QQ\u001a\t\u0007\u0003\u007f\n)ia'\u0015\t\rmU\u0011\u001b\u0005\b\u0003\u0007\u0004\b\u0019AA\\)\u0019\tI-\"6\u0006X\"9\u00111Y9A\u0002\u0005]\u0006bBAjc\u0002\u000711\u0014\u000b\u0005\u0005W,Y\u000eC\u0004\u0006\u001cM\u0004\r!a\u0010\u0003\u0013=4'i\\8mK\u0006t7#\u0002;\u0003r\n=SCACr!\u0019\tI$a7\u0003lR!Qq]Cu!\r\u0011y\u0004\u001e\u0005\b\u0003+<\b\u0019ACr+\t)i\u000f\u0005\u0004\u0002\u0000\u0005\u0015%1\u001e\u000b\u0005\u0005W,\t\u0010C\u0004\u0002Dj\u0004\r!a.\u0015\r\u0005%WQ_C|\u0011\u001d\t\u0019m\u001fa\u0001\u0003oCq!a5|\u0001\u0004\u0011Y\u000f\u0006\u0003\u0003l\u0016m\bbBC\u000e{\u0002\u0007\u0011q\b\u0002\u0007_\u001a,f.\u001b;\u0014\u000by$9La\u0014\u0016\u0005\u0019\r\u0001CBA\u001d\u00037\fI\r\u0006\u0003\u0007\b\u0019%\u0001c\u0001B }\"A\u0011Q[A\u0002\u0001\u00041\u0019!\u0006\u0002\u0007\u000eA1\u0011qPAC\u0003\u0013$B!!3\u0007\u0012!A\u00111YA\u0005\u0001\u0004\t9\f\u0006\u0004\u0002J\u001aUaq\u0003\u0005\t\u0003\u0007\fY\u00011\u0001\u00028\"A\u00111[A\u0006\u0001\u0004\tI\r\u0006\u0003\u0003l\u001am\u0001\u0002CC\u000e\u0003\u001f\u0001\r!a\u0010")
public abstract class WrappedArray<T>
extends AbstractSeq<T>
implements IndexedSeq<T>,
ArrayLike<T, WrappedArray<T>>,
CustomParallelizable<T, ParArray<T>> {
    public static <T> CanBuildFrom<WrappedArray<?>, T, WrappedArray<T>> canBuildFrom(ClassTag<T> classTag) {
        return WrappedArray$.MODULE$.canBuildFrom(classTag);
    }

    public static <T> WrappedArray<T> make(Object object) {
        return WrappedArray$.MODULE$.make(object);
    }

    public static <T> WrappedArray<T> empty() {
        return WrappedArray$.MODULE$.empty();
    }

    @Override
    public Combiner<T, ParArray<T>> parCombiner() {
        return CustomParallelizable.parCombiner$(this);
    }

    @Override
    public scala.collection.IndexedSeq<Object> deep() {
        return ArrayLike.deep$(this);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceLeft(Function2 op) {
        return TraversableOnce.reduceLeft$(this, op);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceRight(Function2 op) {
        return this.iterator().reduceRight(op);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$zip(GenIterable that, CanBuildFrom bf) {
        return IterableLike.zip$(this, that, bf);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$head() {
        return IterableLike.head$(this);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$tail() {
        return TraversableLike.tail$(this);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$last() {
        return TraversableLike.last$(this);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$init() {
        return TraversableLike.init$(this);
    }

    @Override
    public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$sameElements(GenIterable that) {
        return IterableLike.sameElements$(this, that);
    }

    @Override
    public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$endsWith(GenSeq that) {
        return SeqLike.endsWith$(this, that);
    }

    @Override
    public boolean isEmpty() {
        return IndexedSeqOptimized.isEmpty$(this);
    }

    @Override
    public <U> void foreach(Function1<T, U> f) {
        IndexedSeqOptimized.foreach$(this, f);
    }

    @Override
    public boolean forall(Function1<T, Object> p) {
        return IndexedSeqOptimized.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<T, Object> p) {
        return IndexedSeqOptimized.exists$(this, p);
    }

    @Override
    public Option<T> find(Function1<T, Object> p) {
        return IndexedSeqOptimized.find$(this, p);
    }

    @Override
    public <B> B foldLeft(B z, Function2<B, T, B> op) {
        return (B)IndexedSeqOptimized.foldLeft$(this, z, op);
    }

    @Override
    public <B> B foldRight(B z, Function2<T, B, B> op) {
        return (B)IndexedSeqOptimized.foldRight$(this, z, op);
    }

    @Override
    public <B> B reduceLeft(Function2<B, T, B> op) {
        return (B)IndexedSeqOptimized.reduceLeft$(this, op);
    }

    @Override
    public <B> B reduceRight(Function2<T, B, B> op) {
        return (B)IndexedSeqOptimized.reduceRight$(this, op);
    }

    @Override
    public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<WrappedArray<T>, Tuple2<A1, B>, That> bf) {
        return (That)IndexedSeqOptimized.zip$(this, that, bf);
    }

    @Override
    public <A1, That> That zipWithIndex(CanBuildFrom<WrappedArray<T>, Tuple2<A1, Object>, That> bf) {
        return (That)IndexedSeqOptimized.zipWithIndex$(this, bf);
    }

    @Override
    public Object slice(int from, int until) {
        return IndexedSeqOptimized.slice$(this, from, until);
    }

    @Override
    public T head() {
        return (T)IndexedSeqOptimized.head$(this);
    }

    @Override
    public Object tail() {
        return IndexedSeqOptimized.tail$(this);
    }

    @Override
    public T last() {
        return (T)IndexedSeqOptimized.last$(this);
    }

    @Override
    public Object init() {
        return IndexedSeqOptimized.init$(this);
    }

    @Override
    public Object take(int n) {
        return IndexedSeqOptimized.take$(this, n);
    }

    @Override
    public Object drop(int n) {
        return IndexedSeqOptimized.drop$(this, n);
    }

    @Override
    public Object takeRight(int n) {
        return IndexedSeqOptimized.takeRight$(this, n);
    }

    @Override
    public Object dropRight(int n) {
        return IndexedSeqOptimized.dropRight$(this, n);
    }

    @Override
    public Tuple2<WrappedArray<T>, WrappedArray<T>> splitAt(int n) {
        return IndexedSeqOptimized.splitAt$(this, n);
    }

    @Override
    public Object takeWhile(Function1 p) {
        return IndexedSeqOptimized.takeWhile$(this, p);
    }

    @Override
    public Object dropWhile(Function1 p) {
        return IndexedSeqOptimized.dropWhile$(this, p);
    }

    @Override
    public Tuple2<WrappedArray<T>, WrappedArray<T>> span(Function1<T, Object> p) {
        return IndexedSeqOptimized.span$(this, p);
    }

    @Override
    public <B> boolean sameElements(GenIterable<B> that) {
        return IndexedSeqOptimized.sameElements$(this, that);
    }

    @Override
    public <B> void copyToArray(Object xs, int start, int len) {
        IndexedSeqOptimized.copyToArray$(this, xs, start, len);
    }

    @Override
    public int lengthCompare(int len) {
        return IndexedSeqOptimized.lengthCompare$(this, len);
    }

    @Override
    public int segmentLength(Function1<T, Object> p, int from) {
        return IndexedSeqOptimized.segmentLength$(this, p, from);
    }

    @Override
    public int indexWhere(Function1<T, Object> p, int from) {
        return IndexedSeqOptimized.indexWhere$(this, p, from);
    }

    @Override
    public int lastIndexWhere(Function1<T, Object> p, int end) {
        return IndexedSeqOptimized.lastIndexWhere$(this, p, end);
    }

    @Override
    public Object reverse() {
        return IndexedSeqOptimized.reverse$(this);
    }

    @Override
    public Iterator<T> reverseIterator() {
        return IndexedSeqOptimized.reverseIterator$(this);
    }

    @Override
    public <B> boolean startsWith(GenSeq<B> that, int offset) {
        return IndexedSeqOptimized.startsWith$(this, that, offset);
    }

    @Override
    public <B> boolean endsWith(GenSeq<B> that) {
        return IndexedSeqOptimized.endsWith$(this, that);
    }

    @Override
    public List<T> toList() {
        return IndexedSeqOptimized.toList$(this);
    }

    @Override
    public GenericCompanion<IndexedSeq> companion() {
        return IndexedSeq.companion$(this);
    }

    @Override
    public IndexedSeq<T> seq() {
        return IndexedSeq.seq$(this);
    }

    @Override
    public IndexedSeqView<T, WrappedArray<T>> view() {
        return scala.collection.mutable.IndexedSeqLike.view$(this);
    }

    @Override
    public IndexedSeqView<T, WrappedArray<T>> view(int from, int until) {
        return scala.collection.mutable.IndexedSeqLike.view$(this, from, until);
    }

    @Override
    public int hashCode() {
        return IndexedSeqLike.hashCode$(this);
    }

    @Override
    public Iterator<T> iterator() {
        return IndexedSeqLike.iterator$(this);
    }

    @Override
    public <A1> Buffer<A1> toBuffer() {
        return IndexedSeqLike.toBuffer$(this);
    }

    @Override
    public int sizeHintIfCheap() {
        return IndexedSeqLike.sizeHintIfCheap$(this);
    }

    @Override
    public WrappedArray<T> thisCollection() {
        return this;
    }

    @Override
    public WrappedArray<T> toCollection(WrappedArray<T> repr) {
        return repr;
    }

    public abstract ClassTag<T> elemTag();

    public ClassTag<T> elemManifest() {
        return Predef$.MODULE$.ClassManifest().fromClass(this.elemTag().runtimeClass());
    }

    @Override
    public abstract int length();

    @Override
    public abstract T apply(int var1);

    @Override
    public abstract void update(int var1, T var2);

    public abstract Object array();

    @Override
    public ParArray<T> par() {
        return ParArray$.MODULE$.handoff(this.array());
    }

    private Class<?> elementClass() {
        return this.array().getClass().getComponentType();
    }

    @Override
    public <U> Object toArray(ClassTag<U> evidence$1) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Class<?> thatElementClass = evidence$1.runtimeClass();
        if (this.elementClass() == thatElementClass) {
            return this.array();
        }
        return TraversableOnce.toArray$(this, evidence$1);
    }

    @Override
    public String stringPrefix() {
        return "WrappedArray";
    }

    @Override
    public WrappedArray<T> clone() {
        return WrappedArray$.MODULE$.make(ScalaRunTime$.MODULE$.array_clone(this.array()));
    }

    @Override
    public Builder<T, WrappedArray<T>> newBuilder() {
        return new WrappedArrayBuilder<T>(this.elemTag());
    }

    public WrappedArray() {
        IndexedSeqLike.$init$(this);
        scala.collection.IndexedSeq.$init$(this);
        scala.collection.mutable.IndexedSeqLike.$init$(this);
        IndexedSeq.$init$(this);
        IndexedSeqOptimized.$init$(this);
        ArrayLike.$init$(this);
        CustomParallelizable.$init$(this);
    }

    public static final class ofBoolean
    extends WrappedArray<Object>
    implements Serializable {
        private final boolean[] array;

        public boolean[] array() {
            return this.array;
        }

        @Override
        public ClassTag<Object> elemTag() {
            return ClassTag$.MODULE$.Boolean();
        }

        @Override
        public int length() {
            return this.array().length;
        }

        @Override
        public boolean apply(int index) {
            return this.apply$mcZI$sp(index);
        }

        @Override
        public void update(int index, boolean elem) {
            this.array()[index] = elem;
        }

        @Override
        public int hashCode() {
            return MurmurHash3$.MODULE$.wrappedArrayHash$mZc$sp(this.array());
        }

        @Override
        public boolean equals(Object that) {
            boolean bl;
            if (that instanceof ofBoolean) {
                ofBoolean ofBoolean2 = (ofBoolean)that;
                bl = Arrays.equals(this.array(), ofBoolean2.array());
            } else {
                bl = GenSeqLike.equals$(this, that);
            }
            return bl;
        }

        @Override
        public boolean apply$mcZI$sp(int index) {
            return this.array()[index];
        }

        public ofBoolean(boolean[] array) {
            this.array = array;
        }
    }

    public static final class ofByte
    extends WrappedArray<Object>
    implements Serializable {
        private final byte[] array;

        public byte[] array() {
            return this.array;
        }

        @Override
        public ClassTag<Object> elemTag() {
            return ClassTag$.MODULE$.Byte();
        }

        @Override
        public int length() {
            return this.array().length;
        }

        @Override
        public byte apply(int index) {
            return this.array()[index];
        }

        @Override
        public void update(int index, byte elem) {
            this.array()[index] = elem;
        }

        @Override
        public int hashCode() {
            return MurmurHash3$.MODULE$.wrappedBytesHash(this.array());
        }

        @Override
        public boolean equals(Object that) {
            boolean bl;
            if (that instanceof ofByte) {
                ofByte ofByte2 = (ofByte)that;
                bl = Arrays.equals(this.array(), ofByte2.array());
            } else {
                bl = GenSeqLike.equals$(this, that);
            }
            return bl;
        }

        public ofByte(byte[] array) {
            this.array = array;
        }
    }

    public static final class ofChar
    extends WrappedArray<Object>
    implements Serializable {
        private final char[] array;

        public char[] array() {
            return this.array;
        }

        @Override
        public ClassTag<Object> elemTag() {
            return ClassTag$.MODULE$.Char();
        }

        @Override
        public int length() {
            return this.array().length;
        }

        @Override
        public char apply(int index) {
            return this.array()[index];
        }

        @Override
        public void update(int index, char elem) {
            this.array()[index] = elem;
        }

        @Override
        public int hashCode() {
            return MurmurHash3$.MODULE$.wrappedArrayHash$mCc$sp(this.array());
        }

        @Override
        public boolean equals(Object that) {
            boolean bl;
            if (that instanceof ofChar) {
                ofChar ofChar2 = (ofChar)that;
                bl = Arrays.equals(this.array(), ofChar2.array());
            } else {
                bl = GenSeqLike.equals$(this, that);
            }
            return bl;
        }

        public ofChar(char[] array) {
            this.array = array;
        }
    }

    public static final class ofDouble
    extends WrappedArray<Object>
    implements Serializable {
        private final double[] array;

        public double[] array() {
            return this.array;
        }

        @Override
        public ClassTag<Object> elemTag() {
            return ClassTag$.MODULE$.Double();
        }

        @Override
        public int length() {
            return this.array().length;
        }

        @Override
        public double apply(int index) {
            return this.apply$mcDI$sp(index);
        }

        @Override
        public void update(int index, double elem) {
            this.array()[index] = elem;
        }

        @Override
        public int hashCode() {
            return MurmurHash3$.MODULE$.wrappedArrayHash$mDc$sp(this.array());
        }

        @Override
        public boolean equals(Object that) {
            boolean bl;
            if (that instanceof ofDouble) {
                ofDouble ofDouble2 = (ofDouble)that;
                bl = Arrays.equals(this.array(), ofDouble2.array());
            } else {
                bl = GenSeqLike.equals$(this, that);
            }
            return bl;
        }

        @Override
        public double apply$mcDI$sp(int index) {
            return this.array()[index];
        }

        public ofDouble(double[] array) {
            this.array = array;
        }
    }

    public static final class ofFloat
    extends WrappedArray<Object>
    implements Serializable {
        private final float[] array;

        public float[] array() {
            return this.array;
        }

        @Override
        public ClassTag<Object> elemTag() {
            return ClassTag$.MODULE$.Float();
        }

        @Override
        public int length() {
            return this.array().length;
        }

        @Override
        public float apply(int index) {
            return this.apply$mcFI$sp(index);
        }

        @Override
        public void update(int index, float elem) {
            this.array()[index] = elem;
        }

        @Override
        public int hashCode() {
            return MurmurHash3$.MODULE$.wrappedArrayHash$mFc$sp(this.array());
        }

        @Override
        public boolean equals(Object that) {
            boolean bl;
            if (that instanceof ofFloat) {
                ofFloat ofFloat2 = (ofFloat)that;
                bl = Arrays.equals(this.array(), ofFloat2.array());
            } else {
                bl = GenSeqLike.equals$(this, that);
            }
            return bl;
        }

        @Override
        public float apply$mcFI$sp(int index) {
            return this.array()[index];
        }

        public ofFloat(float[] array) {
            this.array = array;
        }
    }

    public static final class ofInt
    extends WrappedArray<Object>
    implements Serializable {
        private final int[] array;

        public int[] array() {
            return this.array;
        }

        @Override
        public ClassTag<Object> elemTag() {
            return ClassTag$.MODULE$.Int();
        }

        @Override
        public int length() {
            return this.array().length;
        }

        @Override
        public int apply(int index) {
            return this.apply$mcII$sp(index);
        }

        @Override
        public void update(int index, int elem) {
            this.array()[index] = elem;
        }

        @Override
        public int hashCode() {
            return MurmurHash3$.MODULE$.wrappedArrayHash$mIc$sp(this.array());
        }

        @Override
        public boolean equals(Object that) {
            boolean bl;
            if (that instanceof ofInt) {
                ofInt ofInt2 = (ofInt)that;
                bl = Arrays.equals(this.array(), ofInt2.array());
            } else {
                bl = GenSeqLike.equals$(this, that);
            }
            return bl;
        }

        @Override
        public int apply$mcII$sp(int index) {
            return this.array()[index];
        }

        public ofInt(int[] array) {
            this.array = array;
        }
    }

    public static final class ofLong
    extends WrappedArray<Object>
    implements Serializable {
        private final long[] array;

        public long[] array() {
            return this.array;
        }

        @Override
        public ClassTag<Object> elemTag() {
            return ClassTag$.MODULE$.Long();
        }

        @Override
        public int length() {
            return this.array().length;
        }

        @Override
        public long apply(int index) {
            return this.apply$mcJI$sp(index);
        }

        @Override
        public void update(int index, long elem) {
            this.array()[index] = elem;
        }

        @Override
        public int hashCode() {
            return MurmurHash3$.MODULE$.wrappedArrayHash$mJc$sp(this.array());
        }

        @Override
        public boolean equals(Object that) {
            boolean bl;
            if (that instanceof ofLong) {
                ofLong ofLong2 = (ofLong)that;
                bl = Arrays.equals(this.array(), ofLong2.array());
            } else {
                bl = GenSeqLike.equals$(this, that);
            }
            return bl;
        }

        @Override
        public long apply$mcJI$sp(int index) {
            return this.array()[index];
        }

        public ofLong(long[] array) {
            this.array = array;
        }
    }

    public static final class ofRef<T>
    extends WrappedArray<T>
    implements Serializable {
        private final T[] array;

        public T[] array() {
            return this.array;
        }

        @Override
        public ClassTag<T> elemTag() {
            return ClassTag$.MODULE$.apply(this.array().getClass().getComponentType());
        }

        @Override
        public int length() {
            return this.array().length;
        }

        @Override
        public T apply(int index) {
            return this.array()[index];
        }

        @Override
        public void update(int index, T elem) {
            this.array()[index] = elem;
        }

        @Override
        public int hashCode() {
            return MurmurHash3$.MODULE$.wrappedArrayHash(this.array());
        }

        public ofRef(T[] array) {
            this.array = array;
        }
    }

    public static final class ofShort
    extends WrappedArray<Object>
    implements Serializable {
        private final short[] array;

        public short[] array() {
            return this.array;
        }

        @Override
        public ClassTag<Object> elemTag() {
            return ClassTag$.MODULE$.Short();
        }

        @Override
        public int length() {
            return this.array().length;
        }

        @Override
        public short apply(int index) {
            return this.array()[index];
        }

        @Override
        public void update(int index, short elem) {
            this.array()[index] = elem;
        }

        @Override
        public int hashCode() {
            return MurmurHash3$.MODULE$.wrappedArrayHash$mSc$sp(this.array());
        }

        @Override
        public boolean equals(Object that) {
            boolean bl;
            if (that instanceof ofShort) {
                ofShort ofShort2 = (ofShort)that;
                bl = Arrays.equals(this.array(), ofShort2.array());
            } else {
                bl = GenSeqLike.equals$(this, that);
            }
            return bl;
        }

        public ofShort(short[] array) {
            this.array = array;
        }
    }

    public static final class ofUnit
    extends WrappedArray<BoxedUnit>
    implements Serializable {
        private final BoxedUnit[] array;

        public BoxedUnit[] array() {
            return this.array;
        }

        @Override
        public ClassTag<BoxedUnit> elemTag() {
            return ClassTag$.MODULE$.Unit();
        }

        @Override
        public int length() {
            return this.array().length;
        }

        @Override
        public void apply(int index) {
            this.apply$mcVI$sp(index);
        }

        @Override
        public void update(int index, BoxedUnit elem) {
            this.array()[index] = elem;
        }

        @Override
        public int hashCode() {
            return MurmurHash3$.MODULE$.wrappedArrayHash$mVc$sp(this.array());
        }

        @Override
        public boolean equals(Object that) {
            boolean bl;
            if (that instanceof ofUnit) {
                ofUnit ofUnit2 = (ofUnit)that;
                bl = this.array().length == ofUnit2.array().length;
            } else {
                bl = GenSeqLike.equals$(this, that);
            }
            return bl;
        }

        @Override
        public void apply$mcVI$sp(int index) {
            BoxedUnit cfr_ignored_0 = this.array()[index];
        }

        public ofUnit(BoxedUnit[] array) {
            this.array = array;
        }
    }
}

