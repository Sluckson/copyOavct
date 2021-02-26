package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ResolvableDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JsonCachable;
import org.codehaus.jackson.map.deser.Creator;
import org.codehaus.jackson.map.deser.SettableBeanProperty;
import org.codehaus.jackson.map.deser.impl.BeanPropertyMap;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.util.TokenBuffer;

@JsonCachable
public class BeanDeserializer extends StdDeserializer<Object> implements ResolvableDeserializer {
    protected final SettableAnyProperty _anySetter;
    protected final Map<String, SettableBeanProperty> _backRefs;
    protected final BeanPropertyMap _beanProperties;
    protected final JavaType _beanType;
    protected final Constructor<?> _defaultConstructor;
    protected final Creator.Delegating _delegatingCreator;
    protected final AnnotatedClass _forClass;
    protected final HashSet<String> _ignorableProps;
    protected final boolean _ignoreAllUnknown;
    protected final Creator.NumberBased _numberCreator;
    protected final BeanProperty _property;
    protected final Creator.PropertyBased _propertyBasedCreator;
    protected final Creator.StringBased _stringCreator;
    protected HashMap<ClassKey, JsonDeserializer<Object>> _subDeserializers;

    public BeanDeserializer(AnnotatedClass annotatedClass, JavaType javaType, BeanProperty beanProperty, CreatorContainer creatorContainer, BeanPropertyMap beanPropertyMap, Map<String, SettableBeanProperty> map, HashSet<String> hashSet, boolean z, SettableAnyProperty settableAnyProperty) {
        super(javaType);
        this._forClass = annotatedClass;
        this._beanType = javaType;
        this._property = beanProperty;
        this._beanProperties = beanPropertyMap;
        this._backRefs = map;
        this._ignorableProps = hashSet;
        this._ignoreAllUnknown = z;
        this._anySetter = settableAnyProperty;
        this._stringCreator = creatorContainer.stringCreator();
        this._numberCreator = creatorContainer.numberCreator();
        this._delegatingCreator = creatorContainer.delegatingCreator();
        this._propertyBasedCreator = creatorContainer.propertyBasedCreator();
        if (this._delegatingCreator == null && this._propertyBasedCreator == null) {
            this._defaultConstructor = creatorContainer.getDefaultConstructor();
        } else {
            this._defaultConstructor = null;
        }
    }

    protected BeanDeserializer(BeanDeserializer beanDeserializer) {
        super(beanDeserializer._beanType);
        this._forClass = beanDeserializer._forClass;
        this._beanType = beanDeserializer._beanType;
        this._property = beanDeserializer._property;
        this._beanProperties = beanDeserializer._beanProperties;
        this._backRefs = beanDeserializer._backRefs;
        this._ignorableProps = beanDeserializer._ignorableProps;
        this._ignoreAllUnknown = beanDeserializer._ignoreAllUnknown;
        this._anySetter = beanDeserializer._anySetter;
        this._defaultConstructor = beanDeserializer._defaultConstructor;
        this._stringCreator = beanDeserializer._stringCreator;
        this._numberCreator = beanDeserializer._numberCreator;
        this._delegatingCreator = beanDeserializer._delegatingCreator;
        this._propertyBasedCreator = beanDeserializer._propertyBasedCreator;
    }

    public boolean hasProperty(String str) {
        return this._beanProperties.find(str) != null;
    }

    public int getPropertyCount() {
        return this._beanProperties.size();
    }

