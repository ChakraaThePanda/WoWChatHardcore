/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.collection.mutable.Publisher;
import scala.collection.mutable.Set;
import scala.collection.mutable.Undoable;
import scala.collection.script.Message;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001i3q!\u0003\u0006\u0011\u0002\u0007\u0005\u0011\u0003C\u00036\u0001\u0011\u0005a\u0007B\u0003;\u0001\t\u00051\b\u0003\u0004>\u0001A%\tA\u0010\u0005\u0007\u0005\u0002\u0001J\u0011A\"\t\r\u0015\u0003\u0001\u0013\"\u00017\u0011-1\u0005\u0001%A\u0002\u0002\u0003%IaR%\t\u00171\u0003\u0001\u0013aA\u0001\u0002\u0013%Qj\u0014\u0005\f!\u0002\u0001\n1!A\u0001\n\u00131\u0014KA\u0007PEN,'O^1cY\u0016\u001cV\r\u001e\u0006\u0003\u00171\tq!\\;uC\ndWM\u0003\u0002\u000e\u001d\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003=\tQa]2bY\u0006\u001c\u0001!\u0006\u0002\u0013;M!\u0001aE\f'!\t!R#D\u0001\u000f\u0013\t1bB\u0001\u0004B]f\u0014VM\u001a\t\u00041eYR\"\u0001\u0006\n\u0005iQ!aA*fiB\u0011A$\b\u0007\u0001\t\u0015q\u0002A1\u0001 \u0005\u0005\t\u0015C\u0001\u0011$!\t!\u0012%\u0003\u0002#\u001d\t9aj\u001c;iS:<\u0007C\u0001\u000b%\u0013\t)cBA\u0002B]f\u00042\u0001G\u0014*\u0013\tA#BA\u0005Qk\nd\u0017n\u001d5feJ\u0019!\u0006\f\u001a\u0007\t-\u0002\u0001!\u000b\u0002\ryI,g-\u001b8f[\u0016tGO\u0010\t\u0004[AZR\"\u0001\u0018\u000b\u0005=b\u0011AB:de&\u0004H/\u0003\u00022]\t9Q*Z:tC\u001e,\u0007C\u0001\r4\u0013\t!$B\u0001\u0005V]\u0012|\u0017M\u00197f\u0003\u0019!\u0013N\\5uIQ\tq\u0007\u0005\u0002\u0015q%\u0011\u0011H\u0004\u0002\u0005+:LGOA\u0002Qk\n\f\"\u0001\t\u001f\u0011\u0007a\u00011$\u0001\u0005%a2,8\u000fJ3r)\ty\u0004)D\u0001\u0001\u0011\u0015\t5\u00011\u0001\u001c\u0003\u0011)G.Z7\u0002\u0013\u0011j\u0017N\\;tI\u0015\fHCA E\u0011\u0015\tE\u00011\u0001\u001c\u0003\u0015\u0019G.Z1s\u00039\u0019X\u000f]3sI\u0011\u0002H.^:%KF$\"a\u0010%\t\u000b\u00053\u0001\u0019A\u000e\n\u0005uR\u0015BA&\u000b\u0005\u001d\u0019V\r\u001e'jW\u0016\fqb];qKJ$C%\\5okN$S-\u001d\u000b\u0003\u007f9CQ!Q\u0004A\u0002mI!A\u0011&\u0002\u0017M,\b/\u001a:%G2,\u0017M]\u0005\u0003\u000b*CC\u0001A*W1B\u0011A\u0003V\u0005\u0003+:\u0011!\u0002Z3qe\u0016\u001c\u0017\r^3eC\u00059\u0016AO8cg\u0016\u0014h/\u00192mKN\u0004\u0013M]3!I\u0016\u0004(/Z2bi\u0016$\u0007EY3dCV\u001cX\rI:de&\u0004H/\u001b8hA%\u001c\b\u0005Z3qe\u0016\u001c\u0017\r^3eC\u0005I\u0016A\u0002\u001a/cEr\u0003\u0007")
public interface ObservableSet<A>
extends Set<A>,
Publisher<Message<A>> {
    public /* synthetic */ ObservableSet scala$collection$mutable$ObservableSet$$super$$plus$eq(Object var1);

    public /* synthetic */ ObservableSet scala$collection$mutable$ObservableSet$$super$$minus$eq(Object var1);

    public /* synthetic */ void scala$collection$mutable$ObservableSet$$super$clear();

    public static /* synthetic */ ObservableSet $plus$eq$(ObservableSet $this, Object elem) {
        return $this.$plus$eq((A)elem);
    }

    @Override
    default public ObservableSet<A> $plus$eq(A elem) {
        if (!this.contains(elem)) {
            this.scala$collection$mutable$ObservableSet$$super$$plus$eq(elem);
            this.publish(new Undoable(this, elem){
                private final /* synthetic */ ObservableSet $outer;

                public void undo() {
                    this.$outer.$minus$eq(this.elem());
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    super(elem$1);
                }
            });
        }
        return this;
    }

    public static /* synthetic */ ObservableSet $minus$eq$(ObservableSet $this, Object elem) {
        return $this.$minus$eq(elem);
    }

    @Override
    default public ObservableSet<A> $minus$eq(A elem) {
        if (this.contains(elem)) {
            this.scala$collection$mutable$ObservableSet$$super$$minus$eq(elem);
            this.publish(new Undoable(this, elem){
                private final /* synthetic */ ObservableSet $outer;

                public void undo() {
                    this.$outer.$plus$eq(this.elem());
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    super(elem$2);
                }
            });
        }
        return this;
    }

    public static /* synthetic */ void clear$(ObservableSet $this) {
        $this.clear();
    }

    @Override
    default public void clear() {
        this.scala$collection$mutable$ObservableSet$$super$clear();
        this.publish(new Undoable(null){

            public void undo() {
                throw new UnsupportedOperationException("cannot undo");
            }
        });
    }

    public static void $init$(ObservableSet $this) {
    }
}

