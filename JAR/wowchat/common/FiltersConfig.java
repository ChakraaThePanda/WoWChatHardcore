/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import scala.runtime.Statics;
import wowchat.common.FiltersConfig$;

@ScalaSignature(bytes="\u0006\u0001\u0005-c\u0001\u0002\r\u001a\u0001zA\u0001b\u000b\u0001\u0003\u0016\u0004%\t\u0001\f\u0005\ta\u0001\u0011\t\u0012)A\u0005[!A\u0011\u0007\u0001BK\u0002\u0013\u0005!\u0007\u0003\u0005H\u0001\tE\t\u0015!\u00034\u0011\u0015A\u0005\u0001\"\u0001J\u0011\u001dq\u0005!!A\u0005\u0002=CqA\u0015\u0001\u0012\u0002\u0013\u00051\u000bC\u0004_\u0001E\u0005I\u0011A0\t\u000f\u0005\u0004\u0011\u0011!C!E\"9!\u000eAA\u0001\n\u0003Y\u0007bB8\u0001\u0003\u0003%\t\u0001\u001d\u0005\bm\u0002\t\t\u0011\"\u0011x\u0011\u001dq\b!!A\u0005\u0002}D\u0011\"a\u0001\u0001\u0003\u0003%\t%!\u0002\t\u0013\u0005\u001d\u0001!!A\u0005B\u0005%\u0001\"CA\u0006\u0001\u0005\u0005I\u0011IA\u0007\u000f%\t\t\"GA\u0001\u0012\u0003\t\u0019B\u0002\u0005\u00193\u0005\u0005\t\u0012AA\u000b\u0011\u0019A%\u0003\"\u0001\u0002$!I\u0011q\u0001\n\u0002\u0002\u0013\u0015\u0013\u0011\u0002\u0005\n\u0003K\u0011\u0012\u0011!CA\u0003OA\u0011\"!\f\u0013\u0003\u0003%\t)a\f\t\u0013\u0005\u0005##!A\u0005\n\u0005\r#!\u0004$jYR,'o]\"p]\u001aLwM\u0003\u0002\u001b7\u000511m\\7n_:T\u0011\u0001H\u0001\bo><8\r[1u\u0007\u0001\u0019B\u0001A\u0010&QA\u0011\u0001eI\u0007\u0002C)\t!%A\u0003tG\u0006d\u0017-\u0003\u0002%C\t1\u0011I\\=SK\u001a\u0004\"\u0001\t\u0014\n\u0005\u001d\n#a\u0002)s_\u0012,8\r\u001e\t\u0003A%J!AK\u0011\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\u000f\u0015t\u0017M\u00197fIV\tQ\u0006\u0005\u0002!]%\u0011q&\t\u0002\b\u0005>|G.Z1o\u0003!)g.\u00192mK\u0012\u0004\u0013\u0001\u00039biR,'O\\:\u0016\u0003M\u00022\u0001\u000e\u001f@\u001d\t)$H\u0004\u00027s5\tqG\u0003\u00029;\u00051AH]8pizJ\u0011AI\u0005\u0003w\u0005\nq\u0001]1dW\u0006<W-\u0003\u0002>}\t\u00191+Z9\u000b\u0005m\n\u0003C\u0001!E\u001d\t\t%\t\u0005\u00027C%\u00111)I\u0001\u0007!J,G-\u001a4\n\u0005\u00153%AB*ue&twM\u0003\u0002DC\u0005I\u0001/\u0019;uKJt7\u000fI\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0007)cU\n\u0005\u0002L\u00015\t\u0011\u0004C\u0003,\u000b\u0001\u0007Q\u0006C\u00032\u000b\u0001\u00071'\u0001\u0003d_BLHc\u0001&Q#\"91F\u0002I\u0001\u0002\u0004i\u0003bB\u0019\u0007!\u0003\u0005\raM\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00132+\u0005!&FA\u0017VW\u00051\u0006CA,]\u001b\u0005A&BA-[\u0003%)hn\u00195fG.,GM\u0003\u0002\\C\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\u0005uC&!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\u0006q1m\u001c9zI\u0011,g-Y;mi\u0012\u0012T#\u00011+\u0005M*\u0016!\u00049s_\u0012,8\r\u001e)sK\u001aL\u00070F\u0001d!\t!\u0017.D\u0001f\u0015\t1w-\u0001\u0003mC:<'\"\u00015\u0002\t)\fg/Y\u0005\u0003\u000b\u0016\fA\u0002\u001d:pIV\u001cG/\u0011:jif,\u0012\u0001\u001c\t\u0003A5L!A\\\u0011\u0003\u0007%sG/\u0001\bqe>$Wo\u0019;FY\u0016lWM\u001c;\u0015\u0005E$\bC\u0001\u0011s\u0013\t\u0019\u0018EA\u0002B]fDq!^\u0006\u0002\u0002\u0003\u0007A.A\u0002yIE\nq\u0002\u001d:pIV\u001cG/\u0013;fe\u0006$xN]\u000b\u0002qB\u0019\u0011\u0010`9\u000e\u0003iT!a_\u0011\u0002\u0015\r|G\u000e\\3di&|g.\u0003\u0002~u\nA\u0011\n^3sCR|'/\u0001\u0005dC:,\u0015/^1m)\ri\u0013\u0011\u0001\u0005\bk6\t\t\u00111\u0001r\u0003!A\u0017m\u001d5D_\u0012,G#\u00017\u0002\u0011Q|7\u000b\u001e:j]\u001e$\u0012aY\u0001\u0007KF,\u0018\r\\:\u0015\u00075\ny\u0001C\u0004v!\u0005\u0005\t\u0019A9\u0002\u001b\u0019KG\u000e^3sg\u000e{gNZ5h!\tY%c\u0005\u0003\u0013\u0003/A\u0003cBA\r\u0003?i3GS\u0007\u0003\u00037Q1!!\b\"\u0003\u001d\u0011XO\u001c;j[\u0016LA!!\t\u0002\u001c\t\t\u0012IY:ue\u0006\u001cGOR;oGRLwN\u001c\u001a\u0015\u0005\u0005M\u0011!B1qa2LH#\u0002&\u0002*\u0005-\u0002\"B\u0016\u0016\u0001\u0004i\u0003\"B\u0019\u0016\u0001\u0004\u0019\u0014aB;oCB\u0004H.\u001f\u000b\u0005\u0003c\ti\u0004E\u0003!\u0003g\t9$C\u0002\u00026\u0005\u0012aa\u00149uS>t\u0007#\u0002\u0011\u0002:5\u001a\u0014bAA\u001eC\t1A+\u001e9mKJB\u0001\"a\u0010\u0017\u0003\u0003\u0005\rAS\u0001\u0004q\u0012\u0002\u0014a\u0003:fC\u0012\u0014Vm]8mm\u0016$\"!!\u0012\u0011\u0007\u0011\f9%C\u0002\u0002J\u0015\u0014aa\u00142kK\u000e$\b")
public class FiltersConfig
implements Product,
Serializable {
    private final boolean enabled;
    private final Seq<String> patterns;

    public static Option<Tuple2<Object, Seq<String>>> unapply(FiltersConfig filtersConfig) {
        return FiltersConfig$.MODULE$.unapply(filtersConfig);
    }

    public static FiltersConfig apply(boolean bl, Seq<String> seq) {
        return FiltersConfig$.MODULE$.apply(bl, seq);
    }

    public static Function1<Tuple2<Object, Seq<String>>, FiltersConfig> tupled() {
        return FiltersConfig$.MODULE$.tupled();
    }

    public static Function1<Object, Function1<Seq<String>, FiltersConfig>> curried() {
        return FiltersConfig$.MODULE$.curried();
    }

    public boolean enabled() {
        return this.enabled;
    }

    public Seq<String> patterns() {
        return this.patterns;
    }

    public FiltersConfig copy(boolean enabled, Seq<String> patterns) {
        return new FiltersConfig(enabled, patterns);
    }

    public boolean copy$default$1() {
        return this.enabled();
    }

    public Seq<String> copy$default$2() {
        return this.patterns();
    }

    @Override
    public String productPrefix() {
        return "FiltersConfig";
    }

    @Override
    public int productArity() {
        return 2;
    }

    @Override
    public Object productElement(int x$1) {
        Object object;
        int n = x$1;
        switch (n) {
            case 0: {
                object = BoxesRunTime.boxToBoolean(this.enabled());
                break;
            }
            case 1: {
                object = this.patterns();
                break;
            }
            default: {
                throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
            }
        }
        return object;
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof FiltersConfig;
    }

    public int hashCode() {
        int n = -889275714;
        n = Statics.mix(n, this.enabled() ? 1231 : 1237);
        n = Statics.mix(n, Statics.anyHash(this.patterns()));
        return Statics.finalizeHash(n, 2);
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
        Object object = x$1;
        if (!(object instanceof FiltersConfig)) return false;
        boolean bl = true;
        if (!bl) return false;
        FiltersConfig filtersConfig = (FiltersConfig)x$1;
        if (this.enabled() != filtersConfig.enabled()) return false;
        Seq<String> seq = this.patterns();
        Seq<String> seq2 = filtersConfig.patterns();
        if (seq == null) {
            if (seq2 != null) {
                return false;
            }
        } else if (!seq.equals(seq2)) return false;
        if (!filtersConfig.canEqual(this)) return false;
        return true;
    }

    public FiltersConfig(boolean enabled, Seq<String> patterns) {
        this.enabled = enabled;
        this.patterns = patterns;
        Product.$init$(this);
    }
}

