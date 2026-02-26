/*
 * Decompiled with CFR 0.152.
 */
package scala.ref;

import scala.Function0;
import scala.None$;
import scala.Option;
import scala.Some;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001q2q\u0001C\u0005\u0011\u0002\u0007\u0005a\u0002C\u0003 \u0001\u0011\u0005\u0001\u0005C\u0003%\u0001\u0019\u0005Q\u0005C\u0003'\u0001\u0019\u0005q\u0005C\u0003,\u0001\u0011\u0005C\u0006C\u00036\u0001\u0019\u0005\u0001\u0005C\u00037\u0001\u0019\u0005q\u0007C\u0003<\u0001\u0019\u0005qGA\u0005SK\u001a,'/\u001a8dK*\u0011!bC\u0001\u0004e\u00164'\"\u0001\u0007\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011q\"G\n\u0004\u0001A!\u0002CA\t\u0013\u001b\u0005Y\u0011BA\n\f\u0005\u0019\te.\u001f*fMB\u0019\u0011#F\f\n\u0005YY!!\u0003$v]\u000e$\u0018n\u001c81!\tA\u0012\u0004\u0004\u0001\u0005\ri\u0001AQ1\u0001\u001c\u0005\u0005!\u0016C\u0001\u000f\u0011!\t\tR$\u0003\u0002\u001f\u0017\t9aj\u001c;iS:<\u0017A\u0002\u0013j]&$H\u0005F\u0001\"!\t\t\"%\u0003\u0002$\u0017\t!QK\\5u\u0003\u0015\t\u0007\u000f\u001d7z)\u00059\u0012aA4fiV\t\u0001\u0006E\u0002\u0012S]I!AK\u0006\u0003\r=\u0003H/[8o\u0003!!xn\u0015;sS:<G#A\u0017\u0011\u00059\u001aT\"A\u0018\u000b\u0005A\n\u0014\u0001\u00027b]\u001eT\u0011AM\u0001\u0005U\u00064\u0018-\u0003\u00025_\t11\u000b\u001e:j]\u001e\fQa\u00197fCJ\fq!\u001a8rk\u0016,X\rF\u00019!\t\t\u0012(\u0003\u0002;\u0017\t9!i\\8mK\u0006t\u0017AC5t\u000b:\fX/Z;fI\u0002")
public interface Reference<T>
extends Function0<T> {
    @Override
    public T apply();

    public Option<T> get();

    public static /* synthetic */ String toString$(Reference $this) {
        return $this.toString();
    }

    @Override
    default public String toString() {
        Option option;
        Option<T> option2 = this.get();
        if (option2 == null) {
            throw null;
        }
        Option<T> map_this = option2;
        Option option3 = option = map_this.isEmpty() ? None$.MODULE$ : new Some<String>(map_this.get().toString());
        if (option == null) {
            throw null;
        }
        return option.isEmpty() ? Reference.$anonfun$toString$2() : option.get();
    }

    public void clear();

    public boolean enqueue();

    public boolean isEnqueued();

    public static /* synthetic */ String $anonfun$toString$2() {
        return "<deleted>";
    }

    public static void $init$(Reference $this) {
    }
}

