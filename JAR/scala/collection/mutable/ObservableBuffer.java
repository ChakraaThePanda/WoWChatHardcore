/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.Function2;
import scala.Predef$;
import scala.Serializable;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Publisher;
import scala.collection.mutable.Undoable;
import scala.collection.script.End$;
import scala.collection.script.Include;
import scala.collection.script.Index;
import scala.collection.script.Message;
import scala.collection.script.Script;
import scala.collection.script.Start$;
import scala.reflect.ScalaSignature;
import scala.runtime.IntRef;

@ScalaSignature(bytes="\u0006\u0001\u0005maa\u0002\t\u0012!\u0003\r\t\u0001\u0007\u0005\u0006y\u0001!\t!\u0010\u0003\u0006\u0003\u0002\u0011\tA\u0011\u0005\u0007\t\u0002\u0001J\u0011A#\t\r%\u0003\u0001\u0013\"\u0001K\u0011\u0019\t\u0006\u0001%C\u0001%\"1A\u000b\u0001I\u0005\u0002UCa!\u0018\u0001\u0011\n\u0003q\u0006B\u00021\u0001!\u0013\u0005Q\b\u0003\u0004b\u0001A%\tA\u0019\u0005\fS\u0002\u0001\n1!A\u0001\n\u0013QW\u000eC\u0006q\u0001A\u0005\u0019\u0011!A\u0005\nE\u001c\bb\u0003;\u0001!\u0003\r\t\u0011!C\u0005kfD1B\u001f\u0001\u0011\u0002\u0007\u0005\t\u0011\"\u0003|{\"Ya\u0010\u0001I\u0001\u0004\u0003\u0005I\u0011B\u001f\u0000\u00119\t\t\u0001\u0001I\u0001\u0004\u0003\u0005I\u0011BA\u0002\u0003\u0013\u0011\u0001c\u00142tKJ4\u0018M\u00197f\u0005V4g-\u001a:\u000b\u0005I\u0019\u0012aB7vi\u0006\u0014G.\u001a\u0006\u0003)U\t!bY8mY\u0016\u001cG/[8o\u0015\u00051\u0012!B:dC2\f7\u0001A\u000b\u00033\u0011\u001aB\u0001\u0001\u000e\u001f[A\u00111\u0004H\u0007\u0002+%\u0011Q$\u0006\u0002\u0007\u0003:L(+\u001a4\u0011\u0007}\u0001#%D\u0001\u0012\u0013\t\t\u0013C\u0001\u0004Ck\u001a4WM\u001d\t\u0003G\u0011b\u0001\u0001B\u0003&\u0001\t\u0007aEA\u0001B#\t9#\u0006\u0005\u0002\u001cQ%\u0011\u0011&\u0006\u0002\b\u001d>$\b.\u001b8h!\tY2&\u0003\u0002-+\t\u0019\u0011I\\=\u0011\u0007}q\u0003'\u0003\u00020#\tI\u0001+\u001e2mSNDWM\u001d\n\u0004cMJd\u0001\u0002\u001a\u0001\u0001A\u0012A\u0002\u0010:fM&tW-\\3oiz\u00022\u0001N\u001c#\u001b\u0005)$B\u0001\u001c\u0014\u0003\u0019\u00198M]5qi&\u0011\u0001(\u000e\u0002\b\u001b\u0016\u001c8/Y4f!\ty\"(\u0003\u0002<#\tAQK\u001c3pC\ndW-\u0001\u0004%S:LG\u000f\n\u000b\u0002}A\u00111dP\u0005\u0003\u0001V\u0011A!\u00168ji\n\u0019\u0001+\u001e2\u0012\u0005\u001d\u001a\u0005cA\u0010\u0001E\u0005AA\u0005\u001d7vg\u0012*\u0017\u000f\u0006\u0002G\u000f6\t\u0001\u0001C\u0003I\u0007\u0001\u0007!%A\u0004fY\u0016lWM\u001c;\u0002\u001b\u0011\u0002H.^:%a2,8\u000fJ3r)\t15\nC\u0003M\t\u0001\u0007Q*\u0001\u0002ygB\u0019aj\u0014\u0012\u000e\u0003MI!\u0001U\n\u0003\u001fQ\u0013\u0018M^3sg\u0006\u0014G.Z(oG\u0016\fa\u0002\n9mkN$S-\u001d\u0013d_2|g\u000e\u0006\u0002G'\")\u0001*\u0002a\u0001E\u00051Q\u000f\u001d3bi\u0016$2A\u0010,\\\u0011\u00159f\u00011\u0001Y\u0003\u0005q\u0007CA\u000eZ\u0013\tQVCA\u0002J]RDQ\u0001\u0018\u0004A\u0002\t\n!B\\3xK2,W.\u001a8u\u0003\u0019\u0011X-\\8wKR\u0011!e\u0018\u0005\u0006/\u001e\u0001\r\u0001W\u0001\u0006G2,\u0017M]\u0001\nS:\u001cXM\u001d;BY2$2AP2e\u0011\u00159\u0016\u00021\u0001Y\u0011\u0015)\u0017\u00021\u0001g\u0003\u0015)G.Z7t!\rquMI\u0005\u0003QN\u00111\u0002\u0016:bm\u0016\u00148/\u00192mK\u0006q1/\u001e9fe\u0012\"\u0003\u000f\\;tI\u0015\fHC\u0001$l\u0011\u0015a'\u00021\u0001#\u0003\u0011)G.Z7\n\u0005\u0011s\u0017BA8\u0012\u0005)\u0011UO\u001a4fe2K7.Z\u0001\u0015gV\u0004XM\u001d\u0013%a2,8\u000fJ3rI\r|Gn\u001c8\u0015\u0005\u0019\u0013\b\"\u00027\f\u0001\u0004\u0011\u0013BA)o\u00031\u0019X\u000f]3sIU\u0004H-\u0019;f)\rqdo\u001e\u0005\u0006/2\u0001\r\u0001\u0017\u0005\u0006q2\u0001\rAI\u0001\b]\u0016<X\r\\3n\u0013\t!f.\u0001\u0007tkB,'\u000f\n:f[>4X\r\u0006\u0002#y\")q+\u0004a\u00011&\u0011QL\\\u0001\fgV\u0004XM\u001d\u0013dY\u0016\f'/\u0003\u0002a]\u0006y1/\u001e9fe\u0012Jgn]3si\u0006cG\u000eF\u0003?\u0003\u000b\t9\u0001C\u0003X\u001f\u0001\u0007\u0001\fC\u0003f\u001f\u0001\u0007a-\u0003\u0002b]\":\u0001!!\u0004\u0002\u0014\u0005]\u0001cA\u000e\u0002\u0010%\u0019\u0011\u0011C\u000b\u0003\u0015\u0011,\u0007O]3dCR,G-\t\u0002\u0002\u0016\u0005QtNY:feZ\f'\r\\3tA\u0005\u0014X\r\t3faJ,7-\u0019;fI\u0002\u0012WmY1vg\u0016\u00043o\u0019:jaRLgn\u001a\u0011jg\u0002\"W\r\u001d:fG\u0006$X\rZ\u0011\u0003\u00033\taA\r\u00182c9\u0002\u0004")
public interface ObservableBuffer<A>
extends Buffer<A>,
Publisher<Message<A>> {
    public /* synthetic */ ObservableBuffer scala$collection$mutable$ObservableBuffer$$super$$plus$eq(Object var1);

    public /* synthetic */ ObservableBuffer scala$collection$mutable$ObservableBuffer$$super$$plus$eq$colon(Object var1);

    public /* synthetic */ void scala$collection$mutable$ObservableBuffer$$super$update(int var1, Object var2);

    public /* synthetic */ Object scala$collection$mutable$ObservableBuffer$$super$remove(int var1);

    public /* synthetic */ void scala$collection$mutable$ObservableBuffer$$super$clear();

    public /* synthetic */ void scala$collection$mutable$ObservableBuffer$$super$insertAll(int var1, Traversable var2);

    public static /* synthetic */ ObservableBuffer $plus$eq$(ObservableBuffer $this, Object element) {
        return $this.$plus$eq(element);
    }

    @Override
    default public ObservableBuffer<A> $plus$eq(A element) {
        this.scala$collection$mutable$ObservableBuffer$$super$$plus$eq(element);
        this.publish(new Undoable(this, element){
            private final /* synthetic */ ObservableBuffer $outer;

            public void undo() {
                this.$outer.trimEnd(1);
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                super(End$.MODULE$, element$1);
            }
        });
        return this;
    }

    public static /* synthetic */ ObservableBuffer $plus$plus$eq$(ObservableBuffer $this, TraversableOnce xs) {
        return $this.$plus$plus$eq(xs);
    }

    @Override
    default public ObservableBuffer<A> $plus$plus$eq(TraversableOnce<A> xs) {
        xs.foreach((Function1<Object, ObservableBuffer> & java.io.Serializable & Serializable)x -> this.$plus$eq(x));
        return this;
    }

    public static /* synthetic */ ObservableBuffer $plus$eq$colon$(ObservableBuffer $this, Object element) {
        return $this.$plus$eq$colon(element);
    }

    @Override
    default public ObservableBuffer<A> $plus$eq$colon(A element) {
        this.scala$collection$mutable$ObservableBuffer$$super$$plus$eq$colon(element);
        this.publish(new Undoable(this, element){
            private final /* synthetic */ ObservableBuffer $outer;

            public void undo() {
                this.$outer.trimStart(1);
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                super(Start$.MODULE$, element$2);
            }
        });
        return this;
    }

    public static /* synthetic */ void update$(ObservableBuffer $this, int n, Object newelement) {
        $this.update(n, newelement);
    }

    @Override
    default public void update(int n, A newelement) {
        Object oldelement = this.apply(n);
        this.scala$collection$mutable$ObservableBuffer$$super$update(n, newelement);
        this.publish(new Undoable(this, n, newelement, oldelement){
            private final /* synthetic */ ObservableBuffer $outer;
            private final int n$1;
            private final Object oldelement$1;

            public void undo() {
                this.$outer.update(this.n$1, this.oldelement$1);
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.n$1 = n$1;
                this.oldelement$1 = oldelement$1;
                super(new Index(n$1), newelement$1);
            }
        });
    }

    public static /* synthetic */ Object remove$(ObservableBuffer $this, int n) {
        return $this.remove(n);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public A remove(int n) {
        void var2_2;
        Object oldelement = this.apply(n);
        this.scala$collection$mutable$ObservableBuffer$$super$remove(n);
        this.publish(new Undoable(this, n, oldelement){
            private final /* synthetic */ ObservableBuffer $outer;
            private final int n$2;
            private final Object oldelement$2;

            public void undo() {
                this.$outer.insert(this.n$2, Predef$.MODULE$.genericWrapArray(new Object[]{this.oldelement$2}));
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.n$2 = n$2;
                this.oldelement$2 = oldelement$2;
                super(new Index(n$2), oldelement$2);
            }
        });
        return var2_2;
    }

    public static /* synthetic */ void clear$(ObservableBuffer $this) {
        $this.clear();
    }

    @Override
    default public void clear() {
        this.scala$collection$mutable$ObservableBuffer$$super$clear();
        this.publish(new Undoable(null){

            public void undo() {
                throw new UnsupportedOperationException("cannot undo");
            }
        });
    }

    public static /* synthetic */ void insertAll$(ObservableBuffer $this, int n, Traversable elems) {
        $this.insertAll(n, elems);
    }

    @Override
    default public void insertAll(int n, Traversable<A> elems) {
        this.scala$collection$mutable$ObservableBuffer$$super$insertAll(n, elems);
        IntRef curr = IntRef.create(n - 1);
        Script msg = elems.foldLeft(new Undoable(null){

            public void undo() {
                throw new UnsupportedOperationException("cannot undo");
            }
        }, (Function2<Script, Object, Script> & java.io.Serializable & Serializable)(x0$1, x1$1) -> {
            Script msg = x0$1;
            ++curr$1.elem;
            return (Script)msg.$plus$eq(new Include<Object>(new Index(curr$1.elem), x1$1));
        });
        this.publish(msg);
    }

    public static void $init$(ObservableBuffer $this) {
    }
}

