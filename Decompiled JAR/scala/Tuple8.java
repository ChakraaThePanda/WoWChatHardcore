/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Option;
import scala.Product;
import scala.Product8;
import scala.Serializable;
import scala.Tuple8$;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\t%g\u0001\u0002\u0015*\u00052B\u0001b\u0017\u0001\u0003\u0016\u0004%\t\u0001\u0018\u0005\t;\u0002\u0011\t\u0012)A\u0005k!Aa\f\u0001BK\u0002\u0013\u0005q\f\u0003\u0005a\u0001\tE\t\u0015!\u0003A\u0011!\t\u0007A!f\u0001\n\u0003\u0011\u0007\u0002C2\u0001\u0005#\u0005\u000b\u0011B\"\t\u0011\u0011\u0004!Q3A\u0005\u0002\u0015D\u0001B\u001a\u0001\u0003\u0012\u0003\u0006IA\u0012\u0005\tO\u0002\u0011)\u001a!C\u0001Q\"A\u0011\u000e\u0001B\tB\u0003%\u0011\n\u0003\u0005k\u0001\tU\r\u0011\"\u0001l\u0011!a\u0007A!E!\u0002\u0013a\u0005\u0002C7\u0001\u0005+\u0007I\u0011\u00018\t\u0011=\u0004!\u0011#Q\u0001\n=C\u0001\u0002\u001d\u0001\u0003\u0016\u0004%\t!\u001d\u0005\te\u0002\u0011\t\u0012)A\u0005%\")1\u000f\u0001C\u0001i\")a\u0010\u0001C!\u007f\"I\u0011\u0011\u0003\u0001\u0002\u0002\u0013\u0005\u00111\u0003\u0005\n\u0003\u0013\u0002\u0011\u0013!C\u0001\u0003\u0017B\u0011\"a\u001d\u0001#\u0003%\t!!\u001e\t\u0013\u0005-\u0005!%A\u0005\u0002\u00055\u0005\"CAR\u0001E\u0005I\u0011AAS\u0011%\tY\fAI\u0001\n\u0003\ti\fC\u0005\u0002T\u0002\t\n\u0011\"\u0001\u0002V\"I\u00111\u001e\u0001\u0012\u0002\u0013\u0005\u0011Q\u001e\u0005\n\u0005\u0007\u0001\u0011\u0013!C\u0001\u0005\u000bA\u0011Ba\u0007\u0001\u0003\u0003%\tE!\b\t\u0013\t}\u0001!!A\u0005B\t\u0005\u0002\"\u0003B\u0018\u0001\u0005\u0005I\u0011\u0001B\u0019\u0011%\u0011i\u0004AA\u0001\n\u0003\u0012y\u0004C\u0005\u0003H\u0001\t\t\u0011\"\u0011\u0003J\u001dI!QJ\u0015\u0002\u0002#\u0005!q\n\u0004\tQ%\n\t\u0011#\u0001\u0003R!11O\tC\u0001\u0005'BqA \u0012\u0002\u0002\u0013\u0015s\u0010C\u0005\u0003V\t\n\t\u0011\"!\u0003X!I!Q\u0012\u0012\u0002\u0002\u0013\u0005%q\u0012\u0005\n\u0005\u007f\u0013\u0013\u0011!C\u0005\u0005\u0003\u0014a\u0001V;qY\u0016D$\"\u0001\u0016\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001UIQfN!E\u000f*k\u0005kU\n\u0006\u00019\u0012T\u000b\u0017\t\u0003_Aj\u0011!K\u0005\u0003c%\u0012a!\u00118z%\u00164\u0007CC\u00184k\u0001\u001be)\u0013'P%&\u0011A'\u000b\u0002\t!J|G-^2uqA\u0011ag\u000e\u0007\u0001\t\u0019A\u0004\u0001\"b\u0001s\t\u0011A+M\t\u0003uu\u0002\"aL\u001e\n\u0005qJ#a\u0002(pi\"Lgn\u001a\t\u0003_yJ!aP\u0015\u0003\u0007\u0005s\u0017\u0010\u0005\u00027\u0003\u00121!\t\u0001CC\u0002e\u0012!\u0001\u0016\u001a\u0011\u0005Y\"EAB#\u0001\t\u000b\u0007\u0011H\u0001\u0002UgA\u0011ag\u0012\u0003\u0007\u0011\u0002!)\u0019A\u001d\u0003\u0005Q#\u0004C\u0001\u001cK\t\u0019Y\u0005\u0001\"b\u0001s\t\u0011A+\u000e\t\u0003m5#aA\u0014\u0001\u0005\u0006\u0004I$A\u0001+7!\t1\u0004\u000b\u0002\u0004R\u0001\u0011\u0015\r!\u000f\u0002\u0003)^\u0002\"AN*\u0005\rQ\u0003AQ1\u0001:\u0005\t!\u0006\b\u0005\u00020-&\u0011q+\u000b\u0002\b!J|G-^2u!\ty\u0013,\u0003\u0002[S\ta1+\u001a:jC2L'0\u00192mK\u0006\u0011q,M\u000b\u0002k\u0005\u0019q,\r\u0011\u0002\u0005}\u0013T#\u0001!\u0002\u0007}\u0013\u0004%\u0001\u0002`gU\t1)A\u0002`g\u0001\n!a\u0018\u001b\u0016\u0003\u0019\u000b1a\u0018\u001b!\u0003\tyV'F\u0001J\u0003\ryV\u0007I\u0001\u0003?Z*\u0012\u0001T\u0001\u0004?Z\u0002\u0013AA08+\u0005y\u0015aA08A\u0005\u0011q\fO\u000b\u0002%\u0006\u0019q\f\u000f\u0011\u0002\rqJg.\u001b;?)%)ho\u001e=zundX\u0010\u0005\u00060\u0001U\u00025IR%M\u001fJCQaW\tA\u0002UBQAX\tA\u0002\u0001CQ!Y\tA\u0002\rCQ\u0001Z\tA\u0002\u0019CQaZ\tA\u0002%CQA[\tA\u00021CQ!\\\tA\u0002=CQ\u0001]\tA\u0002I\u000b\u0001\u0002^8TiJLgn\u001a\u000b\u0003\u0003\u0003\u0001B!a\u0001\u0002\u000e5\u0011\u0011Q\u0001\u0006\u0005\u0003\u000f\tI!\u0001\u0003mC:<'BAA\u0006\u0003\u0011Q\u0017M^1\n\t\u0005=\u0011Q\u0001\u0002\u0007'R\u0014\u0018N\\4\u0002\t\r|\u0007/_\u000b\u0013\u0003+\tY\"a\b\u0002$\u0005\u001d\u00121FA\u0018\u0003g\t9\u0004\u0006\n\u0002\u0018\u0005e\u00121HA\u001f\u0003\u007f\t\t%a\u0011\u0002F\u0005\u001d\u0003CE\u0018\u0001\u00033\ti\"!\t\u0002&\u0005%\u0012QFA\u0019\u0003k\u00012ANA\u000e\t\u0015A4C1\u0001:!\r1\u0014q\u0004\u0003\u0006\u0005N\u0011\r!\u000f\t\u0004m\u0005\rB!B#\u0014\u0005\u0004I\u0004c\u0001\u001c\u0002(\u0011)\u0001j\u0005b\u0001sA\u0019a'a\u000b\u0005\u000b-\u001b\"\u0019A\u001d\u0011\u0007Y\ny\u0003B\u0003O'\t\u0007\u0011\bE\u00027\u0003g!Q!U\nC\u0002e\u00022ANA\u001c\t\u0015!6C1\u0001:\u0011!Y6\u0003%AA\u0002\u0005e\u0001\u0002\u00030\u0014!\u0003\u0005\r!!\b\t\u0011\u0005\u001c\u0002\u0013!a\u0001\u0003CA\u0001\u0002Z\n\u0011\u0002\u0003\u0007\u0011Q\u0005\u0005\tON\u0001\n\u00111\u0001\u0002*!A!n\u0005I\u0001\u0002\u0004\ti\u0003\u0003\u0005n'A\u0005\t\u0019AA\u0019\u0011!\u00018\u0003%AA\u0002\u0005U\u0012AD2paf$C-\u001a4bk2$H%M\u000b\u0013\u0003\u001b\n\u0019'!\u001a\u0002h\u0005%\u00141NA7\u0003_\n\t(\u0006\u0002\u0002P)\u001aQ'!\u0015,\u0005\u0005M\u0003\u0003BA+\u0003?j!!a\u0016\u000b\t\u0005e\u00131L\u0001\nk:\u001c\u0007.Z2lK\u0012T1!!\u0018*\u0003)\tgN\\8uCRLwN\\\u0005\u0005\u0003C\n9FA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016$Q\u0001\u000f\u000bC\u0002e\"QA\u0011\u000bC\u0002e\"Q!\u0012\u000bC\u0002e\"Q\u0001\u0013\u000bC\u0002e\"Qa\u0013\u000bC\u0002e\"QA\u0014\u000bC\u0002e\"Q!\u0015\u000bC\u0002e\"Q\u0001\u0016\u000bC\u0002e\nabY8qs\u0012\"WMZ1vYR$#'\u0006\n\u0002x\u0005m\u0014QPA@\u0003\u0003\u000b\u0019)!\"\u0002\b\u0006%UCAA=U\r\u0001\u0015\u0011\u000b\u0003\u0006qU\u0011\r!\u000f\u0003\u0006\u0005V\u0011\r!\u000f\u0003\u0006\u000bV\u0011\r!\u000f\u0003\u0006\u0011V\u0011\r!\u000f\u0003\u0006\u0017V\u0011\r!\u000f\u0003\u0006\u001dV\u0011\r!\u000f\u0003\u0006#V\u0011\r!\u000f\u0003\u0006)V\u0011\r!O\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00134+I\ty)a%\u0002\u0016\u0006]\u0015\u0011TAN\u0003;\u000by*!)\u0016\u0005\u0005E%fA\"\u0002R\u0011)\u0001H\u0006b\u0001s\u0011)!I\u0006b\u0001s\u0011)QI\u0006b\u0001s\u0011)\u0001J\u0006b\u0001s\u0011)1J\u0006b\u0001s\u0011)aJ\u0006b\u0001s\u0011)\u0011K\u0006b\u0001s\u0011)AK\u0006b\u0001s\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012\"TCEAT\u0003W\u000bi+a,\u00022\u0006M\u0016QWA\\\u0003s+\"!!++\u0007\u0019\u000b\t\u0006B\u00039/\t\u0007\u0011\bB\u0003C/\t\u0007\u0011\bB\u0003F/\t\u0007\u0011\bB\u0003I/\t\u0007\u0011\bB\u0003L/\t\u0007\u0011\bB\u0003O/\t\u0007\u0011\bB\u0003R/\t\u0007\u0011\bB\u0003U/\t\u0007\u0011(\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u001b\u0016%\u0005}\u00161YAc\u0003\u000f\fI-a3\u0002N\u0006=\u0017\u0011[\u000b\u0003\u0003\u0003T3!SA)\t\u0015A\u0004D1\u0001:\t\u0015\u0011\u0005D1\u0001:\t\u0015)\u0005D1\u0001:\t\u0015A\u0005D1\u0001:\t\u0015Y\u0005D1\u0001:\t\u0015q\u0005D1\u0001:\t\u0015\t\u0006D1\u0001:\t\u0015!\u0006D1\u0001:\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIY*\"#a6\u0002\\\u0006u\u0017q\\Aq\u0003G\f)/a:\u0002jV\u0011\u0011\u0011\u001c\u0016\u0004\u0019\u0006EC!\u0002\u001d\u001a\u0005\u0004ID!\u0002\"\u001a\u0005\u0004ID!B#\u001a\u0005\u0004ID!\u0002%\u001a\u0005\u0004ID!B&\u001a\u0005\u0004ID!\u0002(\u001a\u0005\u0004ID!B)\u001a\u0005\u0004ID!\u0002+\u001a\u0005\u0004I\u0014AD2paf$C-\u001a4bk2$HeN\u000b\u0013\u0003_\f\u00190!>\u0002x\u0006e\u00181`A\u007f\u0003\u007f\u0014\t!\u0006\u0002\u0002r*\u001aq*!\u0015\u0005\u000baR\"\u0019A\u001d\u0005\u000b\tS\"\u0019A\u001d\u0005\u000b\u0015S\"\u0019A\u001d\u0005\u000b!S\"\u0019A\u001d\u0005\u000b-S\"\u0019A\u001d\u0005\u000b9S\"\u0019A\u001d\u0005\u000bES\"\u0019A\u001d\u0005\u000bQS\"\u0019A\u001d\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%qU\u0011\"q\u0001B\u0006\u0005\u001b\u0011yA!\u0005\u0003\u0014\tU!q\u0003B\r+\t\u0011IAK\u0002S\u0003#\"Q\u0001O\u000eC\u0002e\"QAQ\u000eC\u0002e\"Q!R\u000eC\u0002e\"Q\u0001S\u000eC\u0002e\"QaS\u000eC\u0002e\"QAT\u000eC\u0002e\"Q!U\u000eC\u0002e\"Q\u0001V\u000eC\u0002e\nQ\u0002\u001d:pIV\u001cG\u000f\u0015:fM&DXCAA\u0001\u0003=\u0001(o\u001c3vGRLE/\u001a:bi>\u0014XC\u0001B\u0012!\u0015\u0011)Ca\u000b>\u001b\t\u00119CC\u0002\u0003*%\n!bY8mY\u0016\u001cG/[8o\u0013\u0011\u0011iCa\n\u0003\u0011%#XM]1u_J\f\u0001bY1o\u000bF,\u0018\r\u001c\u000b\u0005\u0005g\u0011I\u0004E\u00020\u0005kI1Aa\u000e*\u0005\u001d\u0011un\u001c7fC:D\u0001Ba\u000f\u001f\u0003\u0003\u0005\r!P\u0001\u0004q\u0012\n\u0014\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0005\t\u0005\u0003cA\u0018\u0003D%\u0019!QI\u0015\u0003\u0007%sG/\u0001\u0004fcV\fGn\u001d\u000b\u0005\u0005g\u0011Y\u0005\u0003\u0005\u0003<\u0001\n\t\u00111\u0001>\u0003\u0019!V\u000f\u001d7fqA\u0011qFI\n\u0004E9BFC\u0001B(\u0003\u0015\t\u0007\u000f\u001d7z+I\u0011IFa\u0018\u0003d\t\u001d$1\u000eB8\u0005g\u00129Ha\u001f\u0015%\tm#Q\u0010B@\u0005\u0003\u0013\u0019I!\"\u0003\b\n%%1\u0012\t\u0013_\u0001\u0011iF!\u0019\u0003f\t%$Q\u000eB9\u0005k\u0012I\bE\u00027\u0005?\"Q\u0001O\u0013C\u0002e\u00022A\u000eB2\t\u0015\u0011UE1\u0001:!\r1$q\r\u0003\u0006\u000b\u0016\u0012\r!\u000f\t\u0004m\t-D!\u0002%&\u0005\u0004I\u0004c\u0001\u001c\u0003p\u0011)1*\nb\u0001sA\u0019aGa\u001d\u0005\u000b9+#\u0019A\u001d\u0011\u0007Y\u00129\bB\u0003RK\t\u0007\u0011\bE\u00027\u0005w\"Q\u0001V\u0013C\u0002eBaaW\u0013A\u0002\tu\u0003B\u00020&\u0001\u0004\u0011\t\u0007\u0003\u0004bK\u0001\u0007!Q\r\u0005\u0007I\u0016\u0002\rA!\u001b\t\r\u001d,\u0003\u0019\u0001B7\u0011\u0019QW\u00051\u0001\u0003r!1Q.\na\u0001\u0005kBa\u0001]\u0013A\u0002\te\u0014aB;oCB\u0004H._\u000b\u0013\u0005#\u0013iJ!)\u0003&\n%&Q\u0016BY\u0005k\u0013I\f\u0006\u0003\u0003\u0014\nm\u0006#B\u0018\u0003\u0016\ne\u0015b\u0001BLS\t1q\n\u001d;j_:\u0004\"c\f\u0001\u0003\u001c\n}%1\u0015BT\u0005W\u0013yKa-\u00038B\u0019aG!(\u0005\u000ba2#\u0019A\u001d\u0011\u0007Y\u0012\t\u000bB\u0003CM\t\u0007\u0011\bE\u00027\u0005K#Q!\u0012\u0014C\u0002e\u00022A\u000eBU\t\u0015AeE1\u0001:!\r1$Q\u0016\u0003\u0006\u0017\u001a\u0012\r!\u000f\t\u0004m\tEF!\u0002('\u0005\u0004I\u0004c\u0001\u001c\u00036\u0012)\u0011K\nb\u0001sA\u0019aG!/\u0005\u000bQ3#\u0019A\u001d\t\u0013\tuf%!AA\u0002\te\u0015a\u0001=%a\u0005Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\u0011\u0019\r\u0005\u0003\u0002\u0004\t\u0015\u0017\u0002\u0002Bd\u0003\u000b\u0011aa\u00142kK\u000e$\b")
public final class Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>
implements Product8<T1, T2, T3, T4, T5, T6, T7, T8>,
Serializable {
    private final T1 _1;
    private final T2 _2;
    private final T3 _3;
    private final T4 _4;
    private final T5 _5;
    private final T6 _6;
    private final T7 _7;
    private final T8 _8;

    public static <T1, T2, T3, T4, T5, T6, T7, T8> Option<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> unapply(Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> tuple8) {
        return Tuple8$.MODULE$.unapply(tuple8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> apply(T1 T1, T2 T2, T3 T3, T4 T4, T5 T5, T6 T6, T7 T7, T8 T8) {
        return Tuple8$.MODULE$.apply(T1, T2, T3, T4, T5, T6, T7, T8);
    }

    @Override
    public int productArity() {
        return Product8.productArity$(this);
    }

    @Override
    public Object productElement(int n) throws IndexOutOfBoundsException {
        return Product8.productElement$(this, n);
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

    public String toString() {
        return new StringBuilder(9).append("(").append(this._1()).append(",").append(this._2()).append(",").append(this._3()).append(",").append(this._4()).append(",").append(this._5()).append(",").append(this._6()).append(",").append(this._7()).append(",").append(this._8()).append(")").toString();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> copy(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6, T7 _7, T8 _8) {
        return new Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>(_1, _2, _3, _4, _5, _6, _7, _8);
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8> T1 copy$default$1() {
        return this._1();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8> T2 copy$default$2() {
        return this._2();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8> T3 copy$default$3() {
        return this._3();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8> T4 copy$default$4() {
        return this._4();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8> T5 copy$default$5() {
        return this._5();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8> T6 copy$default$6() {
        return this._6();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8> T7 copy$default$7() {
        return this._7();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8> T8 copy$default$8() {
        return this._8();
    }

    @Override
    public String productPrefix() {
        return "Tuple8";
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof Tuple8;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof Tuple8;
                if (!bl) break block3;
                Tuple8 tuple8 = (Tuple8)x$1;
                if (!(BoxesRunTime.equals(this._1(), tuple8._1()) && BoxesRunTime.equals(this._2(), tuple8._2()) && BoxesRunTime.equals(this._3(), tuple8._3()) && BoxesRunTime.equals(this._4(), tuple8._4()) && BoxesRunTime.equals(this._5(), tuple8._5()) && BoxesRunTime.equals(this._6(), tuple8._6()) && BoxesRunTime.equals(this._7(), tuple8._7()) && BoxesRunTime.equals(this._8(), tuple8._8()))) break block3;
            }
            return true;
        }
        return false;
    }

    public Tuple8(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6, T7 _7, T8 _8) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this._5 = _5;
        this._6 = _6;
        this._7 = _7;
        this._8 = _8;
        Product.$init$(this);
        Product8.$init$(this);
    }
}

