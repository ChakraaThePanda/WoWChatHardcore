/*
 * Decompiled with CFR 0.152.
 */
package scala.math;

import scala.math.BigDecimal;
import scala.math.BigDecimal$;
import scala.math.BigInt;
import scala.math.BigInt$;
import scala.math.Fractional;
import scala.math.Integral;
import scala.math.Ordering;
import scala.math.package$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0019\u001dr\u0001CA^\u0003{C\t!a2\u0007\u0011\u0005-\u0017Q\u0018E\u0001\u0003\u001bDq!!8\u0002\t\u0003\tyNB\u0005\u0002b\u0006\u0001\n1!\u0001\u0002d\"9\u0011Q]\u0002\u0005\u0002\u0005\u001d\bbBAx\u0007\u0011\r\u0011\u0011_\u0004\b\u0005'\f\u0001\u0012\u0001Bk\r\u001d\u0011I.\u0001E\u0001\u00057Dq!!8\b\t\u0003\u0011yNB\u0005\u0003b\u0006\u0001\n1!\u0001\u0003d\"9\u0011Q]\u0005\u0005\u0002\u0005\u001d\bb\u0002B\u0016\u0013\u0011\u0005!\u0011\u001f\u0005\b\u0005oIA\u0011\u0001B|\u0011\u001d\u0011y$\u0003C\u0001\u0005{Dqaa\u0001\n\t\u0003\u0019)\u0001C\u0004\u0004\f%!\ta!\u0004\t\u000f\t\u001d\u0013\u0002\"\u0001\u0004\u0014!9!QJ\u0005\u0005\u0002\r]\u0001b\u0002B-\u0013\u0011\u000511\u0004\u0005\b\u0005?JA\u0011AB\u0010\u0011\u001d\u0011Y'\u0003C\u0001\u0007GAqAa\u001e\n\t\u0003\u00199cB\u0004\u0004,\u0005A\u0019a!\f\u0007\u000f\t\u0005\u0018\u0001#\u0001\u00040!9\u0011Q\\\f\u0005\u0002\r\u0005\u0003\"CB\"/\u0005\u0005I\u0011BB#\r%\u00199%\u0001I\u0001\u0004\u0003\u0019I\u0005C\u0004\u0002fj!\t!a:\t\u000f\t-\"\u0004\"\u0001\u0004N!9!q\u0007\u000e\u0005\u0002\rM\u0003b\u0002B 5\u0011\u00051\u0011\f\u0005\b\u0007\u0007QB\u0011AB0\u0011\u001d\u0019YA\u0007C\u0001\u0007KBqAa\u0012\u001b\t\u0003\u0019Y\u0007C\u0004\u0003Ni!\taa\u001c\t\u000f\te#\u0004\"\u0001\u0004t!9!q\f\u000e\u0005\u0002\r]\u0004b\u0002B65\u0011\u000511\u0010\u0005\b\u0005oRB\u0011AB@\u000f\u001d\u0019\u0019)\u0001E\u0002\u0007\u000b3qaa\u0012\u0002\u0011\u0003\u00199\tC\u0004\u0002^\"\"\ta!%\t\u0013\r\r\u0003&!A\u0005\n\r\u0015c!CBJ\u0003A\u0005\u0019\u0011ABK\u0011\u001d\t)o\u000bC\u0001\u0003ODqAa\u000b,\t\u0003\u0019y\nC\u0004\u00038-\"\ta!*\t\u000f\t}2\u0006\"\u0001\u0004,\"911A\u0016\u0005\u0002\rE\u0006bBB\u0006W\u0011\u00051q\u0017\u0005\b\u0005\u000fZC\u0011AB_\u0011\u001d\u0011ie\u000bC\u0001\u0007\u0003DqA!\u0017,\t\u0003\u0019)\rC\u0004\u0003`-\"\ta!3\t\u000f\t-4\u0006\"\u0001\u0004N\"9!qO\u0016\u0005\u0002\rEwaBBk\u0003!\r1q\u001b\u0004\b\u0007'\u000b\u0001\u0012ABm\u0011\u001d\ti.\u000fC\u0001\u0007GD\u0011ba\u0011:\u0003\u0003%Ia!\u0012\u0007\u0013\r\u0015\u0018\u0001%A\u0002\u0002\r\u001d\bbBAsy\u0011\u0005\u0011q\u001d\u0005\b\u0005WaD\u0011ABy\u0011\u001d\u00119\u0004\u0010C\u0001\u0007oDqAa\u0010=\t\u0003\u0019i\u0010C\u0004\u0004\u0004q\"\t\u0001b\u0001\t\u000f\r-A\b\"\u0001\u0005\n!9!q\t\u001f\u0005\u0002\u0011=\u0001b\u0002B'y\u0011\u0005A1\u0003\u0005\b\u00053bD\u0011\u0001C\f\u0011\u001d\u0011y\u0006\u0010C\u0001\t7AqAa\u001b=\t\u0003!y\u0002C\u0004\u0003xq\"\t\u0001b\t\b\u000f\u0011\u001d\u0012\u0001c\u0001\u0005*\u001991Q]\u0001\t\u0002\u0011-\u0002bBAo\u0015\u0012\u0005AQ\u0007\u0005\n\u0007\u0007R\u0015\u0011!C\u0005\u0007\u000b2\u0011\u0002b\u000e\u0002!\u0003\r\t\u0001\"\u000f\t\u000f\u0005\u0015X\n\"\u0001\u0002h\"9!1F'\u0005\u0002\u0011\r\u0003b\u0002B\u001c\u001b\u0012\u0005A\u0011\n\u0005\b\u0005\u007fiE\u0011\u0001C(\u0011\u001d\u0019\u0019!\u0014C\u0001\t+Bqaa\u0003N\t\u0003!Y\u0006C\u0004\u0003H5#\t\u0001\"\u0019\t\u000f\t5S\n\"\u0001\u0005f!9!\u0011L'\u0005\u0002\u0011%\u0004b\u0002B0\u001b\u0012\u0005AQ\u000e\u0005\b\u0005WjE\u0011\u0001C9\u0011\u001d\u00119(\u0014C\u0001\tk:q\u0001\"\u001f\u0002\u0011\u0007!YHB\u0004\u00058\u0005A\t\u0001\" \t\u000f\u0005u7\f\"\u0001\u0005\b\"I11I.\u0002\u0002\u0013%1Q\t\u0004\n\t\u0013\u000b\u0001\u0013aA\u0001\t\u0017Cq!!:_\t\u0003\t9\u000fC\u0004\u0003,y#\t\u0001b$\t\u000f\t]b\f\"\u0001\u0005\u0016\"9!q\b0\u0005\u0002\u0011m\u0005bBB\u0002=\u0012\u0005A\u0011\u0015\u0005\b\u0007\u0017qF\u0011\u0001CT\u0011\u001d\u00119E\u0018C\u0001\t[CqA!\u0014_\t\u0003!\t\fC\u0004\u0003Zy#\t\u0001\".\t\u000f\t}c\f\"\u0001\u0005:\"9!1\u000e0\u0005\u0002\u0011u\u0006b\u0002B<=\u0012\u0005A\u0011Y\u0004\b\t\u000b\f\u00012\u0001Cd\r\u001d!I)\u0001E\u0001\t\u0013Dq!!8m\t\u0003!\u0019\u000eC\u0005\u0004D1\f\t\u0011\"\u0003\u0004F\u0019IAQ[\u0001\u0011\u0002\u0007\u0005Aq\u001b\u0005\b\u0003K|G\u0011AAt\u0011\u001d\u0011Yc\u001cC\u0001\t7DqAa\u000ep\t\u0003!\t\u000fC\u0004\u0003@=$\t\u0001b:\t\u000f\t\u001ds\u000e\"\u0001\u0005n\"9!QJ8\u0005\u0002\u0011E\bb\u0002B-_\u0012\u0005AQ\u001f\u0005\b\u0005?zG\u0011\u0001C}\u0011\u001d\u0011Yg\u001cC\u0001\t{DqAa\u001ep\t\u0003)\t\u0001C\u0004\u0003\n>$\t%\"\u0002\u0007\u0013\u0015%\u0011\u0001%A\u0002\u0002\u0015-\u0001bBAsw\u0012\u0005\u0011q\u001d\u0005\b\u000b+YH\u0011AC\f\r%)i\"\u0001I\u0001\u0004\u0003)y\u0002C\u0004\u0002fz$\t!a:\t\u000f\r\ra\u0010\"\u0001\u0006$!911\u0002@\u0005\u0002\u0015%raBC\u0018\u0003!\rQ\u0011\u0007\u0004\b\u000b\u0013\t\u0001\u0012AC\u001a\u0011!\ti.a\u0002\u0005\u0002\u0015u\u0002BCB\"\u0003\u000f\t\t\u0011\"\u0003\u0004F\u001d9QqH\u0001\t\u0002\u0015\u0005caBC\u000f\u0003!\u0005Q1\t\u0005\t\u0003;\fy\u0001\"\u0001\u0006H!Q11IA\b\u0003\u0003%Ia!\u0012\u0007\u0013\u0015%\u0013\u0001%A\u0002\u0002\u0015-\u0003\u0002CAs\u0003+!\t!a:\t\u0011\t-\u0012Q\u0003C\u0001\u000b\u001fB\u0001Ba\u000e\u0002\u0016\u0011\u0005QQ\u000b\u0005\t\u0005\u007f\t)\u0002\"\u0001\u0006\\!A!qIA\u000b\t\u0003)\t\u0007\u0003\u0005\u0003N\u0005UA\u0011AC3\u0011!\u0011I&!\u0006\u0005\u0002\u0015%\u0004\u0002\u0003B0\u0003+!\t!\"\u001c\t\u0011\t-\u0014Q\u0003C\u0001\u000bcB\u0001Ba\u001e\u0002\u0016\u0011\u0005QQ\u000f\u0005\t\u0005\u0013\u000b)\u0002\"\u0011\u0006z\u0019IQQP\u0001\u0011\u0002\u0007\u0005Qq\u0010\u0005\t\u0003K\fi\u0003\"\u0001\u0002h\"AQQCA\u0017\t\u0003))IB\u0005\u0006\f\u0006\u0001\n1!\u0001\u0006\u000e\"A\u0011Q]A\u001a\t\u0003\t9\u000f\u0003\u0005\u0004\u0004\u0005MB\u0011ACI\u0011!\u0019Y!a\r\u0005\u0002\u0015]e!CCO\u0003A\u0005\u0019\u0011ACP\u0011!\t)/a\u000f\u0005\u0002\u0005\u001d\b\u0002\u0003B\u0016\u0003w!\t!\"+\t\u0011\t]\u00121\bC\u0001\u000b_C\u0001Ba\u0010\u0002<\u0011\u0005QQ\u0017\u0005\t\u0005\u000f\nY\u0004\"\u0001\u0006<\"A!QJA\u001e\t\u0003)y\f\u0003\u0005\u0003Z\u0005mB\u0011ACb\u0011!\u0011y&a\u000f\u0005\u0002\u0015\u001d\u0007\u0002\u0003B6\u0003w!\t!b3\t\u0011\t]\u00141\bC\u0001\u000b\u001f4\u0011\"b5\u0002!\u0003\r\t!\"6\t\u0011\u0005\u0015\u0018\u0011\u000bC\u0001\u0003OD\u0001\"\"\u0006\u0002R\u0011\u0005Q1\u001c\u0004\n\u000bC\f\u0001\u0013aA\u0001\u000bGD\u0001\"!:\u0002X\u0011\u0005\u0011q\u001d\u0005\t\u0007\u0007\t9\u0006\"\u0001\u0006h\"A11BA,\t\u0003)ioB\u0004\u0006t\u0006A\u0019!\">\u0007\u000f\u0015M\u0017\u0001#\u0001\u0006x\"A\u0011Q\\A1\t\u00031\t\u0001\u0003\u0006\u0004D\u0005\u0005\u0014\u0011!C\u0005\u0007\u000b:qAb\u0001\u0002\u0011\u00031)AB\u0004\u0006b\u0006A\tAb\u0002\t\u0011\u0005u\u0017\u0011\u000eC\u0001\r\u0017A!ba\u0011\u0002j\u0005\u0005I\u0011BB#\u000f\u001d1i!\u0001E\u0002\r\u001f1q!\" \u0002\u0011\u00031\t\u0002\u0003\u0005\u0002^\u0006ED\u0011\u0001D\u000e\u0011)\u0019\u0019%!\u001d\u0002\u0002\u0013%1QI\u0004\b\r;\t\u0001\u0012\u0001D\u0010\r\u001d)Y)\u0001E\u0001\rCA\u0001\"!8\u0002z\u0011\u0005aQ\u0005\u0005\u000b\u0007\u0007\nI(!A\u0005\n\r\u0015\u0003\"CB\"\u0003\u0005\u0005I\u0011BB#\r)\tY-!0\u0011\u0002\u0007\u0005\u00111 \u0005\t\u0003K\f\t\t\"\u0001\u0002h\"A!1FAA\r\u0003\u0011i\u0003\u0003\u0005\u00038\u0005\u0005e\u0011\u0001B\u001d\u0011!\u0011y$!!\u0007\u0002\t\u0005\u0003\u0002\u0003B$\u0003\u00033\tA!\u0013\t\u0011\t5\u0013\u0011\u0011D\u0001\u0005\u001fB\u0001B!\u0017\u0002\u0002\u001a\u0005!1\f\u0005\t\u0005?\n\tI\"\u0001\u0003b!A!1NAA\r\u0003\u0011i\u0007\u0003\u0005\u0003x\u0005\u0005e\u0011\u0001B=\u0011!\u0011\u0019)!!\u0005\u0002\t\u0015\u0005\u0002\u0003BD\u0003\u0003#\tA!\"\t\u0011\t%\u0015\u0011\u0011C\u0001\u0005\u0017C\u0001Ba$\u0002\u0002\u0012\u0005!\u0011\u0013\u0004\b\u0005+\u000b\t\t\u0001BL\u0011-\u0011I*a(\u0003\u0002\u0003\u0006IA!\u0006\t\u0011\u0005u\u0017q\u0014C\u0001\u00057C\u0001Ba)\u0002 \u0012\u0005!Q\u0015\u0005\t\u0005W\u000by\n\"\u0001\u0003.\"A!\u0011WAP\t\u0003\u0011\u0019\f\u0003\u0005\u00038\u0006}E\u0011\u0001B]\u0011!\u0011I)a(\u0005\u0002\te\u0006\u0002\u0003BH\u0003?#\tAa/\t\u0011\te\u0013q\u0014C\u0001\u0005wC\u0001Ba\u0018\u0002 \u0012\u0005!Q\u0018\u0005\t\u0005W\ny\n\"\u0001\u0003@\"A!qOAP\t\u0003\u0011\t\r\u0003\u0005\u0003D\u0006\u0005E1\u0001Bc\u0003\u001dqU/\\3sS\u000eTA!a0\u0002B\u0006!Q.\u0019;i\u0015\t\t\u0019-A\u0003tG\u0006d\u0017m\u0001\u0001\u0011\u0007\u0005%\u0017!\u0004\u0002\u0002>\n9a*^7fe&\u001c7#B\u0001\u0002P\u0006]\u0007\u0003BAi\u0003'l!!!1\n\t\u0005U\u0017\u0011\u0019\u0002\u0007\u0003:L(+\u001a4\u0011\t\u0005E\u0017\u0011\\\u0005\u0005\u00037\f\tM\u0001\u0007TKJL\u0017\r\\5{C\ndW-\u0001\u0004=S:LGO\u0010\u000b\u0003\u0003\u000f\u0014a\"\u0012=ue\u0006LU\u000e\u001d7jG&$8oE\u0002\u0004\u0003\u001f\fa\u0001J5oSR$CCAAu!\u0011\t\t.a;\n\t\u00055\u0018\u0011\u0019\u0002\u0005+:LG/A\bj]\u001aL\u0007PT;nKJL7m\u00149t+\u0011\t\u0019Pa3\u0015\t\u0005U(\u0011\u001b\u000b\u0005\u0003o\u0014i\r\u0005\u0003\u0002z\u0006}\u0005CBAe\u0003\u0003\u0013I-\u0006\u0003\u0002~\ne1CBAA\u0003\u007f\u0014y\u0001\u0005\u0003\u0003\u0002\t-QB\u0001B\u0002\u0015\u0011\u0011)Aa\u0002\u0002\t1\fgn\u001a\u0006\u0003\u0005\u0013\tAA[1wC&!!Q\u0002B\u0002\u0005\u0019y%M[3diB1\u0011\u0011\u001aB\t\u0005+IAAa\u0005\u0002>\nAqJ\u001d3fe&tw\r\u0005\u0003\u0003\u0018\teA\u0002\u0001\u0003\t\u00057\t\tI1\u0001\u0003\u001e\t\tA+\u0005\u0003\u0003 \t\u0015\u0002\u0003BAi\u0005CIAAa\t\u0002B\n9aj\u001c;iS:<\u0007\u0003BAi\u0005OIAA!\u000b\u0002B\n\u0019\u0011I\\=\u0002\tAdWo\u001d\u000b\u0007\u0005+\u0011yCa\r\t\u0011\tE\u0012Q\u0011a\u0001\u0005+\t\u0011\u0001\u001f\u0005\t\u0005k\t)\t1\u0001\u0003\u0016\u0005\t\u00110A\u0003nS:,8\u000f\u0006\u0004\u0003\u0016\tm\"Q\b\u0005\t\u0005c\t9\t1\u0001\u0003\u0016!A!QGAD\u0001\u0004\u0011)\"A\u0003uS6,7\u000f\u0006\u0004\u0003\u0016\t\r#Q\t\u0005\t\u0005c\tI\t1\u0001\u0003\u0016!A!QGAE\u0001\u0004\u0011)\"\u0001\u0004oK\u001e\fG/\u001a\u000b\u0005\u0005+\u0011Y\u0005\u0003\u0005\u00032\u0005-\u0005\u0019\u0001B\u000b\u0003\u001d1'o\\7J]R$BA!\u0006\u0003R!A!\u0011GAG\u0001\u0004\u0011\u0019\u0006\u0005\u0003\u0002R\nU\u0013\u0002\u0002B,\u0003\u0003\u00141!\u00138u\u0003\u0015!x.\u00138u)\u0011\u0011\u0019F!\u0018\t\u0011\tE\u0012q\u0012a\u0001\u0005+\ta\u0001^8M_:<G\u0003\u0002B2\u0005S\u0002B!!5\u0003f%!!qMAa\u0005\u0011auN\\4\t\u0011\tE\u0012\u0011\u0013a\u0001\u0005+\tq\u0001^8GY>\fG\u000f\u0006\u0003\u0003p\tU\u0004\u0003BAi\u0005cJAAa\u001d\u0002B\n)a\t\\8bi\"A!\u0011GAJ\u0001\u0004\u0011)\"\u0001\u0005u_\u0012{WO\u00197f)\u0011\u0011YH!!\u0011\t\u0005E'QP\u0005\u0005\u0005\u007f\n\tM\u0001\u0004E_V\u0014G.\u001a\u0005\t\u0005c\t)\n1\u0001\u0003\u0016\u0005!!0\u001a:p+\t\u0011)\"A\u0002p]\u0016\f1!\u00192t)\u0011\u0011)B!$\t\u0011\tE\u00121\u0014a\u0001\u0005+\taa]5h]VlG\u0003\u0002B*\u0005'C\u0001B!\r\u0002\u001e\u0002\u0007!Q\u0003\u0002\u0004\u001fB\u001c8\u0003BAP\u0003\u001f\f1\u0001\u001c5t)\u0011\u0011iJ!)\u0011\t\t}\u0015qT\u0007\u0003\u0003\u0003C\u0001B!'\u0002$\u0002\u0007!QC\u0001\u0006IAdWo\u001d\u000b\u0005\u0005+\u00119\u000b\u0003\u0005\u0003*\u0006\u0015\u0006\u0019\u0001B\u000b\u0003\r\u0011\bn]\u0001\u0007I5Lg.^:\u0015\t\tU!q\u0016\u0005\t\u0005S\u000b9\u000b1\u0001\u0003\u0016\u00051A\u0005^5nKN$BA!\u0006\u00036\"A!\u0011VAU\u0001\u0004\u0011)\"\u0001\u0007v]\u0006\u0014\u0018p\u0018\u0013nS:,8\u000f\u0006\u0002\u0003\u0016Q\u0011!1\u000b\u000b\u0003\u0005G\"\"Aa\u001c\u0015\u0005\tm\u0014\u0001D7l\u001dVlWM]5d\u001fB\u001cH\u0003\u0002BO\u0005\u000fD\u0001B!'\u0002:\u0002\u0007!Q\u0003\t\u0005\u0005/\u0011Y\rB\u0004\u0003\u001c\u0015\u0011\rA!\b\t\u000f\t=W\u0001q\u0001\u0002z\u0006\u0019a.^7\t\u000f\tER\u00011\u0001\u0003J\u0006I\u0011*\u001c9mS\u000eLGo\u001d\t\u0004\u0005/<Q\"A\u0001\u0003\u0013%k\u0007\u000f\\5dSR\u001c8#B\u0004\u0002P\nu\u0007c\u0001Bl\u0007Q\u0011!Q\u001b\u0002\u0011\u0005&<\u0017J\u001c;Jg&sG/Z4sC2\u001cR!CA\u0000\u0005K\u0004b!!3\u0003h\n-\u0018\u0002\u0002Bu\u0003{\u0013\u0001\"\u00138uK\u001e\u0014\u0018\r\u001c\t\u0005\u0003\u0013\u0014i/\u0003\u0003\u0003p\u0006u&A\u0002\"jO&sG\u000f\u0006\u0004\u0003l\nM(Q\u001f\u0005\b\u0005cY\u0001\u0019\u0001Bv\u0011\u001d\u0011)d\u0003a\u0001\u0005W$bAa;\u0003z\nm\bb\u0002B\u0019\u0019\u0001\u0007!1\u001e\u0005\b\u0005ka\u0001\u0019\u0001Bv)\u0019\u0011YOa@\u0004\u0002!9!\u0011G\u0007A\u0002\t-\bb\u0002B\u001b\u001b\u0001\u0007!1^\u0001\u0005cV|G\u000f\u0006\u0004\u0003l\u000e\u001d1\u0011\u0002\u0005\b\u0005cq\u0001\u0019\u0001Bv\u0011\u001d\u0011)D\u0004a\u0001\u0005W\f1A]3n)\u0019\u0011Yoa\u0004\u0004\u0012!9!\u0011G\bA\u0002\t-\bb\u0002B\u001b\u001f\u0001\u0007!1\u001e\u000b\u0005\u0005W\u001c)\u0002C\u0004\u00032A\u0001\rAa;\u0015\t\t-8\u0011\u0004\u0005\b\u0005c\t\u0002\u0019\u0001B*)\u0011\u0011\u0019f!\b\t\u000f\tE\"\u00031\u0001\u0003lR!!1MB\u0011\u0011\u001d\u0011\td\u0005a\u0001\u0005W$BAa\u001c\u0004&!9!\u0011\u0007\u000bA\u0002\t-H\u0003\u0002B>\u0007SAqA!\r\u0016\u0001\u0004\u0011Y/\u0001\tCS\u001eLe\u000e^%t\u0013:$Xm\u001a:bYB\u0019!q[\f\u0014\u000f]\typ!\r\u00044A\u0019!q[\u0005\u0011\t\rU21\b\b\u0005\u0003\u0013\u001c9$\u0003\u0003\u0004:\u0005u\u0016\u0001C(sI\u0016\u0014\u0018N\\4\n\t\ru2q\b\u0002\u000f\u0005&<\u0017J\u001c;Pe\u0012,'/\u001b8h\u0015\u0011\u0019I$!0\u0015\u0005\r5\u0012a\u0003:fC\u0012\u0014Vm]8mm\u0016$\"!a@\u0003\u001b%sG/S:J]R,wM]1m'\u0015Q\u0012q`B&!\u0019\tIMa:\u0003TQ1!1KB(\u0007#BqA!\r\u001d\u0001\u0004\u0011\u0019\u0006C\u0004\u00036q\u0001\rAa\u0015\u0015\r\tM3QKB,\u0011\u001d\u0011\t$\ba\u0001\u0005'BqA!\u000e\u001e\u0001\u0004\u0011\u0019\u0006\u0006\u0004\u0003T\rm3Q\f\u0005\b\u0005cq\u0002\u0019\u0001B*\u0011\u001d\u0011)D\ba\u0001\u0005'\"bAa\u0015\u0004b\r\r\u0004b\u0002B\u0019?\u0001\u0007!1\u000b\u0005\b\u0005ky\u0002\u0019\u0001B*)\u0019\u0011\u0019fa\u001a\u0004j!9!\u0011\u0007\u0011A\u0002\tM\u0003b\u0002B\u001bA\u0001\u0007!1\u000b\u000b\u0005\u0005'\u001ai\u0007C\u0004\u00032\u0005\u0002\rAa\u0015\u0015\t\tM3\u0011\u000f\u0005\b\u0005c\u0011\u0003\u0019\u0001B*)\u0011\u0011\u0019f!\u001e\t\u000f\tE2\u00051\u0001\u0003TQ!!1MB=\u0011\u001d\u0011\t\u0004\na\u0001\u0005'\"BAa\u001c\u0004~!9!\u0011G\u0013A\u0002\tMC\u0003\u0002B>\u0007\u0003CqA!\r'\u0001\u0004\u0011\u0019&A\u0007J]RL5/\u00138uK\u001e\u0014\u0018\r\u001c\t\u0004\u0005/D3c\u0002\u0015\u0002\u0000\u000e%51\u0012\t\u0004\u0005/T\u0002\u0003BB\u001b\u0007\u001bKAaa$\u0004@\tY\u0011J\u001c;Pe\u0012,'/\u001b8h)\t\u0019)IA\bTQ>\u0014H/S:J]R,wM]1m'\u0015Y\u0013q`BL!\u0019\tIMa:\u0004\u001aB!\u0011\u0011[BN\u0013\u0011\u0019i*!1\u0003\u000bMCwN\u001d;\u0015\r\re5\u0011UBR\u0011\u001d\u0011\t$\fa\u0001\u00073CqA!\u000e.\u0001\u0004\u0019I\n\u0006\u0004\u0004\u001a\u000e\u001d6\u0011\u0016\u0005\b\u0005cq\u0003\u0019ABM\u0011\u001d\u0011)D\fa\u0001\u00073#ba!'\u0004.\u000e=\u0006b\u0002B\u0019_\u0001\u00071\u0011\u0014\u0005\b\u0005ky\u0003\u0019ABM)\u0019\u0019Ija-\u00046\"9!\u0011\u0007\u0019A\u0002\re\u0005b\u0002B\u001ba\u0001\u00071\u0011\u0014\u000b\u0007\u00073\u001bIla/\t\u000f\tE\u0012\u00071\u0001\u0004\u001a\"9!QG\u0019A\u0002\reE\u0003BBM\u0007\u007fCqA!\r3\u0001\u0004\u0019I\n\u0006\u0003\u0004\u001a\u000e\r\u0007b\u0002B\u0019g\u0001\u0007!1\u000b\u000b\u0005\u0005'\u001a9\rC\u0004\u00032Q\u0002\ra!'\u0015\t\t\r41\u001a\u0005\b\u0005c)\u0004\u0019ABM)\u0011\u0011yga4\t\u000f\tEb\u00071\u0001\u0004\u001aR!!1PBj\u0011\u001d\u0011\td\u000ea\u0001\u00073\u000bqb\u00155peRL5/\u00138uK\u001e\u0014\u0018\r\u001c\t\u0004\u0005/L4cB\u001d\u0002\u0000\u000em7Q\u001c\t\u0004\u0005/\\\u0003\u0003BB\u001b\u0007?LAa!9\u0004@\ti1\u000b[8si>\u0013H-\u001a:j]\u001e$\"aa6\u0003\u001d\tKH/Z%t\u0013:$Xm\u001a:bYN)A(a@\u0004jB1\u0011\u0011\u001aBt\u0007W\u0004B!!5\u0004n&!1q^Aa\u0005\u0011\u0011\u0015\u0010^3\u0015\r\r-81_B{\u0011\u001d\u0011\tD\u0010a\u0001\u0007WDqA!\u000e?\u0001\u0004\u0019Y\u000f\u0006\u0004\u0004l\u000ee81 \u0005\b\u0005cy\u0004\u0019ABv\u0011\u001d\u0011)d\u0010a\u0001\u0007W$baa;\u0004\u0000\u0012\u0005\u0001b\u0002B\u0019\u0001\u0002\u000711\u001e\u0005\b\u0005k\u0001\u0005\u0019ABv)\u0019\u0019Y\u000f\"\u0002\u0005\b!9!\u0011G!A\u0002\r-\bb\u0002B\u001b\u0003\u0002\u000711\u001e\u000b\u0007\u0007W$Y\u0001\"\u0004\t\u000f\tE\"\t1\u0001\u0004l\"9!Q\u0007\"A\u0002\r-H\u0003BBv\t#AqA!\rD\u0001\u0004\u0019Y\u000f\u0006\u0003\u0004l\u0012U\u0001b\u0002B\u0019\t\u0002\u0007!1\u000b\u000b\u0005\u0005'\"I\u0002C\u0004\u00032\u0015\u0003\raa;\u0015\t\t\rDQ\u0004\u0005\b\u0005c1\u0005\u0019ABv)\u0011\u0011y\u0007\"\t\t\u000f\tEr\t1\u0001\u0004lR!!1\u0010C\u0013\u0011\u001d\u0011\t\u0004\u0013a\u0001\u0007W\faBQ=uK&\u001b\u0018J\u001c;fOJ\fG\u000eE\u0002\u0003X*\u001brASA\u0000\t[!y\u0003E\u0002\u0003Xr\u0002Ba!\u000e\u00052%!A1GB \u00051\u0011\u0015\u0010^3Pe\u0012,'/\u001b8h)\t!IC\u0001\bDQ\u0006\u0014\u0018j]%oi\u0016<'/\u00197\u0014\u000b5\u000by\u0010b\u000f\u0011\r\u0005%'q\u001dC\u001f!\u0011\t\t\u000eb\u0010\n\t\u0011\u0005\u0013\u0011\u0019\u0002\u0005\u0007\"\f'\u000f\u0006\u0004\u0005>\u0011\u0015Cq\t\u0005\b\u0005cy\u0005\u0019\u0001C\u001f\u0011\u001d\u0011)d\u0014a\u0001\t{!b\u0001\"\u0010\u0005L\u00115\u0003b\u0002B\u0019!\u0002\u0007AQ\b\u0005\b\u0005k\u0001\u0006\u0019\u0001C\u001f)\u0019!i\u0004\"\u0015\u0005T!9!\u0011G)A\u0002\u0011u\u0002b\u0002B\u001b#\u0002\u0007AQ\b\u000b\u0007\t{!9\u0006\"\u0017\t\u000f\tE\"\u000b1\u0001\u0005>!9!Q\u0007*A\u0002\u0011uBC\u0002C\u001f\t;\"y\u0006C\u0004\u00032M\u0003\r\u0001\"\u0010\t\u000f\tU2\u000b1\u0001\u0005>Q!AQ\bC2\u0011\u001d\u0011\t\u0004\u0016a\u0001\t{!B\u0001\"\u0010\u0005h!9!\u0011G+A\u0002\tMC\u0003\u0002B*\tWBqA!\rW\u0001\u0004!i\u0004\u0006\u0003\u0003d\u0011=\u0004b\u0002B\u0019/\u0002\u0007AQ\b\u000b\u0005\u0005_\"\u0019\bC\u0004\u00032a\u0003\r\u0001\"\u0010\u0015\t\tmDq\u000f\u0005\b\u0005cI\u0006\u0019\u0001C\u001f\u00039\u0019\u0005.\u0019:Jg&sG/Z4sC2\u00042Aa6\\'\u001dY\u0016q C@\t\u0003\u00032Aa6N!\u0011\u0019)\u0004b!\n\t\u0011\u00155q\b\u0002\r\u0007\"\f'o\u0014:eKJLgn\u001a\u000b\u0003\tw\u0012a\u0002T8oO&\u001b\u0018J\u001c;fOJ\fGnE\u0003_\u0003\u007f$i\t\u0005\u0004\u0002J\n\u001d(1\r\u000b\u0007\u0005G\"\t\nb%\t\u000f\tE\u0002\r1\u0001\u0003d!9!Q\u00071A\u0002\t\rDC\u0002B2\t/#I\nC\u0004\u00032\u0005\u0004\rAa\u0019\t\u000f\tU\u0012\r1\u0001\u0003dQ1!1\rCO\t?CqA!\rc\u0001\u0004\u0011\u0019\u0007C\u0004\u00036\t\u0004\rAa\u0019\u0015\r\t\rD1\u0015CS\u0011\u001d\u0011\td\u0019a\u0001\u0005GBqA!\u000ed\u0001\u0004\u0011\u0019\u0007\u0006\u0004\u0003d\u0011%F1\u0016\u0005\b\u0005c!\u0007\u0019\u0001B2\u0011\u001d\u0011)\u0004\u001aa\u0001\u0005G\"BAa\u0019\u00050\"9!\u0011G3A\u0002\t\rD\u0003\u0002B2\tgCqA!\rg\u0001\u0004\u0011\u0019\u0006\u0006\u0003\u0003T\u0011]\u0006b\u0002B\u0019O\u0002\u0007!1\r\u000b\u0005\u0005G\"Y\fC\u0004\u00032!\u0004\rAa\u0019\u0015\t\t=Dq\u0018\u0005\b\u0005cI\u0007\u0019\u0001B2)\u0011\u0011Y\bb1\t\u000f\tE\"\u000e1\u0001\u0003d\u0005qAj\u001c8h\u0013NLe\u000e^3he\u0006d\u0007c\u0001BlYN9A.a@\u0005L\u00125\u0007c\u0001Bl=B!1Q\u0007Ch\u0013\u0011!\tna\u0010\u0003\u00191{gnZ(sI\u0016\u0014\u0018N\\4\u0015\u0005\u0011\u001d'!\u0005$m_\u0006$\u0018j]\"p]\u001ad\u0017n\u0019;fIN)q.a@\u0005ZB1\u0011\u0011ZAA\u0005_\"bAa\u001c\u0005^\u0012}\u0007b\u0002B\u0019c\u0002\u0007!q\u000e\u0005\b\u0005k\t\b\u0019\u0001B8)\u0019\u0011y\u0007b9\u0005f\"9!\u0011\u0007:A\u0002\t=\u0004b\u0002B\u001be\u0002\u0007!q\u000e\u000b\u0007\u0005_\"I\u000fb;\t\u000f\tE2\u000f1\u0001\u0003p!9!QG:A\u0002\t=D\u0003\u0002B8\t_DqA!\ru\u0001\u0004\u0011y\u0007\u0006\u0003\u0003p\u0011M\bb\u0002B\u0019k\u0002\u0007!1\u000b\u000b\u0005\u0005'\"9\u0010C\u0004\u00032Y\u0004\rAa\u001c\u0015\t\t\rD1 \u0005\b\u0005c9\b\u0019\u0001B8)\u0011\u0011y\u0007b@\t\u000f\tE\u0002\u00101\u0001\u0003pQ!!1PC\u0002\u0011\u001d\u0011\t$\u001fa\u0001\u0005_\"BAa\u001c\u0006\b!9!\u0011\u0007>A\u0002\t=$!\u0005$m_\u0006$\u0018j\u001d$sC\u000e$\u0018n\u001c8bYN910a@\u0006\u000e\u0015=\u0001c\u0001Bl_B1\u0011\u0011ZC\t\u0005_JA!b\u0005\u0002>\nQaI]1di&|g.\u00197\u0002\u0007\u0011Lg\u000f\u0006\u0004\u0003p\u0015eQ1\u0004\u0005\b\u0005ci\b\u0019\u0001B8\u0011\u001d\u0011)$ a\u0001\u0005_\u0012\u0011C\u00127pCR\f5/\u00134J]R,wM]1m'\u001dq\u0018q`C\u0007\u000bC\u0001b!!3\u0003h\n=DC\u0002B8\u000bK)9\u0003\u0003\u0005\u00032\u0005\u0005\u0001\u0019\u0001B8\u0011!\u0011)$!\u0001A\u0002\t=DC\u0002B8\u000bW)i\u0003\u0003\u0005\u00032\u0005\r\u0001\u0019\u0001B8\u0011!\u0011)$a\u0001A\u0002\t=\u0014!\u0005$m_\u0006$\u0018j\u001d$sC\u000e$\u0018n\u001c8bYB!!q[A\u0004'!\t9!a@\u00066\u0015]\u0002c\u0001BlwB!1QGC\u001d\u0013\u0011)Yda\u0010\u0003\u001b\u0019cw.\u0019;Pe\u0012,'/\u001b8h)\t)\t$A\tGY>\fG/Q:JM&sG/Z4sC2\u0004BAa6\u0002\u0010MA\u0011qBA\u0000\u000b\u000b*9\u0004E\u0002\u0003Xz$\"!\"\u0011\u0003%\u0011{WO\u00197f\u0013N\u001cuN\u001c4mS\u000e$X\rZ\n\u0007\u0003+\ty0\"\u0014\u0011\r\u0005%\u0017\u0011\u0011B>)\u0019\u0011Y(\"\u0015\u0006T!A!\u0011GA\r\u0001\u0004\u0011Y\b\u0003\u0005\u00036\u0005e\u0001\u0019\u0001B>)\u0019\u0011Y(b\u0016\u0006Z!A!\u0011GA\u000e\u0001\u0004\u0011Y\b\u0003\u0005\u00036\u0005m\u0001\u0019\u0001B>)\u0019\u0011Y(\"\u0018\u0006`!A!\u0011GA\u000f\u0001\u0004\u0011Y\b\u0003\u0005\u00036\u0005u\u0001\u0019\u0001B>)\u0011\u0011Y(b\u0019\t\u0011\tE\u0012q\u0004a\u0001\u0005w\"BAa\u001f\u0006h!A!\u0011GA\u0011\u0001\u0004\u0011\u0019\u0006\u0006\u0003\u0003T\u0015-\u0004\u0002\u0003B\u0019\u0003G\u0001\rAa\u001f\u0015\t\t\rTq\u000e\u0005\t\u0005c\t)\u00031\u0001\u0003|Q!!qNC:\u0011!\u0011\t$a\nA\u0002\tmD\u0003\u0002B>\u000boB\u0001B!\r\u0002*\u0001\u0007!1\u0010\u000b\u0005\u0005w*Y\b\u0003\u0005\u00032\u0005-\u0002\u0019\u0001B>\u0005I!u.\u001e2mK&\u001bhI]1di&|g.\u00197\u0014\u0011\u00055\u0012q`CA\u000b\u0007\u0003BAa6\u0002\u0016A1\u0011\u0011ZC\t\u0005w\"bAa\u001f\u0006\b\u0016%\u0005\u0002\u0003B\u0019\u0003c\u0001\rAa\u001f\t\u0011\tU\u0012\u0011\u0007a\u0001\u0005w\u0012!\u0003R8vE2,\u0017i]%g\u0013:$Xm\u001a:bYNA\u00111GA\u0000\u000b\u0003+y\t\u0005\u0004\u0002J\n\u001d(1\u0010\u000b\u0007\u0005w*\u0019*\"&\t\u0011\tE\u0012q\u0007a\u0001\u0005wB\u0001B!\u000e\u00028\u0001\u0007!1\u0010\u000b\u0007\u0005w*I*b'\t\u0011\tE\u0012\u0011\ba\u0001\u0005wB\u0001B!\u000e\u0002:\u0001\u0007!1\u0010\u0002\u0017\u0005&<G)Z2j[\u0006d\u0017j]\"p]\u001ad\u0017n\u0019;fIN1\u00111HA\u0000\u000bC\u0003b!!3\u0002\u0002\u0016\r\u0006\u0003BAe\u000bKKA!b*\u0002>\nQ!)[4EK\u000eLW.\u00197\u0015\r\u0015\rV1VCW\u0011!\u0011\t$a\u0010A\u0002\u0015\r\u0006\u0002\u0003B\u001b\u0003\u007f\u0001\r!b)\u0015\r\u0015\rV\u0011WCZ\u0011!\u0011\t$!\u0011A\u0002\u0015\r\u0006\u0002\u0003B\u001b\u0003\u0003\u0002\r!b)\u0015\r\u0015\rVqWC]\u0011!\u0011\t$a\u0011A\u0002\u0015\r\u0006\u0002\u0003B\u001b\u0003\u0007\u0002\r!b)\u0015\t\u0015\rVQ\u0018\u0005\t\u0005c\t)\u00051\u0001\u0006$R!Q1UCa\u0011!\u0011\t$a\u0012A\u0002\tMC\u0003\u0002B*\u000b\u000bD\u0001B!\r\u0002J\u0001\u0007Q1\u0015\u000b\u0005\u0005G*I\r\u0003\u0005\u00032\u0005-\u0003\u0019ACR)\u0011\u0011y'\"4\t\u0011\tE\u0012Q\na\u0001\u000bG#BAa\u001f\u0006R\"A!\u0011GA(\u0001\u0004)\u0019K\u0001\fCS\u001e$UmY5nC2L5O\u0012:bGRLwN\\1m'!\t\t&a@\u0006X\u0016e\u0007\u0003\u0002Bl\u0003w\u0001b!!3\u0006\u0012\u0015\rFCBCR\u000b;,y\u000e\u0003\u0005\u00032\u0005U\u0003\u0019ACR\u0011!\u0011)$!\u0016A\u0002\u0015\r&A\u0006\"jO\u0012+7-[7bY\u0006\u001b\u0018JZ%oi\u0016<'/\u00197\u0014\u0011\u0005]\u0013q`Cl\u000bK\u0004b!!3\u0003h\u0016\rFCBCR\u000bS,Y\u000f\u0003\u0005\u00032\u0005m\u0003\u0019ACR\u0011!\u0011)$a\u0017A\u0002\u0015\rFCBCR\u000b_,\t\u0010\u0003\u0005\u00032\u0005u\u0003\u0019ACR\u0011!\u0011)$!\u0018A\u0002\u0015\r\u0016A\u0006\"jO\u0012+7-[7bY&\u001bhI]1di&|g.\u00197\u0011\t\t]\u0017\u0011M\n\t\u0003C\ny0\"?\u0006|B!!q[A)!\u0011\u0019)$\"@\n\t\u0015}8q\b\u0002\u0013\u0005&<G)Z2j[\u0006dwJ\u001d3fe&tw\r\u0006\u0002\u0006v\u00061\")[4EK\u000eLW.\u00197Bg&3\u0017J\u001c;fOJ\fG\u000e\u0005\u0003\u0003X\u0006%4\u0003CA5\u0003\u007f4I!b?\u0011\t\t]\u0017q\u000b\u000b\u0003\r\u000b\t!\u0003R8vE2,\u0017j\u001d$sC\u000e$\u0018n\u001c8bYB!!q[A9'!\t\t(a@\u0007\u0014\u0019U\u0001\u0003\u0002Bl\u0003[\u0001Ba!\u000e\u0007\u0018%!a\u0011DB \u00059!u.\u001e2mK>\u0013H-\u001a:j]\u001e$\"Ab\u0004\u0002%\u0011{WO\u00197f\u0003NLe-\u00138uK\u001e\u0014\u0018\r\u001c\t\u0005\u0005/\fIh\u0005\u0005\u0002z\u0005}h1\u0005D\u000b!\u0011\u00119.a\r\u0015\u0005\u0019}\u0001")
public interface Numeric<T>
extends Ordering<T> {
    public T plus(T var1, T var2);

    public T minus(T var1, T var2);

    public T times(T var1, T var2);

    public T negate(T var1);

    public T fromInt(int var1);

    public int toInt(T var1);

    public long toLong(T var1);

    public float toFloat(T var1);

    public double toDouble(T var1);

    public static /* synthetic */ Object zero$(Numeric $this) {
        return $this.zero();
    }

    default public T zero() {
        return this.fromInt(0);
    }

    public static /* synthetic */ Object one$(Numeric $this) {
        return $this.one();
    }

    default public T one() {
        return this.fromInt(1);
    }

    public static /* synthetic */ Object abs$(Numeric $this, Object x) {
        return $this.abs(x);
    }

    default public T abs(T x) {
        if (this.lt(x, this.zero())) {
            return this.negate(x);
        }
        return x;
    }

    public static /* synthetic */ int signum$(Numeric $this, Object x) {
        return $this.signum(x);
    }

    default public int signum(T x) {
        if (this.lt(x, this.zero())) {
            return -1;
        }
        if (this.gt(x, this.zero())) {
            return 1;
        }
        return 0;
    }

    public static /* synthetic */ Ops mkNumericOps$(Numeric $this, Object lhs) {
        return $this.mkNumericOps(lhs);
    }

    default public Ops mkNumericOps(T lhs) {
        return new Ops(this, lhs);
    }

    public static void $init$(Numeric $this) {
    }

    public static interface BigDecimalAsIfIntegral
    extends BigDecimalIsConflicted,
    Integral<BigDecimal> {
        public static /* synthetic */ BigDecimal quot$(BigDecimalAsIfIntegral $this, BigDecimal x, BigDecimal y) {
            return $this.quot(x, y);
        }

        @Override
        default public BigDecimal quot(BigDecimal x, BigDecimal y) {
            return x.quot(y);
        }

        public static /* synthetic */ BigDecimal rem$(BigDecimalAsIfIntegral $this, BigDecimal x, BigDecimal y) {
            return $this.rem(x, y);
        }

        @Override
        default public BigDecimal rem(BigDecimal x, BigDecimal y) {
            return x.remainder(y);
        }

        public static void $init$(BigDecimalAsIfIntegral $this) {
        }
    }

    public static interface BigDecimalIsConflicted
    extends Numeric<BigDecimal> {
        public static /* synthetic */ BigDecimal plus$(BigDecimalIsConflicted $this, BigDecimal x, BigDecimal y) {
            return $this.plus(x, y);
        }

        @Override
        default public BigDecimal plus(BigDecimal x, BigDecimal y) {
            return x.$plus(y);
        }

        public static /* synthetic */ BigDecimal minus$(BigDecimalIsConflicted $this, BigDecimal x, BigDecimal y) {
            return $this.minus(x, y);
        }

        @Override
        default public BigDecimal minus(BigDecimal x, BigDecimal y) {
            return x.$minus(y);
        }

        public static /* synthetic */ BigDecimal times$(BigDecimalIsConflicted $this, BigDecimal x, BigDecimal y) {
            return $this.times(x, y);
        }

        @Override
        default public BigDecimal times(BigDecimal x, BigDecimal y) {
            return x.$times(y);
        }

        public static /* synthetic */ BigDecimal negate$(BigDecimalIsConflicted $this, BigDecimal x) {
            return $this.negate(x);
        }

        @Override
        default public BigDecimal negate(BigDecimal x) {
            return x.unary_$minus();
        }

        public static /* synthetic */ BigDecimal fromInt$(BigDecimalIsConflicted $this, int x) {
            return $this.fromInt(x);
        }

        @Override
        default public BigDecimal fromInt(int x) {
            return BigDecimal$.MODULE$.apply(x);
        }

        public static /* synthetic */ int toInt$(BigDecimalIsConflicted $this, BigDecimal x) {
            return $this.toInt(x);
        }

        @Override
        default public int toInt(BigDecimal x) {
            return x.intValue();
        }

        public static /* synthetic */ long toLong$(BigDecimalIsConflicted $this, BigDecimal x) {
            return $this.toLong(x);
        }

        @Override
        default public long toLong(BigDecimal x) {
            return x.longValue();
        }

        public static /* synthetic */ float toFloat$(BigDecimalIsConflicted $this, BigDecimal x) {
            return $this.toFloat(x);
        }

        @Override
        default public float toFloat(BigDecimal x) {
            return x.floatValue();
        }

        public static /* synthetic */ double toDouble$(BigDecimalIsConflicted $this, BigDecimal x) {
            return $this.toDouble(x);
        }

        @Override
        default public double toDouble(BigDecimal x) {
            return x.doubleValue();
        }

        public static void $init$(BigDecimalIsConflicted $this) {
        }
    }

    public static interface BigDecimalIsFractional
    extends BigDecimalIsConflicted,
    Fractional<BigDecimal> {
        public static /* synthetic */ BigDecimal div$(BigDecimalIsFractional $this, BigDecimal x, BigDecimal y) {
            return $this.div(x, y);
        }

        @Override
        default public BigDecimal div(BigDecimal x, BigDecimal y) {
            return x.$div(y);
        }

        public static void $init$(BigDecimalIsFractional $this) {
        }
    }

    public static interface BigIntIsIntegral
    extends Integral<BigInt> {
        public static /* synthetic */ BigInt plus$(BigIntIsIntegral $this, BigInt x, BigInt y) {
            return $this.plus(x, y);
        }

        @Override
        default public BigInt plus(BigInt x, BigInt y) {
            return x.$plus(y);
        }

        public static /* synthetic */ BigInt minus$(BigIntIsIntegral $this, BigInt x, BigInt y) {
            return $this.minus(x, y);
        }

        @Override
        default public BigInt minus(BigInt x, BigInt y) {
            return x.$minus(y);
        }

        public static /* synthetic */ BigInt times$(BigIntIsIntegral $this, BigInt x, BigInt y) {
            return $this.times(x, y);
        }

        @Override
        default public BigInt times(BigInt x, BigInt y) {
            return x.$times(y);
        }

        public static /* synthetic */ BigInt quot$(BigIntIsIntegral $this, BigInt x, BigInt y) {
            return $this.quot(x, y);
        }

        @Override
        default public BigInt quot(BigInt x, BigInt y) {
            return x.$div(y);
        }

        public static /* synthetic */ BigInt rem$(BigIntIsIntegral $this, BigInt x, BigInt y) {
            return $this.rem(x, y);
        }

        @Override
        default public BigInt rem(BigInt x, BigInt y) {
            return x.$percent(y);
        }

        public static /* synthetic */ BigInt negate$(BigIntIsIntegral $this, BigInt x) {
            return $this.negate(x);
        }

        @Override
        default public BigInt negate(BigInt x) {
            return x.unary_$minus();
        }

        public static /* synthetic */ BigInt fromInt$(BigIntIsIntegral $this, int x) {
            return $this.fromInt(x);
        }

        @Override
        default public BigInt fromInt(int x) {
            return BigInt$.MODULE$.apply(x);
        }

        public static /* synthetic */ int toInt$(BigIntIsIntegral $this, BigInt x) {
            return $this.toInt(x);
        }

        @Override
        default public int toInt(BigInt x) {
            return x.intValue();
        }

        public static /* synthetic */ long toLong$(BigIntIsIntegral $this, BigInt x) {
            return $this.toLong(x);
        }

        @Override
        default public long toLong(BigInt x) {
            return x.longValue();
        }

        public static /* synthetic */ float toFloat$(BigIntIsIntegral $this, BigInt x) {
            return $this.toFloat(x);
        }

        @Override
        default public float toFloat(BigInt x) {
            return x.floatValue();
        }

        public static /* synthetic */ double toDouble$(BigIntIsIntegral $this, BigInt x) {
            return $this.toDouble(x);
        }

        @Override
        default public double toDouble(BigInt x) {
            return x.doubleValue();
        }

        public static void $init$(BigIntIsIntegral $this) {
        }
    }

    public static interface ByteIsIntegral
    extends Integral<Object> {
        public static /* synthetic */ byte plus$(ByteIsIntegral $this, byte x, byte y) {
            return $this.plus(x, y);
        }

        @Override
        default public byte plus(byte x, byte y) {
            return (byte)(x + y);
        }

        public static /* synthetic */ byte minus$(ByteIsIntegral $this, byte x, byte y) {
            return $this.minus(x, y);
        }

        @Override
        default public byte minus(byte x, byte y) {
            return (byte)(x - y);
        }

        public static /* synthetic */ byte times$(ByteIsIntegral $this, byte x, byte y) {
            return $this.times(x, y);
        }

        @Override
        default public byte times(byte x, byte y) {
            return (byte)(x * y);
        }

        public static /* synthetic */ byte quot$(ByteIsIntegral $this, byte x, byte y) {
            return $this.quot(x, y);
        }

        @Override
        default public byte quot(byte x, byte y) {
            return (byte)(x / y);
        }

        public static /* synthetic */ byte rem$(ByteIsIntegral $this, byte x, byte y) {
            return $this.rem(x, y);
        }

        @Override
        default public byte rem(byte x, byte y) {
            return (byte)(x % y);
        }

        public static /* synthetic */ byte negate$(ByteIsIntegral $this, byte x) {
            return $this.negate(x);
        }

        @Override
        default public byte negate(byte x) {
            return -x;
        }

        public static /* synthetic */ byte fromInt$(ByteIsIntegral $this, int x) {
            return $this.fromInt(x);
        }

        @Override
        default public byte fromInt(int x) {
            return (byte)x;
        }

        public static /* synthetic */ int toInt$(ByteIsIntegral $this, byte x) {
            return $this.toInt(x);
        }

        @Override
        default public int toInt(byte x) {
            return x;
        }

        public static /* synthetic */ long toLong$(ByteIsIntegral $this, byte x) {
            return $this.toLong(x);
        }

        @Override
        default public long toLong(byte x) {
            return x;
        }

        public static /* synthetic */ float toFloat$(ByteIsIntegral $this, byte x) {
            return $this.toFloat(x);
        }

        @Override
        default public float toFloat(byte x) {
            return x;
        }

        public static /* synthetic */ double toDouble$(ByteIsIntegral $this, byte x) {
            return $this.toDouble(x);
        }

        @Override
        default public double toDouble(byte x) {
            return x;
        }

        public static void $init$(ByteIsIntegral $this) {
        }
    }

    public static interface CharIsIntegral
    extends Integral<Object> {
        public static /* synthetic */ char plus$(CharIsIntegral $this, char x, char y) {
            return $this.plus(x, y);
        }

        @Override
        default public char plus(char x, char y) {
            return (char)(x + y);
        }

        public static /* synthetic */ char minus$(CharIsIntegral $this, char x, char y) {
            return $this.minus(x, y);
        }

        @Override
        default public char minus(char x, char y) {
            return (char)(x - y);
        }

        public static /* synthetic */ char times$(CharIsIntegral $this, char x, char y) {
            return $this.times(x, y);
        }

        @Override
        default public char times(char x, char y) {
            return (char)(x * y);
        }

        public static /* synthetic */ char quot$(CharIsIntegral $this, char x, char y) {
            return $this.quot(x, y);
        }

        @Override
        default public char quot(char x, char y) {
            return (char)(x / y);
        }

        public static /* synthetic */ char rem$(CharIsIntegral $this, char x, char y) {
            return $this.rem(x, y);
        }

        @Override
        default public char rem(char x, char y) {
            return (char)(x % y);
        }

        public static /* synthetic */ char negate$(CharIsIntegral $this, char x) {
            return $this.negate(x);
        }

        @Override
        default public char negate(char x) {
            return -x;
        }

        public static /* synthetic */ char fromInt$(CharIsIntegral $this, int x) {
            return $this.fromInt(x);
        }

        @Override
        default public char fromInt(int x) {
            return (char)x;
        }

        public static /* synthetic */ int toInt$(CharIsIntegral $this, char x) {
            return $this.toInt(x);
        }

        @Override
        default public int toInt(char x) {
            return x;
        }

        public static /* synthetic */ long toLong$(CharIsIntegral $this, char x) {
            return $this.toLong(x);
        }

        @Override
        default public long toLong(char x) {
            return x;
        }

        public static /* synthetic */ float toFloat$(CharIsIntegral $this, char x) {
            return $this.toFloat(x);
        }

        @Override
        default public float toFloat(char x) {
            return x;
        }

        public static /* synthetic */ double toDouble$(CharIsIntegral $this, char x) {
            return $this.toDouble(x);
        }

        @Override
        default public double toDouble(char x) {
            return x;
        }

        public static void $init$(CharIsIntegral $this) {
        }
    }

    public static interface DoubleAsIfIntegral
    extends DoubleIsConflicted,
    Integral<Object> {
        public static /* synthetic */ double quot$(DoubleAsIfIntegral $this, double x, double y) {
            return $this.quot(x, y);
        }

        @Override
        default public double quot(double x, double y) {
            return BigDecimal$.MODULE$.apply(x).quot(BigDecimal$.MODULE$.apply(y)).doubleValue();
        }

        public static /* synthetic */ double rem$(DoubleAsIfIntegral $this, double x, double y) {
            return $this.rem(x, y);
        }

        @Override
        default public double rem(double x, double y) {
            return BigDecimal$.MODULE$.apply(x).remainder(BigDecimal$.MODULE$.apply(y)).doubleValue();
        }

        public static void $init$(DoubleAsIfIntegral $this) {
        }
    }

    public static interface DoubleIsConflicted
    extends Numeric<Object> {
        public static /* synthetic */ double plus$(DoubleIsConflicted $this, double x, double y) {
            return $this.plus(x, y);
        }

        @Override
        default public double plus(double x, double y) {
            return x + y;
        }

        public static /* synthetic */ double minus$(DoubleIsConflicted $this, double x, double y) {
            return $this.minus(x, y);
        }

        @Override
        default public double minus(double x, double y) {
            return x - y;
        }

        public static /* synthetic */ double times$(DoubleIsConflicted $this, double x, double y) {
            return $this.times(x, y);
        }

        @Override
        default public double times(double x, double y) {
            return x * y;
        }

        public static /* synthetic */ double negate$(DoubleIsConflicted $this, double x) {
            return $this.negate(x);
        }

        @Override
        default public double negate(double x) {
            return -x;
        }

        public static /* synthetic */ double fromInt$(DoubleIsConflicted $this, int x) {
            return $this.fromInt(x);
        }

        @Override
        default public double fromInt(int x) {
            return x;
        }

        public static /* synthetic */ int toInt$(DoubleIsConflicted $this, double x) {
            return $this.toInt(x);
        }

        @Override
        default public int toInt(double x) {
            return (int)x;
        }

        public static /* synthetic */ long toLong$(DoubleIsConflicted $this, double x) {
            return $this.toLong(x);
        }

        @Override
        default public long toLong(double x) {
            return (long)x;
        }

        public static /* synthetic */ float toFloat$(DoubleIsConflicted $this, double x) {
            return $this.toFloat(x);
        }

        @Override
        default public float toFloat(double x) {
            return (float)x;
        }

        public static /* synthetic */ double toDouble$(DoubleIsConflicted $this, double x) {
            return $this.toDouble(x);
        }

        @Override
        default public double toDouble(double x) {
            return x;
        }

        public static /* synthetic */ double abs$(DoubleIsConflicted $this, double x) {
            return $this.abs(x);
        }

        @Override
        default public double abs(double x) {
            return package$.MODULE$.abs(x);
        }

        public static void $init$(DoubleIsConflicted $this) {
        }
    }

    public static interface DoubleIsFractional
    extends DoubleIsConflicted,
    Fractional<Object> {
        public static /* synthetic */ double div$(DoubleIsFractional $this, double x, double y) {
            return $this.div(x, y);
        }

        @Override
        default public double div(double x, double y) {
            return x / y;
        }

        public static void $init$(DoubleIsFractional $this) {
        }
    }

    public static interface ExtraImplicits {
        public static /* synthetic */ Ops infixNumericOps$(ExtraImplicits $this, Object x, Numeric num) {
            return $this.infixNumericOps(x, num);
        }

        default public <T> Ops infixNumericOps(T x, Numeric<T> num) {
            return new Ops(num, x);
        }

        public static void $init$(ExtraImplicits $this) {
        }
    }

    public static interface FloatAsIfIntegral
    extends FloatIsConflicted,
    Integral<Object> {
        public static /* synthetic */ float quot$(FloatAsIfIntegral $this, float x, float y) {
            return $this.quot(x, y);
        }

        @Override
        default public float quot(float x, float y) {
            return BigDecimal$.MODULE$.apply(x).quot(BigDecimal$.MODULE$.apply(y)).floatValue();
        }

        public static /* synthetic */ float rem$(FloatAsIfIntegral $this, float x, float y) {
            return $this.rem(x, y);
        }

        @Override
        default public float rem(float x, float y) {
            return BigDecimal$.MODULE$.apply(x).remainder(BigDecimal$.MODULE$.apply(y)).floatValue();
        }

        public static void $init$(FloatAsIfIntegral $this) {
        }
    }

    public static interface FloatIsConflicted
    extends Numeric<Object> {
        public static /* synthetic */ float plus$(FloatIsConflicted $this, float x, float y) {
            return $this.plus(x, y);
        }

        @Override
        default public float plus(float x, float y) {
            return x + y;
        }

        public static /* synthetic */ float minus$(FloatIsConflicted $this, float x, float y) {
            return $this.minus(x, y);
        }

        @Override
        default public float minus(float x, float y) {
            return x - y;
        }

        public static /* synthetic */ float times$(FloatIsConflicted $this, float x, float y) {
            return $this.times(x, y);
        }

        @Override
        default public float times(float x, float y) {
            return x * y;
        }

        public static /* synthetic */ float negate$(FloatIsConflicted $this, float x) {
            return $this.negate(x);
        }

        @Override
        default public float negate(float x) {
            return -x;
        }

        public static /* synthetic */ float fromInt$(FloatIsConflicted $this, int x) {
            return $this.fromInt(x);
        }

        @Override
        default public float fromInt(int x) {
            return x;
        }

        public static /* synthetic */ int toInt$(FloatIsConflicted $this, float x) {
            return $this.toInt(x);
        }

        @Override
        default public int toInt(float x) {
            return (int)x;
        }

        public static /* synthetic */ long toLong$(FloatIsConflicted $this, float x) {
            return $this.toLong(x);
        }

        @Override
        default public long toLong(float x) {
            return (long)x;
        }

        public static /* synthetic */ float toFloat$(FloatIsConflicted $this, float x) {
            return $this.toFloat(x);
        }

        @Override
        default public float toFloat(float x) {
            return x;
        }

        public static /* synthetic */ double toDouble$(FloatIsConflicted $this, float x) {
            return $this.toDouble(x);
        }

        @Override
        default public double toDouble(float x) {
            return x;
        }

        public static /* synthetic */ float abs$(FloatIsConflicted $this, float x) {
            return $this.abs(x);
        }

        @Override
        default public float abs(float x) {
            return package$.MODULE$.abs(x);
        }

        public static void $init$(FloatIsConflicted $this) {
        }
    }

    public static interface FloatIsFractional
    extends FloatIsConflicted,
    Fractional<Object> {
        public static /* synthetic */ float div$(FloatIsFractional $this, float x, float y) {
            return $this.div(x, y);
        }

        @Override
        default public float div(float x, float y) {
            return x / y;
        }

        public static void $init$(FloatIsFractional $this) {
        }
    }

    public static interface IntIsIntegral
    extends Integral<Object> {
        public static /* synthetic */ int plus$(IntIsIntegral $this, int x, int y) {
            return $this.plus(x, y);
        }

        @Override
        default public int plus(int x, int y) {
            return x + y;
        }

        public static /* synthetic */ int minus$(IntIsIntegral $this, int x, int y) {
            return $this.minus(x, y);
        }

        @Override
        default public int minus(int x, int y) {
            return x - y;
        }

        public static /* synthetic */ int times$(IntIsIntegral $this, int x, int y) {
            return $this.times(x, y);
        }

        @Override
        default public int times(int x, int y) {
            return x * y;
        }

        public static /* synthetic */ int quot$(IntIsIntegral $this, int x, int y) {
            return $this.quot(x, y);
        }

        @Override
        default public int quot(int x, int y) {
            return x / y;
        }

        public static /* synthetic */ int rem$(IntIsIntegral $this, int x, int y) {
            return $this.rem(x, y);
        }

        @Override
        default public int rem(int x, int y) {
            return x % y;
        }

        public static /* synthetic */ int negate$(IntIsIntegral $this, int x) {
            return $this.negate(x);
        }

        @Override
        default public int negate(int x) {
            return -x;
        }

        public static /* synthetic */ int fromInt$(IntIsIntegral $this, int x) {
            return $this.fromInt(x);
        }

        @Override
        default public int fromInt(int x) {
            return x;
        }

        public static /* synthetic */ int toInt$(IntIsIntegral $this, int x) {
            return $this.toInt(x);
        }

        @Override
        default public int toInt(int x) {
            return x;
        }

        public static /* synthetic */ long toLong$(IntIsIntegral $this, int x) {
            return $this.toLong(x);
        }

        @Override
        default public long toLong(int x) {
            return x;
        }

        public static /* synthetic */ float toFloat$(IntIsIntegral $this, int x) {
            return $this.toFloat(x);
        }

        @Override
        default public float toFloat(int x) {
            return x;
        }

        public static /* synthetic */ double toDouble$(IntIsIntegral $this, int x) {
            return $this.toDouble(x);
        }

        @Override
        default public double toDouble(int x) {
            return x;
        }

        public static void $init$(IntIsIntegral $this) {
        }
    }

    public static interface LongIsIntegral
    extends Integral<Object> {
        public static /* synthetic */ long plus$(LongIsIntegral $this, long x, long y) {
            return $this.plus(x, y);
        }

        @Override
        default public long plus(long x, long y) {
            return x + y;
        }

        public static /* synthetic */ long minus$(LongIsIntegral $this, long x, long y) {
            return $this.minus(x, y);
        }

        @Override
        default public long minus(long x, long y) {
            return x - y;
        }

        public static /* synthetic */ long times$(LongIsIntegral $this, long x, long y) {
            return $this.times(x, y);
        }

        @Override
        default public long times(long x, long y) {
            return x * y;
        }

        public static /* synthetic */ long quot$(LongIsIntegral $this, long x, long y) {
            return $this.quot(x, y);
        }

        @Override
        default public long quot(long x, long y) {
            return x / y;
        }

        public static /* synthetic */ long rem$(LongIsIntegral $this, long x, long y) {
            return $this.rem(x, y);
        }

        @Override
        default public long rem(long x, long y) {
            return x % y;
        }

        public static /* synthetic */ long negate$(LongIsIntegral $this, long x) {
            return $this.negate(x);
        }

        @Override
        default public long negate(long x) {
            return -x;
        }

        public static /* synthetic */ long fromInt$(LongIsIntegral $this, int x) {
            return $this.fromInt(x);
        }

        @Override
        default public long fromInt(int x) {
            return x;
        }

        public static /* synthetic */ int toInt$(LongIsIntegral $this, long x) {
            return $this.toInt(x);
        }

        @Override
        default public int toInt(long x) {
            return (int)x;
        }

        public static /* synthetic */ long toLong$(LongIsIntegral $this, long x) {
            return $this.toLong(x);
        }

        @Override
        default public long toLong(long x) {
            return x;
        }

        public static /* synthetic */ float toFloat$(LongIsIntegral $this, long x) {
            return $this.toFloat(x);
        }

        @Override
        default public float toFloat(long x) {
            return x;
        }

        public static /* synthetic */ double toDouble$(LongIsIntegral $this, long x) {
            return $this.toDouble(x);
        }

        @Override
        default public double toDouble(long x) {
            return x;
        }

        public static void $init$(LongIsIntegral $this) {
        }
    }

    public class Ops {
        private final T lhs;
        public final /* synthetic */ Numeric $outer;

        public T $plus(T rhs) {
            return this.scala$math$Numeric$Ops$$$outer().plus(this.lhs, rhs);
        }

        public T $minus(T rhs) {
            return this.scala$math$Numeric$Ops$$$outer().minus(this.lhs, rhs);
        }

        public T $times(T rhs) {
            return this.scala$math$Numeric$Ops$$$outer().times(this.lhs, rhs);
        }

        public T unary_$minus() {
            return this.scala$math$Numeric$Ops$$$outer().negate(this.lhs);
        }

        public T abs() {
            return this.scala$math$Numeric$Ops$$$outer().abs(this.lhs);
        }

        public int signum() {
            return this.scala$math$Numeric$Ops$$$outer().signum(this.lhs);
        }

        public int toInt() {
            return this.scala$math$Numeric$Ops$$$outer().toInt(this.lhs);
        }

        public long toLong() {
            return this.scala$math$Numeric$Ops$$$outer().toLong(this.lhs);
        }

        public float toFloat() {
            return this.scala$math$Numeric$Ops$$$outer().toFloat(this.lhs);
        }

        public double toDouble() {
            return this.scala$math$Numeric$Ops$$$outer().toDouble(this.lhs);
        }

        public /* synthetic */ Numeric scala$math$Numeric$Ops$$$outer() {
            return this.$outer;
        }

        public Ops(Numeric $outer, T lhs) {
            this.lhs = lhs;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public static interface ShortIsIntegral
    extends Integral<Object> {
        public static /* synthetic */ short plus$(ShortIsIntegral $this, short x, short y) {
            return $this.plus(x, y);
        }

        @Override
        default public short plus(short x, short y) {
            return (short)(x + y);
        }

        public static /* synthetic */ short minus$(ShortIsIntegral $this, short x, short y) {
            return $this.minus(x, y);
        }

        @Override
        default public short minus(short x, short y) {
            return (short)(x - y);
        }

        public static /* synthetic */ short times$(ShortIsIntegral $this, short x, short y) {
            return $this.times(x, y);
        }

        @Override
        default public short times(short x, short y) {
            return (short)(x * y);
        }

        public static /* synthetic */ short quot$(ShortIsIntegral $this, short x, short y) {
            return $this.quot(x, y);
        }

        @Override
        default public short quot(short x, short y) {
            return (short)(x / y);
        }

        public static /* synthetic */ short rem$(ShortIsIntegral $this, short x, short y) {
            return $this.rem(x, y);
        }

        @Override
        default public short rem(short x, short y) {
            return (short)(x % y);
        }

        public static /* synthetic */ short negate$(ShortIsIntegral $this, short x) {
            return $this.negate(x);
        }

        @Override
        default public short negate(short x) {
            return -x;
        }

        public static /* synthetic */ short fromInt$(ShortIsIntegral $this, int x) {
            return $this.fromInt(x);
        }

        @Override
        default public short fromInt(int x) {
            return (short)x;
        }

        public static /* synthetic */ int toInt$(ShortIsIntegral $this, short x) {
            return $this.toInt(x);
        }

        @Override
        default public int toInt(short x) {
            return x;
        }

        public static /* synthetic */ long toLong$(ShortIsIntegral $this, short x) {
            return $this.toLong(x);
        }

        @Override
        default public long toLong(short x) {
            return x;
        }

        public static /* synthetic */ float toFloat$(ShortIsIntegral $this, short x) {
            return $this.toFloat(x);
        }

        @Override
        default public float toFloat(short x) {
            return x;
        }

        public static /* synthetic */ double toDouble$(ShortIsIntegral $this, short x) {
            return $this.toDouble(x);
        }

        @Override
        default public double toDouble(short x) {
            return x;
        }

        public static void $init$(ShortIsIntegral $this) {
        }
    }
}

