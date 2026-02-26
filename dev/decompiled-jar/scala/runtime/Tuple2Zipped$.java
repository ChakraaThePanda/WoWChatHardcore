/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Function1;
import scala.Function2;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.mutable.Builder;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.NonLocalReturnControl;
import scala.runtime.NonLocalReturnControl$mcV$sp;
import scala.runtime.NonLocalReturnControl$mcZ$sp;
import scala.runtime.Tuple2Zipped;

public final class Tuple2Zipped$ {
    public static Tuple2Zipped$ MODULE$;

    static {
        new Tuple2Zipped$();
    }

    public final <El1, Repr1, El2, Repr2> TraversableLike<El1, Repr1> coll1$extension(Tuple2<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>> $this) {
        return $this._1();
    }

    public final <El1, Repr1, El2, Repr2> IterableLike<El2, Repr2> coll2$extension(Tuple2<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>> $this) {
        return $this._2();
    }

    public final <B, To, El1, Repr1, El2, Repr2> To map$extension(Tuple2<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>> $this, Function2<El1, El2, B> f, CanBuildFrom<Repr1, B, To> cbf) {
        Object object = new Object();
        try {
            Builder b = cbf.apply(this.coll1$extension($this).repr());
            b.sizeHint(this.coll1$extension($this));
            Iterator elems2 = this.coll2$extension($this).iterator();
            this.coll1$extension($this).foreach((Function1<Object, Builder> & java.io.Serializable & Serializable)el1 -> {
                if (elems2.hasNext()) {
                    return b.$plus$eq((Object)f.apply(el1, elems2.next()));
                }
                throw new NonLocalReturnControl(object, b.result());
            });
            return b.result();
        }
        catch (NonLocalReturnControl ex) {
            if (ex.key() == object) {
                return (To)ex.value();
            }
            throw ex;
        }
    }

    public final <B, To, El1, Repr1, El2, Repr2> To flatMap$extension(Tuple2<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>> $this, Function2<El1, El2, TraversableOnce<B>> f, CanBuildFrom<Repr1, B, To> cbf) {
        Object object = new Object();
        try {
            Builder b = cbf.apply(this.coll1$extension($this).repr());
            Iterator elems2 = this.coll2$extension($this).iterator();
            this.coll1$extension($this).foreach((Function1<Object, Builder> & java.io.Serializable & Serializable)el1 -> {
                if (elems2.hasNext()) {
                    return (Builder)b.$plus$plus$eq((TraversableOnce)f.apply(el1, elems2.next()));
                }
                throw new NonLocalReturnControl(object, b.result());
            });
            return b.result();
        }
        catch (NonLocalReturnControl ex) {
            if (ex.key() == object) {
                return (To)ex.value();
            }
            throw ex;
        }
    }

    public final <To1, To2, El1, Repr1, El2, Repr2> Tuple2<To1, To2> filter$extension(Tuple2<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>> $this, Function2<El1, El2, Object> f, CanBuildFrom<Repr1, El1, To1> cbf1, CanBuildFrom<Repr2, El2, To2> cbf2) {
        Object object = new Object();
        try {
            Builder b1 = cbf1.apply(this.coll1$extension($this).repr());
            Builder b2 = cbf2.apply(this.coll2$extension($this).repr());
            Iterator elems2 = this.coll2$extension($this).iterator();
            this.coll1$extension($this).foreach((Function1<Object, Object> & java.io.Serializable & Serializable)el1 -> {
                if (elems2.hasNext()) {
                    Object el2 = elems2.next();
                    if (BoxesRunTime.unboxToBoolean(f.apply(el1, el2))) {
                        b1.$plus$eq((Object)el1);
                        return b2.$plus$eq((Object)el2);
                    }
                    return BoxedUnit.UNIT;
                }
                throw new NonLocalReturnControl(object, new Tuple2(b1.result(), b2.result()));
            });
            return new Tuple2<To1, To2>(b1.result(), b2.result());
        }
        catch (NonLocalReturnControl ex) {
            if (ex.key() == object) {
                return (Tuple2)ex.value();
            }
            throw ex;
        }
    }

