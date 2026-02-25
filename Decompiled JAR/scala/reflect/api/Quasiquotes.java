/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.api;

import scala.StringContext;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Quasiquotes$Quasiquote$cq$;
import scala.reflect.api.Quasiquotes$Quasiquote$fq$;
import scala.reflect.api.Quasiquotes$Quasiquote$pq$;
import scala.reflect.api.Quasiquotes$Quasiquote$q$;
import scala.reflect.api.Quasiquotes$Quasiquote$tq$;
import scala.reflect.api.Universe;

@ScalaSignature(bytes="\u0006\u0001M4\u0001\"\u0007\u000e\u0011\u0002\u0007\u0005\u0011e\u001c\u0005\u0006M\u0001!\ta\n\u0004\u0005W\u0001\tA\u0006\u0003\u0005.\u0005\t\u0005\t\u0015!\u0003/\u0011\u0015\t$\u0001\"\u00013\r\u001d1$\u0001%A\u0002\u0012]BQAJ\u0003\u0005\u0002\u001dBa\u0001O\u0003\u0003\n\u0003I\u0004BB'\u0006\u0005\u0013\u0005ajB\u0003R\u0005!\u0005!KB\u0003U\u0005!\u0005Q\u000bC\u00032\u0015\u0011\u0005qkB\u0003Y\u0005!\u0005\u0011LB\u0003[\u0005!\u00051\fC\u00032\u001b\u0011\u0005AlB\u0003^\u0005!\u0005aLB\u0003`\u0005!\u0005\u0001\rC\u00032!\u0011\u0005\u0011mB\u0003c\u0005!\u00051MB\u0003e\u0005!\u0005Q\rC\u00032'\u0011\u0005amB\u0003h\u0005!\u0005\u0001NB\u0003j\u0005!\u0005!\u000eC\u00032-\u0011\u00051\u000eC\u0004m\u0001\u0005\u0005I1A7\u0003\u0017E+\u0018m]5rk>$Xm\u001d\u0006\u00037q\t1!\u00199j\u0015\tib$A\u0004sK\u001adWm\u0019;\u000b\u0003}\tQa]2bY\u0006\u001c\u0001a\u0005\u0002\u0001EA\u00111\u0005J\u0007\u0002=%\u0011QE\b\u0002\u0007\u0003:L(+\u001a4\u0002\r\u0011Jg.\u001b;%)\u0005A\u0003CA\u0012*\u0013\tQcD\u0001\u0003V]&$(AC)vCNL\u0017/^8uKN\u0011!AI\u0001\u0004GRD\bCA\u00120\u0013\t\u0001dDA\u0007TiJLgnZ\"p]R,\u0007\u0010^\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005M*\u0004C\u0001\u001b\u0003\u001b\u0005\u0001\u0001\"B\u0017\u0005\u0001\u0004q#aA1qSN\u0011QAI\u0001\u0006CB\u0004H._\u000b\u0003u\u001d#\"a\u000f!\u0011\u0005Qb\u0014BA\u001f?\u0005\u0011!&/Z3\n\u0005}R\"!\u0002+sK\u0016\u001c\b\"B!\b\u0001\u0004\u0011\u0015\u0001B1sON\u00042aI\"F\u0013\t!eD\u0001\u0006=e\u0016\u0004X-\u0019;fIz\u0002\"AR$\r\u0001\u0011)\u0001j\u0002b\u0001\u0013\n\t\u0011)\u0005\u0002K\u0015B\u00111eS\u0005\u0003\u0019z\u00111!\u00118z\u0003\u001d)h.\u00199qYf$\"AS(\t\u000bAC\u0001\u0019\u0001&\u0002\u0013M\u001c'/\u001e;j]\u0016,\u0017!A9\u0011\u0005MSQ\"\u0001\u0002\u0003\u0003E\u001c2A\u0003\u0012W!\t\u0019V\u0001F\u0001S\u0003\t!\u0018\u000f\u0005\u0002T\u001b\t\u0011A/]\n\u0004\u001b\t2F#A-\u0002\u0005\r\f\bCA*\u0011\u0005\t\u0019\u0017oE\u0002\u0011EY#\u0012AX\u0001\u0003aF\u0004\"aU\n\u0003\u0005A\f8cA\n#-R\t1-\u0001\u0002gcB\u00111K\u0006\u0002\u0003MF\u001c2A\u0006\u0012W)\u0005A\u0017AC)vCNL\u0017/^8uKR\u00111G\u001c\u0005\u0006[a\u0001\rA\f\t\u0003aFl\u0011AG\u0005\u0003ej\u0011\u0001\"\u00168jm\u0016\u00148/\u001a")
public interface Quasiquotes {
    public static /* synthetic */ Quasiquote Quasiquote$(Quasiquotes $this, StringContext ctx) {
        return $this.Quasiquote(ctx);
    }

