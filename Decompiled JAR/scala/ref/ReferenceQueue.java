/*
 * Decompiled with CFR 0.152.
 */
package scala.ref;

import scala.None$;
import scala.Option;
import scala.Some;
import scala.ref.Reference;
import scala.ref.ReferenceWithWrapper;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001Q3A!\u0003\u0006\u0001\u001f!)Q\u0003\u0001C\u0001-!A\u0011\u0005\u0001b\u0001\n\u0003Q!\u0005\u0003\u00040\u0001\u0001\u0006Ia\t\u0005\u0006c\u0001!\tE\r\u0005\u0006o\u0001!\t\u0002\u000f\u0005\u0006\u0017\u0002!\t\u0001\u0014\u0005\u0006\u001b\u0002!\t\u0001\u0014\u0005\u0006\u001b\u0002!\tA\u0014\u0002\u000f%\u00164WM]3oG\u0016\fV/Z;f\u0015\tYA\"A\u0002sK\u001aT\u0011!D\u0001\u0006g\u000e\fG.Y\u0002\u0001+\t\u00012d\u0005\u0002\u0001#A\u0011!cE\u0007\u0002\u0019%\u0011A\u0003\u0004\u0002\u0007\u0003:L(+\u001a4\u0002\rqJg.\u001b;?)\u00059\u0002c\u0001\r\u000135\t!\u0002\u0005\u0002\u001b71\u0001AA\u0002\u000f\u0001\t\u000b\u0007QDA\u0001U#\tq\u0012\u0003\u0005\u0002\u0013?%\u0011\u0001\u0005\u0004\u0002\b\u001d>$\b.\u001b8h\u0003))h\u000eZ3sYfLgnZ\u000b\u0002GA\u0012A%\f\t\u0004K-bS\"\u0001\u0014\u000b\u0005-9#B\u0001\u0015*\u0003\u0011a\u0017M\\4\u000b\u0003)\nAA[1wC&\u0011\u0011B\n\t\u000355\"\u0011BL\u0002\u0002\u0002\u0003\u0005)\u0011\u0001\u0019\u0003\u0007}#\u0013'A\u0006v]\u0012,'\u000f\\=j]\u001e\u0004\u0013C\u0001\u0010\u001a\u0003!!xn\u0015;sS:<G#A\u001a\u0011\u0005Q*T\"A\u0014\n\u0005Y:#AB*ue&tw-A\u0004Xe\u0006\u0004\b/\u001a:\u0015\u0005ez\u0004c\u0001\n;y%\u00111\b\u0004\u0002\u0007\u001fB$\u0018n\u001c8\u0011\u0007ai\u0014$\u0003\u0002?\u0015\tI!+\u001a4fe\u0016t7-\u001a\u0005\u0006\u0001\u0016\u0001\r!Q\u0001\u0005UJ,g\r\r\u0002C\u000bB\u0019Qe\u0011#\n\u0005y2\u0003C\u0001\u000eF\t%1u(!A\u0001\u0002\u000b\u0005qIA\u0002`II\n\"A\b%\u0011\u0005II\u0015B\u0001&\r\u0005\r\te._\u0001\u0005a>dG.F\u0001:\u0003\u0019\u0011X-\\8wKR\u0011\u0011h\u0014\u0005\u0006!\"\u0001\r!U\u0001\bi&lWm\\;u!\t\u0011\"+\u0003\u0002T\u0019\t!Aj\u001c8h\u0001")
public class ReferenceQueue<T> {
    private final java.lang.ref.ReferenceQueue<? extends T> underlying = new java.lang.ref.ReferenceQueue();

    public java.lang.ref.ReferenceQueue<? extends T> underlying() {
        return this.underlying;
    }

    public String toString() {
        return this.underlying().toString();
    }

    public Option<Reference<T>> Wrapper(java.lang.ref.Reference<?> jref) {
        Option option = jref == null ? None$.MODULE$ : new Some(((ReferenceWithWrapper)((Object)jref)).wrapper());
        return option;
    }

    public Option<Reference<T>> poll() {
        return this.Wrapper(this.underlying().poll());
    }

    public Option<Reference<T>> remove() {
        return this.Wrapper(this.underlying().remove());
    }

    public Option<Reference<T>> remove(long timeout2) {
        return this.Wrapper(this.underlying().remove(timeout2));
    }
}

