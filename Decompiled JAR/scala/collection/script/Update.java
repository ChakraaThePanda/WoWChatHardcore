/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.script;

import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.script.Location;
import scala.collection.script.Message;
import scala.collection.script.NoLo$;
import scala.collection.script.Update$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005-d\u0001B\r\u001b\u0001\u0006B\u0001\u0002\u0010\u0001\u0003\u0016\u0004%\t!\u0010\u0005\t\u0003\u0002\u0011\t\u0012)A\u0005}!A!\t\u0001BK\u0002\u0013\u00051\t\u0003\u0005E\u0001\tE\t\u0015!\u0003,\u0011\u0015)\u0005\u0001\"\u0001G\u0011\u0015)\u0005\u0001\"\u0001K\u0011\u001da\u0005!!A\u0005\u00025Cq\u0001\u0016\u0001\u0012\u0002\u0013\u0005Q\u000bC\u0004c\u0001E\u0005I\u0011A2\t\u000f\u001d\u0004\u0011\u0011!C!Q\"9\u0011\u000fAA\u0001\n\u0003\u0011\bb\u0002<\u0001\u0003\u0003%\ta\u001e\u0005\bu\u0002\t\t\u0011\"\u0011|\u0011%\t\t\u0001AA\u0001\n\u0003\t\u0019\u0001C\u0005\u0002\u000e\u0001\t\t\u0011\"\u0011\u0002\u0010!I\u0011\u0011\u0003\u0001\u0002\u0002\u0013\u0005\u00131\u0003\u0005\n\u0003+\u0001\u0011\u0011!C!\u0003/9\u0011\"a\u000b\u001b\u0003\u0003E\t!!\f\u0007\u0011eQ\u0012\u0011!E\u0001\u0003_Aa!R\n\u0005\u0002\u0005E\u0002\"CA\t'\u0005\u0005IQIA\n\u0011%\t\u0019dEA\u0001\n\u0003\u000b)\u0004C\u0005\u0002DM\t\t\u0011\"!\u0002F!I\u0011qL\n\u0002\u0002\u0013%\u0011\u0011\r\u0002\u0007+B$\u0017\r^3\u000b\u0005ma\u0012AB:de&\u0004HO\u0003\u0002\u001e=\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003}\tQa]2bY\u0006\u001c\u0001!\u0006\u0002#[M)\u0001aI\u00147sA\u0011A%J\u0007\u0002=%\u0011aE\b\u0002\u0007\u0003:L(+\u001a4\u0011\u0007!J3&D\u0001\u001b\u0013\tQ#DA\u0004NKN\u001c\u0018mZ3\u0011\u00051jC\u0002\u0001\u0003\u0007]\u0001!)\u0019A\u0018\u0003\u0003\u0005\u000b\"\u0001M\u001a\u0011\u0005\u0011\n\u0014B\u0001\u001a\u001f\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"\u0001\n\u001b\n\u0005Ur\"aA!osB\u0011AeN\u0005\u0003qy\u0011q\u0001\u0015:pIV\u001cG\u000f\u0005\u0002%u%\u00111H\b\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\tY>\u001c\u0017\r^5p]V\ta\b\u0005\u0002)\u007f%\u0011\u0001I\u0007\u0002\t\u0019>\u001c\u0017\r^5p]\u0006IAn\\2bi&|g\u000eI\u0001\u0005K2,W.F\u0001,\u0003\u0015)G.Z7!\u0003\u0019a\u0014N\\5u}Q\u0019q\tS%\u0011\u0007!\u00021\u0006C\u0003=\u000b\u0001\u0007a\bC\u0003C\u000b\u0001\u00071\u0006\u0006\u0002H\u0017\")!I\u0002a\u0001W\u0005!1m\u001c9z+\tq\u0015\u000bF\u0002P%N\u00032\u0001\u000b\u0001Q!\ta\u0013\u000bB\u0003/\u000f\t\u0007q\u0006C\u0004=\u000fA\u0005\t\u0019\u0001 \t\u000f\t;\u0001\u0013!a\u0001!\u0006q1m\u001c9zI\u0011,g-Y;mi\u0012\nTC\u0001,b+\u00059&F\u0001 YW\u0005I\u0006C\u0001.`\u001b\u0005Y&B\u0001/^\u0003%)hn\u00195fG.,GM\u0003\u0002_=\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\u0005\u0001\\&!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\u0012)a\u0006\u0003b\u0001_\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012\u0012TC\u00013g+\u0005)'FA\u0016Y\t\u0015q\u0013B1\u00010\u00035\u0001(o\u001c3vGR\u0004&/\u001a4jqV\t\u0011\u000e\u0005\u0002k_6\t1N\u0003\u0002m[\u0006!A.\u00198h\u0015\u0005q\u0017\u0001\u00026bm\u0006L!\u0001]6\u0003\rM#(/\u001b8h\u00031\u0001(o\u001c3vGR\f%/\u001b;z+\u0005\u0019\bC\u0001\u0013u\u0013\t)hDA\u0002J]R\fa\u0002\u001d:pIV\u001cG/\u00127f[\u0016tG\u000f\u0006\u00024q\"9\u0011\u0010DA\u0001\u0002\u0004\u0019\u0018a\u0001=%c\u0005y\u0001O]8ek\u000e$\u0018\n^3sCR|'/F\u0001}!\rihpM\u0007\u00029%\u0011q\u0010\b\u0002\t\u0013R,'/\u0019;pe\u0006A1-\u00198FcV\fG\u000e\u0006\u0003\u0002\u0006\u0005-\u0001c\u0001\u0013\u0002\b%\u0019\u0011\u0011\u0002\u0010\u0003\u000f\t{w\u000e\\3b]\"9\u0011PDA\u0001\u0002\u0004\u0019\u0014\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0003M\f\u0001\u0002^8TiJLgn\u001a\u000b\u0002S\u00061Q-];bYN$B!!\u0002\u0002\u001a!9\u00110EA\u0001\u0002\u0004\u0019\u0004f\u0002\u0001\u0002\u001e\u0005\r\u0012q\u0005\t\u0004I\u0005}\u0011bAA\u0011=\tQA-\u001a9sK\u000e\fG/\u001a3\"\u0005\u0005\u0015\u0012aF:de&\u0004H/\u001b8hA%\u001c\b\u0005Z3qe\u0016\u001c\u0017\r^3eC\t\tI#\u0001\u00043]E\nd\u0006M\u0001\u0007+B$\u0017\r^3\u0011\u0005!\u001a2cA\n$sQ\u0011\u0011QF\u0001\u0006CB\u0004H._\u000b\u0005\u0003o\ti\u0004\u0006\u0004\u0002:\u0005}\u0012\u0011\t\t\u0005Q\u0001\tY\u0004E\u0002-\u0003{!QA\f\fC\u0002=BQ\u0001\u0010\fA\u0002yBaA\u0011\fA\u0002\u0005m\u0012aB;oCB\u0004H._\u000b\u0005\u0003\u000f\n9\u0006\u0006\u0003\u0002J\u0005e\u0003#\u0002\u0013\u0002L\u0005=\u0013bAA'=\t1q\n\u001d;j_:\u0004b\u0001JA)}\u0005U\u0013bAA*=\t1A+\u001e9mKJ\u00022\u0001LA,\t\u0015qsC1\u00010\u0011%\tYfFA\u0001\u0002\u0004\ti&A\u0002yIA\u0002B\u0001\u000b\u0001\u0002V\u0005Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\t\u0019\u0007E\u0002k\u0003KJ1!a\u001al\u0005\u0019y%M[3di\":1#!\b\u0002$\u0005\u001d\u0002")
public class Update<A>
implements Message<A>,
Product,
Serializable {
    private final Location location;
    private final A elem;

    public static <A> Option<Tuple2<Location, A>> unapply(Update<A> update) {
        return Update$.MODULE$.unapply(update);
    }

    public static <A> Update<A> apply(Location location, A a) {
        return Update$.MODULE$.apply(location, a);
    }

    public Location location() {
        return this.location;
    }

    public A elem() {
        return this.elem;
    }

    public <A> Update<A> copy(Location location, A elem) {
        return new Update<A>(location, elem);
    }

    public <A> Location copy$default$1() {
        return this.location();
    }

    public <A> A copy$default$2() {
        return this.elem();
    }

    @Override
    public String productPrefix() {
        return "Update";
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
        return x$1 instanceof Update;
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
        if (!(x$1 instanceof Update)) return false;
        boolean bl = true;
        if (!bl) return false;
        Update update = (Update)x$1;
        Location location = this.location();
        Location location2 = update.location();
        if (location == null) {
            if (location2 != null) {
                return false;
            }
        } else if (!location.equals(location2)) return false;
        if (!BoxesRunTime.equals(this.elem(), update.elem())) return false;
        if (!update.canEqual(this)) return false;
        return true;
    }

    public Update(Location location, A elem) {
        this.location = location;
        this.elem = elem;
        Product.$init$(this);
    }

    public Update(A elem) {
        this(NoLo$.MODULE$, elem);
    }
}

