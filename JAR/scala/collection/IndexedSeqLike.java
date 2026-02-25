/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.collection.AbstractIterator;
import scala.collection.BufferedIterator;
import scala.collection.IndexedSeq;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.SeqLike;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Buffer;
import scala.reflect.ScalaSignature;
import scala.runtime.RichInt$;
import scala.util.hashing.MurmurHash3$;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0005baB\f\u0019!\u0003\r\t!\b\u0005\u0006e\u0001!\ta\r\u0005\u0006o\u00011\t\u0001\u000f\u0005\u0006y\u0001!\t%\u0010\u0005\u0007\u0003\u0002\u0001K\u0011\u000b\u001d\t\r\t\u0003\u0001\u0015\"\u0015D\r\u00111\u0005\u0001C$\t\u0011E3!\u0011!Q\u0001\nyB\u0001B\u0015\u0004\u0003\u0002\u0003\u0006IA\u0010\u0005\u0006'\u001a!\t\u0001\u0016\u0005\b3\u001a\u0001\r\u0011\"\u0003[\u0011\u001dYf\u00011A\u0005\nqCaa\u0018\u0004!B\u0013q\u0004\"\u00021\u0007\t\u0013Q\u0006\"B1\u0007\t\u0003\u0011\u0007\"\u00024\u0007\t\u00039\u0007\"\u00025\u0007\t\u0003I\u0007\"\u00026\u0007\t\u0003Z\u0007\"B9\u0007\t\u0003\u0012\b\"\u0002;\u0007\t\u0003*\bbBA\u0001\u0001\u0011\u0005\u00131\u0001\u0005\b\u0003\u000b\u0001A\u0011IA\u0004\u0011\u001d\ty\u0002\u0001C)1i\u0013a\"\u00138eKb,GmU3r\u0019&\\WM\u0003\u0002\u001a5\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003m\tQa]2bY\u0006\u001c\u0001!F\u0002\u001fSA\u001a2\u0001A\u0010$!\t\u0001\u0013%D\u0001\u001b\u0013\t\u0011#DA\u0002B]f\u0004B\u0001J\u0013(_5\t\u0001$\u0003\u0002'1\t91+Z9MS.,\u0007C\u0001\u0015*\u0019\u0001!aA\u000b\u0001\u0005\u0006\u0004Y#!A!\u0012\u00051z\u0002C\u0001\u0011.\u0013\tq#DA\u0004O_RD\u0017N\\4\u0011\u0005!\u0002DAB\u0019\u0001\t\u000b\u00071F\u0001\u0003SKB\u0014\u0018A\u0002\u0013j]&$H\u0005F\u00015!\t\u0001S'\u0003\u000275\t!QK\\5u\u0003\r\u0019X-]\u000b\u0002sA\u0019AEO\u0014\n\u0005mB\"AC%oI\u0016DX\rZ*fc\u0006A\u0001.Y:i\u0007>$W\rF\u0001?!\t\u0001s(\u0003\u0002A5\t\u0019\u0011J\u001c;\u0002\u001dQD\u0017n]\"pY2,7\r^5p]\u0006aAo\\\"pY2,7\r^5p]R\u0011\u0011\b\u0012\u0005\u0006\u000b\u0016\u0001\raL\u0001\u0005e\u0016\u0004(O\u0001\u0005FY\u0016lWM\u001c;t'\u00111\u0001j\u0013(\u0011\u0007\u0011Ju%\u0003\u0002K1\t\u0001\u0012IY:ue\u0006\u001cG/\u0013;fe\u0006$xN\u001d\t\u0004I1;\u0013BA'\u0019\u0005A\u0011UO\u001a4fe\u0016$\u0017\n^3sCR|'\u000f\u0005\u0002!\u001f&\u0011\u0001K\u0007\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0006gR\f'\u000f^\u0001\u0004K:$\u0017A\u0002\u001fj]&$h\bF\u0002V/b\u0003\"A\u0016\u0004\u000e\u0003\u0001AQ!U\u0005A\u0002yBQAU\u0005A\u0002y\nQ!\u001b8eKb,\u0012AP\u0001\nS:$W\r_0%KF$\"\u0001N/\t\u000fy[\u0011\u0011!a\u0001}\u0005\u0019\u0001\u0010J\u0019\u0002\r%tG-\u001a=!\u0003%\tg/Y5mC\ndW-A\u0004iCNtU\r\u001f;\u0016\u0003\r\u0004\"\u0001\t3\n\u0005\u0015T\"a\u0002\"p_2,\u0017M\\\u0001\u0005]\u0016DH\u000fF\u0001(\u0003\u0011AW-\u00193\u0016\u0003\u001d\nA\u0001\u001a:paR\u0011An\u001c\t\u0004I5<\u0013B\u00018\u0019\u0005!IE/\u001a:bi>\u0014\b\"\u00029\u0012\u0001\u0004q\u0014!\u00018\u0002\tQ\f7.\u001a\u000b\u0003YNDQ\u0001\u001d\nA\u0002y\nQa\u001d7jG\u0016$2\u0001\u001c<y\u0011\u001598\u00031\u0001?\u0003\u00111'o\\7\t\u000be\u001c\u0002\u0019\u0001 \u0002\u000bUtG/\u001b7)\t\u0019Yhp \t\u0003AqL!! \u000e\u0003!M+'/[1m-\u0016\u00148/[8o+&#\u0015!\u0002<bYV,g\u0004\u0003\r`kCdbe]\u000f\u0002\u0011%$XM]1u_J,\u0012\u0001\\\u0001\ti>\u0014UO\u001a4feV!\u0011\u0011BA\r+\t\tY\u0001\u0005\u0004\u0002\u000e\u0005M\u0011qC\u0007\u0003\u0003\u001fQ1!!\u0005\u0019\u0003\u001diW\u000f^1cY\u0016LA!!\u0006\u0002\u0010\t1!)\u001e4gKJ\u00042\u0001KA\r\t\u001d\tY\"\u0006b\u0001\u0003;\u0011!!Q\u0019\u0012\u0005\u001dz\u0012aD:ju\u0016D\u0015N\u001c;JM\u000eCW-\u00199")
public interface IndexedSeqLike<A, Repr>
extends SeqLike<A, Repr> {
    @Override
    public IndexedSeq<A> seq();

    public static /* synthetic */ int hashCode$(IndexedSeqLike $this) {
        return $this.hashCode();
    }

    @Override
    default public int hashCode() {
        return MurmurHash3$.MODULE$.seqHash(this.seq());
    }

    public static /* synthetic */ IndexedSeq thisCollection$(IndexedSeqLike $this) {
        return $this.thisCollection();
    }

    @Override
    default public IndexedSeq<A> thisCollection() {
        return (IndexedSeq)this;
    }

    public static /* synthetic */ IndexedSeq toCollection$(IndexedSeqLike $this, Object repr) {
        return $this.toCollection(repr);
    }

    @Override
    default public IndexedSeq<A> toCollection(Repr repr) {
        return (IndexedSeq)repr;
    }

    public static /* synthetic */ Iterator iterator$(IndexedSeqLike $this) {
        return $this.iterator();
    }

    @Override
    default public Iterator<A> iterator() {
        return new Elements(this, 0, this.length());
    }

    public static /* synthetic */ Buffer toBuffer$(IndexedSeqLike $this) {
        return $this.toBuffer();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public <A1> Buffer<A1> toBuffer() {
        void var1_1;
        ArrayBuffer result2 = new ArrayBuffer(this.size());
        this.copyToBuffer(result2);
        return var1_1;
    }

    public static /* synthetic */ int sizeHintIfCheap$(IndexedSeqLike $this) {
        return $this.sizeHintIfCheap();
    }

    @Override
    default public int sizeHintIfCheap() {
        return this.size();
    }

    public static void $init$(IndexedSeqLike $this) {
    }

    public class Elements
    extends AbstractIterator<A>
    implements BufferedIterator<A>,
    Serializable {
        public static final long serialVersionUID = 1756321872811029277L;
        private final int end;
        private int index;
        public final /* synthetic */ IndexedSeqLike $outer;

        @Override
        public Option<A> headOption() {
            return BufferedIterator.headOption$(this);
        }

        @Override
        public BufferedIterator<A> buffered() {
            return BufferedIterator.buffered$(this);
        }

        private int index() {
            return this.index;
        }

        private void index_$eq(int x$1) {
            this.index = x$1;
        }

        private int available() {
            int n = this.end - this.index();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return RichInt$.MODULE$.max$extension(n, 0);
        }

        @Override
        public boolean hasNext() {
            return this.index() < this.end;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public A next() {
            void var1_1;
            if (this.index() >= this.end) {
                Iterator$.MODULE$.empty().next();
            }
            Object x = this.scala$collection$IndexedSeqLike$Elements$$$outer().apply(this.index());
            this.index_$eq(this.index() + 1);
            return var1_1;
        }

        @Override
        public A head() {
            if (this.index() >= this.end) {
                Iterator$.MODULE$.empty().next();
            }
            return this.scala$collection$IndexedSeqLike$Elements$$$outer().apply(this.index());
        }

        @Override
        public Iterator<A> drop(int n) {
            if (n <= 0) {
                return new Elements(this.scala$collection$IndexedSeqLike$Elements$$$outer(), this.index(), this.end);
            }
            if (this.index() + n >= this.end) {
                return new Elements(this.scala$collection$IndexedSeqLike$Elements$$$outer(), this.end, this.end);
            }
            return new Elements(this.scala$collection$IndexedSeqLike$Elements$$$outer(), this.index() + n, this.end);
        }

        @Override
        public Iterator<A> take(int n) {
            if (n <= 0) {
                return Iterator$.MODULE$.empty();
            }
            if (n <= this.available()) {
                return new Elements(this.scala$collection$IndexedSeqLike$Elements$$$outer(), this.index(), this.index() + n);
            }
            return new Elements(this.scala$collection$IndexedSeqLike$Elements$$$outer(), this.index(), this.end);
        }

        @Override
        public Iterator<A> slice(int from, int until) {
            return this.take(until).drop(from);
        }

        public /* synthetic */ IndexedSeqLike scala$collection$IndexedSeqLike$Elements$$$outer() {
            return this.$outer;
        }

        public Elements(IndexedSeqLike $outer, int start, int end) {
            this.end = end;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            BufferedIterator.$init$(this);
            this.index = start;
        }
    }
}

