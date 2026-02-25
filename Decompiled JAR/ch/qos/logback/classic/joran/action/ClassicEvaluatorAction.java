/*
 * Decompiled with CFR 0.152.
 */
package ch.qos.logback.classic.joran.action;

import ch.qos.logback.classic.boolex.JaninoEventEvaluator;
import ch.qos.logback.core.joran.action.EventEvaluatorAction;

public class ClassicEvaluatorAction
extends EventEvaluatorAction {
    protected String defaultClassName() {
        return JaninoEventEvaluator.class.getName();
    }
}

