/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Function0;
import scala.Predef$;
import scala.Serializable;
import scala.collection.immutable.StringOps;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.NoPhase$;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Types;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001e3\u0001b\u0004\t\u0011\u0002\u0007\u0005q#\u0016\u0005\u00069\u0001!\t!\b\u0004\u0006C\u0001\t\tA\t\u0005\u0006G\t!\t\u0001\n\u0005\bO\t\u0001\r\u0011\"\u0001)\u0011\u001dI#\u00011A\u0005\u0002)Ba!\f\u0002!B\u0013)\u0003b\u0002\u0018\u0003\u0001\u0004%\t\u0001\u000b\u0005\b_\t\u0001\r\u0011\"\u00011\u0011\u0019\u0011$\u0001)Q\u0005K!91G\u0001b\u0001\u000e\u0003!\u0004b\u0002\u001d\u0003\u0005\u00045\t!\u000f\u0005\u0006{\t1\tA\u0010\u0005\u0006\u001b\n!\tA\u0014\u0005\u0006#\n!\tA\u0015\u0002\u0011\u0013:4w\u000e\u0016:b]N4wN]7feNT!!\u0005\n\u0002\u0011%tG/\u001a:oC2T!a\u0005\u000b\u0002\u000fI,g\r\\3di*\tQ#A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0005\u0001A\u0002CA\r\u001b\u001b\u0005!\u0012BA\u000e\u0015\u0005\u0019\te.\u001f*fM\u00061A%\u001b8ji\u0012\"\u0012A\b\t\u00033}I!\u0001\t\u000b\u0003\tUs\u0017\u000e\u001e\u0002\u0010\u0013:4w\u000e\u0016:b]N4wN]7feN\u0011!\u0001G\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003\u0015\u0002\"A\n\u0002\u000e\u0003\u0001\tA\u0001\u001d:fmV\tQ%\u0001\u0005qe\u00164x\fJ3r)\tq2\u0006C\u0004-\u000b\u0005\u0005\t\u0019A\u0013\u0002\u0007a$\u0013'A\u0003qe\u00164\b%\u0001\u0003oKb$\u0018\u0001\u00038fqR|F%Z9\u0015\u0005y\t\u0004b\u0002\u0017\t\u0003\u0003\u0005\r!J\u0001\u0006]\u0016DH\u000fI\u0001\u0004a&$W#A\u001b\u0011\u0005e1\u0014BA\u001c\u0015\u0005\rIe\u000e^\u0001\u0013G\"\fgnZ3t\u0005\u0006\u001cXm\u00117bgN,7/F\u0001;!\tI2(\u0003\u0002=)\t9!i\\8mK\u0006t\u0017!\u0003;sC:\u001chm\u001c:n)\ryDi\u0013\t\u0003M\u0001K!!\u0011\"\u0003\tQK\b/Z\u0005\u0003\u0007B\u0011Q\u0001V=qKNDQ!\u0012\u0007A\u0002\u0019\u000b1a]=n!\t1s)\u0003\u0002I\u0013\n11+_7c_2L!A\u0013\t\u0003\u000fMKXNY8mg\")A\n\u0004a\u0001\u007f\u0005\u0019A\u000f]3\u0002\r%t7/\u001a:u)\tqr\nC\u0003Q\u001b\u0001\u0007Q%\u0001\u0003uQ\u0006$\u0018\u0001\u00038fqR4%o\\7\u0015\u0005\u0015\u001a\u0006\"\u0002+\u000f\u0001\u0004)\u0014\u0001\u00024s_6\u0004\"AV,\u000e\u0003AI!\u0001\u0017\t\u0003\u0017MKXNY8m)\u0006\u0014G.\u001a")
public interface InfoTransformers {
    public static void $init$(InfoTransformers $this) {
    }

    public static abstract class InfoTransformer {
        private InfoTransformer prev;
        private InfoTransformer next;
        public final /* synthetic */ SymbolTable $outer;

        public InfoTransformer prev() {
            return this.prev;
        }

        public void prev_$eq(InfoTransformer x$1) {
            this.prev = x$1;
        }

        public InfoTransformer next() {
            return this.next;
        }

        public void next_$eq(InfoTransformer x$1) {
            this.next = x$1;
        }

        public abstract int pid();

        public abstract boolean changesBaseClasses();

        public abstract Types.Type transform(Symbols.Symbol var1, Types.Type var2);

        /*
         * WARNING - void declaration
         */
        public void insert(InfoTransformer that) {
            void assert_assertion;
            boolean bl;
            SymbolTable symbolTable = this.scala$reflect$internal$InfoTransformers$InfoTransformer$$$outer();
            boolean bl2 = bl = this.pid() != that.pid();
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable assert_this = symbolTable;
            if (assert_assertion == false) {
                throw assert_this.throwAssertionError(BoxesRunTime.boxToInteger(this.pid()));
            }
            if (that.pid() < this.pid()) {
                this.prev().insert(that);
                return;
            }
            if (this.next().pid() <= that.pid() && this.next().pid() != NoPhase$.MODULE$.id()) {
                this.next().insert(that);
                return;
            }
            this.scala$reflect$internal$InfoTransformers$InfoTransformer$$$outer().log((Function0<Object>)(Function0<String> & java.io.Serializable & Serializable)() -> {
                String string = "Inserting info transformer %s following %s";
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                return new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{this.scala$reflect$internal$InfoTransformers$InfoTransformer$$$outer().phaseOf(that.pid()), this.scala$reflect$internal$InfoTransformers$InfoTransformer$$$outer().phaseOf(this.pid())}));
            });
            that.next_$eq(this.next());
            that.prev_$eq(this);
            this.next().prev_$eq(that);
            this.next_$eq(that);
        }

        public InfoTransformer nextFrom(int from) {
            if (from == this.pid()) {
                return this;
            }
            if (from < this.pid()) {
                if (this.prev().pid() < from) {
                    return this;
                }
                return this.prev().nextFrom(from);
            }
            if (this.next().pid() == NoPhase$.MODULE$.id()) {
                return this.next();
            }
            return this.next().nextFrom(from);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$InfoTransformers$InfoTransformer$$$outer() {
            return this.$outer;
        }

        public InfoTransformer(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            this.prev = this;
            this.next = this;
        }
    }
}

