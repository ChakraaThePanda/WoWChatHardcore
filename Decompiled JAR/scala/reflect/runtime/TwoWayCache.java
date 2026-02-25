/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.runtime;

import java.lang.ref.WeakReference;
import scala.Function0;
import scala.Option;
import scala.collection.mutable.WeakHashMap;
import scala.reflect.ScalaSignature;
import scala.reflect.runtime.TwoWayCache$SomeRef$;

@ScalaSignature(bytes="\u0006\u0001M4Q!\u0004\b\u0001\u001dQAQA\u0007\u0001\u0005\u0002qAq!\f\u0001C\u0002\u0013%a\u0006\u0003\u0004B\u0001\u0001\u0006Ia\f\u0005\b\u0005\u0002\u0011\r\u0011\"\u0003D\u0011\u00191\u0005\u0001)A\u0005\t\")q\t\u0001C\u0001\u0011\u001e)\u0001\u000b\u0001E\u0005#\u001a)1\u000b\u0001E\u0005)\")!\u0004\u0003C\u0001+\")a\u000b\u0003C\u0001/\")1\r\u0001C\u0001I\")Q\u000e\u0001C\u0001]\nYAk^8XCf\u001c\u0015m\u00195f\u0015\ty\u0001#A\u0004sk:$\u0018.\\3\u000b\u0005E\u0011\u0012a\u0002:fM2,7\r\u001e\u0006\u0002'\u0005)1oY1mCV\u0019Q#I\u0016\u0014\u0005\u00011\u0002CA\f\u0019\u001b\u0005\u0011\u0012BA\r\u0013\u0005\u0019\te.\u001f*fM\u00061A(\u001b8jiz\u001a\u0001\u0001F\u0001\u001e!\u0011q\u0002a\b\u0016\u000e\u00039\u0001\"\u0001I\u0011\r\u0001\u0011)!\u0005\u0001b\u0001G\t\t!*\u0005\u0002%OA\u0011q#J\u0005\u0003MI\u0011qAT8uQ&tw\r\u0005\u0002\u0018Q%\u0011\u0011F\u0005\u0002\u0004\u0003:L\bC\u0001\u0011,\t\u0015a\u0003A1\u0001$\u0005\u0005\u0019\u0016A\u0003;p'\u000e\fG.Y'baV\tq\u0006\u0005\u00031k}9T\"A\u0019\u000b\u0005I\u001a\u0014aB7vi\u0006\u0014G.\u001a\u0006\u0003iI\t!bY8mY\u0016\u001cG/[8o\u0013\t1\u0014GA\u0006XK\u0006\\\u0007*Y:i\u001b\u0006\u0004\bc\u0001\u001d@U5\t\u0011H\u0003\u0002;w\u0005\u0019!/\u001a4\u000b\u0005qj\u0014\u0001\u00027b]\u001eT\u0011AP\u0001\u0005U\u00064\u0018-\u0003\u0002As\tiq+Z1l%\u00164WM]3oG\u0016\f1\u0002^8TG\u0006d\u0017-T1qA\u0005IAo\u001c&bm\u0006l\u0015\r]\u000b\u0002\tB!\u0001'\u000e\u0016F!\rAthH\u0001\u000bi>T\u0015M^1NCB\u0004\u0013!B3oi\u0016\u0014HcA%M\u001dB\u0011qCS\u0005\u0003\u0017J\u0011A!\u00168ji\")QJ\u0002a\u0001?\u0005\t!\u000eC\u0003P\r\u0001\u0007!&A\u0001t\u0003\u001d\u0019v.\\3SK\u001a\u0004\"A\u0015\u0005\u000e\u0003\u0001\u0011qaU8nKJ+gm\u0005\u0002\t-Q\t\u0011+A\u0004v]\u0006\u0004\b\u000f\\=\u0016\u0005akFCA-`!\r9\"\fX\u0005\u00037J\u0011aa\u00149uS>t\u0007C\u0001\u0011^\t\u0015q&B1\u0001$\u0005\u0005!\u0006\"\u00021\u000b\u0001\u0004\t\u0017AB8qiJ+g\rE\u0002\u00185\n\u00042\u0001O ]\u0003\u001d!xnU2bY\u0006$\"!Z6\u0015\u0005)2\u0007BB4\f\t\u0003\u0007\u0001.\u0001\u0003c_\u0012L\bcA\fjU%\u0011!N\u0005\u0002\ty\tLh.Y7f}!)An\u0003a\u0001?\u0005\u00191.Z=\u0002\rQ|'*\u0019<b)\ty'\u000f\u0006\u0002 a\"1q\r\u0004CA\u0002E\u00042aF5 \u0011\u0015aG\u00021\u0001+\u0001")
public class TwoWayCache<J, S> {
    private volatile TwoWayCache$SomeRef$ SomeRef$module;
    private final WeakHashMap<J, WeakReference<S>> toScalaMap = new WeakHashMap();
    private final WeakHashMap<S, WeakReference<J>> toJavaMap = new WeakHashMap();

    private TwoWayCache$SomeRef$ SomeRef() {
        if (this.SomeRef$module == null) {
            this.SomeRef$lzycompute$1();
        }
        return this.SomeRef$module;
    }

    private WeakHashMap<J, WeakReference<S>> toScalaMap() {
        return this.toScalaMap;
    }

    private WeakHashMap<S, WeakReference<J>> toJavaMap() {
        return this.toJavaMap;
    }

    public synchronized void enter(J j, S s) {
        this.toScalaMap().update(j, new WeakReference<S>(s));
        this.toJavaMap().update(s, new WeakReference<J>(j));
    }

    public synchronized S toScala(J key, Function0<S> body) {
        Object object;
        Option option = this.toScalaMap().get(key);
        Option option2 = this.SomeRef().unapply(option);
        if (!option2.isEmpty()) {
            object = option2.get();
        } else {
            S result2 = body.apply();
            this.enter(key, result2);
            object = result2;
        }
        return (S)object;
    }

    public synchronized J toJava(S key, Function0<J> body) {
        Object object;
        Option option = this.toJavaMap().get(key);
        Option option2 = this.SomeRef().unapply(option);
        if (!option2.isEmpty()) {
            object = option2.get();
        } else {
            J result2 = body.apply();
            this.enter(result2, key);
            object = result2;
        }
        return (J)object;
    }

    private final void SomeRef$lzycompute$1() {
        synchronized (this) {
            if (this.SomeRef$module == null) {
                this.SomeRef$module = new TwoWayCache$SomeRef$(this);
            }
            return;
        }
    }
}

