/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Option;
import scala.Product;
import scala.Product19;
import scala.Serializable;
import scala.Tuple19$;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0019}h\u0001B%K\u00056C!\"a\u000f\u0001\u0005+\u0007I\u0011AA\u001f\u0011%\ty\u0004\u0001B\tB\u0003%a\u000b\u0003\u0006\u0002B\u0001\u0011)\u001a!C\u0001\u0003\u0007B\u0011\"!\u0012\u0001\u0005#\u0005\u000b\u0011B1\t\u0015\u0005\u001d\u0003A!f\u0001\n\u0003\tI\u0005C\u0005\u0002L\u0001\u0011\t\u0012)A\u0005I\"Q\u0011Q\n\u0001\u0003\u0016\u0004%\t!a\u0014\t\u0013\u0005E\u0003A!E!\u0002\u00139\u0007BCA*\u0001\tU\r\u0011\"\u0001\u0002V!I\u0011q\u000b\u0001\u0003\u0012\u0003\u0006IA\u001b\u0005\u000b\u00033\u0002!Q3A\u0005\u0002\u0005m\u0003\"CA/\u0001\tE\t\u0015!\u0003n\u0011)\ty\u0006\u0001BK\u0002\u0013\u0005\u0011\u0011\r\u0005\n\u0003G\u0002!\u0011#Q\u0001\nAD!\"!\u001a\u0001\u0005+\u0007I\u0011AA4\u0011%\tI\u0007\u0001B\tB\u0003%1\u000f\u0003\u0006\u0002l\u0001\u0011)\u001a!C\u0001\u0003[B\u0011\"a\u001c\u0001\u0005#\u0005\u000b\u0011\u0002<\t\u0015\u0005E\u0004A!f\u0001\n\u0003\t\u0019\bC\u0005\u0002v\u0001\u0011\t\u0012)A\u0005s\"Q\u0011q\u000f\u0001\u0003\u0016\u0004%\t!!\u001f\t\u0013\u0005m\u0004A!E!\u0002\u0013a\bBCA?\u0001\tU\r\u0011\"\u0001\u0002\u0000!I\u0011\u0011\u0011\u0001\u0003\u0012\u0003\u0006Ia \u0005\u000b\u0003\u0007\u0003!Q3A\u0005\u0002\u0005\u0015\u0005BCAD\u0001\tE\t\u0015!\u0003\u0002\u0006!Q\u0011\u0011\u0012\u0001\u0003\u0016\u0004%\t!a#\t\u0015\u00055\u0005A!E!\u0002\u0013\tY\u0001\u0003\u0006\u0002\u0010\u0002\u0011)\u001a!C\u0001\u0003#C!\"a%\u0001\u0005#\u0005\u000b\u0011BA\t\u0011)\t)\n\u0001BK\u0002\u0013\u0005\u0011q\u0013\u0005\u000b\u00033\u0003!\u0011#Q\u0001\n\u0005]\u0001BCAN\u0001\tU\r\u0011\"\u0001\u0002\u001e\"Q\u0011q\u0014\u0001\u0003\u0012\u0003\u0006I!!\b\t\u0015\u0005\u0005\u0006A!f\u0001\n\u0003\t\u0019\u000b\u0003\u0006\u0002&\u0002\u0011\t\u0012)A\u0005\u0003GA!\"a*\u0001\u0005+\u0007I\u0011AAU\u0011)\tY\u000b\u0001B\tB\u0003%\u0011\u0011\u0006\u0005\b\u0003[\u0003A\u0011AAX\u0011\u001d\tI\u000e\u0001C!\u00037D\u0011\"!<\u0001\u0003\u0003%\t!a<\t\u0013\t\u001d\u0004!%A\u0005\u0002\t%\u0004\"\u0003BT\u0001E\u0005I\u0011\u0001BU\u0011%\u0011)\u000eAI\u0001\n\u0003\u00119\u000eC\u0005\u0004\u0004\u0001\t\n\u0011\"\u0001\u0004\u0006!I1\u0011\u0007\u0001\u0012\u0002\u0013\u000511\u0007\u0005\n\u0007?\u0002\u0011\u0013!C\u0001\u0007CB\u0011b!$\u0001#\u0003%\taa$\t\u0013\rm\u0006!%A\u0005\u0002\ru\u0006\"CBu\u0001E\u0005I\u0011ABv\u0011%!9\u0002AI\u0001\n\u0003!I\u0002C\u0005\u0005F\u0001\t\n\u0011\"\u0001\u0005H!IA1\u000f\u0001\u0012\u0002\u0013\u0005AQ\u000f\u0005\n\tC\u0003\u0011\u0013!C\u0001\tGC\u0011\u0002b4\u0001#\u0003%\t\u0001\"5\t\u0013\u0011u\b!%A\u0005\u0002\u0011}\b\"CC\u0016\u0001E\u0005I\u0011AC\u0017\u0011%)I\u0006AI\u0001\n\u0003)Y\u0006C\u0005\u0006\b\u0002\t\n\u0011\"\u0001\u0006\n\"IQQ\u0017\u0001\u0012\u0002\u0013\u0005Qq\u0017\u0005\n\u000bG\u0004\u0011\u0011!C!\u000bKD\u0011\"b:\u0001\u0003\u0003%\t%\";\t\u0013\u0015]\b!!A\u0005\u0002\u0015e\b\"\u0003D\u0003\u0001\u0005\u0005I\u0011\tD\u0004\u0011%1y\u0001AA\u0001\n\u00032\tbB\u0005\u0007\u0016)\u000b\t\u0011#\u0001\u0007\u0018\u0019A\u0011JSA\u0001\u0012\u00031I\u0002C\u0004\u0002.\u000e#\tAb\u0007\t\u0013\u0005e7)!A\u0005F\u0005m\u0007\"\u0003D\u000f\u0007\u0006\u0005I\u0011\u0011D\u0010\u0011%19jQA\u0001\n\u00033I\nC\u0005\u0007v\u000e\u000b\t\u0011\"\u0003\u0007x\n9A+\u001e9mKFJ$\"A&\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001Uab\n\u00172fQ.t\u0017\u000f^<{{\u0006\u0005\u0011qAA\u0007\u0003'\tI\"a\b\u0002&\u0005-2c\u0002\u0001P'\u0006=\u0012Q\u0007\t\u0003!Fk\u0011AS\u0005\u0003%*\u0013a!\u00118z%\u00164\u0007\u0003\b)U-\u0006$wM[7qgZLHp`A\u0003\u0003\u0017\t\t\"a\u0006\u0002\u001e\u0005\r\u0012\u0011F\u0005\u0003+*\u0013\u0011\u0002\u0015:pIV\u001cG/M\u001d\u0011\u0005]CF\u0002\u0001\u0003\u00073\u0002!)\u0019\u0001.\u0003\u0005Q\u000b\u0014CA._!\t\u0001F,\u0003\u0002^\u0015\n9aj\u001c;iS:<\u0007C\u0001)`\u0013\t\u0001'JA\u0002B]f\u0004\"a\u00162\u0005\r\r\u0004AQ1\u0001[\u0005\t!&\u0007\u0005\u0002XK\u00121a\r\u0001CC\u0002i\u0013!\u0001V\u001a\u0011\u0005]CGAB5\u0001\t\u000b\u0007!L\u0001\u0002UiA\u0011qk\u001b\u0003\u0007Y\u0002!)\u0019\u0001.\u0003\u0005Q+\u0004CA,o\t\u0019y\u0007\u0001\"b\u00015\n\u0011AK\u000e\t\u0003/F$aA\u001d\u0001\u0005\u0006\u0004Q&A\u0001+8!\t9F\u000f\u0002\u0004v\u0001\u0011\u0015\rA\u0017\u0002\u0003)b\u0002\"aV<\u0005\ra\u0004AQ1\u0001[\u0005\t!\u0016\b\u0005\u0002Xu\u001211\u0010\u0001CC\u0002i\u00131\u0001V\u00191!\t9V\u0010\u0002\u0004\u007f\u0001\u0011\u0015\rA\u0017\u0002\u0004)F\n\u0004cA,\u0002\u0002\u00119\u00111\u0001\u0001\u0005\u0006\u0004Q&a\u0001+2eA\u0019q+a\u0002\u0005\u000f\u0005%\u0001\u0001\"b\u00015\n\u0019A+M\u001a\u0011\u0007]\u000bi\u0001B\u0004\u0002\u0010\u0001!)\u0019\u0001.\u0003\u0007Q\u000bD\u0007E\u0002X\u0003'!q!!\u0006\u0001\t\u000b\u0007!LA\u0002UcU\u00022aVA\r\t\u001d\tY\u0002\u0001CC\u0002i\u00131\u0001V\u00197!\r9\u0016q\u0004\u0003\b\u0003C\u0001AQ1\u0001[\u0005\r!\u0016g\u000e\t\u0004/\u0006\u0015BaBA\u0014\u0001\u0011\u0015\rA\u0017\u0002\u0004)FB\u0004cA,\u0002,\u00119\u0011Q\u0006\u0001\u0005\u0006\u0004Q&a\u0001+2sA\u0019\u0001+!\r\n\u0007\u0005M\"JA\u0004Qe>$Wo\u0019;\u0011\u0007A\u000b9$C\u0002\u0002:)\u0013AbU3sS\u0006d\u0017N_1cY\u0016\f!aX\u0019\u0016\u0003Y\u000b1aX\u0019!\u0003\ty&'F\u0001b\u0003\ry&\u0007I\u0001\u0003?N*\u0012\u0001Z\u0001\u0004?N\u0002\u0013AA05+\u00059\u0017aA05A\u0005\u0011q,N\u000b\u0002U\u0006\u0019q,\u000e\u0011\u0002\u0005}3T#A7\u0002\u0007}3\u0004%\u0001\u0002`oU\t\u0001/A\u0002`o\u0001\n!a\u0018\u001d\u0016\u0003M\f1a\u0018\u001d!\u0003\ty\u0016(F\u0001w\u0003\ry\u0016\bI\u0001\u0004?F\u0002T#A=\u0002\t}\u000b\u0004\u0007I\u0001\u0004?F\nT#\u0001?\u0002\t}\u000b\u0014\u0007I\u0001\u0004?F\u0012T#A@\u0002\t}\u000b$\u0007I\u0001\u0004?F\u001aTCAA\u0003\u0003\u0011y\u0016g\r\u0011\u0002\u0007}\u000bD'\u0006\u0002\u0002\f\u0005!q,\r\u001b!\u0003\ry\u0016'N\u000b\u0003\u0003#\tAaX\u00196A\u0005\u0019q,\r\u001c\u0016\u0005\u0005]\u0011\u0001B02m\u0001\n1aX\u00198+\t\ti\"\u0001\u0003`c]\u0002\u0013aA02qU\u0011\u00111E\u0001\u0005?FB\u0004%A\u0002`ce*\"!!\u000b\u0002\t}\u000b\u0014\bI\u0001\u0007y%t\u0017\u000e\u001e \u0015Q\u0005E\u00161WA[\u0003o\u000bI,a/\u0002>\u0006}\u0016\u0011YAb\u0003\u000b\f9-!3\u0002L\u00065\u0017qZAi\u0003'\f).a6\u00119A\u0003a+\u00193hU6\u00048O^=}\u007f\u0006\u0015\u00111BA\t\u0003/\ti\"a\t\u0002*!1\u00111H\u0014A\u0002YCa!!\u0011(\u0001\u0004\t\u0007BBA$O\u0001\u0007A\r\u0003\u0004\u0002N\u001d\u0002\ra\u001a\u0005\u0007\u0003':\u0003\u0019\u00016\t\r\u0005es\u00051\u0001n\u0011\u0019\tyf\na\u0001a\"1\u0011QM\u0014A\u0002MDa!a\u001b(\u0001\u00041\bBBA9O\u0001\u0007\u0011\u0010\u0003\u0004\u0002x\u001d\u0002\r\u0001 \u0005\u0007\u0003{:\u0003\u0019A@\t\u000f\u0005\ru\u00051\u0001\u0002\u0006!9\u0011\u0011R\u0014A\u0002\u0005-\u0001bBAHO\u0001\u0007\u0011\u0011\u0003\u0005\b\u0003+;\u0003\u0019AA\f\u0011\u001d\tYj\na\u0001\u0003;Aq!!)(\u0001\u0004\t\u0019\u0003C\u0004\u0002(\u001e\u0002\r!!\u000b\u0002\u0011Q|7\u000b\u001e:j]\u001e$\"!!8\u0011\t\u0005}\u0017\u0011^\u0007\u0003\u0003CTA!a9\u0002f\u0006!A.\u00198h\u0015\t\t9/\u0001\u0003kCZ\f\u0017\u0002BAv\u0003C\u0014aa\u0015;sS:<\u0017\u0001B2paf,\u0002&!=\u0002x\u0006m\u0018q B\u0002\u0005\u000f\u0011YAa\u0004\u0003\u0014\t]!1\u0004B\u0010\u0005G\u00119Ca\u000b\u00030\tM\"q\u0007B\u001e\u0005\u007f!\u0002&a=\u0003B\t\r#Q\tB$\u0005\u0013\u0012YE!\u0014\u0003P\tE#1\u000bB+\u0005/\u0012IFa\u0017\u0003^\t}#\u0011\rB2\u0005K\u0002\u0002\u0006\u0015\u0001\u0002v\u0006e\u0018Q B\u0001\u0005\u000b\u0011IA!\u0004\u0003\u0012\tU!\u0011\u0004B\u000f\u0005C\u0011)C!\u000b\u0003.\tE\"Q\u0007B\u001d\u0005{\u00012aVA|\t\u0015I\u0016F1\u0001[!\r9\u00161 \u0003\u0006G&\u0012\rA\u0017\t\u0004/\u0006}H!\u00024*\u0005\u0004Q\u0006cA,\u0003\u0004\u0011)\u0011.\u000bb\u00015B\u0019qKa\u0002\u0005\u000b1L#\u0019\u0001.\u0011\u0007]\u0013Y\u0001B\u0003pS\t\u0007!\fE\u0002X\u0005\u001f!QA]\u0015C\u0002i\u00032a\u0016B\n\t\u0015)\u0018F1\u0001[!\r9&q\u0003\u0003\u0006q&\u0012\rA\u0017\t\u0004/\nmA!B>*\u0005\u0004Q\u0006cA,\u0003 \u0011)a0\u000bb\u00015B\u0019qKa\t\u0005\r\u0005\r\u0011F1\u0001[!\r9&q\u0005\u0003\u0007\u0003\u0013I#\u0019\u0001.\u0011\u0007]\u0013Y\u0003\u0002\u0004\u0002\u0010%\u0012\rA\u0017\t\u0004/\n=BABA\u000bS\t\u0007!\fE\u0002X\u0005g!a!a\u0007*\u0005\u0004Q\u0006cA,\u00038\u00111\u0011\u0011E\u0015C\u0002i\u00032a\u0016B\u001e\t\u0019\t9#\u000bb\u00015B\u0019qKa\u0010\u0005\r\u00055\u0012F1\u0001[\u0011%\tY$\u000bI\u0001\u0002\u0004\t)\u0010C\u0005\u0002B%\u0002\n\u00111\u0001\u0002z\"I\u0011qI\u0015\u0011\u0002\u0003\u0007\u0011Q \u0005\n\u0003\u001bJ\u0003\u0013!a\u0001\u0005\u0003A\u0011\"a\u0015*!\u0003\u0005\rA!\u0002\t\u0013\u0005e\u0013\u0006%AA\u0002\t%\u0001\"CA0SA\u0005\t\u0019\u0001B\u0007\u0011%\t)'\u000bI\u0001\u0002\u0004\u0011\t\u0002C\u0005\u0002l%\u0002\n\u00111\u0001\u0003\u0016!I\u0011\u0011O\u0015\u0011\u0002\u0003\u0007!\u0011\u0004\u0005\n\u0003oJ\u0003\u0013!a\u0001\u0005;A\u0011\"! *!\u0003\u0005\rA!\t\t\u0013\u0005\r\u0015\u0006%AA\u0002\t\u0015\u0002\"CAESA\u0005\t\u0019\u0001B\u0015\u0011%\ty)\u000bI\u0001\u0002\u0004\u0011i\u0003C\u0005\u0002\u0016&\u0002\n\u00111\u0001\u00032!I\u00111T\u0015\u0011\u0002\u0003\u0007!Q\u0007\u0005\n\u0003CK\u0003\u0013!a\u0001\u0005sA\u0011\"a**!\u0003\u0005\rA!\u0010\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%cUA#1\u000eBA\u0005\u0007\u0013)Ia\"\u0003\n\n-%Q\u0012BH\u0005#\u0013\u0019J!&\u0003\u0018\ne%1\u0014BO\u0005?\u0013\tKa)\u0003&V\u0011!Q\u000e\u0016\u0004-\n=4F\u0001B9!\u0011\u0011\u0019H! \u000e\u0005\tU$\u0002\u0002B<\u0005s\n\u0011\"\u001e8dQ\u0016\u001c7.\u001a3\u000b\u0007\tm$*\u0001\u0006b]:|G/\u0019;j_:LAAa \u0003v\t\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0005\u000beS#\u0019\u0001.\u0005\u000b\rT#\u0019\u0001.\u0005\u000b\u0019T#\u0019\u0001.\u0005\u000b%T#\u0019\u0001.\u0005\u000b1T#\u0019\u0001.\u0005\u000b=T#\u0019\u0001.\u0005\u000bIT#\u0019\u0001.\u0005\u000bUT#\u0019\u0001.\u0005\u000baT#\u0019\u0001.\u0005\u000bmT#\u0019\u0001.\u0005\u000byT#\u0019\u0001.\u0005\r\u0005\r!F1\u0001[\t\u0019\tIA\u000bb\u00015\u00121\u0011q\u0002\u0016C\u0002i#a!!\u0006+\u0005\u0004QFABA\u000eU\t\u0007!\f\u0002\u0004\u0002\")\u0012\rA\u0017\u0003\u0007\u0003OQ#\u0019\u0001.\u0005\r\u00055\"F1\u0001[\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uII*\u0002Fa+\u00030\nE&1\u0017B[\u0005o\u0013ILa/\u0003>\n}&\u0011\u0019Bb\u0005\u000b\u00149M!3\u0003L\n5'q\u001aBi\u0005',\"A!,+\u0007\u0005\u0014y\u0007B\u0003ZW\t\u0007!\fB\u0003dW\t\u0007!\fB\u0003gW\t\u0007!\fB\u0003jW\t\u0007!\fB\u0003mW\t\u0007!\fB\u0003pW\t\u0007!\fB\u0003sW\t\u0007!\fB\u0003vW\t\u0007!\fB\u0003yW\t\u0007!\fB\u0003|W\t\u0007!\fB\u0003\u007fW\t\u0007!\f\u0002\u0004\u0002\u0004-\u0012\rA\u0017\u0003\u0007\u0003\u0013Y#\u0019\u0001.\u0005\r\u0005=1F1\u0001[\t\u0019\t)b\u000bb\u00015\u00121\u00111D\u0016C\u0002i#a!!\t,\u0005\u0004QFABA\u0014W\t\u0007!\f\u0002\u0004\u0002.-\u0012\rAW\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00134+!\u0012IN!8\u0003`\n\u0005(1\u001dBs\u0005O\u0014IOa;\u0003n\n=(\u0011\u001fBz\u0005k\u00149P!?\u0003|\nu(q`B\u0001+\t\u0011YNK\u0002e\u0005_\"Q!\u0017\u0017C\u0002i#Qa\u0019\u0017C\u0002i#QA\u001a\u0017C\u0002i#Q!\u001b\u0017C\u0002i#Q\u0001\u001c\u0017C\u0002i#Qa\u001c\u0017C\u0002i#QA\u001d\u0017C\u0002i#Q!\u001e\u0017C\u0002i#Q\u0001\u001f\u0017C\u0002i#Qa\u001f\u0017C\u0002i#QA \u0017C\u0002i#a!a\u0001-\u0005\u0004QFABA\u0005Y\t\u0007!\f\u0002\u0004\u0002\u00101\u0012\rA\u0017\u0003\u0007\u0003+a#\u0019\u0001.\u0005\r\u0005mAF1\u0001[\t\u0019\t\t\u0003\fb\u00015\u00121\u0011q\u0005\u0017C\u0002i#a!!\f-\u0005\u0004Q\u0016AD2paf$C-\u001a4bk2$H\u0005N\u000b)\u0007\u000f\u0019Ya!\u0004\u0004\u0010\rE11CB\u000b\u0007/\u0019Iba\u0007\u0004\u001e\r}1\u0011EB\u0012\u0007K\u00199c!\u000b\u0004,\r52qF\u000b\u0003\u0007\u0013Q3a\u001aB8\t\u0015IVF1\u0001[\t\u0015\u0019WF1\u0001[\t\u00151WF1\u0001[\t\u0015IWF1\u0001[\t\u0015aWF1\u0001[\t\u0015yWF1\u0001[\t\u0015\u0011XF1\u0001[\t\u0015)XF1\u0001[\t\u0015AXF1\u0001[\t\u0015YXF1\u0001[\t\u0015qXF1\u0001[\t\u0019\t\u0019!\fb\u00015\u00121\u0011\u0011B\u0017C\u0002i#a!a\u0004.\u0005\u0004QFABA\u000b[\t\u0007!\f\u0002\u0004\u0002\u001c5\u0012\rA\u0017\u0003\u0007\u0003Ci#\u0019\u0001.\u0005\r\u0005\u001dRF1\u0001[\t\u0019\ti#\fb\u00015\u0006q1m\u001c9zI\u0011,g-Y;mi\u0012*T\u0003KB\u001b\u0007s\u0019Yd!\u0010\u0004@\r\u000531IB#\u0007\u000f\u001aIea\u0013\u0004N\r=3\u0011KB*\u0007+\u001a9f!\u0017\u0004\\\ruSCAB\u001cU\rQ'q\u000e\u0003\u00063:\u0012\rA\u0017\u0003\u0006G:\u0012\rA\u0017\u0003\u0006M:\u0012\rA\u0017\u0003\u0006S:\u0012\rA\u0017\u0003\u0006Y:\u0012\rA\u0017\u0003\u0006_:\u0012\rA\u0017\u0003\u0006e:\u0012\rA\u0017\u0003\u0006k:\u0012\rA\u0017\u0003\u0006q:\u0012\rA\u0017\u0003\u0006w:\u0012\rA\u0017\u0003\u0006}:\u0012\rA\u0017\u0003\u0007\u0003\u0007q#\u0019\u0001.\u0005\r\u0005%aF1\u0001[\t\u0019\tyA\fb\u00015\u00121\u0011Q\u0003\u0018C\u0002i#a!a\u0007/\u0005\u0004QFABA\u0011]\t\u0007!\f\u0002\u0004\u0002(9\u0012\rA\u0017\u0003\u0007\u0003[q#\u0019\u0001.\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%mUA31MB4\u0007S\u001aYg!\u001c\u0004p\rE41OB;\u0007o\u001aIha\u001f\u0004~\r}4\u0011QBB\u0007\u000b\u001b9i!#\u0004\fV\u00111Q\r\u0016\u0004[\n=D!B-0\u0005\u0004QF!B20\u0005\u0004QF!\u000240\u0005\u0004QF!B50\u0005\u0004QF!\u000270\u0005\u0004QF!B80\u0005\u0004QF!\u0002:0\u0005\u0004QF!B;0\u0005\u0004QF!\u0002=0\u0005\u0004QF!B>0\u0005\u0004QF!\u0002@0\u0005\u0004QFABA\u0002_\t\u0007!\f\u0002\u0004\u0002\n=\u0012\rA\u0017\u0003\u0007\u0003\u001fy#\u0019\u0001.\u0005\r\u0005UqF1\u0001[\t\u0019\tYb\fb\u00015\u00121\u0011\u0011E\u0018C\u0002i#a!a\n0\u0005\u0004QFABA\u0017_\t\u0007!,\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u001c\u0016Q\rE5QSBL\u00073\u001bYj!(\u0004 \u000e\u000561UBS\u0007O\u001bIka+\u0004.\u000e=6\u0011WBZ\u0007k\u001b9l!/\u0016\u0005\rM%f\u00019\u0003p\u0011)\u0011\f\rb\u00015\u0012)1\r\rb\u00015\u0012)a\r\rb\u00015\u0012)\u0011\u000e\rb\u00015\u0012)A\u000e\rb\u00015\u0012)q\u000e\rb\u00015\u0012)!\u000f\rb\u00015\u0012)Q\u000f\rb\u00015\u0012)\u0001\u0010\rb\u00015\u0012)1\u0010\rb\u00015\u0012)a\u0010\rb\u00015\u00121\u00111\u0001\u0019C\u0002i#a!!\u00031\u0005\u0004QFABA\ba\t\u0007!\f\u0002\u0004\u0002\u0016A\u0012\rA\u0017\u0003\u0007\u00037\u0001$\u0019\u0001.\u0005\r\u0005\u0005\u0002G1\u0001[\t\u0019\t9\u0003\rb\u00015\u00121\u0011Q\u0006\u0019C\u0002i\u000babY8qs\u0012\"WMZ1vYR$\u0003(\u0006\u0015\u0004@\u000e\r7QYBd\u0007\u0013\u001cYm!4\u0004P\u000eE71[Bk\u0007/\u001cIna7\u0004^\u000e}7\u0011]Br\u0007K\u001c9/\u0006\u0002\u0004B*\u001a1Oa\u001c\u0005\u000be\u000b$\u0019\u0001.\u0005\u000b\r\f$\u0019\u0001.\u0005\u000b\u0019\f$\u0019\u0001.\u0005\u000b%\f$\u0019\u0001.\u0005\u000b1\f$\u0019\u0001.\u0005\u000b=\f$\u0019\u0001.\u0005\u000bI\f$\u0019\u0001.\u0005\u000bU\f$\u0019\u0001.\u0005\u000ba\f$\u0019\u0001.\u0005\u000bm\f$\u0019\u0001.\u0005\u000by\f$\u0019\u0001.\u0005\r\u0005\r\u0011G1\u0001[\t\u0019\tI!\rb\u00015\u00121\u0011qB\u0019C\u0002i#a!!\u00062\u0005\u0004QFABA\u000ec\t\u0007!\f\u0002\u0004\u0002\"E\u0012\rA\u0017\u0003\u0007\u0003O\t$\u0019\u0001.\u0005\r\u00055\u0012G1\u0001[\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIe*\u0002f!<\u0004r\u000eM8Q_B|\u0007s\u001cYp!@\u0004\u0000\u0012\u0005A1\u0001C\u0003\t\u000f!I\u0001b\u0003\u0005\u000e\u0011=A\u0011\u0003C\n\t+)\"aa<+\u0007Y\u0014y\u0007B\u0003Ze\t\u0007!\fB\u0003de\t\u0007!\fB\u0003ge\t\u0007!\fB\u0003je\t\u0007!\fB\u0003me\t\u0007!\fB\u0003pe\t\u0007!\fB\u0003se\t\u0007!\fB\u0003ve\t\u0007!\fB\u0003ye\t\u0007!\fB\u0003|e\t\u0007!\fB\u0003\u007fe\t\u0007!\f\u0002\u0004\u0002\u0004I\u0012\rA\u0017\u0003\u0007\u0003\u0013\u0011$\u0019\u0001.\u0005\r\u0005=!G1\u0001[\t\u0019\t)B\rb\u00015\u00121\u00111\u0004\u001aC\u0002i#a!!\t3\u0005\u0004QFABA\u0014e\t\u0007!\f\u0002\u0004\u0002.I\u0012\rAW\u0001\u0010G>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00132aUAC1\u0004C\u0010\tC!\u0019\u0003\"\n\u0005(\u0011%B1\u0006C\u0017\t_!\t\u0004b\r\u00056\u0011]B\u0011\bC\u001e\t{!y\u0004\"\u0011\u0005DU\u0011AQ\u0004\u0016\u0004s\n=D!B-4\u0005\u0004QF!B24\u0005\u0004QF!\u000244\u0005\u0004QF!B54\u0005\u0004QF!\u000274\u0005\u0004QF!B84\u0005\u0004QF!\u0002:4\u0005\u0004QF!B;4\u0005\u0004QF!\u0002=4\u0005\u0004QF!B>4\u0005\u0004QF!\u0002@4\u0005\u0004QFABA\u0002g\t\u0007!\f\u0002\u0004\u0002\nM\u0012\rA\u0017\u0003\u0007\u0003\u001f\u0019$\u0019\u0001.\u0005\r\u0005U1G1\u0001[\t\u0019\tYb\rb\u00015\u00121\u0011\u0011E\u001aC\u0002i#a!a\n4\u0005\u0004QFABA\u0017g\t\u0007!,A\bd_BLH\u0005Z3gCVdG\u000fJ\u00192+!\"I\u0005\"\u0014\u0005P\u0011EC1\u000bC+\t/\"I\u0006b\u0017\u0005^\u0011}C\u0011\rC2\tK\"9\u0007\"\u001b\u0005l\u00115Dq\u000eC9+\t!YEK\u0002}\u0005_\"Q!\u0017\u001bC\u0002i#Qa\u0019\u001bC\u0002i#QA\u001a\u001bC\u0002i#Q!\u001b\u001bC\u0002i#Q\u0001\u001c\u001bC\u0002i#Qa\u001c\u001bC\u0002i#QA\u001d\u001bC\u0002i#Q!\u001e\u001bC\u0002i#Q\u0001\u001f\u001bC\u0002i#Qa\u001f\u001bC\u0002i#QA \u001bC\u0002i#a!a\u00015\u0005\u0004QFABA\u0005i\t\u0007!\f\u0002\u0004\u0002\u0010Q\u0012\rA\u0017\u0003\u0007\u0003+!$\u0019\u0001.\u0005\r\u0005mAG1\u0001[\t\u0019\t\t\u0003\u000eb\u00015\u00121\u0011q\u0005\u001bC\u0002i#a!!\f5\u0005\u0004Q\u0016aD2paf$C-\u001a4bk2$H%\r\u001a\u0016Q\u0011]D1\u0010C?\t\u007f\"\t\tb!\u0005\u0006\u0012\u001dE\u0011\u0012CF\t\u001b#y\t\"%\u0005\u0014\u0012UEq\u0013CM\t7#i\nb(\u0016\u0005\u0011e$fA@\u0003p\u0011)\u0011,\u000eb\u00015\u0012)1-\u000eb\u00015\u0012)a-\u000eb\u00015\u0012)\u0011.\u000eb\u00015\u0012)A.\u000eb\u00015\u0012)q.\u000eb\u00015\u0012)!/\u000eb\u00015\u0012)Q/\u000eb\u00015\u0012)\u00010\u000eb\u00015\u0012)10\u000eb\u00015\u0012)a0\u000eb\u00015\u00121\u00111A\u001bC\u0002i#a!!\u00036\u0005\u0004QFABA\bk\t\u0007!\f\u0002\u0004\u0002\u0016U\u0012\rA\u0017\u0003\u0007\u00037)$\u0019\u0001.\u0005\r\u0005\u0005RG1\u0001[\t\u0019\t9#\u000eb\u00015\u00121\u0011QF\u001bC\u0002i\u000bqbY8qs\u0012\"WMZ1vYR$\u0013gM\u000b)\tK#I\u000bb+\u0005.\u0012=F\u0011\u0017CZ\tk#9\f\"/\u0005<\u0012uFq\u0018Ca\t\u0007$)\rb2\u0005J\u0012-GQZ\u000b\u0003\tOSC!!\u0002\u0003p\u0011)\u0011L\u000eb\u00015\u0012)1M\u000eb\u00015\u0012)aM\u000eb\u00015\u0012)\u0011N\u000eb\u00015\u0012)AN\u000eb\u00015\u0012)qN\u000eb\u00015\u0012)!O\u000eb\u00015\u0012)QO\u000eb\u00015\u0012)\u0001P\u000eb\u00015\u0012)1P\u000eb\u00015\u0012)aP\u000eb\u00015\u00121\u00111\u0001\u001cC\u0002i#a!!\u00037\u0005\u0004QFABA\bm\t\u0007!\f\u0002\u0004\u0002\u0016Y\u0012\rA\u0017\u0003\u0007\u000371$\u0019\u0001.\u0005\r\u0005\u0005bG1\u0001[\t\u0019\t9C\u000eb\u00015\u00121\u0011Q\u0006\u001cC\u0002i\u000bqbY8qs\u0012\"WMZ1vYR$\u0013\u0007N\u000b)\t'$9\u000e\"7\u0005\\\u0012uGq\u001cCq\tG$)\u000fb:\u0005j\u0012-HQ\u001eCx\tc$\u0019\u0010\">\u0005x\u0012eH1`\u000b\u0003\t+TC!a\u0003\u0003p\u0011)\u0011l\u000eb\u00015\u0012)1m\u000eb\u00015\u0012)am\u000eb\u00015\u0012)\u0011n\u000eb\u00015\u0012)An\u000eb\u00015\u0012)qn\u000eb\u00015\u0012)!o\u000eb\u00015\u0012)Qo\u000eb\u00015\u0012)\u0001p\u000eb\u00015\u0012)1p\u000eb\u00015\u0012)ap\u000eb\u00015\u00121\u00111A\u001cC\u0002i#a!!\u00038\u0005\u0004QFABA\bo\t\u0007!\f\u0002\u0004\u0002\u0016]\u0012\rA\u0017\u0003\u0007\u000379$\u0019\u0001.\u0005\r\u0005\u0005rG1\u0001[\t\u0019\t9c\u000eb\u00015\u00121\u0011QF\u001cC\u0002i\u000bqbY8qs\u0012\"WMZ1vYR$\u0013'N\u000b)\u000b\u0003))!b\u0002\u0006\n\u0015-QQBC\b\u000b#)\u0019\"\"\u0006\u0006\u0018\u0015eQ1DC\u000f\u000b?)\t#b\t\u0006&\u0015\u001dR\u0011F\u000b\u0003\u000b\u0007QC!!\u0005\u0003p\u0011)\u0011\f\u000fb\u00015\u0012)1\r\u000fb\u00015\u0012)a\r\u000fb\u00015\u0012)\u0011\u000e\u000fb\u00015\u0012)A\u000e\u000fb\u00015\u0012)q\u000e\u000fb\u00015\u0012)!\u000f\u000fb\u00015\u0012)Q\u000f\u000fb\u00015\u0012)\u0001\u0010\u000fb\u00015\u0012)1\u0010\u000fb\u00015\u0012)a\u0010\u000fb\u00015\u00121\u00111\u0001\u001dC\u0002i#a!!\u00039\u0005\u0004QFABA\bq\t\u0007!\f\u0002\u0004\u0002\u0016a\u0012\rA\u0017\u0003\u0007\u00037A$\u0019\u0001.\u0005\r\u0005\u0005\u0002H1\u0001[\t\u0019\t9\u0003\u000fb\u00015\u00121\u0011Q\u0006\u001dC\u0002i\u000bqbY8qs\u0012\"WMZ1vYR$\u0013GN\u000b)\u000b_)\u0019$\"\u000e\u00068\u0015eR1HC\u001f\u000b\u007f)\t%b\u0011\u0006F\u0015\u001dS\u0011JC&\u000b\u001b*y%\"\u0015\u0006T\u0015USqK\u000b\u0003\u000bcQC!a\u0006\u0003p\u0011)\u0011,\u000fb\u00015\u0012)1-\u000fb\u00015\u0012)a-\u000fb\u00015\u0012)\u0011.\u000fb\u00015\u0012)A.\u000fb\u00015\u0012)q.\u000fb\u00015\u0012)!/\u000fb\u00015\u0012)Q/\u000fb\u00015\u0012)\u00010\u000fb\u00015\u0012)10\u000fb\u00015\u0012)a0\u000fb\u00015\u00121\u00111A\u001dC\u0002i#a!!\u0003:\u0005\u0004QFABA\bs\t\u0007!\f\u0002\u0004\u0002\u0016e\u0012\rA\u0017\u0003\u0007\u00037I$\u0019\u0001.\u0005\r\u0005\u0005\u0012H1\u0001[\t\u0019\t9#\u000fb\u00015\u00121\u0011QF\u001dC\u0002i\u000bqbY8qs\u0012\"WMZ1vYR$\u0013gN\u000b)\u000b;*\t'b\u0019\u0006f\u0015\u001dT\u0011NC6\u000b[*y'\"\u001d\u0006t\u0015UTqOC=\u000bw*i(b \u0006\u0002\u0016\rUQQ\u000b\u0003\u000b?RC!!\b\u0003p\u0011)\u0011L\u000fb\u00015\u0012)1M\u000fb\u00015\u0012)aM\u000fb\u00015\u0012)\u0011N\u000fb\u00015\u0012)AN\u000fb\u00015\u0012)qN\u000fb\u00015\u0012)!O\u000fb\u00015\u0012)QO\u000fb\u00015\u0012)\u0001P\u000fb\u00015\u0012)1P\u000fb\u00015\u0012)aP\u000fb\u00015\u00121\u00111\u0001\u001eC\u0002i#a!!\u0003;\u0005\u0004QFABA\bu\t\u0007!\f\u0002\u0004\u0002\u0016i\u0012\rA\u0017\u0003\u0007\u00037Q$\u0019\u0001.\u0005\r\u0005\u0005\"H1\u0001[\t\u0019\t9C\u000fb\u00015\u00121\u0011Q\u0006\u001eC\u0002i\u000bqbY8qs\u0012\"WMZ1vYR$\u0013\u0007O\u000b)\u000b\u0017+y)\"%\u0006\u0014\u0016UUqSCM\u000b7+i*b(\u0006\"\u0016\rVQUCT\u000bS+Y+\",\u00060\u0016EV1W\u000b\u0003\u000b\u001bSC!a\t\u0003p\u0011)\u0011l\u000fb\u00015\u0012)1m\u000fb\u00015\u0012)am\u000fb\u00015\u0012)\u0011n\u000fb\u00015\u0012)An\u000fb\u00015\u0012)qn\u000fb\u00015\u0012)!o\u000fb\u00015\u0012)Qo\u000fb\u00015\u0012)\u0001p\u000fb\u00015\u0012)1p\u000fb\u00015\u0012)ap\u000fb\u00015\u00121\u00111A\u001eC\u0002i#a!!\u0003<\u0005\u0004QFABA\bw\t\u0007!\f\u0002\u0004\u0002\u0016m\u0012\rA\u0017\u0003\u0007\u00037Y$\u0019\u0001.\u0005\r\u0005\u00052H1\u0001[\t\u0019\t9c\u000fb\u00015\u00121\u0011QF\u001eC\u0002i\u000bqbY8qs\u0012\"WMZ1vYR$\u0013'O\u000b)\u000bs+i,b0\u0006B\u0016\rWQYCd\u000b\u0013,Y-\"4\u0006P\u0016EW1[Ck\u000b/,I.b7\u0006^\u0016}W\u0011]\u000b\u0003\u000bwSC!!\u000b\u0003p\u0011)\u0011\f\u0010b\u00015\u0012)1\r\u0010b\u00015\u0012)a\r\u0010b\u00015\u0012)\u0011\u000e\u0010b\u00015\u0012)A\u000e\u0010b\u00015\u0012)q\u000e\u0010b\u00015\u0012)!\u000f\u0010b\u00015\u0012)Q\u000f\u0010b\u00015\u0012)\u0001\u0010\u0010b\u00015\u0012)1\u0010\u0010b\u00015\u0012)a\u0010\u0010b\u00015\u00121\u00111\u0001\u001fC\u0002i#a!!\u0003=\u0005\u0004QFABA\by\t\u0007!\f\u0002\u0004\u0002\u0016q\u0012\rA\u0017\u0003\u0007\u00037a$\u0019\u0001.\u0005\r\u0005\u0005BH1\u0001[\t\u0019\t9\u0003\u0010b\u00015\u00121\u0011Q\u0006\u001fC\u0002i\u000bQ\u0002\u001d:pIV\u001cG\u000f\u0015:fM&DXCAAo\u0003=\u0001(o\u001c3vGRLE/\u001a:bi>\u0014XCACv!\u0015)i/b=_\u001b\t)yOC\u0002\u0006r*\u000b!bY8mY\u0016\u001cG/[8o\u0013\u0011))0b<\u0003\u0011%#XM]1u_J\f\u0001bY1o\u000bF,\u0018\r\u001c\u000b\u0005\u000bw4\t\u0001E\u0002Q\u000b{L1!b@K\u0005\u001d\u0011un\u001c7fC:D\u0001Bb\u0001@\u0003\u0003\u0005\rAX\u0001\u0004q\u0012\n\u0014\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0005\u0019%\u0001c\u0001)\u0007\f%\u0019aQ\u0002&\u0003\u0007%sG/\u0001\u0004fcV\fGn\u001d\u000b\u0005\u000bw4\u0019\u0002\u0003\u0005\u0007\u0004\u0005\u000b\t\u00111\u0001_\u0003\u001d!V\u000f\u001d7fce\u0002\"\u0001U\"\u0014\t\r{\u0015Q\u0007\u000b\u0003\r/\tQ!\u00199qYf,\u0002F\"\t\u0007(\u0019-bq\u0006D\u001a\ro1YDb\u0010\u0007D\u0019\u001dc1\nD(\r'29Fb\u0017\u0007`\u0019\rdq\rD6\r_\"\u0002Fb\t\u0007r\u0019MdQ\u000fD<\rs2YH\" \u0007\u0000\u0019\u0005e1\u0011DC\r\u000f3IIb#\u0007\u000e\u001a=e\u0011\u0013DJ\r+\u0003\u0002\u0006\u0015\u0001\u0007&\u0019%bQ\u0006D\u0019\rk1ID\"\u0010\u0007B\u0019\u0015c\u0011\nD'\r#2)F\"\u0017\u0007^\u0019\u0005dQ\rD5\r[\u00022a\u0016D\u0014\t\u0015IfI1\u0001[!\r9f1\u0006\u0003\u0006G\u001a\u0013\rA\u0017\t\u0004/\u001a=B!\u00024G\u0005\u0004Q\u0006cA,\u00074\u0011)\u0011N\u0012b\u00015B\u0019qKb\u000e\u0005\u000b14%\u0019\u0001.\u0011\u0007]3Y\u0004B\u0003p\r\n\u0007!\fE\u0002X\r\u007f!QA\u001d$C\u0002i\u00032a\u0016D\"\t\u0015)hI1\u0001[!\r9fq\t\u0003\u0006q\u001a\u0013\rA\u0017\t\u0004/\u001a-C!B>G\u0005\u0004Q\u0006cA,\u0007P\u0011)aP\u0012b\u00015B\u0019qKb\u0015\u0005\r\u0005\raI1\u0001[!\r9fq\u000b\u0003\u0007\u0003\u00131%\u0019\u0001.\u0011\u0007]3Y\u0006\u0002\u0004\u0002\u0010\u0019\u0013\rA\u0017\t\u0004/\u001a}CABA\u000b\r\n\u0007!\fE\u0002X\rG\"a!a\u0007G\u0005\u0004Q\u0006cA,\u0007h\u00111\u0011\u0011\u0005$C\u0002i\u00032a\u0016D6\t\u0019\t9C\u0012b\u00015B\u0019qKb\u001c\u0005\r\u00055bI1\u0001[\u0011\u001d\tYD\u0012a\u0001\rKAq!!\u0011G\u0001\u00041I\u0003C\u0004\u0002H\u0019\u0003\rA\"\f\t\u000f\u00055c\t1\u0001\u00072!9\u00111\u000b$A\u0002\u0019U\u0002bBA-\r\u0002\u0007a\u0011\b\u0005\b\u0003?2\u0005\u0019\u0001D\u001f\u0011\u001d\t)G\u0012a\u0001\r\u0003Bq!a\u001bG\u0001\u00041)\u0005C\u0004\u0002r\u0019\u0003\rA\"\u0013\t\u000f\u0005]d\t1\u0001\u0007N!9\u0011Q\u0010$A\u0002\u0019E\u0003bBAB\r\u0002\u0007aQ\u000b\u0005\b\u0003\u00133\u0005\u0019\u0001D-\u0011\u001d\tyI\u0012a\u0001\r;Bq!!&G\u0001\u00041\t\u0007C\u0004\u0002\u001c\u001a\u0003\rA\"\u001a\t\u000f\u0005\u0005f\t1\u0001\u0007j!9\u0011q\u0015$A\u0002\u00195\u0014aB;oCB\u0004H._\u000b)\r739Kb+\u00070\u001aMfq\u0017D^\r\u007f3\u0019Mb2\u0007L\u001a=g1\u001bDl\r74yNb9\u0007h\u001a-hq\u001e\u000b\u0005\r;3\t\u0010E\u0003Q\r?3\u0019+C\u0002\u0007\"*\u0013aa\u00149uS>t\u0007\u0003\u000b)\u0001\rK3IK\",\u00072\u001aUf\u0011\u0018D_\r\u00034)M\"3\u0007N\u001aEgQ\u001bDm\r;4\tO\":\u0007j\u001a5\bcA,\u0007(\u0012)\u0011l\u0012b\u00015B\u0019qKb+\u0005\u000b\r<%\u0019\u0001.\u0011\u0007]3y\u000bB\u0003g\u000f\n\u0007!\fE\u0002X\rg#Q![$C\u0002i\u00032a\u0016D\\\t\u0015awI1\u0001[!\r9f1\u0018\u0003\u0006_\u001e\u0013\rA\u0017\t\u0004/\u001a}F!\u0002:H\u0005\u0004Q\u0006cA,\u0007D\u0012)Qo\u0012b\u00015B\u0019qKb2\u0005\u000ba<%\u0019\u0001.\u0011\u0007]3Y\rB\u0003|\u000f\n\u0007!\fE\u0002X\r\u001f$QA`$C\u0002i\u00032a\u0016Dj\t\u0019\t\u0019a\u0012b\u00015B\u0019qKb6\u0005\r\u0005%qI1\u0001[!\r9f1\u001c\u0003\u0007\u0003\u001f9%\u0019\u0001.\u0011\u0007]3y\u000e\u0002\u0004\u0002\u0016\u001d\u0013\rA\u0017\t\u0004/\u001a\rHABA\u000e\u000f\n\u0007!\fE\u0002X\rO$a!!\tH\u0005\u0004Q\u0006cA,\u0007l\u00121\u0011qE$C\u0002i\u00032a\u0016Dx\t\u0019\tic\u0012b\u00015\"Ia1_$\u0002\u0002\u0003\u0007a1U\u0001\u0004q\u0012\u0002\u0014a\u0003:fC\u0012\u0014Vm]8mm\u0016$\"A\"?\u0011\t\u0005}g1`\u0005\u0005\r{\f\tO\u0001\u0004PE*,7\r\u001e")
public final class Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>
implements Product19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>,
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
    private final T19 _19;

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> Option<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>> unapply(Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> tuple19) {
        return Tuple19$.MODULE$.unapply(tuple19);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> apply(T1 T1, T2 T2, T3 T3, T4 T4, T5 T5, T6 T6, T7 T7, T8 T8, T9 T9, T10 T10, T11 T11, T12 T12, T13 T13, T14 T14, T15 T15, T16 T16, T17 T17, T18 T18, T19 T19) {
        return Tuple19$.MODULE$.apply(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19);
    }

    @Override
    public int productArity() {
        return Product19.productArity$(this);
    }

    @Override
    public Object productElement(int n) throws IndexOutOfBoundsException {
        return Product19.productElement$(this, n);
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

    @Override
    public T19 _19() {
        return this._19;
    }

    public String toString() {
        return new StringBuilder(20).append("(").append(this._1()).append(",").append(this._2()).append(",").append(this._3()).append(",").append(this._4()).append(",").append(this._5()).append(",").append(this._6()).append(",").append(this._7()).append(",").append(this._8()).append(",").append(this._9()).append(",").append(this._10()).append(",").append(this._11()).append(",").append(this._12()).append(",").append(this._13()).append(",").append(this._14()).append(",").append(this._15()).append(",").append(this._16()).append(",").append(this._17()).append(",").append(this._18()).append(",").append(this._19()).append(")").toString();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> copy(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6, T7 _7, T8 _8, T9 _9, T10 _10, T11 _11, T12 _12, T13 _13, T14 _14, T15 _15, T16 _16, T17 _17, T18 _18, T19 _19) {
        return new Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19);
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> T1 copy$default$1() {
        return this._1();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> T10 copy$default$10() {
        return this._10();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> T11 copy$default$11() {
        return this._11();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> T12 copy$default$12() {
        return this._12();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> T13 copy$default$13() {
        return this._13();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> T14 copy$default$14() {
        return this._14();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> T15 copy$default$15() {
        return this._15();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> T16 copy$default$16() {
        return this._16();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> T17 copy$default$17() {
        return this._17();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> T18 copy$default$18() {
        return this._18();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> T19 copy$default$19() {
        return this._19();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> T2 copy$default$2() {
        return this._2();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> T3 copy$default$3() {
        return this._3();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> T4 copy$default$4() {
        return this._4();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> T5 copy$default$5() {
        return this._5();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> T6 copy$default$6() {
        return this._6();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> T7 copy$default$7() {
        return this._7();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> T8 copy$default$8() {
        return this._8();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> T9 copy$default$9() {
        return this._9();
    }

    @Override
    public String productPrefix() {
        return "Tuple19";
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof Tuple19;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof Tuple19;
                if (!bl) break block3;
                Tuple19 tuple19 = (Tuple19)x$1;
                if (!(BoxesRunTime.equals(this._1(), tuple19._1()) && BoxesRunTime.equals(this._2(), tuple19._2()) && BoxesRunTime.equals(this._3(), tuple19._3()) && BoxesRunTime.equals(this._4(), tuple19._4()) && BoxesRunTime.equals(this._5(), tuple19._5()) && BoxesRunTime.equals(this._6(), tuple19._6()) && BoxesRunTime.equals(this._7(), tuple19._7()) && BoxesRunTime.equals(this._8(), tuple19._8()) && BoxesRunTime.equals(this._9(), tuple19._9()) && BoxesRunTime.equals(this._10(), tuple19._10()) && BoxesRunTime.equals(this._11(), tuple19._11()) && BoxesRunTime.equals(this._12(), tuple19._12()) && BoxesRunTime.equals(this._13(), tuple19._13()) && BoxesRunTime.equals(this._14(), tuple19._14()) && BoxesRunTime.equals(this._15(), tuple19._15()) && BoxesRunTime.equals(this._16(), tuple19._16()) && BoxesRunTime.equals(this._17(), tuple19._17()) && BoxesRunTime.equals(this._18(), tuple19._18()) && BoxesRunTime.equals(this._19(), tuple19._19()))) break block3;
            }
            return true;
        }
        return false;
    }

    public Tuple19(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6, T7 _7, T8 _8, T9 _9, T10 _10, T11 _11, T12 _12, T13 _13, T14 _14, T15 _15, T16 _16, T17 _17, T18 _18, T19 _19) {
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
        this._19 = _19;
        Product.$init$(this);
        Product19.$init$(this);
    }
}

