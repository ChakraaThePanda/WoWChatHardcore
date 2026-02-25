/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.Function1;
import scala.collection.Iterator;
import scala.collection.immutable.List;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001U3Q!\u0003\u0006\u0002\u0002MAQ!\u0007\u0001\u0005\u0002iAQ!\n\u0001\u0007\u0002\u0019BQ!\u000b\u0001\u0007\u0002)BQa\f\u0001\u0007\u0002ABQ\u0001\u000f\u0001\u0005\u0002eBQa\u0012\u0001\u0005\u0002!CQ!\u0014\u0001\u0005\u00029CQ\u0001\u0015\u0001\u0005\u0002E\u00131aU3u\u0015\tYA\"\u0001\u0003vi&d'BA\u0007\u000f\u0003!Ig\u000e^3s]\u0006d'BA\b\u0011\u0003\u001d\u0011XM\u001a7fGRT\u0011!E\u0001\u0006g\u000e\fG.Y\u0002\u0001+\t!rd\u0005\u0002\u0001+A\u0011acF\u0007\u0002!%\u0011\u0001\u0004\u0005\u0002\u0007\u0003:L(+\u001a4\u0002\rqJg.\u001b;?)\u0005Y\u0002c\u0001\u000f\u0001;5\t!\u0002\u0005\u0002\u001f?1\u0001A!\u0002\u0011\u0001\u0005\u0004\t#!\u0001+\u0012\u0005\t*\u0002C\u0001\f$\u0013\t!\u0003CA\u0004O_RD\u0017N\\4\u0002\u0013\u0019Lg\u000eZ#oiJLHCA\u000f(\u0011\u0015A#\u00011\u0001\u001e\u0003\u0005A\u0018\u0001C1eI\u0016sGO]=\u0015\u0005-r\u0003C\u0001\f-\u0013\ti\u0003C\u0001\u0003V]&$\b\"\u0002\u0015\u0004\u0001\u0004i\u0012\u0001C5uKJ\fGo\u001c:\u0016\u0003E\u00022AM\u001b\u001e\u001d\t12'\u0003\u00025!\u00059\u0001/Y2lC\u001e,\u0017B\u0001\u001c8\u0005!IE/\u001a:bi>\u0014(B\u0001\u001b\u0011\u0003\u001d1wN]3bG\",\"AO!\u0015\u0005-Z\u0004\"\u0002\u001f\u0006\u0001\u0004i\u0014!\u00014\u0011\tYqT\u0004Q\u0005\u0003\u007fA\u0011\u0011BR;oGRLwN\\\u0019\u0011\u0005y\tE!\u0002\"\u0006\u0005\u0004\u0019%!A+\u0012\u0005\t\"\u0005C\u0001\fF\u0013\t1\u0005CA\u0002B]f\fQ!\u00199qYf$\"!\u0013'\u0011\u0005YQ\u0015BA&\u0011\u0005\u001d\u0011un\u001c7fC:DQ\u0001\u000b\u0004A\u0002u\t\u0001bY8oi\u0006Lgn\u001d\u000b\u0003\u0013>CQ\u0001K\u0004A\u0002u\ta\u0001^8MSN$X#\u0001*\u0011\u0007I\u001aV$\u0003\u0002Uo\t!A*[:u\u0001")
public abstract class Set<T> {
    public abstract T findEntry(T var1);

    public abstract void addEntry(T var1);

    public abstract Iterator<T> iterator();

    public <U> void foreach(Function1<T, U> f) {
        this.iterator().foreach(f);
    }

    public boolean apply(T x) {
        return this.contains(x);
    }

    public boolean contains(T x) {
        return this.findEntry(x) != null;
    }

    public List<T> toList() {
        return this.iterator().toList();
    }
}

