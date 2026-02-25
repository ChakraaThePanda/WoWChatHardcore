/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Option;
import scala.Product;
import scala.Product9;
import scala.Serializable;
import scala.Tuple9$;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\r]a\u0001B\u0016-\u0005>B\u0001\"\u0019\u0001\u0003\u0016\u0004%\tA\u0019\u0005\tG\u0002\u0011\t\u0012)A\u0005q!AA\r\u0001BK\u0002\u0013\u0005Q\r\u0003\u0005g\u0001\tE\t\u0015!\u0003D\u0011!9\u0007A!f\u0001\n\u0003A\u0007\u0002C5\u0001\u0005#\u0005\u000b\u0011\u0002$\t\u0011)\u0004!Q3A\u0005\u0002-D\u0001\u0002\u001c\u0001\u0003\u0012\u0003\u0006I!\u0013\u0005\t[\u0002\u0011)\u001a!C\u0001]\"Aq\u000e\u0001B\tB\u0003%A\n\u0003\u0005q\u0001\tU\r\u0011\"\u0001r\u0011!\u0011\bA!E!\u0002\u0013y\u0005\u0002C:\u0001\u0005+\u0007I\u0011\u0001;\t\u0011U\u0004!\u0011#Q\u0001\nIC\u0001B\u001e\u0001\u0003\u0016\u0004%\ta\u001e\u0005\tq\u0002\u0011\t\u0012)A\u0005+\"A\u0011\u0010\u0001BK\u0002\u0013\u0005!\u0010\u0003\u0005|\u0001\tE\t\u0015!\u0003Y\u0011\u0015a\b\u0001\"\u0001~\u0011\u001d\t\t\u0002\u0001C!\u0003'A\u0011\"!\n\u0001\u0003\u0003%\t!a\n\t\u0013\u0005\r\u0004!%A\u0005\u0002\u0005\u0015\u0004\"CAH\u0001E\u0005I\u0011AAI\u0011%\tI\u000bAI\u0001\n\u0003\tY\u000bC\u0005\u0002D\u0002\t\n\u0011\"\u0001\u0002F\"I\u0011Q\u001c\u0001\u0012\u0002\u0013\u0005\u0011q\u001c\u0005\n\u0003o\u0004\u0011\u0013!C\u0001\u0003sD\u0011B!\u0005\u0001#\u0003%\tAa\u0005\t\u0013\t-\u0002!%A\u0005\u0002\t5\u0002\"\u0003B#\u0001E\u0005I\u0011\u0001B$\u0011%\u0011y\u0006AA\u0001\n\u0003\u0012\t\u0007C\u0005\u0003d\u0001\t\t\u0011\"\u0011\u0003f!I!1\u000f\u0001\u0002\u0002\u0013\u0005!Q\u000f\u0005\n\u0005\u0003\u0003\u0011\u0011!C!\u0005\u0007C\u0011Ba#\u0001\u0003\u0003%\tE!$\b\u0013\tEE&!A\t\u0002\tMe\u0001C\u0016-\u0003\u0003E\tA!&\t\rq,C\u0011\u0001BL\u0011%\t\t\"JA\u0001\n\u000b\n\u0019\u0002C\u0005\u0003\u001a\u0016\n\t\u0011\"!\u0003\u001c\"I!q[\u0013\u0002\u0002\u0013\u0005%\u0011\u001c\u0005\n\u0007\u001b)\u0013\u0011!C\u0005\u0007\u001f\u0011a\u0001V;qY\u0016L$\"A\u0017\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001UQ\u0001G\u000f#H\u00156\u00036KV-\u0014\u000b\u0001\tTg\u00170\u0011\u0005I\u001aT\"\u0001\u0017\n\u0005Qb#AB!osJ+g\rE\u00063ma\u001ae)\u0013'P%VC\u0016BA\u001c-\u0005!\u0001&o\u001c3vGRL\u0004CA\u001d;\u0019\u0001!aa\u000f\u0001\u0005\u0006\u0004a$A\u0001+2#\ti\u0004\t\u0005\u00023}%\u0011q\b\f\u0002\b\u001d>$\b.\u001b8h!\t\u0011\u0014)\u0003\u0002CY\t\u0019\u0011I\\=\u0011\u0005e\"EAB#\u0001\t\u000b\u0007AH\u0001\u0002UeA\u0011\u0011h\u0012\u0003\u0007\u0011\u0002!)\u0019\u0001\u001f\u0003\u0005Q\u001b\u0004CA\u001dK\t\u0019Y\u0005\u0001\"b\u0001y\t\u0011A\u000b\u000e\t\u0003s5#aA\u0014\u0001\u0005\u0006\u0004a$A\u0001+6!\tI\u0004\u000b\u0002\u0004R\u0001\u0011\u0015\r\u0001\u0010\u0002\u0003)Z\u0002\"!O*\u0005\rQ\u0003AQ1\u0001=\u0005\t!v\u0007\u0005\u0002:-\u00121q\u000b\u0001CC\u0002q\u0012!\u0001\u0016\u001d\u0011\u0005eJFA\u0002.\u0001\t\u000b\u0007AH\u0001\u0002UsA\u0011!\u0007X\u0005\u0003;2\u0012q\u0001\u0015:pIV\u001cG\u000f\u0005\u00023?&\u0011\u0001\r\f\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0003?F*\u0012\u0001O\u0001\u0004?F\u0002\u0013AA03+\u0005\u0019\u0015aA03A\u0005\u0011qlM\u000b\u0002\r\u0006\u0019ql\r\u0011\u0002\u0005}#T#A%\u0002\u0007}#\u0004%\u0001\u0002`kU\tA*A\u0002`k\u0001\n!a\u0018\u001c\u0016\u0003=\u000b1a\u0018\u001c!\u0003\tyv'F\u0001S\u0003\ryv\u0007I\u0001\u0003?b*\u0012!V\u0001\u0004?b\u0002\u0013AA0:+\u0005A\u0016aA0:A\u00051A(\u001b8jiz\"\"C`@\u0002\u0002\u0005\r\u0011QAA\u0004\u0003\u0013\tY!!\u0004\u0002\u0010AY!\u0007\u0001\u001dD\r&cuJU+Y\u0011\u0015\t7\u00031\u00019\u0011\u0015!7\u00031\u0001D\u0011\u001597\u00031\u0001G\u0011\u0015Q7\u00031\u0001J\u0011\u0015i7\u00031\u0001M\u0011\u0015\u00018\u00031\u0001P\u0011\u0015\u00198\u00031\u0001S\u0011\u001518\u00031\u0001V\u0011\u0015I8\u00031\u0001Y\u0003!!xn\u0015;sS:<GCAA\u000b!\u0011\t9\"!\t\u000e\u0005\u0005e!\u0002BA\u000e\u0003;\tA\u0001\\1oO*\u0011\u0011qD\u0001\u0005U\u00064\u0018-\u0003\u0003\u0002$\u0005e!AB*ue&tw-\u0001\u0003d_BLX\u0003FA\u0015\u0003_\t\u0019$a\u000e\u0002<\u0005}\u00121IA$\u0003\u0017\ny\u0005\u0006\u000b\u0002,\u0005E\u00131KA+\u0003/\nI&a\u0017\u0002^\u0005}\u0013\u0011\r\t\u0015e\u0001\ti#!\r\u00026\u0005e\u0012QHA!\u0003\u000b\nI%!\u0014\u0011\u0007e\ny\u0003B\u0003<+\t\u0007A\bE\u0002:\u0003g!Q!R\u000bC\u0002q\u00022!OA\u001c\t\u0015AUC1\u0001=!\rI\u00141\b\u0003\u0006\u0017V\u0011\r\u0001\u0010\t\u0004s\u0005}B!\u0002(\u0016\u0005\u0004a\u0004cA\u001d\u0002D\u0011)\u0011+\u0006b\u0001yA\u0019\u0011(a\u0012\u0005\u000bQ+\"\u0019\u0001\u001f\u0011\u0007e\nY\u0005B\u0003X+\t\u0007A\bE\u0002:\u0003\u001f\"QAW\u000bC\u0002qB\u0001\"Y\u000b\u0011\u0002\u0003\u0007\u0011Q\u0006\u0005\tIV\u0001\n\u00111\u0001\u00022!Aq-\u0006I\u0001\u0002\u0004\t)\u0004\u0003\u0005k+A\u0005\t\u0019AA\u001d\u0011!iW\u0003%AA\u0002\u0005u\u0002\u0002\u00039\u0016!\u0003\u0005\r!!\u0011\t\u0011M,\u0002\u0013!a\u0001\u0003\u000bB\u0001B^\u000b\u0011\u0002\u0003\u0007\u0011\u0011\n\u0005\tsV\u0001\n\u00111\u0001\u0002N\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012\nT\u0003FA4\u0003{\ny(!!\u0002\u0004\u0006\u0015\u0015qQAE\u0003\u0017\u000bi)\u0006\u0002\u0002j)\u001a\u0001(a\u001b,\u0005\u00055\u0004\u0003BA8\u0003sj!!!\u001d\u000b\t\u0005M\u0014QO\u0001\nk:\u001c\u0007.Z2lK\u0012T1!a\u001e-\u0003)\tgN\\8uCRLwN\\\u0005\u0005\u0003w\n\tHA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016$Qa\u000f\fC\u0002q\"Q!\u0012\fC\u0002q\"Q\u0001\u0013\fC\u0002q\"Qa\u0013\fC\u0002q\"QA\u0014\fC\u0002q\"Q!\u0015\fC\u0002q\"Q\u0001\u0016\fC\u0002q\"Qa\u0016\fC\u0002q\"QA\u0017\fC\u0002q\nabY8qs\u0012\"WMZ1vYR$#'\u0006\u000b\u0002\u0014\u0006]\u0015\u0011TAN\u0003;\u000by*!)\u0002$\u0006\u0015\u0016qU\u000b\u0003\u0003+S3aQA6\t\u0015YtC1\u0001=\t\u0015)uC1\u0001=\t\u0015AuC1\u0001=\t\u0015YuC1\u0001=\t\u0015quC1\u0001=\t\u0015\tvC1\u0001=\t\u0015!vC1\u0001=\t\u00159vC1\u0001=\t\u0015QvC1\u0001=\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIM*B#!,\u00022\u0006M\u0016QWA\\\u0003s\u000bY,!0\u0002@\u0006\u0005WCAAXU\r1\u00151\u000e\u0003\u0006wa\u0011\r\u0001\u0010\u0003\u0006\u000bb\u0011\r\u0001\u0010\u0003\u0006\u0011b\u0011\r\u0001\u0010\u0003\u0006\u0017b\u0011\r\u0001\u0010\u0003\u0006\u001db\u0011\r\u0001\u0010\u0003\u0006#b\u0011\r\u0001\u0010\u0003\u0006)b\u0011\r\u0001\u0010\u0003\u0006/b\u0011\r\u0001\u0010\u0003\u00065b\u0011\r\u0001P\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00135+Q\t9-a3\u0002N\u0006=\u0017\u0011[Aj\u0003+\f9.!7\u0002\\V\u0011\u0011\u0011\u001a\u0016\u0004\u0013\u0006-D!B\u001e\u001a\u0005\u0004aD!B#\u001a\u0005\u0004aD!\u0002%\u001a\u0005\u0004aD!B&\u001a\u0005\u0004aD!\u0002(\u001a\u0005\u0004aD!B)\u001a\u0005\u0004aD!\u0002+\u001a\u0005\u0004aD!B,\u001a\u0005\u0004aD!\u0002.\u001a\u0005\u0004a\u0014AD2paf$C-\u001a4bk2$H%N\u000b\u0015\u0003C\f)/a:\u0002j\u0006-\u0018Q^Ax\u0003c\f\u00190!>\u0016\u0005\u0005\r(f\u0001'\u0002l\u0011)1H\u0007b\u0001y\u0011)QI\u0007b\u0001y\u0011)\u0001J\u0007b\u0001y\u0011)1J\u0007b\u0001y\u0011)aJ\u0007b\u0001y\u0011)\u0011K\u0007b\u0001y\u0011)AK\u0007b\u0001y\u0011)qK\u0007b\u0001y\u0011)!L\u0007b\u0001y\u0005q1m\u001c9zI\u0011,g-Y;mi\u00122T\u0003FA~\u0003\u007f\u0014\tAa\u0001\u0003\u0006\t\u001d!\u0011\u0002B\u0006\u0005\u001b\u0011y!\u0006\u0002\u0002~*\u001aq*a\u001b\u0005\u000bmZ\"\u0019\u0001\u001f\u0005\u000b\u0015[\"\u0019\u0001\u001f\u0005\u000b![\"\u0019\u0001\u001f\u0005\u000b-[\"\u0019\u0001\u001f\u0005\u000b9[\"\u0019\u0001\u001f\u0005\u000bE[\"\u0019\u0001\u001f\u0005\u000bQ[\"\u0019\u0001\u001f\u0005\u000b][\"\u0019\u0001\u001f\u0005\u000bi[\"\u0019\u0001\u001f\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%oU!\"Q\u0003B\r\u00057\u0011iBa\b\u0003\"\t\r\"Q\u0005B\u0014\u0005S)\"Aa\u0006+\u0007I\u000bY\u0007B\u0003<9\t\u0007A\bB\u0003F9\t\u0007A\bB\u0003I9\t\u0007A\bB\u0003L9\t\u0007A\bB\u0003O9\t\u0007A\bB\u0003R9\t\u0007A\bB\u0003U9\t\u0007A\bB\u0003X9\t\u0007A\bB\u0003[9\t\u0007A(\u0001\bd_BLH\u0005Z3gCVdG\u000f\n\u001d\u0016)\t=\"1\u0007B\u001b\u0005o\u0011IDa\u000f\u0003>\t}\"\u0011\tB\"+\t\u0011\tDK\u0002V\u0003W\"QaO\u000fC\u0002q\"Q!R\u000fC\u0002q\"Q\u0001S\u000fC\u0002q\"QaS\u000fC\u0002q\"QAT\u000fC\u0002q\"Q!U\u000fC\u0002q\"Q\u0001V\u000fC\u0002q\"QaV\u000fC\u0002q\"QAW\u000fC\u0002q\nabY8qs\u0012\"WMZ1vYR$\u0013(\u0006\u000b\u0003J\t5#q\nB)\u0005'\u0012)Fa\u0016\u0003Z\tm#QL\u000b\u0003\u0005\u0017R3\u0001WA6\t\u0015YdD1\u0001=\t\u0015)eD1\u0001=\t\u0015AeD1\u0001=\t\u0015YeD1\u0001=\t\u0015qeD1\u0001=\t\u0015\tfD1\u0001=\t\u0015!fD1\u0001=\t\u00159fD1\u0001=\t\u0015QfD1\u0001=\u00035\u0001(o\u001c3vGR\u0004&/\u001a4jqV\u0011\u0011QC\u0001\u0010aJ|G-^2u\u0013R,'/\u0019;peV\u0011!q\r\t\u0006\u0005S\u0012y\u0007Q\u0007\u0003\u0005WR1A!\u001c-\u0003)\u0019w\u000e\u001c7fGRLwN\\\u0005\u0005\u0005c\u0012YG\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003!\u0019\u0017M\\#rk\u0006dG\u0003\u0002B<\u0005{\u00022A\rB=\u0013\r\u0011Y\b\f\u0002\b\u0005>|G.Z1o\u0011!\u0011y(IA\u0001\u0002\u0004\u0001\u0015a\u0001=%c\u0005A\u0001.Y:i\u0007>$W\r\u0006\u0002\u0003\u0006B\u0019!Ga\"\n\u0007\t%EFA\u0002J]R\fa!Z9vC2\u001cH\u0003\u0002B<\u0005\u001fC\u0001Ba $\u0003\u0003\u0005\r\u0001Q\u0001\u0007)V\u0004H.Z\u001d\u0011\u0005I*3cA\u00132=R\u0011!1S\u0001\u0006CB\u0004H._\u000b\u0015\u0005;\u0013\u0019Ka*\u0003,\n=&1\u0017B\\\u0005w\u0013yLa1\u0015)\t}%Q\u0019Bd\u0005\u0013\u0014YM!4\u0003P\nE'1\u001bBk!Q\u0011\u0004A!)\u0003&\n%&Q\u0016BY\u0005k\u0013IL!0\u0003BB\u0019\u0011Ha)\u0005\u000bmB#\u0019\u0001\u001f\u0011\u0007e\u00129\u000bB\u0003FQ\t\u0007A\bE\u0002:\u0005W#Q\u0001\u0013\u0015C\u0002q\u00022!\u000fBX\t\u0015Y\u0005F1\u0001=!\rI$1\u0017\u0003\u0006\u001d\"\u0012\r\u0001\u0010\t\u0004s\t]F!B))\u0005\u0004a\u0004cA\u001d\u0003<\u0012)A\u000b\u000bb\u0001yA\u0019\u0011Ha0\u0005\u000b]C#\u0019\u0001\u001f\u0011\u0007e\u0012\u0019\rB\u0003[Q\t\u0007A\b\u0003\u0004bQ\u0001\u0007!\u0011\u0015\u0005\u0007I\"\u0002\rA!*\t\r\u001dD\u0003\u0019\u0001BU\u0011\u0019Q\u0007\u00061\u0001\u0003.\"1Q\u000e\u000ba\u0001\u0005cCa\u0001\u001d\u0015A\u0002\tU\u0006BB:)\u0001\u0004\u0011I\f\u0003\u0004wQ\u0001\u0007!Q\u0018\u0005\u0007s\"\u0002\rA!1\u0002\u000fUt\u0017\r\u001d9msV!\"1\u001cBt\u0005W\u0014yOa=\u0003x\nm(q`B\u0002\u0007\u000f!BA!8\u0004\nA)!Ga8\u0003d&\u0019!\u0011\u001d\u0017\u0003\r=\u0003H/[8o!Q\u0011\u0004A!:\u0003j\n5(\u0011\u001fB{\u0005s\u0014ip!\u0001\u0004\u0006A\u0019\u0011Ha:\u0005\u000bmJ#\u0019\u0001\u001f\u0011\u0007e\u0012Y\u000fB\u0003FS\t\u0007A\bE\u0002:\u0005_$Q\u0001S\u0015C\u0002q\u00022!\u000fBz\t\u0015Y\u0015F1\u0001=!\rI$q\u001f\u0003\u0006\u001d&\u0012\r\u0001\u0010\t\u0004s\tmH!B)*\u0005\u0004a\u0004cA\u001d\u0003\u0000\u0012)A+\u000bb\u0001yA\u0019\u0011ha\u0001\u0005\u000b]K#\u0019\u0001\u001f\u0011\u0007e\u001a9\u0001B\u0003[S\t\u0007A\bC\u0005\u0004\f%\n\t\u00111\u0001\u0003d\u0006\u0019\u0001\u0010\n\u0019\u0002\u0017I,\u0017\r\u001a*fg>dg/\u001a\u000b\u0003\u0007#\u0001B!a\u0006\u0004\u0014%!1QCA\r\u0005\u0019y%M[3di\u0002")
public final class Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>
implements Product9<T1, T2, T3, T4, T5, T6, T7, T8, T9>,
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

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> Option<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> unapply(Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> tuple9) {
        return Tuple9$.MODULE$.unapply(tuple9);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> apply(T1 T1, T2 T2, T3 T3, T4 T4, T5 T5, T6 T6, T7 T7, T8 T8, T9 T9) {
        return Tuple9$.MODULE$.apply(T1, T2, T3, T4, T5, T6, T7, T8, T9);
    }

    @Override
    public int productArity() {
        return Product9.productArity$(this);
    }

    @Override
    public Object productElement(int n) throws IndexOutOfBoundsException {
        return Product9.productElement$(this, n);
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

    public String toString() {
        return new StringBuilder(10).append("(").append(this._1()).append(",").append(this._2()).append(",").append(this._3()).append(",").append(this._4()).append(",").append(this._5()).append(",").append(this._6()).append(",").append(this._7()).append(",").append(this._8()).append(",").append(this._9()).append(")").toString();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9> Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> copy(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6, T7 _7, T8 _8, T9 _9) {
        return new Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(_1, _2, _3, _4, _5, _6, _7, _8, _9);
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9> T1 copy$default$1() {
        return this._1();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9> T2 copy$default$2() {
        return this._2();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9> T3 copy$default$3() {
        return this._3();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9> T4 copy$default$4() {
        return this._4();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9> T5 copy$default$5() {
        return this._5();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9> T6 copy$default$6() {
        return this._6();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9> T7 copy$default$7() {
        return this._7();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9> T8 copy$default$8() {
        return this._8();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9> T9 copy$default$9() {
        return this._9();
    }

    @Override
    public String productPrefix() {
        return "Tuple9";
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof Tuple9;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof Tuple9;
                if (!bl) break block3;
                Tuple9 tuple9 = (Tuple9)x$1;
                if (!(BoxesRunTime.equals(this._1(), tuple9._1()) && BoxesRunTime.equals(this._2(), tuple9._2()) && BoxesRunTime.equals(this._3(), tuple9._3()) && BoxesRunTime.equals(this._4(), tuple9._4()) && BoxesRunTime.equals(this._5(), tuple9._5()) && BoxesRunTime.equals(this._6(), tuple9._6()) && BoxesRunTime.equals(this._7(), tuple9._7()) && BoxesRunTime.equals(this._8(), tuple9._8()) && BoxesRunTime.equals(this._9(), tuple9._9()))) break block3;
            }
            return true;
        }
        return false;
    }

    public Tuple9(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6, T7 _7, T8 _8, T9 _9) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this._5 = _5;
        this._6 = _6;
        this._7 = _7;
        this._8 = _8;
        this._9 = _9;
        Product.$init$(this);
        Product9.$init$(this);
    }
}

