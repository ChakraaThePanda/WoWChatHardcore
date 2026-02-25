/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Option;
import scala.Product;
import scala.Product18;
import scala.Serializable;
import scala.Tuple18$;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0019%e\u0001\u0002$H\u0005*C!\"a\f\u0001\u0005+\u0007I\u0011AA\u0019\u0011%\t\u0019\u0004\u0001B\tB\u0003%1\u000b\u0003\u0006\u00026\u0001\u0011)\u001a!C\u0001\u0003oA\u0011\"!\u000f\u0001\u0005#\u0005\u000b\u0011\u00020\t\u0015\u0005m\u0002A!f\u0001\n\u0003\ti\u0004C\u0005\u0002@\u0001\u0011\t\u0012)A\u0005C\"Q\u0011\u0011\t\u0001\u0003\u0016\u0004%\t!a\u0011\t\u0013\u0005\u0015\u0003A!E!\u0002\u0013!\u0007BCA$\u0001\tU\r\u0011\"\u0001\u0002J!I\u00111\n\u0001\u0003\u0012\u0003\u0006Ia\u001a\u0005\u000b\u0003\u001b\u0002!Q3A\u0005\u0002\u0005=\u0003\"CA)\u0001\tE\t\u0015!\u0003k\u0011)\t\u0019\u0006\u0001BK\u0002\u0013\u0005\u0011Q\u000b\u0005\n\u0003/\u0002!\u0011#Q\u0001\n5D!\"!\u0017\u0001\u0005+\u0007I\u0011AA.\u0011%\ti\u0006\u0001B\tB\u0003%\u0001\u000f\u0003\u0006\u0002`\u0001\u0011)\u001a!C\u0001\u0003CB\u0011\"a\u0019\u0001\u0005#\u0005\u000b\u0011B:\t\u0015\u0005\u0015\u0004A!f\u0001\n\u0003\t9\u0007C\u0005\u0002j\u0001\u0011\t\u0012)A\u0005m\"Q\u00111\u000e\u0001\u0003\u0016\u0004%\t!!\u001c\t\u0013\u0005=\u0004A!E!\u0002\u0013I\bBCA9\u0001\tU\r\u0011\"\u0001\u0002t!I\u0011Q\u000f\u0001\u0003\u0012\u0003\u0006I\u0001 \u0005\u000b\u0003o\u0002!Q3A\u0005\u0002\u0005e\u0004\"CA>\u0001\tE\t\u0015!\u0003\u0000\u0011)\ti\b\u0001BK\u0002\u0013\u0005\u0011q\u0010\u0005\u000b\u0003\u0003\u0003!\u0011#Q\u0001\n\u0005\u0015\u0001BCAB\u0001\tU\r\u0011\"\u0001\u0002\u0006\"Q\u0011q\u0011\u0001\u0003\u0012\u0003\u0006I!a\u0003\t\u0015\u0005%\u0005A!f\u0001\n\u0003\tY\t\u0003\u0006\u0002\u000e\u0002\u0011\t\u0012)A\u0005\u0003#A!\"a$\u0001\u0005+\u0007I\u0011AAI\u0011)\t\u0019\n\u0001B\tB\u0003%\u0011q\u0003\u0005\u000b\u0003+\u0003!Q3A\u0005\u0002\u0005]\u0005BCAM\u0001\tE\t\u0015!\u0003\u0002\u001e!9\u00111\u0014\u0001\u0005\u0002\u0005u\u0005bBAc\u0001\u0011\u0005\u0013q\u0019\u0005\n\u00033\u0004\u0011\u0011!C\u0001\u00037D\u0011B!\u0014\u0001#\u0003%\tAa\u0014\t\u0013\t-\u0005!%A\u0005\u0002\t5\u0005\"\u0003B\\\u0001E\u0005I\u0011\u0001B]\u0011%\u0011\u0019\u000fAI\u0001\n\u0003\u0011)\u000fC\u0005\u0004\u0010\u0001\t\n\u0011\"\u0001\u0004\u0012!I11\b\u0001\u0012\u0002\u0013\u00051Q\b\u0005\n\u0007O\u0002\u0011\u0013!C\u0001\u0007SB\u0011ba%\u0001#\u0003%\ta!&\t\u0013\r}\u0006!%A\u0005\u0002\r\u0005\u0007\"CBv\u0001E\u0005I\u0011ABw\u0011%!9\u0002AI\u0001\n\u0003!I\u0002C\u0005\u0005D\u0001\t\n\u0011\"\u0001\u0005F!IAq\u000e\u0001\u0012\u0002\u0013\u0005A\u0011\u000f\u0005\n\t7\u0003\u0011\u0013!C\u0001\t;C\u0011\u0002b2\u0001#\u0003%\t\u0001\"3\t\u0013\u0011M\b!%A\u0005\u0002\u0011U\b\"CC\u0010\u0001E\u0005I\u0011AC\u0011\u0011%)Y\u0005AI\u0001\n\u0003)i\u0005C\u0005\u0006x\u0001\t\t\u0011\"\u0011\u0006z!IQ1\u0010\u0001\u0002\u0002\u0013\u0005SQ\u0010\u0005\n\u000b\u0017\u0003\u0011\u0011!C\u0001\u000b\u001bC\u0011\"\"'\u0001\u0003\u0003%\t%b'\t\u0013\u0015\r\u0006!!A\u0005B\u0015\u0015v!CCU\u000f\u0006\u0005\t\u0012ACV\r!1u)!A\t\u0002\u00155\u0006bBAN\u0001\u0012\u0005Qq\u0016\u0005\n\u0003\u000b\u0004\u0015\u0011!C#\u0003\u000fD\u0011\"\"-A\u0003\u0003%\t)b-\t\u0013\u0019\u0015\u0002)!A\u0005\u0002\u001a\u001d\u0002\"\u0003D@\u0001\u0006\u0005I\u0011\u0002DA\u0005\u001d!V\u000f\u001d7fcaR\u0011\u0001S\u0001\u0006g\u000e\fG.Y\u0002\u0001+eYUk\u00182fQ.t\u0017\u000f^<{{\u0006\u0005\u0011qAA\u0007\u0003'\tI\"a\b\u0014\u000f\u0001a\u0005+a\t\u0002*A\u0011QJT\u0007\u0002\u000f&\u0011qj\u0012\u0002\u0007\u0003:L(+\u001a4\u001135\u000b6KX1eO*l\u0007o\u001d<zy~\f)!a\u0003\u0002\u0012\u0005]\u0011QD\u0005\u0003%\u001e\u0013\u0011\u0002\u0015:pIV\u001cG/\r\u001d\u0011\u0005Q+F\u0002\u0001\u0003\u0007-\u0002!)\u0019A,\u0003\u0005Q\u000b\u0014C\u0001-\\!\ti\u0015,\u0003\u0002[\u000f\n9aj\u001c;iS:<\u0007CA']\u0013\tivIA\u0002B]f\u0004\"\u0001V0\u0005\r\u0001\u0004AQ1\u0001X\u0005\t!&\u0007\u0005\u0002UE\u001211\r\u0001CC\u0002]\u0013!\u0001V\u001a\u0011\u0005Q+GA\u00024\u0001\t\u000b\u0007qK\u0001\u0002UiA\u0011A\u000b\u001b\u0003\u0007S\u0002!)\u0019A,\u0003\u0005Q+\u0004C\u0001+l\t\u0019a\u0007\u0001\"b\u0001/\n\u0011AK\u000e\t\u0003):$aa\u001c\u0001\u0005\u0006\u00049&A\u0001+8!\t!\u0016\u000f\u0002\u0004s\u0001\u0011\u0015\ra\u0016\u0002\u0003)b\u0002\"\u0001\u0016;\u0005\rU\u0004AQ1\u0001X\u0005\t!\u0016\b\u0005\u0002Uo\u00121\u0001\u0010\u0001CC\u0002]\u00131\u0001V\u00191!\t!&\u0010\u0002\u0004|\u0001\u0011\u0015\ra\u0016\u0002\u0004)F\n\u0004C\u0001+~\t\u0019q\b\u0001\"b\u0001/\n\u0019A+\r\u001a\u0011\u0007Q\u000b\t\u0001B\u0004\u0002\u0004\u0001!)\u0019A,\u0003\u0007Q\u000b4\u0007E\u0002U\u0003\u000f!q!!\u0003\u0001\t\u000b\u0007qKA\u0002UcQ\u00022\u0001VA\u0007\t\u001d\ty\u0001\u0001CC\u0002]\u00131\u0001V\u00196!\r!\u00161\u0003\u0003\b\u0003+\u0001AQ1\u0001X\u0005\r!\u0016G\u000e\t\u0004)\u0006eAaBA\u000e\u0001\u0011\u0015\ra\u0016\u0002\u0004)F:\u0004c\u0001+\u0002 \u00119\u0011\u0011\u0005\u0001\u0005\u0006\u00049&a\u0001+2qA\u0019Q*!\n\n\u0007\u0005\u001drIA\u0004Qe>$Wo\u0019;\u0011\u00075\u000bY#C\u0002\u0002.\u001d\u0013AbU3sS\u0006d\u0017N_1cY\u0016\f!aX\u0019\u0016\u0003M\u000b1aX\u0019!\u0003\ty&'F\u0001_\u0003\ry&\u0007I\u0001\u0003?N*\u0012!Y\u0001\u0004?N\u0002\u0013AA05+\u0005!\u0017aA05A\u0005\u0011q,N\u000b\u0002O\u0006\u0019q,\u000e\u0011\u0002\u0005}3T#\u00016\u0002\u0007}3\u0004%\u0001\u0002`oU\tQ.A\u0002`o\u0001\n!a\u0018\u001d\u0016\u0003A\f1a\u0018\u001d!\u0003\ty\u0016(F\u0001t\u0003\ry\u0016\bI\u0001\u0004?F\u0002T#\u0001<\u0002\t}\u000b\u0004\u0007I\u0001\u0004?F\nT#A=\u0002\t}\u000b\u0014\u0007I\u0001\u0004?F\u0012T#\u0001?\u0002\t}\u000b$\u0007I\u0001\u0004?F\u001aT#A@\u0002\t}\u000b4\u0007I\u0001\u0004?F\"TCAA\u0003\u0003\u0011y\u0016\u0007\u000e\u0011\u0002\u0007}\u000bT'\u0006\u0002\u0002\f\u0005!q,M\u001b!\u0003\ry\u0016GN\u000b\u0003\u0003#\tAaX\u00197A\u0005\u0019q,M\u001c\u0016\u0005\u0005]\u0011\u0001B02o\u0001\n1aX\u00199+\t\ti\"\u0001\u0003`ca\u0002\u0013A\u0002\u001fj]&$h\b\u0006\u0014\u0002 \u0006\u0005\u00161UAS\u0003O\u000bI+a+\u0002.\u0006=\u0016\u0011WAZ\u0003k\u000b9,!/\u0002<\u0006u\u0016qXAa\u0003\u0007\u0004\u0012$\u0014\u0001T=\u0006$wM[7qgZLHp`A\u0003\u0003\u0017\t\t\"a\u0006\u0002\u001e!1\u0011qF\u0013A\u0002MCa!!\u000e&\u0001\u0004q\u0006BBA\u001eK\u0001\u0007\u0011\r\u0003\u0004\u0002B\u0015\u0002\r\u0001\u001a\u0005\u0007\u0003\u000f*\u0003\u0019A4\t\r\u00055S\u00051\u0001k\u0011\u0019\t\u0019&\na\u0001[\"1\u0011\u0011L\u0013A\u0002ADa!a\u0018&\u0001\u0004\u0019\bBBA3K\u0001\u0007a\u000f\u0003\u0004\u0002l\u0015\u0002\r!\u001f\u0005\u0007\u0003c*\u0003\u0019\u0001?\t\r\u0005]T\u00051\u0001\u0000\u0011\u001d\ti(\na\u0001\u0003\u000bAq!a!&\u0001\u0004\tY\u0001C\u0004\u0002\n\u0016\u0002\r!!\u0005\t\u000f\u0005=U\u00051\u0001\u0002\u0018!9\u0011QS\u0013A\u0002\u0005u\u0011\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0005\u0005%\u0007\u0003BAf\u0003+l!!!4\u000b\t\u0005=\u0017\u0011[\u0001\u0005Y\u0006twM\u0003\u0002\u0002T\u0006!!.\u0019<b\u0013\u0011\t9.!4\u0003\rM#(/\u001b8h\u0003\u0011\u0019w\u000e]=\u0016M\u0005u\u00171]At\u0003W\fy/a=\u0002x\u0006m\u0018q B\u0002\u0005\u000f\u0011YAa\u0004\u0003\u0014\t]!1\u0004B\u0010\u0005G\u00119\u0003\u0006\u0014\u0002`\n%\"1\u0006B\u0017\u0005_\u0011\tDa\r\u00036\t]\"\u0011\bB\u001e\u0005{\u0011yD!\u0011\u0003D\t\u0015#q\tB%\u0005\u0017\u0002b%\u0014\u0001\u0002b\u0006\u0015\u0018\u0011^Aw\u0003c\f)0!?\u0002~\n\u0005!Q\u0001B\u0005\u0005\u001b\u0011\tB!\u0006\u0003\u001a\tu!\u0011\u0005B\u0013!\r!\u00161\u001d\u0003\u0006-\u001e\u0012\ra\u0016\t\u0004)\u0006\u001dH!\u00021(\u0005\u00049\u0006c\u0001+\u0002l\u0012)1m\nb\u0001/B\u0019A+a<\u0005\u000b\u0019<#\u0019A,\u0011\u0007Q\u000b\u0019\u0010B\u0003jO\t\u0007q\u000bE\u0002U\u0003o$Q\u0001\\\u0014C\u0002]\u00032\u0001VA~\t\u0015ywE1\u0001X!\r!\u0016q \u0003\u0006e\u001e\u0012\ra\u0016\t\u0004)\n\rA!B;(\u0005\u00049\u0006c\u0001+\u0003\b\u0011)\u0001p\nb\u0001/B\u0019AKa\u0003\u0005\u000bm<#\u0019A,\u0011\u0007Q\u0013y\u0001B\u0003\u007fO\t\u0007q\u000bE\u0002U\u0005'!a!a\u0001(\u0005\u00049\u0006c\u0001+\u0003\u0018\u00111\u0011\u0011B\u0014C\u0002]\u00032\u0001\u0016B\u000e\t\u0019\tya\nb\u0001/B\u0019AKa\b\u0005\r\u0005UqE1\u0001X!\r!&1\u0005\u0003\u0007\u000379#\u0019A,\u0011\u0007Q\u00139\u0003\u0002\u0004\u0002\"\u001d\u0012\ra\u0016\u0005\n\u0003_9\u0003\u0013!a\u0001\u0003CD\u0011\"!\u000e(!\u0003\u0005\r!!:\t\u0013\u0005mr\u0005%AA\u0002\u0005%\b\"CA!OA\u0005\t\u0019AAw\u0011%\t9e\nI\u0001\u0002\u0004\t\t\u0010C\u0005\u0002N\u001d\u0002\n\u00111\u0001\u0002v\"I\u00111K\u0014\u0011\u0002\u0003\u0007\u0011\u0011 \u0005\n\u00033:\u0003\u0013!a\u0001\u0003{D\u0011\"a\u0018(!\u0003\u0005\rA!\u0001\t\u0013\u0005\u0015t\u0005%AA\u0002\t\u0015\u0001\"CA6OA\u0005\t\u0019\u0001B\u0005\u0011%\t\th\nI\u0001\u0002\u0004\u0011i\u0001C\u0005\u0002x\u001d\u0002\n\u00111\u0001\u0003\u0012!I\u0011QP\u0014\u0011\u0002\u0003\u0007!Q\u0003\u0005\n\u0003\u0007;\u0003\u0013!a\u0001\u00053A\u0011\"!#(!\u0003\u0005\rA!\b\t\u0013\u0005=u\u0005%AA\u0002\t\u0005\u0002\"CAKOA\u0005\t\u0019\u0001B\u0013\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIE*bE!\u0015\u0003h\t%$1\u000eB7\u0005_\u0012\tHa\u001d\u0003v\t]$\u0011\u0010B>\u0005{\u0012yH!!\u0003\u0004\n\u0015%q\u0011BE+\t\u0011\u0019FK\u0002T\u0005+Z#Aa\u0016\u0011\t\te#1M\u0007\u0003\u00057RAA!\u0018\u0003`\u0005IQO\\2iK\u000e\\W\r\u001a\u0006\u0004\u0005C:\u0015AC1o]>$\u0018\r^5p]&!!Q\rB.\u0005E)hn\u00195fG.,GMV1sS\u0006t7-\u001a\u0003\u0006-\"\u0012\ra\u0016\u0003\u0006A\"\u0012\ra\u0016\u0003\u0006G\"\u0012\ra\u0016\u0003\u0006M\"\u0012\ra\u0016\u0003\u0006S\"\u0012\ra\u0016\u0003\u0006Y\"\u0012\ra\u0016\u0003\u0006_\"\u0012\ra\u0016\u0003\u0006e\"\u0012\ra\u0016\u0003\u0006k\"\u0012\ra\u0016\u0003\u0006q\"\u0012\ra\u0016\u0003\u0006w\"\u0012\ra\u0016\u0003\u0006}\"\u0012\ra\u0016\u0003\u0007\u0003\u0007A#\u0019A,\u0005\r\u0005%\u0001F1\u0001X\t\u0019\ty\u0001\u000bb\u0001/\u00121\u0011Q\u0003\u0015C\u0002]#a!a\u0007)\u0005\u00049FABA\u0011Q\t\u0007q+\u0001\bd_BLH\u0005Z3gCVdG\u000f\n\u001a\u0016M\t=%1\u0013BK\u0005/\u0013IJa'\u0003\u001e\n}%\u0011\u0015BR\u0005K\u00139K!+\u0003,\n5&q\u0016BY\u0005g\u0013),\u0006\u0002\u0003\u0012*\u001aaL!\u0016\u0005\u000bYK#\u0019A,\u0005\u000b\u0001L#\u0019A,\u0005\u000b\rL#\u0019A,\u0005\u000b\u0019L#\u0019A,\u0005\u000b%L#\u0019A,\u0005\u000b1L#\u0019A,\u0005\u000b=L#\u0019A,\u0005\u000bIL#\u0019A,\u0005\u000bUL#\u0019A,\u0005\u000baL#\u0019A,\u0005\u000bmL#\u0019A,\u0005\u000byL#\u0019A,\u0005\r\u0005\r\u0011F1\u0001X\t\u0019\tI!\u000bb\u0001/\u00121\u0011qB\u0015C\u0002]#a!!\u0006*\u0005\u00049FABA\u000eS\t\u0007q\u000b\u0002\u0004\u0002\"%\u0012\raV\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00134+\u0019\u0012YLa0\u0003B\n\r'Q\u0019Bd\u0005\u0013\u0014YM!4\u0003P\nE'1\u001bBk\u0005/\u0014INa7\u0003^\n}'\u0011]\u000b\u0003\u0005{S3!\u0019B+\t\u00151&F1\u0001X\t\u0015\u0001'F1\u0001X\t\u0015\u0019'F1\u0001X\t\u00151'F1\u0001X\t\u0015I'F1\u0001X\t\u0015a'F1\u0001X\t\u0015y'F1\u0001X\t\u0015\u0011(F1\u0001X\t\u0015)(F1\u0001X\t\u0015A(F1\u0001X\t\u0015Y(F1\u0001X\t\u0015q(F1\u0001X\t\u0019\t\u0019A\u000bb\u0001/\u00121\u0011\u0011\u0002\u0016C\u0002]#a!a\u0004+\u0005\u00049FABA\u000bU\t\u0007q\u000b\u0002\u0004\u0002\u001c)\u0012\ra\u0016\u0003\u0007\u0003CQ#\u0019A,\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%iU1#q\u001dBv\u0005[\u0014yO!=\u0003t\nU(q\u001fB}\u0005w\u0014iPa@\u0004\u0002\r\r1QAB\u0004\u0007\u0013\u0019Ya!\u0004\u0016\u0005\t%(f\u00013\u0003V\u0011)ak\u000bb\u0001/\u0012)\u0001m\u000bb\u0001/\u0012)1m\u000bb\u0001/\u0012)am\u000bb\u0001/\u0012)\u0011n\u000bb\u0001/\u0012)An\u000bb\u0001/\u0012)qn\u000bb\u0001/\u0012)!o\u000bb\u0001/\u0012)Qo\u000bb\u0001/\u0012)\u0001p\u000bb\u0001/\u0012)1p\u000bb\u0001/\u0012)ap\u000bb\u0001/\u00121\u00111A\u0016C\u0002]#a!!\u0003,\u0005\u00049FABA\bW\t\u0007q\u000b\u0002\u0004\u0002\u0016-\u0012\ra\u0016\u0003\u0007\u00037Y#\u0019A,\u0005\r\u0005\u00052F1\u0001X\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIU*bea\u0005\u0004\u0018\re11DB\u000f\u0007?\u0019\tca\t\u0004&\r\u001d2\u0011FB\u0016\u0007[\u0019yc!\r\u00044\rU2qGB\u001d+\t\u0019)BK\u0002h\u0005+\"QA\u0016\u0017C\u0002]#Q\u0001\u0019\u0017C\u0002]#Qa\u0019\u0017C\u0002]#QA\u001a\u0017C\u0002]#Q!\u001b\u0017C\u0002]#Q\u0001\u001c\u0017C\u0002]#Qa\u001c\u0017C\u0002]#QA\u001d\u0017C\u0002]#Q!\u001e\u0017C\u0002]#Q\u0001\u001f\u0017C\u0002]#Qa\u001f\u0017C\u0002]#QA \u0017C\u0002]#a!a\u0001-\u0005\u00049FABA\u0005Y\t\u0007q\u000b\u0002\u0004\u0002\u00101\u0012\ra\u0016\u0003\u0007\u0003+a#\u0019A,\u0005\r\u0005mAF1\u0001X\t\u0019\t\t\u0003\fb\u0001/\u0006q1m\u001c9zI\u0011,g-Y;mi\u00122TCJB \u0007\u0007\u001a)ea\u0012\u0004J\r-3QJB(\u0007#\u001a\u0019f!\u0016\u0004X\re31LB/\u0007?\u001a\tga\u0019\u0004fU\u00111\u0011\t\u0016\u0004U\nUC!\u0002,.\u0005\u00049F!\u00021.\u0005\u00049F!B2.\u0005\u00049F!\u00024.\u0005\u00049F!B5.\u0005\u00049F!\u00027.\u0005\u00049F!B8.\u0005\u00049F!\u0002:.\u0005\u00049F!B;.\u0005\u00049F!\u0002=.\u0005\u00049F!B>.\u0005\u00049F!\u0002@.\u0005\u00049FABA\u0002[\t\u0007q\u000b\u0002\u0004\u0002\n5\u0012\ra\u0016\u0003\u0007\u0003\u001fi#\u0019A,\u0005\r\u0005UQF1\u0001X\t\u0019\tY\"\fb\u0001/\u00121\u0011\u0011E\u0017C\u0002]\u000babY8qs\u0012\"WMZ1vYR$s'\u0006\u0014\u0004l\r=4\u0011OB:\u0007k\u001a9h!\u001f\u0004|\ru4qPBA\u0007\u0007\u001b)ia\"\u0004\n\u000e-5QRBH\u0007#+\"a!\u001c+\u00075\u0014)\u0006B\u0003W]\t\u0007q\u000bB\u0003a]\t\u0007q\u000bB\u0003d]\t\u0007q\u000bB\u0003g]\t\u0007q\u000bB\u0003j]\t\u0007q\u000bB\u0003m]\t\u0007q\u000bB\u0003p]\t\u0007q\u000bB\u0003s]\t\u0007q\u000bB\u0003v]\t\u0007q\u000bB\u0003y]\t\u0007q\u000bB\u0003|]\t\u0007q\u000bB\u0003\u007f]\t\u0007q\u000b\u0002\u0004\u0002\u00049\u0012\ra\u0016\u0003\u0007\u0003\u0013q#\u0019A,\u0005\r\u0005=aF1\u0001X\t\u0019\t)B\fb\u0001/\u00121\u00111\u0004\u0018C\u0002]#a!!\t/\u0005\u00049\u0016AD2paf$C-\u001a4bk2$H\u0005O\u000b'\u0007/\u001bYj!(\u0004 \u000e\u000561UBS\u0007O\u001bIka+\u0004.\u000e=6\u0011WBZ\u0007k\u001b9l!/\u0004<\u000euVCABMU\r\u0001(Q\u000b\u0003\u0006->\u0012\ra\u0016\u0003\u0006A>\u0012\ra\u0016\u0003\u0006G>\u0012\ra\u0016\u0003\u0006M>\u0012\ra\u0016\u0003\u0006S>\u0012\ra\u0016\u0003\u0006Y>\u0012\ra\u0016\u0003\u0006_>\u0012\ra\u0016\u0003\u0006e>\u0012\ra\u0016\u0003\u0006k>\u0012\ra\u0016\u0003\u0006q>\u0012\ra\u0016\u0003\u0006w>\u0012\ra\u0016\u0003\u0006}>\u0012\ra\u0016\u0003\u0007\u0003\u0007y#\u0019A,\u0005\r\u0005%qF1\u0001X\t\u0019\tya\fb\u0001/\u00121\u0011QC\u0018C\u0002]#a!a\u00070\u0005\u00049FABA\u0011_\t\u0007q+\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u001d\u0016M\r\r7qYBe\u0007\u0017\u001cima4\u0004R\u000eM7Q[Bl\u00073\u001cYn!8\u0004`\u000e\u000581]Bs\u0007O\u001cI/\u0006\u0002\u0004F*\u001a1O!\u0016\u0005\u000bY\u0003$\u0019A,\u0005\u000b\u0001\u0004$\u0019A,\u0005\u000b\r\u0004$\u0019A,\u0005\u000b\u0019\u0004$\u0019A,\u0005\u000b%\u0004$\u0019A,\u0005\u000b1\u0004$\u0019A,\u0005\u000b=\u0004$\u0019A,\u0005\u000bI\u0004$\u0019A,\u0005\u000bU\u0004$\u0019A,\u0005\u000ba\u0004$\u0019A,\u0005\u000bm\u0004$\u0019A,\u0005\u000by\u0004$\u0019A,\u0005\r\u0005\r\u0001G1\u0001X\t\u0019\tI\u0001\rb\u0001/\u00121\u0011q\u0002\u0019C\u0002]#a!!\u00061\u0005\u00049FABA\u000ea\t\u0007q\u000b\u0002\u0004\u0002\"A\u0012\raV\u0001\u0010G>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00132aU13q^Bz\u0007k\u001c9p!?\u0004|\u000eu8q C\u0001\t\u0007!)\u0001b\u0002\u0005\n\u0011-AQ\u0002C\b\t#!\u0019\u0002\"\u0006\u0016\u0005\rE(f\u0001<\u0003V\u0011)a+\rb\u0001/\u0012)\u0001-\rb\u0001/\u0012)1-\rb\u0001/\u0012)a-\rb\u0001/\u0012)\u0011.\rb\u0001/\u0012)A.\rb\u0001/\u0012)q.\rb\u0001/\u0012)!/\rb\u0001/\u0012)Q/\rb\u0001/\u0012)\u00010\rb\u0001/\u0012)10\rb\u0001/\u0012)a0\rb\u0001/\u00121\u00111A\u0019C\u0002]#a!!\u00032\u0005\u00049FABA\bc\t\u0007q\u000b\u0002\u0004\u0002\u0016E\u0012\ra\u0016\u0003\u0007\u00037\t$\u0019A,\u0005\r\u0005\u0005\u0012G1\u0001X\u0003=\u0019w\u000e]=%I\u00164\u0017-\u001e7uIE\nTC\nC\u000e\t?!\t\u0003b\t\u0005&\u0011\u001dB\u0011\u0006C\u0016\t[!y\u0003\"\r\u00054\u0011UBq\u0007C\u001d\tw!i\u0004b\u0010\u0005BU\u0011AQ\u0004\u0016\u0004s\nUC!\u0002,3\u0005\u00049F!\u000213\u0005\u00049F!B23\u0005\u00049F!\u000243\u0005\u00049F!B53\u0005\u00049F!\u000273\u0005\u00049F!B83\u0005\u00049F!\u0002:3\u0005\u00049F!B;3\u0005\u00049F!\u0002=3\u0005\u00049F!B>3\u0005\u00049F!\u0002@3\u0005\u00049FABA\u0002e\t\u0007q\u000b\u0002\u0004\u0002\nI\u0012\ra\u0016\u0003\u0007\u0003\u001f\u0011$\u0019A,\u0005\r\u0005U!G1\u0001X\t\u0019\tYB\rb\u0001/\u00121\u0011\u0011\u0005\u001aC\u0002]\u000bqbY8qs\u0012\"WMZ1vYR$\u0013GM\u000b'\t\u000f\"Y\u0005\"\u0014\u0005P\u0011EC1\u000bC+\t/\"I\u0006b\u0017\u0005^\u0011}C\u0011\rC2\tK\"9\u0007\"\u001b\u0005l\u00115TC\u0001C%U\ra(Q\u000b\u0003\u0006-N\u0012\ra\u0016\u0003\u0006AN\u0012\ra\u0016\u0003\u0006GN\u0012\ra\u0016\u0003\u0006MN\u0012\ra\u0016\u0003\u0006SN\u0012\ra\u0016\u0003\u0006YN\u0012\ra\u0016\u0003\u0006_N\u0012\ra\u0016\u0003\u0006eN\u0012\ra\u0016\u0003\u0006kN\u0012\ra\u0016\u0003\u0006qN\u0012\ra\u0016\u0003\u0006wN\u0012\ra\u0016\u0003\u0006}N\u0012\ra\u0016\u0003\u0007\u0003\u0007\u0019$\u0019A,\u0005\r\u0005%1G1\u0001X\t\u0019\tya\rb\u0001/\u00121\u0011QC\u001aC\u0002]#a!a\u00074\u0005\u00049FABA\u0011g\t\u0007q+A\bd_BLH\u0005Z3gCVdG\u000fJ\u00194+\u0019\"\u0019\bb\u001e\u0005z\u0011mDQ\u0010C@\t\u0003#\u0019\t\"\"\u0005\b\u0012%E1\u0012CG\t\u001f#\t\nb%\u0005\u0016\u0012]E\u0011T\u000b\u0003\tkR3a B+\t\u00151FG1\u0001X\t\u0015\u0001GG1\u0001X\t\u0015\u0019GG1\u0001X\t\u00151GG1\u0001X\t\u0015IGG1\u0001X\t\u0015aGG1\u0001X\t\u0015yGG1\u0001X\t\u0015\u0011HG1\u0001X\t\u0015)HG1\u0001X\t\u0015AHG1\u0001X\t\u0015YHG1\u0001X\t\u0015qHG1\u0001X\t\u0019\t\u0019\u0001\u000eb\u0001/\u00121\u0011\u0011\u0002\u001bC\u0002]#a!a\u00045\u0005\u00049FABA\u000bi\t\u0007q\u000b\u0002\u0004\u0002\u001cQ\u0012\ra\u0016\u0003\u0007\u0003C!$\u0019A,\u0002\u001f\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%cQ*b\u0005b(\u0005$\u0012\u0015Fq\u0015CU\tW#i\u000bb,\u00052\u0012MFQ\u0017C\\\ts#Y\f\"0\u0005@\u0012\u0005G1\u0019Cc+\t!\tK\u000b\u0003\u0002\u0006\tUC!\u0002,6\u0005\u00049F!\u000216\u0005\u00049F!B26\u0005\u00049F!\u000246\u0005\u00049F!B56\u0005\u00049F!\u000276\u0005\u00049F!B86\u0005\u00049F!\u0002:6\u0005\u00049F!B;6\u0005\u00049F!\u0002=6\u0005\u00049F!B>6\u0005\u00049F!\u0002@6\u0005\u00049FABA\u0002k\t\u0007q\u000b\u0002\u0004\u0002\nU\u0012\ra\u0016\u0003\u0007\u0003\u001f)$\u0019A,\u0005\r\u0005UQG1\u0001X\t\u0019\tY\"\u000eb\u0001/\u00121\u0011\u0011E\u001bC\u0002]\u000bqbY8qs\u0012\"WMZ1vYR$\u0013'N\u000b'\t\u0017$y\r\"5\u0005T\u0012UGq\u001bCm\t7$i\u000eb8\u0005b\u0012\rHQ\u001dCt\tS$Y\u000f\"<\u0005p\u0012EXC\u0001CgU\u0011\tYA!\u0016\u0005\u000bY3$\u0019A,\u0005\u000b\u00014$\u0019A,\u0005\u000b\r4$\u0019A,\u0005\u000b\u00194$\u0019A,\u0005\u000b%4$\u0019A,\u0005\u000b14$\u0019A,\u0005\u000b=4$\u0019A,\u0005\u000bI4$\u0019A,\u0005\u000bU4$\u0019A,\u0005\u000ba4$\u0019A,\u0005\u000bm4$\u0019A,\u0005\u000by4$\u0019A,\u0005\r\u0005\raG1\u0001X\t\u0019\tIA\u000eb\u0001/\u00121\u0011q\u0002\u001cC\u0002]#a!!\u00067\u0005\u00049FABA\u000em\t\u0007q\u000b\u0002\u0004\u0002\"Y\u0012\raV\u0001\u0010G>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00132mU1Cq\u001fC~\t{$y0\"\u0001\u0006\u0004\u0015\u0015QqAC\u0005\u000b\u0017)i!b\u0004\u0006\u0012\u0015MQQCC\f\u000b3)Y\"\"\b\u0016\u0005\u0011e(\u0006BA\t\u0005+\"QAV\u001cC\u0002]#Q\u0001Y\u001cC\u0002]#QaY\u001cC\u0002]#QAZ\u001cC\u0002]#Q![\u001cC\u0002]#Q\u0001\\\u001cC\u0002]#Qa\\\u001cC\u0002]#QA]\u001cC\u0002]#Q!^\u001cC\u0002]#Q\u0001_\u001cC\u0002]#Qa_\u001cC\u0002]#QA`\u001cC\u0002]#a!a\u00018\u0005\u00049FABA\u0005o\t\u0007q\u000b\u0002\u0004\u0002\u0010]\u0012\ra\u0016\u0003\u0007\u0003+9$\u0019A,\u0005\r\u0005mqG1\u0001X\t\u0019\t\tc\u000eb\u0001/\u0006y1m\u001c9zI\u0011,g-Y;mi\u0012\nt'\u0006\u0014\u0006$\u0015\u001dR\u0011FC\u0016\u000b[)y#\"\r\u00064\u0015URqGC\u001d\u000bw)i$b\u0010\u0006B\u0015\rSQIC$\u000b\u0013*\"!\"\n+\t\u0005]!Q\u000b\u0003\u0006-b\u0012\ra\u0016\u0003\u0006Ab\u0012\ra\u0016\u0003\u0006Gb\u0012\ra\u0016\u0003\u0006Mb\u0012\ra\u0016\u0003\u0006Sb\u0012\ra\u0016\u0003\u0006Yb\u0012\ra\u0016\u0003\u0006_b\u0012\ra\u0016\u0003\u0006eb\u0012\ra\u0016\u0003\u0006kb\u0012\ra\u0016\u0003\u0006qb\u0012\ra\u0016\u0003\u0006wb\u0012\ra\u0016\u0003\u0006}b\u0012\ra\u0016\u0003\u0007\u0003\u0007A$\u0019A,\u0005\r\u0005%\u0001H1\u0001X\t\u0019\ty\u0001\u000fb\u0001/\u00121\u0011Q\u0003\u001dC\u0002]#a!a\u00079\u0005\u00049FABA\u0011q\t\u0007q+A\bd_BLH\u0005Z3gCVdG\u000fJ\u00199+\u0019*y%b\u0015\u0006V\u0015]S\u0011LC.\u000b;*y&\"\u0019\u0006d\u0015\u0015TqMC5\u000bW*i'b\u001c\u0006r\u0015MTQO\u000b\u0003\u000b#RC!!\b\u0003V\u0011)a+\u000fb\u0001/\u0012)\u0001-\u000fb\u0001/\u0012)1-\u000fb\u0001/\u0012)a-\u000fb\u0001/\u0012)\u0011.\u000fb\u0001/\u0012)A.\u000fb\u0001/\u0012)q.\u000fb\u0001/\u0012)!/\u000fb\u0001/\u0012)Q/\u000fb\u0001/\u0012)\u00010\u000fb\u0001/\u0012)10\u000fb\u0001/\u0012)a0\u000fb\u0001/\u00121\u00111A\u001dC\u0002]#a!!\u0003:\u0005\u00049FABA\bs\t\u0007q\u000b\u0002\u0004\u0002\u0016e\u0012\ra\u0016\u0003\u0007\u00037I$\u0019A,\u0005\r\u0005\u0005\u0012H1\u0001X\u00035\u0001(o\u001c3vGR\u0004&/\u001a4jqV\u0011\u0011\u0011Z\u0001\u0010aJ|G-^2u\u0013R,'/\u0019;peV\u0011Qq\u0010\t\u0006\u000b\u0003+9iW\u0007\u0003\u000b\u0007S1!\"\"H\u0003)\u0019w\u000e\u001c7fGRLwN\\\u0005\u0005\u000b\u0013+\u0019I\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003!\u0019\u0017M\\#rk\u0006dG\u0003BCH\u000b+\u00032!TCI\u0013\r)\u0019j\u0012\u0002\b\u0005>|G.Z1o\u0011!)9\nPA\u0001\u0002\u0004Y\u0016a\u0001=%c\u0005A\u0001.Y:i\u0007>$W\r\u0006\u0002\u0006\u001eB\u0019Q*b(\n\u0007\u0015\u0005vIA\u0002J]R\fa!Z9vC2\u001cH\u0003BCH\u000bOC\u0001\"b&?\u0003\u0003\u0005\raW\u0001\b)V\u0004H.Z\u00199!\ti\u0005i\u0005\u0003A\u0019\u0006%BCACV\u0003\u0015\t\u0007\u000f\u001d7z+\u0019*),b/\u0006@\u0016\rWqYCf\u000b\u001f,\u0019.b6\u0006\\\u0016}W1]Ct\u000bW,y/b=\u0006x\u0016mXq \u000b'\u000bo3\tAb\u0001\u0007\u0006\u0019\u001da\u0011\u0002D\u0006\r\u001b1yA\"\u0005\u0007\u0014\u0019Uaq\u0003D\r\r71iBb\b\u0007\"\u0019\r\u0002CJ'\u0001\u000bs+i,\"1\u0006F\u0016%WQZCi\u000b+,I.\"8\u0006b\u0016\u0015X\u0011^Cw\u000bc,)0\"?\u0006~B\u0019A+b/\u0005\u000bY\u001b%\u0019A,\u0011\u0007Q+y\fB\u0003a\u0007\n\u0007q\u000bE\u0002U\u000b\u0007$QaY\"C\u0002]\u00032\u0001VCd\t\u001517I1\u0001X!\r!V1\u001a\u0003\u0006S\u000e\u0013\ra\u0016\t\u0004)\u0016=G!\u00027D\u0005\u00049\u0006c\u0001+\u0006T\u0012)qn\u0011b\u0001/B\u0019A+b6\u0005\u000bI\u001c%\u0019A,\u0011\u0007Q+Y\u000eB\u0003v\u0007\n\u0007q\u000bE\u0002U\u000b?$Q\u0001_\"C\u0002]\u00032\u0001VCr\t\u0015Y8I1\u0001X!\r!Vq\u001d\u0003\u0006}\u000e\u0013\ra\u0016\t\u0004)\u0016-HABA\u0002\u0007\n\u0007q\u000bE\u0002U\u000b_$a!!\u0003D\u0005\u00049\u0006c\u0001+\u0006t\u00121\u0011qB\"C\u0002]\u00032\u0001VC|\t\u0019\t)b\u0011b\u0001/B\u0019A+b?\u0005\r\u0005m1I1\u0001X!\r!Vq \u0003\u0007\u0003C\u0019%\u0019A,\t\u000f\u0005=2\t1\u0001\u0006:\"9\u0011QG\"A\u0002\u0015u\u0006bBA\u001e\u0007\u0002\u0007Q\u0011\u0019\u0005\b\u0003\u0003\u001a\u0005\u0019ACc\u0011\u001d\t9e\u0011a\u0001\u000b\u0013Dq!!\u0014D\u0001\u0004)i\rC\u0004\u0002T\r\u0003\r!\"5\t\u000f\u0005e3\t1\u0001\u0006V\"9\u0011qL\"A\u0002\u0015e\u0007bBA3\u0007\u0002\u0007QQ\u001c\u0005\b\u0003W\u001a\u0005\u0019ACq\u0011\u001d\t\th\u0011a\u0001\u000bKDq!a\u001eD\u0001\u0004)I\u000fC\u0004\u0002~\r\u0003\r!\"<\t\u000f\u0005\r5\t1\u0001\u0006r\"9\u0011\u0011R\"A\u0002\u0015U\bbBAH\u0007\u0002\u0007Q\u0011 \u0005\b\u0003+\u001b\u0005\u0019AC\u007f\u0003\u001d)h.\u00199qYf,bE\"\u000b\u00076\u0019ebQ\bD!\r\u000b2IE\"\u0014\u0007R\u0019Uc\u0011\fD/\rC2)G\"\u001b\u0007n\u0019EdQ\u000fD=)\u00111YCb\u001f\u0011\u000b53iC\"\r\n\u0007\u0019=rI\u0001\u0004PaRLwN\u001c\t'\u001b\u00021\u0019Db\u000e\u0007<\u0019}b1\tD$\r\u00172yEb\u0015\u0007X\u0019mcq\fD2\rO2YGb\u001c\u0007t\u0019]\u0004c\u0001+\u00076\u0011)a\u000b\u0012b\u0001/B\u0019AK\"\u000f\u0005\u000b\u0001$%\u0019A,\u0011\u0007Q3i\u0004B\u0003d\t\n\u0007q\u000bE\u0002U\r\u0003\"QA\u001a#C\u0002]\u00032\u0001\u0016D#\t\u0015IGI1\u0001X!\r!f\u0011\n\u0003\u0006Y\u0012\u0013\ra\u0016\t\u0004)\u001a5C!B8E\u0005\u00049\u0006c\u0001+\u0007R\u0011)!\u000f\u0012b\u0001/B\u0019AK\"\u0016\u0005\u000bU$%\u0019A,\u0011\u0007Q3I\u0006B\u0003y\t\n\u0007q\u000bE\u0002U\r;\"Qa\u001f#C\u0002]\u00032\u0001\u0016D1\t\u0015qHI1\u0001X!\r!fQ\r\u0003\u0007\u0003\u0007!%\u0019A,\u0011\u0007Q3I\u0007\u0002\u0004\u0002\n\u0011\u0013\ra\u0016\t\u0004)\u001a5DABA\b\t\n\u0007q\u000bE\u0002U\rc\"a!!\u0006E\u0005\u00049\u0006c\u0001+\u0007v\u00111\u00111\u0004#C\u0002]\u00032\u0001\u0016D=\t\u0019\t\t\u0003\u0012b\u0001/\"IaQ\u0010#\u0002\u0002\u0003\u0007a\u0011G\u0001\u0004q\u0012\u0002\u0014a\u0003:fC\u0012\u0014Vm]8mm\u0016$\"Ab!\u0011\t\u0005-gQQ\u0005\u0005\r\u000f\u000biM\u0001\u0004PE*,7\r\u001e")
public final class Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>
implements Product18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>,
Serializable {
    private final T1 _1;
    private final T2 _2;
    private final T3 _3;
    private final T4 _4;
    private final T5 _5;
    private final T6 _6;
    private final T7 _7;
    private final T8 _8;
    private final T9 _9;
    private final T10 _10;
    private final T11 _11;
    private final T12 _12;
    private final T13 _13;
    private final T14 _14;
    private final T15 _15;
    private final T16 _16;
    private final T17 _17;
    private final T18 _18;

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> Option<Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>> unapply(Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> tuple18) {
        return Tuple18$.MODULE$.unapply(tuple18);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> apply(T1 T1, T2 T2, T3 T3, T4 T4, T5 T5, T6 T6, T7 T7, T8 T8, T9 T9, T10 T10, T11 T11, T12 T12, T13 T13, T14 T14, T15 T15, T16 T16, T17 T17, T18 T18) {
        return Tuple18$.MODULE$.apply(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18);
    }

    @Override
    public int productArity() {
        return Product18.productArity$(this);
    }

    @Override
    public Object productElement(int n) throws IndexOutOfBoundsException {
        return Product18.productElement$(this, n);
    }

    @Override
    public T1 _1() {
        return this._1;
    }

    @Override
    public T2 _2() {
        return this._2;
    }

    @Override
    public T3 _3() {
        return this._3;
    }

    @Override
    public T4 _4() {
        return this._4;
    }

    @Override
    public T5 _5() {
        return this._5;
    }

    @Override
    public T6 _6() {
        return this._6;
    }

    @Override
    public T7 _7() {
        return this._7;
    }

    @Override
    public T8 _8() {
        return this._8;
    }

    @Override
    public T9 _9() {
        return this._9;
    }

    @Override
    public T10 _10() {
        return this._10;
    }

    @Override
    public T11 _11() {
        return this._11;
    }

    @Override
    public T12 _12() {
        return this._12;
    }

    @Override
    public T13 _13() {
        return this._13;
    }

    @Override
    public T14 _14() {
        return this._14;
    }

    @Override
    public T15 _15() {
        return this._15;
    }

    @Override
    public T16 _16() {
        return this._16;
    }

    @Override
    public T17 _17() {
        return this._17;
    }

    @Override
    public T18 _18() {
        return this._18;
    }

    public String toString() {
        return new StringBuilder(19).append("(").append(this._1()).append(",").append(this._2()).append(",").append(this._3()).append(",").append(this._4()).append(",").append(this._5()).append(",").append(this._6()).append(",").append(this._7()).append(",").append(this._8()).append(",").append(this._9()).append(",").append(this._10()).append(",").append(this._11()).append(",").append(this._12()).append(",").append(this._13()).append(",").append(this._14()).append(",").append(this._15()).append(",").append(this._16()).append(",").append(this._17()).append(",").append(this._18()).append(")").toString();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> copy(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6, T7 _7, T8 _8, T9 _9, T10 _10, T11 _11, T12 _12, T13 _13, T14 _14, T15 _15, T16 _16, T17 _17, T18 _18) {
        return new Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18);
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> T1 copy$default$1() {
        return this._1();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> T10 copy$default$10() {
        return this._10();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> T11 copy$default$11() {
        return this._11();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> T12 copy$default$12() {
        return this._12();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> T13 copy$default$13() {
        return this._13();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> T14 copy$default$14() {
        return this._14();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> T15 copy$default$15() {
        return this._15();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> T16 copy$default$16() {
        return this._16();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> T17 copy$default$17() {
        return this._17();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> T18 copy$default$18() {
        return this._18();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> T2 copy$default$2() {
        return this._2();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> T3 copy$default$3() {
        return this._3();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> T4 copy$default$4() {
        return this._4();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> T5 copy$default$5() {
        return this._5();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> T6 copy$default$6() {
        return this._6();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> T7 copy$default$7() {
        return this._7();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> T8 copy$default$8() {
        return this._8();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> T9 copy$default$9() {
        return this._9();
    }

    @Override
    public String productPrefix() {
        return "Tuple18";
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof Tuple18;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof Tuple18;
                if (!bl) break block3;
                Tuple18 tuple18 = (Tuple18)x$1;
                if (!(BoxesRunTime.equals(this._1(), tuple18._1()) && BoxesRunTime.equals(this._2(), tuple18._2()) && BoxesRunTime.equals(this._3(), tuple18._3()) && BoxesRunTime.equals(this._4(), tuple18._4()) && BoxesRunTime.equals(this._5(), tuple18._5()) && BoxesRunTime.equals(this._6(), tuple18._6()) && BoxesRunTime.equals(this._7(), tuple18._7()) && BoxesRunTime.equals(this._8(), tuple18._8()) && BoxesRunTime.equals(this._9(), tuple18._9()) && BoxesRunTime.equals(this._10(), tuple18._10()) && BoxesRunTime.equals(this._11(), tuple18._11()) && BoxesRunTime.equals(this._12(), tuple18._12()) && BoxesRunTime.equals(this._13(), tuple18._13()) && BoxesRunTime.equals(this._14(), tuple18._14()) && BoxesRunTime.equals(this._15(), tuple18._15()) && BoxesRunTime.equals(this._16(), tuple18._16()) && BoxesRunTime.equals(this._17(), tuple18._17()) && BoxesRunTime.equals(this._18(), tuple18._18()))) break block3;
            }
            return true;
        }
        return false;
    }

    public Tuple18(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6, T7 _7, T8 _8, T9 _9, T10 _10, T11 _11, T12 _12, T13 _13, T14 _14, T15 _15, T16 _16, T17 _17, T18 _18) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this._5 = _5;
        this._6 = _6;
        this._7 = _7;
        this._8 = _8;
        this._9 = _9;
        this._10 = _10;
        this._11 = _11;
        this._12 = _12;
        this._13 = _13;
        this._14 = _14;
        this._15 = _15;
        this._16 = _16;
        this._17 = _17;
        this._18 = _18;
        Product.$init$(this);
        Product18.$init$(this);
    }
}

