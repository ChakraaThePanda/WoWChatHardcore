/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Function$;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.Option;
import scala.PartialFunction;
import scala.Tuple2;
import scala.Tuple3;
import scala.Tuple4;
import scala.Tuple5;
import scala.collection.Seq;
import scala.reflect.ScalaSignature;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@ScalaSignature(bytes="\u0006\u0001\t]s!\u0002\n\u0014\u0011\u00031b!\u0002\r\u0014\u0011\u0003I\u0002\"B\u000f\u0002\t\u0003q\u0002\"B\u0010\u0002\t\u0003\u0001\u0003\"B\u001d\u0002\t\u0003Q\u0004\"B$\u0002\t\u0003A\u0005\"\u0002-\u0002\t\u0003I\u0006\"\u0002-\u0002\t\u0003Q\u0007\"\u0002-\u0002\t\u0003a\bB\u0002-\u0002\t\u0003\t\u0019\u0003C\u0004\u0002T\u0005!\t!!\u0016\t\u000f\u0005M\u0013\u0001\"\u0001\u0002r!9\u00111K\u0001\u0005\u0002\u0005E\u0005bBA*\u0003\u0011\u0005\u0011Q\u0017\u0005\b\u0003;\fA\u0011AAp\u0011\u001d\ti.\u0001C\u0001\u0003oDq!!8\u0002\t\u0003\u0011\u0019\u0002C\u0004\u0002^\u0006!\tAa\r\u0002\u0011\u0019+hn\u0019;j_:T\u0011\u0001F\u0001\u0006g\u000e\fG.Y\u0002\u0001!\t9\u0012!D\u0001\u0014\u0005!1UO\\2uS>t7CA\u0001\u001b!\t92$\u0003\u0002\u001d'\t1\u0011I\\=SK\u001a\fa\u0001P5oSRtD#\u0001\f\u0002\u000b\rD\u0017-\u001b8\u0016\u0005\u0005:CC\u0001\u00121!\u001192%J\u0013\n\u0005\u0011\u001a\"!\u0003$v]\u000e$\u0018n\u001c82!\t1s\u0005\u0004\u0001\u0005\u000b!\u001a!\u0019A\u0015\u0003\u0003\u0005\f\"AK\u0017\u0011\u0005]Y\u0013B\u0001\u0017\u0014\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"a\u0006\u0018\n\u0005=\u001a\"aA!os\")\u0011g\u0001a\u0001e\u0005\u0011am\u001d\t\u0004gY\u0012cBA\f5\u0013\t)4#A\u0004qC\u000e\\\u0017mZ3\n\u0005]B$aA*fc*\u0011QgE\u0001\u0006G>t7\u000f^\u000b\u0004wy\u001aEC\u0001\u001fF)\ti\u0004\t\u0005\u0002'}\u0011)q\b\u0002b\u0001S\t\tA\u000bC\u0003B\t\u0001\u0007!)A\u0001z!\t13\tB\u0003E\t\t\u0007\u0011FA\u0001V\u0011\u00151E\u00011\u0001>\u0003\u0005A\u0018AB;oY&4G/F\u0002J\u001dB#\"A\u0013*\u0011\t]YUjT\u0005\u0003\u0019N\u0011q\u0002U1si&\fGNR;oGRLwN\u001c\t\u0003M9#QaP\u0003C\u0002%\u0002\"A\n)\u0005\u000bE+!\u0019A\u0015\u0003\u0003ICQaU\u0003A\u0002Q\u000b\u0011A\u001a\t\u0005/\rjU\u000bE\u0002\u0018->K!aV\n\u0003\r=\u0003H/[8o\u0003%)hnY;se&,G-\u0006\u0003[?\n,GCA.h!\u00159BLX1e\u0013\ti6CA\u0005Gk:\u001cG/[8oeA\u0011ae\u0018\u0003\u0006A\u001a\u0011\r!\u000b\u0002\u0003CF\u0002\"A\n2\u0005\u000b\r4!\u0019A\u0015\u0003\u0005\u0005\u0014\u0004C\u0001\u0014f\t\u00151gA1\u0001*\u0005\u0005\u0011\u0007\"B*\u0007\u0001\u0004A\u0007\u0003B\f$=&\u0004BaF\u0012bIV)1\u000e\u001d:uoR\u0011A\u000e\u001f\t\u0007/5|\u0017o\u001d<\n\u00059\u001c\"!\u0003$v]\u000e$\u0018n\u001c84!\t1\u0003\u000fB\u0003a\u000f\t\u0007\u0011\u0006\u0005\u0002'e\u0012)1m\u0002b\u0001SA\u0011a\u0005\u001e\u0003\u0006k\u001e\u0011\r!\u000b\u0002\u0003CN\u0002\"AJ<\u0005\u000b\u0019<!\u0019A\u0015\t\u000bM;\u0001\u0019A=\u0011\t]\u0019sN\u001f\t\u0005/\r\n8\u0010\u0005\u0003\u0018GM4XcC?\u0002\u0006\u0005%\u0011QBA\t\u0003/!2A`A\r!19r0a\u0001\u0002\b\u0005-\u0011qBA\u000b\u0013\r\t\ta\u0005\u0002\n\rVt7\r^5p]R\u00022AJA\u0003\t\u0015\u0001\u0007B1\u0001*!\r1\u0013\u0011\u0002\u0003\u0006G\"\u0011\r!\u000b\t\u0004M\u00055A!B;\t\u0005\u0004I\u0003c\u0001\u0014\u0002\u0012\u00111\u00111\u0003\u0005C\u0002%\u0012!!\u0019\u001b\u0011\u0007\u0019\n9\u0002B\u0003g\u0011\t\u0007\u0011\u0006\u0003\u0004T\u0011\u0001\u0007\u00111\u0004\t\u0007/\r\n\u0019!!\b\u0011\r]\u0019\u0013qAA\u0010!\u001992%a\u0003\u0002\"A1qcIA\b\u0003+)b\"!\n\u00020\u0005M\u0012qGA\u001e\u0003\u007f\t)\u0005\u0006\u0003\u0002(\u0005\u001d\u0003cD\f\u0002*\u00055\u0012\u0011GA\u001b\u0003s\ti$a\u0011\n\u0007\u0005-2CA\u0005Gk:\u001cG/[8okA\u0019a%a\f\u0005\u000b\u0001L!\u0019A\u0015\u0011\u0007\u0019\n\u0019\u0004B\u0003d\u0013\t\u0007\u0011\u0006E\u0002'\u0003o!Q!^\u0005C\u0002%\u00022AJA\u001e\t\u0019\t\u0019\"\u0003b\u0001SA\u0019a%a\u0010\u0005\r\u0005\u0005\u0013B1\u0001*\u0005\t\tW\u0007E\u0002'\u0003\u000b\"QAZ\u0005C\u0002%BaaU\u0005A\u0002\u0005%\u0003CB\f$\u0003[\tY\u0005\u0005\u0004\u0018G\u0005E\u0012Q\n\t\u0007/\r\n)$a\u0014\u0011\r]\u0019\u0013\u0011HA)!\u001992%!\u0010\u0002D\u00051A/\u001e9mK\u0012,\u0002\"a\u0016\u0002d\u0005\u001d\u00141\u000e\u000b\u0005\u00033\ni\u0007\u0005\u0004\u0018G\u0005m\u0013\u0011\u000e\t\b/\u0005u\u0013\u0011MA3\u0013\r\tyf\u0005\u0002\u0007)V\u0004H.\u001a\u001a\u0011\u0007\u0019\n\u0019\u0007B\u0003a\u0015\t\u0007\u0011\u0006E\u0002'\u0003O\"Qa\u0019\u0006C\u0002%\u00022AJA6\t\u00151'B1\u0001*\u0011\u0019\u0019&\u00021\u0001\u0002pAAq\u0003XA1\u0003K\nI'\u0006\u0006\u0002t\u0005}\u00141QAD\u0003\u0017#B!!\u001e\u0002\u000eB1qcIA<\u0003\u0013\u0003\u0012bFA=\u0003{\n\t)!\"\n\u0007\u0005m4C\u0001\u0004UkBdWm\r\t\u0004M\u0005}D!\u00021\f\u0005\u0004I\u0003c\u0001\u0014\u0002\u0004\u0012)1m\u0003b\u0001SA\u0019a%a\"\u0005\u000bU\\!\u0019A\u0015\u0011\u0007\u0019\nY\tB\u0003g\u0017\t\u0007\u0011\u0006\u0003\u0004T\u0017\u0001\u0007\u0011q\u0012\t\u000b/5\fi(!!\u0002\u0006\u0006%U\u0003DAJ\u0003?\u000b\u0019+a*\u0002,\u0006=F\u0003BAK\u0003c\u0003baF\u0012\u0002\u0018\u00065\u0006cC\f\u0002\u001a\u0006u\u0015\u0011UAS\u0003SK1!a'\u0014\u0005\u0019!V\u000f\u001d7fiA\u0019a%a(\u0005\u000b\u0001d!\u0019A\u0015\u0011\u0007\u0019\n\u0019\u000bB\u0003d\u0019\t\u0007\u0011\u0006E\u0002'\u0003O#Q!\u001e\u0007C\u0002%\u00022AJAV\t\u0019\t\u0019\u0002\u0004b\u0001SA\u0019a%a,\u0005\u000b\u0019d!\u0019A\u0015\t\rMc\u0001\u0019AAZ!19r0!(\u0002\"\u0006\u0015\u0016\u0011VAW+9\t9,a1\u0002H\u0006-\u0017qZAj\u0003/$B!!/\u0002ZB1qcIA^\u0003+\u0004RbFA_\u0003\u0003\f)-!3\u0002N\u0006E\u0017bAA`'\t1A+\u001e9mKV\u00022AJAb\t\u0015\u0001WB1\u0001*!\r1\u0013q\u0019\u0003\u0006G6\u0011\r!\u000b\t\u0004M\u0005-G!B;\u000e\u0005\u0004I\u0003c\u0001\u0014\u0002P\u00121\u00111C\u0007C\u0002%\u00022AJAj\t\u0019\t\t%\u0004b\u0001SA\u0019a%a6\u0005\u000b\u0019l!\u0019A\u0015\t\rMk\u0001\u0019AAn!=9\u0012\u0011FAa\u0003\u000b\fI-!4\u0002R\u0006U\u0017\u0001C;oiV\u0004H.\u001a3\u0016\u0011\u0005\u0005\u0018q]Av\u0003_$B!a9\u0002rBAq\u0003XAs\u0003S\fi\u000fE\u0002'\u0003O$Q\u0001\u0019\bC\u0002%\u00022AJAv\t\u0015\u0019gB1\u0001*!\r1\u0013q\u001e\u0003\u0006M:\u0011\r!\u000b\u0005\u0007':\u0001\r!a=\u0011\r]\u0019\u0013Q_Aw!\u001d9\u0012QLAs\u0003S,\"\"!?\u0002\u0000\n\r!q\u0001B\u0006)\u0011\tYP!\u0004\u0011\u0015]i\u0017Q B\u0001\u0005\u000b\u0011I\u0001E\u0002'\u0003\u007f$Q\u0001Y\bC\u0002%\u00022A\nB\u0002\t\u0015\u0019wB1\u0001*!\r1#q\u0001\u0003\u0006k>\u0011\r!\u000b\t\u0004M\t-A!\u00024\u0010\u0005\u0004I\u0003BB*\u0010\u0001\u0004\u0011y\u0001\u0005\u0004\u0018G\tE!\u0011\u0002\t\n/\u0005e\u0014Q B\u0001\u0005\u000b)BB!\u0006\u0003\u001c\t}!1\u0005B\u0014\u0005W!BAa\u0006\u0003.Aaqc B\r\u0005;\u0011\tC!\n\u0003*A\u0019aEa\u0007\u0005\u000b\u0001\u0004\"\u0019A\u0015\u0011\u0007\u0019\u0012y\u0002B\u0003d!\t\u0007\u0011\u0006E\u0002'\u0005G!Q!\u001e\tC\u0002%\u00022A\nB\u0014\t\u0019\t\u0019\u0002\u0005b\u0001SA\u0019aEa\u000b\u0005\u000b\u0019\u0004\"\u0019A\u0015\t\rM\u0003\u0002\u0019\u0001B\u0018!\u001992E!\r\u0003*AYq#!'\u0003\u001a\tu!\u0011\u0005B\u0013+9\u0011)Da\u000f\u0003@\t\r#q\tB&\u0005\u001f\"BAa\u000e\u0003RAyq#!\u000b\u0003:\tu\"\u0011\tB#\u0005\u0013\u0012i\u0005E\u0002'\u0005w!Q\u0001Y\tC\u0002%\u00022A\nB \t\u0015\u0019\u0017C1\u0001*!\r1#1\t\u0003\u0006kF\u0011\r!\u000b\t\u0004M\t\u001dCABA\n#\t\u0007\u0011\u0006E\u0002'\u0005\u0017\"a!!\u0011\u0012\u0005\u0004I\u0003c\u0001\u0014\u0003P\u0011)a-\u0005b\u0001S!11+\u0005a\u0001\u0005'\u0002baF\u0012\u0003V\t5\u0003#D\f\u0002>\ne\"Q\bB!\u0005\u000b\u0012I\u0005")
public final class Function {
    public static <a1, a2, a3, a4, a5, b> Function5<a1, a2, a3, a4, a5, b> untupled(Function1<Tuple5<a1, a2, a3, a4, a5>, b> function1) {
        return Function$.MODULE$.untupled(function1);
    }

