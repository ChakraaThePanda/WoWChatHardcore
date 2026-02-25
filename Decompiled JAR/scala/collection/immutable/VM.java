/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

abstract class VM {
    static final MethodHandle RELEASE_FENCE = VM.mkHandle();

    static void releaseFence() throws Throwable {
        RELEASE_FENCE.invoke();
    }

    private VM() {
    }

    private static MethodHandle mkHandle() {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {
            return lookup.findStatic(Class.forName("java.lang.invoke.VarHandle"), "releaseFence", MethodType.methodType(Void.TYPE));
        }
        catch (ClassNotFoundException e) {
            try {
                Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
                return lookup.findVirtual(unsafeClass, "storeFence", MethodType.methodType(Void.TYPE)).bindTo(VM.findUnsafe(unsafeClass));
            }
            catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException e1) {
                ExceptionInInitializerError error = new ExceptionInInitializerError(e1);
                error.addSuppressed(e);
                throw error;
            }
        }
        catch (IllegalAccessException | NoSuchMethodException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private static Object findUnsafe(Class<?> unsafeClass) throws IllegalAccessException {
        Object found = null;
        for (Field field2 : unsafeClass.getDeclaredFields()) {
            if (field2.getType() != unsafeClass) continue;
            field2.setAccessible(true);
            found = field2.get(null);
            break;
        }
        if (found == null) {
            throw new IllegalStateException("No instance of Unsafe found");
        }
        return found;
    }
}

