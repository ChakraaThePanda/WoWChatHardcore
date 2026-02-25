/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.api;

import java.io.ObjectStreamException;
import scala.Equals;
import scala.Function1;
import scala.Serializable;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Mirror;
import scala.reflect.api.SerializedTypeTag;
import scala.reflect.api.Symbols;
import scala.reflect.api.TypeCreator;
import scala.reflect.api.TypeTags$TypeTag$;
import scala.reflect.api.TypeTags$WeakTypeTag$;
import scala.reflect.api.Types;
import scala.reflect.api.Universe;

@ScalaSignature(bytes="\u0006\u0001\u0011=dAC={!\u0003\r\t!a\u0001\u0002X!9\u0011Q\u0002\u0001\u0005\u0002\u0005=a!CA\f\u0001A\u0005\u0019\u0011AA\r\u0011\u001d\tiA\u0001C\u0001\u0003\u001fA\u0011\"!\u000b\u0003\u0005\u00045\t!a\u000b\t\u000f\u0005e\"A\"\u0001\u0002<!9\u00111\u0010\u0002\u0007\u0002\u0005u\u0004bBAE\u0005\u0011\u0005\u00131\u0012\u0005\b\u0003/\u0013A\u0011IAM\u0011\u001d\tiJ\u0001C!\u0003?Cq!a*\u0003\t\u0003\nIkB\u0004\u0002N\u0002A\t!a4\u0007\u000f\u0005]\u0001\u0001#\u0001\u0002R\"9\u00111\u001b\u0007\u0005\u0002\u0005U\u0007\"CAl\u0019\t\u0007I\u0011AAm\u0011!\t\u0019\u000f\u0004Q\u0001\n\u0005m\u0007\"CAs\u0019\t\u0007I\u0011AAt\u0011!\t\t\u0010\u0004Q\u0001\n\u0005%\b\"CAz\u0019\t\u0007I\u0011AA{\u0011!\ty\u0010\u0004Q\u0001\n\u0005]\b\"\u0003B\u0001\u0019\t\u0007I\u0011\u0001B\u0002\u0011!\u00119\u0001\u0004Q\u0001\n\t\u0015\u0001\"\u0003B\u0005\u0019\t\u0007I\u0011\u0001B\u0006\u0011!\u0011)\u0002\u0004Q\u0001\n\t5\u0001\"\u0003B\f\u0019\t\u0007I\u0011\u0001B\r\u0011!\u0011\u0019\u0003\u0004Q\u0001\n\tm\u0001\"\u0003B\u0013\u0019\t\u0007I\u0011\u0001B\u0014\u0011!\u0011\t\u0004\u0004Q\u0001\n\t%\u0002\"\u0003B\u001a\u0019\t\u0007I\u0011\u0001B\u001b\u0011!\u0011I\u0004\u0004Q\u0001\n\t]\u0002\"\u0003B\u001e\u0019\t\u0007I\u0011\u0001B\u001f\u0011!\u0011\t\u0005\u0004Q\u0001\n\t}\u0002\"\u0003B\"\u0019\t\u0007I\u0011\u0001B#\u0011!\u0011I\u0005\u0004Q\u0001\n\t\u001d\u0003\"\u0003B&\u0019\t\u0007I\u0011\u0001B'\u0011!\u00119\u0006\u0004Q\u0001\n\t=\u0003\"\u0003B-\u0019\t\u0007I\u0011\u0001B.\u0011!\u0011y\u0006\u0004Q\u0001\n\tu\u0003\"\u0003B1\u0019\t\u0007I\u0011\u0001B2\u0011!\u0011i\u0007\u0004Q\u0001\n\t\u0015\u0004\"\u0003B8\u0019\t\u0007I\u0011\u0001B9\u0011!\u0011)\b\u0004Q\u0001\n\tM\u0004\"\u0003B<\u0019\t\u0007I\u0011\u0001B=\u0011!\u0011\u0019\t\u0004Q\u0001\n\tm\u0004b\u0002BC\u0019\u0011\u0005!q\u0011\u0005\b\u0005CcA\u0011\u0001BR\r\u0019\u00119\f\u0001\u0003\u0003:\"Q\u0011\u0011\u0006\u0018\u0003\u0006\u0004%\t!a\u000b\t\u0015\t\rgF!A!\u0002\u0013\ti\u0003\u0003\u0006\u0003F:\u0012)\u0019!C\u0001\u0005\u000fD!B!3/\u0005\u0003\u0005\u000b\u0011\u0002BN\u0011\u001d\t\u0019N\fC\u0001\u0005\u0017D!\"a\u001f/\u0011\u000b\u0007I\u0011AA?\u0011\u001d\tID\fC\u0001\u0005'DqAa:/\t\u0013\u0011IOB\u0005\u0004\u0002\u0001\u0001\n1!\u0001\u0004\u0004!9\u0011QB\u001c\u0005\u0002\u0005=\u0001bBA\u001do\u0019\u00053Q\u0002\u0005\b\u0003\u0013;D\u0011IB\u0011\u0011\u001d\t9j\u000eC!\u0007KAq!!(8\t\u0003\ny\nC\u0004\u0002(^\"\t%!+\b\u000f\r=\u0002\u0001#\u0001\u00042\u001991\u0011\u0001\u0001\t\u0002\rM\u0002bBAj\u007f\u0011\u00051Q\u0007\u0005\n\u0003/|$\u0019!C\u0001\u0007oA\u0001\"a9@A\u0003%1\u0011\b\u0005\n\u0003K|$\u0019!C\u0001\u0007wA\u0001\"!=@A\u0003%1Q\b\u0005\n\u0003g|$\u0019!C\u0001\u0007\u007fA\u0001\"a@@A\u0003%1\u0011\t\u0005\n\u0005\u0003y$\u0019!C\u0001\u0007\u0007B\u0001Ba\u0002@A\u0003%1Q\t\u0005\n\u0005\u0013y$\u0019!C\u0001\u0007\u000fB\u0001B!\u0006@A\u0003%1\u0011\n\u0005\n\u0005/y$\u0019!C\u0001\u0007\u0017B\u0001Ba\t@A\u0003%1Q\n\u0005\n\u0005Ky$\u0019!C\u0001\u0007\u001fB\u0001B!\r@A\u0003%1\u0011\u000b\u0005\n\u0005gy$\u0019!C\u0001\u0007'B\u0001B!\u000f@A\u0003%1Q\u000b\u0005\n\u0005wy$\u0019!C\u0001\u0007/B\u0001B!\u0011@A\u0003%1\u0011\f\u0005\n\u0005\u0007z$\u0019!C\u0001\u00077B\u0001B!\u0013@A\u0003%1Q\f\u0005\n\u0005\u0017z$\u0019!C\u0001\u0007?B\u0001Ba\u0016@A\u0003%1\u0011\r\u0005\n\u00053z$\u0019!C\u0001\u0007GB\u0001Ba\u0018@A\u0003%1Q\r\u0005\n\u0005Cz$\u0019!C\u0001\u0007OB\u0001B!\u001c@A\u0003%1\u0011\u000e\u0005\n\u0005_z$\u0019!C\u0001\u0007WB\u0001B!\u001e@A\u0003%1Q\u000e\u0005\n\u0005oz$\u0019!C\u0001\u0007_B\u0001Ba!@A\u0003%1\u0011\u000f\u0005\b\u0005\u000b{D\u0011AB:\u0011\u001d\u0011\tk\u0010C\u0001\u0007\u0003C\u0011b!$@\u0005\u0004%Iaa$\t\u0011\rEu\b)A\u0005\u0003\u001bC\u0001ba%\u0001\t\u0003a8Q\u0013\u0004\u0007\u0007G\u0003Aa!*\t\u0017\u0005%BM!A!\u0002\u0013\tic\f\u0005\f\u0005\u000b$'\u0011!Q\u0001\n\tm\u0015\u0007C\u0004\u0002T\u0012$\ta!-\t\u000f\u0005eB\r\"\u0011\u0004:\"9!q\u001d3\u0005\n\t%hABBh\u0001\u0011\u0019\t\u000e\u0003\u0006\u0004V*\u0014\t\u0011)A\u0005\u0007/Dq!a5k\t\u0003\u0019\u0019\u000fC\u0004\u0003\u0006*$\ta!;\u0007\r\r}\b\u0001\u0002C\u0001\u0011)!YA\u001cB\u0001B\u0003%\u0011q\u0010\u0005\u000b\u0007+t'\u0011!Q\u0001\n\u00115\u0001bBAj]\u0012\u0005A\u0011\u0003\u0005\u000b\u0003wr\u0007R1A\u0005B\u0005u\u0004b\u0002Bt]\u0012%!\u0011\u001e\u0005\b\t7\u0001A\u0011\u0001C\u000f\u0011\u001d!Y\u0003\u0001C\u0001\t[Aq\u0001\"\u000f\u0001\t\u0003!Y\u0004C\u0004\u0005H\u0001!\t\u0001\"\u0013\t\u000f\u0011U\u0003A\"\u0001\u0005X\tAA+\u001f9f)\u0006<7O\u0003\u0002|y\u0006\u0019\u0011\r]5\u000b\u0005ut\u0018a\u0002:fM2,7\r\u001e\u0006\u0002\u007f\u0006)1oY1mC\u000e\u00011c\u0001\u0001\u0002\u0006A!\u0011qAA\u0005\u001b\u0005q\u0018bAA\u0006}\n1\u0011I\\=SK\u001a\fa\u0001J5oSR$CCAA\t!\u0011\t9!a\u0005\n\u0007\u0005UaP\u0001\u0003V]&$(aC,fC.$\u0016\u0010]3UC\u001e,B!a\u0007\u0002hM9!!!\u0002\u0002\u001e\u0005\r\u0002\u0003BA\u0004\u0003?I1!!\t\u007f\u0005\u0019)\u0015/^1mgB!\u0011qAA\u0013\u0013\r\t9C \u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0007[&\u0014(o\u001c:\u0016\u0005\u00055\u0002\u0003BA\u0018\u0003ci\u0011\u0001A\u0005\u0005\u0003g\t)D\u0001\u0004NSJ\u0014xN]\u0005\u0004\u0003oQ(aB'jeJ|'o]\u0001\u0003S:,B!!\u0010\u0002FQ!\u0011qHA:!\u0015\t\tEAA3!\u0011\t\u0019%!\u0012\r\u0001\u00119\u0011qI\u0003C\u0002\u0005%#!A+\u0012\t\u0005-\u0013\u0011\u000b\t\u0005\u0003\u000f\ti%C\u0002\u0002Py\u0014qAT8uQ&twM\u0005\u0004\u0002T\u0005]\u0013q\f\u0004\u0007\u0003+\u0012\u0001!!\u0015\u0003\u0019q\u0012XMZ5oK6,g\u000e\u001e \u0011\t\u0005e\u00131L\u0007\u0002u&\u0019\u0011Q\f>\u0003\u0011Us\u0017N^3sg\u0016\u0004B!a\u0002\u0002b%\u0019\u00111\r@\u0003\u0013MKgn\u001a7fi>t\u0007\u0003BA\"\u0003O\"q!!\u001b\u0003\u0005\u0004\tYGA\u0001U#\u0011\tY%!\u001c\u0011\t\u0005\u001d\u0011qN\u0005\u0004\u0003cr(aA!os\"9\u0011QO\u0003A\u0002\u0005]\u0014aC8uQ\u0016\u0014X*\u001b:s_J\u0004b!!\u0017\u0002z\u0005\u0005\u0013bAA\u001au\u0006\u0019A\u000f]3\u0016\u0005\u0005}\u0004\u0003BA\u0018\u0003\u0003KA!a!\u0002\u0006\n!A+\u001f9f\u0013\r\t9I\u001f\u0002\u0006)f\u0004Xm]\u0001\tG\u0006tW)];bYR!\u0011QRAJ!\u0011\t9!a$\n\u0007\u0005EePA\u0004C_>dW-\u00198\t\u000f\u0005Uu\u00011\u0001\u0002n\u0005\t\u00010\u0001\u0004fcV\fGn\u001d\u000b\u0005\u0003\u001b\u000bY\nC\u0004\u0002\u0016\"\u0001\r!!\u001c\u0002\u0011!\f7\u000f[\"pI\u0016$\"!!)\u0011\t\u0005\u001d\u00111U\u0005\u0004\u0003Ks(aA%oi\u0006AAo\\*ue&tw\r\u0006\u0002\u0002,B!\u0011QVA\\\u001b\t\tyK\u0003\u0003\u00022\u0006M\u0016\u0001\u00027b]\u001eT!!!.\u0002\t)\fg/Y\u0005\u0005\u0003s\u000byK\u0001\u0004TiJLgn\u001a\u0015\u0006\u0005\u0005u\u0016\u0011\u001a\t\u0005\u0003\u007f\u000b)-\u0004\u0002\u0002B*\u0019\u00111\u0019@\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0003\u0002H\u0006\u0005'\u0001E5na2L7-\u001b;O_R4u.\u001e8eC\t\tY-A\u0011O_\u0002:V-Y6UsB,G+Y4!CZ\f\u0017\u000e\\1cY\u0016\u0004cm\u001c:!Im$V0A\u0006XK\u0006\\G+\u001f9f)\u0006<\u0007cAA\u0018\u0019M)A\"!\u0002\u0002$\u00051A(\u001b8jiz\"\"!a4\u0002\t\tKH/Z\u000b\u0003\u00037\u0004R!a\f\u0003\u0003;\u0004B!a\u0002\u0002`&\u0019\u0011\u0011\u001d@\u0003\t\tKH/Z\u0001\u0006\u0005f$X\rI\u0001\u0006'\"|'\u000f^\u000b\u0003\u0003S\u0004R!a\f\u0003\u0003W\u0004B!a\u0002\u0002n&\u0019\u0011q\u001e@\u0003\u000bMCwN\u001d;\u0002\rMCwN\u001d;!\u0003\u0011\u0019\u0005.\u0019:\u0016\u0005\u0005]\b#BA\u0018\u0005\u0005e\b\u0003BA\u0004\u0003wL1!!@\u007f\u0005\u0011\u0019\u0005.\u0019:\u0002\u000b\rC\u0017M\u001d\u0011\u0002\u0007%sG/\u0006\u0002\u0003\u0006A)\u0011q\u0006\u0002\u0002\"\u0006!\u0011J\u001c;!\u0003\u0011auN\\4\u0016\u0005\t5\u0001#BA\u0018\u0005\t=\u0001\u0003BA\u0004\u0005#I1Aa\u0005\u007f\u0005\u0011auN\\4\u0002\u000b1{gn\u001a\u0011\u0002\u000b\u0019cw.\u0019;\u0016\u0005\tm\u0001#BA\u0018\u0005\tu\u0001\u0003BA\u0004\u0005?I1A!\t\u007f\u0005\u00151En\\1u\u0003\u00191En\\1uA\u00051Ai\\;cY\u0016,\"A!\u000b\u0011\u000b\u0005=\"Aa\u000b\u0011\t\u0005\u001d!QF\u0005\u0004\u0005_q(A\u0002#pk\ndW-A\u0004E_V\u0014G.\u001a\u0011\u0002\u000f\t{w\u000e\\3b]V\u0011!q\u0007\t\u0006\u0003_\u0011\u0011QR\u0001\t\u0005>|G.Z1oA\u0005!QK\\5u+\t\u0011y\u0004E\u0003\u00020\t\t\t\"A\u0003V]&$\b%A\u0002B]f,\"Aa\u0012\u0011\u000b\u0005=\"!!\u001c\u0002\t\u0005s\u0017\u0010I\u0001\u0007\u0003:Lh+\u00197\u0016\u0005\t=\u0003#BA\u0018\u0005\tE\u0003\u0003BA\u0004\u0005'J1A!\u0016\u007f\u0005\u0019\te.\u001f,bY\u00069\u0011I\\=WC2\u0004\u0013AB!osJ+g-\u0006\u0002\u0003^A)\u0011q\u0006\u0002\u0002\u0006\u00059\u0011I\\=SK\u001a\u0004\u0013AB(cU\u0016\u001cG/\u0006\u0002\u0003fA)\u0011q\u0006\u0002\u0003hA!\u0011Q\u0016B5\u0013\u0011\u0011Y'a,\u0003\r=\u0013'.Z2u\u0003\u001dy%M[3di\u0002\nqAT8uQ&tw-\u0006\u0002\u0003tA)\u0011q\u0006\u0002\u0002L\u0005Aaj\u001c;iS:<\u0007%\u0001\u0003Ok2dWC\u0001B>!\u0015\tyC\u0001B?!\u0011\t9Aa \n\u0007\t\u0005eP\u0001\u0003Ok2d\u0017!\u0002(vY2\u0004\u0013!B1qa2LX\u0003\u0002BE\u0005\u001f#bAa#\u0003\u0012\n]\u0005#BA\u0018\u0005\t5\u0005\u0003BA\"\u0005\u001f#q!!\u001b-\u0005\u0004\tY\u0007C\u0004\u0003\u00142\u0002\rA!&\u0002\u000f5L'O]8scA1\u0011\u0011LA=\u0003_AqA!'-\u0001\u0004\u0011Y*A\u0003ua\u0016\u001c\u0017\u0007\u0005\u0003\u0002Z\tu\u0015b\u0001BPu\nYA+\u001f9f\u0007J,\u0017\r^8s\u0003\u001d)h.\u00199qYf,BA!*\u00036R!!q\u0015BW!\u0019\t9A!+\u0002\u0000%\u0019!1\u0016@\u0003\r=\u0003H/[8o\u0011\u001d\u0011y+\fa\u0001\u0005c\u000bA\u0001\u001e;bOB)\u0011q\u0006\u0002\u00034B!\u00111\tB[\t\u001d\tI'\fb\u0001\u0003W\u0012qbV3bWRK\b/\u001a+bO&k\u0007\u000f\\\u000b\u0005\u0005w\u0013\tmE\u0003/\u0003\u000b\u0011i\fE\u0003\u00020\t\u0011y\f\u0005\u0003\u0002D\t\u0005GaBA5]\t\u0007\u00111N\u0001\b[&\u0014(o\u001c:!\u0003\u0011!\b/Z2\u0016\u0005\tm\u0015!\u0002;qK\u000e\u0004CC\u0002Bg\u0005\u001f\u0014\t\u000eE\u0003\u000209\u0012y\fC\u0004\u0002*M\u0002\r!!\f\t\u000f\t\u00157\u00071\u0001\u0003\u001cV!!Q\u001bBn)\u0011\u00119Na9\u0011\u000b\te'Aa0\u0011\t\u0005\r#1\u001c\u0003\b\u0003\u000f*$\u0019\u0001Bo#\u0011\tYEa8\u0013\r\t\u0005\u0018qKA0\r\u0019\t)F\f\u0001\u0003`\"9\u0011QO\u001bA\u0002\t\u0015\bCBA-\u0003s\u0012I.\u0001\u0007xe&$XMU3qY\u0006\u001cW\r\u0006\u0002\u0002\u0006!*aG!<\u0003\u0000B1\u0011q\u0001Bx\u0005gL1A!=\u007f\u0005\u0019!\bN]8xgB!!Q\u001fB~\u001b\t\u00119P\u0003\u0003\u0003z\u0006M\u0016AA5p\u0013\u0011\u0011iPa>\u0003+=\u0013'.Z2u'R\u0014X-Y7Fq\u000e,\u0007\u000f^5p]\u000e\u0012!1\u001f\u0002\b)f\u0004X\rV1h+\u0011\u0019)aa\u0003\u0014\u0013]\n)aa\u0002\u0002\u001e\u0005\r\u0002#BA\u0018\u0005\r%\u0001\u0003BA\"\u0007\u0017!q!!\u001b8\u0005\u0004\tY'\u0006\u0003\u0004\u0010\rUA\u0003BB\t\u0007;\u0001Raa\u00058\u0007\u0013\u0001B!a\u0011\u0004\u0016\u00119\u0011qI\u001dC\u0002\r]\u0011\u0003BA&\u00073\u0011baa\u0007\u0002X\u0005}cABA+o\u0001\u0019I\u0002C\u0004\u0002ve\u0002\raa\b\u0011\r\u0005e\u0013\u0011PB\n)\u0011\tiia\t\t\u000f\u0005U%\b1\u0001\u0002nQ!\u0011QRB\u0014\u0011\u001d\t)j\u000fa\u0001\u0003[BSaNA_\u0007W\t#a!\f\u0002;9{\u0007\u0005V=qKR\u000bw\rI1wC&d\u0017M\u00197fA\u0019|'\u000f\t\u0013|)v\fq\u0001V=qKR\u000bw\rE\u0002\u00020}\u001aRaPA\u0003\u0003G!\"a!\r\u0016\u0005\re\u0002#BA\u0018o\u0005uWCAB\u001f!\u0015\tycNAv+\t\u0019\t\u0005E\u0003\u00020]\nI0\u0006\u0002\u0004FA)\u0011qF\u001c\u0002\"V\u00111\u0011\n\t\u0006\u0003_9$qB\u000b\u0003\u0007\u001b\u0002R!a\f8\u0005;)\"a!\u0015\u0011\u000b\u0005=rGa\u000b\u0016\u0005\rU\u0003#BA\u0018o\u00055UCAB-!\u0015\tycNA\t+\t\u0019i\u0006E\u0003\u00020]\ni'\u0006\u0002\u0004bA)\u0011qF\u001c\u0003RU\u00111Q\r\t\u0006\u0003_9\u0014QA\u000b\u0003\u0007S\u0002R!a\f8\u0005O*\"a!\u001c\u0011\u000b\u0005=r'a\u0013\u0016\u0005\rE\u0004#BA\u0018o\tuT\u0003BB;\u0007w\"baa\u001e\u0004~\r}\u0004#BA\u0018o\re\u0004\u0003BA\"\u0007w\"q!!\u001b`\u0005\u0004\tY\u0007C\u0004\u0003\u0014~\u0003\rA!&\t\u000f\teu\f1\u0001\u0003\u001cV!11QBF)\u0011\u00119k!\"\t\u000f\t=\u0006\r1\u0001\u0004\bB)\u0011qF\u001c\u0004\nB!\u00111IBF\t\u001d\tI\u0007\u0019b\u0001\u0003W\n\u0011dY1dQ\u0016l\u0015\r^3sS\u0006d\u0017N_3e)f\u0004X\rV1hgV\u0011\u0011QR\u0001\u001bG\u0006\u001c\u0007.Z'bi\u0016\u0014\u0018.\u00197ju\u0016$G+\u001f9f)\u0006<7\u000fI\u0001\f)f\u0004X\rV1h\u00136\u0004H.\u0006\u0003\u0004\u0018\u000euECBBM\u0007?\u001b\t\u000bE\u0003\u00020]\u001aY\n\u0005\u0003\u0002D\ruEaBA5G\n\u0007\u00111\u000e\u0005\b\u0003S\u0019\u0007\u0019AA\u0017\u0011\u001d\u0011)m\u0019a\u0001\u00057\u00131\u0002V=qKR\u000bw-S7qYV!1qUBW'\u0015!7\u0011VBX!\u0015\tyCLBV!\u0011\t\u0019e!,\u0005\u000f\u0005%DM1\u0001\u0002lA)\u0011qF\u001c\u0004,R111WB[\u0007o\u0003R!a\fe\u0007WCq!!\u000bh\u0001\u0004\ti\u0003C\u0004\u0003F\u001e\u0004\rAa'\u0016\t\rm6\u0011\u0019\u000b\u0005\u0007{\u001bI\rE\u0003\u0004@^\u001aY\u000b\u0005\u0003\u0002D\r\u0005GaBA$Q\n\u000711Y\t\u0005\u0003\u0017\u001a)M\u0005\u0004\u0004H\u0006]\u0013q\f\u0004\u0007\u0003+\"\u0007a!2\t\u000f\u0005U\u0004\u000e1\u0001\u0004LB1\u0011\u0011LA=\u0007\u007fCS!\u001bBw\u0005\u007f\u0014\u0011\u0003\u0015:fI\u00164G+\u001f9f\u0007J,\u0017\r^8s+\u0011\u0019\u0019n!9\u0014\u0007)\u0014Y*\u0001\u0004d_BL\u0018J\u001c\t\t\u0003\u000f\u0019I.a\u0016\u0004^&\u001911\u001c@\u0003\u0013\u0019+hn\u0019;j_:\f\u0004#BA,o\r}\u0007\u0003BA\"\u0007C$q!!\u001bk\u0005\u0004\tY\u0007\u0006\u0003\u0004f\u000e\u001d\b#BA\u0018U\u000e}\u0007bBBkY\u0002\u00071q[\u000b\u0005\u0007W\u001c\t\u0010\u0006\u0003\u0004n\u000ee\b\u0003BBx\u0003\u0003\u0003B!a\u0011\u0004r\u00129\u0011qI7C\u0002\rM\u0018\u0003BA&\u0007k\u0014baa>\u0002X\u0005}cABA+U\u0002\u0019)\u0010C\u0004\u0004|6\u0004\ra!@\u0002\u00035\u0004b!!\u0017\u0002z\r=(!\u0004)sK\u0012,g\rV=qKR\u000bw-\u0006\u0003\u0005\u0004\u0011%1c\u00018\u0005\u0006A)\u0011q\u00063\u0005\bA!\u00111\tC\u0005\t\u001d\tIG\u001cb\u0001\u0003W\nAa\u0018;qKBA\u0011qABm\u0003/\"y\u0001E\u0003\u0002X]\"9\u0001\u0006\u0004\u0005\u0014\u0011UAq\u0003\t\u0006\u0003_qGq\u0001\u0005\b\t\u0017\t\b\u0019AA@\u0011\u001d\u0019).\u001da\u0001\t\u001bASa\u001dBw\u0005\u007f\f1b^3bWRK\b/\u001a+bOV!Aq\u0004C\u0013)\u0011!\t\u0003b\n\u0011\u000b\u0005=\"\u0001b\t\u0011\t\u0005\rCQ\u0005\u0003\b\u0003S\"(\u0019AA6\u0011\u001d!I\u0003\u001ea\u0002\tC\tQ!\u0019;uC\u001e\fq\u0001^=qKR\u000bw-\u0006\u0003\u00050\u0011UB\u0003\u0002C\u0019\to\u0001R!a\f8\tg\u0001B!a\u0011\u00056\u00119\u0011\u0011N;C\u0002\u0005-\u0004b\u0002BXk\u0002\u000fA\u0011G\u0001\u000bo\u0016\f7\u000eV=qK>3W\u0003\u0002C\u001f\t\u000b\"B!a \u0005@!9A\u0011\u0006<A\u0004\u0011\u0005\u0003#BA\u0018\u0005\u0011\r\u0003\u0003BA\"\t\u000b\"q!!\u001bw\u0005\u0004\tY'\u0001\u0004usB,wJZ\u000b\u0005\t\u0017\"\u0019\u0006\u0006\u0003\u0002\u0000\u00115\u0003b\u0002BXo\u0002\u000fAq\n\t\u0006\u0003_9D\u0011\u000b\t\u0005\u0003\u0007\"\u0019\u0006B\u0004\u0002j]\u0014\r!a\u001b\u0002\u0011MLXNY8m\u001f\u001a,B\u0001\"\u0017\u0005nQ!A1\fC3!\u0011\ty\u0003\"\u0018\n\t\u0011}C\u0011\r\u0002\u000b)f\u0004XmU=nE>d\u0017b\u0001C2u\n91+_7c_2\u001c\b\"\u0003C4q\u0006\u0005\t9\u0001C5\u0003))g/\u001b3f]\u000e,G%\r\t\u0006\u0003_\u0011A1\u000e\t\u0005\u0003\u0007\"i\u0007B\u0004\u0002ja\u0014\r!a\u001b")
public interface TypeTags {
    public TypeTags$WeakTypeTag$ WeakTypeTag();

