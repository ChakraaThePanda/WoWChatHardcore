/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Unmodifiable
 */
package net.dv8tion.jda.api.hooks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.hooks.IEventManager;
import net.dv8tion.jda.api.hooks.SubscribeEvent;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.utils.ClassWalker;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.jetbrains.annotations.Unmodifiable;
import org.slf4j.Logger;

public class AnnotatedEventManager
implements IEventManager {
    private static final Logger LOGGER = JDALogger.getLog(AnnotatedEventManager.class);
    private final Set<Object> listeners = ConcurrentHashMap.newKeySet();
    private final Map<Class<?>, Map<Object, List<Method>>> methods = new ConcurrentHashMap();

    @Override
    public void register(@Nonnull Object listener) {
        if (listener.getClass().isArray()) {
            for (Object o : (Object[])listener) {
                this.register(o);
            }
            return;
        }
        if (this.listeners.add(listener)) {
            this.registerListenerMethods(listener);
        }
    }

    @Override
    public void unregister(@Nonnull Object listener) {
        if (listener.getClass().isArray()) {
            for (Object o : (Object[])listener) {
                this.unregister(o);
            }
            return;
        }
        if (this.listeners.remove(listener)) {
            this.updateMethods();
        }
    }

    @Override
    @Nonnull
    public @Unmodifiable List<Object> getRegisteredListeners() {
        return Collections.unmodifiableList(new ArrayList<Object>(this.listeners));
    }

    @Override
    public void handle(@Nonnull GenericEvent event) {
        for (Class<?> eventClass : ClassWalker.walk(event.getClass())) {
            Map<Object, List<Method>> listeners = this.methods.get(eventClass);
            if (listeners == null) continue;
            listeners.forEach((key, value) -> value.forEach(method -> {
                block3: {
                    try {
                        method.setAccessible(true);
                        method.invoke(key, event);
                    }
                    catch (IllegalAccessException | InvocationTargetException e1) {
                        JDAImpl.LOG.error("Couldn't access annotated EventListener method", e1);
                    }
                    catch (Throwable throwable) {
                        JDAImpl.LOG.error("One of the EventListeners had an uncaught exception", throwable);
                        if (!(throwable instanceof Error)) break block3;
                        throw (Error)throwable;
                    }
                }
            }));
        }
    }

    private void updateMethods() {
        this.methods.clear();
        for (Object listener : this.listeners) {
            this.registerListenerMethods(listener);
        }
    }

    private void registerListenerMethods(Object listener) {
        Method[] allMethods;
        boolean isClass = listener instanceof Class;
        Class<?> c = isClass ? (Class<?>)listener : listener.getClass();
        for (Method m : allMethods = c.getDeclaredMethods()) {
            if (!m.isAnnotationPresent(SubscribeEvent.class) || isClass && !Modifier.isStatic(m.getModifiers())) continue;
            Class<?>[] parameterTypes = m.getParameterTypes();
            if (parameterTypes.length != 1 || !GenericEvent.class.isAssignableFrom(parameterTypes[0])) {
                LOGGER.warn("Method '{}' annotated with @{} must have at most 1 parameter, which implements GenericEvent", (Object)m, (Object)SubscribeEvent.class.getSimpleName());
                continue;
            }
            Class<?> eventClass = parameterTypes[0];
            this.methods.computeIfAbsent(eventClass, k -> new ConcurrentHashMap()).computeIfAbsent(listener, k -> new CopyOnWriteArrayList()).add(m);
        }
    }
}

