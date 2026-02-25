/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent;

import scala.MatchError;
import scala.Tuple2;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.concurrent.SyncVar;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u000193AAC\u0006\u0001!!)a\u0003\u0001C\u0001/!9Q\u0005\u0001a\u0001\n\u00131\u0003b\u0002\u001d\u0001\u0001\u0004%I!\u000f\u0005\u0007\u007f\u0001\u0001\u000b\u0015B\u0014\t\u000f\u0001\u0003\u0001\u0019!C\u0005\u0003\"9A\t\u0001a\u0001\n\u0013)\u0005BB$\u0001A\u0003&!\tC\u0003I\u0001\u0011\u0005\u0011\nC\u0003M\u0001\u0011\u0005QJA\u0006Ts:\u001c7\t[1o]\u0016d'B\u0001\u0007\u000e\u0003)\u0019wN\\2veJ,g\u000e\u001e\u0006\u0002\u001d\u0005)1oY1mC\u000e\u0001QCA\t\u001d'\t\u0001!\u0003\u0005\u0002\u0014)5\tQ\"\u0003\u0002\u0016\u001b\t1\u0011I\\=SK\u001a\fa\u0001P5oSRtD#\u0001\r\u0011\u0007e\u0001!$D\u0001\f!\tYB\u0004\u0004\u0001\u0005\u000bu\u0001!\u0019\u0001\u0010\u0003\u0003\u0005\u000b\"a\b\u0012\u0011\u0005M\u0001\u0013BA\u0011\u000e\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"aE\u0012\n\u0005\u0011j!aA!os\u0006i\u0001/\u001a8eS:<wK]5uKN,\u0012a\n\t\u0004Q5zS\"A\u0015\u000b\u0005)Z\u0013!C5n[V$\u0018M\u00197f\u0015\taS\"\u0001\u0006d_2dWm\u0019;j_:L!AL\u0015\u0003\t1K7\u000f\u001e\t\u0005'AR\"'\u0003\u00022\u001b\t1A+\u001e9mKJ\u00022!G\u001a6\u0013\t!4BA\u0004Ts:\u001cg+\u0019:\u0011\u0005M1\u0014BA\u001c\u000e\u0005\u001d\u0011un\u001c7fC:\f\u0011\u0003]3oI&twm\u0016:ji\u0016\u001cx\fJ3r)\tQT\b\u0005\u0002\u0014w%\u0011A(\u0004\u0002\u0005+:LG\u000fC\u0004?\u0007\u0005\u0005\t\u0019A\u0014\u0002\u0007a$\u0013'\u0001\bqK:$\u0017N\\4Xe&$Xm\u001d\u0011\u0002\u0019A,g\u000eZ5oOJ+\u0017\rZ:\u0016\u0003\t\u00032\u0001K\u0017D!\rI2GG\u0001\u0011a\u0016tG-\u001b8h%\u0016\fGm]0%KF$\"A\u000f$\t\u000fy2\u0011\u0011!a\u0001\u0005\u0006i\u0001/\u001a8eS:<'+Z1eg\u0002\nQa\u001e:ji\u0016$\"A\u000f&\t\u000b-C\u0001\u0019\u0001\u000e\u0002\t\u0011\fG/Y\u0001\u0005e\u0016\fG-F\u0001\u001b\u0001")
public class SyncChannel<A> {
    private List<Tuple2<A, SyncVar<Object>>> pendingWrites = Nil$.MODULE$;
    private List<SyncVar<A>> pendingReads = Nil$.MODULE$;

    private List<Tuple2<A, SyncVar<Object>>> pendingWrites() {
        return this.pendingWrites;
    }

    private void pendingWrites_$eq(List<Tuple2<A, SyncVar<Object>>> x$1) {
        this.pendingWrites = x$1;
    }

    private List<SyncVar<A>> pendingReads() {
        return this.pendingReads;
    }

    private void pendingReads_$eq(List<SyncVar<A>> x$1) {
        this.pendingReads = x$1;
    }

    public void write(A data) {
        SyncVar<Boolean> writeReq = new SyncVar<Boolean>();
        synchronized (this) {
            if (!this.pendingReads().isEmpty()) {
                SyncVar<A> readReq = this.pendingReads().head();
                this.pendingReads_$eq((List)this.pendingReads().tail());
                readReq.put(data);
                writeReq.put(BoxesRunTime.boxToBoolean(true));
            } else {
                List<Tuple2<A, SyncVar<Object>>> list = this.pendingWrites();
                this.pendingWrites_$eq(new $colon$colon<Nothing$>((Nothing$)((Object)new Tuple2(data, writeReq)), Nil$.MODULE$).$colon$colon$colon(list));
            }
        }
        writeReq.get();
    }

    public A read() {
        SyncVar<A> readReq = new SyncVar<A>();
        synchronized (this) {
            if (!this.pendingWrites().isEmpty()) {
                Tuple2<A, SyncVar<Object>> tuple2 = this.pendingWrites().head();
                if (tuple2 == null) {
                    throw new MatchError((Object)null);
                }
                A a = tuple2._1();
                SyncVar<Object> syncVar = tuple2._2();
                SyncVar<Object> writeReq = syncVar;
                this.pendingWrites_$eq((List)this.pendingWrites().tail());
                writeReq.put(BoxesRunTime.boxToBoolean(true));
                readReq.put(a);
            } else {
                List<SyncVar<A>> list = this.pendingReads();
                this.pendingReads_$eq(new $colon$colon<Nothing$>((Nothing$)((Object)readReq), Nil$.MODULE$).$colon$colon$colon(list));
            }
        }
        return readReq.get();
    }
}

