/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.EnumNamingStrategy;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.ConfigOverride;
import com.fasterxml.jackson.databind.cfg.ConstructorDetector;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.deser.AbstractDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.CreatorProperty;
import com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate;
import com.fasterxml.jackson.databind.deser.impl.CreatorCollector;
import com.fasterxml.jackson.databind.deser.impl.JDKValueInstantiators;
import com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers;
import com.fasterxml.jackson.databind.deser.std.ArrayBlockingQueueDeserializer;
import com.fasterxml.jackson.databind.deser.std.AtomicReferenceDeserializer;
import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.deser.std.EnumDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumSetDeserializer;
import com.fasterxml.jackson.databind.deser.std.JdkDeserializers;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;
import com.fasterxml.jackson.databind.deser.std.MapDeserializer;
import com.fasterxml.jackson.databind.deser.std.MapEntryDeserializer;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.deser.std.TokenBufferDeserializer;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.EnumNamingStrategyFactory;
import com.fasterxml.jackson.databind.introspect.PotentialCreator;
import com.fasterxml.jackson.databind.introspect.PotentialCreators;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BasicDeserializerFactory
extends DeserializerFactory
implements Serializable {
    private static final Class<?> CLASS_OBJECT = Object.class;
    private static final Class<?> CLASS_STRING = String.class;
    private static final Class<?> CLASS_CHAR_SEQUENCE = CharSequence.class;
    private static final Class<?> CLASS_ITERABLE = Iterable.class;
    private static final Class<?> CLASS_MAP_ENTRY = Map.Entry.class;
    private static final Class<?> CLASS_SERIALIZABLE = Serializable.class;
    protected static final PropertyName UNWRAPPED_CREATOR_PARAM_NAME = new PropertyName("@JsonUnwrapped");
    protected final DeserializerFactoryConfig _factoryConfig;

    protected BasicDeserializerFactory(DeserializerFactoryConfig config) {
        this._factoryConfig = config;
    }

    public DeserializerFactoryConfig getFactoryConfig() {
        return this._factoryConfig;
    }

    protected abstract DeserializerFactory withConfig(DeserializerFactoryConfig var1);

    @Override
    public final DeserializerFactory withAdditionalDeserializers(Deserializers additional) {
        return this.withConfig(this._factoryConfig.withAdditionalDeserializers(additional));
    }

    @Override
    public final DeserializerFactory withAdditionalKeyDeserializers(KeyDeserializers additional) {
        return this.withConfig(this._factoryConfig.withAdditionalKeyDeserializers(additional));
    }

    @Override
    public final DeserializerFactory withDeserializerModifier(BeanDeserializerModifier modifier) {
        return this.withConfig(this._factoryConfig.withDeserializerModifier(modifier));
    }

    @Override
    public final DeserializerFactory withAbstractTypeResolver(AbstractTypeResolver resolver) {
        return this.withConfig(this._factoryConfig.withAbstractTypeResolver(resolver));
    }

    @Override
    public final DeserializerFactory withValueInstantiators(ValueInstantiators instantiators) {
        return this.withConfig(this._factoryConfig.withValueInstantiators(instantiators));
    }

    @Override
    public JavaType mapAbstractType(DeserializationConfig config, JavaType type) throws JsonMappingException {
        JavaType next;
        while ((next = this._mapAbstractType2(config, type)) != null) {
            Class<?> nextCls;
            Class<?> prevCls = type.getRawClass();
            if (prevCls == (nextCls = next.getRawClass()) || !prevCls.isAssignableFrom(nextCls)) {
                throw new IllegalArgumentException("Invalid abstract type resolution from " + type + " to " + next + ": latter is not a subtype of former");
            }
            type = next;
        }
        return type;
    }

    private JavaType _mapAbstractType2(DeserializationConfig config, JavaType type) throws JsonMappingException {
        Class<?> currClass = type.getRawClass();
        if (this._factoryConfig.hasAbstractTypeResolvers()) {
            for (AbstractTypeResolver resolver : this._factoryConfig.abstractTypeResolvers()) {
                JavaType concrete = resolver.findTypeMapping(config, type);
                if (concrete == null || concrete.hasRawClass(currClass)) continue;
                return concrete;
            }
        }
        return null;
    }

    @Override
    public ValueInstantiator findValueInstantiator(DeserializationContext ctxt, BeanDescription beanDesc) throws JsonMappingException {
        DeserializationConfig config = ctxt.getConfig();
        ValueInstantiator instantiator = null;
        AnnotatedClass ac = beanDesc.getClassInfo();
        Object instDef = config.getAnnotationIntrospector().findValueInstantiator(ac);
        if (instDef != null) {
            instantiator = this._valueInstantiatorInstance(config, ac, instDef);
        }
        if (instantiator == null && (instantiator = JDKValueInstantiators.findStdValueInstantiator(config, beanDesc.getBeanClass())) == null) {
            instantiator = this._constructDefaultValueInstantiator(ctxt, beanDesc);
        }
        if (this._factoryConfig.hasValueInstantiators()) {
            for (ValueInstantiators insts : this._factoryConfig.valueInstantiators()) {
                instantiator = insts.findValueInstantiator(config, beanDesc, instantiator);
                if (instantiator != null) continue;
                ctxt.reportBadTypeDefinition(beanDesc, "Broken registered ValueInstantiators (of type %s): returned null ValueInstantiator", insts.getClass().getName());
            }
        }
        if (instantiator != null) {
            instantiator = instantiator.createContextual(ctxt, beanDesc);
        }
        return instantiator;
    }

    protected ValueInstantiator _constructDefaultValueInstantiator(DeserializationContext ctxt, BeanDescription beanDesc) throws JsonMappingException {
        boolean isNonStaticInnerClass;
        DeserializationConfig config = ctxt.getConfig();
        PotentialCreators potentialCreators = beanDesc.getPotentialCreators();
        ConstructorDetector ctorDetector = ((MapperConfig)config).getConstructorDetector();
        VisibilityChecker<?> vchecker = ((MapperConfig)config).getDefaultVisibilityChecker(beanDesc.getBeanClass(), beanDesc.getClassInfo());
        CreatorCollector creators = new CreatorCollector(beanDesc, config);
        if (potentialCreators.hasPropertiesBased()) {
            PotentialCreator primaryPropsBased = potentialCreators.propertiesBased;
            if (primaryPropsBased.paramCount() == 0) {
                creators.setDefaultCreator(primaryPropsBased.creator());
            } else {
                this._addSelectedPropertiesBasedCreator(ctxt, beanDesc, creators, CreatorCandidate.construct(config.getAnnotationIntrospector(), primaryPropsBased.creator(), primaryPropsBased.propertyDefs()));
            }
        }
        boolean hasExplicitDelegating = this._addExplicitDelegatingCreators(ctxt, beanDesc, creators, potentialCreators.getExplicitDelegating());
        if (beanDesc.getType().isConcrete() && !(isNonStaticInnerClass = beanDesc.isNonStaticInnerClass())) {
            boolean findImplicit;
            AnnotatedConstructor defaultCtor;
            if (!creators.hasDefaultCreator() && (defaultCtor = beanDesc.findDefaultConstructor()) != null) {
                creators.setDefaultCreator(defaultCtor);
            }
            if (findImplicit = ctorDetector.shouldIntrospectorImplicitConstructors(beanDesc.getBeanClass())) {
                this._addImplicitDelegatingConstructors(ctxt, beanDesc, vchecker, creators, potentialCreators.getImplicitDelegatingConstructors());
            }
        }
        if (!hasExplicitDelegating) {
            this._addImplicitDelegatingFactories(ctxt, vchecker, creators, potentialCreators.getImplicitDelegatingFactories());
        }
        return creators.constructValueInstantiator(ctxt);
    }

    public ValueInstantiator _valueInstantiatorInstance(DeserializationConfig config, Annotated annotated, Object instDef) throws JsonMappingException {
        ValueInstantiator inst;
        if (instDef == null) {
            return null;
        }
        if (instDef instanceof ValueInstantiator) {
            return (ValueInstantiator)instDef;
        }
        if (!(instDef instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + instDef.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
        }
        Class instClass = (Class)instDef;
        if (ClassUtil.isBogusClass(instClass)) {
            return null;
        }
        if (!ValueInstantiator.class.isAssignableFrom(instClass)) {
            throw new IllegalStateException("AnnotationIntrospector returned Class " + instClass.getName() + "; expected Class<ValueInstantiator>");
        }
        HandlerInstantiator hi = config.getHandlerInstantiator();
        if (hi != null && (inst = hi.valueInstantiatorInstance(config, annotated, instClass)) != null) {
            return inst;
        }
        return (ValueInstantiator)ClassUtil.createInstance(instClass, config.canOverrideAccessModifiers());
    }

    private boolean _addExplicitDelegatingCreators(DeserializationContext ctxt, BeanDescription beanDesc, CreatorCollector creators, List<PotentialCreator> potentials) throws JsonMappingException {
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        boolean added = false;
        for (PotentialCreator ctor : potentials) {
            added |= this._addExplicitDelegatingCreator(ctxt, beanDesc, creators, CreatorCandidate.construct(intr, ctor.creator(), null));
        }
        return added;
    }

    private void _addImplicitDelegatingConstructors(DeserializationContext ctxt, BeanDescription beanDesc, VisibilityChecker<?> vchecker, CreatorCollector creators, List<PotentialCreator> potentials) throws JsonMappingException {
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        for (PotentialCreator candidate : potentials) {
            int argCount = candidate.paramCount();
            AnnotatedWithParams ctor = candidate.creator();
            if (argCount == 1) {
                this._handleSingleArgumentCreator(creators, ctor, false, vchecker.isCreatorVisible(ctor));
                continue;
            }
            SettableBeanProperty[] properties = new SettableBeanProperty[argCount];
            int injectCount = 0;
            for (int i = 0; i < argCount; ++i) {
                AnnotatedParameter param2 = ctor.getParameter(i);
                JacksonInject.Value injectable = intr.findInjectableValue(param2);
                if (injectable != null) {
                    ++injectCount;
                    properties[i] = this.constructCreatorProperty(ctxt, beanDesc, null, i, param2, injectable);
                    continue;
                }
                NameTransformer unwrapper = intr.findUnwrappingNameTransformer(param2);
                if (unwrapper == null) continue;
                this._reportUnwrappedCreatorProperty(ctxt, beanDesc, param2);
            }
            if (injectCount + 1 != argCount) continue;
            creators.addDelegatingCreator(ctor, false, properties, 0);
        }
    }

    private void _addImplicitDelegatingFactories(DeserializationContext ctxt, VisibilityChecker<?> vchecker, CreatorCollector creators, List<PotentialCreator> potentials) throws JsonMappingException {
        for (PotentialCreator candidate : potentials) {
            int argCount = candidate.paramCount();
            AnnotatedWithParams factory2 = candidate.creator();
            if (argCount != 1) continue;
            this._handleSingleArgumentCreator(creators, factory2, false, vchecker.isCreatorVisible(factory2));
        }
    }

    private boolean _addExplicitDelegatingCreator(DeserializationContext ctxt, BeanDescription beanDesc, CreatorCollector creators, CreatorCandidate candidate) throws JsonMappingException {
        int ix = -1;
        int argCount = candidate.paramCount();
        SettableBeanProperty[] properties = new SettableBeanProperty[argCount];
        if (argCount == 0) {
            creators.addPropertyCreator(candidate.creator(), true, properties);
            return true;
        }
        for (int i = 0; i < argCount; ++i) {
            AnnotatedParameter param2 = candidate.parameter(i);
            JacksonInject.Value injectId = candidate.injection(i);
            if (injectId != null) {
                properties[i] = this.constructCreatorProperty(ctxt, beanDesc, null, i, param2, injectId);
                continue;
            }
            if (ix < 0) {
                ix = i;
                continue;
            }
            ctxt.reportBadTypeDefinition(beanDesc, "More than one argument (#%d and #%d) left as delegating for Creator %s: only one allowed", ix, i, candidate);
        }
        if (ix < 0) {
            ctxt.reportBadTypeDefinition(beanDesc, "No argument left as delegating for Creator %s: exactly one required", candidate);
        }
        if (argCount == 1) {
            return this._handleSingleArgumentCreator(creators, candidate.creator(), true, true);
        }
        creators.addDelegatingCreator(candidate.creator(), true, properties, ix);
        return true;
    }

    private void _addSelectedPropertiesBasedCreator(DeserializationContext ctxt, BeanDescription beanDesc, CreatorCollector creators, CreatorCandidate candidate) throws JsonMappingException {
        int paramCount = candidate.paramCount();
        SettableBeanProperty[] properties = new SettableBeanProperty[paramCount];
        int anySetterIx = -1;
        for (int i = 0; i < paramCount; ++i) {
            JacksonInject.Value injectId = candidate.injection(i);
            AnnotatedParameter param2 = candidate.parameter(i);
            PropertyName name = candidate.paramName(i);
            boolean isAnySetter = Boolean.TRUE.equals(ctxt.getAnnotationIntrospector().hasAnySetter(param2));
            if (isAnySetter) {
                if (anySetterIx >= 0) {
                    ctxt.reportBadTypeDefinition(beanDesc, "More than one 'any-setter' specified (parameter #%d vs #%d)", anySetterIx, i);
                } else {
                    anySetterIx = i;
                }
            } else if (name == null) {
                NameTransformer unwrapper = ctxt.getAnnotationIntrospector().findUnwrappingNameTransformer(param2);
                if (unwrapper != null) {
                    this._reportUnwrappedCreatorProperty(ctxt, beanDesc, param2);
                }
                if (name == null && injectId == null) {
                    ctxt.reportBadTypeDefinition(beanDesc, "Argument #%d of Creator %s has no property name (and is not Injectable): can not use as property-based Creator", i, candidate);
                }
            }
            properties[i] = this.constructCreatorProperty(ctxt, beanDesc, name, i, param2, injectId);
        }
        creators.addPropertyCreator(candidate.creator(), true, properties);
    }

    private boolean _handleSingleArgumentCreator(CreatorCollector creators, AnnotatedWithParams ctor, boolean isCreator, boolean isVisible) {
        Class<?> type = ctor.getRawParameterType(0);
        if (type == String.class || type == CLASS_CHAR_SEQUENCE) {
            if (isCreator || isVisible) {
                creators.addStringCreator(ctor, isCreator);
            }
            return true;
        }
        if (type == Integer.TYPE || type == Integer.class) {
            if (isCreator || isVisible) {
                creators.addIntCreator(ctor, isCreator);
            }
            return true;
        }
        if (type == Long.TYPE || type == Long.class) {
            if (isCreator || isVisible) {
                creators.addLongCreator(ctor, isCreator);
            }
            return true;
        }
        if (type == Double.TYPE || type == Double.class) {
            if (isCreator || isVisible) {
                creators.addDoubleCreator(ctor, isCreator);
            }
            return true;
        }
        if (type == Boolean.TYPE || type == Boolean.class) {
            if (isCreator || isVisible) {
                creators.addBooleanCreator(ctor, isCreator);
            }
            return true;
        }
        if (type == BigInteger.class && (isCreator || isVisible)) {
            creators.addBigIntegerCreator(ctor, isCreator);
        }
        if (type == BigDecimal.class && (isCreator || isVisible)) {
            creators.addBigDecimalCreator(ctor, isCreator);
        }
        if (isCreator) {
            creators.addDelegatingCreator(ctor, isCreator, null, 0);
            return true;
        }
        return false;
    }

    private void _reportUnwrappedCreatorProperty(DeserializationContext ctxt, BeanDescription beanDesc, AnnotatedParameter param2) throws JsonMappingException {
        ctxt.reportBadTypeDefinition(beanDesc, "Cannot define Creator parameter %d as `@JsonUnwrapped`: combination not yet supported", param2.getIndex());
    }

    protected SettableBeanProperty constructCreatorProperty(DeserializationContext ctxt, BeanDescription beanDesc, PropertyName name, int index, AnnotatedParameter param2, JacksonInject.Value injectable) throws JsonMappingException {
        PropertyName wrapperName;
        PropertyMetadata metadata;
        DeserializationConfig config = ctxt.getConfig();
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (intr == null) {
            metadata = PropertyMetadata.STD_REQUIRED_OR_OPTIONAL;
            wrapperName = null;
        } else {
            Boolean b = intr.hasRequiredMarker(param2);
            String desc = intr.findPropertyDescription(param2);
            Integer idx = intr.findPropertyIndex(param2);
            String def = intr.findPropertyDefaultValue(param2);
            metadata = PropertyMetadata.construct(b, desc, idx, def);
            wrapperName = intr.findWrapperName(param2);
        }
        JavaType type = this.resolveMemberAndTypeAnnotations(ctxt, param2, param2.getType());
        BeanProperty.Std property = new BeanProperty.Std(name, type, wrapperName, param2, metadata);
        TypeDeserializer typeDeser = (TypeDeserializer)type.getTypeHandler();
        if (typeDeser == null) {
            typeDeser = this.findTypeDeserializer(config, type);
        }
        metadata = this._getSetterInfo(config, property, metadata);
        SettableBeanProperty prop = CreatorProperty.construct(name, type, property.getWrapperName(), typeDeser, beanDesc.getClassAnnotations(), param2, index, injectable, metadata);
        JsonDeserializer<?> deser = this.findDeserializerFromAnnotation(ctxt, param2);
        if (deser == null) {
            deser = (JsonDeserializer<?>)type.getValueHandler();
        }
        if (deser != null) {
            deser = ctxt.handlePrimaryContextualization(deser, prop, type);
            prop = ((SettableBeanProperty)prop).withValueDeserializer(deser);
        }
        return prop;
    }

    private PropertyMetadata _getSetterInfo(MapperConfig<?> config, BeanProperty prop, PropertyMetadata metadata) {
        JsonSetter.Value setterInfo;
        AnnotationIntrospector intr = config.getAnnotationIntrospector();
        boolean needMerge = true;
        Nulls valueNulls = null;
        Nulls contentNulls = null;
        AnnotatedMember prim = prop.getMember();
        if (prim != null) {
            ConfigOverride co;
            JsonSetter.Value setterInfo2;
            if (intr != null && (setterInfo = intr.findSetterInfo(prim)) != null) {
                valueNulls = setterInfo.nonDefaultValueNulls();
                contentNulls = setterInfo.nonDefaultContentNulls();
            }
            if ((needMerge || valueNulls == null || contentNulls == null) && (setterInfo2 = (co = config.getConfigOverride(prop.getType().getRawClass())).getSetterInfo()) != null) {
                if (valueNulls == null) {
                    valueNulls = setterInfo2.nonDefaultValueNulls();
                }
                if (contentNulls == null) {
                    contentNulls = setterInfo2.nonDefaultContentNulls();
                }
            }
        }
        if (needMerge || valueNulls == null || contentNulls == null) {
            setterInfo = config.getDefaultSetterInfo();
            if (valueNulls == null) {
                valueNulls = setterInfo.nonDefaultValueNulls();
            }
            if (contentNulls == null) {
                contentNulls = setterInfo.nonDefaultContentNulls();
            }
        }
        if (valueNulls != null || contentNulls != null) {
            metadata = metadata.withNulls(valueNulls, contentNulls);
        }
        return metadata;
    }

    @Override
    public JsonDeserializer<?> createArrayDeserializer(DeserializationContext ctxt, ArrayType type, BeanDescription beanDesc) throws JsonMappingException {
        JsonDeserializer deser;
        DeserializationConfig config = ctxt.getConfig();
        JavaType elemType = type.getContentType();
        JsonDeserializer contentDeser = (JsonDeserializer)elemType.getValueHandler();
        TypeDeserializer elemTypeDeser = (TypeDeserializer)elemType.getTypeHandler();
        if (elemTypeDeser == null) {
            elemTypeDeser = this.findTypeDeserializer(config, elemType);
        }
        if ((deser = this._findCustomArrayDeserializer(type, config, beanDesc, elemTypeDeser, contentDeser)) == null) {
            if (contentDeser == null) {
                if (elemType.isPrimitive()) {
                    deser = PrimitiveArrayDeserializers.forType(elemType.getRawClass());
                } else if (elemType.hasRawClass(String.class)) {
                    deser = StringArrayDeserializer.instance;
                }
            }
            if (deser == null) {
                deser = new ObjectArrayDeserializer((JavaType)type, contentDeser, elemTypeDeser);
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                deser = mod.modifyArrayDeserializer(config, type, beanDesc, deser);
            }
        }
        return deser;
    }

    @Override
    public JsonDeserializer<?> createCollectionDeserializer(DeserializationContext ctxt, CollectionType type, BeanDescription beanDesc) throws JsonMappingException {
        JsonDeserializer deser;
        JavaType contentType = type.getContentType();
        JsonDeserializer contentDeser = (JsonDeserializer)contentType.getValueHandler();
        DeserializationConfig config = ctxt.getConfig();
        TypeDeserializer contentTypeDeser = (TypeDeserializer)contentType.getTypeHandler();
        if (contentTypeDeser == null) {
            contentTypeDeser = this.findTypeDeserializer(config, contentType);
        }
        if ((deser = this._findCustomCollectionDeserializer(type, config, beanDesc, contentTypeDeser, contentDeser)) == null) {
            Class<?> collectionClass = type.getRawClass();
            if (contentDeser == null && EnumSet.class.isAssignableFrom(collectionClass)) {
                deser = new EnumSetDeserializer(contentType, null, contentTypeDeser);
            }
        }
        if (deser == null) {
            CollectionType implType;
            if ((type.isInterface() || type.isAbstract()) && (implType = this._mapAbstractCollectionType(type, config)) != null) {
                type = implType;
                beanDesc = config.introspectForCreation(type);
            }
            if (deser == null) {
                ValueInstantiator inst = this.findValueInstantiator(ctxt, beanDesc);
                if (!inst.canCreateUsingDefault()) {
                    if (type.hasRawClass(ArrayBlockingQueue.class)) {
                        return new ArrayBlockingQueueDeserializer(type, contentDeser, contentTypeDeser, inst);
                    }
                    deser = JavaUtilCollectionsDeserializers.findForCollection(ctxt, type);
                    if (deser != null) {
                        return deser;
                    }
                }
                deser = contentType.hasRawClass(String.class) ? new StringCollectionDeserializer((JavaType)type, contentDeser, inst) : new CollectionDeserializer(type, contentDeser, contentTypeDeser, inst);
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                deser = mod.modifyCollectionDeserializer(config, type, beanDesc, deser);
            }
        }
        return deser;
    }

    protected CollectionType _mapAbstractCollectionType(JavaType type, DeserializationConfig config) {
        Class<?> collectionClass = ContainerDefaultMappings.findCollectionFallback(type);
        if (collectionClass != null) {
            return (CollectionType)config.getTypeFactory().constructSpecializedType(type, collectionClass, true);
        }
        return null;
    }

    @Override
    public JsonDeserializer<?> createCollectionLikeDeserializer(DeserializationContext ctxt, CollectionLikeType type, BeanDescription beanDesc) throws JsonMappingException {
        JsonDeserializer<?> deser;
        JavaType contentType = type.getContentType();
        JsonDeserializer contentDeser = (JsonDeserializer)contentType.getValueHandler();
        DeserializationConfig config = ctxt.getConfig();
        TypeDeserializer contentTypeDeser = (TypeDeserializer)contentType.getTypeHandler();
        if (contentTypeDeser == null) {
            contentTypeDeser = this.findTypeDeserializer(config, contentType);
        }
        if ((deser = this._findCustomCollectionLikeDeserializer(type, config, beanDesc, contentTypeDeser, contentDeser)) != null && this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                deser = mod.modifyCollectionLikeDeserializer(config, type, beanDesc, deser);
            }
        }
        return deser;
    }

    @Override
    public JsonDeserializer<?> createMapDeserializer(DeserializationContext ctxt, MapType type, BeanDescription beanDesc) throws JsonMappingException {
        JsonDeserializer deser;
        DeserializationConfig config = ctxt.getConfig();
        JavaType keyType = type.getKeyType();
        JavaType contentType = type.getContentType();
        JsonDeserializer contentDeser = (JsonDeserializer)contentType.getValueHandler();
        KeyDeserializer keyDes = (KeyDeserializer)keyType.getValueHandler();
        TypeDeserializer contentTypeDeser = (TypeDeserializer)contentType.getTypeHandler();
        if (contentTypeDeser == null) {
            contentTypeDeser = this.findTypeDeserializer(config, contentType);
        }
        if ((deser = this._findCustomMapDeserializer(type, config, beanDesc, keyDes, contentTypeDeser, contentDeser)) == null) {
            ValueInstantiator inst;
            Class<?> mapClass = type.getRawClass();
            if (EnumMap.class.isAssignableFrom(mapClass)) {
                inst = mapClass == EnumMap.class ? null : this.findValueInstantiator(ctxt, beanDesc);
                if (!keyType.isEnumImplType()) {
                    throw new IllegalArgumentException("Cannot construct EnumMap; generic (key) type not available");
                }
                deser = new EnumMapDeserializer(type, inst, null, contentDeser, contentTypeDeser, null);
            }
            if (deser == null) {
                if (type.isInterface() || type.isAbstract()) {
                    MapType implType = this._mapAbstractMapType(type, config);
                    if (implType != null) {
                        type = implType;
                        mapClass = type.getRawClass();
                        beanDesc = config.introspectForCreation(type);
                    }
                } else {
                    deser = JavaUtilCollectionsDeserializers.findForMap(ctxt, type);
                    if (deser != null) {
                        return deser;
                    }
                }
                if (deser == null) {
                    inst = this.findValueInstantiator(ctxt, beanDesc);
                    MapDeserializer md = new MapDeserializer(type, inst, keyDes, contentDeser, contentTypeDeser);
                    JsonIgnoreProperties.Value ignorals = config.getDefaultPropertyIgnorals(Map.class, beanDesc.getClassInfo());
                    Set<String> ignored = ignorals == null ? null : ignorals.findIgnoredForDeserialization();
                    md.setIgnorableProperties(ignored);
                    JsonIncludeProperties.Value inclusions = config.getDefaultPropertyInclusions(Map.class, beanDesc.getClassInfo());
                    Set<String> included = inclusions == null ? null : inclusions.getIncluded();
                    md.setIncludableProperties(included);
                    deser = md;
                }
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                deser = mod.modifyMapDeserializer(config, type, beanDesc, deser);
            }
        }
        return deser;
    }

    protected MapType _mapAbstractMapType(JavaType type, DeserializationConfig config) {
        Class<?> mapClass = ContainerDefaultMappings.findMapFallback(type);
        if (mapClass != null) {
            return (MapType)config.getTypeFactory().constructSpecializedType(type, mapClass, true);
        }
        return null;
    }

    @Override
    public JsonDeserializer<?> createMapLikeDeserializer(DeserializationContext ctxt, MapLikeType type, BeanDescription beanDesc) throws JsonMappingException {
        JsonDeserializer<?> deser;
        JavaType keyType = type.getKeyType();
        JavaType contentType = type.getContentType();
        DeserializationConfig config = ctxt.getConfig();
        JsonDeserializer contentDeser = (JsonDeserializer)contentType.getValueHandler();
        KeyDeserializer keyDes = (KeyDeserializer)keyType.getValueHandler();
        TypeDeserializer contentTypeDeser = (TypeDeserializer)contentType.getTypeHandler();
        if (contentTypeDeser == null) {
            contentTypeDeser = this.findTypeDeserializer(config, contentType);
        }
        if ((deser = this._findCustomMapLikeDeserializer(type, config, beanDesc, keyDes, contentTypeDeser, contentDeser)) != null && this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                deser = mod.modifyMapLikeDeserializer(config, type, beanDesc, deser);
            }
        }
        return deser;
    }

    @Override
    public JsonDeserializer<?> createEnumDeserializer(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        DeserializationConfig config = ctxt.getConfig();
        Class<?> enumClass = type.getRawClass();
        JsonDeserializer deser = this._findCustomEnumDeserializer(enumClass, config, beanDesc);
        if (deser == null) {
            if (enumClass == Enum.class) {
                return AbstractDeserializer.constructForNonPOJO(beanDesc);
            }
            ValueInstantiator valueInstantiator = this._constructDefaultValueInstantiator(ctxt, beanDesc);
            SettableBeanProperty[] creatorProps = valueInstantiator == null ? null : valueInstantiator.getFromObjectArguments(ctxt.getConfig());
            for (AnnotatedMethod factory2 : beanDesc.getFactoryMethods()) {
                if (!this._hasCreatorAnnotation(config, factory2)) continue;
                if (factory2.getParameterCount() == 0) {
                    deser = EnumDeserializer.deserializerForNoArgsCreator(config, enumClass, factory2);
                    break;
                }
                Class<?> returnType = factory2.getRawReturnType();
                if (!returnType.isAssignableFrom(enumClass)) {
                    ctxt.reportBadDefinition(type, String.format("Invalid `@JsonCreator` annotated Enum factory method [%s]: needs to return compatible type", factory2.toString()));
                }
                deser = EnumDeserializer.deserializerForCreator(config, enumClass, factory2, valueInstantiator, creatorProps);
                break;
            }
            if (deser == null) {
                deser = new EnumDeserializer(this.constructEnumResolver(enumClass, config, beanDesc), config.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS), this.constructEnumNamingStrategyResolver(config, beanDesc.getClassInfo()), EnumResolver.constructUsingToString(config, beanDesc.getClassInfo()));
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                deser = mod.modifyEnumDeserializer(config, type, beanDesc, deser);
            }
        }
        return deser;
    }

    @Override
    public JsonDeserializer<?> createTreeDeserializer(DeserializationConfig config, JavaType nodeType, BeanDescription beanDesc) throws JsonMappingException {
        Class<?> nodeClass = nodeType.getRawClass();
        JsonDeserializer<?> custom = this._findCustomTreeNodeDeserializer(nodeClass, config, beanDesc);
        if (custom != null) {
            return custom;
        }
        return JsonNodeDeserializer.getDeserializer(nodeClass);
    }

    @Override
    public JsonDeserializer<?> createReferenceDeserializer(DeserializationContext ctxt, ReferenceType type, BeanDescription beanDesc) throws JsonMappingException {
        JsonDeserializer<?> deser;
        JavaType contentType = type.getContentType();
        JsonDeserializer contentDeser = (JsonDeserializer)contentType.getValueHandler();
        DeserializationConfig config = ctxt.getConfig();
        TypeDeserializer contentTypeDeser = (TypeDeserializer)contentType.getTypeHandler();
        if (contentTypeDeser == null) {
            contentTypeDeser = this.findTypeDeserializer(config, contentType);
        }
        if ((deser = this._findCustomReferenceDeserializer(type, config, beanDesc, contentTypeDeser, contentDeser)) == null && type.isTypeOrSubTypeOf(AtomicReference.class)) {
            Class<?> rawType = type.getRawClass();
            ValueInstantiator inst = rawType == AtomicReference.class ? null : this.findValueInstantiator(ctxt, beanDesc);
            return new AtomicReferenceDeserializer(type, inst, contentTypeDeser, contentDeser);
        }
        if (deser != null && this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                deser = mod.modifyReferenceDeserializer(config, type, beanDesc, deser);
            }
        }
        return deser;
    }

    @Override
    public TypeDeserializer findTypeDeserializer(DeserializationConfig config, JavaType baseType) throws JsonMappingException {
        JavaType defaultType;
        BeanDescription bean = config.introspectClassAnnotations(baseType.getRawClass());
        AnnotatedClass ac = bean.getClassInfo();
        AnnotationIntrospector ai = config.getAnnotationIntrospector();
        TypeResolverBuilder<?> b = ai.findTypeResolver(config, ac, baseType);
        if (b == null && (b = config.getDefaultTyper(baseType)) == null) {
            return null;
        }
        Collection<NamedType> subtypes = config.getSubtypeResolver().collectAndResolveSubtypesByTypeId(config, ac);
        if (b.getDefaultImpl() == null && baseType.isAbstract() && (defaultType = this.mapAbstractType(config, baseType)) != null && !defaultType.hasRawClass(baseType.getRawClass())) {
            b = b.withDefaultImpl(defaultType.getRawClass());
        }
        try {
            return b.buildTypeDeserializer(config, baseType, subtypes);
        }
        catch (IllegalArgumentException | IllegalStateException e0) {
            throw InvalidDefinitionException.from((JsonParser)null, ClassUtil.exceptionMessage(e0), baseType).withCause(e0);
        }
    }

    protected JsonDeserializer<?> findOptionalStdDeserializer(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        return OptionalHandlerFactory.instance.findDeserializer(type, ctxt.getConfig(), beanDesc);
    }

    @Override
    public KeyDeserializer createKeyDeserializer(DeserializationContext ctxt, JavaType type) throws JsonMappingException {
        DeserializationConfig config = ctxt.getConfig();
        BeanDescription beanDesc = config.introspectClassAnnotations(type);
        KeyDeserializer deser = this.findKeyDeserializerFromAnnotation(ctxt, beanDesc.getClassInfo());
        if (deser == null && this._factoryConfig.hasKeyDeserializers()) {
            KeyDeserializers d;
            Iterator<Object> iterator2 = this._factoryConfig.keyDeserializers().iterator();
            while (iterator2.hasNext() && (deser = (d = iterator2.next()).findKeyDeserializer(type, config, beanDesc)) == null) {
            }
        }
        if (deser == null) {
            deser = type.isEnumType() ? this._createEnumKeyDeserializer(ctxt, type) : StdKeyDeserializers.findStringBasedKeyDeserializer(config, type);
        }
        if (deser != null && this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                deser = mod.modifyKeyDeserializer(config, type, deser);
            }
        }
        return deser;
    }

    private KeyDeserializer _createEnumKeyDeserializer(DeserializationContext ctxt, JavaType type) throws JsonMappingException {
        DeserializationConfig config = ctxt.getConfig();
        Class<?> enumClass = type.getRawClass();
        BeanDescription beanDesc = config.introspect(type);
        KeyDeserializer des = this.findKeyDeserializerFromAnnotation(ctxt, beanDesc.getClassInfo());
        if (des != null) {
            return des;
        }
        JsonDeserializer<?> custom = this._findCustomEnumDeserializer(enumClass, config, beanDesc);
        if (custom != null) {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(config, type, custom);
        }
        JsonDeserializer<Object> valueDesForKey = this.findDeserializerFromAnnotation(ctxt, beanDesc.getClassInfo());
        if (valueDesForKey != null) {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(config, type, valueDesForKey);
        }
        EnumResolver enumRes = this.constructEnumResolver(enumClass, config, beanDesc);
        EnumResolver byEnumNamingResolver = this.constructEnumNamingStrategyResolver(config, beanDesc.getClassInfo());
        EnumResolver byToStringResolver = EnumResolver.constructUsingToString(config, beanDesc.getClassInfo());
        EnumResolver byIndexResolver = EnumResolver.constructUsingIndex(config, beanDesc.getClassInfo());
        for (AnnotatedMethod factory2 : beanDesc.getFactoryMethods()) {
            Class<?> returnType;
            if (!this._hasCreatorAnnotation(config, factory2)) continue;
            int argCount = factory2.getParameterCount();
            if (argCount == 1 && (returnType = factory2.getRawReturnType()).isAssignableFrom(enumClass)) {
                if (factory2.getRawParameterType(0) != String.class) continue;
                if (config.canOverrideAccessModifiers()) {
                    ClassUtil.checkAndFixAccess(factory2.getMember(), ctxt.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                }
                return StdKeyDeserializers.constructEnumKeyDeserializer(enumRes, factory2, byEnumNamingResolver, byToStringResolver, byIndexResolver);
            }
            throw new IllegalArgumentException("Unsuitable method (" + factory2 + ") decorated with @JsonCreator (for Enum type " + enumClass.getName() + ")");
        }
        return StdKeyDeserializers.constructEnumKeyDeserializer(enumRes, byEnumNamingResolver, byToStringResolver, byIndexResolver);
    }

    @Override
    public boolean hasExplicitDeserializerFor(DeserializationConfig config, Class<?> valueType) {
        while (valueType.isArray()) {
            valueType = valueType.getComponentType();
        }
        if (Enum.class.isAssignableFrom(valueType)) {
            return true;
        }
        String clsName = valueType.getName();
        if (clsName.startsWith("java.")) {
            if (Collection.class.isAssignableFrom(valueType)) {
                return true;
            }
            if (Map.class.isAssignableFrom(valueType)) {
                return true;
            }
            if (Number.class.isAssignableFrom(valueType)) {
                return NumberDeserializers.find(valueType, clsName) != null;
            }
            if (JdkDeserializers.hasDeserializerFor(valueType) || valueType == CLASS_STRING || valueType == Boolean.class || valueType == EnumMap.class || valueType == AtomicReference.class) {
                return true;
            }
            return DateDeserializers.hasDeserializerFor(valueType);
        }
        if (clsName.startsWith("com.fasterxml.")) {
            return JsonNode.class.isAssignableFrom(valueType) || valueType == TokenBuffer.class;
        }
        return OptionalHandlerFactory.instance.hasDeserializerFor(valueType);
    }

    public TypeDeserializer findPropertyTypeDeserializer(DeserializationConfig config, JavaType baseType, AnnotatedMember annotated) throws JsonMappingException {
        AnnotationIntrospector ai = config.getAnnotationIntrospector();
        TypeResolverBuilder<?> b = ai.findPropertyTypeResolver(config, annotated, baseType);
        if (b == null) {
            return this.findTypeDeserializer(config, baseType);
        }
        Collection<NamedType> subtypes = config.getSubtypeResolver().collectAndResolveSubtypesByTypeId(config, annotated, baseType);
        try {
            return b.buildTypeDeserializer(config, baseType, subtypes);
        }
        catch (IllegalArgumentException | IllegalStateException e0) {
            throw InvalidDefinitionException.from((JsonParser)null, ClassUtil.exceptionMessage(e0), baseType).withCause(e0);
        }
    }

    public TypeDeserializer findPropertyContentTypeDeserializer(DeserializationConfig config, JavaType containerType, AnnotatedMember propertyEntity) throws JsonMappingException {
        AnnotationIntrospector ai = config.getAnnotationIntrospector();
        TypeResolverBuilder<?> b = ai.findPropertyContentTypeResolver(config, propertyEntity, containerType);
        JavaType contentType = containerType.getContentType();
        if (b == null) {
            return this.findTypeDeserializer(config, contentType);
        }
        Collection<NamedType> subtypes = config.getSubtypeResolver().collectAndResolveSubtypesByTypeId(config, propertyEntity, contentType);
        return b.buildTypeDeserializer(config, contentType, subtypes);
    }

    public JsonDeserializer<?> findDefaultDeserializer(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        JsonDeserializer<?> deser;
        Class<?> rawType = type.getRawClass();
        if (rawType == CLASS_OBJECT || rawType == CLASS_SERIALIZABLE) {
            JavaType mt;
            JavaType lt;
            DeserializationConfig config = ctxt.getConfig();
            if (this._factoryConfig.hasAbstractTypeResolvers()) {
                lt = this._findRemappedType(config, List.class);
                mt = this._findRemappedType(config, Map.class);
            } else {
                mt = null;
                lt = null;
            }
            return new UntypedObjectDeserializer(lt, mt);
        }
        if (rawType == CLASS_STRING || rawType == CLASS_CHAR_SEQUENCE) {
            return StringDeserializer.instance;
        }
        if (rawType == CLASS_ITERABLE) {
            TypeFactory tf = ctxt.getTypeFactory();
            JavaType[] tps = tf.findTypeParameters(type, CLASS_ITERABLE);
            JavaType elemType = tps == null || tps.length != 1 ? TypeFactory.unknownType() : tps[0];
            CollectionType ct = tf.constructCollectionType(Collection.class, elemType);
            return this.createCollectionDeserializer(ctxt, ct, beanDesc);
        }
        if (rawType == CLASS_MAP_ENTRY) {
            JavaType kt = type.containedTypeOrUnknown(0);
            JavaType vt = type.containedTypeOrUnknown(1);
            TypeDeserializer vts = (TypeDeserializer)vt.getTypeHandler();
            if (vts == null) {
                vts = this.findTypeDeserializer(ctxt.getConfig(), vt);
            }
            JsonDeserializer valueDeser = (JsonDeserializer)vt.getValueHandler();
            KeyDeserializer keyDes = (KeyDeserializer)kt.getValueHandler();
            return new MapEntryDeserializer(type, keyDes, (JsonDeserializer<Object>)valueDeser, vts);
        }
        String clsName = rawType.getName();
        if (rawType.isPrimitive() || clsName.startsWith("java.")) {
            deser = NumberDeserializers.find(rawType, clsName);
            if (deser == null) {
                deser = DateDeserializers.find(rawType, clsName);
            }
            if (deser != null) {
                return deser;
            }
        }
        if (rawType == TokenBuffer.class) {
            return new TokenBufferDeserializer();
        }
        deser = this.findOptionalStdDeserializer(ctxt, type, beanDesc);
        if (deser != null) {
            return deser;
        }
        return JdkDeserializers.find(ctxt, rawType, clsName);
    }

    protected JavaType _findRemappedType(DeserializationConfig config, Class<?> rawType) throws JsonMappingException {
        JavaType type = this.mapAbstractType(config, config.constructType(rawType));
        return type == null || type.hasRawClass(rawType) ? null : type;
    }

    protected JsonDeserializer<?> _findCustomTreeNodeDeserializer(Class<? extends JsonNode> type, DeserializationConfig config, BeanDescription beanDesc) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findTreeNodeDeserializer(type, config, beanDesc);
            if (deser == null) continue;
            return deser;
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomReferenceDeserializer(ReferenceType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer contentTypeDeserializer, JsonDeserializer<?> contentDeserializer) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findReferenceDeserializer(type, config, beanDesc, contentTypeDeserializer, contentDeserializer);
            if (deser == null) continue;
            return deser;
        }
        return null;
    }

    protected JsonDeserializer<Object> _findCustomBeanDeserializer(JavaType type, DeserializationConfig config, BeanDescription beanDesc) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<Object> deser = d.findBeanDeserializer(type, config, beanDesc);
            if (deser == null) continue;
            return deser;
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomArrayDeserializer(ArrayType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findArrayDeserializer(type, config, beanDesc, elementTypeDeserializer, elementDeserializer);
            if (deser == null) continue;
            return deser;
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomCollectionDeserializer(CollectionType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findCollectionDeserializer(type, config, beanDesc, elementTypeDeserializer, elementDeserializer);
            if (deser == null) continue;
            return deser;
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomCollectionLikeDeserializer(CollectionLikeType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findCollectionLikeDeserializer(type, config, beanDesc, elementTypeDeserializer, elementDeserializer);
            if (deser == null) continue;
            return deser;
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomEnumDeserializer(Class<?> type, DeserializationConfig config, BeanDescription beanDesc) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findEnumDeserializer(type, config, beanDesc);
            if (deser == null) continue;
            return deser;
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomMapDeserializer(MapType type, DeserializationConfig config, BeanDescription beanDesc, KeyDeserializer keyDeserializer, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findMapDeserializer(type, config, beanDesc, keyDeserializer, elementTypeDeserializer, elementDeserializer);
            if (deser == null) continue;
            return deser;
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomMapLikeDeserializer(MapLikeType type, DeserializationConfig config, BeanDescription beanDesc, KeyDeserializer keyDeserializer, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findMapLikeDeserializer(type, config, beanDesc, keyDeserializer, elementTypeDeserializer, elementDeserializer);
            if (deser == null) continue;
            return deser;
        }
        return null;
    }

    protected JsonDeserializer<Object> findDeserializerFromAnnotation(DeserializationContext ctxt, Annotated ann) throws JsonMappingException {
        Object deserDef;
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (intr != null && (deserDef = intr.findDeserializer(ann)) != null) {
            return ctxt.deserializerInstance(ann, deserDef);
        }
        return null;
    }

    protected KeyDeserializer findKeyDeserializerFromAnnotation(DeserializationContext ctxt, Annotated ann) throws JsonMappingException {
        Object deserDef;
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (intr != null && (deserDef = intr.findKeyDeserializer(ann)) != null) {
            return ctxt.keyDeserializerInstance(ann, deserDef);
        }
        return null;
    }

    protected JsonDeserializer<Object> findContentDeserializerFromAnnotation(DeserializationContext ctxt, Annotated ann) throws JsonMappingException {
        Object deserDef;
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (intr != null && (deserDef = intr.findContentDeserializer(ann)) != null) {
            return ctxt.deserializerInstance(ann, deserDef);
        }
        return null;
    }

    protected JavaType resolveMemberAndTypeAnnotations(DeserializationContext ctxt, AnnotatedMember member, JavaType type) throws JsonMappingException {
        TypeDeserializer valueTypeDeser;
        Object kdDef;
        KeyDeserializer kd;
        JavaType keyType;
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (intr == null) {
            return type;
        }
        if (type.isMapLikeType() && (keyType = type.getKeyType()) != null && (kd = ctxt.keyDeserializerInstance(member, kdDef = intr.findKeyDeserializer(member))) != null) {
            type = ((MapLikeType)type).withKeyValueHandler(kd);
            keyType = type.getKeyType();
        }
        if (type.hasContentType()) {
            TypeDeserializer contentTypeDeser;
            Object cdDef = intr.findContentDeserializer(member);
            JsonDeserializer<Object> cd = ctxt.deserializerInstance(member, cdDef);
            if (cd != null) {
                type = type.withContentValueHandler(cd);
            }
            if ((contentTypeDeser = this.findPropertyContentTypeDeserializer(ctxt.getConfig(), type, member)) != null) {
                type = type.withContentTypeHandler(contentTypeDeser);
            }
        }
        if ((valueTypeDeser = this.findPropertyTypeDeserializer(ctxt.getConfig(), type, member)) != null) {
            type = type.withTypeHandler(valueTypeDeser);
        }
        type = intr.refineDeserializationType(ctxt.getConfig(), member, type);
        return type;
    }

    protected EnumResolver constructEnumResolver(Class<?> enumClass, DeserializationConfig config, BeanDescription beanDesc) {
        AnnotatedMember jvAcc = beanDesc.findJsonValueAccessor();
        if (jvAcc != null) {
            if (config.canOverrideAccessModifiers()) {
                ClassUtil.checkAndFixAccess(jvAcc.getMember(), config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            }
            return EnumResolver.constructUsingMethod(config, beanDesc.getClassInfo(), jvAcc);
        }
        return EnumResolver.constructFor(config, beanDesc.getClassInfo());
    }

    protected EnumResolver constructEnumNamingStrategyResolver(DeserializationConfig config, AnnotatedClass annotatedClass) {
        Object namingDef = config.getAnnotationIntrospector().findEnumNamingStrategy(config, annotatedClass);
        EnumNamingStrategy enumNamingStrategy = EnumNamingStrategyFactory.createEnumNamingStrategyInstance(namingDef, config.canOverrideAccessModifiers());
        return enumNamingStrategy == null ? null : EnumResolver.constructUsingEnumNamingStrategy(config, annotatedClass, enumNamingStrategy);
    }

    @Deprecated
    protected EnumResolver constructEnumNamingStrategyResolver(DeserializationConfig config, Class<?> enumClass, AnnotatedClass annotatedClass) {
        Object namingDef = config.getAnnotationIntrospector().findEnumNamingStrategy(config, annotatedClass);
        EnumNamingStrategy enumNamingStrategy = EnumNamingStrategyFactory.createEnumNamingStrategyInstance(namingDef, config.canOverrideAccessModifiers());
        return enumNamingStrategy == null ? null : EnumResolver.constructUsingEnumNamingStrategy(config, enumClass, enumNamingStrategy);
    }

    protected boolean _hasCreatorAnnotation(MapperConfig<?> config, Annotated ann) {
        AnnotationIntrospector intr = config.getAnnotationIntrospector();
        if (intr != null) {
            JsonCreator.Mode mode = intr.findCreatorAnnotation(config, ann);
            return mode != null && mode != JsonCreator.Mode.DISABLED;
        }
        return false;
    }

    protected static class ContainerDefaultMappings {
        static final HashMap<String, Class<? extends Collection>> _collectionFallbacks;
        static final HashMap<String, Class<? extends Map>> _mapFallbacks;

        protected ContainerDefaultMappings() {
        }

        public static Class<?> findCollectionFallback(JavaType type) {
            return _collectionFallbacks.get(type.getRawClass().getName());
        }

        public static Class<?> findMapFallback(JavaType type) {
            return _mapFallbacks.get(type.getRawClass().getName());
        }

        static {
            HashMap<String, Class<LinkedHashMap>> fallbacks = new HashMap<String, Class<LinkedHashMap>>();
            Class<ArrayList> DEFAULT_LIST = ArrayList.class;
            Class<HashSet> DEFAULT_SET = HashSet.class;
            fallbacks.put(Collection.class.getName(), DEFAULT_LIST);
            fallbacks.put(List.class.getName(), DEFAULT_LIST);
            fallbacks.put(Set.class.getName(), DEFAULT_SET);
            fallbacks.put(SortedSet.class.getName(), TreeSet.class);
            fallbacks.put(Queue.class.getName(), LinkedList.class);
            fallbacks.put(AbstractList.class.getName(), DEFAULT_LIST);
            fallbacks.put(AbstractSet.class.getName(), DEFAULT_SET);
            fallbacks.put(Deque.class.getName(), LinkedList.class);
            fallbacks.put(NavigableSet.class.getName(), TreeSet.class);
            fallbacks.put("java.util.SequencedCollection", DEFAULT_LIST);
            fallbacks.put("java.util.SequencedSet", LinkedHashSet.class);
            _collectionFallbacks = fallbacks;
            fallbacks = new HashMap();
            Class<LinkedHashMap> DEFAULT_MAP = LinkedHashMap.class;
            fallbacks.put(Map.class.getName(), DEFAULT_MAP);
            fallbacks.put(AbstractMap.class.getName(), DEFAULT_MAP);
            fallbacks.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
            fallbacks.put(SortedMap.class.getName(), TreeMap.class);
            fallbacks.put(NavigableMap.class.getName(), TreeMap.class);
            fallbacks.put(ConcurrentNavigableMap.class.getName(), ConcurrentSkipListMap.class);
            fallbacks.put("java.util.SequencedMap", LinkedHashMap.class);
            _mapFallbacks = fallbacks;
        }
    }
}

