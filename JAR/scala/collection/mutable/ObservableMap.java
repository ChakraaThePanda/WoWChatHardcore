/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Some;
import scala.Tuple2;
import scala.collection.mutable.Map;
import scala.collection.mutable.Publisher;
import scala.collection.mutable.Undoable;
import scala.collection.script.Message;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00054q!\u0003\u0006\u0011\u0002\u0007\u0005\u0011\u0003C\u0003<\u0001\u0011\u0005A\bB\u0003A\u0001\t\u0005\u0011\t\u0003\u0004D\u0001A%\t\u0001\u0012\u0005\u0007\u0011\u0002\u0001J\u0011A%\t\r1\u0003\u0001\u0013\"\u0001=\u0011-i\u0005\u0001%A\u0002\u0002\u0003%IA\u0014)\t\u0017M\u0003\u0001\u0013aA\u0001\u0002\u0013%AK\u0016\u0005\f/\u0002\u0001\n1!A\u0001\n\u0013a\u0004LA\u0007PEN,'O^1cY\u0016l\u0015\r\u001d\u0006\u0003\u00171\tq!\\;uC\ndWM\u0003\u0002\u000e\u001d\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003=\tQa]2bY\u0006\u001c\u0001!F\u0002\u0013;\u001d\u001aB\u0001A\n\u0018SA\u0011A#F\u0007\u0002\u001d%\u0011aC\u0004\u0002\u0007\u0003:L(+\u001a4\u0011\taI2DJ\u0007\u0002\u0015%\u0011!D\u0003\u0002\u0004\u001b\u0006\u0004\bC\u0001\u000f\u001e\u0019\u0001!QA\b\u0001C\u0002}\u0011\u0011!Q\t\u0003A\r\u0002\"\u0001F\u0011\n\u0005\tr!a\u0002(pi\"Lgn\u001a\t\u0003)\u0011J!!\n\b\u0003\u0007\u0005s\u0017\u0010\u0005\u0002\u001dO\u0011)\u0001\u0006\u0001b\u0001?\t\t!\tE\u0002\u0019U1J!a\u000b\u0006\u0003\u0013A+(\r\\5tQ\u0016\u0014(cA\u00170q\u0019!a\u0006\u0001\u0001-\u00051a$/\u001a4j]\u0016lWM\u001c;?!\r\u00014'N\u0007\u0002c)\u0011!\u0007D\u0001\u0007g\u000e\u0014\u0018\u000e\u001d;\n\u0005Q\n$aB'fgN\fw-\u001a\t\u0005)YZb%\u0003\u00028\u001d\t1A+\u001e9mKJ\u0002\"\u0001G\u001d\n\u0005iR!\u0001C+oI>\f'\r\\3\u0002\r\u0011Jg.\u001b;%)\u0005i\u0004C\u0001\u000b?\u0013\tydB\u0001\u0003V]&$(a\u0001)vEF\u0011\u0001E\u0011\t\u00051\u0001Yb%\u0001\u0005%a2,8\u000fJ3r)\t)e)D\u0001\u0001\u0011\u001595\u00011\u00016\u0003\tYg/A\u0005%[&tWo\u001d\u0013fcR\u0011QI\u0013\u0005\u0006\u0017\u0012\u0001\raG\u0001\u0004W\u0016L\u0018!B2mK\u0006\u0014\u0018AD:va\u0016\u0014H\u0005\n9mkN$S-\u001d\u000b\u0003\u000b>CQa\u0012\u0004A\u0002UJ!aQ)\n\u0005IS!aB'ba2K7.Z\u0001\u0010gV\u0004XM\u001d\u0013%[&tWo\u001d\u0013fcR\u0011Q)\u0016\u0005\u0006\u0017\u001e\u0001\raG\u0005\u0003\u0011F\u000b1b];qKJ$3\r\\3be&\u0011A*\u0015\u0015\u0005\u0001ikv\f\u0005\u0002\u00157&\u0011AL\u0004\u0002\u000bI\u0016\u0004(/Z2bi\u0016$\u0017%\u00010\u0002u=\u00147/\u001a:wC\ndWm\u001d\u0011be\u0016\u0004C-\u001a9sK\u000e\fG/\u001a3!E\u0016\u001c\u0017-^:fAM\u001c'/\u001b9uS:<\u0007%[:!I\u0016\u0004(/Z2bi\u0016$\u0017%\u00011\u0002\rIr\u0013'\r\u00181\u0001")
public interface ObservableMap<A, B>
extends Map<A, B>,
Publisher<Message<Tuple2<A, B>>> {
    public /* synthetic */ ObservableMap scala$collection$mutable$ObservableMap$$super$$plus$eq(Tuple2 var1);

    public /* synthetic */ ObservableMap scala$collection$mutable$ObservableMap$$super$$minus$eq(Object var1);

    public /* synthetic */ void scala$collection$mutable$ObservableMap$$super$clear();

    public static /* synthetic */ ObservableMap $plus$eq$(ObservableMap $this, Tuple2 kv) {
        return $this.$plus$eq(kv);
    }

    @Override
    default public ObservableMap<A, B> $plus$eq(Tuple2<A, B> kv) {
        if (kv == null) {
            throw new MatchError((Object)null);
        }
        A a = kv._1();
        B b = kv._2();
        Option option = this.get(a);
        if (None$.MODULE$.equals(option)) {
            this.scala$collection$mutable$ObservableMap$$super$$plus$eq(kv);
            this.publish(new Undoable(this, a, b){
                private final /* synthetic */ ObservableMap $outer;
                private final Object key$1;

                public void undo() {
                    this.$outer.$minus$eq(this.key$1);
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    this.key$1 = key$1;
                    super(new Tuple2<Object, Object>(key$1, value$1));
                }
            });
        } else if (option instanceof Some) {
            Object old = ((Some)option).value();
            this.scala$collection$mutable$ObservableMap$$super$$plus$eq(kv);
            this.publish(new Undoable(this, a, b, old){
                private final /* synthetic */ ObservableMap $outer;
                private final Object key$1;
                private final Object old$1;

                public void undo() {
                    this.$outer.$plus$eq(new Tuple2<Object, Object>(this.key$1, this.old$1));
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    this.key$1 = key$1;
                    this.old$1 = old$1;
                    super(new Tuple2<Object, Object>(key$1, value$1));
                }
            });
        } else {
            throw new MatchError(option);
        }
        return this;
    }

    public static /* synthetic */ ObservableMap $minus$eq$(ObservableMap $this, Object key) {
        return $this.$minus$eq((A)key);
    }

    default public ObservableMap<A, B> $minus$eq(A key) {
        Option option = this.get(key);
        if (!None$.MODULE$.equals(option)) {
            if (option instanceof Some) {
                Object old = ((Some)option).value();
                this.scala$collection$mutable$ObservableMap$$super$$minus$eq(key);
                this.publish(new Undoable(this, key, old){
                    private final /* synthetic */ ObservableMap $outer;
                    private final Object key$2;
                    private final Object old$2;

                    public void undo() {
                        this.$outer.update(this.key$2, this.old$2);
                    }
                    {
                        if ($outer == null) {
                            throw null;
                        }
                        this.$outer = $outer;
                        this.key$2 = key$2;
                        this.old$2 = old$2;
                        super(new Tuple2<Object, Object>(key$2, old$2));
                    }
                });
            } else {
                throw new MatchError(option);
            }
        }
        return this;
    }

    public static /* synthetic */ void clear$(ObservableMap $this) {
        $this.clear();
    }

    @Override
    default public void clear() {
        this.scala$collection$mutable$ObservableMap$$super$clear();
        this.publish(new Undoable(null){

            public void undo() {
                throw new UnsupportedOperationException("cannot undo");
            }
        });
    }

    public static void $init$(ObservableMap $this) {
    }
}