    public void resolve(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider) throws JsonMappingException {
        SettableBeanProperty settableBeanProperty;
        boolean z;
        Iterator<SettableBeanProperty> allProperties = this._beanProperties.allProperties();
        while (allProperties.hasNext()) {
            SettableBeanProperty next = allProperties.next();
            if (!next.hasValueDeserializer()) {
                next.setValueDeserializer(findDeserializer(deserializationConfig, deserializerProvider, next.getType(), next));
            }
            String managedReferenceName = next.getManagedReferenceName();
            if (managedReferenceName != null) {
                JsonDeserializer<Object> jsonDeserializer = next._valueDeserializer;
                if (jsonDeserializer instanceof BeanDeserializer) {
                    settableBeanProperty = ((BeanDeserializer) jsonDeserializer).findBackReference(managedReferenceName);
                    z = false;
                } else if (jsonDeserializer instanceof ContainerDeserializer) {
                    JsonDeserializer<Object> contentDeserializer = ((ContainerDeserializer) jsonDeserializer).getContentDeserializer();
                    if (contentDeserializer instanceof BeanDeserializer) {
                        settableBeanProperty = ((BeanDeserializer) contentDeserializer).findBackReference(managedReferenceName);
                        z = true;
                    } else {
                        throw new IllegalArgumentException("Can not handle managed/back reference '" + managedReferenceName + "': value deserializer is of type ContainerDeserializer, but content type is not handled by a BeanDeserializer " + " (instead it's of type " + contentDeserializer.getClass().getName() + ")");
                    }
                } else if (jsonDeserializer instanceof AbstractDeserializer) {
                    throw new IllegalArgumentException("Can not handle managed/back reference for abstract types (property " + this._beanType.getRawClass().getName() + "." + next.getName() + ")");
                } else {
                    throw new IllegalArgumentException("Can not handle managed/back reference '" + managedReferenceName + "': type for value deserializer is not BeanDeserializer or ContainerDeserializer, but " + jsonDeserializer.getClass().getName());
                }
                if (settableBeanProperty != null) {
                    JavaType javaType = this._beanType;
                    JavaType type = settableBeanProperty.getType();
                    if (type.getRawClass().isAssignableFrom(javaType.getRawClass())) {
                        this._beanProperties.replace(new SettableBeanProperty.ManagedReferenceProperty(managedReferenceName, next, settableBeanProperty, this._forClass.getAnnotations(), z));
                    } else {
                        throw new IllegalArgumentException("Can not handle managed/back reference '" + managedReferenceName + "': back reference type (" + type.getRawClass().getName() + ") not compatible with managed type (" + javaType.getRawClass().getName() + ")");
                    }
                } else {
                    throw new IllegalArgumentException("Can not handle managed/back reference '" + managedReferenceName + "': no back reference property found from type " + next.getType());
                }
            }
        }
        SettableAnyProperty settableAnyProperty = this._anySetter;
        if (settableAnyProperty != null && !settableAnyProperty.hasValueDeserializer()) {
            SettableAnyProperty settableAnyProperty2 = this._anySetter;
            settableAnyProperty2.setValueDeserializer(findDeserializer(deserializationConfig, deserializerProvider, settableAnyProperty2.getType(), this._anySetter.getProperty()));
        }
        Creator.Delegating delegating = this._delegatingCreator;
        if (delegating != null) {
            this._delegatingCreator.setDeserializer(findDeserializer(deserializationConfig, deserializerProvider, this._delegatingCreator.getValueType(), new BeanProperty.Std((String) null, delegating.getValueType(), this._forClass.getAnnotations(), this._delegatingCreator.getCreator())));
        }
        Creator.PropertyBased propertyBased = this._propertyBasedCreator;
        if (propertyBased != null) {
            for (SettableBeanProperty next2 : propertyBased.properties()) {
                if (!next2.hasValueDeserializer()) {
                    next2.setValueDeserializer(findDeserializer(deserializationConfig, deserializerProvider, next2.getType(), next2));
                }
            }
        }
    }

