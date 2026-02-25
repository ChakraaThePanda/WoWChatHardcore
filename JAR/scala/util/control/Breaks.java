/*
 * Decompiled with CFR 0.152.
 */
package scala.util.control;

import scala.Function0;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.Nothing$;
import scala.util.control.BreakControl;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@ScalaSignature(bytes="\u0006\u0001}3A\u0001D\u0007\u0001)!)\u0011\u0004\u0001C\u00015!9Q\u0004\u0001b\u0001\n\u0013q\u0002B\u0002\u0012\u0001A\u0003%q\u0004C\u0003$\u0001\u0011\u0005AEB\u0004.\u0001A\u0005\u0019\u0013\u0005\u0018\t\u000bA*a\u0011A\u0019\t\u000b9\u0003A\u0011A(\t\u000be\u0003A\u0011\u0001.\b\u000bmk\u0001\u0012\u0001/\u0007\u000b1i\u0001\u0012A/\t\u000beQA\u0011\u00010\u0003\r\t\u0013X-Y6t\u0015\tqq\"A\u0004d_:$(o\u001c7\u000b\u0005A\t\u0012\u0001B;uS2T\u0011AE\u0001\u0006g\u000e\fG.Y\u0002\u0001'\t\u0001Q\u0003\u0005\u0002\u0017/5\t\u0011#\u0003\u0002\u0019#\t1\u0011I\\=SK\u001a\fa\u0001P5oSRtD#A\u000e\u0011\u0005q\u0001Q\"A\u0007\u0002\u001d\t\u0014X-Y6Fq\u000e,\u0007\u000f^5p]V\tq\u0004\u0005\u0002\u001dA%\u0011\u0011%\u0004\u0002\r\u0005J,\u0017m[\"p]R\u0014x\u000e\\\u0001\u0010EJ,\u0017m[#yG\u0016\u0004H/[8oA\u0005I!M]3bW\u0006\u0014G.\u001a\u000b\u0003K!\u0002\"A\u0006\u0014\n\u0005\u001d\n\"\u0001B+oSRDa!\u000b\u0003\u0005\u0002\u0004Q\u0013AA8q!\r12&J\u0005\u0003YE\u0011\u0001\u0002\u00102z]\u0006lWM\u0010\u0002\t)JL(\t\\8dWV\u0011q\u0006N\n\u0003\u000bU\t!bY1uG\"\u0014%/Z1l)\t\u0011T\b\u0005\u00024i1\u0001A!B\u001b\u0006\u0005\u00041$!\u0001+\u0012\u0005]R\u0004C\u0001\f9\u0013\tI\u0014CA\u0004O_RD\u0017N\\4\u0011\u0005YY\u0014B\u0001\u001f\u0012\u0005\r\te.\u001f\u0005\u0007}\u0019!\t\u0019A \u0002\u000f=t'I]3bWB\u0019ac\u000b\u001a*\u0005\u0015\te\u0001\u0002\"\u0006\u0001\r\u0013Q\u0002\u00107pG\u0006d\u0007e\u00195jY\u0012t4cA!E\u0019B\u0011QIS\u0007\u0002\r*\u0011q\tS\u0001\u0005Y\u0006twMC\u0001J\u0003\u0011Q\u0017M^1\n\u0005-3%AB(cU\u0016\u001cG\u000fE\u0002N\u000bIj\u0011\u0001A\u0001\riJL(I]3bW\u0006\u0014G.Z\u000b\u0003!Z#\"!U,\u0013\u0007I+BK\u0002\u0003T\u000f\u0001\t&\u0001\u0004\u001fsK\u001aLg.Z7f]Rt\u0004cA'\u0006+B\u00111G\u0016\u0003\u0006k\u001d\u0011\rA\u000e\u0005\u0007S\u001d!\t\u0019\u0001-\u0011\u0007YYS+A\u0003ce\u0016\f7\u000eF\u00018\u0003\u0019\u0011%/Z1lgB\u0011ADC\n\u0003\u0015m!\u0012\u0001\u0018")
public class Breaks {
    private final BreakControl scala$util$control$Breaks$$breakException = new BreakControl();

    public BreakControl scala$util$control$Breaks$$breakException() {
        return this.scala$util$control$Breaks$$breakException;
    }

    public void breakable(Function0<BoxedUnit> op) {
        try {
            op.apply$mcV$sp();
            return;
        }
        catch (BreakControl ex) {
            if (ex != this.scala$util$control$Breaks$$breakException()) {
                throw ex;
            }
            return;
        }
    }

    public <T> TryBlock<T> tryBreakable(Function0<T> op) {
        return new TryBlock<T>(this, op){
            private final /* synthetic */ Breaks $outer;
            private final Function0 op$1;

            public T catchBreak(Function0<T> onBreak) {
                try {
                    return (T)this.op$1.apply();
                }
                catch (BreakControl ex) {
                    if (ex != this.$outer.scala$util$control$Breaks$$breakException()) {
                        throw ex;
                    }
                    return onBreak.apply();
                }
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.op$1 = op$1;
            }
        };
    }

    public Nothing$ break() {
        throw this.scala$util$control$Breaks$$breakException();
    }

    public interface TryBlock<T> {
        public T catchBreak(Function0<T> var1);
    }
}

