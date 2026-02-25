/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.api;

import scala.Function0;
import scala.Function1;
import scala.Option;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.Seq;
import scala.collection.immutable.List;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Annotations;
import scala.reflect.api.Constants;
import scala.reflect.api.Internals;
import scala.reflect.api.Names;
import scala.reflect.api.Scopes;
import scala.reflect.api.Symbols;
import scala.reflect.api.Universe;
import scala.runtime.BoxedUnit;

@ScalaSignature(bytes="\u0006\u0001\u0019\u001dc\u0001DA4\u0003S\u0002\n1!\u0001\u0002x\u0019}\u0002bBAA\u0001\u0011\u0005\u00111\u0011\u0003\b\u0003\u0017\u0003!\u0011AAG\u0011%\u00119\r\u0001b\u0001\u000e\u0003\ty\u0010C\u0005\u0003J\u0002\u0011\rQ\"\u0001\u0002\u0000\u001a9\u0011q\u0014\u0001\u0002\u0002\u0005\u0005\u0006bBAR\u000b\u0011\u0005\u0011Q\u0015\u0005\b\u0003O+a\u0011AAU\u0011\u001d\t),\u0002D\u0001\u0003SCq!a.\u0006\r\u0003\tI\fC\u0004\u0002Z\u00161\t!a7\t\u000f\u0005}WA\"\u0001\u0002b\"9\u00111_\u0003\u0007\u0002\u0005\u0005\bbBA{\u000b\u0019\u0005\u0011q\u001f\u0005\b\u0003w,a\u0011AAq\u0011\u001d\ti0\u0002D\u0001\u0003\u007fDqAa\u0001\u0006\r\u0003\u0011)\u0001C\u0004\u0003\u000e\u00151\t!a@\t\u000f\t=QA\"\u0001\u0002\u0000\"9!qC\u0003\u0007\u0002\u0005}\bb\u0002B\r\u000b\u0019\u0005!1\u0004\u0005\b\u0005C)a\u0011\u0001B\u0012\u0011\u001d\u00119#\u0002D\u0001\u0005SAqA!\f\u0006\r\u0003\u0011y\u0003C\u0004\u0003@\u00151\tA!\u0011\t\u000f\t\u001dSA\"\u0001\u0003J!9!\u0011K\u0003\u0007\u0002\u0005}\bb\u0002B*\u000b\u0019\u0005\u0011q \u0005\b\u0005+*a\u0011AA\u0000\u0011\u001d\u00119&\u0002D\u0001\u00053BqA!\u0018\u0006\r\u0003\u0011y\u0006C\u0004\u0003j\u00151\tAa\u0018\t\u000f\t-TA\"\u0001\u00030!9!QN\u0003\u0007\u0002\u0005}\bb\u0002B8\u000b\u0019\u0005\u0011q \u0005\b\u0005c*a\u0011\u0001B:\u0011\u001d\u0011y(\u0002D\u0001\u0005\u0003CqAa#\u0006\r\u0003\u0011i\tC\u0004\u0003\u0014\u00161\tA!&\t\u000f\t\u0005VA\"\u0001\u0003$\"9!\u0011V\u0003\u0007\u0002\t-\u0006b\u0002B]\u000b\u0019\u0005!1\u0018\u0005\b\u0005\u007f+a\u0011\u0001Ba\t\u001d\u0011Y\r\u0001B\u0001\u0005\u001b4\u0011B!6\u0001!\u0003\r\nAa6\u0005\u000f\te\u0007A!\u0001\u0003\\\"I!1\u001e\u0001C\u0002\u001b\u0005!Q\u001e\u0004\b\u0005c\u0004\u0011\u0011\u0001Bz\u0011\u001d\t\u0019k\fC\u0001\u0005kDqAa>0\r\u0003\u0011I\u0010C\u0004\u0004\u0002=\"\taa\u0001\u0007\u0017\t\r\b\u0001%A\u0012\u0002\t\u0015(q\u001d\u0005\b\u0005\u000b\u001cd\u0011AAU\t\u001d\u0019i\u0002\u0001B\u0001\u0007?A\u0011b!\f\u0001\u0005\u00045\taa\f\u0007\u000f\rM\u0002!!\u0001\u00046!9\u00111U\u001c\u0005\u0002\r]\u0002b\u0002B|o\u0019\u00051\u0011\b\u0005\b\u0007\u00039D\u0011AB#\r-\u00199\u0003\u0001I\u0001$\u0003\u0019Ica\u000b\t\u000f\t53H\"\u0001\u0002\u0000\"9!QY\u001e\u0007\u0002\u0005%FaBB+\u0001\t\u00051q\u000b\u0005\n\u0007S\u0002!\u0019!D\u0001\u0007W2qaa\u001c\u0001\u0003\u0003\u0019\t\bC\u0004\u0002$\u0002#\taa\u001d\t\u000f\t]\bI\"\u0001\u0004v!91\u0011\u0001!\u0005\u0002\rudaCB0\u0001A\u0005\u0019\u0013AB1\u0007OBqaa\u0019E\r\u0003\ty\u0010C\u0004\u0004f\u00113\t!a@\u0005\u000f\r5\u0005A!\u0001\u0004\u0010\"I11\u0016\u0001C\u0002\u001b\u00051Q\u0016\u0004\b\u0007c\u0003\u0011\u0011ABZ\u0011\u001d\t\u0019+\u0013C\u0001\u0007kCqAa>J\r\u0003\u00199\fC\u0004\u0004\u0002%#\ta!0\u0007\u0017\r]\u0005\u0001%A\u0012\u0002\re5\u0011\u0016\u0005\b\u00077ke\u0011ABO\t\u001d\u0019Y\r\u0001B\u0001\u0007\u001bD\u0011b!8\u0001\u0005\u00045\taa8\u0007\u000f\r\r\b!!\u0001\u0004f\"9\u00111U)\u0005\u0002\r\u001d\bb\u0002B|#\u001a\u00051\u0011\u001e\u0005\b\u0007\u0003\tF\u0011AB{\r-\u0019)\u000e\u0001I\u0001$\u0003\u00199na7\t\u000f\t5SK\"\u0001\u0002\u0000\"9!QY+\u0007\u0002\u0005%\u0006bBBm+\u001a\u0005!\u0011\f\u0003\b\t\u000f\u0001!\u0011\u0001C\u0005\r%!\t\u0002\u0001I\u0001$\u0003!\u0019\u0002B\u0004\u0005\u0016\u0001\u0011\t\u0001b\u0006\t\u0013\u0011%\u0002A1A\u0007\u0002\u0011-ba\u0002C\u0018\u0001\u0005\u0005A\u0011\u0007\u0005\b\u0003GkF\u0011\u0001C\u001a\u0011\u001d\u001190\u0018D\u0001\tkAqa!\u0001^\t\u0003!\u0019\u0005C\u0004\u0004\u0002u#\t\u0001b\u0015\u0007\u0017\u0011}\u0001\u0001%A\u0012\u0002\u0011\u0005BQ\u0005\u0005\b\tG\u0011g\u0011\u0001B-\u0011\u001d\t\u0019P\u0019D\u0001\u0003C$q\u0001\"\u0019\u0001\u0005\u0003!\u0019\u0007C\u0005\u0005r\u0001\u0011\rQ\"\u0001\u0005t\u00199Aq\u000f\u0001\u0002\u0002\u0011e\u0004bBARO\u0012\u0005A1\u0010\u0005\b\u0005o<g\u0011\u0001C?\u0011\u001d\u0019\ta\u001aC\u0001\t\u000b31\u0002b\u001b\u0001!\u0003\r\n\u0001\"\u001c\u0005p!9A1E6\u0007\u0002\te\u0003bBAzW\u001a\u0005\u0011\u0011\u001d\u0005\b\u0003k[g\u0011AAU\t\u001d!9\n\u0001B\u0001\t3C\u0011\u0002\"+\u0001\u0005\u00045\t\u0001b+\u0007\u000f\u0011=\u0006!!\u0001\u00052\"9\u00111U9\u0005\u0002\u0011M\u0006b\u0002B|c\u001a\u0005AQ\u0017\u0005\b\u0007\u0003\tH\u0011\u0001C_\r-!\t\u000b\u0001I\u0001$\u0003!\u0019\u000bb*\t\u000f\u0011\u0015VO\"\u0001\u00030!9!QN;\u0007\u0002\u0005}Ha\u0002Cg\u0001\t\u0005Aq\u001a\u0005\n\t;\u0004!\u0019!D\u0001\t?4q\u0001b9\u0001\u0003\u0003!)\u000fC\u0004\u0002$j$\t\u0001b:\t\u000f\t](P\"\u0001\u0005j\"91\u0011\u0001>\u0005\u0002\u00115ha\u0003Cl\u0001A\u0005\u0019\u0013\u0001Cm\t7DqA!\u001c\u007f\r\u0003\ty\u0010B\u0004\u0005|\u0002\u0011\t\u0001\"@\t\u0013\u0015-\u0001A1A\u0007\u0002\u00155aaBC\t\u0001\u0005\u0005Q1\u0003\u0005\t\u0003G\u000b)\u0001\"\u0001\u0006\u0016!A!q_A\u0003\r\u0003)9\u0002\u0003\u0005\u0004\u0002\u0005\u0015A\u0011AC\u000e\r-))\u0001\u0001I\u0001$\u0003)9!\"\u0003\t\u0011\t-\u0014Q\u0002D\u0001\u0005_A\u0001B!\u001c\u0002\u000e\u0019\u0005\u0011q \u0003\b\u000bW\u0001!\u0011AC\u0017\u0011%)y\u0004\u0001b\u0001\u000e\u0003)\tEB\u0004\u0006F\u0001\t\t!b\u0012\t\u0011\u0005\r\u0016q\u0003C\u0001\u000b\u0013B\u0001Ba>\u0002\u0018\u0019\u0005Q1\n\u0005\t\u0007\u0003\t9\u0002\"\u0001\u0006P\u0019YQQ\u0007\u0001\u0011\u0002G\u0005QqGC\u001f\u0011!)I$a\b\u0007\u0002\t=\u0002\u0002CC\u001e\u0003?1\t!a@\u0005\u000f\u0015}\u0003A!\u0001\u0006b!IQq\u0010\u0001C\u0002\u001b\u0005Q\u0011\u0011\u0004\b\u000b\u000b\u0003\u0011\u0011ACD\u0011!\t\u0019+!\u000b\u0005\u0002\u0015%\u0005\u0002\u0003B|\u0003S1\t!b#\t\u0011\r\u0005\u0011\u0011\u0006C\u0001\u000b'31\"\"\u001b\u0001!\u0003\r\n!b\u001b\u0006~!AQQNA\u0019\r\u0003)y\u0007\u0003\u0005\u0006<\u0005Eb\u0011AA\u0000\t\u001d)\u0019\u000b\u0001B\u0001\u000bKC\u0011\"b.\u0001\u0005\u00045\t!\"/\u0007\u000f\u0015u\u0006!!\u0001\u0006@\"A\u00111UA\u001e\t\u0003)\t\r\u0003\u0005\u0003x\u0006mb\u0011ACb\u0011!\u0019\t!a\u000f\u0005\u0002\u0015\u001dgaCCW\u0001A\u0005\u0019\u0013ACX\u000bkC\u0001\"\"-\u0002D\u0019\u0005\u0011q \u0005\t\u000bg\u000b\u0019E\"\u0001\u0002\u0000\"IQq\u001b\u0001C\u0002\u001b\u0005\u0011q \u0003\b\u000b3\u0004!\u0011ACn\u0011%)i\u000f\u0001b\u0001\u000e\u0003)yOB\u0004\u0006t\u0002\t\t!\">\t\u0011\u0005\r\u0016q\nC\u0001\u000boD\u0001Ba>\u0002P\u0019\u0005Q\u0011 \u0005\t\u0007\u0003\ty\u0005\"\u0001\u0006\u0000\u001aYQ1\u001d\u0001\u0011\u0002G\u0005QQ]Cv\u0011!)9/a\u0016\u0007\u0002\u0015%\bb\u0002D\u0007\u0001\u0019\u0005aq\u0002\u0005\b\r+\u0001a\u0011\u0001D\f\u0011\u001d1i\u0002\u0001D\u0001\r?AqA\"\b\u0001\r\u000319\u0003C\u0004\u0007\u001e\u00011\tAb\r\t\u000f\u0019u\u0001A\"\u0001\u0007:\t)A+\u001f9fg*!\u00111NA7\u0003\r\t\u0007/\u001b\u0006\u0005\u0003_\n\t(A\u0004sK\u001adWm\u0019;\u000b\u0005\u0005M\u0014!B:dC2\f7\u0001A\n\u0004\u0001\u0005e\u0004\u0003BA>\u0003{j!!!\u001d\n\t\u0005}\u0014\u0011\u000f\u0002\u0007\u0003:L(+\u001a4\u0002\r\u0011Jg.\u001b;%)\t\t)\t\u0005\u0003\u0002|\u0005\u001d\u0015\u0002BAE\u0003c\u0012A!\u00168ji\n!A+\u001f9f#\u0011\ty)!&\u0011\t\u0005m\u0014\u0011S\u0005\u0005\u0003'\u000b\tH\u0001\u0003Ok2d'CBAL\u0003s\nYJ\u0002\u0004\u0002\u001a\u0002\u0001\u0011Q\u0013\u0002\ryI,g-\u001b8f[\u0016tGO\u0010\t\u0004\u0003;+Q\"\u0001\u0001\u0003\u000fQK\b/Z!qSN\u0019Q!!\u001f\u0002\rqJg.\u001b;?)\t\tY*\u0001\u0006uKJl7+_7c_2,\"!a+\u0011\t\u0005u\u0015QV\u0005\u0005\u0003_\u000b\tL\u0001\u0004Ts6\u0014w\u000e\\\u0005\u0005\u0003g\u000bIGA\u0004Ts6\u0014w\u000e\\:\u0002\u0015QL\b/Z*z[\n|G.A\u0006eK\u000ed\u0017M]1uS>tG\u0003BAV\u0003wCq!!0\n\u0001\u0004\ty,\u0001\u0003oC6,\u0007\u0003BAO\u0003\u0003LA!a1\u0002F\n!a*Y7f\u0013\u0011\t9-!\u001b\u0003\u000b9\u000bW.Z:)\u000f%\tY-!5\u0002VB!\u00111PAg\u0013\u0011\ty-!\u001d\u0003\u0015\u0011,\u0007O]3dCR,G-\t\u0002\u0002T\u0006\u0011Ro]3!A\u0012,7\r\u001c1!S:\u001cH/Z1eC\t\t9.\u0001\u00043]E\nd\u0006M\u0001\u0005I\u0016\u001cG\u000e\u0006\u0003\u0002,\u0006u\u0007bBA_\u0015\u0001\u0007\u0011qX\u0001\rI\u0016\u001cG.\u0019:bi&|gn]\u000b\u0003\u0003G\u0004B!!(\u0002f&!\u0011q]Au\u0005-iU-\u001c2feN\u001bw\u000e]3\n\t\u0005-\u0018\u0011\u000e\u0002\u0007'\u000e|\u0007/Z:)\u000f-\tY-a<\u0002V\u0006\u0012\u0011\u0011_\u0001\u0014kN,\u0007\u0005\u00193fG2\u001c\b\rI5ogR,\u0017\rZ\u0001\u0006I\u0016\u001cGn]\u0001\u0007[\u0016l'-\u001a:\u0015\t\u0005-\u0016\u0011 \u0005\b\u0003{k\u0001\u0019AA`\u0003\u001diW-\u001c2feN\f\u0011bY8na\u0006t\u0017n\u001c8\u0016\u0005\t\u0005\u0001cAAO\u0005\u0005iA/Y6fgRK\b/Z!sON,\"Aa\u0002\u0011\t\u0005m$\u0011B\u0005\u0005\u0005\u0017\t\tHA\u0004C_>dW-\u00198\u0002\u001fQL\b/Z\"p]N$(/^2u_J\f\u0011B\\8s[\u0006d\u0017N_3)\u000fI\tYMa\u0005\u0002V\u0006\u0012!QC\u0001%kN,\u0007\u0005\u00193fC2L\u0017m\u001d1!_J\u0004\u0003-\u001a;b\u000bb\u0004\u0018M\u001c3aA%t7\u000f^3bI\u0006IQ\r^1FqB\fg\u000eZ\u0001\u0011I1,7o\u001d\u0013d_2|g\u000e\n7fgN$BAa\u0002\u0003\u001e!9!q\u0004\u000bA\u0002\t\u0005\u0011\u0001\u0002;iCR\fQc^3bW~#C.Z:tI\r|Gn\u001c8%Y\u0016\u001c8\u000f\u0006\u0003\u0003\b\t\u0015\u0002b\u0002B\u0010+\u0001\u0007!\u0011A\u0001\rI\u0015\fHeY8m_:$S-\u001d\u000b\u0005\u0005\u000f\u0011Y\u0003C\u0004\u0003 Y\u0001\rA!\u0001\u0002\u0017\t\f7/Z\"mCN\u001cXm]\u000b\u0003\u0005c\u0001bAa\r\u0003:\u0005-f\u0002BA>\u0005kIAAa\u000e\u0002r\u00059\u0001/Y2lC\u001e,\u0017\u0002\u0002B\u001e\u0005{\u0011A\u0001T5ti*!!qGA9\u0003!\u0011\u0017m]3UsB,G\u0003\u0002B\u0001\u0005\u0007BqA!\u0012\u0019\u0001\u0004\tY+A\u0003dY\u0006T(0\u0001\u0006bgN+WM\u001c$s_6$bA!\u0001\u0003L\t=\u0003b\u0002B'3\u0001\u0007!\u0011A\u0001\u0004aJ,\u0007b\u0002B#3\u0001\u0007\u00111V\u0001\bKJ\f7/\u001e:f\u0003\u00159\u0018\u000eZ3o\u0003\u001d!W-\u00197jCN\f\u0001\u0002^=qK\u0006\u0013xm]\u000b\u0003\u00057\u0002bAa\r\u0003:\t\u0005\u0011a\u00029be\u0006l7o]\u000b\u0003\u0005C\u0002bAa\r\u0003:\tE\u0002f\u0002\u0010\u0002L\n\u0015\u0014Q[\u0011\u0003\u0005O\n\u0001$^:fA\u0001\u0004\u0018M]1n\u0019&\u001cHo\u001d1!S:\u001cH/Z1e\u0003)\u0001\u0018M]1n\u0019&\u001cHo]\u0001\u000bif\u0004X\rU1sC6\u001c\u0018A\u0003:fgVdG\u000fV=qK\u0006ya-\u001b8bYJ+7/\u001e7u)f\u0004X-\u0001\u0004pe\u0016c7/\u001a\u000b\u0005\u0005\u0003\u0011)\b\u0003\u0005\u0003x\r\"\t\u0019\u0001B=\u0003\r\tG\u000e\u001e\t\u0007\u0003w\u0012YH!\u0001\n\t\tu\u0014\u0011\u000f\u0002\ty\tLh.Y7f}\u0005\t2/\u001e2ti&$X\u000f^3Ts6\u0014w\u000e\\:\u0015\r\t\u0005!1\u0011BD\u0011\u001d\u0011)\t\na\u0001\u0005c\tAA\u001a:p[\"9!\u0011\u0012\u0013A\u0002\tE\u0012A\u0001;p\u0003=\u0019XOY:uSR,H/\u001a+za\u0016\u001cHC\u0002B\u0001\u0005\u001f\u0013\t\nC\u0004\u0003\u0006\u0016\u0002\rA!\r\t\u000f\t%U\u00051\u0001\u0003\\\u0005\u0019Q.\u00199\u0015\t\t\u0005!q\u0013\u0005\b\u000533\u0003\u0019\u0001BN\u0003\u00051\u0007\u0003CA>\u0005;\u0013\tA!\u0001\n\t\t}\u0015\u0011\u000f\u0002\n\rVt7\r^5p]F\nqAZ8sK\u0006\u001c\u0007\u000e\u0006\u0003\u0002\u0006\n\u0015\u0006b\u0002BMO\u0001\u0007!q\u0015\t\t\u0003w\u0012iJ!\u0001\u0002\u0006\u0006!a-\u001b8e)\u0011\u0011iKa-\u0011\r\u0005m$q\u0016B\u0001\u0013\u0011\u0011\t,!\u001d\u0003\r=\u0003H/[8o\u0011\u001d\u0011)\f\u000ba\u0001\u0005o\u000b\u0011\u0001\u001d\t\t\u0003w\u0012iJ!\u0001\u0003\b\u00051Q\r_5tiN$BAa\u0002\u0003>\"9!QW\u0015A\u0002\t]\u0016\u0001C2p]R\f\u0017N\\:\u0015\t\t\u001d!1\u0019\u0005\b\u0005\u000bT\u0003\u0019AAV\u0003\r\u0019\u00180\\\u0001\u0007\u001d>$\u0016\u0010]3\u0002\u00119{\u0007K]3gSb\u0014QbU5oO2,Go\u001c8UsB,\u0017\u0003BAH\u0005\u001f\u0014bA!5\u0003T\n\u0005aABAM\u0001\u0001\u0011y\rE\u0002\u0002\u001e2\u0012\u0001cU5oO2,Go\u001c8UsB,\u0017\t]5\u0014\u00071\nIH\u0001\u0005UQ&\u001cH+\u001f9f#\u0011\tyI!8\u0013\r\t}'\u0011\u001dBu\r\u0019\tI\n\u0001\u0001\u0003^B\u0019\u0011QT\u001a\u0003\u0017QC\u0017n\u001d+za\u0016\f\u0005/[\n\u0004g\u0005m\u0005cAAO[A\u0019\u0011QT\u0016\u0002\u0011QC\u0017n\u001d+za\u0016,\"Aa<\u0011\u0007\u0005uuFA\tUQ&\u001cH+\u001f9f\u000bb$(/Y2u_J\u001c2aLA=)\t\u0011y/A\u0004v]\u0006\u0004\b\u000f\\=\u0015\t\tm(Q \t\u0007\u0003w\u0012y+a+\t\u000f\t}\u0018\u00071\u0001\u0003h\u0006\u0019A\u000f]3\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\t\r\u00151Q\u0003\u000b\u0005\u0005\u0003\u00199\u0001C\u0004\u0004\nI\u0002\u001daa\u0003\u0002\u000bQ|7.\u001a8\u0011\t\u0005u5QB\u0005\u0005\u0007\u001f\u0019\tBA\u0006D_6\u0004\u0018\r\u001e+pW\u0016t\u0017\u0002BB\n\u0003S\u0012\u0011\"\u00138uKJt\u0017\r\\:\t\u000f\t\u0015'\u00071\u0001\u0002,\":!'a3\u0004\u001a\u0005U\u0017EAB\u000e\u0003})8/\u001a\u0011aS:$XM\u001d8bY:\"\b.[:UsB,\u0007\rI5ogR,\u0017\r\u001a\u0002\u000b'&tw\r\\3UsB,\u0017\u0003BAH\u0007C\u0011baa\t\u0004&\t%hABAM\u0001\u0001\u0019\t\u0003E\u0002\u0002\u001en\u0012QbU5oO2,G+\u001f9f\u0003BL7cA\u001e\u0002\u001cB\u0019\u0011QT\u001b\u0002\u0015MKgn\u001a7f)f\u0004X-\u0006\u0002\u00042A\u0019\u0011QT\u001c\u0003'MKgn\u001a7f)f\u0004X-\u0012=ue\u0006\u001cGo\u001c:\u0014\u0007]\nI\b\u0006\u0002\u00042Q!11HB\"!\u0019\tYHa,\u0004>AA\u00111PB \u0005\u0003\tY+\u0003\u0003\u0004B\u0005E$A\u0002+va2,'\u0007C\u0004\u0003\u0000f\u0002\raa\u000b\u0015\r\r\u001d31JB')\u0011\u0011\ta!\u0013\t\u000f\r%!\bq\u0001\u0004\f!9!Q\n\u001eA\u0002\t\u0005\u0001b\u0002Bcu\u0001\u0007\u00111\u0016\u0015\bu\u0005-7\u0011KAkC\t\u0019\u0019&A\u001fvg\u0016\u0004\u0003m\u00117bgN\u001c\u00160\u001c2pY:\"\b.[:Qe\u00164\u0017\u000e\u001f1!_J\u0004\u0003-\u001b8uKJt\u0017\r\u001c\u0018tS:<G.\u001a+za\u0016\u0004\u0007%\u001b8ti\u0016\fGMA\u0005TkB,'\u000fV=qKF!\u0011qRB-%\u0019\u0019Yf!\u0018\u0003j\u001a1\u0011\u0011\u0014\u0001\u0001\u00073\u00022!!(E\u00051\u0019V\u000f]3s)f\u0004X-\u00119j'\r!\u00151T\u0001\bi\"L7\u000f\u001e9f\u0003!\u0019X\u000f]3siB,\u0007cAAO}\u0005I1+\u001e9feRK\b/Z\u000b\u0003\u0007[\u00022!!(A\u0005I\u0019V\u000f]3s)f\u0004X-\u0012=ue\u0006\u001cGo\u001c:\u0014\u0007\u0001\u000bI\b\u0006\u0002\u0004nQ!1qOB>!\u0019\tYHa,\u0004zAA\u00111PB \u0005\u0003\u0011\t\u0001C\u0004\u0003\u0000\n\u0003\raa\u001a\u0015\r\r}41QBC)\u0011\u0011\ta!!\t\u000f\r%1\tq\u0001\u0004\f!911M\"A\u0002\t\u0005\u0001bBB3\u0007\u0002\u0007!\u0011\u0001\u0015\b\u0007\u0006-7\u0011RAkC\t\u0019Y)A\u001fvg\u0016\u0004\u0003m\u00117bgN\u001c\u00160\u001c2pY:\u001aX\u000f]3s!J,g-\u001b=aA=\u0014\b\u0005Y5oi\u0016\u0014h.\u00197/gV\u0004XM\u001d+za\u0016\u0004\u0007%\u001b8ti\u0016\fGM\u0001\u0007D_:\u001cH/\u00198u)f\u0004X-\u0005\u0003\u0002\u0010\u000eE%CBBJ\u0007+\u0013IO\u0002\u0004\u0002\u001a\u0002\u00011\u0011\u0013\t\u0004\u0003;k%aD\"p]N$\u0018M\u001c;UsB,\u0017\t]5\u0014\u00075\u000bY*A\u0003wC2,X-\u0006\u0002\u0004 B!\u0011QTBQ\u0013\u0011\u0019\u0019k!*\u0003\u0011\r{gn\u001d;b]RLAaa*\u0002j\tI1i\u001c8ti\u0006tGo\u001d\t\u0004\u0003;;\u0015\u0001D\"p]N$\u0018M\u001c;UsB,WCABX!\r\ti*\u0013\u0002\u0016\u0007>t7\u000f^1oiRK\b/Z#yiJ\f7\r^8s'\rI\u0015\u0011\u0010\u000b\u0003\u0007_#Ba!/\u0004<B1\u00111\u0010BX\u0007?CqAa@L\u0001\u0004\u0019I\u000b\u0006\u0003\u0004@\u000e\rG\u0003BBU\u0007\u0003Dqa!\u0003M\u0001\b\u0019Y\u0001C\u0004\u0004\u001c2\u0003\raa()\u000f1\u000bYma2\u0002V\u0006\u00121\u0011Z\u00013kN,\u0007\u0005\u0019<bYV,g\u0006\u001e9fA\u0002z'\u000f\t1j]R,'O\\1m]\r|gn\u001d;b]R$\u0016\u0010]3aA%t7\u000f^3bI\n9A+\u001f9f%\u00164\u0017\u0003BAH\u0007\u001f\u0014ba!5\u0004T\n\u0005aABAM\u0001\u0001\u0019y\rE\u0002\u0002\u001eV\u0013!\u0002V=qKJ+g-\u00119j'\r)\u00161T\u0001\u0005CJ<7\u000fE\u0002\u0002\u001e>\u000bq\u0001V=qKJ+g-\u0006\u0002\u0004bB\u0019\u0011QT)\u0003!QK\b/\u001a*fM\u0016CHO]1di>\u00148cA)\u0002zQ\u00111\u0011\u001d\u000b\u0005\u0007W\u001c\u0019\u0010\u0005\u0004\u0002|\t=6Q\u001e\t\u000b\u0003w\u001ayO!\u0001\u0002,\nm\u0013\u0002BBy\u0003c\u0012a\u0001V;qY\u0016\u001c\u0004b\u0002B\u0000'\u0002\u000711\u001c\u000b\t\u0007o\u001cYp!@\u0004\u0000R!!\u0011AB}\u0011\u001d\u0019I\u0001\u0016a\u0002\u0007\u0017AqA!\u0014U\u0001\u0004\u0011\t\u0001C\u0004\u0003FR\u0003\r!a+\t\u000f\reG\u000b1\u0001\u0003\\!:A+a3\u0005\u0004\u0005U\u0017E\u0001C\u0003\u0003y)8/\u001a\u0011aS:$XM\u001d8bY:\"\u0018\u0010]3SK\u001a\u0004\u0007%\u001b8ti\u0016\fGM\u0001\u0007D_6\u0004x.\u001e8e)f\u0004X-\u0005\u0003\u0002\u0010\u0012-!C\u0002C\u0007\t\u001f\u0011\tA\u0002\u0004\u0002\u001a\u0002\u0001A1\u0002\t\u0004\u0003;S&aD\"p[B|WO\u001c3UsB,\u0017\t]5\u0014\u0007i\u000bIHA\u0006SK\u001aLg.\u001a3UsB,\u0017\u0003BAH\t3\u0011b\u0001b\u0007\u0005\u001e\u0011\u001dbABAM\u0001\u0001!I\u0002E\u0002\u0002\u001e\n\u0014aBU3gS:,G\rV=qK\u0006\u0003\u0018nE\u0002c\u00037\u000bq\u0001]1sK:$8\u000fE\u0002\u0002\u001en\u00032!!(Z\u0003-\u0011VMZ5oK\u0012$\u0016\u0010]3\u0016\u0005\u00115\u0002cAAO;\n!\"+\u001a4j]\u0016$G+\u001f9f\u000bb$(/Y2u_J\u001c2!XA=)\t!i\u0003\u0006\u0003\u00058\u0011\u0005\u0003CBA>\u0005_#I\u0004\u0005\u0005\u0002|\r}\"1\fC\u001e!\u0011\ti\n\"\u0010\n\t\u0011}\u0012\u0011\u001e\u0002\u0006'\u000e|\u0007/\u001a\u0005\b\u0005\u007f|\u0006\u0019\u0001C\u0013)\u0019!)\u0005\"\u0013\u0005LQ!AQ\u0005C$\u0011\u001d\u0019I\u0001\u0019a\u0002\u0007\u0017Aq\u0001b\ta\u0001\u0004\u0011Y\u0006C\u0004\u0002t\u0002\u0004\r\u0001b\u000f)\u000f\u0001\fY\rb\u0014\u0002V\u0006\u0012A\u0011K\u0001#kN,\u0007\u0005Y5oi\u0016\u0014h.\u00197/e\u00164\u0017N\\3e)f\u0004X\r\u0019\u0011j]N$X-\u00193\u0015\u0011\u0011UC\u0011\fC.\t;\"B\u0001\"\n\u0005X!91\u0011B1A\u0004\r-\u0001b\u0002C\u0012C\u0002\u0007!1\f\u0005\b\u0003g\f\u0007\u0019\u0001C\u001e\u0011\u001d\u0011)%\u0019a\u0001\u0003WCs!YAf\t\u001f\n)NA\u0007DY\u0006\u001c8/\u00138g_RK\b/Z\t\u0005\u0003\u001f#)G\u0005\u0004\u0005h\u0011%Dq\u0005\u0004\u0007\u00033\u0003\u0001\u0001\"\u001a\u0011\u0007\u0005u5N\u0001\tDY\u0006\u001c8/\u00138g_RK\b/Z!qSN\u00191.a'\u0011\u0007\u0005uU-A\u0007DY\u0006\u001c8/\u00138g_RK\b/Z\u000b\u0003\tk\u00022!!(h\u0005Y\u0019E.Y:t\u0013:4w\u000eV=qK\u0016CHO]1di>\u00148cA4\u0002zQ\u0011AQ\u000f\u000b\u0005\t\u007f\"\u0019\t\u0005\u0004\u0002|\t=F\u0011\u0011\t\u000b\u0003w\u001ayOa\u0017\u0005<\u0005-\u0006b\u0002B\u0000S\u0002\u0007Aq\u000e\u000b\t\t\u000f#Y\t\"$\u0005\u0010R!Aq\u000eCE\u0011\u001d\u0019IA\u001ba\u0002\u0007\u0017Aq\u0001b\tk\u0001\u0004\u0011Y\u0006C\u0004\u0002t*\u0004\r\u0001b\u000f\t\u000f\u0005U&\u000e1\u0001\u0002,\":!.a3\u0005\u0014\u0006U\u0017E\u0001CK\u0003\u0011*8/\u001a\u0011aS:$XM\u001d8bY:\u001aG.Y:t\u0013:4w\u000eV=qK\u0002\u0004\u0013N\\:uK\u0006$'AC'fi\"|G\rV=qKF!\u0011q\u0012CN%\u0019!i\nb(\u0003\u0002\u00191\u0011\u0011\u0014\u0001\u0001\t7\u00032!!(v\u00055iU\r\u001e5pIRK\b/Z!qSN\u0019Q/a'\u0002\rA\f'/Y7t!\r\tij\\\u0001\u000b\u001b\u0016$\bn\u001c3UsB,WC\u0001CW!\r\ti*\u001d\u0002\u0014\u001b\u0016$\bn\u001c3UsB,W\t\u001f;sC\u000e$xN]\n\u0004c\u0006eDC\u0001CW)\u0011!9\fb/\u0011\r\u0005m$q\u0016C]!!\tYha\u0010\u00032\t\u0005\u0001b\u0002B\u0000g\u0002\u0007Aq\u0015\u000b\u0007\t\u007f#\u0019\r\"2\u0015\t\u0011\u001dF\u0011\u0019\u0005\b\u0007\u0013!\b9AB\u0006\u0011\u001d!)\u000b\u001ea\u0001\u0005cAqA!\u001cu\u0001\u0004\u0011\t\u0001K\u0004u\u0003\u0017$I-!6\"\u0005\u0011-\u0017!I;tK\u0002\u0002\u0017N\u001c;fe:\fGNL7fi\"|G\rV=qK\u0002\u0004\u0013N\\:uK\u0006$'!\u0005(vY2\f'/_'fi\"|G\rV=qKF!\u0011q\u0012Ci%\u0019!\u0019\u000e\"6\u0003\u0002\u00191\u0011\u0011\u0014\u0001\u0001\t#\u00042!!(\u007f\u0005QqU\u000f\u001c7beflU\r\u001e5pIRK\b/Z!qSN\u0019a0a'\u0011\u0007\u0005u\u00050A\tOk2d\u0017M]=NKRDw\u000e\u001a+za\u0016,\"\u0001\"9\u0011\u0007\u0005u%P\u0001\u000eOk2d\u0017M]=NKRDw\u000e\u001a+za\u0016,\u0005\u0010\u001e:bGR|'oE\u0002{\u0003s\"\"\u0001\"9\u0015\t\t5F1\u001e\u0005\b\u0005\u007fd\b\u0019\u0001Cn)\u0011!y\u000fb=\u0015\t\u0011mG\u0011\u001f\u0005\b\u0007\u0013i\b9AB\u0006\u0011\u001d\u0011i' a\u0001\u0005\u0003As!`Af\to\f).\t\u0002\u0005z\u0006ASo]3!A&tG/\u001a:oC2tc.\u001e7mCJLX*\u001a;i_\u0012$\u0016\u0010]3aA%t7\u000f^3bI\nA\u0001k\u001c7z)f\u0004X-\u0005\u0003\u0002\u0010\u0012}(CBC\u0001\u000b\u0007\u0011\tA\u0002\u0004\u0002\u001a\u0002\u0001Aq \t\u0005\u0003;\u000biAA\u0006Q_2LH+\u001f9f\u0003BL7\u0003BA\u0007\u00037\u0003B!!(\u0002\u0002\u0005A\u0001k\u001c7z)f\u0004X-\u0006\u0002\u0006\u0010A!\u0011QTA\u0003\u0005E\u0001v\u000e\\=UsB,W\t\u001f;sC\u000e$xN]\n\u0005\u0003\u000b\tI\b\u0006\u0002\u0006\u0010Q!AqWC\r\u0011!\u0011y0!\u0003A\u0002\u0015%ACBC\u000f\u000bC)\u0019\u0003\u0006\u0003\u0006\n\u0015}\u0001\u0002CB\u0005\u0003\u0017\u0001\u001daa\u0003\t\u0011\t-\u00141\u0002a\u0001\u0005cA\u0001B!\u001c\u0002\f\u0001\u0007!\u0011\u0001\u0015\t\u0003\u0017\tY-b\n\u0002V\u0006\u0012Q\u0011F\u0001 kN,\u0007\u0005Y5oi\u0016\u0014h.\u00197/a>d\u0017\u0010V=qK\u0002\u0004\u0013N\\:uK\u0006$'aD#ySN$XM\u001c;jC2$\u0016\u0010]3\u0012\t\u0005=Uq\u0006\n\u0007\u000bc)\u0019D!\u0001\u0007\r\u0005e\u0005\u0001AC\u0018!\u0011\ti*a\b\u0003%\u0015C\u0018n\u001d;f]RL\u0017\r\u001c+za\u0016\f\u0005/[\n\u0005\u0003?\tY*\u0001\u0006rk\u0006tG/\u001b4jK\u0012\f!\"\u001e8eKJd\u00170\u001b8h!\u0011\ti*a\u0005\u0002\u001f\u0015C\u0018n\u001d;f]RL\u0017\r\u001c+za\u0016,\"!b\u0011\u0011\t\u0005u\u0015q\u0003\u0002\u0019\u000bbL7\u000f^3oi&\fG\u000eV=qK\u0016CHO]1di>\u00148\u0003BA\f\u0003s\"\"!b\u0011\u0015\t\u0011]VQ\n\u0005\t\u0005\u007f\fY\u00021\u0001\u0006>Q1Q\u0011KC+\u000b/\"B!\"\u0010\u0006T!A1\u0011BA\u000f\u0001\b\u0019Y\u0001\u0003\u0005\u0006:\u0005u\u0001\u0019\u0001B\u0019\u0011!)Y$!\bA\u0002\t\u0005\u0001\u0006CA\u000f\u0003\u0017,Y&!6\"\u0005\u0015u\u0013AJ;tK\u0002\u0002\u0017N\u001c;fe:\fGNL3ySN$XM\u001c;jC2$\u0016\u0010]3aA%t7\u000f^3bI\ni\u0011I\u001c8pi\u0006$X\r\u001a+za\u0016\fB!a$\u0006dI1QQMC4\u0005\u00031a!!'\u0001\u0001\u0015\r\u0004\u0003BAO\u0003c\u0011\u0001#\u00118o_R\fG/\u001a3UsB,\u0017\t]5\u0014\t\u0005E\u00121T\u0001\fC:tw\u000e^1uS>t7/\u0006\u0002\u0006rA1!1\u0007B\u001d\u000bg\u0002B!!(\u0006v%!QqOC=\u0005)\teN\\8uCRLwN\\\u0005\u0005\u000bw\nIGA\u0006B]:|G/\u0019;j_:\u001c\b\u0003BAO\u0003K\tQ\"\u00118o_R\fG/\u001a3UsB,WCACB!\u0011\ti*!\u000b\u0003-\u0005sgn\u001c;bi\u0016$G+\u001f9f\u000bb$(/Y2u_J\u001cB!!\u000b\u0002zQ\u0011Q1\u0011\u000b\u0005\u000b\u001b+\t\n\u0005\u0004\u0002|\t=Vq\u0012\t\t\u0003w\u001ay$\"\u001d\u0003\u0002!A!q`A\u0017\u0001\u0004)i\b\u0006\u0004\u0006\u0016\u0016eU1\u0014\u000b\u0005\u000b{*9\n\u0003\u0005\u0004\n\u0005=\u00029AB\u0006\u0011!)i'a\fA\u0002\u0015E\u0004\u0002CC\u001e\u0003_\u0001\rA!\u0001)\u0011\u0005=\u00121ZCP\u0003+\f#!\")\u0002IU\u001cX\r\t1j]R,'O\\1m]\u0005tgn\u001c;bi\u0016$G+\u001f9fA\u0002Jgn\u001d;fC\u0012\u0014!\u0002V=qK\n{WO\u001c3t#\u0011\ty)b*\u0013\r\u0015%V1\u0016B\u0001\r\u0019\tI\n\u0001\u0001\u0006(B!\u0011QTA\"\u00055!\u0016\u0010]3C_VtGm]!qSN!\u00111IAN\u0003\taw.\u0001\u0002iSB!\u0011QTA\u001c\u0003)!\u0016\u0010]3C_VtGm]\u000b\u0003\u000bw\u0003B!!(\u0002<\t\u0019B+\u001f9f\u0005>,h\u000eZ:FqR\u0014\u0018m\u0019;peN!\u00111HA=)\t)Y\f\u0006\u0003\u0004x\u0015\u0015\u0007\u0002\u0003B\u0000\u0003\u007f\u0001\r!\".\u0015\r\u0015%WQZCh)\u0011)),b3\t\u0011\r%\u0011\u0011\ta\u0002\u0007\u0017A\u0001\"\"-\u0002B\u0001\u0007!\u0011\u0001\u0005\t\u000bg\u000b\t\u00051\u0001\u0003\u0002!B\u0011\u0011IAf\u000b'\f).\t\u0002\u0006V\u0006\tSo]3!A&tG/\u001a:oC2tC/\u001f9f\u0005>,h\u000eZ:aA%t7\u000f^3bI\u0006aq+\u001b7eG\u0006\u0014H\rV=qK\n\u0019\"i\\;oI\u0016$w+\u001b7eG\u0006\u0014H\rV=qKF!\u0011qRCo%\u0019)y.\"9\u0003\u0002\u00191\u0011\u0011\u0014\u0001\u0001\u000b;\u0004B!!(\u0002X\t1\"i\\;oI\u0016$w+\u001b7eG\u0006\u0014H\rV=qK\u0006\u0003\u0018n\u0005\u0003\u0002X\u0005m\u0015A\u00022pk:$7/\u0006\u0002\u00066B!\u0011QTA&\u0003M\u0011u.\u001e8eK\u0012<\u0016\u000e\u001c3dCJ$G+\u001f9f+\t)\t\u0010\u0005\u0003\u0002\u001e\u0006=#\u0001\b\"pk:$W\rZ,jY\u0012\u001c\u0017M\u001d3UsB,W\t\u001f;sC\u000e$xN]\n\u0005\u0003\u001f\nI\b\u0006\u0002\u0006rR!Q1`C\u007f!\u0019\tYHa,\u00066\"A!q`A*\u0001\u0004)Y\u000f\u0006\u0003\u0007\u0002\u0019\u0015A\u0003BCv\r\u0007A\u0001b!\u0003\u0002V\u0001\u000f11\u0002\u0005\t\u000bO\f)\u00061\u0001\u00066\"B\u0011QKAf\r\u0013\t).\t\u0002\u0007\f\u0005QSo]3!A&tG/\u001a:oC2t#m\\;oI\u0016$w+\u001b7eG\u0006\u0014H\rV=qK\u0002\u0004\u0013N\\:uK\u0006$\u0017a\u00017vER!!\u0011\u0001D\t\u0011!1\u0019\"a\u0017A\u0002\tm\u0013A\u0001=t\u0003\r9GN\u0019\u000b\u0005\u0005\u00031I\u0002\u0003\u0005\u0007\u001c\u0005u\u0003\u0019\u0001B.\u0003\t!8/A\u0006baBd\u0017.\u001a3UsB,GC\u0002B\u0001\rC1)\u0003\u0003\u0005\u0007$\u0005}\u0003\u0019\u0001B\u0001\u0003\u0015!\u0018pY8o\u0011!\u0019I.a\u0018A\u0002\tmCC\u0002B\u0001\rS1Y\u0003\u0003\u0005\u0007$\u0005\u0005\u0004\u0019\u0001B\u0001\u0011!\u0019I.!\u0019A\u0002\u00195\u0002CBA>\r_\u0011\t!\u0003\u0003\u00072\u0005E$A\u0003\u001fsKB,\u0017\r^3e}Q1!\u0011\u0001D\u001b\roA\u0001B!2\u0002d\u0001\u0007\u00111\u0016\u0005\t\u00073\f\u0019\u00071\u0001\u0003\\Q1!\u0011\u0001D\u001e\r{A\u0001B!2\u0002f\u0001\u0007\u00111\u0016\u0005\t\u00073\f)\u00071\u0001\u0007.A!a\u0011\tD\"\u001b\t\tI'\u0003\u0003\u0007F\u0005%$\u0001C+oSZ,'o]3")
public interface Types {
    public TypeApi NoType();