    public final <El1, Repr1, El2, Repr2> boolean exists$extension(Tuple2<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>> $this, Function2<El1, El2, Object> p) {
        Object object = new Object();
        try {
            Iterator elems2 = this.coll2$extension($this).iterator();
            this.coll1$extension($this).foreach((Function1<Object, Object> & java.io.Serializable & Serializable)el1 -> {
                Tuple2Zipped$.$anonfun$exists$1(elems2, p, object, el1);
                return BoxedUnit.UNIT;
            });
            return false;
        }
        catch (NonLocalReturnControl ex) {
            if (ex.key() == object) {
                return ex.value$mcZ$sp();
            }
            throw ex;
        }
    }

    public final <El1, Repr1, El2, Repr2> boolean forall$extension(Tuple2<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>> $this, Function2<El1, El2, Object> p) {
        boolean bl;
        Function2<Object, Object, Object> & java.io.Serializable & Serializable exists$extension_p = (Function2<Object, Object, Object> & java.io.Serializable & Serializable)(x, y) -> BoxesRunTime.boxToBoolean(Tuple2Zipped$.$anonfun$forall$1(p, x, y));
        Object object = new Object();
        try {
            Iterator<El2> exists$extension_elems2 = this.coll2$extension($this).iterator();
            this.coll1$extension($this).foreach((Function1<Object, Object> & java.io.Serializable & Serializable)el1 -> {
                Tuple2Zipped$.$anonfun$exists$1(elems2, p, object, el1);
                return BoxedUnit.UNIT;
            });
            bl = false;
        }
        catch (NonLocalReturnControl exists$extension_ex) {
            if (exists$extension_ex.key() == object) {
                bl = exists$extension_ex.value$mcZ$sp();
            }
            throw exists$extension_ex;
        }
        return !bl;
    }

    public final <U, El1, Repr1, El2, Repr2> void foreach$extension(Tuple2<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>> $this, Function2<El1, El2, U> f) {
        Object object = new Object();
        try {
            Iterator elems2 = this.coll2$extension($this).iterator();
            this.coll1$extension($this).foreach((Function1<Object, Object> & java.io.Serializable & Serializable)el1 -> {
                if (elems2.hasNext()) {
                    return f.apply(el1, elems2.next());
                }
                throw new NonLocalReturnControl$mcV$sp(object, BoxedUnit.UNIT);
            });
            return;
        }
        catch (NonLocalReturnControl ex) {
            if (ex.key() == object) {
                ex.value$mcV$sp();
                return;
            }
            throw ex;
        }
    }

    public final <El1, Repr1, El2, Repr2> String toString$extension(Tuple2<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>> $this) {
        return new StringBuilder(11).append("(").append(this.coll1$extension($this)).append(", ").append(this.coll2$extension($this)).append(").zipped").toString();
    }

    public final <El1, Repr1, El2, Repr2> int hashCode$extension(Tuple2<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>> $this) {
        return $this.hashCode();
    }

    public final <El1, Repr1, El2, Repr2> boolean equals$extension(Tuple2<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>> $this, Object x$1) {
        boolean bl = x$1 instanceof Tuple2Zipped;
        if (bl) {
            Tuple2 tuple2 = x$1 == null ? null : ((Tuple2Zipped)x$1).colls();
            Tuple2<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>> tuple22 = $this;
            if (!(tuple22 != null ? !((Object)tuple22).equals(tuple2) : tuple2 != null)) {
                return true;
            }
        }
        return false;
    }

    public static final /* synthetic */ void $anonfun$exists$1(Iterator elems2$4, Function2 p$1, Object nonLocalReturnKey4$1, Object el1) {
        if (elems2$4.hasNext()) {
            if (BoxesRunTime.unboxToBoolean(p$1.apply(el1, elems2$4.next()))) {
                throw new NonLocalReturnControl$mcZ$sp(nonLocalReturnKey4$1, true);
            }
        } else {
            throw new NonLocalReturnControl$mcZ$sp(nonLocalReturnKey4$1, false);
        }
    }

    public static final /* synthetic */ boolean $anonfun$forall$1(Function2 p$2, Object x, Object y) {
        return !BoxesRunTime.unboxToBoolean(p$2.apply(x, y));
    }

    private Tuple2Zipped$() {
        MODULE$ = this;
    }
}

