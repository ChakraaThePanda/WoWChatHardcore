/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.Predef$;
import scala.Proxy;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.Growable;
import scala.collection.mutable.Builder$;
import scala.reflect.ScalaSignature;
import scala.runtime.RichInt$;

@ScalaSignature(bytes="\u0006\u0001Q4qAC\u0006\u0011\u0002\u0007\u0005!\u0003C\u0003*\u0001\u0011\u0005!\u0006C\u0003/\u0001\u0019\u0005q\u0006C\u00034\u0001\u0019\u0005!\u0006C\u00035\u0001\u0019\u0005Q\u0007C\u0003:\u0001\u0011\u0005!\bC\u0003:\u0001\u0011\u0005\u0001\tC\u0003:\u0001\u0011\u0005a\nC\u0003[\u0001\u0011\u00051\fC\u0003h\u0001\u0011\u0005\u0001NA\u0004Ck&dG-\u001a:\u000b\u00051i\u0011aB7vi\u0006\u0014G.\u001a\u0006\u0003\u001d=\t!bY8mY\u0016\u001cG/[8o\u0015\u0005\u0001\u0012!B:dC2\f7\u0001A\u000b\u0004'\u0001:4c\u0001\u0001\u00151A\u0011QCF\u0007\u0002\u001f%\u0011qc\u0004\u0002\u0007\u0003:L(+\u001a4\u0011\u0007eab$D\u0001\u001b\u0015\tYR\"A\u0004hK:,'/[2\n\u0005uQ\"\u0001C$s_^\f'\r\\3\u0011\u0005}\u0001C\u0002\u0001\u0003\u0007C\u0001A)\u0019\u0001\u0012\u0003\t\u0015cW-\\\t\u0003G\u0019\u0002\"!\u0006\u0013\n\u0005\u0015z!a\u0002(pi\"Lgn\u001a\t\u0003+\u001dJ!\u0001K\b\u0003\u0007\u0005s\u00170\u0001\u0004%S:LG\u000f\n\u000b\u0002WA\u0011Q\u0003L\u0005\u0003[=\u0011A!\u00168ji\u0006AA\u0005\u001d7vg\u0012*\u0017\u000f\u0006\u00021c5\t\u0001\u0001C\u00033\u0005\u0001\u0007a$\u0001\u0003fY\u0016l\u0017!B2mK\u0006\u0014\u0018A\u0002:fgVdG\u000fF\u00017!\tyr\u0007\u0002\u00049\u0001\u0011\u0015\rA\t\u0002\u0003)>\f\u0001b]5{K\"Kg\u000e\u001e\u000b\u0003WmBQ\u0001P\u0003A\u0002u\nAa]5{KB\u0011QCP\u0005\u0003\u007f=\u00111!\u00138u)\tY\u0013\tC\u0003C\r\u0001\u00071)\u0001\u0003d_2d\u0007g\u0001#J\u0019B!QI\u0012%L\u001b\u0005i\u0011BA$\u000e\u0005=!&/\u0019<feN\f'\r\\3MS.,\u0007CA\u0010J\t%Q\u0015)!A\u0001\u0002\u000b\u0005!EA\u0002`IE\u0002\"a\b'\u0005\u00135\u000b\u0015\u0011!A\u0001\u0006\u0003\u0011#aA0%eQ\u00191f\u0014-\t\u000b\t;\u0001\u0019\u0001)1\u0007E\u001bf\u000b\u0005\u0003F\rJ+\u0006CA\u0010T\t%!v*!A\u0001\u0002\u000b\u0005!EA\u0002`IM\u0002\"a\b,\u0005\u0013]{\u0015\u0011!A\u0001\u0006\u0003\u0011#aA0%i!)\u0011l\u0002a\u0001{\u0005)A-\u001a7uC\u0006y1/\u001b>f\u0011&tGOQ8v]\u0012,G\rF\u0002,9vCQ\u0001\u0010\u0005A\u0002uBQA\u0018\u0005A\u0002}\u000bABY8v]\u0012LgnZ\"pY2\u00044\u0001\u00192f!\u0011)e)\u00193\u0011\u0005}\u0011G!C2^\u0003\u0003\u0005\tQ!\u0001#\u0005\ryF%\u000e\t\u0003?\u0015$\u0011BZ/\u0002\u0002\u0003\u0005)\u0011\u0001\u0012\u0003\u0007}#c'A\u0005nCB\u0014Vm];miV\u0011\u0011.\u001c\u000b\u0003U>\u0004Ba\u001b\u0001\u001fY6\t1\u0002\u0005\u0002 [\u0012)a.\u0003b\u0001E\t)a*Z<U_\")\u0001/\u0003a\u0001c\u0006\ta\r\u0005\u0003\u0016eZb\u0017BA:\u0010\u0005%1UO\\2uS>t\u0017\u0007")
public interface Builder<Elem, To>
extends Growable<Elem> {
    public Builder<Elem, To> $plus$eq(Elem var1);

    @Override
    public void clear();

    public To result();

    public static /* synthetic */ void sizeHint$(Builder $this, int size) {
        $this.sizeHint(size);
    }

    default public void sizeHint(int size) {
    }

    public static /* synthetic */ void sizeHint$(Builder $this, TraversableLike coll) {
        $this.sizeHint(coll);
    }

    default public void sizeHint(TraversableLike<?, ?> coll) {
        int n = coll.sizeHintIfCheap();
        switch (n) {
            case -1: {
                return;
            }
        }
        this.sizeHint(n);
    }

    public static /* synthetic */ void sizeHint$(Builder $this, TraversableLike coll, int delta) {
        $this.sizeHint(coll, delta);
    }

    default public void sizeHint(TraversableLike<?, ?> coll, int delta) {
        int n = coll.sizeHintIfCheap();
        switch (n) {
            case -1: {
                return;
            }
        }
        this.sizeHint(n + delta);
    }

    public static /* synthetic */ void sizeHintBounded$(Builder $this, int size, TraversableLike boundingColl) {
        $this.sizeHintBounded(size, boundingColl);
    }

    default public void sizeHintBounded(int size, TraversableLike<?, ?> boundingColl) {
        int n = boundingColl.sizeHintIfCheap();
        switch (n) {
            case -1: {
                return;
            }
        }
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        this.sizeHint(RichInt$.MODULE$.min$extension(size, n));
    }

    public static /* synthetic */ Builder mapResult$(Builder $this, Function1 f) {
        return $this.mapResult(f);
    }

    default public <NewTo> Builder<Elem, NewTo> mapResult(Function1<To, NewTo> f) {
        return new Builder<Elem, NewTo>(this, f){
            private final Builder<Elem, To> self;
            private final Function1 f$1;

            public int hashCode() {
                return Proxy.hashCode$(this);
            }

            public boolean equals(Object that) {
                return Proxy.equals$(this, that);
            }

            public String toString() {
                return Proxy.toString$(this);
            }

            public void sizeHint(TraversableLike<?, ?> coll) {
                Builder.sizeHint$((Builder)this, coll);
            }

            public void sizeHint(TraversableLike<?, ?> coll, int delta) {
                Builder.sizeHint$(this, coll, delta);
            }

            public <NewTo> Builder<Elem, NewTo> mapResult(Function1<NewTo, NewTo> f) {
                return Builder.mapResult$(this, f);
            }

            public Growable<Elem> $plus$eq(Elem elem1, Elem elem2, Seq<Elem> elems) {
                return Growable.$plus$eq$(this, elem1, elem2, elems);
            }

            public Builder<Elem, To> self() {
                return this.self;
            }

            public $anon$1 $plus$eq(Elem x) {
                this.self().$plus$eq(x);
                return this;
            }

            public void clear() {
                this.self().clear();
            }

            public $anon$1 $plus$plus$eq(TraversableOnce<Elem> xs) {
                this.self().$plus$plus$eq(xs);
                return this;
            }

            public void sizeHint(int size) {
                this.self().sizeHint(size);
            }

            public void sizeHintBounded(int size, TraversableLike<?, ?> boundColl) {
                this.self().sizeHintBounded(size, boundColl);
            }

            public NewTo result() {
                return (NewTo)this.f$1.apply(this.self().result());
            }
            {
                this.f$1 = f$1;
                Growable.$init$(this);
                Builder.$init$(this);
                Proxy.$init$(this);
                this.self = $outer;
            }
        };
    }

    public static void $init$(Builder $this) {
    }
}

