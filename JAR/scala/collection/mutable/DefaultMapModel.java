/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.mutable.DefaultEntry;
import scala.collection.mutable.Map;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00014qAC\u0006\u0011\u0002\u0007\u0005!\u0003C\u0003+\u0001\u0011\u00051&\u0002\u00030\u0001\u0001\u0001\u0004\"B\u001a\u0001\r#!\u0004\"B\u001d\u0001\r#Q\u0004\"B\u001f\u0001\r#q\u0004\"B\"\u0001\t\u0003!\u0005\"B%\u0001\t\u0003R\u0005\"\u0002(\u0001\t\u0003y\u0005\"B+\u0001\t\u00031&a\u0004#fM\u0006,H\u000e^'ba6{G-\u001a7\u000b\u00051i\u0011aB7vi\u0006\u0014G.\u001a\u0006\u0003\u001d=\t!bY8mY\u0016\u001cG/[8o\u0015\u0005\u0001\u0012!B:dC2\f7\u0001A\u000b\u0004'yA3c\u0001\u0001\u00151A\u0011QCF\u0007\u0002\u001f%\u0011qc\u0004\u0002\u0007\u0003:L(+\u001a4\u0011\teQBdJ\u0007\u0002\u0017%\u00111d\u0003\u0002\u0004\u001b\u0006\u0004\bCA\u000f\u001f\u0019\u0001!Qa\b\u0001C\u0002\u0001\u0012\u0011!Q\t\u0003C\u0011\u0002\"!\u0006\u0012\n\u0005\rz!a\u0002(pi\"Lgn\u001a\t\u0003+\u0015J!AJ\b\u0003\u0007\u0005s\u0017\u0010\u0005\u0002\u001eQ\u0011)\u0011\u0006\u0001b\u0001A\t\t!)\u0001\u0004%S:LG\u000f\n\u000b\u0002YA\u0011Q#L\u0005\u0003]=\u0011A!\u00168ji\n)QI\u001c;ssB!\u0011$\r\u000f(\u0013\t\u00114B\u0001\u0007EK\u001a\fW\u000f\u001c;F]R\u0014\u00180A\u0005gS:$WI\u001c;ssR\u0011Qg\u000e\t\u0003m\ti\u0011\u0001\u0001\u0005\u0006q\r\u0001\r\u0001H\u0001\u0004W\u0016L\u0018\u0001C1eI\u0016sGO]=\u0015\u00051Z\u0004\"\u0002\u001f\u0005\u0001\u0004)\u0014!A3\u0002\u000f\u0015tGO]5fgV\tq\bE\u0002A\u0003Vj\u0011!D\u0005\u0003\u00056\u0011\u0001\"\u0013;fe\u0006$xN]\u0001\u0004O\u0016$HCA#I!\r)biJ\u0005\u0003\u000f>\u0011aa\u00149uS>t\u0007\"\u0002\u001d\u0007\u0001\u0004a\u0012a\u00019viR\u0019Qi\u0013'\t\u000ba:\u0001\u0019\u0001\u000f\t\u000b5;\u0001\u0019A\u0014\u0002\u000bY\fG.^3\u0002\u0011\u0011\u0002H.^:%KF$\"A\u000e)\t\u000bEC\u0001\u0019\u0001*\u0002\u0005-4\b\u0003B\u000bT9\u001dJ!\u0001V\b\u0003\rQ+\b\u000f\\33\u0003!IG/\u001a:bi>\u0014X#A,\u0011\u0007\u0001\u000b%\u000b\u000b\u0003\u00013rs\u0006CA\u000b[\u0013\tYvB\u0001\u0006eKB\u0014XmY1uK\u0012\f\u0013!X\u0001\u001bi\"L7\u000f\t;sC&$\be^5mY\u0002\u0012W\r\t:f[>4X\rZ\u0011\u0002?\u00061!GL\u00192]A\u0002")
public interface DefaultMapModel<A, B>
extends Map<A, B> {
    public DefaultEntry<A, B> findEntry(A var1);

    public void addEntry(DefaultEntry<A, B> var1);

    public Iterator<DefaultEntry<A, B>> entries();

    public static /* synthetic */ Option get$(DefaultMapModel $this, Object key) {
        return $this.get((A)key);
    }

    @Override
    default public Option<B> get(A key) {
        DefaultEntry<A, B> e = this.findEntry(key);
        if (e == null) {
            return None$.MODULE$;
        }
        return new Some<B>(e.value());
    }

    public static /* synthetic */ Option put$(DefaultMapModel $this, Object key, Object value) {
        return $this.put((A)key, (B)value);
    }

    @Override
    default public Option<B> put(A key, B value) {
        DefaultEntry<A, B> e = this.findEntry(key);
        if (e == null) {
            this.addEntry(new DefaultEntry<A, B>(key, value));
            return None$.MODULE$;
        }
        B v = e.value();
        e.value_$eq(value);
        return new Some<B>(v);
    }

    public static /* synthetic */ DefaultMapModel $plus$eq$(DefaultMapModel $this, Tuple2 kv) {
        return $this.$plus$eq(kv);
    }

    @Override
    default public DefaultMapModel<A, B> $plus$eq(Tuple2<A, B> kv) {
        this.put(kv._1(), kv._2());
        return this;
    }

    public static /* synthetic */ Iterator iterator$(DefaultMapModel $this) {
        return $this.iterator();
    }

    @Override
    default public Iterator<Tuple2<A, B>> iterator() {
        return this.entries().map((Function1<DefaultEntry, Tuple2> & java.io.Serializable & Serializable)e -> new Tuple2(e.key(), e.value()));
    }

    public static void $init$(DefaultMapModel $this) {
    }
}

