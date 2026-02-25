/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import java.util.List;

public class PotentialCreator {
    private static final PropertyName[] NO_NAMES = new PropertyName[0];
    private final AnnotatedWithParams _creator;
    private final boolean _isAnnotated;
    private JsonCreator.Mode _creatorMode;
    private PropertyName[] _implicitParamNames;
    private PropertyName[] _explicitParamNames;
    private List<BeanPropertyDefinition> propertyDefs;

    public PotentialCreator(AnnotatedWithParams cr, JsonCreator.Mode cm) {
        this._creator = cr;
        this._isAnnotated = cm != null;
        this._creatorMode = cm == null ? JsonCreator.Mode.DEFAULT : cm;
    }

    public PotentialCreator overrideMode(JsonCreator.Mode mode) {
        this._creatorMode = mode;
        return this;
    }

    public void assignPropertyDefs(List<? extends BeanPropertyDefinition> propertyDefs) {
        this.propertyDefs = propertyDefs;
    }

    public PotentialCreator introspectParamNames(MapperConfig<?> config) {
        if (this._implicitParamNames != null) {
            return this;
        }
        int paramCount = this._creator.getParameterCount();
        if (paramCount == 0) {
            this._explicitParamNames = NO_NAMES;
            this._implicitParamNames = NO_NAMES;
            return this;
        }
        this._explicitParamNames = new PropertyName[paramCount];
        this._implicitParamNames = new PropertyName[paramCount];
        AnnotationIntrospector intr = config.getAnnotationIntrospector();
        for (int i = 0; i < paramCount; ++i) {
            PropertyName explName;
            AnnotatedParameter param2 = this._creator.getParameter(i);
            String rawImplName = intr.findImplicitPropertyName(param2);
            if (rawImplName != null && !rawImplName.isEmpty()) {
                this._implicitParamNames[i] = PropertyName.construct(rawImplName);
            }
            if ((explName = intr.findNameForDeserialization(param2)) == null || explName.isEmpty()) continue;
            this._explicitParamNames[i] = explName;
        }
        return this;
    }

    public PotentialCreator introspectParamNames(MapperConfig<?> config, PropertyName[] implicits) {
        if (this._implicitParamNames != null) {
            return this;
        }
        int paramCount = this._creator.getParameterCount();
        if (paramCount == 0) {
            this._explicitParamNames = NO_NAMES;
            this._implicitParamNames = NO_NAMES;
            return this;
        }
        this._explicitParamNames = new PropertyName[paramCount];
        this._implicitParamNames = implicits;
        AnnotationIntrospector intr = config.getAnnotationIntrospector();
        for (int i = 0; i < paramCount; ++i) {
            AnnotatedParameter param2 = this._creator.getParameter(i);
            PropertyName explName = intr.findNameForDeserialization(param2);
            if (explName == null || explName.isEmpty()) continue;
            this._explicitParamNames[i] = explName;
        }
        return this;
    }

    public boolean isAnnotated() {
        return this._isAnnotated;
    }

    public AnnotatedWithParams creator() {
        return this._creator;
    }

    public JsonCreator.Mode creatorMode() {
        return this._creatorMode;
    }

    public JsonCreator.Mode creatorModeOrDefault() {
        if (this._creatorMode == null) {
            return JsonCreator.Mode.DEFAULT;
        }
        return this._creatorMode;
    }

    public int paramCount() {
        return this._creator.getParameterCount();
    }

    public AnnotatedParameter param(int ix) {
        return this._creator.getParameter(ix);
    }

    public boolean hasExplicitNames() {
        int end = this._explicitParamNames.length;
        for (int i = 0; i < end; ++i) {
            if (this._explicitParamNames[i] == null) continue;
            return true;
        }
        return false;
    }

    public boolean hasNameFor(int ix) {
        return this._explicitParamNames[ix] != null || this._implicitParamNames[ix] != null;
    }

    public boolean hasNameOrInjectForAllParams(MapperConfig<?> config) {
        AnnotationIntrospector intr = config.getAnnotationIntrospector();
        int end = this._implicitParamNames.length;
        for (int i = 0; i < end; ++i) {
            if (this.hasNameFor(i) || intr != null && intr.findInjectableValue(this._creator.getParameter(i)) != null) continue;
            return false;
        }
        return true;
    }

    public PropertyName explicitName(int ix) {
        return this._explicitParamNames[ix];
    }

    public PropertyName implicitName(int ix) {
        return this._implicitParamNames[ix];
    }

    public String implicitNameSimple(int ix) {
        PropertyName pn = this._implicitParamNames[ix];
        return pn == null ? null : pn.getSimpleName();
    }

    public BeanPropertyDefinition[] propertyDefs() {
        if (this.propertyDefs == null || this.propertyDefs.isEmpty()) {
            return new BeanPropertyDefinition[0];
        }
        return this.propertyDefs.toArray(new BeanPropertyDefinition[this.propertyDefs.size()]);
    }

    public String toString() {
        return "(mode=" + (Object)((Object)this._creatorMode) + ")" + this._creator;
    }
}

