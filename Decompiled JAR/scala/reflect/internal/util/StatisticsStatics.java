/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import java.lang.invoke.MethodHandle;
import scala.reflect.internal.util.AlmostFinalValue;

public final class StatisticsStatics {
    private static final AlmostFinalValue COLD_STATS = new AlmostFinalValue(){

        @Override
        protected boolean initialValue() {
            return false;
        }
    };
    private static final AlmostFinalValue HOT_STATS = new AlmostFinalValue(){

        @Override
        protected boolean initialValue() {
            return false;
        }
    };
    private static final MethodHandle COLD_STATS_GETTER = COLD_STATS.createGetter();
    private static final MethodHandle HOT_STATS_GETTER = HOT_STATS.createGetter();

    public static boolean areSomeColdStatsEnabled() throws Throwable {
        return COLD_STATS_GETTER.invokeExact();
    }

    public static boolean areSomeHotStatsEnabled() throws Throwable {
        return HOT_STATS_GETTER.invokeExact();
    }

    public static void enableColdStats() throws Throwable {
        if (!StatisticsStatics.areSomeColdStatsEnabled()) {
            COLD_STATS.setValue(true);
        }
    }

    public static void disableColdStats() {
        COLD_STATS.setValue(false);
    }

    public static void enableHotStats() throws Throwable {
        if (!StatisticsStatics.areSomeHotStatsEnabled()) {
            HOT_STATS.setValue(true);
        }
    }

    public static void disableHotStats() {
        HOT_STATS.setValue(false);
    }
}

