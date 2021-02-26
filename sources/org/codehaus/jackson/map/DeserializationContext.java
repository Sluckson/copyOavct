package org.codehaus.jackson.map;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ObjectBuffer;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.type.JavaType;

public abstract class DeserializationContext {
    protected final DeserializationConfig _config;
    protected final int _featureFlags;

    public abstract Calendar constructCalendar(Date date);

    public abstract ArrayBuilders getArrayBuilders();

    public DeserializerProvider getDeserializerProvider() {
        return null;
    }

    public abstract JsonParser getParser();

    public abstract boolean handleUnknownProperty(JsonParser jsonParser, JsonDeserializer<?> jsonDeserializer, Object obj, String str) throws IOException, JsonProcessingException;

    public abstract JsonMappingException instantiationException(Class<?> cls, String str);

    public abstract JsonMappingException instantiationException(Class<?> cls, Throwable th);

    public abstract ObjectBuffer leaseObjectBuffer();

    public abstract JsonMappingException mappingException(Class<?> cls);

    public abstract Date parseDate(String str) throws IllegalArgumentException;

    public abstract void returnObjectBuffer(ObjectBuffer objectBuffer);

    public abstract JsonMappingException unknownFieldException(Object obj, String str);

    public abstract JsonMappingException unknownTypeException(JavaType javaType, String str);

    public abstract JsonMappingException weirdKeyException(Class<?> cls, String str, String str2);

    public abstract JsonMappingException weirdNumberException(Class<?> cls, String str);

    public abstract JsonMappingException weirdStringException(Class<?> cls, String str);

    public abstract JsonMappingException wrongTokenException(JsonParser jsonParser, JsonToken jsonToken, String str);

    protected DeserializationContext(DeserializationConfig deserializationConfig) {
        this._config = deserializationConfig;
        this._featureFlags = deserializationConfig._featureFlags;
    }

    public DeserializationConfig getConfig() {
        return this._config;
    }

    public boolean isEnabled(DeserializationConfig.Feature feature) {
        return (feature.getMask() & this._featureFlags) != 0;
    }

    public Base64Variant getBase64Variant() {
        return this._config.getBase64Variant();
    }

    public final JsonNodeFactory getNodeFactory() {
        return this._config.getNodeFactory();
    }

    public JavaType constructType(Class<?> cls) {
        return this._config.constructType(cls);
    }

    public JsonMappingException mappingException(String str) {
        return JsonMappingException.from(getParser(), str);
    }
}
