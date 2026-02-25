/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Option;
import scala.Product;
import scala.Product2;
import scala.Serializable;
import scala.Tuple2$;
import scala.Tuple2$mcCC$sp;
import scala.Tuple2$mcCD$sp;
import scala.Tuple2$mcCI$sp;
import scala.Tuple2$mcCJ$sp;
import scala.Tuple2$mcCZ$sp;
import scala.Tuple2$mcDC$sp;
import scala.Tuple2$mcDD$sp;
import scala.Tuple2$mcDI$sp;
import scala.Tuple2$mcDJ$sp;
import scala.Tuple2$mcDZ$sp;
import scala.Tuple2$mcIC$sp;
import scala.Tuple2$mcID$sp;
import scala.Tuple2$mcII$sp;
import scala.Tuple2$mcIJ$sp;
import scala.Tuple2$mcIZ$sp;
import scala.Tuple2$mcJC$sp;
import scala.Tuple2$mcJD$sp;
import scala.Tuple2$mcJI$sp;
import scala.Tuple2$mcJJ$sp;
import scala.Tuple2$mcJZ$sp;
import scala.Tuple2$mcZC$sp;
import scala.Tuple2$mcZD$sp;
import scala.Tuple2$mcZI$sp;
import scala.Tuple2$mcZJ$sp;
import scala.Tuple2$mcZZ$sp;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\t\u0015a\u0001B\f\u0019\u0005nA\u0001B\u0016\u0001\u0003\u0016\u0004%\ta\u0016\u0005\t1\u0002\u0011\t\u0012)A\u0005I!A\u0011\f\u0001BK\u0002\u0013\u0005!\f\u0003\u0005\\\u0001\tE\t\u0015!\u0003H\u0011\u0015a\u0006\u0001\"\u0001^\u0011\u0015\t\u0007\u0001\"\u0011c\u0011\u0015Y\u0007\u0001\"\u0001m\u0011\u001dq\u0007!!A\u0005\u0002=D\u0011\"!\u0003\u0001#\u0003%\t!a\u0003\t\u0013\u0005}\u0002!%A\u0005\u0002\u0005\u0005\u0003\"CA2\u0001\u0005\u0005I\u0011IA3\u0011%\t9\u0007AA\u0001\n\u0003\nI\u0007C\u0005\u0002x\u0001\t\t\u0011\"\u0001\u0002z!I\u0011Q\u0011\u0001\u0002\u0002\u0013\u0005\u0013q\u0011\u0005\n\u0003\u001f\u0003\u0011\u0011!C!\u0003#;\u0011\"!&\u0019\u0003\u0003E\t!a&\u0007\u0011]A\u0012\u0011!E\u0001\u00033Ca\u0001X\t\u0005\u0002\u0005m\u0005bB1\u0012\u0003\u0003%)E\u0019\u0005\n\u0003;\u000b\u0012\u0011!CA\u0003?C\u0011\"!3\u0012\u0003\u0003%\t)a3\t\u0013\u0005m\u0018#!A\u0005\n\u0005u(A\u0002+va2,'GC\u0001\u001a\u0003\u0015\u00198-\u00197b\u0007\u0001)2\u0001\b\u0014I'\u0015\u0001Q$\t)T!\tqr$D\u0001\u0019\u0013\t\u0001\u0003D\u0001\u0004B]f\u0014VM\u001a\t\u0005=\t\"s)\u0003\u0002$1\tA\u0001K]8ek\u000e$(\u0007\u0005\u0002&M1\u0001A!C\u0014\u0001A\u0003\u0005IQ1\u0001)\u0005\t!\u0016'\u0005\u0002*YA\u0011aDK\u0005\u0003Wa\u0011qAT8uQ&tw\r\u0005\u0002\u001f[%\u0011a\u0006\u0007\u0002\u0004\u0003:L\bf\u0002\u00141g]Zth\u0011\t\u0003=EJ!A\r\r\u0003\u0017M\u0004XmY5bY&TX\rZ\u0019\u0005IQ*dG\u0004\u0002\u001fk%\u0011a\u0007G\u0001\u0004\u0013:$\u0018\u0007\u0002\u00139sir!AH\u001d\n\u0005iB\u0012\u0001\u0002'p]\u001e\fD\u0001\n\u001f>}9\u0011a$P\u0005\u0003}a\ta\u0001R8vE2,\u0017\u0007\u0002\u0013A\u0003\ns!AH!\n\u0005\tC\u0012\u0001B\"iCJ\fD\u0001\n#F\r:\u0011a$R\u0005\u0003\rb\tqAQ8pY\u0016\fg\u000e\u0005\u0002&\u0011\u0012I\u0011\n\u0001Q\u0001\u0002\u0013\u0015\r\u0001\u000b\u0002\u0003)JBs\u0001\u0013\u0019L\u00196su*\r\u0003%iU2\u0014\u0007\u0002\u00139si\nD\u0001\n\u001f>}E\"A\u0005Q!Cc\u0011!C)\u0012$\u0011\u0005y\t\u0016B\u0001*\u0019\u0005\u001d\u0001&o\u001c3vGR\u0004\"A\b+\n\u0005UC\"\u0001D*fe&\fG.\u001b>bE2,\u0017AA02+\u0005!\u0013aA02A\u0005\u0011qLM\u000b\u0002\u000f\u0006\u0019qL\r\u0011\u0002\rqJg.\u001b;?)\rqv\f\u0019\t\u0005=\u0001!s\tC\u0003W\u000b\u0001\u0007A\u0005C\u0003Z\u000b\u0001\u0007q)\u0001\u0005u_N#(/\u001b8h)\u0005\u0019\u0007C\u00013j\u001b\u0005)'B\u00014h\u0003\u0011a\u0017M\\4\u000b\u0003!\fAA[1wC&\u0011!.\u001a\u0002\u0007'R\u0014\u0018N\\4\u0002\tM<\u0018\r]\u000b\u0002[B!a\u0004A$%\u0003\u0011\u0019w\u000e]=\u0016\u0007A\u001c8\u0010F\u0003r\u0003\u000b\t9\u0001\u0005\u0003\u001f\u0001IT\bCA\u0013t\t%9\u0003\u0002)A\u0001\u0002\u000b\u0007\u0001\u0006K\u0004taU4x\u000f_=2\t\u0011\"TGN\u0019\u0005IaJ$(\r\u0003%yur\u0014\u0007\u0002\u0013A\u0003\n\u000bD\u0001\n#F\rB\u0011Qe\u001f\u0003\n\u0013\"\u0001\u000b\u0011!AC\u0002!B\u0013b\u001f\u0019~}~\f\t!a\u00012\t\u0011\"TGN\u0019\u0005IaJ$(\r\u0003%yur\u0014\u0007\u0002\u0013A\u0003\n\u000bD\u0001\n#F\r\"9a\u000b\u0003I\u0001\u0002\u0004\u0011\bbB-\t!\u0003\u0005\rA_\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00132+\u0019\ti!a\t\u00022U\u0011\u0011q\u0002\u0016\u0004I\u0005E1FAA\n!\u0011\t)\"a\b\u000e\u0005\u0005]!\u0002BA\r\u00037\t\u0011\"\u001e8dQ\u0016\u001c7.\u001a3\u000b\u0007\u0005u\u0001$\u0001\u0006b]:|G/\u0019;j_:LA!!\t\u0002\u0018\t\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0005\u0013\u001dJ\u0001\u0015!A\u0001\u0006\u0004A\u0003&DA\u0012a\u0005\u001d\u0012\u0011FA\u0016\u0003[\ty#\r\u0003%iU2\u0014\u0007\u0002\u00139si\nD\u0001\n\u001f>}E\"A\u0005Q!Cc\u0011!C)\u0012$\u0005\u0013%K\u0001\u0015!A\u0001\u0006\u0004A\u0003&DA\u0019a\u0005U\u0012qGA\u001d\u0003w\ti$\r\u0003%iU2\u0014\u0007\u0002\u00139si\nD\u0001\n\u001f>}E\"A\u0005Q!Cc\u0011!C)\u0012$\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%eU1\u00111IA$\u0003+*\"!!\u0012+\u0007\u001d\u000b\t\u0002B\u0005(\u0015\u0001\u0006\t\u0011!b\u0001Q!j\u0011q\t\u0019\u0002L\u00055\u0013qJA)\u0003'\nD\u0001\n\u001b6mE\"A\u0005O\u001d;c\u0011!C(\u0010 2\t\u0011\u0002\u0015IQ\u0019\u0005I\u0011+e\tB\u0005J\u0015\u0001\u0006\t\u0011!b\u0001Q!j\u0011Q\u000b\u0019\u0002Z\u0005m\u0013QLA0\u0003C\nD\u0001\n\u001b6mE\"A\u0005O\u001d;c\u0011!C(\u0010 2\t\u0011\u0002\u0015IQ\u0019\u0005I\u0011+e)A\u0007qe>$Wo\u0019;Qe\u00164\u0017\u000e_\u000b\u0002G\u0006y\u0001O]8ek\u000e$\u0018\n^3sCR|'/\u0006\u0002\u0002lA)\u0011QNA:Y5\u0011\u0011q\u000e\u0006\u0004\u0003cB\u0012AC2pY2,7\r^5p]&!\u0011QOA8\u0005!IE/\u001a:bi>\u0014\u0018\u0001C2b]\u0016\u000bX/\u00197\u0015\t\u0005m\u0014\u0011\u0011\t\u0004=\u0005u\u0014bAA@1\t9!i\\8mK\u0006t\u0007\u0002CAB\u001b\u0005\u0005\t\u0019\u0001\u0017\u0002\u0007a$\u0013'\u0001\u0005iCND7i\u001c3f)\t\tI\tE\u0002\u001f\u0003\u0017K1!!$\u0019\u0005\rIe\u000e^\u0001\u0007KF,\u0018\r\\:\u0015\t\u0005m\u00141\u0013\u0005\t\u0003\u0007{\u0011\u0011!a\u0001Y\u00051A+\u001e9mKJ\u0002\"AH\t\u0014\u0007Ei2\u000b\u0006\u0002\u0002\u0018\u0006)\u0011\r\u001d9msV1\u0011\u0011UAT\u0003o#b!a)\u0002F\u0006\u001d\u0007C\u0002\u0010\u0001\u0003K\u000b)\fE\u0002&\u0003O#\u0011b\n\u000b!\u0002\u0003\u0005)\u0019\u0001\u0015)\u001b\u0005\u001d\u0006'a+\u0002.\u0006=\u0016\u0011WAZc\u0011!C'\u000e\u001c2\t\u0011B\u0014HO\u0019\u0005Iqjd(\r\u0003%\u0001\u0006\u0013\u0015\u0007\u0002\u0013E\u000b\u001a\u00032!JA\\\t%IE\u0003)A\u0001\u0002\u000b\u0007\u0001\u0006K\u0007\u00028B\nY,!0\u0002@\u0006\u0005\u00171Y\u0019\u0005IQ*d'\r\u0003%qeR\u0014\u0007\u0002\u0013={y\nD\u0001\n!B\u0005F\"A\u0005R#G\u0011\u00191F\u00031\u0001\u0002&\"1\u0011\f\u0006a\u0001\u0003k\u000bq!\u001e8baBd\u00170\u0006\u0004\u0002N\u0006e\u0017\u0011\u001e\u000b\u0005\u0003\u001f\f9\u0010E\u0003\u001f\u0003#\f).C\u0002\u0002Tb\u0011aa\u00149uS>t\u0007C\u0002\u0010\u0001\u0003/\f9\u000fE\u0002&\u00033$\u0011bJ\u000b!\u0002\u0003\u0005)\u0019\u0001\u0015)\u001b\u0005e\u0007'!8\u0002`\u0006\u0005\u00181]Asc\u0011!C'\u000e\u001c2\t\u0011B\u0014HO\u0019\u0005Iqjd(\r\u0003%\u0001\u0006\u0013\u0015\u0007\u0002\u0013E\u000b\u001a\u00032!JAu\t%IU\u0003)A\u0001\u0002\u000b\u0007\u0001\u0006K\u0007\u0002jB\ni/a<\u0002r\u0006M\u0018Q_\u0019\u0005IQ*d'\r\u0003%qeR\u0014\u0007\u0002\u0013={y\nD\u0001\n!B\u0005F\"A\u0005R#G\u0011%\tI0FA\u0001\u0002\u0004\t).A\u0002yIA\n1B]3bIJ+7o\u001c7wKR\u0011\u0011q \t\u0004I\n\u0005\u0011b\u0001B\u0002K\n1qJ\u00196fGR\u0004")
public class Tuple2<T1, T2>
implements Product2<T1, T2>,
Serializable {
    public final T1 _1;
    public final T2 _2;

    public static <T1, T2> Option<Tuple2<T1, T2>> unapply(Tuple2<T1, T2> tuple2) {
        return Tuple2$.MODULE$.unapply(tuple2);
    }

    public static <T1, T2> Tuple2<T1, T2> apply(T1 T1, T2 T2) {
        return Tuple2$.MODULE$.apply(T1, T2);
    }

    @Override
    public int productArity() {
        return Product2.productArity$(this);
    }

    @Override
    public Object productElement(int n) throws IndexOutOfBoundsException {
        return Product2.productElement$(this, n);
    }

    @Override
    public T1 _1() {
        return this._1;
    }

    @Override
    public T2 _2() {
        return this._2;
    }

    public String toString() {
        return new StringBuilder(3).append("(").append(this._1()).append(",").append(this._2()).append(")").toString();
    }

    public Tuple2<T2, T1> swap() {
        return new Tuple2<T2, T1>(this._2(), this._1());
    }

    public <T1, T2> Tuple2<T1, T2> copy(T1 _1, T2 _2) {
        return new Tuple2<T1, T2>(_1, _2);
    }

    public <T1, T2> T1 copy$default$1() {
        return this._1();
    }

    public <T1, T2> T2 copy$default$2() {
        return this._2();
    }

    @Override
    public String productPrefix() {
        return "Tuple2";
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof Tuple2;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof Tuple2;
                if (!bl) break block3;
                Tuple2 tuple2 = (Tuple2)x$1;
                if (!(BoxesRunTime.equals(this._1(), tuple2._1()) && BoxesRunTime.equals(this._2(), tuple2._2()))) break block3;
            }
            return true;
        }
        return false;
    }

    public boolean _1$mcZ$sp() {
        return BoxesRunTime.unboxToBoolean(this._1());
    }

    public char _1$mcC$sp() {
        return BoxesRunTime.unboxToChar(this._1());
    }

    @Override
    public double _1$mcD$sp() {
        return BoxesRunTime.unboxToDouble(this._1());
    }

    @Override
    public int _1$mcI$sp() {
        return BoxesRunTime.unboxToInt(this._1());
    }

    @Override
    public long _1$mcJ$sp() {
        return BoxesRunTime.unboxToLong(this._1());
    }

    public boolean _2$mcZ$sp() {
        return BoxesRunTime.unboxToBoolean(this._2());
    }

    public char _2$mcC$sp() {
        return BoxesRunTime.unboxToChar(this._2());
    }

    @Override
    public double _2$mcD$sp() {
        return BoxesRunTime.unboxToDouble(this._2());
    }

    @Override
    public int _2$mcI$sp() {
        return BoxesRunTime.unboxToInt(this._2());
    }

    @Override
    public long _2$mcJ$sp() {
        return BoxesRunTime.unboxToLong(this._2());
    }

    public Tuple2<Object, Object> swap$mcZZ$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcZC$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcZD$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcZI$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcZJ$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcCZ$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcCC$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcCD$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcCI$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcCJ$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcDZ$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcDC$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcDD$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcDI$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcDJ$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcIZ$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcIC$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcID$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcII$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcIJ$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcJZ$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcJC$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcJD$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcJI$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> swap$mcJJ$sp() {
        return this.swap();
    }

    public Tuple2<Object, Object> copy$mZZc$sp(boolean _1, boolean _2) {
        return new Tuple2$mcZZ$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mZCc$sp(boolean _1, char _2) {
        return new Tuple2$mcZC$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mZDc$sp(boolean _1, double _2) {
        return new Tuple2$mcZD$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mZIc$sp(boolean _1, int _2) {
        return new Tuple2$mcZI$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mZJc$sp(boolean _1, long _2) {
        return new Tuple2$mcZJ$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mCZc$sp(char _1, boolean _2) {
        return new Tuple2$mcCZ$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mCCc$sp(char _1, char _2) {
        return new Tuple2$mcCC$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mCDc$sp(char _1, double _2) {
        return new Tuple2$mcCD$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mCIc$sp(char _1, int _2) {
        return new Tuple2$mcCI$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mCJc$sp(char _1, long _2) {
        return new Tuple2$mcCJ$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mDZc$sp(double _1, boolean _2) {
        return new Tuple2$mcDZ$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mDCc$sp(double _1, char _2) {
        return new Tuple2$mcDC$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mDDc$sp(double _1, double _2) {
        return new Tuple2$mcDD$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mDIc$sp(double _1, int _2) {
        return new Tuple2$mcDI$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mDJc$sp(double _1, long _2) {
        return new Tuple2$mcDJ$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mIZc$sp(int _1, boolean _2) {
        return new Tuple2$mcIZ$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mICc$sp(int _1, char _2) {
        return new Tuple2$mcIC$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mIDc$sp(int _1, double _2) {
        return new Tuple2$mcID$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mIIc$sp(int _1, int _2) {
        return new Tuple2$mcII$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mIJc$sp(int _1, long _2) {
        return new Tuple2$mcIJ$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mJZc$sp(long _1, boolean _2) {
        return new Tuple2$mcJZ$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mJCc$sp(long _1, char _2) {
        return new Tuple2$mcJC$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mJDc$sp(long _1, double _2) {
        return new Tuple2$mcJD$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mJIc$sp(long _1, int _2) {
        return new Tuple2$mcJI$sp(_1, _2);
    }

    public Tuple2<Object, Object> copy$mJJc$sp(long _1, long _2) {
        return new Tuple2$mcJJ$sp(_1, _2);
    }

    public <T1, T2> boolean copy$default$1$mcZ$sp() {
        return BoxesRunTime.unboxToBoolean(this.copy$default$1());
    }

    public <T1, T2> char copy$default$1$mcC$sp() {
        return BoxesRunTime.unboxToChar(this.copy$default$1());
    }

    public <T1, T2> double copy$default$1$mcD$sp() {
        return BoxesRunTime.unboxToDouble(this.copy$default$1());
    }

    public <T1, T2> int copy$default$1$mcI$sp() {
        return BoxesRunTime.unboxToInt(this.copy$default$1());
    }

    public <T1, T2> long copy$default$1$mcJ$sp() {
        return BoxesRunTime.unboxToLong(this.copy$default$1());
    }

    public <T1, T2> boolean copy$default$2$mcZ$sp() {
        return BoxesRunTime.unboxToBoolean(this.copy$default$2());
    }

    public <T1, T2> char copy$default$2$mcC$sp() {
        return BoxesRunTime.unboxToChar(this.copy$default$2());
    }

    public <T1, T2> double copy$default$2$mcD$sp() {
        return BoxesRunTime.unboxToDouble(this.copy$default$2());
    }

    public <T1, T2> int copy$default$2$mcI$sp() {
        return BoxesRunTime.unboxToInt(this.copy$default$2());
    }

    public <T1, T2> long copy$default$2$mcJ$sp() {
        return BoxesRunTime.unboxToLong(this.copy$default$2());
    }

    public boolean specInstance$() {
        return false;
    }

    public Tuple2(T1 _1, T2 _2) {
        this._1 = _1;
        this._2 = _2;
        Product.$init$(this);
        Product2.$init$(this);
    }
}