    public TypeTags$TypeTag$ TypeTag();

    public static /* synthetic */ TypeTag TypeTagImpl$(TypeTags $this, Mirror mirror, TypeCreator tpec) {
        return $this.TypeTagImpl(mirror, tpec);
    }

    default public <T> TypeTag<T> TypeTagImpl(Mirror mirror, TypeCreator tpec) {
        return new TypeTagImpl((Universe)this, mirror, tpec);
    }

    public static /* synthetic */ WeakTypeTag weakTypeTag$(TypeTags $this, WeakTypeTag attag) {
        return $this.weakTypeTag(attag);
    }

    default public <T> WeakTypeTag<T> weakTypeTag(WeakTypeTag<T> attag) {
        return attag;
    }

    public static /* synthetic */ TypeTag typeTag$(TypeTags $this, TypeTag ttag) {
        return $this.typeTag(ttag);
    }

    default public <T> TypeTag<T> typeTag(TypeTag<T> ttag) {
        return ttag;
    }

    public static /* synthetic */ Types.TypeApi weakTypeOf$(TypeTags $this, WeakTypeTag attag) {
        return $this.weakTypeOf(attag);
    }

    default public <T> Types.TypeApi weakTypeOf(WeakTypeTag<T> attag) {
        return attag.tpe();
    }