    public static <a1, a2, a3, a4, b> Function4<a1, a2, a3, a4, b> untupled(Function1<Tuple4<a1, a2, a3, a4>, b> function1) {
        return Function$.MODULE$.untupled(function1);
    }

    public static <a1, a2, a3, b> Function3<a1, a2, a3, b> untupled(Function1<Tuple3<a1, a2, a3>, b> function1) {
        return Function$.MODULE$.untupled(function1);
    }

    public static <a1, a2, b> Function2<a1, a2, b> untupled(Function1<Tuple2<a1, a2>, b> function1) {
        return Function$.MODULE$.untupled(function1);
    }

    public static <a1, a2, a3, a4, a5, b> Function1<Tuple5<a1, a2, a3, a4, a5>, b> tupled(Function5<a1, a2, a3, a4, a5, b> function5) {
        return Function$.MODULE$.tupled(function5);
    }

    public static <a1, a2, a3, a4, b> Function1<Tuple4<a1, a2, a3, a4>, b> tupled(Function4<a1, a2, a3, a4, b> function4) {
        return Function$.MODULE$.tupled(function4);
    }

    public static <a1, a2, a3, b> Function1<Tuple3<a1, a2, a3>, b> tupled(Function3<a1, a2, a3, b> function3) {
        return Function$.MODULE$.tupled(function3);
    }

