package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Map;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.ResolvableDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.deser.Creator;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.type.JavaType;

@JacksonStdImpl
public class MapDeserializer extends ContainerDeserializer<Map<Object, Object>> implements ResolvableDeserializer {
    protected final Constructor<Map<Object, Object>> _defaultCtor;
    protected HashSet<String> _ignorableProperties;
    protected final KeyDeserializer _keyDeserializer;
    protected final JavaType _mapType;
    protected Creator.PropertyBased _propertyBasedCreator;
    protected final JsonDeserializer<Object> _valueDeserializer;
    protected final TypeDeserializer _valueTypeDeserializer;

    public MapDeserializer(JavaType javaType, Constructor<Map<Object, Object>> constructor, KeyDeserializer keyDeserializer, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer) {
        super(Map.class);
        this._mapType = javaType;
        this._defaultCtor = constructor;
        this._keyDeserializer = keyDeserializer;
        this._valueDeserializer = jsonDeserializer;
        this._valueTypeDeserializer = typeDeserializer;
    }

    public void setCreators(CreatorContainer creatorContainer) {
        this._propertyBasedCreator = creatorContainer.propertyBasedCreator();
    }

    public void setIgnorableProperties(String[] strArr) {
        this._ignorableProperties = (strArr == null || strArr.length == 0) ? null : ArrayBuilders.arrayToSet(strArr);
    }

    public JavaType getContentType() {
        return this._mapType.getContentType();
    }

    public JsonDeserializer<Object> getContentDeserializer() {
        return this._valueDeserializer;
    }

    public void resolve(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider) throws JsonMappingException {
        Creator.PropertyBased propertyBased = this._propertyBasedCreator;
        if (propertyBased != null) {
            for (SettableBeanProperty next : propertyBased.properties()) {
                next.setValueDeserializer(findDeserializer(deserializationConfig, deserializerProvider, next.getType(), next));
            }
        }
    }

    public Map<Object, Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken != JsonToken.START_OBJECT && currentToken != JsonToken.FIELD_NAME && currentToken != JsonToken.END_OBJECT) {
            throw deserializationContext.mappingException(getMapClass());
        } else if (this._propertyBasedCreator != null) {
            return _deserializeUsingCreator(jsonParser, deserializationContext);
        } else {
            Constructor<Map<Object, Object>> constructor = this._defaultCtor;
            if (constructor != null) {
                try {
                    Map<Object, Object> newInstance = constructor.newInstance(new Object[0]);
                    _readAndBind(jsonParser, deserializationContext, newInstance);
                    return newInstance;
                } catch (Exception e) {
                    throw deserializationContext.instantiationException(getMapClass(), (Throwable) e);
                }
            } else {
                throw deserializationContext.instantiationException(getMapClass(), "No default constructor found");
            }
        }
    }

    public Map<Object, Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException, JsonProcessingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.START_OBJECT || currentToken == JsonToken.FIELD_NAME) {
            _readAndBind(jsonParser, deserializationContext, map);
            return map;
        }
        throw deserializationContext.mappingException(getMapClass());
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
        return typeDeserializer.deserializeTypedFromObject(jsonParser, deserializationContext);
    }

    public final Class<?> getMapClass() {
        return this._mapType.getRawClass();
    }

    public JavaType getValueType() {
        return this._mapType;
    }

    /* access modifiers changed from: protected */
    public final void _readAndBind(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException, JsonProcessingException {
        Object obj;
        Object obj2;
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.START_OBJECT) {
            currentToken = jsonParser.nextToken();
        }
        KeyDeserializer keyDeserializer = this._keyDeserializer;
        JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        while (currentToken == JsonToken.FIELD_NAME) {
            String currentName = jsonParser.getCurrentName();
            if (keyDeserializer == null) {
                obj = currentName;
            } else {
                obj = keyDeserializer.deserializeKey(currentName, deserializationContext);
            }
            JsonToken nextToken = jsonParser.nextToken();
            HashSet<String> hashSet = this._ignorableProperties;
            if (hashSet == null || !hashSet.contains(currentName)) {
                if (nextToken == JsonToken.VALUE_NULL) {
                    obj2 = null;
                } else if (typeDeserializer == null) {
                    obj2 = jsonDeserializer.deserialize(jsonParser, deserializationContext);
                } else {
                    obj2 = jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
                }
                map.put(obj, obj2);
            } else {
                jsonParser.skipChildren();
            }
            currentToken = jsonParser.nextToken();
        }
    }

    public Map<Object, Object> _deserializeUsingCreator(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Creator.PropertyBased propertyBased = this._propertyBasedCreator;
        PropertyValueBuffer startBuilding = propertyBased.startBuilding(jsonParser, deserializationContext);
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.START_OBJECT) {
            currentToken = jsonParser.nextToken();
        }
        JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        while (true) {
            Object obj = null;
            if (currentToken == JsonToken.FIELD_NAME) {
                String currentName = jsonParser.getCurrentName();
                JsonToken nextToken = jsonParser.nextToken();
                HashSet<String> hashSet = this._ignorableProperties;
                if (hashSet == null || !hashSet.contains(currentName)) {
                    SettableBeanProperty findCreatorProperty = propertyBased.findCreatorProperty(currentName);
                    if (findCreatorProperty != null) {
                        if (startBuilding.assignParameter(findCreatorProperty.getCreatorIndex(), findCreatorProperty.deserialize(jsonParser, deserializationContext))) {
                            jsonParser.nextToken();
                            try {
                                Map<Object, Object> map = (Map) propertyBased.build(startBuilding);
                                _readAndBind(jsonParser, deserializationContext, map);
                                return map;
                            } catch (Exception e) {
                                wrapAndThrow(e, this._mapType.getRawClass());
                                return null;
                            }
                        }
                    } else {
                        String currentName2 = jsonParser.getCurrentName();
                        KeyDeserializer keyDeserializer = this._keyDeserializer;
                        Object obj2 = currentName2;
                        if (keyDeserializer != null) {
                            obj2 = keyDeserializer.deserializeKey(currentName2, deserializationContext);
                        }
                        if (nextToken != JsonToken.VALUE_NULL) {
                            if (typeDeserializer == null) {
                                obj = jsonDeserializer.deserialize(jsonParser, deserializationContext);
                            } else {
                                obj = jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
                            }
                        }
                        startBuilding.bufferMapProperty(obj2, obj);
                    }
                } else {
                    jsonParser.skipChildren();
                }
                currentToken = jsonParser.nextToken();
            } else {
                try {
                    return (Map) propertyBased.build(startBuilding);
                } catch (Exception e2) {
                    wrapAndThrow(e2, this._mapType.getRawClass());
                    return null;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void wrapAndThrow(Throwable th, Object obj) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        if (th instanceof Error) {
            throw ((Error) th);
        } else if (!(th instanceof IOException) || (th instanceof JsonMappingException)) {
            throw JsonMappingException.wrapWithPath(th, obj, (String) null);
        } else {
            throw ((IOException) th);
        }
    }
}