    default public Quasiquote Quasiquote(StringContext ctx) {
        return new Quasiquote((Universe)this, ctx);
    }

    public static void $init$(Quasiquotes $this) {
    }

    public static class Quasiquote {
        private volatile Quasiquotes$Quasiquote$q$ q$module;
        private volatile Quasiquotes$Quasiquote$tq$ tq$module;
        private volatile Quasiquotes$Quasiquote$cq$ cq$module;
        private volatile Quasiquotes$Quasiquote$pq$ pq$module;
        private volatile Quasiquotes$Quasiquote$fq$ fq$module;
        public final /* synthetic */ Universe $outer;

        public Quasiquotes$Quasiquote$q$ q() {
            if (this.q$module == null) {
                this.q$lzycompute$1();
            }
            return this.q$module;
        }

        public Quasiquotes$Quasiquote$tq$ tq() {
            if (this.tq$module == null) {
                this.tq$lzycompute$1();
            }
            return this.tq$module;
        }

        public Quasiquotes$Quasiquote$cq$ cq() {
            if (this.cq$module == null) {
                this.cq$lzycompute$1();
            }
            return this.cq$module;
        }

        public Quasiquotes$Quasiquote$pq$ pq() {
            if (this.pq$module == null) {
                this.pq$lzycompute$1();
            }
            return this.pq$module;
        }

        public Quasiquotes$Quasiquote$fq$ fq() {
            if (this.fq$module == null) {
                this.fq$lzycompute$1();
            }
            return this.fq$module;
        }

        public /* synthetic */ Universe scala$reflect$api$Quasiquotes$Quasiquote$$$outer() {
            return this.$outer;
        }

        private final void q$lzycompute$1() {
            synchronized (this) {
                if (this.q$module == null) {
                    this.q$module = new Quasiquotes$Quasiquote$q$(this);
                }
                return;
            }
        }

        private final void tq$lzycompute$1() {
            synchronized (this) {
                if (this.tq$module == null) {
                    this.tq$module = new Quasiquotes$Quasiquote$tq$(this);
                }
                return;
            }
        }

        private final void cq$lzycompute$1() {
            synchronized (this) {
                if (this.cq$module == null) {
                    this.cq$module = new Quasiquotes$Quasiquote$cq$(this);
                }
                return;
            }
        }

        private final void pq$lzycompute$1() {
            synchronized (this) {
                if (this.pq$module == null) {
                    this.pq$module = new Quasiquotes$Quasiquote$pq$(this);
                }
                return;
            }
        }

        private final void fq$lzycompute$1() {
            synchronized (this) {
                if (this.fq$module == null) {
                    this.fq$module = new Quasiquotes$Quasiquote$fq$(this);
                }
                return;
            }
        }

        public Quasiquote(Universe $outer, StringContext ctx) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }

        public interface api {
            public /* synthetic */ Quasiquote scala$reflect$api$Quasiquotes$Quasiquote$api$$$outer();

            public static void $init$(api $this) {
            }
        }
    }
}

