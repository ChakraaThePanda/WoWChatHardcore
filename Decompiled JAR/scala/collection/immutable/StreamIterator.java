/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Function0;
import scala.Serializable;
import scala.collection.AbstractIterator;
import scala.collection.Iterator$;
import scala.collection.immutable.List;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Stream$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001}3AAD\b\u0003-!)1\u0006\u0001C\u0005Y!)1\u0006\u0001C\u0001_\u0019!Q\u0007\u0001\u00017\u0011!Q4A!A%\u0002\u0013Y\u0004\"B\u0016\u0004\t\u0003q\u0004\u0002\u0003\"\u0004\u0011\u000b\u0007I\u0011A\"\t\u0013\u0011\u0003\u0001\u0019!a\u0001\n\u0013)\u0005\"\u0003$\u0001\u0001\u0004\u0005\r\u0011\"\u0003H\u0011%i\u0005\u00011A\u0001B\u0003&q\bC\u0003O\u0001\u0011\u0005q\nC\u0003T\u0001\u0011\u0005A\u000bC\u0003V\u0001\u0011\u00053\tC\u0003W\u0001\u0011\u0005sK\u0001\bTiJ,\u0017-\\%uKJ\fGo\u001c:\u000b\u0005A\t\u0012!C5n[V$\u0018M\u00197f\u0015\t\u00112#\u0001\u0006d_2dWm\u0019;j_:T\u0011\u0001F\u0001\u0006g\u000e\fG.Y\u0002\u0001+\t9bdE\u0002\u00011!\u00022!\u0007\u000e\u001d\u001b\u0005\t\u0012BA\u000e\u0012\u0005A\t%m\u001d;sC\u000e$\u0018\n^3sCR|'\u000f\u0005\u0002\u001e=1\u0001AAB\u0010\u0001\t\u000b\u0007\u0001EA\u0001B#\t\tS\u0005\u0005\u0002#G5\t1#\u0003\u0002%'\t9aj\u001c;iS:<\u0007C\u0001\u0012'\u0013\t93CA\u0002B]f\u00042!G\u0015\u001d\u0013\tQ\u0013C\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003\u0019a\u0014N\\5u}Q\tQ\u0006E\u0002/\u0001qi\u0011a\u0004\u000b\u0003[ABQ!\r\u0002A\u0002I\nAa]3mMB\u0019af\r\u000f\n\u0005Qz!AB*ue\u0016\fWN\u0001\u0005MCjL8)\u001a7m'\t\u0019q\u0007\u0005\u0002#q%\u0011\u0011h\u0005\u0002\u0007\u0003:L(+\u001a4\u0002\u0005M$\bc\u0001\u0012=e%\u0011Qh\u0005\u0002\ty\tLh.Y7f}Q\u0011q(\u0011\t\u0003\u0001\u000ei\u0011\u0001\u0001\u0005\u0007u\u0015!\t\u0019A\u001e\u0002\u0003Y,\u0012AM\u0001\u0006i\",7/Z\u000b\u0002\u007f\u0005IA\u000f[3tK~#S-\u001d\u000b\u0003\u0011.\u0003\"AI%\n\u0005)\u001b\"\u0001B+oSRDq\u0001\u0014\u0005\u0002\u0002\u0003\u0007q(A\u0002yIE\na\u0001\u001e5fg\u0016\u0004\u0013a\u00025bg:+\u0007\u0010^\u000b\u0002!B\u0011!%U\u0005\u0003%N\u0011qAQ8pY\u0016\fg.\u0001\u0003oKb$H#\u0001\u000f\u0002\u0011Q|7\u000b\u001e:fC6\fa\u0001^8MSN$X#\u0001-\u0011\u0007ecFD\u0004\u0002#5&\u00111lE\u0001\ba\u0006\u001c7.Y4f\u0013\tifL\u0001\u0003MSN$(BA.\u0014\u0001")
public final class StreamIterator<A>
extends AbstractIterator<A> {
    private LazyCell these;

    private LazyCell these() {
        return this.these;
    }

    private void these_$eq(LazyCell x$1) {
        this.these = x$1;
    }

    @Override
    public boolean hasNext() {
        return this.these().v().nonEmpty();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public A next() {
        void var2_2;
        if (this.isEmpty()) {
            return (A)Iterator$.MODULE$.empty().next();
        }
        Stream cur = this.these().v();
        Object result2 = cur.head();
        this.these_$eq(new LazyCell(this, (Function0<Stream> & java.io.Serializable & Serializable)() -> (Stream)cur.tail()));
        return var2_2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Stream<A> toStream() {
        void var1_1;
        Stream result2 = this.these().v();
        this.these_$eq(new LazyCell(this, (Function0<Stream> & java.io.Serializable & Serializable)() -> Stream$.MODULE$.empty()));
        return var1_1;
    }

    @Override
    public List<A> toList() {
        return this.toStream().toList();
    }

    private StreamIterator() {
    }

    public StreamIterator(Stream<A> self) {
        this();
        super.these_$eq(new LazyCell(this, (Function0<Stream> & java.io.Serializable & Serializable)() -> self));
    }

    public class LazyCell {
        private Stream<A> v;
        private Function0<Stream<A>> st;
        private volatile boolean bitmap$0;
        public final /* synthetic */ StreamIterator $outer;

        private Stream<A> v$lzycompute() {
            synchronized (this) {
                if (!this.bitmap$0) {
                    this.v = this.st.apply();
                    this.bitmap$0 = true;
                }
            }
            this.st = null;
            return this.v;
        }

        public Stream<A> v() {
            if (!this.bitmap$0) {
                return this.v$lzycompute();
            }
            return this.v;
        }

        public /* synthetic */ StreamIterator scala$collection$immutable$StreamIterator$LazyCell$$$outer() {
            return this.$outer;
        }

        public LazyCell(StreamIterator $outer, Function0<Stream<A>> st) {
            this.st = st;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }
}