    public TypeApi NoPrefix();

    public ThisTypeExtractor ThisType();

    public SingleTypeExtractor SingleType();

    public SuperTypeExtractor SuperType();

    public ConstantTypeExtractor ConstantType();

    public TypeRefExtractor TypeRef();

    public RefinedTypeExtractor RefinedType();

    public ClassInfoTypeExtractor ClassInfoType();

    public MethodTypeExtractor MethodType();

    public NullaryMethodTypeExtractor NullaryMethodType();

    public PolyTypeExtractor PolyType();

    public ExistentialTypeExtractor ExistentialType();

    public AnnotatedTypeExtractor AnnotatedType();

    public TypeBoundsExtractor TypeBounds();

    public TypeApi WildcardType();

    public BoundedWildcardTypeExtractor BoundedWildcardType();

    public TypeApi lub(List<TypeApi> var1);

    public TypeApi glb(List<TypeApi> var1);

    public TypeApi appliedType(TypeApi var1, List<TypeApi> var2);

    public TypeApi appliedType(TypeApi var1, Seq<TypeApi> var2);

    public TypeApi appliedType(Symbols.SymbolApi var1, List<TypeApi> var2);

    public TypeApi appliedType(Symbols.SymbolApi var1, Seq<TypeApi> var2);

    public static void $init$(Types $this) {
    }

