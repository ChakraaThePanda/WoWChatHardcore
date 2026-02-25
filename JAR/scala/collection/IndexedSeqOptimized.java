/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function1;
import scala.Function2;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.AbstractIterator;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.IndexedSeq;
import scala.collection.IndexedSeqLike;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.Builder;
import scala.math.package$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt$;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\r}aa\u0002\u001a4!\u0003\r\t\u0001\u000f\u0005\u0006\u001b\u0002!\tA\u0014\u0005\u0006%\u0002!\te\u0015\u0005\u0006/\u0002!\t\u0005\u0017\u0005\u0006E\u0002!Ia\u0019\u0005\u0006Y\u0002!\t%\u001c\u0005\u0006_\u0002!\t\u0005\u001d\u0005\u0006e\u0002!\te\u001d\u0005\u0006q\u0002!I!\u001f\u0005\b\u0003C\u0001A\u0011BA\u0012\u0011\u001d\t9\u0004\u0001C!\u0003sAq!!\u0013\u0001\t\u0003\nY\u0005C\u0004\u0002\\\u0001!\t%!\u0018\t\u000f\u0005-\u0004\u0001\"\u0011\u0002n!9\u0011\u0011\u0010\u0001\u0005B\u0005m\u0004bBAY\u0001\u0011\u0005\u00131\u0017\u0005\b\u0003\u000b\u0004A\u0011IAd\u0011\u001d\t\t\u000e\u0001C!\u0003'Dq!!6\u0001\t\u0003\n9\u000eC\u0004\u0002Z\u0002!\t%a5\t\u000f\u0005m\u0007\u0001\"\u0011\u0002X\"9\u0011Q\u001c\u0001\u0005B\u0005}\u0007bBAs\u0001\u0011\u0005\u0013q\u001d\u0005\b\u0003W\u0004A\u0011IAw\u0011\u001d\t\t\u0010\u0001C!\u0003gDq!a>\u0001\t\u0003\nI\u0010C\u0004\u0002\u0000\u0002!\tE!\u0001\t\u000f\t\u0015\u0001\u0001\"\u0011\u0003\b!9!1\u0002\u0001\u0005B\t5\u0001b\u0002B\t\u0001\u0011\u0005#1\u0003\u0005\b\u0005?\u0001A\u0011\tB\u0011\u0011\u001d\u0011I\u0004\u0001C!\u0005wAqAa\u0010\u0001\t\u0003\u0012\t\u0005C\u0004\u0003H\u0001!IA!\u0013\t\u000f\t5\u0003\u0001\"\u0011\u0003P!9!Q\u000b\u0001\u0005B\t]\u0003b\u0002B/\u0001\u0011\u0005\u0013q\u001b\u0005\b\u0005?\u0002A\u0011\tB1\u0011\u001d\u0011I\u0007\u0001C!\u0005WBqAa \u0001\t\u0003\u0012\t\tC\u0004\u0003\u000e\u0002!\tEa$\t\u001d\t}\u0005\u0001%A\u0002\u0002\u0003%IA!)\u0003.\"q!1\u0017\u0001\u0011\u0002\u0007\u0005\t\u0011\"\u0003\u00036\n\u0005\u0007B\u0004Bd\u0001A\u0005\u0019\u0011!A\u0005\n\t%'Q\u001d\u0005\u000f\u0005O\u0004\u0001\u0013aA\u0001\u0002\u0013%\u00111\u001bBu\u00119\u0011Y\u000f\u0001I\u0001\u0004\u0003\u0005I\u0011BAl\u0005[DaBa=\u0001!\u0003\r\t\u0011!C\u0005\u0003'\u0014)\u0010\u0003\b\u0003x\u0002\u0001\n1!A\u0001\n\u0013\t9N!?\t\u001d\tm\b\u0001%A\u0002\u0002\u0003%IA!@\u0004\n!q11\u0002\u0001\u0011\u0002\u0007\u0005\t\u0011\"\u0003\u0004\u000e\re!aE%oI\u0016DX\rZ*fc>\u0003H/[7ju\u0016$'B\u0001\u001b6\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002m\u0005)1oY1mC\u000e\u0001QcA\u001dE\u0017N\u0019\u0001A\u000f \u0011\u0005mbT\"A\u001b\n\u0005u*$aA!osB!q\b\u0011\"K\u001b\u0005\u0019\u0014BA!4\u00059Ie\u000eZ3yK\u0012\u001cV-\u001d'jW\u0016\u0004\"a\u0011#\r\u0001\u00111Q\t\u0001CC\u0002\u0019\u0013\u0011!Q\t\u0003\u000fj\u0002\"a\u000f%\n\u0005%+$a\u0002(pi\"Lgn\u001a\t\u0003\u0007.#a\u0001\u0014\u0001\u0005\u0006\u00041%\u0001\u0002*faJ\fa\u0001J5oSR$C#A(\u0011\u0005m\u0002\u0016BA)6\u0005\u0011)f.\u001b;\u0002\u000f%\u001cX)\u001c9usV\tA\u000b\u0005\u0002<+&\u0011a+\u000e\u0002\b\u0005>|G.Z1o\u0003\u001d1wN]3bG\",\"!\u00171\u0015\u0005=S\u0006\"B.\u0004\u0001\u0004a\u0016!\u00014\u0011\tmj&iX\u0005\u0003=V\u0012\u0011BR;oGRLwN\\\u0019\u0011\u0005\r\u0003G!B1\u0004\u0005\u00041%!A+\u0002!A\u0014XMZ5y\u0019\u0016tw\r\u001e5J[BdGc\u00013hUB\u00111(Z\u0005\u0003MV\u00121!\u00138u\u0011\u0015AG\u00011\u0001j\u0003\u0005\u0001\b\u0003B\u001e^\u0005RCQa\u001b\u0003A\u0002Q\u000b!\"\u001a=qK\u000e$HK];f\u0003\u00191wN]1mYR\u0011AK\u001c\u0005\u0006Q\u0016\u0001\r![\u0001\u0007KbL7\u000f^:\u0015\u0005Q\u000b\b\"\u00025\u0007\u0001\u0004I\u0017\u0001\u00024j]\u0012$\"\u0001^<\u0011\u0007m*()\u0003\u0002wk\t1q\n\u001d;j_:DQ\u0001[\u0004A\u0002%\fQAZ8mI2,\"A\u001f?\u0015\u0011mt\u0018\u0011AA\u0003\u0003\u0013\u0001\"a\u0011?\u0005\u000buD!\u0019\u0001$\u0003\u0003\tCQa \u0005A\u0002\u0011\fQa\u001d;beRDa!a\u0001\t\u0001\u0004!\u0017aA3oI\"1\u0011q\u0001\u0005A\u0002m\f\u0011A\u001f\u0005\b\u0003\u0017A\u0001\u0019AA\u0007\u0003\ty\u0007\u000f\u0005\u0004<\u0003\u001fY(i_\u0005\u0004\u0003#)$!\u0003$v]\u000e$\u0018n\u001c83Q\rA\u0011Q\u0003\t\u0005\u0003/\ti\"\u0004\u0002\u0002\u001a)\u0019\u00111D\u001b\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0003\u0002 \u0005e!a\u0002;bS2\u0014XmY\u0001\u0006M>dGM]\u000b\u0005\u0003K\tI\u0003\u0006\u0006\u0002(\u0005-\u0012QFA\u0018\u0003c\u00012aQA\u0015\t\u0015i\u0018B1\u0001G\u0011\u0015y\u0018\u00021\u0001e\u0011\u0019\t\u0019!\u0003a\u0001I\"9\u0011qA\u0005A\u0002\u0005\u001d\u0002bBA\u0006\u0013\u0001\u0007\u00111\u0007\t\tw\u0005=!)a\n\u0002(!\u001a\u0011\"!\u0006\u0002\u0011\u0019|G\u000e\u001a'fMR,B!a\u000f\u0002BQ!\u0011QHA$)\u0011\ty$a\u0011\u0011\u0007\r\u000b\t\u0005B\u0003~\u0015\t\u0007a\tC\u0004\u0002\f)\u0001\r!!\u0012\u0011\u0011m\ny!a\u0010C\u0003\u007fAq!a\u0002\u000b\u0001\u0004\ty$A\u0005g_2$'+[4iiV!\u0011QJA*)\u0011\ty%!\u0017\u0015\t\u0005E\u0013Q\u000b\t\u0004\u0007\u0006MC!B?\f\u0005\u00041\u0005bBA\u0006\u0017\u0001\u0007\u0011q\u000b\t\tw\u0005=!)!\u0015\u0002R!9\u0011qA\u0006A\u0002\u0005E\u0013A\u0003:fIV\u001cW\rT3giV!\u0011qLA2)\u0011\t\t'a\u001a\u0011\u0007\r\u000b\u0019\u0007\u0002\u0004~\u0019\t\u0007\u0011QM\t\u0003\u0005jBq!a\u0003\r\u0001\u0004\tI\u0007\u0005\u0005<\u0003\u001f\t\tGQA1\u0003-\u0011X\rZ;dKJKw\r\u001b;\u0016\t\u0005=\u00141\u000f\u000b\u0005\u0003c\n)\bE\u0002D\u0003g\"a!`\u0007C\u0002\u0005\u0015\u0004bBA\u0006\u001b\u0001\u0007\u0011q\u000f\t\tw\u0005=!)!\u001d\u0002r\u0005\u0019!0\u001b9\u0016\u0011\u0005u\u0014qTAS\u0003\u0007#B!a \u0002(R!\u0011\u0011QAD!\r\u0019\u00151\u0011\u0003\u0007\u0003\u000bs!\u0019\u0001$\u0003\tQC\u0017\r\u001e\u0005\b\u0003\u0013s\u00019AAF\u0003\t\u0011g\rE\u0005\u0002\u000e\u0006M%*a&\u0002\u00026\u0011\u0011q\u0012\u0006\u0004\u0003#\u001b\u0014aB4f]\u0016\u0014\u0018nY\u0005\u0005\u0003+\u000byI\u0001\u0007DC:\u0014U/\u001b7e\rJ|W\u000eE\u0004<\u00033\u000bi*a)\n\u0007\u0005mUG\u0001\u0004UkBdWM\r\t\u0004\u0007\u0006}EaBAQ\u001d\t\u0007\u0011Q\r\u0002\u0003\u0003F\u00022aQAS\t\u0015ihB1\u0001G\u0011\u001d\tIK\u0004a\u0001\u0003W\u000bA\u0001\u001e5biB)q(!,\u0002$&\u0019\u0011qV\u001a\u0003\u0017\u001d+g.\u0013;fe\u0006\u0014G.Z\u0001\ru&\u0004x+\u001b;i\u0013:$W\r_\u000b\u0007\u0003k\u000b\u0019-!/\u0015\t\u0005]\u00161\u0018\t\u0004\u0007\u0006eFABAC\u001f\t\u0007a\tC\u0004\u0002\n>\u0001\u001d!!0\u0011\u0013\u00055\u00151\u0013&\u0002@\u0006]\u0006CB\u001e\u0002\u001a\u0006\u0005G\rE\u0002D\u0003\u0007$q!!)\u0010\u0005\u0004\t)'A\u0003tY&\u001cW\rF\u0003K\u0003\u0013\fi\r\u0003\u0004\u0002LB\u0001\r\u0001Z\u0001\u0005MJ|W\u000e\u0003\u0004\u0002PB\u0001\r\u0001Z\u0001\u0006k:$\u0018\u000e\\\u0001\u0005Q\u0016\fG-F\u0001C\u0003\u0011!\u0018-\u001b7\u0016\u0003)\u000bA\u0001\\1ti\u0006!\u0011N\\5u\u0003\u0011!\u0018m[3\u0015\u0007)\u000b\t\u000f\u0003\u0004\u0002dV\u0001\r\u0001Z\u0001\u0002]\u0006!AM]8q)\rQ\u0015\u0011\u001e\u0005\u0007\u0003G4\u0002\u0019\u00013\u0002\u0013Q\f7.\u001a*jO\"$Hc\u0001&\u0002p\"1\u00111]\fA\u0002\u0011\f\u0011\u0002\u001a:paJKw\r\u001b;\u0015\u0007)\u000b)\u0010\u0003\u0004\u0002db\u0001\r\u0001Z\u0001\bgBd\u0017\u000e^!u)\u0011\tY0!@\u0011\u000bm\nIJ\u0013&\t\r\u0005\r\u0018\u00041\u0001e\u0003%!\u0018m[3XQ&dW\rF\u0002K\u0005\u0007AQ\u0001\u001b\u000eA\u0002%\f\u0011\u0002\u001a:pa^C\u0017\u000e\\3\u0015\u0007)\u0013I\u0001C\u0003i7\u0001\u0007\u0011.\u0001\u0003ta\u0006tG\u0003BA~\u0005\u001fAQ\u0001\u001b\u000fA\u0002%\fAb]1nK\u0016cW-\\3oiN,BA!\u0006\u0003\u001eQ\u0019AKa\u0006\t\u000f\u0005%V\u00041\u0001\u0003\u001aA)q(!,\u0003\u001cA\u00191I!\b\u0005\rul\"\u0019AA3\u0003-\u0019w\u000e]=U_\u0006\u0013(/Y=\u0016\t\t\r\"\u0011\u0007\u000b\b\u001f\n\u0015\"1\u0007B\u001b\u0011\u001d\u00119C\ba\u0001\u0005S\t!\u0001_:\u0011\u000bm\u0012YCa\f\n\u0007\t5RGA\u0003BeJ\f\u0017\u0010E\u0002D\u0005c!a! \u0010C\u0002\u0005\u0015\u0004\"B@\u001f\u0001\u0004!\u0007B\u0002B\u001c=\u0001\u0007A-A\u0002mK:\fQ\u0002\\3oORD7i\\7qCJ,Gc\u00013\u0003>!1!qG\u0010A\u0002\u0011\fQb]3h[\u0016tG\u000fT3oORDG#\u00023\u0003D\t\u0015\u0003\"\u00025!\u0001\u0004I\u0007BBAfA\u0001\u0007A-A\u0005oK\u001edUM\\4uQR\u0019AMa\u0013\t\r\u0005\r\u0018\u00051\u0001e\u0003)Ig\u000eZ3y/\",'/\u001a\u000b\u0006I\nE#1\u000b\u0005\u0006Q\n\u0002\r!\u001b\u0005\u0007\u0003\u0017\u0014\u0003\u0019\u00013\u0002\u001d1\f7\u000f^%oI\u0016Dx\u000b[3sKR)AM!\u0017\u0003\\!)\u0001n\ta\u0001S\"1\u00111A\u0012A\u0002\u0011\fqA]3wKJ\u001cX-A\bsKZ,'o]3Ji\u0016\u0014\u0018\r^8s+\t\u0011\u0019\u0007\u0005\u0003@\u0005K\u0012\u0015b\u0001B4g\tA\u0011\n^3sCR|'/\u0001\u0006ti\u0006\u0014Ho],ji\",BA!\u001c\u0003zQ)AKa\u001c\u0003|!9\u0011\u0011\u0016\u0014A\u0002\tE\u0004#B \u0003t\t]\u0014b\u0001B;g\t1q)\u001a8TKF\u00042a\u0011B=\t\u0015ihE1\u0001G\u0011\u0019\u0011iH\na\u0001I\u00061qN\u001a4tKR\f\u0001\"\u001a8eg^KG\u000f[\u000b\u0005\u0005\u0007\u0013Y\tF\u0002U\u0005\u000bCq!!+(\u0001\u0004\u00119\tE\u0003@\u0005g\u0012I\tE\u0002D\u0005\u0017#Q!`\u0014C\u0002\u0019\u000ba\u0001^8MSN$XC\u0001BI!\u0015\u0011\u0019J!'C\u001d\rY$QS\u0005\u0004\u0005/+\u0014a\u00029bG.\fw-Z\u0005\u0005\u00057\u0013iJ\u0001\u0003MSN$(b\u0001BLk\u0005\u00012/\u001e9fe\u0012\u0012X\rZ;dK2+g\r^\u000b\u0005\u0005G\u00139\u000b\u0006\u0003\u0003&\n%\u0006cA\"\u0003(\u00121Q0\u000bb\u0001\u0003KBq!a\u0003*\u0001\u0004\u0011Y\u000b\u0005\u0005<\u0003\u001f\u0011)K\u0011BS\u0013\u0011\tYFa,\n\u0007\tE6GA\bUe\u00064XM]:bE2,wJ\\2f\u0003E\u0019X\u000f]3sII,G-^2f%&<\u0007\u000e^\u000b\u0005\u0005o\u0013Y\f\u0006\u0003\u0003:\nu\u0006cA\"\u0003<\u00121QP\u000bb\u0001\u0003KBq!a\u0003+\u0001\u0004\u0011y\f\u0005\u0005<\u0003\u001f\u0011%\u0011\u0018B]\u0013\u0011\tYGa1\n\u0007\t\u00157G\u0001\u0007Ji\u0016\u0014\u0018M\u00197f\u0019&\\W-A\u0005tkB,'\u000f\n>jaVA!1\u001aBn\u0005?\u0014\t\u000e\u0006\u0003\u0003N\n\u0005H\u0003\u0002Bh\u0005'\u00042a\u0011Bi\t\u0019\t)i\u000bb\u0001\r\"9\u0011\u0011R\u0016A\u0004\tU\u0007#CAG\u0003'S%q\u001bBh!\u001dY\u0014\u0011\u0014Bm\u0005;\u00042a\u0011Bn\t\u001d\t\tk\u000bb\u0001\u0003K\u00022a\u0011Bp\t\u0015i8F1\u0001G\u0011\u001d\tIk\u000ba\u0001\u0005G\u0004RaPAW\u0005;LA!!\u001f\u0003D\u0006Q1/\u001e9fe\u0012BW-\u00193\n\t\u0005E'1Y\u0001\u000bgV\u0004XM\u001d\u0013uC&d\u0017\u0002BAk\u0005_L1A!=4\u0005=!&/\u0019<feN\f'\r\\3MS.,\u0017AC:va\u0016\u0014H\u0005\\1ti&!\u0011\u0011\u001cBx\u0003)\u0019X\u000f]3sI%t\u0017\u000e^\u0005\u0005\u00037\u0014y/\u0001\ntkB,'\u000fJ:b[\u0016,E.Z7f]R\u001cX\u0003\u0002B\u0000\u0007\u000f!2\u0001VB\u0001\u0011\u001d\tI\u000b\ra\u0001\u0007\u0007\u0001RaPAW\u0007\u000b\u00012aQB\u0004\t\u0019i\bG1\u0001\u0002f%!!\u0011\u0003Bb\u00039\u0019X\u000f]3sI\u0015tGm],ji\",Baa\u0004\u0004\u0018Q\u0019Ak!\u0005\t\u000f\u0005%\u0016\u00071\u0001\u0004\u0014A)qHa\u001d\u0004\u0016A\u00191ia\u0006\u0005\u000bu\f$\u0019\u0001$\n\t\t}41D\u0005\u0004\u0007;\u0019$aB*fc2K7.\u001a")
public interface IndexedSeqOptimized<A, Repr>
extends IndexedSeqLike<A, Repr> {
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceLeft(Function2 var1);

    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceRight(Function2 var1);

    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$zip(GenIterable var1, CanBuildFrom var2);

    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$head();

    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$tail();

    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$last();

    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$init();

    public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$sameElements(GenIterable var1);

    public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$endsWith(GenSeq var1);

    public static /* synthetic */ boolean isEmpty$(IndexedSeqOptimized $this) {
        return $this.isEmpty();
    }

    @Override
    default public boolean isEmpty() {
        return this.length() == 0;
    }

    public static /* synthetic */ void foreach$(IndexedSeqOptimized $this, Function1 f) {
        $this.foreach(f);
    }

    @Override
    default public <U> void foreach(Function1<A, U> f) {
        int len = this.length();
        for (int i = 0; i < len; ++i) {
            f.apply(this.apply(i));
        }
    }

    /*
     * WARNING - void declaration
     */
    private int prefixLengthImpl(Function1<A, Object> p, boolean expectTrue) {
        void var3_3;
        for (int i = 0; i < this.length() && BoxesRunTime.unboxToBoolean(p.apply(this.apply(i))) == expectTrue; ++i) {
        }
        return (int)var3_3;
    }

    public static /* synthetic */ boolean forall$(IndexedSeqOptimized $this, Function1 p) {
        return $this.forall(p);
    }

    @Override
    default public boolean forall(Function1<A, Object> p) {
        return this.prefixLengthImpl(p, true) == this.length();
    }

    public static /* synthetic */ boolean exists$(IndexedSeqOptimized $this, Function1 p) {
        return $this.exists(p);
    }

    @Override
    default public boolean exists(Function1<A, Object> p) {
        return this.prefixLengthImpl(p, false) != this.length();
    }

    public static /* synthetic */ Option find$(IndexedSeqOptimized $this, Function1 p) {
        return $this.find(p);
    }

    @Override
    default public Option<A> find(Function1<A, Object> p) {
        int i = this.prefixLength((Function1<Object, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(IndexedSeqOptimized.$anonfun$find$1(p, x$1)));
        if (i < this.length()) {
            return new Some(this.apply(i));
        }
        return None$.MODULE$;
    }

    private <B> B foldl(int start, int end, B z, Function2<B, A, B> op) {
        while (start != end) {
            B b = op.apply(z, this.apply(start));
            z = b;
            ++start;
        }
        return z;
    }

    private <B> B foldr(int start, int end, B z, Function2<A, B, B> op) {
        while (start != end) {
            B b = op.apply(this.apply(end - 1), z);
            z = b;
            --end;
        }
        return z;
    }

    public static /* synthetic */ Object foldLeft$(IndexedSeqOptimized $this, Object z, Function2 op) {
        return $this.foldLeft(z, op);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public <B> B foldLeft(B z, Function2<B, A, B> op) {
        void foldl_end;
        B b = z;
        int n = this.length();
        for (int foldl_start = 0; foldl_start != foldl_end; ++foldl_start) {
            B foldl_z;
            foldl_z = op.apply(foldl_z, this.apply(foldl_start));
        }
        return b;
    }

    public static /* synthetic */ Object foldRight$(IndexedSeqOptimized $this, Object z, Function2 op) {
        return $this.foldRight(z, op);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public <B> B foldRight(B z, Function2<A, B, B> op) {
        void foldr_end;
        B b = z;
        int n = this.length();
        boolean foldr_start = false;
        while (foldr_start != foldr_end) {
            B foldr_z;
            foldr_z = op.apply(this.apply((int)(foldr_end - true)), foldr_z);
            --foldr_end;
        }
        return b;
    }

    public static /* synthetic */ Object reduceLeft$(IndexedSeqOptimized $this, Function2 op) {
        return $this.reduceLeft(op);
    }

    @Override
    default public <B> B reduceLeft(Function2<B, A, B> op) {
        if (this.length() > 0) {
            Object a = this.apply(0);
            int foldl_end = this.length();
            for (int foldl_start = 1; foldl_start != foldl_end; ++foldl_start) {
                B foldl_z;
                foldl_z = op.apply(foldl_z, this.apply(foldl_start));
            }
            return (B)a;
        }
        return (B)this.scala$collection$IndexedSeqOptimized$$super$reduceLeft(op);
    }

    public static /* synthetic */ Object reduceRight$(IndexedSeqOptimized $this, Function2 op) {
        return $this.reduceRight(op);
    }

    @Override
    default public <B> B reduceRight(Function2<A, B, B> op) {
        if (this.length() > 0) {
            Object a = this.apply(this.length() - 1);
            int foldr_start = 0;
            for (int foldr_end = this.length() - 1; foldr_start != foldr_end; --foldr_end) {
                B foldr_z;
                foldr_z = op.apply(this.apply(foldr_end - 1), foldr_z);
            }
            return (B)a;
        }
        return (B)this.scala$collection$IndexedSeqOptimized$$super$reduceRight(op);
    }

    public static /* synthetic */ Object zip$(IndexedSeqOptimized $this, GenIterable that, CanBuildFrom bf) {
        return $this.zip(that, bf);
    }

    @Override
    default public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<Repr, Tuple2<A1, B>, That> bf) {
        Object object;
        if (that instanceof IndexedSeq) {
            IndexedSeq indexedSeq = (IndexedSeq)that;
            Builder<Tuple2<A1, B>, That> b = bf.apply(this.repr());
            int n = this.length();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            int len = RichInt$.MODULE$.min$extension(n, indexedSeq.length());
            b.sizeHint(len);
            for (int i = 0; i < len; ++i) {
                b.$plus$eq(new Tuple2(this.apply(i), indexedSeq.apply(i)));
            }
            object = b.result();
        } else {
            object = this.scala$collection$IndexedSeqOptimized$$super$zip(that, bf);
        }
        return (That)object;
    }

    public static /* synthetic */ Object zipWithIndex$(IndexedSeqOptimized $this, CanBuildFrom bf) {
        return $this.zipWithIndex(bf);
    }

    @Override
    default public <A1, That> That zipWithIndex(CanBuildFrom<Repr, Tuple2<A1, Object>, That> bf) {
        Builder<Tuple2<A1, Object>, That> b = bf.apply(this.repr());
        int len = this.length();
        b.sizeHint(len);
        for (int i = 0; i < len; ++i) {
            b.$plus$eq(new Tuple2(this.apply(i), BoxesRunTime.boxToInteger(i)));
        }
        return b.result();
    }

    public static /* synthetic */ Object slice$(IndexedSeqOptimized $this, int from, int until) {
        return $this.slice(from, until);
    }

    @Override
    default public Repr slice(int from, int until) {
        int lo = package$.MODULE$.max(from, 0);
        int hi = package$.MODULE$.min(package$.MODULE$.max(until, 0), this.length());
        int elems = package$.MODULE$.max(hi - lo, 0);
        Builder b = this.newBuilder();
        b.sizeHint(elems);
        for (int i = lo; i < hi; ++i) {
            b.$plus$eq(this.apply(i));
        }
        return b.result();
    }

    public static /* synthetic */ Object head$(IndexedSeqOptimized $this) {
        return $this.head();
    }

    @Override
    default public A head() {
        if (this.isEmpty()) {
            return (A)this.scala$collection$IndexedSeqOptimized$$super$head();
        }
        return this.apply(0);
    }

    public static /* synthetic */ Object tail$(IndexedSeqOptimized $this) {
        return $this.tail();
    }

    @Override
    default public Repr tail() {
        if (this.isEmpty()) {
            return (Repr)this.scala$collection$IndexedSeqOptimized$$super$tail();
        }
        return this.slice(1, this.length());
    }

    public static /* synthetic */ Object last$(IndexedSeqOptimized $this) {
        return $this.last();
    }

    @Override
    default public A last() {
        if (this.length() > 0) {
            return this.apply(this.length() - 1);
        }
        return (A)this.scala$collection$IndexedSeqOptimized$$super$last();
    }

    public static /* synthetic */ Object init$(IndexedSeqOptimized $this) {
        return $this.init();
    }

    @Override
    default public Repr init() {
        if (this.length() > 0) {
            return this.slice(0, this.length() - 1);
        }
        return (Repr)this.scala$collection$IndexedSeqOptimized$$super$init();
    }

    public static /* synthetic */ Object take$(IndexedSeqOptimized $this, int n) {
        return $this.take(n);
    }

    @Override
    default public Repr take(int n) {
        return this.slice(0, n);
    }

    public static /* synthetic */ Object drop$(IndexedSeqOptimized $this, int n) {
        return $this.drop(n);
    }

    @Override
    default public Repr drop(int n) {
        return this.slice(n, this.length());
    }

    public static /* synthetic */ Object takeRight$(IndexedSeqOptimized $this, int n) {
        return $this.takeRight(n);
    }

    @Override
    default public Repr takeRight(int n) {
        return this.slice(this.length() - package$.MODULE$.max(n, 0), this.length());
    }

    public static /* synthetic */ Object dropRight$(IndexedSeqOptimized $this, int n) {
        return $this.dropRight(n);
    }

    @Override
    default public Repr dropRight(int n) {
        return this.slice(0, this.length() - package$.MODULE$.max(n, 0));
    }

    public static /* synthetic */ Tuple2 splitAt$(IndexedSeqOptimized $this, int n) {
        return $this.splitAt(n);
    }

    @Override
    default public Tuple2<Repr, Repr> splitAt(int n) {
        return new Tuple2<Repr, Repr>(this.take(n), this.drop(n));
    }

    public static /* synthetic */ Object takeWhile$(IndexedSeqOptimized $this, Function1 p) {
        return $this.takeWhile(p);
    }

    @Override
    default public Repr takeWhile(Function1<A, Object> p) {
        return this.take(this.prefixLength(p));
    }

    public static /* synthetic */ Object dropWhile$(IndexedSeqOptimized $this, Function1 p) {
        return $this.dropWhile(p);
    }

    @Override
    default public Repr dropWhile(Function1<A, Object> p) {
        return this.drop(this.prefixLength(p));
    }

    public static /* synthetic */ Tuple2 span$(IndexedSeqOptimized $this, Function1 p) {
        return $this.span(p);
    }

    @Override
    default public Tuple2<Repr, Repr> span(Function1<A, Object> p) {
        return this.splitAt(this.prefixLength(p));
    }

    public static /* synthetic */ boolean sameElements$(IndexedSeqOptimized $this, GenIterable that) {
        return $this.sameElements(that);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    default public <B> boolean sameElements(GenIterable<B> that) {
        int i;
        if (!(that instanceof IndexedSeq)) return this.scala$collection$IndexedSeqOptimized$$super$sameElements(that);
        IndexedSeq indexedSeq = (IndexedSeq)that;
        int len = this.length();
        if (len != indexedSeq.length()) return false;
        for (i = 0; i < len && BoxesRunTime.equals(this.apply(i), indexedSeq.apply(i)); ++i) {
        }
        if (i != len) return false;
        return true;
    }

    public static /* synthetic */ void copyToArray$(IndexedSeqOptimized $this, Object xs, int start, int len) {
        $this.copyToArray(xs, start, len);
    }

    @Override
    default public <B> void copyToArray(Object xs, int start, int len) {
        int i = 0;
        int j = start;
        int n = this.length();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int n2 = RichInt$.MODULE$.min$extension(n, len);
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int end = RichInt$.MODULE$.min$extension(n2, ScalaRunTime$.MODULE$.array_length(xs) - start);
        while (i < end) {
            ScalaRunTime$.MODULE$.array_update(xs, j, this.apply(i));
            ++i;
            ++j;
        }
    }

    public static /* synthetic */ int lengthCompare$(IndexedSeqOptimized $this, int len) {
        return $this.lengthCompare(len);
    }

    @Override
    default public int lengthCompare(int len) {
        return this.length() - len;
    }

    public static /* synthetic */ int segmentLength$(IndexedSeqOptimized $this, Function1 p, int from) {
        return $this.segmentLength(p, from);
    }

    @Override
    default public int segmentLength(Function1<A, Object> p, int from) {
        int i;
        int len = this.length();
        for (i = from; i < len && BoxesRunTime.unboxToBoolean(p.apply(this.apply(i))); ++i) {
        }
        return i - from;
    }

    private int negLength(int n) {
        if (n >= this.length()) {
            return -1;
        }
        return n;
    }

    public static /* synthetic */ int indexWhere$(IndexedSeqOptimized $this, Function1 p, int from) {
        return $this.indexWhere(p, from);
    }

    @Override
    default public int indexWhere(Function1<A, Object> p, int from) {
        int start = package$.MODULE$.max(from, 0);
        return this.negLength(start + this.segmentLength((Function1<Object, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(IndexedSeqOptimized.$anonfun$indexWhere$1(p, x$2)), start));
    }

    public static /* synthetic */ int lastIndexWhere$(IndexedSeqOptimized $this, Function1 p, int end) {
        return $this.lastIndexWhere(p, end);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public int lastIndexWhere(Function1<A, Object> p, int end) {
        void var3_3;
        for (int i = package$.MODULE$.min(end, this.length() - 1); i >= 0 && !BoxesRunTime.unboxToBoolean(p.apply(this.apply(i))); --i) {
        }
        return (int)var3_3;
    }

    public static /* synthetic */ Object reverse$(IndexedSeqOptimized $this) {
        return $this.reverse();
    }

    @Override
    default public Repr reverse() {
        Builder b = this.newBuilder();
        b.sizeHint(this.length());
        int i = this.length();
        while (0 < i) {
            b.$plus$eq(this.apply(--i));
        }
        return b.result();
    }

    public static /* synthetic */ Iterator reverseIterator$(IndexedSeqOptimized $this) {
        return $this.reverseIterator();
    }

    @Override
    default public Iterator<A> reverseIterator() {
        return new AbstractIterator<A>(this){
            private int i;
            private final /* synthetic */ IndexedSeqOptimized $outer;

            private int i() {
                return this.i;
            }

            private void i_$eq(int x$1) {
                this.i = x$1;
            }

            public boolean hasNext() {
                return 0 < this.i();
            }

            public A next() {
                if (0 < this.i()) {
                    this.i_$eq(this.i() - 1);
                    return this.$outer.apply(this.i());
                }
                return (A)Iterator$.MODULE$.empty().next();
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.i = $outer.length();
            }
        };
    }

    public static /* synthetic */ boolean startsWith$(IndexedSeqOptimized $this, GenSeq that, int offset) {
        return $this.startsWith(that, offset);
    }

    @Override
    default public <B> boolean startsWith(GenSeq<B> that, int offset) {
        boolean bl;
        if (that instanceof IndexedSeq) {
            int j;
            IndexedSeq indexedSeq = (IndexedSeq)that;
            int i = offset;
            int thisLen = this.length();
            int thatLen = indexedSeq.length();
            for (j = 0; i < thisLen && j < thatLen && BoxesRunTime.equals(this.apply(i), indexedSeq.apply(j)); ++i, ++j) {
            }
            bl = j == thatLen;
        } else {
            int thisLen = this.length();
            Iterator thatElems = that.iterator();
            for (int i = offset; i < thisLen && thatElems.hasNext(); ++i) {
                if (BoxesRunTime.equals(this.apply(i), thatElems.next())) continue;
                return false;
            }
            bl = !thatElems.hasNext();
        }
        return bl;
    }

    public static /* synthetic */ boolean endsWith$(IndexedSeqOptimized $this, GenSeq that) {
        return $this.endsWith(that);
    }

    @Override
    default public <B> boolean endsWith(GenSeq<B> that) {
        boolean bl;
        if (that instanceof IndexedSeq) {
            boolean bl2;
            IndexedSeq indexedSeq = (IndexedSeq)that;
            int i = this.length() - 1;
            int j = indexedSeq.length() - 1;
            if (j <= i) {
                while (j >= 0) {
                    if (!BoxesRunTime.equals(this.apply(i), indexedSeq.apply(j))) {
                        return false;
                    }
                    --i;
                    --j;
                }
                bl2 = true;
            } else {
                bl2 = false;
            }
            bl = bl2;
        } else {
            bl = this.scala$collection$IndexedSeqOptimized$$super$endsWith(that);
        }
        return bl;
    }

    public static /* synthetic */ List toList$(IndexedSeqOptimized $this) {
        return $this.toList();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public List<A> toList() {
        void var2_2;
        List result2 = Nil$.MODULE$;
        for (int i = this.length() - 1; i >= 0; --i) {
            result2 = result2.$colon$colon(this.apply(i));
        }
        return var2_2;
    }

    public static /* synthetic */ boolean $anonfun$find$1(Function1 p$1, Object x$1) {
        return !BoxesRunTime.unboxToBoolean(p$1.apply(x$1));
    }

    public static /* synthetic */ boolean $anonfun$indexWhere$1(Function1 p$2, Object x$2) {
        return !BoxesRunTime.unboxToBoolean(p$2.apply(x$2));
    }

    public static void $init$(IndexedSeqOptimized $this) {
    }
}

