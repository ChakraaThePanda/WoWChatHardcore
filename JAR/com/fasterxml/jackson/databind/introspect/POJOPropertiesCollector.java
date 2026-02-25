/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.ConstructorDetector;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.introspect.PotentialCreator;
import com.fasterxml.jackson.databind.introspect.PotentialCreators;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jdk14.JDK14Util;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.reflect.Modifier;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class POJOPropertiesCollector {
    protected final MapperConfig<?> _config;
    protected final AccessorNamingStrategy _accessorNaming;
    protected final boolean _forSerialization;
    protected final JavaType _type;
    protected final AnnotatedClass _classDef;
    protected final VisibilityChecker<?> _visibilityChecker;
    protected final AnnotationIntrospector _annotationIntrospector;
    protected final boolean _useAnnotations;
    protected final boolean _isRecordType;
    protected boolean _collected;
    protected LinkedHashMap<String, POJOPropertyBuilder> _properties;
    protected List<POJOPropertyBuilder> _creatorProperties;
    protected PotentialCreators _potentialCreators;
    protected Map<PropertyName, PropertyName> _fieldRenameMappings;
    protected LinkedList<AnnotatedMember> _anyGetters;
    protected LinkedList<AnnotatedMember> _anyGetterField;
    protected LinkedList<AnnotatedMethod> _anySetters;
    protected LinkedList<AnnotatedMember> _anySetterField;
    protected LinkedList<AnnotatedMember> _jsonKeyAccessors;
    protected LinkedList<AnnotatedMember> _jsonValueAccessors;
    protected HashSet<String> _ignoredPropertyNames;
    protected LinkedHashMap<Object, AnnotatedMember> _injectables;
    protected JsonFormat.Value _formatOverrides;

    protected POJOPropertiesCollector(MapperConfig<?> config, boolean forSerialization, JavaType type, AnnotatedClass classDef, AccessorNamingStrategy accessorNaming) {
        this._config = config;
        this._forSerialization = forSerialization;
        this._type = type;
        this._classDef = classDef;
        this._isRecordType = this._type.isRecordType();
        if (config.isAnnotationProcessingEnabled()) {
            this._useAnnotations = true;
            this._annotationIntrospector = this._config.getAnnotationIntrospector();
        } else {
            this._useAnnotations = false;
            this._annotationIntrospector = AnnotationIntrospector.nopInstance();
        }
        this._visibilityChecker = this._config.getDefaultVisibilityChecker(type.getRawClass(), classDef);
        this._accessorNaming = accessorNaming;
    }

    public MapperConfig<?> getConfig() {
        return this._config;
    }

    public JavaType getType() {
        return this._type;
    }

    public boolean isRecordType() {
        return this._isRecordType;
    }

    public AnnotatedClass getClassDef() {
        return this._classDef;
    }

    public AnnotationIntrospector getAnnotationIntrospector() {
        return this._annotationIntrospector;
    }

    public List<BeanPropertyDefinition> getProperties() {
        Map<String, POJOPropertyBuilder> props = this.getPropertyMap();
        return new ArrayList<BeanPropertyDefinition>(props.values());
    }

    public PotentialCreators getPotentialCreators() {
        if (!this._collected) {
            this.collectAll();
        }
        return this._potentialCreators;
    }

    public Map<Object, AnnotatedMember> getInjectables() {
        if (!this._collected) {
            this.collectAll();
        }
        return this._injectables;
    }

    public AnnotatedMember getJsonKeyAccessor() {
        if (!this._collected) {
            this.collectAll();
        }
        if (this._jsonKeyAccessors != null) {
            if (this._jsonKeyAccessors.size() > 1 && !this._resolveFieldVsGetter(this._jsonKeyAccessors)) {
                this.reportProblem("Multiple 'as-key' properties defined (%s vs %s)", this._jsonKeyAccessors.get(0), this._jsonKeyAccessors.get(1));
            }
            return this._jsonKeyAccessors.get(0);
        }
        return null;
    }

    public AnnotatedMember getJsonValueAccessor() {
        if (!this._collected) {
            this.collectAll();
        }
        if (this._jsonValueAccessors != null) {
            if (this._jsonValueAccessors.size() > 1 && !this._resolveFieldVsGetter(this._jsonValueAccessors)) {
                this.reportProblem("Multiple 'as-value' properties defined (%s vs %s)", this._jsonValueAccessors.get(0), this._jsonValueAccessors.get(1));
            }
            return this._jsonValueAccessors.get(0);
        }
        return null;
    }

    @Deprecated
    public AnnotatedMember getAnyGetter() {
        return this.getAnyGetterMethod();
    }

    public AnnotatedMember getAnyGetterField() {
        if (!this._collected) {
            this.collectAll();
        }
        if (this._anyGetterField != null) {
            if (this._anyGetterField.size() > 1) {
                this.reportProblem("Multiple 'any-getter' fields defined (%s vs %s)", this._anyGetterField.get(0), this._anyGetterField.get(1));
            }
            return this._anyGetterField.getFirst();
        }
        return null;
    }

    public AnnotatedMember getAnyGetterMethod() {
        if (!this._collected) {
            this.collectAll();
        }
        if (this._anyGetters != null) {
            if (this._anyGetters.size() > 1) {
                this.reportProblem("Multiple 'any-getter' methods defined (%s vs %s)", this._anyGetters.get(0), this._anyGetters.get(1));
            }
            return this._anyGetters.getFirst();
        }
        return null;
    }

    public AnnotatedMember getAnySetterField() {
        if (!this._collected) {
            this.collectAll();
        }
        if (this._anySetterField != null) {
            if (this._anySetterField.size() > 1) {
                this.reportProblem("Multiple 'any-setter' fields defined (%s vs %s)", this._anySetterField.get(0), this._anySetterField.get(1));
            }
            return this._anySetterField.getFirst();
        }
        return null;
    }

    public AnnotatedMethod getAnySetterMethod() {
        if (!this._collected) {
            this.collectAll();
        }
        if (this._anySetters != null) {
            if (this._anySetters.size() > 1) {
                this.reportProblem("Multiple 'any-setter' methods defined (%s vs %s)", this._anySetters.get(0), this._anySetters.get(1));
            }
            return this._anySetters.getFirst();
        }
        return null;
    }

    public Set<String> getIgnoredPropertyNames() {
        return this._ignoredPropertyNames;
    }

    public ObjectIdInfo getObjectIdInfo() {
        ObjectIdInfo info = this._annotationIntrospector.findObjectIdInfo(this._classDef);
        if (info != null) {
            info = this._annotationIntrospector.findObjectReferenceInfo(this._classDef, info);
        }
        return info;
    }

    protected Map<String, POJOPropertyBuilder> getPropertyMap() {
        if (!this._collected) {
            this.collectAll();
        }
        return this._properties;
    }

    public JsonFormat.Value getFormatOverrides() {
        if (this._formatOverrides == null) {
            JsonFormat.Value v;
            JsonFormat.Value format = null;
            if (this._annotationIntrospector != null) {
                format = this._annotationIntrospector.findFormat(this._classDef);
            }
            if ((v = this._config.getDefaultPropertyFormat(this._type.getRawClass())) != null) {
                format = format == null ? v : format.withOverrides(v);
            }
            this._formatOverrides = format == null ? JsonFormat.Value.empty() : format;
        }
        return this._formatOverrides;
    }

    protected void collectAll() {
        this._potentialCreators = new PotentialCreators();
        LinkedHashMap<String, POJOPropertyBuilder> props = new LinkedHashMap<String, POJOPropertyBuilder>();
        this._addFields(props);
        this._addMethods(props);
        if (!this._classDef.isNonStaticInnerClass()) {
            this._addCreators(props);
        }
        this._removeUnwantedProperties(props);
        this._removeUnwantedAccessors(props);
        this._renameProperties(props);
        this._addInjectables(props);
        for (POJOPropertyBuilder property : props.values()) {
            property.mergeAnnotations(this._forSerialization);
        }
        PropertyNamingStrategy naming = this._findNamingStrategy();
        if (naming != null) {
            this._renameUsing(props, naming);
        }
        for (POJOPropertyBuilder property : props.values()) {
            property.trimByVisibility();
        }
        if (this._isRecordType && !this._forSerialization) {
            for (POJOPropertyBuilder property : props.values()) {
                property.removeFields();
            }
        }
        if (this._config.isEnabled(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME)) {
            this._renameWithWrappers(props);
        }
        this._sortProperties(props);
        this._properties = props;
        this._collected = true;
    }

    protected void _addFields(Map<String, POJOPropertyBuilder> props) {
        AnnotationIntrospector ai = this._annotationIntrospector;
        boolean pruneFinalFields = !this._forSerialization && !this._config.isEnabled(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS);
        boolean transientAsIgnoral = this._config.isEnabled(MapperFeature.PROPAGATE_TRANSIENT_MARKER);
        for (AnnotatedField f : this._classDef.fields()) {
            boolean visible;
            PropertyName pn;
            boolean hasName;
            boolean nameExplicit;
            if (Boolean.TRUE.equals(ai.hasAsKey(this._config, f))) {
                if (this._jsonKeyAccessors == null) {
                    this._jsonKeyAccessors = new LinkedList();
                }
                this._jsonKeyAccessors.add(f);
            }
            if (Boolean.TRUE.equals(ai.hasAsValue(f))) {
                if (this._jsonValueAccessors == null) {
                    this._jsonValueAccessors = new LinkedList();
                }
                this._jsonValueAccessors.add(f);
                continue;
            }
            boolean anyGetter = Boolean.TRUE.equals(ai.hasAnyGetter(f));
            boolean anySetter = Boolean.TRUE.equals(ai.hasAnySetter(f));
            if (anyGetter || anySetter) {
                if (anyGetter) {
                    if (this._anyGetterField == null) {
                        this._anyGetterField = new LinkedList();
                    }
                    this._anyGetterField.add(f);
                }
                if (!anySetter) continue;
                if (this._anySetterField == null) {
                    this._anySetterField = new LinkedList();
                }
                this._anySetterField.add(f);
                continue;
            }
            String implName = ai.findImplicitPropertyName(f);
            if (implName == null) {
                implName = f.getName();
            }
            if ((implName = this._accessorNaming.modifyFieldName(f, implName)) == null) continue;
            PropertyName implNameP = this._propNameFromSimple(implName);
            PropertyName rename = ai.findRenameByField(this._config, f, implNameP);
            if (rename != null && !rename.equals(implNameP)) {
                if (this._fieldRenameMappings == null) {
                    this._fieldRenameMappings = new HashMap<PropertyName, PropertyName>();
                }
                this._fieldRenameMappings.put(rename, implNameP);
            }
            if ((nameExplicit = (hasName = (pn = this._forSerialization ? ai.findNameForSerialization(f) : ai.findNameForDeserialization(f)) != null)) && pn.isEmpty()) {
                pn = this._propNameFromSimple(implName);
                nameExplicit = false;
            }
            boolean bl = visible = pn != null;
            if (!visible) {
                visible = this._visibilityChecker.isFieldVisible(f);
            }
            boolean ignored = ai.hasIgnoreMarker(f);
            if (f.isTransient() && !hasName) {
                if (transientAsIgnoral) {
                    ignored = true;
                } else if (!ignored) continue;
            }
            if (pruneFinalFields && pn == null && !ignored && Modifier.isFinal(f.getModifiers())) continue;
            this._property(props, implName).addField(f, pn, nameExplicit, visible, ignored);
        }
    }

    protected void _addCreators(Map<String, POJOPropertyBuilder> props) {
        PotentialCreators creators = this._potentialCreators;
        List<PotentialCreator> constructors = this._collectCreators(this._classDef.getConstructors());
        List<PotentialCreator> factories = this._collectCreators(this._classDef.getFactoryMethods());
        PotentialCreator primaryCreator = this._isRecordType ? JDK14Util.findCanonicalRecordConstructor(this._config, this._classDef, constructors) : this._annotationIntrospector.findDefaultCreator(this._config, this._classDef, constructors, factories);
        this._removeDisabledCreators(constructors);
        this._removeDisabledCreators(factories);
        this._removeNonFactoryStaticMethods(factories, primaryCreator);
        if (this._useAnnotations) {
            this._addExplicitlyAnnotatedCreators(creators, constructors, props, false);
            this._addExplicitlyAnnotatedCreators(creators, factories, props, creators.hasPropertiesBased());
        }
        if (!creators.hasPropertiesBased()) {
            this._addCreatorsWithAnnotatedNames(creators, constructors, primaryCreator);
        }
        if (primaryCreator != null && (constructors.remove(primaryCreator) || factories.remove(primaryCreator))) {
            if (this._isDelegatingConstructor(primaryCreator)) {
                if (!creators.hasDelegating()) {
                    creators.addExplicitDelegating(primaryCreator);
                }
            } else if (!creators.hasPropertiesBased()) {
                creators.setPropertiesBased(this._config, primaryCreator, "Primary");
            }
        }
        ConstructorDetector ctorDetector = this._config.getConstructorDetector();
        if (!(creators.hasPropertiesBasedOrDelegating() || ctorDetector.requireCtorAnnotation() || this._classDef.getDefaultConstructor() != null && !ctorDetector.singleArgCreatorDefaultsToProperties())) {
            this._addImplicitConstructor(creators, constructors, props);
        }
        this._removeNonVisibleCreators(constructors);
        this._removeNonVisibleCreators(factories);
        creators.setImplicitDelegating(constructors, factories);
        PotentialCreator propsCtor = creators.propertiesBased;
        if (propsCtor == null) {
            this._creatorProperties = Collections.emptyList();
        } else {
            this._creatorProperties = new ArrayList<POJOPropertyBuilder>();
            this._addCreatorParams(props, propsCtor, this._creatorProperties);
        }
    }

    private boolean _isDelegatingConstructor(PotentialCreator ctor) {
        switch (ctor.creatorModeOrDefault()) {
            case DELEGATING: {
                return true;
            }
            case DISABLED: 
            case PROPERTIES: {
                return false;
            }
        }
        return ctor.paramCount() == 1 && this._jsonValueAccessors != null && !this._jsonValueAccessors.isEmpty();
    }

    private List<PotentialCreator> _collectCreators(List<? extends AnnotatedWithParams> ctors) {
        if (ctors.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList result2 = new ArrayList();
        for (AnnotatedWithParams annotatedWithParams : ctors) {
            JsonCreator.Mode creatorMode = this._useAnnotations ? this._annotationIntrospector.findCreatorAnnotation(this._config, annotatedWithParams) : null;
            result2.add(new PotentialCreator(annotatedWithParams, creatorMode));
        }
        return result2 == null ? Collections.emptyList() : result2;
    }

    private void _removeDisabledCreators(List<PotentialCreator> ctors) {
        Iterator<PotentialCreator> it = ctors.iterator();
        while (it.hasNext()) {
            if (it.next().creatorMode() != JsonCreator.Mode.DISABLED) continue;
            it.remove();
        }
    }

    private void _removeNonVisibleCreators(List<PotentialCreator> ctors) {
        Iterator<PotentialCreator> it = ctors.iterator();
        while (it.hasNext()) {
            PotentialCreator ctor = it.next();
            if (this._visibilityChecker.isCreatorVisible(ctor.creator())) continue;
            it.remove();
        }
    }

    private void _removeNonFactoryStaticMethods(List<PotentialCreator> ctors, PotentialCreator primaryCreator) {
        Class<?> rawType = this._type.getRawClass();
        Iterator<PotentialCreator> it = ctors.iterator();
        while (it.hasNext()) {
            Class<?> cls;
            String name;
            AnnotatedWithParams factory2;
            PotentialCreator ctor = it.next();
            if (ctor.isAnnotated() || primaryCreator == ctor || rawType.isAssignableFrom((factory2 = ctor.creator()).getRawType()) && ctor.paramCount() == 1 && ("valueOf".equals(name = factory2.getName()) || "fromString".equals(name) && ((cls = factory2.getRawParameterType(0)) == String.class || CharSequence.class.isAssignableFrom(cls)))) continue;
            it.remove();
        }
    }

    private void _addExplicitlyAnnotatedCreators(PotentialCreators collector, List<PotentialCreator> ctors, Map<String, POJOPropertyBuilder> props, boolean skipPropsBased) {
        ConstructorDetector ctorDetector = this._config.getConstructorDetector();
        Iterator<PotentialCreator> it = ctors.iterator();
        while (it.hasNext()) {
            boolean isPropsBased;
            PotentialCreator ctor = it.next();
            if (!ctor.isAnnotated()) continue;
            it.remove();
            switch (ctor.creatorMode()) {
                case DELEGATING: {
                    isPropsBased = false;
                    break;
                }
                case PROPERTIES: {
                    isPropsBased = true;
                    break;
                }
                default: {
                    isPropsBased = this._isExplicitlyAnnotatedCreatorPropsBased(ctor, props, ctorDetector);
                }
            }
            if (isPropsBased) {
                if (skipPropsBased) continue;
                collector.setPropertiesBased(this._config, ctor, "explicit");
                continue;
            }
            collector.addExplicitDelegating(ctor);
        }
    }

    private boolean _isExplicitlyAnnotatedCreatorPropsBased(PotentialCreator ctor, Map<String, POJOPropertyBuilder> props, ConstructorDetector ctorDetector) {
        if (ctor.paramCount() == 1) {
            switch (ctorDetector.singleArgMode()) {
                case DELEGATING: {
                    return false;
                }
                case PROPERTIES: {
                    return true;
                }
                case REQUIRE_MODE: {
                    throw new IllegalArgumentException(String.format("Single-argument constructor (%s) is annotated but no 'mode' defined; `ConstructorDetector`configured with `SingleArgConstructor.REQUIRE_MODE`", ctor.creator()));
                }
            }
        }
        ctor.introspectParamNames(this._config);
        if (ctor.hasExplicitNames()) {
            return true;
        }
        if (this._jsonValueAccessors != null && !this._jsonValueAccessors.isEmpty()) {
            return false;
        }
        if (ctor.paramCount() == 1) {
            PropertyName paramName = ctor.implicitName(0);
            if (paramName != null) {
                POJOPropertyBuilder prop = props.get(paramName.getSimpleName());
                if (prop != null) {
                    if (prop.anyVisible() && !prop.anyIgnorals()) {
                        return true;
                    }
                } else {
                    for (POJOPropertyBuilder pb : props.values()) {
                        if (!pb.anyVisible() || pb.anyIgnorals() || !pb.hasExplicitName(paramName)) continue;
                        return true;
                    }
                }
            }
            return this._annotationIntrospector != null && this._annotationIntrospector.findInjectableValue(ctor.param(0)) != null;
        }
        return ctor.hasNameOrInjectForAllParams(this._config);
    }

    private void _addCreatorsWithAnnotatedNames(PotentialCreators collector, List<PotentialCreator> ctors, PotentialCreator primaryCtor) {
        List<PotentialCreator> found = this._findCreatorsWithAnnotatedNames(ctors);
        if (primaryCtor != null && found.contains(primaryCtor)) {
            collector.setPropertiesBased(this._config, primaryCtor, "implicit");
            return;
        }
        for (PotentialCreator ctor : found) {
            collector.setPropertiesBased(this._config, ctor, "implicit");
        }
    }

    private List<PotentialCreator> _findCreatorsWithAnnotatedNames(List<PotentialCreator> ctors) {
        ArrayList<PotentialCreator> found = null;
        Iterator<PotentialCreator> it = ctors.iterator();
        while (it.hasNext()) {
            PotentialCreator ctor = it.next();
            ctor.introspectParamNames(this._config);
            if (!ctor.hasExplicitNames()) continue;
            it.remove();
            if (found == null) {
                found = new ArrayList<PotentialCreator>(4);
            }
            found.add(ctor);
        }
        return found == null ? Collections.emptyList() : found;
    }

    private boolean _addImplicitConstructor(PotentialCreators collector, List<PotentialCreator> ctors, Map<String, POJOPropertyBuilder> props) {
        if (ctors.size() != 1) {
            return false;
        }
        PotentialCreator ctor = ctors.get(0);
        if (!this._visibilityChecker.isCreatorVisible(ctor.creator())) {
            return false;
        }
        ctor.introspectParamNames(this._config);
        if (ctor.paramCount() != 1) {
            if (!ctor.hasNameOrInjectForAllParams(this._config)) {
                return false;
            }
        } else if (this._annotationIntrospector == null || this._annotationIntrospector.findInjectableValue(ctor.param(0)) == null) {
            POJOPropertyBuilder prop;
            ConstructorDetector ctorDetector = this._config.getConstructorDetector();
            if (ctorDetector.singleArgCreatorDefaultsToDelegating()) {
                return false;
            }
            String implicitParamName = ctor.implicitNameSimple(0);
            if (implicitParamName == null) {
                return false;
            }
            if (!(ctorDetector.singleArgCreatorDefaultsToProperties() || (prop = props.get(implicitParamName)) != null && prop.anyVisible() && !prop.anyIgnorals())) {
                return false;
            }
        }
        ctors.remove(0);
        collector.setPropertiesBased(this._config, ctor, "implicit");
        return true;
    }

    private void _addCreatorParams(Map<String, POJOPropertyBuilder> props, PotentialCreator ctor, List<POJOPropertyBuilder> creatorProps) {
        int paramCount = ctor.paramCount();
        for (int i = 0; i < paramCount; ++i) {
            POJOPropertyBuilder prop;
            boolean hasExplicit;
            AnnotatedParameter param2 = ctor.param(i);
            PropertyName explName = ctor.explicitName(i);
            PropertyName implName = ctor.implicitName(i);
            boolean bl = hasExplicit = explName != null;
            if (!hasExplicit && implName == null) {
                prop = null;
            } else {
                if (implName != null) {
                    String n = this._checkRenameByField(implName.getSimpleName());
                    implName = PropertyName.construct(n);
                }
                prop = implName == null ? this._property(props, explName) : this._property(props, implName);
                prop.addCtor(param2, hasExplicit ? explName : implName, hasExplicit, true, false);
            }
            creatorProps.add(prop);
        }
        ctor.assignPropertyDefs(creatorProps);
    }

    protected void _addMethods(Map<String, POJOPropertyBuilder> props) {
        for (AnnotatedMethod m : this._classDef.memberMethods()) {
            int argCount = m.getParameterCount();
            if (argCount == 0) {
                this._addGetterMethod(props, m, this._annotationIntrospector);
                continue;
            }
            if (argCount == 1) {
                this._addSetterMethod(props, m, this._annotationIntrospector);
                continue;
            }
            if (argCount != 2 || !Boolean.TRUE.equals(this._annotationIntrospector.hasAnySetter(m))) continue;
            if (this._anySetters == null) {
                this._anySetters = new LinkedList();
            }
            this._anySetters.add(m);
        }
    }

    protected void _addGetterMethod(Map<String, POJOPropertyBuilder> props, AnnotatedMethod m, AnnotationIntrospector ai) {
        boolean visible;
        String implName;
        boolean nameExplicit;
        Class<?> rt = m.getRawReturnType();
        if (rt == Void.TYPE || rt == Void.class && !this._config.isEnabled(MapperFeature.ALLOW_VOID_VALUED_PROPERTIES)) {
            return;
        }
        if (Boolean.TRUE.equals(ai.hasAnyGetter(m))) {
            if (this._anyGetters == null) {
                this._anyGetters = new LinkedList();
            }
            this._anyGetters.add(m);
            return;
        }
        if (Boolean.TRUE.equals(ai.hasAsKey(this._config, m))) {
            if (this._jsonKeyAccessors == null) {
                this._jsonKeyAccessors = new LinkedList();
            }
            this._jsonKeyAccessors.add(m);
            return;
        }
        if (Boolean.TRUE.equals(ai.hasAsValue(m))) {
            if (this._jsonValueAccessors == null) {
                this._jsonValueAccessors = new LinkedList();
            }
            this._jsonValueAccessors.add(m);
            return;
        }
        PropertyName pn = ai.findNameForSerialization(m);
        boolean bl = nameExplicit = pn != null;
        if (!nameExplicit) {
            implName = ai.findImplicitPropertyName(m);
            if (implName == null) {
                implName = this._accessorNaming.findNameForRegularGetter(m, m.getName());
            }
            if (implName == null) {
                implName = this._accessorNaming.findNameForIsGetter(m, m.getName());
                if (implName == null) {
                    return;
                }
                visible = this._visibilityChecker.isIsGetterVisible(m);
            } else {
                visible = this._visibilityChecker.isGetterVisible(m);
            }
        } else {
            implName = ai.findImplicitPropertyName(m);
            if (implName == null && (implName = this._accessorNaming.findNameForRegularGetter(m, m.getName())) == null) {
                implName = this._accessorNaming.findNameForIsGetter(m, m.getName());
            }
            if (implName == null) {
                implName = m.getName();
            }
            if (pn.isEmpty()) {
                pn = this._propNameFromSimple(implName);
                nameExplicit = false;
            }
            visible = true;
        }
        implName = this._checkRenameByField(implName);
        boolean ignore = ai.hasIgnoreMarker(m);
        this._property(props, implName).addGetter(m, pn, nameExplicit, visible, ignore);
    }

    protected void _addSetterMethod(Map<String, POJOPropertyBuilder> props, AnnotatedMethod m, AnnotationIntrospector ai) {
        boolean visible;
        String implName;
        boolean nameExplicit;
        PropertyName pn = ai.findNameForDeserialization(m);
        boolean bl = nameExplicit = pn != null;
        if (!nameExplicit) {
            implName = ai.findImplicitPropertyName(m);
            if (implName == null) {
                implName = this._accessorNaming.findNameForMutator(m, m.getName());
            }
            if (implName == null) {
                return;
            }
            visible = this._visibilityChecker.isSetterVisible(m);
        } else {
            implName = ai.findImplicitPropertyName(m);
            if (implName == null) {
                implName = this._accessorNaming.findNameForMutator(m, m.getName());
            }
            if (implName == null) {
                implName = m.getName();
            }
            if (pn.isEmpty()) {
                pn = this._propNameFromSimple(implName);
                nameExplicit = false;
            }
            visible = true;
        }
        implName = this._checkRenameByField(implName);
        boolean ignore = ai.hasIgnoreMarker(m);
        this._property(props, implName).addSetter(m, pn, nameExplicit, visible, ignore);
    }

    protected void _addInjectables(Map<String, POJOPropertyBuilder> props) {
        for (AnnotatedField f : this._classDef.fields()) {
            this._doAddInjectable(this._annotationIntrospector.findInjectableValue(f), f);
        }
        for (AnnotatedMethod m : this._classDef.memberMethods()) {
            if (m.getParameterCount() != 1) continue;
            this._doAddInjectable(this._annotationIntrospector.findInjectableValue(m), m);
        }
    }

    protected void _doAddInjectable(JacksonInject.Value injectable, AnnotatedMember m) {
        AnnotatedMember prev;
        if (injectable == null) {
            return;
        }
        Object id = injectable.getId();
        if (this._injectables == null) {
            this._injectables = new LinkedHashMap();
        }
        if ((prev = this._injectables.put(id, m)) != null && prev.getClass() == m.getClass()) {
            this.reportProblem("Duplicate injectable value with id '%s' (of type %s)", id, ClassUtil.classNameOf(id));
        }
    }

    private PropertyName _propNameFromSimple(String simpleName) {
        return PropertyName.construct(simpleName, null);
    }

    private String _checkRenameByField(String implName) {
        PropertyName p;
        if (this._fieldRenameMappings != null && (p = this._fieldRenameMappings.get(this._propNameFromSimple(implName))) != null) {
            implName = p.getSimpleName();
            return implName;
        }
        return implName;
    }

    protected void _removeUnwantedProperties(Map<String, POJOPropertyBuilder> props) {
        Iterator<POJOPropertyBuilder> it = props.values().iterator();
        while (it.hasNext()) {
            POJOPropertyBuilder prop = it.next();
            if (!prop.anyVisible()) {
                it.remove();
                continue;
            }
            if (!prop.anyIgnorals()) continue;
            if (this.isRecordType() && !this._forSerialization) {
                prop.removeIgnored();
                this._collectIgnorals(prop.getName());
                continue;
            }
            if (!prop.anyExplicitsWithoutIgnoral()) {
                it.remove();
                this._collectIgnorals(prop.getName());
                continue;
            }
            prop.removeIgnored();
            if (prop.couldDeserialize()) continue;
            this._collectIgnorals(prop.getName());
        }
    }

    protected void _removeUnwantedAccessors(Map<String, POJOPropertyBuilder> props) {
        boolean inferMutators = this._config.isEnabled(MapperFeature.INFER_PROPERTY_MUTATORS);
        for (POJOPropertyBuilder prop : props.values()) {
            prop.removeNonVisible(inferMutators, this._forSerialization ? null : this);
        }
    }

    protected void _collectIgnorals(String name) {
        if (!this._forSerialization && name != null) {
            if (this._ignoredPropertyNames == null) {
                this._ignoredPropertyNames = new HashSet();
            }
            this._ignoredPropertyNames.add(name);
        }
    }

    protected void _renameProperties(Map<String, POJOPropertyBuilder> props) {
        Iterator<Map.Entry<String, POJOPropertyBuilder>> it = props.entrySet().iterator();
        LinkedList<POJOPropertyBuilder> renamed = null;
        while (it.hasNext()) {
            Map.Entry<String, POJOPropertyBuilder> entry = it.next();
            POJOPropertyBuilder prop = entry.getValue();
            Set<PropertyName> l = prop.findExplicitNames();
            if (l.isEmpty()) continue;
            it.remove();
            if (renamed == null) {
                renamed = new LinkedList<POJOPropertyBuilder>();
            }
            if (l.size() == 1) {
                PropertyName n = (PropertyName)l.iterator().next();
                renamed.add(prop.withName(n));
                continue;
            }
            renamed.addAll(prop.explode(l));
        }
        if (renamed != null) {
            for (POJOPropertyBuilder prop : renamed) {
                String name = prop.getName();
                POJOPropertyBuilder old = props.get(name);
                if (old == null) {
                    props.put(name, prop);
                } else {
                    old.addAll(prop);
                }
                if (!this._replaceCreatorProperty(this._creatorProperties, prop) || this._ignoredPropertyNames == null) continue;
                this._ignoredPropertyNames.remove(name);
            }
        }
    }

    protected void _renameUsing(Map<String, POJOPropertyBuilder> propMap, PropertyNamingStrategy naming) {
        if (this._type.isEnumType() && this.getFormatOverrides().getShape() != JsonFormat.Shape.OBJECT) {
            return;
        }
        POJOPropertyBuilder[] props = propMap.values().toArray(new POJOPropertyBuilder[propMap.size()]);
        propMap.clear();
        for (POJOPropertyBuilder prop : props) {
            String simpleName;
            PropertyName fullName = prop.getFullName();
            String rename = null;
            if (!prop.isExplicitlyNamed() || this._config.isEnabled(MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING)) {
                if (this._forSerialization) {
                    if (prop.hasGetter()) {
                        rename = naming.nameForGetterMethod(this._config, prop.getGetter(), fullName.getSimpleName());
                    } else if (prop.hasField()) {
                        rename = naming.nameForField(this._config, prop.getField(), fullName.getSimpleName());
                    }
                } else if (prop.hasSetter()) {
                    rename = naming.nameForSetterMethod(this._config, prop.getSetterUnchecked(), fullName.getSimpleName());
                } else if (prop.hasConstructorParameter()) {
                    rename = naming.nameForConstructorParameter(this._config, prop.getConstructorParameter(), fullName.getSimpleName());
                } else if (prop.hasField()) {
                    rename = naming.nameForField(this._config, prop.getFieldUnchecked(), fullName.getSimpleName());
                } else if (prop.hasGetter()) {
                    rename = naming.nameForGetterMethod(this._config, prop.getGetterUnchecked(), fullName.getSimpleName());
                }
            }
            if (rename != null && !fullName.hasSimpleName(rename)) {
                prop = prop.withSimpleName(rename);
                simpleName = rename;
            } else {
                simpleName = fullName.getSimpleName();
            }
            POJOPropertyBuilder old = propMap.get(simpleName);
            if (old == null) {
                propMap.put(simpleName, prop);
            } else {
                old.addAll(prop);
            }
            this._replaceCreatorProperty(this._creatorProperties, prop);
        }
    }

    protected void _renameWithWrappers(Map<String, POJOPropertyBuilder> props) {
        Iterator<Map.Entry<String, POJOPropertyBuilder>> it = props.entrySet().iterator();
        LinkedList<POJOPropertyBuilder> renamed = null;
        while (it.hasNext()) {
            PropertyName wrapperName;
            Map.Entry<String, POJOPropertyBuilder> entry = it.next();
            POJOPropertyBuilder prop = entry.getValue();
            AnnotatedMember member = prop.getPrimaryMember();
            if (member == null || (wrapperName = this._annotationIntrospector.findWrapperName(member)) == null || !wrapperName.hasSimpleName() || wrapperName.equals(prop.getFullName())) continue;
            if (renamed == null) {
                renamed = new LinkedList<POJOPropertyBuilder>();
            }
            prop = prop.withName(wrapperName);
            renamed.add(prop);
            it.remove();
        }
        if (renamed != null) {
            for (POJOPropertyBuilder prop : renamed) {
                String name = prop.getName();
                POJOPropertyBuilder old = props.get(name);
                if (old == null) {
                    props.put(name, prop);
                    continue;
                }
                old.addAll(prop);
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    protected void _sortProperties(Map<String, POJOPropertyBuilder> props) {
        AnnotationIntrospector intr = this._annotationIntrospector;
        Boolean alpha = intr.findSerializationSortAlphabetically(this._classDef);
        boolean sortAlpha = alpha == null ? this._config.shouldSortPropertiesAlphabetically() : alpha.booleanValue();
        boolean indexed = this._anyIndexed(props.values());
        String[] propertyOrder = intr.findSerializationPropertyOrder(this._classDef);
        if (!sortAlpha && !indexed && this._creatorProperties == null && propertyOrder == null) {
            return;
        }
        int size = props.size();
        AbstractMap all = sortAlpha ? new TreeMap() : new LinkedHashMap(size + size);
        for (POJOPropertyBuilder pOJOPropertyBuilder : props.values()) {
            all.put(pOJOPropertyBuilder.getName(), pOJOPropertyBuilder);
        }
        LinkedHashMap<Object, POJOPropertyBuilder> ordered = new LinkedHashMap<Object, POJOPropertyBuilder>(size + size);
        if (propertyOrder != null) {
            for (String string : propertyOrder) {
                void var13_25;
                POJOPropertyBuilder w = (POJOPropertyBuilder)all.remove(string);
                if (w == null) {
                    for (POJOPropertyBuilder prop : props.values()) {
                        if (!string.equals(prop.getInternalName())) continue;
                        w = prop;
                        String string2 = prop.getName();
                        break;
                    }
                }
                if (w == null) continue;
                ordered.put(var13_25, w);
            }
        }
        if (indexed) {
            TreeMap<Integer, POJOPropertyBuilder> treeMap = new TreeMap<Integer, POJOPropertyBuilder>();
            Iterator it = all.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = it.next();
                POJOPropertyBuilder pOJOPropertyBuilder = (POJOPropertyBuilder)entry.getValue();
                Integer index = pOJOPropertyBuilder.getMetadata().getIndex();
                if (index == null) continue;
                treeMap.put(index, pOJOPropertyBuilder);
                it.remove();
            }
            for (POJOPropertyBuilder pOJOPropertyBuilder : treeMap.values()) {
                ordered.put(pOJOPropertyBuilder.getName(), pOJOPropertyBuilder);
            }
        }
        if (this._creatorProperties != null && (!sortAlpha || this._config.isEnabled(MapperFeature.SORT_CREATOR_PROPERTIES_FIRST))) {
            void var10_17;
            boolean sortCreatorPropsByAlpha;
            boolean bl = sortCreatorPropsByAlpha = sortAlpha && !this._config.isEnabled(MapperFeature.SORT_CREATOR_PROPERTIES_BY_DECLARATION_ORDER);
            if (sortCreatorPropsByAlpha) {
                TreeMap<String, POJOPropertyBuilder> sorted2 = new TreeMap<String, POJOPropertyBuilder>();
                for (POJOPropertyBuilder prop : this._creatorProperties) {
                    if (prop == null) continue;
                    sorted2.put(prop.getName(), prop);
                }
                Collection collection = sorted2.values();
            } else {
                List<POJOPropertyBuilder> list = this._creatorProperties;
            }
            for (POJOPropertyBuilder pOJOPropertyBuilder : var10_17) {
                String name;
                if (pOJOPropertyBuilder == null || !all.containsKey(name = pOJOPropertyBuilder.getName())) continue;
                ordered.put(name, pOJOPropertyBuilder);
            }
        }
        ordered.putAll(all);
        props.clear();
        props.putAll(ordered);
    }

    private boolean _anyIndexed(Collection<POJOPropertyBuilder> props) {
        for (POJOPropertyBuilder prop : props) {
            if (!prop.getMetadata().hasIndex()) continue;
            return true;
        }
        return false;
    }

    protected boolean _resolveFieldVsGetter(List<AnnotatedMember> accessors) {
        do {
            AnnotatedMember acc1 = accessors.get(0);
            AnnotatedMember acc2 = accessors.get(1);
            if (acc1 instanceof AnnotatedField) {
                if (acc2 instanceof AnnotatedMethod) {
                    accessors.remove(0);
                    continue;
                }
            } else if (acc1 instanceof AnnotatedMethod && acc2 instanceof AnnotatedField) {
                accessors.remove(1);
                continue;
            }
            return false;
        } while (accessors.size() > 1);
        return true;
    }

    protected void reportProblem(String msg, Object ... args2) {
        if (args2.length > 0) {
            msg = String.format(msg, args2);
        }
        throw new IllegalArgumentException("Problem with definition of " + this._classDef + ": " + msg);
    }

    protected POJOPropertyBuilder _property(Map<String, POJOPropertyBuilder> props, PropertyName name) {
        String simpleName = name.getSimpleName();
        POJOPropertyBuilder prop = props.get(simpleName);
        if (prop == null) {
            prop = new POJOPropertyBuilder(this._config, this._annotationIntrospector, this._forSerialization, name);
            props.put(simpleName, prop);
        }
        return prop;
    }

    protected POJOPropertyBuilder _property(Map<String, POJOPropertyBuilder> props, String implName) {
        POJOPropertyBuilder prop = props.get(implName);
        if (prop == null) {
            prop = new POJOPropertyBuilder(this._config, this._annotationIntrospector, this._forSerialization, PropertyName.construct(implName));
            props.put(implName, prop);
        }
        return prop;
    }

    private PropertyNamingStrategy _findNamingStrategy() {
        PropertyNamingStrategy pns;
        HandlerInstantiator hi;
        Class namingClass;
        Object namingDef = this._annotationIntrospector.findNamingStrategy(this._classDef);
        if (namingDef == null) {
            return this._config.getPropertyNamingStrategy();
        }
        if (namingDef instanceof PropertyNamingStrategy) {
            return (PropertyNamingStrategy)namingDef;
        }
        if (!(namingDef instanceof Class)) {
            this.reportProblem("AnnotationIntrospector returned PropertyNamingStrategy definition of type %s; expected type `PropertyNamingStrategy` or `Class<PropertyNamingStrategy>` instead", ClassUtil.classNameOf(namingDef));
        }
        if ((namingClass = (Class)namingDef) == PropertyNamingStrategy.class) {
            return null;
        }
        if (!PropertyNamingStrategy.class.isAssignableFrom(namingClass)) {
            this.reportProblem("AnnotationIntrospector returned Class %s; expected `Class<PropertyNamingStrategy>`", ClassUtil.classNameOf(namingClass));
        }
        if ((hi = this._config.getHandlerInstantiator()) != null && (pns = hi.namingStrategyInstance(this._config, this._classDef, namingClass)) != null) {
            return pns;
        }
        return (PropertyNamingStrategy)ClassUtil.createInstance(namingClass, this._config.canOverrideAccessModifiers());
    }

    protected boolean _replaceCreatorProperty(List<POJOPropertyBuilder> creatorProperties, POJOPropertyBuilder prop) {
        AnnotatedParameter ctorParam = prop.getConstructorParameter();
        if (creatorProperties != null) {
            int len = creatorProperties.size();
            for (int i = 0; i < len; ++i) {
                POJOPropertyBuilder cprop = creatorProperties.get(i);
                if (cprop == null || cprop.getConstructorParameter() != ctorParam) continue;
                creatorProperties.set(i, prop);
                return true;
            }
        }
        return false;
    }
}