    public final Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.START_OBJECT) {
            jsonParser.nextToken();
            return deserializeFromObject(jsonParser, deserializationContext);
        }
        switch (currentToken) {
            case VALUE_STRING:
                return deserializeFromString(jsonParser, deserializationContext);
            case VALUE_NUMBER_INT:
            case VALUE_NUMBER_FLOAT:
                return deserializeFromNumber(jsonParser, deserializationContext);
            case VALUE_EMBEDDED_OBJECT:
                return jsonParser.getEmbeddedObject();
            case VALUE_TRUE:
            case VALUE_FALSE:
            case START_ARRAY:
                return deserializeUsingCreator(jsonParser, deserializationContext);
            case FIELD_NAME:
            case END_OBJECT:
                return deserializeFromObject(jsonParser, deserializationContext);
            default:
                throw deserializationContext.mappingException(getBeanClass());
        }
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException, JsonProcessingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.START_OBJECT) {
            currentToken = jsonParser.nextToken();
        }
        while (currentToken == JsonToken.FIELD_NAME) {
            String currentName = jsonParser.getCurrentName();
            SettableBeanProperty find = this._beanProperties.find(currentName);
            jsonParser.nextToken();
            if (find != null) {
                try {
                    find.deserializeAndSet(jsonParser, deserializationContext, obj);
                } catch (Exception e) {
                    wrapAndThrow((Throwable) e, obj, currentName, deserializationContext);
                }
            } else {
                HashSet<String> hashSet = this._ignorableProps;
                if (hashSet == null || !hashSet.contains(currentName)) {
                    SettableAnyProperty settableAnyProperty = this._anySetter;
                    if (settableAnyProperty != null) {
                        settableAnyProperty.deserializeAndSet(jsonParser, deserializationContext, obj, currentName);
                    } else {
                        handleUnknownProperty(jsonParser, deserializationContext, obj, currentName);
                    }
                } else {
                    jsonParser.skipChildren();
                }
            }
            currentToken = jsonParser.nextToken();
        }
        return obj;
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
        return typeDeserializer.deserializeTypedFromObject(jsonParser, deserializationContext);
    }

    public final Class<?> getBeanClass() {
        return this._beanType.getRawClass();
    }

    public JavaType getValueType() {
        return this._beanType;
    }

    public Iterator<SettableBeanProperty> properties() {
        BeanPropertyMap beanPropertyMap = this._beanProperties;
        if (beanPropertyMap != null) {
            return beanPropertyMap.allProperties();
        }
        throw new IllegalStateException("Can only call before BeanDeserializer has been resolved");
    }

    public SettableBeanProperty findBackReference(String str) {
        Map<String, SettableBeanProperty> map = this._backRefs;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public Object deserializeFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (this._defaultConstructor != null) {
            Object constructDefaultInstance = constructDefaultInstance();
            while (jsonParser.getCurrentToken() != JsonToken.END_OBJECT) {
                String currentName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                SettableBeanProperty find = this._beanProperties.find(currentName);
                if (find != null) {
                    try {
                        find.deserializeAndSet(jsonParser, deserializationContext, constructDefaultInstance);
                    } catch (Exception e) {
                        wrapAndThrow((Throwable) e, constructDefaultInstance, currentName, deserializationContext);
                    }
                } else {
                    HashSet<String> hashSet = this._ignorableProps;
                    if (hashSet == null || !hashSet.contains(currentName)) {
                        SettableAnyProperty settableAnyProperty = this._anySetter;
                        if (settableAnyProperty != null) {
                            try {
                                settableAnyProperty.deserializeAndSet(jsonParser, deserializationContext, constructDefaultInstance, currentName);
                            } catch (Exception e2) {
                                wrapAndThrow((Throwable) e2, constructDefaultInstance, currentName, deserializationContext);
                            }
                        } else {
                            handleUnknownProperty(jsonParser, deserializationContext, constructDefaultInstance, currentName);
                        }
                    } else {
                        jsonParser.skipChildren();
                    }
                }
                jsonParser.nextToken();
            }
            return constructDefaultInstance;
        } else if (this._propertyBasedCreator != null) {
            return _deserializeUsingPropertyBased(jsonParser, deserializationContext);
        } else {
            Creator.Delegating delegating = this._delegatingCreator;
            if (delegating != null) {
                return delegating.deserialize(jsonParser, deserializationContext);
            }
            if (this._beanType.isAbstract()) {
                throw JsonMappingException.from(jsonParser, "Can not instantiate abstract type " + this._beanType + " (need to add/enable type information?)");
            }
            throw JsonMappingException.from(jsonParser, "No suitable constructor found for type " + this._beanType + ": can not instantiate from JSON object (need to add/enable type information?)");
        }
    }

    public Object deserializeFromString(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Creator.StringBased stringBased = this._stringCreator;
        if (stringBased != null) {
            return stringBased.construct(jsonParser.getText());
        }
        Creator.Delegating delegating = this._delegatingCreator;
        if (delegating != null) {
            return delegating.deserialize(jsonParser, deserializationContext);
        }
        if (deserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.getTextLength() == 0) {
            return null;
        }
        throw deserializationContext.instantiationException(getBeanClass(), "no suitable creator method found to deserialize from JSON String");
    }

    /* renamed from: org.codehaus.jackson.map.deser.BeanDeserializer$1 */
    static /* synthetic */ class C49151 {
        static final /* synthetic */ int[] $SwitchMap$org$codehaus$jackson$JsonParser$NumberType = new int[JsonParser.NumberType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0068 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0073 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x007f */
        static {
            /*
                org.codehaus.jackson.JsonParser$NumberType[] r0 = org.codehaus.jackson.JsonParser.NumberType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$codehaus$jackson$JsonParser$NumberType = r0
                r0 = 1
                int[] r1 = $SwitchMap$org$codehaus$jackson$JsonParser$NumberType     // Catch:{ NoSuchFieldError -> 0x0014 }
                org.codehaus.jackson.JsonParser$NumberType r2 = org.codehaus.jackson.JsonParser.NumberType.INT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = $SwitchMap$org$codehaus$jackson$JsonParser$NumberType     // Catch:{ NoSuchFieldError -> 0x001f }
                org.codehaus.jackson.JsonParser$NumberType r3 = org.codehaus.jackson.JsonParser.NumberType.LONG     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                org.codehaus.jackson.JsonToken[] r2 = org.codehaus.jackson.JsonToken.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$org$codehaus$jackson$JsonToken = r2
                int[] r2 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0032 }
                org.codehaus.jackson.JsonToken r3 = org.codehaus.jackson.JsonToken.VALUE_STRING     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x003c }
                org.codehaus.jackson.JsonToken r2 = org.codehaus.jackson.JsonToken.VALUE_NUMBER_INT     // Catch:{ NoSuchFieldError -> 0x003c }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0047 }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.VALUE_NUMBER_FLOAT     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0052 }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.VALUE_EMBEDDED_OBJECT     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x005d }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.VALUE_TRUE     // Catch:{ NoSuchFieldError -> 0x005d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0068 }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.VALUE_FALSE     // Catch:{ NoSuchFieldError -> 0x0068 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0068 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0068 }
            L_0x0068:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0073 }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.START_ARRAY     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x007f }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.FIELD_NAME     // Catch:{ NoSuchFieldError -> 0x007f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x008b }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.END_OBJECT     // Catch:{ NoSuchFieldError -> 0x008b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008b }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008b }
            L_0x008b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.deser.BeanDeserializer.C49151.<clinit>():void");
        }
    }

    public Object deserializeFromNumber(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (this._numberCreator != null) {
            int i = C49151.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[jsonParser.getNumberType().ordinal()];
            if (i == 1) {
                return this._numberCreator.construct(jsonParser.getIntValue());
            }
            if (i == 2) {
                return this._numberCreator.construct(jsonParser.getLongValue());
            }
        }
        Creator.Delegating delegating = this._delegatingCreator;
        if (delegating != null) {
            return delegating.deserialize(jsonParser, deserializationContext);
        }
        throw deserializationContext.instantiationException(getBeanClass(), "no suitable creator method found to deserialize from JSON Number");
    }

    public Object deserializeUsingCreator(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Creator.Delegating delegating = this._delegatingCreator;
        if (delegating != null) {
            try {
                return delegating.deserialize(jsonParser, deserializationContext);
            } catch (Exception e) {
                wrapInstantiationProblem(e, deserializationContext);
            }
        }
        throw deserializationContext.mappingException(getBeanClass());
    }

    /* access modifiers changed from: protected */
    public final Object _deserializeUsingPropertyBased(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Creator.PropertyBased propertyBased = this._propertyBasedCreator;
        PropertyValueBuffer startBuilding = propertyBased.startBuilding(jsonParser, deserializationContext);
        JsonToken currentToken = jsonParser.getCurrentToken();
        TokenBuffer tokenBuffer = null;
        while (currentToken == JsonToken.FIELD_NAME) {
            String currentName = jsonParser.getCurrentName();
            jsonParser.nextToken();
            SettableBeanProperty findCreatorProperty = propertyBased.findCreatorProperty(currentName);
            if (findCreatorProperty != null) {
                if (startBuilding.assignParameter(findCreatorProperty.getCreatorIndex(), findCreatorProperty.deserialize(jsonParser, deserializationContext))) {
                    jsonParser.nextToken();
                    try {
                        Object build = propertyBased.build(startBuilding);
                        if (build.getClass() != this._beanType.getRawClass()) {
                            return handlePolymorphic(jsonParser, deserializationContext, build, tokenBuffer);
                        }
                        if (tokenBuffer != null) {
                            build = handleUnknownProperties(deserializationContext, build, tokenBuffer);
                        }
                        return deserialize(jsonParser, deserializationContext, build);
                    } catch (Exception e) {
                        wrapAndThrow((Throwable) e, (Object) this._beanType.getRawClass(), currentName, deserializationContext);
                    }
                } else {
                    continue;
                }
            } else {
                SettableBeanProperty find = this._beanProperties.find(currentName);
                if (find != null) {
                    startBuilding.bufferProperty(find, find.deserialize(jsonParser, deserializationContext));
                } else {
                    HashSet<String> hashSet = this._ignorableProps;
                    if (hashSet == null || !hashSet.contains(currentName)) {
                        SettableAnyProperty settableAnyProperty = this._anySetter;
                        if (settableAnyProperty != null) {
                            startBuilding.bufferAnyProperty(settableAnyProperty, currentName, settableAnyProperty.deserialize(jsonParser, deserializationContext));
                        } else {
                            if (tokenBuffer == null) {
                                tokenBuffer = new TokenBuffer(jsonParser.getCodec());
                            }
                            tokenBuffer.writeFieldName(currentName);
                            tokenBuffer.copyCurrentStructure(jsonParser);
                        }
                    } else {
                        jsonParser.skipChildren();
                    }
                }
            }
            currentToken = jsonParser.nextToken();
        }
        try {
            Object build2 = propertyBased.build(startBuilding);
            if (tokenBuffer == null) {
                return build2;
            }
            if (build2.getClass() != this._beanType.getRawClass()) {
                return handlePolymorphic((JsonParser) null, deserializationContext, build2, tokenBuffer);
            }
            return handleUnknownProperties(deserializationContext, build2, tokenBuffer);
        } catch (Exception e2) {
            wrapInstantiationProblem(e2, deserializationContext);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void handleUnknownProperty(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws IOException, JsonProcessingException {
        HashSet<String> hashSet;
        if (this._ignoreAllUnknown || ((hashSet = this._ignorableProps) != null && hashSet.contains(str))) {
            jsonParser.skipChildren();
        } else {
            super.handleUnknownProperty(jsonParser, deserializationContext, obj, str);
        }
    }

    /* access modifiers changed from: protected */
    public Object handleUnknownProperties(DeserializationContext deserializationContext, Object obj, TokenBuffer tokenBuffer) throws IOException, JsonProcessingException {
        tokenBuffer.writeEndObject();
        JsonParser asParser = tokenBuffer.asParser();
        while (asParser.nextToken() != JsonToken.END_OBJECT) {
            String currentName = asParser.getCurrentName();
            asParser.nextToken();
            handleUnknownProperty(asParser, deserializationContext, obj, currentName);
        }
        return obj;
    }

    /* access modifiers changed from: protected */
    public Object handlePolymorphic(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, TokenBuffer tokenBuffer) throws IOException, JsonProcessingException {
        JsonDeserializer<Object> _findSubclassDeserializer = _findSubclassDeserializer(deserializationContext, obj, tokenBuffer);
        if (_findSubclassDeserializer != null) {
            if (tokenBuffer != null) {
                tokenBuffer.writeEndObject();
                JsonParser asParser = tokenBuffer.asParser();
                asParser.nextToken();
                obj = _findSubclassDeserializer.deserialize(asParser, deserializationContext, obj);
            }
            return jsonParser != null ? _findSubclassDeserializer.deserialize(jsonParser, deserializationContext, obj) : obj;
        }
        if (tokenBuffer != null) {
            obj = handleUnknownProperties(deserializationContext, obj, tokenBuffer);
        }
        return jsonParser != null ? deserialize(jsonParser, deserializationContext, obj) : obj;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> _findSubclassDeserializer(DeserializationContext deserializationContext, Object obj, TokenBuffer tokenBuffer) throws IOException, JsonProcessingException {
        JsonDeserializer<Object> jsonDeserializer;
        synchronized (this) {
            jsonDeserializer = this._subDeserializers == null ? null : this._subDeserializers.get(new ClassKey(obj.getClass()));
        }
        if (jsonDeserializer != null) {
            return jsonDeserializer;
        }
        DeserializerProvider deserializerProvider = deserializationContext.getDeserializerProvider();
        if (!(deserializerProvider == null || (jsonDeserializer = deserializerProvider.findValueDeserializer(deserializationContext.getConfig(), deserializationContext.constructType(obj.getClass()), this._property)) == null)) {
            synchronized (this) {
                if (this._subDeserializers == null) {
                    this._subDeserializers = new HashMap<>();
                }
                this._subDeserializers.put(new ClassKey(obj.getClass()), jsonDeserializer);
            }
        }
        return jsonDeserializer;
    }

    /* access modifiers changed from: protected */
    public Object constructDefaultInstance() {
        try {
            return this._defaultConstructor.newInstance(new Object[0]);
        } catch (Exception e) {
            ClassUtil.unwrapAndThrowAsIAE(e);
            return null;
        }
    }

    public void wrapAndThrow(Throwable th, Object obj, String str, DeserializationContext deserializationContext) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        if (!(th instanceof Error)) {
            boolean z = deserializationContext == null || deserializationContext.isEnabled(DeserializationConfig.Feature.WRAP_EXCEPTIONS);
            if (th instanceof IOException) {
                if (!z || !(th instanceof JsonMappingException)) {
                    throw ((IOException) th);
                }
            } else if (!z && (th instanceof RuntimeException)) {
                throw ((RuntimeException) th);
            }
            throw JsonMappingException.wrapWithPath(th, obj, str);
        }
        throw ((Error) th);
    }

    public void wrapAndThrow(Throwable th, Object obj, int i, DeserializationContext deserializationContext) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        if (!(th instanceof Error)) {
            boolean z = deserializationContext == null || deserializationContext.isEnabled(DeserializationConfig.Feature.WRAP_EXCEPTIONS);
            if (th instanceof IOException) {
                if (!z || !(th instanceof JsonMappingException)) {
                    throw ((IOException) th);
                }
            } else if (!z && (th instanceof RuntimeException)) {
                throw ((RuntimeException) th);
            }
            throw JsonMappingException.wrapWithPath(th, obj, i);
        }
        throw ((Error) th);
    }

    /* access modifiers changed from: protected */
    public void wrapInstantiationProblem(Throwable th, DeserializationContext deserializationContext) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        if (!(th instanceof Error)) {
            boolean z = deserializationContext == null || deserializationContext.isEnabled(DeserializationConfig.Feature.WRAP_EXCEPTIONS);
            if (th instanceof IOException) {
                throw ((IOException) th);
            } else if (z || !(th instanceof RuntimeException)) {
                throw deserializationContext.instantiationException(this._beanType.getRawClass(), th);
            } else {
                throw ((RuntimeException) th);
            }
        } else {
            throw ((Error) th);
        }
    }

    @Deprecated
    public void wrapAndThrow(Throwable th, Object obj, String str) throws IOException {
        wrapAndThrow(th, obj, str, (DeserializationContext) null);
    }

    @Deprecated
    public void wrapAndThrow(Throwable th, Object obj, int i) throws IOException {
        wrapAndThrow(th, obj, i, (DeserializationContext) null);
    }
}
