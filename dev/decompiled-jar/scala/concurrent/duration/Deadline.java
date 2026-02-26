/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent.duration;

import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.collection.Iterator;
import scala.concurrent.duration.Deadline$;
import scala.concurrent.duration.FiniteDuration;
import scala.math.Ordered;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005Ed\u0001B\u0011#\u0001&B\u0001B\u0011\u0001\u0003\u0016\u0004%\ta\u0011\u0005\t\u000f\u0002\u0011\t\u0012)A\u0005\t\")\u0001\n\u0001C\u0005\u0013\")1\n\u0001C\u0001\u0019\")q\n\u0001C\u0001!\")q\n\u0001C\u0001%\")A\u000b\u0001C\u0001\u0007\")Q\u000b\u0001C\u0001-\")!\f\u0001C\u0001-\")1\f\u0001C\u00019\"9\u0011\rAA\u0001\n\u0003\u0011\u0007b\u00023\u0001#\u0003%\t!\u001a\u0005\ba\u0002\t\t\u0011\"\u0011r\u0011\u001dQ\b!!A\u0005\u0002mDq\u0001 \u0001\u0002\u0002\u0013\u0005Q\u0010C\u0005\u0002\b\u0001\t\t\u0011\"\u0011\u0002\n!I\u0011q\u0003\u0001\u0002\u0002\u0013\u0005\u0011\u0011\u0004\u0005\n\u0003;\u0001\u0011\u0011!C!\u0003?A\u0011\"!\t\u0001\u0003\u0003%\t%a\t\t\u0013\u0005\u0015\u0002!!A\u0005B\u0005\u001draBA\u0016E!\u0005\u0011Q\u0006\u0004\u0007C\tB\t!a\f\t\r!3B\u0011AA\u0019\u0011\u001d\t\u0019D\u0006C\u0001\u0003k9q!a\u000e\u0017\u0011\u0007\tIDB\u0004\u0002>YA\t!a\u0010\t\r!SB\u0011AA'\u0011\u0019Y&\u0004\"\u0001\u0002P!I\u0011\u0011\f\u000e\u0002\u0002\u0013%\u00111\f\u0005\n\u0003;2\u0012\u0011!CA\u0003?B\u0011\"a\u0019\u0017\u0003\u0003%\t)!\u001a\t\u0013\u0005ec#!A\u0005\n\u0005m#\u0001\u0003#fC\u0012d\u0017N\\3\u000b\u0005\r\"\u0013\u0001\u00033ve\u0006$\u0018n\u001c8\u000b\u0005\u00152\u0013AC2p]\u000e,(O]3oi*\tq%A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u000b\u0001Qc\u0006P \u0011\u0005-bS\"\u0001\u0014\n\u000552#AB!osJ+g\rE\u00020oir!\u0001M\u001b\u000f\u0005E\"T\"\u0001\u001a\u000b\u0005MB\u0013A\u0002\u001fs_>$h(C\u0001(\u0013\t1d%A\u0004qC\u000e\\\u0017mZ3\n\u0005aJ$aB(sI\u0016\u0014X\r\u001a\u0006\u0003m\u0019\u0002\"a\u000f\u0001\u000e\u0003\t\u0002\"aK\u001f\n\u0005y2#a\u0002)s_\u0012,8\r\u001e\t\u0003W\u0001K!!\u0011\u0014\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\tQLW.Z\u000b\u0002\tB\u00111(R\u0005\u0003\r\n\u0012aBR5oSR,G)\u001e:bi&|g.A\u0003uS6,\u0007%\u0001\u0004=S:LGO\u0010\u000b\u0003u)CQAQ\u0002A\u0002\u0011\u000bQ\u0001\n9mkN$\"AO'\t\u000b9#\u0001\u0019\u0001#\u0002\u000b=$\b.\u001a:\u0002\r\u0011j\u0017N\\;t)\tQ\u0014\u000bC\u0003O\u000b\u0001\u0007A\t\u0006\u0002E'\")aJ\u0002a\u0001u\u0005AA/[7f\u0019\u00164G/A\u0006iCN$\u0016.\\3MK\u001a$H#A,\u0011\u0005-B\u0016BA-'\u0005\u001d\u0011un\u001c7fC:\f\u0011\"[:Pm\u0016\u0014H-^3\u0002\u000f\r|W\u000e]1sKR\u0011Q\f\u0019\t\u0003WyK!a\u0018\u0014\u0003\u0007%sG\u000fC\u0003O\u0015\u0001\u0007!(\u0001\u0003d_BLHC\u0001\u001ed\u0011\u001d\u00115\u0002%AA\u0002\u0011\u000babY8qs\u0012\"WMZ1vYR$\u0013'F\u0001gU\t!umK\u0001i!\tIg.D\u0001k\u0015\tYG.A\u0005v]\u000eDWmY6fI*\u0011QNJ\u0001\u000bC:tw\u000e^1uS>t\u0017BA8k\u0005E)hn\u00195fG.,GMV1sS\u0006t7-Z\u0001\u000eaJ|G-^2u!J,g-\u001b=\u0016\u0003I\u0004\"a\u001d=\u000e\u0003QT!!\u001e<\u0002\t1\fgn\u001a\u0006\u0002o\u0006!!.\u0019<b\u0013\tIHO\u0001\u0004TiJLgnZ\u0001\raJ|G-^2u\u0003JLG/_\u000b\u0002;\u0006q\u0001O]8ek\u000e$X\t\\3nK:$Hc\u0001@\u0002\u0004A\u00111f`\u0005\u0004\u0003\u00031#aA!os\"A\u0011QA\b\u0002\u0002\u0003\u0007Q,A\u0002yIE\nq\u0002\u001d:pIV\u001cG/\u0013;fe\u0006$xN]\u000b\u0003\u0003\u0017\u0001R!!\u0004\u0002\u0014yl!!a\u0004\u000b\u0007\u0005Ea%\u0001\u0006d_2dWm\u0019;j_:LA!!\u0006\u0002\u0010\tA\u0011\n^3sCR|'/\u0001\u0005dC:,\u0015/^1m)\r9\u00161\u0004\u0005\t\u0003\u000b\t\u0012\u0011!a\u0001}\u0006A\u0001.Y:i\u0007>$W\rF\u0001^\u0003!!xn\u0015;sS:<G#\u0001:\u0002\r\u0015\fX/\u00197t)\r9\u0016\u0011\u0006\u0005\t\u0003\u000b!\u0012\u0011!a\u0001}\u0006AA)Z1eY&tW\r\u0005\u0002<-M\u0019aCK \u0015\u0005\u00055\u0012a\u00018poV\t!(A\tEK\u0006$G.\u001b8f\u0013N|%\u000fZ3sK\u0012\u00042!a\u000f\u001b\u001b\u00051\"!\u0005#fC\u0012d\u0017N\\3Jg>\u0013H-\u001a:fIN)!$!\u0011\u0002HA\u00191/a\u0011\n\u0007\u0005\u0015CO\u0001\u0004PE*,7\r\u001e\t\u0005_\u0005%#(C\u0002\u0002Le\u0012\u0001b\u0014:eKJLgn\u001a\u000b\u0003\u0003s!R!XA)\u0003+Ba!a\u0015\u001d\u0001\u0004Q\u0014!A1\t\r\u0005]C\u00041\u0001;\u0003\u0005\u0011\u0017a\u0003:fC\u0012\u0014Vm]8mm\u0016$\"!!\u0011\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\u0007i\n\t\u0007C\u0003C=\u0001\u0007A)A\u0004v]\u0006\u0004\b\u000f\\=\u0015\t\u0005\u001d\u0014Q\u000e\t\u0005W\u0005%D)C\u0002\u0002l\u0019\u0012aa\u00149uS>t\u0007\u0002CA8?\u0005\u0005\t\u0019\u0001\u001e\u0002\u0007a$\u0003\u0007")
public class Deadline
implements Ordered<Deadline>,
Product,
Serializable {
    private final FiniteDuration time;

    public static Option<FiniteDuration> unapply(Deadline deadline) {
        return Deadline$.MODULE$.unapply(deadline);
    }

    public static Deadline apply(FiniteDuration finiteDuration) {
        return Deadline$.MODULE$.apply(finiteDuration);
    }

    public static Deadline now() {
        return Deadline$.MODULE$.now();
    }

    @Override
    public boolean $less(Object that) {
        return Ordered.$less$(this, that);
    }

    @Override
    public boolean $greater(Object that) {
        return Ordered.$greater$(this, that);
    }

    @Override
    public boolean $less$eq(Object that) {
        return Ordered.$less$eq$(this, that);
    }

    @Override
    public boolean $greater$eq(Object that) {
        return Ordered.$greater$eq$(this, that);
    }

    @Override
    public int compareTo(Object that) {
        return Ordered.compareTo$(this, that);
    }

    public FiniteDuration time() {
        return this.time;
    }

    public Deadline $plus(FiniteDuration other) {
        return this.copy(this.time().$plus(other));
    }

    public Deadline $minus(FiniteDuration other) {
        return this.copy(this.time().$minus(other));
    }

    public FiniteDuration $minus(Deadline other) {
        return this.time().$minus(other.time());
    }

    public FiniteDuration timeLeft() {
        return this.$minus(Deadline$.MODULE$.now());
    }

    public boolean hasTimeLeft() {
        return !this.isOverdue();
    }

    public boolean isOverdue() {
        return this.time().toNanos() - System.nanoTime() < 0L;
    }

    @Override
    public int compare(Deadline other) {
        return this.time().compare(other.time());
    }

    public Deadline copy(FiniteDuration time) {
        return new Deadline(time);
    }

    public FiniteDuration copy$default$1() {
        return this.time();
    }

    @Override
    public String productPrefix() {
        return "Deadline";
    }

    @Override
    public int productArity() {
        return 1;
    }

    @Override
    public Object productElement(int x$1) {
        switch (x$1) {
            case 0: {
                return this.time();
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
        return x$1 instanceof Deadline;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    public String toString() {
        return ScalaRunTime$.MODULE$._toString(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof Deadline;
                if (!bl) break block3;
                Deadline deadline = (Deadline)x$1;
                FiniteDuration finiteDuration = this.time();
                FiniteDuration finiteDuration2 = deadline.time();
                if (!(!(finiteDuration != null ? !((Object)finiteDuration).equals(finiteDuration2) : finiteDuration2 != null) && deadline.canEqual(this))) break block3;
            }
            return true;
        }
        return false;
    }

    public Deadline(FiniteDuration time) {
        this.time = time;
        Ordered.$init$(this);
        Product.$init$(this);
    }
}