    public static <a1, a2, b> Function1<Tuple2<a1, a2>, b> tupled(Function2<a1, a2, b> function2) {
        return Function$.MODULE$.tupled(function2);
    }

    public static <a1, a2, a3, a4, a5, b> Function5<a1, a2, a3, a4, a5, b> uncurried(Function1<a1, Function1<a2, Function1<a3, Function1<a4, Function1<a5, b>>>>> function1) {
        return Function$.MODULE$.uncurried(function1);
    }

    public static <a1, a2, a3, a4, b> Function4<a1, a2, a3, a4, b> uncurried(Function1<a1, Function1<a2, Function1<a3, Function1<a4, b>>>> function1) {
        return Function$.MODULE$.uncurried(function1);
    }

    public static <a1, a2, a3, b> Function3<a1, a2, a3, b> uncurried(Function1<a1, Function1<a2, Function1<a3, b>>> function1) {
        return Function$.MODULE$.uncurried(function1);
    }

    public static <a1, a2, b> Function2<a1, a2, b> uncurried(Function1<a1, Function1<a2, b>> function1) {
        return Function$.MODULE$.uncurried(function1);
    }

    public static <T, R> PartialFunction<T, R> unlift(Function1<T, Option<R>> function1) {
        return Function$.MODULE$.unlift(function1);
    }

    public static <T, U> T const(T t, U u) {
        return Function$.MODULE$.const(t, u);
    }

    public static <a> Function1<a, a> chain(Seq<Function1<a, a>> seq) {
        return Function$.MODULE$.chain(seq);
    }
}

