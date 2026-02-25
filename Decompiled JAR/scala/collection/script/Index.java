/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.script;

import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.collection.Iterator;
import scala.collection.script.Index$;
import scala.collection.script.Location;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import scala.runtime.Statics;

@ScalaSignature(bytes="\u0006\u0001\u0005Ma\u0001B\u000b\u0017\u0001vA\u0001\"\u000b\u0001\u0003\u0016\u0004%\tA\u000b\u0005\t]\u0001\u0011\t\u0012)A\u0005W!)q\u0006\u0001C\u0001a!91\u0007AA\u0001\n\u0003!\u0004b\u0002\u001c\u0001#\u0003%\ta\u000e\u0005\b\u0005\u0002\t\t\u0011\"\u0011D\u0011\u001da\u0005!!A\u0005\u0002)Bq!\u0014\u0001\u0002\u0002\u0013\u0005a\nC\u0004U\u0001\u0005\u0005I\u0011I+\t\u000fi\u0003\u0011\u0011!C\u00017\"9\u0001\rAA\u0001\n\u0003\n\u0007b\u00022\u0001\u0003\u0003%\te\u0019\u0005\bI\u0002\t\t\u0011\"\u0011f\u000f\u001dyg#!A\t\u0002A4q!\u0006\f\u0002\u0002#\u0005\u0011\u000fC\u00030\u001f\u0011\u0005\u0001\u0010C\u0004c\u001f\u0005\u0005IQI2\t\u000fe|\u0011\u0011!CAu\"9ApDA\u0001\n\u0003k\b\"CA\u0004\u001f\u0005\u0005I\u0011BA\u0005\u0005\u0015Ie\u000eZ3y\u0015\t9\u0002$\u0001\u0004tGJL\u0007\u000f\u001e\u0006\u00033i\t!bY8mY\u0016\u001cG/[8o\u0015\u0005Y\u0012!B:dC2\f7\u0001A\n\u0005\u0001y\u0011c\u0005\u0005\u0002 A5\ta#\u0003\u0002\"-\tAAj\\2bi&|g\u000e\u0005\u0002$I5\t!$\u0003\u0002&5\t9\u0001K]8ek\u000e$\bCA\u0012(\u0013\tA#D\u0001\u0007TKJL\u0017\r\\5{C\ndW-A\u0001o+\u0005Y\u0003CA\u0012-\u0013\ti#DA\u0002J]R\f!A\u001c\u0011\u0002\rqJg.\u001b;?)\t\t$\u0007\u0005\u0002 \u0001!)\u0011f\u0001a\u0001W\u0005!1m\u001c9z)\t\tT\u0007C\u0004*\tA\u0005\t\u0019A\u0016\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%cU\t\u0001H\u000b\u0002,s-\n!\b\u0005\u0002<\u00016\tAH\u0003\u0002>}\u0005IQO\\2iK\u000e\\W\r\u001a\u0006\u0003\u007fi\t!\"\u00198o_R\fG/[8o\u0013\t\tEHA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016\fQ\u0002\u001d:pIV\u001cG\u000f\u0015:fM&DX#\u0001#\u0011\u0005\u0015SU\"\u0001$\u000b\u0005\u001dC\u0015\u0001\u00027b]\u001eT\u0011!S\u0001\u0005U\u00064\u0018-\u0003\u0002L\r\n11\u000b\u001e:j]\u001e\fA\u0002\u001d:pIV\u001cG/\u0011:jif\fa\u0002\u001d:pIV\u001cG/\u00127f[\u0016tG\u000f\u0006\u0002P%B\u00111\u0005U\u0005\u0003#j\u00111!\u00118z\u0011\u001d\u0019\u0006\"!AA\u0002-\n1\u0001\u001f\u00132\u0003=\u0001(o\u001c3vGRLE/\u001a:bi>\u0014X#\u0001,\u0011\u0007]Cv*D\u0001\u0019\u0013\tI\u0006D\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003!\u0019\u0017M\\#rk\u0006dGC\u0001/`!\t\u0019S,\u0003\u0002_5\t9!i\\8mK\u0006t\u0007bB*\u000b\u0003\u0003\u0005\raT\u0001\tQ\u0006\u001c\bnQ8eKR\t1&\u0001\u0005u_N#(/\u001b8h)\u0005!\u0015AB3rk\u0006d7\u000f\u0006\u0002]M\"91+DA\u0001\u0002\u0004y\u0005\u0006\u0002\u0001iW6\u0004\"aI5\n\u0005)T\"A\u00033faJ,7-\u0019;fI\u0006\nA.A\ftGJL\u0007\u000f^5oO\u0002J7\u000f\t3faJ,7-\u0019;fI\u0006\na.\u0001\u00043]E\nd\u0006M\u0001\u0006\u0013:$W\r\u001f\t\u0003?=\u00192a\u0004:'!\u0011\u0019hoK\u0019\u000e\u0003QT!!\u001e\u000e\u0002\u000fI,h\u000e^5nK&\u0011q\u000f\u001e\u0002\u0012\u0003\n\u001cHO]1di\u001a+hn\u0019;j_:\fD#\u00019\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\u0005EZ\b\"B\u0015\u0013\u0001\u0004Y\u0013aB;oCB\u0004H.\u001f\u000b\u0004}\u0006\r\u0001cA\u0012\u0000W%\u0019\u0011\u0011\u0001\u000e\u0003\r=\u0003H/[8o\u0011!\t)aEA\u0001\u0002\u0004\t\u0014a\u0001=%a\u0005Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\tY\u0001E\u0002F\u0003\u001bI1!a\u0004G\u0005\u0019y%M[3di\"\"q\u0002[6n\u0001")
public class Index
extends Location
implements Product,
Serializable {
    private final int n;

    public static Option<Object> unapply(Index index) {
        return Index$.MODULE$.unapply(index);
    }

    public static Index apply(int n) {
        return Index$.MODULE$.apply(n);
    }

    public static <A> Function1<Object, A> andThen(Function1<Index, A> function1) {
        Index$ index$ = Index$.MODULE$;
        if (index$ == null) {
            throw null;
        }
        return arg_0 -> Function1.$anonfun$andThen$1(index$, function1, arg_0);
    }

    public static <A> Function1<A, Index> compose(Function1<A, Object> function1) {
        Index$ index$ = Index$.MODULE$;
        if (index$ == null) {
            throw null;
        }
        return arg_0 -> Function1.$anonfun$compose$1(index$, function1, arg_0);
    }

    public int n() {
        return this.n;
    }

    public Index copy(int n) {
        return new Index(n);
    }

    public int copy$default$1() {
        return this.n();
    }

    @Override
    public String productPrefix() {
        return "Index";
    }

    @Override
    public int productArity() {
        return 1;
    }

    @Override
    public Object productElement(int x$1) {
        switch (x$1) {
            case 0: {
                return BoxesRunTime.boxToInteger(this.n());
            }
        }
        throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof Index;
    }

    public int hashCode() {
        return Statics.finalizeHash(Statics.mix(-889275714, this.n()), 1);
    }

    public String toString() {
        return ScalaRunTime$.MODULE$._toString(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof Index;
                if (!bl) break block3;
                Index index = (Index)x$1;
                if (!(this.n() == index.n() && index.canEqual(this))) break block3;
            }
            return true;
        }
        return false;
    }

    public Index(int n) {
        this.n = n;
        Product.$init$(this);
    }
}

