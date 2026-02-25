/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Function0;
import scala.Function1;
import scala.None$;
import scala.Option$;
import scala.PartialFunction;
import scala.Predef$;
import scala.Product;
import scala.Serializable;
import scala.Some;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.package$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.Null$;
import scala.util.Either;

@ScalaSignature(bytes="\u0006\u0001\t\rv!B\u0014)\u0011\u0003Yc!B\u0017)\u0011\u0003q\u0003\"B\u001b\u0002\t\u00031\u0004\"B\u001c\u0002\t\u0007A\u0004b\u0002B:\u0003\u0011\u0005!Q\u000f\u0005\b\u0005\u0007\u000bA\u0011\u0001BC\u0011%\u0011y)AA\u0001\n\u0013\u0011\tJB\u0003.Q\u0005\u0005r\nC\u00036\u000f\u0011\u0005A\u000bC\u0003Y\u000f\u0019\u0005\u0011\fC\u0003^\u000f\u0011\u0005\u0011\fC\u0003_\u000f\u0019\u0005q\fC\u0003a\u000f\u0011\u0015\u0011\rC\u0003q\u000f\u0011\u0015\u0011\u000fC\u0004\u0002\u0010\u001d!)!!\u0005\t\u000f\u0005\u001dr\u0001\"\u0002\u0002*!9\u0011qH\u0004\u0005\u0006\u0005\u0005\u0003bBA)\u000f\u0011\u0005\u00111\u000b\u0005\b\u0003C:AQAA2\u0011\u001d\tig\u0002C\u0003\u0003_Ba!!\u001e\b\t\u000bI\u0006bBA<\u000f\u0011\u0015\u0011\u0011\u0010\u0004\u0007\u0003\u007f:\u0001!!!\t\u0015\u0005\u001ddC!A!\u0002\u0013\tI\u0007\u0003\u00046-\u0011\u0005\u00111\u0011\u0005\b\u0003\u001f1B\u0011AAD\u0011\u001d\tyD\u0006C\u0001\u0003+Cq!a)\u0017\t\u0003\t)\u000bC\u0004\u0002xY!\t!!/\t\u000f\u0005\rw\u0001\"\u0002\u0002F\"9\u0011\u0011[\u0004\u0005\u0006\u0005M\u0007bBAm\u000f\u0011\u0015\u00111\u001c\u0005\b\u0003G;AQAAq\u0011\u001d\tyo\u0002C\u0003\u0003cDqAa\u0002\b\t\u000b\u0011I\u0001C\u0004\u0003\u001c\u001d!\tA!\b\t\u000f\t\u0015r\u0001\"\u0001\u0003(!9!qF\u0004\u0005\u0006\tE\u0002b\u0002B%\u000f\u0011\u0015!1J\u0001\u0007\u001fB$\u0018n\u001c8\u000b\u0003%\nQa]2bY\u0006\u001c\u0001\u0001\u0005\u0002-\u00035\t\u0001F\u0001\u0004PaRLwN\\\n\u0004\u0003=\u0012\u0004C\u0001\u00171\u0013\t\t\u0004F\u0001\u0004B]f\u0014VM\u001a\t\u0003YMJ!\u0001\u000e\u0015\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\rqJg.\u001b;?)\u0005Y\u0013aD8qi&|gNM%uKJ\f'\r\\3\u0016\u0005e\u001aEC\u0001\u001eM!\rYd(\u0011\b\u0003YqJ!!\u0010\u0015\u0002\u000fA\f7m[1hK&\u0011q\b\u0011\u0002\t\u0013R,'/\u00192mK*\u0011Q\b\u000b\t\u0003\u0005\u000ec\u0001\u0001B\u0003E\u0007\t\u0007QIA\u0001B#\t1\u0015\n\u0005\u0002-\u000f&\u0011\u0001\n\u000b\u0002\b\u001d>$\b.\u001b8h!\ta#*\u0003\u0002LQ\t\u0019\u0011I\\=\t\u000b5\u001b\u0001\u0019\u0001(\u0002\u0005a|\u0007c\u0001\u0017\b\u0003V\u0011\u0001kV\n\u0005\u000f=\n&\u0007\u0005\u0002-%&\u00111\u000b\u000b\u0002\b!J|G-^2u)\u0005)\u0006c\u0001\u0017\b-B\u0011!i\u0016\u0003\u0007\t\u001e!)\u0019A#\u0002\u000f%\u001cX)\u001c9usV\t!\f\u0005\u0002-7&\u0011A\f\u000b\u0002\b\u0005>|G.Z1o\u0003%I7\u000fR3gS:,G-A\u0002hKR,\u0012AV\u0001\nO\u0016$xJ]#mg\u0016,\"A\u00193\u0015\u0005\r<\u0007C\u0001\"e\t\u0015)GB1\u0001g\u0005\u0005\u0011\u0015C\u0001,J\u0011\u0019AG\u0002\"a\u0001S\u00069A-\u001a4bk2$\bc\u0001\u0017kG&\u00111\u000e\u000b\u0002\ty\tLh.Y7f}!\u0012A\"\u001c\t\u0003Y9L!a\u001c\u0015\u0003\r%tG.\u001b8f\u0003\u0019y'OT;mYV\u0011!\u000f\u001e\u000b\u0003gZ\u0004\"A\u0011;\u0005\u000bUl!\u0019\u00014\u0003\u0005\u0005\u000b\u0004\"B<\u000e\u0001\bA\u0018AA3w!\u0019I\u0018\u0011AA\u0004g:\u0011!P \t\u0003w\"j\u0011\u0001 \u0006\u0003{*\na\u0001\u0010:p_Rt\u0014BA@)\u0003\u0019\u0001&/\u001a3fM&!\u00111AA\u0003\u0005A!C.Z:tI\r|Gn\u001c8%Y\u0016\u001c8O\u0003\u0002\u0000QA\u0019A&!\u0003\n\u0007\u0005-\u0001F\u0001\u0003Ok2d\u0007FA\u0007n\u0003\ri\u0017\r]\u000b\u0005\u0003'\tI\u0002\u0006\u0003\u0002\u0016\u0005m\u0001\u0003\u0002\u0017\b\u0003/\u00012AQA\r\t\u0015)gB1\u0001F\u0011\u001d\tiB\u0004a\u0001\u0003?\t\u0011A\u001a\t\u0007Y\u0005\u0005b+a\u0006\n\u0007\u0005\r\u0002FA\u0005Gk:\u001cG/[8oc!\u0012a\"\\\u0001\u0005M>dG-\u0006\u0003\u0002,\u0005EB\u0003BA\u0017\u0003o!B!a\f\u00024A\u0019!)!\r\u0005\u000b\u0015|!\u0019A#\t\u000f\u0005uq\u00021\u0001\u00026A1A&!\tW\u0003_A\u0001\"!\u000f\u0010\t\u0003\u0007\u00111H\u0001\bS\u001a,U\u000e\u001d;z!\u0011a#.a\f)\u0005=i\u0017a\u00024mCRl\u0015\r]\u000b\u0005\u0003\u0007\nI\u0005\u0006\u0003\u0002F\u0005-\u0003\u0003\u0002\u0017\b\u0003\u000f\u00022AQA%\t\u0015)\u0007C1\u0001F\u0011\u001d\ti\u0002\u0005a\u0001\u0003\u001b\u0002b\u0001LA\u0011-\u0006\u0015\u0003F\u0001\tn\u0003\u001d1G.\u0019;uK:,B!!\u0016\u0002\\Q!\u0011qKA/!\u0011as!!\u0017\u0011\u0007\t\u000bY\u0006B\u0003f#\t\u0007Q\t\u0003\u0004x#\u0001\u000f\u0011q\f\t\u0007s\u0006\u0005a+a\u0016\u0002\r\u0019LG\u000e^3s)\r)\u0016Q\r\u0005\b\u0003O\u0012\u0002\u0019AA5\u0003\u0005\u0001\b#\u0002\u0017\u0002\"YS\u0006F\u0001\nn\u0003%1\u0017\u000e\u001c;fe:{G\u000fF\u0002V\u0003cBq!a\u001a\u0014\u0001\u0004\tI\u0007\u000b\u0002\u0014[\u0006Aan\u001c8F[B$\u00180\u0001\u0006xSRDg)\u001b7uKJ$B!a\u001f\u0002@B\u0019\u0011Q\u0010\f\u000e\u0003\u001d\u0011!bV5uQ\u001aKG\u000e^3s'\t1r\u0006\u0006\u0003\u0002|\u0005\u0015\u0005bBA41\u0001\u0007\u0011\u0011N\u000b\u0005\u0003\u0013\u000by\t\u0006\u0003\u0002\f\u0006E\u0005\u0003\u0002\u0017\b\u0003\u001b\u00032AQAH\t\u0015)\u0017D1\u0001F\u0011\u001d\ti\"\u0007a\u0001\u0003'\u0003b\u0001LA\u0011-\u00065U\u0003BAL\u0003;#B!!'\u0002 B!AfBAN!\r\u0011\u0015Q\u0014\u0003\u0006Kj\u0011\r!\u0012\u0005\b\u0003;Q\u0002\u0019AAQ!\u0019a\u0013\u0011\u0005,\u0002\u001a\u00069am\u001c:fC\u000eDW\u0003BAT\u0003k#B!!+\u00020B\u0019A&a+\n\u0007\u00055\u0006F\u0001\u0003V]&$\bbBA\u000f7\u0001\u0007\u0011\u0011\u0017\t\u0007Y\u0005\u0005b+a-\u0011\u0007\t\u000b)\f\u0002\u0004\u00028n\u0011\r!\u0012\u0002\u0002+R!\u00111PA^\u0011\u001d\ti\f\ba\u0001\u0003S\n\u0011!\u001d\u0005\b\u0003O*\u0002\u0019AA5Q\t)R.\u0001\u0005d_:$\u0018-\u001b8t+\u0011\t9-a4\u0015\u0007i\u000bI\rC\u0004\u0002Lv\u0001\r!!4\u0002\t\u0015dW-\u001c\t\u0004\u0005\u0006=G!B;\u001e\u0005\u00041\u0017AB3ySN$8\u000fF\u0002[\u0003+Dq!a\u001a\u001f\u0001\u0004\tI\u0007\u000b\u0002\u001f[\u00061am\u001c:bY2$2AWAo\u0011\u001d\t9g\ba\u0001\u0003SB#aH7\u0016\t\u0005\r\u00181\u001e\u000b\u0005\u0003S\u000b)\u000fC\u0004\u0002\u001e\u0001\u0002\r!a:\u0011\r1\n\tCVAu!\r\u0011\u00151\u001e\u0003\u0007\u0003o\u0003#\u0019A#)\u0005\u0001j\u0017aB2pY2,7\r^\u000b\u0005\u0003g\fI\u0010\u0006\u0003\u0002v\u0006m\b\u0003\u0002\u0017\b\u0003o\u00042AQA}\t\u0015)\u0017E1\u0001F\u0011\u001d\ti0\ta\u0001\u0003\u007f\f!\u0001\u001d4\u0011\r1\u0012\tAVA|\u0013\r\u0011\u0019\u0001\u000b\u0002\u0010!\u0006\u0014H/[1m\rVt7\r^5p]\"\u0012\u0011%\\\u0001\u0007_J,En]3\u0016\t\t-!\u0011\u0003\u000b\u0005\u0005\u001b\u0011\u0019\u0002\u0005\u0003-\u000f\t=\u0001c\u0001\"\u0003\u0012\u0011)QM\tb\u0001M\"A!Q\u0003\u0012\u0005\u0002\u0004\u00119\"A\u0006bYR,'O\\1uSZ,\u0007\u0003\u0002\u0017k\u0005\u001bA#AI7\u0002\u0011%$XM]1u_J,\"Aa\b\u0011\tm\u0012\tCV\u0005\u0004\u0005G\u0001%\u0001C%uKJ\fGo\u001c:\u0002\rQ|G*[:u+\t\u0011I\u0003\u0005\u0003<\u0005W1\u0016b\u0001B\u0017\u0001\n!A*[:u\u0003\u001d!xNU5hQR,BAa\r\u0003>Q!!Q\u0007B!!\u0019Y$q\u0007B\u001e-&\u0019!\u0011\b!\u0003\r\u0015KG\u000f[3s!\r\u0011%Q\b\u0003\u0007\u0005\u007f)#\u0019A#\u0003\u0003aC\u0001Ba\u0011&\t\u0003\u0007!QI\u0001\u0005Y\u00164G\u000f\u0005\u0003-U\nm\u0002FA\u0013n\u0003\u0019!x\u000eT3giV!!Q\nB*)\u0011\u0011yE!\u0016\u0011\rm\u00129D\u0016B)!\r\u0011%1\u000b\u0003\u0007\u0005\u007f1#\u0019A#\t\u0011\t]c\u0005\"a\u0001\u00053\nQA]5hQR\u0004B\u0001\f6\u0003R!\u0012a%\\\u0015\u0006\u000f\t}#1\r\u0006\u0004\u0005CB\u0013\u0001\u0002(p]\u0016L1A!\u001a)\u0005\u0011\u0019v.\\3)\u000f\u001d\u0011IGa\u001c\u0003rA\u0019AFa\u001b\n\u0007\t5\u0004F\u0001\tTKJL\u0017\r\u001c,feNLwN\\+J\t\u0006)a/\u00197vKzAa@[\u001c~8<1G/A\u0003baBd\u00170\u0006\u0003\u0003x\tuD\u0003\u0002B=\u0005\u007f\u0002B\u0001L\u0004\u0003|A\u0019!I! \u0005\u000b\u0011#!\u0019A#\t\u000f\t\u0005E\u00011\u0001\u0003|\u0005\t\u00010A\u0003f[B$\u00180\u0006\u0003\u0003\b\n5UC\u0001BE!\u0011asAa#\u0011\u0007\t\u0013i\tB\u0003E\u000b\t\u0007Q)A\u0006sK\u0006$'+Z:pYZ,GC\u0001BJ!\u0011\u0011)Ja(\u000e\u0005\t]%\u0002\u0002BM\u00057\u000bA\u0001\\1oO*\u0011!QT\u0001\u0005U\u00064\u0018-\u0003\u0003\u0003\"\n]%AB(cU\u0016\u001cG\u000f")
public abstract class Option<A>
implements Product,
Serializable {
    public static final long serialVersionUID = -114498752079829388L;

    public static <A> Option<A> empty() {
        return Option$.MODULE$.empty();
    }

    public static <A> Option<A> apply(A a) {
        return Option$.MODULE$.apply(a);
    }

    public static <A> Iterable<A> option2Iterable(Option<A> option) {
        return Option$.MODULE$.option2Iterable(option);
    }

    @Override
    public Iterator<Object> productIterator() {
        return Product.productIterator$(this);
    }

    @Override
    public String productPrefix() {
        return Product.productPrefix$(this);
    }

    public abstract boolean isEmpty();

    public boolean isDefined() {
        return !this.isEmpty();
    }

    public abstract A get();

    public final <B> B getOrElse(Function0<B> function0) {
        if (this.isEmpty()) {
            return function0.apply();
        }
        return (B)this.get();
    }

    public final <A1> A1 orNull(Predef$.less.colon.less<Null$, A1> ev) {
        if (this.isEmpty()) {
            return (A1)ev.apply(null);
        }
        return (A1)this.get();
    }

    public final <B> Option<B> map(Function1<A, B> f) {
        if (this.isEmpty()) {
            return None$.MODULE$;
        }
        return new Some<B>(f.apply(this.get()));
    }

    public final <B> B fold(Function0<B> ifEmpty2, Function1<A, B> f) {
        if (this.isEmpty()) {
            return ifEmpty2.apply();
        }
        return f.apply(this.get());
    }

    public final <B> Option<B> flatMap(Function1<A, Option<B>> f) {
        if (this.isEmpty()) {
            return None$.MODULE$;
        }
        return f.apply(this.get());
    }

    public <B> Option<B> flatten(Predef$.less.colon.less<A, Option<B>> ev) {
        if (this.isEmpty()) {
            return None$.MODULE$;
        }
        return (Option)ev.apply(this.get());
    }

    public final Option<A> filter(Function1<A, Object> p) {
        if (this.isEmpty() || BoxesRunTime.unboxToBoolean(p.apply(this.get()))) {
            return this;
        }
        return None$.MODULE$;
    }

    public final Option<A> filterNot(Function1<A, Object> p) {
        if (this.isEmpty() || !BoxesRunTime.unboxToBoolean(p.apply(this.get()))) {
            return this;
        }
        return None$.MODULE$;
    }

    public final boolean nonEmpty() {
        return this.isDefined();
    }

    public final WithFilter withFilter(Function1<A, Object> p) {
        return new WithFilter(this, p);
    }

    public final <A1> boolean contains(A1 elem) {
        return !this.isEmpty() && BoxesRunTime.equals(this.get(), elem);
    }

    public final boolean exists(Function1<A, Object> p) {
        return !this.isEmpty() && BoxesRunTime.unboxToBoolean(p.apply(this.get()));
    }

    public final boolean forall(Function1<A, Object> p) {
        return this.isEmpty() || BoxesRunTime.unboxToBoolean(p.apply(this.get()));
    }

    public final <U> void foreach(Function1<A, U> f) {
        if (!this.isEmpty()) {
            f.apply(this.get());
        }
    }

    public final <B> Option<B> collect(PartialFunction<A, B> pf) {
        if (!this.isEmpty()) {
            return pf.lift().apply(this.get());
        }
        return None$.MODULE$;
    }

    public final <B> Option<B> orElse(Function0<Option<B>> alternative) {
        if (this.isEmpty()) {
            return alternative.apply();
        }
        return this;
    }

    public Iterator<A> iterator() {
        if (this.isEmpty()) {
            return Iterator$.MODULE$.empty();
        }
        return Iterator$.MODULE$.single(this.get());
    }

    public List<A> toList() {
        if (this.isEmpty()) {
            return Nil$.MODULE$;
        }
        return new $colon$colon<Nothing$>((Nothing$)this.get(), Nil$.MODULE$);
    }

    public final <X> Either<X, A> toRight(Function0<X> left) {
        if (this.isEmpty()) {
            return package$.MODULE$.Left().apply(left.apply());
        }
        return package$.MODULE$.Right().apply(this.get());
    }

    public final <X> Either<A, X> toLeft(Function0<X> right) {
        if (this.isEmpty()) {
            return package$.MODULE$.Right().apply(right.apply());
        }
        return package$.MODULE$.Left().apply(this.get());
    }

    public Option() {
        Product.$init$(this);
    }

    public class WithFilter {
        private final Function1<A, Object> p;
        public final /* synthetic */ Option $outer;

        public <B> Option<B> map(Function1<A, B> f) {
            Option option = this.scala$Option$WithFilter$$$outer().filter(this.p);
            if (option == null) {
                throw null;
            }
            Option map_this = option;
            if (map_this.isEmpty()) {
                return None$.MODULE$;
            }
            return new Some<B>(f.apply(map_this.get()));
        }

        public <B> Option<B> flatMap(Function1<A, Option<B>> f) {
            Option option = this.scala$Option$WithFilter$$$outer().filter(this.p);
            if (option == null) {
                throw null;
            }
            Option flatMap_this = option;
            if (flatMap_this.isEmpty()) {
                return None$.MODULE$;
            }
            return f.apply(flatMap_this.get());
        }

        public <U> void foreach(Function1<A, U> f) {
            Option option = this.scala$Option$WithFilter$$$outer().filter(this.p);
            if (option == null) {
                throw null;
            }
            Option foreach_this = option;
            if (!foreach_this.isEmpty()) {
                f.apply(foreach_this.get());
                return;
            }
        }

        public WithFilter withFilter(Function1<A, Object> q) {
            return new WithFilter(this.scala$Option$WithFilter$$$outer(), (Function1<Object, Object> & java.io.Serializable & Serializable)x -> BoxesRunTime.boxToBoolean(WithFilter.$anonfun$withFilter$1(this, q, x)));
        }

        public /* synthetic */ Option scala$Option$WithFilter$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ boolean $anonfun$withFilter$1(WithFilter $this, Function1 q$1, Object x) {
            return BoxesRunTime.unboxToBoolean($this.p.apply(x)) && BoxesRunTime.unboxToBoolean(q$1.apply(x));
        }

        public WithFilter(Option $outer, Function1<A, Object> p) {
            this.p = p;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }
}