    public interface AnnotatedTypeApi {
        public List<Annotations.AnnotationApi> annotations();

        public TypeApi underlying();
    }

    public static abstract class AnnotatedTypeExtractor {
        public final /* synthetic */ Universe $outer;

        public abstract Option<Tuple2<List<Annotations.AnnotationApi>, TypeApi>> unapply(AnnotatedTypeApi var1);

        public AnnotatedTypeApi apply(List<Annotations.AnnotationApi> annotations, TypeApi underlying, Internals.CompatToken token) {
            return this.scala$reflect$api$Types$AnnotatedTypeExtractor$$$outer().internal().annotatedType(annotations, underlying);
        }

        public /* synthetic */ Universe scala$reflect$api$Types$AnnotatedTypeExtractor$$$outer() {
            return this.$outer;
        }

        public AnnotatedTypeExtractor(Universe $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public interface BoundedWildcardTypeApi {
        public TypeBoundsApi bounds();
    }

    public static abstract class BoundedWildcardTypeExtractor {
        public final /* synthetic */ Universe $outer;

        public abstract Option<TypeBoundsApi> unapply(BoundedWildcardTypeApi var1);

        public BoundedWildcardTypeApi apply(TypeBoundsApi bounds, Internals.CompatToken token) {
            return this.scala$reflect$api$Types$BoundedWildcardTypeExtractor$$$outer().internal().boundedWildcardType(bounds);
        }

        public /* synthetic */ Universe scala$reflect$api$Types$BoundedWildcardTypeExtractor$$$outer() {
            return this.$outer;
        }

        public BoundedWildcardTypeExtractor(Universe $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public interface ClassInfoTypeApi {
        public List<TypeApi> parents();

        public Scopes.MemberScopeApi decls();

        public Symbols.SymbolApi typeSymbol();
    }

    public static abstract class ClassInfoTypeExtractor {
        public final /* synthetic */ Universe $outer;

        public abstract Option<Tuple3<List<TypeApi>, Scopes.ScopeApi, Symbols.SymbolApi>> unapply(ClassInfoTypeApi var1);

        public ClassInfoTypeApi apply(List<TypeApi> parents, Scopes.ScopeApi decls, Symbols.SymbolApi typeSymbol, Internals.CompatToken token) {
            return this.scala$reflect$api$Types$ClassInfoTypeExtractor$$$outer().internal().classInfoType(parents, decls, typeSymbol);
        }

        public /* synthetic */ Universe scala$reflect$api$Types$ClassInfoTypeExtractor$$$outer() {
            return this.$outer;
        }

        public ClassInfoTypeExtractor(Universe $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public interface CompoundTypeApi {
    }

    public interface ConstantTypeApi {
        public Constants.ConstantApi value();
    }

    public static abstract class ConstantTypeExtractor {
        public final /* synthetic */ Universe $outer;

        public abstract Option<Constants.ConstantApi> unapply(ConstantTypeApi var1);

        public ConstantTypeApi apply(Constants.ConstantApi value, Internals.CompatToken token) {
            return this.scala$reflect$api$Types$ConstantTypeExtractor$$$outer().internal().constantType(value);
        }

        public /* synthetic */ Universe scala$reflect$api$Types$ConstantTypeExtractor$$$outer() {
            return this.$outer;
        }

        public ConstantTypeExtractor(Universe $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public interface ExistentialTypeApi {
        public List<Symbols.SymbolApi> quantified();

        public TypeApi underlying();
    }

    public static abstract class ExistentialTypeExtractor {
        public final /* synthetic */ Universe $outer;

        public abstract Option<Tuple2<List<Symbols.SymbolApi>, TypeApi>> unapply(ExistentialTypeApi var1);

        public ExistentialTypeApi apply(List<Symbols.SymbolApi> quantified, TypeApi underlying, Internals.CompatToken token) {
            return this.scala$reflect$api$Types$ExistentialTypeExtractor$$$outer().internal().existentialType(quantified, underlying);
        }

        public /* synthetic */ Universe scala$reflect$api$Types$ExistentialTypeExtractor$$$outer() {
            return this.$outer;
        }

        public ExistentialTypeExtractor(Universe $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public interface MethodTypeApi {
        public List<Symbols.SymbolApi> params();

        public TypeApi resultType();
    }

    public static abstract class MethodTypeExtractor {
        public final /* synthetic */ Universe $outer;

        public abstract Option<Tuple2<List<Symbols.SymbolApi>, TypeApi>> unapply(MethodTypeApi var1);

        public MethodTypeApi apply(List<Symbols.SymbolApi> params, TypeApi resultType, Internals.CompatToken token) {
            return this.scala$reflect$api$Types$MethodTypeExtractor$$$outer().internal().methodType(params, resultType);
        }

        public /* synthetic */ Universe scala$reflect$api$Types$MethodTypeExtractor$$$outer() {
            return this.$outer;
        }

        public MethodTypeExtractor(Universe $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public interface NullaryMethodTypeApi {
        public TypeApi resultType();
    }

    public static abstract class NullaryMethodTypeExtractor {
        public final /* synthetic */ Universe $outer;

        public abstract Option<TypeApi> unapply(NullaryMethodTypeApi var1);

        public NullaryMethodTypeApi apply(TypeApi resultType, Internals.CompatToken token) {
            return this.scala$reflect$api$Types$NullaryMethodTypeExtractor$$$outer().internal().nullaryMethodType(resultType);
        }

        public /* synthetic */ Universe scala$reflect$api$Types$NullaryMethodTypeExtractor$$$outer() {
            return this.$outer;
        }

        public NullaryMethodTypeExtractor(Universe $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public interface PolyTypeApi {
        public List<Symbols.SymbolApi> typeParams();

        public TypeApi resultType();
    }

    public static abstract class PolyTypeExtractor {
        public final /* synthetic */ Universe $outer;

        public abstract Option<Tuple2<List<Symbols.SymbolApi>, TypeApi>> unapply(PolyTypeApi var1);

        public PolyTypeApi apply(List<Symbols.SymbolApi> typeParams, TypeApi resultType, Internals.CompatToken token) {
            return this.scala$reflect$api$Types$PolyTypeExtractor$$$outer().internal().polyType(typeParams, resultType);
        }

        public /* synthetic */ Universe scala$reflect$api$Types$PolyTypeExtractor$$$outer() {
            return this.$outer;
        }

        public PolyTypeExtractor(Universe $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public interface RefinedTypeApi {
        public List<TypeApi> parents();

        public Scopes.MemberScopeApi decls();
    }

    public static abstract class RefinedTypeExtractor {
        public final /* synthetic */ Universe $outer;

        public abstract Option<Tuple2<List<TypeApi>, Scopes.ScopeApi>> unapply(RefinedTypeApi var1);

        public RefinedTypeApi apply(List<TypeApi> parents, Scopes.ScopeApi decls, Internals.CompatToken token) {
            return this.scala$reflect$api$Types$RefinedTypeExtractor$$$outer().internal().refinedType(parents, decls);
        }

        public RefinedTypeApi apply(List<TypeApi> parents, Scopes.ScopeApi decls, Symbols.SymbolApi clazz, Internals.CompatToken token) {
            return this.scala$reflect$api$Types$RefinedTypeExtractor$$$outer().internal().refinedType(parents, decls, clazz);
        }

        public /* synthetic */ Universe scala$reflect$api$Types$RefinedTypeExtractor$$$outer() {
            return this.$outer;
        }

        public RefinedTypeExtractor(Universe $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public interface SingleTypeApi {
        public TypeApi pre();

        public Symbols.SymbolApi sym();
    }

    public static abstract class SingleTypeExtractor {
        public final /* synthetic */ Universe $outer;

        public abstract Option<Tuple2<TypeApi, Symbols.SymbolApi>> unapply(SingleTypeApi var1);

        public TypeApi apply(TypeApi pre, Symbols.SymbolApi sym, Internals.CompatToken token) {
            return this.scala$reflect$api$Types$SingleTypeExtractor$$$outer().internal().singleType(pre, sym);
        }

        public /* synthetic */ Universe scala$reflect$api$Types$SingleTypeExtractor$$$outer() {
            return this.$outer;
        }

        public SingleTypeExtractor(Universe $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public interface SingletonTypeApi {
    }

    public interface SuperTypeApi {
        public TypeApi thistpe();

        public TypeApi supertpe();
    }

    public static abstract class SuperTypeExtractor {
        public final /* synthetic */ Universe $outer;

        public abstract Option<Tuple2<TypeApi, TypeApi>> unapply(SuperTypeApi var1);

        public TypeApi apply(TypeApi thistpe, TypeApi supertpe, Internals.CompatToken token) {
            return this.scala$reflect$api$Types$SuperTypeExtractor$$$outer().internal().superType(thistpe, supertpe);
        }

        public /* synthetic */ Universe scala$reflect$api$Types$SuperTypeExtractor$$$outer() {
            return this.$outer;
        }

        public SuperTypeExtractor(Universe $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public interface ThisTypeApi {
        public Symbols.SymbolApi sym();
    }

    public static abstract class ThisTypeExtractor {
        public final /* synthetic */ Universe $outer;

        public abstract Option<Symbols.SymbolApi> unapply(ThisTypeApi var1);

        public TypeApi apply(Symbols.SymbolApi sym, Internals.CompatToken token) {
            return this.scala$reflect$api$Types$ThisTypeExtractor$$$outer().internal().thisType(sym);
        }

        public /* synthetic */ Universe scala$reflect$api$Types$ThisTypeExtractor$$$outer() {
            return this.$outer;
        }

        public ThisTypeExtractor(Universe $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public static abstract class TypeApi {
        public final /* synthetic */ Universe $outer;

        public abstract Symbols.SymbolApi termSymbol();

        public abstract Symbols.SymbolApi typeSymbol();

        public abstract Symbols.SymbolApi declaration(Names.NameApi var1);

        public abstract Symbols.SymbolApi decl(Names.NameApi var1);

        public abstract Scopes.MemberScopeApi declarations();

        public abstract Scopes.MemberScopeApi decls();

        public abstract Symbols.SymbolApi member(Names.NameApi var1);

        public abstract Scopes.MemberScopeApi members();

        public abstract TypeApi companion();

        public abstract boolean takesTypeArgs();

        public abstract TypeApi typeConstructor();

        public abstract TypeApi normalize();

        public abstract TypeApi etaExpand();

        public abstract boolean $less$colon$less(TypeApi var1);

        public abstract boolean weak_$less$colon$less(TypeApi var1);

        public abstract boolean $eq$colon$eq(TypeApi var1);

        public abstract List<Symbols.SymbolApi> baseClasses();

        public abstract TypeApi baseType(Symbols.SymbolApi var1);

        public abstract TypeApi asSeenFrom(TypeApi var1, Symbols.SymbolApi var2);

        public abstract TypeApi erasure();

        public abstract TypeApi widen();

        public abstract TypeApi dealias();

        public abstract List<TypeApi> typeArgs();

        public abstract List<List<Symbols.SymbolApi>> paramss();

        public abstract List<List<Symbols.SymbolApi>> paramLists();

        public abstract List<Symbols.SymbolApi> typeParams();

        public abstract TypeApi resultType();

        public abstract TypeApi finalResultType();

        public abstract TypeApi orElse(Function0<TypeApi> var1);

        public abstract TypeApi substituteSymbols(List<Symbols.SymbolApi> var1, List<Symbols.SymbolApi> var2);

        public abstract TypeApi substituteTypes(List<Symbols.SymbolApi> var1, List<TypeApi> var2);

        public abstract TypeApi map(Function1<TypeApi, TypeApi> var1);

        public abstract void foreach(Function1<TypeApi, BoxedUnit> var1);

        public abstract Option<TypeApi> find(Function1<TypeApi, Object> var1);

        public abstract boolean exists(Function1<TypeApi, Object> var1);

        public abstract boolean contains(Symbols.SymbolApi var1);

        public /* synthetic */ Universe scala$reflect$api$Types$TypeApi$$$outer() {
            return this.$outer;
        }

        public TypeApi(Universe $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public interface TypeBoundsApi {
        public TypeApi lo();

        public TypeApi hi();
    }

    public static abstract class TypeBoundsExtractor {
        public final /* synthetic */ Universe $outer;

        public abstract Option<Tuple2<TypeApi, TypeApi>> unapply(TypeBoundsApi var1);

        public TypeBoundsApi apply(TypeApi lo, TypeApi hi, Internals.CompatToken token) {
            return this.scala$reflect$api$Types$TypeBoundsExtractor$$$outer().internal().typeBounds(lo, hi);
        }

        public /* synthetic */ Universe scala$reflect$api$Types$TypeBoundsExtractor$$$outer() {
            return this.$outer;
        }

        public TypeBoundsExtractor(Universe $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public interface TypeRefApi {
        public TypeApi pre();

        public Symbols.SymbolApi sym();

        public List<TypeApi> args();
    }

    public static abstract class TypeRefExtractor {
        public final /* synthetic */ Universe $outer;

        public abstract Option<Tuple3<TypeApi, Symbols.SymbolApi, List<TypeApi>>> unapply(TypeRefApi var1);

        public TypeApi apply(TypeApi pre, Symbols.SymbolApi sym, List<TypeApi> args2, Internals.CompatToken token) {
            return this.scala$reflect$api$Types$TypeRefExtractor$$$outer().internal().typeRef(pre, sym, args2);
        }

        public /* synthetic */ Universe scala$reflect$api$Types$TypeRefExtractor$$$outer() {
            return this.$outer;
        }

        public TypeRefExtractor(Universe $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }
}

