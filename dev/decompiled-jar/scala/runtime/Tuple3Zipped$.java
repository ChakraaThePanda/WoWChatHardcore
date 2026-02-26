/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Function1;
import scala.Function3;
import scala.Serializable;
import scala.Tuple3;
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
import scala.runtime.Tuple3Zipped;

public final class Tuple3Zipped$ {
    public static Tuple3Zipped$ MODULE$;

    static {
        new Tuple3Zipped$();
    }

    public final <El1, Repr1, El2, Repr2, El3, Repr3> TraversableLike<El1, Repr1> coll1$extension(Tuple3<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>, IterableLike<El3, Repr3>> $this) {
        return $this._1();
    }

    public final <El1, Repr1, El2, Repr2, El3, Repr3> IterableLike<El2, Repr2> coll2$extension(Tuple3<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>, IterableLike<El3, Repr3>> $this) {
        return $this._2();
    }

    public final <El1, Repr1, El2, Repr2, El3, Repr3> IterableLike<El3, Repr3> coll3$extension(Tuple3<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>, IterableLike<El3, Repr3>> $this) {
        return $this._3();
    }

    public final <B, To, El1, Repr1, El2, Repr2, El3, Repr3> To map$extension(Tuple3<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>, IterableLike<El3, Repr3>> $this, Function3<El1, El2, El3, B> f, CanBuildFrom<Repr1, B, To> cbf) {
        Object object = new Object();
        try {
            Builder b = cbf.apply(this.coll1$extension($this).repr());
            Iterator elems2 = this.coll2$extension($this).iterator();
            Iterator elems3 = this.coll3$extension($this).iterator();
            this.coll1$extension($this).foreach((Function1<Object, Builder> & java.io.Serializable & Serializable)el1 -> {
                if (elems2.hasNext() && elems3.hasNext()) {
                    return b.$plus$eq((Object)f.apply(el1, elems2.next(), elems3.next()));
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

    public final <B, To, El1, Repr1, El2, Repr2, El3, Repr3> To flatMap$extension(Tuple3<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>, IterableLike<El3, Repr3>> $this, Function3<El1, El2, El3, TraversableOnce<B>> f, CanBuildFrom<Repr1, B, To> cbf) {
        Object object = new Object();
        try {
            Builder b = cbf.apply(this.coll1$extension($this).repr());
            Iterator elems2 = this.coll2$extension($this).iterator();
            Iterator elems3 = this.coll3$extension($this).iterator();
            this.coll1$extension($this).foreach((Function1<Object, Builder> & java.io.Serializable & Serializable)el1 -> {
                if (elems2.hasNext() && elems3.hasNext()) {
                    return (Builder)b.$plus$plus$eq((TraversableOnce)f.apply(el1, elems2.next(), elems3.next()));
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

    public final <To1, To2, To3, El1, Repr1, El2, Repr2, El3, Repr3> Tuple3<To1, To2, To3> filter$extension(Tuple3<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>, IterableLike<El3, Repr3>> $this, Function3<El1, El2, El3, Object> f, CanBuildFrom<Repr1, El1, To1> cbf1, CanBuildFrom<Repr2, El2, To2> cbf2, CanBuildFrom<Repr3, El3, To3> cbf3) {
        Object object = new Object();
        try {
            Builder b1 = cbf1.apply(this.coll1$extension($this).repr());
            Builder b2 = cbf2.apply(this.coll2$extension($this).repr());
            Builder b3 = cbf3.apply(this.coll3$extension($this).repr());
            Iterator elems2 = this.coll2$extension($this).iterator();
            Iterator elems3 = this.coll3$extension($this).iterator();
            this.coll1$extension($this).foreach((Function1<Object, Object> & java.io.Serializable & Serializable)el1 -> {
                if (elems2.hasNext() && elems3.hasNext()) {
                    Object el3;
                    Object el2 = elems2.next();
                    if (BoxesRunTime.unboxToBoolean(f.apply(el1, el2, el3 = elems3.next()))) {
                        b1.$plus$eq((Object)el1);
                        b2.$plus$eq((Object)el2);
                        return b3.$plus$eq((Object)el3);
                    }
                    return BoxedUnit.UNIT;
                }
                throw new NonLocalReturnControl<Tuple3>(object, Tuple3Zipped$.result$1(b1, b2, b3));
            });
            return Tuple3Zipped$.result$1(b1, b2, b3);
        }
        catch (NonLocalReturnControl ex) {
            if (ex.key() == object) {
                return (Tuple3)ex.value();
            }
            throw ex;
        }
    }

    public final <El1, Repr1, El2, Repr2, El3, Repr3> boolean exists$extension(Tuple3<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>, IterableLike<El3, Repr3>> $this, Function3<El1, El2, El3, Object> p) {
        Object object = new Object();
        try {
            Iterator elems2 = this.coll2$extension($this).iterator();
            Iterator elems3 = this.coll3$extension($this).iterator();
            this.coll1$extension($this).foreach((Function1<Object, Object> & java.io.Serializable & Serializable)el1 -> {
                Tuple3Zipped$.$anonfun$exists$1(elems2, elems3, p, object, el1);
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

    public final <El1, Repr1, El2, Repr2, El3, Repr3> boolean forall$extension(Tuple3<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>, IterableLike<El3, Repr3>> $this, Function3<El1, El2, El3, Object> p) {
        boolean bl;
        Function3<Object, Object, Object, Object> & java.io.Serializable & Serializable exists$extension_p = (Function3<Object, Object, Object, Object> & java.io.Serializable & Serializable)(x, y, z) -> BoxesRunTime.boxToBoolean(Tuple3Zipped$.$anonfun$forall$1(p, x, y, z));
        Object object = new Object();
        try {
            Iterator<El2> exists$extension_elems2 = this.coll2$extension($this).iterator();
            Iterator<El3> exists$extension_elems3 = this.coll3$extension($this).iterator();
            this.coll1$extension($this).foreach((Function1<Object, Object> & java.io.Serializable & Serializable)el1 -> {
                Tuple3Zipped$.$anonfun$exists$1(elems2, elems3, p, object, el1);
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

    public final <U, El1, Repr1, El2, Repr2, El3, Repr3> void foreach$extension(Tuple3<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>, IterableLike<El3, Repr3>> $this, Function3<El1, El2, El3, U> f) {
        Object object = new Object();
        try {
            Iterator elems2 = this.coll2$extension($this).iterator();
            Iterator elems3 = this.coll3$extension($this).iterator();
            this.coll1$extension($this).foreach((Function1<Object, Object> & java.io.Serializable & Serializable)el1 -> {
                if (elems2.hasNext() && elems3.hasNext()) {
                    return f.apply(el1, elems2.next(), elems3.next());
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

    public final <El1, Repr1, El2, Repr2, El3, Repr3> String toString$extension(Tuple3<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>, IterableLike<El3, Repr3>> $this) {
        return new StringBuilder(13).append("(").append(this.coll1$extension($this)).append(", ").append(this.coll2$extension($this)).append(", ").append(this.coll3$extension($this)).append(").zipped").toString();
    }

    public final <El1, Repr1, El2, Repr2, El3, Repr3> int hashCode$extension(Tuple3<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>, IterableLike<El3, Repr3>> $this) {
        return $this.hashCode();
    }

    public final <El1, Repr1, El2, Repr2, El3, Repr3> boolean equals$extension(Tuple3<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>, IterableLike<El3, Repr3>> $this, Object x$1) {
        boolean bl = x$1 instanceof Tuple3Zipped;
        if (bl) {
            Tuple3 tuple3 = x$1 == null ? null : ((Tuple3Zipped)x$1).colls();
            Tuple3<TraversableLike<El1, Repr1>, IterableLike<El2, Repr2>, IterableLike<El3, Repr3>> tuple32 = $this;
            if (!(tuple32 != null ? !((Object)tuple32).equals(tuple3) : tuple3 != null)) {
                return true;
            }
        }
        return false;
    }

    private static final Tuple3 result$1(Builder b1$1, Builder b2$1, Builder b3$1) {
        return new Tuple3(b1$1.result(), b2$1.result(), b3$1.result());
    }

    public static final /* synthetic */ void $anonfun$exists$1(Iterator elems2$4, Iterator elems3$4, Function3 p$1, Object nonLocalReturnKey4$1, Object el1) {
        if (elems2$4.hasNext() && elems3$4.hasNext()) {
            if (BoxesRunTime.unboxToBoolean(p$1.apply(el1, elems2$4.next(), elems3$4.next()))) {
                throw new NonLocalReturnControl$mcZ$sp(nonLocalReturnKey4$1, true);
            }
        } else {
            throw new NonLocalReturnControl$mcZ$sp(nonLocalReturnKey4$1, false);
        }
    }

    public static final /* synthetic */ boolean $anonfun$forall$1(Function3 p$2, Object x, Object y, Object z) {
        return !BoxesRunTime.unboxToBoolean(p$2.apply(x, y, z));
    }

    private Tuple3Zipped$() {
        MODULE$ = this;
    }
}

