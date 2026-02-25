/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function2;
import scala.collection.AbstractIterator;
import scala.collection.GenSeq;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.LinearSeq;
import scala.collection.SeqLike;
import scala.collection.immutable.List;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.util.hashing.MurmurHash3$;

@ScalaSignature(bytes="\u0006\u0001q3\u0001\u0002C\u0005\u0011\u0002\u0007\u0005ab\t\u0005\u0006Q\u0001!\t!\u000b\u0005\u0007[\u0001\u0001K\u0011\u000b\u0018\t\rI\u0002\u0001\u0015\"\u00154\u0011\u00151\u0004A\"\u0001/\u0011\u00159\u0004\u0001\"\u00119\u0011\u0015a\u0004\u0001\"\u0011>\u0011\u0015\t\u0005\u0001\"\u0012C\u00055a\u0015N\\3beN+\u0017\u000fT5lK*\u0011!bC\u0001\u000bG>dG.Z2uS>t'\"\u0001\u0007\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0019qB\u0007\u0013\u0014\u0007\u0001\u0001B\u0003\u0005\u0002\u0012%5\t1\"\u0003\u0002\u0014\u0017\t1\u0011I\\=SK\u001a\u0004B!\u0006\f\u0019G5\t\u0011\"\u0003\u0002\u0018\u0013\t91+Z9MS.,\u0007CA\r\u001b\u0019\u0001!aa\u0007\u0001\u0005\u0006\u0004a\"!A!\u0012\u0005u\u0001\u0003CA\t\u001f\u0013\ty2BA\u0004O_RD\u0017N\\4\u0011\u0005E\t\u0013B\u0001\u0012\f\u0005\r\te.\u001f\t\u00033\u0011\"a!\n\u0001\u0005\u0006\u00041#\u0001\u0002*faJ\f\"!H\u0014\u0011\tU\u0001\u0001dI\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003)\u0002\"!E\u0016\n\u00051Z!\u0001B+oSR\fa\u0002\u001e5jg\u000e{G\u000e\\3di&|g.F\u00010!\r)\u0002\u0007G\u0005\u0003c%\u0011\u0011\u0002T5oK\u0006\u00148+Z9\u0002\u0019Q|7i\u001c7mK\u000e$\u0018n\u001c8\u0015\u0005=\"\u0004\"B\u001b\u0004\u0001\u0004\u0019\u0013\u0001\u0002:faJ\f1a]3r\u0003!A\u0017m\u001d5D_\u0012,G#A\u001d\u0011\u0005EQ\u0014BA\u001e\f\u0005\rIe\u000e^\u0001\tSR,'/\u0019;peV\ta\bE\u0002\u0016\u007faI!\u0001Q\u0005\u0003\u0011%#XM]1u_J\f1bY8se\u0016\u001c\bo\u001c8egV\u00111I\u0014\u000b\u0003\tB#\"!\u0012%\u0011\u0005E1\u0015BA$\f\u0005\u001d\u0011un\u001c7fC:DQ!S\u0004A\u0002)\u000b\u0011\u0001\u001d\t\u0006#-CR*R\u0005\u0003\u0019.\u0011\u0011BR;oGRLwN\u001c\u001a\u0011\u0005eqE!B(\b\u0005\u0004a\"!\u0001\"\t\u000bE;\u0001\u0019\u0001*\u0002\tQD\u0017\r\u001e\t\u0004+Mk\u0015B\u0001+\n\u0005\u00199UM\\*fc\"\u0012qA\u0016\t\u0003/jk\u0011\u0001\u0017\u0006\u00033.\t!\"\u00198o_R\fG/[8o\u0013\tY\u0006LA\u0004uC&d'/Z2")
public interface LinearSeqLike<A, Repr extends LinearSeqLike<A, Repr>>
extends SeqLike<A, Repr> {
    public static /* synthetic */ LinearSeq thisCollection$(LinearSeqLike $this) {
        return $this.thisCollection();
    }

    @Override
    default public LinearSeq<A> thisCollection() {
        return (LinearSeq)this;
    }

    public static /* synthetic */ LinearSeq toCollection$(LinearSeqLike $this, LinearSeqLike repr) {
        return $this.toCollection(repr);
    }

    @Override
    default public LinearSeq<A> toCollection(Repr repr) {
        return (LinearSeq)repr;
    }

    @Override
    public LinearSeq<A> seq();

    public static /* synthetic */ int hashCode$(LinearSeqLike $this) {
        return $this.hashCode();
    }

    @Override
    default public int hashCode() {
        return MurmurHash3$.MODULE$.seqHash(this.seq());
    }

    public static /* synthetic */ Iterator iterator$(LinearSeqLike $this) {
        return $this.iterator();
    }

    @Override
    default public Iterator<A> iterator() {
        return new AbstractIterator<A>(this){
            private Repr these;

            private Repr these() {
                return this.these;
            }

            private void these_$eq(Repr x$1) {
                this.these = x$1;
            }

            public boolean hasNext() {
                return !this.these().isEmpty();
            }

            /*
             * WARNING - void declaration
             */
            public A next() {
                if (this.hasNext()) {
                    void var1_1;
                    A result2 = this.these().head();
                    this.these_$eq((LinearSeqLike)this.these().tail());
                    return var1_1;
                }
                return (A)Iterator$.MODULE$.empty().next();
            }

            /*
             * WARNING - void declaration
             */
            public List<A> toList() {
                void var1_1;
                List<A> xs = this.these().toList();
                this.these_$eq((LinearSeqLike)this.these().take(0));
                return var1_1;
            }
            {
                this.these = $outer;
            }
        };
    }

    public static /* synthetic */ boolean corresponds$(LinearSeqLike $this, GenSeq that, Function2 p) {
        return $this.corresponds(that, p);
    }

    @Override
    default public <B> boolean corresponds(GenSeq<B> that, Function2<A, B, Object> p) {
        while (true) {
            if (this_.isEmpty()) {
                return that.isEmpty();
            }
            if (!that.nonEmpty() || !BoxesRunTime.unboxToBoolean(p.apply(this_.head(), that.head()))) break;
            that = (GenSeq)that.tail();
            LinearSeqLike this_ = (LinearSeqLike)this_.tail();
        }
        return false;
    }

    public static void $init$(LinearSeqLike $this) {
    }
}

