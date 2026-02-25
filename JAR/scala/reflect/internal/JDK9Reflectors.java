/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.jar.JarFile;

public final class JDK9Reflectors {
    private static final MethodHandle RUNTIME_VERSION_PARSE = JDK9Reflectors.lookupRuntimeVersionParse();
    private static final MethodHandle RUNTIME_VERSION = JDK9Reflectors.lookupRuntimeVersion();
    private static final MethodHandle RUNTIME_VERSION_MAJOR = JDK9Reflectors.lookupRuntimeVersionMajor();
    private static final MethodHandle NEW_JAR_FILE = JDK9Reflectors.lookupNewJarFile();

    public static Object runtimeVersionParse(String string) {
        try {
            return RUNTIME_VERSION_PARSE == null ? null : RUNTIME_VERSION_PARSE.invoke(string);
        }
        catch (Throwable t) {
            return null;
        }
    }

    public static Object runtimeVersion() {
        try {
            return RUNTIME_VERSION == null ? null : RUNTIME_VERSION.invoke();
        }
        catch (Throwable t) {
            return null;
        }
    }

    public static Integer runtimeVersionMajor(Object version) {
        try {
            return RUNTIME_VERSION_MAJOR == null ? null : Integer.valueOf(RUNTIME_VERSION_MAJOR.invoke(version));
        }
        catch (Throwable t) {
            return null;
        }
    }

    public static JarFile newJarFile(File file, boolean verify, int mode, Object version) throws IOException {
        try {
            if (version == null) {
                return new JarFile(file, verify, mode);
            }
            return NEW_JAR_FILE == null ? null : NEW_JAR_FILE.invoke(file, verify, mode, version);
        }
        catch (IOException | IllegalArgumentException | SecurityException ex) {
            throw ex;
        }
        catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static MethodHandle lookupRuntimeVersionParse() {
        try {
            return MethodHandles.lookup().findStatic(JDK9Reflectors.runtimeVersionClass(), "parse", MethodType.methodType(JDK9Reflectors.runtimeVersionClass(), String.class));
        }
        catch (Throwable t) {
            return null;
        }
    }

    private static MethodHandle lookupRuntimeVersion() {
        try {
            return MethodHandles.lookup().findStatic(Runtime.class, "version", MethodType.methodType(JDK9Reflectors.runtimeVersionClass()));
        }
        catch (Throwable t) {
            return null;
        }
    }

    private static MethodHandle lookupRuntimeVersionMajor() {
        try {
            return MethodHandles.lookup().findVirtual(JDK9Reflectors.runtimeVersionClass(), "major", MethodType.methodType(Integer.TYPE));
        }
        catch (Throwable t) {
            return null;
        }
    }

    private static MethodHandle lookupNewJarFile() {
        try {
            return MethodHandles.lookup().findConstructor(JarFile.class, MethodType.methodType(Void.TYPE, File.class, Boolean.TYPE, Integer.TYPE, JDK9Reflectors.runtimeVersionClass()));
        }
        catch (Throwable t) {
            return null;
        }
    }

    private static Class<?> runtimeVersionClass() throws ClassNotFoundException {
        return Class.forName("java.lang.Runtime$Version");
    }
}

