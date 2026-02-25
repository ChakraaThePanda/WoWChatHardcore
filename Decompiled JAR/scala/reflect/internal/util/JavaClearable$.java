/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Map;
import scala.reflect.internal.util.JavaClearable;

public final class JavaClearable$ {
    public static JavaClearable$ MODULE$;

    static {
        new JavaClearable$();
    }

    public <T extends Collection<?>> JavaClearable<T> forCollection(T data) {
        return new JavaClearable.JavaClearableCollection<T>(new WeakReference<T>(data));
    }

    public <T extends Map<?, ?>> JavaClearable<T> forMap(T data) {
        return new JavaClearable.JavaClearableMap<T>(new WeakReference<T>(data));
    }

    private JavaClearable$() {
        MODULE$ = this;
    }
}