    public static /* synthetic */ Types.TypeApi typeOf$(TypeTags $this, TypeTag ttag) {
        return $this.typeOf(ttag);
    }

    default public <T> Types.TypeApi typeOf(TypeTag<T> ttag) {
        return ttag.tpe();
    }

    public <T> Symbols.TypeSymbolApi symbolOf(WeakTypeTag<T> var1);

    public static void $init$(TypeTags $this) {
    }

    private class PredefTypeCreator<T>
    extends TypeCreator {
        private final Function1<Universe, TypeTag<T>> copyIn;
        public final /* synthetic */ Universe $outer;

        @Override
        public <U extends Universe> Types.TypeApi apply(Mirror<U> m) {
            return this.copyIn.apply((Universe)m.universe()).tpe();
        }

        public /* synthetic */ Universe scala$reflect$api$TypeTags$PredefTypeCreator$$$outer() {
            return this.$outer;
        }

        public PredefTypeCreator(Universe $outer, Function1<Universe, TypeTag<T>> copyIn) {
            this.copyIn = copyIn;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    private class PredefTypeTag<T>
    extends TypeTagImpl<T> {
        private Types.TypeApi tpe;
        private Types.TypeApi _tpe;
        private volatile boolean bitmap$0;

        private Types.TypeApi tpe$lzycompute() {
            synchronized (this) {
                if (!this.bitmap$0) {
                    this.tpe = this._tpe;
                    this.bitmap$0 = true;
                }
            }
            this._tpe = null;
            return this.tpe;
        }

        @Override
        public Types.TypeApi tpe() {
            if (!this.bitmap$0) {
                return this.tpe$lzycompute();
            }
            return this.tpe;
        }

        private Object writeReplace() throws ObjectStreamException {
            return new SerializedTypeTag(this.tpec(), true);
        }

        public /* synthetic */ Universe scala$reflect$api$TypeTags$PredefTypeTag$$$outer() {
            return this.$outer;
        }

        public PredefTypeTag(Universe $outer, Types.TypeApi _tpe, Function1<Universe, TypeTag<T>> copyIn) {
            this._tpe = _tpe;
            super($outer, $outer.rootMirror(), new scala.reflect.api.PredefTypeCreator<T>(copyIn));
        }
    }

    public interface TypeTag<T>
    extends WeakTypeTag<T> {
        @Override
        public <U extends Universe> TypeTag<T> in(Mirror<U> var1);

        @Override
        default public boolean canEqual(Object x) {
            return x instanceof TypeTag;
        }

        @Override
        default public boolean equals(Object x) {
            if (x instanceof TypeTag) {
                Mirror mirror = this.mirror();
                Mirror mirror2 = ((TypeTag)x).mirror();
                if (!(mirror != null ? !mirror.equals(mirror2) : mirror2 != null)) {
                    Types.TypeApi typeApi = this.tpe();
                    Types.TypeApi typeApi2 = ((TypeTag)x).tpe();
                    if (!(typeApi != null ? !typeApi.equals(typeApi2) : typeApi2 != null)) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        default public int hashCode() {
            return this.mirror().hashCode() * 31 + this.tpe().hashCode();
        }

        @Override
        default public String toString() {
            return new StringBuilder(9).append("TypeTag[").append(this.tpe()).append("]").toString();
        }

        public /* synthetic */ TypeTags scala$reflect$api$TypeTags$TypeTag$$$outer();

        public static void $init$(TypeTag $this) {
        }
    }

    private class TypeTagImpl<T>
    extends WeakTypeTagImpl<T>
    implements TypeTag<T> {
        @Override
        public boolean canEqual(Object x) {
            return ((TypeTag)this).canEqual(x);
        }

        @Override
        public boolean equals(Object x) {
            return ((TypeTag)this).equals(x);
        }

        @Override
        public int hashCode() {
            return ((TypeTag)this).hashCode();
        }

        @Override
        public String toString() {
            return ((TypeTag)this).toString();
        }

        @Override
        public <U extends Universe> TypeTag<T> in(Mirror<U> otherMirror) {
            return ((Universe)otherMirror.universe()).TypeTag().apply(otherMirror, super.tpec());
        }

        private Object writeReplace() throws ObjectStreamException {
            return new SerializedTypeTag(super.tpec(), true);
        }

        public /* synthetic */ Universe scala$reflect$api$TypeTags$TypeTagImpl$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ TypeTags scala$reflect$api$TypeTags$TypeTag$$$outer() {
            return this.scala$reflect$api$TypeTags$TypeTagImpl$$$outer();
        }

        public TypeTagImpl(Universe $outer, Mirror mirror, TypeCreator tpec) {
            super($outer, mirror, tpec);
            TypeTag.$init$(this);
        }
    }

    public interface WeakTypeTag<T>
    extends Equals,
    Serializable {
        public Mirror mirror();

        public <U extends Universe> WeakTypeTag<T> in(Mirror<U> var1);

        public Types.TypeApi tpe();

        @Override
        default public boolean canEqual(Object x) {
            return x instanceof WeakTypeTag;
        }

        @Override
        default public boolean equals(Object x) {
            if (x instanceof WeakTypeTag) {
                Mirror mirror = this.mirror();
                Mirror mirror2 = ((WeakTypeTag)x).mirror();
                if (!(mirror != null ? !mirror.equals(mirror2) : mirror2 != null)) {
                    Types.TypeApi typeApi = this.tpe();
                    Types.TypeApi typeApi2 = ((WeakTypeTag)x).tpe();
                    if (!(typeApi != null ? !typeApi.equals(typeApi2) : typeApi2 != null)) {
                        return true;
                    }
                }
            }
            return false;
        }

        default public int hashCode() {
            return this.mirror().hashCode() * 31 + this.tpe().hashCode();
        }

        default public String toString() {
            return new StringBuilder(13).append("WeakTypeTag[").append(this.tpe()).append("]").toString();
        }

        public /* synthetic */ TypeTags scala$reflect$api$TypeTags$WeakTypeTag$$$outer();

        public static void $init$(WeakTypeTag $this) {
        }
    }

    private class WeakTypeTagImpl<T>
    implements WeakTypeTag<T> {
        private Types.TypeApi tpe;
        private final Mirror mirror;
        private final TypeCreator tpec;
        private volatile boolean bitmap$0;
        public final /* synthetic */ Universe $outer;

        @Override
        public boolean canEqual(Object x) {
            return ((WeakTypeTag)this).canEqual(x);
        }

        @Override
        public boolean equals(Object x) {
            return ((WeakTypeTag)this).equals(x);
        }

        @Override
        public int hashCode() {
            return ((WeakTypeTag)this).hashCode();
        }

        @Override
        public String toString() {
            return ((WeakTypeTag)this).toString();
        }

        @Override
        public Mirror mirror() {
            return this.mirror;
        }

        public TypeCreator tpec() {
            return this.tpec;
        }

        private Types.TypeApi tpe$lzycompute() {
            synchronized (this) {
                if (!this.bitmap$0) {
                    this.tpe = this.tpec().apply(this.mirror());
                    this.bitmap$0 = true;
                }
            }
            return this.tpe;
        }

        @Override
        public Types.TypeApi tpe() {
            if (!this.bitmap$0) {
                return this.tpe$lzycompute();
            }
            return this.tpe;
        }

        @Override
        public <U extends Universe> WeakTypeTag<T> in(Mirror<U> otherMirror) {
            return ((Universe)otherMirror.universe()).WeakTypeTag().apply(otherMirror, this.tpec());
        }

        private Object writeReplace() throws ObjectStreamException {
            return new SerializedTypeTag(this.tpec(), false);
        }

        public /* synthetic */ Universe scala$reflect$api$TypeTags$WeakTypeTagImpl$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ TypeTags scala$reflect$api$TypeTags$WeakTypeTag$$$outer() {
            return this.scala$reflect$api$TypeTags$WeakTypeTagImpl$$$outer();
        }

        public WeakTypeTagImpl(Universe $outer, Mirror mirror, TypeCreator tpec) {
            this.mirror = mirror;
            this.tpec = tpec;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            WeakTypeTag.$init$(this);
        }
    }
}

