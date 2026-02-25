/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.script;

import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.script.Include$;
import scala.collection.script.Location;
import scala.collection.script.Message;
import scala.collection.script.NoLo$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005-d\u0001B\r\u001b\u0001\u0006B\u0001\u0002\u0010\u0001\u0003\u0016\u0004%\t!\u0010\u0005\t\u0003\u0002\u0011\t\u0012)A\u0005}!A!\t\u0001BK\u0002\u0013\u00051\t\u0003\u0005E\u0001\tE\t\u0015!\u0003,\u0011\u0015)\u0005\u0001\"\u0001G\u0011\u0015)\u0005\u0001\"\u0001K\u0011\u001da\u0005!!A\u0005\u00025Cq\u0001\u0016\u0001\u0012\u0002\u0013\u0005Q\u000bC\u0004c\u0001E\u0005I\u0011A2\t\u000f\u001d\u0004\u0011\u0011!C!Q\"9\u0011\u000fAA\u0001\n\u0003\u0011\bb\u0002<\u0001\u0003\u0003%\ta\u001e\u0005\bu\u0002\t\t\u0011\"\u0011|\u0011%\t\t\u0001AA\u0001\n\u0003\t\u0019\u0001C\u0005\u0002\u000e\u0001\t\t\u0011\"\u0011\u0002\u0010!I\u0011\u0011\u0003\u0001\u0002\u0002\u0013\u0005\u00131\u0003\u0005\n\u0003+\u0001\u0011\u0011!C!\u0003/9\u0011\"a\u000b\u001b\u0003\u0003E\t!!\f\u0007\u0011eQ\u0012\u0011!E\u0001\u0003_Aa!R\n\u0005\u0002\u0005E\u0002\"CA\t'\u0005\u0005IQIA\n\u0011%\t\u0019dEA\u0001\n\u0003\u000b)\u0004C\u0005\u0002DM\t\t\u0011\"!\u0002F!I\u0011qL\n\u0002\u0002\u0013%\u0011\u0011\r\u0002\b\u0013:\u001cG.\u001e3f\u0015\tYB$\u0001\u0004tGJL\u0007\u000f\u001e\u0006\u0003;y\t!bY8mY\u0016\u001cG/[8o\u0015\u0005y\u0012!B:dC2\f7\u0001A\u000b\u0003E5\u001aR\u0001A\u0012(me\u0002\"\u0001J\u0013\u000e\u0003yI!A\n\u0010\u0003\r\u0005s\u0017PU3g!\rA\u0013fK\u0007\u00025%\u0011!F\u0007\u0002\b\u001b\u0016\u001c8/Y4f!\taS\u0006\u0004\u0001\u0005\r9\u0002AQ1\u00010\u0005\u0005\t\u0015C\u0001\u00194!\t!\u0013'\u0003\u00023=\t9aj\u001c;iS:<\u0007C\u0001\u00135\u0013\t)dDA\u0002B]f\u0004\"\u0001J\u001c\n\u0005ar\"a\u0002)s_\u0012,8\r\u001e\t\u0003IiJ!a\u000f\u0010\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\u00111|7-\u0019;j_:,\u0012A\u0010\t\u0003Q}J!\u0001\u0011\u000e\u0003\u00111{7-\u0019;j_:\f\u0011\u0002\\8dCRLwN\u001c\u0011\u0002\t\u0015dW-\\\u000b\u0002W\u0005)Q\r\\3nA\u00051A(\u001b8jiz\"2a\u0012%J!\rA\u0003a\u000b\u0005\u0006y\u0015\u0001\rA\u0010\u0005\u0006\u0005\u0016\u0001\ra\u000b\u000b\u0003\u000f.CQA\u0011\u0004A\u0002-\nAaY8qsV\u0011a*\u0015\u000b\u0004\u001fJ\u001b\u0006c\u0001\u0015\u0001!B\u0011A&\u0015\u0003\u0006]\u001d\u0011\ra\f\u0005\by\u001d\u0001\n\u00111\u0001?\u0011\u001d\u0011u\u0001%AA\u0002A\u000babY8qs\u0012\"WMZ1vYR$\u0013'\u0006\u0002WCV\tqK\u000b\u0002?1.\n\u0011\f\u0005\u0002[?6\t1L\u0003\u0002];\u0006IQO\\2iK\u000e\\W\r\u001a\u0006\u0003=z\t!\"\u00198o_R\fG/[8o\u0013\t\u00017LA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016$QA\f\u0005C\u0002=\nabY8qs\u0012\"WMZ1vYR$#'\u0006\u0002eMV\tQM\u000b\u0002,1\u0012)a&\u0003b\u0001_\u0005i\u0001O]8ek\u000e$\bK]3gSb,\u0012!\u001b\t\u0003U>l\u0011a\u001b\u0006\u0003Y6\fA\u0001\\1oO*\ta.\u0001\u0003kCZ\f\u0017B\u00019l\u0005\u0019\u0019FO]5oO\u0006a\u0001O]8ek\u000e$\u0018I]5usV\t1\u000f\u0005\u0002%i&\u0011QO\b\u0002\u0004\u0013:$\u0018A\u00049s_\u0012,8\r^#mK6,g\u000e\u001e\u000b\u0003gaDq!\u001f\u0007\u0002\u0002\u0003\u00071/A\u0002yIE\nq\u0002\u001d:pIV\u001cG/\u0013;fe\u0006$xN]\u000b\u0002yB\u0019QP`\u001a\u000e\u0003qI!a \u000f\u0003\u0011%#XM]1u_J\f\u0001bY1o\u000bF,\u0018\r\u001c\u000b\u0005\u0003\u000b\tY\u0001E\u0002%\u0003\u000fI1!!\u0003\u001f\u0005\u001d\u0011un\u001c7fC:Dq!\u001f\b\u0002\u0002\u0003\u00071'\u0001\u0005iCND7i\u001c3f)\u0005\u0019\u0018\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0003%\fa!Z9vC2\u001cH\u0003BA\u0003\u00033Aq!_\t\u0002\u0002\u0003\u00071\u0007K\u0004\u0001\u0003;\t\u0019#a\n\u0011\u0007\u0011\ny\"C\u0002\u0002\"y\u0011!\u0002Z3qe\u0016\u001c\u0017\r^3eC\t\t)#A\ftGJL\u0007\u000f^5oO\u0002J7\u000f\t3faJ,7-\u0019;fI\u0006\u0012\u0011\u0011F\u0001\u0007e9\n\u0014G\f\u0019\u0002\u000f%s7\r\\;eKB\u0011\u0001fE\n\u0004'\rJDCAA\u0017\u0003\u0015\t\u0007\u000f\u001d7z+\u0011\t9$!\u0010\u0015\r\u0005e\u0012qHA!!\u0011A\u0003!a\u000f\u0011\u00071\ni\u0004B\u0003/-\t\u0007q\u0006C\u0003=-\u0001\u0007a\b\u0003\u0004C-\u0001\u0007\u00111H\u0001\bk:\f\u0007\u000f\u001d7z+\u0011\t9%a\u0016\u0015\t\u0005%\u0013\u0011\f\t\u0006I\u0005-\u0013qJ\u0005\u0004\u0003\u001br\"AB(qi&|g\u000e\u0005\u0004%\u0003#r\u0014QK\u0005\u0004\u0003'r\"A\u0002+va2,'\u0007E\u0002-\u0003/\"QAL\fC\u0002=B\u0011\"a\u0017\u0018\u0003\u0003\u0005\r!!\u0018\u0002\u0007a$\u0003\u0007\u0005\u0003)\u0001\u0005U\u0013a\u0003:fC\u0012\u0014Vm]8mm\u0016$\"!a\u0019\u0011\u0007)\f)'C\u0002\u0002h-\u0014aa\u00142kK\u000e$\bfB\n\u0002\u001e\u0005\r\u0012q\u0005")
public class Include<A>
implements Message<A>,
Product,
Serializable {
    private final Location location;
    private final A elem;

    public static <A> Option<Tuple2<Location, A>> unapply(Include<A> include) {
        return Include$.MODULE$.unapply(include);
    }

    public static <A> Include<A> apply(Location location, A a) {
        return Include$.MODULE$.apply(location, a);
    }

    public Location location() {
        return this.location;
    }

    public A elem() {
        return this.elem;
    }

    public <A> Include<A> copy(Location location, A elem) {
        return new Include<A>(location, elem);
    }

    public <A> Location copy$default$1() {
        return this.location();
    }

    public <A> A copy$default$2() {
        return this.elem();
    }

    @Override
    public String productPrefix() {
        return "Include";
    }

    @Override
    public int productArity() {
        return 2;
    }

    @Override
    public Object productElement(int x$1) {
        switch (x$1) {
            case 0: {
                return this.location();
            }
            case 1: {
                return this.elem();
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
        return x$1 instanceof Include;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    public String toString() {
        return ScalaRunTime$.MODULE$._toString(this);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean equals(Object x$1) {
        if (this == x$1) return true;
        if (!(x$1 instanceof Include)) return false;
        boolean bl = true;
        if (!bl) return false;
        Include include = (Include)x$1;
        Location location = this.location();
        Location location2 = include.location();
        if (location == null) {
            if (location2 != null) {
                return false;
            }
        } else if (!location.equals(location2)) return false;
        if (!BoxesRunTime.equals(this.elem(), include.elem())) return false;
        if (!include.canEqual(this)) return false;
        return true;
    }

    public Include(Location location, A elem) {
        this.location = location;
        this.elem = elem;
        Product.$init$(this);
    }

    public Include(A elem) {
        this(NoLo$.MODULE$, elem);
    }
}

